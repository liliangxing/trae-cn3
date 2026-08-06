package com.vivo.push.d;

import com.vivo.push.restructure.request.a.a.b;
import org.json.JSONException;

/* compiled from: NotifyGuideOutput.java */
/* loaded from: classes7.dex */
public final class i implements com.vivo.push.restructure.request.a.a.b {
    public static final b.a<i> a = new j();
    private int b;

    @Override // com.vivo.push.restructure.request.a.a.b
    public final void a(com.vivo.push.restructure.request.a.a.a aVar) {
        aVar.a(this.b);
    }

    public i(com.vivo.push.restructure.request.a.a.a aVar) throws JSONException {
        this.b = aVar.a();
    }

    public final int a() {
        return this.b;
    }
}
