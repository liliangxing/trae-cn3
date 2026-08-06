package com.bytedance.ug.sdk.share.impl.network.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public class ThreadPlus implements Runnable {
    private static ExecutorService CACHED_EXECUTOR = TTExecutors.getNormalExecutor();
    private static ExecutorService FIXED_EXECUTOR = TTExecutors.getNormalExecutor();
    protected static final AtomicInteger sCount = new AtomicInteger();
    private final boolean mBackground;
    private Runnable runnable;

    public static void shutdown() {
    }

    public ThreadPlus(Runnable runnable, String str, boolean z) {
        this.runnable = runnable;
        this.mBackground = z;
    }

    public ThreadPlus(String str) {
        this(false);
    }

    public ThreadPlus() {
        this(false);
    }

    public ThreadPlus(boolean z) {
        this.mBackground = z;
    }

    public static void setExecutorService(ExecutorService executorService) {
        CACHED_EXECUTOR = executorService;
        FIXED_EXECUTOR = executorService;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable = this.runnable;
        if (runnable != null) {
            runnable.run();
        }
    }

    public void start() {
        if (this.mBackground) {
            FIXED_EXECUTOR.submit(this);
        } else {
            CACHED_EXECUTOR.submit(this);
        }
    }

    public static void submitRunnable(Runnable runnable) {
        if (runnable != null) {
            CACHED_EXECUTOR.submit(runnable);
        }
    }
}
