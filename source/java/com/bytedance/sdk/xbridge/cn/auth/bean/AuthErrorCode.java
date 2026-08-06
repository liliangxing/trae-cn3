package com.bytedance.sdk.xbridge.cn.auth.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AuthResult.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthErrorCode;", "", "code", "", "msg", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getCode", "()I", "getMsg", "()Ljava/lang/String;", "NO_FE_ID_CONFIG", "NOT_IN_SAFE_URl", "IN_EXCLUDE_METHODS", "SECURE_NOT_INCLUDE", "RULE_DENY_NOT_INCLUDE", "WEB_BOT_IN_URL", "OVER_CALL_FREQ", "OVER_CALL_TIMES", "UN_KNOWN", "URL_EMPTY", "REQUEST_CHECK_DENY", "BLOCK_BY_BIZ_SERVICE", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public enum AuthErrorCode {
    NO_FE_ID_CONFIG(-1, "app id is not legal"),
    NOT_IN_SAFE_URl(-2, "not in safe url"),
    IN_EXCLUDE_METHODS(-3, "method in exclude methods"),
    SECURE_NOT_INCLUDE(-4, "method is secure,and not in include method,fail"),
    RULE_DENY_NOT_INCLUDE(-5, "method < rule"),
    WEB_BOT_IN_URL(-6, "auth url is not in method secure url"),
    OVER_CALL_FREQ(-7, "jsb call over call freq limits"),
    OVER_CALL_TIMES(-8, "jsb call over call times limits"),
    UN_KNOWN(-9, "unknown reason"),
    URL_EMPTY(-11, "auth url is empty"),
    REQUEST_CHECK_DENY(-12, "failed_request_parameters_check_deny"),
    BLOCK_BY_BIZ_SERVICE(-13, "block by biz service");

    private final int code;
    private final String msg;

    AuthErrorCode(int i, String str) {
        this.code = i;
        this.msg = str;
    }

    /* synthetic */ AuthErrorCode(int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : str);
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMsg() {
        return this.msg;
    }
}
