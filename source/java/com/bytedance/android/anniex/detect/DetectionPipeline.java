package com.bytedance.android.anniex.detect;

import com.bytedance.android.anniex.detect.BlankCheckResult;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: DetectorConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B3\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/anniex/detect/DetectionPipeline;", "", "steps", "", "Lcom/bytedance/android/anniex/detect/DetectionStep;", "parallel", "", "shouldInterrupt", "Lkotlin/Function1;", "Lcom/bytedance/android/anniex/detect/BlankCheckResult;", "(Ljava/util/List;ZLkotlin/jvm/functions/Function1;)V", "run", "context", "Lcom/bytedance/android/anniex/detect/DetectionContext;", "(Lcom/bytedance/android/anniex/detect/DetectionContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class DetectionPipeline {
    private final boolean parallel;
    private final Function1<BlankCheckResult, Boolean> shouldInterrupt;
    private final List<DetectionStep> steps;

    /* JADX WARN: Multi-variable type inference failed */
    public DetectionPipeline(List<? extends DetectionStep> list, boolean z, Function1<? super BlankCheckResult, Boolean> function1) {
        Intrinsics.checkNotNullParameter(list, "steps");
        Intrinsics.checkNotNullParameter(function1, "shouldInterrupt");
        this.steps = list;
        this.parallel = z;
        this.shouldInterrupt = function1;
    }

    public /* synthetic */ DetectionPipeline(List list, boolean z, C08571 c08571, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? false : z, (i & 4) != 0 ? new Function1<BlankCheckResult, Boolean>() { // from class: com.bytedance.android.anniex.detect.DetectionPipeline.1
            public final Boolean invoke(BlankCheckResult blankCheckResult) {
                Intrinsics.checkNotNullParameter(blankCheckResult, "it");
                return Boolean.valueOf(!(blankCheckResult instanceof BlankCheckResult.Success));
            }
        } : c08571);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0085 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0072 -> B:16:0x0075). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object run(DetectionContext detectionContext, Continuation<? super BlankCheckResult> continuation) {
        DetectionPipeline$run$1 detectionPipeline$run$1;
        int i;
        DetectionPipeline detectionPipeline;
        DetectionContext detectionContext2;
        Iterator<DetectionStep> it;
        if (continuation instanceof DetectionPipeline$run$1) {
            detectionPipeline$run$1 = (DetectionPipeline$run$1) continuation;
            if ((detectionPipeline$run$1.label & Integer.MIN_VALUE) != 0) {
                detectionPipeline$run$1.label -= Integer.MIN_VALUE;
                Object obj = detectionPipeline$run$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = detectionPipeline$run$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (!this.parallel) {
                        detectionPipeline = this;
                        detectionContext2 = detectionContext;
                        it = this.steps.iterator();
                        if (!it.hasNext()) {
                        }
                    } else {
                        DetectionPipeline$run$2 detectionPipeline$run$2 = new DetectionPipeline$run$2(this, detectionContext, null);
                        detectionPipeline$run$1.label = 2;
                        obj = CoroutineScopeKt.coroutineScope(detectionPipeline$run$2, detectionPipeline$run$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else if (i == 1) {
                    it = (Iterator) detectionPipeline$run$1.L$2;
                    DetectionContext detectionContext3 = (DetectionContext) detectionPipeline$run$1.L$1;
                    detectionPipeline = (DetectionPipeline) detectionPipeline$run$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    BlankCheckResult blankCheckResult = (BlankCheckResult) obj;
                    if (!((Boolean) detectionPipeline.shouldInterrupt.invoke(blankCheckResult)).booleanValue()) {
                        return blankCheckResult;
                    }
                    detectionContext2 = detectionContext3;
                    if (!it.hasNext()) {
                        DetectionStep next = it.next();
                        detectionPipeline$run$1.L$0 = detectionPipeline;
                        detectionPipeline$run$1.L$1 = detectionContext2;
                        detectionPipeline$run$1.L$2 = it;
                        detectionPipeline$run$1.label = 1;
                        Object execute = next.execute(detectionContext2, detectionPipeline$run$1);
                        if (execute == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        detectionContext3 = detectionContext2;
                        obj = execute;
                        BlankCheckResult blankCheckResult2 = (BlankCheckResult) obj;
                        if (!((Boolean) detectionPipeline.shouldInterrupt.invoke(blankCheckResult2)).booleanValue()) {
                        }
                    } else {
                        return new BlankCheckResult.Success(200);
                    }
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return obj;
            }
        }
        detectionPipeline$run$1 = new DetectionPipeline$run$1(this, continuation);
        Object obj2 = detectionPipeline$run$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = detectionPipeline$run$1.label;
        if (i != 0) {
        }
        return obj2;
    }
}
