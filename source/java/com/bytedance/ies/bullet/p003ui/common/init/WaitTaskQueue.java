package com.bytedance.ies.bullet.p003ui.common.init;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.init.AbsLoaderTask;
import com.bytedance.ies.bullet.service.base.init.ILoaderTasksCallBack;
import com.bytedance.ies.bullet.service.base.init.TaskStatus;
import com.bytedance.ies.bullet.service.base.init.TaskStyle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WaitTaskQueue.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\r\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\"\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\u0018\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\b\u001a\u0004\u0018\u00010\tJ\b\u0010\u001b\u001a\u00020\u000bH\u0002J\u0006\u0010\u001c\u001a\u00020\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ies/bullet/ui/common/init/WaitTaskQueue;", "", "loaderTasks", "", "Lcom/bytedance/ies/bullet/service/base/init/AbsLoaderTask;", "(Ljava/util/List;)V", "currentIndex", "", "initCallBack", "Lcom/bytedance/ies/bullet/service/base/init/ILoaderTasksCallBack;", "isTerminate", "", "mainHandler", "com/bytedance/ies/bullet/ui/common/init/WaitTaskQueue$mainHandler$1", "Lcom/bytedance/ies/bullet/ui/common/init/WaitTaskQueue$mainHandler$1;", "taskSize", "dealWithCallBack", "", "isSuccess", "code", "taskStatus", "Lcom/bytedance/ies/bullet/service/base/init/TaskStatus;", "getASyncTaskQueue", "getSyncTaskQueue", "initTasks", "context", "Lcom/bytedance/ies/bullet/core/BulletContext;", "isAllLoaderTasksReady", "isTasksAllReady", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class WaitTaskQueue {
    private static final long WAIT_QUEUE_TIME_OUT = 50000;
    private int currentIndex;
    private ILoaderTasksCallBack initCallBack;
    private boolean isTerminate;
    private final List<AbsLoaderTask> loaderTasks;
    private final WaitTaskQueue$mainHandler$1 mainHandler;
    private int taskSize;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.ies.bullet.ui.common.init.WaitTaskQueue$mainHandler$1] */
    public WaitTaskQueue(List<? extends AbsLoaderTask> list) {
        Intrinsics.checkNotNullParameter(list, "loaderTasks");
        this.loaderTasks = list;
        final Looper mainLooper = Looper.getMainLooper();
        this.mainHandler = new Handler(mainLooper) { // from class: com.bytedance.ies.bullet.ui.common.init.WaitTaskQueue$mainHandler$1
            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                TaskStatus taskStatus;
                int i;
                int i2;
                int i3;
                int i4;
                int i5;
                Intrinsics.checkNotNullParameter(msg, "msg");
                if (msg.obj instanceof TaskStatus) {
                    Object obj = msg.obj;
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.bytedance.ies.bullet.service.base.init.TaskStatus");
                    taskStatus = (TaskStatus) obj;
                } else {
                    taskStatus = null;
                }
                int i6 = msg.what;
                if (i6 != 1) {
                    if (i6 == 2) {
                        removeMessages(3);
                        BulletLogger.printLog$default(BulletLogger.INSTANCE, "onInitFailed, task " + (taskStatus != null ? taskStatus.getTaskName() : null), null, null, 6, null);
                        WaitTaskQueue.this.dealWithCallBack(false, msg.what, taskStatus);
                        return;
                    } else {
                        if (i6 != 3) {
                            return;
                        }
                        BulletLogger.printLog$default(BulletLogger.INSTANCE, "onInitFailed, timeout", null, null, 6, null);
                        WaitTaskQueue waitTaskQueue = WaitTaskQueue.this;
                        int i7 = msg.what;
                        if (taskStatus == null) {
                            taskStatus = new TaskStatus(-2, "");
                        }
                        waitTaskQueue.dealWithCallBack(false, i7, taskStatus);
                        return;
                    }
                }
                WaitTaskQueue waitTaskQueue2 = WaitTaskQueue.this;
                i = waitTaskQueue2.currentIndex;
                waitTaskQueue2.currentIndex = i + 1;
                BulletLogger bulletLogger = BulletLogger.INSTANCE;
                StringBuilder sb = new StringBuilder("sync call back onInitSuccess, taskSize:");
                i2 = WaitTaskQueue.this.taskSize;
                StringBuilder append = sb.append(i2).append(", currentIndex :");
                i3 = WaitTaskQueue.this.currentIndex;
                BulletLogger.printLog$default(bulletLogger, append.append(i3).toString(), null, null, 6, null);
                i4 = WaitTaskQueue.this.taskSize;
                i5 = WaitTaskQueue.this.currentIndex;
                if (i4 == i5) {
                    removeMessages(3);
                    BulletLogger.printLog$default(BulletLogger.INSTANCE, "onInitSuccess", null, null, 6, null);
                    WaitTaskQueue.this.dealWithCallBack(true, msg.what, taskStatus);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dealWithCallBack(boolean isSuccess, int code, TaskStatus taskStatus) {
        if (!this.isTerminate) {
            if (isSuccess) {
                ILoaderTasksCallBack iLoaderTasksCallBack = this.initCallBack;
                if (iLoaderTasksCallBack != null) {
                    iLoaderTasksCallBack.onInitSuccess();
                }
            } else {
                ILoaderTasksCallBack iLoaderTasksCallBack2 = this.initCallBack;
                if (iLoaderTasksCallBack2 != null) {
                    iLoaderTasksCallBack2.onInitFailed(code, taskStatus);
                }
            }
        }
        this.isTerminate = true;
    }

    public final boolean isTasksAllReady() {
        Iterator<T> it = this.loaderTasks.iterator();
        while (it.hasNext()) {
            if (!Intrinsics.areEqual(((AbsLoaderTask) it.next()).isTaskAlready(), true)) {
                return false;
            }
        }
        return true;
    }

    public final void initTasks(BulletContext context, ILoaderTasksCallBack initCallBack) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.initCallBack = initCallBack;
        this.isTerminate = false;
        if (this.loaderTasks.isEmpty()) {
            if (initCallBack != null) {
                initCallBack.onInitSuccess();
                return;
            }
            return;
        }
        if (isAllLoaderTasksReady()) {
            if (initCallBack != null) {
                initCallBack.onStateChange(1);
            }
            if (initCallBack != null) {
                initCallBack.onInitSuccess();
                return;
            }
            return;
        }
        for (AbsLoaderTask absLoaderTask : getASyncTaskQueue()) {
            Boolean isTaskAlready = absLoaderTask.isTaskAlready();
            context.getContainerContext().getLoaderTaskPerfMetric().recordTaskIsReady(absLoaderTask.name(), Intrinsics.areEqual(isTaskAlready, true));
            if (!Intrinsics.areEqual(isTaskAlready, true)) {
                absLoaderTask.startTask(context, null);
                if (Intrinsics.areEqual(absLoaderTask.interceptWhenNotReady(), true) && initCallBack != null) {
                    initCallBack.onInitFailed(-3, new TaskStatus(-3, absLoaderTask.name()));
                }
            }
        }
        List<AbsLoaderTask> syncTaskQueue = getSyncTaskQueue();
        removeMessages(3);
        int i = 0;
        boolean z = true;
        for (Object obj : syncTaskQueue) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            AbsLoaderTask absLoaderTask2 = (AbsLoaderTask) obj;
            Boolean isTaskAlready2 = absLoaderTask2.isTaskAlready();
            context.getContainerContext().getLoaderTaskPerfMetric().recordTaskIsReady(absLoaderTask2.name(), Intrinsics.areEqual(isTaskAlready2, true));
            if (!Intrinsics.areEqual(isTaskAlready2, true)) {
                this.taskSize++;
                absLoaderTask2.startTask(context, this.mainHandler);
                z = false;
            }
            i = i2;
        }
        if (z) {
            dealWithCallBack(true, 1, null);
        } else {
            sendEmptyMessageDelayed(3, WAIT_QUEUE_TIME_OUT);
        }
    }

    private final boolean isAllLoaderTasksReady() {
        Iterator<T> it = this.loaderTasks.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(((AbsLoaderTask) it.next()).isTaskAlready(), false)) {
                return false;
            }
        }
        return true;
    }

    private final List<AbsLoaderTask> getASyncTaskQueue() {
        List<AbsLoaderTask> list = this.loaderTasks;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((AbsLoaderTask) obj).getTaskStyle() == TaskStyle.Async) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final List<AbsLoaderTask> getSyncTaskQueue() {
        List<AbsLoaderTask> list = this.loaderTasks;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((AbsLoaderTask) obj).getTaskStyle() == TaskStyle.Sync) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
