package com.bytedance.trae.settings.impl.feature;

import com.bytedance.news.common.settings.SettingsManager;
import com.bytedance.news.common.settings.SettingsUpdateListener;
import com.bytedance.news.common.settings.api.SettingsData;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.login.api.AccountInfo;
import com.bytedance.trae.login.api.AccountType;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.network.DebugSettings;
import com.bytedance.trae.settings.api.ISettingsService;
import com.bytedance.trae.settings.api.feature.Feature;
import com.bytedance.trae.settings.api.feature.IFeatureCapabilityService;
import com.bytedance.trae.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: FeatureCapabilityServiceImpl.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0002J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011H\u0016J\u001f\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0013H\u0016J\u001e\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\n2\u0006\u0010\u0018\u001a\u00020\u000bH\u0002J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\fH\u0002J\b\u0010\u001b\u001a\u00020\u000bH\u0002J\b\u0010\u001c\u001a\u00020\u0007H\u0016J\b\u0010\u001d\u001a\u00020\u0013H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\n\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityServiceImpl;", "Lcom/bytedance/trae/settings/api/feature/IFeatureCapabilityService;", "<init>", "()V", "debugOverrides", "", "Lcom/bytedance/trae/settings/api/feature/Feature;", "", "restoreDebugOverrides", "remoteConfigs", "", "Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;", "", "settingsListenerRegistered", "isEnabled", "feature", "getEnabledFeatures", "", "setDebugOverride", "", "enabled", "(Lcom/bytedance/trae/settings/api/feature/Feature;Ljava/lang/Boolean;)V", "refresh", "loadRemoteConfig", "scope", "parseAndCacheRemoteJson", "json", "resolveScope", "isToBUser", "ensureSettingsListener", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class FeatureCapabilityServiceImpl implements IFeatureCapabilityService {
    private static final String TAG = "FeatureCapability";
    private final Map<Feature, Boolean> debugOverrides = restoreDebugOverrides();
    private volatile Map<FeatureCapabilityScope, ? extends Map<String, Boolean>> remoteConfigs;
    private boolean settingsListenerRegistered;

    private final Map<Feature, Boolean> restoreDebugOverrides() {
        if (!AppHost.Companion.isDebug()) {
            return new LinkedHashMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Feature feature : Feature.getEntries()) {
            Boolean featureOverride = DebugSettings.INSTANCE.getFeatureOverride(feature.getKey());
            if (featureOverride != null) {
                linkedHashMap.put(feature, Boolean.valueOf(featureOverride.booleanValue()));
            }
        }
        return linkedHashMap;
    }

    @Override // com.bytedance.trae.settings.api.feature.IFeatureCapabilityService
    public boolean isEnabled(Feature feature) {
        Boolean bool;
        Boolean bool2;
        Intrinsics.checkNotNullParameter(feature, "feature");
        ensureSettingsListener();
        if (AppHost.Companion.isDebug() && (bool2 = this.debugOverrides.get(feature)) != null) {
            boolean booleanValue = bool2.booleanValue();
            FLogger.INSTANCE.mo428i(TAG, "isEnabled(" + feature.getKey() + ") = " + booleanValue + " [source: debugOverride]");
            return booleanValue;
        }
        FeatureCapabilityScope resolveScope = resolveScope();
        Map<String, Boolean> loadRemoteConfig = loadRemoteConfig(resolveScope);
        if (loadRemoteConfig != null && (bool = loadRemoteConfig.get(feature.getKey())) != null) {
            boolean booleanValue2 = bool.booleanValue();
            FLogger.INSTANCE.mo428i(TAG, "isEnabled(" + feature.getKey() + ") = " + booleanValue2 + " [source: remoteConfig, scope=" + resolveScope.getRemoteKey() + ']');
            return booleanValue2;
        }
        boolean z = FeatureCapabilityDefaults.INSTANCE.getDefault(feature, resolveScope);
        FLogger.INSTANCE.mo428i(TAG, "isEnabled(" + feature.getKey() + ") = " + z + " [source: default, scope=" + resolveScope.getRemoteKey() + ']');
        return z;
    }

    @Override // com.bytedance.trae.settings.api.feature.IFeatureCapabilityService
    public Set<Feature> getEnabledFeatures() {
        Iterable entries = Feature.getEntries();
        ArrayList arrayList = new ArrayList();
        for (Object obj : entries) {
            if (isEnabled((Feature) obj)) {
                arrayList.add(obj);
            }
        }
        return CollectionsKt.toSet(arrayList);
    }

    @Override // com.bytedance.trae.settings.api.feature.IFeatureCapabilityService
    public void setDebugOverride(Feature feature, Boolean enabled) {
        Intrinsics.checkNotNullParameter(feature, "feature");
        if (enabled == null) {
            this.debugOverrides.remove(feature);
        } else {
            this.debugOverrides.put(feature, enabled);
        }
        DebugSettings.INSTANCE.setFeatureOverride(feature.getKey(), enabled);
        FLogger.INSTANCE.mo428i(TAG, "setDebugOverride: " + feature.getKey() + " = " + enabled);
    }

    @Override // com.bytedance.trae.settings.api.feature.IFeatureCapabilityService
    public void refresh() {
        this.remoteConfigs = null;
        FLogger.INSTANCE.mo428i(TAG, "refresh: remote config cache cleared");
    }

    private final Map<String, Boolean> loadRemoteConfig(FeatureCapabilityScope scope) {
        Object obj;
        Map<FeatureCapabilityScope, ? extends Map<String, Boolean>> map = this.remoteConfigs;
        if (map != null) {
            return map.get(scope);
        }
        try {
            Result.Companion companion = Result.Companion;
            FeatureCapabilityServiceImpl featureCapabilityServiceImpl = this;
            IFeatureCapabilitySettings iFeatureCapabilitySettings = (IFeatureCapabilitySettings) SettingsManager.obtain(IFeatureCapabilitySettings.class);
            obj = Result.constructor-impl(iFeatureCapabilitySettings != null ? iFeatureCapabilitySettings.getConfig() : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            FLogger.INSTANCE.mo427e(TAG, "loadRemoteConfig: obtain settings failed", th2);
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        String str = (String) obj;
        FLogger.INSTANCE.mo428i(TAG, "loadRemoteConfig: raw json = " + str);
        if (str == null) {
            return null;
        }
        parseAndCacheRemoteJson(str);
        Map<FeatureCapabilityScope, ? extends Map<String, Boolean>> map2 = this.remoteConfigs;
        if (map2 != null) {
            return map2.get(scope);
        }
        return null;
    }

    private final void parseAndCacheRemoteJson(String json) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            FeatureCapabilityServiceImpl featureCapabilityServiceImpl = this;
            Iterable entries = FeatureCapabilityScope.getEntries();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(entries, 10)), 16));
            for (Object obj2 : entries) {
                linkedHashMap.put(obj2, FeatureRemoteConfigParser.INSTANCE.parse(json, (FeatureCapabilityScope) obj2));
            }
            this.remoteConfigs = linkedHashMap;
            FLogger.INSTANCE.mo428i(TAG, "parseAndCacheRemoteJson: remoteConfigs=" + this.remoteConfigs);
            obj = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            FLogger.INSTANCE.mo427e(TAG, "parseAndCacheRemoteJson failed", th2);
        }
    }

    @Override // com.bytedance.trae.settings.api.feature.IFeatureCapabilityService
    public boolean isToBUser() {
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        return iLoginService != null && iLoginService.getAccountInfo().getAccountType() == AccountType.TOB;
    }

    private final void ensureSettingsListener() {
        if (this.settingsListenerRegistered) {
            return;
        }
        this.settingsListenerRegistered = true;
        ISettingsService iSettingsService = (ISettingsService) ServiceManager.get().getService(ISettingsService.class);
        if (iSettingsService != null) {
            iSettingsService.registerListener(new SettingsUpdateListener() { // from class: com.bytedance.trae.settings.impl.feature.FeatureCapabilityServiceImpl$$ExternalSyntheticLambda0
                @Override // com.bytedance.news.common.settings.SettingsUpdateListener
                public final void onSettingsUpdate(SettingsData settingsData) {
                    FeatureCapabilityServiceImpl.this.refresh();
                }
            }, true);
        }
    }

    private final FeatureCapabilityScope resolveScope() {
        AccountInfo accountInfo;
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        boolean z = false;
        if (iLoginService != null && iLoginService.isTraeLoggedIn()) {
            z = true;
        }
        String str = null;
        if (z && iLoginService != null && (accountInfo = iLoginService.getAccountInfo()) != null) {
            str = accountInfo.getLoginPlatform();
        }
        return FeatureCapabilityScopeResolver.INSTANCE.resolve(z, str);
    }
}
