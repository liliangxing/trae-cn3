package com.bytedance.ies.argus.bean;

import kotlin.Metadata;

/* compiled from: ArgusConstants.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0017\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusJSBCallVerifyReason;", "", "Lcom/bytedance/ies/argus/bean/IArgusVerifyReason;", "code", "", "strValue", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getCode", "()I", "getStrValue", "()Ljava/lang/String;", "NO_FE_ID_CONFIG", "NOT_IN_SAFE_URl", "IN_EXCLUDE_METHODS", "SECURE_NOT_INCLUDE", "RULE_DENY_NOT_INCLUDE", "NOT_IN_SAFE_URL", "OVER_CALL_FREQ", "OVER_CALL_TIMES", "UN_KNOWN", "URL_EMPTY", "REQUEST_CHECK_DENY", "IN_INCLUDE_METHODS", "PASS_GROUP_COMPARE", "GLOBAL_DISABLE_LYNX_AUTH", "LYNX_INVALID_FE_ID", "LYNX_AUTH_CONFIG_IS_NULL", "AUTH_URL_IS_NULL", "DEBUG_DISABLE_LYNX_JSB_AUTH", "RECOVERY_DISABLE_LYNX_JSB_AUTH", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public enum ArgusJSBCallVerifyReason implements IArgusVerifyReason {
    NO_FE_ID_CONFIG(-1, "app id is not legal"),
    NOT_IN_SAFE_URl(-2, "not in safe url"),
    IN_EXCLUDE_METHODS(-3, "method in exclude methods"),
    SECURE_NOT_INCLUDE(-4, "method is secure, but not in include method"),
    RULE_DENY_NOT_INCLUDE(-5, "method < rule"),
    NOT_IN_SAFE_URL(-6, "auth url is not in method secure url"),
    OVER_CALL_FREQ(-7, "jsb call over call freq limit"),
    OVER_CALL_TIMES(-8, "jsb call over call times limit"),
    UN_KNOWN(-9, "unknown reason"),
    URL_EMPTY(-11, "auth url is empty"),
    REQUEST_CHECK_DENY(-12, "failed_request_parameters_check_deny"),
    IN_INCLUDE_METHODS(2, "method in included methods"),
    PASS_GROUP_COMPARE(3, "pass group compare"),
    GLOBAL_DISABLE_LYNX_AUTH(1001, "global disable lynx jsb auth"),
    LYNX_INVALID_FE_ID(1002, "lynx invalid fe id"),
    LYNX_AUTH_CONFIG_IS_NULL(1003, "lynx auth config is null"),
    AUTH_URL_IS_NULL(1004, "auth url is null"),
    DEBUG_DISABLE_LYNX_JSB_AUTH(1005, "disable lynx jsb auth in debug env"),
    RECOVERY_DISABLE_LYNX_JSB_AUTH(1006, "recovery disable lynx jsb auth");

    private final int code;
    private final String strValue;

    ArgusJSBCallVerifyReason(int i, String str) {
        this.code = i;
        this.strValue = str;
    }

    @Override // com.bytedance.ies.argus.bean.IArgusVerifyReason
    public int getCode() {
        return this.code;
    }

    @Override // com.bytedance.ies.argus.bean.IArgusVerifyReason
    public String getStrValue() {
        return this.strValue;
    }
}
