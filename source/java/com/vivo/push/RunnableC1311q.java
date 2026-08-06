package com.vivo.push;

import com.vivo.push.p010b.C1205b;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PushClientManager.java */
/* renamed from: com.vivo.push.q */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class RunnableC1311q implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C1205b f546a;

    /* renamed from: b */
    final /* synthetic */ String f547b;

    /* renamed from: c */
    final /* synthetic */ C1306m f548c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1311q(C1306m c1306m, C1205b c1205b, String str) {
        this.f548c = c1306m;
        this.f546a = c1205b;
        this.f547b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f548c.m776a(this.f546a);
        this.f548c.m771c(this.f547b);
    }
}
