package io.noties.markwon.html.tag;

import io.noties.markwon.MarkwonVisitor;
import io.noties.markwon.RenderProps;
import io.noties.markwon.SpanFactory;
import io.noties.markwon.SpannableBuilder;
import io.noties.markwon.core.CoreProps;
import io.noties.markwon.html.HtmlEmptyTagReplacement;
import io.noties.markwon.html.HtmlTag;
import io.noties.markwon.html.MarkwonHtmlRenderer;
import io.noties.markwon.html.span.SubReferenceSpan;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.node.Link;

/* compiled from: SubReferenceHandler.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, d2 = {"Lio/noties/markwon/html/tag/SubReferenceHandler;", "Lio/noties/markwon/html/tag/SubScriptHandler;", "theme", "Lio/noties/markwon/html/span/SubReferenceSpan$Theme;", "(Lio/noties/markwon/html/span/SubReferenceSpan$Theme;)V", "getTheme", "()Lio/noties/markwon/html/span/SubReferenceSpan$Theme;", "handle", "", "visitor", "Lio/noties/markwon/MarkwonVisitor;", "renderer", "Lio/noties/markwon/html/MarkwonHtmlRenderer;", "tag", "Lio/noties/markwon/html/HtmlTag;", "replaceTag", "", "emptyReplacement", "Lio/noties/markwon/html/HtmlEmptyTagReplacement;", "Companion", "markwon-html_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class SubReferenceHandler extends SubScriptHandler {
    public static final String Href = "href";
    public static final String Title = "title";
    private final SubReferenceSpan.Theme theme;

    public SubReferenceHandler(SubReferenceSpan.Theme theme) {
        Intrinsics.checkParameterIsNotNull(theme, "theme");
        this.theme = theme;
    }

    public final SubReferenceSpan.Theme getTheme() {
        return this.theme;
    }

    @Override // io.noties.markwon.html.tag.SimpleTagHandler, io.noties.markwon.html.TagHandler
    public void handle(MarkwonVisitor visitor, MarkwonHtmlRenderer renderer, HtmlTag tag) {
        Intrinsics.checkParameterIsNotNull(visitor, "visitor");
        Intrinsics.checkParameterIsNotNull(renderer, "renderer");
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Map<String, String> attributes = tag.attributes();
        Intrinsics.checkExpressionValueIsNotNull(attributes, "tag.attributes()");
        String str = attributes.get("title");
        String str2 = attributes.get("href");
        String textContent = tag.textContent();
        Intrinsics.checkExpressionValueIsNotNull(textContent, "tag.textContent()");
        if (str != null && str2 != null) {
            if (tag.isBlock()) {
                SubScriptHandler.visitChildren(visitor, renderer, tag.getAsBlock());
            }
            SpannableBuilder.setSpans(visitor.builder(), new SubReferenceSpan(textContent, str, str2, this.theme), tag.start(), tag.end());
            SpanFactory spanFactory = visitor.configuration().spansFactory().get(Link.class);
            if (spanFactory != null) {
                RenderProps renderProps = visitor.renderProps();
                Intrinsics.checkExpressionValueIsNotNull(renderProps, "visitor.renderProps()");
                CoreProps.LINK_DESTINATION.set(renderProps, str2);
                CoreProps.LINK_EXTRA.set(renderProps, MapsKt.mapOf(new Pair[]{TuplesKt.to("type", "sub"), TuplesKt.to("start", String.valueOf(tag.start())), TuplesKt.to("end", String.valueOf(tag.end()))}));
                SpannableBuilder.setSpans(visitor.builder(), spanFactory.getSpans(visitor.configuration(), renderProps), tag.start(), tag.end());
                CoreProps.LINK_EXTRA.clear(renderProps);
                return;
            }
            return;
        }
        super.handle(visitor, renderer, tag);
    }

    @Override // io.noties.markwon.html.TagHandler
    public CharSequence replaceTag(HtmlTag tag, HtmlEmptyTagReplacement emptyReplacement) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(emptyReplacement, "emptyReplacement");
        Map<String, String> attributes = tag.attributes();
        Intrinsics.checkExpressionValueIsNotNull(attributes, "tag.attributes()");
        String str = attributes.get("href");
        if (str != null) {
            return "(" + str + ')';
        }
        return super.replaceTag(tag, emptyReplacement);
    }
}
