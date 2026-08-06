package androidx.compose.animation;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector4D;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.p002ui.geometry.InlineClassHelperKt;
import androidx.compose.p002ui.geometry.Offset;
import androidx.compose.p002ui.geometry.Rect;
import androidx.compose.p002ui.geometry.RectKt;
import androidx.compose.p002ui.geometry.Size;
import androidx.compose.p002ui.layout.LayoutCoordinates;
import androidx.compose.p002ui.layout.LayoutCoordinatesKt;
import androidx.compose.p002ui.layout.LookaheadScope;
import androidx.compose.p002ui.layout.Placeable;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: AnimateBoundsModifier.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\t¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0016\u0010\u0013J\u001d\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\t¢\u0006\u0004\b!\u0010\"J6\u00102\u001a\u00020\u00102\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020<J\u0018\u0010=\u001a\u00020\u00062\u0006\u00107\u001a\u0002082\u0006\u0010;\u001a\u00020<H\u0002R\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0010\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u00020\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u001c\u0010\u0018\u001a\u00020\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u0013R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010#\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b#\u0010$R/\u0010&\u001a\u0004\u0018\u00010\u00062\b\u0010%\u001a\u0004\u0018\u00010\u00068B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b'\u0010\u001e\"\u0004\b(\u0010)R\u0013\u0010,\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b-\u0010\u001eR\u0016\u0010.\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u00020\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\n¨\u0006>"}, d2 = {"Landroidx/compose/animation/BoundsTransformDeferredAnimation;", "", "<init>", "()V", "animatable", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/animation/core/AnimationVector4D;", "targetSize", "Landroidx/compose/ui/geometry/Size;", "J", "targetOffset", "Landroidx/compose/ui/geometry/Offset;", "isPending", "", "updateTargetSize", "", "size", "updateTargetSize-uvyYCjk", "(J)V", "updateTargetOffset", "offset", "updateTargetOffset-k-4lQ0M", "currentPosition", "currentSize", "getCurrentSize-NH-jbRc", "()J", "setCurrentSize-uvyYCjk", "currentBounds", "getCurrentBounds", "()Landroidx/compose/ui/geometry/Rect;", "updateCurrentBounds", "position", "updateCurrentBounds-tz77jQw", "(JJ)V", "isIdle", "()Z", "<set-?>", "animatedValue", "getAnimatedValue", "setAnimatedValue", "(Landroidx/compose/ui/geometry/Rect;)V", "animatedValue$delegate", "Landroidx/compose/runtime/MutableState;", "value", "getValue", "directManipulationParents", "", "Landroidx/compose/ui/layout/LayoutCoordinates;", "additionalOffset", "updateTargetOffsetAndAnimate", "lookaheadScope", "Landroidx/compose/ui/layout/LookaheadScope;", "placementScope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "directManipulationParentsDirty", "includeMotionFrameOfReference", "boundsTransform", "Landroidx/compose/animation/BoundsTransform;", "animate", "animation"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class BoundsTransformDeferredAnimation {
    public static final int $stable = 8;
    private long additionalOffset;
    private Animatable<Rect, AnimationVector4D> animatable;

    /* renamed from: animatedValue$delegate, reason: from kotlin metadata */
    private final MutableState animatedValue;
    private List<LayoutCoordinates> directManipulationParents;
    private boolean isPending;
    private long targetSize = Size.INSTANCE.m4670getUnspecifiedNHjbRc();
    private long targetOffset = Offset.INSTANCE.m4608getUnspecifiedF1C5BW0();
    private long currentPosition = Offset.INSTANCE.m4608getUnspecifiedF1C5BW0();
    private long currentSize = Size.INSTANCE.m4670getUnspecifiedNHjbRc();

    public BoundsTransformDeferredAnimation() {
        MutableState mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.animatedValue = mutableStateOf$default;
        this.additionalOffset = Offset.INSTANCE.m4609getZeroF1C5BW0();
    }

    /* renamed from: updateTargetSize-uvyYCjk, reason: not valid java name */
    public final void m189updateTargetSizeuvyYCjk(long size) {
        if ((this.targetSize != InlineClassHelperKt.UnspecifiedPackedFloats) && !IntSize.equals-impl0(IntSizeKt.roundToIntSize-uvyYCjk(size), IntSizeKt.roundToIntSize-uvyYCjk(this.targetSize))) {
            this.isPending = true;
        }
        this.targetSize = size;
        if (this.currentSize == InlineClassHelperKt.UnspecifiedPackedFloats) {
            this.currentSize = size;
        }
    }

    /* renamed from: updateTargetOffset-k-4lQ0M, reason: not valid java name */
    private final void m185updateTargetOffsetk4lQ0M(long offset) {
        if (((this.targetOffset & 9223372034707292159L) != InlineClassHelperKt.UnspecifiedPackedFloats) && !IntOffset.equals-impl0(IntOffsetKt.round-k-4lQ0M(offset), IntOffsetKt.round-k-4lQ0M(this.targetOffset))) {
            this.isPending = true;
        }
        this.targetOffset = offset;
        if ((9223372034707292159L & this.currentPosition) == InlineClassHelperKt.UnspecifiedPackedFloats) {
            this.currentPosition = offset;
        }
    }

    /* renamed from: getCurrentSize-NH-jbRc, reason: not valid java name and from getter */
    public final long getCurrentSize() {
        return this.currentSize;
    }

    /* renamed from: setCurrentSize-uvyYCjk, reason: not valid java name */
    public final void m187setCurrentSizeuvyYCjk(long j) {
        this.currentSize = j;
    }

    public final Rect getCurrentBounds() {
        long j = this.currentSize;
        long j2 = this.currentPosition;
        if ((9223372034707292159L & j2) != InlineClassHelperKt.UnspecifiedPackedFloats) {
            if (j != InlineClassHelperKt.UnspecifiedPackedFloats) {
                return RectKt.m4633Recttz77jQw(j2, j);
            }
        }
        return null;
    }

    /* renamed from: updateCurrentBounds-tz77jQw, reason: not valid java name */
    public final void m188updateCurrentBoundstz77jQw(long position, long size) {
        this.currentPosition = position;
        this.currentSize = size;
    }

    public final boolean isIdle() {
        if (this.isPending) {
            return false;
        }
        Animatable<Rect, AnimationVector4D> animatable = this.animatable;
        return !(animatable != null && animatable.isRunning());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Rect getAnimatedValue() {
        return (Rect) this.animatedValue.getValue();
    }

    private final void setAnimatedValue(Rect rect) {
        this.animatedValue.setValue(rect);
    }

    public final Rect getValue() {
        if (isIdle()) {
            return null;
        }
        return getAnimatedValue();
    }

    public final void updateTargetOffsetAndAnimate(LookaheadScope lookaheadScope, Placeable.PlacementScope placementScope, CoroutineScope coroutineScope, boolean directManipulationParentsDirty, boolean includeMotionFrameOfReference, BoundsTransform boundsTransform) {
        LayoutCoordinates coordinates = placementScope.getCoordinates();
        if (coordinates != null) {
            LayoutCoordinates lookaheadScopeCoordinates = lookaheadScope.getLookaheadScopeCoordinates(placementScope);
            long m4609getZeroF1C5BW0 = Offset.INSTANCE.m4609getZeroF1C5BW0();
            if (!includeMotionFrameOfReference && directManipulationParentsDirty) {
                ArrayList arrayList = this.directManipulationParents;
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                int i = 0;
                LayoutCoordinates layoutCoordinates = coordinates;
                while (!Intrinsics.areEqual(lookaheadScope.toLookaheadCoordinates(layoutCoordinates), lookaheadScopeCoordinates)) {
                    if (layoutCoordinates.getIntroducesMotionFrameOfReference()) {
                        if (arrayList.size() == i) {
                            arrayList.add(layoutCoordinates);
                            m4609getZeroF1C5BW0 = Offset.m4598plusMKHz9U(m4609getZeroF1C5BW0, LayoutCoordinatesKt.positionInParent(layoutCoordinates));
                        } else if (!Intrinsics.areEqual(arrayList.get(i), layoutCoordinates)) {
                            long m4597minusMKHz9U = Offset.m4597minusMKHz9U(m4609getZeroF1C5BW0, LayoutCoordinatesKt.positionInParent(arrayList.get(i)));
                            arrayList.set(i, layoutCoordinates);
                            m4609getZeroF1C5BW0 = Offset.m4598plusMKHz9U(m4597minusMKHz9U, LayoutCoordinatesKt.positionInParent(layoutCoordinates));
                        }
                        i++;
                    }
                    layoutCoordinates = layoutCoordinates.getParentCoordinates();
                    if (layoutCoordinates == null) {
                        break;
                    }
                }
                int size = arrayList.size() - 1;
                if (i <= size) {
                    while (true) {
                        m4609getZeroF1C5BW0 = Offset.m4597minusMKHz9U(m4609getZeroF1C5BW0, LayoutCoordinatesKt.positionInParent(arrayList.get(size)));
                        arrayList.remove(arrayList.size() - 1);
                        if (size == i) {
                            break;
                        } else {
                            size--;
                        }
                    }
                }
                this.directManipulationParents = arrayList;
            }
            this.additionalOffset = Offset.m4598plusMKHz9U(this.additionalOffset, m4609getZeroF1C5BW0);
            m185updateTargetOffsetk4lQ0M(Offset.m4598plusMKHz9U(LookaheadScope.m6377localLookaheadPositionOfauaQtc$default(lookaheadScope, lookaheadScopeCoordinates, coordinates, 0L, includeMotionFrameOfReference, 2, null), this.additionalOffset));
            setAnimatedValue(animate(coroutineScope, boundsTransform).m4630translatek4lQ0M(Offset.m4585constructorimpl(this.additionalOffset ^ (-9223372034707292160L))));
        }
    }

    private final Rect animate(CoroutineScope coroutineScope, BoundsTransform boundsTransform) {
        Rect value;
        long j = this.targetOffset;
        if ((9223372034707292159L & j) != InlineClassHelperKt.UnspecifiedPackedFloats) {
            long j2 = this.targetSize;
            if (j2 != InlineClassHelperKt.UnspecifiedPackedFloats) {
                Rect m4633Recttz77jQw = RectKt.m4633Recttz77jQw(j, j2);
                Animatable<Rect, AnimationVector4D> animatable = this.animatable;
                if (animatable == null) {
                    animatable = new Animatable<>(m4633Recttz77jQw, VectorConvertersKt.getVectorConverter(Rect.INSTANCE), null, null, 12, null);
                }
                Animatable<Rect, AnimationVector4D> animatable2 = animatable;
                this.animatable = animatable2;
                if (this.isPending) {
                    this.isPending = false;
                    BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, CoroutineStart.UNDISPATCHED, new BoundsTransformDeferredAnimation$animate$1(animatable2, m4633Recttz77jQw, boundsTransform, this, null), 1, (Object) null);
                }
            }
        }
        Animatable<Rect, AnimationVector4D> animatable3 = this.animatable;
        return (animatable3 == null || (value = animatable3.getValue()) == null) ? Rect.INSTANCE.getZero() : value;
    }
}
