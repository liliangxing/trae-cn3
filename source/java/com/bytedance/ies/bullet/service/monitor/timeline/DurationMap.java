package com.bytedance.ies.bullet.service.monitor.timeline;

import com.bytedance.ies.bullet.prefetchv2.PrefetchRequestConfig;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MetricMap.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ies/bullet/service/monitor/timeline/DurationMap;", "Lcom/bytedance/ies/bullet/service/monitor/timeline/MetricMap;", "()V", PrefetchRequestConfig.METHOD_GET, "", "key", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class DurationMap extends MetricMap {
    @Override // com.bytedance.ies.bullet.service.monitor.timeline.MetricMap
    public long get(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        long j = super.get(key);
        if (j >= 0) {
            return j;
        }
        BulletLogger.INSTANCE.printLog("get negative duration: " + key + ' ' + j, LogLevel.W, MetricMap.moduleName);
        return 0L;
    }
}
