package com.xiaomi.push.service;

import android.app.Notification;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.ss.android.deviceregister.utils.RomUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.C1470ad;
import com.xiaomi.push.C1488av;
import com.xiaomi.push.C1694j;
import com.xiaomi.push.C1703r;
import com.xiaomi.push.NotificationBuilderC1568du;
import java.util.List;
import java.util.Map;

/* renamed from: com.xiaomi.push.service.bb */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1771bb {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m3813a(Context context, Map<String, String> map, NotificationBuilderC1568du notificationBuilderC1568du, long j) {
        if (map == null || notificationBuilderC1568du == null || !C1694j.m3427a(context) || !m3814a(map)) {
            return;
        }
        int m3808a = m3808a(map);
        int m3815b = m3815b(map);
        if (m3808a > 0 && m3815b <= m3808a) {
            notificationBuilderC1568du.setPriority(2);
            Bundle bundle = new Bundle();
            bundle.putLong("mipush_org_when", j);
            bundle.putBoolean("mipush_n_top_flag", true);
            if (m3815b > 0) {
                bundle.putInt("mipush_n_top_fre", m3815b);
            }
            bundle.putInt("mipush_n_top_prd", m3808a);
            notificationBuilderC1568du.addExtras(bundle);
            return;
        }
        AbstractC1417b.m1103d("set top notification failed - period:" + m3808a + " frequency:" + m3815b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m3812a(Context context, String str, int i, String str2, Notification notification) {
        if (C1694j.m3427a(context) && notification != null && notification.extras.getBoolean("mipush_n_top_flag", false)) {
            m3818c(context, str, i, str2, notification);
        }
    }

    /* renamed from: a */
    private static boolean m3814a(Map<String, String> map) {
        String str = map.get("notification_top_repeat");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean parseBoolean = Boolean.parseBoolean(str);
        AbstractC1417b.m1101c("top notification' repeat is " + parseBoolean);
        return parseBoolean;
    }

    /* renamed from: a */
    private static int m3808a(Map<String, String> map) {
        return Math.max(0, C1703r.m3472a(map.get("notification_top_period"), 0));
    }

    /* renamed from: b */
    private static int m3815b(Map<String, String> map) {
        return Math.max(0, C1703r.m3472a(map.get("notification_top_frequency"), 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static void m3818c(Context context, String str, int i, String str2, Notification notification) {
        C1748af m3625a;
        Notification m3809a;
        int i2;
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || Build.VERSION.SDK_INT < 26 || (m3809a = m3809a(notification, i, str2, (m3625a = C1748af.m3625a(context, str)))) == null) {
            return;
        }
        boolean z = notification != null;
        if (m3809a.getGroupAlertBehavior() != 1) {
            C1488av.m1573a((Object) m3809a, "mGroupAlertBehavior", (Object) 1);
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = m3809a.extras.getLong("mipush_org_when", 0L);
        int i3 = m3809a.extras.getInt("mipush_n_top_fre", 0);
        int i4 = m3809a.extras.getInt("mipush_n_top_prd", 0);
        if (i4 <= 0 || i4 < i3) {
            return;
        }
        long j2 = (i4 * 1000) + j;
        if (j >= currentTimeMillis || currentTimeMillis >= j2) {
            i2 = 0;
        } else {
            i2 = i3 > 0 ? (int) Math.min((j2 - currentTimeMillis) / 1000, i3) : i4;
        }
        if (!z) {
            if (i2 > 0) {
                m3809a.when = currentTimeMillis;
                AbstractC1417b.m1089a("update top notification: " + str2);
                m3625a.m3643a(i, m3809a);
            } else {
                Notification.Builder recoverBuilder = Notification.Builder.recoverBuilder(context, m3809a);
                recoverBuilder.setPriority(0);
                recoverBuilder.setWhen(currentTimeMillis);
                Bundle extras = recoverBuilder.getExtras();
                if (extras != null) {
                    extras.remove("mipush_n_top_flag");
                    extras.remove("mipush_org_when");
                    extras.remove("mipush_n_top_fre");
                    extras.remove("mipush_n_top_prd");
                    recoverBuilder.setExtras(extras);
                }
                AbstractC1417b.m1089a("update top notification to common: " + str2);
                m3625a.m3643a(i, recoverBuilder.build());
            }
        }
        if (i2 > 0) {
            AbstractC1417b.m1089a("schedule top notification next update delay: " + i2);
            C1470ad.m1444a(context).m1455a(m3816b(i, str2));
            C1470ad.m1444a(context).m1456b(m3810a(context, str, i, str2, (Notification) null), i2);
        }
    }

    /* renamed from: a */
    private static Notification m3809a(Notification notification, int i, String str, C1748af c1748af) {
        if (notification != null) {
            if (!str.equals(notification.extras.getString("message_id"))) {
                notification = null;
            }
            return notification;
        }
        List<StatusBarNotification> m3648b = c1748af.m3648b();
        if (m3648b == null) {
            return null;
        }
        for (StatusBarNotification statusBarNotification : m3648b) {
            Notification notification2 = statusBarNotification.getNotification();
            String string = notification2.extras.getString("message_id");
            if (i == statusBarNotification.getId() && str.equals(string)) {
                return notification2;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static String m3816b(int i, String str) {
        return "n_top_update_" + i + RomUtils.SEPARATOR + str;
    }

    /* renamed from: a */
    private static C1470ad.a m3810a(final Context context, final String str, final int i, final String str2, final Notification notification) {
        return new C1470ad.a() { // from class: com.xiaomi.push.service.bb.1
            @Override // com.xiaomi.push.C1470ad.a
            /* renamed from: a */
            public String mo1133a() {
                return C1771bb.m3816b(i, str2);
            }

            @Override // java.lang.Runnable
            public void run() {
                C1771bb.m3818c(context, str, i, str2, notification);
            }
        };
    }
}
