package com.bytedance.android.monitorV2.executor;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.monitorV2.exception.MonitorRunnable;
import com.bytedance.android.monitorV2.util.ExceptionUtil;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HybridMonitorExecutor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0017J\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0019J\u0014\u0010\u001a\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0017J\u001c\u0010\u001a\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00172\u0006\u0010\u001b\u001a\u00020\u0011J\u000e\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0019R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R$\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/monitorV2/executor/HybridMonitorExecutor;", "", "()V", "TAG", "", "corePoolSize", "", "value", "Ljava/util/concurrent/ExecutorService;", "executor", "getExecutor", "()Ljava/util/concurrent/ExecutorService;", "setExecutor", "(Ljava/util/concurrent/ExecutorService;)V", "handler", "Landroid/os/Handler;", "keepAliveTime", "", "maximumPoolSize", "sExecutor", "post", "", "runnable", "Lkotlin/Function0;", "runOnMain", "Ljava/lang/Runnable;", "runOnUiThread", "delayed", "submit", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class HybridMonitorExecutor {
    private static final String TAG = "HybridMonitorExecutor";
    private static ExecutorService sExecutor;
    public static final HybridMonitorExecutor INSTANCE = new HybridMonitorExecutor();
    private static final int corePoolSize = 4;
    private static final int maximumPoolSize = 8;
    private static final long keepAliveTime = 15;
    private static final Handler handler = new Handler(Looper.getMainLooper());

    private HybridMonitorExecutor() {
    }

    public final void setExecutor(ExecutorService value) {
        Intrinsics.checkNotNullParameter(value, "value");
        sExecutor = value;
    }

    public final ExecutorService getExecutor() {
        if (sExecutor == null) {
            sExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadPoolExecutor.DiscardPolicy());
        }
        ExecutorService executorService = sExecutor;
        Intrinsics.checkNotNull(executorService);
        return executorService;
    }

    public final void post(final Function0<Unit> runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        getExecutor().execute(new Runnable() { // from class: com.bytedance.android.monitorV2.executor.HybridMonitorExecutor$post$1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    runnable.invoke();
                } catch (Exception e) {
                    ExceptionUtil.handleException(e);
                }
            }
        });
    }

    public final void submit(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        getExecutor().execute(new MonitorRunnable(runnable));
    }

    public final void runOnUiThread(final Function0<Unit> runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        handler.post(new Runnable() { // from class: com.bytedance.android.monitorV2.executor.HybridMonitorExecutor$runOnUiThread$1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    runnable.invoke();
                } catch (Exception e) {
                    ExceptionUtil.handleException(e);
                }
            }
        });
    }

    public final void runOnUiThread(final Function0<Unit> runnable, long delayed) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        handler.postDelayed(new Runnable() { // from class: com.bytedance.android.monitorV2.executor.HybridMonitorExecutor$runOnUiThread$2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    runnable.invoke();
                } catch (Exception e) {
                    ExceptionUtil.handleException(e);
                }
            }
        }, delayed);
    }

    public final void runOnMain(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        if (!Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            handler.post(runnable);
        } else {
            runnable.run();
        }
    }
}
