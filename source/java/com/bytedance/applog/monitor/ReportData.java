package com.bytedance.applog.monitor;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ReportData {
    static final String EVENT_NAME = "applog_trace";
    public String event = EVENT_NAME;
    public JSONObject jsonObject;

    public String getEvent() {
        return this.event;
    }

    public JSONObject getJsonObject() {
        return this.jsonObject;
    }

    public ReportData(JSONObject jSONObject) {
        this.jsonObject = jSONObject;
    }
}
