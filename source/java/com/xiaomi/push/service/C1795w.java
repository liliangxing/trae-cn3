package com.xiaomi.push.service;

import android.content.Context;
import android.os.Messenger;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.AbstractC1600ez;
import com.xiaomi.push.AbstractC1615fn;
import com.xiaomi.push.C1479am;
import com.xiaomi.push.C1538cr;
import com.xiaomi.push.C1591eq;
import com.xiaomi.push.C1609fh;
import com.xiaomi.push.C1648gt;
import com.xiaomi.push.C1656ha;
import com.xiaomi.push.C1659hd;
import com.xiaomi.push.C1670ho;
import com.xiaomi.push.C1675ht;
import com.xiaomi.push.EnumC1633ge;
import com.xiaomi.push.EnumC1643go;
import com.xiaomi.push.InterfaceC1671hp;
import com.xiaomi.push.service.C1755am;
import com.xiaomi.push.service.C1767ay;
import java.nio.ByteBuffer;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.xiaomi.push.service.w */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1795w {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m4031a(XMPushService xMPushService) {
        C1787p m3955a = C1788q.m3955a(xMPushService.getApplicationContext());
        if (m3955a != null) {
            C1755am.b m3952a = C1788q.m3955a(xMPushService.getApplicationContext()).m3952a(xMPushService);
            AbstractC1417b.m1089a("prepare account. " + m3952a.f2995a);
            m4033a(xMPushService, m3952a);
            C1755am.m3702a().m3713a(m3952a);
            m4034a(xMPushService, m3955a, 172800);
        }
    }

    /* renamed from: a */
    private static void m4034a(final XMPushService xMPushService, final C1787p c1787p, int i) {
        C1767ay.m3783a(xMPushService).m3787a(new C1767ay.a("MSAID", i) { // from class: com.xiaomi.push.service.w.1
            @Override // com.xiaomi.push.service.C1767ay.a
            /* renamed from: a */
            void mo3789a(C1767ay c1767ay) {
                C1479am m1501a = C1479am.m1501a(xMPushService);
                String m3786a = c1767ay.m3786a("MSAID", "msaid");
                String mo1482a = m1501a.mo1482a();
                if (TextUtils.isEmpty(mo1482a) || TextUtils.equals(m3786a, mo1482a)) {
                    return;
                }
                c1767ay.m3788a("MSAID", "msaid", mo1482a);
                C1659hd c1659hd = new C1659hd();
                c1659hd.m3060b(c1787p.f3199d);
                c1659hd.m3064c(EnumC1643go.ClientInfoUpdate.f2208a);
                c1659hd.m3047a(C1752aj.m3692a());
                c1659hd.m3049a(new HashMap());
                m1501a.m1504a(c1659hd.m3053a());
                byte[] m3313a = C1670ho.m3313a(C1795w.m4027a(xMPushService.getPackageName(), c1787p.f3199d, c1659hd, EnumC1633ge.Notification));
                XMPushService xMPushService2 = xMPushService;
                xMPushService2.m3553a(xMPushService2.getPackageName(), m3313a, true);
            }
        });
    }

    /* renamed from: a */
    private static String m4029a(C1656ha c1656ha) {
        if (c1656ha.f2438a != null && c1656ha.f2438a.f2285b != null) {
            String str = c1656ha.f2438a.f2285b.get("ext_traffic_source_pkg");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return c1656ha.f2444b;
    }

    /* renamed from: a */
    static C1591eq m4025a(C1787p c1787p, Context context, C1656ha c1656ha) {
        try {
            C1591eq c1591eq = new C1591eq();
            c1591eq.m2434a(5);
            c1591eq.m2454c(c1787p.f3196a);
            c1591eq.m2448b(m4029a(c1656ha));
            c1591eq.m2438a("SECMSG", "message");
            String str = c1787p.f3196a;
            c1656ha.f2439a.f2304a = str.substring(0, str.indexOf("@"));
            c1656ha.f2439a.f2308c = str.substring(str.indexOf("/") + 1);
            c1591eq.m2440a(C1670ho.m3313a(c1656ha), c1787p.f3198c);
            c1591eq.m2439a((short) 1);
            AbstractC1417b.m1089a("try send mi push message. packagename:" + c1656ha.f2444b + " action:" + c1656ha.f2437a);
            return c1591eq;
        } catch (NullPointerException e) {
            AbstractC1417b.m1093a(e);
            return null;
        }
    }

    /* renamed from: a */
    static C1591eq m4024a(XMPushService xMPushService, byte[] bArr) {
        C1656ha c1656ha = new C1656ha();
        try {
            C1670ho.m3312a(c1656ha, bArr);
            return m4025a(C1788q.m3955a((Context) xMPushService), xMPushService, c1656ha);
        } catch (C1675ht e) {
            AbstractC1417b.m1093a(e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static <T extends InterfaceC1671hp<T, ?>> C1656ha m4027a(String str, String str2, T t, EnumC1633ge enumC1633ge) {
        return m4028a(str, str2, t, enumC1633ge, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static <T extends InterfaceC1671hp<T, ?>> C1656ha m4037b(String str, String str2, T t, EnumC1633ge enumC1633ge) {
        return m4028a(str, str2, t, enumC1633ge, false);
    }

    /* renamed from: a */
    private static <T extends InterfaceC1671hp<T, ?>> C1656ha m4028a(String str, String str2, T t, EnumC1633ge enumC1633ge, boolean z) {
        byte[] m3313a = C1670ho.m3313a(t);
        C1656ha c1656ha = new C1656ha();
        C1648gt c1648gt = new C1648gt();
        c1648gt.f2303a = 5L;
        c1648gt.f2304a = "fakeid";
        c1656ha.m3013a(c1648gt);
        c1656ha.m3015a(ByteBuffer.wrap(m3313a));
        c1656ha.m3011a(enumC1633ge);
        c1656ha.m3024b(z);
        c1656ha.m3023b(str);
        c1656ha.m3016a(false);
        c1656ha.m3014a(str2);
        return c1656ha;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static C1656ha m4026a(String str, String str2) {
        C1659hd c1659hd = new C1659hd();
        c1659hd.m3060b(str2);
        c1659hd.m3064c("package uninstalled");
        c1659hd.m3047a(AbstractC1615fn.m2600i());
        c1659hd.m3050a(false);
        return m4027a(str, str2, c1659hd, EnumC1633ge.Notification);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static C1656ha m4036b(String str, String str2) {
        C1659hd c1659hd = new C1659hd();
        c1659hd.m3060b(str2);
        c1659hd.m3064c(EnumC1643go.AppDataCleared.f2208a);
        c1659hd.m3047a(C1752aj.m3692a());
        c1659hd.m3050a(false);
        return m4027a(str, str2, c1659hd, EnumC1633ge.Notification);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m4033a(final XMPushService xMPushService, C1755am.b bVar) {
        bVar.m3728a((Messenger) null);
        bVar.m3729a(new C1755am.b.a() { // from class: com.xiaomi.push.service.w.2
            @Override // com.xiaomi.push.service.C1755am.b.a
            /* renamed from: a */
            public void mo2388a(C1755am.c cVar, C1755am.c cVar2, int i) {
                if (cVar2 == C1755am.c.binded) {
                    C1792t.m3981a(XMPushService.this, true);
                    C1792t.m3980a(XMPushService.this);
                } else if (cVar2 == C1755am.c.unbind) {
                    AbstractC1417b.m1089a("onChange unbind");
                    C1792t.m3978a(XMPushService.this, ErrorCode.ERROR_SERVICE_UNAVAILABLE, " the push is not connected.");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m4035a(XMPushService xMPushService, String str, byte[] bArr) {
        C1538cr.m1929a(str, xMPushService.getApplicationContext(), bArr);
        AbstractC1600ez m3542a = xMPushService.m3542a();
        if (m3542a != null) {
            if (m3542a.mo2492a()) {
                C1591eq m4024a = m4024a(xMPushService, bArr);
                if (m4024a != null) {
                    m3542a.mo2494b(m4024a);
                    return;
                } else {
                    C1792t.m3979a(xMPushService, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "not a valid message");
                    return;
                }
            }
            throw new C1609fh("Don't support XMPP connection.");
        }
        throw new C1609fh("try send msg while connection is null.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m4032a(XMPushService xMPushService, C1656ha c1656ha) {
        C1538cr.m1927a(c1656ha.m3025b(), xMPushService.getApplicationContext(), c1656ha, -1);
        AbstractC1600ez m3542a = xMPushService.m3542a();
        if (m3542a != null) {
            if (m3542a.mo2492a()) {
                C1591eq m4025a = m4025a(C1788q.m3955a((Context) xMPushService), xMPushService, c1656ha);
                if (m4025a != null) {
                    m3542a.mo2494b(m4025a);
                    return;
                }
                return;
            }
            throw new C1609fh("Don't support XMPP connection.");
        }
        throw new C1609fh("try send msg while connection is null.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m4030a(String str) {
        return str + ".permission.MIPUSH_RECEIVE";
    }
}
