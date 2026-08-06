package com.vivo.push.ups;

import com.vivo.push.IPushActionListener;

/* compiled from: VUpsManager.java */
/* renamed from: com.vivo.push.ups.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
final class C1361b implements IPushActionListener {

    /* renamed from: a */
    final /* synthetic */ UPSRegisterCallback f638a;

    /* renamed from: b */
    final /* synthetic */ VUpsManager f639b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1361b(VUpsManager vUpsManager, UPSRegisterCallback uPSRegisterCallback) {
        this.f639b = vUpsManager;
        this.f638a = uPSRegisterCallback;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i) {
        this.f638a.onResult(new TokenResult(i, ""));
    }
}
