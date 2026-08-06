package com.apm.lite.runtime;

import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: classes2.dex */
public class m {
    private static volatile r a;
    private static volatile Handler b;

    public static HandlerThread a() {
        if (a == null) {
            synchronized (m.class) {
                if (a == null) {
                    a = new r("default_npth_thread");
                    a.b();
                }
            }
        }
        return a.c();
    }

    public static r b() {
        if (a == null) {
            a();
        }
        return a;
    }
}
