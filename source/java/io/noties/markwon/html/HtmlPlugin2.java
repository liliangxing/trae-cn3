package io.noties.markwon.html;

import android.content.Context;
import io.noties.markwon.MarkwonVisitor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.node.HtmlInline;
import org.commonmark.node.Node;
import org.commonmark.node.SoftLineBreak;

/* compiled from: HtmlPlugin2.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lio/noties/markwon/html/HtmlPlugin2;", "Lio/noties/markwon/html/HtmlPlugin;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "configureVisitor", "", "builder", "Lio/noties/markwon/MarkwonVisitor$Builder;", "markwon-html_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class HtmlPlugin2 extends HtmlPlugin {
    private final Context context;

    public HtmlPlugin2(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.context = context;
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // io.noties.markwon.html.HtmlPlugin, io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void configureVisitor(MarkwonVisitor.Builder builder) {
        Intrinsics.checkParameterIsNotNull(builder, "builder");
        super.configureVisitor(builder);
        builder.mo2586on(SoftLineBreak.class, new MarkwonVisitor.NodeVisitor<SoftLineBreak>() { // from class: io.noties.markwon.html.HtmlPlugin2$configureVisitor$1
            @Override // io.noties.markwon.MarkwonVisitor.NodeVisitor
            public final void visit(MarkwonVisitor markwonVisitor, SoftLineBreak softLineBreak) {
                Intrinsics.checkParameterIsNotNull(markwonVisitor, "visitor");
                Intrinsics.checkParameterIsNotNull(softLineBreak, "n");
                Node previous = softLineBreak.getPrevious();
                Node node = softLineBreak.next;
                boolean z = previous instanceof HtmlInline;
                if (z && (node instanceof HtmlInline)) {
                    return;
                }
                if (z || (node instanceof HtmlInline)) {
                    markwonVisitor.ensureNewLine();
                    markwonVisitor.forceNewLine();
                } else {
                    markwonVisitor.builder().append(' ');
                }
            }
        });
    }
}
