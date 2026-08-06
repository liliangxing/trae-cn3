package com.vivo.push.b;

/* compiled from: OnNotifyGuideDialogResultCommand.java */
/* loaded from: classes7.dex */
public final class r extends t {
    private static String a = "notify_guide_dialog_result";
    private int b;

    public r() {
        super(2023);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.t, com.vivo.push.v
    public final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a(a, this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.t, com.vivo.push.v
    public final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.b = dVar.b(a, -1);
    }

    public final int e() {
        return this.b;
    }
}
