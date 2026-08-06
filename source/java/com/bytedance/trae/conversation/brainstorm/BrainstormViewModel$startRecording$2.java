package com.bytedance.trae.conversation.brainstorm;

import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.trae.conversation.brainstorm.health.VoicePrompt;
import com.bytedance.trae.conversation.brainstorm.model.BrainstormUiState;
import com.bytedance.trae.conversation.brainstorm.model.ParticipantState;
import com.bytedance.trae.conversation.brainstorm.model.RecordingState;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.conversation.voice.VoiceDiscussionAttemptSignal;
import com.bytedance.trae.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BrainstormViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.brainstorm.BrainstormViewModel$startRecording$2", f = "BrainstormViewModel.kt", i = {}, l = {1758, 1771}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BrainstormViewModel$startRecording$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BMVoiceChatSessionManager $session;
    int label;
    final /* synthetic */ BrainstormViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BrainstormViewModel$startRecording$2(BrainstormViewModel brainstormViewModel, BMVoiceChatSessionManager bMVoiceChatSessionManager, Continuation<? super BrainstormViewModel$startRecording$2> continuation) {
        super(2, continuation);
        this.this$0 = brainstormViewModel;
        this.$session = bMVoiceChatSessionManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BrainstormViewModel$startRecording$2(this.this$0, this.$session, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object resolveVoiceConversationIdForRecording;
        BrainstormViewModel$voiceChatListener$1 brainstormViewModel$voiceChatListener$1;
        String rtcDiag;
        String rtcDiag2;
        Object value;
        BrainstormUiState copy;
        MutableSharedFlow mutableSharedFlow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = true;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            resolveVoiceConversationIdForRecording = this.this$0.resolveVoiceConversationIdForRecording((Continuation) this);
            if (resolveVoiceConversationIdForRecording == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            resolveVoiceConversationIdForRecording = obj;
        }
        String str = (String) resolveVoiceConversationIdForRecording;
        String str2 = str;
        if (str2 != null && !StringsKt.isBlank(str2)) {
            z = false;
        }
        if (!z) {
            BMVoiceChatSessionManager bMVoiceChatSessionManager = this.$session;
            brainstormViewModel$voiceChatListener$1 = this.this$0.voiceChatListener;
            bMVoiceChatSessionManager.start(brainstormViewModel$voiceChatListener$1, BMVoiceChatSessionManager.SCENE_ID_CHAT, str);
            FLogger fLogger = FLogger.INSTANCE;
            rtcDiag = this.this$0.rtcDiag("startRecording: session.start invoked, conversationId=" + str + ", scene=chat, sessionRunning=" + this.$session.getHasStartedVoiceChat() + ", room=" + this.$session.getRoomId() + ", task=" + this.$session.getTaskId());
            fLogger.d("BrainstormViewModel", rtcDiag);
            return Unit.INSTANCE;
        }
        BrainstormViewModel.recordVoiceAttemptSignal$default(this.this$0, VoiceDiscussionAttemptSignal.START_API_FAILED, "voice_conversation_id_empty", 0, 4, null);
        FLogger fLogger2 = FLogger.INSTANCE;
        rtcDiag2 = this.this$0.rtcDiag("startRecording: voice conversation id empty");
        fLogger2.w("BrainstormViewModel", rtcDiag2);
        MutableStateFlow mutableStateFlow = this.this$0._uiState;
        do {
            value = mutableStateFlow.getValue();
            copy = r5.copy((r42 & 1) != 0 ? r5.phase : null, (r42 & 2) != 0 ? r5.subtitleHistory : null, (r42 & 4) != 0 ? r5.recordingState : RecordingState.Idle, (r42 & 8) != 0 ? r5.aiReplyState : null, (r42 & 16) != 0 ? r5.aiParticipantState : null, (r42 & 32) != 0 ? r5.userParticipantState : ParticipantState.Idle, (r42 & 64) != 0 ? r5.currentTranscript : null, (r42 & 128) != 0 ? r5.botTranscript : null, (r42 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? r5.currentAudioDevice : null, (r42 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? r5.isSpeakerOn : false, (r42 & 1024) != 0 ? r5.isMicMuted : false, (r42 & 2048) != 0 ? r5.isSubtitleMode : false, (r42 & 4096) != 0 ? r5.summary : null, (r42 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? r5.sessionStartTimeMs : 0L, (r42 & 16384) != 0 ? r5.sessionElapsedMs : 0L, (r42 & 32768) != 0 ? r5.timeoutState : null, (65536 & r42) != 0 ? r5.timeoutRemainingSeconds : 0, (r42 & 131072) != 0 ? r5.aiStageDescription : null, (r42 & 262144) != 0 ? r5.isRtcJoined : false, (r42 & FConstants.SLICE_SIZE) != 0 ? r5.subTask : null, (r42 & 1048576) != 0 ? r5.finishedSubTasks : null, (r42 & 2097152) != 0 ? ((BrainstormUiState) value).attachments : null);
        } while (!mutableStateFlow.compareAndSet(value, copy));
        mutableSharedFlow = this.this$0._voicePromptEvents;
        this.label = 2;
        if (mutableSharedFlow.emit(VoicePrompt.Runtime.StartFailed.INSTANCE, (Continuation) this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
