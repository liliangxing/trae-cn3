package com.bytedance.android.anniex.detect;

import android.view.View;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import java.util.Map;
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
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AnnieXBlankDetectorManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 4, 3}, xi = 48)
@DebugMetadata(c = "com.bytedance.android.anniex.detect.AnnieXBlankDetectorManager$observeAViewResult$1", f = "AnnieXBlankDetectorManager.kt", i = {}, l = {246}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXBlankDetectorManager$observeAViewResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BlankDetectorItemConfig $config;
    final /* synthetic */ AnnieXBlankDetector $detector;
    final /* synthetic */ View $view;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnnieXBlankDetectorManager$observeAViewResult$1(AnnieXBlankDetector annieXBlankDetector, View view, BlankDetectorItemConfig blankDetectorItemConfig, Continuation<? super AnnieXBlankDetectorManager$observeAViewResult$1> continuation) {
        super(2, continuation);
        this.$detector = annieXBlankDetector;
        this.$view = view;
        this.$config = blankDetectorItemConfig;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AnnieXBlankDetectorManager$observeAViewResult$1(this.$detector, this.$view, this.$config, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        BlankDetectorConfig blankDetectorConfig;
        BlankDetectorConfig blankDetectorConfig2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AnnieXBlankDetector annieXBlankDetector = this.$detector;
            View view = this.$view;
            DetectionStatus detectionStatus = new DetectionStatus(false, false, false, null, false, false, null, null, false, false, null, null, null, null, null, null, 65535, null);
            blankDetectorConfig = AnnieXBlankDetectorManager.INSTANCE.getBlankDetectorConfig();
            detectionStatus.setEnablePureBlankCheck(Boxing.boxBoolean(blankDetectorConfig.isPureBlankCheckEnable()));
            blankDetectorConfig2 = AnnieXBlankDetectorManager.INSTANCE.getBlankDetectorConfig();
            detectionStatus.setEnablePartialBlankCheck(Boxing.boxBoolean(blankDetectorConfig2.isPartialBlankCheckEnable()));
            Unit unit = Unit.INSTANCE;
            Flow flowOn = FlowKt.flowOn(annieXBlankDetector.asFlow(view, detectionStatus), Dispatchers.getMain().getImmediate());
            final BlankDetectorItemConfig blankDetectorItemConfig = this.$config;
            this.label = 1;
            if (flowOn.collect(new FlowCollector<DetectionStatus>() { // from class: com.bytedance.android.anniex.detect.AnnieXBlankDetectorManager$observeAViewResult$1.2
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((DetectionStatus) obj2, (Continuation<? super Unit>) continuation);
                }

                public Object emit(DetectionStatus detectionStatus2, Continuation<? super Unit> continuation) {
                    HybridLogger.i$default(HybridLogger.INSTANCE, AnnieXBlankDetectorManager.BLANK_DETECTOR_TAG, "检测结束，检测结果: " + detectionStatus2, (Map) null, (LoggerContext) null, 12, (Object) null);
                    AnnieXBlankDetectMonitor.INSTANCE.reportBlankDetectResult(detectionStatus2, BlankDetectorItemConfig.this);
                    return Unit.INSTANCE;
                }
            }, (Continuation) this) == coroutine_suspended) {
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
