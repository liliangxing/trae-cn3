package com.unicom.online.account.kernel;

import com.vivo.push.PushClient;

/* renamed from: com.unicom.online.account.kernel.ab */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1166ab {

    /* renamed from: a */
    public static String f226a = "123.125.99.31";

    /* renamed from: b */
    public static String f227b = "0";

    /* renamed from: c */
    public static AbstractC1172d f228c = null;

    /* renamed from: d */
    private static String f229d = "";

    /* renamed from: e */
    private static String f230e = "";

    /* renamed from: f */
    private static String f231f = "";

    /* renamed from: g */
    private static int f232g = 5;

    /* renamed from: h */
    private static int f233h = -1;

    /* renamed from: i */
    private static String f234i = "";

    /* renamed from: j */
    private static String f235j = "";

    /* renamed from: a */
    public static String m452a() {
        return "https://" + C1174f.m524e() + "/unicomAuth/android/v3.0/qc?";
    }

    /* renamed from: a */
    public static void m453a(int i) {
        f232g = i;
    }

    /* renamed from: a */
    public static void m454a(String str) {
        f227b = str;
    }

    /* renamed from: b */
    public static String m455b() {
        return f227b;
    }

    /* renamed from: b */
    public static void m456b(int i) {
        f233h = i;
    }

    /* renamed from: b */
    public static void m457b(String str) {
        f229d = str;
    }

    /* renamed from: c */
    public static String m458c() {
        return f229d;
    }

    /* renamed from: c */
    public static void m459c(String str) {
        f230e = str;
    }

    /* renamed from: d */
    public static String m460d() {
        return f230e;
    }

    /* renamed from: d */
    public static void m461d(String str) {
        C1165aa.m448b("APN:".concat(String.valueOf(str)));
        f231f = str;
    }

    /* renamed from: e */
    public static String m462e() {
        return f231f;
    }

    /* renamed from: e */
    public static String m463e(String str) {
        return ("cmnet".equals(str) || "cmwap".equals(str)) ? PushClient.DEFAULT_REQUEST_ID : ("3gwap".equals(str) || "uniwap".equals(str) || "3gnet".equals(str) || "uninet".equals(str)) ? "3" : ("ctnet".equals(str) || "ctwap".equals(str)) ? "2" : "0";
    }

    /* renamed from: f */
    public static int m464f() {
        return f232g;
    }

    /* renamed from: f */
    public static void m465f(String str) {
        f234i = str;
    }

    /* renamed from: g */
    public static int m466g() {
        return f233h;
    }

    /* renamed from: g */
    public static void m467g(String str) {
        f235j = str;
    }
}
