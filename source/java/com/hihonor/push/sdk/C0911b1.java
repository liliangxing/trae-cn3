package com.hihonor.push.sdk;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.hihonor.push.sdk.b1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class C0911b1 {

    /* renamed from: d */
    public static final C0911b1 f689d = new C0911b1();

    /* renamed from: a */
    public volatile Executor f690a;

    /* renamed from: b */
    public volatile ExecutorService f691b;

    /* renamed from: c */
    public final Object f692c = new Object();

    /* renamed from: com.hihonor.push.sdk.b1$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class a implements Executor {
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    /* renamed from: a */
    public static Executor m752a() {
        C0911b1 c0911b1 = f689d;
        if (c0911b1.f690a == null) {
            synchronized (c0911b1.f692c) {
                if (c0911b1.f690a == null) {
                    c0911b1.f690a = new a();
                }
            }
        }
        return c0911b1.f690a;
    }

    /* renamed from: c */
    public static ExecutorService m754c() {
        return f689d.m755b();
    }

    /* renamed from: b */
    public final ExecutorService m755b() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 10, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    /* renamed from: a */
    public static void m753a(Runnable runnable) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            m752a().execute(runnable);
        }
    }
}
