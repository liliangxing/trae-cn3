package com.xiaomi.push.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import com.ss.ttm.player.C0968C;
import com.ss.ttm.utils.AVLogger;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.C1488av;
import com.xiaomi.push.C1694j;
import com.xiaomi.push.EnumC1638gj;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.xiaomi.push.service.ad */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1746ad {

    /* renamed from: a */
    private static C1746ad f2938a = new C1746ad();

    /* renamed from: a */
    private SpannableString f2939a;

    /* renamed from: a */
    private boolean m3603a() {
        return true;
    }

    /* renamed from: a */
    public static C1746ad m3596a() {
        return f2938a;
    }

    private C1746ad() {
    }

    /* renamed from: a */
    private boolean m3605a(Context context) {
        if (m3609b(context) && C1748af.m3633a(context)) {
            return C1750ah.m3674a(context).m3686a(EnumC1638gj.LatestNotificationNotIntoGroupSwitch.m2760a(), false);
        }
        return false;
    }

    /* renamed from: b */
    private boolean m3609b(Context context) {
        return C1750ah.m3674a(context).m3686a(EnumC1638gj.NotificationAutoGroupSwitch.m2760a(), true);
    }

    /* renamed from: a */
    private String m3597a(Notification notification) {
        if (notification == null || notification.extras == null) {
            return null;
        }
        return notification.extras.getString("push_src_group_name");
    }

    /* renamed from: b */
    private String m3606b(Notification notification) {
        if (notification == null) {
            return null;
        }
        return m3608b(notification) ? m3597a(notification) : notification.getGroup();
    }

    /* renamed from: a */
    private boolean m3604a(Notification notification) {
        if (notification == null) {
            return false;
        }
        Object m1568a = C1488av.m1568a((Object) notification, "isGroupSummary", (Object[]) null);
        if (m1568a instanceof Boolean) {
            return ((Boolean) m1568a).booleanValue();
        }
        return false;
    }

    /* renamed from: a */
    public String m3610a(Context context, Notification.Builder builder, String str) {
        if (!m3603a() || !m3605a(context)) {
            return str;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Bundle extras = builder.getExtras();
        extras.putString("push_src_group_name", str);
        extras.putLong("push_src_group_time", currentTimeMillis);
        return String.format("pushmask_%s_%s", Long.valueOf(currentTimeMillis), str);
    }

    /* renamed from: b */
    private boolean m3608b(Notification notification) {
        if (notification == null || notification.getGroup() == null || notification.extras == null) {
            return false;
        }
        long j = notification.extras.getLong("push_src_group_time");
        return notification.getGroup().equals(String.format("pushmask_%s_%s", Long.valueOf(j), m3597a(notification)));
    }

    /* renamed from: a */
    public void m3611a(Context context, int i, Notification notification) {
        if (m3603a()) {
            if (m3605a(context)) {
                try {
                    m3607b(context, i, notification);
                } catch (Exception e) {
                    AbstractC1417b.m1089a("group notify handle restore error " + e);
                }
            }
            if (m3609b(context)) {
                try {
                    m3599a(context, i, notification, true);
                } catch (Exception e2) {
                    AbstractC1417b.m1089a("group notify handle auto error " + e2);
                }
            }
        }
    }

    /* renamed from: b */
    private void m3607b(Context context, int i, Notification notification) {
        String m3673c = C1749ag.m3673c(notification);
        if (TextUtils.isEmpty(m3673c)) {
            AbstractC1417b.m1089a("group restore not extract pkg from notification:" + i);
            return;
        }
        C1748af m3625a = C1748af.m3625a(context, m3673c);
        List<StatusBarNotification> m3598a = m3598a(m3625a);
        if (m3598a == null) {
            AbstractC1417b.m1089a("group restore not get notifications");
            return;
        }
        for (StatusBarNotification statusBarNotification : m3598a) {
            Notification notification2 = statusBarNotification.getNotification();
            if (notification2 != null && m3608b(notification2) && statusBarNotification.getId() != i) {
                Notification.Builder recoverBuilder = Notification.Builder.recoverBuilder(context, statusBarNotification.getNotification());
                recoverBuilder.setGroup(m3597a(notification2));
                C1749ag.m3666a(recoverBuilder, m3604a(notification2));
                m3625a.m3643a(statusBarNotification.getId(), recoverBuilder.build());
                AbstractC1417b.m1098b("group restore notification:" + statusBarNotification.getId());
            }
        }
    }

    /* renamed from: a */
    private void m3599a(Context context, int i, Notification notification, boolean z) {
        Notification notification2;
        String m3673c = C1749ag.m3673c(notification);
        if (TextUtils.isEmpty(m3673c)) {
            AbstractC1417b.m1089a("group auto not extract pkg from notification:" + i);
            return;
        }
        List<StatusBarNotification> m3598a = m3598a(C1748af.m3625a(context, m3673c));
        if (m3598a == null) {
            AbstractC1417b.m1089a("group auto not get notifications");
            return;
        }
        String m3606b = m3606b(notification);
        HashMap hashMap = new HashMap();
        for (StatusBarNotification statusBarNotification : m3598a) {
            if (statusBarNotification.getNotification() != null && statusBarNotification.getId() != i) {
                m3602a(hashMap, statusBarNotification);
            }
        }
        for (Map.Entry<String, a> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            if (!TextUtils.isEmpty(key)) {
                a value = entry.getValue();
                if (z && key.equals(m3606b) && !m3608b(notification)) {
                    b bVar = new b(i, notification);
                    if (m3604a(notification)) {
                        value.f2942b.add(bVar);
                    } else {
                        value.f2941a.add(bVar);
                    }
                }
                int size = value.f2941a.size();
                if (value.f2942b.size() <= 0) {
                    if (z && size >= 2) {
                        m3601a(context, m3673c, key, value.f2941a.get(0).f2944a);
                    }
                } else if (size <= 0) {
                    m3600a(context, m3673c, key);
                } else if (C1750ah.m3674a(context).m3686a(EnumC1638gj.NotificationGroupUpdateTimeSwitch.m2760a(), false) && (notification2 = value.f2942b.get(0).f2944a) != null) {
                    notification2.when = System.currentTimeMillis();
                    m3601a(context, m3673c, key, notification2);
                }
            }
        }
    }

    /* renamed from: a */
    private void m3602a(Map<String, a> map, StatusBarNotification statusBarNotification) {
        String m3606b = m3606b(statusBarNotification.getNotification());
        a aVar = map.get(m3606b);
        if (aVar == null) {
            aVar = new a();
            map.put(m3606b, aVar);
        }
        b bVar = new b(statusBarNotification.getId(), statusBarNotification.getNotification());
        if (m3604a(statusBarNotification.getNotification())) {
            aVar.f2942b.add(bVar);
        } else {
            aVar.f2941a.add(bVar);
        }
    }

    /* renamed from: a */
    private SpannableString m3595a(Context context, String str) {
        Resources resources;
        DisplayMetrics displayMetrics;
        int max;
        if (this.f2939a == null) {
            int i = (context == null || (resources = context.getResources()) == null || (displayMetrics = resources.getDisplayMetrics()) == null || (max = Math.max(displayMetrics.heightPixels, displayMetrics.widthPixels)) <= 0) ? 200 : max / 16;
            if (TextUtils.isEmpty(str)) {
                str = "新消息";
            }
            StringBuilder sb = new StringBuilder(str.length() + i + 12);
            sb.append(str);
            for (int i2 = 0; i2 < i; i2++) {
                sb.append(' ');
            }
            sb.append("GroupSummary");
            SpannableString spannableString = new SpannableString(sb.toString());
            spannableString.setSpan(new ForegroundColorSpan(0), str.length(), sb.length(), 33);
            this.f2939a = spannableString;
        }
        return this.f2939a;
    }

    /* renamed from: a */
    private void m3601a(Context context, String str, String str2, Notification notification) {
        Notification.Builder defaults;
        try {
            if (TextUtils.isEmpty(str2)) {
                AbstractC1417b.m1089a("group show summary group is null");
                return;
            }
            int m3651a = C1749ag.m3651a(context, str);
            if (m3651a == 0) {
                AbstractC1417b.m1089a("group show summary not get icon from " + str);
                return;
            }
            C1748af m3625a = C1748af.m3625a(context, str);
            if (Build.VERSION.SDK_INT >= 26) {
                String m3649c = m3625a.m3649c(notification.getChannelId(), "groupSummary");
                NotificationChannel m3637a = m3625a.m3637a(m3649c);
                if ("groupSummary".equals(m3649c) && m3637a == null) {
                    m3625a.m3644a(new NotificationChannel(m3649c, "group_summary", 3));
                }
                defaults = new Notification.Builder(context, m3649c);
            } else {
                defaults = new Notification.Builder(context).setPriority(0).setDefaults(-1);
            }
            C1749ag.m3666a(defaults, true);
            Notification build = defaults.setContentTitle(m3595a(context, "新消息")).setContentText("你有一条新消息").setSmallIcon(Icon.createWithResource(str, m3651a)).setAutoCancel(true).setGroup(str2).setGroupSummary(true).build();
            if (Build.VERSION.SDK_INT >= 31) {
                build.contentIntent = m3594a(context, str);
            }
            if (!C1694j.m3435c() && "com.xiaomi.xmsf".equals(context.getPackageName())) {
                C1749ag.m3661a(build, str);
            }
            int m3593a = m3593a(str, str2);
            m3625a.m3643a(m3593a, build);
            AbstractC1417b.m1098b("group show summary notify:" + m3593a);
        } catch (Exception e) {
            AbstractC1417b.m1089a("group show summary error " + e);
        }
    }

    /* renamed from: a */
    private PendingIntent m3594a(Context context, String str) {
        PendingIntent activity;
        if (context == null && TextUtils.isEmpty(str)) {
            AbstractC1417b.m1089a("ctx or pkg must not be null in getting launch intent");
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                AbstractC1417b.m1089a("pm must not be null in getting launch intent");
                return null;
            }
            Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str);
            if (launchIntentForPackage == null) {
                AbstractC1417b.m1089a("targetIntent must not be null in getting launch intent");
                return null;
            }
            launchIntentForPackage.addFlags(C0968C.ENCODING_PCM_MU_LAW);
            if (Build.VERSION.SDK_INT >= 31) {
                activity = PendingIntent.getActivity(context, 0, launchIntentForPackage, AVLogger.LEVEL_LOG_INFO);
            } else {
                activity = PendingIntent.getActivity(context, 0, launchIntentForPackage, 0);
            }
            return activity;
        } catch (Throwable th) {
            AbstractC1417b.m1103d("error occurred during getting launch pendingIntent. exception:" + th);
            return null;
        }
    }

    /* renamed from: a */
    private void m3600a(Context context, String str, String str2) {
        AbstractC1417b.m1098b("group cancel summary:" + str2);
        C1748af.m3625a(context, str).m3642a(m3593a(str, str2));
    }

    /* renamed from: a */
    private int m3593a(String str, String str2) {
        return ("GroupSummary" + str + str2).hashCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.xiaomi.push.service.ad$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class a {

        /* renamed from: a */
        List<b> f2941a;

        /* renamed from: b */
        List<b> f2942b;

        private a() {
            this.f2941a = new ArrayList();
            this.f2942b = new ArrayList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.xiaomi.push.service.ad$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class b {

        /* renamed from: a */
        int f2943a;

        /* renamed from: a */
        Notification f2944a;

        public b(int i, Notification notification) {
            this.f2943a = i;
            this.f2944a = notification;
        }

        public String toString() {
            return "id:" + this.f2943a;
        }
    }

    /* renamed from: a */
    private List<StatusBarNotification> m3598a(C1748af c1748af) {
        List<StatusBarNotification> m3648b = c1748af != null ? c1748af.m3648b() : null;
        if (m3648b == null || m3648b.size() == 0) {
            return null;
        }
        return m3648b;
    }
}
