package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.internal.ClipboardUtils_androidKt;
import androidx.compose.foundation.text.HandleState;
import androidx.compose.ui.platform.Clipboard;
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
@DebugMetadata(c = "androidx.compose.foundation.text.selection.TextFieldSelectionManager$copy$1", f = "TextFieldSelectionManager.kt", i = {}, l = {816}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class TextFieldSelectionManager$copy$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $cancelSelection;
    int label;
    final /* synthetic */ TextFieldSelectionManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextFieldSelectionManager$copy$1(TextFieldSelectionManager textFieldSelectionManager, boolean z, Continuation<? super TextFieldSelectionManager$copy$1> continuation) {
        super(2, continuation);
        this.this$0 = textFieldSelectionManager;
        this.$cancelSelection = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TextFieldSelectionManager$copy$1(this.this$0, this.$cancelSelection, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        TextFieldValue m2142createTextFieldValueFDrldGo;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (TextRange.getCollapsed-impl(this.this$0.getValue$foundation_release().getSelection-d9O1mEE())) {
                return Unit.INSTANCE;
            }
            Clipboard clipboard = this.this$0.getClipboard();
            if (clipboard != null) {
                this.label = 1;
                if (clipboard.setClipEntry(ClipboardUtils_androidKt.toClipEntry(TextFieldValueKt.getSelectedText(this.this$0.getValue$foundation_release())), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        if (!this.$cancelSelection) {
            return Unit.INSTANCE;
        }
        int i2 = TextRange.getMax-impl(this.this$0.getValue$foundation_release().getSelection-d9O1mEE());
        TextFieldSelectionManager textFieldSelectionManager = this.this$0;
        m2142createTextFieldValueFDrldGo = textFieldSelectionManager.m2142createTextFieldValueFDrldGo(textFieldSelectionManager.getValue$foundation_release().getAnnotatedString(), TextRangeKt.TextRange(i2, i2));
        this.this$0.getOnValueChange$foundation_release().invoke(m2142createTextFieldValueFDrldGo);
        this.this$0.m2154setLatestSelectionOEnZFl4$foundation_release(TextRange.box-impl(m2142createTextFieldValueFDrldGo.getSelection-d9O1mEE()));
        this.this$0.setHandleState(HandleState.None);
        return Unit.INSTANCE;
    }
}
