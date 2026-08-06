package com.bytedance.trae.conversation.voice.network;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VoiceChatModels.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006!"}, d2 = {"Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;", "", "role", "", "content", "agentType", "createdAt", "", "chatSessionId", "taskStatus", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "getRole", "()Ljava/lang/String;", "getContent", "getAgentType", "getCreatedAt", "()J", "getChatSessionId", "getTaskStatus", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class VoiceChatHistoryEntry {

    @SerializedName("agent_type")
    private final String agentType;

    @SerializedName(alternate = {"chatSessionId", "cli_conversation_id", "cliConversationId", "parent_chat_session_id", "parentChatSessionId", "voice_conversation_id", "voiceConversationId"}, value = "chat_session_id")
    private final String chatSessionId;

    @SerializedName("content")
    private final String content;

    @SerializedName("created_at")
    private final long createdAt;

    @SerializedName("role")
    private final String role;

    @SerializedName(NewTaskTracker.Param.TASK_STATUS)
    private final String taskStatus;

    public VoiceChatHistoryEntry() {
        this(null, null, null, 0L, null, null, 63, null);
    }

    public static /* synthetic */ VoiceChatHistoryEntry copy$default(VoiceChatHistoryEntry voiceChatHistoryEntry, String str, String str2, String str3, long j, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = voiceChatHistoryEntry.role;
        }
        if ((i & 2) != 0) {
            str2 = voiceChatHistoryEntry.content;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = voiceChatHistoryEntry.agentType;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            j = voiceChatHistoryEntry.createdAt;
        }
        long j2 = j;
        if ((i & 16) != 0) {
            str4 = voiceChatHistoryEntry.chatSessionId;
        }
        String str8 = str4;
        if ((i & 32) != 0) {
            str5 = voiceChatHistoryEntry.taskStatus;
        }
        return voiceChatHistoryEntry.copy(str, str6, str7, j2, str8, str5);
    }

    /* renamed from: component1, reason: from getter */
    public final String getRole() {
        return this.role;
    }

    /* renamed from: component2, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAgentType() {
        return this.agentType;
    }

    /* renamed from: component4, reason: from getter */
    public final long getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: component5, reason: from getter */
    public final String getChatSessionId() {
        return this.chatSessionId;
    }

    /* renamed from: component6, reason: from getter */
    public final String getTaskStatus() {
        return this.taskStatus;
    }

    public final VoiceChatHistoryEntry copy(String role, String content, String agentType, long createdAt, String chatSessionId, String taskStatus) {
        return new VoiceChatHistoryEntry(role, content, agentType, createdAt, chatSessionId, taskStatus);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VoiceChatHistoryEntry)) {
            return false;
        }
        VoiceChatHistoryEntry voiceChatHistoryEntry = (VoiceChatHistoryEntry) other;
        return Intrinsics.areEqual(this.role, voiceChatHistoryEntry.role) && Intrinsics.areEqual(this.content, voiceChatHistoryEntry.content) && Intrinsics.areEqual(this.agentType, voiceChatHistoryEntry.agentType) && this.createdAt == voiceChatHistoryEntry.createdAt && Intrinsics.areEqual(this.chatSessionId, voiceChatHistoryEntry.chatSessionId) && Intrinsics.areEqual(this.taskStatus, voiceChatHistoryEntry.taskStatus);
    }

    public int hashCode() {
        String str = this.role;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.content;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.agentType;
        int hashCode3 = (((hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + Long.hashCode(this.createdAt)) * 31;
        String str4 = this.chatSessionId;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.taskStatus;
        return hashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "VoiceChatHistoryEntry(role=" + this.role + ", content=" + this.content + ", agentType=" + this.agentType + ", createdAt=" + this.createdAt + ", chatSessionId=" + this.chatSessionId + ", taskStatus=" + this.taskStatus + ')';
    }

    public VoiceChatHistoryEntry(String str, String str2, String str3, long j, String str4, String str5) {
        this.role = str;
        this.content = str2;
        this.agentType = str3;
        this.createdAt = j;
        this.chatSessionId = str4;
        this.taskStatus = str5;
    }

    public /* synthetic */ VoiceChatHistoryEntry(String str, String str2, String str3, long j, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? 0L : j, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5);
    }

    public final String getRole() {
        return this.role;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getAgentType() {
        return this.agentType;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final String getChatSessionId() {
        return this.chatSessionId;
    }

    public final String getTaskStatus() {
        return this.taskStatus;
    }
}
