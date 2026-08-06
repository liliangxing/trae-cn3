package com.bytedance.crash.event;

import android.os.Process;
import android.text.TextUtils;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Global;
import com.bytedance.crash.TagService;
import com.bytedance.crash.UserDataCenter;
import com.bytedance.crash.alog.AlogManager;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.dumper.SdkInfo;
import com.bytedance.crash.dumper.Storage;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.monitor.AppMonitorConfigService;
import com.bytedance.crash.monitor.EventMonitor;
import com.bytedance.crash.service.ICrashBodyExtensionDumper;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.crash.util.App;
import com.bytedance.crash.util.Digest;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.NativeTools;
import com.bytedance.crash.util.NpthLog;
import com.bytedance.crash.util.Stack;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class EnsureReportData {
    public static final String CLASS_REF = "class_ref";
    public static final String DEFAULT_ENSURE_LOG_TYPE = "core_exception_monitor";
    private static final int DEFAULT_MESSAGE_LIMIT = 30;
    private static final String DEFULT_NATIVE_STACK_HEADER = "Signal 111(NATIVE_EXCEPTION)\n";
    private static final String ENSURE_NOT_REACH_HERE = "EnsureNotReachHere";
    public static final String ENSURE_TYPE = "ensure_type";
    public static final String LINE_NUM = "line_num";
    public static final String METHOD = "method";
    public static final String STACK = "stack";
    private static int pid = Process.myPid();
    private Map<String, String> data;
    private long eventTime;
    private String eventType;
    private String exceptionType;
    private boolean isCore;
    private String javaStack;
    private String logType;
    private String md5;
    private String message;
    private String nativeStack;
    private int stackDepth;
    private String threadName;
    private Throwable throwable;
    private JSONObject totalData;
    private StackTraceElement[] traceElements;

    public EnsureReportData(Throwable th, StackTraceElement[] stackTraceElementArr, int i, String str, boolean z, Map<String, String> map, String str2, String str3, String str4, String str5) {
        this.throwable = th;
        this.traceElements = stackTraceElementArr;
        this.stackDepth = i;
        this.message = str;
        this.isCore = z;
        this.data = map;
        this.threadName = str2;
        this.exceptionType = str3;
        this.logType = str4;
        this.eventTime = System.currentTimeMillis();
        this.eventType = str5;
    }

    public EnsureReportData(String str, String str2, String str3, Map<String, String> map, String str4, String str5, String str6, int i) {
        this.javaStack = str;
        this.nativeStack = getPackedNativeStack(str2, str3);
        this.message = str3;
        this.threadName = str4;
        this.logType = str5;
        this.data = map;
        this.eventTime = System.currentTimeMillis();
        this.eventType = str6;
        pid = i;
    }

    public EnsureReportData(String str, String str2, String str3, JSONObject jSONObject, String str4) {
        this.totalData = jSONObject;
        this.logType = str;
        this.javaStack = str2;
        this.nativeStack = str3;
        this.eventType = str4;
        this.message = jSONObject.optString("message");
    }

    public String getLogType() {
        return this.logType;
    }

    public String getMessage() {
        return this.message;
    }

    public String getNativeStack() {
        return this.nativeStack;
    }

    public String getStackMD5() {
        String str = this.md5;
        if (str != null) {
            return str;
        }
        String str2 = this.nativeStack;
        if (str2 != null) {
            this.md5 = Digest.getMD5(str2);
        } else {
            this.md5 = Digest.getMD5(getJavaStack());
        }
        return this.md5;
    }

    public String getJavaStack() {
        String str = this.javaStack;
        if (str != null) {
            return str;
        }
        Throwable th = this.throwable;
        String exceptionStack = th != null ? Stack.getExceptionStack(th) : getCurrentJavaStack(this.traceElements, this.stackDepth);
        this.javaStack = exceptionStack;
        return exceptionStack;
    }

    public JSONObject toJsonObject(EventMonitor eventMonitor, Map<String, String> map) {
        JSONObject jSONObject = this.totalData;
        if (jSONObject != null) {
            try {
                if (!jSONObject.has("crash_md5")) {
                    this.totalData.put("crash_md5", getStackMD5());
                }
            } catch (Throwable unused) {
            }
            return this.totalData;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("event_type", this.eventType);
            jSONObject2.put("crash_time", this.eventTime);
            jSONObject2.put("log_type", TextUtils.isEmpty(this.logType) ? "core_exception_monitor" : this.logType);
            jSONObject2.put("timestamp", System.currentTimeMillis());
            jSONObject2.put("crash_md5", getStackMD5());
            jSONObject2.put("message", this.message);
            jSONObject2.put(CrashBody.CRASH_THREAD_NAME, this.threadName);
            jSONObject2.put("process_name", App.getProcessName());
            jSONObject2.put("app_start_time", Global.getAppStartTime());
            int i = 1;
            jSONObject2.put(ApmTrafficStats.KEY_EXCEPTION_TYPE, 1);
            jSONObject2.put("pid", pid);
            if (this.nativeStack != null) {
                jSONObject2.put(CLASS_REF, "Native");
                jSONObject2.put("method", "Native");
                jSONObject2.put("is_core", 1);
                jSONObject2.put(LINE_NUM, -1);
                jSONObject2.put(ENSURE_TYPE, "EnsureNotReachHere");
                jSONObject2.put(CrashBody.CRASH_LIB_UUID, NativeTools.get().getSoUUID(this.nativeStack));
                jSONObject2.put("stack", this.nativeStack);
                jSONObject2.put(Constants.HAS_DUMP, "true");
                String str = this.javaStack;
                if (str != null) {
                    jSONObject2.put("java_data", str);
                }
            } else {
                StackTraceElement[] stackTraceElementArr = this.traceElements;
                if (stackTraceElementArr == null) {
                    stackTraceElementArr = this.throwable.getStackTrace();
                }
                StackTraceElement stackTraceElement = stackTraceElementArr[this.stackDepth];
                jSONObject2.put(CLASS_REF, stackTraceElement.getClassName());
                jSONObject2.put("method", stackTraceElement.getMethodName());
                jSONObject2.put(LINE_NUM, stackTraceElement.getLineNumber());
                jSONObject2.put("stack", getJavaStack());
                if (!this.isCore) {
                    i = 0;
                }
                jSONObject2.put("is_core", i);
                if (!TextUtils.isEmpty(this.exceptionType)) {
                    jSONObject2.put(ENSURE_TYPE, this.exceptionType);
                }
            }
            String business = Global.getBusiness();
            if (business != null) {
                jSONObject2.put("business", business);
            }
            appendCustomData(jSONObject2, eventMonitor);
            appendFilters(jSONObject2, eventMonitor, map);
            SdkInfo.pushTo(jSONObject2);
            jSONObject2.put(Constants.IS_BACKGROUND, ActivityLifecycle.isBackground());
            ActivityLifecycle.loadActivityTrace(jSONObject2);
            ActivityLifecycle.loadActivityTrack(jSONObject2);
            appendExtension(jSONObject2, eventMonitor);
        } catch (Exception e) {
            NpthLog.m231e("EnsureReportData", (Throwable) e);
        }
        return jSONObject2;
    }

    public JSONObject toJsonObject(EventMonitor eventMonitor) {
        if (UserDataCenter.isIgnoreExceptionTag()) {
            return toJsonObject(eventMonitor, null);
        }
        Map<String, String> customTags = eventMonitor.getUserDataCenter().getCustomTags();
        Map<String, String> importTagMap = TagService.getImportTagMap();
        if (importTagMap != null) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(customTags);
            hashMap.putAll(importTagMap);
            customTags = hashMap;
        }
        return toJsonObject(eventMonitor, customTags);
    }

    protected void appendFilters(JSONObject jSONObject, EventMonitor eventMonitor, Map<String, String> map) {
        Map<String, String> map2;
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("storage_free_range", Storage.getInnerFreeSizeRange());
            jSONObject2.put("alog_inited", AlogManager.isInit());
            jSONObject.put("filters", jSONObject2);
            if (this.nativeStack != null) {
                jSONObject2.put(Constants.HAS_DUMP, "true");
            }
            if (eventMonitor == null) {
                return;
            }
            if (this.nativeStack != null && (map2 = this.data) != null) {
                for (Map.Entry<String, String> entry : map2.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey()) && entry.getValue() != null) {
                        jSONObject2.put(entry.getKey(), entry.getValue());
                    }
                }
            }
            if (map == null || map.size() <= 0) {
                return;
            }
            for (Map.Entry<String, String> entry2 : map.entrySet()) {
                if (!TextUtils.isEmpty(entry2.getKey()) && entry2.getValue() != null) {
                    jSONObject2.put(entry2.getKey(), entry2.getValue());
                }
            }
        } catch (Throwable th) {
            NpthLog.m231e("EnsureReportData", th);
        }
    }

    private void appendExtension(JSONObject jSONObject, EventMonitor eventMonitor) {
        try {
            ICrashBodyExtensionDumper bodyDumper = eventMonitor.getBodyDumper();
            if (bodyDumper != null) {
                JSONUtils.combineJson(jSONObject, bodyDumper.load(CrashType.ENSURE));
            }
        } catch (Throwable unused) {
        }
    }

    private void appendCustomData(JSONObject jSONObject, EventMonitor eventMonitor) {
        Map<String, String> attachUserDataToMap;
        try {
            if (AppMonitorConfigService.enableUserCustomData()) {
                JSONObject jSONObject2 = new JSONObject();
                Map<String, String> map = this.data;
                if (map != null) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        jSONObject2.put(entry.getKey(), entry.getValue());
                    }
                }
                if (eventMonitor != null && (attachUserDataToMap = eventMonitor.getUserDataCenter().getAttachUserDataToMap(CrashType.ENSURE)) != null) {
                    for (Map.Entry<String, String> entry2 : attachUserDataToMap.entrySet()) {
                        jSONObject2.put(entry2.getKey(), entry2.getValue());
                    }
                }
                if (JSONUtils.isEmpty(jSONObject2)) {
                    return;
                }
                jSONObject.put("custom", jSONObject2);
            }
        } catch (Throwable unused) {
        }
    }

    private String getCurrentJavaStack(StackTraceElement[] stackTraceElementArr, int i) {
        if (stackTraceElementArr == null || stackTraceElementArr.length <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        while (i < stackTraceElementArr.length) {
            Stack.getStackTraceElementInfo(stackTraceElementArr[i], sb);
            i++;
        }
        return sb.toString();
    }

    private static String getPackedNativeStack(String str, String str2) {
        if (str == null || str.startsWith("Signal")) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        try {
            if (str2 == null) {
                sb.append(DEFULT_NATIVE_STACK_HEADER);
            } else {
                sb.append("Signal 111(");
                if (str2.length() > 30) {
                    sb.append(str2.substring(0, 30));
                } else {
                    sb.append(str2);
                }
                sb.append(")\n");
            }
            sb.append(str);
        } catch (Throwable unused) {
        }
        return sb.toString();
    }

    public String toString() {
        return "EnsureReportData{throwable=" + this.throwable + ", traceElements=" + Arrays.toString(this.traceElements) + ", stackDepth=" + this.stackDepth + ", message='" + this.message + "', isCore=" + this.isCore + ", data=" + this.data + ", threadName='" + this.threadName + "', exceptionType='" + this.exceptionType + "', logType='" + this.logType + "', javaStack='" + this.javaStack + "', nativeStack='" + this.nativeStack + "', eventTime=" + this.eventTime + ", md5='" + this.md5 + "', totalData=" + this.totalData + '}';
    }
}
