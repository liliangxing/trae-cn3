package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.xiaomi.push.ad */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1470ad {

    /* renamed from: a */
    private static volatile C1470ad f920a;

    /* renamed from: a */
    private SharedPreferences f921a;

    /* renamed from: a */
    private ScheduledThreadPoolExecutor f924a = new ScheduledThreadPoolExecutor(1);

    /* renamed from: a */
    private Map<String, ScheduledFuture> f923a = new HashMap();

    /* renamed from: a */
    private Object f922a = new Object();

    /* renamed from: com.xiaomi.push.ad$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static abstract class a implements Runnable {
        /* renamed from: a */
        public abstract String mo1133a();
    }

    /* renamed from: com.xiaomi.push.ad$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private static class b implements Runnable {

        /* renamed from: a */
        a f929a;

        /* renamed from: a */
        void mo1457a() {
        }

        /* renamed from: b */
        void mo1458b() {
        }

        public b(a aVar) {
            this.f929a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            mo1457a();
            this.f929a.run();
            mo1458b();
        }
    }

    /* renamed from: a */
    public static C1470ad m1444a(Context context) {
        if (f920a == null) {
            synchronized (C1470ad.class) {
                if (f920a == null) {
                    f920a = new C1470ad(context);
                }
            }
        }
        return f920a;
    }

    private C1470ad(Context context) {
        this.f921a = context.getSharedPreferences("mipush_extra", 0);
    }

    /* renamed from: a */
    public boolean m1452a(a aVar, int i) {
        return m1453a(aVar, i, 0);
    }

    /* renamed from: a */
    public boolean m1453a(a aVar, int i, int i2) {
        return m1454a(aVar, i, i2, false);
    }

    /* renamed from: a */
    public boolean m1454a(a aVar, int i, int i2, final boolean z) {
        if (aVar == null || m1448a(aVar) != null) {
            return false;
        }
        final String m1446a = m1446a(aVar.mo1133a());
        b bVar = new b(aVar) { // from class: com.xiaomi.push.ad.1
            @Override // com.xiaomi.push.C1470ad.b
            /* renamed from: a */
            void mo1457a() {
                super.mo1457a();
            }

            @Override // com.xiaomi.push.C1470ad.b
            /* renamed from: b */
            void mo1458b() {
                if (z) {
                    return;
                }
                C1470ad.this.f921a.edit().putLong(m1446a, System.currentTimeMillis()).commit();
            }
        };
        if (!z) {
            long abs = Math.abs(System.currentTimeMillis() - this.f921a.getLong(m1446a, 0L)) / 1000;
            if (abs < i - i2) {
                i2 = (int) (i - abs);
            }
        }
        try {
            ScheduledFuture<?> scheduleAtFixedRate = this.f924a.scheduleAtFixedRate(bVar, i2, i, TimeUnit.SECONDS);
            synchronized (this.f922a) {
                this.f923a.put(aVar.mo1133a(), scheduleAtFixedRate);
            }
            return true;
        } catch (Exception e) {
            AbstractC1417b.m1093a(e);
            return true;
        }
    }

    /* renamed from: a */
    public void m1449a(Runnable runnable) {
        m1450a(runnable, 0);
    }

    /* renamed from: a */
    public void m1450a(Runnable runnable, int i) {
        this.f924a.schedule(runnable, i, TimeUnit.SECONDS);
    }

    /* renamed from: a */
    public boolean m1451a(a aVar) {
        return m1456b(aVar, 0);
    }

    /* renamed from: b */
    public boolean m1456b(a aVar, int i) {
        if (aVar == null || m1448a(aVar) != null) {
            return false;
        }
        ScheduledFuture<?> schedule = this.f924a.schedule(new b(aVar) { // from class: com.xiaomi.push.ad.2
            @Override // com.xiaomi.push.C1470ad.b
            /* renamed from: b */
            void mo1458b() {
                synchronized (C1470ad.this.f922a) {
                    C1470ad.this.f923a.remove(this.f929a.mo1133a());
                }
            }
        }, i, TimeUnit.SECONDS);
        synchronized (this.f922a) {
            this.f923a.put(aVar.mo1133a(), schedule);
        }
        return true;
    }

    /* renamed from: a */
    private ScheduledFuture m1448a(a aVar) {
        ScheduledFuture scheduledFuture;
        synchronized (this.f922a) {
            scheduledFuture = this.f923a.get(aVar.mo1133a());
        }
        return scheduledFuture;
    }

    /* renamed from: a */
    public boolean m1455a(String str) {
        synchronized (this.f922a) {
            ScheduledFuture scheduledFuture = this.f923a.get(str);
            if (scheduledFuture == null) {
                return false;
            }
            this.f923a.remove(str);
            return scheduledFuture.cancel(false);
        }
    }

    /* renamed from: a */
    private static String m1446a(String str) {
        return "last_job_time" + str;
    }
}
