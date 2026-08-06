package com.huawei.hms.hatool;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.hms.hatool.y */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class C1188y {

    /* renamed from: b */
    private static C1188y f1584b;

    /* renamed from: a */
    private volatile Map<String, C1170p0> f1585a = new HashMap();

    private C1188y() {
    }

    /* renamed from: a */
    private C1170p0 m1810a(String str) {
        if (!this.f1585a.containsKey(str)) {
            this.f1585a.put(str, new C1170p0());
        }
        return this.f1585a.get(str);
    }

    /* renamed from: a */
    public static C1188y m1811a() {
        if (f1584b == null) {
            m1812b();
        }
        return f1584b;
    }

    /* renamed from: b */
    private static synchronized void m1812b() {
        synchronized (C1188y.class) {
            if (f1584b == null) {
                f1584b = new C1188y();
            }
        }
    }

    /* renamed from: a */
    public C1170p0 m1813a(String str, long j) {
        C1170p0 m1810a = m1810a(str);
        m1810a.m1677a(j);
        return m1810a;
    }
}
