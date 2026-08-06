package com.huawei.secure.android.common.encrypt.utils;

import android.util.Log;

/* renamed from: com.huawei.secure.android.common.encrypt.utils.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1290b {

    /* renamed from: a */
    private static final String f2073a = "SecurityComp10300301: ";

    /* renamed from: a */
    public static void m2314a(String str, String str2) {
    }

    /* renamed from: a */
    public static void m2315a(String str, String str2, Throwable th) {
        Log.e(m2313a(str), str2, th);
    }

    /* renamed from: b */
    public static void m2316b(String str, String str2) {
        Log.e(m2313a(str), str2);
    }

    /* renamed from: c */
    public static void m2317c(String str, String str2) {
        Log.i(m2313a(str), str2);
    }

    /* renamed from: d */
    public static void m2318d(String str, String str2) {
        Log.v(m2313a(str), str2);
    }

    /* renamed from: e */
    public static void m2319e(String str, String str2) {
        Log.w(m2313a(str), str2);
    }

    /* renamed from: a */
    private static String m2313a(String str) {
        return f2073a + str;
    }
}
