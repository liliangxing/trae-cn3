package com.ss.bytertc.audio.device.hwearback;

import com.ss.bytertc.audio.device.router.device.HWEarBackDeviceSupport;
import com.ss.bytertc.audio.device.webrtc.WebRtcAudioEarBack;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class HwEarback implements IHardWareEarback {
    private HWEarBackDeviceSupport hwEarback;

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public void notifyEarbackRecordStateChanged(boolean recordStart) {
    }

    public HwEarback(WebRtcAudioEarBack earBack) {
        this.hwEarback = null;
        this.hwEarback = new HWEarBackDeviceSupport(earBack);
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int init() {
        this.hwEarback.HWEarBack_init();
        return 0;
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int release() {
        close();
        this.hwEarback.HWDestroy();
        return 0;
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public boolean isSupport() {
        return this.hwEarback.HWGetKaraokeSupport();
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int open() {
        return this.hwEarback.HWEnableKaraoke(true);
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int close() {
        return this.hwEarback.HWEnableKaraoke(false);
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int setEffect(int value) {
        return this.hwEarback.HWSetEffectMode(value);
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int setEqualizer(int value) {
        return this.hwEarback.HWSetEqualizerMode(value);
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int setVolume(int volume) {
        return this.hwEarback.setVolume(volume);
    }

    @Override // com.ss.bytertc.audio.device.hwearback.IHardWareEarback
    public int getLatency() {
        return this.hwEarback.getLatency();
    }
}
