package com.bytedance.trae.conversation.voice.network;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.trae.push.api.PushConst;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VoiceChatModels.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003Ja\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006'"}, d2 = {"Lcom/bytedance/trae/conversation/voice/network/GetVoiceChatHistoryData;", "", "historyId", "", "conversationId", "sessionId", "chatSessionId", "agentType", "createdAt", "", "historyContext", "", "Lcom/bytedance/trae/conversation/voice/network/VoiceChatHistoryEntry;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/util/List;)V", "getHistoryId", "()Ljava/lang/String;", "getConversationId", "getSessionId", "getChatSessionId", "getAgentType", "getCreatedAt", "()J", "getHistoryContext", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class GetVoiceChatHistoryData {

    @SerializedName("agent_type")
    private final String agentType;

    @SerializedName(alternate = {"chatSessionId", "cli_conversation_id", "cliConversationId", "parent_chat_session_id", "parentChatSessionId", "voice_conversation_id", "voiceConversationId"}, value = "chat_session_id")
    private final String chatSessionId;

    @SerializedName(PushConst.PUSH_KEY_CONVERSATION_ID)
    private final String conversationId;

    @SerializedName("created_at")
    private final long createdAt;

    @SerializedName("history_context")
    private final List<VoiceChatHistoryEntry> historyContext;

    @SerializedName("history_id")
    private final String historyId;

    @SerializedName("session_id")
    private final String sessionId;

    public GetVoiceChatHistoryData() {
        this(null, null, null, null, null, 0L, null, 127, null);
    }

    /* renamed from: component1, reason: from getter */
    public final String getHistoryId() {
        return this.historyId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getConversationId() {
        return this.conversationId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getChatSessionId() {
        return this.chatSessionId;
    }

    /* renamed from: component5, reason: from getter */
    public final String getAgentType() {
        return this.agentType;
    }

    /* renamed from: component6, reason: from getter */
    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final List<VoiceChatHistoryEntry> component7() {
        return this.historyContext;
    }

    public final GetVoiceChatHistoryData copy(String historyId, String conversationId, String sessionId, String chatSessionId, String agentType, long createdAt, List<VoiceChatHistoryEntry> historyContext) {
        return new GetVoiceChatHistoryData(historyId, conversationId, sessionId, chatSessionId, agentType, createdAt, historyContext);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GetVoiceChatHistoryData)) {
            return false;
        }
        GetVoiceChatHistoryData getVoiceChatHistoryData = (GetVoiceChatHistoryData) other;
        return Intrinsics.areEqual(this.historyId, getVoiceChatHistoryData.historyId) && Intrinsics.areEqual(this.conversationId, getVoiceChatHistoryData.conversationId) && Intrinsics.areEqual(this.sessionId, getVoiceChatHistoryData.sessionId) && Intrinsics.areEqual(this.chatSessionId, getVoiceChatHistoryData.chatSessionId) && Intrinsics.areEqual(this.agentType, getVoiceChatHistoryData.agentType) && this.createdAt == getVoiceChatHistoryData.createdAt && Intrinsics.areEqual(this.historyContext, getVoiceChatHistoryData.historyContext);
    }

    public int hashCode() {
        String str = this.historyId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.conversationId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.sessionId;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.chatSessionId;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.agentType;
        int hashCode5 = (((hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31) + Long.hashCode(this.createdAt)) * 31;
        List<VoiceChatHistoryEntry> list = this.historyContext;
        return hashCode5 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "GetVoiceChatHistoryData(historyId=" + this.historyId + ", conversationId=" + this.conversationId + ", sessionId=" + this.sessionId + ", chatSessionId=" + this.chatSessionId + ", agentType=" + this.agentType + ", createdAt=" + this.createdAt + ", historyContext=" + this.historyContext + ')';
    }

    public GetVoiceChatHistoryData(String str, String str2, String str3, String str4, String str5, long j, List<VoiceChatHistoryEntry> list) {
        this.historyId = str;
        this.conversationId = str2;
        this.sessionId = str3;
        this.chatSessionId = str4;
        this.agentType = str5;
        this.createdAt = j;
        this.historyContext = list;
    }

    public /* synthetic */ GetVoiceChatHistoryData(String str, String str2, String str3, String str4, String str5, long j, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? 0L : j, (i & 64) == 0 ? list : null);
    }

    public final String getHistoryId() {
        return this.historyId;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getChatSessionId() {
        return this.chatSessionId;
    }

    public final String getAgentType() {
        return this.agentType;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final List<VoiceChatHistoryEntry> getHistoryContext() {
        return this.historyContext;
    }
}
