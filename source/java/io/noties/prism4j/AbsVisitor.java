package io.noties.prism4j;

import io.noties.prism4j.Prism4j;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class AbsVisitor implements Prism4j.Visitor {
    protected abstract void visitSyntax(Prism4j.Syntax syntax);

    protected abstract void visitText(Prism4j.Text text);

    @Override // io.noties.prism4j.Prism4j.Visitor
    public void visit(List<? extends Prism4j.Node> list) {
        for (Prism4j.Node node : list) {
            if (node.isSyntax()) {
                visitSyntax((Prism4j.Syntax) node);
            } else {
                visitText((Prism4j.Text) node);
            }
        }
    }
}
