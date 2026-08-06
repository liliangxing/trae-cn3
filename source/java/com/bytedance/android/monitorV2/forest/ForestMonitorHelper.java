package com.bytedance.android.monitorV2.forest;

import com.bytedance.android.monitorV2.entity.CustomInfo;
import com.bytedance.android.monitorV2.logger.MonitorLog;
import com.bytedance.android.monitorV2.standard.ContainerStandardApi;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.forest.ResourceReporter;
import com.bytedance.forest.delegates.ReportDelegate;
import com.bytedance.forest.model.Response;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: ForestMonitorHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/monitorV2/forest/ForestMonitorHelper;", "", "()V", "startMonitor", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ForestMonitorHelper {
    public static final ForestMonitorHelper INSTANCE = new ForestMonitorHelper();

    private ForestMonitorHelper() {
    }

    public final void startMonitor() {
        ResourceReporter.INSTANCE.registerReportDelegate(new ReportDelegate() { // from class: com.bytedance.android.monitorV2.forest.ForestMonitorHelper$startMonitor$delegate$1
            @Override // com.bytedance.forest.delegates.ReportDelegate
            public void onReportResult(String eventName, Map<String, ? extends Map<String, ? extends Object>> data, Map<String, ? extends Object> extra, Response response) {
                Intrinsics.checkNotNullParameter(eventName, "eventName");
                Intrinsics.checkNotNullParameter(data, "data");
                Intrinsics.checkNotNullParameter(extra, "extra");
                Intrinsics.checkNotNullParameter(response, ApmTrafficStats.TTNET_RESPONSE);
                Object obj = extra.get("rl_container_uuid");
                Unit unit = null;
                String str = obj instanceof String ? (String) obj : null;
                if (str != null) {
                    ContainerStandardApi.INSTANCE.handleNativeInfo(null, str, eventName, new JSONObject(data));
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    MonitorLog.m27e("ForestMonitorHelper", "monitorId is null, skip");
                }
            }

            @Override // com.bytedance.forest.delegates.ReportDelegate
            public void customReport(String eventName, String url, String bid, String containerId, JSONObject category, JSONObject metrics, JSONObject extra, int sampleLevel) {
                Intrinsics.checkNotNullParameter(eventName, "eventName");
                Intrinsics.checkNotNullParameter(url, "url");
                Intrinsics.checkNotNullParameter(category, "category");
                Intrinsics.checkNotNullParameter(metrics, "metrics");
                Intrinsics.checkNotNullParameter(extra, "extra");
                CustomInfo build = new CustomInfo.Builder(eventName).setBid(bid).setUrl(url).setMonitorId(containerId).setCategory(category).setMetric(metrics).setExtra(extra).setSample(sampleLevel).build();
                ContainerStandardApi containerStandardApi = ContainerStandardApi.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(build, "customInfo");
                containerStandardApi.customReport(build);
            }
        });
    }
}
