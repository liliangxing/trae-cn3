package com.hihonor.push.sdk;

/* renamed from: com.hihonor.push.sdk.g */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class RunnableC0925g implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ HonorPushCallback f716a;

    /* renamed from: b */
    public final /* synthetic */ C0937l f717b;

    public RunnableC0925g(C0937l c0937l, HonorPushCallback honorPushCallback) {
        this.f717b = c0937l;
        this.f716a = honorPushCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        C0952s c0952s = this.f717b.f738d;
        c0952s.m779a(new CallableC0942n(c0952s), this.f716a);
    }
}
