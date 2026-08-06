package com.bytedance.platform.thread;

import android.text.TextUtils;
import com.bytedance.platform.thread.monitor.ThreadMonitor;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class PlatformThreadPool {
    private static final int AVAILABLE_PROCESSORS;
    private static final int CPU_COUNT;
    private static final String PLATFORM_BACKGROUND_THREAD_POOL = "platform-background";
    private static final String PLATFORM_DEFAULT_THREAD_POOL = "platform-default";
    private static final String PLATFORM_FIXED_THREAD_POOL = "platform-fixed";
    private static final String PLATFORM_IO_THREAD_POOL = "platform-io";
    private static final String PLATFORM_SCHEDULE_THREAD_POOL = "platform-schedule";
    private static final String PLATFORM_SINGLE_THREAD_POOL = "platform-single";
    private static final String TAG = "PlatformExecutor";
    private static volatile ThreadPoolExecutor sBackgroundThreadPool;
    private static volatile ThreadPoolExecutor sDefaultThreadPool;
    private static volatile ThreadPoolExecutor sFixedThreadPool;
    private static volatile ThreadPoolExecutor sIOThreadPool;
    private static Builder sPoolBuilder;
    private static final RejectedExecutionHandler sRejectHandler;
    private static RejectedCallback sRejectedCallback;
    private static volatile ScheduledThreadPoolExecutor sScheduleThreadPool;
    private static volatile ThreadPoolExecutor sSingleThreadPool;
    private static UncaughtThrowableStrategy sThrowableCallback;
    private static UncaughtThrowableStrategy sThrowableStrategy;

    /* loaded from: classes4.dex */
    public interface RejectedCallback {
        void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor, String str);
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        AVAILABLE_PROCESSORS = availableProcessors;
        if (availableProcessors <= 0) {
            availableProcessors = 1;
        }
        CPU_COUNT = availableProcessors;
        sRejectHandler = new RejectedExecutionHandler() { // from class: com.bytedance.platform.thread.PlatformThreadPool.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                if (PlatformThreadPool.sRejectedCallback != null) {
                    PlatformThreadPool.sRejectedCallback.rejectedExecution(runnable, threadPoolExecutor, ((IPoolName) threadPoolExecutor).getName());
                }
                PlatformThreadPool.sFixedThreadPool.execute(runnable);
            }
        };
        sThrowableStrategy = new UncaughtThrowableStrategy() { // from class: com.bytedance.platform.thread.PlatformThreadPool.2
            @Override // com.bytedance.platform.thread.UncaughtThrowableStrategy
            public void handle(Throwable th) {
                if (PlatformThreadPool.sThrowableCallback != null) {
                    PlatformThreadPool.sThrowableCallback.handle(th);
                }
            }
        };
    }

    private PlatformThreadPool() {
    }

    public static void setRejectedCallback(RejectedCallback rejectedCallback) {
        sRejectedCallback = rejectedCallback;
    }

    public static void setThreadPoolException(UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        sThrowableCallback = uncaughtThrowableStrategy;
    }

    public static void setMonitor(ThreadMonitor.IMonitor iMonitor) {
        ThreadMonitor.setMonitorImpl(iMonitor);
    }

    public static void init() {
        init(null);
    }

    public static void init(Builder builder) {
        sPoolBuilder = builder;
    }

    public static ThreadPoolExecutor getIOThreadPool() {
        if (sIOThreadPool == null) {
            synchronized (PlatformThreadPool.class) {
                if (sIOThreadPool == null) {
                    Builder builder = sPoolBuilder;
                    if (builder != null && builder.getIOOptions() != null) {
                        sIOThreadPool = new PlatformPoolExecutor(sPoolBuilder.getIOOptions().coreCount, sPoolBuilder.getIOOptions().maxCount, sPoolBuilder.getIOOptions().keepAliveTime, sPoolBuilder.getIOOptions().unit, new SynchronousQueue(), new DefaultThreadFactory(PLATFORM_IO_THREAD_POOL, sThrowableStrategy), sRejectHandler, PLATFORM_IO_THREAD_POOL);
                    } else {
                        sIOThreadPool = new PlatformPoolExecutor(0, 128, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new DefaultThreadFactory(PLATFORM_IO_THREAD_POOL, sThrowableStrategy), sRejectHandler, PLATFORM_IO_THREAD_POOL);
                    }
                }
            }
        }
        return sIOThreadPool;
    }

    public static ThreadPoolExecutor getDefaultThreadPool() {
        if (sDefaultThreadPool == null) {
            synchronized (PlatformThreadPool.class) {
                if (sDefaultThreadPool == null) {
                    Builder builder = sPoolBuilder;
                    if (builder != null && builder.getDefaultOptions() != null) {
                        sDefaultThreadPool = new PlatformPoolExecutor(sPoolBuilder.getDefaultOptions().coreCount, sPoolBuilder.getDefaultOptions().maxCount, sPoolBuilder.getDefaultOptions().keepAliveTime, sPoolBuilder.getDefaultOptions().unit, sPoolBuilder.getDefaultOptions().workQueue, new DefaultThreadFactory(PLATFORM_DEFAULT_THREAD_POOL, sThrowableStrategy), sRejectHandler, PLATFORM_DEFAULT_THREAD_POOL);
                        sDefaultThreadPool.allowCoreThreadTimeOut(sPoolBuilder.getDefaultOptions().allowCoreThreadTimeOut);
                    } else {
                        int i = CPU_COUNT;
                        sDefaultThreadPool = new PlatformPoolExecutor(Math.min(i, 4), (i * 2) + 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(256), new DefaultThreadFactory(PLATFORM_DEFAULT_THREAD_POOL, sThrowableStrategy), sRejectHandler, PLATFORM_DEFAULT_THREAD_POOL);
                        sDefaultThreadPool.allowCoreThreadTimeOut(true);
                    }
                }
            }
        }
        return sDefaultThreadPool;
    }

    public static ThreadPoolExecutor getBackgroundThreadPool() {
        if (sBackgroundThreadPool == null) {
            synchronized (PlatformThreadPool.class) {
                if (sBackgroundThreadPool == null) {
                    Builder builder = sPoolBuilder;
                    if (builder != null && builder.getBackgroundOptions() != null) {
                        sBackgroundThreadPool = new PlatformPoolExecutor(sPoolBuilder.getBackgroundOptions().coreCount, sPoolBuilder.getBackgroundOptions().maxCount, sPoolBuilder.getBackgroundOptions().keepAliveTime, sPoolBuilder.getBackgroundOptions().unit, sPoolBuilder.getBackgroundOptions().workQueue, new BackgroundThreadFactory(PLATFORM_BACKGROUND_THREAD_POOL, sThrowableStrategy), sRejectHandler, PLATFORM_BACKGROUND_THREAD_POOL);
                        sBackgroundThreadPool.allowCoreThreadTimeOut(sPoolBuilder.getBackgroundOptions().allowCoreThreadTimeOut);
                    } else {
                        sBackgroundThreadPool = new PlatformPoolExecutor(0, 3, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(256), new BackgroundThreadFactory(PLATFORM_BACKGROUND_THREAD_POOL, sThrowableStrategy), sRejectHandler, PLATFORM_BACKGROUND_THREAD_POOL);
                        sBackgroundThreadPool.allowCoreThreadTimeOut(true);
                    }
                }
            }
        }
        return sBackgroundThreadPool;
    }

    public static ScheduledExecutorService getScheduleThreadPool() {
        if (sScheduleThreadPool == null) {
            synchronized (PlatformThreadPool.class) {
                if (sScheduleThreadPool == null) {
                    Builder builder = sPoolBuilder;
                    if (builder != null && builder.getScheduleOptions() != null) {
                        sScheduleThreadPool = new PlatformScheduleExecutor(sPoolBuilder.getScheduleOptions().coreCount, new DefaultThreadFactory(PLATFORM_SCHEDULE_THREAD_POOL, sThrowableStrategy), PLATFORM_SCHEDULE_THREAD_POOL);
                        try {
                            sScheduleThreadPool.allowCoreThreadTimeOut(sPoolBuilder.getScheduleOptions().allowCoreThreadTimeOut);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        sScheduleThreadPool = new PlatformScheduleExecutor(1, new DefaultThreadFactory(PLATFORM_SCHEDULE_THREAD_POOL, sThrowableStrategy), PLATFORM_SCHEDULE_THREAD_POOL);
                        try {
                            sScheduleThreadPool.allowCoreThreadTimeOut(true);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        }
        return sScheduleThreadPool;
    }

    public static ThreadPoolExecutor getSingleThreadPool() {
        if (sSingleThreadPool == null) {
            synchronized (PlatformThreadPool.class) {
                if (sSingleThreadPool == null) {
                    Builder builder = sPoolBuilder;
                    if (builder != null && builder.getSingleOptions() != null) {
                        sSingleThreadPool = new PlatformPoolExecutor(1, 1, sPoolBuilder.getSingleOptions().keepAliveTime, sPoolBuilder.getSingleOptions().unit, new LinkedBlockingQueue(), new DefaultThreadFactory(PLATFORM_SINGLE_THREAD_POOL, sThrowableStrategy), PLATFORM_SINGLE_THREAD_POOL);
                        sSingleThreadPool.allowCoreThreadTimeOut(sPoolBuilder.getSingleOptions().allowCoreThreadTimeOut);
                    } else {
                        sSingleThreadPool = new PlatformPoolExecutor(1, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory(PLATFORM_SINGLE_THREAD_POOL, sThrowableStrategy), PLATFORM_SINGLE_THREAD_POOL);
                        sSingleThreadPool.allowCoreThreadTimeOut(true);
                    }
                }
            }
        }
        return sSingleThreadPool;
    }

    public static ThreadPoolExecutor getFixedThreadPool() {
        if (sFixedThreadPool == null) {
            synchronized (PlatformThreadPool.class) {
                if (sFixedThreadPool == null) {
                    Builder builder = sPoolBuilder;
                    if (builder != null && builder.getFixedOptions() != null) {
                        sFixedThreadPool = new PlatformPoolExecutor(sPoolBuilder.getFixedOptions().coreCount, sPoolBuilder.getFixedOptions().coreCount, sPoolBuilder.getFixedOptions().keepAliveTime, sPoolBuilder.getFixedOptions().unit, new LinkedBlockingQueue(), new DefaultThreadFactory(PLATFORM_FIXED_THREAD_POOL, sThrowableStrategy), PLATFORM_FIXED_THREAD_POOL);
                        sFixedThreadPool.allowCoreThreadTimeOut(sPoolBuilder.getFixedOptions().allowCoreThreadTimeOut);
                    } else {
                        int i = CPU_COUNT;
                        sFixedThreadPool = new PlatformPoolExecutor(i, i, 30L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory(PLATFORM_FIXED_THREAD_POOL, sThrowableStrategy), PLATFORM_FIXED_THREAD_POOL);
                        sFixedThreadPool.allowCoreThreadTimeOut(true);
                    }
                }
            }
        }
        return sFixedThreadPool;
    }

    public static ExecutorService createThreadPool(Options options) {
        if (options.type == ThreadPoolType.IO || options.type == ThreadPoolType.DEFAULT) {
            throw new IllegalArgumentException("not allow create pool type = " + options.type);
        }
        if (options.type == ThreadPoolType.SINGLE) {
            return new PlatformPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, (BlockingQueue<Runnable>) options.workQueue, options.factory, options.name);
        }
        if (options.type == ThreadPoolType.SCHEDULED) {
            return new PlatformScheduleExecutor(options.coreCount, options.factory, options.handler, options.name);
        }
        return new PlatformPoolExecutor(options.coreCount, options.maxCount, options.keepAliveTime, TimeUnit.MILLISECONDS, options.workQueue, options.factory, options.handler, options.name);
    }

    /* loaded from: classes4.dex */
    public static class Options {
        private boolean allowCoreThreadTimeOut;
        private int coreCount;
        private ThreadFactory factory;
        private RejectedExecutionHandler handler;
        private long keepAliveTime;
        private int maxCount;
        private String name;
        private ThreadPoolType type;
        private TimeUnit unit;
        private BlockingQueue<Runnable> workQueue;

        private Options() {
            this.workQueue = new LinkedBlockingQueue();
            this.handler = PlatformThreadPool.sRejectHandler;
            this.keepAliveTime = 15000L;
            this.factory = new BackgroundThreadFactory(this.name);
            this.coreCount = 3;
            this.maxCount = 3;
            this.unit = TimeUnit.SECONDS;
            this.allowCoreThreadTimeOut = true;
        }

        private Options(ThreadPoolType threadPoolType, String str) {
            this.type = threadPoolType;
            this.name = str;
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("thread pool need a name");
            }
            this.workQueue = new LinkedBlockingQueue();
            this.handler = PlatformThreadPool.sRejectHandler;
            this.keepAliveTime = 15000L;
            this.factory = new BackgroundThreadFactory(str);
            this.coreCount = 3;
            this.maxCount = 3;
            this.unit = TimeUnit.SECONDS;
            this.allowCoreThreadTimeOut = true;
        }

        public static Options builderPlatformPool() {
            return new Options();
        }

        public static Options builder(ThreadPoolType threadPoolType, String str) {
            return new Options(threadPoolType, str);
        }

        public Options setCoreThreadCount(int i) {
            this.coreCount = i;
            return this;
        }

        public Options setMaxThreadCount(int i) {
            this.maxCount = i;
            return this;
        }

        public Options setWorkQueue(BlockingQueue<Runnable> blockingQueue) {
            this.workQueue = blockingQueue;
            return this;
        }

        public Options setHandler(RejectedExecutionHandler rejectedExecutionHandler) {
            this.handler = rejectedExecutionHandler;
            return this;
        }

        public Options setKeepAliveTime(long j) {
            this.keepAliveTime = j;
            return this;
        }

        public Options setFactory(ThreadFactory threadFactory) {
            this.factory = threadFactory;
            return this;
        }

        public Options setUnit(TimeUnit timeUnit) {
            this.unit = timeUnit;
            return this;
        }

        public Options setAllowCoreThreadTimeOut(boolean z) {
            this.allowCoreThreadTimeOut = z;
            return this;
        }
    }
}
