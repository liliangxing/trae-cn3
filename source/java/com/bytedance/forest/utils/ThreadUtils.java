package com.bytedance.forest.utils;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.MessageQueue;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ThreadUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001'B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001cJ\u0014\u0010\u001d\u001a\u00020\u00142\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00140\u001fJ\u0010\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u000e\u0010 \u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010!\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\"\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u001f\u0010#\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010$\u001a\u00020%H\u0000¢\u0006\u0002\b&R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0011\u0010\t¨\u0006("}, d2 = {"Lcom/bytedance/forest/utils/ThreadUtils;", "", "()V", "FOREST_HANDLER_NAME", "", "FOREST_REPORT_HANDLER_NAME", "forestHandler", "Landroid/os/Handler;", "getForestHandler", "()Landroid/os/Handler;", "forestHandler$delegate", "Lkotlin/Lazy;", "mainThreadExecutor", "Lcom/bytedance/forest/utils/MainThreadExecutor;", "messageQueue", "Landroid/os/MessageQueue;", "reportHandler", "getReportHandler", "reportHandler$delegate", "handleIfMessageQueueIsNull", "", "runnable", "Ljava/lang/Runnable;", "isMainThread", "", "postIdleTask", "postInSingleThread", "delayMillis", "", "runInBackground", "task", "Lkotlin/Function0;", "runInBackgroundIfNeed", "runInReportThread", "runInUI", "runInUIWithPriority", "priority", "Lcom/bytedance/forest/utils/ThreadUtils$Priority;", "runInUIWithPriority$forest_release", "Priority", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public final class ThreadUtils {
    private static final String FOREST_HANDLER_NAME = "forest_handler_thread";
    private static final String FOREST_REPORT_HANDLER_NAME = "forest_report_thread";
    private static MessageQueue messageQueue;
    public static final ThreadUtils INSTANCE = new ThreadUtils();
    private static final MainThreadExecutor mainThreadExecutor = new MainThreadExecutor();

    /* renamed from: forestHandler$delegate, reason: from kotlin metadata */
    private static final Lazy forestHandler = LazyKt.lazy(new Function0<Handler>() { // from class: com.bytedance.forest.utils.ThreadUtils$forestHandler$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Handler invoke() {
            HandlerThread handlerThread = new HandlerThread("forest_handler_thread");
            handlerThread.start();
            return new Handler(handlerThread.getLooper());
        }
    });

    /* renamed from: reportHandler$delegate, reason: from kotlin metadata */
    private static final Lazy reportHandler = LazyKt.lazy(new Function0<Handler>() { // from class: com.bytedance.forest.utils.ThreadUtils$reportHandler$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Handler invoke() {
            HandlerThread handlerThread = new HandlerThread("forest_report_thread");
            handlerThread.start();
            return new Handler(handlerThread.getLooper());
        }
    });

    /* compiled from: ThreadUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/forest/utils/ThreadUtils$Priority;", "", "(Ljava/lang/String;I)V", "HIGH", "NORMAL", "forest_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes3.dex */
    public enum Priority {
        HIGH,
        NORMAL
    }

    private final Handler getForestHandler() {
        return (Handler) forestHandler.getValue();
    }

    private final Handler getReportHandler() {
        return (Handler) reportHandler.getValue();
    }

    private ThreadUtils() {
    }

    private final void handleIfMessageQueueIsNull(Runnable runnable) {
        Looper looper = getForestHandler().getLooper();
        Intrinsics.checkExpressionValueIsNotNull(looper, "forestHandler.looper");
        messageQueue = looper.getQueue();
        postIdleTask(runnable);
    }

    public final void postInSingleThread(Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "runnable");
        getForestHandler().post(runnable);
    }

    public final void runInReportThread(Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "runnable");
        getReportHandler().post(runnable);
    }

    public final void postIdleTask(final Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "runnable");
        MessageQueue messageQueue2 = messageQueue;
        if (messageQueue2 != null) {
            messageQueue2.addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.bytedance.forest.utils.ThreadUtils$postIdleTask$$inlined$apply$lambda$1
                @Override // android.os.MessageQueue.IdleHandler
                public final boolean queueIdle() {
                    runnable.run();
                    return false;
                }
            });
            if (messageQueue2 != null) {
                return;
            }
        }
        handleIfMessageQueueIsNull(runnable);
        Unit unit = Unit.INSTANCE;
    }

    public final void postInSingleThread(Runnable runnable, long delayMillis) {
        Intrinsics.checkParameterIsNotNull(runnable, "runnable");
        getForestHandler().postDelayed(runnable, delayMillis);
    }

    public final void runInUI(Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "runnable");
        runInUIWithPriority$forest_release(runnable, Priority.NORMAL);
    }

    public static /* synthetic */ void runInUIWithPriority$forest_release$default(ThreadUtils threadUtils, Runnable runnable, Priority priority, int i, Object obj) {
        if ((i & 2) != 0) {
            priority = Priority.NORMAL;
        }
        threadUtils.runInUIWithPriority$forest_release(runnable, priority);
    }

    public final void runInUIWithPriority$forest_release(Runnable runnable, Priority priority) {
        Intrinsics.checkParameterIsNotNull(runnable, "runnable");
        Intrinsics.checkParameterIsNotNull(priority, "priority");
        if (isMainThread()) {
            runnable.run();
        } else {
            mainThreadExecutor.submit$forest_release(runnable, priority);
        }
    }

    private final void runInBackground(Runnable runnable) {
        AsyncTask.THREAD_POOL_EXECUTOR.execute(runnable);
    }

    public final void runInBackground(final Function0<Unit> task) {
        Intrinsics.checkParameterIsNotNull(task, "task");
        runInBackground(new Runnable() { // from class: com.bytedance.forest.utils.ThreadUtils$runInBackground$1
            @Override // java.lang.Runnable
            public final void run() {
                Function0.this.invoke();
            }
        });
    }

    public final boolean isMainThread() {
        Thread currentThread = Thread.currentThread();
        Looper mainLooper = Looper.getMainLooper();
        Intrinsics.checkExpressionValueIsNotNull(mainLooper, "Looper.getMainLooper()");
        return Intrinsics.areEqual(currentThread, mainLooper.getThread());
    }

    public final void runInBackgroundIfNeed(Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "runnable");
        if (isMainThread()) {
            runInBackground(runnable);
        } else {
            runnable.run();
        }
    }
}
