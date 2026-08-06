package com.bytedance.push.settings;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.push.settings.assosiation.start.ComponentProcessInfo;
import com.bytedance.push.settings.assosiation.start.ComponentProcessInfoConverter;
import com.bytedance.push.settings.common.NotificationChannelListConverter;
import com.bytedance.push.settings.notification.NotificationChannelSerializable;
import com.bytedance.push.settings.permission.boot.SysDialogShowHistoryConverter;
import com.bytedance.push.settings.permission.boot.SysDialogShowHistoryModel;
import com.bytedance.push.settings.signal.sync.SignalReportHistory;
import com.bytedance.push.settings.signal.sync.SignalReportHistoryConverter;
import com.bytedance.push.settings.statistics.DeviceDurationLevelConverter;
import com.bytedance.push.settings.statistics.DeviceDurationLevelModel;
import com.bytedance.push.settings.storage.Storage;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class LocalSettings$$SettingImpl implements LocalSettings {
    private Context mContext;
    private final InstanceCreator mInstanceCreator = new InstanceCreator() { // from class: com.bytedance.push.settings.LocalSettings$$SettingImpl.1
        @Override // com.bytedance.push.settings.InstanceCreator
        public <T> T create(Class<T> cls) {
            if (cls == NotificationChannelListConverter.class) {
                return (T) new NotificationChannelListConverter();
            }
            if (cls == ComponentProcessInfoConverter.class) {
                return (T) new ComponentProcessInfoConverter();
            }
            if (cls == SignalReportHistoryConverter.class) {
                return (T) new SignalReportHistoryConverter();
            }
            if (cls == DeviceDurationLevelConverter.class) {
                return (T) new DeviceDurationLevelConverter();
            }
            if (cls == DeviceDurationLevelConverter.class) {
                return (T) new DeviceDurationLevelConverter();
            }
            if (cls == NotificationChannelListConverter.class) {
                return (T) new NotificationChannelListConverter();
            }
            if (cls == SysDialogShowHistoryConverter.class) {
                return (T) new SysDialogShowHistoryConverter();
            }
            return null;
        }
    };
    private Storage mStorage;

    public LocalSettings$$SettingImpl(Context context, Storage storage) {
        this.mContext = context;
        this.mStorage = storage;
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public boolean isAllowNetwork() {
        Storage storage = this.mStorage;
        if (storage == null || !storage.contains("allow_network")) {
            return true;
        }
        return this.mStorage.getBoolean("allow_network");
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public void setAllowNetwork(boolean z) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putBoolean("allow_network", z);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public String getPushDaemonMonitor() {
        Storage storage = this.mStorage;
        return (storage == null || !storage.contains("push_daemon_monitor")) ? "" : this.mStorage.getString("push_daemon_monitor");
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public void setPushDaemonMonitor(String str) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putString("push_daemon_monitor", str);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public String getPushDaemonMonitorResult() {
        Storage storage = this.mStorage;
        return (storage == null || !storage.contains("push_daemon_monitor_result")) ? "" : this.mStorage.getString("push_daemon_monitor_result");
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public void setPushDaemonMonitorResult(String str) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putString("push_daemon_monitor_result", str);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public String getPushChannelsJsonArray() {
        Storage storage = this.mStorage;
        return (storage == null || !storage.contains("push_channels_json_array")) ? "" : this.mStorage.getString("push_channels_json_array");
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public void setPushChannelsJsonArray(String str) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putString("push_channels_json_array", str);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public int getAliPushType() {
        Storage storage = this.mStorage;
        if (storage == null || !storage.contains("ali_push_type")) {
            return -1;
        }
        return this.mStorage.getInt("ali_push_type");
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public void setAliPushType(int i) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putInt("ali_push_type", i);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public boolean isPushNotifyEnable() {
        Storage storage = this.mStorage;
        if (storage == null || !storage.contains("push_notify_enable")) {
            return true;
        }
        return this.mStorage.getBoolean("push_notify_enable");
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public void setPushNotifyEnable(boolean z) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putBoolean("push_notify_enable", z);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public long getLastPullRedBadgeTime() {
        Storage storage = this.mStorage;
        if (storage == null || !storage.contains("last_pull_red_badge_time")) {
            return 0L;
        }
        return this.mStorage.getLong("last_pull_red_badge_time");
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public void setLastPullRedBadgeTime(long j) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putLong("last_pull_red_badge_time", j);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public long getPullRedBadgeRequestIntervalInSecond() {
        Storage storage = this.mStorage;
        return (storage == null || !storage.contains("pull_red_badge_request_interval_in_second")) ? LocalSettings.DEFAULT_PULL_REQUEST_INTERVAL_IN_SECOND : this.mStorage.getLong("pull_red_badge_request_interval_in_second");
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public void setPullRedBadgeRequestIntervalInSecond(long j) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putLong("pull_red_badge_request_interval_in_second", j);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public long getLastPullLocalPushTime() {
        Storage storage = this.mStorage;
        if (storage == null || !storage.contains("last_pull_local_push_time")) {
            return 0L;
        }
        return this.mStorage.getLong("last_pull_local_push_time");
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public void setLastPullLocalPushTime(long j) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putLong("last_pull_local_push_time", j);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public long getPullLocalPushRequestIntervalInSecond() {
        Storage storage = this.mStorage;
        return (storage == null || !storage.contains("pull_local_push_request_interval_in_second")) ? LocalSettings.DEFAULT_PULL_REQUEST_INTERVAL_IN_SECOND : this.mStorage.getLong("pull_local_push_request_interval_in_second");
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public void setPullLocalPushRequestIntervalInSecond(long j) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putLong("pull_local_push_request_interval_in_second", j);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public String getRedBadgeBody() {
        Storage storage = this.mStorage;
        return (storage == null || !storage.contains("red_badge_body_from_pull")) ? "" : this.mStorage.getString("red_badge_body_from_pull");
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public void setRedBadgeBody(String str) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putString("red_badge_body_from_pull", str);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public String getRedBadgeTimeParams() {
        Storage storage = this.mStorage;
        return (storage == null || !storage.contains("red_badge_time_params")) ? "" : this.mStorage.getString("red_badge_time_params");
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public void setRedBadgeTimeParams(String str) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putString("red_badge_time_params", str);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public String getAbVersion() {
        Storage storage = this.mStorage;
        return (storage == null || !storage.contains("ab_version")) ? "" : this.mStorage.getString("ab_version");
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public void setAbVersion(String str) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putString("ab_version", str);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public int getSceneIdV2() {
        Storage storage = this.mStorage;
        if (storage == null || !storage.contains("scene_id_v2")) {
            return 0;
        }
        return this.mStorage.getInt("scene_id_v2");
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public void setSceneIdV2(int i) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putInt("scene_id_v2", i);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public String getPushStatisticsProcessSet() {
        Storage storage = this.mStorage;
        return (storage == null || !storage.contains("push_statistics_process_set")) ? "[]" : this.mStorage.getString("push_statistics_process_set");
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public void setPushStatisticsProcessSet(String str) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putString("push_statistics_process_set", str);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public boolean hasPoppedNotificationPermissionPopup() {
        Storage storage = this.mStorage;
        if (storage == null || !storage.contains("has_popped_notification_permission_popup")) {
            return false;
        }
        return this.mStorage.getBoolean("has_popped_notification_permission_popup");
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public void setHasPoppedNotificationPermissionPopup(boolean z) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putBoolean("has_popped_notification_permission_popup", z);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public boolean needPopNotificationPermissionPopupAfterForeground() {
        Storage storage = this.mStorage;
        if (storage == null || !storage.contains("need_pop_notification_permission_popup_after_foreground")) {
            return false;
        }
        return this.mStorage.getBoolean("need_pop_notification_permission_popup_after_foreground");
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public void setNeedPopNotificationPermissionPopupAfterForeground(boolean z) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putBoolean("need_pop_notification_permission_popup_after_foreground", z);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public Map<String, NotificationChannelSerializable> getNeedToCreateChannelsAfterAllowPopup() {
        Storage storage = this.mStorage;
        if (storage != null && storage.contains("need_to_create_channels_after_allow_popup")) {
            return ((NotificationChannelListConverter) InstanceCache.obtain(NotificationChannelListConverter.class, this.mInstanceCreator)).mo236to(this.mStorage.getString("need_to_create_channels_after_allow_popup"));
        }
        return ((NotificationChannelListConverter) InstanceCache.obtain(NotificationChannelListConverter.class, this.mInstanceCreator)).create();
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public void setNeedToCreateChannelsAfterAllowPopup(Map<String, NotificationChannelSerializable> map) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putString("need_to_create_channels_after_allow_popup", ((NotificationChannelListConverter) InstanceCache.obtain(NotificationChannelListConverter.class, this.mInstanceCreator)).from(map));
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public String getAndroidId() {
        Storage storage = this.mStorage;
        return (storage == null || !storage.contains("android_id")) ? "" : this.mStorage.getString("android_id");
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public void setAndroidId(String str) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putString("android_id", str);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public boolean hasNotShownRedBadge() {
        Storage storage = this.mStorage;
        if (storage == null || !storage.contains("has_not_shown_red_badge")) {
            return false;
        }
        return this.mStorage.getBoolean("has_not_shown_red_badge");
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public void setHasNotShownRedBadge(boolean z) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putBoolean("has_not_shown_red_badge", z);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public long getLastNotShownRedBadgeTimeStamp() {
        Storage storage = this.mStorage;
        if (storage == null || !storage.contains("last_not_shown_red_badge_time_stamp")) {
            return 0L;
        }
        return this.mStorage.getLong("last_not_shown_red_badge_time_stamp");
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public void setLastNotShownRedBadgeTimeStamp(long j) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putLong("last_not_shown_red_badge_time_stamp", j);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public int monitorNotificationBarSupportLevel() {
        Storage storage = this.mStorage;
        if (storage == null || !storage.contains("monitor_notification_bar_support_level")) {
            return 0;
        }
        return this.mStorage.getInt("monitor_notification_bar_support_level");
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public void setMonitorNotificationBarSupportLevel(int i) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putInt("monitor_notification_bar_support_level", i);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public int monitorUserPresentSupportLevel() {
        Storage storage = this.mStorage;
        if (storage == null || !storage.contains("monitor_user_present_support_level")) {
            return 0;
        }
        return this.mStorage.getInt("monitor_user_present_support_level");
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public void setMonitorUserPresentSupportLevel(int i) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putInt("monitor_user_present_support_level", i);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public long getLastMessageShowTimeStamp() {
        Storage storage = this.mStorage;
        if (storage == null || !storage.contains("last_message_show_time_stamp")) {
            return 0L;
        }
        return this.mStorage.getLong("last_message_show_time_stamp");
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public void setLastMessageShowTimeStamp(long j) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putLong("last_message_show_time_stamp", j);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public String getLastProfileId() {
        Storage storage = this.mStorage;
        return (storage == null || !storage.contains("last_profile_id")) ? "" : this.mStorage.getString("last_profile_id");
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public void setLastProfileId(String str) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putString("last_profile_id", str);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public int getPullApiStrategyOfOnlineSettings() {
        Storage storage = this.mStorage;
        if (storage == null || !storage.contains(LocalSettings.KEY_LOCAL_PULL_API_STRATEGY)) {
            return -1;
        }
        return this.mStorage.getInt(LocalSettings.KEY_LOCAL_PULL_API_STRATEGY);
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public void setPullApiStrategyOfOnlineSettings(int i) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putInt(LocalSettings.KEY_LOCAL_PULL_API_STRATEGY, i);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public String getPullStrategy() {
        Storage storage = this.mStorage;
        return (storage == null || !storage.contains("pull_strategy")) ? "" : this.mStorage.getString("pull_strategy");
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public void setPullStrategy(String str) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putString("pull_strategy", str);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public boolean hasBarrierHwAwarenessSignal() {
        Storage storage = this.mStorage;
        if (storage == null || !storage.contains("has_barrier_hw_awareness_signal")) {
            return false;
        }
        return this.mStorage.getBoolean("has_barrier_hw_awareness_signal");
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public void setHasBarrierHwAwarenessSignal(boolean z) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putBoolean("has_barrier_hw_awareness_signal", z);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public String getLastSecUid() {
        Storage storage = this.mStorage;
        return (storage == null || !storage.contains(LocalSettings.LAST_SEC_UID)) ? LocalSettings.INIT_SEC_UID : this.mStorage.getString(LocalSettings.LAST_SEC_UID);
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public void setLastSecUid(String str) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putString(LocalSettings.LAST_SEC_UID, str);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public ComponentProcessInfo getComponentProcessInfo() {
        Storage storage = this.mStorage;
        if (storage != null && storage.contains(LocalSettings.COMPONENT_PROCESS_INFO)) {
            return ((ComponentProcessInfoConverter) InstanceCache.obtain(ComponentProcessInfoConverter.class, this.mInstanceCreator)).mo236to(this.mStorage.getString(LocalSettings.COMPONENT_PROCESS_INFO));
        }
        return ((ComponentProcessInfoConverter) InstanceCache.obtain(ComponentProcessInfoConverter.class, this.mInstanceCreator)).create();
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public void setComponentProcessInfo(ComponentProcessInfo componentProcessInfo) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putString(LocalSettings.COMPONENT_PROCESS_INFO, ((ComponentProcessInfoConverter) InstanceCache.obtain(ComponentProcessInfoConverter.class, this.mInstanceCreator)).from(componentProcessInfo));
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public boolean getLastLaunchAccountStatus() {
        Storage storage = this.mStorage;
        if (storage == null || !storage.contains("last_account_status")) {
            return false;
        }
        return this.mStorage.getBoolean("last_account_status");
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public void setLastLaunchAccountStatus(boolean z) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putBoolean("last_account_status", z);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public SignalReportHistory getSignalReportHistory() {
        Storage storage = this.mStorage;
        if (storage != null && storage.contains(LocalSettings.SIGNAL_REPORT_HISTORY)) {
            return ((SignalReportHistoryConverter) InstanceCache.obtain(SignalReportHistoryConverter.class, this.mInstanceCreator)).mo236to(this.mStorage.getString(LocalSettings.SIGNAL_REPORT_HISTORY));
        }
        return ((SignalReportHistoryConverter) InstanceCache.obtain(SignalReportHistoryConverter.class, this.mInstanceCreator)).create();
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public void setSignalReportHistory(SignalReportHistory signalReportHistory) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putString(LocalSettings.SIGNAL_REPORT_HISTORY, ((SignalReportHistoryConverter) InstanceCache.obtain(SignalReportHistoryConverter.class, this.mInstanceCreator)).from(signalReportHistory));
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public long getLastUnlockAwarenessTime() {
        Storage storage = this.mStorage;
        if (storage == null || !storage.contains("last_unlock_awareness_time")) {
            return 0L;
        }
        return this.mStorage.getLong("last_unlock_awareness_time");
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public void setLastUnlockAwarenessTime(long j) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putLong("last_unlock_awareness_time", j);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public boolean serverDisableAwBarrier() {
        Storage storage = this.mStorage;
        if (storage == null || !storage.contains(LocalSettings.SERVER_DISABLE_AW_BARRIER)) {
            return false;
        }
        return this.mStorage.getBoolean(LocalSettings.SERVER_DISABLE_AW_BARRIER);
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public void setServerDisableAwBarrier(boolean z) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putBoolean(LocalSettings.SERVER_DISABLE_AW_BARRIER, z);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public boolean lastEnableGifPermissionPage() {
        Storage storage = this.mStorage;
        if (storage == null || !storage.contains("last_enable_gif_permission_page")) {
            return false;
        }
        return this.mStorage.getBoolean("last_enable_gif_permission_page");
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public void setLastEnableGifPermissionPage(boolean z) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putBoolean("last_enable_gif_permission_page", z);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public DeviceDurationLevelModel getMainDeviceDurationLevelModel() {
        Storage storage = this.mStorage;
        if (storage != null && storage.contains("main_device_duration_level")) {
            return ((DeviceDurationLevelConverter) InstanceCache.obtain(DeviceDurationLevelConverter.class, this.mInstanceCreator)).mo236to(this.mStorage.getString("main_device_duration_level"));
        }
        return ((DeviceDurationLevelConverter) InstanceCache.obtain(DeviceDurationLevelConverter.class, this.mInstanceCreator)).create();
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public void setMainDeviceDurationLevelModel(DeviceDurationLevelModel deviceDurationLevelModel) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putString("main_device_duration_level", ((DeviceDurationLevelConverter) InstanceCache.obtain(DeviceDurationLevelConverter.class, this.mInstanceCreator)).from(deviceDurationLevelModel));
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public DeviceDurationLevelModel getSmpDeviceDurationLevelModel() {
        Storage storage = this.mStorage;
        if (storage != null && storage.contains("smp_device_duration_level")) {
            return ((DeviceDurationLevelConverter) InstanceCache.obtain(DeviceDurationLevelConverter.class, this.mInstanceCreator)).mo236to(this.mStorage.getString("smp_device_duration_level"));
        }
        return ((DeviceDurationLevelConverter) InstanceCache.obtain(DeviceDurationLevelConverter.class, this.mInstanceCreator)).create();
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public void setSmpDeviceDurationLevelModel(DeviceDurationLevelModel deviceDurationLevelModel) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putString("smp_device_duration_level", ((DeviceDurationLevelConverter) InstanceCache.obtain(DeviceDurationLevelConverter.class, this.mInstanceCreator)).from(deviceDurationLevelModel));
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public long getLastHmsNotificationDialogTime() {
        Storage storage = this.mStorage;
        if (storage == null || !storage.contains("last_hms_notification_dialog_time")) {
            return 0L;
        }
        return this.mStorage.getLong("last_hms_notification_dialog_time");
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public void setLastHmsNotificationDialogTime(long j) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putLong("last_hms_notification_dialog_time", j);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public long getLastCustomDialogTime() {
        Storage storage = this.mStorage;
        if (storage == null || !storage.contains("last_custom_dialog_time")) {
            return 0L;
        }
        return this.mStorage.getLong("last_custom_dialog_time");
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public void setLastCustomDialogTime(long j) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putLong("last_custom_dialog_time", j);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public long getLastHwDialogShowTime() {
        Storage storage = this.mStorage;
        if (storage == null || !storage.contains("last_hw_dialog_show_time")) {
            return 0L;
        }
        return this.mStorage.getLong("last_hw_dialog_show_time");
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public void setLastHwDialogShowTime(long j) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putLong("last_hw_dialog_show_time", j);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public String getLastLaunchAccountType() {
        Storage storage = this.mStorage;
        return (storage == null || !storage.contains("last_account_type")) ? "" : this.mStorage.getString("last_account_type");
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public void setLastLaunchAccountType(String str) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putString("last_account_type", str);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public long getLastToastDialogTime() {
        Storage storage = this.mStorage;
        if (storage == null || !storage.contains("last_toast_dialog_time")) {
            return 0L;
        }
        return this.mStorage.getLong("last_toast_dialog_time");
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public void setLastToastDialogTime(long j) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putLong("last_toast_dialog_time", j);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public String getGooglePermissionRequestRecord() {
        Storage storage = this.mStorage;
        return (storage == null || !storage.contains("google_permission_request_record")) ? "" : this.mStorage.getString("google_permission_request_record");
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public void updateGooglePermissionRequestRecord(String str) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putString("google_permission_request_record", str);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public boolean isGooglePermissionEnable() {
        Storage storage = this.mStorage;
        if (storage == null || !storage.contains("google_permission_request_enable")) {
            return true;
        }
        return this.mStorage.getBoolean("google_permission_request_enable");
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public void setGooglePermissionEnable(boolean z) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putBoolean("google_permission_request_enable", z);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public String hasSysDialogShowFailed() {
        Storage storage = this.mStorage;
        return (storage == null || !storage.contains("has_sys_dialog_show_failed")) ? "" : this.mStorage.getString("has_sys_dialog_show_failed");
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public void setHasSysDialogShowFailed(String str) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putString("has_sys_dialog_show_failed", str);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public Map<String, NotificationChannelSerializable> getCachedNotificationChannels() {
        Storage storage = this.mStorage;
        if (storage != null && storage.contains("cached_notification_channels")) {
            return ((NotificationChannelListConverter) InstanceCache.obtain(NotificationChannelListConverter.class, this.mInstanceCreator)).mo236to(this.mStorage.getString("cached_notification_channels"));
        }
        return ((NotificationChannelListConverter) InstanceCache.obtain(NotificationChannelListConverter.class, this.mInstanceCreator)).create();
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public void setCachedNotificationChannels(Map<String, NotificationChannelSerializable> map) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putString("cached_notification_channels", ((NotificationChannelListConverter) InstanceCache.obtain(NotificationChannelListConverter.class, this.mInstanceCreator)).from(map));
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public int defaultNotificationStatus() {
        Storage storage = this.mStorage;
        if (storage == null || !storage.contains("default_notification_status")) {
            return -1;
        }
        return this.mStorage.getInt("default_notification_status");
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public void updateDefaultNotificationStatus(int i) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putInt("default_notification_status", i);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public String defaultNotificationPermissionRationale() {
        Storage storage = this.mStorage;
        return (storage == null || !storage.contains("default_notification_permission_rationale")) ? "" : this.mStorage.getString("default_notification_permission_rationale");
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public void updateDefaultNotificationPermissionRationale(String str) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putString("default_notification_permission_rationale", str);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public SysDialogShowHistoryModel getSysDialogShowHistory() {
        Storage storage = this.mStorage;
        if (storage != null && storage.contains("sys_dialog_show_history")) {
            return ((SysDialogShowHistoryConverter) InstanceCache.obtain(SysDialogShowHistoryConverter.class, this.mInstanceCreator)).mo236to(this.mStorage.getString("sys_dialog_show_history"));
        }
        return ((SysDialogShowHistoryConverter) InstanceCache.obtain(SysDialogShowHistoryConverter.class, this.mInstanceCreator)).create();
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public void updateSysDialogShowHistory(SysDialogShowHistoryModel sysDialogShowHistoryModel) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putString("sys_dialog_show_history", ((SysDialogShowHistoryConverter) InstanceCache.obtain(SysDialogShowHistoryConverter.class, this.mInstanceCreator)).from(sysDialogShowHistoryModel));
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public boolean getDisableBusinessCustomDialog() {
        Storage storage = this.mStorage;
        if (storage == null || !storage.contains("disable_business_custom_dialog")) {
            return false;
        }
        return this.mStorage.getBoolean("disable_business_custom_dialog");
    }

    @Override // com.bytedance.push.settings.LocalSettings
    public void setDisableBusinessCustomDialog(boolean z) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putBoolean("disable_business_custom_dialog", z);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.ILocalSettings
    public void registerValChanged(Context context, String str, String str2, IDataChangedListener iDataChangedListener) {
        Storage storage = this.mStorage;
        if (storage != null) {
            storage.registerValChanged(context, str, str2, iDataChangedListener);
        }
    }

    @Override // com.bytedance.push.settings.ILocalSettings
    public void unregisterValChanged(IDataChangedListener iDataChangedListener) {
        Storage storage = this.mStorage;
        if (storage != null) {
            storage.unregisterValChanged(iDataChangedListener);
        }
    }
}
