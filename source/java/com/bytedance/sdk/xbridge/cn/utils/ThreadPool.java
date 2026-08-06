package com.bytedance.sdk.xbridge.cn.utils;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ThreadPool.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006J\b\u0010\u0010\u001a\u00020\u0006H\u0002J\b\u0010\u0011\u001a\u00020\u000eH\u0002J\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/utils/ThreadPool;", "", "()V", "TAG", "", "executor", "Ljava/util/concurrent/ExecutorService;", "mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "mainHandler$delegate", "Lkotlin/Lazy;", "configExecutorService", "", "outerExecutors", "createDefault", "ensureExecutorNotNull", "isInMainThread", "", "runInBackGround", "runnable", "Ljava/lang/Runnable;", "runInMain", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ThreadPool {
    private static final String TAG = "ThreadPool";
    private static ExecutorService executor;
    public static final ThreadPool INSTANCE = new ThreadPool();

    /* renamed from: mainHandler$delegate, reason: from kotlin metadata */
    private static final Lazy mainHandler = LazyKt.lazy(new Function0<Handler>() { // from class: com.bytedance.sdk.xbridge.cn.utils.ThreadPool$mainHandler$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Handler m917invoke() {
            return new Handler(Looper.getMainLooper());
        }
    });

    private ThreadPool() {
    }

    private final Handler getMainHandler() {
        return (Handler) mainHandler.getValue();
    }

    public final boolean isInMainThread() {
        return Intrinsics.areEqual(getMainHandler().getLooper().getThread(), Thread.currentThread());
    }

    public final void runInMain(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        getMainHandler().post(runnable);
    }

    public final void runInBackGround(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        ensureExecutorNotNull();
        ExecutorService executorService = executor;
        Intrinsics.checkNotNull(executorService);
        executorService.submit(runnable);
    }

    public final void configExecutorService(ExecutorService outerExecutors) {
        Intrinsics.checkNotNullParameter(outerExecutors, "outerExecutors");
        executor = outerExecutors;
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
