package com.bytedance.trae.network;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.selects.SelectBuilder;
import kotlinx.coroutines.selects.SelectImplementation;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HubNetConnection.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.network.HubNetConnectionKt$awaitNetworkRecoveryOrRetryDelay$2", f = "HubNetConnection.kt", i = {0, 0}, l = {1549}, m = "invokeSuspend", n = {"timerDeferred", "networkDeferred"}, s = {"L$0", "L$1"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class HubNetConnectionKt$awaitNetworkRecoveryOrRetryDelay$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ StateFlow<Boolean> $isConnected;
    final /* synthetic */ long $retryDelayMs;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HubNetConnectionKt$awaitNetworkRecoveryOrRetryDelay$2(long j, StateFlow<Boolean> stateFlow, Continuation<? super HubNetConnectionKt$awaitNetworkRecoveryOrRetryDelay$2> continuation) {
        super(2, continuation);
        this.$retryDelayMs = j;
        this.$isConnected = stateFlow;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> hubNetConnectionKt$awaitNetworkRecoveryOrRetryDelay$2 = new HubNetConnectionKt$awaitNetworkRecoveryOrRetryDelay$2(this.$retryDelayMs, this.$isConnected, continuation);
        hubNetConnectionKt$awaitNetworkRecoveryOrRetryDelay$2.L$0 = obj;
        return hubNetConnectionKt$awaitNetworkRecoveryOrRetryDelay$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Deferred async$default;
        Deferred deferred;
        Throwable th;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            async$default = BuildersKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new C0888x5f1ffc7b(this.$retryDelayMs, null), 3, (Object) null);
            Deferred async$default2 = BuildersKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new C0887x2e397da4(this.$isConnected, null), 3, (Object) null);
            try {
                SelectBuilder selectImplementation = new SelectImplementation(getContext());
                SelectBuilder selectBuilder = selectImplementation;
                selectBuilder.invoke(async$default.getOnAwait(), new HubNetConnectionKt$awaitNetworkRecoveryOrRetryDelay$2$1$1(async$default2, null));
                selectBuilder.invoke(async$default2.getOnAwait(), new HubNetConnectionKt$awaitNetworkRecoveryOrRetryDelay$2$1$2(async$default, null));
                this.L$0 = async$default;
                this.L$1 = async$default2;
                this.label = 1;
                if (selectImplementation.doSelect(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                deferred = async$default2;
            } catch (Throwable th2) {
                deferred = async$default2;
                th = th2;
                Job.DefaultImpls.cancel$default((Job) async$default, (CancellationException) null, 1, (Object) null);
                Job.DefaultImpls.cancel$default((Job) deferred, (CancellationException) null, 1, (Object) null);
                throw th;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            deferred = (Deferred) this.L$1;
            async$default = (Deferred) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th3) {
                th = th3;
                Job.DefaultImpls.cancel$default((Job) async$default, (CancellationException) null, 1, (Object) null);
                Job.DefaultImpls.cancel$default((Job) deferred, (CancellationException) null, 1, (Object) null);
                throw th;
            }
        }
        Job.DefaultImpls.cancel$default((Job) async$default, (CancellationException) null, 1, (Object) null);
        Job.DefaultImpls.cancel$default((Job) deferred, (CancellationException) null, 1, (Object) null);
        return Unit.INSTANCE;
    }
}
