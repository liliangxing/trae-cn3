package androidx.compose.foundation.gestures;

import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.p002ui.geometry.Offset;
import androidx.compose.p002ui.input.pointer.PointerInputChange;
import androidx.compose.p002ui.input.pointer.PointerInputEventHandler;
import androidx.compose.p002ui.input.pointer.PointerInputScope;
import androidx.compose.p002ui.input.pointer.util.VelocityTracker;
import androidx.compose.p002ui.input.pointer.util.VelocityTrackerKt;
import androidx.compose.p002ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.unit.VelocityKt;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Draggable.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class DragGestureNode$initializePointerInputNode$1 implements PointerInputEventHandler {
    final /* synthetic */ DragGestureNode this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DragGestureNode$initializePointerInputNode$1(DragGestureNode dragGestureNode) {
        this.this$0 = dragGestureNode;
    }

    @Override // androidx.compose.p002ui.input.pointer.PointerInputEventHandler
    public final Object invoke(final PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        long m4609getZeroF1C5BW0;
        final VelocityTracker velocityTracker = new VelocityTracker();
        final Ref.LongRef longRef = new Ref.LongRef();
        if (ComposeFoundationFlags.isAdjustPointerInputChangeOffsetForVelocityTrackerEnabled) {
            m4609getZeroF1C5BW0 = LayoutCoordinatesKt.positionOnScreen(DelegatableNodeKt.requireLayoutCoordinates(this.this$0));
        } else {
            m4609getZeroF1C5BW0 = Offset.INSTANCE.m4609getZeroF1C5BW0();
        }
        longRef.element = m4609getZeroF1C5BW0;
        final DragGestureNode dragGestureNode = this.this$0;
        Function3 function3 = new Function3() { // from class: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit invoke$lambda$0;
                invoke$lambda$0 = DragGestureNode$initializePointerInputNode$1.invoke$lambda$0(DragGestureNode.this, velocityTracker, (PointerInputChange) obj, (PointerInputChange) obj2, (Offset) obj3);
                return invoke$lambda$0;
            }
        };
        final DragGestureNode dragGestureNode2 = this.this$0;
        Function1 function1 = new Function1() { // from class: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit invoke$lambda$1;
                invoke$lambda$1 = DragGestureNode$initializePointerInputNode$1.invoke$lambda$1(VelocityTracker.this, pointerInputScope, dragGestureNode2, (PointerInputChange) obj);
                return invoke$lambda$1;
            }
        };
        final DragGestureNode dragGestureNode3 = this.this$0;
        Function0 function0 = new Function0() { // from class: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$$ExternalSyntheticLambda2
            public final Object invoke() {
                Unit invoke$lambda$2;
                invoke$lambda$2 = DragGestureNode$initializePointerInputNode$1.invoke$lambda$2(DragGestureNode.this);
                return invoke$lambda$2;
            }
        };
        final DragGestureNode dragGestureNode4 = this.this$0;
        Function0 function02 = new Function0() { // from class: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$$ExternalSyntheticLambda3
            public final Object invoke() {
                boolean invoke$lambda$3;
                invoke$lambda$3 = DragGestureNode$initializePointerInputNode$1.invoke$lambda$3(DragGestureNode.this);
                return Boolean.valueOf(invoke$lambda$3);
            }
        };
        final DragGestureNode dragGestureNode5 = this.this$0;
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new C02671(pointerInputScope, this.this$0, function3, function1, function0, function02, new Function2() { // from class: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$$ExternalSyntheticLambda4
            public final Object invoke(Object obj, Object obj2) {
                Unit invoke$lambda$4;
                invoke$lambda$4 = DragGestureNode$initializePointerInputNode$1.invoke$lambda$4(DragGestureNode.this, longRef, velocityTracker, (PointerInputChange) obj, (Offset) obj2);
                return invoke$lambda$4;
            }
        }, null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$0(DragGestureNode dragGestureNode, VelocityTracker velocityTracker, PointerInputChange pointerInputChange, PointerInputChange pointerInputChange2, Offset offset) {
        boolean z;
        Channel channel;
        Channel channel2;
        dragGestureNode.nodeOffset = Offset.INSTANCE.m4609getZeroF1C5BW0();
        if (((Boolean) dragGestureNode.getCanDrag().invoke(pointerInputChange)).booleanValue()) {
            z = dragGestureNode.isListeningForEvents;
            if (!z) {
                channel2 = dragGestureNode.channel;
                if (channel2 == null) {
                    dragGestureNode.channel = ChannelKt.Channel$default(Integer.MAX_VALUE, (BufferOverflow) null, (Function1) null, 6, (Object) null);
                }
                dragGestureNode.startListeningForEvents();
            }
            VelocityTrackerKt.addPointerInputChange(velocityTracker, pointerInputChange);
            long m4597minusMKHz9U = Offset.m4597minusMKHz9U(pointerInputChange2.getPosition(), offset.m4603unboximpl());
            channel = dragGestureNode.channel;
            if (channel != null) {
                ChannelResult.box-impl(channel.trySend-JP2dKIU(new DragEvent.DragStarted(m4597minusMKHz9U, null)));
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1(VelocityTracker velocityTracker, PointerInputScope pointerInputScope, DragGestureNode dragGestureNode, PointerInputChange pointerInputChange) {
        Channel channel;
        long m700toValidVelocityTH1AsA0;
        VelocityTrackerKt.addPointerInputChange(velocityTracker, pointerInputChange);
        float maximumFlingVelocity = pointerInputScope.getViewConfiguration().getMaximumFlingVelocity();
        long m6259calculateVelocityAH228Gc = velocityTracker.m6259calculateVelocityAH228Gc(VelocityKt.Velocity(maximumFlingVelocity, maximumFlingVelocity));
        velocityTracker.resetTracking();
        channel = dragGestureNode.channel;
        if (channel != null) {
            m700toValidVelocityTH1AsA0 = DraggableKt.m700toValidVelocityTH1AsA0(m6259calculateVelocityAH228Gc);
            ChannelResult.box-impl(channel.trySend-JP2dKIU(new DragEvent.DragStopped(m700toValidVelocityTH1AsA0, null)));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$2(DragGestureNode dragGestureNode) {
        Channel channel;
        channel = dragGestureNode.channel;
        if (channel != null) {
            ChannelResult.box-impl(channel.trySend-JP2dKIU(DragEvent.DragCancelled.INSTANCE));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invoke$lambda$3(DragGestureNode dragGestureNode) {
        return !dragGestureNode.getStartDragImmediately();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$4(DragGestureNode dragGestureNode, Ref.LongRef longRef, VelocityTracker velocityTracker, PointerInputChange pointerInputChange, Offset offset) {
        long j;
        Channel channel;
        long j2;
        if (ComposeFoundationFlags.isAdjustPointerInputChangeOffsetForVelocityTrackerEnabled) {
            long positionOnScreen = LayoutCoordinatesKt.positionOnScreen(DelegatableNodeKt.requireLayoutCoordinates((DelegatableNode) dragGestureNode));
            if (!Offset.m4590equalsimpl0(positionOnScreen, longRef.element)) {
                long m4597minusMKHz9U = Offset.m4597minusMKHz9U(positionOnScreen, longRef.element);
                j2 = dragGestureNode.nodeOffset;
                dragGestureNode.nodeOffset = Offset.m4598plusMKHz9U(j2, m4597minusMKHz9U);
            }
            longRef.element = positionOnScreen;
        }
        j = dragGestureNode.nodeOffset;
        VelocityTrackerKt.m6262addPointerInputChange0AR0LA0(velocityTracker, pointerInputChange, j);
        channel = dragGestureNode.channel;
        if (channel != null) {
            ChannelResult.box-impl(channel.trySend-JP2dKIU(new DragEvent.DragDelta(offset.m4603unboximpl(), null)));
        }
        return Unit.INSTANCE;
    }

    /* compiled from: Draggable.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$1", f = "Draggable.kt", i = {0}, l = {543}, m = "invokeSuspend", n = {"$this$coroutineScope"}, s = {"L$0"})
    /* renamed from: androidx.compose.foundation.gestures.DragGestureNode$initializePointerInputNode$1$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
    static final class C02671 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<PointerInputChange, Offset, Unit> $onDrag;
        final /* synthetic */ Function0<Unit> $onDragCancel;
        final /* synthetic */ Function1<PointerInputChange, Unit> $onDragEnd;
        final /* synthetic */ Function3<PointerInputChange, PointerInputChange, Offset, Unit> $onDragStart;
        final /* synthetic */ Function0<Boolean> $shouldAwaitTouchSlop;
        final /* synthetic */ PointerInputScope $this_SuspendingPointerInputModifierNode;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DragGestureNode this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C02671(PointerInputScope pointerInputScope, DragGestureNode dragGestureNode, Function3<? super PointerInputChange, ? super PointerInputChange, ? super Offset, Unit> function3, Function1<? super PointerInputChange, Unit> function1, Function0<Unit> function0, Function0<Boolean> function02, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super C02671> continuation) {
            super(2, continuation);
            this.$this_SuspendingPointerInputModifierNode = pointerInputScope;
            this.this$0 = dragGestureNode;
            this.$onDragStart = function3;
            this.$onDragEnd = function1;
            this.$onDragCancel = function0;
            this.$shouldAwaitTouchSlop = function02;
            this.$onDrag = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c02671 = new C02671(this.$this_SuspendingPointerInputModifierNode, this.this$0, this.$onDragStart, this.$onDragEnd, this.$onDragCancel, this.$shouldAwaitTouchSlop, this.$onDrag, continuation);
            c02671.L$0 = obj;
            return c02671;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0050  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0062  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope;
            CancellationException e;
            Orientation orientation;
            Channel channel;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                try {
                    PointerInputScope pointerInputScope = this.$this_SuspendingPointerInputModifierNode;
                    orientation = this.this$0.orientationLock;
                    this.L$0 = coroutineScope2;
                    this.label = 1;
                    if (DragGestureDetectorKt.detectDragGestures(pointerInputScope, orientation, this.$onDragStart, this.$onDragEnd, this.$onDragCancel, this.$shouldAwaitTouchSlop, this.$onDrag, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } catch (CancellationException e2) {
                    coroutineScope = coroutineScope2;
                    e = e2;
                    channel = this.this$0.channel;
                    if (channel != null) {
                    }
                    if (!CoroutineScopeKt.isActive(coroutineScope)) {
                    }
                    return Unit.INSTANCE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                coroutineScope = (CoroutineScope) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (CancellationException e3) {
                    e = e3;
                    channel = this.this$0.channel;
                    if (channel != null) {
                        ChannelResult.box-impl(channel.trySend-JP2dKIU(DragEvent.DragCancelled.INSTANCE));
                    }
                    if (!CoroutineScopeKt.isActive(coroutineScope)) {
                        throw e;
                    }
                    return Unit.INSTANCE;
                }
            }
            return Unit.INSTANCE;
        }
    }
}
