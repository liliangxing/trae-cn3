package com.hihonor.push.sdk;

/* loaded from: classes6.dex */
public class u0 implements Runnable {
    public final /* synthetic */ a1 a;
    public final /* synthetic */ v0 b;

    public u0(v0 v0Var, a1 a1Var) {
        this.b = v0Var;
        this.a = a1Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.b.c) {
            l0 l0Var = this.b.b;
            if (l0Var != null) {
                this.a.b();
                ((y0) l0Var).a.countDown();
            }
        }
    }
}
