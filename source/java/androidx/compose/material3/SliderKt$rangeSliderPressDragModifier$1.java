package androidx.compose.material3;

import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.p002ui.geometry.Offset;
import androidx.compose.p002ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p002ui.input.pointer.PointerEventKt;
import androidx.compose.p002ui.input.pointer.PointerInputChange;
import androidx.compose.p002ui.input.pointer.PointerInputScope;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Slider.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1", f = "Slider.kt", i = {}, l = {1496}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class SliderKt$rangeSliderPressDragModifier$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableInteractionSource $endInteractionSource;
    final /* synthetic */ MutableInteractionSource $startInteractionSource;
    final /* synthetic */ RangeSliderState $state;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SliderKt$rangeSliderPressDragModifier$1(RangeSliderState rangeSliderState, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, Continuation<? super SliderKt$rangeSliderPressDragModifier$1> continuation) {
        super(2, continuation);
        this.$state = rangeSliderState;
        this.$startInteractionSource = mutableInteractionSource;
        this.$endInteractionSource = mutableInteractionSource2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> sliderKt$rangeSliderPressDragModifier$1 = new SliderKt$rangeSliderPressDragModifier$1(this.$state, this.$startInteractionSource, this.$endInteractionSource, continuation);
        sliderKt$rangeSliderPressDragModifier$1.L$0 = obj;
        return sliderKt$rangeSliderPressDragModifier$1;
    }

    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return create(pointerInputScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
            RangeSliderLogic rangeSliderLogic = new RangeSliderLogic(this.$state, this.$startInteractionSource, this.$endInteractionSource);
            this.label = 1;
            if (CoroutineScopeKt.coroutineScope(new C06921(pointerInputScope, this.$state, rangeSliderLogic, null), (Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Slider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1", f = "Slider.kt", i = {}, l = {1497}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
    public static final class C06921 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PointerInputScope $$this$pointerInput;
        final /* synthetic */ RangeSliderLogic $rangeSliderLogic;
        final /* synthetic */ RangeSliderState $state;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06921(PointerInputScope pointerInputScope, RangeSliderState rangeSliderState, RangeSliderLogic rangeSliderLogic, Continuation<? super C06921> continuation) {
            super(2, continuation);
            this.$$this$pointerInput = pointerInputScope;
            this.$state = rangeSliderState;
            this.$rangeSliderLogic = rangeSliderLogic;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c06921 = new C06921(this.$$this$pointerInput, this.$state, this.$rangeSliderLogic, continuation);
            c06921.L$0 = obj;
            return c06921;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Slider.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1$1", f = "Slider.kt", i = {0, 1, 1, 1, 1, 1, 2, 2}, l = {1498, 1509, 1528}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "event", "interaction", "posX", "draggingStart", "interaction", "draggingStart"}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1"})
        /* renamed from: androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1$1, reason: invalid class name */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
        public static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ CoroutineScope $$this$coroutineScope;
            final /* synthetic */ RangeSliderLogic $rangeSliderLogic;
            final /* synthetic */ RangeSliderState $state;
            private /* synthetic */ Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(RangeSliderState rangeSliderState, RangeSliderLogic rangeSliderLogic, CoroutineScope coroutineScope, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$state = rangeSliderState;
                this.$rangeSliderLogic = rangeSliderLogic;
                this.$$this$coroutineScope = coroutineScope;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$state, this.$rangeSliderLogic, this.$$this$coroutineScope, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                return create(awaitPointerEventScope, continuation).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x017b A[Catch: CancellationException -> 0x018d, TryCatch #1 {CancellationException -> 0x018d, blocks: (B:8:0x001b, B:9:0x0173, B:11:0x017b, B:15:0x0183), top: B:7:0x001b }] */
            /* JADX WARN: Removed duplicated region for block: B:15:0x0183 A[Catch: CancellationException -> 0x018d, TRY_LEAVE, TryCatch #1 {CancellationException -> 0x018d, blocks: (B:8:0x001b, B:9:0x0173, B:11:0x017b, B:15:0x0183), top: B:7:0x001b }] */
            /* JADX WARN: Removed duplicated region for block: B:23:0x00df  */
            /* JADX WARN: Removed duplicated region for block: B:42:0x0170 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:43:0x0171  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object obj) {
                AwaitPointerEventScope awaitPointerEventScope;
                PointerInputChange pointerInputChange;
                Object m2930awaitSlop8vUncbI;
                DragInteraction.Start start;
                Ref.FloatRef floatRef;
                final Ref.BooleanRef booleanRef;
                Pair pair;
                Ref.BooleanRef booleanRef2;
                DragInteraction.Start start2;
                DragInteraction.Cancel cancel;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                boolean z = false;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                    this.L$0 = awaitPointerEventScope2;
                    this.label = 1;
                    Object awaitFirstDown$default = TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope2, false, null, (Continuation) this, 2, null);
                    if (awaitFirstDown$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    awaitPointerEventScope = awaitPointerEventScope2;
                    obj = awaitFirstDown$default;
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            booleanRef2 = (Ref.BooleanRef) this.L$1;
                            start2 = (DragInteraction.Start) this.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                if (!((Boolean) obj).booleanValue()) {
                                    cancel = new DragInteraction.Stop(start2);
                                } else {
                                    cancel = new DragInteraction.Cancel(start2);
                                }
                            } catch (CancellationException unused) {
                                cancel = new DragInteraction.Cancel(start2);
                                this.$state.getGestureEndAction$material3_release().invoke(Boxing.boxBoolean(booleanRef2.element));
                                BuildersKt.launch$default(this.$$this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass2(this.$rangeSliderLogic, booleanRef2, cancel, null), 3, (Object) null);
                                return Unit.INSTANCE;
                            }
                            this.$state.getGestureEndAction$material3_release().invoke(Boxing.boxBoolean(booleanRef2.element));
                            BuildersKt.launch$default(this.$$this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass2(this.$rangeSliderLogic, booleanRef2, cancel, null), 3, (Object) null);
                            return Unit.INSTANCE;
                        }
                        booleanRef = (Ref.BooleanRef) this.L$4;
                        floatRef = (Ref.FloatRef) this.L$3;
                        start = (DragInteraction.Start) this.L$2;
                        pointerInputChange = (PointerInputChange) this.L$1;
                        awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        pair = (Pair) obj;
                        if (pair != null) {
                            RangeSliderState rangeSliderState = this.$state;
                            float m2545pointerSlopE8SPZFQ = DragGestureDetectorCopyKt.m2545pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), pointerInputChange.getType());
                            if (Math.abs(rangeSliderState.getRawOffsetEnd$material3_release() - floatRef.element) < m2545pointerSlopE8SPZFQ && Math.abs(rangeSliderState.getRawOffsetStart$material3_release() - floatRef.element) < m2545pointerSlopE8SPZFQ) {
                                float floatValue = ((Number) pair.getSecond()).floatValue();
                                if (!rangeSliderState.isRtl$material3_release() ? floatValue < 0.0f : floatValue >= 0.0f) {
                                    z = true;
                                }
                                booleanRef.element = z;
                                floatRef.element += Offset.m4593getXimpl(PointerEventKt.positionChange((PointerInputChange) pair.getFirst()));
                            }
                        }
                        this.$rangeSliderLogic.captureThumb(booleanRef.element, floatRef.element, start, this.$$this$coroutineScope);
                        try {
                            long id = pointerInputChange.getId();
                            final RangeSliderState rangeSliderState2 = this.$state;
                            this.L$0 = start;
                            this.L$1 = booleanRef;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.L$4 = null;
                            this.label = 3;
                            obj = DragGestureDetectorKt.m683horizontalDragjO51t88(awaitPointerEventScope, id, new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1$1$finishInteraction$success$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                    invoke((PointerInputChange) obj2);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(PointerInputChange pointerInputChange2) {
                                    float m4593getXimpl = Offset.m4593getXimpl(PointerEventKt.positionChange(pointerInputChange2));
                                    RangeSliderState rangeSliderState3 = RangeSliderState.this;
                                    boolean z2 = booleanRef.element;
                                    if (RangeSliderState.this.isRtl$material3_release()) {
                                        m4593getXimpl = -m4593getXimpl;
                                    }
                                    rangeSliderState3.onDrag$material3_release(z2, m4593getXimpl);
                                }
                            }, (Continuation) this);
                        } catch (CancellationException unused2) {
                            booleanRef2 = booleanRef;
                            start2 = start;
                            cancel = new DragInteraction.Cancel(start2);
                            this.$state.getGestureEndAction$material3_release().invoke(Boxing.boxBoolean(booleanRef2.element));
                            BuildersKt.launch$default(this.$$this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass2(this.$rangeSliderLogic, booleanRef2, cancel, null), 3, (Object) null);
                            return Unit.INSTANCE;
                        }
                        if (obj != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        booleanRef2 = booleanRef;
                        start2 = start;
                        if (!((Boolean) obj).booleanValue()) {
                        }
                        this.$state.getGestureEndAction$material3_release().invoke(Boxing.boxBoolean(booleanRef2.element));
                        BuildersKt.launch$default(this.$$this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass2(this.$rangeSliderLogic, booleanRef2, cancel, null), 3, (Object) null);
                        return Unit.INSTANCE;
                    }
                    AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    awaitPointerEventScope = awaitPointerEventScope3;
                }
                pointerInputChange = (PointerInputChange) obj;
                DragInteraction.Start start3 = new DragInteraction.Start();
                Ref.FloatRef floatRef2 = new Ref.FloatRef();
                floatRef2.element = this.$state.isRtl$material3_release() ? this.$state.getTotalWidth$material3_release() - Offset.m4593getXimpl(pointerInputChange.getPosition()) : Offset.m4593getXimpl(pointerInputChange.getPosition());
                int compareOffsets = this.$rangeSliderLogic.compareOffsets(floatRef2.element);
                Ref.BooleanRef booleanRef3 = new Ref.BooleanRef();
                booleanRef3.element = compareOffsets == 0 ? this.$state.getRawOffsetStart$material3_release() > floatRef2.element : compareOffsets < 0;
                this.L$0 = awaitPointerEventScope;
                this.L$1 = pointerInputChange;
                this.L$2 = start3;
                this.L$3 = floatRef2;
                this.L$4 = booleanRef3;
                this.label = 2;
                m2930awaitSlop8vUncbI = SliderKt.m2930awaitSlop8vUncbI(awaitPointerEventScope, pointerInputChange.getId(), pointerInputChange.getType(), (Continuation) this);
                if (m2930awaitSlop8vUncbI == coroutine_suspended) {
                    return coroutine_suspended;
                }
                start = start3;
                obj = m2930awaitSlop8vUncbI;
                floatRef = floatRef2;
                booleanRef = booleanRef3;
                pair = (Pair) obj;
                if (pair != null) {
                }
                this.$rangeSliderLogic.captureThumb(booleanRef.element, floatRef.element, start, this.$$this$coroutineScope);
                long id2 = pointerInputChange.getId();
                final RangeSliderState rangeSliderState22 = this.$state;
                this.L$0 = start;
                this.L$1 = booleanRef;
                this.L$2 = null;
                this.L$3 = null;
                this.L$4 = null;
                this.label = 3;
                obj = DragGestureDetectorKt.m683horizontalDragjO51t88(awaitPointerEventScope, id2, new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1$1$finishInteraction$success$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        invoke((PointerInputChange) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(PointerInputChange pointerInputChange2) {
                        float m4593getXimpl = Offset.m4593getXimpl(PointerEventKt.positionChange(pointerInputChange2));
                        RangeSliderState rangeSliderState3 = RangeSliderState.this;
                        boolean z2 = booleanRef.element;
                        if (RangeSliderState.this.isRtl$material3_release()) {
                            m4593getXimpl = -m4593getXimpl;
                        }
                        rangeSliderState3.onDrag$material3_release(z2, m4593getXimpl);
                    }
                }, (Continuation) this);
                if (obj != coroutine_suspended) {
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: Slider.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1$1$2", f = "Slider.kt", i = {}, l = {1545}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1$1$2, reason: invalid class name */
            /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
            public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Ref.BooleanRef $draggingStart;
                final /* synthetic */ DragInteraction $finishInteraction;
                final /* synthetic */ RangeSliderLogic $rangeSliderLogic;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass2(RangeSliderLogic rangeSliderLogic, Ref.BooleanRef booleanRef, DragInteraction dragInteraction, Continuation<? super AnonymousClass2> continuation) {
                    super(2, continuation);
                    this.$rangeSliderLogic = rangeSliderLogic;
                    this.$draggingStart = booleanRef;
                    this.$finishInteraction = dragInteraction;
                }

                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass2(this.$rangeSliderLogic, this.$draggingStart, this.$finishInteraction, continuation);
                }

                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                }

                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        if (this.$rangeSliderLogic.activeInteraction(this.$draggingStart.element).emit(this.$finishInteraction, (Continuation) this) == coroutine_suspended) {
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
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                this.label = 1;
                if (ForEachGestureKt.awaitEachGesture(this.$$this$pointerInput, new AnonymousClass1(this.$state, this.$rangeSliderLogic, coroutineScope, null), (Continuation) this) == coroutine_suspended) {
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
    }
}
