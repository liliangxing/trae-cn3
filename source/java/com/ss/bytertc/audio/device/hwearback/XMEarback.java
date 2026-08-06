package com.ss.bytertc.audio.device.hwearback;

import com.bytedance.realx.base.ContextUtils;
import com.ss.bytertc.audio.device.router.device.KaraokeMediaHelper;
import com.ss.bytertc.audio.device.webrtc.WebRtcAudioEarBack;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class XMEarback implements IHardWareEarback {
    private boolean isKtvDeviceOpened = false;
    private SlientPlayer slientPlayer;
    private WebRtcAudioEarBack webRtcAudioEarBack;
    private KaraokeMediaHelper xmKtvHelper;

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

    public XMEarback(WebRtcAudioEarBack earBack) {
        this.webRtcAudioEarBack = earBack;
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int init() {
        this.xmKtvHelper = new KaraokeMediaHelper(ContextUtils.getApplicationContext());
        this.slientPlayer = new SlientPlayer();
        WebRtcAudioEarBack webRtcAudioEarBack = this.webRtcAudioEarBack;
        if (webRtcAudioEarBack == null) {
            return 0;
        }
        webRtcAudioEarBack.onHardwareEarbackSupported(isSupport());
        return 0;
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int release() {
        if (this.xmKtvHelper != null) {
            close();
            this.xmKtvHelper.closeKTVDevice();
            this.isKtvDeviceOpened = false;
        }
        return 0;
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public boolean isSupport() {
        KaraokeMediaHelper karaokeMediaHelper;
        return ContextUtils.getApplicationContext() != null && (karaokeMediaHelper = this.xmKtvHelper) != null && karaokeMediaHelper.isDeviceSupportKaraoke() && this.xmKtvHelper.isAppSupportKaraoke(ContextUtils.getApplicationContext().getPackageName());
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int open() {
        if (this.xmKtvHelper == null || this.slientPlayer == null) {
            return -1;
        }
        if (!this.isKtvDeviceOpened && isSupport()) {
            this.xmKtvHelper.openKTVDevice();
            this.isKtvDeviceOpened = true;
        }
        this.slientPlayer.play();
        this.xmKtvHelper.setPlayFeedbackParam(1);
        return 0;
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int close() {
        SlientPlayer slientPlayer;
        if (this.xmKtvHelper == null || (slientPlayer = this.slientPlayer) == null) {
            return -1;
        }
        slientPlayer.stop();
        this.xmKtvHelper.setPlayFeedbackParam(0);
        return 0;
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int setEffect(int value) {
        KaraokeMediaHelper karaokeMediaHelper = this.xmKtvHelper;
        if (karaokeMediaHelper == null) {
            return -1;
        }
        karaokeMediaHelper.setFeedbackEffect(value);
        return 0;
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int setVolume(int volume) {
        KaraokeMediaHelper karaokeMediaHelper = this.xmKtvHelper;
        if (karaokeMediaHelper == null) {
            return -1;
        }
        karaokeMediaHelper.setMicVolParam((int) ((volume * 15.0d) / 100.0d));
        return 0;
    }
}
