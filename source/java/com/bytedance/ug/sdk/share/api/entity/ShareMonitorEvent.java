package com.bytedance.ug.sdk.share.api.entity;

import org.json.JSONObject;

/* loaded from: classes4.dex */
public class ShareMonitorEvent {
    private JSONObject mCategory;
    private JSONObject mDuration;
    private JSONObject mLogExtra;
    private JSONObject mMetric;
    private String mServiceName;
    private int mStatus;

    public JSONObject getDuration() {
        return this.mDuration;
    }

    public void setDuration(JSONObject jSONObject) {
        this.mDuration = jSONObject;
    }

    public JSONObject getLogExtra() {
        return this.mLogExtra;
    }

    public void setLogExtra(JSONObject jSONObject) {
        this.mLogExtra = jSONObject;
    }

    public String getServiceName() {
        return this.mServiceName;
    }

    public void setServiceName(String str) {
        this.mServiceName = str;
    }

    public JSONObject getCategory() {
        return this.mCategory;
    }

    public void setCategory(JSONObject jSONObject) {
        this.mCategory = jSONObject;
    }

    public JSONObject getMetric() {
        return this.mMetric;
    }

    public void setMetric(JSONObject jSONObject) {
        this.mMetric = jSONObject;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        this.mStatus = i;
    }
}
