package com.hihonor.push.sdk;

/* renamed from: com.hihonor.push.sdk.u */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class RunnableC0956u implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ HonorPushCallback f771a;

    /* renamed from: b */
    public final /* synthetic */ int f772b;

    /* renamed from: c */
    public final /* synthetic */ String f773c;

    public RunnableC0956u(C0952s c0952s, HonorPushCallback honorPushCallback, int i, String str) {
        this.f771a = honorPushCallback;
        this.f772b = i;
        this.f773c = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        HonorPushCallback honorPushCallback = this.f771a;
        if (honorPushCallback != null) {
            honorPushCallback.onFailure(this.f772b, this.f773c);
        }
    }
}
