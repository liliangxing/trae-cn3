package com.vivo.push.p012d;

import android.app.Activity;
import com.vivo.push.IPushActionListener;
import com.vivo.push.restructure.request.C1347b;
import com.vivo.push.restructure.request.C1349d;
import com.vivo.push.util.C1395v;
import com.vivo.push.util.C1396w;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NotifyGuideDialogManager.java */
/* renamed from: com.vivo.push.d.e */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class RunnableC1237e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Activity f401a;

    /* renamed from: b */
    final /* synthetic */ IPushActionListener f402b;

    /* renamed from: c */
    final /* synthetic */ long f403c;

    /* renamed from: d */
    final /* synthetic */ C1234b f404d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1237e(C1234b c1234b, Activity activity, IPushActionListener iPushActionListener, long j) {
        this.f404d = c1234b;
        this.f401a = activity;
        this.f402b = iPushActionListener;
        this.f403c = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int m666a = C1234b.m666a(this.f401a);
        if (m666a != 0) {
            this.f402b.onStateChanged(m666a);
            return;
        }
        C1349d.m901a().m905a(new C1347b(new C1233a(new C1239g(this.f403c, C1395v.m1053a(), C1396w.m1054a(this.f401a))), new C1238f(this), 3000L));
    }
}
