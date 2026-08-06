package com.bytedance.trae.conversation.brainstorm;

import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.trae.conversation.brainstorm.model.BrainstormUiState;
import com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptState;
import com.bytedance.trae.im.service.CliType;
import com.bytedance.trae.im.service.Mode;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HolderTypes.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b;\b\u0086\b\u0018\u00002\u00020\u0001Bç\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0015\u001a\u00020\r\u0012\b\b\u0002\u0010\u0016\u001a\u00020\r\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u0012\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001b\u0012\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001b\u0012\b\b\u0002\u0010\u001d\u001a\u00020\r\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b \u0010!J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010D\u001a\u00020\tHÆ\u0003J\t\u0010E\u001a\u00020\u000bHÆ\u0003J\t\u0010F\u001a\u00020\rHÆ\u0003J\t\u0010G\u001a\u00020\u000fHÆ\u0003J\t\u0010H\u001a\u00020\u000fHÆ\u0003J\t\u0010I\u001a\u00020\u000fHÆ\u0003J\t\u0010J\u001a\u00020\u000fHÆ\u0003J\t\u0010K\u001a\u00020\u000fHÆ\u0003J\t\u0010L\u001a\u00020\u000fHÆ\u0003J\t\u0010M\u001a\u00020\rHÆ\u0003J\t\u0010N\u001a\u00020\rHÆ\u0003J\t\u0010O\u001a\u00020\u0018HÆ\u0003J\t\u0010P\u001a\u00020\u0018HÆ\u0003J\u000f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001bHÆ\u0003J\u000f\u0010R\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001bHÆ\u0003J\t\u0010S\u001a\u00020\rHÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u001fHÆ\u0003Jï\u0001\u0010U\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00182\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001b2\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\r2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÆ\u0001J\u0013\u0010V\u001a\u00020\r2\b\u0010W\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010X\u001a\u00020\u0018HÖ\u0001J\t\u0010Y\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010%R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u0010\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b0\u0010/R\u0011\u0010\u0011\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b1\u0010/R\u0011\u0010\u0012\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b2\u0010/R\u0011\u0010\u0013\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b3\u0010/R\u0011\u0010\u0014\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b4\u0010/R\u0011\u0010\u0015\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b5\u0010-R\u0011\u0010\u0016\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b6\u0010-R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0011\u0010\u0019\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b9\u00108R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001b¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001b¢\u0006\b\n\u0000\u001a\u0004\b<\u0010;R\u0011\u0010\u001d\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b=\u0010-R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?¨\u0006Z"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/HolderSnapshot;", "", "uiState", "Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;", "cliConversationId", "", "parentConversationId", "originConversationId", "voiceCliType", "Lcom/bytedance/trae/im/service/CliType;", "voiceMode", "Lcom/bytedance/trae/im/service/Mode;", "attachmentSubTaskEnabled", "", "perfMicCheckStartMs", "", "perfMicCheckEndMs", "perfApiRequestStartMs", "perfJoinRoomStartMs", "perfJoinRoomSuccessMs", "perfBotJoinedMs", "perfIsNewSession", "discussionStartPerfReported", "sessionUserMessageCount", "", "sessionBotMessageCount", "sessionUserSpeakEndTimestamps", "", "sessionBotSpeakStartTimestamps", "sessionHasEverEnabledSubtitle", "voiceDiscussionAttemptState", "Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;", "<init>", "(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/im/service/CliType;Lcom/bytedance/trae/im/service/Mode;ZJJJJJJZZIILjava/util/List;Ljava/util/List;ZLcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;)V", "getUiState", "()Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;", "getCliConversationId", "()Ljava/lang/String;", "getParentConversationId", "getOriginConversationId", "getVoiceCliType", "()Lcom/bytedance/trae/im/service/CliType;", "getVoiceMode", "()Lcom/bytedance/trae/im/service/Mode;", "getAttachmentSubTaskEnabled", "()Z", "getPerfMicCheckStartMs", "()J", "getPerfMicCheckEndMs", "getPerfApiRequestStartMs", "getPerfJoinRoomStartMs", "getPerfJoinRoomSuccessMs", "getPerfBotJoinedMs", "getPerfIsNewSession", "getDiscussionStartPerfReported", "getSessionUserMessageCount", "()I", "getSessionBotMessageCount", "getSessionUserSpeakEndTimestamps", "()Ljava/util/List;", "getSessionBotSpeakStartTimestamps", "getSessionHasEverEnabledSubtitle", "getVoiceDiscussionAttemptState", "()Lcom/bytedance/trae/conversation/voice/VoiceDiscussionAttemptState;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "copy", "equals", "other", "hashCode", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class HolderSnapshot {
    private final boolean attachmentSubTaskEnabled;
    private final String cliConversationId;
    private final boolean discussionStartPerfReported;
    private final String originConversationId;
    private final String parentConversationId;
    private final long perfApiRequestStartMs;
    private final long perfBotJoinedMs;
    private final boolean perfIsNewSession;
    private final long perfJoinRoomStartMs;
    private final long perfJoinRoomSuccessMs;
    private final long perfMicCheckEndMs;
    private final long perfMicCheckStartMs;
    private final int sessionBotMessageCount;
    private final List<Long> sessionBotSpeakStartTimestamps;
    private final boolean sessionHasEverEnabledSubtitle;
    private final int sessionUserMessageCount;
    private final List<Long> sessionUserSpeakEndTimestamps;
    private final BrainstormUiState uiState;
    private final CliType voiceCliType;
    private final VoiceDiscussionAttemptState voiceDiscussionAttemptState;
    private final Mode voiceMode;

    /* renamed from: component1, reason: from getter */
    public final BrainstormUiState getUiState() {
        return this.uiState;
    }

    /* renamed from: component10, reason: from getter */
    public final long getPerfApiRequestStartMs() {
        return this.perfApiRequestStartMs;
    }

    /* renamed from: component11, reason: from getter */
    public final long getPerfJoinRoomStartMs() {
        return this.perfJoinRoomStartMs;
    }

    /* renamed from: component12, reason: from getter */
    public final long getPerfJoinRoomSuccessMs() {
        return this.perfJoinRoomSuccessMs;
    }

    /* renamed from: component13, reason: from getter */
    public final long getPerfBotJoinedMs() {
        return this.perfBotJoinedMs;
    }

    /* renamed from: component14, reason: from getter */
    public final boolean getPerfIsNewSession() {
        return this.perfIsNewSession;
    }

    /* renamed from: component15, reason: from getter */
    public final boolean getDiscussionStartPerfReported() {
        return this.discussionStartPerfReported;
    }

    /* renamed from: component16, reason: from getter */
    public final int getSessionUserMessageCount() {
        return this.sessionUserMessageCount;
    }

    /* renamed from: component17, reason: from getter */
    public final int getSessionBotMessageCount() {
        return this.sessionBotMessageCount;
    }

    public final List<Long> component18() {
        return this.sessionUserSpeakEndTimestamps;
    }

    public final List<Long> component19() {
        return this.sessionBotSpeakStartTimestamps;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCliConversationId() {
        return this.cliConversationId;
    }

    /* renamed from: component20, reason: from getter */
    public final boolean getSessionHasEverEnabledSubtitle() {
        return this.sessionHasEverEnabledSubtitle;
    }

    /* renamed from: component21, reason: from getter */
    public final VoiceDiscussionAttemptState getVoiceDiscussionAttemptState() {
        return this.voiceDiscussionAttemptState;
    }

    /* renamed from: component3, reason: from getter */
    public final String getParentConversationId() {
        return this.parentConversationId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getOriginConversationId() {
        return this.originConversationId;
    }

    /* renamed from: component5, reason: from getter */
    public final CliType getVoiceCliType() {
        return this.voiceCliType;
    }

    /* renamed from: component6, reason: from getter */
    public final Mode getVoiceMode() {
        return this.voiceMode;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getAttachmentSubTaskEnabled() {
        return this.attachmentSubTaskEnabled;
    }

    /* renamed from: component8, reason: from getter */
    public final long getPerfMicCheckStartMs() {
        return this.perfMicCheckStartMs;
    }

    /* renamed from: component9, reason: from getter */
    public final long getPerfMicCheckEndMs() {
        return this.perfMicCheckEndMs;
    }

    public final HolderSnapshot copy(BrainstormUiState uiState, String cliConversationId, String parentConversationId, String originConversationId, CliType voiceCliType, Mode voiceMode, boolean attachmentSubTaskEnabled, long perfMicCheckStartMs, long perfMicCheckEndMs, long perfApiRequestStartMs, long perfJoinRoomStartMs, long perfJoinRoomSuccessMs, long perfBotJoinedMs, boolean perfIsNewSession, boolean discussionStartPerfReported, int sessionUserMessageCount, int sessionBotMessageCount, List<Long> sessionUserSpeakEndTimestamps, List<Long> sessionBotSpeakStartTimestamps, boolean sessionHasEverEnabledSubtitle, VoiceDiscussionAttemptState voiceDiscussionAttemptState) {
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        Intrinsics.checkNotNullParameter(voiceCliType, "voiceCliType");
        Intrinsics.checkNotNullParameter(voiceMode, "voiceMode");
        Intrinsics.checkNotNullParameter(sessionUserSpeakEndTimestamps, "sessionUserSpeakEndTimestamps");
        Intrinsics.checkNotNullParameter(sessionBotSpeakStartTimestamps, "sessionBotSpeakStartTimestamps");
        return new HolderSnapshot(uiState, cliConversationId, parentConversationId, originConversationId, voiceCliType, voiceMode, attachmentSubTaskEnabled, perfMicCheckStartMs, perfMicCheckEndMs, perfApiRequestStartMs, perfJoinRoomStartMs, perfJoinRoomSuccessMs, perfBotJoinedMs, perfIsNewSession, discussionStartPerfReported, sessionUserMessageCount, sessionBotMessageCount, sessionUserSpeakEndTimestamps, sessionBotSpeakStartTimestamps, sessionHasEverEnabledSubtitle, voiceDiscussionAttemptState);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HolderSnapshot)) {
            return false;
        }
        HolderSnapshot holderSnapshot = (HolderSnapshot) other;
        return Intrinsics.areEqual(this.uiState, holderSnapshot.uiState) && Intrinsics.areEqual(this.cliConversationId, holderSnapshot.cliConversationId) && Intrinsics.areEqual(this.parentConversationId, holderSnapshot.parentConversationId) && Intrinsics.areEqual(this.originConversationId, holderSnapshot.originConversationId) && this.voiceCliType == holderSnapshot.voiceCliType && this.voiceMode == holderSnapshot.voiceMode && this.attachmentSubTaskEnabled == holderSnapshot.attachmentSubTaskEnabled && this.perfMicCheckStartMs == holderSnapshot.perfMicCheckStartMs && this.perfMicCheckEndMs == holderSnapshot.perfMicCheckEndMs && this.perfApiRequestStartMs == holderSnapshot.perfApiRequestStartMs && this.perfJoinRoomStartMs == holderSnapshot.perfJoinRoomStartMs && this.perfJoinRoomSuccessMs == holderSnapshot.perfJoinRoomSuccessMs && this.perfBotJoinedMs == holderSnapshot.perfBotJoinedMs && this.perfIsNewSession == holderSnapshot.perfIsNewSession && this.discussionStartPerfReported == holderSnapshot.discussionStartPerfReported && this.sessionUserMessageCount == holderSnapshot.sessionUserMessageCount && this.sessionBotMessageCount == holderSnapshot.sessionBotMessageCount && Intrinsics.areEqual(this.sessionUserSpeakEndTimestamps, holderSnapshot.sessionUserSpeakEndTimestamps) && Intrinsics.areEqual(this.sessionBotSpeakStartTimestamps, holderSnapshot.sessionBotSpeakStartTimestamps) && this.sessionHasEverEnabledSubtitle == holderSnapshot.sessionHasEverEnabledSubtitle && Intrinsics.areEqual(this.voiceDiscussionAttemptState, holderSnapshot.voiceDiscussionAttemptState);
    }

    public int hashCode() {
        int hashCode = this.uiState.hashCode() * 31;
        String str = this.cliConversationId;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.parentConversationId;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.originConversationId;
        int hashCode4 = (((((((((((((((((((((((((((((((((hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.voiceCliType.hashCode()) * 31) + this.voiceMode.hashCode()) * 31) + Boolean.hashCode(this.attachmentSubTaskEnabled)) * 31) + Long.hashCode(this.perfMicCheckStartMs)) * 31) + Long.hashCode(this.perfMicCheckEndMs)) * 31) + Long.hashCode(this.perfApiRequestStartMs)) * 31) + Long.hashCode(this.perfJoinRoomStartMs)) * 31) + Long.hashCode(this.perfJoinRoomSuccessMs)) * 31) + Long.hashCode(this.perfBotJoinedMs)) * 31) + Boolean.hashCode(this.perfIsNewSession)) * 31) + Boolean.hashCode(this.discussionStartPerfReported)) * 31) + Integer.hashCode(this.sessionUserMessageCount)) * 31) + Integer.hashCode(this.sessionBotMessageCount)) * 31) + this.sessionUserSpeakEndTimestamps.hashCode()) * 31) + this.sessionBotSpeakStartTimestamps.hashCode()) * 31) + Boolean.hashCode(this.sessionHasEverEnabledSubtitle)) * 31;
        VoiceDiscussionAttemptState voiceDiscussionAttemptState = this.voiceDiscussionAttemptState;
        return hashCode4 + (voiceDiscussionAttemptState != null ? voiceDiscussionAttemptState.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("HolderSnapshot(uiState=");
        sb.append(this.uiState).append(", cliConversationId=").append(this.cliConversationId).append(", parentConversationId=").append(this.parentConversationId).append(", originConversationId=").append(this.originConversationId).append(", voiceCliType=").append(this.voiceCliType).append(", voiceMode=").append(this.voiceMode).append(", attachmentSubTaskEnabled=").append(this.attachmentSubTaskEnabled).append(", perfMicCheckStartMs=").append(this.perfMicCheckStartMs).append(", perfMicCheckEndMs=").append(this.perfMicCheckEndMs).append(", perfApiRequestStartMs=").append(this.perfApiRequestStartMs).append(", perfJoinRoomStartMs=").append(this.perfJoinRoomStartMs).append(", perfJoinRoomSuccessMs=");
        sb.append(this.perfJoinRoomSuccessMs).append(", perfBotJoinedMs=").append(this.perfBotJoinedMs).append(", perfIsNewSession=").append(this.perfIsNewSession).append(", discussionStartPerfReported=").append(this.discussionStartPerfReported).append(", sessionUserMessageCount=").append(this.sessionUserMessageCount).append(", sessionBotMessageCount=").append(this.sessionBotMessageCount).append(", sessionUserSpeakEndTimestamps=").append(this.sessionUserSpeakEndTimestamps).append(", sessionBotSpeakStartTimestamps=").append(this.sessionBotSpeakStartTimestamps).append(", sessionHasEverEnabledSubtitle=").append(this.sessionHasEverEnabledSubtitle).append(", voiceDiscussionAttemptState=").append(this.voiceDiscussionAttemptState).append(')');
        return sb.toString();
    }

    public HolderSnapshot(BrainstormUiState brainstormUiState, String str, String str2, String str3, CliType cliType, Mode mode, boolean z, long j, long j2, long j3, long j4, long j5, long j6, boolean z2, boolean z3, int i, int i2, List<Long> list, List<Long> list2, boolean z4, VoiceDiscussionAttemptState voiceDiscussionAttemptState) {
        Intrinsics.checkNotNullParameter(brainstormUiState, "uiState");
        Intrinsics.checkNotNullParameter(cliType, "voiceCliType");
        Intrinsics.checkNotNullParameter(mode, "voiceMode");
        Intrinsics.checkNotNullParameter(list, "sessionUserSpeakEndTimestamps");
        Intrinsics.checkNotNullParameter(list2, "sessionBotSpeakStartTimestamps");
        this.uiState = brainstormUiState;
        this.cliConversationId = str;
        this.parentConversationId = str2;
        this.originConversationId = str3;
        this.voiceCliType = cliType;
        this.voiceMode = mode;
        this.attachmentSubTaskEnabled = z;
        this.perfMicCheckStartMs = j;
        this.perfMicCheckEndMs = j2;
        this.perfApiRequestStartMs = j3;
        this.perfJoinRoomStartMs = j4;
        this.perfJoinRoomSuccessMs = j5;
        this.perfBotJoinedMs = j6;
        this.perfIsNewSession = z2;
        this.discussionStartPerfReported = z3;
        this.sessionUserMessageCount = i;
        this.sessionBotMessageCount = i2;
        this.sessionUserSpeakEndTimestamps = list;
        this.sessionBotSpeakStartTimestamps = list2;
        this.sessionHasEverEnabledSubtitle = z4;
        this.voiceDiscussionAttemptState = voiceDiscussionAttemptState;
    }

    public final BrainstormUiState getUiState() {
        return this.uiState;
    }

    public final String getCliConversationId() {
        return this.cliConversationId;
    }

    public final String getParentConversationId() {
        return this.parentConversationId;
    }

    public final String getOriginConversationId() {
        return this.originConversationId;
    }

    public /* synthetic */ HolderSnapshot(BrainstormUiState brainstormUiState, String str, String str2, String str3, CliType cliType, Mode mode, boolean z, long j, long j2, long j3, long j4, long j5, long j6, boolean z2, boolean z3, int i, int i2, List list, List list2, boolean z4, VoiceDiscussionAttemptState voiceDiscussionAttemptState, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(brainstormUiState, str, (i3 & 4) != 0 ? null : str2, str3, (i3 & 16) != 0 ? CliType.LOCAL : cliType, (i3 & 32) != 0 ? Mode.WORK : mode, (i3 & 64) != 0 ? true : z, (i3 & 128) != 0 ? 0L : j, (i3 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? 0L : j2, (i3 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? 0L : j3, (i3 & 1024) != 0 ? 0L : j4, (i3 & 2048) != 0 ? 0L : j5, (i3 & 4096) != 0 ? 0L : j6, (i3 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? true : z2, (i3 & 16384) != 0 ? false : z3, (32768 & i3) != 0 ? 0 : i, (65536 & i3) != 0 ? 0 : i2, (131072 & i3) != 0 ? CollectionsKt.emptyList() : list, (262144 & i3) != 0 ? CollectionsKt.emptyList() : list2, (524288 & i3) != 0 ? false : z4, (i3 & 1048576) != 0 ? null : voiceDiscussionAttemptState);
    }

    public final CliType getVoiceCliType() {
        return this.voiceCliType;
    }

    public final Mode getVoiceMode() {
        return this.voiceMode;
    }

    public final boolean getAttachmentSubTaskEnabled() {
        return this.attachmentSubTaskEnabled;
    }

    public final long getPerfMicCheckStartMs() {
        return this.perfMicCheckStartMs;
    }

    public final long getPerfMicCheckEndMs() {
        return this.perfMicCheckEndMs;
    }

    public final long getPerfApiRequestStartMs() {
        return this.perfApiRequestStartMs;
    }

    public final long getPerfJoinRoomStartMs() {
        return this.perfJoinRoomStartMs;
    }

    public final long getPerfJoinRoomSuccessMs() {
        return this.perfJoinRoomSuccessMs;
    }

    public final long getPerfBotJoinedMs() {
        return this.perfBotJoinedMs;
    }

    public final boolean getPerfIsNewSession() {
        return this.perfIsNewSession;
    }

    public final boolean getDiscussionStartPerfReported() {
        return this.discussionStartPerfReported;
    }

    public final int getSessionUserMessageCount() {
        return this.sessionUserMessageCount;
    }

    public final int getSessionBotMessageCount() {
        return this.sessionBotMessageCount;
    }

    public final List<Long> getSessionUserSpeakEndTimestamps() {
        return this.sessionUserSpeakEndTimestamps;
    }

    public final List<Long> getSessionBotSpeakStartTimestamps() {
        return this.sessionBotSpeakStartTimestamps;
    }

    public final boolean getSessionHasEverEnabledSubtitle() {
        return this.sessionHasEverEnabledSubtitle;
    }

    public final VoiceDiscussionAttemptState getVoiceDiscussionAttemptState() {
        return this.voiceDiscussionAttemptState;
    }
}
