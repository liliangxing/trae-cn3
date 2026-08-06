package com.bytedance.ies.argus.api.params;

import kotlin.Metadata;

/* compiled from: WebLoadUrlParams.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/argus/api/params/WebLoadPageType;", "", "strValue", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getStrValue", "()Ljava/lang/String;", "WHITE_INNER", "GREY_SEC_LINK", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public enum WebLoadPageType {
    WHITE_INNER("white_inner"),
    GREY_SEC_LINK("grey_secLink");

    private final String strValue;

    WebLoadPageType(String str) {
        this.strValue = str;
    }

    public final String getStrValue() {
        return this.strValue;
    }
}
