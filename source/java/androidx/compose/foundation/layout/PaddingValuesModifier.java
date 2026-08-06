package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.layout.Measurable;
import androidx.compose.p002ui.layout.MeasureResult;
import androidx.compose.p002ui.layout.MeasureScope;
import androidx.compose.p002ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: Padding.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\n\u001a\u00020\u000b*\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u0013"}, d2 = {"Landroidx/compose/foundation/layout/PaddingValuesModifier;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "<init>", "(Landroidx/compose/foundation/layout/PaddingValues;)V", "getPaddingValues", "()Landroidx/compose/foundation/layout/PaddingValues;", "setPaddingValues", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
final class PaddingValuesModifier extends Modifier.Node implements LayoutModifierNode {
    private PaddingValues paddingValues;

    public final PaddingValues getPaddingValues() {
        return this.paddingValues;
    }

    public final void setPaddingValues(PaddingValues paddingValues) {
        this.paddingValues = paddingValues;
    }

    public PaddingValuesModifier(PaddingValues paddingValues) {
        this.paddingValues = paddingValues;
    }

    /* renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m1091measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        float mo998calculateLeftPaddingu2uoSUM = this.paddingValues.mo998calculateLeftPaddingu2uoSUM(measureScope.getLayoutDirection());
        float top = this.paddingValues.getTop();
        float mo999calculateRightPaddingu2uoSUM = this.paddingValues.mo999calculateRightPaddingu2uoSUM(measureScope.getLayoutDirection());
        float bottom = this.paddingValues.getBottom();
        float f = 0;
        if (!((Dp.compareTo-0680j_4(bottom, Dp.constructor-impl(f)) >= 0) & (Dp.compareTo-0680j_4(mo998calculateLeftPaddingu2uoSUM, Dp.constructor-impl(f)) >= 0) & (Dp.compareTo-0680j_4(top, Dp.constructor-impl(f)) >= 0) & (Dp.compareTo-0680j_4(mo999calculateRightPaddingu2uoSUM, Dp.constructor-impl(f)) >= 0))) {
            InlineClassHelperKt.throwIllegalArgumentException("Padding must be non-negative");
        }
        final int i = measureScope.roundToPx-0680j_4(mo998calculateLeftPaddingu2uoSUM);
        int i2 = measureScope.roundToPx-0680j_4(mo999calculateRightPaddingu2uoSUM) + i;
        final int i3 = measureScope.roundToPx-0680j_4(top);
        int i4 = measureScope.roundToPx-0680j_4(bottom) + i3;
        final Placeable mo6318measureBRTryo0 = measurable.mo6318measureBRTryo0(ConstraintsKt.offset-NN6Ew-U(j, -i2, -i4));
        return MeasureScope.layout$default(measureScope, ConstraintsKt.constrainWidth-K40F9xA(j, mo6318measureBRTryo0.getWidth() + i2), ConstraintsKt.constrainHeight-K40F9xA(j, mo6318measureBRTryo0.getHeight() + i4), null, new Function1() { // from class: androidx.compose.foundation.layout.PaddingValuesModifier$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit measure_3p2s80s$lambda$1;
                measure_3p2s80s$lambda$1 = PaddingValuesModifier.measure_3p2s80s$lambda$1(Placeable.this, i, i3, (Placeable.PlacementScope) obj);
                return measure_3p2s80s$lambda$1;
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$1(Placeable placeable, int i, int i2, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.place$default(placementScope, placeable, i, i2, 0.0f, 4, null);
        return Unit.INSTANCE;
    }
}
