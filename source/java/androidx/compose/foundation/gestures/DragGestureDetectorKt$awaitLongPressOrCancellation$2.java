package androidx.compose.foundation.gestures;

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
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DragGestureDetector.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$2", f = "DragGestureDetector.kt", i = {0, 0, 1, 1, 1}, l = {1015, 1037}, m = "invokeSuspend", n = {"$this$withTimeout", "finished", "$this$withTimeout", "event", "finished"}, s = {"L$0", "I$0", "L$0", "L$1", "I$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class DragGestureDetectorKt$awaitLongPressOrCancellation$2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<PointerInputChange> $currentDown;
    final /* synthetic */ Ref.BooleanRef $deepPress;
    final /* synthetic */ Ref.ObjectRef<PointerInputChange> $longPress;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DragGestureDetectorKt$awaitLongPressOrCancellation$2(Ref.BooleanRef booleanRef, Ref.ObjectRef<PointerInputChange> objectRef, Ref.ObjectRef<PointerInputChange> objectRef2, Continuation<? super DragGestureDetectorKt$awaitLongPressOrCancellation$2> continuation) {
        super(2, continuation);
        this.$deepPress = booleanRef;
        this.$currentDown = objectRef;
        this.$longPress = objectRef2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> dragGestureDetectorKt$awaitLongPressOrCancellation$2 = new DragGestureDetectorKt$awaitLongPressOrCancellation$2(this.$deepPress, this.$currentDown, this.$longPress, continuation);
        dragGestureDetectorKt$awaitLongPressOrCancellation$2.L$0 = obj;
        return dragGestureDetectorKt$awaitLongPressOrCancellation$2;
    }

    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return create(awaitPointerEventScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00d9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x007f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00fd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00ec  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x00da -> B:6:0x00dc). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        DragGestureDetectorKt$awaitLongPressOrCancellation$2 dragGestureDetectorKt$awaitLongPressOrCancellation$2;
        AwaitPointerEventScope awaitPointerEventScope;
        int i;
        Object obj2;
        AwaitPointerEventScope awaitPointerEventScope2;
        DragGestureDetectorKt$awaitLongPressOrCancellation$2 dragGestureDetectorKt$awaitLongPressOrCancellation$22;
        PointerEvent pointerEvent;
        int size;
        int i2;
        boolean z;
        int size2;
        int i3;
        boolean z2;
        Object awaitPointerEvent;
        boolean z3;
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.label;
        Object obj3 = null;
        boolean z4 = true;
        z4 = true;
        z4 = true;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            dragGestureDetectorKt$awaitLongPressOrCancellation$2 = this;
            awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
            i = 0;
            if (i == 0) {
            }
        } else if (i4 == 1) {
            i = this.I$0;
            AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            obj2 = obj;
            awaitPointerEventScope2 = awaitPointerEventScope3;
            dragGestureDetectorKt$awaitLongPressOrCancellation$22 = this;
            pointerEvent = (PointerEvent) obj2;
            List<PointerInputChange> changes = pointerEvent.getChanges();
            size = changes.size();
            i2 = 0;
            while (true) {
                if (i2 >= size) {
                }
                i2++;
            }
            if (z) {
            }
            List<PointerInputChange> changes2 = pointerEvent.getChanges();
            size2 = changes2.size();
            i3 = 0;
            while (true) {
                if (i3 < size2) {
                }
                i3++;
            }
            if (z2) {
            }
            if (TapGestureDetector_androidKt.isDeepPress(pointerEvent)) {
            }
            dragGestureDetectorKt$awaitLongPressOrCancellation$22.L$0 = awaitPointerEventScope2;
            dragGestureDetectorKt$awaitLongPressOrCancellation$22.L$1 = pointerEvent;
            dragGestureDetectorKt$awaitLongPressOrCancellation$22.I$0 = i;
            dragGestureDetectorKt$awaitLongPressOrCancellation$22.label = 2;
            awaitPointerEvent = awaitPointerEventScope2.awaitPointerEvent(PointerEventPass.Final, (Continuation) dragGestureDetectorKt$awaitLongPressOrCancellation$22);
            if (awaitPointerEvent != coroutine_suspended) {
            }
        } else {
            if (i4 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = this.I$0;
            PointerEvent pointerEvent2 = (PointerEvent) this.L$1;
            awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            awaitPointerEvent = obj;
            DragGestureDetectorKt$awaitLongPressOrCancellation$2 dragGestureDetectorKt$awaitLongPressOrCancellation$23 = this;
            List<PointerInputChange> changes3 = ((PointerEvent) awaitPointerEvent).getChanges();
            int size3 = changes3.size();
            int i5 = 0;
            while (true) {
                if (i5 >= size3) {
                    z3 = false;
                    break;
                }
                if (changes3.get(i5).isConsumed()) {
                    z3 = z4 ? 1 : 0;
                    break;
                }
                i5++;
            }
            if (z3) {
                i = z4 ? 1 : 0;
            }
            if (!DragGestureDetectorKt.m684isPointerUpDmW0f2w(pointerEvent2, ((PointerInputChange) dragGestureDetectorKt$awaitLongPressOrCancellation$23.$currentDown.element).getId())) {
                List<PointerInputChange> changes4 = pointerEvent2.getChanges();
                int size4 = changes4.size();
                int i6 = 0;
                while (true) {
                    if (i6 >= size4) {
                        pointerInputChange2 = null;
                        break;
                    }
                    pointerInputChange2 = changes4.get(i6);
                    if (pointerInputChange2.getPressed()) {
                        break;
                    }
                    i6++;
                }
                PointerInputChange pointerInputChange3 = pointerInputChange2;
                if (pointerInputChange3 != null) {
                    dragGestureDetectorKt$awaitLongPressOrCancellation$23.$currentDown.element = pointerInputChange3;
                    dragGestureDetectorKt$awaitLongPressOrCancellation$23.$longPress.element = dragGestureDetectorKt$awaitLongPressOrCancellation$23.$currentDown.element;
                } else {
                    i = z4 ? 1 : 0;
                    awaitPointerEventScope = awaitPointerEventScope2;
                    obj3 = null;
                    dragGestureDetectorKt$awaitLongPressOrCancellation$2 = dragGestureDetectorKt$awaitLongPressOrCancellation$23;
                    if (i == 0) {
                        dragGestureDetectorKt$awaitLongPressOrCancellation$2.L$0 = awaitPointerEventScope;
                        dragGestureDetectorKt$awaitLongPressOrCancellation$2.L$1 = obj3;
                        dragGestureDetectorKt$awaitLongPressOrCancellation$2.I$0 = i;
                        dragGestureDetectorKt$awaitLongPressOrCancellation$2.label = z4 ? 1 : 0;
                        obj2 = awaitPointerEventScope.awaitPointerEvent(PointerEventPass.Main, (Continuation) dragGestureDetectorKt$awaitLongPressOrCancellation$2);
                        if (obj2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        DragGestureDetectorKt$awaitLongPressOrCancellation$2 dragGestureDetectorKt$awaitLongPressOrCancellation$24 = dragGestureDetectorKt$awaitLongPressOrCancellation$2;
                        awaitPointerEventScope2 = awaitPointerEventScope;
                        dragGestureDetectorKt$awaitLongPressOrCancellation$22 = dragGestureDetectorKt$awaitLongPressOrCancellation$24;
                        pointerEvent = (PointerEvent) obj2;
                        List<PointerInputChange> changes5 = pointerEvent.getChanges();
                        size = changes5.size();
                        i2 = 0;
                        while (true) {
                            if (i2 >= size) {
                                z = z4 ? 1 : 0;
                                break;
                            }
                            if (!PointerEventKt.changedToUpIgnoreConsumed(changes5.get(i2))) {
                                z = false;
                                break;
                            }
                            i2++;
                        }
                        if (z) {
                            i = z4 ? 1 : 0;
                        }
                        List<PointerInputChange> changes22 = pointerEvent.getChanges();
                        size2 = changes22.size();
                        i3 = 0;
                        while (true) {
                            if (i3 < size2) {
                                z2 = false;
                                break;
                            }
                            PointerInputChange pointerInputChange4 = changes22.get(i3);
                            if ((pointerInputChange4.isConsumed() || PointerEventKt.m6087isOutOfBoundsjwHxaWs(pointerInputChange4, awaitPointerEventScope2.mo6048getSizeYbymL2g(), awaitPointerEventScope2.mo6047getExtendedTouchPaddingNHjbRc())) ? z4 ? 1 : 0 : false) {
                                z2 = z4 ? 1 : 0;
                                break;
                            }
                            i3++;
                        }
                        if (z2) {
                            i = z4 ? 1 : 0;
                        }
                        if (TapGestureDetector_androidKt.isDeepPress(pointerEvent)) {
                            dragGestureDetectorKt$awaitLongPressOrCancellation$22.$deepPress.element = z4;
                            i = z4 ? 1 : 0;
                        }
                        dragGestureDetectorKt$awaitLongPressOrCancellation$22.L$0 = awaitPointerEventScope2;
                        dragGestureDetectorKt$awaitLongPressOrCancellation$22.L$1 = pointerEvent;
                        dragGestureDetectorKt$awaitLongPressOrCancellation$22.I$0 = i;
                        dragGestureDetectorKt$awaitLongPressOrCancellation$22.label = 2;
                        awaitPointerEvent = awaitPointerEventScope2.awaitPointerEvent(PointerEventPass.Final, (Continuation) dragGestureDetectorKt$awaitLongPressOrCancellation$22);
                        if (awaitPointerEvent != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        dragGestureDetectorKt$awaitLongPressOrCancellation$23 = dragGestureDetectorKt$awaitLongPressOrCancellation$22;
                        pointerEvent2 = pointerEvent;
                        List<PointerInputChange> changes32 = ((PointerEvent) awaitPointerEvent).getChanges();
                        int size32 = changes32.size();
                        int i52 = 0;
                        while (true) {
                            if (i52 >= size32) {
                            }
                            i52++;
                        }
                        if (z3) {
                        }
                        if (!DragGestureDetectorKt.m684isPointerUpDmW0f2w(pointerEvent2, ((PointerInputChange) dragGestureDetectorKt$awaitLongPressOrCancellation$23.$currentDown.element).getId())) {
                            Ref.ObjectRef<PointerInputChange> objectRef = dragGestureDetectorKt$awaitLongPressOrCancellation$23.$longPress;
                            List<PointerInputChange> changes6 = pointerEvent2.getChanges();
                            Ref.ObjectRef<PointerInputChange> objectRef2 = dragGestureDetectorKt$awaitLongPressOrCancellation$23.$currentDown;
                            int size5 = changes6.size();
                            int i7 = 0;
                            while (true) {
                                if (i7 >= size5) {
                                    pointerInputChange = null;
                                    break;
                                }
                                pointerInputChange = changes6.get(i7);
                                List<PointerInputChange> list = changes6;
                                if (PointerId.m6126equalsimpl0(pointerInputChange.getId(), ((PointerInputChange) objectRef2.element).getId())) {
                                    break;
                                }
                                i7++;
                                changes6 = list;
                            }
                            objectRef.element = pointerInputChange;
                        }
                    } else {
                        return Unit.INSTANCE;
                    }
                }
            }
            awaitPointerEventScope = awaitPointerEventScope2;
            obj3 = null;
            z4 = true;
            dragGestureDetectorKt$awaitLongPressOrCancellation$2 = dragGestureDetectorKt$awaitLongPressOrCancellation$23;
            if (i == 0) {
            }
        }
    }
}
