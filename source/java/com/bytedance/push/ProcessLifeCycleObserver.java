package com.bytedance.push;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.android.service.manager.push.trace.PushTraceSceneType;
import com.bytedance.common.process.cross.CrossProcessHelper;
import com.bytedance.common.push.interfaze.IPushCommonInitConfigProvider;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.push.alive.AliveKeeperProxy;
import com.bytedance.push.appstatus.AppStatusObserverForChildProcess;
import com.bytedance.push.client.intelligence.FeatureCollectionHelper;
import com.bytedance.push.initialize.PushCommonInitConfigProvider;
import com.bytedance.push.legacy.MessageContext;
import com.bytedance.push.legacy.MessageData;
import com.bytedance.push.monitor.multiprocess.ActiveSourceMethod;
import com.bytedance.push.monitor.opentracing.ITracingMonitor;
import com.bytedance.push.network.CommonParamProvider;
import com.bytedance.push.settings.AliveOnlineSettings;
import com.bytedance.push.settings.SettingsManager;
import com.bytedance.push.settings.helper.SettingsFileLockHelper;
import com.bytedance.push.third.PushLifeManager;
import com.bytedance.push.user.UidTokenSynchronizer;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.AnrOptManager;
import com.ss.android.message.AppProvider;
import com.ss.android.message.PushThreadHandlerManager;
import com.ss.android.message.util.ToolUtils;
import com.ss.android.pushmanager.ApiConstants;
import com.ss.android.ug.bus.UgBusFramework;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ProcessLifeCycleObserver {
    private static volatile ProcessLifeCycleObserver instance;
    private final String TAG = "ProcessLifeCycleObserver";
    private boolean mNeedDoWorkerOnStart = false;
    private final AtomicBoolean mStartedWorkerProcess = new AtomicBoolean(false);

    public static ProcessLifeCycleObserver getInstance() {
        if (instance == null) {
            synchronized (ProcessLifeCycleObserver.class) {
                if (instance == null) {
                    instance = new ProcessLifeCycleObserver();
                }
            }
        }
        return instance;
    }

    private ProcessLifeCycleObserver() {
    }

    public void initOnApplication() {
        onInit();
        if (!ToolUtils.isSmpProcess(Configuration.get().mApplication)) {
            onInitOnProcessIsolationProtectedMode();
        } else {
            PushServiceManager.get().getIAllianceService().doAfterProcessIsolationProtected(new Runnable() { // from class: com.bytedance.push.ProcessLifeCycleObserver.1
                @Override // java.lang.Runnable
                public void run() {
                    ProcessLifeCycleObserver.this.onInitOnProcessIsolationProtectedMode();
                }
            });
        }
        if (ToolUtils.isMainProcess(Configuration.get().mApplication)) {
            onMainProcessInit();
        } else if (ToolUtils.isMessageProcess(Configuration.get().mApplication)) {
            onPushProcessInit(Configuration.get());
        } else if (ToolUtils.isPushServiceProcess(Configuration.get().mApplication)) {
            onPushServiceProcessInit(Configuration.get());
        }
    }

    public void initOnApplicationDelayForMainProcess() {
        if (Configuration.get().mEnableOnInitDelay) {
            onInitDelay();
        }
        if (Configuration.get().mEnableOnInitOnProcessIsolationProtectedModeDelay) {
            onInitOnProcessIsolationProtectedModeDelay();
        }
        if (Configuration.get().mEnableOnMainProcessInitDelay) {
            onMainProcessInitDelay();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onInitOnProcessIsolationProtectedMode() {
        Logger.m268d("ProcessLifeCycleObserver", "[onInitOnProcessIsolationProtectedMode]");
        ActiveSourceMethod.getInstance().init(Configuration.get().mApplication);
        if (Configuration.get().mEnableOnInitOnProcessIsolationProtectedModeDelay) {
            return;
        }
        onInitOnProcessIsolationProtectedModeDelay();
    }

    private void onInitOnProcessIsolationProtectedModeDelay() {
        Logger.m268d("ProcessLifeCycleObserver", "[onInitOnProcessIsolationProtectedMode]");
        PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.bytedance.push.ProcessLifeCycleObserver.2
            @Override // java.lang.Runnable
            public void run() {
                CrossProcessHelper.getInstance();
            }
        });
        if (PushCommonSupport.getInstance().getPushConfigurationService().keepOldInitTimeCostV2()) {
            PushSupporter.get().getPushNotificationManagerService().init(Configuration.get().mApplication);
        } else {
            PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.bytedance.push.ProcessLifeCycleObserver.3
                @Override // java.lang.Runnable
                public void run() {
                    PushSupporter.get().getPushNotificationManagerService().init(Configuration.get().mApplication);
                }
            });
        }
        if (PushCommonSupport.getInstance().getPushConfigurationService().keepOldInitTimeCostV2()) {
            PushServiceManager.get().getIAllianceService().onInitOnProcessIsolationProtectedMode();
        } else {
            PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.bytedance.push.ProcessLifeCycleObserver.4
                @Override // java.lang.Runnable
                public void run() {
                    PushServiceManager.get().getIAllianceService().onInitOnProcessIsolationProtectedMode();
                }
            });
        }
    }

    private void onInit() {
        Logger.openALog(Configuration.get().mApplication, Configuration.get().mEnableAlog, Configuration.get().mPushAlogInstanceName);
        AppProvider.initApp(Configuration.get().mApplication);
        Logger.m274i("ProcessLifeCycleObserver", "[onInit]");
        PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.bytedance.push.ProcessLifeCycleObserver.5
            @Override // java.lang.Runnable
            public void run() {
                SettingsFileLockHelper.getInstance().onProcessStart(Configuration.get().mApplication);
            }
        });
        if (!Configuration.get().mEnableLazy) {
            PushSupporter.get().init(Configuration.get(), new CommonParamProvider(Configuration.get()));
            PushCommonSupport.getInstance().getPushConfigurationService().injectConfiguration(Configuration.get().getPushCommonConfiguration());
            if (PushCommonSupport.getInstance().getPushConfigurationService().keepOldInitTimeCost()) {
                SettingsManager.allowReadSettingsOnMain = true;
            }
        } else {
            UgBusFramework.registerService(IPushCommonInitConfigProvider.class, new PushCommonInitConfigProvider());
        }
        PushSupporter.get().getPushSdkMonitorService().initOnApplication(Configuration.get().mApplication);
        Logger.setDebuggable(Configuration.get().mDebug);
        Logger.setLogLevel(Configuration.get().mLogLevel);
        if (!Configuration.get().mEnableLazy) {
            if (!TextUtils.isEmpty(Configuration.get().mHost)) {
                ApiConstants.setHost(Configuration.get().mHost);
            }
            ToolUtils.setProcessName(Configuration.get().mProcess);
        }
        MessageData.setLegacyImpl();
        PushSupporter.monitor().init();
        if (PushCommonSupport.getInstance().getPushConfigurationService().keepOldInitTimeCost() && ToolUtils.isMainProcess(Configuration.get().mApplication) && PushSupporter.get().getProcessManagerService().curIsWorkerProcess(Configuration.get().mApplication)) {
            this.mNeedDoWorkerOnStart = true;
        }
        if (Configuration.get().mEnableOnInitDelay) {
            return;
        }
        onInitDelay();
    }

    private void onInitDelay() {
        Logger.m274i("ProcessLifeCycleObserver", "[onInitDelay]");
        if (!Configuration.get().mEnableLazy) {
            if (Configuration.get().openTracingMonitor != null) {
                UgBusFramework.registerService(ITracingMonitor.class, Configuration.get().openTracingMonitor);
                Configuration.get().openTracingMonitor.startInit();
            }
            PushServiceManager.get().getPushExternalService().getIMultiProcessMonitor().init(Configuration.get().mApplication);
            PushServiceManager.get().getPushTraceExternalService().getTraceScene(PushTraceSceneType.ALLIANCE_WAKEUP).enterNode("process_start", "process start");
        }
        PushLifeManager.inst().setPushLifeAdapters(Configuration.get().mAdapters);
        PushLifeManager.inst().initOnApplication(Configuration.get().mApplication, MessageContext.getInstance());
        PushServiceManager.get().getIAllianceService().onApplicationInit(String.valueOf(Configuration.get().mAid), Configuration.get().mApplication);
        if (!ToolUtils.isSmpProcess(Configuration.get().mApplication)) {
            PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.bytedance.push.ProcessLifeCycleObserver.6
                @Override // java.lang.Runnable
                public void run() {
                    PushServiceManager.get().getAliveMonitorService().monitorAssociationStart(Configuration.get().mApplication);
                }
            });
        }
        AppStatusObserverForChildProcess.getIns();
    }

    private void doOnWorkerProcess() {
        if (this.mStartedWorkerProcess.getAndSet(true)) {
            return;
        }
        PushServiceManager.get().getPushTraceExternalService().getTraceScene(PushTraceSceneType.ALLIANCE_WAKEUP).enterNode("do_on_worker_process", "The logic of the worker process is executed");
        Logger.m268d("NON_MAIN_PROCESS_START_CONTROL", "ProcessLifeCycleObserver--> doOnWorkerProcess:start alliance");
        PushServiceManager.get().getIAllianceService().onWorkerApplicationStart();
        Logger.m268d("NON_MAIN_PROCESS_START_CONTROL", "ProcessLifeCycleObserver--> doOnWorkerProcess:start old red badge");
        PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.bytedance.push.ProcessLifeCycleObserver.7
            @Override // java.lang.Runnable
            public void run() {
                PushServiceManager.get().getIRedBadgeExternalService().startOnWorkerProcess(MessageContext.getInstance());
            }
        });
    }

    private void onMainProcessInit() {
        if (Configuration.get().mIsPreInstallVersion) {
            AliveOnlineSettings aliveOnlineSettings = (AliveOnlineSettings) SettingsManager.obtain(Configuration.get().mApplication, AliveOnlineSettings.class);
            aliveOnlineSettings.setNotifyServiceStick(false);
            aliveOnlineSettings.setAllowPushDaemonMonitor(false);
            aliveOnlineSettings.setCloseAlarmWakeup(true);
            aliveOnlineSettings.setAllowPushJobService(false);
        }
        if (!Configuration.get().mEnableOnMainProcessInitDelay) {
            onMainProcessInitDelay();
        }
        if (Configuration.get().mAutoInitRedBadge) {
            PushSupporter.get().getPushRedbadgeManager().init();
        }
        PushServiceManager.get().getIPermissionBootExternalService().initOnApplication();
        if (PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mIPushCommonConfiguration.optUidChangeByHostInvoke()) {
            if (PushCommonSupport.getInstance().getPushConfigurationService().keepOldInitTimeCostV2()) {
                UidTokenSynchronizer.getUidTokenSynchronizer().observerUidChangeEvent(PushSupporter.get(), Configuration.get().mAccountService);
            } else {
                PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.bytedance.push.ProcessLifeCycleObserver.8
                    @Override // java.lang.Runnable
                    public void run() {
                        UidTokenSynchronizer.getUidTokenSynchronizer().observerUidChangeEvent(PushSupporter.get(), Configuration.get().mAccountService);
                    }
                });
            }
        }
    }

    private void onMainProcessInitDelay() {
        if (PushCommonSupport.getInstance().getPushConfigurationService().keepOldInitTimeCost()) {
            updateComponentStatus(Configuration.get().mApplication);
        } else {
            PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.bytedance.push.ProcessLifeCycleObserver.9
                @Override // java.lang.Runnable
                public void run() {
                    ProcessLifeCycleObserver.this.updateComponentStatus(Configuration.get().mApplication);
                }
            });
        }
        PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.bytedance.push.ProcessLifeCycleObserver.10
            @Override // java.lang.Runnable
            public void run() {
                FeatureCollectionHelper.getInstance(Configuration.get().mApplication);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateComponentStatus(Context context) {
        ToolUtils.setComponentEnable(context, "com.xiaomi.push.service.receivers.MIPushMessageHandler", true);
        ToolUtils.setComponentEnable(context, "com.xiaomi.push.service.receivers.SmpMIPushMessageHandler", false);
        ToolUtils.setComponentEnable(context, "com.xiaomi.push.service.receivers.WidgetProviderMIPushMessageHandler", false);
        ToolUtils.setComponentEnable(context, "com.heytap.msp.push.service.DataMessageCallbackService", true);
        ToolUtils.setComponentEnable(context, "com.heytap.msp.push.service.SmpDataMessageCallbackService", false);
        ToolUtils.setComponentEnable(context, "com.heytap.msp.push.service.CompatibleDataMessageCallbackService", true);
        ToolUtils.setComponentEnable(context, "com.heytap.msp.push.service.SmpCompatibleDataMessageCallbackService", false);
    }

    private void onPushProcessInit(Configuration configuration) {
        AliveKeeperProxy.inst(configuration.mApplication).doKeepAlive();
    }

    private void onPushServiceProcessInit(final Configuration configuration) {
        Logger.m268d("ProcessLifeCycleObserver", "init of push service process");
        AnrOptManager.postRunnable(new Runnable() { // from class: com.bytedance.push.ProcessLifeCycleObserver.11
            @Override // java.lang.Runnable
            public void run() {
                PushSupporter.get().getSenderService().registerSenderInPushServiceProcess();
                AliveKeeperProxy.inst(configuration.mApplication).doKeepAlive();
            }
        });
    }

    public void start(Context context) {
        PushServiceManager.get().getPushTraceExternalService().getTraceScene(PushTraceSceneType.ALLIANCE_WAKEUP).enterNode("lifecycle_start", "Start of LifeCycle");
        Logger.m268d("ProcessLifeCycleObserver", "on com.bytedance.push.ProcessLifeCycleObserver.start");
        PushLifeManager.inst().onStart();
        PushServiceManager.get().getPullExternalService().initOnApplication();
        if (ToolUtils.isMainProcess(context)) {
            if (!PushCommonSupport.getInstance().getPushConfigurationService().keepOldInitTimeCost()) {
                this.mNeedDoWorkerOnStart = PushSupporter.get().getProcessManagerService().curIsWorkerProcess(context);
            }
            if (this.mNeedDoWorkerOnStart) {
                doOnWorkerProcess();
                return;
            }
            return;
        }
        if (ToolUtils.isSmpProcess(context) || !PushSupporter.get().getProcessManagerService().curIsWorkerProcess(context)) {
            return;
        }
        doOnWorkerProcess();
    }
}
