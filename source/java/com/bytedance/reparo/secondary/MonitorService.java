package com.bytedance.reparo.secondary;

import android.app.Application;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import com.bytedance.networkstackapplib.NetworkStackConstant;
import com.bytedance.notification.Constants;
import com.bytedance.reparo.IReparoConfig;
import com.bytedance.reparo.core.ReparoPatch;
import com.bytedance.reparo.core.common.event.Event;
import com.bytedance.reparo.core.common.utils.ThrowableUtils;
import com.bytedance.reparo.util.CpuUtils;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class MonitorService {
    private static final String MONITOR_CONFIG_URL = "https://mon.snssdk.com/monitor/appmonitor/v2/settings";
    private static final String MONITOR_REPORT_URL = "https://mon.snssdk.com/monitor/collect/";
    private static final String SDK_ID = "7506";
    private static final String SERVICE_NAME_COMMON_ERROR = "common_error";
    private static final String SERVICE_NAME_PATCH_DOWNLOAD = "patch_download";
    private static final String SERVICE_NAME_PATCH_DURATION = "patch_load_duration";
    private static final String SERVICE_NAME_PATCH_INSTALL = "patch_install";
    private static final String SERVICE_NAME_PATCH_LOAD = "patch_load";
    private static final String SERVICE_NAME_PATCH_UPDATE = "patch_update";
    private static final String SERVICE_NAME_REMOTE_PATCH_QUERY = "remote_patch_query";
    private static final String SERVICE_NAME_SDK_INIT = "sdk_init";
    private static final String SERVICE_NAME_SO_MD5_CHECK = "so_md5_check";
    private static final String TAG = "MonitorService";
    private static volatile SDKMonitor sMonitor;
    private static final Map<String, String> sServiceMap = new HashMap<String, String>() { // from class: com.bytedance.reparo.secondary.MonitorService.1
        {
            put(MonitorService.SERVICE_NAME_SDK_INIT, MonitorService.SERVICE_NAME_SDK_INIT);
            put("query_remote_patch_info", MonitorService.SERVICE_NAME_REMOTE_PATCH_QUERY);
            put(MonitorService.SERVICE_NAME_PATCH_DOWNLOAD, MonitorService.SERVICE_NAME_PATCH_DOWNLOAD);
            put("patch_install", "patch_install");
            put("patch_update", "patch_update");
            put("so_md5_check", "so_md5_check");
            put("patch_load", "patch_load");
            put("patch_load_duration", "patch_load_duration");
        }
    };
    private static boolean sInited = false;
    private static IReparoConfig sConfig = null;
    private static Application sApp = null;

    public static void initParam(Application application, IReparoConfig iReparoConfig) {
        sConfig = iReparoConfig;
        sApp = application;
    }

    public static void init(Application application, IReparoConfig iReparoConfig) {
        sConfig = iReparoConfig;
        sApp = application;
        checkInit();
    }

    public static boolean isInited() {
        return sInited;
    }

    private static void checkInit() {
        IReparoConfig iReparoConfig;
        if (sInited || sApp == null || (iReparoConfig = sConfig) == null || !CheckedReparoConfig.isAvailableDid(iReparoConfig.getDeviceId())) {
            return;
        }
        sInited = true;
        init(sApp, sConfig.getDeviceId(), sConfig.getAppId(), sConfig.getChannel(), sConfig.getUpdateVersionCode());
    }

    public static void init(Application application, String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CommonConstants.KEY_DID, str);
            jSONObject.put("host_aid", str2);
            jSONObject.put("channel", "release");
            jSONObject.put("app_version", "0.0.4-rc.50");
            jSONObject.put("update_version_code", str4);
            jSONObject.put("package_name", application.getPackageName());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        SDKMonitorUtils.setConfigUrl(SDK_ID, Collections.singletonList(MONITOR_CONFIG_URL));
        SDKMonitorUtils.setDefaultReportUrl(SDK_ID, Collections.singletonList(MONITOR_REPORT_URL));
        SDKMonitorUtils.initMonitor(application, SDK_ID, jSONObject, new SDKMonitor.IGetExtendParams() { // from class: com.bytedance.reparo.secondary.MonitorService.2
            Map<String, String> commonParams = null;

            public String getSessionId() {
                return null;
            }

            public Map<String, String> getCommonParams() {
                Map<String, String> map = this.commonParams;
                if (map != null) {
                    return map;
                }
                HashMap hashMap = new HashMap();
                this.commonParams = hashMap;
                hashMap.put("device_manufacturer", Build.MANUFACTURER);
                this.commonParams.put("device_model", MonitorService.getVendorModel());
                return this.commonParams;
            }
        });
        Logger.m328i(TAG, "real init with did: " + str);
    }

    public static String getVendorModel() {
        String str = Build.BRAND;
        String str2 = Build.MODEL;
        return TextUtils.isEmpty(str2) ? str == null ? NetworkStackConstant.UNKNOWN_TYPE : str : (str == null || str2.contains(str)) ? str2 : str + ' ' + str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SDKMonitor getMonitor() {
        if (sMonitor == null) {
            synchronized (MonitorService.class) {
                if (sMonitor == null) {
                    sMonitor = SDKMonitorUtils.getInstance(SDK_ID);
                }
            }
        }
        checkInit();
        return sMonitor;
    }

    public static void commonErrorLog(String str, String str2) {
        commonErrorLog(str, str2, null);
    }

    public static void commonErrorLog(String str, String str2, Throwable th) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(Constants.NOTIFICATION_TAG, str);
            jSONObject.putOpt(Constants.EVENT_PARAMS_KEY_ERROR_MSG, str2);
            jSONObject.putOpt("throwable", ThrowableUtils.getThrowableStack(th));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        getMonitor().monitorStatusAndEvent(SERVICE_NAME_COMMON_ERROR, 1, new JSONObject(), new JSONObject(), jSONObject);
    }

    public static void report(Event event) {
        String step = event.getStep();
        if (!TextUtils.isEmpty(step)) {
            Map<String, String> map = sServiceMap;
            if (!TextUtils.isEmpty(map.get(step))) {
                String str = map.get(step);
                try {
                    JSONObject createMetricJSONObject = event.createMetricJSONObject();
                    getMonitor().monitorStatusAndEvent(str, event.getStatus(), getCommonJson(event.createCategoryJSONObject()), createMetricJSONObject, event.createExtraJSONObject());
                    return;
                } catch (JSONException unused) {
                    return;
                }
            }
        }
        logEvent(event);
    }

    private static void logEvent(Event event) {
        if (event.isSuccess()) {
            Logger.m328i(TAG, event.toString());
        } else if (event.getException() != null) {
            Logger.m327e(TAG, event.getStep(), event.getException());
        } else {
            Logger.m326e(TAG, event.toString());
        }
    }

    private static JSONObject getCommonJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("is_64_device", CpuUtils.is64BitDevice());
            jSONObject.put("is_x86_device", CpuUtils.isX86Device());
            jSONObject.put("api_level", Build.VERSION.SDK_INT);
            jSONObject.put("sdk_channel", "release");
            jSONObject.put("is_64_runtime", ReparoPatch.getInstance().getHostApkAbi().contains("64"));
        } catch (Throwable unused) {
        }
        return jSONObject;
    }
}
