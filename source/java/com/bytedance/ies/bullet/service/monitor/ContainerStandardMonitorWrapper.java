package com.bytedance.ies.bullet.service.monitor;

import android.view.View;
import com.bytedance.ies.bullet.service.monitor.standard.ContainerStandardMonitor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: ContainerStandardMonitorWrapper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tJ\u001e\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\tJ\u0016\u0010\u0011\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013J\u001e\u0010\u0014\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0001J8\u0010\u0016\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\tR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ies/bullet/service/monitor/ContainerStandardMonitorWrapper;", "", "()V", "executor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "addContext", "", "monitorId", "", "key", "value", "attach", "sessionId", "view", "Landroid/view/View;", "type", "batchCollect", "data", "Lorg/json/JSONObject;", "collect", "field", "reportError", "errCode", "", "errorMsg", "virtualAid", MetricConstant.FIELD_BIZ, "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ContainerStandardMonitorWrapper {
    public static final ContainerStandardMonitorWrapper INSTANCE = new ContainerStandardMonitorWrapper();
    private static final ExecutorService executor = Executors.newSingleThreadExecutor();

    private ContainerStandardMonitorWrapper() {
    }

    public final void collect(final String sessionId, final String field, final Object data) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(field, "field");
        Intrinsics.checkNotNullParameter(data, "data");
        executor.execute(new Runnable() { // from class: com.bytedance.ies.bullet.service.monitor.ContainerStandardMonitorWrapper$collect$1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    ContainerStandardMonitor.INSTANCE.collect(sessionId, field, data);
                } catch (Throwable unused) {
                }
            }
        });
    }

    public final void batchCollect(final String sessionId, final JSONObject data) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(data, "data");
        executor.execute(new Runnable() { // from class: com.bytedance.ies.bullet.service.monitor.ContainerStandardMonitorWrapper$batchCollect$1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    ContainerStandardMonitor.INSTANCE.batchCollect(sessionId, data);
                } catch (Throwable unused) {
                }
            }
        });
    }

    public final void addContext(final String monitorId, final String key, final String value) {
        Intrinsics.checkNotNullParameter(monitorId, "monitorId");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        executor.execute(new Runnable() { // from class: com.bytedance.ies.bullet.service.monitor.ContainerStandardMonitorWrapper$addContext$1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    ContainerStandardMonitor.INSTANCE.addContext(monitorId, key, value);
                } catch (Throwable unused) {
                }
            }
        });
    }

    public final void attach(final String sessionId, final View view, final String type) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(type, "type");
        executor.execute(new Runnable() { // from class: com.bytedance.ies.bullet.service.monitor.ContainerStandardMonitorWrapper$attach$1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    ContainerStandardMonitor.INSTANCE.attach(sessionId, view, type);
                } catch (Throwable unused) {
                }
            }
        });
    }

    public final void reportError(View view, String sessionId, int errCode, String errorMsg, String virtualAid, String biz) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        Intrinsics.checkNotNullParameter(virtualAid, "virtualAid");
        Intrinsics.checkNotNullParameter(biz, MetricConstant.FIELD_BIZ);
        ContainerStandardMonitor.INSTANCE.reportError(view, sessionId, errCode, errorMsg, virtualAid, biz);
    }
}
