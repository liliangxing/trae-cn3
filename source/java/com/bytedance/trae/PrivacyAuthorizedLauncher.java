package com.bytedance.trae;

import android.app.Application;
import android.content.Context;
import com.bytedance.apm.ApmContext;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.config.TaskConfig;
import com.bytedance.lego.init.monitor.InitMonitor;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.home.privacy.InitPeriodWrapper;
import com.bytedance.trae.home.privacy.PrivacyManager;
import com.bytedance.trae.init.LaunchBoostExecutor;
import com.bytedance.trae.init.task.base.TaskCollector;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PrivacyAuthorizedLauncher.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/trae/PrivacyAuthorizedLauncher;", "Lcom/bytedance/trae/ILauncher;", "<init>", "()V", "beforeAttachBaseContext", "", "context", "Landroid/content/Context;", "afterAttachBaseContext", "beforeOnCreate", "application", "Landroid/app/Application;", "afterOnCreate", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class PrivacyAuthorizedLauncher implements ILauncher {
    public static final int $stable = 0;

    @Override // com.bytedance.trae.ILauncher
    public void beforeAttachBaseContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        long currentTimeMillis = System.currentTimeMillis();
        InitMonitor.INSTANCE.onAttachBase();
        boolean isTestChannel = AppHost.INSTANCE.isTestChannel();
        boolean isMainProcessSimple = ApmContext.isMainProcessSimple();
        String currentProcessName = ApmContext.getCurrentProcessName();
        Intrinsics.checkNotNullExpressionValue(currentProcessName, "getCurrentProcessName(...)");
        InitScheduler.config(new TaskConfig.Builder(context, isMainProcessSimple, currentProcessName).isDebug(true).setTimeOut(10000).enableCatchException(!isTestChannel).setThreadFactory(new ThreadFactory() { // from class: com.bytedance.trae.PrivacyAuthorizedLauncher$beforeAttachBaseContext$config$1
            private final AtomicInteger mCount = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable r) {
                Intrinsics.checkNotNullParameter(r, "r");
                return new Thread(r, "_a_init_" + this.mCount.getAndIncrement());
            }
        }).setCoreThreadNum(Runtime.getRuntime().availableProcessors() * 2).setExecutorService(LaunchBoostExecutor.INSTANCE.executors$app_mainlandRelease()).setApplicationStartTime(currentTimeMillis).agreePrivacyPopupWindow(PrivacyManager.INSTANCE.checkAgreed()).build());
        TaskCollector.INSTANCE.start();
        ThreadPlus.submitRunnable(new Runnable() { // from class: com.bytedance.trae.PrivacyAuthorizedLauncher$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                PrivacyAuthorizedLauncher.beforeAttachBaseContext$lambda$0();
            }
        });
        InitPeriodWrapper.INSTANCE.applicationAttachBeforeSuper(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void beforeAttachBaseContext$lambda$0() {
        InitScheduler.initTasks();
        InitScheduler.initPeriodTask();
        TaskCollector.INSTANCE.markTaskInitialized();
    }

    @Override // com.bytedance.trae.ILauncher
    public void afterAttachBaseContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        InitPeriodWrapper.INSTANCE.applicationAttachAfterSuper();
    }

    @Override // com.bytedance.trae.ILauncher
    public void beforeOnCreate(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        InitPeriodWrapper.INSTANCE.applicationCreateBeforeSuper(application);
    }

    @Override // com.bytedance.trae.ILauncher
    public void afterOnCreate(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        InitPeriodWrapper.INSTANCE.applicationCreateAfterSuper();
    }
}
