package com.hihonor.push.sdk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX WARN: Incorrect class signature, class is equals to this class: <TResult:Ljava/lang/Object;>Lcom/hihonor/push/sdk/a1<TTResult;>; */
/* loaded from: classes6.dex */
public final class a1<TResult> {
    public boolean b;
    public TResult c;
    public Exception d;
    public final Object a = new Object();
    public List<j0<TResult>> e = new ArrayList();

    public final void a() {
        synchronized (this.a) {
            Iterator<j0<TResult>> it = this.e.iterator();
            while (it.hasNext()) {
                try {
                    it.next().a(this);
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
            }
            this.e = null;
        }
    }

    public final Exception b() {
        Exception exc;
        synchronized (this.a) {
            exc = this.d;
        }
        return exc;
    }

    public final TResult c() {
        TResult tresult;
        synchronized (this.a) {
            if (this.d == null) {
                tresult = this.c;
            } else {
                throw new RuntimeException(this.d);
            }
        }
        return tresult;
    }

    public final boolean d() {
        synchronized (this.a) {
        }
        return false;
    }

    public final boolean e() {
        boolean z;
        synchronized (this.a) {
            if (this.b) {
                d();
                z = this.d == null;
            }
        }
        return z;
    }

    public final a1<TResult> a(j0<TResult> j0Var) {
        synchronized (this.a) {
            if (!this.b) {
                this.e.add(j0Var);
            } else {
                j0Var.a(this);
            }
        }
        return this;
    }
}
