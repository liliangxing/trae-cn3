package com.bytedance.lego.init.model;

import java.util.List;

/* loaded from: classes4.dex */
public class InitTaskInfo implements Comparable<InitTaskInfo> {
    public boolean afterPrivacyPopupWindow;
    public List<String> child;
    public List<String> dependencies;
    public volatile InitPeriod endPeriod;
    public volatile long endTime;
    public volatile boolean isCompleted;
    public String moduleName;
    public boolean mustRunInMainThread;
    public List<String> parent;
    public float realPriority;
    public List<String> runInProcess;
    public volatile long startTime;
    public IInitTask task;
    public String taskClassName;
    public String taskId;

    public InitTaskInfo() {
        this.realPriority = 0.0f;
    }

    public InitTaskInfo(String str, boolean z, boolean z2, float f, List<String> list, List<String> list2, List<String> list3, List<String> list4, String str2, InitPeriod initPeriod) {
        this.taskId = str;
        this.mustRunInMainThread = z;
        this.runInProcess = list;
        this.realPriority = f;
        this.child = list2;
        this.parent = list3;
        this.dependencies = list4;
        this.taskClassName = str2;
        this.endPeriod = initPeriod;
        this.afterPrivacyPopupWindow = z2;
    }

    public InitTaskInfo(String str, boolean z, boolean z2, float f, List<String> list, List<String> list2, List<String> list3, List<String> list4, String str2, IInitTask iInitTask, InitPeriod initPeriod) {
        this.taskId = str;
        this.mustRunInMainThread = z;
        this.runInProcess = list;
        this.realPriority = f;
        this.child = list2;
        this.parent = list3;
        this.dependencies = list4;
        this.taskClassName = str2;
        this.task = iInitTask;
        this.endPeriod = initPeriod;
        this.afterPrivacyPopupWindow = z2;
    }

    @Override // java.lang.Comparable
    public int compareTo(InitTaskInfo initTaskInfo) {
        float f = initTaskInfo.realPriority - this.realPriority;
        if (f > 0.0f) {
            return 1;
        }
        if (f < 0.0f) {
            return -1;
        }
        return this.taskClassName.compareTo(initTaskInfo.taskClassName);
    }

    public String toString() {
        return this.realPriority + "," + this.taskId + "," + this.mustRunInMainThread;
    }

    public String getFullContent() {
        return this.realPriority + "," + this.taskId + "," + this.mustRunInMainThread + "," + this.moduleName + "," + this.taskClassName + "," + listToString(this.runInProcess) + "," + listToString(this.dependencies) + "," + listToString(this.parent) + "," + listToString(this.parent);
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
