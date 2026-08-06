package com.vivo.push.p013e;

import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.C1393t;

/* compiled from: SyncProfileInfoImpl.java */
/* renamed from: com.vivo.push.e.g */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
final class RunnableC1253g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ IPushRequestCallback f431a;

    /* renamed from: b */
    final /* synthetic */ C1250d f432b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1253g(C1250d c1250d, IPushRequestCallback iPushRequestCallback) {
        this.f432b = c1250d;
        this.f431a = iPushRequestCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C1393t.m1044b("delete all profileIds");
        C1250d.m683a(this.f432b, "", this.f431a, 3);
    }
}
