package com.hihonor.push.sdk;

import java.util.concurrent.Executor;

/* loaded from: classes6.dex */
public final class t0<TResult> implements j0<TResult> {
    public Executor a;
    public k0<TResult> b;
    public final Object c = new Object();

    public t0(Executor executor, k0<TResult> k0Var) {
        this.b = k0Var;
        this.a = executor;
    }

    @Override // com.hihonor.push.sdk.j0
    public final void a(a1<TResult> a1Var) {
        this.a.execute(new s0(this, a1Var));
    }
}
