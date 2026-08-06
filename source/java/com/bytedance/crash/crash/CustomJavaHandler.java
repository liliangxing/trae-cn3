package com.bytedance.crash.crash;

import android.os.Process;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Global;
import com.bytedance.crash.alog.AlogManager;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.dumper.Logcat;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.crash.dumper.SdkInfo;
import com.bytedance.crash.dumper.Storage;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.AppMonitorConfigService;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.crash.upload.CrashUploader;
import com.bytedance.crash.upload.UploaderUrl;
import com.bytedance.crash.util.App;
import com.bytedance.crash.util.Digest;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.NpthLog;
import com.bytedance.crash.util.Stack;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class CustomJavaHandler {
    private static final int MAX_COUNT = 3;
    private static final String TAG = "CustomJavaHandler";
    private static boolean sIsDropData;
    private volatile int mCount = 0;
    private File mRootDir;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CustomJavaHandler(File file) {
        this.mRootDir = file;
    }

    public void handleCustomException(final Thread thread, final Throwable th, final boolean z) {
        if (sIsDropData || MonitorManager.getAppMonitor() == null || this.mCount > 3) {
            return;
        }
        this.mCount++;
        DefaultWorkThread.post(new Runnable() { // from class: com.bytedance.crash.crash.CustomJavaHandler.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jsonObject = CustomJavaHandler.toJsonObject(th, thread);
                    Header createEventHeader = Header.createEventHeader(MonitorManager.getAppMonitor(), currentTimeMillis, CrashType.JAVA, Process.myPid());
                    if (z && CustomJavaHandler.this.mRootDir != null) {
                        File file = new File(FileSystemUtils.createDirectory(CustomJavaHandler.this.mRootDir, "custom_crash"), Process.myPid() + "_" + currentTimeMillis);
                        FileSystemUtils.createDirectory(file);
                        CustomJavaHandler.dumpLogcat(file, jsonObject);
                        FileUtils.deleteFile(file);
                    }
                    JSONUtils.put(jsonObject, "header", createEventHeader.getJson());
                    String urlByCrashTypeAndHeader = UploaderUrl.getUrlByCrashTypeAndHeader(CrashType.JAVA, createEventHeader.getJson());
                    CrashUploader.uploadCrashLogWithAttachment(CrashType.JAVA.toString(), urlByCrashTypeAndHeader, jsonObject.toString(), new ArrayList());
                    NpthLog.m236w(CustomJavaHandler.TAG, "upload:" + urlByCrashTypeAndHeader);
                } catch (Throwable unused) {
                }
            }
        });
    }

    public void handleCustomException(Thread thread, Throwable th) {
        handleCustomException(thread, th, false);
    }

    public static void setDropData(boolean z) {
        sIsDropData = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean dumpLogcat(File file, JSONObject jSONObject) {
        try {
            Logcat.npthDump(file, true);
            if (!Logcat.isLogcatExists(file)) {
                return false;
            }
            String readFile = FileUtils.readFile(new File(file, "logcat.txt"));
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(readFile);
            jSONObject.put(Constants.LOGCAT, jSONArray);
            if (readFile.isEmpty() || readFile.length() <= 10) {
                return false;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("filters");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
                jSONObject.put("filters", optJSONObject);
            }
            JSONUtils.put(optJSONObject, "has_logcat", "true");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static JSONObject toJsonObject(Throwable th, Thread thread) {
        StackTraceElement[] stackTrace;
        JSONObject jSONObject = new JSONObject();
        try {
            stackTrace = th.getStackTrace();
        } catch (Exception e) {
            NpthLog.m231e("EnsureReportData", (Throwable) e);
        }
        if (stackTrace.length == 0) {
            return jSONObject;
        }
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTrace) {
            Stack.getStackTraceElementInfo(stackTraceElement, sb);
        }
        String sb2 = sb.toString();
        JSONUtils.put(jSONObject, "data", sb2);
        jSONObject.put("crash_time", currentTimeMillis);
        jSONObject.put(CrashBody.CRASH_THREAD_NAME, thread.getName());
        jSONObject.put("crash_md5", Digest.getMD5(sb2));
        jSONObject.put("process_name", App.getProcessName());
        jSONObject.put("app_start_time", Global.getAppStartTime());
        jSONObject.put("pid", Process.myPid());
        jSONObject.put("isJava", 1);
        jSONObject.put("isOOM", false);
        String business = Global.getBusiness();
        if (business != null) {
            jSONObject.put("business", business);
        }
        appendCustomData(jSONObject);
        appendFilters(jSONObject);
        Scraps.pushTo(jSONObject);
        SdkInfo.pushTo(jSONObject);
        jSONObject.put(Constants.IS_BACKGROUND, ActivityLifecycle.isBackground());
        ActivityLifecycle.loadActivityTrace(jSONObject);
        ActivityLifecycle.loadActivityTrack(jSONObject);
        return jSONObject;
    }

    private static void appendCustomData(JSONObject jSONObject) {
        Map<String, String> attachUserDataToMap;
        try {
            if (AppMonitorConfigService.enableUserCustomData()) {
                AppMonitor appMonitor = MonitorManager.getAppMonitor();
                JSONObject jSONObject2 = new JSONObject();
                if (appMonitor != null && (attachUserDataToMap = appMonitor.getUserDataCenter().getAttachUserDataToMap(CrashType.JAVA)) != null) {
                    for (Map.Entry<String, String> entry : attachUserDataToMap.entrySet()) {
                        jSONObject2.put(entry.getKey(), entry.getValue());
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

    private static void appendFilters(JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("filters");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
                jSONObject.put("filters", optJSONObject);
            }
            optJSONObject.put(Constants.FROM_CUSTOM, "1");
            optJSONObject.put("storage_free_range", Storage.getInnerFreeSizeRange());
            optJSONObject.put("alog_inited", AlogManager.isInit());
        } catch (Throwable th) {
            NpthLog.m231e("EnsureReportData", th);
        }
    }
}
