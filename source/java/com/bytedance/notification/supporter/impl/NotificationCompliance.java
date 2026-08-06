package com.bytedance.notification.supporter.impl;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.android.service.manager.push.notification.NotificationBody;
import com.bytedance.notification.supporter.service.INotificationCompliance;
import com.bytedance.push.utils.RomVersionParamHelper;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class NotificationCompliance implements INotificationCompliance {
    public static final int COMPLIANCE_CHANNEL_IMPORTANCE_HIGH = 3;
    public static final int COMPLIANCE_CHANNEL_NOTIFY_WAY_ERROR = 4;
    public static final int COMPLIANCE_CHANNEL_NO_EXIST = 2;
    public static final int COMPLIANCE_NO_CHANNEL_ID_OR_CATEGORY = 1;
    public static final int COMPLIANCE_SUCCESS = 0;

    @Override // com.bytedance.notification.supporter.service.INotificationCompliance
    public int check(Context context, NotificationBody notificationBody) {
        return checkNotificationInHarmonyOs4Device(context, notificationBody);
    }

    private int checkNotificationInHarmonyOs4Device(Context context, NotificationBody notificationBody) {
        NotificationManager notificationManager;
        if (Build.VERSION.SDK_INT < 26 || !RomVersionParamHelper.isGreaterThanHarmonyOs4() || (notificationManager = (NotificationManager) context.getSystemService("notification")) == null) {
            return 0;
        }
        if (TextUtils.isEmpty(notificationBody.notificationCategory) || TextUtils.isEmpty(notificationBody.channelId)) {
            return 1;
        }
        NotificationChannel notificationChannel = notificationManager.getNotificationChannel(notificationBody.channelId);
        if (notificationChannel == null) {
            return 2;
        }
        if (notificationBody.channelImportance == 1 && notificationChannel.getImportance() > 2) {
            return 3;
        }
        if (notificationChannel.getImportance() <= 2) {
            if (notificationChannel.shouldVibrate()) {
                return 4;
            }
            if ((notificationChannel.getSound() != null && notificationChannel.getSound() != Settings.System.DEFAULT_NOTIFICATION_URI && !TextUtils.isEmpty(notificationChannel.getSound().toString())) || notificationChannel.getLockscreenVisibility() != -1) {
                return 4;
            }
        }
        return 0;
    }
}
