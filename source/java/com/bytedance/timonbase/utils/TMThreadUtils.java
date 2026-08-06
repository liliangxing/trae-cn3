package com.bytedance.timonbase.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TMThreadUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0017J\u001c\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0017J\u0006\u0010\u001b\u001a\u00020\nJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u001dJ\u0014\u0010\u001f\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0017J\u001c\u0010 \u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0017R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\t\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\b\u001a\u0004\b\u0011\u0010\u0012¨\u0006!"}, d2 = {"Lcom/bytedance/timonbase/utils/TMThreadUtils;", "", "()V", "handlerThread", "Landroid/os/HandlerThread;", "getHandlerThread", "()Landroid/os/HandlerThread;", "handlerThread$delegate", "Lkotlin/Lazy;", "ioExecutor", "Ljava/util/concurrent/ExecutorService;", "getIoExecutor", "()Ljava/util/concurrent/ExecutorService;", "setIoExecutor", "(Ljava/util/concurrent/ExecutorService;)V", "mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "mainHandler$delegate", "async", "", "task", "Lkotlin/Function0;", "asyncPostDelay", "delayMs", "", "createDefaultIOExecutor", "initialed", "", "isMainThread", "main", "postDelay", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TMThreadUtils {
    public static ExecutorService ioExecutor;
    public static final TMThreadUtils INSTANCE = new TMThreadUtils();

    /* renamed from: handlerThread$delegate, reason: from kotlin metadata */
    private static final Lazy handlerThread = LazyKt.lazy(new Function0<HandlerThread>() { // from class: com.bytedance.timonbase.utils.TMThreadUtils$handlerThread$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final HandlerThread m1083invoke() {
            HandlerThread handlerThread2 = new HandlerThread("tm_handler_thread");
            handlerThread2.start();
            return handlerThread2;
        }
    });

    /* renamed from: mainHandler$delegate, reason: from kotlin metadata */
    private static final Lazy mainHandler = LazyKt.lazy(new Function0<Handler>() { // from class: com.bytedance.timonbase.utils.TMThreadUtils$mainHandler$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Handler m1084invoke() {
            return new Handler(Looper.getMainLooper());
        }
    });

    private final Handler getMainHandler() {
        return (Handler) mainHandler.getValue();
    }

    public final HandlerThread getHandlerThread() {
        return (HandlerThread) handlerThread.getValue();
    }

    private TMThreadUtils() {
    }

    public final ExecutorService getIoExecutor() {
        ExecutorService executorService = ioExecutor;
        if (executorService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ioExecutor");
        }
        return executorService;
    }

    public final void setIoExecutor(ExecutorService executorService) {
        Intrinsics.checkParameterIsNotNull(executorService, "<set-?>");
        ioExecutor = executorService;
    }

    public final boolean initialed() {
        return ioExecutor != null;
    }

    public final ExecutorService createDefaultIOExecutor() {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(8);
        Intrinsics.checkExpressionValueIsNotNull(newFixedThreadPool, "Executors.newFixedThreadPool(8)");
        return newFixedThreadPool;
    }

    public final void async(Function0<Unit> task) {
        Intrinsics.checkParameterIsNotNull(task, "task");
        if (!initialed()) {
            ioExecutor = createDefaultIOExecutor();
        }
        ExecutorService executorService = ioExecutor;
        if (executorService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ioExecutor");
        }
        executorService.execute(new TMThreadUtils$sam$java_lang_Runnable$0(task));
    }

    public final void main(Function0<Unit> task) {
        Intrinsics.checkParameterIsNotNull(task, "task");
        getMainHandler().post(new TMThreadUtils$sam$java_lang_Runnable$0(task));
    }

    public final void postDelay(long delayMs, Function0<Unit> task) {
        Intrinsics.checkParameterIsNotNull(task, "task");
        getMainHandler().postDelayed(new TMThreadUtils$sam$java_lang_Runnable$0(task), delayMs);
    }

    public final void asyncPostDelay(long delayMs, final Function0<Unit> task) {
        Intrinsics.checkParameterIsNotNull(task, "task");
        getMainHandler().postDelayed(new Runnable() { // from class: com.bytedance.timonbase.utils.TMThreadUtils$asyncPostDelay$1
            @Override // java.lang.Runnable
            public final void run() {
                TMThreadUtils.INSTANCE.async(task);
            }
        }, delayMs);
    }

    public final boolean isMainThread() {
        Thread currentThread = Thread.currentThread();
        Looper mainLooper = Looper.getMainLooper();
        Intrinsics.checkExpressionValueIsNotNull(mainLooper, "Looper.getMainLooper()");
        return Intrinsics.areEqual(currentThread, mainLooper.getThread());
    }
}
