package com.bytedance.rts.foundation;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import java.util.LinkedList;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Timer.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J-\u0010\t\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u0011J\u001b\u0010\u0012\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0000¢\u0006\u0002\b\u0013J\u0015\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u0016J\b\u0010\u0017\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/rts/foundation/RTSMessageLooper;", "", "()V", "handler", "Landroid/os/Handler;", "macroTaskQueue", "Ljava/util/Queue;", "Lcom/bytedance/rts/foundation/Task;", "mircoTaskQueue", "postMacroTask", StrategyConstants.ACTION, "Lkotlin/Function0;", "", "delayMillis", "", "isInterval", "", "postMacroTask$lib_release", "postMicroTask", "postMicroTask$lib_release", "removeMacroTask", "task", "removeMacroTask$lib_release", "runLoop", "lib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class RTSMessageLooper {
    private Queue<Task> macroTaskQueue = new LinkedList();
    private Handler handler = new Handler(Looper.getMainLooper());
    private Queue<Task> mircoTaskQueue = new LinkedList();

    /* JADX INFO: Access modifiers changed from: private */
    public final void runLoop() {
        while (!this.mircoTaskQueue.isEmpty()) {
            this.mircoTaskQueue.poll().run();
        }
        LinkedList linkedList = new LinkedList(this.macroTaskQueue);
        long j = Long.MAX_VALUE;
        while (!linkedList.isEmpty()) {
            Task task = (Task) linkedList.poll();
            if (task != null) {
                if (task.getNextTime() < SystemClock.uptimeMillis()) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    task.run();
                    while (!this.mircoTaskQueue.isEmpty()) {
                        Task poll = this.mircoTaskQueue.poll();
                        if (poll != null) {
                            poll.run();
                        }
                    }
                    if (task.getIsInterval() && this.macroTaskQueue.contains(task)) {
                        task.setNextTime(uptimeMillis + task.getTimeout());
                        if (j > task.getNextTime()) {
                            j = task.getNextTime();
                        }
                        this.macroTaskQueue.remove(task);
                        this.macroTaskQueue.add(task);
                    } else {
                        this.macroTaskQueue.remove(task);
                    }
                } else if (j > task.getNextTime()) {
                    j = task.getNextTime();
                }
            }
        }
        if (j != Long.MAX_VALUE) {
            this.handler.postAtTime(new Runnable() { // from class: com.bytedance.rts.foundation.RTSMessageLooper$runLoop$$inlined$Runnable$1
                @Override // java.lang.Runnable
                public final void run() {
                    RTSMessageLooper.this.runLoop();
                }
            }, j);
        }
    }

    public final Task postMicroTask$lib_release(Function0<Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        final Task task = new Task(action, this);
        this.mircoTaskQueue.add(task);
        this.handler.postAtFrontOfQueue(new Runnable() { // from class: com.bytedance.rts.foundation.RTSMessageLooper$postMicroTask$$inlined$Runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                Task.this.getSourceLooper().runLoop();
            }
        });
        return task;
    }

    public static /* synthetic */ Task postMacroTask$lib_release$default(RTSMessageLooper rTSMessageLooper, Function0 function0, long j, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return rTSMessageLooper.postMacroTask$lib_release(function0, j, z);
    }

    public final Task postMacroTask$lib_release(Function0<Unit> action, long delayMillis, boolean isInterval) {
        Intrinsics.checkNotNullParameter(action, "action");
        final Task task = new Task(action, this, delayMillis, isInterval);
        this.macroTaskQueue.add(task);
        this.handler.postDelayed(new Runnable() { // from class: com.bytedance.rts.foundation.RTSMessageLooper$postMacroTask$$inlined$Runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                Task.this.getSourceLooper().runLoop();
            }
        }, delayMillis);
        return task;
    }

    public final void removeMacroTask$lib_release(Task task) {
        Intrinsics.checkNotNullParameter(task, "task");
        this.macroTaskQueue.remove(task);
    }
}
