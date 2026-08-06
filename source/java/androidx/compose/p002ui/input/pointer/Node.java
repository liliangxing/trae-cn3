package androidx.compose.p002ui.input.pointer;

import androidx.collection.LongSparseArray;
import androidx.collection.MutableObjectList;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.geometry.InlineClassHelperKt;
import androidx.compose.p002ui.geometry.Offset;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.input.pointer.util.PointerIdArray;
import androidx.compose.p002ui.layout.LayoutCoordinates;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.PointerInputModifierNodeKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HitPathTracker.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00000\u001cH\u0016J.\u0010\u001d\u001a\u00020\u00142\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0014H\u0016J\u0010\u0010#\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!H\u0016J.\u0010$\u001a\u00020\u00142\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0014H\u0016J\u001a\u0010%\u001a\u00020\u00142\b\u0010&\u001a\u0004\u0018\u00010\u00122\u0006\u0010'\u001a\u00020\u0012H\u0002J\b\u0010(\u001a\u00020\u0018H\u0002J\u0017\u0010)\u001a\u00020\u00142\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00180+H\u0082\bJ\b\u0010,\u001a\u00020\u0018H\u0016J\u0006\u0010-\u001a\u00020\u0018J\u0010\u0010.\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010/\u001a\u000200H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Landroidx/compose/ui/input/pointer/Node;", "Landroidx/compose/ui/input/pointer/NodeParent;", "modifierNode", "Landroidx/compose/ui/Modifier$Node;", "<init>", "(Landroidx/compose/ui/Modifier$Node;)V", "getModifierNode", "()Landroidx/compose/ui/Modifier$Node;", "pointerIds", "Landroidx/compose/ui/input/pointer/util/PointerIdArray;", "getPointerIds", "()Landroidx/compose/ui/input/pointer/util/PointerIdArray;", "relevantChanges", "Landroidx/collection/LongSparseArray;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "wasIn", "", "isIn", "hasExited", "removeInvalidPointerIdsAndChanges", "", "pointerIdValue", "", "hitNodes", "Landroidx/collection/MutableObjectList;", "dispatchMainEventPass", "changes", "parentCoordinates", "internalPointerEvent", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "isInBounds", "dispatchFinalEventPass", "buildCache", "hasPositionChanged", "oldEvent", "newEvent", "clearCache", "dispatchIfNeeded", "block", "Lkotlin/Function0;", "dispatchCancel", "markIsIn", "cleanUpHits", "toString", "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class Node extends NodeParent {
    public static final int $stable = 8;
    private LayoutCoordinates coordinates;
    private final Modifier.Node modifierNode;
    private PointerEvent pointerEvent;
    private boolean wasIn;
    private final PointerIdArray pointerIds = new PointerIdArray();
    private final LongSparseArray<PointerInputChange> relevantChanges = new LongSparseArray<>(2);
    private boolean isIn = true;
    private boolean hasExited = true;

    public Node(Modifier.Node node) {
        this.modifierNode = node;
    }

    public final Modifier.Node getModifierNode() {
        return this.modifierNode;
    }

    public final PointerIdArray getPointerIds() {
        return this.pointerIds;
    }

    @Override // androidx.compose.p002ui.input.pointer.NodeParent
    public void removeInvalidPointerIdsAndChanges(long pointerIdValue, MutableObjectList<Node> hitNodes) {
        if (this.pointerIds.contains(pointerIdValue) && !hitNodes.contains(this)) {
            this.pointerIds.remove(pointerIdValue);
            this.relevantChanges.remove(pointerIdValue);
        }
        MutableVector<Node> children = getChildren();
        Node[] nodeArr = children.content;
        int size = children.getSize();
        for (int i = 0; i < size; i++) {
            nodeArr[i].removeInvalidPointerIdsAndChanges(pointerIdValue, hitNodes);
        }
    }

    @Override // androidx.compose.p002ui.input.pointer.NodeParent
    public boolean buildCache(LongSparseArray<PointerInputChange> changes, LayoutCoordinates parentCoordinates, InternalPointerEvent internalPointerEvent, boolean isInBounds) {
        boolean z;
        PointerInputChange pointerInputChange;
        boolean z2;
        boolean z3;
        int m6096getExit7fucELk;
        boolean z4;
        int i;
        int i2;
        PointerInputChange m6139copyOHpmEuE;
        List<HistoricalChange> list;
        int i3;
        boolean buildCache = super.buildCache(changes, parentCoordinates, internalPointerEvent, isInBounds);
        if (!this.modifierNode.getIsAttached()) {
            return true;
        }
        Modifier.Node node = this.modifierNode;
        int i4 = NodeKind.constructor-impl(16);
        MutableVector mutableVector = null;
        while (true) {
            z = false;
            if (node == null) {
                break;
            }
            if (node instanceof PointerInputModifierNode) {
                this.coordinates = PointerInputModifierNodeKt.getLayoutCoordinates((PointerInputModifierNode) node);
            } else if (((node.getKindSet() & i4) != 0) && (node instanceof DelegatingNode)) {
                int i5 = 0;
                for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild()) {
                    if ((delegate$ui_release.getKindSet() & i4) != 0) {
                        i5++;
                        if (i5 == 1) {
                            node = delegate$ui_release;
                        } else {
                            if (mutableVector == null) {
                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (node != null) {
                                if (mutableVector != null) {
                                    mutableVector.add(node);
                                }
                                node = null;
                            }
                            if (mutableVector != null) {
                                mutableVector.add(delegate$ui_release);
                            }
                        }
                    }
                }
                if (i5 == 1) {
                }
            }
            node = DelegatableNodeKt.access$pop(mutableVector);
        }
        if (this.coordinates == null) {
            return true;
        }
        int size = changes.size();
        int i6 = 0;
        while (i6 < size) {
            long keyAt = changes.keyAt(i6);
            PointerInputChange valueAt = changes.valueAt(i6);
            if (this.pointerIds.contains(keyAt)) {
                long previousPosition = valueAt.getPreviousPosition();
                i2 = i6;
                long position = valueAt.getPosition();
                if ((((previousPosition & 9223372034707292159L) + InlineClassHelperKt.DualLoadedSignificand) & (-9223372034707292160L)) == 0 ? true : z) {
                    if ((((position & 9223372034707292159L) + InlineClassHelperKt.DualLoadedSignificand) & (-9223372034707292160L)) == 0 ? true : z) {
                        ArrayList arrayList = new ArrayList(valueAt.getHistorical().size());
                        List<HistoricalChange> historical = valueAt.getHistorical();
                        int size2 = historical.size();
                        i = size;
                        int i7 = 0;
                        while (i7 < size2) {
                            HistoricalChange historicalChange = historical.get(i7);
                            boolean z5 = buildCache;
                            long position2 = historicalChange.getPosition();
                            if ((((position2 & 9223372034707292159L) + InlineClassHelperKt.DualLoadedSignificand) & (-9223372034707292160L)) == 0) {
                                list = historical;
                                long uptimeMillis = historicalChange.getUptimeMillis();
                                i3 = size2;
                                LayoutCoordinates layoutCoordinates = this.coordinates;
                                Intrinsics.checkNotNull(layoutCoordinates);
                                arrayList.add(new HistoricalChange(uptimeMillis, layoutCoordinates.mo6340localPositionOfR5De75A(parentCoordinates, position2), historicalChange.getOriginalEventPosition(), null));
                            } else {
                                list = historical;
                                i3 = size2;
                            }
                            i7++;
                            historical = list;
                            size2 = i3;
                            buildCache = z5;
                        }
                        z4 = buildCache;
                        LongSparseArray<PointerInputChange> longSparseArray = this.relevantChanges;
                        LayoutCoordinates layoutCoordinates2 = this.coordinates;
                        Intrinsics.checkNotNull(layoutCoordinates2);
                        long mo6340localPositionOfR5De75A = layoutCoordinates2.mo6340localPositionOfR5De75A(parentCoordinates, previousPosition);
                        LayoutCoordinates layoutCoordinates3 = this.coordinates;
                        Intrinsics.checkNotNull(layoutCoordinates3);
                        m6139copyOHpmEuE = valueAt.m6139copyOHpmEuE((r34 & 1) != 0 ? valueAt.id : 0L, (r34 & 2) != 0 ? valueAt.uptimeMillis : 0L, (r34 & 4) != 0 ? valueAt.position : layoutCoordinates3.mo6340localPositionOfR5De75A(parentCoordinates, position), (r34 & 8) != 0 ? valueAt.pressed : false, (r34 & 16) != 0 ? valueAt.previousUptimeMillis : 0L, (r34 & 32) != 0 ? valueAt.previousPosition : mo6340localPositionOfR5De75A, (r34 & 64) != 0 ? valueAt.previousPressed : false, (r34 & Fields.SpotShadowColor) != 0 ? valueAt.type : 0, arrayList, (r34 & Fields.RotationY) != 0 ? valueAt.scrollDelta : 0L);
                        longSparseArray.put(keyAt, m6139copyOHpmEuE);
                    }
                }
                z4 = buildCache;
                i = size;
            } else {
                z4 = buildCache;
                i = size;
                i2 = i6;
            }
            i6 = i2 + 1;
            size = i;
            buildCache = z4;
            z = false;
        }
        boolean z6 = buildCache;
        if (this.relevantChanges.isEmpty()) {
            this.pointerIds.clear();
            getChildren().clear();
            return true;
        }
        for (int size3 = this.pointerIds.getSize() - 1; -1 < size3; size3--) {
            if (!changes.containsKey(this.pointerIds.m6254get_I2yYro(size3))) {
                this.pointerIds.removeAt(size3);
            }
        }
        ArrayList arrayList2 = new ArrayList(this.relevantChanges.size());
        int size4 = this.relevantChanges.size();
        for (int i8 = 0; i8 < size4; i8++) {
            arrayList2.add(this.relevantChanges.valueAt(i8));
        }
        PointerEvent pointerEvent = new PointerEvent(arrayList2, internalPointerEvent);
        List<PointerInputChange> changes2 = pointerEvent.getChanges();
        int size5 = changes2.size();
        int i9 = 0;
        while (true) {
            if (i9 >= size5) {
                pointerInputChange = null;
                break;
            }
            PointerInputChange pointerInputChange2 = changes2.get(i9);
            if (internalPointerEvent.m6070activeHoverEvent0FcD4WY(pointerInputChange2.getId())) {
                pointerInputChange = pointerInputChange2;
                break;
            }
            i9++;
        }
        PointerInputChange pointerInputChange3 = pointerInputChange;
        if (pointerInputChange3 != null) {
            if (!isInBounds) {
                z2 = false;
                this.isIn = false;
            } else {
                z2 = false;
                if (!this.isIn && (pointerInputChange3.getPressed() || pointerInputChange3.getPreviousPressed())) {
                    Intrinsics.checkNotNull(this.coordinates);
                    z3 = true;
                    this.isIn = !PointerEventKt.m6086isOutOfBoundsO0kMr_c(pointerInputChange3, r3.mo6339getSizeYbymL2g());
                    if (this.isIn == this.wasIn && (PointerEventType.m6091equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m6097getMove7fucELk()) || PointerEventType.m6091equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m6095getEnter7fucELk()) || PointerEventType.m6091equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m6096getExit7fucELk()))) {
                        if (this.isIn) {
                            m6096getExit7fucELk = PointerEventType.INSTANCE.m6095getEnter7fucELk();
                        } else {
                            m6096getExit7fucELk = PointerEventType.INSTANCE.m6096getExit7fucELk();
                        }
                        pointerEvent.m6085setTypeEhbLWgg$ui_release(m6096getExit7fucELk);
                    } else if (!PointerEventType.m6091equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m6095getEnter7fucELk()) && this.wasIn && !this.hasExited) {
                        pointerEvent.m6085setTypeEhbLWgg$ui_release(PointerEventType.INSTANCE.m6097getMove7fucELk());
                    } else if (PointerEventType.m6091equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m6096getExit7fucELk()) && this.isIn && pointerInputChange3.getPressed()) {
                        pointerEvent.m6085setTypeEhbLWgg$ui_release(PointerEventType.INSTANCE.m6097getMove7fucELk());
                    }
                }
            }
            z3 = true;
            if (this.isIn == this.wasIn) {
            }
            if (!PointerEventType.m6091equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m6095getEnter7fucELk())) {
            }
            if (PointerEventType.m6091equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m6096getExit7fucELk())) {
                pointerEvent.m6085setTypeEhbLWgg$ui_release(PointerEventType.INSTANCE.m6097getMove7fucELk());
            }
        } else {
            z2 = false;
            z3 = true;
        }
        boolean z7 = (z6 || !PointerEventType.m6091equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m6097getMove7fucELk()) || hasPositionChanged(this.pointerEvent, pointerEvent)) ? z3 : z2;
        this.pointerEvent = pointerEvent;
        return z7;
    }

    private final boolean hasPositionChanged(PointerEvent oldEvent, PointerEvent newEvent) {
        if (oldEvent == null || oldEvent.getChanges().size() != newEvent.getChanges().size()) {
            return true;
        }
        int size = newEvent.getChanges().size();
        for (int i = 0; i < size; i++) {
            if (!Offset.m4590equalsimpl0(oldEvent.getChanges().get(i).getPosition(), newEvent.getChanges().get(i).getPosition())) {
                return true;
            }
        }
        return false;
    }

    private final void clearCache() {
        this.relevantChanges.clear();
        this.coordinates = null;
    }

    private final boolean dispatchIfNeeded(Function0<Unit> block) {
        if (this.relevantChanges.isEmpty() || !this.modifierNode.getIsAttached()) {
            return false;
        }
        block.invoke();
        return true;
    }

    @Override // androidx.compose.p002ui.input.pointer.NodeParent
    public void dispatchCancel() {
        MutableVector<Node> children = getChildren();
        Node[] nodeArr = children.content;
        int size = children.getSize();
        for (int i = 0; i < size; i++) {
            nodeArr[i].dispatchCancel();
        }
        Modifier.Node node = this.modifierNode;
        int i2 = NodeKind.constructor-impl(16);
        MutableVector mutableVector = null;
        while (node != null) {
            if (node instanceof PointerInputModifierNode) {
                ((PointerInputModifierNode) node).onCancelPointerInput();
            } else if (((node.getKindSet() & i2) != 0) && (node instanceof DelegatingNode)) {
                int i3 = 0;
                for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild()) {
                    if ((delegate$ui_release.getKindSet() & i2) != 0) {
                        i3++;
                        if (i3 == 1) {
                            node = delegate$ui_release;
                        } else {
                            if (mutableVector == null) {
                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (node != null) {
                                if (mutableVector != null) {
                                    mutableVector.add(node);
                                }
                                node = null;
                            }
                            if (mutableVector != null) {
                                mutableVector.add(delegate$ui_release);
                            }
                        }
                    }
                }
                if (i3 == 1) {
                }
            }
            node = DelegatableNodeKt.access$pop(mutableVector);
        }
    }

    public final void markIsIn() {
        this.isIn = true;
    }

    @Override // androidx.compose.p002ui.input.pointer.NodeParent
    public void cleanUpHits(InternalPointerEvent internalPointerEvent) {
        super.cleanUpHits(internalPointerEvent);
        PointerEvent pointerEvent = this.pointerEvent;
        if (pointerEvent == null) {
            return;
        }
        this.wasIn = this.isIn;
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        for (int i = 0; i < size; i++) {
            PointerInputChange pointerInputChange = changes.get(i);
            boolean z = true;
            boolean z2 = !pointerInputChange.getPressed();
            boolean z3 = !internalPointerEvent.m6070activeHoverEvent0FcD4WY(pointerInputChange.getId());
            boolean z4 = !this.isIn;
            if ((!z2 || !z3) && (!z2 || !z4)) {
                z = false;
            }
            if (z) {
                this.pointerIds.remove(pointerInputChange.getId());
            }
        }
        this.isIn = false;
        this.hasExited = PointerEventType.m6091equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m6096getExit7fucELk());
    }

    public String toString() {
        return "Node(modifierNode=" + this.modifierNode + ", children=" + getChildren() + ", pointerIds=" + this.pointerIds + ')';
    }

    @Override // androidx.compose.p002ui.input.pointer.NodeParent
    public boolean dispatchMainEventPass(LongSparseArray<PointerInputChange> changes, LayoutCoordinates parentCoordinates, InternalPointerEvent internalPointerEvent, boolean isInBounds) {
        if (this.relevantChanges.isEmpty() || !this.modifierNode.getIsAttached()) {
            return false;
        }
        PointerEvent pointerEvent = this.pointerEvent;
        Intrinsics.checkNotNull(pointerEvent);
        LayoutCoordinates layoutCoordinates = this.coordinates;
        Intrinsics.checkNotNull(layoutCoordinates);
        long mo6339getSizeYbymL2g = layoutCoordinates.mo6339getSizeYbymL2g();
        Modifier.Node node = this.modifierNode;
        int i = NodeKind.constructor-impl(16);
        MutableVector mutableVector = null;
        while (node != null) {
            if (node instanceof PointerInputModifierNode) {
                ((PointerInputModifierNode) node).onPointerEvent-H0pRuoY(pointerEvent, PointerEventPass.Initial, mo6339getSizeYbymL2g);
            } else if (((node.getKindSet() & i) != 0) && (node instanceof DelegatingNode)) {
                int i2 = 0;
                for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild()) {
                    if ((delegate$ui_release.getKindSet() & i) != 0) {
                        i2++;
                        if (i2 == 1) {
                            node = delegate$ui_release;
                        } else {
                            if (mutableVector == null) {
                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (node != null) {
                                if (mutableVector != null) {
                                    mutableVector.add(node);
                                }
                                node = null;
                            }
                            if (mutableVector != null) {
                                mutableVector.add(delegate$ui_release);
                            }
                        }
                    }
                }
                if (i2 == 1) {
                }
            }
            node = DelegatableNodeKt.access$pop(mutableVector);
        }
        if (this.modifierNode.getIsAttached()) {
            MutableVector<Node> children = getChildren();
            Node[] nodeArr = children.content;
            int size = children.getSize();
            for (int i3 = 0; i3 < size; i3++) {
                Node node2 = nodeArr[i3];
                LongSparseArray<PointerInputChange> longSparseArray = this.relevantChanges;
                LayoutCoordinates layoutCoordinates2 = this.coordinates;
                Intrinsics.checkNotNull(layoutCoordinates2);
                node2.dispatchMainEventPass(longSparseArray, layoutCoordinates2, internalPointerEvent, isInBounds);
            }
        }
        if (this.modifierNode.getIsAttached()) {
            Modifier.Node node3 = this.modifierNode;
            int i4 = NodeKind.constructor-impl(16);
            MutableVector mutableVector2 = null;
            while (node3 != null) {
                if (node3 instanceof PointerInputModifierNode) {
                    ((PointerInputModifierNode) node3).onPointerEvent-H0pRuoY(pointerEvent, PointerEventPass.Main, mo6339getSizeYbymL2g);
                } else if (((node3.getKindSet() & i4) != 0) && (node3 instanceof DelegatingNode)) {
                    int i5 = 0;
                    for (Modifier.Node delegate$ui_release2 = ((DelegatingNode) node3).getDelegate$ui_release(); delegate$ui_release2 != null; delegate$ui_release2 = delegate$ui_release2.getChild()) {
                        if ((delegate$ui_release2.getKindSet() & i4) != 0) {
                            i5++;
                            if (i5 == 1) {
                                node3 = delegate$ui_release2;
                            } else {
                                if (mutableVector2 == null) {
                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node3 != null) {
                                    if (mutableVector2 != null) {
                                        mutableVector2.add(node3);
                                    }
                                    node3 = null;
                                }
                                if (mutableVector2 != null) {
                                    mutableVector2.add(delegate$ui_release2);
                                }
                            }
                        }
                    }
                    if (i5 == 1) {
                    }
                }
                node3 = DelegatableNodeKt.access$pop(mutableVector2);
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.p002ui.input.pointer.NodeParent
    public boolean dispatchFinalEventPass(InternalPointerEvent internalPointerEvent) {
        boolean z = false;
        z = false;
        if (!this.relevantChanges.isEmpty() && this.modifierNode.getIsAttached()) {
            PointerEvent pointerEvent = this.pointerEvent;
            Intrinsics.checkNotNull(pointerEvent);
            LayoutCoordinates layoutCoordinates = this.coordinates;
            Intrinsics.checkNotNull(layoutCoordinates);
            long mo6339getSizeYbymL2g = layoutCoordinates.mo6339getSizeYbymL2g();
            Modifier.Node node = this.modifierNode;
            int i = NodeKind.constructor-impl(16);
            MutableVector mutableVector = null;
            while (node != null) {
                if (node instanceof PointerInputModifierNode) {
                    ((PointerInputModifierNode) node).onPointerEvent-H0pRuoY(pointerEvent, PointerEventPass.Final, mo6339getSizeYbymL2g);
                } else if (((node.getKindSet() & i) != 0) != false && (node instanceof DelegatingNode)) {
                    int i2 = 0;
                    for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild()) {
                        if (((delegate$ui_release.getKindSet() & i) != 0) != false) {
                            i2++;
                            if (i2 == 1) {
                                node = delegate$ui_release;
                            } else {
                                if (mutableVector == null) {
                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (node != null) {
                                    if (mutableVector != null) {
                                        mutableVector.add(node);
                                    }
                                    node = null;
                                }
                                if (mutableVector != null) {
                                    mutableVector.add(delegate$ui_release);
                                }
                            }
                        }
                    }
                    if (i2 == 1) {
                    }
                }
                node = DelegatableNodeKt.access$pop(mutableVector);
            }
            if (this.modifierNode.getIsAttached()) {
                MutableVector<Node> children = getChildren();
                Node[] nodeArr = children.content;
                int size = children.getSize();
                for (int i3 = 0; i3 < size; i3++) {
                    nodeArr[i3].dispatchFinalEventPass(internalPointerEvent);
                }
            }
            z = true;
        }
        cleanUpHits(internalPointerEvent);
        clearCache();
        return z;
    }
}
