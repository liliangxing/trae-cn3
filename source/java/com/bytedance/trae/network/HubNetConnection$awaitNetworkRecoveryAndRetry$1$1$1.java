package com.bytedance.trae.network;

import com.bytedance.trae.utils.logger.FLogger;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;

/* compiled from: HubNetConnection.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "it"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.network.HubNetConnection$awaitNetworkRecoveryAndRetry$1$1$1", f = "HubNetConnection.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
final class HubNetConnection$awaitNetworkRecoveryAndRetry$1$1$1 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
    final /* synthetic */ Deferred<Unit> $networkDeferred;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HubNetConnection$awaitNetworkRecoveryAndRetry$1$1$1(Deferred<Unit> deferred, Continuation<? super HubNetConnection$awaitNetworkRecoveryAndRetry$1$1$1> continuation) {
        super(2, continuation);
        this.$networkDeferred = deferred;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HubNetConnection$awaitNetworkRecoveryAndRetry$1$1$1(this.$networkDeferred, continuation);
    }

    public final Object invoke(Unit unit, Continuation<? super Unit> continuation) {
        return create(unit, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        FLogger.INSTANCE.mo428i("HubNetConnection", "retryRegisterApp: timer fired");
        Job.DefaultImpls.cancel$default(this.$networkDeferred, (CancellationException) null, 1, (Object) null);
        return Unit.INSTANCE;
    }
}
