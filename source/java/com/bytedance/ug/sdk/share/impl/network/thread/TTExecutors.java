package com.bytedance.ug.sdk.share.impl.network.thread;

import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public class TTExecutors {
    public static final int AVAILABLEPROCESSORS;
    public static final int CORE_POOL_SIZE_CPU;
    public static final int CORE_POOL_SIZE_NORMAL;
    public static final int CORE_POOL_SIZE_SCHEDULED = 3;
    public static final int CPU_COUNT;
    public static final int DOWNLOAD_THREAD_COUNT = 2;
    public static final int KEEP_ALIVE_SECONDS = 30;
    public static final int MAXIMUM_POOL_SIZE_CPU;
    public static final int MAXIMUM_POOL_SIZE_NORMAL;
    private static ExecutorService sCPUThreadPool;
    private static final DefaultThreadFactory sCpuThreadFactory;
    private static final DefaultThreadFactory sDefaultThreadFactory;
    private static final DefaultThreadFactory sDownLoadThreadFactory;
    private static ExecutorService sDownLoadThreadPool;
    private static final RejectedExecutionHandler sHandler;
    private static ExecutorService sNormalThreadPool;
    private static final BlockingQueue<Runnable> sPoolWorkQueue;
    private static final BlockingQueue<Runnable> sPoolWorkQueue_Cpu;
    private static final BlockingQueue<Runnable> sPoolWorkQueue_Download;
    private static final DefaultThreadFactory sScheduledThreadFactory;
    private static ScheduledExecutorService sScheduledThreadPool;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        AVAILABLEPROCESSORS = availableProcessors;
        if (availableProcessors <= 0) {
            availableProcessors = 1;
        }
        CPU_COUNT = availableProcessors;
        int max = Math.max(2, Math.min(availableProcessors - 1, 6)) * 2;
        CORE_POOL_SIZE_NORMAL = max;
        int i = (max * 2) + 1;
        MAXIMUM_POOL_SIZE_NORMAL = i;
        int max2 = Math.max(2, Math.min(availableProcessors - 1, 3));
        CORE_POOL_SIZE_CPU = max2;
        int i2 = (availableProcessors * 2) + 1;
        MAXIMUM_POOL_SIZE_CPU = i2;
        DefaultThreadFactory defaultThreadFactory = new DefaultThreadFactory("TTDefaultExecutors");
        sDefaultThreadFactory = defaultThreadFactory;
        DefaultThreadFactory defaultThreadFactory2 = new DefaultThreadFactory("TTCpuExecutors");
        sCpuThreadFactory = defaultThreadFactory2;
        DefaultThreadFactory defaultThreadFactory3 = new DefaultThreadFactory("TTScheduledExecutors");
        sScheduledThreadFactory = defaultThreadFactory3;
        DefaultThreadFactory defaultThreadFactory4 = new DefaultThreadFactory("TTDownLoadExecutors");
        sDownLoadThreadFactory = defaultThreadFactory4;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        sPoolWorkQueue = linkedBlockingQueue;
        LinkedBlockingQueue linkedBlockingQueue2 = new LinkedBlockingQueue();
        sPoolWorkQueue_Cpu = linkedBlockingQueue2;
        LinkedBlockingQueue linkedBlockingQueue3 = new LinkedBlockingQueue();
        sPoolWorkQueue_Download = linkedBlockingQueue3;
        RejectedExecutionHandler rejectedExecutionHandler = new RejectedExecutionHandler() { // from class: com.bytedance.ug.sdk.share.impl.network.thread.TTExecutors.1
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                Executors.newCachedThreadPool().execute(runnable);
            }
        };
        sHandler = rejectedExecutionHandler;
        TTThreadPoolExecutor tTThreadPoolExecutor = new TTThreadPoolExecutor(max, i, 30L, TimeUnit.SECONDS, linkedBlockingQueue, defaultThreadFactory, rejectedExecutionHandler);
        sNormalThreadPool = tTThreadPoolExecutor;
        tTThreadPoolExecutor.allowCoreThreadTimeOut(true);
        TTThreadPoolExecutor tTThreadPoolExecutor2 = new TTThreadPoolExecutor(max2, i2, 30L, TimeUnit.SECONDS, linkedBlockingQueue2, defaultThreadFactory2, rejectedExecutionHandler);
        sCPUThreadPool = tTThreadPoolExecutor2;
        tTThreadPoolExecutor2.allowCoreThreadTimeOut(true);
        sScheduledThreadPool = Executors.newScheduledThreadPool(3, defaultThreadFactory3);
        TTThreadPoolExecutor tTThreadPoolExecutor3 = new TTThreadPoolExecutor(2, 2, 30L, TimeUnit.SECONDS, linkedBlockingQueue3, defaultThreadFactory4, rejectedExecutionHandler);
        sDownLoadThreadPool = tTThreadPoolExecutor3;
        tTThreadPoolExecutor3.allowCoreThreadTimeOut(true);
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

    public static ExecutorService getDownLoadThreadPool() {
        return sDownLoadThreadPool;
    }

    public static ScheduledExecutorService getScheduledThreadPool() {
        return sScheduledThreadPool;
    }

    public static ExecutorService getCPUThreadPool() {
        return sCPUThreadPool;
    }

    public static void setNormalThreadPool(ExecutorService executorService) {
        sNormalThreadPool = executorService;
    }
}
