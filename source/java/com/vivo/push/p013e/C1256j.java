package com.vivo.push.p013e;

import com.vivo.push.p013e.p014a.C1246b;
import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.restructure.request.InterfaceC1348c;
import com.vivo.push.util.C1393t;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SyncProfileInfoImpl.java */
/* renamed from: com.vivo.push.e.j */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1256j implements InterfaceC1348c<C1246b> {

    /* renamed from: a */
    final /* synthetic */ IPushRequestCallback f436a;

    /* renamed from: b */
    final /* synthetic */ int f437b;

    /* renamed from: c */
    final /* synthetic */ C1250d f438c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1256j(C1250d c1250d, IPushRequestCallback iPushRequestCallback, int i) {
        this.f438c = c1250d;
        this.f436a = iPushRequestCallback;
        this.f437b = i;
    }

    @Override // com.vivo.push.restructure.request.InterfaceC1348c
    /* renamed from: a */
    public final /* synthetic */ void mo672a(C1246b c1246b) {
        if (this.f436a != null) {
            C1393t.m1044b(this.f437b + " sync success");
            this.f436a.onSuccess(0);
        }
    }

    @Override // com.vivo.push.restructure.request.InterfaceC1348c
    /* renamed from: a */
    public final void mo671a(int i) {
        if (this.f436a != null) {
            C1393t.m1044b(this.f437b + " sync err : " + i);
            this.f436a.onError(i);
        }
    }
}
