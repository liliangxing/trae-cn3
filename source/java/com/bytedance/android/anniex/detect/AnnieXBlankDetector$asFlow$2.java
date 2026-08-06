package com.bytedance.android.anniex.detect;

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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: AnnieXBlankDetector.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/bytedance/android/anniex/detect/DetectionStatus;", "e", ""}, k = 3, mv = {1, 4, 3}, xi = 48)
@DebugMetadata(c = "com.bytedance.android.anniex.detect.AnnieXBlankDetector$asFlow$2", f = "AnnieXBlankDetector.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
final class AnnieXBlankDetector$asFlow$2 extends SuspendLambda implements Function3<FlowCollector<? super DetectionStatus>, Throwable, Continuation<? super Unit>, Object> {
    final /* synthetic */ DetectionStatus $detectionStatus;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnnieXBlankDetector$asFlow$2(DetectionStatus detectionStatus, Continuation<? super AnnieXBlankDetector$asFlow$2> continuation) {
        super(3, continuation);
        this.$detectionStatus = detectionStatus;
    }

    public final Object invoke(FlowCollector<? super DetectionStatus> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        AnnieXBlankDetector$asFlow$2 annieXBlankDetector$asFlow$2 = new AnnieXBlankDetector$asFlow$2(this.$detectionStatus, continuation);
        annieXBlankDetector$asFlow$2.L$0 = flowCollector;
        annieXBlankDetector$asFlow$2.L$1 = th;
        return annieXBlankDetector$asFlow$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Throwable th = (Throwable) this.L$1;
            HybridLogger.e$default(HybridLogger.INSTANCE, AnnieXBlankDetectorManager.BLANK_DETECTOR_TAG, "检测异常: " + th.getMessage(), (Map) null, (LoggerContext) null, 12, (Object) null);
            DetectionStatus detectionStatus = this.$detectionStatus;
            detectionStatus.setDetectFinish(false);
            StringBuilder append = detectionStatus.getErrorMsg().append("Detection EXCEPTION: " + th.getMessage());
            Intrinsics.checkNotNullExpressionValue(append, "append(value)");
            Intrinsics.checkNotNullExpressionValue(append.append('\n'), "append('\\n')");
            this.L$0 = null;
            this.label = 1;
            if (flowCollector.emit(detectionStatus, (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
