package io.noties.markwon.html.tag;

import io.noties.markwon.MarkwonConfiguration;
import io.noties.markwon.RenderProps;
import io.noties.markwon.SpanFactory;
import io.noties.markwon.html.HtmlTag;
import io.noties.markwon.image.CustomImageSizeResolverDef;
import java.util.Arrays;
import java.util.Collection;
import org.commonmark.node.Emphasis;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class EmphasisHandler extends SimpleTagHandler {
    @Override // io.noties.markwon.html.tag.SimpleTagHandler
    public Object getSpans(MarkwonConfiguration markwonConfiguration, RenderProps renderProps, HtmlTag htmlTag) {
        SpanFactory spanFactory = markwonConfiguration.spansFactory().get(Emphasis.class);
        if (spanFactory == null) {
            return null;
        }
        return spanFactory.getSpans(markwonConfiguration, renderProps);
    }

    @Override // io.noties.markwon.html.tag.SimpleTagHandler, io.noties.markwon.html.TagHandler
    public Collection<String> supportedTags() {
        return Arrays.asList("i", CustomImageSizeResolverDef.UNIT_EM, "cite", "dfn");
    }
}
