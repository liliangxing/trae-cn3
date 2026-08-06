package io.noties.markwon.maybe;

import io.noties.markwon.MarkwonVisitor;
import org.commonmark.node.Node;
import org.commonmark.node.Visitor;

/* loaded from: classes7.dex */
public class MaybeNode<Target> extends Node {
    public final Target target;
    public final Class<? super Target> targetType;

    public MaybeNode(Target target) {
        this(target, target.getClass());
    }

    public MaybeNode(Target target, Class<? super Target> cls) {
        this.target = target;
        this.targetType = cls;
    }

    @Override // org.commonmark.node.Node
    public void accept(Visitor visitor) {
        MarkwonVisitor markwonVisitor;
        MarkwonVisitor.NodeVisitor<Node> nodeVisitor;
        if ((visitor instanceof MarkwonVisitor) && (nodeVisitor = (markwonVisitor = (MarkwonVisitor) visitor).getNodeVisitor(this)) != null) {
            nodeVisitor.visit(markwonVisitor, this);
            return;
        }
        Node firstChild = getFirstChild();
        while (firstChild != null) {
            Node next = firstChild.getNext();
            firstChild.accept(visitor);
            firstChild = next;
        }
    }
}
