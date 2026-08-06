package com.ss.bytertc.engine.type;

import com.ss.bytertc.engine.InternalAudioVolumeInfo;

/* loaded from: classes7.dex */
public class AudioVolumeInfo {
    public int linearVolume;
    public int nonlinearVolume;
    public String uid;

    public AudioVolumeInfo(String uid, int nonlinearVolume, int linearVolume) {
        this.uid = uid;
        this.nonlinearVolume = nonlinearVolume;
        this.linearVolume = linearVolume;
    }

    public AudioVolumeInfo(InternalAudioVolumeInfo internalInfo) {
        this.uid = internalInfo.uid;
        this.nonlinearVolume = internalInfo.nonlinearVolume;
        this.linearVolume = internalInfo.linearVolume;
    }

    public String toString() {
        return "AudioVolumeInfo{ user_id= '" + this.uid + "' linear_volume= '" + this.linearVolume + "' nonlinear_volume= '" + this.nonlinearVolume + "'}";
    }
}
