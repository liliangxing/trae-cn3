package com.vivo.push.b;

/* compiled from: OnLogReceiveCommand.java */
/* loaded from: classes7.dex */
public final class n extends t {
    private String a;
    private int b;
    private boolean c;

    @Override // com.vivo.push.b.t, com.vivo.push.v
    public final String toString() {
        return "OnLogCommand";
    }

    public n() {
        super(7);
        this.b = 0;
        this.c = false;
    }

    public final String e() {
        return this.a;
    }

    public final void b(String str) {
        this.a = str;
    }

    public final int f() {
        return this.b;
    }

    public final void a(int i) {
        this.b = i;
    }

    public final boolean g() {
        return this.c;
    }

    public final void h() {
        this.c = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.t, com.vivo.push.v
    public final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("content", this.a);
        dVar.a("log_level", this.b);
        dVar.a("is_server_log", this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.t, com.vivo.push.v
    public final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.a = dVar.a("content");
        this.b = dVar.b("log_level", 0);
        this.c = dVar.e("is_server_log");
    }
}
