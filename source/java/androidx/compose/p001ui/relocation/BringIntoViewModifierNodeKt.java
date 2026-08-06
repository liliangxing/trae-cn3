package androidx.compose.p001ui.relocation;

import androidx.compose.p001ui.node.DelegatableNode;
import androidx.compose.p001ui.node.DelegatableNodeKt;
import androidx.compose.p001ui.node.DelegatingNode;
import androidx.compose.p001ui.node.LayoutNode;
import androidx.compose.p001ui.node.NodeChain;
import androidx.compose.p001ui.node.NodeKind;
import androidx.compose.p001ui.unit.IntSizeKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;

/* compiled from: BringIntoViewModifierNode.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0012\b\u0002\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004H\u0086@¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"bringIntoView", "", "Landroidx/compose/ui/node/DelegatableNode;", "bounds", "Lkotlin/Function0;", "Landroidx/compose/ui/geometry/Rect;", "(Landroidx/compose/ui/node/DelegatableNode;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class BringIntoViewModifierNodeKt {
    public static /* synthetic */ Object bringIntoView$default(DelegatableNode delegatableNode, Function0 function0, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        return bringIntoView(delegatableNode, function0, continuation);
    }

    public static final Object bringIntoView(DelegatableNode delegatableNode, final Function0<Rect> function0, Continuation<? super Unit> continuation) {
        Modifier.Node node;
        final LayoutCoordinates requireLayoutCoordinates;
        Object bringIntoView;
        NodeChain nodes;
        if (!delegatableNode.getNode().isAttached()) {
            return Unit.INSTANCE;
        }
        int m1562constructorimpl = NodeKind.m1562constructorimpl(524288);
        if (!delegatableNode.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node parent$ui_release = delegatableNode.getNode().getParent$ui_release();
        LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(delegatableNode);
        loop0: while (true) {
            node = null;
            if (requireLayoutNode == null) {
                break;
            }
            if ((requireLayoutNode.getNodes().getHead().getAggregateChildKindSet$ui_release() & m1562constructorimpl) != 0) {
                while (parent$ui_release != null) {
                    if ((parent$ui_release.getKindSet$ui_release() & m1562constructorimpl) != 0) {
                        Modifier.Node node2 = parent$ui_release;
                        MutableVector mutableVector = null;
                        while (node2 != null) {
                            if (node2 instanceof BringIntoViewModifierNode) {
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
                                                    Boxing.boxBoolean(mutableVector.add(node2));
                                                }
                                                node2 = null;
                                            }
                                            if (mutableVector != null) {
                                                Boxing.boxBoolean(mutableVector.add(delegate));
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
                    parent$ui_release = parent$ui_release.getParent$ui_release();
                }
            }
            requireLayoutNode = requireLayoutNode.getParent$ui_release();
            parent$ui_release = (requireLayoutNode == null || (nodes = requireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
        BringIntoViewModifierNode bringIntoViewModifierNode = (BringIntoViewModifierNode) node;
        return (bringIntoViewModifierNode != null && (bringIntoView = bringIntoViewModifierNode.bringIntoView((requireLayoutCoordinates = DelegatableNodeKt.requireLayoutCoordinates(delegatableNode)), new Function0<Rect>() { // from class: androidx.compose.ui.relocation.BringIntoViewModifierNodeKt$bringIntoView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Rect m1842invoke() {
                Rect rect;
                Function0<Rect> function02 = function0;
                if (function02 != null && (rect = (Rect) function02.invoke()) != null) {
                    return rect;
                }
                LayoutCoordinates layoutCoordinates = requireLayoutCoordinates;
                if (!layoutCoordinates.isAttached()) {
                    layoutCoordinates = null;
                }
                if (layoutCoordinates != null) {
                    return SizeKt.toRect-uvyYCjk(IntSizeKt.m2863toSizeozmzZPI(layoutCoordinates.getSize-YbymL2g()));
                }
                return null;
            }
        }, continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? bringIntoView : Unit.INSTANCE;
    }
}
