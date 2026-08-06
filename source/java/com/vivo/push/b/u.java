package com.vivo.push.b;

import java.util.ArrayList;
import java.util.List;

/* compiled from: OnTagsReceiveCommand.java */
/* loaded from: classes7.dex */
public final class u extends t {
    private ArrayList<String> a;
    private ArrayList<String> b;

    @Override // com.vivo.push.b.t, com.vivo.push.v
    public final String toString() {
        return "OnSetTagsCommand";
    }

    public u(int i) {
        super(i);
        this.a = null;
        this.b = null;
    }

    public final ArrayList<String> e() {
        return this.a;
    }

    public final List<String> f() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.t, com.vivo.push.v
    public final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("content", this.a);
        dVar.a("error_msg", this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.t, com.vivo.push.v
    public final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.a = dVar.c("content");
        this.b = dVar.c("error_msg");
    }
}
