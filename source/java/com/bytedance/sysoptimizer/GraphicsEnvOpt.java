package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.bytedance.shadowhook.ShadowHook;

/* loaded from: classes5.dex */
public class GraphicsEnvOpt {
    private static final String TAG = "GraphicsEnvOpt";
    private static boolean sOptimized;

    private static native boolean optimize();

    public static synchronized void fix(Context context) {
        synchronized (GraphicsEnvOpt.class) {
            if (sOptimized) {
                return;
            }
            if (Build.VERSION.SDK_INT != 29) {
                return;
            }
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
