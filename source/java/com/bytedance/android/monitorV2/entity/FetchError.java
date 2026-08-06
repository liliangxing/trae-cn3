package com.bytedance.android.monitorV2.entity;

import com.bytedance.android.monitorV2.constant.MonitorConstant;
import com.bytedance.android.monitorV2.util.JsonUtils;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class FetchError {
    public int errorCode;
    public String errorMessage;
    public int hitPrefetch;
    public int jsbReturn;
    public String logId;
    public String method;
    public int requestErrorCode;
    public String requestErrorMsg;
    public int statusCode;
    public String url;

    public String toString() {
        return "FetchError{method='" + this.method + "', url='" + this.url + "', errorMessage='" + this.errorMessage + "', errorCode=" + this.errorCode + ", statusCode=" + this.statusCode + ", requestErrorCode=" + this.requestErrorCode + ", requestErrorMsg='" + this.requestErrorMsg + "', jsbReturn=" + this.jsbReturn + ", hitPrefetch=" + this.hitPrefetch + AbstractJsonLexerKt.END_OBJ;
    }

    public void fillInJsonObject(JSONObject jSONObject) {
        JsonUtils.safePut(jSONObject, "event_type", "fetchError");
        JsonUtils.safePut(jSONObject, "error_no", this.errorCode);
        JsonUtils.safePut(jSONObject, "error_msg", this.errorMessage);
        JsonUtils.safePut(jSONObject, "method", this.method);
        JsonUtils.safePut(jSONObject, "url", this.url);
        JsonUtils.safePut(jSONObject, "status_code", this.statusCode);
        JsonUtils.safePut(jSONObject, "request_error_code", this.requestErrorCode);
        JsonUtils.safePut(jSONObject, "request_error_msg", this.requestErrorMsg);
        JsonUtils.safePut(jSONObject, "jsb_ret", this.jsbReturn);
        JsonUtils.safePut(jSONObject, "hit_prefetch", this.hitPrefetch);
        JsonUtils.safePut(jSONObject, MonitorConstant.TT_LOG_ID, this.logId);
    }
}
