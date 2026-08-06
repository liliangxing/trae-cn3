package com.hihonor.push.sdk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX WARN: Incorrect class signature, class is equals to this class: <TResult:Ljava/lang/Object;>Lcom/hihonor/push/sdk/a1<TTResult;>; */
/* renamed from: com.hihonor.push.sdk.a1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class C0908a1<TResult> {

    /* renamed from: b */
    public boolean f685b;

    /* renamed from: c */
    public TResult f686c;

    /* renamed from: d */
    public Exception f687d;

    /* renamed from: a */
    public final Object f684a = new Object();

    /* renamed from: e */
    public List<InterfaceC0934j0<TResult>> f688e = new ArrayList();

    /* renamed from: a */
    public final void m734a() {
        synchronized (this.f684a) {
            Iterator<InterfaceC0934j0<TResult>> it = this.f688e.iterator();
            while (it.hasNext()) {
                try {
                    it.next().mo770a(this);
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
            }
            this.f688e = null;
        }
    }

    /* renamed from: b */
    public final Exception m735b() {
        Exception exc;
        synchronized (this.f684a) {
            exc = this.f687d;
        }
        return exc;
    }

    /* renamed from: c */
    public final TResult m736c() {
        TResult tresult;
        synchronized (this.f684a) {
            if (this.f687d == null) {
                tresult = this.f686c;
            } else {
                throw new RuntimeException(this.f687d);
            }
        }
        return tresult;
    }

    /* renamed from: d */
    public final boolean m737d() {
        synchronized (this.f684a) {
        }
        return false;
    }

    /* renamed from: e */
    public final boolean m738e() {
        boolean z;
        synchronized (this.f684a) {
            if (this.f685b) {
                m737d();
                z = this.f687d == null;
            }
        }
        return z;
    }

    /* renamed from: a */
    public final C0908a1<TResult> m733a(InterfaceC0934j0<TResult> interfaceC0934j0) {
        synchronized (this.f684a) {
            if (!this.f685b) {
                this.f688e.add(interfaceC0934j0);
            } else {
                interfaceC0934j0.mo770a(this);
            }
        }
        return this;
    }
}
