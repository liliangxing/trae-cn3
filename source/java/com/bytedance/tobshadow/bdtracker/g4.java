package com.bytedance.tobshadow.bdtracker;

import com.bytedance.tobshadow.applog.profile.UserProfileCallback;

/* loaded from: classes5.dex */
public class g4 implements Runnable {
    public final /* synthetic */ h4 a;

    public g4(h4 h4Var) {
        this.a = h4Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        UserProfileCallback userProfileCallback = this.a.d;
        if (userProfileCallback != null) {
            userProfileCallback.onSuccess();
        }
    }
}
