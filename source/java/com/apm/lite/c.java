package com.apm.lite;

/* loaded from: classes2.dex */
public class c {
    private static volatile c a;

    private c() {
    }

    public static c a() {
        if (a == null) {
            synchronized (c.class) {
                if (a == null) {
                    a = new c();
                }
            }
        }
        return a;
    }

    public static void a(String str, Throwable th) {
    }

    public static void a(Throwable th, String str) {
    }
}
