package com.ss.android.common.applog;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.applog.IBDAccountCallback;
import com.bytedance.applog.ILogCompressor;
import com.service.middleware.applog.IHeaderCustomTimelyCallback;
import com.ss.android.common.AppContext;
import com.ss.android.common.applog.AppLog;
import com.ss.android.common.applog.LogTrace;
import com.ss.android.common.applog.UserProfileHelper;
import com.ss.android.common.applog.task.TaskCallback;
import com.ss.android.common.util.ILogger;
import com.ss.android.deviceregister.DeviceCategory;
import com.ss.android.deviceregister.OnResetListener;
import com.ss.android.deviceregister.SensitiveApiCallback;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public interface IAppLogApi {
    void activeUser(Context context);

    void addAppCount();

    void addLaunchObserver(ILaunchObserver iLaunchObserver);

    void addSessionHook(AppLog.ILogSessionHook iLogSessionHook);

    int checkHttpRequestException(Throwable th, String[] strArr);

    void clearWhenSwitchChildMode(boolean z);

    void flush();

    String getAbSDKVersion();

    String getAppVersionMinor();

    String getClientId();

    String getCurrentSessionId();

    int getEncodeType();

    JSONObject getHeaderCopy();

    int getHttpMonitorPort();

    IHeaderCustomTimelyCallback getIHeaderCustomTimelyCallback();

    String getInstallId();

    AppLog getInstance(Context context);

    long getLastActiveTime();

    ILogCompressor getLogCompressor();

    void getSSIDs(Map<String, String> map);

    String getServerDeviceId();

    String getSessionKey();

    String getSigHash(Context context);

    JSONObject getTimeSync();

    String getUserId();

    String getUserUniqueId();

    String getVersion(Context context);

    void init(Context context, boolean z, UrlConfig urlConfig);

    boolean isBadDeviceId(String str);

    boolean isEnableNetCommOpt();

    boolean isHitStickySamplingDrop(String str);

    boolean isHitStickySamplingDrop(String str, JSONObject jSONObject);

    boolean isNewUser();

    void onActivityCreate(Context context);

    void onActivityCreate(String str);

    void onAppQuit();

    void onEvent(Context context, String str, String str2, String str3, long j, long j2, boolean z, JSONObject jSONObject);

    void onImageFailure();

    void onImageFailure(String str, int i, int i2);

    void onImageSample(String str, int i, long j);

    void onImageSuccess();

    void onPause(Context context);

    void onPause(Context context, String str, int i);

    void onQuit();

    void onResume(Context context);

    void onResume(Context context, String str, int i);

    void onTaskPause(Context context);

    void onTaskResume(Context context);

    void recordMiscLog(Context context, String str, JSONObject jSONObject);

    void registerAbSdkVersionCallback(AppLog.IAbSdkVersion iAbSdkVersion);

    void registerGlobalEventCallback(GlobalEventCallback globalEventCallback);

    void registerHeaderCustomCallback(IHeaderCustomTimelyCallback iHeaderCustomTimelyCallback);

    void registerLogRequestCallback(LogTrace.LogRequestTraceCallback logRequestTraceCallback);

    void registerTaskCallback(TaskCallback taskCallback);

    void removeLaunchObserver(ILaunchObserver iLaunchObserver);

    void removeSessionHook(AppLog.ILogSessionHook iLogSessionHook);

    void resetDidWhenSwitchChildMode(Context context, boolean z, long j, OnResetListener onResetListener);

    void setAbSDKVersion(String str);

    void setAdjustTerminate(boolean z);

    void setAliYunHanlder(IAliYunHandler iAliYunHandler);

    void setAllowPushService(int i, int i2);

    void setAnonymous(boolean z);

    void setAppContext(AppContext appContext);

    void setAppLanguageAndRegion(String str, String str2);

    void setAppTrack(JSONObject jSONObject);

    void setAppVersionMinor(String str);

    void setBDAccountCallback(IBDAccountCallback iBDAccountCallback);

    void setChildModeBeforeInit(boolean z);

    void setCollectFreeSpace(boolean z, AppLog.FreeSpaceCollector freeSpaceCollector);

    void setConfigUpdateListener(AppLog.ConfigUpdateListener configUpdateListener);

    void setConfigUpdateListener(AppLog.ConfigUpdateListenerEnhanced configUpdateListenerEnhanced);

    void setCustomInfo(AppLog.ICustomInfo iCustomInfo);

    void setCustomerHeader(Bundle bundle);

    void setDBNamme(String str);

    void setDefaultUserAgent(String str);

    void setDeviceCategory(DeviceCategory deviceCategory);

    void setDisablePersonalization(int i);

    void setEgdiRetryInterval(int i);

    void setEnableEventInTouristMode(boolean z);

    void setEnableEventUserId(boolean z);

    void setEnableGetEgdi(boolean z);

    void setEnableMigrate(boolean z);

    void setEnableNetCommOpt(boolean z);

    void setEncryptCountSPName(String str);

    void setEventFilterByClient(List<String> list, boolean z);

    void setEventFilterEnable(Context context, int i);

    void setEventSamplingEnable(boolean z);

    void setHttpMonitorPort(int i);

    void setIsMainProcess(boolean z);

    void setLogCompressor(ILogCompressor iLogCompressor);

    void setLogEncryptConfig(AppLog.ILogEncryptConfig iLogEncryptConfig);

    void setLogger(ILogger iLogger);

    void setMyPushIncludeValues(boolean z);

    void setNewMonitorEnabled(boolean z);

    void setPushCustomValues(boolean z, boolean z2, boolean z3, boolean z4);

    void setSPName(String str);

    void setSensitiveApiCallback(SensitiveApiCallback sensitiveApiCallback);

    void setSessionKey(String str);

    void setStartLogReaperDelay(long j);

    void setTeaEventSamplingEnable(boolean z);

    void setTerminateImmediately(boolean z);

    void setTouristMode(boolean z);

    void setUseGoogleAdId(boolean z);

    void setUserId(long j);

    void setUserIdIsolateCallback(UserIdIsolateCallback userIdIsolateCallback);

    void setUserIdIsolateEnabled(boolean z);

    void setUserUniqueId(String str);

    void userProfileCheck(UserProfileHelper.UserProfileCheckCallback userProfileCheckCallback);
}
