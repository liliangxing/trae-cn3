package com.huawei.secure.android.common.ssl.util;

import android.util.Log;

/* renamed from: com.huawei.secure.android.common.ssl.util.e */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1302e {

    /* renamed from: a */
    private static final String f2208a = "SecurityComp10201304: ";

    /* renamed from: a */
    public static void m2405a(String str, String str2) {
    }

    /* renamed from: a */
    public static void m2406a(String str, String str2, Throwable th) {
        Log.e(m2404a(str), str2, th);
    }

    /* renamed from: b */
    public static void m2407b(String str, String str2) {
        Log.e(m2404a(str), str2);
    }

    /* renamed from: c */
    public static void m2408c(String str, String str2) {
        Log.i(m2404a(str), str2);
    }

    /* renamed from: d */
    public static void m2409d(String str, String str2) {
        Log.v(m2404a(str), str2);
    }

    /* renamed from: e */
    public static void m2410e(String str, String str2) {
        Log.w(m2404a(str), str2);
    }

    /* renamed from: a */
    private static String m2404a(String str) {
        return f2208a + str;
    }
}
