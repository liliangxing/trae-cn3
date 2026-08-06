package cn.com.chinatelecom.account.api.p008c;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: cn.com.chinatelecom.account.api.c.d */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0684d extends ThreadPoolExecutor {

    /* renamed from: a */
    private static final BlockingQueue<Runnable> f200a = new LinkedBlockingQueue(256);

    /* renamed from: b */
    private static final ThreadFactory f201b = new ThreadFactory() { // from class: cn.com.chinatelecom.account.api.c.d.1

        /* renamed from: a */
        private final AtomicInteger f202a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable);
        }
    };

    public C0684d() {
        this(5);
    }

    public C0684d(int i) {
        this(i, i * 2, 1L, TimeUnit.SECONDS, f200a, f201b);
    }

    public C0684d(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory);
    }

    /* renamed from: a */
    public void m233a(AbstractRunnableC0685e abstractRunnableC0685e) {
        execute(abstractRunnableC0685e);
    }
}
