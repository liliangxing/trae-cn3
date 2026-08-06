package cn.com.chinatelecom.account.api.c;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes2.dex */
public abstract class e implements Runnable {
    private static Handler c = new Handler(Looper.getMainLooper());
    private boolean a = false;
    private long b;
    private a d;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a implements Runnable {
        private e a;

        public a(e eVar) {
            this.a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar = this.a;
            if (eVar != null) {
                eVar.b();
            }
        }
    }

    public e() {
    }

    public e(long j) {
        this.b = j;
    }

    private void e() {
        a aVar = new a(this);
        this.d = aVar;
        c.postDelayed(aVar, this.b);
    }

    public abstract void a();

    public void a(boolean z) {
        this.a = z;
    }

    public void b() {
    }

    public boolean c() {
        return this.a;
    }

    public void d() {
        try {
            a aVar = this.d;
            if (aVar != null) {
                c.removeCallbacks(aVar);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.b > 0) {
            e();
        }
        a();
    }
}
