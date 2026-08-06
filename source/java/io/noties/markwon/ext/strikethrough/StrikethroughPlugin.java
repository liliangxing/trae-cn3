package io.noties.markwon.ext.strikethrough;

import android.text.style.StrikethroughSpan;
import io.noties.markwon.AbstractMarkwonPlugin;
import io.noties.markwon.MarkwonConfiguration;
import io.noties.markwon.MarkwonSpansFactory;
import io.noties.markwon.MarkwonVisitor;
import io.noties.markwon.RenderProps;
import io.noties.markwon.SpanFactory;
import java.util.Collections;
import org.commonmark.ext.gfm.strikethrough.Strikethrough;
import org.commonmark.ext.gfm.strikethrough.StrikethroughExtension;
import org.commonmark.parser.Parser;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class StrikethroughPlugin extends AbstractMarkwonPlugin {
    public static StrikethroughPlugin create() {
        return new StrikethroughPlugin();
    }

    public void configureParser(Parser.Builder builder) {
        builder.extensions(Collections.singleton(StrikethroughExtension.create()));
    }

    public void configureSpansFactory(MarkwonSpansFactory.Builder builder) {
        builder.setFactory(Strikethrough.class, new SpanFactory() { // from class: io.noties.markwon.ext.strikethrough.StrikethroughPlugin.1
            public Object getSpans(MarkwonConfiguration markwonConfiguration, RenderProps renderProps) {
                return new StrikethroughSpan();
            }
        });
    }

    public void configureVisitor(MarkwonVisitor.Builder builder) {
        builder.on(Strikethrough.class, new MarkwonVisitor.NodeVisitor<Strikethrough>() { // from class: io.noties.markwon.ext.strikethrough.StrikethroughPlugin.2
            public void visit(MarkwonVisitor markwonVisitor, Strikethrough strikethrough) {
                int length = markwonVisitor.length();
                markwonVisitor.visitChildren(strikethrough);
                markwonVisitor.setSpansForNodeOptional(strikethrough, length);
            }
        });
    }
}
