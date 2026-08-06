package com.bytedance.trae.conversation.voice.subtask;

import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.utils.logger.FLogger;
import java.util.Set;
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
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VoiceSubTaskCoordinator.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator$startLongRunningJob$1", f = "VoiceSubTaskCoordinator.kt", i = {}, l = {2498}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class VoiceSubTaskCoordinator$startLongRunningJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $sourceTaskId;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceSubTaskCoordinator$startLongRunningJob$1(String str, Continuation<? super VoiceSubTaskCoordinator$startLongRunningJob$1> continuation) {
        super(2, continuation);
        this.$sourceTaskId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VoiceSubTaskCoordinator$startLongRunningJob$1(this.$sourceTaskId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        boolean z;
        MutableStateFlow mutableStateFlow;
        Set set;
        MutableStateFlow mutableStateFlow2;
        SubTaskUiState copy;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.delay(SubTaskUiState.LONG_RUNNING_THRESHOLD_MS, (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        z = VoiceSubTaskCoordinator.started;
        if (!z) {
            return Unit.INSTANCE;
        }
        mutableStateFlow = VoiceSubTaskCoordinator._activeTask;
        SubTaskUiState subTaskUiState = (SubTaskUiState) mutableStateFlow.getValue();
        if (!Intrinsics.areEqual(subTaskUiState != null ? subTaskUiState.getSourceTaskId() : null, this.$sourceTaskId)) {
            return Unit.INSTANCE;
        }
        set = VoiceSubTaskCoordinator.IN_FLIGHT_STATES;
        if (set.contains(subTaskUiState.getState()) && !subTaskUiState.getLongRunning()) {
            mutableStateFlow2 = VoiceSubTaskCoordinator._activeTask;
            copy = subTaskUiState.copy((r28 & 1) != 0 ? subTaskUiState.sourceTaskId : null, (r28 & 2) != 0 ? subTaskUiState.taskDescription : null, (r28 & 4) != 0 ? subTaskUiState.localTaskId : null, (r28 & 8) != 0 ? subTaskUiState.proxyConversationId : null, (r28 & 16) != 0 ? subTaskUiState.proxyChatSessionId : null, (r28 & 32) != 0 ? subTaskUiState.state : null, (r28 & 64) != 0 ? subTaskUiState.content : null, (r28 & 128) != 0 ? subTaskUiState.failureReason : null, (r28 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? subTaskUiState.createStartedAtMs : 0L, (r28 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? subTaskUiState.longRunning : true, (r28 & 1024) != 0 ? subTaskUiState.executor : null, (r28 & 2048) != 0 ? subTaskUiState.toolName : null);
            mutableStateFlow2.setValue(copy);
            FLogger.INSTANCE.d("VoiceSubTaskCoord", "subTask longRunning: sourceTaskId=" + this.$sourceTaskId);
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}
