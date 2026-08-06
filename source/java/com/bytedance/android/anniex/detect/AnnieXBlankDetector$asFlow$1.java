package com.bytedance.android.anniex.detect;

import android.graphics.Bitmap;
import android.view.View;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AnnieXBlankDetector.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/bytedance/android/anniex/detect/DetectionStatus;"}, k = 3, mv = {1, 4, 3}, xi = 48)
@DebugMetadata(c = "com.bytedance.android.anniex.detect.AnnieXBlankDetector$asFlow$1", f = "AnnieXBlankDetector.kt", i = {0, 0, 0, 2}, l = {32, 42, 55, 60}, m = "invokeSuspend", n = {"$this$flow", "viewRef", "snapShotContext", "$this$flow"}, s = {"L$0", "L$1", "L$2", "L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXBlankDetector$asFlow$1 extends SuspendLambda implements Function2<FlowCollector<? super DetectionStatus>, Continuation<? super Unit>, Object> {
    final /* synthetic */ DetectionStatus $detectionStatus;
    final /* synthetic */ View $view;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ AnnieXBlankDetector this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnnieXBlankDetector$asFlow$1(View view, AnnieXBlankDetector annieXBlankDetector, DetectionStatus detectionStatus, Continuation<? super AnnieXBlankDetector$asFlow$1> continuation) {
        super(2, continuation);
        this.$view = view;
        this.this$0 = annieXBlankDetector;
        this.$detectionStatus = detectionStatus;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> annieXBlankDetector$asFlow$1 = new AnnieXBlankDetector$asFlow$1(this.$view, this.this$0, this.$detectionStatus, continuation);
        annieXBlankDetector$asFlow$1.L$0 = obj;
        return annieXBlankDetector$asFlow$1;
    }

    public final Object invoke(FlowCollector<? super DetectionStatus> flowCollector, Continuation<? super Unit> continuation) {
        return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00ef A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        WeakReference weakReference;
        SnapshotPipeline snapshotPipeline;
        Object run;
        FlowCollector flowCollector;
        SnapShotContext snapShotContext;
        FlowCollector flowCollector2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector3 = (FlowCollector) this.L$0;
            weakReference = new WeakReference(this.$view);
            SnapShotContext snapShotContext2 = new SnapShotContext(weakReference, null, null, null, 14, null);
            snapshotPipeline = this.this$0.snapShotPipeline;
            this.L$0 = flowCollector3;
            this.L$1 = weakReference;
            this.L$2 = snapShotContext2;
            this.label = 1;
            run = snapshotPipeline.run(snapShotContext2, (Continuation) this);
            if (run == coroutine_suspended) {
                return coroutine_suspended;
            }
            flowCollector = flowCollector3;
            snapShotContext = snapShotContext2;
        } else {
            if (i != 1) {
                if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                if (i != 3) {
                    if (i != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                flowCollector2 = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
                this.L$0 = null;
                this.label = 4;
                if (flowCollector2.emit(this.$detectionStatus, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            snapShotContext = (SnapShotContext) this.L$2;
            WeakReference weakReference2 = (WeakReference) this.L$1;
            flowCollector = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
            weakReference = weakReference2;
            run = obj;
        }
        SnapShotResult snapShotResult = (SnapShotResult) run;
        DetectionStatus detectionStatus = this.$detectionStatus;
        detectionStatus.setDetectFinish(false);
        detectionStatus.setPixelCopyCost(snapShotContext.getSnapShotStats().getIsPixelCopyCost());
        detectionStatus.setPixelCopySuccess(snapShotContext.getSnapShotStats().getIsPixelCopySuccess());
        if (!snapShotResult.isSuccess() || snapShotContext.getBitmap() == null) {
            DetectionStatus detectionStatus2 = this.$detectionStatus;
            StringBuilder append = detectionStatus2.getErrorMsg().append("PixelCopy EXCEPTION: " + snapShotResult.getErrorMsg());
            Intrinsics.checkNotNullExpressionValue(append, "append(value)");
            Intrinsics.checkNotNullExpressionValue(append.append('\n'), "append('\\n')");
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.label = 2;
            if (flowCollector.emit(detectionStatus2, (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
        weakReference.clear();
        Bitmap bitmap = snapShotContext.getBitmap();
        Intrinsics.checkNotNull(bitmap);
        DetectionContext detectionContext = new DetectionContext(bitmap, this.$detectionStatus, null, 4, null);
        this.L$0 = flowCollector;
        this.L$1 = null;
        this.L$2 = null;
        this.label = 3;
        if (BuildersKt.withContext(Dispatchers.getIO(), new C08553(this.this$0, detectionContext, null), (Continuation) this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        flowCollector2 = flowCollector;
        this.L$0 = null;
        this.label = 4;
        if (flowCollector2.emit(this.$detectionStatus, (Continuation) this) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnnieXBlankDetector.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 4, 3}, xi = 48)
    @DebugMetadata(c = "com.bytedance.android.anniex.detect.AnnieXBlankDetector$asFlow$1$3", f = "AnnieXBlankDetector.kt", i = {}, l = {56}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.android.anniex.detect.AnnieXBlankDetector$asFlow$1$3 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class C08553 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DetectionContext $context;
        int label;
        final /* synthetic */ AnnieXBlankDetector this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08553(AnnieXBlankDetector annieXBlankDetector, DetectionContext detectionContext, Continuation<? super C08553> continuation) {
            super(2, continuation);
            this.this$0 = annieXBlankDetector;
            this.$context = detectionContext;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C08553(this.this$0, this.$context, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            DetectionPipeline detectionPipeline;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                detectionPipeline = this.this$0.detectPipeline;
                this.label = 1;
                if (detectionPipeline.run(this.$context, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            this.$context.getDetectionStatus().setDetectFinish(true);
            return Unit.INSTANCE;
        }
    }
}
