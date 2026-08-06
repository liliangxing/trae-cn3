package com.hihonor.push.sdk;

import java.util.concurrent.Callable;

/* renamed from: com.hihonor.push.sdk.z0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class RunnableC0967z0 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ C0943n0 f802a;

    /* renamed from: b */
    public final /* synthetic */ Callable f803b;

    public RunnableC0967z0(C0943n0 c0943n0, Callable callable) {
        this.f802a = c0943n0;
        this.f803b = callable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f802a.m777a((C0943n0) this.f803b.call());
        } catch (Exception e) {
            this.f802a.m776a(e);
        }
    }
}
