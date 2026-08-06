package com.bytedance.tobshadow.bdtracker;

import com.bytedance.tobshadow.applog.log.IAppLogLogger;

/* renamed from: com.bytedance.tobshadow.bdtracker.l0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class AbstractC0461l0 {

    /* renamed from: a */
    public int f730a;

    /* renamed from: b */
    public volatile boolean f731b;

    /* renamed from: c */
    public long f732c;

    /* renamed from: d */
    public volatile boolean f733d;

    /* renamed from: e */
    public final C0475n0 f734e;

    /* renamed from: f */
    public final C0467m f735f;

    public AbstractC0461l0(C0475n0 c0475n0) {
        this.f734e = c0475n0;
        this.f735f = c0475n0.f834d;
    }

    /* renamed from: a */
    public final long m505a() {
        long m506b = m506b();
        if (m506b > System.currentTimeMillis()) {
            return m506b;
        }
        this.f734e.f834d.f764D.debug("The worker:{} start to work...", mo486d());
        try {
            boolean mo485c = mo485c();
            this.f732c = System.currentTimeMillis();
            if (mo485c) {
                this.f730a = 0;
            } else {
                this.f730a++;
            }
            IAppLogLogger iAppLogLogger = this.f734e.f834d.f764D;
            Object[] objArr = new Object[2];
            objArr[0] = mo486d();
            objArr[1] = mo485c ? "success" : "failed";
            iAppLogLogger.debug("The worker:{} worked:{}.", objArr);
        } catch (Throwable th) {
            try {
                this.f734e.f834d.f764D.error("Work do failed.", th, new Object[0]);
                this.f732c = System.currentTimeMillis();
                this.f730a++;
                this.f734e.f834d.f764D.debug("The worker:{} worked:{}.", mo486d(), "failed");
            } catch (Throwable th2) {
                this.f732c = System.currentTimeMillis();
                this.f730a++;
                this.f734e.f834d.f764D.debug("The worker:{} worked:{}.", mo486d(), "failed");
                throw th2;
            }
        }
        return m506b();
    }

    /* renamed from: b */
    public final long m506b() {
        long mo489g;
        long j;
        if (!mo488f() || C0501q5.m623b(this.f734e.m546b(), this.f734e.f844n.m653a()).m625a()) {
            if (this.f731b) {
                mo489g = 0;
                this.f732c = 0L;
                this.f731b = false;
            } else {
                int i = this.f730a;
                if (i > 0) {
                    long[] mo487e = mo487e();
                    mo489g = mo487e[(i - 1) % mo487e.length];
                } else {
                    mo489g = mo489g();
                }
            }
            j = this.f732c;
        } else {
            this.f734e.f834d.f764D.debug("Check work time is not net available.", new Object[0]);
            j = System.currentTimeMillis();
            mo489g = 5000;
        }
        return j + mo489g;
    }

    /* renamed from: c */
    public abstract boolean mo485c();

    /* renamed from: d */
    public abstract String mo486d();

    /* renamed from: e */
    public abstract long[] mo487e();

    /* renamed from: f */
    public abstract boolean mo488f();

    /* renamed from: g */
    public abstract long mo489g();

    public AbstractC0461l0(C0475n0 c0475n0, long j) {
        this.f734e = c0475n0;
        this.f735f = c0475n0.f834d;
        this.f732c = j;
    }
}
