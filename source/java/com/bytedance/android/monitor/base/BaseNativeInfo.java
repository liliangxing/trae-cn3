package com.bytedance.android.monitor.base;

import com.bytedance.android.monitor.util.JsonUtils;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class BaseNativeInfo extends BaseMonitorData {
    public String eventType;

    public BaseNativeInfo(String str) {
        this.eventType = str;
    }

    @Override // com.bytedance.android.monitor.base.BaseMonitorData, com.bytedance.android.monitor.base.IMonitorData
    public JSONObject toJsonObject() {
        JSONObject jsonObject = super.toJsonObject();
        JsonUtils.safePut(jsonObject, "event_type", this.eventType);
        return jsonObject;
    }
}
