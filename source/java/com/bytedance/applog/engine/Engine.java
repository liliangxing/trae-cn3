package com.bytedance.applog.engine;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.applog.AppLogHelper;
import com.bytedance.applog.AppLogInstance;
import com.bytedance.applog.BDInstallInitHook;
import com.bytedance.applog.IHeaderCustomTimelyCallback;
import com.bytedance.applog.InitConfig;
import com.bytedance.applog.UriConfig;
import com.bytedance.applog.adaptor.OldAppLogDataMigrator;
import com.bytedance.applog.batch.PackOptConfig;
import com.bytedance.applog.bdinstall.BdInstallImpl;
import com.bytedance.applog.bdinstall.IBdInstallService;
import com.bytedance.applog.collector.Collector;
import com.bytedance.applog.collector.NavigatorHelper;
import com.bytedance.applog.concurrent.AppLogExecutors;
import com.bytedance.applog.engine.Session;
import com.bytedance.applog.exception.GlobalExceptionHandler;
import com.bytedance.applog.exception.UncaughtExceptionCallback;
import com.bytedance.applog.filter.AbstractEventFilter;
import com.bytedance.applog.filter.HandlerEventFilter;
import com.bytedance.applog.filter.IEventFilter;
import com.bytedance.applog.filter.SamplingFilter;
import com.bytedance.applog.forward.EventForward;
import com.bytedance.applog.log.EventBus;
import com.bytedance.applog.log.IAppLogLogger;
import com.bytedance.applog.log.LogUtils;
import com.bytedance.applog.manager.AppLogCache;
import com.bytedance.applog.manager.ConfigManager;
import com.bytedance.applog.manager.DeviceManager;
import com.bytedance.applog.monitor.MonitorKey;
import com.bytedance.applog.monitor.MonitorUtils;
import com.bytedance.applog.monitor.exception.AppLogExceptionManager;
import com.bytedance.applog.monitor.exception.ExceptionType;
import com.bytedance.applog.monitor.p006v3.EventStage;
import com.bytedance.applog.monitor.p006v3.IMonitorDataFetcher;
import com.bytedance.applog.monitor.p006v3.MonitorV3AppLogConfig;
import com.bytedance.applog.monitor.p006v3.MonitorV3Config;
import com.bytedance.applog.monitor.p006v3.StatsCountKeys;
import com.bytedance.applog.priority.EventPriority;
import com.bytedance.applog.priority.EventPriorityItem;
import com.bytedance.applog.priority.original.ValueLoader;
import com.bytedance.applog.server.Api;
import com.bytedance.applog.store.BaseData;
import com.bytedance.applog.store.DbStore;
import com.bytedance.applog.store.Event;
import com.bytedance.applog.store.EventMisc;
import com.bytedance.applog.store.EventV3;
import com.bytedance.applog.store.ForwardEvent;
import com.bytedance.applog.store.Launch;
import com.bytedance.applog.store.Pack;
import com.bytedance.applog.store.Page;
import com.bytedance.applog.task.TaskPresenter;
import com.bytedance.applog.task.TeaThread;
import com.bytedance.applog.throttle.BackoffController;
import com.bytedance.applog.util.BlockHelper;
import com.bytedance.applog.util.EventsSenderUtils;
import com.bytedance.applog.util.SensitiveUtils;
import com.bytedance.applog.util.UriConstants;
import com.bytedance.applog.util.Utils;
import com.bytedance.bdinstall.Cdid;
import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.GWorker;
import com.bytedance.bdinstall.InstallInfo;
import com.bytedance.bdinstall.OnResetListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class Engine implements Handler.Callback, Comparator<BaseData> {
    private static final int INTERVAL_PROCESS = 5;
    private static final int MSG_BG_SESSION_TASK = 22;
    private static final int MSG_BG_SESSION_TASK_LIFECYCLE = 23;
    private static final int MSG_CHECK_AB_CONFIG = 13;
    private static final int MSG_CHECK_STATE_READY = 2;
    private static final int MSG_CHECK_WORKER = 6;
    private static final int MSG_CLEAR_ABD_SET_ENV = 21;
    private static final int MSG_CLEAR_WHEN_SWITCH_CHILD_MODE = 18;
    private static final int MSG_DO_APPLOG_MIGRATE = 24;
    private static final int MSG_ENABLE_INSERT_CACHE = 26;
    private static final int MSG_ENABLE_INSERT_TRANSACTION = 27;
    private static final int MSG_INIT_PRIORITY = 28;
    private static final int MSG_PROCESS = 4;
    private static final int MSG_PROCESS_CACHE = 10;
    private static final int MSG_RESET_AND_REINSTALL = 20;
    private static final int MSG_RESET_WHEN_SWITCH_CHILD_MODE = 19;
    private static final int MSG_SAVE_REAL_TIME = 8;
    private static final int MSG_SEND_IMMEDIATELY = 14;
    private static final int MSG_SET_UUID = 12;
    private static final int MSG_START_BDINSTALL_SERVICE = 1;
    private static final int MSG_START_NEW_MONITOR = 25;
    private static final int MSG_START_WORK = 3;
    private static final int MSG_TERM = 7;
    private static final int MSG_UPDATE_PACK_SEND_RESULT = 16;
    private static final int MSG_UPDATE_SENDER_WORK = 17;
    private static final long REAL_FAIL_INTERVAL = 60000;
    private static final int STATE_BDINSTALL_ON_LOAD = 2;
    private static final int STATE_BDINSTALL_ON_UPDATE = 4;
    private static final int STATE_DEVICE_HEADER_READY = 8;
    private static final int STATE_START_BDINSTALL_SERVICE = 1;
    private static final int STATE_START_NET_WORK = 16;
    private static final long TERMINATE_IMMEDIATELY_DELAY = 500;
    private final AppLogCache appLogCache;
    private volatile TaskPresenter bgTaskPresenter;
    private final HandlerEventFilter handlerEventFilter;
    private final AppLogInstance mAppLogInst;
    private final IBdInstallService mBDInstallService;
    private final ConfigManager mConfig;
    private Configer mConfiger;
    private volatile DbStore mDbStore;
    private final DeviceManager mDevice;
    private volatile AbstractEventFilter mEventFilter;
    private volatile InitConfig.IpcDataChecker mIpcDataChecker;
    private volatile long mLastFlushTime;
    private volatile Handler mNetHandler;
    private final Looper mNtLooper;
    private long mRealFailTs;
    private List<BaseWorker> mSenderList;
    private final Session mSession;
    private volatile boolean mStarted;
    private UriConfig mUriConfig;
    volatile boolean mUuidChanged;
    private final Handler mWorkHandler;
    private final NavigatorHelper navigatorHelper;
    private volatile SamplingFilter samplingFilter;
    private static final List<String> logTags = Collections.singletonList("Engine");
    public static volatile long flushIntervalThresholdMs = GWorker.INTERVAL;
    private final ArrayList<BaseData> mDataList = new ArrayList<>(32);
    private final ArrayList<BaseWorker> mWorkers = new ArrayList<>(4);
    private volatile int mEngineState = 0;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class PackSendResult {
        public ArrayList<Pack> mSended = new ArrayList<>();
        public ArrayList<Pack> mFailed = new ArrayList<>();
        public boolean abort = false;
    }

    public AppLogInstance getAppLog() {
        return this.mAppLogInst;
    }

    public Session getSession() {
        return this.mSession;
    }

    public String getSessionId() {
        return this.mSession.getId();
    }

    public void destroy() {
        if (this.mNetHandler != null) {
            this.mNetHandler.removeCallbacksAndMessages(null);
            this.mNetHandler.getLooper().quit();
        }
        Handler handler = this.mWorkHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mWorkHandler.getLooper().quit();
        }
        try {
            Thread.sleep(100L);
        } catch (InterruptedException unused) {
        }
    }

    public Engine(AppLogInstance appLogInstance, ConfigManager configManager, DeviceManager deviceManager, IBdInstallService iBdInstallService, BDInstallInitHook bDInstallInitHook, AppLogCache appLogCache) {
        this.mAppLogInst = appLogInstance;
        this.mConfig = configManager;
        configManager.setEngine(this);
        this.mDevice = deviceManager;
        this.appLogCache = appLogCache;
        this.mSession = new Session(this);
        this.mBDInstallService = iBdInstallService;
        this.handlerEventFilter = new HandlerEventFilter(appLogInstance);
        String appId = getAppLog().getAppId();
        HandlerThread handlerThread = new HandlerThread("bd_tracker_w:" + appId);
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper(), this);
        this.mWorkHandler = handler;
        HandlerThread handlerThread2 = new HandlerThread("bd_tracker_n:" + appId);
        handlerThread2.start();
        Looper looper = handlerThread2.getLooper();
        this.mNtLooper = looper;
        iBdInstallService.init(configManager, getUriConfig().getInstallEnv(), looper, bDInstallInitHook);
        this.navigatorHelper = new NavigatorHelper(appLogInstance, looper);
        if (appLogInstance.getEventSamplingCapability() > 0) {
            this.samplingFilter = SamplingFilter.parseEventSamplingFromLocal(this, AppLogHelper.getInstanceSpName(appLogInstance, "sampling_list"));
        }
        if (configManager.autoStart()) {
            this.mStarted = true;
            handler.sendEmptyMessage(1);
            handler.sendEmptyMessageDelayed(2, 200L);
        }
        handler.sendEmptyMessage(25);
        handler.sendEmptyMessage(10);
        if (configManager.getInitConfig().getIpcDataChecker() != null && !configManager.isMainProcess()) {
            this.mIpcDataChecker = configManager.getInitConfig().getIpcDataChecker();
        }
        if (getAppLog().isMigrateOldAppLogDataEnabled() && AppLogHelper.isGlobalInstance(getAppLog())) {
            handler.sendEmptyMessageDelayed(24, GWorker.INTERVAL);
        }
    }

    public Context getContext() {
        return getAppLog().getContext();
    }

    public DbStore getDbStore() {
        if (this.mDbStore == null) {
            synchronized (this) {
                DbStore dbStore = this.mDbStore;
                if (dbStore == null) {
                    dbStore = new DbStore(this, getConfig().getInitConfig().getDbName());
                }
                this.mDbStore = dbStore;
            }
        }
        return this.mDbStore;
    }

    public void setFlushIntervalThresholdMs(long j) {
        flushIntervalThresholdMs = Math.max(0L, j);
    }

    public long getBackgroundSessionKeepMills() {
        if (getAppLog().isTerminateImmediately()) {
            return 500L;
        }
        return getConfig().getSessionLife();
    }

    public void onBgSessionTaskResume() {
        Handler handler = this.mWorkHandler;
        if (handler != null) {
            handler.obtainMessage(22, true).sendToTarget();
        }
    }

    public void onBgSessionTaskPause() {
        Handler handler = this.mWorkHandler;
        if (handler != null) {
            handler.obtainMessage(22, false).sendToTarget();
        }
    }

    public DeviceManager getDm() {
        return this.mDevice;
    }

    public void setLanguageAndRegion(String str, String str2) {
        this.mBDInstallService.updateLanguageAndRegion(getContext(), str, str2);
        workImmediately(this.mConfiger, 0);
    }

    public void setUriConfig(UriConfig uriConfig) {
        this.mUriConfig = uriConfig;
        this.mBDInstallService.setUriRuntime(uriConfig.getInstallEnv());
    }

    public UriConfig getUriConfig() {
        if (this.mUriConfig == null) {
            UriConfig uriConfig = getConfig().getInitConfig().getUriConfig();
            this.mUriConfig = uriConfig;
            if (uriConfig == null) {
                this.mUriConfig = UriConstants.createUriConfig(0);
            }
        }
        return this.mUriConfig;
    }

    public void start() {
        if (this.mStarted) {
            return;
        }
        this.mStarted = true;
        this.mWorkHandler.sendEmptyMessage(1);
        this.mWorkHandler.sendEmptyMessageDelayed(2, 200L);
    }

    public void initGroupPriority() {
        Handler handler = this.mWorkHandler;
        if (handler != null) {
            handler.removeMessages(28);
            this.mWorkHandler.sendEmptyMessage(28);
        }
    }

    public int clearDataListIfCacheTooLarge() {
        synchronized (this.mDataList) {
            if (this.mDataList.isEmpty()) {
                return 0;
            }
            Iterator<BaseData> it = this.mDataList.iterator();
            long j = 0;
            while (it.hasNext()) {
                j += it.next().size();
            }
            if (j < 1048576) {
                return 0;
            }
            int size = this.mDataList.size();
            getAppLog().getLogger().error(logTags, "force clear data list with state={} and mDataList={} size={} and stack: ", new Throwable(), Integer.valueOf(this.mEngineState), Integer.valueOf(size), Long.valueOf(j));
            getAppLog().getMonitorHelper().sendError("force clear engine data list", new Throwable("state=" + this.mEngineState + ", len=" + size + ", totalSize=" + j));
            this.mDataList.clear();
            return size;
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int dumpData;
        if (message.what != 1) {
            BlockHelper.tryBlock();
        }
        switch (message.what) {
            case 1:
                this.mEngineState |= 1;
                IAppLogLogger logger = getAppLog().getLogger();
                List<String> list = logTags;
                logger.info(list, "start bdinstall...", new Object[0]);
                if (this.mConfig.isMainProcess()) {
                    getAppLog().getLogger().info(list, "start add observers to bdinstall...", new Object[0]);
                    this.mBDInstallService.addDataObserver();
                    this.mBDInstallService.addHeaderAndInstallFinishListener(new BdInstallImpl.OnHeaderAndInstallInfoCallback() { // from class: com.bytedance.applog.engine.Engine.1
                        @Override // com.bytedance.applog.bdinstall.BdInstallImpl.OnHeaderAndInstallInfoCallback
                        public void onLoad(JSONObject jSONObject, InstallInfo installInfo) {
                            Engine.this.mEngineState |= 2;
                            Engine.this.onGotHeader(jSONObject);
                            Engine.this.getAppLog().getLogger().info(Engine.logTags, "bdinstall onLoad", new Object[0]);
                        }

                        @Override // com.bytedance.applog.bdinstall.BdInstallImpl.OnHeaderAndInstallInfoCallback
                        public void onUpdate(JSONObject jSONObject, InstallInfo installInfo) {
                            Engine.this.mEngineState |= 4;
                            Engine.this.onGotHeader(jSONObject);
                            Engine.this.getAppLog().getLogger().info(Engine.logTags, "bdinstall onUpdate", new Object[0]);
                        }
                    });
                }
                getAppLog().getLogger().info(list, "start bdinstall service begin", new Object[0]);
                this.mBDInstallService.start();
                getAppLog().getLogger().info(list, "start bdinstall service end", new Object[0]);
                return true;
            case 2:
                IAppLogLogger logger2 = getAppLog().getLogger();
                List<String> list2 = logTags;
                logger2.info(list2, "start to check header ready...", new Object[0]);
                if (this.mConfig.isMainProcess()) {
                    if (this.mDevice.isHeaderReady()) {
                        this.mEngineState |= 8;
                        this.mNetHandler = new Handler(this.mNtLooper, this);
                        this.mNetHandler.sendEmptyMessage(3);
                        if (getAppLog().isPriorityAutoStartEnabled()) {
                            initPriority3();
                        }
                        if (this.mDataList.size() > 0) {
                            this.mWorkHandler.removeMessages(4);
                            this.mWorkHandler.sendEmptyMessageDelayed(4, 1000L);
                        }
                        getAppLog().getLogger().info(list2, "net handler start work", new Object[0]);
                    } else {
                        this.mWorkHandler.removeMessages(2);
                        JSONObject jSONObject = new JSONObject();
                        if (this.mBDInstallService.getCurrentHeader(jSONObject) && this.mDevice.isValidDidAndIid(jSONObject)) {
                            this.mDevice.updateHeader(jSONObject);
                            this.mWorkHandler.sendEmptyMessage(2);
                            getAppLog().getLogger().info(list2, "net handler start work by get", new Object[0]);
                        } else {
                            this.mWorkHandler.sendEmptyMessageDelayed(2, 1000L);
                            getAppLog().getLogger().info(list2, "header not ready, will check gain after 1s...", new Object[0]);
                        }
                    }
                } else {
                    getAppLog().getLogger().warn(list2, "workers will not start for current is not the main process!", new Object[0]);
                }
                return true;
            case 3:
                this.mEngineState |= 16;
                IAppLogLogger logger3 = getAppLog().getLogger();
                List<String> list3 = logTags;
                logger3.info(list3, "start to build workers...", new Object[0]);
                if (getAppLog().isInsertEventOptEnabled()) {
                    GlobalExceptionHandler.getInstance().addExceptionCallback(new UncaughtExceptionCallback() { // from class: com.bytedance.applog.engine.Engine.2
                        @Override // com.bytedance.applog.exception.UncaughtExceptionCallback
                        public void onException(Thread thread, Throwable th) {
                            Engine.this.process(null, false);
                        }
                    });
                }
                this.mConfig.loadLocalCacheConfig();
                if (!TextUtils.isEmpty(getUriConfig().getSettingUri())) {
                    Configer configer = new Configer(this);
                    this.mConfiger = configer;
                    this.mWorkers.add(configer);
                }
                List<BaseWorker> senderList = getSenderList();
                this.mSenderList = senderList;
                this.mWorkers.addAll(senderList);
                getAppLog().getLogger().info(list3, "{} workers prepared", Integer.valueOf(this.mWorkers.size()));
                checkAppUpdate();
                if (getConfig().getInitConfig() != null && getConfig().getInitConfig().isLogEnable()) {
                    getAppLog().getCommonParamsHelper().setLogEnable(true);
                }
                this.mNetHandler.removeMessages(6);
                this.mNetHandler.sendEmptyMessage(6);
                if (!LogUtils.isDisabled()) {
                    LogUtils.sendJsonFetcher("start_end", new EventBus.DataFetcher() { // from class: com.bytedance.applog.engine.Engine.3
                        @Override // com.bytedance.applog.log.EventBus.DataFetcher
                        public Object fetch() {
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put("appId", Engine.this.mAppLogInst.getAppId());
                                jSONObject2.put("isMainProcess", Engine.this.mConfig.isMainProcess());
                            } catch (Throwable unused) {
                            }
                            return jSONObject2;
                        }
                    });
                }
                return true;
            case 4:
                process((String[]) message.obj, false);
                return true;
            case 5:
            case 9:
            case 11:
            case 13:
            case 15:
            case 16:
            default:
                getAppLog().getLogger().warn(logTags, "Not support message type", new Object[0]);
                return true;
            case 6:
                this.mNetHandler.removeMessages(6);
                getAppLog().getLogger().debug(logTags, "start to check worker to do...", new Object[0]);
                long eventInterval = this.mConfig.getEventInterval();
                if (!this.mConfig.getInitConfig().isSilenceInBackground() || this.mSession.isResume()) {
                    Iterator<BaseWorker> it = this.mWorkers.iterator();
                    long j = Long.MAX_VALUE;
                    while (it.hasNext()) {
                        BaseWorker next = it.next();
                        if (!next.isStop()) {
                            long checkToWork = next.checkToWork(message.arg1);
                            if (checkToWork < j) {
                                j = checkToWork;
                            }
                        }
                    }
                    eventInterval = j - System.currentTimeMillis();
                }
                Message obtainMessage = this.mNetHandler.obtainMessage(6);
                obtainMessage.arg1 = 2;
                long max = Math.max(eventInterval, 100L);
                this.mNetHandler.sendMessageDelayed(obtainMessage, max);
                getAppLog().getLogger().debug(logTags, "post check worker task with delay: {}ms.", Long.valueOf(max));
                return true;
            case 7:
                getAppLog().getLogger().debug(logTags, "Terminate created", new Object[0]);
                synchronized (this.mDataList) {
                    this.mDataList.add(Session.getTermTrigger());
                }
                process(null, false);
                return true;
            case 8:
                ArrayList<BaseData> arrayList = (ArrayList) message.obj;
                Iterator<BaseData> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    BaseData next2 = it2.next();
                    if (next2.getPriority() == 0) {
                        next2.setPriority(-1);
                    }
                }
                getDbStore().save(arrayList);
                return true;
            case 10:
                synchronized (this.mDataList) {
                    dumpData = this.appLogCache.dumpData(this.mDataList);
                }
                getAppLog().getLogger().debug(logTags, "dump cache data count: {}", Integer.valueOf(dumpData));
                process(this.appLogCache.getArray(), false);
                return true;
            case 12:
                Object[] objArr = (Object[]) message.obj;
                switchSessionAndSetUuid((String) objArr[0], (Page) objArr[1]);
                return true;
            case 14:
                process(null, true);
                return true;
            case 17:
                getAppLog().getLogger().info(logTags, "Start to update sender workers...", new Object[0]);
                this.mWorkers.removeAll(this.mSenderList);
                List<BaseWorker> senderList2 = getSenderList();
                this.mSenderList = senderList2;
                this.mWorkers.addAll(0, senderList2);
                return true;
            case 18:
                ChildModeParam childModeParam = (ChildModeParam) message.obj;
                doClearWhenSwitchChildMode(childModeParam.childMode);
                if (childModeParam.countDownLatch != null) {
                    childModeParam.countDownLatch.countDown();
                }
                return true;
            case 19:
                ChildModeParam childModeParam2 = (ChildModeParam) message.obj;
                doResetWhenSwitchChildMode(childModeParam2.childMode, childModeParam2.timeout, childModeParam2.listener);
                if (childModeParam2.countDownLatch != null) {
                    childModeParam2.countDownLatch.countDown();
                }
                return true;
            case 20:
                ChildModeParam childModeParam3 = (ChildModeParam) message.obj;
                doResetAndReInstall(childModeParam3.timeout, childModeParam3.listener);
                if (childModeParam3.countDownLatch != null) {
                    childModeParam3.countDownLatch.countDown();
                }
                return true;
            case 21:
                ChildModeParam childModeParam4 = (ChildModeParam) message.obj;
                doClearAndSetEnv();
                if (childModeParam4.countDownLatch != null) {
                    childModeParam4.countDownLatch.countDown();
                }
                return true;
            case 22:
                if (message.obj instanceof Boolean) {
                    handleBgSessionTask(((Boolean) message.obj).booleanValue());
                }
                return true;
            case 23:
                if (message.obj instanceof Page) {
                    handleBgSessionTaskPage((Page) message.obj);
                }
                return true;
            case 24:
                OldAppLogDataMigrator.migrateStayDuration(getAppLog(), getDbStore());
                OldAppLogDataMigrator.migrateEvents(getAppLog(), getDbStore());
                OldAppLogDataMigrator.migrateQueueLogs(getAppLog(), getDbStore());
                return true;
            case 25:
                initNewMonitor();
                return true;
            case 26:
                if (message.obj instanceof Boolean) {
                    getDbStore().setEnableMemoryCache(((Boolean) message.obj).booleanValue());
                }
                return true;
            case 27:
                if (message.obj instanceof Boolean) {
                    getDbStore().setEnableTransaction(((Boolean) message.obj).booleanValue());
                }
                return true;
            case 28:
                initPriority3();
                return true;
        }
    }

    public TaskPresenter getBgTaskPresenter() {
        if (this.bgTaskPresenter == null) {
            synchronized (this) {
                TaskPresenter taskPresenter = this.bgTaskPresenter;
                if (taskPresenter == null) {
                    taskPresenter = new TaskPresenter(getAppLog(), getDbStore(), this.mDevice);
                }
                this.bgTaskPresenter = taskPresenter;
            }
        }
        return this.bgTaskPresenter;
    }

    private void handleBgSessionTask(boolean z) {
        if (!getAppLog().isEnableBgSessionTask()) {
            getAppLog().getLogger().info(logTags, "[Task] Background session task is not enabled, isResume = {} will not work!", Boolean.valueOf(z));
            return;
        }
        TaskPresenter bgTaskPresenter = getBgTaskPresenter();
        if (z) {
            bgTaskPresenter.onTaskResume();
        } else {
            bgTaskPresenter.onTaskPause();
        }
    }

    private void handleBgSessionTaskPage(Page page) {
        if (getAppLog().isEnableBgSessionTask()) {
            TaskPresenter bgTaskPresenter = getBgTaskPresenter();
            if (page.isResumeEvent()) {
                bgTaskPresenter.onExitBg(page.f80ts, page.sid);
            } else {
                bgTaskPresenter.onEnterBg(page.f80ts, page.sid);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onGotHeader(JSONObject jSONObject) {
        this.mDevice.updateHeader(jSONObject);
        if ((this.mEngineState & 8) == 0) {
            this.mWorkHandler.removeMessages(2);
            this.mWorkHandler.sendEmptyMessage(2);
        }
    }

    private List<BaseWorker> getSenderList() {
        boolean z;
        ArrayList arrayList = new ArrayList();
        EventPriority eventPriority = this.mConfig.getEventPriority();
        if (eventPriority == null || !eventPriority.isValid()) {
            z = false;
        } else {
            for (EventPriorityItem eventPriorityItem : eventPriority.getEventPriorityItemMap().values()) {
                if (eventPriorityItem != null && eventPriorityItem.getPriority() != 0) {
                    arrayList.add(new Sender(this, eventPriorityItem));
                }
            }
            z = true;
        }
        if (!z) {
            arrayList.add(new Sender(this));
        }
        EventForward eventForward = this.mConfig.getEventForward();
        if (eventForward != null && eventForward.isEnabled()) {
            arrayList.add(new ForwardSender(this, eventForward));
        }
        return arrayList;
    }

    public void process(String[] strArr, boolean z) {
        ArrayList<BaseData> arrayList;
        boolean z2;
        synchronized (this.mDataList) {
            arrayList = (ArrayList) this.mDataList.clone();
            this.mDataList.clear();
        }
        Iterator<BaseData> it = arrayList.iterator();
        while (it.hasNext()) {
            BaseData next = it.next();
            if (next.sentryStained > 0) {
                MonitorUtils.stageEvent(getAppLog().getMonitorHelper(), EventStage.PROCESS_START, next);
            }
        }
        if (strArr != null) {
            arrayList.ensureCapacity(arrayList.size() + strArr.length);
            for (String str : strArr) {
                BaseData fromIpc = BaseData.fromIpc(str);
                if (fromIpc != null && (!Utils.isNotEmpty(fromIpc.getAppId()) || Utils.equal(getAppLog().getAppId(), fromIpc.getAppId()))) {
                    arrayList.add(fromIpc);
                    if (fromIpc.sentryStained > 0) {
                        MonitorUtils.stageEvent(getAppLog().getMonitorHelper(), EventStage.PROCESS_START, fromIpc);
                    }
                }
            }
        }
        notifyEventObserverBeforeProcess(arrayList);
        if (this.mAppLogInst.isTouristMode() && !this.mAppLogInst.isEnableEventInTouristMode()) {
            getAppLog().getLogger().info(logTags, "not process events in tourist mode.", new Object[0]);
            Iterator<BaseData> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                BaseData next2 = it2.next();
                if (next2.sentryStained > 0) {
                    MonitorUtils.stageEvent(getAppLog().getMonitorHelper(), EventStage.TOURIST_BREAK, next2);
                }
            }
            return;
        }
        filterEvent(arrayList);
        filterEventParams(arrayList);
        Iterator<BaseData> it3 = arrayList.iterator();
        while (it3.hasNext()) {
            BaseData next3 = it3.next();
            if (next3.sentryStained > 0) {
                MonitorUtils.stageEvent(getAppLog().getMonitorHelper(), EventStage.PROCESS_END, next3);
            }
        }
        if (!arrayList.isEmpty()) {
            if (this.mConfig.isMainProcess()) {
                saveAndSend(arrayList);
            } else {
                Intent intent = new Intent(getContext(), (Class<?>) Collector.class);
                int size = arrayList.size();
                String[] strArr2 = new String[size];
                int i = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    String jSONObject = arrayList.get(i2).toIpcJson().toString();
                    strArr2[i2] = jSONObject;
                    i += jSONObject.length();
                }
                if (i < 307200 || this.mIpcDataChecker == null) {
                    z2 = true;
                } else {
                    try {
                        z2 = this.mIpcDataChecker.checkIpcData(strArr2);
                    } catch (Throwable th) {
                        getAppLog().getLogger().warn(logTags, "check ipc data", th);
                        z2 = true;
                    }
                    getAppLog().getLogger().error(logTags, "IPC over 300k", new Object[0]);
                }
                if (z2) {
                    intent.putExtra(Collector.KEY_DATA, strArr2);
                    getContext().sendBroadcast(intent);
                }
            }
        }
        if (z && this.mConfig.isMainProcess() && this.mConfig.isFlushEnabled()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!getAppLog().isFlushThresholdEnabled() || Math.abs(currentTimeMillis - this.mLastFlushTime) >= flushIntervalThresholdMs) {
                this.mLastFlushTime = currentTimeMillis;
                workImmediately(this.mSenderList, 4);
                getAppLog().getLogger().info(logTags, "flush work...", new Object[0]);
            } else {
                getAppLog().getLogger().warn(logTags, "flush disallowed by threshold:{} limit!", Long.valueOf(flushIntervalThresholdMs));
            }
            if (getAppLog().getPriorityWrapper() != null) {
                getAppLog().getPriorityWrapper().flush();
            }
        }
    }

    public void setEnableInsertCache(boolean z) {
        this.mWorkHandler.obtainMessage(26, Boolean.valueOf(z)).sendToTarget();
    }

    public void setInsertByTransactionEnabled(boolean z) {
        this.mWorkHandler.obtainMessage(27, Boolean.valueOf(z)).sendToTarget();
    }

    private void notifyEventObserverBeforeProcess(List<BaseData> list) {
        if (getAppLog().getEventObserverHolder().noStage(2)) {
            return;
        }
        for (BaseData baseData : list) {
            try {
                if (baseData instanceof Event) {
                    Event event = (Event) baseData;
                    getAppLog().getEventObserverHolder().onEvent(2, event.category, event.tag, event.label, event.value, event.extValue, event.param);
                } else if (baseData instanceof EventV3) {
                    EventV3 eventV3 = (EventV3) baseData;
                    getAppLog().getEventObserverHolder().onEventV3(2, eventV3.getEvent(), eventV3.getContent());
                } else if (baseData instanceof EventMisc) {
                    EventMisc eventMisc = (EventMisc) baseData;
                    getAppLog().getEventObserverHolder().onMiscEvent(2, eventMisc.getLogType(), eventMisc.getContent());
                }
            } catch (Throwable th) {
                getAppLog().getLogger().error(4, "notify event observer before process failed", th, new Object[0]);
                getAppLog().getMonitorHelper().sendError("notify event observer before process failed", th);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:86:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void saveAndSend(ArrayList<BaseData> arrayList) {
        boolean z;
        List<BaseWorker> list;
        Iterator<BaseData> it = arrayList.iterator();
        while (it.hasNext()) {
            BaseData next = it.next();
            if (next.sentryStained > 0) {
                MonitorUtils.stageEvent(getAppLog().getMonitorHelper(), EventStage.DB_SAVE_START, next);
            }
            MonitorUtils.addHighFrequencyEvent(next);
        }
        Collections.sort(arrayList, this);
        ArrayList<BaseData> arrayList2 = new ArrayList<>(arrayList.size());
        EventPriority eventPriority = this.mConfig.getEventPriority();
        Iterator<BaseData> it2 = arrayList.iterator();
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            BaseData next2 = it2.next();
            boolean process = this.mSession.process(next2, arrayList2);
            boolean isResumeEvent = Session.isResumeEvent(next2);
            if (process && isResumeEvent) {
                z4 = true;
            }
            if (next2 instanceof Page) {
                if (getAppLog().isEnableBgSessionTask()) {
                    this.mWorkHandler.obtainMessage(23, next2).sendToTarget();
                }
                z2 = true;
                z3 = isResumeEvent;
            } else if (next2 instanceof EventV3) {
                EventV3 eventV3 = (EventV3) next2;
                eventV3.updateEventPriority(eventPriority);
                handleEventForward(eventV3, arrayList2);
                getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.ACCEPT_EVENT_COUNT);
            } else if (next2 instanceof Session.TermTrigger) {
                z5 = true;
            } else if ((next2 instanceof Event) || (next2 instanceof EventMisc)) {
                getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.ACCEPT_EVENT_COUNT);
            }
            if (next2.sentryStained > 0 && !MonitorUtils.isEventMaybeAccepted(getAppLog().getMonitorHelper(), next2)) {
                next2.sentryStained = 0;
            }
        }
        handleCommonParams(arrayList2);
        bypassToEventSender(arrayList2);
        Iterator<BaseData> it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            BaseData next3 = it3.next();
            if (next3.sentryStained > 0) {
                MonitorUtils.stageEvent(getAppLog().getMonitorHelper(), EventStage.HANDLE_REALTIME_START, next3);
            }
        }
        if (getAppLog().getPriorityWrapper() != null) {
            Iterator<BaseData> it4 = arrayList2.iterator();
            while (it4.hasNext()) {
                final BaseData next4 = it4.next();
                boolean onPriorityEvent = getAppLog().getPriorityWrapper().onPriorityEvent(Utils.getEventType(next4).value(), next4.getEventName(), new ValueLoader<JSONObject>() { // from class: com.bytedance.applog.engine.Engine.4
                    @Override // com.bytedance.applog.priority.original.ValueLoader
                    public JSONObject load() {
                        return next4.toPackJson();
                    }
                });
                if (onPriorityEvent) {
                    it4.remove();
                }
                getAppLog().getLogger().info(4, "event: {} is saved: {} into priority core.", next4.toString(), Boolean.valueOf(onPriorityEvent));
            }
        }
        filterRealEvent(arrayList2);
        if (getAppLog().getInsertCacheEnabled()) {
            Iterator<BaseData> it5 = arrayList.iterator();
            while (it5.hasNext()) {
                BaseData next5 = it5.next();
                if ((next5 instanceof EventV3) && !getAppLog().getInsertByCacheWhiteSet().contains(next5.getDetail())) {
                }
            }
            z = false;
            getDbStore().save(arrayList2, z);
            if (z2) {
                if (z3) {
                    this.mWorkHandler.removeMessages(7);
                } else {
                    this.mWorkHandler.sendEmptyMessageDelayed(7, getBackgroundSessionKeepMills());
                }
            }
            if (!z4 || z5) {
                workImmediately(this.mSenderList, z4 ? 1 : 3);
                list = this.mSenderList;
                if (list == null && !list.isEmpty() && (this.mEngineState & 2) == 0) {
                    getAppLog().getLogger().error(logTags, "bdinstall lost header callback", new Object[0]);
                    Bundle bundle = new Bundle();
                    bundle.putInt("engine_state", this.mEngineState);
                    this.mAppLogInst.onEventV3("bdinstall_lost_callback", bundle);
                    return;
                }
                return;
            }
            if (this.mNetHandler != null) {
                this.mNetHandler.removeMessages(6);
                Message obtainMessage = this.mNetHandler.obtainMessage(6);
                obtainMessage.arg1 = 2;
                this.mNetHandler.sendMessage(obtainMessage);
                return;
            }
            return;
        }
        z = true;
        getDbStore().save(arrayList2, z);
        if (z2) {
        }
        if (!z4) {
        }
        workImmediately(this.mSenderList, z4 ? 1 : 3);
        list = this.mSenderList;
        if (list == null) {
        }
    }

    private void handleEventForward(EventV3 eventV3, ArrayList<BaseData> arrayList) {
        if (this.mConfig.getEventForward() == null || !this.mConfig.getEventForward().isEnabled()) {
            return;
        }
        EventForward eventForward = this.mConfig.getEventForward();
        String event = eventV3.getEvent();
        if (eventForward.hasEvent(event)) {
            getAppLog().getLogger().info(4, "Event: {} is match forward...", event);
            arrayList.add(ForwardEvent.fromEventV3(eventV3));
        }
    }

    private void filterRealEvent(List<BaseData> list) {
        boolean z = true;
        if (!PackOptConfig.realtimeEventOptEnabled && System.currentTimeMillis() - this.mRealFailTs < 60000) {
            z = false;
        }
        if (this.mDevice.isHeaderReady() && z) {
            final ArrayList<BaseData> filterReal = this.mConfig.filterReal(list);
            if (filterReal == null || filterReal.isEmpty()) {
                return;
            }
            for (BaseData baseData : filterReal) {
                if (baseData.sentryStained > 0) {
                    MonitorUtils.stageEvent(getAppLog().getMonitorHelper(), EventStage.REALTIME_SEND_START, baseData);
                }
            }
            TeaThread.getInst().post(new Runnable() { // from class: com.bytedance.applog.engine.Engine.5
                @Override // java.lang.Runnable
                public void run() {
                    EventPriorityItem eventPriorityItem = Engine.this.mConfig.getEventPriorityItem(0);
                    Engine.this.handleRealTimeEvents(filterReal, eventPriorityItem, Engine.this.getAppLog().getApiParamsUtil().getSendLogUris(Engine.this, true, eventPriorityItem));
                }
            });
            getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.REALTIME_EVENT_COUNT, filterReal.size());
            return;
        }
        for (BaseData baseData2 : list) {
            if (baseData2.getPriority() == 0) {
                baseData2.setPriority(-1);
            }
        }
    }

    private void handleCommonParams(List<BaseData> list) {
        if (getAppLog().isCommonParamsEnabled()) {
            for (BaseData baseData : list) {
                if (baseData instanceof EventV3) {
                    EventV3 eventV3 = (EventV3) baseData;
                    String handleEvent = getAppLog().getCommonParamsHelper().handleEvent(eventV3.getEvent(), baseData.getContent());
                    if (!TextUtils.isEmpty(handleEvent)) {
                        eventV3.setParams(handleEvent);
                    }
                }
            }
        }
    }

    private void workImmediately(BaseWorker baseWorker, int i) {
        if (this.mNetHandler == null || baseWorker == null) {
            return;
        }
        baseWorker.setImmediately();
        if (Looper.myLooper() == this.mNetHandler.getLooper()) {
            if (baseWorker.isStop()) {
                return;
            }
            baseWorker.checkToWork(i);
        } else {
            this.mNetHandler.removeMessages(6);
            Message obtainMessage = this.mNetHandler.obtainMessage(6);
            obtainMessage.arg1 = i;
            this.mNetHandler.sendMessage(obtainMessage);
        }
    }

    private void workImmediately(List<? extends BaseWorker> list, int i) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<? extends BaseWorker> it = list.iterator();
        while (it.hasNext()) {
            workImmediately(it.next(), i);
        }
    }

    public void receive(BaseData baseData) {
        int size;
        if (baseData.f80ts == 0) {
            getAppLog().getLogger().error(logTags, "receive zero ts", new Object[0]);
        }
        synchronized (this.mDataList) {
            size = this.mDataList.size();
            this.mDataList.add(baseData);
        }
        if (baseData.sentryStained > 0) {
            MonitorUtils.stageEvent(getAppLog().getMonitorHelper(), EventStage.DATA_LIST_ADDED, baseData);
        }
        boolean z = baseData instanceof Page;
        if (getAppLog().isInsertEventOptEnabled()) {
            if (z || (size + 1) % getAppLog().getBatchProcessEventCount() == 0) {
                this.mWorkHandler.removeMessages(4);
                this.mWorkHandler.sendEmptyMessage(4);
            } else if (!this.mWorkHandler.hasMessages(4)) {
                this.mWorkHandler.sendEmptyMessageDelayed(4, getAppLog().getBatchProcessIntervalMills());
            }
        } else if (size % 5 == 0 || z) {
            this.mWorkHandler.removeMessages(4);
            if (size != 0 || z) {
                this.mWorkHandler.sendEmptyMessage(4);
            } else {
                this.mWorkHandler.sendEmptyMessageDelayed(4, 200L);
            }
        }
        if (baseData.sentryStained > 0) {
            MonitorUtils.stageEvent(getAppLog().getMonitorHelper(), EventStage.PRE_PROCESS_END, baseData);
        }
        if (z) {
            this.navigatorHelper.onPageReceived((Page) baseData);
        }
    }

    public void receive(String[] strArr) {
        this.mWorkHandler.removeMessages(4);
        this.mWorkHandler.obtainMessage(4, strArr).sendToTarget();
    }

    @Override // java.util.Comparator
    public int compare(BaseData baseData, BaseData baseData2) {
        long j = baseData.f80ts - baseData2.f80ts;
        if (j < 0) {
            return -1;
        }
        return j > 0 ? 1 : 0;
    }

    public ConfigManager getConfig() {
        return this.mConfig;
    }

    private void bypassToEventSender(ArrayList<BaseData> arrayList) {
        String type;
        if (EventsSenderUtils.isEnable(this.mAppLogInst.getAppId())) {
            Iterator<BaseData> it = arrayList.iterator();
            while (it.hasNext()) {
                BaseData next = it.next();
                if (!(next instanceof ForwardEvent) && (type = EventsSenderUtils.getType(next)) != null) {
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(next.toPackJson());
                    EventsSenderUtils.putEvent(this.mAppLogInst.getAppId(), type, jSONArray);
                }
            }
        }
    }

    public void setUserUniqueId(String str) {
        String userUniqueId = this.mDevice.getUserUniqueId();
        if ((TextUtils.isEmpty(str) && !TextUtils.isEmpty(userUniqueId)) || (!TextUtils.isEmpty(str) && !TextUtils.equals(str, userUniqueId))) {
            doSetUuid(str);
        }
        this.mDevice.setUserUniqueId(str);
    }

    public boolean isEventAndParamsHitStickySamplingDrop(String str, JSONObject jSONObject) {
        if (this.samplingFilter == null || getAppLog().getEventSamplingCapability() == 0) {
            return false;
        }
        return this.samplingFilter.isHitStickySamplingDrop(str, jSONObject);
    }

    private void switchSessionAndSetUuid(String str, Page page) {
        workImmediately(this.mSenderList, 10);
        if (page == null && (page = getAppLog().getCurPage()) != null) {
            page = (Page) page.m432clone();
        }
        ArrayList<BaseData> arrayList = new ArrayList<>();
        long currentTimeMillis = System.currentTimeMillis();
        if (page != null) {
            long j = currentTimeMillis - page.f80ts;
            page.setTs(currentTimeMillis);
            if (j < 0) {
                j = 0;
            }
            page.duration = j;
            page.lastSession = this.mSession.getLastFgId();
            this.mSession.fillSessionParams(page);
            arrayList.add(page);
        }
        doSetUuid(str);
        if (page != null) {
            Page page2 = (Page) page.m432clone();
            page2.setTs(currentTimeMillis + 1);
            page2.duration = -1L;
            Launch startSession = this.mSession.startSession(page2, arrayList, true);
            if (startSession != null) {
                startSession.lastSession = this.mSession.getLastFgId();
            }
            this.mSession.fillSessionParams(page2);
            arrayList.add(page2);
        }
        if (!arrayList.isEmpty()) {
            getDbStore().save(arrayList);
        }
        workImmediately(this.mSenderList, 10);
    }

    private void doSetUuid(String str) {
        this.mBDInstallService.updateUserUniqueId((Application) getContext(), str);
    }

    public void setEventFilter(AbstractEventFilter abstractEventFilter) {
        this.mEventFilter = abstractEventFilter;
    }

    public void sendImmediately() {
        this.mWorkHandler.removeMessages(14);
        this.mWorkHandler.sendEmptyMessage(14);
    }

    private void filterEvent(ArrayList<BaseData> arrayList) {
        if (arrayList.isEmpty()) {
            return;
        }
        filterByAbsEventFilter(arrayList, this.handlerEventFilter, EventStage.FILTER_CUSTOM_BLOCKED);
        AbstractEventFilter eventFilterByClient = getAppLog().getEventFilterByClient();
        if (eventFilterByClient != null) {
            filterByAbsEventFilter(arrayList, eventFilterByClient, EventStage.FILTER_EVENT_BLOCKED);
        }
        if (getConfig().getInitConfig().isEventFilterEnable() && this.mEventFilter != null) {
            filterByAbsEventFilter(arrayList, this.mEventFilter, EventStage.FILTER_EVENT_BLOCKED);
        }
        if (this.samplingFilter != null && getAppLog().getEventSamplingCapability() > 0) {
            filterByAbsEventFilter(arrayList, this.samplingFilter, EventStage.FILTER_SAMPLING_DROPPED);
        }
        this.mConfig.filterBlock(arrayList);
    }

    private void filterByAbsEventFilter(ArrayList<BaseData> arrayList, IEventFilter iEventFilter, EventStage eventStage) {
        if (iEventFilter.noFilter()) {
            return;
        }
        Iterator<BaseData> it = arrayList.iterator();
        while (it.hasNext()) {
            BaseData next = it.next();
            if (next instanceof EventV3) {
                EventV3 eventV3 = (EventV3) next;
                tryFilterEvent(next, it, iEventFilter, MonitorKey.event_v3, eventStage, eventV3.getEvent(), eventV3.getContent());
            } else if (next instanceof Event) {
                Event event = (Event) next;
                tryFilterEvent(next, it, iEventFilter, MonitorKey.event, eventStage, event.tag, event.param);
            } else if (next instanceof EventMisc) {
                tryFilterEvent(next, it, iEventFilter, MonitorKey.log_data, eventStage, "log_data", ((EventMisc) next).getContent());
            }
        }
    }

    private void tryFilterEvent(BaseData baseData, Iterator<BaseData> it, IEventFilter iEventFilter, MonitorKey monitorKey, EventStage eventStage, String str, String str2) {
        if (iEventFilter.filterAndDiscardEvent(monitorKey, str, str2)) {
            it.remove();
            if (baseData.sentryStained > 0) {
                MonitorUtils.stageEvent(getAppLog().getMonitorHelper(), eventStage, baseData);
            }
            getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.FILTER_DROP_EVENT_COUNT);
            if (iEventFilter instanceof SamplingFilter) {
                getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.SAMPLING_DROP_EVENT_COUNT);
                AppLogExceptionManager.getInstance().dispatchDiscardEvent(ExceptionType.InterruptionSampling, baseData.getDetail());
            } else {
                AppLogExceptionManager.getInstance().dispatchDiscardEvent(ExceptionType.InterruptionEventList, baseData.getDetail());
            }
            getAppLog().getLogger().debug(logTags, "event:{} is match filter:{} drop!", str, iEventFilter);
        }
    }

    private void filterEventParams(List<BaseData> list) {
        if (getAppLog().isEventParamControlEnabled()) {
            for (BaseData baseData : list) {
                if (baseData instanceof EventV3) {
                    EventV3 eventV3 = (EventV3) baseData;
                    String event = eventV3.getEvent();
                    if (this.mConfig.isEventParamsControlledByEventName(event)) {
                        String content = eventV3.getContent();
                        if (!TextUtils.isEmpty(content)) {
                            try {
                                JSONObject jSONObject = new JSONObject(content);
                                Iterator<String> keys = jSONObject.keys();
                                ArrayList<String> arrayList = new ArrayList();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    if (!this.mConfig.isEventParamKeyAllowed(event, next)) {
                                        arrayList.add(next);
                                    }
                                }
                                if (!arrayList.isEmpty()) {
                                    for (String str : arrayList) {
                                        jSONObject.remove(str);
                                        getAppLog().getLogger().debug(logTags, "event v3:{}, param:{} has been removed for server control", event, str);
                                    }
                                    getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.REMOVE_EVENT_PARAM_COUNT, arrayList.size());
                                    ((EventV3) baseData).setParams(jSONObject.toString());
                                }
                            } catch (Throwable th) {
                                getAppLog().getLogger().debug(logTags, "parse event v3:{} params to json failed ", event, th);
                            }
                        }
                    }
                }
            }
        }
    }

    private void checkAppUpdate() {
        if (this.mDevice.getLastVersionCode() != this.mDevice.getVersionCode() || !TextUtils.equals(this.mConfig.getLastChannel(), this.mConfig.getChannel())) {
            Configer configer = this.mConfiger;
            if (configer != null) {
                configer.setImmediately();
            }
            if (getConfig().getInitConfig().isEventFilterEnable()) {
                if (getAppLog().isServerFilterByNativeEnabled()) {
                    AbstractEventFilter.clearNativeServerFilterCache(getAppLog());
                    setEventFilter(null);
                    return;
                } else {
                    setEventFilter(AbstractEventFilter.parseFilterFromServer(getAppLog(), AppLogHelper.getInstanceSpName(getAppLog(), AbstractEventFilter.SP_FILTER_NAME), null));
                    return;
                }
            }
            return;
        }
        if (getConfig().getInitConfig().isEventFilterEnable()) {
            if (getAppLog().isServerFilterByNativeEnabled()) {
                setEventFilter(AbstractEventFilter.parseNativeFilterFromLocal(getAppLog()));
            } else {
                setEventFilter(AbstractEventFilter.parseFilterFromLocal(getAppLog(), AppLogHelper.getInstanceSpName(getAppLog(), AbstractEventFilter.SP_FILTER_NAME)));
            }
        }
    }

    public SamplingFilter getEventSampling() {
        return this.samplingFilter;
    }

    public void setEventSampling(SamplingFilter samplingFilter) {
        this.samplingFilter = samplingFilter;
    }

    public void tryUpdateSenders() {
        if (this.mNetHandler != null) {
            this.mNetHandler.sendEmptyMessage(17);
        }
    }

    public void tryUpdateCongestionMaxRequestFrequency(EventPriorityItem eventPriorityItem, int i) {
        List<BaseWorker> list = this.mSenderList;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (BaseWorker baseWorker : this.mSenderList) {
            if (baseWorker instanceof Sender) {
                ((Sender) baseWorker).tryUpdateCongestionMaxRequestFrequency(eventPriorityItem, i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class ChildModeParam {
        boolean childMode;
        CountDownLatch countDownLatch;
        OnResetListener listener;
        long timeout;

        private ChildModeParam() {
        }
    }

    public void clearWhenSwitchChildMode(boolean z) {
        clearOrResetWhenSwitchChildMode(z, 18, 0L, null);
    }

    public void resetDidWhenSwitchChildMode(boolean z, long j, OnResetListener onResetListener) {
        clearOrResetWhenSwitchChildMode(z, 19, j, onResetListener);
    }

    public void clearAndSetEnv() {
        clearOrResetWhenSwitchChildMode(false, 21, 0L, null);
    }

    public void resetAndReInstall(long j, OnResetListener onResetListener) {
        clearOrResetWhenSwitchChildMode(false, 20, j, onResetListener);
    }

    public void forceTimeoutReportSync(long j) {
        if (this.mSenderList == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = j;
        for (BaseWorker baseWorker : this.mSenderList) {
            if (baseWorker instanceof Sender) {
                Sender sender = (Sender) baseWorker;
                if (j2 > 0) {
                    sender.setWorkTimeout(j2);
                }
                try {
                    sender.doWork(12);
                } catch (Throwable th) {
                    getAppLog().getLogger().error(logTags, "force report by sender:{} failed", sender.getName(), th);
                }
                sender.setWorkTimeout(0L);
                if (j > 0) {
                    j2 = j - (System.currentTimeMillis() - currentTimeMillis);
                    if (j2 <= 0) {
                        return;
                    }
                } else {
                    continue;
                }
            }
        }
    }

    private void initPriority3() {
        if (getAppLog().getPriorityWrapper() != null) {
            getAppLog().getPriorityWrapper().initPriority();
        }
    }

    private void clearOrResetWhenSwitchChildMode(boolean z, int i, long j, OnResetListener onResetListener) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Message obtainMessage = this.mWorkHandler.obtainMessage(i);
        ChildModeParam childModeParam = new ChildModeParam();
        childModeParam.childMode = z;
        childModeParam.listener = onResetListener;
        childModeParam.timeout = j;
        childModeParam.countDownLatch = countDownLatch;
        obtainMessage.obj = childModeParam;
        this.mWorkHandler.sendMessage(obtainMessage);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            getAppLog().getLogger().error(logTags, "clearOrResetWhenSwitchChildMode interrupted", e, new Object[0]);
        }
    }

    private void doClearWhenSwitchChildMode(boolean z) {
        Env installEnv = getUriConfig().getInstallEnv();
        this.mBDInstallService.clearInstallInfoWhenSwitchChildMode(new Env(installEnv.getConfig(), installEnv.isI18n(), installEnv.isBoe(), z));
        getDbStore().clearAllTables();
        ArrayList<BaseData> arrayList = new ArrayList<>();
        Page curPage = getAppLog().getCurPage();
        if (curPage != null) {
            curPage = (Page) curPage.m432clone();
        }
        if (curPage != null) {
            curPage.setTs(System.currentTimeMillis());
            curPage.duration = -1L;
            this.mSession.startSession(curPage, arrayList, true);
            this.mSession.fillSessionParams(curPage);
            arrayList.add(curPage);
        } else {
            this.mSession.startSession(null, arrayList, false);
        }
        if (arrayList.isEmpty()) {
            return;
        }
        getDbStore().save(arrayList);
    }

    private void doResetWhenSwitchChildMode(boolean z, long j, OnResetListener onResetListener) {
        Env installEnv = getUriConfig().getInstallEnv();
        this.mBDInstallService.resetInstallInfoWhenSwitchChildMode(getContext(), new Env(installEnv.getConfig(), installEnv.isI18n(), installEnv.isBoe(), z), j, onResetListener);
    }

    private void doClearAndSetEnv() {
        Env installEnv = getUriConfig().getInstallEnv();
        this.mBDInstallService.clearAndSetEnv(new Env(installEnv.getConfig(), installEnv.isI18n(), installEnv.isBoe(), installEnv.isChildMode()));
    }

    private void doResetAndReInstall(long j, OnResetListener onResetListener) {
        Env installEnv = getUriConfig().getInstallEnv();
        this.mBDInstallService.resetAndReInstall(getContext(), new Env(installEnv.getConfig(), installEnv.isI18n(), installEnv.isBoe(), installEnv.isChildMode()), j, onResetListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleRealTimeEvents(List<BaseData> list, EventPriorityItem eventPriorityItem, String[] strArr) {
        trySendRealTimeEvents(strArr, eventPriorityItem, list, getUriConfig().getCommonHttpHeaders());
    }

    private void trySendRealTimeEvents(String[] strArr, EventPriorityItem eventPriorityItem, List<BaseData> list, Map<String, String> map) {
        if (!sendRealTime(strArr, eventPriorityItem, list, map)) {
            for (BaseData baseData : list) {
                if (baseData.sentryStained > 0) {
                    MonitorUtils.stageEvent(getAppLog().getMonitorHelper(), EventStage.REALTIME_SEND_FAILED, baseData);
                }
            }
            this.mWorkHandler.obtainMessage(8, list).sendToTarget();
            return;
        }
        for (BaseData baseData2 : list) {
            if (baseData2.sentryStained > 0) {
                MonitorUtils.stageEvent(getAppLog().getMonitorHelper(), EventStage.REPORT_END, baseData2);
            }
        }
        getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.REPORT_SUCCESS_EVENT_COUNT, list.size());
        getDbStore().notifyEventObserver(list);
    }

    private boolean sendRealTime(String[] strArr, EventPriorityItem eventPriorityItem, List<BaseData> list, Map<String, String> map) {
        boolean z;
        JSONObject transferHeader = SensitiveUtils.transferHeader(this.mDevice.getCopiedHeader());
        if (strArr.length > 0) {
            IHeaderCustomTimelyCallback headerCustomCallback = getAppLog().getHeaderCustomCallback();
            if (headerCustomCallback != null) {
                try {
                    headerCustomCallback.updateHeader(transferHeader);
                } catch (Throwable th) {
                    getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.PACK_ERROR_COUNT);
                    getAppLog().getLogger().error(logTags, "header custom callback updateHeader error", th, new Object[0]);
                    getAppLog().getMonitorHelper().sendError("Realtime send IHeaderCustomTimelyCallback updateHeader failed", th);
                }
            }
            Pack realTimePack = Pack.realTimePack(this.mAppLogInst, list, transferHeader, eventPriorityItem);
            if (!PackOptConfig.realtimeEventOptEnabled) {
                BackoffController backoffController = eventPriorityItem != null ? eventPriorityItem.getBackoffController() : null;
                if (backoffController != null && backoffController.backoffLogRequestAsRatio(8)) {
                    getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.BACKOFF_BLOCK_REQUEST_COUNT);
                    return false;
                }
            }
            if (realTimePack.data == null || realTimePack.data.length <= 0) {
                return false;
            }
            int send = getAppLog().getApi().send(strArr, realTimePack.data, this, realTimePack.getPackKeyAndIv(), realTimePack.encodeType, realTimePack.encodeHeaders, map, true);
            realTimePack.failHttpCode = send;
            if (send != 200) {
                if (Api.checkIfJamMsg(send)) {
                    this.mRealFailTs = System.currentTimeMillis();
                }
                if (eventPriorityItem != null) {
                    eventPriorityItem.checkPriorityUrisValid(send);
                }
                z = false;
            } else {
                this.mRealFailTs = 0L;
                z = true;
            }
            getAppLog().getMonitorHelper().increaseStats(z ? StatsCountKeys.REPORT_REALTIME_EVENTS_SUCCESS_COUNT : StatsCountKeys.REPORT_REALTIME_EVENTS_FAILED_COUNT, list.size());
            if (!LogUtils.isDisabled()) {
                Sender.sendPackUpload2Devtools(getAppLog().getAppId(), realTimePack.getEventLocalIds(), z);
            }
        } else {
            z = false;
        }
        getAppLog().getLogger().debug(logTags, "sendRealTime: {}", Boolean.valueOf(z));
        return z;
    }

    private void initNewMonitor() {
        if (getAppLog().isNewMonitorEnabled() && getAppLog().getMonitorHelper().isEnabled() && !TextUtils.isEmpty(getUriConfig().getMonitorUri())) {
            getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.PILED_UP_EVENT_COUNT, getDbStore().getPiledUpEventCount());
            getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.PILED_UP_LAUNCH_COUNT, getDbStore().getPiledUpLaunchCount());
            getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.PILED_UP_TERMINATE_COUNT, getDbStore().getPiledUpTerminateCount());
            getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.PILED_UP_PACK_COUNT, getDbStore().getPiledUpPackCount());
            getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.PILED_UP_DB_SIZE_KB, getDbStore().getPiledUpDbSizeInKb());
            getAppLog().getMonitorHelper().init(new MonitorV3Config.Builder().appLogConfig(new MonitorV3AppLogConfig.Builder().appId(getConfig().getAid()).channel(getConfig().getChannel()).appName(getConfig().getInitConfig().getAppName()).version(getConfig().getVersion()).updateVersionCode(getConfig().getInitConfig().getUpdateVersionCode()).logSdkVersion("5.7.11-rc.1").logEnabled(getConfig().getInitConfig().isLogEnable()).cdid(Cdid.getMainInstanceCdid(getContext())).devtoolsEnabled(!LogUtils.isDisabled()).frequencyControlEnabled(getConfig().getInitConfig().isCongestionControlEnable()).logEventFilterEnabled(getConfig().getInitConfig().isEventFilterEnable()).touristMode(getConfig().getInitConfig().isTouristMode()).build()).executor(AppLogExecutors.getSingleExecutor()).eventReportInterval(getConfig().getEventInterval()).networkClient(getAppLog().getNetClient()).reportUrl(getUriConfig().getMonitorUri()).context(getContext()).dataFetcher(new IMonitorDataFetcher() { // from class: com.bytedance.applog.engine.Engine.6
                @Override // com.bytedance.applog.monitor.p006v3.IMonitorDataFetcher
                public JSONObject fetchExternalHeaders() {
                    JSONObject header = Engine.this.getAppLog().getHeader();
                    IHeaderCustomTimelyCallback headerCustomCallback = Engine.this.getAppLog().getHeaderCustomCallback();
                    if (headerCustomCallback != null) {
                        headerCustomCallback.updateHeader(header);
                    }
                    try {
                        return new JSONObject(header, new String[]{"carrier_region", "region", com.bytedance.bdinstall.Api.KEY_APP_REGION});
                    } catch (JSONException unused) {
                        return null;
                    }
                }
            }).build());
            return;
        }
        getAppLog().getMonitorHelper().init(new MonitorV3Config.Builder().build());
    }
}
