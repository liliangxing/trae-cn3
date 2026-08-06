package io.noties.markwon.html;

import io.noties.markwon.MarkwonVisitor;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public abstract class MarkwonHtmlRenderer {
    public abstract void render(MarkwonVisitor markwonVisitor, MarkwonHtmlParser markwonHtmlParser);

    public abstract TagHandler tagHandler(String str);
}
