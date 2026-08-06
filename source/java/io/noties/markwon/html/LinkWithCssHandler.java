package io.noties.markwon.html;

import com.larus.business.markdown.api.extplugin.html.HtmlCssStyle;
import io.noties.markwon.MarkwonConfiguration;
import io.noties.markwon.RenderProps;
import io.noties.markwon.html.tag.LinkHandler;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LinkWithCssHandler.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B#\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\"\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lio/noties/markwon/html/LinkWithCssHandler;", "Lio/noties/markwon/html/tag/LinkHandler;", "htmlCssStyleMap", "", "", "Lcom/larus/business/markdown/api/extplugin/html/HtmlCssStyle;", "darkMode", "", "(Ljava/util/Map;Z)V", "getSpans", "", "configuration", "Lio/noties/markwon/MarkwonConfiguration;", "renderProps", "Lio/noties/markwon/RenderProps;", "tag", "Lio/noties/markwon/html/HtmlTag;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class LinkWithCssHandler extends LinkHandler {
    private final boolean darkMode;
    private final Map<String, HtmlCssStyle> htmlCssStyleMap;

    public LinkWithCssHandler(Map<String, HtmlCssStyle> map, boolean z) {
        this.htmlCssStyleMap = map;
        this.darkMode = z;
    }

    @Override // io.noties.markwon.html.tag.LinkHandler, io.noties.markwon.html.tag.SimpleTagHandler
    public Object getSpans(MarkwonConfiguration configuration, RenderProps renderProps, HtmlTag tag) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(renderProps, "renderProps");
        Intrinsics.checkNotNullParameter(tag, "tag");
        return CssAttributeHandler.INSTANCE.joinSpans(super.getSpans(configuration, renderProps, tag), CssAttributeHandler.INSTANCE.getSpans(tag, this.htmlCssStyleMap, this.darkMode));
    }
}
