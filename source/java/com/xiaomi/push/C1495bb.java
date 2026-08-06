package com.xiaomi.push;

import java.util.concurrent.Callable;

/* renamed from: com.xiaomi.push.bb */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1495bb<T> {

    /* renamed from: a */
    private final long f1043a;

    /* renamed from: b */
    private long f1044b;

    /* renamed from: c */
    private long f1045c;

    /* renamed from: d */
    private long f1046d;

    /* renamed from: e */
    private long f1047e;

    /* renamed from: f */
    private long f1048f;

    /* renamed from: g */
    private long f1049g;

    /* renamed from: h */
    private long f1050h;

    /* renamed from: i */
    private final long f1051i;

    public C1495bb(long j, long j2) {
        this.f1051i = j * 1000000;
        this.f1043a = j2;
    }

    /* renamed from: a */
    public long m1636a() {
        return this.f1045c;
    }

    /* renamed from: b */
    public long m1638b() {
        return this.f1046d;
    }

    /* renamed from: c */
    public long m1639c() {
        long j = this.f1048f;
        if (j > 0) {
            long j2 = this.f1047e;
            if (j2 > 0) {
                return j / j2;
            }
        }
        return 0L;
    }

    /* renamed from: d */
    public long m1640d() {
        long j = this.f1050h;
        long j2 = this.f1049g;
        if (j > j2) {
            return j - j2;
        }
        return 0L;
    }

    /* renamed from: a */
    public T m1637a(Callable<T> callable) {
        T t;
        long j = this.f1044b;
        long j2 = this.f1051i;
        if (j > j2) {
            long j3 = (j / j2) * this.f1043a;
            this.f1044b = 0L;
            if (j3 > 0) {
                try {
                    Thread.sleep(j3);
                } catch (Exception unused) {
                }
            }
        }
        long nanoTime = System.nanoTime();
        if (this.f1049g <= 0) {
            this.f1049g = nanoTime;
        }
        try {
            t = callable.call();
        } catch (Exception e) {
            e.printStackTrace();
            t = null;
        }
        long nanoTime2 = System.nanoTime() - nanoTime;
        this.f1050h = System.nanoTime();
        this.f1047e++;
        if (this.f1045c < nanoTime2) {
            this.f1045c = nanoTime2;
        }
        if (nanoTime2 > 0) {
            this.f1048f += nanoTime2;
            long j4 = this.f1046d;
            if (j4 == 0 || j4 > nanoTime2) {
                this.f1046d = nanoTime2;
            }
        }
        this.f1044b += Math.max(nanoTime2, 0L);
        return t;
    }
}
