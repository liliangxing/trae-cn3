package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.LongPressResult;
import androidx.compose.p002ui.geometry.Offset;
import androidx.compose.p002ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p002ui.input.pointer.PointerInputChange;
import androidx.compose.p002ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TapGestureDetector.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2", f = "TapGestureDetector.kt", i = {}, l = {104}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class TapGestureDetectorKt$detectTapGestures$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Offset, Unit> $onDoubleTap;
    final /* synthetic */ Function1<Offset, Unit> $onLongPress;
    final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
    final /* synthetic */ Function1<Offset, Unit> $onTap;
    final /* synthetic */ PointerInputScope $this_detectTapGestures;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TapGestureDetectorKt$detectTapGestures$2(PointerInputScope pointerInputScope, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function1<? super Offset, Unit> function1, Function1<? super Offset, Unit> function12, Function1<? super Offset, Unit> function13, Continuation<? super TapGestureDetectorKt$detectTapGestures$2> continuation) {
        super(2, continuation);
        this.$this_detectTapGestures = pointerInputScope;
        this.$onPress = function3;
        this.$onLongPress = function1;
        this.$onDoubleTap = function12;
        this.$onTap = function13;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> tapGestureDetectorKt$detectTapGestures$2 = new TapGestureDetectorKt$detectTapGestures$2(this.$this_detectTapGestures, this.$onPress, this.$onLongPress, this.$onDoubleTap, this.$onTap, continuation);
        tapGestureDetectorKt$detectTapGestures$2.L$0 = obj;
        return tapGestureDetectorKt$detectTapGestures$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            PressGestureScopeImpl pressGestureScopeImpl = new PressGestureScopeImpl(this.$this_detectTapGestures);
            this.label = 1;
            if (ForEachGestureKt.awaitEachGesture(this.$this_detectTapGestures, new C02751(coroutineScope, this.$onPress, this.$onLongPress, this.$onDoubleTap, this.$onTap, pressGestureScopeImpl, null), (Continuation) this) == coroutine_suspended) {
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
    /* compiled from: TapGestureDetector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1", f = "TapGestureDetector.kt", i = {0, 1, 1, 2, 2, 2, 3, 4, 4, 4, 5, 5, 6, 6, 6, 6, 7}, l = {105, 116, 119, 122, 149, 167, 169, 180}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "resetJob", "$this$awaitEachGesture", "down", "resetJob", "resetJob", "$this$awaitEachGesture", "upOrCancel", "cancelOrReleaseJob", "resetJob", "upOrCancel", "$this$awaitEachGesture", "resetJob", "upOrCancel", "secondDown", "resetJob"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$0", "L$1", "L$2", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$0"})
    /* renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
    public static final class C02751 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CoroutineScope $$this$coroutineScope;
        final /* synthetic */ Function1<Offset, Unit> $onDoubleTap;
        final /* synthetic */ Function1<Offset, Unit> $onLongPress;
        final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
        final /* synthetic */ Function1<Offset, Unit> $onTap;
        final /* synthetic */ PressGestureScopeImpl $pressScope;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C02751(CoroutineScope coroutineScope, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function1<? super Offset, Unit> function1, Function1<? super Offset, Unit> function12, Function1<? super Offset, Unit> function13, PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super C02751> continuation) {
            super(2, continuation);
            this.$$this$coroutineScope = coroutineScope;
            this.$onPress = function3;
            this.$onLongPress = function1;
            this.$onDoubleTap = function12;
            this.$onTap = function13;
            this.$pressScope = pressGestureScopeImpl;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c02751 = new C02751(this.$$this$coroutineScope, this.$onPress, this.$onLongPress, this.$onDoubleTap, this.$onTap, this.$pressScope, continuation);
            c02751.L$0 = obj;
            return c02751;
        }

        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return create(awaitPointerEventScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000a. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0244  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x027d  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0293  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x02b6  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x01c0  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x01d1  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x011f  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x0155  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x0168  */
        /* JADX WARN: Removed duplicated region for block: B:69:0x0194  */
        /* JADX WARN: Removed duplicated region for block: B:77:0x017c  */
        /* JADX WARN: Removed duplicated region for block: B:88:0x00d1  */
        /* JADX WARN: Removed duplicated region for block: B:91:0x00ed  */
        /* JADX WARN: Removed duplicated region for block: B:94:0x0102  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            AwaitPointerEventScope awaitPointerEventScope;
            Object awaitFirstDown$default;
            AwaitPointerEventScope awaitPointerEventScope2;
            PointerInputChange pointerInputChange;
            CoroutineStart coroutineStartForCurrentDispatchBehavior;
            Job launch$default;
            Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> function3;
            Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> function32;
            Object waitForLongPress$default;
            Object waitForUpOrCancellation$default;
            PointerInputChange pointerInputChange2;
            Job launchAwaitingReset$default;
            Object awaitSecondDown;
            LongPressResult longPressResult;
            Object consumeUntilUp;
            Job job;
            PointerInputChange pointerInputChange3;
            CoroutineStart coroutineStartForCurrentDispatchBehavior2;
            Job launch$default2;
            Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> function33;
            Object waitForLongPress$default2;
            Object waitForUpOrCancellation$default2;
            PointerInputChange pointerInputChange4;
            PointerInputChange pointerInputChange5;
            Job job2;
            LongPressResult longPressResult2;
            Object consumeUntilUp2;
            Job job3;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                    this.L$0 = awaitPointerEventScope;
                    this.label = 1;
                    awaitFirstDown$default = TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope, false, null, (Continuation) this, 3, null);
                    if (awaitFirstDown$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    awaitPointerEventScope2 = awaitPointerEventScope;
                    pointerInputChange = (PointerInputChange) awaitFirstDown$default;
                    pointerInputChange.consume();
                    CoroutineScope coroutineScope = this.$$this$coroutineScope;
                    coroutineStartForCurrentDispatchBehavior = TapGestureDetectorKt.getCoroutineStartForCurrentDispatchBehavior();
                    launch$default = BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, coroutineStartForCurrentDispatchBehavior, new TapGestureDetectorKt$detectTapGestures$2$1$resetJob$1(this.$pressScope, null), 1, (Object) null);
                    function3 = this.$onPress;
                    function32 = TapGestureDetectorKt.NoPressGesture;
                    if (function3 != function32) {
                        TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, launch$default, null, new AnonymousClass1(this.$onPress, this.$pressScope, pointerInputChange, null), 2, null);
                    }
                    if (this.$onLongPress == null) {
                        this.L$0 = awaitPointerEventScope2;
                        this.L$1 = pointerInputChange;
                        this.L$2 = launch$default;
                        this.label = 3;
                        waitForLongPress$default = TapGestureDetectorKt.waitForLongPress$default(awaitPointerEventScope2, null, (Continuation) this, 1, null);
                        if (waitForLongPress$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        longPressResult = (LongPressResult) waitForLongPress$default;
                        if (Intrinsics.areEqual(longPressResult, LongPressResult.Success.INSTANCE)) {
                            if (longPressResult instanceof LongPressResult.Released) {
                                pointerInputChange2 = ((LongPressResult.Released) longPressResult).getFinalUpChange();
                            } else {
                                if (!(longPressResult instanceof LongPressResult.Canceled)) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                pointerInputChange2 = null;
                            }
                            Job job4 = launch$default;
                            if (pointerInputChange2 == null) {
                            }
                            if (pointerInputChange2 != null) {
                            }
                            return Unit.INSTANCE;
                        }
                        this.$onLongPress.invoke(Offset.m4582boximpl(pointerInputChange.getPosition()));
                        this.L$0 = launch$default;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.label = 4;
                        consumeUntilUp = TapGestureDetectorKt.consumeUntilUp(awaitPointerEventScope2, (Continuation) this);
                        if (consumeUntilUp == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        job = launch$default;
                        TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job, null, new AnonymousClass2(this.$pressScope, null), 2, null);
                        return Unit.INSTANCE;
                    }
                    this.L$0 = awaitPointerEventScope2;
                    this.L$1 = launch$default;
                    this.label = 2;
                    waitForUpOrCancellation$default = TapGestureDetectorKt.waitForUpOrCancellation$default(awaitPointerEventScope2, null, (Continuation) this, 1, null);
                    if (waitForUpOrCancellation$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    pointerInputChange2 = (PointerInputChange) waitForUpOrCancellation$default;
                    Job job42 = launch$default;
                    if (pointerInputChange2 == null) {
                        launchAwaitingReset$default = TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job42, null, new AnonymousClass3(this.$pressScope, null), 2, null);
                    } else {
                        pointerInputChange2.consume();
                        launchAwaitingReset$default = TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job42, null, new AnonymousClass4(this.$pressScope, null), 2, null);
                    }
                    if (pointerInputChange2 != null) {
                        if (this.$onDoubleTap == null) {
                            Function1<Offset, Unit> function1 = this.$onTap;
                            if (function1 != null) {
                                function1.invoke(Offset.m4582boximpl(pointerInputChange2.getPosition()));
                            }
                        } else {
                            this.L$0 = awaitPointerEventScope2;
                            this.L$1 = pointerInputChange2;
                            this.L$2 = launchAwaitingReset$default;
                            this.label = 5;
                            awaitSecondDown = TapGestureDetectorKt.awaitSecondDown(awaitPointerEventScope2, pointerInputChange2, (Continuation) this);
                            if (awaitSecondDown == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            pointerInputChange3 = (PointerInputChange) awaitSecondDown;
                            if (pointerInputChange3 != null) {
                                Function1<Offset, Unit> function12 = this.$onTap;
                                if (function12 != null) {
                                    function12.invoke(Offset.m4582boximpl(pointerInputChange2.getPosition()));
                                }
                            } else {
                                CoroutineScope coroutineScope2 = this.$$this$coroutineScope;
                                coroutineStartForCurrentDispatchBehavior2 = TapGestureDetectorKt.getCoroutineStartForCurrentDispatchBehavior();
                                launch$default2 = BuildersKt.launch$default(coroutineScope2, (CoroutineContext) null, coroutineStartForCurrentDispatchBehavior2, new AnonymousClass5(launchAwaitingReset$default, this.$pressScope, null), 1, (Object) null);
                                Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> function34 = this.$onPress;
                                function33 = TapGestureDetectorKt.NoPressGesture;
                                if (function34 != function33) {
                                    TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, launch$default2, null, new AnonymousClass6(this.$onPress, this.$pressScope, pointerInputChange3, null), 2, null);
                                }
                                if (this.$onLongPress == null) {
                                    this.L$0 = launch$default2;
                                    this.L$1 = pointerInputChange2;
                                    this.L$2 = null;
                                    this.label = 6;
                                    waitForUpOrCancellation$default2 = TapGestureDetectorKt.waitForUpOrCancellation$default(awaitPointerEventScope2, null, (Continuation) this, 1, null);
                                    if (waitForUpOrCancellation$default2 == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    pointerInputChange4 = pointerInputChange2;
                                    pointerInputChange5 = (PointerInputChange) waitForUpOrCancellation$default2;
                                    job2 = launch$default2;
                                    if (pointerInputChange5 != null) {
                                        pointerInputChange5.consume();
                                        TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job2, null, new AnonymousClass7(this.$pressScope, null), 2, null);
                                        this.$onDoubleTap.invoke(Offset.m4582boximpl(pointerInputChange5.getPosition()));
                                    } else {
                                        TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job2, null, new AnonymousClass8(this.$pressScope, null), 2, null);
                                        Function1<Offset, Unit> function13 = this.$onTap;
                                        if (function13 != null) {
                                            function13.invoke(Offset.m4582boximpl(pointerInputChange4.getPosition()));
                                        }
                                    }
                                } else {
                                    this.L$0 = awaitPointerEventScope2;
                                    this.L$1 = launch$default2;
                                    this.L$2 = pointerInputChange2;
                                    this.L$3 = pointerInputChange3;
                                    this.label = 7;
                                    waitForLongPress$default2 = TapGestureDetectorKt.waitForLongPress$default(awaitPointerEventScope2, null, (Continuation) this, 1, null);
                                    if (waitForLongPress$default2 == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    longPressResult2 = (LongPressResult) waitForLongPress$default2;
                                    if (!Intrinsics.areEqual(longPressResult2, LongPressResult.Success.INSTANCE)) {
                                        this.$onLongPress.invoke(Offset.m4582boximpl(pointerInputChange3.getPosition()));
                                        this.L$0 = launch$default2;
                                        this.L$1 = null;
                                        this.L$2 = null;
                                        this.L$3 = null;
                                        this.label = 8;
                                        consumeUntilUp2 = TapGestureDetectorKt.consumeUntilUp(awaitPointerEventScope2, (Continuation) this);
                                        if (consumeUntilUp2 == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        job3 = launch$default2;
                                        TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job3, null, new TapGestureDetectorKt$detectTapGestures$2$1$secondUp$1(this.$pressScope, null), 2, null);
                                        return Unit.INSTANCE;
                                    }
                                    if (longPressResult2 instanceof LongPressResult.Released) {
                                        pointerInputChange5 = ((LongPressResult.Released) longPressResult2).getFinalUpChange();
                                        job2 = launch$default2;
                                    } else {
                                        if (!(longPressResult2 instanceof LongPressResult.Canceled)) {
                                            throw new NoWhenBranchMatchedException();
                                        }
                                        job2 = launch$default2;
                                        pointerInputChange5 = null;
                                    }
                                    pointerInputChange4 = pointerInputChange2;
                                    if (pointerInputChange5 != null) {
                                    }
                                }
                            }
                        }
                    }
                    return Unit.INSTANCE;
                case 1:
                    awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    awaitFirstDown$default = obj;
                    awaitPointerEventScope2 = awaitPointerEventScope;
                    pointerInputChange = (PointerInputChange) awaitFirstDown$default;
                    pointerInputChange.consume();
                    CoroutineScope coroutineScope3 = this.$$this$coroutineScope;
                    coroutineStartForCurrentDispatchBehavior = TapGestureDetectorKt.getCoroutineStartForCurrentDispatchBehavior();
                    launch$default = BuildersKt.launch$default(coroutineScope3, (CoroutineContext) null, coroutineStartForCurrentDispatchBehavior, new TapGestureDetectorKt$detectTapGestures$2$1$resetJob$1(this.$pressScope, null), 1, (Object) null);
                    function3 = this.$onPress;
                    function32 = TapGestureDetectorKt.NoPressGesture;
                    if (function3 != function32) {
                    }
                    if (this.$onLongPress == null) {
                    }
                    break;
                case 2:
                    launch$default = (Job) this.L$1;
                    AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    awaitPointerEventScope2 = awaitPointerEventScope3;
                    waitForUpOrCancellation$default = obj;
                    pointerInputChange2 = (PointerInputChange) waitForUpOrCancellation$default;
                    Job job422 = launch$default;
                    if (pointerInputChange2 == null) {
                    }
                    if (pointerInputChange2 != null) {
                    }
                    return Unit.INSTANCE;
                case 3:
                    launch$default = (Job) this.L$2;
                    pointerInputChange = (PointerInputChange) this.L$1;
                    awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    waitForLongPress$default = obj;
                    longPressResult = (LongPressResult) waitForLongPress$default;
                    if (Intrinsics.areEqual(longPressResult, LongPressResult.Success.INSTANCE)) {
                    }
                    break;
                case 4:
                    Job job5 = (Job) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    job = job5;
                    TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job, null, new AnonymousClass2(this.$pressScope, null), 2, null);
                    return Unit.INSTANCE;
                case 5:
                    launchAwaitingReset$default = (Job) this.L$2;
                    pointerInputChange2 = (PointerInputChange) this.L$1;
                    awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    awaitSecondDown = obj;
                    pointerInputChange3 = (PointerInputChange) awaitSecondDown;
                    if (pointerInputChange3 != null) {
                    }
                    break;
                case 6:
                    pointerInputChange4 = (PointerInputChange) this.L$1;
                    launch$default2 = (Job) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    waitForUpOrCancellation$default2 = obj;
                    pointerInputChange5 = (PointerInputChange) waitForUpOrCancellation$default2;
                    job2 = launch$default2;
                    if (pointerInputChange5 != null) {
                    }
                    return Unit.INSTANCE;
                case 7:
                    PointerInputChange pointerInputChange6 = (PointerInputChange) this.L$3;
                    PointerInputChange pointerInputChange7 = (PointerInputChange) this.L$2;
                    Job job6 = (Job) this.L$1;
                    awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    pointerInputChange3 = pointerInputChange6;
                    launch$default2 = job6;
                    pointerInputChange2 = pointerInputChange7;
                    waitForLongPress$default2 = obj;
                    longPressResult2 = (LongPressResult) waitForLongPress$default2;
                    if (!Intrinsics.areEqual(longPressResult2, LongPressResult.Success.INSTANCE)) {
                    }
                    break;
                case 8:
                    Job job7 = (Job) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    job3 = job7;
                    TapGestureDetectorKt.launchAwaitingReset$default(this.$$this$coroutineScope, job3, null, new TapGestureDetectorKt$detectTapGestures$2$1$secondUp$1(this.$pressScope, null), 2, null);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TapGestureDetector.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$1", f = "TapGestureDetector.kt", i = {}, l = {110}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$1, reason: invalid class name */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PointerInputChange $down;
            final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
            final /* synthetic */ PressGestureScopeImpl $pressScope;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, PressGestureScopeImpl pressGestureScopeImpl, PointerInputChange pointerInputChange, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$onPress = function3;
                this.$pressScope = pressGestureScopeImpl;
                this.$down = pointerInputChange;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$onPress, this.$pressScope, this.$down, continuation);
            }

            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> function3 = this.$onPress;
                    PressGestureScopeImpl pressGestureScopeImpl = this.$pressScope;
                    Offset m4582boximpl = Offset.m4582boximpl(this.$down.getPosition());
                    this.label = 1;
                    if (function3.invoke(pressGestureScopeImpl, m4582boximpl, this) == coroutine_suspended) {
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TapGestureDetector.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$2", f = "TapGestureDetector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$2, reason: invalid class name */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PressGestureScopeImpl $pressScope;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$pressScope = pressGestureScopeImpl;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.$pressScope, continuation);
            }

            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$pressScope.release();
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TapGestureDetector.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$3", f = "TapGestureDetector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$3, reason: invalid class name */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
        public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PressGestureScopeImpl $pressScope;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
                this.$pressScope = pressGestureScopeImpl;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass3(this.$pressScope, continuation);
            }

            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$pressScope.cancel();
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TapGestureDetector.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$4", f = "TapGestureDetector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$4, reason: invalid class name */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
        public static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PressGestureScopeImpl $pressScope;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass4(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass4> continuation) {
                super(2, continuation);
                this.$pressScope = pressGestureScopeImpl;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass4(this.$pressScope, continuation);
            }

            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$pressScope.release();
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TapGestureDetector.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$5", f = "TapGestureDetector.kt", i = {}, l = {157, 158}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$5, reason: invalid class name */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
        public static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Job $cancelOrReleaseJob;
            final /* synthetic */ PressGestureScopeImpl $pressScope;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass5(Job job, PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass5> continuation) {
                super(2, continuation);
                this.$cancelOrReleaseJob = job;
                this.$pressScope = pressGestureScopeImpl;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass5(this.$cancelOrReleaseJob, this.$pressScope, continuation);
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
                    if (this.$cancelOrReleaseJob.join((Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.label = 2;
                if (this.$pressScope.reset((Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TapGestureDetector.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$6", f = "TapGestureDetector.kt", i = {}, l = {161}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$6, reason: invalid class name */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
        public static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
            final /* synthetic */ PressGestureScopeImpl $pressScope;
            final /* synthetic */ PointerInputChange $secondDown;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass6(Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, PressGestureScopeImpl pressGestureScopeImpl, PointerInputChange pointerInputChange, Continuation<? super AnonymousClass6> continuation) {
                super(2, continuation);
                this.$onPress = function3;
                this.$pressScope = pressGestureScopeImpl;
                this.$secondDown = pointerInputChange;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass6(this.$onPress, this.$pressScope, this.$secondDown, continuation);
            }

            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> function3 = this.$onPress;
                    PressGestureScopeImpl pressGestureScopeImpl = this.$pressScope;
                    Offset m4582boximpl = Offset.m4582boximpl(this.$secondDown.getPosition());
                    this.label = 1;
                    if (function3.invoke(pressGestureScopeImpl, m4582boximpl, this) == coroutine_suspended) {
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TapGestureDetector.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$7", f = "TapGestureDetector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$7, reason: invalid class name */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
        public static final class AnonymousClass7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PressGestureScopeImpl $pressScope;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass7(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass7> continuation) {
                super(2, continuation);
                this.$pressScope = pressGestureScopeImpl;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass7(this.$pressScope, continuation);
            }

            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$pressScope.release();
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TapGestureDetector.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$8", f = "TapGestureDetector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$8, reason: invalid class name */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
        public static final class AnonymousClass8 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PressGestureScopeImpl $pressScope;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass8(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass8> continuation) {
                super(2, continuation);
                this.$pressScope = pressGestureScopeImpl;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass8(this.$pressScope, continuation);
            }

            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$pressScope.cancel();
                return Unit.INSTANCE;
            }
        }
    }
}
