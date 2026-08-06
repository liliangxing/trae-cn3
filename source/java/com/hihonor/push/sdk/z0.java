package com.hihonor.push.sdk;

import java.util.concurrent.Callable;

/* loaded from: classes6.dex */
public final class z0 implements Runnable {
    public final /* synthetic */ n0 a;
    public final /* synthetic */ Callable b;

    public z0(n0 n0Var, Callable callable) {
        this.a = n0Var;
        this.b = callable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.a.a((n0) this.b.call());
        } catch (Exception e) {
            this.a.a(e);
        }
    }
}
