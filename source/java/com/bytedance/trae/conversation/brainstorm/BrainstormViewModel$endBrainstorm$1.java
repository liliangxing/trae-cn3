package com.bytedance.trae.conversation.brainstorm;

import com.bytedance.sdk.account.VcdNetConstants;
import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.brainstorm.model.BrainstormEndData;
import com.bytedance.trae.conversation.brainstorm.model.BrainstormUiState;
import com.bytedance.trae.conversation.brainstorm.model.RecordingState;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BrainstormViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.brainstorm.BrainstormViewModel$endBrainstorm$1", f = "BrainstormViewModel.kt", i = {}, l = {VcdNetConstants.API_VCD_GET_LOGIN_TICKET}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BrainstormViewModel$endBrainstorm$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BrainstormUiState $endState;
    final /* synthetic */ boolean $hasSummaryWorthyInput;
    final /* synthetic */ boolean $isAbort;
    final /* synthetic */ String $parentConversationId;
    int label;
    final /* synthetic */ BrainstormViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BrainstormViewModel$endBrainstorm$1(BrainstormUiState brainstormUiState, BrainstormViewModel brainstormViewModel, boolean z, boolean z2, String str, Continuation<? super BrainstormViewModel$endBrainstorm$1> continuation) {
        super(2, continuation);
        this.$endState = brainstormUiState;
        this.this$0 = brainstormViewModel;
        this.$hasSummaryWorthyInput = z;
        this.$isAbort = z2;
        this.$parentConversationId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BrainstormViewModel$endBrainstorm$1(this.$endState, this.this$0, this.$hasSummaryWorthyInput, this.$isAbort, this.$parentConversationId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        String formatDuration;
        Object value;
        BrainstormUiState copy;
        MutableSharedFlow mutableSharedFlow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            formatDuration = BrainstormViewModel.INSTANCE.formatDuration(System.currentTimeMillis() - this.$endState.getSessionStartTimeMs());
            MutableStateFlow mutableStateFlow = this.this$0._uiState;
            do {
                value = mutableStateFlow.getValue();
                copy = r6.copy((r42 & 1) != 0 ? r6.phase : null, (r42 & 2) != 0 ? r6.subtitleHistory : null, (r42 & 4) != 0 ? r6.recordingState : RecordingState.Idle, (r42 & 8) != 0 ? r6.aiReplyState : null, (r42 & 16) != 0 ? r6.aiParticipantState : null, (r42 & 32) != 0 ? r6.userParticipantState : null, (r42 & 64) != 0 ? r6.currentTranscript : null, (r42 & 128) != 0 ? r6.botTranscript : null, (r42 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? r6.currentAudioDevice : null, (r42 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? r6.isSpeakerOn : false, (r42 & 1024) != 0 ? r6.isMicMuted : false, (r42 & 2048) != 0 ? r6.isSubtitleMode : false, (r42 & 4096) != 0 ? r6.summary : null, (r42 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? r6.sessionStartTimeMs : 0L, (r42 & 16384) != 0 ? r6.sessionElapsedMs : 0L, (r42 & 32768) != 0 ? r6.timeoutState : null, (65536 & r42) != 0 ? r6.timeoutRemainingSeconds : 0, (r42 & 131072) != 0 ? r6.aiStageDescription : null, (r42 & 262144) != 0 ? r6.isRtcJoined : false, (r42 & FConstants.SLICE_SIZE) != 0 ? r6.subTask : null, (r42 & 1048576) != 0 ? r6.finishedSubTasks : null, (r42 & 2097152) != 0 ? ((BrainstormUiState) value).attachments : null);
            } while (!mutableStateFlow.compareAndSet(value, copy));
            mutableSharedFlow = this.this$0._brainstormEnded;
            boolean z = false;
            String string = this.$hasSummaryWorthyInput ? this.this$0.getApplication().getString(C0637R.string.trae_brainstorm_summary_query, new Object[]{formatDuration}) : "";
            Intrinsics.checkNotNull(string);
            boolean z2 = this.$isAbort;
            String str = this.$parentConversationId;
            if (!z2 && !this.$hasSummaryWorthyInput) {
                z = true;
            }
            this.label = 1;
            if (mutableSharedFlow.emit(new BrainstormEndData(string, z2, str, z), (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
