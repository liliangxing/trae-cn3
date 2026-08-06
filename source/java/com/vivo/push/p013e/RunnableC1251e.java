package com.vivo.push.p013e;

import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.C1393t;

/* compiled from: SyncProfileInfoImpl.java */
/* renamed from: com.vivo.push.e.e */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
final class RunnableC1251e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f425a;

    /* renamed from: b */
    final /* synthetic */ IPushRequestCallback f426b;

    /* renamed from: c */
    final /* synthetic */ C1250d f427c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1251e(C1250d c1250d, String str, IPushRequestCallback iPushRequestCallback) {
        this.f427c = c1250d;
        this.f425a = str;
        this.f426b = iPushRequestCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C1393t.m1044b("add profileId");
        C1250d.m683a(this.f427c, this.f425a, this.f426b, 1);
    }
}
