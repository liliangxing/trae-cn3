package com.bytedance.lego.init;

import android.app.Activity;
import android.util.Log;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.lego.init.config.ProcessMatchMode;
import com.bytedance.lego.init.config.TaskConfig;
import com.bytedance.lego.init.model.InitPeriod;
import com.bytedance.lego.init.monitor.Category;
import com.bytedance.lego.init.monitor.IdleTaskMonitor;
import com.bytedance.lego.init.monitor.InitMonitor;
import com.bytedance.lego.init.util.InitTraceUtil;
import java.lang.ref.WeakReference;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: InitScheduler.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0007J\u0010\u0010\u0007\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0006\u0010\u0015\u001a\u00020\u0016J\r\u0010\u0017\u001a\u00020\u0012H\u0000¢\u0006\u0002\b\u0018J\u000f\u0010\u0019\u001a\u0004\u0018\u00010\u0012H\u0000¢\u0006\u0002\b\u001aJ\u000f\u0010\u001b\u001a\u0004\u0018\u00010\u000fH\u0001¢\u0006\u0002\b\u001cJ\r\u0010\u001d\u001a\u00020\u001eH\u0000¢\u0006\u0002\b\u001fJ\u000f\u0010 \u001a\u0004\u0018\u00010\u000fH\u0001¢\u0006\u0002\b!J\b\u0010\"\u001a\u00020\u0014H\u0007J\b\u0010#\u001a\u00020\u0014H\u0007J\r\u0010$\u001a\u00020\u0016H\u0000¢\u0006\u0002\b%J\b\u0010&\u001a\u00020\u0014H\u0007J\u0010\u0010'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020)H\u0007J\u0010\u0010*\u001a\u00020\u00142\u0006\u0010(\u001a\u00020)H\u0007J\u0010\u0010+\u001a\u00020\u00142\u0006\u0010,\u001a\u00020\u000fH\u0007J\u0010\u0010-\u001a\u00020\u00142\u0006\u0010.\u001a\u00020\u000fH\u0007J\u0010\u0010/\u001a\u00020\u00142\u0006\u00100\u001a\u00020\u0012H\u0007J\u0010\u00101\u001a\u00020\u00142\u0006\u00102\u001a\u000203H\u0007J\b\u00104\u001a\u00020\u0014H\u0007J\b\u00105\u001a\u00020\u0014H\u0007J\r\u00106\u001a\u00020\u0014H\u0001¢\u0006\u0002\b7J\r\u00108\u001a\u00020\u0014H\u0001¢\u0006\u0002\b9R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/bytedance/lego/init/InitScheduler;", "", "()V", "INIT_SCHEDULER_CATEGORY", "", "getINIT_SCHEDULER_CATEGORY$initscheduler_release", "()Ljava/lang/String;", "config", "Lcom/bytedance/lego/init/config/TaskConfig;", "getConfig$initscheduler_release", "()Lcom/bytedance/lego/init/config/TaskConfig;", "setConfig$initscheduler_release", "(Lcom/bytedance/lego/init/config/TaskConfig;)V", "mainActivityWR", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "splashActivityWR", "taskExecutor", "Ljava/util/concurrent/ThreadPoolExecutor;", "afterPrivacyPopupWindow", "", "enableCatchException", "", "getExecutorService", "getExecutorService$initscheduler_release", "getExecutorServiceOrNull", "getExecutorServiceOrNull$initscheduler_release", "getMainActivity", "getMainActivity$initscheduler_release", "getProcessMatchMode", "Lcom/bytedance/lego/init/config/ProcessMatchMode;", "getProcessMatchMode$initscheduler_release", "getSplashActivity", "getSplashActivity$initscheduler_release", "initPeriodTask", "initTasks", "isDebug", "isDebug$initscheduler_release", "onFeedShow", "onPeriodEnd", "period", "Lcom/bytedance/lego/init/model/InitPeriod;", "onPeriodStart", "registerMainActivity", "mainActivity", "registerSplashActivity", "splashActivity", "setExecutorService", "executor", "setServiceManagerProxy", "proxy", "Lcom/bytedance/lego/init/IServiceManagerProxy;", "startDispatchDelayTask", "startDispatchIdleTask", "unRegisterMainActivity", "unRegisterMainActivity$initscheduler_release", "unRegisterSplashActivity", "unRegisterSplashActivity$initscheduler_release", "initscheduler_release"}, k = 1, mv = {1, 1, 13})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class InitScheduler {
    public static TaskConfig config;
    private static WeakReference<Activity> mainActivityWR;
    private static WeakReference<Activity> splashActivityWR;
    private static ThreadPoolExecutor taskExecutor;
    public static final InitScheduler INSTANCE = new InitScheduler();
    private static final String INIT_SCHEDULER_CATEGORY = INIT_SCHEDULER_CATEGORY;
    private static final String INIT_SCHEDULER_CATEGORY = INIT_SCHEDULER_CATEGORY;

    private InitScheduler() {
    }

    public final TaskConfig getConfig$initscheduler_release() {
        TaskConfig taskConfig = config;
        if (taskConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("config");
        }
        return taskConfig;
    }

    public final void setConfig$initscheduler_release(TaskConfig taskConfig) {
        Intrinsics.checkParameterIsNotNull(taskConfig, "<set-?>");
        config = taskConfig;
    }

    public final String getINIT_SCHEDULER_CATEGORY$initscheduler_release() {
        return INIT_SCHEDULER_CATEGORY;
    }

    @JvmStatic
    public static final void config(TaskConfig config2) {
        Intrinsics.checkParameterIsNotNull(config2, "config");
        config = config2;
        IdleTaskDispatcher.INSTANCE.config(config2.getIdleTaskConfig());
        IdleTaskMonitor.INSTANCE.setApplicationStartTime(config2.getApplicationStartTime());
    }

    @JvmStatic
    public static final void setServiceManagerProxy(IServiceManagerProxy proxy) {
        Intrinsics.checkParameterIsNotNull(proxy, "proxy");
        ServiceManagerProxy.INSTANCE.setProxy$initscheduler_release(proxy);
    }

    @JvmStatic
    public static final void setExecutorService(ThreadPoolExecutor executor) {
        Intrinsics.checkParameterIsNotNull(executor, "executor");
        taskExecutor = executor;
    }

    @JvmStatic
    public static final void onPeriodStart(InitPeriod period) {
        Intrinsics.checkParameterIsNotNull(period, "period");
        TaskConfig taskConfig = config;
        if (taskConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("config");
        }
        taskConfig.getIsDebug();
        try {
            InitTaskDispatcher.INSTANCE.onPeriod(period, false);
        } catch (Exception e) {
            e.printStackTrace();
            InitMonitor initMonitor = InitMonitor.INSTANCE;
            Category category = Category.ON_PERIOD_EXCEPTION;
            String name = period.name();
            JSONObject jSONObject = new JSONObject();
            Exception exc = e;
            jSONObject.put("exception_detail", Log.getStackTraceString(exc));
            initMonitor.monitorEvent(category, name, jSONObject);
            TaskConfig taskConfig2 = config;
            if (taskConfig2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("config");
            }
            if (taskConfig2.getCatchException()) {
                InitMonitor.INSTANCE.ensureNotReachHere(exc, "ON_PERIOD_EXCEPTION:" + period.name());
                return;
            }
            throw exc;
        }
    }

    @JvmStatic
    public static final void onPeriodEnd(InitPeriod period) {
        Intrinsics.checkParameterIsNotNull(period, "period");
        try {
            InitTaskDispatcher.INSTANCE.onPeriod(period, true);
        } catch (Exception e) {
            e.printStackTrace();
            InitMonitor initMonitor = InitMonitor.INSTANCE;
            Category category = Category.ON_PERIOD_EXCEPTION;
            String name = period.name();
            JSONObject jSONObject = new JSONObject();
            Exception exc = e;
            jSONObject.put("exception_detail", Log.getStackTraceString(exc));
            initMonitor.monitorEvent(category, name, jSONObject);
            TaskConfig taskConfig = config;
            if (taskConfig == null) {
                Intrinsics.throwUninitializedPropertyAccessException("config");
            }
            if (taskConfig.getCatchException()) {
                InitMonitor.INSTANCE.ensureNotReachHere(exc, "ON_PERIOD_EXCEPTION:" + period.name());
                return;
            }
            throw exc;
        }
    }

    @JvmStatic
    public static final void startDispatchDelayTask() {
        TaskConfig taskConfig = config;
        if (taskConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("config");
        }
        taskConfig.getIsDebug();
        try {
            DelayTaskDispatcher.INSTANCE.start();
        } catch (Exception e) {
            e.printStackTrace();
            if (INSTANCE.enableCatchException()) {
                InitMonitor.INSTANCE.ensureNotReachHere(e, "START_DELAY_TASK_DISPATCHER");
                return;
            }
            throw e;
        }
    }

    @JvmStatic
    public static final void startDispatchIdleTask() {
        try {
            IdleTaskDispatcher.INSTANCE.bootFinish();
        } catch (Exception e) {
            e.printStackTrace();
            if (INSTANCE.enableCatchException()) {
                InitMonitor.INSTANCE.ensureNotReachHere(e, "START_IDLE_TASK_DISPATCHER");
                return;
            }
            throw e;
        }
    }

    @JvmStatic
    public static final void onFeedShow() {
        TaskConfig taskConfig = config;
        if (taskConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("config");
        }
        taskConfig.getIsDebug();
        try {
            FeedShowTaskDispatcher.INSTANCE.onFeedShow();
        } catch (Exception e) {
            e.printStackTrace();
            if (INSTANCE.enableCatchException()) {
                InitMonitor.INSTANCE.ensureNotReachHere(e, "START_FEED_SHOW_TASK_DISPATCHER");
                return;
            }
            throw e;
        }
    }

    @JvmStatic
    public static final void registerMainActivity(Activity mainActivity) {
        Intrinsics.checkParameterIsNotNull(mainActivity, "mainActivity");
        mainActivityWR = new WeakReference<>(mainActivity);
        if (!(mainActivity instanceof LifecycleOwner)) {
            mainActivity = null;
        }
        LifecycleOwner lifecycleOwner = (LifecycleOwner) mainActivity;
        Lifecycle lifecycle = lifecycleOwner != null ? lifecycleOwner.getLifecycle() : null;
        if (lifecycle == null) {
            throw new IllegalArgumentException("mainActivity must be LifecycleOwner.");
        }
        PeriodTaskManager.INSTANCE.registerMain$initscheduler_release(lifecycle);
    }

    @JvmStatic
    public static final void registerSplashActivity(Activity splashActivity) {
        Intrinsics.checkParameterIsNotNull(splashActivity, "splashActivity");
        splashActivityWR = new WeakReference<>(splashActivity);
        if (!(splashActivity instanceof LifecycleOwner)) {
            splashActivity = null;
        }
        LifecycleOwner lifecycleOwner = (LifecycleOwner) splashActivity;
        Lifecycle lifecycle = lifecycleOwner != null ? lifecycleOwner.getLifecycle() : null;
        if (lifecycle == null) {
            throw new IllegalArgumentException("splashActivity must be LifecycleOwner.");
        }
        PeriodTaskManager.INSTANCE.registerSplash$initscheduler_release(lifecycle);
    }

    @JvmStatic
    public static final Activity getMainActivity$initscheduler_release() {
        WeakReference<Activity> weakReference = mainActivityWR;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @JvmStatic
    public static final Activity getSplashActivity$initscheduler_release() {
        WeakReference<Activity> weakReference = splashActivityWR;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @JvmStatic
    public static final void unRegisterMainActivity$initscheduler_release() {
        WeakReference<Activity> weakReference = mainActivityWR;
        if (weakReference != null) {
            weakReference.clear();
        }
    }

    @JvmStatic
    public static final void unRegisterSplashActivity$initscheduler_release() {
        WeakReference<Activity> weakReference = splashActivityWR;
        if (weakReference != null) {
            weakReference.clear();
        }
    }

    public final boolean isDebug$initscheduler_release() {
        try {
            TaskConfig taskConfig = config;
            if (taskConfig == null) {
                Intrinsics.throwUninitializedPropertyAccessException("config");
            }
            return taskConfig.getIsDebug();
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public final ThreadPoolExecutor getExecutorService$initscheduler_release() {
        ThreadPoolExecutor threadPoolExecutor = taskExecutor;
        if (threadPoolExecutor != null) {
            if (threadPoolExecutor == null) {
                Intrinsics.throwNpe();
            }
            return threadPoolExecutor;
        }
        TaskConfig taskConfig = config;
        if (taskConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("config");
        }
        ThreadPoolExecutor taskExecutor2 = taskConfig.getTaskExecutor();
        if (taskExecutor2 == null) {
            Intrinsics.throwNpe();
        }
        return taskExecutor2;
    }

    public final ThreadPoolExecutor getExecutorServiceOrNull$initscheduler_release() {
        ThreadPoolExecutor threadPoolExecutor = taskExecutor;
        if (threadPoolExecutor != null) {
            return threadPoolExecutor;
        }
        try {
            TaskConfig taskConfig = config;
            if (taskConfig == null) {
                Intrinsics.throwUninitializedPropertyAccessException("config");
            }
            return taskConfig.getTaskExecutor();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final ProcessMatchMode getProcessMatchMode$initscheduler_release() {
        TaskConfig taskConfig = config;
        if (taskConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("config");
        }
        return taskConfig.getMode();
    }

    public final boolean enableCatchException() {
        TaskConfig taskConfig = config;
        if (taskConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("config");
        }
        return taskConfig.getCatchException();
    }

    @JvmStatic
    public static final void afterPrivacyPopupWindow() {
        try {
            InitTaskDispatcher.INSTANCE.startPrivacyTask();
        } catch (Exception e) {
            e.printStackTrace();
            if (INSTANCE.enableCatchException()) {
                InitMonitor.INSTANCE.ensureNotReachHere(e, "START_DELAY_TASK_DISPATCHER");
            } else {
                throw e;
            }
        }
        TaskConfig taskConfig = config;
        if (taskConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException("config");
        }
        taskConfig.setAgreePrivacyPopupWindow(true);
    }

    @JvmStatic
    public static final void initTasks() {
        InitTraceUtil.INSTANCE.beginSection("initTasks");
        InitTaskDispatcher.INSTANCE.init();
        Unit unit = Unit.INSTANCE;
        InitTraceUtil.INSTANCE.endSection();
    }

    @JvmStatic
    public static final void initPeriodTask() {
        InitTraceUtil.INSTANCE.beginSection("initPeriodTask");
        PeriodTaskManager.INSTANCE.init();
        Unit unit = Unit.INSTANCE;
        InitTraceUtil.INSTANCE.endSection();
    }
}
