package com.bytedance.bdturing.cache;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class TuringThreadPool {
    private static final int CORE_SIZE = 2;
    private static final int MAX_SIZE = 3;
    private static final String prefix = "turing";
    private static volatile TuringThreadPool sInstance;
    private final ThreadPoolExecutor mExecutor = new ThreadPoolExecutor(2, 3, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(50), new ThreadFactory() { // from class: com.bytedance.bdturing.cache.TuringThreadPool.1
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(TuringThreadPool.prefix);
            thread.setPriority(5);
            return thread;
        }
    }, new ThreadPoolExecutor.DiscardOldestPolicy());

    private TuringThreadPool() {
    }

    public static TuringThreadPool getInstance() {
        if (sInstance == null) {
            synchronized (TuringThreadPool.class) {
                if (sInstance == null) {
                    sInstance = new TuringThreadPool();
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
