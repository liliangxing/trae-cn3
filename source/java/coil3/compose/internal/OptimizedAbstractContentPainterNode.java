package coil3.compose.internal;

import androidx.compose.p001ui.node.DrawModifierNode;
import androidx.compose.p001ui.node.LayoutModifierNode;
import androidx.compose.p001ui.node.SemanticsModifierNode;
import androidx.compose.p001ui.semantics.Role;
import androidx.compose.p001ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p001ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p001ui.unit.Constraints;
import androidx.compose.p001ui.unit.ConstraintsKt;
import androidx.compose.p001ui.unit.IntOffset;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
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
import coil3.compose.AsyncImagePainter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;

/* compiled from: ContentPainterModifier.kt */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b!\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004BG\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J#\u00107\u001a\u000208*\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0016¢\u0006\u0004\b>\u0010?J\u001c\u0010@\u001a\u00020A*\u00020B2\u0006\u0010:\u001a\u00020C2\u0006\u0010D\u001a\u00020AH\u0016J\u001c\u0010E\u001a\u00020A*\u00020B2\u0006\u0010:\u001a\u00020C2\u0006\u0010D\u001a\u00020AH\u0016J\u001c\u0010F\u001a\u00020A*\u00020B2\u0006\u0010:\u001a\u00020C2\u0006\u0010G\u001a\u00020AH\u0016J\u001c\u0010H\u001a\u00020A*\u00020B2\u0006\u0010:\u001a\u00020C2\u0006\u0010G\u001a\u00020AH\u0016J\u0017\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020JH\u0002¢\u0006\u0004\bL\u0010MJ\u0017\u0010N\u001a\u00020=2\u0006\u0010<\u001a\u00020=H\u0002¢\u0006\u0004\bO\u0010MJ\f\u0010P\u001a\u00020Q*\u00020RH\u0016J\f\u0010S\u001a\u00020Q*\u00020TH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0012\u00101\u001a\u000202X¦\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u0014\u00105\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u0010&¨\u0006U"}, d2 = {"Lcoil3/compose/internal/OptimizedAbstractContentPainterNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "clipToBounds", "", "contentDescription", "", "constraintSizeResolver", "Lcoil3/compose/internal/ConstraintsSizeResolver;", "<init>", "(Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;ZLjava/lang/String;Lcoil3/compose/internal/ConstraintsSizeResolver;)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "setAlignment", "(Landroidx/compose/ui/Alignment;)V", "getContentScale", "()Landroidx/compose/ui/layout/ContentScale;", "setContentScale", "(Landroidx/compose/ui/layout/ContentScale;)V", "getAlpha", "()F", "setAlpha", "(F)V", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "getClipToBounds", "()Z", "setClipToBounds", "(Z)V", "getContentDescription", "()Ljava/lang/String;", "setContentDescription", "(Ljava/lang/String;)V", "getConstraintSizeResolver", "()Lcoil3/compose/internal/ConstraintsSizeResolver;", "setConstraintSizeResolver", "(Lcoil3/compose/internal/ConstraintsSizeResolver;)V", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "shouldAutoInvalidate", "getShouldAutoInvalidate", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "maxIntrinsicWidth", "minIntrinsicHeight", "width", "maxIntrinsicHeight", "calculateScaledSize", "Landroidx/compose/ui/geometry/Size;", "dstSize", "calculateScaledSize-E7KxVPU", "(J)J", "modifyConstraints", "modifyConstraints-ZezNO4M", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "coil-compose-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public abstract class OptimizedAbstractContentPainterNode extends Modifier.Node implements DrawModifierNode, LayoutModifierNode, SemanticsModifierNode {
    public static final int $stable = 8;
    private Alignment alignment;
    private float alpha;
    private boolean clipToBounds;
    private ColorFilter colorFilter;
    private ConstraintsSizeResolver constraintSizeResolver;
    private String contentDescription;
    private ContentScale contentScale;

    public abstract Painter getPainter();

    public boolean getShouldAutoInvalidate() {
        return false;
    }

    public /* synthetic */ OptimizedAbstractContentPainterNode(Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, boolean z, String str, ConstraintsSizeResolver constraintsSizeResolver, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(alignment, contentScale, f, colorFilter, z, str, (i & 64) != 0 ? null : constraintsSizeResolver);
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

    public final boolean getClipToBounds() {
        return this.clipToBounds;
    }

    public final void setClipToBounds(boolean z) {
        this.clipToBounds = z;
    }

    public final String getContentDescription() {
        return this.contentDescription;
    }

    public final void setContentDescription(String str) {
        this.contentDescription = str;
    }

    public final ConstraintsSizeResolver getConstraintSizeResolver() {
        return this.constraintSizeResolver;
    }

    public final void setConstraintSizeResolver(ConstraintsSizeResolver constraintsSizeResolver) {
        this.constraintSizeResolver = constraintsSizeResolver;
    }

    public OptimizedAbstractContentPainterNode(Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, boolean z, String str, ConstraintsSizeResolver constraintsSizeResolver) {
        this.alignment = alignment;
        this.contentScale = contentScale;
        this.alpha = f;
        this.colorFilter = colorFilter;
        this.clipToBounds = z;
        this.contentDescription = str;
        this.constraintSizeResolver = constraintsSizeResolver;
    }

    @Override // androidx.compose.p001ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo1319measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        ConstraintsSizeResolver constraintsSizeResolver = this.constraintSizeResolver;
        if (constraintsSizeResolver != null) {
            constraintsSizeResolver.mo3211setConstraintsBRTryo0(j);
        }
        final Placeable placeable = measurable.measure-BRTryo0(m3220modifyConstraintsZezNO4M(j));
        return MeasureScope.layout$default(measureScope, placeable.getWidth(), placeable.getHeight(), (Map) null, new Function1() { // from class: coil3.compose.internal.OptimizedAbstractContentPainterNode$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit measure_3p2s80s$lambda$0;
                measure_3p2s80s$lambda$0 = OptimizedAbstractContentPainterNode.measure_3p2s80s$lambda$0(placeable, (Placeable.PlacementScope) obj);
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
        long Constraints$default = ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null);
        ConstraintsSizeResolver constraintsSizeResolver = this.constraintSizeResolver;
        if (constraintsSizeResolver != null) {
            constraintsSizeResolver.mo3211setConstraintsBRTryo0(Constraints$default);
        }
        if (getPainter().getIntrinsicSize-NH-jbRc() != Size.Companion.getUnspecified-NH-jbRc()) {
            return Math.max(Constraints.m2623getMinWidthimpl(m3220modifyConstraintsZezNO4M(Constraints$default)), intrinsicMeasurable.minIntrinsicWidth(i));
        }
        return intrinsicMeasurable.minIntrinsicWidth(i);
    }

    @Override // androidx.compose.p001ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        long Constraints$default = ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null);
        ConstraintsSizeResolver constraintsSizeResolver = this.constraintSizeResolver;
        if (constraintsSizeResolver != null) {
            constraintsSizeResolver.mo3211setConstraintsBRTryo0(Constraints$default);
        }
        if (getPainter().getIntrinsicSize-NH-jbRc() != Size.Companion.getUnspecified-NH-jbRc()) {
            return Math.max(Constraints.m2623getMinWidthimpl(m3220modifyConstraintsZezNO4M(Constraints$default)), intrinsicMeasurable.maxIntrinsicWidth(i));
        }
        return intrinsicMeasurable.maxIntrinsicWidth(i);
    }

    @Override // androidx.compose.p001ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        long Constraints$default = ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null);
        ConstraintsSizeResolver constraintsSizeResolver = this.constraintSizeResolver;
        if (constraintsSizeResolver != null) {
            constraintsSizeResolver.mo3211setConstraintsBRTryo0(Constraints$default);
        }
        if (getPainter().getIntrinsicSize-NH-jbRc() != Size.Companion.getUnspecified-NH-jbRc()) {
            return Math.max(Constraints.m2622getMinHeightimpl(m3220modifyConstraintsZezNO4M(Constraints$default)), intrinsicMeasurable.minIntrinsicHeight(i));
        }
        return intrinsicMeasurable.minIntrinsicHeight(i);
    }

    @Override // androidx.compose.p001ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        long Constraints$default = ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null);
        ConstraintsSizeResolver constraintsSizeResolver = this.constraintSizeResolver;
        if (constraintsSizeResolver != null) {
            constraintsSizeResolver.mo3211setConstraintsBRTryo0(Constraints$default);
        }
        if (getPainter().getIntrinsicSize-NH-jbRc() != Size.Companion.getUnspecified-NH-jbRc()) {
            return Math.max(Constraints.m2622getMinHeightimpl(m3220modifyConstraintsZezNO4M(Constraints$default)), intrinsicMeasurable.maxIntrinsicHeight(i));
        }
        return intrinsicMeasurable.maxIntrinsicHeight(i);
    }

    /* renamed from: calculateScaledSize-E7KxVPU, reason: not valid java name */
    private final long m3219calculateScaledSizeE7KxVPU(long dstSize) {
        if (Size.isEmpty-impl(dstSize)) {
            return Size.Companion.getZero-NH-jbRc();
        }
        long j = getPainter().getIntrinsicSize-NH-jbRc();
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
    private final long m3220modifyConstraintsZezNO4M(long constraints) {
        float m3230constrainWidthK40F9xA;
        int m2622getMinHeightimpl;
        float m3229constrainHeightK40F9xA;
        boolean m2619getHasFixedWidthimpl = Constraints.m2619getHasFixedWidthimpl(constraints);
        boolean m2618getHasFixedHeightimpl = Constraints.m2618getHasFixedHeightimpl(constraints);
        if (m2619getHasFixedWidthimpl && m2618getHasFixedHeightimpl) {
            return constraints;
        }
        Painter painter = getPainter();
        boolean z = Constraints.m2617getHasBoundedWidthimpl(constraints) && Constraints.m2616getHasBoundedHeightimpl(constraints);
        long j = painter.getIntrinsicSize-NH-jbRc();
        if (j == Size.Companion.getUnspecified-NH-jbRc()) {
            return z ? ((painter instanceof AsyncImagePainter) && ((AsyncImagePainter.State) ((AsyncImagePainter) painter).getState().getValue()).getPainter() == null) ? constraints : Constraints.m2611copyZbe2FdA$default(constraints, Constraints.m2621getMaxWidthimpl(constraints), 0, Constraints.m2620getMaxHeightimpl(constraints), 0, 10, null) : constraints;
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
                long m3219calculateScaledSizeE7KxVPU = m3219calculateScaledSizeE7KxVPU(SizeKt.Size(m3230constrainWidthK40F9xA, m3229constrainHeightK40F9xA));
                return Constraints.m2611copyZbe2FdA$default(constraints, ConstraintsKt.m2638constrainWidthK40F9xA(constraints, MathKt.roundToInt(Size.getWidth-impl(m3219calculateScaledSizeE7KxVPU))), 0, ConstraintsKt.m2637constrainHeightK40F9xA(constraints, MathKt.roundToInt(Size.getHeight-impl(m3219calculateScaledSizeE7KxVPU))), 0, 10, null);
            }
        }
        m3229constrainHeightK40F9xA = m2622getMinHeightimpl;
        long m3219calculateScaledSizeE7KxVPU2 = m3219calculateScaledSizeE7KxVPU(SizeKt.Size(m3230constrainWidthK40F9xA, m3229constrainHeightK40F9xA));
        return Constraints.m2611copyZbe2FdA$default(constraints, ConstraintsKt.m2638constrainWidthK40F9xA(constraints, MathKt.roundToInt(Size.getWidth-impl(m3219calculateScaledSizeE7KxVPU2))), 0, ConstraintsKt.m2637constrainHeightK40F9xA(constraints, MathKt.roundToInt(Size.getHeight-impl(m3219calculateScaledSizeE7KxVPU2))), 0, 10, null);
    }

    @Override // androidx.compose.p001ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        long m3219calculateScaledSizeE7KxVPU = m3219calculateScaledSizeE7KxVPU(contentDrawScope.getSize-NH-jbRc());
        long j = this.alignment.align-KFBX0sM(UtilsKt.m3233toIntSizeuvyYCjk(m3219calculateScaledSizeE7KxVPU), UtilsKt.m3233toIntSizeuvyYCjk(contentDrawScope.getSize-NH-jbRc()), contentDrawScope.getLayoutDirection());
        int m2800component1impl = IntOffset.m2800component1impl(j);
        int m2801component2impl = IntOffset.m2801component2impl(j);
        DrawScope drawScope = (DrawScope) contentDrawScope;
        DrawContext drawContext = drawScope.getDrawContext();
        long j2 = drawContext.getSize-NH-jbRc();
        drawContext.getCanvas().save();
        DrawTransform transform = drawContext.getTransform();
        if (this.clipToBounds) {
            DrawTransform.clipRect-N_I0leg$default(transform, 0.0f, 0.0f, 0.0f, 0.0f, 0, 31, (Object) null);
        }
        transform.translate(m2800component1impl, m2801component2impl);
        getPainter().draw-x_KDEd0(drawScope, m3219calculateScaledSizeE7KxVPU, this.alpha, this.colorFilter);
        drawContext.getCanvas().restore();
        drawContext.setSize-uvyYCjk(j2);
        contentDrawScope.drawContent();
    }

    @Override // androidx.compose.p001ui.node.SemanticsModifierNode
    public void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        String str = this.contentDescription;
        if (str != null) {
            SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
            SemanticsPropertiesKt.m1878setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m1863getImageo7Vup1c());
        }
    }
}
