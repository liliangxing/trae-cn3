package com.heytap.mcssdk.utils;

import android.util.Log;

/* renamed from: com.heytap.mcssdk.utils.d */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0895d {

    /* renamed from: a */
    public static final String f621a = "mcssdk---";

    /* renamed from: b */
    private static String f622b = "MCS";

    /* renamed from: c */
    private static boolean f623c = false;

    /* renamed from: d */
    private static boolean f624d = false;

    /* renamed from: e */
    private static boolean f625e = true;

    /* renamed from: f */
    private static boolean f626f = true;

    /* renamed from: g */
    private static boolean f627g = true;

    /* renamed from: h */
    private static String f628h = "-->";

    /* renamed from: i */
    private static boolean f629i = true;

    /* renamed from: a */
    public static String m655a() {
        return f622b;
    }

    /* renamed from: a */
    public static void m656a(Exception exc) {
        if (!f627g || exc == null) {
            return;
        }
        Log.e(f621a, exc.getMessage());
    }

    /* renamed from: a */
    public static void m657a(String str) {
        if (f623c && f629i) {
            Log.v(f621a, f622b + f628h + str);
        }
    }

    /* renamed from: a */
    public static void m658a(String str, String str2) {
        if (f623c && f629i) {
            Log.v(str, f622b + f628h + str2);
        }
    }

    /* renamed from: a */
    public static void m659a(String str, Throwable th) {
        if (f627g) {
            Log.e(str, th.toString());
        }
    }

    /* renamed from: a */
    public static void m660a(boolean z) {
        f623c = z;
    }

    /* renamed from: b */
    public static void m661b(String str) {
        if (f625e && f629i) {
            Log.d(f621a, f622b + f628h + str);
        }
    }

    /* renamed from: b */
    public static void m662b(String str, String str2) {
        if (f625e && f629i) {
            Log.d(str, f622b + f628h + str2);
        }
    }

    /* renamed from: b */
    public static void m663b(boolean z) {
        f625e = z;
    }

    /* renamed from: b */
    public static boolean m664b() {
        return f623c;
    }

    /* renamed from: c */
    public static void m665c(String str) {
        if (f624d && f629i) {
            Log.i(f621a, f622b + f628h + str);
        }
    }

    /* renamed from: c */
    public static void m666c(String str, String str2) {
        if (f624d && f629i) {
            Log.i(str, f622b + f628h + str2);
        }
    }

    /* renamed from: c */
    public static void m667c(boolean z) {
        f624d = z;
    }

    /* renamed from: c */
    public static boolean m668c() {
        return f625e;
    }

    /* renamed from: d */
    public static void m669d(String str) {
        if (f626f && f629i) {
            Log.w(f621a, f622b + f628h + str);
        }
    }

    /* renamed from: d */
    public static void m670d(String str, String str2) {
        if (f626f && f629i) {
            Log.w(str, f622b + f628h + str2);
        }
    }

    /* renamed from: d */
    public static void m671d(boolean z) {
        f626f = z;
    }

    /* renamed from: d */
    public static boolean m672d() {
        return f624d;
    }

    /* renamed from: e */
    public static void m673e(String str) {
        if (f627g && f629i) {
            Log.e(f621a, f622b + f628h + str);
        }
    }

    /* renamed from: e */
    public static void m674e(String str, String str2) {
        if (f627g && f629i) {
            Log.e(str, f622b + f628h + str2);
        }
    }

    /* renamed from: e */
    public static void m675e(boolean z) {
        f627g = z;
    }

    /* renamed from: e */
    public static boolean m676e() {
        return f626f;
    }

    /* renamed from: f */
    public static void m677f(String str) {
        f622b = str;
    }

    /* renamed from: f */
    public static void m678f(boolean z) {
        f629i = z;
        boolean z2 = z;
        f623c = z2;
        f625e = z2;
        f624d = z2;
        f626f = z2;
        f627g = z2;
    }

    /* renamed from: f */
    public static boolean m679f() {
        return f627g;
    }

    /* renamed from: g */
    public static void m680g(String str) {
        f628h = str;
    }

    /* renamed from: g */
    public static boolean m681g() {
        return f629i;
    }

    /* renamed from: h */
    public static String m682h() {
        return f628h;
    }
}
