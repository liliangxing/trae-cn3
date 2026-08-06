package com.bytedance.lego.init.model;

/* loaded from: classes4.dex */
public class PeriodTaskInfo {
    private String executionPeriod;
    private IPeriodTask task;
    private String taskId;

    public String getTaskId() {
        return this.taskId;
    }

    public IPeriodTask getTask() {
        return this.task;
    }

    public ExecutionPeriod getExecutionPeriod() {
        return ExecutionPeriod.from(this.executionPeriod);
    }

    public PeriodTaskInfo(String str, IPeriodTask iPeriodTask, String str2) {
        this.taskId = str;
        this.task = iPeriodTask;
        this.executionPeriod = str2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.taskId);
        sb.append(", " + this.task);
        sb.append(", " + this.executionPeriod);
        return sb.toString();
    }
}
