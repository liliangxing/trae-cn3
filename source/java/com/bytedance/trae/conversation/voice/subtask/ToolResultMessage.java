package com.bytedance.trae.conversation.voice.subtask;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubTaskProtocol.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fBG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003JM\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006 "}, d2 = {"Lcom/bytedance/trae/conversation/voice/subtask/ToolResultMessage;", "", "type", "", DBDefinition.TASK_ID, "toolName", "result", "status", "error", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "getTaskId", "getToolName", "getResult", "getStatus", "getError", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ToolResultMessage {
    public static final String TYPE = "task_result";

    @SerializedName("error")
    private final String error;

    @SerializedName("result")
    private final String result;

    @SerializedName("status")
    private final String status;

    @SerializedName(NewTaskTracker.Param.TASK_ID)
    private final String taskId;

    @SerializedName("tool_name")
    private final String toolName;

    @SerializedName("type")
    private final String type;

    public static /* synthetic */ ToolResultMessage copy$default(ToolResultMessage toolResultMessage, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = toolResultMessage.type;
        }
        if ((i & 2) != 0) {
            str2 = toolResultMessage.taskId;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = toolResultMessage.toolName;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = toolResultMessage.result;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = toolResultMessage.status;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = toolResultMessage.error;
        }
        return toolResultMessage.copy(str, str7, str8, str9, str10, str6);
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

    /* renamed from: component4, reason: from getter */
    public final String getResult() {
        return this.result;
    }

    /* renamed from: component5, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component6, reason: from getter */
    public final String getError() {
        return this.error;
    }

    public final ToolResultMessage copy(String type, String taskId, String toolName, String result, String status, String error) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        return new ToolResultMessage(type, taskId, toolName, result, status, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ToolResultMessage)) {
            return false;
        }
        ToolResultMessage toolResultMessage = (ToolResultMessage) other;
        return Intrinsics.areEqual(this.type, toolResultMessage.type) && Intrinsics.areEqual(this.taskId, toolResultMessage.taskId) && Intrinsics.areEqual(this.toolName, toolResultMessage.toolName) && Intrinsics.areEqual(this.result, toolResultMessage.result) && Intrinsics.areEqual(this.status, toolResultMessage.status) && Intrinsics.areEqual(this.error, toolResultMessage.error);
    }

    public int hashCode() {
        int hashCode = ((this.type.hashCode() * 31) + this.taskId.hashCode()) * 31;
        String str = this.toolName;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.result;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.status;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.error;
        return hashCode4 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "ToolResultMessage(type=" + this.type + ", taskId=" + this.taskId + ", toolName=" + this.toolName + ", result=" + this.result + ", status=" + this.status + ", error=" + this.error + ')';
    }

    public ToolResultMessage(String type, String taskId, String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        this.type = type;
        this.taskId = taskId;
        this.toolName = str;
        this.result = str2;
        this.status = str3;
        this.error = str4;
    }

    public /* synthetic */ ToolResultMessage(String str, String str2, String str3, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6);
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

    public final String getResult() {
        return this.result;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getError() {
        return this.error;
    }
}
