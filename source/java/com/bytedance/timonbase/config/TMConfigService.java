package com.bytedance.timonbase.config;

import com.bytedance.timonbase.TMLogger;
import com.bytedance.timonbase.TimonConstantKt;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TMConfigService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002&'B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001a\u001a\u00020\u0004J\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004J \u0010\u0019\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004J\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u001ej\u0004\u0018\u0001`\u001fJ\u0012\u0010 \u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001a\u001a\u00020\u0004H\u0002J$\u0010!\u001a\u00020\u00182\u001c\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u001ej\u0004\u0018\u0001`\u001fJ\"\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u00042\u0012\u0010\u0011\u001a\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00060$j\u0002`%R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/bytedance/timonbase/config/TMConfigService;", "", "()V", "TAG", "", "defaultConfig", "Lcom/google/gson/JsonObject;", "getDefaultConfig", "()Lcom/google/gson/JsonObject;", "setDefaultConfig", "(Lcom/google/gson/JsonObject;)V", "enableLocalSettingFallback", "", "getEnableLocalSettingFallback", "()Z", "setEnableLocalSettingFallback", "(Z)V", "fetcher", "Lcom/bytedance/timonbase/config/TMConfigService$CacheSettingFetcher;", "localSettingLoader", "subSettingFetchers", "", "Lcom/bytedance/timonbase/config/TMConfigService$CacheSubSettingFetcher;", "flushSettings", "", "getConfigJson", "key", "secondaryKey", "thirdKey", "getCurrentConfigFetcher", "Lkotlin/Function1;", "Lcom/bytedance/timonbase/scene/SettingFetcher;", "invokeSettingFetcher", "setConfigFetcher", "setSubConfigFetcher", "subKey", "Lkotlin/Function0;", "Lcom/bytedance/timonbase/scene/SubSettingFetcher;", "CacheSettingFetcher", "CacheSubSettingFetcher", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TMConfigService {
    private static final String TAG = "TMConfigService";
    private static JsonObject defaultConfig;
    private static boolean enableLocalSettingFallback;
    private static CacheSettingFetcher fetcher;
    public static final TMConfigService INSTANCE = new TMConfigService();
    private static CacheSettingFetcher localSettingLoader = new CacheSettingFetcher(new TMLocalSettingLoader());
    private static final Map<String, CacheSubSettingFetcher> subSettingFetchers = new LinkedHashMap();

    private TMConfigService() {
    }

    public final JsonObject getDefaultConfig() {
        return defaultConfig;
    }

    public final void setDefaultConfig(JsonObject jsonObject) {
        defaultConfig = jsonObject;
    }

    public final boolean getEnableLocalSettingFallback() {
        return enableLocalSettingFallback;
    }

    public final void setEnableLocalSettingFallback(boolean z) {
        enableLocalSettingFallback = z;
    }

    public final void setConfigFetcher(Function1<? super String, JsonObject> fetcher2) {
        fetcher = new CacheSettingFetcher(fetcher2);
    }

    public final void setSubConfigFetcher(String subKey, Function0<JsonObject> fetcher2) {
        Intrinsics.checkParameterIsNotNull(subKey, "subKey");
        Intrinsics.checkParameterIsNotNull(fetcher2, "fetcher");
        subSettingFetchers.put(subKey, new CacheSubSettingFetcher(fetcher2));
    }

    public final Function1<String, JsonObject> getCurrentConfigFetcher() {
        CacheSettingFetcher cacheSettingFetcher = fetcher;
        if (cacheSettingFetcher != null) {
            return cacheSettingFetcher.getImpl();
        }
        return null;
    }

    public final void flushSettings() {
        CacheSettingFetcher cacheSettingFetcher = fetcher;
        if (cacheSettingFetcher != null) {
            cacheSettingFetcher.flushCache();
        }
        Iterator<T> it = subSettingFetchers.values().iterator();
        while (it.hasNext()) {
            ((CacheSubSettingFetcher) it.next()).flushCache();
        }
    }

    private final JsonObject invokeSettingFetcher(String key) {
        CacheSettingFetcher cacheSettingFetcher = fetcher;
        JsonObject invoke = cacheSettingFetcher != null ? cacheSettingFetcher.invoke(key) : null;
        if (invoke == null) {
            JsonObject jsonObject = defaultConfig;
            invoke = jsonObject != null ? jsonObject.getAsJsonObject(key) : null;
        }
        if (!enableLocalSettingFallback || invoke != null) {
            return invoke;
        }
        TMLogger.INSTANCE.m219d(TAG, "setting_fetcher return null for key[" + key + "], try load from local");
        return localSettingLoader.invoke(key);
    }

    public final JsonObject getConfigJson(String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        if (Intrinsics.areEqual(key, TimonConstantKt.RULER_RULE_KEY)) {
            return invokeSettingFetcher(TimonConstantKt.RULER_RULE_KEY);
        }
        if (Intrinsics.areEqual(key, "timon_config")) {
            JsonObject invokeSettingFetcher = invokeSettingFetcher("timon_config");
            for (Map.Entry<String, CacheSubSettingFetcher> entry : subSettingFetchers.entrySet()) {
                JsonElement m1049invoke = entry.getValue().m1049invoke();
                if (m1049invoke != null && invokeSettingFetcher != null) {
                    invokeSettingFetcher.add(entry.getKey(), m1049invoke);
                }
            }
            return invokeSettingFetcher;
        }
        if (Intrinsics.areEqual(key, TimonConstantKt.SENSITIVE_PATH_CONFIG_KEY)) {
            CacheSubSettingFetcher cacheSubSettingFetcher = subSettingFetchers.get(TimonConstantKt.SENSITIVE_PATH_CONFIG_KEY);
            if (cacheSubSettingFetcher != null) {
                return cacheSubSettingFetcher.m1049invoke();
            }
            return invokeSettingFetcher(TimonConstantKt.SENSITIVE_PATH_CONFIG_KEY);
        }
        if (Intrinsics.areEqual(key, TimonConstantKt.TIMON_ENCRYPTION_LIST)) {
            CacheSubSettingFetcher cacheSubSettingFetcher2 = subSettingFetchers.get(TimonConstantKt.TIMON_ENCRYPTION_LIST);
            if (cacheSubSettingFetcher2 != null) {
                return cacheSubSettingFetcher2.m1049invoke();
            }
            return invokeSettingFetcher(TimonConstantKt.TIMON_ENCRYPTION_LIST);
        }
        CacheSubSettingFetcher cacheSubSettingFetcher3 = subSettingFetchers.get(key);
        JsonObject m1049invoke2 = cacheSubSettingFetcher3 != null ? cacheSubSettingFetcher3.m1049invoke() : null;
        if (m1049invoke2 != null) {
            return m1049invoke2;
        }
        JsonObject invokeSettingFetcher2 = invokeSettingFetcher("timon_config");
        if (invokeSettingFetcher2 != null) {
            return invokeSettingFetcher2.getAsJsonObject(key);
        }
        return null;
    }

    public final JsonObject getConfigJson(String key, String secondaryKey) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(secondaryKey, "secondaryKey");
        JsonObject configJson = getConfigJson(key);
        if (configJson != null) {
            return configJson.getAsJsonObject(secondaryKey);
        }
        return null;
    }

    public final JsonObject getConfigJson(String key, String secondaryKey, String thirdKey) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(secondaryKey, "secondaryKey");
        Intrinsics.checkParameterIsNotNull(thirdKey, "thirdKey");
        JsonObject configJson = getConfigJson(key, secondaryKey);
        if (configJson != null) {
            return configJson.getAsJsonObject(thirdKey);
        }
        return null;
    }

    /* compiled from: TMConfigService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001j\u0002`\u0004B#\u0012\u001c\u0010\u0005\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0001j\u0004\u0018\u0001`\u0004¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\fJ\u0013\u0010\r\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000e\u001a\u00020\u0002H\u0096\u0002R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\bX\u0082\u0004¢\u0006\u0002\n\u0000R'\u0010\u0005\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0001j\u0004\u0018\u0001`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/bytedance/timonbase/config/TMConfigService$CacheSettingFetcher;", "Lkotlin/Function1;", "", "Lcom/google/gson/JsonObject;", "Lcom/bytedance/timonbase/scene/SettingFetcher;", "impl", "(Lkotlin/jvm/functions/Function1;)V", "cache", "Ljava/util/concurrent/ConcurrentHashMap;", "getImpl", "()Lkotlin/jvm/functions/Function1;", "flushCache", "", "invoke", "key", "timonbase_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class CacheSettingFetcher implements Function1<String, JsonObject> {
        private final ConcurrentHashMap<String, JsonObject> cache = new ConcurrentHashMap<>();
        private final Function1<String, JsonObject> impl;

        /* JADX WARN: Multi-variable type inference failed */
        public CacheSettingFetcher(Function1<? super String, JsonObject> function1) {
            this.impl = function1;
        }

        public final Function1<String, JsonObject> getImpl() {
            return this.impl;
        }

        public JsonObject invoke(String key) {
            JsonObject jsonObject;
            Intrinsics.checkParameterIsNotNull(key, "key");
            JsonObject jsonObject2 = this.cache.get(key);
            if (jsonObject2 != null) {
                return jsonObject2;
            }
            Function1<String, JsonObject> function1 = this.impl;
            if (function1 == null || (jsonObject = (JsonObject) function1.invoke(key)) == null) {
                return null;
            }
            this.cache.put(key, jsonObject);
            return jsonObject;
        }

        public final void flushCache() {
            this.cache.clear();
        }
    }

    /* compiled from: TMConfigService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001j\u0002`\u0003B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001j\u0002`\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\t\u001a\u00020\nJ\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0096\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001j\u0002`\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/timonbase/config/TMConfigService$CacheSubSettingFetcher;", "Lkotlin/Function0;", "Lcom/google/gson/JsonObject;", "Lcom/bytedance/timonbase/scene/SubSettingFetcher;", "impl", "(Lkotlin/jvm/functions/Function0;)V", "cache", "loaded", "", "flushCache", "", "invoke", "timonbase_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class CacheSubSettingFetcher implements Function0<JsonObject> {
        private JsonObject cache;
        private final Function0<JsonObject> impl;
        private boolean loaded;

        public CacheSubSettingFetcher(Function0<JsonObject> function0) {
            Intrinsics.checkParameterIsNotNull(function0, "impl");
            this.impl = function0;
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public JsonObject m1049invoke() {
            if (!this.loaded) {
                this.cache = (JsonObject) this.impl.invoke();
                this.loaded = true;
            }
            return this.cache;
        }

        public final void flushCache() {
            this.cache = null;
            this.loaded = false;
        }
    }
}
