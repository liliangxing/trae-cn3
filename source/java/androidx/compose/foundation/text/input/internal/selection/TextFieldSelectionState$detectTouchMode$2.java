package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.text.selection.SelectionGesturesKt;
import androidx.compose.p002ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p002ui.input.pointer.PointerEvent;
import androidx.compose.p002ui.input.pointer.PointerEventPass;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TextFieldSelectionState.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectTouchMode$2", f = "TextFieldSelectionState.kt", i = {0}, l = {467}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class TextFieldSelectionState$detectTouchMode$2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TextFieldSelectionState this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextFieldSelectionState$detectTouchMode$2(TextFieldSelectionState textFieldSelectionState, Continuation<? super TextFieldSelectionState$detectTouchMode$2> continuation) {
        super(2, continuation);
        this.this$0 = textFieldSelectionState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> textFieldSelectionState$detectTouchMode$2 = new TextFieldSelectionState$detectTouchMode$2(this.this$0, continuation);
        textFieldSelectionState$detectTouchMode$2.L$0 = obj;
        return textFieldSelectionState$detectTouchMode$2;
    }

    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return create(awaitPointerEventScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0036 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0037 -> B:5:0x003c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        AwaitPointerEventScope awaitPointerEventScope;
        TextFieldSelectionState$detectTouchMode$2 textFieldSelectionState$detectTouchMode$2;
        Object awaitPointerEvent;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
            textFieldSelectionState$detectTouchMode$2 = this;
            textFieldSelectionState$detectTouchMode$2.L$0 = awaitPointerEventScope;
            textFieldSelectionState$detectTouchMode$2.label = 1;
            awaitPointerEvent = awaitPointerEventScope.awaitPointerEvent(PointerEventPass.Initial, (Continuation) textFieldSelectionState$detectTouchMode$2);
            if (awaitPointerEvent == coroutine_suspended) {
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            AwaitPointerEventScope awaitPointerEventScope3 = awaitPointerEventScope2;
            Object obj2 = coroutine_suspended;
            TextFieldSelectionState$detectTouchMode$2 textFieldSelectionState$detectTouchMode$22 = this;
            textFieldSelectionState$detectTouchMode$22.this$0.setInTouchMode(!SelectionGesturesKt.isPrecisePointer((PointerEvent) obj));
            textFieldSelectionState$detectTouchMode$2 = textFieldSelectionState$detectTouchMode$22;
            coroutine_suspended = obj2;
            awaitPointerEventScope = awaitPointerEventScope3;
            textFieldSelectionState$detectTouchMode$2.L$0 = awaitPointerEventScope;
            textFieldSelectionState$detectTouchMode$2.label = 1;
            awaitPointerEvent = awaitPointerEventScope.awaitPointerEvent(PointerEventPass.Initial, (Continuation) textFieldSelectionState$detectTouchMode$2);
            if (awaitPointerEvent == coroutine_suspended) {
                return coroutine_suspended;
            }
            Object obj3 = coroutine_suspended;
            textFieldSelectionState$detectTouchMode$22 = textFieldSelectionState$detectTouchMode$2;
            obj = awaitPointerEvent;
            awaitPointerEventScope3 = awaitPointerEventScope;
            obj2 = obj3;
            textFieldSelectionState$detectTouchMode$22.this$0.setInTouchMode(!SelectionGesturesKt.isPrecisePointer((PointerEvent) obj));
            textFieldSelectionState$detectTouchMode$2 = textFieldSelectionState$detectTouchMode$22;
            coroutine_suspended = obj2;
            awaitPointerEventScope = awaitPointerEventScope3;
            textFieldSelectionState$detectTouchMode$2.L$0 = awaitPointerEventScope;
            textFieldSelectionState$detectTouchMode$2.label = 1;
            awaitPointerEvent = awaitPointerEventScope.awaitPointerEvent(PointerEventPass.Initial, (Continuation) textFieldSelectionState$detectTouchMode$2);
            if (awaitPointerEvent == coroutine_suspended) {
            }
        }
    }
}
