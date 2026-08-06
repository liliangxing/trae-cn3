package com.bytedance.android.monitorV2.base;

import com.bytedance.android.monitorV2.util.JsonUtils;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class BaseNativeInfo extends BaseMonitorData {
    public String eventType;

    public BaseNativeInfo(String str) {
        this.eventType = str;
    }

    @Override // com.bytedance.android.monitorV2.base.BaseMonitorData, com.bytedance.android.monitorV2.base.IMonitorData
    public JSONObject toJsonObject() {
        JSONObject jsonObject = super.toJsonObject();
        JsonUtils.safePut(jsonObject, "event_type", this.eventType);
        return jsonObject;
    }

    public String toString() {
        return "BaseNativeInfo{eventType='" + this.eventType + "'}";
    }
}
