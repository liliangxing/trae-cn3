package androidx.compose.p001ui.spatial;

import androidx.compose.p001ui.node.DelegatableNode;
import androidx.compose.p001ui.node.DelegatableNodeKt;
import androidx.compose.p001ui.node.LayoutNode;
import androidx.compose.p001ui.node.NodeCoordinator;
import androidx.compose.p001ui.node.NodeKind;
import androidx.compose.p001ui.unit.IntOffset;
import androidx.compose.p001ui.unit.IntOffsetKt;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;

/* compiled from: ThrottledCallbacks.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aK\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0000¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"rectInfoFor", "Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "node", "Landroidx/compose/ui/node/DelegatableNode;", "topLeft", "", "bottomRight", "windowOffset", "Landroidx/compose/ui/unit/IntOffset;", "screenOffset", "windowSize", "viewToWindowMatrix", "Landroidx/compose/ui/graphics/Matrix;", "rectInfoFor-Dg36KO4", "(Landroidx/compose/ui/node/DelegatableNode;JJJJJ[F)Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class ThrottledCallbacksKt {
    /* renamed from: rectInfoFor-Dg36KO4, reason: not valid java name */
    public static final RelativeLayoutBounds m1908rectInfoForDg36KO4(DelegatableNode delegatableNode, long j, long j2, long j3, long j4, long j5, float[] fArr) {
        NodeCoordinator m1341requireCoordinator64DMado = DelegatableNodeKt.m1341requireCoordinator64DMado(delegatableNode, NodeKind.m1562constructorimpl(2));
        LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(delegatableNode);
        if (!requireLayoutNode.isPlaced()) {
            return null;
        }
        if (requireLayoutNode.getOuterCoordinator$ui_release() != m1341requireCoordinator64DMado) {
            long m2802constructorimpl = IntOffset.m2802constructorimpl(j);
            long j6 = Offset.constructor-impl((Float.floatToRawIntBits(IntOffset.m2808getXimpl(m2802constructorimpl)) << 32) | (Float.floatToRawIntBits(IntOffset.m2809getYimpl(m2802constructorimpl)) & 4294967295L));
            long j7 = m1341requireCoordinator64DMado.getCoordinates().getSize-YbymL2g();
            return new RelativeLayoutBounds(IntOffsetKt.m2825roundk4lQ0M(requireLayoutNode.getOuterCoordinator$ui_release().getCoordinates().localPositionOf-R5De75A(m1341requireCoordinator64DMado, j6)), IntOffset.m2802constructorimpl(((IntOffset.m2808getXimpl(r3) + ((int) (j7 >> 32))) << 32) | ((IntOffset.m2809getYimpl(r3) + ((int) (j7 & 4294967295L))) & 4294967295L)), j3, j4, j5, fArr, delegatableNode, null);
        }
        return new RelativeLayoutBounds(j, j2, j3, j4, j5, fArr, delegatableNode, null);
    }
}
