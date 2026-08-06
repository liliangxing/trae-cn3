package com.hihonor.push.sdk;

import java.util.concurrent.Executor;

/* loaded from: classes6.dex */
public final class v0<TResult> implements j0<TResult> {
    public Executor a;
    public l0 b;
    public final Object c = new Object();

    public v0(Executor executor, l0 l0Var) {
        this.b = l0Var;
        this.a = executor;
    }

    @Override // com.hihonor.push.sdk.j0
    public final void a(a1<TResult> a1Var) {
        if (a1Var.e()) {
            return;
        }
        a1Var.d();
        this.a.execute(new u0(this, a1Var));
    }
}
