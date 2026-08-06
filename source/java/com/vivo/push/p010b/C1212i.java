package com.vivo.push.p010b;

import com.vivo.push.C1232d;

/* compiled from: OnAppReceiveCommand.java */
/* renamed from: com.vivo.push.b.i */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1212i extends C1223t {

    /* renamed from: a */
    private String f349a;

    /* renamed from: b */
    private String f350b;

    /* renamed from: c */
    private String f351c;

    /* renamed from: d */
    private String f352d;

    @Override // com.vivo.push.p010b.C1223t, com.vivo.push.AbstractC1400v
    public final String toString() {
        return "OnBindCommand";
    }

    public C1212i(int i) {
        super(i);
    }

    /* renamed from: e */
    public final String m594e() {
        return this.f349a;
    }

    /* renamed from: f */
    public final String m595f() {
        return this.f351c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.p010b.C1223t, com.vivo.push.AbstractC1400v
    /* renamed from: c */
    public final void mo582c(C1232d c1232d) {
        super.mo582c(c1232d);
        c1232d.m654a("app_id", this.f349a);
        c1232d.m654a("client_id", this.f350b);
        c1232d.m654a("client_token", this.f351c);
        c1232d.m654a("client_token_validity_period", this.f352d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.p010b.C1223t, com.vivo.push.AbstractC1400v
    /* renamed from: d */
    public final void mo583d(C1232d c1232d) {
        super.mo583d(c1232d);
        this.f349a = c1232d.m650a("app_id");
        this.f350b = c1232d.m650a("client_id");
        this.f351c = c1232d.m650a("client_token");
        this.f352d = c1232d.m650a("client_token_validity_period");
    }
}
