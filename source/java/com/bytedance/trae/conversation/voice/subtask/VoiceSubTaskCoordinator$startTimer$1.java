package com.bytedance.trae.conversation.voice.subtask;

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
@DebugMetadata(c = "com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator$startTimer$1", f = "VoiceSubTaskCoordinator.kt", i = {}, l = {2471}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class VoiceSubTaskCoordinator$startTimer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $sourceTaskId;
    final /* synthetic */ long $timeoutMs;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceSubTaskCoordinator$startTimer$1(long j, String str, Continuation<? super VoiceSubTaskCoordinator$startTimer$1> continuation) {
        super(2, continuation);
        this.$timeoutMs = j;
        this.$sourceTaskId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VoiceSubTaskCoordinator$startTimer$1(this.$timeoutMs, this.$sourceTaskId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        boolean z;
        MutableStateFlow mutableStateFlow;
        Set set;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.delay(this.$timeoutMs, (Continuation) this) == coroutine_suspended) {
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
        if (!set.contains(subTaskUiState.getState())) {
            return Unit.INSTANCE;
        }
        FLogger.INSTANCE.w("VoiceSubTaskCoord", "subTask timeout: sourceTaskId=" + this.$sourceTaskId + ", timeoutMs=" + this.$timeoutMs);
        VoiceSubTaskCoordinator.INSTANCE.cancelActiveTask("timeout", true);
        return Unit.INSTANCE;
    }
}
