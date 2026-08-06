package com.larus.business.markdown.fresco;

import android.text.Spanned;
import android.widget.TextView;
import com.larus.business.markdown.api.extplugin.image.ICustomImgSpan;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DefaultImgWidget.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.larus.business.markdown.fresco.DefaultImgWidget$bindData$1", f = "DefaultImgWidget.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
final class DefaultImgWidget$bindData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ICustomImgSpan $span;
    final /* synthetic */ Spanned $text;
    final /* synthetic */ TextView $textView;
    int label;
    final /* synthetic */ DefaultImgWidget this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultImgWidget$bindData$1(DefaultImgWidget defaultImgWidget, ICustomImgSpan iCustomImgSpan, Spanned spanned, TextView textView, Continuation<? super DefaultImgWidget$bindData$1> continuation) {
        super(2, continuation);
        this.this$0 = defaultImgWidget;
        this.$span = iCustomImgSpan;
        this.$text = spanned;
        this.$textView = textView;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DefaultImgWidget$bindData$1(this.this$0, this.$span, this.$text, this.$textView, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.updateSimpleImageGroupUISingle(this.$span, this.$text, this.$textView);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
