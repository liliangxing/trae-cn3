package com.unicom.online.account.kernel;

import android.util.Log;

/* loaded from: classes7.dex */
public final class aa {
    private static boolean a;
    private static StringBuilder b = new StringBuilder();
    private static StringBuilder c = new StringBuilder();
    private static int d;

    public static String a(int i) {
        if (a) {
            return (1 == i ? c : b).toString();
        }
        return "setLogEnable(false)";
    }

    public static void a() {
        d = 0;
        c.setLength(0);
        c.append("\n\n********************\n\n\n\n   debug info      \n\n\n\n********************\n\n");
        b.setLength(0);
        b.append("\n\n********************\n\n\n\n   debug info      \n\n\n\n********************\n\n");
    }

    public static void a(String str) {
        b.append(str);
    }

    public static void a(boolean z) {
        a = z;
    }

    public static void b(String str) {
        if (a) {
            Log.d("UniAccount", u.a() + " " + str);
            e(str);
        }
    }

    public static void c(String str) {
        if (a) {
            Log.e("UniAccount", u.a() + " " + str);
            e(str);
        }
    }

    public static void d(String str) {
        Log.e("UniAccount", u.a() + " " + str);
        e(str);
    }

    private static void e(String str) {
        StringBuilder sb = new StringBuilder("【");
        int i = d;
        d = i + 1;
        a(sb.append(i).append("】").append(System.currentTimeMillis()).append("-->\n").append(str).append("\n\n").toString());
    }
}
