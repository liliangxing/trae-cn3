package io.noties.markwon.core;

import android.widget.TextView;
import com.lynx.jsbridge.LynxResourceModule;
import io.noties.markwon.MarkwonConfiguration;
import io.noties.markwon.MarkwonVisitor;
import io.noties.markwon.Prop;
import io.noties.markwon.RenderProps;
import io.noties.markwon.SpanFactory;
import io.noties.markwon.core.spans.CustomExtraLineHeightSpan;
import io.noties.markwon.image.ImageProps;
import io.noties.markwon.image.ImageSize;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.commonmark.node.Image;
import org.commonmark.node.Link;
import org.commonmark.node.Node;
import org.commonmark.node.Text;

/* compiled from: CorePlugin2.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\"\u0010\u0003\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¨\u0006\u0016"}, d2 = {"Lio/noties/markwon/core/CorePlugin2;", "Lio/noties/markwon/core/CorePlugin;", "()V", "afterRender", "", "textView", "Landroid/widget/TextView;", "node", "Lorg/commonmark/node/Node;", "visitor", "Lio/noties/markwon/MarkwonVisitor;", "reuseCharSequence", "", "configureVisitor", "builder", "Lio/noties/markwon/MarkwonVisitor$Builder;", "getImageSizeFromUrl", "Lio/noties/markwon/image/ImageSize;", "url", "", LynxResourceModule.IMAGE_TYPE, "Companion", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class CorePlugin2 extends CorePlugin {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Prop<String> LINK_TITLE;

    @Override // io.noties.markwon.core.CorePlugin, io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void afterRender(TextView textView, Node node, MarkwonVisitor visitor) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        afterRender(node, visitor);
    }

    @Override // io.noties.markwon.core.CorePlugin, io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void afterRender(CharSequence reuseCharSequence, Node node, MarkwonVisitor visitor) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        afterRender(node, visitor);
    }

    /* compiled from: CorePlugin2.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u001f\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lio/noties/markwon/core/CorePlugin2$Companion;", "", "()V", "LINK_TITLE", "Lio/noties/markwon/Prop;", "", "kotlin.jvm.PlatformType", "getLINK_TITLE", "()Lio/noties/markwon/Prop;", "setCommonLineHeight", "", "visitor", "Lio/noties/markwon/MarkwonVisitor;", "loading", "", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Prop<String> getLINK_TITLE() {
            return CorePlugin2.LINK_TITLE;
        }

        public final void setCommonLineHeight(MarkwonVisitor visitor, boolean loading) {
            Intrinsics.checkNotNullParameter(visitor, "visitor");
            MarkwonTheme theme = visitor.configuration().theme();
            Intrinsics.checkNotNullExpressionValue(theme, "visitor.configuration().theme()");
            if (theme.blankSpaceMulti == 1.0f) {
                if (theme.textLineMulti == 1.0f) {
                    return;
                }
            }
            visitor.setSpans(0, new CustomExtraLineHeightSpan(theme.blankSpaceMulti, theme.textLineMulti, loading));
        }
    }

    static {
        Prop<String> m2588of = Prop.m2588of("link-title");
        Intrinsics.checkNotNullExpressionValue(m2588of, "of<String>(\"link-title\")");
        LINK_TITLE = m2588of;
    }

    @Override // io.noties.markwon.core.CorePlugin, io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void configureVisitor(MarkwonVisitor.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        super.configureVisitor(builder);
        builder.mo2586on(Link.class, new MarkwonVisitor.NodeVisitor() { // from class: io.noties.markwon.core.CorePlugin2$configureVisitor$1
            @Override // io.noties.markwon.MarkwonVisitor.NodeVisitor
            public final void visit(MarkwonVisitor markwonVisitor, Link link) {
                String literal;
                Intrinsics.checkNotNullParameter(markwonVisitor, "visitor");
                Intrinsics.checkNotNullParameter(link, "link");
                int length = markwonVisitor.length();
                Node node = (Node) link;
                markwonVisitor.visitChildren(node);
                CoreProps.LINK_DESTINATION.set(markwonVisitor.renderProps(), link.getDestination());
                Prop<String> link_title = CorePlugin2.INSTANCE.getLINK_TITLE();
                RenderProps renderProps = markwonVisitor.renderProps();
                String title = link.getTitle();
                if (title == null || StringsKt.isBlank(title)) {
                    Text text = link.firstChild;
                    Text text2 = text instanceof Text ? text : null;
                    literal = text2 != null ? text2.getLiteral() : null;
                    if (literal == null) {
                        literal = "";
                    }
                } else {
                    literal = link.getTitle();
                }
                link_title.set(renderProps, literal);
                markwonVisitor.setSpansForNodeOptional((MarkwonVisitor) node, length);
            }
        });
        image(builder);
    }

    private final void image(MarkwonVisitor.Builder builder) {
        builder.mo2586on(Image.class, new MarkwonVisitor.NodeVisitor() { // from class: io.noties.markwon.core.CorePlugin2$image$1
            @Override // io.noties.markwon.MarkwonVisitor.NodeVisitor
            public final void visit(MarkwonVisitor markwonVisitor, Image image) {
                ImageSize imageSizeFromUrl;
                Intrinsics.checkNotNullParameter(markwonVisitor, "visitor");
                Intrinsics.checkNotNullParameter(image, LynxResourceModule.IMAGE_TYPE);
                SpanFactory spanFactory = markwonVisitor.configuration().spansFactory().get(Image.class);
                if (spanFactory == null) {
                    markwonVisitor.visitChildren((Node) image);
                    return;
                }
                int length = markwonVisitor.length();
                markwonVisitor.visitChildren((Node) image);
                if (length == markwonVisitor.length()) {
                    markwonVisitor.builder().append((char) 65532);
                }
                MarkwonConfiguration configuration = markwonVisitor.configuration();
                Intrinsics.checkNotNullExpressionValue(configuration, "visitor.configuration()");
                Node node = image.parent;
                Intrinsics.checkNotNullExpressionValue(node, "image.parent");
                String process = configuration.imageDestinationProcessor().process(image.getDestination());
                Intrinsics.checkNotNullExpressionValue(process, "configuration\n          …rocess(image.destination)");
                RenderProps renderProps = markwonVisitor.renderProps();
                Intrinsics.checkNotNullExpressionValue(renderProps, "visitor.renderProps()");
                ImageProps.DESTINATION.set(renderProps, process);
                ImageProps.REPLACEMENT_TEXT_IS_LINK.set(renderProps, Boolean.valueOf(node instanceof Link));
                Prop<ImageSize> prop = ImageProps.IMAGE_SIZE;
                imageSizeFromUrl = CorePlugin2.this.getImageSizeFromUrl(process);
                prop.set(renderProps, imageSizeFromUrl);
                ImageProps.IMAGE_START_INDEX.set(renderProps, Integer.valueOf(length));
                ImageProps.IMAGE_END_INDEX.set(renderProps, Integer.valueOf(markwonVisitor.builder().length()));
                markwonVisitor.setSpans(length, spanFactory.getSpans(configuration, renderProps));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageSize getImageSizeFromUrl(String url) {
        Matcher matcher = Pattern.compile(":(\\d+):(\\d+):(\\d+):(\\d+):(\\d+):(\\d+)").matcher(url);
        if (!matcher.find()) {
            return null;
        }
        String group = matcher.group();
        Intrinsics.checkNotNullExpressionValue(group, "extracted");
        List split$default = StringsKt.split$default(group, new String[]{":"}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList();
        Iterator it = split$default.iterator();
        while (it.hasNext()) {
            Integer intOrNull = StringsKt.toIntOrNull((String) it.next());
            if (intOrNull != null) {
                arrayList.add(intOrNull);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.size() < 4) {
            return null;
        }
        int intValue = ((Number) arrayList2.get(2)).intValue() - ((Number) arrayList2.get(0)).intValue();
        int intValue2 = ((Number) arrayList2.get(3)).intValue() - ((Number) arrayList2.get(1)).intValue();
        if (intValue <= 0 || intValue2 <= 0) {
            return null;
        }
        return new ImageSize(new ImageSize.Dimension(intValue, "px"), new ImageSize.Dimension(intValue2, "px"));
    }
}
