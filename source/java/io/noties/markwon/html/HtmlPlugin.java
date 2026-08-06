package io.noties.markwon.html;

import android.widget.TextView;
import io.noties.markwon.AbstractMarkwonPlugin;
import io.noties.markwon.MarkwonConfiguration;
import io.noties.markwon.MarkwonVisitor;
import io.noties.markwon.html.MarkwonHtmlRendererImpl;
import io.noties.markwon.html.tag.BlockquoteHandler;
import io.noties.markwon.html.tag.EmphasisHandler;
import io.noties.markwon.html.tag.HeadingHandler;
import io.noties.markwon.html.tag.ImageHandler;
import io.noties.markwon.html.tag.LinkHandler;
import io.noties.markwon.html.tag.ListHandler;
import io.noties.markwon.html.tag.StrikeHandler;
import io.noties.markwon.html.tag.StrongEmphasisHandler;
import io.noties.markwon.html.tag.SubScriptHandler;
import io.noties.markwon.html.tag.SuperScriptHandler;
import io.noties.markwon.html.tag.UnderlineHandler;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.commonmark.node.HtmlBlock;
import org.commonmark.node.HtmlInline;
import org.commonmark.node.Node;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class HtmlPlugin extends AbstractMarkwonPlugin {
    public static final float SCRIPT_DEF_TEXT_SIZE_RATIO = 0.75f;
    protected MarkwonHtmlParser htmlParser;
    protected MarkwonHtmlRenderer htmlRenderer;
    protected HtmlEmptyTagReplacement emptyTagReplacement = new HtmlEmptyTagReplacement();
    protected final MarkwonHtmlRendererImpl.Builder builder = new MarkwonHtmlRendererImpl.Builder();
    protected final TagHandlerBuilder tagBuilder = new TagHandlerBuilder();

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public interface HtmlConfigure {
        void configureHtml(HtmlPlugin htmlPlugin);
    }

    public static HtmlPlugin create() {
        return new HtmlPlugin();
    }

    public static HtmlPlugin create(HtmlConfigure htmlConfigure) {
        HtmlPlugin create = create();
        htmlConfigure.configureHtml(create);
        return create;
    }

    public HtmlPlugin allowNonClosedTags(boolean z) {
        this.builder.allowNonClosedTags(z);
        return this;
    }

    public HtmlPlugin addHandler(TagHandler tagHandler) {
        this.tagBuilder.addHandler(tagHandler);
        return this;
    }

    public TagHandler getHandler(String str) {
        return this.tagBuilder.getHandler(str);
    }

    public HtmlPlugin additionBlockTags(Set<String> set) {
        this.tagBuilder.additionBlockTags.addAll(set);
        return this;
    }

    public HtmlPlugin additionInlineTags(Set<String> set) {
        this.tagBuilder.additionInlineTags.addAll(set);
        return this;
    }

    public HtmlPlugin excludeDefaults(boolean z) {
        this.tagBuilder.excludeDefaults(z);
        return this;
    }

    public HtmlPlugin emptyTagReplacement(HtmlEmptyTagReplacement htmlEmptyTagReplacement) {
        this.emptyTagReplacement = htmlEmptyTagReplacement;
        return this;
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void configureConfiguration(MarkwonConfiguration.Builder builder) {
        MarkwonHtmlRendererImpl.Builder builder2 = this.builder;
        if (!this.tagBuilder.excludeDefaults()) {
            this.tagBuilder.addDefaultTagHandler(ImageHandler.create());
            this.tagBuilder.addDefaultTagHandler(new LinkHandler());
            this.tagBuilder.addDefaultTagHandler(new BlockquoteHandler());
            this.tagBuilder.addDefaultTagHandler(new SubScriptHandler());
            this.tagBuilder.addDefaultTagHandler(new SuperScriptHandler());
            this.tagBuilder.addDefaultTagHandler(new StrongEmphasisHandler());
            this.tagBuilder.addDefaultTagHandler(new StrikeHandler());
            this.tagBuilder.addDefaultTagHandler(new UnderlineHandler());
            this.tagBuilder.addDefaultTagHandler(new ListHandler());
            this.tagBuilder.addDefaultTagHandler(new EmphasisHandler());
            this.tagBuilder.addDefaultTagHandler(new HeadingHandler());
        }
        Map<String, TagHandler> build = this.tagBuilder.build();
        this.htmlParser = MarkwonHtmlParserImpl.create(this.emptyTagReplacement, build, this.tagBuilder.additionBlockTags, this.tagBuilder.additionInlineTags);
        this.htmlRenderer = builder2.tagHandlers(build).build();
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void afterRender(TextView textView, Node node, MarkwonVisitor markwonVisitor) {
        MarkwonHtmlRenderer markwonHtmlRenderer = this.htmlRenderer;
        if (markwonHtmlRenderer != null) {
            markwonHtmlRenderer.render(markwonVisitor, this.htmlParser);
            return;
        }
        throw new IllegalStateException("Unexpected state, html-renderer is not defined");
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void afterRender(CharSequence charSequence, Node node, MarkwonVisitor markwonVisitor) {
        MarkwonHtmlRenderer markwonHtmlRenderer = this.htmlRenderer;
        if (markwonHtmlRenderer != null) {
            markwonHtmlRenderer.render(markwonVisitor, this.htmlParser);
            return;
        }
        throw new IllegalStateException("Unexpected state, html-renderer is not defined");
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void configureVisitor(MarkwonVisitor.Builder builder) {
        builder.mo2586on(HtmlBlock.class, new MarkwonVisitor.NodeVisitor<HtmlBlock>() { // from class: io.noties.markwon.html.HtmlPlugin.2
            @Override // io.noties.markwon.MarkwonVisitor.NodeVisitor
            public void visit(MarkwonVisitor markwonVisitor, HtmlBlock htmlBlock) {
                HtmlPlugin.this.visitHtml(markwonVisitor, htmlBlock.getLiteral());
            }
        }).mo2586on(HtmlInline.class, new MarkwonVisitor.NodeVisitor<HtmlInline>() { // from class: io.noties.markwon.html.HtmlPlugin.1
            @Override // io.noties.markwon.MarkwonVisitor.NodeVisitor
            public void visit(MarkwonVisitor markwonVisitor, HtmlInline htmlInline) {
                HtmlPlugin.this.visitHtml(markwonVisitor, htmlInline.getLiteral());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void visitHtml(MarkwonVisitor markwonVisitor, String str) {
        if (str != null) {
            this.htmlParser.processFragment(markwonVisitor.builder(), str);
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    protected static class TagHandlerBuilder {
        private boolean excludeDefaults;
        private boolean isBuilt;
        private final Map<String, TagHandler> tagHandlers = new HashMap(2);
        private final Set<String> additionBlockTags = new HashSet();
        private final Set<String> additionInlineTags = new HashSet();

        protected TagHandlerBuilder() {
        }

        void addHandler(TagHandler tagHandler) {
            checkState();
            Iterator<String> it = tagHandler.supportedTags().iterator();
            while (it.hasNext()) {
                this.tagHandlers.put(it.next(), tagHandler);
            }
        }

        TagHandler getHandler(String str) {
            checkState();
            return this.tagHandlers.get(str);
        }

        void excludeDefaults(boolean z) {
            checkState();
            this.excludeDefaults = z;
        }

        boolean excludeDefaults() {
            return this.excludeDefaults;
        }

        private void checkState() {
            if (this.isBuilt) {
                throw new IllegalStateException("Builder has been already built");
            }
        }

        void addDefaultTagHandler(TagHandler tagHandler) {
            for (String str : tagHandler.supportedTags()) {
                if (!this.tagHandlers.containsKey(str)) {
                    this.tagHandlers.put(str, tagHandler);
                }
            }
        }

        Map<String, TagHandler> build() {
            checkState();
            this.isBuilt = true;
            return Collections.unmodifiableMap(this.tagHandlers);
        }
    }
}
