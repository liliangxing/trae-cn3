package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.p002ui.geometry.InlineClassHelperKt;
import androidx.compose.p002ui.geometry.Offset;
import androidx.compose.p002ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p002ui.input.pointer.PointerEventKt;
import androidx.compose.p002ui.input.pointer.PointerInputChange;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* compiled from: SelectionGestures.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/text/selection/DownResolution;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelectionSubsequentPress$downResolution$1", f = "SelectionGestures.kt", i = {0}, l = {284}, m = "invokeSuspend", n = {"$this$withTimeoutOrNull"}, s = {"L$0"})
/* renamed from: androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelectionSubsequentPress$downResolution$1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
final class C0521xcb1d223 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super DownResolution>, Object> {
    final /* synthetic */ Ref.LongRef $overSlop;
    final /* synthetic */ long $pointerId;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0521xcb1d223(long j, Ref.LongRef longRef, Continuation<? super C0521xcb1d223> continuation) {
        super(2, continuation);
        this.$pointerId = j;
        this.$overSlop = longRef;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> c0521xcb1d223 = new C0521xcb1d223(this.$pointerId, this.$overSlop, continuation);
        c0521xcb1d223.L$0 = obj;
        return c0521xcb1d223;
    }

    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super DownResolution> continuation) {
        return create(awaitPointerEventScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        AwaitPointerEventScope awaitPointerEventScope;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
            long j = this.$pointerId;
            final Ref.LongRef longRef = this.$overSlop;
            this.L$0 = awaitPointerEventScope2;
            this.label = 1;
            Object m676awaitTouchSlopOrCancellationjO51t88 = DragGestureDetectorKt.m676awaitTouchSlopOrCancellationjO51t88(awaitPointerEventScope2, j, new Function2() { // from class: androidx.compose.foundation.text.selection.SelectionGesturesKt$touchSelectionSubsequentPress$downResolution$1$$ExternalSyntheticLambda0
                public final Object invoke(Object obj2, Object obj3) {
                    Unit invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = C0521xcb1d223.invokeSuspend$lambda$0(longRef, (PointerInputChange) obj2, (Offset) obj3);
                    return invokeSuspend$lambda$0;
                }
            }, (Continuation) this);
            if (m676awaitTouchSlopOrCancellationjO51t88 == coroutine_suspended) {
                return coroutine_suspended;
            }
            awaitPointerEventScope = awaitPointerEventScope2;
            obj = m676awaitTouchSlopOrCancellationjO51t88;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        if (((PointerInputChange) obj) != null) {
            if ((this.$overSlop.element & 9223372034707292159L) != InlineClassHelperKt.UnspecifiedPackedFloats) {
                return DownResolution.Drag;
            }
        }
        PointerInputChange pointerInputChange = (PointerInputChange) CollectionsKt.first(awaitPointerEventScope.getCurrentEvent().getChanges());
        if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
            pointerInputChange.consume();
            return DownResolution.f61Up;
        }
        return DownResolution.Cancel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(Ref.LongRef longRef, PointerInputChange pointerInputChange, Offset offset) {
        pointerInputChange.consume();
        longRef.element = offset.m4603unboximpl();
        return Unit.INSTANCE;
    }
}
