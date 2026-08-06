package com.vivo.push;

import com.vivo.push.p010b.C1205b;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PushClientManager.java */
/* renamed from: com.vivo.push.o */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class RunnableC1309o implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C1205b f542a;

    /* renamed from: b */
    final /* synthetic */ String f543b;

    /* renamed from: c */
    final /* synthetic */ C1306m f544c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1309o(C1306m c1306m, C1205b c1205b, String str) {
        this.f544c = c1306m;
        this.f542a = c1205b;
        this.f543b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f544c.m776a(this.f542a);
        this.f544c.m771c(this.f543b);
    }
}
