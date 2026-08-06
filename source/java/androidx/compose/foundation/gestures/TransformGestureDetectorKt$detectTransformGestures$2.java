package androidx.compose.foundation.gestures;

import androidx.compose.p002ui.geometry.Offset;
import androidx.compose.p002ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p002ui.input.pointer.PointerEvent;
import androidx.compose.p002ui.input.pointer.PointerEventKt;
import androidx.compose.p002ui.input.pointer.PointerInputChange;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TransformGestureDetector.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.TransformGestureDetectorKt$detectTransformGestures$2", f = "TransformGestureDetector.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {60, 62}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "rotation", "zoom", "pan", "pastTouchSlop", "touchSlop", "lockedToPanZoom", "$this$awaitEachGesture", "rotation", "zoom", "pan", "pastTouchSlop", "touchSlop", "lockedToPanZoom"}, s = {"L$0", "F$0", "F$1", "J$0", "I$0", "F$2", "I$1", "L$0", "F$0", "F$1", "J$0", "I$0", "F$2", "I$1"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class TransformGestureDetectorKt$detectTransformGestures$2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function4<Offset, Offset, Float, Float, Unit> $onGesture;
    final /* synthetic */ boolean $panZoomLock;
    float F$0;
    float F$1;
    float F$2;
    int I$0;
    int I$1;
    long J$0;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TransformGestureDetectorKt$detectTransformGestures$2(boolean z, Function4<? super Offset, ? super Offset, ? super Float, ? super Float, Unit> function4, Continuation<? super TransformGestureDetectorKt$detectTransformGestures$2> continuation) {
        super(2, continuation);
        this.$panZoomLock = z;
        this.$onGesture = function4;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> transformGestureDetectorKt$detectTransformGestures$2 = new TransformGestureDetectorKt$detectTransformGestures$2(this.$panZoomLock, this.$onGesture, continuation);
        transformGestureDetectorKt$detectTransformGestures$2.L$0 = obj;
        return transformGestureDetectorKt$detectTransformGestures$2;
    }

    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return create(awaitPointerEventScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0153, code lost:
    
        if (androidx.compose.p002ui.geometry.Offset.m4590equalsimpl0(r6, androidx.compose.p002ui.geometry.Offset.INSTANCE.m4609getZeroF1C5BW0()) != false) goto L61;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00c8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00b7  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x00a3 -> B:6:0x00a6). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        AwaitPointerEventScope awaitPointerEventScope;
        float f;
        float f2;
        float f3;
        int i;
        int i2;
        long j;
        TransformGestureDetectorKt$detectTransformGestures$2 transformGestureDetectorKt$detectTransformGestures$2;
        Object awaitPointerEvent$default;
        int size;
        int i3;
        int i4;
        Object obj2;
        boolean z;
        boolean z2;
        boolean z3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        int i6 = 2;
        int i7 = 0;
        int i8 = 1;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
            long m4609getZeroF1C5BW0 = Offset.INSTANCE.m4609getZeroF1C5BW0();
            float touchSlop = awaitPointerEventScope.getViewConfiguration().getTouchSlop();
            this.L$0 = awaitPointerEventScope;
            this.F$0 = 0.0f;
            this.F$1 = 1.0f;
            this.J$0 = m4609getZeroF1C5BW0;
            this.I$0 = 0;
            this.F$2 = touchSlop;
            this.I$1 = 0;
            this.label = 1;
            if (TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope, false, null, (Continuation) this, 2, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
            f = touchSlop;
            f2 = 1.0f;
            f3 = 0.0f;
            i = 0;
            i2 = 0;
            j = m4609getZeroF1C5BW0;
        } else {
            if (i5 != 1) {
                if (i5 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i = this.I$1;
                f = this.F$2;
                i2 = this.I$0;
                j = this.J$0;
                f2 = this.F$1;
                f3 = this.F$0;
                awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                awaitPointerEvent$default = obj;
                transformGestureDetectorKt$detectTransformGestures$2 = this;
                PointerEvent pointerEvent = (PointerEvent) awaitPointerEvent$default;
                List<PointerInputChange> changes = pointerEvent.getChanges();
                size = changes.size();
                i3 = i7;
                while (true) {
                    if (i3 >= size) {
                        i4 = i7;
                        break;
                    }
                    if (changes.get(i3).isConsumed()) {
                        i4 = 1;
                        break;
                    }
                    i3++;
                }
                if (i4 == 0) {
                    float calculateZoom = TransformGestureDetectorKt.calculateZoom(pointerEvent);
                    float calculateRotation = TransformGestureDetectorKt.calculateRotation(pointerEvent);
                    long calculatePan = TransformGestureDetectorKt.calculatePan(pointerEvent);
                    if (i2 == 0) {
                        f2 *= calculateZoom;
                        f3 += calculateRotation;
                        j = Offset.m4598plusMKHz9U(j, calculatePan);
                        float calculateCentroidSize = TransformGestureDetectorKt.calculateCentroidSize(pointerEvent, false);
                        obj2 = coroutine_suspended;
                        z3 = true;
                        float abs = Math.abs(1 - f2) * calculateCentroidSize;
                        float abs2 = Math.abs(((3.1415927f * f3) * calculateCentroidSize) / 180.0f);
                        float m4591getDistanceimpl = Offset.m4591getDistanceimpl(j);
                        if (abs > f || abs2 > f || m4591getDistanceimpl > f) {
                            i = (!transformGestureDetectorKt$detectTransformGestures$2.$panZoomLock || abs2 >= f) ? 0 : 1;
                            i2 = 1;
                        }
                    } else {
                        obj2 = coroutine_suspended;
                        z3 = true;
                    }
                    if (i2 != 0) {
                        long calculateCentroid = TransformGestureDetectorKt.calculateCentroid(pointerEvent, false);
                        float f4 = i != 0 ? 0.0f : calculateRotation;
                        z = false;
                        if (f4 == 0.0f ? z3 : false) {
                            if (calculateZoom == 1.0f ? z3 : false) {
                            }
                        }
                        transformGestureDetectorKt$detectTransformGestures$2.$onGesture.invoke(Offset.m4582boximpl(calculateCentroid), Offset.m4582boximpl(calculatePan), Boxing.boxFloat(calculateZoom), Boxing.boxFloat(f4));
                        List<PointerInputChange> changes2 = pointerEvent.getChanges();
                        int size2 = changes2.size();
                        for (int i9 = 0; i9 < size2; i9++) {
                            PointerInputChange pointerInputChange = changes2.get(i9);
                            if (PointerEventKt.positionChanged(pointerInputChange)) {
                                pointerInputChange.consume();
                            }
                        }
                        if (i4 == 0) {
                            List<PointerInputChange> changes3 = pointerEvent.getChanges();
                            int size3 = changes3.size();
                            int i10 = 0;
                            while (true) {
                                if (i10 >= size3) {
                                    z2 = false;
                                    break;
                                }
                                if (changes3.get(i10).getPressed()) {
                                    z2 = true;
                                    break;
                                }
                                i10++;
                            }
                            if (z2) {
                                coroutine_suspended = obj2;
                                i6 = 2;
                                i7 = 0;
                                i8 = 1;
                                transformGestureDetectorKt$detectTransformGestures$2.L$0 = awaitPointerEventScope;
                                transformGestureDetectorKt$detectTransformGestures$2.F$0 = f3;
                                transformGestureDetectorKt$detectTransformGestures$2.F$1 = f2;
                                transformGestureDetectorKt$detectTransformGestures$2.J$0 = j;
                                transformGestureDetectorKt$detectTransformGestures$2.I$0 = i2;
                                transformGestureDetectorKt$detectTransformGestures$2.F$2 = f;
                                transformGestureDetectorKt$detectTransformGestures$2.I$1 = i;
                                transformGestureDetectorKt$detectTransformGestures$2.label = i6;
                                awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, (Continuation) transformGestureDetectorKt$detectTransformGestures$2, i8, null);
                                if (awaitPointerEvent$default == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                PointerEvent pointerEvent2 = (PointerEvent) awaitPointerEvent$default;
                                List<PointerInputChange> changes4 = pointerEvent2.getChanges();
                                size = changes4.size();
                                i3 = i7;
                                while (true) {
                                    if (i3 >= size) {
                                    }
                                    i3++;
                                }
                                if (i4 == 0) {
                                    obj2 = coroutine_suspended;
                                }
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }
                z = false;
                if (i4 == 0) {
                }
                return Unit.INSTANCE;
            }
            i = this.I$1;
            f = this.F$2;
            i2 = this.I$0;
            j = this.J$0;
            f2 = this.F$1;
            f3 = this.F$0;
            awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        transformGestureDetectorKt$detectTransformGestures$2 = this;
        transformGestureDetectorKt$detectTransformGestures$2.L$0 = awaitPointerEventScope;
        transformGestureDetectorKt$detectTransformGestures$2.F$0 = f3;
        transformGestureDetectorKt$detectTransformGestures$2.F$1 = f2;
        transformGestureDetectorKt$detectTransformGestures$2.J$0 = j;
        transformGestureDetectorKt$detectTransformGestures$2.I$0 = i2;
        transformGestureDetectorKt$detectTransformGestures$2.F$2 = f;
        transformGestureDetectorKt$detectTransformGestures$2.I$1 = i;
        transformGestureDetectorKt$detectTransformGestures$2.label = i6;
        awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, (Continuation) transformGestureDetectorKt$detectTransformGestures$2, i8, null);
        if (awaitPointerEvent$default == coroutine_suspended) {
        }
        PointerEvent pointerEvent22 = (PointerEvent) awaitPointerEvent$default;
        List<PointerInputChange> changes42 = pointerEvent22.getChanges();
        size = changes42.size();
        i3 = i7;
        while (true) {
            if (i3 >= size) {
            }
            i3++;
        }
        if (i4 == 0) {
        }
        z = false;
        if (i4 == 0) {
        }
        return Unit.INSTANCE;
    }
}
