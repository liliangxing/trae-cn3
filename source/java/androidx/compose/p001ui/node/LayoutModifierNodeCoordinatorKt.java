package androidx.compose.p001ui.node;

import androidx.compose.p001ui.unit.IntOffset;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import kotlin.Metadata;

/* compiled from: LayoutModifierNodeCoordinator.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¨\u0006\u0005"}, d2 = {"calculateAlignmentAndPlaceChildAsNeeded", "", "Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class LayoutModifierNodeCoordinatorKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int calculateAlignmentAndPlaceChildAsNeeded(LookaheadCapablePlaceable lookaheadCapablePlaceable, AlignmentLine alignmentLine) {
        int m2808getXimpl;
        LookaheadCapablePlaceable child = lookaheadCapablePlaceable.getChild();
        if (!(child != null)) {
            InlineClassHelperKt.throwIllegalStateException("Child of " + lookaheadCapablePlaceable + " cannot be null when calculating alignment line");
        }
        if (lookaheadCapablePlaceable.getMeasureResult$ui_release().getAlignmentLines().containsKey(alignmentLine)) {
            Integer num = (Integer) lookaheadCapablePlaceable.getMeasureResult$ui_release().getAlignmentLines().get(alignmentLine);
            if (num != null) {
                return num.intValue();
            }
            return Integer.MIN_VALUE;
        }
        int i = child.get(alignmentLine);
        if (i == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        child.setShallowPlacing$ui_release(true);
        lookaheadCapablePlaceable.setPlacingForAlignment$ui_release(true);
        lookaheadCapablePlaceable.replace$ui_release();
        child.setShallowPlacing$ui_release(false);
        lookaheadCapablePlaceable.setPlacingForAlignment$ui_release(false);
        if (alignmentLine instanceof HorizontalAlignmentLine) {
            m2808getXimpl = IntOffset.m2809getYimpl(child.getPosition());
        } else {
            m2808getXimpl = IntOffset.m2808getXimpl(child.getPosition());
        }
        return i + m2808getXimpl;
    }
}
