package com.vivo.push.p012d;

import com.vivo.push.restructure.request.p023a.p024a.C1341a;
import com.vivo.push.restructure.request.p023a.p024a.InterfaceC1342b;
import org.json.JSONException;

/* compiled from: NotifyGuideOutput.java */
/* renamed from: com.vivo.push.d.i */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1241i implements InterfaceC1342b {

    /* renamed from: a */
    public static final InterfaceC1342b.a<C1241i> f411a = new C1242j();

    /* renamed from: b */
    private int f412b;

    @Override // com.vivo.push.restructure.request.p023a.p024a.InterfaceC1342b
    /* renamed from: a */
    public final void mo673a(C1341a c1341a) {
        c1341a.m887a(this.f412b);
    }

    public C1241i(C1341a c1341a) throws JSONException {
        this.f412b = c1341a.m886a();
    }

    /* renamed from: a */
    public final int m675a() {
        return this.f412b;
    }
}
