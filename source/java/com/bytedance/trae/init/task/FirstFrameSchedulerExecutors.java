package com.bytedance.trae.init.task;

import com.bytedance.trae.init.LaunchBoostExecutor;
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

/* compiled from: FirstFrameSchedulerExecutors.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012J\u0014\u0010\u0013\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/init/task/FirstFrameSchedulerExecutors;", "", "<init>", "()V", "CORE_POOL_SIZE", "", "MAX_POOL_SIZE", "KEEP_ALIVE_SECONDS", "", "threadPoolExecutor", "Ljava/util/concurrent/ThreadPoolExecutor;", "getThreadPoolExecutor", "()Ljava/util/concurrent/ThreadPoolExecutor;", "threadPoolExecutor$delegate", "Lkotlin/Lazy;", "singleAsync", "", "runnable", "Lkotlin/Function0;", "useLaunchBoostExecutor", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class FirstFrameSchedulerExecutors {
    private static final int CORE_POOL_SIZE = 1;
    private static final long KEEP_ALIVE_SECONDS = 30;
    private static final int MAX_POOL_SIZE = 1;
    public static final FirstFrameSchedulerExecutors INSTANCE = new FirstFrameSchedulerExecutors();

    /* renamed from: threadPoolExecutor$delegate, reason: from kotlin metadata */
    private static final Lazy threadPoolExecutor = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.init.task.FirstFrameSchedulerExecutors$$ExternalSyntheticLambda0
        public final Object invoke() {
            ThreadPoolExecutor threadPoolExecutor_delegate$lambda$1;
            threadPoolExecutor_delegate$lambda$1 = FirstFrameSchedulerExecutors.threadPoolExecutor_delegate$lambda$1();
            return threadPoolExecutor_delegate$lambda$1;
        }
    });
    public static final int $stable = 8;

    private FirstFrameSchedulerExecutors() {
    }

    private final ThreadPoolExecutor getThreadPoolExecutor() {
        return (ThreadPoolExecutor) threadPoolExecutor.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ThreadPoolExecutor threadPoolExecutor_delegate$lambda$1() {
        return new ThreadPoolExecutor(1, 1, KEEP_ALIVE_SECONDS, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.bytedance.trae.init.task.FirstFrameSchedulerExecutors$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread threadPoolExecutor_delegate$lambda$1$lambda$0;
                threadPoolExecutor_delegate$lambda$1$lambda$0 = FirstFrameSchedulerExecutors.threadPoolExecutor_delegate$lambda$1$lambda$0(runnable);
                return threadPoolExecutor_delegate$lambda$1$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread threadPoolExecutor_delegate$lambda$1$lambda$0(Runnable runnable) {
        return new Thread(runnable, "A-FirstFrameSchedulerExecutors");
    }

    public final void singleAsync(final Function0<Unit> runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        getThreadPoolExecutor().execute(new Runnable() { // from class: com.bytedance.trae.init.task.FirstFrameSchedulerExecutors$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                runnable.invoke();
            }
        });
    }

    public final void useLaunchBoostExecutor(final Function0<Unit> runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        LaunchBoostExecutor.INSTANCE.executors$app_mainlandRelease().execute(new Runnable() { // from class: com.bytedance.trae.init.task.FirstFrameSchedulerExecutors$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                runnable.invoke();
            }
        });
    }
}
