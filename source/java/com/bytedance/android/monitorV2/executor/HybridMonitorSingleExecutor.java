package com.bytedance.android.monitorV2.executor;

import com.bytedance.android.monitorV2.util.ExceptionUtil;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HybridMonitorSingleExecutor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/monitorV2/executor/HybridMonitorSingleExecutor;", "", "()V", "TAG", "", "singleExecutorService", "Ljava/util/concurrent/ExecutorService;", "getSingleExecutorService", "()Ljava/util/concurrent/ExecutorService;", "singleExecutorService$delegate", "Lkotlin/Lazy;", "execute", "", "runnable", "Lkotlin/Function0;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class HybridMonitorSingleExecutor {
    private static final String TAG = "HybridMonitorSingleExecutor";
    public static final HybridMonitorSingleExecutor INSTANCE = new HybridMonitorSingleExecutor();

    /* renamed from: singleExecutorService$delegate, reason: from kotlin metadata */
    private static final Lazy singleExecutorService = LazyKt.lazy(new Function0<ExecutorService>() { // from class: com.bytedance.android.monitorV2.executor.HybridMonitorSingleExecutor$singleExecutorService$2
        public final ExecutorService invoke() {
            return Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.bytedance.android.monitorV2.executor.HybridMonitorSingleExecutor$singleExecutorService$2.1
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    Thread thread = new Thread(runnable);
                    thread.setName("hybrid-monitor-data-report-thread");
                    thread.setPriority(2);
                    return thread;
                }
            });
        }
    });

    private HybridMonitorSingleExecutor() {
    }

    private final ExecutorService getSingleExecutorService() {
        Object value = singleExecutorService.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-singleExecutorService>(...)");
        return (ExecutorService) value;
    }

    public final void execute(final Function0<Unit> runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        getSingleExecutorService().execute(new Runnable() { // from class: com.bytedance.android.monitorV2.executor.HybridMonitorSingleExecutor$execute$1
            @Override // java.lang.Runnable
            public final void run() {
                Object obj;
                Function0<Unit> function0 = runnable;
                try {
                    Result.Companion companion = Result.Companion;
                    function0.invoke();
                    obj = Result.constructor-impl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                Throwable th2 = Result.exceptionOrNull-impl(obj);
                if (th2 != null) {
                    ExceptionUtil.handleException(th2);
                }
            }
        });
    }
}
