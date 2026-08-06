package androidx.compose.p001ui.node;

import androidx.compose.p001ui.node.LayoutNode;
import androidx.compose.p001ui.node.NodeCoordinator;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.Placeable;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InnerNodeCoordinator.kt */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0001\u0018\u0000 D2\u00020\u0001:\u0002CDB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0017\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001aH\u0016J'\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0014¢\u0006\u0004\b'\u0010(J:\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0019\u0010)\u001a\u0015\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u0012\u0018\u00010*¢\u0006\u0002\b,H\u0014¢\u0006\u0004\b'\u0010-J\b\u0010.\u001a\u00020\u0012H\u0002J\u0010\u0010/\u001a\u00020\u001a2\u0006\u00100\u001a\u000201H\u0016J\u001a\u00102\u001a\u00020\u00122\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010&H\u0016J7\u00106\u001a\u00020\u00122\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@H\u0016¢\u0006\u0004\bA\u0010BR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR(\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b@TX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006E"}, d2 = {"Landroidx/compose/ui/node/InnerNodeCoordinator;", "Landroidx/compose/ui/node/NodeCoordinator;", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "<init>", "(Landroidx/compose/ui/node/LayoutNode;)V", "tail", "Landroidx/compose/ui/node/TailModifierNode;", "getTail", "()Landroidx/compose/ui/node/TailModifierNode;", StrategyConstants.VALUE, "Landroidx/compose/ui/node/LookaheadDelegate;", "lookaheadDelegate", "getLookaheadDelegate", "()Landroidx/compose/ui/node/LookaheadDelegate;", "setLookaheadDelegate", "(Landroidx/compose/ui/node/LookaheadDelegate;)V", "ensureLookaheadDelegateCreated", "", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicWidth", "", "height", "minIntrinsicHeight", "width", "maxIntrinsicWidth", "maxIntrinsicHeight", "placeAt", "position", "Landroidx/compose/ui/unit/IntOffset;", "zIndex", "", "layer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "placeAt-f8xVGno", "(JFLandroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "(JFLkotlin/jvm/functions/Function1;)V", "onAfterPlaceAt", "calculateAlignmentLine", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "performDraw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "graphicsLayer", "hitTestChild", "hitTestSource", "Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "pointerType", "Landroidx/compose/ui/input/pointer/PointerType;", "isInLayer", "", "hitTestChild-qzLsGqo", "(Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;IZ)V", "LookaheadDelegateImpl", "Companion", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class InnerNodeCoordinator extends NodeCoordinator {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Paint innerBoundsPaint;
    private LookaheadDelegate lookaheadDelegate;
    private final TailModifierNode tail;

    public InnerNodeCoordinator(LayoutNode layoutNode) {
        super(layoutNode);
        this.tail = new TailModifierNode();
        getTail().updateCoordinator$ui_release(this);
        this.lookaheadDelegate = layoutNode.getLookaheadRoot() != null ? new LookaheadDelegateImpl() : null;
    }

    @Override // androidx.compose.p001ui.node.NodeCoordinator
    public TailModifierNode getTail() {
        return this.tail;
    }

    @Override // androidx.compose.p001ui.node.NodeCoordinator
    public LookaheadDelegate getLookaheadDelegate() {
        return this.lookaheadDelegate;
    }

    @Override // androidx.compose.p001ui.node.NodeCoordinator
    protected void setLookaheadDelegate(LookaheadDelegate lookaheadDelegate) {
        this.lookaheadDelegate = lookaheadDelegate;
    }

    /* compiled from: InnerNodeCoordinator.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0014J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000bH\u0016¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/node/InnerNodeCoordinator$LookaheadDelegateImpl;", "Landroidx/compose/ui/node/LookaheadDelegate;", "<init>", "(Landroidx/compose/ui/node/InnerNodeCoordinator;)V", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "calculateAlignmentLine", "", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "placeChildren", "", "minIntrinsicWidth", "height", "minIntrinsicHeight", "width", "maxIntrinsicWidth", "maxIntrinsicHeight", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    private final class LookaheadDelegateImpl extends LookaheadDelegate {
        public LookaheadDelegateImpl() {
            super(InnerNodeCoordinator.this);
        }

        /* renamed from: measure-BRTryo0, reason: not valid java name */
        public Placeable m1389measureBRTryo0(long constraints) {
            LookaheadDelegateImpl lookaheadDelegateImpl = this;
            LookaheadDelegate.m1468access$setMeasurementConstraintsBRTryo0(lookaheadDelegateImpl, constraints);
            MutableVector<LayoutNode> mutableVector = getLayoutNode().get_children$ui_release();
            Object[] objArr = mutableVector.content;
            int size = mutableVector.getSize();
            for (int i = 0; i < size; i++) {
                LookaheadPassDelegate lookaheadPassDelegate$ui_release = ((LayoutNode) objArr[i]).getLookaheadPassDelegate$ui_release();
                Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
                lookaheadPassDelegate$ui_release.setMeasuredByParent$ui_release(LayoutNode.UsageByParent.NotUsed);
            }
            LookaheadDelegate.access$set_measureResult(lookaheadDelegateImpl, getLayoutNode().getMeasurePolicy().measure-3p2s80s(this, getLayoutNode().getChildLookaheadMeasurables$ui_release(), constraints));
            return lookaheadDelegateImpl;
        }

        @Override // androidx.compose.p001ui.node.LookaheadCapablePlaceable
        public int calculateAlignmentLine(AlignmentLine alignmentLine) {
            Integer num = getAlignmentLinesOwner().calculateAlignmentLines().get(alignmentLine);
            int intValue = num != null ? num.intValue() : Integer.MIN_VALUE;
            getCachedAlignmentLinesMap().set(alignmentLine, intValue);
            return intValue;
        }

        @Override // androidx.compose.p001ui.node.LookaheadDelegate
        protected void placeChildren() {
            LookaheadPassDelegate lookaheadPassDelegate$ui_release = getLayoutNode().getLookaheadPassDelegate$ui_release();
            Intrinsics.checkNotNull(lookaheadPassDelegate$ui_release);
            lookaheadPassDelegate$ui_release.onNodePlaced$ui_release();
        }

        @Override // androidx.compose.p001ui.node.LookaheadDelegate
        public int minIntrinsicWidth(int height) {
            return getLayoutNode().minLookaheadIntrinsicWidth(height);
        }

        @Override // androidx.compose.p001ui.node.LookaheadDelegate
        public int minIntrinsicHeight(int width) {
            return getLayoutNode().minLookaheadIntrinsicHeight(width);
        }

        @Override // androidx.compose.p001ui.node.LookaheadDelegate
        public int maxIntrinsicWidth(int height) {
            return getLayoutNode().maxLookaheadIntrinsicWidth(height);
        }

        @Override // androidx.compose.p001ui.node.LookaheadDelegate
        public int maxIntrinsicHeight(int width) {
            return getLayoutNode().maxLookaheadIntrinsicHeight(width);
        }
    }

    @Override // androidx.compose.p001ui.node.NodeCoordinator
    public void ensureLookaheadDelegateCreated() {
        if (getLookaheadDelegate() == null) {
            setLookaheadDelegate(new LookaheadDelegateImpl());
        }
    }

    /* renamed from: measure-BRTryo0, reason: not valid java name */
    public Placeable m1386measureBRTryo0(long constraints) {
        if (getForceMeasureWithLookaheadConstraints()) {
            LookaheadDelegate lookaheadDelegate = getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            constraints = lookaheadDelegate.m1470getConstraintsmsEJaDk$ui_release();
        }
        setMeasurementConstraints-BRTryo0(constraints);
        MutableVector<LayoutNode> mutableVector = getLayoutNode().get_children$ui_release();
        Object[] objArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            ((LayoutNode) objArr[i]).getMeasurePassDelegate$ui_release().setMeasuredByParent$ui_release(LayoutNode.UsageByParent.NotUsed);
        }
        setMeasureResult$ui_release(getLayoutNode().getMeasurePolicy().measure-3p2s80s(this, getLayoutNode().getChildMeasurables$ui_release(), constraints));
        onMeasured();
        return this;
    }

    public int minIntrinsicWidth(int height) {
        return getLayoutNode().minIntrinsicWidth(height);
    }

    public int minIntrinsicHeight(int width) {
        return getLayoutNode().minIntrinsicHeight(width);
    }

    public int maxIntrinsicWidth(int height) {
        return getLayoutNode().maxIntrinsicWidth(height);
    }

    public int maxIntrinsicHeight(int width) {
        return getLayoutNode().maxIntrinsicHeight(width);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.p001ui.node.NodeCoordinator
    /* renamed from: placeAt-f8xVGno, reason: not valid java name */
    public void mo1387placeAtf8xVGno(long position, float zIndex, GraphicsLayer layer) {
        super.mo1387placeAtf8xVGno(position, zIndex, layer);
        onAfterPlaceAt();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.p001ui.node.NodeCoordinator
    /* renamed from: placeAt-f8xVGno, reason: not valid java name */
    public void mo1388placeAtf8xVGno(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
        super.mo1388placeAtf8xVGno(position, zIndex, layerBlock);
        onAfterPlaceAt();
    }

    private final void onAfterPlaceAt() {
        if (getIsShallowPlacing()) {
            return;
        }
        getLayoutNode().getMeasurePassDelegate$ui_release().onNodePlaced$ui_release();
    }

    @Override // androidx.compose.p001ui.node.LookaheadCapablePlaceable
    public int calculateAlignmentLine(AlignmentLine alignmentLine) {
        LookaheadDelegate lookaheadDelegate = getLookaheadDelegate();
        if (lookaheadDelegate != null) {
            return lookaheadDelegate.calculateAlignmentLine(alignmentLine);
        }
        Integer num = getAlignmentLinesOwner().calculateAlignmentLines().get(alignmentLine);
        if (num != null) {
            return num.intValue();
        }
        return Integer.MIN_VALUE;
    }

    @Override // androidx.compose.p001ui.node.NodeCoordinator
    public void performDraw(Canvas canvas, GraphicsLayer graphicsLayer) {
        Owner requireOwner = LayoutNodeKt.requireOwner(getLayoutNode());
        MutableVector<LayoutNode> zSortedChildren = getLayoutNode().getZSortedChildren();
        Object[] objArr = zSortedChildren.content;
        int size = zSortedChildren.getSize();
        for (int i = 0; i < size; i++) {
            LayoutNode layoutNode = (LayoutNode) objArr[i];
            if (layoutNode.isPlaced()) {
                layoutNode.draw$ui_release(canvas, graphicsLayer);
            }
        }
        if (requireOwner.getShowLayoutBounds()) {
            drawBorder(canvas, innerBoundsPaint);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00a2 A[LOOP:0: B:8:0x0064->B:17:0x00a2, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a7 A[EDGE_INSN: B:18:0x00a7->B:19:0x00a7 BREAK  A[LOOP:0: B:8:0x0064->B:17:0x00a2], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x004f  */
    @Override // androidx.compose.p001ui.node.NodeCoordinator
    /* renamed from: hitTestChild-qzLsGqo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mo1385hitTestChildqzLsGqo(NodeCoordinator.HitTestSource hitTestSource, long pointerPosition, HitTestResult hitTestResult, int pointerType, boolean isInLayer) {
        boolean z;
        boolean z2;
        Object[] objArr;
        boolean z3;
        boolean z4;
        if (hitTestSource.shouldHitTestChildren(getLayoutNode())) {
            if (m1551withinLayerBoundsk4lQ0M(pointerPosition)) {
                z = isInLayer;
                z2 = true;
            } else if (PointerType.equals-impl0(pointerType, PointerType.Companion.getTouch-T8wyACA())) {
                if ((Float.floatToRawIntBits(m1529distanceInMinimumTouchTargettz77jQw(pointerPosition, m1532getMinimumTouchTargetSizeNHjbRc())) & Integer.MAX_VALUE) < 2139095040) {
                    z2 = true;
                    z = false;
                }
            }
            if (z2) {
                return;
            }
            int i = hitTestResult.hitDepth;
            MutableVector<LayoutNode> zSortedChildren = getLayoutNode().getZSortedChildren();
            Object[] objArr2 = zSortedChildren.content;
            int size = zSortedChildren.getSize() - 1;
            while (size >= 0) {
                LayoutNode layoutNode = (LayoutNode) objArr2[size];
                if (layoutNode.isPlaced()) {
                    objArr = objArr2;
                    hitTestSource.mo1552childHitTestqzLsGqo(layoutNode, pointerPosition, hitTestResult, pointerType, z);
                    if (hitTestResult.hasHit()) {
                        if (!layoutNode.getOuterCoordinator$ui_release().shouldSharePointerInputWithSiblings()) {
                            z4 = false;
                            if (!z4) {
                                z3 = true;
                                if (!z3) {
                                    break;
                                }
                                size--;
                                objArr2 = objArr;
                            }
                        } else {
                            hitTestResult.acceptHits();
                        }
                    }
                    z4 = true;
                    if (!z4) {
                    }
                } else {
                    objArr = objArr2;
                }
                z3 = false;
                if (!z3) {
                }
            }
            hitTestResult.hitDepth = i;
            return;
        }
        z = isInLayer;
        z2 = false;
        if (z2) {
        }
    }

    /* compiled from: InnerNodeCoordinator.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/node/InnerNodeCoordinator$Companion;", "", "<init>", "()V", "innerBoundsPaint", "Landroidx/compose/ui/graphics/Paint;", "getInnerBoundsPaint", "()Landroidx/compose/ui/graphics/Paint;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Paint getInnerBoundsPaint() {
            return InnerNodeCoordinator.innerBoundsPaint;
        }
    }

    static {
        Paint Paint = AndroidPaint_androidKt.Paint();
        Paint.setColor-8_81llA(Color.Companion.getRed-0d7_KjU());
        Paint.setStrokeWidth(1.0f);
        Paint.setStyle-k9PVt8s(PaintingStyle.Companion.getStroke-TiuSbCo());
        innerBoundsPaint = Paint;
    }
}
