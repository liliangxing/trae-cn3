package com.bytedance.lego.init.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes4.dex */
public class DelayTaskInfo implements Serializable, Comparable<DelayTaskInfo> {

    @SerializedName("delayTime")
    public DelayTime delayTime;

    @SerializedName("moduleName")
    public String moduleName;

    @SerializedName("mustRunInMainThread")
    public boolean mustRunInMainThread;

    @SerializedName("priority")
    public int priority;

    @SerializedName("realPriority")
    public int realPriority;

    @SerializedName("runInProcess")
    public List<String> runInProcess;
    public transient IDelayTask task;

    @SerializedName(DBDefinition.TASK_ID)
    public String taskId;

    public DelayTaskInfo() {
    }

    public DelayTaskInfo(String str, String str2, IDelayTask iDelayTask, boolean z, List<String> list, int i, DelayTime delayTime) {
        this.taskId = str;
        this.moduleName = str2;
        this.task = iDelayTask;
        this.mustRunInMainThread = z;
        this.runInProcess = list;
        this.priority = i;
        this.delayTime = delayTime;
        this.realPriority = delayTime.getValue() - i;
    }

    @Override // java.lang.Comparable
    public int compareTo(DelayTaskInfo delayTaskInfo) {
        int i = this.realPriority;
        int i2 = delayTaskInfo.realPriority;
        if (i < i2) {
            return -1;
        }
        if (i > i2) {
            return 1;
        }
        return this.task.getClass().getSimpleName().compareTo(delayTaskInfo.task.getClass().getSimpleName());
    }

    public String toString() {
        return this.realPriority + "," + this.taskId + "," + this.mustRunInMainThread + "," + this.moduleName + "," + this.delayTime.name() + "," + this.priority + "," + listToString(this.runInProcess);
    }

    private String listToString(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder("[");
        sb.append(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            sb.append("," + list.get(i));
        }
        sb.append("]");
        return sb.toString();
    }
}
