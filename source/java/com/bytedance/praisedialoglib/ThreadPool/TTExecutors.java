package com.bytedance.praisedialoglib.ThreadPool;

import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public class TTExecutors {
    private static final int AVAILABLE_PROCESSORS;
    private static final int CORE_POOL_SIZE_NORMAL;
    private static final int CPU_COUNT;
    private static final int KEEP_ALIVE_SECONDS = 30;
    private static final int MAXIMUM_POOL_SIZE_NORMAL;
    private static final DefaultThreadFactory sDefaultThreadFactory;
    private static final RejectedExecutionHandler sHandler;
    private static ExecutorService sNormalThreadPool;
    private static final BlockingQueue<Runnable> sPoolWorkQueue;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        AVAILABLE_PROCESSORS = availableProcessors;
        if (availableProcessors <= 0) {
            availableProcessors = 1;
        }
        CPU_COUNT = availableProcessors;
        int max = Math.max(2, Math.min(availableProcessors - 1, 6)) * 2;
        CORE_POOL_SIZE_NORMAL = max;
        int i = (max * 2) + 1;
        MAXIMUM_POOL_SIZE_NORMAL = i;
        DefaultThreadFactory defaultThreadFactory = new DefaultThreadFactory("TTDefaultExecutors");
        sDefaultThreadFactory = defaultThreadFactory;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        sPoolWorkQueue = linkedBlockingQueue;
        RejectedExecutionHandler rejectedExecutionHandler = new RejectedExecutionHandler() { // from class: com.bytedance.praisedialoglib.ThreadPool.TTExecutors.1
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                Executors.newCachedThreadPool().execute(runnable);
            }
        };
        sHandler = rejectedExecutionHandler;
        TTThreadPoolExecutor tTThreadPoolExecutor = new TTThreadPoolExecutor(max, i, 30L, TimeUnit.SECONDS, linkedBlockingQueue, defaultThreadFactory, rejectedExecutionHandler);
        sNormalThreadPool = tTThreadPoolExecutor;
        tTThreadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    /* loaded from: classes4.dex */
    private static class DefaultThreadFactory implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final String namePrefix;
        private final AtomicInteger threadNumber = new AtomicInteger(1);

        DefaultThreadFactory(String str) {
            ThreadGroup threadGroup;
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                threadGroup = securityManager.getThreadGroup();
            } else {
                threadGroup = Thread.currentThread().getThreadGroup();
            }
            this.group = threadGroup;
            this.namePrefix = str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + poolNumber.getAndIncrement() + "-Thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.group, runnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    public static ExecutorService getNormalExecutor() {
        return sNormalThreadPool;
    }
}
