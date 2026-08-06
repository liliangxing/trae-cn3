package com.bytedance.sdk.xbridge.cn.auth.entity;

import android.net.Uri;
import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sdk.xbridge.cn.auth.PermissionExtKt;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthConfigV1Bean;
import com.bytedance.sdk.xbridge.cn.auth.respository.PermissionConfigParser;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBridgeCall;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* compiled from: PermissionConfigNamespace.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 !2\u00020\u0001:\u0001!B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\u0002\u0010\nJ\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0003H\u0002J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0003H\u0002J\u0018\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0006\u0010\u0015\u001a\u00020\u0003H\u0002J\u000e\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0003J\u000e\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0003J\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u0002J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0003H\u0002J \u0010\u001e\u001a\u00020\u001f2\u0018\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR \u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/entity/PermissionConfigNamespace;", "", LynxBridgeCall.NAME_SPACE, "", "cacheCapacity", "", "configMap", "", "", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthConfigV1Bean;", "(Ljava/lang/String;ILjava/util/Map;)V", "getNamespace", "()Ljava/lang/String;", "permissionConfigMapFromVerifyV2", "ruleCache", "Landroid/util/LruCache;", "Lcom/bytedance/sdk/xbridge/cn/auth/entity/PermissionRule;", "createRule", IWeixinService.ResponseConstants.URL, "createRuleMix", "getRemoteConfigList", PermissionConfigParser.WEBCAST_HOST_NAMESPACE, "getRule", "rawUrl", "getRuleMix", "getShortenedHost", "isPatternMatch", "", ReportConstant.COMMON_CONTENT, "pattern", "update", "", "config", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class PermissionConfigNamespace {
    public static final int DEFAULT_CACHE_CAPACITY = 32;
    private final String namespace;
    private Map<String, ? extends List<AuthConfigV1Bean>> permissionConfigMapFromVerifyV2;
    private LruCache<String, PermissionRule> ruleCache;

    public PermissionConfigNamespace(String str, int i, Map<String, ? extends List<AuthConfigV1Bean>> map) {
        Intrinsics.checkNotNullParameter(str, LynxBridgeCall.NAME_SPACE);
        Intrinsics.checkNotNullParameter(map, "configMap");
        this.namespace = str;
        this.permissionConfigMapFromVerifyV2 = MapsKt.emptyMap();
        this.ruleCache = new LruCache<>(i <= 0 ? 32 : i);
        this.permissionConfigMapFromVerifyV2 = map;
    }

    public final String getNamespace() {
        return this.namespace;
    }

    public /* synthetic */ PermissionConfigNamespace(String str, int i, Map map, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? 32 : i, (i2 & 4) != 0 ? MapsKt.emptyMap() : map);
    }

    public final void update(Map<String, ? extends List<AuthConfigV1Bean>> config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.permissionConfigMapFromVerifyV2 = config;
    }

    public final PermissionRule getRule(String rawUrl) {
        PermissionRule permissionRule;
        Intrinsics.checkNotNullParameter(rawUrl, "rawUrl");
        Uri parse = Uri.parse(rawUrl);
        String scheme = parse.getScheme();
        String authority = parse.getAuthority();
        String builder = new Uri.Builder().scheme(scheme).authority(authority).path(parse.getPath()).toString();
        Intrinsics.checkNotNullExpressionValue(builder, "Builder()\n            .s…)\n            .toString()");
        if (authority != null) {
            if (!(authority.length() == 0)) {
                LruCache<String, PermissionRule> lruCache = this.ruleCache;
                return (lruCache == null || (permissionRule = lruCache.get(builder)) == null) ? createRule(builder) : permissionRule;
            }
        }
        return new PermissionRule(IDLXBridgeMethod.Access.PUBLIC, null, null, 6, null);
    }

    public final PermissionRule getRuleMix(String rawUrl) {
        PermissionRule permissionRule;
        Intrinsics.checkNotNullParameter(rawUrl, "rawUrl");
        Uri parse = Uri.parse(rawUrl);
        String scheme = parse.getScheme();
        String authority = parse.getAuthority();
        String builder = new Uri.Builder().scheme(scheme).authority(authority).path(parse.getPath()).toString();
        Intrinsics.checkNotNullExpressionValue(builder, "Builder()\n            .s…)\n            .toString()");
        if (authority != null) {
            if (!(authority.length() == 0)) {
                LruCache<String, PermissionRule> lruCache = this.ruleCache;
                return (lruCache == null || (permissionRule = lruCache.get(builder)) == null) ? createRuleMix(builder) : permissionRule;
            }
        }
        return new PermissionRule(IDLXBridgeMethod.Access.PUBLIC, null, null, 6, null);
    }

    private final PermissionRule createRule(String url) {
        PermissionRule permissionRule = new PermissionRule(IDLXBridgeMethod.Access.PUBLIC, null, null, 6, null);
        Uri parse = Uri.parse(url);
        String scheme = parse.getScheme();
        String authority = parse.getAuthority();
        String shortenedHost = getShortenedHost(authority);
        if (TextUtils.isEmpty(scheme) || TextUtils.isEmpty(authority) || shortenedHost == null) {
            LruCache<String, PermissionRule> lruCache = this.ruleCache;
            if (lruCache != null) {
                lruCache.put(url, permissionRule);
            }
            return permissionRule;
        }
        List<AuthConfigV1Bean> remoteConfigList = getRemoteConfigList(shortenedHost);
        if (remoteConfigList != null) {
            for (AuthConfigV1Bean authConfigV1Bean : remoteConfigList) {
                if (isPatternMatch(url, authConfigV1Bean.getPattern())) {
                    IDLXBridgeMethod.Access access = PermissionExtKt.toAccess(authConfigV1Bean.getAccess().getValue());
                    if (access.compareTo(permissionRule.getAccess()) >= 0) {
                        permissionRule.setAccess(access);
                    }
                    permissionRule.getIncludedMethods().addAll(authConfigV1Bean.getIncluded_methods());
                    permissionRule.getExcludedMethods().addAll(authConfigV1Bean.getExcluded_methods());
                }
            }
        }
        LruCache<String, PermissionRule> lruCache2 = this.ruleCache;
        if (lruCache2 != null) {
            lruCache2.put(url, permissionRule);
        }
        return permissionRule;
    }

    private final boolean isPatternMatch(String content, String pattern) {
        try {
            Result.Companion companion = Result.Companion;
            return Pattern.compile(pattern).matcher(content).find();
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            return false;
        }
    }

    private final PermissionRule createRuleMix(String url) {
        PermissionRule permissionRule = new PermissionRule(IDLXBridgeMethod.Access.PUBLIC, null, null, 6, null);
        Uri parse = Uri.parse(url);
        String scheme = parse.getScheme();
        String authority = parse.getAuthority();
        String shortenedHost = getShortenedHost(authority);
        if (TextUtils.isEmpty(scheme) || TextUtils.isEmpty(authority) || shortenedHost == null) {
            LruCache<String, PermissionRule> lruCache = this.ruleCache;
            if (lruCache != null) {
                lruCache.put(url, permissionRule);
            }
            return permissionRule;
        }
        Iterator<Map.Entry<String, ? extends List<AuthConfigV1Bean>>> it = this.permissionConfigMapFromVerifyV2.entrySet().iterator();
        while (it.hasNext()) {
            for (AuthConfigV1Bean authConfigV1Bean : it.next().getValue()) {
                if (isPatternMatch(url, authConfigV1Bean.getPattern())) {
                    IDLXBridgeMethod.Access access = PermissionExtKt.toAccess(authConfigV1Bean.getAccess().getValue());
                    if (access.compareTo(permissionRule.getAccess()) >= 0) {
                        permissionRule.setAccess(access);
                    }
                    permissionRule.getIncludedMethods().addAll(authConfigV1Bean.getIncluded_methods());
                    permissionRule.getExcludedMethods().addAll(authConfigV1Bean.getExcluded_methods());
                }
            }
        }
        LruCache<String, PermissionRule> lruCache2 = this.ruleCache;
        if (lruCache2 != null) {
            lruCache2.put(url, permissionRule);
        }
        return permissionRule;
    }

    private final String getShortenedHost(String host) {
        if (host == null) {
            return null;
        }
        Object[] array = new Regex("[.]").split(host, 0).toArray(new String[0]);
        if (array != null) {
            String[] strArr = (String[]) array;
            int length = strArr.length;
            if (length < 2) {
                return null;
            }
            return length == 2 ? host : strArr[length - 2] + '.' + strArr[length - 1];
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    private final List<AuthConfigV1Bean> getRemoteConfigList(String host) {
        return this.permissionConfigMapFromVerifyV2.get(host);
    }
}
