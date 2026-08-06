package com.bytedance.apm.data.type;

import com.bytedance.apm.data.ITypeData;
import com.bytedance.apm.samplers.SamplerHelper;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class MetricsData implements ITypeData {
    public String key;
    public String type;
    public float value;

    @Override // com.bytedance.apm.data.ITypeData
    public String getSubTypeLabel() {
        return "timer";
    }

    @Override // com.bytedance.apm.data.ITypeData
    public String getTypeLabel() {
        return "timer";
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean isSaveImmediately() {
        return false;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean isUploadImmediately() {
        return false;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean supportFetch() {
        return false;
    }

    public MetricsData(String str, String str2, float f) {
        this.type = str;
        this.key = str2;
        this.value = f;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public JSONObject packLog() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", this.type);
            jSONObject.put("key", this.key);
            jSONObject.put("value", this.value);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean isSampled(JSONObject jSONObject) {
        return SamplerHelper.getMetricSwitch(this.type);
    }
}
