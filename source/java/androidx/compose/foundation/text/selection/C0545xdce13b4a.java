package androidx.compose.foundation.text.selection;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TextFieldSelectionManager.android.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt$addBasicTextFieldTextContextMenuComponents$1$2$1$2", f = "TextFieldSelectionManager.android.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* renamed from: androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt$addBasicTextFieldTextContextMenuComponents$1$2$1$2 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class C0545xdce13b4a extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ TextFieldSelectionManager $this_with;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0545xdce13b4a(TextFieldSelectionManager textFieldSelectionManager, Continuation<? super C0545xdce13b4a> continuation) {
        super(1, continuation);
        this.$this_with = textFieldSelectionManager;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new C0545xdce13b4a(this.$this_with, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        TextFieldSelectionManager textFieldSelectionManager = this.$this_with;
        textFieldSelectionManager.copy$foundation_release(textFieldSelectionManager.getTextToolbarShown$foundation_release());
        return Unit.INSTANCE;
    }
}
