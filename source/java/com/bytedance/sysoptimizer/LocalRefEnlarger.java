package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.bytedance.shadowhook.ShadowHook;

/* loaded from: classes5.dex */
public class LocalRefEnlarger {
    private static final String TAG = "LocalRefEnlarger";
    private static boolean sOptimized;

    private static native boolean optimize(int i);

    public static native void test();

    public static synchronized void fix(Context context) {
        synchronized (LocalRefEnlarger.class) {
            if (sOptimized) {
                return;
            }
            if (Build.VERSION.SDK_INT > 26) {
                return;
            }
            if (SysOptimizer.loadOptimizerLibrary(context)) {
                try {
                    ShadowHook.init(new ShadowHook.ConfigBuilder().setMode(ShadowHook.Mode.SHARED).setDebuggable(true).build());
                    if (optimize(Build.VERSION.SDK_INT)) {
                        Log.d(TAG, "opt for LocalRefEnlarger");
                    } else {
                        Log.d(TAG, "opt failed");
                    }
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
