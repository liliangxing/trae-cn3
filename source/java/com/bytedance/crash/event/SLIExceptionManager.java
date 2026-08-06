package com.bytedance.crash.event;

import android.os.Process;
import android.text.TextUtils;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.config.NetConfig;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.AppMonitorConfigService;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.upload.CrashUploader;
import com.bytedance.crash.upload.UploaderUrl;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.NpthLog;
import com.bytedance.crash.util.Stack;
import java.io.File;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class SLIExceptionManager {
    private static String TAG = "SLIExceptionManager";
    private static SLIExceptionManager sInstance = new SLIExceptionManager();
    private String mSceneInfo;

    public static SLIExceptionManager getInstance() {
        return sInstance;
    }

    public void reportException(Throwable th, String str, String str2, boolean z, Map<String, String> map, String str3, String str4, File file) {
        String currentJavaStack;
        try {
            String str5 = TextUtils.isEmpty(str4) ? "core_exception_monitor" : str4;
            if (!AppMonitorConfigService.enable_SLI_exception()) {
                NpthLog.m233i("exception has been discard due to not sampled: " + str5);
                return;
            }
            this.mSceneInfo = str2;
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace[0] == null) {
                return;
            }
            if (th != null) {
                currentJavaStack = Stack.getExceptionStack(th);
            } else {
                currentJavaStack = getCurrentJavaStack(stackTrace, 0);
            }
            String str6 = currentJavaStack;
            if (TextUtils.isEmpty(str6)) {
                return;
            }
            upload(new EnsureReportData(str6, str3, str, map, Thread.currentThread().getName(), "1", "native_exception", Process.myPid()), file);
        } catch (Throwable th2) {
            NpthLog.m239w(th2);
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

    private boolean upload(EnsureReportData ensureReportData, File file) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            int myPid = Process.myPid();
            AppMonitor appMonitor = MonitorManager.getAppMonitor();
            JSONObject json = Header.createEventHeader(appMonitor, currentTimeMillis, CrashType.NATIVE_CUSTOMIZE, myPid).getJson();
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(ensureReportData.toJsonObject(appMonitor));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("data", jSONArray);
            jSONObject.put("header", json);
            if (this.mSceneInfo != null && AppMonitorConfigService.enable_scene_exception()) {
                jSONObject.put("app_scene_info", this.mSceneInfo);
            }
            boolean uploadNativeExceptionLog = CrashUploader.uploadNativeExceptionLog(UploaderUrl.appendUrlParamsByHeader(NetConfig.getExceptionZipUploadUrl(), json), jSONObject.toString(), file);
            if (uploadNativeExceptionLog) {
                NpthLog.m227d(TAG + "upload success");
                FileUtils.deleteFile(file);
            }
            return uploadNativeExceptionLog;
        } catch (Exception unused) {
            return false;
        }
    }
}
