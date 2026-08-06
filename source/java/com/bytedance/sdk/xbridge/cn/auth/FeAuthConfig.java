package com.bytedance.sdk.xbridge.cn.auth;

import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthBridgeAccess;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthConfigBean;
import com.bytedance.sdk.xbridge.cn.auth.bean.FeAuthConfigSource;
import com.bytedance.sdk.xbridge.cn.auth.bean.MethodCallLimitsBean;
import com.bytedance.timonbase.pipeline.TimonPipeline;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: AuthV2VerifyHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\u000f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u00101\u001a\u00020\tHÆ\u0003J\u0015\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\t\u00103\u001a\u00020\u0006HÆ\u0003J\t\u00104\u001a\u00020\u000fHÆ\u0003Jg\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\u0013\u00106\u001a\u00020 2\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u00020\tHÖ\u0001J\t\u00109\u001a\u00020\u0006HÖ\u0001J2\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u00032\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010?\u001a\u00020\u000fJ \u0010@\u001a\u00020;2\u0006\u0010A\u001a\u00020\u00062\b\u0010B\u001a\u0004\u0018\u00010C2\u0006\u0010?\u001a\u00020\u000fJ\u0006\u0010D\u001a\u00020;R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\r\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u0011\u0010\u001f\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010!R&\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u0006E"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/FeAuthConfig;", "", "access", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthBridgeAccess;", "includedMethods", "", "", "excludedMethods", "secureAuthVersion", "", "methodCallLimits", "", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/MethodCallLimitsBean;", "feId", TimonPipeline.KEY_SOURCE, "Lcom/bytedance/sdk/xbridge/cn/auth/bean/FeAuthConfigSource;", "(Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthBridgeAccess;Ljava/util/Set;Ljava/util/Set;ILjava/util/Map;Ljava/lang/String;Lcom/bytedance/sdk/xbridge/cn/auth/bean/FeAuthConfigSource;)V", "getAccess", "()Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthBridgeAccess;", "setAccess", "(Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthBridgeAccess;)V", "getExcludedMethods", "()Ljava/util/Set;", "setExcludedMethods", "(Ljava/util/Set;)V", "getFeId", "()Ljava/lang/String;", "setFeId", "(Ljava/lang/String;)V", "getIncludedMethods", "setIncludedMethods", "isFromContentV2", "", "()Z", "getMethodCallLimits", "()Ljava/util/Map;", "setMethodCallLimits", "(Ljava/util/Map;)V", "getSecureAuthVersion", "()I", "setSecureAuthVersion", "(I)V", "getSource", "()Lcom/bytedance/sdk/xbridge/cn/auth/bean/FeAuthConfigSource;", "setSource", "(Lcom/bytedance/sdk/xbridge/cn/auth/bean/FeAuthConfigSource;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "updateContentConfig", "", "newAccess", "newIncludeMethods", "newExcludedMethods", "updateSource", "updateContentV2Config", "authFeId", "config", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthConfigBean;", "updatePrivateDomainsConfig", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class FeAuthConfig {
    private AuthBridgeAccess access;
    private Set<String> excludedMethods;
    private String feId;
    private Set<String> includedMethods;
    private Map<String, MethodCallLimitsBean> methodCallLimits;
    private int secureAuthVersion;
    private FeAuthConfigSource source;

    public FeAuthConfig() {
        this(null, null, null, 0, null, null, null, 127, null);
    }

    public static /* synthetic */ FeAuthConfig copy$default(FeAuthConfig feAuthConfig, AuthBridgeAccess authBridgeAccess, Set set, Set set2, int i, Map map, String str, FeAuthConfigSource feAuthConfigSource, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            authBridgeAccess = feAuthConfig.access;
        }
        if ((i2 & 2) != 0) {
            set = feAuthConfig.includedMethods;
        }
        Set set3 = set;
        if ((i2 & 4) != 0) {
            set2 = feAuthConfig.excludedMethods;
        }
        Set set4 = set2;
        if ((i2 & 8) != 0) {
            i = feAuthConfig.secureAuthVersion;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            map = feAuthConfig.methodCallLimits;
        }
        Map map2 = map;
        if ((i2 & 32) != 0) {
            str = feAuthConfig.feId;
        }
        String str2 = str;
        if ((i2 & 64) != 0) {
            feAuthConfigSource = feAuthConfig.source;
        }
        return feAuthConfig.copy(authBridgeAccess, set3, set4, i3, map2, str2, feAuthConfigSource);
    }

    /* renamed from: component1, reason: from getter */
    public final AuthBridgeAccess getAccess() {
        return this.access;
    }

    public final Set<String> component2() {
        return this.includedMethods;
    }

    public final Set<String> component3() {
        return this.excludedMethods;
    }

    /* renamed from: component4, reason: from getter */
    public final int getSecureAuthVersion() {
        return this.secureAuthVersion;
    }

    public final Map<String, MethodCallLimitsBean> component5() {
        return this.methodCallLimits;
    }

    /* renamed from: component6, reason: from getter */
    public final String getFeId() {
        return this.feId;
    }

    /* renamed from: component7, reason: from getter */
    public final FeAuthConfigSource getSource() {
        return this.source;
    }

    public final FeAuthConfig copy(AuthBridgeAccess access, Set<String> includedMethods, Set<String> excludedMethods, int secureAuthVersion, Map<String, MethodCallLimitsBean> methodCallLimits, String feId, FeAuthConfigSource source) {
        Intrinsics.checkNotNullParameter(access, "access");
        Intrinsics.checkNotNullParameter(includedMethods, "includedMethods");
        Intrinsics.checkNotNullParameter(excludedMethods, "excludedMethods");
        Intrinsics.checkNotNullParameter(methodCallLimits, "methodCallLimits");
        Intrinsics.checkNotNullParameter(feId, "feId");
        Intrinsics.checkNotNullParameter(source, TimonPipeline.KEY_SOURCE);
        return new FeAuthConfig(access, includedMethods, excludedMethods, secureAuthVersion, methodCallLimits, feId, source);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeAuthConfig)) {
            return false;
        }
        FeAuthConfig feAuthConfig = (FeAuthConfig) other;
        return this.access == feAuthConfig.access && Intrinsics.areEqual(this.includedMethods, feAuthConfig.includedMethods) && Intrinsics.areEqual(this.excludedMethods, feAuthConfig.excludedMethods) && this.secureAuthVersion == feAuthConfig.secureAuthVersion && Intrinsics.areEqual(this.methodCallLimits, feAuthConfig.methodCallLimits) && Intrinsics.areEqual(this.feId, feAuthConfig.feId) && this.source == feAuthConfig.source;
    }

    public int hashCode() {
        return (((((((((((this.access.hashCode() * 31) + this.includedMethods.hashCode()) * 31) + this.excludedMethods.hashCode()) * 31) + Integer.hashCode(this.secureAuthVersion)) * 31) + this.methodCallLimits.hashCode()) * 31) + this.feId.hashCode()) * 31) + this.source.hashCode();
    }

    public String toString() {
        return "FeAuthConfig(access=" + this.access + ", includedMethods=" + this.includedMethods + ", excludedMethods=" + this.excludedMethods + ", secureAuthVersion=" + this.secureAuthVersion + ", methodCallLimits=" + this.methodCallLimits + ", feId=" + this.feId + ", source=" + this.source + ')';
    }

    public FeAuthConfig(AuthBridgeAccess authBridgeAccess, Set<String> set, Set<String> set2, int i, Map<String, MethodCallLimitsBean> map, String str, FeAuthConfigSource feAuthConfigSource) {
        Intrinsics.checkNotNullParameter(authBridgeAccess, "access");
        Intrinsics.checkNotNullParameter(set, "includedMethods");
        Intrinsics.checkNotNullParameter(set2, "excludedMethods");
        Intrinsics.checkNotNullParameter(map, "methodCallLimits");
        Intrinsics.checkNotNullParameter(str, "feId");
        Intrinsics.checkNotNullParameter(feAuthConfigSource, TimonPipeline.KEY_SOURCE);
        this.access = authBridgeAccess;
        this.includedMethods = set;
        this.excludedMethods = set2;
        this.secureAuthVersion = i;
        this.methodCallLimits = map;
        this.feId = str;
        this.source = feAuthConfigSource;
    }

    public /* synthetic */ FeAuthConfig(AuthBridgeAccess authBridgeAccess, Set set, Set set2, int i, Map map, String str, FeAuthConfigSource feAuthConfigSource, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? AuthBridgeAccess.PUBLIC : authBridgeAccess, (i2 & 2) != 0 ? SetsKt.emptySet() : set, (i2 & 4) != 0 ? SetsKt.emptySet() : set2, (i2 & 8) != 0 ? 0 : i, (i2 & 16) != 0 ? MapsKt.emptyMap() : map, (i2 & 32) != 0 ? "0" : str, (i2 & 64) != 0 ? FeAuthConfigSource.UN_KNOWN : feAuthConfigSource);
    }

    public final AuthBridgeAccess getAccess() {
        return this.access;
    }

    public final void setAccess(AuthBridgeAccess authBridgeAccess) {
        Intrinsics.checkNotNullParameter(authBridgeAccess, "<set-?>");
        this.access = authBridgeAccess;
    }

    public final Set<String> getIncludedMethods() {
        return this.includedMethods;
    }

    public final void setIncludedMethods(Set<String> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.includedMethods = set;
    }

    public final Set<String> getExcludedMethods() {
        return this.excludedMethods;
    }

    public final void setExcludedMethods(Set<String> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.excludedMethods = set;
    }

    public final int getSecureAuthVersion() {
        return this.secureAuthVersion;
    }

    public final void setSecureAuthVersion(int i) {
        this.secureAuthVersion = i;
    }

    public final Map<String, MethodCallLimitsBean> getMethodCallLimits() {
        return this.methodCallLimits;
    }

    public final void setMethodCallLimits(Map<String, MethodCallLimitsBean> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.methodCallLimits = map;
    }

    public final String getFeId() {
        return this.feId;
    }

    public final void setFeId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.feId = str;
    }

    public final FeAuthConfigSource getSource() {
        return this.source;
    }

    public final void setSource(FeAuthConfigSource feAuthConfigSource) {
        Intrinsics.checkNotNullParameter(feAuthConfigSource, "<set-?>");
        this.source = feAuthConfigSource;
    }

    public final boolean isFromContentV2() {
        Integer intOrNull = StringsKt.toIntOrNull(this.feId);
        return (intOrNull != null ? intOrNull.intValue() : 0) > 0;
    }

    public final void updateContentV2Config(String authFeId, AuthConfigBean config, FeAuthConfigSource updateSource) {
        Intrinsics.checkNotNullParameter(authFeId, "authFeId");
        Intrinsics.checkNotNullParameter(updateSource, "updateSource");
        this.feId = authFeId;
        if (config != null) {
            this.access = config.getGroup();
            this.includedMethods = CollectionsKt.toSet(config.getIncluded_methods());
            this.excludedMethods = CollectionsKt.toSet(config.getExcluded_methods());
            this.secureAuthVersion = config.getFe_secure_auth_version();
            Map<String, MethodCallLimitsBean> method_call_limits = config.getMethod_call_limits();
            if (method_call_limits == null) {
                method_call_limits = MapsKt.emptyMap();
            }
            this.methodCallLimits = method_call_limits;
        }
        this.source = updateSource;
    }

    public final void updateContentConfig(AuthBridgeAccess newAccess, Set<String> newIncludeMethods, Set<String> newExcludedMethods, FeAuthConfigSource updateSource) {
        Intrinsics.checkNotNullParameter(newAccess, "newAccess");
        Intrinsics.checkNotNullParameter(newIncludeMethods, "newIncludeMethods");
        Intrinsics.checkNotNullParameter(newExcludedMethods, "newExcludedMethods");
        Intrinsics.checkNotNullParameter(updateSource, "updateSource");
        this.feId = OnekeyLoginConstants.ErrorCode.ERROR_CODE_UNKNOW;
        this.access = newAccess;
        this.includedMethods = newIncludeMethods;
        this.excludedMethods = newExcludedMethods;
        this.source = updateSource;
    }

    public final void updatePrivateDomainsConfig() {
        this.access = AuthBridgeAccess.PRIVATE;
        this.source = FeAuthConfigSource.PRIVATE_DOMAINS;
    }
}
