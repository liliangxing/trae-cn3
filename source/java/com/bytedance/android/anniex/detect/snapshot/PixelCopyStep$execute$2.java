package com.bytedance.android.anniex.detect.snapshot;

import android.graphics.Bitmap;
import android.view.View;
import com.bytedance.android.anniex.detect.AnnieXBlankDetectorManager;
import com.bytedance.android.anniex.detect.SnapShotContext;
import com.bytedance.android.anniex.detect.SnapShotResult;
import com.bytedance.android.anniex.detect.detection.DetectorUtilsKt;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PixelCopyStep.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/bytedance/android/anniex/detect/SnapShotResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 4, 3}, xi = 48)
@DebugMetadata(c = "com.bytedance.android.anniex.detect.snapshot.PixelCopyStep$execute$2", f = "PixelCopyStep.kt", i = {}, l = {38}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class PixelCopyStep$execute$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SnapShotResult>, Object> {
    final /* synthetic */ StringBuilder $captureLog;
    final /* synthetic */ SnapShotContext $context;
    int label;
    final /* synthetic */ PixelCopyStep this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PixelCopyStep$execute$2(SnapShotContext snapShotContext, PixelCopyStep pixelCopyStep, StringBuilder sb, Continuation<? super PixelCopyStep$execute$2> continuation) {
        super(2, continuation);
        this.$context = snapShotContext;
        this.this$0 = pixelCopyStep;
        this.$captureLog = sb;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PixelCopyStep$execute$2(this.$context, this.this$0, this.$captureLog, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super SnapShotResult> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PixelCopyStep.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/bytedance/android/anniex/detect/SnapShotResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 4, 3}, xi = 48)
    @DebugMetadata(c = "com.bytedance.android.anniex.detect.snapshot.PixelCopyStep$execute$2$1", f = "PixelCopyStep.kt", i = {0}, l = {49}, m = "invokeSuspend", n = {"start"}, s = {"J$0"})
    /* renamed from: com.bytedance.android.anniex.detect.snapshot.PixelCopyStep$execute$2$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class C08611 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SnapShotResult>, Object> {
        final /* synthetic */ StringBuilder $captureLog;
        final /* synthetic */ SnapShotContext $context;
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ PixelCopyStep this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08611(SnapShotContext snapShotContext, PixelCopyStep pixelCopyStep, StringBuilder sb, Continuation<? super C08611> continuation) {
            super(2, continuation);
            this.$context = snapShotContext;
            this.this$0 = pixelCopyStep;
            this.$captureLog = sb;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C08611(this.$context, this.this$0, this.$captureLog, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super SnapShotResult> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            float f;
            long j;
            StringBuilder sb;
            SnapShotContext snapShotContext;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                View view = this.$context.getView().get();
                if (view == null) {
                    HybridLogger.e$default(HybridLogger.INSTANCE, AnnieXBlankDetectorManager.BLANK_DETECTOR_TAG, "View is null", (Map) null, (LoggerContext) null, 12, (Object) null);
                    return new SnapShotResult(false, "WeakRef View is null");
                }
                if (!DetectorUtilsKt.isViewSafeToCapture(view)) {
                    HybridLogger.e$default(HybridLogger.INSTANCE, AnnieXBlankDetectorManager.BLANK_DETECTOR_TAG, "View is not attached", (Map) null, (LoggerContext) null, 12, (Object) null);
                }
                long currentTimeMillis = System.currentTimeMillis();
                View view2 = this.$context.getView().get();
                if (view2 != null) {
                    PixelCopyStep pixelCopyStep = this.this$0;
                    StringBuilder sb2 = this.$captureLog;
                    SnapShotContext snapShotContext2 = this.$context;
                    f = pixelCopyStep.maxQuality;
                    float snapShotScale = DetectorUtilsKt.getSnapShotScale(f, view2.getContext());
                    this.L$0 = sb2;
                    this.L$1 = snapShotContext2;
                    this.J$0 = currentTimeMillis;
                    this.label = 1;
                    obj = DetectorUtilsKt.captureAViewBitmap(view2, snapShotScale, sb2, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    j = currentTimeMillis;
                    sb = sb2;
                    snapShotContext = snapShotContext2;
                } else {
                    return new SnapShotResult(false, "view  context is null");
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j = this.J$0;
                snapShotContext = (SnapShotContext) this.L$1;
                sb = (StringBuilder) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            Bitmap bitmap = (Bitmap) obj;
            if (bitmap == null) {
                HybridLogger.e$default(HybridLogger.INSTANCE, AnnieXBlankDetectorManager.BLANK_DETECTOR_TAG, "capture result is null, " + ((Object) sb), (Map) null, (LoggerContext) null, 12, (Object) null);
                return new SnapShotResult(false, "capture result is null," + ((Object) sb));
            }
            long currentTimeMillis2 = System.currentTimeMillis() - j;
            StringBuilder append = sb.append("capture took " + currentTimeMillis2 + "ms");
            Intrinsics.checkNotNullExpressionValue(append, "append(value)");
            Intrinsics.checkNotNullExpressionValue(append.append('\n'), "append('\\n')");
            bitmap.setHasAlpha(false);
            snapShotContext.setBitmap(bitmap);
            snapShotContext.getSnapShotStats().setPixelCopyCost(Boxing.boxLong(currentTimeMillis2));
            snapShotContext.getSnapShotStats().setPixelCopySuccess(true);
            HybridLogger.d$default(HybridLogger.INSTANCE, AnnieXBlankDetectorManager.BLANK_DETECTOR_TAG, "截图完成", (Map) null, (LoggerContext) null, 12, (Object) null);
            return new SnapShotResult(true, null);
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getMain().getImmediate(), new C08611(this.$context, this.this$0, this.$captureLog, null), (Continuation) this);
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
