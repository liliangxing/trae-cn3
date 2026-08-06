package com.bytedance.android.monitorV2.base;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class BaseMonitorData implements IMonitorData {
    public abstract void fillInJsonObject(JSONObject jSONObject);

    @Override // com.bytedance.android.monitorV2.base.IMonitorData
    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        fillInJsonObject(jSONObject);
        return jSONObject;
    }
}
