package com.bytedance.ies.bullet.service.base.init;

import com.bytedance.forest.model.PreloadConfig;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AbsLoaderTask.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/init/TaskStatus;", "", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "", "taskName", "", "(ILjava/lang/String;)V", "getStatusCode", "()I", "getTaskName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class TaskStatus {
    private final int statusCode;
    private final String taskName;

    public static /* synthetic */ TaskStatus copy$default(TaskStatus taskStatus, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = taskStatus.statusCode;
        }
        if ((i2 & 2) != 0) {
            str = taskStatus.taskName;
        }
        return taskStatus.copy(i, str);
    }

    /* renamed from: component1, reason: from getter */
    public final int getStatusCode() {
        return this.statusCode;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTaskName() {
        return this.taskName;
    }

    public final TaskStatus copy(int statusCode, String taskName) {
        Intrinsics.checkNotNullParameter(taskName, "taskName");
        return new TaskStatus(statusCode, taskName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskStatus)) {
            return false;
        }
        TaskStatus taskStatus = (TaskStatus) other;
        return this.statusCode == taskStatus.statusCode && Intrinsics.areEqual(this.taskName, taskStatus.taskName);
    }

    public int hashCode() {
        return (Integer.hashCode(this.statusCode) * 31) + this.taskName.hashCode();
    }

    public String toString() {
        return "TaskStatus(statusCode=" + this.statusCode + ", taskName=" + this.taskName + ')';
    }

    public TaskStatus(int i, String taskName) {
        Intrinsics.checkNotNullParameter(taskName, "taskName");
        this.statusCode = i;
        this.taskName = taskName;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final String getTaskName() {
        return this.taskName;
    }
}
