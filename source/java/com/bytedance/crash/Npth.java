package com.bytedance.crash;

import android.app.Application;
import android.content.Context;
import com.bytedance.crash.NpthApi;
import com.bytedance.crash.alog.AlogManager;
import com.bytedance.crash.alog.IALogCrashObserver;
import com.bytedance.crash.alog.IAlogUploadStrategy;
import com.bytedance.crash.anr.AnrManager;
import com.bytedance.crash.config.BitsConfig;
import com.bytedance.crash.config.InnerAppMonitorConfigService;
import com.bytedance.crash.config.NpthBuildConfig;
import com.bytedance.crash.crash.CrashManager;
import com.bytedance.crash.crash.CrashSummary;
import com.bytedance.crash.crash.JavaCrashHandler;
import com.bytedance.crash.diagnose.InitMonitor;
import com.bytedance.crash.dumper.BytestConfig;
import com.bytedance.crash.dumper.EvilDumpFile;
import com.bytedance.crash.dumper.InnerCrashBodyDumper;
import com.bytedance.crash.event.BizException;
import com.bytedance.crash.event.BizExceptionManager;
import com.bytedance.crash.event.EnsureConfig;
import com.bytedance.crash.event.EnsureDeliverer;
import com.bytedance.crash.event.EventConfig;
import com.bytedance.crash.event.IGetBizException;
import com.bytedance.crash.java.CrashIgnoreHandler;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.mira.NpthMiraApi;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.AppMonitorConfigService;
import com.bytedance.crash.monitor.EventMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.outer.CustomActivity;
import com.bytedance.crash.plugin.PluginInfoManager;
import com.bytedance.crash.protector.CrashProtector;
import com.bytedance.crash.repair.RepairAdapter;
import com.bytedance.crash.runtime.AllDefaultUrls;
import com.bytedance.crash.runtime.ConfigManager;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.runtime.ILogcatImpl;
import com.bytedance.crash.service.IHttpUrlConnectionInterceptor;
import com.bytedance.crash.service.INetworkCallback;
import com.bytedance.crash.service.IRequestHeaderProvider;
import com.bytedance.crash.soloader.NpthSoData;
import com.bytedance.crash.terminate.CrashAccessibilityMonitor;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.crash.upload.CrashUploader;
import com.bytedance.crash.upload.IRequestIntercept;
import com.bytedance.crash.upload.IRequestPermission;
import com.bytedance.crash.upload.LaunchScanner;
import com.bytedance.crash.util.App;
import com.bytedance.crash.util.JSONUtils;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class Npth {
    private static final UserDataCenter sCachedDataCenter = MonitorManager.getAppMonitorUserDataCenter();

    @Deprecated
    public static long getFileSize(String str) {
        return 0L;
    }

    @Deprecated
    public static long getFolderSize(String str) {
        return 0L;
    }

    @Deprecated
    public static boolean hasCrashWhenNativeCrash() {
        return false;
    }

    @Deprecated
    public static void openANRMonitor() {
    }

    @Deprecated
    public static void openJavaCrashMonitor() {
    }

    @Deprecated
    public static boolean openNativeCrashMonitor() {
        return false;
    }

    @Deprecated
    public static void registerCrashCallbackOnDrop(CrashCallbackEx crashCallbackEx, CrashType crashType) {
    }

    @Deprecated
    public static void setANRCheckEnable(boolean z) {
    }

    @Deprecated
    public static void setAlogFlushAddr(long j) {
    }

    @Deprecated
    public static void setAlogLogDirAddr(long j) {
    }

    @Deprecated
    public static void setAlogWriteAddr(long j) {
    }

    @Deprecated
    public static void setInitAnrAhead(boolean z) {
    }

    public static void setTerminateMonitorDelayTime(long j) {
    }

    @Deprecated
    public static void stopEnsure() {
    }

    @Deprecated
    public static void stopUpload() {
    }

    public static synchronized void init(Context context, ICommonParams iCommonParams) {
        synchronized (Npth.class) {
            if (isInit()) {
                return;
            }
            InitMonitor.start();
            final AppMonitor createInnerAppMonitor = MonitorManager.createInnerAppMonitor(context, iCommonParams);
            createInnerAppMonitor.registerBodyHeaderDumper(new InnerCrashBodyDumper(iCommonParams));
            DefaultNpthApiImpl.registerImplObject();
            DefaultWorkThread.post(new Runnable() { // from class: com.bytedance.crash.Npth.1
                @Override // java.lang.Runnable
                public void run() {
                    new InnerAppMonitorConfigService(AppMonitor.this).init();
                }
            });
            InitMonitor.end();
        }
    }

    public static synchronized void init(Context context, ICommonParams iCommonParams, boolean z, boolean z2, boolean z3) {
        synchronized (Npth.class) {
            init(context, iCommonParams, z, z, z2, z3);
        }
    }

    public static synchronized void init(Context context, ICommonParams iCommonParams, boolean z, boolean z2, boolean z3, boolean z4) {
        synchronized (Npth.class) {
            init(context, iCommonParams, z, z2, z3, z4, 0L);
        }
    }

    public static synchronized void init(Context context, ICommonParams iCommonParams, boolean z, boolean z2, boolean z3, boolean z4, long j) {
        synchronized (Npth.class) {
            init(null, context, iCommonParams, z, z2, z3, z4, j);
        }
    }

    public static synchronized void init(Application application, Context context, ICommonParams iCommonParams, boolean z, boolean z2, boolean z3, boolean z4, long j) {
        synchronized (Npth.class) {
            init(context, iCommonParams);
        }
    }

    public static synchronized EventMonitor initSDK(Context context, String str, int i, long j, String str2) {
        EventMonitor createEventMonitor;
        synchronized (Npth.class) {
            createEventMonitor = MonitorManager.createEventMonitor(context, str, i, j, str2);
        }
        return createEventMonitor;
    }

    public static synchronized void initMiniApp(Context context, ICommonParams iCommonParams) {
        synchronized (Npth.class) {
            NpthCore.setCurrentMiniAppProcess(true);
            init(context, iCommonParams, true, false, true, true);
        }
    }

    public static synchronized void initMiniApp(Context context, ICommonParams iCommonParams, int i, String str) {
        synchronized (Npth.class) {
            NpthCore.setCurrentMiniAppProcess(true);
            NpthCore.registerMiniApp(i, str);
            init(context, iCommonParams, true, true, true, true);
        }
    }

    public static boolean isJavaCrashEnable() {
        return NpthCore.isInit();
    }

    public static boolean isANREnable() {
        return NpthCore.isInit();
    }

    public static boolean isNativeCrashEnable() {
        return NpthCore.isInit();
    }

    public static boolean isInit() {
        return MonitorManager.getAppMonitor() != null;
    }

    public static void setCurProcessName(String str) {
        App.setCurProcessName(str);
    }

    public static void setApplication(Application application) {
        if (application != null) {
            Global.setApplication(application);
        }
    }

    @Deprecated
    public static void setAnrInfoFileObserver(String str, IFileContentGetter iFileContentGetter) {
        NpthCore.setAnrInfoFileObserver(str, iFileContentGetter);
    }

    @Deprecated
    public static void setLogcatImpl(ILogcatImpl iLogcatImpl) {
        NpthCore.setLogcatImpl(iLogcatImpl);
    }

    public static boolean isRunning() {
        return NpthCore.isAnrThreadRunning();
    }

    public static void reportDartError(String str) {
        NpthCore.reportDartError(str);
    }

    public static void reportDartError(String str, Map<? extends String, ? extends String> map, Map<String, String> map2, IUploadCallback iUploadCallback) {
        NpthCore.reportDartError(str, map, map2, iUploadCallback);
    }

    public static void reportGameException(String str, String str2, String str3) {
        NpthCore.reportGameException(str, str2, str3);
    }

    public static ConfigManager getConfigManager() {
        return NpthBus.getConfigManager();
    }

    public static void scanNativeCrash(Context context, CrashCallbackEx crashCallbackEx, String[] strArr) {
        List<CrashSummary> nativeCrashList = CrashManager.getNativeCrashList(context);
        if (nativeCrashList == null) {
            return;
        }
        for (CrashSummary crashSummary : nativeCrashList) {
            if (crashSummary != null) {
                crashCallbackEx.onCrash(0, null, crashSummary.getCrashType(), crashSummary.getStartTime(), crashSummary.getCrashTime(), crashSummary.getProcessName(), crashSummary.getStackTrace(), null, null);
            }
        }
    }

    public static void addImportTags(Map<? extends String, ? extends String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        TagService.addImportTags(map);
    }

    public static void addImportTag(String str, String str2) {
        TagService.addImportTag(str, str2);
    }

    public static void removeImportTag(String str) {
        TagService.removeImportTag(str);
    }

    public static void addTags(Map<? extends String, ? extends String> map) {
        TagService.addTags(map, sCachedDataCenter);
    }

    public static void addTag(String str, String str2) {
        TagService.addTag(str, str2, sCachedDataCenter);
    }

    public static void removeTag(String str) {
        TagService.remove(str, sCachedDataCenter);
    }

    public static void registerCrashCallback(ICrashCallback iCrashCallback, CrashType crashType) {
        sCachedDataCenter.addCrashCallback(iCrashCallback, crashType);
    }

    public static void registerCrashInfoCallback(CrashInfoCallback crashInfoCallback, CrashType crashType) {
        sCachedDataCenter.addCrashInfoCallback(crashInfoCallback, crashType);
    }

    public static void registerANRCallback(IANRCallback iANRCallback) {
        sCachedDataCenter.addANRCallback(iANRCallback);
    }

    public static void registerOOMCallback(IOOMCallback iOOMCallback) {
        sCachedDataCenter.addOOMCallback(iOOMCallback);
    }

    public static void registerHprofCallback(IOOMCallback iOOMCallback) {
        sCachedDataCenter.addHprofCallback(iOOMCallback);
    }

    public static void unregisterCrashCallback(ICrashCallback iCrashCallback, CrashType crashType) {
        sCachedDataCenter.removeCrashCallback(iCrashCallback, crashType);
    }

    public static void unregisterOOMCallback(IOOMCallback iOOMCallback, CrashType crashType) {
        sCachedDataCenter.removeOOMCallback(iOOMCallback);
    }

    public static void unregisterHprofCallback(IOOMCallback iOOMCallback, CrashType crashType) {
        sCachedDataCenter.removeHprofCallback(iOOMCallback);
    }

    public static void setCrashFilter(ICrashFilter iCrashFilter) {
        sCachedDataCenter.setCrashFilter(iCrashFilter);
    }

    public static void addAttachUserData(AttachUserData attachUserData, CrashType crashType) {
        sCachedDataCenter.addAttachUserData(attachUserData, crashType);
    }

    public static void addAttachLongUserData(AttachUserData attachUserData, CrashType crashType) {
        sCachedDataCenter.addAttachUserData(attachUserData, crashType);
    }

    public static void removeAttachUserData(AttachUserData attachUserData, CrashType crashType) {
        sCachedDataCenter.removeAttachUserData(crashType, attachUserData);
    }

    public static void removeAttachLongUserData(AttachUserData attachUserData, CrashType crashType) {
        sCachedDataCenter.removeAttachUserData(crashType, attachUserData);
    }

    public static void registerSdk(int i, String str) {
        sCachedDataCenter.registerSdkInfo(i, str);
    }

    public static void registerSdk(String str, String str2) {
        sCachedDataCenter.registerInnerSdkInfo(str, str2);
    }

    public static void addUserCrashInfoCallback(IUserCrashInfoCallback iUserCrashInfoCallback, CrashType crashType) {
        if (iUserCrashInfoCallback != null) {
            sCachedDataCenter.addUserCrashInfoCallback(iUserCrashInfoCallback, crashType);
        }
    }

    public static void removeCrashInfoCallback(IUserCrashInfoCallback iUserCrashInfoCallback, CrashType crashType) {
        if (iUserCrashInfoCallback != null) {
            sCachedDataCenter.removeUserCrashInfoCallback(iUserCrashInfoCallback, crashType);
        }
    }

    public static void setScriptStackCallback(IScriptCallback iScriptCallback) {
        NpthCore.setScriptStackCallback(iScriptCallback);
    }

    public static void stopAnr() {
        NpthCore.stopAnr();
    }

    public static void setRequestIntercept(IRequestIntercept iRequestIntercept) {
        NpthCore.setRequestIntercept(iRequestIntercept);
    }

    public static void setAlogFlushV2Addr(long j) {
        AlogManager.setAlogFlushFunction(j);
    }

    public static void enableALogCollector(String str, IALogCrashObserver iALogCrashObserver, IAlogUploadStrategy iAlogUploadStrategy) {
        NpthCore.enableALogCollector(str, iALogCrashObserver, iAlogUploadStrategy);
    }

    public static boolean hasCrash() {
        return NpthCore.hasCrash();
    }

    public static void enableGwpAsan(boolean z) {
        if (z) {
            NpthCore.EnableGwpAsan();
        }
    }

    public static void setEncryptImpl(IEncrypt iEncrypt) {
        NpthCore.setEncryptImpl(iEncrypt);
    }

    public static void customActivityName(CustomActivity customActivity) {
        ActivityLifecycle.setCustomActivity(customActivity);
    }

    @Deprecated
    public static void reportError(Throwable th) {
        NpthCore.reportError(th);
    }

    @Deprecated
    public static void reportError(String str) {
        NpthCore.reportError(str);
    }

    @Deprecated
    public static void setAttachUserData(AttachUserData attachUserData, CrashType crashType) {
        addAttachUserData(attachUserData, crashType);
    }

    public static void dumpHprof(String str) {
        NativeBridge.dumpHprof(str);
    }

    @Deprecated
    public static boolean isStopUpload() {
        return NpthCore.isStopUpload();
    }

    @Deprecated
    public static void setBusiness(String str) {
        Global.setBusiness(str);
    }

    public static void setRequestPermission(IRequestPermission iRequestPermission) {
        CrashUploader.setRequestPermission(iRequestPermission);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class DefaultNpthApiImpl extends NpthApi {
        @Override // com.bytedance.crash.NpthApi
        protected void uploadKilledHistoryInner() {
        }

        DefaultNpthApiImpl() {
        }

        @Override // com.bytedance.crash.NpthApi
        protected void addCustomInner(final NpthApi.CustomDataCallback customDataCallback) {
            Npth.addAttachUserData(new AttachUserData() { // from class: com.bytedance.crash.Npth.DefaultNpthApiImpl.1
                @Override // com.bytedance.crash.AttachUserData
                public Map<? extends String, ? extends String> getUserData(CrashType crashType) {
                    return customDataCallback.getData();
                }
            }, CrashType.ALL);
        }

        @Override // com.bytedance.crash.NpthApi
        protected void addCustomInner(final NpthApi.CustomDataCallback customDataCallback, String str) {
            for (CrashType crashType : CrashType.values()) {
                if (crashType.getName().equals(str)) {
                    Npth.addAttachUserData(new AttachUserData() { // from class: com.bytedance.crash.Npth.DefaultNpthApiImpl.2
                        @Override // com.bytedance.crash.AttachUserData
                        public Map<? extends String, ? extends String> getUserData(CrashType crashType2) {
                            return customDataCallback.getData();
                        }
                    }, crashType);
                    return;
                }
            }
        }

        @Override // com.bytedance.crash.NpthApi
        protected void addANRInfoCallbackInner(final NpthApi.IANRInfoCallback iANRInfoCallback) {
            if (iANRInfoCallback == null) {
                return;
            }
            Npth.addTag("has_register_evil_callback", String.valueOf(true));
            EvilDumpFile.setANRCallback(new CrashInfoCallback() { // from class: com.bytedance.crash.Npth.DefaultNpthApiImpl.3
                @Override // com.bytedance.crash.CrashInfoCallback
                public File[] crashFileList(CrashType crashType) {
                    File file;
                    if (crashType != CrashType.ANR || (file = iANRInfoCallback.getFile()) == null) {
                        return null;
                    }
                    return new File[]{file};
                }
            });
        }

        @Override // com.bytedance.crash.NpthApi
        protected void addTagsInner(Map<String, String> map) {
            Npth.addTags(map);
        }

        @Override // com.bytedance.crash.NpthApi
        protected String getByTraceIDInner() {
            return BytestConfig.getBytraceId();
        }

        @Override // com.bytedance.crash.NpthApi
        protected void checkInnerSo(String str) {
            NpthSoData.checkSoFile(str, NpthBuildConfig.VERSION_NAME);
        }

        @Override // com.bytedance.crash.NpthApi
        protected void checkInnerSo(String str, String str2) {
            NpthSoData.checkSoFile(str, str2);
        }

        static void registerImplObject() {
            new DefaultNpthApiImpl();
            NpthApi.setRetraceData(new NpthApi.RetraceDataCallback() { // from class: com.bytedance.crash.Npth.DefaultNpthApiImpl.4
                @Override // com.bytedance.crash.NpthApi.RetraceDataCallback
                public JSONObject getData() {
                    JSONObject jSONObject = new JSONObject();
                    JSONUtils.put(jSONObject, "release_build", BitsConfig.getReleaseBuild());
                    boolean miraInited = NpthMiraApi.miraInited();
                    JSONUtils.put(jSONObject, PluginInfoManager.MIRA_INIT, Boolean.valueOf(miraInited));
                    if (miraInited) {
                        JSONUtils.put(jSONObject, "plugin_info", PluginInfoManager.getPluginInfo());
                    }
                    return jSONObject;
                }
            });
        }
    }

    public static void setOpenNewAnrMonitor(boolean z) {
        GlobalSwitch.setOpenNewAnrMonitor(z);
    }

    public static void setCrashMonitorService(ICrashMonitorService iCrashMonitorService) {
        Global.setCrashMonitorService(iCrashMonitorService);
    }

    public static void setFixDumpStack(boolean z) {
        RepairAdapter.setFixDumpStack(z);
    }

    public static void setUrlConnectionInterceptor(IHttpUrlConnectionInterceptor iHttpUrlConnectionInterceptor) {
        CrashUploader.setUrlConnectionInterceptor(iHttpUrlConnectionInterceptor);
    }

    public static void setMaxCacheSize(int i) {
        EnsureDeliverer.setMaxCacheCount(i);
    }

    public static void setQueueLimitSize(int i) {
        EnsureDeliverer.setQueueLimitSize(i);
    }

    public static void addWhiteLogType(String str) {
        EnsureDeliverer.addWhiteLogType(str);
    }

    public static int optMtkBuffer(int i) {
        return RepairAdapter.startOptMtkBuffer(i);
    }

    public static int fixScudoVmaLeak() {
        return RepairAdapter.fixScudoVmaLeak();
    }

    public static void setTagCacheService(ITagCacheService iTagCacheService) {
        TagService.setTagCacheService(iTagCacheService);
        UserDataCenter userDataCenter = sCachedDataCenter;
        TagService.addTags(new HashMap(userDataCenter.getCacheCustomTags()), userDataCenter);
        userDataCenter.clearCustomTags();
    }

    public static void setTagOpt(boolean z) {
        sCachedDataCenter.setTagOpt(z);
    }

    public static void addCustomCrashReasonArray(String str, String str2) {
        sCachedDataCenter.addCrashReasonArray(str, str2);
    }

    public static void removeCustomCrashReasonArray(String str) {
        sCachedDataCenter.removeCrashReasonArray(str);
    }

    public static void setCustomCrashReasonArrayLimit(String str, int i) {
        sCachedDataCenter.setCrashReasonArrayLimit(str, i);
    }

    public static void setCrashUploadCallback(CrashUploadCallback crashUploadCallback) {
        sCachedDataCenter.setUploadCallback(crashUploadCallback);
    }

    public static void ignoreExceptionTag(boolean z) {
        UserDataCenter.setIgnoreExceptionTagEnable(z);
    }

    public static void setTerminateOpt(boolean z) {
        UserDataCenter.setTerminateOpt(z);
    }

    public static void optProcessTrackDisk() {
        UserDataCenter.optProcessTrackDisk();
    }

    public static void setOpenDumpTraceOpt(boolean z) {
        UserDataCenter.setOpenDumpTraceOpt(z);
    }

    public static void setNpthInitOptEnable(boolean z) {
        UserDataCenter.setNpthInitOptEnable(z);
    }

    public static void setUseLocalDomain(boolean z) {
        AppMonitorConfigService.setUseLocalDomain(z);
    }

    public static void setDomainName(String str) {
        try {
            AllDefaultUrls.setDomainName(new URL(str).getHost());
        } catch (Throwable unused) {
        }
    }

    public static void setRequestHeaderProvider(IRequestHeaderProvider iRequestHeaderProvider) {
        NpthNetworkApi.setRequestHeaderProvider(iRequestHeaderProvider);
    }

    public static void setNetworkCallback(INetworkCallback iNetworkCallback) {
        NpthNetworkApi.setNetworkCallback(iNetworkCallback);
    }

    public static int startOptMtkBuffer(int i) {
        return NpthCore.startOptMtkBuffer(i);
    }

    public static void setUploadDelayTime(long j) {
        LaunchScanner.setUploadDelayTime(j);
    }

    public static void setCrashAccessibilityEnable(boolean z) {
        CrashAccessibilityMonitor.setCrashAccessibilityEnable(z);
    }

    public static void pause() {
        EnsureConfig.setStopEnable(true);
        EventConfig.setStopEnable(true);
    }

    public static void resume() {
        EnsureConfig.setStopEnable(false);
        EventConfig.setStopEnable(false);
    }

    public static void setAnrDisableDumpData(boolean z) {
        AnrManager.setAnrDisableDumpData(z);
    }

    @Deprecated
    public static void registerPreCrashCallback(IPreCrashCallback iPreCrashCallback, CrashType crashType) {
        sCachedDataCenter.addPreCrashCallback(iPreCrashCallback, crashType);
    }

    @Deprecated
    public static void unregisterPreCrashCallback(IPreCrashCallback iPreCrashCallback, CrashType crashType) {
        sCachedDataCenter.removePreCrashCallback(iPreCrashCallback, crashType);
    }

    public static void registerPreANRCallback(IPreANRCallback iPreANRCallback) {
        sCachedDataCenter.addPreANRCallback(iPreANRCallback);
    }

    public static void unregisterPreANRCallback(IPreANRCallback iPreANRCallback) {
        sCachedDataCenter.removePreANRCallback(iPreANRCallback);
    }

    public static void registerAnrUploadCallback(IAnrUploadCallback iAnrUploadCallback) {
        sCachedDataCenter.addAnrUploadCallback(iAnrUploadCallback);
    }

    public static void registerExceptionTriggerCallback(IExceptionTriggerCallback iExceptionTriggerCallback) {
        AppMonitorConfigService.registerExceptionTriggerCallback(iExceptionTriggerCallback);
    }

    public static void setIgnoreHandler(CrashIgnoreHandler crashIgnoreHandler) {
        JavaCrashHandler.setIgnoreHandler(crashIgnoreHandler);
    }

    public static void setAnrMonitorOpt(boolean z) {
        GlobalSwitch.setAnrMonitorOpt(z);
    }

    public static void setCloseBgAnr(boolean z) {
        UserDataCenter.setCloseBgAnr(z);
    }

    public static void setANRImprovementOpt(boolean z) {
        GlobalSwitch.setANRImprovementOpt(z);
    }

    public static void setDumpAnrAsync(boolean z) {
        NpthCore.setDumpAnrAsync(z);
    }

    public static void setAnrResendSigquit(boolean z) {
        NpthCore.setAnrResendSigquit(z);
    }

    public static void clean() {
        EnsureDeliverer.clean();
    }

    public static void reportBizException(String str, Throwable th, String str2, Map<String, String> map) {
        if (str == null || th == null) {
            return;
        }
        reportBizException(str, th, str2, map, false);
    }

    public static void reportBizException(String str, Throwable th, String str2, Map<String, String> map, boolean z) {
        if (str == null || th == null) {
            return;
        }
        BizExceptionManager.getInstance().reportException(str, th, str2, map, null, z);
    }

    public static void reportBizException(String str, Throwable th, String str2, Map<String, String> map, Map<String, String> map2) {
        if (str == null || th == null) {
            return;
        }
        reportBizException(str, th, str2, map, map2, false);
    }

    public static void reportBizException(String str, Throwable th, String str2, Map<String, String> map, Map<String, String> map2, boolean z) {
        if (str == null || th == null) {
            return;
        }
        BizExceptionManager.getInstance().reportException(str, th, str2, map, map2, z);
    }

    public static void reportBizException(String str, IGetBizException iGetBizException, boolean z) {
        BizException exception;
        if (str == null || iGetBizException == null) {
            return;
        }
        if ((!BizExceptionManager.isConfigValid() || BizExceptionManager.isSample(str)) && (exception = iGetBizException.getException()) != null) {
            BizExceptionManager.getInstance().reportException(str, exception.getThrowable(), exception.getMessage(), exception.getFilters(), exception.getCustomData(), z);
        }
    }

    public static void reportBizException(String str, IGetBizException iGetBizException) {
        reportBizException(str, iGetBizException, false);
    }

    public static boolean addNativeProtectorConfig(JSONObject jSONObject) {
        return CrashProtector.addConfig(jSONObject);
    }
}
