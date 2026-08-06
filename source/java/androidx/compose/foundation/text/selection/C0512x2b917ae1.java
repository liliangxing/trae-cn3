package androidx.compose.foundation.text.selection;

import android.content.Context;
import android.view.textclassifier.TextClassifier;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: PlatformSelectionBehaviors.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/view/textclassifier/TextClassifier;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl$requireTextClassificationSession$2$textClassificationSession$1$1", f = "PlatformSelectionBehaviors.android.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* renamed from: androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl$requireTextClassificationSession$2$textClassificationSession$1$1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
final class C0512x2b917ae1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super TextClassifier>, Object> {
    int label;
    final /* synthetic */ PlatformSelectionBehaviorsImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0512x2b917ae1(PlatformSelectionBehaviorsImpl platformSelectionBehaviorsImpl, Continuation<? super C0512x2b917ae1> continuation) {
        super(2, continuation);
        this.this$0 = platformSelectionBehaviorsImpl;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C0512x2b917ae1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super TextClassifier> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Context context;
        SelectedTextType selectedTextType;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        TextClassifierHelperMethods textClassifierHelperMethods = TextClassifierHelperMethods.INSTANCE;
        context = this.this$0.context;
        selectedTextType = this.this$0.selectedTextType;
        TextClassifier createTextClassificationSession = textClassifierHelperMethods.createTextClassificationSession(context, selectedTextType);
        this.this$0.textClassificationSession = createTextClassificationSession;
        return createTextClassificationSession;
    }
}
