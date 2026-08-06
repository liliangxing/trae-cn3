package com.bytedance.push.settings;

import com.bytedance.push.settings.annotation.Settings;
import com.bytedance.push.settings.assosiation.start.ComponentProcessInfo;
import com.bytedance.push.settings.notification.NotificationChannelSerializable;
import com.bytedance.push.settings.permission.boot.SysDialogShowHistoryModel;
import com.bytedance.push.settings.signal.sync.SignalReportHistory;
import com.bytedance.push.settings.statistics.DeviceDurationLevelModel;
import java.util.Map;

@Settings(storageKey = "push_multi_process_config", supportMultiProcess = true)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface LocalSettings extends ILocalSettings {
    public static final String COMPONENT_PROCESS_INFO = "component_process_info";
    public static final long DEFAULT_PULL_REQUEST_INTERVAL_IN_SECOND = 1800;
    public static final String INIT_SEC_UID = "init_sec_uid";
    public static final int INT_VALUE_INIT = -1;
    public static final String KEY_LOCAL_PULL_API_STRATEGY = "local_pull_api_strategy";
    public static final String LAST_SEC_UID = "last_sec_uid";
    public static final String SERVER_DISABLE_AW_BARRIER = "server_disable_aw_barrier";
    public static final String SIGNAL_REPORT_HISTORY = "signal_report_history";
    public static final int SUPPORT_LEVEL_NOT_SUPPORT = 0;
    public static final int SUPPORT_LEVEL_SUPPORT = 1;

    String defaultNotificationPermissionRationale();

    int defaultNotificationStatus();

    String getAbVersion();

    int getAliPushType();

    String getAndroidId();

    Map<String, NotificationChannelSerializable> getCachedNotificationChannels();

    ComponentProcessInfo getComponentProcessInfo();

    boolean getDisableBusinessCustomDialog();

    String getGooglePermissionRequestRecord();

    long getLastCustomDialogTime();

    long getLastHmsNotificationDialogTime();

    long getLastHwDialogShowTime();

    boolean getLastLaunchAccountStatus();

    String getLastLaunchAccountType();

    long getLastMessageShowTimeStamp();

    long getLastNotShownRedBadgeTimeStamp();

    String getLastProfileId();

    long getLastPullLocalPushTime();

    long getLastPullRedBadgeTime();

    String getLastSecUid();

    long getLastToastDialogTime();

    long getLastUnlockAwarenessTime();

    DeviceDurationLevelModel getMainDeviceDurationLevelModel();

    Map<String, NotificationChannelSerializable> getNeedToCreateChannelsAfterAllowPopup();

    int getPullApiStrategyOfOnlineSettings();

    long getPullLocalPushRequestIntervalInSecond();

    long getPullRedBadgeRequestIntervalInSecond();

    String getPullStrategy();

    String getPushChannelsJsonArray();

    String getPushDaemonMonitor();

    String getPushDaemonMonitorResult();

    String getPushStatisticsProcessSet();

    String getRedBadgeBody();

    String getRedBadgeTimeParams();

    int getSceneIdV2();

    SignalReportHistory getSignalReportHistory();

    DeviceDurationLevelModel getSmpDeviceDurationLevelModel();

    SysDialogShowHistoryModel getSysDialogShowHistory();

    boolean hasBarrierHwAwarenessSignal();

    boolean hasNotShownRedBadge();

    boolean hasPoppedNotificationPermissionPopup();

    String hasSysDialogShowFailed();

    boolean isAllowNetwork();

    boolean isGooglePermissionEnable();

    boolean isPushNotifyEnable();

    boolean lastEnableGifPermissionPage();

    int monitorNotificationBarSupportLevel();

    int monitorUserPresentSupportLevel();

    boolean needPopNotificationPermissionPopupAfterForeground();

    boolean serverDisableAwBarrier();

    void setAbVersion(String str);

    void setAliPushType(int i);

    void setAllowNetwork(boolean z);

    void setAndroidId(String str);

    void setCachedNotificationChannels(Map<String, NotificationChannelSerializable> map);

    void setComponentProcessInfo(ComponentProcessInfo componentProcessInfo);

    void setDisableBusinessCustomDialog(boolean z);

    void setGooglePermissionEnable(boolean z);

    void setHasBarrierHwAwarenessSignal(boolean z);

    void setHasNotShownRedBadge(boolean z);

    void setHasPoppedNotificationPermissionPopup(boolean z);

    void setHasSysDialogShowFailed(String str);

    void setLastCustomDialogTime(long j);

    void setLastEnableGifPermissionPage(boolean z);

    void setLastHmsNotificationDialogTime(long j);

    void setLastHwDialogShowTime(long j);

    void setLastLaunchAccountStatus(boolean z);

    void setLastLaunchAccountType(String str);

    void setLastMessageShowTimeStamp(long j);

    void setLastNotShownRedBadgeTimeStamp(long j);

    void setLastProfileId(String str);

    void setLastPullLocalPushTime(long j);

    void setLastPullRedBadgeTime(long j);

    void setLastSecUid(String str);

    void setLastToastDialogTime(long j);

    void setLastUnlockAwarenessTime(long j);

    void setMainDeviceDurationLevelModel(DeviceDurationLevelModel deviceDurationLevelModel);

    void setMonitorNotificationBarSupportLevel(int i);

    void setMonitorUserPresentSupportLevel(int i);

    void setNeedPopNotificationPermissionPopupAfterForeground(boolean z);

    void setNeedToCreateChannelsAfterAllowPopup(Map<String, NotificationChannelSerializable> map);

    void setPullApiStrategyOfOnlineSettings(int i);

    void setPullLocalPushRequestIntervalInSecond(long j);

    void setPullRedBadgeRequestIntervalInSecond(long j);

    void setPullStrategy(String str);

    void setPushChannelsJsonArray(String str);

    void setPushDaemonMonitor(String str);

    void setPushDaemonMonitorResult(String str);

    void setPushNotifyEnable(boolean z);

    void setPushStatisticsProcessSet(String str);

    void setRedBadgeBody(String str);

    void setRedBadgeTimeParams(String str);

    void setSceneIdV2(int i);

    void setServerDisableAwBarrier(boolean z);

    void setSignalReportHistory(SignalReportHistory signalReportHistory);

    void setSmpDeviceDurationLevelModel(DeviceDurationLevelModel deviceDurationLevelModel);

    void updateDefaultNotificationPermissionRationale(String str);

    void updateDefaultNotificationStatus(int i);

    void updateGooglePermissionRequestRecord(String str);

    void updateSysDialogShowHistory(SysDialogShowHistoryModel sysDialogShowHistoryModel);
}
