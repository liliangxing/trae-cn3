package com.bytedance.tobshadow.bdtracker;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.bytedance.tobshadow.bdtracker.g0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0426g0 {

    /* renamed from: a */
    public static ExecutorService f610a;

    /* renamed from: b */
    public static final int f611b;

    /* renamed from: c */
    public static final int f612c;

    /* renamed from: d */
    public static final int f613d;

    /* renamed from: e */
    public static final int f614e;

    /* renamed from: f */
    public static final BlockingQueue<Runnable> f615f;

    /* renamed from: g */
    public static final b f616g;

    /* renamed from: h */
    public static final RejectedExecutionHandler f617h;

    /* renamed from: com.bytedance.tobshadow.bdtracker.g0$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class a implements RejectedExecutionHandler {
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            Executors.newCachedThreadPool().execute(runnable);
        }
    }

    /* renamed from: com.bytedance.tobshadow.bdtracker.g0$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class b implements ThreadFactory {

        /* renamed from: d */
        public static final AtomicInteger f618d = new AtomicInteger(1);

        /* renamed from: a */
        public final ThreadGroup f619a;

        /* renamed from: b */
        public final AtomicInteger f620b = new AtomicInteger(1);

        /* renamed from: c */
        public final String f621c;

        public b(String str) {
            SecurityManager securityManager = System.getSecurityManager();
            this.f619a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.f621c = str + "-" + f618d.getAndIncrement() + "-Thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.f619a, runnable, this.f621c + this.f620b.getAndIncrement(), 0L);
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
        f611b = availableProcessors;
        if (availableProcessors <= 0) {
            availableProcessors = 1;
        }
        f612c = availableProcessors;
        int max = Math.max(2, Math.min(availableProcessors - 1, 6)) * 2;
        f613d = max;
        int i = (max * 2) + 1;
        f614e = i;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        f615f = linkedBlockingQueue;
        b bVar = new b("TTDefaultExecutors");
        f616g = bVar;
        a aVar = new a();
        f617h = aVar;
        C0433h0 c0433h0 = new C0433h0(max, i, 30L, TimeUnit.SECONDS, linkedBlockingQueue, bVar, aVar);
        f610a = c0433h0;
        c0433h0.allowCoreThreadTimeOut(true);
    }
}
