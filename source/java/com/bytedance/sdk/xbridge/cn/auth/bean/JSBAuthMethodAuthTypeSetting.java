package com.bytedance.sdk.xbridge.cn.auth.bean;

import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: JSBAuthStrategyConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u001e\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0002\u0010\u0018J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0015\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003JX\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020\u00032\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u000bHÖ\u0001J\t\u0010(\u001a\u00020\u0006HÖ\u0001R&\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\"\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001a¨\u0006)"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/bean/JSBAuthMethodAuthTypeSetting;", "", "enableWebForcePrivate", "", "webPublicMethod", "", "", "enableLynxForcePrivate", "lynxPublicMethod", "commonSecureMethod", "", "", "(Z[Ljava/lang/String;Z[Ljava/lang/String;Ljava/util/Map;)V", "getCommonSecureMethod", "()Ljava/util/Map;", "setCommonSecureMethod", "(Ljava/util/Map;)V", "getEnableLynxForcePrivate", "()Z", "setEnableLynxForcePrivate", "(Z)V", "getEnableWebForcePrivate", "setEnableWebForcePrivate", "getLynxPublicMethod", "()[Ljava/lang/String;", "setLynxPublicMethod", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "getWebPublicMethod", "setWebPublicMethod", "component1", "component2", "component3", "component4", "component5", "copy", "(Z[Ljava/lang/String;Z[Ljava/lang/String;Ljava/util/Map;)Lcom/bytedance/sdk/xbridge/cn/auth/bean/JSBAuthMethodAuthTypeSetting;", "equals", "other", "hashCode", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class JSBAuthMethodAuthTypeSetting {
    private Map<String, Integer> commonSecureMethod;
    private boolean enableLynxForcePrivate;
    private boolean enableWebForcePrivate;
    private String[] lynxPublicMethod;
    private String[] webPublicMethod;

    public JSBAuthMethodAuthTypeSetting() {
        this(false, null, false, null, null, 31, null);
    }

    public static /* synthetic */ JSBAuthMethodAuthTypeSetting copy$default(JSBAuthMethodAuthTypeSetting jSBAuthMethodAuthTypeSetting, boolean z, String[] strArr, boolean z2, String[] strArr2, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            z = jSBAuthMethodAuthTypeSetting.enableWebForcePrivate;
        }
        if ((i & 2) != 0) {
            strArr = jSBAuthMethodAuthTypeSetting.webPublicMethod;
        }
        String[] strArr3 = strArr;
        if ((i & 4) != 0) {
            z2 = jSBAuthMethodAuthTypeSetting.enableLynxForcePrivate;
        }
        boolean z3 = z2;
        if ((i & 8) != 0) {
            strArr2 = jSBAuthMethodAuthTypeSetting.lynxPublicMethod;
        }
        String[] strArr4 = strArr2;
        if ((i & 16) != 0) {
            map = jSBAuthMethodAuthTypeSetting.commonSecureMethod;
        }
        return jSBAuthMethodAuthTypeSetting.copy(z, strArr3, z3, strArr4, map);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getEnableWebForcePrivate() {
        return this.enableWebForcePrivate;
    }

    /* renamed from: component2, reason: from getter */
    public final String[] getWebPublicMethod() {
        return this.webPublicMethod;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getEnableLynxForcePrivate() {
        return this.enableLynxForcePrivate;
    }

    /* renamed from: component4, reason: from getter */
    public final String[] getLynxPublicMethod() {
        return this.lynxPublicMethod;
    }

    public final Map<String, Integer> component5() {
        return this.commonSecureMethod;
    }

    public final JSBAuthMethodAuthTypeSetting copy(boolean enableWebForcePrivate, String[] webPublicMethod, boolean enableLynxForcePrivate, String[] lynxPublicMethod, Map<String, Integer> commonSecureMethod) {
        Intrinsics.checkNotNullParameter(webPublicMethod, "webPublicMethod");
        Intrinsics.checkNotNullParameter(lynxPublicMethod, "lynxPublicMethod");
        Intrinsics.checkNotNullParameter(commonSecureMethod, "commonSecureMethod");
        return new JSBAuthMethodAuthTypeSetting(enableWebForcePrivate, webPublicMethod, enableLynxForcePrivate, lynxPublicMethod, commonSecureMethod);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JSBAuthMethodAuthTypeSetting)) {
            return false;
        }
        JSBAuthMethodAuthTypeSetting jSBAuthMethodAuthTypeSetting = (JSBAuthMethodAuthTypeSetting) other;
        return this.enableWebForcePrivate == jSBAuthMethodAuthTypeSetting.enableWebForcePrivate && Intrinsics.areEqual(this.webPublicMethod, jSBAuthMethodAuthTypeSetting.webPublicMethod) && this.enableLynxForcePrivate == jSBAuthMethodAuthTypeSetting.enableLynxForcePrivate && Intrinsics.areEqual(this.lynxPublicMethod, jSBAuthMethodAuthTypeSetting.lynxPublicMethod) && Intrinsics.areEqual(this.commonSecureMethod, jSBAuthMethodAuthTypeSetting.commonSecureMethod);
    }

    public int hashCode() {
        return (((((((Boolean.hashCode(this.enableWebForcePrivate) * 31) + Arrays.hashCode(this.webPublicMethod)) * 31) + Boolean.hashCode(this.enableLynxForcePrivate)) * 31) + Arrays.hashCode(this.lynxPublicMethod)) * 31) + this.commonSecureMethod.hashCode();
    }

    public String toString() {
        return "JSBAuthMethodAuthTypeSetting(enableWebForcePrivate=" + this.enableWebForcePrivate + ", webPublicMethod=" + Arrays.toString(this.webPublicMethod) + ", enableLynxForcePrivate=" + this.enableLynxForcePrivate + ", lynxPublicMethod=" + Arrays.toString(this.lynxPublicMethod) + ", commonSecureMethod=" + this.commonSecureMethod + ')';
    }

    public JSBAuthMethodAuthTypeSetting(boolean z, String[] strArr, boolean z2, String[] strArr2, Map<String, Integer> map) {
        Intrinsics.checkNotNullParameter(strArr, "webPublicMethod");
        Intrinsics.checkNotNullParameter(strArr2, "lynxPublicMethod");
        Intrinsics.checkNotNullParameter(map, "commonSecureMethod");
        this.enableWebForcePrivate = z;
        this.webPublicMethod = strArr;
        this.enableLynxForcePrivate = z2;
        this.lynxPublicMethod = strArr2;
        this.commonSecureMethod = map;
    }

    public final boolean getEnableWebForcePrivate() {
        return this.enableWebForcePrivate;
    }

    public final void setEnableWebForcePrivate(boolean z) {
        this.enableWebForcePrivate = z;
    }

    public final String[] getWebPublicMethod() {
        return this.webPublicMethod;
    }

    public final void setWebPublicMethod(String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "<set-?>");
        this.webPublicMethod = strArr;
    }

    public final boolean getEnableLynxForcePrivate() {
        return this.enableLynxForcePrivate;
    }

    public final void setEnableLynxForcePrivate(boolean z) {
        this.enableLynxForcePrivate = z;
    }

    public final String[] getLynxPublicMethod() {
        return this.lynxPublicMethod;
    }

    public final void setLynxPublicMethod(String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "<set-?>");
        this.lynxPublicMethod = strArr;
    }

    public /* synthetic */ JSBAuthMethodAuthTypeSetting(boolean z, String[] strArr, boolean z2, String[] strArr2, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? new String[0] : strArr, (i & 4) != 0 ? true : z2, (i & 8) != 0 ? new String[0] : strArr2, (i & 16) != 0 ? MapsKt.emptyMap() : map);
    }

    public final Map<String, Integer> getCommonSecureMethod() {
        return this.commonSecureMethod;
    }

    public final void setCommonSecureMethod(Map<String, Integer> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.commonSecureMethod = map;
    }
}
