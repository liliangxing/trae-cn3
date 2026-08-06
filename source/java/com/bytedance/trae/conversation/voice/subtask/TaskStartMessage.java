package com.bytedance.trae.conversation.voice.subtask;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubTaskProtocol.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/bytedance/trae/conversation/voice/subtask/TaskStartMessage;", "", "type", "", DBDefinition.TASK_ID, "toolName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "getTaskId", "getToolName", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class TaskStartMessage {
    public static final String TYPE = "task_start";

    @SerializedName(NewTaskTracker.Param.TASK_ID)
    private final String taskId;

    @SerializedName("tool_name")
    private final String toolName;

    @SerializedName("type")
    private final String type;

    public static /* synthetic */ TaskStartMessage copy$default(TaskStartMessage taskStartMessage, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = taskStartMessage.type;
        }
        if ((i & 2) != 0) {
            str2 = taskStartMessage.taskId;
        }
        if ((i & 4) != 0) {
            str3 = taskStartMessage.toolName;
        }
        return taskStartMessage.copy(str, str2, str3);
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
    public final String getToolName() {
        return this.toolName;
    }

    public final TaskStartMessage copy(String type, String taskId, String toolName) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        return new TaskStartMessage(type, taskId, toolName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskStartMessage)) {
            return false;
        }
        TaskStartMessage taskStartMessage = (TaskStartMessage) other;
        return Intrinsics.areEqual(this.type, taskStartMessage.type) && Intrinsics.areEqual(this.taskId, taskStartMessage.taskId) && Intrinsics.areEqual(this.toolName, taskStartMessage.toolName);
    }

    public int hashCode() {
        int hashCode = ((this.type.hashCode() * 31) + this.taskId.hashCode()) * 31;
        String str = this.toolName;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "TaskStartMessage(type=" + this.type + ", taskId=" + this.taskId + ", toolName=" + this.toolName + ')';
    }

    public TaskStartMessage(String type, String taskId, String str) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        this.type = type;
        this.taskId = taskId;
        this.toolName = str;
    }

    public /* synthetic */ TaskStartMessage(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : str3);
    }

    public final String getType() {
        return this.type;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getToolName() {
        return this.toolName;
    }
}
