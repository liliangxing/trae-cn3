package io.noties.markwon.html;

import io.noties.markwon.MarkwonVisitor;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
class MarkwonHtmlRendererNoOp extends MarkwonHtmlRenderer {
    @Override // io.noties.markwon.html.MarkwonHtmlRenderer
    public TagHandler tagHandler(String str) {
        return null;
    }

    @Override // io.noties.markwon.html.MarkwonHtmlRenderer
    public void render(MarkwonVisitor markwonVisitor, MarkwonHtmlParser markwonHtmlParser) {
        markwonHtmlParser.reset();
    }
}
