package com.bytedance.reparo;

import android.content.Context;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.os.StatFs;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.config.NetConfig;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.event.EnsureReportData;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.EventMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.upload.CrashUploader;
import com.bytedance.crash.upload.UploadLimits;
import com.bytedance.crash.upload.UploaderUrl;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.ies.bullet.service.base.standard.visiblestate.ViewVisibleBridge;
import com.bytedance.memory.api.MemoryApi;
import com.bytedance.pia.core.tracing.OnlineTracing;
import com.bytedance.push.utils.RomVersionParamHelper;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ReparoNpthMonitor {
    private static final String NPTH_AID = "8616";
    private static ReparoNpthMonitor sInstance;
    private final EventMonitor mEventMonitor;

    static /* synthetic */ ReparoNpthMonitor access$000() {
        return getInstance();
    }

    private ReparoNpthMonitor(Context context, boolean z, long j, String str) {
        String str2;
        EventMonitor createEventMonitor = MonitorManager.createEventMonitor(context, NPTH_AID, j, j, str);
        this.mEventMonitor = createEventMonitor;
        if (z) {
            str2 = MemoryApi.DEBUG;
        } else {
            str2 = "alpha";
            if (!str.contains("alpha")) {
                str2 = "release";
            }
        }
        createEventMonitor.setChannel(str2);
        AppMonitor appMonitor = MonitorManager.getAppMonitor();
        if (appMonitor != null) {
            createEventMonitor.setDeviceId(appMonitor.getDeviceId(ViewVisibleBridge.INVISIBLE));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EventMonitor getEventMonitor() {
        return this.mEventMonitor;
    }

    public static void init(Context context, boolean z, long j, String str) {
        if (sInstance == null) {
            synchronized (ReparoNpthMonitor.class) {
                if (sInstance == null) {
                    sInstance = new ReparoNpthMonitor(context, z, j, str);
                }
            }
        }
    }

    private static ReparoNpthMonitor getInstance() {
        return sInstance;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
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
            ReparoNpthMonitor access$000 = ReparoNpthMonitor.access$000();
            if (access$000 != null) {
                appendDefaultCategory();
                access$000.getEventMonitor().reportEvent(this.mServiceName, 1, this.mCategory, this.mMetric);
            }
        }

        private void appendDefaultCategory() {
            AppMonitor appMonitor = MonitorManager.getAppMonitor();
            if (appMonitor != null) {
                HashMap hashMap = new HashMap();
                hashMap.put(CommonConstants.KEY_AID, appMonitor.getAppId());
                hashMap.put(CommonConstants.KEY_DID, appMonitor.getDeviceId(ViewVisibleBridge.INVISIBLE));
                hashMap.put("update_version_code", String.valueOf(appMonitor.getUpdateVersionCode()));
                hashMap.put("version_code", String.valueOf(appMonitor.getVersionCode()));
                hashMap.put("app_version", String.valueOf(appMonitor.getVersionName()));
                hashMap.put("channel", appMonitor.getChannel());
                hashMap.put("npth_version", "4.0.0");
                JSONUtils.put(this.mCategory, hashMap);
            }
        }
    }

    public static void reportInnerExceptionWithSpace(String str, Throwable th) {
        boolean z = getInnerFreeSizeReal() < 25165824;
        ReparoNpthMonitor reparoNpthMonitor = getInstance();
        if (reparoNpthMonitor != null) {
            reparoNpthMonitor.getEventMonitor().reportEnsure(str + RomVersionParamHelper.SEPARATOR + z, th);
        }
    }

    public static void reportInnerException(String str, Throwable th) {
        ReparoNpthMonitor reparoNpthMonitor = getInstance();
        if (reparoNpthMonitor != null) {
            reparoNpthMonitor.getEventMonitor().reportEnsure(str, th);
        }
    }

    public static void directReportInnerException(String str, Throwable th) {
        ReparoNpthMonitor reparoNpthMonitor = getInstance();
        if (reparoNpthMonitor == null) {
            return;
        }
        EventMonitor eventMonitor = reparoNpthMonitor.getEventMonitor();
        try {
            EnsureReportData ensureReportData = new EnsureReportData(th, (StackTraceElement[]) null, 0, str, true, (Map) null, Thread.currentThread().getName(), "EnsureNotReachHere", "core_exception_monitor", "exception");
            final JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(ensureReportData.toJsonObject(eventMonitor));
            jSONObject.put("data", jSONArray);
            JSONObject json = Header.createEventHeader(eventMonitor, System.currentTimeMillis(), CrashType.ENSURE, Process.myPid()).getJson();
            jSONObject.put(OnlineTracing.HeaderKeys.KEY_SSR_FALLBACK_HEADER, json);
            final String appendUrlParamsByHeader = UploaderUrl.appendUrlParamsByHeader(NetConfig.getExceptionUploadUrl(), json);
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                DefaultWorkThread.post(new Runnable() { // from class: com.bytedance.reparo.ReparoNpthMonitor.1
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
