package com.bytedance.tracing.internal;

import com.bytedance.apm.data.ITypeData;
import com.bytedance.apm.launch.LaunchCommon;
import com.bytedance.apm.samplers.SamplerHelper;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class TracingData implements ITypeData {
    private final boolean isErrorTag;
    private final JSONObject jsonObject;
    private final String serviceName;
    private final String subType;

    @Override // com.bytedance.apm.data.ITypeData
    public String getTypeLabel() {
        return "tracing";
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

    public TracingData(JSONObject jSONObject, String str, boolean z, String str2) {
        this.jsonObject = jSONObject;
        this.serviceName = str;
        this.isErrorTag = z;
        this.subType = str2;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public JSONObject packLog() {
        return this.jsonObject;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean isSampled(JSONObject jSONObject) {
        if (LaunchCommon.LAUNCH_TASK_TRACING_SERVICE_NAME.equals(this.serviceName)) {
            return SamplerHelper.getPerfAllowSwitch("start_trace");
        }
        return TraceSettings.getInstance().isErrorOrSampleHit(this.isErrorTag, this.serviceName) != 0;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public String getSubTypeLabel() {
        return this.subType;
    }
}
