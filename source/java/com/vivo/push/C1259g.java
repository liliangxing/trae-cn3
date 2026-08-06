package com.vivo.push;

import com.vivo.push.restructure.request.p023a.p024a.C1341a;
import com.vivo.push.restructure.request.p023a.p024a.InterfaceC1343c;
import org.json.JSONException;

/* compiled from: ClientSdkQueryResultDS.java */
/* renamed from: com.vivo.push.g */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1259g implements InterfaceC1343c {

    /* renamed from: a */
    public static InterfaceC1343c.a<C1259g> f441a = new C1263h();

    /* renamed from: b */
    private int f442b;

    /* renamed from: c */
    private String f443c;

    /* JADX INFO: Access modifiers changed from: protected */
    public C1259g(C1341a c1341a) throws JSONException {
        this.f442b = c1341a.m886a();
        this.f443c = c1341a.m894c();
    }

    /* renamed from: b */
    public final String m689b() {
        return this.f443c;
    }

    @Override // com.vivo.push.restructure.request.p023a.p024a.InterfaceC1343c
    /* renamed from: a */
    public final String mo677a() {
        C1341a c1341a = new C1341a();
        c1341a.m887a(this.f442b);
        c1341a.m890a(this.f443c);
        return c1341a.m896e();
    }
}
