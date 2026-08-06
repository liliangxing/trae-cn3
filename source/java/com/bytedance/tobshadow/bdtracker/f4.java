package com.bytedance.tobshadow.bdtracker;

import com.bytedance.tobshadow.applog.profile.UserProfileCallback;

/* loaded from: classes5.dex */
public class f4 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ h4 b;

    public f4(h4 h4Var, int i) {
        this.b = h4Var;
        this.a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        UserProfileCallback userProfileCallback = this.b.d;
        if (userProfileCallback != null) {
            userProfileCallback.onFail(this.a);
        }
    }
}
