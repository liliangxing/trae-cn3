package com.vivo.push.p012d;

import com.vivo.push.restructure.request.p023a.p024a.C1341a;
import com.vivo.push.restructure.request.p023a.p024a.InterfaceC1342b;
import org.json.JSONException;

/* compiled from: NotifyGuideInput.java */
/* renamed from: com.vivo.push.d.g */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1239g implements InterfaceC1342b {

    /* renamed from: a */
    public static final InterfaceC1342b.a<C1239g> f406a = new C1240h();

    /* renamed from: b */
    private long f407b;

    /* renamed from: c */
    private int f408c;

    /* renamed from: d */
    private int f409d;

    /* renamed from: e */
    private boolean f410e;

    public C1239g(int i, boolean z) {
        this.f408c = i;
        this.f409d = 1;
        this.f410e = z;
    }

    public C1239g(long j, int i, boolean z) {
        this.f407b = j;
        this.f408c = i;
        this.f409d = 2;
        this.f410e = z;
    }

    public C1239g(C1341a c1341a) {
        try {
            this.f407b = c1341a.m893b();
            this.f408c = c1341a.m886a();
            this.f409d = c1341a.m886a();
            this.f410e = c1341a.m895d();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.vivo.push.restructure.request.p023a.p024a.InterfaceC1342b
    /* renamed from: a */
    public final void mo673a(C1341a c1341a) {
        c1341a.m888a(this.f407b);
        c1341a.m887a(this.f408c);
        c1341a.m887a(this.f409d);
        c1341a.m892a(this.f410e);
    }
}
