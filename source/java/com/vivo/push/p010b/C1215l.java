package com.vivo.push.p010b;

import com.vivo.push.C1232d;

/* compiled from: OnDispatcherReceiveCommand.java */
/* renamed from: com.vivo.push.b.l */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1215l extends C1223t {

    /* renamed from: a */
    private int f355a;

    /* renamed from: b */
    private int f356b;

    public C1215l() {
        super(2016);
        this.f355a = -1;
        this.f356b = -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.p010b.C1223t, com.vivo.push.AbstractC1400v
    /* renamed from: c */
    public final void mo582c(C1232d c1232d) {
        super.mo582c(c1232d);
        c1232d.m651a("key_dispatch_environment", this.f355a);
        c1232d.m651a("key_dispatch_area", this.f356b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.p010b.C1223t, com.vivo.push.AbstractC1400v
    /* renamed from: d */
    public final void mo583d(C1232d c1232d) {
        super.mo583d(c1232d);
        this.f355a = c1232d.m658b("key_dispatch_environment", 1);
        this.f356b = c1232d.m658b("key_dispatch_area", 1);
    }

    /* renamed from: e */
    public final int m598e() {
        return this.f355a;
    }

    /* renamed from: f */
    public final int m599f() {
        return this.f356b;
    }
}
