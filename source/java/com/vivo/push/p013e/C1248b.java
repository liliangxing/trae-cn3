package com.vivo.push.p013e;

import com.vivo.push.restructure.request.p023a.p024a.C1341a;
import com.vivo.push.restructure.request.p023a.p024a.InterfaceC1343c;
import org.json.JSONException;

/* compiled from: ProfileInfoDS.java */
/* renamed from: com.vivo.push.e.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1248b implements InterfaceC1343c {

    /* renamed from: a */
    public static InterfaceC1343c.a<C1248b> f423a = new C1249c();

    /* renamed from: b */
    private String f424b;

    public C1248b(String str) {
        this.f424b = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public C1248b(C1341a c1341a) throws JSONException {
        this.f424b = c1341a.m894c();
    }

    @Override // com.vivo.push.restructure.request.p023a.p024a.InterfaceC1343c
    /* renamed from: a */
    public final String mo677a() {
        C1341a c1341a = new C1341a();
        c1341a.m890a(this.f424b);
        return c1341a.m896e();
    }

    /* renamed from: b */
    public final String m680b() {
        return this.f424b;
    }
}
