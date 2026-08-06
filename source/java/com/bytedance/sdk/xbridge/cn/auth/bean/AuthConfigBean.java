package com.bytedance.sdk.xbridge.cn.auth.bean;

import com.bytedance.sdk.account.save.database.DBData;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BridgeCallRecord.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010#\u001a\u00020\bHÆ\u0003J\t\u0010$\u001a\u00020\nHÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u0017\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0003J\t\u0010(\u001a\u00020\u0011HÆ\u0003Jy\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0011HÆ\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u0011HÖ\u0001J\t\u0010.\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u001f\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006/"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthConfigBean;", "", DBData.FIELD_TYPE, "Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthConfigType;", "safe_urls", "", "", "public_key", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/PublicKey;", "group", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthBridgeAccess;", "included_methods", "excluded_methods", "method_call_limits", "", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/MethodCallLimitsBean;", "fe_secure_auth_version", "", "(Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthConfigType;Ljava/util/List;Lcom/bytedance/sdk/xbridge/cn/auth/bean/PublicKey;Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthBridgeAccess;Ljava/util/List;Ljava/util/List;Ljava/util/Map;I)V", "getExcluded_methods", "()Ljava/util/List;", "getFe_secure_auth_version", "()I", "getGroup", "()Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthBridgeAccess;", "getIncluded_methods", "getMethod_call_limits", "()Ljava/util/Map;", "getPublic_key", "()Lcom/bytedance/sdk/xbridge/cn/auth/bean/PublicKey;", "getSafe_urls", "getType", "()Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthConfigType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class AuthConfigBean {
    private final List<String> excluded_methods;
    private final int fe_secure_auth_version;
    private final AuthBridgeAccess group;
    private final List<String> included_methods;
    private final Map<String, MethodCallLimitsBean> method_call_limits;
    private final PublicKey public_key;
    private final List<String> safe_urls;
    private final AuthConfigType type;

    /* renamed from: component1, reason: from getter */
    public final AuthConfigType getType() {
        return this.type;
    }

    public final List<String> component2() {
        return this.safe_urls;
    }

    /* renamed from: component3, reason: from getter */
    public final PublicKey getPublic_key() {
        return this.public_key;
    }

    /* renamed from: component4, reason: from getter */
    public final AuthBridgeAccess getGroup() {
        return this.group;
    }

    public final List<String> component5() {
        return this.included_methods;
    }

    public final List<String> component6() {
        return this.excluded_methods;
    }

    public final Map<String, MethodCallLimitsBean> component7() {
        return this.method_call_limits;
    }

    /* renamed from: component8, reason: from getter */
    public final int getFe_secure_auth_version() {
        return this.fe_secure_auth_version;
    }

    public final AuthConfigBean copy(AuthConfigType type, List<String> safe_urls, PublicKey public_key, AuthBridgeAccess group, List<String> included_methods, List<String> excluded_methods, Map<String, MethodCallLimitsBean> method_call_limits, int fe_secure_auth_version) {
        Intrinsics.checkNotNullParameter(type, DBData.FIELD_TYPE);
        Intrinsics.checkNotNullParameter(safe_urls, "safe_urls");
        Intrinsics.checkNotNullParameter(public_key, "public_key");
        Intrinsics.checkNotNullParameter(group, "group");
        Intrinsics.checkNotNullParameter(included_methods, "included_methods");
        Intrinsics.checkNotNullParameter(excluded_methods, "excluded_methods");
        return new AuthConfigBean(type, safe_urls, public_key, group, included_methods, excluded_methods, method_call_limits, fe_secure_auth_version);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AuthConfigBean)) {
            return false;
        }
        AuthConfigBean authConfigBean = (AuthConfigBean) other;
        return this.type == authConfigBean.type && Intrinsics.areEqual(this.safe_urls, authConfigBean.safe_urls) && Intrinsics.areEqual(this.public_key, authConfigBean.public_key) && this.group == authConfigBean.group && Intrinsics.areEqual(this.included_methods, authConfigBean.included_methods) && Intrinsics.areEqual(this.excluded_methods, authConfigBean.excluded_methods) && Intrinsics.areEqual(this.method_call_limits, authConfigBean.method_call_limits) && this.fe_secure_auth_version == authConfigBean.fe_secure_auth_version;
    }

    public int hashCode() {
        int hashCode = ((((((((((this.type.hashCode() * 31) + this.safe_urls.hashCode()) * 31) + this.public_key.hashCode()) * 31) + this.group.hashCode()) * 31) + this.included_methods.hashCode()) * 31) + this.excluded_methods.hashCode()) * 31;
        Map<String, MethodCallLimitsBean> map = this.method_call_limits;
        return ((hashCode + (map == null ? 0 : map.hashCode())) * 31) + Integer.hashCode(this.fe_secure_auth_version);
    }

    public String toString() {
        return "AuthConfigBean(type=" + this.type + ", safe_urls=" + this.safe_urls + ", public_key=" + this.public_key + ", group=" + this.group + ", included_methods=" + this.included_methods + ", excluded_methods=" + this.excluded_methods + ", method_call_limits=" + this.method_call_limits + ", fe_secure_auth_version=" + this.fe_secure_auth_version + ')';
    }

    public AuthConfigBean(AuthConfigType authConfigType, List<String> list, PublicKey publicKey, AuthBridgeAccess authBridgeAccess, List<String> list2, List<String> list3, Map<String, MethodCallLimitsBean> map, int i) {
        Intrinsics.checkNotNullParameter(authConfigType, DBData.FIELD_TYPE);
        Intrinsics.checkNotNullParameter(list, "safe_urls");
        Intrinsics.checkNotNullParameter(publicKey, "public_key");
        Intrinsics.checkNotNullParameter(authBridgeAccess, "group");
        Intrinsics.checkNotNullParameter(list2, "included_methods");
        Intrinsics.checkNotNullParameter(list3, "excluded_methods");
        this.type = authConfigType;
        this.safe_urls = list;
        this.public_key = publicKey;
        this.group = authBridgeAccess;
        this.included_methods = list2;
        this.excluded_methods = list3;
        this.method_call_limits = map;
        this.fe_secure_auth_version = i;
    }

    public final AuthConfigType getType() {
        return this.type;
    }

    public final List<String> getSafe_urls() {
        return this.safe_urls;
    }

    public final PublicKey getPublic_key() {
        return this.public_key;
    }

    public final AuthBridgeAccess getGroup() {
        return this.group;
    }

    public final List<String> getIncluded_methods() {
        return this.included_methods;
    }

    public final List<String> getExcluded_methods() {
        return this.excluded_methods;
    }

    public final Map<String, MethodCallLimitsBean> getMethod_call_limits() {
        return this.method_call_limits;
    }

    public final int getFe_secure_auth_version() {
        return this.fe_secure_auth_version;
    }
}
