package com.bytedance.android.anniex.detect;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DetectorConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Lcom/bytedance/android/anniex/detect/DetectionStep;", "Lcom/bytedance/android/anniex/detect/BlankCheckResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 4, 3}, xi = 48)
@DebugMetadata(c = "com.bytedance.android.anniex.detect.DetectionPipeline$run$2$results$1$1", f = "DetectorConfig.kt", i = {}, l = {172}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
final class DetectionPipeline$run$2$results$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends DetectionStep, ? extends BlankCheckResult>>, Object> {
    final /* synthetic */ DetectionContext $context;
    final /* synthetic */ DetectionStep $step;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DetectionPipeline$run$2$results$1$1(DetectionStep detectionStep, DetectionContext detectionContext, Continuation<? super DetectionPipeline$run$2$results$1$1> continuation) {
        super(2, continuation);
        this.$step = detectionStep;
        this.$context = detectionContext;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DetectionPipeline$run$2$results$1$1(this.$step, this.$context, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends DetectionStep, ? extends BlankCheckResult>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        DetectionStep detectionStep;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            DetectionStep detectionStep2 = this.$step;
            this.L$0 = detectionStep2;
            this.label = 1;
            Object execute = detectionStep2.execute(this.$context, (Continuation) this);
            if (execute == coroutine_suspended) {
                return coroutine_suspended;
            }
            detectionStep = detectionStep2;
            obj = execute;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            detectionStep = (DetectionStep) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return TuplesKt.to(detectionStep, obj);
    }
}
