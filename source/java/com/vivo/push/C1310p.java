package com.vivo.push;

import com.vivo.push.restructure.C1313a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PushClientManager.java */
/* renamed from: com.vivo.push.p */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1310p implements IPushActionListener {

    /* renamed from: a */
    final /* synthetic */ C1306m f545a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1310p(C1306m c1306m) {
        this.f545a = c1306m;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i) {
        if (i == 0) {
            C1313a.m810a().m818h().mo758b("");
        } else {
            C1313a.m810a().m818h().mo759c("");
        }
    }
}
