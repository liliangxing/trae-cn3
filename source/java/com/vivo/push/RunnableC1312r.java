package com.vivo.push;

import com.vivo.push.C1306m;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PushClientManager.java */
/* renamed from: com.vivo.push.r */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class RunnableC1312r implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f549a;

    /* renamed from: b */
    final /* synthetic */ C1306m f550b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1312r(C1306m c1306m, String str) {
        this.f550b = c1306m;
        this.f549a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C1306m.a m769b;
        m769b = this.f550b.m769b(this.f549a);
        if (m769b != null) {
            m769b.m798a(1003, new Object[0]);
        }
    }
}
