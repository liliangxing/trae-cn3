package com.bytedance.push.settings;

import com.bytedance.push.settings.annotation.Settings;
import com.bytedance.push.settings.assosiation.start.AssociationStartSettingsModel;
import com.bytedance.push.settings.client.intelligence.ClientIntelligenceSettingsModel;
import com.bytedance.push.settings.delay.start.DelayStartChildProcessSettingsModel;
import com.bytedance.push.settings.depths.DepthsI18nSettingsModel;
import com.bytedance.push.settings.message.unduplicate.UnDuplicateSettingsModel;
import com.bytedance.push.settings.monitor.PushMonitorSettingsModel;
import com.bytedance.push.settings.msg.callback.MsgCallbackSettingsModel;
import com.bytedance.push.settings.notification.ClearNotificationSettingsModel;
import com.bytedance.push.settings.notification.MessageBlackTimeWindowSettingsModel;
import com.bytedance.push.settings.notification.NotificationMonitorSettingsModel;
import com.bytedance.push.settings.notification.NotificationParamsModel;
import com.bytedance.push.settings.notification.NotificationSettings;
import com.bytedance.push.settings.notification.PollingNotificationReport;
import com.bytedance.push.settings.permission.boot.BusinessCustomSysDialogConfig;
import com.bytedance.push.settings.permission.boot.GifSysPermissionPageSettingsModel;
import com.bytedance.push.settings.permission.boot.GoogleCustomSysDialogConfig;
import com.bytedance.push.settings.permission.boot.PermissionBootChannelModel;
import com.bytedance.push.settings.permission.boot.PermissionBootSettingsModel;
import com.bytedance.push.settings.permission.boot.PermissionEventSettingsModel;
import com.bytedance.push.settings.pull.PullSettingsModel;
import com.bytedance.push.settings.push.click.PushClickReportOptSettingsModel;
import com.bytedance.push.settings.signal.sync.SignalReportSettingsModel;
import com.bytedance.push.settings.statistics.StatisticsSettingsModel;
import com.bytedance.push.settings.token.TokenRetrySettingsMode;
import java.util.Arrays;
import java.util.List;

@Settings(storageKey = "push_multi_process_config", supportMultiProcess = true)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface PushOnlineSettings extends ISettings {
    public static final String KEY_ENABLE_HW_ANALYTICS = "enable_hw_analytics";
    public static final String KEY_ENABLE_PASS_THROUGH_REDBADGE_SHOW = "enable_pass_through_redbadge_show";
    public static final String KEY_ENABLE_REDBADGE_AUTO_DISMISS = "enable_redbadge_auto_dismiss";
    public static final String KEY_OPT_SENSITIVE_API_INVOKE = "opt_sensitive_api_invoke";
    public static final String KEY_PULL_API_STRATEGY = "pull_api_strategy";
    public static final String KEY_REMOVE_AUTO_BOOT = "remove_auto_boot_v2";
    public static final String KEY_SIGNAL_REPORT_SETTINGS = "signal_report_settings";
    public static final String KEY_UPDATE_FRONTIER_SETTING_INTERVAL = "frontier_update_setting_interval";
    public static final String KEY_UPLOAD_HW_INFO_INTERVAL = "upload_hw_device_info_interval";
    public static final String KEY_WAKEUP_SUPPORT_STRATEGY = "wakeup_support_strategy";
    public static final String KEY_GIF_SYS_PERMISSION_PAGE_SETTINGS = "gif_sys_permission_page_settings";
    public static final String KEY_GOOGLE_CUSTOM_SYS_DIALOG_CONFIG = "google_custom_sys_dialog_config";
    public static final List<String> SDK_SETTINGS_KEY = Arrays.asList(KEY_GIF_SYS_PERMISSION_PAGE_SETTINGS, KEY_GOOGLE_CUSTOM_SYS_DIALOG_CONFIG);

    boolean allowCacheMessageToDb();

    boolean allowForceSendToken();

    boolean allowProfileId();

    boolean allowSpreadOutMessage();

    long autoStartPushDelayInMill();

    int checkSign();

    boolean enableBackUpTokenRefresh();

    boolean enableCachedAndroidId();

    boolean enableDefaultConfiguration();

    boolean enableGifPermissionPage();

    boolean enableHmsBusinessNotificationDialog();

    boolean enableHonorBusinessNotificationDialog();

    boolean enableHwAnalytics();

    boolean enableMonitorAssociationStart();

    boolean enableMonitorChannelCreate();

    boolean enablePassThroughRedbadgeShow();

    boolean enableProcessStats();

    boolean enableRedbadgeAutoDismiss();

    void enableReportClientFeature(boolean z);

    boolean enableReportClientFeature();

    boolean enableReportUmengChannel();

    boolean enableRestrictUpdateToken();

    boolean enableStartPushProcess();

    boolean enableVvBusinessNotificationDialog();

    int forbidSetAlias();

    String getAbTag();

    AssociationStartSettingsModel getAssociationStartSettings();

    BusinessCustomSysDialogConfig getBusinessCustomSysDialogConfig();

    ClearNotificationSettingsModel getClearNotificationConfig();

    ClientIntelligenceSettingsModel getClientIntelligenceSettings();

    DelayStartChildProcessSettingsModel getDelayStartChildProcessSettings();

    DepthsI18nSettingsModel getDepthsI18nSettingsModel();

    GifSysPermissionPageSettingsModel getGifSysPermissionPageSettingsModel();

    GoogleCustomSysDialogConfig getGoogleCustomSysDialogConfig();

    MessageBlackTimeWindowSettingsModel getMessageBlackTimeWindowSettings();

    MsgCallbackSettingsModel getMsgCallbackSettings();

    String getNotAllowAliveWhenNoMainProcessList();

    NotificationMonitorSettingsModel getNotificationMonitorSettings();

    NotificationParamsModel getNotificationParamsModel();

    NotificationSettings getNotificationSettings();

    int getNotificationSoundMode();

    PermissionEventSettingsModel getPermissionEventSettingsModel();

    PollingNotificationReport getPollingNotificationReport();

    int getPullApiStrategy();

    PullSettingsModel getPullSettings();

    PushClickReportOptSettingsModel getPushClickReportOptSettingsModel();

    PushMonitorSettingsModel getPushMonitorSettings();

    StatisticsSettingsModel getPushStatisticsSettings();

    int getReceiverMessageWakeupScreenTime();

    String getRedBadgeStrategy();

    long getRequestSettingsInterval();

    SignalReportSettingsModel getSignalSyncSettingsModel();

    TokenRetrySettingsMode getTokenRetrySettingsMode();

    UnDuplicateSettingsModel getUnDuplicateMessageSettings();

    long getUpdateFrontierSettingIntervalTimeInMinute();

    long getUpdateSenderIntervalTimeInMs();

    long getUpdateTokenIntervalInSecond();

    long getUploadHwDeviceInfoTimeInMinute();

    long getUploadSwitchInterval();

    int getWakeUpStrategy();

    boolean isAllowSettingsNotifyEnable();

    boolean isReceiverMessageWakeupScreen();

    boolean killPushProcessWhenStopService();

    boolean killSmpAfterVvPush();

    long minHmsBusinessNotificationDialogInterval();

    boolean needControlFlares();

    boolean needKillAllIfMainProcessDied();

    int notificationSmallIconStyle();

    boolean optSensitiveApiInvoke();

    boolean passThoughUseNewActivity();

    PermissionBootChannelModel permissionBootChannelSettings();

    PermissionBootSettingsModel permissionBootSettings();

    boolean removeAllAutoBoot();

    boolean removeUmengAutoBoot();

    void setAllowSettingsNotifyEnable(boolean z);

    void setAssociationStartSettings(AssociationStartSettingsModel associationStartSettingsModel);

    void setEnableHwAnalytics(boolean z);

    void setIsShutPushOnStopService(boolean z);

    void setNotificationSettings(NotificationSettings notificationSettings);

    void setPullApiStrategy(int i);

    void setReceiverMessageWakeupScreen(boolean z);

    void setReceiverMessageWakeupScreenTime(int i);

    void setRedBadgeStrategy(String str);

    void setRedbadgeAutoDismiss(boolean z);

    void setRequestSenderInterval(long j);

    void setUpdateFrontierSettingIntervalTimeInMinute(long j);

    void setUpdateTokenIntervalInSecond(long j);

    void setUploadHwDeviceInfoIntervalTimeInMinute(long j);

    boolean useHwManifestAppId();

    boolean useOpHomeBadgeV2();
}
