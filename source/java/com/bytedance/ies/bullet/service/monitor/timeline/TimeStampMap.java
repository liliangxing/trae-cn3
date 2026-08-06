package com.bytedance.ies.bullet.service.monitor.timeline;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MetricMap.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/bullet/service/monitor/timeline/TimeStampMap;", "Lcom/bytedance/ies/bullet/service/monitor/timeline/MetricMap;", "()V", "computeDuration", "", "start", "", "end", "record", "", "key", "recordWithOverride", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class TimeStampMap extends MetricMap {
    public final void record(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        record(key, Long.valueOf(System.currentTimeMillis()));
    }

    public final void recordWithOverride(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        recordWithOverride(key, Long.valueOf(System.currentTimeMillis()));
    }

    public final long computeDuration(String start, String end) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(end, "end");
        long j = get(start);
        long j2 = get(end);
        if (j == -1 || j2 == -1) {
            return 0L;
        }
        return j2 - j;
    }
}
