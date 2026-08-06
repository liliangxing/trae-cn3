package com.bytedance.trae.init;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LaunchBoostExecutor.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0002\b\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/init/LaunchBoostExecutor;", "", "<init>", "()V", "threadFactory", "Ljava/util/concurrent/ThreadFactory;", "CPU_COUNT", "", "CORE_POOL_SIZE", "MAXIMUM_POOL_SIZE", "KEEP_ALIVE", "", "EXECUTORS", "Ljava/util/concurrent/ThreadPoolExecutor;", "executors", "executors$app_mainlandRelease", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LaunchBoostExecutor {
    public static final int $stable;
    private static final int CORE_POOL_SIZE;
    private static final int CPU_COUNT;
    private static final ThreadPoolExecutor EXECUTORS;
    public static final LaunchBoostExecutor INSTANCE = new LaunchBoostExecutor();
    private static final long KEEP_ALIVE = 5;
    private static final int MAXIMUM_POOL_SIZE;
    private static final ThreadFactory threadFactory;

    private LaunchBoostExecutor() {
    }

    static {
        ThreadFactory threadFactory2 = new ThreadFactory() { // from class: com.bytedance.trae.init.LaunchBoostExecutor$threadFactory$1
            private final AtomicInteger threadNumber = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable r) {
                Intrinsics.checkNotNullParameter(r, "r");
                return new Thread(new ThreadGroup("flow_a"), r, "flow_a_launch" + this.threadNumber.getAndIncrement(), 0L);
            }
        };
        threadFactory = threadFactory2;
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = availableProcessors;
        int i = availableProcessors + 1;
        CORE_POOL_SIZE = i;
        int i2 = (availableProcessors * 2) + 1;
        MAXIMUM_POOL_SIZE = i2;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i2, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactory2);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        EXECUTORS = threadPoolExecutor;
        $stable = 8;
    }

    public final ThreadPoolExecutor executors$app_mainlandRelease() {
        return EXECUTORS;
    }
}
