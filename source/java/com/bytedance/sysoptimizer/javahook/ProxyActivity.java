package com.bytedance.sysoptimizer.javahook;

import android.app.Activity;
import android.os.Looper;

/* loaded from: classes5.dex */
public class ProxyActivity {
    private static final String TAG = "ProxyActivity";

    public void setTheme(int i) throws Throwable {
        AHook.getCallback().e(TAG, this + " before setTheme() called with: resid = [" + i + "]", new Throwable());
        AHook.callOrigin(OriginMethodKey.KEY_Activity_setTheme, this, Integer.valueOf(i));
        AHook.getCallback().e(TAG, this + " after setTheme() called with: resid = [" + i + "]", new Throwable());
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            toActivity(this).getWindow().getDecorView();
        }
    }

    private static Activity toActivity(Object obj) {
        return (Activity) obj;
    }
}
