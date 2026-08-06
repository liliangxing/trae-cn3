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
@DebugMetadata(c = "com.bytedance.kmp.network.nqe.NQEListenerManager$onEffectiveConnectionTypeChanged$2", f = "NQEListenerManager.kt", i = {}, l = {126}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
final class NQEListenerManager$onEffectiveConnectionTypeChanged$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ EffectiveConnectionType $type;
    int label;
    final /* synthetic */ NQEListenerManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NQEListenerManager$onEffectiveConnectionTypeChanged$2(NQEListenerManager nQEListenerManager, EffectiveConnectionType effectiveConnectionType, Continuation<? super NQEListenerManager$onEffectiveConnectionTypeChanged$2> continuation) {
        super(2, continuation);
        this.this$0 = nQEListenerManager;
        this.$type = effectiveConnectionType;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NQEListenerManager$onEffectiveConnectionTypeChanged$2(this.this$0, this.$type, continuation);
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
            final EffectiveConnectionType effectiveConnectionType = this.$type;
            this.label = 1;
            dispatchToListeners = nQEListenerManager.dispatchToListeners(new Function1<NQEListener, Unit>() { // from class: com.bytedance.kmp.network.nqe.NQEListenerManager$onEffectiveConnectionTypeChanged$2.1
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((NQEListener) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(NQEListener nQEListener) {
                    Intrinsics.checkNotNullParameter(nQEListener, "listener");
                    nQEListener.onEffectiveConnectionTypeChanged(EffectiveConnectionType.this);
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
