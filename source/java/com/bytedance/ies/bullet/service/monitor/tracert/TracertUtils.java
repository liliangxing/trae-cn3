package com.bytedance.ies.bullet.service.monitor.tracert;

import com.bytedance.ies.bullet.core.BulletMonitorContext;
import com.bytedance.ies.bullet.service.base.ReportInfo;
import com.bytedance.ies.bullet.service.monitor.utils.JsonUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: TracertUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/bullet/service/monitor/tracert/TracertUtils;", "", "()V", "mergeTracertInfo", "", "info", "Lcom/bytedance/ies/bullet/service/base/ReportInfo;", "monitorContext", "Lcom/bytedance/ies/bullet/core/BulletMonitorContext;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class TracertUtils {
    public static final TracertUtils INSTANCE = new TracertUtils();

    private TracertUtils() {
    }

    public final void mergeTracertInfo(ReportInfo info, BulletMonitorContext monitorContext) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(monitorContext, "monitorContext");
        if (info.getCategory() == null) {
            info.setCategory(new JSONObject());
        }
        JSONObject category = info.getCategory();
        if (category != null) {
            JsonUtilsKt.wrap(category, monitorContext.getCategory());
        }
        if (info.getMetrics() == null) {
            info.setMetrics(new JSONObject());
        }
        JSONObject metrics = info.getMetrics();
        if (metrics != null) {
            JsonUtilsKt.wrap(metrics, monitorContext.getMetric());
        }
    }
}
