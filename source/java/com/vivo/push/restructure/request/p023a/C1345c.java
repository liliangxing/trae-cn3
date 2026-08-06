package com.vivo.push.restructure.request.p023a;

import com.vivo.push.restructure.C1313a;
import com.vivo.push.restructure.request.p023a.p024a.C1341a;
import com.vivo.push.restructure.request.p023a.p024a.InterfaceC1342b;
import org.json.JSONException;

/* compiled from: CFToCoreDS.java */
/* renamed from: com.vivo.push.restructure.request.a.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1345c implements InterfaceC1342b {

    /* renamed from: a */
    public static final InterfaceC1342b.a<C1345c> f609a = new C1346d();

    /* renamed from: b */
    private String f610b;

    /* renamed from: c */
    private int f611c;

    /* renamed from: d */
    private long f612d;

    /* renamed from: e */
    private int f613e;

    public C1345c(int i, int i2) {
        this.f610b = C1313a.m810a().m812b().getPackageName();
        this.f611c = i;
        this.f612d = 356L;
        this.f613e = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public C1345c(C1341a c1341a) {
        try {
            this.f610b = c1341a.m894c();
            this.f611c = c1341a.m886a();
            this.f612d = c1341a.m893b();
            this.f613e = c1341a.m886a();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.vivo.push.restructure.request.p023a.p024a.InterfaceC1342b
    /* renamed from: a */
    public final void mo673a(C1341a c1341a) {
        c1341a.m890a(this.f610b);
        c1341a.m887a(this.f611c);
        c1341a.m888a(this.f612d);
        c1341a.m887a(this.f613e);
    }
}
