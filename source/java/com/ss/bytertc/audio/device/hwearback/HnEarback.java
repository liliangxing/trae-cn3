package com.ss.bytertc.audio.device.hwearback;

import com.ss.bytertc.audio.device.router.device.HnEarBackDeviceSupport;
import com.ss.bytertc.audio.device.webrtc.WebRtcAudioEarBack;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class HnEarback implements IHardWareEarback {
    private HnEarBackDeviceSupport hnEarback;

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public void notifyEarbackRecordStateChanged(boolean recordStart) {
    }

    public HnEarback(WebRtcAudioEarBack earBack) {
        this.hnEarback = null;
        this.hnEarback = new HnEarBackDeviceSupport(earBack);
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int init() {
        this.hnEarback.HnInitAudioClient();
        return 0;
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int release() {
        close();
        this.hnEarback.HnDestroy();
        return 0;
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public boolean isSupport() {
        return this.hnEarback.HnIsEarReturnSupport();
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int open() {
        return this.hnEarback.HnEnableEarReturn(true);
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int close() {
        return this.hnEarback.HnEnableEarReturn(false);
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int setEffect(int value) {
        return this.hnEarback.HnSetEffectMode(value);
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int setEqualizer(int value) {
        return this.hnEarback.HnSetEqualizer(value);
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int setVolume(int volume) {
        return this.hnEarback.HnSetVocalVolume(volume);
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int getLatency() {
        return this.hnEarback.HnGetLatency();
    }
}
