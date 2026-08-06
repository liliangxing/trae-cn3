package com.bytedance.sdk.xbridge.cn.auth.bean;

import com.bytedance.bdinstall.Api;
import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.webx.addr.AddressParam;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BridgeCallRecord.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0015JN\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u0013R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006,"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthConfigV1Bean;", "", AddressParam.SETTING_BDWK_EXTENSION_PATTERN, "", Api.KEY_ACCESS, "Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthBridgeAccess;", "included_methods", "", "excluded_methods", "feId", "", "(Ljava/lang/String;Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthBridgeAccess;Ljava/util/List;Ljava/util/List;Ljava/lang/Long;)V", "getAccess", "()Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthBridgeAccess;", "setAccess", "(Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthBridgeAccess;)V", "getExcluded_methods", "()Ljava/util/List;", "setExcluded_methods", "(Ljava/util/List;)V", "getFeId", "()Ljava/lang/Long;", "setFeId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getIncluded_methods", "setIncluded_methods", "getPattern", "()Ljava/lang/String;", "setPattern", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthBridgeAccess;Ljava/util/List;Ljava/util/List;Ljava/lang/Long;)Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthConfigV1Bean;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class AuthConfigV1Bean {
    private AuthBridgeAccess access;
    private List<String> excluded_methods;
    private Long feId;
    private List<String> included_methods;
    private String pattern;

    public static /* synthetic */ AuthConfigV1Bean copy$default(AuthConfigV1Bean authConfigV1Bean, String str, AuthBridgeAccess authBridgeAccess, List list, List list2, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            str = authConfigV1Bean.pattern;
        }
        if ((i & 2) != 0) {
            authBridgeAccess = authConfigV1Bean.access;
        }
        AuthBridgeAccess authBridgeAccess2 = authBridgeAccess;
        if ((i & 4) != 0) {
            list = authConfigV1Bean.included_methods;
        }
        List list3 = list;
        if ((i & 8) != 0) {
            list2 = authConfigV1Bean.excluded_methods;
        }
        List list4 = list2;
        if ((i & 16) != 0) {
            l = authConfigV1Bean.feId;
        }
        return authConfigV1Bean.copy(str, authBridgeAccess2, list3, list4, l);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPattern() {
        return this.pattern;
    }

    /* renamed from: component2, reason: from getter */
    public final AuthBridgeAccess getAccess() {
        return this.access;
    }

    public final List<String> component3() {
        return this.included_methods;
    }

    public final List<String> component4() {
        return this.excluded_methods;
    }

    /* renamed from: component5, reason: from getter */
    public final Long getFeId() {
        return this.feId;
    }

    public final AuthConfigV1Bean copy(String pattern, AuthBridgeAccess access, List<String> included_methods, List<String> excluded_methods, Long feId) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        Intrinsics.checkNotNullParameter(access, "access");
        Intrinsics.checkNotNullParameter(included_methods, "included_methods");
        Intrinsics.checkNotNullParameter(excluded_methods, "excluded_methods");
        return new AuthConfigV1Bean(pattern, access, included_methods, excluded_methods, feId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AuthConfigV1Bean)) {
            return false;
        }
        AuthConfigV1Bean authConfigV1Bean = (AuthConfigV1Bean) other;
        return Intrinsics.areEqual(this.pattern, authConfigV1Bean.pattern) && this.access == authConfigV1Bean.access && Intrinsics.areEqual(this.included_methods, authConfigV1Bean.included_methods) && Intrinsics.areEqual(this.excluded_methods, authConfigV1Bean.excluded_methods) && Intrinsics.areEqual(this.feId, authConfigV1Bean.feId);
    }

    public int hashCode() {
        int hashCode = ((((((this.pattern.hashCode() * 31) + this.access.hashCode()) * 31) + this.included_methods.hashCode()) * 31) + this.excluded_methods.hashCode()) * 31;
        Long l = this.feId;
        return hashCode + (l == null ? 0 : l.hashCode());
    }

    public String toString() {
        return "AuthConfigV1Bean(pattern=" + this.pattern + ", access=" + this.access + ", included_methods=" + this.included_methods + ", excluded_methods=" + this.excluded_methods + ", feId=" + this.feId + ')';
    }

    public AuthConfigV1Bean(String pattern, AuthBridgeAccess access, List<String> included_methods, List<String> excluded_methods, Long l) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        Intrinsics.checkNotNullParameter(access, "access");
        Intrinsics.checkNotNullParameter(included_methods, "included_methods");
        Intrinsics.checkNotNullParameter(excluded_methods, "excluded_methods");
        this.pattern = pattern;
        this.access = access;
        this.included_methods = included_methods;
        this.excluded_methods = excluded_methods;
        this.feId = l;
    }

    public /* synthetic */ AuthConfigV1Bean(String str, AuthBridgeAccess authBridgeAccess, List list, List list2, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, authBridgeAccess, list, list2, (i & 16) != 0 ? null : l);
    }

    public final String getPattern() {
        return this.pattern;
    }

    public final void setPattern(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.pattern = str;
    }

    public final AuthBridgeAccess getAccess() {
        return this.access;
    }

    public final void setAccess(AuthBridgeAccess authBridgeAccess) {
        Intrinsics.checkNotNullParameter(authBridgeAccess, "<set-?>");
        this.access = authBridgeAccess;
    }

    public final List<String> getIncluded_methods() {
        return this.included_methods;
    }

    public final void setIncluded_methods(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.included_methods = list;
    }

    public final List<String> getExcluded_methods() {
        return this.excluded_methods;
    }

    public final void setExcluded_methods(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.excluded_methods = list;
    }

    public final Long getFeId() {
        return this.feId;
    }

    public final void setFeId(Long l) {
        this.feId = l;
    }
}
