package com.bytedance.webx.seclink.util;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* loaded from: classes6.dex */
public class SecLinkTaskExecutor {
    private static volatile SecLinkTaskExecutor instance;
    private ExecutorService mExecutorService;

    private SecLinkTaskExecutor() {
    }

    public static SecLinkTaskExecutor getInstance() {
        if (instance == null) {
            synchronized (SecLinkTaskExecutor.class) {
                if (instance == null) {
                    instance = new SecLinkTaskExecutor();
                }
            }
        }
        return instance;
    }

    public void setExecutor(ExecutorService executorService) {
        this.mExecutorService = executorService;
    }

    public void execute(Runnable runnable) {
        if (this.mExecutorService == null) {
            this.mExecutorService = Executors.newCachedThreadPool();
        }
        this.mExecutorService.execute(runnable);
    }

    public Future submit(Callable callable) {
        if (this.mExecutorService == null) {
            this.mExecutorService = Executors.newCachedThreadPool();
        }
        return this.mExecutorService.submit(callable);
    }

    public Future<?> submit(Runnable runnable) {
        if (this.mExecutorService == null) {
            this.mExecutorService = Executors.newCachedThreadPool();
        }
        return this.mExecutorService.submit(runnable);
    }
}
