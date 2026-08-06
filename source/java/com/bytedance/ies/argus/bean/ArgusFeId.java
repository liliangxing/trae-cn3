package com.bytedance.ies.argus.bean;

import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import kotlin.Metadata;

/* compiled from: ArgusConstants.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusFeId;", "", "longValue", "", "strValue", "", "(Ljava/lang/String;IJLjava/lang/String;)V", "getLongValue", "()J", "getStrValue", "()Ljava/lang/String;", "SIGN_BUT_VERIFY_ERROR", "UNSET", "NO_AUTH_CONFIG", "NOT_MATCH", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public enum ArgusFeId {
    SIGN_BUT_VERIFY_ERROR(-4, OnekeyLoginConstants.ErrorCode.ERROR_CU_REQUEST_TIMEOUT),
    UNSET(-3, OnekeyLoginConstants.ErrorCode.ERROR_SDK_INIT),
    NO_AUTH_CONFIG(-2, "-2"),
    NOT_MATCH(-1, "-1");

    private final long longValue;
    private final String strValue;

    ArgusFeId(long j, String str) {
        this.longValue = j;
        this.strValue = str;
    }

    public final long getLongValue() {
        return this.longValue;
    }

    public final String getStrValue() {
        return this.strValue;
    }
}
