package com.huawei.hms.hatool;

/* renamed from: com.huawei.hms.hatool.l1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1159l1 {

    /* renamed from: a */
    private C1177s0 f1510a;

    /* renamed from: b */
    private C1177s0 f1511b;

    /* renamed from: c */
    private C1177s0 f1512c;

    /* renamed from: d */
    private C1177s0 f1513d;

    public C1159l1(String str) {
    }

    /* renamed from: a */
    public C1177s0 m1614a() {
        return this.f1512c;
    }

    /* renamed from: a */
    public C1177s0 m1615a(String str) {
        if (str.equals("oper")) {
            return m1619c();
        }
        if (str.equals("maint")) {
            return m1617b();
        }
        if (str.equals("diffprivacy")) {
            return m1614a();
        }
        if (str.equals("preins")) {
            return m1620d();
        }
        C1182v.m1786f("hmsSdk", "HiAnalyticsInstData.getConfig(type): wrong type: " + str);
        return null;
    }

    /* renamed from: a */
    public void m1616a(C1177s0 c1177s0) {
        this.f1510a = c1177s0;
    }

    /* renamed from: b */
    public C1177s0 m1617b() {
        return this.f1510a;
    }

    /* renamed from: b */
    public void m1618b(C1177s0 c1177s0) {
        this.f1511b = c1177s0;
    }

    /* renamed from: c */
    public C1177s0 m1619c() {
        return this.f1511b;
    }

    /* renamed from: d */
    public C1177s0 m1620d() {
        return this.f1513d;
    }
}
