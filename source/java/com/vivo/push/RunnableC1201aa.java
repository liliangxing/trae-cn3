package com.vivo.push;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.restructure.C1313a;
import com.vivo.push.util.C1373ah;

/* compiled from: SubscribeImpl.java */
/* renamed from: com.vivo.push.aa */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
final class RunnableC1201aa implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f325a;

    /* renamed from: b */
    final /* synthetic */ C1404z f326b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1201aa(C1404z c1404z, String str) {
        this.f326b = c1404z;
        this.f325a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context m812b = C1313a.m810a().m812b();
        if (m812b == null) {
            return;
        }
        long j = C1306m.m762a().m791f() ? 506L : 356L;
        if (TextUtils.isEmpty(this.f325a) || !C1373ah.m958a(m812b, m812b.getPackageName(), this.f325a, j)) {
            return;
        }
        C1313a.m810a().m815e().mo864e();
        this.f326b.f738d = "";
    }
}
