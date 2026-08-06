package com.vivo.push.b;

import java.util.ArrayList;

/* compiled from: OnListTagReceiveCommand.java */
/* loaded from: classes7.dex */
public final class m extends t {
    private ArrayList<String> a;

    @Override // com.vivo.push.b.t, com.vivo.push.v
    public final String toString() {
        return "OnListTagCommand";
    }

    public m() {
        super(8);
    }

    public final ArrayList<String> e() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.t, com.vivo.push.v
    public final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("tags_list", this.a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.t, com.vivo.push.v
    public final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.a = dVar.c("tags_list");
    }
}
