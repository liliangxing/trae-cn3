package com.bytedance.crash.diagnose;

import android.content.Context;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.os.StatFs;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Global;
import com.bytedance.crash.config.NetConfig;
import com.bytedance.crash.config.NpthBuildConfig;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.event.EnsureDeliverer;
import com.bytedance.crash.event.EnsureReportData;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.EventMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.upload.CrashUploader;
import com.bytedance.crash.upload.UploadLimits;
import com.bytedance.crash.upload.UploaderUrl;
import com.bytedance.crash.util.JSONUtils;
import java.io.File;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class NpthMonitor {
    private static final String NPTH_AID = "2010";
    private static NpthMonitor sInstance;
    private final EventMonitor mEventMonitor;

    static /* synthetic */ NpthMonitor access$000() {
        return getInstance();
    }

    private NpthMonitor(Context context) {
        EventMonitor createEventMonitor = MonitorManager.createEventMonitor(context, NPTH_AID, 4020260L, 4020260L, NpthBuildConfig.VERSION_NAME);
        this.mEventMonitor = createEventMonitor;
        createEventMonitor.setChannel("release");
        AppMonitor appMonitor = MonitorManager.getAppMonitor();
        if (appMonitor != null) {
            createEventMonitor.setDeviceId(appMonitor.getDeviceId("0"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EventMonitor getEventMonitor() {
        return this.mEventMonitor;
    }

    public static void init() {
        if (sInstance == null) {
            synchronized (NpthMonitor.class) {
                if (sInstance == null) {
                    sInstance = new NpthMonitor(Global.getContext());
                }
            }
        }
    }

    private static NpthMonitor getInstance() {
        return sInstance;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class Event {
        private final JSONObject mCategory;
        private JSONObject mMetric;
        private final String mServiceName;

        public Event(String str) {
            this.mMetric = new JSONObject();
            this.mServiceName = str;
            this.mCategory = new JSONObject();
        }

        public Event(String str, JSONObject jSONObject) {
            this.mMetric = new JSONObject();
            this.mServiceName = str;
            if (jSONObject != null) {
                this.mCategory = jSONObject;
            } else {
                this.mCategory = new JSONObject();
            }
        }

        public Event addCategories(Object... objArr) {
            JSONUtils.addKVs(this.mCategory, objArr);
            return this;
        }

        public Event addMetrics(Object... objArr) {
            JSONUtils.addKVs(this.mMetric, objArr);
            return this;
        }

        public Event addMetrics(JSONObject jSONObject) {
            this.mMetric = jSONObject;
            return this;
        }

        public void upload() {
            NpthMonitor access$000 = NpthMonitor.access$000();
            if (access$000 != null) {
                appendDefaultCategory();
                access$000.getEventMonitor().reportEvent(this.mServiceName, 1, this.mCategory, this.mMetric);
            }
        }

        private void appendDefaultCategory() {
            AppMonitor appMonitor = MonitorManager.getAppMonitor();
            if (appMonitor != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("aid", appMonitor.getAppId());
                hashMap.put("device_id", appMonitor.getDeviceId("0"));
                hashMap.put("update_version_code", String.valueOf(appMonitor.getUpdateVersionCode()));
                hashMap.put("version_code", String.valueOf(appMonitor.getVersionCode()));
                hashMap.put("app_version", String.valueOf(appMonitor.getVersionName()));
                hashMap.put("channel", appMonitor.getChannel());
                hashMap.put("npth_version", NpthBuildConfig.VERSION_NAME);
                JSONUtils.put(this.mCategory, hashMap);
            }
        }
    }

    public static void reportInnerExceptionWithSpace(String str, Throwable th) {
        boolean z = getInnerFreeSizeReal() < 25165824;
        NpthMonitor npthMonitor = getInstance();
        if (npthMonitor != null) {
            npthMonitor.getEventMonitor().reportEnsure(str + "_" + z, th);
        }
    }

    public static void reportInnerException(String str, Throwable th) {
        NpthMonitor npthMonitor = getInstance();
        if (npthMonitor != null) {
            npthMonitor.getEventMonitor().reportEnsure(str, th);
        }
    }

    public static void directReportInnerException(String str, Throwable th) {
        NpthMonitor npthMonitor = getInstance();
        if (npthMonitor == null) {
            return;
        }
        EventMonitor eventMonitor = npthMonitor.getEventMonitor();
        try {
            EnsureReportData ensureReportData = new EnsureReportData(th, null, 0, str, true, null, Thread.currentThread().getName(), EnsureDeliverer.ENSURE_NOT_REACH_HERE, "core_exception_monitor", "exception");
            final JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(ensureReportData.toJsonObject(eventMonitor));
            jSONObject.put("data", jSONArray);
            JSONObject json = Header.createEventHeader(eventMonitor, System.currentTimeMillis(), CrashType.ENSURE, Process.myPid()).getJson();
            jSONObject.put("header", json);
            final String appendUrlParamsByHeader = UploaderUrl.appendUrlParamsByHeader(NetConfig.getExceptionUploadUrl(), json);
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                DefaultWorkThread.post(new Runnable() { // from class: com.bytedance.crash.diagnose.NpthMonitor.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (CrashUploader.uploadEvent(appendUrlParamsByHeader, jSONObject)) {
                                UploadLimits.get().writeUploadTimesFile();
                            }
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
        } catch (Throwable unused) {
        }
    }

    public static void reportInnerException(Throwable th) {
        reportInnerException("NPTH_CATCH_NEW", th);
    }

    public static long getInnerFreeSizeReal() {
        try {
            return getFileFreeSize(Environment.getDataDirectory());
        } catch (Throwable unused) {
            return 0L;
        }
    }

    private static long getFileFreeSize(File file) {
        try {
            return new StatFs(file.getPath()).getFreeBytes();
        } catch (Throwable unused) {
            return 0L;
        }
    }
}
