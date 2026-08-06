package androidx.compose.p002ui.focus;

import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.internal.InlineClassHelperKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: FocusEventModifierNode.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\u0000¨\u0006\u0005"}, d2 = {"invalidateFocusEvent", "", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "getFocusState", "Landroidx/compose/ui/focus/FocusState;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class FocusEventModifierNodeKt {

    /* compiled from: FocusEventModifierNode.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            try {
                iArr[FocusStateImpl.Active.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FocusStateImpl.ActiveParent.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FocusStateImpl.Captured.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void invalidateFocusEvent(FocusEventModifierNode focusEventModifierNode) {
        DelegatableNodeKt.requireOwner(focusEventModifierNode).getFocusOwner().scheduleInvalidation(focusEventModifierNode);
    }

    /* JADX WARN: Code restructure failed: missing block: B:134:0x0106, code lost:
    
        return r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x00b6, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final FocusState getFocusState(FocusEventModifierNode focusEventModifierNode) {
        FocusEventModifierNode focusEventModifierNode2 = focusEventModifierNode;
        int i = NodeKind.constructor-impl(Fields.RotationZ);
        Modifier.Node node = focusEventModifierNode2.getNode();
        MutableVector mutableVector = null;
        while (node != null) {
            if (node instanceof FocusTargetNode) {
                FocusStateImpl focusState = ((FocusTargetNode) node).getFocusState();
                int i2 = WhenMappings.$EnumSwitchMapping$0[focusState.ordinal()];
                if (i2 == 1 || i2 == 2 || i2 == 3) {
                    return focusState;
                }
                if (i2 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
            } else if (((node.getKindSet() & i) != 0) && (node instanceof DelegatingNode)) {
                int i3 = 0;
                for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild()) {
                    if ((delegate$ui_release.getKindSet() & i) != 0) {
                        i3++;
                        if (i3 == 1) {
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
                if (i3 == 1) {
                }
            }
            node = DelegatableNodeKt.access$pop(mutableVector);
        }
        if (!focusEventModifierNode2.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = focusEventModifierNode2.getNode().getChild();
        if (child == null) {
            DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector2, focusEventModifierNode2.getNode(), false);
        } else {
            mutableVector2.add(child);
        }
        loop2: while (true) {
            if (!(mutableVector2.getSize() != 0)) {
                return FocusStateImpl.Inactive;
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
                                FocusStateImpl focusState2 = ((FocusTargetNode) node2).getFocusState();
                                int i4 = WhenMappings.$EnumSwitchMapping$0[focusState2.ordinal()];
                                if (i4 == 1 || i4 == 2 || i4 == 3) {
                                    break loop2;
                                }
                                if (i4 != 4) {
                                    throw new NoWhenBranchMatchedException();
                                }
                            } else if (((node2.getKindSet() & i) != 0) && (node2 instanceof DelegatingNode)) {
                                int i5 = 0;
                                for (Modifier.Node delegate$ui_release2 = ((DelegatingNode) node2).getDelegate$ui_release(); delegate$ui_release2 != null; delegate$ui_release2 = delegate$ui_release2.getChild()) {
                                    if ((delegate$ui_release2.getKindSet() & i) != 0) {
                                        i5++;
                                        if (i5 == 1) {
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
                                if (i5 == 1) {
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
