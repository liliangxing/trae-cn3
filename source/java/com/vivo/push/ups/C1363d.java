package com.vivo.push.ups;

import com.vivo.push.IPushActionListener;

/* compiled from: VUpsManager.java */
/* renamed from: com.vivo.push.ups.d */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
final class C1363d implements IPushActionListener {

    /* renamed from: a */
    final /* synthetic */ UPSTurnCallback f642a;

    /* renamed from: b */
    final /* synthetic */ VUpsManager f643b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1363d(VUpsManager vUpsManager, UPSTurnCallback uPSTurnCallback) {
        this.f643b = vUpsManager;
        this.f642a = uPSTurnCallback;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i) {
        this.f642a.onResult(new CodeResult(i));
    }
}
