package com.vivo.push.b;

import com.bytedance.tracing.internal.TracingConstants;
import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: TagCommand.java */
/* loaded from: classes7.dex */
public final class z extends c {
    private ArrayList<String> a;

    @Override // com.vivo.push.b.c, com.vivo.push.v
    public final String toString() {
        return "TagCommand";
    }

    public z(boolean z, String str, ArrayList<String> arrayList) {
        super(z ? 2004 : 2005, str);
        this.a = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.c, com.vivo.push.v
    public final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a(TracingConstants.KEY_TAGS, (Serializable) this.a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.c, com.vivo.push.v
    public final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.a = dVar.c(TracingConstants.KEY_TAGS);
    }
}
