package com.ss.bytertc.audio.device.webrtc;

import android.media.AudioRecord;
import android.os.Process;
import com.bytedance.realx.base.RXLogging;
import com.bytedance.realx.base.ThreadUtils;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: classes7.dex */
public class WebRtcAudioRecord {
    private static final long AUDIO_RECORD_THREAD_JOIN_TIMEOUT_MS = 2000;
    private static final int BITS_PER_SAMPLE = 16;
    private static final int BUFFERS_PER_SECOND = 100;
    private static final int BUFFER_SIZE_FACTOR = 2;
    private static final int CALLBACK_BUFFER_SIZE_MS = 10;
    private static final boolean DEBUG = false;
    private static final int DEFAULT_AUDIO_SOURCE;
    private static final int INVALID_AUDIO_SESSION_ID = -1;
    private static final int INVALID_AUDIO_SOURCE = -1;
    private static final String TAG = "WebRtcAudioRecord";
    private static WebRtcAudioRecordSamplesReadyCallback audioSamplesReadyCallback;
    private static int defaultMediaModeAudioSource;
    private static WebRtcAudioRecordErrorCallback errorCallback;
    private static volatile boolean microphoneMute;
    private String apiResult = "";
    private AudioRecord audioRecord;
    private AudioRecordThread audioThread;
    private ByteBuffer byteBuffer;
    private WebRtcAudioEffects effects;
    private byte[] emptyBytes;
    private final long nativeAudioRecord;

    /* loaded from: classes7.dex */
    public enum AudioRecordStartErrorCode {
        AUDIO_RECORD_START_EXCEPTION,
        AUDIO_RECORD_START_STATE_MISMATCH
    }

    /* loaded from: classes7.dex */
    public interface WebRtcAudioRecordErrorCallback {
        void onWebRtcAudioRecordError(String errorMessage);

        void onWebRtcAudioRecordInitError(String errorMessage);

        void onWebRtcAudioRecordStartError(AudioRecordStartErrorCode errorCode, String errorMessage);
    }

    /* loaded from: classes7.dex */
    public interface WebRtcAudioRecordSamplesReadyCallback {
        void onWebRtcAudioRecordSamplesReady(AudioSamples samples);
    }

    private int channelCountToConfiguration(int channels) {
        return channels == 1 ? 16 : 12;
    }

    private static int getDefaultAudioSource() {
        return 0;
    }

    private native void nativeCacheDirectBufferAddress(ByteBuffer byteBuffer, long nativeAudioRecord);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeDataIsRecorded(int bytes, long nativeAudioRecord);

    static {
        int defaultAudioSource = getDefaultAudioSource();
        DEFAULT_AUDIO_SOURCE = defaultAudioSource;
        defaultMediaModeAudioSource = defaultAudioSource;
    }

    /* loaded from: classes7.dex */
    private static class AudioRecordErrorCode {
        public static final int AUDIO_RECORD_INIT_CREATE_FAIL = -402;
        public static final int AUDIO_RECORD_INIT_CREATE_INVALID_STATE = -403;
        public static final int AUDIO_RECORD_INIT_ILLEGAL_ARGUMENTS = -401;
        public static final int AUDIO_RECORD_INIT_IS_NOT_NULL = -400;
        public static final int AUDIO_RECORD_START_ILLEGAL_STATE = -302;
        public static final int AUDIO_RECORD_START_INVALID_STATE = -303;
        public static final int AUDIO_RECORD_START_IS_NULL = -300;
        public static final int AUDIO_RECORD_START_THREAD_NOT_NULL = -301;
        public static final int AUDIO_RECORD_SUCCESS = 0;

        private AudioRecordErrorCode() {
        }
    }

    public static void setErrorCallback(WebRtcAudioRecordErrorCallback errorCallback2) {
        RXLogging.i(TAG, "Set error callback");
        errorCallback = errorCallback2;
    }

    /* loaded from: classes7.dex */
    public static class AudioSamples {
        private final int audioFormat;
        private final int channelCount;
        private final byte[] data;
        private final int sampleRate;

        private AudioSamples(AudioRecord audioRecord, byte[] data) {
            this.audioFormat = audioRecord.getAudioFormat();
            this.channelCount = audioRecord.getChannelCount();
            this.sampleRate = audioRecord.getSampleRate();
            this.data = data;
        }

        public int getAudioFormat() {
            return this.audioFormat;
        }

        public int getChannelCount() {
            return this.channelCount;
        }

        public int getSampleRate() {
            return this.sampleRate;
        }

        public byte[] getData() {
            return this.data;
        }
    }

    public static void setOnAudioSamplesReady(WebRtcAudioRecordSamplesReadyCallback callback) {
        audioSamplesReadyCallback = callback;
    }

    /* loaded from: classes7.dex */
    private class AudioRecordThread extends Thread {
        private volatile boolean keepAlive;

        public AudioRecordThread(String name) {
            super(name);
            this.keepAlive = true;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            int i;
            Process.setThreadPriority(-19);
            RXLogging.i(WebRtcAudioRecord.TAG, "AudioRecordThread" + WebRtcAudioUtils.getThreadInfo());
            if (WebRtcAudioRecord.this.audioRecord == null || WebRtcAudioRecord.this.audioRecord.getRecordingState() != 3) {
                String str = "AudioRecord.run failed: incorrect state :" + (WebRtcAudioRecord.this.audioRecord == null ? "null" : Integer.valueOf(WebRtcAudioRecord.this.audioRecord.getRecordingState()));
                RXLogging.e(WebRtcAudioRecord.TAG, str);
                this.keepAlive = false;
                WebRtcAudioRecord.this.reportWebRtcAudioRecordError(str);
            }
            System.nanoTime();
            while (this.keepAlive) {
                try {
                    i = WebRtcAudioRecord.this.audioRecord.read(WebRtcAudioRecord.this.byteBuffer, WebRtcAudioRecord.this.byteBuffer.capacity());
                } catch (Exception e) {
                    RXLogging.e(WebRtcAudioRecord.TAG, "audioRecord.read failed: " + e.getMessage());
                    this.keepAlive = false;
                    i = -1;
                }
                if (i == WebRtcAudioRecord.this.byteBuffer.capacity()) {
                    if (WebRtcAudioRecord.microphoneMute) {
                        WebRtcAudioRecord.this.byteBuffer.clear();
                        WebRtcAudioRecord.this.byteBuffer.put(WebRtcAudioRecord.this.emptyBytes);
                    }
                    synchronized (this) {
                        if (this.keepAlive) {
                            WebRtcAudioRecord webRtcAudioRecord = WebRtcAudioRecord.this;
                            webRtcAudioRecord.nativeDataIsRecorded(i, webRtcAudioRecord.nativeAudioRecord);
                        }
                    }
                    if (WebRtcAudioRecord.audioSamplesReadyCallback != null) {
                        WebRtcAudioRecord.audioSamplesReadyCallback.onWebRtcAudioRecordSamplesReady(new AudioSamples(WebRtcAudioRecord.this.audioRecord, Arrays.copyOf(WebRtcAudioRecord.this.byteBuffer.array(), WebRtcAudioRecord.this.byteBuffer.capacity())));
                    }
                } else if (i == -3 || i == -6) {
                    this.keepAlive = false;
                    String str2 = "AudioRecord.read failed: " + i;
                    RXLogging.e(WebRtcAudioRecord.TAG, str2);
                    WebRtcAudioRecord.this.reportWebRtcAudioRecordError(str2);
                }
            }
            try {
                if (WebRtcAudioRecord.this.audioRecord != null) {
                    WebRtcAudioRecord.this.audioRecord.stop();
                }
            } catch (Exception e2) {
                RXLogging.e(WebRtcAudioRecord.TAG, "AudioRecord.stop failed: " + e2.getMessage());
            }
        }

        public void stopThread() {
            synchronized (this) {
                RXLogging.i(WebRtcAudioRecord.TAG, "stopThread");
                this.keepAlive = false;
            }
        }
    }

    WebRtcAudioRecord(long nativeAudioRecord) {
        RXLogging.i(TAG, "ctor" + WebRtcAudioUtils.getThreadInfo());
        this.nativeAudioRecord = nativeAudioRecord;
        if (WebRtcAudioEffects.IsAudioEffectSupported()) {
            this.effects = WebRtcAudioEffects.create();
        }
    }

    private boolean enableBuiltInAEC(boolean enable) {
        RXLogging.i(TAG, "enableBuiltInAEC(" + enable + ')');
        WebRtcAudioEffects webRtcAudioEffects = this.effects;
        if (webRtcAudioEffects == null) {
            RXLogging.e(TAG, "Built-in AEC is not supported on this platform");
            return false;
        }
        return webRtcAudioEffects.setAEC(enable);
    }

    private boolean enableBuiltInNS(boolean enable) {
        RXLogging.i(TAG, "enableBuiltInNS(" + enable + ')');
        WebRtcAudioEffects webRtcAudioEffects = this.effects;
        if (webRtcAudioEffects == null) {
            RXLogging.e(TAG, "Built-in NS is not supported on this platform");
            return false;
        }
        return webRtcAudioEffects.setNS(enable);
    }

    private int initRecording(int sampleRate, int channels, int frameSizeMs, boolean forbidVoip, int audioSourceFromNative) {
        AudioRecord audioRecord;
        String str = "InitRecording(sampleRate=" + sampleRate + ", channels=" + channels + ", frameSizeMs=" + frameSizeMs + ", forbidVoip=" + forbidVoip + ", preferredSource=" + audioSourceFromNative + "):";
        this.apiResult = str;
        RXLogging.w(TAG, str);
        if (this.audioRecord != null) {
            reportWebRtcAudioRecordInitError("InitRecording called twice without StopRecording.");
            return -400;
        }
        int i = channels * 2;
        int i2 = sampleRate / 100;
        if (frameSizeMs > 0 && frameSizeMs % 10 == 0) {
            i2 = (frameSizeMs * sampleRate) / 1000;
        }
        this.byteBuffer = ByteBuffer.allocateDirect(i * i2);
        RXLogging.i(TAG, "byteBuffer.capacity: " + this.byteBuffer.capacity());
        this.emptyBytes = new byte[this.byteBuffer.capacity()];
        nativeCacheDirectBufferAddress(this.byteBuffer, this.nativeAudioRecord);
        int channelCountToConfiguration = channelCountToConfiguration(channels);
        int minBufferSize = AudioRecord.getMinBufferSize(sampleRate, channelCountToConfiguration, 2);
        if (minBufferSize == -1 || minBufferSize == -2) {
            reportWebRtcAudioRecordInitError("AudioRecord.getMinBufferSize failed: " + minBufferSize);
            this.apiResult += "AudioRecord.getMinBufferSize failed: " + minBufferSize;
            return minBufferSize;
        }
        RXLogging.i(TAG, "AudioRecord.getMinBufferSize: " + minBufferSize);
        int max = Math.max(minBufferSize, this.byteBuffer.capacity() * 2);
        RXLogging.i(TAG, "bufferSizeInBytes: " + max);
        try {
            synchronized (this) {
                int cvtNativeSetAudioSource = cvtNativeSetAudioSource(audioSourceFromNative, forbidVoip);
                this.apiResult += ",AudioSource:" + cvtNativeSetAudioSource + ",MinBufferSize:" + minBufferSize + ",byteBuffer.capcity:" + this.byteBuffer.capacity() + ", bufferSizeInBytes:" + max;
                audioRecord = this.audioRecord;
                if (audioRecord == null) {
                    audioRecord = new AudioRecord(cvtNativeSetAudioSource, sampleRate, channelCountToConfiguration, 2, max);
                }
                this.audioRecord = audioRecord;
            }
            if (audioRecord == null || audioRecord.getState() != 1) {
                reportWebRtcAudioRecordInitError("Failed to create a new AudioRecord instance");
                releaseAudioResources();
                StringBuilder append = new StringBuilder().append(this.apiResult).append("Failed to create a new AudioRecord instance state:");
                AudioRecord audioRecord2 = this.audioRecord;
                this.apiResult = append.append(audioRecord2 == null ? "null" : Integer.valueOf(audioRecord2.getState())).toString();
                return this.audioRecord == null ? -402 : -403;
            }
            WebRtcAudioEffects webRtcAudioEffects = this.effects;
            if (webRtcAudioEffects != null) {
                webRtcAudioEffects.enable(this.audioRecord.getAudioSessionId());
            }
            logMainParameters();
            logMainParametersExtended();
            return i2;
        } catch (IllegalArgumentException e) {
            reportWebRtcAudioRecordInitError("AudioRecord ctor error: " + e.getMessage());
            releaseAudioResources();
            this.apiResult += "AudioRecord ctor error: " + e.getMessage();
            return -401;
        }
    }

    private int startRecording() {
        this.apiResult = "StartRecording:";
        RXLogging.i(TAG, "StartRecording:");
        AudioRecord audioRecord = this.audioRecord;
        if (audioRecord == null) {
            RXLogging.e(TAG, "null audio record object");
            return -300;
        }
        if (this.audioThread != null) {
            RXLogging.e(TAG, "the previous audio thread leak");
            return -301;
        }
        try {
            audioRecord.startRecording();
            if (this.audioRecord.getRecordingState() != 3) {
                reportWebRtcAudioRecordStartError(AudioRecordStartErrorCode.AUDIO_RECORD_START_STATE_MISMATCH, "AudioRecord.startRecording failed - incorrect state :" + this.audioRecord.getRecordingState());
                this.apiResult += "AudioRecord.startRecording failed - incorrect state :" + this.audioRecord.getRecordingState();
                WebRtcAudioEffects webRtcAudioEffects = this.effects;
                if (webRtcAudioEffects != null) {
                    webRtcAudioEffects.release();
                }
                releaseAudioResources();
                return -303;
            }
            AudioRecordThread audioRecordThread = new AudioRecordThread("BaeRecordJavaThread");
            this.audioThread = audioRecordThread;
            audioRecordThread.start();
            return 0;
        } catch (IllegalStateException e) {
            reportWebRtcAudioRecordStartError(AudioRecordStartErrorCode.AUDIO_RECORD_START_EXCEPTION, "AudioRecord.startRecording failed: " + e.getMessage());
            this.apiResult += "AudioRecord.startRecording failed: " + e.getMessage();
            releaseAudioResources();
            return -302;
        }
    }

    private boolean stopRecording() {
        this.apiResult = "StopRecording:";
        RXLogging.i(TAG, "StopRecording:");
        AudioRecordThread audioRecordThread = this.audioThread;
        if (audioRecordThread != null) {
            audioRecordThread.stopThread();
            if (!ThreadUtils.joinUninterruptibly(this.audioThread, 2000L)) {
                RXLogging.e(TAG, "Join of AudioRecordJavaThread timed out");
                WebRtcAudioUtils.logAudioState(TAG);
                this.apiResult += "Join of AudioRecordJavaThread timed out";
            }
            this.audioThread = null;
        }
        WebRtcAudioEffects webRtcAudioEffects = this.effects;
        if (webRtcAudioEffects != null) {
            webRtcAudioEffects.release();
        }
        releaseAudioResources();
        RXLogging.i(TAG, "stopRecording release done.");
        return true;
    }

    private String getApiResult() {
        return this.apiResult;
    }

    private int getAudioSource() {
        AudioRecord audioRecord = this.audioRecord;
        if (audioRecord == null) {
            return -1;
        }
        return audioRecord.getAudioSource();
    }

    private int getAudioSessionId() {
        AudioRecord audioRecord = this.audioRecord;
        if (audioRecord == null) {
            return -1;
        }
        return audioRecord.getAudioSessionId();
    }

    private void logMainParameters() {
        RXLogging.w(TAG, "AudioRecord: session ID: " + this.audioRecord.getAudioSessionId() + ", channels: " + this.audioRecord.getChannelCount() + ", sample rate: " + this.audioRecord.getSampleRate() + ", source:" + this.audioRecord.getAudioSource());
    }

    private void logMainParametersExtended() {
        RXLogging.w(TAG, "AudioRecord: buffer size in frames: " + this.audioRecord.getBufferSizeInFrames());
    }

    private static void assertTrue(boolean condition) {
        if (!condition) {
            throw new AssertionError("Expected condition to be true");
        }
    }

    public static void setMicrophoneMute(boolean mute) {
        RXLogging.w(TAG, "setMicrophoneMute(" + mute + ")");
        microphoneMute = mute;
    }

    private void releaseAudioResources() {
        RXLogging.i(TAG, "releaseAudioResources");
        AudioRecord audioRecord = this.audioRecord;
        if (audioRecord != null) {
            audioRecord.release();
            this.audioRecord = null;
        }
    }

    private void reportWebRtcAudioRecordInitError(String errorMessage) {
        RXLogging.e(TAG, "Init recording error: " + errorMessage);
        WebRtcAudioUtils.logAudioState(TAG);
        WebRtcAudioRecordErrorCallback webRtcAudioRecordErrorCallback = errorCallback;
        if (webRtcAudioRecordErrorCallback != null) {
            webRtcAudioRecordErrorCallback.onWebRtcAudioRecordInitError(errorMessage);
        }
    }

    private void reportWebRtcAudioRecordStartError(AudioRecordStartErrorCode errorCode, String errorMessage) {
        RXLogging.e(TAG, "Start recording error: " + errorCode + ". " + errorMessage);
        WebRtcAudioUtils.logAudioState(TAG);
        WebRtcAudioRecordErrorCallback webRtcAudioRecordErrorCallback = errorCallback;
        if (webRtcAudioRecordErrorCallback != null) {
            webRtcAudioRecordErrorCallback.onWebRtcAudioRecordStartError(errorCode, errorMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportWebRtcAudioRecordError(String errorMessage) {
        RXLogging.e(TAG, "Run-time recording error: " + errorMessage);
        WebRtcAudioUtils.logAudioState(TAG);
        WebRtcAudioRecordErrorCallback webRtcAudioRecordErrorCallback = errorCallback;
        if (webRtcAudioRecordErrorCallback != null) {
            webRtcAudioRecordErrorCallback.onWebRtcAudioRecordError(errorMessage);
        }
    }

    private int cvtNativeSetAudioSource(int audioSourceFromNative, boolean forbidVoip) {
        int i = defaultMediaModeAudioSource;
        if (!forbidVoip) {
            i = 7;
        }
        if (audioSourceFromNative == 0) {
            return 0;
        }
        int i2 = 1;
        if (audioSourceFromNative != 1) {
            i2 = 5;
            if (audioSourceFromNative != 5) {
                i2 = 6;
                if (audioSourceFromNative != 6) {
                    if (audioSourceFromNative == 7) {
                        return 7;
                    }
                    if (audioSourceFromNative == 9) {
                        return 9;
                    }
                    if (audioSourceFromNative != 10) {
                        return i;
                    }
                    return 10;
                }
            }
        }
        return i2;
    }
}
