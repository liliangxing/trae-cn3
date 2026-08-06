package androidx.compose.p001ui.semantics;

import androidx.compose.p001ui.node.DelegatableNodeKt;
import androidx.compose.p001ui.node.DelegatingNode;
import androidx.compose.p001ui.node.LayoutNode;
import androidx.compose.p001ui.node.NodeChain;
import androidx.compose.p001ui.node.NodeKind;
import androidx.compose.p001ui.node.SemanticsModifierNode;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SemanticsNode.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0000\u001a#\u0010\b\u001a\u0004\u0018\u00010\u0003*\u00020\u00032\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\nH\u0080\b\u001a\f\u0010\u000f\u001a\u00020\u0010*\u00020\u0001H\u0002\u001a\f\u0010\u0011\u001a\u00020\u0010*\u00020\u0001H\u0002\"\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f*\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"SemanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "mergingEnabled", "", "outerSemanticsNode", "Landroidx/compose/ui/node/SemanticsModifierNode;", "findClosestParentNode", "selector", "Lkotlin/Function1;", "role", "Landroidx/compose/ui/semantics/Role;", "getRole", "(Landroidx/compose/ui/semantics/SemanticsNode;)Landroidx/compose/ui/semantics/Role;", "contentDescriptionFakeNodeId", "", "roleFakeNodeId", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class SemanticsNodeKt {
    public static final SemanticsNode SemanticsNode(LayoutNode layoutNode, boolean z) {
        NodeChain nodes = layoutNode.getNodes();
        int m1562constructorimpl = NodeKind.m1562constructorimpl(8);
        Modifier.Node node = null;
        if ((nodes.getAggregateChildKindSet() & m1562constructorimpl) != 0) {
            Modifier.Node head = nodes.getHead();
            loop0: while (true) {
                if (head == null) {
                    break;
                }
                if ((head.getKindSet$ui_release() & m1562constructorimpl) != 0) {
                    Modifier.Node node2 = head;
                    MutableVector mutableVector = null;
                    while (node2 != null) {
                        if (node2 instanceof SemanticsModifierNode) {
                            node = node2;
                            break loop0;
                        }
                        if (((node2.getKindSet$ui_release() & m1562constructorimpl) != 0) && (node2 instanceof DelegatingNode)) {
                            int i = 0;
                            for (Modifier.Node delegate = ((DelegatingNode) node2).getDelegate(); delegate != null; delegate = delegate.getChild$ui_release()) {
                                if ((delegate.getKindSet$ui_release() & m1562constructorimpl) != 0) {
                                    i++;
                                    if (i == 1) {
                                        node2 = delegate;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (node2 != null) {
                                            if (mutableVector != null) {
                                                mutableVector.add(node2);
                                            }
                                            node2 = null;
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
                        node2 = DelegatableNodeKt.pop(mutableVector);
                    }
                }
                if ((head.getAggregateChildKindSet$ui_release() & m1562constructorimpl) == 0) {
                    break;
                }
                head = head.getChild$ui_release();
            }
        }
        Intrinsics.checkNotNull(node);
        Modifier.Node node3 = ((SemanticsModifierNode) node).getNode();
        SemanticsConfiguration semanticsConfiguration = layoutNode.getSemanticsConfiguration();
        if (semanticsConfiguration == null) {
            semanticsConfiguration = new SemanticsConfiguration();
        }
        return new SemanticsNode(node3, z, layoutNode, semanticsConfiguration);
    }

    public static /* synthetic */ SemanticsNode SemanticsNode$default(SemanticsModifierNode semanticsModifierNode, boolean z, LayoutNode layoutNode, int i, Object obj) {
        if ((i & 4) != 0) {
            layoutNode = DelegatableNodeKt.requireLayoutNode(semanticsModifierNode);
        }
        return SemanticsNode(semanticsModifierNode, z, layoutNode);
    }

    public static final SemanticsNode SemanticsNode(SemanticsModifierNode semanticsModifierNode, boolean z, LayoutNode layoutNode) {
        Modifier.Node node = semanticsModifierNode.getNode();
        SemanticsConfiguration semanticsConfiguration = layoutNode.getSemanticsConfiguration();
        if (semanticsConfiguration == null) {
            semanticsConfiguration = new SemanticsConfiguration();
        }
        return new SemanticsNode(node, z, layoutNode, semanticsConfiguration);
    }

    public static final LayoutNode findClosestParentNode(LayoutNode layoutNode, Function1<? super LayoutNode, Boolean> function1) {
        for (LayoutNode parent$ui_release = layoutNode.getParent$ui_release(); parent$ui_release != null; parent$ui_release = parent$ui_release.getParent$ui_release()) {
            if (((Boolean) function1.invoke(parent$ui_release)).booleanValue()) {
                return parent$ui_release;
            }
        }
        return null;
    }

    public static final Role getRole(SemanticsNode semanticsNode) {
        return (Role) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getRole());
    }

    public static final int contentDescriptionFakeNodeId(SemanticsNode semanticsNode) {
        return semanticsNode.getId() + 2000000000;
    }

    public static final int roleFakeNodeId(SemanticsNode semanticsNode) {
        return semanticsNode.getId() + 1000000000;
    }
}
