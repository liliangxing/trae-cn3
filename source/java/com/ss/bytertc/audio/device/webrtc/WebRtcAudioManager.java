package com.ss.bytertc.audio.device.webrtc;

import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioRecordingConfiguration;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import com.bytedance.realx.base.ContextUtils;
import com.bytedance.realx.base.RXLogging;
import com.ss.bytertc.audio.device.webrtc.observer.MicMuteChangedObserver;
import com.ss.bytertc.audio.device.webrtc.observer.VolumeChangedObserver;
import com.ss.ttm.player.MediaFormat;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class WebRtcAudioManager implements VolumeChangedObserver.OnVolumeChangedListener, MicMuteChangedObserver.OnMicMuteChangedListener {
    private static final int BITS_PER_SAMPLE = 16;
    private static final boolean DEBUG = false;
    private static final int DEFAULT_FRAME_PER_BUFFER = 256;
    private static int MAX_VOLUMED = 0;
    private static int MAX_VOLUMED_VOIP = 0;
    private static final String TAG = "WebRtcAudioManager";
    private static final boolean blacklistDeviceForAAudioUsage = false;
    private static boolean blacklistDeviceForOpenSLESUsage;
    private static boolean blacklistDeviceForOpenSLESUsageIsOverridden;
    private static boolean useStereoInput;
    private static boolean useStereoOutput;
    private boolean aAudio;
    private int apiLevel;
    private final AudioManager audioManager;
    private boolean hardwareAEC;
    private boolean hardwareAGC;
    private boolean hardwareNS;
    private boolean initialized;
    private int inputBufferSize;
    private int inputChannels;
    private Set<NativeRecordCallbackInfo> lastRecordcallbackInfos;
    private boolean lowLatencyInput;
    private boolean lowLatencyOutput;
    private WebRtcAudioEarBack mByteAudioEarback;
    private MicMuteChangedObserver mMicMuteChangedObserver;
    private VolumeChangedObserver mVolumeChangedObserver;
    private long nativeAudioManager;
    private int nativeChannels;
    private int nativeSampleRate;
    private int outputBufferSize;
    private int outputChannels;
    private boolean proAudio;
    private int sampleRate;
    private int preferAudioLayer = 0;
    private AudioManagerRecordingCallback recordingCallback = null;
    private AudioManagerPhoneStateListener phoneStateListener = null;
    private int microphoneVolume = 100;
    private int curMode = -2;
    private boolean modeInvalid = false;

    private int getPreferAudioLayer() {
        return 0;
    }

    private native void nativeCacheAudioParameters(int apiLevel, int sampleRate, int outputChannels, int inputChannels, boolean hardwareAEC, boolean hardwareAGC, boolean hardwareNS, boolean lowLatencyOutput, boolean lowLatencyInput, boolean proAudio, boolean aAudio, int outputBufferSize, int inputBufferSize, int preferAudioLayer, long nativeAudioManager);

    private native void nativeOnHardwareEarbackReleased(boolean success, long nativeAudioManager);

    private native void nativeOnHardwareEarbackSupportParamsGet(String params, long nativeAudioManager);

    private native void nativeOnHardwareEarbackSupported(boolean isSupported, long nativeAudioManager);

    private native void nativeOnMicMuteChanged(boolean micMuted, long nativeAudioManager);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnPhoneCallEnd(long nativeAudioManager);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnPhoneCallStart(long nativeAudioManager);

    private native void nativeOnPhoneStateListenerRegisterChanged(boolean isRegistered, long nativeAudioManager);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeRecordCallbackChanged(Object[] recordCallbackInfos, long nativeAudioManager);

    private native void onVolumeChanged(int streamType, int volume, long nativeAudioManager);

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private static final class NativeAudioLayer {
        public static final int kAndroidAAudioAudio = 8;
        public static final int kAndroidJavaAudio = 5;
        public static final int kAndroidJavaInputAndAAudioOutputAudio = 9;
        public static final int kAndroidJavaInputAndOpenSLESOutputAudio = 7;
        public static final int kAndroidOpenSLESAudio = 6;
        public static final int kPlatformDefaultAudio = 0;

        private NativeAudioLayer() {
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private final class NativeRecordCallbackInfo {
        private int audio_session_id;
        private int audio_source;
        private int client_audio_source;
        private int is_client_silenced;

        private NativeRecordCallbackInfo() {
            this.audio_session_id = -1;
            this.client_audio_source = -1;
            this.audio_source = -1;
            this.is_client_silenced = -1;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            NativeRecordCallbackInfo nativeRecordCallbackInfo = (NativeRecordCallbackInfo) o;
            return this.audio_session_id == nativeRecordCallbackInfo.audio_session_id && this.client_audio_source == nativeRecordCallbackInfo.client_audio_source && this.audio_source == nativeRecordCallbackInfo.audio_source && this.is_client_silenced == nativeRecordCallbackInfo.is_client_silenced;
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(this.audio_session_id), Integer.valueOf(this.client_audio_source), Integer.valueOf(this.audio_source), Integer.valueOf(this.is_client_silenced));
        }
    }

    public static synchronized void setBlacklistDeviceForOpenSLESUsage(boolean enable) {
        synchronized (WebRtcAudioManager.class) {
            blacklistDeviceForOpenSLESUsageIsOverridden = true;
            blacklistDeviceForOpenSLESUsage = enable;
        }
    }

    public static synchronized void setStereoOutput(boolean enable) {
        synchronized (WebRtcAudioManager.class) {
            RXLogging.w(TAG, "Overriding default output behavior: setStereoOutput(" + enable + ')');
            useStereoOutput = enable;
        }
    }

    public static synchronized void setStereoInput(boolean enable) {
        synchronized (WebRtcAudioManager.class) {
            RXLogging.w(TAG, "Overriding default input behavior: setStereoInput(" + enable + ')');
            useStereoInput = enable;
        }
    }

    public static synchronized boolean getStereoOutput() {
        boolean z;
        synchronized (WebRtcAudioManager.class) {
            z = useStereoOutput;
        }
        return z;
    }

    public static synchronized boolean getStereoInput() {
        boolean z;
        synchronized (WebRtcAudioManager.class) {
            z = useStereoInput;
        }
        return z;
    }

    @Override // com.ss.bytertc.audio.device.webrtc.observer.VolumeChangedObserver.OnVolumeChangedListener
    public void onVolumeChanged(int streamType, int volume) {
        double d = ((volume * 1.0d) / (streamType == 0 ? MAX_VOLUMED_VOIP : MAX_VOLUMED)) * 100.0d;
        synchronized (this) {
            long j = this.nativeAudioManager;
            if (j != 0) {
                onVolumeChanged(streamType, (int) d, j);
            }
        }
    }

    @Override // com.ss.bytertc.audio.device.webrtc.observer.MicMuteChangedObserver.OnMicMuteChangedListener
    public void onMicMuteChanged(boolean micMuted) {
        synchronized (this) {
            long j = this.nativeAudioManager;
            if (j != 0) {
                nativeOnMicMuteChanged(micMuted, j);
            }
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    class AudioManagerRecordingCallback extends AudioManager.AudioRecordingCallback {
        private WebRtcAudioManager manager;

        AudioManagerRecordingCallback(WebRtcAudioManager manager) {
            this.manager = manager;
        }

        @Override // android.media.AudioManager.AudioRecordingCallback
        public void onRecordingConfigChanged(List<AudioRecordingConfiguration> configs) {
            super.onRecordingConfigChanged(configs);
            HashSet hashSet = new HashSet();
            for (int i = 0; i < configs.size(); i++) {
                AudioRecordingConfiguration audioRecordingConfiguration = configs.get(i);
                NativeRecordCallbackInfo nativeRecordCallbackInfo = new NativeRecordCallbackInfo();
                nativeRecordCallbackInfo.audio_session_id = audioRecordingConfiguration.getClientAudioSessionId();
                nativeRecordCallbackInfo.client_audio_source = audioRecordingConfiguration.getClientAudioSource();
                int i2 = -1;
                nativeRecordCallbackInfo.audio_source = Build.VERSION.SDK_INT >= 29 ? audioRecordingConfiguration.getAudioSource() : -1;
                if (Build.VERSION.SDK_INT >= 29) {
                    i2 = audioRecordingConfiguration.isClientSilenced() ? 1 : 0;
                }
                nativeRecordCallbackInfo.is_client_silenced = i2;
                hashSet.add(nativeRecordCallbackInfo);
            }
            synchronized (this.manager) {
                if (WebRtcAudioManager.this.nativeAudioManager != 0 && (WebRtcAudioManager.this.lastRecordcallbackInfos == null || !WebRtcAudioManager.this.lastRecordcallbackInfos.equals(hashSet))) {
                    WebRtcAudioManager.this.nativeRecordCallbackChanged(hashSet.toArray(new NativeRecordCallbackInfo[hashSet.size()]), WebRtcAudioManager.this.nativeAudioManager);
                    WebRtcAudioManager.this.lastRecordcallbackInfos = hashSet;
                }
            }
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class AudioManagerPhoneStateListener extends PhoneStateListener {
        private int callState = 0;

        @Override // android.telephony.PhoneStateListener
        public void onServiceStateChanged(ServiceState serviceState) {
        }

        public AudioManagerPhoneStateListener() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int state, String incomingNumber) {
            synchronized (WebRtcAudioManager.this) {
                int i = this.callState;
                this.callState = state;
                RXLogging.i(WebRtcAudioManager.TAG, "onCallStateChanged, from: " + i + ", to: " + state);
                if (state != 0) {
                    if ((state == 1 || state == 2) && i == 0) {
                        if (WebRtcAudioManager.this.nativeAudioManager != 0) {
                            RXLogging.i(WebRtcAudioManager.TAG, "startPhoneCall");
                            WebRtcAudioManager webRtcAudioManager = WebRtcAudioManager.this;
                            webRtcAudioManager.nativeOnPhoneCallStart(webRtcAudioManager.nativeAudioManager);
                        } else {
                            RXLogging.e(WebRtcAudioManager.TAG, "nativeAudioManager is null");
                        }
                    }
                } else if (i == 1 || i == 2) {
                    if (WebRtcAudioManager.this.nativeAudioManager != 0) {
                        RXLogging.i(WebRtcAudioManager.TAG, "endPhoneCall");
                        WebRtcAudioManager webRtcAudioManager2 = WebRtcAudioManager.this;
                        webRtcAudioManager2.nativeOnPhoneCallEnd(webRtcAudioManager2.nativeAudioManager);
                    } else {
                        RXLogging.e(WebRtcAudioManager.TAG, "nativeAudioManager is null");
                    }
                }
            }
        }
    }

    WebRtcAudioManager(long nativeAudioManager) {
        synchronized (this) {
            RXLogging.i(TAG, "ctor(" + this + ")" + WebRtcAudioUtils.getThreadInfo());
            this.nativeAudioManager = nativeAudioManager;
            AudioManager audioManager = (AudioManager) ContextUtils.getApplicationContext().getSystemService(MediaFormat.KEY_AUDIO);
            this.audioManager = audioManager;
            MAX_VOLUMED = audioManager.getStreamMaxVolume(3);
            MAX_VOLUMED_VOIP = audioManager.getStreamMaxVolume(0);
            refreshAudioParameters();
            WebRtcAudioUtils.logAudioState(TAG);
        }
    }

    private boolean init() {
        synchronized (this) {
            RXLogging.i(TAG, "init(" + this + ")" + WebRtcAudioUtils.getThreadInfo());
            if (this.initialized) {
                return true;
            }
            RXLogging.i(TAG, "audio mode is: " + WebRtcAudioUtils.modeToString(this.audioManager.getMode()));
            if (this.recordingCallback == null) {
                AudioManagerRecordingCallback audioManagerRecordingCallback = new AudioManagerRecordingCallback(this);
                this.recordingCallback = audioManagerRecordingCallback;
                try {
                    this.audioManager.registerAudioRecordingCallback(audioManagerRecordingCallback, null);
                } catch (Exception e) {
                    StringWriter stringWriter = new StringWriter();
                    e.printStackTrace(new PrintWriter(stringWriter));
                    RXLogging.e(TAG, stringWriter.toString());
                }
            }
            registerPhoneStateListener(32);
            this.mVolumeChangedObserver = new VolumeChangedObserver(this);
            try {
                int mode = this.audioManager.getMode();
                if (mode == 0) {
                    onVolumeChanged(3, this.audioManager.getStreamVolume(3));
                } else if (mode == 3) {
                    onVolumeChanged(0, this.audioManager.getStreamVolume(0));
                }
                this.initialized = true;
            } catch (Exception e2) {
                StringWriter stringWriter2 = new StringWriter();
                e2.printStackTrace(new PrintWriter(stringWriter2));
                RXLogging.e(TAG, stringWriter2.toString());
            }
            this.mMicMuteChangedObserver = new MicMuteChangedObserver(this);
            return true;
        }
    }

    private void registerPhoneStateListener(final int events) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ss.bytertc.audio.device.webrtc.WebRtcAudioManager.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (WebRtcAudioManager.this.phoneStateListener == null) {
                        WebRtcAudioManager.this.phoneStateListener = new AudioManagerPhoneStateListener();
                    }
                    if (events == 0) {
                        WebRtcAudioManager.this.notifyPhoneStateListenerRegistered(false);
                    }
                    TelephonyManager telephonyManager = (TelephonyManager) ContextUtils.getApplicationContext().getSystemService("phone");
                    if (telephonyManager != null) {
                        telephonyManager.listen(WebRtcAudioManager.this.phoneStateListener, events);
                    }
                    if (events == 32) {
                        WebRtcAudioManager.this.notifyPhoneStateListenerRegistered(true);
                    }
                    RXLogging.i(WebRtcAudioManager.TAG, "registerPhoneStateListener success with event: " + events);
                } catch (Throwable th) {
                    th.printStackTrace();
                    RXLogging.e(WebRtcAudioManager.TAG, "registerPhoneStateListener (" + events + "), error: " + th.getCause() + ", " + th.getMessage());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyPhoneStateListenerRegistered(boolean registered) {
        synchronized (this) {
            if (this.nativeAudioManager != 0) {
                RXLogging.i(TAG, "dixing: notifyPhoneStateListenerRegistered: " + registered + ", " + this.nativeAudioManager);
                nativeOnPhoneStateListenerRegisterChanged(registered, this.nativeAudioManager);
            }
        }
    }

    private void terminate() {
        synchronized (this) {
            RXLogging.i(TAG, "terminate(" + this + ")" + WebRtcAudioUtils.getThreadInfo());
            AudioManagerRecordingCallback audioManagerRecordingCallback = this.recordingCallback;
            if (audioManagerRecordingCallback != null) {
                try {
                    this.audioManager.unregisterAudioRecordingCallback(audioManagerRecordingCallback);
                } catch (Exception e) {
                    StringWriter stringWriter = new StringWriter();
                    e.printStackTrace(new PrintWriter(stringWriter));
                    RXLogging.e(TAG, stringWriter.toString());
                }
                this.recordingCallback = null;
            }
            registerPhoneStateListener(0);
            VolumeChangedObserver volumeChangedObserver = this.mVolumeChangedObserver;
            if (volumeChangedObserver != null) {
                volumeChangedObserver.release();
                this.mVolumeChangedObserver = null;
            }
            MicMuteChangedObserver micMuteChangedObserver = this.mMicMuteChangedObserver;
            if (micMuteChangedObserver != null) {
                micMuteChangedObserver.release();
                this.mMicMuteChangedObserver = null;
            }
            WebRtcAudioEarBack webRtcAudioEarBack = this.mByteAudioEarback;
            if (webRtcAudioEarBack != null) {
                webRtcAudioEarBack.ByteAudioEarBackRelease();
                this.mByteAudioEarback = null;
            }
            this.nativeAudioManager = 0L;
            this.initialized = false;
        }
    }

    private boolean isCommunicationModeEnabled() {
        try {
            return 3 == this.audioManager.getMode();
        } catch (Exception e) {
            StringWriter stringWriter = new StringWriter();
            e.printStackTrace(new PrintWriter(stringWriter));
            RXLogging.e(TAG, stringWriter.toString());
            return false;
        }
    }

    private int SetAudioMode(int mode) {
        RXLogging.i(TAG, "SetAudioMode enter, modeInvalid: " + this.modeInvalid + ", curMode: " + this.curMode + ", setMode: " + mode);
        try {
            if (mode != this.curMode || this.modeInvalid) {
                this.audioManager.setMode(mode);
                RXLogging.w(TAG, "set mode from: " + this.curMode + ", to: " + mode + ", modeInvalid is: " + this.modeInvalid);
            }
            int mode2 = getMode();
            this.curMode = mode2;
            this.modeInvalid = mode2 != mode;
            RXLogging.i(TAG, "SetAudioMode leave, modeInvalid: " + this.modeInvalid + ", curMode: " + this.curMode + ", setMode: " + mode);
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    private boolean isWiredHeadsetOn() {
        try {
            return this.audioManager.isWiredHeadsetOn();
        } catch (Exception e) {
            StringWriter stringWriter = new StringWriter();
            e.printStackTrace(new PrintWriter(stringWriter));
            RXLogging.e(TAG, stringWriter.toString());
            return false;
        }
    }

    private boolean isDeviceBlacklistedForOpenSLESUsage() {
        boolean deviceIsBlacklistedForOpenSLESUsage;
        if (blacklistDeviceForOpenSLESUsageIsOverridden) {
            deviceIsBlacklistedForOpenSLESUsage = blacklistDeviceForOpenSLESUsage;
        } else {
            deviceIsBlacklistedForOpenSLESUsage = WebRtcAudioUtils.deviceIsBlacklistedForOpenSLESUsage();
        }
        if (deviceIsBlacklistedForOpenSLESUsage) {
            RXLogging.i(TAG, Build.MODEL + " is blacklisted for OpenSL ES usage!");
        }
        return deviceIsBlacklistedForOpenSLESUsage;
    }

    private boolean isRecordShouldUseVoiceRecognition() {
        return Build.BRAND.equals("samsung");
    }

    private void refreshAudioParameters() {
        storeAudioParameters();
        nativeCacheAudioParameters(this.apiLevel, this.sampleRate, this.outputChannels, this.inputChannels, this.hardwareAEC, this.hardwareAGC, this.hardwareNS, this.lowLatencyOutput, this.lowLatencyInput, this.proAudio, this.aAudio, this.outputBufferSize, this.inputBufferSize, this.preferAudioLayer, this.nativeAudioManager);
    }

    private void storeAudioParameters() {
        this.apiLevel = Build.VERSION.SDK_INT;
        this.outputChannels = getStereoOutput() ? 2 : 1;
        this.inputChannels = getStereoInput() ? 2 : 1;
        this.sampleRate = getNativeOutputSampleRate();
        this.hardwareAEC = isAcousticEchoCancelerSupported();
        this.hardwareAGC = false;
        this.hardwareNS = isNoiseSuppressorSupported();
        this.lowLatencyOutput = isLowLatencyOutputSupported();
        this.lowLatencyInput = isLowLatencyInputSupported();
        this.proAudio = isProAudioSupported();
        this.aAudio = isAAudioSupported();
        this.outputBufferSize = this.lowLatencyOutput ? getLowLatencyOutputFramesPerBuffer() : getMinOutputFrameSize(this.sampleRate, this.outputChannels);
        this.inputBufferSize = this.lowLatencyInput ? getLowLatencyInputFramesPerBuffer() : getMinInputFrameSize(this.sampleRate, this.inputChannels);
        this.preferAudioLayer = getPreferAudioLayer();
    }

    private boolean hasEarpiece() {
        return ContextUtils.getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.telephony");
    }

    private boolean isLowLatencyOutputSupported() {
        return ContextUtils.getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
    }

    public boolean isLowLatencyInputSupported() {
        return isLowLatencyOutputSupported();
    }

    private boolean isProAudioSupported() {
        return ContextUtils.getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.audio.pro");
    }

    private boolean isAAudioSupported() {
        return Build.VERSION.SDK_INT >= 28;
    }

    private int getNativeOutputSampleRate() {
        if (WebRtcAudioUtils.runningOnEmulator()) {
            RXLogging.i(TAG, "Running emulator, overriding sample rate to 8 kHz.");
            return 8000;
        }
        if (WebRtcAudioUtils.isDefaultSampleRateOverridden()) {
            RXLogging.i(TAG, "Default sample rate is overriden to " + WebRtcAudioUtils.getDefaultSampleRateHz() + " Hz");
            return WebRtcAudioUtils.getDefaultSampleRateHz();
        }
        int defaultSampleRateHz = WebRtcAudioUtils.getDefaultSampleRateHz();
        RXLogging.i(TAG, "Sample rate is set to " + defaultSampleRateHz + " Hz");
        return defaultSampleRateHz;
    }

    private int getSampleRateForApiLevel() {
        String str;
        try {
            str = this.audioManager.getProperty("android.media.property.OUTPUT_SAMPLE_RATE");
        } catch (Exception e) {
            StringWriter stringWriter = new StringWriter();
            e.printStackTrace(new PrintWriter(stringWriter));
            RXLogging.e(TAG, stringWriter.toString());
            str = "";
        }
        if (str == null) {
            return WebRtcAudioUtils.getDefaultSampleRateHz();
        }
        return Integer.parseInt(str);
    }

    private int getLowLatencyOutputFramesPerBuffer() {
        String str;
        if (isLowLatencyOutputSupported()) {
            try {
                str = this.audioManager.getProperty("android.media.property.OUTPUT_FRAMES_PER_BUFFER");
            } catch (Exception e) {
                StringWriter stringWriter = new StringWriter();
                e.printStackTrace(new PrintWriter(stringWriter));
                RXLogging.e(TAG, stringWriter.toString());
                str = "";
            }
            if (str != null && Integer.parseInt(str) != 0) {
                return Integer.parseInt(str);
            }
        }
        return 256;
    }

    private static boolean isAcousticEchoCancelerSupported() {
        return WebRtcAudioEffects.canUseAcousticEchoCanceler();
    }

    private static boolean isNoiseSuppressorSupported() {
        return WebRtcAudioEffects.canUseNoiseSuppressor();
    }

    private static int getMinOutputFrameSize(int sampleRateInHz, int numChannels) {
        return AudioTrack.getMinBufferSize(sampleRateInHz, numChannels == 1 ? 4 : 12, 2) / (numChannels * 2);
    }

    private int getLowLatencyInputFramesPerBuffer() {
        return getLowLatencyOutputFramesPerBuffer();
    }

    private static int getMinInputFrameSize(int sampleRateInHz, int numChannels) {
        return AudioRecord.getMinBufferSize(sampleRateInHz, numChannels == 1 ? 16 : 12, 2) / (numChannels * 2);
    }

    private static void assertTrue(boolean condition) {
        if (!condition) {
            throw new AssertionError("Expected condition to be true");
        }
    }

    private boolean isPermissionGranted() {
        return WebRtcAudioUtils.isPermissionGranted();
    }

    private String getAudioDeviceInfo() {
        try {
            return "{ Audio State: audio mode: " + WebRtcAudioUtils.modeToString(this.audioManager.getMode()) + ", has mic: " + WebRtcAudioUtils.hasMicrophone() + ", music active: " + this.audioManager.isMusicActive() + ", speakerphone: " + this.audioManager.isSpeakerphoneOn() + ", headset: " + this.audioManager.isWiredHeadsetOn() + "BT SCO: " + this.audioManager.isBluetoothScoOn() + "music actived: " + this.audioManager.isMusicActive() + "permission: " + WebRtcAudioUtils.isPermissionGranted() + " bt_sco_available_off_call: " + this.audioManager.isBluetoothScoAvailableOffCall() + " }";
        } catch (Exception e) {
            StringWriter stringWriter = new StringWriter();
            e.printStackTrace(new PrintWriter(stringWriter));
            RXLogging.e(TAG, stringWriter.toString());
            return stringWriter.toString();
        }
    }

    private int getMode() {
        try {
            return this.audioManager.getMode();
        } catch (Exception e) {
            StringWriter stringWriter = new StringWriter();
            e.printStackTrace(new PrintWriter(stringWriter));
            RXLogging.e(TAG, stringWriter.toString());
            return -1;
        }
    }

    private int getFixedDevicePlayVolume() {
        try {
            int mode = this.audioManager.getMode();
            int i = 3;
            if (mode != 0) {
                if (mode == 1) {
                    i = 2;
                } else if (mode == 2 || mode == 3) {
                    i = 0;
                }
            }
            return (int) ((this.audioManager.getStreamVolume(i) * 100.0d) / this.audioManager.getStreamMaxVolume(i));
        } catch (Exception e) {
            StringWriter stringWriter = new StringWriter();
            e.printStackTrace(new PrintWriter(stringWriter));
            RXLogging.e(TAG, stringWriter.toString());
            return -1;
        }
    }

    private int getFixedDeviceRecordVolume() {
        return this.microphoneVolume;
    }

    private int[] getActiveRecordingSessionIds() {
        AudioManager audioManager = this.audioManager;
        if (audioManager == null) {
            return new int[0];
        }
        try {
            List<AudioRecordingConfiguration> activeRecordingConfigurations = audioManager.getActiveRecordingConfigurations();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < activeRecordingConfigurations.size(); i++) {
                AudioRecordingConfiguration audioRecordingConfiguration = activeRecordingConfigurations.get(i);
                if (audioRecordingConfiguration != null) {
                    arrayList.add(Integer.valueOf(audioRecordingConfiguration.getClientAudioSessionId()));
                }
            }
            int[] iArr = new int[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                iArr[i2] = ((Integer) arrayList.get(i2)).intValue();
            }
            return iArr;
        } catch (Throwable th) {
            th.printStackTrace();
            return new int[0];
        }
    }

    private int getMicrophoneMuteState() {
        try {
            return this.audioManager.isMicrophoneMute() ? 1 : 0;
        } catch (Exception e) {
            StringWriter stringWriter = new StringWriter();
            e.printStackTrace(new PrintWriter(stringWriter));
            RXLogging.e(TAG, stringWriter.toString());
            return -1;
        }
    }

    private void earBackInit() {
        if (this.mByteAudioEarback == null) {
            this.mByteAudioEarback = new WebRtcAudioEarBack(this);
        }
        this.mByteAudioEarback.ByteAudioEarBackInit();
    }

    private int earBackEnable(boolean enable) {
        WebRtcAudioEarBack webRtcAudioEarBack = this.mByteAudioEarback;
        if (webRtcAudioEarBack != null) {
            return webRtcAudioEarBack.ByteAudioEarBackEnable(enable);
        }
        return -1;
    }

    private int earBackSetVolume(int value) {
        WebRtcAudioEarBack webRtcAudioEarBack = this.mByteAudioEarback;
        if (webRtcAudioEarBack == null) {
            return 0;
        }
        webRtcAudioEarBack.ByteAudioEarBackSetVolume(value);
        return 0;
    }

    private int earBackSetEffect(int value) {
        WebRtcAudioEarBack webRtcAudioEarBack = this.mByteAudioEarback;
        if (webRtcAudioEarBack == null) {
            return 0;
        }
        webRtcAudioEarBack.ByteAudioEarBackEffect(value);
        return 0;
    }

    private int earBackSetEqualizer(int value) {
        WebRtcAudioEarBack webRtcAudioEarBack = this.mByteAudioEarback;
        if (webRtcAudioEarBack == null) {
            return 0;
        }
        webRtcAudioEarBack.ByteAudioEarBackEqualizer(value);
        return 0;
    }

    private int earBackGetLatency() {
        WebRtcAudioEarBack webRtcAudioEarBack = this.mByteAudioEarback;
        if (webRtcAudioEarBack != null) {
            return webRtcAudioEarBack.ByteAudioEarBackGetLatency();
        }
        return -1;
    }

    private boolean earBackGetIsSupport() {
        WebRtcAudioEarBack webRtcAudioEarBack = this.mByteAudioEarback;
        if (webRtcAudioEarBack != null) {
            return webRtcAudioEarBack.ByteAudioEarBackSupport();
        }
        return false;
    }

    public void onHardwareEarbackSupported(boolean isSupported) {
        synchronized (this) {
            long j = this.nativeAudioManager;
            if (j != 0) {
                nativeOnHardwareEarbackSupported(isSupported, j);
            }
        }
    }

    public void onHardwareEarbackSupportParamsGet(String params) {
        synchronized (this) {
            long j = this.nativeAudioManager;
            if (j != 0) {
                nativeOnHardwareEarbackSupportParamsGet(params, j);
            }
        }
    }

    public void onHardwareEarbackReleased(boolean success) {
        synchronized (this) {
            long j = this.nativeAudioManager;
            if (j != 0) {
                nativeOnHardwareEarbackReleased(success, j);
            }
        }
    }

    public void notifyEarbackRecordStateChanged(boolean recordStart) {
        WebRtcAudioEarBack webRtcAudioEarBack = this.mByteAudioEarback;
        if (webRtcAudioEarBack != null) {
            webRtcAudioEarBack.notifyEarbackRecordStateChanged(recordStart);
        }
    }
}
