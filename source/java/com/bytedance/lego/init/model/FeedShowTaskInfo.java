package com.bytedance.lego.init.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.Serializable;

/* loaded from: classes4.dex */
public class FeedShowTaskInfo implements Serializable, Comparable<FeedShowTaskInfo> {

    @SerializedName("moduleName")
    public String moduleName;

    @SerializedName("mustRunInMainThread")
    public boolean mustRunInMainThread;

    @SerializedName("priority")
    public int priority;
    public transient BaseFeedShowTask task;

    @SerializedName(DBDefinition.TASK_ID)
    public String taskId;

    public FeedShowTaskInfo() {
    }

    public FeedShowTaskInfo(String str, String str2, BaseFeedShowTask baseFeedShowTask, boolean z, int i) {
        this.taskId = str;
        this.moduleName = str2;
        this.task = baseFeedShowTask;
        this.mustRunInMainThread = z;
        this.priority = i;
    }

    @Override // java.lang.Comparable
    public int compareTo(FeedShowTaskInfo feedShowTaskInfo) {
        int i = this.priority;
        int i2 = feedShowTaskInfo.priority;
        if (i < i2) {
            return 1;
        }
        if (i > i2) {
            return -1;
        }
        return this.task.getClass().getSimpleName().compareTo(feedShowTaskInfo.task.getClass().getSimpleName());
    }

    public String toString() {
        return this.priority + "," + this.taskId + "," + this.mustRunInMainThread + "," + this.moduleName;
    }
}
