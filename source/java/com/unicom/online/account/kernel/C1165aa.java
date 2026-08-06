package com.unicom.online.account.kernel;

import android.util.Log;

/* renamed from: com.unicom.online.account.kernel.aa */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1165aa {

    /* renamed from: a */
    private static boolean f222a;

    /* renamed from: b */
    private static StringBuilder f223b = new StringBuilder();

    /* renamed from: c */
    private static StringBuilder f224c = new StringBuilder();

    /* renamed from: d */
    private static int f225d;

    /* renamed from: a */
    public static String m444a(int i) {
        if (f222a) {
            return (1 == i ? f224c : f223b).toString();
        }
        return "setLogEnable(false)";
    }

    /* renamed from: a */
    public static void m445a() {
        f225d = 0;
        f224c.setLength(0);
        f224c.append("\n\n********************\n\n\n\n   debug info      \n\n\n\n********************\n\n");
        f223b.setLength(0);
        f223b.append("\n\n********************\n\n\n\n   debug info      \n\n\n\n********************\n\n");
    }

    /* renamed from: a */
    public static void m446a(String str) {
        f223b.append(str);
    }

    /* renamed from: a */
    public static void m447a(boolean z) {
        f222a = z;
    }

    /* renamed from: b */
    public static void m448b(String str) {
        if (f222a) {
            Log.d("UniAccount", C1189u.m556a() + " " + str);
            m451e(str);
        }
    }

    /* renamed from: c */
    public static void m449c(String str) {
        if (f222a) {
            Log.e("UniAccount", C1189u.m556a() + " " + str);
            m451e(str);
        }
    }

    /* renamed from: d */
    public static void m450d(String str) {
        Log.e("UniAccount", C1189u.m556a() + " " + str);
        m451e(str);
    }

    /* renamed from: e */
    private static void m451e(String str) {
        StringBuilder sb = new StringBuilder("【");
        int i = f225d;
        f225d = i + 1;
        m446a(sb.append(i).append("】").append(System.currentTimeMillis()).append("-->\n").append(str).append("\n\n").toString());
    }
}
