package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.ttm.player.UnifiedCodec.codec.CodecError;
import com.vivo.push.PushClient;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.AbstractC1615fn;
import com.xiaomi.push.C1538cr;
import com.xiaomi.push.C1566ds;
import com.xiaomi.push.C1591eq;
import com.xiaomi.push.C1609fh;
import com.xiaomi.push.C1612fk;
import com.xiaomi.push.C1614fm;
import com.xiaomi.push.C1626fy;
import com.xiaomi.push.C1628g;
import com.xiaomi.push.C1646gr;
import com.xiaomi.push.C1649gu;
import com.xiaomi.push.C1650gv;
import com.xiaomi.push.C1656ha;
import com.xiaomi.push.C1659hd;
import com.xiaomi.push.C1661hf;
import com.xiaomi.push.C1670ho;
import com.xiaomi.push.C1675ht;
import com.xiaomi.push.C1682i;
import com.xiaomi.push.C1694j;
import com.xiaomi.push.EnumC1633ge;
import com.xiaomi.push.EnumC1643go;
import com.xiaomi.push.InterfaceC1671hp;
import com.xiaomi.push.service.C1755am;
import com.xiaomi.push.service.C1796x;
import com.xiaomi.push.service.XMPushService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.xiaomi.push.service.u */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1793u {
    /* renamed from: a */
    public void m4007a(Context context, C1755am.b bVar, boolean z, int i, String str) {
        C1787p m3955a;
        if (z || (m3955a = C1788q.m3955a(context)) == null || !"token-expired".equals(str)) {
            return;
        }
        C1788q.m3956a(context, m3955a.f3201f, m3955a.f3199d, m3955a.f3200e);
    }

    /* renamed from: a */
    public void m4009a(XMPushService xMPushService, AbstractC1615fn abstractC1615fn, C1755am.b bVar) {
        if (abstractC1615fn instanceof C1614fm) {
            C1614fm c1614fm = (C1614fm) abstractC1615fn;
            C1612fk a = c1614fm.m2580a("s");
            if (a != null) {
                try {
                    m3994a(xMPushService, C1760ar.m3746a(C1760ar.m3745a(bVar.f3006h, c1614fm.m2610j()), a.m2571c()), C1626fy.m2655a(abstractC1615fn.mo2575a()));
                    return;
                } catch (IllegalArgumentException e) {
                    AbstractC1417b.m1093a(e);
                    return;
                }
            }
            return;
        }
        AbstractC1417b.m1089a("not a mipush message");
    }

    /* renamed from: a */
    public void m4008a(XMPushService xMPushService, C1591eq c1591eq, C1755am.b bVar) {
        HashMap hashMap;
        try {
            byte[] m2443a = c1591eq.m2443a(bVar.f3006h);
            if (AbstractC1776e.m3829b(c1591eq)) {
                hashMap = new HashMap();
                hashMap.put("t_im", String.valueOf(c1591eq.m2445b()));
                hashMap.put("t_rt", String.valueOf(c1591eq.m2430a()));
            } else {
                hashMap = null;
            }
            m3995a(xMPushService, m2443a, c1591eq.mo2450c(), hashMap);
        } catch (IllegalArgumentException e) {
            AbstractC1417b.m1093a(e);
        }
    }

    /* renamed from: a */
    private static void m3994a(XMPushService xMPushService, byte[] bArr, long j) {
        m3995a(xMPushService, bArr, j, (Map<String, String>) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00c1  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void m3995a(XMPushService xMPushService, byte[] bArr, long j, Map<String, String> map) {
        byte[] bArr2;
        String m4057a;
        String str;
        Map<String, String> m2843a;
        Map<String, String> m2843a2;
        byte[] m3313a;
        C1656ha m3987a = m3987a(bArr);
        if (m3987a == null) {
            return;
        }
        if (TextUtils.isEmpty(m3987a.f2444b)) {
            AbstractC1417b.m1089a("receive a mipush message without package name");
            return;
        }
        C1646gr m3010a = m3987a.m3010a();
        if (m3010a != null && map != null && !map.isEmpty() && (m2843a2 = m3010a.m2843a()) != null && !m2843a2.isEmpty()) {
            boolean z = false;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (m2843a2.containsKey(entry.getKey())) {
                    m2843a2.put(entry.getKey(), entry.getValue());
                    z = true;
                }
            }
            if (z && (m3313a = C1670ho.m3313a(m3987a)) != null && m3313a.length > 0) {
                bArr2 = m3313a;
                Long valueOf = Long.valueOf(System.currentTimeMillis());
                Intent m3984a = m3984a(bArr2, valueOf.longValue());
                m4057a = C1796x.m4057a(m3987a);
                C1626fy.m2663a(xMPushService, m4057a, j, true, true, System.currentTimeMillis());
                if (m3010a != null && m3010a.m2842a() != null) {
                    AbstractC1417b.m1105e(String.format("receive a message. appid=%1$s, msgid= %2$s, action=%3$s", m3987a.m3017a(), C1752aj.m3693a(m3010a.m2842a()), m3987a.m3009a()));
                }
                if (m3010a != null) {
                    m3010a.m2845a("mrt", Long.toString(valueOf.longValue()));
                }
                String str2 = "";
                if (EnumC1633ge.SendMessage != m3987a.m3009a() && C1789r.m3965a(xMPushService).m3967a(m3987a.f2444b) && !C1796x.m4073a(m3987a)) {
                    if (m3010a != null) {
                        str2 = m3010a.m2842a();
                        if (C1796x.m4091e(m3987a)) {
                            C1566ds.m2275a(xMPushService.getApplicationContext()).m2282a(m3987a.m3025b(), C1796x.m4080b(m3987a), str2, PushClient.DEFAULT_REQUEST_ID);
                        }
                    }
                    AbstractC1417b.m1089a("Drop a message for unregistered, msgid=" + str2);
                    m3991a(xMPushService, m3987a, m3987a.f2444b);
                    return;
                }
                if (EnumC1633ge.SendMessage != m3987a.m3009a() && C1789r.m3965a(xMPushService).m3971c(m3987a.f2444b) && !C1796x.m4073a(m3987a)) {
                    if (m3010a != null) {
                        str2 = m3010a.m2842a();
                        if (C1796x.m4091e(m3987a)) {
                            C1566ds.m2275a(xMPushService.getApplicationContext()).m2282a(m3987a.m3025b(), C1796x.m4080b(m3987a), str2, "2");
                        }
                    }
                    AbstractC1417b.m1089a("Drop a message for push closed, msgid=" + str2);
                    m3991a(xMPushService, m3987a, m3987a.f2444b);
                    return;
                }
                if (EnumC1633ge.SendMessage != m3987a.m3009a() && !TextUtils.equals(xMPushService.getPackageName(), "com.xiaomi.xmsf") && !TextUtils.equals(xMPushService.getPackageName(), m3987a.f2444b)) {
                    AbstractC1417b.m1089a("Receive a message with wrong package name, expect " + xMPushService.getPackageName() + ", received " + m3987a.f2444b);
                    m3992a(xMPushService, m3987a, "unmatched_package", "package should be " + xMPushService.getPackageName() + ", but got " + m3987a.f2444b);
                    if (m3010a == null || !C1796x.m4091e(m3987a)) {
                        return;
                    }
                    C1566ds.m2275a(xMPushService.getApplicationContext()).m2282a(m3987a.m3025b(), C1796x.m4080b(m3987a), m3010a.m2842a(), "3");
                    return;
                }
                if (EnumC1633ge.SendMessage == m3987a.m3009a() || C1682i.m3377a() != 999) {
                    str = m4057a;
                } else {
                    str = m4057a;
                    if (C1682i.m3386a((Context) xMPushService, str)) {
                        AbstractC1417b.m1089a("Receive the uninstalled dual app message");
                        try {
                            C1795w.m4032a(xMPushService, C1795w.m4026a(str, m3987a.m3017a()));
                            AbstractC1417b.m1089a("uninstall " + str + " msg sent");
                        } catch (C1609fh e) {
                            AbstractC1417b.m1103d("Fail to send Message: " + e.getMessage());
                            xMPushService.m3546a(10, e);
                        }
                        C1796x.m4061a((Context) xMPushService, str);
                        return;
                    }
                }
                if (m3010a == null && (m2843a = m3010a.m2843a()) != null && m2843a.containsKey("hide") && "true".equalsIgnoreCase(m2843a.get("hide"))) {
                    m4002b(xMPushService, m3987a);
                    return;
                }
                m3993a(xMPushService, str, bArr2, m3984a);
            }
        }
        bArr2 = bArr;
        Long valueOf2 = Long.valueOf(System.currentTimeMillis());
        Intent m3984a2 = m3984a(bArr2, valueOf2.longValue());
        m4057a = C1796x.m4057a(m3987a);
        C1626fy.m2663a(xMPushService, m4057a, j, true, true, System.currentTimeMillis());
        if (m3010a != null) {
            AbstractC1417b.m1105e(String.format("receive a message. appid=%1$s, msgid= %2$s, action=%3$s", m3987a.m3017a(), C1752aj.m3693a(m3010a.m2842a()), m3987a.m3009a()));
        }
        if (m3010a != null) {
        }
        String str22 = "";
        if (EnumC1633ge.SendMessage != m3987a.m3009a()) {
        }
        if (EnumC1633ge.SendMessage != m3987a.m3009a()) {
        }
        if (EnumC1633ge.SendMessage != m3987a.m3009a()) {
        }
        if (EnumC1633ge.SendMessage == m3987a.m3009a()) {
        }
        str = m4057a;
        if (m3010a == null) {
        }
        m3993a(xMPushService, str, bArr2, m3984a2);
    }

    /* renamed from: a */
    public static Intent m3984a(byte[] bArr, long j) {
        C1656ha m3987a = m3987a(bArr);
        if (m3987a == null) {
            return null;
        }
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mrt", Long.toString(j));
        intent.setPackage(m3987a.f2444b);
        return intent;
    }

    /* renamed from: a */
    public static C1656ha m3987a(byte[] bArr) {
        C1656ha c1656ha = new C1656ha();
        try {
            C1670ho.m3312a(c1656ha, bArr);
            return c1656ha;
        } catch (Throwable th) {
            AbstractC1417b.m1093a(th);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0441  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0434  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m3993a(XMPushService xMPushService, String str, byte[] bArr, Intent intent) {
        Object[] objArr;
        C1659hd c1659hd;
        C1656ha m3987a = m3987a(bArr);
        C1646gr m3010a = m3987a.m3010a();
        InterfaceC1671hp interfaceC1671hp = null;
        String str2 = null;
        if (bArr != null) {
            C1538cr.m1928a(m3987a.m3025b(), xMPushService.getApplicationContext(), null, m3987a.m3009a(), bArr.length);
        }
        if (m4005c(m3987a) && m3997a(xMPushService, str)) {
            if (C1796x.m4091e(m3987a)) {
                C1566ds.m2275a(xMPushService.getApplicationContext()).m2282a(m3987a.m3025b(), C1796x.m4080b(m3987a), m3010a.m2842a(), "5");
            }
            m4004c(xMPushService, m3987a);
            return;
        }
        if (m3999a(m3987a) && !m3997a(xMPushService, str) && !m4003b(m3987a)) {
            if (C1796x.m4091e(m3987a)) {
                C1566ds.m2275a(xMPushService.getApplicationContext()).m2282a(m3987a.m3025b(), C1796x.m4080b(m3987a), m3010a.m2842a(), "6");
            }
            m4006d(xMPushService, m3987a);
            return;
        }
        if ((C1796x.m4073a(m3987a) && C1628g.m2691c(xMPushService, m3987a.f2444b)) || m3996a(xMPushService, intent)) {
            boolean z = false;
            if (EnumC1633ge.Registration == m3987a.m3009a()) {
                String m3025b = m3987a.m3025b();
                SharedPreferences.Editor edit = xMPushService.getSharedPreferences("pref_registered_pkg_names", 0).edit();
                edit.putString(m3025b, m3987a.f2440a);
                edit.commit();
                C1661hf m3866a = C1783l.m3866a(m3987a);
                if (m3866a.m3139a() == 0 && !TextUtils.isEmpty(m3866a.m3146b())) {
                    C1783l.m3868a(xMPushService, m3025b, m3866a.m3146b());
                } else {
                    AbstractC1417b.m1103d("read regSecret failed");
                }
                C1789r.m3965a(xMPushService).m3973e(m3025b);
                C1789r.m3965a(xMPushService).m3974f(m3025b);
                C1566ds.m2275a(xMPushService.getApplicationContext()).m2281a(m3025b, "E100003", m3010a.m2842a(), 6003, null);
                if (!TextUtils.isEmpty(m3010a.m2842a())) {
                    intent.putExtra("messageId", m3010a.m2842a());
                    intent.putExtra("eventMessageType", CodecError.RELEASE_OUTPUT_ILLEGAL);
                }
            }
            if (C1796x.m4089c(m3987a)) {
                C1566ds.m2275a(xMPushService.getApplicationContext()).m2280a(m3987a.m3025b(), C1796x.m4080b(m3987a), m3010a.m2842a(), 1001, System.currentTimeMillis(), null);
                if (!TextUtils.isEmpty(m3010a.m2842a())) {
                    intent.putExtra("messageId", m3010a.m2842a());
                    intent.putExtra("eventMessageType", 1000);
                }
            }
            if (C1796x.m4085b(m3987a)) {
                C1566ds.m2275a(xMPushService.getApplicationContext()).m2280a(m3987a.m3025b(), C1796x.m4080b(m3987a), m3010a.m2842a(), 2001, System.currentTimeMillis(), null);
                if (!TextUtils.isEmpty(m3010a.m2842a())) {
                    intent.putExtra("messageId", m3010a.m2842a());
                    intent.putExtra("eventMessageType", 2000);
                }
            }
            if (C1796x.m4073a(m3987a)) {
                C1566ds.m2275a(xMPushService.getApplicationContext()).m2280a(m3987a.m3025b(), C1796x.m4080b(m3987a), m3010a.m2842a(), CodecError.DEQUEUE_OUTPUT_CODEC_EXCEPTION, System.currentTimeMillis(), null);
                if (!TextUtils.isEmpty(m3010a.m2842a())) {
                    intent.putExtra("messageId", m3010a.m2842a());
                    intent.putExtra("eventMessageType", 3000);
                }
            }
            if (m3010a == null || TextUtils.isEmpty(m3010a.m2860c()) || TextUtils.isEmpty(m3010a.m2864d()) || m3010a.f2283b == 1 || C1796x.m4071a((Context) xMPushService, m3987a.f2444b, C1796x.m4075a(m3010a.m2843a()))) {
                if ("com.xiaomi.xmsf".contains(m3987a.f2444b) && !m3987a.m3027b() && m3010a != null && m3010a.m2843a() != null && m3010a.m2843a().containsKey("ab")) {
                    m4002b(xMPushService, m3987a);
                    AbstractC1417b.m1101c("receive abtest message. ack it." + m3010a.m2842a());
                } else if (m4000a(xMPushService, str, m3987a, m3010a)) {
                    if (m3010a != null && !TextUtils.isEmpty(m3010a.m2842a())) {
                        if (C1796x.m4085b(m3987a)) {
                            C1566ds.m2275a(xMPushService.getApplicationContext()).m2281a(m3987a.m3025b(), C1796x.m4080b(m3987a), m3010a.m2842a(), 2002, null);
                        } else if (C1796x.m4073a(m3987a)) {
                            C1566ds.m2275a(xMPushService.getApplicationContext()).m2282a(m3987a.m3025b(), C1796x.m4080b(m3987a), m3010a.m2842a(), "7");
                        } else if (C1796x.m4089c(m3987a)) {
                            C1566ds.m2275a(xMPushService.getApplicationContext()).m2282a(m3987a.m3025b(), C1796x.m4080b(m3987a), m3010a.m2842a(), "8");
                        } else if (C1796x.m4090d(m3987a)) {
                            C1566ds.m2275a(xMPushService.getApplicationContext()).m2281a(m3987a.m3025b(), "E100003", m3010a.m2842a(), 6004, null);
                        }
                    }
                    if (EnumC1633ge.Notification == m3987a.f2437a) {
                        try {
                            interfaceC1671hp = C1772bc.m3819a(xMPushService, m3987a);
                        } catch (C1675ht e) {
                            AbstractC1417b.m1103d("receive a message which action string is not valid. " + e);
                        }
                        if (interfaceC1671hp == null) {
                            AbstractC1417b.m1103d("receiving an un-recognized notification message. " + m3987a.f2437a);
                            objArr = false;
                            if (objArr != false && (interfaceC1671hp instanceof C1659hd)) {
                                c1659hd = (C1659hd) interfaceC1671hp;
                                if (!EnumC1643go.CancelPushMessage.f2208a.equals(c1659hd.f2478d) && c1659hd.m3053a() != null) {
                                    String str3 = c1659hd.m3053a().get(AbstractC1756an.f3039Q);
                                    int i = -2;
                                    if (!TextUtils.isEmpty(str3)) {
                                        try {
                                            i = Integer.parseInt(str3);
                                        } catch (NumberFormatException e2) {
                                            AbstractC1417b.m1089a("parse notifyId from STRING to INT failed: " + e2);
                                        }
                                    }
                                    if (i >= -1) {
                                        AbstractC1417b.m1089a("try to retract a message by notifyId=" + i);
                                        C1796x.m4062a(xMPushService, m3987a.f2444b, i);
                                    } else {
                                        String str4 = c1659hd.m3053a().get(AbstractC1756an.f3037O);
                                        String str5 = c1659hd.m3053a().get(AbstractC1756an.f3038P);
                                        AbstractC1417b.m1089a("try to retract a message by title&description.");
                                        C1796x.m4065a(xMPushService, m3987a.f2444b, str4, str5);
                                    }
                                    if (m3010a != null && m3010a.m2843a() != null && C1694j.m3427a((Context) xMPushService) && "pulldown".equals(C1749ag.m3658a((Object) m3010a.m2843a()))) {
                                        C1794v.m4013a(m3987a);
                                    }
                                    m3990a(xMPushService, m3987a, c1659hd);
                                } else if (EnumC1643go.SettingAppNotificationPermission.f2208a.equals(c1659hd.m3065c())) {
                                    if (C1694j.m3427a((Context) xMPushService)) {
                                        C1794v.m4012a(xMPushService, m3987a, c1659hd);
                                    }
                                }
                                if (z) {
                                    AbstractC1417b.m1089a("broadcast passthrough message.");
                                    xMPushService.sendBroadcast(intent, C1795w.m4030a(m3987a.f2444b));
                                }
                            }
                        } else {
                            objArr = true;
                            if (objArr != false) {
                                c1659hd = (C1659hd) interfaceC1671hp;
                                if (!EnumC1643go.CancelPushMessage.f2208a.equals(c1659hd.f2478d)) {
                                }
                                if (EnumC1643go.SettingAppNotificationPermission.f2208a.equals(c1659hd.m3065c())) {
                                }
                            }
                        }
                    }
                    z = true;
                    if (z) {
                    }
                } else {
                    C1566ds.m2275a(xMPushService.getApplicationContext()).m2282a(m3987a.m3025b(), C1796x.m4080b(m3987a), m3010a.m2842a(), "9");
                }
            } else {
                if (m3010a != null) {
                    str2 = m3010a.f2281a != null ? m3010a.f2281a.get("jobkey") : null;
                    if (TextUtils.isEmpty(str2)) {
                        str2 = m3010a.m2842a();
                    }
                    z = C1797y.m4093a(xMPushService, m3987a.f2444b, str2);
                }
                if (z) {
                    C1566ds.m2275a(xMPushService.getApplicationContext()).m2284c(m3987a.m3025b(), C1796x.m4080b(m3987a), m3010a.m2842a(), "1:" + str2);
                    AbstractC1417b.m1089a("drop a duplicate message, key=" + str2);
                } else if (C1694j.m3427a((Context) xMPushService) && C1794v.m4016a(m3987a)) {
                    AbstractC1417b.m1089a("receive pull down message");
                } else {
                    m3988a(xMPushService, m3987a, bArr);
                }
                m4002b(xMPushService, m3987a);
            }
            if (m3987a.m3009a() != EnumC1633ge.UnRegistration || "com.xiaomi.xmsf".equals(xMPushService.getPackageName())) {
                return;
            }
            xMPushService.stopSelf();
            return;
        }
        if (!C1628g.m2691c(xMPushService, m3987a.f2444b)) {
            if (C1796x.m4091e(m3987a)) {
                C1566ds.m2275a(xMPushService.getApplicationContext()).m2283b(m3987a.m3025b(), C1796x.m4080b(m3987a), m3010a.m2842a(), "2");
            }
            m3989a(xMPushService, m3987a);
        } else {
            AbstractC1417b.m1089a("receive a mipush message, we can see the app, but we can't see the receiver.");
            if (C1796x.m4091e(m3987a)) {
                C1566ds.m2275a(xMPushService.getApplicationContext()).m2283b(m3987a.m3025b(), C1796x.m4080b(m3987a), m3010a.m2842a(), "3");
            }
        }
    }

    /* renamed from: a */
    public static void m3988a(Context context, C1656ha c1656ha, byte[] bArr) {
        try {
            C1796x.c m4055a = C1796x.m4055a(context, c1656ha, bArr);
            if (m4055a.f3255a > 0 && !TextUtils.isEmpty(m4055a.f3256a)) {
                C1626fy.m2663a(context, m4055a.f3256a, m4055a.f3255a, true, false, System.currentTimeMillis());
            }
            if (C1694j.m3427a(context) && C1794v.m4015a(context, c1656ha, m4055a.f3257a)) {
                C1794v.m4011a(context, c1656ha);
                AbstractC1417b.m1089a("consume this broadcast by tts");
            } else {
                m4001b(context, c1656ha, bArr);
            }
        } catch (Exception e) {
            AbstractC1417b.m1089a("notify push msg error " + e);
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    private static void m4001b(Context context, C1656ha c1656ha, byte[] bArr) {
        if (C1796x.m4073a(c1656ha)) {
            return;
        }
        String m4057a = C1796x.m4057a(c1656ha);
        if (TextUtils.isEmpty(m4057a) || m3998a(context, m4057a, bArr)) {
            return;
        }
        C1566ds.m2275a(context).m2283b(m4057a, C1796x.m4080b(c1656ha), c1656ha.m3010a().m2842a(), PushClient.DEFAULT_REQUEST_ID);
    }

    /* renamed from: a */
    public static boolean m3998a(Context context, String str, byte[] bArr) {
        if (!C1628g.m2687a(context, str)) {
            return false;
        }
        Intent intent = new Intent("com.xiaomi.mipush.MESSAGE_ARRIVED");
        intent.putExtra("mipush_payload", bArr);
        intent.setPackage(str);
        try {
            if (context.getPackageManager().queryBroadcastReceivers(intent, 0).isEmpty()) {
                return false;
            }
            AbstractC1417b.m1089a("broadcast message arrived.");
            context.sendBroadcast(intent, C1795w.m4030a(str));
            return true;
        } catch (Exception e) {
            AbstractC1417b.m1089a("meet error when broadcast message arrived. " + e);
            return false;
        }
    }

    /* renamed from: a */
    private static boolean m4000a(XMPushService xMPushService, String str, C1656ha c1656ha, C1646gr c1646gr) {
        boolean z = true;
        if (c1646gr != null && c1646gr.m2843a() != null && c1646gr.m2843a().containsKey("__check_alive") && c1646gr.m2843a().containsKey("__awake")) {
            C1659hd c1659hd = new C1659hd();
            c1659hd.m3060b(c1656ha.m3017a());
            c1659hd.m3068d(str);
            c1659hd.m3064c(EnumC1643go.AwakeSystemApp.f2208a);
            c1659hd.m3047a(c1646gr.m2842a());
            c1659hd.f2473a = new HashMap();
            boolean m2687a = C1628g.m2687a(xMPushService.getApplicationContext(), str);
            c1659hd.f2473a.put("app_running", Boolean.toString(m2687a));
            if (!m2687a) {
                boolean parseBoolean = Boolean.parseBoolean(c1646gr.m2843a().get("__awake"));
                c1659hd.f2473a.put("awaked", Boolean.toString(parseBoolean));
                if (!parseBoolean) {
                    z = false;
                }
            }
            try {
                C1795w.m4032a(xMPushService, C1795w.m4027a(c1656ha.m3025b(), c1656ha.m3017a(), c1659hd, EnumC1633ge.Notification));
            } catch (C1609fh e) {
                AbstractC1417b.m1093a(e);
            }
        }
        return z;
    }

    /* renamed from: a */
    private static void m3989a(final XMPushService xMPushService, final C1656ha c1656ha) {
        xMPushService.m3548a(new XMPushService.AbstractC1731j(4) { // from class: com.xiaomi.push.service.u.1
            @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
            /* renamed from: a */
            public String mo2389a() {
                return "send app absent message.";
            }

            @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
            /* renamed from: a */
            public void mo2390a() {
                try {
                    C1795w.m4032a(xMPushService, C1795w.m4026a(c1656ha.m3025b(), c1656ha.m3017a()));
                } catch (C1609fh e) {
                    AbstractC1417b.m1093a(e);
                    xMPushService.m3546a(10, e);
                }
            }
        });
    }

    /* renamed from: a */
    private static boolean m3999a(C1656ha c1656ha) {
        return "com.xiaomi.xmsf".equals(c1656ha.f2444b) && c1656ha.m3010a() != null && c1656ha.m3010a().m2843a() != null && c1656ha.m3010a().m2843a().containsKey("miui_package_name");
    }

    /* renamed from: b */
    private static boolean m4003b(C1656ha c1656ha) {
        Map<String, String> m2843a = c1656ha.m3010a().m2843a();
        return m2843a != null && m2843a.containsKey("notify_effect");
    }

    /* renamed from: a */
    private static boolean m3997a(Context context, String str) {
        Intent intent = new Intent("com.xiaomi.mipush.miui.CLICK_MESSAGE");
        intent.setPackage(str);
        Intent intent2 = new Intent("com.xiaomi.mipush.miui.RECEIVE_MESSAGE");
        intent2.setPackage(str);
        PackageManager packageManager = context.getPackageManager();
        try {
            List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 32);
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 32);
            if (queryBroadcastReceivers.isEmpty()) {
                if (queryIntentServices.isEmpty()) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            AbstractC1417b.m1093a(e);
            return false;
        }
    }

    /* renamed from: c */
    private static boolean m4005c(C1656ha c1656ha) {
        if (c1656ha.m3010a() == null || c1656ha.m3010a().m2843a() == null) {
            return false;
        }
        return PushClient.DEFAULT_REQUEST_ID.equals(c1656ha.m3010a().m2843a().get("obslete_ads_message"));
    }

    /* renamed from: b */
    private static void m4002b(final XMPushService xMPushService, final C1656ha c1656ha) {
        xMPushService.m3548a(new XMPushService.AbstractC1731j(4) { // from class: com.xiaomi.push.service.u.2
            @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
            /* renamed from: a */
            public String mo2389a() {
                return "send ack message for message.";
            }

            @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
            /* renamed from: a */
            public void mo2390a() {
                Map<String, String> m4010a;
                try {
                    if (C1694j.m3427a((Context) xMPushService)) {
                        try {
                            m4010a = C1794v.m4010a((Context) xMPushService, c1656ha);
                        } catch (Throwable th) {
                            AbstractC1417b.m1103d("error creating params for ack message :" + th);
                        }
                        C1795w.m4032a(xMPushService, C1793u.m3986a(xMPushService, c1656ha, m4010a));
                    }
                    m4010a = null;
                    C1795w.m4032a(xMPushService, C1793u.m3986a(xMPushService, c1656ha, m4010a));
                } catch (C1609fh e) {
                    AbstractC1417b.m1103d("error sending ack message :" + e);
                    xMPushService.m3546a(10, e);
                }
            }
        });
    }

    /* renamed from: c */
    private static void m4004c(final XMPushService xMPushService, final C1656ha c1656ha) {
        xMPushService.m3548a(new XMPushService.AbstractC1731j(4) { // from class: com.xiaomi.push.service.u.3
            @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
            /* renamed from: a */
            public String mo2389a() {
                return "send ack message for obsleted message.";
            }

            @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
            /* renamed from: a */
            public void mo2390a() {
                try {
                    C1656ha m3985a = C1793u.m3985a((Context) xMPushService, c1656ha);
                    m3985a.m3010a().m2845a("message_obsleted", PushClient.DEFAULT_REQUEST_ID);
                    C1795w.m4032a(xMPushService, m3985a);
                } catch (C1609fh e) {
                    AbstractC1417b.m1093a(e);
                    xMPushService.m3546a(10, e);
                }
            }
        });
    }

    /* renamed from: d */
    private static void m4006d(final XMPushService xMPushService, final C1656ha c1656ha) {
        xMPushService.m3548a(new XMPushService.AbstractC1731j(4) { // from class: com.xiaomi.push.service.u.4
            @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
            /* renamed from: a */
            public String mo2389a() {
                return "send ack message for unrecognized new miui message.";
            }

            @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
            /* renamed from: a */
            public void mo2390a() {
                try {
                    C1656ha m3985a = C1793u.m3985a((Context) xMPushService, c1656ha);
                    m3985a.m3010a().m2845a("miui_message_unrecognized", PushClient.DEFAULT_REQUEST_ID);
                    C1795w.m4032a(xMPushService, m3985a);
                } catch (C1609fh e) {
                    AbstractC1417b.m1093a(e);
                    xMPushService.m3546a(10, e);
                }
            }
        });
    }

    /* renamed from: a */
    private static void m3991a(final XMPushService xMPushService, final C1656ha c1656ha, final String str) {
        xMPushService.m3548a(new XMPushService.AbstractC1731j(4) { // from class: com.xiaomi.push.service.u.5
            @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
            /* renamed from: a */
            public String mo2389a() {
                return "send app absent ack message for message.";
            }

            @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
            /* renamed from: a */
            public void mo2390a() {
                try {
                    C1656ha m3985a = C1793u.m3985a((Context) xMPushService, c1656ha);
                    m3985a.m3010a().m2845a("absent_target_package", str);
                    C1795w.m4032a(xMPushService, m3985a);
                } catch (C1609fh e) {
                    AbstractC1417b.m1093a(e);
                    xMPushService.m3546a(10, e);
                }
            }
        });
    }

    /* renamed from: a */
    private static void m3992a(final XMPushService xMPushService, final C1656ha c1656ha, final String str, final String str2) {
        xMPushService.m3548a(new XMPushService.AbstractC1731j(4) { // from class: com.xiaomi.push.service.u.6
            @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
            /* renamed from: a */
            public String mo2389a() {
                return "send wrong message ack for message.";
            }

            @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
            /* renamed from: a */
            public void mo2390a() {
                try {
                    C1656ha m3985a = C1793u.m3985a((Context) xMPushService, c1656ha);
                    m3985a.f2438a.m2845a("error", str);
                    m3985a.f2438a.m2845a(BaseConstants.DownloadManager.COLUMN_REASON, str2);
                    C1795w.m4032a(xMPushService, m3985a);
                } catch (C1609fh e) {
                    AbstractC1417b.m1093a(e);
                    xMPushService.m3546a(10, e);
                }
            }
        });
    }

    /* renamed from: a */
    private static void m3990a(final XMPushService xMPushService, final C1656ha c1656ha, final C1659hd c1659hd) {
        xMPushService.m3548a(new XMPushService.AbstractC1731j(4) { // from class: com.xiaomi.push.service.u.7
            @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
            /* renamed from: a */
            public String mo2389a() {
                return "send ack message for clear push message.";
            }

            @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
            /* renamed from: a */
            public void mo2390a() {
                try {
                    C1650gv c1650gv = new C1650gv();
                    c1650gv.m2938c(EnumC1643go.CancelPushMessageACK.f2208a);
                    c1650gv.m2928a(c1659hd.m3052a());
                    c1650gv.m2927a(c1659hd.m3046a());
                    c1650gv.m2935b(c1659hd.m3061b());
                    c1650gv.m2942e(c1659hd.m3069d());
                    c1650gv.m2926a(0L);
                    c1650gv.m2940d("success clear push message.");
                    C1795w.m4032a(xMPushService, C1795w.m4037b(c1656ha.m3025b(), c1656ha.m3017a(), c1650gv, EnumC1633ge.Notification));
                } catch (C1609fh e) {
                    AbstractC1417b.m1103d("clear push message. " + e);
                    xMPushService.m3546a(10, e);
                }
            }
        });
    }

    /* renamed from: a */
    public static C1656ha m3985a(Context context, C1656ha c1656ha) {
        return m3986a(context, c1656ha, (Map<String, String>) null);
    }

    /* renamed from: a */
    public static C1656ha m3986a(Context context, C1656ha c1656ha, Map<String, String> map) {
        C1649gu c1649gu = new C1649gu();
        c1649gu.m2899b(c1656ha.m3017a());
        C1646gr m3010a = c1656ha.m3010a();
        if (m3010a != null) {
            c1649gu.m2893a(m3010a.m2842a());
            c1649gu.m2892a(m3010a.m2837a());
            if (!TextUtils.isEmpty(m3010a.m2852b())) {
                c1649gu.m2902c(m3010a.m2852b());
            }
        }
        c1649gu.m2894a(C1670ho.m3309a(context, c1656ha));
        C1656ha m4027a = C1795w.m4027a(c1656ha.m3025b(), c1656ha.m3017a(), c1649gu, EnumC1633ge.AckMessage);
        C1646gr m3010a2 = c1656ha.m3010a();
        if (m3010a2 != null) {
            m3010a2 = C1763au.m3762a(m3010a2.m2838a());
            Map<String, String> m2843a = m3010a2.m2843a();
            String str = m2843a != null ? m2843a.get("channel_id") : null;
            m3010a2.m2845a("mat", Long.toString(System.currentTimeMillis()));
            m3010a2.m2845a("cs", String.valueOf(C1777f.m3831a(context, c1656ha.f2444b, str)));
        }
        if (map != null) {
            try {
                if (map.size() > 0) {
                    for (String str2 : map.keySet()) {
                        m3010a2.m2845a(str2, map.get(str2));
                    }
                }
            } catch (Throwable th) {
                AbstractC1417b.m1103d("error adding params to ack message :" + th);
            }
        }
        m4027a.m3012a(m3010a2);
        return m4027a;
    }

    /* renamed from: a */
    private static boolean m3996a(Context context, Intent intent) {
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
            if (queryBroadcastReceivers != null) {
                if (!queryBroadcastReceivers.isEmpty()) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }
}
