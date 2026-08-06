package com.bytedance.trae.conversation.voice.subtask;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubTaskProtocol.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J=\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/bytedance/trae/conversation/voice/subtask/TaskStopMessage;", "", "type", "", DBDefinition.TASK_ID, "roomId", "userId", "timeoutMs", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getType", "()Ljava/lang/String;", "getTaskId", "getRoomId", "getUserId", "getTimeoutMs", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class TaskStopMessage {
    public static final String TYPE = "task_stop";

    @SerializedName("room_id")
    private final String roomId;

    @SerializedName(NewTaskTracker.Param.TASK_ID)
    private final String taskId;

    @SerializedName("timeout_ms")
    private final long timeoutMs;

    @SerializedName("type")
    private final String type;

    @SerializedName("user_id")
    private final String userId;

    public static /* synthetic */ TaskStopMessage copy$default(TaskStopMessage taskStopMessage, String str, String str2, String str3, String str4, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = taskStopMessage.type;
        }
        if ((i & 2) != 0) {
            str2 = taskStopMessage.taskId;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = taskStopMessage.roomId;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = taskStopMessage.userId;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            j = taskStopMessage.timeoutMs;
        }
        return taskStopMessage.copy(str, str5, str6, str7, j);
    }

    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getRoomId() {
        return this.roomId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* renamed from: component5, reason: from getter */
    public final long getTimeoutMs() {
        return this.timeoutMs;
    }

    public final TaskStopMessage copy(String type, String taskId, String roomId, String userId, long timeoutMs) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        return new TaskStopMessage(type, taskId, roomId, userId, timeoutMs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskStopMessage)) {
            return false;
        }
        TaskStopMessage taskStopMessage = (TaskStopMessage) other;
        return Intrinsics.areEqual(this.type, taskStopMessage.type) && Intrinsics.areEqual(this.taskId, taskStopMessage.taskId) && Intrinsics.areEqual(this.roomId, taskStopMessage.roomId) && Intrinsics.areEqual(this.userId, taskStopMessage.userId) && this.timeoutMs == taskStopMessage.timeoutMs;
    }

    public int hashCode() {
        int hashCode = ((((this.type.hashCode() * 31) + this.taskId.hashCode()) * 31) + this.roomId.hashCode()) * 31;
        String str = this.userId;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Long.hashCode(this.timeoutMs);
    }

    public String toString() {
        return "TaskStopMessage(type=" + this.type + ", taskId=" + this.taskId + ", roomId=" + this.roomId + ", userId=" + this.userId + ", timeoutMs=" + this.timeoutMs + ')';
    }

    public TaskStopMessage(String type, String taskId, String roomId, String str, long j) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        this.type = type;
        this.taskId = taskId;
        this.roomId = roomId;
        this.userId = str;
        this.timeoutMs = j;
    }

    public /* synthetic */ TaskStopMessage(String str, String str2, String str3, String str4, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? 600000L : j);
    }

    public final String getType() {
        return this.type;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final long getTimeoutMs() {
        return this.timeoutMs;
    }
}
