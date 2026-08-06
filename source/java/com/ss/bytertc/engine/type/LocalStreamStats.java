package com.ss.bytertc.engine.type;

import com.ss.bytertc.engine.InternalLocalStreamStats;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes7.dex */
public class LocalStreamStats {
    public LocalAudioStats audioStats;
    public boolean isScreen;
    public int rxQuality;
    public int txQuality;
    public LocalVideoStats videoStats;

    public LocalStreamStats() {
    }

    public LocalStreamStats(InternalLocalStreamStats stats) {
        LocalAudioStats localAudioStats = new LocalAudioStats(stats.audioStats);
        LocalVideoStats localVideoStats = new LocalVideoStats(stats.videoStats);
        this.audioStats = localAudioStats;
        this.videoStats = localVideoStats;
        this.isScreen = stats.isScreen;
        this.txQuality = stats.txQuality;
        this.rxQuality = stats.rxQuality;
    }

    public String toString() {
        return "LocalStreamStats{audioStats=" + this.audioStats + ", videoStats=" + this.videoStats + ", isScreen=" + this.isScreen + ", txQuality=" + this.txQuality + ", rxQuality=" + this.rxQuality + AbstractJsonLexerKt.END_OBJ;
    }
}
