package com.bytedance.ies.xbridge.model.item;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XBaseParamResultItem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ies/xbridge/model/item/XBaseParamResultItem;", "", "name", "", "(Ljava/lang/String;)V", "defaultValue", "getDefaultValue", "()Ljava/lang/Object;", "setDefaultValue", "(Ljava/lang/Object;)V", "getName", "()Ljava/lang/String;", "optional", "", "getOptional", "()Z", "setOptional", "(Z)V", "type", "getType", "setType", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class XBaseParamResultItem {
    private Object defaultValue;
    private final String name;
    private boolean optional;
    private String type;

    public XBaseParamResultItem(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.type = "";
        this.optional = true;
    }

    public final String getName() {
        return this.name;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.type = str;
    }

    public final boolean getOptional() {
        return this.optional;
    }

    public final void setOptional(boolean z) {
        this.optional = z;
    }

    public final Object getDefaultValue() {
        return this.defaultValue;
    }

    public final void setDefaultValue(Object obj) {
        this.defaultValue = obj;
    }
}
