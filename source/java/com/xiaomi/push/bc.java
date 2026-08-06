package com.xiaomi.push;

/* loaded from: classes7.dex */
public class bc {
    private long a;
    private long b;
    private long c;
    private long d;
    private final long e = System.currentTimeMillis();

    public int a() {
        return com.xiaomi.push.service.ag.a() ? 1 : 0;
    }

    /* renamed from: a, reason: collision with other method in class */
    public long m9657a() {
        return this.a;
    }

    public void a(long j) {
        this.a = j;
    }

    public long b() {
        return this.b;
    }

    public void b(long j) {
        this.b += j;
    }

    public long c() {
        return this.c;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m9658a() {
        this.c++;
    }

    public long d() {
        return this.d;
    }

    public void c(long j) {
        this.d += j;
    }
}
