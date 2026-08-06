package com.huawei.hms.hatool;

/* renamed from: com.huawei.hms.hatool.v */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1182v {

    /* renamed from: a */
    private static C1161m0 f1578a = new C1161m0();

    /* renamed from: a */
    public static void m1774a(int i) {
        f1578a.m1626a(i);
    }

    /* renamed from: a */
    public static void m1775a(String str, String str2) {
        if (!m1777a() || str == null || str2 == null) {
            return;
        }
        f1578a.m1628b(3, str, str2);
    }

    /* renamed from: a */
    public static void m1776a(String str, String str2, Object... objArr) {
        if (!m1782c() || str == null || str2 == null) {
            return;
        }
        f1578a.m1628b(4, str, String.format(str2, objArr));
    }

    /* renamed from: a */
    private static boolean m1777a() {
        return f1578a.m1629b(3);
    }

    /* renamed from: b */
    public static void m1778b(String str, String str2) {
        if (!m1780b() || str == null || str2 == null) {
            return;
        }
        f1578a.m1628b(6, str, str2);
    }

    /* renamed from: b */
    public static void m1779b(String str, String str2, Object... objArr) {
        m1783d(str, String.format(str2, objArr));
    }

    /* renamed from: b */
    private static boolean m1780b() {
        return f1578a.m1629b(6);
    }

    /* renamed from: c */
    public static void m1781c(String str, String str2) {
        if (!m1782c() || str == null || str2 == null) {
            return;
        }
        f1578a.m1628b(4, str, str2);
    }

    /* renamed from: c */
    private static boolean m1782c() {
        return f1578a.m1629b(4);
    }

    /* renamed from: d */
    public static void m1783d(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        f1578a.m1628b(4, str, str2);
    }

    /* renamed from: d */
    private static boolean m1784d() {
        return f1578a.m1629b(5);
    }

    /* renamed from: e */
    public static void m1785e(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        f1578a.m1628b(5, str, str2);
    }

    /* renamed from: f */
    public static void m1786f(String str, String str2) {
        if (!m1784d() || str == null || str2 == null) {
            return;
        }
        f1578a.m1628b(5, str, str2);
    }
}
