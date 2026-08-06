package com.bytedance.trae.conversation.voice.network;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VoiceChatModels.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jc\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010#\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010¨\u0006("}, d2 = {"Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatRequest;", "", "sceneId", "", "configOnly", "", "agentConfig", "Lcom/bytedance/trae/conversation/voice/network/AgentConfig;", "roomId", "userId", DBDefinition.TASK_ID, "token", "botUserId", "<init>", "(Ljava/lang/String;ZLcom/bytedance/trae/conversation/voice/network/AgentConfig;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSceneId", "()Ljava/lang/String;", "getConfigOnly", "()Z", "getAgentConfig", "()Lcom/bytedance/trae/conversation/voice/network/AgentConfig;", "getRoomId", "getUserId", "getTaskId", "getToken", "getBotUserId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class StartVoiceChatRequest {

    @SerializedName("AgentConfig")
    private final AgentConfig agentConfig;

    @SerializedName("bot_user_id")
    private final String botUserId;

    @SerializedName("config_only")
    private final boolean configOnly;

    @SerializedName("room_id")
    private final String roomId;

    @SerializedName("scene_id")
    private final String sceneId;

    @SerializedName(NewTaskTracker.Param.TASK_ID)
    private final String taskId;

    @SerializedName("token")
    private final String token;

    @SerializedName("user_id")
    private final String userId;

    /* renamed from: component1, reason: from getter */
    public final String getSceneId() {
        return this.sceneId;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getConfigOnly() {
        return this.configOnly;
    }

    /* renamed from: component3, reason: from getter */
    public final AgentConfig getAgentConfig() {
        return this.agentConfig;
    }

    /* renamed from: component4, reason: from getter */
    public final String getRoomId() {
        return this.roomId;
    }

    /* renamed from: component5, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* renamed from: component6, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    /* renamed from: component7, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    /* renamed from: component8, reason: from getter */
    public final String getBotUserId() {
        return this.botUserId;
    }

    public final StartVoiceChatRequest copy(String sceneId, boolean configOnly, AgentConfig agentConfig, String roomId, String userId, String taskId, String token, String botUserId) {
        Intrinsics.checkNotNullParameter(sceneId, "sceneId");
        Intrinsics.checkNotNullParameter(agentConfig, "agentConfig");
        return new StartVoiceChatRequest(sceneId, configOnly, agentConfig, roomId, userId, taskId, token, botUserId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StartVoiceChatRequest)) {
            return false;
        }
        StartVoiceChatRequest startVoiceChatRequest = (StartVoiceChatRequest) other;
        return Intrinsics.areEqual(this.sceneId, startVoiceChatRequest.sceneId) && this.configOnly == startVoiceChatRequest.configOnly && Intrinsics.areEqual(this.agentConfig, startVoiceChatRequest.agentConfig) && Intrinsics.areEqual(this.roomId, startVoiceChatRequest.roomId) && Intrinsics.areEqual(this.userId, startVoiceChatRequest.userId) && Intrinsics.areEqual(this.taskId, startVoiceChatRequest.taskId) && Intrinsics.areEqual(this.token, startVoiceChatRequest.token) && Intrinsics.areEqual(this.botUserId, startVoiceChatRequest.botUserId);
    }

    public int hashCode() {
        int hashCode = ((((this.sceneId.hashCode() * 31) + Boolean.hashCode(this.configOnly)) * 31) + this.agentConfig.hashCode()) * 31;
        String str = this.roomId;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.userId;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.taskId;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.token;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.botUserId;
        return hashCode5 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "StartVoiceChatRequest(sceneId=" + this.sceneId + ", configOnly=" + this.configOnly + ", agentConfig=" + this.agentConfig + ", roomId=" + this.roomId + ", userId=" + this.userId + ", taskId=" + this.taskId + ", token=" + this.token + ", botUserId=" + this.botUserId + ')';
    }

    public StartVoiceChatRequest(String sceneId, boolean z, AgentConfig agentConfig, String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(sceneId, "sceneId");
        Intrinsics.checkNotNullParameter(agentConfig, "agentConfig");
        this.sceneId = sceneId;
        this.configOnly = z;
        this.agentConfig = agentConfig;
        this.roomId = str;
        this.userId = str2;
        this.taskId = str3;
        this.token = str4;
        this.botUserId = str5;
    }

    public final String getSceneId() {
        return this.sceneId;
    }

    public final boolean getConfigOnly() {
        return this.configOnly;
    }

    public /* synthetic */ StartVoiceChatRequest(String str, boolean z, AgentConfig agentConfig, String str2, String str3, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? false : z, (i & 4) != 0 ? new AgentConfig(false, 1, null) : agentConfig, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5, (i & 128) == 0 ? str6 : null);
    }

    public final AgentConfig getAgentConfig() {
        return this.agentConfig;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getToken() {
        return this.token;
    }

    public final String getBotUserId() {
        return this.botUserId;
    }
}
