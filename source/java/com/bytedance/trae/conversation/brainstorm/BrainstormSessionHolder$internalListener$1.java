package com.bytedance.trae.conversation.brainstorm;

import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.timonbase.scene.PageDataManager;
import com.bytedance.tracing.log.Fields;
import com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager;
import com.bytedance.trae.conversation.brainstorm.model.BrainstormMessage;
import com.bytedance.trae.conversation.brainstorm.model.BrainstormUiState;
import com.bytedance.trae.conversation.voice.ConversationStateMessage;
import com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptSignal;
import com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptStage;
import com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptState;
import com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptTracker;
import com.bytedance.trae.conversation.voice.VoiceDiscussionMetrics;
import com.bytedance.trae.conversation.voice.network.StartVoiceChatData;
import com.bytedance.trae.conversation.voice.rtc.VolcRtcClient;
import com.bytedance.trae.conversation.voice.subtask.SubTaskProtocolKt;
import com.bytedance.trae.conversation.voice.subtask.SubTaskRequestMessage;
import com.bytedance.trae.conversation.voice.subtask.TaskStartMessage;
import com.bytedance.trae.conversation.voice.subtask.TaskStopMessage;
import com.bytedance.trae.conversation.voice.subtask.ToolResultMessage;
import com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator;
import com.bytedance.trae.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;

/* compiled from: BrainstormSessionHolder.kt */
@Metadata(d1 = {"\u0000U\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\bH\u0016¨\u0006!"}, d2 = {"com/bytedance/trae/conversation/brainstorm/BrainstormSessionHolder$internalListener$1", "Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener;", "onStatus", "", PageDataManager.EXTRA_STATUS, "Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Status;", "onRecognizedText", "text", "", "role", "Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$MessageRole;", "onSubtitleText", "onFinalText", "onError", "error", "", "onConversationStateChanged", "state", "Lcom/bytedance/trae/conversation/voice/ConversationStateMessage;", "onLocalAudioVolume", "volume", "", "onPerfTimestamp", Fields.EVENT, "Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$PerfEvent;", "timestampMs", "", "onVoiceChatDataReady", "data", "Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;", "onRtcTextMessage", "uid", "message", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BrainstormSessionHolder$internalListener$1 implements BMVoiceChatSessionManager.Listener {
    @Override // com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager.Listener
    public void onPerfTimestamp(BMVoiceChatSessionManager.PerfEvent event, long timestampMs) {
        Intrinsics.checkNotNullParameter(event, Fields.EVENT);
    }

    @Override // com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager.Listener
    public void onRecognizedText(String text, BMVoiceChatSessionManager.MessageRole role) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(role, "role");
    }

    @Override // com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager.Listener
    public void onSubtitleText(String text, BMVoiceChatSessionManager.MessageRole role) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(role, "role");
    }

    @Override // com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager.Listener
    public void onRtcAudioInputDeviceStateChanged(String str, int i, int i2) {
        BMVoiceChatSessionManager.Listener.DefaultImpls.onRtcAudioInputDeviceStateChanged(this, str, i, i2);
    }

    @Override // com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager.Listener
    public void onRtcAudioProperties(VolcRtcClient.RtcLocalAudioProperties rtcLocalAudioProperties) {
        BMVoiceChatSessionManager.Listener.DefaultImpls.onRtcAudioProperties(this, rtcLocalAudioProperties);
    }

    @Override // com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager.Listener
    public void onRtcNetworkQuality(VolcRtcClient.RtcNetworkQuality rtcNetworkQuality, List<VolcRtcClient.RtcNetworkQuality> list) {
        BMVoiceChatSessionManager.Listener.DefaultImpls.onRtcNetworkQuality(this, rtcNetworkQuality, list);
    }

    @Override // com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager.Listener
    public void onStatus(BMVoiceChatSessionManager.Status status) {
        Intrinsics.checkNotNullParameter(status, PageDataManager.EXTRA_STATUS);
        if (status == BMVoiceChatSessionManager.Status.JoinedRoom) {
            BrainstormSessionHolder.INSTANCE.withVoiceDiscussionAttempt(new Function1() { // from class: com.bytedance.trae.conversation.brainstorm.BrainstormSessionHolder$internalListener$1$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit onStatus$lambda$0;
                    onStatus$lambda$0 = BrainstormSessionHolder$internalListener$1.onStatus$lambda$0((VoiceDiscussionAttemptTracker) obj);
                    return onStatus$lambda$0;
                }
            });
        }
        FLogger.INSTANCE.d("BrainstormHolder", "internalListener.onStatus: " + status);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onStatus$lambda$0(VoiceDiscussionAttemptTracker voiceDiscussionAttemptTracker) {
        Intrinsics.checkNotNullParameter(voiceDiscussionAttemptTracker, "tracker");
        voiceDiscussionAttemptTracker.recordStage(VoiceDiscussionAttemptStage.RTC_JOINED);
        return Unit.INSTANCE;
    }

    @Override // com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager.Listener
    public void onFinalText(String text, BMVoiceChatSessionManager.MessageRole role) {
        HolderSnapshot holderSnapshot;
        HolderSnapshot holderSnapshot2;
        BrainstormMessage buildBrainstormMessage;
        MutableStateFlow mutableStateFlow;
        BrainstormUiState copy;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(role, "role");
        if (StringsKt.isBlank(text)) {
            return;
        }
        if (role == BMVoiceChatSessionManager.MessageRole.USER) {
            BrainstormSessionHolder.INSTANCE.withVoiceDiscussionAttempt(new Function1() { // from class: com.bytedance.trae.conversation.brainstorm.BrainstormSessionHolder$internalListener$1$$ExternalSyntheticLambda4
                public final Object invoke(Object obj) {
                    Unit onFinalText$lambda$1;
                    onFinalText$lambda$1 = BrainstormSessionHolder$internalListener$1.onFinalText$lambda$1((VoiceDiscussionAttemptTracker) obj);
                    return onFinalText$lambda$1;
                }
            });
        }
        BrainstormSessionHolder brainstormSessionHolder = BrainstormSessionHolder.INSTANCE;
        holderSnapshot = BrainstormSessionHolder.currentSnapshot;
        if (holderSnapshot != null) {
            List<BrainstormMessage> subtitleHistory = holderSnapshot.getUiState().getSubtitleHistory();
            buildBrainstormMessage = BrainstormSessionHolder.INSTANCE.buildBrainstormMessage(text, role);
            List plus = CollectionsKt.plus(subtitleHistory, buildBrainstormMessage);
            mutableStateFlow = BrainstormSessionHolder._subtitleHistorySize;
            mutableStateFlow.setValue(Integer.valueOf(plus.size()));
            copy = r4.copy((r42 & 1) != 0 ? r4.phase : null, (r42 & 2) != 0 ? r4.subtitleHistory : plus, (r42 & 4) != 0 ? r4.recordingState : null, (r42 & 8) != 0 ? r4.aiReplyState : null, (r42 & 16) != 0 ? r4.aiParticipantState : null, (r42 & 32) != 0 ? r4.userParticipantState : null, (r42 & 64) != 0 ? r4.currentTranscript : null, (r42 & 128) != 0 ? r4.botTranscript : null, (r42 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? r4.currentAudioDevice : null, (r42 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? r4.isSpeakerOn : false, (r42 & 1024) != 0 ? r4.isMicMuted : false, (r42 & 2048) != 0 ? r4.isSubtitleMode : false, (r42 & 4096) != 0 ? r4.summary : null, (r42 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? r4.sessionStartTimeMs : 0L, (r42 & 16384) != 0 ? r4.sessionElapsedMs : 0L, (r42 & 32768) != 0 ? r4.timeoutState : null, (65536 & r42) != 0 ? r4.timeoutRemainingSeconds : 0, (r42 & 131072) != 0 ? r4.aiStageDescription : null, (r42 & 262144) != 0 ? r4.isRtcJoined : false, (r42 & FConstants.SLICE_SIZE) != 0 ? r4.subTask : null, (r42 & 1048576) != 0 ? r4.finishedSubTasks : null, (r42 & 2097152) != 0 ? holderSnapshot.getUiState().attachments : null);
            holderSnapshot2 = holderSnapshot.copy((r45 & 1) != 0 ? holderSnapshot.uiState : copy, (r45 & 2) != 0 ? holderSnapshot.cliConversationId : null, (r45 & 4) != 0 ? holderSnapshot.parentConversationId : null, (r45 & 8) != 0 ? holderSnapshot.originConversationId : null, (r45 & 16) != 0 ? holderSnapshot.voiceCliType : null, (r45 & 32) != 0 ? holderSnapshot.voiceMode : null, (r45 & 64) != 0 ? holderSnapshot.attachmentSubTaskEnabled : false, (r45 & 128) != 0 ? holderSnapshot.perfMicCheckStartMs : 0L, (r45 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? holderSnapshot.perfMicCheckEndMs : 0L, (r45 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? holderSnapshot.perfApiRequestStartMs : 0L, (r45 & 1024) != 0 ? holderSnapshot.perfJoinRoomStartMs : 0L, (r45 & 2048) != 0 ? holderSnapshot.perfJoinRoomSuccessMs : 0L, (r45 & 4096) != 0 ? holderSnapshot.perfBotJoinedMs : 0L, (r45 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? holderSnapshot.perfIsNewSession : false, (r45 & 16384) != 0 ? holderSnapshot.discussionStartPerfReported : false, (r45 & 32768) != 0 ? holderSnapshot.sessionUserMessageCount : 0, (r45 & 65536) != 0 ? holderSnapshot.sessionBotMessageCount : 0, (r45 & 131072) != 0 ? holderSnapshot.sessionUserSpeakEndTimestamps : null, (r45 & 262144) != 0 ? holderSnapshot.sessionBotSpeakStartTimestamps : null, (r45 & FConstants.SLICE_SIZE) != 0 ? holderSnapshot.sessionHasEverEnabledSubtitle : false, (r45 & 1048576) != 0 ? holderSnapshot.voiceDiscussionAttemptState : null);
        } else {
            holderSnapshot2 = null;
        }
        BrainstormSessionHolder.currentSnapshot = holderSnapshot2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onFinalText$lambda$1(VoiceDiscussionAttemptTracker voiceDiscussionAttemptTracker) {
        Intrinsics.checkNotNullParameter(voiceDiscussionAttemptTracker, "tracker");
        voiceDiscussionAttemptTracker.recordStage(VoiceDiscussionAttemptStage.USER_FINAL_RECEIVED);
        return Unit.INSTANCE;
    }

    @Override // com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager.Listener
    public void onError(Throwable error) {
        Intrinsics.checkNotNullParameter(error, "error");
        BrainstormSessionHolder.INSTANCE.withVoiceDiscussionAttempt(new Function1() { // from class: com.bytedance.trae.conversation.brainstorm.BrainstormSessionHolder$internalListener$1$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit onError$lambda$3;
                onError$lambda$3 = BrainstormSessionHolder$internalListener$1.onError$lambda$3((VoiceDiscussionAttemptTracker) obj);
                return onError$lambda$3;
            }
        });
        FLogger.INSTANCE.w("BrainstormHolder", "internalListener.onError", error);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onError$lambda$3(VoiceDiscussionAttemptTracker voiceDiscussionAttemptTracker) {
        Intrinsics.checkNotNullParameter(voiceDiscussionAttemptTracker, "tracker");
        VoiceDiscussionAttemptTracker.recordSignal$default(voiceDiscussionAttemptTracker, VoiceDiscussionAttemptSignal.RTC_ERROR, "rtc_runtime_error_minimized", 0, 4, null);
        return Unit.INSTANCE;
    }

    @Override // com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager.Listener
    public void onConversationStateChanged(final ConversationStateMessage state) {
        Intrinsics.checkNotNullParameter(state, "state");
        int code = state.getStage().getCode();
        if (code == 0) {
            BrainstormSessionHolder.INSTANCE.withVoiceDiscussionAttempt(new Function1() { // from class: com.bytedance.trae.conversation.brainstorm.BrainstormSessionHolder$internalListener$1$$ExternalSyntheticLambda3
                public final Object invoke(Object obj) {
                    Unit onConversationStateChanged$lambda$5;
                    onConversationStateChanged$lambda$5 = BrainstormSessionHolder$internalListener$1.onConversationStateChanged$lambda$5(ConversationStateMessage.this, (VoiceDiscussionAttemptTracker) obj);
                    return onConversationStateChanged$lambda$5;
                }
            });
        } else if (code == 2) {
            BrainstormSessionHolder.INSTANCE.withVoiceDiscussionAttempt(new Function1() { // from class: com.bytedance.trae.conversation.brainstorm.BrainstormSessionHolder$internalListener$1$$ExternalSyntheticLambda2
                public final Object invoke(Object obj) {
                    Unit onConversationStateChanged$lambda$4;
                    onConversationStateChanged$lambda$4 = BrainstormSessionHolder$internalListener$1.onConversationStateChanged$lambda$4((VoiceDiscussionAttemptTracker) obj);
                    return onConversationStateChanged$lambda$4;
                }
            });
        }
        FLogger.INSTANCE.d("BrainstormHolder", "internalListener.onConversationStateChanged: " + state.getStage().getCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onConversationStateChanged$lambda$4(VoiceDiscussionAttemptTracker voiceDiscussionAttemptTracker) {
        Intrinsics.checkNotNullParameter(voiceDiscussionAttemptTracker, "tracker");
        voiceDiscussionAttemptTracker.recordStage(VoiceDiscussionAttemptStage.THINKING_RECEIVED);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onConversationStateChanged$lambda$5(ConversationStateMessage conversationStateMessage, VoiceDiscussionAttemptTracker voiceDiscussionAttemptTracker) {
        Intrinsics.checkNotNullParameter(voiceDiscussionAttemptTracker, "tracker");
        VoiceDiscussionAttemptSignal voiceDiscussionAttemptSignal = VoiceDiscussionAttemptSignal.CONVERSATION_ERROR;
        StringBuilder sb = new StringBuilder("conversation_error_");
        ConversationStateMessage.ErrorDetail errorInfo = conversationStateMessage.getErrorInfo();
        String sb2 = sb.append(errorInfo != null ? Integer.valueOf(errorInfo.getErrorCode()) : null).toString();
        ConversationStateMessage.ErrorDetail errorInfo2 = conversationStateMessage.getErrorInfo();
        voiceDiscussionAttemptTracker.recordSignal(voiceDiscussionAttemptSignal, sb2, errorInfo2 != null ? errorInfo2.getErrorCode() : 0);
        return Unit.INSTANCE;
    }

    @Override // com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager.Listener
    public void onLocalAudioVolume(final float volume) {
        HolderSnapshot holderSnapshot;
        MutableSharedFlow mutableSharedFlow;
        holderSnapshot = BrainstormSessionHolder.currentSnapshot;
        VoiceDiscussionAttemptState voiceDiscussionAttemptState = holderSnapshot != null ? holderSnapshot.getVoiceDiscussionAttemptState() : null;
        if (VoiceDiscussionAttemptTracker.INSTANCE.isVoiceDetected(volume) && voiceDiscussionAttemptState != null && !voiceDiscussionAttemptState.getStageElapsedMs().containsKey(VoiceDiscussionAttemptStage.FIRST_VOICE_DETECTED.getValue())) {
            BrainstormSessionHolder.INSTANCE.withVoiceDiscussionAttempt(new Function1() { // from class: com.bytedance.trae.conversation.brainstorm.BrainstormSessionHolder$internalListener$1$$ExternalSyntheticLambda5
                public final Object invoke(Object obj) {
                    Unit onLocalAudioVolume$lambda$6;
                    onLocalAudioVolume$lambda$6 = BrainstormSessionHolder$internalListener$1.onLocalAudioVolume$lambda$6(volume, (VoiceDiscussionAttemptTracker) obj);
                    return onLocalAudioVolume$lambda$6;
                }
            });
        }
        mutableSharedFlow = BrainstormSessionHolder._localAudioVolume;
        mutableSharedFlow.tryEmit(Float.valueOf(volume));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onLocalAudioVolume$lambda$6(float f, VoiceDiscussionAttemptTracker voiceDiscussionAttemptTracker) {
        Intrinsics.checkNotNullParameter(voiceDiscussionAttemptTracker, "tracker");
        voiceDiscussionAttemptTracker.onLocalAudioVolume(f);
        return Unit.INSTANCE;
    }

    @Override // com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager.Listener
    public void onVoiceChatDataReady(StartVoiceChatData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        VoiceSubTaskCoordinator.INSTANCE.updateSubTaskConfig(data.getSubTaskConfig());
    }

    @Override // com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager.Listener
    public void onRtcTextMessage(String uid, String message) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(message, "message");
        String peekSubTaskMessageType = SubTaskProtocolKt.peekSubTaskMessageType(message);
        if (peekSubTaskMessageType != null) {
            switch (peekSubTaskMessageType.hashCode()) {
                case -906867340:
                    if (peekSubTaskMessageType.equals(SubTaskRequestMessage.TYPE)) {
                        SubTaskRequestMessage parseSubTaskRequest = SubTaskProtocolKt.parseSubTaskRequest(message);
                        if (parseSubTaskRequest == null) {
                            BrainstormSessionHolder.INSTANCE.logUnrecognizedRtcFrame(uid, message, "invalid sub_task_request");
                            return;
                        }
                        BMVoiceChatSessionManager voiceChatSession$conversation_mainlandRelease = BrainstormSessionHolder.INSTANCE.getVoiceChatSession$conversation_mainlandRelease();
                        String roomId = voiceChatSession$conversation_mainlandRelease != null ? voiceChatSession$conversation_mainlandRelease.getRoomId() : null;
                        str = roomId != null ? roomId : "";
                        str2 = str.length() > 0 ? str : null;
                        FLogger.INSTANCE.d("BrainstormHolder", "internalListener.onRtcTextMessage: forward sub_task_request, taskId=" + parseSubTaskRequest.getTaskId() + ", room=" + parseSubTaskRequest.getRoomId() + ", currentRoom=" + str2);
                        VoiceSubTaskCoordinator.INSTANCE.handleSubTaskRequest(parseSubTaskRequest, str2);
                        return;
                    }
                    break;
                case 180893308:
                    if (peekSubTaskMessageType.equals(TaskStopMessage.TYPE)) {
                        TaskStopMessage parseTaskStop = SubTaskProtocolKt.parseTaskStop(message);
                        if (parseTaskStop == null) {
                            BrainstormSessionHolder.INSTANCE.logUnrecognizedRtcFrame(uid, message, "invalid task_stop");
                            return;
                        }
                        BMVoiceChatSessionManager voiceChatSession$conversation_mainlandRelease2 = BrainstormSessionHolder.INSTANCE.getVoiceChatSession$conversation_mainlandRelease();
                        String roomId2 = voiceChatSession$conversation_mainlandRelease2 != null ? voiceChatSession$conversation_mainlandRelease2.getRoomId() : null;
                        str = roomId2 != null ? roomId2 : "";
                        str2 = str.length() > 0 ? str : null;
                        FLogger.INSTANCE.d("BrainstormHolder", "internalListener.onRtcTextMessage: forward " + parseTaskStop.getType() + ", taskId=" + parseTaskStop.getTaskId() + ", room=" + parseTaskStop.getRoomId() + ", currentRoom=" + str2);
                        VoiceSubTaskCoordinator.INSTANCE.handleTaskStop(parseTaskStop, str2);
                        return;
                    }
                    break;
                case 1312711976:
                    if (peekSubTaskMessageType.equals(TaskStartMessage.TYPE)) {
                        TaskStartMessage parseTaskStart = SubTaskProtocolKt.parseTaskStart(message);
                        if (parseTaskStart == null) {
                            BrainstormSessionHolder.INSTANCE.logUnrecognizedRtcFrame(uid, message, "invalid task_start");
                            return;
                        }
                        FLogger.INSTANCE.d("BrainstormHolder", "internalListener.onRtcTextMessage: forward " + parseTaskStart.getType() + ", taskId=" + parseTaskStart.getTaskId() + ", tool=" + parseTaskStart.getToolName());
                        VoiceDiscussionMetrics.INSTANCE.recordServerToolStart(parseTaskStart);
                        VoiceSubTaskCoordinator.INSTANCE.handleTaskStart(parseTaskStart);
                        return;
                    }
                    break;
                case 1997422615:
                    if (peekSubTaskMessageType.equals(ToolResultMessage.TYPE)) {
                        ToolResultMessage parseToolResult = SubTaskProtocolKt.parseToolResult(message);
                        if (parseToolResult == null) {
                            BrainstormSessionHolder.INSTANCE.logUnrecognizedRtcFrame(uid, message, "invalid task_result");
                            return;
                        }
                        FLogger.INSTANCE.d("BrainstormHolder", "internalListener.onRtcTextMessage: forward " + parseToolResult.getType() + ", taskId=" + parseToolResult.getTaskId() + ", tool=" + parseToolResult.getToolName() + ", status=" + parseToolResult.getStatus());
                        if (VoiceSubTaskCoordinator.INSTANCE.handleToolResult(parseToolResult)) {
                            BrainstormSessionHolder.INSTANCE.reportServerToolEnd(parseToolResult);
                            return;
                        }
                        return;
                    }
                    break;
                case 2093002947:
                    if (peekSubTaskMessageType.equals(SubTaskRequestMessage.TYPE_UPDATE)) {
                        SubTaskRequestMessage parseSubTaskUpdate = SubTaskProtocolKt.parseSubTaskUpdate(message);
                        if (parseSubTaskUpdate == null) {
                            BrainstormSessionHolder.INSTANCE.logUnrecognizedRtcFrame(uid, message, "invalid task_update");
                            return;
                        }
                        BMVoiceChatSessionManager voiceChatSession$conversation_mainlandRelease3 = BrainstormSessionHolder.INSTANCE.getVoiceChatSession$conversation_mainlandRelease();
                        String roomId3 = voiceChatSession$conversation_mainlandRelease3 != null ? voiceChatSession$conversation_mainlandRelease3.getRoomId() : null;
                        str = roomId3 != null ? roomId3 : "";
                        str2 = str.length() > 0 ? str : null;
                        FLogger.INSTANCE.d("BrainstormHolder", "internalListener.onRtcTextMessage: forward task_update, taskId=" + parseSubTaskUpdate.getTaskId() + ", room=" + parseSubTaskUpdate.getRoomId() + ", currentRoom=" + str2);
                        VoiceSubTaskCoordinator.INSTANCE.handleSubTaskUpdate(parseSubTaskUpdate, str2);
                        return;
                    }
                    break;
            }
        }
        SubTaskRequestMessage parseSubTaskRequest2 = SubTaskProtocolKt.parseSubTaskRequest(message);
        if (parseSubTaskRequest2 != null) {
            BMVoiceChatSessionManager voiceChatSession$conversation_mainlandRelease4 = BrainstormSessionHolder.INSTANCE.getVoiceChatSession$conversation_mainlandRelease();
            String roomId4 = voiceChatSession$conversation_mainlandRelease4 != null ? voiceChatSession$conversation_mainlandRelease4.getRoomId() : null;
            str = roomId4 != null ? roomId4 : "";
            str2 = str.length() > 0 ? str : null;
            FLogger.INSTANCE.d("BrainstormHolder", "internalListener.onRtcTextMessage: forward sub_task_request, taskId=" + parseSubTaskRequest2.getTaskId() + ", room=" + parseSubTaskRequest2.getRoomId() + ", currentRoom=" + str2);
            VoiceSubTaskCoordinator.INSTANCE.handleSubTaskRequest(parseSubTaskRequest2, str2);
            return;
        }
        SubTaskRequestMessage parseSubTaskUpdate2 = SubTaskProtocolKt.parseSubTaskUpdate(message);
        if (parseSubTaskUpdate2 != null) {
            BMVoiceChatSessionManager voiceChatSession$conversation_mainlandRelease5 = BrainstormSessionHolder.INSTANCE.getVoiceChatSession$conversation_mainlandRelease();
            String roomId5 = voiceChatSession$conversation_mainlandRelease5 != null ? voiceChatSession$conversation_mainlandRelease5.getRoomId() : null;
            str = roomId5 != null ? roomId5 : "";
            str2 = str.length() > 0 ? str : null;
            FLogger.INSTANCE.d("BrainstormHolder", "internalListener.onRtcTextMessage: forward task_update, taskId=" + parseSubTaskUpdate2.getTaskId() + ", room=" + parseSubTaskUpdate2.getRoomId() + ", currentRoom=" + str2);
            VoiceSubTaskCoordinator.INSTANCE.handleSubTaskUpdate(parseSubTaskUpdate2, str2);
            return;
        }
        TaskStartMessage parseTaskStart2 = SubTaskProtocolKt.parseTaskStart(message);
        if (parseTaskStart2 != null) {
            FLogger.INSTANCE.d("BrainstormHolder", "internalListener.onRtcTextMessage: forward " + parseTaskStart2.getType() + ", taskId=" + parseTaskStart2.getTaskId() + ", tool=" + parseTaskStart2.getToolName());
            VoiceDiscussionMetrics.INSTANCE.recordServerToolStart(parseTaskStart2);
            VoiceSubTaskCoordinator.INSTANCE.handleTaskStart(parseTaskStart2);
            return;
        }
        TaskStopMessage parseTaskStop2 = SubTaskProtocolKt.parseTaskStop(message);
        if (parseTaskStop2 != null) {
            BMVoiceChatSessionManager voiceChatSession$conversation_mainlandRelease6 = BrainstormSessionHolder.INSTANCE.getVoiceChatSession$conversation_mainlandRelease();
            String roomId6 = voiceChatSession$conversation_mainlandRelease6 != null ? voiceChatSession$conversation_mainlandRelease6.getRoomId() : null;
            str = roomId6 != null ? roomId6 : "";
            str2 = str.length() > 0 ? str : null;
            FLogger.INSTANCE.d("BrainstormHolder", "internalListener.onRtcTextMessage: forward " + parseTaskStop2.getType() + ", taskId=" + parseTaskStop2.getTaskId() + ", room=" + parseTaskStop2.getRoomId() + ", currentRoom=" + str2);
            VoiceSubTaskCoordinator.INSTANCE.handleTaskStop(parseTaskStop2, str2);
            return;
        }
        ToolResultMessage parseToolResult2 = SubTaskProtocolKt.parseToolResult(message);
        if (parseToolResult2 == null) {
            BrainstormSessionHolder.logUnrecognizedRtcFrame$default(BrainstormSessionHolder.INSTANCE, uid, message, null, 4, null);
            return;
        }
        FLogger.INSTANCE.d("BrainstormHolder", "internalListener.onRtcTextMessage: forward " + parseToolResult2.getType() + ", taskId=" + parseToolResult2.getTaskId() + ", tool=" + parseToolResult2.getToolName() + ", status=" + parseToolResult2.getStatus());
        if (VoiceSubTaskCoordinator.INSTANCE.handleToolResult(parseToolResult2)) {
            BrainstormSessionHolder.INSTANCE.reportServerToolEnd(parseToolResult2);
        }
    }
}
