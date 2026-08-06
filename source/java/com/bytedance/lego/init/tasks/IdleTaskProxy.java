package com.bytedance.lego.init.tasks;

import android.util.Log;
import com.bytedance.lego.init.IdleTaskDispatcher;
import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.model.BaseIdleTask;
import com.bytedance.lego.init.monitor.IdleTaskMonitor;
import com.bytedance.lego.init.monitor.InitMonitor;
import com.bytedance.lego.init.util.InitLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IdleTaskProxy.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\b\u0010\u0011\u001a\u00020\tH\u0016R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/bytedance/lego/init/tasks/IdleTaskProxy;", "Lcom/bytedance/lego/init/model/BaseIdleTask;", "origin", "taskId", "", "uiThread", "", "executeFinish", "Lkotlin/Function0;", "", "(Lcom/bytedance/lego/init/model/BaseIdleTask;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;)V", "getExecuteFinish", "()Lkotlin/jvm/functions/Function0;", "getTaskId", "()Ljava/lang/String;", "getUiThread", "()Z", "run", "initscheduler_release"}, k = 1, mv = {1, 1, 13})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class IdleTaskProxy implements BaseIdleTask {
    private final Function0<Unit> executeFinish;
    private final BaseIdleTask origin;
    private final String taskId;
    private final boolean uiThread;

    public IdleTaskProxy(BaseIdleTask baseIdleTask, String str, boolean z, Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(baseIdleTask, "origin");
        Intrinsics.checkParameterIsNotNull(str, "taskId");
        Intrinsics.checkParameterIsNotNull(function0, "executeFinish");
        this.origin = baseIdleTask;
        this.taskId = str;
        this.uiThread = z;
        this.executeFinish = function0;
    }

    public final Function0<Unit> getExecuteFinish() {
        return this.executeFinish;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final boolean getUiThread() {
        return this.uiThread;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            IdleTaskMonitor.INSTANCE.monitorTaskStart(this.taskId, this.uiThread);
            this.origin.run();
            long currentTimeMillis2 = System.currentTimeMillis();
            IdleTaskMonitor.INSTANCE.monitorTaskEnd(this.taskId, this.uiThread);
            long j = currentTimeMillis2 - currentTimeMillis;
            IdleTaskMonitor.INSTANCE.monitorCostTime(this.taskId, j, this.uiThread);
            InitLogger.INSTANCE.m86d(IdleTaskDispatcher.TAG, this.taskId + " end. cos " + j + " ms.");
        } catch (Throwable th) {
            th.printStackTrace();
            InitLogger.INSTANCE.m88e(IdleTaskDispatcher.TAG, "\nerror!error!error!  " + this.taskId + " run error.\n");
            InitLogger initLogger = InitLogger.INSTANCE;
            String stackTraceString = Log.getStackTraceString(th);
            Intrinsics.checkExpressionValueIsNotNull(stackTraceString, "Log.getStackTraceString(e)");
            initLogger.m88e(IdleTaskDispatcher.TAG, stackTraceString);
            if (InitScheduler.INSTANCE.getConfig$initscheduler_release().getCatchException()) {
                InitMonitor.INSTANCE.ensureNotReachHere(th, "RUN_IDLE_TASK_EXCEPTION:" + this.taskId);
            } else {
                throw th;
            }
        }
        this.executeFinish.invoke();
    }
}
