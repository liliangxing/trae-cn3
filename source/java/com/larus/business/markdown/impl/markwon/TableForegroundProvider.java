package com.larus.business.markdown.impl.markwon;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import com.larus.business.markdown.api.view.text.IMarkdownTextView;
import io.noties.markwon.core.spans.TextViewSpan;
import io.noties.markwon.ext.tables.ForegroundProvider;
import kotlin.Metadata;

/* compiled from: MarkwonExt.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/TableForegroundProvider;", "Lio/noties/markwon/ext/tables/ForegroundProvider;", "()V", "getDrawable", "Landroid/graphics/drawable/Drawable;", "text", "", "start", "", "end", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class TableForegroundProvider implements ForegroundProvider {
    @Override // io.noties.markwon.ext.tables.ForegroundProvider
    public Drawable getDrawable(CharSequence text, int start, int end) {
        if (text == null || text.length() == 0) {
            return null;
        }
        KeyEvent.Callback textViewOf = TextViewSpan.textViewOf(text);
        IMarkdownTextView iMarkdownTextView = textViewOf instanceof IMarkdownTextView ? (IMarkdownTextView) textViewOf : null;
        if (iMarkdownTextView != null && iMarkdownTextView.isSelected(start, end)) {
            return new ColorDrawable(iMarkdownTextView.getSelectedColor());
        }
        return null;
    }
}
