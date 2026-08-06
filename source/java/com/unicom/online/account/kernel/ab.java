package com.unicom.online.account.kernel;

/* loaded from: classes7.dex */
public final class ab {
    public static String a = "123.125.99.31";
    public static String b = "0";
    public static d c = null;
    private static String d = "";
    private static String e = "";
    private static String f = "";
    private static int g = 5;
    private static int h = -1;
    private static String i = "";
    private static String j = "";

    public static String a() {
        return "https://" + f.e() + "/unicomAuth/android/v3.0/qc?";
    }

    public static void a(int i2) {
        g = i2;
    }

    public static void a(String str) {
        b = str;
    }

    public static String b() {
        return b;
    }

    public static void b(int i2) {
        h = i2;
    }

    public static void b(String str) {
        d = str;
    }

    public static String c() {
        return d;
    }

    public static void c(String str) {
        e = str;
    }

    public static String d() {
        return e;
    }

    public static void d(String str) {
        aa.b("APN:".concat(String.valueOf(str)));
        f = str;
    }

    public static String e() {
        return f;
    }

    public static String e(String str) {
        return ("cmnet".equals(str) || "cmwap".equals(str)) ? "1" : ("3gwap".equals(str) || "uniwap".equals(str) || "3gnet".equals(str) || "uninet".equals(str)) ? "3" : ("ctnet".equals(str) || "ctwap".equals(str)) ? "2" : "0";
    }

    public static int f() {
        return g;
    }

    public static void f(String str) {
        i = str;
    }

    public static int g() {
        return h;
    }

    public static void g(String str) {
        j = str;
    }
}
