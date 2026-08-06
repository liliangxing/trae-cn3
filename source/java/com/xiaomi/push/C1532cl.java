package com.xiaomi.push;

import android.content.Context;

/* renamed from: com.xiaomi.push.cl */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1532cl implements InterfaceC1606fe, InterfaceC1611fj {

    /* renamed from: a */
    private Context f1185a;

    @Override // com.xiaomi.push.InterfaceC1611fj
    /* renamed from: a */
    public boolean mo1864a(AbstractC1615fn abstractC1615fn) {
        return true;
    }

    public C1532cl(Context context) {
        this.f1185a = context;
    }

    @Override // com.xiaomi.push.InterfaceC1606fe
    /* renamed from: a */
    public void mo1863a(AbstractC1615fn abstractC1615fn) {
        C1539cs.m1930a(this.f1185a);
    }

    @Override // com.xiaomi.push.InterfaceC1606fe
    /* renamed from: a */
    public void mo1862a(C1591eq c1591eq) {
        if (c1591eq != null && c1591eq.m2429a() == 0 && "PING".equals(c1591eq.m2431a())) {
            C1539cs.m1937c(this.f1185a);
        } else {
            C1539cs.m1930a(this.f1185a);
        }
    }
}
