package com.bytedance.trae.conversation.brainstorm.model;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.trae.conversation.voice.subtask.SubTaskRenderState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BrainstormMessage.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jm\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012¨\u0006."}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;", "", "id", "", "role", "Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;", "content", "timestamp", "", "attachedSubTaskId", "taskResultRefersToTaskId", "taskResultStatus", "subTaskTerminalState", "Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;", "subTaskFailureReason", "<init>", "(Ljava/lang/String;Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getRole", "()Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;", "getContent", "getTimestamp", "()J", "getAttachedSubTaskId", "getTaskResultRefersToTaskId", "getTaskResultStatus", "getSubTaskTerminalState", "()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;", "getSubTaskFailureReason", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class BrainstormMessage {
    private final String attachedSubTaskId;
    private final String content;
    private final String id;
    private final MessageRole role;
    private final String subTaskFailureReason;
    private final SubTaskRenderState subTaskTerminalState;
    private final String taskResultRefersToTaskId;
    private final String taskResultStatus;
    private final long timestamp;

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final MessageRole getRole() {
        return this.role;
    }

    /* renamed from: component3, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component4, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    /* renamed from: component5, reason: from getter */
    public final String getAttachedSubTaskId() {
        return this.attachedSubTaskId;
    }

    /* renamed from: component6, reason: from getter */
    public final String getTaskResultRefersToTaskId() {
        return this.taskResultRefersToTaskId;
    }

    /* renamed from: component7, reason: from getter */
    public final String getTaskResultStatus() {
        return this.taskResultStatus;
    }

    /* renamed from: component8, reason: from getter */
    public final SubTaskRenderState getSubTaskTerminalState() {
        return this.subTaskTerminalState;
    }

    /* renamed from: component9, reason: from getter */
    public final String getSubTaskFailureReason() {
        return this.subTaskFailureReason;
    }

    public final BrainstormMessage copy(String id, MessageRole role, String content, long timestamp, String attachedSubTaskId, String taskResultRefersToTaskId, String taskResultStatus, SubTaskRenderState subTaskTerminalState, String subTaskFailureReason) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(role, "role");
        Intrinsics.checkNotNullParameter(content, "content");
        return new BrainstormMessage(id, role, content, timestamp, attachedSubTaskId, taskResultRefersToTaskId, taskResultStatus, subTaskTerminalState, subTaskFailureReason);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BrainstormMessage)) {
            return false;
        }
        BrainstormMessage brainstormMessage = (BrainstormMessage) other;
        return Intrinsics.areEqual(this.id, brainstormMessage.id) && this.role == brainstormMessage.role && Intrinsics.areEqual(this.content, brainstormMessage.content) && this.timestamp == brainstormMessage.timestamp && Intrinsics.areEqual(this.attachedSubTaskId, brainstormMessage.attachedSubTaskId) && Intrinsics.areEqual(this.taskResultRefersToTaskId, brainstormMessage.taskResultRefersToTaskId) && Intrinsics.areEqual(this.taskResultStatus, brainstormMessage.taskResultStatus) && this.subTaskTerminalState == brainstormMessage.subTaskTerminalState && Intrinsics.areEqual(this.subTaskFailureReason, brainstormMessage.subTaskFailureReason);
    }

    public int hashCode() {
        int hashCode = ((((((this.id.hashCode() * 31) + this.role.hashCode()) * 31) + this.content.hashCode()) * 31) + Long.hashCode(this.timestamp)) * 31;
        String str = this.attachedSubTaskId;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.taskResultRefersToTaskId;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.taskResultStatus;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        SubTaskRenderState subTaskRenderState = this.subTaskTerminalState;
        int hashCode5 = (hashCode4 + (subTaskRenderState == null ? 0 : subTaskRenderState.hashCode())) * 31;
        String str4 = this.subTaskFailureReason;
        return hashCode5 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "BrainstormMessage(id=" + this.id + ", role=" + this.role + ", content=" + this.content + ", timestamp=" + this.timestamp + ", attachedSubTaskId=" + this.attachedSubTaskId + ", taskResultRefersToTaskId=" + this.taskResultRefersToTaskId + ", taskResultStatus=" + this.taskResultStatus + ", subTaskTerminalState=" + this.subTaskTerminalState + ", subTaskFailureReason=" + this.subTaskFailureReason + ')';
    }

    public BrainstormMessage(String id, MessageRole role, String content, long j, String str, String str2, String str3, SubTaskRenderState subTaskRenderState, String str4) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(role, "role");
        Intrinsics.checkNotNullParameter(content, "content");
        this.id = id;
        this.role = role;
        this.content = content;
        this.timestamp = j;
        this.attachedSubTaskId = str;
        this.taskResultRefersToTaskId = str2;
        this.taskResultStatus = str3;
        this.subTaskTerminalState = subTaskRenderState;
        this.subTaskFailureReason = str4;
    }

    public /* synthetic */ BrainstormMessage(String str, MessageRole messageRole, String str2, long j, String str3, String str4, String str5, SubTaskRenderState subTaskRenderState, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, messageRole, str2, j, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : subTaskRenderState, (i & 256) != 0 ? null : str6);
    }

    public final String getId() {
        return this.id;
    }

    public final MessageRole getRole() {
        return this.role;
    }

    public final String getContent() {
        return this.content;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getAttachedSubTaskId() {
        return this.attachedSubTaskId;
    }

    public final String getTaskResultRefersToTaskId() {
        return this.taskResultRefersToTaskId;
    }

    public final String getTaskResultStatus() {
        return this.taskResultStatus;
    }

    public final SubTaskRenderState getSubTaskTerminalState() {
        return this.subTaskTerminalState;
    }

    public final String getSubTaskFailureReason() {
        return this.subTaskFailureReason;
    }
}
