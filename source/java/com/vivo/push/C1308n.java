package com.vivo.push;

import com.vivo.push.C1306m;
import com.vivo.push.restructure.C1313a;
import com.vivo.push.util.C1393t;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PushClientManager.java */
/* renamed from: com.vivo.push.n */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1308n implements IPushActionListener {

    /* renamed from: a */
    final /* synthetic */ C1306m.a f538a;

    /* renamed from: b */
    final /* synthetic */ String f539b;

    /* renamed from: c */
    final /* synthetic */ String f540c;

    /* renamed from: d */
    final /* synthetic */ C1306m f541d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1308n(C1306m c1306m, C1306m.a aVar, String str, String str2) {
        this.f541d = c1306m;
        this.f538a = aVar;
        this.f539b = str;
        this.f540c = str2;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i) {
        if (i == 0) {
            Object[] m801b = this.f538a.m801b();
            if (m801b == null || m801b.length == 0) {
                C1393t.m1034a("PushClientManager", "bind app result is null");
                return;
            } else {
                C1313a.m810a().m818h().mo756a((String) this.f538a.m801b()[0], this.f539b, this.f540c);
                return;
            }
        }
        C1313a.m810a().m818h().mo755a("");
    }
}
