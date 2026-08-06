package com.bytedance.lego.init;

import android.util.Log;
import com.bytedance.lego.init.model.FeedShowTaskInfo;
import com.bytedance.lego.init.monitor.FeedShowTaskMonitor;
import com.bytedance.lego.init.monitor.InitMonitor;
import com.bytedance.lego.init.util.InitLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FeedShowTaskDispatcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u000e\u001a\u00020\r2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u000bH\u0002J\b\u0010\u0014\u001a\u00020\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/lego/init/FeedShowTaskDispatcher;", "", "()V", "TAG", "", "allFeedShowTask", "", "Lcom/bytedance/lego/init/model/FeedShowTaskInfo;", "completedTaskCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "started", "", "onFeedShow", "", "printAllFeedShowTasks", "allFeedShowTaskInfo", "", "runTask", "taskInfo", "isUIThread", "sendMonitorData", "initscheduler_release"}, k = 1, mv = {1, 1, 13})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class FeedShowTaskDispatcher {
    private static final String TAG = "FeedShowTaskDispatcher";
    private static boolean started;
    public static final FeedShowTaskDispatcher INSTANCE = new FeedShowTaskDispatcher();
    private static volatile AtomicInteger completedTaskCount = new AtomicInteger(0);
    private static final List<FeedShowTaskInfo> allFeedShowTask = new ArrayList();

    private FeedShowTaskDispatcher() {
    }

    public final synchronized void onFeedShow() {
        if (started) {
            return;
        }
        started = true;
        new Thread(new Runnable() { // from class: com.bytedance.lego.init.FeedShowTaskDispatcher$onFeedShow$1
            @Override // java.lang.Runnable
            public final void run() {
                List list;
                List list2;
                List list3;
                List<FeedShowTaskInfo> list4;
                FeedShowTaskDispatcher feedShowTaskDispatcher = FeedShowTaskDispatcher.INSTANCE;
                list = FeedShowTaskDispatcher.allFeedShowTask;
                List<FeedShowTaskInfo> allFeedShowTaskInfo = TaskCollectorManager.getAllFeedShowTaskInfo();
                Intrinsics.checkExpressionValueIsNotNull(allFeedShowTaskInfo, "TaskCollectorManager.getAllFeedShowTaskInfo()");
                list.addAll(allFeedShowTaskInfo);
                FeedShowTaskDispatcher feedShowTaskDispatcher2 = FeedShowTaskDispatcher.INSTANCE;
                list2 = FeedShowTaskDispatcher.allFeedShowTask;
                CollectionsKt.sort(list2);
                FeedShowTaskDispatcher feedShowTaskDispatcher3 = FeedShowTaskDispatcher.INSTANCE;
                FeedShowTaskDispatcher feedShowTaskDispatcher4 = FeedShowTaskDispatcher.INSTANCE;
                list3 = FeedShowTaskDispatcher.allFeedShowTask;
                feedShowTaskDispatcher3.printAllFeedShowTasks(list3);
                FeedShowTaskDispatcher feedShowTaskDispatcher5 = FeedShowTaskDispatcher.INSTANCE;
                list4 = FeedShowTaskDispatcher.allFeedShowTask;
                for (final FeedShowTaskInfo feedShowTaskInfo : list4) {
                    if (!feedShowTaskInfo.mustRunInMainThread) {
                        FeedShowTaskDispatcher.INSTANCE.runTask(feedShowTaskInfo, false);
                    } else {
                        DelayTaskDispatcher.INSTANCE.getMainHandler().post(new Runnable() { // from class: com.bytedance.lego.init.FeedShowTaskDispatcher$onFeedShow$1$1$1
                            @Override // java.lang.Runnable
                            public final void run() {
                                FeedShowTaskDispatcher.INSTANCE.runTask(FeedShowTaskInfo.this, true);
                            }
                        });
                    }
                }
            }
        }, "A-FeedShowTaskDispatcher").start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void runTask(FeedShowTaskInfo taskInfo, boolean isUIThread) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            FeedShowTaskMonitor.INSTANCE.monitorTaskStart(taskInfo, isUIThread);
            InitLogger.INSTANCE.m86d(TAG, taskInfo.taskId + " start. isUIThread: " + isUIThread);
            taskInfo.task.run();
            long currentTimeMillis2 = System.currentTimeMillis();
            FeedShowTaskMonitor.INSTANCE.monitorTaskEnd(taskInfo, isUIThread);
            long j = currentTimeMillis2 - currentTimeMillis;
            FeedShowTaskMonitor.INSTANCE.monitorCosTime(taskInfo, j, isUIThread);
            InitLogger.INSTANCE.m86d(TAG, taskInfo.taskId + " end. cos " + j + " ms.");
            if (completedTaskCount.incrementAndGet() == allFeedShowTask.size()) {
                sendMonitorData();
            }
        } catch (Exception e) {
            e.printStackTrace();
            InitLogger.INSTANCE.m88e(TAG, "\nerror!error!error!  " + taskInfo.taskId + " run error.\n");
            InitLogger initLogger = InitLogger.INSTANCE;
            Exception exc = e;
            String stackTraceString = Log.getStackTraceString(exc);
            Intrinsics.checkExpressionValueIsNotNull(stackTraceString, "Log.getStackTraceString(e)");
            initLogger.m88e(TAG, stackTraceString);
            if (InitScheduler.INSTANCE.getConfig$initscheduler_release().getCatchException()) {
                InitMonitor.INSTANCE.ensureNotReachHere(exc, "RUN_FEED_SHOW_TASK_EXCEPTION:" + taskInfo.taskId);
                return;
            }
            throw exc;
        }
    }

    private final void sendMonitorData() {
        try {
            InitLogger.INSTANCE.m86d(TAG, "sendMonitorData");
            FeedShowTaskMonitor.INSTANCE.sendFeedShowTaskMonitor();
        } catch (Exception e) {
            InitMonitor.INSTANCE.ensureNotReachHere(e, "DELAY_TASK_MONITOR_EXCEPTION");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void printAllFeedShowTasks(List<? extends FeedShowTaskInfo> allFeedShowTaskInfo) {
        if (InitScheduler.INSTANCE.isDebug$initscheduler_release() && allFeedShowTaskInfo != null) {
            StringBuilder sb = new StringBuilder("\n-------------------------   AllFeedShowTasks   ------------------------\n");
            Iterator<T> it = allFeedShowTaskInfo.iterator();
            while (it.hasNext()) {
                sb.append(new StringBuilder().append((FeedShowTaskInfo) it.next()).append('\n').toString());
            }
            InitLogger initLogger = InitLogger.INSTANCE;
            String sb2 = sb.toString();
            Intrinsics.checkExpressionValueIsNotNull(sb2, "sb.toString()");
            initLogger.m86d(TAG, sb2);
        }
    }
}
