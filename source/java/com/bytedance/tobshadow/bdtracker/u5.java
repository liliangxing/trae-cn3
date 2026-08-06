package com.bytedance.tobshadow.bdtracker;

import android.content.Context;
import com.bytedance.bdinstall.Api;

/* loaded from: classes5.dex */
public final class u5 implements Runnable {
    public final /* synthetic */ Context a;

    public u5(Context context) {
        this.a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        t5.b.b(this.a).putBoolean(Api.KEY_STARTED, true);
    }
}
