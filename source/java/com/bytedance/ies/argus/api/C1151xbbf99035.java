package com.bytedance.ies.argus.api;

import com.bytedance.ies.argus.api.interfaces.service.ArgusWebSecureServiceListener;
import com.bytedance.ies.argus.api.interfaces.service.IArgusWebSecureService;
import com.bytedance.ies.argus.aspect.eventCenter.BaseEventCenter;
import com.bytedance.ies.argus.bean.ArgusWebViewAspect;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: BaseEventCenter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\n\b\u0001\u0010\u0004*\u0004\u0018\u00010\u0005*\u00020\u0006H\u008a@¨\u0006\u0007"}, d2 = {"<anonymous>", "", "PARAMS", "Lcom/bytedance/ies/argus/api/params/BaseAspectParams;", "REWRITE_PAYLOAD", "Lcom/bytedance/ies/argus/strategy/BaseRewritePayload;", "Lkotlinx/coroutines/CoroutineScope;", "com/bytedance/ies/argus/aspect/eventCenter/BaseEventCenter$VerifyHandler$setAsyncReportAwaitTask$task$1"}, k = 3, mv = {1, 4, 3}, xi = 48)
@DebugMetadata(c = "com.bytedance.ies.argus.api.ArgusWebDelegate$innerVerifyLoadUrl$lambda$12$lambda$11$$inlined$setAsyncReportAwaitTask$1", f = "ArgusWebDelegate.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* renamed from: com.bytedance.ies.argus.api.ArgusWebDelegate$innerVerifyLoadUrl$lambda$12$lambda$11$$inlined$setAsyncReportAwaitTask$1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class C1151xbbf99035 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ArgusWebViewAspect $callingAspect$inlined;
    final /* synthetic */ CopyOnWriteArrayList $serviceList$inlined;
    final /* synthetic */ BaseEventCenter.VerifyHandler $this_apply$inlined;
    int label;
    final /* synthetic */ ArgusWebDelegate this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1151xbbf99035(Continuation continuation, CopyOnWriteArrayList copyOnWriteArrayList, ArgusWebDelegate argusWebDelegate, ArgusWebViewAspect argusWebViewAspect, BaseEventCenter.VerifyHandler verifyHandler) {
        super(2, continuation);
        this.$serviceList$inlined = copyOnWriteArrayList;
        this.this$0 = argusWebDelegate;
        this.$callingAspect$inlined = argusWebViewAspect;
        this.$this_apply$inlined = verifyHandler;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C1151xbbf99035(continuation, this.$serviceList$inlined, this.this$0, this.$callingAspect$inlined, this.$this_apply$inlined);
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
        Iterator it = this.$serviceList$inlined.iterator();
        while (it.hasNext()) {
            ArgusWebSecureServiceListener provideListener = ((IArgusWebSecureService) it.next()).provideListener();
            if (provideListener != null) {
                provideListener.afterVerifyLoadUrl(this.this$0.getViewContext$anniex_release().getView(), this.$callingAspect$inlined, this.$this_apply$inlined.getVerifyResult());
            }
        }
        return Unit.INSTANCE;
    }
}
