package com.bytedance.sdk.xbridge.cn.auth.repository;

import com.bytedance.sdk.xbridge.cn.auth.bean.JSBAuthMethodAuthTypeSetting;
import com.bytedance.sdk.xbridge.cn.auth.bean.LynxAuthStrategyConfig;
import com.bytedance.sdk.xbridge.cn.auth.bean.WebAuthStrategyConfig;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: AuthStrategyRepository.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0017J\u000e\u0010*\u001a\u00020(2\u0006\u0010)\u001a\u00020\u000eJ\u000e\u0010+\u001a\u00020(2\u0006\u0010\u0007\u001a\u00020\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u00020\u00178@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R4\u0010\u001d\u001a\u001c\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\f\"\u0004\b\u001f\u0010 R4\u0010!\u001a\u001c\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010 R\u0011\u0010$\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006,"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/repository/AuthStrategyRepository;", "", "()V", "APP_ID_USE_V3", "", "", "", "appId", "customMethodAuthTypeSettings", "", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/JSBAuthMethodAuthTypeSetting;", "getCustomMethodAuthTypeSettings", "()Ljava/util/Map;", "defaultAuthStrategy", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/WebAuthStrategyConfig;", "defaultLynxSignVerifyWhiteList", "", "[Ljava/lang/String;", "enableAuthV3", "", "getEnableAuthV3", "()Z", "lynxAuthStrategy", "Lcom/bytedance/sdk/xbridge/cn/auth/bean/LynxAuthStrategyConfig;", "getLynxAuthStrategy$anniex_release", "()Lcom/bytedance/sdk/xbridge/cn/auth/bean/LynxAuthStrategyConfig;", "setLynxAuthStrategy$anniex_release", "(Lcom/bytedance/sdk/xbridge/cn/auth/bean/LynxAuthStrategyConfig;)V", "remoteWebAuthStrategy", "requestCheckMethods", "getRequestCheckMethods", "setRequestCheckMethods", "(Ljava/util/Map;)V", "requestCheckSettings", "getRequestCheckSettings", "setRequestCheckSettings", "webAuthStrategy", "getWebAuthStrategy", "()Lcom/bytedance/sdk/xbridge/cn/auth/bean/WebAuthStrategyConfig;", "setLynxAuthStrategy", "", "config", "setWebAuthStrategy", "updateAppId", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AuthStrategyRepository {
    private static final Map<String, Integer> APP_ID_USE_V3;
    private static String appId;
    private static WebAuthStrategyConfig remoteWebAuthStrategy;
    private static Map<String, ? extends Map<String, ? extends Object>> requestCheckMethods;
    private static Map<String, ? extends Map<String, ? extends Object>> requestCheckSettings;
    public static final AuthStrategyRepository INSTANCE = new AuthStrategyRepository();
    private static final String[] defaultLynxSignVerifyWhiteList = {"dy_search", "unknown"};
    private static LynxAuthStrategyConfig lynxAuthStrategy = new LynxAuthStrategyConfig(null, null, 3, null);
    private static WebAuthStrategyConfig defaultAuthStrategy = new WebAuthStrategyConfig(false, null, false, 7, null);
    private static final Map<String, JSBAuthMethodAuthTypeSetting> customMethodAuthTypeSettings = new LinkedHashMap();

    private AuthStrategyRepository() {
    }

    static {
        List listOf = CollectionsKt.listOf(new String[]{"1128", "2329", "8663"});
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(listOf, 10)), 16));
        for (Object obj : listOf) {
            linkedHashMap.put(obj, 1);
        }
        APP_ID_USE_V3 = linkedHashMap;
    }

    public final void setLynxAuthStrategy$anniex_release(LynxAuthStrategyConfig lynxAuthStrategyConfig) {
        Intrinsics.checkNotNullParameter(lynxAuthStrategyConfig, "<set-?>");
        lynxAuthStrategy = lynxAuthStrategyConfig;
    }

    public final LynxAuthStrategyConfig getLynxAuthStrategy$anniex_release() {
        if (lynxAuthStrategy.getLynxSignVerifyWhiteList() == null) {
            return LynxAuthStrategyConfig.copy$default(lynxAuthStrategy, defaultLynxSignVerifyWhiteList, null, 2, null);
        }
        return lynxAuthStrategy;
    }

    public final WebAuthStrategyConfig getWebAuthStrategy() {
        WebAuthStrategyConfig webAuthStrategyConfig = remoteWebAuthStrategy;
        return webAuthStrategyConfig == null ? defaultAuthStrategy : webAuthStrategyConfig;
    }

    public final boolean getEnableAuthV3() {
        return getWebAuthStrategy().getEnableJSBAuthV3();
    }

    public final void setWebAuthStrategy(WebAuthStrategyConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        remoteWebAuthStrategy = config;
    }

    public final void setLynxAuthStrategy(LynxAuthStrategyConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        lynxAuthStrategy = config;
    }

    public final Map<String, JSBAuthMethodAuthTypeSetting> getCustomMethodAuthTypeSettings() {
        return customMethodAuthTypeSettings;
    }

    public final Map<String, Map<String, Object>> getRequestCheckMethods() {
        return requestCheckMethods;
    }

    public final void setRequestCheckMethods(Map<String, ? extends Map<String, ? extends Object>> map) {
        requestCheckMethods = map;
    }

    public final Map<String, Map<String, Object>> getRequestCheckSettings() {
        return requestCheckSettings;
    }

    public final void setRequestCheckSettings(Map<String, ? extends Map<String, ? extends Object>> map) {
        requestCheckSettings = map;
    }

    public final void updateAppId(String appId2) {
        Intrinsics.checkNotNullParameter(appId2, "appId");
        appId = appId2;
        if (APP_ID_USE_V3.containsKey(appId2)) {
            defaultAuthStrategy = new WebAuthStrategyConfig(true, null, true, 2, null);
        }
    }
}
