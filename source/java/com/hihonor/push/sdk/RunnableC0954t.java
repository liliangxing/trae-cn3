package com.hihonor.push.sdk;

/* renamed from: com.hihonor.push.sdk.t */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class RunnableC0954t implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ HonorPushCallback f766a;

    /* renamed from: b */
    public final /* synthetic */ Object f767b;

    public RunnableC0954t(C0952s c0952s, HonorPushCallback honorPushCallback, Object obj) {
        this.f766a = honorPushCallback;
        this.f767b = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        HonorPushCallback honorPushCallback = this.f766a;
        if (honorPushCallback != null) {
            honorPushCallback.onSuccess(this.f767b);
        }
    }
}
