package com.bytedance.trae.conversation.debug;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConversationDebugInfoCopier.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\fHÆ\u0003J[\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006)"}, d2 = {"Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;", "", "createdAt", "", "messageId", "", "replyToMessageId", "sessionId", "deviceId", "userId", "location", "voiceDiscussion", "Lcom/bytedance/trae/conversation/debug/VoiceDiscussionDebugLogInfo;", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/conversation/debug/VoiceDiscussionDebugLogInfo;)V", "getCreatedAt", "()J", "getMessageId", "()Ljava/lang/String;", "getReplyToMessageId", "getSessionId", "getDeviceId", "getUserId", "getLocation", "getVoiceDiscussion", "()Lcom/bytedance/trae/conversation/debug/VoiceDiscussionDebugLogInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ConversationDebugLogInfo {
    private final long createdAt;
    private final String deviceId;
    private final String location;
    private final String messageId;
    private final String replyToMessageId;
    private final String sessionId;
    private final String userId;
    private final VoiceDiscussionDebugLogInfo voiceDiscussion;

    /* renamed from: component1, reason: from getter */
    public final long getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMessageId() {
        return this.messageId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getReplyToMessageId() {
        return this.replyToMessageId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: component5, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* renamed from: component6, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* renamed from: component7, reason: from getter */
    public final String getLocation() {
        return this.location;
    }

    /* renamed from: component8, reason: from getter */
    public final VoiceDiscussionDebugLogInfo getVoiceDiscussion() {
        return this.voiceDiscussion;
    }

    public final ConversationDebugLogInfo copy(long createdAt, String messageId, String replyToMessageId, String sessionId, String deviceId, String userId, String location, VoiceDiscussionDebugLogInfo voiceDiscussion) {
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        Intrinsics.checkNotNullParameter(replyToMessageId, "replyToMessageId");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(location, "location");
        return new ConversationDebugLogInfo(createdAt, messageId, replyToMessageId, sessionId, deviceId, userId, location, voiceDiscussion);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConversationDebugLogInfo)) {
            return false;
        }
        ConversationDebugLogInfo conversationDebugLogInfo = (ConversationDebugLogInfo) other;
        return this.createdAt == conversationDebugLogInfo.createdAt && Intrinsics.areEqual(this.messageId, conversationDebugLogInfo.messageId) && Intrinsics.areEqual(this.replyToMessageId, conversationDebugLogInfo.replyToMessageId) && Intrinsics.areEqual(this.sessionId, conversationDebugLogInfo.sessionId) && Intrinsics.areEqual(this.deviceId, conversationDebugLogInfo.deviceId) && Intrinsics.areEqual(this.userId, conversationDebugLogInfo.userId) && Intrinsics.areEqual(this.location, conversationDebugLogInfo.location) && Intrinsics.areEqual(this.voiceDiscussion, conversationDebugLogInfo.voiceDiscussion);
    }

    public int hashCode() {
        int hashCode = ((((((((((((Long.hashCode(this.createdAt) * 31) + this.messageId.hashCode()) * 31) + this.replyToMessageId.hashCode()) * 31) + this.sessionId.hashCode()) * 31) + this.deviceId.hashCode()) * 31) + this.userId.hashCode()) * 31) + this.location.hashCode()) * 31;
        VoiceDiscussionDebugLogInfo voiceDiscussionDebugLogInfo = this.voiceDiscussion;
        return hashCode + (voiceDiscussionDebugLogInfo == null ? 0 : voiceDiscussionDebugLogInfo.hashCode());
    }

    public String toString() {
        return "ConversationDebugLogInfo(createdAt=" + this.createdAt + ", messageId=" + this.messageId + ", replyToMessageId=" + this.replyToMessageId + ", sessionId=" + this.sessionId + ", deviceId=" + this.deviceId + ", userId=" + this.userId + ", location=" + this.location + ", voiceDiscussion=" + this.voiceDiscussion + ')';
    }

    public ConversationDebugLogInfo(long j, String messageId, String replyToMessageId, String sessionId, String deviceId, String userId, String location, VoiceDiscussionDebugLogInfo voiceDiscussionDebugLogInfo) {
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        Intrinsics.checkNotNullParameter(replyToMessageId, "replyToMessageId");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(location, "location");
        this.createdAt = j;
        this.messageId = messageId;
        this.replyToMessageId = replyToMessageId;
        this.sessionId = sessionId;
        this.deviceId = deviceId;
        this.userId = userId;
        this.location = location;
        this.voiceDiscussion = voiceDiscussionDebugLogInfo;
    }

    public /* synthetic */ ConversationDebugLogInfo(long j, String str, String str2, String str3, String str4, String str5, String str6, VoiceDiscussionDebugLogInfo voiceDiscussionDebugLogInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, str, str2, str3, str4, str5, str6, (i & 128) != 0 ? null : voiceDiscussionDebugLogInfo);
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final String getReplyToMessageId() {
        return this.replyToMessageId;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getLocation() {
        return this.location;
    }

    public final VoiceDiscussionDebugLogInfo getVoiceDiscussion() {
        return this.voiceDiscussion;
    }
}
