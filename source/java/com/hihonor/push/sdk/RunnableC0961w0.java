package com.hihonor.push.sdk;

/* renamed from: com.hihonor.push.sdk.w0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class RunnableC0961w0 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ C0908a1 f783a;

    /* renamed from: b */
    public final /* synthetic */ C0963x0 f784b;

    public RunnableC0961w0(C0963x0 c0963x0, C0908a1 c0908a1) {
        this.f784b = c0963x0;
        this.f783a = c0908a1;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.f784b.f788c) {
            Object obj = this.f784b.f787b;
            if (obj != null) {
                this.f783a.m736c();
                ((C0965y0) obj).f791a.countDown();
            }
        }
    }
}
