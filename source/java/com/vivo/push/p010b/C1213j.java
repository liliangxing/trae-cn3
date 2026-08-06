package com.vivo.push.p010b;

import com.vivo.push.C1232d;

/* compiled from: OnChangePushStatusReceiveCommand.java */
/* renamed from: com.vivo.push.b.j */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1213j extends C1223t {

    /* renamed from: a */
    private int f353a;

    /* renamed from: b */
    private int f354b;

    @Override // com.vivo.push.p010b.C1223t, com.vivo.push.AbstractC1400v
    public final String toString() {
        return "OnChangePushStatusCommand";
    }

    public C1213j() {
        super(12);
        this.f353a = -1;
        this.f354b = -1;
    }

    /* renamed from: e */
    public final int m596e() {
        return this.f353a;
    }

    /* renamed from: f */
    public final int m597f() {
        return this.f354b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.p010b.C1223t, com.vivo.push.AbstractC1400v
    /* renamed from: c */
    public final void mo582c(C1232d c1232d) {
        super.mo582c(c1232d);
        c1232d.m651a("OnChangePushStatus.EXTRA_REQ_SERVICE_STATUS", this.f353a);
        c1232d.m651a("OnChangePushStatus.EXTRA_REQ_RECEIVER_STATUS", this.f354b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.p010b.C1223t, com.vivo.push.AbstractC1400v
    /* renamed from: d */
    public final void mo583d(C1232d c1232d) {
        super.mo583d(c1232d);
        this.f353a = c1232d.m658b("OnChangePushStatus.EXTRA_REQ_SERVICE_STATUS", this.f353a);
        this.f354b = c1232d.m658b("OnChangePushStatus.EXTRA_REQ_RECEIVER_STATUS", this.f354b);
    }
}
