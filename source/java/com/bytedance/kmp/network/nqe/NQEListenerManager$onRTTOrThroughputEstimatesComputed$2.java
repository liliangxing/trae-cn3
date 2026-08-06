package com.bytedance.kmp.network.nqe;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: NQEListenerManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.kmp.network.nqe.NQEListenerManager$onRTTOrThroughputEstimatesComputed$2", f = "NQEListenerManager.kt", i = {}, l = {110}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
final class NQEListenerManager$onRTTOrThroughputEstimatesComputed$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $downstreamThroughputKbps;
    final /* synthetic */ int $httpRttMs;
    final /* synthetic */ int $transportRttMs;
    int label;
    final /* synthetic */ NQEListenerManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NQEListenerManager$onRTTOrThroughputEstimatesComputed$2(NQEListenerManager nQEListenerManager, int i, int i2, int i3, Continuation<? super NQEListenerManager$onRTTOrThroughputEstimatesComputed$2> continuation) {
        super(2, continuation);
        this.this$0 = nQEListenerManager;
        this.$httpRttMs = i;
        this.$transportRttMs = i2;
        this.$downstreamThroughputKbps = i3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NQEListenerManager$onRTTOrThroughputEstimatesComputed$2(this.this$0, this.$httpRttMs, this.$transportRttMs, this.$downstreamThroughputKbps, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object dispatchToListeners;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            NQEListenerManager nQEListenerManager = this.this$0;
            final int i2 = this.$httpRttMs;
            final int i3 = this.$transportRttMs;
            final int i4 = this.$downstreamThroughputKbps;
            this.label = 1;
            dispatchToListeners = nQEListenerManager.dispatchToListeners(new Function1<NQEListener, Unit>() { // from class: com.bytedance.kmp.network.nqe.NQEListenerManager$onRTTOrThroughputEstimatesComputed$2.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((NQEListener) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(NQEListener nQEListener) {
                    Intrinsics.checkNotNullParameter(nQEListener, "listener");
                    nQEListener.onRTTOrThroughputEstimatesComputed(i2, i3, i4);
                }
            }, (Continuation) this);
            if (dispatchToListeners == coroutine_suspended) {
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
