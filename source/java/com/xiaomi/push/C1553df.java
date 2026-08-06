package com.xiaomi.push;

/* renamed from: com.xiaomi.push.df */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1553df {

    /* renamed from: a */
    private static volatile C1553df f1324a;

    /* renamed from: a */
    private InterfaceC1552de f1325a;

    /* renamed from: a */
    public static C1553df m2027a() {
        if (f1324a == null) {
            synchronized (C1553df.class) {
                if (f1324a == null) {
                    f1324a = new C1553df();
                }
            }
        }
        return f1324a;
    }

    /* renamed from: a */
    public InterfaceC1552de m2028a() {
        return this.f1325a;
    }

    /* renamed from: a */
    public void m2029a(InterfaceC1552de interfaceC1552de) {
        this.f1325a = interfaceC1552de;
    }
}
