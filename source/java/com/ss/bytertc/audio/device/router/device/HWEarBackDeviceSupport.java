package com.ss.bytertc.audio.device.router.device;

import com.bytedance.realx.base.ContextUtils;
import com.bytedance.realx.base.RXLogging;
import com.huawei.multimedia.audiokit.interfaces.HwAudioKaraokeFeatureKit;
import com.huawei.multimedia.audiokit.interfaces.HwAudioKit;
import com.huawei.multimedia.audiokit.interfaces.IAudioKitCallback;
import com.ss.bytertc.audio.device.webrtc.WebRtcAudioEarBack;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class HWEarBackDeviceSupport implements IAudioKitCallback {
    private static final String TAG = "HWEarBackDeviceSupport";
    private WebRtcAudioEarBack earBack;
    private HwAudioKaraokeFeatureKit mHwAudioKaraokeFeatureKit;
    private HwAudioKit mHwAudioKit;
    private String mResultType = "";
    private boolean mIsAudiokitBindSuccess = false;
    private boolean mIsAudiokitKaraokeBindSuccess = false;
    private boolean mSupportLowLatencyEarBack = true;

    public void onResult(int resultType) {
        printLog(String.format("onResult result=%d", Integer.valueOf(resultType)));
        if (resultType == 0) {
            initKaraokeFeature();
            this.mIsAudiokitBindSuccess = true;
            return;
        }
        if (resultType == 2) {
            this.mIsAudiokitBindSuccess = false;
            this.mIsAudiokitKaraokeBindSuccess = false;
            onDeviceSupported(false);
            return;
        }
        if (resultType == 4 || resultType == 6) {
            this.mIsAudiokitBindSuccess = false;
            return;
        }
        if (resultType != 1003) {
            if (resultType == 1806) {
                onDeviceSupported(false);
                return;
            } else if (resultType == 1000) {
                this.mIsAudiokitKaraokeBindSuccess = true;
                setVolume(90);
                onDeviceSupported(HWGetKaraokeSupport());
                return;
            } else if (resultType != 1001) {
                return;
            }
        }
        this.mIsAudiokitKaraokeBindSuccess = false;
    }

    public HWEarBackDeviceSupport(WebRtcAudioEarBack webRtcAudioEarBack) {
        this.earBack = webRtcAudioEarBack;
    }

    private void initAudioKit() {
        if (this.mIsAudiokitBindSuccess && this.mIsAudiokitKaraokeBindSuccess) {
            onDeviceSupported(HWGetKaraokeSupport());
            return;
        }
        HwAudioKit hwAudioKit = new HwAudioKit(ContextUtils.getApplicationContext(), this);
        this.mHwAudioKit = hwAudioKit;
        hwAudioKit.initialize();
    }

    private void initKaraokeFeature() {
        HwAudioKit hwAudioKit = this.mHwAudioKit;
        if (hwAudioKit != null) {
            this.mHwAudioKaraokeFeatureKit = hwAudioKit.createFeature(HwAudioKit.FeatureType.HWAUDIO_FEATURE_KARAOKE);
        }
    }

    public void HWEarBack_init() {
        printLog("HWEarBack_init");
        initAudioKit();
    }

    public void HWDestroy() {
        if (!this.mIsAudiokitBindSuccess || this.mHwAudioKit == null) {
            return;
        }
        printLog("HWDestroy");
        HwAudioKaraokeFeatureKit hwAudioKaraokeFeatureKit = this.mHwAudioKaraokeFeatureKit;
        if (hwAudioKaraokeFeatureKit != null) {
            hwAudioKaraokeFeatureKit.destroy();
            this.mIsAudiokitKaraokeBindSuccess = false;
        }
        this.mHwAudioKit.destroy();
        this.mIsAudiokitBindSuccess = false;
    }

    public int HWEnableKaraoke(boolean enable) {
        if (this.mHwAudioKaraokeFeatureKit == null || !this.mIsAudiokitKaraokeBindSuccess) {
            return -1;
        }
        printLog("HWEnableKaraoke enable=" + enable);
        return this.mHwAudioKaraokeFeatureKit.enableKaraokeFeature(enable);
    }

    public boolean HWGetKaraokeSupport() {
        HwAudioKaraokeFeatureKit hwAudioKaraokeFeatureKit = this.mHwAudioKaraokeFeatureKit;
        if (hwAudioKaraokeFeatureKit == null || !this.mIsAudiokitKaraokeBindSuccess) {
            return false;
        }
        return hwAudioKaraokeFeatureKit.isKaraokeFeatureSupport();
    }

    public int HWSetEffectMode(int value) {
        if (this.mHwAudioKaraokeFeatureKit == null || !this.mIsAudiokitKaraokeBindSuccess) {
            return -1;
        }
        printLog("HWSetEffectMode value=" + value);
        return this.mHwAudioKaraokeFeatureKit.setParameter(HwAudioKaraokeFeatureKit.ParameName.CMD_SET_AUDIO_EFFECT_MODE_BASE, value);
    }

    public int HWSetEqualizerMode(int value) {
        if (this.mHwAudioKaraokeFeatureKit == null || !this.mIsAudiokitKaraokeBindSuccess) {
            return -1;
        }
        printLog("HWSetEqualizerMode value=" + value);
        return this.mHwAudioKaraokeFeatureKit.setParameter(HwAudioKaraokeFeatureKit.ParameName.CMD_SET_VOCAL_EQUALIZER_MODE, value);
    }

    public int setVolume(int value) {
        if (this.mHwAudioKaraokeFeatureKit == null || !this.mIsAudiokitKaraokeBindSuccess) {
            return -1;
        }
        printLog("setVolume volome=" + value);
        return this.mHwAudioKaraokeFeatureKit.setParameter(HwAudioKaraokeFeatureKit.ParameName.CMD_SET_VOCAL_VOLUME_BASE, value);
    }

    public int getLatency() {
        HwAudioKaraokeFeatureKit hwAudioKaraokeFeatureKit = this.mHwAudioKaraokeFeatureKit;
        if (hwAudioKaraokeFeatureKit == null || !this.mIsAudiokitKaraokeBindSuccess) {
            return -1;
        }
        return hwAudioKaraokeFeatureKit.getKaraokeLatency();
    }

    public void onDeviceSupported(boolean isSupported) {
        WebRtcAudioEarBack webRtcAudioEarBack = this.earBack;
        if (webRtcAudioEarBack != null) {
            webRtcAudioEarBack.onHardwareEarbackSupported(isSupported);
        }
    }

    private void printLog(String message) {
        RXLogging.i(TAG, "HWEarBackDeviceSupport:" + message);
    }
}
