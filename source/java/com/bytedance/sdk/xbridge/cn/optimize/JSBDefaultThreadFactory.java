package com.bytedance.sdk.xbridge.cn.optimize;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OptimizeConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/optimize/JSBDefaultThreadFactory;", "Ljava/util/concurrent/ThreadFactory;", "factoryTag", "", "(Ljava/lang/String;)V", "threadGroup", "Ljava/lang/ThreadGroup;", "threadNamePre", "threadNumber", "Ljava/util/concurrent/atomic/AtomicInteger;", "newThread", "Ljava/lang/Thread;", "runnable", "Ljava/lang/Runnable;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final class JSBDefaultThreadFactory implements ThreadFactory {
    private static final AtomicInteger POOL_NUMBER = new AtomicInteger(1);
    private ThreadGroup threadGroup;
    private final String threadNamePre;
    private final AtomicInteger threadNumber;

    public JSBDefaultThreadFactory(String factoryTag) {
        ThreadGroup threadGroup;
        Intrinsics.checkNotNullParameter(factoryTag, "factoryTag");
        this.threadNumber = new AtomicInteger(1);
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            threadGroup = securityManager.getThreadGroup();
        } else {
            threadGroup = Thread.currentThread().getThreadGroup();
        }
        this.threadGroup = threadGroup;
        this.threadNamePre = factoryTag + '-' + POOL_NUMBER.getAndIncrement() + "-Thread-";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        Thread thread = new Thread(this.threadGroup, runnable, this.threadNamePre + this.threadNumber.getAndIncrement(), 0L);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (thread.getPriority() != 5) {
            thread.setPriority(5);
        }
        return thread;
    }
}
