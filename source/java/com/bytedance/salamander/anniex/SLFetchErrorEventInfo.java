package com.bytedance.salamander.anniex;

import com.bytedance.notification.Constants;
import com.bytedance.rts.foundation.Date;
import com.bytedance.rts.foundation.Float64;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnniexMonitorEventTypingsInfoFetchErrorEvent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u001d\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001a\u0010\u001e\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR\u001a\u0010!\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001c\u0010$\u001a\u0004\u0018\u00010\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001a\u0010'\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\f\"\u0004\b)\u0010\u000eR\u001a\u0010*\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\b¨\u0006-"}, d2 = {"Lcom/bytedance/salamander/anniex/SLFetchErrorEventInfo;", "Lcom/bytedance/salamander/anniex/IEventInfo;", "()V", Constants.EVENT_PARAMS_KEY_ERROR_MSG, "", "getError_msg", "()Ljava/lang/String;", "setError_msg", "(Ljava/lang/String;)V", "error_no", "", "getError_no", "()I", "setError_no", "(I)V", "error_ts", "", "getError_ts", "()J", "setError_ts", "(J)V", "jsb_name", "getJsb_name", "setJsb_name", "log_id", "getLog_id", "setLog_id", "method", "getMethod", "setMethod", "request_error_code", "getRequest_error_code", "setRequest_error_code", "request_error_msg", "getRequest_error_msg", "setRequest_error_msg", "root_cause", "getRoot_cause", "setRoot_cause", "status_code", "getStatus_code", "setStatus_code", "url", "getUrl", "setUrl", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SLFetchErrorEventInfo implements IEventInfo {
    private int error_no;
    private String log_id;
    private int request_error_code;
    private String root_cause;
    private int status_code;
    private String error_msg = "";
    private String method = "";
    private String url = "";
    private String jsb_name = "";
    private String request_error_msg = "";
    private long error_ts = Float64.INSTANCE.toInt64(Date.INSTANCE.now_v2());

    public int getError_no() {
        return this.error_no;
    }

    public void setError_no(int i) {
        this.error_no = i;
    }

    public String getError_msg() {
        return this.error_msg;
    }

    public void setError_msg(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.error_msg = str;
    }

    public String getMethod() {
        return this.method;
    }

    public void setMethod(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.method = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }

    public String getJsb_name() {
        return this.jsb_name;
    }

    public void setJsb_name(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.jsb_name = str;
    }

    public int getStatus_code() {
        return this.status_code;
    }

    public void setStatus_code(int i) {
        this.status_code = i;
    }

    public int getRequest_error_code() {
        return this.request_error_code;
    }

    public void setRequest_error_code(int i) {
        this.request_error_code = i;
    }

    public String getRequest_error_msg() {
        return this.request_error_msg;
    }

    public void setRequest_error_msg(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.request_error_msg = str;
    }

    public String getLog_id() {
        return this.log_id;
    }

    public void setLog_id(String str) {
        this.log_id = str;
    }

    public long getError_ts() {
        return this.error_ts;
    }

    public void setError_ts(long j) {
        this.error_ts = j;
    }

    public String getRoot_cause() {
        return this.root_cause;
    }

    public void setRoot_cause(String str) {
        this.root_cause = str;
    }
}
