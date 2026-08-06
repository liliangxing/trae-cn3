package com.vivo.push.b;

/* compiled from: OnVerifyReceiveCommand.java */
/* loaded from: classes7.dex */
public abstract class w extends t {
    private String a;
    private long b;

    public w(int i) {
        super(i);
    }

    public final long h() {
        return this.b;
    }

    public final String k() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.t, com.vivo.push.v
    public void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("OnVerifyCallBackCommand.EXTRA_SECURITY_CONTENT", this.a);
        dVar.a("notify_id", this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.t, com.vivo.push.v
    public void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.a = dVar.a("OnVerifyCallBackCommand.EXTRA_SECURITY_CONTENT");
        this.b = dVar.b("notify_id", -1L);
    }
}
