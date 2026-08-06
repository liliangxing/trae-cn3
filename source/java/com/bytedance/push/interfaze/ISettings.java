package com.bytedance.push.interfaze;

import java.util.Map;

/* loaded from: classes4.dex */
public interface ISettings {
    boolean allowCacheMessageToDb();

    boolean allowProfileId();

    String getLastProfileId();

    Boolean getProviderBoolean(String str, Boolean bool);

    float getProviderFloat(String str, float f);

    int getProviderInt(String str, int i);

    long getProviderLong(String str, long j);

    String getProviderString(String str, String str2);

    String getPushChannelsJsonArray();

    String getPushDaemonMonitor();

    String getPushDaemonMonitorResult();

    String getUninstallQuestionUrl();

    boolean isAllowCloseBootReceiver();

    boolean isAllowNetwork();

    boolean isAllowPushDaemonMonitor();

    boolean isAllowPushJobService();

    boolean isAllowSettingsNotifyEnable();

    boolean isCloseAlarmWakeUp();

    boolean isNotifyServiceStick();

    boolean isPushNotifyEnable();

    boolean isShutPushNotifyEnable();

    boolean isShutPushOnStopService();

    boolean isUseCNativeProcessKeepAlive();

    void saveMapToProvider(Map<String, ?> map);

    void setAllowCloseBootReceiver(boolean z);

    void setAllowOffAlive(boolean z);

    void setAllowPushDaemonMonitor(boolean z);

    void setAllowPushJobService(boolean z);

    void setAllowSettingsNotifyEnable(boolean z);

    void setIsAllowNetwork(boolean z);

    void setIsCloseAlarmWakeup(boolean z);

    void setIsNotifyServiceStick(boolean z);

    void setIsReceiverMessageWakeupScreen(boolean z);

    void setIsShutPushOnStopService(boolean z);

    void setIsUseCNativeProcessKeepAlive(boolean z);

    void setIsUseStartForegroundNotification(boolean z);

    void setJobScheduleWakeUpIntervalSecond(int i);

    void setLastProfileId(String str);

    void setPushChannelsJsonArray(String str);

    void setPushDaemonMonitor(String str);

    void setPushDaemonMonitorResult(String str);

    void setPushNotifyEnable(boolean z);

    void setReceiverMessageWakeupScreenTime(int i);

    void setUninstallQuestionUrl(String str);
}
