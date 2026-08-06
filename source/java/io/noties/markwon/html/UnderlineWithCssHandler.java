package io.noties.markwon.html;

import com.larus.business.markdown.api.extplugin.html.HtmlCssStyle;
import io.noties.markwon.MarkwonVisitor;
import io.noties.markwon.SpannableBuilder;
import io.noties.markwon.html.tag.UnderlineHandler;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UnderlineWithCssHandler.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B#\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lio/noties/markwon/html/UnderlineWithCssHandler;", "Lio/noties/markwon/html/tag/UnderlineHandler;", "htmlCssStyleMap", "", "", "Lcom/larus/business/markdown/api/extplugin/html/HtmlCssStyle;", "darkMode", "", "(Ljava/util/Map;Z)V", "handle", "", "visitor", "Lio/noties/markwon/MarkwonVisitor;", "renderer", "Lio/noties/markwon/html/MarkwonHtmlRenderer;", "tag", "Lio/noties/markwon/html/HtmlTag;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class UnderlineWithCssHandler extends UnderlineHandler {
    private final boolean darkMode;
    private final Map<String, HtmlCssStyle> htmlCssStyleMap;

    public UnderlineWithCssHandler(Map<String, HtmlCssStyle> map, boolean z) {
        this.htmlCssStyleMap = map;
        this.darkMode = z;
    }

    @Override // io.noties.markwon.html.tag.UnderlineHandler, io.noties.markwon.html.TagHandler
    public void handle(MarkwonVisitor visitor, MarkwonHtmlRenderer renderer, HtmlTag tag) {
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        Intrinsics.checkNotNullParameter(renderer, "renderer");
        Intrinsics.checkNotNullParameter(tag, "tag");
        super.handle(visitor, renderer, tag);
        SpannableBuilder.setSpans(visitor.builder(), CssAttributeHandler.INSTANCE.getSpans(tag, this.htmlCssStyleMap, this.darkMode), tag.start(), tag.end());
    }
}
