package com.bytedance.trae.conversation.voice.subtask;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator;
import com.bytedance.trae.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VoiceSubTaskCoordinator.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator$queueSubTaskSupersede$1", f = "VoiceSubTaskCoordinator.kt", i = {0}, l = {908}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class VoiceSubTaskCoordinator$queueSubTaskSupersede$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SubTaskUiState $current;
    final /* synthetic */ Job $previousCreateJob;
    final /* synthetic */ String $previousTaskId;
    private /* synthetic */ Object L$0;
    int label;

    /* compiled from: VoiceSubTaskCoordinator.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SubTaskExecutor.values().length];
            try {
                iArr[SubTaskExecutor.ClientProxy.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SubTaskExecutor.ServerClosedLoop.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceSubTaskCoordinator$queueSubTaskSupersede$1(SubTaskUiState subTaskUiState, Job job, String str, Continuation<? super VoiceSubTaskCoordinator$queueSubTaskSupersede$1> continuation) {
        super(2, continuation);
        this.$current = subTaskUiState;
        this.$previousCreateJob = job;
        this.$previousTaskId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> voiceSubTaskCoordinator$queueSubTaskSupersede$1 = new VoiceSubTaskCoordinator$queueSubTaskSupersede$1(this.$current, this.$previousCreateJob, this.$previousTaskId, continuation);
        voiceSubTaskCoordinator$queueSubTaskSupersede$1.L$0 = obj;
        return voiceSubTaskCoordinator$queueSubTaskSupersede$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:78:0x0259  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        Throwable th;
        Object cancelPreviousTaskForSwitch;
        CoroutineContext.Element element;
        boolean z;
        String str;
        SubTaskRequestMessage subTaskRequestMessage;
        SubTaskExecutor subTaskExecutor;
        MutableStateFlow mutableStateFlow;
        CoroutineContext.Element element2;
        CoroutineContext.Element element3;
        CoroutineContext.Element element4;
        SubTaskRequestMessage subTaskRequestMessage2;
        SubTaskExecutor subTaskExecutor2;
        CoroutineContext.Element element5;
        String str2;
        CoroutineContext.Element element6;
        CoroutineContext.Element element7;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            try {
                this.L$0 = coroutineScope2;
                this.label = 1;
                cancelPreviousTaskForSwitch = VoiceSubTaskCoordinator.INSTANCE.cancelPreviousTaskForSwitch(this.$current, this.$previousCreateJob, (Continuation) this);
                if (cancelPreviousTaskForSwitch == coroutine_suspended) {
                    return coroutine_suspended;
                }
                coroutineScope = coroutineScope2;
                obj = cancelPreviousTaskForSwitch;
            } catch (Throwable th2) {
                coroutineScope = coroutineScope2;
                th = th2;
                element = VoiceSubTaskCoordinator.pendingClientProxyStartJob;
                if (element == coroutineScope.getCoroutineContext().get(Job.Key)) {
                }
                throw th;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            coroutineScope = (CoroutineScope) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th3) {
                th = th3;
                element = VoiceSubTaskCoordinator.pendingClientProxyStartJob;
                if (element == coroutineScope.getCoroutineContext().get(Job.Key)) {
                    VoiceSubTaskCoordinator voiceSubTaskCoordinator = VoiceSubTaskCoordinator.INSTANCE;
                    VoiceSubTaskCoordinator.pendingClientProxyStartJob = null;
                }
                throw th;
            }
        }
        VoiceSubTaskCoordinator.CancelOutcome cancelOutcome = (VoiceSubTaskCoordinator.CancelOutcome) obj;
        z = VoiceSubTaskCoordinator.started;
        if (!z) {
            Unit unit = Unit.INSTANCE;
            element7 = VoiceSubTaskCoordinator.pendingClientProxyStartJob;
            if (element7 == coroutineScope.getCoroutineContext().get(Job.Key)) {
                VoiceSubTaskCoordinator voiceSubTaskCoordinator2 = VoiceSubTaskCoordinator.INSTANCE;
                VoiceSubTaskCoordinator.pendingClientProxyStartJob = null;
            }
            return unit;
        }
        str = VoiceSubTaskCoordinator.cancelingClientProxyTaskId;
        if (!Intrinsics.areEqual(str, this.$previousTaskId)) {
            FLogger fLogger = FLogger.INSTANCE;
            StringBuilder append = new StringBuilder("switching[stale-cancel]: prevId=").append(this.$previousTaskId).append(", currentCanceling=");
            str2 = VoiceSubTaskCoordinator.cancelingClientProxyTaskId;
            fLogger.d("VoiceSubTaskCoord", append.append(str2).toString());
            Unit unit2 = Unit.INSTANCE;
            element6 = VoiceSubTaskCoordinator.pendingClientProxyStartJob;
            if (element6 == coroutineScope.getCoroutineContext().get(Job.Key)) {
                VoiceSubTaskCoordinator voiceSubTaskCoordinator3 = VoiceSubTaskCoordinator.INSTANCE;
                VoiceSubTaskCoordinator.pendingClientProxyStartJob = null;
            }
            return unit2;
        }
        if (cancelOutcome instanceof VoiceSubTaskCoordinator.CancelOutcome.Failed) {
            subTaskRequestMessage2 = VoiceSubTaskCoordinator.pendingClientProxyRequest;
            subTaskExecutor2 = VoiceSubTaskCoordinator.pendingClientProxyExecutor;
            FLogger.INSTANCE.w("VoiceSubTaskCoord", "switching[failed]: prevId=" + this.$previousTaskId + ", pending=" + (subTaskRequestMessage2 != null ? subTaskRequestMessage2.getTaskId() : null) + ", pendingExecutor=" + subTaskExecutor2 + ", reason=" + ((VoiceSubTaskCoordinator.CancelOutcome.Failed) cancelOutcome).getReason());
            VoiceSubTaskCoordinator voiceSubTaskCoordinator4 = VoiceSubTaskCoordinator.INSTANCE;
            VoiceSubTaskCoordinator.pendingClientProxyRequest = null;
            VoiceSubTaskCoordinator voiceSubTaskCoordinator5 = VoiceSubTaskCoordinator.INSTANCE;
            VoiceSubTaskCoordinator.pendingClientProxyExecutor = null;
            VoiceSubTaskCoordinator voiceSubTaskCoordinator6 = VoiceSubTaskCoordinator.INSTANCE;
            VoiceSubTaskCoordinator.cancelingClientProxyTaskId = null;
            if (subTaskRequestMessage2 != null) {
                VoiceSubTaskCoordinator.INSTANCE.failPendingClientProxyTask(subTaskRequestMessage2.getTaskId(), "local_sub_task_cancel_previous_failed");
            }
            Unit unit3 = Unit.INSTANCE;
            element5 = VoiceSubTaskCoordinator.pendingClientProxyStartJob;
            if (element5 == coroutineScope.getCoroutineContext().get(Job.Key)) {
                VoiceSubTaskCoordinator voiceSubTaskCoordinator7 = VoiceSubTaskCoordinator.INSTANCE;
                VoiceSubTaskCoordinator.pendingClientProxyStartJob = null;
            }
            return unit3;
        }
        VoiceSubTaskCoordinator voiceSubTaskCoordinator8 = VoiceSubTaskCoordinator.INSTANCE;
        VoiceSubTaskCoordinator.cancelingClientProxyTaskId = null;
        subTaskRequestMessage = VoiceSubTaskCoordinator.pendingClientProxyRequest;
        if (subTaskRequestMessage == null) {
            Unit unit4 = Unit.INSTANCE;
            element4 = VoiceSubTaskCoordinator.pendingClientProxyStartJob;
            if (element4 == coroutineScope.getCoroutineContext().get(Job.Key)) {
                VoiceSubTaskCoordinator voiceSubTaskCoordinator9 = VoiceSubTaskCoordinator.INSTANCE;
                VoiceSubTaskCoordinator.pendingClientProxyStartJob = null;
            }
            return unit4;
        }
        subTaskExecutor = VoiceSubTaskCoordinator.pendingClientProxyExecutor;
        if (subTaskExecutor == null) {
            subTaskExecutor = SubTaskExecutor.INSTANCE.fromProtocol(subTaskRequestMessage.getExecutor());
        }
        VoiceSubTaskCoordinator voiceSubTaskCoordinator10 = VoiceSubTaskCoordinator.INSTANCE;
        VoiceSubTaskCoordinator.pendingClientProxyRequest = null;
        VoiceSubTaskCoordinator voiceSubTaskCoordinator11 = VoiceSubTaskCoordinator.INSTANCE;
        VoiceSubTaskCoordinator.pendingClientProxyExecutor = null;
        mutableStateFlow = VoiceSubTaskCoordinator._activeTask;
        SubTaskUiState subTaskUiState = (SubTaskUiState) mutableStateFlow.getValue();
        if (!Intrinsics.areEqual(subTaskUiState != null ? subTaskUiState.getSourceTaskId() : null, subTaskRequestMessage.getTaskId())) {
            FLogger.INSTANCE.w("VoiceSubTaskCoord", "switching[pending-not-active]: pending=" + subTaskRequestMessage.getTaskId() + ", active=" + (subTaskUiState != null ? subTaskUiState.getSourceTaskId() : null) + ", skip start");
            Unit unit5 = Unit.INSTANCE;
            element3 = VoiceSubTaskCoordinator.pendingClientProxyStartJob;
            if (element3 == coroutineScope.getCoroutineContext().get(Job.Key)) {
                VoiceSubTaskCoordinator voiceSubTaskCoordinator12 = VoiceSubTaskCoordinator.INSTANCE;
                VoiceSubTaskCoordinator.pendingClientProxyStartJob = null;
            }
            return unit5;
        }
        FLogger.INSTANCE.d("VoiceSubTaskCoord", "switching[start-latest]: taskId=" + subTaskRequestMessage.getTaskId() + ", executor=" + subTaskExecutor + ", outcome=" + cancelOutcome);
        int i2 = WhenMappings.$EnumSwitchMapping$0[subTaskExecutor.ordinal()];
        if (i2 == 1) {
            VoiceSubTaskCoordinator.INSTANCE.markCreateTaskRetryableBizErrorSuppressed(subTaskRequestMessage.getTaskId());
            VoiceSubTaskCoordinator.INSTANCE.startClientProxyTask(subTaskRequestMessage);
        } else {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            VoiceSubTaskCoordinator.INSTANCE.startServerClosedLoopTask(subTaskRequestMessage);
        }
        element2 = VoiceSubTaskCoordinator.pendingClientProxyStartJob;
        if (element2 == coroutineScope.getCoroutineContext().get(Job.Key)) {
            VoiceSubTaskCoordinator voiceSubTaskCoordinator13 = VoiceSubTaskCoordinator.INSTANCE;
            VoiceSubTaskCoordinator.pendingClientProxyStartJob = null;
        }
        return Unit.INSTANCE;
    }
}
