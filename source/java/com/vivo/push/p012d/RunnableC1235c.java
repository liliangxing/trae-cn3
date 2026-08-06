package com.vivo.push.p012d;

import android.app.Activity;
import com.vivo.push.IPushActionListener;
import com.vivo.push.restructure.request.C1347b;
import com.vivo.push.restructure.request.C1349d;
import com.vivo.push.util.C1395v;
import com.vivo.push.util.C1396w;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NotifyGuideDialogManager.java */
/* renamed from: com.vivo.push.d.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class RunnableC1235c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Activity f397a;

    /* renamed from: b */
    final /* synthetic */ IPushActionListener f398b;

    /* renamed from: c */
    final /* synthetic */ C1234b f399c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1235c(C1234b c1234b, Activity activity, IPushActionListener iPushActionListener) {
        this.f399c = c1234b;
        this.f397a = activity;
        this.f398b = iPushActionListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int m666a = C1234b.m666a(this.f397a);
        if (m666a != 0) {
            this.f398b.onStateChanged(m666a);
            return;
        }
        C1349d.m901a().m905a(new C1347b(new C1233a(new C1239g(C1395v.m1053a(), C1396w.m1054a(this.f397a))), new C1236d(this), 3000L));
    }
}
