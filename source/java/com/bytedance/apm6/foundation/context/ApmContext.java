package com.bytedance.apm6.foundation.context;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.apm.listener.INtpTimeService;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.services.apm.api.HttpResponse;
import com.bytedance.services.apm.api.IHttpService;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ApmContext extends ApmBaseContext {
    private static ApmContextAdapter apmContextAdapter = null;
    private static String appVersion = null;
    private static Map<String, String> cacheBaseUrlParams = null;
    private static String channel = null;
    private static long configTime = -1;
    private static long initTimeStamp = 0;
    private static Boolean isMainProcess = null;
    private static int manifestVersionCode = -1;
    private static INtpTimeService ntpTimeService = null;
    private static String processName = null;
    private static String releaseBuild = null;
    private static JSONObject stableHeaderExtra = null;
    private static long startId = -1;
    private static int updateVersionCode = -1;
    private static int versionCode = -1;
    private static String versionName;

    public static void setApmContextAdapter(ApmContextAdapter apmContextAdapter2) {
        if (apmContextAdapter2 == null) {
            throw new IllegalArgumentException("apmAdapter cannot be null!");
        }
        apmContextAdapter = apmContextAdapter2;
        ApmBaseContext.setContext(apmContextAdapter2.getContext());
    }

    public static void setNtpTimeService(INtpTimeService iNtpTimeService) {
        ntpTimeService = iNtpTimeService;
    }

    public static INtpTimeService getNtpTimeService() {
        return ntpTimeService;
    }

    public static ApmContextAdapter getApmContextAdapter() {
        return apmContextAdapter;
    }

    public static void setInitTimeStamp(long j) {
        initTimeStamp = j;
    }

    public static void setStartId(long j) {
        startId = j;
    }

    public static long getStartId() {
        if (startId < 0) {
            startId = System.currentTimeMillis();
        }
        return startId;
    }

    public static long getInitTimeStamp() {
        if (initTimeStamp <= 0) {
            initTimeStamp = System.currentTimeMillis();
        }
        return initTimeStamp;
    }

    public static boolean isMainProcess() {
        if (isMainProcess == null) {
            synchronized (ApmContext.class) {
                if (isMainProcess == null) {
                    String currentProcessName = getCurrentProcessName();
                    boolean z = false;
                    if (currentProcessName != null && currentProcessName.contains(Constants.COLON_SEPARATOR)) {
                        isMainProcess = false;
                    } else {
                        if (currentProcessName != null && currentProcessName.equals(getContext().getPackageName())) {
                            z = true;
                        }
                        isMainProcess = Boolean.valueOf(z);
                    }
                }
            }
        }
        return isMainProcess.booleanValue();
    }

    public static String getCurrentProcessName() {
        if (processName == null) {
            synchronized (ApmContext.class) {
                if (processName == null) {
                    processName = apmContextAdapter.getProcessName();
                }
            }
        }
        return processName;
    }

    public static int getAid() {
        return apmContextAdapter.getAid();
    }

    public static String getChannel() {
        if (channel == null) {
            synchronized (ApmContext.class) {
                if (channel == null) {
                    channel = apmContextAdapter.getChannel();
                }
            }
        }
        return channel;
    }

    public static int getUpdateVersionCode() {
        if (updateVersionCode == -1) {
            synchronized (ApmContext.class) {
                if (updateVersionCode == -1) {
                    updateVersionCode = apmContextAdapter.getUpdateVersionCode();
                }
            }
        }
        return updateVersionCode;
    }

    public static String getVersionName() {
        if (TextUtils.isEmpty(versionName)) {
            synchronized (ApmContext.class) {
                if (TextUtils.isEmpty(versionName)) {
                    versionName = apmContextAdapter.getVersionName();
                }
            }
        }
        return versionName;
    }

    public static int getVersionCode() {
        if (versionCode == -1) {
            synchronized (ApmContext.class) {
                if (versionCode == -1) {
                    versionCode = apmContextAdapter.getVersionCode();
                }
            }
        }
        return versionCode;
    }

    public static String getAppVersion() {
        if (TextUtils.isEmpty(appVersion)) {
            synchronized (ApmContext.class) {
                if (TextUtils.isEmpty(appVersion)) {
                    appVersion = apmContextAdapter.getAppVersion();
                }
            }
        }
        return appVersion;
    }

    public static String getReleaseBuild() {
        if (TextUtils.isEmpty(releaseBuild)) {
            synchronized (ApmContext.class) {
                if (TextUtils.isEmpty(releaseBuild)) {
                    releaseBuild = apmContextAdapter.getReleaseBuild();
                }
            }
        }
        return releaseBuild;
    }

    public static String getManifestVersionCode() {
        if (manifestVersionCode == -1) {
            synchronized (ApmContext.class) {
                if (manifestVersionCode == -1) {
                    manifestVersionCode = apmContextAdapter.getManifestVersionCode();
                }
            }
        }
        return String.valueOf(manifestVersionCode);
    }

    public static JSONObject getStableHeaderExtras() {
        if (stableHeaderExtra == null) {
            synchronized (ApmContext.class) {
                if (stableHeaderExtra == null) {
                    stableHeaderExtra = apmContextAdapter.getStableHeaderExtras();
                }
            }
        }
        return stableHeaderExtra;
    }

    public static String getDeviceId() {
        return apmContextAdapter.getDeviceId();
    }

    public static String getSessionId() {
        return apmContextAdapter.getSessionId();
    }

    public static long getUserID() {
        return apmContextAdapter.getUid();
    }

    public static void setConfigTime(long j) {
        configTime = j;
    }

    public static long getConfigTime() {
        return configTime;
    }

    public static Map<String, String> getUrlParams() {
        if (cacheBaseUrlParams == null) {
            HashMap hashMap = new HashMap();
            cacheBaseUrlParams = hashMap;
            hashMap.put("aid", String.valueOf(getAid()));
            cacheBaseUrlParams.put("os", "Android");
            cacheBaseUrlParams.put("device_platform", "android");
            cacheBaseUrlParams.put("os_api", Build.VERSION.SDK_INT + "");
            cacheBaseUrlParams.put("update_version_code", String.valueOf(getUpdateVersionCode()));
            cacheBaseUrlParams.put("version_code", getAppVersion());
            cacheBaseUrlParams.put("channel", getChannel());
            cacheBaseUrlParams.put("device_model", Build.MODEL);
            cacheBaseUrlParams.put("device_brand", Build.BRAND);
        }
        cacheBaseUrlParams.put("device_id", getDeviceId());
        if (isDebugMode()) {
            cacheBaseUrlParams.put("_log_level", "debug");
        }
        try {
            Map<String, String> paramsExtras = getApmContextAdapter().getParamsExtras();
            if (paramsExtras != null && paramsExtras.size() > 0) {
                for (Map.Entry<String, String> entry : paramsExtras.entrySet()) {
                    cacheBaseUrlParams.put(entry.getKey(), entry.getValue());
                }
            }
        } catch (Throwable unused) {
        }
        return cacheBaseUrlParams;
    }

    public static HttpResponse doPost(String str, Map<String, String> map, byte[] bArr) throws Exception {
        return ((IHttpService) ServiceManager.getService(IHttpService.class)).doPost(str, bArr, map);
    }

    public static HttpResponse doGet(String str, Map<String, String> map) throws Exception {
        return ((IHttpService) ServiceManager.getService(IHttpService.class)).doGet(str, map);
    }
}
