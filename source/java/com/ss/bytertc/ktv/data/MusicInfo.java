package com.ss.bytertc.ktv.data;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes7.dex */
public class MusicInfo {
    public int climaxEndTime;
    public int climaxStartTime;
    public int duration;
    public boolean enableScore;
    public LyricStatus lyricStatus;
    public String musicId;
    public String musicName;
    public String posterUrl;
    public String singer;
    public long updateTimestamp;
    public String vendorId;
    public String vendorName;

    public MusicInfo(String musicId, String musicName, String singer, String vendorId, String vendorName, long updateTimestamp, String posterUrl, LyricStatus lyricType, int duration, boolean enableScore, int climaxStart, int climaxEnd) {
        this.musicId = musicId;
        this.musicName = musicName;
        this.singer = singer;
        this.vendorId = vendorId;
        this.vendorName = vendorName;
        this.updateTimestamp = updateTimestamp;
        this.posterUrl = posterUrl;
        this.lyricStatus = lyricType;
        this.duration = duration;
        this.enableScore = enableScore;
        this.climaxStartTime = climaxStart;
        this.climaxEndTime = climaxEnd;
    }

    public String toString() {
        return "Music{musicId='" + this.musicId + "', musicName='" + this.musicName + "', singer='" + this.singer + "', vendorId='" + this.vendorId + "', vendorName='" + this.vendorName + "', updateTimestamp=" + this.updateTimestamp + ", posterUrl='" + this.posterUrl + "', lyricStatus=" + this.lyricStatus + ", duration=" + this.duration + ", enableScore=" + this.enableScore + ", climaxStartTime=" + this.climaxStartTime + ", climaxEndTime=" + this.climaxEndTime + AbstractJsonLexerKt.END_OBJ;
    }
}
