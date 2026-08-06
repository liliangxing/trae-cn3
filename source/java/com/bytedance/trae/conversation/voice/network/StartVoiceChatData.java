package com.bytedance.trae.conversation.voice.network;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VoiceChatModels.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010%\u001a\u0004\u0018\u00010\rHÆ\u0003Jz\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006."}, d2 = {"Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;", "", "appId", "", "roomId", "userId", "token", "botName", DBDefinition.TASK_ID, "botUserId", "taskExpireAt", "", "subTaskConfig", "Lcom/bytedance/trae/conversation/voice/network/VoiceSubTaskConfig;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/bytedance/trae/conversation/voice/network/VoiceSubTaskConfig;)V", "getAppId", "()Ljava/lang/String;", "getRoomId", "getUserId", "getToken", "getBotName", "getTaskId", "getBotUserId", "getTaskExpireAt", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSubTaskConfig", "()Lcom/bytedance/trae/conversation/voice/network/VoiceSubTaskConfig;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/bytedance/trae/conversation/voice/network/VoiceSubTaskConfig;)Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class StartVoiceChatData {

    @SerializedName("app_id")
    private final String appId;

    @SerializedName("bot_name")
    private final String botName;

    @SerializedName("bot_user_id")
    private final String botUserId;

    @SerializedName("room_id")
    private final String roomId;

    @SerializedName("sub_task_config")
    private final VoiceSubTaskConfig subTaskConfig;

    @SerializedName("token_expire_at")
    private final Long taskExpireAt;

    @SerializedName(NewTaskTracker.Param.TASK_ID)
    private final String taskId;

    @SerializedName("token")
    private final String token;

    @SerializedName("user_id")
    private final String userId;

    public StartVoiceChatData() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getRoomId() {
        return this.roomId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    /* renamed from: component5, reason: from getter */
    public final String getBotName() {
        return this.botName;
    }

    /* renamed from: component6, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    /* renamed from: component7, reason: from getter */
    public final String getBotUserId() {
        return this.botUserId;
    }

    /* renamed from: component8, reason: from getter */
    public final Long getTaskExpireAt() {
        return this.taskExpireAt;
    }

    /* renamed from: component9, reason: from getter */
    public final VoiceSubTaskConfig getSubTaskConfig() {
        return this.subTaskConfig;
    }

    public final StartVoiceChatData copy(String appId, String roomId, String userId, String token, String botName, String taskId, String botUserId, Long taskExpireAt, VoiceSubTaskConfig subTaskConfig) {
        return new StartVoiceChatData(appId, roomId, userId, token, botName, taskId, botUserId, taskExpireAt, subTaskConfig);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StartVoiceChatData)) {
            return false;
        }
        StartVoiceChatData startVoiceChatData = (StartVoiceChatData) other;
        return Intrinsics.areEqual(this.appId, startVoiceChatData.appId) && Intrinsics.areEqual(this.roomId, startVoiceChatData.roomId) && Intrinsics.areEqual(this.userId, startVoiceChatData.userId) && Intrinsics.areEqual(this.token, startVoiceChatData.token) && Intrinsics.areEqual(this.botName, startVoiceChatData.botName) && Intrinsics.areEqual(this.taskId, startVoiceChatData.taskId) && Intrinsics.areEqual(this.botUserId, startVoiceChatData.botUserId) && Intrinsics.areEqual(this.taskExpireAt, startVoiceChatData.taskExpireAt) && Intrinsics.areEqual(this.subTaskConfig, startVoiceChatData.subTaskConfig);
    }

    public int hashCode() {
        String str = this.appId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.roomId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.userId;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.token;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.botName;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.taskId;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.botUserId;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Long l = this.taskExpireAt;
        int hashCode8 = (hashCode7 + (l == null ? 0 : l.hashCode())) * 31;
        VoiceSubTaskConfig voiceSubTaskConfig = this.subTaskConfig;
        return hashCode8 + (voiceSubTaskConfig != null ? voiceSubTaskConfig.hashCode() : 0);
    }

    public String toString() {
        return "StartVoiceChatData(appId=" + this.appId + ", roomId=" + this.roomId + ", userId=" + this.userId + ", token=" + this.token + ", botName=" + this.botName + ", taskId=" + this.taskId + ", botUserId=" + this.botUserId + ", taskExpireAt=" + this.taskExpireAt + ", subTaskConfig=" + this.subTaskConfig + ')';
    }

    public StartVoiceChatData(String str, String str2, String str3, String str4, String str5, String str6, String str7, Long l, VoiceSubTaskConfig voiceSubTaskConfig) {
        this.appId = str;
        this.roomId = str2;
        this.userId = str3;
        this.token = str4;
        this.botName = str5;
        this.taskId = str6;
        this.botUserId = str7;
        this.taskExpireAt = l;
        this.subTaskConfig = voiceSubTaskConfig;
    }

    public /* synthetic */ StartVoiceChatData(String str, String str2, String str3, String str4, String str5, String str6, String str7, Long l, VoiceSubTaskConfig voiceSubTaskConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : l, (i & 256) == 0 ? voiceSubTaskConfig : null);
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getToken() {
        return this.token;
    }

    public final String getBotName() {
        return this.botName;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getBotUserId() {
        return this.botUserId;
    }

    public final Long getTaskExpireAt() {
        return this.taskExpireAt;
    }

    public final VoiceSubTaskConfig getSubTaskConfig() {
        return this.subTaskConfig;
    }
}
