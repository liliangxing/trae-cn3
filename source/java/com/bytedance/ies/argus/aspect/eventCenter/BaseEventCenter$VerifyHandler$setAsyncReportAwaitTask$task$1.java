package com.bytedance.ies.argus.aspect.eventCenter;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: BaseEventCenter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\n\b\u0001\u0010\u0004*\u0004\u0018\u00010\u0005*\u00020\u0006H\u008a@"}, d2 = {"<anonymous>", "", "PARAMS", "Lcom/bytedance/ies/argus/api/params/BaseAspectParams;", "REWRITE_PAYLOAD", "Lcom/bytedance/ies/argus/strategy/BaseRewritePayload;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 4, 3}, xi = 176)
@DebugMetadata(c = "com.bytedance.ies.argus.aspect.eventCenter.BaseEventCenter$VerifyHandler$setAsyncReportAwaitTask$task$1", f = "BaseEventCenter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class BaseEventCenter$VerifyHandler$setAsyncReportAwaitTask$task$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $block;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseEventCenter$VerifyHandler$setAsyncReportAwaitTask$task$1(Function0<Unit> function0, Continuation<? super BaseEventCenter$VerifyHandler$setAsyncReportAwaitTask$task$1> continuation) {
        super(2, continuation);
        this.$block = function0;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BaseEventCenter$VerifyHandler$setAsyncReportAwaitTask$task$1(this.$block, continuation);
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
        this.$block.invoke();
        return Unit.INSTANCE;
    }

    public final Object invokeSuspend$$forInline(Object obj) {
        this.$block.invoke();
        return Unit.INSTANCE;
    }
}
