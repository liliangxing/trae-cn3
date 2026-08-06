package io.noties.markwon;

import android.text.Spanned;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextViewGenerating.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lio/noties/markwon/StatusSpanPlugin;", "Lio/noties/markwon/AbstractMarkwonPlugin;", "()V", "beforeSetText", "", "textView", "Landroid/widget/TextView;", "markdown", "Landroid/text/Spanned;", "markwon-core_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class StatusSpanPlugin extends AbstractMarkwonPlugin {
    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void beforeSetText(TextView textView, Spanned markdown) {
        Intrinsics.checkParameterIsNotNull(textView, "textView");
        Intrinsics.checkParameterIsNotNull(markdown, "markdown");
        super.beforeSetText(textView, markdown);
        StatusSpan[] statusSpanArr = (StatusSpan[]) markdown.getSpans(0, markdown.length(), StatusSpan.class);
        boolean z = TextViewGenerating.INSTANCE.get(textView);
        if (statusSpanArr != null) {
            for (StatusSpan statusSpan : statusSpanArr) {
                statusSpan.setGenerating(z);
            }
        }
    }
}
