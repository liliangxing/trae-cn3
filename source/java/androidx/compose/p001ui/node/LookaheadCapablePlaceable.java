package androidx.compose.p001ui.node;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterMap;
import androidx.collection.ScatterSet;
import androidx.compose.p001ui.node.LayoutNode;
import androidx.compose.p001ui.node.LookaheadCapablePlaceable;
import androidx.compose.p001ui.unit.IntOffset;
import androidx.compose.p001ui.unit.IntOffsetKt;
import androidx.compose.p001ui.unit.IntSize;
import androidx.compose.p001ui.unit.LayoutDirection;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.PlaceableKt;
import androidx.compose.ui.layout.Ruler;
import androidx.compose.ui.layout.RulerScope;
import androidx.compose.ui.layout.VerticalAlignmentLine;
import androidx.compose.ui.layout.VerticalRuler;
import androidx.core.view.ViewCompat;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LookaheadDelegate.kt */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\b!\u0018\u0000 p2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002opB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010'\u001a\u00020 2\u0006\u0010(\u001a\u00020\u0010H\u0016J\u0011\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0086\u0002J\u0010\u00100\u001a\u00020-2\u0006\u0010.\u001a\u00020/H&J\r\u00108\u001a\u00020 H ¢\u0006\u0002\b9J\f\u0010E\u001a\u00020 *\u00020FH\u0004J\u0016\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020L2\u0006\u0010R\u001a\u00020PJ\u0018\u0010S\u001a\u00020 2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010Q\u001a\u00020LH\u0002J\u0010\u0010T\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020LH\u0002J\u0014\u0010U\u001a\u00020\u0010*\u00020\u00142\u0006\u0010V\u001a\u00020\u0014H\u0002J\u0015\u0010W\u001a\u00020 2\u0006\u0010Q\u001a\u00020LH\u0000¢\u0006\u0002\bXJ`\u0010Y\u001a\u0002052\u0006\u0010Z\u001a\u00020-2\u0006\u0010[\u001a\u00020-2\u0012\u0010\\\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020-0]2\u0019\u0010^\u001a\u0015\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 \u0018\u00010\u001e¢\u0006\u0002\b!2\u0017\u0010_\u001a\u0013\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020 0\u001e¢\u0006\u0002\b!H\u0016J\u0017\u0010`\u001a\u00020 2\b\u0010a\u001a\u0004\u0018\u000105H\u0000¢\u0006\u0002\bbJ+\u0010c\u001a\u00020 2\u0006\u0010d\u001a\u00020#2\b\b\u0002\u0010e\u001a\u00020\u00072\b\b\u0002\u0010f\u001a\u00020gH\u0002¢\u0006\u0004\bh\u0010iJ\u0010\u0010`\u001a\u00020 2\u0006\u0010d\u001a\u00020#H\u0002J\u001c\u0010j\u001a\u00020 2\u0012\u0010k\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140N0MH\u0002J\u0016\u0010l\u001a\u00020 2\u0006\u0010Q\u001a\u00020L2\u0006\u0010m\u001a\u00020PJ\u0016\u0010n\u001a\u00020 2\u0006\u0010Q\u001a\u00020L2\u0006\u0010m\u001a\u00020PR\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u0004\u0018\u00010\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u00020\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0017\u001a\u00020\u0018X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\b\u0018\u00010\u001cR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\u001d\u001a\u0015\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 \u0018\u00010\u001e¢\u0006\u0002\b!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u00020\u0010X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0012\"\u0004\b%\u0010&R\u0018\u0010)\u001a\u00060\u001cR\u00020\u00008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u001a\u00101\u001a\u00020\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0012\"\u0004\b3\u0010&R\u0012\u00104\u001a\u000205X \u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u0012\u0010:\u001a\u00020;X¦\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=R\u001a\u0010>\u001a\u00020\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0012\"\u0004\b@\u0010&R\u0011\u0010A\u001a\u00020B¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0014\u0010G\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bG\u0010\u0012R\u0010\u0010H\u001a\u0004\u0018\u00010IX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010J\u001a\u001c\u0012\u0004\u0012\u00020L\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140N0M\u0018\u00010KX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006q"}, d2 = {"Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "Landroidx/compose/ui/layout/Placeable;", "Landroidx/compose/ui/node/MeasureScopeWithLayoutNode;", "Landroidx/compose/ui/node/MotionReferencePlacementDelegate;", "<init>", "()V", "position", "Landroidx/compose/ui/unit/IntOffset;", "getPosition-nOcc-ac", "()J", "child", "getChild", "()Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "parent", "getParent", "hasMeasureResult", "", "getHasMeasureResult", "()Z", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "_rulerScope", "Landroidx/compose/ui/node/LookaheadCapablePlaceable$ResettableRulerScope;", "rulersLambda", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/RulerScope;", "", "Lkotlin/ExtensionFunctionType;", "cachedRulerPlaceableResult", "Landroidx/compose/ui/node/PlaceableResult;", "isPlacedUnderMotionFrameOfReference", "setPlacedUnderMotionFrameOfReference", "(Z)V", "updatePlacedUnderMotionFrameOfReference", "newMFR", "rulerScope", "getRulerScope", "()Landroidx/compose/ui/node/LookaheadCapablePlaceable$ResettableRulerScope;", "get", "", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "calculateAlignmentLine", "isShallowPlacing", "isShallowPlacing$ui_release", "setShallowPlacing$ui_release", "measureResult", "Landroidx/compose/ui/layout/MeasureResult;", "getMeasureResult$ui_release", "()Landroidx/compose/ui/layout/MeasureResult;", "replace", "replace$ui_release", "alignmentLinesOwner", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "getAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "isPlacingForAlignment", "isPlacingForAlignment$ui_release", "setPlacingForAlignment$ui_release", "placementScope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "getPlacementScope", "()Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invalidateAlignmentLinesFromPositionChange", "Landroidx/compose/ui/node/NodeCoordinator;", "isLookingAhead", "rulerValues", "Landroidx/compose/ui/node/RulerTrackingMap;", "rulerReaders", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/ui/layout/Ruler;", "Landroidx/collection/MutableScatterSet;", "Landroidx/compose/ui/node/WeakReference;", "findRulerValue", "", "ruler", "defaultValue", "addRulerReader", "findAncestorRulerDefiner", "isLayoutNodeAncestor", "ancestor", "invalidateChildrenOfDefiningRuler", "invalidateChildrenOfDefiningRuler$ui_release", "layout", "width", "height", "alignmentLines", "", "rulers", "placementBlock", "captureRulersIfNeeded", StrategyConstants.RESULT, "captureRulersIfNeeded$ui_release", "captureRulers", "placeableResult", "positionOnScreen", "size", "Landroidx/compose/ui/unit/IntSize;", "captureRulers-OSxE8f4", "(Landroidx/compose/ui/node/PlaceableResult;JJ)V", "notifyRulerValueChange", "layoutNodes", "provideRulerValue", StrategyConstants.VALUE, "provideRelativeRulerValue", "ResettableRulerScope", "Companion", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public abstract class LookaheadCapablePlaceable extends Placeable implements MeasureScopeWithLayoutNode, MotionReferencePlacementDelegate {
    public static final int $stable = 0;
    private static final Function1<PlaceableResult, Unit> onCommitAffectingRuler = new Function1<PlaceableResult, Unit>() { // from class: androidx.compose.ui.node.LookaheadCapablePlaceable$Companion$onCommitAffectingRuler$1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((PlaceableResult) obj);
            return Unit.INSTANCE;
        }

        public final void invoke(PlaceableResult placeableResult) {
            if (placeableResult.isValidOwnerScope()) {
                placeableResult.getPlaceable().captureRulersIfNeeded(placeableResult);
            }
        }
    };
    private ResettableRulerScope _rulerScope;
    private PlaceableResult cachedRulerPlaceableResult;
    private boolean isPlacedUnderMotionFrameOfReference;
    private boolean isPlacingForAlignment;
    private boolean isShallowPlacing;
    private final Placeable.PlacementScope placementScope = PlaceableKt.PlacementScope(this);
    private MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> rulerReaders;
    private RulerTrackingMap rulerValues;
    private Function1<? super RulerScope, Unit> rulersLambda;

    public abstract int calculateAlignmentLine(AlignmentLine alignmentLine);

    public abstract AlignmentLinesOwner getAlignmentLinesOwner();

    public abstract LookaheadCapablePlaceable getChild();

    public abstract LayoutCoordinates getCoordinates();

    public abstract boolean getHasMeasureResult();

    @Override // androidx.compose.p001ui.node.MeasureScopeWithLayoutNode
    public abstract LayoutNode getLayoutNode();

    public abstract MeasureResult getMeasureResult$ui_release();

    public abstract LookaheadCapablePlaceable getParent();

    /* renamed from: getPosition-nOcc-ac, reason: not valid java name */
    public abstract long getPosition();

    public boolean isLookingAhead() {
        return false;
    }

    public abstract void replace$ui_release();

    @Override // androidx.compose.p001ui.node.MotionReferencePlacementDelegate
    /* renamed from: isPlacedUnderMotionFrameOfReference, reason: from getter */
    public boolean getIsPlacedUnderMotionFrameOfReference() {
        return this.isPlacedUnderMotionFrameOfReference;
    }

    public void setPlacedUnderMotionFrameOfReference(boolean z) {
        this.isPlacedUnderMotionFrameOfReference = z;
    }

    @Override // androidx.compose.p001ui.node.MotionReferencePlacementDelegate
    public void updatePlacedUnderMotionFrameOfReference(boolean newMFR) {
        LookaheadCapablePlaceable parent = getParent();
        LayoutNode layoutNode = parent != null ? parent.getLayoutNode() : null;
        if (Intrinsics.areEqual(layoutNode, getLayoutNode())) {
            setPlacedUnderMotionFrameOfReference(newMFR);
            return;
        }
        if ((layoutNode != null ? layoutNode.getLayoutState$ui_release() : null) != LayoutNode.LayoutState.LayingOut) {
            if ((layoutNode != null ? layoutNode.getLayoutState$ui_release() : null) != LayoutNode.LayoutState.LookaheadLayingOut) {
                return;
            }
        }
        setPlacedUnderMotionFrameOfReference(newMFR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ResettableRulerScope getRulerScope() {
        ResettableRulerScope resettableRulerScope = this._rulerScope;
        if (resettableRulerScope != null) {
            return resettableRulerScope;
        }
        ResettableRulerScope resettableRulerScope2 = new ResettableRulerScope();
        this._rulerScope = resettableRulerScope2;
        return resettableRulerScope2;
    }

    public final int get(AlignmentLine alignmentLine) {
        int calculateAlignmentLine;
        int m2809getYimpl;
        if (!getHasMeasureResult() || (calculateAlignmentLine = calculateAlignmentLine(alignmentLine)) == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        if (alignmentLine instanceof VerticalAlignmentLine) {
            m2809getYimpl = IntOffset.m2808getXimpl(getApparentToRealOffset-nOcc-ac());
        } else {
            m2809getYimpl = IntOffset.m2809getYimpl(getApparentToRealOffset-nOcc-ac());
        }
        return calculateAlignmentLine + m2809getYimpl;
    }

    /* renamed from: isShallowPlacing$ui_release, reason: from getter */
    public final boolean getIsShallowPlacing() {
        return this.isShallowPlacing;
    }

    public final void setShallowPlacing$ui_release(boolean z) {
        this.isShallowPlacing = z;
    }

    /* renamed from: isPlacingForAlignment$ui_release, reason: from getter */
    public final boolean getIsPlacingForAlignment() {
        return this.isPlacingForAlignment;
    }

    public final void setPlacingForAlignment$ui_release(boolean z) {
        this.isPlacingForAlignment = z;
    }

    public final Placeable.PlacementScope getPlacementScope() {
        return this.placementScope;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void invalidateAlignmentLinesFromPositionChange(NodeCoordinator nodeCoordinator) {
        AlignmentLines alignmentLines;
        NodeCoordinator wrapped = nodeCoordinator.getWrapped();
        if (!Intrinsics.areEqual(wrapped != null ? wrapped.getLayoutNode() : null, nodeCoordinator.getLayoutNode())) {
            nodeCoordinator.getAlignmentLinesOwner().getAlignmentLines().onAlignmentsChanged();
            return;
        }
        AlignmentLinesOwner parentAlignmentLinesOwner = nodeCoordinator.getAlignmentLinesOwner().getParentAlignmentLinesOwner();
        if (parentAlignmentLinesOwner == null || (alignmentLines = parentAlignmentLinesOwner.getAlignmentLines()) == null) {
            return;
        }
        alignmentLines.onAlignmentsChanged();
    }

    public final float findRulerValue(Ruler ruler, float defaultValue) {
        if (this.isPlacingForAlignment) {
            return defaultValue;
        }
        LookaheadCapablePlaceable lookaheadCapablePlaceable = this;
        while (true) {
            RulerTrackingMap rulerTrackingMap = lookaheadCapablePlaceable.rulerValues;
            float orDefault = rulerTrackingMap != null ? rulerTrackingMap.getOrDefault(ruler, Float.NaN) : Float.NaN;
            if (!Float.isNaN(orDefault)) {
                lookaheadCapablePlaceable.addRulerReader(getLayoutNode(), ruler);
                return ruler.calculateCoordinate$ui_release(orDefault, lookaheadCapablePlaceable.getCoordinates(), getCoordinates());
            }
            LookaheadCapablePlaceable parent = lookaheadCapablePlaceable.getParent();
            if (parent == null) {
                lookaheadCapablePlaceable.addRulerReader(getLayoutNode(), ruler);
                return defaultValue;
            }
            lookaheadCapablePlaceable = parent;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ba A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void addRulerReader(LayoutNode layoutNode, Ruler ruler) {
        int i;
        int i2;
        long[] jArr;
        Object[] objArr;
        long[] jArr2;
        Object[] objArr2;
        int i3;
        int i4;
        Object[] objArr3;
        long[] jArr3;
        Object[] objArr4;
        long[] jArr4;
        boolean z;
        ScatterMap scatterMap = this.rulerReaders;
        long j = 255;
        char c = 7;
        long j2 = -9187201950435737472L;
        int i5 = 8;
        if (scatterMap != null) {
            ScatterMap scatterMap2 = scatterMap;
            Object[] objArr5 = scatterMap2.values;
            long[] jArr5 = scatterMap2.metadata;
            int length = jArr5.length - 2;
            if (length >= 0) {
                int i6 = 0;
                while (true) {
                    long j3 = jArr5[i6];
                    if ((((~j3) << c) & j3 & j2) != j2) {
                        int i7 = 8 - ((~(i6 - length)) >>> 31);
                        int i8 = 0;
                        while (i8 < i7) {
                            if ((j3 & j) < 128) {
                                ScatterSet scatterSet = (MutableScatterSet) objArr5[(i6 << 3) + i8];
                                Object[] objArr6 = ((MutableScatterSet) scatterSet).elements;
                                long[] jArr6 = scatterSet.metadata;
                                int length2 = jArr6.length - 2;
                                jArr2 = jArr5;
                                if (length2 >= 0) {
                                    int i9 = 0;
                                    while (true) {
                                        long j4 = jArr6[i9];
                                        objArr2 = objArr5;
                                        i3 = length;
                                        if ((((~j4) << c) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                                            int i10 = 8 - ((~(i9 - length2)) >>> 31);
                                            int i11 = 0;
                                            while (i11 < i10) {
                                                if ((j4 & 255) < 128) {
                                                    int i12 = (i9 << 3) + i11;
                                                    LayoutNode layoutNode2 = (LayoutNode) ((WeakReference) objArr6[i12]).get();
                                                    objArr4 = objArr6;
                                                    if (layoutNode2 != null) {
                                                        boolean isAttached = layoutNode2.isAttached();
                                                        jArr4 = jArr6;
                                                        if (isAttached) {
                                                            z = true;
                                                            if (!(!z)) {
                                                                scatterSet.removeElementAt(i12);
                                                            }
                                                        }
                                                    } else {
                                                        jArr4 = jArr6;
                                                    }
                                                    z = false;
                                                    if (!(!z)) {
                                                    }
                                                } else {
                                                    objArr4 = objArr6;
                                                    jArr4 = jArr6;
                                                }
                                                j4 >>= 8;
                                                i11++;
                                                jArr6 = jArr4;
                                                objArr6 = objArr4;
                                            }
                                            objArr3 = objArr6;
                                            jArr3 = jArr6;
                                            if (i10 != 8) {
                                                break;
                                            }
                                        } else {
                                            objArr3 = objArr6;
                                            jArr3 = jArr6;
                                        }
                                        if (i9 == length2) {
                                            break;
                                        }
                                        i9++;
                                        objArr5 = objArr2;
                                        length = i3;
                                        jArr6 = jArr3;
                                        objArr6 = objArr3;
                                        c = 7;
                                    }
                                } else {
                                    objArr2 = objArr5;
                                    i3 = length;
                                }
                                i4 = 8;
                            } else {
                                jArr2 = jArr5;
                                objArr2 = objArr5;
                                i3 = length;
                                i4 = i5;
                            }
                            j3 >>= i4;
                            i8++;
                            i5 = i4;
                            jArr5 = jArr2;
                            objArr5 = objArr2;
                            length = i3;
                            j = 255;
                            c = 7;
                        }
                        jArr = jArr5;
                        objArr = objArr5;
                        int i13 = length;
                        if (i7 != i5) {
                            break;
                        } else {
                            length = i13;
                        }
                    } else {
                        jArr = jArr5;
                        objArr = objArr5;
                    }
                    if (i6 == length) {
                        break;
                    }
                    i6++;
                    jArr5 = jArr;
                    objArr5 = objArr;
                    j = 255;
                    c = 7;
                    j2 = -9187201950435737472L;
                    i5 = 8;
                }
            }
        }
        ScatterMap scatterMap3 = this.rulerReaders;
        if (scatterMap3 != null) {
            long[] jArr7 = scatterMap3.metadata;
            int length3 = jArr7.length - 2;
            if (length3 >= 0) {
                int i14 = 0;
                while (true) {
                    long j5 = jArr7[i14];
                    if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i15 = 8 - ((~(i14 - length3)) >>> 31);
                        for (int i16 = 0; i16 < i15; i16++) {
                            if ((j5 & 255) < 128) {
                                int i17 = (i14 << 3) + i16;
                                if (((MutableScatterSet) ((MutableScatterMap) scatterMap3).values[i17]).isEmpty()) {
                                    scatterMap3.removeValueAt(i17);
                                }
                            }
                            j5 >>= 8;
                        }
                        if (i15 != 8) {
                            break;
                        }
                    }
                    if (i14 == length3) {
                        break;
                    } else {
                        i14++;
                    }
                }
            }
        }
        MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> mutableScatterMap = this.rulerReaders;
        if (mutableScatterMap == null) {
            i = 0;
            i2 = 1;
            mutableScatterMap = new MutableScatterMap<>(0, 1, (DefaultConstructorMarker) null);
            this.rulerReaders = mutableScatterMap;
        } else {
            i = 0;
            i2 = 1;
        }
        Object obj = mutableScatterMap.get(ruler);
        if (obj == null) {
            obj = new MutableScatterSet(i, i2, (DefaultConstructorMarker) null);
            mutableScatterMap.set(ruler, obj);
        }
        ((MutableScatterSet) obj).plusAssign(new WeakReference(layoutNode));
    }

    private final LookaheadCapablePlaceable findAncestorRulerDefiner(Ruler ruler) {
        LookaheadCapablePlaceable parent;
        LookaheadCapablePlaceable lookaheadCapablePlaceable = this;
        while (true) {
            RulerTrackingMap rulerTrackingMap = lookaheadCapablePlaceable.rulerValues;
            boolean z = false;
            if (rulerTrackingMap != null && rulerTrackingMap.contains(ruler)) {
                z = true;
            }
            if (z || (parent = lookaheadCapablePlaceable.getParent()) == null) {
                return lookaheadCapablePlaceable;
            }
            lookaheadCapablePlaceable = parent;
        }
    }

    private final boolean isLayoutNodeAncestor(LayoutNode layoutNode, LayoutNode layoutNode2) {
        if (layoutNode == layoutNode2) {
            return true;
        }
        LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
        if (parent$ui_release != null) {
            return isLayoutNodeAncestor(parent$ui_release, layoutNode2);
        }
        return false;
    }

    public final void invalidateChildrenOfDefiningRuler$ui_release(Ruler ruler) {
        MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> mutableScatterMap = findAncestorRulerDefiner(ruler).rulerReaders;
        MutableScatterSet<WeakReference<LayoutNode>> mutableScatterSet = mutableScatterMap != null ? (MutableScatterSet) mutableScatterMap.remove(ruler) : null;
        if (mutableScatterSet != null) {
            notifyRulerValueChange(mutableScatterSet);
        }
    }

    public final void captureRulersIfNeeded$ui_release(MeasureResult result) {
        long j;
        ScatterMap scatterMap = this.rulerReaders;
        long j2 = 255;
        char c = 7;
        if (result != null) {
            if (this.isPlacingForAlignment) {
                return;
            }
            Function1<? super RulerScope, Unit> rulers = result.getRulers();
            if (rulers != null) {
                boolean z = this.rulersLambda != rulers;
                long m2818getMaxnOccac = IntOffset.INSTANCE.m2818getMaxnOccac();
                long m2856getZeroYbymL2g = IntSize.INSTANCE.m2856getZeroYbymL2g();
                if (z || !getRulerScope().getCoordinatesAccessed()) {
                    j = m2856getZeroYbymL2g;
                } else {
                    LayoutCoordinates coordinates = getCoordinates();
                    m2818getMaxnOccac = IntOffsetKt.m2825roundk4lQ0M(LayoutCoordinatesKt.positionOnScreen(coordinates));
                    long j3 = coordinates.getSize-YbymL2g();
                    j = j3;
                    z = (IntOffset.m2807equalsimpl0(m2818getMaxnOccac, getRulerScope().getPositionOnScreen()) && IntSize.m2849equalsimpl0(j3, getRulerScope().getSize())) ? false : true;
                }
                long j4 = m2818getMaxnOccac;
                if (z) {
                    PlaceableResult placeableResult = this.cachedRulerPlaceableResult;
                    if (placeableResult != null) {
                        placeableResult.setResult(result);
                    } else {
                        placeableResult = new PlaceableResult(result, this);
                        this.cachedRulerPlaceableResult = placeableResult;
                    }
                    m1460captureRulersOSxE8f4(placeableResult, j4, j);
                    this.rulersLambda = result.getRulers();
                    return;
                }
                return;
            }
            if (scatterMap != null) {
                ScatterMap scatterMap2 = scatterMap;
                Object[] objArr = scatterMap2.values;
                long[] jArr = scatterMap2.metadata;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i = 0;
                    while (true) {
                        long j5 = jArr[i];
                        if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i2 = 8 - ((~(i - length)) >>> 31);
                            int i3 = 0;
                            while (i3 < i2) {
                                if ((j5 & j2) < 128) {
                                    notifyRulerValueChange((MutableScatterSet) objArr[(i << 3) + i3]);
                                }
                                j5 >>= 8;
                                i3++;
                                j2 = 255;
                            }
                            if (i2 != 8) {
                                break;
                            }
                        }
                        if (i == length) {
                            break;
                        }
                        i++;
                        j2 = 255;
                    }
                }
                scatterMap.clear();
                return;
            }
            return;
        }
        if (scatterMap != null) {
            ScatterMap scatterMap3 = scatterMap;
            Object[] objArr2 = scatterMap3.values;
            long[] jArr2 = scatterMap3.metadata;
            int length2 = jArr2.length - 2;
            if (length2 >= 0) {
                int i4 = 0;
                while (true) {
                    long j6 = jArr2[i4];
                    if ((((~j6) << c) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i5 = 8 - ((~(i4 - length2)) >>> 31);
                        for (int i6 = 0; i6 < i5; i6++) {
                            if ((j6 & 255) < 128) {
                                notifyRulerValueChange((MutableScatterSet) objArr2[(i4 << 3) + i6]);
                            }
                            j6 >>= 8;
                        }
                        if (i5 != 8) {
                            break;
                        }
                    }
                    if (i4 == length2) {
                        break;
                    }
                    i4++;
                    c = 7;
                }
            }
        }
        if (scatterMap != null) {
            scatterMap.clear();
        }
        RulerTrackingMap rulerTrackingMap = this.rulerValues;
        if (rulerTrackingMap != null) {
            rulerTrackingMap.clear();
        }
    }

    /* renamed from: captureRulers-OSxE8f4$default, reason: not valid java name */
    static /* synthetic */ void m1461captureRulersOSxE8f4$default(LookaheadCapablePlaceable lookaheadCapablePlaceable, PlaceableResult placeableResult, long j, long j2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: captureRulers-OSxE8f4");
        }
        if ((i & 2) != 0) {
            j = IntOffset.INSTANCE.m2818getMaxnOccac();
        }
        long j3 = j;
        if ((i & 4) != 0) {
            j2 = IntSize.INSTANCE.m2856getZeroYbymL2g();
        }
        lookaheadCapablePlaceable.m1460captureRulersOSxE8f4(placeableResult, j3, j2);
    }

    /* renamed from: captureRulers-OSxE8f4, reason: not valid java name */
    private final void m1460captureRulersOSxE8f4(final PlaceableResult placeableResult, final long positionOnScreen, final long size) {
        OwnerSnapshotObserver snapshotObserver;
        MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> mutableScatterMap = this.rulerReaders;
        RulerTrackingMap rulerTrackingMap = this.rulerValues;
        if (rulerTrackingMap == null) {
            rulerTrackingMap = new RulerTrackingMap();
            this.rulerValues = rulerTrackingMap;
        }
        RulerTrackingMap rulerTrackingMap2 = rulerTrackingMap;
        Owner owner = getLayoutNode().getOwner();
        if (owner != null && (snapshotObserver = owner.getSnapshotObserver()) != null) {
            snapshotObserver.observeReads$ui_release(placeableResult, onCommitAffectingRuler, new Function0<Unit>() { // from class: androidx.compose.ui.node.LookaheadCapablePlaceable$captureRulers$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m1467invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m1467invoke() {
                    LookaheadCapablePlaceable.ResettableRulerScope rulerScope;
                    LookaheadCapablePlaceable.ResettableRulerScope rulerScope2;
                    LookaheadCapablePlaceable.ResettableRulerScope rulerScope3;
                    LookaheadCapablePlaceable.ResettableRulerScope rulerScope4;
                    rulerScope = LookaheadCapablePlaceable.this.getRulerScope();
                    rulerScope.setCoordinatesAccessed(false);
                    rulerScope2 = LookaheadCapablePlaceable.this.getRulerScope();
                    rulerScope2.m1465setPositionOnScreengyyYBs(positionOnScreen);
                    rulerScope3 = LookaheadCapablePlaceable.this.getRulerScope();
                    rulerScope3.m1466setSizeozmzZPI(size);
                    Function1 rulers = placeableResult.getResult().getRulers();
                    if (rulers != null) {
                        rulerScope4 = LookaheadCapablePlaceable.this.getRulerScope();
                        rulers.invoke(rulerScope4);
                    }
                }
            });
        }
        rulerTrackingMap2.notifyChanged(isLookingAhead(), this, mutableScatterMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void captureRulersIfNeeded(PlaceableResult placeableResult) {
        if (this.isPlacingForAlignment) {
            return;
        }
        Function1<? super RulerScope, Unit> rulers = placeableResult.getResult().getRulers();
        ScatterMap scatterMap = this.rulerReaders;
        if (rulers != null) {
            m1461captureRulersOSxE8f4$default(this, placeableResult, 0L, 0L, 6, null);
            this.rulersLambda = rulers;
            return;
        }
        if (scatterMap != null) {
            ScatterMap scatterMap2 = scatterMap;
            Object[] objArr = scatterMap2.values;
            long[] jArr = scatterMap2.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i = 0;
                while (true) {
                    long j = jArr[i];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i2 = 8 - ((~(i - length)) >>> 31);
                        for (int i3 = 0; i3 < i2; i3++) {
                            if ((255 & j) < 128) {
                                notifyRulerValueChange((MutableScatterSet) objArr[(i << 3) + i3]);
                            }
                            j >>= 8;
                        }
                        if (i2 != 8) {
                            break;
                        }
                    }
                    if (i == length) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
            scatterMap.clear();
        }
    }

    private final void notifyRulerValueChange(MutableScatterSet<WeakReference<LayoutNode>> layoutNodes) {
        LayoutNode layoutNode;
        ScatterSet scatterSet = (ScatterSet) layoutNodes;
        Object[] objArr = scatterSet.elements;
        long[] jArr = scatterSet.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if (((255 & j) < 128) && (layoutNode = (LayoutNode) ((WeakReference) objArr[(i << 3) + i3]).get()) != null) {
                        if (isLookingAhead()) {
                            layoutNode.requestLookaheadRelayout$ui_release(false);
                        } else {
                            layoutNode.requestRelayout$ui_release(false);
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    public final void provideRulerValue(Ruler ruler, float value) {
        RulerTrackingMap rulerTrackingMap = this.rulerValues;
        if (rulerTrackingMap == null) {
            rulerTrackingMap = new RulerTrackingMap();
            this.rulerValues = rulerTrackingMap;
        }
        rulerTrackingMap.set(ruler, value);
    }

    public final void provideRelativeRulerValue(Ruler ruler, float value) {
        RulerTrackingMap rulerTrackingMap = this.rulerValues;
        if (rulerTrackingMap == null) {
            rulerTrackingMap = new RulerTrackingMap();
            this.rulerValues = rulerTrackingMap;
        }
        if (getLayoutDirection() != LayoutDirection.Ltr) {
            value = getWidth() - value;
        }
        rulerTrackingMap.set(ruler, value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LookaheadDelegate.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0019\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0096\u0004J\u0015\u0010\u001e\u001a\u00020\u001a*\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0096\u0004R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000fR\u0014\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010 \u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\"¨\u0006%"}, d2 = {"Landroidx/compose/ui/node/LookaheadCapablePlaceable$ResettableRulerScope;", "Landroidx/compose/ui/layout/RulerScope;", "<init>", "(Landroidx/compose/ui/node/LookaheadCapablePlaceable;)V", "coordinatesAccessed", "", "getCoordinatesAccessed", "()Z", "setCoordinatesAccessed", "(Z)V", "positionOnScreen", "Landroidx/compose/ui/unit/IntOffset;", "getPositionOnScreen-nOcc-ac", "()J", "setPositionOnScreen--gyyYBs", "(J)V", "J", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "setSize-ozmzZPI", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "provides", "", "Landroidx/compose/ui/layout/Ruler;", StrategyConstants.VALUE, "", "providesRelative", "Landroidx/compose/ui/layout/VerticalRuler;", "density", "getDensity", "()F", "fontScale", "getFontScale", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public final class ResettableRulerScope implements RulerScope {
        private boolean coordinatesAccessed;
        private long positionOnScreen = IntOffset.INSTANCE.m2818getMaxnOccac();
        private long size = IntSize.INSTANCE.m2856getZeroYbymL2g();

        public ResettableRulerScope() {
        }

        public final boolean getCoordinatesAccessed() {
            return this.coordinatesAccessed;
        }

        public final void setCoordinatesAccessed(boolean z) {
            this.coordinatesAccessed = z;
        }

        /* renamed from: getPositionOnScreen-nOcc-ac, reason: not valid java name and from getter */
        public final long getPositionOnScreen() {
            return this.positionOnScreen;
        }

        /* renamed from: setPositionOnScreen--gyyYBs, reason: not valid java name */
        public final void m1465setPositionOnScreengyyYBs(long j) {
            this.positionOnScreen = j;
        }

        /* renamed from: getSize-YbymL2g, reason: not valid java name and from getter */
        public final long getSize() {
            return this.size;
        }

        /* renamed from: setSize-ozmzZPI, reason: not valid java name */
        public final void m1466setSizeozmzZPI(long j) {
            this.size = j;
        }

        public LayoutCoordinates getCoordinates() {
            this.coordinatesAccessed = true;
            LayoutCoordinates coordinates = LookaheadCapablePlaceable.this.getCoordinates();
            if (IntOffset.m2807equalsimpl0(this.positionOnScreen, IntOffset.INSTANCE.m2818getMaxnOccac())) {
                this.positionOnScreen = IntOffsetKt.m2825roundk4lQ0M(LayoutCoordinatesKt.positionOnScreen(coordinates));
                this.size = coordinates.getSize-YbymL2g();
            }
            LookaheadCapablePlaceable.this.getLayoutNode().getLayoutDelegate().onCoordinatesUsed();
            return coordinates;
        }

        public void provides(Ruler ruler, float f) {
            LookaheadCapablePlaceable.this.provideRulerValue(ruler, f);
        }

        public void providesRelative(VerticalRuler verticalRuler, float f) {
            LookaheadCapablePlaceable.this.provideRelativeRulerValue((Ruler) verticalRuler, f);
        }

        public float getDensity() {
            return LookaheadCapablePlaceable.this.getDensity();
        }

        public float getFontScale() {
            return LookaheadCapablePlaceable.this.getFontScale();
        }
    }

    public MeasureResult layout(final int width, final int height, final Map<AlignmentLine, Integer> alignmentLines, final Function1<? super RulerScope, Unit> rulers, final Function1<? super Placeable.PlacementScope, Unit> placementBlock) {
        if (!((width & ViewCompat.MEASURED_STATE_MASK) == 0 && ((-16777216) & height) == 0)) {
            InlineClassHelperKt.throwIllegalStateException("Size(" + width + " x " + height + ") is out of range. Each dimension must be between 0 and 16777215.");
        }
        return new MeasureResult() { // from class: androidx.compose.ui.node.LookaheadCapablePlaceable$layout$1
            /* renamed from: getWidth, reason: from getter */
            public int get$width() {
                return width;
            }

            /* renamed from: getHeight, reason: from getter */
            public int get$height() {
                return height;
            }

            public Map<AlignmentLine, Integer> getAlignmentLines() {
                return alignmentLines;
            }

            public Function1<RulerScope, Unit> getRulers() {
                return rulers;
            }

            public void placeChildren() {
                placementBlock.invoke(this.getPlacementScope());
            }
        };
    }
}
