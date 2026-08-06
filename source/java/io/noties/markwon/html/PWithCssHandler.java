package io.noties.markwon.html;

import com.larus.business.markdown.api.extplugin.html.HtmlCssStyle;
import io.noties.markwon.MarkwonConfiguration;
import io.noties.markwon.RenderProps;
import io.noties.markwon.html.tag.SimpleTagHandler;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PWithCssHandler.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B#\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\"\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lio/noties/markwon/html/PWithCssHandler;", "Lio/noties/markwon/html/tag/SimpleTagHandler;", "htmlCssStyleMap", "", "", "Lcom/larus/business/markdown/api/extplugin/html/HtmlCssStyle;", "darkMode", "", "(Ljava/util/Map;Z)V", "getSpans", "", "configuration", "Lio/noties/markwon/MarkwonConfiguration;", "renderProps", "Lio/noties/markwon/RenderProps;", "tag", "Lio/noties/markwon/html/HtmlTag;", "supportedTags", "", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class PWithCssHandler extends SimpleTagHandler {
    private final boolean darkMode;
    private final Map<String, HtmlCssStyle> htmlCssStyleMap;

    public PWithCssHandler(Map<String, HtmlCssStyle> map, boolean z) {
        this.htmlCssStyleMap = map;
        this.darkMode = z;
    }

    @Override // io.noties.markwon.html.tag.SimpleTagHandler, io.noties.markwon.html.TagHandler
    public List<String> supportedTags() {
        return CollectionsKt.listOf("p");
    }

    @Override // io.noties.markwon.html.tag.SimpleTagHandler
    public Object getSpans(MarkwonConfiguration configuration, RenderProps renderProps, HtmlTag tag) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(renderProps, "renderProps");
        Intrinsics.checkNotNullParameter(tag, "tag");
        return CssAttributeHandler.INSTANCE.getSpans(tag, this.htmlCssStyleMap, this.darkMode);
    }
}
