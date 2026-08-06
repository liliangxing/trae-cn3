package com.huawei.hms.common.internal;

import android.text.TextUtils;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class ResponseWrap {

    /* renamed from: a */
    private String f1230a;

    /* renamed from: b */
    private ResponseHeader f1231b;

    public ResponseWrap(ResponseHeader responseHeader) {
        this.f1231b = responseHeader;
    }

    public boolean fromJson(String str) {
        if (this.f1231b == null) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f1231b.setStatusCode(JsonUtil.getIntValue(jSONObject, "status_code"));
            this.f1231b.setErrorCode(JsonUtil.getIntValue(jSONObject, "error_code"));
            this.f1231b.setErrorReason(JsonUtil.getStringValue(jSONObject, "error_reason"));
            this.f1231b.setSrvName(JsonUtil.getStringValue(jSONObject, "srv_name"));
            this.f1231b.setApiName(JsonUtil.getStringValue(jSONObject, "api_name"));
            this.f1231b.setAppID(JsonUtil.getStringValue(jSONObject, "app_id"));
            this.f1231b.setPkgName(JsonUtil.getStringValue(jSONObject, "pkg_name"));
            this.f1231b.setSessionId(JsonUtil.getStringValue(jSONObject, "session_id"));
            this.f1231b.setTransactionId(JsonUtil.getStringValue(jSONObject, CommonCode.MapKey.TRANSACTION_ID));
            this.f1231b.setResolution(JsonUtil.getStringValue(jSONObject, CommonCode.MapKey.HAS_RESOLUTION));
            this.f1230a = JsonUtil.getStringValue(jSONObject, "body");
            return true;
        } catch (JSONException e) {
            HMSLog.m2118e("ResponseWrap", "fromJson failed: " + e.getMessage());
            return false;
        }
    }

    public String getBody() {
        if (TextUtils.isEmpty(this.f1230a)) {
            this.f1230a = new JSONObject().toString();
        }
        return this.f1230a;
    }

    public ResponseHeader getResponseHeader() {
        return this.f1231b;
    }

    public void setBody(String str) {
        this.f1230a = str;
    }

    public void setResponseHeader(ResponseHeader responseHeader) {
        this.f1231b = responseHeader;
    }

    public String toJson() {
        if (this.f1231b == null) {
            return "{}";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status_code", this.f1231b.getStatusCode());
            jSONObject.put("error_code", this.f1231b.getErrorCode());
            jSONObject.put("error_reason", this.f1231b.getErrorReason());
            jSONObject.put("srv_name", this.f1231b.getSrvName());
            jSONObject.put("api_name", this.f1231b.getApiName());
            jSONObject.put("app_id", this.f1231b.getAppID());
            jSONObject.put("pkg_name", this.f1231b.getPkgName());
            jSONObject.put(CommonCode.MapKey.TRANSACTION_ID, this.f1231b.getTransactionId());
            jSONObject.put(CommonCode.MapKey.HAS_RESOLUTION, this.f1231b.getResolution());
            String sessionId = this.f1231b.getSessionId();
            if (!TextUtils.isEmpty(sessionId)) {
                jSONObject.put("session_id", sessionId);
            }
            if (!TextUtils.isEmpty(this.f1230a)) {
                jSONObject.put("body", this.f1230a);
            }
        } catch (JSONException e) {
            HMSLog.m2118e("ResponseWrap", "toJson failed: " + e.getMessage());
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "ResponseWrap{body='" + this.f1230a + "', responseHeader=" + this.f1231b + '}';
    }
}
