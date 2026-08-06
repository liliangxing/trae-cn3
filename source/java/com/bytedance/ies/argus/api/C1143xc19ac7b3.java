package com.bytedance.ies.argus.api;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.bytedance.ies.argus.api.params.ArgusContainerCreateType;
import com.bytedance.ies.argus.api.params.ContainerCreatedParams;
import com.bytedance.ies.argus.aspect.eventCenter.BaseEventCenter;
import com.bytedance.ies.argus.aspect.eventCenter.ContainerContext;
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
@DebugMetadata(c = "com.bytedance.ies.argus.api.ArgusContainerDelegate$asyncCalculateRouterRisk$$inlined$verify$1", f = "ArgusContainerDelegate.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* renamed from: com.bytedance.ies.argus.api.ArgusContainerDelegate$asyncCalculateRouterRisk$$inlined$verify$1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class C1143xc19ac7b3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity$inlined;
    final /* synthetic */ IArgusAspect $aspect;
    final /* synthetic */ ContainerCreatedParams $params$inlined;
    final /* synthetic */ boolean $saveEvent;
    int label;
    final /* synthetic */ ArgusContainerDelegate this$0;
    final /* synthetic */ BaseEventCenter this$0$inline_fun;
    final /* synthetic */ BaseEventCenter.VerifyHandler this$0$inline_fun$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1143xc19ac7b3(boolean z, BaseEventCenter baseEventCenter, IArgusAspect iArgusAspect, Continuation continuation, BaseEventCenter.VerifyHandler verifyHandler, ContainerCreatedParams containerCreatedParams, Activity activity, ArgusContainerDelegate argusContainerDelegate) {
        super(2, continuation);
        this.$saveEvent = z;
        this.$aspect = iArgusAspect;
        this.this$0$inline_fun$1 = verifyHandler;
        this.$params$inlined = containerCreatedParams;
        this.$activity$inlined = activity;
        this.this$0 = argusContainerDelegate;
        this.this$0$inline_fun = baseEventCenter;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C1143xc19ac7b3(this.$saveEvent, this.this$0$inline_fun, this.$aspect, continuation, this.this$0$inline_fun$1, this.$params$inlined, this.$activity$inlined, this.this$0);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Bundle bundle;
        ConcurrentHashMap concurrentHashMap;
        Class<?> cls;
        Intent intent;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0$inline_fun$1.getContext().recordCost(AspectContext.Companion.TraceType.INNER_ASPECT_VERIFY, AspectContext.Companion.TraceStage.START, "");
            AspectContext<?, ?> context = this.this$0$inline_fun$1.getContext();
            this.this$0$inline_fun$1.getVerifyResult();
            if (this.$params$inlined.getCreateType() == ArgusContainerCreateType.Activity) {
                Activity activity = this.$activity$inlined;
                if (activity == null || (intent = activity.getIntent()) == null || (bundle = intent.getExtras()) == null) {
                    bundle = this.$params$inlined.getBundle();
                }
            } else {
                bundle = this.$params$inlined.getBundle();
            }
            Activity activity2 = this.$activity$inlined;
            String simpleName = (activity2 == null || (cls = activity2.getClass()) == null) ? null : cls.getSimpleName();
            ContainerContext argusContext = this.this$0.getArgusContext();
            argusContext.getOrRecordActivity(simpleName, bundle);
            argusContext.getOrRecordSchemaMap(this.$params$inlined.getSchema());
            this.this$0.getStrategyEngine$anniex_release().calculate(context);
            context.getReportParams().setAddReportDataBlock(new ArgusContainerDelegate$asyncCalculateRouterRisk$1$2(this.this$0, context));
            this.this$0$inline_fun$1.getContext().recordCost(AspectContext.Companion.TraceType.INNER_ASPECT_VERIFY, AspectContext.Companion.TraceStage.END, "");
            if (this.$saveEvent) {
                concurrentHashMap = this.this$0$inline_fun.finishEvent;
                concurrentHashMap.put(this.$aspect, Boxing.boxBoolean(true));
                this.this$0$inline_fun.awaitEventJobs.remove(this.$aspect);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
