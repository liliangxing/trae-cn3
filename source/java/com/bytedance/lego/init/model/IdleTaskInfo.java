package com.bytedance.lego.init.model;

/* loaded from: classes4.dex */
public class IdleTaskInfo implements Comparable<IdleTaskInfo> {
    public boolean mustRunInMainThread;
    public int priority;
    public BaseIdleTask task;
    public String taskId;

    public IdleTaskInfo(String str, boolean z, int i, BaseIdleTask baseIdleTask) {
        this.taskId = str;
        this.mustRunInMainThread = z;
        this.priority = i;
        this.task = baseIdleTask;
    }

    @Override // java.lang.Comparable
    public int compareTo(IdleTaskInfo idleTaskInfo) {
        BaseIdleTask baseIdleTask;
        if (idleTaskInfo == null || (baseIdleTask = this.task) == null) {
            return 0;
        }
        int i = this.priority;
        int i2 = idleTaskInfo.priority;
        if (i > i2) {
            return -1;
        }
        if (i < i2) {
            return 1;
        }
        return baseIdleTask.getClass().getSimpleName().compareTo(idleTaskInfo.task.getClass().getSimpleName());
    }

    public String toString() {
        return "priority:" + this.priority + " taskClassName:" + this.task.getClass().getSimpleName() + " mustRunInMainThread:" + this.mustRunInMainThread;
    }
}
