package com.xiaomi.push;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.ss.android.update.UpdateDialogNewBase;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.service.C1784m;
import com.xiaomi.push.service.XMPushService;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.xiaomi.push.fg */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class AbstractC1608fg extends AbstractC1600ez {

    /* renamed from: a */
    protected Exception f1735a;

    /* renamed from: a */
    protected Socket f1736a;

    /* renamed from: b */
    protected XMPushService f1737b;

    /* renamed from: c */
    private int f1738c;

    /* renamed from: c */
    String f1739c;

    /* renamed from: d */
    private String f1740d;

    /* renamed from: e */
    protected volatile long f1741e;

    /* renamed from: f */
    protected volatile long f1742f;

    /* renamed from: g */
    protected volatile long f1743g;

    /* renamed from: h */
    private long f1744h;

    /* renamed from: a */
    protected abstract void mo2490a(boolean z);

    public AbstractC1608fg(XMPushService xMPushService, C1602fa c1602fa) {
        super(xMPushService, c1602fa);
        this.f1735a = null;
        this.f1739c = null;
        this.f1741e = 0L;
        this.f1742f = 0L;
        this.f1743g = 0L;
        this.f1744h = 0L;
        this.f1737b = xMPushService;
    }

    /* renamed from: a */
    public Context m2550a() {
        return this.f1737b;
    }

    @Override // com.xiaomi.push.AbstractC1600ez
    /* renamed from: b */
    public void mo2520b(boolean z) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        final long currentTimeMillis = System.currentTimeMillis();
        mo2490a(z);
        C1784m.m3872a(this.f1737b).m3898c();
        if (z) {
            return;
        }
        this.f1737b.m3549a(new XMPushService.AbstractC1731j(13) { // from class: com.xiaomi.push.fg.1
            @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
            /* renamed from: a */
            public void mo2390a() {
                Thread.yield();
                if (!AbstractC1608fg.this.m2555c() || AbstractC1608fg.this.m2512a(elapsedRealtime)) {
                    return;
                }
                C1784m.m3872a(AbstractC1608fg.this.f1737b).m3897b();
                AbstractC1608fg.this.f1737b.m3546a(22, (Exception) null);
            }

            @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
            /* renamed from: a */
            public String mo2389a() {
                return "check the ping-pong." + currentTimeMillis;
            }
        }, 10000L);
    }

    /* renamed from: c */
    public String m2555c() {
        return this.f1703a;
    }

    @Override // com.xiaomi.push.AbstractC1600ez
    /* renamed from: a */
    public String mo2505a() {
        return this.f1740d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public synchronized void mo2485a(int i, Exception exc) {
        if (m2513b() == 2) {
            return;
        }
        m2507a(2, i, exc);
        this.f1703a = "";
        try {
            this.f1736a.close();
        } catch (Throwable unused) {
        }
        this.f1741e = 0L;
        this.f1742f = 0L;
    }

    @Override // com.xiaomi.push.AbstractC1600ez
    /* renamed from: b */
    public void mo2516b(int i, Exception exc) {
        mo2485a(i, exc);
        if ((exc != null || i == 18) && this.f1743g != 0) {
            m2553a(exc);
        }
    }

    /* renamed from: a */
    protected void m2553a(Exception exc) {
        if (SystemClock.elapsedRealtime() - this.f1743g < Constants.ASSEMBLE_PUSH_NETWORK_INTERVAL) {
            if (C1486at.m1545a((Context) this.f1737b)) {
                int i = this.f1738c + 1;
                this.f1738c = i;
                if (i >= 2) {
                    String mo2505a = mo2505a();
                    AbstractC1417b.m1089a("max short conn time reached, sink down current host:" + mo2505a);
                    m2554a(mo2505a, 0L, exc);
                    this.f1738c = 0;
                    return;
                }
                return;
            }
            return;
        }
        this.f1738c = 0;
    }

    /* renamed from: a */
    protected void m2554a(String str, long j, Exception exc) {
        C1522cb m1823a = C1526cf.m1812a().m1823a(C1602fa.m2530a(), false);
        if (m1823a != null) {
            m1823a.m1797b(str, j, 0L, exc);
            C1526cf.m1812a().m1836c();
        }
    }

    @Override // com.xiaomi.push.AbstractC1600ez
    /* renamed from: a */
    public void mo2491a(C1591eq[] c1591eqArr) {
        throw new C1609fh("Don't support send Blob");
    }

    /* renamed from: a */
    private void m2548a(C1602fa c1602fa) {
        m2549a(c1602fa.m2539c(), c1602fa.m2533a());
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x028c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0290 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x028c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01b5  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m2549a(String str, int i) {
        StringBuilder sb;
        long j;
        int i2;
        String str2;
        boolean z;
        Iterator<String> it;
        String str3;
        C1522cb c1522cb;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        boolean z2;
        this.f1735a = null;
        ArrayList<String> arrayList = new ArrayList<>();
        int intValue = AbstractC1417b.m1077a("get bucket for host : " + str).intValue();
        C1522cb m2551a = m2551a(str);
        AbstractC1417b.m1088a(Integer.valueOf(intValue));
        if (m2551a != null) {
            arrayList = m2551a.mo1782a(true);
        }
        C1522cb m1837d = C1526cf.m1812a().m1837d(str);
        if (m1837d != null) {
            Iterator<String> it2 = m1837d.mo1782a(true).iterator();
            while (it2.hasNext()) {
                String next = it2.next();
                if (arrayList.indexOf(next) == -1) {
                    arrayList.add(next);
                }
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(str);
        }
        long j2 = 0;
        this.f1743g = 0L;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        String m1535a = C1486at.m1535a((Context) this.f1737b);
        StringBuilder sb2 = new StringBuilder();
        Iterator<String> it3 = arrayList.iterator();
        String str9 = "";
        int i3 = 0;
        while (it3.hasNext()) {
            String next2 = it3.next();
            long currentTimeMillis = System.currentTimeMillis();
            this.f1698a++;
            int i4 = i3 + 1;
            try {
                AbstractC1417b.m1089a("begin to connect to " + next2);
                this.f1736a = m2552a();
                this.f1736a.connect(C1524cd.m1808a(next2, i), 8000);
                AbstractC1417b.m1089a("tcp connected");
            } catch (Exception e) {
                e = e;
                it = it3;
                sb = sb2;
                c1522cb = m2551a;
            } catch (Throwable th) {
                th = th;
                it = it3;
                sb = sb2;
                str3 = m1535a;
                c1522cb = m2551a;
            }
            try {
                this.f1736a.setTcpNoDelay(true);
                this.f1740d = next2;
                mo2484a();
                this.f1699a = System.currentTimeMillis() - currentTimeMillis;
                this.f1709b = m1535a;
                if (m2551a != null) {
                    it = it3;
                    sb = sb2;
                    str3 = m1535a;
                    z2 = true;
                    j = 0;
                    c1522cb = m2551a;
                    try {
                        m2551a.m1796b(next2, this.f1699a, 0L);
                    } catch (Exception e2) {
                        e = e2;
                        str4 = str9;
                        str5 = str3;
                        try {
                            this.f1735a = e;
                            AbstractC1417b.m1103d("SMACK: Could not connect to:" + next2);
                            sb.append("SMACK: Could not connect to ").append(next2).append(" port:").append(i).append(" err:").append(this.f1735a.getClass().getSimpleName()).append(UpdateDialogNewBase.TYPE);
                            str2 = !TextUtils.isEmpty(str4) ? next2 : str4 + "|" + next2;
                            C1589eo.m2420a(next2, this.f1735a);
                            if (c1522cb == null) {
                                str7 = str5;
                                c1522cb.m1797b(next2, System.currentTimeMillis() - currentTimeMillis, 0L, this.f1735a);
                            } else {
                                str7 = str5;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            AbstractC1417b.m1103d("SMACK: Could not connect to:" + next2);
                            sb.append("SMACK: Could not connect to ").append(next2).append(" port:").append(i).append(" err:").append(this.f1735a.getClass().getSimpleName()).append(UpdateDialogNewBase.TYPE);
                            if (!TextUtils.isEmpty(str4)) {
                            }
                            C1589eo.m2420a(next2, this.f1735a);
                            if (c1522cb == null) {
                            }
                            if (!TextUtils.equals(str8, C1486at.m1535a((Context) this.f1737b))) {
                            }
                        }
                        if (TextUtils.equals(str7, C1486at.m1535a((Context) this.f1737b))) {
                            i2 = i4;
                            z = false;
                            C1526cf.m1812a().m1836c();
                            int elapsedRealtime2 = (int) (SystemClock.elapsedRealtime() - elapsedRealtime);
                            if (z) {
                            }
                        } else {
                            str9 = str2;
                            sb2 = sb;
                            m1535a = str7;
                            i3 = i4;
                            it3 = it;
                            j2 = j;
                            m2551a = c1522cb;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            this.f1735a = new Exception("abnormal exception", th);
                            AbstractC1417b.m1093a(th);
                            AbstractC1417b.m1103d("SMACK: Could not connect to:" + next2);
                            sb.append("SMACK: Could not connect to ").append(next2).append(" port:").append(i).append(" err:").append(this.f1735a.getClass().getSimpleName()).append(UpdateDialogNewBase.TYPE);
                            str2 = !TextUtils.isEmpty(str9) ? next2 : str9 + "|" + next2;
                            C1589eo.m2420a(next2, this.f1735a);
                            if (c1522cb != null) {
                                c1522cb.m1797b(next2, System.currentTimeMillis() - currentTimeMillis, 0L, this.f1735a);
                            }
                            str6 = str3;
                        } catch (Throwable th4) {
                            th = th4;
                            str4 = str9;
                            str5 = str3;
                            AbstractC1417b.m1103d("SMACK: Could not connect to:" + next2);
                            sb.append("SMACK: Could not connect to ").append(next2).append(" port:").append(i).append(" err:").append(this.f1735a.getClass().getSimpleName()).append(UpdateDialogNewBase.TYPE);
                            String str10 = !TextUtils.isEmpty(str4) ? next2 : str4 + "|" + next2;
                            C1589eo.m2420a(next2, this.f1735a);
                            if (c1522cb == null) {
                                str8 = str5;
                                c1522cb.m1797b(next2, System.currentTimeMillis() - currentTimeMillis, 0L, this.f1735a);
                            } else {
                                str8 = str5;
                            }
                            if (!TextUtils.equals(str8, C1486at.m1535a((Context) this.f1737b))) {
                                throw th;
                            }
                            str2 = str10;
                            i2 = i4;
                            z = false;
                            C1526cf.m1812a().m1836c();
                            int elapsedRealtime22 = (int) (SystemClock.elapsedRealtime() - elapsedRealtime);
                            if (z) {
                            }
                        }
                        if (TextUtils.equals(str6, C1486at.m1535a((Context) this.f1737b))) {
                            i2 = i4;
                            z = false;
                            C1526cf.m1812a().m1836c();
                            int elapsedRealtime222 = (int) (SystemClock.elapsedRealtime() - elapsedRealtime);
                            if (z) {
                            }
                        } else {
                            str7 = str6;
                            str9 = str2;
                            sb2 = sb;
                            m1535a = str7;
                            i3 = i4;
                            it3 = it;
                            j2 = j;
                            m2551a = c1522cb;
                        }
                    }
                } else {
                    it = it3;
                    sb = sb2;
                    str3 = m1535a;
                    c1522cb = m2551a;
                    z2 = true;
                    j = 0;
                }
                this.f1743g = SystemClock.elapsedRealtime();
                AbstractC1417b.m1089a("connected to " + next2 + " in " + this.f1699a);
                str2 = str9;
                z = z2;
                i2 = i4;
                break;
            } catch (Exception e3) {
                e = e3;
                it = it3;
                sb = sb2;
                c1522cb = m2551a;
                j = 0;
                str4 = str9;
                str5 = m1535a;
                this.f1735a = e;
                AbstractC1417b.m1103d("SMACK: Could not connect to:" + next2);
                sb.append("SMACK: Could not connect to ").append(next2).append(" port:").append(i).append(" err:").append(this.f1735a.getClass().getSimpleName()).append(UpdateDialogNewBase.TYPE);
                if (!TextUtils.isEmpty(str4)) {
                }
                C1589eo.m2420a(next2, this.f1735a);
                if (c1522cb == null) {
                }
                if (TextUtils.equals(str7, C1486at.m1535a((Context) this.f1737b))) {
                }
            } catch (Throwable th5) {
                th = th5;
                it = it3;
                sb = sb2;
                str3 = m1535a;
                c1522cb = m2551a;
                j = 0;
                this.f1735a = new Exception("abnormal exception", th);
                AbstractC1417b.m1093a(th);
                AbstractC1417b.m1103d("SMACK: Could not connect to:" + next2);
                sb.append("SMACK: Could not connect to ").append(next2).append(" port:").append(i).append(" err:").append(this.f1735a.getClass().getSimpleName()).append(UpdateDialogNewBase.TYPE);
                if (!TextUtils.isEmpty(str9)) {
                }
                C1589eo.m2420a(next2, this.f1735a);
                if (c1522cb != null) {
                }
                str6 = str3;
                if (TextUtils.equals(str6, C1486at.m1535a((Context) this.f1737b))) {
                }
            }
        }
        sb = sb2;
        j = j2;
        i2 = i3;
        str2 = str9;
        z = false;
        C1526cf.m1812a().m1836c();
        int elapsedRealtime2222 = (int) (SystemClock.elapsedRealtime() - elapsedRealtime);
        if (z) {
            if (this.f1744h == j || SystemClock.elapsedRealtime() - this.f1744h > 480000) {
                this.f1744h = SystemClock.elapsedRealtime();
                C1589eo.m2416a(0, EnumC1582eh.BATCH_TCP_CONN_FAIL.m2346a(), elapsedRealtime2222, str2, C1486at.m1547b(this.f1737b.getApplicationContext()) ? 1 : 0);
            }
            throw new C1609fh(sb.toString());
        }
        C1589eo.m2416a(0, EnumC1582eh.BATCH_TCP_CONN_SUCCESS.m2346a(), elapsedRealtime2222, str2, i2);
    }

    /* renamed from: a */
    protected synchronized void mo2484a() {
    }

    /* renamed from: e */
    public synchronized void m2557e() {
        try {
            if (!m2555c() && !m2513b()) {
                m2507a(0, 0, (Exception) null);
                m2548a(this.f1700a);
                return;
            }
            AbstractC1417b.m1089a("WARNING: current xmpp has connected");
        } catch (IOException e) {
            throw new C1609fh(e);
        }
    }

    /* renamed from: c */
    public void m2556c(final int i, final Exception exc) {
        C1486at.m1546b();
        this.f1737b.m3548a(new XMPushService.AbstractC1731j(2) { // from class: com.xiaomi.push.fg.2
            @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
            /* renamed from: a */
            public void mo2390a() {
                AbstractC1608fg.this.f1737b.m3546a(i, exc);
            }

            @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
            /* renamed from: a */
            public String mo2389a() {
                return "shutdown the connection. " + i + ", " + exc;
            }
        });
    }

    /* renamed from: a */
    public Socket m2552a() {
        return new Socket();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public C1522cb m2551a(final String str) {
        C1522cb m1823a = C1526cf.m1812a().m1823a(str, false);
        if (!m1823a.mo1798b()) {
            C1625fx.m2653a(new Runnable() { // from class: com.xiaomi.push.fg.3
                @Override // java.lang.Runnable
                public void run() {
                    C1526cf.m1812a().m1823a(str, true);
                }
            });
        }
        return m1823a;
    }

    /* renamed from: f */
    public void m2558f() {
        this.f1741e = SystemClock.elapsedRealtime();
    }

    /* renamed from: g */
    public void m2559g() {
        this.f1742f = SystemClock.elapsedRealtime();
    }
}
