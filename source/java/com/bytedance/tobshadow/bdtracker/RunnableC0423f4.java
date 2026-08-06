package com.bytedance.tobshadow.bdtracker;

import com.bytedance.tobshadow.applog.profile.UserProfileCallback;

/* renamed from: com.bytedance.tobshadow.bdtracker.f4 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class RunnableC0423f4 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f600a;

    /* renamed from: b */
    public final /* synthetic */ RunnableC0437h4 f601b;

    public RunnableC0423f4(RunnableC0437h4 runnableC0437h4, int i) {
        this.f601b = runnableC0437h4;
        this.f600a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        UserProfileCallback userProfileCallback = this.f601b.f654d;
        if (userProfileCallback != null) {
            userProfileCallback.onFail(this.f600a);
        }
    }
}
