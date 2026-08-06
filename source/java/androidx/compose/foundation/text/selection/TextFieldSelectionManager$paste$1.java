package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.internal.ClipboardUtils_androidKt;
import androidx.compose.foundation.text.HandleState;
import androidx.compose.foundation.text.UndoManager;
import androidx.compose.ui.platform.ClipEntry;
import androidx.compose.ui.platform.Clipboard;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextFieldValueKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TextFieldSelectionManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.selection.TextFieldSelectionManager$paste$1", f = "TextFieldSelectionManager.kt", i = {}, l = {841, 841}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class TextFieldSelectionManager$paste$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TextFieldSelectionManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextFieldSelectionManager$paste$1(TextFieldSelectionManager textFieldSelectionManager, Continuation<? super TextFieldSelectionManager$paste$1> continuation) {
        super(2, continuation);
        this.this$0 = textFieldSelectionManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TextFieldSelectionManager$paste$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        AnnotatedString annotatedString;
        TextFieldValue m2142createTextFieldValueFDrldGo;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Clipboard clipboard = this.this$0.getClipboard();
            if (clipboard != null) {
                this.label = 1;
                obj = clipboard.getClipEntry((Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            annotatedString = (AnnotatedString) obj;
            if (annotatedString != null) {
                AnnotatedString plus = TextFieldValueKt.getTextBeforeSelection(this.this$0.getValue$foundation_release(), this.this$0.getValue$foundation_release().getText().length()).plus(annotatedString).plus(TextFieldValueKt.getTextAfterSelection(this.this$0.getValue$foundation_release(), this.this$0.getValue$foundation_release().getText().length()));
                int i2 = TextRange.getMin-impl(this.this$0.getValue$foundation_release().getSelection-d9O1mEE()) + annotatedString.length();
                m2142createTextFieldValueFDrldGo = this.this$0.m2142createTextFieldValueFDrldGo(plus, TextRangeKt.TextRange(i2, i2));
                this.this$0.getOnValueChange$foundation_release().invoke(m2142createTextFieldValueFDrldGo);
                this.this$0.m2154setLatestSelectionOEnZFl4$foundation_release(TextRange.box-impl(m2142createTextFieldValueFDrldGo.getSelection-d9O1mEE()));
                this.this$0.setHandleState(HandleState.None);
                UndoManager undoManager = this.this$0.getUndoManager();
                if (undoManager != null) {
                    undoManager.forceNextSnapshot();
                }
                return Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        ClipEntry clipEntry = (ClipEntry) obj;
        if (clipEntry != null) {
            this.label = 2;
            obj = ClipboardUtils_androidKt.readAnnotatedString(clipEntry, (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            annotatedString = (AnnotatedString) obj;
            if (annotatedString != null) {
            }
        }
        return Unit.INSTANCE;
    }
}
