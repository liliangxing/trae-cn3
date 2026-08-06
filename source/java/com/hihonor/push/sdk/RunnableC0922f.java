package com.hihonor.push.sdk;

/* renamed from: com.hihonor.push.sdk.f */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class RunnableC0922f implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ HonorPushCallback f703a;

    /* renamed from: b */
    public final /* synthetic */ boolean f704b;

    /* renamed from: c */
    public final /* synthetic */ C0937l f705c;

    public RunnableC0922f(C0937l c0937l, HonorPushCallback honorPushCallback, boolean z) {
        this.f705c = c0937l;
        this.f703a = honorPushCallback;
        this.f704b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        C0952s c0952s = this.f705c.f738d;
        c0952s.m779a(new CallableC0939m(c0952s, this.f704b), this.f703a);
    }
}
