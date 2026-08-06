package com.xiaomi.push;

import android.content.Context;
import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.service.XMPushService;

/* renamed from: com.xiaomi.push.em */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1587em implements InterfaceC1604fc {

    /* renamed from: a */
    private int f1624a;

    /* renamed from: a */
    AbstractC1600ez f1626a;

    /* renamed from: a */
    XMPushService f1627a;

    /* renamed from: a */
    private Exception f1628a;

    /* renamed from: e */
    private long f1633e;

    /* renamed from: f */
    private long f1634f;

    /* renamed from: a */
    private long f1625a = 0;

    /* renamed from: b */
    private long f1630b = 0;

    /* renamed from: c */
    private long f1631c = 0;

    /* renamed from: d */
    private long f1632d = 0;

    /* renamed from: a */
    private String f1629a = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1587em(XMPushService xMPushService) {
        this.f1633e = 0L;
        this.f1634f = 0L;
        this.f1627a = xMPushService;
        m2396b();
        int myUid = Process.myUid();
        try {
            this.f1634f = TrafficStats.getUidRxBytes(myUid);
            this.f1633e = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e) {
            AbstractC1417b.m1089a("Failed to obtain traffic data during initialization: " + e);
            this.f1634f = -1L;
            this.f1633e = -1L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public Exception m2398a() {
        return this.f1628a;
    }

    /* renamed from: a */
    public synchronized void m2399a() {
        XMPushService xMPushService = this.f1627a;
        if (xMPushService == null) {
            return;
        }
        String m1535a = C1486at.m1535a((Context) xMPushService);
        boolean m1547b = C1486at.m1547b(this.f1627a);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.f1625a;
        if (j > 0) {
            this.f1630b += elapsedRealtime - j;
            this.f1625a = 0L;
        }
        long j2 = this.f1631c;
        if (j2 != 0) {
            this.f1632d += elapsedRealtime - j2;
            this.f1631c = 0L;
        }
        if (m1547b) {
            if ((!TextUtils.equals(this.f1629a, m1535a) && this.f1630b > 30000) || this.f1630b > 5400000) {
                m2397c();
            }
            this.f1629a = m1535a;
            if (this.f1625a == 0) {
                this.f1625a = elapsedRealtime;
            }
            if (this.f1627a.m3563c()) {
                this.f1631c = elapsedRealtime;
            }
        }
    }

    /* renamed from: b */
    private void m2396b() {
        this.f1630b = 0L;
        this.f1632d = 0L;
        this.f1625a = 0L;
        this.f1631c = 0L;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (C1486at.m1545a((Context) this.f1627a)) {
            this.f1625a = elapsedRealtime;
        }
        if (this.f1627a.m3563c()) {
            this.f1631c = elapsedRealtime;
        }
    }

    /* renamed from: c */
    private synchronized void m2397c() {
        AbstractC1417b.m1101c("stat connpt = " + this.f1629a + " netDuration = " + this.f1630b + " ChannelDuration = " + this.f1632d + " channelConnectedTime = " + this.f1631c);
        C1583ei c1583ei = new C1583ei();
        c1583ei.f1596a = (byte) 0;
        c1583ei.m2349a(EnumC1582eh.CHANNEL_ONLINE_RATE.m2346a());
        c1583ei.m2350a(this.f1629a);
        c1583ei.m2365d((int) (System.currentTimeMillis() / 1000));
        c1583ei.m2356b((int) (this.f1630b / 1000));
        c1583ei.m2361c((int) (this.f1632d / 1000));
        C1588en.m2403a().m2408a(c1583ei);
        m2396b();
    }

    @Override // com.xiaomi.push.InterfaceC1604fc
    /* renamed from: a */
    public void mo1919a(AbstractC1600ez abstractC1600ez) {
        this.f1624a = 0;
        this.f1628a = null;
        this.f1626a = abstractC1600ez;
        this.f1629a = C1486at.m1535a((Context) this.f1627a);
        C1589eo.m2415a(0, EnumC1582eh.CONN_SUCCESS.m2346a());
    }

    @Override // com.xiaomi.push.InterfaceC1604fc
    /* renamed from: a */
    public void mo1920a(AbstractC1600ez abstractC1600ez, int i, Exception exc) {
        long j;
        long j2;
        if (this.f1624a == 0 && this.f1628a == null) {
            this.f1624a = i;
            this.f1628a = exc;
            C1589eo.m2423b(abstractC1600ez.mo2505a(), exc);
        }
        if (i == 22 && this.f1631c != 0) {
            long m2503a = abstractC1600ez.m2503a() - this.f1631c;
            if (m2503a < 0) {
                m2503a = 0;
            }
            this.f1632d += m2503a + (C1607ff.m2547b() / 2);
            this.f1631c = 0L;
        }
        m2399a();
        int myUid = Process.myUid();
        try {
            j = TrafficStats.getUidRxBytes(myUid);
            j2 = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e) {
            AbstractC1417b.m1089a("Failed to obtain traffic data: " + e);
            j = -1;
            j2 = -1;
        }
        AbstractC1417b.m1101c("Stats rx=" + (j - this.f1634f) + ", tx=" + (j2 - this.f1633e));
        this.f1634f = j;
        this.f1633e = j2;
    }

    @Override // com.xiaomi.push.InterfaceC1604fc
    /* renamed from: b */
    public void mo1922b(AbstractC1600ez abstractC1600ez) {
        m2399a();
        this.f1631c = SystemClock.elapsedRealtime();
        C1589eo.m2417a(0, EnumC1582eh.CONN_SUCCESS.m2346a(), abstractC1600ez.mo2505a(), abstractC1600ez.m2502a());
    }

    @Override // com.xiaomi.push.InterfaceC1604fc
    /* renamed from: a */
    public void mo1921a(AbstractC1600ez abstractC1600ez, Exception exc) {
        C1589eo.m2416a(0, EnumC1582eh.CHANNEL_CON_FAIL.m2346a(), 1, abstractC1600ez.mo2505a(), C1486at.m1547b(this.f1627a) ? 1 : 0);
        m2399a();
    }
}
