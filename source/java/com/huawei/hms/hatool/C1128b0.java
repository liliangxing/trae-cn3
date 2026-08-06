package com.huawei.hms.hatool;

import com.bytedance.webx.event.EventManager;
import com.heytap.mcssdk.constant.C0878a;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.huawei.hms.hatool.b0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1128b0 {

    /* renamed from: b */
    private static C1128b0 f1409b;

    /* renamed from: c */
    private static C1128b0 f1410c;

    /* renamed from: d */
    private static C1128b0 f1411d;

    /* renamed from: a */
    private ThreadPoolExecutor f1412a = new ThreadPoolExecutor(0, 1, C0878a.f518d, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(EventManager.REGION_IN_OUT_ADJUST), new b());

    /* renamed from: com.huawei.hms.hatool.b0$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    private static class a implements Runnable {

        /* renamed from: a */
        private Runnable f1413a;

        public a(Runnable runnable) {
            this.f1413a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = this.f1413a;
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Exception unused) {
                    C1182v.m1785e("hmsSdk", "InnerTask : Exception has happened,From internal operations!");
                }
            }
        }
    }

    /* renamed from: com.huawei.hms.hatool.b0$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    static class b implements ThreadFactory {

        /* renamed from: d */
        private static final AtomicInteger f1414d = new AtomicInteger(1);

        /* renamed from: a */
        private final ThreadGroup f1415a;

        /* renamed from: b */
        private final AtomicInteger f1416b = new AtomicInteger(1);

        /* renamed from: c */
        private final String f1417c;

        b() {
            SecurityManager securityManager = System.getSecurityManager();
            this.f1415a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.f1417c = "FormalHASDK-base-" + f1414d.getAndIncrement();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(this.f1415a, runnable, this.f1417c + this.f1416b.getAndIncrement(), 0L);
        }
    }

    static {
        new C1128b0();
        new C1128b0();
        f1409b = new C1128b0();
        f1410c = new C1128b0();
        f1411d = new C1128b0();
    }

    private C1128b0() {
    }

    /* renamed from: a */
    public static C1128b0 m1435a() {
        return f1411d;
    }

    /* renamed from: b */
    public static C1128b0 m1436b() {
        return f1410c;
    }

    /* renamed from: c */
    public static C1128b0 m1437c() {
        return f1409b;
    }

    /* renamed from: a */
    public void m1438a(InterfaceRunnableC1142g interfaceRunnableC1142g) {
        try {
            this.f1412a.execute(new a(interfaceRunnableC1142g));
        } catch (RejectedExecutionException unused) {
            C1182v.m1785e("hmsSdk", "addToQueue() Exception has happened!Form rejected execution");
        }
    }
}
