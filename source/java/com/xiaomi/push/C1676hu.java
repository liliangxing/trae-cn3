package com.xiaomi.push;

import com.xiaomi.push.C1677hv;
import java.io.ByteArrayOutputStream;

/* renamed from: com.xiaomi.push.hu */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1676hu {

    /* renamed from: a */
    private AbstractC1681hz f2751a;

    /* renamed from: a */
    private final C1689ig f2752a;

    /* renamed from: a */
    private final ByteArrayOutputStream f2753a;

    public C1676hu() {
        this(new C1677hv.a());
    }

    public C1676hu(InterfaceC1684ib interfaceC1684ib) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f2753a = byteArrayOutputStream;
        C1689ig c1689ig = new C1689ig(byteArrayOutputStream);
        this.f2752a = c1689ig;
        this.f2751a = interfaceC1684ib.mo3373a(c1689ig);
    }

    /* renamed from: a */
    public byte[] m3334a(InterfaceC1671hp interfaceC1671hp) {
        this.f2753a.reset();
        interfaceC1671hp.mo2358b(this.f2751a);
        return this.f2753a.toByteArray();
    }
}
