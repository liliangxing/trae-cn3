package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;

/* loaded from: classes5.dex */
public class FdSanFatalSwitch {
    private static final String TAG = "FdSanFatalSwitch";
    private static volatile boolean mFdSanFatalSwitch;

    private static native void openAndroidQFdsan();

    public static synchronized void openAndroidQFdsan(Context context) {
        synchronized (FdSanFatalSwitch.class) {
            if (!mFdSanFatalSwitch && loadOptimizerOnNeed(context)) {
                openAndroidQFdsan();
                mFdSanFatalSwitch = true;
            }
        }
    }

    private static boolean loadOptimizerOnNeed(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            return SysOptimizer.loadOptimizerLibrary(context);
        }
        return false;
    }
}
