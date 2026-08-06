package com.bytedance.apm.data.type;

import com.bytedance.apm.ApmContext;
import com.bytedance.apm.constant.ExceptionConsts;
import com.bytedance.apm.data.ITypeData;
import com.bytedance.apm.samplers.SamplerHelper;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ExceptionLogData implements ITypeData {
    private String eventType;
    private boolean forceSampled;
    private JSONObject logJson;
    private long time;

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
        return true;
    }

    public ExceptionLogData(String str, JSONObject jSONObject) {
        this(str, jSONObject, System.currentTimeMillis());
    }

    public ExceptionLogData(String str, JSONObject jSONObject, long j) {
        this.eventType = str;
        this.logJson = jSONObject;
        this.time = j;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public JSONObject packLog() {
        JSONObject jSONObject = this.logJson;
        if (jSONObject == null) {
            return null;
        }
        try {
            jSONObject.put("timestamp", this.time);
            this.logJson.put("crash_time", this.time);
            this.logJson.put("is_main_process", ApmContext.isMainProcess());
            this.logJson.put("process_name", ApmContext.getCurrentProcessName());
            this.logJson.put("log_type", this.eventType);
            if (ApmContext.getAppLaunchStartTimestamp() <= ApmContext.getStartId() && ApmContext.getAppLaunchStartTimestamp() != 0) {
                this.logJson.put(ExceptionConsts.KEY_APP_START_TIME, ApmContext.getAppLaunchStartTimestamp());
            } else {
                this.logJson.put(ExceptionConsts.KEY_APP_START_TIME, ApmContext.getStartId());
            }
        } catch (JSONException unused) {
        }
        return this.logJson;
    }

    public void forceSample() {
        this.forceSampled = true;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean isSampled(JSONObject jSONObject) {
        return this.forceSampled || SamplerHelper.getPerfSecondStageSwitch(this.eventType);
    }

    @Override // com.bytedance.apm.data.ITypeData
    public String getTypeLabel() {
        return this.eventType;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public String getSubTypeLabel() {
        return this.eventType;
    }

    public long crashTime() {
        return this.time;
    }

    public JSONObject getLogJson() {
        return this.logJson;
    }

    public String toString() {
        return "ExceptionLogData{eventType='" + this.eventType + "', logJson=" + this.logJson + ", forceSampled=" + this.forceSampled + ", time=" + this.time + '}';
    }
}
