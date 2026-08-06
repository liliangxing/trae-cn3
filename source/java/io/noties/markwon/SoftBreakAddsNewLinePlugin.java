package io.noties.markwon;

import io.noties.markwon.MarkwonVisitor;
import org.commonmark.node.SoftLineBreak;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class SoftBreakAddsNewLinePlugin extends AbstractMarkwonPlugin {
    public static SoftBreakAddsNewLinePlugin create() {
        return new SoftBreakAddsNewLinePlugin();
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void configureVisitor(MarkwonVisitor.Builder builder) {
        builder.mo2586on(SoftLineBreak.class, new MarkwonVisitor.NodeVisitor<SoftLineBreak>() { // from class: io.noties.markwon.SoftBreakAddsNewLinePlugin.1
            @Override // io.noties.markwon.MarkwonVisitor.NodeVisitor
            public void visit(MarkwonVisitor markwonVisitor, SoftLineBreak softLineBreak) {
                markwonVisitor.ensureNewLine();
            }
        });
    }
}
