package com.bytedance.lego.init;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.bytedance.lego.init.model.IInitTask;
import com.bytedance.lego.init.model.InitPeriod;
import com.bytedance.lego.init.model.InitTaskInfo;
import com.bytedance.lego.init.monitor.Category;
import com.bytedance.lego.init.monitor.InitMonitor;
import com.bytedance.lego.init.util.InitLogger;
import com.bytedance.lego.init.util.InitTaskExtendKt;
import com.bytedance.lego.init.util.InitTraceUtil;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

/* compiled from: InitTaskDispatcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010'\u001a\u00020(J\u0018\u0010)\u001a\u00020\f2\u0006\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\fH\u0003J\u0006\u0010,\u001a\u00020(J\b\u0010-\u001a\u00020(H\u0002J\u0018\u0010.\u001a\u00020(2\u0006\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\fH\u0007J\b\u0010/\u001a\u00020(H\u0016J\u0010\u00100\u001a\u00020(2\u0006\u00101\u001a\u000202H\u0002J\u0010\u00103\u001a\u00020(2\u0006\u0010*\u001a\u00020\nH\u0002J\u0010\u00104\u001a\u00020(2\u0006\u00105\u001a\u000202H\u0002J\b\u00106\u001a\u00020(H\u0003J\u0006\u00107\u001a\u00020(J\u0018\u00108\u001a\u00020(2\u0006\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\fH\u0003R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0015\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/bytedance/lego/init/InitTaskDispatcher;", "Ljava/lang/Runnable;", "()V", "TAG", "", "afterPrivacyTask", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/bytedance/lego/init/ReadyTask;", "allPeriods", "", "Lcom/bytedance/lego/init/model/InitPeriod;", "asyncStarted", "", "dispatchThread", "Ljava/lang/Thread;", "executor", "Ljava/util/concurrent/ThreadPoolExecutor;", "getExecutor", "()Ljava/util/concurrent/ThreadPoolExecutor;", "executor$delegate", "Lkotlin/Lazy;", "hasNoneTask", "getHasNoneTask$initscheduler_release", "()Z", "setHasNoneTask$initscheduler_release", "(Z)V", "initTaskCountDownLatch", "Ljava/util/concurrent/CountDownLatch;", "inited", "lastUITaskEnd", "", "mainHandler", "Landroid/os/Handler;", "nonUITaskList", "nonUITaskListLock", "", "periodDoneList", "taskManager", "Lcom/bytedance/lego/init/InitTaskManager;", "beforeSendMonitor", "", "checkPeriod", "period", "isPeriodEnd", EventConstants.PARAM_SOURCE_INIT, "initInternal", "onPeriod", "run", "runTask", "taskInfo", "Lcom/bytedance/lego/init/model/InitTaskInfo;", "sendPeriodTimeoutException", "sendTaskTimeoutException", "task", "startAsyncTask", "startPrivacyTask", "takeTaskInMainThread", "initscheduler_release"}, k = 1, mv = {1, 1, 13})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class InitTaskDispatcher implements Runnable {
    private static final String TAG = "InitTaskDispatcher";
    private static boolean asyncStarted;
    private static Thread dispatchThread;
    private static boolean hasNoneTask;
    private static boolean inited;
    private static long lastUITaskEnd;
    static final /* synthetic */ KProperty[] $$delegatedProperties = {(KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(InitTaskDispatcher.class), "executor", "getExecutor()Ljava/util/concurrent/ThreadPoolExecutor;"))};
    public static final InitTaskDispatcher INSTANCE = new InitTaskDispatcher();
    private static final InitTaskManager taskManager = new InitTaskManager();

    /* renamed from: executor$delegate, reason: from kotlin metadata */
    private static final Lazy executor = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ThreadPoolExecutor>() { // from class: com.bytedance.lego.init.InitTaskDispatcher$executor$2
        public final ThreadPoolExecutor invoke() {
            return InitScheduler.INSTANCE.getExecutorService$initscheduler_release();
        }
    });
    private static final CountDownLatch initTaskCountDownLatch = new CountDownLatch(1);
    private static final List<InitPeriod> allPeriods = new ArrayList();
    private static final List<InitPeriod> periodDoneList = new ArrayList();
    private static final List<ReadyTask> nonUITaskList = new ArrayList();
    private static final Object nonUITaskListLock = new Object();
    private static final CopyOnWriteArrayList<ReadyTask> afterPrivacyTask = new CopyOnWriteArrayList<>();
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());

    private final ThreadPoolExecutor getExecutor() {
        Lazy lazy = executor;
        KProperty kProperty = $$delegatedProperties[0];
        return (ThreadPoolExecutor) lazy.getValue();
    }

    private InitTaskDispatcher() {
    }

    public static final /* synthetic */ CountDownLatch access$getInitTaskCountDownLatch$p(InitTaskDispatcher initTaskDispatcher) {
        return initTaskCountDownLatch;
    }

    public static final /* synthetic */ InitTaskManager access$getTaskManager$p(InitTaskDispatcher initTaskDispatcher) {
        return taskManager;
    }

    public final boolean getHasNoneTask$initscheduler_release() {
        return hasNoneTask;
    }

    public final void setHasNoneTask$initscheduler_release(boolean z) {
        hasNoneTask = z;
    }

    public final void init() {
        if (inited) {
            return;
        }
        initInternal();
    }

    public final void onPeriod(InitPeriod period, boolean isPeriodEnd) {
        Intrinsics.checkParameterIsNotNull(period, "period");
        long currentTimeMillis = System.currentTimeMillis();
        String str = isPeriodEnd ? "-END" : "-START";
        if (checkPeriod(period, isPeriodEnd)) {
            InitMonitor.INSTANCE.monitorStart(period.name() + str, true);
            InitTraceUtil.INSTANCE.beginSection("onPeriod-" + period.name() + str);
            if (!inited) {
                InitLogger.d$default(InitLogger.INSTANCE, null, "wait init countdownlatch " + period.name(), 1, null);
                long currentTimeMillis2 = System.currentTimeMillis();
                initTaskCountDownLatch.await();
                InitMonitor.INSTANCE.monitorCosTime(InitMonitor.WAIT_ASYNC_TASK_INIT, System.currentTimeMillis() - currentTimeMillis2, true);
                InitLogger.INSTANCE.m86d("InitTaskDispatcher", "wait initTaskCountDownLatch cos: " + (System.currentTimeMillis() - currentTimeMillis2));
            }
            if (hasNoneTask) {
                InitLogger.e$default(InitLogger.INSTANCE, null, "No task.", 1, null);
                return;
            }
            if (!asyncStarted) {
                startAsyncTask();
            }
            InitLogger.d$default(InitLogger.INSTANCE, null, "onPeriod: " + period.name() + str, 1, null);
            takeTaskInMainThread(period, isPeriodEnd);
            InitTraceUtil.INSTANCE.endSection();
            InitMonitor.INSTANCE.monitorEnd(period.name() + str, true);
            InitMonitor.INSTANCE.monitorCosTime("onPeriod-" + period.name() + str, System.currentTimeMillis() - currentTimeMillis, true);
        }
    }

    private final boolean checkPeriod(InitPeriod period, boolean isPeriodEnd) {
        Object obj;
        List<InitPeriod> list = allPeriods;
        if (list.contains(period)) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((InitPeriod) obj).getValue() >= period.getValue()) {
                break;
            }
        }
        if (((InitPeriod) obj) != null) {
            return false;
        }
        if (isPeriodEnd) {
            allPeriods.add(period);
        }
        return true;
    }

    private final void startAsyncTask() {
        InitLogger.INSTANCE.m86d("InitTaskDispatcher", "startAsyncTask");
        InitTraceUtil.INSTANCE.beginSection("startAsyncTask");
        Thread thread = new Thread(this);
        dispatchThread = thread;
        thread.start();
        asyncStarted = true;
        InitTraceUtil.INSTANCE.endSection();
    }

    private final void takeTaskInMainThread(InitPeriod period, boolean isPeriodEnd) {
        ReadyTask readyTask;
        while (!periodDoneList.contains(period)) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            if (isPeriodEnd) {
                objectRef.element = taskManager.takeUiTaskIfExist(0L);
                if (((InitTaskInfo) objectRef.element) == null) {
                    synchronized (nonUITaskListLock) {
                        Iterator<ReadyTask> it = nonUITaskList.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                readyTask = null;
                                break;
                            }
                            readyTask = it.next();
                            InitTaskManager initTaskManager = taskManager;
                            String str = readyTask.getInitTaskInfo().taskId;
                            Intrinsics.checkExpressionValueIsNotNull(str, "runnable.initTaskInfo.taskId");
                            float priorityByTaskId = initTaskManager.getPriorityByTaskId(str);
                            if (priorityByTaskId > 0) {
                                InitPeriod initPeriod = readyTask.getInitTaskInfo().endPeriod;
                                Intrinsics.checkExpressionValueIsNotNull(initPeriod, "runnable.initTaskInfo.endPeriod");
                                if (initPeriod.getValue() <= period.getValue() && priorityByTaskId > initTaskManager.getPriorityByTaskId(period.name() + Constants.END)) {
                                    it.remove();
                                    if (INSTANCE.getExecutor().remove(readyTask)) {
                                        InitLogger.d$default(InitLogger.INSTANCE, null, "execute async-task:" + readyTask.getInitTaskInfo().taskId + " in UIThread.", 1, null);
                                        break;
                                    }
                                }
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                    if (readyTask != null) {
                        readyTask.run();
                        lastUITaskEnd = System.currentTimeMillis();
                    }
                    if (readyTask == null) {
                        objectRef.element = taskManager.takeNonUiTaskMainThreadIfExist(period);
                    }
                }
                if (((InitTaskInfo) objectRef.element) == null) {
                    if (System.currentTimeMillis() - lastUITaskEnd >= InitScheduler.INSTANCE.getConfig$initscheduler_release().getTimeout()) {
                        InitLogger.d$default(InitLogger.INSTANCE, null, "UIThread wait timeout.", 1, null);
                        INSTANCE.sendPeriodTimeoutException(period);
                        try {
                            Iterator<T> it2 = taskManager.getTaskDependencyById(period.name() + Constants.END).iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                String str2 = (String) it2.next();
                                InitTaskManager initTaskManager2 = taskManager;
                                InitTaskInfo initTaskInfoById = initTaskManager2.getInitTaskInfoById(str2);
                                if (initTaskInfoById != null) {
                                    long currentTimeMillis = System.currentTimeMillis() - initTaskInfoById.startTime;
                                    if (initTaskInfoById.startTime > 0 && currentTimeMillis >= InitScheduler.INSTANCE.getConfig$initscheduler_release().getTimeout()) {
                                        initTaskManager2.onTaskComplete(initTaskInfoById);
                                        INSTANCE.sendTaskTimeoutException(initTaskInfoById);
                                        InitLogger.d$default(InitLogger.INSTANCE, null, "Task " + initTaskInfoById.taskId + " timeout, is forced to complete.", 1, null);
                                        break;
                                    }
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            if (InitScheduler.INSTANCE.getConfig$initscheduler_release().getCatchException()) {
                                InitMonitor.INSTANCE.ensureNotReachHere(e, "letTimeoutTaskCompele");
                            } else {
                                throw e;
                            }
                        }
                    }
                    Unit unit2 = Unit.INSTANCE;
                }
                if (((InitTaskInfo) objectRef.element) == null) {
                    continue;
                }
            } else {
                InitTaskInfo takeUiTaskIfExist = taskManager.takeUiTaskIfExist(0L);
                if (takeUiTaskIfExist == null) {
                    return;
                } else {
                    objectRef.element = takeUiTaskIfExist;
                }
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (InitTaskExtendKt.isInternalTask((InitTaskInfo) objectRef.element) || !InitTaskExtendKt.getSupportCurProcess((InitTaskInfo) objectRef.element)) {
                InitTraceUtil.INSTANCE.beginTask((InitTaskInfo) objectRef.element);
                InitLogger.d$default(InitLogger.INSTANCE, null, ((InitTaskInfo) objectRef.element).taskId + " complete directly. cos " + (System.currentTimeMillis() - currentTimeMillis2) + "ms", 1, null);
                taskManager.onTaskComplete((InitTaskInfo) objectRef.element);
                InitTraceUtil.INSTANCE.endTask();
                if (InitTaskExtendKt.isInternalTask((InitTaskInfo) objectRef.element) && Intrinsics.areEqual(period.name() + Constants.END, ((InitTaskInfo) objectRef.element).taskId)) {
                    InitMonitor.INSTANCE.monitorCosTime("wait: " + period.name(), System.currentTimeMillis() - lastUITaskEnd, true);
                    InitLogger.d$default(InitLogger.INSTANCE, null, "wait: " + period.name() + ' ' + (System.currentTimeMillis() - lastUITaskEnd) + "ms.", 1, null);
                    periodDoneList.add(period);
                    return;
                }
            } else if (((InitTaskInfo) objectRef.element).afterPrivacyPopupWindow && !InitScheduler.INSTANCE.getConfig$initscheduler_release().getAgreePrivacyPopupWindow()) {
                afterPrivacyTask.add(new ReadyTask(objectRef) { // from class: com.bytedance.lego.init.InitTaskDispatcher$takeTaskInMainThread$runnable$1
                    final /* synthetic */ Ref.ObjectRef $taskInfo;
                    private InitTaskInfo initTaskInfo;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.$taskInfo = objectRef;
                        this.initTaskInfo = (InitTaskInfo) objectRef.element;
                    }

                    @Override // com.bytedance.lego.init.ReadyTask
                    public InitTaskInfo getInitTaskInfo() {
                        return this.initTaskInfo;
                    }

                    @Override // com.bytedance.lego.init.ReadyTask
                    public void setInitTaskInfo(InitTaskInfo initTaskInfo) {
                        Intrinsics.checkParameterIsNotNull(initTaskInfo, "<set-?>");
                        this.initTaskInfo = initTaskInfo;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        InitTaskDispatcher.INSTANCE.runTask(getInitTaskInfo());
                    }
                });
                InitLogger.d$default(InitLogger.INSTANCE, null, ((InitTaskInfo) objectRef.element).taskId + " skip directly.", 1, null);
                taskManager.onTaskComplete((InitTaskInfo) objectRef.element);
            } else {
                runTask((InitTaskInfo) objectRef.element);
            }
            lastUITaskEnd = System.currentTimeMillis();
        }
    }

    public final void beforeSendMonitor() {
        taskManager.beforeSendMonitor();
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            InitTaskManager initTaskManager = taskManager;
            final InitTaskInfo takeNonUiTaskIfExist$default = InitTaskManager.takeNonUiTaskIfExist$default(initTaskManager, null, 1, null);
            if (takeNonUiTaskIfExist$default != null) {
                if (InitTaskExtendKt.isInternalTask(takeNonUiTaskIfExist$default) || !InitTaskExtendKt.getSupportCurProcess(takeNonUiTaskIfExist$default)) {
                    InitLogger.d$default(InitLogger.INSTANCE, null, takeNonUiTaskIfExist$default.taskId + " complete directly.", 1, null);
                    initTaskManager.onTaskComplete(takeNonUiTaskIfExist$default);
                } else {
                    ReadyTask readyTask = new ReadyTask() { // from class: com.bytedance.lego.init.InitTaskDispatcher$run$runnable$1
                        private InitTaskInfo initTaskInfo;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.initTaskInfo = InitTaskInfo.this;
                        }

                        @Override // com.bytedance.lego.init.ReadyTask
                        public InitTaskInfo getInitTaskInfo() {
                            return this.initTaskInfo;
                        }

                        @Override // com.bytedance.lego.init.ReadyTask
                        public void setInitTaskInfo(InitTaskInfo initTaskInfo) {
                            Intrinsics.checkParameterIsNotNull(initTaskInfo, "<set-?>");
                            this.initTaskInfo = initTaskInfo;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            InitTaskDispatcher.INSTANCE.runTask(getInitTaskInfo());
                        }
                    };
                    if (takeNonUiTaskIfExist$default.afterPrivacyPopupWindow && !InitScheduler.INSTANCE.getConfig$initscheduler_release().getAgreePrivacyPopupWindow()) {
                        afterPrivacyTask.add(readyTask);
                        InitLogger.d$default(InitLogger.INSTANCE, null, takeNonUiTaskIfExist$default.taskId + " skip directly.", 1, null);
                        initTaskManager.onTaskComplete(takeNonUiTaskIfExist$default);
                    } else {
                        getExecutor().execute(readyTask);
                        synchronized (nonUITaskListLock) {
                            nonUITaskList.add(readyTask);
                        }
                    }
                }
            } else {
                InitLogger.v$default(InitLogger.INSTANCE, null, "异步调度线程 end.", 1, null);
                return;
            }
        }
    }

    private final void sendPeriodTimeoutException(InitPeriod period) {
        try {
            StringBuilder sb = new StringBuilder();
            Iterator<T> it = taskManager.getTaskDependencyById(period.name() + Constants.END).iterator();
            while (it.hasNext()) {
                sb.append(((String) it.next()) + ' ');
            }
            InitMonitor initMonitor = InitMonitor.INSTANCE;
            Category category = Category.PERIOD_TIMEOUT_EXCEPTION;
            String name = period.name();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("dependencyTasks", sb.toString());
            initMonitor.monitorEvent(category, name, jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
            InitMonitor.INSTANCE.ensureNotReachHere(e, "sendPeriodTimeoutException");
        }
    }

    private final void sendTaskTimeoutException(InitTaskInfo task) {
        InitMonitor initMonitor = InitMonitor.INSTANCE;
        String str = task.taskId;
        Intrinsics.checkExpressionValueIsNotNull(str, "task.taskId");
        initMonitor.onTaskTimeout(str);
        InitMonitor initMonitor2 = InitMonitor.INSTANCE;
        Category category = Category.TASK_TIMEOUT_EXCEPTION;
        String str2 = task.taskId;
        Intrinsics.checkExpressionValueIsNotNull(str2, "task.taskId");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("startTime", task.startTime);
        jSONObject.put("curTime", System.currentTimeMillis());
        initMonitor2.monitorEvent(category, str2, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void runTask(InitTaskInfo taskInfo) {
        boolean areEqual = Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper());
        InitLogger.v$default(InitLogger.INSTANCE, null, "TaskStart - " + taskInfo + "  isUIThread:" + areEqual, 1, null);
        long currentTimeMillis = System.currentTimeMillis();
        taskInfo.startTime = currentTimeMillis;
        InitMonitor.INSTANCE.monitorTaskStart(taskInfo, areEqual);
        InitTraceUtil.INSTANCE.beginTask(taskInfo);
        try {
            if (taskInfo.task != null) {
                taskInfo.task.run();
            } else {
                Object newInstance = Class.forName(taskInfo.taskClassName).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                if (newInstance == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.bytedance.lego.init.model.IInitTask");
                }
                ((IInitTask) newInstance).run();
            }
        } catch (Exception e) {
            InitLogger initLogger = InitLogger.INSTANCE;
            StringBuilder append = new StringBuilder("\nerror!error!error! ").append(taskInfo.taskId).append(" run error.\n ");
            e.printStackTrace();
            initLogger.m88e("InitTaskDispatcher", append.append(Unit.INSTANCE).append(" \n").toString());
            if (InitScheduler.INSTANCE.getConfig$initscheduler_release().getCatchException() || (e instanceof ClassNotFoundException)) {
                Exception exc = e;
                InitMonitor.INSTANCE.ensureNotReachHere(exc, "RUN_TASK_EXCEPTION:" + taskInfo.taskClassName);
                InitMonitor initMonitor = InitMonitor.INSTANCE;
                Category category = Category.RUN_TAK_EXCEPTION;
                String str = taskInfo.taskClassName + ":" + e.getClass().getName();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("exception_detail", Log.getStackTraceString(exc));
                initMonitor.monitorEvent(category, str, jSONObject);
            } else {
                throw e;
            }
        }
        InitTraceUtil.INSTANCE.endTask();
        InitMonitor.INSTANCE.monitorTaskEnd(taskInfo, areEqual);
        long currentTimeMillis2 = System.currentTimeMillis();
        taskInfo.endTime = currentTimeMillis2;
        InitMonitor.INSTANCE.monitorCosTime(taskInfo, currentTimeMillis2 - currentTimeMillis, areEqual);
        InitLogger.d$default(InitLogger.INSTANCE, null, "Task " + taskInfo.taskId + " done. cos " + (System.currentTimeMillis() - currentTimeMillis) + "ms.", 1, null);
        taskManager.onTaskComplete(taskInfo);
    }

    public final void startPrivacyTask() {
        InitLogger.d$default(InitLogger.INSTANCE, null, "startPrivacyTask", 1, null);
        InitSchedulerExecutorsKt.singleAsync(new Function0<Unit>() { // from class: com.bytedance.lego.init.InitTaskDispatcher$startPrivacyTask$1
            public /* bridge */ /* synthetic */ Object invoke() {
                m700invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m700invoke() {
                CopyOnWriteArrayList<ReadyTask> copyOnWriteArrayList;
                Handler handler;
                InitTaskDispatcher initTaskDispatcher = InitTaskDispatcher.INSTANCE;
                copyOnWriteArrayList = InitTaskDispatcher.afterPrivacyTask;
                for (final ReadyTask readyTask : copyOnWriteArrayList) {
                    if (!readyTask.getInitTaskInfo().mustRunInMainThread) {
                        InitTaskDispatcher.INSTANCE.runTask(readyTask.getInitTaskInfo());
                    } else {
                        final CountDownLatch countDownLatch = new CountDownLatch(1);
                        InitTaskDispatcher initTaskDispatcher2 = InitTaskDispatcher.INSTANCE;
                        handler = InitTaskDispatcher.mainHandler;
                        handler.post(new Runnable() { // from class: com.bytedance.lego.init.InitTaskDispatcher$startPrivacyTask$1$1$1
                            @Override // java.lang.Runnable
                            public final void run() {
                                InitTaskDispatcher.INSTANCE.runTask(ReadyTask.this.getInitTaskInfo());
                                countDownLatch.countDown();
                            }
                        });
                        countDownLatch.await();
                    }
                }
            }
        });
    }

    private final void initInternal() {
        long currentTimeMillis = System.currentTimeMillis();
        if (InitLogger.INSTANCE.isDebug()) {
            InitLogger.INSTANCE.m92v("InitTaskDispatcher", "InitTaskDispatcher.init start");
        }
        InitMonitor.INSTANCE.monitorStart(InitMonitor.TASKDISPATCHER_INIT, false);
        InitTraceUtil.INSTANCE.beginSection("InitTaskDispatcher.initInternal");
        InitTaskDispatcher initTaskDispatcher = INSTANCE;
        access$getTaskManager$p(initTaskDispatcher).init();
        inited = true;
        access$getInitTaskCountDownLatch$p(initTaskDispatcher).countDown();
        Unit unit = Unit.INSTANCE;
        InitTraceUtil.INSTANCE.endSection();
        InitMonitor.INSTANCE.monitorEnd(InitMonitor.TASKDISPATCHER_INIT, false);
        InitMonitor.INSTANCE.monitorCosTime(InitMonitor.TASKDISPATCHER_INIT, System.currentTimeMillis() - currentTimeMillis, false);
        if (InitLogger.INSTANCE.isDebug()) {
            InitLogger.INSTANCE.m86d("InitTaskDispatcher", "InitTaskDispatcher.init done. cos: " + (System.currentTimeMillis() - currentTimeMillis) + "ms.");
        }
    }
}
