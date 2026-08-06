package com.vivo.push.b;

import net.openid.appauth.TokenRequest;

/* compiled from: OnAppReceiveCommand.java */
/* loaded from: classes7.dex */
public final class i extends t {
    private String a;
    private String b;
    private String c;
    private String d;

    @Override // com.vivo.push.b.t, com.vivo.push.v
    public final String toString() {
        return "OnBindCommand";
    }

    public i(int i) {
        super(i);
    }

    public final String e() {
        return this.a;
    }

    public final String f() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.t, com.vivo.push.v
    public final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("app_id", this.a);
        dVar.a(TokenRequest.PARAM_CLIENT_ID, this.b);
        dVar.a("client_token", this.c);
        dVar.a("client_token_validity_period", this.d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.t, com.vivo.push.v
    public final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.a = dVar.a("app_id");
        this.b = dVar.a(TokenRequest.PARAM_CLIENT_ID);
        this.c = dVar.a("client_token");
        this.d = dVar.a("client_token_validity_period");
    }
}
