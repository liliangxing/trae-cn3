package io.noties.markwon;

import android.text.Spanned;
import android.widget.TextView;
import io.noties.markwon.MarkwonConfiguration;
import io.noties.markwon.MarkwonPlugin;
import io.noties.markwon.MarkwonSpansFactory;
import io.noties.markwon.MarkwonVisitor;
import io.noties.markwon.core.MarkwonTheme;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public abstract class AbstractMarkwonPlugin implements MarkwonPlugin {
    @Deprecated
    public void afterRender(Node node, MarkwonVisitor markwonVisitor) {
    }

    @Override // io.noties.markwon.MarkwonPlugin
    public void afterSetText(TextView textView) {
    }

    @Deprecated
    public void beforeRender(Node node) {
    }

    @Override // io.noties.markwon.MarkwonPlugin
    public void beforeSetText(TextView textView, Spanned spanned) {
    }

    @Override // io.noties.markwon.MarkwonPlugin
    public void configure(MarkwonPlugin.Registry registry) {
    }

    @Override // io.noties.markwon.MarkwonPlugin
    public void configureConfiguration(MarkwonConfiguration.Builder builder) {
    }

    @Override // io.noties.markwon.MarkwonPlugin
    public void configureParser(Parser.Builder builder) {
    }

    @Override // io.noties.markwon.MarkwonPlugin
    public void configureSpansFactory(MarkwonSpansFactory.Builder builder) {
    }

    @Override // io.noties.markwon.MarkwonPlugin
    public void configureTheme(MarkwonTheme.Builder builder) {
    }

    @Override // io.noties.markwon.MarkwonPlugin
    public void configureVisitor(MarkwonVisitor.Builder builder) {
    }

    @Override // io.noties.markwon.MarkwonPlugin
    public String processMarkdown(String str) {
        return str;
    }

    @Override // io.noties.markwon.MarkwonPlugin
    @Deprecated
    public void beforeRender(TextView textView, Node node) {
        beforeRender(node);
    }

    @Override // io.noties.markwon.MarkwonPlugin
    public void beforeRender(CharSequence charSequence, Node node) {
        beforeRender(node);
    }

    @Override // io.noties.markwon.MarkwonPlugin
    @Deprecated
    public void afterRender(TextView textView, Node node, MarkwonVisitor markwonVisitor) {
        afterRender(node, markwonVisitor);
    }

    @Override // io.noties.markwon.MarkwonPlugin
    public void afterRender(CharSequence charSequence, Node node, MarkwonVisitor markwonVisitor) {
        afterRender(node, markwonVisitor);
    }
}
