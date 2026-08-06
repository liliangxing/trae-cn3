package com.bytedance.android.monitorV2.lynx.data.entity;

import com.bytedance.android.monitorV2.base.BaseNativeInfo;
import com.bytedance.android.monitorV2.constant.MonitorConstant;
import com.bytedance.android.monitorV2.util.JsonUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: LynxJsbFetchErrorData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u001a\u0010\u001b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR\u001a\u0010!\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001c\u0010$\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u000e¨\u0006+"}, d2 = {"Lcom/bytedance/android/monitorV2/lynx/data/entity/LynxJsbFetchErrorData;", "Lcom/bytedance/android/monitorV2/base/BaseNativeInfo;", "()V", "errorCode", "", "getErrorCode", "()I", "setErrorCode", "(I)V", "errorMessage", "", "getErrorMessage", "()Ljava/lang/String;", "setErrorMessage", "(Ljava/lang/String;)V", "hitPrefetch", "getHitPrefetch", "setHitPrefetch", "jsbReturn", "getJsbReturn", "setJsbReturn", "logId", "getLogId", "setLogId", "method", "getMethod", "setMethod", "requestErrorCode", "getRequestErrorCode", "setRequestErrorCode", "requestErrorMsg", "getRequestErrorMsg", "setRequestErrorMsg", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "getStatusCode", "setStatusCode", "url", "getUrl", "setUrl", "fillInJsonObject", "", "jsonObject", "Lorg/json/JSONObject;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class LynxJsbFetchErrorData extends BaseNativeInfo {
    private int errorCode;
    private String errorMessage;
    private int hitPrefetch;
    private int jsbReturn;
    private String logId;
    private String method;
    private int requestErrorCode;
    private String requestErrorMsg;
    private int statusCode;
    private String url;

    public LynxJsbFetchErrorData() {
        super("fetchError");
    }

    public final String getMethod() {
        return this.method;
    }

    public final void setMethod(String str) {
        this.method = str;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final void setStatusCode(int i) {
        this.statusCode = i;
    }

    public final int getRequestErrorCode() {
        return this.requestErrorCode;
    }

    public final void setRequestErrorCode(int i) {
        this.requestErrorCode = i;
    }

    public final String getRequestErrorMsg() {
        return this.requestErrorMsg;
    }

    public final void setRequestErrorMsg(String str) {
        this.requestErrorMsg = str;
    }

    public final int getJsbReturn() {
        return this.jsbReturn;
    }

    public final void setJsbReturn(int i) {
        this.jsbReturn = i;
    }

    public final int getHitPrefetch() {
        return this.hitPrefetch;
    }

    public final void setHitPrefetch(int i) {
        this.hitPrefetch = i;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final void setErrorCode(int i) {
        this.errorCode = i;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final void setLogId(String str) {
        this.logId = str;
    }

    @Override // com.bytedance.android.monitorV2.base.BaseMonitorData
    public void fillInJsonObject(JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        JsonUtils.safePut(jsonObject, "method", this.method);
        JsonUtils.safePut(jsonObject, "error_no", this.errorCode);
        JsonUtils.safePut(jsonObject, "error_msg", this.errorMessage);
        JsonUtils.safePut(jsonObject, "url", this.url);
        JsonUtils.safePut(jsonObject, "status_code", this.statusCode);
        JsonUtils.safePut(jsonObject, "request_error_code", this.requestErrorCode);
        JsonUtils.safePut(jsonObject, "request_error_msg", this.requestErrorMsg);
        JsonUtils.safePut(jsonObject, "jsb_ret", this.jsbReturn);
        JsonUtils.safePut(jsonObject, "hit_prefetch", this.hitPrefetch);
        JsonUtils.safePut(jsonObject, MonitorConstant.TT_LOG_ID, this.logId);
    }
}
