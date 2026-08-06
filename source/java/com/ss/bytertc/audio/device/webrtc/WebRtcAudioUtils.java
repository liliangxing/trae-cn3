package com.ss.bytertc.audio.device.webrtc;

import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.bytedance.realx.base.ContextUtils;
import com.bytedance.realx.base.RXLogging;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes7.dex */
public final class WebRtcAudioUtils {
    private static final String RO_PRODUCT_BRAND = "ro.product.brand";
    private static final String RO_VIVO_OS_BUILD_DISPLAY_ID = "ro.vivo.os.build.display.id";
    private static final String RO_VIVO_OS_PRODUCT_VERSION = "ro.vivo.product.version";
    private static final String TAG = "WebRtcAudioUtils";
    private static boolean isDefaultSampleRateOverridden;
    private static final String[] BLACKLISTED_OPEN_SL_ES_MODELS = {"SM-G9650", "SM-G9750", "SM-N9600", "V1962A"};
    private static final String[] BLACKLISTED_AEC_MODELS = new String[0];
    private static final String[] BLACKLISTED_NS_MODELS = new String[0];
    private static final int DEFAULT_SAMPLE_RATE_HZ = 16000;
    private static int defaultSampleRateHz = DEFAULT_SAMPLE_RATE_HZ;
    private static boolean useWebRtcBasedAcousticEchoCanceler = false;
    private static boolean useWebRtcBasedNoiseSuppressor = false;

    private static String deviceTypeToString(int type) {
        switch (type) {
            case 1:
                return "TYPE_BUILTIN_EARPIECE";
            case 2:
                return "TYPE_BUILTIN_SPEAKER";
            case 3:
                return "TYPE_WIRED_HEADSET";
            case 4:
                return "TYPE_WIRED_HEADPHONES";
            case 5:
                return "TYPE_LINE_ANALOG";
            case 6:
                return "TYPE_LINE_DIGITAL";
            case 7:
                return "TYPE_BLUETOOTH_SCO";
            case 8:
                return "TYPE_BLUETOOTH_A2DP";
            case 9:
                return "TYPE_HDMI";
            case 10:
                return "TYPE_HDMI_ARC";
            case 11:
                return "TYPE_USB_DEVICE";
            case 12:
                return "TYPE_USB_ACCESSORY";
            case 13:
                return "TYPE_DOCK";
            case 14:
                return "TYPE_FM";
            case 15:
                return "TYPE_BUILTIN_MIC";
            case 16:
                return "TYPE_FM_TUNER";
            case 17:
                return "TYPE_TV_TUNER";
            case 18:
                return "TYPE_TELEPHONY";
            case 19:
                return "TYPE_AUX_LINE";
            case 20:
                return "TYPE_IP";
            case 21:
                return "TYPE_BUS";
            case 22:
                return "TYPE_USB_HEADSET";
            default:
                return "TYPE_UNKNOWN";
        }
    }

    public static boolean isAutomaticGainControlSupported() {
        return false;
    }

    public static String modeToString(int mode) {
        return mode != 0 ? mode != 1 ? mode != 2 ? mode != 3 ? "MODE_INVALID" : "MODE_IN_COMMUNICATION" : "MODE_IN_CALL" : "MODE_RINGTONE" : "MODE_NORMAL";
    }

    private static String streamTypeToString(int stream) {
        return stream != 0 ? stream != 1 ? stream != 2 ? stream != 3 ? stream != 4 ? stream != 5 ? "STREAM_INVALID" : "STREAM_NOTIFICATION" : "STREAM_ALARM" : "STREAM_MUSIC" : "STREAM_RING" : "STREAM_SYSTEM" : "STREAM_VOICE_CALL";
    }

    public static synchronized void setWebRtcBasedAcousticEchoCanceler(boolean enable) {
        synchronized (WebRtcAudioUtils.class) {
            useWebRtcBasedAcousticEchoCanceler = enable;
        }
    }

    public static synchronized void setWebRtcBasedNoiseSuppressor(boolean enable) {
        synchronized (WebRtcAudioUtils.class) {
            useWebRtcBasedNoiseSuppressor = enable;
        }
    }

    public static synchronized void setWebRtcBasedAutomaticGainControl(boolean enable) {
        synchronized (WebRtcAudioUtils.class) {
            RXLogging.w(TAG, "setWebRtcBasedAutomaticGainControl() is deprecated");
        }
    }

    public static synchronized boolean useWebRtcBasedAcousticEchoCanceler() {
        boolean z;
        synchronized (WebRtcAudioUtils.class) {
            if (useWebRtcBasedAcousticEchoCanceler) {
                RXLogging.w(TAG, "Overriding default behavior; now using WebRTC AEC!");
            }
            z = useWebRtcBasedAcousticEchoCanceler;
        }
        return z;
    }

    public static synchronized boolean useWebRtcBasedNoiseSuppressor() {
        boolean z;
        synchronized (WebRtcAudioUtils.class) {
            if (useWebRtcBasedNoiseSuppressor) {
                RXLogging.w(TAG, "Overriding default behavior; now using WebRTC NS!");
            }
            z = useWebRtcBasedNoiseSuppressor;
        }
        return z;
    }

    public static synchronized boolean useWebRtcBasedAutomaticGainControl() {
        synchronized (WebRtcAudioUtils.class) {
        }
        return true;
    }

    public static boolean isAcousticEchoCancelerSupported() {
        return WebRtcAudioEffects.canUseAcousticEchoCanceler();
    }

    public static boolean isNoiseSuppressorSupported() {
        return WebRtcAudioEffects.canUseNoiseSuppressor();
    }

    public static synchronized void setDefaultSampleRateHz(int sampleRateHz) {
        synchronized (WebRtcAudioUtils.class) {
            isDefaultSampleRateOverridden = true;
            defaultSampleRateHz = sampleRateHz;
        }
    }

    public static synchronized boolean isDefaultSampleRateOverridden() {
        boolean z;
        synchronized (WebRtcAudioUtils.class) {
            z = isDefaultSampleRateOverridden;
        }
        return z;
    }

    public static synchronized int getDefaultSampleRateHz() {
        int i;
        synchronized (WebRtcAudioUtils.class) {
            i = defaultSampleRateHz;
        }
        return i;
    }

    public static List<String> getBlackListedModelsForAecUsage() {
        return Arrays.asList(BLACKLISTED_AEC_MODELS);
    }

    public static List<String> getBlackListedModelsForNsUsage() {
        return Arrays.asList(BLACKLISTED_NS_MODELS);
    }

    public static String getThreadInfo() {
        return "@[name=" + Thread.currentThread().getName() + ", id=" + Thread.currentThread().getId() + "]";
    }

    public static boolean runningOnEmulator() {
        return Build.HARDWARE.equals("goldfish") && Build.BRAND.startsWith("generic_");
    }

    public static boolean deviceIsBlacklistedForOpenSLESUsage() {
        return Arrays.asList(BLACKLISTED_OPEN_SL_ES_MODELS).contains(Build.MODEL);
    }

    public static void logAudioState(String tag) {
        AudioManager audioManager = (AudioManager) ContextUtils.getApplicationContext().getSystemService("audio");
        if (audioManager != null) {
            logAudioStateBasic(tag, audioManager);
        }
    }

    private static void logAudioStateBasic(String tag, AudioManager audioManager) {
        RXLogging.i(tag, "Audio State: audio mode: " + modeToString(audioManager.getMode()) + ", has mic: " + hasMicrophone() + ", mic muted: " + audioManager.isMicrophoneMute() + ", music active: " + audioManager.isMusicActive() + ", speakerphone: " + audioManager.isSpeakerphoneOn() + ", BT SCO: " + audioManager.isBluetoothScoOn());
    }

    private static boolean isVolumeFixed(AudioManager audioManager) {
        return audioManager.isVolumeFixed();
    }

    private static void logAudioStateVolume(String tag, AudioManager audioManager) {
        int[] iArr = {0, 3, 2, 4, 5, 1};
        RXLogging.i(tag, "Audio State: ");
        boolean isVolumeFixed = isVolumeFixed(audioManager);
        RXLogging.i(tag, "  fixed volume=" + isVolumeFixed);
        if (isVolumeFixed) {
            return;
        }
        for (int i = 0; i < 6; i++) {
            int i2 = iArr[i];
            StringBuilder sb = new StringBuilder();
            sb.append("  " + streamTypeToString(i2) + ": ");
            sb.append("volume=").append(audioManager.getStreamVolume(i2));
            sb.append(", max=").append(audioManager.getStreamMaxVolume(i2));
            logIsStreamMute(tag, audioManager, i2, sb);
            RXLogging.i(tag, sb.toString());
        }
    }

    private static void logIsStreamMute(String tag, AudioManager audioManager, int stream, StringBuilder info) {
        info.append(", muted=").append(audioManager.isStreamMute(stream));
    }

    private static void logAudioDeviceInfo(String tag, AudioManager audioManager) {
        AudioDeviceInfo[] devices = audioManager.getDevices(3);
        if (devices.length == 0) {
            return;
        }
        RXLogging.i(tag, "Audio Devices: ");
        for (AudioDeviceInfo audioDeviceInfo : devices) {
            StringBuilder sb = new StringBuilder("  ");
            sb.append(deviceTypeToString(audioDeviceInfo.getType()));
            sb.append(audioDeviceInfo.isSource() ? "(in): " : "(out): ");
            if (audioDeviceInfo.getChannelCounts().length > 0) {
                sb.append("channels=").append(Arrays.toString(audioDeviceInfo.getChannelCounts()));
                sb.append(", ");
            }
            if (audioDeviceInfo.getEncodings().length > 0) {
                sb.append("encodings=").append(Arrays.toString(audioDeviceInfo.getEncodings()));
                sb.append(", ");
            }
            if (audioDeviceInfo.getSampleRates().length > 0) {
                sb.append("sample rates=").append(Arrays.toString(audioDeviceInfo.getSampleRates()));
                sb.append(", ");
            }
            sb.append("id=").append(audioDeviceInfo.getId());
            RXLogging.i(tag, sb.toString());
        }
    }

    public static boolean isPermissionGranted() {
        return ContextCompat.checkSelfPermission(ContextUtils.getApplicationContext(), "android.permission.RECORD_AUDIO") == 0;
    }

    public static boolean hasMicrophone() {
        return ContextUtils.getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.microphone");
    }

    private static String getSystemProperty(String key) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, key, "");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String getVivoRomVersion() {
        return getSystemProperty(RO_VIVO_OS_BUILD_DISPLAY_ID) + "_" + getSystemProperty(RO_VIVO_OS_PRODUCT_VERSION);
    }

    public static String getRomVersion(String brand) {
        return brand.toLowerCase().equals("vivo") ? getVivoRomVersion() : "";
    }

    public static String getProductBrand() {
        return getSystemProperty("ro.product.brand");
    }
}
