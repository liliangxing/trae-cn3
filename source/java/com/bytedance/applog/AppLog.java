package com.bytedance.applog;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.applog.collector.NavigatorCallback;
import com.bytedance.applog.filter.AbstractEventFilter;
import com.bytedance.applog.filter.SamplingFilter;
import com.bytedance.applog.handler.IEventHandler;
import com.bytedance.applog.isolate.DataIsolateKey;
import com.bytedance.applog.isolate.IDataIsolateCallback;
import com.bytedance.applog.log.ConsoleLogProcessor;
import com.bytedance.applog.log.LogUtils;
import com.bytedance.applog.manager.ConfigManager;
import com.bytedance.applog.params.CommonParamsApi;
import com.bytedance.applog.strategy.IReportDropStrategy;
import com.bytedance.applog.task.BgSessionTaskCallback;
import com.bytedance.bdinstall.IBDInstallApi;
import com.bytedance.bdinstall.IExtraParams;
import com.bytedance.bdinstall.ILogger;
import com.bytedance.bdinstall.INetworkClient;
import com.bytedance.bdinstall.Level;
import com.bytedance.bdinstall.OnResetListener;
import com.bytedance.bdinstall.service.NUApi;
import java.net.Proxy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class AppLog {
    private static final IAppLogInstance gAppLogInstance = newInstance();
    private static volatile boolean gAppLogInstanceInitialized = false;

    public static IAppLogInstance getInstance() {
        return gAppLogInstance;
    }

    public static Context getContext() {
        return gAppLogInstance.getContext();
    }

    public static IAppLogInstance newInstance() {
        return new AppLogInstance();
    }

    public static void init(Context context, InitConfig initConfig) {
        synchronized (AppLog.class) {
            if (gAppLogInstanceInitialized) {
                Log.e(ConsoleLogProcessor.TAG, "Default AppLog is initialized, please new a instance by `AppLog.newInstance()`");
                return;
            }
            gAppLogInstanceInitialized = true;
            if (TextUtils.isEmpty(initConfig.getSpName())) {
                initConfig.setSpName(ConfigManager.SP_FILE);
            }
            gAppLogInstance.init(context, initConfig);
        }
    }

    public static void start() {
        gAppLogInstance.start();
    }

    public static void stop() {
        gAppLogInstance.stop();
    }

    public static boolean hasStarted() {
        return gAppLogInstance.hasStarted();
    }

    public static InitConfig getInitConfig() {
        return gAppLogInstance.getInitConfig();
    }

    @Deprecated
    public static void flush() {
        gAppLogInstance.flush();
    }

    public static void flushAsync() {
        gAppLogInstance.flushAsync();
    }

    public static void setUserID(long j) {
        gAppLogInstance.setUserID(j);
    }

    public static void setAppLanguageAndRegion(String str, String str2) {
        gAppLogInstance.setAppLanguageAndRegion(str, str2);
    }

    public static String addNetCommonParams(Context context, String str, boolean z, Level level) {
        return gAppLogInstance.addNetCommonParams(context, str, z, level);
    }

    public static String addNetCommonParams(Context context, StringBuilder sb, boolean z, Level level) {
        return gAppLogInstance.addNetCommonParams(context, sb, z, level);
    }

    public static void putCommonParams(Context context, Map<String, String> map, boolean z, Level level) {
        gAppLogInstance.putCommonParams(context, map, z, level);
    }

    public static void setUserUniqueID(String str) {
        gAppLogInstance.setUserUniqueID(str);
    }

    public static void setExtraParams(IExtraParams iExtraParams) {
        gAppLogInstance.setExtraParams(iExtraParams);
    }

    public static void setEventSenderEnable(boolean z, String str) {
        gAppLogInstance.setEventSenderEnable(z, str);
    }

    public static void setTouchPoint(String str) {
        gAppLogInstance.setTouchPoint(str);
    }

    public static void setHeaderInfo(HashMap<String, Object> hashMap) {
        gAppLogInstance.setHeaderInfo(hashMap);
    }

    public static void setHeaderInfo(String str, Object obj) {
        gAppLogInstance.setHeaderInfo(str, obj);
    }

    public static void removeHeaderInfo(String str) {
        gAppLogInstance.removeHeaderInfo(str);
    }

    public static void setExternalAbVersion(String str) {
        gAppLogInstance.setExternalAbVersion(str);
    }

    public static String getAbSdkVersion() {
        return gAppLogInstance.getAbSdkVersion();
    }

    @Deprecated
    public static String getAid() {
        return gAppLogInstance.getAid();
    }

    public static String getAppId() {
        return gAppLogInstance.getAppId();
    }

    public static <T> T getHeaderValue(String str, T t, Class<T> cls) {
        return (T) gAppLogInstance.getHeaderValue(str, t, cls);
    }

    public static void setUserAgent(String str) {
        gAppLogInstance.setUserAgent(str);
    }

    public static void onEvent(String str, String str2, String str3, long j, long j2, JSONObject jSONObject) {
        gAppLogInstance.onEvent(str, str2, str3, j, j2, jSONObject);
    }

    public static void onEvent(String str, String str2, String str3, long j, long j2) {
        gAppLogInstance.onEvent(str, str2, str3, j, j2);
    }

    public static void onEvent(String str, String str2) {
        gAppLogInstance.onEvent(str, str2);
    }

    public static void onEvent(String str) {
        gAppLogInstance.onEvent(str);
    }

    public static void onEventV3(String str) {
        gAppLogInstance.onEventV3(str);
    }

    public static void onEventV3(String str, JSONObject jSONObject) {
        gAppLogInstance.onEventV3(str, jSONObject);
    }

    public static void onEventV3(String str, Bundle bundle) {
        gAppLogInstance.onEventV3(str, bundle);
    }

    public static void onInternalEventV3(String str, JSONObject jSONObject, String str2, String str3, String str4) {
        gAppLogInstance.onInternalEventV3(str, jSONObject, str2, str3, str4);
    }

    public static void onInternalEventV3(String str, Bundle bundle, String str2, String str3, String str4) {
        gAppLogInstance.onInternalEventV3(str, bundle, str2, str3, str4);
    }

    public static void onMiscEvent(String str, JSONObject jSONObject) {
        gAppLogInstance.onMiscEvent(str, jSONObject);
    }

    public static void setEncryptAndCompress(boolean z) {
        gAppLogInstance.setEncryptAndCompress(z);
    }

    public static boolean getEncryptAndCompress() {
        return gAppLogInstance.getEncryptAndCompress();
    }

    public static boolean manualActivate() {
        return gAppLogInstance.manualActivate();
    }

    public static String getDid() {
        return gAppLogInstance.getDid();
    }

    public static void addSessionHook(ISessionObserver iSessionObserver) {
        gAppLogInstance.addSessionHook(iSessionObserver);
    }

    public static void removeSessionHook(ISessionObserver iSessionObserver) {
        gAppLogInstance.removeSessionHook(iSessionObserver);
    }

    public static void addEventObserver(int i, IEventObserver iEventObserver) {
        gAppLogInstance.addEventObserver(i, iEventObserver);
    }

    public static void addEventObserver(IEventObserver iEventObserver) {
        gAppLogInstance.addEventObserver(iEventObserver);
    }

    public static void removeEventObserver(IEventObserver iEventObserver) {
        gAppLogInstance.removeEventObserver(iEventObserver);
    }

    public static void setAccount(Account account) {
        gAppLogInstance.setAccount(account);
    }

    public static String getIid() {
        return gAppLogInstance.getIid();
    }

    public static String getSsid() {
        return gAppLogInstance.getSsid();
    }

    public static String getUserUniqueID() {
        return gAppLogInstance.getUserUniqueID();
    }

    public static String getUserID() {
        return gAppLogInstance.getUserID();
    }

    public static String getClientUdid() {
        return gAppLogInstance.getClientUdid();
    }

    public static String getOpenUdid() {
        return gAppLogInstance.getOpenUdid();
    }

    public static void setUriRuntime(UriConfig uriConfig) {
        gAppLogInstance.setUriRuntime(uriConfig);
    }

    public static boolean isNewUserMode(Context context) {
        return gAppLogInstance.isNewUserMode(context);
    }

    public static void setNewUserMode(Context context, boolean z) {
        gAppLogInstance.setNewUserMode(context, z);
    }

    public static NUApi newUserMode(Context context) {
        return gAppLogInstance.newUserMode(context);
    }

    public static boolean isNewUserModeAvailable() {
        return gAppLogInstance.isNewUserModeAvailable();
    }

    public static void getSsidGroup(Map<String, String> map) {
        gAppLogInstance.getSsidGroup(map);
    }

    public static void addDataObserver(IDataObserver iDataObserver) {
        gAppLogInstance.addDataObserver(iDataObserver);
    }

    public static void removeDataObserver(IDataObserver iDataObserver) {
        gAppLogInstance.removeDataObserver(iDataObserver);
    }

    public static void removeAllDataObserver() {
        gAppLogInstance.removeAllDataObserver();
    }

    public static INetworkClient getNetClient() {
        return gAppLogInstance.getNetClient();
    }

    public static JSONObject getHeader() {
        return gAppLogInstance.getHeader();
    }

    public static void setAppTrack(JSONObject jSONObject) {
        gAppLogInstance.setAppTrack(jSONObject);
    }

    public static boolean isNewUser() {
        return gAppLogInstance.isNewUser();
    }

    public static void onResume(Context context) {
        gAppLogInstance.onResume(context);
    }

    public static void onPause(Context context) {
        gAppLogInstance.onPause(context);
    }

    public static void onActivityResumed(Activity activity, int i) {
        gAppLogInstance.onActivityResumed(activity, i);
    }

    public static void onActivityResumed(String str, int i) {
        gAppLogInstance.onActivityResumed(str, i);
    }

    public static void onActivityPause() {
        gAppLogInstance.onActivityPause();
    }

    public static void registerHeaderCustomCallback(IHeaderCustomTimelyCallback iHeaderCustomTimelyCallback) {
        gAppLogInstance.registerHeaderCustomCallback(iHeaderCustomTimelyCallback);
    }

    public static IHeaderCustomTimelyCallback getHeaderCustomCallback() {
        return gAppLogInstance.getHeaderCustomCallback();
    }

    public static int getHttpMonitorPort() {
        return gAppLogInstance.getHttpMonitorPort();
    }

    public static void setHttpMonitorPort(int i) {
        gAppLogInstance.setHttpMonitorPort(i);
    }

    public static void setEventFilterByClient(List<String> list, boolean z) {
        gAppLogInstance.setEventFilterByClient(list, z);
    }

    public static AbstractEventFilter getEventFilterByClient() {
        return gAppLogInstance.getEventFilterByClient();
    }

    public static Map<String, String> getRequestHeader() {
        return gAppLogInstance.getRequestHeader();
    }

    public static String getSessionId() {
        return gAppLogInstance.getSessionId();
    }

    public static void registerAbSdkVersionCallback(IAbSdkVersion iAbSdkVersion) {
        gAppLogInstance.registerAbSdkVersionCallback(iAbSdkVersion);
    }

    public static void setEnableEventUserId(boolean z) {
        gAppLogInstance.setEnableEventUserId(z);
    }

    public static boolean getEnableEventUserId() {
        return gAppLogInstance.getEnableEventUserId();
    }

    public static void setBDAccountCallback(IBDAccountCallback iBDAccountCallback) {
        gAppLogInstance.setBDAccountCallback(iBDAccountCallback);
    }

    public static IBDAccountCallback getBDAccountCallback() {
        return gAppLogInstance.getBDAccountCallback();
    }

    public static void setTouristMode(boolean z) {
        gAppLogInstance.setTouristMode(z);
    }

    public static boolean isTouristMode() {
        return gAppLogInstance.isTouristMode();
    }

    public static void setEnableEventInTouristMode(boolean z) {
        gAppLogInstance.setEnableEventInTouristMode(z);
    }

    public static boolean isEnableEventInTouristMode() {
        return gAppLogInstance.isEnableEventInTouristMode();
    }

    public static boolean getAdjustTerminate() {
        return gAppLogInstance.getAdjustTerminate();
    }

    public static void setAdjustTerminate(boolean z) {
        gAppLogInstance.setAdjustTerminate(z);
    }

    public static void setEventSamplingEnable(boolean z) {
        gAppLogInstance.setEventSamplingEnable(z);
    }

    public static void setTeaEventSamplingEnable(boolean z) {
        gAppLogInstance.setTeaEventSamplingEnable(z);
    }

    public static void setDefaultHttpClientProxy(Proxy proxy) {
        gAppLogInstance.setDefaultHttpClientProxy(proxy);
    }

    public static void setEnableEventPriority(boolean z) {
        gAppLogInstance.setEnableEventPriority(z);
    }

    public static boolean isEnableEventPriority() {
        return gAppLogInstance.isEnableEventPriority();
    }

    public static void setGroupPriorityEnable(boolean z) {
        gAppLogInstance.setGroupPriorityEnable(z);
    }

    public static boolean isGroupPriorityEnabled() {
        return gAppLogInstance.isGroupPriorityEnabled();
    }

    public static void setAutoStartGroupPriority(boolean z) {
        gAppLogInstance.setAutoStartGroupPriority(z);
    }

    public static void initGroupPriority() {
        gAppLogInstance.initGroupPriority();
    }

    public static void setInsertByTransactionEnabled(boolean z) {
        gAppLogInstance.setInsertByTransactionEnabled(z);
    }

    public static void enableInsertCache(HashSet<String> hashSet, int i, int i2) {
        gAppLogInstance.enableInsertCache(hashSet, i, i2);
    }

    public static void disableInsertCache() {
        gAppLogInstance.disableInsertCache();
    }

    public static void clearWhenSwitchChildMode(boolean z) {
        gAppLogInstance.clearWhenSwitchChildMode(z);
    }

    public static void resetDidWhenSwitchChildMode(Context context, boolean z, long j, OnResetListener onResetListener) {
        gAppLogInstance.resetDidWhenSwitchChildMode(context, z, j, onResetListener);
    }

    public static void clearAndSetEnv() {
        gAppLogInstance.clearAndSetEnv();
    }

    public static void resetAndReInstall(long j, OnResetListener onResetListener) {
        gAppLogInstance.resetAndReInstall(j, onResetListener);
    }

    public static void setDisablePersonalization(int i) {
        gAppLogInstance.setDisablePersonalization(i);
    }

    public static Integer getDisablePersonalization() {
        return gAppLogInstance.getDisablePersonalization();
    }

    public static void setLogCompressor(ILogCompressor iLogCompressor) {
        gAppLogInstance.setLogCompressor(iLogCompressor);
    }

    public static ILogCompressor getLogCompressor() {
        return gAppLogInstance.getLogCompressor();
    }

    public static void addLaunchObserver(ILaunchObserver iLaunchObserver) {
        gAppLogInstance.addLaunchObserver(iLaunchObserver);
    }

    public static void removeLaunchObserver(ILaunchObserver iLaunchObserver) {
        gAppLogInstance.removeLaunchObserver(iLaunchObserver);
    }

    public static SamplingFilter getSamplingFilter() {
        return gAppLogInstance.getSamplingFilter();
    }

    public static void setDevToolsEnable(boolean z) {
        LogUtils.setEnable(z);
    }

    public static void setBgSessionReportOnPause(boolean z) {
        gAppLogInstance.setBgSessionReportOnPause(z);
    }

    public static void onBgSessionTaskResume() {
        gAppLogInstance.onBgSessionTaskResume();
    }

    public static void onBgSessionTaskPause() {
        gAppLogInstance.onBgSessionTaskPause();
    }

    public static void setBgSessionTaskEnabled(boolean z) {
        gAppLogInstance.setBgSessionTaskEnabled(z);
    }

    public static boolean isEnableBgSessionTask() {
        return gAppLogInstance.isEnableBgSessionTask();
    }

    public static void registerBgSessionTaskCallback(BgSessionTaskCallback bgSessionTaskCallback) {
        gAppLogInstance.registerTaskCallback(bgSessionTaskCallback);
    }

    public static void setBgSessionTaskNavigatorCallback(NavigatorCallback navigatorCallback) {
        gAppLogInstance.setBgSessionTaskNavigatorCallback(navigatorCallback);
    }

    public static void setDataIsolateEnabled(boolean z) {
        gAppLogInstance.setDataIsolateEnabled(z);
    }

    public static void setDataIsolateKey(DataIsolateKey dataIsolateKey) {
        gAppLogInstance.setDataIsolateKey(dataIsolateKey);
    }

    public static void setDataIsolateCallback(IDataIsolateCallback iDataIsolateCallback) {
        gAppLogInstance.setDataIsolateCallback(iDataIsolateCallback);
    }

    public static void setBatchProcessEventCount(int i) {
        gAppLogInstance.setBatchProcessEventCount(i);
    }

    public static void setBatchProcessInterval(int i) {
        gAppLogInstance.setBatchProcessInterval(i);
    }

    public static void setInsertEventOptEnabled(boolean z) {
        gAppLogInstance.setInsertEventOptEnabled(z);
    }

    public static void setExpectedBatchInterval(String str, String str2, int i) {
        gAppLogInstance.setExpectedBatchInterval(str, str2, i);
    }

    public static void setMigrateOldAppLogDataEnabled(boolean z) {
        gAppLogInstance.setMigrateOldAppLogDataEnabled(z);
    }

    public static void forceTimeoutReportSync(long j) {
        gAppLogInstance.forceTimeoutReportSync(j);
    }

    public static void setTerminateImmediately(boolean z) {
        gAppLogInstance.setTerminateImmediately(z);
    }

    public static void setMaxRequestOnceReport(int i) {
        gAppLogInstance.setMaxRequestOnceReport(i);
    }

    @Deprecated
    public static boolean isEventHitSamplingDrop(String str) {
        return gAppLogInstance.isEventHitStickySamplingDrop(str);
    }

    @Deprecated
    public static boolean isEventHitSamplingDrop(String str, JSONObject jSONObject) {
        return gAppLogInstance.isEventHitStickySamplingDrop(str, jSONObject);
    }

    public static boolean isEventHitStickySamplingDrop(String str) {
        return gAppLogInstance.isEventHitStickySamplingDrop(str);
    }

    public static boolean isEventHitStickySamplingDrop(String str, JSONObject jSONObject) {
        return gAppLogInstance.isEventHitStickySamplingDrop(str, jSONObject);
    }

    public static void setReportDropStrategy(IReportDropStrategy iReportDropStrategy) {
        gAppLogInstance.setReportDropStrategy(iReportDropStrategy);
    }

    public static void addLogReportMonitor(ILogReportMonitor iLogReportMonitor) {
        gAppLogInstance.addLogReportMonitor(iLogReportMonitor);
    }

    public static void setEventHandler(IEventHandler iEventHandler) {
        gAppLogInstance.setEventHandler(iEventHandler);
    }

    public static void setEventForwardEnabled(boolean z) {
        gAppLogInstance.setEventForwardEnabled(z);
    }

    public static void setEventForwardHttpHeader(String str, String str2) {
        gAppLogInstance.setEventForwardHttpHeader(str, str2);
    }

    public static void setMaxCacheEventNum(int i) {
        gAppLogInstance.setMaxCacheEventNum(i);
    }

    public static void setPackLaunchByDesc(boolean z) {
        gAppLogInstance.setPackLaunchByDesc(z);
    }

    public static void setBDInstallEventTrackEnabled(boolean z) {
        gAppLogInstance.setBDInstallEventTrackEnabled(z);
    }

    public static void setTrackResumeEvent(boolean z) {
        gAppLogInstance.setTrackResumeEvent(z);
    }

    public static void setNewMonitorEnabled(boolean z) {
        gAppLogInstance.setNewMonitorEnabled(z);
    }

    public static void setNewMonitorInDebugMode(boolean z) {
        gAppLogInstance.setNewMonitorInDebugMode(z);
    }

    public static void setFlushAsyncDefault(boolean z) {
        gAppLogInstance.setFlushAsyncDefault(z);
    }

    public static void setFlushThresholdEnable(boolean z) {
        gAppLogInstance.setFlushThresholdEnable(z);
    }

    public static void blockHeaderKey(String str) {
        gAppLogInstance.blockHeaderKey(str);
    }

    public static void allowHeaderKey(String str) {
        gAppLogInstance.allowHeaderKey(str);
    }

    public static void setEventParamControlEnabled(boolean z) {
        gAppLogInstance.setEventParamControlEnabled(z);
    }

    public static void setCustomHeaderControlEnabled(boolean z) {
        gAppLogInstance.setCustomHeaderControlEnabled(z);
    }

    public static void addRegisterCustomHeader(Context context, JSONObject jSONObject) {
        gAppLogInstance.addRegisterCustomHeader(context, jSONObject);
    }

    public static IBDInstallApi getBDInstallApi() {
        return gAppLogInstance.getBDInstallApi();
    }

    public static void setNavigatorCallback(NavigatorCallback navigatorCallback) {
        gAppLogInstance.setNavigatorCallback(navigatorCallback);
    }

    public static void setCommonParamsEnabled(boolean z) {
        gAppLogInstance.setCommonParamsEnabled(z);
    }

    public static CommonParamsApi getCommonParams() {
        return gAppLogInstance.getCommonParams();
    }

    public static void setLogger(ILogger iLogger) {
        gAppLogInstance.setLogger(iLogger);
    }

    public static void setPageInfoEnabled(boolean z) {
        gAppLogInstance.setPageInfoEnabled(z);
    }

    public static void setPageId(String str) {
        gAppLogInstance.setPageId(str);
    }

    public static void setPageName(String str) {
        gAppLogInstance.setPageName(str);
    }

    public static void setServerFilterByNative(boolean z) {
        gAppLogInstance.setServerFilterByNative(z);
    }

    public static void setServerFilterSaveToKeva(boolean z) {
        gAppLogInstance.setServerFilterSaveToKeva(z);
    }
}
