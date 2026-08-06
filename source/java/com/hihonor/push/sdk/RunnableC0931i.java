package com.hihonor.push.sdk;

/* renamed from: com.hihonor.push.sdk.i */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class RunnableC0931i implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ HonorPushCallback f726a;

    /* renamed from: b */
    public final /* synthetic */ C0937l f727b;

    public RunnableC0931i(C0937l c0937l, HonorPushCallback honorPushCallback) {
        this.f727b = c0937l;
        this.f726a = honorPushCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        C0952s c0952s = this.f727b.f738d;
        c0952s.m779a(new CallableC0946p(c0952s), this.f726a);
    }
}
