package androidx.compose.foundation.text.handwriting;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.gestures.TapGestureDetector_androidKt;
import androidx.compose.p002ui.focus.FocusEventModifierNode;
import androidx.compose.p002ui.focus.FocusRequesterModifierNode;
import androidx.compose.p002ui.focus.FocusRequesterModifierNodeKt;
import androidx.compose.p002ui.focus.FocusState;
import androidx.compose.p002ui.geometry.Offset;
import androidx.compose.p002ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p002ui.input.pointer.PointerEvent;
import androidx.compose.p002ui.input.pointer.PointerEventPass;
import androidx.compose.p002ui.input.pointer.PointerId;
import androidx.compose.p002ui.input.pointer.PointerInputChange;
import androidx.compose.p002ui.input.pointer.PointerInputEventHandler;
import androidx.compose.p002ui.input.pointer.PointerInputScope;
import androidx.compose.p002ui.input.pointer.PointerType;
import androidx.compose.p002ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p002ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.PointerInputModifierNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* compiled from: StylusHandwriting.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0011\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J'\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 J\b\u0010!\u001a\u00020\u0007H\u0016J\u0006\u0010\"\u001a\u00020\u0007R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\tR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Landroidx/compose/foundation/text/handwriting/StylusHandwritingNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "Landroidx/compose/ui/focus/FocusRequesterModifierNode;", "onHandwritingSlopExceeded", "Lkotlin/Function0;", "", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "getOnHandwritingSlopExceeded", "()Lkotlin/jvm/functions/Function0;", "setOnHandwritingSlopExceeded", "focused", "", "onFocusEvent", "focusState", "Landroidx/compose/ui/focus/FocusState;", "touchBoundsExpansion", "Landroidx/compose/ui/node/TouchBoundsExpansion;", "getTouchBoundsExpansion-RZrCHBk", "()J", "suspendingPointerInputModifierNode", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onCancelPointerInput", "resetPointerInputHandler", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public class StylusHandwritingNode extends DelegatingNode implements PointerInputModifierNode, FocusEventModifierNode, FocusRequesterModifierNode {
    public static final int $stable = 8;
    private boolean focused;
    private Function0<Unit> onHandwritingSlopExceeded;
    private final SuspendingPointerInputModifierNode suspendingPointerInputModifierNode = delegate((DelegatableNode) SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new PointerInputEventHandler() { // from class: androidx.compose.foundation.text.handwriting.StylusHandwritingNode$suspendingPointerInputModifierNode$1

        /* compiled from: StylusHandwriting.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.text.handwriting.StylusHandwritingNode$suspendingPointerInputModifierNode$1$1", f = "StylusHandwriting.kt", i = {0, 1, 1, 1, 2, 2}, l = {116, 144, 182}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "firstDown", "pass", "$this$awaitEachGesture", "firstDown"}, s = {"L$0", "L$0", "L$1", "L$2", "L$0", "L$1"})
        /* renamed from: androidx.compose.foundation.text.handwriting.StylusHandwritingNode$suspendingPointerInputModifierNode$1$1 */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
        static final class C04471 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            Object L$1;
            Object L$2;
            int label;
            final /* synthetic */ StylusHandwritingNode this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C04471(StylusHandwritingNode stylusHandwritingNode, Continuation<? super C04471> continuation) {
                super(2, continuation);
                this.this$0 = stylusHandwritingNode;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> c04471 = new C04471(this.this$0, continuation);
                c04471.L$0 = obj;
                return c04471;
            }

            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                return create(awaitPointerEventScope, continuation).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Removed duplicated region for block: B:21:0x01fb  */
            /* JADX WARN: Removed duplicated region for block: B:24:0x01fe  */
            /* JADX WARN: Removed duplicated region for block: B:27:0x01bb A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:29:0x01f6 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:36:0x0117  */
            /* JADX WARN: Removed duplicated region for block: B:48:0x014b  */
            /* JADX WARN: Removed duplicated region for block: B:55:0x0187  */
            /* JADX WARN: Removed duplicated region for block: B:57:0x018a  */
            /* JADX WARN: Removed duplicated region for block: B:61:0x0202  */
            /* JADX WARN: Removed duplicated region for block: B:64:0x0106 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:67:0x0145 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:9:0x01cc  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x01b9 -> B:7:0x01bc). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x0104 -> B:32:0x0107). Please report as a decompilation issue!!! */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object obj) {
                AwaitPointerEventScope awaitPointerEventScope;
                Object awaitFirstDown;
                PointerInputChange pointerInputChange;
                boolean z;
                C04471 c04471;
                AwaitPointerEventScope awaitPointerEventScope2;
                PointerEventPass pointerEventPass;
                Object awaitPointerEvent;
                int size;
                int i;
                PointerInputChange pointerInputChange2;
                PointerInputChange pointerInputChange3;
                boolean z2;
                PointerInputChange pointerInputChange4;
                AwaitPointerEventScope awaitPointerEventScope3;
                Object awaitPointerEvent2;
                int size2;
                int i2;
                PointerInputChange pointerInputChange5;
                PointerInputChange pointerInputChange6;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i3 = this.label;
                int i4 = 2;
                if (i3 == 0) {
                    ResultKt.throwOnFailure(obj);
                    awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                    this.L$0 = awaitPointerEventScope;
                    this.label = 1;
                    awaitFirstDown = TapGestureDetectorKt.awaitFirstDown(awaitPointerEventScope, true, PointerEventPass.Initial, (Continuation) this);
                    if (awaitFirstDown == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    awaitFirstDown = obj;
                } else if (i3 == 2) {
                    pointerEventPass = (PointerEventPass) this.L$2;
                    pointerInputChange = (PointerInputChange) this.L$1;
                    awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    awaitPointerEvent = obj;
                    c04471 = this;
                    PointerEvent pointerEvent = (PointerEvent) awaitPointerEvent;
                    List<PointerInputChange> changes = pointerEvent.getChanges();
                    size = changes.size();
                    i = 0;
                    while (true) {
                        if (i >= size) {
                            pointerInputChange2 = null;
                            break;
                        }
                        pointerInputChange2 = changes.get(i);
                        PointerInputChange pointerInputChange7 = pointerInputChange2;
                        if (!pointerInputChange7.isConsumed() && PointerId.m6126equalsimpl0(pointerInputChange7.getId(), pointerInputChange.getId()) && pointerInputChange7.getPressed()) {
                            break;
                        }
                        i++;
                    }
                    pointerInputChange3 = pointerInputChange2;
                    if (pointerInputChange3 == null || pointerInputChange3.getUptimeMillis() - pointerInputChange.getUptimeMillis() >= awaitPointerEventScope2.getViewConfiguration().getLongPressTimeoutMillis() || TapGestureDetector_androidKt.isDeepPress(pointerEvent)) {
                        pointerInputChange3 = null;
                    } else if (Offset.m4591getDistanceimpl(Offset.m4597minusMKHz9U(pointerInputChange3.getPosition(), pointerInputChange.getPosition())) <= awaitPointerEventScope2.getViewConfiguration().getHandwritingSlop()) {
                        i4 = 2;
                        c04471.L$0 = awaitPointerEventScope2;
                        c04471.L$1 = pointerInputChange;
                        c04471.L$2 = pointerEventPass;
                        c04471.label = i4;
                        awaitPointerEvent = awaitPointerEventScope2.awaitPointerEvent(pointerEventPass, (Continuation) c04471);
                        if (awaitPointerEvent == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        PointerEvent pointerEvent2 = (PointerEvent) awaitPointerEvent;
                        List<PointerInputChange> changes2 = pointerEvent2.getChanges();
                        size = changes2.size();
                        i = 0;
                        while (true) {
                            if (i >= size) {
                            }
                            i++;
                        }
                        pointerInputChange3 = pointerInputChange2;
                        if (pointerInputChange3 == null) {
                            if (Offset.m4591getDistanceimpl(Offset.m4597minusMKHz9U(pointerInputChange3.getPosition(), pointerInputChange.getPosition())) <= awaitPointerEventScope2.getViewConfiguration().getHandwritingSlop()) {
                            }
                        }
                        pointerInputChange3 = null;
                    }
                    if (pointerInputChange3 != null) {
                        return Unit.INSTANCE;
                    }
                    z2 = c04471.this$0.focused;
                    if (!z2) {
                        FocusRequesterModifierNodeKt.requestFocus(c04471.this$0);
                    }
                    c04471.this$0.getOnHandwritingSlopExceeded().invoke();
                    pointerInputChange3.consume();
                    pointerInputChange4 = pointerInputChange;
                    awaitPointerEventScope3 = awaitPointerEventScope2;
                    c04471.L$0 = awaitPointerEventScope3;
                    c04471.L$1 = pointerInputChange4;
                    c04471.L$2 = null;
                    c04471.label = 3;
                    awaitPointerEvent2 = awaitPointerEventScope3.awaitPointerEvent(PointerEventPass.Initial, (Continuation) c04471);
                    if (awaitPointerEvent2 == coroutine_suspended) {
                    }
                    List<PointerInputChange> changes3 = ((PointerEvent) awaitPointerEvent2).getChanges();
                    size2 = changes3.size();
                    i2 = 0;
                    while (true) {
                        if (i2 >= size2) {
                        }
                        i2++;
                    }
                    pointerInputChange6 = pointerInputChange5;
                    if (pointerInputChange6 == null) {
                    }
                } else {
                    if (i3 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    pointerInputChange4 = (PointerInputChange) this.L$1;
                    awaitPointerEventScope3 = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    c04471 = this;
                    awaitPointerEvent2 = obj;
                    List<PointerInputChange> changes32 = ((PointerEvent) awaitPointerEvent2).getChanges();
                    size2 = changes32.size();
                    i2 = 0;
                    while (true) {
                        if (i2 >= size2) {
                            pointerInputChange5 = null;
                            break;
                        }
                        pointerInputChange5 = changes32.get(i2);
                        PointerInputChange pointerInputChange8 = pointerInputChange5;
                        if (!pointerInputChange8.isConsumed() && PointerId.m6126equalsimpl0(pointerInputChange8.getId(), pointerInputChange4.getId()) && pointerInputChange8.getPressed()) {
                            break;
                        }
                        i2++;
                    }
                    pointerInputChange6 = pointerInputChange5;
                    if (pointerInputChange6 == null) {
                        return Unit.INSTANCE;
                    }
                    pointerInputChange6.consume();
                    c04471.L$0 = awaitPointerEventScope3;
                    c04471.L$1 = pointerInputChange4;
                    c04471.L$2 = null;
                    c04471.label = 3;
                    awaitPointerEvent2 = awaitPointerEventScope3.awaitPointerEvent(PointerEventPass.Initial, (Continuation) c04471);
                    if (awaitPointerEvent2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    List<PointerInputChange> changes322 = ((PointerEvent) awaitPointerEvent2).getChanges();
                    size2 = changes322.size();
                    i2 = 0;
                    while (true) {
                        if (i2 >= size2) {
                        }
                        i2++;
                    }
                    pointerInputChange6 = pointerInputChange5;
                    if (pointerInputChange6 == null) {
                    }
                }
                pointerInputChange = (PointerInputChange) awaitFirstDown;
                if (!(PointerType.m6215equalsimpl0(pointerInputChange.getType(), PointerType.INSTANCE.m6221getStylusT8wyACA()) || PointerType.m6215equalsimpl0(pointerInputChange.getType(), PointerType.INSTANCE.m6219getEraserT8wyACA()))) {
                    return Unit.INSTANCE;
                }
                boolean z3 = Float.intBitsToFloat((int) (pointerInputChange.getPosition() >> 32)) >= 0.0f && Float.intBitsToFloat((int) (pointerInputChange.getPosition() >> 32)) < ((float) ((int) (awaitPointerEventScope.mo6048getSizeYbymL2g() >> 32))) && Float.intBitsToFloat((int) (pointerInputChange.getPosition() & 4294967295L)) >= 0.0f && Float.intBitsToFloat((int) (pointerInputChange.getPosition() & 4294967295L)) < ((float) ((int) (awaitPointerEventScope.mo6048getSizeYbymL2g() & 4294967295L)));
                z = this.this$0.focused;
                PointerEventPass pointerEventPass2 = (z || z3) ? PointerEventPass.Initial : PointerEventPass.Main;
                c04471 = this;
                PointerEventPass pointerEventPass3 = pointerEventPass2;
                awaitPointerEventScope2 = awaitPointerEventScope;
                pointerEventPass = pointerEventPass3;
                c04471.L$0 = awaitPointerEventScope2;
                c04471.L$1 = pointerInputChange;
                c04471.L$2 = pointerEventPass;
                c04471.label = i4;
                awaitPointerEvent = awaitPointerEventScope2.awaitPointerEvent(pointerEventPass, (Continuation) c04471);
                if (awaitPointerEvent == coroutine_suspended) {
                }
                PointerEvent pointerEvent22 = (PointerEvent) awaitPointerEvent;
                List<PointerInputChange> changes22 = pointerEvent22.getChanges();
                size = changes22.size();
                i = 0;
                while (true) {
                    if (i >= size) {
                    }
                    i++;
                }
                pointerInputChange3 = pointerInputChange2;
                if (pointerInputChange3 == null) {
                }
                pointerInputChange3 = null;
                if (pointerInputChange3 != null) {
                }
            }
        }

        @Override // androidx.compose.p002ui.input.pointer.PointerInputEventHandler
        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
            Object awaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new C04471(StylusHandwritingNode.this, null), continuation);
            return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
        }
    }));

    public final Function0<Unit> getOnHandwritingSlopExceeded() {
        return this.onHandwritingSlopExceeded;
    }

    public final void setOnHandwritingSlopExceeded(Function0<Unit> function0) {
        this.onHandwritingSlopExceeded = function0;
    }

    public StylusHandwritingNode(Function0<Unit> function0) {
        this.onHandwritingSlopExceeded = function0;
    }

    @Override // androidx.compose.p002ui.focus.FocusEventModifierNode
    public void onFocusEvent(FocusState focusState) {
        this.focused = focusState.isFocused();
    }

    /* renamed from: getTouchBoundsExpansion-RZrCHBk, reason: not valid java name */
    public long m1721getTouchBoundsExpansionRZrCHBk() {
        return StylusHandwritingKt.getHandwritingBoundsExpansion().roundToTouchBoundsExpansion-TW6G1oQ(DelegatableNodeKt.requireDensity(this));
    }

    /* renamed from: onPointerEvent-H0pRuoY, reason: not valid java name */
    public void m1722onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds) {
        this.suspendingPointerInputModifierNode.onPointerEvent-H0pRuoY(pointerEvent, pass, bounds);
    }

    public void onCancelPointerInput() {
        this.suspendingPointerInputModifierNode.onCancelPointerInput();
    }

    public final void resetPointerInputHandler() {
        this.suspendingPointerInputModifierNode.resetPointerInputHandler();
    }
}
