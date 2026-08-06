package com.huawei.hms.hatool;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: com.huawei.hms.hatool.s */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class C1176s {

    /* renamed from: b */
    static Map<String, C1159l1> f1548b = new HashMap();

    /* renamed from: c */
    private static C1176s f1549c;

    /* renamed from: a */
    private C1144g1 f1550a = new C1144g1();

    private C1176s() {
    }

    /* renamed from: c */
    public static C1176s m1722c() {
        if (f1549c == null) {
            m1723d();
        }
        return f1549c;
    }

    /* renamed from: d */
    private static synchronized void m1723d() {
        synchronized (C1176s.class) {
            if (f1549c == null) {
                f1549c = new C1176s();
            }
        }
    }

    /* renamed from: a */
    public C1159l1 m1724a(String str) {
        return f1548b.get(str);
    }

    /* renamed from: a */
    public Set<String> m1725a() {
        return f1548b.keySet();
    }

    /* renamed from: a */
    public void m1726a(String str, C1159l1 c1159l1) {
        f1548b.put(str, c1159l1);
    }

    /* renamed from: b */
    public C1144g1 m1727b() {
        return this.f1550a;
    }
}
