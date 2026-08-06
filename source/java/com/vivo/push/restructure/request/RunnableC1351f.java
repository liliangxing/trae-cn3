package com.vivo.push.restructure.request;

/* compiled from: RequestManager.java */
/* renamed from: com.vivo.push.restructure.request.f */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
final class RunnableC1351f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C1347b f623a;

    /* renamed from: b */
    final /* synthetic */ HandlerC1350e f624b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1351f(HandlerC1350e handlerC1350e, C1347b c1347b) {
        this.f624b = handlerC1350e;
        this.f623a = c1347b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C1347b c1347b = this.f623a;
        if (c1347b == null || c1347b.m898b() == null) {
            return;
        }
        this.f623a.m898b().mo671a(1003);
    }
}
