package com.bytedance.android.anniex.detect.detection;

import com.bytedance.android.anniex.detect.AnnieXBlankDetectorManager;
import com.bytedance.android.anniex.detect.BlankCheckResult;
import com.bytedance.android.anniex.detect.DetectionContext;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PureColorDetectionStep.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/bytedance/android/anniex/detect/BlankCheckResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 4, 3}, xi = 48)
@DebugMetadata(c = "com.bytedance.android.anniex.detect.detection.PureColorDetectionStep$execute$duration$1$1", f = "PureColorDetectionStep.kt", i = {}, l = {35}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class PureColorDetectionStep$execute$duration$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BlankCheckResult>, Object> {
    final /* synthetic */ DetectionContext $context;
    int label;
    final /* synthetic */ PureColorDetectionStep this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PureColorDetectionStep$execute$duration$1$1(DetectionContext detectionContext, PureColorDetectionStep pureColorDetectionStep, Continuation<? super PureColorDetectionStep$execute$duration$1$1> continuation) {
        super(2, continuation);
        this.$context = detectionContext;
        this.this$0 = pureColorDetectionStep;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PureColorDetectionStep$execute$duration$1$1(this.$context, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super BlankCheckResult> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PureColorDetectionStep.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/bytedance/android/anniex/detect/BlankCheckResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 4, 3}, xi = 48)
    @DebugMetadata(c = "com.bytedance.android.anniex.detect.detection.PureColorDetectionStep$execute$duration$1$1$1", f = "PureColorDetectionStep.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.android.anniex.detect.detection.PureColorDetectionStep$execute$duration$1$1$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class C08601 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BlankCheckResult>, Object> {
        final /* synthetic */ DetectionContext $context;
        int label;
        final /* synthetic */ PureColorDetectionStep this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08601(DetectionContext detectionContext, PureColorDetectionStep pureColorDetectionStep, Continuation<? super C08601> continuation) {
            super(2, continuation);
            this.$context = detectionContext;
            this.this$0 = pureColorDetectionStep;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C08601(this.$context, this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super BlankCheckResult> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            float f;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            float isPureColorBitmapProbability = DetectorUtilsKt.isPureColorBitmapProbability(this.$context.getBitmap());
            HybridLogger.d$default(HybridLogger.INSTANCE, AnnieXBlankDetectorManager.BLANK_DETECTOR_TAG, "纯色检测概率为：" + isPureColorBitmapProbability, (Map) null, (LoggerContext) null, 12, (Object) null);
            f = this.this$0.tolerance;
            if (isPureColorBitmapProbability > f) {
                HybridLogger.e$default(HybridLogger.INSTANCE, AnnieXBlankDetectorManager.BLANK_DETECTOR_TAG, "纯色白屏检测异常，probability：" + isPureColorBitmapProbability, (Map) null, (LoggerContext) null, 12, (Object) null);
                BlankCheckResult.PureWhite pureWhite = new BlankCheckResult.PureWhite(1000, isPureColorBitmapProbability);
                this.$context.getDetectionStatus().setPureBlank(true);
                return pureWhite;
            }
            return new BlankCheckResult.Success(200);
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getDefault(), new C08601(this.$context, this.this$0, null), (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
