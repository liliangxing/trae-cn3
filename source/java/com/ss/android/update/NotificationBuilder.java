package com.ss.android.update;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import androidx.core.app.NotificationCompat;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
class NotificationBuilder {
    NotificationBuilder() {
    }

    public static Notification initProgressNotification(Context context, NotificationCompat.Builder builder, int i, Bitmap bitmap, String str, String str2, String str3, int i2, PendingIntent pendingIntent) {
        builder.setSmallIcon(i).setTicker(str).setWhen(System.currentTimeMillis()).setOngoing(true).setContentIntent(pendingIntent);
        return updateProgressNotification(context, builder, str2, str3, i2);
    }

    public static Notification updateProgressNotification(Context context, NotificationCompat.Builder builder, String str, String str2, int i) {
        builder.setContentTitle(str).setContentInfo(str2).setProgress(100, i, false);
        return builder.build();
    }
}
