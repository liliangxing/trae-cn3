package com.bytedance.timon.clipboard.suite.config;

import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.timon.clipboard.suite.TimonClipboardSuite;
import com.bytedance.timonbase.TMLogger;
import com.bytedance.timonbase.TimonConstantKt;
import com.bytedance.timonbase.config.TMConfigService;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CertConfigManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b \bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010$\u001a\u00020%J\u000e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0017J\u000e\u0010)\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0017J\u000e\u0010*\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0017J\u000e\u0010+\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0017J\u000e\u0010,\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0017J\u000e\u0010-\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0017J\u000e\u0010.\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0017J\u000e\u0010/\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0017J\u000e\u00100\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0017J\u000f\u00101\u001a\u0004\u0018\u00010\u001fH\u0000¢\u0006\u0002\b2J\n\u00103\u001a\u0004\u0018\u00010\u001fH\u0002J\u000f\u00104\u001a\u0004\u0018\u00010\u001fH\u0000¢\u0006\u0002\b5J\u0006\u00106\u001a\u00020\u0004J\u000e\u00107\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0017J\u0010\u00108\u001a\u0004\u0018\u00010\u00062\u0006\u0010(\u001a\u00020\u0017J\u000e\u00109\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0017J\u0006\u0010:\u001a\u00020%J\u000e\u0010;\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0017J\u000e\u0010<\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0017J\u000e\u0010=\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0017J\u000e\u0010>\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0017J\u0019\u0010?\u001a\u0004\u0018\u00010\u00152\b\u0010@\u001a\u0004\u0018\u00010\u001fH\u0000¢\u0006\u0002\bAJ\u000e\u0010B\u001a\u00020%2\u0006\u0010(\u001a\u00020\u0017J\u001a\u0010C\u001a\u00020%2\u0012\u0010\u001d\u001a\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001ej\u0002` J\u001a\u0010D\u001a\u00020%2\u0012\u0010\u001d\u001a\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001ej\u0002` J\u000e\u0010E\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0017J\u0006\u0010F\u001a\u00020%R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0015X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0018\u00010\u001ej\u0004\u0018\u0001` X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010!\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0018\u00010\u001ej\u0004\u0018\u0001` X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00040#X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/bytedance/timon/clipboard/suite/config/CertConfigManager;", "", "()V", "CLOSE_FAST_PASS", "", "DEFAULT_TOKEN_CONFIG", "Lcom/bytedance/timon/clipboard/suite/config/TokenConfig;", "DISABLE_ALL", "DISABLE_AUTO_READ_PASS", "DISABLE_AUTO_READ_SWITCH", "DISABLE_BASE_MODEL_INTERCEPT", "DISABLE_PATTERN_MATCH", "DISABLE_REPEAT_READ_USE_CACHE", "DISABLE_REPORT", "DISABLE_USE_CACHE", "DISABLE_USE_WRITE_CACHE", "ENABLE_CUSTOM_SAVE", "ENABLE_NONE_TEXT_IN_FIRST_INTERCEPT", "ENABLE_NOT_CONTAINS_TEXT_INTERCEPT", "ENABLE_TIMESTAMP_VERIFY_INTERCEPT", "LOCAL_CONFIG", "Lcom/bytedance/timon/clipboard/suite/config/ClipboardCertConfig;", "PASTEBOARD_KEY", "", "config", "getConfig$clipboard_suite_release", "()Lcom/bytedance/timon/clipboard/suite/config/ClipboardCertConfig;", "setConfig$clipboard_suite_release", "(Lcom/bytedance/timon/clipboard/suite/config/ClipboardCertConfig;)V", "configProvider", "Lkotlin/Function0;", "Lcom/google/gson/JsonObject;", "Lcom/bytedance/timon/clipboard/suite/config/CertConfigProvider;", "defaultConfigProvider", "disableRepeatReadCacheContainer", "Ljava/util/concurrent/ConcurrentHashMap;", "clearTokenHasReadClipData", "", "disableAutoReadPass", "", "token", "disableAutoReadSwitch", "disableBaseModelIntercept", "disableCache", "disableFastPass", "disablePatternMatch", "disableRepeatReadUseCache", "disableReport", "disableWriteCache", "fetchFromConfigProvider", "fetchFromConfigProvider$clipboard_suite_release", "fetchFromDefaultConfigProvider", "fetchFromTMConfig", "fetchFromTMConfig$clipboard_suite_release", "getBackgroundDuration", "getConfig", "getConfigOrNull", "getUnitDisable", "init", "isEnableCustomSaveTimestamp", "isEnableNoneTextInFirstIntercept", "isEnableNotContainsTextIntercept", "isEnableTimestampVerifyIntercept", "parsecConfig", "jsonObject", "parsecConfig$clipboard_suite_release", "recordTokenHasReadClipData", "registerConfigProvider", "registerDefaultConfigProvider", "tokenExpire", "updateTimonConfig", "clipboard-suite_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class CertConfigManager {
    private static final int CLOSE_FAST_PASS = 1;
    private static final int DISABLE_ALL = 127;
    private static final int DISABLE_AUTO_READ_PASS = 64;
    private static final int DISABLE_AUTO_READ_SWITCH = 2;
    private static final int DISABLE_BASE_MODEL_INTERCEPT = 32;
    private static final int DISABLE_PATTERN_MATCH = 4;
    private static final int DISABLE_REPEAT_READ_USE_CACHE = 256;
    private static final int DISABLE_REPORT = 16;
    private static final int DISABLE_USE_CACHE = 8;
    private static final int DISABLE_USE_WRITE_CACHE = 128;
    private static final int ENABLE_CUSTOM_SAVE = 512;
    private static final int ENABLE_NONE_TEXT_IN_FIRST_INTERCEPT = 4096;
    private static final int ENABLE_NOT_CONTAINS_TEXT_INTERCEPT = 2048;
    private static final int ENABLE_TIMESTAMP_VERIFY_INTERCEPT = 1024;
    private static final String PASTEBOARD_KEY = "pasteboard";
    private static ClipboardCertConfig config;
    private static Function0<JsonObject> configProvider;
    private static Function0<JsonObject> defaultConfigProvider;
    public static final CertConfigManager INSTANCE = new CertConfigManager();
    private static final TokenConfig DEFAULT_TOKEN_CONFIG = new TokenConfig(0, 0, 0.0f, null, 15, null);
    private static final ClipboardCertConfig LOCAL_CONFIG = new ClipboardCertConfig(32, MapsKt.emptyMap(), BaseApiResponse.API_THIRD_AUTHORIZE);
    private static final ConcurrentHashMap<String, Integer> disableRepeatReadCacheContainer = new ConcurrentHashMap<>();

    private CertConfigManager() {
    }

    public final ClipboardCertConfig getConfig$clipboard_suite_release() {
        return config;
    }

    public final void setConfig$clipboard_suite_release(ClipboardCertConfig clipboardCertConfig) {
        config = clipboardCertConfig;
    }

    public final void registerDefaultConfigProvider(Function0<JsonObject> configProvider2) {
        Intrinsics.checkParameterIsNotNull(configProvider2, "configProvider");
        defaultConfigProvider = configProvider2;
    }

    public final void registerConfigProvider(Function0<JsonObject> configProvider2) {
        Intrinsics.checkParameterIsNotNull(configProvider2, "configProvider");
        configProvider = configProvider2;
    }

    public final void init() {
        if (config == null) {
            ClipboardCertConfig parsecConfig$clipboard_suite_release = parsecConfig$clipboard_suite_release(fetchFromConfigProvider$clipboard_suite_release());
            if (parsecConfig$clipboard_suite_release == null) {
                parsecConfig$clipboard_suite_release = parsecConfig$clipboard_suite_release(fetchFromTMConfig$clipboard_suite_release());
            }
            if (parsecConfig$clipboard_suite_release == null) {
                parsecConfig$clipboard_suite_release = parsecConfig$clipboard_suite_release(fetchFromDefaultConfigProvider());
            }
            if (parsecConfig$clipboard_suite_release == null) {
                parsecConfig$clipboard_suite_release = LOCAL_CONFIG;
            }
            config = parsecConfig$clipboard_suite_release;
        }
    }

    public final void updateTimonConfig() {
        ClipboardCertConfig parsecConfig$clipboard_suite_release = parsecConfig$clipboard_suite_release(fetchFromTMConfig$clipboard_suite_release());
        if (parsecConfig$clipboard_suite_release != null) {
            config = parsecConfig$clipboard_suite_release;
        }
    }

    public final ClipboardCertConfig parsecConfig$clipboard_suite_release(JsonObject jsonObject) {
        if (jsonObject == null) {
            return null;
        }
        try {
            JsonElement jsonElement = jsonObject.get("unit_disable");
            int asInt = jsonElement != null ? jsonElement.getAsInt() : 0;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Set<Map.Entry> entrySet = jsonObject.entrySet();
            Intrinsics.checkExpressionValueIsNotNull(entrySet, "jsonObject.entrySet()");
            for (Map.Entry entry : entrySet) {
                if (!Intrinsics.areEqual((String) entry.getKey(), "unit_disable") && !Intrinsics.areEqual((String) entry.getKey(), "enter_background_duration_threshold")) {
                    Object key = entry.getKey();
                    Intrinsics.checkExpressionValueIsNotNull(key, "it.key");
                    Object fromJson = new Gson().fromJson((JsonElement) entry.getValue(), TokenConfig.class);
                    Intrinsics.checkExpressionValueIsNotNull(fromJson, "Gson().fromJson(it.value, TokenConfig::class.java)");
                    linkedHashMap.put(key, fromJson);
                }
            }
            JsonElement jsonElement2 = jsonObject.get("enter_background_duration_threshold");
            return new ClipboardCertConfig(asInt, linkedHashMap, jsonElement2 != null ? jsonElement2.getAsInt() : BaseApiResponse.API_THIRD_AUTHORIZE);
        } catch (Exception unused) {
            return null;
        }
    }

    public final JsonObject fetchFromTMConfig$clipboard_suite_release() {
        try {
            JsonObject configJson = TMConfigService.INSTANCE.getConfigJson(TimonConstantKt.CERTS_CONFIG);
            JsonObject asJsonObject = configJson != null ? configJson.getAsJsonObject(PASTEBOARD_KEY) : null;
            if (asJsonObject == null) {
                TMLogger.INSTANCE.m224v(TimonClipboardSuite.TAG, "从 TMConfig 中获取配置失败");
                return null;
            }
            TMLogger.INSTANCE.m224v(TimonClipboardSuite.TAG, "从 TMConfig 中获取配置成功");
            return asJsonObject;
        } catch (Throwable unused) {
            TMLogger.INSTANCE.m224v(TimonClipboardSuite.TAG, "parse config failed");
            return null;
        }
    }

    public final JsonObject fetchFromConfigProvider$clipboard_suite_release() {
        Function0<JsonObject> function0 = configProvider;
        JsonObject jsonObject = function0 != null ? (JsonObject) function0.invoke() : null;
        if (jsonObject != null) {
            TMLogger.INSTANCE.m224v(TimonClipboardSuite.TAG, "从 ConfigProvider 中获取配置成功");
        } else {
            TMLogger.INSTANCE.m224v(TimonClipboardSuite.TAG, "从 ConfigProvider 中获取配置失败");
        }
        return jsonObject;
    }

    private final JsonObject fetchFromDefaultConfigProvider() {
        Function0<JsonObject> function0 = defaultConfigProvider;
        JsonObject jsonObject = function0 != null ? (JsonObject) function0.invoke() : null;
        if (jsonObject != null) {
            TMLogger.INSTANCE.m224v(TimonClipboardSuite.TAG, "从 defaultConfigProvider 中获取配置成功");
        } else {
            TMLogger.INSTANCE.m224v(TimonClipboardSuite.TAG, "从 defaultConfigProvider 中获取配置失败");
        }
        return jsonObject;
    }

    public final TokenConfig getConfig(String token) {
        Map<String, TokenConfig> tokenConfig;
        TokenConfig tokenConfig2;
        Intrinsics.checkParameterIsNotNull(token, "token");
        ClipboardCertConfig clipboardCertConfig = config;
        return (clipboardCertConfig == null || (tokenConfig = clipboardCertConfig.getTokenConfig()) == null || (tokenConfig2 = tokenConfig.get(token)) == null) ? DEFAULT_TOKEN_CONFIG : tokenConfig2;
    }

    public final TokenConfig getConfigOrNull(String token) {
        Map<String, TokenConfig> tokenConfig;
        Intrinsics.checkParameterIsNotNull(token, "token");
        ClipboardCertConfig clipboardCertConfig = config;
        if (clipboardCertConfig == null || (tokenConfig = clipboardCertConfig.getTokenConfig()) == null) {
            return null;
        }
        return tokenConfig.get(token);
    }

    public final boolean disableFastPass(String token) {
        Intrinsics.checkParameterIsNotNull(token, "token");
        ClipboardCertConfig clipboardCertConfig = config;
        if (clipboardCertConfig != null) {
            return ((getConfig(token).getUnitDisable() | clipboardCertConfig.getUnitDisable()) & 1) != 0;
        }
        return false;
    }

    public final boolean disableAutoReadSwitch(String token) {
        Intrinsics.checkParameterIsNotNull(token, "token");
        ClipboardCertConfig clipboardCertConfig = config;
        if (clipboardCertConfig != null) {
            return ((getConfig(token).getUnitDisable() | clipboardCertConfig.getUnitDisable()) & 2) != 0;
        }
        return false;
    }

    public final boolean disablePatternMatch(String token) {
        Intrinsics.checkParameterIsNotNull(token, "token");
        ClipboardCertConfig clipboardCertConfig = config;
        if (clipboardCertConfig == null) {
            return true;
        }
        int unitDisable = clipboardCertConfig.getUnitDisable();
        TokenConfig config2 = getConfig(token);
        return config2.getPatterns().isEmpty() || ((config2.getUnitDisable() | unitDisable) & 4) != 0;
    }

    public final boolean disableCache(String token) {
        Intrinsics.checkParameterIsNotNull(token, "token");
        ClipboardCertConfig clipboardCertConfig = config;
        if (clipboardCertConfig != null) {
            return ((getConfig(token).getUnitDisable() | clipboardCertConfig.getUnitDisable()) & 8) != 0;
        }
        return false;
    }

    public final boolean disableWriteCache(String token) {
        Intrinsics.checkParameterIsNotNull(token, "token");
        ClipboardCertConfig clipboardCertConfig = config;
        if (clipboardCertConfig != null) {
            return ((getConfig(token).getUnitDisable() | clipboardCertConfig.getUnitDisable()) & DISABLE_USE_WRITE_CACHE) != 0;
        }
        return false;
    }

    public final boolean disableReport(String token) {
        Intrinsics.checkParameterIsNotNull(token, "token");
        ClipboardCertConfig clipboardCertConfig = config;
        if (clipboardCertConfig != null) {
            return ((getConfig(token).getUnitDisable() | clipboardCertConfig.getUnitDisable()) & 16) != 0;
        }
        return false;
    }

    public final boolean tokenExpire(String token) {
        Intrinsics.checkParameterIsNotNull(token, "token");
        TokenConfig config2 = getConfig(token);
        return config2.getExpireTime() != 0 && System.currentTimeMillis() > config2.getExpireTime();
    }

    public final boolean disableBaseModelIntercept(String token) {
        Intrinsics.checkParameterIsNotNull(token, "token");
        ClipboardCertConfig clipboardCertConfig = config;
        if (clipboardCertConfig != null) {
            return ((getConfig(token).getUnitDisable() | clipboardCertConfig.getUnitDisable()) & 32) != 0;
        }
        return true;
    }

    public final boolean disableAutoReadPass(String token) {
        Intrinsics.checkParameterIsNotNull(token, "token");
        ClipboardCertConfig clipboardCertConfig = config;
        if (clipboardCertConfig != null) {
            return ((getConfig(token).getUnitDisable() | clipboardCertConfig.getUnitDisable()) & 64) != 0;
        }
        return false;
    }

    public final boolean disableRepeatReadUseCache(String token) {
        Intrinsics.checkParameterIsNotNull(token, "token");
        return (getConfig(token).getUnitDisable() & 256) != 0 && disableRepeatReadCacheContainer.containsKey(token);
    }

    public final boolean isEnableNotContainsTextIntercept(String token) {
        Intrinsics.checkParameterIsNotNull(token, "token");
        ClipboardCertConfig clipboardCertConfig = config;
        if (clipboardCertConfig == null) {
            clipboardCertConfig = new ClipboardCertConfig(0, null, 0, 7, null);
        }
        int unitDisable = clipboardCertConfig.getUnitDisable();
        TokenConfig configOrNull = getConfigOrNull(token);
        if ((configOrNull != null ? Integer.valueOf(configOrNull.getUnitDisable()) : null) != null && configOrNull.getUnitDisable() != 0) {
            unitDisable = configOrNull.getUnitDisable();
        }
        return (unitDisable & 2048) != 0;
    }

    public final boolean isEnableNoneTextInFirstIntercept(String token) {
        Intrinsics.checkParameterIsNotNull(token, "token");
        ClipboardCertConfig clipboardCertConfig = config;
        if (clipboardCertConfig == null) {
            clipboardCertConfig = new ClipboardCertConfig(0, null, 0, 7, null);
        }
        int unitDisable = clipboardCertConfig.getUnitDisable();
        TokenConfig configOrNull = getConfigOrNull(token);
        if ((configOrNull != null ? Integer.valueOf(configOrNull.getUnitDisable()) : null) != null && configOrNull.getUnitDisable() != 0) {
            unitDisable = configOrNull.getUnitDisable();
        }
        return (unitDisable & 4096) != 0;
    }

    public final boolean isEnableCustomSaveTimestamp(String token) {
        Intrinsics.checkParameterIsNotNull(token, "token");
        ClipboardCertConfig clipboardCertConfig = config;
        if (clipboardCertConfig == null) {
            clipboardCertConfig = new ClipboardCertConfig(0, null, 0, 7, null);
        }
        int unitDisable = clipboardCertConfig.getUnitDisable();
        TokenConfig configOrNull = getConfigOrNull(token);
        if ((configOrNull != null ? Integer.valueOf(configOrNull.getUnitDisable()) : null) != null && configOrNull.getUnitDisable() != 0) {
            unitDisable = configOrNull.getUnitDisable();
        }
        return (unitDisable & 512) != 0;
    }

    public final boolean isEnableTimestampVerifyIntercept(String token) {
        Intrinsics.checkParameterIsNotNull(token, "token");
        ClipboardCertConfig clipboardCertConfig = config;
        if (clipboardCertConfig == null) {
            clipboardCertConfig = new ClipboardCertConfig(0, null, 0, 7, null);
        }
        int unitDisable = clipboardCertConfig.getUnitDisable();
        TokenConfig configOrNull = getConfigOrNull(token);
        if ((configOrNull != null ? Integer.valueOf(configOrNull.getUnitDisable()) : null) != null && configOrNull.getUnitDisable() != 0) {
            unitDisable = configOrNull.getUnitDisable();
        }
        return (unitDisable & 1024) != 0;
    }

    public final void recordTokenHasReadClipData(String token) {
        Intrinsics.checkParameterIsNotNull(token, "token");
        if ((getConfig(token).getUnitDisable() & 256) == 0) {
            return;
        }
        disableRepeatReadCacheContainer.put(token, 1);
    }

    public final void clearTokenHasReadClipData() {
        disableRepeatReadCacheContainer.clear();
    }

    public final int getUnitDisable(String token) {
        Intrinsics.checkParameterIsNotNull(token, "token");
        TokenConfig config2 = getConfig(token);
        ClipboardCertConfig clipboardCertConfig = config;
        return config2.getUnitDisable() | (clipboardCertConfig != null ? clipboardCertConfig.getUnitDisable() : 0);
    }

    public final int getBackgroundDuration() {
        ClipboardCertConfig clipboardCertConfig = config;
        return clipboardCertConfig != null ? clipboardCertConfig.getBackgroundDuration() : BaseApiResponse.API_THIRD_AUTHORIZE;
    }
}
