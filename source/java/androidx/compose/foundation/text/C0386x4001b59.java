package androidx.compose.foundation.text;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BasicTextField.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1", f = "BasicTextField.kt", i = {0, 0}, l = {333}, m = "showTextToolbar", n = {"rect", "$this$showTextToolbar_u24lambda_u245"}, s = {"L$0", "L$3"})
/* renamed from: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class C0386x4001b59 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0386x4001b59(BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1 basicTextFieldKt$BasicTextField$textToolbarHandler$1$1, Continuation<? super C0386x4001b59> continuation) {
        super(continuation);
        this.this$0 = basicTextFieldKt$BasicTextField$textToolbarHandler$1$1;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.showTextToolbar(null, null, (Continuation) this);
    }
}
