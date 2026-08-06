package com.huawei.hms.hatool;

import java.util.ArrayList;
import java.util.UUID;

/* renamed from: com.huawei.hms.hatool.i1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1150i1 {

    /* renamed from: a */
    private String f1473a;

    /* renamed from: b */
    private String f1474b;

    /* renamed from: c */
    private String f1475c;

    /* renamed from: d */
    private String f1476d;

    /* renamed from: e */
    private long f1477e;

    public C1150i1(String str, String str2, String str3, String str4, long j) {
        this.f1473a = str;
        this.f1474b = str2;
        this.f1475c = str3;
        this.f1476d = str4;
        this.f1477e = j;
    }

    /* renamed from: a */
    public void m1563a() {
        C1182v.m1781c("StreamEventHandler", "Begin to handle stream events...");
        C1129b1 c1129b1 = new C1129b1();
        c1129b1.m1443b(this.f1475c);
        c1129b1.m1447d(this.f1474b);
        c1129b1.m1440a(this.f1476d);
        c1129b1.m1445c(String.valueOf(this.f1477e));
        if ("oper".equals(this.f1474b) && AbstractC1190z.m1825i(this.f1473a, "oper")) {
            C1170p0 m1813a = C1188y.m1811a().m1813a(this.f1473a, this.f1477e);
            String m1676a = m1813a.m1676a();
            Boolean valueOf = Boolean.valueOf(m1813a.m1678b());
            c1129b1.m1449f(m1676a);
            c1129b1.m1448e(String.valueOf(valueOf));
        }
        String replace = UUID.randomUUID().toString().replace("-", "");
        ArrayList arrayList = new ArrayList();
        arrayList.add(c1129b1);
        new C1158l0(this.f1473a, this.f1474b, AbstractC1173q0.m1703g(), arrayList, replace).m1613a();
    }
}
