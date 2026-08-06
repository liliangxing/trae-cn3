package com.xiaomi.push;

import com.xiaomi.push.C1677hv;

/* renamed from: com.xiaomi.push.hs */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1674hs {

    /* renamed from: a */
    private final AbstractC1681hz f2749a;

    /* renamed from: a */
    private final C1691ii f2750a;

    public C1674hs() {
        this(new C1677hv.a());
    }

    public C1674hs(InterfaceC1684ib interfaceC1684ib) {
        C1691ii c1691ii = new C1691ii();
        this.f2750a = c1691ii;
        this.f2749a = interfaceC1684ib.mo3373a(c1691ii);
    }

    /* renamed from: a */
    public void m3333a(InterfaceC1671hp interfaceC1671hp, byte[] bArr) {
        try {
            this.f2750a.m3412a(bArr);
            interfaceC1671hp.mo2352a(this.f2749a);
        } finally {
            this.f2749a.m3374k();
        }
    }
}
