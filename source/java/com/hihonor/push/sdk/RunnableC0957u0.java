package com.hihonor.push.sdk;

/* renamed from: com.hihonor.push.sdk.u0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class RunnableC0957u0 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ C0908a1 f774a;

    /* renamed from: b */
    public final /* synthetic */ C0959v0 f775b;

    public RunnableC0957u0(C0959v0 c0959v0, C0908a1 c0908a1) {
        this.f775b = c0959v0;
        this.f774a = c0908a1;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.f775b.f780c) {
            InterfaceC0938l0 interfaceC0938l0 = this.f775b.f779b;
            if (interfaceC0938l0 != null) {
                this.f774a.m735b();
                ((C0965y0) interfaceC0938l0).f791a.countDown();
            }
        }
    }
}
