package com.bytedance.ies.bullet.prefetchv2;

import com.bytedance.ies.bullet.service.base.IMonitorReportService;
import com.bytedance.ies.bullet.service.base.ReportInfo;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.lynx.scc.cloudservice.SccResult;
import com.bytedance.lynx.service.reporter.performance.LynxTimingPerformanceReportProcessor;
import com.bytedance.memory.shrink.HprofMemoryConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: PrefetchReporter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ies/bullet/prefetchv2/PrefetchReporter;", "", "()V", "reportPrefetchResult", "", "info", "Lcom/bytedance/ies/bullet/prefetchv2/PrefetchReportInfo;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PrefetchReporter {
    public static final PrefetchReporter INSTANCE = new PrefetchReporter();

    private PrefetchReporter() {
    }

    public final void reportPrefetchResult(PrefetchReportInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        IMonitorReportService iMonitorReportService = (IMonitorReportService) ServiceCenter.INSTANCE.instance().get(info.getBid(), IMonitorReportService.class);
        if (iMonitorReportService != null) {
            ReportInfo reportInfo = new ReportInfo("bdx_monitor_prefetch_data", null, null, null, null, null, null, null, HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_HEAP_DUMP_INFO, null);
            reportInfo.setPageIdentifier(info.getIdentifier());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("prefetch_api", info.getPrefetchApi());
            jSONObject.put("prefetch_state", info.getRequestSuccess() ? "success" : SccResult.MESSAGE_FAIL);
            jSONObject.put("prefetch_from", "bridge");
            jSONObject.put("prefetch_cached", info.getPrefetchStatus());
            jSONObject.put("prefetch_type", "v2");
            jSONObject.put("prefetch_error", info.getErrorMsg());
            jSONObject.put("prefetch_config_from", info.getConfigFrom());
            reportInfo.setCategory(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(LynxTimingPerformanceReportProcessor.KEY_DURATION, info.getDuration());
            reportInfo.setMetrics(jSONObject2);
            iMonitorReportService.report(reportInfo);
        }
    }
}
