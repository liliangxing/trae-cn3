package androidx.compose.material3;

import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.p002ui.geometry.Offset;
import androidx.compose.p002ui.input.pointer.PointerInputChange;
import androidx.compose.p002ui.input.pointer.PointerInputScope;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TimePicker.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.ClockDialNode$pointerInputDragNode$1", f = "TimePicker.kt", i = {}, l = {1292}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class ClockDialNode$pointerInputDragNode$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ClockDialNode this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClockDialNode$pointerInputDragNode$1(ClockDialNode clockDialNode, Continuation<? super ClockDialNode$pointerInputDragNode$1> continuation) {
        super(2, continuation);
        this.this$0 = clockDialNode;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> clockDialNode$pointerInputDragNode$1 = new ClockDialNode$pointerInputDragNode$1(this.this$0, continuation);
        clockDialNode$pointerInputDragNode$1.L$0 = obj;
        return clockDialNode$pointerInputDragNode$1;
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
            final ClockDialNode clockDialNode = this.this$0;
            Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.material3.ClockDialNode$pointerInputDragNode$1.1
                {
                    super(0);
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: TimePicker.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "androidx.compose.material3.ClockDialNode$pointerInputDragNode$1$1$1", f = "TimePicker.kt", i = {}, l = {1296, 1298}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: androidx.compose.material3.ClockDialNode$pointerInputDragNode$1$1$1, reason: invalid class name */
                /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    int label;
                    final /* synthetic */ ClockDialNode this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(ClockDialNode clockDialNode, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.this$0 = clockDialNode;
                    }

                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.this$0, continuation);
                    }

                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                    }

                    public final Object invokeSuspend(Object obj) {
                        TimePickerState timePickerState;
                        TimePickerState timePickerState2;
                        TimePickerState timePickerState3;
                        boolean z;
                        TimePickerState timePickerState4;
                        TimePickerState timePickerState5;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            timePickerState = this.this$0.state;
                            if (Selection.m2900equalsimpl0(timePickerState.m3255getSelectionJiIwxys$material3_release(), Selection.INSTANCE.m2904getHourJiIwxys())) {
                                z = this.this$0.autoSwitchToMinute;
                                if (z) {
                                    timePickerState4 = this.this$0.state;
                                    timePickerState4.m3258setSelectioniHAOin8$material3_release(Selection.INSTANCE.m2905getMinuteJiIwxys());
                                    timePickerState5 = this.this$0.state;
                                    this.label = 1;
                                    if (timePickerState5.animateToCurrent$material3_release((Continuation) this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            }
                            timePickerState2 = this.this$0.state;
                            if (Selection.m2900equalsimpl0(timePickerState2.m3255getSelectionJiIwxys$material3_release(), Selection.INSTANCE.m2905getMinuteJiIwxys())) {
                                timePickerState3 = this.this$0.state;
                                this.label = 2;
                                if (timePickerState3.settle((Continuation) this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                        } else {
                            if (i != 1 && i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        return Unit.INSTANCE;
                    }
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m2334invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2334invoke() {
                    BuildersKt.launch$default(ClockDialNode.this.getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(ClockDialNode.this, null), 3, (Object) null);
                }
            };
            final ClockDialNode clockDialNode2 = this.this$0;
            this.label = 1;
            if (DragGestureDetectorKt.detectDragGestures$default(pointerInputScope, null, function0, null, new Function2<PointerInputChange, Offset, Unit>() { // from class: androidx.compose.material3.ClockDialNode$pointerInputDragNode$1.2
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    m2335invokeUv8p0NA((PointerInputChange) obj2, ((Offset) obj3).m4603unboximpl());
                    return Unit.INSTANCE;
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: TimePicker.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "androidx.compose.material3.ClockDialNode$pointerInputDragNode$1$2$1", f = "TimePicker.kt", i = {}, l = {1305}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: androidx.compose.material3.ClockDialNode$pointerInputDragNode$1$2$1, reason: invalid class name */
                /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ long $dragAmount;
                    int label;
                    final /* synthetic */ ClockDialNode this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(ClockDialNode clockDialNode, long j, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.this$0 = clockDialNode;
                        this.$dragAmount = j;
                    }

                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.this$0, this.$dragAmount, continuation);
                    }

                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                    }

                    public final Object invokeSuspend(Object obj) {
                        float f;
                        float f2;
                        TimePickerState timePickerState;
                        float f3;
                        TimePickerState timePickerState2;
                        float f4;
                        TimePickerState timePickerState3;
                        float atan;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            ClockDialNode clockDialNode = this.this$0;
                            f = clockDialNode.offsetX;
                            clockDialNode.offsetX = f + Offset.m4593getXimpl(this.$dragAmount);
                            ClockDialNode clockDialNode2 = this.this$0;
                            f2 = clockDialNode2.offsetY;
                            clockDialNode2.offsetY = f2 + Offset.m4594getYimpl(this.$dragAmount);
                            timePickerState = this.this$0.state;
                            f3 = this.this$0.offsetY;
                            timePickerState2 = this.this$0.state;
                            float f5 = f3 - IntOffset.getY-impl(timePickerState2.m3254getCenternOccac$material3_release());
                            f4 = this.this$0.offsetX;
                            timePickerState3 = this.this$0.state;
                            atan = TimePickerKt.atan(f5, f4 - IntOffset.getX-impl(timePickerState3.m3254getCenternOccac$material3_release()));
                            this.label = 1;
                            if (TimePickerState.update$material3_release$default(timePickerState, atan, false, (Continuation) this, 2, null) == coroutine_suspended) {
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

                /* renamed from: invoke-Uv8p0NA, reason: not valid java name */
                public final void m2335invokeUv8p0NA(PointerInputChange pointerInputChange, long j) {
                    TimePickerState timePickerState;
                    float f;
                    float f2;
                    float maxDist;
                    BuildersKt.launch$default(ClockDialNode.this.getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(ClockDialNode.this, j, null), 3, (Object) null);
                    timePickerState = ClockDialNode.this.state;
                    f = ClockDialNode.this.offsetX;
                    f2 = ClockDialNode.this.offsetY;
                    maxDist = ClockDialNode.this.getMaxDist();
                    timePickerState.moveSelector$material3_release(f, f2, maxDist);
                }
            }, (Continuation) this, 5, null) == coroutine_suspended) {
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
