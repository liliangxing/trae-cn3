package androidx.compose.foundation.text;

import androidx.compose.p002ui.geometry.Offset;
import androidx.compose.p002ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p002ui.input.pointer.PointerEvent;
import androidx.compose.p002ui.input.pointer.PointerEventPass;
import androidx.compose.p002ui.input.pointer.PointerEventType;
import androidx.compose.p002ui.input.pointer.PointerInputChange;
import androidx.compose.p002ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;

/* compiled from: PointerMoveDetector.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.PointerMoveDetectorKt$detectMoves$2", f = "PointerMoveDetector.kt", i = {}, l = {41}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
final class PointerMoveDetectorKt$detectMoves$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Offset, Unit> $onMove;
    final /* synthetic */ PointerEventPass $pointerEventPass;
    final /* synthetic */ PointerInputScope $this_detectMoves;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PointerMoveDetectorKt$detectMoves$2(PointerInputScope pointerInputScope, PointerEventPass pointerEventPass, Function1<? super Offset, Unit> function1, Continuation<? super PointerMoveDetectorKt$detectMoves$2> continuation) {
        super(2, continuation);
        this.$this_detectMoves = pointerInputScope;
        this.$pointerEventPass = pointerEventPass;
        this.$onMove = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PointerMoveDetectorKt$detectMoves$2(this.$this_detectMoves, this.$pointerEventPass, this.$onMove, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineContext context = getContext();
            this.label = 1;
            if (this.$this_detectMoves.awaitPointerEventScope(new C03991(context, this.$pointerEventPass, this.$onMove, null), (Continuation) this) == coroutine_suspended) {
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
    /* compiled from: PointerMoveDetector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.PointerMoveDetectorKt$detectMoves$2$1", f = "PointerMoveDetector.kt", i = {0, 0}, l = {44}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope", "previousPosition"}, s = {"L$0", "L$1"})
    /* renamed from: androidx.compose.foundation.text.PointerMoveDetectorKt$detectMoves$2$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
    public static final class C03991 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CoroutineContext $currentContext;
        final /* synthetic */ Function1<Offset, Unit> $onMove;
        final /* synthetic */ PointerEventPass $pointerEventPass;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C03991(CoroutineContext coroutineContext, PointerEventPass pointerEventPass, Function1<? super Offset, Unit> function1, Continuation<? super C03991> continuation) {
            super(2, continuation);
            this.$currentContext = coroutineContext;
            this.$pointerEventPass = pointerEventPass;
            this.$onMove = function1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c03991 = new C03991(this.$currentContext, this.$pointerEventPass, this.$onMove, continuation);
            c03991.L$0 = obj;
            return c03991;
        }

        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return create(awaitPointerEventScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x00b6  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x009a  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x009d  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x004b -> B:5:0x0051). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Ref.ObjectRef objectRef;
            AwaitPointerEventScope awaitPointerEventScope;
            C03991 c03991;
            Offset m4582boximpl;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                objectRef = new Ref.ObjectRef();
                awaitPointerEventScope = awaitPointerEventScope2;
                c03991 = this;
                if (JobKt.isActive(c03991.$currentContext)) {
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Ref.ObjectRef objectRef2 = (Ref.ObjectRef) this.L$1;
                AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                AwaitPointerEventScope awaitPointerEventScope4 = awaitPointerEventScope3;
                Ref.ObjectRef objectRef3 = objectRef2;
                Object obj2 = coroutine_suspended;
                C03991 c039912 = this;
                PointerEvent pointerEvent = (PointerEvent) obj;
                int type = pointerEvent.getType();
                if (!PointerEventType.m6091equalsimpl0(type, PointerEventType.INSTANCE.m6097getMove7fucELk()) || PointerEventType.m6091equalsimpl0(type, PointerEventType.INSTANCE.m6095getEnter7fucELk()) || PointerEventType.m6091equalsimpl0(type, PointerEventType.INSTANCE.m6096getExit7fucELk())) {
                    m4582boximpl = Offset.m4582boximpl(((PointerInputChange) CollectionsKt.first(pointerEvent.getChanges())).getPosition());
                    if (Offset.m4589equalsimpl(m4582boximpl.m4603unboximpl(), objectRef3.element)) {
                        m4582boximpl = null;
                    }
                    if (m4582boximpl != null) {
                        Function1<Offset, Unit> function1 = c039912.$onMove;
                        long m4603unboximpl = m4582boximpl.m4603unboximpl();
                        objectRef3.element = Offset.m4582boximpl(m4603unboximpl);
                        function1.invoke(Offset.m4582boximpl(m4603unboximpl));
                    }
                }
                c03991 = c039912;
                coroutine_suspended = obj2;
                objectRef = objectRef3;
                awaitPointerEventScope = awaitPointerEventScope4;
                if (JobKt.isActive(c03991.$currentContext)) {
                    c03991.L$0 = awaitPointerEventScope;
                    c03991.L$1 = objectRef;
                    c03991.label = 1;
                    Object awaitPointerEvent = awaitPointerEventScope.awaitPointerEvent(c03991.$pointerEventPass, (Continuation) c03991);
                    if (awaitPointerEvent == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Object obj3 = coroutine_suspended;
                    c039912 = c03991;
                    obj = awaitPointerEvent;
                    awaitPointerEventScope4 = awaitPointerEventScope;
                    objectRef3 = objectRef;
                    obj2 = obj3;
                    PointerEvent pointerEvent2 = (PointerEvent) obj;
                    int type2 = pointerEvent2.getType();
                    if (!PointerEventType.m6091equalsimpl0(type2, PointerEventType.INSTANCE.m6097getMove7fucELk())) {
                    }
                    m4582boximpl = Offset.m4582boximpl(((PointerInputChange) CollectionsKt.first(pointerEvent2.getChanges())).getPosition());
                    if (Offset.m4589equalsimpl(m4582boximpl.m4603unboximpl(), objectRef3.element)) {
                    }
                    if (m4582boximpl != null) {
                    }
                    c03991 = c039912;
                    coroutine_suspended = obj2;
                    objectRef = objectRef3;
                    awaitPointerEventScope = awaitPointerEventScope4;
                    if (JobKt.isActive(c03991.$currentContext)) {
                        return Unit.INSTANCE;
                    }
                }
            }
        }
    }
}
