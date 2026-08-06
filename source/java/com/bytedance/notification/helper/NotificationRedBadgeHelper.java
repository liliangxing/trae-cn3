package com.bytedance.notification.helper;

import android.app.Notification;
import android.graphics.Bitmap;
import com.bytedance.notification.utils.RedBadgeUtils;

/* loaded from: classes4.dex */
public class NotificationRedBadgeHelper {
    public static Notification.Builder setNotificationRedBadge(Notification.Builder builder, Bitmap bitmap, int i) {
        return (bitmap == null || i == 0) ? builder : builder.setLargeIcon(RedBadgeUtils.getRedBadgeBitmap(bitmap, i));
    }
}
