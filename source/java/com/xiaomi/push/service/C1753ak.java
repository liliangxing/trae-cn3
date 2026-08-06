package com.xiaomi.push.service;

import android.text.TextUtils;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.vivo.push.PushClient;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.AbstractC1615fn;
import com.xiaomi.push.C1522cb;
import com.xiaomi.push.C1526cf;
import com.xiaomi.push.C1548da;
import com.xiaomi.push.C1562do;
import com.xiaomi.push.C1589eo;
import com.xiaomi.push.C1591eq;
import com.xiaomi.push.C1602fa;
import com.xiaomi.push.C1612fk;
import com.xiaomi.push.C1613fl;
import com.xiaomi.push.C1614fm;
import com.xiaomi.push.C1626fy;
import com.xiaomi.push.EnumC1582eh;
import com.xiaomi.push.service.C1755am;
import java.util.Date;

/* renamed from: com.xiaomi.push.service.ak */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1753ak {

    /* renamed from: a */
    private XMPushService f2981a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1753ak(XMPushService xMPushService) {
        this.f2981a = xMPushService;
    }

    /* renamed from: a */
    public void m3699a(AbstractC1615fn abstractC1615fn) {
        if (!"5".equals(abstractC1615fn.m2611k())) {
            m3696b(abstractC1615fn);
        }
        String m2611k = abstractC1615fn.m2611k();
        if (TextUtils.isEmpty(m2611k)) {
            m2611k = PushClient.DEFAULT_REQUEST_ID;
            abstractC1615fn.m2614l(PushClient.DEFAULT_REQUEST_ID);
        }
        if (m2611k.equals("0")) {
            AbstractC1417b.m1089a("Received wrong packet with chid = 0 : " + abstractC1615fn.mo2575a());
        }
        if (abstractC1615fn instanceof C1613fl) {
            C1612fk m2602a = abstractC1615fn.m2602a("kick");
            if (m2602a != null) {
                String m2613l = abstractC1615fn.m2613l();
                String m2567a = m2602a.m2567a(DownloadSettingKeys.AhPlans.KEY_AH_PLAN_TYPE);
                String m2567a2 = m2602a.m2567a(BaseConstants.DownloadManager.COLUMN_REASON);
                AbstractC1417b.m1089a("kicked by server, chid=" + m2611k + " res=" + C1755am.b.m3719a(m2613l) + " type=" + m2567a + " reason=" + m2567a2);
                if ("wait".equals(m2567a)) {
                    C1755am.b m3705a = C1755am.m3702a().m3705a(m2611k, m2613l);
                    if (m3705a != null) {
                        this.f2981a.m3551a(m3705a);
                        m3705a.m3730a(C1755am.c.unbind, 3, 0, m2567a2, m2567a);
                        return;
                    }
                    return;
                }
                this.f2981a.m3552a(m2611k, m2613l, 3, m2567a2, m2567a);
                C1755am.m3702a().m3715a(m2611k, m2613l);
                return;
            }
        } else if (abstractC1615fn instanceof C1614fm) {
            C1614fm c1614fm = (C1614fm) abstractC1615fn;
            if ("redir".equals(c1614fm.m2583b())) {
                C1612fk a = c1614fm.m2580a("hosts");
                if (a != null) {
                    m3695a(a);
                    return;
                }
                return;
            }
        }
        this.f2981a.m3559b().m3858a(this.f2981a, m2611k, abstractC1615fn);
    }

    /* renamed from: a */
    public void m3698a(C1591eq c1591eq) {
        if (5 != c1591eq.m2429a()) {
            m3697c(c1591eq);
        }
        try {
            m3700b(c1591eq);
        } catch (Exception e) {
            AbstractC1417b.m1091a("handle Blob chid = " + c1591eq.m2429a() + " cmd = " + c1591eq.m2431a() + " packetid = " + c1591eq.m2455e() + " failure ", e);
        }
    }

    /* renamed from: b */
    public void m3700b(C1591eq c1591eq) {
        String m2431a = c1591eq.m2431a();
        if (c1591eq.m2429a() == 0) {
            if ("PING".equals(m2431a)) {
                byte[] m2442a = c1591eq.m2442a();
                if (m2442a != null && m2442a.length > 0) {
                    C1562do.j m2233a = C1562do.j.m2233a(m2442a);
                    if (m2233a.m2239b()) {
                        C1766ax.m3768a().m3779a(m2233a.m2235a());
                    }
                }
                if (!"com.xiaomi.xmsf".equals(this.f2981a.getPackageName())) {
                    this.f2981a.m3544a();
                }
                if (PushClient.DEFAULT_REQUEST_ID.equals(c1591eq.m2455e())) {
                    AbstractC1417b.m1089a("received a server ping");
                } else {
                    C1589eo.m2422b();
                }
                this.f2981a.m3560b();
                return;
            }
            if ("SYNC".equals(m2431a)) {
                if ("CONF".equals(c1591eq.m2446b())) {
                    C1766ax.m3768a().m3779a(C1562do.b.m2119a(c1591eq.m2442a()));
                    return;
                }
                if (TextUtils.equals("U", c1591eq.m2446b())) {
                    C1562do.k m2240a = C1562do.k.m2240a(c1591eq.m2442a());
                    C1548da.m2007a(this.f2981a).m2016a(m2240a.m2246a(), m2240a.m2251b(), new Date(m2240a.m2241a()), new Date(m2240a.m2248b()), m2240a.m2253c() * 1024, m2240a.m2256e());
                    C1591eq c1591eq2 = new C1591eq();
                    c1591eq2.m2434a(0);
                    c1591eq2.m2438a(c1591eq.m2431a(), "UCA");
                    c1591eq2.m2437a(c1591eq.m2455e());
                    this.f2981a.m3548a(new C1765aw(this.f2981a, c1591eq2));
                    return;
                }
                if (TextUtils.equals("P", c1591eq.m2446b())) {
                    C1562do.i m2229a = C1562do.i.m2229a(c1591eq.m2442a());
                    C1591eq c1591eq3 = new C1591eq();
                    c1591eq3.m2434a(0);
                    c1591eq3.m2438a(c1591eq.m2431a(), "PCA");
                    c1591eq3.m2437a(c1591eq.m2455e());
                    C1562do.i iVar = new C1562do.i();
                    if (m2229a.m2232a()) {
                        iVar.m2231a(m2229a.m2230a());
                    }
                    c1591eq3.m2440a(iVar.mo2060a(), (String) null);
                    this.f2981a.m3548a(new C1765aw(this.f2981a, c1591eq3));
                    AbstractC1417b.m1089a("ACK msgP: id = " + c1591eq.m2455e());
                    return;
                }
                return;
            }
            if ("NOTIFY".equals(c1591eq.m2431a())) {
                C1562do.h m2222a = C1562do.h.m2222a(c1591eq.m2442a());
                AbstractC1417b.m1089a("notify by server err = " + m2222a.m2228c() + " desc = " + m2222a.m2225a());
                return;
            }
            return;
        }
        String num = Integer.toString(c1591eq.m2429a());
        if ("SECMSG".equals(c1591eq.m2431a())) {
            if (!c1591eq.m2441a()) {
                this.f2981a.m3559b().m3857a(this.f2981a, num, c1591eq);
                return;
            } else {
                AbstractC1417b.m1089a("Recv SECMSG errCode = " + c1591eq.m2444b() + " errStr = " + c1591eq.m2452c());
                return;
            }
        }
        if ("BIND".equals(m2431a)) {
            C1562do.d m2150a = C1562do.d.m2150a(c1591eq.m2442a());
            String m2457g = c1591eq.m2457g();
            C1755am.b m3705a = C1755am.m3702a().m3705a(num, m2457g);
            if (m3705a == null) {
                return;
            }
            if (m2150a.m2154a()) {
                AbstractC1417b.m1089a("SMACK: channel bind succeeded, chid=" + c1591eq.m2429a());
                m3705a.m3730a(C1755am.c.binded, 1, 0, (String) null, (String) null);
                return;
            }
            String m2153a = m2150a.m2153a();
            if ("auth".equals(m2153a)) {
                if ("invalid-sig".equals(m2150a.m2156b())) {
                    AbstractC1417b.m1089a("SMACK: bind error invalid-sig token = " + m3705a.f3001c + " sec = " + m3705a.f3006h);
                    C1589eo.m2416a(0, EnumC1582eh.BIND_INVALID_SIG.m2346a(), 1, null, 0);
                }
                m3705a.m3730a(C1755am.c.unbind, 1, 5, m2150a.m2156b(), m2153a);
                C1755am.m3702a().m3715a(num, m2457g);
            } else if ("cancel".equals(m2153a)) {
                m3705a.m3730a(C1755am.c.unbind, 1, 7, m2150a.m2156b(), m2153a);
                C1755am.m3702a().m3715a(num, m2457g);
            } else if ("wait".equals(m2153a)) {
                this.f2981a.m3551a(m3705a);
                m3705a.m3730a(C1755am.c.unbind, 1, 7, m2150a.m2156b(), m2153a);
            }
            AbstractC1417b.m1089a("SMACK: channel bind failed, chid=" + num + " reason=" + m2150a.m2156b());
            return;
        }
        if ("KICK".equals(m2431a)) {
            C1562do.g m2212a = C1562do.g.m2212a(c1591eq.m2442a());
            String m2457g2 = c1591eq.m2457g();
            String m2214a = m2212a.m2214a();
            String m2217b = m2212a.m2217b();
            AbstractC1417b.m1089a("kicked by server, chid=" + num + " res= " + C1755am.b.m3719a(m2457g2) + " type=" + m2214a + " reason=" + m2217b);
            if ("wait".equals(m2214a)) {
                C1755am.b m3705a2 = C1755am.m3702a().m3705a(num, m2457g2);
                if (m3705a2 != null) {
                    this.f2981a.m3551a(m3705a2);
                    m3705a2.m3730a(C1755am.c.unbind, 3, 0, m2217b, m2214a);
                    return;
                }
                return;
            }
            this.f2981a.m3552a(num, m2457g2, 3, m2217b, m2214a);
            C1755am.m3702a().m3715a(num, m2457g2);
        }
    }

    /* renamed from: b */
    private void m3696b(AbstractC1615fn abstractC1615fn) {
        C1755am.b m3705a;
        String m2613l = abstractC1615fn.m2613l();
        String m2611k = abstractC1615fn.m2611k();
        if (TextUtils.isEmpty(m2613l) || TextUtils.isEmpty(m2611k) || (m3705a = C1755am.m3702a().m3705a(m2611k, m2613l)) == null) {
            return;
        }
        C1626fy.m2663a(this.f2981a, m3705a.f2995a, C1626fy.m2655a(abstractC1615fn.mo2575a()), true, true, System.currentTimeMillis());
    }

    /* renamed from: c */
    private void m3697c(C1591eq c1591eq) {
        C1755am.b m3705a;
        String m2457g = c1591eq.m2457g();
        String num = Integer.toString(c1591eq.m2429a());
        if (TextUtils.isEmpty(m2457g) || TextUtils.isEmpty(num) || (m3705a = C1755am.m3702a().m3705a(num, m2457g)) == null) {
            return;
        }
        C1626fy.m2663a(this.f2981a, m3705a.f2995a, c1591eq.mo2450c(), true, true, System.currentTimeMillis());
    }

    /* renamed from: a */
    private void m3695a(C1612fk c1612fk) {
        String m2571c = c1612fk.m2571c();
        if (TextUtils.isEmpty(m2571c)) {
            return;
        }
        String[] split = m2571c.split(";");
        C1522cb m1823a = C1526cf.m1812a().m1823a(C1602fa.m2530a(), false);
        if (m1823a == null || split.length <= 0) {
            return;
        }
        m1823a.m1792a(split);
        this.f2981a.m3546a(20, (Exception) null);
        this.f2981a.m3554a(true);
    }
}
