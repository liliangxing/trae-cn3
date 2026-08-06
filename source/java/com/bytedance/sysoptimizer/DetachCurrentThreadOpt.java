package com.bytedance.sysoptimizer;

import android.content.Context;
import android.util.Log;
import com.bytedance.shadowhook.ShadowHook;

/* loaded from: classes5.dex */
public class DetachCurrentThreadOpt {
    private static final String TAG = "DetachCurrentThreadOpt";
    private static boolean sOptimized;

    private static boolean isTargetOSVersion() {
        return false;
    }

    private static native boolean optimize();

    public static void fix(Context context, int i) {
        fix(context);
    }

    public static synchronized void fix(Context context) {
        synchronized (DetachCurrentThreadOpt.class) {
            if (sOptimized) {
                return;
            }
            if (isTargetOSVersion()) {
                if (SysOptimizer.loadOptimizerLibrary(context)) {
                    ShadowHook.init(new ShadowHook.ConfigBuilder().setMode(ShadowHook.Mode.SHARED).setDebuggable(true).build());
                    try {
                        optimize();
                        sOptimized = true;
                    } catch (NoSuchMethodError e) {
                        Log.e(TAG, "NoSuchMethodError", e);
                    } catch (UnsatisfiedLinkError e2) {
                        Log.e(TAG, "UnsatisfiedLinkError", e2);
                    }
                }
            }
        }
    }
}
