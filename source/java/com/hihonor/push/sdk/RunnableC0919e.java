package com.hihonor.push.sdk;

import java.lang.ref.WeakReference;

/* renamed from: com.hihonor.push.sdk.e */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class RunnableC0919e implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ C0958v f700a;

    /* renamed from: b */
    public final /* synthetic */ C0937l f701b;

    public RunnableC0919e(C0937l c0937l, C0958v c0958v) {
        this.f701b = c0937l;
        this.f700a = c0958v;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f701b.f736b) {
            return;
        }
        this.f701b.f736b = true;
        this.f701b.getClass();
        this.f701b.f735a = new WeakReference<>(this.f700a.f776a);
        this.f701b.f737c = this.f700a.f777b;
        this.f701b.f738d = new C0952s(this.f700a.f776a);
        if (this.f701b.f737c) {
            C0937l c0937l = this.f701b;
            c0937l.m774a(new RunnableC0922f(c0937l, null, true), (HonorPushCallback<?>) null);
        }
    }
}
