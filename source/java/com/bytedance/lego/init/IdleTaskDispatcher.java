package com.bytedance.lego.init;

import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import com.bytedance.lego.init.model.BaseIdleTask;
import com.bytedance.lego.init.model.IdleTaskInfo;
import com.bytedance.lego.init.monitor.IdleTaskMonitor;
import com.bytedance.lego.init.monitor.InitMonitor;
import com.bytedance.lego.init.tasks.IdleTaskProxy;
import com.bytedance.lego.init.util.InitLogger;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IdleTaskDispatcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Q\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u001a\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u0006\u0010\u0007\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\fJ\b\u0010!\u001a\u00020\bH\u0002J\b\u0010\"\u001a\u00020\bH\u0002J\b\u0010#\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R!\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR!\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016¨\u0006$"}, d2 = {"Lcom/bytedance/lego/init/IdleTaskDispatcher;", "", "()V", "TAG", "", "allTaskSize", "", "bootFinish", "", "completedTaskCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "idleTaskConfig", "Lcom/bytedance/lego/init/IdleTaskConfig;", "getIdleTaskConfig", "()Lcom/bytedance/lego/init/IdleTaskConfig;", "setIdleTaskConfig", "(Lcom/bytedance/lego/init/IdleTaskConfig;)V", "nonUiTaskList", "Ljava/util/ArrayList;", "Lcom/bytedance/lego/init/model/IdleTaskInfo;", "Lkotlin/collections/ArrayList;", "getNonUiTaskList", "()Ljava/util/ArrayList;", "timeoutHandler", "Landroid/os/Handler;", "uiIdleTaskHandler", "com/bytedance/lego/init/IdleTaskDispatcher$uiIdleTaskHandler$1", "Lcom/bytedance/lego/init/IdleTaskDispatcher$uiIdleTaskHandler$1;", "uiTaskList", "getUiTaskList", "asyncSendMonitorData", "", "config", "peekIdleTaskExecute", "peekNonUITaskExecute", "peekUITaskExecute", "initscheduler_release"}, k = 1, mv = {1, 1, 13})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class IdleTaskDispatcher {
    public static final String TAG = "IdleTaskDispatcher";
    private static int allTaskSize;
    private static volatile boolean bootFinish;
    public static final IdleTaskDispatcher INSTANCE = new IdleTaskDispatcher();
    private static IdleTaskConfig idleTaskConfig = IdleTaskConfig.INSTANCE.getDEFAULT_IDLETASK_CONFIG$initscheduler_release();
    private static final ArrayList<IdleTaskInfo> uiTaskList = new ArrayList<>();
    private static final ArrayList<IdleTaskInfo> nonUiTaskList = new ArrayList<>();
    private static volatile AtomicInteger completedTaskCount = new AtomicInteger(0);
    private static final Handler timeoutHandler = new Handler(Looper.getMainLooper());
    private static final IdleTaskDispatcher$uiIdleTaskHandler$1 uiIdleTaskHandler = new MessageQueue.IdleHandler() { // from class: com.bytedance.lego.init.IdleTaskDispatcher$uiIdleTaskHandler$1
        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            boolean z;
            IdleTaskDispatcher idleTaskDispatcher = IdleTaskDispatcher.INSTANCE;
            z = IdleTaskDispatcher.bootFinish;
            if (!z) {
                return true;
            }
            IdleTaskDispatcher.INSTANCE.peekIdleTaskExecute();
            return (IdleTaskDispatcher.INSTANCE.getNonUiTaskList().isEmpty() ^ true) || (IdleTaskDispatcher.INSTANCE.getUiTaskList().isEmpty() ^ true);
        }
    };

    private IdleTaskDispatcher() {
    }

    public final IdleTaskConfig getIdleTaskConfig() {
        return idleTaskConfig;
    }

    public final void setIdleTaskConfig(IdleTaskConfig idleTaskConfig2) {
        Intrinsics.checkParameterIsNotNull(idleTaskConfig2, "<set-?>");
        idleTaskConfig = idleTaskConfig2;
    }

    public final ArrayList<IdleTaskInfo> getUiTaskList() {
        return uiTaskList;
    }

    public final ArrayList<IdleTaskInfo> getNonUiTaskList() {
        return nonUiTaskList;
    }

    public final void config(IdleTaskConfig config) {
        Intrinsics.checkParameterIsNotNull(config, "config");
        if (InitScheduler.INSTANCE.getConfig$initscheduler_release().getIsMainProcess()) {
            bootFinish = false;
            idleTaskConfig = config;
            if (config.getAutoIdleTask()) {
                timeoutHandler.postDelayed(new Runnable() { // from class: com.bytedance.lego.init.IdleTaskDispatcher$config$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        InitScheduler.startDispatchIdleTask();
                    }
                }, idleTaskConfig.getBootFinishTimeOut());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean peekIdleTaskExecute() {
        boolean peekUITaskExecute = peekUITaskExecute();
        return !peekUITaskExecute ? peekNonUITaskExecute() : peekUITaskExecute;
    }

    private final boolean peekUITaskExecute() {
        int min = Math.min(uiTaskList.size(), idleTaskConfig.getUiThreadTaskNum());
        int i = 0;
        boolean z = false;
        while (i < min) {
            IdleTaskInfo remove = uiTaskList.remove(0);
            Intrinsics.checkExpressionValueIsNotNull(remove, "uiTaskList.removeAt(0)");
            IdleTaskInfo idleTaskInfo = remove;
            BaseIdleTask baseIdleTask = idleTaskInfo.task;
            Intrinsics.checkExpressionValueIsNotNull(baseIdleTask, "task.task");
            String str = idleTaskInfo.taskId;
            Intrinsics.checkExpressionValueIsNotNull(str, "task.taskId");
            new IdleTaskProxy(baseIdleTask, str, true, new Function0<Unit>() { // from class: com.bytedance.lego.init.IdleTaskDispatcher$peekUITaskExecute$1
                public /* bridge */ /* synthetic */ Object invoke() {
                    m697invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m697invoke() {
                    IdleTaskDispatcher.INSTANCE.asyncSendMonitorData();
                }
            }).run();
            i++;
            z = true;
        }
        return z;
    }

    private final boolean peekNonUITaskExecute() {
        int min = Math.min(nonUiTaskList.size(), idleTaskConfig.getNonUIThreadTaskNum());
        int i = 0;
        boolean z = false;
        while (i < min) {
            IdleTaskInfo remove = nonUiTaskList.remove(0);
            Intrinsics.checkExpressionValueIsNotNull(remove, "nonUiTaskList.removeAt(0)");
            final IdleTaskInfo idleTaskInfo = remove;
            InitSchedulerExecutorsKt.singleAsync(new Function0<Unit>() { // from class: com.bytedance.lego.init.IdleTaskDispatcher$peekNonUITaskExecute$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m695invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m695invoke() {
                    BaseIdleTask baseIdleTask = IdleTaskInfo.this.task;
                    Intrinsics.checkExpressionValueIsNotNull(baseIdleTask, "task.task");
                    String str = IdleTaskInfo.this.taskId;
                    Intrinsics.checkExpressionValueIsNotNull(str, "task.taskId");
                    new IdleTaskProxy(baseIdleTask, str, false, new Function0<Unit>() { // from class: com.bytedance.lego.init.IdleTaskDispatcher$peekNonUITaskExecute$1.1
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m696invoke();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: collision with other method in class */
                        public final void m696invoke() {
                            IdleTaskDispatcher.INSTANCE.asyncSendMonitorData();
                        }
                    }).run();
                }
            });
            i++;
            z = true;
        }
        return z;
    }

    public final void bootFinish() {
        if (InitScheduler.INSTANCE.getConfig$initscheduler_release().getIsMainProcess() && !bootFinish) {
            bootFinish = true;
            ArrayList<IdleTaskInfo> arrayList = uiTaskList;
            arrayList.addAll(TaskCollectorManager.getUiIdleTaskInfo());
            ArrayList<IdleTaskInfo> arrayList2 = nonUiTaskList;
            arrayList2.addAll(TaskCollectorManager.getNonUiIdleTaskInfo());
            int size = arrayList.size() + arrayList2.size();
            allTaskSize = size;
            if (size == 0) {
                return;
            }
            Looper.myQueue().addIdleHandler(uiIdleTaskHandler);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void asyncSendMonitorData() {
        if (completedTaskCount.incrementAndGet() != allTaskSize) {
            return;
        }
        InitSchedulerExecutorsKt.singleAsync(new Function0<Unit>() { // from class: com.bytedance.lego.init.IdleTaskDispatcher$asyncSendMonitorData$1
            public /* bridge */ /* synthetic */ Object invoke() {
                m694invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m694invoke() {
                try {
                    InitLogger.INSTANCE.m86d(IdleTaskDispatcher.TAG, "asyncSendMonitorData");
                    IdleTaskMonitor.INSTANCE.sendIdleTaskTaskMonitor();
                } catch (Throwable th) {
                    InitMonitor.INSTANCE.ensureNotReachHere(th, "IDLE_TASK_MONITOR_EXCEPTION");
                }
            }
        });
    }
}
