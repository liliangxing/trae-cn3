package com.bytedance.apm6.hub.config;

import com.bytedance.apm6.frequency.FrequencyMonitor;
import com.bytedance.apm6.frequency.FrequencyMonitorConfig;
import com.bytedance.apm6.frequency.FrequencyMonitorConfigService;
import com.bytedance.apm6.hub.config.internal.ConfigManager;
import com.bytedance.apm6.hub.config.internal.IConfigChangeListener;
import com.bytedance.apm6.perf.base.BasePerfConfigParser;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class FrequencyConfigManager implements FrequencyMonitorConfigService {
    private static final String BASE_FREQUENCY_KEY = "frequency";
    private static final String KEY_BACKGROUND_EXCEPTION_CHECK_INTERVAL = "background_exception_check_interval";
    private static final String KEY_BACKGROUND_EXCEPTION_THRESHOLD_PER_MIN = "background_exception_threshold_per_min";
    private static final String KEY_BACKGROUND_REPORT_THRESHOLD_PER_MIN = "background_report_threshold_per_min";
    private static final String KEY_ENABLE_EXCEPTION_MONITOR = "enable_exception_monitor";
    private static final String KEY_ENABLE_FREQUENCY_MONITOR = "enable_frequency_monitor";
    private static final String KEY_EVENT_SAMPLING_RATE = "event_sampling_rate";
    private static final String KEY_EXCEPTION_REPORT_TOP_COUNT = "exception_report_top_count";
    private static final String KEY_FRONT_EXCEPTION_CHECK_INTERVAL = "front_exception_check_interval";
    private static final String KEY_FRONT_EXCEPTION_THRESHOLD_PER_MIN = "front_exception_threshold_per_min";
    private static final String KEY_FRONT_REPORT_THRESHOLD_PER_MIN = "front_report_threshold_per_min";
    private static final String KEY_REPORT_INTERVAL = "report_interval";
    private FrequencyMonitorConfig mConfig;

    public FrequencyConfigManager() {
        ConfigManager.getInstance().init();
        ConfigManager.getInstance().registerConfigListener(new IConfigChangeListener() { // from class: com.bytedance.apm6.hub.config.FrequencyConfigManager.1
            @Override // com.bytedance.apm6.hub.config.internal.IConfigChangeListener
            public void onConfigChanged(JSONObject jSONObject, boolean z) {
                FrequencyConfigManager.this.parseConfig(jSONObject, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parseConfig(JSONObject jSONObject, boolean z) {
        JSONObject parseData;
        HashMap<String, Float> hashMap;
        HashMap<String, Float> hashMap2;
        HashMap<String, Float> hashMap3;
        int i;
        HashMap<String, Float> hashMap4;
        HashMap<String, Float> hashMap5;
        HashMap<String, Float> hashMap6;
        if (jSONObject == null || (parseData = BasePerfConfigParser.parseData(jSONObject, BASE_FREQUENCY_KEY)) == null) {
            return;
        }
        boolean z2 = parseData.optInt(KEY_ENABLE_FREQUENCY_MONITOR, 0) == 1;
        boolean z3 = parseData.optInt(KEY_ENABLE_EXCEPTION_MONITOR, 0) == 1;
        int optInt = parseData.optInt(KEY_FRONT_EXCEPTION_CHECK_INTERVAL, 0);
        int optInt2 = parseData.optInt(KEY_BACKGROUND_EXCEPTION_CHECK_INTERVAL, 0);
        JSONObject optJSONObject = parseData.optJSONObject(KEY_FRONT_EXCEPTION_THRESHOLD_PER_MIN);
        if (optJSONObject != null) {
            hashMap = new HashMap<>();
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, Float.valueOf((float) optJSONObject.optDouble(next, 0.0d)));
            }
        } else {
            hashMap = null;
        }
        JSONObject optJSONObject2 = parseData.optJSONObject(KEY_BACKGROUND_EXCEPTION_THRESHOLD_PER_MIN);
        if (optJSONObject2 != null) {
            hashMap2 = new HashMap<>();
            Iterator<String> keys2 = optJSONObject2.keys();
            while (keys2.hasNext()) {
                String next2 = keys2.next();
                hashMap2.put(next2, Float.valueOf((float) optJSONObject2.optDouble(next2, 0.0d)));
            }
        } else {
            hashMap2 = null;
        }
        int optInt3 = parseData.optInt(KEY_EXCEPTION_REPORT_TOP_COUNT, 0);
        int optInt4 = parseData.optInt(KEY_REPORT_INTERVAL, 0);
        int optInt5 = parseData.optInt(KEY_EVENT_SAMPLING_RATE, 10000);
        JSONObject optJSONObject3 = parseData.optJSONObject(KEY_FRONT_REPORT_THRESHOLD_PER_MIN);
        if (optJSONObject3 != null) {
            hashMap4 = new HashMap<>();
            Iterator<String> keys3 = optJSONObject3.keys();
            while (keys3.hasNext()) {
                String next3 = keys3.next();
                hashMap4.put(next3, Float.valueOf((float) optJSONObject3.optDouble(next3, 0.0d)));
                optInt5 = optInt5;
                hashMap2 = hashMap2;
            }
            hashMap3 = hashMap2;
            i = optInt5;
        } else {
            hashMap3 = hashMap2;
            i = optInt5;
            hashMap4 = null;
        }
        JSONObject optJSONObject4 = parseData.optJSONObject(KEY_BACKGROUND_REPORT_THRESHOLD_PER_MIN);
        if (optJSONObject4 != null) {
            hashMap6 = new HashMap<>();
            Iterator<String> keys4 = optJSONObject4.keys();
            while (keys4.hasNext()) {
                String next4 = keys4.next();
                hashMap6.put(next4, Float.valueOf((float) optJSONObject4.optDouble(next4, 0.0d)));
                hashMap4 = hashMap4;
            }
            hashMap5 = hashMap4;
        } else {
            hashMap5 = hashMap4;
            hashMap6 = null;
        }
        this.mConfig = new FrequencyMonitorConfig.Builder().enableFrequencyMonitor(z2).enableExceptionMonitor(z3).frontExceptionCheckInterval(optInt).backgroundExceptionCheckInterval(optInt2).frontExceptionThresholdPerMin(hashMap).backgroundExceptionThresholdPerMin(hashMap3).exceptionReportTopCount(optInt3).reportInterval(optInt4).eventSamplingRate(i).frontReportThreshold(hashMap5).backgroundReportThreshold(hashMap6).build();
        FrequencyMonitor.getInstance().updateConfig(getConfig());
    }

    @Override // com.bytedance.apm6.frequency.FrequencyMonitorConfigService
    public FrequencyMonitorConfig getConfig() {
        return this.mConfig;
    }
}
