package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes7.dex */
public class ad {
    private static volatile ad a;

    /* renamed from: a, reason: collision with other field name */
    private SharedPreferences f142a;

    /* renamed from: a, reason: collision with other field name */
    private ScheduledThreadPoolExecutor f145a = new ScheduledThreadPoolExecutor(1);

    /* renamed from: a, reason: collision with other field name */
    private Map<String, ScheduledFuture> f144a = new HashMap();

    /* renamed from: a, reason: collision with other field name */
    private Object f143a = new Object();

    /* loaded from: classes7.dex */
    public static abstract class a implements Runnable {
        /* renamed from: a */
        public abstract String mo9661a();
    }

    /* loaded from: classes7.dex */
    private static class b implements Runnable {
        a a;

        void a() {
        }

        void b() {
        }

        public b(a aVar) {
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
            this.a.run();
            b();
        }
    }

    public static ad a(Context context) {
        if (a == null) {
            synchronized (ad.class) {
                if (a == null) {
                    a = new ad(context);
                }
            }
        }
        return a;
    }

    private ad(Context context) {
        this.f142a = context.getSharedPreferences("mipush_extra", 0);
    }

    public boolean a(a aVar, int i) {
        return a(aVar, i, 0);
    }

    public boolean a(a aVar, int i, int i2) {
        return a(aVar, i, i2, false);
    }

    public boolean a(a aVar, int i, int i2, final boolean z) {
        if (aVar == null || a(aVar) != null) {
            return false;
        }
        final String a2 = a(aVar.mo9661a());
        b bVar = new b(aVar) { // from class: com.xiaomi.push.ad.1
            @Override // com.xiaomi.push.ad.b
            void a() {
                super.a();
            }

            @Override // com.xiaomi.push.ad.b
            void b() {
                if (z) {
                    return;
                }
                ad.this.f142a.edit().putLong(a2, System.currentTimeMillis()).commit();
            }
        };
        if (!z) {
            long abs = Math.abs(System.currentTimeMillis() - this.f142a.getLong(a2, 0L)) / 1000;
            if (abs < i - i2) {
                i2 = (int) (i - abs);
            }
        }
        try {
            ScheduledFuture<?> scheduleAtFixedRate = this.f145a.scheduleAtFixedRate(bVar, i2, i, TimeUnit.SECONDS);
            synchronized (this.f143a) {
                this.f144a.put(aVar.mo9661a(), scheduleAtFixedRate);
            }
            return true;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return true;
        }
    }

    public void a(Runnable runnable) {
        a(runnable, 0);
    }

    public void a(Runnable runnable, int i) {
        this.f145a.schedule(runnable, i, TimeUnit.SECONDS);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m9608a(a aVar) {
        return b(aVar, 0);
    }

    public boolean b(a aVar, int i) {
        if (aVar == null || a(aVar) != null) {
            return false;
        }
        ScheduledFuture<?> schedule = this.f145a.schedule(new b(aVar) { // from class: com.xiaomi.push.ad.2
            @Override // com.xiaomi.push.ad.b
            void b() {
                synchronized (ad.this.f143a) {
                    ad.this.f144a.remove(this.a.mo9661a());
                }
            }
        }, i, TimeUnit.SECONDS);
        synchronized (this.f143a) {
            this.f144a.put(aVar.mo9661a(), schedule);
        }
        return true;
    }

    private ScheduledFuture a(a aVar) {
        ScheduledFuture scheduledFuture;
        synchronized (this.f143a) {
            scheduledFuture = this.f144a.get(aVar.mo9661a());
        }
        return scheduledFuture;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m9609a(String str) {
        synchronized (this.f143a) {
            ScheduledFuture scheduledFuture = this.f144a.get(str);
            if (scheduledFuture == null) {
                return false;
            }
            this.f144a.remove(str);
            return scheduledFuture.cancel(false);
        }
    }

    private static String a(String str) {
        return "last_job_time" + str;
    }
}
