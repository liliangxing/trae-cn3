package com.vivo.push.ups;

import com.vivo.push.IPushActionListener;
import com.vivo.push.restructure.C1313a;

/* compiled from: VUpsManager.java */
/* renamed from: com.vivo.push.ups.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
final class C1360a implements IPushActionListener {

    /* renamed from: a */
    final /* synthetic */ UPSRegisterCallback f636a;

    /* renamed from: b */
    final /* synthetic */ VUpsManager f637b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1360a(VUpsManager vUpsManager, UPSRegisterCallback uPSRegisterCallback) {
        this.f637b = vUpsManager;
        this.f636a = uPSRegisterCallback;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i) {
        this.f636a.onResult(new TokenResult(i, C1313a.m810a().m818h().mo757b()));
    }
}
