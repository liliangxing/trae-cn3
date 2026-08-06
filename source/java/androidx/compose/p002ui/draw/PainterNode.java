package androidx.compose.p002ui.draw;

import androidx.compose.p002ui.Alignment;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.geometry.InlineClassHelperKt;
import androidx.compose.p002ui.geometry.Size;
import androidx.compose.p002ui.graphics.ColorFilter;
import androidx.compose.p002ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p002ui.graphics.painter.Painter;
import androidx.compose.p002ui.layout.ContentScale;
import androidx.compose.p002ui.layout.IntrinsicMeasurable;
import androidx.compose.p002ui.layout.IntrinsicMeasureScope;
import androidx.compose.p002ui.layout.Measurable;
import androidx.compose.p002ui.layout.MeasureResult;
import androidx.compose.p002ui.layout.MeasureScope;
import androidx.compose.p002ui.layout.Placeable;
import androidx.compose.p002ui.layout.ScaleFactorKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: PainterModifier.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BA\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010.\u001a\u00020/*\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0016¢\u0006\u0004\b5\u00106J\u001c\u00107\u001a\u000208*\u0002092\u0006\u00101\u001a\u00020:2\u0006\u0010;\u001a\u000208H\u0016J\u001c\u0010<\u001a\u000208*\u0002092\u0006\u00101\u001a\u00020:2\u0006\u0010;\u001a\u000208H\u0016J\u001c\u0010=\u001a\u000208*\u0002092\u0006\u00101\u001a\u00020:2\u0006\u0010>\u001a\u000208H\u0016J\u001c\u0010?\u001a\u000208*\u0002092\u0006\u00101\u001a\u00020:2\u0006\u0010>\u001a\u000208H\u0016J\u0017\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020AH\u0002¢\u0006\u0004\bC\u0010DJ\u0017\u0010E\u001a\u0002042\u0006\u00103\u001a\u000204H\u0002¢\u0006\u0004\bF\u0010DJ\f\u0010G\u001a\u00020H*\u00020IH\u0016J\u0013\u0010J\u001a\u00020\u0007*\u00020AH\u0002¢\u0006\u0004\bK\u0010LJ\u0013\u0010M\u001a\u00020\u0007*\u00020AH\u0002¢\u0006\u0004\bN\u0010LJ\b\u0010O\u001a\u00020PH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\u0017R\u0014\u0010,\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\u0017¨\u0006Q"}, d2 = {"Landroidx/compose/ui/draw/PainterNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "sizeToIntrinsics", "", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "<init>", "(Landroidx/compose/ui/graphics/painter/Painter;ZLandroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;)V", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "setPainter", "(Landroidx/compose/ui/graphics/painter/Painter;)V", "getSizeToIntrinsics", "()Z", "setSizeToIntrinsics", "(Z)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "setAlignment", "(Landroidx/compose/ui/Alignment;)V", "getContentScale", "()Landroidx/compose/ui/layout/ContentScale;", "setContentScale", "(Landroidx/compose/ui/layout/ContentScale;)V", "getAlpha", "()F", "setAlpha", "(F)V", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "useIntrinsicSize", "getUseIntrinsicSize", "shouldAutoInvalidate", "getShouldAutoInvalidate", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "maxIntrinsicWidth", "minIntrinsicHeight", "width", "maxIntrinsicHeight", "calculateScaledSize", "Landroidx/compose/ui/geometry/Size;", "dstSize", "calculateScaledSize-E7KxVPU", "(J)J", "modifyConstraints", "modifyConstraints-ZezNO4M", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "hasSpecifiedAndFiniteWidth", "hasSpecifiedAndFiniteWidth-uvyYCjk", "(J)Z", "hasSpecifiedAndFiniteHeight", "hasSpecifiedAndFiniteHeight-uvyYCjk", "toString", "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
final class PainterNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode {
    private Alignment alignment;
    private float alpha;
    private ColorFilter colorFilter;
    private ContentScale contentScale;
    private Painter painter;
    private boolean sizeToIntrinsics;

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return false;
    }

    public final Painter getPainter() {
        return this.painter;
    }

    public final void setPainter(Painter painter) {
        this.painter = painter;
    }

    public final boolean getSizeToIntrinsics() {
        return this.sizeToIntrinsics;
    }

    public final void setSizeToIntrinsics(boolean z) {
        this.sizeToIntrinsics = z;
    }

    public /* synthetic */ PainterNode(Painter painter, boolean z, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(painter, z, (i & 4) != 0 ? Alignment.INSTANCE.getCenter() : alignment, (i & 8) != 0 ? ContentScale.INSTANCE.getInside() : contentScale, (i & 16) != 0 ? 1.0f : f, (i & 32) != 0 ? null : colorFilter);
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

    public PainterNode(Painter painter, boolean z, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter) {
        this.painter = painter;
        this.sizeToIntrinsics = z;
        this.alignment = alignment;
        this.contentScale = contentScale;
        this.alpha = f;
        this.colorFilter = colorFilter;
    }

    private final boolean getUseIntrinsicSize() {
        if (this.sizeToIntrinsics) {
            return (this.painter.getIntrinsicSize() > InlineClassHelperKt.UnspecifiedPackedFloats ? 1 : (this.painter.getIntrinsicSize() == InlineClassHelperKt.UnspecifiedPackedFloats ? 0 : -1)) != 0;
        }
        return false;
    }

    /* renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m4414measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        final Placeable mo6318measureBRTryo0 = measurable.mo6318measureBRTryo0(m4413modifyConstraintsZezNO4M(j));
        return MeasureScope.layout$default(measureScope, mo6318measureBRTryo0.getWidth(), mo6318measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.draw.PainterNode$measure$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope.placeRelative$default(placementScope, Placeable.this, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (getUseIntrinsicSize()) {
            long m4413modifyConstraintsZezNO4M = m4413modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7, (Object) null));
            return Math.max(Constraints.getMinWidth-impl(m4413modifyConstraintsZezNO4M), intrinsicMeasurable.minIntrinsicWidth(i));
        }
        return intrinsicMeasurable.minIntrinsicWidth(i);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (getUseIntrinsicSize()) {
            long m4413modifyConstraintsZezNO4M = m4413modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7, (Object) null));
            return Math.max(Constraints.getMinWidth-impl(m4413modifyConstraintsZezNO4M), intrinsicMeasurable.maxIntrinsicWidth(i));
        }
        return intrinsicMeasurable.maxIntrinsicWidth(i);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (getUseIntrinsicSize()) {
            long m4413modifyConstraintsZezNO4M = m4413modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13, (Object) null));
            return Math.max(Constraints.getMinHeight-impl(m4413modifyConstraintsZezNO4M), intrinsicMeasurable.minIntrinsicHeight(i));
        }
        return intrinsicMeasurable.minIntrinsicHeight(i);
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (getUseIntrinsicSize()) {
            long m4413modifyConstraintsZezNO4M = m4413modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13, (Object) null));
            return Math.max(Constraints.getMinHeight-impl(m4413modifyConstraintsZezNO4M), intrinsicMeasurable.maxIntrinsicHeight(i));
        }
        return intrinsicMeasurable.maxIntrinsicHeight(i);
    }

    /* renamed from: calculateScaledSize-E7KxVPU, reason: not valid java name */
    private final long m4410calculateScaledSizeE7KxVPU(long dstSize) {
        float intBitsToFloat;
        float intBitsToFloat2;
        if (!getUseIntrinsicSize()) {
            return dstSize;
        }
        if (!m4412hasSpecifiedAndFiniteWidthuvyYCjk(this.painter.getIntrinsicSize())) {
            intBitsToFloat = Float.intBitsToFloat((int) (dstSize >> 32));
        } else {
            intBitsToFloat = Float.intBitsToFloat((int) (this.painter.getIntrinsicSize() >> 32));
        }
        if (!m4411hasSpecifiedAndFiniteHeightuvyYCjk(this.painter.getIntrinsicSize())) {
            intBitsToFloat2 = Float.intBitsToFloat((int) (dstSize & 4294967295L));
        } else {
            intBitsToFloat2 = Float.intBitsToFloat((int) (this.painter.getIntrinsicSize() & 4294967295L));
        }
        long m4653constructorimpl = Size.m4653constructorimpl((Float.floatToRawIntBits(intBitsToFloat) << 32) | (Float.floatToRawIntBits(intBitsToFloat2) & 4294967295L));
        if (!(Float.intBitsToFloat((int) (dstSize >> 32)) == 0.0f)) {
            if (!(Float.intBitsToFloat((int) (4294967295L & dstSize)) == 0.0f)) {
                return ScaleFactorKt.m6468timesUQTWf7w(m4653constructorimpl, this.contentScale.mo6311computeScaleFactorH7hwNQA(m4653constructorimpl, dstSize));
            }
        }
        return Size.INSTANCE.m4671getZeroNHjbRc();
    }

    /* renamed from: modifyConstraints-ZezNO4M, reason: not valid java name */
    private final long m4413modifyConstraintsZezNO4M(long constraints) {
        int i;
        int i2;
        boolean z = Constraints.getHasBoundedWidth-impl(constraints) && Constraints.getHasBoundedHeight-impl(constraints);
        boolean z2 = Constraints.getHasFixedWidth-impl(constraints) && Constraints.getHasFixedHeight-impl(constraints);
        if ((!getUseIntrinsicSize() && z) || z2) {
            return Constraints.copy-Zbe2FdA$default(constraints, Constraints.getMaxWidth-impl(constraints), 0, Constraints.getMaxHeight-impl(constraints), 0, 10, (Object) null);
        }
        long intrinsicSize = this.painter.getIntrinsicSize();
        if (!m4412hasSpecifiedAndFiniteWidthuvyYCjk(intrinsicSize)) {
            i = Constraints.getMinWidth-impl(constraints);
        } else {
            i = Math.round(Float.intBitsToFloat((int) (intrinsicSize >> 32)));
        }
        if (!m4411hasSpecifiedAndFiniteHeightuvyYCjk(intrinsicSize)) {
            i2 = Constraints.getMinHeight-impl(constraints);
        } else {
            i2 = Math.round(Float.intBitsToFloat((int) (intrinsicSize & 4294967295L)));
        }
        long m4410calculateScaledSizeE7KxVPU = m4410calculateScaledSizeE7KxVPU(Size.m4653constructorimpl((Float.floatToRawIntBits(ConstraintsKt.constrainWidth-K40F9xA(constraints, i)) << 32) | (Float.floatToRawIntBits(ConstraintsKt.constrainHeight-K40F9xA(constraints, i2)) & 4294967295L)));
        return Constraints.copy-Zbe2FdA$default(constraints, ConstraintsKt.constrainWidth-K40F9xA(constraints, Math.round(Float.intBitsToFloat((int) (m4410calculateScaledSizeE7KxVPU >> 32)))), 0, ConstraintsKt.constrainHeight-K40F9xA(constraints, Math.round(Float.intBitsToFloat((int) (m4410calculateScaledSizeE7KxVPU & 4294967295L)))), 0, 10, (Object) null);
    }

    public void draw(ContentDrawScope contentDrawScope) {
        float intBitsToFloat;
        float intBitsToFloat2;
        long m4671getZeroNHjbRc;
        float f;
        float f2;
        ContentDrawScope contentDrawScope2;
        long intrinsicSize = this.painter.getIntrinsicSize();
        if (m4412hasSpecifiedAndFiniteWidthuvyYCjk(intrinsicSize)) {
            intBitsToFloat = Float.intBitsToFloat((int) (intrinsicSize >> 32));
        } else {
            intBitsToFloat = Float.intBitsToFloat((int) (contentDrawScope.m5417getSizeNHjbRc() >> 32));
        }
        if (m4411hasSpecifiedAndFiniteHeightuvyYCjk(intrinsicSize)) {
            intBitsToFloat2 = Float.intBitsToFloat((int) (intrinsicSize & 4294967295L));
        } else {
            intBitsToFloat2 = Float.intBitsToFloat((int) (contentDrawScope.m5417getSizeNHjbRc() & 4294967295L));
        }
        long m4653constructorimpl = Size.m4653constructorimpl((Float.floatToRawIntBits(intBitsToFloat2) & 4294967295L) | (Float.floatToRawIntBits(intBitsToFloat) << 32));
        try {
            if (!(Float.intBitsToFloat((int) (contentDrawScope.m5417getSizeNHjbRc() >> 32)) == 0.0f)) {
                if (!(Float.intBitsToFloat((int) (contentDrawScope.m5417getSizeNHjbRc() & 4294967295L)) == 0.0f)) {
                    m4671getZeroNHjbRc = ScaleFactorKt.m6468timesUQTWf7w(m4653constructorimpl, this.contentScale.mo6311computeScaleFactorH7hwNQA(m4653constructorimpl, contentDrawScope.m5417getSizeNHjbRc()));
                    long j = m4671getZeroNHjbRc;
                    long mo4279alignKFBX0sM = this.alignment.mo4279alignKFBX0sM(IntSize.constructor-impl((Math.round(Float.intBitsToFloat((int) (j & 4294967295L))) & 4294967295L) | (Math.round(Float.intBitsToFloat((int) (j >> 32))) << 32)), IntSize.constructor-impl((Math.round(Float.intBitsToFloat((int) (contentDrawScope.m5417getSizeNHjbRc() >> 32))) << 32) | (Math.round(Float.intBitsToFloat((int) (contentDrawScope.m5417getSizeNHjbRc() & 4294967295L))) & 4294967295L)), contentDrawScope.getLayoutDirection());
                    f = IntOffset.getX-impl(mo4279alignKFBX0sM);
                    f2 = IntOffset.getY-impl(mo4279alignKFBX0sM);
                    contentDrawScope2 = contentDrawScope;
                    contentDrawScope2.getDrawContext().getTransform().translate(f, f2);
                    this.painter.m5543drawx_KDEd0(contentDrawScope2, j, this.alpha, this.colorFilter);
                    contentDrawScope2.getDrawContext().getTransform().translate(-f, -f2);
                    contentDrawScope.drawContent();
                    return;
                }
            }
            this.painter.m5543drawx_KDEd0(contentDrawScope2, j, this.alpha, this.colorFilter);
            contentDrawScope2.getDrawContext().getTransform().translate(-f, -f2);
            contentDrawScope.drawContent();
            return;
        } catch (Throwable th) {
            contentDrawScope2.getDrawContext().getTransform().translate(-f, -f2);
            throw th;
        }
        m4671getZeroNHjbRc = Size.INSTANCE.m4671getZeroNHjbRc();
        long j2 = m4671getZeroNHjbRc;
        long mo4279alignKFBX0sM2 = this.alignment.mo4279alignKFBX0sM(IntSize.constructor-impl((Math.round(Float.intBitsToFloat((int) (j2 & 4294967295L))) & 4294967295L) | (Math.round(Float.intBitsToFloat((int) (j2 >> 32))) << 32)), IntSize.constructor-impl((Math.round(Float.intBitsToFloat((int) (contentDrawScope.m5417getSizeNHjbRc() >> 32))) << 32) | (Math.round(Float.intBitsToFloat((int) (contentDrawScope.m5417getSizeNHjbRc() & 4294967295L))) & 4294967295L)), contentDrawScope.getLayoutDirection());
        f = IntOffset.getX-impl(mo4279alignKFBX0sM2);
        f2 = IntOffset.getY-impl(mo4279alignKFBX0sM2);
        contentDrawScope2 = contentDrawScope;
        contentDrawScope2.getDrawContext().getTransform().translate(f, f2);
    }

    /* renamed from: hasSpecifiedAndFiniteWidth-uvyYCjk, reason: not valid java name */
    private final boolean m4412hasSpecifiedAndFiniteWidthuvyYCjk(long j) {
        if (Size.m4658equalsimpl0(j, Size.INSTANCE.m4670getUnspecifiedNHjbRc())) {
            return false;
        }
        return (Float.floatToRawIntBits(Float.intBitsToFloat((int) (j >> 32))) & Integer.MAX_VALUE) < 2139095040;
    }

    /* renamed from: hasSpecifiedAndFiniteHeight-uvyYCjk, reason: not valid java name */
    private final boolean m4411hasSpecifiedAndFiniteHeightuvyYCjk(long j) {
        if (Size.m4658equalsimpl0(j, Size.INSTANCE.m4670getUnspecifiedNHjbRc())) {
            return false;
        }
        return (Float.floatToRawIntBits(Float.intBitsToFloat((int) (j & 4294967295L))) & Integer.MAX_VALUE) < 2139095040;
    }

    public String toString() {
        return "PainterModifier(painter=" + this.painter + ", sizeToIntrinsics=" + this.sizeToIntrinsics + ", alignment=" + this.alignment + ", alpha=" + this.alpha + ", colorFilter=" + this.colorFilter + ')';
    }
}
