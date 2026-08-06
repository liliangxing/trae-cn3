package com.bytedance.ies.bullet.service.monitor.timeline;

import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MetricMap.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0018\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00070\u0006J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/bullet/service/monitor/timeline/SecurityTimeStampMap;", "Lcom/bytedance/ies/bullet/service/monitor/timeline/MetricMap;", "()V", "computeDuration", "", "stageList", "", "Lkotlin/Pair;", "", "record", "", "key", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class SecurityTimeStampMap extends MetricMap {
    public final void record(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        record(key, Long.valueOf(System.nanoTime()));
    }

    public final long computeDuration(List<Pair<String, String>> stageList) {
        Intrinsics.checkNotNullParameter(stageList, "stageList");
        long j = 0;
        for (Pair<String, String> pair : stageList) {
            long j2 = get(pair.getFirst());
            long j3 = get(pair.getSecond());
            j += (j2 == -1 || j3 == -1) ? 0L : j3 - j2;
        }
        return j / 1000000;
    }
}
