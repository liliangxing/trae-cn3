package com.bytedance.ies.argus.api;

import com.bytedance.ies.argus.aspect.ArgusWebDefaultDelegateKt;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\n\b\u0001\u0010\u0004*\u0004\u0018\u00010\u0005*\u00020\u0006H\u008a@¨\u0006\u0007"}, d2 = {"<anonymous>", "", "PARAMS", "Lcom/bytedance/ies/argus/api/params/BaseAspectParams;", "REWRITE_PAYLOAD", "Lcom/bytedance/ies/argus/strategy/BaseRewritePayload;", "Lkotlinx/coroutines/CoroutineScope;", "com/bytedance/ies/argus/aspect/eventCenter/BaseEventCenter$VerifyHandler$setAsyncReportAwaitTask$task$1"}, k = 3, mv = {1, 4, 3}, xi = 48)
@DebugMetadata(c = "com.bytedance.ies.argus.api.ArgusWebDelegate$innerVerifyLoadUrl$lambda$12$lambda$11$lambda$8$$inlined$setAsyncReportAwaitTask$1", f = "ArgusWebDelegate.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* renamed from: com.bytedance.ies.argus.api.ArgusWebDelegate$innerVerifyLoadUrl$lambda$12$lambda$11$lambda$8$$inlined$setAsyncReportAwaitTask$1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class C1152x2575f0ee extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0 $asyncBlock$inlined;
    int label;
    final /* synthetic */ ArgusWebDelegate this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1152x2575f0ee(Continuation continuation, Function0 function0, ArgusWebDelegate argusWebDelegate) {
        super(2, continuation);
        this.$asyncBlock$inlined = function0;
        this.this$0 = argusWebDelegate;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C1152x2575f0ee(continuation, this.$asyncBlock$inlined, this.this$0);
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
        String str = (String) this.$asyncBlock$inlined.invoke();
        if (str != null) {
            ArgusWebDefaultDelegateKt.reloadMiddlePageInMain$default(this.this$0, str, null, 2, null);
        }
        return Unit.INSTANCE;
    }
}
