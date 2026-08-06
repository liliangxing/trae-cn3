package com.xiaomi.push;

import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.AbstractC1600ez;
import com.xiaomi.push.C1562do;
import com.xiaomi.push.service.C1752aj;
import com.xiaomi.push.service.C1755am;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/* renamed from: com.xiaomi.push.ey */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1599ey implements InterfaceC1610fi {

    /* renamed from: a */
    public static boolean f1685a;

    /* renamed from: a */
    private AbstractC1600ez f1687a;

    /* renamed from: a */
    private SimpleDateFormat f1690a = new SimpleDateFormat("hh:mm:ss aaa");

    /* renamed from: a */
    private a f1686a = null;

    /* renamed from: b */
    private a f1691b = null;

    /* renamed from: a */
    private InterfaceC1604fc f1688a = null;

    /* renamed from: a */
    private final String f1689a = "[Slim] ";

    public C1599ey(AbstractC1600ez abstractC1600ez) {
        this.f1687a = abstractC1600ez;
        m2499a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.push.ey$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class a implements InterfaceC1606fe, InterfaceC1611fj {

        /* renamed from: a */
        String f1694a;

        /* renamed from: a */
        private boolean f1695a;

        @Override // com.xiaomi.push.InterfaceC1611fj
        /* renamed from: a */
        public boolean mo1864a(AbstractC1615fn abstractC1615fn) {
            return true;
        }

        a(boolean z) {
            this.f1695a = z;
            this.f1694a = z ? " RCV " : " Sent ";
        }

        @Override // com.xiaomi.push.InterfaceC1606fe
        /* renamed from: a */
        public void mo1863a(AbstractC1615fn abstractC1615fn) {
            if (C1599ey.f1685a) {
                AbstractC1417b.m1101c("[Slim] " + C1599ey.this.f1690a.format(new Date()) + this.f1694a + " PKT " + abstractC1615fn.mo2575a());
            } else {
                AbstractC1417b.m1101c("[Slim] " + C1599ey.this.f1690a.format(new Date()) + this.f1694a + " PKT [" + abstractC1615fn.m2611k() + Constants.ACCEPT_TIME_SEPARATOR_SP + abstractC1615fn.m2610j() + "]");
            }
        }

        @Override // com.xiaomi.push.InterfaceC1606fe
        /* renamed from: a */
        public void mo1862a(C1591eq c1591eq) {
            if (C1599ey.f1685a) {
                AbstractC1417b.m1101c("[Slim] " + C1599ey.this.f1690a.format(new Date()) + this.f1694a + c1591eq.toString());
            } else {
                AbstractC1417b.m1101c("[Slim] " + C1599ey.this.f1690a.format(new Date()) + this.f1694a + " Blob [" + c1591eq.m2431a() + Constants.ACCEPT_TIME_SEPARATOR_SP + c1591eq.m2429a() + Constants.ACCEPT_TIME_SEPARATOR_SP + C1752aj.m3693a(c1591eq.m2455e()) + "]");
            }
            if (c1591eq == null || c1591eq.m2429a() != 99999) {
                return;
            }
            String m2431a = c1591eq.m2431a();
            C1591eq c1591eq2 = null;
            if (!this.f1695a) {
                if ("BIND".equals(m2431a)) {
                    AbstractC1417b.m1089a("build binded result for loopback.");
                    C1562do.d dVar = new C1562do.d();
                    dVar.m2152a(true);
                    dVar.m2158c("login success.");
                    dVar.m2155b("success");
                    dVar.m2151a("success");
                    C1591eq c1591eq3 = new C1591eq();
                    c1591eq3.m2440a(dVar.mo2060a(), (String) null);
                    c1591eq3.m2439a((short) 2);
                    c1591eq3.m2434a(99999);
                    c1591eq3.m2438a("BIND", (String) null);
                    c1591eq3.m2437a(c1591eq.m2455e());
                    c1591eq3.m2448b((String) null);
                    c1591eq3.m2454c(c1591eq.m2457g());
                    c1591eq2 = c1591eq3;
                } else if (!"UBND".equals(m2431a) && "SECMSG".equals(m2431a)) {
                    C1591eq c1591eq4 = new C1591eq();
                    c1591eq4.m2434a(99999);
                    c1591eq4.m2438a("SECMSG", (String) null);
                    c1591eq4.m2454c(c1591eq.m2457g());
                    c1591eq4.m2437a(c1591eq.m2455e());
                    c1591eq4.m2439a(c1591eq.m2433a());
                    c1591eq4.m2448b(c1591eq.m2456f());
                    c1591eq4.m2440a(c1591eq.m2443a(C1755am.m3702a().m3705a(String.valueOf(99999), c1591eq.m2457g()).f3006h), (String) null);
                    c1591eq2 = c1591eq4;
                }
            }
            if (c1591eq2 != null) {
                for (Map.Entry<InterfaceC1606fe, AbstractC1600ez.a> entry : C1599ey.this.f1687a.m2506a().entrySet()) {
                    if (C1599ey.this.f1686a != entry.getKey()) {
                        entry.getValue().m2525a(c1591eq2);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m2499a() {
        this.f1686a = new a(true);
        this.f1691b = new a(false);
        AbstractC1600ez abstractC1600ez = this.f1687a;
        a aVar = this.f1686a;
        abstractC1600ez.m2510a(aVar, aVar);
        AbstractC1600ez abstractC1600ez2 = this.f1687a;
        a aVar2 = this.f1691b;
        abstractC1600ez2.m2519b(aVar2, aVar2);
        this.f1688a = new InterfaceC1604fc() { // from class: com.xiaomi.push.ey.1
            @Override // com.xiaomi.push.InterfaceC1604fc
            /* renamed from: a */
            public void mo1920a(AbstractC1600ez abstractC1600ez3, int i, Exception exc) {
                AbstractC1417b.m1101c("[Slim] " + C1599ey.this.f1690a.format(new Date()) + " Connection closed (" + C1599ey.this.f1687a.hashCode() + ")");
            }

            @Override // com.xiaomi.push.InterfaceC1604fc
            /* renamed from: a */
            public void mo1921a(AbstractC1600ez abstractC1600ez3, Exception exc) {
                AbstractC1417b.m1101c("[Slim] " + C1599ey.this.f1690a.format(new Date()) + " Reconnection failed due to an exception (" + C1599ey.this.f1687a.hashCode() + ")");
                exc.printStackTrace();
            }

            @Override // com.xiaomi.push.InterfaceC1604fc
            /* renamed from: b */
            public void mo1922b(AbstractC1600ez abstractC1600ez3) {
                AbstractC1417b.m1101c("[Slim] " + C1599ey.this.f1690a.format(new Date()) + " Connection reconnected (" + C1599ey.this.f1687a.hashCode() + ")");
            }

            @Override // com.xiaomi.push.InterfaceC1604fc
            /* renamed from: a */
            public void mo1919a(AbstractC1600ez abstractC1600ez3) {
                AbstractC1417b.m1101c("[Slim] " + C1599ey.this.f1690a.format(new Date()) + " Connection started (" + C1599ey.this.f1687a.hashCode() + ")");
            }
        };
    }
}
