package com.bytedance.android.monitorV2.webview.ttweb;

import android.webkit.WebView;
import com.bytedance.android.monitorV2.entity.CustomInfo;
import com.bytedance.android.monitorV2.settings.WebBlankConfig;
import com.bytedance.android.monitorV2.util.JsonUtils;
import com.bytedance.android.monitorV2.webview.WebViewMonitorHelper;
import com.bytedance.applog.server.Api;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: KernelReporter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\u0016\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fJ&\u0010\u000f\u001a\u00020\u0004*\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0013H\u0002¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/monitorV2/webview/ttweb/KernelReporter;", "", "()V", "reportKernelBlankDetect", "", "webView", "Landroid/webkit/WebView;", "isBlank", "", "detectConfig", "Lcom/bytedance/android/monitorV2/settings/WebBlankConfig;", "category", "Lorg/json/JSONObject;", "metrics", "reportKernelMetrics", "putNotNegative", Api.KEY_ENCRYPT_RESP_KEY, "", "value", "", "default", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class KernelReporter {
    public static final KernelReporter INSTANCE = new KernelReporter();

    private KernelReporter() {
    }

    public final void reportKernelMetrics(WebView webView, JSONObject metrics) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        JSONObject safeOptJsonObj = JsonUtils.safeOptJsonObj(metrics, "loading");
        if (safeOptJsonObj == null) {
            safeOptJsonObj = new JSONObject();
        }
        JSONObject safeOptJsonObj2 = JsonUtils.safeOptJsonObj(safeOptJsonObj, "top_level_timing");
        if (safeOptJsonObj2 == null) {
            safeOptJsonObj2 = new JSONObject();
        }
        JSONObject safeOptJsonObj3 = JsonUtils.safeOptJsonObj(safeOptJsonObj, "create_webview_timing");
        if (safeOptJsonObj3 == null) {
            safeOptJsonObj3 = new JSONObject();
        }
        JSONObject safeOptJsonObj4 = JsonUtils.safeOptJsonObj(safeOptJsonObj, "main_resource_timing");
        if (safeOptJsonObj4 == null) {
            safeOptJsonObj4 = new JSONObject();
        }
        JSONObject safeOptJsonObj5 = JsonUtils.safeOptJsonObj(safeOptJsonObj, "render_timing");
        if (safeOptJsonObj5 == null) {
            safeOptJsonObj5 = new JSONObject();
        }
        JSONObject safeOptJsonObj6 = JsonUtils.safeOptJsonObj(safeOptJsonObj, "ttwebview_info");
        if (safeOptJsonObj6 == null) {
            safeOptJsonObj6 = new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        KernelReporter kernelReporter = INSTANCE;
        putNotNegative$default(kernelReporter, jSONObject, "fcp", safeOptJsonObj5.optLong("tick_fcp") - safeOptJsonObj4.optLong("tick_navigation_start"), 0L, 4, null);
        putNotNegative$default(kernelReporter, jSONObject, "lcp", safeOptJsonObj2.optLong("tick_lcp") - safeOptJsonObj4.optLong("tick_navigation_start"), 0L, 4, null);
        putNotNegative$default(kernelReporter, jSONObject, "fmp", safeOptJsonObj5.optLong("tick_fmp") - safeOptJsonObj4.optLong("tick_navigation_start"), 0L, 4, null);
        putNotNegative$default(kernelReporter, jSONObject, "tti", safeOptJsonObj5.optLong("tick_tti") - safeOptJsonObj4.optLong("tick_navigation_start"), 0L, 4, null);
        putNotNegative$default(kernelReporter, jSONObject, "dur_main_resource_load", safeOptJsonObj4.optLong("tick_response_end") - safeOptJsonObj4.optLong("tick_navigation_start"), 0L, 4, null);
        putNotNegative$default(kernelReporter, jSONObject, "dur_resource_load", safeOptJsonObj2.optLong("tick_page_finished") - safeOptJsonObj2.optLong("tick_page_started"), 0L, 4, null);
        putNotNegative$default(kernelReporter, jSONObject, "dur_javascript_execute", safeOptJsonObj5.optLong("dur_js_execution_before_lcp"), 0L, 4, null);
        putNotNegative$default(kernelReporter, jSONObject, "dur_layout", safeOptJsonObj2.optLong("dur_layout_before_lcp"), 0L, 4, null);
        putNotNegative$default(kernelReporter, jSONObject, "dur_paint", safeOptJsonObj2.optLong("dur_paint_before_lcp"), 0L, 4, null);
        putNotNegative$default(kernelReporter, jSONObject, "dur_webview_create_time", safeOptJsonObj2.optLong("tick_create_webview_end") - safeOptJsonObj2.optLong("tick_create_webview_start"), 0L, 4, null);
        putNotNegative$default(kernelReporter, jSONObject, "dur_init_ttwebview_provider", safeOptJsonObj3.optLong("tick_init_ttwebview_provider_end") - safeOptJsonObj3.optLong("tick_init_ttwebview_provider_start"), 0L, 4, null);
        putNotNegative$default(kernelReporter, jSONObject, "dur_create_factory_provider", safeOptJsonObj3.optLong("tick_create_factory_provider_end") - safeOptJsonObj3.optLong("tick_create_factory_provider_start"), 0L, 4, null);
        putNotNegative$default(kernelReporter, jSONObject, "dur_webview_chromium_construct", safeOptJsonObj3.optLong("tick_webview_chromium_construct_end") - safeOptJsonObj3.optLong("tick_webview_chromium_construct_start"), 0L, 4, null);
        putNotNegative$default(kernelReporter, jSONObject, "dur_webview_chromium_init", safeOptJsonObj3.optLong("tick_webview_chromium_init_end") - safeOptJsonObj3.optLong("tick_webview_chromium_init_start"), 0L, 4, null);
        putNotNegative$default(kernelReporter, jSONObject, "dur_load_library", safeOptJsonObj3.optLong("tick_load_library_end") - safeOptJsonObj3.optLong("tick_load_library_start"), 0L, 4, null);
        putNotNegative$default(kernelReporter, jSONObject, "dur_start_engines", safeOptJsonObj3.optLong("tick_start_engines_end") - safeOptJsonObj3.optLong("tick_start_engines_start"), 0L, 4, null);
        putNotNegative$default(kernelReporter, jSONObject, "dur_wait_render_process_ready_time", safeOptJsonObj2.optLong("tick_render_process_ready") - safeOptJsonObj2.optLong("tick_loadurl"), 0L, 4, null);
        WebViewMonitorHelper.getInstance().customReport(webView, new CustomInfo.Builder("ttwebview_metrics_from_monitor").setMetric(jSONObject).setCategory(safeOptJsonObj6).setSample(2).build());
    }

    public final void reportKernelBlankDetect(WebView webView, boolean isBlank, WebBlankConfig detectConfig, JSONObject category, JSONObject metrics) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(detectConfig, "detectConfig");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        if (webView.getWidth() <= 0 || webView.getHeight() <= 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("is_blank", isBlank);
        jSONObject.put("use_monitor_detect", detectConfig.getUseMonitorDetect());
        jSONObject.put("detect_type", detectConfig.getMonitorDetectType());
        jSONObject.put("stay_duration", detectConfig.getStayDuration());
        WebViewMonitorHelper.getInstance().customReport(webView, new CustomInfo.Builder("ttwebview_blank_detect_from_monitor").setCategory(JsonUtils.merge(category, jSONObject)).setMetric(metrics).setSample(1).build());
    }

    static /* synthetic */ void putNotNegative$default(KernelReporter kernelReporter, JSONObject jSONObject, String str, long j, long j2, int i, Object obj) {
        if ((i & 4) != 0) {
            j2 = -1;
        }
        kernelReporter.putNotNegative(jSONObject, str, j, j2);
    }

    private final void putNotNegative(JSONObject jSONObject, String str, long j, long j2) {
        if (j < 0) {
            j = j2;
        }
        jSONObject.put(str, j);
    }
}
