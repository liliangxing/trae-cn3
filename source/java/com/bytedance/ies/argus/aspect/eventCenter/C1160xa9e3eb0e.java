package com.bytedance.ies.argus.aspect.eventCenter;

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
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: BaseEventCenter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/bytedance/ies/argus/aspect/eventCenter/BaseEventCenter$triggerAsyncEvent$job$1"}, k = 3, mv = {1, 4, 3}, xi = 48)
@DebugMetadata(c = "com.bytedance.ies.argus.aspect.eventCenter.BaseEventCenter$VerifyHandler$asyncVerify$$inlined$triggerAsyncEvent$1", f = "BaseEventCenter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* renamed from: com.bytedance.ies.argus.aspect.eventCenter.BaseEventCenter$VerifyHandler$asyncVerify$$inlined$triggerAsyncEvent$1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class C1160xa9e3eb0e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IArgusAspect $aspect;
    final /* synthetic */ Function3 $block$inlined;
    final /* synthetic */ boolean $saveEvent;
    int label;
    final /* synthetic */ BaseEventCenter.VerifyHandler this$0;
    final /* synthetic */ BaseEventCenter this$0$inline_fun;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1160xa9e3eb0e(boolean z, BaseEventCenter baseEventCenter, IArgusAspect iArgusAspect, Continuation continuation, BaseEventCenter.VerifyHandler verifyHandler, Function3 function3) {
        super(2, continuation);
        this.$saveEvent = z;
        this.this$0$inline_fun = baseEventCenter;
        this.$aspect = iArgusAspect;
        this.this$0 = verifyHandler;
        this.$block$inlined = function3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C1160xa9e3eb0e(this.$saveEvent, this.this$0$inline_fun, this.$aspect, continuation, this.this$0, this.$block$inlined);
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
        this.this$0.getContext().recordCost(AspectContext.Companion.TraceType.INNER_ASPECT_VERIFY, AspectContext.Companion.TraceStage.START, "");
        Function3 function3 = this.$block$inlined;
        BaseEventCenter.VerifyHandler verifyHandler = this.this$0;
        function3.invoke(verifyHandler, verifyHandler.getContext(), this.this$0.getVerifyResult());
        this.this$0.getContext().recordCost(AspectContext.Companion.TraceType.INNER_ASPECT_VERIFY, AspectContext.Companion.TraceStage.END, "");
        if (this.$saveEvent) {
            concurrentHashMap = this.this$0$inline_fun.finishEvent;
            concurrentHashMap.put(this.$aspect, Boxing.boxBoolean(true));
            this.this$0$inline_fun.awaitEventJobs.remove(this.$aspect);
        }
        return Unit.INSTANCE;
    }

    public final Object invokeSuspend$$forInline(Object obj) {
        ConcurrentHashMap concurrentHashMap;
        this.this$0.getContext().recordCost(AspectContext.Companion.TraceType.INNER_ASPECT_VERIFY, AspectContext.Companion.TraceStage.START, "");
        Function3 function3 = this.$block$inlined;
        BaseEventCenter.VerifyHandler verifyHandler = this.this$0;
        function3.invoke(verifyHandler, verifyHandler.getContext(), this.this$0.getVerifyResult());
        this.this$0.getContext().recordCost(AspectContext.Companion.TraceType.INNER_ASPECT_VERIFY, AspectContext.Companion.TraceStage.END, "");
        if (this.$saveEvent) {
            concurrentHashMap = this.this$0$inline_fun.finishEvent;
            concurrentHashMap.put(this.$aspect, true);
            this.this$0$inline_fun.awaitEventJobs.remove(this.$aspect);
        }
        return Unit.INSTANCE;
    }
}
