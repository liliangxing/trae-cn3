package com.xiaomi.push;

import android.content.Context;

/* renamed from: com.xiaomi.push.ck */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1531ck implements InterfaceC1606fe, InterfaceC1611fj {

    /* renamed from: a */
    private Context f1184a;

    @Override // com.xiaomi.push.InterfaceC1611fj
    /* renamed from: a */
    public boolean mo1864a(AbstractC1615fn abstractC1615fn) {
        return true;
    }

    public C1531ck(Context context) {
        this.f1184a = context;
    }

    @Override // com.xiaomi.push.InterfaceC1606fe
    /* renamed from: a */
    public void mo1863a(AbstractC1615fn abstractC1615fn) {
        C1539cs.m1934b(this.f1184a);
    }

    @Override // com.xiaomi.push.InterfaceC1606fe
    /* renamed from: a */
    public void mo1862a(C1591eq c1591eq) {
        if (c1591eq != null && c1591eq.m2429a() == 0 && "PING".equals(c1591eq.m2431a())) {
            C1539cs.m1938d(this.f1184a);
        } else {
            C1539cs.m1934b(this.f1184a);
        }
    }
}
