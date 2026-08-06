package com.vivo.push.p013e;

import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.C1393t;

/* compiled from: SyncProfileInfoImpl.java */
/* renamed from: com.vivo.push.e.f */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
final class RunnableC1252f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f428a;

    /* renamed from: b */
    final /* synthetic */ IPushRequestCallback f429b;

    /* renamed from: c */
    final /* synthetic */ C1250d f430c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1252f(C1250d c1250d, String str, IPushRequestCallback iPushRequestCallback) {
        this.f430c = c1250d;
        this.f428a = str;
        this.f429b = iPushRequestCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C1393t.m1044b("delete profileId");
        C1250d.m683a(this.f430c, this.f428a, this.f429b, 2);
    }
}
