package com.bytedance.ies.argus.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'LOAD_STATIC_RESOURCE' uses external variables
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusGlobalAspect;", "", "Lcom/bytedance/ies/argus/bean/IArgusAspect;", "stringValue", "", "type", "Lcom/bytedance/ies/argus/bean/AspectType;", "(Ljava/lang/String;ILjava/lang/String;Lcom/bytedance/ies/argus/bean/AspectType;)V", "getStringValue", "()Ljava/lang/String;", "getType", "()Lcom/bytedance/ies/argus/bean/AspectType;", "ABOUT_TO_PREFETCH", "LOAD_STATIC_RESOURCE", "MOTION_ON_TOUCH", "ABOUT_TO_UPLOAD_FILE", "INJECT_LOGIN_STATE", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class ArgusGlobalAspect implements IArgusAspect {
    public static final ArgusGlobalAspect ABOUT_TO_UPLOAD_FILE;
    public static final ArgusGlobalAspect INJECT_LOGIN_STATE;
    public static final ArgusGlobalAspect LOAD_STATIC_RESOURCE;
    public static final ArgusGlobalAspect MOTION_ON_TOUCH;
    private final String stringValue;
    private final AspectType type;
    public static final ArgusGlobalAspect ABOUT_TO_PREFETCH = new ArgusGlobalAspect("ABOUT_TO_PREFETCH", 0, "about_to_prefetch", null, 2, null);
    private static final /* synthetic */ ArgusGlobalAspect[] $VALUES = $values();

    private static final /* synthetic */ ArgusGlobalAspect[] $values() {
        return new ArgusGlobalAspect[]{ABOUT_TO_PREFETCH, LOAD_STATIC_RESOURCE, MOTION_ON_TOUCH, ABOUT_TO_UPLOAD_FILE, INJECT_LOGIN_STATE};
    }

    public static ArgusGlobalAspect valueOf(String str) {
        return (ArgusGlobalAspect) Enum.valueOf(ArgusGlobalAspect.class, str);
    }

    public static ArgusGlobalAspect[] values() {
        return (ArgusGlobalAspect[]) $VALUES.clone();
    }

    private ArgusGlobalAspect(String str, int i, String str2, AspectType aspectType) {
        this.stringValue = str2;
        this.type = aspectType;
    }

    @Override // com.bytedance.ies.argus.bean.IEnumClass
    public String getStringValue() {
        return this.stringValue;
    }

    /* synthetic */ ArgusGlobalAspect(String str, int i, String str2, AspectType aspectType, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, str2, (i2 & 2) != 0 ? AspectType.GLOBAL : aspectType);
    }

    @Override // com.bytedance.ies.argus.bean.IArgusAspect
    public AspectType getType() {
        return this.type;
    }

    static {
        AspectType aspectType = null;
        int i = 2;
        DefaultConstructorMarker defaultConstructorMarker = null;
        LOAD_STATIC_RESOURCE = new ArgusGlobalAspect("LOAD_STATIC_RESOURCE", 1, "load_static_resource", aspectType, i, defaultConstructorMarker);
        AspectType aspectType2 = null;
        int i2 = 2;
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        MOTION_ON_TOUCH = new ArgusGlobalAspect("MOTION_ON_TOUCH", 2, "motion_on_touch", aspectType2, i2, defaultConstructorMarker2);
        ABOUT_TO_UPLOAD_FILE = new ArgusGlobalAspect("ABOUT_TO_UPLOAD_FILE", 3, "about_to_upload_file", aspectType, i, defaultConstructorMarker);
        INJECT_LOGIN_STATE = new ArgusGlobalAspect("INJECT_LOGIN_STATE", 4, "inject_login_state", aspectType2, i2, defaultConstructorMarker2);
    }
}
