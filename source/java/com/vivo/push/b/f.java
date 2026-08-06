package com.vivo.push.b;

/* compiled from: DefaultCommand.java */
/* loaded from: classes7.dex */
public final class f extends com.vivo.push.v {
    private int a;

    @Override // com.vivo.push.v
    public final String toString() {
        return "DefaultCommand";
    }

    public f() {
        super(0);
    }

    public final void a(int i) {
        this.a = i;
    }

    @Override // com.vivo.push.v
    protected final void c(com.vivo.push.d dVar) {
        if (dVar != null) {
            dVar.a("APP_CLIENT_SWITCH_FLAG", this.a);
        }
    }

    @Override // com.vivo.push.v
    protected final void d(com.vivo.push.d dVar) {
        if (dVar != null) {
            this.a = dVar.b("APP_CLIENT_SWITCH_FLAG", 0);
        }
    }
}
