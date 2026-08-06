package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.p002ui.graphics.GraphicsContext;
import androidx.compose.p002ui.layout.MeasureScope;
import androidx.compose.p002ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSize;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: LazyStaggeredGridMeasure.kt */
@Metadata(d1 = {"\u0000¬\u0001\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\u001a5\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00030\u0007¢\u0006\u0002\b\bH\u0082\b¢\u0006\u0002\u0010\t\u001a\u001d\u0010\n\u001a\u00020\u000b*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fH\u0002¢\u0006\u0002\u0010\u000f\u001a\u0017\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013H\u0082\b\u001a£\u0001\u0010\u0014\u001a\u00020\u0015*\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u00012\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u000200H\u0000¢\u0006\u0004\b1\u00102\u001a,\u00103\u001a\u00020\u0015*\u0002042\u0006\u00105\u001a\u00020\u001a2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u00020\u0001H\u0002\u001aK\u0010:\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0019*\u0002042\u0012\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f2\u0006\u0010<\u001a\u0002072\u0006\u0010=\u001a\u00020\u001a2\u0006\u0010>\u001a\u00020\u001a2\u0006\u0010?\u001a\u00020\u001aH\u0002¢\u0006\u0002\u0010@\u001aG\u0010A\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0019*\u0002042\u0006\u0010B\u001a\u00020\u001a2\u0006\u0010C\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\u00012\u0018\u0010D\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00110EH\u0082\b\u001aR\u0010F\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0019*\u0002042\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00110\u00072!\u0010G\u001a\u001d\u0012\u0013\u0012\u00110\u001a¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(J\u0012\u0004\u0012\u00020\u00010\u00072\u0006\u0010K\u001a\u00020\u0001H\u0082\b\u001a7\u0010L\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00192\b\b\u0002\u0010M\u001a\u00020\u00012\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u00110\u0007H\u0082\b\u001a(\u0010O\u001a\u00020\u0011*\u00020P2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00110\u0007H\u0082\b¢\u0006\u0004\bQ\u0010R\u001a\u0014\u0010S\u001a\u00020\u0011*\u0002072\u0006\u0010T\u001a\u00020\u001aH\u0002\u001a\u001b\u0010U\u001a\u00020\u001a*\u0002072\u0006\u0010V\u001a\u00020PH\u0002¢\u0006\u0004\bW\u0010X\u001a\u0016\u0010Y\u001a\u00020\u001a*\u0002072\b\b\u0002\u0010Z\u001a\u00020\u001aH\u0000\u001a2\u0010[\u001a\u00020\u001a\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\f2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u001a0\u0007H\u0082\b¢\u0006\u0002\u0010\\\u001a\f\u0010]\u001a\u00020\u001a*\u000207H\u0002\u001a!\u0010^\u001a\u000207*\u0002072\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0\u0007H\u0082\b\u001a\u001c\u0010_\u001a\u00020\u0011*\u0002042\u0006\u0010`\u001a\u0002072\u0006\u0010a\u001a\u00020\u001aH\u0002\u001a\u001c\u0010b\u001a\u00020\u001a*\u0002042\u0006\u0010c\u001a\u00020\u001a2\u0006\u0010d\u001a\u00020\u001aH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010e\u001a\u00020\u001aX\u0082T¢\u0006\u0002\n\u0000¨\u0006f"}, d2 = {"DebugLoggingEnabled", "", "withDebugLogging", "T", "scope", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "debugRender", "", "", "Lkotlin/collections/ArrayDeque;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "([Lkotlin/collections/ArrayDeque;)Ljava/lang/String;", "debugLog", "", "message", "Lkotlin/Function0;", "measureStaggeredGrid", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "pinnedItems", "", "", "itemProvider", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;", "resolvedSlots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "isVertical", "reverseLayout", "contentOffset", "Landroidx/compose/ui/unit/IntOffset;", "mainAxisAvailableSize", "mainAxisSpacing", "beforeContentPadding", "afterContentPadding", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "isInLookaheadScope", "isLookingAhead", "approachLayoutInfo", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "measureStaggeredGrid-C6celF4", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Ljava/util/List;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;JZZJIIIILkotlinx/coroutines/CoroutineScope;ZZLandroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;Landroidx/compose/ui/graphics/GraphicsContext;)Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "measure", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;", "initialScrollDelta", "initialItemIndices", "", "initialItemOffsets", "canRestartMeasure", "calculateVisibleItems", "measuredItems", "itemScrollOffsets", "mainAxisLayoutSize", "minOffset", "maxOffset", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;[Lkotlin/collections/ArrayDeque;[IIII)Ljava/util/List;", "itemsRetainedForLookahead", "lastVisibleItemIndex", "itemsCount", "position", "Lkotlin/Function2;", "calculateExtraItems", "filter", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "itemIndex", "beforeVisibleBounds", "fastForEach", "reverse", "action", "forEach", "Landroidx/compose/foundation/lazy/staggeredgrid/SpanRange;", "forEach-nIS5qE8", "(JLkotlin/jvm/functions/Function1;)V", "offsetBy", "delta", "maxInRange", "indexRange", "maxInRange-jy6DScQ", "([IJ)I", "indexOfMinValue", "minBound", "indexOfMinBy", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)I", "indexOfMaxValue", "transform", "ensureIndicesInRange", "indices", "itemCount", "findPreviousItemIndex", "item", "lane", "Unset", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class LazyStaggeredGridMeasureKt {
    private static final boolean DebugLoggingEnabled = false;
    private static final int Unset = Integer.MIN_VALUE;

    private static final void debugLog(Function0<String> function0) {
    }

    private static final String debugRender(ArrayDeque<LazyStaggeredGridMeasuredItem>[] arrayDequeArr) {
        return "";
    }

    private static final <T> T withDebugLogging(LazyLayoutMeasureScope lazyLayoutMeasureScope, Function1<? super LazyLayoutMeasureScope, ? extends T> function1) {
        return (T) function1.invoke(lazyLayoutMeasureScope);
    }

    /* renamed from: measureStaggeredGrid-C6celF4, reason: not valid java name */
    public static final LazyStaggeredGridMeasureResult m1372measureStaggeredGridC6celF4(LazyLayoutMeasureScope lazyLayoutMeasureScope, LazyStaggeredGridState lazyStaggeredGridState, List<Integer> list, LazyStaggeredGridItemProvider lazyStaggeredGridItemProvider, LazyStaggeredGridSlots lazyStaggeredGridSlots, long j, boolean z, boolean z2, long j2, int i, int i2, int i3, int i4, CoroutineScope coroutineScope, boolean z3, boolean z4, LazyStaggeredGridLayoutInfo lazyStaggeredGridLayoutInfo, GraphicsContext graphicsContext) {
        boolean z5;
        int i5;
        int m1371maxInRangejy6DScQ;
        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext = new LazyStaggeredGridMeasureContext(lazyStaggeredGridState, list, lazyStaggeredGridItemProvider, lazyStaggeredGridSlots, j, z, lazyLayoutMeasureScope, i, j2, i3, i4, z2, i2, coroutineScope, z3, z4, lazyStaggeredGridLayoutInfo, graphicsContext, null);
        int[] updateScrollPositionIfTheFirstItemWasMoved$foundation_release = lazyStaggeredGridState.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(lazyStaggeredGridItemProvider, lazyStaggeredGridState.getScrollPosition().getIndices());
        int[] scrollOffsets = lazyStaggeredGridState.getScrollPosition().getScrollOffsets();
        if (updateScrollPositionIfTheFirstItemWasMoved$foundation_release.length != lazyStaggeredGridMeasureContext.getLaneCount()) {
            lazyStaggeredGridMeasureContext.getLaneInfo().reset();
            int laneCount = lazyStaggeredGridMeasureContext.getLaneCount();
            int[] iArr = new int[laneCount];
            int i6 = 0;
            while (i6 < laneCount) {
                if (i6 >= updateScrollPositionIfTheFirstItemWasMoved$foundation_release.length || (m1371maxInRangejy6DScQ = updateScrollPositionIfTheFirstItemWasMoved$foundation_release[i6]) == -1) {
                    m1371maxInRangejy6DScQ = i6 == 0 ? 0 : m1371maxInRangejy6DScQ(iArr, SpanRange.m1383constructorimpl(0, i6)) + 1;
                }
                iArr[i6] = m1371maxInRangejy6DScQ;
                lazyStaggeredGridMeasureContext.getLaneInfo().setLane(iArr[i6], i6);
                i6++;
            }
            updateScrollPositionIfTheFirstItemWasMoved$foundation_release = iArr;
        }
        if (scrollOffsets.length == lazyStaggeredGridMeasureContext.getLaneCount()) {
            z5 = z4;
        } else {
            int laneCount2 = lazyStaggeredGridMeasureContext.getLaneCount();
            int[] iArr2 = new int[laneCount2];
            int i7 = 0;
            while (i7 < laneCount2) {
                if (i7 < scrollOffsets.length) {
                    i5 = scrollOffsets[i7];
                } else {
                    i5 = i7 == 0 ? 0 : iArr2[i7 - 1];
                }
                iArr2[i7] = i5;
                i7++;
            }
            z5 = z4;
            scrollOffsets = iArr2;
        }
        return measure(lazyStaggeredGridMeasureContext, Math.round(lazyStaggeredGridState.scrollToBeConsumed$foundation_release(z5)), updateScrollPositionIfTheFirstItemWasMoved$foundation_release, scrollOffsets, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:309:0x05ab, code lost:
    
        if ((r0 != null ? r0.getIndex() : -1) > r2) goto L313;
     */
    /* JADX WARN: Removed duplicated region for block: B:360:0x06ec  */
    /* JADX WARN: Removed duplicated region for block: B:378:0x0763 A[LOOP:24: B:346:0x06bd->B:378:0x0763, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:379:0x0771 A[EDGE_INSN: B:379:0x0771->B:380:0x0771 BREAK  A[LOOP:24: B:346:0x06bd->B:378:0x0763], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:382:0x0782  */
    /* JADX WARN: Removed duplicated region for block: B:410:0x07d4  */
    /* JADX WARN: Removed duplicated region for block: B:436:0x084f  */
    /* JADX WARN: Removed duplicated region for block: B:439:0x0867  */
    /* JADX WARN: Removed duplicated region for block: B:442:0x08bf  */
    /* JADX WARN: Removed duplicated region for block: B:458:0x0932  */
    /* JADX WARN: Removed duplicated region for block: B:466:0x0947  */
    /* JADX WARN: Removed duplicated region for block: B:484:0x0944 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:494:0x075d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final LazyStaggeredGridMeasureResult measure(final LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int i, int[] iArr, int[] iArr2, boolean z) {
        int i2;
        ArrayDeque[] arrayDequeArr;
        int i3;
        LazyLayoutMeasureScope lazyLayoutMeasureScope;
        int i4;
        int i5;
        boolean z2;
        int i6;
        int i7;
        int i8;
        int[] iArr3;
        boolean z3;
        boolean z4;
        int[] iArr4;
        int i9;
        int i10;
        int[] iArr5;
        int[] iArr6;
        int i11;
        int i12;
        int i13;
        int i14;
        int[] iArr7;
        int i15;
        List list;
        int i16;
        int[] iArr8;
        int i17;
        ArrayList arrayList;
        int size;
        int i18;
        ArrayList arrayList2;
        int i19;
        int i20;
        int i21;
        int i22;
        boolean z5;
        boolean z6;
        boolean z7;
        List<Integer> list2;
        int i23;
        boolean z8;
        int[] iArr9;
        boolean z9;
        boolean z10;
        int i24;
        int[] iArr10;
        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo;
        int index;
        int min;
        boolean z11;
        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo2;
        boolean z12;
        boolean z13;
        int i25;
        boolean z14;
        int i26;
        boolean z15;
        int i27;
        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext2 = lazyStaggeredGridMeasureContext;
        int i28 = i;
        LazyLayoutMeasureScope measureScope = lazyStaggeredGridMeasureContext.getMeasureScope();
        int itemCount = lazyStaggeredGridMeasureContext.getItemProvider().getItemCount();
        if (itemCount <= 0 || lazyStaggeredGridMeasureContext.getLaneCount() == 0) {
            int i29 = Constraints.getMinWidth-impl(lazyStaggeredGridMeasureContext.getConstraints());
            int i30 = Constraints.getMinHeight-impl(lazyStaggeredGridMeasureContext.getConstraints());
            lazyStaggeredGridMeasureContext.getState().getItemAnimator$foundation_release().onMeasured(0, i29, i30, new ArrayList(), lazyStaggeredGridMeasureContext.getMeasuredItemProvider().getKeyIndexMap(), lazyStaggeredGridMeasureContext.getMeasuredItemProvider(), lazyStaggeredGridMeasureContext.getIsVertical(), measureScope.isLookingAhead(), lazyStaggeredGridMeasureContext.getLaneCount(), lazyStaggeredGridMeasureContext.getIsInLookaheadScope(), 0, 0, lazyStaggeredGridMeasureContext.getCoroutineScope(), lazyStaggeredGridMeasureContext.getGraphicsContext());
            if (!measureScope.isLookingAhead()) {
                long m1289getMinSizeToFitDisappearingItemsYbymL2g = lazyStaggeredGridMeasureContext.getState().getItemAnimator$foundation_release().m1289getMinSizeToFitDisappearingItemsYbymL2g();
                if (!IntSize.equals-impl0(m1289getMinSizeToFitDisappearingItemsYbymL2g, IntSize.Companion.getZero-YbymL2g())) {
                    i29 = ConstraintsKt.constrainWidth-K40F9xA(lazyStaggeredGridMeasureContext.getConstraints(), (int) (m1289getMinSizeToFitDisappearingItemsYbymL2g >> 32));
                    i30 = ConstraintsKt.constrainHeight-K40F9xA(lazyStaggeredGridMeasureContext.getConstraints(), (int) (m1289getMinSizeToFitDisappearingItemsYbymL2g & 4294967295L));
                }
            }
            return new LazyStaggeredGridMeasureResult(iArr, iArr2, 0.0f, MeasureScope.layout$default(measureScope, i29, i30, null, new Function1() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    Unit measure$lambda$49$lambda$4;
                    measure$lambda$49$lambda$4 = LazyStaggeredGridMeasureKt.measure$lambda$49$lambda$4((Placeable.PlacementScope) obj);
                    return measure$lambda$49$lambda$4;
                }
            }, 4, null), 0.0f, false, lazyStaggeredGridMeasureContext.getIsVertical(), false, lazyStaggeredGridMeasureContext.getResolvedSlots(), lazyStaggeredGridMeasureContext.getItemProvider().getSpanProvider(), measureScope, itemCount, CollectionsKt.emptyList(), IntSize.constructor-impl((Constraints.getMinWidth-impl(lazyStaggeredGridMeasureContext.getConstraints()) << 32) | (Constraints.getMinHeight-impl(lazyStaggeredGridMeasureContext.getConstraints()) & 4294967295L)), -lazyStaggeredGridMeasureContext.getBeforeContentPadding(), lazyStaggeredGridMeasureContext.getMainAxisAvailableSize() + lazyStaggeredGridMeasureContext.getAfterContentPadding(), lazyStaggeredGridMeasureContext.getBeforeContentPadding(), lazyStaggeredGridMeasureContext.getAfterContentPadding(), lazyStaggeredGridMeasureContext.getMainAxisSpacing(), lazyStaggeredGridMeasureContext.getCoroutineScope(), null);
        }
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        String str = "copyOf(...)";
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        int[] copyOf2 = Arrays.copyOf(iArr2, iArr2.length);
        Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(...)");
        ensureIndicesInRange(lazyStaggeredGridMeasureContext2, copyOf, itemCount);
        offsetBy(copyOf2, -i28);
        int laneCount = lazyStaggeredGridMeasureContext.getLaneCount();
        ArrayDeque[] arrayDequeArr2 = new ArrayDeque[laneCount];
        for (int i31 = 0; i31 < laneCount; i31++) {
            arrayDequeArr2[i31] = new ArrayDeque(16);
        }
        offsetBy(copyOf2, -lazyStaggeredGridMeasureContext.getBeforeContentPadding());
        boolean z16 = false;
        while (true) {
            if (!measure$lambda$49$hasSpaceBeforeFirst(copyOf, copyOf2, lazyStaggeredGridMeasureContext2)) {
                i2 = laneCount;
                arrayDequeArr = arrayDequeArr2;
                i3 = itemCount;
                lazyLayoutMeasureScope = measureScope;
                i4 = -1;
                break;
            }
            i4 = indexOfMaxValue(copyOf);
            int i32 = copyOf[i4];
            int length = copyOf2.length;
            for (int i33 = 0; i33 < length; i33++) {
                if (copyOf[i33] != copyOf[i4]) {
                    int i34 = copyOf2[i33];
                    int i35 = copyOf2[i4];
                    if (i34 < i35) {
                        copyOf2[i33] = i35;
                    }
                }
            }
            int findPreviousItemIndex = findPreviousItemIndex(lazyStaggeredGridMeasureContext2, i32, i4);
            if (findPreviousItemIndex < 0) {
                i2 = laneCount;
                arrayDequeArr = arrayDequeArr2;
                i3 = itemCount;
                lazyLayoutMeasureScope = measureScope;
                break;
            }
            long m1367getSpanRangelOCCd4c = lazyStaggeredGridMeasureContext2.m1367getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext.getItemProvider(), findPreviousItemIndex, i4);
            int i36 = itemCount;
            LazyLayoutMeasureScope lazyLayoutMeasureScope2 = measureScope;
            int i37 = (int) (m1367getSpanRangelOCCd4c & 4294967295L);
            int i38 = laneCount;
            ArrayDeque[] arrayDequeArr3 = arrayDequeArr2;
            int i39 = (int) (m1367getSpanRangelOCCd4c >> 32);
            int i40 = i37 - i39;
            lazyStaggeredGridMeasureContext.getLaneInfo().setLane(findPreviousItemIndex, i40 != 1 ? -2 : i39);
            LazyStaggeredGridMeasuredItem m1375getAndMeasurejy6DScQ = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m1375getAndMeasurejy6DScQ(findPreviousItemIndex, m1367getSpanRangelOCCd4c);
            int m1371maxInRangejy6DScQ = m1371maxInRangejy6DScQ(copyOf2, m1367getSpanRangelOCCd4c);
            int[] gaps = i40 != 1 ? lazyStaggeredGridMeasureContext.getLaneInfo().getGaps(findPreviousItemIndex) : null;
            while (i39 < i37) {
                copyOf[i39] = findPreviousItemIndex;
                int mainAxisSizeWithSpacings = m1375getAndMeasurejy6DScQ.getMainAxisSizeWithSpacings() + m1371maxInRangejy6DScQ + (gaps == null ? 0 : gaps[i39]);
                copyOf2[i39] = mainAxisSizeWithSpacings;
                if (lazyStaggeredGridMeasureContext.getMainAxisAvailableSize() + mainAxisSizeWithSpacings <= 0) {
                    z16 = true;
                }
                i39++;
            }
            laneCount = i38;
            arrayDequeArr2 = arrayDequeArr3;
            measureScope = lazyLayoutMeasureScope2;
            itemCount = i36;
        }
        int i41 = -lazyStaggeredGridMeasureContext.getBeforeContentPadding();
        int i42 = copyOf2[0];
        if (i42 < i41) {
            offsetBy(copyOf2, i41 - i42);
            i28 -= i41 - i42;
        }
        offsetBy(copyOf2, lazyStaggeredGridMeasureContext.getBeforeContentPadding());
        int i43 = -1;
        if (i4 == -1) {
            i4 = ArraysKt.indexOf(copyOf, 0);
        }
        if (i4 != -1 && measure$lambda$49$misalignedStart(copyOf, lazyStaggeredGridMeasureContext2, copyOf2, i4) && z) {
            lazyStaggeredGridMeasureContext.getLaneInfo().reset();
            int length2 = copyOf.length;
            int[] iArr11 = new int[length2];
            int i44 = 0;
            while (i44 < length2) {
                iArr11[i44] = i43;
                i44++;
                i43 = -1;
            }
            int length3 = copyOf2.length;
            int[] iArr12 = new int[length3];
            for (int i45 = 0; i45 < length3; i45++) {
                iArr12[i45] = copyOf2[i4];
            }
            return measure(lazyStaggeredGridMeasureContext2, i28, iArr11, iArr12, false);
        }
        int[] copyOf3 = Arrays.copyOf(copyOf, copyOf.length);
        Intrinsics.checkNotNullExpressionValue(copyOf3, "copyOf(...)");
        int length4 = copyOf2.length;
        int[] iArr13 = new int[length4];
        for (int i46 = 0; i46 < length4; i46++) {
            iArr13[i46] = -copyOf2[i46];
        }
        int mainAxisSpacing = i41 + lazyStaggeredGridMeasureContext.getMainAxisSpacing();
        int coerceAtLeast = RangesKt.coerceAtLeast(lazyStaggeredGridMeasureContext.getMainAxisAvailableSize() + lazyStaggeredGridMeasureContext.getAfterContentPadding(), 0);
        boolean z17 = z16;
        int indexOfMinValue$default = indexOfMinValue$default(copyOf3, 0, 1, null);
        int i47 = 0;
        while (indexOfMinValue$default != -1 && i47 < lazyStaggeredGridMeasureContext.getLaneCount()) {
            int i48 = copyOf3[indexOfMinValue$default];
            int indexOfMinValue = indexOfMinValue(copyOf3, i48);
            i47++;
            if (i48 >= 0) {
                long m1367getSpanRangelOCCd4c2 = lazyStaggeredGridMeasureContext2.m1367getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext.getItemProvider(), i48, indexOfMinValue$default);
                int i49 = i41;
                LazyStaggeredGridMeasuredItem m1375getAndMeasurejy6DScQ2 = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m1375getAndMeasurejy6DScQ(i48, m1367getSpanRangelOCCd4c2);
                String str2 = str;
                int i50 = i2;
                int[] iArr14 = copyOf;
                int i51 = (int) (m1367getSpanRangelOCCd4c2 & 4294967295L);
                int i52 = coerceAtLeast;
                int[] iArr15 = copyOf2;
                int i53 = (int) (m1367getSpanRangelOCCd4c2 >> 32);
                int i54 = i51 - i53;
                lazyStaggeredGridMeasureContext.getLaneInfo().setLane(i48, i54 != 1 ? -2 : i53);
                int m1371maxInRangejy6DScQ2 = m1371maxInRangejy6DScQ(iArr13, m1367getSpanRangelOCCd4c2);
                for (int i55 = i53; i55 < i51; i55++) {
                    iArr13[i55] = m1375getAndMeasurejy6DScQ2.getMainAxisSizeWithSpacings() + m1371maxInRangejy6DScQ2;
                    copyOf3[i55] = i48;
                    arrayDequeArr[i55].addLast(m1375getAndMeasurejy6DScQ2);
                }
                if (m1371maxInRangejy6DScQ2 >= mainAxisSpacing || iArr13[i53] > mainAxisSpacing) {
                    i27 = 1;
                } else {
                    m1375getAndMeasurejy6DScQ2.setVisible(false);
                    i27 = 1;
                    z17 = true;
                }
                i47 = i54 != i27 ? lazyStaggeredGridMeasureContext.getLaneCount() : i47;
                coerceAtLeast = i52;
                indexOfMinValue$default = indexOfMinValue;
                i41 = i49;
                str = str2;
                i2 = i50;
                copyOf = iArr14;
                copyOf2 = iArr15;
            } else {
                indexOfMinValue$default = indexOfMinValue;
            }
        }
        String str3 = str;
        int i56 = i41;
        int i57 = i2;
        int[] iArr16 = copyOf;
        int i58 = coerceAtLeast;
        int[] iArr17 = copyOf2;
        while (true) {
            int i59 = 0;
            while (true) {
                if (i59 >= length4) {
                    i5 = i58;
                    z2 = false;
                    break;
                }
                int i60 = iArr13[i59];
                i5 = i58;
                if (i60 < i5 || i60 <= 0) {
                    z2 = true;
                    break;
                }
                i59++;
                i58 = i5;
            }
            i6 = i57;
            if (!z2) {
                int i61 = 0;
                while (true) {
                    if (i61 >= i6) {
                        z15 = true;
                        break;
                    }
                    if (!arrayDequeArr[i61].isEmpty()) {
                        z15 = false;
                        break;
                    }
                    i61++;
                }
                if (!z15) {
                    i8 = i3;
                    i7 = 1;
                    break;
                }
            }
            i7 = 1;
            int indexOfMinValue$default2 = indexOfMinValue$default(iArr13, 0, 1, null);
            int maxOrThrow = ArraysKt.maxOrThrow(copyOf3) + 1;
            i8 = i3;
            if (maxOrThrow >= i8) {
                break;
            }
            int i62 = i5;
            int[] iArr18 = copyOf3;
            int[] iArr19 = iArr13;
            String str4 = str3;
            LazyLayoutMeasureScope lazyLayoutMeasureScope3 = lazyLayoutMeasureScope;
            int[] iArr20 = iArr17;
            LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext3 = lazyStaggeredGridMeasureContext2;
            int i63 = length4;
            int[] iArr21 = iArr16;
            long m1367getSpanRangelOCCd4c3 = lazyStaggeredGridMeasureContext3.m1367getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext.getItemProvider(), maxOrThrow, indexOfMinValue$default2);
            int i64 = (int) (m1367getSpanRangelOCCd4c3 & 4294967295L);
            int i65 = (int) (m1367getSpanRangelOCCd4c3 >> 32);
            int i66 = i64 - i65;
            lazyStaggeredGridMeasureContext.getLaneInfo().setLane(maxOrThrow, i66 != 1 ? -2 : i65);
            LazyStaggeredGridMeasuredItem m1375getAndMeasurejy6DScQ3 = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m1375getAndMeasurejy6DScQ(maxOrThrow, m1367getSpanRangelOCCd4c3);
            iArr13 = iArr19;
            int m1371maxInRangejy6DScQ3 = m1371maxInRangejy6DScQ(iArr13, m1367getSpanRangelOCCd4c3);
            if (i66 != 1) {
                iArr3 = lazyStaggeredGridMeasureContext.getLaneInfo().getGaps(maxOrThrow);
                if (iArr3 == null) {
                    iArr3 = new int[lazyStaggeredGridMeasureContext.getLaneCount()];
                }
            } else {
                iArr3 = null;
            }
            for (int i67 = i65; i67 < i64; i67++) {
                if (iArr3 != null) {
                    iArr3[i67] = m1371maxInRangejy6DScQ3 - iArr13[i67];
                }
                iArr18[i67] = maxOrThrow;
                iArr13[i67] = m1371maxInRangejy6DScQ3 + m1375getAndMeasurejy6DScQ3.getMainAxisSizeWithSpacings();
                arrayDequeArr[i67].addLast(m1375getAndMeasurejy6DScQ3);
            }
            lazyStaggeredGridMeasureContext.getLaneInfo().setGaps(maxOrThrow, iArr3);
            if (m1371maxInRangejy6DScQ3 < mainAxisSpacing && iArr13[i65] <= mainAxisSpacing) {
                m1375getAndMeasurejy6DScQ3.setVisible(false);
            }
            iArr17 = iArr20;
            i57 = i6;
            lazyStaggeredGridMeasureContext2 = lazyStaggeredGridMeasureContext3;
            lazyLayoutMeasureScope = lazyLayoutMeasureScope3;
            copyOf3 = iArr18;
            str3 = str4;
            length4 = i63;
            i58 = i62;
            i3 = i8;
            iArr16 = iArr21;
        }
        int i68 = 0;
        while (i68 < i6) {
            ArrayDeque arrayDeque = arrayDequeArr[i68];
            while (arrayDeque.size() > i7 && !((LazyStaggeredGridMeasuredItem) arrayDeque.first()).getIsVisible()) {
                LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem = (LazyStaggeredGridMeasuredItem) arrayDeque.removeFirst();
                int[] gaps2 = lazyStaggeredGridMeasuredItem.getSpan() != i7 ? lazyStaggeredGridMeasureContext.getLaneInfo().getGaps(lazyStaggeredGridMeasuredItem.getIndex()) : null;
                iArr17[i68] = iArr17[i68] - (lazyStaggeredGridMeasuredItem.getMainAxisSizeWithSpacings() + (gaps2 == null ? 0 : gaps2[i68]));
                i7 = 1;
            }
            LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem2 = (LazyStaggeredGridMeasuredItem) arrayDeque.firstOrNull();
            iArr16[i68] = lazyStaggeredGridMeasuredItem2 != null ? lazyStaggeredGridMeasuredItem2.getIndex() : -1;
            i68++;
            i7 = 1;
        }
        int length5 = copyOf3.length;
        int i69 = 0;
        while (true) {
            if (i69 >= length5) {
                z3 = false;
                break;
            }
            if (copyOf3[i69] == i8 + (-1)) {
                z3 = true;
                break;
            }
            i69++;
        }
        if (z3) {
            offsetBy(iArr13, -lazyStaggeredGridMeasureContext.getMainAxisSpacing());
        }
        int i70 = 0;
        while (true) {
            if (i70 >= length4) {
                z4 = true;
                break;
            }
            if (!(iArr13[i70] < lazyStaggeredGridMeasureContext.getMainAxisAvailableSize())) {
                z4 = false;
                break;
            }
            i70++;
        }
        if (z4) {
            int mainAxisAvailableSize = lazyStaggeredGridMeasureContext.getMainAxisAvailableSize() - iArr13[indexOfMaxValue(iArr13)];
            iArr6 = iArr17;
            offsetBy(iArr6, -mainAxisAvailableSize);
            offsetBy(iArr13, mainAxisAvailableSize);
            boolean z18 = false;
            while (true) {
                int length6 = iArr6.length;
                int i71 = 0;
                while (true) {
                    if (i71 >= length6) {
                        z14 = false;
                        break;
                    }
                    if (iArr6[i71] < lazyStaggeredGridMeasureContext.getBeforeContentPadding()) {
                        z14 = true;
                        break;
                    }
                    i71++;
                }
                if (!z14) {
                    i26 = mainAxisAvailableSize;
                    iArr4 = copyOf3;
                    i9 = length4;
                    i10 = i8;
                    iArr5 = iArr16;
                    break;
                }
                int indexOfMinValue$default3 = indexOfMinValue$default(iArr6, 0, 1, null);
                int indexOfMaxValue = indexOfMaxValue(iArr16);
                if (indexOfMinValue$default3 != indexOfMaxValue) {
                    if (iArr6[indexOfMinValue$default3] == iArr6[indexOfMaxValue]) {
                        indexOfMinValue$default3 = indexOfMaxValue;
                    } else {
                        z18 = true;
                    }
                }
                int i72 = iArr16[indexOfMinValue$default3];
                if (i72 == -1) {
                    i72 = i8;
                }
                int findPreviousItemIndex2 = findPreviousItemIndex(lazyStaggeredGridMeasureContext2, i72, indexOfMinValue$default3);
                if (findPreviousItemIndex2 < 0) {
                    iArr5 = iArr16;
                    if ((z18 || measure$lambda$49$misalignedStart(iArr5, lazyStaggeredGridMeasureContext2, iArr6, indexOfMinValue$default3)) && z) {
                        lazyStaggeredGridMeasureContext.getLaneInfo().reset();
                        int length7 = iArr5.length;
                        int[] iArr22 = new int[length7];
                        for (int i73 = 0; i73 < length7; i73++) {
                            iArr22[i73] = -1;
                        }
                        int length8 = iArr6.length;
                        int[] iArr23 = new int[length8];
                        for (int i74 = 0; i74 < length8; i74++) {
                            iArr23[i74] = iArr6[indexOfMinValue$default3];
                        }
                        return measure(lazyStaggeredGridMeasureContext2, i28, iArr22, iArr23, false);
                    }
                    i26 = mainAxisAvailableSize;
                    iArr4 = copyOf3;
                    i9 = length4;
                    i10 = i8;
                } else {
                    int[] iArr24 = iArr16;
                    int[] iArr25 = copyOf3;
                    int i75 = length4;
                    long m1367getSpanRangelOCCd4c4 = lazyStaggeredGridMeasureContext2.m1367getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext.getItemProvider(), findPreviousItemIndex2, indexOfMinValue$default3);
                    int i76 = i8;
                    int i77 = (int) (m1367getSpanRangelOCCd4c4 & 4294967295L);
                    boolean z19 = z18;
                    int i78 = mainAxisAvailableSize;
                    int i79 = (int) (m1367getSpanRangelOCCd4c4 >> 32);
                    int i80 = i77 - i79;
                    lazyStaggeredGridMeasureContext.getLaneInfo().setLane(findPreviousItemIndex2, i80 != 1 ? -2 : i79);
                    LazyStaggeredGridMeasuredItem m1375getAndMeasurejy6DScQ4 = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m1375getAndMeasurejy6DScQ(findPreviousItemIndex2, m1367getSpanRangelOCCd4c4);
                    int m1371maxInRangejy6DScQ4 = m1371maxInRangejy6DScQ(iArr6, m1367getSpanRangelOCCd4c4);
                    int[] gaps3 = i80 != 1 ? lazyStaggeredGridMeasureContext.getLaneInfo().getGaps(findPreviousItemIndex2) : null;
                    boolean z20 = z19;
                    while (i79 < i77) {
                        if (iArr6[i79] != m1371maxInRangejy6DScQ4) {
                            z20 = true;
                        }
                        arrayDequeArr[i79].addFirst(m1375getAndMeasurejy6DScQ4);
                        iArr24[i79] = findPreviousItemIndex2;
                        iArr6[i79] = m1371maxInRangejy6DScQ4 + m1375getAndMeasurejy6DScQ4.getMainAxisSizeWithSpacings() + (gaps3 == null ? 0 : gaps3[i79]);
                        i79++;
                    }
                    copyOf3 = iArr25;
                    mainAxisAvailableSize = i78;
                    z18 = z20;
                    iArr16 = iArr24;
                    length4 = i75;
                    i8 = i76;
                }
            }
            if (z18 && z) {
                lazyStaggeredGridMeasureContext.getLaneInfo().reset();
                return measure(lazyStaggeredGridMeasureContext2, i28, iArr5, iArr6, false);
            }
            i11 = i28 + i26;
            int i81 = iArr6[indexOfMinValue$default(iArr6, 0, 1, null)];
            if (i81 < 0) {
                i11 += i81;
                offsetBy(iArr13, i81);
                offsetBy(iArr6, -i81);
            }
        } else {
            iArr4 = copyOf3;
            i9 = length4;
            i10 = i8;
            iArr5 = iArr16;
            iArr6 = iArr17;
            i11 = i28;
        }
        float scrollToBeConsumed$foundation_release = lazyStaggeredGridMeasureContext.getState().scrollToBeConsumed$foundation_release(lazyLayoutMeasureScope.isLookingAhead());
        float f = (MathKt.getSign(Math.round(scrollToBeConsumed$foundation_release)) != MathKt.getSign(i11) || Math.abs(Math.round(scrollToBeConsumed$foundation_release)) < Math.abs(i11)) ? scrollToBeConsumed$foundation_release : i11;
        float f2 = scrollToBeConsumed$foundation_release - f;
        float f3 = (!lazyLayoutMeasureScope.isLookingAhead() || i11 <= i28 || f2 > 0.0f) ? 0.0f : (i11 - i28) + f2;
        int[] copyOf4 = Arrays.copyOf(iArr6, iArr6.length);
        Intrinsics.checkNotNullExpressionValue(copyOf4, str3);
        int length9 = copyOf4.length;
        for (int i82 = 0; i82 < length9; i82++) {
            copyOf4[i82] = -copyOf4[i82];
        }
        if (lazyStaggeredGridMeasureContext.getBeforeContentPadding() > lazyStaggeredGridMeasureContext.getMainAxisSpacing()) {
            for (int i83 = 0; i83 < i6; i83++) {
                ArrayDeque arrayDeque2 = arrayDequeArr[i83];
                int size2 = ((Collection) arrayDeque2).size();
                int i84 = 0;
                while (i84 < size2) {
                    LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem3 = (LazyStaggeredGridMeasuredItem) arrayDeque2.get(i84);
                    int[] gaps4 = lazyStaggeredGridMeasureContext.getLaneInfo().getGaps(lazyStaggeredGridMeasuredItem3.getIndex());
                    int mainAxisSizeWithSpacings2 = lazyStaggeredGridMeasuredItem3.getMainAxisSizeWithSpacings() + (gaps4 == null ? 0 : gaps4[i83]);
                    if (i84 != CollectionsKt.getLastIndex((List) arrayDeque2) && (i25 = iArr6[i83]) != 0 && i25 >= mainAxisSizeWithSpacings2) {
                        iArr6[i83] = i25 - mainAxisSizeWithSpacings2;
                        i84++;
                        iArr5[i83] = ((LazyStaggeredGridMeasuredItem) arrayDeque2.get(i84)).getIndex();
                    }
                }
            }
        }
        int beforeContentPadding = lazyStaggeredGridMeasureContext.getBeforeContentPadding() + lazyStaggeredGridMeasureContext.getAfterContentPadding();
        if (lazyStaggeredGridMeasureContext.getIsVertical()) {
            i12 = Constraints.getMaxWidth-impl(lazyStaggeredGridMeasureContext.getConstraints());
        } else {
            i12 = ConstraintsKt.constrainWidth-K40F9xA(lazyStaggeredGridMeasureContext.getConstraints(), ArraysKt.maxOrThrow(iArr13) + beforeContentPadding);
        }
        int i85 = i12;
        if (lazyStaggeredGridMeasureContext.getIsVertical()) {
            i13 = ConstraintsKt.constrainHeight-K40F9xA(lazyStaggeredGridMeasureContext.getConstraints(), ArraysKt.maxOrThrow(iArr13) + beforeContentPadding);
        } else {
            i13 = Constraints.getMaxHeight-impl(lazyStaggeredGridMeasureContext.getConstraints());
        }
        int i86 = i13;
        int min2 = (Math.min(lazyStaggeredGridMeasureContext.getIsVertical() ? i86 : i85, lazyStaggeredGridMeasureContext.getMainAxisAvailableSize()) - lazyStaggeredGridMeasureContext.getBeforeContentPadding()) + lazyStaggeredGridMeasureContext.getAfterContentPadding();
        int i87 = copyOf4[0];
        List<Integer> pinnedItems = lazyStaggeredGridMeasureContext.getPinnedItems();
        int size3 = pinnedItems.size() - 1;
        if (size3 >= 0) {
            ArrayList arrayList3 = null;
            while (true) {
                int i88 = size3 - 1;
                int intValue = pinnedItems.get(size3).intValue();
                List<Integer> list3 = pinnedItems;
                int lane = lazyStaggeredGridMeasureContext.getLaneInfo().getLane(intValue);
                i14 = i86;
                if (lane == -2 || lane == -1) {
                    for (int i89 = 0; i89 < i6; i89++) {
                        LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem4 = (LazyStaggeredGridMeasuredItem) arrayDequeArr[i89].firstOrNull();
                        if (!((lazyStaggeredGridMeasuredItem4 != null ? lazyStaggeredGridMeasuredItem4.getIndex() : -1) > intValue)) {
                            z13 = false;
                            break;
                        }
                    }
                    z13 = true;
                } else {
                    LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem5 = (LazyStaggeredGridMeasuredItem) arrayDequeArr[lane].firstOrNull();
                }
                if (z13) {
                    iArr7 = iArr13;
                    i15 = i85;
                    long m1367getSpanRangelOCCd4c5 = lazyStaggeredGridMeasureContext2.m1367getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext.getItemProvider(), intValue, 0);
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList();
                    }
                    ArrayList arrayList4 = arrayList3;
                    LazyStaggeredGridMeasuredItem m1375getAndMeasurejy6DScQ5 = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m1375getAndMeasurejy6DScQ(intValue, m1367getSpanRangelOCCd4c5);
                    i87 -= m1375getAndMeasurejy6DScQ5.getMainAxisSizeWithSpacings();
                    m1375getAndMeasurejy6DScQ5.position(i87, 0, min2);
                    arrayList4.add(m1375getAndMeasurejy6DScQ5);
                    arrayList3 = arrayList4;
                } else {
                    iArr7 = iArr13;
                    i15 = i85;
                }
                if (i88 < 0) {
                    break;
                }
                pinnedItems = list3;
                i86 = i14;
                i85 = i15;
                size3 = i88;
                iArr13 = iArr7;
            }
            list = arrayList3;
        } else {
            i14 = i86;
            iArr7 = iArr13;
            i15 = i85;
            list = null;
        }
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        List list4 = list;
        ArrayDeque[] arrayDequeArr4 = arrayDequeArr;
        int i90 = i14;
        List<LazyStaggeredGridMeasuredItem> calculateVisibleItems = calculateVisibleItems(lazyStaggeredGridMeasureContext, arrayDequeArr4, copyOf4, min2, i56, i5);
        int i91 = copyOf4[0];
        LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem6 = (LazyStaggeredGridMeasuredItem) CollectionsKt.lastOrNull(calculateVisibleItems);
        int index2 = lazyStaggeredGridMeasuredItem6 != null ? lazyStaggeredGridMeasuredItem6.getIndex() : -1;
        if (lazyLayoutMeasureScope.isLookingAhead() && lazyStaggeredGridMeasureContext.getApproachLayoutInfo() != null && (!lazyStaggeredGridMeasureContext.getApproachLayoutInfo().getVisibleItemsInfo().isEmpty())) {
            List<LazyStaggeredGridItemInfo> visibleItemsInfo = lazyStaggeredGridMeasureContext.getApproachLayoutInfo().getVisibleItemsInfo();
            for (int size4 = visibleItemsInfo.size() - 1; -1 < size4; size4--) {
                if (visibleItemsInfo.get(size4).getIndex() > index2 && (size4 == 0 || visibleItemsInfo.get(size4 - 1).getIndex() <= index2)) {
                    lazyStaggeredGridItemInfo = visibleItemsInfo.get(size4);
                    break;
                }
            }
            lazyStaggeredGridItemInfo = null;
            LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo3 = (LazyStaggeredGridItemInfo) CollectionsKt.last(lazyStaggeredGridMeasureContext.getApproachLayoutInfo().getVisibleItemsInfo());
            if (lazyStaggeredGridItemInfo != null && (index = lazyStaggeredGridItemInfo.getIndex()) <= (min = Math.min(lazyStaggeredGridItemInfo3.getIndex(), i10 - 1))) {
                i17 = i91;
                arrayList = null;
                while (true) {
                    if (arrayList != null) {
                        int size5 = arrayList.size();
                        int i92 = 0;
                        while (true) {
                            if (i92 >= size5) {
                                z12 = false;
                                break;
                            }
                            int i93 = size5;
                            if (((LazyStaggeredGridMeasuredItem) arrayList.get(i92)).getIndex() == index) {
                                z12 = true;
                                break;
                            }
                            i92++;
                            size5 = i93;
                        }
                        if (z12) {
                            z11 = true;
                            if (z11) {
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                List<LazyStaggeredGridItemInfo> visibleItemsInfo2 = lazyStaggeredGridMeasureContext.getApproachLayoutInfo().getVisibleItemsInfo();
                                int size6 = visibleItemsInfo2.size();
                                i16 = i5;
                                int i94 = 0;
                                while (true) {
                                    if (i94 >= size6) {
                                        lazyStaggeredGridItemInfo2 = null;
                                        break;
                                    }
                                    lazyStaggeredGridItemInfo2 = visibleItemsInfo2.get(i94);
                                    List<LazyStaggeredGridItemInfo> list5 = visibleItemsInfo2;
                                    if (lazyStaggeredGridItemInfo2.getIndex() == index) {
                                        break;
                                    }
                                    i94++;
                                    visibleItemsInfo2 = list5;
                                }
                                LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo4 = lazyStaggeredGridItemInfo2;
                                int lane2 = lazyStaggeredGridItemInfo4 != null ? lazyStaggeredGridItemInfo4.getLane() : 0;
                                iArr8 = iArr5;
                                LazyStaggeredGridMeasuredItem m1375getAndMeasurejy6DScQ6 = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m1375getAndMeasurejy6DScQ(index, lazyStaggeredGridMeasureContext2.m1367getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext.getItemProvider(), index, lane2));
                                arrayList.add(m1375getAndMeasurejy6DScQ6);
                                int[] positions = lazyStaggeredGridMeasureContext.getResolvedSlots().getPositions();
                                m1375getAndMeasurejy6DScQ6.position(i17, positions.length > lane2 ? positions[lane2] : 0, min2);
                                i17 += m1375getAndMeasurejy6DScQ6.getMainAxisSizeWithSpacings();
                            } else {
                                i16 = i5;
                                iArr8 = iArr5;
                            }
                            if (index != min) {
                                break;
                            }
                            index++;
                            i5 = i16;
                            iArr5 = iArr8;
                        }
                    }
                    z11 = false;
                    if (z11) {
                    }
                    if (index != min) {
                    }
                }
                List<Integer> pinnedItems2 = lazyStaggeredGridMeasureContext.getPinnedItems();
                size = pinnedItems2.size();
                int i95 = i17;
                i18 = 0;
                arrayList2 = null;
                while (i18 < size) {
                    int intValue2 = pinnedItems2.get(i18).intValue();
                    int i96 = i10;
                    if (intValue2 < i96) {
                        if (arrayList != null) {
                            int size7 = arrayList.size();
                            list2 = pinnedItems2;
                            int i97 = 0;
                            while (true) {
                                if (i97 >= size7) {
                                    i23 = size;
                                    z10 = false;
                                    break;
                                }
                                i23 = size;
                                if (((LazyStaggeredGridMeasuredItem) arrayList.get(i97)).getIndex() == intValue2) {
                                    z10 = true;
                                    break;
                                }
                                i97++;
                                size = i23;
                            }
                            if (z10) {
                                z8 = true;
                                if (!z8) {
                                    int lane3 = lazyStaggeredGridMeasureContext.getLaneInfo().getLane(intValue2);
                                    if (lane3 != -2 && lane3 != -1) {
                                        if (iArr4[lane3] < intValue2) {
                                            iArr9 = iArr4;
                                        }
                                    } else {
                                        iArr9 = iArr4;
                                        int length10 = iArr9.length;
                                        int i98 = 0;
                                        while (i98 < length10) {
                                            int i99 = length10;
                                            if (!(iArr9[i98] < intValue2)) {
                                                z9 = false;
                                                break;
                                            }
                                            i98++;
                                            length10 = i99;
                                        }
                                    }
                                    z9 = true;
                                }
                                iArr9 = iArr4;
                                z9 = false;
                                break;
                            }
                        } else {
                            list2 = pinnedItems2;
                            i23 = size;
                        }
                        z8 = false;
                        if (!z8) {
                        }
                        iArr9 = iArr4;
                        z9 = false;
                        break;
                    } else {
                        list2 = pinnedItems2;
                        i23 = size;
                        z9 = false;
                        iArr9 = iArr4;
                    }
                    if (z9) {
                        i24 = i96;
                        iArr10 = iArr6;
                        long m1367getSpanRangelOCCd4c6 = lazyStaggeredGridMeasureContext2.m1367getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext.getItemProvider(), intValue2, 0);
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        List list6 = arrayList2;
                        LazyStaggeredGridMeasuredItem m1375getAndMeasurejy6DScQ7 = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m1375getAndMeasurejy6DScQ(intValue2, m1367getSpanRangelOCCd4c6);
                        m1375getAndMeasurejy6DScQ7.position(i95, 0, min2);
                        i95 += m1375getAndMeasurejy6DScQ7.getMainAxisSizeWithSpacings();
                        list6.add(m1375getAndMeasurejy6DScQ7);
                        arrayList2 = list6;
                    } else {
                        i24 = i96;
                        iArr10 = iArr6;
                    }
                    i18++;
                    lazyStaggeredGridMeasureContext2 = lazyStaggeredGridMeasureContext;
                    iArr6 = iArr10;
                    iArr4 = iArr9;
                    pinnedItems2 = list2;
                    size = i23;
                    i10 = i24;
                }
                int[] iArr26 = iArr4;
                int[] iArr27 = iArr6;
                int i100 = i10;
                if (arrayList2 == null) {
                    arrayList2 = CollectionsKt.emptyList();
                }
                final ArrayList arrayList5 = new ArrayList();
                arrayList5.addAll(list4);
                arrayList5.addAll(calculateVisibleItems);
                if (arrayList != null) {
                    arrayList5.addAll(arrayList);
                }
                arrayList5.addAll(arrayList2);
                lazyStaggeredGridMeasureContext.getState().getItemAnimator$foundation_release().onMeasured((int) f, i15, i90, arrayList5, lazyStaggeredGridMeasureContext.getMeasuredItemProvider().getKeyIndexMap(), lazyStaggeredGridMeasureContext.getMeasuredItemProvider(), lazyStaggeredGridMeasureContext.getIsVertical(), lazyLayoutMeasureScope.isLookingAhead(), lazyStaggeredGridMeasureContext.getLaneCount(), lazyStaggeredGridMeasureContext.getIsInLookaheadScope(), ArraysKt.minOrThrow(iArr27), ArraysKt.maxOrThrow(iArr7) + beforeContentPadding, lazyStaggeredGridMeasureContext.getCoroutineScope(), lazyStaggeredGridMeasureContext.getGraphicsContext());
                if (!lazyLayoutMeasureScope.isLookingAhead()) {
                    long m1289getMinSizeToFitDisappearingItemsYbymL2g2 = lazyStaggeredGridMeasureContext.getState().getItemAnimator$foundation_release().m1289getMinSizeToFitDisappearingItemsYbymL2g();
                    if (!IntSize.equals-impl0(m1289getMinSizeToFitDisappearingItemsYbymL2g2, IntSize.Companion.getZero-YbymL2g())) {
                        int i101 = lazyStaggeredGridMeasureContext.getIsVertical() ? i90 : i15;
                        int i102 = ConstraintsKt.constrainWidth-K40F9xA(lazyStaggeredGridMeasureContext.getConstraints(), Math.max(i15, (int) (m1289getMinSizeToFitDisappearingItemsYbymL2g2 >> 32)));
                        i20 = ConstraintsKt.constrainHeight-K40F9xA(lazyStaggeredGridMeasureContext.getConstraints(), Math.max(i90, (int) (m1289getMinSizeToFitDisappearingItemsYbymL2g2 & 4294967295L)));
                        int i103 = lazyStaggeredGridMeasureContext.getIsVertical() ? i20 : i102;
                        if (i103 != i101) {
                            int size8 = arrayList5.size();
                            for (int i104 = 0; i104 < size8; i104++) {
                                arrayList5.get(i104).updateMainAxisLayoutSize(i103);
                            }
                        }
                        i19 = i102;
                        i21 = i9;
                        i22 = 0;
                        while (true) {
                            if (i22 >= i21) {
                                z5 = false;
                                break;
                            }
                            if (iArr7[i22] > lazyStaggeredGridMeasureContext.getMainAxisAvailableSize()) {
                                z5 = true;
                                break;
                            }
                            i22++;
                        }
                        if (!z5) {
                            int length11 = iArr26.length;
                            int i105 = 0;
                            while (true) {
                                if (i105 >= length11) {
                                    z7 = true;
                                    break;
                                }
                                if (!(iArr26[i105] < i100 + (-1))) {
                                    z7 = false;
                                    break;
                                }
                                i105++;
                            }
                            if (!z7) {
                                z6 = false;
                                final LazyLayoutMeasureScope lazyLayoutMeasureScope4 = lazyLayoutMeasureScope;
                                return new LazyStaggeredGridMeasureResult(iArr8, iArr27, f, MeasureScope.layout$default(lazyLayoutMeasureScope, i19, i20, null, new Function1() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$$ExternalSyntheticLambda2
                                    public final Object invoke(Object obj) {
                                        Unit measure$lambda$49$lambda$48;
                                        measure$lambda$49$lambda$48 = LazyStaggeredGridMeasureKt.measure$lambda$49$lambda$48(LazyStaggeredGridMeasureContext.this, arrayList5, lazyLayoutMeasureScope4, (Placeable.PlacementScope) obj);
                                        return measure$lambda$49$lambda$48;
                                    }
                                }, 4, null), f3, z6, lazyStaggeredGridMeasureContext.getIsVertical(), z17, lazyStaggeredGridMeasureContext.getResolvedSlots(), lazyStaggeredGridMeasureContext.getItemProvider().getSpanProvider(), lazyLayoutMeasureScope4, i100, calculateVisibleItems, IntSize.constructor-impl((i19 << 32) | (i20 & 4294967295L)), i56, i16, lazyStaggeredGridMeasureContext.getBeforeContentPadding(), lazyStaggeredGridMeasureContext.getAfterContentPadding(), lazyStaggeredGridMeasureContext.getMainAxisSpacing(), lazyStaggeredGridMeasureContext.getCoroutineScope(), null);
                            }
                        }
                        z6 = true;
                        final LazyLayoutMeasureScope lazyLayoutMeasureScope42 = lazyLayoutMeasureScope;
                        return new LazyStaggeredGridMeasureResult(iArr8, iArr27, f, MeasureScope.layout$default(lazyLayoutMeasureScope, i19, i20, null, new Function1() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$$ExternalSyntheticLambda2
                            public final Object invoke(Object obj) {
                                Unit measure$lambda$49$lambda$48;
                                measure$lambda$49$lambda$48 = LazyStaggeredGridMeasureKt.measure$lambda$49$lambda$48(LazyStaggeredGridMeasureContext.this, arrayList5, lazyLayoutMeasureScope42, (Placeable.PlacementScope) obj);
                                return measure$lambda$49$lambda$48;
                            }
                        }, 4, null), f3, z6, lazyStaggeredGridMeasureContext.getIsVertical(), z17, lazyStaggeredGridMeasureContext.getResolvedSlots(), lazyStaggeredGridMeasureContext.getItemProvider().getSpanProvider(), lazyLayoutMeasureScope42, i100, calculateVisibleItems, IntSize.constructor-impl((i19 << 32) | (i20 & 4294967295L)), i56, i16, lazyStaggeredGridMeasureContext.getBeforeContentPadding(), lazyStaggeredGridMeasureContext.getAfterContentPadding(), lazyStaggeredGridMeasureContext.getMainAxisSpacing(), lazyStaggeredGridMeasureContext.getCoroutineScope(), null);
                    }
                }
                i19 = i15;
                i20 = i90;
                i21 = i9;
                i22 = 0;
                while (true) {
                    if (i22 >= i21) {
                    }
                    i22++;
                }
                if (!z5) {
                }
                z6 = true;
                final LazyLayoutMeasureScope lazyLayoutMeasureScope422 = lazyLayoutMeasureScope;
                return new LazyStaggeredGridMeasureResult(iArr8, iArr27, f, MeasureScope.layout$default(lazyLayoutMeasureScope, i19, i20, null, new Function1() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        Unit measure$lambda$49$lambda$48;
                        measure$lambda$49$lambda$48 = LazyStaggeredGridMeasureKt.measure$lambda$49$lambda$48(LazyStaggeredGridMeasureContext.this, arrayList5, lazyLayoutMeasureScope422, (Placeable.PlacementScope) obj);
                        return measure$lambda$49$lambda$48;
                    }
                }, 4, null), f3, z6, lazyStaggeredGridMeasureContext.getIsVertical(), z17, lazyStaggeredGridMeasureContext.getResolvedSlots(), lazyStaggeredGridMeasureContext.getItemProvider().getSpanProvider(), lazyLayoutMeasureScope422, i100, calculateVisibleItems, IntSize.constructor-impl((i19 << 32) | (i20 & 4294967295L)), i56, i16, lazyStaggeredGridMeasureContext.getBeforeContentPadding(), lazyStaggeredGridMeasureContext.getAfterContentPadding(), lazyStaggeredGridMeasureContext.getMainAxisSpacing(), lazyStaggeredGridMeasureContext.getCoroutineScope(), null);
            }
        }
        i16 = i5;
        iArr8 = iArr5;
        i17 = i91;
        arrayList = null;
        List<Integer> pinnedItems22 = lazyStaggeredGridMeasureContext.getPinnedItems();
        size = pinnedItems22.size();
        int i952 = i17;
        i18 = 0;
        arrayList2 = null;
        while (i18 < size) {
        }
        int[] iArr262 = iArr4;
        int[] iArr272 = iArr6;
        int i1002 = i10;
        if (arrayList2 == null) {
        }
        final List arrayList52 = new ArrayList();
        arrayList52.addAll(list4);
        arrayList52.addAll(calculateVisibleItems);
        if (arrayList != null) {
        }
        arrayList52.addAll(arrayList2);
        lazyStaggeredGridMeasureContext.getState().getItemAnimator$foundation_release().onMeasured((int) f, i15, i90, arrayList52, lazyStaggeredGridMeasureContext.getMeasuredItemProvider().getKeyIndexMap(), lazyStaggeredGridMeasureContext.getMeasuredItemProvider(), lazyStaggeredGridMeasureContext.getIsVertical(), lazyLayoutMeasureScope.isLookingAhead(), lazyStaggeredGridMeasureContext.getLaneCount(), lazyStaggeredGridMeasureContext.getIsInLookaheadScope(), ArraysKt.minOrThrow(iArr272), ArraysKt.maxOrThrow(iArr7) + beforeContentPadding, lazyStaggeredGridMeasureContext.getCoroutineScope(), lazyStaggeredGridMeasureContext.getGraphicsContext());
        if (!lazyLayoutMeasureScope.isLookingAhead()) {
        }
        i19 = i15;
        i20 = i90;
        i21 = i9;
        i22 = 0;
        while (true) {
            if (i22 >= i21) {
            }
            i22++;
        }
        if (!z5) {
        }
        z6 = true;
        final LazyLayoutMeasureScope lazyLayoutMeasureScope4222 = lazyLayoutMeasureScope;
        return new LazyStaggeredGridMeasureResult(iArr8, iArr272, f, MeasureScope.layout$default(lazyLayoutMeasureScope, i19, i20, null, new Function1() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit measure$lambda$49$lambda$48;
                measure$lambda$49$lambda$48 = LazyStaggeredGridMeasureKt.measure$lambda$49$lambda$48(LazyStaggeredGridMeasureContext.this, arrayList52, lazyLayoutMeasureScope4222, (Placeable.PlacementScope) obj);
                return measure$lambda$49$lambda$48;
            }
        }, 4, null), f3, z6, lazyStaggeredGridMeasureContext.getIsVertical(), z17, lazyStaggeredGridMeasureContext.getResolvedSlots(), lazyStaggeredGridMeasureContext.getItemProvider().getSpanProvider(), lazyLayoutMeasureScope4222, i1002, calculateVisibleItems, IntSize.constructor-impl((i19 << 32) | (i20 & 4294967295L)), i56, i16, lazyStaggeredGridMeasureContext.getBeforeContentPadding(), lazyStaggeredGridMeasureContext.getAfterContentPadding(), lazyStaggeredGridMeasureContext.getMainAxisSpacing(), lazyStaggeredGridMeasureContext.getCoroutineScope(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure$lambda$49$lambda$4(Placeable.PlacementScope placementScope) {
        return Unit.INSTANCE;
    }

    private static final boolean measure$lambda$49$hasSpaceBeforeFirst(int[] iArr, int[] iArr2, LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            int i2 = iArr[i];
            if (iArr2[i] < Math.max(-lazyStaggeredGridMeasureContext.getMainAxisSpacing(), 0) && i2 > 0) {
                return true;
            }
        }
        return false;
    }

    private static final boolean measure$lambda$49$misalignedStart(int[] iArr, LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int[] iArr2, int i) {
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (findPreviousItemIndex(lazyStaggeredGridMeasureContext, iArr[i2], i2) == -1 && iArr2[i2] != iArr2[i]) {
                return true;
            }
        }
        int length2 = iArr.length;
        for (int i3 = 0; i3 < length2; i3++) {
            if (findPreviousItemIndex(lazyStaggeredGridMeasureContext, iArr[i3], i3) != -1 && iArr2[i3] >= iArr2[i]) {
                return true;
            }
        }
        int lane = lazyStaggeredGridMeasureContext.getLaneInfo().getLane(0);
        return (lane == 0 || lane == -1 || lane == -2) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure$lambda$49$lambda$48(final LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, final List list, final LazyLayoutMeasureScope lazyLayoutMeasureScope, Placeable.PlacementScope placementScope) {
        placementScope.withMotionFrameOfReferencePlacement(new Function1() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit measure$lambda$49$lambda$48$lambda$47;
                measure$lambda$49$lambda$48$lambda$47 = LazyStaggeredGridMeasureKt.measure$lambda$49$lambda$48$lambda$47(list, lazyStaggeredGridMeasureContext, lazyLayoutMeasureScope, (Placeable.PlacementScope) obj);
                return measure$lambda$49$lambda$48$lambda$47;
            }
        });
        ObservableScopeInvalidator.m1324attachToScopeimpl(lazyStaggeredGridMeasureContext.getState().m1381getPlacementScopeInvalidatorzYiylxw$foundation_release());
        return Unit.INSTANCE;
    }

    private static final List<LazyStaggeredGridMeasuredItem> calculateVisibleItems(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, ArrayDeque<LazyStaggeredGridMeasuredItem>[] arrayDequeArr, int[] iArr, int i, int i2, int i3) {
        boolean z;
        int i4 = 0;
        for (ArrayDeque<LazyStaggeredGridMeasuredItem> arrayDeque : arrayDequeArr) {
            i4 += arrayDeque.size();
        }
        ArrayList arrayList = new ArrayList(i4);
        while (true) {
            int length = arrayDequeArr.length;
            int i5 = 0;
            while (true) {
                if (i5 >= length) {
                    z = false;
                    break;
                }
                z = true;
                if (!((Collection) arrayDequeArr[i5]).isEmpty()) {
                    break;
                }
                i5++;
            }
            if (!z) {
                return arrayList;
            }
            int length2 = arrayDequeArr.length;
            int i6 = -1;
            int i7 = Integer.MAX_VALUE;
            for (int i8 = 0; i8 < length2; i8++) {
                LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem = (LazyStaggeredGridMeasuredItem) arrayDequeArr[i8].firstOrNull();
                int index = lazyStaggeredGridMeasuredItem != null ? lazyStaggeredGridMeasuredItem.getIndex() : Integer.MAX_VALUE;
                if (i7 > index) {
                    i6 = i8;
                    i7 = index;
                }
            }
            LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem2 = (LazyStaggeredGridMeasuredItem) arrayDequeArr[i6].removeFirst();
            if (lazyStaggeredGridMeasuredItem2.getLane() == i6) {
                long m1383constructorimpl = SpanRange.m1383constructorimpl(lazyStaggeredGridMeasuredItem2.getLane(), lazyStaggeredGridMeasuredItem2.getSpan());
                int m1371maxInRangejy6DScQ = m1371maxInRangejy6DScQ(iArr, m1383constructorimpl);
                int i9 = lazyStaggeredGridMeasureContext.getResolvedSlots().getPositions()[i6];
                if (lazyStaggeredGridMeasuredItem2.getMainAxisSize() + m1371maxInRangejy6DScQ >= i2 && m1371maxInRangejy6DScQ <= i3) {
                    lazyStaggeredGridMeasuredItem2.position(m1371maxInRangejy6DScQ, i9, i);
                    arrayList.add(lazyStaggeredGridMeasuredItem2);
                }
                int i10 = (int) (m1383constructorimpl & 4294967295L);
                for (int i11 = (int) (m1383constructorimpl >> 32); i11 < i10; i11++) {
                    iArr[i11] = lazyStaggeredGridMeasuredItem2.getMainAxisSizeWithSpacings() + m1371maxInRangejy6DScQ;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0102 A[LOOP:1: B:22:0x0072->B:58:0x0102, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0106 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final List<LazyStaggeredGridMeasuredItem> itemsRetainedForLookahead(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int i, int i2, boolean z, Function2<? super LazyStaggeredGridMeasuredItem, ? super Integer, Unit> function2) {
        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo;
        int index;
        int min;
        boolean z2;
        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo2;
        boolean z3;
        if (!z || lazyStaggeredGridMeasureContext.getApproachLayoutInfo() == null || !(!lazyStaggeredGridMeasureContext.getApproachLayoutInfo().getVisibleItemsInfo().isEmpty())) {
            return null;
        }
        List<LazyStaggeredGridItemInfo> visibleItemsInfo = lazyStaggeredGridMeasureContext.getApproachLayoutInfo().getVisibleItemsInfo();
        for (int size = visibleItemsInfo.size() - 1; -1 < size; size--) {
            if (visibleItemsInfo.get(size).getIndex() > i && (size == 0 || visibleItemsInfo.get(size - 1).getIndex() <= i)) {
                lazyStaggeredGridItemInfo = visibleItemsInfo.get(size);
                break;
            }
        }
        lazyStaggeredGridItemInfo = null;
        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo3 = (LazyStaggeredGridItemInfo) CollectionsKt.last(lazyStaggeredGridMeasureContext.getApproachLayoutInfo().getVisibleItemsInfo());
        if (lazyStaggeredGridItemInfo == null || (index = lazyStaggeredGridItemInfo.getIndex()) > (min = Math.min(lazyStaggeredGridItemInfo3.getIndex(), i2 - 1))) {
            return null;
        }
        ArrayList arrayList = null;
        while (true) {
            if (arrayList != null) {
                int size2 = arrayList.size();
                int i3 = 0;
                while (true) {
                    if (i3 >= size2) {
                        z3 = false;
                        break;
                    }
                    if (arrayList.get(i3).getIndex() == index) {
                        z3 = true;
                        break;
                    }
                    i3++;
                }
                if (z3) {
                    z2 = true;
                    if (!z2) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        List<LazyStaggeredGridItemInfo> visibleItemsInfo2 = lazyStaggeredGridMeasureContext.getApproachLayoutInfo().getVisibleItemsInfo();
                        int size3 = visibleItemsInfo2.size();
                        int i4 = 0;
                        while (true) {
                            if (i4 >= size3) {
                                lazyStaggeredGridItemInfo2 = null;
                                break;
                            }
                            lazyStaggeredGridItemInfo2 = visibleItemsInfo2.get(i4);
                            if (lazyStaggeredGridItemInfo2.getIndex() == index) {
                                break;
                            }
                            i4++;
                        }
                        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo4 = lazyStaggeredGridItemInfo2;
                        int lane = lazyStaggeredGridItemInfo4 != null ? lazyStaggeredGridItemInfo4.getLane() : 0;
                        LazyStaggeredGridMeasuredItem m1375getAndMeasurejy6DScQ = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m1375getAndMeasurejy6DScQ(index, lazyStaggeredGridMeasureContext.m1367getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext.getItemProvider(), index, lane));
                        arrayList.add(m1375getAndMeasurejy6DScQ);
                        int[] positions = lazyStaggeredGridMeasureContext.getResolvedSlots().getPositions();
                        function2.invoke(m1375getAndMeasurejy6DScQ, Integer.valueOf(positions.length > lane ? positions[lane] : 0));
                    }
                    if (index != min) {
                        return arrayList;
                    }
                    index++;
                }
            }
            z2 = false;
            if (!z2) {
            }
            if (index != min) {
            }
        }
    }

    private static final List<LazyStaggeredGridMeasuredItem> calculateExtraItems(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, Function1<? super LazyStaggeredGridMeasuredItem, Unit> function1, Function1<? super Integer, Boolean> function12, boolean z) {
        List<Integer> pinnedItems = lazyStaggeredGridMeasureContext.getPinnedItems();
        ArrayList arrayList = null;
        if (z) {
            int size = pinnedItems.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i = size - 1;
                    int intValue = pinnedItems.get(size).intValue();
                    if (((Boolean) function12.invoke(Integer.valueOf(intValue))).booleanValue()) {
                        long m1367getSpanRangelOCCd4c = lazyStaggeredGridMeasureContext.m1367getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext.getItemProvider(), intValue, 0);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        LazyStaggeredGridMeasuredItem m1375getAndMeasurejy6DScQ = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m1375getAndMeasurejy6DScQ(intValue, m1367getSpanRangelOCCd4c);
                        function1.invoke(m1375getAndMeasurejy6DScQ);
                        arrayList.add(m1375getAndMeasurejy6DScQ);
                    }
                    if (i < 0) {
                        break;
                    }
                    size = i;
                }
            }
        } else {
            int size2 = pinnedItems.size();
            for (int i2 = 0; i2 < size2; i2++) {
                int intValue2 = pinnedItems.get(i2).intValue();
                if (((Boolean) function12.invoke(Integer.valueOf(intValue2))).booleanValue()) {
                    long m1367getSpanRangelOCCd4c2 = lazyStaggeredGridMeasureContext.m1367getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext.getItemProvider(), intValue2, 0);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    LazyStaggeredGridMeasuredItem m1375getAndMeasurejy6DScQ2 = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m1375getAndMeasurejy6DScQ(intValue2, m1367getSpanRangelOCCd4c2);
                    function1.invoke(m1375getAndMeasurejy6DScQ2);
                    arrayList.add(m1375getAndMeasurejy6DScQ2);
                }
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    /* renamed from: forEach-nIS5qE8, reason: not valid java name */
    private static final void m1370forEachnIS5qE8(long j, Function1<? super Integer, Unit> function1) {
        int i = (int) (j & 4294967295L);
        for (int i2 = (int) (j >> 32); i2 < i; i2++) {
            function1.invoke(Integer.valueOf(i2));
        }
    }

    private static final void offsetBy(int[] iArr, int i) {
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = iArr[i2] + i;
        }
    }

    /* renamed from: maxInRange-jy6DScQ, reason: not valid java name */
    private static final int m1371maxInRangejy6DScQ(int[] iArr, long j) {
        int i = (int) (j & 4294967295L);
        int i2 = Integer.MIN_VALUE;
        for (int i3 = (int) (j >> 32); i3 < i; i3++) {
            i2 = Math.max(i2, iArr[i3]);
        }
        return i2;
    }

    public static /* synthetic */ int indexOfMinValue$default(int[] iArr, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = Integer.MIN_VALUE;
        }
        return indexOfMinValue(iArr, i);
    }

    public static final int indexOfMinValue(int[] iArr, int i) {
        int length = iArr.length;
        int i2 = -1;
        int i3 = Integer.MAX_VALUE;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = i + 1;
            int i6 = iArr[i4];
            if (i5 <= i6 && i6 < i3) {
                i2 = i4;
                i3 = i6;
            }
        }
        return i2;
    }

    private static final <T> int indexOfMinBy(T[] tArr, Function1<? super T, Integer> function1) {
        int length = tArr.length;
        int i = -1;
        int i2 = Integer.MAX_VALUE;
        for (int i3 = 0; i3 < length; i3++) {
            int intValue = ((Number) function1.invoke(tArr[i3])).intValue();
            if (i2 > intValue) {
                i = i3;
                i2 = intValue;
            }
        }
        return i;
    }

    private static final int indexOfMaxValue(int[] iArr) {
        int length = iArr.length;
        int i = -1;
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = iArr[i3];
            if (i2 < i4) {
                i = i3;
                i2 = i4;
            }
        }
        return i;
    }

    private static final int[] transform(int[] iArr, Function1<? super Integer, Integer> function1) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            iArr[i] = ((Number) function1.invoke(Integer.valueOf(iArr[i]))).intValue();
        }
        return iArr;
    }

    private static final void ensureIndicesInRange(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int[] iArr, int i) {
        int length = iArr.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i2 = length - 1;
            while (true) {
                if (iArr[length] < i && lazyStaggeredGridMeasureContext.getLaneInfo().assignedToLane(iArr[length], length)) {
                    break;
                } else {
                    iArr[length] = findPreviousItemIndex(lazyStaggeredGridMeasureContext, iArr[length], length);
                }
            }
            if (iArr[length] >= 0 && !lazyStaggeredGridMeasureContext.isFullSpan(lazyStaggeredGridMeasureContext.getItemProvider(), iArr[length])) {
                lazyStaggeredGridMeasureContext.getLaneInfo().setLane(iArr[length], length);
            }
            if (i2 < 0) {
                return;
            } else {
                length = i2;
            }
        }
    }

    private static final int findPreviousItemIndex(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int i, int i2) {
        return lazyStaggeredGridMeasureContext.getLaneInfo().findPreviousItemIndex(i, i2);
    }

    private static final <T> void fastForEach(List<? extends T> list, boolean z, Function1<? super T, Unit> function1) {
        if (z) {
            int size = list.size() - 1;
            if (size < 0) {
                return;
            }
            while (true) {
                int i = size - 1;
                function1.invoke(list.get(size));
                if (i < 0) {
                    return;
                } else {
                    size = i;
                }
            }
        } else {
            int size2 = list.size();
            for (int i2 = 0; i2 < size2; i2++) {
                function1.invoke(list.get(i2));
            }
        }
    }

    static /* synthetic */ void fastForEach$default(List list, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if (z) {
            int size = list.size() - 1;
            if (size < 0) {
                return;
            }
            while (true) {
                int i2 = size - 1;
                function1.invoke(list.get(size));
                if (i2 < 0) {
                    return;
                } else {
                    size = i2;
                }
            }
        } else {
            int size2 = list.size();
            for (int i3 = 0; i3 < size2; i3++) {
                function1.invoke(list.get(i3));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure$lambda$49$lambda$48$lambda$47(List list, LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, LazyLayoutMeasureScope lazyLayoutMeasureScope, Placeable.PlacementScope placementScope) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ((LazyStaggeredGridMeasuredItem) list.get(i)).place(placementScope, lazyStaggeredGridMeasureContext, lazyLayoutMeasureScope.isLookingAhead());
        }
        return Unit.INSTANCE;
    }
}
