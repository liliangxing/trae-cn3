package com.bytedance.android.monitor.base;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class BaseMonitorData implements IMonitorData {
    public abstract void fillInJsonObject(JSONObject jSONObject);

    @Override // com.bytedance.android.monitor.base.IMonitorData
    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        fillInJsonObject(jSONObject);
        return jSONObject;
    }
}
