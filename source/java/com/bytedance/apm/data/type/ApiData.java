package com.bytedance.apm.data.type;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.apm.constant.TrafficConsts;
import com.bytedance.apm.data.ITypeData;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ApiData implements ITypeData {
    public String apiType;
    public long duration;
    public JSONObject extJson;
    public String sendIp;
    public long sendTime;
    public String sendUrl;
    public int status;
    public String traceCode;

    @Override // com.bytedance.apm.data.ITypeData
    public String getSubTypeLabel() {
        return null;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public String getTypeLabel() {
        return null;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean isSampled(JSONObject jSONObject) {
        return false;
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
        return true;
    }

    public ApiData(String str, long j, long j2, String str2, String str3, String str4, int i, JSONObject jSONObject) {
        this.apiType = str;
        this.duration = j;
        this.sendTime = j2;
        this.sendUrl = str2;
        this.sendIp = str3;
        this.traceCode = str4;
        this.status = i;
        if (jSONObject == null) {
            this.extJson = new JSONObject();
        } else {
            this.extJson = jSONObject;
        }
    }

    public void appendFront(boolean z) throws JSONException {
        if (this.extJson.isNull("front")) {
            this.extJson.put("front", z ? 1 : 0);
        }
    }

    public void appendConsumeType(String str) throws JSONException {
        if (this.extJson.isNull(TrafficConsts.KEY_NET_CONSUME_TYPE)) {
            this.extJson.put(TrafficConsts.KEY_NET_CONSUME_TYPE, str);
        }
    }

    public void appendLaunchTraceInfo() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(TraceStatsConsts.STATS_KEY_TRACE_BASE, ApmContext.getAppLaunchStartTimestamp());
            this.extJson.put("relate_start_trace", jSONObject);
        } catch (JSONException unused) {
        }
    }

    @Override // com.bytedance.apm.data.ITypeData
    public JSONObject packLog() {
        if (TextUtils.isEmpty(this.apiType)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("log_type", this.apiType);
            jSONObject.put("duration", this.duration);
            jSONObject.put("uri", Uri.parse(this.sendUrl));
            long j = this.sendTime;
            if (j > 0) {
                jSONObject.put("timestamp", j);
            }
            jSONObject.put("status", this.status);
            if (!TextUtils.isEmpty(this.sendIp)) {
                jSONObject.put("ip", this.sendIp);
            }
            if (!TextUtils.isEmpty(this.traceCode)) {
                jSONObject.put("trace_code", this.traceCode);
            } else {
                jSONObject.put("trace_code", "");
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }
}
