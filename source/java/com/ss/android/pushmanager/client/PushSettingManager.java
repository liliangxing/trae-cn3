package com.ss.android.pushmanager.client;

import android.content.Context;
import com.bytedance.common.push.ThreadPlus;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.settings.PushOnlineSettings;
import com.bytedance.push.settings.SettingsManager;
import com.bytedance.push.settings.notification.PollingNotificationReport;
import com.ss.android.message.AppProvider;
import com.ss.android.pushmanager.setting.PushSetting;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class PushSettingManager {
    private static volatile PushSettingManager sPushSettingManager;

    public static PushSettingManager getInstance() {
        if (sPushSettingManager == null) {
            synchronized (PushSettingManager.class) {
                if (sPushSettingManager == null) {
                    sPushSettingManager = new PushSettingManager();
                }
            }
        }
        return sPushSettingManager;
    }

    public boolean isPushNotifyEnable(Context context) {
        return PushSetting.getInstance().isPushNotifyEnable();
    }

    public void notifyPushEnableChange(final Context context, final boolean z) {
        PushSetting.getInstance().setPushNotifyEnable(z);
        if (z) {
            PushSupporter.get().getSenderService().registerAllSender(context);
        } else {
            PushSupporter.get().getSenderService().unRegisterAllThirdPush(context);
        }
        ThreadPlus.submitRunnable(new Runnable() { // from class: com.ss.android.pushmanager.client.PushSettingManager.1
            @Override // java.lang.Runnable
            public void run() {
                PollingNotificationReport pollingNotificationReport = PushSetting.getInstance().getPushOnLineSettings().getPollingNotificationReport();
                try {
                    if (pollingNotificationReport.enableOriginalReporting) {
                        PushSupporter.get().getNotificationService().sendPushEnableToServer(context, z);
                    }
                    if (pollingNotificationReport.enableReportingTiming) {
                        PushSupporter.get().getNotificationService().sendPushEnableToServer(context, z, "innerPushSwitchAction");
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    public void notifyAllowNetwork(Context context, boolean z) {
        PushSetting.getInstance().setIsAllowNetwork(z);
    }

    public void notifyAllowSettingsNotifyEnable(Context context, boolean z) {
        boolean isAllowSettingsNotifyEnable = PushSetting.getInstance().isAllowSettingsNotifyEnable();
        PushSetting.getInstance().setAllowSettingsNotifyEnable(z);
        if (isAllowSettingsNotifyEnable || !z) {
            return;
        }
        PushSupporter.get().getSenderService().registerAllSender(context);
    }

    public void notifyShutPushOnStopService(Context context, boolean z) {
        PushSetting.getInstance().setIsShutPushOnStopService(z);
    }

    public void notifyAllowPushJobService(Context context, boolean z) {
        PushSetting.getInstance().setAllowPushJobService(z);
    }

    public void notifyUninstallQuestionUrl(Context context, String str) {
        PushSetting.getInstance().setUninstallQuestionUrl(str);
    }

    public void notifyAllowPushDaemonMonitor(Context context, boolean z) {
        PushSetting.getInstance().setAllowPushDaemonMonitor(z);
    }

    public void notifyAllowOffAlive(Context context, boolean z) {
        PushSetting.getInstance().setAllowOffAlive(z);
    }

    public void setRequestSenderInterval(Context context, long j) {
        ((PushOnlineSettings) SettingsManager.obtain(context, PushOnlineSettings.class)).setRequestSenderInterval(j * 1000);
    }

    public void setUpdateTokenIntervalInSecond(long j) {
        ((PushOnlineSettings) SettingsManager.obtain(AppProvider.getApp(), PushOnlineSettings.class)).setUpdateTokenIntervalInSecond(j * 1000);
    }
}
