package androidx.compose.p001ui.node;

import androidx.compose.p001ui.semantics.SemanticsActions;
import androidx.compose.p001ui.semantics.SemanticsConfiguration;
import androidx.compose.p001ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import kotlin.Metadata;

/* compiled from: SemanticsModifierNode.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0014\u0010\b\u001a\u00020\t*\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\"\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"invalidateSemantics", "", "Landroidx/compose/ui/node/SemanticsModifierNode;", "useMinimumTouchTarget", "", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "getUseMinimumTouchTarget", "(Landroidx/compose/ui/semantics/SemanticsConfiguration;)Z", "touchBoundsInRoot", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/Modifier$Node;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class SemanticsModifierNodeKt {
    public static final void invalidateSemantics(SemanticsModifierNode semanticsModifierNode) {
        DelegatableNodeKt.requireLayoutNode(semanticsModifierNode).invalidateSemantics$ui_release();
    }

    public static final boolean getUseMinimumTouchTarget(SemanticsConfiguration semanticsConfiguration) {
        return SemanticsConfigurationKt.getOrNull(semanticsConfiguration, SemanticsActions.INSTANCE.getOnClick()) != null;
    }

    public static final Rect touchBoundsInRoot(Modifier.Node node, boolean z) {
        if (!node.getNode().isAttached()) {
            return Rect.Companion.getZero();
        }
        if (!z) {
            return LayoutCoordinatesKt.boundsInRoot(DelegatableNodeKt.m1341requireCoordinator64DMado((DelegatableNode) node, NodeKind.m1562constructorimpl(8)));
        }
        return DelegatableNodeKt.m1341requireCoordinator64DMado((DelegatableNode) node, NodeKind.m1562constructorimpl(8)).touchBoundsInRoot();
    }
}
