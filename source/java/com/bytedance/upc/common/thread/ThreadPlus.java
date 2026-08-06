package com.bytedance.upc.common.thread;

import com.bytedance.common.utility.concurrent.TTExecutors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ThreadPlus.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00182\b\b\u0002\u0010\u0016\u001a\u00020\u0017J\u0014\u0010\u0019\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0015J\u000e\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0018J\u0014\u0010\u001a\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0015J\u000e\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0018R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR#\u0010\u000e\u001a\n \u000f*\u0004\u0018\u00010\u00040\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\b\u001a\u0004\b\u0010\u0010\u0006¨\u0006\u001b"}, d2 = {"Lcom/bytedance/upc/common/thread/ThreadPlus;", "", "()V", "mExecutorService", "Ljava/util/concurrent/ExecutorService;", "getMExecutorService", "()Ljava/util/concurrent/ExecutorService;", "mExecutorService$delegate", "Lkotlin/Lazy;", "mScheduledThreadPool", "Ljava/util/concurrent/ScheduledExecutorService;", "getMScheduledThreadPool", "()Ljava/util/concurrent/ScheduledExecutorService;", "mScheduledThreadPool$delegate", "mSingleExecutorService", "kotlin.jvm.PlatformType", "getMSingleExecutorService", "mSingleExecutorService$delegate", "schedule", "", "runnable", "Lkotlin/Function0;", "delay", "", "Ljava/lang/Runnable;", "submit", "submitWithOrder", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class ThreadPlus {
    public static final ThreadPlus INSTANCE = new ThreadPlus();

    /* renamed from: mExecutorService$delegate, reason: from kotlin metadata */
    private static final Lazy mExecutorService = LazyKt.lazy(new Function0<ExecutorService>() { // from class: com.bytedance.upc.common.thread.ThreadPlus$mExecutorService$2
        public final ExecutorService invoke() {
            return TTExecutors.getIOThreadPool();
        }
    });

    /* renamed from: mScheduledThreadPool$delegate, reason: from kotlin metadata */
    private static final Lazy mScheduledThreadPool = LazyKt.lazy(new Function0<ScheduledExecutorService>() { // from class: com.bytedance.upc.common.thread.ThreadPlus$mScheduledThreadPool$2
        public final ScheduledExecutorService invoke() {
            return TTExecutors.getScheduledThreadPool();
        }
    });

    /* renamed from: mSingleExecutorService$delegate, reason: from kotlin metadata */
    private static final Lazy mSingleExecutorService = LazyKt.lazy(new Function0<ExecutorService>() { // from class: com.bytedance.upc.common.thread.ThreadPlus$mSingleExecutorService$2
        public final ExecutorService invoke() {
            return Executors.newSingleThreadExecutor();
        }
    });

    private final ExecutorService getMExecutorService() {
        return (ExecutorService) mExecutorService.getValue();
    }

    private final ScheduledExecutorService getMScheduledThreadPool() {
        return (ScheduledExecutorService) mScheduledThreadPool.getValue();
    }

    private final ExecutorService getMSingleExecutorService() {
        return (ExecutorService) mSingleExecutorService.getValue();
    }

    private ThreadPlus() {
    }

    public final void submit(Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "runnable");
        getMExecutorService().submit(runnable);
    }

    public final void submit(final Function0<Unit> runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "runnable");
        getMExecutorService().submit(new Runnable() { // from class: com.bytedance.upc.common.thread.ThreadPlus$submit$1
            @Override // java.lang.Runnable
            public final void run() {
                runnable.invoke();
            }
        });
    }

    public static /* synthetic */ void schedule$default(ThreadPlus threadPlus, Runnable runnable, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        threadPlus.schedule(runnable, j);
    }

    public final void schedule(Runnable runnable, long delay) {
        Intrinsics.checkParameterIsNotNull(runnable, "runnable");
        getMScheduledThreadPool().schedule(runnable, delay, TimeUnit.SECONDS);
    }

    public static /* synthetic */ void schedule$default(ThreadPlus threadPlus, Function0 function0, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        threadPlus.schedule((Function0<Unit>) function0, j);
    }

    public final void schedule(final Function0<Unit> runnable, long delay) {
        Intrinsics.checkParameterIsNotNull(runnable, "runnable");
        getMScheduledThreadPool().schedule(new Runnable() { // from class: com.bytedance.upc.common.thread.ThreadPlus$sam$java_lang_Runnable$0
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                Intrinsics.checkExpressionValueIsNotNull(runnable.invoke(), "invoke(...)");
            }
        }, delay, TimeUnit.SECONDS);
    }

    public final void submitWithOrder(Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "runnable");
        getMSingleExecutorService().submit(runnable);
    }

    public final void submitWithOrder(final Function0<Unit> runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "runnable");
        getMSingleExecutorService().submit(new Runnable() { // from class: com.bytedance.upc.common.thread.ThreadPlus$submitWithOrder$1
            @Override // java.lang.Runnable
            public final void run() {
                runnable.invoke();
            }
        });
    }
}
