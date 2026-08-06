package com.bytedance.tobshadow.bdtracker;

import com.bytedance.tobshadow.applog.profile.UserProfileCallback;

/* renamed from: com.bytedance.tobshadow.bdtracker.g4 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class RunnableC0430g4 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ RunnableC0437h4 f638a;

    public RunnableC0430g4(RunnableC0437h4 runnableC0437h4) {
        this.f638a = runnableC0437h4;
    }

    @Override // java.lang.Runnable
    public void run() {
        UserProfileCallback userProfileCallback = this.f638a.f654d;
        if (userProfileCallback != null) {
            userProfileCallback.onSuccess();
        }
    }
}
