package com.apm.lite.p021i;

import android.os.Handler;

/* renamed from: com.apm.lite.i.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public abstract class AbstractRunnableC0762a implements Runnable {

    /* renamed from: a */
    private Handler f490a;

    /* renamed from: b */
    private final long f491b;

    /* renamed from: c */
    private final long f492c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractRunnableC0762a(Handler handler, long j, long j2) {
        this.f490a = handler;
        this.f491b = j;
        this.f492c = j2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m641a() {
        if (m643b() > 0) {
            this.f490a.postDelayed(this, m643b());
        } else {
            this.f490a.post(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m642a(long j) {
        if (j > 0) {
            this.f490a.postDelayed(this, j);
        } else {
            this.f490a.post(this);
        }
    }

    /* renamed from: b */
    long m643b() {
        return this.f491b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public long m644c() {
        return this.f492c;
    }
}
