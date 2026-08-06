package androidx.compose.p001ui.spatial;

import android.os.Trace;
import androidx.collection.IntObjectMap;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableObjectList;
import androidx.collection.ObjectList;
import androidx.compose.p001ui.node.DelegatableNode;
import androidx.compose.p001ui.node.LayoutNode;
import androidx.compose.p001ui.node.MeasurePassDelegate;
import androidx.compose.p001ui.node.NodeCoordinator;
import androidx.compose.p001ui.node.NodeKind;
import androidx.compose.p001ui.node.OwnedLayer;
import androidx.compose.p001ui.spatial.ThrottledCallbacks;
import androidx.compose.p001ui.unit.IntOffset;
import androidx.compose.p001ui.unit.IntOffsetKt;
import androidx.compose.p001ui.unit.IntSize;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Actual_androidKt;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.MatrixKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: RectManager.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0019\u001a\u00020\u0010J5\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\u0006\u0010%\u001a\u00020\u0010J\u000e\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u0012J\u0016\u0010(\u001a\u0004\u0018\u00010\u00012\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ:\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020!2\u0006\u0010-\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u0002002\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\u001001J:\u00103\u001a\u00020+2\u0006\u0010,\u001a\u00020!2\u0006\u0010-\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u0002002\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\u001001J\u0010\u00104\u001a\u00020\u00102\b\u00105\u001a\u0004\u0018\u00010\u0001J\u000e\u00106\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u0004J\u001e\u00108\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u00042\u0006\u00109\u001a\u00020\u00122\u0006\u0010:\u001a\u00020\u0012J\u000e\u0010;\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u0004J\u0016\u0010<\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u0012J\u0010\u0010>\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u0004H\u0002J\u0010\u0010?\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u0004H\u0002J\u0018\u0010B\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u0012H\u0002J8\u0010C\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u00122\u0006\u0010D\u001a\u00020!2\u0006\u0010E\u001a\u00020!2\u0006\u0010F\u001a\u00020!2\u0006\u0010G\u001a\u00020!H\u0002J\u0014\u0010H\u001a\u00020\u0010*\u00020I2\u0006\u0010J\u001a\u00020AH\u0002J\u001b\u0010K\u001a\u00020\u001c*\u00020I2\u0006\u0010L\u001a\u00020\u001cH\u0002¢\u0006\u0004\bM\u0010NJ\u0013\u0010O\u001a\u00020\u001c*\u00020\u0004H\u0002¢\u0006\u0004\bP\u0010QJ\u000e\u0010R\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u0004J\u001d\u0010S\u001a\u00020\u00122\u0006\u0010T\u001a\u00020!2\u0006\u0010U\u001a\u00020!H\u0000¢\u0006\u0002\bVR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020AX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006W"}, d2 = {"Landroidx/compose/ui/spatial/RectManager;", "", "layoutNodes", "Landroidx/collection/IntObjectMap;", "Landroidx/compose/ui/node/LayoutNode;", "<init>", "(Landroidx/collection/IntObjectMap;)V", "rects", "Landroidx/compose/ui/spatial/RectList;", "getRects", "()Landroidx/compose/ui/spatial/RectList;", "throttledCallbacks", "Landroidx/compose/ui/spatial/ThrottledCallbacks;", "callbacks", "Landroidx/collection/MutableObjectList;", "Lkotlin/Function0;", "", "isDirty", "", "isScreenOrWindowDirty", "isFragmented", "dispatchToken", "scheduledDispatchDeadline", "", "dispatchLambda", "invalidate", "updateOffsets", "screenOffset", "Landroidx/compose/ui/unit/IntOffset;", "windowOffset", "viewToWindowMatrix", "Landroidx/compose/ui/graphics/Matrix;", "windowWidth", "", "windowHeight", "updateOffsets-gTq6Wqs", "(JJ[FII)V", "dispatchCallbacks", "scheduleDebounceCallback", "ensureSomethingScheduled", "registerOnChangedCallback", "callback", "registerOnRectChangedCallback", "Landroidx/compose/ui/node/DelegatableNode$RegistrationHandle;", "id", "throttleMillis", "debounceMillis", "node", "Landroidx/compose/ui/node/DelegatableNode;", "Lkotlin/Function1;", "Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "registerOnGlobalLayoutCallback", "unregisterOnChangedCallback", "token", "invalidateCallbacksFor", "layoutNode", "updateFlagsFor", "focusable", "gesturable", "onLayoutLayerPositionalPropertiesChanged", "onLayoutPositionChanged", "firstPlacement", "recalculateOffsetFromRoot", "insertOrUpdateTransformedNodeSubhierarchy", "cachedRect", "Landroidx/compose/ui/geometry/MutableRect;", "insertOrUpdateTransformedNode", "insertOrUpdate", "l", "t", "r", "b", "boundingRectInRoot", "Landroidx/compose/ui/node/NodeCoordinator;", "rect", "applyLayerTransformation", "position", "applyLayerTransformation-2IdBmHc", "(Landroidx/compose/ui/node/NodeCoordinator;J)J", "outerToInnerOffset", "outerToInnerOffset-Bjo55l4", "(Landroidx/compose/ui/node/LayoutNode;)J", "remove", "isTargetDrawnFirst", "targetId", "otherId", "isTargetDrawnFirst$ui_release", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class RectManager {
    public static final int $stable = 8;
    private final MutableRect cachedRect;
    private final MutableObjectList<Function0<Unit>> callbacks;
    private final Function0<Unit> dispatchLambda;
    private Object dispatchToken;
    private boolean isDirty;
    private boolean isFragmented;
    private boolean isScreenOrWindowDirty;
    private final IntObjectMap<LayoutNode> layoutNodes;
    private final RectList rects;
    private long scheduledDispatchDeadline;
    private final ThrottledCallbacks throttledCallbacks;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RectManager() {
        this(r0, 1, r0);
        IntObjectMap intObjectMap = null;
    }

    public RectManager(IntObjectMap<LayoutNode> intObjectMap) {
        this.layoutNodes = intObjectMap;
        this.rects = new RectList();
        this.throttledCallbacks = new ThrottledCallbacks();
        this.callbacks = new MutableObjectList<>(0, 1, (DefaultConstructorMarker) null);
        this.scheduledDispatchDeadline = -1L;
        this.dispatchLambda = new Function0<Unit>() { // from class: androidx.compose.ui.spatial.RectManager$dispatchLambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m1889invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m1889invoke() {
                RectManager.this.dispatchToken = null;
                RectManager rectManager = RectManager.this;
                Trace.beginSection("OnPositionedDispatch");
                try {
                    rectManager.dispatchCallbacks();
                    Unit unit = Unit.INSTANCE;
                } finally {
                    Trace.endSection();
                }
            }
        };
        this.cachedRect = new MutableRect(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public /* synthetic */ RectManager(IntObjectMap intObjectMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? IntObjectMapKt.intObjectMapOf() : intObjectMap);
    }

    public final RectList getRects() {
        return this.rects;
    }

    public final void invalidate() {
        this.isDirty = true;
    }

    /* renamed from: updateOffsets-gTq6Wqs, reason: not valid java name */
    public final void m1888updateOffsetsgTq6Wqs(long screenOffset, long windowOffset, float[] viewToWindowMatrix, int windowWidth, int windowHeight) {
        int m1892analyzeComponents58bKbWc;
        m1892analyzeComponents58bKbWc = RectManagerKt.m1892analyzeComponents58bKbWc(viewToWindowMatrix);
        boolean z = true;
        if (!this.throttledCallbacks.m1906updateOffsetsLDcG7Xg(screenOffset, windowOffset, (m1892analyzeComponents58bKbWc & 2) == 0 ? viewToWindowMatrix : null, windowWidth, windowHeight) && !this.isScreenOrWindowDirty) {
            z = false;
        }
        this.isScreenOrWindowDirty = z;
    }

    public final void dispatchCallbacks() {
        int i;
        final long currentTimeMillis = Actual_androidKt.currentTimeMillis();
        boolean z = this.isDirty;
        int i2 = 1;
        int i3 = 0;
        boolean z2 = z || this.isScreenOrWindowDirty;
        if (z) {
            this.isDirty = false;
            ObjectList objectList = this.callbacks;
            Object[] objArr = objectList.content;
            int i4 = objectList._size;
            for (int i5 = 0; i5 < i4; i5++) {
                ((Function0) objArr[i5]).invoke();
            }
            RectList rectList = this.rects;
            long[] jArr = rectList.items;
            int i6 = rectList.itemsSize;
            int i7 = 0;
            while (i7 < jArr.length - 2 && i7 < i6) {
                long j = jArr[i7 + 2];
                if ((((int) (j >> 61)) & 1) != 0) {
                    i = i7;
                    this.throttledCallbacks.fireOnUpdatedRect(67108863 & ((int) j), jArr[i7 + 0], jArr[i7 + 1], currentTimeMillis);
                } else {
                    i = i7;
                }
                i7 = i + 3;
            }
            IntObjectMap rectChangedMap = this.throttledCallbacks.getRectChangedMap();
            Object[] objArr2 = rectChangedMap.values;
            long[] jArr2 = rectChangedMap.metadata;
            int length = jArr2.length - 2;
            if (length >= 0) {
                int i8 = 0;
                while (true) {
                    long j2 = jArr2[i8];
                    if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i9 = 8;
                        int i10 = 8 - ((~(i8 - length)) >>> 31);
                        int i11 = i3;
                        while (i11 < i10) {
                            if (((255 & j2) < 128 ? i2 : i3) != 0) {
                                final ThrottledCallbacks.Entry entry = (ThrottledCallbacks.Entry) objArr2[(i8 << 3) + i11];
                                ThrottledCallbacks.Entry entry2 = entry;
                                while (entry2 != null) {
                                    if (entry.getLastInvokeMillis() == Long.MIN_VALUE) {
                                        this.rects.withTopLeftBottomRight(entry.getId(), new Function2<Long, Long, Unit>() { // from class: androidx.compose.ui.spatial.RectManager$dispatchCallbacks$3$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(2);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                invoke(((Number) obj).longValue(), ((Number) obj2).longValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(long j3, long j4) {
                                                ThrottledCallbacks throttledCallbacks;
                                                throttledCallbacks = RectManager.this.throttledCallbacks;
                                                throttledCallbacks.fireWithUpdatedRect$ui_release(entry, j3, j4, currentTimeMillis);
                                            }
                                        });
                                    }
                                    entry2 = entry2.getNext();
                                    i9 = 8;
                                }
                            }
                            j2 >>= i9;
                            i11++;
                            i2 = 1;
                            i3 = 0;
                        }
                        if (i10 != i9) {
                            break;
                        }
                    }
                    if (i8 == length) {
                        break;
                    }
                    i8++;
                    i2 = 1;
                    i3 = 0;
                }
            }
            this.rects.clearUpdated();
        }
        if (this.isScreenOrWindowDirty) {
            this.isScreenOrWindowDirty = false;
            this.throttledCallbacks.fireOnRectChangedEntries(currentTimeMillis);
        }
        if (z2) {
            this.throttledCallbacks.fireGlobalChangeEntries(currentTimeMillis);
        }
        if (this.isFragmented) {
            this.isFragmented = false;
            this.rects.defragment();
        }
        this.throttledCallbacks.triggerDebounced(currentTimeMillis);
        if (this.throttledCallbacks.getMinDebounceDeadline() > 0) {
            scheduleDebounceCallback(true);
        }
    }

    public final void scheduleDebounceCallback(boolean ensureSomethingScheduled) {
        boolean z = (ensureSomethingScheduled && this.dispatchToken == null) ? false : true;
        long minDebounceDeadline = this.throttledCallbacks.getMinDebounceDeadline();
        if (minDebounceDeadline >= 0 || !z) {
            if (this.scheduledDispatchDeadline == minDebounceDeadline && z) {
                return;
            }
            Object obj = this.dispatchToken;
            if (obj != null) {
                Actual_androidKt.removePost(obj);
            }
            long currentTimeMillis = Actual_androidKt.currentTimeMillis();
            long max = Math.max(minDebounceDeadline, 16 + currentTimeMillis);
            this.scheduledDispatchDeadline = max;
            this.dispatchToken = Actual_androidKt.postDelayed(max - currentTimeMillis, this.dispatchLambda);
        }
    }

    public final Object registerOnChangedCallback(Function0<Unit> callback) {
        this.callbacks.add(callback);
        return callback;
    }

    public final DelegatableNode.RegistrationHandle registerOnRectChangedCallback(int id, long throttleMillis, long debounceMillis, DelegatableNode node, Function1<? super RelativeLayoutBounds, Unit> callback) {
        DelegatableNode.RegistrationHandle registerOnRectChanged = this.throttledCallbacks.registerOnRectChanged(id, throttleMillis, debounceMillis, node, callback);
        invalidate();
        scheduleDebounceCallback(true);
        return registerOnRectChanged;
    }

    public final DelegatableNode.RegistrationHandle registerOnGlobalLayoutCallback(int id, long throttleMillis, long debounceMillis, DelegatableNode node, Function1<? super RelativeLayoutBounds, Unit> callback) {
        return this.throttledCallbacks.registerOnGlobalChange(id, throttleMillis, debounceMillis, node, callback);
    }

    public final void unregisterOnChangedCallback(Object token) {
        if ((TypeIntrinsics.isFunctionOfArity(token, 0) ? (Function0) token : null) == null) {
            return;
        }
        this.callbacks.remove(token);
    }

    public final void invalidateCallbacksFor(LayoutNode layoutNode) {
        this.isDirty = true;
        this.rects.markUpdated(layoutNode.getSemanticsId());
        scheduleDebounceCallback(true);
    }

    public final void updateFlagsFor(LayoutNode layoutNode, boolean focusable, boolean gesturable) {
        if (layoutNode.isAttached()) {
            this.rects.updateFlagsFor(layoutNode.getSemanticsId(), focusable, gesturable);
        }
    }

    public final void onLayoutLayerPositionalPropertiesChanged(LayoutNode layoutNode) {
        boolean m1893isSetgyyYBs;
        if (ComposeUiFlags.isRectTrackingEnabled) {
            long m1887outerToInnerOffsetBjo55l4 = m1887outerToInnerOffsetBjo55l4(layoutNode);
            m1893isSetgyyYBs = RectManagerKt.m1893isSetgyyYBs(m1887outerToInnerOffsetBjo55l4);
            if (m1893isSetgyyYBs) {
                layoutNode.m1409setOuterToInnerOffsetgyyYBs$ui_release(m1887outerToInnerOffsetBjo55l4);
                layoutNode.setOuterToInnerOffsetDirty$ui_release(false);
                MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui_release();
                Object[] objArr = mutableVector.content;
                int size = mutableVector.getSize();
                for (int i = 0; i < size; i++) {
                    onLayoutPositionChanged((LayoutNode) objArr[i], false);
                }
                invalidateCallbacksFor(layoutNode);
                return;
            }
            insertOrUpdateTransformedNodeSubhierarchy(layoutNode);
        }
    }

    public final void onLayoutPositionChanged(LayoutNode layoutNode, boolean firstPlacement) {
        boolean m1893isSetgyyYBs;
        if (ComposeUiFlags.isRectTrackingEnabled) {
            MeasurePassDelegate measurePassDelegate$ui_release = layoutNode.getMeasurePassDelegate$ui_release();
            int measuredWidth = measurePassDelegate$ui_release.getMeasuredWidth();
            int measuredHeight = measurePassDelegate$ui_release.getMeasuredHeight();
            long offsetFromRoot = layoutNode.getOffsetFromRoot();
            long lastSize = layoutNode.getLastSize();
            int i = (int) (lastSize >> 32);
            int i2 = (int) (lastSize & 4294967295L);
            recalculateOffsetFromRoot(layoutNode);
            long offsetFromRoot2 = layoutNode.getOffsetFromRoot();
            m1893isSetgyyYBs = RectManagerKt.m1893isSetgyyYBs(offsetFromRoot2);
            if (!m1893isSetgyyYBs) {
                insertOrUpdateTransformedNode(layoutNode, firstPlacement);
                return;
            }
            layoutNode.m1407setLastSizeozmzZPI$ui_release(IntSize.m2846constructorimpl((measuredWidth << 32) | (4294967295L & measuredHeight)));
            int m2808getXimpl = IntOffset.m2808getXimpl(offsetFromRoot2);
            int m2809getYimpl = IntOffset.m2809getYimpl(offsetFromRoot2);
            int i3 = m2808getXimpl + measuredWidth;
            int i4 = m2809getYimpl + measuredHeight;
            if (!firstPlacement && IntOffset.m2807equalsimpl0(offsetFromRoot2, offsetFromRoot) && i == measuredWidth && i2 == measuredHeight) {
                return;
            }
            insertOrUpdate(layoutNode, firstPlacement, m2808getXimpl, m2809getYimpl, i3, i4);
        }
    }

    private final void recalculateOffsetFromRoot(LayoutNode layoutNode) {
        boolean m1893isSetgyyYBs;
        boolean m1893isSetgyyYBs2;
        boolean m1893isSetgyyYBs3;
        long outerToInnerOffset;
        boolean m1893isSetgyyYBs4;
        NodeCoordinator outerCoordinator$ui_release = layoutNode.getOuterCoordinator$ui_release();
        long m1886applyLayerTransformation2IdBmHc = m1886applyLayerTransformation2IdBmHc(outerCoordinator$ui_release, IntOffset.INSTANCE.m2819getZeronOccac());
        m1893isSetgyyYBs = RectManagerKt.m1893isSetgyyYBs(m1886applyLayerTransformation2IdBmHc);
        if (!m1893isSetgyyYBs) {
            layoutNode.m1408setOffsetFromRootgyyYBs$ui_release(IntOffset.INSTANCE.m2818getMaxnOccac());
            return;
        }
        long m2812plusqkQi6aY = IntOffset.m2812plusqkQi6aY(m1886applyLayerTransformation2IdBmHc, outerCoordinator$ui_release.getPosition());
        LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
        if (parent$ui_release != null) {
            m1893isSetgyyYBs2 = RectManagerKt.m1893isSetgyyYBs(parent$ui_release.getOffsetFromRoot());
            if (!m1893isSetgyyYBs2) {
                recalculateOffsetFromRoot(parent$ui_release);
            }
            long offsetFromRoot = parent$ui_release.getOffsetFromRoot();
            m1893isSetgyyYBs3 = RectManagerKt.m1893isSetgyyYBs(offsetFromRoot);
            if (!m1893isSetgyyYBs3) {
                m2812plusqkQi6aY = IntOffset.INSTANCE.m2818getMaxnOccac();
            } else {
                if (parent$ui_release.getOuterToInnerOffsetDirty()) {
                    outerToInnerOffset = m1887outerToInnerOffsetBjo55l4(parent$ui_release);
                    parent$ui_release.m1409setOuterToInnerOffsetgyyYBs$ui_release(outerToInnerOffset);
                    parent$ui_release.setOuterToInnerOffsetDirty$ui_release(false);
                } else {
                    outerToInnerOffset = parent$ui_release.getOuterToInnerOffset();
                }
                m1893isSetgyyYBs4 = RectManagerKt.m1893isSetgyyYBs(outerToInnerOffset);
                if (!m1893isSetgyyYBs4) {
                    m2812plusqkQi6aY = IntOffset.INSTANCE.m2818getMaxnOccac();
                } else {
                    m2812plusqkQi6aY = IntOffset.m2812plusqkQi6aY(IntOffset.m2812plusqkQi6aY(offsetFromRoot, outerToInnerOffset), m2812plusqkQi6aY);
                }
            }
        }
        layoutNode.m1408setOffsetFromRootgyyYBs$ui_release(m2812plusqkQi6aY);
    }

    private final void insertOrUpdateTransformedNode(LayoutNode layoutNode, boolean firstPlacement) {
        NodeCoordinator outerCoordinator$ui_release = layoutNode.getOuterCoordinator$ui_release();
        MeasurePassDelegate measurePassDelegate$ui_release = layoutNode.getMeasurePassDelegate$ui_release();
        int measuredWidth = measurePassDelegate$ui_release.getMeasuredWidth();
        int measuredHeight = measurePassDelegate$ui_release.getMeasuredHeight();
        MutableRect mutableRect = this.cachedRect;
        mutableRect.set(0.0f, 0.0f, measuredWidth, measuredHeight);
        boundingRectInRoot(outerCoordinator$ui_release, mutableRect);
        int left = (int) mutableRect.getLeft();
        int top = (int) mutableRect.getTop();
        int right = (int) mutableRect.getRight();
        int bottom = (int) mutableRect.getBottom();
        int semanticsId = layoutNode.getSemanticsId();
        if (firstPlacement || !this.rects.update(semanticsId, left, top, right, bottom)) {
            LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
            this.rects.insert(semanticsId, left, top, right, bottom, parent$ui_release != null ? parent$ui_release.getSemanticsId() : -1, layoutNode.getNodes().m1508hasH91voCI$ui_release(NodeKind.m1562constructorimpl(1024)), layoutNode.getNodes().m1508hasH91voCI$ui_release(NodeKind.m1562constructorimpl(16)));
        }
        invalidate();
    }

    private final void insertOrUpdate(LayoutNode layoutNode, boolean firstPlacement, int l, int t, int r, int b) {
        int semanticsId = layoutNode.getSemanticsId();
        if (firstPlacement || !this.rects.move(semanticsId, l, t, r, b)) {
            LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
            this.rects.insert(semanticsId, l, t, r, b, parent$ui_release != null ? parent$ui_release.getSemanticsId() : -1, layoutNode.getNodes().m1508hasH91voCI$ui_release(NodeKind.m1562constructorimpl(1024)), layoutNode.getNodes().m1508hasH91voCI$ui_release(NodeKind.m1562constructorimpl(16)));
        }
        invalidate();
    }

    private final void boundingRectInRoot(NodeCoordinator nodeCoordinator, MutableRect mutableRect) {
        while (nodeCoordinator != null) {
            OwnedLayer layer = nodeCoordinator.getLayer();
            if (layer != null) {
                float[] mo1618getUnderlyingMatrixsQKQjiQ = layer.mo1618getUnderlyingMatrixsQKQjiQ();
                if (!MatrixKt.isIdentity-58bKbWc(mo1618getUnderlyingMatrixsQKQjiQ)) {
                    Matrix.map-impl(mo1618getUnderlyingMatrixsQKQjiQ, mutableRect);
                }
            }
            long position = nodeCoordinator.getPosition();
            float m2808getXimpl = IntOffset.m2808getXimpl(position);
            float m2809getYimpl = IntOffset.m2809getYimpl(position);
            mutableRect.translate-k-4lQ0M(Offset.constructor-impl((Float.floatToRawIntBits(m2808getXimpl) << 32) | (Float.floatToRawIntBits(m2809getYimpl) & 4294967295L)));
            nodeCoordinator = nodeCoordinator.getWrappedBy();
        }
    }

    /* renamed from: applyLayerTransformation-2IdBmHc, reason: not valid java name */
    private final long m1886applyLayerTransformation2IdBmHc(NodeCoordinator nodeCoordinator, long j) {
        int m1892analyzeComponents58bKbWc;
        OwnedLayer layer = nodeCoordinator.getLayer();
        if (layer != null) {
            float[] mo1618getUnderlyingMatrixsQKQjiQ = layer.mo1618getUnderlyingMatrixsQKQjiQ();
            m1892analyzeComponents58bKbWc = RectManagerKt.m1892analyzeComponents58bKbWc(mo1618getUnderlyingMatrixsQKQjiQ);
            if (!(m1892analyzeComponents58bKbWc == 3)) {
                if ((m1892analyzeComponents58bKbWc & 2) == 0) {
                    return IntOffset.INSTANCE.m2818getMaxnOccac();
                }
                float m2808getXimpl = IntOffset.m2808getXimpl(j);
                return IntOffsetKt.m2825roundk4lQ0M(Matrix.map-MK-Hz9U(mo1618getUnderlyingMatrixsQKQjiQ, Offset.constructor-impl((Float.floatToRawIntBits(IntOffset.m2809getYimpl(j)) & 4294967295L) | (Float.floatToRawIntBits(m2808getXimpl) << 32))));
            }
        }
        return j;
    }

    /* renamed from: outerToInnerOffset-Bjo55l4, reason: not valid java name */
    private final long m1887outerToInnerOffsetBjo55l4(LayoutNode layoutNode) {
        NodeCoordinator outerCoordinator$ui_release = layoutNode.getOuterCoordinator$ui_release();
        long m2819getZeronOccac = IntOffset.INSTANCE.m2819getZeronOccac();
        for (NodeCoordinator innerCoordinator$ui_release = layoutNode.getInnerCoordinator$ui_release(); innerCoordinator$ui_release != null && innerCoordinator$ui_release != outerCoordinator$ui_release; innerCoordinator$ui_release = innerCoordinator$ui_release.getWrappedBy()) {
            long m1886applyLayerTransformation2IdBmHc = m1886applyLayerTransformation2IdBmHc(innerCoordinator$ui_release, m2819getZeronOccac);
            if (IntOffset.m2807equalsimpl0(m1886applyLayerTransformation2IdBmHc, IntOffset.INSTANCE.m2818getMaxnOccac())) {
                return IntOffset.INSTANCE.m2818getMaxnOccac();
            }
            m2819getZeronOccac = IntOffset.m2812plusqkQi6aY(m1886applyLayerTransformation2IdBmHc, innerCoordinator$ui_release.getPosition());
        }
        return m2819getZeronOccac;
    }

    public final void remove(LayoutNode layoutNode) {
        this.rects.remove(layoutNode.getSemanticsId());
        invalidate();
        this.isFragmented = true;
    }

    public final boolean isTargetDrawnFirst$ui_release(int targetId, int otherId) {
        LayoutNode layoutNode;
        LayoutNode parent$ui_release;
        LayoutNode layoutNode2 = (LayoutNode) this.layoutNodes.get(targetId);
        if (layoutNode2 == null || (layoutNode = (LayoutNode) this.layoutNodes.get(otherId)) == null || layoutNode2.getDepth() == 0 || layoutNode.getDepth() == 0) {
            return false;
        }
        while (layoutNode2.getDepth() > layoutNode.getDepth()) {
            layoutNode2 = layoutNode2.getParent$ui_release();
            if (layoutNode2 == null) {
                return false;
            }
        }
        if (layoutNode2 == layoutNode) {
            return false;
        }
        while (layoutNode.getDepth() > layoutNode2.getDepth()) {
            layoutNode = layoutNode.getParent$ui_release();
            if (layoutNode == null) {
                return false;
            }
        }
        if (layoutNode2 == layoutNode) {
            return false;
        }
        LayoutNode layoutNode3 = layoutNode;
        LayoutNode layoutNode4 = layoutNode3;
        LayoutNode layoutNode5 = layoutNode2;
        while (layoutNode2 != layoutNode3) {
            LayoutNode parent$ui_release2 = layoutNode2.getParent$ui_release();
            if (parent$ui_release2 == null || (parent$ui_release = layoutNode3.getParent$ui_release()) == null) {
                return false;
            }
            layoutNode5 = layoutNode2;
            layoutNode2 = parent$ui_release2;
            layoutNode4 = layoutNode3;
            layoutNode3 = parent$ui_release;
        }
        return (layoutNode5.getMeasurePassDelegate$ui_release().getZIndex() > layoutNode4.getMeasurePassDelegate$ui_release().getZIndex() ? 1 : (layoutNode5.getMeasurePassDelegate$ui_release().getZIndex() == layoutNode4.getMeasurePassDelegate$ui_release().getZIndex() ? 0 : -1)) == 0 ? layoutNode5.getPlaceOrder$ui_release() < layoutNode4.getPlaceOrder$ui_release() : layoutNode5.getMeasurePassDelegate$ui_release().getZIndex() < layoutNode4.getMeasurePassDelegate$ui_release().getZIndex();
    }

    private final void insertOrUpdateTransformedNodeSubhierarchy(LayoutNode layoutNode) {
        MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui_release();
        Object[] objArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            LayoutNode layoutNode2 = (LayoutNode) objArr[i];
            insertOrUpdateTransformedNode(layoutNode2, false);
            insertOrUpdateTransformedNodeSubhierarchy(layoutNode2);
        }
    }
}
