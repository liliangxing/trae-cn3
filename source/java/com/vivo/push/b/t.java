package com.vivo.push.b;

/* compiled from: OnReceiveCommand.java */
/* loaded from: classes7.dex */
public class t extends com.vivo.push.v {
    private String a;
    private int b;

    @Override // com.vivo.push.v
    public String toString() {
        return "OnReceiveCommand";
    }

    public t(int i) {
        super(i);
        this.a = null;
        this.b = 0;
    }

    public final String i() {
        return this.a;
    }

    public final int j() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.v
    public void c(com.vivo.push.d dVar) {
        dVar.a("req_id", this.a);
        dVar.a("status_msg_code", this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.v
    public void d(com.vivo.push.d dVar) {
        this.a = dVar.a("req_id");
        this.b = dVar.b("status_msg_code", this.b);
    }
}
