package com.ss.bytertc.audio.device.webrtc;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Process;
import com.bytedance.realx.base.ContextUtils;
import com.bytedance.realx.base.ExceptionUtils;
import com.bytedance.realx.base.RXLogging;
import com.bytedance.realx.base.ThreadUtils;
import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public class WebRtcAudioTrack {
    private static final long AUDIO_TRACK_THREAD_JOIN_TIMEOUT_MS = 2000;
    private static final int BITS_PER_SAMPLE = 16;
    private static final int BUFFERS_PER_SECOND = 100;
    private static final int CALLBACK_BUFFER_SIZE_MS = 10;
    private static final boolean DEBUG = false;
    private static final int DEFAULT_USAGE;
    private static final int INVALID_AUDIO_SESSION_ID = -1;
    private static final String TAG = "WebRtcAudioTrack";
    private static ErrorCallback errorCallback;
    private static WebRtcAudioTrackErrorCallback errorCallbackOld;
    private static boolean sForbidVoip;
    private static volatile boolean speakerMute;
    private static int usageAttribute;
    private String apiResult;
    private final AudioManager audioManager;
    private AudioTrackThread audioThread;
    private AudioTrack audioTrack;
    private ByteBuffer byteBuffer;
    private byte[] emptyBytes;
    private final long nativeAudioTrack;
    private final ThreadUtils.ThreadChecker threadChecker;

    /* loaded from: classes7.dex */
    public enum AudioTrackStartErrorCode {
        AUDIO_TRACK_START_EXCEPTION,
        AUDIO_TRACK_START_STATE_MISMATCH
    }

    /* loaded from: classes7.dex */
    public interface ErrorCallback {
        void onWebRtcAudioTrackError(String errorMessage);

        void onWebRtcAudioTrackInitError(String errorMessage);

        void onWebRtcAudioTrackStartError(AudioTrackStartErrorCode errorCode, String errorMessage);
    }

    @Deprecated
    /* loaded from: classes7.dex */
    public interface WebRtcAudioTrackErrorCallback {
        void onWebRtcAudioTrackError(String errorMessage);

        void onWebRtcAudioTrackInitError(String errorMessage);

        void onWebRtcAudioTrackStartError(String errorMessage);
    }

    private int channelCountToConfiguration(int channels) {
        return channels == 1 ? 4 : 12;
    }

    private static int getDefaultUsageAttribute() {
        return 2;
    }

    private native void nativeCacheDirectBufferAddress(ByteBuffer byteBuffer, long nativeAudioRecord);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeGetPlayoutData(int bytes, long nativeAudioRecord);

    static {
        int defaultUsageAttribute = getDefaultUsageAttribute();
        DEFAULT_USAGE = defaultUsageAttribute;
        usageAttribute = defaultUsageAttribute;
    }

    public static synchronized void setAudioTrackUsageAttribute(int usage) {
        synchronized (WebRtcAudioTrack.class) {
            RXLogging.w(TAG, "Default usage attribute is changed from: " + DEFAULT_USAGE + " to " + usage);
            usageAttribute = usage;
        }
    }

    /* loaded from: classes7.dex */
    private static class AudioTrackErrorCode {
        public static final int AUDIO_TRACK_INIT_CREATE_FAIL = -203;
        public static final int AUDIO_TRACK_INIT_CREATE_INVALID_STATE = -204;
        public static final int AUDIO_TRACK_INIT_ERROR = -205;
        public static final int AUDIO_TRACK_INIT_ILLEGAL_ARGUMENTS = -202;
        public static final int AUDIO_TRACK_INIT_IS_NOT_NULL = -201;
        public static final int AUDIO_TRACK_INIT_MINBUFFER_ERROR = -200;
        public static final int AUDIO_TRACK_START_ILLEGAL_STATE = -102;
        public static final int AUDIO_TRACK_START_INVALID_STATE = -103;
        public static final int AUDIO_TRACK_START_IS_NULL = -100;
        public static final int AUDIO_TRACK_START_THREAD_NOT_NULL = -101;
        public static final int AUDIO_TRACK_SUCCESS = 0;

        private AudioTrackErrorCode() {
        }
    }

    @Deprecated
    public static void setErrorCallback(WebRtcAudioTrackErrorCallback errorCallback2) {
        RXLogging.i(TAG, "Set error callback (deprecated");
        errorCallbackOld = errorCallback2;
    }

    public static void setErrorCallback(ErrorCallback errorCallback2) {
        RXLogging.i(TAG, "Set extended error callback");
        errorCallback = errorCallback2;
    }

    /* loaded from: classes7.dex */
    private class AudioTrackThread extends Thread {
        private volatile boolean keepAlive;

        public AudioTrackThread(String name) {
            super(name);
            this.keepAlive = true;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            int i;
            if (WebRtcAudioTrack.this.audioTrack == null) {
                RXLogging.e(WebRtcAudioTrack.TAG, "null audio track instance");
                this.keepAlive = false;
            } else {
                RXLogging.i(WebRtcAudioTrack.TAG, "AudioTrackThread" + WebRtcAudioUtils.getThreadInfo());
                RXLogging.i(WebRtcAudioTrack.TAG, "AudioTrack state: " + WebRtcAudioTrack.this.audioTrack.getPlayState());
            }
            Process.setThreadPriority(-19);
            int capacity = WebRtcAudioTrack.this.byteBuffer.capacity();
            while (this.keepAlive) {
                synchronized (this) {
                    if (this.keepAlive) {
                        WebRtcAudioTrack webRtcAudioTrack = WebRtcAudioTrack.this;
                        webRtcAudioTrack.nativeGetPlayoutData(capacity, webRtcAudioTrack.nativeAudioTrack);
                    }
                }
                if (WebRtcAudioTrack.speakerMute) {
                    WebRtcAudioTrack.this.byteBuffer.clear();
                    WebRtcAudioTrack.this.byteBuffer.put(WebRtcAudioTrack.this.emptyBytes);
                    WebRtcAudioTrack.this.byteBuffer.position(0);
                }
                try {
                    i = writeBytes(WebRtcAudioTrack.this.audioTrack, WebRtcAudioTrack.this.byteBuffer, capacity);
                } catch (Exception e) {
                    this.keepAlive = false;
                    RXLogging.e(WebRtcAudioTrack.TAG, "AudioTrack.write error, Exception: " + e.getMessage());
                    WebRtcAudioTrack.this.reportWebRtcAudioTrackError("AudioTrack.write error, Exception: " + e.getMessage());
                    i = -1;
                }
                if (i != capacity && i < 0) {
                    this.keepAlive = false;
                    RXLogging.e(WebRtcAudioTrack.TAG, "AudioTrack.write played invalid number of bytes: " + i);
                    WebRtcAudioTrack.this.reportWebRtcAudioTrackError("AudioTrack.write failed: " + i);
                }
                WebRtcAudioTrack.this.byteBuffer.rewind();
            }
            if (WebRtcAudioTrack.this.audioTrack != null) {
                RXLogging.i(WebRtcAudioTrack.TAG, "Calling AudioTrack.stop...");
                try {
                    WebRtcAudioTrack.this.audioTrack.stop();
                    RXLogging.i(WebRtcAudioTrack.TAG, "AudioTrack.stop is done.");
                } catch (Exception e2) {
                    RXLogging.e(WebRtcAudioTrack.TAG, "AudioTrack.stop failed: " + e2.getMessage());
                }
            }
        }

        private int writeBytes(AudioTrack audioTrack, ByteBuffer byteBuffer, int sizeInBytes) {
            if (audioTrack == null) {
                return -1;
            }
            return audioTrack.write(byteBuffer, sizeInBytes, 0);
        }

        public void stopThread() {
            synchronized (this) {
                RXLogging.i(WebRtcAudioTrack.TAG, "stopThread");
                this.keepAlive = false;
            }
        }
    }

    WebRtcAudioTrack(long nativeAudioTrack) {
        ThreadUtils.ThreadChecker threadChecker = new ThreadUtils.ThreadChecker();
        this.threadChecker = threadChecker;
        this.apiResult = "";
        threadChecker.checkIsOnValidThread();
        RXLogging.i(TAG, "ctor" + WebRtcAudioUtils.getThreadInfo());
        this.nativeAudioTrack = nativeAudioTrack;
        this.audioManager = (AudioManager) ContextUtils.getApplicationContext().getSystemService("audio");
    }

    private int initPlayout(int sampleRate, int channels, boolean forbidVoip) {
        this.apiResult = "InitPlayout(sampleRate=" + sampleRate + ", channels=" + channels + ", forbidVoip=" + forbidVoip + "):";
        sForbidVoip = forbidVoip;
        try {
            this.threadChecker.checkIsOnValidThread();
            RXLogging.i(TAG, "initPlayout(sampleRate=" + sampleRate + ", channels=" + channels + ")");
            this.byteBuffer = ByteBuffer.allocateDirect(channels * 2 * (sampleRate / 100));
            RXLogging.i(TAG, "byteBuffer.capacity: " + this.byteBuffer.capacity());
            this.emptyBytes = new byte[this.byteBuffer.capacity()];
            nativeCacheDirectBufferAddress(this.byteBuffer, this.nativeAudioTrack);
            int channelCountToConfiguration = channelCountToConfiguration(channels);
            int minBufferSize = AudioTrack.getMinBufferSize(sampleRate, channelCountToConfiguration, 2);
            RXLogging.i(TAG, "AudioTrack.getMinBufferSize: " + minBufferSize);
            if (minBufferSize < this.byteBuffer.capacity()) {
                reportWebRtcAudioTrackInitError("AudioTrack.getMinBufferSize returns an invalid value.");
                this.apiResult += "AudioTrack.getMinBufferSize returns an invalid value.";
                return -200;
            }
            if (this.audioTrack != null) {
                reportWebRtcAudioTrackInitError("Conflict with existing AudioTrack.");
                this.apiResult += "Conflict with existing AudioTrack.";
                return -201;
            }
            try {
                this.apiResult += "minBufferSizeInBytes: " + minBufferSize;
                AudioTrack createAudioTrackOnLollipopOrHigher = createAudioTrackOnLollipopOrHigher(sampleRate, channelCountToConfiguration, minBufferSize);
                this.audioTrack = createAudioTrackOnLollipopOrHigher;
                if (createAudioTrackOnLollipopOrHigher != null && createAudioTrackOnLollipopOrHigher.getState() == 1) {
                    logMainParameters();
                    logMainParametersExtended();
                    return 0;
                }
                reportWebRtcAudioTrackInitError("Initialization of audio track failed.");
                releaseAudioResources();
                this.apiResult += "Initialization of audio track failed.";
                return this.audioTrack == null ? -203 : -204;
            } catch (IllegalArgumentException e) {
                reportWebRtcAudioTrackInitError(ExceptionUtils.stackTrace(e) + e.getMessage());
                releaseAudioResources();
                return -202;
            }
        } catch (Exception e2) {
            RXLogging.w(TAG, "initPlayout exception", e2);
            reportWebRtcAudioTrackInitError(ExceptionUtils.stackTrace(e2));
            this.apiResult += "initPlayout exception";
            return -205;
        }
    }

    private int startPlayout() {
        this.threadChecker.checkIsOnValidThread();
        RXLogging.i(TAG, "startPlayout");
        AudioTrack audioTrack = this.audioTrack;
        if (audioTrack == null) {
            RXLogging.e(TAG, "null audio track object");
            return -100;
        }
        if (this.audioThread != null) {
            RXLogging.e(TAG, "the previous audio thread leak");
            return -101;
        }
        this.apiResult = "StartPlayout:";
        try {
            audioTrack.play();
            if (this.audioTrack.getPlayState() != 3) {
                reportWebRtcAudioTrackStartError(AudioTrackStartErrorCode.AUDIO_TRACK_START_STATE_MISMATCH, "AudioTrack.play failed - incorrect state :" + this.audioTrack.getPlayState());
                this.apiResult += "AudioTrack.play failed - incorrect state :" + this.audioTrack.getPlayState();
                releaseAudioResources();
                return -103;
            }
            AudioTrackThread audioTrackThread = new AudioTrackThread("BaeTrackJavaThread");
            this.audioThread = audioTrackThread;
            audioTrackThread.start();
            return 0;
        } catch (IllegalStateException e) {
            reportWebRtcAudioTrackStartError(AudioTrackStartErrorCode.AUDIO_TRACK_START_EXCEPTION, "AudioTrack.play failed: " + e.getMessage());
            releaseAudioResources();
            this.apiResult += "AudioTrack.play failed: " + e.getMessage();
            return -102;
        }
    }

    private boolean stopPlayout() {
        this.threadChecker.checkIsOnValidThread();
        RXLogging.i(TAG, "stopPlayout");
        this.apiResult = "StopPlayout:";
        logUnderrunCount();
        if (this.audioThread != null) {
            RXLogging.i(TAG, "Stopping the AudioTrackThread...");
            this.audioThread.stopThread();
            RXLogging.i(TAG, "interrupt the AudioTrackThread...");
            this.audioThread.interrupt();
            if (!ThreadUtils.joinUninterruptibly(this.audioThread, 2000L)) {
                RXLogging.e(TAG, "Join of AudioTrackThread timed out.");
                WebRtcAudioUtils.logAudioState(TAG);
                this.apiResult += "Join of AudioTrackThread timed out.";
            }
            RXLogging.i(TAG, "AudioTrackThread has now been stopped.");
            this.audioThread = null;
        }
        releaseAudioResources();
        RXLogging.i(TAG, "stopPlayout release done.");
        return true;
    }

    private String getApiResult() {
        this.threadChecker.checkIsOnValidThread();
        return this.apiResult;
    }

    private int getStreamType() {
        this.threadChecker.checkIsOnValidThread();
        AudioTrack audioTrack = this.audioTrack;
        if (audioTrack == null) {
            return -1;
        }
        return audioTrack.getStreamType();
    }

    private int getStreamMaxVolume() {
        this.threadChecker.checkIsOnValidThread();
        RXLogging.i(TAG, "getStreamMaxVolume");
        AudioManager audioManager = this.audioManager;
        if (audioManager == null) {
            return -1;
        }
        return audioManager.getStreamMaxVolume(0);
    }

    private boolean setStreamVolume(int volume) {
        this.threadChecker.checkIsOnValidThread();
        RXLogging.i(TAG, "setStreamVolume(" + volume + ")");
        if (this.audioManager == null) {
            return false;
        }
        if (isVolumeFixed()) {
            RXLogging.e(TAG, "The device implements a fixed volume policy.");
            return false;
        }
        this.audioManager.setStreamVolume(0, volume, 0);
        return true;
    }

    private boolean isVolumeFixed() {
        return this.audioManager.isVolumeFixed();
    }

    private int getStreamVolume() {
        this.threadChecker.checkIsOnValidThread();
        RXLogging.i(TAG, "getStreamVolume");
        AudioManager audioManager = this.audioManager;
        if (audioManager == null) {
            return -1;
        }
        return audioManager.getStreamVolume(0);
    }

    private int getAudioSessionId() {
        AudioTrack audioTrack = this.audioTrack;
        if (audioTrack == null) {
            return -1;
        }
        return audioTrack.getAudioSessionId();
    }

    private void logMainParameters() {
        RXLogging.i(TAG, "AudioTrack: session ID: " + this.audioTrack.getAudioSessionId() + ", channels: " + this.audioTrack.getChannelCount() + ", sample rate: " + this.audioTrack.getSampleRate() + ", max gain: " + AudioTrack.getMaxVolume());
    }

    private static AudioTrack createAudioTrackOnLollipopOrHigher(int sampleRateInHz, int channelConfig, int bufferSizeInBytes) {
        RXLogging.i(TAG, "createAudioTrackOnLollipopOrHigher");
        int nativeOutputSampleRate = AudioTrack.getNativeOutputSampleRate(sForbidVoip ? 3 : 0);
        RXLogging.i(TAG, "nativeOutputSampleRate: " + nativeOutputSampleRate);
        if (sampleRateInHz != nativeOutputSampleRate) {
            RXLogging.w(TAG, "Unable to use fast mode since requested sample rate is not native");
        }
        if (sForbidVoip) {
            usageAttribute = 1;
        } else {
            usageAttribute = DEFAULT_USAGE;
        }
        if (usageAttribute != DEFAULT_USAGE) {
            RXLogging.w(TAG, "A non default usage attribute is used: " + usageAttribute);
        }
        return new AudioTrack(new AudioAttributes.Builder().setUsage(usageAttribute).setContentType(1).build(), new AudioFormat.Builder().setEncoding(2).setSampleRate(sampleRateInHz).setChannelMask(channelConfig).build(), bufferSizeInBytes, 1, 0);
    }

    private static AudioTrack createAudioTrackOnLowerThanLollipop(int sampleRateInHz, int channelConfig, int bufferSizeInBytes) {
        if (sForbidVoip) {
            return new AudioTrack(3, sampleRateInHz, channelConfig, 2, bufferSizeInBytes, 1);
        }
        return new AudioTrack(0, sampleRateInHz, channelConfig, 2, bufferSizeInBytes, 1);
    }

    private void logBufferSizeInFrames() {
        RXLogging.i(TAG, "AudioTrack: buffer size in frames: " + this.audioTrack.getBufferSizeInFrames());
    }

    private void logBufferCapacityInFrames() {
        RXLogging.i(TAG, "AudioTrack: buffer capacity in frames: " + this.audioTrack.getBufferCapacityInFrames());
    }

    private void logMainParametersExtended() {
        logBufferSizeInFrames();
        logBufferCapacityInFrames();
    }

    private void logUnderrunCount() {
        if (this.audioTrack != null) {
            RXLogging.i(TAG, "underrun count: " + this.audioTrack.getUnderrunCount());
        }
    }

    private static void assertTrue(boolean condition) {
        if (!condition) {
            throw new AssertionError("Expected condition to be true");
        }
    }

    public static void setSpeakerMute(boolean mute) {
        RXLogging.w(TAG, "setSpeakerMute(" + mute + ")");
        speakerMute = mute;
    }

    private void releaseAudioResources() {
        RXLogging.i(TAG, "releaseAudioResources");
        AudioTrack audioTrack = this.audioTrack;
        if (audioTrack != null) {
            audioTrack.release();
            this.audioTrack = null;
        }
    }

    private void reportWebRtcAudioTrackInitError(String errorMessage) {
        RXLogging.e(TAG, "Init playout error: " + errorMessage);
        WebRtcAudioUtils.logAudioState(TAG);
        WebRtcAudioTrackErrorCallback webRtcAudioTrackErrorCallback = errorCallbackOld;
        if (webRtcAudioTrackErrorCallback != null) {
            webRtcAudioTrackErrorCallback.onWebRtcAudioTrackInitError(errorMessage);
        }
        ErrorCallback errorCallback2 = errorCallback;
        if (errorCallback2 != null) {
            errorCallback2.onWebRtcAudioTrackInitError(errorMessage);
        }
    }

    private void reportWebRtcAudioTrackStartError(AudioTrackStartErrorCode errorCode, String errorMessage) {
        RXLogging.e(TAG, "Start playout error: " + errorCode + ". " + errorMessage);
        WebRtcAudioUtils.logAudioState(TAG);
        WebRtcAudioTrackErrorCallback webRtcAudioTrackErrorCallback = errorCallbackOld;
        if (webRtcAudioTrackErrorCallback != null) {
            webRtcAudioTrackErrorCallback.onWebRtcAudioTrackStartError(errorMessage);
        }
        ErrorCallback errorCallback2 = errorCallback;
        if (errorCallback2 != null) {
            errorCallback2.onWebRtcAudioTrackStartError(errorCode, errorMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportWebRtcAudioTrackError(String errorMessage) {
        RXLogging.e(TAG, "Run-time playback error: " + errorMessage);
        WebRtcAudioUtils.logAudioState(TAG);
        WebRtcAudioTrackErrorCallback webRtcAudioTrackErrorCallback = errorCallbackOld;
        if (webRtcAudioTrackErrorCallback != null) {
            webRtcAudioTrackErrorCallback.onWebRtcAudioTrackError(errorMessage);
        }
        ErrorCallback errorCallback2 = errorCallback;
        if (errorCallback2 != null) {
            errorCallback2.onWebRtcAudioTrackError(errorMessage);
        }
    }
}
