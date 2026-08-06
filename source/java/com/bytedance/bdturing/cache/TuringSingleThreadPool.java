package com.bytedance.bdturing.cache;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class TuringSingleThreadPool {
    private static final String prefix = "turing_single";
    private static volatile TuringSingleThreadPool sInstance;
    private final ThreadPoolExecutor mExecutor = new ThreadPoolExecutor(1, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.bytedance.bdturing.cache.TuringSingleThreadPool.1
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(TuringSingleThreadPool.prefix);
            thread.setPriority(5);
            return thread;
        }
    }, new ThreadPoolExecutor.DiscardOldestPolicy());

    private TuringSingleThreadPool() {
    }

    public static TuringSingleThreadPool getInstance() {
        if (sInstance == null) {
            synchronized (TuringSingleThreadPool.class) {
                if (sInstance == null) {
                    sInstance = new TuringSingleThreadPool();
                }
            }
        }
        return sInstance;
    }

    public void execute(Runnable runnable) {
        ThreadPoolExecutor threadPoolExecutor;
        if (runnable == null || (threadPoolExecutor = this.mExecutor) == null) {
            return;
        }
        threadPoolExecutor.execute(runnable);
    }
}
