package com.vivo.push.ups;

import com.vivo.push.IPushActionListener;

/* compiled from: VUpsManager.java */
/* renamed from: com.vivo.push.ups.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
final class C1362c implements IPushActionListener {

    /* renamed from: a */
    final /* synthetic */ UPSTurnCallback f640a;

    /* renamed from: b */
    final /* synthetic */ VUpsManager f641b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1362c(VUpsManager vUpsManager, UPSTurnCallback uPSTurnCallback) {
        this.f641b = vUpsManager;
        this.f640a = uPSTurnCallback;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i) {
        this.f640a.onResult(new CodeResult(i));
    }
}
