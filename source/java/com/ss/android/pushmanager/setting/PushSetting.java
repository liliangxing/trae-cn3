package com.ss.android.pushmanager.setting;

import android.app.Application;
import android.content.Context;
import com.bytedance.android.service.manager.push.settings.ISettingsUpdateListener;
import com.bytedance.push.interfaze.ISettings;
import com.bytedance.push.settings.AliveOnlineSettings;
import com.bytedance.push.settings.LocalSettings;
import com.bytedance.push.settings.PushOnlineSettings;
import com.bytedance.push.settings.SettingsManager;
import com.ss.android.common.util.ToolUtils;
import com.ss.android.message.AnrOptManager;
import com.ss.android.message.AppProvider;
import com.ss.android.pushmanager.setting.PushMultiProcessSharedProvider;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class PushSetting implements ISettings {
    public static final String ALI_PUSH_TYPE = "ali_push_type";
    public static final String ALLOW_NETWORK = "allow_network";
    public static final String ALLOW_PUSH_JOB_SERVICE = "allow_push_job_service";
    public static final String ALLOW_SELF_PUSH_ENABLE = "allow_self_push_enable";
    public static final String NEED_CONTROL_MIUI_FLARES = "need_control_miui_flares_v2";
    public static final String PUSH_NOTIFY_ENABLE = "push_notify_enable";
    public static final String SHUT_PUSH_ON_STOP_SERVICE = "shut_push_on_stop_service";
    public static final String TAG = "PushSetting";
    public static final String UNINSTALL_QUESTION_URL = "uninstall_question_url";
    private static PushSetting sPushSetting;
    private final Set<ISettingsUpdateListener> mISettingsUpdateListenerSet = new HashSet();
    private Boolean allowCacheMessageToDb = null;
    private PushMultiProcessSharedProvider.MultiProcessShared multiProcessShared = PushMultiProcessSharedProvider.getMultiprocessShared(AppProvider.getApp());

    public static void init(Context context) {
        AppProvider.initApp((Application) context.getApplicationContext());
    }

    public static PushSetting getInstance() {
        if (sPushSetting == null) {
            synchronized (PushSetting.class) {
                if (sPushSetting == null) {
                    sPushSetting = new PushSetting();
                }
            }
        }
        return sPushSetting;
    }

    private PushSetting() {
    }

    public void setIsShutPushOnStopService(final boolean z) {
        AnrOptManager.postRunnable(new Runnable() { // from class: com.ss.android.pushmanager.setting.PushSetting.1
            @Override // java.lang.Runnable
            public void run() {
                PushSetting.this.getPushOnLineSettings().setIsShutPushOnStopService(z);
            }
        });
    }

    public boolean isShutPushOnStopService() {
        return getPushOnLineSettings().killPushProcessWhenStopService();
    }

    public void setPushNotifyEnable(boolean z) {
        getLocalSettings().setPushNotifyEnable(z);
    }

    public boolean isPushNotifyEnable() {
        return getLocalSettings().isPushNotifyEnable() && isAllowSettingsNotifyEnable();
    }

    public void setIsAllowNetwork(boolean z) {
        getLocalSettings().setAllowNetwork(z);
    }

    public boolean isAllowNetwork() {
        return getLocalSettings().isAllowNetwork();
    }

    public void setUninstallQuestionUrl(final String str) {
        AnrOptManager.postRunnable(new Runnable() { // from class: com.ss.android.pushmanager.setting.PushSetting.2
            @Override // java.lang.Runnable
            public void run() {
                PushSetting.this.getAliveSettings().setUninstallQuestionUrl(str);
            }
        });
    }

    public String getUninstallQuestionUrl() {
        return getAliveSettings().getUninstallQuestionUrl();
    }

    public void setAllowPushJobService(boolean z) {
        getAliveSettings().setAllowPushJobService(z);
    }

    public boolean isAllowPushJobService() {
        return getAliveSettings().isAllowPushJobService();
    }

    public void setAllowPushDaemonMonitor(boolean z) {
        getAliveSettings().setAllowPushDaemonMonitor(z);
    }

    public boolean isAllowPushDaemonMonitor() {
        if (ToolUtils.isMiui() && getAliveSettings().isMiuiCloseDaemon()) {
            return false;
        }
        return getAliveSettings().isAllowPushDaemonMonitor();
    }

    public void setPushDaemonMonitor(String str) {
        getLocalSettings().setPushDaemonMonitor(str);
    }

    public String getPushDaemonMonitor() {
        return getLocalSettings().getPushDaemonMonitor();
    }

    public void setPushDaemonMonitorResult(String str) {
        getLocalSettings().setPushDaemonMonitorResult(str);
    }

    public String getPushDaemonMonitorResult() {
        return getLocalSettings().getPushDaemonMonitorResult();
    }

    public void setAllowCloseBootReceiver(boolean z) {
        getAliveSettings().setAllowCloseBootReceiver(z);
    }

    public boolean isAllowCloseBootReceiver() {
        return getAliveSettings().isAllowCloseBootReceiver();
    }

    public boolean isShutPushNotifyEnable() {
        return !isPushNotifyEnable() && isShutPushOnStopService();
    }

    public void setIsCloseAlarmWakeup(boolean z) {
        getAliveSettings().setCloseAlarmWakeup(z);
    }

    public boolean isCloseAlarmWakeUp() {
        return getAliveSettings().isCloseAlarmWakeup();
    }

    public void setPushChannelsJsonArray(String str) {
        getLocalSettings().setPushChannelsJsonArray(str);
    }

    public String getPushChannelsJsonArray() {
        return getLocalSettings().getPushChannelsJsonArray();
    }

    public void saveSSIDs(Map<String, String> map) {
        PushCommonSetting.getInstance().saveSSIDs(map);
    }

    public String getSsids() {
        return PushCommonSetting.getInstance().getSsids();
    }

    public void getSSIDs(Map<String, String> map) {
        PushCommonSetting.getInstance().getSSIDs(map);
    }

    public String getDeviceId() {
        return PushCommonSetting.getInstance().getDeviceId();
    }

    public String getAlias() {
        return PushCommonSetting.getInstance().getAlias();
    }

    public void setAllowOffAlive(boolean z) {
        getAliveSettings().setAllowOffAlive(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AliveOnlineSettings getAliveSettings() {
        return (AliveOnlineSettings) SettingsManager.obtain(AppProvider.getApp(), AliveOnlineSettings.class);
    }

    public PushOnlineSettings getPushOnLineSettings() {
        return (PushOnlineSettings) SettingsManager.obtain(AppProvider.getApp(), PushOnlineSettings.class);
    }

    public LocalSettings getLocalSettings() {
        return (LocalSettings) SettingsManager.obtain(AppProvider.getApp(), LocalSettings.class);
    }

    public void setAliPushType(int i) {
        getLocalSettings().setAliPushType(i);
    }

    public int getAliPushType() {
        return getLocalSettings().getAliPushType();
    }

    public void setAllowSettingsNotifyEnable(boolean z) {
        getPushOnLineSettings().setAllowSettingsNotifyEnable(z);
    }

    public boolean isAllowSettingsNotifyEnable() {
        return getPushOnLineSettings().isAllowSettingsNotifyEnable();
    }

    public void setIsReceiverMessageWakeupScreen(boolean z) {
        getPushOnLineSettings().setReceiverMessageWakeupScreen(z);
    }

    public boolean isReceiverMessageWakeupScreen() {
        return getPushOnLineSettings().isReceiverMessageWakeupScreen();
    }

    public void setReceiverMessageWakeupScreenTime(int i) {
        getPushOnLineSettings().setReceiverMessageWakeupScreenTime(i);
    }

    public int getReceiverMessageWakeupScreenTime() {
        return getPushOnLineSettings().getReceiverMessageWakeupScreenTime();
    }

    public void setIsUseStartForegroundNotification(boolean z) {
        getAliveSettings().setUseStartForegroundNotification(z);
    }

    public boolean isUseStartForegroundNotification() {
        return getAliveSettings().isUseStartForegroundNotification();
    }

    public void setJobScheduleWakeUpIntervalSecond(int i) {
        getAliveSettings().setJobScheduleWakeUpIntervalSecond(i);
    }

    public boolean allowCacheMessageToDb() {
        Boolean bool = this.allowCacheMessageToDb;
        if (bool != null) {
            return bool.booleanValue();
        }
        Boolean valueOf = Boolean.valueOf(allowCacheMessageToDbInternal());
        this.allowCacheMessageToDb = valueOf;
        return valueOf.booleanValue();
    }

    public boolean allowProfileId() {
        return getPushOnLineSettings().allowProfileId();
    }

    public String getLastProfileId() {
        return getLocalSettings().getLastProfileId();
    }

    public void setLastProfileId(String str) {
        getLocalSettings().setLastProfileId(str);
    }

    private boolean allowCacheMessageToDbInternal() {
        return getPushOnLineSettings().allowCacheMessageToDb();
    }

    public int getJobScheduleWakeUpIntervalSecond() {
        return getAliveSettings().getJobScheduleWakeUpIntervalSecond();
    }

    public void setIsUseCNativeProcessKeepAlive(boolean z) {
        getAliveSettings().setIsUseCNativeProcessKeepAlive(z);
    }

    public boolean isUseCNativeProcessKeepAlive() {
        return getAliveSettings().isUseCNativeProcessKeepAlive();
    }

    public void setIsNotifyServiceStick(boolean z) {
        getAliveSettings().setNotifyServiceStick(z);
    }

    public boolean isNotifyServiceStick() {
        return getAliveSettings().isNotifyServiceStick();
    }

    @Deprecated
    public void saveMapToProvider(Map<String, ?> map) {
        try {
            PushMultiProcessSharedProvider.Editor edit = this.multiProcessShared.edit();
            if (map != null) {
                for (Map.Entry<String, ?> entry : map.entrySet()) {
                    Object value = entry.getValue();
                    if (value instanceof Integer) {
                        edit.putInt(entry.getKey(), ((Integer) value).intValue());
                    } else if (value instanceof Long) {
                        edit.putLong(entry.getKey(), ((Long) value).longValue());
                    } else if (value instanceof Float) {
                        edit.putFloat(entry.getKey(), ((Float) value).floatValue());
                    } else if (value instanceof Boolean) {
                        edit.putBoolean(entry.getKey(), ((Boolean) value).booleanValue());
                    } else if (value instanceof String) {
                        edit.putString(entry.getKey(), (String) value);
                    }
                }
                edit.commit();
            }
        } catch (Throwable unused) {
        }
    }

    @Deprecated
    public int getProviderInt(String str, int i) {
        return this.multiProcessShared.getInt(str, i);
    }

    @Deprecated
    public long getProviderLong(String str, long j) {
        return this.multiProcessShared.getLong(str, j);
    }

    @Deprecated
    public String getProviderString(String str, String str2) {
        return this.multiProcessShared.getString(str, str2);
    }

    @Deprecated
    public Boolean getProviderBoolean(String str, Boolean bool) {
        return Boolean.valueOf(this.multiProcessShared.getBoolean(str, bool.booleanValue()));
    }

    @Deprecated
    public float getProviderFloat(String str, float f) {
        return this.multiProcessShared.getFloat(str, f);
    }

    public void registerSettingsUpdateListener(ISettingsUpdateListener iSettingsUpdateListener) {
        synchronized (this.mISettingsUpdateListenerSet) {
            this.mISettingsUpdateListenerSet.add(iSettingsUpdateListener);
        }
    }

    public Object[] getSettingsUpdateListenerSet() {
        Object[] array;
        synchronized (this.mISettingsUpdateListenerSet) {
            array = this.mISettingsUpdateListenerSet.toArray();
        }
        return array;
    }

    public void unRegisterSettingsUpdateListener(ISettingsUpdateListener iSettingsUpdateListener) {
        synchronized (this.mISettingsUpdateListenerSet) {
            this.mISettingsUpdateListenerSet.remove(iSettingsUpdateListener);
        }
    }
}
