package com.bytedance.trae.conversation.chat.block.renderer;

import io.noties.markwon.AbstractMarkwonPlugin;
import io.noties.markwon.MarkwonConfiguration;
import io.noties.markwon.MarkwonSpansFactory;
import io.noties.markwon.MarkwonVisitor;
import io.noties.markwon.RenderProps;
import io.noties.markwon.SpanFactory;
import io.noties.markwon.SpannableBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.node.Code;

/* compiled from: MarkdownHelper.kt */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$createMarkdownContent$inlineCodePlugin$1", "Lio/noties/markwon/AbstractMarkwonPlugin;", "configureSpansFactory", "", "builder", "Lio/noties/markwon/MarkwonSpansFactory$Builder;", "configureVisitor", "Lio/noties/markwon/MarkwonVisitor$Builder;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class MarkdownHelper$createMarkdownContent$inlineCodePlugin$1 extends AbstractMarkwonPlugin {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Object configureSpansFactory$lambda$0(MarkwonConfiguration markwonConfiguration, RenderProps renderProps) {
        Intrinsics.checkNotNullParameter(markwonConfiguration, "<unused var>");
        Intrinsics.checkNotNullParameter(renderProps, "<unused var>");
        return new InlineCodeSpan();
    }

    public void configureSpansFactory(MarkwonSpansFactory.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        builder.setFactory(Code.class, new SpanFactory() { // from class: com.bytedance.trae.conversation.chat.block.renderer.MarkdownHelper$createMarkdownContent$inlineCodePlugin$1$$ExternalSyntheticLambda0
            public final Object getSpans(MarkwonConfiguration markwonConfiguration, RenderProps renderProps) {
                Object configureSpansFactory$lambda$0;
                configureSpansFactory$lambda$0 = MarkdownHelper$createMarkdownContent$inlineCodePlugin$1.configureSpansFactory$lambda$0(markwonConfiguration, renderProps);
                return configureSpansFactory$lambda$0;
            }
        });
    }

    public void configureVisitor(MarkwonVisitor.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        builder.on(Code.class, new MarkwonVisitor.NodeVisitor() { // from class: com.bytedance.trae.conversation.chat.block.renderer.MarkdownHelper$createMarkdownContent$inlineCodePlugin$1$configureVisitor$1
            public final void visit(MarkwonVisitor markwonVisitor, Code code) {
                Intrinsics.checkNotNullParameter(markwonVisitor, "visitor");
                Intrinsics.checkNotNullParameter(code, "code");
                int length = markwonVisitor.length();
                markwonVisitor.builder().append((char) 160).append(code.getLiteral()).append((char) 160);
                SpannableBuilder.setSpans(markwonVisitor.builder(), markwonVisitor.configuration().spansFactory().require(Code.class).getSpans(markwonVisitor.configuration(), markwonVisitor.renderProps()), length, markwonVisitor.length());
            }
        });
    }
}
