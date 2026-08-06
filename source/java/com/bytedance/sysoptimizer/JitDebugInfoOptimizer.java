package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import com.bytedance.shadowhook.ShadowHook;

/* loaded from: classes5.dex */
public class JitDebugInfoOptimizer {
    private static final String TAG = "JitDebugInfoOptimizer";
    private static volatile boolean isOptimized;

    private static native void doOptimize(int i, boolean z);

    public static synchronized void install(Context context, boolean z) {
        synchronized (JitDebugInfoOptimizer.class) {
            if (!isOptimized && Build.VERSION.SDK_INT >= 28 && SysOptimizer.loadOptimizerLibrary(context)) {
                ShadowHook.init(new ShadowHook.ConfigBuilder().setMode(ShadowHook.Mode.SHARED).setDebuggable(true).build());
                doOptimize(Build.VERSION.SDK_INT, z);
                isOptimized = true;
            }
        }
    }
}
