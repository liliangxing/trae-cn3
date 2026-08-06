package com.apm.lite.i;

import android.os.Handler;

/* loaded from: classes2.dex */
public abstract class a implements Runnable {
    private Handler a;
    private final long b;
    private final long c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Handler handler, long j, long j2) {
        this.a = handler;
        this.b = j;
        this.c = j2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (b() > 0) {
            this.a.postDelayed(this, b());
        } else {
            this.a.post(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j) {
        if (j > 0) {
            this.a.postDelayed(this, j);
        } else {
            this.a.post(this);
        }
    }

    long b() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long c() {
        return this.c;
    }
}
