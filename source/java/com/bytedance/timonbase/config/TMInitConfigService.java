package com.bytedance.timonbase.config;

import com.bytedance.timonbase.ITMLifecycleService;
import com.bytedance.timonbase.TMLogger;
import com.bytedance.timonbase.TimonConstantKt;
import com.bytedance.timonbase.cache.TMCacheService;
import com.bytedance.timonkit.TimonConstant;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TMInitConfigService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010%\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0019J\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001eJ\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020 J\u0016\u0010!\u001a\u00020\"2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\"J\u001a\u0010#\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001b\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004J\b\u0010$\u001a\u00020%H\u0002J\u0016\u0010&\u001a\u00020%2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0019J\u0016\u0010(\u001a\u00020%2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0019J\u0016\u0010)\u001a\u00020%2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u001eJ\u0016\u0010*\u001a\u00020%2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010'\u001a\u00020 J\u0016\u0010+\u001a\u00020%2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0004J\u0016\u0010,\u001a\u00020%2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u001eJ\u0016\u0010-\u001a\u00020%2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010'\u001a\u00020 J\u0016\u0010.\u001a\u00020%2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\"J\u0016\u0010/\u001a\u00020%2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0004J\u0006\u00100\u001a\u00020%R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/bytedance/timonbase/config/TMInitConfigService;", "", "()V", "ANIT_SURVIVAL_FORBIDDEN_ALARM_SERVICE", "", "ANTI_SURVIVAL_CLOSE_PUSH_PROXY", "ANTI_SURVIVAL_ENABLE", "ANTI_SURVIVAL_FORBIDDEN_JOB_SCHEDULER", "ANTI_SURVIVAL_MONITOR", "BPEA_ENABLE", "BPEA_PIPELINE_ENABLE", "HELIOS_ENABLE", "IS_UPDATE_CONFIG_SUCCESSFULLY", "NETWORK_CONTROL_ENABLE", "PERMISSION_KEEPER_LOCATION", "RULER_ENABLE", "SHIELD_ENABLE", "SILENT_MODE_DURATION", "SILENT_MODE_ENABLE", "TAG", "TIMON_CACHE_ENABLE", "UPC_ENABLE", "defaultValues", "", "updateInitConfigCalled", "", "getBoolean", "key", "defaultValue", "getFloat", "", "getInt", "", "getLong", "", "getString", "preInvokeReadValueFunction", "", "putBoolean", "value", "putDefaultBoolean", "putDefaultFloat", "putDefaultInt", "putDefaultString", "putFloat", "putInt", "putLong", "putString", "updateInitConfig", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TMInitConfigService {
    public static final String ANIT_SURVIVAL_FORBIDDEN_ALARM_SERVICE = "anti_survival.forbidden_alarm_service";
    public static final String ANTI_SURVIVAL_CLOSE_PUSH_PROXY = "anti_survival.close_push_service_proxy";
    public static final String ANTI_SURVIVAL_ENABLE = "init.anti_survival_switch.enable";
    public static final String ANTI_SURVIVAL_FORBIDDEN_JOB_SCHEDULER = "anti_survival.forbidden_job_scheduler";
    public static final String ANTI_SURVIVAL_MONITOR = "anti_survival.monitor_enable";
    public static final String BPEA_ENABLE = "init.bpea.enable";
    public static final String BPEA_PIPELINE_ENABLE = "init.bpea_pipline.enable";
    public static final String HELIOS_ENABLE = "init.monitor.enable";
    public static final String IS_UPDATE_CONFIG_SUCCESSFULLY = "init.is_update_config_successfully";
    public static final String NETWORK_CONTROL_ENABLE = "init.network_control_config.enable";
    public static final String PERMISSION_KEEPER_LOCATION = "init.permission_keeper_location.enable";
    public static final String RULER_ENABLE = "init.rule_engine_config.enable";
    public static final String SHIELD_ENABLE = "init.timon_shield.enable";
    public static final String SILENT_MODE_DURATION = "silent_mode_duration";
    public static final String SILENT_MODE_ENABLE = "scene_config.silent_mode";
    public static final String TAG = "TMInitConfigService";
    public static final String TIMON_CACHE_ENABLE = "init.timon_cache.enable";
    public static final String UPC_ENABLE = "init.upc.enable";
    private static boolean updateInitConfigCalled;
    public static final TMInitConfigService INSTANCE = new TMInitConfigService();
    private static final Map<String, Object> defaultValues = new LinkedHashMap();

    private TMInitConfigService() {
    }

    public final void updateInitConfig() {
        Object obj;
        Object obj2;
        Unit unit;
        JsonElement jsonElement;
        JsonElement jsonElement2;
        JsonElement jsonElement3;
        JsonElement jsonElement4;
        JsonElement jsonElement5;
        JsonElement jsonElement6;
        JsonElement jsonElement7;
        JsonElement jsonElement8;
        JsonElement jsonElement9;
        JsonElement jsonElement10;
        JsonElement jsonElement11;
        JsonElement jsonElement12;
        JsonElement jsonElement13;
        JsonElement jsonElement14;
        JsonElement jsonElement15;
        JsonElement jsonElement16;
        Set services = ServiceManager.get().getServices(ITMLifecycleService.class);
        Intrinsics.checkExpressionValueIsNotNull(services, "ServiceManager.get().get…cycleService::class.java)");
        Iterator it = services.iterator();
        while (it.hasNext()) {
            ((ITMLifecycleService) it.next()).updateInitConfig();
        }
        JsonObject configJson = TMConfigService.INSTANCE.getConfigJson("monitor");
        if (configJson != null && (jsonElement16 = configJson.get("enable")) != null) {
            INSTANCE.putBoolean(HELIOS_ENABLE, jsonElement16.getAsBoolean());
        }
        JsonObject configJson2 = TMConfigService.INSTANCE.getConfigJson("rule_engine_config");
        if (configJson2 != null && (jsonElement15 = configJson2.get("enable")) != null) {
            INSTANCE.putBoolean(RULER_ENABLE, jsonElement15.getAsBoolean());
        }
        JsonObject configJson3 = TMConfigService.INSTANCE.getConfigJson("bpea");
        if (configJson3 != null && (jsonElement14 = configJson3.get("enable")) != null) {
            INSTANCE.putBoolean(BPEA_ENABLE, jsonElement14.getAsBoolean());
        }
        JsonObject configJson4 = TMConfigService.INSTANCE.getConfigJson("bpea_pipeline");
        if (configJson4 != null && (jsonElement13 = configJson4.get("enable")) != null) {
            INSTANCE.putBoolean(BPEA_PIPELINE_ENABLE, jsonElement13.getAsBoolean());
        }
        JsonObject configJson5 = TMConfigService.INSTANCE.getConfigJson(TimonConstantKt.TIMON_SHIELD_CONFIG_KEY);
        if (configJson5 != null && (jsonElement12 = configJson5.get("enable")) != null) {
            INSTANCE.putBoolean(SHIELD_ENABLE, jsonElement12.getAsBoolean());
        }
        JsonObject configJson6 = TMConfigService.INSTANCE.getConfigJson(TimonConstantKt.TIMON_CACHE_CONFIG_KEY);
        if (configJson6 != null && (jsonElement11 = configJson6.get("enable")) != null) {
            INSTANCE.putBoolean(TIMON_CACHE_ENABLE, jsonElement11.getAsBoolean());
        }
        JsonObject configJson7 = TMConfigService.INSTANCE.getConfigJson(TimonConstantKt.TIMON_PERMISSION_KEEPER_LOCATION_KEY);
        if (configJson7 != null && (jsonElement10 = configJson7.get("enable")) != null) {
            INSTANCE.putBoolean(PERMISSION_KEEPER_LOCATION, jsonElement10.getAsBoolean());
        }
        JsonObject configJson8 = TMConfigService.INSTANCE.getConfigJson("anti_survival_switch");
        if (configJson8 != null && (jsonElement9 = configJson8.get("enable")) != null) {
            INSTANCE.putBoolean(ANTI_SURVIVAL_ENABLE, jsonElement9.getAsBoolean());
        }
        if (configJson8 != null && (jsonElement8 = configJson8.get("monitor_enable")) != null) {
            INSTANCE.putBoolean(ANTI_SURVIVAL_MONITOR, jsonElement8.getAsBoolean());
        }
        if (configJson8 != null && (jsonElement7 = configJson8.get("forbidden_job_scheduler")) != null) {
            INSTANCE.putBoolean(ANTI_SURVIVAL_FORBIDDEN_JOB_SCHEDULER, jsonElement7.getAsBoolean());
        }
        if (configJson8 != null && (jsonElement6 = configJson8.get("forbidden_alarm_service")) != null) {
            INSTANCE.putBoolean(ANIT_SURVIVAL_FORBIDDEN_ALARM_SERVICE, jsonElement6.getAsBoolean());
        }
        if (configJson8 != null && (jsonElement5 = configJson8.get("close_push_service_proxy")) != null) {
            INSTANCE.putBoolean(ANTI_SURVIVAL_CLOSE_PUSH_PROXY, jsonElement5.getAsBoolean());
        }
        try {
            Result.Companion companion = Result.Companion;
            JsonObject configJson9 = TMConfigService.INSTANCE.getConfigJson(TimonConstantKt.NETWORK_MONITOR_CONFIG_KEY);
            if (configJson9 == null) {
                configJson9 = new JsonObject();
            }
            obj = Result.constructor-impl(configJson9);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isSuccess-impl(obj) && (jsonElement4 = ((JsonObject) obj).get("enable")) != null) {
            INSTANCE.putBoolean(NETWORK_CONTROL_ENABLE, jsonElement4.getAsBoolean());
        }
        JsonObject configJson10 = TMConfigService.INSTANCE.getConfigJson("upc");
        if (configJson10 != null && (jsonElement3 = configJson10.get("enable")) != null) {
            INSTANCE.putBoolean(UPC_ENABLE, jsonElement3.getAsBoolean());
        }
        try {
            Result.Companion companion3 = Result.Companion;
            JsonObject configJson11 = TMConfigService.INSTANCE.getConfigJson(TimonConstant.CONFIG_KEY_SCENE_CONFIG);
            if (configJson11 == null) {
                TMLogger.INSTANCE.m221e(TAG, "未拉取到场景检测配置");
            }
            if (configJson11 != null && (jsonElement2 = configJson11.get("silent_scene_enable")) != null) {
                INSTANCE.putBoolean(SILENT_MODE_ENABLE, jsonElement2.getAsBoolean());
            }
            if (configJson11 == null || (jsonElement = configJson11.get("silent_scene_threshold")) == null) {
                unit = null;
            } else {
                INSTANCE.putLong(SILENT_MODE_DURATION, jsonElement.getAsLong());
                unit = Unit.INSTANCE;
            }
            obj2 = Result.constructor-impl(unit);
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.createFailure(th2));
        }
        Throwable th3 = Result.exceptionOrNull-impl(obj2);
        if (th3 != null) {
            TMLogger.INSTANCE.m222e(TAG, "拉取配置失败", th3);
        }
        Result.isFailure-impl(obj2);
        putBoolean(IS_UPDATE_CONFIG_SUCCESSFULLY, true);
        updateInitConfigCalled = true;
    }

    public final void putDefaultBoolean(String key, boolean value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        defaultValues.put(key, Boolean.valueOf(value));
    }

    public final void putDefaultInt(String key, int value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        defaultValues.put(key, Integer.valueOf(value));
    }

    public final void putDefaultString(String key, String value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(value, "value");
        defaultValues.put(key, value);
    }

    public final void putDefaultFloat(String key, float value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        defaultValues.put(key, Float.valueOf(value));
    }

    public final void putString(String key, String value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(value, "value");
        TMCacheService.INSTANCE.putString(key, value);
    }

    public final void putInt(String key, int value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        TMCacheService.INSTANCE.putInt(key, value);
    }

    public final void putBoolean(String key, boolean value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        TMCacheService.INSTANCE.putBoolean(key, value);
    }

    public final void putLong(String key, long value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        TMCacheService.INSTANCE.putLong(key, value);
    }

    public final void putFloat(String key, float value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        TMCacheService.INSTANCE.putFloat(key, value);
    }

    public final int getInt(String key, int defaultValue) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        preInvokeReadValueFunction();
        Object obj = defaultValues.get(key);
        if (!(obj instanceof Integer)) {
            obj = null;
        }
        Integer num = (Integer) obj;
        if (num != null) {
            defaultValue = num.intValue();
        }
        return TMCacheService.INSTANCE.getInt(key, defaultValue);
    }

    public final String getString(String key, String defaultValue) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        preInvokeReadValueFunction();
        Object obj = defaultValues.get(key);
        if (!(obj instanceof String)) {
            obj = null;
        }
        String str = (String) obj;
        if (str != null) {
            defaultValue = str;
        }
        return TMCacheService.INSTANCE.getString(key, defaultValue);
    }

    public final boolean getBoolean(String key, boolean defaultValue) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        preInvokeReadValueFunction();
        Object obj = defaultValues.get(key);
        if (!(obj instanceof Boolean)) {
            obj = null;
        }
        Boolean bool = (Boolean) obj;
        if (bool != null) {
            defaultValue = bool.booleanValue();
        }
        return TMCacheService.INSTANCE.getBoolean(key, defaultValue);
    }

    public final long getLong(String key, long defaultValue) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        preInvokeReadValueFunction();
        Object obj = defaultValues.get(key);
        if (!(obj instanceof Long)) {
            obj = null;
        }
        Long l = (Long) obj;
        if (l != null) {
            defaultValue = l.longValue();
        }
        return TMCacheService.INSTANCE.getLong(key, defaultValue);
    }

    public final float getFloat(String key, float defaultValue) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        preInvokeReadValueFunction();
        Object obj = defaultValues.get(key);
        if (!(obj instanceof Float)) {
            obj = null;
        }
        Float f = (Float) obj;
        if (f != null) {
            defaultValue = f.floatValue();
        }
        return TMCacheService.INSTANCE.getFloat(key, defaultValue);
    }

    private final void preInvokeReadValueFunction() {
        if (!updateInitConfigCalled) {
            updateInitConfigCalled = TMCacheService.INSTANCE.getBoolean(IS_UPDATE_CONFIG_SUCCESSFULLY, false);
        }
        if (updateInitConfigCalled) {
            return;
        }
        updateInitConfig();
    }
}
