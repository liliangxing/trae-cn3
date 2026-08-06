package com.bytedance.sysoptimizer;

import android.content.Context;
import android.util.Log;
import com.bytedance.android.bytehook.ByteHook;
import com.bytedance.keva.Keva;

/* loaded from: classes5.dex */
public class NativeAllocatorOptimizer {
    private static final String JEMALLOC_KEVA_REPO = "jemalloc_repo";
    private static final int KEVA_ININTED_FALSE = 1;
    private static final int KEVA_ININTED_TRUE = 2;
    private static final int KEVA_NO_TINITED = 0;
    private static final String KEY_IS_JEMALLOC_ALLOCATOR = "is_jemalloc_allocator";
    private static final String TAG = "NativeAllocator";
    private static boolean sIsInvoked;
    private static boolean sIsJemalloc;

    private static native boolean do_jemalloc_decay_opt(int i);

    private static native boolean do_jemalloc_purge();

    private static native boolean do_set_extra_graphic_buffer(int i);

    private static native boolean do_set_gui_extra_graphic_buffer(int i);

    private static native boolean do_shrink_native_thread(int i);

    private static native boolean is_jemalloc_allocator();

    private static native boolean optimize(int i);

    public static synchronized void optimize(Context context, int i) {
        synchronized (NativeAllocatorOptimizer.class) {
            if (SysOptimizer.loadOptimizerLibrary(context)) {
                try {
                    try {
                        if (optimize(i)) {
                            Log.d(TAG, "opt NativeAllocator flag");
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

    public static boolean doJemallocPurge() {
        try {
            if (do_jemalloc_purge()) {
                Log.d(TAG, "opted jemalloc purge");
                return true;
            }
            Log.d(TAG, "opt failed");
            return false;
        } catch (NoSuchMethodError e) {
            Log.e(TAG, "NoSuchMethodError", e);
            return false;
        } catch (UnsatisfiedLinkError e2) {
            Log.e(TAG, "UnsatisfiedLinkError", e2);
            return false;
        }
    }

    public static boolean isJemallocAllocator(Context context) {
        if (sIsInvoked) {
            return sIsJemalloc;
        }
        if (SysOptimizer.loadOptimizerLibrary(context)) {
            try {
                if (is_jemalloc_allocator()) {
                    Log.d(TAG, "found the jemalloc symbols");
                    sIsJemalloc = true;
                } else {
                    Log.d(TAG, "NOT found jemalloc symbols");
                    sIsJemalloc = false;
                }
                sIsInvoked = true;
                return sIsJemalloc;
            } catch (NoSuchMethodError e) {
                Log.e(TAG, "NoSuchMethodError", e);
            } catch (UnsatisfiedLinkError e2) {
                Log.e(TAG, "UnsatisfiedLinkError", e2);
            }
        }
        return false;
    }

    public static boolean doJemallocDecayOpt(Context context, int i) {
        if (!SysOptimizer.loadOptimizerLibrary(context)) {
            return false;
        }
        try {
            if (do_jemalloc_decay_opt(i)) {
                Log.d(TAG, "opted jemalloc decay time");
                return true;
            }
            Log.d(TAG, "opt failed");
            return false;
        } catch (NoSuchMethodError e) {
            Log.e(TAG, "NoSuchMethodError", e);
            return false;
        } catch (UnsatisfiedLinkError e2) {
            Log.e(TAG, "UnsatisfiedLinkError", e2);
            return false;
        }
    }

    public static boolean doShrinkNativeThread(Context context, int i) {
        if (!SysOptimizer.loadOptimizerLibrary(context)) {
            return false;
        }
        ByteHook.init();
        try {
            if (do_shrink_native_thread(i)) {
                Log.d(TAG, "opted native thread");
                return true;
            }
            Log.d(TAG, "opt failed");
            return false;
        } catch (NoSuchMethodError e) {
            Log.e(TAG, "NoSuchMethodError", e);
            return false;
        } catch (UnsatisfiedLinkError e2) {
            Log.e(TAG, "UnsatisfiedLinkError", e2);
            return false;
        }
    }

    public static boolean doSetExtraGraphicBuffer(Context context, int i) {
        if (!SysOptimizer.loadOptimizerLibrary(context)) {
            return false;
        }
        ByteHook.init();
        try {
            if (do_set_extra_graphic_buffer(i)) {
                Log.d(TAG, "opted extra buffer");
                return true;
            }
            Log.d(TAG, "opt failed");
            return false;
        } catch (NoSuchMethodError e) {
            Log.e(TAG, "NoSuchMethodError", e);
            return false;
        } catch (UnsatisfiedLinkError e2) {
            Log.e(TAG, "UnsatisfiedLinkError", e2);
            return false;
        }
    }

    public static boolean doSetGUIExtraGraphicBuffer(Context context, int i) {
        if (!SysOptimizer.loadOptimizerLibrary(context)) {
            return false;
        }
        ByteHook.init();
        try {
            if (do_set_gui_extra_graphic_buffer(i)) {
                Log.d(TAG, "opted gui extra buffer");
                return true;
            }
            Log.d(TAG, "opt failed");
            return false;
        } catch (NoSuchMethodError e) {
            Log.e(TAG, "NoSuchMethodError", e);
            return false;
        } catch (UnsatisfiedLinkError e2) {
            Log.e(TAG, "UnsatisfiedLinkError", e2);
            return false;
        }
    }

    private static void setIsJemallocAllocatorToKeva(int i) {
        Keva.getRepo(JEMALLOC_KEVA_REPO).storeInt(KEY_IS_JEMALLOC_ALLOCATOR, i);
    }

    private static int getIsJemallocAllocatorFromKeva() {
        return Keva.getRepo(JEMALLOC_KEVA_REPO).getInt(KEY_IS_JEMALLOC_ALLOCATOR, 0);
    }
}
