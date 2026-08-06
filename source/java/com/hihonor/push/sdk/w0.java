package com.hihonor.push.sdk;

/* loaded from: classes6.dex */
public class w0 implements Runnable {
    public final /* synthetic */ a1 a;
    public final /* synthetic */ x0 b;

    public w0(x0 x0Var, a1 a1Var) {
        this.b = x0Var;
        this.a = a1Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.b.c) {
            Object obj = this.b.b;
            if (obj != null) {
                this.a.c();
                ((y0) obj).a.countDown();
            }
        }
    }
}
