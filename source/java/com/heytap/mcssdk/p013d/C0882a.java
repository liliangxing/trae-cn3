package com.heytap.mcssdk.p013d;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import com.heytap.mcssdk.p011b.C0874a;
import com.heytap.msp.push.notification.PushNotification;
import com.huawei.hms.push.constant.RemoteMessageConst;

/* renamed from: com.heytap.mcssdk.d.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0882a {
    /* renamed from: a */
    public static Notification m606a(Context context, String str, PushNotification.Builder builder) {
        Notification.Builder builder2 = new Notification.Builder(context);
        if (Build.VERSION.SDK_INT >= 26) {
            builder2.setChannelId(C0874a.f498a);
        }
        builder2.setGroup(str);
        builder2.setGroupSummary(true);
        if (m608a(builder2, builder)) {
            return builder2.build();
        }
        return null;
    }

    /* renamed from: a */
    public static NotificationManager m607a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return (NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: a */
    private static boolean m608a(Notification.Builder builder, PushNotification.Builder builder2) {
        int iconRes = builder2.getIconRes();
        int iconLevel = builder2.getIconLevel();
        Icon icon = builder2.getIcon();
        if (icon != null) {
            builder.setSmallIcon(icon);
            return true;
        }
        if (iconRes != 0 && iconLevel != 0) {
            builder.setSmallIcon(iconRes, iconLevel);
            return true;
        }
        if (iconRes == 0) {
            return false;
        }
        builder.setSmallIcon(iconRes);
        return true;
    }

    /* renamed from: a */
    public static boolean m609a(NotificationManager notificationManager, String str, int i) {
        StatusBarNotification[] m610a = m610a(notificationManager, str);
        if (m610a != null && m610a.length != 0) {
            for (StatusBarNotification statusBarNotification : m610a) {
                if (statusBarNotification.getId() == i) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public static StatusBarNotification[] m610a(NotificationManager notificationManager, String str) {
        return notificationManager.getActiveNotifications();
    }
}
