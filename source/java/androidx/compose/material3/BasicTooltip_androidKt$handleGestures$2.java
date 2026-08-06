package androidx.compose.material3;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.p002ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p002ui.input.pointer.PointerEvent;
import androidx.compose.p002ui.input.pointer.PointerEventPass;
import androidx.compose.p002ui.input.pointer.PointerEventType;
import androidx.compose.p002ui.input.pointer.PointerInputScope;
import androidx.compose.p002ui.input.pointer.PointerType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: BasicTooltip.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.BasicTooltip_androidKt$handleGestures$2", f = "BasicTooltip.android.kt", i = {}, l = {184}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
final class BasicTooltip_androidKt$handleGestures$2 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BasicTooltipState $state;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BasicTooltip_androidKt$handleGestures$2(BasicTooltipState basicTooltipState, Continuation<? super BasicTooltip_androidKt$handleGestures$2> continuation) {
        super(2, continuation);
        this.$state = basicTooltipState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> basicTooltip_androidKt$handleGestures$2 = new BasicTooltip_androidKt$handleGestures$2(this.$state, continuation);
        basicTooltip_androidKt$handleGestures$2.L$0 = obj;
        return basicTooltip_androidKt$handleGestures$2;
    }

    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return create(pointerInputScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BasicTooltip.android.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.BasicTooltip_androidKt$handleGestures$2$1", f = "BasicTooltip.android.kt", i = {}, l = {185}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.material3.BasicTooltip_androidKt$handleGestures$2$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
    public static final class C05741 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PointerInputScope $$this$pointerInput;
        final /* synthetic */ BasicTooltipState $state;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05741(PointerInputScope pointerInputScope, BasicTooltipState basicTooltipState, Continuation<? super C05741> continuation) {
            super(2, continuation);
            this.$$this$pointerInput = pointerInputScope;
            this.$state = basicTooltipState;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c05741 = new C05741(this.$$this$pointerInput, this.$state, continuation);
            c05741.L$0 = obj;
            return c05741;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: BasicTooltip.android.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.material3.BasicTooltip_androidKt$handleGestures$2$1$1", f = "BasicTooltip.android.kt", i = {0, 0}, l = {189}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope", "pass"}, s = {"L$0", "L$1"})
        /* renamed from: androidx.compose.material3.BasicTooltip_androidKt$handleGestures$2$1$1, reason: invalid class name */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
        public static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ CoroutineScope $$this$coroutineScope;
            final /* synthetic */ BasicTooltipState $state;
            private /* synthetic */ Object L$0;
            Object L$1;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(CoroutineScope coroutineScope, BasicTooltipState basicTooltipState, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$$this$coroutineScope = coroutineScope;
                this.$state = basicTooltipState;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$$this$coroutineScope, this.$state, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                return create(awaitPointerEventScope, continuation).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x003d A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:18:0x003e  */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0061  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x003e -> B:5:0x0044). Please report as a decompilation issue!!! */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object obj) {
                PointerEventPass pointerEventPass;
                AwaitPointerEventScope awaitPointerEventScope;
                AnonymousClass1 anonymousClass1;
                Object awaitPointerEvent;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                    pointerEventPass = PointerEventPass.Main;
                    awaitPointerEventScope = awaitPointerEventScope2;
                    anonymousClass1 = this;
                    anonymousClass1.L$0 = awaitPointerEventScope;
                    anonymousClass1.L$1 = pointerEventPass;
                    anonymousClass1.label = 1;
                    awaitPointerEvent = awaitPointerEventScope.awaitPointerEvent(pointerEventPass, (Continuation) anonymousClass1);
                    if (awaitPointerEvent == coroutine_suspended) {
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    PointerEventPass pointerEventPass2 = (PointerEventPass) this.L$1;
                    AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    AwaitPointerEventScope awaitPointerEventScope4 = awaitPointerEventScope3;
                    PointerEventPass pointerEventPass3 = pointerEventPass2;
                    Object obj2 = coroutine_suspended;
                    AnonymousClass1 anonymousClass12 = this;
                    PointerEvent pointerEvent = (PointerEvent) obj;
                    if (PointerType.m6215equalsimpl0(pointerEvent.getChanges().get(0).getType(), PointerType.INSTANCE.m6220getMouseT8wyACA())) {
                        int type = pointerEvent.getType();
                        if (PointerEventType.m6091equalsimpl0(type, PointerEventType.INSTANCE.m6095getEnter7fucELk())) {
                            BuildersKt.launch$default(anonymousClass12.$$this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new C07941(anonymousClass12.$state, null), 3, (Object) null);
                        } else if (PointerEventType.m6091equalsimpl0(type, PointerEventType.INSTANCE.m6096getExit7fucELk())) {
                            anonymousClass12.$state.dismiss();
                        }
                    }
                    anonymousClass1 = anonymousClass12;
                    coroutine_suspended = obj2;
                    pointerEventPass = pointerEventPass3;
                    awaitPointerEventScope = awaitPointerEventScope4;
                    anonymousClass1.L$0 = awaitPointerEventScope;
                    anonymousClass1.L$1 = pointerEventPass;
                    anonymousClass1.label = 1;
                    awaitPointerEvent = awaitPointerEventScope.awaitPointerEvent(pointerEventPass, (Continuation) anonymousClass1);
                    if (awaitPointerEvent == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Object obj3 = coroutine_suspended;
                    anonymousClass12 = anonymousClass1;
                    obj = awaitPointerEvent;
                    awaitPointerEventScope4 = awaitPointerEventScope;
                    pointerEventPass3 = pointerEventPass;
                    obj2 = obj3;
                    PointerEvent pointerEvent2 = (PointerEvent) obj;
                    if (PointerType.m6215equalsimpl0(pointerEvent2.getChanges().get(0).getType(), PointerType.INSTANCE.m6220getMouseT8wyACA())) {
                    }
                    anonymousClass1 = anonymousClass12;
                    coroutine_suspended = obj2;
                    pointerEventPass = pointerEventPass3;
                    awaitPointerEventScope = awaitPointerEventScope4;
                    anonymousClass1.L$0 = awaitPointerEventScope;
                    anonymousClass1.L$1 = pointerEventPass;
                    anonymousClass1.label = 1;
                    awaitPointerEvent = awaitPointerEventScope.awaitPointerEvent(pointerEventPass, (Continuation) anonymousClass1);
                    if (awaitPointerEvent == coroutine_suspended) {
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: BasicTooltip.android.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.material3.BasicTooltip_androidKt$handleGestures$2$1$1$1", f = "BasicTooltip.android.kt", i = {}, l = {194}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: androidx.compose.material3.BasicTooltip_androidKt$handleGestures$2$1$1$1, reason: invalid class name and collision with other inner class name */
            /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
            public static final class C07941 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ BasicTooltipState $state;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C07941(BasicTooltipState basicTooltipState, Continuation<? super C07941> continuation) {
                    super(2, continuation);
                    this.$state = basicTooltipState;
                }

                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C07941(this.$state, continuation);
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
                        if (this.$state.show(MutatePriority.UserInput, (Continuation) this) == coroutine_suspended) {
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
                if (this.$$this$pointerInput.awaitPointerEventScope(new AnonymousClass1(coroutineScope, this.$state, null), (Continuation) this) == coroutine_suspended) {
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

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (CoroutineScopeKt.coroutineScope(new C05741((PointerInputScope) this.L$0, this.$state, null), (Continuation) this) == coroutine_suspended) {
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
