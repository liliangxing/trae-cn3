package com.bytedance.trae.init.task.base;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.apm.ApmAgent;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.util.ThreadUtils;
import com.bytedance.lego.init.model.InitTaskInfo;
import com.bytedance.lego.init.util.InitTaskExtendKt;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.trae.init.task.base.TaskDurationCollector;
import com.bytedance.trae.utils.StringKt;
import com.bytedance.trae.utils.logger.FLogger;
import java.util.Map;
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
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: InitTaskHelper.kt */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0010\u001a.\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\u00012\u0006\u0010$\u001a\u00020%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020!0'H\u0000\u001a\b\u0010(\u001a\u00020)H\u0002\u001a\u0010\u0010*\u001a\u00020!2\u0006\u0010+\u001a\u00020\u0019H\u0000\u001aV\u0010,\u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\u00012\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020)2\b\u00100\u001a\u0004\u0018\u00010\u00012\b\u00101\u001a\u0004\u0018\u00010\u00012\b\u00102\u001a\u0004\u0018\u00010\u00012\u0006\u00103\u001a\u00020\u00192\u0006\u00104\u001a\u00020.H\u0002\u001a,\u00105\u001a\u00020!2\b\u00100\u001a\u0004\u0018\u00010\u00012\b\u00101\u001a\u0004\u0018\u00010\u00012\u0006\u00106\u001a\u00020.2\u0006\u00107\u001a\u00020.H\u0002\u001a\"\u00108\u001a\u00020!2\u0006\u00109\u001a\u00020\u00012\u0006\u0010:\u001a\u00020.2\b\u0010;\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u001a\u0010<\u001a\u00020!2\u0006\u0010:\u001a\u00020.2\b\u0010;\u001a\u0004\u0018\u00010\u0001H\u0000\u001a\u001a\u0010=\u001a\u00020!2\u0006\u0010:\u001a\u00020.2\b\u0010;\u001a\u0004\u0018\u00010\u0001H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0016X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0016X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0019X\u0082T¢\u0006\u0002\n\u0000\"\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001d¨\u0006>"}, d2 = {"TAG", "", "EVENT_INIT_TASK_CUSTOM_MONITOR", "EVENT_INIT_TASK_SUSPICIOUS_MONITOR", "KEY_THREAD_NAME", "KEY_PROCESS_NAME", "KEY_TASK_NAME", "KEY_TASK_DURATION", "KEY_TASK_RESULT", "KEY_TASK_RUN_IN_MAIN", "KEY_TASK_STAGE", "KEY_TASK_STARTED", "KEY_TASK_COMPLETED", "KEY_TASK_SCENE", "KEY_FIRST_STYLE", "EVENT_APP_RECREATE", "KEY_RECREATE_TYPE", "KEY_RECREATE_RESULT", "KEY_ACTIVITY_NAME", "TYPE_PROCESS", "TYPE_ACTIVITY", "CORE_POOL_SIZE", "", "MAX_POOL_SIZE", "KEEP_ALIVE_SECONDS", "", "threadPoolExecutor", "Ljava/util/concurrent/ThreadPoolExecutor;", "getThreadPoolExecutor", "()Ljava/util/concurrent/ThreadPoolExecutor;", "threadPoolExecutor$delegate", "Lkotlin/Lazy;", "runWithMonitor", "", "scene", "style", "task", "Ljava/lang/Runnable;", "call", "Lkotlin/Function0;", "getCurrentAppLaunchStage", "Lcom/bytedance/trae/init/task/base/TaskDurationCollector$AppInitStage;", "checkSuspiciousTask", "processStartMillis", "monitorInitTask", "isMainThread", "", "stage", "taskName", "processName", "threadName", ReportConstant.COMMON_INIT_DURATION, "successful", "monitorSuspiciousTask", "taskStarted", "taskCompleted", "monitorAppRecreate", "type", "recreated", "activityName", "monitorProcessRecreate", "monitorActivityRecreate", "app_mainlandRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class InitTaskHelperKt {
    private static final int CORE_POOL_SIZE = 1;
    private static final String EVENT_APP_RECREATE = "app_recreate_monitor";
    private static final String EVENT_INIT_TASK_CUSTOM_MONITOR = "init_task_custom_monitor";
    private static final String EVENT_INIT_TASK_SUSPICIOUS_MONITOR = "init_task_suspicious_monitor";
    private static final long KEEP_ALIVE_SECONDS = 10;
    private static final String KEY_ACTIVITY_NAME = "activity_name";
    private static final String KEY_FIRST_STYLE = "task_first_style";
    private static final String KEY_PROCESS_NAME = "process_name";
    private static final String KEY_RECREATE_RESULT = "result";
    private static final String KEY_RECREATE_TYPE = "type";
    private static final String KEY_TASK_COMPLETED = "task_completed";
    private static final String KEY_TASK_DURATION = "task_duration";
    private static final String KEY_TASK_NAME = "task_name";
    private static final String KEY_TASK_RESULT = "task_result";
    private static final String KEY_TASK_RUN_IN_MAIN = "task_run_in_main";
    private static final String KEY_TASK_SCENE = "task_scene";
    private static final String KEY_TASK_STAGE = "task_stage";
    private static final String KEY_TASK_STARTED = "task_started";
    private static final String KEY_THREAD_NAME = "thread_name";
    private static final int MAX_POOL_SIZE = 1;
    private static final String TAG = "flow_init";
    private static final String TYPE_ACTIVITY = "activity";
    private static final String TYPE_PROCESS = "process";
    private static final Lazy threadPoolExecutor$delegate = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.init.task.base.InitTaskHelperKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            ThreadPoolExecutor threadPoolExecutor_delegate$lambda$1;
            threadPoolExecutor_delegate$lambda$1 = InitTaskHelperKt.threadPoolExecutor_delegate$lambda$1();
            return threadPoolExecutor_delegate$lambda$1;
        }
    });

    private static final ThreadPoolExecutor getThreadPoolExecutor() {
        return (ThreadPoolExecutor) threadPoolExecutor$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ThreadPoolExecutor threadPoolExecutor_delegate$lambda$1() {
        return new ThreadPoolExecutor(1, 1, KEEP_ALIVE_SECONDS, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.bytedance.trae.init.task.base.InitTaskHelperKt$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread threadPoolExecutor_delegate$lambda$1$lambda$0;
                threadPoolExecutor_delegate$lambda$1$lambda$0 = InitTaskHelperKt.threadPoolExecutor_delegate$lambda$1$lambda$0(runnable);
                return threadPoolExecutor_delegate$lambda$1$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread threadPoolExecutor_delegate$lambda$1$lambda$0(Runnable runnable) {
        return new Thread(runnable, "A-FlowInitLog");
    }

    public static final void runWithMonitor(String str, String str2, Runnable runnable, Function0<Unit> function0) {
        String str3;
        String str4;
        String str5;
        String str6;
        long currentTimeMillis;
        Intrinsics.checkNotNullParameter(str, "scene");
        Intrinsics.checkNotNullParameter(str2, "style");
        Intrinsics.checkNotNullParameter(runnable, "task");
        Intrinsics.checkNotNullParameter(function0, "call");
        String simpleName = runnable.getClass().getSimpleName();
        String name = Thread.currentThread().getName();
        String currentProcessName = ApmContext.getCurrentProcessName();
        long currentTimeMillis2 = System.currentTimeMillis();
        boolean isMainThread = ThreadUtils.isMainThread();
        TaskDurationCollector.AppInitStage currentAppLaunchStage = getCurrentAppLaunchStage();
        try {
            FLogger.INSTANCE.d(TAG, "[" + simpleName + "] start, thread:" + name + ", process:" + currentProcessName);
            function0.invoke();
            currentTimeMillis = System.currentTimeMillis() - currentTimeMillis2;
            FLogger.INSTANCE.d(TAG, "[" + simpleName + "] end success, duration:" + currentTimeMillis + "ms, thread:" + name + ", process:" + currentProcessName);
            str4 = currentProcessName;
        } catch (Throwable th) {
            th = th;
            str3 = TAG;
            str4 = currentProcessName;
        }
        try {
            TaskDurationCollector.INSTANCE.addTaskDuration(str, isMainThread, currentAppLaunchStage, simpleName, currentTimeMillis);
            str3 = TAG;
            str5 = simpleName;
            str6 = name;
            try {
                monitorInitTask(str, str2, isMainThread, currentAppLaunchStage, simpleName, str4, name, currentTimeMillis, true);
            } catch (Throwable th2) {
                th = th2;
                long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
                String str7 = str4;
                FLogger.INSTANCE.e(str3, "[" + str5 + "] end failure, duration:" + currentTimeMillis3 + "ms, thread:" + str6 + ", process:" + str7 + ", err:" + th.getMessage());
                String str8 = str5;
                TaskDurationCollector.INSTANCE.addTaskDuration(str, isMainThread, currentAppLaunchStage, str8, currentTimeMillis3);
                monitorInitTask(str, str2, isMainThread, currentAppLaunchStage, str8, str7, str6, currentTimeMillis3, false);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            str3 = TAG;
            str5 = simpleName;
            str6 = name;
            long currentTimeMillis32 = System.currentTimeMillis() - currentTimeMillis2;
            String str72 = str4;
            FLogger.INSTANCE.e(str3, "[" + str5 + "] end failure, duration:" + currentTimeMillis32 + "ms, thread:" + str6 + ", process:" + str72 + ", err:" + th.getMessage());
            String str82 = str5;
            TaskDurationCollector.INSTANCE.addTaskDuration(str, isMainThread, currentAppLaunchStage, str82, currentTimeMillis32);
            monitorInitTask(str, str2, isMainThread, currentAppLaunchStage, str82, str72, str6, currentTimeMillis32, false);
            throw th;
        }
    }

    private static final TaskDurationCollector.AppInitStage getCurrentAppLaunchStage() {
        if (!TaskDurationCollector.INSTANCE.isFirstFrame()) {
            return TaskDurationCollector.AppInitStage.FIRST_FRAME;
        }
        if (TaskDurationCollector.INSTANCE.isFirstFrame() && !TaskDurationCollector.INSTANCE.isFirstFeedShow()) {
            return TaskDurationCollector.AppInitStage.FIRST_FEED;
        }
        if (TaskDurationCollector.INSTANCE.isFirstFrame() && TaskDurationCollector.INSTANCE.isFirstFeedShow()) {
            return TaskDurationCollector.AppInitStage.OTHER;
        }
        return TaskDurationCollector.AppInitStage.DEFAULT;
    }

    public static final void checkSuspiciousTask(final long j) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.trae.init.task.base.InitTaskHelperKt$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                InitTaskHelperKt.checkSuspiciousTask$lambda$3(j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkSuspiciousTask$lambda$3(final long j) {
        getThreadPoolExecutor().execute(new Runnable() { // from class: com.bytedance.trae.init.task.base.InitTaskHelperKt$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                InitTaskHelperKt.checkSuspiciousTask$lambda$3$lambda$2(j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkSuspiciousTask$lambda$3$lambda$2(long j) {
        Map<String, InitTaskInfo> initTaskIndexs = TaskCollector.INSTANCE.getInitTaskIndexs();
        if (initTaskIndexs.isEmpty()) {
            FLogger.INSTANCE.d(TAG, "checkSuspiciousTask, getInitTaskIndexs is empty");
            return;
        }
        String currentProcessName = ApmContext.getCurrentProcessName();
        for (InitTaskInfo initTaskInfo : initTaskIndexs.values()) {
            if (initTaskInfo != null && !InitTaskExtendKt.isInternalTask(initTaskInfo)) {
                boolean z = initTaskInfo.startTime > j;
                boolean z2 = initTaskInfo.isCompleted;
                if (!z || !z2) {
                    String str = initTaskInfo.taskClassName;
                    int lastIndexOf$default = str != null ? StringsKt.lastIndexOf$default(str, '.', 0, false, 6, (Object) null) : -1;
                    if (lastIndexOf$default >= 0) {
                        Intrinsics.checkNotNull(str);
                        str = str.substring(lastIndexOf$default + 1);
                        Intrinsics.checkNotNullExpressionValue(str, "substring(...)");
                    }
                    FLogger.INSTANCE.d(TAG, "Suspicious task -> [" + str + "], started:" + z + ", completed:" + z2 + ", process:" + currentProcessName);
                    monitorSuspiciousTask(str, currentProcessName, z, z2);
                }
            }
        }
    }

    private static final void monitorInitTask(final String str, final String str2, final boolean z, final TaskDurationCollector.AppInitStage appInitStage, final String str3, final String str4, final String str5, final long j, final boolean z2) {
        getThreadPoolExecutor().execute(new Runnable() { // from class: com.bytedance.trae.init.task.base.InitTaskHelperKt$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                InitTaskHelperKt.monitorInitTask$lambda$6(str3, str4, str5, z2, z, appInitStage, str, str2, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void monitorInitTask$lambda$6(String str, String str2, String str3, boolean z, boolean z2, TaskDurationCollector.AppInitStage appInitStage, String str4, String str5, long j) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(KEY_TASK_NAME, StringKt.analysis(str));
        jSONObject.put(KEY_PROCESS_NAME, StringKt.analysis(str2));
        jSONObject.put(KEY_THREAD_NAME, StringKt.analysis(str3));
        jSONObject.put("task_result", z ? 1 : 0);
        jSONObject.put(KEY_TASK_RUN_IN_MAIN, z2);
        jSONObject.put(KEY_TASK_STAGE, appInitStage.getStage());
        jSONObject.put(KEY_TASK_SCENE, str4);
        jSONObject.put(KEY_FIRST_STYLE, str5);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(KEY_TASK_DURATION, j);
        Unit unit = Unit.INSTANCE;
        ApmAgent.monitorEvent(EVENT_INIT_TASK_CUSTOM_MONITOR, jSONObject, jSONObject2, (JSONObject) null);
    }

    private static final void monitorSuspiciousTask(String str, String str2, boolean z, boolean z2) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(KEY_TASK_NAME, StringKt.analysis(str));
        jSONObject.put(KEY_PROCESS_NAME, StringKt.analysis(str2));
        jSONObject.put(KEY_TASK_STARTED, z ? 1 : 0);
        jSONObject.put(KEY_TASK_COMPLETED, z2 ? 1 : 0);
        ApmAgent.monitorEvent(EVENT_INIT_TASK_SUSPICIOUS_MONITOR, jSONObject, (JSONObject) null, (JSONObject) null);
    }

    private static final void monitorAppRecreate(String str, boolean z, String str2) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", str);
        jSONObject.put("result", z ? 1 : 0);
        jSONObject.put(KEY_PROCESS_NAME, StringKt.analysis(ApmContext.getCurrentProcessName()));
        jSONObject.put(KEY_ACTIVITY_NAME, StringKt.analysis(str2));
        ApmAgent.monitorEvent(EVENT_APP_RECREATE, jSONObject, (JSONObject) null, (JSONObject) null);
    }

    public static final void monitorProcessRecreate(boolean z, String str) {
        monitorAppRecreate(TYPE_PROCESS, z, str);
    }

    public static final void monitorActivityRecreate(boolean z, String str) {
        monitorAppRecreate(TYPE_ACTIVITY, z, str);
    }
}
