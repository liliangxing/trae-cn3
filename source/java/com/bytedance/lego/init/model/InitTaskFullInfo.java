package com.bytedance.lego.init.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes4.dex */
public class InitTaskFullInfo implements Serializable, Comparable<InitTaskFullInfo> {

    @SerializedName("afterPrivacyPopupWindow")
    public boolean afterPrivacyPopupWindow;
    public transient List<String> child;
    public transient List<String> dependencies;

    @SerializedName("dependon")
    public String[] dependon;

    @SerializedName("desc")
    public String desc;

    @SerializedName("earliestPeriod")
    public InitPeriod earliestPeriod;

    @SerializedName("executePriority")
    public int executePriority;

    @SerializedName("latestPeriod")
    public InitPeriod latestPeriod;

    @SerializedName("moduleName")
    public String moduleName;

    @SerializedName("mustRunInMainThread")
    public boolean mustRunInMainThread;
    public transient List<String> parent;
    public transient int priority;
    public transient float realPriority;

    @SerializedName("runInProcess")
    public List<String> runInProcess;

    @SerializedName("taskClassName")
    public String taskClassName;

    @SerializedName(DBDefinition.TASK_ID)
    public String taskId;

    public InitTaskFullInfo() {
        this.earliestPeriod = InitPeriod.APP_ATTACHBASE2SUPER;
        this.latestPeriod = InitPeriod.NONE;
        this.priority = -1;
        this.realPriority = 0.0f;
    }

    public InitTaskFullInfo(String str, Boolean bool, boolean z, InitPeriod initPeriod, InitPeriod initPeriod2, float f, List<String> list, List<String> list2, List<String> list3, List<String> list4, String str2) {
        this.earliestPeriod = InitPeriod.APP_ATTACHBASE2SUPER;
        this.latestPeriod = InitPeriod.NONE;
        this.priority = -1;
        this.realPriority = 0.0f;
        this.taskId = str;
        this.mustRunInMainThread = bool.booleanValue();
        this.earliestPeriod = initPeriod;
        this.latestPeriod = initPeriod2;
        this.realPriority = f;
        this.runInProcess = list;
        this.child = list2;
        this.parent = list3;
        this.dependencies = list4;
        this.taskClassName = str2;
        this.afterPrivacyPopupWindow = z;
    }

    @Override // java.lang.Comparable
    public int compareTo(InitTaskFullInfo initTaskFullInfo) {
        float f = initTaskFullInfo.realPriority - this.realPriority;
        if (f > 0.0f) {
            return 1;
        }
        if (f < 0.0f) {
            return -1;
        }
        return this.taskClassName.compareTo(initTaskFullInfo.taskClassName);
    }

    public String toString() {
        return this.realPriority + "," + this.taskId + "," + this.mustRunInMainThread + ",[" + getPeriodStr(this.earliestPeriod) + "," + getPeriodStr(this.latestPeriod) + "]," + arrayToString(this.dependon) + "," + listToString(this.runInProcess) + "," + this.moduleName;
    }

    public String getFullContent() {
        return this.realPriority + "," + this.taskId + "," + this.mustRunInMainThread + "," + this.moduleName + "," + this.taskClassName + "," + listToString(this.runInProcess) + "," + listToString(this.dependencies) + "," + listToString(this.child) + "," + listToString(this.parent);
    }

    private String getPeriodStr(InitPeriod initPeriod) {
        if (initPeriod == null) {
            return InitPeriod.NONE.name();
        }
        return initPeriod.name();
    }

    private String arrayToString(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder("[");
        sb.append(strArr[0]);
        for (int i = 1; i < strArr.length; i++) {
            sb.append("," + strArr[i]);
        }
        sb.append("]");
        return sb.toString();
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
