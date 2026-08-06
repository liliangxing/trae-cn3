package com.bytedance.trae.im.service;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ISubTaskResultApi.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/im/service/SubTaskResultResponse;", "", DBDefinition.TASK_ID, "", "<init>", "(Ljava/lang/String;)V", "getTaskId", "()Ljava/lang/String;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SubTaskResultResponse {

    @SerializedName(NewTaskTracker.Param.TASK_ID)
    private final String taskId;

    /* JADX WARN: Multi-variable type inference failed */
    public SubTaskResultResponse() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SubTaskResultResponse copy$default(SubTaskResultResponse subTaskResultResponse, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = subTaskResultResponse.taskId;
        }
        return subTaskResultResponse.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    public final SubTaskResultResponse copy(String taskId) {
        return new SubTaskResultResponse(taskId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof SubTaskResultResponse) && Intrinsics.areEqual(this.taskId, ((SubTaskResultResponse) other).taskId);
    }

    public int hashCode() {
        String str = this.taskId;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "SubTaskResultResponse(taskId=" + this.taskId + ')';
    }

    public SubTaskResultResponse(String str) {
        this.taskId = str;
    }

    public /* synthetic */ SubTaskResultResponse(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    public final String getTaskId() {
        return this.taskId;
    }
}
