package io.noties.markwon.linkify;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import androidx.core.text.util.LinkifyCompat;
import io.noties.markwon.AbstractMarkwonPlugin;
import io.noties.markwon.MarkwonPlugin;
import io.noties.markwon.MarkwonVisitor;
import io.noties.markwon.RenderProps;
import io.noties.markwon.SpanFactory;
import io.noties.markwon.SpannableBuilder;
import io.noties.markwon.core.CorePlugin;
import io.noties.markwon.core.CoreProps;
import org.commonmark.node.Link;
import org.commonmark.node.Node;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LinkifyPlugin extends AbstractMarkwonPlugin {
    private final int mask;
    private final boolean useCompat;

    public static LinkifyPlugin create() {
        return create(false);
    }

    public static LinkifyPlugin create(boolean z) {
        return create(7, z);
    }

    public static LinkifyPlugin create(int i) {
        return new LinkifyPlugin(i, false);
    }

    public static LinkifyPlugin create(int i, boolean z) {
        return new LinkifyPlugin(i, z);
    }

    LinkifyPlugin(int i, boolean z) {
        this.mask = i;
        this.useCompat = z;
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void configure(MarkwonPlugin.Registry registry) {
        registry.require(CorePlugin.class, new MarkwonPlugin.Action<CorePlugin>() { // from class: io.noties.markwon.linkify.LinkifyPlugin.1
            @Override // io.noties.markwon.MarkwonPlugin.Action
            public void apply(CorePlugin corePlugin) {
                CorePlugin.OnTextAddedListener linkifyTextAddedListener;
                if (LinkifyPlugin.this.useCompat) {
                    linkifyTextAddedListener = new LinkifyCompatTextAddedListener(LinkifyPlugin.this.mask);
                } else {
                    linkifyTextAddedListener = new LinkifyTextAddedListener(LinkifyPlugin.this.mask);
                }
                corePlugin.addOnTextAddedListener(linkifyTextAddedListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class LinkifyTextAddedListener implements CorePlugin.OnTextAddedListener {
        private final int mask;

        LinkifyTextAddedListener(int i) {
            this.mask = i;
        }

        @Override // io.noties.markwon.core.CorePlugin.OnTextAddedListener
        public void onTextAdded(MarkwonVisitor markwonVisitor, String str, int i, Node node) {
            SpanFactory spanFactory = markwonVisitor.configuration().spansFactory().get(Link.class);
            if (spanFactory == null) {
                return;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            if (addLinks(spannableStringBuilder, this.mask)) {
                URLSpan[] uRLSpanArr = (URLSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), URLSpan.class);
                if (uRLSpanArr == null || uRLSpanArr.length <= 0) {
                    return;
                }
                RenderProps renderProps = markwonVisitor.renderProps();
                SpannableBuilder builder = markwonVisitor.builder();
                for (URLSpan uRLSpan : uRLSpanArr) {
                    CoreProps.LINK_DESTINATION.set(renderProps, uRLSpan.getURL());
                    SpannableBuilder.setSpans(builder, spanFactory.getSpans(markwonVisitor.configuration(), renderProps), spannableStringBuilder.getSpanStart(uRLSpan) + i, spannableStringBuilder.getSpanEnd(uRLSpan) + i);
                }
            }
        }

        protected boolean addLinks(Spannable spannable, int i) {
            return Linkify.addLinks(spannable, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class LinkifyCompatTextAddedListener extends LinkifyTextAddedListener {
        LinkifyCompatTextAddedListener(int i) {
            super(i);
        }

        @Override // io.noties.markwon.linkify.LinkifyPlugin.LinkifyTextAddedListener
        protected boolean addLinks(Spannable spannable, int i) {
            return LinkifyCompat.addLinks(spannable, i);
        }
    }
}
