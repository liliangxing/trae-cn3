package com.bytedance.push.settings;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.push.settings.storage.Storage;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class AliveOnlineSettings$$SettingImpl implements AliveOnlineSettings {
    private Storage mStorage;
    private final ConcurrentHashMap<String, Object> mStickySettings = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Object> mTransientSettings = new ConcurrentHashMap<>();
    private final InstanceCreator mInstanceCreator = new InstanceCreator() { // from class: com.bytedance.push.settings.AliveOnlineSettings$$SettingImpl.1
        @Override // com.bytedance.push.settings.InstanceCreator
        public <T> T create(Class<T> cls) {
            if (cls == ListStrConverter.class) {
                return (T) new ListStrConverter();
            }
            return null;
        }
    };

    public AliveOnlineSettings$$SettingImpl(Storage storage) {
        this.mStorage = storage;
    }

    @Override // com.bytedance.push.settings.AliveOnlineSettings
    public boolean allowOffALive() {
        Storage storage = this.mStorage;
        if (storage == null || !storage.contains("allow_off_alive")) {
            return true;
        }
        return this.mStorage.getBoolean("allow_off_alive");
    }

    @Override // com.bytedance.push.settings.AliveOnlineSettings
    public String getUninstallQuestionUrl() {
        Storage storage = this.mStorage;
        return (storage == null || !storage.contains("uninstall_question_url")) ? "" : this.mStorage.getString("uninstall_question_url");
    }

    @Override // com.bytedance.push.settings.AliveOnlineSettings
    public boolean isAllowPushJobService() {
        Storage storage = this.mStorage;
        if (storage == null || !storage.contains("allow_push_job_service")) {
            return true;
        }
        return this.mStorage.getBoolean("allow_push_job_service");
    }

    @Override // com.bytedance.push.settings.AliveOnlineSettings
    public boolean isAllowPushDaemonMonitor() {
        Storage storage = this.mStorage;
        if (storage == null || !storage.contains("allow_push_daemon_monitor")) {
            return true;
        }
        return this.mStorage.getBoolean("allow_push_daemon_monitor");
    }

    @Override // com.bytedance.push.settings.AliveOnlineSettings
    public boolean isAllowCloseBootReceiver() {
        Storage storage = this.mStorage;
        if (storage == null || !storage.contains("allow_close_boot_receiver")) {
            return true;
        }
        return this.mStorage.getBoolean("allow_close_boot_receiver");
    }

    @Override // com.bytedance.push.settings.AliveOnlineSettings
    public boolean isCloseAlarmWakeup() {
        Storage storage = this.mStorage;
        if (storage == null || !storage.contains("is_close_alarm_wakeup")) {
            return false;
        }
        return this.mStorage.getBoolean("is_close_alarm_wakeup");
    }

    @Override // com.bytedance.push.settings.AliveOnlineSettings
    public boolean isUseStartForegroundNotification() {
        Storage storage = this.mStorage;
        if (storage == null || !storage.contains("is_use_start_foreground_notification")) {
            return true;
        }
        return this.mStorage.getBoolean("is_use_start_foreground_notification");
    }

    @Override // com.bytedance.push.settings.AliveOnlineSettings
    public int getJobScheduleWakeUpIntervalSecond() {
        Storage storage = this.mStorage;
        if (storage == null || !storage.contains("job_schedule_wake_up_interval_second")) {
            return 3600;
        }
        return this.mStorage.getInt("job_schedule_wake_up_interval_second");
    }

    @Override // com.bytedance.push.settings.AliveOnlineSettings
    public boolean isUseCNativeProcessKeepAlive() {
        Storage storage = this.mStorage;
        if (storage == null || !storage.contains("is_use_c_native_process_keep_alive")) {
            return true;
        }
        return this.mStorage.getBoolean("is_use_c_native_process_keep_alive");
    }

    @Override // com.bytedance.push.settings.AliveOnlineSettings
    public boolean isNotifyServiceStick() {
        Storage storage = this.mStorage;
        if (storage == null || !storage.contains("is_notify_service_stick")) {
            return false;
        }
        return this.mStorage.getBoolean("is_notify_service_stick");
    }

    @Override // com.bytedance.push.settings.AliveOnlineSettings
    public boolean isMiuiCloseDaemon() {
        Storage storage = this.mStorage;
        if (storage == null || !storage.contains("key_is_miui_close_daemon")) {
            return true;
        }
        return this.mStorage.getBoolean("key_is_miui_close_daemon");
    }

    @Override // com.bytedance.push.settings.AliveOnlineSettings
    public List<String> getAllowList() {
        Storage storage = this.mStorage;
        if (storage != null && storage.contains("ttpush_alv_white_list")) {
            return ((ListStrConverter) InstanceCache.obtain(ListStrConverter.class, this.mInstanceCreator)).mo236to(this.mStorage.getString("ttpush_alv_white_list"));
        }
        return ((ListStrConverter) InstanceCache.obtain(ListStrConverter.class, this.mInstanceCreator)).create();
    }

    @Override // com.bytedance.push.settings.AliveOnlineSettings
    public void setAllowOffAlive(boolean z) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putBoolean("allow_off_alive", z);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.AliveOnlineSettings
    public void setUninstallQuestionUrl(String str) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putString("uninstall_question_url", str);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.AliveOnlineSettings
    public void setAllowPushJobService(boolean z) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putBoolean("allow_push_job_service", z);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.AliveOnlineSettings
    public void setAllowPushDaemonMonitor(boolean z) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putBoolean("allow_push_daemon_monitor", z);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.AliveOnlineSettings
    public void setAllowCloseBootReceiver(boolean z) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putBoolean("allow_close_boot_receiver", z);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.AliveOnlineSettings
    public void setCloseAlarmWakeup(boolean z) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putBoolean("is_close_alarm_wakeup", z);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.AliveOnlineSettings
    public void setUseStartForegroundNotification(boolean z) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putBoolean("is_use_start_foreground_notification", z);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.AliveOnlineSettings
    public void setJobScheduleWakeUpIntervalSecond(int i) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putInt("job_schedule_wake_up_interval_second", i);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.AliveOnlineSettings
    public void setIsUseCNativeProcessKeepAlive(boolean z) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putBoolean("is_use_c_native_process_keep_alive", z);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.AliveOnlineSettings
    public void setNotifyServiceStick(boolean z) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putBoolean("is_notify_service_stick", z);
            edit.apply();
        }
    }

    @Override // com.bytedance.push.settings.AliveOnlineSettings
    public void setMiuiCloseDaemon(boolean z) {
        Storage storage = this.mStorage;
        if (storage != null) {
            SharedPreferences.Editor edit = storage.edit();
            edit.putBoolean("key_is_miui_close_daemon", z);
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
            if (jSONObject.has("ttpush_allow_off_alive")) {
                edit.putBoolean("allow_off_alive", JsonUtil.optBoolean(jSONObject, "ttpush_allow_off_alive"));
            }
            if (jSONObject.has("ttpush_uninstall_question_url")) {
                edit.putString("uninstall_question_url", jSONObject.optString("ttpush_uninstall_question_url"));
            }
            if (jSONObject.has(AliveOnlineSettings.SERVER_KEY_JOB_SERVICE)) {
                edit.putBoolean("allow_push_job_service", JsonUtil.optBoolean(jSONObject, AliveOnlineSettings.SERVER_KEY_JOB_SERVICE));
            }
            if (jSONObject.has(AliveOnlineSettings.SERVER_KEY_PUSH_DAEMON)) {
                edit.putBoolean("allow_push_daemon_monitor", JsonUtil.optBoolean(jSONObject, AliveOnlineSettings.SERVER_KEY_PUSH_DAEMON));
            }
            if (jSONObject.has("ttpush_allow_close_boot_receiver")) {
                edit.putBoolean("allow_close_boot_receiver", JsonUtil.optBoolean(jSONObject, "ttpush_allow_close_boot_receiver"));
            }
            if (jSONObject.has(AliveOnlineSettings.SERVER_KEY_ALARM_WAKE_UP)) {
                edit.putBoolean("is_close_alarm_wakeup", JsonUtil.optBoolean(jSONObject, AliveOnlineSettings.SERVER_KEY_ALARM_WAKE_UP));
            }
            if (jSONObject.has("ttpush_use_start_foreground_notification")) {
                edit.putBoolean("is_use_start_foreground_notification", JsonUtil.optBoolean(jSONObject, "ttpush_use_start_foreground_notification"));
            }
            if (jSONObject.has("ttpush_job_schedule_wake_up_interval_second")) {
                edit.putInt("job_schedule_wake_up_interval_second", jSONObject.optInt("ttpush_job_schedule_wake_up_interval_second"));
            }
            if (jSONObject.has("ttpush_is_use_c_native_process_keep_alive")) {
                edit.putBoolean("is_use_c_native_process_keep_alive", JsonUtil.optBoolean(jSONObject, "ttpush_is_use_c_native_process_keep_alive"));
            }
            if (jSONObject.has(AliveOnlineSettings.SERVER_KEY_NOTIFY_STICKY)) {
                edit.putBoolean("is_notify_service_stick", JsonUtil.optBoolean(jSONObject, AliveOnlineSettings.SERVER_KEY_NOTIFY_STICKY));
            }
            if (jSONObject.has("ttpush_key_is_miui_close_daemon")) {
                edit.putBoolean("key_is_miui_close_daemon", JsonUtil.optBoolean(jSONObject, "ttpush_key_is_miui_close_daemon"));
            }
            if (jSONObject.has("ttpush_alv_white_list")) {
                edit.putString("ttpush_alv_white_list", jSONObject.optString("ttpush_alv_white_list"));
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
}
