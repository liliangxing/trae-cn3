package com.huawei.hms.push;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.api.push.TransActivity;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;

/* compiled from: PushNotification.java */
/* renamed from: com.huawei.hms.push.n */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1224n {

    /* renamed from: a */
    private static int f1693a;

    /* renamed from: a */
    public static synchronized void m1972a(Context context, C1225o c1225o) {
        int hashCode;
        int i;
        int i2;
        int hashCode2;
        synchronized (C1224n.class) {
            if (context != null) {
                if (!m1976a(c1225o)) {
                    HMSLog.m2115d("PushSelfShowLog", "showNotification, the msg id = " + c1225o.m2012o());
                    if (f1693a == 0) {
                        f1693a = (context.getPackageName() + System.currentTimeMillis()).hashCode();
                    }
                    if (TextUtils.isEmpty(c1225o.m2008k())) {
                        String m2013p = c1225o.m2013p();
                        if (!TextUtils.isEmpty(m2013p)) {
                            int hashCode3 = m2013p.hashCode();
                            c1225o.m1998a(hashCode3);
                            HMSLog.m2115d("PushSelfShowLog", "notification msgTag = " + hashCode3);
                        }
                        if (c1225o.m2014r() != -1) {
                            hashCode = c1225o.m2014r();
                            i = (c1225o.m2007j() + System.currentTimeMillis()).hashCode();
                            i2 = i + 1;
                            hashCode2 = (c1225o.m2014r() + c1225o.m2007j() + context.getPackageName()).hashCode();
                        } else {
                            hashCode = f1693a + 1;
                            i = hashCode + 1;
                            i2 = i + 1;
                            hashCode2 = i2 + 1;
                            f1693a = hashCode2;
                        }
                    } else {
                        hashCode = (c1225o.m2008k() + c1225o.m2007j()).hashCode();
                        i = f1693a + 1;
                        i2 = i + 1;
                        f1693a = i2;
                        hashCode2 = (c1225o.m2008k() + c1225o.m2007j() + context.getPackageName()).hashCode();
                    }
                    HMSLog.m2115d("PushSelfShowLog", "notifyId:" + hashCode + ",openNotifyId:" + i + ",delNotifyId:" + i2 + ",alarmNotifyId:" + hashCode2);
                    int[] iArr = new int[4];
                    iArr[0] = hashCode;
                    iArr[1] = i;
                    iArr[2] = i2;
                    if (c1225o.m2002e() <= 0) {
                        hashCode2 = 0;
                    }
                    iArr[3] = hashCode2;
                    Notification m1968a = C1215e.m1955d() ? m1968a(context, c1225o, iArr) : null;
                    NotificationManager notificationManager = (NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION);
                    if (notificationManager != null && m1968a != null) {
                        if (Build.VERSION.SDK_INT >= 26) {
                            notificationManager.createNotificationChannel(new NotificationChannel("HwPushChannelID", context.getString(ResourceLoaderUtil.getStringId("hms_push_channel")), 3));
                        }
                        notificationManager.notify(hashCode, m1968a);
                        C1222l.m1967a(context, c1225o.m2012o(), c1225o.m1999b(), "100");
                    }
                }
            }
        }
    }

    /* renamed from: b */
    private static PendingIntent m1977b(Context context, C1225o c1225o, int[] iArr) {
        return PendingIntent.getBroadcast(context, iArr[2], m1969a(context, c1225o, iArr, "2", 268435456), C1215e.m1947a());
    }

    /* renamed from: c */
    private static PendingIntent m1980c(Context context, C1225o c1225o, int[] iArr) {
        Intent m1969a = m1969a(context, c1225o, iArr, "1", 268435456);
        if (m1975a()) {
            m1969a.setClass(context, TransActivity.class);
            m1969a.setFlags(268468224);
            return PendingIntent.getActivity(context, iArr[1], m1969a, C1215e.m1947a());
        }
        return PendingIntent.getBroadcast(context, iArr[1], m1969a, C1215e.m1947a());
    }

    /* renamed from: d */
    private static void m1982d(C1225o c1225o, Notification.Builder builder) {
        String m2016t = c1225o.m2016t();
        String m2006i = c1225o.m2006i();
        if (TextUtils.isEmpty(m2006i)) {
            builder.setContentText(m2016t);
            return;
        }
        builder.setContentText(m2006i);
        if (TextUtils.isEmpty(m2016t)) {
            return;
        }
        builder.setContentTitle(m2016t);
    }

    /* renamed from: b */
    private static void m1978b(Context context, Notification.Builder builder, C1225o c1225o) {
        if ("com.huawei.android.pushagent".equals(context.getPackageName())) {
            Bundle bundle = new Bundle();
            String m2007j = c1225o.m2007j();
            if (TextUtils.isEmpty(m2007j)) {
                return;
            }
            bundle.putString("hw_origin_sender_package_name", m2007j);
            builder.setExtras(bundle);
        }
    }

    /* renamed from: c */
    private static void m1981c(C1225o c1225o, Notification.Builder builder) {
        builder.setTicker(c1225o.m2018w());
    }

    /* renamed from: b */
    private static void m1979b(C1225o c1225o, Notification.Builder builder) {
        String m2015s = c1225o.m2015s();
        if (TextUtils.isEmpty(m2015s)) {
            return;
        }
        builder.setSubText(m2015s);
    }

    /* renamed from: a */
    private static boolean m1975a() {
        return Build.VERSION.SDK_INT >= 30;
    }

    /* renamed from: a */
    private static Intent m1969a(Context context, C1225o c1225o, int[] iArr, String str, int i) {
        Intent intent = new Intent("com.huawei.intent.action.PUSH_DELAY_NOTIFY");
        intent.putExtra("selfshow_info", c1225o.m2011n()).putExtra("selfshow_token", c1225o.m2019x()).putExtra("selfshow_event_id", str).putExtra("selfshow_notify_id", iArr[0]).putExtra("selfshow_auto_clear_id", iArr[3]).setPackage(context.getPackageName()).setFlags(i);
        return intent;
    }

    /* renamed from: a */
    private static Notification m1968a(Context context, C1225o c1225o, int[] iArr) {
        Notification.Builder builder = new Notification.Builder(context);
        if (C1220j.m1963a(c1225o) == EnumC1221k.STYLE_BIGTEXT) {
            C1220j.m1964a(builder, c1225o.m2003f(), c1225o);
        }
        C1218h.m1959a(context, builder, c1225o);
        m1979b(c1225o, builder);
        m1982d(c1225o, builder);
        m1973a(context, c1225o, builder);
        m1970a(builder);
        m1974a(c1225o, builder);
        m1981c(c1225o, builder);
        builder.setContentIntent(m1980c(context, c1225o, iArr));
        builder.setDeleteIntent(m1977b(context, c1225o, iArr));
        if (Build.VERSION.SDK_INT >= 26) {
            builder.setChannelId("HwPushChannelID");
        }
        m1978b(context, builder, c1225o);
        m1971a(context, builder, c1225o);
        return builder.build();
    }

    /* renamed from: a */
    private static void m1971a(Context context, Notification.Builder builder, C1225o c1225o) {
        if (HwBuildEx.VERSION.EMUI_SDK_INT < 11 || !C1215e.m1950a(context)) {
            return;
        }
        Bundle bundle = new Bundle();
        String m2007j = c1225o.m2007j();
        HMSLog.m2120i("PushSelfShowLog", "the package name of notification is:" + m2007j);
        if (!TextUtils.isEmpty(m2007j)) {
            String m1949a = C1215e.m1949a(context, m2007j);
            HMSLog.m2120i("PushSelfShowLog", "the app name is:" + m1949a);
            if (m1949a != null) {
                bundle.putCharSequence("android.extraAppName", m1949a);
            }
        }
        builder.setExtras(bundle);
    }

    /* renamed from: a */
    private static void m1973a(Context context, C1225o c1225o, Notification.Builder builder) {
        Bitmap m1958a = C1218h.m1958a(context, c1225o);
        if (m1958a != null) {
            builder.setLargeIcon(m1958a);
        }
    }

    /* renamed from: a */
    private static void m1970a(Notification.Builder builder) {
        builder.setShowWhen(true);
        builder.setWhen(System.currentTimeMillis());
    }

    /* renamed from: a */
    private static void m1974a(C1225o c1225o, Notification.Builder builder) {
        builder.setAutoCancel(c1225o.m2001d() == 1);
        builder.setOngoing(false);
    }

    /* renamed from: a */
    private static boolean m1976a(C1225o c1225o) {
        return c1225o == null || (TextUtils.isEmpty(c1225o.m2016t()) && TextUtils.isEmpty(c1225o.m2006i()));
    }
}
