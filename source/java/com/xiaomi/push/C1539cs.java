package com.xiaomi.push;

import android.content.Context;

/* renamed from: com.xiaomi.push.cs */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1539cs {

    /* renamed from: a */
    private static C1531ck f1230a;

    /* renamed from: a */
    private static C1532cl f1231a;

    /* renamed from: a */
    public static void m1931a(Context context, AbstractC1600ez abstractC1600ez) {
        if (m1936b(context)) {
            if (f1230a == null) {
                f1230a = new C1531ck(context);
            }
            if (f1231a == null) {
                f1231a = new C1532cl(context);
            }
            C1531ck c1531ck = f1230a;
            abstractC1600ez.m2510a(c1531ck, c1531ck);
            C1532cl c1532cl = f1231a;
            abstractC1600ez.m2519b(c1532cl, c1532cl);
            m1932a("startStats");
        }
    }

    /* renamed from: b */
    public static void m1935b(Context context, AbstractC1600ez abstractC1600ez) {
        C1531ck c1531ck = f1230a;
        if (c1531ck != null) {
            abstractC1600ez.m2509a(c1531ck);
            f1230a = null;
        }
        C1532cl c1532cl = f1231a;
        if (c1532cl != null) {
            abstractC1600ez.m2518b(c1532cl);
            f1231a = null;
        }
        m1932a("stopStats");
    }

    /* renamed from: b */
    private static boolean m1936b(Context context) {
        return C1530cj.m1861a(context);
    }

    /* renamed from: a */
    public static void m1930a(Context context) {
        m1932a("onSendMsg");
        if (m1936b(context)) {
            C1542cv.m1974a(context, System.currentTimeMillis(), m1933a(context));
        }
    }

    /* renamed from: b */
    public static void m1934b(Context context) {
        m1932a("onReceiveMsg");
        if (m1936b(context)) {
            C1542cv.m1978b(context, System.currentTimeMillis(), m1933a(context));
        }
    }

    /* renamed from: c */
    public static void m1937c(Context context) {
        m1932a("onPing");
        if (m1936b(context)) {
            C1542cv.m1979c(context, System.currentTimeMillis(), m1933a(context));
        }
    }

    /* renamed from: d */
    public static void m1938d(Context context) {
        m1932a("onPong");
        if (m1936b(context)) {
            C1542cv.m1980d(context, System.currentTimeMillis(), m1933a(context));
        }
    }

    /* renamed from: a */
    public static boolean m1933a(Context context) {
        return C1682i.m3391b(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m1932a(String str) {
        C1530cj.m1860a("Push-PowerStats", str);
    }
}
