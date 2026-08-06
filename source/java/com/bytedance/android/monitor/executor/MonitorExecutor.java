package com.bytedance.android.monitor.executor;

import com.bytedance.android.monitor.exception.MonitorRunnable;
import com.bytedance.android.monitor.util.ExceptionUtil;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MonitorExecutor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0015J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R$\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/monitor/executor/MonitorExecutor;", "", "()V", "TAG", "", "corePoolSize", "", "value", "Ljava/util/concurrent/ExecutorService;", "executor", "getExecutor", "()Ljava/util/concurrent/ExecutorService;", "setExecutor", "(Ljava/util/concurrent/ExecutorService;)V", "keepAliveTime", "", "maximumPoolSize", "sExecutor", "post", "", "runnable", "Lkotlin/Function0;", "submit", "Ljava/lang/Runnable;", "com.bytedance.android.livesdk.monitor.base"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes3.dex */
public final class MonitorExecutor {
    private static final String TAG = "MonitorExecutor";
    private static ExecutorService sExecutor;
    public static final MonitorExecutor INSTANCE = new MonitorExecutor();
    private static final int corePoolSize = 4;
    private static final int maximumPoolSize = 8;
    private static final long keepAliveTime = 15;

    private MonitorExecutor() {
    }

    public final void setExecutor(ExecutorService value) {
        Intrinsics.checkParameterIsNotNull(value, "value");
        sExecutor = value;
    }

    public final ExecutorService getExecutor() {
        if (sExecutor == null) {
            sExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadPoolExecutor.DiscardPolicy());
        }
        ExecutorService executorService = sExecutor;
        if (executorService == null) {
            Intrinsics.throwNpe();
        }
        return executorService;
    }

    public final void post(final Function0<Unit> runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "runnable");
        getExecutor().execute(new Runnable() { // from class: com.bytedance.android.monitor.executor.MonitorExecutor$post$1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    Function0.this.invoke();
                } catch (Exception e) {
                    ExceptionUtil.handleException(e);
                }
            }
        });
    }

    public final void submit(Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "runnable");
        getExecutor().execute(new MonitorRunnable(runnable));
    }
}
