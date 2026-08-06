package com.bytedance.applog.monitor.v3;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class MonitorConfigManager {
    public static final String KEY_EVENT_SENTRY_STAINED = "event_stained";
    public static final String KEY_OPTIONS_SENTRY_STAINED = "sentry_stained";
    public static final int MAX_SAMPLING_RATE = 10000;
    private static final String SP_KEY_COLD_START_REPORT_DELAY = "coldstart_report_delay_ms";
    private static final String SP_KEY_DATA_KEEP_ALIVE_DAYS = "data_keep_alive_days";
    public static final String SP_KEY_DATA_UPTIME = "uptime";
    private static final String SP_KEY_ENABLED = "enabled";
    private static final String SP_KEY_ERROR_REPORTABLE = "error_report_enable";
    private static final String SP_KEY_INTERVAL = "report_interval_ms";
    private static final String SP_KEY_MAX_REQ_COUNT = "max_request_count";
    private static final String SP_KEY_REQ_MAX_BODY_SIZE = "max_request_body_size_kb";
    private static final String SP_KEY_SENTRY_COLD_START_SAMPLING_RATE = "sentry_coldstart_sampling_rate";
    private static final String SP_KEY_SENTRY_ENABLED = "sentry_enabled";
    private static final String SP_KEY_SENTRY_EVENTS = "sentry_events";
    public static volatile long defaultColdStartReportDelay = 30000;
    public static volatile int defaultDataAliveDays = 7;
    public static volatile boolean defaultEnabled = true;
    public static volatile boolean defaultErrorReportEnabled = true;
    public static volatile int defaultMaxRequestBodySizeKb = 1024;
    public static volatile int defaultMaxRequestCountPerInterval = 10;
    public static volatile long defaultReportInterval = 300000;
    public static volatile int defaultSentryColdStartSamplingRate;
    public static volatile boolean defaultSentryEnabled;
    public static volatile Map<String, Integer> defaultSentryEventMap;
    private SharedPreferences sp;
    private boolean enabled = defaultEnabled;
    private int maxRequestBodySize = defaultMaxRequestBodySizeKb * 1024;
    private int maxRequestCount = defaultMaxRequestCountPerInterval;
    private boolean errorReportEnabled = defaultErrorReportEnabled;
    private long reportInterval = defaultReportInterval;
    private long coldStartReportDelay = defaultColdStartReportDelay;
    private int dataAliveDays = defaultDataAliveDays;
    private boolean sentryEnabled = defaultSentryEnabled;
    private int sentryColdStartSamplingRate = defaultSentryColdStartSamplingRate;
    private Map<String, Integer> sentryEventMap = defaultSentryEventMap;
    private JSONObject configJson = null;
    private volatile boolean isDebug = false;

    public void setDebug(boolean z) {
        if (!z) {
            this.isDebug = false;
            return;
        }
        this.isDebug = true;
        defaultEnabled = true;
        defaultSentryEnabled = true;
        defaultSentryColdStartSamplingRate = 10000;
        defaultSentryEventMap = null;
        this.enabled = defaultEnabled;
        this.sentryEnabled = defaultSentryEnabled;
        this.sentryColdStartSamplingRate = defaultSentryColdStartSamplingRate;
        this.sentryEventMap = defaultSentryEventMap;
    }

    public void init(Context context, String str) {
        if (context == null) {
            return;
        }
        this.sp = context.getSharedPreferences(str + "@applog_monitor_config", 0);
        loadConfigFromSp();
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public int getMaxRequestBodySize() {
        return this.maxRequestBodySize;
    }

    public int getMaxRequestCount() {
        return this.maxRequestCount;
    }

    public boolean isErrorReportEnabled() {
        return this.errorReportEnabled;
    }

    public long getReportInterval() {
        return this.reportInterval;
    }

    public long getColdStartReportDelay() {
        return this.coldStartReportDelay;
    }

    public int getDataAliveDays() {
        return this.dataAliveDays;
    }

    public boolean isSentryEnabled() {
        return this.sentryEnabled;
    }

    public int getSentryColdStartSamplingRate() {
        return this.sentryColdStartSamplingRate;
    }

    public boolean isDebugMode() {
        return this.isDebug;
    }

    public Map<String, Integer> getSentryEventMap() {
        return this.sentryEventMap;
    }

    public boolean isSentryEnabledForEventName(String str) {
        return this.sentryEventMap.containsKey(str);
    }

    public void setConfig(JSONObject jSONObject) {
        SharedPreferences.Editor editor;
        if (jSONObject == null) {
            return;
        }
        SharedPreferences sharedPreferences = this.sp;
        if (sharedPreferences != null) {
            editor = sharedPreferences.edit();
        } else {
            this.configJson = jSONObject;
            editor = null;
        }
        boolean z = jSONObject.optInt(SP_KEY_ENABLED, defaultEnabled ? 1 : 0) == 1;
        this.enabled = z;
        if (editor != null) {
            editor.putBoolean(SP_KEY_ENABLED, z);
        }
        if (jSONObject.has(SP_KEY_REQ_MAX_BODY_SIZE)) {
            int optInt = jSONObject.optInt(SP_KEY_REQ_MAX_BODY_SIZE, defaultMaxRequestBodySizeKb) * 1024;
            this.maxRequestBodySize = optInt;
            if (editor != null) {
                editor.putInt(SP_KEY_REQ_MAX_BODY_SIZE, optInt);
            }
        }
        if (jSONObject.has(SP_KEY_MAX_REQ_COUNT)) {
            int optInt2 = jSONObject.optInt(SP_KEY_MAX_REQ_COUNT, defaultMaxRequestCountPerInterval);
            this.maxRequestCount = optInt2;
            if (editor != null) {
                editor.putInt(SP_KEY_MAX_REQ_COUNT, optInt2);
            }
        }
        if (jSONObject.has(SP_KEY_ERROR_REPORTABLE)) {
            boolean z2 = jSONObject.optInt(SP_KEY_ERROR_REPORTABLE, defaultErrorReportEnabled ? 1 : 0) == 1;
            this.errorReportEnabled = z2;
            if (editor != null) {
                editor.putBoolean(SP_KEY_ERROR_REPORTABLE, z2);
            }
        }
        if (jSONObject.has(SP_KEY_INTERVAL)) {
            long optLong = jSONObject.optLong(SP_KEY_INTERVAL, defaultReportInterval);
            this.reportInterval = optLong;
            if (editor != null) {
                editor.putLong(SP_KEY_INTERVAL, optLong);
            }
        }
        if (jSONObject.has(SP_KEY_COLD_START_REPORT_DELAY)) {
            long optLong2 = jSONObject.optLong(SP_KEY_COLD_START_REPORT_DELAY, defaultColdStartReportDelay);
            this.coldStartReportDelay = optLong2;
            if (editor != null) {
                editor.putLong(SP_KEY_COLD_START_REPORT_DELAY, optLong2);
            }
        }
        if (jSONObject.has(SP_KEY_DATA_KEEP_ALIVE_DAYS)) {
            int optInt3 = jSONObject.optInt(SP_KEY_DATA_KEEP_ALIVE_DAYS, defaultDataAliveDays);
            this.dataAliveDays = optInt3;
            if (editor != null) {
                editor.putLong(SP_KEY_DATA_KEEP_ALIVE_DAYS, optInt3);
            }
        }
        if (jSONObject.has(SP_KEY_SENTRY_ENABLED)) {
            boolean z3 = jSONObject.optInt(SP_KEY_SENTRY_ENABLED, defaultSentryEnabled ? 1 : 0) == 1;
            this.sentryEnabled = z3;
            if (editor != null) {
                editor.putBoolean(SP_KEY_SENTRY_ENABLED, z3);
            }
        }
        if (jSONObject.has(SP_KEY_SENTRY_COLD_START_SAMPLING_RATE)) {
            int optInt4 = jSONObject.optInt(SP_KEY_SENTRY_COLD_START_SAMPLING_RATE, defaultSentryColdStartSamplingRate);
            this.sentryColdStartSamplingRate = optInt4;
            if (editor != null) {
                editor.putInt(SP_KEY_SENTRY_COLD_START_SAMPLING_RATE, optInt4);
            }
        }
        if (jSONObject.has(SP_KEY_SENTRY_EVENTS)) {
            JSONObject optJSONObject = jSONObject.optJSONObject(SP_KEY_SENTRY_EVENTS);
            parseSentryEventMap(optJSONObject);
            if (editor != null) {
                editor.putString(SP_KEY_SENTRY_EVENTS, optJSONObject.toString());
            }
        }
        if (editor != null) {
            editor.apply();
        }
        if (this.isDebug) {
            setDebug(true);
        }
    }

    private void loadConfigFromSp() {
        JSONObject jSONObject = this.configJson;
        if (jSONObject != null && this.sp != null) {
            setConfig(jSONObject);
            return;
        }
        if (!this.sp.contains(SP_KEY_ENABLED)) {
            this.enabled = defaultEnabled;
            this.maxRequestBodySize = defaultMaxRequestBodySizeKb * 1024;
            this.maxRequestCount = defaultMaxRequestCountPerInterval;
            this.errorReportEnabled = defaultErrorReportEnabled;
            this.reportInterval = defaultReportInterval;
            this.coldStartReportDelay = defaultColdStartReportDelay;
            this.dataAliveDays = defaultDataAliveDays;
            this.sentryEnabled = defaultSentryEnabled;
            this.sentryColdStartSamplingRate = defaultSentryColdStartSamplingRate;
            this.sentryEventMap = defaultSentryEventMap;
        } else {
            this.enabled = this.sp.getBoolean(SP_KEY_ENABLED, defaultEnabled);
            this.maxRequestBodySize = this.sp.getInt(SP_KEY_REQ_MAX_BODY_SIZE, defaultMaxRequestBodySizeKb * 1024);
            this.maxRequestCount = this.sp.getInt(SP_KEY_MAX_REQ_COUNT, defaultMaxRequestCountPerInterval);
            this.errorReportEnabled = this.sp.getBoolean(SP_KEY_ERROR_REPORTABLE, defaultErrorReportEnabled);
            this.reportInterval = this.sp.getLong(SP_KEY_INTERVAL, defaultReportInterval);
            this.coldStartReportDelay = this.sp.getLong(SP_KEY_COLD_START_REPORT_DELAY, defaultColdStartReportDelay);
            this.dataAliveDays = this.sp.getInt(SP_KEY_DATA_KEEP_ALIVE_DAYS, defaultDataAliveDays);
            this.sentryEnabled = this.sp.getBoolean(SP_KEY_SENTRY_ENABLED, defaultSentryEnabled);
            this.sentryColdStartSamplingRate = this.sp.getInt(SP_KEY_SENTRY_COLD_START_SAMPLING_RATE, defaultSentryColdStartSamplingRate);
            String string = this.sp.getString(SP_KEY_SENTRY_EVENTS, null);
            if (!TextUtils.isEmpty(string)) {
                try {
                    parseSentryEventMap(new JSONObject(string));
                } catch (Throwable unused) {
                }
            }
        }
        if (this.isDebug) {
            setDebug(true);
        }
    }

    private void parseSentryEventMap(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.sentryEventMap.clear();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            int optInt = jSONObject.optInt(next, 0);
            if (optInt > 0 && optInt <= 10000) {
                this.sentryEventMap.put(next, Integer.valueOf(optInt));
            }
        }
    }
}
