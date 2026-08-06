package com.bytedance.ies.argus.bean;

import kotlin.Metadata;

/* compiled from: ArgusConstants.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0017\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusLoginStateSourceVerifyReason;", "", "Lcom/bytedance/ies/argus/bean/IArgusVerifyReason;", "code", "", "strValue", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getCode", "()I", "getStrValue", "()Ljava/lang/String;", "NOT_HTTPS", "CONFIG_IS_EMPTY", "NOT_MATCH", "MATCH", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public enum ArgusLoginStateSourceVerifyReason implements IArgusVerifyReason {
    NOT_HTTPS(-3, "not https"),
    CONFIG_IS_EMPTY(-2, "config is empty"),
    NOT_MATCH(-1, "not match white list"),
    MATCH(1, "match white list");

    private final int code;
    private final String strValue;

    ArgusLoginStateSourceVerifyReason(int i, String str) {
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
