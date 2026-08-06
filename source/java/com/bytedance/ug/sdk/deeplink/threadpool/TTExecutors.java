package com.bytedance.ug.sdk.deeplink.threadpool;

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
    public static final int AVAILABLE_PROCESSORS;
    public static final int CORE_POOL_SIZE_NORMAL;
    public static final int CPU_COUNT;
    public static final int KEEP_ALIVE_SECONDS = 30;
    public static final int MAXIMUM_POOL_SIZE_NORMAL;
    private static final DefaultThreadFactory S_DEFAULT_THREAD_FACTORY;
    private static final RejectedExecutionHandler S_HANDLER;
    private static final BlockingQueue<Runnable> S_WORK_QUEUE;
    private static ExecutorService sNormalThreadPool;

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
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        S_WORK_QUEUE = linkedBlockingQueue;
        DefaultThreadFactory defaultThreadFactory = new DefaultThreadFactory("TTDefaultExecutors");
        S_DEFAULT_THREAD_FACTORY = defaultThreadFactory;
        RejectedExecutionHandler rejectedExecutionHandler = new RejectedExecutionHandler() { // from class: com.bytedance.ug.sdk.deeplink.threadpool.TTExecutors.1
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                Executors.newCachedThreadPool().execute(runnable);
            }
        };
        S_HANDLER = rejectedExecutionHandler;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(max, i, 30L, TimeUnit.SECONDS, linkedBlockingQueue, defaultThreadFactory, rejectedExecutionHandler);
        sNormalThreadPool = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    private TTExecutors() {
    }

    /* loaded from: classes4.dex */
    private static class DefaultThreadFactory implements ThreadFactory {
        private static final AtomicInteger POOL_NUMBER = new AtomicInteger(1);
        private final ThreadGroup group;
        private final String namePrefix;
        private final AtomicInteger threadNumber = new AtomicInteger(1);

        DefaultThreadFactory(String str) {
            SecurityManager securityManager = System.getSecurityManager();
            this.group = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.namePrefix = str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + POOL_NUMBER.getAndIncrement() + "-Thread-";
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

    public static ExecutorService getNormalThreadPool() {
        return sNormalThreadPool;
    }

    public static void execute(Runnable runnable) {
        if (runnable != null) {
            getNormalThreadPool().submit(runnable);
        }
    }
}
