package androidx.compose.foundation.gestures;

import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.text.input.internal.PartialGapBuffer;
import androidx.compose.p002ui.geometry.InlineClassHelperKt;
import androidx.compose.p002ui.geometry.Offset;
import androidx.compose.p002ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p002ui.input.pointer.PointerEvent;
import androidx.compose.p002ui.input.pointer.PointerEventKt;
import androidx.compose.p002ui.input.pointer.PointerEventPass;
import androidx.compose.p002ui.input.pointer.PointerId;
import androidx.compose.p002ui.input.pointer.PointerInputChange;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DragGestureDetector.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$13", f = "DragGestureDetector.kt", i = {0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7}, l = {249, PartialGapBuffer.BUF_SIZE, 1105, 1142, 282, 1181, 1219, 1231}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "initialDown", "awaitTouchSlop", "$this$awaitEachGesture", "down", "$this$awaitPointerSlopOrCancellation_u2d6ksA65w_u24default$iv", "pointer$iv", "touchSlopDetector$iv", "touchSlop$iv", "$this$awaitEachGesture", "down", "$this$awaitPointerSlopOrCancellation_u2d6ksA65w_u24default$iv", "pointer$iv", "touchSlopDetector$iv", "dragEvent$iv", "touchSlop$iv", "$this$awaitEachGesture", "down", "drag", "$this$awaitEachGesture", "down", "$this$awaitPointerSlopOrCancellation_u2d6ksA65w$iv", "pointer$iv", "touchSlopDetector$iv", "touchSlop$iv", "$this$awaitEachGesture", "down", "$this$awaitPointerSlopOrCancellation_u2d6ksA65w$iv", "pointer$iv", "touchSlopDetector$iv", "dragEvent$iv", "touchSlop$iv", "$this$drag_u2dVnAYq1g$iv", "orientation$iv", "$this$awaitDragOrUp_u2djO51t88$iv$iv", "pointer$iv$iv"}, s = {"L$0", "L$0", "L$1", "Z$0", "L$0", "L$1", "L$2", "L$4", "L$5", "F$0", "L$0", "L$1", "L$2", "L$4", "L$5", "L$6", "F$0", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$4", "L$5", "F$0", "L$0", "L$1", "L$2", "L$4", "L$5", "L$6", "F$0", "L$0", "L$2", "L$3", "L$4"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class DragGestureDetectorKt$detectDragGestures$13 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<PointerInputChange, Offset, Unit> $onDrag;
    final /* synthetic */ Function0<Unit> $onDragCancel;
    final /* synthetic */ Function1<PointerInputChange, Unit> $onDragEnd;
    final /* synthetic */ Function3<PointerInputChange, PointerInputChange, Offset, Unit> $onDragStart;
    final /* synthetic */ Orientation $orientationLock;
    final /* synthetic */ Ref.LongRef $overSlop;
    final /* synthetic */ Function0<Boolean> $shouldAwaitTouchSlop;
    float F$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    boolean Z$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DragGestureDetectorKt$detectDragGestures$13(Function0<Boolean> function0, Ref.LongRef longRef, Orientation orientation, Function3<? super PointerInputChange, ? super PointerInputChange, ? super Offset, Unit> function3, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Function0<Unit> function02, Function1<? super PointerInputChange, Unit> function1, Continuation<? super DragGestureDetectorKt$detectDragGestures$13> continuation) {
        super(2, continuation);
        this.$shouldAwaitTouchSlop = function0;
        this.$overSlop = longRef;
        this.$orientationLock = orientation;
        this.$onDragStart = function3;
        this.$onDrag = function2;
        this.$onDragCancel = function02;
        this.$onDragEnd = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> dragGestureDetectorKt$detectDragGestures$13 = new DragGestureDetectorKt$detectDragGestures$13(this.$shouldAwaitTouchSlop, this.$overSlop, this.$orientationLock, this.$onDragStart, this.$onDrag, this.$onDragCancel, this.$onDragEnd, continuation);
        dragGestureDetectorKt$detectDragGestures$13.L$0 = obj;
        return dragGestureDetectorKt$detectDragGestures$13;
    }

    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return create(awaitPointerEventScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x02c6, code lost:
    
        if (0 == 0) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x04d5, code lost:
    
        if (androidx.compose.foundation.gestures.DragGestureDetectorKt.m684isPointerUpDmW0f2w(r4.getCurrentEvent(), r5) != false) goto L229;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0595, code lost:
    
        if ((!(r7 == 0.0f)) != false) goto L227;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x02c4, code lost:
    
        if (r5 == false) goto L178;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0328, code lost:
    
        if (1 == 0) goto L113;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000b. Please report as an issue. */
    /* JADX WARN: Path cross not found for [B:35:0x053d, B:49:0x056d], limit reached: 250 */
    /* JADX WARN: Removed duplicated region for block: B:118:0x03b6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x03f4  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0401  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0437  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x03e8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0534  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0305 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x02c3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x04a5  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0493  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x01b8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:196:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x05ac  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x05b2  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x01ea A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0158 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x05a9  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x05b8  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0501 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0537  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x052e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x048e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x029e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0512  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:126:0x0494 -> B:103:0x0399). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:134:0x045f -> B:65:0x029a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:139:0x0486 -> B:62:0x0488). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:171:0x0184 -> B:165:0x0284). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:182:0x01f0 -> B:164:0x0282). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:184:0x01f8 -> B:164:0x0282). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:193:0x0224 -> B:164:0x0282). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:195:0x0294 -> B:173:0x019c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:203:0x0253 -> B:165:0x0284). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:208:0x0279 -> B:162:0x027c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x04ff -> B:7:0x0502). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        AwaitPointerEventScope awaitPointerEventScope;
        Object awaitFirstDown;
        AwaitPointerEventScope awaitPointerEventScope2;
        DefaultConstructorMarker defaultConstructorMarker;
        boolean booleanValue;
        Object awaitFirstDown$default;
        PointerInputChange pointerInputChange;
        DragGestureDetectorKt$detectDragGestures$13 dragGestureDetectorKt$detectDragGestures$13;
        Object obj2;
        Ref.LongRef longRef;
        Ref.LongRef longRef2;
        AwaitPointerEventScope awaitPointerEventScope3;
        TouchSlopDetector touchSlopDetector;
        float f;
        List<PointerInputChange> changes;
        int size;
        PointerInputChange pointerInputChange2;
        PointerInputChange pointerInputChange3;
        AwaitPointerEventScope awaitPointerEventScope4;
        float f2;
        DefaultConstructorMarker defaultConstructorMarker2;
        PointerInputChange pointerInputChange4;
        List<PointerInputChange> list;
        int i;
        Object obj3;
        TouchSlopDetector touchSlopDetector2;
        AwaitPointerEventScope awaitPointerEventScope5;
        float f3;
        Ref.LongRef longRef3;
        Ref.LongRef longRef4;
        List<PointerInputChange> changes2;
        int size2;
        int i2;
        PointerInputChange pointerInputChange5;
        PointerInputChange pointerInputChange6;
        PointerInputChange pointerInputChange7;
        DefaultConstructorMarker defaultConstructorMarker3;
        PointerInputChange pointerInputChange8;
        List<PointerInputChange> list2;
        int i3;
        boolean z;
        boolean z2;
        long id;
        Function2<PointerInputChange, Offset, Unit> function2;
        Orientation orientation;
        int size3;
        int i4;
        boolean z3;
        PointerInputChange pointerInputChange9;
        PointerInputChange pointerInputChange10;
        float intBitsToFloat;
        PointerInputChange pointerInputChange11;
        PointerInputChange pointerInputChange12;
        List<PointerInputChange> list3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = 0;
        int i6 = 1;
        DefaultConstructorMarker defaultConstructorMarker4 = null;
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                this.L$0 = awaitPointerEventScope;
                this.label = 1;
                awaitFirstDown = TapGestureDetectorKt.awaitFirstDown(awaitPointerEventScope, false, PointerEventPass.Initial, (Continuation) this);
                if (awaitFirstDown == coroutine_suspended) {
                    return coroutine_suspended;
                }
                awaitPointerEventScope2 = awaitPointerEventScope;
                defaultConstructorMarker = (PointerInputChange) awaitFirstDown;
                booleanValue = ((Boolean) this.$shouldAwaitTouchSlop.invoke()).booleanValue();
                if (!booleanValue) {
                    defaultConstructorMarker.consume();
                }
                this.L$0 = awaitPointerEventScope2;
                this.L$1 = defaultConstructorMarker;
                this.Z$0 = booleanValue;
                this.label = 2;
                awaitFirstDown$default = TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope2, false, null, (Continuation) this, 2, null);
                if (awaitFirstDown$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                pointerInputChange = (PointerInputChange) awaitFirstDown$default;
                this.$overSlop.element = Offset.INSTANCE.m4609getZeroF1C5BW0();
                if (!booleanValue) {
                    dragGestureDetectorKt$detectDragGestures$13 = this;
                    if (ComposeFoundationFlags.DragGesturePickUpEnabled) {
                        List<PointerInputChange> changes3 = awaitPointerEventScope2.getCurrentEvent().getChanges();
                        size3 = changes3.size();
                        i4 = 0;
                        while (true) {
                            if (i4 >= size3) {
                            }
                            i4++;
                        }
                    }
                    if (defaultConstructorMarker != null) {
                    }
                    return Unit.INSTANCE;
                }
                dragGestureDetectorKt$detectDragGestures$13 = this;
                long id2 = pointerInputChange.getId();
                int type = pointerInputChange.getType();
                Orientation orientation2 = dragGestureDetectorKt$detectDragGestures$13.$orientationLock;
                longRef2 = dragGestureDetectorKt$detectDragGestures$13.$overSlop;
                long m4609getZeroF1C5BW0 = Offset.INSTANCE.m4609getZeroF1C5BW0();
                if (DragGestureDetectorKt.m684isPointerUpDmW0f2w(awaitPointerEventScope2.getCurrentEvent(), id2)) {
                    defaultConstructorMarker = defaultConstructorMarker4;
                    if (defaultConstructorMarker != null && !defaultConstructorMarker.isConsumed()) {
                        i5 = 0;
                        i6 = 1;
                        defaultConstructorMarker4 = null;
                        long id22 = pointerInputChange.getId();
                        int type2 = pointerInputChange.getType();
                        Orientation orientation22 = dragGestureDetectorKt$detectDragGestures$13.$orientationLock;
                        longRef2 = dragGestureDetectorKt$detectDragGestures$13.$overSlop;
                        long m4609getZeroF1C5BW02 = Offset.INSTANCE.m4609getZeroF1C5BW0();
                        if (DragGestureDetectorKt.m684isPointerUpDmW0f2w(awaitPointerEventScope2.getCurrentEvent(), id22)) {
                            f = DragGestureDetectorKt.m685pointerSlopE8SPZFQ(awaitPointerEventScope2.getViewConfiguration(), type2);
                            longRef = new Ref.LongRef();
                            longRef.element = id22;
                            touchSlopDetector = new TouchSlopDetector(orientation22, m4609getZeroF1C5BW02, defaultConstructorMarker4);
                            awaitPointerEventScope3 = awaitPointerEventScope2;
                            dragGestureDetectorKt$detectDragGestures$13.L$0 = awaitPointerEventScope3;
                            dragGestureDetectorKt$detectDragGestures$13.L$1 = pointerInputChange;
                            dragGestureDetectorKt$detectDragGestures$13.L$2 = awaitPointerEventScope2;
                            dragGestureDetectorKt$detectDragGestures$13.L$3 = longRef2;
                            dragGestureDetectorKt$detectDragGestures$13.L$4 = longRef;
                            dragGestureDetectorKt$detectDragGestures$13.L$5 = touchSlopDetector;
                            dragGestureDetectorKt$detectDragGestures$13.L$6 = defaultConstructorMarker4;
                            dragGestureDetectorKt$detectDragGestures$13.F$0 = f;
                            dragGestureDetectorKt$detectDragGestures$13.label = 3;
                            obj2 = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, defaultConstructorMarker4, (Continuation) dragGestureDetectorKt$detectDragGestures$13, i6, defaultConstructorMarker4);
                            if (obj2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            PointerEvent pointerEvent = (PointerEvent) obj2;
                            changes = pointerEvent.getChanges();
                            size = changes.size();
                            while (true) {
                                if (i5 >= size) {
                                    pointerInputChange2 = changes.get(i5);
                                    list = changes;
                                    i = size;
                                    if (!PointerId.m6126equalsimpl0(pointerInputChange2.getId(), longRef.element)) {
                                        i5++;
                                        changes = list;
                                        size = i;
                                    }
                                } else {
                                    pointerInputChange2 = null;
                                }
                            }
                            pointerInputChange3 = pointerInputChange2;
                            if (pointerInputChange3 != null && !pointerInputChange3.isConsumed()) {
                                if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                                    long m809addPointerInputChangedBAh8RU = touchSlopDetector.m809addPointerInputChangedBAh8RU(pointerInputChange3, f);
                                    if ((m809addPointerInputChangedBAh8RU & 9223372034707292159L) != InlineClassHelperKt.UnspecifiedPackedFloats) {
                                        pointerInputChange3.consume();
                                        longRef2.element = m809addPointerInputChangedBAh8RU;
                                        if (pointerInputChange3.isConsumed()) {
                                            awaitPointerEventScope2 = awaitPointerEventScope3;
                                            defaultConstructorMarker = pointerInputChange3;
                                            if (defaultConstructorMarker != null) {
                                                i5 = 0;
                                                i6 = 1;
                                                defaultConstructorMarker4 = null;
                                                long id222 = pointerInputChange.getId();
                                                int type22 = pointerInputChange.getType();
                                                Orientation orientation222 = dragGestureDetectorKt$detectDragGestures$13.$orientationLock;
                                                longRef2 = dragGestureDetectorKt$detectDragGestures$13.$overSlop;
                                                long m4609getZeroF1C5BW022 = Offset.INSTANCE.m4609getZeroF1C5BW0();
                                                if (DragGestureDetectorKt.m684isPointerUpDmW0f2w(awaitPointerEventScope2.getCurrentEvent(), id222)) {
                                                }
                                            }
                                        } else {
                                            touchSlopDetector.reset();
                                        }
                                    } else {
                                        dragGestureDetectorKt$detectDragGestures$13.L$0 = awaitPointerEventScope3;
                                        dragGestureDetectorKt$detectDragGestures$13.L$1 = pointerInputChange;
                                        dragGestureDetectorKt$detectDragGestures$13.L$2 = awaitPointerEventScope2;
                                        dragGestureDetectorKt$detectDragGestures$13.L$3 = longRef2;
                                        dragGestureDetectorKt$detectDragGestures$13.L$4 = longRef;
                                        dragGestureDetectorKt$detectDragGestures$13.L$5 = touchSlopDetector;
                                        dragGestureDetectorKt$detectDragGestures$13.L$6 = pointerInputChange3;
                                        dragGestureDetectorKt$detectDragGestures$13.F$0 = f;
                                        dragGestureDetectorKt$detectDragGestures$13.label = 4;
                                        if (awaitPointerEventScope2.awaitPointerEvent(PointerEventPass.Final, (Continuation) dragGestureDetectorKt$detectDragGestures$13) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        awaitPointerEventScope4 = awaitPointerEventScope2;
                                        f2 = f;
                                        defaultConstructorMarker2 = pointerInputChange3;
                                        if (!defaultConstructorMarker2.isConsumed()) {
                                            f = f2;
                                            awaitPointerEventScope2 = awaitPointerEventScope4;
                                        }
                                    }
                                } else {
                                    List<PointerInputChange> changes4 = pointerEvent.getChanges();
                                    int size4 = changes4.size();
                                    int i7 = 0;
                                    while (true) {
                                        if (i7 < size4) {
                                            pointerInputChange4 = changes4.get(i7);
                                            if (!pointerInputChange4.getPressed()) {
                                                i7++;
                                            }
                                        } else {
                                            pointerInputChange4 = null;
                                        }
                                    }
                                    PointerInputChange pointerInputChange13 = pointerInputChange4;
                                    if (pointerInputChange13 != null) {
                                        longRef.element = pointerInputChange13.getId();
                                    }
                                }
                                i5 = 0;
                                i6 = 1;
                                defaultConstructorMarker4 = null;
                                dragGestureDetectorKt$detectDragGestures$13.L$0 = awaitPointerEventScope3;
                                dragGestureDetectorKt$detectDragGestures$13.L$1 = pointerInputChange;
                                dragGestureDetectorKt$detectDragGestures$13.L$2 = awaitPointerEventScope2;
                                dragGestureDetectorKt$detectDragGestures$13.L$3 = longRef2;
                                dragGestureDetectorKt$detectDragGestures$13.L$4 = longRef;
                                dragGestureDetectorKt$detectDragGestures$13.L$5 = touchSlopDetector;
                                dragGestureDetectorKt$detectDragGestures$13.L$6 = defaultConstructorMarker4;
                                dragGestureDetectorKt$detectDragGestures$13.F$0 = f;
                                dragGestureDetectorKt$detectDragGestures$13.label = 3;
                                obj2 = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, defaultConstructorMarker4, (Continuation) dragGestureDetectorKt$detectDragGestures$13, i6, defaultConstructorMarker4);
                                if (obj2 == coroutine_suspended) {
                                }
                                PointerEvent pointerEvent2 = (PointerEvent) obj2;
                                changes = pointerEvent2.getChanges();
                                size = changes.size();
                                while (true) {
                                    if (i5 >= size) {
                                    }
                                    i5++;
                                    changes = list;
                                    size = i;
                                }
                                pointerInputChange3 = pointerInputChange2;
                                if (pointerInputChange3 != null) {
                                    if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                                    }
                                    i5 = 0;
                                    i6 = 1;
                                    defaultConstructorMarker4 = null;
                                    dragGestureDetectorKt$detectDragGestures$13.L$0 = awaitPointerEventScope3;
                                    dragGestureDetectorKt$detectDragGestures$13.L$1 = pointerInputChange;
                                    dragGestureDetectorKt$detectDragGestures$13.L$2 = awaitPointerEventScope2;
                                    dragGestureDetectorKt$detectDragGestures$13.L$3 = longRef2;
                                    dragGestureDetectorKt$detectDragGestures$13.L$4 = longRef;
                                    dragGestureDetectorKt$detectDragGestures$13.L$5 = touchSlopDetector;
                                    dragGestureDetectorKt$detectDragGestures$13.L$6 = defaultConstructorMarker4;
                                    dragGestureDetectorKt$detectDragGestures$13.F$0 = f;
                                    dragGestureDetectorKt$detectDragGestures$13.label = 3;
                                    obj2 = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, defaultConstructorMarker4, (Continuation) dragGestureDetectorKt$detectDragGestures$13, i6, defaultConstructorMarker4);
                                    if (obj2 == coroutine_suspended) {
                                    }
                                    PointerEvent pointerEvent22 = (PointerEvent) obj2;
                                    changes = pointerEvent22.getChanges();
                                    size = changes.size();
                                    while (true) {
                                        if (i5 >= size) {
                                        }
                                        i5++;
                                        changes = list;
                                        size = i;
                                    }
                                    pointerInputChange3 = pointerInputChange2;
                                    if (pointerInputChange3 != null) {
                                    }
                                }
                            }
                            awaitPointerEventScope2 = awaitPointerEventScope3;
                            defaultConstructorMarker = null;
                            if (defaultConstructorMarker != null) {
                            }
                        }
                    }
                    if (ComposeFoundationFlags.DragGesturePickUpEnabled && defaultConstructorMarker == null) {
                        List<PointerInputChange> changes32 = awaitPointerEventScope2.getCurrentEvent().getChanges();
                        size3 = changes32.size();
                        i4 = 0;
                        while (true) {
                            if (i4 >= size3) {
                                z3 = false;
                                break;
                            } else if (changes32.get(i4).getPressed()) {
                                z3 = true;
                                break;
                            } else {
                                i4++;
                            }
                        }
                    }
                    if (defaultConstructorMarker != null) {
                        dragGestureDetectorKt$detectDragGestures$13.$onDragStart.invoke(pointerInputChange, defaultConstructorMarker, Offset.m4582boximpl(dragGestureDetectorKt$detectDragGestures$13.$overSlop.element));
                        dragGestureDetectorKt$detectDragGestures$13.$onDrag.invoke(defaultConstructorMarker, Offset.m4582boximpl(dragGestureDetectorKt$detectDragGestures$13.$overSlop.element));
                        id = defaultConstructorMarker.getId();
                        function2 = dragGestureDetectorKt$detectDragGestures$13.$onDrag;
                        orientation = ComposeFoundationFlags.DragGesturePickUpEnabled ? null : dragGestureDetectorKt$detectDragGestures$13.$orientationLock;
                        break;
                    }
                    return Unit.INSTANCE;
                }
            case 1:
                awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                awaitFirstDown = obj;
                awaitPointerEventScope2 = awaitPointerEventScope;
                defaultConstructorMarker = (PointerInputChange) awaitFirstDown;
                booleanValue = ((Boolean) this.$shouldAwaitTouchSlop.invoke()).booleanValue();
                if (!booleanValue) {
                }
                this.L$0 = awaitPointerEventScope2;
                this.L$1 = defaultConstructorMarker;
                this.Z$0 = booleanValue;
                this.label = 2;
                awaitFirstDown$default = TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope2, false, null, (Continuation) this, 2, null);
                if (awaitFirstDown$default == coroutine_suspended) {
                }
                pointerInputChange = (PointerInputChange) awaitFirstDown$default;
                this.$overSlop.element = Offset.INSTANCE.m4609getZeroF1C5BW0();
                if (!booleanValue) {
                }
                break;
            case 2:
                booleanValue = this.Z$0;
                defaultConstructorMarker = (PointerInputChange) this.L$1;
                awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                awaitFirstDown$default = obj;
                pointerInputChange = (PointerInputChange) awaitFirstDown$default;
                this.$overSlop.element = Offset.INSTANCE.m4609getZeroF1C5BW0();
                if (!booleanValue) {
                }
                break;
            case 3:
                float f4 = this.F$0;
                TouchSlopDetector touchSlopDetector3 = (TouchSlopDetector) this.L$5;
                Ref.LongRef longRef5 = (Ref.LongRef) this.L$4;
                Ref.LongRef longRef6 = (Ref.LongRef) this.L$3;
                AwaitPointerEventScope awaitPointerEventScope6 = (AwaitPointerEventScope) this.L$2;
                PointerInputChange pointerInputChange14 = (PointerInputChange) this.L$1;
                AwaitPointerEventScope awaitPointerEventScope7 = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                obj2 = obj;
                longRef = longRef5;
                longRef2 = longRef6;
                awaitPointerEventScope2 = awaitPointerEventScope6;
                pointerInputChange = pointerInputChange14;
                awaitPointerEventScope3 = awaitPointerEventScope7;
                touchSlopDetector = touchSlopDetector3;
                f = f4;
                dragGestureDetectorKt$detectDragGestures$13 = this;
                PointerEvent pointerEvent222 = (PointerEvent) obj2;
                changes = pointerEvent222.getChanges();
                size = changes.size();
                while (true) {
                    if (i5 >= size) {
                    }
                    i5++;
                    changes = list;
                    size = i;
                }
                pointerInputChange3 = pointerInputChange2;
                if (pointerInputChange3 != null) {
                }
                awaitPointerEventScope2 = awaitPointerEventScope3;
                defaultConstructorMarker = null;
                if (defaultConstructorMarker != null) {
                }
                if (ComposeFoundationFlags.DragGesturePickUpEnabled) {
                }
                if (defaultConstructorMarker != null) {
                }
                return Unit.INSTANCE;
            case 4:
                float f5 = this.F$0;
                defaultConstructorMarker2 = (PointerInputChange) this.L$6;
                TouchSlopDetector touchSlopDetector4 = (TouchSlopDetector) this.L$5;
                Ref.LongRef longRef7 = (Ref.LongRef) this.L$4;
                Ref.LongRef longRef8 = (Ref.LongRef) this.L$3;
                awaitPointerEventScope4 = (AwaitPointerEventScope) this.L$2;
                PointerInputChange pointerInputChange15 = (PointerInputChange) this.L$1;
                AwaitPointerEventScope awaitPointerEventScope8 = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                longRef = longRef7;
                pointerInputChange = pointerInputChange15;
                awaitPointerEventScope3 = awaitPointerEventScope8;
                longRef2 = longRef8;
                touchSlopDetector = touchSlopDetector4;
                f2 = f5;
                dragGestureDetectorKt$detectDragGestures$13 = this;
                if (!defaultConstructorMarker2.isConsumed()) {
                }
                awaitPointerEventScope2 = awaitPointerEventScope3;
                defaultConstructorMarker = null;
                if (defaultConstructorMarker != null) {
                }
                if (ComposeFoundationFlags.DragGesturePickUpEnabled) {
                }
                if (defaultConstructorMarker != null) {
                }
                return Unit.INSTANCE;
            case 5:
                DefaultConstructorMarker defaultConstructorMarker5 = (PointerInputChange) this.L$2;
                PointerInputChange pointerInputChange16 = (PointerInputChange) this.L$1;
                awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                Object obj4 = obj;
                pointerInputChange = pointerInputChange16;
                defaultConstructorMarker = defaultConstructorMarker5;
                dragGestureDetectorKt$detectDragGestures$13 = this;
                PointerEvent pointerEvent3 = (PointerEvent) obj4;
                List<PointerInputChange> changes5 = pointerEvent3.getChanges();
                int size5 = changes5.size();
                int i8 = 0;
                while (true) {
                    if (i8 >= size5) {
                        z = false;
                    } else if (changes5.get(i8).isConsumed()) {
                        z = true;
                    } else {
                        i8++;
                    }
                }
                if (z) {
                    List<PointerInputChange> changes6 = pointerEvent3.getChanges();
                    int size6 = changes6.size();
                    int i9 = 0;
                    while (true) {
                        if (i9 < size6) {
                            if (changes6.get(i9).getPressed()) {
                                break;
                            } else {
                                i9++;
                            }
                        } else {
                            break;
                        }
                    }
                    dragGestureDetectorKt$detectDragGestures$13.L$0 = awaitPointerEventScope2;
                    dragGestureDetectorKt$detectDragGestures$13.L$1 = pointerInputChange;
                    dragGestureDetectorKt$detectDragGestures$13.L$2 = defaultConstructorMarker;
                    dragGestureDetectorKt$detectDragGestures$13.L$3 = null;
                    dragGestureDetectorKt$detectDragGestures$13.L$4 = null;
                    dragGestureDetectorKt$detectDragGestures$13.L$5 = null;
                    dragGestureDetectorKt$detectDragGestures$13.L$6 = null;
                    dragGestureDetectorKt$detectDragGestures$13.label = 5;
                    obj4 = awaitPointerEventScope2.awaitPointerEvent(PointerEventPass.Final, (Continuation) dragGestureDetectorKt$detectDragGestures$13);
                    if (obj4 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    PointerEvent pointerEvent32 = (PointerEvent) obj4;
                    List<PointerInputChange> changes52 = pointerEvent32.getChanges();
                    int size52 = changes52.size();
                    int i82 = 0;
                    while (true) {
                        if (i82 >= size52) {
                        }
                        i82++;
                    }
                    if (z) {
                    }
                }
                List<PointerInputChange> changes7 = pointerEvent32.getChanges();
                int size7 = changes7.size();
                int i10 = 0;
                while (true) {
                    if (i10 >= size7) {
                        z2 = false;
                    } else if (changes7.get(i10).getPressed()) {
                        z2 = true;
                    } else {
                        i10++;
                    }
                }
                if (z2) {
                    PointerInputChange pointerInputChange17 = (PointerInputChange) CollectionsKt.firstOrNull(pointerEvent32.getChanges());
                    long m4597minusMKHz9U = Offset.m4597minusMKHz9U(pointerInputChange17 != null ? pointerInputChange17.getPosition() : Offset.INSTANCE.m4609getZeroF1C5BW0(), pointerInputChange.getPosition());
                    long id3 = pointerInputChange.getId();
                    int type3 = pointerInputChange.getType();
                    Orientation orientation3 = dragGestureDetectorKt$detectDragGestures$13.$orientationLock;
                    longRef4 = dragGestureDetectorKt$detectDragGestures$13.$overSlop;
                    if (!DragGestureDetectorKt.m684isPointerUpDmW0f2w(awaitPointerEventScope2.getCurrentEvent(), id3)) {
                        f3 = DragGestureDetectorKt.m685pointerSlopE8SPZFQ(awaitPointerEventScope2.getViewConfiguration(), type3);
                        longRef3 = new Ref.LongRef();
                        longRef3.element = id3;
                        PointerEventPass pointerEventPass = null;
                        touchSlopDetector2 = new TouchSlopDetector(orientation3, m4597minusMKHz9U, null);
                        awaitPointerEventScope5 = awaitPointerEventScope2;
                        dragGestureDetectorKt$detectDragGestures$13.L$0 = awaitPointerEventScope5;
                        dragGestureDetectorKt$detectDragGestures$13.L$1 = pointerInputChange;
                        dragGestureDetectorKt$detectDragGestures$13.L$2 = awaitPointerEventScope2;
                        dragGestureDetectorKt$detectDragGestures$13.L$3 = longRef4;
                        dragGestureDetectorKt$detectDragGestures$13.L$4 = longRef3;
                        dragGestureDetectorKt$detectDragGestures$13.L$5 = touchSlopDetector2;
                        dragGestureDetectorKt$detectDragGestures$13.L$6 = pointerEventPass;
                        dragGestureDetectorKt$detectDragGestures$13.F$0 = f3;
                        dragGestureDetectorKt$detectDragGestures$13.label = 6;
                        obj3 = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass, (Continuation) dragGestureDetectorKt$detectDragGestures$13, 1, pointerEventPass);
                        if (obj3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        PointerEvent pointerEvent4 = (PointerEvent) obj3;
                        changes2 = pointerEvent4.getChanges();
                        size2 = changes2.size();
                        i2 = 0;
                        while (true) {
                            if (i2 >= size2) {
                                PointerInputChange pointerInputChange18 = changes2.get(i2);
                                list2 = changes2;
                                i3 = size2;
                                pointerInputChange5 = pointerInputChange18;
                                if (!PointerId.m6126equalsimpl0(pointerInputChange18.getId(), longRef3.element)) {
                                    i2++;
                                    changes2 = list2;
                                    size2 = i3;
                                }
                            } else {
                                pointerInputChange5 = null;
                            }
                        }
                        pointerInputChange6 = pointerInputChange5;
                        if (pointerInputChange6 != null && !pointerInputChange6.isConsumed()) {
                            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange6)) {
                                List<PointerInputChange> changes8 = pointerEvent4.getChanges();
                                int size8 = changes8.size();
                                int i11 = 0;
                                while (true) {
                                    if (i11 < size8) {
                                        pointerInputChange8 = changes8.get(i11);
                                        if (!pointerInputChange8.getPressed()) {
                                            i11++;
                                        }
                                    } else {
                                        pointerInputChange8 = null;
                                    }
                                }
                                PointerInputChange pointerInputChange19 = pointerInputChange8;
                                if (pointerInputChange19 != null) {
                                    longRef3.element = pointerInputChange19.getId();
                                }
                            } else {
                                if ((touchSlopDetector2.m809addPointerInputChangedBAh8RU(pointerInputChange6, f3) & 9223372034707292159L) != InlineClassHelperKt.UnspecifiedPackedFloats) {
                                    pointerInputChange6.consume();
                                    longRef4.element = PointerEventKt.positionChange(pointerInputChange6);
                                    if (pointerInputChange6.isConsumed()) {
                                        awaitPointerEventScope2 = awaitPointerEventScope5;
                                        defaultConstructorMarker = pointerInputChange6;
                                        if (ComposeFoundationFlags.DragGesturePickUpEnabled) {
                                        }
                                        if (defaultConstructorMarker != null) {
                                        }
                                        return Unit.INSTANCE;
                                    }
                                    touchSlopDetector2.reset();
                                } else {
                                    dragGestureDetectorKt$detectDragGestures$13.L$0 = awaitPointerEventScope5;
                                    dragGestureDetectorKt$detectDragGestures$13.L$1 = pointerInputChange;
                                    dragGestureDetectorKt$detectDragGestures$13.L$2 = awaitPointerEventScope2;
                                    dragGestureDetectorKt$detectDragGestures$13.L$3 = longRef4;
                                    dragGestureDetectorKt$detectDragGestures$13.L$4 = longRef3;
                                    dragGestureDetectorKt$detectDragGestures$13.L$5 = touchSlopDetector2;
                                    dragGestureDetectorKt$detectDragGestures$13.L$6 = pointerInputChange6;
                                    dragGestureDetectorKt$detectDragGestures$13.F$0 = f3;
                                    dragGestureDetectorKt$detectDragGestures$13.label = 7;
                                    if (awaitPointerEventScope2.awaitPointerEvent(PointerEventPass.Final, (Continuation) dragGestureDetectorKt$detectDragGestures$13) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    pointerInputChange7 = pointerInputChange;
                                    defaultConstructorMarker3 = pointerInputChange6;
                                    if (!defaultConstructorMarker3.isConsumed()) {
                                        awaitPointerEventScope2 = awaitPointerEventScope5;
                                        pointerInputChange = pointerInputChange7;
                                        defaultConstructorMarker = null;
                                        if (ComposeFoundationFlags.DragGesturePickUpEnabled) {
                                        }
                                        if (defaultConstructorMarker != null) {
                                        }
                                        return Unit.INSTANCE;
                                    }
                                    pointerInputChange = pointerInputChange7;
                                }
                            }
                            pointerEventPass = null;
                            dragGestureDetectorKt$detectDragGestures$13.L$0 = awaitPointerEventScope5;
                            dragGestureDetectorKt$detectDragGestures$13.L$1 = pointerInputChange;
                            dragGestureDetectorKt$detectDragGestures$13.L$2 = awaitPointerEventScope2;
                            dragGestureDetectorKt$detectDragGestures$13.L$3 = longRef4;
                            dragGestureDetectorKt$detectDragGestures$13.L$4 = longRef3;
                            dragGestureDetectorKt$detectDragGestures$13.L$5 = touchSlopDetector2;
                            dragGestureDetectorKt$detectDragGestures$13.L$6 = pointerEventPass;
                            dragGestureDetectorKt$detectDragGestures$13.F$0 = f3;
                            dragGestureDetectorKt$detectDragGestures$13.label = 6;
                            obj3 = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass, (Continuation) dragGestureDetectorKt$detectDragGestures$13, 1, pointerEventPass);
                            if (obj3 == coroutine_suspended) {
                            }
                            PointerEvent pointerEvent42 = (PointerEvent) obj3;
                            changes2 = pointerEvent42.getChanges();
                            size2 = changes2.size();
                            i2 = 0;
                            while (true) {
                                if (i2 >= size2) {
                                }
                                i2++;
                                changes2 = list2;
                                size2 = i3;
                            }
                            pointerInputChange6 = pointerInputChange5;
                            if (pointerInputChange6 != null) {
                                if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange6)) {
                                }
                                pointerEventPass = null;
                                dragGestureDetectorKt$detectDragGestures$13.L$0 = awaitPointerEventScope5;
                                dragGestureDetectorKt$detectDragGestures$13.L$1 = pointerInputChange;
                                dragGestureDetectorKt$detectDragGestures$13.L$2 = awaitPointerEventScope2;
                                dragGestureDetectorKt$detectDragGestures$13.L$3 = longRef4;
                                dragGestureDetectorKt$detectDragGestures$13.L$4 = longRef3;
                                dragGestureDetectorKt$detectDragGestures$13.L$5 = touchSlopDetector2;
                                dragGestureDetectorKt$detectDragGestures$13.L$6 = pointerEventPass;
                                dragGestureDetectorKt$detectDragGestures$13.F$0 = f3;
                                dragGestureDetectorKt$detectDragGestures$13.label = 6;
                                obj3 = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, pointerEventPass, (Continuation) dragGestureDetectorKt$detectDragGestures$13, 1, pointerEventPass);
                                if (obj3 == coroutine_suspended) {
                                }
                                PointerEvent pointerEvent422 = (PointerEvent) obj3;
                                changes2 = pointerEvent422.getChanges();
                                size2 = changes2.size();
                                i2 = 0;
                                while (true) {
                                    if (i2 >= size2) {
                                    }
                                    i2++;
                                    changes2 = list2;
                                    size2 = i3;
                                }
                                pointerInputChange6 = pointerInputChange5;
                                if (pointerInputChange6 != null) {
                                }
                            }
                        }
                        awaitPointerEventScope2 = awaitPointerEventScope5;
                    }
                    defaultConstructorMarker = null;
                }
                if (ComposeFoundationFlags.DragGesturePickUpEnabled) {
                }
                if (defaultConstructorMarker != null) {
                }
                return Unit.INSTANCE;
            case 6:
                float f6 = this.F$0;
                TouchSlopDetector touchSlopDetector5 = (TouchSlopDetector) this.L$5;
                Ref.LongRef longRef9 = (Ref.LongRef) this.L$4;
                Ref.LongRef longRef10 = (Ref.LongRef) this.L$3;
                AwaitPointerEventScope awaitPointerEventScope9 = (AwaitPointerEventScope) this.L$2;
                PointerInputChange pointerInputChange20 = (PointerInputChange) this.L$1;
                AwaitPointerEventScope awaitPointerEventScope10 = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                obj3 = obj;
                touchSlopDetector2 = touchSlopDetector5;
                awaitPointerEventScope5 = awaitPointerEventScope10;
                f3 = f6;
                dragGestureDetectorKt$detectDragGestures$13 = this;
                longRef3 = longRef9;
                awaitPointerEventScope2 = awaitPointerEventScope9;
                longRef4 = longRef10;
                pointerInputChange = pointerInputChange20;
                PointerEvent pointerEvent4222 = (PointerEvent) obj3;
                changes2 = pointerEvent4222.getChanges();
                size2 = changes2.size();
                i2 = 0;
                while (true) {
                    if (i2 >= size2) {
                    }
                    i2++;
                    changes2 = list2;
                    size2 = i3;
                }
                pointerInputChange6 = pointerInputChange5;
                if (pointerInputChange6 != null) {
                }
                awaitPointerEventScope2 = awaitPointerEventScope5;
                defaultConstructorMarker = null;
                if (ComposeFoundationFlags.DragGesturePickUpEnabled) {
                }
                if (defaultConstructorMarker != null) {
                }
                return Unit.INSTANCE;
            case 7:
                float f7 = this.F$0;
                defaultConstructorMarker3 = (PointerInputChange) this.L$6;
                TouchSlopDetector touchSlopDetector6 = (TouchSlopDetector) this.L$5;
                longRef3 = (Ref.LongRef) this.L$4;
                Ref.LongRef longRef11 = (Ref.LongRef) this.L$3;
                AwaitPointerEventScope awaitPointerEventScope11 = (AwaitPointerEventScope) this.L$2;
                PointerInputChange pointerInputChange21 = (PointerInputChange) this.L$1;
                AwaitPointerEventScope awaitPointerEventScope12 = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                awaitPointerEventScope5 = awaitPointerEventScope12;
                touchSlopDetector2 = touchSlopDetector6;
                longRef4 = longRef11;
                awaitPointerEventScope2 = awaitPointerEventScope11;
                pointerInputChange7 = pointerInputChange21;
                f3 = f7;
                dragGestureDetectorKt$detectDragGestures$13 = this;
                if (!defaultConstructorMarker3.isConsumed()) {
                }
                break;
            case 8:
                Ref.LongRef longRef12 = (Ref.LongRef) this.L$4;
                AwaitPointerEventScope awaitPointerEventScope13 = (AwaitPointerEventScope) this.L$3;
                Orientation orientation4 = (Orientation) this.L$2;
                Function2<PointerInputChange, Offset, Unit> function22 = (Function2) this.L$1;
                AwaitPointerEventScope awaitPointerEventScope14 = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                Object awaitPointerEvent$default = obj;
                Ref.LongRef longRef13 = longRef12;
                dragGestureDetectorKt$detectDragGestures$13 = this;
                PointerEvent pointerEvent5 = (PointerEvent) awaitPointerEvent$default;
                List<PointerInputChange> changes9 = pointerEvent5.getChanges();
                int size9 = changes9.size();
                int i12 = 0;
                while (true) {
                    if (i12 < size9) {
                        pointerInputChange10 = changes9.get(i12);
                        list3 = changes9;
                        if (!PointerId.m6126equalsimpl0(pointerInputChange10.getId(), longRef13.element)) {
                            i12++;
                            changes9 = list3;
                        }
                    } else {
                        pointerInputChange10 = null;
                    }
                }
                PointerInputChange pointerInputChange22 = pointerInputChange10;
                if (pointerInputChange22 == null) {
                    if (!PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange22)) {
                        long positionChangeIgnoreConsumed = PointerEventKt.positionChangeIgnoreConsumed(pointerInputChange22);
                        if (orientation4 != null) {
                            intBitsToFloat = Float.intBitsToFloat((int) (orientation4 == Orientation.Vertical ? positionChangeIgnoreConsumed & 4294967295L : positionChangeIgnoreConsumed >> 32));
                        } else {
                            intBitsToFloat = Offset.m4591getDistanceimpl(positionChangeIgnoreConsumed);
                        }
                        break;
                    } else {
                        List<PointerInputChange> changes10 = pointerEvent5.getChanges();
                        int size10 = changes10.size();
                        int i13 = 0;
                        while (true) {
                            if (i13 < size10) {
                                PointerInputChange pointerInputChange23 = changes10.get(i13);
                                if (pointerInputChange23.getPressed()) {
                                    pointerInputChange12 = pointerInputChange23;
                                } else {
                                    i13++;
                                }
                            } else {
                                pointerInputChange12 = null;
                            }
                        }
                        PointerInputChange pointerInputChange24 = pointerInputChange12;
                        if (pointerInputChange24 == null) {
                            pointerInputChange11 = pointerInputChange22;
                        } else {
                            longRef13.element = pointerInputChange24.getId();
                            dragGestureDetectorKt$detectDragGestures$13.L$0 = awaitPointerEventScope14;
                            dragGestureDetectorKt$detectDragGestures$13.L$1 = function22;
                            dragGestureDetectorKt$detectDragGestures$13.L$2 = orientation4;
                            dragGestureDetectorKt$detectDragGestures$13.L$3 = awaitPointerEventScope13;
                            dragGestureDetectorKt$detectDragGestures$13.L$4 = longRef13;
                            dragGestureDetectorKt$detectDragGestures$13.L$5 = null;
                            dragGestureDetectorKt$detectDragGestures$13.L$6 = null;
                            dragGestureDetectorKt$detectDragGestures$13.label = 8;
                            awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope13, null, (Continuation) dragGestureDetectorKt$detectDragGestures$13, 1, null);
                            if (awaitPointerEvent$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            PointerEvent pointerEvent52 = (PointerEvent) awaitPointerEvent$default;
                            List<PointerInputChange> changes92 = pointerEvent52.getChanges();
                            int size92 = changes92.size();
                            int i122 = 0;
                            while (true) {
                                if (i122 < size92) {
                                }
                                i122++;
                                changes92 = list3;
                            }
                            PointerInputChange pointerInputChange222 = pointerInputChange10;
                            if (pointerInputChange222 == null) {
                                pointerInputChange11 = null;
                            }
                        }
                    }
                }
                if (pointerInputChange11 != null && !pointerInputChange11.isConsumed()) {
                    if (!PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange11)) {
                        pointerInputChange9 = pointerInputChange11;
                        if (pointerInputChange9 != null) {
                            dragGestureDetectorKt$detectDragGestures$13.$onDragCancel.invoke();
                        } else {
                            dragGestureDetectorKt$detectDragGestures$13.$onDragEnd.invoke(pointerInputChange9);
                        }
                        return Unit.INSTANCE;
                    }
                    function22.invoke(pointerInputChange11, Offset.m4582boximpl(PointerEventKt.positionChange(pointerInputChange11)));
                    pointerInputChange11.consume();
                    long id4 = pointerInputChange11.getId();
                    function2 = function22;
                    orientation = orientation4;
                    awaitPointerEventScope2 = awaitPointerEventScope14;
                    id = id4;
                    longRef13 = new Ref.LongRef();
                    longRef13.element = id;
                    function22 = function2;
                    awaitPointerEventScope13 = awaitPointerEventScope2;
                    awaitPointerEventScope14 = awaitPointerEventScope13;
                    orientation4 = orientation;
                    dragGestureDetectorKt$detectDragGestures$13.L$0 = awaitPointerEventScope14;
                    dragGestureDetectorKt$detectDragGestures$13.L$1 = function22;
                    dragGestureDetectorKt$detectDragGestures$13.L$2 = orientation4;
                    dragGestureDetectorKt$detectDragGestures$13.L$3 = awaitPointerEventScope13;
                    dragGestureDetectorKt$detectDragGestures$13.L$4 = longRef13;
                    dragGestureDetectorKt$detectDragGestures$13.L$5 = null;
                    dragGestureDetectorKt$detectDragGestures$13.L$6 = null;
                    dragGestureDetectorKt$detectDragGestures$13.label = 8;
                    awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope13, null, (Continuation) dragGestureDetectorKt$detectDragGestures$13, 1, null);
                    if (awaitPointerEvent$default == coroutine_suspended) {
                    }
                    PointerEvent pointerEvent522 = (PointerEvent) awaitPointerEvent$default;
                    List<PointerInputChange> changes922 = pointerEvent522.getChanges();
                    int size922 = changes922.size();
                    int i1222 = 0;
                    while (true) {
                        if (i1222 < size922) {
                        }
                        i1222++;
                        changes922 = list3;
                    }
                    PointerInputChange pointerInputChange2222 = pointerInputChange10;
                    if (pointerInputChange2222 == null) {
                    }
                    if (pointerInputChange11 != null) {
                        if (!PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange11)) {
                        }
                    }
                }
                pointerInputChange9 = null;
                if (pointerInputChange9 != null) {
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
