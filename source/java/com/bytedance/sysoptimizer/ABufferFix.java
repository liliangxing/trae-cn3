package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.bytedance.shadowhook.ShadowHook;

/* loaded from: classes5.dex */
public class ABufferFix {
    private static final String TAG = "ABufferFix";
    private static boolean sOptimized;

    private static native boolean nStart(int i, boolean z, boolean z2, boolean z3);

    public static synchronized void start(Context context, boolean z, boolean z2, boolean z3) {
        synchronized (ABufferFix.class) {
            if (sOptimized) {
                return;
            }
            Log.i(TAG, "enter ABufferFix.start");
            if (SysOptimizer.loadOptimizerLibrary(context)) {
                ShadowHook.init(new ShadowHook.ConfigBuilder().setMode(ShadowHook.Mode.SHARED).setDebuggable(true).build());
                try {
                    Log.i(TAG, "enter ABufferFix.start try nStart");
                    nStart(Build.VERSION.SDK_INT, z, z2, z3);
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
