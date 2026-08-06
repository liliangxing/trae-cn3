package com.bytedance.security.android.aopcheck.utils;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public class ThreadPool {
    private static volatile ThreadPoolExecutor sDefaultThreadPool;

    public static ThreadPoolExecutor getDefaultThreadPool() {
        if (sDefaultThreadPool == null) {
            synchronized (ThreadPool.class) {
                if (sDefaultThreadPool == null) {
                    sDefaultThreadPool = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors() + 1, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(10), new ThreadFactory() { // from class: com.bytedance.security.android.aopcheck.utils.ThreadPool.1
                        @Override // java.util.concurrent.ThreadFactory
                        public Thread newThread(Runnable runnable) {
                            Thread thread = new Thread(runnable);
                            thread.setName("Mobius_thread");
                            thread.setPriority(5);
                            return thread;
                        }
                    });
                    sDefaultThreadPool.allowCoreThreadTimeOut(true);
                }
            }
        }
        return sDefaultThreadPool;
    }
}
