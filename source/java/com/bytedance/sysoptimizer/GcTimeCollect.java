package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import com.bytedance.shadowhook.ShadowHook;

/* loaded from: classes5.dex */
public class GcTimeCollect {
    private static final String TAG = "GcTimeCollect";
    private static boolean sInited;
    private static final Object sMutex = new Object();

    private static native int startCollect(boolean z);

    public static boolean GcTimeCollectHook(Context context) {
        boolean z;
        synchronized (sMutex) {
            boolean z2 = false;
            if (sInited) {
                return false;
            }
            if (!isTargetOSVersion()) {
                return false;
            }
            try {
                if (SysOptimizer.loadOptimizerLibrary(context)) {
                    ShadowHook.init(new ShadowHook.ConfigBuilder().setMode(ShadowHook.Mode.SHARED).setDebuggable(true).build());
                    sInited = true;
                    z = true;
                } else {
                    z = false;
                }
                if (startCollect(true) == 0) {
                    z2 = z;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return z2;
        }
    }

    private static boolean isTargetOSVersion() {
        return Build.VERSION.SDK_INT <= 33;
    }
}
