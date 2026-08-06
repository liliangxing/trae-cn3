package androidx.compose.foundation.text.input.internal.selection;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TextFieldSelectionState.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState", f = "TextFieldSelectionState.kt", i = {}, l = {438}, m = "startToolbarAndHandlesVisibilityObserver", n = {}, s = {})
/* renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$startToolbarAndHandlesVisibilityObserver$1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class C0497x677e5db4 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TextFieldSelectionState this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0497x677e5db4(TextFieldSelectionState textFieldSelectionState, Continuation<? super C0497x677e5db4> continuation) {
        super(continuation);
        this.this$0 = textFieldSelectionState;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.startToolbarAndHandlesVisibilityObserver((Continuation) this);
    }
}
