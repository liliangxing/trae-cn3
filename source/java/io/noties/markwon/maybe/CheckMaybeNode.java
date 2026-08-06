package io.noties.markwon.maybe;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.node.Node;
import org.commonmark.parser.PostProcessor;

/* compiled from: CheckMaybeNode.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0014\u0010\u0006\u001a\u00020\u00072\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\bH\u0002J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0002¨\u0006\r"}, d2 = {"Lio/noties/markwon/maybe/CheckMaybeNode;", "Lorg/commonmark/parser/PostProcessor;", "()V", "process", "Lorg/commonmark/node/Node;", "node", "replaceNodeWithChild", "", "Lio/noties/markwon/maybe/MaybeNode;", "visit", "lastChild", "visitChildren", "parent", "markwon-maybe_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes7.dex */
public final class CheckMaybeNode implements PostProcessor {
    @Override // org.commonmark.parser.PostProcessor
    public Node process(Node node) {
        Intrinsics.checkParameterIsNotNull(node, "node");
        Node node2 = node;
        while (node2.lastChild != null) {
            node2 = node2.lastChild;
            Intrinsics.checkExpressionValueIsNotNull(node2, "lastMaybe.lastChild");
        }
        if (!(node2 instanceof MaybeNode) && node2.parent != null) {
            node2 = node2.parent;
            Intrinsics.checkExpressionValueIsNotNull(node2, "lastMaybe.parent");
        }
        visitChildren(node, node2);
        return node;
    }

    private final void visitChildren(Node parent, Node lastChild) {
        Node node = parent.firstChild;
        while (node != null) {
            Node node2 = node.next;
            visit(node, lastChild);
            node = node2;
        }
    }

    private final void visit(Node node, Node lastChild) {
        if ((node instanceof MaybeNode) && node != lastChild) {
            replaceNodeWithChild((MaybeNode) node);
        } else {
            visitChildren(node, lastChild);
        }
    }

    private final void replaceNodeWithChild(MaybeNode<?> node) {
        node.insertAfter(node.firstChild);
        node.unlink();
    }
}
