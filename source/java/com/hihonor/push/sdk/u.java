package com.hihonor.push.sdk;

/* loaded from: classes6.dex */
public class u implements Runnable {
    public final /* synthetic */ HonorPushCallback a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;

    public u(s sVar, HonorPushCallback honorPushCallback, int i, String str) {
        this.a = honorPushCallback;
        this.b = i;
        this.c = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        HonorPushCallback honorPushCallback = this.a;
        if (honorPushCallback != null) {
            honorPushCallback.onFailure(this.b, this.c);
        }
    }
}
