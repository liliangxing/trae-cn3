package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.geometry.Offset;
import androidx.compose.p002ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p002ui.input.pointer.PointerEvent;
import androidx.compose.p002ui.input.pointer.PointerEventKt;
import androidx.compose.p002ui.input.pointer.PointerEventPass;
import androidx.compose.p002ui.input.pointer.PointerEvent_androidKt;
import androidx.compose.p002ui.input.pointer.PointerInputChange;
import androidx.compose.p002ui.input.pointer.PointerInputEventHandler;
import androidx.compose.p002ui.input.pointer.PointerInputScope;
import androidx.compose.p002ui.input.pointer.PointerType;
import androidx.compose.p002ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.platform.ViewConfiguration;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: SelectionGestures.kt */
@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a \u0010\u0002\u001a\u00020\u0003*\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0000\u001a\u001c\u0010\b\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a\"\u0010\r\u001a\u00020\u0007*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u0012\u001a*\u0010\u0013\u001a\u00020\u0007*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u0016\u001a\"\u0010\u0017\u001a\u00020\u0007*\u00020\u00182\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0080@¢\u0006\u0002\u0010\u0019\u001a\"\u0010\u001a\u001a\u00020\u0007*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u0012\u001a\"\u0010\u001c\u001a\u00020\u0007*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u0012\u001a*\u0010\u001d\u001a\u00020\u0007*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u0016\u001a\u0012\u0010\u001e\u001a\u00020\u0011*\u00020\u000eH\u0082@¢\u0006\u0002\u0010\u001f\u001a \u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010&\u001a\u00020\u0006*\u00020\u00118@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006("}, d2 = {"STATIC_KEY", "", "updateSelectionTouchMode", "Landroidx/compose/ui/Modifier;", "updateTouchMode", "Lkotlin/Function1;", "", "", "selectionGestureInput", "mouseSelectionObserver", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "textDragObserver", "Landroidx/compose/foundation/text/TextDragObserver;", "touchSelection", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "observer", "down", "Landroidx/compose/ui/input/pointer/PointerEvent;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/foundation/text/TextDragObserver;Landroidx/compose/ui/input/pointer/PointerEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mouseSelection", "clicksCounter", "Landroidx/compose/foundation/text/selection/ClicksCounter;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/foundation/text/selection/MouseSelectionObserver;Landroidx/compose/foundation/text/selection/ClicksCounter;Landroidx/compose/ui/input/pointer/PointerEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectionGesturePointerInputBtf2", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/foundation/text/selection/MouseSelectionObserver;Landroidx/compose/foundation/text/TextDragObserver;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "touchSelectionFirstPress", "downEvent", "touchSelectionSubsequentPress", "mouseSelectionBtf2", "awaitDown", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "distanceIsTolerable", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "change1", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "change2", "isPrecisePointer", "(Landroidx/compose/ui/input/pointer/PointerEvent;)Z", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class SelectionGesturesKt {
    private static final int STATIC_KEY = 8675309;

    public static final Modifier updateSelectionTouchMode(Modifier modifier, final Function1<? super Boolean, Unit> function1) {
        return SuspendingPointerInputFilterKt.pointerInput(modifier, Integer.valueOf(STATIC_KEY), new PointerInputEventHandler() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt$updateSelectionTouchMode$1

            /* compiled from: SelectionGestures.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionGesturesKt$updateSelectionTouchMode$1$1", f = "SelectionGestures.kt", i = {0}, l = {94}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope"}, s = {"L$0"})
            /* renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$updateSelectionTouchMode$1$1 */
            /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
            static final class C05221 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Function1<Boolean, Unit> $updateTouchMode;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C05221(Function1<? super Boolean, Unit> function1, Continuation<? super C05221> continuation) {
                    super(2, continuation);
                    this.$updateTouchMode = function1;
                }

                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    Continuation<Unit> c05221 = new C05221(this.$updateTouchMode, continuation);
                    c05221.L$0 = obj;
                    return c05221;
                }

                public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                    return create(awaitPointerEventScope, continuation).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0037  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0036 A[RETURN] */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0037 -> B:5:0x003c). Please report as a decompilation issue!!! */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object invokeSuspend(Object obj) {
                    AwaitPointerEventScope awaitPointerEventScope;
                    C05221 c05221;
                    Object awaitPointerEvent;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                        c05221 = this;
                        c05221.L$0 = awaitPointerEventScope;
                        c05221.label = 1;
                        awaitPointerEvent = awaitPointerEventScope.awaitPointerEvent(PointerEventPass.Initial, (Continuation) c05221);
                        if (awaitPointerEvent == coroutine_suspended) {
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        AwaitPointerEventScope awaitPointerEventScope3 = awaitPointerEventScope2;
                        Object obj2 = coroutine_suspended;
                        C05221 c052212 = this;
                        c052212.$updateTouchMode.invoke(Boxing.boxBoolean(!SelectionGesturesKt.isPrecisePointer((PointerEvent) obj)));
                        c05221 = c052212;
                        coroutine_suspended = obj2;
                        awaitPointerEventScope = awaitPointerEventScope3;
                        c05221.L$0 = awaitPointerEventScope;
                        c05221.label = 1;
                        awaitPointerEvent = awaitPointerEventScope.awaitPointerEvent(PointerEventPass.Initial, (Continuation) c05221);
                        if (awaitPointerEvent == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Object obj3 = coroutine_suspended;
                        c052212 = c05221;
                        obj = awaitPointerEvent;
                        awaitPointerEventScope3 = awaitPointerEventScope;
                        obj2 = obj3;
                        c052212.$updateTouchMode.invoke(Boxing.boxBoolean(!SelectionGesturesKt.isPrecisePointer((PointerEvent) obj)));
                        c05221 = c052212;
                        coroutine_suspended = obj2;
                        awaitPointerEventScope = awaitPointerEventScope3;
                        c05221.L$0 = awaitPointerEventScope;
                        c05221.label = 1;
                        awaitPointerEvent = awaitPointerEventScope.awaitPointerEvent(PointerEventPass.Initial, (Continuation) c05221);
                        if (awaitPointerEvent == coroutine_suspended) {
                        }
                    }
                }
            }

            @Override // androidx.compose.p002ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                Object awaitPointerEventScope = pointerInputScope.awaitPointerEventScope(new C05221(function1, null), continuation);
                return awaitPointerEventScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitPointerEventScope : Unit.INSTANCE;
            }
        });
    }

    public static final Modifier selectionGestureInput(Modifier modifier, final MouseSelectionObserver mouseSelectionObserver, final TextDragObserver textDragObserver) {
        return SuspendingPointerInputFilterKt.pointerInput(modifier, mouseSelectionObserver, textDragObserver, new PointerInputEventHandler() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt$selectionGestureInput$1

            /* compiled from: SelectionGestures.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionGesturesKt$selectionGestureInput$1$1", f = "SelectionGestures.kt", i = {0}, l = {107, 113, 115}, m = "invokeSuspend", n = {"$this$awaitEachGesture"}, s = {"L$0"})
            /* renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$selectionGestureInput$1$1 */
            /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
            static final class C05201 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ ClicksCounter $clicksCounter;
                final /* synthetic */ MouseSelectionObserver $mouseSelectionObserver;
                final /* synthetic */ TextDragObserver $textDragObserver;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C05201(MouseSelectionObserver mouseSelectionObserver, ClicksCounter clicksCounter, TextDragObserver textDragObserver, Continuation<? super C05201> continuation) {
                    super(2, continuation);
                    this.$mouseSelectionObserver = mouseSelectionObserver;
                    this.$clicksCounter = clicksCounter;
                    this.$textDragObserver = textDragObserver;
                }

                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    Continuation<Unit> c05201 = new C05201(this.$mouseSelectionObserver, this.$clicksCounter, this.$textDragObserver, continuation);
                    c05201.L$0 = obj;
                    return c05201;
                }

                public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                    return create(awaitPointerEventScope, continuation).invokeSuspend(Unit.INSTANCE);
                }

                public final Object invokeSuspend(Object obj) {
                    AwaitPointerEventScope awaitPointerEventScope;
                    Object obj2;
                    Object mouseSelection;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    boolean z = true;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                        this.L$0 = awaitPointerEventScope;
                        this.label = 1;
                        obj = SelectionGesturesKt.awaitDown(awaitPointerEventScope, (Continuation) this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            if (i != 2 && i != 3) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    PointerEvent pointerEvent = (PointerEvent) obj;
                    if (SelectionGesturesKt.isPrecisePointer(pointerEvent) && PointerEvent_androidKt.m6115isPrimaryPressedaHzCxE(pointerEvent.getButtons())) {
                        int size = pointerEvent.getChanges().size();
                        int i2 = 0;
                        while (true) {
                            if (i2 >= size) {
                                break;
                            }
                            if (!(!r5.get(i2).isConsumed())) {
                                z = false;
                                break;
                            }
                            i2++;
                        }
                        if (z) {
                            this.L$0 = null;
                            this.label = 2;
                            mouseSelection = SelectionGesturesKt.mouseSelection(awaitPointerEventScope, this.$mouseSelectionObserver, this.$clicksCounter, pointerEvent, (Continuation) this);
                            if (mouseSelection == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    if (!SelectionGesturesKt.isPrecisePointer(pointerEvent)) {
                        this.L$0 = null;
                        this.label = 3;
                        obj2 = SelectionGesturesKt.touchSelection(awaitPointerEventScope, this.$textDragObserver, pointerEvent, (Continuation) this);
                        if (obj2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // androidx.compose.p002ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                Object awaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new C05201(MouseSelectionObserver.this, new ClicksCounter(pointerInputScope.getViewConfiguration()), textDragObserver, null), continuation);
                return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00a7 A[Catch: CancellationException -> 0x00d5, TryCatch #0 {CancellationException -> 0x00d5, blocks: (B:12:0x0032, B:13:0x009f, B:15:0x00a7, B:17:0x00b9, B:19:0x00c5, B:21:0x00c8, B:24:0x00cb, B:28:0x00cf, B:32:0x004a, B:34:0x0071, B:36:0x0075, B:38:0x007f, B:42:0x0054), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00cf A[Catch: CancellationException -> 0x00d5, TRY_LEAVE, TryCatch #0 {CancellationException -> 0x00d5, blocks: (B:12:0x0032, B:13:0x009f, B:15:0x00a7, B:17:0x00b9, B:19:0x00c5, B:21:0x00c8, B:24:0x00cb, B:28:0x00cf, B:32:0x004a, B:34:0x0071, B:36:0x0075, B:38:0x007f, B:42:0x0054), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object touchSelection(AwaitPointerEventScope awaitPointerEventScope, final TextDragObserver textDragObserver, PointerEvent pointerEvent, Continuation<? super Unit> continuation) {
        SelectionGesturesKt$touchSelection$1 selectionGesturesKt$touchSelection$1;
        Object obj;
        Object coroutine_suspended;
        int i;
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        try {
            if (continuation instanceof SelectionGesturesKt$touchSelection$1) {
                selectionGesturesKt$touchSelection$1 = (SelectionGesturesKt$touchSelection$1) continuation;
                if ((selectionGesturesKt$touchSelection$1.label & Integer.MIN_VALUE) != 0) {
                    selectionGesturesKt$touchSelection$1.label -= Integer.MIN_VALUE;
                    obj = selectionGesturesKt$touchSelection$1.result;
                    coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = selectionGesturesKt$touchSelection$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        pointerInputChange = (PointerInputChange) CollectionsKt.first(pointerEvent.getChanges());
                        long id = pointerInputChange.getId();
                        selectionGesturesKt$touchSelection$1.L$0 = awaitPointerEventScope;
                        selectionGesturesKt$touchSelection$1.L$1 = textDragObserver;
                        selectionGesturesKt$touchSelection$1.L$2 = pointerInputChange;
                        selectionGesturesKt$touchSelection$1.label = 1;
                        obj = DragGestureDetectorKt.m672awaitLongPressOrCancellationrnUCldI(awaitPointerEventScope, id, selectionGesturesKt$touchSelection$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            textDragObserver = (TextDragObserver) selectionGesturesKt$touchSelection$1.L$1;
                            awaitPointerEventScope = (AwaitPointerEventScope) selectionGesturesKt$touchSelection$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            if (((Boolean) obj).booleanValue()) {
                                List<PointerInputChange> changes = awaitPointerEventScope.getCurrentEvent().getChanges();
                                int size = changes.size();
                                for (int i2 = 0; i2 < size; i2++) {
                                    PointerInputChange pointerInputChange3 = changes.get(i2);
                                    if (PointerEventKt.changedToUp(pointerInputChange3)) {
                                        pointerInputChange3.consume();
                                    }
                                }
                                textDragObserver.onStop();
                            } else {
                                textDragObserver.onCancel();
                            }
                            return Unit.INSTANCE;
                        }
                        PointerInputChange pointerInputChange4 = (PointerInputChange) selectionGesturesKt$touchSelection$1.L$2;
                        textDragObserver = (TextDragObserver) selectionGesturesKt$touchSelection$1.L$1;
                        AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) selectionGesturesKt$touchSelection$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        pointerInputChange = pointerInputChange4;
                        awaitPointerEventScope = awaitPointerEventScope2;
                    }
                    pointerInputChange2 = (PointerInputChange) obj;
                    if (pointerInputChange2 != null && distanceIsTolerable(awaitPointerEventScope.getViewConfiguration(), pointerInputChange, pointerInputChange2)) {
                        textDragObserver.mo1625onStartk4lQ0M(pointerInputChange2.getPosition());
                        long id2 = pointerInputChange2.getId();
                        Function1 function1 = new Function1() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt$$ExternalSyntheticLambda2
                            public final Object invoke(Object obj2) {
                                Unit unit;
                                unit = SelectionGesturesKt.touchSelection$lambda$0(TextDragObserver.this, (PointerInputChange) obj2);
                                return unit;
                            }
                        };
                        selectionGesturesKt$touchSelection$1.L$0 = awaitPointerEventScope;
                        selectionGesturesKt$touchSelection$1.L$1 = textDragObserver;
                        selectionGesturesKt$touchSelection$1.L$2 = null;
                        selectionGesturesKt$touchSelection$1.label = 2;
                        obj = DragGestureDetectorKt.m682dragjO51t88(awaitPointerEventScope, id2, function1, selectionGesturesKt$touchSelection$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (((Boolean) obj).booleanValue()) {
                        }
                    }
                    return Unit.INSTANCE;
                }
            }
            if (i != 0) {
            }
            pointerInputChange2 = (PointerInputChange) obj;
            if (pointerInputChange2 != null) {
                textDragObserver.mo1625onStartk4lQ0M(pointerInputChange2.getPosition());
                long id22 = pointerInputChange2.getId();
                Function1 function12 = new Function1() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj2) {
                        Unit unit;
                        unit = SelectionGesturesKt.touchSelection$lambda$0(TextDragObserver.this, (PointerInputChange) obj2);
                        return unit;
                    }
                };
                selectionGesturesKt$touchSelection$1.L$0 = awaitPointerEventScope;
                selectionGesturesKt$touchSelection$1.L$1 = textDragObserver;
                selectionGesturesKt$touchSelection$1.L$2 = null;
                selectionGesturesKt$touchSelection$1.label = 2;
                obj = DragGestureDetectorKt.m682dragjO51t88(awaitPointerEventScope, id22, function12, selectionGesturesKt$touchSelection$1);
                if (obj == coroutine_suspended) {
                }
                if (((Boolean) obj).booleanValue()) {
                }
            }
            return Unit.INSTANCE;
        } catch (CancellationException e) {
            textDragObserver.onCancel();
            throw e;
        }
        selectionGesturesKt$touchSelection$1 = new SelectionGesturesKt$touchSelection$1(continuation);
        obj = selectionGesturesKt$touchSelection$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = selectionGesturesKt$touchSelection$1.label;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit touchSelection$lambda$0(TextDragObserver textDragObserver, PointerInputChange pointerInputChange) {
        textDragObserver.mo1624onDragk4lQ0M(PointerEventKt.positionChange(pointerInputChange));
        pointerInputChange.consume();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object mouseSelection(AwaitPointerEventScope awaitPointerEventScope, final MouseSelectionObserver mouseSelectionObserver, ClicksCounter clicksCounter, PointerEvent pointerEvent, Continuation<? super Unit> continuation) {
        SelectionGesturesKt$mouseSelection$1 selectionGesturesKt$mouseSelection$1;
        int i;
        final SelectionAdjustment none;
        AwaitPointerEventScope awaitPointerEventScope2;
        Ref.BooleanRef booleanRef;
        int size;
        if (continuation instanceof SelectionGesturesKt$mouseSelection$1) {
            selectionGesturesKt$mouseSelection$1 = (SelectionGesturesKt$mouseSelection$1) continuation;
            if ((selectionGesturesKt$mouseSelection$1.label & Integer.MIN_VALUE) != 0) {
                selectionGesturesKt$mouseSelection$1.label -= Integer.MIN_VALUE;
                Object obj = selectionGesturesKt$mouseSelection$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = selectionGesturesKt$mouseSelection$1.label;
                int i2 = 0;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    clicksCounter.update(pointerEvent);
                    PointerInputChange pointerInputChange = pointerEvent.getChanges().get(0);
                    if (TextFieldSelectionManager_androidKt.isShiftPressed(pointerEvent)) {
                        if (mouseSelectionObserver.mo1964onExtendk4lQ0M(pointerInputChange.getPosition())) {
                            long id = pointerInputChange.getId();
                            Function1 function1 = new Function1() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj2) {
                                    Unit mouseSelection$lambda$2;
                                    mouseSelection$lambda$2 = SelectionGesturesKt.mouseSelection$lambda$2(MouseSelectionObserver.this, (PointerInputChange) obj2);
                                    return mouseSelection$lambda$2;
                                }
                            };
                            selectionGesturesKt$mouseSelection$1.L$0 = awaitPointerEventScope;
                            selectionGesturesKt$mouseSelection$1.L$1 = mouseSelectionObserver;
                            selectionGesturesKt$mouseSelection$1.label = 1;
                            obj = DragGestureDetectorKt.m682dragjO51t88(awaitPointerEventScope, id, function1, selectionGesturesKt$mouseSelection$1);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            if (((Boolean) obj).booleanValue()) {
                            }
                            mouseSelectionObserver.onDragDone();
                        }
                    } else {
                        int clicks = clicksCounter.getClicks();
                        if (clicks == 1) {
                            none = SelectionAdjustment.INSTANCE.getNone();
                        } else if (clicks == 2) {
                            none = SelectionAdjustment.INSTANCE.getWord();
                        } else {
                            none = SelectionAdjustment.INSTANCE.getParagraph();
                        }
                        if (mouseSelectionObserver.mo1966onStart9KIMszo(pointerInputChange.getPosition(), none, clicksCounter.getClicks())) {
                            final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
                            booleanRef2.element = !Intrinsics.areEqual(none, SelectionAdjustment.INSTANCE.getNone());
                            long id2 = pointerInputChange.getId();
                            Function1 function12 = new Function1() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt$$ExternalSyntheticLambda1
                                public final Object invoke(Object obj2) {
                                    Unit mouseSelection$lambda$4;
                                    mouseSelection$lambda$4 = SelectionGesturesKt.mouseSelection$lambda$4(MouseSelectionObserver.this, none, booleanRef2, (PointerInputChange) obj2);
                                    return mouseSelection$lambda$4;
                                }
                            };
                            selectionGesturesKt$mouseSelection$1.L$0 = awaitPointerEventScope;
                            selectionGesturesKt$mouseSelection$1.L$1 = mouseSelectionObserver;
                            selectionGesturesKt$mouseSelection$1.L$2 = booleanRef2;
                            selectionGesturesKt$mouseSelection$1.label = 2;
                            obj = DragGestureDetectorKt.m682dragjO51t88(awaitPointerEventScope, id2, function12, selectionGesturesKt$mouseSelection$1);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            awaitPointerEventScope2 = awaitPointerEventScope;
                            booleanRef = booleanRef2;
                            if (((Boolean) obj).booleanValue()) {
                                List<PointerInputChange> changes = awaitPointerEventScope2.getCurrentEvent().getChanges();
                                size = changes.size();
                                while (i2 < size) {
                                }
                            }
                            mouseSelectionObserver.onDragDone();
                        }
                    }
                } else if (i == 1) {
                    mouseSelectionObserver = (MouseSelectionObserver) selectionGesturesKt$mouseSelection$1.L$1;
                    awaitPointerEventScope = (AwaitPointerEventScope) selectionGesturesKt$mouseSelection$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    if (((Boolean) obj).booleanValue()) {
                        List<PointerInputChange> changes2 = awaitPointerEventScope.getCurrentEvent().getChanges();
                        int size2 = changes2.size();
                        while (i2 < size2) {
                            PointerInputChange pointerInputChange2 = changes2.get(i2);
                            if (PointerEventKt.changedToUp(pointerInputChange2)) {
                                pointerInputChange2.consume();
                            }
                            i2++;
                        }
                    }
                    mouseSelectionObserver.onDragDone();
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    booleanRef = (Ref.BooleanRef) selectionGesturesKt$mouseSelection$1.L$2;
                    mouseSelectionObserver = (MouseSelectionObserver) selectionGesturesKt$mouseSelection$1.L$1;
                    awaitPointerEventScope2 = (AwaitPointerEventScope) selectionGesturesKt$mouseSelection$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    if (((Boolean) obj).booleanValue() && booleanRef.element) {
                        List<PointerInputChange> changes3 = awaitPointerEventScope2.getCurrentEvent().getChanges();
                        size = changes3.size();
                        while (i2 < size) {
                            PointerInputChange pointerInputChange3 = changes3.get(i2);
                            if (PointerEventKt.changedToUp(pointerInputChange3)) {
                                pointerInputChange3.consume();
                            }
                            i2++;
                        }
                    }
                    mouseSelectionObserver.onDragDone();
                }
                return Unit.INSTANCE;
            }
        }
        selectionGesturesKt$mouseSelection$1 = new SelectionGesturesKt$mouseSelection$1(continuation);
        Object obj2 = selectionGesturesKt$mouseSelection$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = selectionGesturesKt$mouseSelection$1.label;
        int i22 = 0;
        if (i != 0) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit mouseSelection$lambda$2(MouseSelectionObserver mouseSelectionObserver, PointerInputChange pointerInputChange) {
        if (mouseSelectionObserver.mo1965onExtendDragk4lQ0M(pointerInputChange.getPosition())) {
            pointerInputChange.consume();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit mouseSelection$lambda$4(MouseSelectionObserver mouseSelectionObserver, SelectionAdjustment selectionAdjustment, Ref.BooleanRef booleanRef, PointerInputChange pointerInputChange) {
        if (mouseSelectionObserver.mo1963onDrag3MmeM6k(pointerInputChange.getPosition(), selectionAdjustment)) {
            pointerInputChange.consume();
            booleanRef.element = true;
        }
        return Unit.INSTANCE;
    }

    public static final Object selectionGesturePointerInputBtf2(PointerInputScope pointerInputScope, MouseSelectionObserver mouseSelectionObserver, TextDragObserver textDragObserver, Continuation<? super Unit> continuation) {
        Object awaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new SelectionGesturesKt$selectionGesturePointerInputBtf2$2(new ClicksCounter(pointerInputScope.getViewConfiguration()), mouseSelectionObserver, textDragObserver, null), continuation);
        return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00a7 A[Catch: CancellationException -> 0x00d5, TryCatch #0 {CancellationException -> 0x00d5, blocks: (B:12:0x0032, B:13:0x009f, B:15:0x00a7, B:17:0x00b9, B:19:0x00c5, B:21:0x00c8, B:24:0x00cb, B:28:0x00cf, B:32:0x004a, B:34:0x0071, B:36:0x0075, B:38:0x007f, B:42:0x0054), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00cf A[Catch: CancellationException -> 0x00d5, TRY_LEAVE, TryCatch #0 {CancellationException -> 0x00d5, blocks: (B:12:0x0032, B:13:0x009f, B:15:0x00a7, B:17:0x00b9, B:19:0x00c5, B:21:0x00c8, B:24:0x00cb, B:28:0x00cf, B:32:0x004a, B:34:0x0071, B:36:0x0075, B:38:0x007f, B:42:0x0054), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object touchSelectionFirstPress(AwaitPointerEventScope awaitPointerEventScope, final TextDragObserver textDragObserver, PointerEvent pointerEvent, Continuation<? super Unit> continuation) {
        SelectionGesturesKt$touchSelectionFirstPress$1 selectionGesturesKt$touchSelectionFirstPress$1;
        Object obj;
        Object coroutine_suspended;
        int i;
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        try {
            if (continuation instanceof SelectionGesturesKt$touchSelectionFirstPress$1) {
                selectionGesturesKt$touchSelectionFirstPress$1 = (SelectionGesturesKt$touchSelectionFirstPress$1) continuation;
                if ((selectionGesturesKt$touchSelectionFirstPress$1.label & Integer.MIN_VALUE) != 0) {
                    selectionGesturesKt$touchSelectionFirstPress$1.label -= Integer.MIN_VALUE;
                    obj = selectionGesturesKt$touchSelectionFirstPress$1.result;
                    coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = selectionGesturesKt$touchSelectionFirstPress$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        pointerInputChange = (PointerInputChange) CollectionsKt.first(pointerEvent.getChanges());
                        long id = pointerInputChange.getId();
                        selectionGesturesKt$touchSelectionFirstPress$1.L$0 = awaitPointerEventScope;
                        selectionGesturesKt$touchSelectionFirstPress$1.L$1 = textDragObserver;
                        selectionGesturesKt$touchSelectionFirstPress$1.L$2 = pointerInputChange;
                        selectionGesturesKt$touchSelectionFirstPress$1.label = 1;
                        obj = DragGestureDetectorKt.m672awaitLongPressOrCancellationrnUCldI(awaitPointerEventScope, id, selectionGesturesKt$touchSelectionFirstPress$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            textDragObserver = (TextDragObserver) selectionGesturesKt$touchSelectionFirstPress$1.L$1;
                            awaitPointerEventScope = (AwaitPointerEventScope) selectionGesturesKt$touchSelectionFirstPress$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            if (((Boolean) obj).booleanValue()) {
                                List<PointerInputChange> changes = awaitPointerEventScope.getCurrentEvent().getChanges();
                                int size = changes.size();
                                for (int i2 = 0; i2 < size; i2++) {
                                    PointerInputChange pointerInputChange3 = changes.get(i2);
                                    if (PointerEventKt.changedToUp(pointerInputChange3)) {
                                        pointerInputChange3.consume();
                                    }
                                }
                                textDragObserver.onStop();
                            } else {
                                textDragObserver.onCancel();
                            }
                            return Unit.INSTANCE;
                        }
                        PointerInputChange pointerInputChange4 = (PointerInputChange) selectionGesturesKt$touchSelectionFirstPress$1.L$2;
                        textDragObserver = (TextDragObserver) selectionGesturesKt$touchSelectionFirstPress$1.L$1;
                        AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) selectionGesturesKt$touchSelectionFirstPress$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        pointerInputChange = pointerInputChange4;
                        awaitPointerEventScope = awaitPointerEventScope2;
                    }
                    pointerInputChange2 = (PointerInputChange) obj;
                    if (pointerInputChange2 != null && distanceIsTolerable(awaitPointerEventScope.getViewConfiguration(), pointerInputChange, pointerInputChange2)) {
                        textDragObserver.mo1625onStartk4lQ0M(pointerInputChange2.getPosition());
                        long id2 = pointerInputChange2.getId();
                        Function1 function1 = new Function1() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt$$ExternalSyntheticLambda6
                            public final Object invoke(Object obj2) {
                                Unit unit;
                                unit = SelectionGesturesKt.touchSelectionFirstPress$lambda$6(TextDragObserver.this, (PointerInputChange) obj2);
                                return unit;
                            }
                        };
                        selectionGesturesKt$touchSelectionFirstPress$1.L$0 = awaitPointerEventScope;
                        selectionGesturesKt$touchSelectionFirstPress$1.L$1 = textDragObserver;
                        selectionGesturesKt$touchSelectionFirstPress$1.L$2 = null;
                        selectionGesturesKt$touchSelectionFirstPress$1.label = 2;
                        obj = DragGestureDetectorKt.m682dragjO51t88(awaitPointerEventScope, id2, function1, selectionGesturesKt$touchSelectionFirstPress$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (((Boolean) obj).booleanValue()) {
                        }
                    }
                    return Unit.INSTANCE;
                }
            }
            if (i != 0) {
            }
            pointerInputChange2 = (PointerInputChange) obj;
            if (pointerInputChange2 != null) {
                textDragObserver.mo1625onStartk4lQ0M(pointerInputChange2.getPosition());
                long id22 = pointerInputChange2.getId();
                Function1 function12 = new Function1() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt$$ExternalSyntheticLambda6
                    public final Object invoke(Object obj2) {
                        Unit unit;
                        unit = SelectionGesturesKt.touchSelectionFirstPress$lambda$6(TextDragObserver.this, (PointerInputChange) obj2);
                        return unit;
                    }
                };
                selectionGesturesKt$touchSelectionFirstPress$1.L$0 = awaitPointerEventScope;
                selectionGesturesKt$touchSelectionFirstPress$1.L$1 = textDragObserver;
                selectionGesturesKt$touchSelectionFirstPress$1.L$2 = null;
                selectionGesturesKt$touchSelectionFirstPress$1.label = 2;
                obj = DragGestureDetectorKt.m682dragjO51t88(awaitPointerEventScope, id22, function12, selectionGesturesKt$touchSelectionFirstPress$1);
                if (obj == coroutine_suspended) {
                }
                if (((Boolean) obj).booleanValue()) {
                }
            }
            return Unit.INSTANCE;
        } catch (CancellationException e) {
            textDragObserver.onCancel();
            throw e;
        }
        selectionGesturesKt$touchSelectionFirstPress$1 = new SelectionGesturesKt$touchSelectionFirstPress$1(continuation);
        obj = selectionGesturesKt$touchSelectionFirstPress$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = selectionGesturesKt$touchSelectionFirstPress$1.label;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit touchSelectionFirstPress$lambda$6(TextDragObserver textDragObserver, PointerInputChange pointerInputChange) {
        textDragObserver.mo1624onDragk4lQ0M(PointerEventKt.positionChange(pointerInputChange));
        pointerInputChange.consume();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00e7 A[Catch: CancellationException -> 0x0115, TryCatch #1 {CancellationException -> 0x0115, blocks: (B:12:0x0033, B:13:0x00df, B:15:0x00e7, B:17:0x00f9, B:19:0x0105, B:21:0x0108, B:24:0x010b, B:28:0x010f, B:35:0x00a2, B:37:0x00a6, B:38:0x00a8, B:40:0x00ac, B:42:0x00af, B:44:0x00ba, B:46:0x00c0, B:48:0x00c4, B:49:0x00c9, B:58:0x0064), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x010f A[Catch: CancellationException -> 0x0115, TRY_LEAVE, TryCatch #1 {CancellationException -> 0x0115, blocks: (B:12:0x0033, B:13:0x00df, B:15:0x00e7, B:17:0x00f9, B:19:0x0105, B:21:0x0108, B:24:0x010b, B:28:0x010f, B:35:0x00a2, B:37:0x00a6, B:38:0x00a8, B:40:0x00ac, B:42:0x00af, B:44:0x00ba, B:46:0x00c0, B:48:0x00c4, B:49:0x00c9, B:58:0x0064), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a6 A[Catch: CancellationException -> 0x0115, TryCatch #1 {CancellationException -> 0x0115, blocks: (B:12:0x0033, B:13:0x00df, B:15:0x00e7, B:17:0x00f9, B:19:0x0105, B:21:0x0108, B:24:0x010b, B:28:0x010f, B:35:0x00a2, B:37:0x00a6, B:38:0x00a8, B:40:0x00ac, B:42:0x00af, B:44:0x00ba, B:46:0x00c0, B:48:0x00c4, B:49:0x00c9, B:58:0x0064), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ac A[Catch: CancellationException -> 0x0115, TryCatch #1 {CancellationException -> 0x0115, blocks: (B:12:0x0033, B:13:0x00df, B:15:0x00e7, B:17:0x00f9, B:19:0x0105, B:21:0x0108, B:24:0x010b, B:28:0x010f, B:35:0x00a2, B:37:0x00a6, B:38:0x00a8, B:40:0x00ac, B:42:0x00af, B:44:0x00ba, B:46:0x00c0, B:48:0x00c4, B:49:0x00c9, B:58:0x0064), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00af A[Catch: CancellationException -> 0x0115, TryCatch #1 {CancellationException -> 0x0115, blocks: (B:12:0x0033, B:13:0x00df, B:15:0x00e7, B:17:0x00f9, B:19:0x0105, B:21:0x0108, B:24:0x010b, B:28:0x010f, B:35:0x00a2, B:37:0x00a6, B:38:0x00a8, B:40:0x00ac, B:42:0x00af, B:44:0x00ba, B:46:0x00c0, B:48:0x00c4, B:49:0x00c9, B:58:0x0064), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object touchSelectionSubsequentPress(AwaitPointerEventScope awaitPointerEventScope, final TextDragObserver textDragObserver, PointerEvent pointerEvent, Continuation<? super Unit> continuation) {
        SelectionGesturesKt$touchSelectionSubsequentPress$1 selectionGesturesKt$touchSelectionSubsequentPress$1;
        int i;
        PointerInputChange pointerInputChange;
        long id;
        Ref.LongRef longRef;
        Object withTimeoutOrNull;
        DownResolution downResolution;
        try {
            if (continuation instanceof SelectionGesturesKt$touchSelectionSubsequentPress$1) {
                selectionGesturesKt$touchSelectionSubsequentPress$1 = (SelectionGesturesKt$touchSelectionSubsequentPress$1) continuation;
                if ((selectionGesturesKt$touchSelectionSubsequentPress$1.label & Integer.MIN_VALUE) != 0) {
                    selectionGesturesKt$touchSelectionSubsequentPress$1.label -= Integer.MIN_VALUE;
                    Object obj = selectionGesturesKt$touchSelectionSubsequentPress$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = selectionGesturesKt$touchSelectionSubsequentPress$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        pointerInputChange = (PointerInputChange) CollectionsKt.first(pointerEvent.getChanges());
                        id = pointerInputChange.getId();
                        longRef = new Ref.LongRef();
                        longRef.element = Offset.INSTANCE.m4608getUnspecifiedF1C5BW0();
                        long longPressTimeoutMillis = awaitPointerEventScope.getViewConfiguration().getLongPressTimeoutMillis();
                        C0521xcb1d223 c0521xcb1d223 = new C0521xcb1d223(id, longRef, null);
                        selectionGesturesKt$touchSelectionSubsequentPress$1.L$0 = awaitPointerEventScope;
                        selectionGesturesKt$touchSelectionSubsequentPress$1.L$1 = textDragObserver;
                        selectionGesturesKt$touchSelectionSubsequentPress$1.L$2 = pointerInputChange;
                        selectionGesturesKt$touchSelectionSubsequentPress$1.L$3 = longRef;
                        selectionGesturesKt$touchSelectionSubsequentPress$1.J$0 = id;
                        selectionGesturesKt$touchSelectionSubsequentPress$1.label = 1;
                        withTimeoutOrNull = awaitPointerEventScope.withTimeoutOrNull(longPressTimeoutMillis, c0521xcb1d223, selectionGesturesKt$touchSelectionSubsequentPress$1);
                        if (withTimeoutOrNull == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            textDragObserver = (TextDragObserver) selectionGesturesKt$touchSelectionSubsequentPress$1.L$1;
                            awaitPointerEventScope = (AwaitPointerEventScope) selectionGesturesKt$touchSelectionSubsequentPress$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            if (!((Boolean) obj).booleanValue()) {
                                List<PointerInputChange> changes = awaitPointerEventScope.getCurrentEvent().getChanges();
                                int size = changes.size();
                                for (int i2 = 0; i2 < size; i2++) {
                                    PointerInputChange pointerInputChange2 = changes.get(i2);
                                    if (PointerEventKt.changedToUp(pointerInputChange2)) {
                                        pointerInputChange2.consume();
                                    }
                                }
                                textDragObserver.onStop();
                            } else {
                                textDragObserver.onCancel();
                            }
                            return Unit.INSTANCE;
                        }
                        long j = selectionGesturesKt$touchSelectionSubsequentPress$1.J$0;
                        Ref.LongRef longRef2 = (Ref.LongRef) selectionGesturesKt$touchSelectionSubsequentPress$1.L$3;
                        pointerInputChange = (PointerInputChange) selectionGesturesKt$touchSelectionSubsequentPress$1.L$2;
                        TextDragObserver textDragObserver2 = (TextDragObserver) selectionGesturesKt$touchSelectionSubsequentPress$1.L$1;
                        AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) selectionGesturesKt$touchSelectionSubsequentPress$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            longRef = longRef2;
                            withTimeoutOrNull = obj;
                            id = j;
                            textDragObserver = textDragObserver2;
                            awaitPointerEventScope = awaitPointerEventScope2;
                        } catch (CancellationException e) {
                            e = e;
                            textDragObserver = textDragObserver2;
                            textDragObserver.onCancel();
                            throw e;
                        }
                    }
                    downResolution = (DownResolution) withTimeoutOrNull;
                    if (downResolution == null) {
                        downResolution = DownResolution.Timeout;
                    }
                    if (downResolution != DownResolution.Cancel) {
                        return Unit.INSTANCE;
                    }
                    textDragObserver.mo1625onStartk4lQ0M(pointerInputChange.getPosition());
                    if (downResolution == DownResolution.f61Up) {
                        textDragObserver.onStop();
                        return Unit.INSTANCE;
                    }
                    if (downResolution == DownResolution.Drag) {
                        textDragObserver.mo1624onDragk4lQ0M(longRef.element);
                    }
                    Function1 function1 = new Function1() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt$$ExternalSyntheticLambda5
                        public final Object invoke(Object obj2) {
                            Unit unit;
                            unit = SelectionGesturesKt.touchSelectionSubsequentPress$lambda$8(TextDragObserver.this, (PointerInputChange) obj2);
                            return unit;
                        }
                    };
                    selectionGesturesKt$touchSelectionSubsequentPress$1.L$0 = awaitPointerEventScope;
                    selectionGesturesKt$touchSelectionSubsequentPress$1.L$1 = textDragObserver;
                    selectionGesturesKt$touchSelectionSubsequentPress$1.L$2 = null;
                    selectionGesturesKt$touchSelectionSubsequentPress$1.L$3 = null;
                    selectionGesturesKt$touchSelectionSubsequentPress$1.label = 2;
                    obj = DragGestureDetectorKt.m682dragjO51t88(awaitPointerEventScope, id, function1, selectionGesturesKt$touchSelectionSubsequentPress$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    if (!((Boolean) obj).booleanValue()) {
                    }
                    return Unit.INSTANCE;
                }
            }
            if (i != 0) {
            }
            downResolution = (DownResolution) withTimeoutOrNull;
            if (downResolution == null) {
            }
            if (downResolution != DownResolution.Cancel) {
            }
        } catch (CancellationException e2) {
            e = e2;
        }
        selectionGesturesKt$touchSelectionSubsequentPress$1 = new SelectionGesturesKt$touchSelectionSubsequentPress$1(continuation);
        Object obj2 = selectionGesturesKt$touchSelectionSubsequentPress$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = selectionGesturesKt$touchSelectionSubsequentPress$1.label;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit touchSelectionSubsequentPress$lambda$8(TextDragObserver textDragObserver, PointerInputChange pointerInputChange) {
        textDragObserver.mo1624onDragk4lQ0M(PointerEventKt.positionChange(pointerInputChange));
        pointerInputChange.consume();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0139 A[Catch: all -> 0x003b, TryCatch #1 {all -> 0x003b, blocks: (B:12:0x0036, B:13:0x011c, B:15:0x0124, B:17:0x0128, B:19:0x0139, B:21:0x0145, B:61:0x00e9, B:64:0x00ff), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0093 A[Catch: all -> 0x0053, TryCatch #0 {all -> 0x0053, blocks: (B:34:0x004f, B:35:0x008b, B:37:0x0093, B:39:0x00a4, B:41:0x00b0, B:52:0x0072), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object mouseSelectionBtf2(AwaitPointerEventScope awaitPointerEventScope, final MouseSelectionObserver mouseSelectionObserver, ClicksCounter clicksCounter, PointerEvent pointerEvent, Continuation<? super Unit> continuation) {
        SelectionGesturesKt$mouseSelectionBtf2$1 selectionGesturesKt$mouseSelectionBtf2$1;
        int i;
        final SelectionAdjustment none;
        AwaitPointerEventScope awaitPointerEventScope2;
        Ref.BooleanRef booleanRef;
        int size;
        try {
            try {
                if (continuation instanceof SelectionGesturesKt$mouseSelectionBtf2$1) {
                    selectionGesturesKt$mouseSelectionBtf2$1 = (SelectionGesturesKt$mouseSelectionBtf2$1) continuation;
                    if ((selectionGesturesKt$mouseSelectionBtf2$1.label & Integer.MIN_VALUE) != 0) {
                        selectionGesturesKt$mouseSelectionBtf2$1.label -= Integer.MIN_VALUE;
                        Object obj = selectionGesturesKt$mouseSelectionBtf2$1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i = selectionGesturesKt$mouseSelectionBtf2$1.label;
                        int i2 = 0;
                        boolean z = true;
                        if (i == 0) {
                            if (i == 1) {
                                mouseSelectionObserver = (MouseSelectionObserver) selectionGesturesKt$mouseSelectionBtf2$1.L$1;
                                awaitPointerEventScope = (AwaitPointerEventScope) selectionGesturesKt$mouseSelectionBtf2$1.L$0;
                                ResultKt.throwOnFailure(obj);
                                if (((Boolean) obj).booleanValue()) {
                                    List<PointerInputChange> changes = awaitPointerEventScope.getCurrentEvent().getChanges();
                                    int size2 = changes.size();
                                    while (i2 < size2) {
                                        PointerInputChange pointerInputChange = changes.get(i2);
                                        if (PointerEventKt.changedToUp(pointerInputChange)) {
                                            pointerInputChange.consume();
                                        }
                                        i2++;
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                            if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            booleanRef = (Ref.BooleanRef) selectionGesturesKt$mouseSelectionBtf2$1.L$2;
                            mouseSelectionObserver = (MouseSelectionObserver) selectionGesturesKt$mouseSelectionBtf2$1.L$1;
                            awaitPointerEventScope2 = (AwaitPointerEventScope) selectionGesturesKt$mouseSelectionBtf2$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            if (((Boolean) obj).booleanValue() && booleanRef.element) {
                                List<PointerInputChange> changes2 = awaitPointerEventScope2.getCurrentEvent().getChanges();
                                size = changes2.size();
                                while (i2 < size) {
                                    PointerInputChange pointerInputChange2 = changes2.get(i2);
                                    if (PointerEventKt.changedToUp(pointerInputChange2)) {
                                        pointerInputChange2.consume();
                                    }
                                    i2++;
                                }
                            }
                            mouseSelectionObserver.onDragDone();
                            return Unit.INSTANCE;
                        }
                        ResultKt.throwOnFailure(obj);
                        PointerInputChange pointerInputChange3 = pointerEvent.getChanges().get(0);
                        if (TextFieldSelectionManager_androidKt.isShiftPressed(pointerEvent)) {
                            if (mouseSelectionObserver.mo1964onExtendk4lQ0M(pointerInputChange3.getPosition())) {
                                pointerInputChange3.consume();
                                long id = pointerInputChange3.getId();
                                Function1 function1 = new Function1() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt$$ExternalSyntheticLambda3
                                    public final Object invoke(Object obj2) {
                                        Unit mouseSelectionBtf2$lambda$10;
                                        mouseSelectionBtf2$lambda$10 = SelectionGesturesKt.mouseSelectionBtf2$lambda$10(MouseSelectionObserver.this, (PointerInputChange) obj2);
                                        return mouseSelectionBtf2$lambda$10;
                                    }
                                };
                                selectionGesturesKt$mouseSelectionBtf2$1.L$0 = awaitPointerEventScope;
                                selectionGesturesKt$mouseSelectionBtf2$1.L$1 = mouseSelectionObserver;
                                selectionGesturesKt$mouseSelectionBtf2$1.label = 1;
                                obj = DragGestureDetectorKt.m682dragjO51t88(awaitPointerEventScope, id, function1, selectionGesturesKt$mouseSelectionBtf2$1);
                                if (obj == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                if (((Boolean) obj).booleanValue()) {
                                }
                            }
                        } else {
                            int clicks = clicksCounter.getClicks();
                            if (clicks == 1) {
                                none = SelectionAdjustment.INSTANCE.getNone();
                            } else if (clicks == 2) {
                                none = SelectionAdjustment.INSTANCE.getWord();
                            } else {
                                none = SelectionAdjustment.INSTANCE.getParagraph();
                            }
                            if (mouseSelectionObserver.mo1966onStart9KIMszo(pointerInputChange3.getPosition(), none, clicksCounter.getClicks())) {
                                pointerInputChange3.consume();
                                final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
                                if (Intrinsics.areEqual(none, SelectionAdjustment.INSTANCE.getNone())) {
                                    z = false;
                                }
                                booleanRef2.element = z;
                                long id2 = pointerInputChange3.getId();
                                Function1 function12 = new Function1() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt$$ExternalSyntheticLambda4
                                    public final Object invoke(Object obj2) {
                                        Unit mouseSelectionBtf2$lambda$12;
                                        mouseSelectionBtf2$lambda$12 = SelectionGesturesKt.mouseSelectionBtf2$lambda$12(MouseSelectionObserver.this, none, booleanRef2, (PointerInputChange) obj2);
                                        return mouseSelectionBtf2$lambda$12;
                                    }
                                };
                                selectionGesturesKt$mouseSelectionBtf2$1.L$0 = awaitPointerEventScope;
                                selectionGesturesKt$mouseSelectionBtf2$1.L$1 = mouseSelectionObserver;
                                selectionGesturesKt$mouseSelectionBtf2$1.L$2 = booleanRef2;
                                selectionGesturesKt$mouseSelectionBtf2$1.label = 2;
                                obj = DragGestureDetectorKt.m682dragjO51t88(awaitPointerEventScope, id2, function12, selectionGesturesKt$mouseSelectionBtf2$1);
                                if (obj == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                awaitPointerEventScope2 = awaitPointerEventScope;
                                booleanRef = booleanRef2;
                                if (((Boolean) obj).booleanValue()) {
                                    List<PointerInputChange> changes22 = awaitPointerEventScope2.getCurrentEvent().getChanges();
                                    size = changes22.size();
                                    while (i2 < size) {
                                    }
                                }
                                mouseSelectionObserver.onDragDone();
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }
                if (i == 0) {
                }
            } finally {
            }
        } finally {
        }
        selectionGesturesKt$mouseSelectionBtf2$1 = new SelectionGesturesKt$mouseSelectionBtf2$1(continuation);
        Object obj2 = selectionGesturesKt$mouseSelectionBtf2$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = selectionGesturesKt$mouseSelectionBtf2$1.label;
        int i22 = 0;
        boolean z2 = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit mouseSelectionBtf2$lambda$10(MouseSelectionObserver mouseSelectionObserver, PointerInputChange pointerInputChange) {
        if (mouseSelectionObserver.mo1965onExtendDragk4lQ0M(pointerInputChange.getPosition())) {
            pointerInputChange.consume();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit mouseSelectionBtf2$lambda$12(MouseSelectionObserver mouseSelectionObserver, SelectionAdjustment selectionAdjustment, Ref.BooleanRef booleanRef, PointerInputChange pointerInputChange) {
        if (mouseSelectionObserver.mo1963onDrag3MmeM6k(pointerInputChange.getPosition(), selectionAdjustment)) {
            pointerInputChange.consume();
            booleanRef.element = true;
        }
        return Unit.INSTANCE;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0045 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0067 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0043 -> B:10:0x0046). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final java.lang.Object awaitDown(androidx.compose.p002ui.input.pointer.AwaitPointerEventScope r8, kotlin.coroutines.Continuation<? super androidx.compose.p002ui.input.pointer.PointerEvent> r9) {
        /*
            boolean r0 = r9 instanceof androidx.compose.foundation.text.selection.SelectionGesturesKt$awaitDown$1
            if (r0 == 0) goto L14
            r0 = r9
            androidx.compose.foundation.text.selection.SelectionGesturesKt$awaitDown$1 r0 = (androidx.compose.foundation.text.selection.SelectionGesturesKt$awaitDown$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            androidx.compose.foundation.text.selection.SelectionGesturesKt$awaitDown$1 r0 = new androidx.compose.foundation.text.selection.SelectionGesturesKt$awaitDown$1
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r8 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r8 = (androidx.compose.p002ui.input.pointer.AwaitPointerEventScope) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L46
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L36:
            kotlin.ResultKt.throwOnFailure(r9)
        L39:
            androidx.compose.ui.input.pointer.PointerEventPass r9 = androidx.compose.p002ui.input.pointer.PointerEventPass.Main
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r9 = r8.awaitPointerEvent(r9, r0)
            if (r9 != r1) goto L46
            return r1
        L46:
            androidx.compose.ui.input.pointer.PointerEvent r9 = (androidx.compose.p002ui.input.pointer.PointerEvent) r9
            java.util.List r2 = r9.getChanges()
            r4 = r2
            java.util.Collection r4 = (java.util.Collection) r4
            int r4 = r4.size()
            r5 = 0
            r6 = r5
        L55:
            if (r6 >= r4) goto L67
            java.lang.Object r7 = r2.get(r6)
            androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.p002ui.input.pointer.PointerInputChange) r7
            boolean r7 = androidx.compose.p002ui.input.pointer.PointerEventKt.changedToDownIgnoreConsumed(r7)
            if (r7 != 0) goto L64
            goto L68
        L64:
            int r6 = r6 + 1
            goto L55
        L67:
            r5 = r3
        L68:
            if (r5 == 0) goto L39
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionGesturesKt.awaitDown(androidx.compose.ui.input.pointer.AwaitPointerEventScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean distanceIsTolerable(ViewConfiguration viewConfiguration, PointerInputChange pointerInputChange, PointerInputChange pointerInputChange2) {
        return Offset.m4591getDistanceimpl(Offset.m4597minusMKHz9U(pointerInputChange.getPosition(), pointerInputChange2.getPosition())) < DragGestureDetectorKt.m685pointerSlopE8SPZFQ(viewConfiguration, pointerInputChange.getType());
    }

    public static final boolean isPrecisePointer(PointerEvent pointerEvent) {
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        for (int i = 0; i < size; i++) {
            if (!PointerType.m6215equalsimpl0(changes.get(i).getType(), PointerType.INSTANCE.m6220getMouseT8wyACA())) {
                return false;
            }
        }
        return true;
    }
}
