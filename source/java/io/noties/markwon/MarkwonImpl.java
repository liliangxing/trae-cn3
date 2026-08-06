package io.noties.markwon;

import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.widget.TextView;
import io.noties.markwon.Markwon;
import io.noties.markwon.core.CoreProps;
import io.noties.markwon.inject.IInjectParser;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
class MarkwonImpl extends Markwon {
    private final TextView.BufferType bufferType;
    private final MarkwonConfiguration configuration;
    private final boolean fallbackToRawInputWhenEmpty;
    private final IInjectParser injectParser;
    private final Parser parser;
    private final List<MarkwonPlugin> plugins;
    private final Markwon.TextSetter textSetter;
    private final MarkwonVisitorFactory visitorFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MarkwonImpl(TextView.BufferType bufferType, Markwon.TextSetter textSetter, Parser parser, MarkwonVisitorFactory markwonVisitorFactory, MarkwonConfiguration markwonConfiguration, List<MarkwonPlugin> list, boolean z, IInjectParser iInjectParser) {
        this.bufferType = bufferType;
        this.textSetter = textSetter;
        this.parser = parser;
        this.visitorFactory = markwonVisitorFactory;
        this.configuration = markwonConfiguration;
        this.plugins = list;
        this.fallbackToRawInputWhenEmpty = z;
        this.injectParser = iInjectParser;
    }

    @Override // io.noties.markwon.Markwon
    public Node parse(String str) {
        return parse(str, true);
    }

    @Override // io.noties.markwon.Markwon
    public Node parse(String str, boolean z) {
        Iterator<MarkwonPlugin> it = this.plugins.iterator();
        while (it.hasNext()) {
            str = it.next().processMarkdown(str);
        }
        if (this.injectParser != null) {
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                return this.injectParser.parseMarkdown(str, z);
            }
            if (this.injectParser.supportMultiThread()) {
                return this.injectParser.parseMarkdown(str, z);
            }
            return this.parser.parse(str);
        }
        return this.parser.parse(str);
    }

    @Override // io.noties.markwon.Markwon
    public Spanned render(Node node) {
        return render(node, null);
    }

    @Override // io.noties.markwon.Markwon
    public Spanned render(Node node, TextView textView) {
        return render(node, textView, (RenderCallback) null);
    }

    @Override // io.noties.markwon.Markwon
    public Spanned render(Node node, TextView textView, RenderCallback renderCallback) {
        Iterator<MarkwonPlugin> it = this.plugins.iterator();
        while (it.hasNext()) {
            it.next().beforeRender(textView, node);
        }
        MarkwonVisitor create = this.visitorFactory.create();
        if (renderCallback != null) {
            CoreProps.RENDER_NODE_INFO.set(create.renderProps(), new HashMap<>());
        }
        node.accept(create);
        Iterator<MarkwonPlugin> it2 = this.plugins.iterator();
        while (it2.hasNext()) {
            it2.next().afterRender(textView, node, create);
        }
        if (renderCallback != null) {
            renderCallback.handle(CoreProps.RENDER_NODE_INFO.get(create.renderProps()));
        }
        return create.builder().spannableStringBuilder();
    }

    @Override // io.noties.markwon.Markwon
    public Spanned render(Node node, CharSequence charSequence, RenderCallback renderCallback) {
        Iterator<MarkwonPlugin> it = this.plugins.iterator();
        while (it.hasNext()) {
            it.next().beforeRender(charSequence, node);
        }
        MarkwonVisitor create = this.visitorFactory.create();
        if (renderCallback != null) {
            CoreProps.RENDER_NODE_INFO.set(create.renderProps(), new HashMap<>());
        }
        node.accept(create);
        Iterator<MarkwonPlugin> it2 = this.plugins.iterator();
        while (it2.hasNext()) {
            it2.next().afterRender(charSequence, node, create);
        }
        if (renderCallback != null) {
            renderCallback.handle(CoreProps.RENDER_NODE_INFO.get(create.renderProps()));
        }
        return create.builder().spannableStringBuilder();
    }

    @Override // io.noties.markwon.Markwon
    public Spanned toMarkdown(String str) {
        return toMarkdown(str, null);
    }

    @Override // io.noties.markwon.Markwon
    public Spanned toMarkdown(String str, TextView textView) {
        Spanned render = render(parse(str), textView);
        return (TextUtils.isEmpty(render) && this.fallbackToRawInputWhenEmpty && !TextUtils.isEmpty(str)) ? new SpannableStringBuilder(str) : render;
    }

    @Override // io.noties.markwon.Markwon
    public void setMarkdown(TextView textView, String str) {
        setParsedMarkdown(textView, toMarkdown(str, textView), null);
    }

    @Override // io.noties.markwon.Markwon
    public void setParsedMarkdown(TextView textView, Spanned spanned) {
        setParsedMarkdown(textView, spanned, null);
    }

    @Override // io.noties.markwon.Markwon
    public void setParsedMarkdown(final TextView textView, Spanned spanned, final SetMarkdownCallback setMarkdownCallback) {
        final long currentTimeMillis = System.currentTimeMillis();
        Iterator<MarkwonPlugin> it = this.plugins.iterator();
        while (it.hasNext()) {
            it.next().beforeSetText(textView, spanned);
        }
        final long currentTimeMillis2 = System.currentTimeMillis();
        Markwon.TextSetter textSetter = this.textSetter;
        if (textSetter != null) {
            textSetter.setText(textView, spanned, this.bufferType, new Runnable() { // from class: io.noties.markwon.MarkwonImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    long currentTimeMillis3 = System.currentTimeMillis();
                    Iterator it2 = MarkwonImpl.this.plugins.iterator();
                    while (it2.hasNext()) {
                        ((MarkwonPlugin) it2.next()).afterSetText(textView);
                    }
                    long currentTimeMillis4 = System.currentTimeMillis();
                    SetMarkdownCallback setMarkdownCallback2 = setMarkdownCallback;
                    if (setMarkdownCallback2 != null) {
                        long j = currentTimeMillis2;
                        setMarkdownCallback2.handle(j - currentTimeMillis, currentTimeMillis3 - j, currentTimeMillis4 - currentTimeMillis3);
                    }
                }
            });
            return;
        }
        textView.setText(spanned, this.bufferType);
        long currentTimeMillis3 = System.currentTimeMillis();
        Iterator<MarkwonPlugin> it2 = this.plugins.iterator();
        while (it2.hasNext()) {
            it2.next().afterSetText(textView);
        }
        long currentTimeMillis4 = System.currentTimeMillis();
        if (setMarkdownCallback != null) {
            setMarkdownCallback.handle(currentTimeMillis2 - currentTimeMillis, currentTimeMillis3 - currentTimeMillis2, currentTimeMillis4 - currentTimeMillis3);
        }
    }

    @Override // io.noties.markwon.Markwon
    public boolean hasPlugin(Class<? extends MarkwonPlugin> cls) {
        return getPlugin(cls) != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [io.noties.markwon.MarkwonPlugin, java.lang.Object] */
    @Override // io.noties.markwon.Markwon
    public <P extends MarkwonPlugin> P getPlugin(Class<P> cls) {
        P p = null;
        for (MarkwonPlugin markwonPlugin : this.plugins) {
            if (cls.isAssignableFrom(markwonPlugin.getClass())) {
                p = markwonPlugin;
            }
        }
        return p;
    }

    @Override // io.noties.markwon.Markwon
    public <P extends MarkwonPlugin> P requirePlugin(Class<P> cls) {
        P p = (P) getPlugin(cls);
        if (p != null) {
            return p;
        }
        throw new IllegalStateException(String.format(Locale.US, "Requested plugin `%s` is not registered with this Markwon instance", cls.getName()));
    }

    @Override // io.noties.markwon.Markwon
    public List<? extends MarkwonPlugin> getPlugins() {
        return Collections.unmodifiableList(this.plugins);
    }

    @Override // io.noties.markwon.Markwon
    public MarkwonConfiguration configuration() {
        return this.configuration;
    }
}
