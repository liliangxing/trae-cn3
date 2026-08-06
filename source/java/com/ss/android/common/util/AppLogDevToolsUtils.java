package com.ss.android.common.util;

import android.text.TextUtils;
import com.bytedance.applog.log.EventBus;
import com.bytedance.applog.log.LogUtils;
import com.bytedance.applog.util.JsonUtils;
import com.bytedance.common.utility.StringUtils;
import com.optimize.statistics.FrescoMonitorConst;
import com.ss.android.common.applog.AppLog;
import com.ss.android.common.applog.LogEvent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AppLogDevToolsUtils {
    private static final String KEY_LOCAL_EVENT_ID = "$$EVENT_LOCAL_ID";

    public static String getEventType(String str) {
        return "event_v3".equalsIgnoreCase(str) ? "EVENT_V3" : str;
    }

    public static void sendSaveDbEvent(final String str, final LogEvent logEvent) {
        if (LogUtils.isDisabled()) {
            return;
        }
        final long eventId = getEventId(logEvent);
        if (eventId <= 0) {
            return;
        }
        LogUtils.sendJsonFetcher("event_save_db", new EventBus.DataFetcher() { // from class: com.ss.android.common.util.AppLogDevToolsUtils.1
            public Object fetch() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("$$APP_ID", String.valueOf(AppLog.getAppId()));
                    jSONObject.put("$$EVENT_TYPE", str);
                    jSONObject.put(AppLogDevToolsUtils.KEY_LOCAL_EVENT_ID, eventId);
                    if (logEvent.user_id > 0) {
                        jSONObject.put("user_id", logEvent.user_id);
                    }
                    if (logEvent.user_is_login > 0) {
                        jSONObject.put(AppLog.KEY_USER_IS_LOGIN, logEvent.user_is_login);
                    }
                    if (logEvent.user_type > 0) {
                        jSONObject.put(AppLog.KEY_USER_TYPE, logEvent.user_type);
                    }
                    if (logEvent.user_is_auth > 0) {
                        jSONObject.put(AppLog.KEY_USER_IS_AUTH, logEvent.user_is_auth);
                    }
                    if (logEvent.uid > 0) {
                        jSONObject.put(AppLog.KEY_UID, logEvent.uid);
                    }
                    if (!TextUtils.isEmpty(AppLog.getUserUniqueId())) {
                        jSONObject.put(AppLog.KEY_USER_UNIQUE_ID, AppLog.getUserUniqueId());
                    }
                    jSONObject.put("event", logEvent.tag);
                    JSONObject jSONObject2 = null;
                    if (!StringUtils.isEmpty(logEvent.ext_json)) {
                        try {
                            JSONObject jSONObject3 = new JSONObject(logEvent.ext_json);
                            try {
                                jSONObject3.remove("_event_v3");
                            } catch (Exception unused) {
                            }
                            jSONObject2 = jSONObject3;
                        } catch (Exception unused2) {
                        }
                    }
                    if (jSONObject2 == null) {
                        jSONObject2 = new JSONObject();
                    }
                    if ("EVENT_V3".equals(str)) {
                        jSONObject.put("params", jSONObject2);
                    } else {
                        JsonUtils.mergeJsonObject(jSONObject2, jSONObject);
                    }
                    jSONObject.put(AppLog.KEY_EVENT_ID, logEvent.f36id);
                    jSONObject.put(AppLog.KEY_EVENT_INDEX, logEvent.teaEventIndex);
                    jSONObject.put(AppLog.KEY_LOCAL_TIME_MS, logEvent.timestamp);
                    jSONObject.put(AppLog.KEY_SESSION_ID, logEvent.session_id);
                    jSONObject.put(AppLog.KEY_DATETIME, AppLog.formatDate(logEvent.timestamp));
                } catch (JSONException unused3) {
                }
                return jSONObject;
            }
        });
    }

    public static void sendSaveDbMiscEvent(final String str, final JSONObject jSONObject) {
        if (LogUtils.isDisabled()) {
            return;
        }
        final long optLong = jSONObject.optLong(AppLog.KEY_EVENT_ID, 0L);
        if (optLong <= 0) {
            return;
        }
        LogUtils.sendJsonFetcher("event_save_db", new EventBus.DataFetcher() { // from class: com.ss.android.common.util.AppLogDevToolsUtils.2
            public Object fetch() {
                JSONObject jSONObject2 = new JSONObject();
                JsonUtils.mergeJsonObject(jSONObject, jSONObject2);
                try {
                    jSONObject2.put("$$APP_ID", String.valueOf(AppLog.getAppId()));
                    jSONObject2.put("$$EVENT_TYPE", "LOG_DATA");
                    jSONObject2.put(AppLogDevToolsUtils.KEY_LOCAL_EVENT_ID, optLong);
                    jSONObject2.put(FrescoMonitorConst.LOG_TYPE, str);
                } catch (JSONException unused) {
                }
                return jSONObject2;
            }
        });
    }

    public static void sendReceiveMiscEvent(final String str, final JSONObject jSONObject) {
        if (LogUtils.isDisabled()) {
            return;
        }
        final long optLong = jSONObject.optLong(AppLog.KEY_EVENT_ID, 0L);
        if (optLong <= 0) {
            return;
        }
        LogUtils.sendJsonFetcher("event_receive", new EventBus.DataFetcher() { // from class: com.ss.android.common.util.AppLogDevToolsUtils.3
            public Object fetch() {
                JSONObject jSONObject2 = new JSONObject();
                JsonUtils.mergeJsonObject(jSONObject, jSONObject2);
                try {
                    jSONObject2.put("$$APP_ID", String.valueOf(AppLog.getAppId()));
                    jSONObject2.put("$$EVENT_TYPE", "LOG_DATA");
                    jSONObject2.put(AppLogDevToolsUtils.KEY_LOCAL_EVENT_ID, String.valueOf(optLong));
                    jSONObject2.put(FrescoMonitorConst.LOG_TYPE, str);
                } catch (JSONException unused) {
                }
                return jSONObject2;
            }
        });
    }

    public static void sendReceiveEvent(final String str, final LogEvent logEvent) {
        if (LogUtils.isDisabled()) {
            return;
        }
        final long eventId = getEventId(logEvent);
        if (eventId <= 0) {
            return;
        }
        LogUtils.sendJsonFetcher("event_receive", new EventBus.DataFetcher() { // from class: com.ss.android.common.util.AppLogDevToolsUtils.4
            public Object fetch() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("$$APP_ID", String.valueOf(AppLog.getAppId()));
                    jSONObject.put("$$EVENT_TYPE", str);
                    jSONObject.put(AppLogDevToolsUtils.KEY_LOCAL_EVENT_ID, eventId);
                    if (logEvent.user_id > 0) {
                        jSONObject.put("user_id", logEvent.user_id);
                    }
                    if (logEvent.user_is_login > 0) {
                        jSONObject.put(AppLog.KEY_USER_IS_LOGIN, logEvent.user_is_login);
                    }
                    if (logEvent.user_type > 0) {
                        jSONObject.put(AppLog.KEY_USER_TYPE, logEvent.user_type);
                    }
                    if (logEvent.user_is_auth > 0) {
                        jSONObject.put(AppLog.KEY_USER_IS_AUTH, logEvent.user_is_auth);
                    }
                    if (logEvent.uid > 0) {
                        jSONObject.put(AppLog.KEY_UID, logEvent.uid);
                    }
                    if (!TextUtils.isEmpty(AppLog.getUserUniqueId())) {
                        jSONObject.put(AppLog.KEY_USER_UNIQUE_ID, AppLog.getUserUniqueId());
                    }
                    jSONObject.put("event", logEvent.tag);
                    JSONObject jSONObject2 = null;
                    if (!StringUtils.isEmpty(logEvent.ext_json)) {
                        try {
                            JSONObject jSONObject3 = new JSONObject(logEvent.ext_json);
                            try {
                                jSONObject3.remove("_event_v3");
                            } catch (Exception unused) {
                            }
                            jSONObject2 = jSONObject3;
                        } catch (Exception unused2) {
                        }
                    }
                    if (jSONObject2 == null) {
                        jSONObject2 = new JSONObject();
                    }
                    if ("EVENT_V3".equals(str)) {
                        jSONObject.put("params", jSONObject2);
                    } else {
                        JsonUtils.mergeJsonObject(jSONObject2, jSONObject);
                    }
                    jSONObject.put(AppLog.KEY_EVENT_ID, logEvent.f36id);
                    jSONObject.put(AppLog.KEY_EVENT_INDEX, logEvent.teaEventIndex);
                    jSONObject.put(AppLog.KEY_LOCAL_TIME_MS, logEvent.timestamp);
                    jSONObject.put(AppLog.KEY_SESSION_ID, logEvent.session_id);
                    jSONObject.put(AppLog.KEY_DATETIME, AppLog.formatDate(logEvent.timestamp));
                } catch (JSONException unused3) {
                }
                return jSONObject;
            }
        });
    }

    public static void sendReceiveTerminate(final JSONObject jSONObject) {
        if (LogUtils.isDisabled() || jSONObject == null) {
            return;
        }
        final long optLong = jSONObject.optLong(AppLog.KEY_EVENT_ID, 0L);
        if (optLong <= 0) {
            return;
        }
        LogUtils.sendJsonFetcher("event_receive", new EventBus.DataFetcher() { // from class: com.ss.android.common.util.AppLogDevToolsUtils.5
            public Object fetch() {
                JSONObject jSONObject2 = new JSONObject();
                JsonUtils.mergeJsonObject(jSONObject, jSONObject2);
                try {
                    jSONObject2.put("$$APP_ID", String.valueOf(AppLog.getAppId()));
                    jSONObject2.put("$$EVENT_TYPE", "TERMINATE");
                    jSONObject2.put(AppLogDevToolsUtils.KEY_LOCAL_EVENT_ID, optLong);
                } catch (JSONException unused) {
                }
                return jSONObject2;
            }
        });
    }

    public static void sendReceiveLaunch(final JSONObject jSONObject) {
        if (LogUtils.isDisabled() || jSONObject == null) {
            return;
        }
        final long optLong = jSONObject.optLong(AppLog.KEY_EVENT_ID, 0L);
        if (optLong <= 0) {
            return;
        }
        LogUtils.sendJsonFetcher("event_receive", new EventBus.DataFetcher() { // from class: com.ss.android.common.util.AppLogDevToolsUtils.6
            public Object fetch() {
                JSONObject jSONObject2 = new JSONObject();
                JsonUtils.mergeJsonObject(jSONObject, jSONObject2);
                try {
                    jSONObject2.put("$$APP_ID", String.valueOf(AppLog.getAppId()));
                    jSONObject2.put("$$EVENT_TYPE", "LAUNCH");
                    jSONObject2.put(AppLogDevToolsUtils.KEY_LOCAL_EVENT_ID, optLong);
                } catch (JSONException unused) {
                }
                return jSONObject2;
            }
        });
    }

    public static void sendRealtimeEvent(LogEvent logEvent) {
        if (LogUtils.isDisabled()) {
            return;
        }
        final long eventId = getEventId(logEvent);
        if (eventId <= 0) {
            return;
        }
        LogUtils.sendJsonFetcher("event_realtime_eid", new EventBus.DataFetcher() { // from class: com.ss.android.common.util.AppLogDevToolsUtils.7
            public Object fetch() {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                try {
                    jSONArray.put(eventId);
                    jSONObject.put("$$APP_ID", String.valueOf(AppLog.getAppId()));
                    jSONObject.put("$$EVENT_LOCAL_ID_ARRAY", jSONArray);
                } catch (JSONException unused) {
                }
                return jSONObject;
            }
        });
    }

    public static void sendReportedEvent(LogEvent logEvent, final boolean z) {
        if (LogUtils.isDisabled()) {
            return;
        }
        final long eventId = getEventId(logEvent);
        if (eventId <= 0) {
            return;
        }
        LogUtils.sendJsonFetcher("event_upload_eid", new EventBus.DataFetcher() { // from class: com.ss.android.common.util.AppLogDevToolsUtils.8
            public Object fetch() {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                try {
                    jSONArray.put(eventId);
                    jSONObject.put("$$APP_ID", String.valueOf(AppLog.getAppId()));
                    jSONObject.put("$$EVENT_LOCAL_ID_ARRAY", jSONArray);
                    jSONObject.put("$$UPLOAD_STATUS", z ? "success" : "failed");
                } catch (JSONException unused) {
                }
                return jSONObject;
            }
        });
    }

    public static void sendReportedEvent(JSONObject jSONObject, final boolean z) {
        if (LogUtils.isDisabled()) {
            return;
        }
        final JSONArray jSONArray = new JSONArray();
        appendPackEventId(jSONObject, "launch", jSONArray);
        appendPackEventId(jSONObject, "terminate", jSONArray);
        appendPackEventId(jSONObject, "log_data", jSONArray);
        appendPackEventId(jSONObject, "event", jSONArray);
        appendPackEventId(jSONObject, "event_v3", jSONArray);
        if (jSONArray.length() == 0) {
            return;
        }
        LogUtils.sendJsonFetcher("event_upload_eid", new EventBus.DataFetcher() { // from class: com.ss.android.common.util.AppLogDevToolsUtils.9
            public Object fetch() {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("$$APP_ID", String.valueOf(AppLog.getAppId()));
                    jSONObject2.put("$$EVENT_LOCAL_ID_ARRAY", jSONArray);
                    jSONObject2.put("$$UPLOAD_STATUS", z ? "success" : "failed");
                } catch (JSONException unused) {
                }
                return jSONObject2;
            }
        });
    }

    private static void appendPackEventId(JSONObject jSONObject, String str, JSONArray jSONArray) {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                long optLong = optJSONObject.optLong(AppLog.KEY_EVENT_ID, 0L);
                if (optLong > 0) {
                    jSONArray.put(optLong);
                }
            }
        }
    }

    private static long getEventId(LogEvent logEvent) {
        if (logEvent == null || logEvent.f36id <= 0) {
            return 0L;
        }
        return logEvent.f36id;
    }
}
