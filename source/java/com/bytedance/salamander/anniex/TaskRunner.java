package com.bytedance.salamander.anniex;

import com.bytedance.salamander.adapter.Lock;
import com.bytedance.salamander.adapter.Queue;
import com.bytedance.salamander.adapter.SLThread;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnniexMonitorUtilsTaskRunner.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007\b\u0016¢\u0006\u0002\u0010\u0002J/\u0010\u0005\u001a\u00020\u00062%\u0010\u0007\u001a!\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00060\bj\u0002`\rH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/salamander/anniex/TaskRunner;", "", "()V", "monitorQueue", "Lcom/bytedance/salamander/adapter/Queue;", "runTaskOnMonitorThread", "", "workLoad", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isCancelled", "Lcom/bytedance/salamander/adapter/Workload;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class TaskRunner {
    private static TaskRunner instance;
    private Queue monitorQueue = new Queue("anniex.salamander.monitor", true);

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static Lock instanceLock = new Lock();

    public void runTaskOnMonitorThread(Function1<? super Boolean, Unit> workLoad) {
        Intrinsics.checkNotNullParameter(workLoad, "workLoad");
        SLThread.Companion companion = SLThread.INSTANCE;
        Queue queue = this.monitorQueue;
        Intrinsics.checkNotNull(queue);
        SLThread.Companion.runOnThread$default(companion, workLoad, queue, 0.0d, 4, null);
    }

    /* compiled from: AnniexMonitorUtilsTaskRunner.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/salamander/anniex/TaskRunner$Companion;", "", "()V", "instance", "Lcom/bytedance/salamander/anniex/TaskRunner;", "instanceLock", "Lcom/bytedance/salamander/adapter/Lock;", "getInstance", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public TaskRunner getInstance() {
            if (TaskRunner.instance == null) {
                TaskRunner.instanceLock.lock();
                if (TaskRunner.instance != null) {
                    TaskRunner.instanceLock.unlock();
                } else {
                    Companion companion = TaskRunner.INSTANCE;
                    TaskRunner.instance = new TaskRunner();
                    TaskRunner.instanceLock.unlock();
                }
            }
            TaskRunner taskRunner = TaskRunner.instance;
            Intrinsics.checkNotNull(taskRunner);
            return taskRunner;
        }
    }
}
