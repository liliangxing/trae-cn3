package com.bytedance.ies.bullet.service.monitor.deviceperf;

import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.service.base.IMonitorReportService;
import com.bytedance.ies.bullet.service.base.ReportInfo;
import com.bytedance.ies.bullet.service.base.api.IServiceCenter;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.ies.bullet.service.monitor.utils.JsonUtilsKt;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.bytedance.memory.shrink.HprofMemoryConstants;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: CpuMemoryReporter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ies/bullet/service/monitor/deviceperf/CpuMemoryReporter;", "", "()V", "cpuReportInfo", "Lcom/bytedance/ies/bullet/service/base/ReportInfo;", "memoryReportInfo", "inject", "", SchemaConstants.INNER_PARAM_EVENT_NAME, "", "category", "Lorg/json/JSONObject;", LynxMonitorService.KEY_METRICS, "reportCpuMemory", "context", "Lcom/bytedance/ies/bullet/core/BulletContext;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class CpuMemoryReporter {
    private final ReportInfo cpuReportInfo;
    private final ReportInfo memoryReportInfo;

    public CpuMemoryReporter() {
        ReportInfo reportInfo = new ReportInfo(CpuMemoryPerfMetric.BDX_MONITOR_CPU, null, null, null, null, null, null, null, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_HEAP_DUMP_INFO, null);
        reportInfo.setCategory(new JSONObject());
        reportInfo.setMetrics(new JSONObject());
        this.cpuReportInfo = reportInfo;
        ReportInfo reportInfo2 = new ReportInfo(CpuMemoryPerfMetric.BDX_MONITOR_MEMORY, null, null, null, null, null, null, null, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_HEAP_DUMP_INFO, null);
        reportInfo2.setCategory(new JSONObject());
        reportInfo2.setMetrics(new JSONObject());
        this.memoryReportInfo = reportInfo2;
    }

    public final void inject(String eventName, JSONObject category, JSONObject metrics) {
        Intrinsics.checkNotNullParameter(eventName, SchemaConstants.INNER_PARAM_EVENT_NAME);
        if (Intrinsics.areEqual(eventName, CpuMemoryPerfMetric.BDX_MONITOR_CPU)) {
            JSONObject category2 = this.cpuReportInfo.getCategory();
            if (category2 != null) {
                JsonUtilsKt.wrap(category2, category);
            }
        } else if (Intrinsics.areEqual(eventName, CpuMemoryPerfMetric.BDX_MONITOR_MEMORY)) {
            JSONObject category3 = this.memoryReportInfo.getCategory();
            if (category3 != null) {
                JsonUtilsKt.wrap(category3, category);
            }
        } else {
            JSONObject category4 = this.cpuReportInfo.getCategory();
            if (category4 != null) {
                JsonUtilsKt.wrap(category4, category);
            }
            JSONObject category5 = this.memoryReportInfo.getCategory();
            if (category5 != null) {
                JsonUtilsKt.wrap(category5, category);
            }
        }
        if (Intrinsics.areEqual(eventName, CpuMemoryPerfMetric.BDX_MONITOR_CPU)) {
            JSONObject metrics2 = this.cpuReportInfo.getMetrics();
            if (metrics2 != null) {
                JsonUtilsKt.wrap(metrics2, metrics);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(eventName, CpuMemoryPerfMetric.BDX_MONITOR_MEMORY)) {
            JSONObject metrics3 = this.memoryReportInfo.getMetrics();
            if (metrics3 != null) {
                JsonUtilsKt.wrap(metrics3, metrics);
                return;
            }
            return;
        }
        JSONObject metrics4 = this.cpuReportInfo.getMetrics();
        if (metrics4 != null) {
            JsonUtilsKt.wrap(metrics4, metrics);
        }
        JSONObject metrics5 = this.memoryReportInfo.getMetrics();
        if (metrics5 != null) {
            JsonUtilsKt.wrap(metrics5, metrics);
        }
    }

    public final void reportCpuMemory(BulletContext context) {
        AtomicBoolean isCanRecord;
        Intrinsics.checkNotNullParameter(context, "context");
        JSONObject category = context.getMonitorContext().getCategory();
        Object cpuMemoryPerfMetric = context.getContainerContext().getCpuMemoryPerfMetric();
        CpuMemoryPerfMetric cpuMemoryPerfMetric2 = cpuMemoryPerfMetric instanceof CpuMemoryPerfMetric ? (CpuMemoryPerfMetric) cpuMemoryPerfMetric : null;
        boolean z = false;
        if (cpuMemoryPerfMetric2 != null && (isCanRecord = cpuMemoryPerfMetric2.getIsCanRecord()) != null && isCanRecord.get()) {
            z = true;
        }
        if (z) {
            JSONObject jSONObject = new JSONObject();
            if (cpuMemoryPerfMetric2.getMemory(CpuMemoryPerfMetric.MEMORY_WARNING) != -1) {
                jSONObject.put(CpuMemoryPerfMetric.STACK_ON_MEMORY_WARNING, cpuMemoryPerfMetric2.getRunningBulletStackInfo());
            }
            JSONObject jSONObject2 = new JSONObject();
            for (String str : cpuMemoryPerfMetric2.getCpuMetricMap().keySet()) {
                Intrinsics.checkNotNullExpressionValue(str, "key");
                jSONObject2.put(str, cpuMemoryPerfMetric2.getCpu(str));
            }
            JSONObject jSONObject3 = new JSONObject();
            for (String str2 : cpuMemoryPerfMetric2.getMemoryMetricMap().keySet()) {
                Intrinsics.checkNotNullExpressionValue(str2, "key");
                jSONObject3.put(str2, cpuMemoryPerfMetric2.getMemory(str2));
            }
            context.getMonitorCallback().onCpuMemoryInject(CpuMemoryPerfMetric.BDX_MONITOR_MEMORY, jSONObject, jSONObject3);
            context.getMonitorCallback().onCpuMemoryInject(CpuMemoryPerfMetric.BDX_MONITOR_CPU, jSONObject, jSONObject2);
            if (this.memoryReportInfo.getPageIdentifier() == null) {
                this.memoryReportInfo.setPageIdentifier(context.getUriIdentifier());
            }
            JSONObject category2 = this.memoryReportInfo.getCategory();
            if (category2 != null) {
                JsonUtilsKt.wrap(category2, category);
            }
            IServiceCenter instance = ServiceCenter.INSTANCE.instance();
            String bid = context.getBid();
            if (bid == null) {
                bid = "default_bid";
            }
            IMonitorReportService iMonitorReportService = (IMonitorReportService) instance.get(bid, IMonitorReportService.class);
            if (iMonitorReportService != null) {
                iMonitorReportService.report(this.memoryReportInfo);
            }
            if (this.cpuReportInfo.getPageIdentifier() == null) {
                this.cpuReportInfo.setPageIdentifier(context.getUriIdentifier());
            }
            JSONObject category3 = this.cpuReportInfo.getCategory();
            if (category3 != null) {
                JsonUtilsKt.wrap(category3, category);
            }
            IServiceCenter instance2 = ServiceCenter.INSTANCE.instance();
            String bid2 = context.getBid();
            IMonitorReportService iMonitorReportService2 = (IMonitorReportService) instance2.get(bid2 != null ? bid2 : "default_bid", IMonitorReportService.class);
            if (iMonitorReportService2 != null) {
                iMonitorReportService2.report(this.cpuReportInfo);
            }
        }
    }
}
