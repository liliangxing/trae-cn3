package com.bytedance.lego.init;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.bytedance.ies.bullet.prefetchv2.PrefetchConfigKt;
import com.bytedance.lego.init.model.DelayTaskInfo;
import com.bytedance.lego.init.model.DelayTime;
import com.bytedance.lego.init.monitor.DelayTaskMonitor;
import com.bytedance.lego.init.monitor.InitMonitor;
import com.bytedance.lego.init.util.DelayTaskExtendKt;
import com.bytedance.lego.init.util.InitLogger;
import com.bytedance.pia.core.metrics.ErrorCode;
import com.bytedance.push.settings.StatisticsSettings;
import com.bytedance.trae.login.traeauth.TraeAuthManager;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DelayTaskDispatcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010 \u001a\u00020!2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015H\u0002J\b\u0010#\u001a\u00020!H\u0003J\u0018\u0010$\u001a\u00020!2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010&H\u0002J\u0018\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u0018H\u0002J\b\u0010*\u001a\u00020!H\u0002J\u0006\u0010+\u001a\u00020!R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/bytedance/lego/init/DelayTaskDispatcher;", "", "()V", "MSG_10min", "", "MSG_15min", "MSG_15s", "MSG_2min", "MSG_30s", "MSG_5min", "MSG_5s", "MSG_60s", "MSG_8s", "TAG", "", "allDelayTaskCount", "completedTaskCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "delayTaskMap", "", "Lcom/bytedance/lego/init/model/DelayTime;", "Ljava/util/PriorityQueue;", "Lcom/bytedance/lego/init/model/DelayTaskInfo;", "inited", "", "mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "onCreateEndTime", "", "started", "dispatchTask", "", "priorityQueue", "initDelayTasks", "printAllDelayTasks", "allDelayTaskInfo", "", "runTask", "taskInfo", "isUIThread", "sendMonitorData", TraeAuthManager.STAGE_START, "initscheduler_release"}, k = 1, mv = {1, 1, 13})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class DelayTaskDispatcher {
    private static final int MSG_10min = 1008;
    private static final int MSG_15min = 1009;
    private static final int MSG_15s = 1003;
    private static final int MSG_2min = 1006;
    private static final int MSG_30s = 1004;
    private static final int MSG_5min = 1007;
    private static final int MSG_5s = 1001;
    private static final int MSG_60s = 1005;
    private static final int MSG_8s = 1002;
    private static final String TAG = "DelayTaskDispatcher";
    private static volatile int allDelayTaskCount;
    private static volatile boolean inited;
    private static boolean started;
    public static final DelayTaskDispatcher INSTANCE = new DelayTaskDispatcher();
    private static final Map<DelayTime, PriorityQueue<DelayTaskInfo>> delayTaskMap = new LinkedHashMap();
    private static volatile AtomicInteger completedTaskCount = new AtomicInteger(0);
    private static long onCreateEndTime = -1;
    private static final Handler mainHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.bytedance.lego.init.DelayTaskDispatcher$mainHandler$1
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0137, code lost:
        
            return true;
         */
        @Override // android.os.Handler.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean handleMessage(Message message) {
            long j;
            long j2;
            long j3;
            long j4;
            long j5;
            long j6;
            long j7;
            long j8;
            long j9;
            switch (message.what) {
                case 1001:
                    InitLogger.INSTANCE.m86d("DelayTaskDispatcher", "Start dispatch 5s tasks...");
                    DelayTaskMonitor delayTaskMonitor = DelayTaskMonitor.INSTANCE;
                    long currentTimeMillis = System.currentTimeMillis();
                    DelayTaskDispatcher delayTaskDispatcher = DelayTaskDispatcher.INSTANCE;
                    j = DelayTaskDispatcher.onCreateEndTime;
                    delayTaskMonitor.monitor("Start_Dispatch_5s", currentTimeMillis - j, true);
                    InitSchedulerExecutorsKt.singleAsync(new Function0<Unit>() { // from class: com.bytedance.lego.init.DelayTaskDispatcher$mainHandler$1.1
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m684invoke();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: collision with other method in class */
                        public final void m684invoke() {
                            Map map;
                            DelayTaskDispatcher.INSTANCE.initDelayTasks();
                            DelayTaskDispatcher delayTaskDispatcher2 = DelayTaskDispatcher.INSTANCE;
                            DelayTaskDispatcher delayTaskDispatcher3 = DelayTaskDispatcher.INSTANCE;
                            map = DelayTaskDispatcher.delayTaskMap;
                            delayTaskDispatcher2.dispatchTask((PriorityQueue) map.get(DelayTime.SECOND_5));
                        }
                    });
                    break;
                case 1002:
                    InitLogger.INSTANCE.m86d("DelayTaskDispatcher", "Start dispatch 8s tasks...");
                    DelayTaskMonitor delayTaskMonitor2 = DelayTaskMonitor.INSTANCE;
                    long currentTimeMillis2 = System.currentTimeMillis();
                    DelayTaskDispatcher delayTaskDispatcher2 = DelayTaskDispatcher.INSTANCE;
                    j2 = DelayTaskDispatcher.onCreateEndTime;
                    delayTaskMonitor2.monitor("Start_Dispatch_8s", currentTimeMillis2 - j2, true);
                    InitSchedulerExecutorsKt.singleAsync(new Function0<Unit>() { // from class: com.bytedance.lego.init.DelayTaskDispatcher$mainHandler$1.2
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m685invoke();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: collision with other method in class */
                        public final void m685invoke() {
                            Map map;
                            DelayTaskDispatcher delayTaskDispatcher3 = DelayTaskDispatcher.INSTANCE;
                            DelayTaskDispatcher delayTaskDispatcher4 = DelayTaskDispatcher.INSTANCE;
                            map = DelayTaskDispatcher.delayTaskMap;
                            delayTaskDispatcher3.dispatchTask((PriorityQueue) map.get(DelayTime.SECOND_8));
                        }
                    });
                    break;
                case 1003:
                    DelayTaskMonitor delayTaskMonitor3 = DelayTaskMonitor.INSTANCE;
                    long currentTimeMillis3 = System.currentTimeMillis();
                    DelayTaskDispatcher delayTaskDispatcher3 = DelayTaskDispatcher.INSTANCE;
                    j3 = DelayTaskDispatcher.onCreateEndTime;
                    delayTaskMonitor3.monitor("Start_Dispatch_15s", currentTimeMillis3 - j3, true);
                    InitLogger.INSTANCE.m86d("DelayTaskDispatcher", "Start dispatch 15s tasks...");
                    InitSchedulerExecutorsKt.singleAsync(new Function0<Unit>() { // from class: com.bytedance.lego.init.DelayTaskDispatcher$mainHandler$1.3
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m686invoke();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: collision with other method in class */
                        public final void m686invoke() {
                            Map map;
                            DelayTaskDispatcher delayTaskDispatcher4 = DelayTaskDispatcher.INSTANCE;
                            DelayTaskDispatcher delayTaskDispatcher5 = DelayTaskDispatcher.INSTANCE;
                            map = DelayTaskDispatcher.delayTaskMap;
                            delayTaskDispatcher4.dispatchTask((PriorityQueue) map.get(DelayTime.SECOND_15));
                        }
                    });
                    break;
                case ErrorCode.PREFETCH_NOT_ENABLED /* 1004 */:
                    DelayTaskMonitor delayTaskMonitor4 = DelayTaskMonitor.INSTANCE;
                    long currentTimeMillis4 = System.currentTimeMillis();
                    DelayTaskDispatcher delayTaskDispatcher4 = DelayTaskDispatcher.INSTANCE;
                    j4 = DelayTaskDispatcher.onCreateEndTime;
                    delayTaskMonitor4.monitor("Start_Dispatch_30s", currentTimeMillis4 - j4, true);
                    InitLogger.INSTANCE.m86d("DelayTaskDispatcher", "Start dispatch 30s tasks...");
                    InitSchedulerExecutorsKt.singleAsync(new Function0<Unit>() { // from class: com.bytedance.lego.init.DelayTaskDispatcher$mainHandler$1.4
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m687invoke();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: collision with other method in class */
                        public final void m687invoke() {
                            Map map;
                            DelayTaskDispatcher delayTaskDispatcher5 = DelayTaskDispatcher.INSTANCE;
                            DelayTaskDispatcher delayTaskDispatcher6 = DelayTaskDispatcher.INSTANCE;
                            map = DelayTaskDispatcher.delayTaskMap;
                            delayTaskDispatcher5.dispatchTask((PriorityQueue) map.get(DelayTime.SECOND_30));
                        }
                    });
                    break;
                case 1005:
                    DelayTaskMonitor delayTaskMonitor5 = DelayTaskMonitor.INSTANCE;
                    long currentTimeMillis5 = System.currentTimeMillis();
                    DelayTaskDispatcher delayTaskDispatcher5 = DelayTaskDispatcher.INSTANCE;
                    j5 = DelayTaskDispatcher.onCreateEndTime;
                    delayTaskMonitor5.monitor("Start_Dispatch_60s", currentTimeMillis5 - j5, true);
                    InitLogger.INSTANCE.m86d("DelayTaskDispatcher", "Start dispatch 60s tasks...");
                    InitSchedulerExecutorsKt.singleAsync(new Function0<Unit>() { // from class: com.bytedance.lego.init.DelayTaskDispatcher$mainHandler$1.5
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m688invoke();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: collision with other method in class */
                        public final void m688invoke() {
                            Map map;
                            DelayTaskDispatcher delayTaskDispatcher6 = DelayTaskDispatcher.INSTANCE;
                            DelayTaskDispatcher delayTaskDispatcher7 = DelayTaskDispatcher.INSTANCE;
                            map = DelayTaskDispatcher.delayTaskMap;
                            delayTaskDispatcher6.dispatchTask((PriorityQueue) map.get(DelayTime.SECOND_60));
                        }
                    });
                    break;
                case 1006:
                    DelayTaskMonitor delayTaskMonitor6 = DelayTaskMonitor.INSTANCE;
                    long currentTimeMillis6 = System.currentTimeMillis();
                    DelayTaskDispatcher delayTaskDispatcher6 = DelayTaskDispatcher.INSTANCE;
                    j6 = DelayTaskDispatcher.onCreateEndTime;
                    delayTaskMonitor6.monitor("Start_Dispatch_2min", currentTimeMillis6 - j6, true);
                    InitLogger.INSTANCE.m86d("DelayTaskDispatcher", "Start dispatch 2min tasks...");
                    InitSchedulerExecutorsKt.singleAsync(new Function0<Unit>() { // from class: com.bytedance.lego.init.DelayTaskDispatcher$mainHandler$1.6
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m689invoke();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: collision with other method in class */
                        public final void m689invoke() {
                            Map map;
                            DelayTaskDispatcher delayTaskDispatcher7 = DelayTaskDispatcher.INSTANCE;
                            DelayTaskDispatcher delayTaskDispatcher8 = DelayTaskDispatcher.INSTANCE;
                            map = DelayTaskDispatcher.delayTaskMap;
                            delayTaskDispatcher7.dispatchTask((PriorityQueue) map.get(DelayTime.MINUTE_2));
                        }
                    });
                    break;
                case 1007:
                    DelayTaskMonitor delayTaskMonitor7 = DelayTaskMonitor.INSTANCE;
                    long currentTimeMillis7 = System.currentTimeMillis();
                    DelayTaskDispatcher delayTaskDispatcher7 = DelayTaskDispatcher.INSTANCE;
                    j7 = DelayTaskDispatcher.onCreateEndTime;
                    delayTaskMonitor7.monitor("Start_Dispatch_5min", currentTimeMillis7 - j7, true);
                    InitLogger.INSTANCE.m86d("DelayTaskDispatcher", "Start dispatch 5min tasks...");
                    InitSchedulerExecutorsKt.singleAsync(new Function0<Unit>() { // from class: com.bytedance.lego.init.DelayTaskDispatcher$mainHandler$1.7
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m690invoke();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: collision with other method in class */
                        public final void m690invoke() {
                            Map map;
                            DelayTaskDispatcher delayTaskDispatcher8 = DelayTaskDispatcher.INSTANCE;
                            DelayTaskDispatcher delayTaskDispatcher9 = DelayTaskDispatcher.INSTANCE;
                            map = DelayTaskDispatcher.delayTaskMap;
                            delayTaskDispatcher8.dispatchTask((PriorityQueue) map.get(DelayTime.MINUTE_5));
                        }
                    });
                    break;
                case ErrorCode.NO_VALID_NSR_RESULT /* 1008 */:
                    DelayTaskMonitor delayTaskMonitor8 = DelayTaskMonitor.INSTANCE;
                    long currentTimeMillis8 = System.currentTimeMillis();
                    DelayTaskDispatcher delayTaskDispatcher8 = DelayTaskDispatcher.INSTANCE;
                    j8 = DelayTaskDispatcher.onCreateEndTime;
                    delayTaskMonitor8.monitor("Start_Dispatch_10min", currentTimeMillis8 - j8, true);
                    InitLogger.INSTANCE.m86d("DelayTaskDispatcher", "Start dispatch 10min tasks...");
                    InitSchedulerExecutorsKt.singleAsync(new Function0<Unit>() { // from class: com.bytedance.lego.init.DelayTaskDispatcher$mainHandler$1.8
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m691invoke();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: collision with other method in class */
                        public final void m691invoke() {
                            Map map;
                            DelayTaskDispatcher delayTaskDispatcher9 = DelayTaskDispatcher.INSTANCE;
                            DelayTaskDispatcher delayTaskDispatcher10 = DelayTaskDispatcher.INSTANCE;
                            map = DelayTaskDispatcher.delayTaskMap;
                            delayTaskDispatcher9.dispatchTask((PriorityQueue) map.get(DelayTime.MINUTE_10));
                        }
                    });
                    break;
                case ErrorCode.NSR_EXECUTE_FAILED /* 1009 */:
                    DelayTaskMonitor delayTaskMonitor9 = DelayTaskMonitor.INSTANCE;
                    long currentTimeMillis9 = System.currentTimeMillis();
                    DelayTaskDispatcher delayTaskDispatcher9 = DelayTaskDispatcher.INSTANCE;
                    j9 = DelayTaskDispatcher.onCreateEndTime;
                    delayTaskMonitor9.monitor("Start_Dispatch_15min", currentTimeMillis9 - j9, true);
                    InitLogger.INSTANCE.m86d("DelayTaskDispatcher", "Start dispatch 15min tasks...");
                    InitSchedulerExecutorsKt.singleAsync(new Function0<Unit>() { // from class: com.bytedance.lego.init.DelayTaskDispatcher$mainHandler$1.9
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m692invoke();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: collision with other method in class */
                        public final void m692invoke() {
                            Map map;
                            DelayTaskDispatcher delayTaskDispatcher10 = DelayTaskDispatcher.INSTANCE;
                            DelayTaskDispatcher delayTaskDispatcher11 = DelayTaskDispatcher.INSTANCE;
                            map = DelayTaskDispatcher.delayTaskMap;
                            delayTaskDispatcher10.dispatchTask((PriorityQueue) map.get(DelayTime.MINUTE_15));
                        }
                    });
                    break;
            }
        }
    });

    private DelayTaskDispatcher() {
    }

    public final Handler getMainHandler() {
        return mainHandler;
    }

    public final synchronized void start() {
        if (started) {
            return;
        }
        started = true;
        onCreateEndTime = System.currentTimeMillis();
        InitLogger.INSTANCE.m86d(TAG, "start, curTime: " + onCreateEndTime);
        DelayTaskMonitor.INSTANCE.setOnCreateEnd(onCreateEndTime);
        Handler handler = mainHandler;
        handler.sendEmptyMessageDelayed(1001, com.bytedance.platform.thread.Constants.TASK_RUN_THRESHOLD);
        handler.sendEmptyMessageDelayed(1002, 8000L);
        handler.sendEmptyMessageDelayed(1003, 15000L);
        handler.sendEmptyMessageDelayed(1004, PrefetchConfigKt.DEFAULT_EXPIRE_MS);
        handler.sendEmptyMessageDelayed(1005, 60000L);
        handler.sendEmptyMessageDelayed(1006, 120000L);
        handler.sendEmptyMessageDelayed(1007, StatisticsSettings.DEFAULT_STATS_INTERVAL);
        handler.sendEmptyMessageDelayed(1008, 600000L);
        handler.sendEmptyMessageDelayed(1009, 900000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initDelayTasks() {
        if (inited) {
            return;
        }
        inited = true;
        InitLogger.INSTANCE.m86d(TAG, "initDelayTasks, curTimeFromCreateEnd: " + (System.currentTimeMillis() - onCreateEndTime));
        long currentTimeMillis = System.currentTimeMillis();
        List<DelayTaskInfo> allDelayTaskInfo = TaskCollectorManager.getAllDelayTaskInfo();
        if (allDelayTaskInfo != null) {
            for (DelayTaskInfo delayTaskInfo : allDelayTaskInfo) {
                Intrinsics.checkExpressionValueIsNotNull(delayTaskInfo, "delayTaskInfo");
                if (DelayTaskExtendKt.getSupportCurProcess(delayTaskInfo)) {
                    Map<DelayTime, PriorityQueue<DelayTaskInfo>> map = delayTaskMap;
                    if (map.get(delayTaskInfo.delayTime) == null) {
                        DelayTime delayTime = delayTaskInfo.delayTime;
                        Intrinsics.checkExpressionValueIsNotNull(delayTime, "delayTaskInfo.delayTime");
                        map.put(delayTime, new PriorityQueue<>());
                        Unit unit = Unit.INSTANCE;
                    }
                    PriorityQueue<DelayTaskInfo> priorityQueue = map.get(delayTaskInfo.delayTime);
                    if (priorityQueue != null) {
                        priorityQueue.add(delayTaskInfo);
                    }
                    allDelayTaskCount++;
                }
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        printAllDelayTasks(allDelayTaskInfo);
        long j = currentTimeMillis2 - currentTimeMillis;
        InitLogger.INSTANCE.m86d(TAG, "init cos: " + j);
        DelayTaskMonitor.INSTANCE.monitor("DelayTaskDispatcher.initDelayTasks", j, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dispatchTask(PriorityQueue<DelayTaskInfo> priorityQueue) {
        if (priorityQueue != null) {
            while (!priorityQueue.isEmpty()) {
                final DelayTaskInfo poll = priorityQueue.poll();
                InitSchedulerExecutorsKt.singleAsync(new Function0<Unit>() { // from class: com.bytedance.lego.init.DelayTaskDispatcher$dispatchTask$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m683invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m683invoke() {
                        if (!DelayTaskInfo.this.mustRunInMainThread) {
                            DelayTaskDispatcher delayTaskDispatcher = DelayTaskDispatcher.INSTANCE;
                            DelayTaskInfo delayTaskInfo = DelayTaskInfo.this;
                            Intrinsics.checkExpressionValueIsNotNull(delayTaskInfo, "task");
                            delayTaskDispatcher.runTask(delayTaskInfo, false);
                            return;
                        }
                        DelayTaskDispatcher.INSTANCE.getMainHandler().post(new Runnable() { // from class: com.bytedance.lego.init.DelayTaskDispatcher$dispatchTask$1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                DelayTaskDispatcher delayTaskDispatcher2 = DelayTaskDispatcher.INSTANCE;
                                DelayTaskInfo delayTaskInfo2 = DelayTaskInfo.this;
                                Intrinsics.checkExpressionValueIsNotNull(delayTaskInfo2, "task");
                                delayTaskDispatcher2.runTask(delayTaskInfo2, true);
                            }
                        });
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void runTask(DelayTaskInfo taskInfo, boolean isUIThread) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            DelayTaskMonitor.INSTANCE.monitorTaskStart(taskInfo, isUIThread);
            InitLogger.INSTANCE.m86d(TAG, taskInfo.taskId + " start. startTimeFromOnCreateEnd: " + (currentTimeMillis - onCreateEndTime));
            InitLogger.INSTANCE.m86d(TAG, taskInfo.taskId + " run. isUIThread: " + isUIThread);
            taskInfo.task.run();
            long currentTimeMillis2 = System.currentTimeMillis();
            DelayTaskMonitor.INSTANCE.monitorTaskEnd(taskInfo, isUIThread);
            long j = currentTimeMillis2 - currentTimeMillis;
            DelayTaskMonitor.INSTANCE.monitorCosTime(taskInfo, j, isUIThread);
            InitLogger.INSTANCE.m86d(TAG, taskInfo.taskId + " end. endTimeFromOnCreateEnd: " + (currentTimeMillis2 - onCreateEndTime) + ", cos " + j + " ms.");
            if (completedTaskCount.incrementAndGet() == allDelayTaskCount) {
                sendMonitorData();
            }
        } catch (Exception e) {
            InitLogger.INSTANCE.m88e(TAG, "\nerror!error!error!  " + taskInfo.taskId + " run error.\n");
            InitLogger initLogger = InitLogger.INSTANCE;
            Exception exc = e;
            String stackTraceString = Log.getStackTraceString(exc);
            Intrinsics.checkExpressionValueIsNotNull(stackTraceString, "Log.getStackTraceString(e)");
            initLogger.m88e(TAG, stackTraceString);
            if (!InitScheduler.INSTANCE.getConfig$initscheduler_release().getCatchException()) {
                throw exc;
            }
            InitMonitor.INSTANCE.ensureNotReachHere(exc, "RUN_DELAY_TASK_EXCEPTION:" + taskInfo.taskId);
        }
    }

    private final void sendMonitorData() {
        try {
            InitLogger.INSTANCE.m86d(TAG, "sendMonitorData");
            InitSchedulerExecutorsKt.singleAsync(new Function0<Unit>() { // from class: com.bytedance.lego.init.DelayTaskDispatcher$sendMonitorData$1
                public /* bridge */ /* synthetic */ Object invoke() {
                    m693invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m693invoke() {
                    DelayTaskMonitor.INSTANCE.sendDelayTaskMonitor();
                }
            });
        } catch (Exception e) {
            InitMonitor.INSTANCE.ensureNotReachHere(e, "DELAY_TASK_MONITOR_EXCEPTION");
        }
    }

    private final void printAllDelayTasks(List<? extends DelayTaskInfo> allDelayTaskInfo) {
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() && allDelayTaskInfo != null) {
            StringBuilder sb = new StringBuilder("\n-------------------------   AllDelayTasks   ------------------------\n");
            for (DelayTaskInfo delayTaskInfo : CollectionsKt.sorted(allDelayTaskInfo)) {
                if (DelayTaskExtendKt.getSupportCurProcess(delayTaskInfo)) {
                    sb.append(new StringBuilder().append(delayTaskInfo).append('\n').toString());
                }
            }
            InitLogger initLogger = InitLogger.INSTANCE;
            String sb2 = sb.toString();
            Intrinsics.checkExpressionValueIsNotNull(sb2, "sb.toString()");
            initLogger.m86d(TAG, sb2);
        }
    }
}
