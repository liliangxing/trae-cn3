package com.hihonor.push.sdk;

/* renamed from: com.hihonor.push.sdk.h */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class RunnableC0928h implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ HonorPushCallback f721a;

    /* renamed from: b */
    public final /* synthetic */ C0937l f722b;

    public RunnableC0928h(C0937l c0937l, HonorPushCallback honorPushCallback) {
        this.f722b = c0937l;
        this.f721a = honorPushCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        C0952s c0952s = this.f722b.f738d;
        c0952s.m779a(new CallableC0944o(c0952s), this.f721a);
    }
}
