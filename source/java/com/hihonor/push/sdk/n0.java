package com.hihonor.push.sdk;

/* loaded from: classes6.dex */
public class n0<TResult> {
    public final a1<TResult> a = new a1<>();

    public void a(TResult tresult) {
        a1<TResult> a1Var = this.a;
        synchronized (a1Var.a) {
            if (!a1Var.b) {
                a1Var.b = true;
                a1Var.c = tresult;
                a1Var.a.notifyAll();
                a1Var.a();
            }
        }
    }

    public void a(Exception exc) {
        a1<TResult> a1Var = this.a;
        synchronized (a1Var.a) {
            if (!a1Var.b) {
                a1Var.b = true;
                a1Var.d = exc;
                a1Var.a.notifyAll();
                a1Var.a();
            }
        }
    }
}
