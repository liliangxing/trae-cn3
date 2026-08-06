package com.bytedance.gkfs;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GkFSExecutor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\r\u0010\u0015\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/gkfs/GkFSExecutor;", "", "()V", "PARALLEL_CORE_THREAD_COUNT", "", "TAG", "", "defaultExecutor", "Landroid/os/Handler;", "getDefaultExecutor", "()Landroid/os/Handler;", "defaultExecutor$delegate", "Lkotlin/Lazy;", "parallelExecutor", "Ljava/util/concurrent/Executor;", "parallel", "", "task", "Ljava/lang/Runnable;", "sequence", "", "warmup", "warmup$geckox_noasanRelease", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class GkFSExecutor {
    private static final int PARALLEL_CORE_THREAD_COUNT = 3;
    private static final String TAG = "GkFSExecutor";
    public static final GkFSExecutor INSTANCE = new GkFSExecutor();
    private static final Executor parallelExecutor = new ThreadPoolExecutor(3, 5, 30, TimeUnit.MINUTES, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.bytedance.gkfs.GkFSExecutor$parallelExecutor$1
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("gkfs-parallel");
            thread.setPriority(6);
            return thread;
        }
    });

    /* renamed from: defaultExecutor$delegate, reason: from kotlin metadata */
    private static final Lazy defaultExecutor = LazyKt.lazy(new Function0<Handler>() { // from class: com.bytedance.gkfs.GkFSExecutor$defaultExecutor$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Handler m555invoke() {
            HandlerThread handlerThread = new HandlerThread("gkfs-sequence");
            handlerThread.start();
            return new Handler(handlerThread.getLooper());
        }
    });

    private final Handler getDefaultExecutor() {
        return (Handler) defaultExecutor.getValue();
    }

    private GkFSExecutor() {
    }

    public final void warmup$geckox_noasanRelease() {
        final GkFSLogger gkFSLogger = new GkFSLogger();
        for (final int i = 0; i < 3; i++) {
            parallelExecutor.execute(new Runnable() { // from class: com.bytedance.gkfs.GkFSExecutor$warmup$1
                @Override // java.lang.Runnable
                public final void run() {
                    GkFSLogger.d$default(GkFSLogger.this, "GkFSExecutor", "parallel core thread " + (i + 1) + " warmup", 0, false, 12, null);
                }
            });
        }
    }

    @JvmStatic
    public static final boolean sequence(Runnable task) {
        Intrinsics.checkParameterIsNotNull(task, "task");
        return INSTANCE.getDefaultExecutor().post(task);
    }

    public final void parallel(Runnable task) {
        Intrinsics.checkParameterIsNotNull(task, "task");
        parallelExecutor.execute(task);
    }
}
