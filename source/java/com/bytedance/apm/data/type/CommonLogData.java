package com.bytedance.apm.data.type;

import com.bytedance.apm.data.ITypeData;
import com.bytedance.apm.samplers.SamplerHelper;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class CommonLogData implements ITypeData {
    public boolean isSaveDBImmediate;
    public JSONObject logJson;
    public String logType;

    @Override // com.bytedance.apm.data.ITypeData
    public String getTypeLabel() {
        return "common_log";
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean isUploadImmediately() {
        return false;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean supportFetch() {
        return true;
    }

    public CommonLogData(String str, JSONObject jSONObject, boolean z) {
        this.logType = str;
        this.logJson = jSONObject;
        this.isSaveDBImmediate = z;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public JSONObject packLog() {
        JSONObject jSONObject = this.logJson;
        if (jSONObject == null) {
            return null;
        }
        try {
            jSONObject.put("log_type", this.logType);
        } catch (JSONException unused) {
        }
        return this.logJson;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean isSampled(JSONObject jSONObject) {
        return SamplerHelper.getLogTypeSwitch(this.logType);
    }

    @Override // com.bytedance.apm.data.ITypeData
    public String getSubTypeLabel() {
        return this.logType;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean isSaveImmediately() {
        return this.isSaveDBImmediate;
    }
}
