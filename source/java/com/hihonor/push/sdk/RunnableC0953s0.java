package com.hihonor.push.sdk;

/* renamed from: com.hihonor.push.sdk.s0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class RunnableC0953s0 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ C0908a1 f764a;

    /* renamed from: b */
    public final /* synthetic */ C0955t0 f765b;

    public RunnableC0953s0(C0955t0 c0955t0, C0908a1 c0908a1) {
        this.f765b = c0955t0;
        this.f764a = c0908a1;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.f765b.f770c) {
            InterfaceC0936k0<TResult> interfaceC0936k0 = this.f765b.f769b;
            if (interfaceC0936k0 != 0) {
                interfaceC0936k0.mo731a(this.f764a);
            }
        }
    }
}
