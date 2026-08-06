package com.bytedance.ies.argus.api;

import com.bytedance.ies.argus.aspect.eventCenter.BaseEventCenter;
import com.bytedance.ies.argus.bean.AspectContext;
import com.bytedance.ies.argus.bean.IArgusAspect;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: BaseEventCenter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¨\u0006\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/bytedance/ies/argus/aspect/eventCenter/BaseEventCenter$triggerAsyncEvent$job$1", "com/bytedance/ies/argus/aspect/eventCenter/BaseEventCenter$VerifyHandler$asyncVerify$$inlined$triggerAsyncEvent$1"}, k = 3, mv = {1, 4, 3}, xi = 48)
@DebugMetadata(c = "com.bytedance.ies.argus.api.ArgusGlobalDelegate$verifyLoadStaticResource$$inlined$verify$default$1", f = "ArgusGlobalDelegate.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* renamed from: com.bytedance.ies.argus.api.ArgusGlobalDelegate$verifyLoadStaticResource$$inlined$verify$default$1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class C1148x8dc365df extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IArgusAspect $aspect;
    final /* synthetic */ boolean $saveEvent;
    int label;
    final /* synthetic */ ArgusGlobalDelegate this$0;
    final /* synthetic */ BaseEventCenter this$0$inline_fun;
    final /* synthetic */ BaseEventCenter.VerifyHandler this$0$inline_fun$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1148x8dc365df(boolean z, BaseEventCenter baseEventCenter, IArgusAspect iArgusAspect, Continuation continuation, BaseEventCenter.VerifyHandler verifyHandler, ArgusGlobalDelegate argusGlobalDelegate) {
        super(2, continuation);
        this.$saveEvent = z;
        this.$aspect = iArgusAspect;
        this.this$0$inline_fun$1 = verifyHandler;
        this.this$0 = argusGlobalDelegate;
        this.this$0$inline_fun = baseEventCenter;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C1148x8dc365df(this.$saveEvent, this.this$0$inline_fun, this.$aspect, continuation, this.this$0$inline_fun$1, this.this$0);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        ConcurrentHashMap concurrentHashMap;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.this$0$inline_fun$1.getContext().recordCost(AspectContext.Companion.TraceType.INNER_ASPECT_VERIFY, AspectContext.Companion.TraceStage.START, "");
        AspectContext<?, ?> context = this.this$0$inline_fun$1.getContext();
        this.this$0$inline_fun$1.getVerifyResult();
        this.this$0.strategyEngine.calculate(context);
        this.this$0$inline_fun$1.getContext().recordCost(AspectContext.Companion.TraceType.INNER_ASPECT_VERIFY, AspectContext.Companion.TraceStage.END, "");
        if (this.$saveEvent) {
            concurrentHashMap = this.this$0$inline_fun.finishEvent;
            concurrentHashMap.put(this.$aspect, Boxing.boxBoolean(true));
            this.this$0$inline_fun.awaitEventJobs.remove(this.$aspect);
        }
        return Unit.INSTANCE;
    }
}
