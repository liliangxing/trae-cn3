package com.hihonor.push.sdk;

import java.util.concurrent.Executor;

/* renamed from: com.hihonor.push.sdk.x0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class C0963x0<TResult> implements InterfaceC0934j0<TResult> {

    /* renamed from: a */
    public Executor f786a;

    /* renamed from: b */
    public InterfaceC0940m0<TResult> f787b;

    /* renamed from: c */
    public final Object f788c = new Object();

    public C0963x0(Executor executor, InterfaceC0940m0<TResult> interfaceC0940m0) {
        this.f787b = interfaceC0940m0;
        this.f786a = executor;
    }

    @Override // com.hihonor.push.sdk.InterfaceC0934j0
    /* renamed from: a */
    public final void mo770a(C0908a1<TResult> c0908a1) {
        if (c0908a1.m738e()) {
            c0908a1.m737d();
            this.f786a.execute(new RunnableC0961w0(this, c0908a1));
        }
    }
}
