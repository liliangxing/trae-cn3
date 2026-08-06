package com.vivo.push.restructure.request.p023a;

import com.vivo.push.restructure.request.p023a.p024a.C1341a;
import com.vivo.push.restructure.request.p023a.p024a.InterfaceC1342b;
import com.vivo.push.util.C1393t;
import org.json.JSONException;

/* compiled from: CFToClientDS.java */
/* renamed from: com.vivo.push.restructure.request.a.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1340a implements InterfaceC1342b {

    /* renamed from: a */
    public static final InterfaceC1342b.a<C1340a> f599a = new C1344b();

    /* renamed from: b */
    private String f600b;

    /* renamed from: c */
    private int f601c;

    /* renamed from: d */
    private int f602d;

    /* renamed from: e */
    private long f603e;

    /* renamed from: f */
    private int f604f;

    /* renamed from: g */
    private int f605g;

    /* renamed from: a */
    public final int m883a() {
        return this.f601c;
    }

    /* renamed from: b */
    public final int m884b() {
        return this.f604f;
    }

    /* renamed from: c */
    public final int m885c() {
        return this.f605g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public C1340a(C1341a c1341a) {
        try {
            this.f600b = c1341a.m894c();
            this.f601c = c1341a.m886a();
            this.f603e = c1341a.m893b();
            this.f604f = c1341a.m886a();
            this.f602d = c1341a.m886a();
            this.f605g = c1341a.m886a();
        } catch (JSONException e) {
            C1393t.m1036a("CFToClientDS", e);
        }
    }

    @Override // com.vivo.push.restructure.request.p023a.p024a.InterfaceC1342b
    /* renamed from: a */
    public final void mo673a(C1341a c1341a) {
        c1341a.m890a(this.f600b);
        c1341a.m887a(this.f601c);
        c1341a.m888a(this.f603e);
        c1341a.m887a(this.f604f);
        c1341a.m887a(this.f602d);
        c1341a.m887a(this.f605g);
    }
}
