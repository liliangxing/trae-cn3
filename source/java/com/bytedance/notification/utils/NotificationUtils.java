package com.bytedance.notification.utils;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;

/* loaded from: classes4.dex */
public class NotificationUtils {
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
}
