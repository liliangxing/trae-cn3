package io.noties.markwon.core;

import io.noties.markwon.AbstractMarkwonPlugin;
import io.noties.markwon.MarkwonConfiguration;
import io.noties.markwon.MarkwonSpansFactory;
import io.noties.markwon.MarkwonVisitor;
import io.noties.markwon.Prop;
import io.noties.markwon.RenderProps;
import io.noties.markwon.SpanFactory;
import io.noties.markwon.core.MarkwonTheme;
import io.noties.markwon.core.spans.RoundCornerCodeBlockSpan;
import io.noties.markwon.scrollable.HorizontalScrollable;
import io.noties.markwon.scrollable.ScrollBarTheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.IndentedCodeBlock;
import org.commonmark.node.Node;

/* compiled from: CodeBlockPlugin.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0015H\u0016J*\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\r0\r0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lio/noties/markwon/core/CodeBlockPlugin;", "Lio/noties/markwon/AbstractMarkwonPlugin;", "codeBlockTheme", "Lio/noties/markwon/core/CodeBlockTheme;", "scrollBarTheme", "Lio/noties/markwon/scrollable/ScrollBarTheme;", "(Lio/noties/markwon/core/CodeBlockTheme;Lio/noties/markwon/scrollable/ScrollBarTheme;)V", "codeEndIndex", "Lio/noties/markwon/Prop;", "", "kotlin.jvm.PlatformType", "codeStartIndex", "scrollableSpan", "Lio/noties/markwon/scrollable/HorizontalScrollable;", "configureSpansFactory", "", "builder", "Lio/noties/markwon/MarkwonSpansFactory$Builder;", "configureTheme", "Lio/noties/markwon/core/MarkwonTheme$Builder;", "configureVisitor", "Lio/noties/markwon/MarkwonVisitor$Builder;", "visitCodeBlock", "visitor", "Lio/noties/markwon/MarkwonVisitor;", "info", "", "code", "node", "Lorg/commonmark/node/Node;", "markwon-core_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class CodeBlockPlugin extends AbstractMarkwonPlugin {
    private final CodeBlockTheme codeBlockTheme;
    private final Prop<Integer> codeEndIndex;
    private final Prop<Integer> codeStartIndex;
    private final ScrollBarTheme scrollBarTheme;
    private final Prop<HorizontalScrollable> scrollableSpan;

    public CodeBlockPlugin(CodeBlockTheme codeBlockTheme, ScrollBarTheme scrollBarTheme) {
        Intrinsics.checkParameterIsNotNull(codeBlockTheme, "codeBlockTheme");
        Intrinsics.checkParameterIsNotNull(scrollBarTheme, "scrollBarTheme");
        this.codeBlockTheme = codeBlockTheme;
        this.scrollBarTheme = scrollBarTheme;
        Prop<Integer> m2588of = Prop.m2588of("code-block-start-index");
        Intrinsics.checkExpressionValueIsNotNull(m2588of, "Prop.of<Int>(\"code-block-start-index\")");
        this.codeStartIndex = m2588of;
        Prop<Integer> m2588of2 = Prop.m2588of("code-block-end-index");
        Intrinsics.checkExpressionValueIsNotNull(m2588of2, "Prop.of<Int>(\"code-block-end-index\")");
        this.codeEndIndex = m2588of2;
        Prop<HorizontalScrollable> m2588of3 = Prop.m2588of("code-block-scrollable");
        Intrinsics.checkExpressionValueIsNotNull(m2588of3, "Prop.of<HorizontalScroll…(\"code-block-scrollable\")");
        this.scrollableSpan = m2588of3;
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void configureTheme(MarkwonTheme.Builder builder) {
        Intrinsics.checkParameterIsNotNull(builder, "builder");
        builder.codeBlockBackgroundColor(this.codeBlockTheme.getCodeBlockBgColor());
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void configureVisitor(MarkwonVisitor.Builder builder) {
        Intrinsics.checkParameterIsNotNull(builder, "builder");
        builder.mo2586on(FencedCodeBlock.class, new MarkwonVisitor.NodeVisitor<FencedCodeBlock>() { // from class: io.noties.markwon.core.CodeBlockPlugin$configureVisitor$1
            @Override // io.noties.markwon.MarkwonVisitor.NodeVisitor
            public final void visit(MarkwonVisitor markwonVisitor, FencedCodeBlock fencedCodeBlock) {
                Intrinsics.checkParameterIsNotNull(markwonVisitor, "visitor");
                Intrinsics.checkParameterIsNotNull(fencedCodeBlock, "fencedCodeBlock");
                CodeBlockPlugin codeBlockPlugin = CodeBlockPlugin.this;
                String info = fencedCodeBlock.getInfo();
                String literal = fencedCodeBlock.getLiteral();
                Intrinsics.checkExpressionValueIsNotNull(literal, "fencedCodeBlock.literal");
                codeBlockPlugin.visitCodeBlock(markwonVisitor, info, literal, (Node) fencedCodeBlock);
            }
        });
        builder.mo2586on(IndentedCodeBlock.class, new MarkwonVisitor.NodeVisitor<IndentedCodeBlock>() { // from class: io.noties.markwon.core.CodeBlockPlugin$configureVisitor$2
            @Override // io.noties.markwon.MarkwonVisitor.NodeVisitor
            public final void visit(MarkwonVisitor markwonVisitor, IndentedCodeBlock indentedCodeBlock) {
                Intrinsics.checkParameterIsNotNull(markwonVisitor, "visitor");
                Intrinsics.checkParameterIsNotNull(indentedCodeBlock, "indentedCodeBlock");
                CodeBlockPlugin codeBlockPlugin = CodeBlockPlugin.this;
                String literal = indentedCodeBlock.getLiteral();
                Intrinsics.checkExpressionValueIsNotNull(literal, "indentedCodeBlock.literal");
                codeBlockPlugin.visitCodeBlock(markwonVisitor, null, literal, (Node) indentedCodeBlock);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void visitCodeBlock(MarkwonVisitor visitor, String info, String code, Node node) {
        visitor.blockStart(node);
        int length = visitor.length();
        visitor.builder().append(visitor.configuration().syntaxHighlight().highlight(info, code));
        visitor.ensureNewLine();
        visitor.renderProps().set(CoreProps.CODE_BLOCK_INFO, info);
        visitor.renderProps().set(this.codeStartIndex, Integer.valueOf(length));
        visitor.renderProps().set(this.codeEndIndex, Integer.valueOf(visitor.length()));
        if (this.codeBlockTheme.getScrollable()) {
            HorizontalScrollable horizontalScrollable = new HorizontalScrollable(0.0f);
            visitor.renderProps().set(this.scrollableSpan, horizontalScrollable);
            visitor.setSpans(length, horizontalScrollable);
        }
        visitor.setSpansForNodeOptional((MarkwonVisitor) node, length);
        visitor.blockEnd(node);
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void configureSpansFactory(MarkwonSpansFactory.Builder builder) {
        Intrinsics.checkParameterIsNotNull(builder, "builder");
        SpanFactory spanFactory = new SpanFactory() { // from class: io.noties.markwon.core.CodeBlockPlugin$configureSpansFactory$codeBlockSpanFactory$1
            @Override // io.noties.markwon.SpanFactory
            public final RoundCornerCodeBlockSpan getSpans(MarkwonConfiguration markwonConfiguration, RenderProps renderProps) {
                Prop prop;
                Prop prop2;
                Prop prop3;
                CodeBlockTheme codeBlockTheme;
                ScrollBarTheme scrollBarTheme;
                Intrinsics.checkParameterIsNotNull(markwonConfiguration, "<anonymous parameter 0>");
                Intrinsics.checkParameterIsNotNull(renderProps, "props");
                prop = CodeBlockPlugin.this.codeStartIndex;
                Object obj = renderProps.get(prop);
                if (obj == null) {
                    Intrinsics.throwNpe();
                }
                Intrinsics.checkExpressionValueIsNotNull(obj, "props[codeStartIndex]!!");
                int intValue = ((Number) obj).intValue();
                prop2 = CodeBlockPlugin.this.codeEndIndex;
                Object obj2 = renderProps.get(prop2);
                if (obj2 == null) {
                    Intrinsics.throwNpe();
                }
                Intrinsics.checkExpressionValueIsNotNull(obj2, "props[codeEndIndex]!!");
                int intValue2 = ((Number) obj2).intValue();
                prop3 = CodeBlockPlugin.this.scrollableSpan;
                HorizontalScrollable horizontalScrollable = (HorizontalScrollable) renderProps.get(prop3);
                codeBlockTheme = CodeBlockPlugin.this.codeBlockTheme;
                scrollBarTheme = CodeBlockPlugin.this.scrollBarTheme;
                return new RoundCornerCodeBlockSpan(codeBlockTheme, scrollBarTheme, intValue, intValue2, horizontalScrollable);
            }
        };
        builder.setFactory(FencedCodeBlock.class, spanFactory).setFactory(IndentedCodeBlock.class, spanFactory);
    }
}
