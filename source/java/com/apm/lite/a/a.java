package com.apm.lite.a;

import com.apm.lite.CrashType;

/* loaded from: classes2.dex */
public class a {
    private static volatile a a;

    private a() {
    }

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
            }
        }
        return a;
    }

    public void a(CrashType crashType, long j, String str) {
    }

    public void a(String str) {
    }

    public void b() {
    }
}
