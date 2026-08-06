package io.noties.markwon;

import android.content.Context;
import android.text.Spanned;
import android.widget.TextView;
import io.noties.markwon.core.CorePlugin;
import io.noties.markwon.inject.IInjectParser;
import java.util.List;
import org.commonmark.node.Node;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public abstract class Markwon {

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public interface Builder {
        Builder bufferType(TextView.BufferType bufferType);

        Markwon build();

        Builder fallbackToRawInputWhenEmpty(boolean z);

        Builder injectParser(IInjectParser iInjectParser);

        Builder textSetter(TextSetter textSetter);

        Builder usePlugin(MarkwonPlugin markwonPlugin);

        Builder usePlugins(Iterable<? extends MarkwonPlugin> iterable);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public interface TextSetter {
        void setText(TextView textView, Spanned spanned, TextView.BufferType bufferType, Runnable runnable);
    }

    public abstract MarkwonConfiguration configuration();

    public abstract <P extends MarkwonPlugin> P getPlugin(Class<P> cls);

    public abstract List<? extends MarkwonPlugin> getPlugins();

    public abstract boolean hasPlugin(Class<? extends MarkwonPlugin> cls);

    public abstract Node parse(String str);

    public abstract Node parse(String str, boolean z);

    public abstract Spanned render(Node node);

    public abstract Spanned render(Node node, TextView textView);

    public abstract Spanned render(Node node, TextView textView, RenderCallback renderCallback);

    public abstract Spanned render(Node node, CharSequence charSequence, RenderCallback renderCallback);

    public abstract <P extends MarkwonPlugin> P requirePlugin(Class<P> cls);

    public abstract void setMarkdown(TextView textView, String str);

    public abstract void setParsedMarkdown(TextView textView, Spanned spanned);

    public abstract void setParsedMarkdown(TextView textView, Spanned spanned, SetMarkdownCallback setMarkdownCallback);

    public abstract Spanned toMarkdown(String str);

    public abstract Spanned toMarkdown(String str, TextView textView);

    public static Markwon create(Context context) {
        return builder(context).usePlugin(CorePlugin.create()).build();
    }

    public static Builder builder(Context context) {
        return new MarkwonBuilderImpl(context).usePlugin(CorePlugin.create());
    }

    public static Builder builderNoCore(Context context) {
        return new MarkwonBuilderImpl(context);
    }
}
