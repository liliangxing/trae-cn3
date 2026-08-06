package com.bytedance.ies.argus.bean;

import kotlin.Metadata;

/* compiled from: ArgusConstants.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0017\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$¨\u0006%"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusCommonVerifyReason;", "", "Lcom/bytedance/ies/argus/bean/IArgusVerifyReason;", "code", "", "strValue", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getCode", "()I", "getStrValue", "()Ljava/lang/String;", "REWRITE_BY_EXTERN_SERVICE", "BLOCK_BY_EXTERN_SERVICE", "BLOCK_BY_SEC_LINK_HANDLE", "UN_SET", "ASYNC_PASS_FIRST", "PASS_STRATEGY_CALCULATE", "PASS_BY_SEC_LINK_HANDLE", "SEC_LINK_STRATEGY_IS_NULL", "TTM_IS_NOT_ENABLED", "TTM_RULE_NAME_IS_NULL", "TTM_RULE_VERSION_IS_NULL", "TTM_RULE_INFO_IS_NULL", "TTM_RULE_ADDRESS_IS_NULL", "RUN_TTM_ERROR", "MISMATCH_PARAMS_TYPE", "TRY_CATCH_ERROR", "STRATEGY_RULE_NAME_IS_NULL", "ASPECT_CONFIG_IS_NULL", "CLIENT_STRATEGY_PROVIDER_NOT_FOUND", "STRATEGY_RULE_LIST_IS_EMPTY", "ASPECT_IS_REPORT_ONLY", "ASPECT_IS_OFF", "DISABLE_BY_RECOVERY", "TTM_STRATEGY_PROVIDER_NOT_FOUND", "STRATEGY_CONFIG_IS_NULL", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public enum ArgusCommonVerifyReason implements IArgusVerifyReason {
    REWRITE_BY_EXTERN_SERVICE(-3, "rewrite by extern service"),
    BLOCK_BY_EXTERN_SERVICE(-2, "block by extern service"),
    BLOCK_BY_SEC_LINK_HANDLE(-1, "block handle by secLink strategy"),
    UN_SET(0, "unset"),
    ASYNC_PASS_FIRST(1, "async pass first"),
    PASS_STRATEGY_CALCULATE(2, "pass calculate"),
    PASS_BY_SEC_LINK_HANDLE(3, "pass by secLink handle"),
    SEC_LINK_STRATEGY_IS_NULL(4, "secLink strategy is null"),
    TTM_IS_NOT_ENABLED(1001, "ttm is not enabled"),
    TTM_RULE_NAME_IS_NULL(1002, "ttm rule name is null"),
    TTM_RULE_VERSION_IS_NULL(1003, "ttm rule version is null"),
    TTM_RULE_INFO_IS_NULL(1004, "ttm rule info is null"),
    TTM_RULE_ADDRESS_IS_NULL(1005, "ttm rule address is null"),
    RUN_TTM_ERROR(1006, "run ttm error"),
    MISMATCH_PARAMS_TYPE(1007, "mismatch param type"),
    TRY_CATCH_ERROR(1008, "try catch error"),
    STRATEGY_RULE_NAME_IS_NULL(1009, "strategy rule name is null"),
    ASPECT_CONFIG_IS_NULL(1010, "aspect config is null"),
    CLIENT_STRATEGY_PROVIDER_NOT_FOUND(1011, "client strategy provider not found"),
    STRATEGY_RULE_LIST_IS_EMPTY(1012, "strategy rule list is empty"),
    ASPECT_IS_REPORT_ONLY(1013, "aspect switch is report only"),
    ASPECT_IS_OFF(1014, "aspect switch is off"),
    DISABLE_BY_RECOVERY(1015, "disable by recovery"),
    TTM_STRATEGY_PROVIDER_NOT_FOUND(1016, "ttm strategy provider not found"),
    STRATEGY_CONFIG_IS_NULL(1017, "strategy config is null");

    private final int code;
    private final String strValue;

    ArgusCommonVerifyReason(int i, String str) {
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
