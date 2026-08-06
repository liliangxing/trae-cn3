package androidx.compose.p002ui.focus;

import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.internal.InlineClassHelperKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import kotlin.Metadata;

/* compiled from: FocusPropertiesModifierNode.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"invalidateFocusProperties", "", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class FocusPropertiesModifierNodeKt {
    public static final void invalidateFocusProperties(FocusPropertiesModifierNode focusPropertiesModifierNode) {
        FocusPropertiesModifierNode focusPropertiesModifierNode2 = focusPropertiesModifierNode;
        int i = NodeKind.constructor-impl(Fields.RotationZ);
        if (!focusPropertiesModifierNode2.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = focusPropertiesModifierNode2.getNode().getChild();
        if (child == null) {
            DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector, focusPropertiesModifierNode2.getNode(), false);
        } else {
            mutableVector.add(child);
        }
        while (true) {
            if (!(mutableVector.getSize() != 0)) {
                return;
            }
            Modifier.Node node = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
            if ((node.getAggregateChildKindSet() & i) == 0) {
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector, node, false);
            } else {
                while (true) {
                    if (node == null) {
                        break;
                    }
                    if ((node.getKindSet() & i) != 0) {
                        MutableVector mutableVector2 = null;
                        while (node != null) {
                            if (node instanceof FocusTargetNode) {
                                FocusTargetNodeKt.invalidateFocusTarget((FocusTargetNode) node);
                            } else if (((node.getKindSet() & i) != 0) && (node instanceof DelegatingNode)) {
                                int i2 = 0;
                                for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild()) {
                                    if ((delegate$ui_release.getKindSet() & i) != 0) {
                                        i2++;
                                        if (i2 == 1) {
                                            node = delegate$ui_release;
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
                                                mutableVector2.add(delegate$ui_release);
                                            }
                                        }
                                    }
                                }
                                if (i2 == 1) {
                                }
                            }
                            node = DelegatableNodeKt.access$pop(mutableVector2);
                        }
                    } else {
                        node = node.getChild();
                    }
                }
            }
        }
    }
}
