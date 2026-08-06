package coil3.compose.internal;

import androidx.compose.p001ui.node.DrawModifierNode;
import androidx.compose.p001ui.node.LayoutModifierNode;
import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.p001ui.unit.ConstraintsKt;
import androidx.compose.p001ui.unit.IntOffset;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.ScaleFactor;
import androidx.compose.ui.layout.ScaleFactorKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;

/* compiled from: ContentPainterModifier.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B1\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010(\u001a\u00020)*\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0016¢\u0006\u0004\b/\u00100J\u001c\u00101\u001a\u000202*\u0002032\u0006\u0010+\u001a\u0002042\u0006\u00105\u001a\u000202H\u0016J\u001c\u00106\u001a\u000202*\u0002032\u0006\u0010+\u001a\u0002042\u0006\u00105\u001a\u000202H\u0016J\u001c\u00107\u001a\u000202*\u0002032\u0006\u0010+\u001a\u0002042\u0006\u00108\u001a\u000202H\u0016J\u001c\u00109\u001a\u000202*\u0002032\u0006\u0010+\u001a\u0002042\u0006\u00108\u001a\u000202H\u0016J\u0017\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020;H\u0002¢\u0006\u0004\b=\u0010>J\u0017\u0010?\u001a\u00020.2\u0006\u0010-\u001a\u00020.H\u0002¢\u0006\u0004\b@\u0010>J\f\u0010A\u001a\u00020B*\u00020CH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006D"}, d2 = {"Lcoil3/compose/internal/LegacyContentPainterNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "<init>", "(Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;)V", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "setPainter", "(Landroidx/compose/ui/graphics/painter/Painter;)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "setAlignment", "(Landroidx/compose/ui/Alignment;)V", "getContentScale", "()Landroidx/compose/ui/layout/ContentScale;", "setContentScale", "(Landroidx/compose/ui/layout/ContentScale;)V", "getAlpha", "()F", "setAlpha", "(F)V", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "shouldAutoInvalidate", "", "getShouldAutoInvalidate", "()Z", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "maxIntrinsicWidth", "minIntrinsicHeight", "width", "maxIntrinsicHeight", "calculateScaledSize", "Landroidx/compose/ui/geometry/Size;", "dstSize", "calculateScaledSize-E7KxVPU", "(J)J", "modifyConstraints", "modifyConstraints-ZezNO4M", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "coil-compose-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class LegacyContentPainterNode extends Modifier.Node implements DrawModifierNode, LayoutModifierNode {
    public static final int $stable = 8;
    private Alignment alignment;
    private float alpha;
    private ColorFilter colorFilter;
    private ContentScale contentScale;
    private Painter painter;

    public boolean getShouldAutoInvalidate() {
        return false;
    }

    public final Painter getPainter() {
        return this.painter;
    }

    public final void setPainter(Painter painter) {
        this.painter = painter;
    }

    public final Alignment getAlignment() {
        return this.alignment;
    }

    public final void setAlignment(Alignment alignment) {
        this.alignment = alignment;
    }

    public final ContentScale getContentScale() {
        return this.contentScale;
    }

    public final void setContentScale(ContentScale contentScale) {
        this.contentScale = contentScale;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final void setAlpha(float f) {
        this.alpha = f;
    }

    public final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.colorFilter = colorFilter;
    }

    public LegacyContentPainterNode(Painter painter, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter) {
        this.painter = painter;
        this.alignment = alignment;
        this.contentScale = contentScale;
        this.alpha = f;
        this.colorFilter = colorFilter;
    }

    @Override // androidx.compose.p001ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo1319measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        final Placeable placeable = measurable.measure-BRTryo0(m3218modifyConstraintsZezNO4M(j));
        return MeasureScope.layout$default(measureScope, placeable.getWidth(), placeable.getHeight(), (Map) null, new Function1() { // from class: coil3.compose.internal.LegacyContentPainterNode$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit measure_3p2s80s$lambda$0;
                measure_3p2s80s$lambda$0 = LegacyContentPainterNode.measure_3p2s80s$lambda$0(placeable, (Placeable.PlacementScope) obj);
                return measure_3p2s80s$lambda$0;
            }
        }, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$0(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, 0, 0.0f, 4, (Object) null);
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.p001ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (this.painter.getIntrinsicSize-NH-jbRc() != Size.Companion.getUnspecified-NH-jbRc()) {
            int minIntrinsicWidth = intrinsicMeasurable.minIntrinsicWidth(Constraints.m2620getMaxHeightimpl(m3218modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null))));
            return Math.max(MathKt.roundToInt(Size.getWidth-impl(m3217calculateScaledSizeE7KxVPU(SizeKt.Size(minIntrinsicWidth, i)))), minIntrinsicWidth);
        }
        return intrinsicMeasurable.minIntrinsicWidth(i);
    }

    @Override // androidx.compose.p001ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (this.painter.getIntrinsicSize-NH-jbRc() != Size.Companion.getUnspecified-NH-jbRc()) {
            int maxIntrinsicWidth = intrinsicMeasurable.maxIntrinsicWidth(Constraints.m2620getMaxHeightimpl(m3218modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null))));
            return Math.max(MathKt.roundToInt(Size.getWidth-impl(m3217calculateScaledSizeE7KxVPU(SizeKt.Size(maxIntrinsicWidth, i)))), maxIntrinsicWidth);
        }
        return intrinsicMeasurable.maxIntrinsicWidth(i);
    }

    @Override // androidx.compose.p001ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (this.painter.getIntrinsicSize-NH-jbRc() != Size.Companion.getUnspecified-NH-jbRc()) {
            int minIntrinsicHeight = intrinsicMeasurable.minIntrinsicHeight(Constraints.m2621getMaxWidthimpl(m3218modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null))));
            return Math.max(MathKt.roundToInt(Size.getHeight-impl(m3217calculateScaledSizeE7KxVPU(SizeKt.Size(i, minIntrinsicHeight)))), minIntrinsicHeight);
        }
        return intrinsicMeasurable.minIntrinsicHeight(i);
    }

    @Override // androidx.compose.p001ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (this.painter.getIntrinsicSize-NH-jbRc() != Size.Companion.getUnspecified-NH-jbRc()) {
            int maxIntrinsicHeight = intrinsicMeasurable.maxIntrinsicHeight(Constraints.m2621getMaxWidthimpl(m3218modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null))));
            return Math.max(MathKt.roundToInt(Size.getHeight-impl(m3217calculateScaledSizeE7KxVPU(SizeKt.Size(i, maxIntrinsicHeight)))), maxIntrinsicHeight);
        }
        return intrinsicMeasurable.maxIntrinsicHeight(i);
    }

    /* renamed from: calculateScaledSize-E7KxVPU, reason: not valid java name */
    private final long m3217calculateScaledSizeE7KxVPU(long dstSize) {
        if (Size.isEmpty-impl(dstSize)) {
            return Size.Companion.getZero-NH-jbRc();
        }
        long j = this.painter.getIntrinsicSize-NH-jbRc();
        if (j == Size.Companion.getUnspecified-NH-jbRc()) {
            return dstSize;
        }
        float f = Size.getWidth-impl(j);
        if (!((Float.isInfinite(f) || Float.isNaN(f)) ? false : true)) {
            f = Size.getWidth-impl(dstSize);
        }
        float f2 = Size.getHeight-impl(j);
        if (!((Float.isInfinite(f2) || Float.isNaN(f2)) ? false : true)) {
            f2 = Size.getHeight-impl(dstSize);
        }
        long Size = SizeKt.Size(f, f2);
        long j2 = this.contentScale.computeScaleFactor-H7hwNQA(Size, dstSize);
        float f3 = ScaleFactor.getScaleX-impl(j2);
        if (!((Float.isInfinite(f3) || Float.isNaN(f3)) ? false : true)) {
            return dstSize;
        }
        float f4 = ScaleFactor.getScaleY-impl(j2);
        return !((Float.isInfinite(f4) || Float.isNaN(f4)) ? false : true) ? dstSize : ScaleFactorKt.times-m-w2e94(j2, Size);
    }

    /* renamed from: modifyConstraints-ZezNO4M, reason: not valid java name */
    private final long m3218modifyConstraintsZezNO4M(long constraints) {
        float m3230constrainWidthK40F9xA;
        int m2622getMinHeightimpl;
        float m3229constrainHeightK40F9xA;
        boolean m2619getHasFixedWidthimpl = Constraints.m2619getHasFixedWidthimpl(constraints);
        boolean m2618getHasFixedHeightimpl = Constraints.m2618getHasFixedHeightimpl(constraints);
        if (m2619getHasFixedWidthimpl && m2618getHasFixedHeightimpl) {
            return constraints;
        }
        boolean z = Constraints.m2617getHasBoundedWidthimpl(constraints) && Constraints.m2616getHasBoundedHeightimpl(constraints);
        long j = this.painter.getIntrinsicSize-NH-jbRc();
        if (j == Size.Companion.getUnspecified-NH-jbRc()) {
            return z ? Constraints.m2611copyZbe2FdA$default(constraints, Constraints.m2621getMaxWidthimpl(constraints), 0, Constraints.m2620getMaxHeightimpl(constraints), 0, 10, null) : constraints;
        }
        if (z && (m2619getHasFixedWidthimpl || m2618getHasFixedHeightimpl)) {
            m3230constrainWidthK40F9xA = Constraints.m2621getMaxWidthimpl(constraints);
            m2622getMinHeightimpl = Constraints.m2620getMaxHeightimpl(constraints);
        } else {
            float f = Size.getWidth-impl(j);
            float f2 = Size.getHeight-impl(j);
            m3230constrainWidthK40F9xA = !Float.isInfinite(f) && !Float.isNaN(f) ? UtilsKt.m3230constrainWidthK40F9xA(constraints, f) : Constraints.m2623getMinWidthimpl(constraints);
            if (!((Float.isInfinite(f2) || Float.isNaN(f2)) ? false : true)) {
                m2622getMinHeightimpl = Constraints.m2622getMinHeightimpl(constraints);
            } else {
                m3229constrainHeightK40F9xA = UtilsKt.m3229constrainHeightK40F9xA(constraints, f2);
                long m3217calculateScaledSizeE7KxVPU = m3217calculateScaledSizeE7KxVPU(SizeKt.Size(m3230constrainWidthK40F9xA, m3229constrainHeightK40F9xA));
                return Constraints.m2611copyZbe2FdA$default(constraints, ConstraintsKt.m2638constrainWidthK40F9xA(constraints, MathKt.roundToInt(Size.getWidth-impl(m3217calculateScaledSizeE7KxVPU))), 0, ConstraintsKt.m2637constrainHeightK40F9xA(constraints, MathKt.roundToInt(Size.getHeight-impl(m3217calculateScaledSizeE7KxVPU))), 0, 10, null);
            }
        }
        m3229constrainHeightK40F9xA = m2622getMinHeightimpl;
        long m3217calculateScaledSizeE7KxVPU2 = m3217calculateScaledSizeE7KxVPU(SizeKt.Size(m3230constrainWidthK40F9xA, m3229constrainHeightK40F9xA));
        return Constraints.m2611copyZbe2FdA$default(constraints, ConstraintsKt.m2638constrainWidthK40F9xA(constraints, MathKt.roundToInt(Size.getWidth-impl(m3217calculateScaledSizeE7KxVPU2))), 0, ConstraintsKt.m2637constrainHeightK40F9xA(constraints, MathKt.roundToInt(Size.getHeight-impl(m3217calculateScaledSizeE7KxVPU2))), 0, 10, null);
    }

    @Override // androidx.compose.p001ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        long m3217calculateScaledSizeE7KxVPU = m3217calculateScaledSizeE7KxVPU(contentDrawScope.getSize-NH-jbRc());
        long j = this.alignment.align-KFBX0sM(UtilsKt.m3233toIntSizeuvyYCjk(m3217calculateScaledSizeE7KxVPU), UtilsKt.m3233toIntSizeuvyYCjk(contentDrawScope.getSize-NH-jbRc()), contentDrawScope.getLayoutDirection());
        DrawScope drawScope = (DrawScope) contentDrawScope;
        float m2800component1impl = IntOffset.m2800component1impl(j);
        float m2801component2impl = IntOffset.m2801component2impl(j);
        drawScope.getDrawContext().getTransform().translate(m2800component1impl, m2801component2impl);
        this.painter.draw-x_KDEd0(drawScope, m3217calculateScaledSizeE7KxVPU, this.alpha, this.colorFilter);
        drawScope.getDrawContext().getTransform().translate(-m2800component1impl, -m2801component2impl);
        contentDrawScope.drawContent();
    }
}
