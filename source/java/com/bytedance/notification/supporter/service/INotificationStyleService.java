package com.bytedance.notification.supporter.service;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import com.bytedance.android.service.manager.push.notification.NotificationBody;
import com.bytedance.notification.model.PushNotification;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface INotificationStyleService {
    void addSoundAndVibrator(Context context, Notification notification, NotificationBody notificationBody);

    PushNotification buildCustomNotification(Context context, Intent intent, Notification.Builder builder, NotificationBody notificationBody);

    PushNotification buildCustomNotification(Context context, Intent intent, Notification.Builder builder, NotificationBody notificationBody, boolean z);

    PushNotification buildCustomNotification(Context context, Intent intent, Notification.Builder builder, NotificationBody notificationBody, boolean z, int i, String str);
}
