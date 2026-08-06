package com.bytedance.crash.event;

import android.os.Process;
import android.text.TextUtils;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Global;
import com.bytedance.crash.config.NetConfig;
import com.bytedance.crash.config.RuntimeConfig;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.dumper.SdkInfo;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.crash.upload.CrashUploader;
import com.bytedance.crash.upload.UploaderUrl;
import com.bytedance.crash.util.App;
import com.bytedance.crash.util.Digest;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.NpthLog;
import com.bytedance.crash.util.Stack;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class BizExceptionManager implements Runnable {
    private static final int DELAY_CHECK = 30000;
    private static final int MAX_COUNT = 90;
    private static final int SINGLE_LOG_TYPE_MAX_COUNT = 10;
    private static String TAG = "BizExceptionManager";
    private static final int TRIGGER_UPLOAD_COUNT = 30;
    private static BizExceptionManager sInstance = new BizExceptionManager();
    private long configTimeStamp;
    private BizExceptionConfig mConfig;
    private final LinkedList<CacheException> mCacheExceptions = new LinkedList<>();
    private LinkedList<CacheException> mReportException = new LinkedList<>();
    private ConcurrentHashMap<String, Integer> mAlreadyUploadCounts = new ConcurrentHashMap<>();

    public static BizExceptionManager getInstance() {
        return sInstance;
    }

    public static boolean isSample(String str) {
        BizExceptionConfig bizExceptionConfig = sInstance.mConfig;
        return bizExceptionConfig != null && bizExceptionConfig.isEnable() && sInstance.mConfig.isSampled(str);
    }

    public static boolean isConfigValid() {
        return sInstance.mConfig != null;
    }

    public void setConfig(BizExceptionConfig bizExceptionConfig) {
        if (RuntimeConfig.isDebugMode()) {
            NpthLog.m234i(TAG, "setConfig:" + bizExceptionConfig);
        }
        if (bizExceptionConfig == null) {
            synchronized (this.mCacheExceptions) {
                this.mCacheExceptions.clear();
            }
            return;
        }
        this.configTimeStamp = System.currentTimeMillis();
        sInstance.mConfig = bizExceptionConfig;
        if (!this.mConfig.isEnable()) {
            synchronized (this.mCacheExceptions) {
                this.mCacheExceptions.clear();
            }
            synchronized (this.mReportException) {
                this.mReportException.clear();
            }
            DefaultWorkThread.removeCallbacks(this);
            return;
        }
        DefaultWorkThread.removeCallbacks(this);
        DefaultWorkThread.postDelayed(this, 30000L);
        processCache();
        upload();
    }

    public void reportException(String str, Throwable th, String str2, Map<String, String> map, Map<String, String> map2, boolean z) {
        if (!z) {
            Integer num = this.mAlreadyUploadCounts.get(str);
            if (num == null) {
                this.mAlreadyUploadCounts.put(str, 1);
            } else if (num.intValue() > 10) {
                return;
            } else {
                this.mAlreadyUploadCounts.put(str, Integer.valueOf(num.intValue() + 1));
            }
        }
        BizExceptionConfig bizExceptionConfig = this.mConfig;
        if (bizExceptionConfig == null) {
            synchronized (this.mCacheExceptions) {
                if (this.mCacheExceptions.size() >= 90) {
                    this.mCacheExceptions.removeFirst();
                }
                this.mCacheExceptions.add(new CacheException(str, th, str2, Thread.currentThread().getName(), map, map2));
            }
            if (RuntimeConfig.isDebugMode()) {
                NpthLog.m228d(TAG, "config is not fetch:logType:" + str + " message:" + str2);
                return;
            }
            return;
        }
        if (!bizExceptionConfig.isEnable()) {
            if (RuntimeConfig.isDebugMode()) {
                NpthLog.m228d(TAG, "enable_upload is not enable:" + str + " message:" + str2);
                return;
            }
            return;
        }
        if (!this.mConfig.isSampled(str)) {
            if (RuntimeConfig.isDebugMode()) {
                NpthLog.m228d(TAG, str + " message:" + str2 + " is not sample");
                return;
            }
            return;
        }
        if (RuntimeConfig.isDebugMode()) {
            NpthLog.m228d(TAG, str + " message:" + str2 + " is sample");
        }
        processCache();
        synchronized (this.mReportException) {
            this.mReportException.add(new CacheException(str, th, str2, Thread.currentThread().getName(), map, map2));
        }
        synchronized (this.mReportException) {
            if (this.mReportException.size() >= 30) {
                DefaultWorkThread.post(new Runnable() { // from class: com.bytedance.crash.event.BizExceptionManager.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BizExceptionManager.this.upload();
                    }
                });
            }
        }
    }

    private void processCache() {
        ArrayList arrayList;
        if (!this.mConfig.isEnable()) {
            synchronized (this.mCacheExceptions) {
                this.mCacheExceptions.clear();
            }
            synchronized (this.mReportException) {
                this.mReportException.clear();
            }
            return;
        }
        synchronized (this.mCacheExceptions) {
            if (this.mCacheExceptions.size() > 0) {
                arrayList = new ArrayList();
                Iterator<CacheException> it = this.mCacheExceptions.iterator();
                while (it.hasNext()) {
                    CacheException next = it.next();
                    if (this.mConfig.isSampled(next.logType)) {
                        if (RuntimeConfig.isDebugMode()) {
                            NpthLog.m228d(TAG, next.logType + " message:" + next.message + " is sample");
                        }
                        arrayList.add(next);
                    } else if (RuntimeConfig.isDebugMode()) {
                        NpthLog.m228d(TAG, next.logType + " message:" + next.message + " is not sample");
                    }
                }
                this.mCacheExceptions.clear();
            } else {
                arrayList = null;
            }
        }
        if (arrayList != null) {
            synchronized (this.mReportException) {
                this.mReportException.addAll(arrayList);
            }
        }
        if (RuntimeConfig.isDebugMode()) {
            NpthLog.m228d(TAG, "report exception size:" + this.mReportException.size());
        }
    }

    public void upload() {
        if (RuntimeConfig.isDebugMode()) {
            NpthLog.m228d(TAG, "upload");
        }
        synchronized (this.mReportException) {
            if (this.mReportException.isEmpty()) {
                return;
            }
            ArrayList<CacheException> arrayList = new ArrayList();
            int i = 0;
            while (!this.mReportException.isEmpty() && i <= 30) {
                i++;
                arrayList.add(this.mReportException.remove(0));
            }
            if (arrayList.size() == 0) {
                return;
            }
            Header createEventHeader = Header.createEventHeader(MonitorManager.getAppMonitor(), System.currentTimeMillis(), CrashType.ENSURE, Process.myPid());
            try {
                HashSet hashSet = RuntimeConfig.isDebugMode() ? new HashSet() : null;
                JSONArray jSONArray = new JSONArray();
                for (CacheException cacheException : arrayList) {
                    JSONObject jSONObject = cacheException.toJSONObject(createEventHeader);
                    if (hashSet != null) {
                        hashSet.add(cacheException.logType);
                    }
                    jSONArray.put(jSONObject);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("data", jSONArray);
                JSONObject json = createEventHeader.getJson();
                jSONObject2.put("header", json);
                if (RuntimeConfig.isDebugMode()) {
                    NpthLog.m228d(TAG, "start upload:" + hashSet);
                }
                String appendUrlParamsByHeader = UploaderUrl.appendUrlParamsByHeader(NetConfig.getBizExceptionUploadUrl(), json);
                boolean uploadEvent = CrashUploader.uploadEvent(appendUrlParamsByHeader, jSONObject2);
                if (RuntimeConfig.isDebugMode()) {
                    NpthLog.m228d(TAG, "end upload:" + appendUrlParamsByHeader + " " + uploadEvent);
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        processCache();
        upload();
        DefaultWorkThread.postDelayed(this, 30000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class CacheException {
        private Map<String, String> customData;
        private Map<String, String> filters;
        private String logType;
        private String message;
        private String threadName;
        private Throwable throwable;
        private long timeStamp = System.currentTimeMillis();

        public CacheException(String str, Throwable th, String str2, String str3, Map<String, String> map, Map<String, String> map2) {
            this.logType = str;
            this.throwable = th;
            this.message = str2;
            this.filters = map;
            this.threadName = str3;
            this.customData = map2;
        }

        JSONObject toJSONObject(Header header) {
            Map<String, String> attachUserDataToMap;
            JSONObject jSONObject = new JSONObject();
            String exceptionStack = Stack.getExceptionStack(this.throwable);
            try {
                jSONObject.put("event_type", "biz_exception");
                jSONObject.put("crash_time", this.timeStamp);
                jSONObject.put("biz_exception_type", this.logType);
                jSONObject.put("app_start_time", Global.getAppStartTime());
                jSONObject.put("timestamp", this.timeStamp);
                jSONObject.put("crash_md5", Digest.getMD5(exceptionStack));
                jSONObject.put("message", this.message);
                jSONObject.put(CrashBody.CRASH_THREAD_NAME, this.threadName);
                jSONObject.put("process_name", App.getCurProcessName());
                jSONObject.put(ApmTrafficStats.KEY_EXCEPTION_TYPE, 1);
                jSONObject.put("process_name", App.getProcessName());
                jSONObject.put("app_start_time", Global.getAppStartTime());
                jSONObject.put("pid", Process.myPid());
                StackTraceElement stackTraceElement = this.throwable.getStackTrace()[0];
                jSONObject.put(EnsureReportData.CLASS_REF, stackTraceElement.getClassName());
                jSONObject.put("method", stackTraceElement.getMethodName());
                jSONObject.put(EnsureReportData.LINE_NUM, stackTraceElement.getLineNumber());
                jSONObject.put("stack", exceptionStack);
                ActivityLifecycle.loadActivityTrace(jSONObject);
                ActivityLifecycle.loadActivityTrack(jSONObject);
                jSONObject.put(Constants.IS_BACKGROUND, ActivityLifecycle.isBackground());
                SdkInfo.pushTo(jSONObject);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject.put("filters", jSONObject2);
                for (Map.Entry<String, String> entry : this.filters.entrySet()) {
                    if (entry.getKey() != null && entry.getValue() != null) {
                        jSONObject2.put(entry.getKey(), entry.getValue());
                    }
                }
                JSONUtils.put(jSONObject2, "is_64_runtime", NativeBridge.is64BitRuntime() ? "true" : "false");
                String optString = header.getJson().optString("cpu_abi");
                if (!TextUtils.isEmpty(optString)) {
                    boolean contains = optString.contains("64");
                    JSONUtils.put(jSONObject2, "is_x86_devices", Boolean.valueOf(optString.contains("86")));
                    JSONUtils.put(jSONObject2, Constants.IS_64_DEVICES, Boolean.valueOf(contains));
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("custom");
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                    jSONObject.put("custom", optJSONObject);
                }
                Map<String, String> map = this.customData;
                if (map != null) {
                    for (Map.Entry<String, String> entry2 : map.entrySet()) {
                        if (entry2.getKey() != null && entry2.getValue() != null) {
                            optJSONObject.put(entry2.getKey(), entry2.getValue());
                        }
                    }
                }
                if (MonitorManager.getAppMonitor() != null && (attachUserDataToMap = MonitorManager.getAppMonitor().getUserDataCenter().getAttachUserDataToMap(CrashType.ENSURE)) != null) {
                    for (Map.Entry<String, String> entry3 : attachUserDataToMap.entrySet()) {
                        optJSONObject.put(entry3.getKey(), entry3.getValue());
                    }
                }
            } catch (Exception e) {
                NpthLog.m231e(BizExceptionManager.TAG, (Throwable) e);
            }
            return jSONObject;
        }
    }
}
