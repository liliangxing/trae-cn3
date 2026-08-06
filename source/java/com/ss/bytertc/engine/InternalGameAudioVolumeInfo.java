package com.ss.bytertc.engine;

/* loaded from: classes7.dex */
public class InternalGameAudioVolumeInfo {
    public String userId;
    public int volume;

    public InternalGameAudioVolumeInfo(String userId, int volume) {
        this.userId = userId;
        this.volume = volume;
    }

    private static InternalGameAudioVolumeInfo create(String userId, int volume) {
        return new InternalGameAudioVolumeInfo(userId, volume);
    }
}
