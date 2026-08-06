package com.vivo.push.util;

import android.content.Context;

/* compiled from: LogUtil.java */
/* renamed from: com.vivo.push.util.t */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1393t {

    /* renamed from: a */
    public static final InterfaceC1392s f721a = new C1391r();

    /* renamed from: b */
    private static boolean f722b = C1373ah.m962b("persist.sys.log.ctrl", "no").equals("yes");

    /* renamed from: c */
    private static boolean f723c;

    /* renamed from: a */
    public static boolean m1040a() {
        return f722b;
    }

    /* renamed from: b */
    public static boolean m1045b() {
        return f722b && f723c;
    }

    /* renamed from: a */
    public static int m1034a(String str, String str2) {
        return f721a.mo1023a(str, str2);
    }

    /* renamed from: a */
    public static int m1036a(String str, Throwable th) {
        return f721a.mo1025a(str, th);
    }

    /* renamed from: a */
    public static int m1035a(String str, String str2, Throwable th) {
        return f721a.mo1024a(str, str2, th);
    }

    /* renamed from: b */
    public static int m1041b(String str, String str2) {
        return f721a.mo1027b(str, str2);
    }

    /* renamed from: c */
    public static int m1046c(String str, String str2) {
        return f721a.mo1030c(str, str2);
    }

    /* renamed from: d */
    public static int m1048d(String str, String str2) {
        return f721a.mo1032d(str, str2);
    }

    /* renamed from: b */
    public static int m1042b(String str, String str2, Throwable th) {
        return f721a.mo1028b(str, str2, th);
    }

    /* renamed from: e */
    public static int m1049e(String str, String str2) {
        return f721a.mo1033e(str, str2);
    }

    /* renamed from: a */
    public static void m1038a(Context context, String str) {
        f721a.mo1026a(context, str);
    }

    /* renamed from: b */
    public static void m1043b(Context context, String str) {
        f721a.mo1029b(context, str);
    }

    /* renamed from: c */
    public static void m1047c(Context context, String str) {
        f721a.mo1031c(context, str);
    }

    /* renamed from: a */
    public static void m1039a(String str) {
        if (f722b) {
            f721a.mo1030c("VIVO.PUSH.MSG_NODE", str);
        }
    }

    /* renamed from: b */
    public static void m1044b(String str) {
        if (f722b) {
            f721a.mo1030c("VIVO.PUSH.PROFILE.SYNC", str);
        }
    }

    /* renamed from: a */
    public static void m1037a(int i, String str) {
        m1034a("RunTimeException", "code: " + i + ", exceptionMsg: " + str);
    }
}
