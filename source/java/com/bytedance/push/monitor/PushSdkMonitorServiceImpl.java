package com.bytedance.push.monitor;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.android.service.manager.push.monitor.IPushSdkMonitorService;
import com.bytedance.common.model.ProcessEnum;
import com.bytedance.common.model.PushCommonConfiguration;
import com.bytedance.common.process.cross.CrossProcessHelper;
import com.bytedance.common.push.BaseJson;
import com.bytedance.common.push.interfaze.IPushCommonConfiguration;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.common.support.service.IPushConfigurationService;
import com.bytedance.memory.common.MemoryWidgetGlobal;
import com.bytedance.memory.dump.DumpFileController;
import com.bytedance.notification.NotificationDeleteBroadcastReceiver;
import com.bytedance.perf.monitor.ReportConst;
import com.bytedance.pia.core.tracing.OnlineTracing;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.appstatus.AppStatusObserverForChildProcess;
import com.bytedance.push.monitor.multiprocess.ActiveSourceMethod;
import com.bytedance.push.monitor.multiprocess.PushMultiProcessMonitor;
import com.bytedance.push.settings.PushOnlineSettings;
import com.bytedance.push.settings.SettingsManager;
import com.bytedance.push.settings.assosiation.start.AssociationStartSettingsConverter;
import com.bytedance.push.settings.assosiation.start.AssociationStartSettingsModel;
import com.bytedance.push.settings.client.intelligence.ClientIntelligenceSettingsConverter;
import com.bytedance.push.settings.client.intelligence.ClientIntelligenceSettingsModel;
import com.bytedance.push.settings.delay.start.DelayStartChildProcessSettingsConverter;
import com.bytedance.push.settings.delay.start.DelayStartChildProcessSettingsModel;
import com.bytedance.push.settings.depths.DepthsI18nSettingsConverter;
import com.bytedance.push.settings.depths.DepthsI18nSettingsModel;
import com.bytedance.push.settings.message.unduplicate.UnDuplicateSettingsConverter;
import com.bytedance.push.settings.message.unduplicate.UnDuplicateSettingsModel;
import com.bytedance.push.settings.monitor.DepthsProcessStartMonitorModel;
import com.bytedance.push.settings.monitor.PushMonitorSettingsConverter;
import com.bytedance.push.settings.monitor.PushMonitorSettingsModel;
import com.bytedance.push.settings.msg.callback.MsgCallbackSettingsConverter;
import com.bytedance.push.settings.msg.callback.MsgCallbackSettingsModel;
import com.bytedance.push.settings.notification.ClearNotificationSettingsConverter;
import com.bytedance.push.settings.notification.ClearNotificationSettingsModel;
import com.bytedance.push.settings.notification.MessageBlackTimeWindowConverter;
import com.bytedance.push.settings.notification.MessageBlackTimeWindowSettingsModel;
import com.bytedance.push.settings.notification.NotificationMonitorSettingsConverter;
import com.bytedance.push.settings.notification.NotificationMonitorSettingsModel;
import com.bytedance.push.settings.notification.NotificationParamsConverter;
import com.bytedance.push.settings.notification.NotificationParamsModel;
import com.bytedance.push.settings.notification.NotificationSettings;
import com.bytedance.push.settings.notification.NotificationSettingsConverter;
import com.bytedance.push.settings.notification.PollingNotificationReport;
import com.bytedance.push.settings.notification.PollingNotificationReportConverter;
import com.bytedance.push.settings.permission.boot.BusinessCustomSysDialogConfig;
import com.bytedance.push.settings.permission.boot.GifSysPermissionPageSettingsConverter;
import com.bytedance.push.settings.permission.boot.GifSysPermissionPageSettingsModel;
import com.bytedance.push.settings.permission.boot.GoogleCustomSysDialogConfig;
import com.bytedance.push.settings.permission.boot.GoogleCustomSysDialogSettingsConverter;
import com.bytedance.push.settings.permission.boot.HwCustomSysDialogSettingsConverter;
import com.bytedance.push.settings.permission.boot.PermissionBootChannelConverter;
import com.bytedance.push.settings.permission.boot.PermissionBootChannelModel;
import com.bytedance.push.settings.permission.boot.PermissionBootSettingsConverter;
import com.bytedance.push.settings.permission.boot.PermissionBootSettingsModel;
import com.bytedance.push.settings.permission.boot.PermissionEventSettingsConverter;
import com.bytedance.push.settings.permission.boot.PermissionEventSettingsModel;
import com.bytedance.push.settings.pull.PullSettingsConverter;
import com.bytedance.push.settings.pull.PullSettingsModel;
import com.bytedance.push.settings.push.click.PushClickReportOptSettingsConverter;
import com.bytedance.push.settings.push.click.PushClickReportOptSettingsModel;
import com.bytedance.push.settings.signal.sync.SignalReportSettingsConverter;
import com.bytedance.push.settings.signal.sync.SignalReportSettingsModel;
import com.bytedance.push.settings.statistics.StatisticsSettingsConverter;
import com.bytedance.push.settings.statistics.StatisticsSettingsModel;
import com.bytedance.push.settings.storage.SharedPreferenceStorage;
import com.bytedance.push.settings.storage.Storage;
import com.bytedance.push.settings.token.TokenRetrySettingsConverter;
import com.bytedance.push.settings.token.TokenRetrySettingsMode;
import com.bytedance.push.utils.Logger;
import com.bytedance.push.utils.NetworkUtils;
import com.ss.android.message.AppProvider;
import com.ss.android.message.PushThreadHandlerManager;
import com.ss.android.message.util.ToolUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PushSdkMonitorServiceImpl extends BaseJson implements IPushSdkMonitorService, Observer {
    private Context mContext;
    private volatile PushMonitorSettingsModel mPushMonitorSettingsModel;
    private final String TAG = "PushSdkMonitorServiceImpl";
    private final Object mSettingsModelLock = "settings_model_lock";
    private final AtomicBoolean mHasReportDauEvent = new AtomicBoolean(false);
    private Boolean mCurIsDau = null;
    private Boolean mCurIsTransmit = null;

    /* JADX INFO: Access modifiers changed from: private */
    public void initPushMonitorSettingsModel() {
        if (this.mPushMonitorSettingsModel == null) {
            synchronized (this.mSettingsModelLock) {
                if (this.mPushMonitorSettingsModel == null) {
                    Application app = AppProvider.getApp();
                    this.mContext = app;
                    if (ToolUtils.isSmpProcess(app)) {
                        final SharedPreferenceStorage sharedPreferenceStorage = new SharedPreferenceStorage(this.mContext, "push_multi_process_config");
                        this.mPushMonitorSettingsModel = new PushOnlineSettings(sharedPreferenceStorage) { // from class: com.bytedance.push.settings.PushOnlineSettings$$SettingImpl
                            private Storage mStorage;
                            private final ConcurrentHashMap<String, Object> mStickySettings = new ConcurrentHashMap<>();
                            private final ConcurrentHashMap<String, Object> mTransientSettings = new ConcurrentHashMap<>();
                            private final InstanceCreator mInstanceCreator = new InstanceCreator() { // from class: com.bytedance.push.settings.PushOnlineSettings$$SettingImpl.1
                                @Override // com.bytedance.push.settings.InstanceCreator
                                public <T> T create(Class<T> cls) {
                                    if (cls == StatisticsSettingsConverter.class) {
                                        return (T) new StatisticsSettingsConverter();
                                    }
                                    if (cls == ClientIntelligenceSettingsConverter.class) {
                                        return (T) new ClientIntelligenceSettingsConverter();
                                    }
                                    if (cls == UnDuplicateSettingsConverter.class) {
                                        return (T) new UnDuplicateSettingsConverter();
                                    }
                                    if (cls == AssociationStartSettingsConverter.class) {
                                        return (T) new AssociationStartSettingsConverter();
                                    }
                                    if (cls == DelayStartChildProcessSettingsConverter.class) {
                                        return (T) new DelayStartChildProcessSettingsConverter();
                                    }
                                    if (cls == NotificationMonitorSettingsConverter.class) {
                                        return (T) new NotificationMonitorSettingsConverter();
                                    }
                                    if (cls == MessageBlackTimeWindowConverter.class) {
                                        return (T) new MessageBlackTimeWindowConverter();
                                    }
                                    if (cls == PushMonitorSettingsConverter.class) {
                                        return (T) new PushMonitorSettingsConverter();
                                    }
                                    if (cls == MsgCallbackSettingsConverter.class) {
                                        return (T) new MsgCallbackSettingsConverter();
                                    }
                                    if (cls == NotificationSettingsConverter.class) {
                                        return (T) new NotificationSettingsConverter();
                                    }
                                    if (cls == PullSettingsConverter.class) {
                                        return (T) new PullSettingsConverter();
                                    }
                                    if (cls == PermissionBootSettingsConverter.class) {
                                        return (T) new PermissionBootSettingsConverter();
                                    }
                                    if (cls == PermissionBootChannelConverter.class) {
                                        return (T) new PermissionBootChannelConverter();
                                    }
                                    if (cls == SignalReportSettingsConverter.class) {
                                        return (T) new SignalReportSettingsConverter();
                                    }
                                    if (cls == DepthsI18nSettingsConverter.class) {
                                        return (T) new DepthsI18nSettingsConverter();
                                    }
                                    if (cls == PollingNotificationReportConverter.class) {
                                        return (T) new PollingNotificationReportConverter();
                                    }
                                    if (cls == GifSysPermissionPageSettingsConverter.class) {
                                        return (T) new GifSysPermissionPageSettingsConverter();
                                    }
                                    if (cls == PushClickReportOptSettingsConverter.class) {
                                        return (T) new PushClickReportOptSettingsConverter();
                                    }
                                    if (cls == ClearNotificationSettingsConverter.class) {
                                        return (T) new ClearNotificationSettingsConverter();
                                    }
                                    if (cls == HwCustomSysDialogSettingsConverter.class) {
                                        return (T) new HwCustomSysDialogSettingsConverter();
                                    }
                                    if (cls == NotificationParamsConverter.class) {
                                        return (T) new NotificationParamsConverter();
                                    }
                                    if (cls == TokenRetrySettingsConverter.class) {
                                        return (T) new TokenRetrySettingsConverter();
                                    }
                                    if (cls == GoogleCustomSysDialogSettingsConverter.class) {
                                        return (T) new GoogleCustomSysDialogSettingsConverter();
                                    }
                                    if (cls == PermissionEventSettingsConverter.class) {
                                        return (T) new PermissionEventSettingsConverter();
                                    }
                                    return null;
                                }
                            };

                            {
                                this.mStorage = sharedPreferenceStorage;
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public boolean isAllowSettingsNotifyEnable() {
                                Storage storage = this.mStorage;
                                if (storage == null || !storage.contains("allow_settings_notify_enable")) {
                                    return true;
                                }
                                return this.mStorage.getBoolean("allow_settings_notify_enable");
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public long getUpdateSenderIntervalTimeInMs() {
                                Storage storage = this.mStorage;
                                if (storage == null || !storage.contains("ttpush_update_sender_interval")) {
                                    return 10800000L;
                                }
                                return this.mStorage.getLong("ttpush_update_sender_interval");
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public long getUpdateTokenIntervalInSecond() {
                                Storage storage = this.mStorage;
                                return (storage == null || !storage.contains("ttpush_update_token_interval")) ? MemoryWidgetGlobal.ONE_DAY_MILLIS : this.mStorage.getLong("ttpush_update_token_interval");
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public boolean enableRestrictUpdateToken() {
                                Storage storage = this.mStorage;
                                if (storage == null || !storage.contains("ttpush_enable_restrict_update_token")) {
                                    return false;
                                }
                                return this.mStorage.getBoolean("ttpush_enable_restrict_update_token");
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public boolean killPushProcessWhenStopService() {
                                Storage storage = this.mStorage;
                                if (storage == null || !storage.contains("ttpush_shut_push_on_stop_service")) {
                                    return false;
                                }
                                return this.mStorage.getBoolean("ttpush_shut_push_on_stop_service");
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public boolean isReceiverMessageWakeupScreen() {
                                Storage storage = this.mStorage;
                                if (storage == null || !storage.contains("is_receiver_message_wakeup_screen")) {
                                    return false;
                                }
                                return this.mStorage.getBoolean("is_receiver_message_wakeup_screen");
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public int getReceiverMessageWakeupScreenTime() {
                                Storage storage = this.mStorage;
                                if (storage == null || !storage.contains("receiver_message_wakeup_screen_time")) {
                                    return 5000;
                                }
                                return this.mStorage.getInt("receiver_message_wakeup_screen_time");
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public long getUploadSwitchInterval() {
                                Storage storage = this.mStorage;
                                return (storage == null || !storage.contains("ttpush_upload_switch_interval")) ? MemoryWidgetGlobal.ONE_DAY_MILLIS : this.mStorage.getLong("ttpush_upload_switch_interval");
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public int forbidSetAlias() {
                                Storage storage = this.mStorage;
                                if (storage == null || !storage.contains("ttpush_forbid_alias")) {
                                    return 0;
                                }
                                return this.mStorage.getInt("ttpush_forbid_alias");
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public boolean needControlFlares() {
                                Storage storage = this.mStorage;
                                if (storage == null || !storage.contains("need_control_miui_flares_v2")) {
                                    return true;
                                }
                                return this.mStorage.getBoolean("need_control_miui_flares_v2");
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public boolean removeAllAutoBoot() {
                                Storage storage = this.mStorage;
                                if (storage == null || !storage.contains(PushOnlineSettings.KEY_REMOVE_AUTO_BOOT)) {
                                    return false;
                                }
                                return this.mStorage.getBoolean(PushOnlineSettings.KEY_REMOVE_AUTO_BOOT);
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public boolean removeUmengAutoBoot() {
                                Storage storage = this.mStorage;
                                if (storage == null || !storage.contains("remove_umeng_autoboot")) {
                                    return true;
                                }
                                return this.mStorage.getBoolean("remove_umeng_autoboot");
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public int checkSign() {
                                Storage storage = this.mStorage;
                                if (storage == null || !storage.contains("check_sign_v2")) {
                                    return 0;
                                }
                                return this.mStorage.getInt("check_sign_v2");
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public boolean passThoughUseNewActivity() {
                                Storage storage = this.mStorage;
                                if (storage == null || !storage.contains("pass_though_new_activity")) {
                                    return false;
                                }
                                return this.mStorage.getBoolean("pass_though_new_activity");
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public long getUpdateFrontierSettingIntervalTimeInMinute() {
                                Storage storage = this.mStorage;
                                if (storage == null || !storage.contains(PushOnlineSettings.KEY_UPDATE_FRONTIER_SETTING_INTERVAL)) {
                                    return 10080L;
                                }
                                return this.mStorage.getLong(PushOnlineSettings.KEY_UPDATE_FRONTIER_SETTING_INTERVAL);
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public int getWakeUpStrategy() {
                                Storage storage = this.mStorage;
                                if (storage == null || !storage.contains(PushOnlineSettings.KEY_WAKEUP_SUPPORT_STRATEGY)) {
                                    return 1;
                                }
                                return this.mStorage.getInt(PushOnlineSettings.KEY_WAKEUP_SUPPORT_STRATEGY);
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public boolean enablePassThroughRedbadgeShow() {
                                Storage storage = this.mStorage;
                                if (storage == null || !storage.contains(PushOnlineSettings.KEY_ENABLE_PASS_THROUGH_REDBADGE_SHOW)) {
                                    return true;
                                }
                                return this.mStorage.getBoolean(PushOnlineSettings.KEY_ENABLE_PASS_THROUGH_REDBADGE_SHOW);
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public boolean enableRedbadgeAutoDismiss() {
                                Storage storage = this.mStorage;
                                if (storage == null || !storage.contains(PushOnlineSettings.KEY_ENABLE_REDBADGE_AUTO_DISMISS)) {
                                    return true;
                                }
                                return this.mStorage.getBoolean(PushOnlineSettings.KEY_ENABLE_REDBADGE_AUTO_DISMISS);
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public long getUploadHwDeviceInfoTimeInMinute() {
                                Storage storage = this.mStorage;
                                if (storage == null || !storage.contains(PushOnlineSettings.KEY_UPLOAD_HW_INFO_INTERVAL)) {
                                    return 21600L;
                                }
                                return this.mStorage.getLong(PushOnlineSettings.KEY_UPLOAD_HW_INFO_INTERVAL);
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public boolean enableHwAnalytics() {
                                Storage storage = this.mStorage;
                                if (storage == null || !storage.contains(PushOnlineSettings.KEY_ENABLE_HW_ANALYTICS)) {
                                    return false;
                                }
                                return this.mStorage.getBoolean(PushOnlineSettings.KEY_ENABLE_HW_ANALYTICS);
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public boolean enableStartPushProcess() {
                                Storage storage = this.mStorage;
                                if (storage == null || !storage.contains("enable_start_push_process")) {
                                    return true;
                                }
                                return this.mStorage.getBoolean("enable_start_push_process");
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public int getPullApiStrategy() {
                                Storage storage = this.mStorage;
                                if (storage == null || !storage.contains(PushOnlineSettings.KEY_PULL_API_STRATEGY)) {
                                    return 0;
                                }
                                return this.mStorage.getInt(PushOnlineSettings.KEY_PULL_API_STRATEGY);
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public String getRedBadgeStrategy() {
                                Storage storage = this.mStorage;
                                return (storage == null || !storage.contains("pull_redbadge_strategy")) ? "" : this.mStorage.getString("pull_redbadge_strategy");
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public long getRequestSettingsInterval() {
                                Storage storage = this.mStorage;
                                return (storage == null || !storage.contains("ttpush_request_settings_interval")) ? DumpFileController.HOUR : this.mStorage.getLong("ttpush_request_settings_interval");
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public boolean enableMonitorAssociationStart() {
                                Storage storage = this.mStorage;
                                if (storage == null || !storage.contains("enable_monitor_association_start")) {
                                    return false;
                                }
                                return this.mStorage.getBoolean("enable_monitor_association_start");
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public boolean enableReportClientFeature() {
                                Storage storage = this.mStorage;
                                if (storage == null || !storage.contains("enable_report_client_feature")) {
                                    return false;
                                }
                                return this.mStorage.getBoolean("enable_report_client_feature");
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public int notificationSmallIconStyle() {
                                Storage storage = this.mStorage;
                                if (storage == null || !storage.contains("notification_small_icon_style")) {
                                    return 0;
                                }
                                return this.mStorage.getInt("notification_small_icon_style");
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public StatisticsSettingsModel getPushStatisticsSettings() {
                                Storage storage = this.mStorage;
                                if (storage != null && storage.contains("push_statistics_settings")) {
                                    return ((StatisticsSettingsConverter) InstanceCache.obtain(StatisticsSettingsConverter.class, this.mInstanceCreator)).mo236to(this.mStorage.getString("push_statistics_settings"));
                                }
                                return ((StatisticsSettingsConverter) InstanceCache.obtain(StatisticsSettingsConverter.class, this.mInstanceCreator)).create();
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public ClientIntelligenceSettingsModel getClientIntelligenceSettings() {
                                Storage storage = this.mStorage;
                                if (storage != null && storage.contains("client_intelligence_settings")) {
                                    return ((ClientIntelligenceSettingsConverter) InstanceCache.obtain(ClientIntelligenceSettingsConverter.class, this.mInstanceCreator)).mo236to(this.mStorage.getString("client_intelligence_settings"));
                                }
                                return ((ClientIntelligenceSettingsConverter) InstanceCache.obtain(ClientIntelligenceSettingsConverter.class, this.mInstanceCreator)).create();
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public UnDuplicateSettingsModel getUnDuplicateMessageSettings() {
                                Storage storage = this.mStorage;
                                if (storage != null && storage.contains("un_duplicate_message_settings")) {
                                    return ((UnDuplicateSettingsConverter) InstanceCache.obtain(UnDuplicateSettingsConverter.class, this.mInstanceCreator)).mo236to(this.mStorage.getString("un_duplicate_message_settings"));
                                }
                                return ((UnDuplicateSettingsConverter) InstanceCache.obtain(UnDuplicateSettingsConverter.class, this.mInstanceCreator)).create();
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public AssociationStartSettingsModel getAssociationStartSettings() {
                                Storage storage = this.mStorage;
                                if (storage != null && storage.contains("association_start_settings")) {
                                    return ((AssociationStartSettingsConverter) InstanceCache.obtain(AssociationStartSettingsConverter.class, this.mInstanceCreator)).mo236to(this.mStorage.getString("association_start_settings"));
                                }
                                return ((AssociationStartSettingsConverter) InstanceCache.obtain(AssociationStartSettingsConverter.class, this.mInstanceCreator)).create();
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public String getNotAllowAliveWhenNoMainProcessList() {
                                Storage storage = this.mStorage;
                                return (storage == null || !storage.contains("not_allow_alive_when_no_main_process_list")) ? "push,pushservice,smp" : this.mStorage.getString("not_allow_alive_when_no_main_process_list");
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public boolean needKillAllIfMainProcessDied() {
                                Storage storage = this.mStorage;
                                if (storage == null || !storage.contains("need_kill_all_if_main_process_died")) {
                                    return true;
                                }
                                return this.mStorage.getBoolean("need_kill_all_if_main_process_died");
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public boolean enableProcessStats() {
                                Storage storage = this.mStorage;
                                if (storage == null || !storage.contains("enable_process_stats")) {
                                    return false;
                                }
                                return this.mStorage.getBoolean("enable_process_stats");
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public DelayStartChildProcessSettingsModel getDelayStartChildProcessSettings() {
                                Storage storage = this.mStorage;
                                if (storage != null && storage.contains("delay_start_child_process_settings")) {
                                    return ((DelayStartChildProcessSettingsConverter) InstanceCache.obtain(DelayStartChildProcessSettingsConverter.class, this.mInstanceCreator)).mo236to(this.mStorage.getString("delay_start_child_process_settings"));
                                }
                                return ((DelayStartChildProcessSettingsConverter) InstanceCache.obtain(DelayStartChildProcessSettingsConverter.class, this.mInstanceCreator)).create();
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public boolean enableReportUmengChannel() {
                                Storage storage = this.mStorage;
                                if (storage == null || !storage.contains("enable_report_umeng_channel")) {
                                    return true;
                                }
                                return this.mStorage.getBoolean("enable_report_umeng_channel");
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public long autoStartPushDelayInMill() {
                                Storage storage = this.mStorage;
                                return (storage == null || !storage.contains("auto_start_push_delay_in_mill")) ? OnlineTracing.DATA_TIMEOUT : this.mStorage.getLong("auto_start_push_delay_in_mill");
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public String getAbTag() {
                                Storage storage = this.mStorage;
                                return (storage == null || !storage.contains("ab_tag")) ? "" : this.mStorage.getString("ab_tag");
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public boolean enableMonitorChannelCreate() {
                                Storage storage = this.mStorage;
                                if (storage == null || !storage.contains("enable_monitor_channel_create")) {
                                    return false;
                                }
                                return this.mStorage.getBoolean("enable_monitor_channel_create");
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public boolean enableCachedAndroidId() {
                                Storage storage = this.mStorage;
                                if (storage == null || !storage.contains("enable_cached_android_id")) {
                                    return false;
                                }
                                return this.mStorage.getBoolean("enable_cached_android_id");
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public int getNotificationSoundMode() {
                                Storage storage = this.mStorage;
                                if (storage == null || !storage.contains("notification_sound_mode")) {
                                    return 0;
                                }
                                return this.mStorage.getInt("notification_sound_mode");
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public boolean enableDefaultConfiguration() {
                                Storage storage = this.mStorage;
                                if (storage == null || !storage.contains("enable_default_configuration")) {
                                    return true;
                                }
                                return this.mStorage.getBoolean("enable_default_configuration");
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public boolean useOpHomeBadgeV2() {
                                Storage storage = this.mStorage;
                                if (storage == null || !storage.contains("use_op_home_badge_v2")) {
                                    return true;
                                }
                                return this.mStorage.getBoolean("use_op_home_badge_v2");
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public boolean allowCacheMessageToDb() {
                                Storage storage = this.mStorage;
                                if (storage == null || !storage.contains("allow_cache_msg_to_db")) {
                                    return true;
                                }
                                return this.mStorage.getBoolean("allow_cache_msg_to_db");
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public boolean allowSpreadOutMessage() {
                                Storage storage = this.mStorage;
                                if (storage == null || !storage.contains("allow_spread_out_message")) {
                                    return false;
                                }
                                return this.mStorage.getBoolean("allow_spread_out_message");
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public NotificationMonitorSettingsModel getNotificationMonitorSettings() {
                                Storage storage = this.mStorage;
                                if (storage != null && storage.contains("notification_show_monitor_settings")) {
                                    return ((NotificationMonitorSettingsConverter) InstanceCache.obtain(NotificationMonitorSettingsConverter.class, this.mInstanceCreator)).mo236to(this.mStorage.getString("notification_show_monitor_settings"));
                                }
                                return ((NotificationMonitorSettingsConverter) InstanceCache.obtain(NotificationMonitorSettingsConverter.class, this.mInstanceCreator)).create();
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public MessageBlackTimeWindowSettingsModel getMessageBlackTimeWindowSettings() {
                                Storage storage = this.mStorage;
                                if (storage != null && storage.contains("message_black_time_window")) {
                                    return ((MessageBlackTimeWindowConverter) InstanceCache.obtain(MessageBlackTimeWindowConverter.class, this.mInstanceCreator)).mo236to(this.mStorage.getString("message_black_time_window"));
                                }
                                return ((MessageBlackTimeWindowConverter) InstanceCache.obtain(MessageBlackTimeWindowConverter.class, this.mInstanceCreator)).create();
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public PushMonitorSettingsModel getPushMonitorSettings() {
                                Storage storage = this.mStorage;
                                if (storage != null && storage.contains("push_monitor_settings")) {
                                    return ((PushMonitorSettingsConverter) InstanceCache.obtain(PushMonitorSettingsConverter.class, this.mInstanceCreator)).mo236to(this.mStorage.getString("push_monitor_settings"));
                                }
                                return ((PushMonitorSettingsConverter) InstanceCache.obtain(PushMonitorSettingsConverter.class, this.mInstanceCreator)).create();
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public boolean useHwManifestAppId() {
                                Storage storage = this.mStorage;
                                if (storage == null || !storage.contains("use_hw_manifest_appid")) {
                                    return false;
                                }
                                return this.mStorage.getBoolean("use_hw_manifest_appid");
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public MsgCallbackSettingsModel getMsgCallbackSettings() {
                                Storage storage = this.mStorage;
                                if (storage != null && storage.contains("msg_call_back_settings")) {
                                    return ((MsgCallbackSettingsConverter) InstanceCache.obtain(MsgCallbackSettingsConverter.class, this.mInstanceCreator)).mo236to(this.mStorage.getString("msg_call_back_settings"));
                                }
                                return ((MsgCallbackSettingsConverter) InstanceCache.obtain(MsgCallbackSettingsConverter.class, this.mInstanceCreator)).create();
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public boolean allowForceSendToken() {
                                Storage storage = this.mStorage;
                                if (storage == null || !storage.contains("allow_force_send_token")) {
                                    return true;
                                }
                                return this.mStorage.getBoolean("allow_force_send_token");
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public NotificationSettings getNotificationSettings() {
                                Storage storage = this.mStorage;
                                if (storage != null && storage.contains("notification_settings")) {
                                    return ((NotificationSettingsConverter) InstanceCache.obtain(NotificationSettingsConverter.class, this.mInstanceCreator)).mo236to(this.mStorage.getString("notification_settings"));
                                }
                                return ((NotificationSettingsConverter) InstanceCache.obtain(NotificationSettingsConverter.class, this.mInstanceCreator)).create();
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public PullSettingsModel getPullSettings() {
                                Storage storage = this.mStorage;
                                if (storage != null && storage.contains("pull_config")) {
                                    return ((PullSettingsConverter) InstanceCache.obtain(PullSettingsConverter.class, this.mInstanceCreator)).mo236to(this.mStorage.getString("pull_config"));
                                }
                                return ((PullSettingsConverter) InstanceCache.obtain(PullSettingsConverter.class, this.mInstanceCreator)).create();
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public PermissionBootSettingsModel permissionBootSettings() {
                                Storage storage = this.mStorage;
                                if (storage != null && storage.contains("permission_boot_settings")) {
                                    return ((PermissionBootSettingsConverter) InstanceCache.obtain(PermissionBootSettingsConverter.class, this.mInstanceCreator)).mo236to(this.mStorage.getString("permission_boot_settings"));
                                }
                                return ((PermissionBootSettingsConverter) InstanceCache.obtain(PermissionBootSettingsConverter.class, this.mInstanceCreator)).create();
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public PermissionBootChannelModel permissionBootChannelSettings() {
                                Storage storage = this.mStorage;
                                if (storage != null && storage.contains("permission_boot_channel_clear_config")) {
                                    return ((PermissionBootChannelConverter) InstanceCache.obtain(PermissionBootChannelConverter.class, this.mInstanceCreator)).mo236to(this.mStorage.getString("permission_boot_channel_clear_config"));
                                }
                                return ((PermissionBootChannelConverter) InstanceCache.obtain(PermissionBootChannelConverter.class, this.mInstanceCreator)).create();
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public boolean optSensitiveApiInvoke() {
                                Storage storage = this.mStorage;
                                if (storage == null || !storage.contains(PushOnlineSettings.KEY_OPT_SENSITIVE_API_INVOKE)) {
                                    return false;
                                }
                                return this.mStorage.getBoolean(PushOnlineSettings.KEY_OPT_SENSITIVE_API_INVOKE);
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public boolean allowProfileId() {
                                Storage storage = this.mStorage;
                                if (storage == null || !storage.contains("allow_profile_id")) {
                                    return false;
                                }
                                return this.mStorage.getBoolean("allow_profile_id");
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public SignalReportSettingsModel getSignalSyncSettingsModel() {
                                Storage storage = this.mStorage;
                                if (storage != null && storage.contains(PushOnlineSettings.KEY_SIGNAL_REPORT_SETTINGS)) {
                                    return ((SignalReportSettingsConverter) InstanceCache.obtain(SignalReportSettingsConverter.class, this.mInstanceCreator)).mo236to(this.mStorage.getString(PushOnlineSettings.KEY_SIGNAL_REPORT_SETTINGS));
                                }
                                return ((SignalReportSettingsConverter) InstanceCache.obtain(SignalReportSettingsConverter.class, this.mInstanceCreator)).create();
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public boolean enableBackUpTokenRefresh() {
                                Storage storage = this.mStorage;
                                if (storage == null || !storage.contains("enable_backup_token_refresh")) {
                                    return false;
                                }
                                return this.mStorage.getBoolean("enable_backup_token_refresh");
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public DepthsI18nSettingsModel getDepthsI18nSettingsModel() {
                                Storage storage = this.mStorage;
                                if (storage != null && storage.contains("depths_i18n_config")) {
                                    return ((DepthsI18nSettingsConverter) InstanceCache.obtain(DepthsI18nSettingsConverter.class, this.mInstanceCreator)).mo236to(this.mStorage.getString("depths_i18n_config"));
                                }
                                return ((DepthsI18nSettingsConverter) InstanceCache.obtain(DepthsI18nSettingsConverter.class, this.mInstanceCreator)).create();
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public boolean enableGifPermissionPage() {
                                Storage storage = this.mStorage;
                                if (storage == null || !storage.contains("enable_gif_permission_page")) {
                                    return false;
                                }
                                return this.mStorage.getBoolean("enable_gif_permission_page");
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public PollingNotificationReport getPollingNotificationReport() {
                                Storage storage = this.mStorage;
                                if (storage != null && storage.contains("polling_notification_report")) {
                                    return ((PollingNotificationReportConverter) InstanceCache.obtain(PollingNotificationReportConverter.class, this.mInstanceCreator)).mo236to(this.mStorage.getString("polling_notification_report"));
                                }
                                return ((PollingNotificationReportConverter) InstanceCache.obtain(PollingNotificationReportConverter.class, this.mInstanceCreator)).create();
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public GifSysPermissionPageSettingsModel getGifSysPermissionPageSettingsModel() {
                                Storage storage = this.mStorage;
                                if (storage != null && storage.contains(PushOnlineSettings.KEY_GIF_SYS_PERMISSION_PAGE_SETTINGS)) {
                                    return ((GifSysPermissionPageSettingsConverter) InstanceCache.obtain(GifSysPermissionPageSettingsConverter.class, this.mInstanceCreator)).mo236to(this.mStorage.getString(PushOnlineSettings.KEY_GIF_SYS_PERMISSION_PAGE_SETTINGS));
                                }
                                return ((GifSysPermissionPageSettingsConverter) InstanceCache.obtain(GifSysPermissionPageSettingsConverter.class, this.mInstanceCreator)).create();
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public PushClickReportOptSettingsModel getPushClickReportOptSettingsModel() {
                                Storage storage = this.mStorage;
                                if (storage != null && storage.contains("opt_push_click_session_id")) {
                                    return ((PushClickReportOptSettingsConverter) InstanceCache.obtain(PushClickReportOptSettingsConverter.class, this.mInstanceCreator)).mo236to(this.mStorage.getString("opt_push_click_session_id"));
                                }
                                return ((PushClickReportOptSettingsConverter) InstanceCache.obtain(PushClickReportOptSettingsConverter.class, this.mInstanceCreator)).create();
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public ClearNotificationSettingsModel getClearNotificationConfig() {
                                Storage storage = this.mStorage;
                                if (storage != null && storage.contains("clear_notification_config")) {
                                    return ((ClearNotificationSettingsConverter) InstanceCache.obtain(ClearNotificationSettingsConverter.class, this.mInstanceCreator)).mo236to(this.mStorage.getString("clear_notification_config"));
                                }
                                return ((ClearNotificationSettingsConverter) InstanceCache.obtain(ClearNotificationSettingsConverter.class, this.mInstanceCreator)).create();
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public BusinessCustomSysDialogConfig getBusinessCustomSysDialogConfig() {
                                Storage storage = this.mStorage;
                                if (storage != null && storage.contains("custom_sys_dialog_config_v2")) {
                                    return ((HwCustomSysDialogSettingsConverter) InstanceCache.obtain(HwCustomSysDialogSettingsConverter.class, this.mInstanceCreator)).mo236to(this.mStorage.getString("custom_sys_dialog_config_v2"));
                                }
                                return ((HwCustomSysDialogSettingsConverter) InstanceCache.obtain(HwCustomSysDialogSettingsConverter.class, this.mInstanceCreator)).create();
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public NotificationParamsModel getNotificationParamsModel() {
                                Storage storage = this.mStorage;
                                if (storage != null && storage.contains("notification_params_config")) {
                                    return ((NotificationParamsConverter) InstanceCache.obtain(NotificationParamsConverter.class, this.mInstanceCreator)).mo236to(this.mStorage.getString("notification_params_config"));
                                }
                                return ((NotificationParamsConverter) InstanceCache.obtain(NotificationParamsConverter.class, this.mInstanceCreator)).create();
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public TokenRetrySettingsMode getTokenRetrySettingsMode() {
                                Storage storage = this.mStorage;
                                if (storage != null && storage.contains("token_retry_config")) {
                                    return ((TokenRetrySettingsConverter) InstanceCache.obtain(TokenRetrySettingsConverter.class, this.mInstanceCreator)).mo236to(this.mStorage.getString("token_retry_config"));
                                }
                                return ((TokenRetrySettingsConverter) InstanceCache.obtain(TokenRetrySettingsConverter.class, this.mInstanceCreator)).create();
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public boolean killSmpAfterVvPush() {
                                Storage storage = this.mStorage;
                                if (storage == null || !storage.contains("kill_smp_after_vv_push")) {
                                    return false;
                                }
                                return this.mStorage.getBoolean("kill_smp_after_vv_push");
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public GoogleCustomSysDialogConfig getGoogleCustomSysDialogConfig() {
                                Storage storage = this.mStorage;
                                if (storage != null && storage.contains(PushOnlineSettings.KEY_GOOGLE_CUSTOM_SYS_DIALOG_CONFIG)) {
                                    return ((GoogleCustomSysDialogSettingsConverter) InstanceCache.obtain(GoogleCustomSysDialogSettingsConverter.class, this.mInstanceCreator)).mo236to(this.mStorage.getString(PushOnlineSettings.KEY_GOOGLE_CUSTOM_SYS_DIALOG_CONFIG));
                                }
                                return ((GoogleCustomSysDialogSettingsConverter) InstanceCache.obtain(GoogleCustomSysDialogSettingsConverter.class, this.mInstanceCreator)).create();
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public PermissionEventSettingsModel getPermissionEventSettingsModel() {
                                Storage storage = this.mStorage;
                                if (storage != null && storage.contains("permission_event_settings_model")) {
                                    return ((PermissionEventSettingsConverter) InstanceCache.obtain(PermissionEventSettingsConverter.class, this.mInstanceCreator)).mo236to(this.mStorage.getString("permission_event_settings_model"));
                                }
                                return ((PermissionEventSettingsConverter) InstanceCache.obtain(PermissionEventSettingsConverter.class, this.mInstanceCreator)).create();
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public boolean enableHonorBusinessNotificationDialog() {
                                Storage storage = this.mStorage;
                                if (storage == null || !storage.contains("enable_honor_business_notification_dialog")) {
                                    return false;
                                }
                                return this.mStorage.getBoolean("enable_honor_business_notification_dialog");
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public boolean enableHmsBusinessNotificationDialog() {
                                Storage storage = this.mStorage;
                                if (storage == null || !storage.contains("enable_hms_business_notification_dialog")) {
                                    return true;
                                }
                                return this.mStorage.getBoolean("enable_hms_business_notification_dialog");
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public boolean enableVvBusinessNotificationDialog() {
                                Storage storage = this.mStorage;
                                if (storage == null || !storage.contains("enable_vv_business_notification_dialog")) {
                                    return true;
                                }
                                return this.mStorage.getBoolean("enable_vv_business_notification_dialog");
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public long minHmsBusinessNotificationDialogInterval() {
                                Storage storage = this.mStorage;
                                if (storage == null || !storage.contains("min_hms_business_notification_dialog_interval")) {
                                    return 172800000L;
                                }
                                return this.mStorage.getLong("min_hms_business_notification_dialog_interval");
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public void setAllowSettingsNotifyEnable(boolean z) {
                                Storage storage = this.mStorage;
                                if (storage != null) {
                                    SharedPreferences.Editor edit = storage.edit();
                                    edit.putBoolean("allow_settings_notify_enable", z);
                                    edit.apply();
                                }
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public void setRequestSenderInterval(long j) {
                                Storage storage = this.mStorage;
                                if (storage != null) {
                                    SharedPreferences.Editor edit = storage.edit();
                                    edit.putLong("ttpush_update_sender_interval", j);
                                    edit.apply();
                                }
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public void setUpdateTokenIntervalInSecond(long j) {
                                Storage storage = this.mStorage;
                                if (storage != null) {
                                    SharedPreferences.Editor edit = storage.edit();
                                    edit.putLong("ttpush_update_token_interval", j);
                                    edit.apply();
                                }
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public void setIsShutPushOnStopService(boolean z) {
                                Storage storage = this.mStorage;
                                if (storage != null) {
                                    SharedPreferences.Editor edit = storage.edit();
                                    edit.putBoolean("ttpush_shut_push_on_stop_service", z);
                                    edit.apply();
                                }
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public void setReceiverMessageWakeupScreen(boolean z) {
                                Storage storage = this.mStorage;
                                if (storage != null) {
                                    SharedPreferences.Editor edit = storage.edit();
                                    edit.putBoolean("is_receiver_message_wakeup_screen", z);
                                    edit.apply();
                                }
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public void setReceiverMessageWakeupScreenTime(int i) {
                                Storage storage = this.mStorage;
                                if (storage != null) {
                                    SharedPreferences.Editor edit = storage.edit();
                                    edit.putInt("receiver_message_wakeup_screen_time", i);
                                    edit.apply();
                                }
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public void setUpdateFrontierSettingIntervalTimeInMinute(long j) {
                                Storage storage = this.mStorage;
                                if (storage != null) {
                                    SharedPreferences.Editor edit = storage.edit();
                                    edit.putLong(PushOnlineSettings.KEY_UPDATE_FRONTIER_SETTING_INTERVAL, j);
                                    edit.apply();
                                }
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public void setRedbadgeAutoDismiss(boolean z) {
                                Storage storage = this.mStorage;
                                if (storage != null) {
                                    SharedPreferences.Editor edit = storage.edit();
                                    edit.putBoolean(PushOnlineSettings.KEY_ENABLE_REDBADGE_AUTO_DISMISS, z);
                                    edit.apply();
                                }
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public void setUploadHwDeviceInfoIntervalTimeInMinute(long j) {
                                Storage storage = this.mStorage;
                                if (storage != null) {
                                    SharedPreferences.Editor edit = storage.edit();
                                    edit.putLong(PushOnlineSettings.KEY_UPLOAD_HW_INFO_INTERVAL, j);
                                    edit.apply();
                                }
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public void setEnableHwAnalytics(boolean z) {
                                Storage storage = this.mStorage;
                                if (storage != null) {
                                    SharedPreferences.Editor edit = storage.edit();
                                    edit.putBoolean(PushOnlineSettings.KEY_ENABLE_HW_ANALYTICS, z);
                                    edit.apply();
                                }
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public void setPullApiStrategy(int i) {
                                Storage storage = this.mStorage;
                                if (storage != null) {
                                    SharedPreferences.Editor edit = storage.edit();
                                    edit.putInt(PushOnlineSettings.KEY_PULL_API_STRATEGY, i);
                                    edit.apply();
                                }
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public void setRedBadgeStrategy(String str) {
                                Storage storage = this.mStorage;
                                if (storage != null) {
                                    SharedPreferences.Editor edit = storage.edit();
                                    edit.putString("pull_redbadge_strategy", str);
                                    edit.apply();
                                }
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public void enableReportClientFeature(boolean z) {
                                Storage storage = this.mStorage;
                                if (storage != null) {
                                    SharedPreferences.Editor edit = storage.edit();
                                    edit.putBoolean("enable_report_client_feature", z);
                                    edit.apply();
                                }
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public void setAssociationStartSettings(AssociationStartSettingsModel associationStartSettingsModel) {
                                Storage storage = this.mStorage;
                                if (storage != null) {
                                    SharedPreferences.Editor edit = storage.edit();
                                    edit.putString("association_start_settings", ((AssociationStartSettingsConverter) InstanceCache.obtain(AssociationStartSettingsConverter.class, this.mInstanceCreator)).from(associationStartSettingsModel));
                                    edit.apply();
                                }
                            }

                            @Override // com.bytedance.push.settings.PushOnlineSettings
                            public void setNotificationSettings(NotificationSettings notificationSettings) {
                                Storage storage = this.mStorage;
                                if (storage != null) {
                                    SharedPreferences.Editor edit = storage.edit();
                                    edit.putString("notification_settings", ((NotificationSettingsConverter) InstanceCache.obtain(NotificationSettingsConverter.class, this.mInstanceCreator)).from(notificationSettings));
                                    edit.apply();
                                }
                            }

                            @Override // com.bytedance.push.settings.ISettings
                            public void updateSettings(Context context, JSONObject jSONObject) {
                                Storage storage;
                                if (jSONObject == null || (storage = this.mStorage) == null) {
                                    return;
                                }
                                SharedPreferences.Editor edit = storage.edit();
                                if (jSONObject != null) {
                                    if (jSONObject.has("ttpush_allow_settings_notify_enable")) {
                                        edit.putBoolean("allow_settings_notify_enable", JsonUtil.optBoolean(jSONObject, "ttpush_allow_settings_notify_enable"));
                                    }
                                    if (jSONObject.has("ttpush_update_sender_interval")) {
                                        edit.putLong("ttpush_update_sender_interval", jSONObject.optLong("ttpush_update_sender_interval"));
                                    }
                                    if (jSONObject.has("ttpush_update_token_interval")) {
                                        edit.putLong("ttpush_update_token_interval", jSONObject.optLong("ttpush_update_token_interval"));
                                    }
                                    if (jSONObject.has("ttpush_enable_restrict_update_token")) {
                                        edit.putBoolean("ttpush_enable_restrict_update_token", JsonUtil.optBoolean(jSONObject, "ttpush_enable_restrict_update_token"));
                                    }
                                    if (jSONObject.has("ttpush_shut_push_on_stop_service")) {
                                        edit.putBoolean("ttpush_shut_push_on_stop_service", JsonUtil.optBoolean(jSONObject, "ttpush_shut_push_on_stop_service"));
                                    }
                                    if (jSONObject.has("ttpush_is_receiver_message_wakeup_screen")) {
                                        edit.putBoolean("is_receiver_message_wakeup_screen", JsonUtil.optBoolean(jSONObject, "ttpush_is_receiver_message_wakeup_screen"));
                                    }
                                    if (jSONObject.has("ttpush_receiver_message_wakeup_screen_time")) {
                                        edit.putInt("receiver_message_wakeup_screen_time", jSONObject.optInt("ttpush_receiver_message_wakeup_screen_time"));
                                    }
                                    if (jSONObject.has("ttpush_upload_switch_interval")) {
                                        edit.putLong("ttpush_upload_switch_interval", jSONObject.optLong("ttpush_upload_switch_interval"));
                                    }
                                    if (jSONObject.has("ttpush_forbid_alias")) {
                                        edit.putInt("ttpush_forbid_alias", jSONObject.optInt("ttpush_forbid_alias"));
                                    }
                                    if (jSONObject.has("need_control_miui_flares_v2")) {
                                        edit.putBoolean("need_control_miui_flares_v2", JsonUtil.optBoolean(jSONObject, "need_control_miui_flares_v2"));
                                    }
                                    if (jSONObject.has(PushOnlineSettings.KEY_REMOVE_AUTO_BOOT)) {
                                        edit.putBoolean(PushOnlineSettings.KEY_REMOVE_AUTO_BOOT, JsonUtil.optBoolean(jSONObject, PushOnlineSettings.KEY_REMOVE_AUTO_BOOT));
                                    }
                                    if (jSONObject.has("remove_umeng_autoboot")) {
                                        edit.putBoolean("remove_umeng_autoboot", JsonUtil.optBoolean(jSONObject, "remove_umeng_autoboot"));
                                    }
                                    if (jSONObject.has("check_sign_v2")) {
                                        edit.putInt("check_sign_v2", jSONObject.optInt("check_sign_v2"));
                                    }
                                    if (jSONObject.has("pass_though_new_activity")) {
                                        edit.putBoolean("pass_though_new_activity", JsonUtil.optBoolean(jSONObject, "pass_though_new_activity"));
                                    }
                                    if (jSONObject.has(PushOnlineSettings.KEY_UPDATE_FRONTIER_SETTING_INTERVAL)) {
                                        edit.putLong(PushOnlineSettings.KEY_UPDATE_FRONTIER_SETTING_INTERVAL, jSONObject.optLong(PushOnlineSettings.KEY_UPDATE_FRONTIER_SETTING_INTERVAL));
                                    }
                                    if (jSONObject.has(PushOnlineSettings.KEY_WAKEUP_SUPPORT_STRATEGY)) {
                                        edit.putInt(PushOnlineSettings.KEY_WAKEUP_SUPPORT_STRATEGY, jSONObject.optInt(PushOnlineSettings.KEY_WAKEUP_SUPPORT_STRATEGY));
                                    }
                                    if (jSONObject.has(PushOnlineSettings.KEY_ENABLE_PASS_THROUGH_REDBADGE_SHOW)) {
                                        edit.putBoolean(PushOnlineSettings.KEY_ENABLE_PASS_THROUGH_REDBADGE_SHOW, JsonUtil.optBoolean(jSONObject, PushOnlineSettings.KEY_ENABLE_PASS_THROUGH_REDBADGE_SHOW));
                                    }
                                    if (jSONObject.has(PushOnlineSettings.KEY_ENABLE_REDBADGE_AUTO_DISMISS)) {
                                        edit.putBoolean(PushOnlineSettings.KEY_ENABLE_REDBADGE_AUTO_DISMISS, JsonUtil.optBoolean(jSONObject, PushOnlineSettings.KEY_ENABLE_REDBADGE_AUTO_DISMISS));
                                    }
                                    if (jSONObject.has(PushOnlineSettings.KEY_UPLOAD_HW_INFO_INTERVAL)) {
                                        edit.putLong(PushOnlineSettings.KEY_UPLOAD_HW_INFO_INTERVAL, jSONObject.optLong(PushOnlineSettings.KEY_UPLOAD_HW_INFO_INTERVAL));
                                    }
                                    if (jSONObject.has(PushOnlineSettings.KEY_ENABLE_HW_ANALYTICS)) {
                                        edit.putBoolean(PushOnlineSettings.KEY_ENABLE_HW_ANALYTICS, JsonUtil.optBoolean(jSONObject, PushOnlineSettings.KEY_ENABLE_HW_ANALYTICS));
                                    }
                                    if (jSONObject.has("enable_start_push_process")) {
                                        edit.putBoolean("enable_start_push_process", JsonUtil.optBoolean(jSONObject, "enable_start_push_process"));
                                    }
                                    if (jSONObject.has(PushOnlineSettings.KEY_PULL_API_STRATEGY)) {
                                        edit.putInt(PushOnlineSettings.KEY_PULL_API_STRATEGY, jSONObject.optInt(PushOnlineSettings.KEY_PULL_API_STRATEGY));
                                    }
                                    if (jSONObject.has("pull_redbadge_strategy")) {
                                        edit.putString("pull_redbadge_strategy", jSONObject.optString("pull_redbadge_strategy"));
                                    }
                                    if (jSONObject.has("ttpush_request_settings_interval")) {
                                        edit.putLong("ttpush_request_settings_interval", jSONObject.optLong("ttpush_request_settings_interval"));
                                    }
                                    if (jSONObject.has("enable_monitor_association_start")) {
                                        edit.putBoolean("enable_monitor_association_start", JsonUtil.optBoolean(jSONObject, "enable_monitor_association_start"));
                                    }
                                    if (jSONObject.has("enable_report_client_feature")) {
                                        edit.putBoolean("enable_report_client_feature", JsonUtil.optBoolean(jSONObject, "enable_report_client_feature"));
                                    }
                                    if (jSONObject.has("notification_small_icon_style")) {
                                        edit.putInt("notification_small_icon_style", jSONObject.optInt("notification_small_icon_style"));
                                    }
                                    if (jSONObject.has("push_statistics_settings")) {
                                        edit.putString("push_statistics_settings", jSONObject.optString("push_statistics_settings"));
                                    }
                                    if (jSONObject.has("client_intelligence_settings")) {
                                        edit.putString("client_intelligence_settings", jSONObject.optString("client_intelligence_settings"));
                                    }
                                    if (jSONObject.has("un_duplicate_message_settings")) {
                                        edit.putString("un_duplicate_message_settings", jSONObject.optString("un_duplicate_message_settings"));
                                    }
                                    if (jSONObject.has("association_start_settings")) {
                                        edit.putString("association_start_settings", jSONObject.optString("association_start_settings"));
                                    }
                                    if (jSONObject.has("not_allow_alive_when_no_main_process_list")) {
                                        edit.putString("not_allow_alive_when_no_main_process_list", jSONObject.optString("not_allow_alive_when_no_main_process_list"));
                                    }
                                    if (jSONObject.has("need_kill_all_if_main_process_died")) {
                                        edit.putBoolean("need_kill_all_if_main_process_died", JsonUtil.optBoolean(jSONObject, "need_kill_all_if_main_process_died"));
                                    }
                                    if (jSONObject.has("enable_process_stats")) {
                                        edit.putBoolean("enable_process_stats", JsonUtil.optBoolean(jSONObject, "enable_process_stats"));
                                    }
                                    if (jSONObject.has("delay_start_child_process_settings")) {
                                        edit.putString("delay_start_child_process_settings", jSONObject.optString("delay_start_child_process_settings"));
                                    }
                                    if (jSONObject.has("enable_report_umeng_channel")) {
                                        edit.putBoolean("enable_report_umeng_channel", JsonUtil.optBoolean(jSONObject, "enable_report_umeng_channel"));
                                    }
                                    if (jSONObject.has("auto_start_push_delay_in_mill")) {
                                        edit.putLong("auto_start_push_delay_in_mill", jSONObject.optLong("auto_start_push_delay_in_mill"));
                                    }
                                    if (jSONObject.has("ab_tag")) {
                                        edit.putString("ab_tag", jSONObject.optString("ab_tag"));
                                    }
                                    if (jSONObject.has("enable_monitor_channel_create")) {
                                        edit.putBoolean("enable_monitor_channel_create", JsonUtil.optBoolean(jSONObject, "enable_monitor_channel_create"));
                                    }
                                    if (jSONObject.has("enable_cached_android_id")) {
                                        edit.putBoolean("enable_cached_android_id", JsonUtil.optBoolean(jSONObject, "enable_cached_android_id"));
                                    }
                                    if (jSONObject.has("notification_sound_mode")) {
                                        edit.putInt("notification_sound_mode", jSONObject.optInt("notification_sound_mode"));
                                    }
                                    if (jSONObject.has("enable_default_configuration")) {
                                        edit.putBoolean("enable_default_configuration", JsonUtil.optBoolean(jSONObject, "enable_default_configuration"));
                                    }
                                    if (jSONObject.has("use_op_home_badge_v2")) {
                                        edit.putBoolean("use_op_home_badge_v2", JsonUtil.optBoolean(jSONObject, "use_op_home_badge_v2"));
                                    }
                                    if (jSONObject.has("allow_cache_msg_to_db")) {
                                        edit.putBoolean("allow_cache_msg_to_db", JsonUtil.optBoolean(jSONObject, "allow_cache_msg_to_db"));
                                    }
                                    if (jSONObject.has("allow_spread_out_message")) {
                                        edit.putBoolean("allow_spread_out_message", JsonUtil.optBoolean(jSONObject, "allow_spread_out_message"));
                                    }
                                    if (jSONObject.has("notification_show_monitor_settings")) {
                                        edit.putString("notification_show_monitor_settings", jSONObject.optString("notification_show_monitor_settings"));
                                    }
                                    if (jSONObject.has("message_black_time_window")) {
                                        edit.putString("message_black_time_window", jSONObject.optString("message_black_time_window"));
                                    }
                                    if (jSONObject.has("push_monitor_settings")) {
                                        edit.putString("push_monitor_settings", jSONObject.optString("push_monitor_settings"));
                                    }
                                    if (jSONObject.has("use_hw_manifest_appid")) {
                                        edit.putBoolean("use_hw_manifest_appid", JsonUtil.optBoolean(jSONObject, "use_hw_manifest_appid"));
                                    }
                                    if (jSONObject.has("msg_call_back_settings")) {
                                        edit.putString("msg_call_back_settings", jSONObject.optString("msg_call_back_settings"));
                                    }
                                    if (jSONObject.has("allow_force_send_token")) {
                                        edit.putBoolean("allow_force_send_token", JsonUtil.optBoolean(jSONObject, "allow_force_send_token"));
                                    }
                                    if (jSONObject.has("notification_settings")) {
                                        edit.putString("notification_settings", jSONObject.optString("notification_settings"));
                                    }
                                    if (jSONObject.has("pull_config")) {
                                        edit.putString("pull_config", jSONObject.optString("pull_config"));
                                    }
                                    if (jSONObject.has("permission_boot_settings")) {
                                        edit.putString("permission_boot_settings", jSONObject.optString("permission_boot_settings"));
                                    }
                                    if (jSONObject.has("permission_boot_channel_clear_config")) {
                                        edit.putString("permission_boot_channel_clear_config", jSONObject.optString("permission_boot_channel_clear_config"));
                                    }
                                    if (jSONObject.has(PushOnlineSettings.KEY_OPT_SENSITIVE_API_INVOKE)) {
                                        edit.putBoolean(PushOnlineSettings.KEY_OPT_SENSITIVE_API_INVOKE, JsonUtil.optBoolean(jSONObject, PushOnlineSettings.KEY_OPT_SENSITIVE_API_INVOKE));
                                    }
                                    if (jSONObject.has("allow_profile_id")) {
                                        edit.putBoolean("allow_profile_id", JsonUtil.optBoolean(jSONObject, "allow_profile_id"));
                                    }
                                    if (jSONObject.has(PushOnlineSettings.KEY_SIGNAL_REPORT_SETTINGS)) {
                                        edit.putString(PushOnlineSettings.KEY_SIGNAL_REPORT_SETTINGS, jSONObject.optString(PushOnlineSettings.KEY_SIGNAL_REPORT_SETTINGS));
                                    }
                                    if (jSONObject.has("enable_backup_token_refresh")) {
                                        edit.putBoolean("enable_backup_token_refresh", JsonUtil.optBoolean(jSONObject, "enable_backup_token_refresh"));
                                    }
                                    if (jSONObject.has("depths_i18n_config")) {
                                        edit.putString("depths_i18n_config", jSONObject.optString("depths_i18n_config"));
                                    }
                                    if (jSONObject.has("enable_gif_permission_page")) {
                                        edit.putBoolean("enable_gif_permission_page", JsonUtil.optBoolean(jSONObject, "enable_gif_permission_page"));
                                    }
                                    if (jSONObject.has("polling_notification_report")) {
                                        edit.putString("polling_notification_report", jSONObject.optString("polling_notification_report"));
                                    }
                                    if (jSONObject.has(PushOnlineSettings.KEY_GIF_SYS_PERMISSION_PAGE_SETTINGS)) {
                                        edit.putString(PushOnlineSettings.KEY_GIF_SYS_PERMISSION_PAGE_SETTINGS, jSONObject.optString(PushOnlineSettings.KEY_GIF_SYS_PERMISSION_PAGE_SETTINGS));
                                    }
                                    if (jSONObject.has("opt_push_click_session_id")) {
                                        edit.putString("opt_push_click_session_id", jSONObject.optString("opt_push_click_session_id"));
                                    }
                                    if (jSONObject.has("clear_notification_config")) {
                                        edit.putString("clear_notification_config", jSONObject.optString("clear_notification_config"));
                                    }
                                    if (jSONObject.has("custom_sys_dialog_config_v2")) {
                                        edit.putString("custom_sys_dialog_config_v2", jSONObject.optString("custom_sys_dialog_config_v2"));
                                    }
                                    if (jSONObject.has("notification_params_config")) {
                                        edit.putString("notification_params_config", jSONObject.optString("notification_params_config"));
                                    }
                                    if (jSONObject.has("token_retry_config")) {
                                        edit.putString("token_retry_config", jSONObject.optString("token_retry_config"));
                                    }
                                    if (jSONObject.has("kill_smp_after_vv_push")) {
                                        edit.putBoolean("kill_smp_after_vv_push", JsonUtil.optBoolean(jSONObject, "kill_smp_after_vv_push"));
                                    }
                                    if (jSONObject.has(PushOnlineSettings.KEY_GOOGLE_CUSTOM_SYS_DIALOG_CONFIG)) {
                                        edit.putString(PushOnlineSettings.KEY_GOOGLE_CUSTOM_SYS_DIALOG_CONFIG, jSONObject.optString(PushOnlineSettings.KEY_GOOGLE_CUSTOM_SYS_DIALOG_CONFIG));
                                    }
                                    if (jSONObject.has("permission_event_settings_model")) {
                                        edit.putString("permission_event_settings_model", jSONObject.optString("permission_event_settings_model"));
                                    }
                                    if (jSONObject.has("enable_honor_business_notification_dialog")) {
                                        edit.putBoolean("enable_honor_business_notification_dialog", JsonUtil.optBoolean(jSONObject, "enable_honor_business_notification_dialog"));
                                    }
                                    if (jSONObject.has("enable_hms_business_notification_dialog")) {
                                        edit.putBoolean("enable_hms_business_notification_dialog", JsonUtil.optBoolean(jSONObject, "enable_hms_business_notification_dialog"));
                                    }
                                    if (jSONObject.has("enable_vv_business_notification_dialog")) {
                                        edit.putBoolean("enable_vv_business_notification_dialog", JsonUtil.optBoolean(jSONObject, "enable_vv_business_notification_dialog"));
                                    }
                                    if (jSONObject.has("min_hms_business_notification_dialog_interval")) {
                                        edit.putLong("min_hms_business_notification_dialog_interval", jSONObject.optLong("min_hms_business_notification_dialog_interval"));
                                    }
                                }
                                edit.apply();
                            }

                            @Override // com.bytedance.push.settings.ISettings
                            public void registerValChanged(Context context, String str, String str2, IDataChangedListener iDataChangedListener) {
                                Storage storage = this.mStorage;
                                if (storage != null) {
                                    storage.registerValChanged(context, str, str2, iDataChangedListener);
                                }
                            }

                            @Override // com.bytedance.push.settings.ISettings
                            public void unregisterValChanged(IDataChangedListener iDataChangedListener) {
                                Storage storage = this.mStorage;
                                if (storage != null) {
                                    storage.unregisterValChanged(iDataChangedListener);
                                }
                            }
                        }.getPushMonitorSettings();
                    } else {
                        this.mPushMonitorSettingsModel = ((PushOnlineSettings) SettingsManager.obtain(this.mContext, PushOnlineSettings.class)).getPushMonitorSettings();
                    }
                }
            }
        }
    }

    public void initOnApplication(Context context) {
        startSdkMonitor(context);
    }

    public boolean curIsDau() {
        Boolean bool = this.mCurIsDau;
        return bool != null && bool.booleanValue();
    }

    public boolean curIsTransmit() {
        Boolean bool = this.mCurIsTransmit;
        return bool != null && bool.booleanValue();
    }

    private void startSdkMonitor(Context context) {
        ProcessStartMonitor.getInstance().startMonitor();
        if (ToolUtils.isMainProcess(context)) {
            if (!AppStatusObserverForChildProcess.sIsInBackGround()) {
                onDauEvent();
            } else {
                AppStatusObserverForChildProcess.getIns().addObserver(this);
            }
        }
    }

    private void onDauEvent() {
        if (this.mHasReportDauEvent.getAndSet(true)) {
            Logger.m268d("PushSdkMonitorServiceImpl", "has reported dau,do nothing");
        } else {
            this.mCurIsDau = true;
            PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.bytedance.push.monitor.PushSdkMonitorServiceImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    PushSdkMonitorServiceImpl.this.initPushMonitorSettingsModel();
                    if (PushSdkMonitorServiceImpl.this.mPushMonitorSettingsModel.enableDauMonitor) {
                        PushSdkMonitorServiceImpl.this.monitorEvent("push_monitor_dau", null, null, null);
                    } else {
                        Logger.m268d("PushSdkMonitorServiceImpl", "enableDauMonitor is false,not monitor dau");
                    }
                }
            });
        }
    }

    public void onBadgeOperateSuccess(int i, Integer num) {
        onBadgeShowResult(i, num, true, "success");
    }

    public void onBadgeOperateFailed(int i, Integer num, String str) {
        onBadgeShowResult(i, num, false, str);
    }

    public void onRequestSuccess(String str, String str2, String str3, long j) {
        onRequestResult(str, str2, true, "success", str3, j, null);
    }

    public void onRequestFailed(String str, String str2, String str3, String str4, long j) {
        onRequestResult(str, str2, false, str3, str4, j, null);
    }

    public void onRequestSuccess(String str, String str2, String str3, long j, JSONObject jSONObject) {
        onRequestResult(str, str2, true, "success", str3, j, jSONObject);
    }

    public void onRequestFailed(String str, String str2, String str3, String str4, long j, JSONObject jSONObject) {
        onRequestResult(str, str2, false, str3, str4, j, jSONObject);
    }

    public void onMessageArrive(long j) {
        initPushMonitorSettingsModel();
        if (!this.mPushMonitorSettingsModel.enableMessageShowMonitor) {
            Logger.m268d("PushSdkMonitorServiceImpl", "enableMessageShowMonitor is false,not monitor message [arrive] and message show");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        add(jSONObject, NotificationDeleteBroadcastReceiver.KEY_MSG_ID, j);
        add(jSONObject, "process", ToolUtils.getCurProcessNameSuffix(AppProvider.getApp()));
        monitorEvent("push_monitor_message_arrive", jSONObject, null, null);
    }

    public void onMessageShow(long j, long j2) {
        initPushMonitorSettingsModel();
        if (!this.mPushMonitorSettingsModel.enableMessageShowMonitor) {
            Logger.m268d("PushSdkMonitorServiceImpl", "enableMessageShowMonitor is false,not monitor message arrive and message [show]");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        add(jSONObject, NotificationDeleteBroadcastReceiver.KEY_MSG_ID, j);
        add(jSONObject, "process", ToolUtils.getCurProcessNameSuffix(AppProvider.getApp()));
        JSONObject jSONObject2 = new JSONObject();
        add(jSONObject2, "show_time_cost", System.currentTimeMillis() - j2);
        monitorEvent("push_monitor_message_show", jSONObject, jSONObject2, null);
    }

    public void onLaunchEvent(boolean z, boolean z2, long j, long j2, int i, int i2, String str) {
        PushCommonConfiguration pushCommonConfiguration;
        IPushCommonConfiguration iPushCommonConfiguration;
        if (!ToolUtils.isMainProcess(AppProvider.getApp())) {
            Logger.m278w("PushSdkMonitorServiceImpl", "[onLaunchEvent]do nothing because cur is not main process");
            return;
        }
        IPushConfigurationService pushConfigurationService = PushCommonSupport.getInstance().getPushConfigurationService();
        boolean z3 = false;
        if (pushConfigurationService != null && (pushCommonConfiguration = pushConfigurationService.getPushCommonConfiguration()) != null && (iPushCommonConfiguration = pushCommonConfiguration.mIPushCommonConfiguration) != null) {
            Logger.m268d("PushSdkMonitorServiceImpl", String.format("onLaunchEvent,enableMonitorNotificationClick from host is %s", Boolean.valueOf(iPushCommonConfiguration.enableMonitorNotificationClick())));
            z3 = iPushCommonConfiguration.enableMonitorNotificationClick();
        }
        Logger.m268d("PushSdkMonitorServiceImpl", "[onLaunchEvent]enableMonitorNotificationClick from host:" + z3);
        if (!z3) {
            initPushMonitorSettingsModel();
            z3 = this.mPushMonitorSettingsModel.enablePushLaunchMonitor;
            Logger.m268d("PushSdkMonitorServiceImpl", "[onLaunchEvent]enableMonitorNotificationClick from sdk settings:" + z3);
        }
        if (!z3) {
            Logger.m278w("PushSdkMonitorServiceImpl", "[onLaunchEvent]enableMonitorNotificationClick is false,do nothing");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("detect_timeout", z);
            jSONObject.put("success_to_foreground", z2);
            JSONObject jSONObject2 = new JSONObject();
            if (!z) {
                if (z2) {
                    jSONObject2.put("process_launch_to_foreground_time_cost", j);
                    jSONObject2.put("component_launch_to_foreground_time_cost", j2);
                }
                jSONObject2.put("badge_num_when_app_launch", i);
                jSONObject.put("start_type", i2);
                jSONObject.put("component", str);
            }
            monitorEvent("push_monitor_app_launch", jSONObject, jSONObject2, null);
        } catch (Throwable th) {
            Logger.m272e("PushSdkMonitorServiceImpl", "error when report launch event ", th);
        }
    }

    public void onKeepAliveFrom(String str, String str2, int i) {
        this.mCurIsTransmit = true;
        initPushMonitorSettingsModel();
        if (!this.mPushMonitorSettingsModel.enableKeepAliveFromMonitor) {
            Logger.m268d("PushSdkMonitorServiceImpl", "enableKeepAliveFromMonitor is false,not monitor keep_alive result");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        Application app = AppProvider.getApp();
        add(jSONObject, "partner", str);
        add(jSONObject, "method", str2);
        add(jSONObject, "api_strategy", i);
        add(jSONObject, "process", ToolUtils.getCurProcessNameSuffix(app));
        monitorEvent("push_monitor_transmit_keep_alive_from", jSONObject, null, null);
    }

    public void onContentRequest(String str, int i, int i2) {
        initPushMonitorSettingsModel();
        if (!this.mPushMonitorSettingsModel.enableContentRequestMonitor) {
            Logger.m268d("PushSdkMonitorServiceImpl", "enableContentRequestMonitor is false,not monitor content request result");
            return;
        }
        str.hashCode();
        if (str.equals("post_compose")) {
            if ((i & 256) == 256 || (i & 1) == 1) {
                onContentRequestInternal(str, "badge", i, i2);
            }
            if ((i & 4096) == 4096 || (i & 16) == 16) {
                onContentRequestInternal(str, "local_push", i, i2);
                return;
            }
            return;
        }
        if (str.equals("get_compose")) {
            if ((i & 256) != 256) {
                onContentRequestInternal(str, "badge", i, i2);
            }
            if ((i & 4096) != 4096) {
                onContentRequestInternal(str, "local_push", i, i2);
            }
        }
    }

    public void onContentRequestInternal(String str, String str2, int i, int i2) {
        JSONObject jSONObject = new JSONObject();
        Application app = AppProvider.getApp();
        add(jSONObject, "req_path", str);
        add(jSONObject, "content_type", str2);
        add(jSONObject, "api_strategy", i);
        add(jSONObject, "scene_id", i2);
        add(jSONObject, "process", ToolUtils.getCurProcessNameSuffix(app));
        if (TextUtils.equals("post_compose", str)) {
            if (!curIsDau()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(ActiveSourceMethod.SUB_METHOD_NAME_DAU);
                this.mCurIsDau = Boolean.valueOf(Boolean.parseBoolean(CrossProcessHelper.getInstance().callMethod(ProcessEnum.MAIN, ActiveSourceMethod.METHOD_NAME_ACTIVE_SOURCE_METHOD, arrayList)));
            }
            if (!curIsTransmit()) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(ActiveSourceMethod.SUB_METHOD_NAME_TRANSMIT);
                this.mCurIsTransmit = Boolean.valueOf(Boolean.parseBoolean(CrossProcessHelper.getInstance().callMethod(ProcessEnum.MAIN, ActiveSourceMethod.METHOD_NAME_ACTIVE_SOURCE_METHOD, arrayList2)));
            }
            Boolean bool = this.mCurIsDau;
            add(jSONObject, "cur_is_dau", bool == null ? "unknown" : String.valueOf(bool));
            Boolean bool2 = this.mCurIsTransmit;
            add(jSONObject, "cur_is_transmit", bool2 != null ? String.valueOf(bool2) : "unknown");
        }
        monitorEvent("push_monitor_content_request", jSONObject, null, null);
    }

    public void onContentShow(String str, String str2, int i) {
        initPushMonitorSettingsModel();
        if (!this.mPushMonitorSettingsModel.enableContentShowMonitor) {
            Logger.m268d("PushSdkMonitorServiceImpl", "enableContentShowMonitor is false,not monitor network request result");
            return;
        }
        int pullApiStrategy = ((PushOnlineSettings) SettingsManager.obtain(AppProvider.getApp(), PushOnlineSettings.class)).getPullApiStrategy();
        str.hashCode();
        if (str.equals("post_compose")) {
            if (TextUtils.equals(str2, "badge")) {
                if ((pullApiStrategy & 256) == 256) {
                    onContentShowInternal(str, "badge", pullApiStrategy, i);
                    return;
                }
                return;
            } else {
                if (TextUtils.equals(str2, "local_push") && (pullApiStrategy & 4096) == 4096) {
                    onContentShowInternal(str, "local_push", pullApiStrategy, i);
                    return;
                }
                return;
            }
        }
        if (str.equals("get_compose")) {
            if (TextUtils.equals(str2, "badge")) {
                if ((pullApiStrategy & 256) != 256) {
                    onContentShowInternal(str, "badge", pullApiStrategy, i);
                }
            } else {
                if (!TextUtils.equals(str2, "local_push") || (pullApiStrategy & 4096) == 4096) {
                    return;
                }
                onContentShowInternal(str, "local_push", pullApiStrategy, i);
            }
        }
    }

    public void onTransmitStrategyRequest() {
        initPushMonitorSettingsModel();
        if (!this.mPushMonitorSettingsModel.enableNetworkRequestMonitor) {
            Logger.m268d("PushSdkMonitorServiceImpl", "enableNetworkRequestMonitor is false,not monitor network request result");
            return;
        }
        if (!curIsDau()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(ActiveSourceMethod.SUB_METHOD_NAME_DAU);
            this.mCurIsDau = Boolean.valueOf(Boolean.parseBoolean(CrossProcessHelper.getInstance().callMethod(ProcessEnum.MAIN, ActiveSourceMethod.METHOD_NAME_ACTIVE_SOURCE_METHOD, arrayList)));
        }
        if (!curIsTransmit()) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(ActiveSourceMethod.SUB_METHOD_NAME_TRANSMIT);
            this.mCurIsTransmit = Boolean.valueOf(Boolean.parseBoolean(CrossProcessHelper.getInstance().callMethod(ProcessEnum.MAIN, ActiveSourceMethod.METHOD_NAME_ACTIVE_SOURCE_METHOD, arrayList2)));
        }
        JSONObject jSONObject = new JSONObject();
        Application app = AppProvider.getApp();
        Boolean bool = this.mCurIsDau;
        add(jSONObject, "cur_is_dau", bool == null ? "unknown" : String.valueOf(bool));
        Boolean bool2 = this.mCurIsTransmit;
        add(jSONObject, "cur_is_transmit", bool2 != null ? String.valueOf(bool2) : "unknown");
        add(jSONObject, "process", ToolUtils.getCurProcessNameSuffix(app));
        monitorEvent("push_monitor_transmit_strategy_request", jSONObject, null, null);
    }

    public void onProfileIdOperateResult(int i, int i2, int i3, long j, String str) {
        JSONObject jSONObject = new JSONObject();
        add(jSONObject, "operate_type", i);
        add(jSONObject, "push_type", i2);
        add(jSONObject, "result_code", i3);
        add(jSONObject, "extra_str", str);
        JSONObject jSONObject2 = new JSONObject();
        add(jSONObject2, "time_cost", j);
        monitorEvent("push_monitor_profile_id_operate_result", jSONObject, jSONObject2, null);
    }

    public void onActivityStartReturnValue(String str, JSONObject jSONObject, int i) {
        JSONObject jSONObject2 = new JSONObject();
        add(jSONObject2, "target_pkg", str);
        add(jSONObject2, "target_activity", jSONObject);
        add(jSONObject2, "return_value", i);
        monitorEvent("push_monitor_activity_start_return_value", jSONObject2, null, null);
    }

    public void onActivityDepthsDeviceStatus(JSONObject jSONObject) {
        monitorEvent("push_monitor_activity_depths_device_status", jSONObject, null, null);
    }

    public void onActivityStartResult(boolean z, int i, String str, String str2, String str3, long j, String str4) {
        JSONObject jSONObject = new JSONObject();
        add(jSONObject, ReportConst.KEY_EVENT_TYPE, "all_activity_start_event");
        add(jSONObject, "result", z);
        add(jSONObject, "result_code", i);
        add(jSONObject, "target_pkg", str);
        add(jSONObject, "result_msg", str2);
        add(jSONObject, "target_activity", str3);
        if (TextUtils.isEmpty(str4)) {
            str4 = "null";
        }
        add(jSONObject, "cur_top_app", str4);
        JSONObject jSONObject2 = new JSONObject();
        add(jSONObject2, "life_cycle_time_cost", j);
        monitorEvent("push_monitor_activity_start_result", jSONObject, jSONObject2, null);
    }

    public void onInvalidMrDepths(Context context, List<String> list) {
        JSONObject jSONObject = new JSONObject();
        add(jSONObject, "preferred_features", String.valueOf(list));
        add(jSONObject, "process", ToolUtils.getCurProcessNameSuffix(context));
        monitorEvent("push_monitor_invalid_mr_depths", jSONObject, null, null);
    }

    public void onTokenRetry(int i, String str) {
        JSONObject jSONObject = new JSONObject();
        add(jSONObject, "push_type", i);
        add(jSONObject, "retry_reason", str);
        add(jSONObject, "is_new_user", PushSupporter.get().getConfiguration().mIsNewUser);
        monitorEvent("bdpush_retry_token_register", jSONObject, null, null);
    }

    public void onTokenRetryResult(int i, boolean z, String str) {
        Logger.m268d("PushSdkMonitorServiceImpl", "[onTokenRetryResult]pushType:" + i + " result:" + z + " retryReason:" + str);
        JSONObject jSONObject = new JSONObject();
        add(jSONObject, "push_type", i);
        add(jSONObject, "result", z);
        add(jSONObject, "retry_reason", str);
        add(jSONObject, "is_new_user", PushSupporter.get().getConfiguration().mIsNewUser);
        monitorEvent("bdpush_retry_token_register_result", jSONObject, null, null);
    }

    public void onProcessStartEvent(boolean z, boolean z2, long j, long j2, int i, int i2, String str, boolean z3) {
        initPushMonitorSettingsModel();
        if (this.mPushMonitorSettingsModel == null || this.mPushMonitorSettingsModel.depthsProcessStartMonitorModel == null || !this.mPushMonitorSettingsModel.depthsProcessStartMonitorModel.enableProcessStartMonitor) {
            Logger.m278w("PushSdkMonitorServiceImpl", "[onProcessStartEvent]do nothing because settings config is invalid");
            return;
        }
        DepthsProcessStartMonitorModel depthsProcessStartMonitorModel = this.mPushMonitorSettingsModel.depthsProcessStartMonitorModel;
        if (z2 && !depthsProcessStartMonitorModel.enableMonitorForegroundProcess) {
            Logger.m278w("PushSdkMonitorServiceImpl", "[onProcessStartEvent]do nothing because cur is foreground process start but enableMonitorForegroundProcess is false");
            return;
        }
        if (!z3 && !depthsProcessStartMonitorModel.enableMonitorAllProcess) {
            Logger.m278w("PushSdkMonitorServiceImpl", "[onProcessStartEvent]do nothing because cur is not first process and enableMonitorAllProcess is false");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("detect_timeout", z);
            jSONObject.put("process", ToolUtils.getCurProcessNameSuffix(AppProvider.getApp()));
            jSONObject.put("success_to_foreground", z2);
            JSONObject jSONObject2 = new JSONObject();
            if (!z) {
                if (z2) {
                    jSONObject2.put("process_launch_to_foreground_time_cost", j);
                    jSONObject2.put("component_launch_to_foreground_time_cost", j2);
                }
                jSONObject2.put("badge_num_when_process_launch", i);
                jSONObject2.put("notification_num_when_process_launch", PushServiceManager.get().getIPushNotificationService().getNotificationNum(this.mContext));
                jSONObject.put("start_type", i2);
                jSONObject.put("component", str);
            }
            jSONObject.put("is_first_process", z3);
            monitorEvent("push_monitor_process_launch", jSONObject, jSONObject2, null);
        } catch (Throwable th) {
            Logger.m272e("PushSdkMonitorServiceImpl", "error when report launch event ", th);
        }
    }

    public void onContentShowInternal(String str, String str2, int i, int i2) {
        JSONObject jSONObject = new JSONObject();
        Application app = AppProvider.getApp();
        add(jSONObject, "req_path", str);
        add(jSONObject, "content_type", str2);
        add(jSONObject, "api_strategy", i);
        add(jSONObject, "scene_id", i2);
        add(jSONObject, "process", ToolUtils.getCurProcessNameSuffix(app));
        monitorEvent("push_monitor_content_show", jSONObject, null, null);
    }

    private void onRequestResult(String str, String str2, boolean z, String str3, String str4, long j, JSONObject jSONObject) {
        initPushMonitorSettingsModel();
        if (!this.mPushMonitorSettingsModel.enableNetworkRequestMonitor) {
            Logger.m268d("PushSdkMonitorServiceImpl", "enableNetworkRequestMonitor is false,not monitor network request result");
            return;
        }
        String parsePathFromUrl = NetworkUtils.parsePathFromUrl(str);
        long currentTimeMillis = System.currentTimeMillis() - j;
        JSONObject jSONObject2 = new JSONObject();
        add(jSONObject2, "path", parsePathFromUrl);
        add(jSONObject2, "method", str2);
        add(jSONObject2, "result", z);
        add(jSONObject2, "msg", str3);
        add(jSONObject2, "network_client_class_name", str4);
        add(jSONObject2, "process", ToolUtils.getCurProcessNameSuffix(this.mContext));
        add(jSONObject2, "in_foreground", !AppStatusObserverForChildProcess.sIsInBackGround());
        if (jSONObject != null) {
            add(jSONObject2, jSONObject);
        }
        JSONObject jSONObject3 = new JSONObject();
        add(jSONObject3, "time_cost", currentTimeMillis);
        monitorEvent("push_monitor_network_request_result", jSONObject2, jSONObject3, null);
    }

    private void onBadgeShowResult(int i, Integer num, boolean z, String str) {
        int i2;
        initPushMonitorSettingsModel();
        if (!this.mPushMonitorSettingsModel.enableBadgeApplyMonitor) {
            Logger.m268d("PushSdkMonitorServiceImpl", "enableBadgeApplyMonitor is false,not monitor badge show result");
            return;
        }
        Logger.m268d("PushSdkMonitorServiceImpl", String.format("on badge show result,badgeNumber is %s,result is %s, msg is %s", num, Boolean.valueOf(z), str));
        JSONObject jSONObject = new JSONObject();
        add(jSONObject, "operateType", i);
        add(jSONObject, "result", z);
        if (i == 1 && this.mPushMonitorSettingsModel.enableRealBadgeNumSetResultMonitor) {
            try {
                i2 = PushServiceManager.get().getIRedBadgeExternalService().getCurRedBadgeNumber(this.mContext);
            } catch (RuntimeException e) {
                Logger.m272e("PushSdkMonitorServiceImpl", "error when  getCurRedBadgeNumber", e);
                i2 = -1;
            }
            add(jSONObject, "real_result", i2 == -1 || num.intValue() == i2);
        }
        if (num != null) {
            add(jSONObject, "badge_number", num.intValue());
        }
        add(jSONObject, "msg", str);
        add(jSONObject, "process", ToolUtils.getCurProcessNameSuffix(this.mContext));
        add(jSONObject, "in_foreground", !AppStatusObserverForChildProcess.sIsInBackGround());
        monitorEvent("push_monitor_red_badge_operate_result", jSONObject, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void monitorEvent(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        if (Logger.debug()) {
            JSONObject jSONObject4 = new JSONObject();
            try {
                jSONObject4.put("service_name", str);
                Object obj = "null";
                jSONObject4.put("category", jSONObject == null ? "null" : jSONObject);
                jSONObject4.put("metric", jSONObject2 == null ? "null" : jSONObject2);
                if (jSONObject3 != null) {
                    obj = jSONObject3;
                }
                jSONObject4.put("extra", obj);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Logger.m268d("PushSdkMonitorServiceImpl", String.format("[reportEvent]%s", jSONObject4));
        } else {
            Logger.m268d("PushSdkMonitorServiceImpl", String.format("[reportEvent] eventName:%s,category:%s,metric:%s,extra:%s", str, jSONObject, jSONObject2, jSONObject3));
        }
        PushMultiProcessMonitor.getInstance().monitorEvent(str, jSONObject, jSONObject2, jSONObject3);
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if (((Boolean) obj).booleanValue()) {
            return;
        }
        onDauEvent();
        AppStatusObserverForChildProcess.getIns().deleteObserver(this);
    }
}
