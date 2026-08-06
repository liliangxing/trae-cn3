package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.bytedance.shadowhook.ShadowHook;

/* loaded from: classes5.dex */
public class BypassDexFileVerify {
    private static final String TAG = "BypassDexFileVerify";
    private static boolean sInited;

    private static native int bypassVerifyNative();

    public static synchronized int bypassVerify(Context context) {
        synchronized (BypassDexFileVerify.class) {
            int i = -1;
            if (sInited) {
                return -1;
            }
            if (!isTargetOSVersion()) {
                return -1;
            }
            if (SysOptimizer.loadOptimizerLibrary(context)) {
                ShadowHook.init(new ShadowHook.ConfigBuilder().setMode(ShadowHook.Mode.SHARED).setDebuggable(true).build());
                try {
                    i = bypassVerifyNative();
                    sInited = true;
                } catch (NoSuchMethodError e) {
                    Log.e(TAG, "NoSuchMethodError", e);
                } catch (UnsatisfiedLinkError e2) {
                    Log.e(TAG, "UnsatisfiedLinkError", e2);
                }
            }
            return i;
        }
    }

    private static boolean isTargetOSVersion() {
        return Build.VERSION.SDK_INT <= 27;
    }
}
