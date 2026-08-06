package com.vivo.push;

import com.vivo.push.restructure.request.a.a.c;
import org.json.JSONException;

/* compiled from: ClientSdkQueryResultDS.java */
/* loaded from: classes7.dex */
public final class g implements com.vivo.push.restructure.request.a.a.c {
    public static c.a<g> a = new h();
    private int b;
    private String c;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(com.vivo.push.restructure.request.a.a.a aVar) throws JSONException {
        this.b = aVar.a();
        this.c = aVar.c();
    }

    public final String b() {
        return this.c;
    }

    @Override // com.vivo.push.restructure.request.a.a.c
    public final String a() {
        com.vivo.push.restructure.request.a.a.a aVar = new com.vivo.push.restructure.request.a.a.a();
        aVar.a(this.b);
        aVar.a(this.c);
        return aVar.e();
    }
}
