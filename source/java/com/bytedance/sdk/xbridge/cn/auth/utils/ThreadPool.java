package com.bytedance.sdk.xbridge.cn.auth.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ThreadPool.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\tH\u0002J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/utils/ThreadPool;", "", "()V", "TAG", "", "executor", "Ljava/util/concurrent/ExecutorService;", "createDefault", "ensureExecutorNotNull", "", "runInBackGround", "runnable", "Ljava/lang/Runnable;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final class ThreadPool {
    public static final ThreadPool INSTANCE = new ThreadPool();
    private static final String TAG = "JSBAuthThreadPool";
    private static ExecutorService executor;

    private ThreadPool() {
    }

    public final void runInBackGround(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        ensureExecutorNotNull();
        ExecutorService executorService = executor;
        Intrinsics.checkNotNull(executorService);
        executorService.submit(runnable);
    }

    private final void ensureExecutorNotNull() {
        if (executor == null) {
            executor = createDefault();
        }
    }

    private final ExecutorService createDefault() {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(newSingleThreadExecutor, "newSingleThreadExecutor()");
        return newSingleThreadExecutor;
    }
}
