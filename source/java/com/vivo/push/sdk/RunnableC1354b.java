package com.vivo.push.sdk;

import android.content.Context;
import com.vivo.push.C1306m;
import com.vivo.push.restructure.C1313a;
import com.vivo.push.restructure.p019a.C1330b;
import com.vivo.push.restructure.p019a.InterfaceC1314a;
import com.vivo.push.util.C1393t;

/* compiled from: CommandWorker.java */
/* renamed from: com.vivo.push.sdk.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
final class RunnableC1354b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ InterfaceC1314a f630a;

    /* renamed from: b */
    final /* synthetic */ C1353a f631b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1354b(C1353a c1353a, C1330b c1330b) {
        this.f631b = c1353a;
        this.f630a = c1330b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        C1313a m810a = C1313a.m810a();
        context = this.f631b.f327a;
        m810a.m811a(context);
        C1393t.m1048d("CommandWorker", " handleMessage type: ".concat(String.valueOf(this.f630a.mo828j())));
        C1306m m762a = C1306m.m762a();
        context2 = this.f631b.f327a;
        m762a.m774a(context2);
        C1313a.m810a().m814d().m842a(this.f630a);
    }
}
