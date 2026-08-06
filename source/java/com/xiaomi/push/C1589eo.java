package com.xiaomi.push;

import android.os.SystemClock;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.C1586el;
import com.xiaomi.push.service.C1755am;
import com.xiaomi.push.service.XMPushService;
import java.util.Hashtable;

/* renamed from: com.xiaomi.push.eo */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1589eo {

    /* renamed from: a */
    private static final int f1643a = EnumC1582eh.PING_RTT.m2346a();

    /* renamed from: a */
    private static long f1644a = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.push.eo$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class a {

        /* renamed from: a */
        static Hashtable<Integer, Long> f1645a = new Hashtable<>();
    }

    /* renamed from: a */
    public static void m2420a(String str, Exception exc) {
        try {
            C1586el.a m2393b = C1586el.m2393b(exc);
            C1583ei m2405a = C1588en.m2403a().m2405a();
            m2405a.m2349a(m2393b.f1622a.m2346a());
            m2405a.m2362c(m2393b.f1623a);
            m2405a.m2357b(str);
            if (C1588en.m2402a() != null && C1588en.m2402a().f1627a != null) {
                m2405a.m2361c(C1486at.m1547b(C1588en.m2402a().f1627a) ? 1 : 0);
            }
            C1588en.m2403a().m2408a(m2405a);
        } catch (NullPointerException unused) {
        }
    }

    /* renamed from: b */
    public static void m2423b(String str, Exception exc) {
        try {
            C1586el.a m2395d = C1586el.m2395d(exc);
            C1583ei m2405a = C1588en.m2403a().m2405a();
            m2405a.m2349a(m2395d.f1622a.m2346a());
            m2405a.m2362c(m2395d.f1623a);
            m2405a.m2357b(str);
            if (C1588en.m2402a() != null && C1588en.m2402a().f1627a != null) {
                m2405a.m2361c(C1486at.m1547b(C1588en.m2402a().f1627a) ? 1 : 0);
            }
            C1588en.m2403a().m2408a(m2405a);
        } catch (NullPointerException unused) {
        }
    }

    /* renamed from: a */
    public static void m2419a(String str, int i, Exception exc) {
        C1583ei m2405a = C1588en.m2403a().m2405a();
        if (C1588en.m2402a() != null && C1588en.m2402a().f1627a != null) {
            m2405a.m2361c(C1486at.m1547b(C1588en.m2402a().f1627a) ? 1 : 0);
        }
        if (i > 0) {
            m2405a.m2349a(EnumC1582eh.GSLB_REQUEST_SUCCESS.m2346a());
            m2405a.m2357b(str);
            m2405a.m2356b(i);
            C1588en.m2403a().m2408a(m2405a);
            return;
        }
        try {
            C1586el.a m2391a = C1586el.m2391a(exc);
            m2405a.m2349a(m2391a.f1622a.m2346a());
            m2405a.m2362c(m2391a.f1623a);
            m2405a.m2357b(str);
            C1588en.m2403a().m2408a(m2405a);
        } catch (NullPointerException unused) {
        }
    }

    /* renamed from: a */
    public static void m2418a(XMPushService xMPushService, C1755am.b bVar) {
        new C1585ek(xMPushService, bVar).m2387a();
    }

    /* renamed from: a */
    public static synchronized void m2415a(int i, int i2) {
        synchronized (C1589eo.class) {
            if (i2 < 16777215) {
                a.f1645a.put(Integer.valueOf((i << 24) | i2), Long.valueOf(System.currentTimeMillis()));
            } else {
                AbstractC1417b.m1103d("stats key should less than 16777215");
            }
        }
    }

    /* renamed from: a */
    public static synchronized void m2417a(int i, int i2, String str, int i3) {
        synchronized (C1589eo.class) {
            long currentTimeMillis = System.currentTimeMillis();
            int i4 = (i << 24) | i2;
            if (a.f1645a.containsKey(Integer.valueOf(i4))) {
                C1583ei m2405a = C1588en.m2403a().m2405a();
                m2405a.m2349a(i2);
                m2405a.m2356b((int) (currentTimeMillis - a.f1645a.get(Integer.valueOf(i4)).longValue()));
                m2405a.m2357b(str);
                if (i3 > -1) {
                    m2405a.m2361c(i3);
                }
                C1588en.m2403a().m2408a(m2405a);
                a.f1645a.remove(Integer.valueOf(i2));
            } else {
                AbstractC1417b.m1103d("stats key not found");
            }
        }
    }

    /* renamed from: a */
    public static void m2413a() {
        if (f1644a == 0 || SystemClock.elapsedRealtime() - f1644a > 7200000) {
            f1644a = SystemClock.elapsedRealtime();
            m2415a(0, f1643a);
        }
    }

    /* renamed from: b */
    public static void m2422b() {
        m2417a(0, f1643a, null, -1);
    }

    /* renamed from: a */
    public static void m2416a(int i, int i2, int i3, String str, int i4) {
        C1583ei m2405a = C1588en.m2403a().m2405a();
        m2405a.m2348a((byte) i);
        m2405a.m2349a(i2);
        m2405a.m2356b(i3);
        m2405a.m2357b(str);
        m2405a.m2361c(i4);
        C1588en.m2403a().m2408a(m2405a);
    }

    /* renamed from: a */
    public static void m2414a(int i) {
        C1583ei m2405a = C1588en.m2403a().m2405a();
        m2405a.m2349a(EnumC1582eh.CHANNEL_STATS_COUNTER.m2346a());
        m2405a.m2361c(i);
        C1588en.m2403a().m2408a(m2405a);
    }

    /* renamed from: a */
    public static byte[] m2421a() {
        C1584ej m2406a = C1588en.m2403a().m2406a();
        if (m2406a != null) {
            return C1670ho.m3313a(m2406a);
        }
        return null;
    }
}
