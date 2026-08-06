package com.vivo.push.p013e;

import com.vivo.push.p013e.p014a.C1246b;
import com.vivo.push.restructure.request.InterfaceC1348c;
import com.vivo.push.util.C1393t;

/* compiled from: SyncProfileInfoImpl.java */
/* renamed from: com.vivo.push.e.i */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
final class C1255i implements InterfaceC1348c<C1246b> {

    /* renamed from: a */
    final /* synthetic */ RunnableC1254h f435a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1255i(RunnableC1254h runnableC1254h) {
        this.f435a = runnableC1254h;
    }

    @Override // com.vivo.push.restructure.request.InterfaceC1348c
    /* renamed from: a */
    public final /* synthetic */ void mo672a(C1246b c1246b) {
        C1246b c1246b2 = c1246b;
        if (this.f435a.f433a != null) {
            C1393t.m1044b("query success");
            this.f435a.f433a.onSuccess(c1246b2.m678a());
        }
    }

    @Override // com.vivo.push.restructure.request.InterfaceC1348c
    /* renamed from: a */
    public final void mo671a(int i) {
        if (this.f435a.f433a != null) {
            C1393t.m1044b("query err : ".concat(String.valueOf(i)));
            this.f435a.f433a.onError(i);
        }
    }
}
