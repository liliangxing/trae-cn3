package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;

/* renamed from: com.xiaomi.push.cv */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1542cv {

    /* renamed from: a */
    private static int f1262a = 0;

    /* renamed from: a */
    private static boolean f1263a = true;

    /* renamed from: a */
    private static int m1969a(boolean z) {
        return z ? 1 : 0;
    }

    /* renamed from: a */
    private static SharedPreferences m1970a(Context context) {
        return context.getSharedPreferences("sp_power_stats", 0);
    }

    /* renamed from: a */
    public static void m1974a(final Context context, final long j, final boolean z) {
        C1470ad.m1444a(context).m1449a(new Runnable() { // from class: com.xiaomi.push.cv.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    C1542cv.m1985i(context, j, z);
                } catch (Exception e) {
                    AbstractC1417b.m1089a("PowerStatsSP onSendMsg exception: " + e.getMessage());
                }
            }
        });
    }

    /* renamed from: b */
    public static void m1978b(final Context context, final long j, final boolean z) {
        C1470ad.m1444a(context).m1449a(new Runnable() { // from class: com.xiaomi.push.cv.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    C1542cv.m1986j(context, j, z);
                } catch (Exception e) {
                    AbstractC1417b.m1089a("PowerStatsSP onReceiveMsg exception: " + e.getMessage());
                }
            }
        });
    }

    /* renamed from: c */
    public static void m1979c(final Context context, final long j, final boolean z) {
        C1470ad.m1444a(context).m1449a(new Runnable() { // from class: com.xiaomi.push.cv.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    C1542cv.m1987k(context, j, z);
                } catch (Exception e) {
                    AbstractC1417b.m1089a("PowerStatsSP onPing exception: " + e.getMessage());
                }
            }
        });
    }

    /* renamed from: d */
    public static void m1980d(final Context context, final long j, final boolean z) {
        C1470ad.m1444a(context).m1449a(new Runnable() { // from class: com.xiaomi.push.cv.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    C1542cv.m1988l(context, j, z);
                } catch (Exception e) {
                    AbstractC1417b.m1089a("PowerStatsSP onPong exception: " + e.getMessage());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public static synchronized void m1985i(Context context, long j, boolean z) {
        int i;
        synchronized (C1542cv.class) {
            C1539cs.m1932a("recordSendMsg start");
            int m1969a = m1969a(z);
            SharedPreferences m1970a = m1970a(context);
            long j2 = m1970a.getLong("start_time", 0L);
            if (j2 <= 0) {
                m1975a(context, m1970a, j, m1969a);
            }
            if (m1969a == 1) {
                i = m1970a.getInt("on_up_count", 0) + 1;
                m1970a.edit().putInt("on_up_count", i).apply();
            } else {
                i = m1970a.getInt("off_up_count", 0) + 1;
                m1970a.edit().putInt("off_up_count", i).apply();
            }
            m1973a(context, j2, j, i, m1969a);
            C1539cs.m1932a("recordSendMsg complete");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public static synchronized void m1986j(Context context, long j, boolean z) {
        int i;
        synchronized (C1542cv.class) {
            C1539cs.m1932a("recordReceiveMsg start");
            int m1969a = m1969a(z);
            SharedPreferences m1970a = m1970a(context);
            long j2 = m1970a.getLong("start_time", 0L);
            if (j2 <= 0) {
                m1975a(context, m1970a, j, m1969a);
            }
            if (m1969a == 1) {
                i = m1970a.getInt("on_down_count", 0) + 1;
                m1970a.edit().putInt("on_down_count", i).apply();
            } else {
                i = m1970a.getInt("off_down_count", 0) + 1;
                m1970a.edit().putInt("off_down_count", i).apply();
            }
            m1973a(context, j2, j, i, m1969a);
            C1539cs.m1932a("recordReceiveMsg complete");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public static synchronized void m1987k(Context context, long j, boolean z) {
        int i;
        synchronized (C1542cv.class) {
            C1539cs.m1932a("recordPing start");
            int m1969a = m1969a(z);
            SharedPreferences m1970a = m1970a(context);
            long j2 = m1970a.getLong("start_time", 0L);
            if (j2 <= 0) {
                m1975a(context, m1970a, j, m1969a);
            }
            if (m1969a == 1) {
                i = m1970a.getInt("on_ping_count", 0) + 1;
                m1970a.edit().putInt("on_ping_count", i).apply();
            } else {
                i = m1970a.getInt("off_ping_count", 0) + 1;
                m1970a.edit().putInt("off_ping_count", i).apply();
            }
            m1973a(context, j2, j, i, m1969a);
            C1539cs.m1932a("recordPing complete");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public static synchronized void m1988l(Context context, long j, boolean z) {
        int i;
        synchronized (C1542cv.class) {
            C1539cs.m1932a("recordPong start");
            int m1969a = m1969a(z);
            SharedPreferences m1970a = m1970a(context);
            long j2 = m1970a.getLong("start_time", 0L);
            if (j2 <= 0) {
                m1975a(context, m1970a, j, m1969a);
            }
            if (m1969a == 1) {
                i = m1970a.getInt("on_pong_count", 0) + 1;
                m1970a.edit().putInt("on_pong_count", i).apply();
            } else {
                i = m1970a.getInt("off_pong_count", 0) + 1;
                m1970a.edit().putInt("off_pong_count", i).apply();
            }
            m1973a(context, j2, j, i, m1969a);
            C1539cs.m1932a("recordPong complete");
        }
    }

    /* renamed from: a */
    private static void m1975a(Context context, SharedPreferences sharedPreferences, long j, int i) {
        C1539cs.m1932a("recordInit");
        sharedPreferences.edit().putLong("start_time", j).putInt("current_screen_state", i).putLong("current_screen_state_start_time", j).putInt("xmsf_vc", m1968a(context)).putInt("android_vc", Build.VERSION.SDK_INT).apply();
    }

    /* renamed from: a */
    private static void m1973a(Context context, long j, long j2, int i, int i2) {
        if (j > 0) {
            if (m1976a(context) || i >= 1073741823 || j2 - j >= DownloadConstants.DAY) {
                m1970a(context).edit().putLong("end_time", j2).apply();
                m1972a(context, j2, i2);
            }
        }
    }

    /* renamed from: a */
    private static void m1972a(Context context, long j, int i) {
        C1539cs.m1932a("upload");
        new C1541cu().m1967a(context, m1971a(context));
        m1977b(context, j, i);
    }

    /* renamed from: a */
    private static C1540ct m1971a(Context context) {
        SharedPreferences m1970a = m1970a(context);
        C1540ct c1540ct = new C1540ct();
        c1540ct.m1941a(m1970a.getInt("off_up_count", 0));
        c1540ct.m1945b(m1970a.getInt("off_down_count", 0));
        c1540ct.m1949c(m1970a.getInt("off_ping_count", 0));
        c1540ct.m1953d(m1970a.getInt("off_pong_count", 0));
        c1540ct.m1942a(m1970a.getLong("off_duration", 0L));
        c1540ct.m1956e(m1970a.getInt("on_up_count", 0));
        c1540ct.m1958f(m1970a.getInt("on_down_count", 0));
        c1540ct.m1960g(m1970a.getInt("on_ping_count", 0));
        c1540ct.m1962h(m1970a.getInt("on_pong_count", 0));
        c1540ct.m1946b(m1970a.getLong("on_duration", 0L));
        c1540ct.m1950c(m1970a.getLong("start_time", 0L));
        c1540ct.m1954d(m1970a.getLong("end_time", 0L));
        c1540ct.m1964i(m1970a.getInt("xmsf_vc", 0));
        c1540ct.m1966j(m1970a.getInt("android_vc", 0));
        return c1540ct;
    }

    /* renamed from: b */
    private static void m1977b(Context context, long j, int i) {
        C1539cs.m1932a("reset");
        m1970a(context).edit().clear().putLong("start_time", j).putInt("current_screen_state", i).putLong("current_screen_state_start_time", j).putInt("xmsf_vc", m1968a(context)).putInt("android_vc", Build.VERSION.SDK_INT).apply();
    }

    /* renamed from: a */
    private static boolean m1976a(Context context) {
        boolean z = false;
        if (f1263a) {
            f1263a = false;
            SharedPreferences m1970a = m1970a(context);
            int i = m1970a.getInt("xmsf_vc", 0);
            int i2 = m1970a.getInt("android_vc", 0);
            if (i != 0 && i2 != 0 && (i != m1968a(context) || i2 != Build.VERSION.SDK_INT)) {
                z = true;
            }
        }
        C1539cs.m1932a("isVcChanged = " + z);
        return z;
    }

    /* renamed from: a */
    private static int m1968a(Context context) {
        if (f1262a <= 0) {
            f1262a = C1694j.m3429b(context);
        }
        return f1262a;
    }
}
