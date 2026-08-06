package com.bytedance.ies.argus.bean;

import kotlin.Metadata;

/* compiled from: ArgusConstants.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0017\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b ¨\u0006!"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusLynxSignVerifyReason;", "", "Lcom/bytedance/ies/argus/bean/IArgusVerifyReason;", "code", "", "strValue", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getCode", "()I", "getStrValue", "()Ljava/lang/String;", "TASM_SIGN_FAIL", "NO_CONFIG", "UN_KNOWN", "URL_DEGRADE_FAILED", "DISABLE_GLOBAL_SIGN", "TASM_PARSE_FAILED", "FORCE_USE_URL_VERIFY_FAILED", "FORBID_FE_PAGE_LOAD_SOURCE", "SIGN_SUCCESS", "URL_DEGRADE_SUCCESS", "NOT_VERIFY_UNSIGNED_FILE", "VERIFY_ONLY_NO_CONFIG", "CONTAINER_DISABLE_SIGN", "DEBUG_DISABLE_LYNX_SIGN_VERIFY", "FE_PAGE_LOAD_LIMIT_SOURCE_PASS_NOT_MAIN_TEMPLATE", "FE_PAGE_LOAD_LIMIT_SOURCE_PASS", "LOGIC_ERROR", "FORCE_USE_URL_VERIFY_SUCCESS", "USE_DEGRAED_BUT_WHITE_LIST_IS_NULL", "TS_VERIFY_PARAMS_IS_NULL", "FE_PAGE_LOAD_LIMIT_SOURCE_ABNORMAL_PASS_NO_VIEW", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public enum ArgusLynxSignVerifyReason implements IArgusVerifyReason {
    TASM_SIGN_FAIL(-1, "lynx sign verify failed"),
    NO_CONFIG(-2, "no fe public key"),
    UN_KNOWN(-3, "unknown"),
    URL_DEGRADE_FAILED(-4, "url degrade failed"),
    DISABLE_GLOBAL_SIGN(-5, "disable global sign"),
    TASM_PARSE_FAILED(-6, "parse tasm failed"),
    FORCE_USE_URL_VERIFY_FAILED(-7, "force use url verify failed"),
    FORBID_FE_PAGE_LOAD_SOURCE(-10, "fe enable load source verify but not match"),
    SIGN_SUCCESS(1, "sign success"),
    URL_DEGRADE_SUCCESS(2, "url degrade success"),
    NOT_VERIFY_UNSIGNED_FILE(3, "not verify unsigned failed"),
    VERIFY_ONLY_NO_CONFIG(4, "mode is verify only, no config"),
    CONTAINER_DISABLE_SIGN(5, "container disable sign"),
    DEBUG_DISABLE_LYNX_SIGN_VERIFY(6, "disable lynx sign verify in debug env"),
    FE_PAGE_LOAD_LIMIT_SOURCE_PASS_NOT_MAIN_TEMPLATE(7, "fe enable load source verify, pass because not main template"),
    FE_PAGE_LOAD_LIMIT_SOURCE_PASS(8, "fe enable load source verify and pass"),
    LOGIC_ERROR(102, "logic error"),
    FORCE_USE_URL_VERIFY_SUCCESS(104, "force use url verify success"),
    USE_DEGRAED_BUT_WHITE_LIST_IS_NULL(105, "use degrade but white list is null"),
    TS_VERIFY_PARAMS_IS_NULL(107, "ts verify param is null"),
    FE_PAGE_LOAD_LIMIT_SOURCE_ABNORMAL_PASS_NO_VIEW(108, "fe enable load source verify, pass because no view");

    private final int code;
    private final String strValue;

    ArgusLynxSignVerifyReason(int i, String str) {
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
