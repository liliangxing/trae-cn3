package com.apm.lite.p011a;

import com.apm.lite.CrashType;

/* renamed from: com.apm.lite.a.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0730a {

    /* renamed from: a */
    private static volatile C0730a f343a;

    private C0730a() {
    }

    /* renamed from: a */
    public static C0730a m378a() {
        if (f343a == null) {
            synchronized (C0730a.class) {
                if (f343a == null) {
                    f343a = new C0730a();
                }
            }
        }
        return f343a;
    }

    /* renamed from: a */
    public void m379a(CrashType crashType, long j, String str) {
    }

    /* renamed from: a */
    public void m380a(String str) {
    }

    /* renamed from: b */
    public void m381b() {
    }
}
