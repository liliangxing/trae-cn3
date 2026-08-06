package com.ss.bytertc.audio.device.router.device;

import com.bytedance.realx.base.ContextUtils;
import com.bytedance.realx.base.RXLogging;
import com.hihonor.android.magicx.media.audio.interfaces.HnAudioClient;
import com.hihonor.android.magicx.media.audio.interfaces.HnEarReturnClient;
import com.hihonor.android.magicx.media.audio.interfaces.IAudioServiceCallback;
import com.ss.bytertc.audio.device.webrtc.WebRtcAudioEarBack;
import java.util.Iterator;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class HnEarBackDeviceSupport implements IAudioServiceCallback {
    private static final String TAG = "HnEarBackDeviceSupport";
    private WebRtcAudioEarBack earBack;
    private HnAudioClient mHnAudioClient = null;
    private HnEarReturnClient mHnEarReturnClient = null;
    private boolean mIsAudiokitBindSuccess = false;
    private boolean mIsEarReturnBindSuccess = false;

    public int HnGetLatency() {
        return -1;
    }

    public HnEarBackDeviceSupport(WebRtcAudioEarBack webRtcAudioEarBack) {
        this.earBack = webRtcAudioEarBack;
    }

    public void onResult(int resultCode) {
        printLog(String.format("onResult result=%d", Integer.valueOf(resultCode)));
        if (resultCode == 0) {
            HnInitHnEarReturnClient();
            this.mIsAudiokitBindSuccess = true;
            return;
        }
        if (resultCode == 2) {
            this.mIsEarReturnBindSuccess = false;
            this.mIsAudiokitBindSuccess = false;
            onDeviceSupported(false);
            return;
        }
        if (resultCode != 4) {
            if (resultCode != 1003) {
                if (resultCode == 1806) {
                    onDeviceSupported(false);
                    return;
                }
                if (resultCode != 6) {
                    if (resultCode == 7) {
                        onDeviceSupported(false);
                        return;
                    } else if (resultCode == 1000) {
                        this.mIsEarReturnBindSuccess = true;
                        HnSetVocalVolume(90);
                        onDeviceSupported(HnIsEarReturnSupport());
                        return;
                    } else if (resultCode != 1001) {
                        return;
                    }
                }
            }
            this.mIsEarReturnBindSuccess = false;
            return;
        }
        this.mIsAudiokitBindSuccess = false;
    }

    public void HnInitAudioClient() {
        if (HnAudioClient.isDeviceSupported(ContextUtils.getApplicationContext())) {
            printLog("HnInitAudioClient");
            HnAudioClient hnAudioClient = new HnAudioClient(ContextUtils.getApplicationContext(), this);
            this.mHnAudioClient = hnAudioClient;
            hnAudioClient.initialize();
            return;
        }
        onDeviceSupported(false);
    }

    public void HnInitHnEarReturnClient() {
        if (this.mHnAudioClient == null) {
            return;
        }
        printLog("HnInitHnEarReturnClient");
        List supportedServices = this.mHnAudioClient.getSupportedServices();
        if (supportedServices != null && supportedServices.size() > 0) {
            Iterator it = supportedServices.iterator();
            while (it.hasNext()) {
                if (((Integer) it.next()).intValue() == HnAudioClient.ServiceType.HNAUDIO_SERVICE_EARRETURN.getServiceType()) {
                    this.mHnEarReturnClient = this.mHnAudioClient.createService(HnAudioClient.ServiceType.HNAUDIO_SERVICE_EARRETURN);
                    return;
                }
            }
        }
        printLog("service != HnAudioClient.ServiceType.HNAUDIO_SERVICE_EARRETURN.getServiceType()");
        onDeviceSupported(false);
    }

    public boolean HnIsEarReturnSupport() {
        if (this.mHnEarReturnClient == null || !this.mIsEarReturnBindSuccess) {
            return false;
        }
        printLog("HnIsEarReturnSupport: false");
        return this.mHnEarReturnClient.isServiceSupported();
    }

    public int HnEnableEarReturn(boolean isEnable) {
        if (this.mHnEarReturnClient == null || !this.mIsEarReturnBindSuccess) {
            return -1;
        }
        printLog("HnEnableEarReturn=" + isEnable);
        return this.mHnEarReturnClient.enableEarReturn(isEnable);
    }

    public int HnSetEffectMode(int value) {
        if (this.mHnEarReturnClient == null || !this.mIsEarReturnBindSuccess) {
            return -1;
        }
        printLog("HnSetEffectMode=" + value);
        return this.mHnEarReturnClient.setParameter(HnEarReturnClient.ParameName.CMD_SET_AUDIO_EFFECT_MODE_BASE, value);
    }

    public int HnSetVocalVolume(int value) {
        if (this.mHnEarReturnClient == null || !this.mIsEarReturnBindSuccess) {
            return -1;
        }
        printLog("HnSetVocalVolume=" + value);
        return this.mHnEarReturnClient.setParameter(HnEarReturnClient.ParameName.CMD_SET_VOCAL_VOLUME_BASE, value);
    }

    public int HnSetEqualizer(int value) {
        if (this.mHnEarReturnClient == null || !this.mIsEarReturnBindSuccess) {
            return -1;
        }
        printLog("HnSetEqualizer=" + value);
        return this.mHnEarReturnClient.setParameter(HnEarReturnClient.ParameName.CMD_SET_VOCAL_EQUALIZER_MODE, value);
    }

    public void HnDestroy() {
        printLog("HnDestroy");
        HnAudioClient hnAudioClient = this.mHnAudioClient;
        if (hnAudioClient != null) {
            hnAudioClient.destroy();
            this.mHnAudioClient = null;
        }
        HnEarReturnClient hnEarReturnClient = this.mHnEarReturnClient;
        if (hnEarReturnClient != null) {
            hnEarReturnClient.destroy();
            this.mHnEarReturnClient = null;
        }
        this.mIsEarReturnBindSuccess = false;
    }

    public void onDeviceSupported(boolean isSupport) {
        if (this.earBack != null) {
            printLog("Hn onDeviceSupported: " + isSupport);
            this.earBack.onHardwareEarbackSupported(isSupport);
        }
    }

    private void printLog(String message) {
        RXLogging.i(TAG, "HnEarBackDeviceSupport:" + message);
    }
}
