package com.bytedance.ies.argus.bean;

import com.bytedance.ies.bullet.base.utils.logger.LoggerStage;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'WEB_REDIRECT' uses external variables
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B#\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ies/argus/bean/ArgusWebViewAspect;", "", "Lcom/bytedance/ies/argus/bean/IArgusViewAspect;", "stringValue", "", "type", "Lcom/bytedance/ies/argus/bean/AspectType;", "containerType", "Lcom/bytedance/ies/argus/bean/ArgusContainerType;", "(Ljava/lang/String;ILjava/lang/String;Lcom/bytedance/ies/argus/bean/AspectType;Lcom/bytedance/ies/argus/bean/ArgusContainerType;)V", "getContainerType", "()Lcom/bytedance/ies/argus/bean/ArgusContainerType;", "getStringValue", "()Ljava/lang/String;", "getType", "()Lcom/bytedance/ies/argus/bean/AspectType;", "LOAD_URL", "WEB_REDIRECT", "SHOULD_INTERCEPT_REQUEST", "ON_WEBVIEW_CREATED", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class ArgusWebViewAspect implements IArgusViewAspect {
    public static final ArgusWebViewAspect ON_WEBVIEW_CREATED;
    public static final ArgusWebViewAspect WEB_REDIRECT;
    private final ArgusContainerType containerType;
    private final String stringValue;
    private final AspectType type;
    public static final ArgusWebViewAspect LOAD_URL = new ArgusWebViewAspect("LOAD_URL", 0, LoggerStage.WEB_LOAD_URL, null, null, 6, null);
    public static final ArgusWebViewAspect SHOULD_INTERCEPT_REQUEST = new ArgusWebViewAspect("SHOULD_INTERCEPT_REQUEST", 2, "should_intercept_request", 0 == true ? 1 : 0, null, 6, null);
    private static final /* synthetic */ ArgusWebViewAspect[] $VALUES = $values();

    private static final /* synthetic */ ArgusWebViewAspect[] $values() {
        return new ArgusWebViewAspect[]{LOAD_URL, WEB_REDIRECT, SHOULD_INTERCEPT_REQUEST, ON_WEBVIEW_CREATED};
    }

    public static ArgusWebViewAspect valueOf(String str) {
        return (ArgusWebViewAspect) Enum.valueOf(ArgusWebViewAspect.class, str);
    }

    public static ArgusWebViewAspect[] values() {
        return (ArgusWebViewAspect[]) $VALUES.clone();
    }

    private ArgusWebViewAspect(String str, int i, String str2, AspectType aspectType, ArgusContainerType argusContainerType) {
        this.stringValue = str2;
        this.type = aspectType;
        this.containerType = argusContainerType;
    }

    @Override // com.bytedance.ies.argus.bean.IEnumClass
    public String getStringValue() {
        return this.stringValue;
    }

    /* synthetic */ ArgusWebViewAspect(String str, int i, String str2, AspectType aspectType, ArgusContainerType argusContainerType, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, str2, (i2 & 2) != 0 ? AspectType.VIEW : aspectType, (i2 & 4) != 0 ? ArgusContainerType.WEB : argusContainerType);
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
        WEB_REDIRECT = new ArgusWebViewAspect("WEB_REDIRECT", 1, "web_redirect", aspectType, argusContainerType, i, defaultConstructorMarker);
        ON_WEBVIEW_CREATED = new ArgusWebViewAspect("ON_WEBVIEW_CREATED", 3, "on_webview_created", aspectType, argusContainerType, i, defaultConstructorMarker);
    }
}
