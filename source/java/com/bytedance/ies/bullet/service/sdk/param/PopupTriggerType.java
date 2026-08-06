package com.bytedance.ies.bullet.service.sdk.param;

import kotlin.Metadata;

/* compiled from: PopupTriggerParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/bullet/service/sdk/param/PopupTriggerType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "FINISH", "HIDE", "KEEP", "RESUME", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public enum PopupTriggerType {
    FINISH("0"),
    HIDE("1"),
    KEEP("2"),
    RESUME("3");

    private final String value;

    PopupTriggerType(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
