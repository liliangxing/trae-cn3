package com.bytedance.crash.entity;

import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.bytedance.crash.dumper.BytestConfig;
import com.bytedance.crash.event.EnsureDeliverer;
import com.bytedance.crash.runtime.assembly.ActivityDataManager;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.crash.util.App;
import com.bytedance.crash.util.Digest;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class EventBody extends CrashBody {
    public static final String BLOCK_INTERVAL = "caton_interval";
    private static final String CLASS_REF = "class_ref";
    private static final String ENSURE_TYPE = "ensure_type";
    private static final String EVENT_TYPE = "event_type";
    private static final String EXCEPTION = "exception";
    private static final String EXCEPTION_TYPE = "exception_type";
    private static final String IS_CORE = "is_core";
    public static final String KEY_CATEGORY = "category";
    public static final String KEY_METRIC = "metric";
    public static final String KEY_SERVICE = "service";
    public static final String KEY_START_ID = "sid";
    public static final String KEY_STATUS = "status";
    public static final String KEY_VALUE = "value";
    private static final String LAG = "lag";
    private static final String LINE_NUM = "line_num";
    public static final String LOG_TYPE = "log_type";
    public static final String LOG_TYPE_SERVICE_MONITOR = "service_monitor";
    public static final String MESSAGE = "message";
    private static final String METHOD = "method";
    private static final String NATIVE_EXCEPTION = "native_exception";
    public static final String STACK = "stack";
    public static final String TIMESTAMP = "timestamp";
    private static final String TYPE_BLOCK_MONITOR = "caton_monitor";
    public static final String TYPE_ENSURE_MONITOR = "core_exception_monitor";

    public boolean isEvent() {
        return false;
    }

    private EventBody(String str) {
    }

    public static EventBody wrapEnsure(StackTraceElement stackTraceElement, String str, String str2, String str3, boolean z, String str4) {
        EventBody eventBody = new EventBody("core_exception_monitor");
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        int lineNumber = stackTraceElement.getLineNumber();
        eventBody.put("event_type", "exception");
        eventBody.put("log_type", "core_exception_monitor");
        eventBody.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        eventBody.put("crash_time", Long.valueOf(System.currentTimeMillis()));
        eventBody.put("class_ref", className);
        eventBody.put("method", methodName);
        eventBody.put("line_num", Integer.valueOf(lineNumber));
        eventBody.put("stack", str);
        eventBody.put("exception_type", 1);
        eventBody.put("ensure_type", str4);
        eventBody.put(IS_CORE, Integer.valueOf(z ? 1 : 0));
        eventBody.put("message", str2);
        eventBody.put("process_name", App.getProcessName());
        eventBody.put(CrashBody.CRASH_THREAD_NAME, str3);
        JSONObject optJSONObject = eventBody.getJson().optJSONObject("filters");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
            try {
                eventBody.getJson().put("filters", optJSONObject);
            } catch (JSONException unused) {
            }
        }
        BytestConfig.expandFilters(optJSONObject);
        return eventBody;
    }

    public static EventBody wrapNativeEnsure(String str, String str2, String str3, String str4, String str5) {
        EventBody wrapEnsure = wrapEnsure(new StackTraceElement("Native", "Native", "Native.java", -1), str2, str3, str4, true, EnsureDeliverer.ENSURE_NOT_REACH_HERE, str5);
        wrapEnsure.put("event_type", NATIVE_EXCEPTION);
        wrapEnsure.put("java_data", str);
        return wrapEnsure;
    }

    public CrashBody setActivityTrace(ActivityDataManager activityDataManager) {
        put(ActivityLifecycle.ACTIVITY_TRACE, activityDataManager.getActivityTrace());
        addCustomLong(ActivityLifecycle.ACTIVITY_TRACK, activityDataManager.getActivityLife());
        return this;
    }

    public static EventBody wrapEnsure(StackTraceElement stackTraceElement, String str, String str2, String str3, boolean z, String str4, String str5) {
        EventBody eventBody = new EventBody(str5);
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        int lineNumber = stackTraceElement.getLineNumber();
        eventBody.put("event_type", "exception");
        eventBody.put("log_type", str5);
        eventBody.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        eventBody.put("crash_time", Long.valueOf(System.currentTimeMillis()));
        eventBody.put("class_ref", className);
        eventBody.put("method", methodName);
        eventBody.put("line_num", Integer.valueOf(lineNumber));
        eventBody.put("stack", str);
        eventBody.put("crash_md5", Digest.getMD5(str));
        eventBody.put("exception_type", 1);
        eventBody.put("ensure_type", str4);
        eventBody.put(IS_CORE, Integer.valueOf(z ? 1 : 0));
        eventBody.put("message", str2);
        eventBody.put("process_name", App.getProcessName());
        eventBody.put(CrashBody.CRASH_THREAD_NAME, str3);
        JSONObject optJSONObject = eventBody.getJson().optJSONObject("filters");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
            try {
                eventBody.getJson().put("filters", optJSONObject);
            } catch (JSONException unused) {
            }
        }
        BytestConfig.expandFilters(optJSONObject);
        return eventBody;
    }

    public static EventBody wrapBlock(String str) {
        EventBody eventBody = new EventBody("caton_monitor");
        eventBody.put("event_type", "lag");
        eventBody.put("log_type", "caton_monitor");
        eventBody.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        eventBody.put("crash_time", Long.valueOf(System.currentTimeMillis()));
        eventBody.put("process_name", App.getProcessName());
        eventBody.put(CrashBody.CRASH_THREAD_NAME, PullConfiguration.PROCESS_NAME_MAIN);
        eventBody.put("stack", str);
        return eventBody;
    }

    public JSONObject getDataJson() {
        Object opt = getJson().opt("data");
        if (opt instanceof JSONArray) {
            return ((JSONArray) opt).optJSONObject(0);
        }
        return getJson();
    }
}
