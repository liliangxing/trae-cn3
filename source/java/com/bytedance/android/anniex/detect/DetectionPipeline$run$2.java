package com.bytedance.android.anniex.detect;

import com.bytedance.android.anniex.detect.BlankCheckResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DetectorConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/bytedance/android/anniex/detect/BlankCheckResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 4, 3}, xi = 48)
@DebugMetadata(c = "com.bytedance.android.anniex.detect.DetectionPipeline$run$2", f = "DetectorConfig.kt", i = {}, l = {172}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class DetectionPipeline$run$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BlankCheckResult>, Object> {
    final /* synthetic */ DetectionContext $context;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DetectionPipeline this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DetectionPipeline$run$2(DetectionPipeline detectionPipeline, DetectionContext detectionContext, Continuation<? super DetectionPipeline$run$2> continuation) {
        super(2, continuation);
        this.this$0 = detectionPipeline;
        this.$context = detectionContext;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> detectionPipeline$run$2 = new DetectionPipeline$run$2(this.this$0, this.$context, continuation);
        detectionPipeline$run$2.L$0 = obj;
        return detectionPipeline$run$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super BlankCheckResult> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        List list;
        BlankCheckResult blankCheckResult;
        Function1 function1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        Object obj2 = null;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            list = this.this$0.steps;
            List list2 = list;
            DetectionContext detectionContext = this.$context;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(BuildersKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new DetectionPipeline$run$2$results$1$1((DetectionStep) it.next(), detectionContext, null), 3, (Object) null));
            }
            this.label = 1;
            obj = AwaitKt.awaitAll(arrayList, (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        DetectionPipeline detectionPipeline = this.this$0;
        Iterator it2 = ((List) obj).iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            function1 = detectionPipeline.shouldInterrupt;
            if (((Boolean) function1.invoke(((Pair) next).getSecond())).booleanValue()) {
                obj2 = next;
                break;
            }
        }
        Pair pair = (Pair) obj2;
        return (pair == null || (blankCheckResult = (BlankCheckResult) pair.getSecond()) == null) ? new BlankCheckResult.Success(200) : blankCheckResult;
    }
}
