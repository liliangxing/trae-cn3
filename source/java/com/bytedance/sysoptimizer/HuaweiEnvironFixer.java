package com.bytedance.sysoptimizer;

import android.content.Context;
import android.util.Log;
import com.bytedance.shadowhook.ShadowHook;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes5.dex */
public class HuaweiEnvironFixer {
    private static final int SHADOWHOOK_ERRNO_OK = 0;
    private static final int SHADOWHOOK_ERRNO_UNINIT = 2;
    private static final String TAG = "HuaweiEnvironFixer";
    private static final AtomicBoolean mInitFlag = new AtomicBoolean(false);

    public static native boolean fix();

    public static synchronized boolean apply(Context context) {
        synchronized (HuaweiEnvironFixer.class) {
            if (mInitFlag.get()) {
                return true;
            }
            int i = 2;
            try {
                if (SysOptimizer.loadOptimizerLibrary(context)) {
                    i = ShadowHook.init(new ShadowHook.ConfigBuilder().setMode(ShadowHook.Mode.SHARED).setDebuggable(true).build());
                } else {
                    Log.e(TAG, "load sysopt native lib fail.");
                }
            } catch (Throwable th) {
                Log.e(TAG, "init shadowhook fail", th);
            }
            if (i != 0) {
                Log.e(TAG, "shadowhook errno=" + i);
                return false;
            }
            try {
                boolean fix = fix();
                mInitFlag.set(true);
                return fix;
            } catch (Throwable th2) {
                Log.e(TAG, "apply fail", th2);
                return false;
            }
        }
    }
}
