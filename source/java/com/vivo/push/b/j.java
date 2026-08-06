package com.vivo.push.b;

/* compiled from: OnChangePushStatusReceiveCommand.java */
/* loaded from: classes7.dex */
public final class j extends t {
    private int a;
    private int b;

    @Override // com.vivo.push.b.t, com.vivo.push.v
    public final String toString() {
        return "OnChangePushStatusCommand";
    }

    public j() {
        super(12);
        this.a = -1;
        this.b = -1;
    }

    public final int e() {
        return this.a;
    }

    public final int f() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.t, com.vivo.push.v
    public final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("OnChangePushStatus.EXTRA_REQ_SERVICE_STATUS", this.a);
        dVar.a("OnChangePushStatus.EXTRA_REQ_RECEIVER_STATUS", this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.t, com.vivo.push.v
    public final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.a = dVar.b("OnChangePushStatus.EXTRA_REQ_SERVICE_STATUS", this.a);
        this.b = dVar.b("OnChangePushStatus.EXTRA_REQ_RECEIVER_STATUS", this.b);
    }
}
