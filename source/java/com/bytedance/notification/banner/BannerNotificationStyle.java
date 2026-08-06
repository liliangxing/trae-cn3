package com.bytedance.notification.banner;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.bytedance.android.service.manager.push.notification.NotificationBody;
import com.bytedance.notification.extra.PushNotificationExtra;
import com.bytedance.notification.interfaze.IBannerNotification;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class BannerNotificationStyle implements IBannerNotification {
    private final String TAG = "BannerNotification";
    private AbsBannerNotification mAbsBannerNotification;
    private Context mContext;
    private NotificationBody mNotificationBody;
    private PushNotificationExtra mPushNotificationExtra;

    public BannerNotificationStyle(Context context, Notification.Builder builder, Intent intent, PushNotificationExtra pushNotificationExtra, NotificationBody notificationBody) {
        this.mContext = context;
        this.mPushNotificationExtra = pushNotificationExtra;
        this.mNotificationBody = notificationBody;
        int i = pushNotificationExtra.mBannerType;
        if (i == 0) {
            this.mAbsBannerNotification = new ToastBannerNotification(context, builder, intent, pushNotificationExtra, notificationBody);
        } else {
            if (i != 1) {
                return;
            }
            this.mAbsBannerNotification = new WindowBannerNotification(context, builder, intent, pushNotificationExtra, notificationBody);
        }
    }

    @Override // com.bytedance.notification.interfaze.IBannerNotification
    public void showBannerNotification(String str, int i) {
        AbsBannerNotification absBannerNotification = this.mAbsBannerNotification;
        if (absBannerNotification != null) {
            absBannerNotification.showBannerNotification(str, i);
        }
    }

    @Override // com.bytedance.notification.interfaze.IBannerNotification
    public PendingIntent getFullScreenIntent(Context context) {
        AbsBannerNotification absBannerNotification = this.mAbsBannerNotification;
        if (absBannerNotification != null) {
            return absBannerNotification.getFullScreenIntent(context);
        }
        return null;
    }
}
