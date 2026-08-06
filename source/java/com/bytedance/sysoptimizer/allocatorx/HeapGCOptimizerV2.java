package com.bytedance.sysoptimizer.allocatorx;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.bytedance.shadowhook.ShadowHook;
import com.bytedance.sysoptimizer.SysOptimizer;

/* loaded from: classes5.dex */
public class HeapGCOptimizerV2 {
    private static final long KB = 1024;
    private static final long MB = 1048576;
    private static final String TAG = "HeapGCOptimizerV2";
    private static boolean sInited = false;
    private static int sMaxAPISupport = 33;

    private static native boolean disable_native_alloc_gc(int i);

    private static native boolean disable_request_trim(int i);

    private static native boolean optimize(long j, long j2, long j3, long j4);

    private static native boolean optimize_gc_step(long j, long j2);

    private static native boolean reuse_partial_tlab();

    private static native boolean sched_heap_task_daemon(int i, int i2);

    private static native boolean set_gc_step_diff_value(long j);

    private static native boolean set_max_heap_usage_add_gcdiff(float f);

    private static native boolean set_next_gc_type(int i);

    private static native boolean set_values(long j, long j2, long j3);

    public static synchronized void setHeapOptMaxAPISupport(int i) {
        synchronized (HeapGCOptimizerV2.class) {
            sMaxAPISupport = i;
        }
    }

    public static boolean shouldSkipHeapOptimize(int i, int i2, int i3) {
        if (Build.VERSION.SDK_INT > sMaxAPISupport) {
            Log.d(TAG, "current sdk version is to large. should NOT optimize");
            return true;
        }
        if (i <= 400 && i2 <= 32 && i >= 0 && i3 >= 0) {
            return false;
        }
        Log.d(TAG, "values is too dangerous. should NOT optimize");
        return true;
    }

    public static synchronized void optimize(Context context, int i, int i2, int i3) {
        synchronized (HeapGCOptimizerV2.class) {
            if (shouldSkipHeapOptimize(i, i2, i3)) {
                return;
            }
            if (SysOptimizer.loadOptimizerLibrary(context)) {
                ShadowHook.init(new ShadowHook.ConfigBuilder().setMode(ShadowHook.Mode.SHARED).setDebuggable(true).build());
                try {
                    if (sInited) {
                        set_values(i * 1048576, i2 * 1048576, i3 * 1048576);
                        return;
                    }
                    if (optimize(i * 1048576, i2 * 1048576, i3 * 1048576, Runtime.getRuntime().maxMemory())) {
                        Log.d(TAG, "first optimize success!");
                        sInited = true;
                    } else {
                        Log.d(TAG, "first optimize failed!");
                    }
                } catch (NoSuchMethodError e) {
                    Log.e(TAG, "NoSuchMethodError", e);
                } catch (UnsatisfiedLinkError e2) {
                    Log.e(TAG, "UnsatisfiedLinkError", e2);
                }
            }
        }
    }

    public static synchronized void optimizeOnGCStep(Context context, int i, int i2) {
        synchronized (HeapGCOptimizerV2.class) {
            if (Build.VERSION.SDK_INT > sMaxAPISupport) {
                Log.d(TAG, "current sdk version is to large. should NOT optimize");
                return;
            }
            if (SysOptimizer.loadOptimizerLibrary(context)) {
                ShadowHook.init(new ShadowHook.ConfigBuilder().setMode(ShadowHook.Mode.SHARED).setDebuggable(true).build());
                try {
                    if (optimize_gc_step(i * 1048576, i2 * 1048576)) {
                        Log.d(TAG, "optimize success!");
                    } else {
                        Log.d(TAG, "optimize failed!");
                    }
                } catch (NoSuchMethodError e) {
                    Log.e(TAG, "NoSuchMethodError", e);
                } catch (UnsatisfiedLinkError e2) {
                    Log.e(TAG, "UnsatisfiedLinkError", e2);
                }
            }
        }
    }

    public static synchronized void setGCStepDiff(Context context, int i) {
        synchronized (HeapGCOptimizerV2.class) {
            if (Build.VERSION.SDK_INT > sMaxAPISupport) {
                Log.d(TAG, "current sdk version is to large. should NOT optimize");
                return;
            }
            if (SysOptimizer.loadOptimizerLibrary(context)) {
                ShadowHook.init(new ShadowHook.ConfigBuilder().setMode(ShadowHook.Mode.SHARED).setDebuggable(true).build());
                try {
                    if (sInited) {
                        set_gc_step_diff_value(i * 1048576);
                    } else {
                        Log.d(TAG, "set gc step diff failed!");
                    }
                } catch (NoSuchMethodError e) {
                    Log.e(TAG, "NoSuchMethodError", e);
                } catch (UnsatisfiedLinkError e2) {
                    Log.e(TAG, "UnsatisfiedLinkError", e2);
                }
            }
        }
    }

    public static synchronized void setNextGCType(Context context, int i) {
        synchronized (HeapGCOptimizerV2.class) {
            if (Build.VERSION.SDK_INT > sMaxAPISupport) {
                Log.d(TAG, "current sdk version is to large. should NOT optimize");
                return;
            }
            if (SysOptimizer.loadOptimizerLibrary(context)) {
                ShadowHook.init(new ShadowHook.ConfigBuilder().setMode(ShadowHook.Mode.SHARED).setDebuggable(true).build());
                try {
                    try {
                        if (sInited) {
                            set_next_gc_type(i);
                        } else {
                            Log.d(TAG, "set next gc type failed!");
                        }
                    } catch (UnsatisfiedLinkError e) {
                        Log.e(TAG, "UnsatisfiedLinkError", e);
                    }
                } catch (NoSuchMethodError e2) {
                    Log.e(TAG, "NoSuchMethodError", e2);
                }
            }
        }
    }

    public static synchronized void setMaxHeapUsageAddGCDiff(Context context, float f) {
        synchronized (HeapGCOptimizerV2.class) {
            try {
                if (sInited) {
                    set_max_heap_usage_add_gcdiff(f);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static synchronized void reusePartialTLAB(Context context) {
        synchronized (HeapGCOptimizerV2.class) {
            if (SysOptimizer.loadOptimizerLibrary(context)) {
                ShadowHook.init(new ShadowHook.ConfigBuilder().setMode(ShadowHook.Mode.SHARED).setDebuggable(true).build());
                try {
                    if (reuse_partial_tlab()) {
                        Log.d(TAG, "opt for reusing partial thread local");
                    } else {
                        Log.d(TAG, "opt failed");
                    }
                } catch (NoSuchMethodError e) {
                    Log.e(TAG, "NoSuchMethodError", e);
                } catch (UnsatisfiedLinkError e2) {
                    Log.e(TAG, "UnsatisfiedLinkError", e2);
                }
            }
        }
    }

    public static synchronized void disableNativeAllocGC(Context context, int i) {
        synchronized (HeapGCOptimizerV2.class) {
            if (SysOptimizer.loadOptimizerLibrary(context)) {
                ShadowHook.init(new ShadowHook.ConfigBuilder().setMode(ShadowHook.Mode.SHARED).setDebuggable(true).build());
                try {
                    if (disable_native_alloc_gc(i)) {
                        Log.d(TAG, "opt for disable Native Alloc GC");
                    } else {
                        Log.d(TAG, "opt failed");
                    }
                } catch (NoSuchMethodError e) {
                    Log.e(TAG, "NoSuchMethodError", e);
                } catch (UnsatisfiedLinkError e2) {
                    Log.e(TAG, "UnsatisfiedLinkError", e2);
                }
            }
        }
    }

    public static synchronized void disableRequestTrim(Context context, int i) {
        synchronized (HeapGCOptimizerV2.class) {
            if (SysOptimizer.loadOptimizerLibrary(context)) {
                ShadowHook.init(new ShadowHook.ConfigBuilder().setMode(ShadowHook.Mode.SHARED).setDebuggable(true).build());
                try {
                    if (disable_request_trim(i)) {
                        Log.d(TAG, "opt for disable requestTrim");
                    } else {
                        Log.d(TAG, "opt failed");
                    }
                } catch (NoSuchMethodError e) {
                    Log.e(TAG, "NoSuchMethodError", e);
                } catch (UnsatisfiedLinkError e2) {
                    Log.e(TAG, "UnsatisfiedLinkError", e2);
                }
            }
        }
    }

    public static synchronized void schedHeapTaskDaemon(Context context, int i, int i2) {
        synchronized (HeapGCOptimizerV2.class) {
            if (SysOptimizer.loadOptimizerLibrary(context)) {
                try {
                    try {
                        if (sched_heap_task_daemon(i, i2)) {
                            Log.d(TAG, "opt for sched heap task daemon");
                        } else {
                            Log.d(TAG, "opt failed");
                        }
                    } catch (UnsatisfiedLinkError e) {
                        Log.e(TAG, "UnsatisfiedLinkError", e);
                    }
                } catch (NoSuchMethodError e2) {
                    Log.e(TAG, "NoSuchMethodError", e2);
                }
            }
        }
    }
}
