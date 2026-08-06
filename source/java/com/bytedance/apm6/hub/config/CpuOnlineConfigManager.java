package com.bytedance.apm6.hub.config;

import com.bytedance.apm6.cpu.Constants;
import com.bytedance.apm6.cpu.collect.CpuCollectManager;
import com.bytedance.apm6.cpu.config.CpuConfig;
import com.bytedance.apm6.cpu.config.CpuConfigService;
import com.bytedance.apm6.cpu.config.CpuExceptionConfig;
import com.bytedance.apm6.cpu.exception.CpuExceptionManager;
import com.bytedance.apm6.hub.config.internal.ConfigManager;
import com.bytedance.apm6.hub.config.internal.IConfigChangeListener;
import com.bytedance.apm6.perf.base.BasePerfConfigParser;
import com.bytedance.apm6.util.log.Logger;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class CpuOnlineConfigManager implements CpuConfigService {
    private static final String BASE_CPU_KEY = "cpu";
    private static final String KEY_BACK_COLLECT_INTERVAL = "back_collect_interval";
    private static final String KEY_BACK_THREAD_COLLECT_INTERVAL = "back_thread_collect_interval";
    private static final String KEY_COLLECT_ALL_PROCESS = "exception_collect_all_process";
    private static final String KEY_ENABLE_ALL_PROCESS = "enable_collect_all_process";
    private static final String KEY_ENABLE_UPLOAD = "enable_upload";
    private static final String KEY_EXCEPTION_BACK_MAX_SPEED_SCENE = "exception_back_max_speed_scene";
    private static final String KEY_EXCEPTION_FORE_MAX_SPEED_SCENE = "exception_fore_max_speed_scene";
    private static final String KEY_EXCEPTION_NATIVE_THREAD_ENABLED = "exception_native_thread_enabled";
    private static final String KEY_EXCEPTION_SWITCH = "exception_switch";
    private static final String KEY_EXCEPTION_THREAD_MAX_USAGE = "exception_thread_max_usage";
    private static final String KEY_EXCEPTION_THREAD_MAX_USAGE_MAP = "exception_thread_max_usage_map";
    private static final String KEY_EXCEPTION_THREAD_STACK_ENABLED = "exception_thread_stack_enabled";
    private static final String KEY_FRONT_COLLECT_INTERVAL = "front_collect_interval";
    private static final String KEY_FRONT_THREAD_COLLECT_INTERVAL = "front_thread_collect_interval";
    private static final String KEY_MAIN_THREAD_COLLECT_ENABLED = "main_thread_collect_enabled";
    private static final String KEY_MONITOR_INTERVAL = "monitor_interval";
    private static final String KEY_PROCESS_BACK_MAX_SPEED = "exception_process_back_max_speed";
    private static final String KEY_PROCESS_DETECT_INTERVAL = "process_detect_interval";
    private static final String KEY_PROCESS_FORE_MAX_SPEED = "exception_process_fore_max_speed";
    private static final String KEY_THREAD_DETECT_INTERVAL = "thread_detect_interval";
    private CpuConfig mConfig;
    private CpuExceptionConfig mExceptionConfig;

    public CpuOnlineConfigManager() {
        ConfigManager.getInstance().init();
        ConfigManager.getInstance().registerConfigListener(new IConfigChangeListener() { // from class: com.bytedance.apm6.hub.config.CpuOnlineConfigManager.1
            @Override // com.bytedance.apm6.hub.config.internal.IConfigChangeListener
            public void onConfigChanged(JSONObject jSONObject, boolean z) {
                CpuOnlineConfigManager.this.parseConfig(jSONObject, z);
            }
        });
    }

    @Override // com.bytedance.apm6.cpu.config.CpuConfigService
    public CpuConfig getConfig() {
        return this.mConfig;
    }

    @Override // com.bytedance.apm6.cpu.config.CpuConfigService
    public CpuExceptionConfig getExceptionConfig() {
        return this.mExceptionConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parseConfig(JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return;
        }
        JSONObject parseData = BasePerfConfigParser.parseData(jSONObject, "cpu");
        if (parseData != null) {
            this.mConfig = new CpuConfig();
            this.mConfig.setEnableUpload(parseData.optInt("enable_upload", 0) == 1);
            this.mConfig.setCollectAllProcess(parseData.optInt(KEY_ENABLE_ALL_PROCESS, 0) == 1);
            long optLong = parseData.optLong(KEY_FRONT_COLLECT_INTERVAL, 0L);
            if (optLong > 0) {
                this.mConfig.setFrontCollectInterval(optLong);
            }
            long optLong2 = parseData.optLong(KEY_BACK_COLLECT_INTERVAL, 0L);
            if (optLong2 > 0) {
                this.mConfig.setBackCollectInterval(optLong2);
            }
            long optLong3 = parseData.optLong("monitor_interval", 0L);
            if (optLong3 > 0) {
                this.mConfig.setMonitorInterval(optLong3);
            }
            long optLong4 = parseData.optLong(KEY_FRONT_THREAD_COLLECT_INTERVAL, 0L);
            if (optLong4 > 0) {
                this.mConfig.setFrontThreadCollectInterval(optLong4);
            }
            long optLong5 = parseData.optLong(KEY_BACK_THREAD_COLLECT_INTERVAL, 0L);
            if (optLong5 > 0) {
                this.mConfig.setBackThreadCollectInterval(optLong5);
            }
            this.mExceptionConfig = new CpuExceptionConfig();
            this.mExceptionConfig.setOpen(parseData.optInt(KEY_EXCEPTION_SWITCH, 0) == 1);
            double optDouble = parseData.optDouble(KEY_PROCESS_BACK_MAX_SPEED, 0.0d);
            if (optDouble > 0.0d) {
                this.mExceptionConfig.setMaxProcessBackCpuSpeed(optDouble);
            }
            double optDouble2 = parseData.optDouble(KEY_PROCESS_FORE_MAX_SPEED, 0.0d);
            if (optDouble2 > 0.0d) {
                this.mExceptionConfig.setMaxProcessForeCpuSpeed(optDouble2);
            }
            this.mExceptionConfig.setCollectMainThread(parseData.optInt("main_thread_collect_enabled", 0) == 1);
            this.mExceptionConfig.setCollectAllProcess(parseData.optInt(KEY_COLLECT_ALL_PROCESS, 0) == 1);
            this.mExceptionConfig.setCollectThreadStack(parseData.optInt(KEY_EXCEPTION_THREAD_STACK_ENABLED, 1) == 1);
            double optDouble3 = parseData.optDouble(KEY_EXCEPTION_THREAD_MAX_USAGE, 0.0d);
            if (optDouble3 > 0.0d) {
                this.mExceptionConfig.setMaxThreadCpuRate(optDouble3);
            }
            JSONObject optJSONObject = parseData.optJSONObject(KEY_EXCEPTION_THREAD_MAX_USAGE_MAP);
            HashMap hashMap = new HashMap();
            if (optJSONObject != null) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    double optDouble4 = optJSONObject.optDouble(next, 0.0d);
                    if (optDouble4 > 0.0d) {
                        hashMap.put(next, Double.valueOf(optDouble4));
                    }
                }
            }
            this.mExceptionConfig.setMaxThreadCpuRateMap(hashMap);
            this.mExceptionConfig.setProcessDetectInterval(parseData.optInt(KEY_PROCESS_DETECT_INTERVAL, 30));
            this.mExceptionConfig.setThreadDetectInterval(parseData.optInt(KEY_THREAD_DETECT_INTERVAL, 30));
            JSONObject optJSONObject2 = parseData.optJSONObject(KEY_EXCEPTION_FORE_MAX_SPEED_SCENE);
            HashMap hashMap2 = new HashMap();
            if (optJSONObject2 != null) {
                Iterator<String> keys2 = optJSONObject2.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    double optDouble5 = optJSONObject2.optDouble(next2, 0.0d);
                    if (optDouble5 > 0.0d) {
                        hashMap2.put(next2, Double.valueOf(optDouble5));
                    }
                }
            }
            this.mExceptionConfig.setForeSceneMaxSpeedMap(hashMap2);
            JSONObject optJSONObject3 = parseData.optJSONObject(KEY_EXCEPTION_BACK_MAX_SPEED_SCENE);
            HashMap hashMap3 = new HashMap();
            if (optJSONObject3 != null) {
                Iterator<String> keys3 = optJSONObject3.keys();
                while (keys3.hasNext()) {
                    String next3 = keys3.next();
                    double optDouble6 = optJSONObject3.optDouble(next3, 0.0d);
                    if (optDouble6 > 0.0d) {
                        hashMap3.put(next3, Double.valueOf(optDouble6));
                    }
                }
            }
            this.mExceptionConfig.setBackSceneMaxSpeedMap(hashMap3);
            this.mExceptionConfig.setCollectNativeThread(parseData.optBoolean(KEY_EXCEPTION_NATIVE_THREAD_ENABLED, false));
        }
        Logger.m119d(Constants.TAG, getConfig() + " " + getExceptionConfig());
        CpuCollectManager.getInstance().updateConfig(getConfig());
        CpuExceptionManager.getInstance().updateConfig(getExceptionConfig());
    }
}
