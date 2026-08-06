package com.bytedance.android.anniex.detect.detection;

import com.bytedance.android.anniex.detect.AnnieXBlankDetectorManager;
import com.bytedance.android.anniex.detect.BlankCheckResult;
import com.bytedance.android.anniex.detect.DetectionContext;
import com.bytedance.android.anniex.detect.DetectionStep;
import com.bytedance.android.anniex.detect.FailureStage;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.TimeoutKt;

/* compiled from: PureColorDetectionStep.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010\u000fR\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/anniex/detect/detection/PureColorDetectionStep;", "Lcom/bytedance/android/anniex/detect/DetectionStep;", "timeoutMs", "", "tolerance", "", "(JF)V", "id", "", "getId", "()Ljava/lang/String;", "execute", "Lcom/bytedance/android/anniex/detect/BlankCheckResult;", "context", "Lcom/bytedance/android/anniex/detect/DetectionContext;", "(Lcom/bytedance/android/anniex/detect/DetectionContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class PureColorDetectionStep implements DetectionStep {
    private final String id = "PureColorDetection";
    private final long timeoutMs;
    private final float tolerance;

    public PureColorDetectionStep(long j, float f) {
        this.timeoutMs = j;
        this.tolerance = f;
    }

    @Override // com.bytedance.android.anniex.detect.DetectionStep
    public String getId() {
        return this.id;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.bytedance.android.anniex.detect.DetectionStep
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object execute(DetectionContext detectionContext, Continuation<? super BlankCheckResult> continuation) {
        PureColorDetectionStep$execute$1 pureColorDetectionStep$execute$1;
        int i;
        long j;
        Ref.ObjectRef objectRef;
        DetectionContext detectionContext2;
        Ref.ObjectRef objectRef2;
        BlankCheckResult.Error error;
        if (continuation instanceof PureColorDetectionStep$execute$1) {
            pureColorDetectionStep$execute$1 = (PureColorDetectionStep$execute$1) continuation;
            if ((pureColorDetectionStep$execute$1.label & Integer.MIN_VALUE) != 0) {
                pureColorDetectionStep$execute$1.label -= Integer.MIN_VALUE;
                Object obj = pureColorDetectionStep$execute$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = pureColorDetectionStep$execute$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    HybridLogger.d$default(HybridLogger.INSTANCE, AnnieXBlankDetectorManager.BLANK_DETECTOR_TAG, "开启纯色检测", (Map) null, (LoggerContext) null, 12, (Object) null);
                    Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
                    long currentTimeMillis = System.currentTimeMillis();
                    long j2 = this.timeoutMs;
                    PureColorDetectionStep$execute$duration$1$1 pureColorDetectionStep$execute$duration$1$1 = new PureColorDetectionStep$execute$duration$1$1(detectionContext, this, null);
                    pureColorDetectionStep$execute$1.L$0 = detectionContext;
                    pureColorDetectionStep$execute$1.L$1 = objectRef3;
                    pureColorDetectionStep$execute$1.L$2 = objectRef3;
                    pureColorDetectionStep$execute$1.J$0 = currentTimeMillis;
                    pureColorDetectionStep$execute$1.label = 1;
                    Object withTimeoutOrNull = TimeoutKt.withTimeoutOrNull(j2, pureColorDetectionStep$execute$duration$1$1, pureColorDetectionStep$execute$1);
                    if (withTimeoutOrNull == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    j = currentTimeMillis;
                    objectRef = objectRef3;
                    obj = withTimeoutOrNull;
                    detectionContext2 = detectionContext;
                    objectRef2 = objectRef;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    j = pureColorDetectionStep$execute$1.J$0;
                    objectRef2 = (Ref.ObjectRef) pureColorDetectionStep$execute$1.L$2;
                    objectRef = (Ref.ObjectRef) pureColorDetectionStep$execute$1.L$1;
                    detectionContext2 = (DetectionContext) pureColorDetectionStep$execute$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                error = (BlankCheckResult) obj;
                if (error == null) {
                    BlankCheckResult.Error error2 = new BlankCheckResult.Error(1002, "PureColorDetection timeout", FailureStage.PureColorDetection);
                    detectionContext2.getDetectionStatus().setPureBlankTimeout(true);
                    error = error2;
                }
                objectRef2.element = error;
                long currentTimeMillis2 = System.currentTimeMillis() - j;
                HybridLogger.d$default(HybridLogger.INSTANCE, AnnieXBlankDetectorManager.BLANK_DETECTOR_TAG, "纯色检测结束，检测耗时为 ：" + currentTimeMillis2, (Map) null, (LoggerContext) null, 12, (Object) null);
                detectionContext2.getDetectionStatus().setPureBlankCost(Boxing.boxLong(currentTimeMillis2));
                return objectRef.element;
            }
        }
        pureColorDetectionStep$execute$1 = new PureColorDetectionStep$execute$1(this, continuation);
        Object obj2 = pureColorDetectionStep$execute$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = pureColorDetectionStep$execute$1.label;
        if (i != 0) {
        }
        error = (BlankCheckResult) obj2;
        if (error == null) {
        }
        objectRef2.element = error;
        long currentTimeMillis22 = System.currentTimeMillis() - j;
        HybridLogger.d$default(HybridLogger.INSTANCE, AnnieXBlankDetectorManager.BLANK_DETECTOR_TAG, "纯色检测结束，检测耗时为 ：" + currentTimeMillis22, (Map) null, (LoggerContext) null, 12, (Object) null);
        detectionContext2.getDetectionStatus().setPureBlankCost(Boxing.boxLong(currentTimeMillis22));
        return objectRef.element;
    }
}
