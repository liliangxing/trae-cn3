package com.bytedance.ies.argus.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ArgusConstants.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusContainerAspect;", "", "Lcom/bytedance/ies/argus/bean/IArgusAspect;", "stringValue", "", "type", "Lcom/bytedance/ies/argus/bean/AspectType;", "(Ljava/lang/String;ILjava/lang/String;Lcom/bytedance/ies/argus/bean/AspectType;)V", "getStringValue", "()Ljava/lang/String;", "getType", "()Lcom/bytedance/ies/argus/bean/AspectType;", "CONTAINER_CREATED", "JSB_CALL", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public enum ArgusContainerAspect implements IArgusAspect {
    CONTAINER_CREATED("container_created", null, 2, null),
    JSB_CALL("jsb_call", null, 2, null);

    private final String stringValue;
    private final AspectType type;

    ArgusContainerAspect(String str, AspectType aspectType) {
        this.stringValue = str;
        this.type = aspectType;
    }

    @Override // com.bytedance.ies.argus.bean.IEnumClass
    public String getStringValue() {
        return this.stringValue;
    }

    /* synthetic */ ArgusContainerAspect(String str, AspectType aspectType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? AspectType.CONTAINER : aspectType);
    }

    @Override // com.bytedance.ies.argus.bean.IArgusAspect
    public AspectType getType() {
        return this.type;
    }
}
