package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.layout.BeyondBoundsLayout;
import androidx.compose.p002ui.layout.BeyondBoundsLayoutKt;
import androidx.compose.p002ui.layout.Measurable;
import androidx.compose.p002ui.layout.MeasureResult;
import androidx.compose.p002ui.layout.MeasureScope;
import androidx.compose.p002ui.layout.Placeable;
import androidx.compose.p002ui.modifier.ModifierLocalMap;
import androidx.compose.p002ui.modifier.ModifierLocalModifierNode;
import androidx.compose.p002ui.modifier.ModifierLocalModifierNodeKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* compiled from: LazyLayoutBeyondBoundsModifierLocal.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 52\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u00015B'\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J:\u0010\u001c\u001a\u0004\u0018\u0001H\u001d\"\u0004\b\u0000\u0010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0019\u0010 \u001a\u0015\u0012\u0004\u0012\u00020\"\u0012\u0006\u0012\u0004\u0018\u0001H\u001d0!¢\u0006\u0002\b#H\u0016¢\u0006\u0004\b$\u0010%J\u0013\u0010&\u001a\u00020\n*\u00020\u001fH\u0002¢\u0006\u0004\b'\u0010(J\u001f\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002¢\u0006\u0004\b,\u0010-J\u001b\u0010.\u001a\u00020\n*\u00020*2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002¢\u0006\u0004\b/\u00100J\u0013\u00101\u001a\u00020\n*\u00020\u001fH\u0002¢\u0006\u0004\b2\u0010(J&\u00103\u001a\u0002042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u00066"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "Landroidx/compose/ui/layout/BeyondBoundsLayout;", "Landroidx/compose/ui/node/LayoutModifierNode;", "state", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsState;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "reverseLayout", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "<init>", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsState;Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;ZLandroidx/compose/foundation/gestures/Orientation;)V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "providedValues", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "getProvidedValues", "()Landroidx/compose/ui/modifier/ModifierLocalMap;", "layout", "T", "direction", "Landroidx/compose/ui/layout/BeyondBoundsLayout$LayoutDirection;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/BeyondBoundsLayout$BeyondBoundsScope;", "Lkotlin/ExtensionFunctionType;", "layout-o7g1Pn8", "(ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "isForward", "isForward-4vf7U8o", "(I)Z", "addNextInterval", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo$Interval;", "currentInterval", "addNextInterval-FR3nfPY", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo$Interval;I)Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo$Interval;", "hasMoreContent", "hasMoreContent-FR3nfPY", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo$Interval;I)Z", "isOppositeToOrientation", "isOppositeToOrientation-4vf7U8o", "update", "", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class LazyLayoutBeyondBoundsModifierNode extends Modifier.Node implements ModifierLocalModifierNode, BeyondBoundsLayout, LayoutModifierNode {
    private LazyLayoutBeyondBoundsInfo beyondBoundsInfo;
    private Orientation orientation;
    private boolean reverseLayout;
    private LazyLayoutBeyondBoundsState state;
    public static final int $stable = 8;
    private static final C0341xa5ff65d1 emptyBeyondBoundsScope = new BeyondBoundsLayout.BeyondBoundsScope() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierNode$Companion$emptyBeyondBoundsScope$1
        private final boolean hasMoreContent;

        @Override // androidx.compose.ui.layout.BeyondBoundsLayout.BeyondBoundsScope
        public boolean getHasMoreContent() {
            return this.hasMoreContent;
        }
    };

    /* compiled from: LazyLayoutBeyondBoundsModifierLocal.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            try {
                iArr[LayoutDirection.Ltr.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayoutDirection.Rtl.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public LazyLayoutBeyondBoundsModifierNode(LazyLayoutBeyondBoundsState lazyLayoutBeyondBoundsState, LazyLayoutBeyondBoundsInfo lazyLayoutBeyondBoundsInfo, boolean z, Orientation orientation) {
        this.state = lazyLayoutBeyondBoundsState;
        this.beyondBoundsInfo = lazyLayoutBeyondBoundsInfo;
        this.reverseLayout = z;
        this.orientation = orientation;
    }

    /* renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult m1274measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        final Placeable mo6318measureBRTryo0 = measurable.mo6318measureBRTryo0(j);
        return MeasureScope.layout$default(measureScope, mo6318measureBRTryo0.getWidth(), mo6318measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierNode$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit measure_3p2s80s$lambda$0;
                measure_3p2s80s$lambda$0 = LazyLayoutBeyondBoundsModifierNode.measure_3p2s80s$lambda$0(Placeable.this, (Placeable.PlacementScope) obj);
                return measure_3p2s80s$lambda$0;
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$0(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.p002ui.modifier.ModifierLocalModifierNode
    public ModifierLocalMap getProvidedValues() {
        return ModifierLocalModifierNodeKt.modifierLocalMapOf(TuplesKt.to(BeyondBoundsLayoutKt.getModifierLocalBeyondBoundsLayout(), this));
    }

    @Override // androidx.compose.p002ui.layout.BeyondBoundsLayout
    /* renamed from: layout-o7g1Pn8, reason: not valid java name */
    public <T> T mo1273layouto7g1Pn8(final int direction, Function1<? super BeyondBoundsLayout.BeyondBoundsScope, ? extends T> block) {
        int firstPlacedIndex;
        if (this.state.getItemCount() <= 0 || !this.state.getHasVisibleItems() || !getIsAttached()) {
            return (T) block.invoke(emptyBeyondBoundsScope);
        }
        if (m1271isForward4vf7U8o(direction)) {
            firstPlacedIndex = this.state.getLastPlacedIndex();
        } else {
            firstPlacedIndex = this.state.getFirstPlacedIndex();
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = this.beyondBoundsInfo.addInterval(firstPlacedIndex, firstPlacedIndex);
        int coerceAtMost = RangesKt.coerceAtMost(this.state.itemsPerViewport() * 2, this.state.getItemCount());
        T t = null;
        int i = 0;
        while (t == null && m1270hasMoreContentFR3nfPY((LazyLayoutBeyondBoundsInfo.Interval) objectRef.element, direction) && i < coerceAtMost) {
            LazyLayoutBeyondBoundsInfo.Interval m1269addNextIntervalFR3nfPY = m1269addNextIntervalFR3nfPY((LazyLayoutBeyondBoundsInfo.Interval) objectRef.element, direction);
            this.beyondBoundsInfo.removeInterval((LazyLayoutBeyondBoundsInfo.Interval) objectRef.element);
            objectRef.element = m1269addNextIntervalFR3nfPY;
            i++;
            LayoutModifierNodeKt.remeasureSync(this);
            t = (T) block.invoke(new BeyondBoundsLayout.BeyondBoundsScope() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierNode$layout$2
                @Override // androidx.compose.ui.layout.BeyondBoundsLayout.BeyondBoundsScope
                public boolean getHasMoreContent() {
                    boolean m1270hasMoreContentFR3nfPY;
                    m1270hasMoreContentFR3nfPY = LazyLayoutBeyondBoundsModifierNode.this.m1270hasMoreContentFR3nfPY((LazyLayoutBeyondBoundsInfo.Interval) objectRef.element, direction);
                    return m1270hasMoreContentFR3nfPY;
                }
            });
        }
        this.beyondBoundsInfo.removeInterval((LazyLayoutBeyondBoundsInfo.Interval) objectRef.element);
        LayoutModifierNodeKt.remeasureSync(this);
        return t;
    }

    /* renamed from: isForward-4vf7U8o, reason: not valid java name */
    private final boolean m1271isForward4vf7U8o(int i) {
        if (BeyondBoundsLayout.LayoutDirection.m6300equalsimpl0(i, BeyondBoundsLayout.LayoutDirection.INSTANCE.m6306getBeforehoxUOeE())) {
            return false;
        }
        if (!BeyondBoundsLayout.LayoutDirection.m6300equalsimpl0(i, BeyondBoundsLayout.LayoutDirection.INSTANCE.m6305getAfterhoxUOeE())) {
            if (BeyondBoundsLayout.LayoutDirection.m6300equalsimpl0(i, BeyondBoundsLayout.LayoutDirection.INSTANCE.m6304getAbovehoxUOeE())) {
                return this.reverseLayout;
            }
            if (BeyondBoundsLayout.LayoutDirection.m6300equalsimpl0(i, BeyondBoundsLayout.LayoutDirection.INSTANCE.m6307getBelowhoxUOeE())) {
                if (this.reverseLayout) {
                    return false;
                }
            } else if (BeyondBoundsLayout.LayoutDirection.m6300equalsimpl0(i, BeyondBoundsLayout.LayoutDirection.INSTANCE.m6308getLefthoxUOeE())) {
                int i2 = WhenMappings.$EnumSwitchMapping$0[DelegatableNodeKt.requireLayoutDirection(this).ordinal()];
                if (i2 == 1) {
                    return this.reverseLayout;
                }
                if (i2 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                if (this.reverseLayout) {
                    return false;
                }
            } else if (BeyondBoundsLayout.LayoutDirection.m6300equalsimpl0(i, BeyondBoundsLayout.LayoutDirection.INSTANCE.m6309getRighthoxUOeE())) {
                int i3 = WhenMappings.$EnumSwitchMapping$0[DelegatableNodeKt.requireLayoutDirection(this).ordinal()];
                if (i3 != 1) {
                    if (i3 != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    return this.reverseLayout;
                }
                if (this.reverseLayout) {
                    return false;
                }
            } else {
                LazyLayoutBeyondBoundsModifierLocalKt.access$unsupportedDirection();
                throw new KotlinNothingValueException();
            }
        }
        return true;
    }

    /* renamed from: addNextInterval-FR3nfPY, reason: not valid java name */
    private final LazyLayoutBeyondBoundsInfo.Interval m1269addNextIntervalFR3nfPY(LazyLayoutBeyondBoundsInfo.Interval currentInterval, int direction) {
        int start = currentInterval.getStart();
        int end = currentInterval.getEnd();
        if (m1271isForward4vf7U8o(direction)) {
            end++;
        } else {
            start--;
        }
        return this.beyondBoundsInfo.addInterval(start, end);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: hasMoreContent-FR3nfPY, reason: not valid java name */
    public final boolean m1270hasMoreContentFR3nfPY(LazyLayoutBeyondBoundsInfo.Interval interval, int i) {
        if (m1272isOppositeToOrientation4vf7U8o(i)) {
            return false;
        }
        if (m1271isForward4vf7U8o(i)) {
            if (interval.getEnd() >= this.state.getItemCount() - 1) {
                return false;
            }
        } else if (interval.getStart() <= 0) {
            return false;
        }
        return true;
    }

    /* renamed from: isOppositeToOrientation-4vf7U8o, reason: not valid java name */
    private final boolean m1272isOppositeToOrientation4vf7U8o(int i) {
        if (BeyondBoundsLayout.LayoutDirection.m6300equalsimpl0(i, BeyondBoundsLayout.LayoutDirection.INSTANCE.m6304getAbovehoxUOeE()) || BeyondBoundsLayout.LayoutDirection.m6300equalsimpl0(i, BeyondBoundsLayout.LayoutDirection.INSTANCE.m6307getBelowhoxUOeE())) {
            if (this.orientation == Orientation.Horizontal) {
                return true;
            }
        } else if (BeyondBoundsLayout.LayoutDirection.m6300equalsimpl0(i, BeyondBoundsLayout.LayoutDirection.INSTANCE.m6308getLefthoxUOeE()) || BeyondBoundsLayout.LayoutDirection.m6300equalsimpl0(i, BeyondBoundsLayout.LayoutDirection.INSTANCE.m6309getRighthoxUOeE())) {
            if (this.orientation == Orientation.Vertical) {
                return true;
            }
        } else if (!BeyondBoundsLayout.LayoutDirection.m6300equalsimpl0(i, BeyondBoundsLayout.LayoutDirection.INSTANCE.m6306getBeforehoxUOeE()) && !BeyondBoundsLayout.LayoutDirection.m6300equalsimpl0(i, BeyondBoundsLayout.LayoutDirection.INSTANCE.m6305getAfterhoxUOeE())) {
            LazyLayoutBeyondBoundsModifierLocalKt.access$unsupportedDirection();
            throw new KotlinNothingValueException();
        }
        return false;
    }

    public final void update(LazyLayoutBeyondBoundsState state, LazyLayoutBeyondBoundsInfo beyondBoundsInfo, boolean reverseLayout, Orientation orientation) {
        this.state = state;
        this.beyondBoundsInfo = beyondBoundsInfo;
        this.reverseLayout = reverseLayout;
        this.orientation = orientation;
    }
}
