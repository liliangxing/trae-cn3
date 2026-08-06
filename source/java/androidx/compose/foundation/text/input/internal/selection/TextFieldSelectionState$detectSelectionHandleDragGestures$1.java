package androidx.compose.foundation.text.input.internal.selection;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TextFieldSelectionState.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState", f = "TextFieldSelectionState.kt", i = {0, 0, 0}, l = {1067}, m = "detectSelectionHandleDragGestures", n = {"dragBeginPosition", "dragTotalDistance", "handle"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class TextFieldSelectionState$detectSelectionHandleDragGestures$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TextFieldSelectionState this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextFieldSelectionState$detectSelectionHandleDragGestures$1(TextFieldSelectionState textFieldSelectionState, Continuation<? super TextFieldSelectionState$detectSelectionHandleDragGestures$1> continuation) {
        super(continuation);
        this.this$0 = textFieldSelectionState;
    }

    public final Object invokeSuspend(Object obj) {
        Object detectSelectionHandleDragGestures;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        detectSelectionHandleDragGestures = this.this$0.detectSelectionHandleDragGestures(null, false, (Continuation) this);
        return detectSelectionHandleDragGestures;
    }
}
