package androidx.compose.foundation.gestures;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AnchoredDraggable.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableNode$onDragStopped$1", f = "AnchoredDraggable.kt", i = {}, l = {435, 437}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
final class AnchoredDraggableNode$onDragStopped$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $velocity;
    int label;
    final /* synthetic */ AnchoredDraggableNode<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnchoredDraggableNode$onDragStopped$1(AnchoredDraggableNode<T> anchoredDraggableNode, long j, Continuation<? super AnchoredDraggableNode$onDragStopped$1> continuation) {
        super(2, continuation);
        this.this$0 = anchoredDraggableNode;
        this.$velocity = j;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AnchoredDraggableNode$onDragStopped$1(this.this$0, this.$velocity, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        long m618reverseIfNeededAH228Gc;
        float m620toFloatTH1AsA0;
        OverscrollEffect overscrollEffect;
        OverscrollEffect overscrollEffect2;
        long m623toVelocityadjELrA;
        Object fling;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Unit unit = Unit.INSTANCE;
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        AnchoredDraggableNode<T> anchoredDraggableNode = this.this$0;
        m618reverseIfNeededAH228Gc = anchoredDraggableNode.m618reverseIfNeededAH228Gc(this.$velocity);
        m620toFloatTH1AsA0 = anchoredDraggableNode.m620toFloatTH1AsA0(m618reverseIfNeededAH228Gc);
        overscrollEffect = ((AnchoredDraggableNode) this.this$0).overscrollEffect;
        if (overscrollEffect == null) {
            this.label = 1;
            fling = this.this$0.fling(m620toFloatTH1AsA0, (Continuation) this);
            if (fling == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
        overscrollEffect2 = ((AnchoredDraggableNode) this.this$0).overscrollEffect;
        Intrinsics.checkNotNull(overscrollEffect2);
        m623toVelocityadjELrA = this.this$0.m623toVelocityadjELrA(m620toFloatTH1AsA0);
        this.label = 2;
        if (overscrollEffect2.mo371applyToFlingBMRW4eQ(m623toVelocityadjELrA, new C02501(this.this$0, null), (Continuation) this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        Unit unit2 = Unit.INSTANCE;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnchoredDraggable.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Landroidx/compose/ui/unit/Velocity;", "availableVelocity"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableNode$onDragStopped$1$1", f = "AnchoredDraggable.kt", i = {0}, l = {439}, m = "invokeSuspend", n = {"availableVelocity"}, s = {"J$0"})
    /* renamed from: androidx.compose.foundation.gestures.AnchoredDraggableNode$onDragStopped$1$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
    public static final class C02501 extends SuspendLambda implements Function2<Velocity, Continuation<? super Velocity>, Object> {
        /* synthetic */ long J$0;
        int label;
        final /* synthetic */ AnchoredDraggableNode<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02501(AnchoredDraggableNode<T> anchoredDraggableNode, Continuation<? super C02501> continuation) {
            super(2, continuation);
            this.this$0 = anchoredDraggableNode;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c02501 = new C02501(this.this$0, continuation);
            c02501.J$0 = ((Velocity) obj).unbox-impl();
            return c02501;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return m627invokesFctU(((Velocity) obj).unbox-impl(), (Continuation) obj2);
        }

        /* renamed from: invoke-sF-c-tU, reason: not valid java name */
        public final Object m627invokesFctU(long j, Continuation<? super Velocity> continuation) {
            return create(Velocity.box-impl(j), continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            float m620toFloatTH1AsA0;
            long j;
            AnchoredDraggableState anchoredDraggableState;
            AnchoredDraggableState anchoredDraggableState2;
            AnchoredDraggableState anchoredDraggableState3;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                long j2 = this.J$0;
                AnchoredDraggableNode<T> anchoredDraggableNode = this.this$0;
                m620toFloatTH1AsA0 = anchoredDraggableNode.m620toFloatTH1AsA0(j2);
                this.J$0 = j2;
                this.label = 1;
                obj = anchoredDraggableNode.fling(m620toFloatTH1AsA0, (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                j = j2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j = this.J$0;
                ResultKt.throwOnFailure(obj);
            }
            float floatValue = ((Number) obj).floatValue();
            anchoredDraggableState = ((AnchoredDraggableNode) this.this$0).state;
            float requireOffset = anchoredDraggableState.requireOffset();
            anchoredDraggableState2 = ((AnchoredDraggableNode) this.this$0).state;
            float minPosition = anchoredDraggableState2.getAnchors().minPosition();
            anchoredDraggableState3 = ((AnchoredDraggableNode) this.this$0).state;
            if (requireOffset >= anchoredDraggableState3.getAnchors().maxPosition() || requireOffset <= minPosition) {
                j = this.this$0.m623toVelocityadjELrA(floatValue);
            }
            return Velocity.box-impl(j);
        }
    }
}
