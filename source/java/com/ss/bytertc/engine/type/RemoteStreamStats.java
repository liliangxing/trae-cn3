package com.ss.bytertc.engine.type;

import com.ss.bytertc.engine.InternalRemoteStreamStats;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes7.dex */
public class RemoteStreamStats {
    public RemoteAudioStats audioStats;
    public boolean isScreen;
    public int rxQuality;
    public int txQuality;
    public String uid;
    public RemoteVideoStats videoStats;

    public RemoteStreamStats() {
    }

    public RemoteStreamStats(InternalRemoteStreamStats stats) {
        RemoteAudioStats remoteAudioStats = new RemoteAudioStats(stats.audioStats);
        RemoteVideoStats remoteVideoStats = new RemoteVideoStats(stats.videoStats);
        this.audioStats = remoteAudioStats;
        this.videoStats = remoteVideoStats;
        this.uid = stats.uid;
        this.isScreen = stats.isScreen;
        this.rxQuality = stats.rxQuality;
        this.txQuality = stats.txQuality;
    }

    public String toString() {
        return "RemoteStreamStats{uid='" + this.uid + "', audioStats=" + this.audioStats + ", videoStats=" + this.videoStats + ", isScreen=" + this.isScreen + ", txQuality=" + this.txQuality + ", rxQuality=" + this.rxQuality + AbstractJsonLexerKt.END_OBJ;
    }
}
