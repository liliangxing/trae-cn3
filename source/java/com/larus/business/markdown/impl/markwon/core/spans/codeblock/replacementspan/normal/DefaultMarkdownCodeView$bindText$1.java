package com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan.normal;

import android.text.SpannableStringBuilder;
import android.widget.TextView;
import io.noties.markwon.SpannableBuilder;
import io.noties.markwon.syntax.Prism4jSyntaxHighlight;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DefaultMarkdownCodeView.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan.normal.DefaultMarkdownCodeView$bindText$1", f = "DefaultMarkdownCodeView.kt", i = {}, l = {252}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class DefaultMarkdownCodeView$bindText$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $optimizeCode;
    final /* synthetic */ TextView $tv;
    int label;
    final /* synthetic */ DefaultMarkdownCodeView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultMarkdownCodeView$bindText$1(DefaultMarkdownCodeView defaultMarkdownCodeView, String str, TextView textView, Continuation<? super DefaultMarkdownCodeView$bindText$1> continuation) {
        super(2, continuation);
        this.this$0 = defaultMarkdownCodeView;
        this.$optimizeCode = str;
        this.$tv = textView;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DefaultMarkdownCodeView$bindText$1(this.this$0, this.$optimizeCode, this.$tv, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Prism4jSyntaxHighlight highlight;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            highlight = this.this$0.getHighlight();
            SpannableStringBuilder spannableStringBuilder = new SpannableBuilder(highlight.highlight(this.this$0.getCurrentLanguage(), this.$optimizeCode)).spannableStringBuilder();
            Intrinsics.checkNotNullExpressionValue(spannableStringBuilder, "SpannableBuilder(\n      ….spannableStringBuilder()");
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new C13281(this.$tv, spannableStringBuilder, null), (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DefaultMarkdownCodeView.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan.normal.DefaultMarkdownCodeView$bindText$1$1", f = "DefaultMarkdownCodeView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan.normal.DefaultMarkdownCodeView$bindText$1$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class C13281 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SpannableStringBuilder $highlightText;
        final /* synthetic */ TextView $tv;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13281(TextView textView, SpannableStringBuilder spannableStringBuilder, Continuation<? super C13281> continuation) {
            super(2, continuation);
            this.$tv = textView;
            this.$highlightText = spannableStringBuilder;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C13281(this.$tv, this.$highlightText, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$tv.setText(this.$highlightText);
            return Unit.INSTANCE;
        }
    }
}
