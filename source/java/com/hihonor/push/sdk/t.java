package com.hihonor.push.sdk;

/* loaded from: classes6.dex */
public class t implements Runnable {
    public final /* synthetic */ HonorPushCallback a;
    public final /* synthetic */ Object b;

    public t(s sVar, HonorPushCallback honorPushCallback, Object obj) {
        this.a = honorPushCallback;
        this.b = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        HonorPushCallback honorPushCallback = this.a;
        if (honorPushCallback != null) {
            honorPushCallback.onSuccess(this.b);
        }
    }
}
