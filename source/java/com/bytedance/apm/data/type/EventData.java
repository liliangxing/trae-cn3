package com.bytedance.apm.data.type;

import com.bytedance.apm.data.ITypeData;
import com.bytedance.apm.samplers.SamplerHelper;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class EventData implements ITypeData {
    public JSONObject category;
    public JSONObject extrJson;
    public boolean isUploadImmediately;
    public JSONObject metric;
    public String serviceName;
    public int status;
    public JSONObject value;

    @Override // com.bytedance.apm.data.ITypeData
    public String getSubTypeLabel() {
        return "service_monitor";
    }

    @Override // com.bytedance.apm.data.ITypeData
    public String getTypeLabel() {
        return "service_monitor";
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean isSaveImmediately() {
        return false;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean supportFetch() {
        return true;
    }

    public EventData(String str, int i, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4) {
        this.serviceName = str;
        this.status = i;
        this.value = jSONObject;
        this.category = jSONObject2;
        this.metric = jSONObject3;
        this.extrJson = jSONObject4;
    }

    public EventData(String str, int i, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, boolean z) {
        this.serviceName = str;
        this.status = i;
        this.value = jSONObject;
        this.category = jSONObject2;
        this.metric = jSONObject3;
        this.extrJson = jSONObject4;
        this.isUploadImmediately = z;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public JSONObject packLog() {
        if (this.extrJson == null) {
            this.extrJson = new JSONObject();
        }
        try {
            this.extrJson.put("log_type", "service_monitor");
            this.extrJson.put("service", this.serviceName);
            this.extrJson.put("status", this.status);
            JSONObject jSONObject = this.value;
            if (jSONObject != null) {
                this.extrJson.put("value", jSONObject);
            }
            JSONObject jSONObject2 = this.category;
            if (jSONObject2 != null) {
                this.extrJson.put("category", jSONObject2);
            }
            JSONObject jSONObject3 = this.metric;
            if (jSONObject3 != null) {
                this.extrJson.put("metric", jSONObject3);
            }
            return this.extrJson;
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean isSampled(JSONObject jSONObject) {
        return SamplerHelper.getServiceSwitch(this.serviceName);
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean isUploadImmediately() {
        return this.isUploadImmediately;
    }
}
