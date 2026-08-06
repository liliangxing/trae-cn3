package com.bytedance.geckox.utils;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.geckox.policy.queue.DefaultUpdateExecutor;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GeckoExecutors.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u001e\u001a\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0!R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006R\u001b\u0010\f\u001a\u00020\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\b\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\b\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\b\u001a\u0004\b\u0017\u0010\u0006R\u001b\u0010\u0019\u001a\u00020\u001a8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\b\u001a\u0004\b\u001b\u0010\u001c¨\u0006\""}, d2 = {"Lcom/bytedance/geckox/utils/GeckoExecutors;", "", "()V", "accessExecutor", "Ljava/util/concurrent/Executor;", "getAccessExecutor", "()Ljava/util/concurrent/Executor;", "accessExecutor$delegate", "Lkotlin/Lazy;", "callbackExecutor", "getCallbackExecutor", "callbackExecutor$delegate", "checkUpdateExecutor", "Ljava/util/concurrent/ThreadPoolExecutor;", "getCheckUpdateExecutor", "()Ljava/util/concurrent/ThreadPoolExecutor;", "checkUpdateExecutor$delegate", "delayHandler", "Landroid/os/Handler;", "getDelayHandler", "()Landroid/os/Handler;", "delayHandler$delegate", "ioExecutor", "getIoExecutor", "ioExecutor$delegate", "updateExecutor", "Lcom/bytedance/geckox/policy/queue/DefaultUpdateExecutor;", "getUpdateExecutor", "()Lcom/bytedance/geckox/policy/queue/DefaultUpdateExecutor;", "updateExecutor$delegate", "runInBackground", "", "task", "Lkotlin/Function0;", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class GeckoExecutors {
    public static final GeckoExecutors INSTANCE = new GeckoExecutors();

    /* renamed from: checkUpdateExecutor$delegate, reason: from kotlin metadata */
    private static final Lazy checkUpdateExecutor = LazyKt.lazy(new Function0<ThreadPoolExecutor>() { // from class: com.bytedance.geckox.utils.GeckoExecutors$checkUpdateExecutor$2
        public final ThreadPoolExecutor invoke() {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 3, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.bytedance.geckox.utils.GeckoExecutors$checkUpdateExecutor$2$executor$1
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    Thread thread = new Thread(runnable);
                    thread.setName("gecko-check-update-thread");
                    thread.setPriority(3);
                    return thread;
                }
            });
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            return threadPoolExecutor;
        }
    });

    /* renamed from: delayHandler$delegate, reason: from kotlin metadata */
    private static final Lazy delayHandler = LazyKt.lazy(new Function0<Handler>() { // from class: com.bytedance.geckox.utils.GeckoExecutors$delayHandler$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Handler m551invoke() {
            HandlerThread handlerThread = new HandlerThread("gecko-delay-thread", 3);
            handlerThread.start();
            return new Handler(handlerThread.getLooper());
        }
    });

    /* renamed from: updateExecutor$delegate, reason: from kotlin metadata */
    private static final Lazy updateExecutor = LazyKt.lazy(new Function0<DefaultUpdateExecutor>() { // from class: com.bytedance.geckox.utils.GeckoExecutors$updateExecutor$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final DefaultUpdateExecutor m553invoke() {
            return new DefaultUpdateExecutor();
        }
    });

    /* renamed from: accessExecutor$delegate, reason: from kotlin metadata */
    private static final Lazy accessExecutor = LazyKt.lazy(new Function0<ExecutorService>() { // from class: com.bytedance.geckox.utils.GeckoExecutors$accessExecutor$2
        public final ExecutorService invoke() {
            return Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.bytedance.geckox.utils.GeckoExecutors$accessExecutor$2.1
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    Thread thread = new Thread(runnable);
                    thread.setName("gecko-access-thread");
                    thread.setPriority(3);
                    return thread;
                }
            });
        }
    });

    /* renamed from: callbackExecutor$delegate, reason: from kotlin metadata */
    private static final Lazy callbackExecutor = LazyKt.lazy(new Function0<ExecutorService>() { // from class: com.bytedance.geckox.utils.GeckoExecutors$callbackExecutor$2
        public final ExecutorService invoke() {
            return Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.bytedance.geckox.utils.GeckoExecutors$callbackExecutor$2.1
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    Thread thread = new Thread(runnable);
                    thread.setName("gecko-callback-thread");
                    thread.setPriority(3);
                    return thread;
                }
            });
        }
    });

    /* renamed from: ioExecutor$delegate, reason: from kotlin metadata */
    private static final Lazy ioExecutor = LazyKt.lazy(new Function0<ExecutorService>() { // from class: com.bytedance.geckox.utils.GeckoExecutors$ioExecutor$2
        public final ExecutorService invoke() {
            return Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.bytedance.geckox.utils.GeckoExecutors$ioExecutor$2.1
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    Thread thread = new Thread(runnable);
                    thread.setName("gecko-io-thread");
                    thread.setPriority(3);
                    return thread;
                }
            });
        }
    });

    public final Executor getAccessExecutor() {
        return (Executor) accessExecutor.getValue();
    }

    public final Executor getCallbackExecutor() {
        return (Executor) callbackExecutor.getValue();
    }

    public final ThreadPoolExecutor getCheckUpdateExecutor() {
        return (ThreadPoolExecutor) checkUpdateExecutor.getValue();
    }

    public final Handler getDelayHandler() {
        return (Handler) delayHandler.getValue();
    }

    public final Executor getIoExecutor() {
        return (Executor) ioExecutor.getValue();
    }

    public final DefaultUpdateExecutor getUpdateExecutor() {
        return (DefaultUpdateExecutor) updateExecutor.getValue();
    }

    private GeckoExecutors() {
    }

    public final void runInBackground(final Function0<Unit> task) {
        Intrinsics.checkParameterIsNotNull(task, "task");
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() { // from class: com.bytedance.geckox.utils.GeckoExecutors$sam$java_lang_Runnable$0
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                Intrinsics.checkExpressionValueIsNotNull(task.invoke(), "invoke(...)");
            }
        });
    }
}
