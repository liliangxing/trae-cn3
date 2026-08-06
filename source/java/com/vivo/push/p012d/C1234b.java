package com.vivo.push.p012d;

import android.app.Activity;
import android.os.SystemClock;
import com.vivo.push.C1306m;
import com.vivo.push.IPushActionListener;
import com.vivo.push.restructure.C1313a;
import com.vivo.push.util.C1380g;
import com.vivo.push.util.C1393t;

/* compiled from: NotifyGuideDialogManager.java */
/* renamed from: com.vivo.push.d.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1234b {

    /* renamed from: a */
    private long f395a;

    /* synthetic */ C1234b(byte b) {
        this();
    }

    private C1234b() {
        this.f395a = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NotifyGuideDialogManager.java */
    /* renamed from: com.vivo.push.d.b$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class a {

        /* renamed from: a */
        private static final C1234b f396a = new C1234b(0);
    }

    /* renamed from: a */
    public static C1234b m667a() {
        return a.f396a;
    }

    /* renamed from: a */
    public final void m668a(Activity activity, IPushActionListener iPushActionListener) {
        if (iPushActionListener == null) {
            return;
        }
        C1380g.m996a().execute(new RunnableC1235c(this, activity, iPushActionListener));
    }

    /* renamed from: a */
    public final void m669a(Activity activity, IPushActionListener iPushActionListener, long j) {
        if (iPushActionListener == null) {
            return;
        }
        C1306m.m762a();
        if (!C1306m.m766a(this.f395a)) {
            C1393t.m1046c("NotifyGuideDialogManage", "tryShowGuideDialog: isCallingTooQuick, return");
            iPushActionListener.onStateChanged(1002);
        } else {
            this.f395a = SystemClock.elapsedRealtime();
            C1380g.m996a().execute(new RunnableC1237e(this, activity, iPushActionListener, j));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ int m666a(Activity activity) {
        if (!((activity == null || activity.isFinishing() || activity.getWindow() == null || activity.getWindow().getDecorView() == null || activity.getWindow().getDecorView().getVisibility() != 0) ? false : true)) {
            return 8105;
        }
        if (C1313a.m810a().m817g().m642a(16384)) {
            return C1313a.m810a().m816f().mo880b(activity) ? 8107 : 0;
        }
        return 8106;
    }
}
