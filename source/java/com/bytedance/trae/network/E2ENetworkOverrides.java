package com.bytedance.trae.network;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.bytedance.pia.core.cache.IPiaCacheProvider;
import com.bytedance.trae.common.apphost.AppHost;
import java.net.URI;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: E2ENetworkOverrides.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0018\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u0019\u001a\u00020\u0016J\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\u001b\u001a\u00020\u000eJ\u000e\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u000eJ\u0010\u0010\u001e\u001a\u00020\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010\u0005J\b\u0010 \u001a\u0004\u0018\u00010\u0005J\u0015\u0010!\u001a\u00020\u00162\b\u0010\"\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010#J\r\u0010$\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010%J\u0015\u0010&\u001a\u00020\u00162\b\u0010\"\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010#J\r\u0010'\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010%J\r\u0010(\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010%J\u0006\u0010)\u001a\u00020\u000eJ\b\u0010*\u001a\u00020\u000eH\u0002J\n\u0010+\u001a\u0004\u0018\u00010,H\u0002J\u0010\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u0005H\u0002J\b\u0010/\u001a\u00020\u000eH\u0002J\n\u00100\u001a\u0004\u0018\u000101H\u0002J\u000e\u00102\u001a\b\u0012\u0002\b\u0003\u0018\u000103H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011¨\u00064"}, d2 = {"Lcom/bytedance/trae/network/E2ENetworkOverrides;", "", "<init>", "()V", "ALLOWED_HOST", "", "INSTRUMENTATION_REGISTRY_CLASS", "MOCK_BASE_URL_ARGUMENT", "BACKEND_MODE_ARGUMENT", "E2E_PREFS_NAME", "CMP_SETTINGS_ENTRY_ENABLED_KEY", "CMP_DEVICE_MANAGEMENT_ENABLED_KEY", "baseUrl", "forceHubHttpFallback", "", "overrideEnabled", "networkAvailableOverride", "Ljava/lang/Boolean;", "taskPinMinIdeVersionOverride", "cmpSettingsEntryEnabledOverride", "cmpDeviceManagementEnabledOverride", "set", "", "fullBaseUrl", "forceHubHttpFallbackOnly", "clear", "overrideBaseUrlOrNull", "isHubHttpFallbackForced", "setNetworkAvailableForE2E", "available", "setTaskPinMinIdeVersionForE2E", IPiaCacheProvider.CacheConfig.FIELD_VERSION, "taskPinMinIdeVersionOverrideOrNull", "setCmpSettingsEntryEnabledForE2E", "enabled", "(Ljava/lang/Boolean;)V", "cmpSettingsEntryEnabledOverrideOrNull", "()Ljava/lang/Boolean;", "setCmpDeviceManagementEnabledForE2E", "cmpDeviceManagementEnabledOverrideOrNull", "networkAvailableOverrideOrNull", "shouldBypassAppLogDidWaitForMockE2E", "canUseOverride", "overridePrefsOrNull", "Landroid/content/SharedPreferences;", "normalizeAndValidate", "value", "isE2EInstrumentationRun", "instrumentationArgumentsOrNull", "Landroid/os/Bundle;", "loadInstrumentationRegistryClass", "Ljava/lang/Class;", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class E2ENetworkOverrides {
    private static final String ALLOWED_HOST = "127.0.0.1";
    private static final String BACKEND_MODE_ARGUMENT = "backendMode";
    private static final String CMP_DEVICE_MANAGEMENT_ENABLED_KEY = "cmp_device_management_enabled";
    private static final String CMP_SETTINGS_ENTRY_ENABLED_KEY = "cmp_settings_entry_enabled";
    private static final String E2E_PREFS_NAME = "e2e_network_overrides";
    public static final E2ENetworkOverrides INSTANCE = new E2ENetworkOverrides();
    private static final String INSTRUMENTATION_REGISTRY_CLASS = "androidx.test.platform.app.InstrumentationRegistry";
    private static final String MOCK_BASE_URL_ARGUMENT = "mockBaseUrl";
    private static volatile String baseUrl;
    private static volatile Boolean cmpDeviceManagementEnabledOverride;
    private static volatile Boolean cmpSettingsEntryEnabledOverride;
    private static volatile boolean forceHubHttpFallback;
    private static volatile Boolean networkAvailableOverride;
    private static volatile boolean overrideEnabled;
    private static volatile String taskPinMinIdeVersionOverride;

    private E2ENetworkOverrides() {
    }

    public final void set(String fullBaseUrl, boolean forceHubHttpFallback2) {
        Intrinsics.checkNotNullParameter(fullBaseUrl, "fullBaseUrl");
        if (!isE2EInstrumentationRun()) {
            throw new IllegalStateException("E2E network overrides are only available in debug androidTest runs with mockBaseUrl".toString());
        }
        baseUrl = normalizeAndValidate(fullBaseUrl);
        forceHubHttpFallback = forceHubHttpFallback2;
        overrideEnabled = true;
    }

    public final void forceHubHttpFallbackOnly(boolean forceHubHttpFallback2) {
        if (!isE2EInstrumentationRun()) {
            throw new IllegalStateException("E2E network overrides are only available in debug androidTest runs".toString());
        }
        baseUrl = null;
        forceHubHttpFallback = forceHubHttpFallback2;
        overrideEnabled = true;
    }

    public final void clear() {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor remove;
        SharedPreferences.Editor edit2;
        SharedPreferences.Editor remove2;
        baseUrl = null;
        forceHubHttpFallback = false;
        networkAvailableOverride = null;
        taskPinMinIdeVersionOverride = null;
        cmpSettingsEntryEnabledOverride = null;
        cmpDeviceManagementEnabledOverride = null;
        SharedPreferences overridePrefsOrNull = overridePrefsOrNull();
        if (overridePrefsOrNull != null && (edit2 = overridePrefsOrNull.edit()) != null && (remove2 = edit2.remove(CMP_SETTINGS_ENTRY_ENABLED_KEY)) != null) {
            remove2.apply();
        }
        SharedPreferences overridePrefsOrNull2 = overridePrefsOrNull();
        if (overridePrefsOrNull2 != null && (edit = overridePrefsOrNull2.edit()) != null && (remove = edit.remove(CMP_DEVICE_MANAGEMENT_ENABLED_KEY)) != null) {
            remove.apply();
        }
        overrideEnabled = false;
        NetworkMonitor.INSTANCE.applyE2EConnectivityOverride(null);
    }

    public final String overrideBaseUrlOrNull() {
        if (canUseOverride()) {
            return baseUrl;
        }
        return null;
    }

    public final boolean isHubHttpFallbackForced() {
        return canUseOverride() && forceHubHttpFallback;
    }

    public final void setNetworkAvailableForE2E(boolean available) {
        if (!isE2EInstrumentationRun()) {
            throw new IllegalStateException("E2E network availability override is only available in debug androidTest runs".toString());
        }
        networkAvailableOverride = Boolean.valueOf(available);
        overrideEnabled = true;
        NetworkMonitor.INSTANCE.applyE2EConnectivityOverride(Boolean.valueOf(available));
    }

    public final void setTaskPinMinIdeVersionForE2E(String version) {
        if (!isE2EInstrumentationRun()) {
            throw new IllegalStateException("E2E task pin settings override is only available in debug androidTest runs".toString());
        }
        if (version == null || !(!StringsKt.isBlank(version))) {
            version = null;
        }
        taskPinMinIdeVersionOverride = version;
        overrideEnabled = true;
    }

    public final String taskPinMinIdeVersionOverrideOrNull() {
        if (canUseOverride()) {
            return taskPinMinIdeVersionOverride;
        }
        return null;
    }

    public final void setCmpSettingsEntryEnabledForE2E(Boolean enabled) {
        SharedPreferences.Editor edit;
        if (!isE2EInstrumentationRun()) {
            throw new IllegalStateException("E2E CMP settings entry override is only available in debug androidTest runs".toString());
        }
        cmpSettingsEntryEnabledOverride = enabled;
        SharedPreferences overridePrefsOrNull = overridePrefsOrNull();
        if (overridePrefsOrNull != null && (edit = overridePrefsOrNull.edit()) != null) {
            if (enabled == null) {
                edit.remove(CMP_SETTINGS_ENTRY_ENABLED_KEY);
            } else {
                edit.putBoolean(CMP_SETTINGS_ENTRY_ENABLED_KEY, enabled.booleanValue());
            }
            edit.apply();
        }
        overrideEnabled = true;
    }

    public final Boolean cmpSettingsEntryEnabledOverrideOrNull() {
        if (!canUseOverride()) {
            return null;
        }
        Boolean bool = cmpSettingsEntryEnabledOverride;
        if (bool != null) {
            return Boolean.valueOf(bool.booleanValue());
        }
        SharedPreferences overridePrefsOrNull = overridePrefsOrNull();
        if (overridePrefsOrNull != null && overridePrefsOrNull.contains(CMP_SETTINGS_ENTRY_ENABLED_KEY)) {
            return Boolean.valueOf(overridePrefsOrNull.getBoolean(CMP_SETTINGS_ENTRY_ENABLED_KEY, false));
        }
        return null;
    }

    public final void setCmpDeviceManagementEnabledForE2E(Boolean enabled) {
        SharedPreferences.Editor edit;
        if (!isE2EInstrumentationRun()) {
            throw new IllegalStateException("E2E CMP device management override is only available in debug androidTest runs".toString());
        }
        cmpDeviceManagementEnabledOverride = enabled;
        SharedPreferences overridePrefsOrNull = overridePrefsOrNull();
        if (overridePrefsOrNull != null && (edit = overridePrefsOrNull.edit()) != null) {
            if (enabled == null) {
                edit.remove(CMP_DEVICE_MANAGEMENT_ENABLED_KEY);
            } else {
                edit.putBoolean(CMP_DEVICE_MANAGEMENT_ENABLED_KEY, enabled.booleanValue());
            }
            edit.apply();
        }
        overrideEnabled = true;
    }

    public final Boolean cmpDeviceManagementEnabledOverrideOrNull() {
        if (!canUseOverride()) {
            return null;
        }
        Boolean bool = cmpDeviceManagementEnabledOverride;
        if (bool != null) {
            return Boolean.valueOf(bool.booleanValue());
        }
        SharedPreferences overridePrefsOrNull = overridePrefsOrNull();
        if (overridePrefsOrNull != null && overridePrefsOrNull.contains(CMP_DEVICE_MANAGEMENT_ENABLED_KEY)) {
            return Boolean.valueOf(overridePrefsOrNull.getBoolean(CMP_DEVICE_MANAGEMENT_ENABLED_KEY, false));
        }
        return null;
    }

    public final Boolean networkAvailableOverrideOrNull() {
        if (canUseOverride()) {
            return networkAvailableOverride;
        }
        return null;
    }

    public final boolean shouldBypassAppLogDidWaitForMockE2E() {
        Bundle instrumentationArgumentsOrNull;
        String str;
        String string;
        Object obj;
        if (!AppHost.Companion.isDebug() || (instrumentationArgumentsOrNull = instrumentationArgumentsOrNull()) == null) {
            return false;
        }
        String string2 = instrumentationArgumentsOrNull.getString(BACKEND_MODE_ARGUMENT);
        if (string2 != null) {
            str = string2.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(str, "toLowerCase(...)");
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(str, "mock") && (string = instrumentationArgumentsOrNull.getString(MOCK_BASE_URL_ARGUMENT)) != null) {
            String str2 = StringsKt.isBlank(string) ^ true ? string : null;
            if (str2 != null) {
                try {
                    Result.Companion companion = Result.Companion;
                    E2ENetworkOverrides e2ENetworkOverrides = this;
                    normalizeAndValidate(str2);
                    obj = Result.constructor-impl(true);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                if (Result.isFailure-impl(obj)) {
                    obj = false;
                }
                return ((Boolean) obj).booleanValue();
            }
        }
        return false;
    }

    private final boolean canUseOverride() {
        return AppHost.Companion.isDebug() && (overrideEnabled || isE2EInstrumentationRun());
    }

    private final SharedPreferences overridePrefsOrNull() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            E2ENetworkOverrides e2ENetworkOverrides = this;
            obj = Result.constructor-impl(AppHost.Companion.getApplication().getSharedPreferences(E2E_PREFS_NAME, 0));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        return (SharedPreferences) obj;
    }

    private final String normalizeAndValidate(String value) {
        String str;
        String str2 = null;
        if (!StringsKt.endsWith$default(value, "/", false, 2, (Object) null)) {
            value = value + '/';
        }
        URI uri = new URI(value);
        String scheme = uri.getScheme();
        if (scheme != null) {
            str = scheme.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(str, "toLowerCase(...)");
        } else {
            str = null;
        }
        String host = uri.getHost();
        if (host != null) {
            str2 = host.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(str2, "toLowerCase(...)");
        }
        if (!(Intrinsics.areEqual(str, "http") || Intrinsics.areEqual(str, "https"))) {
            throw new IllegalStateException("E2E mock base URL must use http or https".toString());
        }
        if (Intrinsics.areEqual(str2, ALLOWED_HOST)) {
            return value;
        }
        throw new IllegalStateException("E2E mock base URL host must be 127.0.0.1".toString());
    }

    private final boolean isE2EInstrumentationRun() {
        Bundle instrumentationArgumentsOrNull;
        if (AppHost.Companion.isDebug() && (instrumentationArgumentsOrNull = instrumentationArgumentsOrNull()) != null) {
            return instrumentationArgumentsOrNull.containsKey(MOCK_BASE_URL_ARGUMENT) || Intrinsics.areEqual(instrumentationArgumentsOrNull.getString(BACKEND_MODE_ARGUMENT), "real");
        }
        return false;
    }

    private final Bundle instrumentationArgumentsOrNull() {
        Object obj;
        Class<?> loadInstrumentationRegistryClass = loadInstrumentationRegistryClass();
        if (loadInstrumentationRegistryClass == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            E2ENetworkOverrides e2ENetworkOverrides = this;
            Object invoke = loadInstrumentationRegistryClass.getMethod("getArguments", new Class[0]).invoke(null, new Object[0]);
            obj = Result.constructor-impl(invoke instanceof Bundle ? (Bundle) invoke : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        return (Bundle) (Result.isFailure-impl(obj) ? null : obj);
    }

    private final Class<?> loadInstrumentationRegistryClass() {
        Object obj;
        Object obj2;
        Class<?> cls;
        Iterator it = CollectionsKt.listOfNotNull(new ClassLoader[]{Thread.currentThread().getContextClassLoader(), E2ENetworkOverrides.class.getClassLoader(), ClassLoader.getSystemClassLoader()}).iterator();
        do {
            if (it.hasNext()) {
                ClassLoader classLoader = (ClassLoader) it.next();
                try {
                    Result.Companion companion = Result.Companion;
                    obj2 = Result.constructor-impl(Class.forName(INSTRUMENTATION_REGISTRY_CLASS, false, classLoader));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                }
                cls = (Class) (Result.isFailure-impl(obj2) ? null : obj2);
            } else {
                try {
                    Result.Companion companion3 = Result.Companion;
                    E2ENetworkOverrides e2ENetworkOverrides = this;
                    obj = Result.constructor-impl(Class.forName(INSTRUMENTATION_REGISTRY_CLASS));
                } catch (Throwable th2) {
                    Result.Companion companion4 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th2));
                }
                return (Class) (Result.isFailure-impl(obj) ? null : obj);
            }
        } while (cls == null);
        return cls;
    }
}
