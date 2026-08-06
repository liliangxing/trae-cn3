package com.vivo.push;

import com.vivo.push.restructure.C1313a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BasePushClient.java */
/* renamed from: com.vivo.push.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class RunnableC1230c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ IPushActionListener f388a;

    /* renamed from: b */
    final /* synthetic */ C1199a f389b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1230c(C1199a c1199a, IPushActionListener iPushActionListener) {
        this.f389b = c1199a;
        this.f388a = iPushActionListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int mo753a = C1313a.m810a().m818h().mo753a();
        IPushActionListener iPushActionListener = this.f388a;
        if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(mo753a);
        }
    }
}
