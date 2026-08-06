package com.hihonor.push.sdk;

import java.util.concurrent.Executor;

/* renamed from: com.hihonor.push.sdk.t0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class C0955t0<TResult> implements InterfaceC0934j0<TResult> {

    /* renamed from: a */
    public Executor f768a;

    /* renamed from: b */
    public InterfaceC0936k0<TResult> f769b;

    /* renamed from: c */
    public final Object f770c = new Object();

    public C0955t0(Executor executor, InterfaceC0936k0<TResult> interfaceC0936k0) {
        this.f769b = interfaceC0936k0;
        this.f768a = executor;
    }

    @Override // com.hihonor.push.sdk.InterfaceC0934j0
    /* renamed from: a */
    public final void mo770a(C0908a1<TResult> c0908a1) {
        this.f768a.execute(new RunnableC0953s0(this, c0908a1));
    }
}
