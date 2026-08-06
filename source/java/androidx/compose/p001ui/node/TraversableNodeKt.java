package androidx.compose.p001ui.node;

import androidx.compose.p001ui.node.TraversableNode;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Actual_jvmKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TraversableNode.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u001a\u001b\u0010\u0000\u001a\u0004\u0018\u0001H\u0005\"\b\b\u0000\u0010\u0005*\u00020\u0001*\u0002H\u0005¢\u0006\u0002\u0010\u0006\u001a(\u0010\u0007\u001a\u00020\b*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000b0\n\u001a-\u0010\u0007\u001a\u00020\b\"\b\b\u0000\u0010\u0005*\u00020\u0001*\u0002H\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\f\u001a(\u0010\r\u001a\u00020\b*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000b0\n\u001a-\u0010\r\u001a\u00020\b\"\b\b\u0000\u0010\u0005*\u00020\u0001*\u0002H\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\f\u001a(\u0010\u000e\u001a\u00020\b*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000f0\n\u001a-\u0010\u000e\u001a\u00020\b\"\b\b\u0000\u0010\u0005*\u00020\u0001*\u0002H\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u00020\u000f0\n¢\u0006\u0002\u0010\f¨\u0006\u0010"}, d2 = {"findNearestAncestor", "Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/node/DelegatableNode;", "key", "", ExifInterface.GPS_DIRECTION_TRUE, "(Landroidx/compose/ui/node/TraversableNode;)Landroidx/compose/ui/node/TraversableNode;", "traverseAncestors", "", "block", "Lkotlin/Function1;", "", "(Landroidx/compose/ui/node/TraversableNode;Lkotlin/jvm/functions/Function1;)V", "traverseChildren", "traverseDescendants", "Landroidx/compose/ui/node/TraversableNode$Companion$TraverseDescendantsAction;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class TraversableNodeKt {
    public static final <T extends TraversableNode> T findNearestAncestor(T t) {
        NodeChain nodes;
        T t2 = t;
        int m1562constructorimpl = NodeKind.m1562constructorimpl(262144);
        if (!t2.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node parent$ui_release = t2.getNode().getParent$ui_release();
        LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(t2);
        while (requireLayoutNode != null) {
            if ((requireLayoutNode.getNodes().getHead().getAggregateChildKindSet$ui_release() & m1562constructorimpl) != 0) {
                while (parent$ui_release != null) {
                    if ((parent$ui_release.getKindSet$ui_release() & m1562constructorimpl) != 0) {
                        Modifier.Node node = parent$ui_release;
                        MutableVector mutableVector = null;
                        while (node != null) {
                            if (node instanceof TraversableNode) {
                                T t3 = (T) node;
                                if (Intrinsics.areEqual(t.getTraverseKey(), t3.getTraverseKey()) && Actual_jvmKt.areObjectsOfSameType(t, t3)) {
                                    return t3;
                                }
                            } else if (((node.getKindSet$ui_release() & m1562constructorimpl) != 0) && (node instanceof DelegatingNode)) {
                                int i = 0;
                                for (Modifier.Node delegate = ((DelegatingNode) node).getDelegate(); delegate != null; delegate = delegate.getChild$ui_release()) {
                                    if ((delegate.getKindSet$ui_release() & m1562constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            node = delegate;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (node != null) {
                                                if (mutableVector != null) {
                                                    mutableVector.add(node);
                                                }
                                                node = null;
                                            }
                                            if (mutableVector != null) {
                                                mutableVector.add(delegate);
                                            }
                                        }
                                    }
                                }
                                if (i == 1) {
                                }
                            }
                            node = DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    parent$ui_release = parent$ui_release.getParent$ui_release();
                }
            }
            requireLayoutNode = requireLayoutNode.getParent$ui_release();
            parent$ui_release = (requireLayoutNode == null || (nodes = requireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
        return null;
    }

    public static final <T extends TraversableNode> void traverseAncestors(T t, Function1<? super T, Boolean> function1) {
        NodeChain nodes;
        T t2 = t;
        int m1562constructorimpl = NodeKind.m1562constructorimpl(262144);
        if (!t2.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node parent$ui_release = t2.getNode().getParent$ui_release();
        LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(t2);
        while (requireLayoutNode != null) {
            if ((requireLayoutNode.getNodes().getHead().getAggregateChildKindSet$ui_release() & m1562constructorimpl) != 0) {
                while (parent$ui_release != null) {
                    if ((parent$ui_release.getKindSet$ui_release() & m1562constructorimpl) != 0) {
                        Modifier.Node node = parent$ui_release;
                        MutableVector mutableVector = null;
                        while (node != null) {
                            boolean z = true;
                            if (node instanceof TraversableNode) {
                                TraversableNode traversableNode = (TraversableNode) node;
                                if (Intrinsics.areEqual(t.getTraverseKey(), traversableNode.getTraverseKey()) && Actual_jvmKt.areObjectsOfSameType(t, traversableNode)) {
                                    z = ((Boolean) function1.invoke(traversableNode)).booleanValue();
                                }
                                if (!z) {
                                    return;
                                }
                            } else if (((node.getKindSet$ui_release() & m1562constructorimpl) != 0) && (node instanceof DelegatingNode)) {
                                int i = 0;
                                for (Modifier.Node delegate = ((DelegatingNode) node).getDelegate(); delegate != null; delegate = delegate.getChild$ui_release()) {
                                    if ((delegate.getKindSet$ui_release() & m1562constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            node = delegate;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (node != null) {
                                                if (mutableVector != null) {
                                                    mutableVector.add(node);
                                                }
                                                node = null;
                                            }
                                            if (mutableVector != null) {
                                                mutableVector.add(delegate);
                                            }
                                        }
                                    }
                                }
                                if (i == 1) {
                                }
                            }
                            node = DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    parent$ui_release = parent$ui_release.getParent$ui_release();
                }
            }
            requireLayoutNode = requireLayoutNode.getParent$ui_release();
            parent$ui_release = (requireLayoutNode == null || (nodes = requireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:76:0x0038, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T extends TraversableNode> void traverseChildren(T t, Function1<? super T, Boolean> function1) {
        T t2 = t;
        int m1562constructorimpl = NodeKind.m1562constructorimpl(262144);
        if (!t2.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui_release = t2.getNode().getChild$ui_release();
        if (child$ui_release == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, t2.getNode(), false);
        } else {
            mutableVector.add(child$ui_release);
        }
        while (true) {
            if (!(mutableVector.getSize() != 0)) {
                return;
            }
            Modifier.Node node = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
            if ((node.getAggregateChildKindSet$ui_release() & m1562constructorimpl) == 0) {
                DelegatableNodeKt.addLayoutNodeChildren(mutableVector, node, false);
            } else {
                while (true) {
                    if (node == null) {
                        break;
                    }
                    if ((node.getKindSet$ui_release() & m1562constructorimpl) != 0) {
                        MutableVector mutableVector2 = null;
                        while (node != null) {
                            if (node instanceof TraversableNode) {
                                TraversableNode traversableNode = (TraversableNode) node;
                                if (!((Intrinsics.areEqual(t.getTraverseKey(), traversableNode.getTraverseKey()) && Actual_jvmKt.areObjectsOfSameType(t, traversableNode)) ? ((Boolean) function1.invoke(traversableNode)).booleanValue() : true)) {
                                    return;
                                }
                            } else if (((node.getKindSet$ui_release() & m1562constructorimpl) != 0) && (node instanceof DelegatingNode)) {
                                int i = 0;
                                for (Modifier.Node delegate = ((DelegatingNode) node).getDelegate(); delegate != null; delegate = delegate.getChild$ui_release()) {
                                    if ((delegate.getKindSet$ui_release() & m1562constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            node = delegate;
                                        } else {
                                            if (mutableVector2 == null) {
                                                mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (node != null) {
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(node);
                                                }
                                                node = null;
                                            }
                                            if (mutableVector2 != null) {
                                                mutableVector2.add(delegate);
                                            }
                                        }
                                    }
                                }
                                if (i == 1) {
                                }
                            }
                            node = DelegatableNodeKt.pop(mutableVector2);
                        }
                    } else {
                        node = node.getChild$ui_release();
                    }
                }
            }
        }
    }

    public static final <T extends TraversableNode> void traverseDescendants(T t, Function1<? super T, ? extends TraversableNode.Companion.TraverseDescendantsAction> function1) {
        boolean z;
        TraversableNode.Companion.TraverseDescendantsAction traverseDescendantsAction;
        T t2 = t;
        int m1562constructorimpl = NodeKind.m1562constructorimpl(262144);
        if (!t2.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui_release = t2.getNode().getChild$ui_release();
        if (child$ui_release == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, t2.getNode(), false);
        } else {
            mutableVector.add(child$ui_release);
        }
        while (true) {
            if (!(mutableVector.getSize() != 0)) {
                return;
            }
            Modifier.Node node = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
            if ((node.getAggregateChildKindSet$ui_release() & m1562constructorimpl) != 0) {
                for (Modifier.Node node2 = node; node2 != null; node2 = node2.getChild$ui_release()) {
                    if ((node2.getKindSet$ui_release() & m1562constructorimpl) != 0) {
                        Modifier.Node node3 = node2;
                        MutableVector mutableVector2 = null;
                        while (true) {
                            if (node3 == null) {
                                z = true;
                                break;
                            }
                            if (node3 instanceof TraversableNode) {
                                TraversableNode traversableNode = (TraversableNode) node3;
                                if (Intrinsics.areEqual(t.getTraverseKey(), traversableNode.getTraverseKey()) && Actual_jvmKt.areObjectsOfSameType(t, traversableNode)) {
                                    traverseDescendantsAction = (TraversableNode.Companion.TraverseDescendantsAction) function1.invoke(traversableNode);
                                } else {
                                    traverseDescendantsAction = TraversableNode.Companion.TraverseDescendantsAction.ContinueTraversal;
                                }
                                if (traverseDescendantsAction == TraversableNode.Companion.TraverseDescendantsAction.CancelTraversal) {
                                    return;
                                }
                                if (!(traverseDescendantsAction != TraversableNode.Companion.TraverseDescendantsAction.SkipSubtreeAndContinueTraversal)) {
                                    z = false;
                                    break;
                                }
                            } else if (((node3.getKindSet$ui_release() & m1562constructorimpl) != 0) && (node3 instanceof DelegatingNode)) {
                                int i = 0;
                                for (Modifier.Node delegate = ((DelegatingNode) node3).getDelegate(); delegate != null; delegate = delegate.getChild$ui_release()) {
                                    if ((delegate.getKindSet$ui_release() & m1562constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            node3 = delegate;
                                        } else {
                                            if (mutableVector2 == null) {
                                                mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (node3 != null) {
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(node3);
                                                }
                                                node3 = null;
                                            }
                                            if (mutableVector2 != null) {
                                                mutableVector2.add(delegate);
                                            }
                                        }
                                    }
                                }
                                if (i == 1) {
                                }
                            }
                            node3 = DelegatableNodeKt.pop(mutableVector2);
                        }
                        if (z) {
                        }
                    }
                }
            }
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, node, false);
        }
    }

    public static final TraversableNode findNearestAncestor(DelegatableNode delegatableNode, Object obj) {
        NodeChain nodes;
        int m1562constructorimpl = NodeKind.m1562constructorimpl(262144);
        if (!delegatableNode.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node parent$ui_release = delegatableNode.getNode().getParent$ui_release();
        LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(delegatableNode);
        while (requireLayoutNode != null) {
            if ((requireLayoutNode.getNodes().getHead().getAggregateChildKindSet$ui_release() & m1562constructorimpl) != 0) {
                while (parent$ui_release != null) {
                    if ((parent$ui_release.getKindSet$ui_release() & m1562constructorimpl) != 0) {
                        Modifier.Node node = parent$ui_release;
                        MutableVector mutableVector = null;
                        while (node != null) {
                            if (node instanceof TraversableNode) {
                                TraversableNode traversableNode = (TraversableNode) node;
                                if (Intrinsics.areEqual(obj, traversableNode.getTraverseKey())) {
                                    return traversableNode;
                                }
                            } else if (((node.getKindSet$ui_release() & m1562constructorimpl) != 0) && (node instanceof DelegatingNode)) {
                                int i = 0;
                                for (Modifier.Node delegate = ((DelegatingNode) node).getDelegate(); delegate != null; delegate = delegate.getChild$ui_release()) {
                                    if ((delegate.getKindSet$ui_release() & m1562constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            node = delegate;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (node != null) {
                                                if (mutableVector != null) {
                                                    mutableVector.add(node);
                                                }
                                                node = null;
                                            }
                                            if (mutableVector != null) {
                                                mutableVector.add(delegate);
                                            }
                                        }
                                    }
                                }
                                if (i == 1) {
                                }
                            }
                            node = DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    parent$ui_release = parent$ui_release.getParent$ui_release();
                }
            }
            requireLayoutNode = requireLayoutNode.getParent$ui_release();
            parent$ui_release = (requireLayoutNode == null || (nodes = requireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
        return null;
    }

    public static final void traverseAncestors(DelegatableNode delegatableNode, Object obj, Function1<? super TraversableNode, Boolean> function1) {
        NodeChain nodes;
        int m1562constructorimpl = NodeKind.m1562constructorimpl(262144);
        if (!delegatableNode.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node parent$ui_release = delegatableNode.getNode().getParent$ui_release();
        LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(delegatableNode);
        while (requireLayoutNode != null) {
            if ((requireLayoutNode.getNodes().getHead().getAggregateChildKindSet$ui_release() & m1562constructorimpl) != 0) {
                while (parent$ui_release != null) {
                    if ((parent$ui_release.getKindSet$ui_release() & m1562constructorimpl) != 0) {
                        Modifier.Node node = parent$ui_release;
                        MutableVector mutableVector = null;
                        while (node != null) {
                            if (node instanceof TraversableNode) {
                                TraversableNode traversableNode = (TraversableNode) node;
                                if (!(Intrinsics.areEqual(obj, traversableNode.getTraverseKey()) ? ((Boolean) function1.invoke(traversableNode)).booleanValue() : true)) {
                                    return;
                                }
                            } else if (((node.getKindSet$ui_release() & m1562constructorimpl) != 0) && (node instanceof DelegatingNode)) {
                                int i = 0;
                                for (Modifier.Node delegate = ((DelegatingNode) node).getDelegate(); delegate != null; delegate = delegate.getChild$ui_release()) {
                                    if ((delegate.getKindSet$ui_release() & m1562constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            node = delegate;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (node != null) {
                                                if (mutableVector != null) {
                                                    mutableVector.add(node);
                                                }
                                                node = null;
                                            }
                                            if (mutableVector != null) {
                                                mutableVector.add(delegate);
                                            }
                                        }
                                    }
                                }
                                if (i == 1) {
                                }
                            }
                            node = DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    parent$ui_release = parent$ui_release.getParent$ui_release();
                }
            }
            requireLayoutNode = requireLayoutNode.getParent$ui_release();
            parent$ui_release = (requireLayoutNode == null || (nodes = requireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x0035, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void traverseChildren(DelegatableNode delegatableNode, Object obj, Function1<? super TraversableNode, Boolean> function1) {
        int m1562constructorimpl = NodeKind.m1562constructorimpl(262144);
        if (!delegatableNode.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui_release = delegatableNode.getNode().getChild$ui_release();
        if (child$ui_release == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, delegatableNode.getNode(), false);
        } else {
            mutableVector.add(child$ui_release);
        }
        while (true) {
            if (!(mutableVector.getSize() != 0)) {
                return;
            }
            Modifier.Node node = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
            if ((node.getAggregateChildKindSet$ui_release() & m1562constructorimpl) == 0) {
                DelegatableNodeKt.addLayoutNodeChildren(mutableVector, node, false);
            } else {
                while (true) {
                    if (node == null) {
                        break;
                    }
                    if ((node.getKindSet$ui_release() & m1562constructorimpl) != 0) {
                        MutableVector mutableVector2 = null;
                        while (node != null) {
                            if (node instanceof TraversableNode) {
                                TraversableNode traversableNode = (TraversableNode) node;
                                if (!(Intrinsics.areEqual(obj, traversableNode.getTraverseKey()) ? ((Boolean) function1.invoke(traversableNode)).booleanValue() : true)) {
                                    return;
                                }
                            } else if (((node.getKindSet$ui_release() & m1562constructorimpl) != 0) && (node instanceof DelegatingNode)) {
                                int i = 0;
                                for (Modifier.Node delegate = ((DelegatingNode) node).getDelegate(); delegate != null; delegate = delegate.getChild$ui_release()) {
                                    if ((delegate.getKindSet$ui_release() & m1562constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            node = delegate;
                                        } else {
                                            if (mutableVector2 == null) {
                                                mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (node != null) {
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(node);
                                                }
                                                node = null;
                                            }
                                            if (mutableVector2 != null) {
                                                mutableVector2.add(delegate);
                                            }
                                        }
                                    }
                                }
                                if (i == 1) {
                                }
                            }
                            node = DelegatableNodeKt.pop(mutableVector2);
                        }
                    } else {
                        node = node.getChild$ui_release();
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x00db, code lost:
    
        if (r6 == false) goto L76;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void traverseDescendants(DelegatableNode delegatableNode, Object obj, Function1<? super TraversableNode, ? extends TraversableNode.Companion.TraverseDescendantsAction> function1) {
        boolean z;
        TraversableNode.Companion.TraverseDescendantsAction traverseDescendantsAction;
        int m1562constructorimpl = NodeKind.m1562constructorimpl(262144);
        if (!delegatableNode.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui_release = delegatableNode.getNode().getChild$ui_release();
        if (child$ui_release == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, delegatableNode.getNode(), false);
        } else {
            mutableVector.add(child$ui_release);
        }
        while (true) {
            if (!(mutableVector.getSize() != 0)) {
                return;
            }
            Modifier.Node node = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
            if ((node.getAggregateChildKindSet$ui_release() & m1562constructorimpl) != 0) {
                for (Modifier.Node node2 = node; node2 != null; node2 = node2.getChild$ui_release()) {
                    if ((node2.getKindSet$ui_release() & m1562constructorimpl) != 0) {
                        Modifier.Node node3 = node2;
                        MutableVector mutableVector2 = null;
                        while (true) {
                            if (node3 == null) {
                                z = true;
                                break;
                            }
                            if (node3 instanceof TraversableNode) {
                                TraversableNode traversableNode = (TraversableNode) node3;
                                if (Intrinsics.areEqual(obj, traversableNode.getTraverseKey())) {
                                    traverseDescendantsAction = (TraversableNode.Companion.TraverseDescendantsAction) function1.invoke(traversableNode);
                                } else {
                                    traverseDescendantsAction = TraversableNode.Companion.TraverseDescendantsAction.ContinueTraversal;
                                }
                                if (traverseDescendantsAction == TraversableNode.Companion.TraverseDescendantsAction.CancelTraversal) {
                                    return;
                                }
                                if (!(traverseDescendantsAction != TraversableNode.Companion.TraverseDescendantsAction.SkipSubtreeAndContinueTraversal)) {
                                    z = false;
                                    break;
                                }
                            } else if (((node3.getKindSet$ui_release() & m1562constructorimpl) != 0) && (node3 instanceof DelegatingNode)) {
                                int i = 0;
                                for (Modifier.Node delegate = ((DelegatingNode) node3).getDelegate(); delegate != null; delegate = delegate.getChild$ui_release()) {
                                    if ((delegate.getKindSet$ui_release() & m1562constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            node3 = delegate;
                                        } else {
                                            if (mutableVector2 == null) {
                                                mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (node3 != null) {
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(node3);
                                                }
                                                node3 = null;
                                            }
                                            if (mutableVector2 != null) {
                                                mutableVector2.add(delegate);
                                            }
                                        }
                                    }
                                }
                                if (i == 1) {
                                }
                            }
                            node3 = DelegatableNodeKt.pop(mutableVector2);
                        }
                    }
                }
            }
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, node, false);
        }
    }
}
