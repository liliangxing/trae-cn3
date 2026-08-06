package com.bytedance.lego.init.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PriorityInitTask.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0000H\u0096\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/bytedance/lego/init/model/PriorityInitTask;", "", "priority", "", "taskInfo", "Lcom/bytedance/lego/init/model/InitTaskInfo;", "(FLcom/bytedance/lego/init/model/InitTaskInfo;)V", "getPriority", "()F", "getTaskInfo", "()Lcom/bytedance/lego/init/model/InitTaskInfo;", "compareTo", "", "o", "initscheduler_release"}, k = 1, mv = {1, 1, 13})
/* loaded from: classes4.dex */
public final class PriorityInitTask implements Comparable<PriorityInitTask> {
    private final float priority;
    private final InitTaskInfo taskInfo;

    public PriorityInitTask(float f, InitTaskInfo taskInfo) {
        Intrinsics.checkParameterIsNotNull(taskInfo, "taskInfo");
        this.priority = f;
        this.taskInfo = taskInfo;
    }

    public final float getPriority() {
        return this.priority;
    }

    public final InitTaskInfo getTaskInfo() {
        return this.taskInfo;
    }

    @Override // java.lang.Comparable
    public int compareTo(PriorityInitTask o) {
        Intrinsics.checkParameterIsNotNull(o, "o");
        float f = o.priority - this.priority;
        float f2 = 0;
        if (f > f2) {
            return 1;
        }
        return f < f2 ? -1 : 0;
    }
}
