package cn.com.chinatelecom.account.api.p008c;

import android.os.Handler;
import android.os.Looper;

/* renamed from: cn.com.chinatelecom.account.api.c.e */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public abstract class AbstractRunnableC0685e implements Runnable {

    /* renamed from: c */
    private static Handler f203c = new Handler(Looper.getMainLooper());

    /* renamed from: a */
    private boolean f204a = false;

    /* renamed from: b */
    private long f205b;

    /* renamed from: d */
    private a f206d;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cn.com.chinatelecom.account.api.c.e$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static class a implements Runnable {

        /* renamed from: a */
        private AbstractRunnableC0685e f207a;

        public a(AbstractRunnableC0685e abstractRunnableC0685e) {
            this.f207a = abstractRunnableC0685e;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractRunnableC0685e abstractRunnableC0685e = this.f207a;
            if (abstractRunnableC0685e != null) {
                abstractRunnableC0685e.mo205b();
            }
        }
    }

    public AbstractRunnableC0685e() {
    }

    public AbstractRunnableC0685e(long j) {
        this.f205b = j;
    }

    /* renamed from: e */
    private void m234e() {
        a aVar = new a(this);
        this.f206d = aVar;
        f203c.postDelayed(aVar, this.f205b);
    }

    /* renamed from: a */
    public abstract void mo204a();

    /* renamed from: a */
    public void m235a(boolean z) {
        this.f204a = z;
    }

    /* renamed from: b */
    public void mo205b() {
    }

    /* renamed from: c */
    public boolean m236c() {
        return this.f204a;
    }

    /* renamed from: d */
    public void m237d() {
        try {
            a aVar = this.f206d;
            if (aVar != null) {
                f203c.removeCallbacks(aVar);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f205b > 0) {
            m234e();
        }
        mo204a();
    }
}
