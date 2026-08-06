package com.vivo.push;

import com.vivo.push.listener.IPushQueryActionListener;
import com.vivo.push.restructure.C1313a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BasePushClient.java */
/* renamed from: com.vivo.push.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class RunnableC1203b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ IPushQueryActionListener f331a;

    /* renamed from: b */
    final /* synthetic */ C1199a f332b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1203b(C1199a c1199a, IPushQueryActionListener iPushQueryActionListener) {
        this.f332b = c1199a;
        this.f331a = iPushQueryActionListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String mo757b = C1313a.m810a().m818h().mo757b();
        IPushQueryActionListener iPushQueryActionListener = this.f331a;
        if (iPushQueryActionListener != null) {
            iPushQueryActionListener.onSuccess(mo757b);
        }
    }
}
