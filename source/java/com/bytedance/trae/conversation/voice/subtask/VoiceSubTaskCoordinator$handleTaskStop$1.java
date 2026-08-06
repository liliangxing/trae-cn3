package com.bytedance.trae.conversation.voice.subtask;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator;
import com.bytedance.trae.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VoiceSubTaskCoordinator.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator$handleTaskStop$1", f = "VoiceSubTaskCoordinator.kt", i = {}, l = {1627}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class VoiceSubTaskCoordinator$handleTaskStop$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SubTaskUiState $current;
    final /* synthetic */ long $durationMs;
    final /* synthetic */ TaskStopMessage $msg;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceSubTaskCoordinator$handleTaskStop$1(SubTaskUiState subTaskUiState, TaskStopMessage taskStopMessage, long j, Continuation<? super VoiceSubTaskCoordinator$handleTaskStop$1> continuation) {
        super(2, continuation);
        this.$current = subTaskUiState;
        this.$msg = taskStopMessage;
        this.$durationMs = j;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VoiceSubTaskCoordinator$handleTaskStop$1(this.$current, this.$msg, this.$durationMs, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        VoiceSubTaskCoordinator.CancelOutcome.LocalOnly localOnly;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String proxyConversationId = this.$current.getProxyConversationId();
            String localTaskId = this.$current.getLocalTaskId();
            String str = proxyConversationId;
            if (!(str == null || str.length() == 0)) {
                String str2 = localTaskId;
                if (!(str2 == null || str2.length() == 0)) {
                    this.label = 1;
                    obj = VoiceSubTaskCoordinator.cancelClientProxyTaskForReuse$default(VoiceSubTaskCoordinator.INSTANCE, proxyConversationId, localTaskId, this.$current.getSourceTaskId(), TaskStopMessage.TYPE, 0L, (Continuation) this, 16, null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            localOnly = VoiceSubTaskCoordinator.CancelOutcome.LocalOnly.INSTANCE;
            FLogger.INSTANCE.d("VoiceSubTaskCoord", "handleTaskStop[ack]: taskId=" + this.$msg.getTaskId() + ", outcome=" + localOnly);
            VoiceSubTaskCoordinator.postSubTaskResultOnceAsync$default(VoiceSubTaskCoordinator.INSTANCE, this.$msg.getTaskId(), "success", "", this.$durationMs, null, null, "task-stop-client-proxy", 48, null);
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        localOnly = (VoiceSubTaskCoordinator.CancelOutcome) obj;
        FLogger.INSTANCE.d("VoiceSubTaskCoord", "handleTaskStop[ack]: taskId=" + this.$msg.getTaskId() + ", outcome=" + localOnly);
        VoiceSubTaskCoordinator.postSubTaskResultOnceAsync$default(VoiceSubTaskCoordinator.INSTANCE, this.$msg.getTaskId(), "success", "", this.$durationMs, null, null, "task-stop-client-proxy", 48, null);
        return Unit.INSTANCE;
    }
}
