package com.bytedance.sysoptimizer.anr;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes5.dex */
public class ResourceUsage {
    public long idRss;
    public long majFlt;
    public long maxPss;
    public long maxRss;
    public long minFlt;
    public long nivcsw;
    public long nvcsw;
    public long readSizeMB;
    public long recordTimestamp;
    public long stm;
    public long sysTimeSec;
    public long sysTimeUsec;
    public String threadState;
    public long userTimeSec;
    public long userTimeUsec;
    public long utm;
    public long writeSizeMB;

    public String toString() {
        return "UsageInfo{userTimeSec=" + this.userTimeSec + ", userTimeUsec=" + this.userTimeUsec + ", sysTimeSec=" + this.sysTimeSec + ", sysTimeUsec=" + this.sysTimeUsec + ", maxRss=" + this.maxRss + ", idRss=" + this.idRss + ", minFlt=" + this.minFlt + ", majFlt=" + this.majFlt + ", readSizeMB=" + this.readSizeMB + ", writeSizeMB=" + this.writeSizeMB + ", nvcsw=" + this.nvcsw + ", nivcsw=" + this.nivcsw + ", recordTimestamp=" + this.recordTimestamp + AbstractJsonLexerKt.END_OBJ;
    }
}
