package com.hihonor.push.sdk;

/* renamed from: com.hihonor.push.sdk.j */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class RunnableC0933j implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ HonorPushCallback f730a;

    /* renamed from: b */
    public final /* synthetic */ C0937l f731b;

    public RunnableC0933j(C0937l c0937l, HonorPushCallback honorPushCallback) {
        this.f731b = c0937l;
        this.f730a = honorPushCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        C0952s c0952s = this.f731b.f738d;
        c0952s.m779a(new CallableC0948q(c0952s), this.f730a);
    }
}
