package com.bytedance.lego.init;

import com.bytedance.lego.init.model.InitPeriod;
import com.bytedance.lego.init.model.InitTaskInfo;
import com.bytedance.lego.init.monitor.Category;
import com.bytedance.lego.init.monitor.InitMonitor;
import com.bytedance.lego.init.util.InitLogger;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: InitTaskManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0014\u001a\u00020\u0004J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u0004J\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00182\u0006\u0010\u0014\u001a\u00020\u0004J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u0006\u0010\u001b\u001a\u00020\u0012J\b\u0010\u001c\u001a\u00020\u0012H\u0002J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\tH\u0002J\u000e\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\tJ\u0019\u0010!\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#¢\u0006\u0002\u0010$J\u0010\u0010%\u001a\u0004\u0018\u00010\t2\u0006\u0010&\u001a\u00020'J\u0014\u0010(\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\"\u001a\u00020#H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000fj\b\u0012\u0004\u0012\u00020\t`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/bytedance/lego/init/InitTaskManager;", "", "()V", "TAG", "", "completedTaskCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "nonUiReadyQueue", "Ljava/util/concurrent/PriorityBlockingQueue;", "Lcom/bytedance/lego/init/model/InitTaskInfo;", "readWriteLock", "taskIndex", "", "uiReadyQueue", "unDispatchTask", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "beforeSendMonitor", "", "getInitTaskInfoById", "taskId", "getPriorityByTaskId", "", "getTaskDependencyById", "", "hasNonUiTask", "", EventConstants.PARAM_SOURCE_INIT, "initReadyQueue", "letTaskReady", "taskInfo", "onTaskComplete", "task", "takeNonUiTaskIfExist", EventConstants.PARAM_TIME_OUT, "", "(Ljava/lang/Long;)Lcom/bytedance/lego/init/model/InitTaskInfo;", "takeNonUiTaskMainThreadIfExist", "period", "Lcom/bytedance/lego/init/model/InitPeriod;", "takeUiTaskIfExist", "initscheduler_release"}, k = 1, mv = {1, 1, 13})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class InitTaskManager {
    private Map<String, InitTaskInfo> taskIndex = new LinkedHashMap();
    private final ArrayList<InitTaskInfo> unDispatchTask = new ArrayList<>();
    private final PriorityBlockingQueue<InitTaskInfo> uiReadyQueue = new PriorityBlockingQueue<>();
    private final PriorityBlockingQueue<InitTaskInfo> nonUiReadyQueue = new PriorityBlockingQueue<>();
    private final Object readWriteLock = new Object();
    private AtomicInteger completedTaskCount = new AtomicInteger(0);
    private final String TAG = "InitTaskManager";

    public final void init() {
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, InitTaskInfo> initTaskIndexs = TaskCollectorManager.getInitTaskIndexs();
        Intrinsics.checkExpressionValueIsNotNull(initTaskIndexs, "TaskCollectorManager.getInitTaskIndexs()");
        this.taskIndex = initTaskIndexs;
        InitLogger.d$default(InitLogger.INSTANCE, null, "collect cos: " + (System.currentTimeMillis() - currentTimeMillis) + "ms  size: " + this.taskIndex.size(), 1, null);
        InitMonitor.INSTANCE.monitorCosTime("InitTaskManager.CollectTasks", System.currentTimeMillis() - currentTimeMillis, false);
        this.unDispatchTask.addAll(this.taskIndex.values());
        initReadyQueue();
        InitTaskDispatcher.INSTANCE.setHasNoneTask$initscheduler_release(this.taskIndex.isEmpty());
        InitMonitor.INSTANCE.monitorCosTime("InitTaskManager.init", System.currentTimeMillis() - currentTimeMillis, false);
    }

    public static /* synthetic */ InitTaskInfo takeUiTaskIfExist$default(InitTaskManager initTaskManager, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 5;
        }
        return initTaskManager.takeUiTaskIfExist(j);
    }

    public final InitTaskInfo takeUiTaskIfExist(long r3) {
        try {
            return this.uiReadyQueue.poll(r3, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static /* synthetic */ InitTaskInfo takeNonUiTaskIfExist$default(InitTaskManager initTaskManager, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            l = null;
        }
        return initTaskManager.takeNonUiTaskIfExist(l);
    }

    public final InitTaskInfo takeNonUiTaskIfExist(Long r4) {
        if (!hasNonUiTask()) {
            return null;
        }
        if (r4 != null) {
            return this.nonUiReadyQueue.poll(r4.longValue(), TimeUnit.MILLISECONDS);
        }
        return this.nonUiReadyQueue.take();
    }

    public final InitTaskInfo takeNonUiTaskMainThreadIfExist(InitPeriod period) {
        Intrinsics.checkParameterIsNotNull(period, "period");
        if (!hasNonUiTask()) {
            return null;
        }
        Iterator<InitTaskInfo> it = this.nonUiReadyQueue.iterator();
        Intrinsics.checkExpressionValueIsNotNull(it, "nonUiReadyQueue.iterator()");
        while (it.hasNext()) {
            InitTaskInfo next = it.next();
            InitPeriod initPeriod = next.endPeriod;
            Intrinsics.checkExpressionValueIsNotNull(initPeriod, "next.endPeriod");
            if (initPeriod.getValue() <= period.getValue()) {
                it.remove();
                return next;
            }
        }
        return null;
    }

    private final boolean hasNonUiTask() {
        synchronized (this.readWriteLock) {
            if (!this.nonUiReadyQueue.isEmpty()) {
                return true;
            }
            Iterator<T> it = this.unDispatchTask.iterator();
            while (it.hasNext()) {
                if (!((InitTaskInfo) it.next()).mustRunInMainThread) {
                    return true;
                }
            }
            return false;
        }
    }

    public final void onTaskComplete(InitTaskInfo task) {
        Intrinsics.checkParameterIsNotNull(task, "task");
        synchronized (this.readWriteLock) {
            if (task.isCompleted) {
                return;
            }
            task.isCompleted = true;
            this.completedTaskCount.getAndIncrement();
            List<String> list = task.child;
            if (list != null) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    InitTaskInfo initTaskInfo = this.taskIndex.get((String) it.next());
                    if (initTaskInfo != null && this.unDispatchTask.contains(initTaskInfo)) {
                        List<String> list2 = initTaskInfo.dependencies;
                        if (list2 != null) {
                            list2.remove(task.taskId);
                        }
                        if (initTaskInfo.dependencies == null || initTaskInfo.dependencies.isEmpty()) {
                            letTaskReady(initTaskInfo);
                        }
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void beforeSendMonitor() {
        try {
            if (this.completedTaskCount.get() != this.taskIndex.size()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("count", this.completedTaskCount.get() - this.taskIndex.size());
                jSONObject.put("undispatchCount", this.unDispatchTask.size());
                Iterator<T> it = this.unDispatchTask.iterator();
                while (it.hasNext()) {
                    jSONObject.put(((InitTaskInfo) it.next()).taskId, "task");
                }
                InitMonitor initMonitor = InitMonitor.INSTANCE;
                Category category = Category.TASK_COUNT_EXCEPTION;
                String valueOf = String.valueOf(this.completedTaskCount.get() - this.taskIndex.size());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("task_count_exception", jSONObject);
                initMonitor.monitorEvent(category, valueOf, jSONObject2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final InitTaskInfo getInitTaskInfoById(String taskId) {
        Intrinsics.checkParameterIsNotNull(taskId, "taskId");
        return this.taskIndex.get(taskId);
    }

    public final List<String> getTaskDependencyById(String taskId) {
        Intrinsics.checkParameterIsNotNull(taskId, "taskId");
        ArrayList arrayList = new ArrayList();
        synchronized (this.readWriteLock) {
            InitTaskInfo initTaskInfo = this.taskIndex.get(taskId);
            if (initTaskInfo != null) {
                List<String> list = initTaskInfo.dependencies;
                Intrinsics.checkExpressionValueIsNotNull(list, "it.dependencies");
                Boolean.valueOf(arrayList.addAll(list));
            }
        }
        return arrayList;
    }

    public final float getPriorityByTaskId(String taskId) {
        Intrinsics.checkParameterIsNotNull(taskId, "taskId");
        InitTaskInfo initTaskInfo = this.taskIndex.get(taskId);
        if (initTaskInfo != null) {
            return initTaskInfo.realPriority;
        }
        return -1.0f;
    }

    private final void initReadyQueue() {
        Collection<InitTaskInfo> values = this.taskIndex.values();
        if (values != null) {
            for (InitTaskInfo initTaskInfo : values) {
                if (initTaskInfo.dependencies == null || initTaskInfo.dependencies.isEmpty()) {
                    letTaskReady(initTaskInfo);
                }
            }
        }
    }

    private final void letTaskReady(InitTaskInfo taskInfo) {
        InitLogger.INSTANCE.m86d(this.TAG, "letTaskReady: " + taskInfo.taskId);
        if (taskInfo.mustRunInMainThread) {
            this.uiReadyQueue.add(taskInfo);
        } else {
            this.nonUiReadyQueue.add(taskInfo);
        }
        this.unDispatchTask.remove(taskInfo);
    }
}
