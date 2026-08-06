package com.hihonor.push.sdk;

/* renamed from: com.hihonor.push.sdk.k */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class RunnableC0935k implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ HonorPushCallback f732a;

    /* renamed from: b */
    public final /* synthetic */ C0937l f733b;

    public RunnableC0935k(C0937l c0937l, HonorPushCallback honorPushCallback) {
        this.f733b = c0937l;
        this.f732a = honorPushCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        C0952s c0952s = this.f733b.f738d;
        HonorPushCallback honorPushCallback = this.f732a;
        c0952s.getClass();
        if (honorPushCallback == null) {
            return;
        }
        C0908a1 m740a = C0909b.m740a(new CallableC0947p0(c0952s.f759a));
        C0950r c0950r = new C0950r(c0952s, honorPushCallback);
        m740a.getClass();
        m740a.m733a(new C0955t0(C0945o0.f747c.f748a, c0950r));
    }
}
