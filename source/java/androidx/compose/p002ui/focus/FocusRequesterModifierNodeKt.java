package androidx.compose.p002ui.focus;

import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.internal.InlineClassHelperKt;
import androidx.compose.p002ui.layout.PinnableContainer;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: FocusRequesterModifierNode.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0002\u001a\u000e\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\u0002H\u0000¨\u0006\t"}, d2 = {"requestFocus", "", "Landroidx/compose/ui/focus/FocusRequesterModifierNode;", "captureFocus", "freeFocus", "saveFocusedChild", "restoreFocusedChild", "pinFocusedChild", "Landroidx/compose/ui/layout/PinnableContainer$PinnedHandle;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class FocusRequesterModifierNodeKt {
    /* JADX WARN: Code restructure failed: missing block: B:125:0x00b5, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean requestFocus(FocusRequesterModifierNode focusRequesterModifierNode) {
        FocusRequesterModifierNode focusRequesterModifierNode2 = focusRequesterModifierNode;
        int i = NodeKind.constructor-impl(Fields.RotationZ);
        Modifier.Node node = focusRequesterModifierNode2.getNode();
        MutableVector mutableVector = null;
        while (node != null) {
            if (node instanceof FocusTargetNode) {
                FocusTargetNode focusTargetNode = (FocusTargetNode) node;
                return focusTargetNode.fetchFocusProperties$ui_release().getCanFocus() ? FocusTargetModifierNode.m4499requestFocus3ESFkO8$default(focusTargetNode, 0, 1, null) : TwoDimensionalFocusSearchKt.m4539findChildCorrespondingToFocusEnterOMvw8(focusTargetNode, FocusDirection.INSTANCE.m4465getEnterdhqQ8s(), new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusRequesterModifierNodeKt$requestFocus$1$1
                    public final Boolean invoke(FocusTargetNode focusTargetNode2) {
                        return Boolean.valueOf(FocusTargetModifierNode.m4499requestFocus3ESFkO8$default(focusTargetNode2, 0, 1, null));
                    }
                });
            }
            if (((node.getKindSet() & i) != 0) && (node instanceof DelegatingNode)) {
                int i2 = 0;
                for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild()) {
                    if ((delegate$ui_release.getKindSet() & i) != 0) {
                        i2++;
                        if (i2 == 1) {
                            node = delegate$ui_release;
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
                                mutableVector.add(delegate$ui_release);
                            }
                        }
                    }
                }
                if (i2 == 1) {
                }
            }
            node = DelegatableNodeKt.access$pop(mutableVector);
        }
        if (!focusRequesterModifierNode2.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = focusRequesterModifierNode2.getNode().getChild();
        if (child == null) {
            DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, focusRequesterModifierNode2.getNode(), false);
        } else {
            mutableVector2.add(child);
        }
        while (true) {
            if (!(mutableVector2.getSize() != 0)) {
                return false;
            }
            Modifier.Node node2 = (Modifier.Node) mutableVector2.removeAt(mutableVector2.getSize() - 1);
            if ((node2.getAggregateChildKindSet() & i) == 0) {
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, node2, false);
            } else {
                while (true) {
                    if (node2 == null) {
                        break;
                    }
                    if ((node2.getKindSet() & i) != 0) {
                        MutableVector mutableVector3 = null;
                        while (node2 != null) {
                            if (node2 instanceof FocusTargetNode) {
                                FocusTargetNode focusTargetNode2 = (FocusTargetNode) node2;
                                return focusTargetNode2.fetchFocusProperties$ui_release().getCanFocus() ? FocusTargetModifierNode.m4499requestFocus3ESFkO8$default(focusTargetNode2, 0, 1, null) : TwoDimensionalFocusSearchKt.m4539findChildCorrespondingToFocusEnterOMvw8(focusTargetNode2, FocusDirection.INSTANCE.m4465getEnterdhqQ8s(), new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusRequesterModifierNodeKt$requestFocus$1$1
                                    public final Boolean invoke(FocusTargetNode focusTargetNode22) {
                                        return Boolean.valueOf(FocusTargetModifierNode.m4499requestFocus3ESFkO8$default(focusTargetNode22, 0, 1, null));
                                    }
                                });
                            }
                            if (((node2.getKindSet() & i) != 0) && (node2 instanceof DelegatingNode)) {
                                int i3 = 0;
                                for (Modifier.Node delegate$ui_release2 = ((DelegatingNode) node2).getDelegate$ui_release(); delegate$ui_release2 != null; delegate$ui_release2 = delegate$ui_release2.getChild()) {
                                    if ((delegate$ui_release2.getKindSet() & i) != 0) {
                                        i3++;
                                        if (i3 == 1) {
                                            node2 = delegate$ui_release2;
                                        } else {
                                            if (mutableVector3 == null) {
                                                mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (node2 != null) {
                                                if (mutableVector3 != null) {
                                                    mutableVector3.add(node2);
                                                }
                                                node2 = null;
                                            }
                                            if (mutableVector3 != null) {
                                                mutableVector3.add(delegate$ui_release2);
                                            }
                                        }
                                    }
                                }
                                if (i3 == 1) {
                                }
                            }
                            node2 = DelegatableNodeKt.access$pop(mutableVector3);
                        }
                    } else {
                        node2 = node2.getChild();
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:121:0x009c, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean captureFocus(FocusRequesterModifierNode focusRequesterModifierNode) {
        FocusRequesterModifierNode focusRequesterModifierNode2 = focusRequesterModifierNode;
        int i = NodeKind.constructor-impl(Fields.RotationZ);
        Modifier.Node node = focusRequesterModifierNode2.getNode();
        MutableVector mutableVector = null;
        while (node != null) {
            if (!(node instanceof FocusTargetNode)) {
                if (((node.getKindSet() & i) != 0) && (node instanceof DelegatingNode)) {
                    int i2 = 0;
                    for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild()) {
                        if ((delegate$ui_release.getKindSet() & i) != 0) {
                            i2++;
                            if (i2 == 1) {
                                node = delegate$ui_release;
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
                                    mutableVector.add(delegate$ui_release);
                                }
                            }
                        }
                    }
                    if (i2 == 1) {
                    }
                }
            } else if (FocusTransactionsKt.captureFocus((FocusTargetNode) node)) {
                return true;
            }
            node = DelegatableNodeKt.access$pop(mutableVector);
        }
        if (!focusRequesterModifierNode2.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = focusRequesterModifierNode2.getNode().getChild();
        if (child == null) {
            DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, focusRequesterModifierNode2.getNode(), false);
        } else {
            mutableVector2.add(child);
        }
        while (true) {
            if (!(mutableVector2.getSize() != 0)) {
                return false;
            }
            Modifier.Node node2 = (Modifier.Node) mutableVector2.removeAt(mutableVector2.getSize() - 1);
            if ((node2.getAggregateChildKindSet() & i) == 0) {
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, node2, false);
            } else {
                while (true) {
                    if (node2 == null) {
                        break;
                    }
                    if ((node2.getKindSet() & i) != 0) {
                        MutableVector mutableVector3 = null;
                        while (node2 != null) {
                            if (!(node2 instanceof FocusTargetNode)) {
                                if (((node2.getKindSet() & i) != 0) && (node2 instanceof DelegatingNode)) {
                                    int i3 = 0;
                                    for (Modifier.Node delegate$ui_release2 = ((DelegatingNode) node2).getDelegate$ui_release(); delegate$ui_release2 != null; delegate$ui_release2 = delegate$ui_release2.getChild()) {
                                        if ((delegate$ui_release2.getKindSet() & i) != 0) {
                                            i3++;
                                            if (i3 == 1) {
                                                node2 = delegate$ui_release2;
                                            } else {
                                                if (mutableVector3 == null) {
                                                    mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (node2 != null) {
                                                    if (mutableVector3 != null) {
                                                        mutableVector3.add(node2);
                                                    }
                                                    node2 = null;
                                                }
                                                if (mutableVector3 != null) {
                                                    mutableVector3.add(delegate$ui_release2);
                                                }
                                            }
                                        }
                                    }
                                    if (i3 == 1) {
                                    }
                                }
                            } else if (FocusTransactionsKt.captureFocus((FocusTargetNode) node2)) {
                                return true;
                            }
                            node2 = DelegatableNodeKt.access$pop(mutableVector3);
                        }
                    } else {
                        node2 = node2.getChild();
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:121:0x009c, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean freeFocus(FocusRequesterModifierNode focusRequesterModifierNode) {
        FocusRequesterModifierNode focusRequesterModifierNode2 = focusRequesterModifierNode;
        int i = NodeKind.constructor-impl(Fields.RotationZ);
        Modifier.Node node = focusRequesterModifierNode2.getNode();
        MutableVector mutableVector = null;
        while (node != null) {
            if (!(node instanceof FocusTargetNode)) {
                if (((node.getKindSet() & i) != 0) && (node instanceof DelegatingNode)) {
                    int i2 = 0;
                    for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild()) {
                        if ((delegate$ui_release.getKindSet() & i) != 0) {
                            i2++;
                            if (i2 == 1) {
                                node = delegate$ui_release;
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
                                    mutableVector.add(delegate$ui_release);
                                }
                            }
                        }
                    }
                    if (i2 == 1) {
                    }
                }
            } else if (FocusTransactionsKt.freeFocus((FocusTargetNode) node)) {
                return true;
            }
            node = DelegatableNodeKt.access$pop(mutableVector);
        }
        if (!focusRequesterModifierNode2.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = focusRequesterModifierNode2.getNode().getChild();
        if (child == null) {
            DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, focusRequesterModifierNode2.getNode(), false);
        } else {
            mutableVector2.add(child);
        }
        while (true) {
            if (!(mutableVector2.getSize() != 0)) {
                return false;
            }
            Modifier.Node node2 = (Modifier.Node) mutableVector2.removeAt(mutableVector2.getSize() - 1);
            if ((node2.getAggregateChildKindSet() & i) == 0) {
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, node2, false);
            } else {
                while (true) {
                    if (node2 == null) {
                        break;
                    }
                    if ((node2.getKindSet() & i) != 0) {
                        MutableVector mutableVector3 = null;
                        while (node2 != null) {
                            if (!(node2 instanceof FocusTargetNode)) {
                                if (((node2.getKindSet() & i) != 0) && (node2 instanceof DelegatingNode)) {
                                    int i3 = 0;
                                    for (Modifier.Node delegate$ui_release2 = ((DelegatingNode) node2).getDelegate$ui_release(); delegate$ui_release2 != null; delegate$ui_release2 = delegate$ui_release2.getChild()) {
                                        if ((delegate$ui_release2.getKindSet() & i) != 0) {
                                            i3++;
                                            if (i3 == 1) {
                                                node2 = delegate$ui_release2;
                                            } else {
                                                if (mutableVector3 == null) {
                                                    mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (node2 != null) {
                                                    if (mutableVector3 != null) {
                                                        mutableVector3.add(node2);
                                                    }
                                                    node2 = null;
                                                }
                                                if (mutableVector3 != null) {
                                                    mutableVector3.add(delegate$ui_release2);
                                                }
                                            }
                                        }
                                    }
                                    if (i3 == 1) {
                                    }
                                }
                            } else if (FocusTransactionsKt.freeFocus((FocusTargetNode) node2)) {
                                return true;
                            }
                            node2 = DelegatableNodeKt.access$pop(mutableVector3);
                        }
                    } else {
                        node2 = node2.getChild();
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:121:0x009c, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean saveFocusedChild(FocusRequesterModifierNode focusRequesterModifierNode) {
        FocusRequesterModifierNode focusRequesterModifierNode2 = focusRequesterModifierNode;
        int i = NodeKind.constructor-impl(Fields.RotationZ);
        Modifier.Node node = focusRequesterModifierNode2.getNode();
        MutableVector mutableVector = null;
        while (node != null) {
            if (!(node instanceof FocusTargetNode)) {
                if (((node.getKindSet() & i) != 0) && (node instanceof DelegatingNode)) {
                    int i2 = 0;
                    for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild()) {
                        if ((delegate$ui_release.getKindSet() & i) != 0) {
                            i2++;
                            if (i2 == 1) {
                                node = delegate$ui_release;
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
                                    mutableVector.add(delegate$ui_release);
                                }
                            }
                        }
                    }
                    if (i2 == 1) {
                    }
                }
            } else if (FocusRestorerKt.saveFocusedChild((FocusTargetNode) node)) {
                return true;
            }
            node = DelegatableNodeKt.access$pop(mutableVector);
        }
        if (!focusRequesterModifierNode2.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = focusRequesterModifierNode2.getNode().getChild();
        if (child == null) {
            DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, focusRequesterModifierNode2.getNode(), false);
        } else {
            mutableVector2.add(child);
        }
        while (true) {
            if (!(mutableVector2.getSize() != 0)) {
                return false;
            }
            Modifier.Node node2 = (Modifier.Node) mutableVector2.removeAt(mutableVector2.getSize() - 1);
            if ((node2.getAggregateChildKindSet() & i) == 0) {
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, node2, false);
            } else {
                while (true) {
                    if (node2 == null) {
                        break;
                    }
                    if ((node2.getKindSet() & i) != 0) {
                        MutableVector mutableVector3 = null;
                        while (node2 != null) {
                            if (!(node2 instanceof FocusTargetNode)) {
                                if (((node2.getKindSet() & i) != 0) && (node2 instanceof DelegatingNode)) {
                                    int i3 = 0;
                                    for (Modifier.Node delegate$ui_release2 = ((DelegatingNode) node2).getDelegate$ui_release(); delegate$ui_release2 != null; delegate$ui_release2 = delegate$ui_release2.getChild()) {
                                        if ((delegate$ui_release2.getKindSet() & i) != 0) {
                                            i3++;
                                            if (i3 == 1) {
                                                node2 = delegate$ui_release2;
                                            } else {
                                                if (mutableVector3 == null) {
                                                    mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (node2 != null) {
                                                    if (mutableVector3 != null) {
                                                        mutableVector3.add(node2);
                                                    }
                                                    node2 = null;
                                                }
                                                if (mutableVector3 != null) {
                                                    mutableVector3.add(delegate$ui_release2);
                                                }
                                            }
                                        }
                                    }
                                    if (i3 == 1) {
                                    }
                                }
                            } else if (FocusRestorerKt.saveFocusedChild((FocusTargetNode) node2)) {
                                return true;
                            }
                            node2 = DelegatableNodeKt.access$pop(mutableVector3);
                        }
                    } else {
                        node2 = node2.getChild();
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:121:0x009c, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean restoreFocusedChild(FocusRequesterModifierNode focusRequesterModifierNode) {
        FocusRequesterModifierNode focusRequesterModifierNode2 = focusRequesterModifierNode;
        int i = NodeKind.constructor-impl(Fields.RotationZ);
        Modifier.Node node = focusRequesterModifierNode2.getNode();
        MutableVector mutableVector = null;
        while (node != null) {
            if (!(node instanceof FocusTargetNode)) {
                if (((node.getKindSet() & i) != 0) && (node instanceof DelegatingNode)) {
                    int i2 = 0;
                    for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild()) {
                        if ((delegate$ui_release.getKindSet() & i) != 0) {
                            i2++;
                            if (i2 == 1) {
                                node = delegate$ui_release;
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
                                    mutableVector.add(delegate$ui_release);
                                }
                            }
                        }
                    }
                    if (i2 == 1) {
                    }
                }
            } else if (FocusRestorerKt.restoreFocusedChild((FocusTargetNode) node)) {
                return true;
            }
            node = DelegatableNodeKt.access$pop(mutableVector);
        }
        if (!focusRequesterModifierNode2.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = focusRequesterModifierNode2.getNode().getChild();
        if (child == null) {
            DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, focusRequesterModifierNode2.getNode(), false);
        } else {
            mutableVector2.add(child);
        }
        while (true) {
            if (!(mutableVector2.getSize() != 0)) {
                return false;
            }
            Modifier.Node node2 = (Modifier.Node) mutableVector2.removeAt(mutableVector2.getSize() - 1);
            if ((node2.getAggregateChildKindSet() & i) == 0) {
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, node2, false);
            } else {
                while (true) {
                    if (node2 == null) {
                        break;
                    }
                    if ((node2.getKindSet() & i) != 0) {
                        MutableVector mutableVector3 = null;
                        while (node2 != null) {
                            if (!(node2 instanceof FocusTargetNode)) {
                                if (((node2.getKindSet() & i) != 0) && (node2 instanceof DelegatingNode)) {
                                    int i3 = 0;
                                    for (Modifier.Node delegate$ui_release2 = ((DelegatingNode) node2).getDelegate$ui_release(); delegate$ui_release2 != null; delegate$ui_release2 = delegate$ui_release2.getChild()) {
                                        if ((delegate$ui_release2.getKindSet() & i) != 0) {
                                            i3++;
                                            if (i3 == 1) {
                                                node2 = delegate$ui_release2;
                                            } else {
                                                if (mutableVector3 == null) {
                                                    mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (node2 != null) {
                                                    if (mutableVector3 != null) {
                                                        mutableVector3.add(node2);
                                                    }
                                                    node2 = null;
                                                }
                                                if (mutableVector3 != null) {
                                                    mutableVector3.add(delegate$ui_release2);
                                                }
                                            }
                                        }
                                    }
                                    if (i3 == 1) {
                                    }
                                }
                            } else if (FocusRestorerKt.restoreFocusedChild((FocusTargetNode) node2)) {
                                return true;
                            }
                            node2 = DelegatableNodeKt.access$pop(mutableVector3);
                        }
                    } else {
                        node2 = node2.getChild();
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:121:0x009c, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final PinnableContainer.PinnedHandle pinFocusedChild(FocusRequesterModifierNode focusRequesterModifierNode) {
        FocusRequesterModifierNode focusRequesterModifierNode2 = focusRequesterModifierNode;
        int i = NodeKind.constructor-impl(Fields.RotationZ);
        Modifier.Node node = focusRequesterModifierNode2.getNode();
        MutableVector mutableVector = null;
        while (node != null) {
            if (node instanceof FocusTargetNode) {
                PinnableContainer.PinnedHandle pinFocusedChild = FocusRestorerKt.pinFocusedChild((FocusTargetNode) node);
                if (pinFocusedChild != null) {
                    return pinFocusedChild;
                }
            } else if (((node.getKindSet() & i) != 0) && (node instanceof DelegatingNode)) {
                int i2 = 0;
                for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild()) {
                    if ((delegate$ui_release.getKindSet() & i) != 0) {
                        i2++;
                        if (i2 == 1) {
                            node = delegate$ui_release;
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
                                mutableVector.add(delegate$ui_release);
                            }
                        }
                    }
                }
                if (i2 == 1) {
                }
            }
            node = DelegatableNodeKt.access$pop(mutableVector);
        }
        if (!focusRequesterModifierNode2.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = focusRequesterModifierNode2.getNode().getChild();
        if (child == null) {
            DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, focusRequesterModifierNode2.getNode(), false);
        } else {
            mutableVector2.add(child);
        }
        while (true) {
            if (!(mutableVector2.getSize() != 0)) {
                return null;
            }
            Modifier.Node node2 = (Modifier.Node) mutableVector2.removeAt(mutableVector2.getSize() - 1);
            if ((node2.getAggregateChildKindSet() & i) == 0) {
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, node2, false);
            } else {
                while (true) {
                    if (node2 == null) {
                        break;
                    }
                    if ((node2.getKindSet() & i) != 0) {
                        MutableVector mutableVector3 = null;
                        while (node2 != null) {
                            if (node2 instanceof FocusTargetNode) {
                                PinnableContainer.PinnedHandle pinFocusedChild2 = FocusRestorerKt.pinFocusedChild((FocusTargetNode) node2);
                                if (pinFocusedChild2 != null) {
                                    return pinFocusedChild2;
                                }
                            } else if (((node2.getKindSet() & i) != 0) && (node2 instanceof DelegatingNode)) {
                                int i3 = 0;
                                for (Modifier.Node delegate$ui_release2 = ((DelegatingNode) node2).getDelegate$ui_release(); delegate$ui_release2 != null; delegate$ui_release2 = delegate$ui_release2.getChild()) {
                                    if ((delegate$ui_release2.getKindSet() & i) != 0) {
                                        i3++;
                                        if (i3 == 1) {
                                            node2 = delegate$ui_release2;
                                        } else {
                                            if (mutableVector3 == null) {
                                                mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (node2 != null) {
                                                if (mutableVector3 != null) {
                                                    mutableVector3.add(node2);
                                                }
                                                node2 = null;
                                            }
                                            if (mutableVector3 != null) {
                                                mutableVector3.add(delegate$ui_release2);
                                            }
                                        }
                                    }
                                }
                                if (i3 == 1) {
                                }
                            }
                            node2 = DelegatableNodeKt.access$pop(mutableVector3);
                        }
                    } else {
                        node2 = node2.getChild();
                    }
                }
            }
        }
    }
}
