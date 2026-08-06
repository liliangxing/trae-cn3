package com.hihonor.push.sdk;

import java.util.concurrent.Executor;

/* renamed from: com.hihonor.push.sdk.v0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class C0959v0<TResult> implements InterfaceC0934j0<TResult> {

    /* renamed from: a */
    public Executor f778a;

    /* renamed from: b */
    public InterfaceC0938l0 f779b;

    /* renamed from: c */
    public final Object f780c = new Object();

    public C0959v0(Executor executor, InterfaceC0938l0 interfaceC0938l0) {
        this.f779b = interfaceC0938l0;
        this.f778a = executor;
    }

    @Override // com.hihonor.push.sdk.InterfaceC0934j0
    /* renamed from: a */
    public final void mo770a(C0908a1<TResult> c0908a1) {
        if (c0908a1.m738e()) {
            return;
        }
        c0908a1.m737d();
        this.f778a.execute(new RunnableC0957u0(this, c0908a1));
    }
}
