package com.ss.ttm.player;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes7.dex */
public final class AVThreadPool {
    private static ThreadPoolExecutor mExecutorInstance;
    private static volatile ExecutorService mExtExecutorInstance;

    public static synchronized void setExecutorInstance(ExecutorService executor) {
        synchronized (AVThreadPool.class) {
            mExtExecutorInstance = executor;
        }
    }

    private static synchronized ExecutorService getExecutorInstance() {
        ExecutorService executorService;
        synchronized (AVThreadPool.class) {
            if (mExtExecutorInstance != null) {
                executorService = mExtExecutorInstance;
            } else {
                if (mExecutorInstance == null) {
                    mExecutorInstance = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue());
                }
                executorService = mExecutorInstance;
            }
        }
        return executorService;
    }

    public static synchronized void addTask(Runnable runnable) {
        synchronized (AVThreadPool.class) {
            getExecutorInstance().submit(runnable);
        }
    }

    public static synchronized Future<String> addTask(Callable<String> callable) {
        Future<String> submit;
        synchronized (AVThreadPool.class) {
            submit = getExecutorInstance().submit(callable);
        }
        return submit;
    }
}
