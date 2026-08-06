package com.bytedance.applog.concurrent;

import com.bytedance.applog.log.AbsSingleton;
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

/* loaded from: classes3.dex */
public class AppLogExecutors {
    public static final int AVAILABLE_PROCESSORS;
    public static final int CORE_POOL_SIZE_NORMAL;
    public static final int CPU_COUNT;
    public static final int KEEP_ALIVE_SECONDS = 30;
    public static final int MAXIMUM_POOL_SIZE_NORMAL;
    private static final DefaultThreadFactory S_DEFAULT_THREAD_FACTORY;
    private static final RejectedExecutionHandler S_HANDLER;
    private static final BlockingQueue<Runnable> S_POOL_WORK_QUEUE;
    private static final AbsSingleton<AppLogThreadPoolExecutor> normal;
    private static final AbsSingleton<AppLogThreadPoolExecutor> single;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        AVAILABLE_PROCESSORS = availableProcessors;
        if (availableProcessors <= 0) {
            availableProcessors = 1;
        }
        CPU_COUNT = availableProcessors;
        int max = Math.max(2, Math.min(availableProcessors - 1, 6)) * 2;
        CORE_POOL_SIZE_NORMAL = max;
        MAXIMUM_POOL_SIZE_NORMAL = (max * 2) + 1;
        S_POOL_WORK_QUEUE = new LinkedBlockingQueue();
        S_DEFAULT_THREAD_FACTORY = new DefaultThreadFactory("AppLogDefaultExecutors");
        S_HANDLER = new RejectedExecutionHandler() { // from class: com.bytedance.applog.concurrent.AppLogExecutors.1
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                Executors.newCachedThreadPool().execute(runnable);
            }
        };
        normal = new AbsSingleton<AppLogThreadPoolExecutor>() { // from class: com.bytedance.applog.concurrent.AppLogExecutors.2
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bytedance.applog.log.AbsSingleton
            public AppLogThreadPoolExecutor create(Object... objArr) {
                AppLogThreadPoolExecutor appLogThreadPoolExecutor = new AppLogThreadPoolExecutor(AppLogExecutors.CORE_POOL_SIZE_NORMAL, AppLogExecutors.MAXIMUM_POOL_SIZE_NORMAL, 30L, TimeUnit.SECONDS, AppLogExecutors.S_POOL_WORK_QUEUE, AppLogExecutors.S_DEFAULT_THREAD_FACTORY, AppLogExecutors.S_HANDLER);
                appLogThreadPoolExecutor.allowCoreThreadTimeOut(true);
                return appLogThreadPoolExecutor;
            }
        };
        single = new AbsSingleton<AppLogThreadPoolExecutor>() { // from class: com.bytedance.applog.concurrent.AppLogExecutors.3
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bytedance.applog.log.AbsSingleton
            public AppLogThreadPoolExecutor create(Object... objArr) {
                AppLogThreadPoolExecutor appLogThreadPoolExecutor = new AppLogThreadPoolExecutor(1, AppLogExecutors.MAXIMUM_POOL_SIZE_NORMAL, 1L, TimeUnit.SECONDS, AppLogExecutors.S_POOL_WORK_QUEUE, AppLogExecutors.S_DEFAULT_THREAD_FACTORY, AppLogExecutors.S_HANDLER);
                appLogThreadPoolExecutor.allowCoreThreadTimeOut(true);
                return appLogThreadPoolExecutor;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class DefaultThreadFactory implements ThreadFactory {
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

    public static ExecutorService getNormalExecutor() {
        return normal.get(new Object[0]);
    }

    public static ExecutorService getSingleExecutor() {
        return single.get(new Object[0]);
    }
}
