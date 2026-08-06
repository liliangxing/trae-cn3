package com.bytedance.sysoptimizer;

import android.content.Context;
import android.util.Log;
import com.bytedance.android.bytehook.ByteHook;

/* loaded from: classes5.dex */
public class MaliMemOptimizer {
    private static final String TAG = "MaliMemOptimizer";
    private static volatile boolean hasEnableEglSetDamageRegionKHRErrorSkip;
    private static volatile boolean hasEnableMaliGLErrorRegionSpaceSkip;
    private static volatile boolean hasEnableMaliGLErrorSkip;
    private static volatile boolean hasSetTimeMillsDelayed;

    private static native void enable_egl_set_damage_region_khr_error_skip(boolean z);

    private static native void enable_gl_error_region_space_skip();

    private static native void enable_gl_error_skip(boolean z);

    private static native void set_time_mills_delayed(int i, int i2);

    private MaliMemOptimizer() {
    }

    public static synchronized void setTimeMillsDelayed(int i, int i2, Context context) {
        synchronized (MaliMemOptimizer.class) {
            if (hasSetTimeMillsDelayed) {
                return;
            }
            ByteHook.init();
            SysOptimizer.loadOptimizerLibrary(context);
            set_time_mills_delayed(i, i2);
            hasSetTimeMillsDelayed = true;
        }
    }

    public static synchronized void enableMaliGLErrorSkip(Context context, boolean z) {
        synchronized (MaliMemOptimizer.class) {
            if (hasEnableMaliGLErrorSkip) {
                return;
            }
            if (SysOptimizer.loadOptimizerLibrary(context)) {
                ByteHook.init();
                try {
                    enable_gl_error_skip(z);
                } catch (NoSuchMethodError e) {
                    Log.e(TAG, "NoSuchMethodError", e);
                    return;
                } catch (UnsatisfiedLinkError e2) {
                    Log.e(TAG, "UnsatisfiedLinkError", e2);
                    return;
                }
            }
            hasEnableMaliGLErrorSkip = true;
        }
    }

    public static synchronized void enableMaliGLErrorRegionSpaceSkip(Context context) {
        synchronized (MaliMemOptimizer.class) {
            if (hasEnableMaliGLErrorRegionSpaceSkip) {
                return;
            }
            if (SysOptimizer.loadOptimizerLibrary(context)) {
                ByteHook.init();
                try {
                    enable_gl_error_region_space_skip();
                } catch (NoSuchMethodError e) {
                    Log.e(TAG, "NoSuchMethodError", e);
                    return;
                } catch (UnsatisfiedLinkError e2) {
                    Log.e(TAG, "UnsatisfiedLinkError", e2);
                    return;
                }
            }
            hasEnableMaliGLErrorRegionSpaceSkip = true;
        }
    }

    public static synchronized void enableEglSetDamageRegionKHRErrorSkip(Context context, boolean z) {
        synchronized (MaliMemOptimizer.class) {
            if (hasEnableEglSetDamageRegionKHRErrorSkip) {
                return;
            }
            if (SysOptimizer.loadOptimizerLibrary(context)) {
                ByteHook.init();
                try {
                    enable_egl_set_damage_region_khr_error_skip(z);
                } catch (NoSuchMethodError e) {
                    Log.e(TAG, "NoSuchMethodError", e);
                    return;
                } catch (UnsatisfiedLinkError e2) {
                    Log.e(TAG, "UnsatisfiedLinkError", e2);
                    return;
                }
            }
            hasEnableEglSetDamageRegionKHRErrorSkip = true;
        }
    }
}
