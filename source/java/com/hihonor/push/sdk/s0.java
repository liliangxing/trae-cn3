package com.hihonor.push.sdk;

/* loaded from: classes6.dex */
public class s0 implements Runnable {
    public final /* synthetic */ a1 a;
    public final /* synthetic */ t0 b;

    public s0(t0 t0Var, a1 a1Var) {
        this.b = t0Var;
        this.a = a1Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.b.c) {
            k0<TResult> k0Var = this.b.b;
            if (k0Var != 0) {
                k0Var.a(this.a);
            }
        }
    }
}
