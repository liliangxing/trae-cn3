package com.ss.bytertc.engine;

/* loaded from: classes7.dex */
public class InternalRemoteStreamStats {
    public InternalRemoteAudioStats audioStats;
    public boolean isScreen;
    public int rxQuality;
    public int txQuality;
    public String uid;
    public InternalRemoteVideoStats videoStats;

    public InternalRemoteStreamStats() {
    }

    public InternalRemoteStreamStats(String uid, InternalRemoteAudioStats audioStats, InternalRemoteVideoStats videoStats, boolean isScreen, int txQuality, int rxQuality) {
        this.uid = uid;
        this.audioStats = audioStats;
        this.videoStats = videoStats;
        this.isScreen = isScreen;
        this.txQuality = txQuality;
        this.rxQuality = rxQuality;
    }

    public static InternalRemoteStreamStats create(String uid, InternalRemoteAudioStats audioStats, InternalRemoteVideoStats videoStats, boolean isScreen, int txQuality, int rxQuality) {
        return new InternalRemoteStreamStats(uid, audioStats, videoStats, isScreen, txQuality, rxQuality);
    }
}
