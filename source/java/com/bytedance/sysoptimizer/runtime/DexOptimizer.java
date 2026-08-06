package com.bytedance.sysoptimizer.runtime;

import android.content.Context;
import android.util.Log;
import com.bytedance.android.bytehook.ByteHook;
import com.bytedance.shadowhook.ShadowHook;
import com.bytedance.sysoptimizer.SysOptimizer;

/* loaded from: classes5.dex */
public class DexOptimizer {
    private static final String TAG = "DexOptimizer";

    private static native boolean disable_dex_preload(int i);

    private static native boolean optimize_dexfile_preload();

    public static boolean disableDexPreload(Context context, int i) {
        if (!SysOptimizer.loadOptimizerLibrary(context)) {
            return false;
        }
        ByteHook.init();
        try {
            disable_dex_preload(i);
            return false;
        } catch (NoSuchMethodError e) {
            Log.e(TAG, "NoSuchMethodError", e);
            return false;
        } catch (UnsatisfiedLinkError e2) {
            Log.e(TAG, "UnsatisfiedLinkError", e2);
            return false;
        }
    }

    public static boolean optimizeDexFilePreload(Context context) {
        if (!SysOptimizer.loadOptimizerLibrary(context)) {
            return false;
        }
        ShadowHook.init(new ShadowHook.ConfigBuilder().setMode(ShadowHook.Mode.SHARED).setDebuggable(true).build());
        try {
            optimize_dexfile_preload();
            return false;
        } catch (NoSuchMethodError e) {
            Log.e(TAG, "NoSuchMethodError", e);
            return false;
        } catch (UnsatisfiedLinkError e2) {
            Log.e(TAG, "UnsatisfiedLinkError", e2);
            return false;
        }
    }
}
