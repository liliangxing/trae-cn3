package com.bytedance.ies.argus.repository;

import com.bytedance.ies.argus.base.ArgusLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

/* compiled from: ArgusConfigManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 4, 3}, xi = 48)
@DebugMetadata(c = "com.bytedance.ies.argus.repository.BaseConfigProvider$onConfigUpdate$1$1", f = "ArgusConfigManager.kt", i = {}, l = {331}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
final class BaseConfigProvider$onConfigUpdate$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<T, Unit> $callback;
    final /* synthetic */ StateFlow<T> $flow;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BaseConfigProvider$onConfigUpdate$1$1(StateFlow<? extends T> stateFlow, Function1<? super T, Unit> function1, Continuation<? super BaseConfigProvider$onConfigUpdate$1$1> continuation) {
        super(2, continuation);
        this.$flow = stateFlow;
        this.$callback = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> baseConfigProvider$onConfigUpdate$1$1 = new BaseConfigProvider$onConfigUpdate$1$1(this.$flow, this.$callback, continuation);
        baseConfigProvider$onConfigUpdate$1$1.L$0 = obj;
        return baseConfigProvider$onConfigUpdate$1$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Flow flow = this.$flow;
            final Function1<T, Unit> function1 = this.$callback;
            this.label = 1;
            if (flow.collect(new FlowCollector<T>() { // from class: com.bytedance.ies.argus.repository.BaseConfigProvider$onConfigUpdate$1$1$invokeSuspend$$inlined$collect$1
                public Object emit(Object obj2, Continuation continuation) {
                    try {
                        Function1 function12 = function1;
                        if (function12 != null) {
                            function12.invoke(obj2);
                        }
                    } catch (Exception e) {
                        ArgusLog.e$default(ArgusLog.INSTANCE, ArgusConfigManager.TAG, coroutineScope.getClass().getSimpleName() + " collector invoke error: " + e.getMessage(), null, null, 12, null);
                    }
                    return Unit.INSTANCE;
                }
            }, (Continuation) this) == coroutine_suspended) {
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
