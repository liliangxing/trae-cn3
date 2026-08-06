package com.apm.lite.runtime;

import android.os.Handler;
import android.os.HandlerThread;

/* renamed from: com.apm.lite.runtime.m */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0832m {

    /* renamed from: a */
    private static volatile C0837r f725a;

    /* renamed from: b */
    private static volatile Handler f726b;

    /* renamed from: a */
    public static HandlerThread m1189a() {
        if (f725a == null) {
            synchronized (C0832m.class) {
                if (f725a == null) {
                    f725a = new C0837r("default_npth_thread");
                    f725a.m1240b();
                }
            }
        }
        return f725a.m1243c();
    }

    /* renamed from: b */
    public static C0837r m1190b() {
        if (f725a == null) {
            m1189a();
        }
        return f725a;
    }
}
