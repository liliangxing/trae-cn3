package com.vivo.push.p017h;

import android.content.Context;
import com.vivo.push.p010b.C1217n;
import com.vivo.push.sdk.PushMessageCallback;

/* compiled from: OnLogReceiveTask.java */
/* renamed from: com.vivo.push.h.s */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
final class RunnableC1293s implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C1217n f488a;

    /* renamed from: b */
    final /* synthetic */ C1292r f489b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1293s(C1292r c1292r, C1217n c1217n) {
        this.f489b = c1292r;
        this.f488a = c1217n;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.f489b.f454b;
        context = this.f489b.f625a;
        pushMessageCallback.onLog(context, this.f488a.m603e(), this.f488a.m604f(), this.f488a.m605g());
    }
}
