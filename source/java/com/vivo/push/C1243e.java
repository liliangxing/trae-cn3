package com.vivo.push;

import com.vivo.push.restructure.request.p023a.p024a.C1341a;
import com.vivo.push.restructure.request.p023a.p024a.InterfaceC1343c;
import org.json.JSONException;

/* compiled from: ClientSdkQueryParemeterDS.java */
/* renamed from: com.vivo.push.e */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1243e implements InterfaceC1343c {

    /* renamed from: a */
    public static InterfaceC1343c.a<C1243e> f413a = new C1257f();

    /* renamed from: b */
    private int f414b;

    /* renamed from: c */
    private String f415c;

    /* renamed from: d */
    private String f416d;

    /* renamed from: e */
    private String f417e;

    /* renamed from: f */
    private String f418f;

    public C1243e(int i, String str, String str2, String str3, String str4) {
        this.f414b = i;
        this.f415c = str;
        this.f416d = str2;
        this.f417e = str3;
        this.f418f = str4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public C1243e(C1341a c1341a) throws JSONException {
        this.f414b = c1341a.m886a();
        this.f415c = c1341a.m894c();
        this.f416d = c1341a.m894c();
        this.f417e = c1341a.m894c();
        this.f418f = c1341a.m894c();
    }

    @Override // com.vivo.push.restructure.request.p023a.p024a.InterfaceC1343c
    /* renamed from: a */
    public final String mo677a() {
        C1341a c1341a = new C1341a();
        c1341a.m887a(this.f414b);
        c1341a.m890a(this.f415c);
        c1341a.m890a(this.f416d);
        c1341a.m890a(this.f417e);
        c1341a.m890a(this.f418f);
        return c1341a.m896e();
    }
}
