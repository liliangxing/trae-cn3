package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import com.vivo.push.PushClient;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import com.xiaomi.push.C1494ba;
import com.xiaomi.push.C1506bm;
import com.xiaomi.push.C1538cr;
import com.xiaomi.push.C1565dr;
import com.xiaomi.push.C1566ds;
import com.xiaomi.push.C1628g;
import com.xiaomi.push.C1645gq;
import com.xiaomi.push.C1646gr;
import com.xiaomi.push.C1649gu;
import com.xiaomi.push.C1650gv;
import com.xiaomi.push.C1654gz;
import com.xiaomi.push.C1656ha;
import com.xiaomi.push.C1657hb;
import com.xiaomi.push.C1658hc;
import com.xiaomi.push.C1659hd;
import com.xiaomi.push.C1661hf;
import com.xiaomi.push.C1663hh;
import com.xiaomi.push.C1665hj;
import com.xiaomi.push.C1667hl;
import com.xiaomi.push.C1669hn;
import com.xiaomi.push.C1670ho;
import com.xiaomi.push.C1675ht;
import com.xiaomi.push.C1699o;
import com.xiaomi.push.EnumC1577ec;
import com.xiaomi.push.EnumC1633ge;
import com.xiaomi.push.EnumC1643go;
import com.xiaomi.push.EnumC1647gs;
import com.xiaomi.push.InterfaceC1671hp;
import com.xiaomi.push.service.AbstractC1756an;
import com.xiaomi.push.service.C1749ag;
import com.xiaomi.push.service.C1750ah;
import com.xiaomi.push.service.C1751ai;
import com.xiaomi.push.service.C1763au;
import com.xiaomi.push.service.C1778g;
import com.xiaomi.push.service.C1796x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TimeZone;

/* renamed from: com.xiaomi.mipush.sdk.t */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1461t {

    /* renamed from: a */
    private static C1461t f880a;

    /* renamed from: a */
    private static Object f881a = new Object();

    /* renamed from: a */
    private static Queue<String> f882a;

    /* renamed from: a */
    private Context f883a;

    /* renamed from: a */
    public static C1461t m1352a(Context context) {
        if (f880a == null) {
            f880a = new C1461t(context);
        }
        return f880a;
    }

    private C1461t(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f883a = applicationContext;
        if (applicationContext == null) {
            this.f883a = context;
        }
    }

    /* renamed from: a */
    public PushMessageHandler.InterfaceC1441a m1365a(Intent intent) {
        String action = intent.getAction();
        AbstractC1417b.m1089a("receive an intent from server, action=" + action);
        String stringExtra = intent.getStringExtra("mrt");
        if (stringExtra == null) {
            stringExtra = Long.toString(System.currentTimeMillis());
        }
        String stringExtra2 = intent.getStringExtra("messageId");
        int intExtra = intent.getIntExtra("eventMessageType", -1);
        if ("com.xiaomi.mipush.RECEIVE_MESSAGE".equals(action)) {
            byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
            boolean booleanExtra = intent.getBooleanExtra("mipush_notified", false);
            if (byteArrayExtra == null) {
                AbstractC1417b.m1103d("receiving an empty message, drop");
                C1566ds.m2275a(this.f883a).m2279a(this.f883a.getPackageName(), intent, "12");
                return null;
            }
            C1656ha c1656ha = new C1656ha();
            try {
                C1670ho.m3312a(c1656ha, byteArrayExtra);
                C1443b m1222a = C1443b.m1222a(this.f883a);
                C1646gr m3010a = c1656ha.m3010a();
                if (c1656ha.m3009a() == EnumC1633ge.SendMessage && m3010a != null && !m1222a.m1246e() && !booleanExtra) {
                    m3010a.m2845a("mrt", stringExtra);
                    m3010a.m2845a("mat", Long.toString(System.currentTimeMillis()));
                    if (!m1361a(c1656ha)) {
                        m1363b(c1656ha);
                    } else {
                        AbstractC1417b.m1098b("this is a mina's message, ack later");
                        m3010a.m2845a(Constants.EXTRA_KEY_HYBRID_MESSAGE_TS, String.valueOf(m3010a.m2837a()));
                        m3010a.m2845a(Constants.EXTRA_KEY_HYBRID_DEVICE_STATUS, String.valueOf((int) C1670ho.m3309a(this.f883a, c1656ha)));
                    }
                }
                if (c1656ha.m3009a() == EnumC1633ge.SendMessage && !c1656ha.m3027b()) {
                    if (C1796x.m4073a(c1656ha)) {
                        Object[] objArr = new Object[2];
                        objArr[0] = c1656ha.m3025b();
                        objArr[1] = m3010a != null ? m3010a.m2842a() : "";
                        AbstractC1417b.m1089a(String.format("drop an un-encrypted wake-up messages. %1$s, %2$s", objArr));
                        C1566ds.m2275a(this.f883a).m2279a(this.f883a.getPackageName(), intent, String.format("13: %1$s", c1656ha.m3025b()));
                    } else {
                        Object[] objArr2 = new Object[2];
                        objArr2[0] = c1656ha.m3025b();
                        objArr2[1] = m3010a != null ? m3010a.m2842a() : "";
                        AbstractC1417b.m1089a(String.format("drop an un-encrypted messages. %1$s, %2$s", objArr2));
                        C1566ds.m2275a(this.f883a).m2279a(this.f883a.getPackageName(), intent, String.format("14: %1$s", c1656ha.m3025b()));
                    }
                    C1451j.m1314a(this.f883a, c1656ha, booleanExtra);
                    return null;
                }
                if (c1656ha.m3009a() == EnumC1633ge.SendMessage && c1656ha.m3027b() && C1796x.m4073a(c1656ha) && (!booleanExtra || m3010a == null || m3010a.m2843a() == null || !m3010a.m2843a().containsKey("notify_effect"))) {
                    Object[] objArr3 = new Object[2];
                    objArr3[0] = c1656ha.m3025b();
                    objArr3[1] = m3010a != null ? m3010a.m2842a() : "";
                    AbstractC1417b.m1089a(String.format("drop a wake-up messages which not has 'notify_effect' attr. %1$s, %2$s", objArr3));
                    C1566ds.m2275a(this.f883a).m2279a(this.f883a.getPackageName(), intent, String.format("25: %1$s", c1656ha.m3025b()));
                    C1451j.m1316b(this.f883a, c1656ha, booleanExtra);
                    return null;
                }
                if (!m1222a.m1242c() && c1656ha.f2437a != EnumC1633ge.Registration) {
                    if (C1796x.m4073a(c1656ha)) {
                        return m1350a(c1656ha, booleanExtra, byteArrayExtra, stringExtra2, intExtra, intent);
                    }
                    C1451j.m1319e(this.f883a, c1656ha, booleanExtra);
                    boolean m1244d = m1222a.m1244d();
                    AbstractC1417b.m1103d("receive message without registration. need re-register!registered?" + m1244d);
                    C1566ds.m2275a(this.f883a).m2279a(this.f883a.getPackageName(), intent, "15");
                    if (!m1244d) {
                        return null;
                    }
                    m1353a();
                    return null;
                }
                if (m1222a.m1242c() && m1222a.m1248f()) {
                    if (c1656ha.f2437a == EnumC1633ge.UnRegistration) {
                        if (c1656ha.m3027b()) {
                            m1222a.m1227a();
                            MiPushClient.clearExtras(this.f883a);
                            PushMessageHandler.m1200a();
                            return null;
                        }
                        AbstractC1417b.m1103d("receiving an un-encrypt unregistration message");
                        return null;
                    }
                    C1451j.m1319e(this.f883a, c1656ha, booleanExtra);
                    MiPushClient.unregisterPush(this.f883a);
                    return null;
                }
                return m1350a(c1656ha, booleanExtra, byteArrayExtra, stringExtra2, intExtra, intent);
            } catch (C1675ht e) {
                C1566ds.m2275a(this.f883a).m2279a(this.f883a.getPackageName(), intent, "16");
                AbstractC1417b.m1093a(e);
                return null;
            } catch (Exception e2) {
                C1566ds.m2275a(this.f883a).m2279a(this.f883a.getPackageName(), intent, "17");
                AbstractC1417b.m1093a(e2);
                return null;
            }
        }
        if ("com.xiaomi.mipush.ERROR".equals(action)) {
            MiPushCommandMessage miPushCommandMessage = new MiPushCommandMessage();
            C1656ha c1656ha2 = new C1656ha();
            try {
                byte[] byteArrayExtra2 = intent.getByteArrayExtra("mipush_payload");
                if (byteArrayExtra2 != null) {
                    C1670ho.m3312a(c1656ha2, byteArrayExtra2);
                }
            } catch (C1675ht unused) {
            }
            miPushCommandMessage.setCommand(String.valueOf(c1656ha2.m3009a()));
            miPushCommandMessage.setResultCode(intent.getIntExtra("mipush_error_code", 0));
            miPushCommandMessage.setReason(intent.getStringExtra("mipush_error_msg"));
            AbstractC1417b.m1103d("receive a error message. code = " + intent.getIntExtra("mipush_error_code", 0) + ", msg= " + intent.getStringExtra("mipush_error_msg"));
            return miPushCommandMessage;
        }
        if (!"com.xiaomi.mipush.MESSAGE_ARRIVED".equals(action)) {
            return null;
        }
        byte[] byteArrayExtra3 = intent.getByteArrayExtra("mipush_payload");
        if (byteArrayExtra3 == null) {
            AbstractC1417b.m1103d("message arrived: receiving an empty message, drop");
            return null;
        }
        C1656ha c1656ha3 = new C1656ha();
        try {
            C1670ho.m3312a(c1656ha3, byteArrayExtra3);
            C1443b m1222a2 = C1443b.m1222a(this.f883a);
            if (C1796x.m4073a(c1656ha3)) {
                AbstractC1417b.m1103d("message arrived: receive ignore reg message, ignore!");
                return null;
            }
            if (!m1222a2.m1242c()) {
                AbstractC1417b.m1103d("message arrived: receive message without registration. need unregister or re-register!");
                return null;
            }
            if (m1222a2.m1242c() && m1222a2.m1248f()) {
                AbstractC1417b.m1103d("message arrived: app info is invalidated");
                return null;
            }
            return m1351a(c1656ha3, byteArrayExtra3);
        } catch (Exception e3) {
            AbstractC1417b.m1103d("fail to deal with arrived message. " + e3);
            return null;
        }
    }

    /* renamed from: a */
    private PushMessageHandler.InterfaceC1441a m1351a(C1656ha c1656ha, byte[] bArr) {
        String str = null;
        try {
            InterfaceC1671hp m1344a = C1459r.m1344a(this.f883a, c1656ha);
            if (m1344a == null) {
                AbstractC1417b.m1103d("message arrived: receiving an un-recognized message. " + c1656ha.f2437a);
                return null;
            }
            EnumC1633ge m3009a = c1656ha.m3009a();
            AbstractC1417b.m1089a("message arrived: processing an arrived message, action=" + m3009a);
            if (AnonymousClass1.f884a[m3009a.ordinal()] != 1) {
                return null;
            }
            if (!c1656ha.m3027b()) {
                AbstractC1417b.m1103d("message arrived: receiving an un-encrypt message(SendMessage).");
                return null;
            }
            C1663hh c1663hh = (C1663hh) m1344a;
            C1645gq m3184a = c1663hh.m3184a();
            if (m3184a == null) {
                AbstractC1417b.m1103d("message arrived: receive an empty message without push content, drop it");
                return null;
            }
            if (c1656ha.f2438a != null && c1656ha.f2438a.m2843a() != null) {
                str = c1656ha.f2438a.f2281a.get("jobkey");
            }
            MiPushMessage generateMessage = PushMessageHelper.generateMessage(c1663hh, c1656ha.m3010a(), false);
            generateMessage.setArrivedMessage(true);
            AbstractC1417b.m1089a("message arrived: receive a message, msgid=" + m3184a.m2808a() + ", jobkey=" + str);
            return generateMessage;
        } catch (C1453l e) {
            AbstractC1417b.m1093a(e);
            AbstractC1417b.m1103d("message arrived: receive a message but decrypt failed. report when click.");
            return null;
        } catch (C1675ht e2) {
            AbstractC1417b.m1093a(e2);
            AbstractC1417b.m1103d("message arrived: receive a message which action string is not valid. is the reg expired?");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.mipush.sdk.t$1, reason: invalid class name */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a */
        static final /* synthetic */ int[] f884a;

        static {
            int[] iArr = new int[EnumC1633ge.values().length];
            f884a = iArr;
            try {
                iArr[EnumC1633ge.SendMessage.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f884a[EnumC1633ge.Registration.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f884a[EnumC1633ge.UnRegistration.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f884a[EnumC1633ge.Subscription.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f884a[EnumC1633ge.UnSubscription.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f884a[EnumC1633ge.Command.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f884a[EnumC1633ge.Notification.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: a */
    private PushMessageHandler.InterfaceC1441a m1350a(C1656ha c1656ha, boolean z, byte[] bArr, String str, int i, Intent intent) {
        C1646gr c1646gr;
        MiPushMessage miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        miPushMessage = null;
        ArrayList arrayList3 = null;
        miPushMessage = null;
        try {
            InterfaceC1671hp m1344a = C1459r.m1344a(this.f883a, c1656ha);
            if (m1344a == null) {
                AbstractC1417b.m1103d("receiving an un-recognized message. " + c1656ha.f2437a);
                C1566ds.m2275a(this.f883a).m2283b(this.f883a.getPackageName(), C1565dr.m2268a(i), str, "18");
                C1451j.m1317c(this.f883a, c1656ha, z);
                return null;
            }
            EnumC1633ge m3009a = c1656ha.m3009a();
            AbstractC1417b.m1092a("processing a message, action=", m3009a, ", hasNotified=", Boolean.valueOf(z));
            switch (AnonymousClass1.f884a[m3009a.ordinal()]) {
                case 1:
                    if (!c1656ha.m3027b()) {
                        AbstractC1417b.m1103d("receiving an un-encrypt message(SendMessage).");
                        return null;
                    }
                    if (C1443b.m1222a(this.f883a).m1246e() && !z) {
                        AbstractC1417b.m1089a("receive a message in pause state. drop it");
                        C1566ds.m2275a(this.f883a).m2282a(this.f883a.getPackageName(), C1565dr.m2268a(i), str, "12");
                        return null;
                    }
                    C1663hh c1663hh = (C1663hh) m1344a;
                    C1645gq m3184a = c1663hh.m3184a();
                    if (m3184a == null) {
                        AbstractC1417b.m1103d("receive an empty message without push content, drop it");
                        C1566ds.m2275a(this.f883a).m2283b(this.f883a.getPackageName(), C1565dr.m2268a(i), str, "22");
                        C1451j.m1318d(this.f883a, c1656ha, z);
                        return null;
                    }
                    int intExtra = intent.getIntExtra("notification_click_button", 0);
                    if (z) {
                        if (C1796x.m4073a(c1656ha)) {
                            MiPushClient.reportIgnoreRegMessageClicked(this.f883a, m3184a.m2808a(), c1656ha.m3010a(), c1656ha.f2444b, m3184a.m2813b());
                        } else {
                            if (c1656ha.m3010a() != null) {
                                c1646gr = new C1646gr(c1656ha.m3010a());
                            } else {
                                c1646gr = new C1646gr();
                            }
                            if (c1646gr.m2843a() == null) {
                                c1646gr.m2841a(new HashMap());
                            }
                            c1646gr.m2843a().put("notification_click_button", String.valueOf(intExtra));
                            MiPushClient.reportMessageClicked(this.f883a, m3184a.m2808a(), c1646gr, m3184a.m2813b());
                        }
                    }
                    if (!z) {
                        if (!TextUtils.isEmpty(c1663hh.m3194d()) && MiPushClient.aliasSetTime(this.f883a, c1663hh.m3194d()) < 0) {
                            MiPushClient.addAlias(this.f883a, c1663hh.m3194d());
                        } else if (!TextUtils.isEmpty(c1663hh.m3192c()) && MiPushClient.topicSubscribedTime(this.f883a, c1663hh.m3192c()) < 0) {
                            MiPushClient.addTopic(this.f883a, c1663hh.m3192c());
                        }
                    }
                    String str2 = (c1656ha.f2438a == null || c1656ha.f2438a.m2843a() == null) ? null : c1656ha.f2438a.f2281a.get("jobkey");
                    String str3 = str2;
                    if (TextUtils.isEmpty(str2)) {
                        str2 = m3184a.m2808a();
                    }
                    if (!z && m1360a(this.f883a, str2)) {
                        AbstractC1417b.m1089a("drop a duplicate message, key=" + str2);
                        C1566ds.m2275a(this.f883a).m2284c(this.f883a.getPackageName(), C1565dr.m2268a(i), str, "2:" + str2);
                    } else {
                        MiPushMessage generateMessage = PushMessageHelper.generateMessage(c1663hh, c1656ha.m3010a(), z);
                        if (generateMessage.getPassThrough() == 0 && !z && C1796x.m4075a(generateMessage.getExtra())) {
                            C1796x.m4055a(this.f883a, c1656ha, bArr);
                            return null;
                        }
                        String m4058a = C1796x.m4058a(generateMessage.getExtra(), intExtra);
                        AbstractC1417b.m1092a("receive a message, msgid=", m3184a.m2808a(), ", jobkey=", str2, ", btn=", Integer.valueOf(intExtra), ", typeId=", m4058a, ", hasNotified=", Boolean.valueOf(z));
                        if (z && generateMessage.getExtra() != null && !TextUtils.isEmpty(m4058a)) {
                            Map<String, String> extra = generateMessage.getExtra();
                            if (intExtra != 0 && c1656ha.m3010a() != null) {
                                C1462u.m1373a(this.f883a).m1398a(c1656ha.m3010a().m2857c(), intExtra);
                            }
                            if (C1796x.m4073a(c1656ha)) {
                                Intent m1349a = m1349a(this.f883a, c1656ha.f2444b, extra, intExtra);
                                m1349a.putExtra("eventMessageType", i);
                                m1349a.putExtra("messageId", str);
                                m1349a.putExtra("jobkey", str3);
                                if (m1349a == null) {
                                    AbstractC1417b.m1089a("Getting Intent fail from ignore reg message. ");
                                    C1566ds.m2275a(this.f883a).m2283b(this.f883a.getPackageName(), C1565dr.m2268a(i), str, "23");
                                    return null;
                                }
                                String m2816c = m3184a.m2816c();
                                if (!TextUtils.isEmpty(m2816c)) {
                                    m1349a.putExtra("payload", m2816c);
                                }
                                this.f883a.startActivity(m1349a);
                                C1451j.m1313a(this.f883a, c1656ha);
                                C1566ds.m2275a(this.f883a).m2281a(this.f883a.getPackageName(), C1565dr.m2268a(i), str, 3006, m4058a);
                                AbstractC1417b.m1090a("PushMessageProcessor", "start business activity succ");
                            } else {
                                Context context = this.f883a;
                                Intent m1349a2 = m1349a(context, context.getPackageName(), extra, intExtra);
                                if (m1349a2 != null) {
                                    if (!m4058a.equals(AbstractC1756an.f3043c)) {
                                        m1349a2.putExtra(PushMessageHelper.KEY_MESSAGE, generateMessage);
                                        m1349a2.putExtra("eventMessageType", i);
                                        m1349a2.putExtra("messageId", str);
                                        m1349a2.putExtra("jobkey", str3);
                                    }
                                    this.f883a.startActivity(m1349a2);
                                    C1451j.m1313a(this.f883a, c1656ha);
                                    AbstractC1417b.m1090a("PushMessageProcessor", "start activity succ");
                                    C1566ds.m2275a(this.f883a).m2281a(this.f883a.getPackageName(), C1565dr.m2268a(i), str, 1006, m4058a);
                                    if (m4058a.equals(AbstractC1756an.f3043c)) {
                                        C1566ds.m2275a(this.f883a).m2282a(this.f883a.getPackageName(), C1565dr.m2268a(i), str, "13");
                                    }
                                } else {
                                    AbstractC1417b.m1104d("PushMessageProcessor", "missing target intent for message: " + m3184a.m2808a() + ", typeId=" + m4058a);
                                }
                            }
                            AbstractC1417b.m1090a("PushMessageProcessor", "pre-def msg process done.");
                            return null;
                        }
                        miPushMessage = generateMessage;
                    }
                    if (c1656ha.m3010a() == null && !z) {
                        m1358a(c1663hh, c1656ha);
                    }
                    return miPushMessage;
                case 2:
                    C1661hf c1661hf = (C1661hf) m1344a;
                    String str4 = C1443b.m1222a(this.f883a).f821a;
                    if (TextUtils.isEmpty(str4) || !TextUtils.equals(str4, c1661hf.m3140a())) {
                        AbstractC1417b.m1089a("bad Registration result:");
                        C1566ds.m2275a(this.f883a).m2283b(this.f883a.getPackageName(), C1565dr.m2268a(i), str, "21");
                        return null;
                    }
                    long m1395a = C1462u.m1373a(this.f883a).m1395a();
                    if (m1395a > 0 && SystemClock.elapsedRealtime() - m1395a > 900000) {
                        AbstractC1417b.m1089a("The received registration result has expired.");
                        C1566ds.m2275a(this.f883a).m2283b(this.f883a.getPackageName(), C1565dr.m2268a(i), str, "26");
                        return null;
                    }
                    C1443b.m1222a(this.f883a).f821a = null;
                    if (c1661hf.f2566a == 0) {
                        C1443b.m1222a(this.f883a).m1239b(c1661hf.f2578e, c1661hf.f2579f, c1661hf.f2585l);
                        FCMPushHelper.persistIfXmsfSupDecrypt(this.f883a);
                        C1566ds.m2275a(this.f883a).m2281a(this.f883a.getPackageName(), C1565dr.m2268a(i), str, 6006, PushClient.DEFAULT_REQUEST_ID);
                    } else {
                        C1566ds.m2275a(this.f883a).m2281a(this.f883a.getPackageName(), C1565dr.m2268a(i), str, 6006, "2");
                    }
                    if (!TextUtils.isEmpty(c1661hf.f2578e)) {
                        arrayList3 = new ArrayList();
                        arrayList3.add(c1661hf.f2578e);
                    }
                    MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(EnumC1577ec.COMMAND_REGISTER.f1521a, arrayList3, c1661hf.f2566a, c1661hf.f2577d, null, c1661hf.m3141a());
                    C1462u.m1373a(this.f883a).m1423d();
                    return generateCommandMessage;
                case 3:
                    if (!c1656ha.m3027b()) {
                        AbstractC1417b.m1103d("receiving an un-encrypt message(UnRegistration).");
                        return null;
                    }
                    if (((C1667hl) m1344a).f2701a == 0) {
                        C1443b.m1222a(this.f883a).m1227a();
                        MiPushClient.clearExtras(this.f883a);
                    }
                    PushMessageHandler.m1200a();
                    return miPushMessage;
                case 4:
                    C1665hj c1665hj = (C1665hj) m1344a;
                    if (c1665hj.f2655a == 0) {
                        MiPushClient.addTopic(this.f883a, c1665hj.m3228b());
                    }
                    if (!TextUtils.isEmpty(c1665hj.m3228b())) {
                        arrayList2 = new ArrayList();
                        arrayList2.add(c1665hj.m3228b());
                    }
                    AbstractC1417b.m1105e("resp-cmd:" + EnumC1577ec.COMMAND_SUBSCRIBE_TOPIC + ", " + c1665hj.m3223a());
                    return PushMessageHelper.generateCommandMessage(EnumC1577ec.COMMAND_SUBSCRIBE_TOPIC.f1521a, arrayList2, c1665hj.f2655a, c1665hj.f2661d, c1665hj.m3230c(), null);
                case 5:
                    C1669hn c1669hn = (C1669hn) m1344a;
                    if (c1669hn.f2738a == 0) {
                        MiPushClient.removeTopic(this.f883a, c1669hn.m3298b());
                    }
                    if (!TextUtils.isEmpty(c1669hn.m3298b())) {
                        arrayList = new ArrayList();
                        arrayList.add(c1669hn.m3298b());
                    }
                    AbstractC1417b.m1105e("resp-cmd:" + EnumC1577ec.COMMAND_UNSUBSCRIBE_TOPIC + ", " + c1669hn.m3293a());
                    return PushMessageHelper.generateCommandMessage(EnumC1577ec.COMMAND_UNSUBSCRIBE_TOPIC.f1521a, arrayList, c1669hn.f2738a, c1669hn.f2744d, c1669hn.m3300c(), null);
                case 6:
                    C1538cr.m1928a(this.f883a.getPackageName(), this.f883a, m1344a, EnumC1633ge.Command, bArr.length);
                    C1654gz c1654gz = (C1654gz) m1344a;
                    String m2993b = c1654gz.m2993b();
                    List<String> m2988a = c1654gz.m2988a();
                    if (c1654gz.f2416a == 0) {
                        if (TextUtils.equals(m2993b, EnumC1577ec.COMMAND_SET_ACCEPT_TIME.f1521a) && m2988a != null && m2988a.size() > 1) {
                            MiPushClient.addAcceptTime(this.f883a, m2988a.get(0), m2988a.get(1));
                            if ("00:00".equals(m2988a.get(0)) && "00:00".equals(m2988a.get(1))) {
                                C1443b.m1222a(this.f883a).m1232a(true);
                            } else {
                                C1443b.m1222a(this.f883a).m1232a(false);
                            }
                            m2988a = m1366a(TimeZone.getTimeZone("GMT+08"), TimeZone.getDefault(), m2988a);
                        } else if (TextUtils.equals(m2993b, EnumC1577ec.COMMAND_SET_ALIAS.f1521a) && m2988a != null && m2988a.size() > 0) {
                            MiPushClient.addAlias(this.f883a, m2988a.get(0));
                        } else if (TextUtils.equals(m2993b, EnumC1577ec.COMMAND_UNSET_ALIAS.f1521a) && m2988a != null && m2988a.size() > 0) {
                            MiPushClient.removeAlias(this.f883a, m2988a.get(0));
                        } else if (TextUtils.equals(m2993b, EnumC1577ec.COMMAND_SET_ACCOUNT.f1521a) && m2988a != null && m2988a.size() > 0) {
                            MiPushClient.addAccount(this.f883a, m2988a.get(0));
                        } else if (TextUtils.equals(m2993b, EnumC1577ec.COMMAND_UNSET_ACCOUNT.f1521a) && m2988a != null && m2988a.size() > 0) {
                            MiPushClient.removeAccount(this.f883a, m2988a.get(0));
                        } else if (TextUtils.equals(m2993b, EnumC1577ec.COMMAND_CHK_VDEVID.f1521a)) {
                            return null;
                        }
                    }
                    List<String> list = m2988a;
                    AbstractC1417b.m1105e("resp-cmd:" + m2993b + ", " + c1654gz.m2987a());
                    return PushMessageHelper.generateCommandMessage(m2993b, list, c1654gz.f2416a, c1654gz.f2424d, c1654gz.m2996c(), null);
                case 7:
                    C1538cr.m1928a(this.f883a.getPackageName(), this.f883a, m1344a, EnumC1633ge.Notification, bArr.length);
                    if (m1344a instanceof C1650gv) {
                        C1650gv c1650gv = (C1650gv) m1344a;
                        String m2929a = c1650gv.m2929a();
                        AbstractC1417b.m1105e("resp-type:" + c1650gv.m2936b() + ", code:" + c1650gv.f2363a + ", " + m2929a);
                        if (EnumC1643go.DisablePushMessage.f2208a.equalsIgnoreCase(c1650gv.f2370d)) {
                            if (c1650gv.f2363a == 0) {
                                synchronized (C1457p.class) {
                                    if (C1457p.m1333a(this.f883a).m1338a(m2929a)) {
                                        C1457p.m1333a(this.f883a).m1340c(m2929a);
                                        if ("syncing".equals(C1457p.m1333a(this.f883a).m1335a(EnumC1463v.DISABLE_PUSH))) {
                                            C1457p.m1333a(this.f883a).m1336a(EnumC1463v.DISABLE_PUSH, "synced");
                                            MiPushClient.clearNotification(this.f883a);
                                            MiPushClient.clearLocalNotificationType(this.f883a);
                                            PushMessageHandler.m1200a();
                                            C1462u.m1373a(this.f883a).m1419b();
                                        }
                                    }
                                }
                            } else if ("syncing".equals(C1457p.m1333a(this.f883a).m1335a(EnumC1463v.DISABLE_PUSH))) {
                                synchronized (C1457p.class) {
                                    if (C1457p.m1333a(this.f883a).m1338a(m2929a)) {
                                        if (C1457p.m1333a(this.f883a).m1334a(m2929a) < 10) {
                                            C1457p.m1333a(this.f883a).m1339b(m2929a);
                                            C1462u.m1373a(this.f883a).m1416a(true, m2929a);
                                        } else {
                                            C1457p.m1333a(this.f883a).m1340c(m2929a);
                                        }
                                    }
                                }
                            } else {
                                C1457p.m1333a(this.f883a).m1340c(m2929a);
                            }
                        } else if (EnumC1643go.EnablePushMessage.f2208a.equalsIgnoreCase(c1650gv.f2370d)) {
                            if (c1650gv.f2363a == 0) {
                                synchronized (C1457p.class) {
                                    if (C1457p.m1333a(this.f883a).m1338a(m2929a)) {
                                        C1457p.m1333a(this.f883a).m1340c(m2929a);
                                        if ("syncing".equals(C1457p.m1333a(this.f883a).m1335a(EnumC1463v.ENABLE_PUSH))) {
                                            C1457p.m1333a(this.f883a).m1336a(EnumC1463v.ENABLE_PUSH, "synced");
                                        }
                                    }
                                }
                            } else if ("syncing".equals(C1457p.m1333a(this.f883a).m1335a(EnumC1463v.ENABLE_PUSH))) {
                                synchronized (C1457p.class) {
                                    if (C1457p.m1333a(this.f883a).m1338a(m2929a)) {
                                        if (C1457p.m1333a(this.f883a).m1334a(m2929a) < 10) {
                                            C1457p.m1333a(this.f883a).m1339b(m2929a);
                                            C1462u.m1373a(this.f883a).m1416a(false, m2929a);
                                        } else {
                                            C1457p.m1333a(this.f883a).m1340c(m2929a);
                                        }
                                    }
                                }
                            } else {
                                C1457p.m1333a(this.f883a).m1340c(m2929a);
                            }
                        } else if (EnumC1643go.ThirdPartyRegUpdate.f2208a.equalsIgnoreCase(c1650gv.f2370d)) {
                            m1362b(c1650gv);
                        } else if (EnumC1643go.UploadTinyData.f2208a.equalsIgnoreCase(c1650gv.f2370d)) {
                            m1355a(c1650gv);
                        }
                    } else if (m1344a instanceof C1659hd) {
                        C1659hd c1659hd = (C1659hd) m1344a;
                        if ("registration id expired".equalsIgnoreCase(c1659hd.f2478d)) {
                            List<String> allAlias = MiPushClient.getAllAlias(this.f883a);
                            List<String> allTopic = MiPushClient.getAllTopic(this.f883a);
                            List<String> allUserAccount = MiPushClient.getAllUserAccount(this.f883a);
                            String acceptTime = MiPushClient.getAcceptTime(this.f883a);
                            AbstractC1417b.m1105e("resp-type:" + c1659hd.f2478d + ", " + c1659hd.m3052a());
                            MiPushClient.reInitialize(this.f883a, EnumC1647gs.RegIdExpired);
                            for (String str5 : allAlias) {
                                MiPushClient.removeAlias(this.f883a, str5);
                                MiPushClient.setAlias(this.f883a, str5, null);
                            }
                            for (String str6 : allTopic) {
                                MiPushClient.removeTopic(this.f883a, str6);
                                MiPushClient.subscribe(this.f883a, str6, null);
                            }
                            for (String str7 : allUserAccount) {
                                MiPushClient.removeAccount(this.f883a, str7);
                                MiPushClient.setUserAccount(this.f883a, str7, null);
                            }
                            String[] split = acceptTime.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            if (split.length == 2) {
                                MiPushClient.removeAcceptTime(this.f883a);
                                MiPushClient.addAcceptTime(this.f883a, split[0], split[1]);
                            }
                        } else if (EnumC1643go.ClientInfoUpdateOk.f2208a.equalsIgnoreCase(c1659hd.f2478d)) {
                            if (c1659hd.m3053a() != null && c1659hd.m3053a().containsKey("app_version")) {
                                C1443b.m1222a(this.f883a).m1229a(c1659hd.m3053a().get("app_version"));
                            }
                        } else {
                            try {
                                if (EnumC1643go.NormalClientConfigUpdate.f2208a.equalsIgnoreCase(c1659hd.f2478d)) {
                                    C1658hc c1658hc = new C1658hc();
                                    C1670ho.m3312a(c1658hc, c1659hd.m3059a());
                                    C1751ai.m3691a(C1750ah.m3674a(this.f883a), c1658hc);
                                } else if (EnumC1643go.CustomClientConfigUpdate.f2208a.equalsIgnoreCase(c1659hd.f2478d)) {
                                    C1657hb c1657hb = new C1657hb();
                                    C1670ho.m3312a(c1657hb, c1659hd.m3059a());
                                    C1751ai.m3690a(C1750ah.m3674a(this.f883a), c1657hb);
                                } else if (EnumC1643go.SyncInfoResult.f2208a.equalsIgnoreCase(c1659hd.f2478d)) {
                                    C1464w.m1428a(this.f883a, c1659hd);
                                } else if (EnumC1643go.ForceSync.f2208a.equalsIgnoreCase(c1659hd.f2478d)) {
                                    AbstractC1417b.m1089a("receive force sync notification");
                                    C1464w.m1429a(this.f883a, false);
                                } else if (EnumC1643go.CancelPushMessage.f2208a.equals(c1659hd.f2478d)) {
                                    AbstractC1417b.m1105e("resp-type:" + c1659hd.f2478d + ", " + c1659hd.m3052a());
                                    if (c1659hd.m3053a() != null) {
                                        int i2 = -2;
                                        if (c1659hd.m3053a().containsKey(AbstractC1756an.f3039Q)) {
                                            String str8 = c1659hd.m3053a().get(AbstractC1756an.f3039Q);
                                            if (!TextUtils.isEmpty(str8)) {
                                                try {
                                                    i2 = Integer.parseInt(str8);
                                                } catch (NumberFormatException e) {
                                                    e.printStackTrace();
                                                }
                                            }
                                        }
                                        if (i2 >= -1) {
                                            MiPushClient.clearNotification(this.f883a, i2);
                                        } else {
                                            MiPushClient.clearNotification(this.f883a, c1659hd.m3053a().containsKey(AbstractC1756an.f3037O) ? c1659hd.m3053a().get(AbstractC1756an.f3037O) : "", c1659hd.m3053a().containsKey(AbstractC1756an.f3038P) ? c1659hd.m3053a().get(AbstractC1756an.f3038P) : "");
                                        }
                                    }
                                    m1357a(c1659hd);
                                } else if (EnumC1643go.HybridRegisterResult.f2208a.equals(c1659hd.f2478d)) {
                                    try {
                                        C1661hf c1661hf2 = new C1661hf();
                                        C1670ho.m3312a(c1661hf2, c1659hd.m3059a());
                                        MiPushClient4Hybrid.onReceiveRegisterResult(this.f883a, c1661hf2);
                                    } catch (C1675ht e2) {
                                        AbstractC1417b.m1093a(e2);
                                    }
                                } else if (EnumC1643go.HybridUnregisterResult.f2208a.equals(c1659hd.f2478d)) {
                                    try {
                                        C1667hl c1667hl = new C1667hl();
                                        C1670ho.m3312a(c1667hl, c1659hd.m3059a());
                                        MiPushClient4Hybrid.onReceiveUnregisterResult(this.f883a, c1667hl);
                                    } catch (C1675ht e3) {
                                        AbstractC1417b.m1093a(e3);
                                    }
                                } else if (!EnumC1643go.PushLogUpload.f2208a.equals(c1659hd.f2478d)) {
                                    if (EnumC1643go.DetectAppAlive.f2208a.equals(c1659hd.f2478d)) {
                                        AbstractC1417b.m1098b("receive detect msg");
                                        m1364b(c1659hd);
                                    } else if (C1778g.m3847a(c1659hd)) {
                                        AbstractC1417b.m1098b("receive notification handle by cpra");
                                    }
                                }
                            } catch (C1675ht unused) {
                            }
                        }
                    }
                    return miPushMessage;
                default:
                    return miPushMessage;
            }
        } catch (C1453l e4) {
            AbstractC1417b.m1093a(e4);
            m1356a(c1656ha);
            C1566ds.m2275a(this.f883a).m2283b(this.f883a.getPackageName(), C1565dr.m2268a(i), str, "19");
            C1451j.m1317c(this.f883a, c1656ha, z);
            return null;
        } catch (C1675ht e5) {
            AbstractC1417b.m1093a(e5);
            AbstractC1417b.m1103d("receive a message which action string is not valid. is the reg expired?");
            C1566ds.m2275a(this.f883a).m2283b(this.f883a.getPackageName(), C1565dr.m2268a(i), str, "20");
            C1451j.m1317c(this.f883a, c1656ha, z);
            return null;
        }
    }

    /* renamed from: a */
    private void m1359a(String str, long j, EnumC1445d enumC1445d) {
        EnumC1463v m1301a = C1448g.m1301a(enumC1445d);
        if (m1301a == null) {
            return;
        }
        if (j == 0) {
            synchronized (C1457p.class) {
                if (C1457p.m1333a(this.f883a).m1338a(str)) {
                    C1457p.m1333a(this.f883a).m1340c(str);
                    if ("syncing".equals(C1457p.m1333a(this.f883a).m1335a(m1301a))) {
                        C1457p.m1333a(this.f883a).m1336a(m1301a, "synced");
                    }
                }
            }
            return;
        }
        if ("syncing".equals(C1457p.m1333a(this.f883a).m1335a(m1301a))) {
            synchronized (C1457p.class) {
                if (C1457p.m1333a(this.f883a).m1338a(str)) {
                    if (C1457p.m1333a(this.f883a).m1334a(str) < 10) {
                        C1457p.m1333a(this.f883a).m1339b(str);
                        C1462u.m1373a(this.f883a).m1413a(str, m1301a, enumC1445d, "retry");
                    } else {
                        C1457p.m1333a(this.f883a).m1340c(str);
                    }
                }
            }
            return;
        }
        C1457p.m1333a(this.f883a).m1340c(str);
    }

    /* renamed from: a */
    private void m1355a(C1650gv c1650gv) {
        String m2929a = c1650gv.m2929a();
        AbstractC1417b.m1098b("receive ack " + m2929a);
        Map<String, String> m2930a = c1650gv.m2930a();
        if (m2930a != null) {
            String str = m2930a.get("real_source");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            AbstractC1417b.m1098b("receive ack : messageId = " + m2929a + "  realSource = " + str);
            C1506bm.m1678a(this.f883a).m1689a(m2929a, str, Boolean.valueOf(c1650gv.f2363a == 0));
        }
    }

    /* renamed from: b */
    private void m1362b(C1650gv c1650gv) {
        AbstractC1417b.m1101c("ASSEMBLE_PUSH : " + c1650gv.toString());
        String m2929a = c1650gv.m2929a();
        Map<String, String> m2930a = c1650gv.m2930a();
        if (m2930a != null) {
            String str = m2930a.get(Constants.ASSEMBLE_PUSH_REG_INFO);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (str.contains("brand:" + EnumC1458q.FCM.name())) {
                AbstractC1417b.m1089a("ASSEMBLE_PUSH : receive fcm token sync ack");
                C1447f.m1295b(this.f883a, EnumC1445d.ASSEMBLE_PUSH_FCM, str);
                m1359a(m2929a, c1650gv.f2363a, EnumC1445d.ASSEMBLE_PUSH_FCM);
                return;
            }
            if (str.contains("brand:" + EnumC1458q.HUAWEI.name()) || str.contains("channel:" + EnumC1458q.HUAWEI.name())) {
                AbstractC1417b.m1089a("ASSEMBLE_PUSH : receive hw token sync ack");
                C1447f.m1295b(this.f883a, EnumC1445d.ASSEMBLE_PUSH_HUAWEI, str);
                m1359a(m2929a, c1650gv.f2363a, EnumC1445d.ASSEMBLE_PUSH_HUAWEI);
            } else if (str.contains("brand:" + EnumC1458q.OPPO.name()) || str.contains("channel:" + EnumC1458q.OPPO.name())) {
                AbstractC1417b.m1089a("ASSEMBLE_PUSH : receive COS token sync ack");
                C1447f.m1295b(this.f883a, EnumC1445d.ASSEMBLE_PUSH_COS, str);
                m1359a(m2929a, c1650gv.f2363a, EnumC1445d.ASSEMBLE_PUSH_COS);
            } else if (str.contains("brand:" + EnumC1458q.VIVO.name()) || str.contains("channel:" + EnumC1458q.VIVO.name())) {
                AbstractC1417b.m1089a("ASSEMBLE_PUSH : receive FTOS token sync ack");
                C1447f.m1295b(this.f883a, EnumC1445d.ASSEMBLE_PUSH_FTOS, str);
                m1359a(m2929a, c1650gv.f2363a, EnumC1445d.ASSEMBLE_PUSH_FTOS);
            }
        }
    }

    /* renamed from: a */
    public List<String> m1366a(TimeZone timeZone, TimeZone timeZone2, List<String> list) {
        if (timeZone.equals(timeZone2)) {
            return list;
        }
        long rawOffset = ((timeZone.getRawOffset() - timeZone2.getRawOffset()) / 1000) / 60;
        long parseLong = ((((Long.parseLong(list.get(0).split(Constants.COLON_SEPARATOR)[0]) * 60) + Long.parseLong(list.get(0).split(Constants.COLON_SEPARATOR)[1])) - rawOffset) + 1440) % 1440;
        long parseLong2 = ((((Long.parseLong(list.get(1).split(Constants.COLON_SEPARATOR)[0]) * 60) + Long.parseLong(list.get(1).split(Constants.COLON_SEPARATOR)[1])) - rawOffset) + 1440) % 1440;
        ArrayList arrayList = new ArrayList();
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(parseLong / 60), Long.valueOf(parseLong % 60)));
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(parseLong2 / 60), Long.valueOf(parseLong2 % 60)));
        return arrayList;
    }

    /* renamed from: a */
    private void m1353a() {
        SharedPreferences sharedPreferences = this.f883a.getSharedPreferences("mipush_extra", 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - sharedPreferences.getLong(Constants.SP_KEY_LAST_REINITIALIZE, 0L)) > 1800000) {
            MiPushClient.reInitialize(this.f883a, EnumC1647gs.PackageUnregistered);
            sharedPreferences.edit().putLong(Constants.SP_KEY_LAST_REINITIALIZE, currentTimeMillis).commit();
        }
    }

    /* renamed from: a */
    private void m1356a(C1656ha c1656ha) {
        AbstractC1417b.m1089a("receive a message but decrypt failed. report now.");
        C1659hd c1659hd = new C1659hd(c1656ha.m3010a().f2279a, false);
        c1659hd.m3064c(EnumC1643go.DecryptMessageFail.f2208a);
        c1659hd.m3060b(c1656ha.m3017a());
        c1659hd.m3068d(c1656ha.f2444b);
        c1659hd.f2473a = new HashMap();
        c1659hd.f2473a.put("regid", MiPushClient.getRegId(this.f883a));
        C1462u.m1373a(this.f883a).m1407a((C1462u) c1659hd, EnumC1633ge.Notification, false, (C1646gr) null);
    }

    /* renamed from: b */
    private void m1363b(C1656ha c1656ha) {
        C1646gr m3010a = c1656ha.m3010a();
        if (m3010a != null) {
            m3010a = C1763au.m3762a(m3010a.m2838a());
        }
        C1649gu c1649gu = new C1649gu();
        c1649gu.m2899b(c1656ha.m3017a());
        c1649gu.m2893a(m3010a.m2842a());
        c1649gu.m2892a(m3010a.m2837a());
        if (!TextUtils.isEmpty(m3010a.m2852b())) {
            c1649gu.m2902c(m3010a.m2852b());
        }
        c1649gu.m2894a(C1670ho.m3309a(this.f883a, c1656ha));
        C1462u.m1373a(this.f883a).m1407a((C1462u) c1649gu, EnumC1633ge.AckMessage, false, m3010a);
    }

    /* renamed from: a */
    private void m1358a(C1663hh c1663hh, C1656ha c1656ha) {
        C1646gr m3010a = c1656ha.m3010a();
        if (m3010a != null) {
            m3010a = C1763au.m3762a(m3010a.m2838a());
        }
        C1649gu c1649gu = new C1649gu();
        c1649gu.m2899b(c1663hh.m3190b());
        c1649gu.m2893a(c1663hh.m3185a());
        c1649gu.m2892a(c1663hh.m3184a().m2807a());
        if (!TextUtils.isEmpty(c1663hh.m3192c())) {
            c1649gu.m2902c(c1663hh.m3192c());
        }
        if (!TextUtils.isEmpty(c1663hh.m3194d())) {
            c1649gu.m2905d(c1663hh.m3194d());
        }
        c1649gu.m2894a(C1670ho.m3309a(this.f883a, c1656ha));
        C1462u.m1373a(this.f883a).m1405a((C1462u) c1649gu, EnumC1633ge.AckMessage, m3010a);
    }

    /* renamed from: a */
    private void m1357a(C1659hd c1659hd) {
        C1650gv c1650gv = new C1650gv();
        c1650gv.m2938c(EnumC1643go.CancelPushMessageACK.f2208a);
        c1650gv.m2928a(c1659hd.m3052a());
        c1650gv.m2927a(c1659hd.m3046a());
        c1650gv.m2935b(c1659hd.m3061b());
        c1650gv.m2942e(c1659hd.m3069d());
        c1650gv.m2926a(0L);
        c1650gv.m2940d("success clear push message.");
        C1462u.m1373a(this.f883a).m1411a(c1650gv, EnumC1633ge.Notification, false, true, null, false, this.f883a.getPackageName(), C1443b.m1222a(this.f883a).m1226a(), false);
    }

    /* renamed from: a */
    private static boolean m1360a(Context context, String str) {
        synchronized (f881a) {
            C1443b.m1222a(context);
            SharedPreferences m1221a = C1443b.m1221a(context);
            if (f882a == null) {
                String[] split = m1221a.getString("pref_msg_ids", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                f882a = new LinkedList();
                for (String str2 : split) {
                    f882a.add(str2);
                }
            }
            if (f882a.contains(str)) {
                return true;
            }
            f882a.add(str);
            if (f882a.size() > 25) {
                f882a.poll();
            }
            String m1627a = C1494ba.m1627a(f882a, Constants.ACCEPT_TIME_SEPARATOR_SP);
            SharedPreferences.Editor edit = m1221a.edit();
            edit.putString("pref_msg_ids", m1627a);
            C1699o.m3458a(edit);
            return false;
        }
    }

    /* renamed from: a */
    public static void m1354a(Context context, String str) {
        synchronized (f881a) {
            f882a.remove(str);
            C1443b.m1222a(context);
            SharedPreferences m1221a = C1443b.m1221a(context);
            String m1627a = C1494ba.m1627a(f882a, Constants.ACCEPT_TIME_SEPARATOR_SP);
            SharedPreferences.Editor edit = m1221a.edit();
            edit.putString("pref_msg_ids", m1627a);
            C1699o.m3458a(edit);
        }
    }

    /* renamed from: a */
    public static Intent m1349a(Context context, String str, Map<String, String> map, int i) {
        return C1796x.m4079b(context, str, map, i);
    }

    /* renamed from: a */
    private boolean m1361a(C1656ha c1656ha) {
        Map<String, String> m2843a = c1656ha.m3010a() == null ? null : c1656ha.m3010a().m2843a();
        if (m2843a == null) {
            return false;
        }
        String str = m2843a.get(Constants.EXTRA_KEY_PUSH_SERVER_ACTION);
        return TextUtils.equals(str, Constants.EXTRA_VALUE_HYBRID_MESSAGE) || TextUtils.equals(str, Constants.EXTRA_VALUE_PLATFORM_MESSAGE);
    }

    /* renamed from: b */
    private void m1364b(C1659hd c1659hd) {
        Map<String, String> m3053a = c1659hd.m3053a();
        if (m3053a == null) {
            AbstractC1417b.m1089a("detect failed because null");
            return;
        }
        String str = (String) C1749ag.m3656a(m3053a, "pkgList", (Object) null);
        if (TextUtils.isEmpty(str)) {
            AbstractC1417b.m1089a("detect failed because empty");
            return;
        }
        Map<String, String> m2684a = C1628g.m2684a(this.f883a, str);
        if (m2684a != null) {
            String str2 = m2684a.get("alive");
            String str3 = m2684a.get("notAlive");
            if (!TextUtils.isEmpty(str2)) {
                C1659hd c1659hd2 = new C1659hd();
                c1659hd2.m3047a(c1659hd.m3052a());
                c1659hd2.m3060b(c1659hd.m3061b());
                c1659hd2.m3068d(c1659hd.m3069d());
                c1659hd2.m3064c(EnumC1643go.DetectAppAliveResult.f2208a);
                c1659hd2.f2473a = new HashMap();
                c1659hd2.f2473a.put("alive", str2);
                if (Boolean.parseBoolean((String) C1749ag.m3656a(m3053a, "reportNotAliveApp", "false")) && !TextUtils.isEmpty(str3)) {
                    c1659hd2.f2473a.put("notAlive", str3);
                }
                C1462u.m1373a(this.f883a).m1407a((C1462u) c1659hd2, EnumC1633ge.Notification, false, (C1646gr) null);
                return;
            }
            AbstractC1417b.m1098b("detect failed because no alive process");
            return;
        }
        AbstractC1417b.m1089a("detect failed because get status illegal");
    }
}
