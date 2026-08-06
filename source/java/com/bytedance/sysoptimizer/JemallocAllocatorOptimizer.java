package com.bytedance.sysoptimizer;

import android.content.Context;
import android.util.Log;
import com.bytedance.android.bytehook.ByteHook;

/* loaded from: classes5.dex */
public class JemallocAllocatorOptimizer {
    private static final String TAG = "JemallocAllocator";

    private static native boolean do_arena_chunk_hooks();

    private static native boolean do_arena_decay();

    private static native int do_arena_decay_time(long j);

    private static native boolean do_arena_destroy();

    private static native int do_arena_dirty_decay_ms(long j);

    private static native int do_arena_dss(String str);

    private static native boolean do_arena_extent_hooks();

    private static native int do_arena_lg_dirty_mult(long j);

    private static native int do_arena_muzzy_decay_ms(long j);

    private static native boolean do_arena_purge();

    private static native boolean do_arena_reset();

    private static native int do_arena_retain_grow_limit(long j);

    private static native int do_arenas_decay_time(long j);

    private static native int do_arenas_dirty_decay_ms(long j);

    private static native int do_arenas_lg_dirty_mult(long j);

    private static native int do_arenas_muzzy_decay_ms(long j);

    private static native boolean do_arenas_purge();

    private static native String do_get_arena_dss();

    private static native boolean do_get_boolean_option_value(String str);

    private static native int do_get_integer_option_value(String str);

    private static native boolean do_opt_retain(boolean z);

    private static native int do_tcache_create();

    private static native boolean do_tcache_destroy(int i);

    private static native boolean do_tcache_flush();

    private static native boolean do_thread_arena(int i);

    private static native int do_thread_tcache_enabled(boolean z);

    private static native boolean do_thread_tcache_flush();

    public static synchronized void getJemallocOptions(Context context) {
        synchronized (JemallocAllocatorOptimizer.class) {
            if (SysOptimizer.loadOptimizerLibrary(context)) {
                ByteHook.init();
                StringBuilder sb = new StringBuilder(100);
                sb.append(String.format("raw thread.arena is %d\n", Integer.valueOf(do_get_integer_option_value("thread.arena"))));
                sb.append(String.format("thread.tcache.enabled is %b\n", Boolean.valueOf(do_get_boolean_option_value("thread.tcache.enabled"))));
                sb.append(String.format("arenas.narenas is %d\n", Integer.valueOf(do_get_integer_option_value("arenas.narenas"))));
                sb.append(String.format("arena.<i>.lg_dirty_mult is %d\n", Integer.valueOf(do_get_integer_option_value("arena.0.lg_dirty_mult"))));
                sb.append(String.format("arena.<i>.decay_time is %d\n", Integer.valueOf(do_get_integer_option_value("arena.0.decay_time"))));
                sb.append(String.format("arena.<i>.dirty_decay_ms is %d\n", Integer.valueOf(do_get_integer_option_value("arena.0.dirty_decay_ms"))));
                sb.append(String.format("arena.<i>.muzzy_decay_ms is %d\n", Integer.valueOf(do_get_integer_option_value("arena.0.muzzy_decay_ms"))));
                sb.append(String.format("arena.<i>.retain_grow_limit is %d\n", Integer.valueOf(do_get_integer_option_value("arena.0.retain_grow_limit"))));
                sb.append(String.format("arenas.lg_dirty_mult is %d\n", Integer.valueOf(do_get_integer_option_value("arenas.lg_dirty_mult"))));
                sb.append(String.format("arenas.decay_time is %d\n", Integer.valueOf(do_get_integer_option_value("arenas.decay_time"))));
                sb.append(String.format("arenas.dirty_decay_ms is %d\n", Integer.valueOf(do_get_integer_option_value("arenas.dirty_decay_ms"))));
                sb.append(String.format("arenas.muzzy_decay_ms is %d\n", Integer.valueOf(do_get_integer_option_value("arenas.muzzy_decay_ms"))));
                Log.d(TAG, sb.toString());
            }
        }
    }

    public static synchronized void setJemallocOptions(Context context) {
        synchronized (JemallocAllocatorOptimizer.class) {
            if (SysOptimizer.loadOptimizerLibrary(context)) {
                ByteHook.init();
                StringBuilder sb = new StringBuilder(100);
                if (do_thread_arena(0)) {
                    sb.append("jemalloc thread.arena (unsigned) rw success!\n");
                } else {
                    sb.append("jemalloc thread.arena (unsigned) rw failed!\n");
                }
                if (do_thread_tcache_enabled(true) == 0 && do_thread_tcache_enabled(false) == 0) {
                    sb.append("jemalloc thread.tcache.enabled (bool) rw success!\n");
                } else {
                    sb.append("jemalloc thread.tcache.enabled (bool) rw failed!\n");
                }
                if (do_thread_tcache_flush()) {
                    sb.append("jemalloc thread.tcache.flush (void) -- success!\n");
                } else {
                    sb.append("jemalloc thread.tcache.flush (void) -- failed!\n");
                }
                int do_tcache_create = do_tcache_create();
                if (do_tcache_create == 0) {
                    sb.append("jemalloc tcache.create (unsigned) r- success!\n");
                } else {
                    sb.append("jemalloc tcache.create (unsigned) r- failed!\n");
                }
                if (do_tcache_flush()) {
                    sb.append("jemalloc tcache.flush (unsigned) -w success!\n");
                } else {
                    sb.append("jemalloc tcache.flush (unsigned) -w failed!\n");
                }
                if (do_tcache_create == 0 && do_tcache_destroy(do_tcache_create)) {
                    sb.append("jemalloc tcache.destroy (unsigned) -w success\n");
                } else {
                    sb.append("jemalloc tcache.destroy (unsigned) -w failed\n");
                }
                if (do_arena_decay()) {
                    sb.append("jemalloc arena.<i>.decay (void) -- success!\n");
                } else {
                    sb.append("jemalloc arena.<i>.decay (void) -- failed!\n");
                }
                if (do_arena_purge()) {
                    sb.append("jemalloc arena.<i>.purge (void) -- success!\n");
                } else {
                    sb.append("jemalloc arena.<i>.purge (void) -- failed!\n");
                }
                sb.append("jemalloc arena.<i>.reset (void) -- crash!\n");
                if (do_arena_destroy()) {
                    sb.append("jemalloc arena.<i>.destroy (void) -- success!\n");
                } else {
                    sb.append("jemalloc arena.<i>.destroy (void) -- failed!\n");
                }
                sb.append(String.format("get jemalloc arena.<i>.dss, result: %s\n", do_get_arena_dss()));
                if (do_arena_dss("secondary") == 0) {
                    sb.append("jemalloc arena.<i>.dss (const char *) rw success!\n");
                } else {
                    sb.append("jemalloc arena.<i>.dss (const char *) rw failed!\n");
                }
                if (do_arena_lg_dirty_mult(1000L) == 0) {
                    sb.append("jemalloc arena.<i>.lg_dirty_mult (ssize_t) rw success!\n");
                } else {
                    sb.append("jemalloc arena.<i>.lg_dirty_mult (ssize_t) rw failed!\n");
                }
                if (do_arena_decay_time(1000L) == 0) {
                    sb.append("jemalloc arena.<i>.decay_time (ssize_t) rw success!\n");
                } else {
                    sb.append("jemalloc arena.<i>.decay_time (ssize_t) rw failed!\n");
                }
                if (do_arena_dirty_decay_ms(1000L) == 0) {
                    sb.append("jemalloc arena.<i>.dirty_decay_ms (ssize_t) rw succeed!\n");
                } else {
                    sb.append("jemalloc arena.<i>.dirty_decay_ms (ssize_t) rw failed!\n");
                }
                if (do_arena_muzzy_decay_ms(1000L) == 0) {
                    sb.append("jemalloc arena.<i>.dirty_muzzy_decay_ms (ssize_t) rw succeed!\n");
                } else {
                    sb.append("jemalloc arena.<i>.dirty_muzzy_decay_ms (ssize_t) rw failed!\n");
                }
                if (do_arena_retain_grow_limit(1048576L) == 0) {
                    sb.append("jemalloc arena.<i>.retain_grow_limit (size_t) rw succeed!\n");
                } else {
                    sb.append("jemalloc arena.<i>.retain_grow_limit (size_t) rw failed!\n");
                }
                if (do_arena_extent_hooks()) {
                    sb.append("jemalloc arena.<i>.extent_hooks (extent_hooks_t *) rw succeed!\n");
                } else {
                    sb.append("jemalloc arena.<i>.extent_hooks (extent_hooks_t *) rw failed!\n");
                }
                if (do_arena_chunk_hooks()) {
                    sb.append("jemalloc arena.<i>.chunk_hooks (chunk_hooks_t) rw succeed!\n");
                } else {
                    sb.append("jemalloc arena.<i>.chunk_hooks (chunk_hooks_t) rw failed!\n");
                }
                if (do_arenas_lg_dirty_mult(1000L) == 0) {
                    sb.append("jemalloc arenas.lg_dirty_mult(ssize_t) rw succeed!\n");
                } else {
                    sb.append("jemalloc arenas.lg_dirty_mult(ssize_t) rw failed!\n");
                }
                if (do_arenas_decay_time(1000L) == 0) {
                    sb.append("jemalloc arenas.decay_time (ssize_t) rw succeed!\n");
                } else {
                    sb.append("jemalloc arenas.decay_time (ssize_t) rw failed!\n");
                }
                if (do_arenas_dirty_decay_ms(1000L) == 0) {
                    sb.append("jemalloc arenas.dirty_decay_ms (ssize_t) rw succeed!\n");
                } else {
                    sb.append("jemalloc arenas.dirty_decay_ms (ssize_t) rw failed!\n");
                }
                if (do_arenas_muzzy_decay_ms(1000L) == 0) {
                    sb.append("jemalloc arenas.muzzy_decay_ms (ssize_t) rw succeed!\n");
                } else {
                    sb.append("jemalloc arenas.muzzy_decay_ms (ssize_t) rw failed!\n");
                }
                if (do_arenas_purge()) {
                    sb.append("jemalloc arenas.purge (unsigned) -w succeed!\n");
                } else {
                    sb.append("jemalloc arenas.purge (unsigned) -w failed!\n");
                }
                Log.d(TAG, sb.toString());
            }
        }
    }

    public static JemallocSettingResult doJemallocThreadTcacheEnabled(Context context, boolean z) {
        if (SysOptimizer.loadOptimizerLibrary(context)) {
            try {
                boolean do_get_boolean_option_value = do_get_boolean_option_value("thread.tcache.enabled");
                Log.d(TAG, "opted jemalloc thread.tcache.enabled(bool), exit code: " + do_thread_tcache_enabled(z));
                return new JemallocSettingResult("thread.tcache.enabled(bool)", String.valueOf(do_get_boolean_option_value), String.valueOf(z), 0);
            } catch (NoSuchMethodError e) {
                Log.e(TAG, "NoSuchMethodError", e);
            } catch (UnsatisfiedLinkError e2) {
                Log.e(TAG, "UnsatisfiedLinkError", e2);
            }
        }
        return new JemallocSettingResult("thread.tcache.enabled", "", String.valueOf(z), -1);
    }

    public static JemallocSettingResult doJemallocArenasDecayTime(Context context, int i) {
        if (SysOptimizer.loadOptimizerLibrary(context)) {
            try {
                int do_get_integer_option_value = do_get_integer_option_value("arenas.decay_time");
                int do_arenas_decay_time = do_arenas_decay_time(i);
                Log.d(TAG, "opted jemalloc arenas.decay_time(ssize_t), exit code:" + do_arenas_decay_time);
                return new JemallocSettingResult("arenas.decay_time(ssize_t)", String.valueOf(do_get_integer_option_value), String.valueOf(i), do_arenas_decay_time);
            } catch (NoSuchMethodError e) {
                Log.e(TAG, "NoSuchMethodError", e);
            } catch (UnsatisfiedLinkError e2) {
                Log.e(TAG, "UnsatisfiedLinkError", e2);
            }
        }
        return new JemallocSettingResult("arenas.decay_time(ssize_t)", "", String.valueOf(i), -1);
    }

    public static JemallocSettingResult doJemallocArenasDirtyDecayMs(Context context, int i) {
        if (SysOptimizer.loadOptimizerLibrary(context)) {
            try {
                int do_get_integer_option_value = do_get_integer_option_value("arenas.dirty_decay_ms");
                int do_arenas_dirty_decay_ms = do_arenas_dirty_decay_ms(i);
                Log.d(TAG, "opted jemalloc arenas.dirty_decay_ms(ssize_t), exit code:" + do_arenas_dirty_decay_ms);
                return new JemallocSettingResult("arenas.dirty_decay_ms(ssize_t)", String.valueOf(do_get_integer_option_value), String.valueOf(i), do_arenas_dirty_decay_ms);
            } catch (NoSuchMethodError e) {
                Log.e(TAG, "NoSuchMethodError", e);
            } catch (UnsatisfiedLinkError e2) {
                Log.e(TAG, "UnsatisfiedLinkError", e2);
            }
        }
        return new JemallocSettingResult("arenas.dirty_decay_ms(ssize_t)", "", String.valueOf(i), -1);
    }

    public static JemallocSettingResult doJemallocArenasMuzzyDecayMs(Context context, int i) {
        if (SysOptimizer.loadOptimizerLibrary(context)) {
            try {
                int do_get_integer_option_value = do_get_integer_option_value("arenas.muzzy_decay_ms");
                int do_arenas_muzzy_decay_ms = do_arenas_muzzy_decay_ms(i);
                Log.d(TAG, "opted jemalloc arenas.muzzy_decay_ms(ssize_t), exit code:" + do_arenas_muzzy_decay_ms);
                return new JemallocSettingResult("arenas.muzzy_decay_ms(ssize_t)", String.valueOf(do_get_integer_option_value), String.valueOf(i), do_arenas_muzzy_decay_ms);
            } catch (NoSuchMethodError e) {
                Log.e(TAG, "NoSuchMethodError", e);
            } catch (UnsatisfiedLinkError e2) {
                Log.e(TAG, "UnsatisfiedLinkError", e2);
            }
        }
        return new JemallocSettingResult("arenas.muzzy_decay_ms(ssize_t)", "", String.valueOf(i), -1);
    }

    public static JemallocSettingResult doJemallocArenaDecayTime(Context context, int i) {
        if (SysOptimizer.loadOptimizerLibrary(context)) {
            try {
                int do_get_integer_option_value = do_get_integer_option_value("arena.0.decay_time");
                int do_arena_decay_time = do_arena_decay_time(i);
                Log.d(TAG, "opted jemalloc arena.<i>.decay_time(ssize_t), exit code:" + do_arena_decay_time);
                return new JemallocSettingResult("arena.<i>.decay_time(ssize_t)", String.valueOf(do_get_integer_option_value), String.valueOf(i), do_arena_decay_time);
            } catch (NoSuchMethodError e) {
                Log.e(TAG, "NoSuchMethodError", e);
            } catch (UnsatisfiedLinkError e2) {
                Log.e(TAG, "UnsatisfiedLinkError", e2);
            }
        }
        return new JemallocSettingResult("arena.<i>.decay_time(ssize_t)", "", String.valueOf(i), -1);
    }

    public static JemallocSettingResult doJemallocArenaDss(Context context, String str) {
        if (SysOptimizer.loadOptimizerLibrary(context)) {
            try {
                String do_get_arena_dss = do_get_arena_dss();
                int do_arena_dss = do_arena_dss(str);
                Log.d(TAG, "opted jemalloc arena.<i>.dss(const char*), exit code" + do_arena_dss);
                return new JemallocSettingResult("arena.<i>.dss(const char*)", do_get_arena_dss, str, do_arena_dss);
            } catch (NoSuchMethodError e) {
                Log.e(TAG, "NoSuchMethodError", e);
            } catch (UnsatisfiedLinkError e2) {
                Log.e(TAG, "UnsatisfiedLinkError", e2);
            }
        }
        return new JemallocSettingResult("arena.<i>.dss(const char*)", "", str, -1);
    }

    public static JemallocSettingResult doJemallocArenaLgDirtyMult(Context context, int i) {
        if (SysOptimizer.loadOptimizerLibrary(context)) {
            try {
                int do_get_integer_option_value = do_get_integer_option_value("arena.0.lg_dirty_mult");
                int do_arena_lg_dirty_mult = do_arena_lg_dirty_mult(i);
                Log.d(TAG, "opted jemalloc arena.<i>.lg_dirty_mult(ssize_t), exit code:" + do_arena_lg_dirty_mult);
                return new JemallocSettingResult("arena.<i>.lg_dirty_mult(ssize_t)", String.valueOf(do_get_integer_option_value), String.valueOf(i), do_arena_lg_dirty_mult);
            } catch (NoSuchMethodError e) {
                Log.e(TAG, "NoSuchMethodError", e);
            } catch (UnsatisfiedLinkError e2) {
                Log.e(TAG, "UnsatisfiedLinkError", e2);
            }
        }
        return new JemallocSettingResult("arena.<i>.lg_dirty_mult(ssize_t)", "", String.valueOf(i), -1);
    }

    public static JemallocSettingResult doJemallocArenaDirtyDecayMs(Context context, int i) {
        if (SysOptimizer.loadOptimizerLibrary(context)) {
            try {
                int do_get_integer_option_value = do_get_integer_option_value("arena.0.dirty_decay_ms");
                int do_arena_dirty_decay_ms = do_arena_dirty_decay_ms(i);
                Log.d(TAG, "opted jemalloc arena.<i>.dirty_decay_ms(ssize_t)" + do_arena_dirty_decay_ms);
                return new JemallocSettingResult("arena.<i>.dirty_decay_ms(ssize_t)", String.valueOf(do_get_integer_option_value), String.valueOf(i), do_arena_dirty_decay_ms);
            } catch (NoSuchMethodError e) {
                Log.e(TAG, "NoSuchMethodError", e);
            } catch (UnsatisfiedLinkError e2) {
                Log.e(TAG, "UnsatisfiedLinkError", e2);
            }
        }
        return new JemallocSettingResult("arena.<i>.dirty_decay_ms(ssize_t)", "", String.valueOf(i), -1);
    }

    public static JemallocSettingResult doJemallocArenaMuzzyDecayMs(Context context, int i) {
        if (SysOptimizer.loadOptimizerLibrary(context)) {
            try {
                int do_get_integer_option_value = do_get_integer_option_value("arena.0.muzzy_decay_ms");
                int do_arena_muzzy_decay_ms = do_arena_muzzy_decay_ms(i);
                Log.d(TAG, "opted jemalloc arena.<i>.muzzy_decay_ms(ssize_t)" + do_arena_muzzy_decay_ms);
                return new JemallocSettingResult("arena.<i>.muzzy_decay_ms(ssize_t)", String.valueOf(do_get_integer_option_value), String.valueOf(i), do_arena_muzzy_decay_ms);
            } catch (NoSuchMethodError e) {
                Log.e(TAG, "NoSuchMethodError", e);
            } catch (UnsatisfiedLinkError e2) {
                Log.e(TAG, "UnsatisfiedLinkError", e2);
            }
        }
        return new JemallocSettingResult("arena.<i>.muzzy_decay_ms(ssize_t)", "", String.valueOf(i), -1);
    }

    public static JemallocSettingResult doJemallocArenaRetainGrowLimit(Context context, int i) {
        if (SysOptimizer.loadOptimizerLibrary(context)) {
            try {
                int do_get_integer_option_value = do_get_integer_option_value("arena.0.retain_grow_limit");
                int do_arena_retain_grow_limit = do_arena_retain_grow_limit(i);
                Log.d(TAG, "opted jemalloc arena.<i>.retain_grow_limit(size_t)" + do_arena_retain_grow_limit);
                return new JemallocSettingResult("arena.<i>.retain_grow_limit(size_t)", String.valueOf(do_get_integer_option_value), String.valueOf(i), do_arena_retain_grow_limit);
            } catch (NoSuchMethodError e) {
                Log.e(TAG, "NoSuchMethodError", e);
            } catch (UnsatisfiedLinkError e2) {
                Log.e(TAG, "UnsatisfiedLinkError", e2);
            }
        }
        return new JemallocSettingResult("arena.<i>.retain_grow_limit(size_t)", "", String.valueOf(i), -1);
    }

    public static JemallocSettingResult doJemallocArenasLgDirtyMult(Context context, int i) {
        if (SysOptimizer.loadOptimizerLibrary(context)) {
            try {
                int do_get_integer_option_value = do_get_integer_option_value("arenas.lg_dirty_mult");
                int do_arenas_lg_dirty_mult = do_arenas_lg_dirty_mult(i);
                Log.d(TAG, "opted jemalloc arenas.lg_dirty_mult(ssize_t)" + do_arenas_lg_dirty_mult);
                return new JemallocSettingResult("arenas.lg_dirty_mult(ssize_t)", String.valueOf(do_get_integer_option_value), String.valueOf(i), do_arenas_lg_dirty_mult);
            } catch (NoSuchMethodError e) {
                Log.e(TAG, "NoSuchMethodError", e);
            } catch (UnsatisfiedLinkError e2) {
                Log.e(TAG, "UnsatisfiedLinkError", e2);
            }
        }
        return new JemallocSettingResult("arenas.lg_dirty_mult(ssize_t)", "", String.valueOf(i), -1);
    }
}
