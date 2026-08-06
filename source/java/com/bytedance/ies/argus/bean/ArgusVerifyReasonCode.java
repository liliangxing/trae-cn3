package com.bytedance.ies.argus.bean;

import kotlin.Metadata;

/* compiled from: ArgusConstants.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusVerifyReasonCode;", "", "()V", "ASYNC_PASS_FIRST", "", "EMPTY_STRATEGY_RULE", "PARAMS_RETURNED_BY_EXECUTOR", "RUN_TTM_ERROR", "TRIGGERED_CHECK_BLOCKED", "TRIGGERED_CHECK_PASS", "TRY_CATCH_ERROR", "UN_SET", "toString", "", "value", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class ArgusVerifyReasonCode {
    public static final int ASYNC_PASS_FIRST = 1;
    public static final int EMPTY_STRATEGY_RULE = 105;
    public static final ArgusVerifyReasonCode INSTANCE = new ArgusVerifyReasonCode();
    public static final int PARAMS_RETURNED_BY_EXECUTOR = 11;
    public static final int RUN_TTM_ERROR = 104;
    public static final int TRIGGERED_CHECK_BLOCKED = -10;
    public static final int TRIGGERED_CHECK_PASS = 10;
    public static final int TRY_CATCH_ERROR = 103;
    public static final int UN_SET = 0;

    public final String toString(int value) {
        if (value == -10) {
            return "has triggered to check and block";
        }
        if (value == 0) {
            return "unset";
        }
        if (value == 10) {
            return "has triggered to check and pass";
        }
        if (value == 11) {
            return "value is return by executor";
        }
        switch (value) {
            case 103:
                return "try catch error";
            case 104:
                return "run ttm error";
            case 105:
                return "calculate with empty rule";
            default:
                return "unknown";
        }
    }

    private ArgusVerifyReasonCode() {
    }
}
