package com.bytedance.ug.sdk.deeplink.monitor;

import org.json.JSONObject;

/* loaded from: classes4.dex */
public class MonitorData {
    private JSONObject duration;
    private boolean isValid;
    private JSONObject logExtra;
    private String serviceName;
    private int status;

    public MonitorData() {
    }

    public MonitorData(String str, int i, JSONObject jSONObject, JSONObject jSONObject2, boolean z) {
        this.serviceName = str;
        this.status = i;
        this.duration = jSONObject;
        this.logExtra = jSONObject2;
        this.isValid = z;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public void setServiceName(String str) {
        this.serviceName = str;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public JSONObject getDuration() {
        return this.duration;
    }

    public void setDuration(JSONObject jSONObject) {
        this.duration = jSONObject;
    }

    public JSONObject getLogExtra() {
        return this.logExtra;
    }

    public void setLogExtra(JSONObject jSONObject) {
        this.logExtra = jSONObject;
    }

    public boolean isValid() {
        return this.isValid;
    }

    public void setValid(boolean z) {
        this.isValid = z;
    }
}
