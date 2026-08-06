package com.bytedance.ies.bullet.service.preload;

import bolts.Task;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IPreloadConfigsExecutor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0001R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/bullet/service/preload/PreloadConfigsExecutor;", "Ljava/util/concurrent/Executor;", "()V", "executor", "execute", "", "runnable", "Ljava/lang/Runnable;", "setExecutor", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PreloadConfigsExecutor implements Executor {
    public static final PreloadConfigsExecutor INSTANCE = new PreloadConfigsExecutor();
    private static Executor executor;

    private PreloadConfigsExecutor() {
    }

    public final void setExecutor(Executor executor2) {
        Intrinsics.checkNotNullParameter(executor2, "executor");
        executor = executor2;
    }

    @Override // java.util.concurrent.Executor
    public void execute(final Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        Executor executor2 = executor;
        if (executor2 != null) {
            executor2.execute(runnable);
        } else {
            Task.call(new Callable() { // from class: com.bytedance.ies.bullet.service.preload.PreloadConfigsExecutor$execute$2
                @Override // java.util.concurrent.Callable
                public /* bridge */ /* synthetic */ Object call() {
                    call();
                    return Unit.INSTANCE;
                }

                @Override // java.util.concurrent.Callable
                public final void call() {
                    runnable.run();
                }
            }, Task.BACKGROUND_EXECUTOR);
        }
    }
}
