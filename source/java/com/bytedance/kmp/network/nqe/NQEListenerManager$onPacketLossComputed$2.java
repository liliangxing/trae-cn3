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
@DebugMetadata(c = "com.bytedance.kmp.network.nqe.NQEListenerManager$onPacketLossComputed$2", f = "NQEListenerManager.kt", i = {}, l = {155}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
final class NQEListenerManager$onPacketLossComputed$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ double $downstreamLossRate;
    final /* synthetic */ double $downstreamLossRateVariance;
    final /* synthetic */ int $protocol;
    final /* synthetic */ double $upstreamLossRate;
    final /* synthetic */ double $upstreamLossRateVariance;
    int label;
    final /* synthetic */ NQEListenerManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NQEListenerManager$onPacketLossComputed$2(NQEListenerManager nQEListenerManager, int i, double d, double d2, double d3, double d4, Continuation<? super NQEListenerManager$onPacketLossComputed$2> continuation) {
        super(2, continuation);
        this.this$0 = nQEListenerManager;
        this.$protocol = i;
        this.$upstreamLossRate = d;
        this.$upstreamLossRateVariance = d2;
        this.$downstreamLossRate = d3;
        this.$downstreamLossRateVariance = d4;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NQEListenerManager$onPacketLossComputed$2(this.this$0, this.$protocol, this.$upstreamLossRate, this.$upstreamLossRateVariance, this.$downstreamLossRate, this.$downstreamLossRateVariance, continuation);
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
            final int i2 = this.$protocol;
            final double d = this.$upstreamLossRate;
            final double d2 = this.$upstreamLossRateVariance;
            final double d3 = this.$downstreamLossRate;
            final double d4 = this.$downstreamLossRateVariance;
            this.label = 1;
            dispatchToListeners = nQEListenerManager.dispatchToListeners(new Function1<NQEListener, Unit>() { // from class: com.bytedance.kmp.network.nqe.NQEListenerManager$onPacketLossComputed$2.1
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
                    nQEListener.onPacketLossComputed(i2, d, d2, d3, d4);
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
