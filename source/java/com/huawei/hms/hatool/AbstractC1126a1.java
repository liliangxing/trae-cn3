package com.huawei.hms.hatool;

import java.util.Map;

/* renamed from: com.huawei.hms.hatool.a1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public abstract class AbstractC1126a1 {
    /* renamed from: a */
    public static void m1413a(String str, String str2, long j) {
        C1177s0 m1421h = m1421h(str, str2);
        if (m1421h != null) {
            m1421h.m1729a(j);
        }
    }

    /* renamed from: a */
    public static boolean m1414a(String str, String str2) {
        C1177s0 m1421h = m1421h(str, str2);
        if (m1421h != null) {
            return m1421h.m1733a();
        }
        return true;
    }

    /* renamed from: b */
    public static int m1415b(String str, String str2) {
        C1177s0 m1421h = m1421h(str, str2);
        if (m1421h != null) {
            return m1421h.m1741d();
        }
        return 7;
    }

    /* renamed from: c */
    public static boolean m1416c(String str, String str2) {
        C1177s0 m1421h = m1421h(str, str2);
        if (m1421h != null) {
            return m1421h.m1750g();
        }
        return true;
    }

    /* renamed from: d */
    public static String m1417d(String str, String str2) {
        C1177s0 m1421h = m1421h(str, str2);
        return m1421h != null ? m1421h.m1747f() : "";
    }

    /* renamed from: e */
    public static boolean m1418e(String str, String str2) {
        C1177s0 m1421h = m1421h(str, str2);
        if (m1421h != null) {
            return m1421h.m1752i();
        }
        return false;
    }

    /* renamed from: f */
    public static String m1419f(String str, String str2) {
        C1177s0 m1421h = m1421h(str, str2);
        return m1421h != null ? m1421h.m1751h() : "";
    }

    /* renamed from: g */
    public static String m1420g(String str, String str2) {
        C1177s0 m1421h = m1421h(str, str2);
        return m1421h != null ? m1421h.m1757n() : "";
    }

    /* renamed from: h */
    private static C1177s0 m1421h(String str, String str2) {
        C1159l1 m1724a = C1176s.m1722c().m1724a(str);
        if (m1724a == null) {
            return null;
        }
        if (!"alltype".equals(str2)) {
            return m1724a.m1615a(str2);
        }
        C1177s0 m1615a = m1724a.m1615a("oper");
        return m1615a == null ? m1724a.m1615a("maint") : m1615a;
    }

    /* renamed from: i */
    public static Map<String, String> m1422i(String str, String str2) {
        C1177s0 m1421h = m1421h(str, str2);
        if (m1421h != null) {
            return m1421h.m1754k();
        }
        return null;
    }

    /* renamed from: j */
    public static long m1423j(String str, String str2) {
        C1177s0 m1421h = m1421h(str, str2);
        if (m1421h != null) {
            return m1421h.m1755l();
        }
        return 0L;
    }

    /* renamed from: k */
    public static int m1424k(String str, String str2) {
        C1177s0 m1421h = m1421h(str, str2);
        if (m1421h != null) {
            return m1421h.m1734b();
        }
        return 10;
    }

    /* renamed from: l */
    public static String m1425l(String str, String str2) {
        C1177s0 m1421h = m1421h(str, str2);
        return m1421h != null ? m1421h.m1758o() : "";
    }

    /* renamed from: m */
    public static String m1426m(String str, String str2) {
        C1177s0 m1421h = m1421h(str, str2);
        return m1421h != null ? m1421h.m1760q() : "";
    }

    /* renamed from: n */
    public static String m1427n(String str, String str2) {
        C1177s0 m1421h = m1421h(str, str2);
        return m1421h != null ? m1421h.m1756m() : "";
    }

    /* renamed from: o */
    public static String m1428o(String str, String str2) {
        C1177s0 m1421h = m1421h(str, str2);
        return m1421h != null ? m1421h.m1759p() : "";
    }
}
