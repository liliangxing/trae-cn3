package com.bytedance.sysoptimizer.allocatorx;

import android.content.Context;
import android.util.Log;
import com.bytedance.android.bytehook.ByteHook;
import com.bytedance.sysoptimizer.SysOptimizer;
import javax.annotation.Nullable;

/* loaded from: classes5.dex */
public class JemallocExtend {
    private static final String TAG = "JemallocExtend";

    private static native boolean art_extend_arena(int i);

    private static native boolean extend_arena();

    private static native boolean extend_arena_specific(String str, int i);

    private static native boolean extend_arena_specific_2(String str, int i);

    private static native boolean extend_multi_arena_to_auto(int i, int i2);

    private static native String get_jemalloc_stats();

    private static native boolean hwui_purge_control(int i);

    private static native boolean other_core_libs_extend_arena(int i);

    private static native boolean player_lib_extend_arena(int i);

    private static native boolean renderthread_extend_arena();

    @Nullable
    public static String getJemallocStats(Context context) {
        if (!SysOptimizer.loadOptimizerLibrary(context)) {
            return null;
        }
        ByteHook.init();
        try {
            return get_jemalloc_stats();
        } catch (NoSuchMethodError e) {
            Log.e(TAG, "NoSuchMethodError", e);
            return null;
        } catch (UnsatisfiedLinkError e2) {
            Log.e(TAG, "UnsatisfiedLinkError", e2);
            return null;
        }
    }

    public static boolean extendMultiArenaToAuto(Context context, int i, int i2) {
        if (SysOptimizer.loadOptimizerLibrary(context)) {
            ByteHook.init();
            try {
                if (!extend_multi_arena_to_auto(i, i2)) {
                    return false;
                }
                Log.e(TAG, "extend multi arenas to auto success!");
                return true;
            } catch (NoSuchMethodError e) {
                Log.e(TAG, "NoSuchMethodError", e);
            } catch (UnsatisfiedLinkError e2) {
                Log.e(TAG, "UnsatisfiedLinkError", e2);
            }
        }
        return false;
    }

    public static boolean extendArena(Context context) {
        if (SysOptimizer.loadOptimizerLibrary(context)) {
            ByteHook.init();
            try {
                if (!extend_arena()) {
                    return false;
                }
                Log.e(TAG, "thread extend success");
                return true;
            } catch (NoSuchMethodError e) {
                Log.e(TAG, "NoSuchMethodError", e);
            } catch (UnsatisfiedLinkError e2) {
                Log.e(TAG, "UnsatisfiedLinkError", e2);
            }
        }
        return false;
    }

    public static boolean renderThreadExtendArena(Context context) {
        if (SysOptimizer.loadOptimizerLibrary(context)) {
            ByteHook.init();
            try {
                if (!renderthread_extend_arena()) {
                    return false;
                }
                Log.e(TAG, "hook to extend renderthread success");
                return true;
            } catch (NoSuchMethodError e) {
                Log.e(TAG, "NoSuchMethodError", e);
            } catch (UnsatisfiedLinkError e2) {
                Log.e(TAG, "UnsatisfiedLinkError", e2);
            }
        }
        return false;
    }

    public static boolean artThreadExtendArena(Context context, int i) {
        if (SysOptimizer.loadOptimizerLibrary(context)) {
            ByteHook.init();
            try {
                if (!art_extend_arena(i)) {
                    return false;
                }
                Log.e(TAG, "hook to extend art success");
                return true;
            } catch (NoSuchMethodError e) {
                Log.e(TAG, "NoSuchMethodError", e);
            } catch (UnsatisfiedLinkError e2) {
                Log.e(TAG, "UnsatisfiedLinkError", e2);
            }
        }
        return false;
    }

    public static boolean playerExtendArena(Context context, int i) {
        if (SysOptimizer.loadOptimizerLibrary(context)) {
            ByteHook.init();
            try {
                if (!player_lib_extend_arena(i)) {
                    return false;
                }
                Log.e(TAG, "hook to extend other core libs success");
                return true;
            } catch (NoSuchMethodError e) {
                Log.e(TAG, "NoSuchMethodError", e);
            } catch (UnsatisfiedLinkError e2) {
                Log.e(TAG, "UnsatisfiedLinkError", e2);
            }
        }
        return false;
    }

    public static boolean extendArenaSpecific(Context context, String str, int i) {
        if (SysOptimizer.loadOptimizerLibrary(context)) {
            ByteHook.init();
            try {
                if (!extend_arena_specific(str, i)) {
                    return false;
                }
                Log.e(TAG, "hook to " + str + " to extend arena success");
                return true;
            } catch (NoSuchMethodError e) {
                Log.e(TAG, "NoSuchMethodError", e);
            } catch (UnsatisfiedLinkError e2) {
                Log.e(TAG, "UnsatisfiedLinkError", e2);
            }
        }
        return false;
    }

    public static boolean extendArenaSpecific2(Context context, String str, int i) {
        if (SysOptimizer.loadOptimizerLibrary(context)) {
            ByteHook.init();
            try {
                if (!extend_arena_specific_2(str, i)) {
                    return false;
                }
                Log.e(TAG, "hook to " + str + " to extend arena success");
                return true;
            } catch (NoSuchMethodError e) {
                Log.e(TAG, "NoSuchMethodError", e);
            } catch (UnsatisfiedLinkError e2) {
                Log.e(TAG, "UnsatisfiedLinkError", e2);
            }
        }
        return false;
    }

    public static boolean otherCoreLibsExtendArena(Context context, int i) {
        if (SysOptimizer.loadOptimizerLibrary(context)) {
            ByteHook.init();
            try {
                if (!other_core_libs_extend_arena(i)) {
                    return false;
                }
                Log.e(TAG, "hook to extend other core libs success");
                return true;
            } catch (NoSuchMethodError e) {
                Log.e(TAG, "NoSuchMethodError", e);
            } catch (UnsatisfiedLinkError e2) {
                Log.e(TAG, "UnsatisfiedLinkError", e2);
            }
        }
        return false;
    }

    public static boolean hwuiPurgeCtl(Context context, int i) {
        if (SysOptimizer.loadOptimizerLibrary(context)) {
            ByteHook.init();
            try {
                if (!hwui_purge_control(i)) {
                    return false;
                }
                Log.e(TAG, "hook hwui to control purge success");
                return true;
            } catch (NoSuchMethodError e) {
                Log.e(TAG, "NoSuchMethodError", e);
            } catch (UnsatisfiedLinkError e2) {
                Log.e(TAG, "UnsatisfiedLinkError", e2);
            }
        }
        return false;
    }
}
