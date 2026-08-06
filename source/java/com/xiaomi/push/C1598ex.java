package com.xiaomi.push;

import android.os.SystemClock;
import android.text.TextUtils;
import com.vivo.push.PushClient;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.AbstractC1600ez;
import com.xiaomi.push.C1562do;
import com.xiaomi.push.service.AbstractC1776e;
import com.xiaomi.push.service.C1755am;
import com.xiaomi.push.service.C1760ar;
import com.xiaomi.push.service.C1765aw;
import com.xiaomi.push.service.C1766ax;
import com.xiaomi.push.service.XMPushService;
import java.util.Iterator;

/* renamed from: com.xiaomi.push.ex */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1598ex extends AbstractC1608fg {

    /* renamed from: a */
    private C1593es f1680a;

    /* renamed from: a */
    private C1594et f1681a;

    /* renamed from: a */
    private Thread f1682a;

    /* renamed from: a */
    private byte[] f1683a;

    @Override // com.xiaomi.push.AbstractC1600ez
    /* renamed from: a */
    public boolean mo2492a() {
        return true;
    }

    public C1598ex(XMPushService xMPushService, C1602fa c1602fa) {
        super(xMPushService, c1602fa);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized byte[] m2493a() {
        if (this.f1683a == null && !TextUtils.isEmpty(this.f1703a)) {
            String m3769a = C1766ax.m3769a();
            this.f1683a = C1760ar.m3747a(this.f1703a.getBytes(), (this.f1703a.substring(this.f1703a.length() / 2) + m3769a.substring(m3769a.length() / 2)).getBytes());
        }
        return this.f1683a;
    }

    /* renamed from: a */
    private C1591eq m2481a(boolean z) {
        C1597ew c1597ew = new C1597ew();
        if (z) {
            c1597ew.m2437a(PushClient.DEFAULT_REQUEST_ID);
        }
        byte[] m2421a = C1589eo.m2421a();
        if (m2421a != null) {
            C1562do.j jVar = new C1562do.j();
            jVar.m2236a(C1466a.m1433a(m2421a));
            c1597ew.m2440a(jVar.mo2060a(), (String) null);
        }
        return c1597ew;
    }

    @Override // com.xiaomi.push.AbstractC1608fg
    /* renamed from: a */
    protected void mo2490a(boolean z) {
        if (this.f1681a != null) {
            C1591eq m2481a = m2481a(z);
            AbstractC1417b.m1089a("[Slim] SND ping id=" + m2481a.m2455e());
            mo2494b(m2481a);
            m2558f();
            return;
        }
        throw new C1609fh("The BlobWriter is null.");
    }

    @Override // com.xiaomi.push.AbstractC1600ez
    /* renamed from: a */
    public synchronized void mo2488a(C1755am.b bVar) {
        C1590ep.m2424a(bVar, m2555c(), this);
    }

    @Override // com.xiaomi.push.AbstractC1600ez
    /* renamed from: a */
    public synchronized void mo2489a(String str, String str2) {
        C1590ep.m2425a(str, str2, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaomi.push.AbstractC1608fg
    /* renamed from: a */
    public synchronized void mo2485a(int i, Exception exc) {
        C1593es c1593es = this.f1680a;
        if (c1593es != null) {
            c1593es.m2464b();
            this.f1680a = null;
        }
        C1594et c1594et = this.f1681a;
        if (c1594et != null) {
            try {
                c1594et.m2467b();
            } catch (Exception e) {
                AbstractC1417b.m1103d("SlimConnection shutdown cause exception: " + e);
            }
            this.f1681a = null;
        }
        this.f1683a = null;
        super.mo2485a(i, exc);
    }

    @Override // com.xiaomi.push.AbstractC1608fg, com.xiaomi.push.AbstractC1600ez
    /* renamed from: a */
    public void mo2491a(C1591eq[] c1591eqArr) {
        for (C1591eq c1591eq : c1591eqArr) {
            mo2494b(c1591eq);
        }
    }

    @Override // com.xiaomi.push.AbstractC1600ez
    @Deprecated
    /* renamed from: a */
    public void mo2487a(AbstractC1615fn abstractC1615fn) {
        mo2494b(C1591eq.m2426a(abstractC1615fn, (String) null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xiaomi.push.AbstractC1608fg
    /* renamed from: a */
    public synchronized void mo2484a() {
        m2483h();
        this.f1681a.m2466a();
    }

    /* renamed from: h */
    private void m2483h() {
        try {
            this.f1680a = new C1593es(this.f1736a.getInputStream(), this);
            this.f1681a = new C1594et(this.f1736a.getOutputStream(), this);
            Thread thread = new Thread("Blob Reader (" + this.f1707b + ")") { // from class: com.xiaomi.push.ex.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        C1598ex.this.f1680a.m2463a();
                    } catch (Exception e) {
                        C1598ex.this.m2556c(9, e);
                    }
                }
            };
            this.f1682a = thread;
            thread.start();
        } catch (Exception e) {
            throw new C1609fh("Error to init reader and writer", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m2495b(AbstractC1615fn abstractC1615fn) {
        if (abstractC1615fn == null) {
            return;
        }
        Iterator<AbstractC1600ez.a> it = this.f1706a.values().iterator();
        while (it.hasNext()) {
            it.next().m2526a(abstractC1615fn);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m2486a(C1591eq c1591eq) {
        if (c1591eq == null) {
            return;
        }
        if (AbstractC1776e.m3828a(c1591eq)) {
            C1591eq c1591eq2 = new C1591eq();
            c1591eq2.m2434a(c1591eq.m2429a());
            c1591eq2.m2438a("SYNC", "ACK_RTT");
            c1591eq2.m2437a(c1591eq.m2455e());
            c1591eq2.m2447b(c1591eq.m2445b());
            c1591eq2.m2435a(c1591eq.m2451c());
            this.f1702a.m3548a(new C1765aw(this.f1702a, c1591eq2));
        }
        if (c1591eq.m2441a()) {
            AbstractC1417b.m1089a("[Slim] RCV blob chid=" + c1591eq.m2429a() + "; id=" + c1591eq.m2455e() + "; errCode=" + c1591eq.m2444b() + "; err=" + c1591eq.m2452c());
        }
        if (c1591eq.m2429a() == 0) {
            if ("PING".equals(c1591eq.m2431a())) {
                AbstractC1417b.m1089a("[Slim] RCV ping id=" + c1591eq.m2455e());
                m2559g();
            } else if ("CLOSE".equals(c1591eq.m2431a())) {
                m2556c(13, null);
            }
        }
        Iterator<AbstractC1600ez.a> it = this.f1706a.values().iterator();
        while (it.hasNext()) {
            it.next().m2525a(c1591eq);
        }
    }

    @Override // com.xiaomi.push.AbstractC1600ez
    /* renamed from: b */
    public void mo2494b(C1591eq c1591eq) {
        C1594et c1594et = this.f1681a;
        if (c1594et != null) {
            try {
                int m2465a = c1594et.m2465a(c1591eq);
                this.f1713d = SystemClock.elapsedRealtime();
                String m2456f = c1591eq.m2456f();
                if (!TextUtils.isEmpty(m2456f)) {
                    C1626fy.m2663a(this.f1702a, m2456f, m2465a, false, true, System.currentTimeMillis());
                }
                Iterator<AbstractC1600ez.a> it = this.f1710b.values().iterator();
                while (it.hasNext()) {
                    it.next().m2525a(c1591eq);
                }
                return;
            } catch (Exception e) {
                throw new C1609fh(e);
            }
        }
        throw new C1609fh("the writer is null.");
    }
}
