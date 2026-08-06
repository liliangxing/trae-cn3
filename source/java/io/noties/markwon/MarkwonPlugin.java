package io.noties.markwon;

import android.text.Spanned;
import android.widget.TextView;
import io.noties.markwon.MarkwonConfiguration;
import io.noties.markwon.MarkwonSpansFactory;
import io.noties.markwon.MarkwonVisitor;
import io.noties.markwon.core.MarkwonTheme;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public interface MarkwonPlugin {

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public interface Action<P extends MarkwonPlugin> {
        void apply(P p);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public interface Registry {
        <P extends MarkwonPlugin> P require(Class<P> cls);

        <P extends MarkwonPlugin> void require(Class<P> cls, Action<? super P> action);
    }

    void afterRender(TextView textView, Node node, MarkwonVisitor markwonVisitor);

    void afterRender(CharSequence charSequence, Node node, MarkwonVisitor markwonVisitor);

    void afterSetText(TextView textView);

    void beforeRender(TextView textView, Node node);

    void beforeRender(CharSequence charSequence, Node node);

    void beforeSetText(TextView textView, Spanned spanned);

    void configure(Registry registry);

    void configureConfiguration(MarkwonConfiguration.Builder builder);

    void configureParser(Parser.Builder builder);

    void configureSpansFactory(MarkwonSpansFactory.Builder builder);

    void configureTheme(MarkwonTheme.Builder builder);

    void configureVisitor(MarkwonVisitor.Builder builder);

    String processMarkdown(String str);
}
