package com.bytedance.push.notification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.common.push.ThreadPlus;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.push.Configuration;
import com.bytedance.push.interfaze.INotificationService;
import com.bytedance.push.interfaze.ISupport;
import com.bytedance.push.interfaze.OnSwitcherServerListener;
import com.bytedance.push.interfaze.OnSwitcherSyncListener;
import com.bytedance.push.model.PushNotificationChannel;
import com.bytedance.push.model.SwitcherStatus;
import com.bytedance.push.settings.LocalFrequencySettings;
import com.bytedance.push.settings.PushOnlineSettings;
import com.bytedance.push.settings.SettingsManager;
import com.bytedance.push.settings.notification.PollingNotificationReport;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.util.ToolUtils;
import com.ss.android.push.R;
import com.ss.android.pushmanager.setting.PushSetting;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class NotificationServiceImpl implements INotificationService {
    private final ISupport mSupport;

    public NotificationServiceImpl(ISupport iSupport) {
        this.mSupport = iSupport;
    }

    @Override // com.bytedance.push.interfaze.INotificationService
    public void syncNotifySwitchStatus(Context context) {
        syncNotifySwitchStatusOnce(context, "");
    }

    @Override // com.bytedance.push.interfaze.INotificationService
    public void syncNotifySwitchStatusWithReportingTiming(Context context, String str) {
        syncNotifySwitchStatusOnce(context, str);
    }

    public void syncNotifySwitchStatusOnce(final Context context, final String str) {
        ThreadPlus.submitRunnable(new Runnable() { // from class: com.bytedance.push.notification.NotificationServiceImpl.1
            @Override // java.lang.Runnable
            public void run() {
                boolean isPushNotifyEnable = PushSetting.getInstance().isPushNotifyEnable();
                LocalFrequencySettings localFrequencySettings = (LocalFrequencySettings) SettingsManager.obtain(context, LocalFrequencySettings.class);
                PushOnlineSettings pushOnlineSettings = (PushOnlineSettings) SettingsManager.obtain(context, PushOnlineSettings.class);
                long currentTimeMillis = ToolUtils.currentTimeMillis();
                long uploadSwitchTs = localFrequencySettings.getUploadSwitchTs();
                long uploadSwitchInterval = pushOnlineSettings.getUploadSwitchInterval();
                long abs = Math.abs(currentTimeMillis - uploadSwitchTs);
                boolean z = abs > uploadSwitchInterval;
                Logger.m268d("NoticeStateSync", "[syncNotifySwitchStatus] needUploadWithFrequency: " + z + " lastUploadSwitchTs:" + uploadSwitchTs + " currentTimeMillis:" + currentTimeMillis + " uploadSwitchInterval:" + uploadSwitchInterval + " actualInterval:" + abs);
                if (z || !localFrequencySettings.isLastSendNotifyEnableSucc() || NotificationServiceImpl.this.isSystemSwitcherChanged(context)) {
                    Logger.m268d("NoticeStateSync", "[syncNotifySwitchStatus] sendPushEnableToServer");
                    if (!TextUtils.isEmpty(str)) {
                        NotificationServiceImpl.this.sendPushEnableToServer(context, isPushNotifyEnable, str);
                    } else {
                        NotificationServiceImpl.this.sendPushEnableToServer(context, isPushNotifyEnable);
                    }
                }
                NotificationServiceImpl.this.eventSwitchStatus(context, isPushNotifyEnable);
            }
        });
    }

    @Override // com.bytedance.push.interfaze.INotificationService
    public void createChannels(Context context, List<PushNotificationChannel> list) {
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
        for (PushNotificationChannel pushNotificationChannel : list) {
            if (pushNotificationChannel != null) {
                try {
                    if (pushNotificationChannel.isEnable()) {
                        NotificationCompat.get().createChannel(context, pushNotificationChannel);
                    } else if (!TextUtils.equals(pushNotificationChannel.getId(), Configuration.NOTIFICATION_ID)) {
                        NotificationCompat.get().deleteChannel(context, pushNotificationChannel);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // com.bytedance.push.interfaze.INotificationService
    public void sendPushEnableToServer(Context context, boolean z) {
        LocalFrequencySettings localFrequencySettings = (LocalFrequencySettings) SettingsManager.obtain(context, LocalFrequencySettings.class);
        if (!NetworkUtils.isNetworkAvailable(context)) {
            localFrequencySettings.setLastSendNotifyEnableSucc(false);
            return;
        }
        SyncNotificationSwitchTask syncNotificationSwitchTask = new SyncNotificationSwitchTask(context, this.mSupport, z, null, null);
        if (Looper.getMainLooper() == Looper.myLooper()) {
            ThreadPlus.submitRunnable(syncNotificationSwitchTask);
        } else {
            syncNotificationSwitchTask.run();
        }
    }

    @Override // com.bytedance.push.interfaze.INotificationService
    public void sendPushEnableToServer(Context context, boolean z, String str) {
        LocalFrequencySettings localFrequencySettings = (LocalFrequencySettings) SettingsManager.obtain(context, LocalFrequencySettings.class);
        if (!NetworkUtils.isNetworkAvailable(context)) {
            localFrequencySettings.setLastSendNotifyEnableSucc(false);
            return;
        }
        SyncNotificationSwitchTask syncNotificationSwitchTask = new SyncNotificationSwitchTask(context, this.mSupport, z, null, null, str);
        if (Looper.getMainLooper() == Looper.myLooper()) {
            ThreadPlus.submitRunnable(syncNotificationSwitchTask);
        } else {
            syncNotificationSwitchTask.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isSystemSwitcherChanged(Context context) {
        return NotificationCompat.get().isSwitcherChanged(context, ((LocalFrequencySettings) SettingsManager.obtain(context, LocalFrequencySettings.class)).getSystemPushEnable());
    }

    public static boolean checkChannelExists(Context context, String str) {
        try {
            if (Build.VERSION.SDK_INT < 26) {
                return true;
            }
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (notificationManager != null && !TextUtils.isEmpty(str)) {
                return notificationManager.getNotificationChannel(str) != null;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.bytedance.push.interfaze.INotificationService
    public void trySyncNoticeStateOnce(Context context) {
        Logger.m268d("NoticeStateSync", "[trySyncNoticeStateOnce]");
        if (PushSetting.getInstance().isAllowNetwork()) {
            syncNotifySwitchStatus(context);
        }
    }

    @Override // com.bytedance.push.interfaze.INotificationService
    public void trySyncNoticeStateOnceWithReportingTiming(Context context, String str) {
        Logger.m268d("NoticeStateSync", "[trySyncNoticeStateOnce]");
        if (PushSetting.getInstance().isAllowNetwork()) {
            syncNotifySwitchStatusWithReportingTiming(context, str);
        }
    }

    @Override // com.bytedance.push.interfaze.INotificationService
    public void createDefaultChannel(final Context context, final Configuration.Notification notification) {
        if (context != null && Build.VERSION.SDK_INT >= 26) {
            ThreadPlus.submitRunnable(new Runnable() { // from class: com.bytedance.push.notification.NotificationServiceImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    Configuration.Notification notification2 = notification;
                    String string = context.getString(R.string.push_notification_channel_name);
                    if (notification2 == null) {
                        notification2 = new Configuration.Notification(Configuration.NOTIFICATION_ID, string);
                    } else if (!notification2.isValid()) {
                        if (TextUtils.isEmpty(notification2.f83id)) {
                            notification2.f83id = Configuration.NOTIFICATION_ID;
                        }
                        if (TextUtils.isEmpty(notification2.name)) {
                            notification2.name = string;
                        }
                    }
                    String str = notification2.f83id;
                    String str2 = notification2.name;
                    NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                    if (notificationManager != null && notificationManager.getNotificationChannel(str) == null) {
                        NotificationChannel notificationChannel = new NotificationChannel(str, str2, 4);
                        notificationChannel.setShowBadge(true);
                        notificationChannel.enableVibration(true);
                        notificationChannel.enableLights(true);
                        notificationManager.createNotificationChannel(notificationChannel);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.push.interfaze.INotificationService
    public void syncChildrenSwitcherChange(final Context context, final boolean z, final SwitcherStatus switcherStatus, final OnSwitcherSyncListener onSwitcherSyncListener) throws IllegalArgumentException {
        switcherStatus.checkValid();
        ThreadPlus.submitRunnable(new Runnable() { // from class: com.bytedance.push.notification.NotificationServiceImpl.3
            @Override // java.lang.Runnable
            public void run() {
                PollingNotificationReport pollingNotificationReport = PushSetting.getInstance().getPushOnLineSettings().getPollingNotificationReport();
                if (pollingNotificationReport.enableOriginalReporting) {
                    ThreadPlus.submitRunnable(new SyncNotificationSwitchTask(context, NotificationServiceImpl.this.mSupport, z, switcherStatus, onSwitcherSyncListener));
                }
                if (pollingNotificationReport.enableReportingTiming) {
                    ThreadPlus.submitRunnable(new SyncNotificationSwitchTask(context, NotificationServiceImpl.this.mSupport, z, switcherStatus, onSwitcherSyncListener, "innerSubSwitchAction"));
                }
            }
        });
    }

    @Override // com.bytedance.push.interfaze.INotificationService
    public void getChildrenSwitcherStatus(Context context, boolean z, OnSwitcherServerListener onSwitcherServerListener) {
        ThreadPlus.submitRunnable(new GetNotificationSwitchTask(context, z, this.mSupport, onSwitcherServerListener));
    }

    @Override // com.bytedance.push.interfaze.INotificationService
    public String checkAndGetValidChannelId(Context context, String str) {
        return Build.VERSION.SDK_INT < 26 ? str : (TextUtils.isEmpty(str) || !checkChannelExists(context, str)) ? Configuration.NOTIFICATION_ID : str;
    }

    @Override // com.bytedance.push.interfaze.INotificationService
    public void createDefaultChannel(Context context) {
        if (context == null || Build.VERSION.SDK_INT < 26 || checkChannelExists(context, Configuration.NOTIFICATION_ID)) {
            return;
        }
        createDefaultChannel(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eventSwitchStatus(Context context, boolean z) {
        JSONObject jSONObject = new JSONObject();
        String str = "open";
        try {
            jSONObject.put("in_status", z ? "open" : "close");
            if (1 != ToolUtils.areNotificationsEnabled(context)) {
                str = "close";
            }
            jSONObject.put("out_status", str);
        } catch (Throwable unused) {
        }
        this.mSupport.getStatisticsService().onEventV3("ttpush_push_notification_status", jSONObject);
    }
}
