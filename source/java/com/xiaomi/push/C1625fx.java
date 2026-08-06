package com.xiaomi.push;

import com.xiaomi.push.C1471ae;

/* renamed from: com.xiaomi.push.fx */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1625fx {

    /* renamed from: a */
    private static C1471ae f1860a = new C1471ae(true, 20);

    /* renamed from: a */
    public static void m2653a(final Runnable runnable) {
        f1860a.m1465a(new C1471ae.b() { // from class: com.xiaomi.push.fx.1
            @Override // com.xiaomi.push.C1471ae.b
            /* renamed from: b */
            public void mo1470b() {
                runnable.run();
            }
        });
    }

    /* renamed from: a */
    public static void m2651a(C1471ae.b bVar) {
        f1860a.m1465a(bVar);
    }

    /* renamed from: a */
    public static void m2652a(C1471ae.b bVar, long j) {
        f1860a.m1466a(bVar, j);
    }
}
