package com.bytedance.android.monitor.webview;

import com.bytedance.android.monitor.util.JsonUtils;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class TTLiveWebViewMonitorConfig {
    private static final String APM_CONFIG = "apmReportConfig";
    private static final String COMMON_CONFIG = "commonReportConfig";
    private static final String ERROR_CONFIG = "errorMsgReportConfig";
    private static final String PERFORMANCE_CONFIG = "performanceReportConfig";
    private static final String RESOURCE_CONFIG = "resourceTimingReportConfig";
    private JSONObject apmJsonObj;
    private JSONObject commonJsonObj;
    private JSONObject errorJsonObj;
    private JSONObject performanceJsonObj;
    private JSONObject resourceJsonObj;

    public static String buildDefaultConfig() {
        return "SlardarHybrid('config',{sendCommonParams:{},monitors:{StaticErrorMonitor:{ignore:[]},StaticPerformanceMonitor:{slowSession:8000,sampleRate:0.1},FPSMonitor:{interval:3000},MemoryMonitor:{interval:3000},PerformanceMonitor:{interval:100,checkPoint:['DOMContentLoaded','load']}}});";
    }

    public TTLiveWebViewMonitorConfig(String str) {
        JSONObject safeToJsonOb = JsonUtils.safeToJsonOb(str);
        this.apmJsonObj = JsonUtils.safeOptJsonObj(safeToJsonOb, APM_CONFIG);
        this.performanceJsonObj = JsonUtils.safeOptJsonObj(safeToJsonOb, PERFORMANCE_CONFIG);
        this.errorJsonObj = JsonUtils.safeOptJsonObj(safeToJsonOb, ERROR_CONFIG);
        this.resourceJsonObj = JsonUtils.safeOptJsonObj(safeToJsonOb, RESOURCE_CONFIG);
        this.commonJsonObj = JsonUtils.safeOptJsonObj(safeToJsonOb, COMMON_CONFIG);
    }

    public String buildConfig() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JsonUtils.safePut(jSONObject, "monitors", jSONObject2);
        JsonUtils.safePut(jSONObject, "sendCommonParams", this.commonJsonObj);
        append(jSONObject2, this.apmJsonObj);
        append(jSONObject2, this.performanceJsonObj);
        append(jSONObject2, this.errorJsonObj);
        append(jSONObject2, this.resourceJsonObj);
        return "SlardarHybrid('config', " + jSONObject.toString() + ")";
    }

    private void append(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null) {
            return;
        }
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JsonUtils.safePut(jSONObject, next, JsonUtils.safeOptObj(jSONObject2, next));
        }
    }
}
