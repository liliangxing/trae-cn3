package com.ss.bytertc.engine;

/* loaded from: classes7.dex */
public class InternalAudioVolumeInfo {
    public int linearVolume;
    public int nonlinearVolume;
    public int smoothVolume;
    public String uid;

    public InternalAudioVolumeInfo(String uid, int linearVolume, int nonlinearVolume) {
        this.uid = uid;
        this.linearVolume = linearVolume;
        this.nonlinearVolume = nonlinearVolume;
    }

    private static InternalAudioVolumeInfo create(String uid, int linearVolume, int nonlinearVolume) {
        return new InternalAudioVolumeInfo(uid, linearVolume, nonlinearVolume);
    }
}
