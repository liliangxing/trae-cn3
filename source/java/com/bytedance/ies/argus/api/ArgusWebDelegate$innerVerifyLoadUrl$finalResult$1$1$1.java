package com.bytedance.ies.argus.api;

import com.bytedance.ies.argus.api.params.WebLoadUrlParams;
import com.bytedance.ies.argus.aspect.ArgusWebDefaultDelegateKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ArgusWebDelegate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 4, 3}, xi = 48)
@DebugMetadata(c = "com.bytedance.ies.argus.api.ArgusWebDelegate$innerVerifyLoadUrl$finalResult$1$1$1", f = "ArgusWebDelegate.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
final class ArgusWebDelegate$innerVerifyLoadUrl$finalResult$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ WebLoadUrlParams $params;
    int label;
    final /* synthetic */ ArgusWebDelegate this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArgusWebDelegate$innerVerifyLoadUrl$finalResult$1$1$1(ArgusWebDelegate argusWebDelegate, WebLoadUrlParams webLoadUrlParams, Continuation<? super ArgusWebDelegate$innerVerifyLoadUrl$finalResult$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = argusWebDelegate;
        this.$params = webLoadUrlParams;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ArgusWebDelegate$innerVerifyLoadUrl$finalResult$1$1$1(this.this$0, this.$params, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        ArgusWebDefaultDelegateKt.matchPageFeId(this.this$0, this.$params);
        return Unit.INSTANCE;
    }
}
