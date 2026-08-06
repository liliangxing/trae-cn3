package com.bytedance.trae.conversation.brainstorm.model;

import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.trae.conversation.voice.subtask.SubTaskUiState;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BrainstormUiState.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b>\b\u0086\b\u0018\u00002\u00020\u0001Bÿ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001d\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001f\u0012\b\b\u0002\u0010 \u001a\u00020\u000f\u0012\b\b\u0002\u0010!\u001a\u00020\u0014\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#\u0012\u0014\b\u0002\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020#0%\u0012\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u0005¢\u0006\u0004\b(\u0010)J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\u000f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010L\u001a\u00020\bHÆ\u0003J\t\u0010M\u001a\u00020\nHÆ\u0003J\t\u0010N\u001a\u00020\fHÆ\u0003J\t\u0010O\u001a\u00020\fHÆ\u0003J\t\u0010P\u001a\u00020\u000fHÆ\u0003J\t\u0010Q\u001a\u00020\u000fHÆ\u0003J\t\u0010R\u001a\u00020\u0012HÆ\u0003J\t\u0010S\u001a\u00020\u0014HÆ\u0003J\t\u0010T\u001a\u00020\u0014HÆ\u0003J\t\u0010U\u001a\u00020\u0014HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\t\u0010W\u001a\u00020\u001aHÆ\u0003J\t\u0010X\u001a\u00020\u001aHÆ\u0003J\t\u0010Y\u001a\u00020\u001dHÆ\u0003J\t\u0010Z\u001a\u00020\u001fHÆ\u0003J\t\u0010[\u001a\u00020\u000fHÆ\u0003J\t\u0010\\\u001a\u00020\u0014HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010#HÆ\u0003J\u0015\u0010^\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020#0%HÆ\u0003J\u000f\u0010_\u001a\b\u0012\u0004\u0012\u00020'0\u0005HÆ\u0003J\u0081\u0002\u0010`\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00142\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u000f2\b\b\u0002\u0010!\u001a\u00020\u00142\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\u0014\b\u0002\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020#0%2\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u0005HÆ\u0001J\u0013\u0010a\u001a\u00020\u00142\b\u0010b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010c\u001a\u00020\u001fHÖ\u0001J\t\u0010d\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b4\u00103R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0011\u0010\u0010\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b7\u00106R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010:R\u0011\u0010\u0015\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010:R\u0011\u0010\u0016\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010:R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0011\u0010\u001b\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b?\u0010>R\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0011\u0010\u001e\u001a\u00020\u001f¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0011\u0010 \u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\bD\u00106R\u0011\u0010!\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b!\u0010:R\u0013\u0010\"\u001a\u0004\u0018\u00010#¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u001d\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020#0%¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u0005¢\u0006\b\n\u0000\u001a\u0004\bI\u0010-¨\u0006e"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormUiState;", "", "phase", "Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;", "subtitleHistory", "", "Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;", "recordingState", "Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState;", "aiReplyState", "Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState;", "aiParticipantState", "Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;", "userParticipantState", "currentTranscript", "", "botTranscript", "currentAudioDevice", "Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;", "isSpeakerOn", "", "isMicMuted", "isSubtitleMode", "summary", "Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;", "sessionStartTimeMs", "", "sessionElapsedMs", "timeoutState", "Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;", "timeoutRemainingSeconds", "", "aiStageDescription", "isRtcJoined", "subTask", "Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;", "finishedSubTasks", "", "attachments", "Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;", "<init>", "(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;Ljava/util/List;Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState;Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState;Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;ZZZLcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;JJLcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;ILjava/lang/String;ZLcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;Ljava/util/Map;Ljava/util/List;)V", "getPhase", "()Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormPhase;", "getSubtitleHistory", "()Ljava/util/List;", "getRecordingState", "()Lcom/bytedance/trae/conversation/brainstorm/model/RecordingState;", "getAiReplyState", "()Lcom/bytedance/trae/conversation/brainstorm/model/AiReplyState;", "getAiParticipantState", "()Lcom/bytedance/trae/conversation/brainstorm/model/ParticipantState;", "getUserParticipantState", "getCurrentTranscript", "()Ljava/lang/String;", "getBotTranscript", "getCurrentAudioDevice", "()Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;", "()Z", "getSummary", "()Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;", "getSessionStartTimeMs", "()J", "getSessionElapsedMs", "getTimeoutState", "()Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;", "getTimeoutRemainingSeconds", "()I", "getAiStageDescription", "getSubTask", "()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;", "getFinishedSubTasks", "()Ljava/util/Map;", "getAttachments", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "copy", "equals", "other", "hashCode", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class BrainstormUiState {
    private final ParticipantState aiParticipantState;
    private final AiReplyState aiReplyState;
    private final String aiStageDescription;
    private final List<BrainstormAttachment> attachments;
    private final String botTranscript;
    private final AudioDevice currentAudioDevice;
    private final String currentTranscript;
    private final Map<String, SubTaskUiState> finishedSubTasks;
    private final boolean isMicMuted;
    private final boolean isRtcJoined;
    private final boolean isSpeakerOn;
    private final boolean isSubtitleMode;
    private final BrainstormPhase phase;
    private final RecordingState recordingState;
    private final long sessionElapsedMs;
    private final long sessionStartTimeMs;
    private final SubTaskUiState subTask;
    private final List<BrainstormMessage> subtitleHistory;
    private final BrainstormSummary summary;
    private final int timeoutRemainingSeconds;
    private final TimeoutState timeoutState;
    private final ParticipantState userParticipantState;

    public BrainstormUiState() {
        this(null, null, null, null, null, null, null, null, null, false, false, false, null, 0L, 0L, null, 0, null, false, null, null, null, 4194303, null);
    }

    /* renamed from: component1, reason: from getter */
    public final BrainstormPhase getPhase() {
        return this.phase;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getIsSpeakerOn() {
        return this.isSpeakerOn;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getIsMicMuted() {
        return this.isMicMuted;
    }

    /* renamed from: component12, reason: from getter */
    public final boolean getIsSubtitleMode() {
        return this.isSubtitleMode;
    }

    /* renamed from: component13, reason: from getter */
    public final BrainstormSummary getSummary() {
        return this.summary;
    }

    /* renamed from: component14, reason: from getter */
    public final long getSessionStartTimeMs() {
        return this.sessionStartTimeMs;
    }

    /* renamed from: component15, reason: from getter */
    public final long getSessionElapsedMs() {
        return this.sessionElapsedMs;
    }

    /* renamed from: component16, reason: from getter */
    public final TimeoutState getTimeoutState() {
        return this.timeoutState;
    }

    /* renamed from: component17, reason: from getter */
    public final int getTimeoutRemainingSeconds() {
        return this.timeoutRemainingSeconds;
    }

    /* renamed from: component18, reason: from getter */
    public final String getAiStageDescription() {
        return this.aiStageDescription;
    }

    /* renamed from: component19, reason: from getter */
    public final boolean getIsRtcJoined() {
        return this.isRtcJoined;
    }

    public final List<BrainstormMessage> component2() {
        return this.subtitleHistory;
    }

    /* renamed from: component20, reason: from getter */
    public final SubTaskUiState getSubTask() {
        return this.subTask;
    }

    public final Map<String, SubTaskUiState> component21() {
        return this.finishedSubTasks;
    }

    public final List<BrainstormAttachment> component22() {
        return this.attachments;
    }

    /* renamed from: component3, reason: from getter */
    public final RecordingState getRecordingState() {
        return this.recordingState;
    }

    /* renamed from: component4, reason: from getter */
    public final AiReplyState getAiReplyState() {
        return this.aiReplyState;
    }

    /* renamed from: component5, reason: from getter */
    public final ParticipantState getAiParticipantState() {
        return this.aiParticipantState;
    }

    /* renamed from: component6, reason: from getter */
    public final ParticipantState getUserParticipantState() {
        return this.userParticipantState;
    }

    /* renamed from: component7, reason: from getter */
    public final String getCurrentTranscript() {
        return this.currentTranscript;
    }

    /* renamed from: component8, reason: from getter */
    public final String getBotTranscript() {
        return this.botTranscript;
    }

    /* renamed from: component9, reason: from getter */
    public final AudioDevice getCurrentAudioDevice() {
        return this.currentAudioDevice;
    }

    public final BrainstormUiState copy(BrainstormPhase phase, List<BrainstormMessage> subtitleHistory, RecordingState recordingState, AiReplyState aiReplyState, ParticipantState aiParticipantState, ParticipantState userParticipantState, String currentTranscript, String botTranscript, AudioDevice currentAudioDevice, boolean isSpeakerOn, boolean isMicMuted, boolean isSubtitleMode, BrainstormSummary summary, long sessionStartTimeMs, long sessionElapsedMs, TimeoutState timeoutState, int timeoutRemainingSeconds, String aiStageDescription, boolean isRtcJoined, SubTaskUiState subTask, Map<String, SubTaskUiState> finishedSubTasks, List<BrainstormAttachment> attachments) {
        Intrinsics.checkNotNullParameter(phase, "phase");
        Intrinsics.checkNotNullParameter(subtitleHistory, "subtitleHistory");
        Intrinsics.checkNotNullParameter(recordingState, "recordingState");
        Intrinsics.checkNotNullParameter(aiReplyState, "aiReplyState");
        Intrinsics.checkNotNullParameter(aiParticipantState, "aiParticipantState");
        Intrinsics.checkNotNullParameter(userParticipantState, "userParticipantState");
        Intrinsics.checkNotNullParameter(currentTranscript, "currentTranscript");
        Intrinsics.checkNotNullParameter(botTranscript, "botTranscript");
        Intrinsics.checkNotNullParameter(currentAudioDevice, "currentAudioDevice");
        Intrinsics.checkNotNullParameter(timeoutState, "timeoutState");
        Intrinsics.checkNotNullParameter(aiStageDescription, "aiStageDescription");
        Intrinsics.checkNotNullParameter(finishedSubTasks, "finishedSubTasks");
        Intrinsics.checkNotNullParameter(attachments, "attachments");
        return new BrainstormUiState(phase, subtitleHistory, recordingState, aiReplyState, aiParticipantState, userParticipantState, currentTranscript, botTranscript, currentAudioDevice, isSpeakerOn, isMicMuted, isSubtitleMode, summary, sessionStartTimeMs, sessionElapsedMs, timeoutState, timeoutRemainingSeconds, aiStageDescription, isRtcJoined, subTask, finishedSubTasks, attachments);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BrainstormUiState)) {
            return false;
        }
        BrainstormUiState brainstormUiState = (BrainstormUiState) other;
        return this.phase == brainstormUiState.phase && Intrinsics.areEqual(this.subtitleHistory, brainstormUiState.subtitleHistory) && this.recordingState == brainstormUiState.recordingState && this.aiReplyState == brainstormUiState.aiReplyState && this.aiParticipantState == brainstormUiState.aiParticipantState && this.userParticipantState == brainstormUiState.userParticipantState && Intrinsics.areEqual(this.currentTranscript, brainstormUiState.currentTranscript) && Intrinsics.areEqual(this.botTranscript, brainstormUiState.botTranscript) && this.currentAudioDevice == brainstormUiState.currentAudioDevice && this.isSpeakerOn == brainstormUiState.isSpeakerOn && this.isMicMuted == brainstormUiState.isMicMuted && this.isSubtitleMode == brainstormUiState.isSubtitleMode && Intrinsics.areEqual(this.summary, brainstormUiState.summary) && this.sessionStartTimeMs == brainstormUiState.sessionStartTimeMs && this.sessionElapsedMs == brainstormUiState.sessionElapsedMs && this.timeoutState == brainstormUiState.timeoutState && this.timeoutRemainingSeconds == brainstormUiState.timeoutRemainingSeconds && Intrinsics.areEqual(this.aiStageDescription, brainstormUiState.aiStageDescription) && this.isRtcJoined == brainstormUiState.isRtcJoined && Intrinsics.areEqual(this.subTask, brainstormUiState.subTask) && Intrinsics.areEqual(this.finishedSubTasks, brainstormUiState.finishedSubTasks) && Intrinsics.areEqual(this.attachments, brainstormUiState.attachments);
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((((((this.phase.hashCode() * 31) + this.subtitleHistory.hashCode()) * 31) + this.recordingState.hashCode()) * 31) + this.aiReplyState.hashCode()) * 31) + this.aiParticipantState.hashCode()) * 31) + this.userParticipantState.hashCode()) * 31) + this.currentTranscript.hashCode()) * 31) + this.botTranscript.hashCode()) * 31) + this.currentAudioDevice.hashCode()) * 31) + Boolean.hashCode(this.isSpeakerOn)) * 31) + Boolean.hashCode(this.isMicMuted)) * 31) + Boolean.hashCode(this.isSubtitleMode)) * 31;
        BrainstormSummary brainstormSummary = this.summary;
        int hashCode2 = (((((((((((((hashCode + (brainstormSummary == null ? 0 : brainstormSummary.hashCode())) * 31) + Long.hashCode(this.sessionStartTimeMs)) * 31) + Long.hashCode(this.sessionElapsedMs)) * 31) + this.timeoutState.hashCode()) * 31) + Integer.hashCode(this.timeoutRemainingSeconds)) * 31) + this.aiStageDescription.hashCode()) * 31) + Boolean.hashCode(this.isRtcJoined)) * 31;
        SubTaskUiState subTaskUiState = this.subTask;
        return ((((hashCode2 + (subTaskUiState != null ? subTaskUiState.hashCode() : 0)) * 31) + this.finishedSubTasks.hashCode()) * 31) + this.attachments.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("BrainstormUiState(phase=");
        sb.append(this.phase).append(", subtitleHistory=").append(this.subtitleHistory).append(", recordingState=").append(this.recordingState).append(", aiReplyState=").append(this.aiReplyState).append(", aiParticipantState=").append(this.aiParticipantState).append(", userParticipantState=").append(this.userParticipantState).append(", currentTranscript=").append(this.currentTranscript).append(", botTranscript=").append(this.botTranscript).append(", currentAudioDevice=").append(this.currentAudioDevice).append(", isSpeakerOn=").append(this.isSpeakerOn).append(", isMicMuted=").append(this.isMicMuted).append(", isSubtitleMode=");
        sb.append(this.isSubtitleMode).append(", summary=").append(this.summary).append(", sessionStartTimeMs=").append(this.sessionStartTimeMs).append(", sessionElapsedMs=").append(this.sessionElapsedMs).append(", timeoutState=").append(this.timeoutState).append(", timeoutRemainingSeconds=").append(this.timeoutRemainingSeconds).append(", aiStageDescription=").append(this.aiStageDescription).append(", isRtcJoined=").append(this.isRtcJoined).append(", subTask=").append(this.subTask).append(", finishedSubTasks=").append(this.finishedSubTasks).append(", attachments=").append(this.attachments).append(')');
        return sb.toString();
    }

    public BrainstormUiState(BrainstormPhase brainstormPhase, List<BrainstormMessage> list, RecordingState recordingState, AiReplyState aiReplyState, ParticipantState participantState, ParticipantState participantState2, String str, String str2, AudioDevice audioDevice, boolean z, boolean z2, boolean z3, BrainstormSummary brainstormSummary, long j, long j2, TimeoutState timeoutState, int i, String str3, boolean z4, SubTaskUiState subTaskUiState, Map<String, SubTaskUiState> map, List<BrainstormAttachment> list2) {
        Intrinsics.checkNotNullParameter(brainstormPhase, "phase");
        Intrinsics.checkNotNullParameter(list, "subtitleHistory");
        Intrinsics.checkNotNullParameter(recordingState, "recordingState");
        Intrinsics.checkNotNullParameter(aiReplyState, "aiReplyState");
        Intrinsics.checkNotNullParameter(participantState, "aiParticipantState");
        Intrinsics.checkNotNullParameter(participantState2, "userParticipantState");
        Intrinsics.checkNotNullParameter(str, "currentTranscript");
        Intrinsics.checkNotNullParameter(str2, "botTranscript");
        Intrinsics.checkNotNullParameter(audioDevice, "currentAudioDevice");
        Intrinsics.checkNotNullParameter(timeoutState, "timeoutState");
        Intrinsics.checkNotNullParameter(str3, "aiStageDescription");
        Intrinsics.checkNotNullParameter(map, "finishedSubTasks");
        Intrinsics.checkNotNullParameter(list2, "attachments");
        this.phase = brainstormPhase;
        this.subtitleHistory = list;
        this.recordingState = recordingState;
        this.aiReplyState = aiReplyState;
        this.aiParticipantState = participantState;
        this.userParticipantState = participantState2;
        this.currentTranscript = str;
        this.botTranscript = str2;
        this.currentAudioDevice = audioDevice;
        this.isSpeakerOn = z;
        this.isMicMuted = z2;
        this.isSubtitleMode = z3;
        this.summary = brainstormSummary;
        this.sessionStartTimeMs = j;
        this.sessionElapsedMs = j2;
        this.timeoutState = timeoutState;
        this.timeoutRemainingSeconds = i;
        this.aiStageDescription = str3;
        this.isRtcJoined = z4;
        this.subTask = subTaskUiState;
        this.finishedSubTasks = map;
        this.attachments = list2;
    }

    public /* synthetic */ BrainstormUiState(BrainstormPhase brainstormPhase, List list, RecordingState recordingState, AiReplyState aiReplyState, ParticipantState participantState, ParticipantState participantState2, String str, String str2, AudioDevice audioDevice, boolean z, boolean z2, boolean z3, BrainstormSummary brainstormSummary, long j, long j2, TimeoutState timeoutState, int i, String str3, boolean z4, SubTaskUiState subTaskUiState, Map map, List list2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? BrainstormPhase.Intro : brainstormPhase, (i2 & 2) != 0 ? CollectionsKt.emptyList() : list, (i2 & 4) != 0 ? RecordingState.Idle : recordingState, (i2 & 8) != 0 ? AiReplyState.Idle : aiReplyState, (i2 & 16) != 0 ? ParticipantState.Idle : participantState, (i2 & 32) != 0 ? ParticipantState.Idle : participantState2, (i2 & 64) != 0 ? "" : str, (i2 & 128) != 0 ? "" : str2, (i2 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? AudioDevice.Speaker : audioDevice, (i2 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? true : z, (i2 & 1024) != 0 ? false : z2, (i2 & 2048) != 0 ? false : z3, (i2 & 4096) != 0 ? null : brainstormSummary, (i2 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? System.currentTimeMillis() : j, (i2 & 16384) != 0 ? 0L : j2, (32768 & i2) != 0 ? TimeoutState.Normal : timeoutState, (i2 & 65536) != 0 ? -1 : i, (i2 & 131072) == 0 ? str3 : "", (i2 & 262144) != 0 ? false : z4, (i2 & FConstants.SLICE_SIZE) == 0 ? subTaskUiState : null, (i2 & 1048576) != 0 ? MapsKt.emptyMap() : map, (i2 & 2097152) != 0 ? CollectionsKt.emptyList() : list2);
    }

    public final BrainstormPhase getPhase() {
        return this.phase;
    }

    public final List<BrainstormMessage> getSubtitleHistory() {
        return this.subtitleHistory;
    }

    public final RecordingState getRecordingState() {
        return this.recordingState;
    }

    public final AiReplyState getAiReplyState() {
        return this.aiReplyState;
    }

    public final ParticipantState getAiParticipantState() {
        return this.aiParticipantState;
    }

    public final ParticipantState getUserParticipantState() {
        return this.userParticipantState;
    }

    public final String getCurrentTranscript() {
        return this.currentTranscript;
    }

    public final String getBotTranscript() {
        return this.botTranscript;
    }

    public final AudioDevice getCurrentAudioDevice() {
        return this.currentAudioDevice;
    }

    public final boolean isSpeakerOn() {
        return this.isSpeakerOn;
    }

    public final boolean isMicMuted() {
        return this.isMicMuted;
    }

    public final boolean isSubtitleMode() {
        return this.isSubtitleMode;
    }

    public final BrainstormSummary getSummary() {
        return this.summary;
    }

    public final long getSessionStartTimeMs() {
        return this.sessionStartTimeMs;
    }

    public final long getSessionElapsedMs() {
        return this.sessionElapsedMs;
    }

    public final TimeoutState getTimeoutState() {
        return this.timeoutState;
    }

    public final int getTimeoutRemainingSeconds() {
        return this.timeoutRemainingSeconds;
    }

    public final String getAiStageDescription() {
        return this.aiStageDescription;
    }

    public final boolean isRtcJoined() {
        return this.isRtcJoined;
    }

    public final SubTaskUiState getSubTask() {
        return this.subTask;
    }

    public final Map<String, SubTaskUiState> getFinishedSubTasks() {
        return this.finishedSubTasks;
    }

    public final List<BrainstormAttachment> getAttachments() {
        return this.attachments;
    }
}
