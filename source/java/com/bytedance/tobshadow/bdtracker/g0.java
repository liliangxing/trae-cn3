package com.bytedance.tobshadow.bdtracker;

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

/* loaded from: classes5.dex */
public class g0 {
    public static ExecutorService a;
    public static final int b;
    public static final int c;
    public static final int d;
    public static final int e;
    public static final BlockingQueue<Runnable> f;
    public static final b g;
    public static final RejectedExecutionHandler h;

    /* loaded from: classes5.dex */
    public static class a implements RejectedExecutionHandler {
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            Executors.newCachedThreadPool().execute(runnable);
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements ThreadFactory {
        public static final AtomicInteger d = new AtomicInteger(1);
        public final ThreadGroup a;
        public final AtomicInteger b = new AtomicInteger(1);
        public final String c;

        public b(String str) {
            SecurityManager securityManager = System.getSecurityManager();
            this.a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.c = str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + d.getAndIncrement() + "-Thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.a, runnable, this.c + this.b.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        b = availableProcessors;
        if (availableProcessors <= 0) {
            availableProcessors = 1;
        }
        c = availableProcessors;
        int max = Math.max(2, Math.min(availableProcessors - 1, 6)) * 2;
        d = max;
        int i = (max * 2) + 1;
        e = i;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        f = linkedBlockingQueue;
        b bVar = new b("TTDefaultExecutors");
        g = bVar;
        a aVar = new a();
        h = aVar;
        h0 h0Var = new h0(max, i, 30L, TimeUnit.SECONDS, linkedBlockingQueue, bVar, aVar);
        a = h0Var;
        h0Var.allowCoreThreadTimeOut(true);
    }
}
