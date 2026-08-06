package io.noties.markwon;

import android.text.Spanned;
import android.view.View;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextViewGenerating.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004¨\u0006\u000b"}, d2 = {"Lio/noties/markwon/TextViewGenerating;", "", "()V", "get", "", "view", "Landroid/view/View;", "set", "", "Landroid/widget/TextView;", "value", "markwon-core_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes6.dex */
public final class TextViewGenerating {
    public static final TextViewGenerating INSTANCE = new TextViewGenerating();

    private TextViewGenerating() {
    }

    public final void set(TextView view, boolean value) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        if (value != get(view)) {
            view.setTag(R.id.markdown_generating, Boolean.valueOf(value));
            CharSequence text = view.getText();
            if (!(text instanceof Spanned)) {
                text = null;
            }
            Spanned spanned = (Spanned) text;
            StatusSpan[] statusSpanArr = spanned != null ? (StatusSpan[]) spanned.getSpans(0, spanned.length(), StatusSpan.class) : null;
            if (statusSpanArr != null) {
                for (StatusSpan statusSpan : statusSpanArr) {
                    statusSpan.setGenerating(value);
                }
            }
            view.invalidate();
        }
    }

    public final boolean get(View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        Object tag = view.getTag(R.id.markdown_generating);
        if (!(tag instanceof Boolean)) {
            tag = null;
        }
        Boolean bool = (Boolean) tag;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }
}
