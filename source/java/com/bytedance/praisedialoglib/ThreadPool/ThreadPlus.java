package com.bytedance.praisedialoglib.ThreadPool;

import java.util.concurrent.ExecutorService;

/* loaded from: classes4.dex */
public class ThreadPlus {
    private static ExecutorService CACHED_EXECUTOR = TTExecutors.getNormalExecutor();

    public static void submitRunnable(Runnable runnable) {
        if (runnable != null) {
            CACHED_EXECUTOR.submit(runnable);
        }
    }
}
