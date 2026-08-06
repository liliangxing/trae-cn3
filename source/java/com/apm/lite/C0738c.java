package com.apm.lite;

/* renamed from: com.apm.lite.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0738c {

    /* renamed from: a */
    private static volatile C0738c f392a;

    private C0738c() {
    }

    /* renamed from: a */
    public static C0738c m435a() {
        if (f392a == null) {
            synchronized (C0738c.class) {
                if (f392a == null) {
                    f392a = new C0738c();
                }
            }
        }
        return f392a;
    }

    /* renamed from: a */
    public static void m436a(String str, Throwable th) {
    }

    /* renamed from: a */
    public static void m437a(Throwable th, String str) {
    }
}
