package com.bytedance.apm;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.apm.constant.ReportConsts;
import com.bytedance.apm.core.DefaultDynamicParams;
import com.bytedance.apm.core.IDynamicParams;
import com.bytedance.apm.core.IQueryParams;
import com.bytedance.apm.entity.UploadInfo;
import com.bytedance.apm.net.DefaultHttpServiceImpl;
import com.bytedance.apm.util.AppUtils;
import com.bytedance.apm.util.JsonUtils;
import com.bytedance.apm.util.RomUtils;
import com.bytedance.apm.util.SlardarProperties;
import com.bytedance.apm6.monitor.MonitorableInterceptor;
import com.bytedance.bdturing.utils.Consts;
import com.bytedance.ies.argus.bean.ArgusConstants;
import com.bytedance.services.apm.api.HttpResponse;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.apm.api.IMultipartUploader;
import com.bytedance.services.apm.api.IRequestTagHeaderProvider;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ApmContext {
    private static IRequestTagHeaderProvider httpProvider;
    private static CommonParams params;
    private static String sAlogFilesDir;
    private static long sAppLaunchStartTimestamp;
    private static boolean sAutomationTest;
    private static Context sContext;
    private static String sCurrentProcessName;
    private static boolean sDebugMode;
    private static boolean sDoctorDebugMode;
    private static boolean sExceptionTrafficDetect;
    private static long sInitCostTime;
    private static long sInitCostTime6;
    static long sInitCostTimeStep2;
    static long sInitCostTimeStep3;
    static long sInitCostTimeStep4;
    static long sInitCostTimeStep5;
    private static long sInitTimeStamp;
    private static MonitorableInterceptor sInterceptor;
    private static boolean sIsDeviceInfoOnPerfDataEnabled;
    private static boolean sIsInternalTest;
    private static boolean sIsMainProcess;
    private static List<String> sSlardarConfigUrls;
    private static long sStartCostTime;
    private static long sStartTimeStamp;
    private static long sStartupTimestamp;
    private static boolean sSupportMultiFrameRate;
    private static JSONObject sHeader = new JSONObject();
    private static IDynamicParams sDynamicParams = new DefaultDynamicParams();
    private static Map<String, String> sQueryParamsMap = Collections.emptyMap();
    private static IHttpService sHttpService = new DefaultHttpServiceImpl();
    private static long sStartId = -1;
    private static volatile int sLaunchMode = -1;
    private static boolean sStopWhenBackground = false;
    private static long sReportSeqNo = 0;
    private static boolean sNeedSalvage = true;
    private static boolean sIsApm6Enable = true;
    private static boolean isInitFinish = false;
    private static ApmProgressListener progressListener = null;
    private static IQueryParams sQueryParams = null;

    public static boolean isInitFinish() {
        return isInitFinish;
    }

    public static void setIsInitFinish(boolean z) {
        isInitFinish = z;
    }

    public static Context getContext() {
        return sContext;
    }

    public static void setContext(Context context) {
        if (context == null) {
            return;
        }
        sContext = AppUtils.getApplication(context);
    }

    public static void setInterceptor(MonitorableInterceptor monitorableInterceptor) {
        sInterceptor = monitorableInterceptor;
    }

    public static MonitorableInterceptor getInterceptor() {
        return sInterceptor;
    }

    public static void setCurrentProcessName(String str) {
        sCurrentProcessName = str;
    }

    public static void setInitCostTime(long j) {
        sInitCostTime = j;
    }

    public static void setInitCostTimeStepFinish(long j) {
        sInitCostTime6 = j;
    }

    public static void setInitCostTimeStep2(long j) {
        sInitCostTimeStep2 = j;
    }

    public static void setInitCostTimeStep3(long j) {
        sInitCostTimeStep3 = j;
    }

    public static void setInitCostTimeStep4(long j) {
        sInitCostTimeStep4 = j;
    }

    public static void setInitCostTimeStep5(long j) {
        sInitCostTimeStep5 = j;
    }

    public static void setStartCostTime(long j) {
        sStartCostTime = j;
    }

    public static boolean isNeedSalvage() {
        return sNeedSalvage;
    }

    public static void setNeedSalvage(boolean z) {
        sNeedSalvage = z;
    }

    public static ApmProgressListener getProgressListener() {
        return progressListener;
    }

    public static void setProgressListener(ApmProgressListener apmProgressListener) {
        progressListener = apmProgressListener;
    }

    public static String getCurrentProcessName() {
        if (TextUtils.isEmpty(sCurrentProcessName)) {
            sCurrentProcessName = AppUtils.getProcessName(Process.myPid());
        }
        return sCurrentProcessName;
    }

    public static boolean isMainProcess() {
        if (sIsMainProcess) {
            return true;
        }
        if (sContext == null) {
            return isMainProcessSimple();
        }
        String currentProcessName = getCurrentProcessName();
        if (currentProcessName != null && currentProcessName.contains(":")) {
            sIsMainProcess = false;
        } else {
            sIsMainProcess = currentProcessName != null && currentProcessName.equals(sContext.getPackageName());
        }
        return sIsMainProcess;
    }

    public static boolean isMainProcessSimple() {
        String currentProcessName;
        return sIsMainProcess || (currentProcessName = getCurrentProcessName()) == null || !currentProcessName.contains(":");
    }

    public static void setStopWhenBackground(boolean z) {
        sStopWhenBackground = z;
    }

    public static boolean isStopWhenBackground() {
        return sStopWhenBackground;
    }

    public static String getPackageName() {
        Context context = sContext;
        return context == null ? "" : context.getPackageName();
    }

    public static String getTimeRange(long j) {
        long j2 = j - sInitTimeStamp;
        return j2 < 30000 ? "0 - 30s" : j2 < 60000 ? "30s - 1min" : j2 < 120000 ? "1min - 2min" : j2 < 300000 ? "2min - 5min" : j2 < UploadInfo.DEFAULT_SEND_DURATION ? "5min - 10min" : j2 < ReportConsts.LAST_STOP_INTERVAL ? "10min - 30min" : j2 < 3600000 ? "30min - 1h" : "1h - ";
    }

    public static long getStartId() {
        if (sStartId == -1) {
            sStartId = System.currentTimeMillis();
        }
        return sStartId;
    }

    public static int getLaunchMode() {
        return sLaunchMode;
    }

    public static void setLaunchMode(int i) {
        sLaunchMode = i;
    }

    public static void setDebugMode(boolean z) {
        sDebugMode = z;
        com.bytedance.apm6.foundation.context.ApmContext.setDebugMode(isDebugMode());
    }

    public static void setDoctorDebugMode(boolean z) {
        sDoctorDebugMode = z;
        com.bytedance.apm6.foundation.context.ApmContext.setDebugMode(isDebugMode());
    }

    public static void setInternalTest(boolean z) {
        sIsInternalTest = z;
    }

    public static boolean isDebugMode() {
        return sDebugMode || sDoctorDebugMode;
    }

    public static boolean isDoctorDebugMode() {
        return sDoctorDebugMode;
    }

    public static void setAutomationTest(boolean z) {
        sAutomationTest = z;
    }

    public static boolean isAutomationTest() {
        return sAutomationTest;
    }

    public static boolean isInternalTest() {
        return sIsInternalTest;
    }

    public static synchronized void setHeaderInfo(JSONObject jSONObject) {
        PackageInfo packageInfo;
        synchronized (ApmContext.class) {
            try {
                if (params == null) {
                    params = new CommonParams();
                }
                jSONObject.put("os", "Android");
                jSONObject.put("device_platform", Consts.OS_NAME);
                jSONObject.put("os_version", Build.VERSION.RELEASE);
                jSONObject.put("os_api", Build.VERSION.SDK_INT);
                jSONObject.put("device_model", Build.MODEL);
                jSONObject.put("device_brand", Build.BRAND);
                jSONObject.put("device_manufacturer", Build.MANUFACTURER);
                jSONObject.put("process_name", AppUtils.getProcessName(Process.myPid()));
                jSONObject.put("sid", getStartId());
                jSONObject.put("phone_startup_time", getInitTimeStamp());
                jSONObject.put("verify_info", SlardarProperties.getReleaseBuild());
                jSONObject.put("rom_version", RomUtils.getRomInfo());
                if (jSONObject.has("version_name")) {
                    packageInfo = null;
                } else {
                    packageInfo = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0);
                    jSONObject.put("version_name", packageInfo.versionName);
                }
                if (TextUtils.isEmpty(jSONObject.optString("app_version"))) {
                    jSONObject.put("app_version", jSONObject.optString("version_name"));
                }
                if (!jSONObject.has("version_code")) {
                    if (packageInfo == null) {
                        packageInfo = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0);
                    }
                    jSONObject.put("version_code", packageInfo.versionCode);
                }
                if (TextUtils.isEmpty(jSONObject.optString("package"))) {
                    jSONObject.put("package", getContext().getPackageName());
                }
                jSONObject.put("monitor_version", "5.0.21.41");
            } catch (Exception unused) {
            }
            params.setProcessName(jSONObject.optString("process_name"));
            params.setDeviceId(jSONObject.optString("device_id"));
            try {
                params.setAid(jSONObject.optInt("aid"));
                params.setChannel(jSONObject.optString("channel"));
                if (jSONObject.has("update_version_code")) {
                    if (jSONObject.get("update_version_code") instanceof String) {
                        params.setUpdateVersionCode(Integer.valueOf(jSONObject.optString("update_version_code")).intValue());
                    } else {
                        params.setUpdateVersionCode(jSONObject.optInt("update_version_code"));
                    }
                }
                if (jSONObject.has("version_name")) {
                    params.setVersionName(jSONObject.optString("version_name"));
                }
                if (jSONObject.has("manifest_version_code")) {
                    if (jSONObject.get("manifest_version_code") instanceof String) {
                        params.setManifestVersionCode(Integer.valueOf(jSONObject.optString("manifest_version_code")).intValue());
                    } else {
                        params.setManifestVersionCode(jSONObject.optInt("manifest_version_code"));
                    }
                }
                if (jSONObject.has("version_code")) {
                    if (jSONObject.get("version_code") instanceof String) {
                        params.setVersionCode(Integer.valueOf(jSONObject.optString("version_code")).intValue());
                    } else {
                        params.setVersionCode(jSONObject.optInt("version_code"));
                    }
                }
                if (jSONObject.has("app_version")) {
                    params.setAppVersion(jSONObject.optString("app_version"));
                }
                String releaseBuild = SlardarProperties.getReleaseBuild();
                if (!TextUtils.isEmpty(releaseBuild) && !releaseBuild.equals(ArgusConstants.NULL_PLACE_HOLDER)) {
                    jSONObject.put("release_build", releaseBuild);
                    params.setReleaseBuild(jSONObject.optString("release_build"));
                } else if (!SlardarProperties.getReleaseBuild().isEmpty()) {
                    params.setReleaseBuild(SlardarProperties.getReleaseBuild());
                }
            } catch (Exception unused2) {
            }
            params.setStaticHeaderExtras(JsonUtils.deepCopy(jSONObject));
            if (sHeader == null) {
                sHeader = jSONObject;
            } else {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    try {
                        sHeader.put(next, jSONObject.get(next));
                    } catch (JSONException unused3) {
                    }
                }
            }
        }
    }

    public static void setHttpService(IHttpService iHttpService) {
        if (iHttpService != null) {
            sHttpService = iHttpService;
        }
    }

    public static void setRequestTagHeaderProvider(IRequestTagHeaderProvider iRequestTagHeaderProvider) {
        httpProvider = iRequestTagHeaderProvider;
    }

    public static IRequestTagHeaderProvider getRequestTagHeaderProvider() {
        return httpProvider;
    }

    public static boolean isLocalChannel() {
        JSONObject jSONObject = sHeader;
        if (jSONObject == null || jSONObject.optString("channel") == null) {
            return false;
        }
        return sHeader.optString("channel").contains("local");
    }

    public static synchronized CommonParams getParams() {
        CommonParams commonParams;
        synchronized (ApmContext.class) {
            commonParams = params;
        }
        return commonParams;
    }

    public static synchronized Map<String, String> getParamsExtras() {
        Map<String, String> queryParams;
        synchronized (ApmContext.class) {
            IQueryParams iQueryParams = sQueryParams;
            if (iQueryParams != null && (queryParams = iQueryParams.getQueryParams()) != null && queryParams.size() > 0) {
                if (params.getParamExtras() == null) {
                    return queryParams;
                }
                HashMap hashMap = new HashMap(params.getParamExtras());
                hashMap.putAll(queryParams);
                return hashMap;
            }
            CommonParams commonParams = params;
            if (commonParams != null) {
                return commonParams.getParamExtras();
            }
            return null;
        }
    }

    public static synchronized void setQueryParams(IQueryParams iQueryParams) {
        synchronized (ApmContext.class) {
            sQueryParams = iQueryParams;
        }
    }

    public static synchronized IQueryParams getQueryParams() {
        IQueryParams iQueryParams;
        synchronized (ApmContext.class) {
            iQueryParams = sQueryParams;
        }
        return iQueryParams;
    }

    public static synchronized void setDynamicParams(IDynamicParams iDynamicParams) {
        synchronized (ApmContext.class) {
            sDynamicParams = iDynamicParams;
            Map<String, String> commonParams = iDynamicParams.getCommonParams();
            sQueryParamsMap = commonParams;
            if (commonParams == null) {
                sQueryParamsMap = new HashMap();
            }
            if (!sQueryParamsMap.containsKey("aid")) {
                sQueryParamsMap.put("aid", sHeader.optString("aid"));
            }
            if (!sQueryParamsMap.containsKey("device_id")) {
                sQueryParamsMap.put("device_id", sHeader.optString("device_id"));
            }
            if (!sQueryParamsMap.containsKey("device_platform")) {
                sQueryParamsMap.put("device_platform", Consts.OS_NAME);
            }
            sQueryParamsMap.put("os", "Android");
            if (!sQueryParamsMap.containsKey("update_version_code")) {
                sQueryParamsMap.put("update_version_code", sHeader.optString("update_version_code"));
            }
            if (!sQueryParamsMap.containsKey("version_code")) {
                sQueryParamsMap.put("version_code", sHeader.optString("version_code"));
            }
            if (!sQueryParamsMap.containsKey("channel")) {
                sQueryParamsMap.put("channel", sHeader.optString("channel"));
            }
            if (!sQueryParamsMap.containsKey("os_api")) {
                sQueryParamsMap.put("os_api", Build.VERSION.SDK_INT + "");
            }
            if (isDebugMode() && !sQueryParamsMap.containsKey("_log_level")) {
                sQueryParamsMap.put("_log_level", "debug");
            }
            if (params == null) {
                params = new CommonParams();
            }
            params.setParamExtras(new HashMap(sQueryParamsMap));
        }
    }

    public static synchronized Map<String, String> getQueryParamsMap() {
        Map<String, String> queryParams;
        synchronized (ApmContext.class) {
            IQueryParams iQueryParams = sQueryParams;
            if (iQueryParams != null && (queryParams = iQueryParams.getQueryParams()) != null && queryParams.size() > 0) {
                HashMap hashMap = new HashMap(sQueryParamsMap);
                hashMap.putAll(queryParams);
                return hashMap;
            }
            return sQueryParamsMap;
        }
    }

    public static void setExceptionTrafficDetect(boolean z) {
        sExceptionTrafficDetect = z;
    }

    @Deprecated
    public static JSONObject getHeaderInner() {
        return sHeader;
    }

    public static JSONObject getHeader() {
        try {
            return new JSONObject(String.valueOf(sHeader));
        } catch (JSONException unused) {
            return new JSONObject();
        }
    }

    public static boolean extendHeader(String str, String str2) {
        if (sHeader == null || str.equals("release_build")) {
            return false;
        }
        try {
            sHeader.put(str, str2);
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    public static IDynamicParams getDynamicParams() {
        return sDynamicParams;
    }

    public static boolean isExceptionTrafficSwitchOn() {
        return sExceptionTrafficDetect;
    }

    public static IHttpService getHttpService() {
        return sHttpService;
    }

    public static HttpResponse doPost(String str, byte[] bArr, Map<String, String> map) throws Exception {
        return sHttpService.doPost(str, bArr, map);
    }

    public static HttpResponse doGet(String str, Map<String, String> map) throws Exception {
        return sHttpService.doGet(str, map);
    }

    public static HttpResponse uploadFiles(String str, List<File> list, Map<String, String> map) throws Exception {
        return sHttpService.uploadFiles(str, list, map);
    }

    public static IMultipartUploader buildMultipartUploader(String str, String str2, boolean z) throws Exception {
        return sHttpService.buildMultipartUpload(str, str2, z);
    }

    public static IMultipartUploader buildMultipartUploader(String str, String str2, boolean z, Map<String, String> map) throws Exception {
        return sHttpService.buildMultipartUpload(str, str2, z, map);
    }

    public static long getInitTimeStamp() {
        if (sInitTimeStamp == 0) {
            sInitTimeStamp = System.currentTimeMillis();
        }
        return sInitTimeStamp;
    }

    public static void setInitTimeStamp(long j) {
        sInitTimeStamp = j;
    }

    public static long getInitUpTimestamp() {
        return sStartupTimestamp;
    }

    public static void setInitUpTimestamp(long j) {
        sStartupTimestamp = j;
    }

    public static long getDeltaTime() {
        return System.currentTimeMillis() - SystemClock.uptimeMillis();
    }

    public static long getStartTimeStamp() {
        return sStartTimeStamp;
    }

    public static void setStartTimeStamp(long j) {
        sStartTimeStamp = j;
    }

    public static void setAppLaunchStartTimestamp(long j) {
        if (j <= 0) {
            return;
        }
        long j2 = sAppLaunchStartTimestamp;
        if (j2 == 0 || j < j2) {
            sAppLaunchStartTimestamp = j;
        }
    }

    public static long getAppLaunchStartTimestamp() {
        return sAppLaunchStartTimestamp;
    }

    public static boolean supportMultiFrameRate() {
        return sSupportMultiFrameRate;
    }

    public static void setSupportMultiFrameRate(boolean z) {
        sSupportMultiFrameRate = z;
    }

    public static long getInitCostTime() {
        return sInitCostTime;
    }

    public static long getInitCostTimeIncludingApm6() {
        return sInitCostTime6;
    }

    public static long getInitCostTimeStep2() {
        return sInitCostTimeStep2;
    }

    public static long getInitCostTimeStep3() {
        return sInitCostTimeStep3;
    }

    public static long getInitCostTimeStep4() {
        return sInitCostTimeStep4;
    }

    public static long getInitCostTimeStep5() {
        return sInitCostTimeStep5;
    }

    public static long getStartCostTime() {
        return sStartCostTime;
    }

    public static void setDeviceInfoOnPerfDataEnabled(boolean z) {
        sIsDeviceInfoOnPerfDataEnabled = z;
    }

    public static boolean isDeviceInfoOnPerfDataEnabled() {
        return sIsDeviceInfoOnPerfDataEnabled;
    }

    public static long getReportSeqNo() {
        long j = sReportSeqNo;
        sReportSeqNo = 1 + j;
        return j;
    }

    public static List<String> getSlardarConfigUrls() {
        return sSlardarConfigUrls;
    }

    public static void setSlardarConfigUrls(List<String> list) {
        sSlardarConfigUrls = list;
    }

    public static void setAlogFilesDir(String str) {
        sAlogFilesDir = str;
    }

    public static String getAlogFilesDir() {
        return sAlogFilesDir;
    }

    public static String getNetType() {
        String simpleName = sHttpService.getClass().getSimpleName();
        return "DefaultTTNetImpl".equals(simpleName) ? "ttnet" : simpleName;
    }
}
