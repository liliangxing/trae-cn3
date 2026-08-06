package androidx.compose.foundation.text;

import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.foundation.text.selection.PlatformSelectionBehaviors;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ContextMenu.android.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.ContextMenu_androidKt$ContextMenuArea$modifier$1$1", f = "ContextMenu.android.kt", i = {}, l = {88, 89}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class ContextMenu_androidKt$ContextMenuArea$modifier$1$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ TextFieldSelectionState $selectionState;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContextMenu_androidKt$ContextMenuArea$modifier$1$1(TextFieldSelectionState textFieldSelectionState, Continuation<? super ContextMenu_androidKt$ContextMenuArea$modifier$1$1> continuation) {
        super(1, continuation);
        this.$selectionState = textFieldSelectionState;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new ContextMenu_androidKt$ContextMenuArea$modifier$1$1(this.$selectionState, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.$selectionState.updateClipboardEntry((Continuation) this) == coroutine_suspended) {
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
        PlatformSelectionBehaviors platformSelectionBehaviors = this.$selectionState.getPlatformSelectionBehaviors();
        if (platformSelectionBehaviors != null) {
            this.label = 2;
            if (platformSelectionBehaviors.mo2060onShowContextMenuSbBc2M(this.$selectionState.getTextFieldState().getVisualText().getText(), this.$selectionState.getTextFieldState().getVisualText().getSelection(), (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
