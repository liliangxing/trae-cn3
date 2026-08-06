package com.bytedance.crash.event;

import com.bytedance.crash.Global;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.util.App;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class EventReportData {
    private static final String DEFAULT_EVENT_LOG_TYPE = "service_monitor";
    private JSONObject category;
    private long eventTime;
    private JSONObject metric;
    private String serviceName;
    private int status;
    private String threadName;

    public EventReportData(String str, long j, String str2, int i, JSONObject jSONObject, JSONObject jSONObject2) {
        this.threadName = str;
        this.eventTime = j;
        this.serviceName = str2;
        this.status = i;
        this.category = jSONObject;
        this.metric = jSONObject2;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("log_type", "service_monitor");
            jSONObject.put("event_type", "exception");
            jSONObject.put("service", this.serviceName);
            jSONObject.put("status", this.status);
            jSONObject.put("category", this.category);
            jSONObject.put("metric", this.metric);
            jSONObject.put("sid", Global.getAppStartTime());
            jSONObject.put("timestamp", System.currentTimeMillis());
            jSONObject.put("crash_time", this.eventTime);
            jSONObject.put("process_name", App.getProcessName());
            jSONObject.put(CrashBody.CRASH_THREAD_NAME, this.threadName);
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
