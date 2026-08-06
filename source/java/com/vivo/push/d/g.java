package com.vivo.push.d;

import com.vivo.push.restructure.request.a.a.b;
import org.json.JSONException;

/* compiled from: NotifyGuideInput.java */
/* loaded from: classes7.dex */
public final class g implements com.vivo.push.restructure.request.a.a.b {
    public static final b.a<g> a = new h();
    private long b;
    private int c;
    private int d;
    private boolean e;

    public g(int i, boolean z) {
        this.c = i;
        this.d = 1;
        this.e = z;
    }

    public g(long j, int i, boolean z) {
        this.b = j;
        this.c = i;
        this.d = 2;
        this.e = z;
    }

    public g(com.vivo.push.restructure.request.a.a.a aVar) {
        try {
            this.b = aVar.b();
            this.c = aVar.a();
            this.d = aVar.a();
            this.e = aVar.d();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.vivo.push.restructure.request.a.a.b
    public final void a(com.vivo.push.restructure.request.a.a.a aVar) {
        aVar.a(this.b);
        aVar.a(this.c);
        aVar.a(this.d);
        aVar.a(this.e);
    }
}
