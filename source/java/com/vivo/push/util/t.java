package com.vivo.push.util;

import android.content.Context;
import com.caverock.androidsvg.SVGParser;

/* compiled from: LogUtil.java */
/* loaded from: classes7.dex */
public final class t {
    public static final s a = new r();
    private static boolean b = ah.b("persist.sys.log.ctrl", SVGParser.XML_STYLESHEET_ATTR_ALTERNATE_NO).equals("yes");
    private static boolean c;

    public static boolean a() {
        return b;
    }

    public static boolean b() {
        return b && c;
    }

    public static int a(String str, String str2) {
        return a.a(str, str2);
    }

    public static int a(String str, Throwable th) {
        return a.a(str, th);
    }

    public static int a(String str, String str2, Throwable th) {
        return a.a(str, str2, th);
    }

    public static int b(String str, String str2) {
        return a.b(str, str2);
    }

    public static int c(String str, String str2) {
        return a.c(str, str2);
    }

    public static int d(String str, String str2) {
        return a.d(str, str2);
    }

    public static int b(String str, String str2, Throwable th) {
        return a.b(str, str2, th);
    }

    public static int e(String str, String str2) {
        return a.e(str, str2);
    }

    public static void a(Context context, String str) {
        a.a(context, str);
    }

    public static void b(Context context, String str) {
        a.b(context, str);
    }

    public static void c(Context context, String str) {
        a.c(context, str);
    }

    public static void a(String str) {
        if (b) {
            a.c("VIVO.PUSH.MSG_NODE", str);
        }
    }

    public static void b(String str) {
        if (b) {
            a.c("VIVO.PUSH.PROFILE.SYNC", str);
        }
    }

    public static void a(int i, String str) {
        a("RunTimeException", "code: " + i + ", exceptionMsg: " + str);
    }
}
