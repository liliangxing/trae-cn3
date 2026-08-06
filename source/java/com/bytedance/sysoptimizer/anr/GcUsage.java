package com.bytedance.sysoptimizer.anr;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes5.dex */
public class GcUsage {
    public long blockingGcCountRateHistogram;
    public long blockingGcCountTotal;
    public long blockingGcTimeTotal;
    public long bytesAllocatedTotal;
    public long bytesFreedTotal;
    public long gcCountRateHistogram;
    public long gcCountTotal;
    public long gcTimeTotal;
    public long recordTimestamp = 0;

    public String toString() {
        return "GcUsage{gcCountTotal=" + this.gcCountTotal + ", gcTimeTotal=" + this.gcTimeTotal + ", bytesAllocatedTotal=" + this.bytesAllocatedTotal + ", bytesFreedTotal=" + this.bytesFreedTotal + ", blockingGcCountTotal=" + this.blockingGcCountTotal + ", blockingGcTimeTotal=" + this.blockingGcTimeTotal + ", gcCountRateHistogram=" + this.gcCountRateHistogram + ", blockingGcCountRateHistogram=" + this.blockingGcCountRateHistogram + ", recordTimestamp=" + this.recordTimestamp + AbstractJsonLexerKt.END_OBJ;
    }
}
