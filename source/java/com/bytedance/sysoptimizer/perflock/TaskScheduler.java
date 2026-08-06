package com.bytedance.sysoptimizer.perflock;

import android.content.Context;
import android.util.Log;
import com.bytedance.sysoptimizer.SysOptimizer;

/* loaded from: classes5.dex */
public class TaskScheduler {
    public static final int GC_THREAD = 3;
    public static final int JIT_THREAD = 4;
    public static final int MAIN_THREAD = 1;
    public static final int RENDER_THREAD = 2;
    private static final String TAG = "TaskScheduler";
    private static volatile boolean sPopulated;

    private static native boolean bind_task_core(String str, int i);

    private static native boolean do_concurrent_optimize(int i, int i2);

    private static native void dump_data();

    private static native int get_thread_tid(String str);

    private static native boolean native_populate(boolean z);

    private static native boolean native_schedule_important_task(int i, int i2, int i3);

    private static native boolean native_schedule_task(String str, int i, int i2);

    private static native boolean set_task_priority(String str, int i);

    private static native void unbind_task_core(String str, boolean z);

    public static synchronized boolean doConcurrentOptimize(Context context, int i) {
        boolean doConcurrentOptimize;
        synchronized (TaskScheduler.class) {
            doConcurrentOptimize = doConcurrentOptimize(context, i, -1);
        }
        return doConcurrentOptimize;
    }

    public static synchronized boolean doConcurrentOptimize(Context context, int i, int i2) {
        synchronized (TaskScheduler.class) {
            if (SysOptimizer.loadOptimizerLibrary(context)) {
                try {
                    try {
                        return do_concurrent_optimize(i, i2);
                    } catch (UnsatisfiedLinkError e) {
                        Log.e(TAG, "UnsatisfiedLinkError", e);
                    }
                } catch (NoSuchMethodError e2) {
                    Log.e(TAG, "NoSuchMethodError", e2);
                }
            }
            return false;
        }
    }

    public static synchronized boolean populateDatas(Context context, boolean z) {
        synchronized (TaskScheduler.class) {
            if (SysOptimizer.loadOptimizerLibrary(context)) {
                try {
                    if (native_populate(z)) {
                        sPopulated = true;
                    }
                    return sPopulated;
                } catch (NoSuchMethodError e) {
                    Log.e(TAG, "NoSuchMethodError", e);
                } catch (UnsatisfiedLinkError e2) {
                    Log.e(TAG, "UnsatisfiedLinkError", e2);
                }
            }
            return false;
        }
    }

    public static synchronized boolean populateDatas(Context context) {
        synchronized (TaskScheduler.class) {
            if (SysOptimizer.loadOptimizerLibrary(context)) {
                try {
                    if (native_populate(false)) {
                        sPopulated = true;
                    }
                    return sPopulated;
                } catch (NoSuchMethodError e) {
                    Log.e(TAG, "NoSuchMethodError", e);
                } catch (UnsatisfiedLinkError e2) {
                    Log.e(TAG, "UnsatisfiedLinkError", e2);
                }
            }
            return false;
        }
    }

    public static synchronized boolean scheduleTask(String str, int i, int i2) {
        synchronized (TaskScheduler.class) {
            if (!sPopulated) {
                return false;
            }
            return native_schedule_task(str, i, i2);
        }
    }

    public static synchronized boolean scheduleImportantTask(Context context, int i, int i2, int i3) {
        synchronized (TaskScheduler.class) {
            if (i == 1) {
                if (SysOptimizer.loadOptimizerLibrary(context)) {
                    try {
                        return native_schedule_important_task(i, i2, i3);
                    } catch (NoSuchMethodError e) {
                        Log.e(TAG, "NoSuchMethodError", e);
                    } catch (UnsatisfiedLinkError e2) {
                        Log.e(TAG, "UnsatisfiedLinkError", e2);
                    }
                }
            } else if (sPopulated) {
                return native_schedule_important_task(i, i2, i3);
            }
            return false;
        }
    }

    public static synchronized boolean setTaskPriority(String str, int i) {
        synchronized (TaskScheduler.class) {
            if (!sPopulated) {
                return false;
            }
            return set_task_priority(str, i);
        }
    }

    public static synchronized boolean bindTaskCore(String str, int i) {
        synchronized (TaskScheduler.class) {
            if (!sPopulated) {
                return false;
            }
            return bind_task_core(str, i);
        }
    }

    public static synchronized void unbindTaskCore(String str, boolean z) {
        synchronized (TaskScheduler.class) {
            if (sPopulated) {
                unbind_task_core(str, z);
            }
        }
    }

    public static boolean isDataPopulated() {
        return sPopulated;
    }

    public static int getThreadTid(Context context, String str, boolean z) {
        if (z && !sPopulated) {
            populateDatas(context);
        }
        if (sPopulated) {
            return get_thread_tid(str);
        }
        return -1;
    }

    public static synchronized void dump(Context context) {
        synchronized (TaskScheduler.class) {
            if (sPopulated) {
                dump_data();
            }
        }
    }
}
