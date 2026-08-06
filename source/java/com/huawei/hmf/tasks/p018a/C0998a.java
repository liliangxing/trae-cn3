package com.huawei.hmf.tasks.p018a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.huawei.hmf.tasks.a.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class C0998a {

    /* renamed from: b */
    public static final C0998a f883b = new C0998a();

    /* renamed from: c */
    public static final int f884c;

    /* renamed from: d */
    public static final int f885d;

    /* renamed from: e */
    public static final int f886e;

    /* renamed from: a */
    public final Executor f887a = new b();

    /* renamed from: com.huawei.hmf.tasks.a.a$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class b implements Executor {
        public b() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f884c = availableProcessors;
        f885d = availableProcessors + 1;
        f886e = (availableProcessors * 2) + 1;
    }

    /* renamed from: a */
    public static ExecutorService m851a() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f885d, f886e, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    /* renamed from: b */
    public static Executor m852b() {
        return f883b.f887a;
    }
}
