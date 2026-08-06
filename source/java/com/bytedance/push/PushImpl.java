package com.bytedance.push;

import android.app.Activity;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.android.service.manager.alliance.SmpProcessInitCallback;
import com.bytedance.android.service.manager.permission.boot.BusinessCustomSysAlertDialogStatus;
import com.bytedance.android.service.manager.permission.boot.GoogleCustomSysAlertDialogStatus;
import com.bytedance.android.service.manager.permission.boot.ISysPermissionPageCallback;
import com.bytedance.android.service.manager.permission.boot.LottieAnimatorModel;
import com.bytedance.android.service.manager.permission.boot.PermissionBootRequestParam;
import com.bytedance.android.service.manager.permission.boot.PushPermissionBootShowResult;
import com.bytedance.android.service.manager.push.client.intelligence.IFeatureCallBack;
import com.bytedance.android.service.manager.push.notification.NotificationBody;
import com.bytedance.android.service.manager.push.trace.PushTraceSceneType;
import com.bytedance.common.model.PushCommonConfiguration;
import com.bytedance.common.push.ThreadPlus;
import com.bytedance.common.push.interfaze.RequestResultCallback;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.perf.monitor.ReportConst;
import com.bytedance.push.alive.AliveKeeperProxy;
import com.bytedance.push.client.intelligence.FeatureCollectionHelper;
import com.bytedance.push.client.intelligence.FeatureConnectionConstant;
import com.bytedance.push.configuration.AbsBDPushConfiguration;
import com.bytedance.push.event.sync.ISignalReportApi;
import com.bytedance.push.helper.MultiProcessPushMessageDatabaseHelper;
import com.bytedance.push.helper.SysDialogActivityLifecycleObserver;
import com.bytedance.push.interfaze.IPushNotificationManagerService;
import com.bytedance.push.interfaze.IPushService;
import com.bytedance.push.interfaze.IRequestNotificationPermissionCallback;
import com.bytedance.push.interfaze.ISDKMonitor;
import com.bytedance.push.interfaze.ISupport;
import com.bytedance.push.interfaze.IThirdSupportService;
import com.bytedance.push.interfaze.OnSwitcherServerListener;
import com.bytedance.push.interfaze.OnSwitcherSyncListener;
import com.bytedance.push.log.MessageLogClientManager;
import com.bytedance.push.model.SwitcherStatus;
import com.bytedance.push.monitor.multiprocess.PushMultiProcessMonitor;
import com.bytedance.push.monitor.opentracing.ITracingMonitor;
import com.bytedance.push.pull.PullScene;
import com.bytedance.push.settings.LocalSettings;
import com.bytedance.push.settings.PushOnlineSettings;
import com.bytedance.push.settings.SettingsManager;
import com.bytedance.push.settings.notification.PollingNotificationReport;
import com.bytedance.push.settings.pull.PullSettingsModel;
import com.bytedance.push.statistics.ProcessStatsCalculator;
import com.bytedance.push.statistics.ProcessStatsConfigProvider;
import com.bytedance.push.task.SendTokenTask;
import com.bytedance.push.task.UpdateSettingsTask;
import com.bytedance.push.third.PushChannelHelper;
import com.bytedance.push.third.PushLifeManager;
import com.bytedance.push.third.PushManager;
import com.bytedance.push.user.UidTokenSynchronizer;
import com.bytedance.push.utils.Logger;
import com.bytedance.push.utils.RomVersionParamHelper;
import com.bytedance.trae.login.traeauth.TraeAuthManager;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import com.ss.android.common.applog.AppLog;
import com.ss.android.message.AppProvider;
import com.ss.android.message.PushThreadHandlerManager;
import com.ss.android.message.util.ToolUtils;
import com.ss.android.pushmanager.client.PushSettingManager;
import com.ss.android.pushmanager.setting.PushCommonSetting;
import com.ss.android.pushmanager.setting.PushSetting;
import com.ss.android.ug.bus.UgBusFramework;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PushImpl implements IPushService {
    static long sInitTimeCost;
    private AbsBDPushConfiguration mBDPushConfiguration;
    private volatile Configuration mConfiguration;
    private ProcessStatsCalculator mProcessStatsCalculator;
    private final AtomicBoolean mInit = new AtomicBoolean(false);
    private final AtomicBoolean mStarted = new AtomicBoolean(false);

    @Override // com.bytedance.push.interfaze.IPushService
    public void onAttachBaseContext(Application application) {
        if (ToolUtils.isMainProcess(application) || ToolUtils.isMessageProcess(application) || ToolUtils.isPushServiceProcess(application) || ToolUtils.isSmpProcess(application)) {
            AppProvider.initApp(application);
        }
        if (ToolUtils.isSmpProcess(application)) {
            PushServiceManager.get().getAliveMonitorService().monitorAssociationStart(application);
            PushServiceManager.get().getIAllianceService().onAttachBaseContext(application);
            PushServiceManager.get().getAliveMonitorService().startDetectProcessLaunchReason(application);
        }
    }

    @Override // com.bytedance.push.interfaze.IPushService
    public void initOnApplication(AbsBDPushConfiguration absBDPushConfiguration) {
        this.mBDPushConfiguration = absBDPushConfiguration;
        PushSupporter.get().init(absBDPushConfiguration);
        Configuration.setInstance(absBDPushConfiguration.getConfiguration());
        initOnApplicationWithOldConfiguration();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Configuration getConfiguration() {
        if (this.mConfiguration == null) {
            synchronized (this.mInit) {
                if (this.mConfiguration == null) {
                    this.mConfiguration = Configuration.get();
                }
            }
        }
        return this.mConfiguration;
    }

    private void initOnApplicationWithOldConfiguration() {
        if (this.mInit.getAndSet(true)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Logger.m274i(IPushService.TAG, "initOnApplication , cur process is " + getConfiguration().mProcess);
        ProcessLifeCycleObserver.getInstance().initOnApplication();
        sInitTimeCost = System.currentTimeMillis() - currentTimeMillis;
        Logger.m268d(IPushService.TAG, "init time cost:" + sInitTimeCost);
        if (getConfiguration().mEnableInitOnApplicationWithOldConfigurationDelay) {
            return;
        }
        initOnApplicationWithOldConfigurationDelay();
    }

    private void initOnApplicationWithOldConfigurationDelay() {
        final boolean equals = TextUtils.equals(getConfiguration().mProcess, getConfiguration().mApplication.getPackageName());
        if (!ToolUtils.isSmpProcess(getConfiguration().mApplication)) {
            PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.bytedance.push.PushImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    PushImpl pushImpl = PushImpl.this;
                    pushImpl.initProcessStatics(pushImpl.getConfiguration(), equals);
                }
            });
        }
        PushSupporter.get().getMonitor().monitorInitTimeCoast(sInitTimeCost);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initProcessStatics(Configuration configuration, boolean z) {
        ProcessStatsConfigProvider processStatsConfigProvider;
        if (!PushServiceManager.get().getIPushStatisticsExternalService().isEnablePushStatistics()) {
            if (((PushOnlineSettings) SettingsManager.obtain(configuration.mApplication, PushOnlineSettings.class)).enableProcessStats()) {
                if (z) {
                    processStatsConfigProvider = new ProcessStatsConfigProvider(this.mConfiguration.mApplication, getSupportService().getLogger(), configuration.mEventCallback);
                } else {
                    processStatsConfigProvider = new ProcessStatsConfigProvider(this.mConfiguration.mApplication, getSupportService().getLogger());
                }
                ProcessStatsCalculator processStatsCalculator = new ProcessStatsCalculator(processStatsConfigProvider, getSupportService().getLogger());
                this.mProcessStatsCalculator = processStatsCalculator;
                processStatsCalculator.start();
                if (z) {
                    return;
                }
                this.mProcessStatsCalculator.tryStartUpload();
                return;
            }
            return;
        }
        PushServiceManager.get().getIPushStatisticsExternalService().onProcessStart();
    }

    @Override // com.bytedance.push.interfaze.IPushService
    @Deprecated
    public void initOnApplication(Configuration configuration) {
        Configuration.setInstance(configuration);
        initOnApplicationWithOldConfiguration();
    }

    @Override // com.bytedance.push.interfaze.IPushService
    public void initOnApplicationDelay() {
        if (getConfiguration().mEnableInitOnApplicationWithOldConfigurationDelay) {
            initOnApplicationWithOldConfigurationDelay();
        }
        ProcessLifeCycleObserver.getInstance().initOnApplicationDelayForMainProcess();
    }

    @Override // com.bytedance.push.interfaze.IPushService
    public void start(String str, String str2, String str3) {
        start(str, str2, str3, null);
    }

    @Override // com.bytedance.push.interfaze.IPushService
    public void start(String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put("clientudid", str3);
        hashMap.put(CommonConstants.KEY_DID, str);
        hashMap.put("install_id", str2);
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("alias", str4);
        }
        start(hashMap, false);
    }

    @Override // com.bytedance.push.interfaze.IPushService
    public void startNonMainProcess() {
        PushSupporter.get().getProcessManagerService().startNonMainProcess();
    }

    @Override // com.bytedance.push.interfaze.IPushService
    public boolean isPushInit() {
        return this.mInit.get();
    }

    @Override // com.bytedance.push.interfaze.IPushService
    public boolean isPushStarted() {
        return this.mStarted.get();
    }

    @Override // com.bytedance.push.interfaze.IPushService
    public void start(Map<String, String> map, boolean z) {
        SettingsManager.allowReadSettingsOnMain = true;
        PushServiceManager.get().getPushTraceExternalService().getTraceScene(PushTraceSceneType.ALLIANCE_WAKEUP).enterNode("push_start", "Push logic is started");
        Application application = getConfiguration().mApplication;
        boolean saveSsids = saveSsids(map);
        Logger.m268d("Start", "BDPush start ,isDidValid = " + saveSsids + " forceUpdate = " + z + " cur process is " + getConfiguration().mProcess);
        if (saveSsids && ToolUtils.isMainProcess(application)) {
            ISupport supportService = getSupportService();
            if (this.mStarted.compareAndSet(false, true)) {
                ITracingMonitor iTracingMonitor = (ITracingMonitor) UgBusFramework.getService(ITracingMonitor.class);
                if (iTracingMonitor != null) {
                    iTracingMonitor.start();
                }
                AliveKeeperProxy.inst(getConfiguration().mApplication).enableMessageReceiver(PushSupporter.get().getProcessManagerService().allowStartNonMainProcess());
                startOnce(application, supportService);
                UidTokenSynchronizer.getUidTokenSynchronizer().observerUidChangeEvent(supportService, getConfiguration().mAccountService);
                ProcessStatsCalculator processStatsCalculator = this.mProcessStatsCalculator;
                if (processStatsCalculator != null) {
                    processStatsCalculator.tryStartUpload();
                }
                supportService.requestSettings(getConfiguration().mAutoUpdateSettings);
            } else {
                UidTokenSynchronizer.getUidTokenSynchronizer().checkUidUpdate(supportService, getConfiguration().mAccountService);
            }
            supportService.getMonitor().monitorStart();
            supportService.getSenderService().tryUpdateSender(z);
            PushLifeManager.inst().handleAppLogUpdate(application, map);
        }
    }

    @Override // com.bytedance.push.interfaze.IPushService
    public void start(Map<String, String> map, boolean z, boolean z2) {
        SendTokenTask.forceSendToken(z2);
        start(map, z);
    }

    @Override // com.bytedance.push.interfaze.IPushService
    public void updateSettings(Context context, JSONObject jSONObject) {
        if (ToolUtils.isMainProcess(context)) {
            if (TextUtils.isEmpty(PushCommonSetting.getInstance().getDeviceId())) {
                Logger.m278w(IPushService.TAG, "not trigger updateSettings because did is empty");
            } else {
                UpdateSettingsTask.updateSettings(context, jSONObject, getConfiguration().mIsPreInstallVersion, UpdateSettingsTask.UPDATE_SOURCE_HOST);
            }
        }
    }

    private void startOnce(final Context context, final ISupport iSupport) {
        PushServiceManager.get().getPushTraceExternalService().getTraceScene(PushTraceSceneType.ALLIANCE_WAKEUP).enterNode("push_start_once", "startOnce logic is triggered");
        PushCommonConfiguration pushCommonConfiguration = PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration();
        if (pushCommonConfiguration.mIsDebugMode && !checkConfiguration(IPushService.TAG, getConfiguration().mApplication)) {
            if (pushCommonConfiguration.mIPushCommonConfiguration.enableExceptionInDebugModeWhenFatalError()) {
                throw new IllegalArgumentException("configuration error，please filter \"BDPush\" in logcat to correct the error");
            }
            Logger.m271e(IPushService.TAG, "configuration error，please filter \"BDPush\" in logcat to correct the error");
        }
        String pushChannelsJsonArray = ((LocalSettings) SettingsManager.obtain(AppProvider.getApp(), LocalSettings.class)).getPushChannelsJsonArray();
        getConfiguration().mIsNewUser = TextUtils.isEmpty(pushChannelsJsonArray);
        Logger.m268d(IPushService.TAG, "mIsNewUser：" + getConfiguration().mIsNewUser + " pushChannelsJsonArray：" + pushChannelsJsonArray);
        iSupport.getNotificationService().createDefaultChannel(context, getConfiguration().mDefaultNotificationChannel);
        Logger.m268d(IPushService.TAG, "start once,delay 15s to sync notice state");
        PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.bytedance.push.PushImpl.2
            @Override // java.lang.Runnable
            public void run() {
                PollingNotificationReport pollingNotificationReport = PushSetting.getInstance().getPushOnLineSettings().getPollingNotificationReport();
                if (pollingNotificationReport.enableOriginalReporting) {
                    iSupport.getNotificationService().trySyncNoticeStateOnce(context);
                }
                if (pollingNotificationReport.enableReportingTiming) {
                    iSupport.getNotificationService().trySyncNoticeStateOnceWithReportingTiming(context, "coldStartAction");
                }
                if (PushSupporter.get().getProcessManagerService().allowStartNonMainProcess()) {
                    MessageLogClientManager.start(context);
                }
                PushImpl.this.trySendPushDaemonMonitor(context);
            }
        }, TimeUnit.SECONDS.toMillis(15L));
        Logger.m268d("Polling", "ready to register foreground listener");
        iSupport.getNotificationSwitchReport().tryUpdateNoticeStateByPolling(context, iSupport);
        ((ISDKMonitor) UgBusFramework.getService(ISDKMonitor.class)).onUserActive();
        PushServiceManager.get().getIPushStatisticsExternalService().onPushStart();
        MultiProcessPushMessageDatabaseHelper.getInstance(context).deleteExpiredMsg(PushSetting.getInstance().getPushOnLineSettings().getUnDuplicateMessageSettings().maxCacheTimeInHour);
        PushSupporter.get().getMessageSpreadOutService().handleMessageNotBeenShown();
        PushSupporter.get().getProcessManagerService().onMainProcessStart(context);
        PushServiceManager.get().getAliveMonitorService().onUserActive();
        ProcessLifeCycleObserver.getInstance().start(context);
        if (PushSupporter.get().getProcessManagerService().allowStartNonMainProcess()) {
            PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.bytedance.push.PushImpl.3
                @Override // java.lang.Runnable
                public void run() {
                    PushSupporter.get().getSenderService().tryStartPushProcess(context);
                }
            }, 1000L);
        }
        PushServiceManager.get().getIClientAiExternalService().init();
        PushMultiProcessMonitor.getInstance().startReport();
        PushServiceManager.get().getPushExternalService().triggerSignalReport(PullSettingsModel.SCENE_COLD_LAUNCH);
        PushServiceManager.get().getIAllianceService().onMainProcessStart();
        PushServiceManager.get().getIDepthsI18nExternalService().start();
        PushServiceManager.get().getIPushNotificationService().tryClearSomeNotification();
        Logger.m268d(IPushService.TAG, "[startOnce]mIsNewUser:" + getConfiguration().mIsNewUser);
        if (getConfiguration().mIsNewUser) {
            if (SysDialogActivityLifecycleObserver.getIns().hasForeGround()) {
                Logger.m268d(IPushService.TAG, "[startOnce]cur has foreground");
                PushServiceManager.get().getIPermissionBootExternalService().reportDefaultNotificationStatus();
            } else {
                Logger.m268d(IPushService.TAG, "[startOnce]cur not has background,listen app status change");
                SysDialogActivityLifecycleObserver.getIns().addObserver(new Observer() { // from class: com.bytedance.push.PushImpl.4
                    @Override // java.util.Observer
                    public void update(Observable observable, Object obj) {
                        boolean booleanValue = ((Boolean) obj).booleanValue();
                        Logger.m268d(IPushService.TAG, "[startOnce]isInBackGround:" + booleanValue);
                        if (booleanValue) {
                            return;
                        }
                        SysDialogActivityLifecycleObserver.getIns().deleteObserver(this);
                        PushServiceManager.get().getIPermissionBootExternalService().reportDefaultNotificationStatus();
                    }
                });
            }
        }
    }

    @Override // com.bytedance.push.interfaze.IPushService
    public void synNotifySwitchStatus(final Context context) {
        PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.bytedance.push.PushImpl.5
            final PollingNotificationReport pollingNotificationReport = PushSetting.getInstance().getPushOnLineSettings().getPollingNotificationReport();

            @Override // java.lang.Runnable
            public void run() {
                if (this.pollingNotificationReport.enableOriginalReporting) {
                    PushImpl.this.getSupportService().getNotificationService().syncNotifySwitchStatus(context);
                }
                if (this.pollingNotificationReport.enableReportingTiming) {
                    PushImpl.this.getSupportService().getNotificationService().syncNotifySwitchStatusWithReportingTiming(context, "newAction");
                }
            }
        });
    }

    private boolean checkConfiguration(String str, Context context) {
        boolean checkThirdPushConfig = PushManager.inst().checkThirdPushConfig(str, context);
        if (checkThirdPushConfig) {
            Logger.m274i(str, "configuration correct");
        } else {
            Logger.m271e(str, "configuration error!!!");
        }
        return checkThirdPushConfig;
    }

    @Override // com.bytedance.push.interfaze.IPushService
    public ISupport getSupportService() {
        return PushSupporter.get();
    }

    @Override // com.bytedance.push.interfaze.IPushService
    public void trackClickPush(Context context, long j, String str, String str2, boolean z, JSONObject jSONObject) {
        getSupportService().getPushHandler().trackClickPush(context, j, str, str2, z, jSONObject, false);
    }

    @Override // com.bytedance.push.interfaze.IPushService
    public void trackClickPush(Context context, Intent intent, String str, JSONObject jSONObject) {
        getSupportService().getPushHandler().trackClickPush(context, intent, str, jSONObject);
    }

    @Override // com.bytedance.push.interfaze.IPushService
    public void trackClickPush(Context context, PushBody pushBody, boolean z, JSONObject jSONObject) {
        getSupportService().getPushHandler().trackClickPush(context, pushBody, z, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trySendPushDaemonMonitor(Context context) {
        try {
            String pushDaemonMonitorResult = PushSetting.getInstance().getPushDaemonMonitorResult();
            if (StringUtils.isEmpty(pushDaemonMonitorResult)) {
                return;
            }
            PushSupporter.thirdService().sendMonitor(context, IThirdSupportService.LOG_TYPE, new JSONObject(pushDaemonMonitorResult));
            PushSetting.getInstance().setPushDaemonMonitorResult("");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.bytedance.push.interfaze.IPushService
    public void notifyInAppSwitchChange(Context context, boolean z) {
        PushSettingManager.getInstance().notifyPushEnableChange(context, z);
    }

    @Override // com.bytedance.push.interfaze.IPushService
    public void notifyChildrenSwitcherChange(Context context, SwitcherStatus switcherStatus, OnSwitcherSyncListener onSwitcherSyncListener) throws IllegalArgumentException {
        getSupportService().getNotificationService().syncChildrenSwitcherChange(context, PushSetting.getInstance().isPushNotifyEnable(), switcherStatus, onSwitcherSyncListener);
    }

    @Override // com.bytedance.push.interfaze.IPushService
    public void notifyChildrenSwitcherChange(Context context, boolean z, SwitcherStatus switcherStatus, OnSwitcherSyncListener onSwitcherSyncListener) throws IllegalArgumentException {
        PushSetting.getInstance().setPushNotifyEnable(z);
        getSupportService().getNotificationService().syncChildrenSwitcherChange(context, z, switcherStatus, onSwitcherSyncListener);
    }

    @Override // com.bytedance.push.interfaze.IPushService
    public void getChildrenSwitcherStatus(Context context, OnSwitcherServerListener onSwitcherServerListener) {
        getChildrenSwitcherStatus(context, PushSetting.getInstance().isPushNotifyEnable(), onSwitcherServerListener);
    }

    @Override // com.bytedance.push.interfaze.IPushService
    public void getChildrenSwitcherStatus(Context context, boolean z, OnSwitcherServerListener onSwitcherServerListener) {
        getSupportService().getNotificationService().getChildrenSwitcherStatus(context, z, onSwitcherServerListener);
    }

    @Override // com.bytedance.push.interfaze.IPushService
    public boolean requestOpNotificationPermission() {
        return PushChannelHelper.inst(AppProvider.getApp()).requestNotificationPermissionBySysAlertForOp();
    }

    @Override // com.bytedance.push.interfaze.IPushService
    public void requestHwNotificationPermission(String str, RequestResultCallback requestResultCallback) {
        PushChannelHelper.inst(AppProvider.getApp()).requestHwNotificationPermission(str, requestResultCallback);
    }

    @Override // com.bytedance.push.interfaze.IPushService
    public void requestNotificationPermissionByBusinessAlert(String str, RequestResultCallback requestResultCallback) {
        PushChannelHelper.inst(AppProvider.getApp()).requestNotificationPermissionByBusinessAlert(str, null, true, requestResultCallback);
    }

    @Override // com.bytedance.push.interfaze.IPushService
    public void requestNotificationPermissionByBusinessAlert(String str, View view, boolean z, RequestResultCallback requestResultCallback) {
        PushChannelHelper.inst(AppProvider.getApp()).requestNotificationPermissionByBusinessAlert(str, view, !z, requestResultCallback);
    }

    @Override // com.bytedance.push.interfaze.IPushService
    public void requestNotificationPermissionByGoogleAlert(String str, View view, boolean z, boolean z2, boolean z3, RequestResultCallback requestResultCallback) {
        PushServiceManager.get().getIPermissionBootExternalService().requestNotificationPermissionByGoogleAlert(str, view, z, z2, z3, requestResultCallback);
    }

    @Override // com.bytedance.push.interfaze.IPushService
    public BusinessCustomSysAlertDialogStatus allowBusinessCustomSysAlertDialog(Context context) {
        BusinessCustomSysAlertDialogStatus allowBusinessCustomSysAlertDialog = PushServiceManager.get().getIPermissionBootExternalService().allowBusinessCustomSysAlertDialog(context);
        String str = allowBusinessCustomSysAlertDialog.supportReason;
        JSONObject jSONObject = new JSONObject();
        try {
            if (TextUtils.equals(str, "1")) {
                str = "success";
            }
            jSONObject.put("availability", str);
            jSONObject.put("os_detail_type", RomVersionParamHelper.isHarmonyOs() ? "harmony" : "android");
            String harmonyOsVersion = RomVersionParamHelper.getHarmonyOsVersion();
            if (!TextUtils.isEmpty(harmonyOsVersion)) {
                jSONObject.put("extra_rom_version", harmonyOsVersion);
            }
            jSONObject.put("dialog_type", "business");
            jSONObject.put("device_manufacturer", Build.MANUFACTURER.toLowerCase());
            PushServiceManager.get().getPushExternalService().getMultiProcessEventSenderService().onEventV3("bdpush_custom_sys_dialog_availability", jSONObject);
        } catch (Throwable th) {
            Logger.m272e(getClass().getName(), "error ", th);
        }
        return allowBusinessCustomSysAlertDialog;
    }

    @Override // com.bytedance.push.interfaze.IPushService
    public GoogleCustomSysAlertDialogStatus preCheckGoogleCustomSysAlertDialogStatus(Context context) {
        GoogleCustomSysAlertDialogStatus allowGoogleCustomSysAlertDialog = PushServiceManager.get().getIPermissionBootExternalService().allowGoogleCustomSysAlertDialog(context);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sys_permission_enable", RomVersionParamHelper.getSystemProperty("persist.sys.permission.enable"));
            jSONObject.put("android_security_patch", Build.VERSION.SECURITY_PATCH);
            jSONObject.put("availability", allowGoogleCustomSysAlertDialog.supportReason);
            jSONObject.put("os_detail_type", RomVersionParamHelper.isHarmonyOs() ? "harmony" : "android");
            String harmonyOsVersion = RomVersionParamHelper.getHarmonyOsVersion();
            if (!TextUtils.isEmpty(harmonyOsVersion)) {
                jSONObject.put("extra_rom_version", harmonyOsVersion);
            }
            jSONObject.put("dialog_type", TraeAuthManager.PLATFORM_GOOGLE);
            jSONObject.put("device_manufacturer", Build.MANUFACTURER.toLowerCase());
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("rom_version", RomVersionParamHelper.getParameter());
            PushServiceManager.get().getPushExternalService().getMultiProcessEventSenderService().onEventV3("bdpush_custom_sys_dialog_availability", jSONObject);
        } catch (Throwable th) {
            Logger.m272e(getClass().getName(), "error ", th);
        }
        return allowGoogleCustomSysAlertDialog;
    }

    @Override // com.bytedance.push.interfaze.IPushService
    public boolean requestMiRemoveVoipNotification(Context context) {
        return PushChannelHelper.inst(AppProvider.getApp()).requestMiRemoveVoipNotification(context);
    }

    @Override // com.bytedance.push.interfaze.IPushService
    public void resetPushChannels() {
        PushChannelHelper.inst(AppProvider.getApp()).resetPushChannels();
    }

    @Override // com.bytedance.push.interfaze.IPushService
    public PendingIntent getNotificationDeleteIntent(long j, JSONObject jSONObject) {
        return PushServiceManager.get().getIPushNotificationService().getNotificationDeleteIntent(j, jSONObject);
    }

    @Override // com.bytedance.push.interfaze.IPushService
    public void onNotificationDelete(long j, final JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("id", j);
            jSONObject.put(ReportConst.KEY_TIMESTAMP, ToolUtils.currentTimeMillis());
            ThreadPlus.runOnChildThread(new Runnable() { // from class: com.bytedance.push.PushImpl.6
                @Override // java.lang.Runnable
                public void run() {
                    PushSupporter.get().getClientIntelligenceService();
                    FeatureCollectionHelper.getInstance(PushImpl.this.getConfiguration().mApplication).getFeatureForEventReport(new IFeatureCallBack() { // from class: com.bytedance.push.PushImpl.6.1
                        public void onFeatureCallBack(JSONObject jSONObject2) {
                            if (jSONObject2 != null) {
                                try {
                                    jSONObject.put(FeatureConnectionConstant.CLIENT_FEATURE, jSONObject2);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                            PushSupporter.get().getMultiProcessEventSenderService().onEventV3("push_clear_ug", jSONObject);
                        }
                    }, "event_push_clear_ug");
                }
            });
            PushSupporter.get().getSignalReportService().onNotificationDelete(j);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.bytedance.push.interfaze.IPushService
    public void onNotificationDelete(long j) {
        onNotificationDelete(j, null);
    }

    private boolean saveSsids(Map<String, String> map) {
        String str;
        String str2;
        String str3;
        HashMap hashMap;
        String str4;
        String str5;
        String str6;
        if (map == null || map.isEmpty()) {
            str = null;
            str2 = null;
            str3 = null;
        } else {
            str = map.get("clientudid");
            str2 = map.get(CommonConstants.KEY_DID);
            str3 = map.get("install_id");
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            try {
                hashMap = new HashMap();
                try {
                    AppLog.getSSIDs(hashMap);
                    str4 = hashMap.get("clientudid");
                    try {
                        str5 = hashMap.get(CommonConstants.KEY_DID);
                        try {
                            str6 = hashMap.get("install_id");
                        } catch (Throwable th) {
                            th = th;
                            str = str4;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        str = str4;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Throwable th4) {
                th = th4;
            }
            try {
                Logger.m268d(IPushService.TAG, "getSSIDs from applog again ");
                str = str4;
                str3 = str6;
                str2 = str5;
                map = hashMap;
            } catch (Throwable th5) {
                th = th5;
                str = str4;
                str3 = str6;
                str2 = str5;
                map = hashMap;
                Logger.m272e(IPushService.TAG, "error when getSSIDs", th);
                return TextUtils.isEmpty(str) ? false : false;
            }
        }
        if (!TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return false;
        }
        PushSetting.getInstance().saveSSIDs(map);
        return true;
    }

    @Override // com.bytedance.push.interfaze.IPushService
    public boolean showNotification(Context context, Intent intent, NotificationBody notificationBody) {
        if (getConfiguration() == null || context == null || intent == null || notificationBody == null) {
            return false;
        }
        PushServiceManager.get().getIPushNotificationService().showNotification(context, intent, notificationBody);
        return true;
    }

    @Override // com.bytedance.push.interfaze.IPushService
    public IPushNotificationManagerService getPushNotificationManagerService() {
        return PushSupporter.get().getPushNotificationManagerService();
    }

    @Override // com.bytedance.push.interfaze.IPushService
    public boolean requestNotificationPermission() {
        return PushSupporter.get().getPushNotificationManagerService().requestNotificationPermission();
    }

    @Override // com.bytedance.push.interfaze.IPushService
    public boolean requestNotificationPermission(IRequestNotificationPermissionCallback iRequestNotificationPermissionCallback) {
        return PushSupporter.get().getPushNotificationManagerService().requestNotificationPermission(iRequestNotificationPermissionCallback);
    }

    @Override // com.bytedance.push.interfaze.IPushService
    public boolean syncEventToPushServer(List<String> list, Map<String, String> map) {
        return PushSupporter.get().getSignalReportService().syncEventToPushServer(list, map);
    }

    @Override // com.bytedance.push.interfaze.IPushService
    public void onActivityResult(int i, int i2, Intent intent) {
        PushChannelHelper.inst(AppProvider.getApp()).onActivityResult(i, i2, intent);
    }

    @Override // com.bytedance.push.interfaze.IPushService
    public void requestAndShowContent(String str) {
        PushServiceManager.get().getPullExternalService().requestAndShowContent(str);
    }

    @Override // com.bytedance.push.interfaze.IPushService
    public void setBadgeNumberToPushSdk(Context context, int i, PullScene pullScene) {
        PushServiceManager.get().getPullExternalService().setBadgeNumberToPushSdk(context, i, pullScene);
    }

    @Override // com.bytedance.push.interfaze.IPushService
    public PushPermissionBootShowResult tryShowPushPermissionBoot(PermissionBootRequestParam permissionBootRequestParam) {
        return PushServiceManager.get().getIPermissionBootExternalService().tryShowPushPermissionBoot(permissionBootRequestParam);
    }

    @Override // com.bytedance.push.interfaze.IPushService
    public void onSmpProcessStart(Context context, Object obj, String str, SmpProcessInitCallback smpProcessInitCallback) {
        PushServiceManager.get().getIAllianceService().onSmpProcessStart(context, obj, str, smpProcessInitCallback);
    }

    @Override // com.bytedance.push.interfaze.IPushService
    public void setPushTokenListener(IPushService.PushTokenCallback pushTokenCallback, IPushService.PushType pushType) {
        PushChannelHelper.inst(AppProvider.getApp()).setPushTokenListener(pushTokenCallback, pushType.getType());
    }

    @Override // com.bytedance.push.interfaze.IPushService
    public void trySupplyIntentData(Intent intent) {
        PushSupporter.get().getPushHandler().trySupplyIntentData(intent);
    }

    @Override // com.bytedance.push.interfaze.IPushService
    public ISignalReportApi getSignalReportApi() {
        return PushSupporter.get().getSignalReportService();
    }

    @Override // com.bytedance.push.interfaze.IPushService
    public boolean openSysPushSettingsPage(String str, Activity activity, ISysPermissionPageCallback iSysPermissionPageCallback) {
        return PushServiceManager.get().getIPermissionBootExternalService().openSysPushSettingsPage(str, activity, iSysPermissionPageCallback);
    }

    @Override // com.bytedance.push.interfaze.IPushService
    public boolean openSysPushSettingsPage(String str, Activity activity, LottieAnimatorModel lottieAnimatorModel, ISysPermissionPageCallback iSysPermissionPageCallback) {
        return PushServiceManager.get().getIPermissionBootExternalService().openSysPushSettingsPage(str, activity, lottieAnimatorModel, iSysPermissionPageCallback);
    }

    @Override // com.bytedance.push.interfaze.IPushService
    public boolean shouldOpenSysPushSettingsByPushSdk(Context context) {
        return PushServiceManager.get().getIPermissionBootExternalService().shouldOpenSysPushSettingsByPushSdk(context);
    }

    @Override // com.bytedance.push.interfaze.IPushService
    public void onHostNotificationPermissionDialogRequestResult(String str, boolean z, String str2) {
        PushServiceManager.get().getIPermissionBootExternalService().onNotificationPermissionDialogRequestResultEvent(str, "host", 0, 0, z, str2);
    }

    @Override // com.bytedance.push.interfaze.IPushService
    public void onHostNotificationPermissionDialogClickResult(String str, boolean z, String str2) {
        PushServiceManager.get().getIPermissionBootExternalService().onNotificationPermissionDialogClickResult(str, "host", 0, 0, z, str2, ToolUtils.areNotificationsEnabled(AppProvider.getApp()), (JSONObject) null);
    }
}
