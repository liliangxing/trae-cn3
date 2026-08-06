package com.bytedance.android.service.manager.push.notification;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.bytedance.android.push.service.manager.annotation.ExternalService;
import org.json.JSONObject;

@ExternalService
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public interface IPushNotificationService {
    IPushNotification buildNotification(Context context, Intent intent, Notification.Builder builder, NotificationBody notificationBody);

    IPushNotification buildNotification(Context context, Intent intent, Notification.Builder builder, NotificationBody notificationBody, int i, String str);

    IPushNotification buildNotification(Context context, Intent intent, Notification.Builder builder, NotificationBody notificationBody, Notification notification, boolean z);

    IPushNotification buildNotification(Context context, Intent intent, Notification.Builder builder, NotificationBody notificationBody, Notification notification, boolean z, int i, String str);

    IPushNotification buildNotification(Context context, Intent intent, Notification.Builder builder, NotificationBody notificationBody, boolean z);

    IPushNotification buildNotification(Context context, Intent intent, Notification.Builder builder, NotificationBody notificationBody, boolean z, int i, String str);

    IPushNotification buildNotification(Context context, Intent intent, NotificationBody notificationBody, Notification notification);

    IPushNotification buildNotification(Context context, Intent intent, NotificationBody notificationBody, Notification notification, int i, String str);

    Bitmap downloadImage(String str);

    PendingIntent getNotificationDeleteIntent(long j);

    PendingIntent getNotificationDeleteIntent(long j, Bundle bundle, JSONObject jSONObject);

    PendingIntent getNotificationDeleteIntent(long j, JSONObject jSONObject);

    int getNotificationNum(Context context);

    boolean isClickByBanner(long j);

    boolean isSupportProxyNotification();

    void setAsyncImageDownloader(AsyncImageDownloader asyncImageDownloader);

    void showNotification(Context context, Intent intent, NotificationBody notificationBody);

    void tryClearSomeNotification();

    boolean tryShowPushNotification(Context context, Intent intent, NotificationBody notificationBody);
}
