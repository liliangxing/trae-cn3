package com.bytedance.android.anniex.detect.detection;

import android.graphics.Bitmap;
import com.bytedance.android.anniex.ability.service.TaskResultCallback;
import com.bytedance.android.anniex.detect.AnnieXBlankDetectorManager;
import com.bytedance.android.anniex.detect.BlankCheckResult;
import com.bytedance.android.anniex.detect.DetectionContext;
import com.bytedance.android.anniex.detect.DetectionStep;
import com.bytedance.android.anniex.detect.FailureStage;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutKt;
import org.json.JSONArray;

/* compiled from: PartialBlankDetectionStep.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012(\u0010\u0004\u001a$\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0005¢\u0006\u0002\u0010\u000bJ\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0096@¢\u0006\u0002\u0010\u0015J\u0018\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u0018\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u0018\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002R2\u0010\u0004\u001a$\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/anniex/detect/detection/PartialBlankDetectionStep;", "Lcom/bytedance/android/anniex/detect/DetectionStep;", "timeoutMs", "", "checker", "Lkotlin/Function3;", "Landroid/graphics/Bitmap;", "Lcom/bytedance/android/anniex/ability/service/TaskResultCallback;", "Lkotlin/coroutines/Continuation;", "", "", "(JLkotlin/jvm/functions/Function3;)V", "Lkotlin/jvm/functions/Function3;", "id", "", "getId", "()Ljava/lang/String;", "execute", "Lcom/bytedance/android/anniex/detect/BlankCheckResult;", "context", "Lcom/bytedance/android/anniex/detect/DetectionContext;", "(Lcom/bytedance/android/anniex/detect/DetectionContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseBboxs", "", "jsonArray", "Lorg/json/JSONArray;", "parseClassLabels", "parseScores", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class PartialBlankDetectionStep implements DetectionStep {
    private final Function3<Bitmap, TaskResultCallback, Continuation<? super Unit>, Object> checker;
    private final String id;
    private final long timeoutMs;

    /* JADX WARN: Multi-variable type inference failed */
    public PartialBlankDetectionStep(long j, Function3<? super Bitmap, ? super TaskResultCallback, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.checkNotNullParameter(function3, "checker");
        this.timeoutMs = j;
        this.checker = function3;
        this.id = "PartialBlankDetection";
    }

    @Override // com.bytedance.android.anniex.detect.DetectionStep
    public String getId() {
        return this.id;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00dd A[PHI: r2
      0x00dd: PHI (r2v5 java.lang.Object) = (r2v4 java.lang.Object), (r2v1 java.lang.Object) binds: [B:20:0x00da, B:10:0x0030] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00dc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    @Override // com.bytedance.android.anniex.detect.DetectionStep
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object execute(DetectionContext detectionContext, Continuation<? super BlankCheckResult> continuation) {
        PartialBlankDetectionStep$execute$1 partialBlankDetectionStep$execute$1;
        int i;
        CompletableDeferred CompletableDeferred$default;
        long currentTimeMillis;
        Object withTimeoutOrNull;
        DetectionContext detectionContext2 = detectionContext;
        if (continuation instanceof PartialBlankDetectionStep$execute$1) {
            partialBlankDetectionStep$execute$1 = (PartialBlankDetectionStep$execute$1) continuation;
            if ((partialBlankDetectionStep$execute$1.label & Integer.MIN_VALUE) != 0) {
                partialBlankDetectionStep$execute$1.label -= Integer.MIN_VALUE;
                Object obj = partialBlankDetectionStep$execute$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = partialBlankDetectionStep$execute$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    HybridLogger.d$default(HybridLogger.INSTANCE, AnnieXBlankDetectorManager.BLANK_DETECTOR_TAG, "开启半白屏检测", (Map) null, (LoggerContext) null, 12, (Object) null);
                    CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
                    currentTimeMillis = System.currentTimeMillis();
                    long j = this.timeoutMs;
                    PartialBlankDetectionStep$execute$duration$1$1 partialBlankDetectionStep$execute$duration$1$1 = new PartialBlankDetectionStep$execute$duration$1$1(this, detectionContext2, CompletableDeferred$default, null);
                    partialBlankDetectionStep$execute$1.L$0 = detectionContext2;
                    partialBlankDetectionStep$execute$1.L$1 = CompletableDeferred$default;
                    partialBlankDetectionStep$execute$1.J$0 = currentTimeMillis;
                    partialBlankDetectionStep$execute$1.label = 1;
                    withTimeoutOrNull = TimeoutKt.withTimeoutOrNull(j, partialBlankDetectionStep$execute$duration$1$1, partialBlankDetectionStep$execute$1);
                    if (withTimeoutOrNull == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        if (i == 2) {
                            ResultKt.throwOnFailure(obj);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    currentTimeMillis = partialBlankDetectionStep$execute$1.J$0;
                    CompletableDeferred completableDeferred = (CompletableDeferred) partialBlankDetectionStep$execute$1.L$1;
                    DetectionContext detectionContext3 = (DetectionContext) partialBlankDetectionStep$execute$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    CompletableDeferred$default = completableDeferred;
                    detectionContext2 = detectionContext3;
                    withTimeoutOrNull = obj;
                }
                if (((BlankCheckResult) withTimeoutOrNull) == null) {
                    BlankCheckResult.Error error = new BlankCheckResult.Error(1004, "PartialBlankDetection timeout", FailureStage.PartialBlankDetection);
                    detectionContext2.getDetectionStatus().setPartialBlankTimeout(true);
                    Boxing.boxBoolean(CompletableDeferred$default.complete(error));
                }
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                detectionContext2.getDetectionStatus().setPartialBlankCost(Boxing.boxLong(currentTimeMillis2));
                HybridLogger.d$default(HybridLogger.INSTANCE, AnnieXBlankDetectorManager.BLANK_DETECTOR_TAG, "半白屏检测结束，检测耗时为 ：" + currentTimeMillis2, (Map) null, (LoggerContext) null, 12, (Object) null);
                partialBlankDetectionStep$execute$1.L$0 = null;
                partialBlankDetectionStep$execute$1.L$1 = null;
                partialBlankDetectionStep$execute$1.label = 2;
                obj = CompletableDeferred$default.await(partialBlankDetectionStep$execute$1);
                return obj != coroutine_suspended ? coroutine_suspended : obj;
            }
        }
        partialBlankDetectionStep$execute$1 = new PartialBlankDetectionStep$execute$1(this, continuation);
        Object obj2 = partialBlankDetectionStep$execute$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = partialBlankDetectionStep$execute$1.label;
        if (i != 0) {
        }
        if (((BlankCheckResult) withTimeoutOrNull) == null) {
        }
        long currentTimeMillis22 = System.currentTimeMillis() - currentTimeMillis;
        detectionContext2.getDetectionStatus().setPartialBlankCost(Boxing.boxLong(currentTimeMillis22));
        HybridLogger.d$default(HybridLogger.INSTANCE, AnnieXBlankDetectorManager.BLANK_DETECTOR_TAG, "半白屏检测结束，检测耗时为 ：" + currentTimeMillis22, (Map) null, (LoggerContext) null, 12, (Object) null);
        partialBlankDetectionStep$execute$1.L$0 = null;
        partialBlankDetectionStep$execute$1.L$1 = null;
        partialBlankDetectionStep$execute$1.label = 2;
        obj2 = CompletableDeferred$default.await(partialBlankDetectionStep$execute$1);
        if (obj2 != coroutine_suspended2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<String> parseBboxs(JSONArray jsonArray) {
        if (jsonArray == null || jsonArray.length() == 0) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(jsonArray.length());
        int length = jsonArray.length();
        for (int i = 0; i < length; i++) {
            JSONArray optJSONArray = jsonArray.optJSONArray(i);
            if (optJSONArray != null) {
                StringBuilder sb = new StringBuilder();
                int length2 = optJSONArray.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    sb.append(optJSONArray.optInt(i2)).append(",");
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                arrayList.add(sb.toString());
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<String> parseClassLabels(JSONArray jsonArray) {
        if (jsonArray == null || jsonArray.length() == 0) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(jsonArray.length());
        int length = jsonArray.length();
        for (int i = 0; i < length; i++) {
            String optString = jsonArray.optString(i);
            if (optString != null) {
                if (!(optString.length() > 0)) {
                    optString = null;
                }
                if (optString != null) {
                    arrayList.add(optString);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Float> parseScores(JSONArray jsonArray) {
        if (jsonArray == null || jsonArray.length() == 0) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(jsonArray.length());
        int length = jsonArray.length();
        for (int i = 0; i < length; i++) {
            Integer valueOf = Integer.valueOf(jsonArray.optInt(i));
            if (!(valueOf.intValue() >= 0)) {
                valueOf = null;
            }
            if (valueOf != null) {
                arrayList.add(Float.valueOf(valueOf.intValue() / 100.0f));
            }
        }
        return arrayList;
    }
}
