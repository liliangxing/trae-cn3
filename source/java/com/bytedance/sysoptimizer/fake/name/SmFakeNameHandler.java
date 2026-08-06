package com.bytedance.sysoptimizer.fake.name;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.bytedance.sysoptimizer.SysOptimizer;

/* loaded from: classes5.dex */
public class SmFakeNameHandler {
    private static String TAG = "SYSOPTIMIZER";
    private static volatile boolean inited;

    private static boolean inAndroid5x() {
        return false;
    }

    private static native void replace(int i);

    public static synchronized void start(Context context) {
        synchronized (SmFakeNameHandler.class) {
            if (shouldFix()) {
                if (inited) {
                    return;
                }
                inited = true;
                if (SysOptimizer.loadOptimizerLibrary(context)) {
                    try {
                        try {
                            replace(Build.VERSION.SDK_INT);
                        } catch (UnsatisfiedLinkError e) {
                            Log.e(TAG, "UnsatisfiedLinkError", e);
                        }
                    } catch (NoSuchMethodError e2) {
                        Log.e(TAG, "NoSuchMethodError", e2);
                    }
                }
            }
        }
    }

    private static boolean shouldFix() {
        return inAndroid5x() && Build.MODEL.startsWith("SM-");
    }
}
