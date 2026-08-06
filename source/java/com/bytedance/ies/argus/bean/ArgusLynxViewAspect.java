package com.bytedance.ies.argus.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'LOAD_TEMPLATE' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:293)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:266)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: ArgusConstants.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B#\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusLynxViewAspect;", "", "Lcom/bytedance/ies/argus/bean/IArgusViewAspect;", "stringValue", "", "type", "Lcom/bytedance/ies/argus/bean/AspectType;", "containerType", "Lcom/bytedance/ies/argus/bean/ArgusContainerType;", "(Ljava/lang/String;ILjava/lang/String;Lcom/bytedance/ies/argus/bean/AspectType;Lcom/bytedance/ies/argus/bean/ArgusContainerType;)V", "getContainerType", "()Lcom/bytedance/ies/argus/bean/ArgusContainerType;", "getStringValue", "()Ljava/lang/String;", "getType", "()Lcom/bytedance/ies/argus/bean/AspectType;", "ABOUT_TO_LOAD_TEMPLATE", "LOAD_TEMPLATE", "EXIT", "ABOUT_TO_REQUEST_LYNX_SSR_URL", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class ArgusLynxViewAspect implements IArgusViewAspect {
    public static final ArgusLynxViewAspect ABOUT_TO_REQUEST_LYNX_SSR_URL;
    public static final ArgusLynxViewAspect LOAD_TEMPLATE;
    private final ArgusContainerType containerType;
    private final String stringValue;
    private final AspectType type;
    public static final ArgusLynxViewAspect ABOUT_TO_LOAD_TEMPLATE = new ArgusLynxViewAspect("ABOUT_TO_LOAD_TEMPLATE", 0, "about_to_load_template", null, null, 6, null);
    public static final ArgusLynxViewAspect EXIT = new ArgusLynxViewAspect("EXIT", 2, "exit", 0 == true ? 1 : 0, null, 6, null);
    private static final /* synthetic */ ArgusLynxViewAspect[] $VALUES = $values();

    private static final /* synthetic */ ArgusLynxViewAspect[] $values() {
        return new ArgusLynxViewAspect[]{ABOUT_TO_LOAD_TEMPLATE, LOAD_TEMPLATE, EXIT, ABOUT_TO_REQUEST_LYNX_SSR_URL};
    }

    public static ArgusLynxViewAspect valueOf(String str) {
        return (ArgusLynxViewAspect) Enum.valueOf(ArgusLynxViewAspect.class, str);
    }

    public static ArgusLynxViewAspect[] values() {
        return (ArgusLynxViewAspect[]) $VALUES.clone();
    }

    private ArgusLynxViewAspect(String str, int i, String str2, AspectType aspectType, ArgusContainerType argusContainerType) {
        this.stringValue = str2;
        this.type = aspectType;
        this.containerType = argusContainerType;
    }

    @Override // com.bytedance.ies.argus.bean.IEnumClass
    public String getStringValue() {
        return this.stringValue;
    }

    /* synthetic */ ArgusLynxViewAspect(String str, int i, String str2, AspectType aspectType, ArgusContainerType argusContainerType, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, str2, (i2 & 2) != 0 ? AspectType.VIEW : aspectType, (i2 & 4) != 0 ? ArgusContainerType.LYNX : argusContainerType);
    }

    @Override // com.bytedance.ies.argus.bean.IArgusAspect
    public AspectType getType() {
        return this.type;
    }

    @Override // com.bytedance.ies.argus.bean.IArgusViewAspect
    public ArgusContainerType getContainerType() {
        return this.containerType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        AspectType aspectType = null;
        ArgusContainerType argusContainerType = null;
        int i = 6;
        DefaultConstructorMarker defaultConstructorMarker = null;
        LOAD_TEMPLATE = new ArgusLynxViewAspect("LOAD_TEMPLATE", 1, "load_template", aspectType, argusContainerType, i, defaultConstructorMarker);
        ABOUT_TO_REQUEST_LYNX_SSR_URL = new ArgusLynxViewAspect("ABOUT_TO_REQUEST_LYNX_SSR_URL", 3, "about_to_request_lynx_ssr_url", aspectType, argusContainerType, i, defaultConstructorMarker);
    }
}
