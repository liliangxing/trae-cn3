package io.noties.markwon.html;

import io.noties.markwon.MarkwonVisitor;
import io.noties.markwon.html.HtmlTag;
import java.util.Collection;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public abstract class TagHandler {
    public abstract void handle(MarkwonVisitor markwonVisitor, MarkwonHtmlRenderer markwonHtmlRenderer, HtmlTag htmlTag);

    public CharSequence replaceTag(HtmlTag htmlTag, HtmlEmptyTagReplacement htmlEmptyTagReplacement) {
        return null;
    }

    public abstract Collection<String> supportedTags();

    /* JADX INFO: Access modifiers changed from: protected */
    public static void visitChildren(MarkwonVisitor markwonVisitor, MarkwonHtmlRenderer markwonHtmlRenderer, HtmlTag.Block block) {
        for (HtmlTag.Block block2 : block.children()) {
            if (block2.isClosed()) {
                TagHandler tagHandler = markwonHtmlRenderer.tagHandler(block2.name());
                if (tagHandler != null) {
                    tagHandler.handle(markwonVisitor, markwonHtmlRenderer, block2);
                } else {
                    visitChildren(markwonVisitor, markwonHtmlRenderer, block2);
                }
            }
        }
    }
}
