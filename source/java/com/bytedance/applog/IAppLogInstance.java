package com.bytedance.applog;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.applog.collector.NavigatorCallback;
import com.bytedance.applog.filter.AbstractEventFilter;
import com.bytedance.applog.filter.SamplingFilter;
import com.bytedance.applog.handler.IEventHandler;
import com.bytedance.applog.isolate.DataIsolateKey;
import com.bytedance.applog.isolate.IDataIsolateCallback;
import com.bytedance.applog.monitor.p006v3.MonitorV3Helper;
import com.bytedance.applog.params.CommonParamsApi;
import com.bytedance.applog.store.BaseData;
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
public interface IAppLogInstance {
    void addDataObserver(IDataObserver iDataObserver);

    void addEventObserver(int i, IEventObserver iEventObserver);

    void addEventObserver(IEventObserver iEventObserver);

    void addLaunchObserver(ILaunchObserver iLaunchObserver);

    void addLogReportMonitor(ILogReportMonitor iLogReportMonitor);

    String addNetCommonParams(Context context, String str, boolean z, Level level);

    String addNetCommonParams(Context context, StringBuilder sb, boolean z, Level level);

    void addRegisterCustomHeader(Context context, JSONObject jSONObject);

    void addSessionHook(ISessionObserver iSessionObserver);

    void allowHeaderKey(String str);

    void blockHeaderKey(String str);

    void clearAndSetEnv();

    int clearEngineDataListIfCacheTooLarge();

    void clearWhenSwitchChildMode(boolean z);

    void destroy();

    void disableInsertCache();

    void enableInsertCache(HashSet<String> hashSet, int i, int i2);

    void flush();

    void flushAsync();

    void forceTimeoutReportSync(long j);

    String getAbSdkVersion();

    boolean getAdjustTerminate();

    String getAid();

    String getAppId();

    IBDAccountCallback getBDAccountCallback();

    IBDInstallApi getBDInstallApi();

    String getClientUdid();

    CommonParamsApi getCommonParams();

    Context getContext();

    IDataIsolateCallback getDataIsolateCallback();

    DataIsolateKey getDataIsolateKey();

    String getDid();

    Integer getDisablePersonalization();

    boolean getEnableEventUserId();

    boolean getEncryptAndCompress();

    AbstractEventFilter getEventFilterByClient();

    JSONObject getExpectedBatchInterval();

    JSONObject getHeader();

    IHeaderCustomTimelyCallback getHeaderCustomCallback();

    <T> T getHeaderValue(String str, T t, Class<T> cls);

    int getHttpMonitorPort();

    String getIid();

    InitConfig getInitConfig();

    int getLaunchFrom();

    ILogCompressor getLogCompressor();

    JSONObject getLogback();

    MonitorV3Helper getMonitorHelper();

    INetworkClient getNetClient();

    String getOpenUdid();

    Map<String, String> getRequestHeader();

    SamplingFilter getSamplingFilter();

    String getSdkVersion();

    String getSessionId();

    String getSsid();

    void getSsidGroup(Map<String, String> map);

    String getUserID();

    String getUserUniqueID();

    boolean hasStarted();

    void init(Context context, InitConfig initConfig);

    void initGroupPriority();

    boolean isDataIsolateEnabled();

    boolean isEnableBgSessionTask();

    boolean isEnableEventInTouristMode();

    boolean isEnableEventPriority();

    boolean isEventHitStickySamplingDrop(String str);

    boolean isEventHitStickySamplingDrop(String str, JSONObject jSONObject);

    boolean isGroupPriorityEnabled();

    boolean isInsertEventOptEnabled();

    boolean isNewUser();

    boolean isNewUserMode(Context context);

    boolean isNewUserModeAvailable();

    boolean isTouristMode();

    boolean manualActivate();

    NUApi newUserMode(Context context);

    void onActivityPause();

    void onActivityResumed(Activity activity, int i);

    void onActivityResumed(String str, int i);

    void onBgSessionTaskPause();

    void onBgSessionTaskResume();

    void onEvent(String str);

    void onEvent(String str, String str2);

    void onEvent(String str, String str2, String str3, long j, long j2);

    void onEvent(String str, String str2, String str3, long j, long j2, JSONObject jSONObject);

    void onEventString(String str, String str2, String str3, long j, long j2, String str4);

    void onEventV3(String str);

    void onEventV3(String str, Bundle bundle);

    void onEventV3(String str, JSONObject jSONObject);

    void onEventV3String(String str, String str2);

    void onInternalEventV3(String str, Bundle bundle, String str2, String str3, String str4);

    void onInternalEventV3(String str, JSONObject jSONObject, String str2, String str3, String str4);

    void onMiscEvent(String str, JSONObject jSONObject);

    void onPause(Context context);

    void onResume(Context context);

    void putCommonParams(Context context, Map<String, String> map, boolean z, Level level);

    void receive(BaseData baseData);

    void receive(String[] strArr);

    void registerAbSdkVersionCallback(IAbSdkVersion iAbSdkVersion);

    void registerHeaderCustomCallback(IHeaderCustomTimelyCallback iHeaderCustomTimelyCallback);

    void registerTaskCallback(BgSessionTaskCallback bgSessionTaskCallback);

    void removeAllDataObserver();

    void removeDataObserver(IDataObserver iDataObserver);

    void removeEventObserver(IEventObserver iEventObserver);

    void removeHeaderInfo(String str);

    void removeLaunchObserver(ILaunchObserver iLaunchObserver);

    void removeSessionHook(ISessionObserver iSessionObserver);

    void resetAndReInstall(long j, OnResetListener onResetListener);

    void resetDidWhenSwitchChildMode(Context context, boolean z, long j, OnResetListener onResetListener);

    void setAccount(Account account);

    void setAdjustTerminate(boolean z);

    void setAppLanguageAndRegion(String str, String str2);

    void setAppTrack(JSONObject jSONObject);

    void setAutoStartGroupPriority(boolean z);

    void setBDAccountCallback(IBDAccountCallback iBDAccountCallback);

    void setBDInstallEventTrackEnabled(boolean z);

    void setBatchProcessEventCount(int i);

    void setBatchProcessInterval(int i);

    void setBgSessionReportOnPause(boolean z);

    void setBgSessionTaskEnabled(boolean z);

    void setBgSessionTaskNavigatorCallback(NavigatorCallback navigatorCallback);

    void setCommonParamsEnabled(boolean z);

    void setCustomHeaderControlEnabled(boolean z);

    void setDataIsolateCallback(IDataIsolateCallback iDataIsolateCallback);

    void setDataIsolateEnabled(boolean z);

    void setDataIsolateKey(DataIsolateKey dataIsolateKey);

    void setDefaultHttpClientProxy(Proxy proxy);

    void setDisablePersonalization(int i);

    void setEnableEventInTouristMode(boolean z);

    void setEnableEventPriority(boolean z);

    void setEnableEventUserId(boolean z);

    void setEncryptAndCompress(boolean z);

    void setEventFilterByClient(List<String> list, boolean z);

    void setEventForwardEnabled(boolean z);

    void setEventForwardHttpHeader(String str, String str2);

    void setEventHandler(IEventHandler iEventHandler);

    void setEventParamControlEnabled(boolean z);

    void setEventSamplingEnable(boolean z);

    void setEventSenderEnable(boolean z, String str);

    void setExpectedBatchInterval(String str, String str2, int i);

    void setExternalAbVersion(String str);

    void setExtraParams(IExtraParams iExtraParams);

    void setFlushAsyncDefault(boolean z);

    void setFlushThresholdEnable(boolean z);

    void setGroupPriorityEnable(boolean z);

    void setHeaderInfo(String str, Object obj);

    void setHeaderInfo(HashMap<String, Object> hashMap);

    void setHttpMonitorPort(int i);

    void setInsertByTransactionEnabled(boolean z);

    void setInsertEventOptEnabled(boolean z);

    void setLaunchFrom(int i);

    void setLogCompressor(ILogCompressor iLogCompressor);

    void setLogger(ILogger iLogger);

    void setMaxCacheEventNum(int i);

    void setMaxRequestOnceReport(int i);

    void setMigrateOldAppLogDataEnabled(boolean z);

    void setNavigatorCallback(NavigatorCallback navigatorCallback);

    void setNewMonitorEnabled(boolean z);

    void setNewMonitorInDebugMode(boolean z);

    void setNewUserMode(Context context, boolean z);

    void setPackLaunchByDesc(boolean z);

    void setPageId(String str);

    void setPageInfoEnabled(boolean z);

    void setPageName(String str);

    void setReportDropStrategy(IReportDropStrategy iReportDropStrategy);

    void setServerFilterByNative(boolean z);

    void setServerFilterSaveToKeva(boolean z);

    void setTeaEventSamplingEnable(boolean z);

    void setTerminateImmediately(boolean z);

    void setTouchPoint(String str);

    void setTouristMode(boolean z);

    void setTrackResumeEvent(boolean z);

    void setUriRuntime(UriConfig uriConfig);

    void setUserAgent(String str);

    void setUserID(long j);

    void setUserUniqueID(String str);

    void start();

    void stop();
}
