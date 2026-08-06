package io.noties.markwon.maybe;

import android.widget.TextView;
import com.lynx.tasm.behavior.PropsConstants;
import io.noties.markwon.AbstractMarkwonPlugin;
import io.noties.markwon.DelegateVisitor;
import io.noties.markwon.MarkwonPlugin;
import io.noties.markwon.MarkwonVisitor;
import io.noties.markwon.core.MarkwonTheme;
import io.noties.markwon.html.jsoup.parser.CharacterReader;
import io.noties.markwon.html.jsoup.parser.ParseErrorList;
import io.noties.markwon.html.jsoup.parser.Token;
import io.noties.markwon.html.jsoup.parser.Tokeniser;
import io.noties.markwon.inlineparser.BangInlineProcessor;
import io.noties.markwon.inlineparser.MarkwonInlineParserPlugin;
import io.noties.markwon.inlineparser.OpenBracketInlineProcessor;
import io.noties.markwon.maybe.MaybeFencedCodeBlockParser;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.ext.gfm.tables.TableBlock;
import org.commonmark.internal.DocumentParser;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.HtmlInline;
import org.commonmark.node.Image;
import org.commonmark.node.Link;
import org.commonmark.node.Node;
import org.commonmark.node.Text;
import org.commonmark.parser.Parser;

/* compiled from: MaybePlugin.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 +2\u00020\u0001:\u0003+,-B\u0019\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000bH\u0016J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0014J\u0018\u0010\"\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020#H\u0014J\u0018\u0010$\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020%H\u0014J\u001c\u0010&\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001f2\n\u0010'\u001a\u0006\u0012\u0002\b\u00030(H\u0014J\u0018\u0010)\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020*H\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lio/noties/markwon/maybe/MaybePlugin;", "Lio/noties/markwon/AbstractMarkwonPlugin;", "feature", "", "hideFeature", "(II)V", "getFeature", "()I", "getHideFeature", "originMarkdown", "Ljava/util/concurrent/atomic/AtomicReference;", "", "afterSetText", "", "textView", "Landroid/widget/TextView;", "configure", "registry", "Lio/noties/markwon/MarkwonPlugin$Registry;", "configureParser", "builder", "Lorg/commonmark/parser/Parser$Builder;", "configureTheme", "Lio/noties/markwon/core/MarkwonTheme$Builder;", "configureVisitor", "Lio/noties/markwon/MarkwonVisitor$Builder;", "processMarkdown", "markdown", "visitHtmlInline", "", "visitor", "Lio/noties/markwon/MarkwonVisitor;", "maybe", "Lorg/commonmark/node/HtmlInline;", "visitImage", "Lorg/commonmark/node/Image;", "visitLink", "Lorg/commonmark/node/Link;", "visitMaybe", "node", "Lio/noties/markwon/maybe/MaybeNode;", "visitTable", "Lorg/commonmark/ext/gfm/tables/TableBlock;", "Companion", "Feature", "MaybeChildVisitor", "markwon-maybe_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class MaybePlugin extends AbstractMarkwonPlugin {
    public static final int CODE_BLOCK = 16;
    public static final int HTML = 1;
    public static final int IMG = 2;
    public static final int LINK = 4;
    public static final int TABLE = 8;
    private final int feature;
    private final int hideFeature;
    private final AtomicReference<String> originMarkdown;

    /* compiled from: MaybePlugin.kt */
    @Retention(RetentionPolicy.RUNTIME)
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0086\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lio/noties/markwon/maybe/MaybePlugin$Feature;", "", "markwon-maybe_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public @interface Feature {
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MaybePlugin() {
        this(r2, r2, 3, null);
        int i = 0;
    }

    public final int getFeature() {
        return this.feature;
    }

    public /* synthetic */ MaybePlugin(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 29 : i, (i3 & 2) != 0 ? 2 : i2);
    }

    public final int getHideFeature() {
        return this.hideFeature;
    }

    public MaybePlugin(@Feature int i, @Feature int i2) {
        this.feature = i;
        this.hideFeature = i2;
        this.originMarkdown = new AtomicReference<>();
    }

    public void configureTheme(MarkwonTheme.Builder builder) {
        Intrinsics.checkParameterIsNotNull(builder, "builder");
        builder.showImagePlaceHolderIfDestinationBlank((this.feature & 2) != 0);
    }

    public void configure(MarkwonPlugin.Registry registry) {
        Intrinsics.checkParameterIsNotNull(registry, "registry");
        if ((this.feature & 1) != 0 || (this.hideFeature & 1) != 0) {
            registry.require(MarkwonInlineParserPlugin.class).factoryBuilder().addInlineProcessor(new MaybeHtmlProcessor(this.originMarkdown));
        }
        if ((this.feature & 2) != 0 || (this.hideFeature & 2) != 0) {
            registry.require(MarkwonInlineParserPlugin.class).factoryBuilder().excludeInlineProcessor(BangInlineProcessor.class).addInlineProcessor(new MaybeImageProcessor(this.originMarkdown));
        }
        if ((this.feature & 4) != 0 || (this.hideFeature & 4) != 0) {
            registry.require(MarkwonInlineParserPlugin.class).factoryBuilder().excludeInlineProcessor(OpenBracketInlineProcessor.class).addInlineProcessor(new MaybeLinkProcessor(this.originMarkdown));
        }
        if ((this.feature & 8) == 0 && (this.hideFeature & 8) == 0) {
            return;
        }
        registry.require(MarkwonInlineParserPlugin.class).factoryBuilder().addInlineProcessor(new MaybeTableProcessor(this.originMarkdown));
    }

    public void configureParser(Parser.Builder builder) {
        Intrinsics.checkParameterIsNotNull(builder, "builder");
        if (this.feature != 0) {
            builder.postProcessor(new CheckMaybeNode());
        }
        if ((this.feature & 16) != 0) {
            Set defaultBlockParserTypes = DocumentParser.getDefaultBlockParserTypes();
            Intrinsics.checkExpressionValueIsNotNull(defaultBlockParserTypes, "DocumentParser.getDefaultBlockParserTypes()");
            Set mutableSet = CollectionsKt.toMutableSet(defaultBlockParserTypes);
            mutableSet.remove(FencedCodeBlock.class);
            builder.enabledBlockTypes(mutableSet);
            builder.customBlockParserFactory(new MaybeFencedCodeBlockParser.Factory());
        }
    }

    public String processMarkdown(String markdown) {
        Intrinsics.checkParameterIsNotNull(markdown, "markdown");
        this.originMarkdown.set(markdown);
        String processMarkdown = super.processMarkdown(markdown);
        Intrinsics.checkExpressionValueIsNotNull(processMarkdown, "super.processMarkdown(markdown)");
        return processMarkdown;
    }

    public void afterSetText(TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "textView");
        super.afterSetText(textView);
        this.originMarkdown.set("");
    }

    public void configureVisitor(MarkwonVisitor.Builder builder) {
        Intrinsics.checkParameterIsNotNull(builder, "builder");
        final MaybePlugin$configureVisitor$1 maybePlugin$configureVisitor$1 = new MaybePlugin$configureVisitor$1(this);
        builder.on(MaybeNode.class, new MarkwonVisitor.NodeVisitor() { // from class: io.noties.markwon.maybe.MaybePlugin$sam$io_noties_markwon_MarkwonVisitor_NodeVisitor$0
            public final /* synthetic */ void visit(MarkwonVisitor markwonVisitor, Node node) {
                Intrinsics.checkParameterIsNotNull(markwonVisitor, "p0");
                Intrinsics.checkExpressionValueIsNotNull(maybePlugin$configureVisitor$1.invoke(markwonVisitor, node), "invoke(...)");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void visitMaybe(MarkwonVisitor visitor, MaybeNode<?> node) {
        Intrinsics.checkParameterIsNotNull(visitor, "visitor");
        Intrinsics.checkParameterIsNotNull(node, "node");
        if ((this.feature & 1) != 0 && (node.target instanceof HtmlInline) && visitHtmlInline(visitor, (HtmlInline) node.target)) {
            return;
        }
        if ((this.feature & 2) != 0 && (node.target instanceof Image) && visitImage(visitor, (Image) node.target)) {
            return;
        }
        if ((this.feature & 4) != 0 && (node.target instanceof Link) && visitLink(visitor, (Link) node.target)) {
            return;
        }
        if ((this.feature & 8) != 0 && (node.target instanceof TableBlock) && visitTable(visitor, (TableBlock) node.target)) {
            return;
        }
        new MaybeChildVisitor(visitor).visitChildren(node);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [io.noties.markwon.maybe.MaybePlugin$visitHtmlInline$1] */
    protected boolean visitHtmlInline(final MarkwonVisitor visitor, HtmlInline maybe) {
        Intrinsics.checkParameterIsNotNull(visitor, "visitor");
        Intrinsics.checkParameterIsNotNull(maybe, "maybe");
        ?? r0 = new Function1<HtmlInline, Unit>() { // from class: io.noties.markwon.maybe.MaybePlugin$visitHtmlInline$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((HtmlInline) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(HtmlInline htmlInline) {
                Intrinsics.checkParameterIsNotNull(htmlInline, "html");
                Node node = (Node) htmlInline;
                MarkwonVisitor.NodeVisitor nodeVisitor = visitor.getNodeVisitor(node);
                if (nodeVisitor != null) {
                    Intrinsics.checkExpressionValueIsNotNull(nodeVisitor, "visitor.getNodeVisitor(h…re require HtmlPlugin!!\")");
                    nodeVisitor.visit(visitor, node);
                    return;
                }
                throw new IllegalStateException("HTML feature require HtmlPlugin!!");
            }
        };
        Tokeniser tokeniser = new Tokeniser(new CharacterReader(maybe.getLiteral()), ParseErrorList.noTracking());
        if (tokeniser.read().type == Token.TokenType.EOF) {
            Token.Tag pendingTag = tokeniser.getPendingTag();
            if (pendingTag == null) {
                return false;
            }
            HtmlInline htmlInline = new HtmlInline();
            htmlInline.setLiteral(pendingTag.toString());
            r0.invoke(htmlInline);
            return false;
        }
        r0.invoke(maybe);
        return true;
    }

    protected boolean visitImage(MarkwonVisitor visitor, Image maybe) {
        Intrinsics.checkParameterIsNotNull(visitor, "visitor");
        Intrinsics.checkParameterIsNotNull(maybe, "maybe");
        Node node = (Node) maybe;
        MarkwonVisitor.NodeVisitor nodeVisitor = visitor.getNodeVisitor(node);
        if (nodeVisitor == null) {
            return false;
        }
        nodeVisitor.visit(visitor, node);
        return true;
    }

    protected boolean visitLink(MarkwonVisitor visitor, Link maybe) {
        Intrinsics.checkParameterIsNotNull(visitor, "visitor");
        Intrinsics.checkParameterIsNotNull(maybe, "maybe");
        visitor.builder().append(maybe.getTitle());
        return true;
    }

    protected boolean visitTable(MarkwonVisitor visitor, TableBlock maybe) {
        Intrinsics.checkParameterIsNotNull(visitor, "visitor");
        Intrinsics.checkParameterIsNotNull(maybe, "maybe");
        Node node = (Node) maybe;
        MarkwonVisitor.NodeVisitor nodeVisitor = visitor.getNodeVisitor(node);
        if (nodeVisitor == null) {
            return false;
        }
        nodeVisitor.visit(visitor, node);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: MaybePlugin.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0014\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lio/noties/markwon/maybe/MaybePlugin$MaybeChildVisitor;", "Lio/noties/markwon/DelegateVisitor;", "visitor", "Lio/noties/markwon/MarkwonVisitor;", "(Lio/noties/markwon/MarkwonVisitor;)V", "visit", "", PropsConstants.TEXT, "Lorg/commonmark/node/Text;", "markwon-maybe_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class MaybeChildVisitor extends DelegateVisitor {
        public void visit(Text text) {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MaybeChildVisitor(MarkwonVisitor markwonVisitor) {
            super(markwonVisitor);
            Intrinsics.checkParameterIsNotNull(markwonVisitor, "visitor");
        }
    }
}
