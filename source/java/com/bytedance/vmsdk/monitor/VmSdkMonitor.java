package com.bytedance.vmsdk.monitor;

import android.content.Context;
import android.util.Log;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import com.bytedance.vmsdk.log.VLog;
import com.bytedance.vmsdk.settings.SettingsManager;
import com.bytedance.webx.seclink.util.ReportUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class VmSdkMonitor {
    private static String TAG = "VmSdkMonitor";
    private static Context mContext;
    private static VmSdkMonitorInfo mInfo;
    private static boolean mOversea;
    private static volatile SDKMonitor mSdkMonitor;
    private static boolean settingsInit;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class Logger {
        Logger() {
        }

        private static String createLogMsg(Object... objArr) {
            StringBuilder sb = new StringBuilder();
            for (Object obj : objArr) {
                sb.append(" ");
                if (obj != null) {
                    sb.append(obj);
                } else {
                    sb.append("null");
                }
            }
            return sb.toString();
        }

        /* renamed from: v */
        public static void m22v(String str, Object... objArr) {
            Log.v(str, createLogMsg(objArr));
        }

        /* renamed from: d */
        public static void m19d(String str, Object... objArr) {
            Log.d(str, createLogMsg(objArr));
        }

        /* renamed from: i */
        public static void m21i(String str, Object... objArr) {
            Log.i(str, createLogMsg(objArr));
        }

        /* renamed from: w */
        public static void m23w(String str, Object... objArr) {
            Log.w(str, createLogMsg(objArr));
        }

        /* renamed from: e */
        public static void m20e(String str, Object... objArr) {
            Log.e(str, createLogMsg(objArr));
        }
    }

    public static synchronized void fastInit(Context context, VmSdkMonitorInfo vmSdkMonitorInfo, boolean z) {
        synchronized (VmSdkMonitor.class) {
            mContext = context;
            mInfo = vmSdkMonitorInfo;
            mOversea = z;
        }
    }

    private static synchronized void commonInit() {
        synchronized (VmSdkMonitor.class) {
            if (mSdkMonitor != null) {
                return;
            }
            VLog.init();
            SDKMonitorUtils.setConfigUrl("8398", MonitorUrl.configUrls);
            SDKMonitorUtils.setDefaultReportUrl("8398", MonitorUrl.reportUrls);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(ReportUtil.Params.DEVICE_ID, mInfo.getDeviceId());
                jSONObject.put("channel", mInfo.getChannel());
                jSONObject.put("host_aid", mInfo.getHostAid());
                jSONObject.put(ReportUtil.Params.APP_VERSION, mInfo.getAppVersion());
                jSONObject.put("update_version_code", mInfo.getUpdateVersionCode());
            } catch (JSONException e) {
                Logger.m20e(TAG, e.getMessage());
            }
            SDKMonitorUtils.initMonitor(mContext, "8398", jSONObject, new SDKMonitor.IGetExtendParams() { // from class: com.bytedance.vmsdk.monitor.VmSdkMonitor.1
                public String getSessionId() {
                    return null;
                }

                public Map<String, String> getCommonParams() {
                    if (!VmSdkMonitor.mOversea) {
                        return null;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("oversea", "1");
                    return hashMap;
                }
            });
            mSdkMonitor = SDKMonitorUtils.getInstance("8398");
            if (mSdkMonitor == null) {
                Logger.m21i(TAG, "VmSdkMonitor is null");
            }
        }
    }

    public static synchronized void init(Context context, VmSdkMonitorInfo vmSdkMonitorInfo, boolean z) {
        synchronized (VmSdkMonitor.class) {
            fastInit(context, vmSdkMonitorInfo, z);
            commonInit();
        }
    }

    public static synchronized void init(Context context, VmSdkMonitorInfo vmSdkMonitorInfo) {
        synchronized (VmSdkMonitor.class) {
            init(context, vmSdkMonitorInfo, false);
        }
    }

    public static void monitorStatusAndDuration(String str, int i, JSONObject jSONObject, JSONObject jSONObject2) {
        if (mSdkMonitor == null) {
            commonInit();
        }
        if (mSdkMonitor != null) {
            mSdkMonitor.monitorStatusAndDuration(str, i, jSONObject, jSONObject2);
        }
        Logger.m21i(TAG, str, Integer.valueOf(i), jSONObject, jSONObject2);
    }

    public static boolean isMonitorNull() {
        return mSdkMonitor == null;
    }

    public static void monitorStatusRate(String str, int i, JSONObject jSONObject) {
        if (mSdkMonitor == null) {
            commonInit();
        }
        if (mSdkMonitor != null) {
            mSdkMonitor.monitorStatusRate(str, i, jSONObject);
        }
        Logger.m21i(TAG, str, Integer.valueOf(i), jSONObject);
    }

    public static void monitorDuration(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        if (mSdkMonitor == null) {
            commonInit();
        }
        if (mSdkMonitor != null) {
            mSdkMonitor.monitorDuration(str, jSONObject, jSONObject2);
        }
        Logger.m21i(TAG, str, jSONObject, jSONObject2);
    }

    public static void monitorCommonLog(String str, JSONObject jSONObject) {
        if (mSdkMonitor == null) {
            commonInit();
        }
        if (mSdkMonitor != null) {
            mSdkMonitor.monitorCommonLog(str, jSONObject);
        }
        Logger.m21i(TAG, str, jSONObject);
    }

    public static void monitorEvent(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        if (mSdkMonitor == null) {
            commonInit();
        }
        if (mSdkMonitor != null) {
            mSdkMonitor.monitorEvent(str, jSONObject, jSONObject2, jSONObject3);
        }
        Logger.m21i(TAG, str, jSONObject, jSONObject2, jSONObject3);
    }

    public static void monitorSLA(Long l, Long l2, String str, String str2, String str3, int i, JSONObject jSONObject) {
        if (mSdkMonitor == null) {
            commonInit();
        }
        if (mSdkMonitor != null) {
            mSdkMonitor.monitorSLA(l.longValue(), l2.longValue(), str, str2, str3, i, jSONObject);
        }
        Logger.m21i(TAG, l, l2, str, str2, str3, Integer.valueOf(i), jSONObject);
    }

    public static void monitorApiError(Long l, Long l2, String str, String str2, String str3, int i, JSONObject jSONObject) {
        if (mSdkMonitor == null) {
            commonInit();
        }
        if (mSdkMonitor != null) {
            mSdkMonitor.monitorApiError(l.longValue(), l2.longValue(), str, str2, str3, i, jSONObject);
        }
        Logger.m21i(TAG, l, l2, str, str2, str3, Integer.valueOf(i), jSONObject);
    }

    public static void flushBuffer() {
        if (mSdkMonitor == null) {
            commonInit();
        }
        if (mSdkMonitor != null) {
            mSdkMonitor.flushBuffer();
        }
    }

    public static void flushReport() {
        if (mSdkMonitor == null) {
            commonInit();
        }
        if (mSdkMonitor != null) {
            mSdkMonitor.flushReport();
        }
    }

    private static void monitorEvent(String str, String str2, String str3, String str4) {
        Log.d(TAG, "monitorEvent from native, moduleName:" + str + " bizName:" + str2 + " dataKey:" + str3 + " dataValue:" + str4);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("biz_name", str2);
            jSONObject.put(str3, str4);
            monitorEvent(str, jSONObject, (JSONObject) null, (JSONObject) null);
        } catch (Throwable th) {
            Log.e(TAG, "VmSdkMonitor upload error: " + th.getMessage());
        }
    }

    private static boolean getSettings(String str) {
        if (!settingsInit) {
            SettingsManager.inst().initSettings(mContext);
        }
        boolean settingsFromCache = SettingsManager.inst().getSettingsFromCache(str);
        Log.d(TAG, "VmSdkMonitor getSettings from native, key:" + str + " value: " + settingsFromCache);
        return settingsFromCache;
    }

    private static int getSettingsFlag() {
        if (!settingsInit) {
            SettingsManager.inst().initSettings(mContext);
        }
        int settingsFlag = SettingsManager.inst().getSettingsFlag();
        Log.d(TAG, "VmSdkMonitor getSettingsFlag from native value: " + settingsFlag);
        return settingsFlag;
    }
}
