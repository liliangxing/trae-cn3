package com.bytedance.crash.event;

import android.os.Process;
import android.text.TextUtils;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Global;
import com.bytedance.crash.TagService;
import com.bytedance.crash.UserDataCenter;
import com.bytedance.crash.config.NetConfig;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.monitor.EventMonitor;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.upload.CrashUploader;
import com.bytedance.crash.upload.UploadLimits;
import com.bytedance.crash.upload.UploaderUrl;
import com.bytedance.crash.util.App;
import com.bytedance.crash.util.Digest;
import com.bytedance.crash.util.NpthLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class EnsureDeliverer implements Runnable {
    private static final int DELAY_CHECK = 30000;
    public static final String ENSURE_NOT_REACH_HERE = "EnsureNotReachHere";
    private static final String TAG = "CustomException";
    private static int maxCacheCount = 100;
    private static int maxQueueLimitSize = 30;
    private static boolean sIsDropData;
    private static boolean sIsStopUpload;
    private EnsureConfig config;
    private EventMonitor monitor;
    private static CopyOnWriteArrayList<EnsureDeliverer> sEnsureList = new CopyOnWriteArrayList<>();
    private static HashSet<String> list = new HashSet<>();
    private final ConcurrentLinkedQueue<EnsureReportData> queue = new ConcurrentLinkedQueue<>();
    private final ConcurrentLinkedQueue<EnsureReportData> cache = new ConcurrentLinkedQueue<>();

    public EnsureDeliverer(EventMonitor eventMonitor) {
        this.monitor = eventMonitor;
        sEnsureList.add(this);
    }

    public static void clean() {
        try {
            Iterator<EnsureDeliverer> it = sEnsureList.iterator();
            while (it.hasNext()) {
                EnsureDeliverer next = it.next();
                next.queue.clear();
                next.cache.clear();
            }
        } catch (Throwable unused) {
        }
    }

    public static void setMaxCacheCount(int i) {
        if (i > 0) {
            maxCacheCount = i;
        }
    }

    public static void setQueueLimitSize(int i) {
        if (i <= 0) {
            sIsStopUpload = true;
        } else {
            maxQueueLimitSize = i;
        }
    }

    public static void addWhiteLogType(String str) {
        list.add(str);
    }

    public void setMonitor(EventMonitor eventMonitor) {
        this.monitor = eventMonitor;
    }

    public boolean isEnsureEnable() {
        EnsureConfig ensureConfig = this.config;
        if (ensureConfig == null) {
            return false;
        }
        return ensureConfig.isUploadEnable();
    }

    public void reportMessage(int i) {
        if (isDropException("core_exception_monitor", null)) {
            return;
        }
        Thread currentThread = Thread.currentThread();
        reportReportData(new EnsureReportData(null, currentThread.getStackTrace(), i, null, true, null, currentThread.getName(), ENSURE_NOT_REACH_HERE, "core_exception_monitor", "exception"));
    }

    public void reportMessage(String str, int i) {
        if (isDropException("core_exception_monitor", str)) {
            NpthLog.m234i(TAG, "reportMessage：isDrop:" + str);
        } else {
            Thread currentThread = Thread.currentThread();
            reportReportData(new EnsureReportData(null, currentThread.getStackTrace(), i, str, true, null, currentThread.getName(), ENSURE_NOT_REACH_HERE, "core_exception_monitor", "exception"));
        }
    }

    public void reportMessage(String str, Map<String, String> map, int i) {
        if (isDropException("core_exception_monitor", str)) {
            NpthLog.m234i(TAG, "reportMessage：isDrop:" + str);
        } else {
            Thread currentThread = Thread.currentThread();
            reportReportData(new EnsureReportData(null, currentThread.getStackTrace(), i, str, true, map, currentThread.getName(), ENSURE_NOT_REACH_HERE, "core_exception_monitor", "exception"));
        }
    }

    public void reportThrowable(Throwable th) {
        if (isDropException("core_exception_monitor", null)) {
            NpthLog.m234i(TAG, "reportThrowable：isDrop:");
        } else {
            reportThrowable(null, null, th, "core_exception_monitor");
        }
    }

    public void reportThrowable(Throwable th, String str) {
        reportThrowable(str, null, th, "core_exception_monitor");
    }

    public void reportThrowable(Throwable th, String str, boolean z) {
        reportJavaEnsure(th, null, str, null, Thread.currentThread().getName(), ENSURE_NOT_REACH_HERE, "core_exception_monitor", z);
    }

    public void reportThrowable(Throwable th, String str, Map<String, String> map) {
        reportThrowable(str, map, th, "core_exception_monitor");
    }

    public void reportThrowable(Throwable th, String str, String str2) {
        reportThrowable(str, null, th, str2);
    }

    public void reportThrowable(String str, Map<String, String> map, Throwable th, String str2) {
        reportJavaEnsure(th, null, str, map, Thread.currentThread().getName(), ENSURE_NOT_REACH_HERE, str2, true);
    }

    public void reportJavaEnsure(Throwable th, StackTraceElement[] stackTraceElementArr, String str, Map<String, String> map, String str2, String str3, String str4, boolean z) {
        String str5 = TextUtils.isEmpty(str4) ? "core_exception_monitor" : str4;
        NpthLog.m228d(TAG, "reportJavaEnsure:message:" + str + " " + App.getProcessName());
        if (isDropException(str5, str)) {
            NpthLog.m234i(TAG, "reportJavaEnsure：isDrop:" + str5 + " " + str);
        } else {
            reportReportData(new EnsureReportData(th, stackTraceElementArr, 0, str, z, map, str2, str3, str5, "exception"));
        }
    }

    public void reportJavaEnsure(JSONObject jSONObject, String str, String str2) {
        String optString = jSONObject.optString("message");
        if (TextUtils.isEmpty(str2)) {
            str2 = "core_exception_monitor";
        }
        String str3 = str2;
        if (isDropException(str3, optString)) {
            NpthLog.m234i(TAG, "reportJavaEnsure：isDrop:" + str3 + " " + optString);
        } else {
            reportReportData(new EnsureReportData(str3, str, null, jSONObject, "exception"));
        }
    }

    public void reportNativeEnsure(JSONObject jSONObject, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            str3 = "core_exception_monitor";
        }
        String str4 = str3;
        String optString = jSONObject.optString("message");
        if (isDropException(str4, optString)) {
            NpthLog.m234i(TAG, "reportNativeEnsure：isDrop:" + str4 + " " + optString);
        } else {
            reportReportData(new EnsureReportData(str4, str2, str, jSONObject, "native_exception"));
        }
    }

    public void reportNativeEnsure(String str, String str2, String str3, String str4, Map<String, String> map, String str5) {
        if (TextUtils.isEmpty(str5)) {
            str5 = "core_exception_monitor";
        }
        String str6 = str5;
        if (isDropException(str6, str4)) {
            NpthLog.m234i(TAG, "reportNativeEnsure：isDrop:" + str6 + " " + str4);
        } else {
            reportReportData(new EnsureReportData(str2, str, str4, map, str3, str6, "native_exception", Process.myPid()));
        }
    }

    public void updateConfig(EnsureConfig ensureConfig) {
        if (ensureConfig == null) {
            return;
        }
        NpthLog.m234i(TAG, "updateConfig :" + this.monitor.getAppId() + " :" + ensureConfig);
        this.config = ensureConfig;
        DefaultWorkThread.removeCallbacks(this);
        DefaultWorkThread.post(new Runnable() { // from class: com.bytedance.crash.event.EnsureDeliverer.1
            @Override // java.lang.Runnable
            public void run() {
                EnsureDeliverer.this.processCache();
            }
        });
        DefaultWorkThread.postDelayed(this, 30000L);
    }

    public boolean isCanReport(EnsureReportData ensureReportData) {
        if (this.config == null) {
            NpthLog.m234i(TAG, "isCanReport:config = null and event type" + ensureReportData.getLogType());
            return false;
        }
        if (isStopUpload(ensureReportData.getLogType())) {
            NpthLog.m234i(TAG, "the log_type = " + ensureReportData.getLogType() + " and message = " + ensureReportData.getMessage() + "is discard because the stop upload");
            return false;
        }
        if (!this.config.isSample(ensureReportData.getLogType(), ensureReportData.getMessage())) {
            NpthLog.m234i(TAG, "the log_type = " + ensureReportData.getLogType() + " and message = " + ensureReportData.getMessage() + "is discard because the config" + this.config.isSample(ensureReportData.getLogType()) + " " + this.config.isMessageSample(ensureReportData.getMessage()));
            return false;
        }
        String md5 = TextUtils.isEmpty(ensureReportData.getMessage()) ? null : Digest.getMD5(ensureReportData.getMessage());
        String stackMD5 = ensureReportData.getStackMD5();
        boolean checkEnsureLimit = UploadLimits.get().checkEnsureLimit(md5, stackMD5);
        NpthLog.m234i(TAG, "the message " + ensureReportData.getMessage() + "  is exceed limit:" + checkEnsureLimit);
        if (checkEnsureLimit) {
            return false;
        }
        UploadLimits.get().updateEnsureUploadTimes(stackMD5, md5);
        return true;
    }

    private void reportReportData(final EnsureReportData ensureReportData) {
        if (this.config == null) {
            if (this.cache.size() >= maxCacheCount) {
                return;
            }
            NpthLog.m229e(TAG, "cache:" + ensureReportData);
            this.cache.add(ensureReportData);
            return;
        }
        DefaultWorkThread.post(new Runnable() { // from class: com.bytedance.crash.event.EnsureDeliverer.2
            @Override // java.lang.Runnable
            public void run() {
                if (EnsureDeliverer.this.isCanReport(ensureReportData)) {
                    EnsureDeliverer.this.queue.add(ensureReportData);
                }
                EnsureDeliverer.this.processCache();
            }
        });
    }

    private void cacheToQueue() {
        while (!this.cache.isEmpty()) {
            EnsureReportData poll = this.cache.poll();
            if (isCanReport(poll)) {
                this.queue.add(poll);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processCache() {
        cacheToQueue();
        if (this.queue.size() >= maxQueueLimitSize) {
            upload();
        }
    }

    private void upload() {
        Map<String, String> map;
        if (this.queue.isEmpty()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (UserDataCenter.isIgnoreExceptionTag()) {
                map = null;
            } else {
                map = this.monitor.getUserDataCenter().getCustomTags();
                Map<String, String> importTagMap = TagService.getImportTagMap();
                if (importTagMap != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.putAll(map);
                    hashMap.putAll(importTagMap);
                    map = hashMap;
                }
            }
            for (int i = 0; !this.queue.isEmpty() && i <= maxQueueLimitSize; i++) {
                EnsureReportData poll = this.queue.poll();
                NpthLog.m234i(TAG, "upload:message:" + poll.getMessage() + " log_type:" + poll.getLogType());
                jSONArray.put(poll.toJsonObject(this.monitor, map));
            }
            jSONObject.put("data", jSONArray);
            JSONObject json = Header.createEventHeader(this.monitor, System.currentTimeMillis(), CrashType.ENSURE, Process.myPid()).getJson();
            jSONObject.put("header", json);
            if (sIsDropData) {
                return;
            }
            String appendUrlParamsByHeader = UploaderUrl.appendUrlParamsByHeader(NetConfig.getExceptionUploadUrl(), json);
            NpthLog.m234i(TAG, "isSuccess:" + CrashUploader.uploadEvent(appendUrlParamsByHeader, jSONObject) + "  upload:" + appendUrlParamsByHeader);
            UploadLimits.get().writeUploadTimesFile();
        } catch (Exception unused) {
        }
    }

    public static void setDropData(boolean z) {
        sIsDropData = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        NpthLog.m228d(TAG, "run:" + App.getCurProcessName(Global.getContext()) + " " + this.monitor.getAppId());
        cacheToQueue();
        upload();
        DefaultWorkThread.postDelayed(this, 30000L);
    }

    private boolean isDropException(String str, String str2) {
        if (isStopUpload(str)) {
            NpthLog.m234i(TAG, "isStopUpload：the logType = " + str + " message:" + str2);
            return true;
        }
        if (this.config == null && this.cache.size() >= maxCacheCount) {
            NpthLog.m234i(TAG, "the logType = " + str + "is discarded the cache exceed 100");
            return true;
        }
        if (maxQueueLimitSize <= 0) {
            return true;
        }
        if (UploadLimits.isInited() && UploadLimits.get().checkEnsureAllLimit()) {
            NpthLog.m234i(TAG, "the logType = " + str + "is discarded beacuse the report is exceed 100");
            return true;
        }
        if (this.config == null && this.cache.size() >= maxCacheCount) {
            NpthLog.m234i(TAG, "the logType = " + str + "is discarded the cache exceed 100");
            return true;
        }
        if (this.config == null) {
            return false;
        }
        NpthLog.m234i(TAG, "the logType = " + str + "message = " + str2 + " isSample = " + this.config.isSample(str, str2));
        return !this.config.isSample(str, str2);
    }

    public static boolean isStopUpload(String str) {
        if (sIsStopUpload) {
            return !list.contains(str);
        }
        return false;
    }
}
