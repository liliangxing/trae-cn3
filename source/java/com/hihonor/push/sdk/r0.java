package com.hihonor.push.sdk;

import java.util.concurrent.Executor;

/* loaded from: classes6.dex */
public final class r0<TResult> implements j0<TResult> {
    public Executor a;
    public y0 b;
    public final Object c = new Object();

    public r0(Executor executor, y0 y0Var) {
        this.b = y0Var;
        this.a = executor;
    }

    @Override // com.hihonor.push.sdk.j0
    public final void a(a1<TResult> a1Var) {
        a1Var.d();
    }
}
