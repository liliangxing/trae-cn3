package com.ss.bytertc.audio.device.hwearback;

import com.bytedance.realx.base.ContextUtils;
import com.bytedance.realx.base.RXLogging;
import com.ss.android.pushmanager.PushCommonConstants;
import com.ss.bytertc.audio.device.router.device.VivoKTVHelper;
import com.ss.bytertc.audio.device.webrtc.WebRtcAudioEarBack;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class VivoEarback implements IHardWareEarback {
    private static final String TAG = "com.ss.bytertc.audio.device.hwearback.VivoEarback";
    private boolean isKtvDeviceOpened = false;
    private SlientPlayer slientPlayer;
    private VivoKTVHelper vivoKtvHelper;
    private WebRtcAudioEarBack webRtcAudioEarBack;

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int getLatency() {
        return -1;
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public void notifyEarbackRecordStateChanged(boolean recordStart) {
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int setEqualizer(int value) {
        return -1;
    }

    public VivoEarback(WebRtcAudioEarBack earBack) {
        this.webRtcAudioEarBack = earBack;
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int init() {
        this.vivoKtvHelper = new VivoKTVHelper(ContextUtils.getApplicationContext());
        SlientPlayer slientPlayer = new SlientPlayer();
        this.slientPlayer = slientPlayer;
        slientPlayer.setRequireDeepBuffer(false);
        boolean isSupport = isSupport();
        WebRtcAudioEarBack webRtcAudioEarBack = this.webRtcAudioEarBack;
        if (webRtcAudioEarBack != null) {
            webRtcAudioEarBack.onHardwareEarbackSupported(isSupport);
        }
        printLog("inited, isSupportHardwareEarback=" + isSupport);
        return 0;
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int release() {
        printLog("release");
        if (this.vivoKtvHelper != null) {
            close();
            this.vivoKtvHelper.closeKTVDevice();
            this.isKtvDeviceOpened = false;
        }
        return 0;
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public boolean isSupport() {
        VivoKTVHelper vivoKTVHelper = this.vivoKtvHelper;
        if (vivoKTVHelper != null) {
            return vivoKTVHelper.isDeviceSupportKaraoke();
        }
        return false;
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int open() {
        VivoKTVHelper vivoKTVHelper = this.vivoKtvHelper;
        if (vivoKTVHelper == null || this.slientPlayer == null) {
            return -1;
        }
        if (!this.isKtvDeviceOpened && vivoKTVHelper.isDeviceSupportKaraoke()) {
            this.vivoKtvHelper.openKTVDevice();
            this.isKtvDeviceOpened = true;
        }
        printLog(PushCommonConstants.VALUE_OPEN);
        this.slientPlayer.play();
        this.vivoKtvHelper.setPlayFeedbackParam(1);
        return 0;
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int close() {
        if (this.vivoKtvHelper == null || this.slientPlayer == null) {
            return -1;
        }
        printLog(PushCommonConstants.VALUE_CLOSE);
        this.slientPlayer.stop();
        this.vivoKtvHelper.setPlayFeedbackParam(0);
        this.vivoKtvHelper.setCustomMode(0);
        return 0;
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int setEffect(int value) {
        if (this.vivoKtvHelper != null) {
            printLog("setEffect value=" + value);
            if (value >= 0 && value <= this.vivoKtvHelper.getEffectSize()) {
                this.vivoKtvHelper.setCustomMode(value);
                return 0;
            }
            RXLogging.w(TAG, String.format("ByteAudioEarBackEffect vivo valid is [%d,%d], value is %d, ignore it", 0, Integer.valueOf(this.vivoKtvHelper.getEffectSize()), Integer.valueOf(value)));
        }
        return -1;
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int setVolume(int volume) {
        if (this.vivoKtvHelper == null) {
            return -1;
        }
        printLog("setVolume volume=" + volume);
        this.vivoKtvHelper.setMicVolParam((int) ((volume * 15.0d) / 100.0d));
        return 0;
    }

    private void printLog(String message) {
        String str = TAG;
        RXLogging.i(str, str + Constants.COLON_SEPARATOR + message);
    }
}
