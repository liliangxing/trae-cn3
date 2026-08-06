package com.bytedance.apm.internal;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.apm.ApmAgent;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.ApmProgressListener;
import com.bytedance.apm.MonitorCoreExceptionManager;
import com.bytedance.apm.ZstdCompressService;
import com.bytedance.apm.agent.tracing.AutoLaunchTraceHelper;
import com.bytedance.apm.agent.tracing.AutoPageTraceHelper;
import com.bytedance.apm.alog.AlogActiveUploadManager;
import com.bytedance.apm.alog.AlogMonitor;
import com.bytedance.apm.alog.IALogActiveUploadCallback;
import com.bytedance.apm.alog.IALogActiveUploadObserver;
import com.bytedance.apm.alog.net.AlogUploadService;
import com.bytedance.apm.battery.BatteryWidget;
import com.bytedance.apm.block.BlockDetector;
import com.bytedance.apm.block.FluencyMonitor;
import com.bytedance.apm.block.trace.FrameTracer;
import com.bytedance.apm.block.trace.MainThreadMonitor;
import com.bytedance.apm.block.trace.MethodCollector;
import com.bytedance.apm.config.ApmInitConfig;
import com.bytedance.apm.config.ApmReportConfig;
import com.bytedance.apm.config.ApmStartConfig;
import com.bytedance.apm.config.SlardarConfigManagerImpl;
import com.bytedance.apm.constant.CommonConsts;
import com.bytedance.apm.constant.ReportUrl;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.core.IQueryParams;
import com.bytedance.apm.data.BaseDataPipeline;
import com.bytedance.apm.data.pipeline.CommonDataPipeline;
import com.bytedance.apm.data.pipeline.NetDataPipeline;
import com.bytedance.apm.doctor.DoctorConstants;
import com.bytedance.apm.doctor.DoctorManager;
import com.bytedance.apm.impl.ApmAgentServiceImpl;
import com.bytedance.apm.impl.LaunchTraceImpl;
import com.bytedance.apm.launch.LaunchAnalysisContext;
import com.bytedance.apm.launch.evil.LaunchEvilMethodManager;
import com.bytedance.apm.listener.IApmStartListener;
import com.bytedance.apm.logging.ApmAlogHelper;
import com.bytedance.apm.logging.Logger;
import com.bytedance.apm.observer.LogObserver;
import com.bytedance.apm.perf.PerfConfigManager;
import com.bytedance.apm.perf.StorageCollector;
import com.bytedance.apm.perf.ThreadCollector;
import com.bytedance.apm.perf.memory.DetectActivityLeakTask;
import com.bytedance.apm.perf.traffic.TrafficCollector;
import com.bytedance.apm.report.FileUploadServiceImpl;
import com.bytedance.apm.sampler.DefaultSampler;
import com.bytedance.apm.samplers.SamplerHelper;
import com.bytedance.apm.thread.ApmHandlerThread;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.trace.ITraceListener;
import com.bytedance.apm.trace.LaunchTrace;
import com.bytedance.apm.trace.PageTimeMonitor;
import com.bytedance.apm.trace.TraceConfig;
import com.bytedance.apm.trace.fps.RealFpsTracer;
import com.bytedance.apm.util.AppUtils;
import com.bytedance.apm.util.JsonUtils;
import com.bytedance.apm.util.ListUtils;
import com.bytedance.apm.util.NetUtils;
import com.bytedance.apm.util.StackUtils;
import com.bytedance.apm6.Apm6;
import com.bytedance.apm6.commonevent.CommonEventDeliverer;
import com.bytedance.apm6.consumer.slardar.LogReporter;
import com.bytedance.apm6.consumer.slardar.send.LogReportController;
import com.bytedance.apm6.disk.DiskCollector;
import com.bytedance.apm6.hub.Apm;
import com.bytedance.apm6.memory.MemoryCollector;
import com.bytedance.apm6.monitor.Monitor;
import com.bytedance.crash.NpthApi;
import com.bytedance.monitor.collector.LooperMonitor;
import com.bytedance.monitor.collector.MonitorConfig;
import com.bytedance.monitor.collector.PerfMonitorManager;
import com.bytedance.monitor.collector.Util;
import com.bytedance.news.common.service.manager.ServiceCreator;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.perf.monitor.EvilMethodTracer;
import com.bytedance.perf.monitor.IBlockListener;
import com.bytedance.services.apm.api.EnsureManager;
import com.bytedance.services.apm.api.HttpResponse;
import com.bytedance.services.apm.api.IApmAgent;
import com.bytedance.services.apm.api.IEncrypt;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.apm.api.ILaunchTrace;
import com.bytedance.services.apm.api.IMultipartUploader;
import com.bytedance.services.apm.api.IWidget;
import com.bytedance.services.apm.api.IZstdCompress;
import com.bytedance.services.apm.api.IZstdDict;
import com.bytedance.services.apm.api.WidgetParams;
import com.bytedance.services.slardar.config.IConfigListener;
import com.bytedance.services.slardar.config.IConfigManager;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ApmDelegate implements IConfigListener {
    private static boolean sEvilMethodTraceEnable;
    private static long sEvilThresholdMs;
    private static boolean sLimitEvilMethodDepth;
    boolean isBlockInited;
    private ApmInitConfig mApmInitConfig;
    private ApmStartConfig mApmStartConfig;
    private IApmStartListener mApmStartListener;
    private volatile boolean mConfigReady;
    private List<String> mDefaultCongfigUrlsCompat;
    private List<String> mDefaultLogReportUrlsCompat;
    private boolean mEnableActiveUploadAlog;
    private IEncrypt mEncrypt;
    private List<String> mExceptionLogReportUrlsCompat;
    private volatile boolean mInited;
    private boolean mIsMainProcess;
    private SlardarConfigManagerImpl mSlardarConfigManager;
    private volatile boolean mStarted;
    private TraceConfig mTraceConfig;
    private ITraceListener mTraceListener;
    private Set<IWidget> mWidgetSet;

    private void initEvilMethodTraceInject() {
    }

    private void initMethodTrace(Application application) {
    }

    @Deprecated
    public void clearBufferLog() {
    }

    @Deprecated
    public void clearBufferLogSync() {
    }

    @Deprecated
    public void clearLegacyLog(long j) {
    }

    @Deprecated
    public void clearLegacyLogSync(long j) {
    }

    public void setReportConfig(ApmReportConfig apmReportConfig) {
    }

    private ApmDelegate() {
        this.isBlockInited = false;
        this.mEnableActiveUploadAlog = true;
    }

    public static ApmDelegate getInstance() {
        return Holder.sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class Holder {
        private static final ApmDelegate sInstance = new ApmDelegate();

        private Holder() {
        }
    }

    @Deprecated
    public void setTraceConfig(TraceConfig traceConfig) {
        if (traceConfig != null) {
            this.mTraceConfig = traceConfig;
        }
    }

    @Deprecated
    public void setTraceListener(ITraceListener iTraceListener) {
        this.mTraceListener = iTraceListener;
    }

    public void init(Context context) {
        ApmInitConfig.Builder builder = ApmInitConfig.builder();
        builder.pageTraceListener(this.mTraceListener);
        TraceConfig traceConfig = this.mTraceConfig;
        if (traceConfig != null) {
            builder.viewIdMonitorPageSwitch(traceConfig.isPageAnnotationTraceTimeSwitchOn());
            builder.maxValidPageLoadTimeMs(this.mTraceConfig.getMaxWaitViewShowTimeMs());
            builder.reportEvilMethodSwitch(this.mTraceConfig.isDropFrameReportEvilMethodSwitch());
            builder.evilMethodThresholdMs(this.mTraceConfig.getEvilMethodThresholdMs());
        }
        init(context, builder.build());
    }

    public void init(final Context context, final ApmInitConfig apmInitConfig) {
        if (this.mInited) {
            return;
        }
        long nanoTime = System.nanoTime();
        this.mInited = true;
        ApmContext.getStartId();
        ApmContext.setInitTimeStamp(System.currentTimeMillis());
        ApmContext.setInitUpTimestamp(System.currentTimeMillis() - SystemClock.uptimeMillis());
        this.mApmInitConfig = apmInitConfig;
        NetUtils.setUrlConnectionInterceptor(apmInitConfig.getHttpUrlConnectionInterceptor());
        ITraceListener iTraceListener = this.mTraceListener;
        if (iTraceListener != null) {
            this.mApmInitConfig.setTraceListener(iTraceListener);
        }
        TraceConfig traceConfig = this.mTraceConfig;
        if (traceConfig != null) {
            this.mApmInitConfig.setViewIdmonitorPageSwitch(traceConfig.isPageAnnotationTraceTimeSwitchOn());
            this.mApmInitConfig.setMaxValidPageLoadTimeMs(this.mTraceConfig.getMaxWaitViewShowTimeMs());
            this.mApmInitConfig.setReportEvilMethodSwitch(this.mTraceConfig.isDropFrameReportEvilMethodSwitch());
            this.mApmInitConfig.setEvilMethodThresholdMs(this.mTraceConfig.getEvilMethodThresholdMs());
        }
        BaseDataPipeline.setCacheBufferMaxSize(apmInitConfig.getCacheBufferCount());
        BaseDataPipeline.setReportFullException(apmInitConfig.isReportCacheException());
        CommonEventDeliverer.setReportFullException(apmInitConfig.isReportCacheException());
        Application application = AppUtils.getApplication(context);
        ApmContext.setContext(application);
        ActivityLifeObserver.init(application);
        ApmContext.setInitCostTimeStep2(System.nanoTime() - nanoTime);
        registerServiceWhenStart();
        printDataEventInDebugMode();
        ApmContext.setInitCostTimeStep3(System.nanoTime() - nanoTime);
        ApmProgressListener progressListener = ApmContext.getProgressListener();
        if (progressListener != null) {
            progressListener.afterRegisterService();
        }
        ApmContext.setCurrentProcessName(apmInitConfig.getProcessName());
        this.mIsMainProcess = ApmContext.isMainProcess();
        final Runnable init = Apm6.init(context);
        ApmContext.setInitCostTimeStep4(System.nanoTime() - nanoTime);
        AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.internal.ApmDelegate.1
            @Override // java.lang.Runnable
            public void run() {
                ApmDelegate.this.mSlardarConfigManager.registerConfigListener(ApmDelegate.getInstance());
                LaunchTrace.setLaunchCollectExtraInfoFlag(apmInitConfig.getTraceExtraFlag());
                LaunchTrace.setLaunchCollectExtraInfoTimeMs(apmInitConfig.getTraceExtraCollectTimeMs());
                FunctionSwitcher.init(context);
                ApmProgressListener progressListener2 = ApmContext.getProgressListener();
                if (progressListener2 != null) {
                    progressListener2.functionSwitcherInited();
                }
                if (ApmDelegate.this.mIsMainProcess) {
                    MainThreadMonitor.getMonitor().start();
                    MonitorConfig.Builder builder = new MonitorConfig.Builder();
                    builder.atraceTag(FunctionSwitcher.getAtraceFlags()).enableAtrace(FunctionSwitcher.getAtraceFlags() != 0 && FunctionSwitcher.getSwitch(2)).enableBinder(apmInitConfig.isEnableBinderMonitor() && FunctionSwitcher.getSwitch(2)).enableStackSampling(FunctionSwitcher.getSwitch(64)).enableLock(false).enableLooperMonitor(!ApmDelegate.this.mApmInitConfig.isEnableLooperOpt()).runMode(FunctionSwitcher.getMonitorRunMode());
                    PerfMonitorManager.getInstance().init(ApmContext.getContext(), builder.build());
                    PerfMonitorManager.getInstance().start();
                    PerfMonitorManager.getInstance().setEnableCpuOpt(ApmDelegate.this.mApmInitConfig.isEnableCpuAllocOpt());
                } else {
                    PerfMonitorManager.loadLibrary(ApmContext.getContext());
                }
                FluencyMonitor.getInstance().init();
                Runnable runnable = init;
                if (runnable != null) {
                    runnable.run();
                }
                if (ApmContext.isDebugMode()) {
                    DoctorManager.getInstance().onEvent(ApmDelegate.this.mIsMainProcess ? DoctorConstants.APM_INIT_ASYNC : DoctorConstants.APM_INIT_ASYNC_OTHER_PROCESS, "done");
                }
            }
        });
        ApmContext.setInitCostTimeStep5(System.nanoTime() - nanoTime);
        if (this.mIsMainProcess) {
            DetectActivityLeakTask.init(application, this.mApmInitConfig.getActivityLeakDetectConfig());
            if (apmInitConfig.isViewIdmonitorPageSwitch()) {
                new PageTimeMonitor().init(apmInitConfig.getMaxValidPageLoadTimeMs(), true);
            }
            AutoPageTraceHelper.setMaxValidTimeMs(apmInitConfig.getMaxValidPageLoadTimeMs());
            AutoLaunchTraceHelper.setMaxValidTimeMs(apmInitConfig.getMaxValidLaunchTimeMs());
            initMethodTrace(application);
            sLimitEvilMethodDepth = apmInitConfig.isLimitEvilMethodDepth();
            sEvilThresholdMs = apmInitConfig.getEvilMethodThresholdMs();
            sEvilMethodTraceEnable = apmInitConfig.isReportEvilMethodSwitch();
            FrameTracer.setsNeedMonitorActivity(apmInitConfig.isActivityFps());
            boolean isFullFpsTracer = apmInitConfig.isFullFpsTracer();
            boolean isDisableFpsTracer = apmInitConfig.isDisableFpsTracer();
            MainThreadMonitor.getMonitor().init();
            MainThreadMonitor.getMonitor().setFpsLifeCycleChange(apmInitConfig.isChangeFpsLifeCyclesTracer());
            MainThreadMonitor.getMonitor().setEnableFpsAllocOpt(apmInitConfig.isEnableCpuAllocOpt());
            MainThreadMonitor.getMonitor().setEnableCloseListener(apmInitConfig.isEnableCloseListener());
            MainThreadMonitor.getMonitor().setEnableLooperOpt(apmInitConfig.isEnableLooperOpt());
            Util.enableLooperOpt = this.mApmInitConfig.isEnableLooperDeepOpt();
            if (isFullFpsTracer && !isDisableFpsTracer) {
                final FrameTracer frameTracer = new FrameTracer();
                RealFpsTracer.setFrameTracer(frameTracer);
                EvilMethodTracer.setBlockListener(new IBlockListener() { // from class: com.bytedance.apm.internal.ApmDelegate.2
                    public void doBlock(long j, boolean z) {
                        frameTracer.doBlock(j, z);
                    }
                });
                if (!this.mApmInitConfig.isEnableLooperOpt()) {
                    MainThreadMonitor.getMonitor().addObserver(frameTracer);
                }
                MainThreadMonitor.getMonitor().setFrameObserver(frameTracer);
            }
            initEvilMethodTraceInject();
            LaunchEvilMethodManager.registerEvilMethodConfig();
            LaunchAnalysisContext.getInstance().setConfig(apmInitConfig.getLaunchConfig());
            ApmContext.setInitCostTime(System.nanoTime() - nanoTime);
            ApmContext.setDeviceInfoOnPerfDataEnabled(apmInitConfig.isDeviceInfoOnPerfDataEnabled());
            ApmContext.setSupportMultiFrameRate(apmInitConfig.supportMultiFrameRate());
        }
        if (ApmContext.isDebugMode()) {
            DoctorManager.getInstance().onEvent(this.mIsMainProcess ? DoctorConstants.APM_INIT : DoctorConstants.APM_INIT_OTHER_PROCESS, apmInitConfig.toString());
        }
        if (ApmAlogHelper.getInnerLogger() != null) {
            ApmAlogHelper.getInnerLogger().m80i("apm_debug", "apm_init");
        }
        ApmContext.setIsInitFinish(true);
        ApmContext.setInitCostTimeStepFinish(System.nanoTime() - nanoTime);
    }

    private static void initTraceEvilMethod() {
        EvilMethodTracer.setEvilThresholdMs(sEvilThresholdMs);
        EvilMethodTracer.setIsEvilMethodTraceEnable(sEvilMethodTraceEnable);
        EvilMethodTracer.isMethodTraced = true;
        MainThreadMonitor.getMonitor().init();
        MethodCollector.getInstance().onStart();
        new EvilMethodTracer(sLimitEvilMethodDepth).startTrace();
        PerfMonitorManager.getInstance().setEvilMethodEnable(true);
    }

    public boolean isStarted() {
        return this.mStarted;
    }

    public boolean isInited() {
        return this.mInited;
    }

    public void start(ApmStartConfig apmStartConfig) {
        if (ApmAlogHelper.getInnerLogger() != null) {
            try {
                ApmAlogHelper.getInnerLogger().m80i("apm_debug", "start");
            } catch (Exception unused) {
            }
        }
        if (!this.mInited) {
            throw new IllegalArgumentException("You must call Apm.getInstance().init() on Application.onCreate from version 5.x.x, pls call init() before start().");
        }
        if (apmStartConfig == null) {
            throw new IllegalArgumentException("startConfig must not be allowed");
        }
        if (this.mStarted) {
            return;
        }
        AsyncEventManager.getInstance().resumeTimer();
        this.mStarted = true;
        this.mApmStartConfig = apmStartConfig;
        AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.internal.ApmDelegate.3
            @Override // java.lang.Runnable
            public void run() {
                ApmDelegate.this.startInternalSafely();
            }
        });
    }

    public void stop() {
        AsyncEventManager.getInstance().stopTimer();
        this.mStarted = false;
    }

    public ApmStartConfig.Builder newStartConfigBuilder() {
        if (!this.mStarted) {
            Logger.m87e("ERROR", "apm sdk only can get startconfigBuilder after start finished");
            return ApmStartConfig.builder();
        }
        return ApmStartConfig.builder(this.mApmStartConfig);
    }

    public void restart(final ApmStartConfig apmStartConfig) {
        AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.internal.ApmDelegate.4
            @Override // java.lang.Runnable
            public void run() {
                ApmDelegate.this.restartInternal(apmStartConfig);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startInternalSafely() {
        try {
            long nanoTime = System.nanoTime();
            com.bytedance.apm6.foundation.context.ApmContext.setNtpTimeService(this.mApmStartConfig.getNtpTimeService());
            startInternal();
            if (this.mIsMainProcess) {
                ApmContext.setStartCostTime(System.nanoTime() - nanoTime);
                reportInnerCost();
            }
        } catch (Throwable th) {
            if (ApmContext.isDebugMode()) {
                th.printStackTrace();
                DoctorManager.getInstance().onEvent(DoctorConstants.APM_START_ERROR, StackUtils.getStack(th));
            }
            if (ApmAlogHelper.getInnerLogger() != null) {
                ApmAlogHelper.getInnerLogger().m80i("apm_debug", "APM_START_ERROR:" + StackUtils.getStack(th));
            }
            try {
                AsyncEventManager.getInstance().stopTimer();
            } catch (Throwable unused) {
            }
        }
    }

    private void startInternal() {
        SpManager.getInstance();
        ApmContext.setStartTimeStamp(System.currentTimeMillis());
        ApmContext.setQueryParams(this.mApmStartConfig.getQueryParams());
        Monitor.registerInterceptor(this.mApmStartConfig.getInterceptor());
        compatV4();
        SamplerHelper.setSampler(new DefaultSampler());
        MonitorCoreExceptionManager.getInstance().setExceptionCallback(new MonitorCoreExceptionManager.ExceptionCallBack() { // from class: com.bytedance.apm.internal.ApmDelegate.5
            @Override // com.bytedance.apm.MonitorCoreExceptionManager.ExceptionCallBack
            public void ensureNotReachHere(Throwable th, String str) {
                EnsureManager.ensureNotReachHere(th, str);
            }

            @Override // com.bytedance.apm.MonitorCoreExceptionManager.ExceptionCallBack
            public void ensureNotReachHere(String str) {
                EnsureManager.ensureNotReachHere(str);
            }

            @Override // com.bytedance.apm.MonitorCoreExceptionManager.ExceptionCallBack
            public void ensureNotReachHere(Throwable th, String str, Map<String, String> map) {
                EnsureManager.ensureNotReachHere(th, str, map);
            }

            @Override // com.bytedance.apm.MonitorCoreExceptionManager.ExceptionCallBack
            public void directReportError(Throwable th, String str) {
                EnsureManager.reportLogEException(5, th, str, false);
            }
        });
        ApmContext.setHeaderInfo(this.mApmStartConfig.getHeader());
        ApmContext.setDynamicParams(this.mApmStartConfig.getDynamicParams());
        ApmContext.setHttpService(this.mApmStartConfig.getHttpService());
        ApmContext.setRequestTagHeaderProvider(this.mApmStartConfig.getRequestTagHeaderProvider());
        ApmContext.setSlardarConfigUrls(this.mApmStartConfig.getSlardarConfigUrls());
        ApmContext.setAlogFilesDir(this.mApmStartConfig.getAlogFilesDir());
        this.mEncrypt = this.mApmStartConfig.getEncryptor();
        this.mWidgetSet = this.mApmStartConfig.getWidgets();
        initPerfMonitor();
        LogObserver.getInstance().addLogObserver(this.mApmStartConfig.getApmLogListener());
        CommonDataPipeline.getInstance().init();
        NetDataPipeline.getInstance().init();
        NetDataPipeline.getInstance().setNetMonitorWithDisconnected(this.mApmStartConfig.getNetMonitorWithDisconnected());
        AlogActiveUploadManager.init(ApmContext.getContext(), this.mApmInitConfig.getAlogUploadStrategy());
        initByTraceExtendParams();
        long delayRequestSeconds = this.mApmStartConfig.getDelayRequestSeconds();
        Runnable runnable = new Runnable() { // from class: com.bytedance.apm.internal.ApmDelegate.6
            @Override // java.lang.Runnable
            public void run() {
                ApmDelegate.this.mSlardarConfigManager.initParams(ApmDelegate.this.mApmStartConfig.isEnableMultiProcessRequestSetting(), new IQueryParams() { // from class: com.bytedance.apm.internal.ApmDelegate.6.1
                    @Override // com.bytedance.apm.core.IQueryParams
                    public Map<String, String> getQueryParams() {
                        return ApmContext.getQueryParamsMap();
                    }
                }, ApmDelegate.this.mApmStartConfig.getSlardarConfigUrls());
                if (!ApmDelegate.this.mApmStartConfig.isForceUpdateSlardarSetting() || !ApmContext.isMainProcess()) {
                    ApmDelegate.this.mSlardarConfigManager.fetchConfig();
                } else {
                    ApmDelegate.this.mSlardarConfigManager.forceUpdateFromRemote(null, null);
                }
            }
        };
        if (delayRequestSeconds <= 0) {
            AsyncEventManager.getInstance().post(runnable);
        } else {
            AsyncEventManager.getInstance().postDelay(runnable, 1000 * delayRequestSeconds);
        }
        if (ApmContext.isDebugMode()) {
            ApmAlogHelper.m77i("apm_debug", "delayRequestSeconds:" + delayRequestSeconds);
        }
        if (this.mIsMainProcess) {
            checkWhetherFirstInstall();
        }
        initAllPlugins(ApmContext.getContext());
        WidgetParams widgetParams = new WidgetParams();
        widgetParams.setReportDomain(this.mApmStartConfig.getDefaultLogReportUrls());
        notifyPluginsParams(widgetParams);
        startAllPlugins();
        AsyncEventManager.getInstance().injectExecutor(this.mApmStartConfig.getExecutor());
        injectReportUrl(this.mApmStartConfig);
        IApmStartListener apmStartListener = this.mApmStartConfig.getApmStartListener();
        this.mApmStartListener = apmStartListener;
        if (apmStartListener != null) {
            apmStartListener.onStartComplete();
        }
        AutoLaunchTraceHelper.reportStats();
        ServiceManager.registerService(IHttpService.class, new IHttpService() { // from class: com.bytedance.apm.internal.ApmDelegate.7
            public HttpResponse doPost(String str, byte[] bArr, Map<String, String> map) throws Exception {
                return ApmContext.doPost(str, bArr, map);
            }

            public HttpResponse doGet(String str, Map<String, String> map) throws Exception {
                return ApmContext.doGet(str, map);
            }

            public HttpResponse uploadFiles(String str, List<File> list, Map<String, String> map) throws Exception {
                return ApmContext.uploadFiles(str, list, map);
            }

            public IMultipartUploader buildMultipartUpload(String str, String str2, boolean z) throws Exception {
                return ApmContext.buildMultipartUploader(str, str2, z);
            }

            public IMultipartUploader buildMultipartUpload(String str, String str2, boolean z, Map<String, String> map) throws Exception {
                return ApmContext.buildMultipartUploader(str, str2, z, map);
            }
        });
        if (ApmContext.isDebugMode()) {
            DoctorManager.getInstance().onEvent(this.mIsMainProcess ? DoctorConstants.APM_START : DoctorConstants.APM_START_OTHER_PROCESS, this.mApmStartConfig.toString());
        }
        if (ApmAlogHelper.getInnerLogger() != null) {
            ApmAlogHelper.getInnerLogger().m80i("apm_debug", DoctorConstants.APM_START);
        }
    }

    private static void initByTraceExtendParams() {
        try {
            String byTraceID = NpthApi.getByTraceID();
            if (TextUtils.isEmpty(byTraceID)) {
                return;
            }
            ApmContext.getHeaderInner().put("bytrace_id", byTraceID);
            ApmContext.getHeaderInner().put("pid", String.valueOf(Process.myPid()));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void injectReportUrl(ApmStartConfig apmStartConfig) {
        List<String> defaultLogReportUrls = apmStartConfig.getDefaultLogReportUrls();
        if (!ListUtils.isEmpty(defaultLogReportUrls)) {
            try {
                String host = new URL(defaultLogReportUrls.get(0)).getHost();
                FileUploadServiceImpl.setUploadHost(host);
                FileUploadServiceImpl.setMappingFileUploadHost(host);
                AlogUploadService.setUploadHost(host);
            } catch (MalformedURLException unused) {
            }
            ArrayList arrayList = new ArrayList(2);
            int size = defaultLogReportUrls.size();
            for (int i = 0; i < size; i++) {
                try {
                    String host2 = new URL(defaultLogReportUrls.get(i)).getHost();
                    if (!TextUtils.isEmpty(host2) && host2.indexOf(46) > 0) {
                        arrayList.add("https://" + host2 + "/monitor/collect/batch/");
                    }
                } catch (Exception unused2) {
                }
            }
            LogReportController.getInstance().setDefaultReportUrlList(arrayList);
        }
        LogReportController.getInstance().setTraceReportUrlList(ReportUrl.REPORT_TRACING_URL_LIST);
        LogReportController.getInstance().setDefaultExceptionUrlList(ReportUrl.EXCEPTION_UPLOAD_URL_LIST);
        LogReportController.getInstance().setDefaultExceptionUrlList(apmStartConfig.getExceptionLogReportUrls());
        List<String> traceReportUrls = apmStartConfig.getTraceReportUrls();
        if (ListUtils.isEmpty(traceReportUrls)) {
            return;
        }
        LogReportController.getInstance().setTraceReportUrlList(traceReportUrls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void restartInternal(ApmStartConfig apmStartConfig) {
        SlardarConfigManagerImpl slardarConfigManagerImpl;
        this.mApmStartConfig = apmStartConfig;
        ApmContext.setQueryParams(apmStartConfig.getQueryParams());
        ApmContext.setHeaderInfo(apmStartConfig.getHeader());
        ApmContext.setDynamicParams(apmStartConfig.getDynamicParams());
        ApmContext.setHttpService(apmStartConfig.getHttpService());
        this.mEncrypt = apmStartConfig.getEncryptor();
        if (this.mIsMainProcess) {
            this.mSlardarConfigManager.forceUpdateFromRemote(new IQueryParams() { // from class: com.bytedance.apm.internal.ApmDelegate.8
                @Override // com.bytedance.apm.core.IQueryParams
                public Map<String, String> getQueryParams() {
                    return ApmContext.getQueryParamsMap();
                }
            }, apmStartConfig.getSlardarConfigUrls());
        } else if (apmStartConfig.isEnableMultiProcessRequestSetting() && (slardarConfigManagerImpl = this.mSlardarConfigManager) != null) {
            slardarConfigManagerImpl.initParams(apmStartConfig.isEnableMultiProcessRequestSetting(), new IQueryParams() { // from class: com.bytedance.apm.internal.ApmDelegate.9
                @Override // com.bytedance.apm.core.IQueryParams
                public Map<String, String> getQueryParams() {
                    return ApmContext.getQueryParamsMap();
                }
            }, apmStartConfig.getSlardarConfigUrls());
        }
        NetDataPipeline.getInstance().setNetMonitorWithDisconnected(apmStartConfig.getNetMonitorWithDisconnected());
        LogReporter.getInstance().restart();
        injectReportUrl(this.mApmStartConfig);
        AsyncEventManager.getInstance().injectExecutor(apmStartConfig.getExecutor());
    }

    private void initPerfMonitor() {
        MemoryCollector.getInstance().initGCInfo();
        if (this.mIsMainProcess) {
            StorageCollector storageCollector = new StorageCollector();
            storageCollector.setStorageCheckListener(this.mApmStartConfig.getStorageCheckListener());
            storageCollector.init();
        }
        TrafficCollector.setCallback(this.mApmStartConfig.getTrafficCallback());
        DiskCollector.getInstance().setDiskCheckListener(this.mApmStartConfig.getStorageCheckListener());
        MemoryCollector.getInstance().registerReachTopListener(this.mApmStartConfig.getMemoryReachTopListener());
        if (!this.mApmStartConfig.isWithBlockDetect() || this.mApmStartConfig.isEnableBlockOnlySampled()) {
            return;
        }
        initBlockMonitor();
    }

    private void initBlockMonitor() {
        if (this.isBlockInited) {
            return;
        }
        this.isBlockInited = true;
        ApmHandlerThread.getDefaultMainHandler().post(new Runnable() { // from class: com.bytedance.apm.internal.ApmDelegate.10
            @Override // java.lang.Runnable
            public void run() {
                LooperMonitor.init();
            }
        });
        BlockDetector blockDetector = new BlockDetector();
        blockDetector.setBlockThresholdMs(this.mApmStartConfig.getBlockThresholdMs());
        blockDetector.setWithSeriousBlockDetect(this.mApmStartConfig.isWithSeriousBlockDetect());
        blockDetector.setIgnoreInvalidStack(this.mApmStartConfig.isIgnoreInvalidStack());
        blockDetector.setBlockListener(this.mApmStartConfig.getBlockListener());
        blockDetector.init();
        if (ActivityLifeObserver.getInstance().isForeground()) {
            blockDetector.start();
        }
        blockDetector.setSliverEnable(this.mApmInitConfig.isEnableSliverDump());
    }

    private void compatV4() {
        if (ListUtils.isEmpty(this.mApmStartConfig.getSlardarConfigUrls()) && !ListUtils.isEmpty(this.mDefaultCongfigUrlsCompat)) {
            this.mApmStartConfig.setSlardarConfigUrlsCompat(this.mDefaultCongfigUrlsCompat);
        }
        if (ListUtils.isEmpty(this.mApmStartConfig.getDefaultLogReportUrls()) && !ListUtils.isEmpty(this.mDefaultLogReportUrlsCompat)) {
            this.mApmStartConfig.setDefaultLogReportUrlsCompat(this.mDefaultLogReportUrlsCompat);
        }
        if (!ListUtils.isEmpty(this.mApmStartConfig.getExceptionLogReportUrls()) || ListUtils.isEmpty(this.mExceptionLogReportUrlsCompat)) {
            return;
        }
        this.mApmStartConfig.setExceptionLogReportUrlsCompat(this.mExceptionLogReportUrlsCompat);
    }

    private void checkWhetherFirstInstall() {
        String string = SpManager.getInstance().getString("update_version_code");
        String optString = ApmContext.getHeaderInner().optString("update_version_code");
        if (!TextUtils.equals(string, optString)) {
            ApmContext.setLaunchMode(1);
            SpManager.getInstance().saveAsync("update_version_code", optString);
        } else {
            ApmContext.setLaunchMode(2);
        }
    }

    private void initAllPlugins(Context context) {
        Set<IWidget> set = this.mWidgetSet;
        if (set == null) {
            return;
        }
        Iterator<IWidget> it = set.iterator();
        while (it.hasNext()) {
            try {
                it.next().init(context);
            } catch (Throwable unused) {
            }
        }
    }

    public void notifyPluginsParams(WidgetParams widgetParams) {
        Set<IWidget> set = this.mWidgetSet;
        if (set == null) {
            return;
        }
        Iterator<IWidget> it = set.iterator();
        while (it.hasNext()) {
            try {
                it.next().notifyParams(widgetParams);
            } catch (Throwable unused) {
            }
        }
    }

    public void startAllPlugins() {
        Set<IWidget> set = this.mWidgetSet;
        if (set == null) {
            return;
        }
        Iterator<IWidget> it = set.iterator();
        while (it.hasNext()) {
            try {
                it.next().start();
            } catch (Throwable unused) {
            }
        }
    }

    public void stopAllPlugins() {
        if (this.mWidgetSet == null) {
            return;
        }
        AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.internal.ApmDelegate.11
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = ApmDelegate.this.mWidgetSet.iterator();
                while (it.hasNext()) {
                    try {
                        ((IWidget) it.next()).stop();
                    } catch (Throwable unused) {
                    }
                }
            }
        });
    }

    public void destroyAllPlugins() {
        if (this.mWidgetSet == null) {
            return;
        }
        AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.internal.ApmDelegate.12
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = ApmDelegate.this.mWidgetSet.iterator();
                while (it.hasNext()) {
                    try {
                        ((IWidget) it.next()).destroy();
                    } catch (Throwable unused) {
                    }
                }
            }
        });
    }

    private void registerServiceWhenStart() {
        SlardarConfigManagerImpl slardarConfigManagerImpl = new SlardarConfigManagerImpl();
        this.mSlardarConfigManager = slardarConfigManagerImpl;
        slardarConfigManagerImpl.registerConfigListener(this);
        ServiceManager.registerService(IConfigManager.class, this.mSlardarConfigManager);
        ServiceManager.registerService(IApmAgent.class, new ServiceCreator<IApmAgent>() { // from class: com.bytedance.apm.internal.ApmDelegate.13
            /* renamed from: create, reason: merged with bridge method [inline-methods] */
            public IApmAgent m414create() {
                return new ApmAgentServiceImpl();
            }
        });
        ServiceManager.registerService(ILaunchTrace.class, new ServiceCreator<ILaunchTrace>() { // from class: com.bytedance.apm.internal.ApmDelegate.14
            /* renamed from: create, reason: merged with bridge method [inline-methods] */
            public ILaunchTrace m415create() {
                return new LaunchTraceImpl();
            }
        });
        ServiceManager.registerService(IZstdCompress.class, new ServiceCreator<IZstdCompress>() { // from class: com.bytedance.apm.internal.ApmDelegate.15
            /* renamed from: create, reason: merged with bridge method [inline-methods] */
            public IZstdCompress m416create() {
                return new ZstdCompressService();
            }
        });
        ServiceManager.registerService(IZstdDict.class, new ServiceCreator<IZstdDict>() { // from class: com.bytedance.apm.internal.ApmDelegate.16
            /* renamed from: create, reason: merged with bridge method [inline-methods] */
            public IZstdDict m417create() {
                return (IZstdDict) com.bytedance.apm6.service.ServiceManager.getService(IZstdDict.class);
            }
        });
    }

    public ApmInitConfig getApmInitConfig() {
        ApmInitConfig apmInitConfig = this.mApmInitConfig;
        return apmInitConfig == null ? ApmInitConfig.builder().build() : apmInitConfig;
    }

    public void onRefresh(JSONObject jSONObject, boolean z) {
        JSONObject optJSONObject = jSONObject.optJSONObject("general");
        if (optJSONObject != null) {
            this.mEnableActiveUploadAlog = optJSONObject.optBoolean(SlardarSettingsConsts.ENABLE_ACTIVE_UPLOAD_ALOG, true);
        } else {
            this.mEnableActiveUploadAlog = true;
        }
    }

    public void onReady() {
        this.mConfigReady = true;
        IApmStartListener iApmStartListener = this.mApmStartListener;
        if (iApmStartListener != null) {
            iApmStartListener.onReady();
        }
        JSONObject config = this.mSlardarConfigManager.getConfig();
        if (this.mIsMainProcess) {
            new ThreadCollector().init();
            if (JsonUtils.optInt(config, "performance_modules", "traffic", "enable_collect") == 1) {
                TrafficCollector.getInstance().init();
            }
        }
        if (this.mApmStartConfig.isWithBatteryDetect()) {
            boolean z = JsonUtils.optInt(config, "performance_modules", "battery", "enable_upload") == 1;
            if (z) {
                BatteryWidget.initBatteryEnergy();
            }
            if (z || this.mApmStartConfig.isBatteryLocalRecordEnable()) {
                BatteryWidget.initBatteryCollector(this.mApmStartConfig.isBatteryLocalRecordEnable());
            }
            if (JsonUtils.optInt(config, "performance_modules", "battery", SlardarSettingsConsts.PER_POWER_MONITOR_ENABLE) == 1) {
                BatteryWidget.initPower();
            }
            if ((JsonUtils.optInt(config, "performance_modules", "battery", SlardarSettingsConsts.PERF_KEY_BATTERY_TEMPERATURE_ENABLE_UPLOAD) == 1) || this.mApmStartConfig.isTemperatureLocalRecordEnable()) {
                BatteryWidget.initBatteryTemperature(this.mApmStartConfig.isTemperatureLocalRecordEnable());
            }
        }
        if (this.mApmStartConfig.isEnableBlockOnlySampled() && PerfConfigManager.getInstance().getPerfSecondStageSwitch("block_monitor")) {
            initBlockMonitor();
        }
    }

    public boolean isConfigReady() {
        return this.mConfigReady;
    }

    public boolean getLogTypeSwitch(String str) {
        SlardarConfigManagerImpl slardarConfigManagerImpl;
        if (!this.mConfigReady || (slardarConfigManagerImpl = this.mSlardarConfigManager) == null) {
            return false;
        }
        return slardarConfigManagerImpl.getLogTypeSwitch(str);
    }

    public boolean getServiceNameSwitch(String str) {
        SlardarConfigManagerImpl slardarConfigManagerImpl;
        if (!this.mConfigReady || (slardarConfigManagerImpl = this.mSlardarConfigManager) == null) {
            return false;
        }
        return slardarConfigManagerImpl.getServiceSwitch(str);
    }

    public boolean getMetricsTypeSwitch(String str) {
        SlardarConfigManagerImpl slardarConfigManagerImpl;
        if (!this.mConfigReady || (slardarConfigManagerImpl = this.mSlardarConfigManager) == null) {
            return false;
        }
        return slardarConfigManagerImpl.getMetricTypeSwitch(str);
    }

    public IEncrypt getEncrypt() {
        return this.mEncrypt;
    }

    public void activeUploadAlog(final String str, final long j, final long j2, final String str2, final IALogActiveUploadObserver iALogActiveUploadObserver, final IALogActiveUploadCallback iALogActiveUploadCallback) {
        if (this.mEnableActiveUploadAlog) {
            AsyncEventManager.getInstance().submitTask(new Runnable() { // from class: com.bytedance.apm.internal.ApmDelegate.17
                @Override // java.lang.Runnable
                public void run() {
                    AlogActiveUploadManager.tryUploadAlog(str, j, j2, str2, iALogActiveUploadObserver, iALogActiveUploadCallback);
                }
            });
        } else if (iALogActiveUploadCallback != null) {
            iALogActiveUploadCallback.onCallback(false, AlogMonitor.getResult(false, 9, null, null));
        }
    }

    public void stopWithReport() {
        AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.internal.ApmDelegate.18
            @Override // java.lang.Runnable
            public void run() {
                PerfMonitorManager.getInstance().stop();
            }
        });
        AsyncEventManager.getInstance().stopTimer();
        Apm.pause();
    }

    public void restart() {
        AsyncEventManager.getInstance().resumeTimer();
        AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.internal.ApmDelegate.19
            @Override // java.lang.Runnable
            public void run() {
                PerfMonitorManager.getInstance().start();
            }
        });
        Apm.resume();
    }

    public void pause() {
        AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.internal.ApmDelegate.20
            @Override // java.lang.Runnable
            public void run() {
                PerfMonitorManager.getInstance().stop();
            }
        });
        AsyncEventManager.getInstance().stopTimer();
    }

    public void resume() {
        AsyncEventManager.getInstance().resumeTimer();
        AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.internal.ApmDelegate.21
            @Override // java.lang.Runnable
            public void run() {
                PerfMonitorManager.getInstance().start();
            }
        });
    }

    public void setConfigUrlCompat(List<String> list) {
        if (this.mStarted || ListUtils.isEmpty(list)) {
            return;
        }
        this.mDefaultCongfigUrlsCompat = list;
    }

    public void setDefaultLogReportUrlsCompat(List<String> list) {
        if (this.mStarted || ListUtils.isEmpty(list)) {
            return;
        }
        this.mDefaultLogReportUrlsCompat = list;
    }

    public void setExceptionLogReportUrlsCompat(List<String> list) {
        if (this.mStarted || ListUtils.isEmpty(list)) {
            return;
        }
        this.mExceptionLogReportUrlsCompat = list;
    }

    private void reportInnerCost() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("init", ApmContext.getInitCostTime());
            jSONObject.put("init_finish", ApmContext.getInitCostTimeIncludingApm6());
            jSONObject.put(CommonConsts.APM_INNER_EVENT_COST_INIT_STEP2, ApmContext.getInitCostTimeStep2());
            jSONObject.put(CommonConsts.APM_INNER_EVENT_COST_INIT_STEP3, ApmContext.getInitCostTimeStep3());
            jSONObject.put(CommonConsts.APM_INNER_EVENT_COST_INIT_STEP4, ApmContext.getInitCostTimeStep4());
            jSONObject.put(CommonConsts.APM_INNER_EVENT_COST_INIT_STEP5, ApmContext.getInitCostTimeStep5());
            jSONObject.put("start", ApmContext.getStartCostTime());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("is_main_process", this.mIsMainProcess);
            ApmAgent.monitorEvent("apm_cost", jSONObject2, jSONObject, null);
        } catch (JSONException unused) {
        }
    }

    private static void printDataEventInDebugMode() {
        if (ApmContext.isDebugMode()) {
            DoctorManager.getInstance().registerApmListener(new DoctorManager.ApmListener() { // from class: com.bytedance.apm.internal.ApmDelegate.22
                private static final String TAG = "APM-Doctor-Log";

                @Override // com.bytedance.apm.doctor.DoctorManager.ApmListener
                public void onEvent(String str, String str2) {
                    safePrint("onEvent key=" + str, str2, false);
                }

                @Override // com.bytedance.apm.doctor.DoctorManager.ApmListener
                public void onDataEvent(int i, String str, JSONObject jSONObject) {
                    if (TextUtils.equals(str, DoctorConstants.DATA_CACHE) || TextUtils.equals(str, DoctorConstants.DATA_SEND_END) || TextUtils.equals(str, DoctorConstants.DATA_SEND_RESPONSE)) {
                        return;
                    }
                    if (TextUtils.equals(str, DoctorConstants.DATA_RECEIVE) && !jSONObject.optJSONObject(DoctorConstants.DATA_DOCTOR).optBoolean(DoctorConstants.DATA_SAMPLE)) {
                        str = DoctorConstants.DATA_NOT_SAMPLED;
                    }
                    safePrint("onDataEvent[" + i + "] " + str + " [service:" + jSONObject.optString("service") + "|logType:" + jSONObject.optString("log_type") + "] = ", jSONObject.toString(), str.contains("ERROR"));
                }

                private void safePrint(String str, String str2, boolean z) {
                    int length = (4000 - str.length()) - 5;
                    if (str2.length() <= length) {
                        if (z) {
                            Logger.m87e(TAG, str, " " + str2);
                            return;
                        } else {
                            Logger.m88i(TAG, str, " " + str2);
                            return;
                        }
                    }
                    int i = 0;
                    while (i < str2.length()) {
                        int i2 = i + length;
                        String substring = i2 < str2.length() ? str2.substring(i, i2) : str2.substring(i);
                        if (z) {
                            Logger.m87e(TAG, str, " " + substring);
                        } else {
                            Logger.m88i(TAG, str, " " + substring);
                        }
                        i = i2;
                    }
                }
            });
        }
    }
}
