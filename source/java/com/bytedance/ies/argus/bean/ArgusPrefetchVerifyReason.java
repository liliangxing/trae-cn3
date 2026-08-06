package com.bytedance.ies.argus.bean;

import kotlin.Metadata;

/* compiled from: ArgusConstants.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0017\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusPrefetchVerifyReason;", "", "Lcom/bytedance/ies/argus/bean/IArgusVerifyReason;", "code", "", "strValue", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getCode", "()I", "getStrValue", "()Ljava/lang/String;", "NOT_MATCH", "PREFETCH_HOST_UNPARSEABLE", "NOT_END_WITH_CORRECT_SUFFIX", "MATCH", "EMPTY_HOST", "PREFETCH_LOAD_OFFLINE_CONFIG", "DEBUG_DISABLE_PREFETCH_VERIFY", "RECOVERY_DISABLE_PREFETCH_VERIFY", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public enum ArgusPrefetchVerifyReason implements IArgusVerifyReason {
    NOT_MATCH(-1, "not match white list"),
    PREFETCH_HOST_UNPARSEABLE(-2, "prefetch host unparseable"),
    NOT_END_WITH_CORRECT_SUFFIX(-3, "not end with correct suffix"),
    MATCH(1, "match white list"),
    EMPTY_HOST(2, "empty host"),
    PREFETCH_LOAD_OFFLINE_CONFIG(3, "prefetch load offline config"),
    DEBUG_DISABLE_PREFETCH_VERIFY(6, "disable prefetch verify in debug env"),
    RECOVERY_DISABLE_PREFETCH_VERIFY(1001, "recovery disable prefetch verify");

    private final int code;
    private final String strValue;

    ArgusPrefetchVerifyReason(int i, String str) {
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
