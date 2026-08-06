package io.noties.markwon.html;

import io.noties.markwon.SpannableBuilder;
import io.noties.markwon.html.HtmlTag;
import java.util.List;

/* loaded from: classes6.dex */
public abstract class MarkwonHtmlParser {

    /* loaded from: classes6.dex */
    public interface FlushAction<T> {
        void apply(List<T> list);
    }

    public abstract void flushBlockTags(int i, FlushAction<HtmlTag.Block> flushAction);

    public abstract void flushInlineTags(int i, FlushAction<HtmlTag.Inline> flushAction);

    public abstract void processFragment(SpannableBuilder spannableBuilder, String str);

    public abstract void reset();
}
