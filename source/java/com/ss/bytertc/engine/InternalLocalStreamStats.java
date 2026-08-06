package com.ss.bytertc.engine;

/* loaded from: classes7.dex */
public class InternalLocalStreamStats {
    public InternalLocalAudioStats audioStats;
    public boolean isScreen;
    public int rxQuality;
    public int txQuality;
    public InternalLocalVideoStats videoStats;

    public InternalLocalStreamStats() {
    }

    public InternalLocalStreamStats(InternalLocalAudioStats audioStats, InternalLocalVideoStats videoStats, boolean isScreen, int txQuality, int rxQuality) {
        this.audioStats = audioStats;
        this.videoStats = videoStats;
        this.isScreen = isScreen;
        this.txQuality = txQuality;
        this.rxQuality = rxQuality;
    }

    public static InternalLocalStreamStats create(InternalLocalAudioStats audioStats, InternalLocalVideoStats videoStats, boolean isScreen, int txQuality, int rxQuality) {
        return new InternalLocalStreamStats(audioStats, videoStats, isScreen, txQuality, rxQuality);
    }
}
