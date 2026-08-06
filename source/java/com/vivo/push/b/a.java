package com.vivo.push.b;

import com.bytedance.tracing.internal.TracingConstants;
import java.util.ArrayList;

/* compiled from: AliasCommand.java */
/* loaded from: classes7.dex */
public final class a extends c {
    private ArrayList<String> a;

    public a(boolean z, String str, ArrayList<String> arrayList) {
        super(z ? 2002 : 2003, str);
        this.a = arrayList;
    }

    @Override // com.vivo.push.b.c, com.vivo.push.v
    public final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a(TracingConstants.KEY_TAGS, this.a);
    }

    @Override // com.vivo.push.b.c, com.vivo.push.v
    public final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.a = dVar.c(TracingConstants.KEY_TAGS);
    }

    @Override // com.vivo.push.b.c, com.vivo.push.v
    public final String toString() {
        return "AliasCommand:" + b();
    }
}
