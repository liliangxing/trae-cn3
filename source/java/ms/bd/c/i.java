package ms.bd.c;

import android.app.Activity;

/* loaded from: classes8.dex */
public final class i implements Runnable {
    public final /* synthetic */ Activity a;

    public i(Activity activity) {
        this.a = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        n.a(this.a);
        n.a(1);
    }
}
