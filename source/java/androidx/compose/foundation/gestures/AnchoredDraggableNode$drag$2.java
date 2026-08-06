package androidx.compose.foundation.gestures;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.p002ui.geometry.Offset;
import androidx.compose.p002ui.input.nestedscroll.NestedScrollSource;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: AnchoredDraggable.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "T", "Landroidx/compose/foundation/gestures/AnchoredDragScope;", "it", "Landroidx/compose/foundation/gestures/DraggableAnchors;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableNode$drag$2", f = "AnchoredDraggable.kt", i = {}, l = {409}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
final class AnchoredDraggableNode$drag$2<T> extends SuspendLambda implements Function3<AnchoredDragScope, DraggableAnchors<T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Function1<? super DragEvent.DragDelta, Unit>, Continuation<? super Unit>, Object> $forEachDelta;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AnchoredDraggableNode<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnchoredDraggableNode$drag$2(Function2<? super Function1<? super DragEvent.DragDelta, Unit>, ? super Continuation<? super Unit>, ? extends Object> function2, AnchoredDraggableNode<T> anchoredDraggableNode, Continuation<? super AnchoredDraggableNode$drag$2> continuation) {
        super(3, continuation);
        this.$forEachDelta = function2;
        this.this$0 = anchoredDraggableNode;
    }

    public final Object invoke(AnchoredDragScope anchoredDragScope, DraggableAnchors<T> draggableAnchors, Continuation<? super Unit> continuation) {
        AnchoredDraggableNode$drag$2 anchoredDraggableNode$drag$2 = new AnchoredDraggableNode$drag$2(this.$forEachDelta, this.this$0, continuation);
        anchoredDraggableNode$drag$2.L$0 = anchoredDragScope;
        return anchoredDraggableNode$drag$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final AnchoredDragScope anchoredDragScope = (AnchoredDragScope) this.L$0;
            Function2<Function1<? super DragEvent.DragDelta, Unit>, Continuation<? super Unit>, Object> function2 = this.$forEachDelta;
            final AnchoredDraggableNode<T> anchoredDraggableNode = this.this$0;
            Function1 function1 = new Function1() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableNode$drag$2$$ExternalSyntheticLambda0
                public final Object invoke(Object obj2) {
                    Unit invokeSuspend$lambda$1;
                    invokeSuspend$lambda$1 = AnchoredDraggableNode$drag$2.invokeSuspend$lambda$1(AnchoredDraggableNode.this, anchoredDragScope, (DragEvent.DragDelta) obj2);
                    return invokeSuspend$lambda$1;
                }
            };
            this.label = 1;
            if (function2.invoke(function1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$1(final AnchoredDraggableNode anchoredDraggableNode, final AnchoredDragScope anchoredDragScope, DragEvent.DragDelta dragDelta) {
        long m619reverseIfNeededMKHz9U;
        float m621toFloatk4lQ0M;
        OverscrollEffect overscrollEffect;
        OverscrollEffect overscrollEffect2;
        long m622toOffsettuRUvjQ;
        AnchoredDraggableState anchoredDraggableState;
        m619reverseIfNeededMKHz9U = anchoredDraggableNode.m619reverseIfNeededMKHz9U(dragDelta.getDelta());
        m621toFloatk4lQ0M = anchoredDraggableNode.m621toFloatk4lQ0M(m619reverseIfNeededMKHz9U);
        overscrollEffect = anchoredDraggableNode.overscrollEffect;
        if (overscrollEffect == null) {
            anchoredDraggableState = anchoredDraggableNode.state;
            AnchoredDragScope.dragTo$default(anchoredDragScope, anchoredDraggableState.newOffsetForDelta$foundation_release(m621toFloatk4lQ0M), 0.0f, 2, null);
        } else {
            overscrollEffect2 = anchoredDraggableNode.overscrollEffect;
            Intrinsics.checkNotNull(overscrollEffect2);
            m622toOffsettuRUvjQ = anchoredDraggableNode.m622toOffsettuRUvjQ(m621toFloatk4lQ0M);
            Offset.m4582boximpl(overscrollEffect2.mo372applyToScrollRhakbz0(m622toOffsettuRUvjQ, NestedScrollSource.INSTANCE.m6032getUserInputWNlRxjI(), new Function1() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableNode$drag$2$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    Offset invokeSuspend$lambda$1$lambda$0;
                    invokeSuspend$lambda$1$lambda$0 = AnchoredDraggableNode$drag$2.invokeSuspend$lambda$1$lambda$0(AnchoredDraggableNode.this, anchoredDragScope, (Offset) obj);
                    return invokeSuspend$lambda$1$lambda$0;
                }
            }));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Offset invokeSuspend$lambda$1$lambda$0(AnchoredDraggableNode anchoredDraggableNode, AnchoredDragScope anchoredDragScope, Offset offset) {
        AnchoredDraggableState anchoredDraggableState;
        float m621toFloatk4lQ0M;
        AnchoredDraggableState anchoredDraggableState2;
        long m622toOffsettuRUvjQ;
        anchoredDraggableState = anchoredDraggableNode.state;
        m621toFloatk4lQ0M = anchoredDraggableNode.m621toFloatk4lQ0M(offset.m4603unboximpl());
        float newOffsetForDelta$foundation_release = anchoredDraggableState.newOffsetForDelta$foundation_release(m621toFloatk4lQ0M);
        anchoredDraggableState2 = anchoredDraggableNode.state;
        m622toOffsettuRUvjQ = anchoredDraggableNode.m622toOffsettuRUvjQ(newOffsetForDelta$foundation_release - anchoredDraggableState2.requireOffset());
        AnchoredDragScope.dragTo$default(anchoredDragScope, newOffsetForDelta$foundation_release, 0.0f, 2, null);
        return Offset.m4582boximpl(m622toOffsettuRUvjQ);
    }
}
