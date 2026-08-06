package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.service.C1784m;

/* renamed from: com.xiaomi.push.cm */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1533cm {

    /* renamed from: a */
    private static int f1186a = -1;

    /* renamed from: a */
    private static C1537cq f1187a;

    /* renamed from: a */
    private static String f1188a;

    /* renamed from: a */
    public static void m1868a(Context context, AbstractC1600ez abstractC1600ez) {
        if (m1872a(context)) {
            if (f1187a == null) {
                f1187a = new C1537cq(context);
            }
            abstractC1600ez.m2508a(f1187a);
            m1871a("startStats");
        }
    }

    /* renamed from: b */
    public static void m1873b(Context context, AbstractC1600ez abstractC1600ez) {
        C1537cq c1537cq = f1187a;
        if (c1537cq != null) {
            abstractC1600ez.m2517b(c1537cq);
            f1187a = null;
            m1871a("stopStats");
        }
    }

    /* renamed from: a */
    private static boolean m1872a(Context context) {
        return C1530cj.m1861a(context);
    }

    /* renamed from: a */
    public static void m1870a(Context context, String str, int i) {
        if (!m1872a(context)) {
            m1871a("onDisconnection shouldSampling = false");
            return;
        }
        C1536cp.m1912a(context, str, C1486at.m1547b(context), System.currentTimeMillis(), i, C1784m.m3872a(context).m3896b(), m1865a(context), m1866a(), f1186a);
        m1871a("onDisconnection");
    }

    /* renamed from: a */
    public static void m1867a(Context context) {
        if (!m1872a(context)) {
            m1871a("onReconnection shouldSampling = false");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        f1186a = m1865a(context);
        C1536cp.m1910a(context, currentTimeMillis);
        m1871a("onReconnection connectedNetworkType = " + f1186a);
    }

    /* renamed from: a */
    public static void m1869a(Context context, String str) {
        if (!m1872a(context)) {
            m1871a("onWifiChanged shouldSampling = false");
            return;
        }
        m1871a("onWifiChanged wifiDigest = " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        m1874b("W-" + str);
    }

    /* renamed from: a */
    private static int m1865a(Context context) {
        try {
            C1487au m1530a = C1486at.m1530a();
            if (m1530a != null) {
                if (m1530a.m1557a() == 0) {
                    String m1563b = m1530a.m1563b();
                    m1874b((TextUtils.isEmpty(m1563b) || "UNKNOWN".equalsIgnoreCase(m1563b)) ? null : "M-" + m1563b);
                    return 0;
                }
                if (m1530a.m1557a() != 1 && m1530a.m1557a() != 6) {
                    m1874b(null);
                    return -1;
                }
                m1874b("WIFI-ID-UNKNOWN");
                return 1;
            }
            m1874b(null);
            return -1;
        } catch (Exception e) {
            AbstractC1417b.m1103d("DisconnectStatsHelper getNetType occurred error: " + e.getMessage());
            m1874b(null);
            return -1;
        }
    }

    /* renamed from: b */
    private static synchronized void m1874b(String str) {
        synchronized (C1533cm.class) {
            if ("WIFI-ID-UNKNOWN".equals(str)) {
                String str2 = f1188a;
                if (str2 == null || !str2.startsWith("W-")) {
                    f1188a = null;
                }
            } else {
                f1188a = str;
            }
            m1871a("updateNetId new networkId = " + str + ", finally netId = " + f1188a);
        }
    }

    /* renamed from: a */
    private static synchronized String m1866a() {
        String str;
        synchronized (C1533cm.class) {
            str = f1188a;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m1871a(String str) {
        C1530cj.m1860a("Push-DiscntStats", str);
    }
}
