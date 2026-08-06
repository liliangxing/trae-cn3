package com.bytedance.crash.monitor;

import com.bytedance.crash.config.ConfigManager;
import com.bytedance.crash.config.IConfigChangeListener;
import com.bytedance.crash.event.EnsureConfig;
import com.bytedance.crash.event.EventConfig;
import com.bytedance.crash.util.NpthLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class EventConfigService implements IConfigChangeListener {
    private static final String BASE_KEY_ALLOW_LOG_TYPE = "allow_log_type";
    private static final String BASE_KEY_ALLOW_SERVICE_NAME = "allow_service_name";
    public static final String CUSTOM_EVENT_SETTINGS = "custom_event_settings";
    private static final String ENABLE_UPLOAD = "enable_upload";
    private static final String EXCEPTION = "exception";
    public static final String EXCEPTION_MODULE = "exception_modules";
    private static final String METRIC_SAMPLE = "metric_sampling";
    public static final String NPTH_SIMPLE_SETTING = "npth_simple_setting";
    private static final String TAG = "NPTH-Config";
    private final ConfigManager configManager;
    protected EnsureConfig ensureConfig;
    protected EventConfig eventConfig;
    protected EventMonitor monitor;

    public EventConfigService(EventMonitor eventMonitor) {
        this.monitor = eventMonitor;
        ConfigManager createConfigManager = createConfigManager();
        this.configManager = createConfigManager;
        createConfigManager.registerConfigListener(this);
    }

    protected ConfigManager createConfigManager() {
        return new ConfigManager(this.monitor);
    }

    public void init() {
        this.configManager.init();
    }

    public EventConfig getEventConfig() {
        return this.eventConfig;
    }

    public EnsureConfig getEnsureConfig() {
        return this.ensureConfig;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void parseEventConfig(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        HashSet hashSet = new HashSet();
        JSONObject optJSONObject = jSONObject.optJSONObject("custom_event_settings");
        JSONObject optJSONObject2 = optJSONObject != null ? optJSONObject.optJSONObject("allow_service_name") : null;
        if (optJSONObject2 != null) {
            Iterator<String> keys = optJSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (optJSONObject2.optInt(next) == 1) {
                    hashSet.add(next);
                }
            }
        }
        this.eventConfig = new EventConfig(hashSet);
    }

    private Set<String> parseAllowLogType(JSONObject jSONObject) {
        HashSet hashSet = new HashSet();
        JSONObject optJSONObject = jSONObject.optJSONObject("custom_event_settings");
        JSONObject optJSONObject2 = optJSONObject != null ? optJSONObject.optJSONObject("allow_log_type") : null;
        if (optJSONObject2 != null) {
            Iterator<String> keys = optJSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (optJSONObject2.optInt(next) == 1) {
                    hashSet.add(next);
                }
            }
        }
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void parseEnsureConfig(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null) {
            return;
        }
        Set<String> parseAllowLogType = parseAllowLogType(jSONObject);
        JSONObject jSONObject2 = new JSONObject();
        JSONObject optJSONObject2 = jSONObject.optJSONObject("exception_modules");
        if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("exception")) != null) {
            r2 = optJSONObject.optInt("enable_upload") == 1;
            jSONObject2 = optJSONObject.optJSONObject(METRIC_SAMPLE);
        }
        this.ensureConfig = new EnsureConfig(parseAllowLogType, jSONObject2, r2);
        NpthLog.m228d(TAG, "parseEnsureConfig:" + this.monitor.mAppId + " " + this.ensureConfig);
    }

    @Override // com.bytedance.crash.config.IConfigChangeListener
    public void onConfigChanged(JSONObject jSONObject) {
        NpthLog.m228d(TAG, "onConfigChanged:" + this.monitor.getAppId());
        if (jSONObject == null) {
            return;
        }
        parseEnsureConfig(jSONObject);
        parseEventConfig(jSONObject);
        this.monitor.getEnsureDeliver().updateConfig(getEnsureConfig());
        this.monitor.getEventDeliverer().updateConfig(getEventConfig());
    }
}
