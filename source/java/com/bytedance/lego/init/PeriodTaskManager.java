package com.bytedance.lego.init;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.lego.init.model.ExecutionPeriod;
import com.bytedance.lego.init.model.PeriodTaskInfo;
import com.bytedance.lego.init.monitor.InitMonitor;
import com.bytedance.lego.init.util.InitLogger;
import com.bytedance.lego.init.util.InitTraceUtil;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PeriodTaskManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\u0006H\u0002J\u0006\u0010\u0011\u001a\u00020\u000eJ\b\u0010\u0012\u001a\u00020\u000eH\u0002J\u0015\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u0016J\u0015\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/lego/init/PeriodTaskManager;", "", "()V", "TAG", "", "alreadyMainOnResume", "", "alreadySplashOnResume", "periodTaskMap", "", "Lcom/bytedance/lego/init/model/ExecutionPeriod;", "", "Lcom/bytedance/lego/init/model/PeriodTaskInfo;", "dispatchTasks", "", "executionPeriod", "shouldMonitor", EventConstants.PARAM_SOURCE_INIT, "printAllPeriodTasks", "registerMain", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "registerMain$initscheduler_release", "registerSplash", "registerSplash$initscheduler_release", "initscheduler_release"}, k = 1, mv = {1, 1, 13})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PeriodTaskManager {
    private static final String TAG = "PeriodTaskManager";
    private static volatile boolean alreadyMainOnResume;
    private static volatile boolean alreadySplashOnResume;
    public static final PeriodTaskManager INSTANCE = new PeriodTaskManager();
    private static final Map<ExecutionPeriod, List<PeriodTaskInfo>> periodTaskMap = new LinkedHashMap();

    private PeriodTaskManager() {
    }

    public final void init() {
        List<PeriodTaskInfo> allPeriodTaskInfo = TaskCollectorManager.getAllPeriodTaskInfo();
        Intrinsics.checkExpressionValueIsNotNull(allPeriodTaskInfo, "TaskCollectorManager.getAllPeriodTaskInfo()");
        for (PeriodTaskInfo periodTaskInfo : allPeriodTaskInfo) {
            Map<ExecutionPeriod, List<PeriodTaskInfo>> map = periodTaskMap;
            Intrinsics.checkExpressionValueIsNotNull(periodTaskInfo, "taskInfo");
            ArrayList arrayList = map.get(periodTaskInfo.getExecutionPeriod());
            if (arrayList == null) {
                arrayList = new ArrayList();
                ExecutionPeriod executionPeriod = periodTaskInfo.getExecutionPeriod();
                Intrinsics.checkExpressionValueIsNotNull(executionPeriod, "taskInfo.executionPeriod");
                map.put(executionPeriod, arrayList);
                Unit unit = Unit.INSTANCE;
            }
            if (arrayList != null) {
                arrayList.add(periodTaskInfo);
            }
        }
        printAllPeriodTasks();
    }

    public final void registerMain$initscheduler_release(Lifecycle lifecycle) {
        Intrinsics.checkParameterIsNotNull(lifecycle, "lifecycle");
        lifecycle.addObserver(new LifecycleObserver() { // from class: com.bytedance.lego.init.PeriodTaskManager$registerMain$1
            @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
            public final void onCreate() {
                boolean z;
                InitLogger.INSTANCE.m86d("PeriodTaskManager", "main - onCreate");
                PeriodTaskManager periodTaskManager = PeriodTaskManager.INSTANCE;
                ExecutionPeriod executionPeriod = ExecutionPeriod.MAIN_ON_CREATE;
                PeriodTaskManager periodTaskManager2 = PeriodTaskManager.INSTANCE;
                z = PeriodTaskManager.alreadyMainOnResume;
                periodTaskManager.dispatchTasks(executionPeriod, !z);
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_START)
            public final void onStart() {
                boolean z;
                InitLogger.INSTANCE.m86d("PeriodTaskManager", "main - onStart");
                PeriodTaskManager periodTaskManager = PeriodTaskManager.INSTANCE;
                ExecutionPeriod executionPeriod = ExecutionPeriod.MAIN_ON_START;
                PeriodTaskManager periodTaskManager2 = PeriodTaskManager.INSTANCE;
                z = PeriodTaskManager.alreadyMainOnResume;
                periodTaskManager.dispatchTasks(executionPeriod, !z);
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
            public final void onResume() {
                boolean z;
                InitLogger.INSTANCE.m86d("PeriodTaskManager", "main - onResume");
                PeriodTaskManager periodTaskManager = PeriodTaskManager.INSTANCE;
                ExecutionPeriod executionPeriod = ExecutionPeriod.MAIN_ON_RESUME;
                PeriodTaskManager periodTaskManager2 = PeriodTaskManager.INSTANCE;
                z = PeriodTaskManager.alreadyMainOnResume;
                periodTaskManager.dispatchTasks(executionPeriod, !z);
                PeriodTaskManager periodTaskManager3 = PeriodTaskManager.INSTANCE;
                PeriodTaskManager.alreadyMainOnResume = true;
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
            public final void onPause() {
                InitLogger.INSTANCE.m86d("PeriodTaskManager", "main - onPause");
                PeriodTaskManager.dispatchTasks$default(PeriodTaskManager.INSTANCE, ExecutionPeriod.MAIN_ON_PAUSE, false, 2, null);
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
            public final void onStop() {
                InitLogger.INSTANCE.m86d("PeriodTaskManager", "main - onStop");
                PeriodTaskManager.dispatchTasks$default(PeriodTaskManager.INSTANCE, ExecutionPeriod.MAIN_ON_STOP, false, 2, null);
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            public final void onDestroy() {
                InitLogger.INSTANCE.m86d("PeriodTaskManager", "main - onDestroy");
                try {
                    PeriodTaskManager.dispatchTasks$default(PeriodTaskManager.INSTANCE, ExecutionPeriod.MAIN_ON_DESTROY, false, 2, null);
                    InitScheduler.unRegisterMainActivity$initscheduler_release();
                } catch (Exception e) {
                    InitMonitor.INSTANCE.ensureNotReachHere(e, "MAIN_ON_DESTROY_EXCEPTION");
                }
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
            public final void onAny() {
                boolean z;
                PeriodTaskManager periodTaskManager = PeriodTaskManager.INSTANCE;
                ExecutionPeriod executionPeriod = ExecutionPeriod.MAIN_ON_ANY;
                PeriodTaskManager periodTaskManager2 = PeriodTaskManager.INSTANCE;
                z = PeriodTaskManager.alreadyMainOnResume;
                periodTaskManager.dispatchTasks(executionPeriod, !z);
            }
        });
    }

    public final void registerSplash$initscheduler_release(Lifecycle lifecycle) {
        Intrinsics.checkParameterIsNotNull(lifecycle, "lifecycle");
        lifecycle.addObserver(new LifecycleObserver() { // from class: com.bytedance.lego.init.PeriodTaskManager$registerSplash$1
            @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
            public final void onCreate() {
                boolean z;
                InitLogger.INSTANCE.m86d("PeriodTaskManager", "splash - onCreate");
                PeriodTaskManager periodTaskManager = PeriodTaskManager.INSTANCE;
                ExecutionPeriod executionPeriod = ExecutionPeriod.SPLASH_ON_CREATE;
                PeriodTaskManager periodTaskManager2 = PeriodTaskManager.INSTANCE;
                z = PeriodTaskManager.alreadySplashOnResume;
                periodTaskManager.dispatchTasks(executionPeriod, !z);
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_START)
            public final void onStart() {
                boolean z;
                InitLogger.INSTANCE.m86d("PeriodTaskManager", "splash - onStart");
                PeriodTaskManager periodTaskManager = PeriodTaskManager.INSTANCE;
                ExecutionPeriod executionPeriod = ExecutionPeriod.SPLASH_ON_START;
                PeriodTaskManager periodTaskManager2 = PeriodTaskManager.INSTANCE;
                z = PeriodTaskManager.alreadySplashOnResume;
                periodTaskManager.dispatchTasks(executionPeriod, !z);
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
            public final void onResume() {
                boolean z;
                InitLogger.INSTANCE.m86d("PeriodTaskManager", "splash - onResume");
                PeriodTaskManager periodTaskManager = PeriodTaskManager.INSTANCE;
                ExecutionPeriod executionPeriod = ExecutionPeriod.SPLASH_ON_RESUME;
                PeriodTaskManager periodTaskManager2 = PeriodTaskManager.INSTANCE;
                z = PeriodTaskManager.alreadySplashOnResume;
                periodTaskManager.dispatchTasks(executionPeriod, !z);
                PeriodTaskManager periodTaskManager3 = PeriodTaskManager.INSTANCE;
                PeriodTaskManager.alreadySplashOnResume = true;
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
            public final void onPause() {
                InitLogger.INSTANCE.m86d("PeriodTaskManager", "splash - onPause");
                PeriodTaskManager.dispatchTasks$default(PeriodTaskManager.INSTANCE, ExecutionPeriod.SPLASH_ON_PAUSE, false, 2, null);
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
            public final void onStop() {
                InitLogger.INSTANCE.m86d("PeriodTaskManager", "splash - onStop");
                PeriodTaskManager.dispatchTasks$default(PeriodTaskManager.INSTANCE, ExecutionPeriod.SPLASH_ON_STOP, false, 2, null);
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            public final void onDestroy() {
                InitLogger.INSTANCE.m86d("PeriodTaskManager", "splash - onDestroy");
                try {
                    PeriodTaskManager.dispatchTasks$default(PeriodTaskManager.INSTANCE, ExecutionPeriod.SPLASH_ON_DESTROY, false, 2, null);
                    InitScheduler.unRegisterSplashActivity$initscheduler_release();
                } catch (Exception e) {
                    InitMonitor.INSTANCE.ensureNotReachHere(e, "SPALSH_ON_DESTROY_EXCEPTION");
                }
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
            public final void onAny() {
                boolean z;
                PeriodTaskManager periodTaskManager = PeriodTaskManager.INSTANCE;
                ExecutionPeriod executionPeriod = ExecutionPeriod.SPLASH_ON_ANY;
                PeriodTaskManager periodTaskManager2 = PeriodTaskManager.INSTANCE;
                z = PeriodTaskManager.alreadySplashOnResume;
                periodTaskManager.dispatchTasks(executionPeriod, !z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void dispatchTasks$default(PeriodTaskManager periodTaskManager, ExecutionPeriod executionPeriod, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        periodTaskManager.dispatchTasks(executionPeriod, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatchTasks(ExecutionPeriod executionPeriod, boolean shouldMonitor) {
        List<PeriodTaskInfo> list = periodTaskMap.get(executionPeriod);
        if (list != null) {
            for (PeriodTaskInfo periodTaskInfo : list) {
                if (periodTaskInfo.getTask().mustRunInMainThread()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    InitTraceUtil initTraceUtil = InitTraceUtil.INSTANCE;
                    String taskId = periodTaskInfo.getTaskId();
                    Intrinsics.checkExpressionValueIsNotNull(taskId, "taskInfo.taskId");
                    initTraceUtil.beginSection(taskId);
                    periodTaskInfo.getTask().run();
                    InitTraceUtil.INSTANCE.endSection();
                    InitLogger.INSTANCE.m86d(TAG, "UIThread " + periodTaskInfo.getTaskId() + " done.");
                    if (shouldMonitor) {
                        InitMonitor.INSTANCE.monitorCosTime(periodTaskInfo, System.currentTimeMillis() - currentTimeMillis, true);
                    }
                } else {
                    InitScheduler.INSTANCE.getExecutorService$initscheduler_release().submit(periodTaskInfo.getTask());
                    InitLogger.INSTANCE.m86d(TAG, "ASYNC " + periodTaskInfo.getTaskId() + " submit.");
                    if (shouldMonitor) {
                        InitMonitor.INSTANCE.monitor(periodTaskInfo.getTaskId() + "-SUBMIT");
                    }
                }
            }
        }
    }

    private final void printAllPeriodTasks() {
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release()) {
            StringBuilder sb = new StringBuilder("------------------------------ AllPeriodTask --------------------------------\n");
            for (Map.Entry<ExecutionPeriod, List<PeriodTaskInfo>> entry : periodTaskMap.entrySet()) {
                if (!entry.getValue().isEmpty()) {
                    sb.append(entry.getKey().name() + ": ");
                    Iterator<T> it = entry.getValue().iterator();
                    while (it.hasNext()) {
                        sb.append(((PeriodTaskInfo) it.next()).getTaskId() + ' ');
                    }
                    sb.append("\n");
                }
            }
            InitLogger initLogger = InitLogger.INSTANCE;
            String sb2 = sb.toString();
            Intrinsics.checkExpressionValueIsNotNull(sb2, "totalInfo.toString()");
            initLogger.m86d(TAG, sb2);
        }
    }
}
