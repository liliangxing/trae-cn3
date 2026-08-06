package com.bytedance.trae.network;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FrontierConnection.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.network.FrontierConnection$tryWaitLastChannelClose$1", f = "FrontierConnection.kt", i = {}, l = {244}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class FrontierConnection$tryWaitLastChannelClose$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $block;
    int label;
    final /* synthetic */ FrontierConnection this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrontierConnection$tryWaitLastChannelClose$1(FrontierConnection frontierConnection, Function0<Unit> function0, Continuation<? super FrontierConnection$tryWaitLastChannelClose$1> continuation) {
        super(2, continuation);
        this.this$0 = frontierConnection;
        this.$block = function0;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FrontierConnection$tryWaitLastChannelClose$1(this.this$0, this.$block, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CompletableDeferred completableDeferred;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            completableDeferred = this.this$0.pendingCloseDeferred;
            if (completableDeferred != null) {
                FrontierConnection$tryWaitLastChannelClose$1$1$1 frontierConnection$tryWaitLastChannelClose$1$1$1 = new FrontierConnection$tryWaitLastChannelClose$1$1$1(completableDeferred, null);
                this.label = 1;
                obj = TimeoutKt.withTimeoutOrNull(2000L, frontierConnection$tryWaitLastChannelClose$1$1$1, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            this.this$0.pendingCloseDeferred = null;
            this.$block.invoke();
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.this$0.pendingCloseDeferred = null;
        this.$block.invoke();
        return Unit.INSTANCE;
    }
}
