package com.bytedance.trae.im.service;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ISubTaskResultApi.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 !2\u00020\u0001:\u0001!B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003JG\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006\""}, d2 = {"Lcom/bytedance/trae/im/service/SubTaskResultRequest;", "", DBDefinition.TASK_ID, "", "result", "status", "errorCode", "durationMs", "", "error", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getTaskId", "()Ljava/lang/String;", "getResult", "getStatus", "getErrorCode", "getDurationMs", "()J", "getError", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "Companion", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SubTaskResultRequest {
    public static final String STATUS_FAILED = "failed";
    public static final String STATUS_SUCCESS = "success";

    @SerializedName("duration_ms")
    private final long durationMs;

    @SerializedName("error")
    private final String error;

    @SerializedName("error_code")
    private final String errorCode;

    @SerializedName("result")
    private final String result;

    @SerializedName("status")
    private final String status;

    @SerializedName(NewTaskTracker.Param.TASK_ID)
    private final String taskId;

    public static /* synthetic */ SubTaskResultRequest copy$default(SubTaskResultRequest subTaskResultRequest, String str, String str2, String str3, String str4, long j, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = subTaskResultRequest.taskId;
        }
        if ((i & 2) != 0) {
            str2 = subTaskResultRequest.result;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = subTaskResultRequest.status;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = subTaskResultRequest.errorCode;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            j = subTaskResultRequest.durationMs;
        }
        long j2 = j;
        if ((i & 32) != 0) {
            str5 = subTaskResultRequest.error;
        }
        return subTaskResultRequest.copy(str, str6, str7, str8, j2, str5);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getResult() {
        return this.result;
    }

    /* renamed from: component3, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component4, reason: from getter */
    public final String getErrorCode() {
        return this.errorCode;
    }

    /* renamed from: component5, reason: from getter */
    public final long getDurationMs() {
        return this.durationMs;
    }

    /* renamed from: component6, reason: from getter */
    public final String getError() {
        return this.error;
    }

    public final SubTaskResultRequest copy(String taskId, String result, String status, String errorCode, long durationMs, String error) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        return new SubTaskResultRequest(taskId, result, status, errorCode, durationMs, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubTaskResultRequest)) {
            return false;
        }
        SubTaskResultRequest subTaskResultRequest = (SubTaskResultRequest) other;
        return Intrinsics.areEqual(this.taskId, subTaskResultRequest.taskId) && Intrinsics.areEqual(this.result, subTaskResultRequest.result) && Intrinsics.areEqual(this.status, subTaskResultRequest.status) && Intrinsics.areEqual(this.errorCode, subTaskResultRequest.errorCode) && this.durationMs == subTaskResultRequest.durationMs && Intrinsics.areEqual(this.error, subTaskResultRequest.error);
    }

    public int hashCode() {
        int hashCode = ((((((((this.taskId.hashCode() * 31) + this.result.hashCode()) * 31) + this.status.hashCode()) * 31) + this.errorCode.hashCode()) * 31) + Long.hashCode(this.durationMs)) * 31;
        String str = this.error;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "SubTaskResultRequest(taskId=" + this.taskId + ", result=" + this.result + ", status=" + this.status + ", errorCode=" + this.errorCode + ", durationMs=" + this.durationMs + ", error=" + this.error + ')';
    }

    public SubTaskResultRequest(String taskId, String result, String status, String errorCode, long j, String str) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        this.taskId = taskId;
        this.result = result;
        this.status = status;
        this.errorCode = errorCode;
        this.durationMs = j;
        this.error = str;
    }

    public /* synthetic */ SubTaskResultRequest(String str, String str2, String str3, String str4, long j, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, j, (i & 32) != 0 ? null : str5);
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getResult() {
        return this.result;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getErrorCode() {
        return this.errorCode;
    }

    public final long getDurationMs() {
        return this.durationMs;
    }

    public final String getError() {
        return this.error;
    }
}
