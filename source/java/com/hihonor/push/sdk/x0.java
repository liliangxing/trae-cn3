package com.hihonor.push.sdk;

import java.util.concurrent.Executor;

/* loaded from: classes6.dex */
public final class x0<TResult> implements j0<TResult> {
    public Executor a;
    public m0<TResult> b;
    public final Object c = new Object();

    public x0(Executor executor, m0<TResult> m0Var) {
        this.b = m0Var;
        this.a = executor;
    }

    @Override // com.hihonor.push.sdk.j0
    public final void a(a1<TResult> a1Var) {
        if (a1Var.e()) {
            a1Var.d();
            this.a.execute(new w0(this, a1Var));
        }
    }
}
