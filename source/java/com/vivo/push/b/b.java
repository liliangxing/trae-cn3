package com.vivo.push.b;

/* compiled from: AppCommand.java */
/* loaded from: classes7.dex */
public final class b extends c {
    private String a;
    private String b;
    private int c;
    private boolean d;

    public b(boolean z, String str) {
        super(z ? 2006 : 2007, str);
        this.c = 1;
        this.d = false;
    }

    public final void a(int i) {
        this.c = i;
    }

    @Override // com.vivo.push.b.c, com.vivo.push.v
    public final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("sdk_clients", this.a);
        dVar.a("sdk_version", 356L);
        dVar.a("PUSH_REGID", this.b);
        if (b() == 2007) {
            dVar.a("PUSH_UNBIND_SOURCE_CODE", this.c);
        }
    }

    @Override // com.vivo.push.b.c, com.vivo.push.v
    public final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.a = dVar.a("sdk_clients");
        this.b = dVar.a("PUSH_REGID");
        if (b() == 2007) {
            this.c = dVar.b("PUSH_UNBIND_SOURCE_CODE", 1);
        }
    }

    @Override // com.vivo.push.b.c, com.vivo.push.v
    public final String toString() {
        return "AppCommand:" + b();
    }
}
