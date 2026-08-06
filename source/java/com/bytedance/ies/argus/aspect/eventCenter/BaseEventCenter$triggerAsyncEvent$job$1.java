package com.bytedance.ies.argus.aspect.eventCenter;

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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: BaseEventCenter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 4, 3}, xi = 176)
@DebugMetadata(c = "com.bytedance.ies.argus.aspect.eventCenter.BaseEventCenter$triggerAsyncEvent$job$1", f = "BaseEventCenter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class BaseEventCenter$triggerAsyncEvent$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IArgusAspect $aspect;
    final /* synthetic */ Function0<Unit> $block;
    final /* synthetic */ boolean $saveEvent;
    int label;
    final /* synthetic */ BaseEventCenter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseEventCenter$triggerAsyncEvent$job$1(Function0<Unit> function0, boolean z, BaseEventCenter baseEventCenter, IArgusAspect iArgusAspect, Continuation<? super BaseEventCenter$triggerAsyncEvent$job$1> continuation) {
        super(2, continuation);
        this.$block = function0;
        this.$saveEvent = z;
        this.this$0 = baseEventCenter;
        this.$aspect = iArgusAspect;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BaseEventCenter$triggerAsyncEvent$job$1(this.$block, this.$saveEvent, this.this$0, this.$aspect, continuation);
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
        this.$block.invoke();
        if (this.$saveEvent) {
            concurrentHashMap = this.this$0.finishEvent;
            concurrentHashMap.put(this.$aspect, Boxing.boxBoolean(true));
            this.this$0.awaitEventJobs.remove(this.$aspect);
        }
        return Unit.INSTANCE;
    }

    public final Object invokeSuspend$$forInline(Object obj) {
        ConcurrentHashMap concurrentHashMap;
        this.$block.invoke();
        if (this.$saveEvent) {
            concurrentHashMap = this.this$0.finishEvent;
            concurrentHashMap.put(this.$aspect, true);
            this.this$0.awaitEventJobs.remove(this.$aspect);
        }
        return Unit.INSTANCE;
    }
}
