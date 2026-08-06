package com.bytedance.android.anniex.detect.detection;

import android.graphics.Bitmap;
import com.bytedance.android.anniex.ability.service.TaskConfig;
import com.bytedance.android.anniex.ability.service.TaskResultCallback;
import com.bytedance.android.anniex.detect.AnnieXBlankDetectMonitor;
import com.bytedance.android.anniex.detect.AnnieXBlankDetectorManager;
import com.bytedance.android.anniex.detect.BlankCheckResult;
import com.bytedance.android.anniex.detect.DetectionContext;
import com.bytedance.android.anniex.detect.DetectionStatus;
import com.bytedance.android.anniex.detect.FailureStage;
import com.bytedance.android.anniex.pitaya.PitayaPackageInfo;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.android.anniex.pitaya.StrategyError;
import com.bytedance.android.anniex.pitaya.StrategyManager;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PartialBlankDetectionStep.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/bytedance/android/anniex/detect/BlankCheckResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 4, 3}, xi = 48)
@DebugMetadata(c = "com.bytedance.android.anniex.detect.detection.PartialBlankDetectionStep$execute$duration$1$1", f = "PartialBlankDetectionStep.kt", i = {}, l = {42}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class PartialBlankDetectionStep$execute$duration$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BlankCheckResult>, Object> {
    final /* synthetic */ DetectionContext $context;
    final /* synthetic */ CompletableDeferred<BlankCheckResult> $resultDeferred;
    int label;
    final /* synthetic */ PartialBlankDetectionStep this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PartialBlankDetectionStep$execute$duration$1$1(PartialBlankDetectionStep partialBlankDetectionStep, DetectionContext detectionContext, CompletableDeferred<BlankCheckResult> completableDeferred, Continuation<? super PartialBlankDetectionStep$execute$duration$1$1> continuation) {
        super(2, continuation);
        this.this$0 = partialBlankDetectionStep;
        this.$context = detectionContext;
        this.$resultDeferred = completableDeferred;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PartialBlankDetectionStep$execute$duration$1$1(this.this$0, this.$context, this.$resultDeferred, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super BlankCheckResult> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PartialBlankDetectionStep.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/bytedance/android/anniex/detect/BlankCheckResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 4, 3}, xi = 48)
    @DebugMetadata(c = "com.bytedance.android.anniex.detect.detection.PartialBlankDetectionStep$execute$duration$1$1$1", f = "PartialBlankDetectionStep.kt", i = {}, l = {44, 109}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.android.anniex.detect.detection.PartialBlankDetectionStep$execute$duration$1$1$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class C08591 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BlankCheckResult>, Object> {
        final /* synthetic */ DetectionContext $context;
        final /* synthetic */ CompletableDeferred<BlankCheckResult> $resultDeferred;
        int label;
        final /* synthetic */ PartialBlankDetectionStep this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08591(PartialBlankDetectionStep partialBlankDetectionStep, DetectionContext detectionContext, CompletableDeferred<BlankCheckResult> completableDeferred, Continuation<? super C08591> continuation) {
            super(2, continuation);
            this.this$0 = partialBlankDetectionStep;
            this.$context = detectionContext;
            this.$resultDeferred = completableDeferred;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C08591(this.this$0, this.$context, this.$resultDeferred, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super BlankCheckResult> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Function3 function3;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final long currentTimeMillis = System.currentTimeMillis();
                function3 = this.this$0.checker;
                Bitmap bitmap = this.$context.getBitmap();
                final CompletableDeferred<BlankCheckResult> completableDeferred = this.$resultDeferred;
                final PartialBlankDetectionStep partialBlankDetectionStep = this.this$0;
                final DetectionContext detectionContext = this.$context;
                TaskResultCallback taskResultCallback = new TaskResultCallback() { // from class: com.bytedance.android.anniex.detect.detection.PartialBlankDetectionStep.execute.duration.1.1.1.1
                    /* JADX WARN: Removed duplicated region for block: B:15:0x005a A[Catch: Exception -> 0x0045, TryCatch #0 {Exception -> 0x0045, blocks: (B:50:0x0038, B:13:0x0056, B:15:0x005a, B:16:0x0062, B:18:0x006a, B:19:0x0072, B:21:0x007a, B:22:0x0083, B:24:0x009e, B:26:0x00a4, B:30:0x00ae, B:32:0x00e0, B:33:0x012f, B:40:0x0126, B:46:0x004d), top: B:49:0x0038 }] */
                    /* JADX WARN: Removed duplicated region for block: B:18:0x006a A[Catch: Exception -> 0x0045, TryCatch #0 {Exception -> 0x0045, blocks: (B:50:0x0038, B:13:0x0056, B:15:0x005a, B:16:0x0062, B:18:0x006a, B:19:0x0072, B:21:0x007a, B:22:0x0083, B:24:0x009e, B:26:0x00a4, B:30:0x00ae, B:32:0x00e0, B:33:0x012f, B:40:0x0126, B:46:0x004d), top: B:49:0x0038 }] */
                    /* JADX WARN: Removed duplicated region for block: B:21:0x007a A[Catch: Exception -> 0x0045, TryCatch #0 {Exception -> 0x0045, blocks: (B:50:0x0038, B:13:0x0056, B:15:0x005a, B:16:0x0062, B:18:0x006a, B:19:0x0072, B:21:0x007a, B:22:0x0083, B:24:0x009e, B:26:0x00a4, B:30:0x00ae, B:32:0x00e0, B:33:0x012f, B:40:0x0126, B:46:0x004d), top: B:49:0x0038 }] */
                    /* JADX WARN: Removed duplicated region for block: B:30:0x00ae A[Catch: Exception -> 0x0045, TryCatch #0 {Exception -> 0x0045, blocks: (B:50:0x0038, B:13:0x0056, B:15:0x005a, B:16:0x0062, B:18:0x006a, B:19:0x0072, B:21:0x007a, B:22:0x0083, B:24:0x009e, B:26:0x00a4, B:30:0x00ae, B:32:0x00e0, B:33:0x012f, B:40:0x0126, B:46:0x004d), top: B:49:0x0038 }] */
                    /* JADX WARN: Removed duplicated region for block: B:32:0x00e0 A[Catch: Exception -> 0x0045, TryCatch #0 {Exception -> 0x0045, blocks: (B:50:0x0038, B:13:0x0056, B:15:0x005a, B:16:0x0062, B:18:0x006a, B:19:0x0072, B:21:0x007a, B:22:0x0083, B:24:0x009e, B:26:0x00a4, B:30:0x00ae, B:32:0x00e0, B:33:0x012f, B:40:0x0126, B:46:0x004d), top: B:49:0x0038 }] */
                    /* JADX WARN: Removed duplicated region for block: B:40:0x0126 A[Catch: Exception -> 0x0045, TryCatch #0 {Exception -> 0x0045, blocks: (B:50:0x0038, B:13:0x0056, B:15:0x005a, B:16:0x0062, B:18:0x006a, B:19:0x0072, B:21:0x007a, B:22:0x0083, B:24:0x009e, B:26:0x00a4, B:30:0x00ae, B:32:0x00e0, B:33:0x012f, B:40:0x0126, B:46:0x004d), top: B:49:0x0038 }] */
                    /* JADX WARN: Removed duplicated region for block: B:41:0x00d9  */
                    /* JADX WARN: Removed duplicated region for block: B:43:0x0082  */
                    /* JADX WARN: Removed duplicated region for block: B:44:0x0071  */
                    /* JADX WARN: Removed duplicated region for block: B:45:0x0061  */
                    @Override // com.bytedance.android.anniex.ability.service.TaskResultCallback
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public void onResult(boolean isPitayaReady, boolean success, StrategyError error, JSONObject outputData, JSONObject extraParams, PitayaPackageInfo packageInfo) {
                        Integer valueOf;
                        boolean z;
                        List<String> parseBboxs;
                        List<String> parseClassLabels;
                        List<Float> parseScores;
                        List<Float> list;
                        List<String> list2;
                        Integer num;
                        List<String> list3;
                        BlankCheckResult.Success success2;
                        StrategyManager.Strategy strategy;
                        if (!isPitayaReady) {
                            HybridLogger.e$default(HybridLogger.INSTANCE, AnnieXBlankDetectorManager.BLANK_DETECTOR_TAG, "Pitaya 未准备好", (Map) null, (LoggerContext) null, 12, (Object) null);
                            CompletableDeferred<BlankCheckResult> completableDeferred2 = completableDeferred;
                            BlankCheckResult.Error error2 = new BlankCheckResult.Error(1003, "Pitaya not ready", FailureStage.PartialBlankDetection);
                            detectionContext.getDetectionStatus().setPitayaReady(false);
                            completableDeferred2.complete(error2);
                            return;
                        }
                        if (outputData != null) {
                            try {
                                valueOf = Integer.valueOf(outputData.optInt(StrategyConstants.RESULT, 0));
                            } catch (Exception e) {
                                HybridLogger.d$default(HybridLogger.INSTANCE, AnnieXBlankDetectorManager.BLANK_DETECTOR_TAG, "半白屏检测 结束 异常:" + e.getMessage(), (Map) null, (LoggerContext) null, 12, (Object) null);
                                completableDeferred.completeExceptionally(e);
                                return;
                            }
                        } else {
                            valueOf = null;
                        }
                        boolean z2 = true;
                        if (valueOf != null && valueOf.intValue() == 0) {
                            z = false;
                            parseBboxs = partialBlankDetectionStep.parseBboxs(outputData == null ? outputData.optJSONArray("bboxs") : null);
                            parseClassLabels = partialBlankDetectionStep.parseClassLabels(outputData == null ? outputData.optJSONArray("class_labels") : null);
                            parseScores = partialBlankDetectionStep.parseScores(outputData == null ? outputData.optJSONArray("scores") : null);
                            DetectionStatus detectionStatus = detectionContext.getDetectionStatus();
                            detectionStatus.setBboxs(parseBboxs);
                            detectionStatus.setClassLabels(parseClassLabels);
                            detectionStatus.setScores(parseScores);
                            detectionStatus.setPartialBlank(z);
                            detectionStatus.setPitayaReady(true);
                            if (packageInfo != null || (strategy = packageInfo.getStrategy()) == null || !strategy.getEnable()) {
                                z2 = false;
                            }
                            if (z2) {
                                list = parseScores;
                                list2 = parseClassLabels;
                                num = valueOf;
                                list3 = parseBboxs;
                            } else {
                                num = valueOf;
                                list = parseScores;
                                list2 = parseClassLabels;
                                list3 = parseBboxs;
                                AnnieXBlankDetectMonitor.INSTANCE.reportAnnieXModelInferenceResult(System.currentTimeMillis() - currentTimeMillis, String.valueOf(z), success, new TaskConfig("caijing_half_blank_detection", false, null, 5.0f), error, outputData, packageInfo);
                            }
                            if (!z) {
                                HybridLogger.e$default(HybridLogger.INSTANCE, AnnieXBlankDetectorManager.BLANK_DETECTOR_TAG, "白屏检测异常，result:" + num + ", bboxs:" + list3 + ", classLabels:" + list2 + ", scores:" + list, (Map) null, (LoggerContext) null, 12, (Object) null);
                                success2 = new BlankCheckResult.PartialWhite(1003);
                            } else {
                                success2 = new BlankCheckResult.Success(200);
                            }
                            HybridLogger.d$default(HybridLogger.INSTANCE, AnnieXBlankDetectorManager.BLANK_DETECTOR_TAG, "半白屏检测 结束 结果:" + z, (Map) null, (LoggerContext) null, 12, (Object) null);
                            completableDeferred.complete(success2);
                        }
                        z = true;
                        parseBboxs = partialBlankDetectionStep.parseBboxs(outputData == null ? outputData.optJSONArray("bboxs") : null);
                        parseClassLabels = partialBlankDetectionStep.parseClassLabels(outputData == null ? outputData.optJSONArray("class_labels") : null);
                        parseScores = partialBlankDetectionStep.parseScores(outputData == null ? outputData.optJSONArray("scores") : null);
                        DetectionStatus detectionStatus2 = detectionContext.getDetectionStatus();
                        detectionStatus2.setBboxs(parseBboxs);
                        detectionStatus2.setClassLabels(parseClassLabels);
                        detectionStatus2.setScores(parseScores);
                        detectionStatus2.setPartialBlank(z);
                        detectionStatus2.setPitayaReady(true);
                        if (packageInfo != null) {
                        }
                        z2 = false;
                        if (z2) {
                        }
                        if (!z) {
                        }
                        HybridLogger.d$default(HybridLogger.INSTANCE, AnnieXBlankDetectorManager.BLANK_DETECTOR_TAG, "半白屏检测 结束 结果:" + z, (Map) null, (LoggerContext) null, 12, (Object) null);
                        completableDeferred.complete(success2);
                    }
                };
                this.label = 1;
                if (function3.invoke(bitmap, taskResultCallback, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i == 2) {
                        ResultKt.throwOnFailure(obj);
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            this.label = 2;
            obj = this.$resultDeferred.await((Continuation) this);
            return obj == coroutine_suspended ? coroutine_suspended : obj;
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getDefault(), new C08591(this.this$0, this.$context, this.$resultDeferred, null), (Continuation) this);
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
