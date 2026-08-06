package androidx.compose.animation;

import androidx.compose.p002ui.Alignment;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.graphics.GraphicsLayerScope;
import androidx.compose.p002ui.graphics.TransformOriginKt;
import androidx.compose.p002ui.layout.ContentScale;
import androidx.compose.p002ui.layout.IntrinsicMeasurable;
import androidx.compose.p002ui.layout.IntrinsicMeasureScope;
import androidx.compose.p002ui.layout.Measurable;
import androidx.compose.p002ui.layout.MeasureResult;
import androidx.compose.p002ui.layout.MeasureScope;
import androidx.compose.p002ui.layout.Placeable;
import androidx.compose.p002ui.layout.ScaleFactor;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: SkipToLookaheadNode.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ#\u0010\u001a\u001a\u00020\u001b*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0016H\u0016¢\u0006\u0004\b \u0010!J\u001c\u0010\"\u001a\u00020#*\u00020$2\u0006\u0010\u001d\u001a\u00020%2\u0006\u0010&\u001a\u00020#H\u0016J\u001c\u0010'\u001a\u00020#*\u00020$2\u0006\u0010\u001d\u001a\u00020%2\u0006\u0010&\u001a\u00020#H\u0016J\u001c\u0010(\u001a\u00020#*\u00020$2\u0006\u0010\u001d\u001a\u00020%2\u0006\u0010)\u001a\u00020#H\u0016J\u001c\u0010*\u001a\u00020#*\u00020$2\u0006\u0010\u001d\u001a\u00020%2\u0006\u0010)\u001a\u00020#H\u0016R/\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR7\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0005\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0019¨\u0006+"}, d2 = {"Landroidx/compose/animation/SkipToLookaheadNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "scaleToBounds", "Landroidx/compose/animation/ScaleToBoundsImpl;", "isEnabled", "Lkotlin/Function0;", "", "<init>", "(Landroidx/compose/animation/ScaleToBoundsImpl;Lkotlin/jvm/functions/Function0;)V", "<set-?>", "getScaleToBounds", "()Landroidx/compose/animation/ScaleToBoundsImpl;", "setScaleToBounds", "(Landroidx/compose/animation/ScaleToBoundsImpl;)V", "scaleToBounds$delegate", "Landroidx/compose/runtime/MutableState;", "()Lkotlin/jvm/functions/Function0;", "setEnabled", "(Lkotlin/jvm/functions/Function0;)V", "isEnabled$delegate", "lookaheadConstraints", "Landroidx/compose/ui/unit/Constraints;", "lookaheadSize", "Landroidx/compose/ui/unit/IntSize;", "J", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "maxIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "minIntrinsicWidth", "maxIntrinsicHeight", "width", "minIntrinsicHeight", "animation"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class SkipToLookaheadNode extends Modifier.Node implements LayoutModifierNode {
    public static final int $stable = 8;

    /* renamed from: isEnabled$delegate, reason: from kotlin metadata */
    private final MutableState isEnabled;
    private Constraints lookaheadConstraints;
    private long lookaheadSize;

    /* renamed from: scaleToBounds$delegate, reason: from kotlin metadata */
    private final MutableState scaleToBounds;

    public SkipToLookaheadNode(ScaleToBoundsImpl scaleToBoundsImpl, Function0<Boolean> function0) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(scaleToBoundsImpl, null, 2, null);
        this.scaleToBounds = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(function0, null, 2, null);
        this.isEnabled = mutableStateOf$default2;
        this.lookaheadSize = AnimationModifierKt.getInvalidSize();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ScaleToBoundsImpl getScaleToBounds() {
        return (ScaleToBoundsImpl) this.scaleToBounds.getValue();
    }

    public final void setScaleToBounds(ScaleToBoundsImpl scaleToBoundsImpl) {
        this.scaleToBounds.setValue(scaleToBoundsImpl);
    }

    public final Function0<Boolean> isEnabled() {
        return (Function0) this.isEnabled.getValue();
    }

    public final void setEnabled(Function0<Boolean> function0) {
        this.isEnabled.setValue(function0);
    }

    /* renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m257measure3p2s80s(final MeasureScope measureScope, Measurable measurable, long j) {
        Placeable mo6318measureBRTryo0;
        if (measureScope.isLookingAhead()) {
            this.lookaheadConstraints = Constraints.box-impl(j);
        }
        if (!((Boolean) isEnabled().invoke()).booleanValue()) {
            final Placeable mo6318measureBRTryo02 = measurable.mo6318measureBRTryo0(j);
            return MeasureScope.layout$default(measureScope, mo6318measureBRTryo02.getWidth(), mo6318measureBRTryo02.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.SkipToLookaheadNode$measure$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Placeable.PlacementScope) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(Placeable.PlacementScope placementScope) {
                    Placeable.PlacementScope.place$default(placementScope, Placeable.this, 0, 0, 0.0f, 4, null);
                }
            }, 4, null);
        }
        if (measureScope.isLookingAhead()) {
            mo6318measureBRTryo0 = measurable.mo6318measureBRTryo0(j);
            this.lookaheadSize = IntSize.constructor-impl((mo6318measureBRTryo0.getHeight() & 4294967295L) | (mo6318measureBRTryo0.getWidth() << 32));
        } else {
            Constraints constraints = this.lookaheadConstraints;
            Intrinsics.checkNotNull(constraints);
            mo6318measureBRTryo0 = measurable.mo6318measureBRTryo0(constraints.unbox-impl());
        }
        final Placeable placeable = mo6318measureBRTryo0;
        final long j2 = ConstraintsKt.constrain-4WqzIAM(j, this.lookaheadSize);
        return MeasureScope.layout$default(measureScope, (int) (j2 >> 32), (int) (j2 & 4294967295L), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.SkipToLookaheadNode$measure$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                long j3;
                final long m6447constructorimpl;
                long j4;
                long j5;
                long j6;
                long j7;
                ScaleToBoundsImpl scaleToBounds = SkipToLookaheadNode.this.getScaleToBounds();
                if (scaleToBounds == null) {
                    Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
                    return;
                }
                ContentScale contentScale = scaleToBounds.getContentScale();
                j3 = SkipToLookaheadNode.this.lookaheadSize;
                if (((int) (j3 >> 32)) != 0) {
                    j6 = SkipToLookaheadNode.this.lookaheadSize;
                    if (((int) (j6 & 4294967295L)) != 0) {
                        j7 = SkipToLookaheadNode.this.lookaheadSize;
                        m6447constructorimpl = contentScale.mo6311computeScaleFactorH7hwNQA(IntSizeKt.toSize-ozmzZPI(j7), IntSizeKt.toSize-ozmzZPI(j2));
                        Alignment alignment = scaleToBounds.getAlignment();
                        j4 = SkipToLookaheadNode.this.lookaheadSize;
                        int roundToInt = MathKt.roundToInt(((int) (j4 >> 32)) * Float.intBitsToFloat((int) (m6447constructorimpl >> 32)));
                        j5 = SkipToLookaheadNode.this.lookaheadSize;
                        long mo4279alignKFBX0sM = alignment.mo4279alignKFBX0sM(IntSize.constructor-impl((MathKt.roundToInt(((int) (j5 & 4294967295L)) * Float.intBitsToFloat((int) (m6447constructorimpl & 4294967295L))) & 4294967295L) | (roundToInt << 32)), j2, measureScope.getLayoutDirection());
                        Placeable.PlacementScope.placeWithLayer$default(placementScope, placeable, IntOffset.getX-impl(mo4279alignKFBX0sM), IntOffset.getY-impl(mo4279alignKFBX0sM), 0.0f, new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.animation.SkipToLookaheadNode$measure$2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((GraphicsLayerScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                                graphicsLayerScope.setScaleX(Float.intBitsToFloat((int) (m6447constructorimpl >> 32)));
                                graphicsLayerScope.setScaleY(Float.intBitsToFloat((int) (m6447constructorimpl & 4294967295L)));
                                graphicsLayerScope.mo5042setTransformOrigin__ExYCQ(TransformOriginKt.TransformOrigin(0.0f, 0.0f));
                            }
                        }, 4, (Object) null);
                    }
                }
                m6447constructorimpl = ScaleFactor.m6447constructorimpl((Float.floatToRawIntBits(1.0f) << 32) | (Float.floatToRawIntBits(1.0f) & 4294967295L));
                Alignment alignment2 = scaleToBounds.getAlignment();
                j4 = SkipToLookaheadNode.this.lookaheadSize;
                int roundToInt2 = MathKt.roundToInt(((int) (j4 >> 32)) * Float.intBitsToFloat((int) (m6447constructorimpl >> 32)));
                j5 = SkipToLookaheadNode.this.lookaheadSize;
                long mo4279alignKFBX0sM2 = alignment2.mo4279alignKFBX0sM(IntSize.constructor-impl((MathKt.roundToInt(((int) (j5 & 4294967295L)) * Float.intBitsToFloat((int) (m6447constructorimpl & 4294967295L))) & 4294967295L) | (roundToInt2 << 32)), j2, measureScope.getLayoutDirection());
                Placeable.PlacementScope.placeWithLayer$default(placementScope, placeable, IntOffset.getX-impl(mo4279alignKFBX0sM2), IntOffset.getY-impl(mo4279alignKFBX0sM2), 0.0f, new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.animation.SkipToLookaheadNode$measure$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((GraphicsLayerScope) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                        graphicsLayerScope.setScaleX(Float.intBitsToFloat((int) (m6447constructorimpl >> 32)));
                        graphicsLayerScope.setScaleY(Float.intBitsToFloat((int) (m6447constructorimpl & 4294967295L)));
                        graphicsLayerScope.mo5042setTransformOrigin__ExYCQ(TransformOriginKt.TransformOrigin(0.0f, 0.0f));
                    }
                }, 4, (Object) null);
            }
        }, 4, null);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (!intrinsicMeasureScope.isLookingAhead() && AnimationModifierKt.m181isValidozmzZPI(this.lookaheadSize)) {
            return (int) (this.lookaheadSize >> 32);
        }
        return intrinsicMeasurable.maxIntrinsicWidth(i);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (!intrinsicMeasureScope.isLookingAhead() && AnimationModifierKt.m181isValidozmzZPI(this.lookaheadSize)) {
            return (int) (this.lookaheadSize >> 32);
        }
        return intrinsicMeasurable.minIntrinsicWidth(i);
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (!intrinsicMeasureScope.isLookingAhead() && AnimationModifierKt.m181isValidozmzZPI(this.lookaheadSize)) {
            return (int) (this.lookaheadSize & 4294967295L);
        }
        return intrinsicMeasurable.maxIntrinsicHeight(i);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (!intrinsicMeasureScope.isLookingAhead() && AnimationModifierKt.m181isValidozmzZPI(this.lookaheadSize)) {
            return (int) (this.lookaheadSize & 4294967295L);
        }
        return intrinsicMeasurable.minIntrinsicHeight(i);
    }
}
