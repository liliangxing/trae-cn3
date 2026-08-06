package com.bytedance.android.anniex.detect.snapshot;

import com.bytedance.android.anniex.detect.AnnieXBlankDetectorManager;
import com.bytedance.android.anniex.detect.SnapShotContext;
import com.bytedance.android.anniex.detect.SnapShotResult;
import com.bytedance.android.anniex.detect.SnapShotStep;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;

/* compiled from: PixelCopyStep.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010\u000fR\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/anniex/detect/snapshot/PixelCopyStep;", "Lcom/bytedance/android/anniex/detect/SnapShotStep;", "timeoutMs", "", "maxQuality", "", "(JF)V", "id", "", "getId", "()Ljava/lang/String;", "execute", "Lcom/bytedance/android/anniex/detect/SnapShotResult;", "context", "Lcom/bytedance/android/anniex/detect/SnapShotContext;", "(Lcom/bytedance/android/anniex/detect/SnapShotContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class PixelCopyStep implements SnapShotStep {
    private final String id;
    private final float maxQuality;
    private final long timeoutMs;

    public PixelCopyStep(long j, float f) {
        this.timeoutMs = j;
        this.maxQuality = f;
        this.id = "PixelCopy";
    }

    public /* synthetic */ PixelCopyStep(long j, float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? 360.0f : f);
    }

    @Override // com.bytedance.android.anniex.detect.SnapShotStep
    public String getId() {
        return this.id;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // com.bytedance.android.anniex.detect.SnapShotStep
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object execute(SnapShotContext snapShotContext, Continuation<? super SnapShotResult> continuation) {
        PixelCopyStep$execute$1 pixelCopyStep$execute$1;
        int i;
        PixelCopyStep pixelCopyStep;
        StringBuilder sb;
        Exception e;
        if (continuation instanceof PixelCopyStep$execute$1) {
            pixelCopyStep$execute$1 = (PixelCopyStep$execute$1) continuation;
            if ((pixelCopyStep$execute$1.label & Integer.MIN_VALUE) != 0) {
                pixelCopyStep$execute$1.label -= Integer.MIN_VALUE;
                Object obj = pixelCopyStep$execute$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = pixelCopyStep$execute$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    HybridLogger.d$default(HybridLogger.INSTANCE, AnnieXBlankDetectorManager.BLANK_DETECTOR_TAG, "开始截图", (Map) null, (LoggerContext) null, 12, (Object) null);
                    StringBuilder sb2 = new StringBuilder();
                    try {
                        long j = this.timeoutMs;
                        PixelCopyStep$execute$2 pixelCopyStep$execute$2 = new PixelCopyStep$execute$2(snapShotContext, this, sb2, null);
                        pixelCopyStep$execute$1.L$0 = this;
                        pixelCopyStep$execute$1.L$1 = sb2;
                        pixelCopyStep$execute$1.label = 1;
                        obj = TimeoutKt.withTimeout(j, pixelCopyStep$execute$2, pixelCopyStep$execute$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        sb = sb2;
                        HybridLogger.e$default(HybridLogger.INSTANCE, AnnieXBlankDetectorManager.BLANK_DETECTOR_TAG, "PixelCopy exception:" + e.getMessage() + ", captureLog: " + ((Object) sb), (Map) null, (LoggerContext) null, 12, (Object) null);
                        return new SnapShotResult(false, "PixelCopy exception:" + e.getMessage() + ", captureLog: " + ((Object) sb));
                    } catch (TimeoutCancellationException unused) {
                        pixelCopyStep = this;
                        sb = sb2;
                        String str = "PixelCopy timeout after " + pixelCopyStep.timeoutMs + "ms, captureLog: " + ((Object) sb);
                        HybridLogger.e$default(HybridLogger.INSTANCE, AnnieXBlankDetectorManager.BLANK_DETECTOR_TAG, str, (Map) null, (LoggerContext) null, 12, (Object) null);
                        return new SnapShotResult(false, str);
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    sb = (StringBuilder) pixelCopyStep$execute$1.L$1;
                    pixelCopyStep = (PixelCopyStep) pixelCopyStep$execute$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Exception e3) {
                        e = e3;
                        HybridLogger.e$default(HybridLogger.INSTANCE, AnnieXBlankDetectorManager.BLANK_DETECTOR_TAG, "PixelCopy exception:" + e.getMessage() + ", captureLog: " + ((Object) sb), (Map) null, (LoggerContext) null, 12, (Object) null);
                        return new SnapShotResult(false, "PixelCopy exception:" + e.getMessage() + ", captureLog: " + ((Object) sb));
                    } catch (TimeoutCancellationException unused2) {
                        String str2 = "PixelCopy timeout after " + pixelCopyStep.timeoutMs + "ms, captureLog: " + ((Object) sb);
                        HybridLogger.e$default(HybridLogger.INSTANCE, AnnieXBlankDetectorManager.BLANK_DETECTOR_TAG, str2, (Map) null, (LoggerContext) null, 12, (Object) null);
                        return new SnapShotResult(false, str2);
                    }
                }
                return obj;
            }
        }
        pixelCopyStep$execute$1 = new PixelCopyStep$execute$1(this, continuation);
        Object obj2 = pixelCopyStep$execute$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = pixelCopyStep$execute$1.label;
        if (i != 0) {
        }
        return obj2;
    }
}
