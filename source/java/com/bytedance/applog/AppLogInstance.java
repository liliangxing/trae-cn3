package com.bytedance.applog;

import android.accounts.Account;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.bytedance.applog.bdinstall.BdInstallImpl;
import com.bytedance.applog.bdinstall.IBdInstallService;
import com.bytedance.applog.collector.Navigator;
import com.bytedance.applog.collector.NavigatorCallback;
import com.bytedance.applog.collector.PageHolder;
import com.bytedance.applog.engine.Engine;
import com.bytedance.applog.filter.AbstractEventFilter;
import com.bytedance.applog.filter.SamplingFilter;
import com.bytedance.applog.forward.EventForward;
import com.bytedance.applog.handler.IEventHandler;
import com.bytedance.applog.holder.EventObserverHolder;
import com.bytedance.applog.holder.LaunchObserverHolder;
import com.bytedance.applog.holder.SessionObserverHolder;
import com.bytedance.applog.isolate.DataIsolateKey;
import com.bytedance.applog.isolate.IDataIsolateCallback;
import com.bytedance.applog.log.AbsSingleton;
import com.bytedance.applog.log.ConsoleLogProcessor;
import com.bytedance.applog.log.CustomLogProcessor;
import com.bytedance.applog.log.EventBus;
import com.bytedance.applog.log.IAppLogLogger;
import com.bytedance.applog.log.LogMessageConstants;
import com.bytedance.applog.log.LogProcessorHolder;
import com.bytedance.applog.log.LogUtils;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.applog.manager.AppLogCache;
import com.bytedance.applog.manager.ConfigManager;
import com.bytedance.applog.manager.DeviceManager;
import com.bytedance.applog.monitor.LogReportMonitor;
import com.bytedance.applog.monitor.MonitorUtils;
import com.bytedance.applog.monitor.p006v3.EventStage;
import com.bytedance.applog.monitor.p006v3.MonitorV3Helper;
import com.bytedance.applog.monitor.p006v3.MonitorV3Utils;
import com.bytedance.applog.monitor.p006v3.StageEventType;
import com.bytedance.applog.monitor.p006v3.StatsCountKeys;
import com.bytedance.applog.params.CommonParamsApi;
import com.bytedance.applog.params.CommonParamsHelper;
import com.bytedance.applog.params.CommonParamsWrapper;
import com.bytedance.applog.params.EmptyCommonParams;
import com.bytedance.applog.priority.EventPriority;
import com.bytedance.applog.priority.PriorityCallbackImpl;
import com.bytedance.applog.priority.PriorityWrapper;
import com.bytedance.applog.server.Api;
import com.bytedance.applog.server.ApiParamsUtil;
import com.bytedance.applog.store.BaseData;
import com.bytedance.applog.store.Event;
import com.bytedance.applog.store.EventMisc;
import com.bytedance.applog.store.EventV3;
import com.bytedance.applog.store.Page;
import com.bytedance.applog.strategy.DefaultReportDropStrategy;
import com.bytedance.applog.strategy.IReportDropStrategy;
import com.bytedance.applog.task.BgSessionTaskCallback;
import com.bytedance.applog.util.DataObserverHolder;
import com.bytedance.applog.util.DefaultClient;
import com.bytedance.applog.util.DefaultCompress;
import com.bytedance.applog.util.EventsSenderUtils;
import com.bytedance.applog.util.TLog;
import com.bytedance.applog.util.Utils;
import com.bytedance.bdinstall.IBDInstallApi;
import com.bytedance.bdinstall.IExtraParams;
import com.bytedance.bdinstall.ILogger;
import com.bytedance.bdinstall.INetworkClient;
import com.bytedance.bdinstall.InstallInfo;
import com.bytedance.bdinstall.Level;
import com.bytedance.bdinstall.OnResetListener;
import com.bytedance.bdinstall.service.NUApi;
import com.bytedance.crash.entity.Header;
import com.bytedance.ies.argus.bean.ArgusConstants;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class AppLogInstance implements IAppLogInstance {
    private static final String EVENT_V1_CATEGORY = "event_v1";
    private static final long MAX_BASE_DATA_SIZE_LIMIT_1MB = 1048576;
    private static final String SECOND_APP_ID_KEY = "second_appid";
    private static final String SECOND_APP_NAME_KEY = "second_appname";
    private static final String SECOND_APP_PREFIX = "second_app_";
    private static final String SECOND_APP_PRODUCT_TYPE_KEY = "product_type";
    private static final String SECOND_APP_SPECIAL_KEY = "params_for_special";
    private static final String SECOND_APP_VALUE = "second_app";
    private final Api api;
    private final ApiParamsUtil apiParamsUtil;
    private volatile int batchProcessEvents;
    private volatile int batchProcessIntervalMills;
    private final List<String> blockHeaderKeys;
    private final AppLogCache cache;
    private final AbsSingleton<CommonParamsWrapper> commonParamsWrapper;
    private DataObserverHolder dataObserverHolder;
    private volatile Proxy defaultHttpClientProxy;
    private final INetworkClient defaultNetworkClient;
    private final EventObserverHolder eventObserverHolder;
    private final LaunchObserverHolder launchObserverHolder;
    private final IAppLogLogger logger;
    private volatile boolean mAdjustTerminate;
    private volatile Application mApp;
    private String mAppId;
    private volatile boolean mBDInstallEventTrackEnabled;
    private final IBdInstallService mBDInstallService;
    private volatile ConfigManager mConfig;
    private volatile IDataIsolateCallback mDataIsolateCallback;
    private volatile DeviceManager mDevice;
    private volatile boolean mEnableBgSessionTask;
    private volatile boolean mEnableBgSessionTaskReportOnPause;
    private volatile boolean mEnableEventInTouristMode;
    private volatile boolean mEnableEventPriority;
    private volatile boolean mEnableEventUserId;
    private volatile boolean mEncryptAndCompress;
    private volatile Engine mEngine;
    private volatile AbstractEventFilter mEventFilterFromClient;
    private final AtomicInteger mEventSamplingCapability;
    private volatile JSONObject mExpectedBatchIntervalConfig;
    private volatile boolean mGroupPriorityEnabled;
    private volatile IHeaderCustomTimelyCallback mHeaderCustomTimelyCallback;
    private volatile Integer mHttpMonitorPort;
    private volatile IAbSdkVersion mIAbSdkVersion;
    private volatile IBDAccountCallback mIBDAccountCallback;
    private volatile boolean mInsertByTransactionEnabled;
    private volatile boolean mInsertCacheEnabled;
    private volatile int mInsertCacheMaxCount;
    private volatile int mInsertCacheMaxIntervalMills;
    private volatile HashSet<String> mInsertCacheWhiteSet;
    private volatile boolean mInsertEventOptEnabled;
    private volatile boolean mIsTouristMode;
    private volatile boolean mIsolateEnabled;
    private volatile DataIsolateKey mIsolateKey;
    private int mLaunchFrom;
    private volatile boolean mLaunchPackDesc;
    private volatile ILogCompressor mLogCompressor;
    private volatile boolean mMigrateOldAppLogDataEnabled;
    private final Navigator mNav;
    private volatile boolean mStarted;
    private volatile boolean mUseAsyncFlushDefault;
    private final MonitorV3Helper monitorHelper;
    private final PageHolder pageHolder;
    private volatile Long preInitUserId;
    private PriorityWrapper priorityWrapper;
    private volatile boolean sCommonParamsEnabled;
    private volatile boolean sCustomHeaderControlEnabled;
    private volatile Integer sDisablePersonalization;
    private volatile boolean sEventForwardEnabled;
    private volatile ConcurrentHashMap<String, String> sEventForwardHttpHeaders;
    private volatile IEventHandler sEventHandler;
    private volatile boolean sEventParamControlEnabled;
    private volatile boolean sFlushThresholdEnabled;
    private final int sInstId;
    private final LogReportMonitor sLogReportMonitor;
    private final AtomicBoolean sLoggerInitialized;
    private volatile int sMaxPackOnceReport;
    private volatile boolean sNewMonitorEnabled;
    private volatile boolean sPriorityAutoStartEnabled;
    private volatile IReportDropStrategy sReportDropStrategy;
    private volatile boolean sServerFilterByNativeEnabled;
    private volatile boolean sServerFilterSaveToKevaEnabled;
    private volatile boolean sTerminateImmediately;
    private final SessionObserverHolder sessionObserverHolder;
    private static final List<AppLogInstance> sInstances = new CopyOnWriteArrayList();
    private static final AtomicInteger lastInstId = new AtomicInteger(0);

    @Override // com.bytedance.applog.IAppLogInstance
    public String getSdkVersion() {
        return "5.7.11-rc.1";
    }

    public AppLogInstance() {
        this.sessionObserverHolder = new SessionObserverHolder();
        this.eventObserverHolder = new EventObserverHolder();
        this.mLaunchFrom = 0;
        this.mAppId = "";
        this.mApp = null;
        this.mEncryptAndCompress = true;
        this.mEnableEventUserId = false;
        this.mIsTouristMode = false;
        this.mEnableEventInTouristMode = true;
        this.mAdjustTerminate = false;
        this.mEventSamplingCapability = new AtomicInteger(0);
        this.mEnableEventPriority = false;
        this.mGroupPriorityEnabled = false;
        this.mEnableBgSessionTask = false;
        this.mEnableBgSessionTaskReportOnPause = false;
        this.mUseAsyncFlushDefault = true;
        this.mInsertEventOptEnabled = false;
        this.batchProcessEvents = 5;
        this.batchProcessIntervalMills = 200;
        this.mInsertByTransactionEnabled = false;
        this.mInsertCacheEnabled = false;
        this.mInsertCacheWhiteSet = new HashSet<>();
        this.mInsertCacheMaxIntervalMills = 200;
        this.mInsertCacheMaxCount = 20;
        this.mMigrateOldAppLogDataEnabled = false;
        this.sTerminateImmediately = false;
        this.mLaunchPackDesc = false;
        this.mBDInstallEventTrackEnabled = false;
        this.sNewMonitorEnabled = false;
        this.sMaxPackOnceReport = 8;
        this.sReportDropStrategy = null;
        this.sLogReportMonitor = new LogReportMonitor();
        this.mIsolateEnabled = false;
        this.mExpectedBatchIntervalConfig = null;
        this.sEventHandler = null;
        this.priorityWrapper = null;
        this.sPriorityAutoStartEnabled = true;
        this.sEventForwardEnabled = false;
        this.sEventForwardHttpHeaders = new ConcurrentHashMap<>();
        this.sEventParamControlEnabled = false;
        this.sCustomHeaderControlEnabled = false;
        this.sCommonParamsEnabled = true;
        this.sFlushThresholdEnabled = true;
        this.sServerFilterByNativeEnabled = false;
        this.sServerFilterSaveToKevaEnabled = false;
        this.commonParamsWrapper = new AbsSingleton<CommonParamsWrapper>() { // from class: com.bytedance.applog.AppLogInstance.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bytedance.applog.log.AbsSingleton
            public CommonParamsWrapper create(Object... objArr) {
                return new CommonParamsWrapper(String.valueOf(hashCode()));
            }
        };
        this.sLoggerInitialized = new AtomicBoolean(false);
        this.blockHeaderKeys = new CopyOnWriteArrayList();
        this.sInstId = lastInstId.getAndIncrement();
        this.logger = new LoggerImpl();
        this.api = new Api(this);
        this.launchObserverHolder = new LaunchObserverHolder(this);
        this.apiParamsUtil = new ApiParamsUtil(this);
        this.defaultNetworkClient = new DefaultClient(this);
        sInstances.add(this);
        this.cache = new AppLogCache(this);
        this.mBDInstallService = new BdInstallImpl(this);
        this.mNav = new Navigator(this);
        this.monitorHelper = new MonitorV3Helper();
        this.pageHolder = new PageHolder();
    }

    public AppLogInstance(Context context, InitConfig initConfig) {
        this();
        init(context, initConfig);
    }

    public String toString() {
        return "AppLogInstance{id:" + this.sInstId + ";appId:" + this.mAppId + "}@" + hashCode();
    }

    public static List<AppLogInstance> getAllInstances() {
        return sInstances;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public String getAppId() {
        return this.mAppId;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public Context getContext() {
        return this.mApp;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void init(Context context, InitConfig initConfig) {
        synchronized (AppLogInstance.class) {
            if (TextUtils.isEmpty(initConfig.getAid())) {
                throw new IllegalStateException("App id must not be empty!");
            }
            if (AppLogHelper.hasInstanceByAppId(initConfig.getAid())) {
                throw new IllegalStateException("The app id is init already!");
            }
            getLogger().setAppId(initConfig.getAid());
            this.mAppId = initConfig.getAid();
            this.mApp = (Application) context.getApplicationContext();
            if (initConfig.isLogEnable() && this.sLoggerInitialized.compareAndSet(false, true)) {
                if (initConfig.getLogger() != null) {
                    LogProcessorHolder.setProcessor(this.mAppId, new CustomLogProcessor(initConfig.getLogger()));
                } else {
                    LogProcessorHolder.setProcessor(this.mAppId, new ConsoleLogProcessor(this));
                }
            }
            getLogger().info("App:{} init begin...", this.mAppId);
            if (TextUtils.isEmpty(initConfig.getSpName())) {
                initConfig.setSpName(AppLogHelper.getInstanceSpName(this, ConfigManager.SP_FILE));
            }
            sendConfig2DevTools(initConfig);
            this.mConfig = new ConfigManager(this, this.mApp, initConfig);
            initDefaultCompress();
            this.mDevice = new DeviceManager(this, this.mConfig, this.mBDInstallService);
            this.mEngine = new Engine(this, this.mConfig, this.mDevice, this.mBDInstallService, initConfig.getBDInstallInitHook(), this.cache);
            if (initConfig.isHandleLifeCycle()) {
                this.mApp.registerActivityLifecycleCallbacks(this.mNav);
            }
            this.mLaunchFrom = 1;
            this.mStarted = initConfig.autoStart();
            if (this.preInitUserId != null) {
                setUserID(this.preInitUserId.longValue());
                this.preInitUserId = null;
            }
            if (isGroupPriorityEnabled()) {
                String[] sendUris = this.mEngine.getUriConfig().getSendUris();
                this.priorityWrapper = new PriorityWrapper(context, this.mAppId, sendUris.length > 0 ? sendUris[0] : "", initConfig.isLogEnable(), new PriorityCallbackImpl(this));
            }
            if (initConfig.isCongestionControlEnable()) {
                getMonitorHelper().setFeature("congestion_enable", 1L);
            }
            if (initConfig.isSilenceInBackground()) {
                getMonitorHelper().setFeature("silence_in_background", 1L);
            }
            if (initConfig.isEventFilterEnable()) {
                getMonitorHelper().setFeature("event_filter_enable", 1L);
            }
            if (initConfig.isStopOnEnterBackgroundEnabled()) {
                getMonitorHelper().setFeature("stop_on_enter_background", 1L);
            }
            if (initConfig.isHandleLifeCycle()) {
                getMonitorHelper().setFeature("handle_lifecycle_enable", 1L);
            }
            LogUtils.sendString("init_end", this.mAppId);
            getLogger().info("App:{} init end.", this.mAppId);
            this.mConfig.sendOriginCachedConfig2DevTools();
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void start() {
        if (this.mStarted) {
            return;
        }
        this.mStarted = true;
        this.mEngine.start();
        getLogger().info("System start!", new Object[0]);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void stop() {
        getLogger().info("System stop!", new Object[0]);
        if (this.mStarted) {
            this.mStarted = false;
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public boolean hasStarted() {
        return this.mStarted;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void destroy() {
        if (this.mApp != null) {
            this.mEngine.destroy();
            this.mLaunchFrom = 0;
            this.mStarted = false;
            this.mEngine = null;
            this.mDevice = null;
            this.mConfig = null;
            this.mApp = null;
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public InitConfig getInitConfig() {
        if (this.mConfig != null) {
            return this.mConfig.getInitConfig();
        }
        return null;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void flush() {
        if (this.mUseAsyncFlushDefault) {
            flushAsync();
            return;
        }
        if (this.mEngine != null) {
            this.mEngine.process(null, true);
        }
        getMonitorHelper().increaseStats(StatsCountKeys.FLUSH_COUNT);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void flushAsync() {
        if (this.mEngine != null) {
            this.mEngine.sendImmediately();
        }
        getMonitorHelper().increaseStats(StatsCountKeys.FLUSH_COUNT);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setUserID(long j) {
        if (this.mEngine == null || this.mEngine.getSession() == null) {
            this.preInitUserId = Long.valueOf(j);
        } else if (this.mEngine.getSession().getUserId() != j) {
            this.mEngine.getSession().setUserId(j);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setAppLanguageAndRegion(String str, String str2) {
        if (this.mEngine != null) {
            this.mEngine.setLanguageAndRegion(str, str2);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public String addNetCommonParams(Context context, String str, boolean z, Level level) {
        return addNetCommonParams(context, new StringBuilder(str), z, level);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public String addNetCommonParams(Context context, StringBuilder sb, boolean z, Level level) {
        return this.mBDInstallService.addNetCommonParams(context, sb, z, level);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void putCommonParams(Context context, Map<String, String> map, boolean z, Level level) {
        this.mBDInstallService.putCommonParams(context, map, z, level);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setUserUniqueID(String str) {
        if (this.mEngine != null) {
            this.mEngine.setUserUniqueId(str);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setExtraParams(IExtraParams iExtraParams) {
        this.mBDInstallService.setCommonExtraParam(iExtraParams);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setEventSenderEnable(boolean z, String str) {
        if (TextUtils.isEmpty(getAppId())) {
            getLogger().warn("Not init before change event sender", new Object[0]);
            return;
        }
        EventsSenderUtils.setEventsSenderEnable(getAppId(), z, getContext());
        if (!TextUtils.isEmpty(str)) {
            EventsSenderUtils.setEventVerifyHost(getAppId(), str);
        }
        getMonitorHelper().setFeature("et_enable", z);
        getMonitorHelper().setFeature("et_host", str);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setTouchPoint(String str) {
        setHeaderInfo(Api.KEY_TOUCH_POINT, str);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setHeaderInfo(HashMap<String, Object> hashMap) {
        this.mBDInstallService.setHeaderInfo(hashMap);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setHeaderInfo(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put(str, obj);
        this.mBDInstallService.setHeaderInfo(hashMap);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void removeHeaderInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mBDInstallService.removeHeaderInfo(str);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setExternalAbVersion(String str) {
        if (this.mDevice != null) {
            this.mDevice.setExternalAbVersion(str);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public String getAbSdkVersion() {
        if (this.mEngine == null) {
            return null;
        }
        long userId = this.mEngine.getSession().getUserId();
        IBDAccountCallback bDAccountCallback = getBDAccountCallback();
        if (bDAccountCallback != null) {
            userId = ((Long) bDAccountCallback.getOdinUserInfo().second).longValue();
        }
        return getAbSdkVersion(String.valueOf(userId));
    }

    public String getAbSdkVersion(String str) {
        IAbSdkVersion iAbSdkVersion = this.mIAbSdkVersion;
        if (iAbSdkVersion != null) {
            return iAbSdkVersion.getAbSdkVersion(str);
        }
        if (this.mDevice != null) {
            return this.mDevice.getAbSdkVersion();
        }
        return null;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public String getAid() {
        return getAppId();
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public <T> T getHeaderValue(String str, T t, Class<T> cls) {
        if (this.mDevice != null) {
            return (T) this.mDevice.getHeaderValue(str, t, cls);
        }
        return null;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setUserAgent(String str) {
        this.mBDInstallService.setUserAgent(getContext(), str);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void onEvent(String str, String str2, String str3, long j, long j2, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            getLogger().warn("category or tag is empty", new Object[0]);
        } else {
            receive(new Event(this.mAppId, str, str2, str3, j, j2, transferEventParamFromJsonToString(StageEventType.V1_EVENT, str2, str3, jSONObject)));
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void onEventString(String str, String str2, String str3, long j, long j2, String str4) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            getLogger().warn("category or tag is empty", new Object[0]);
        } else {
            receive(new Event(this.mAppId, str, str2, str3, j, j2, str4));
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void onEvent(String str, String str2, String str3, long j, long j2) {
        onEvent(str, str2, str3, j, j2, null);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void onEvent(String str, String str2) {
        onEvent(EVENT_V1_CATEGORY, str, str2, 0L, 0L, null);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void onEvent(String str) {
        onEvent(EVENT_V1_CATEGORY, str, null, 0L, 0L, null);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void onEventV3(String str) {
        onEventV3Inner(str, null);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void onEventV3(String str, JSONObject jSONObject) {
        onEventV3Inner(str, jSONObject);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void onEventV3String(String str, String str2) {
        onEventV3InnerString(str, str2);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void onEventV3(String str, Bundle bundle) {
        JSONObject jSONObject = null;
        if (bundle != null) {
            try {
                if (!bundle.isEmpty()) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        for (String str2 : bundle.keySet()) {
                            jSONObject2.put(str2, bundle.get(str2));
                        }
                        jSONObject = jSONObject2;
                    } catch (Throwable th) {
                        th = th;
                        jSONObject = jSONObject2;
                        getLogger().error("parse bundle params failed", th, new Object[0]);
                        getMonitorHelper().increaseStats(StatsCountKeys.JSON_ERROR_COUNT);
                        onEventV3Inner(str, jSONObject);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        onEventV3Inner(str, jSONObject);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void onInternalEventV3(String str, JSONObject jSONObject, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            getLogger().warn("both second appid and second app name is empty, return", new Object[0]);
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str5 = SECOND_APP_PREFIX + str;
        try {
            jSONObject.put(SECOND_APP_SPECIAL_KEY, SECOND_APP_VALUE);
            jSONObject.put(SECOND_APP_ID_KEY, str2);
            jSONObject.put(SECOND_APP_NAME_KEY, str3);
            jSONObject.put(SECOND_APP_PRODUCT_TYPE_KEY, str4);
        } catch (Throwable th) {
            getLogger().error("prepare params failed", th, new Object[0]);
            getMonitorHelper().increaseStats(StatsCountKeys.JSON_ERROR_COUNT);
        }
        onEventV3Inner(str5, jSONObject);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void onInternalEventV3(String str, Bundle bundle, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            getLogger().warn("both second appid and second app name is empty, return", new Object[0]);
            return;
        }
        String str5 = SECOND_APP_PREFIX + str;
        JSONObject jSONObject = null;
        if (bundle != null) {
            try {
                if (!bundle.isEmpty()) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        for (String str6 : bundle.keySet()) {
                            jSONObject2.put(str6, bundle.get(str6));
                        }
                        jSONObject2.put(SECOND_APP_SPECIAL_KEY, SECOND_APP_VALUE);
                        jSONObject2.put(SECOND_APP_ID_KEY, str2);
                        jSONObject2.put(SECOND_APP_NAME_KEY, str3);
                        jSONObject2.put(SECOND_APP_PRODUCT_TYPE_KEY, str4);
                        jSONObject = jSONObject2;
                    } catch (Throwable th) {
                        th = th;
                        jSONObject = jSONObject2;
                        getLogger().error("prepare params failed", th, new Object[0]);
                        getMonitorHelper().increaseStats(StatsCountKeys.JSON_ERROR_COUNT);
                        onEventV3Inner(str5, jSONObject);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        onEventV3Inner(str5, jSONObject);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void onMiscEvent(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject.length() <= 0) {
            getLogger().warn("call onEventData with invalid params, return", new Object[0]);
            return;
        }
        try {
            receive(new EventMisc(this.mAppId, str, jSONObject));
        } catch (Exception e) {
            if (getMonitorHelper().isEventMaybeAccepted(str)) {
                getMonitorHelper().stageEvent(EventStage.PARAMS_INVALID_DROP, str, MonitorV3Utils.getNewMonitorIdString(), System.currentTimeMillis(), StageEventType.LOG_DATA);
            }
            getLogger().error("call onEventData get exception: ", e, new Object[0]);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setEncryptAndCompress(boolean z) {
        this.mEncryptAndCompress = z;
        getMonitorHelper().setFeature("encrypt_enable", z ? 1L : 0L);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public boolean getEncryptAndCompress() {
        return this.mEncryptAndCompress;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public boolean manualActivate() {
        return this.mBDInstallService.manualActivate();
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public String getDid() {
        return this.mBDInstallService.getDid();
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void addSessionHook(ISessionObserver iSessionObserver) {
        this.sessionObserverHolder.addSessionHook(iSessionObserver);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void removeSessionHook(ISessionObserver iSessionObserver) {
        this.sessionObserverHolder.removeSessionHook(iSessionObserver);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void addEventObserver(int i, IEventObserver iEventObserver) {
        this.eventObserverHolder.addEventObserver(i, iEventObserver);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void addEventObserver(IEventObserver iEventObserver) {
        this.eventObserverHolder.addEventObserver(0, iEventObserver);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void removeEventObserver(IEventObserver iEventObserver) {
        this.eventObserverHolder.removeEventObserver(iEventObserver);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setAccount(Account account) {
        this.mBDInstallService.setAccount(account);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public String getIid() {
        return this.mBDInstallService.getIid();
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public String getSsid() {
        return this.mBDInstallService.getSsid();
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public String getUserUniqueID() {
        return this.mDevice != null ? this.mDevice.getUserUniqueId() : "";
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public String getUserID() {
        if (this.mEngine != null) {
            return String.valueOf(this.mEngine.getSession().getUserId());
        }
        return null;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public String getClientUdid() {
        return this.mBDInstallService.getClientUdid();
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public String getOpenUdid() {
        return this.mBDInstallService.getOpenUdid();
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setUriRuntime(UriConfig uriConfig) {
        if (this.mEngine != null) {
            this.mEngine.setUriConfig(uriConfig);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public boolean isNewUserMode(Context context) {
        return this.mBDInstallService.isNewUserMode(context);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setNewUserMode(Context context, boolean z) {
        this.mBDInstallService.setNewUserMode(context, z);
        sendUpdateConfig2Devtools(LogMessageConstants.CONFIG_NEW_USER_MODE, Boolean.valueOf(z));
        getMonitorHelper().setFeature(com.bytedance.bdinstall.Api.KEY_NEW_USER_MODE, z);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public NUApi newUserMode(Context context) {
        return this.mBDInstallService.newUserMode(context);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public boolean isNewUserModeAvailable() {
        return this.mBDInstallService.isNewUserAvailable();
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void getSsidGroup(Map<String, String> map) {
        InstallInfo installInfo = this.mBDInstallService.getInstallInfo();
        if (installInfo != null) {
            String did = installInfo.getDid();
            if (!TextUtils.isEmpty(did)) {
                map.put("device_id", did);
            }
            String iid = installInfo.getIid();
            if (!TextUtils.isEmpty(iid)) {
                map.put("install_id", iid);
            }
            String openUdid = installInfo.getOpenUdid();
            if (!TextUtils.isEmpty(openUdid)) {
                map.put("openudid", openUdid);
            }
            String clientUdid = installInfo.getClientUdid();
            if (TextUtils.isEmpty(clientUdid)) {
                return;
            }
            map.put("clientudid", clientUdid);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public synchronized void addDataObserver(IDataObserver iDataObserver) {
        if (this.dataObserverHolder == null) {
            this.dataObserverHolder = new DataObserverHolder();
        }
        this.dataObserverHolder.addDataObserver(iDataObserver);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void removeDataObserver(IDataObserver iDataObserver) {
        DataObserverHolder dataObserverHolder = this.dataObserverHolder;
        if (dataObserverHolder != null) {
            dataObserverHolder.removeDataObserver(iDataObserver);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void removeAllDataObserver() {
        DataObserverHolder dataObserverHolder = this.dataObserverHolder;
        if (dataObserverHolder != null) {
            dataObserverHolder.removeAllDataObserver();
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public INetworkClient getNetClient() {
        INetworkClient networkClient = this.mConfig.getInitConfig().getNetworkClient();
        return networkClient != null ? networkClient : this.defaultNetworkClient;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public JSONObject getHeader() {
        if (this.mDevice == null) {
            getLogger().warn("Init first please to get header", new Object[0]);
            return null;
        }
        return this.mDevice.getCopiedHeader();
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setAppTrack(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.mBDInstallService.setAppTrack(getContext(), jSONObject);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public boolean isNewUser() {
        return this.mBDInstallService.isNewUserFirstLaunch();
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void onResume(Context context) {
        if (context instanceof Activity) {
            onActivityResumed((Activity) context, context.hashCode());
        } else {
            getLogger().error("onResume context: " + (context == null ? ArgusConstants.NULL_PLACE_HOLDER : context.getClass().getName()), new Object[0]);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void onPause(Context context) {
        if (context instanceof Activity) {
            onActivityPause();
        } else {
            getLogger().error("onPause context: " + (context == null ? ArgusConstants.NULL_PLACE_HOLDER : context.getClass().getName()), new Object[0]);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void onActivityResumed(Activity activity, int i) {
        if (activity != null) {
            this.mNav.onActivityResumed(activity);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void onActivityResumed(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mNav.onActivityResumed(str, i);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void onActivityPause() {
        this.mNav.onActivityPaused(null);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void registerHeaderCustomCallback(IHeaderCustomTimelyCallback iHeaderCustomTimelyCallback) {
        this.mHeaderCustomTimelyCallback = iHeaderCustomTimelyCallback;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public IHeaderCustomTimelyCallback getHeaderCustomCallback() {
        return this.mHeaderCustomTimelyCallback;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public int getHttpMonitorPort() {
        if (this.mHttpMonitorPort != null) {
            return this.mHttpMonitorPort.intValue();
        }
        if (this.mConfig != null) {
            return this.mConfig.getHttpMonitorPort();
        }
        return 0;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setHttpMonitorPort(int i) {
        this.mHttpMonitorPort = Integer.valueOf(i);
        getMonitorHelper().setFeature("http_monitor_port", i);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setEventFilterByClient(List<String> list, boolean z) {
        long j;
        this.mEventFilterFromClient = AbstractEventFilter.parseFilterFromClient(this, list, z);
        MonitorV3Helper monitorHelper = getMonitorHelper();
        if (list != null) {
            j = z ? 1 : 2;
        } else {
            j = 0;
        }
        monitorHelper.setFeature("custom_event_filter", j);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public AbstractEventFilter getEventFilterByClient() {
        return this.mEventFilterFromClient;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public Map<String, String> getRequestHeader() {
        return this.mBDInstallService.getRequestHeader();
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public String getSessionId() {
        if (this.mEngine != null) {
            return this.mEngine.getSessionId();
        }
        return null;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void registerAbSdkVersionCallback(IAbSdkVersion iAbSdkVersion) {
        this.mIAbSdkVersion = iAbSdkVersion;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setEnableEventUserId(boolean z) {
        this.mEnableEventUserId = z;
        sendUpdateConfig2Devtools(LogMessageConstants.CONFIG_EVENT_USER_ID, Boolean.valueOf(z));
        getMonitorHelper().setFeature("event_uid_enable", z);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public boolean getEnableEventUserId() {
        return this.mEnableEventUserId;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setBDAccountCallback(IBDAccountCallback iBDAccountCallback) {
        this.mIBDAccountCallback = iBDAccountCallback;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public IBDAccountCallback getBDAccountCallback() {
        return this.mIBDAccountCallback;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setTouristMode(boolean z) {
        this.mIsTouristMode = z;
        getMonitorHelper().setFeature("tourist_mode", z);
        sendUpdateConfig2Devtools(LogMessageConstants.CONFIG_TOURIST_MODE_SWITCH, Boolean.valueOf(z));
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public boolean isTouristMode() {
        return this.mIsTouristMode;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setEnableEventInTouristMode(boolean z) {
        this.mEnableEventInTouristMode = z;
        getMonitorHelper().setFeature("tourist_mode_event_enable", z);
        sendUpdateConfig2Devtools(LogMessageConstants.CONFIG_TOURIST_MODE_EVENT_SWITCH, Boolean.valueOf(z));
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public boolean isEnableEventInTouristMode() {
        return this.mEnableEventInTouristMode;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public boolean getAdjustTerminate() {
        return this.mAdjustTerminate;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setAdjustTerminate(boolean z) {
        this.mAdjustTerminate = z;
        sendUpdateConfig2Devtools(LogMessageConstants.CONFIG_DAU_FIX_SWITCH, Boolean.valueOf(z));
        getMonitorHelper().setFeature("dau_fix", z);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setEventSamplingEnable(boolean z) {
        if (z) {
            AtomicInteger atomicInteger = this.mEventSamplingCapability;
            atomicInteger.set(atomicInteger.get() | 1);
        } else {
            AtomicInteger atomicInteger2 = this.mEventSamplingCapability;
            atomicInteger2.set(atomicInteger2.get() & (-2));
        }
        sendUpdateConfig2Devtools(LogMessageConstants.CONFIG_EVENT_SAMPLING, Boolean.valueOf(z));
        getMonitorHelper().setFeature("normal_sample_enable", z);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setTeaEventSamplingEnable(boolean z) {
        if (z) {
            AtomicInteger atomicInteger = this.mEventSamplingCapability;
            atomicInteger.set(atomicInteger.get() | 2);
        } else {
            AtomicInteger atomicInteger2 = this.mEventSamplingCapability;
            atomicInteger2.set(atomicInteger2.get() & (-3));
        }
        sendUpdateConfig2Devtools(LogMessageConstants.CONFIG_TEA_EVENT_SAMPLING, Boolean.valueOf(z));
        getMonitorHelper().setFeature("tea_sample_enable", z);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setEnableEventPriority(boolean z) {
        this.mEnableEventPriority = z;
        getMonitorHelper().setFeature("priority_enable", z);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public boolean isEnableEventPriority() {
        return this.mEnableEventPriority;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setGroupPriorityEnable(boolean z) {
        this.mGroupPriorityEnabled = z;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public boolean isGroupPriorityEnabled() {
        return this.mGroupPriorityEnabled;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setAutoStartGroupPriority(boolean z) {
        this.sPriorityAutoStartEnabled = z;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void initGroupPriority() {
        if (this.mEngine != null) {
            this.mEngine.initGroupPriority();
        } else {
            getLogger().error("init priority failed for not init engine!", new Object[0]);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public int getLaunchFrom() {
        return this.mLaunchFrom;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setLaunchFrom(int i) {
        this.mLaunchFrom = i;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setDefaultHttpClientProxy(Proxy proxy) {
        this.defaultHttpClientProxy = proxy;
        sendUpdateConfig2Devtools(LogMessageConstants.CONFIG_HTTP_PROXY, Boolean.valueOf(proxy != null));
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public SamplingFilter getSamplingFilter() {
        if (this.mEngine != null) {
            return this.mEngine.getEventSampling();
        }
        return null;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setBgSessionReportOnPause(boolean z) {
        this.mEnableBgSessionTaskReportOnPause = z;
        getMonitorHelper().setFeature("bg_session_report_after_pause_enable", z);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void onBgSessionTaskResume() {
        if (this.mEngine != null) {
            this.mEngine.onBgSessionTaskResume();
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void onBgSessionTaskPause() {
        if (this.mEngine != null) {
            this.mEngine.onBgSessionTaskPause();
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setBgSessionTaskEnabled(boolean z) {
        this.mEnableBgSessionTask = z;
        getMonitorHelper().setFeature("bg_session_enable", z);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public boolean isEnableBgSessionTask() {
        if (getInitConfig() == null || !getInitConfig().isStopOnEnterBackgroundEnabled()) {
            return this.mEnableBgSessionTask;
        }
        return false;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void registerTaskCallback(BgSessionTaskCallback bgSessionTaskCallback) {
        if (this.mEngine != null) {
            this.mEngine.getBgTaskPresenter().registerTaskCallback(bgSessionTaskCallback);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setBgSessionTaskNavigatorCallback(NavigatorCallback navigatorCallback) {
        if (this.mEngine != null) {
            this.mEngine.getBgTaskPresenter().setBgSessionTaskNavigatorCallback(navigatorCallback);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setDataIsolateEnabled(boolean z) {
        this.mIsolateEnabled = z;
        getMonitorHelper().setFeature("isolate_enable", z);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public boolean isDataIsolateEnabled() {
        return this.mIsolateEnabled;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setDataIsolateKey(DataIsolateKey dataIsolateKey) {
        this.mIsolateKey = dataIsolateKey;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public DataIsolateKey getDataIsolateKey() {
        return this.mIsolateKey;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setDataIsolateCallback(IDataIsolateCallback iDataIsolateCallback) {
        this.mDataIsolateCallback = iDataIsolateCallback;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public IDataIsolateCallback getDataIsolateCallback() {
        return this.mDataIsolateCallback;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setExpectedBatchInterval(String str, String str2, int i) {
        if (i < 0) {
            getLogger().warn("interval must not less than 0", new Object[0]);
            return;
        }
        if (this.mExpectedBatchIntervalConfig == null) {
            this.mExpectedBatchIntervalConfig = new JSONObject();
        }
        try {
            this.mExpectedBatchIntervalConfig.put("interval", i);
            this.mExpectedBatchIntervalConfig.put("caller", str);
            this.mExpectedBatchIntervalConfig.put(Header.KEY_UNIQUE_KEY, str2);
        } catch (Throwable th) {
            getLogger().error("json build ExpectedBatchInterval failed", th, new Object[0]);
            getMonitorHelper().increaseStats(StatsCountKeys.JSON_ERROR_COUNT);
        }
        getMonitorHelper().setFeature("expected_batch_interval_config", Utils.copyJson(this.mExpectedBatchIntervalConfig));
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public JSONObject getExpectedBatchInterval() {
        return this.mExpectedBatchIntervalConfig;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public JSONObject getLogback() {
        if (this.mConfig == null) {
            getLogger().warn("call getLogback after init plz.", new Object[0]);
            return null;
        }
        return this.mConfig.getLogback();
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void clearWhenSwitchChildMode(boolean z) {
        if (this.mEngine != null) {
            this.mEngine.clearWhenSwitchChildMode(z);
        }
        getMonitorHelper().setFeature("child_mode", z);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void resetDidWhenSwitchChildMode(Context context, boolean z, long j, OnResetListener onResetListener) {
        if (this.mEngine != null) {
            this.mEngine.resetDidWhenSwitchChildMode(z, j, onResetListener);
        }
        getMonitorHelper().setFeature("child_mode", z);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void clearAndSetEnv() {
        if (this.mEngine != null) {
            this.mEngine.clearAndSetEnv();
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void resetAndReInstall(long j, OnResetListener onResetListener) {
        if (this.mEngine != null) {
            this.mEngine.resetAndReInstall(j, onResetListener);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setDisablePersonalization(int i) {
        this.sDisablePersonalization = Integer.valueOf(i);
        getMonitorHelper().setFeature("disable_personalization_enable", i > 0);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public Integer getDisablePersonalization() {
        return this.sDisablePersonalization;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setLogCompressor(ILogCompressor iLogCompressor) {
        this.mLogCompressor = iLogCompressor;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public ILogCompressor getLogCompressor() {
        return this.mLogCompressor;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void addLaunchObserver(ILaunchObserver iLaunchObserver) {
        this.launchObserverHolder.addObserver(iLaunchObserver);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void removeLaunchObserver(ILaunchObserver iLaunchObserver) {
        this.launchObserverHolder.removeObserver(iLaunchObserver);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void receive(BaseData baseData) {
        if (baseData == null) {
            return;
        }
        baseData.setAppId(getAppId());
        baseData.setPageInfo(this.pageHolder.getPageInfo());
        if ((baseData instanceof EventV3) || (baseData instanceof Event) || (baseData instanceof EventMisc)) {
            getMonitorHelper().increaseStats(StatsCountKeys.COLLECT_EVENT_COUNT);
            baseData.sentryStained = MonitorUtils.getStainedValue(getMonitorHelper(), baseData);
            if (baseData.sentryStained > 0) {
                MonitorUtils.stageEvent(getMonitorHelper(), EventStage.PRE_PROCESS_START, baseData);
            }
        }
        notifyEventObserverBeforeReceive(baseData);
        if (this.mEngine == null) {
            this.cache.cache(baseData);
            if (baseData.sentryStained > 0) {
                MonitorUtils.stageEvent(getMonitorHelper(), EventStage.CACHED_BEFORE_HANDLE, baseData);
            }
        } else {
            this.mEngine.receive(baseData);
        }
        if (baseData.size() > 1048576) {
            getMonitorHelper().sendError("receive data too big (>1MB)", new Throwable(baseData.toString()));
        }
        LogUtils.sendObject("event_receive", baseData);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void receive(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            sb.append(str);
            sb.append(",");
        }
        if (this.mEngine == null) {
            this.cache.cache(strArr);
        } else {
            this.mEngine.receive(strArr);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setBatchProcessEventCount(int i) {
        this.batchProcessEvents = Math.max(i, 1);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setBatchProcessInterval(int i) {
        this.batchProcessIntervalMills = Math.max(i, 100);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setInsertEventOptEnabled(boolean z) {
        this.mInsertEventOptEnabled = z;
        getMonitorHelper().setFeature("insert_event_opt_enable", z);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public boolean isInsertEventOptEnabled() {
        return this.mInsertEventOptEnabled;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setMigrateOldAppLogDataEnabled(boolean z) {
        this.mMigrateOldAppLogDataEnabled = z;
        getMonitorHelper().setFeature("migrate_old_applog_data_enable", z);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setNewMonitorEnabled(boolean z) {
        this.sNewMonitorEnabled = z;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setNewMonitorInDebugMode(boolean z) {
        getMonitorHelper().getConfigManager().setDebug(z);
        getMonitorHelper().setFeature("monitor_debug_mode", z);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void forceTimeoutReportSync(long j) {
        if (this.mEngine != null) {
            this.mEngine.forceTimeoutReportSync(j);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setTerminateImmediately(boolean z) {
        this.sTerminateImmediately = z;
        getMonitorHelper().setFeature("terminate_immediately_enable", z);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setMaxRequestOnceReport(int i) {
        this.sMaxPackOnceReport = Math.min(Math.max(1, i), 8);
        getMonitorHelper().setFeature("max_request_once_report", i);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public boolean isEventHitStickySamplingDrop(String str) {
        if (getEventSamplingCapability() == 0 || this.mEngine == null) {
            return false;
        }
        return this.mEngine.isEventAndParamsHitStickySamplingDrop(str, null);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public boolean isEventHitStickySamplingDrop(String str, JSONObject jSONObject) {
        if (getEventSamplingCapability() == 0 || this.mEngine == null) {
            return false;
        }
        return this.mEngine.isEventAndParamsHitStickySamplingDrop(str, jSONObject);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setReportDropStrategy(IReportDropStrategy iReportDropStrategy) {
        this.sReportDropStrategy = iReportDropStrategy;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void addLogReportMonitor(ILogReportMonitor iLogReportMonitor) {
        this.sLogReportMonitor.addMonitor(iLogReportMonitor);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setEventHandler(IEventHandler iEventHandler) {
        this.sEventHandler = iEventHandler;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setEventForwardEnabled(boolean z) {
        this.sEventForwardEnabled = z;
        getMonitorHelper().setFeature("event_forward_enable", z);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setEventForwardHttpHeader(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str2 == null) {
            this.sEventForwardHttpHeaders.remove(str);
        } else {
            this.sEventForwardHttpHeaders.put(str, str2);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setMaxCacheEventNum(int i) {
        this.cache.setMaxCacheEventNum(i);
        getMonitorHelper().setFeature("max_cache_event_num", i);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setPackLaunchByDesc(boolean z) {
        this.mLaunchPackDesc = z;
        getMonitorHelper().setFeature("pack_launch_desc", z);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setBDInstallEventTrackEnabled(boolean z) {
        this.mBDInstallEventTrackEnabled = z;
        getMonitorHelper().setFeature("bdinstall_event_enable", z);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setTrackResumeEvent(boolean z) {
        this.mNav.setTrackResumeEvent(z);
        getMonitorHelper().setFeature("track_resume_event_enable", z);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setFlushAsyncDefault(boolean z) {
        this.mUseAsyncFlushDefault = z;
        getMonitorHelper().setFeature("flush_async_default_enable", z);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setFlushThresholdEnable(boolean z) {
        this.sFlushThresholdEnabled = z;
        getMonitorHelper().setFeature("flush_threshold_enable", z);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public MonitorV3Helper getMonitorHelper() {
        return this.monitorHelper;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void blockHeaderKey(String str) {
        this.blockHeaderKeys.add(str);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void allowHeaderKey(String str) {
        this.blockHeaderKeys.remove(str);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void addRegisterCustomHeader(Context context, JSONObject jSONObject) {
        this.mBDInstallService.addRegisterCustomHeader(context, jSONObject);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public IBDInstallApi getBDInstallApi() {
        return this.mBDInstallService.getBDInstallApi();
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setEventParamControlEnabled(boolean z) {
        this.sEventParamControlEnabled = z;
        getMonitorHelper().setFeature("event_param_control_enable", z);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setCustomHeaderControlEnabled(boolean z) {
        this.sCustomHeaderControlEnabled = z;
        getMonitorHelper().setFeature("custom_header_control_enable", z);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public int clearEngineDataListIfCacheTooLarge() {
        if (this.mEngine != null) {
            return this.mEngine.clearDataListIfCacheTooLarge();
        }
        return 0;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setNavigatorCallback(NavigatorCallback navigatorCallback) {
        this.mNav.setCallback(navigatorCallback);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setCommonParamsEnabled(boolean z) {
        this.sCommonParamsEnabled = z;
        if (this.sCommonParamsEnabled) {
            return;
        }
        this.commonParamsWrapper.get(new Object[0]).destroy();
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public CommonParamsApi getCommonParams() {
        return isCommonParamsEnabled() ? this.commonParamsWrapper.get(new Object[0]) : EmptyCommonParams.INSTANCE;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setLogger(ILogger iLogger) {
        if (getInitConfig() == null && this.sLoggerInitialized.compareAndSet(false, true)) {
            LogProcessorHolder.addProcessor(new CustomLogProcessor(iLogger));
            getCommonParamsHelper().setLogEnable(true);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setPageInfoEnabled(boolean z) {
        this.pageHolder.setEnabled(z);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setPageId(String str) {
        this.pageHolder.setPageId(str);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setPageName(String str) {
        this.pageHolder.setPageName(str);
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setServerFilterByNative(boolean z) {
        this.sServerFilterByNativeEnabled = z;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setServerFilterSaveToKeva(boolean z) {
        this.sServerFilterSaveToKevaEnabled = z;
    }

    private void notifyEventObserverBeforeReceive(BaseData baseData) {
        if (this.eventObserverHolder.noStage(1)) {
            return;
        }
        try {
            if (baseData instanceof Event) {
                Event event = (Event) baseData;
                this.eventObserverHolder.onEvent(1, event.category, event.tag, event.label, event.value, event.extValue, event.param);
            } else if (baseData instanceof EventV3) {
                EventV3 eventV3 = (EventV3) baseData;
                this.eventObserverHolder.onEventV3(1, eventV3.getEvent(), eventV3.getContent());
            } else if (baseData instanceof EventMisc) {
                EventMisc eventMisc = (EventMisc) baseData;
                this.eventObserverHolder.onMiscEvent(1, eventMisc.getLogType(), eventMisc.getContent());
            }
        } catch (Throwable th) {
            getLogger().error(4, "notify event observer before receive failed", th, new Object[0]);
            getMonitorHelper().sendError("notify event observer before receive failed", th);
        }
    }

    private void initDefaultCompress() {
        if (getLogCompressor() == null) {
            setLogCompressor(new DefaultCompress(this, this.mConfig));
        }
    }

    private String transferEventParamFromJsonToString(StageEventType stageEventType, String str, String str2, JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.toString();
        } catch (Throwable th) {
            getLogger().error("event toString failed " + str + ", label: " + str2, th, new Object[0]);
            JSONObject copyJson = Utils.copyJson(jSONObject);
            if (copyJson == null) {
                return null;
            }
            InitConfig initConfig = getInitConfig();
            boolean z = initConfig != null && "local_test".equalsIgnoreCase(initConfig.getChannel());
            try {
                return copyJson.toString();
            } catch (OutOfMemoryError e) {
                getMonitorHelper().increaseStats(StatsCountKeys.MEM_ERROR_COUNT);
                if (z) {
                    if (getMonitorHelper().isEventMaybeAccepted(str)) {
                        getMonitorHelper().stageEvent(EventStage.PARAMS_INVALID_DROP, str, MonitorV3Utils.getNewMonitorIdString(), System.currentTimeMillis(), StageEventType.V3_EVENT);
                    }
                    throw new RuntimeException("event toString OOM tag: " + str + ", label: " + str2, e);
                }
                getLogger().error("event toString OOM tag: " + str + ", label: " + str2, e, new Object[0]);
                return null;
            } catch (StackOverflowError e2) {
                getMonitorHelper().increaseStats(StatsCountKeys.SOF_ERROR_COUNT);
                if (z) {
                    if (getMonitorHelper().isEventMaybeAccepted(str)) {
                        getMonitorHelper().stageEvent(EventStage.PARAMS_INVALID_DROP, str, MonitorV3Utils.getNewMonitorIdString(), System.currentTimeMillis(), stageEventType);
                    }
                    throw new RuntimeException("event toString stack overflow tag: " + str + ", label: " + str2, e2);
                }
                getLogger().error("event toString stack overflow tag: " + str + ", label: " + str2, e2, new Object[0]);
                return null;
            } catch (ConcurrentModificationException unused) {
                getMonitorHelper().increaseStats(StatsCountKeys.CONCURRENT_MODIFY_ERROR_COUNT);
                try {
                    return copyJson.toString();
                } catch (Throwable th2) {
                    if (getMonitorHelper().isEventMaybeAccepted(str)) {
                        getMonitorHelper().stageEvent(EventStage.PARAMS_INVALID_DROP, str, MonitorV3Utils.getNewMonitorIdString(), System.currentTimeMillis(), stageEventType);
                    }
                    throw new RuntimeException("event params exception tag: " + str + ", label: " + str2, th2);
                }
            }
        }
    }

    private void onEventV3Inner(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            getLogger().warn("event name is empty", new Object[0]);
        } else {
            receive(new EventV3(this.mAppId, str, false, transferEventParamFromJsonToString(StageEventType.V3_EVENT, str, null, jSONObject)));
        }
    }

    private void onEventV3InnerString(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            getLogger().warn("event name is empty", new Object[0]);
        } else {
            receive(new EventV3(this.mAppId, str, false, str2));
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void enableInsertCache(HashSet<String> hashSet, int i, int i2) {
        this.mInsertCacheWhiteSet = hashSet;
        this.mInsertCacheMaxIntervalMills = i;
        this.mInsertCacheMaxCount = i2;
        this.mInsertCacheEnabled = true;
        if (this.mEngine != null) {
            this.mEngine.setEnableInsertCache(true);
        }
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void disableInsertCache() {
        this.mInsertCacheEnabled = false;
        if (this.mEngine != null) {
            this.mEngine.setEnableInsertCache(false);
        }
    }

    public boolean getInsertCacheEnabled() {
        return this.mInsertCacheEnabled;
    }

    public HashSet<String> getInsertByCacheWhiteSet() {
        return this.mInsertCacheWhiteSet;
    }

    public int getInsertByCacheMaxIntervalMills() {
        return this.mInsertCacheMaxIntervalMills;
    }

    public int getInsertCacheMaxCount() {
        return this.mInsertCacheMaxCount;
    }

    @Override // com.bytedance.applog.IAppLogInstance
    public void setInsertByTransactionEnabled(boolean z) {
        if (this.mEngine != null) {
            this.mEngine.setInsertByTransactionEnabled(z);
        }
    }

    public int getBatchProcessEventCount() {
        return this.batchProcessEvents;
    }

    public int getBatchProcessIntervalMills() {
        return this.batchProcessIntervalMills;
    }

    public DataObserverHolder getDataObserverHolder() {
        return this.dataObserverHolder;
    }

    public SessionObserverHolder getSessionObserverHolder() {
        return this.sessionObserverHolder;
    }

    public EventObserverHolder getEventObserverHolder() {
        return this.eventObserverHolder;
    }

    public LaunchObserverHolder getLaunchObserverHolder() {
        return this.launchObserverHolder;
    }

    public ApiParamsUtil getApiParamsUtil() {
        return this.apiParamsUtil;
    }

    public Api getApi() {
        return this.api;
    }

    public Page getCurPage() {
        return this.mNav.getCurPage();
    }

    public Proxy getDefaultHttpClientProxy() {
        return this.defaultHttpClientProxy;
    }

    public IReportDropStrategy getReportDropStrategy() {
        if (this.sReportDropStrategy == null) {
            return DefaultReportDropStrategy.getDefault();
        }
        return this.sReportDropStrategy;
    }

    public IAppLogLogger getLogger() {
        return this.logger;
    }

    public long getNextEventIndex() {
        if (this.mEngine == null) {
            return 0L;
        }
        return this.mEngine.getSession().nextEventId();
    }

    public void fillSessionParams(BaseData baseData) {
        if (this.mEngine == null) {
            return;
        }
        this.mEngine.getSession().fillSessionParams(baseData);
    }

    public boolean isMigrateOldAppLogDataEnabled() {
        return this.mMigrateOldAppLogDataEnabled;
    }

    public boolean isTerminateImmediately() {
        return this.sTerminateImmediately;
    }

    public int getMaxPackOnceReport() {
        return this.sMaxPackOnceReport;
    }

    public LogReportMonitor getLogReportMonitor() {
        return this.sLogReportMonitor;
    }

    public IEventHandler getEventHandler() {
        return this.sEventHandler;
    }

    public boolean isEventForwardEnabled() {
        return this.sEventForwardEnabled;
    }

    public EventForward getEventForward() {
        if (this.mConfig != null) {
            return this.mConfig.getEventForward();
        }
        return null;
    }

    public EventPriority getEventPriority() {
        if (this.mConfig != null) {
            return this.mConfig.getEventPriority();
        }
        return null;
    }

    public int getEventSamplingCapability() {
        return this.mEventSamplingCapability.get();
    }

    public boolean isLaunchPackDesc() {
        return this.mLaunchPackDesc;
    }

    public boolean isBDInstallEventTrackEnabled() {
        return this.mBDInstallEventTrackEnabled;
    }

    public boolean isLogEnabled() {
        InitConfig initConfig = getInitConfig();
        if (initConfig != null) {
            return initConfig.isLogEnable();
        }
        return false;
    }

    public boolean isNewMonitorEnabled() {
        return this.sNewMonitorEnabled;
    }

    public List<String> getBlockHeaderKeys() {
        return this.blockHeaderKeys;
    }

    public boolean isEventParamControlEnabled() {
        return this.sEventParamControlEnabled;
    }

    public boolean isCustomHeaderControlEnabled() {
        return this.sCustomHeaderControlEnabled;
    }

    public PriorityWrapper getPriorityWrapper() {
        if (isGroupPriorityEnabled()) {
            return this.priorityWrapper;
        }
        return null;
    }

    public boolean isPriorityAutoStartEnabled() {
        return this.sPriorityAutoStartEnabled;
    }

    public boolean isCommonParamsEnabled() {
        return this.sCommonParamsEnabled;
    }

    public CommonParamsHelper getCommonParamsHelper() {
        return isCommonParamsEnabled() ? this.commonParamsWrapper.get(new Object[0]) : EmptyCommonParams.INSTANCE;
    }

    public Map<String, String> getEventForwardHttpHeaders() {
        return this.sEventForwardHttpHeaders;
    }

    public PageHolder getPageHolder() {
        return this.pageHolder;
    }

    public boolean isEnableBgSessionTaskReportOnPause() {
        return this.mEnableBgSessionTaskReportOnPause;
    }

    public boolean isFlushThresholdEnabled() {
        return this.sFlushThresholdEnabled;
    }

    public boolean isServerFilterByNativeEnabled() {
        return this.sServerFilterByNativeEnabled;
    }

    public boolean isServerFilterSaveToKevaEnabled() {
        return this.sServerFilterSaveToKevaEnabled;
    }

    private void sendConfig2DevTools(final InitConfig initConfig) {
        if (LogUtils.isDisabled()) {
            return;
        }
        LogUtils.sendJsonFetcher("init_begin", new EventBus.DataFetcher() { // from class: com.bytedance.applog.AppLogInstance.2
            @Override // com.bytedance.applog.log.EventBus.DataFetcher
            public Object fetch() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("appId", initConfig.getAid());
                    jSONObject.put("channel", initConfig.getChannel());
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(LogMessageConstants.CONFIG_APPLOG_VERSION, "5.7.11-rc.1");
                    jSONObject2.put(LogMessageConstants.CONFIG_APPLOG_REGION, "cn");
                    jSONObject2.put(LogMessageConstants.CONFIG_REQUEST_ENCRYPT_SWITCH, AppLogInstance.this.mEncryptAndCompress);
                    jSONObject2.put(LogMessageConstants.CONFIG_LOG_SWITCH, TLog.DEBUG);
                    jSONObject2.put(LogMessageConstants.CONFIG_LOG_CUSTOM, initConfig.getLogger() != null);
                    jSONObject2.put(LogMessageConstants.CONFIG_AUTO_START_SWITCH, initConfig.autoStart());
                    jSONObject2.put(LogMessageConstants.CONFIG_AUTO_ACTIVE_SWITCH, initConfig.isAutoActive());
                    jSONObject2.put(LogMessageConstants.CONFIG_SILENCE_IN_BG_SWITCH, initConfig.isSilenceInBackground());
                    jSONObject2.put(LogMessageConstants.CONFIG_CACHE_SP_NAME, initConfig.getSpName());
                    jSONObject2.put(LogMessageConstants.CONFIG_CACHE_DB_NAME, initConfig.getDbName());
                    jSONObject2.put(LogMessageConstants.CONFIG_LISTEN_LIFE_CYCLE_SWITCH, initConfig.isHandleLifeCycle());
                    jSONObject2.put(LogMessageConstants.CONFIG_DISABLE_PERSONALIZATION_SWITCH, AppLogInstance.this.sDisablePersonalization != null && AppLogInstance.this.sDisablePersonalization.intValue() == 1);
                    jSONObject2.put(LogMessageConstants.CONFIG_MINOR_VERSION, initConfig.getVersionMinor());
                    jSONObject2.put(LogMessageConstants.CONFIG_VERSION_CODE, String.valueOf(initConfig.getVersionCode()));
                    jSONObject2.put(LogMessageConstants.CONFIG_VERSION, initConfig.getVersion());
                    jSONObject2.put(LogMessageConstants.CONFIG_APP_NAME, initConfig.getAppName());
                    jSONObject2.put(LogMessageConstants.CONFIG_CURRENT_PROCESS, initConfig.getProcess() == 1 ? PullConfiguration.PROCESS_NAME_MAIN : "child");
                    jSONObject2.put(LogMessageConstants.CONFIG_REGION, initConfig.getRegion());
                    jSONObject2.put(LogMessageConstants.CONFIG_LANGUAGE, initConfig.getLanguage());
                    jSONObject2.put(LogMessageConstants.CONFIG_PLAY_SWITCH, initConfig.isPlayEnable());
                    jSONObject2.put(LogMessageConstants.CONFIG_EVENT_SAMPLING, (AppLogInstance.this.getEventSamplingCapability() & 1) > 0);
                    jSONObject2.put(LogMessageConstants.CONFIG_TEA_EVENT_SAMPLING, (AppLogInstance.this.getEventSamplingCapability() & 2) > 0);
                    jSONObject2.put(LogMessageConstants.CONFIG_EVENT_PRIORITY, AppLogInstance.this.isEnableEventPriority());
                    jSONObject2.put(LogMessageConstants.CONFIG_EVENT_USER_ID, AppLogInstance.this.getEnableEventUserId());
                    jSONObject2.put(LogMessageConstants.CONFIG_TOURIST_MODE_SWITCH, AppLogInstance.this.isTouristMode());
                    jSONObject2.put(LogMessageConstants.CONFIG_TOURIST_MODE_EVENT_SWITCH, AppLogInstance.this.isEnableEventInTouristMode());
                    jSONObject2.put(LogMessageConstants.CONFIG_DAU_FIX_SWITCH, AppLogInstance.this.getAdjustTerminate());
                    jSONObject2.put(LogMessageConstants.CONFIG_HTTP_PROXY, AppLogInstance.this.defaultHttpClientProxy != null);
                    jSONObject2.put(LogMessageConstants.CONFIG_EXPECTED_BATCH_INTERVAL, AppLogInstance.this.getExpectedBatchInterval());
                    jSONObject2.put(LogMessageConstants.CONFIG_FORWARD_OPEN, AppLogInstance.this.isEventForwardEnabled());
                    jSONObject2.put(LogMessageConstants.CONFIG_TERMINATE_IMMEDIATELY_SWITCH, AppLogInstance.this.isTerminateImmediately());
                    if (initConfig.getUriConfig() != null) {
                        ArrayList arrayList = new ArrayList();
                        if (initConfig.getUriConfig().getInstallEnv() != null && initConfig.getUriConfig().getInstallEnv().getConfig() != null) {
                            if (!TextUtils.isEmpty(initConfig.getUriConfig().getInstallEnv().getConfig().getRegisterUri())) {
                                arrayList.add(initConfig.getUriConfig().getInstallEnv().getConfig().getRegisterUri());
                            }
                            if (!TextUtils.isEmpty(initConfig.getUriConfig().getInstallEnv().getConfig().getActiveUri())) {
                                arrayList.add(initConfig.getUriConfig().getInstallEnv().getConfig().getActiveUri());
                            }
                        }
                        if (initConfig.getUriConfig().getSendUris() != null && initConfig.getUriConfig().getSendUris().length > 0) {
                            arrayList.add(TextUtils.join(";", initConfig.getUriConfig().getSendUris()));
                        }
                        if (!TextUtils.isEmpty(initConfig.getUriConfig().getSettingUri())) {
                            arrayList.add(initConfig.getUriConfig().getSettingUri());
                        }
                        if (!TextUtils.isEmpty(initConfig.getUriConfig().getSettingUri())) {
                            arrayList.add(initConfig.getUriConfig().getSettingUri());
                        }
                        jSONObject2.put(LogMessageConstants.CONFIG_SERVER_DOMAIN_CONFIG, TextUtils.join("、", arrayList));
                    } else {
                        jSONObject2.put(LogMessageConstants.CONFIG_SERVER_DOMAIN_CONFIG, "default");
                    }
                    jSONObject.put("config", jSONObject2);
                } catch (Throwable unused) {
                }
                return jSONObject;
            }
        });
    }

    private void sendUpdateConfig2Devtools(final String str, final Object obj) {
        if (LogUtils.isDisabled() || TextUtils.isEmpty(getAid())) {
            return;
        }
        LogUtils.sendJsonFetcher("update_config", new EventBus.DataFetcher() { // from class: com.bytedance.applog.AppLogInstance.3
            @Override // com.bytedance.applog.log.EventBus.DataFetcher
            public Object fetch() {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject.put("appId", AppLogInstance.this.getAid());
                    jSONObject2.put(str, obj);
                    jSONObject.put("config", jSONObject2);
                } catch (Throwable unused) {
                }
                return jSONObject;
            }
        });
    }
}
