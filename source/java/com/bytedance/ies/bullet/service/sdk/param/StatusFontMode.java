package com.bytedance.ies.bullet.service.sdk.param;

import com.bytedance.ies.xbridge.XBridge;
import kotlin.Metadata;

/* compiled from: StatusFontModeParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/bullet/service/sdk/param/StatusFontMode;", "", "value", "", "aliasValue", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getAliasValue", "()Ljava/lang/String;", "getValue", "LIGHT", "DARK", XBridge.DEFAULT_NAMESPACE, "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public enum StatusFontMode {
    LIGHT("light", "0"),
    DARK("dark", "1"),
    DEFAULT("default", "2");

    private final String aliasValue;
    private final String value;

    StatusFontMode(String str, String str2) {
        this.value = str;
        this.aliasValue = str2;
    }

    public final String getAliasValue() {
        return this.aliasValue;
    }

    public final String getValue() {
        return this.value;
    }
}
