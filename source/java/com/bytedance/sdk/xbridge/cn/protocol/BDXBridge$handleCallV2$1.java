package com.bytedance.sdk.xbridge.cn.protocol;

import com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BDXBridge.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H\u008a@"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "INPUT", "OUTPUT", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 4, 3}, xi = 48)
@DebugMetadata(c = "com.bytedance.sdk.xbridge.cn.protocol.BDXBridge$handleCallV2$1", f = "BDXBridge.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BDXBridge$handleCallV2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BaseBridgeCall<INPUT> $call;
    final /* synthetic */ BridgeResultCallback<OUTPUT> $callback;
    int label;
    final /* synthetic */ BDXBridge<INPUT, OUTPUT> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BDXBridge$handleCallV2$1(BDXBridge<INPUT, OUTPUT> bDXBridge, BaseBridgeCall<INPUT> baseBridgeCall, BridgeResultCallback<OUTPUT> bridgeResultCallback, Continuation<? super BDXBridge$handleCallV2$1> continuation) {
        super(2, continuation);
        this.this$0 = bDXBridge;
        this.$call = baseBridgeCall;
        this.$callback = bridgeResultCallback;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BDXBridge$handleCallV2$1(this.this$0, this.$call, this.$callback, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.realHandleCall(this.$call, this.$callback);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
