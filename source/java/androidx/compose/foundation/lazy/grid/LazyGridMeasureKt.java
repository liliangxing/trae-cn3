package androidx.compose.foundation.lazy.grid;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutStickyItemsKt;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.foundation.lazy.layout.StickyItemsPlacement;
import androidx.compose.p002ui.graphics.GraphicsContext;
import androidx.compose.p002ui.layout.MeasureResult;
import androidx.compose.p002ui.layout.Placeable;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: LazyGridMeasure.kt */
@Metadata(d1 = {"\u0000¸\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\b\u0002\u001aü\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\u00032\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030 2\u0006\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u00132\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*23\u0010+\u001a/\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0011000 0,2!\u00101\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020\u00030,2\b\u00103\u001a\u0004\u0018\u0001042/\u00105\u001a+\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u0002080,¢\u0006\u0002\b9\u0012\u0004\u0012\u00020:06H\u0000¢\u0006\u0004\b;\u0010<\u001aA\u0010=\u001a\b\u0012\u0004\u0012\u00020\u001d0 2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030 2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00130,H\u0082\b\u001aF\u0010?\u001a\b\u0012\u0004\u0012\u00020@0 2\u0006\u0010A\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00132\f\u0010B\u001a\b\u0012\u0004\u0012\u00020@0 2\b\u0010C\u001a\u0004\u0018\u00010$H\u0002\u001a\u008c\u0001\u0010D\u001a\b\u0012\u0004\u0012\u00020\u001d0E2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020@0 2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u001d0 2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u001d0 2\u0006\u0010I\u001a\u00020\u00032\u0006\u0010J\u001a\u00020\u00032\u0006\u0010K\u001a\u00020\u00032\u0006\u0010L\u001a\u00020\u00032\u0006\u0010M\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aH\u0002\u001a+\u0010N\u001a\u000208\"\u0004\b\u0000\u0010O*\b\u0012\u0004\u0012\u0002HO0E2\f\u0010P\u001a\b\u0012\u0004\u0012\u0002HO0QH\u0002¢\u0006\u0002\u0010R¨\u0006S"}, d2 = {"measureLazyGrid", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "itemsCount", "", "measuredLineProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLineProvider;", "measuredItemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;", "mainAxisAvailableSize", "beforeContentPadding", "afterContentPadding", "spaceBetweenLines", "firstVisibleLineIndex", "firstVisibleLineScrollOffset", "scrollToBeConsumed", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "isVertical", "", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "reverseLayout", "density", "Landroidx/compose/ui/unit/Density;", "itemAnimator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "slotsPerLine", "pinnedItems", "", "isInLookaheadScope", "isLookingAhead", "approachLayoutInfo", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "placementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "prefetchInfoRetriever", "Lkotlin/Function1;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "line", "Lkotlin/Pair;", "lineIndexProvider", "itemIndex", "stickyItemsScrollBehavior", "Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;", "layout", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measureLazyGrid-t1x4au0", "(ILandroidx/compose/foundation/lazy/grid/LazyGridMeasuredLineProvider;Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;IIIIIIFJZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ZLandroidx/compose/ui/unit/Density;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;ILjava/util/List;ZZLandroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/graphics/GraphicsContext;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "calculateExtraItems", "filter", "linesRetainedForLookahead", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "lastVisibleItemIndex", "visibleLines", "lastApproachLayoutInfo", "calculateItemsOffsets", "", "lines", "itemsBefore", "itemsAfter", "layoutWidth", "layoutHeight", "finalMainAxisOffset", "maxOffset", "firstLineScrollOffset", "addAllFromArray", "T", "arr", "", "(Ljava/util/List;[Ljava/lang/Object;)V", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class LazyGridMeasureKt {
    private static final int calculateItemsOffsets$reverseAware(int i, boolean z, int i2) {
        return !z ? i : (i2 - i) - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measureLazyGrid_t1x4au0$lambda$2(Placeable.PlacementScope placementScope) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LazyGridMeasuredItem measureLazyGrid_t1x4au0$lambda$9(LazyGridMeasuredLineProvider lazyGridMeasuredLineProvider, LazyGridMeasuredItemProvider lazyGridMeasuredItemProvider, int i) {
        int spanOf = lazyGridMeasuredLineProvider.spanOf(i);
        return lazyGridMeasuredItemProvider.mo1210getAndMeasurehBUhpc(i, 0, spanOf, lazyGridMeasuredLineProvider.m1257childConstraintsJhjzzOo$foundation_release(0, spanOf));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measureLazyGrid_t1x4au0$lambda$13(MutableState mutableState, final List list, final List list2, final boolean z, Placeable.PlacementScope placementScope) {
        placementScope.withMotionFrameOfReferencePlacement(new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit measureLazyGrid_t1x4au0$lambda$13$lambda$12;
                measureLazyGrid_t1x4au0$lambda$13$lambda$12 = LazyGridMeasureKt.measureLazyGrid_t1x4au0$lambda$13$lambda$12(list, list2, z, (Placeable.PlacementScope) obj);
                return measureLazyGrid_t1x4au0$lambda$13$lambda$12;
            }
        });
        ObservableScopeInvalidator.m1324attachToScopeimpl(mutableState);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c2 A[LOOP:1: B:22:0x0071->B:45:0x00c2, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c5 A[EDGE_INSN: B:46:0x00c5->B:60:0x00c5 BREAK  A[LOOP:1: B:22:0x0071->B:45:0x00c2], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final List<LazyGridMeasuredLine> linesRetainedForLookahead(int i, int i2, LazyGridMeasuredLineProvider lazyGridMeasuredLineProvider, boolean z, List<LazyGridMeasuredLine> list, LazyGridLayoutInfo lazyGridLayoutInfo) {
        LazyGridItemInfo lazyGridItemInfo;
        int index;
        int min;
        boolean z2;
        boolean z3;
        boolean z4;
        ArrayList arrayList = null;
        if (z && lazyGridLayoutInfo != null && (!lazyGridLayoutInfo.getVisibleItemsInfo().isEmpty())) {
            List<LazyGridItemInfo> visibleItemsInfo = lazyGridLayoutInfo.getVisibleItemsInfo();
            for (int size = visibleItemsInfo.size() - 1; -1 < size; size--) {
                if (visibleItemsInfo.get(size).getIndex() > i && (size == 0 || visibleItemsInfo.get(size - 1).getIndex() <= i)) {
                    lazyGridItemInfo = visibleItemsInfo.get(size);
                    break;
                }
            }
            lazyGridItemInfo = null;
            LazyGridItemInfo lazyGridItemInfo2 = (LazyGridItemInfo) CollectionsKt.last(lazyGridLayoutInfo.getVisibleItemsInfo());
            LazyGridMeasuredLine lazyGridMeasuredLine = (LazyGridMeasuredLine) CollectionsKt.lastOrNull(list);
            int index2 = lazyGridMeasuredLine != null ? lazyGridMeasuredLine.getIndex() + 1 : 0;
            if (lazyGridItemInfo != null && (index = lazyGridItemInfo.getIndex()) <= (min = Math.min(lazyGridItemInfo2.getIndex(), i2 - 1))) {
                while (true) {
                    if (arrayList != null) {
                        int size2 = arrayList.size();
                        int i3 = 0;
                        while (true) {
                            if (i3 >= size2) {
                                z3 = false;
                                break;
                            }
                            LazyGridMeasuredItem[] items = arrayList.get(i3).getItems();
                            int length = items.length;
                            int i4 = 0;
                            while (true) {
                                if (i4 >= length) {
                                    z4 = false;
                                    break;
                                }
                                if (items[i4].getIndex() == index) {
                                    z4 = true;
                                    break;
                                }
                                i4++;
                            }
                            if (z4) {
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
                                LazyGridMeasuredLine andMeasure = lazyGridMeasuredLineProvider.getAndMeasure(index2);
                                index2++;
                                arrayList.add(andMeasure);
                            }
                            if (index != min) {
                                break;
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
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    private static final List<LazyGridMeasuredItem> calculateItemsOffsets(List<LazyGridMeasuredLine> list, List<LazyGridMeasuredItem> list2, List<LazyGridMeasuredItem> list3, int i, int i2, int i3, int i4, int i5, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z2, Density density) {
        int i6 = z ? i2 : i;
        boolean z3 = i3 < Math.min(i6, i4);
        if (z3) {
            if (!(i5 == 0)) {
                InlineClassHelperKt.throwIllegalStateException("non-zero firstLineScrollOffset");
            }
        }
        List<LazyGridMeasuredLine> list4 = list;
        int size = list4.size();
        int i7 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            i7 += list.get(i8).getItems().length;
        }
        ArrayList arrayList = new ArrayList(i7);
        if (z3) {
            if (!(list2.isEmpty() && list3.isEmpty())) {
                InlineClassHelperKt.throwIllegalArgumentException("no items");
            }
            int size2 = list.size();
            int[] iArr = new int[size2];
            for (int i9 = 0; i9 < size2; i9++) {
                iArr[i9] = list.get(calculateItemsOffsets$reverseAware(i9, z2, size2)).getMainAxisSize();
            }
            int[] iArr2 = new int[size2];
            if (z) {
                if (vertical != null) {
                    vertical.arrange(density, i6, iArr, iArr2);
                } else {
                    InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null verticalArrangement");
                    throw new KotlinNothingValueException();
                }
            } else if (horizontal != null) {
                horizontal.arrange(density, i6, iArr, LayoutDirection.Ltr, iArr2);
            } else {
                InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null horizontalArrangement");
                throw new KotlinNothingValueException();
            }
            IntProgression indices = ArraysKt.getIndices(iArr2);
            if (z2) {
                indices = RangesKt.reversed(indices);
            }
            int first = indices.getFirst();
            int last = indices.getLast();
            int step = indices.getStep();
            if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                while (true) {
                    int i10 = iArr2[first];
                    LazyGridMeasuredLine lazyGridMeasuredLine = list.get(calculateItemsOffsets$reverseAware(first, z2, size2));
                    if (z2) {
                        i10 = (i6 - i10) - lazyGridMeasuredLine.getMainAxisSize();
                    }
                    addAllFromArray(arrayList, lazyGridMeasuredLine.position(i10, i, i2));
                    if (first == last) {
                        break;
                    }
                    first += step;
                }
            }
        } else {
            int size3 = list2.size() - 1;
            if (size3 >= 0) {
                int i11 = i5;
                while (true) {
                    int i12 = size3 - 1;
                    LazyGridMeasuredItem lazyGridMeasuredItem = list2.get(size3);
                    i11 -= lazyGridMeasuredItem.getMainAxisSizeWithSpacings();
                    lazyGridMeasuredItem.position(i11, 0, i, i2);
                    arrayList.add(lazyGridMeasuredItem);
                    if (i12 < 0) {
                        break;
                    }
                    size3 = i12;
                }
            }
            int size4 = list4.size();
            int i13 = i5;
            for (int i14 = 0; i14 < size4; i14++) {
                LazyGridMeasuredLine lazyGridMeasuredLine2 = list.get(i14);
                addAllFromArray(arrayList, lazyGridMeasuredLine2.position(i13, i, i2));
                i13 += lazyGridMeasuredLine2.getMainAxisSizeWithSpacings();
            }
            int size5 = list3.size();
            for (int i15 = 0; i15 < size5; i15++) {
                LazyGridMeasuredItem lazyGridMeasuredItem2 = list3.get(i15);
                lazyGridMeasuredItem2.position(i13, 0, i, i2);
                arrayList.add(lazyGridMeasuredItem2);
                i13 += lazyGridMeasuredItem2.getMainAxisSizeWithSpacings();
            }
        }
        return arrayList;
    }

    private static final <T> void addAllFromArray(List<T> list, T[] tArr) {
        for (T t : tArr) {
            list.add(t);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:136:0x0376, code lost:
    
        if (r0 == false) goto L150;
     */
    /* JADX WARN: Removed duplicated region for block: B:139:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0525  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0528  */
    /* renamed from: measureLazyGrid-t1x4au0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final LazyGridMeasureResult m1253measureLazyGridt1x4au0(int i, final LazyGridMeasuredLineProvider lazyGridMeasuredLineProvider, final LazyGridMeasuredItemProvider lazyGridMeasuredItemProvider, int i2, int i3, int i4, int i5, int i6, int i7, float f, long j, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z2, Density density, LazyLayoutItemAnimator<LazyGridMeasuredItem> lazyLayoutItemAnimator, int i8, List<Integer> list, boolean z3, boolean z4, LazyGridLayoutInfo lazyGridLayoutInfo, CoroutineScope coroutineScope, final MutableState<Unit> mutableState, GraphicsContext graphicsContext, Function1<? super Integer, ? extends List<Pair<Integer, Constraints>>> function1, Function1<? super Integer, Integer> function12, StickyItemsPlacement stickyItemsPlacement, Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> function3) {
        boolean z5;
        int i9;
        int i10;
        int i11;
        int i12;
        LazyGridMeasuredLine lazyGridMeasuredLine;
        int i13;
        int i14;
        float f2;
        final boolean z6;
        boolean z7;
        int i15;
        int i16;
        List<LazyGridMeasuredLine> list2;
        boolean z8;
        int i17;
        int i18;
        int i19;
        List<LazyGridMeasuredLine> list3;
        boolean z9;
        boolean z10;
        int i20;
        int i21;
        int i22;
        ArrayDeque arrayDeque;
        boolean z11;
        float f3;
        int i23;
        int i24;
        int i25;
        LazyGridMeasuredItem[] items;
        LazyGridMeasuredItem lazyGridMeasuredItem;
        int i26;
        int i27;
        int i28;
        boolean z12 = z4;
        if (!(i3 >= 0)) {
            InlineClassHelperKt.throwIllegalArgumentException("negative beforeContentPadding");
        }
        if (!(i4 >= 0)) {
            InlineClassHelperKt.throwIllegalArgumentException("negative afterContentPadding");
        }
        if (i <= 0) {
            int i29 = Constraints.getMinWidth-impl(j);
            int i30 = Constraints.getMinHeight-impl(j);
            lazyLayoutItemAnimator.onMeasured(0, i29, i30, new ArrayList(), lazyGridMeasuredItemProvider.getKeyIndexMap(), lazyGridMeasuredItemProvider, z, z4, i8, z3, 0, 0, coroutineScope, graphicsContext);
            if (!z12) {
                long m1289getMinSizeToFitDisappearingItemsYbymL2g = lazyLayoutItemAnimator.m1289getMinSizeToFitDisappearingItemsYbymL2g();
                if (!IntSize.equals-impl0(m1289getMinSizeToFitDisappearingItemsYbymL2g, IntSize.Companion.getZero-YbymL2g())) {
                    i29 = ConstraintsKt.constrainWidth-K40F9xA(j, (int) (m1289getMinSizeToFitDisappearingItemsYbymL2g >> 32));
                    i30 = ConstraintsKt.constrainHeight-K40F9xA(j, (int) (m1289getMinSizeToFitDisappearingItemsYbymL2g & 4294967295L));
                }
            }
            return new LazyGridMeasureResult(null, 0, false, 0.0f, (MeasureResult) function3.invoke(Integer.valueOf(i29), Integer.valueOf(i30), new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    Unit measureLazyGrid_t1x4au0$lambda$2;
                    measureLazyGrid_t1x4au0$lambda$2 = LazyGridMeasureKt.measureLazyGrid_t1x4au0$lambda$2((Placeable.PlacementScope) obj);
                    return measureLazyGrid_t1x4au0$lambda$2;
                }
            }), 0.0f, false, coroutineScope, density, i8, function1, function12, CollectionsKt.emptyList(), -i3, i2 + i4, 0, z2, z ? Orientation.Vertical : Orientation.Horizontal, i4, i5);
        }
        int round = Math.round(f);
        int i31 = i7 - round;
        if (i6 == 0 && i31 < 0) {
            round += i31;
            i31 = 0;
        }
        ArrayDeque arrayDeque2 = new ArrayDeque();
        int i32 = -i3;
        int i33 = i32 + (i5 < 0 ? i5 : 0);
        int i34 = i31 + i33;
        int i35 = i6;
        while (i34 < 0 && i35 > 0) {
            int i36 = i35 - 1;
            int i37 = i32;
            LazyGridMeasuredLine andMeasure = lazyGridMeasuredLineProvider.getAndMeasure(i36);
            arrayDeque2.add(0, andMeasure);
            i34 += andMeasure.getMainAxisSizeWithSpacings();
            i35 = i36;
            i32 = i37;
        }
        int i38 = i32;
        if (i34 < i33) {
            round -= i33 - i34;
            i34 = i33;
        }
        int i39 = i34 - i33;
        int i40 = i2 + i4;
        int i41 = i35;
        int coerceAtLeast = RangesKt.coerceAtLeast(i40, 0);
        int i42 = -i39;
        int i43 = i41;
        int i44 = i40;
        int i45 = i39;
        int i46 = 0;
        boolean z13 = false;
        while (i46 < arrayDeque2.size()) {
            if (i42 >= coerceAtLeast) {
                arrayDeque2.remove(i46);
                Unit unit = Unit.INSTANCE;
                z13 = true;
            } else {
                i43++;
                i42 += ((LazyGridMeasuredLine) arrayDeque2.get(i46)).getMainAxisSizeWithSpacings();
                Integer.valueOf(i46);
                i46++;
            }
        }
        boolean z14 = z13;
        int i47 = i43;
        while (i47 < i && (i42 < coerceAtLeast || i42 <= 0 || arrayDeque2.isEmpty())) {
            int i48 = coerceAtLeast;
            LazyGridMeasuredLine andMeasure2 = lazyGridMeasuredLineProvider.getAndMeasure(i47);
            if (andMeasure2.isEmpty()) {
                break;
            }
            int mainAxisSizeWithSpacings = i42 + andMeasure2.getMainAxisSizeWithSpacings();
            if (mainAxisSizeWithSpacings <= i33) {
                i26 = mainAxisSizeWithSpacings;
                i27 = i33;
                if (((LazyGridMeasuredItem) ArraysKt.last(andMeasure2.getItems())).getIndex() != i - 1) {
                    i28 = i47 + 1;
                    i45 -= andMeasure2.getMainAxisSizeWithSpacings();
                    Unit unit2 = Unit.INSTANCE;
                    z14 = true;
                    i47++;
                    i41 = i28;
                    coerceAtLeast = i48;
                    i33 = i27;
                    i42 = i26;
                }
            } else {
                i26 = mainAxisSizeWithSpacings;
                i27 = i33;
            }
            Boolean.valueOf(arrayDeque2.add(andMeasure2));
            i28 = i41;
            i47++;
            i41 = i28;
            coerceAtLeast = i48;
            i33 = i27;
            i42 = i26;
        }
        if (i42 < i2) {
            int i49 = i2 - i42;
            int i50 = i42 + i49;
            int i51 = i41;
            i11 = i45 - i49;
            while (i11 < i3 && i51 > 0) {
                int i52 = i51 - 1;
                boolean z15 = z14;
                LazyGridMeasuredLine andMeasure3 = lazyGridMeasuredLineProvider.getAndMeasure(i52);
                arrayDeque2.add(0, andMeasure3);
                i11 += andMeasure3.getMainAxisSizeWithSpacings();
                z14 = z15;
                i51 = i52;
            }
            z5 = z14;
            i9 = i49 + round;
            if (i11 < 0) {
                i9 += i11;
                i10 = i50 + i11;
                i11 = 0;
            } else {
                i10 = i50;
            }
        } else {
            z5 = z14;
            i9 = round;
            i10 = i42;
            i11 = i45;
        }
        float f4 = (MathKt.getSign(Math.round(f)) != MathKt.getSign(i9) || Math.abs(Math.round(f)) < Math.abs(i9)) ? f : i9;
        float f5 = f - f4;
        float f6 = (!z12 || i9 <= round || f5 > 0.0f) ? 0.0f : (i9 - round) + f5;
        if (!(i11 >= 0)) {
            InlineClassHelperKt.throwIllegalArgumentException("negative initial offset");
        }
        int i53 = -i11;
        LazyGridMeasuredLine lazyGridMeasuredLine2 = (LazyGridMeasuredLine) arrayDeque2.first();
        LazyGridMeasuredItem lazyGridMeasuredItem2 = (LazyGridMeasuredItem) ArraysKt.firstOrNull(lazyGridMeasuredLine2.getItems());
        int index = lazyGridMeasuredItem2 != null ? lazyGridMeasuredItem2.getIndex() : 0;
        LazyGridMeasuredLine lazyGridMeasuredLine3 = (LazyGridMeasuredLine) arrayDeque2.lastOrNull();
        int index2 = (lazyGridMeasuredLine3 == null || (items = lazyGridMeasuredLine3.getItems()) == null || (lazyGridMeasuredItem = (LazyGridMeasuredItem) ArraysKt.lastOrNull(items)) == null) ? 0 : lazyGridMeasuredItem.getIndex();
        List<Integer> list4 = list;
        int i54 = i53;
        int size = list4.size();
        ArrayList arrayList = null;
        int i55 = i11;
        List list5 = null;
        int i56 = 0;
        while (i56 < size) {
            int i57 = size;
            int intValue = list.get(i56).intValue();
            if (intValue >= 0 && intValue < index) {
                ArrayDeque arrayDeque3 = arrayDeque2;
                int spanOf = lazyGridMeasuredLineProvider.spanOf(intValue);
                i21 = index2;
                i22 = index;
                i20 = i44;
                i23 = i38;
                i24 = i54;
                i25 = i57;
                arrayDeque = arrayDeque3;
                z11 = z12;
                f3 = f4;
                LazyGridMeasuredItem mo1210getAndMeasurehBUhpc = lazyGridMeasuredItemProvider.mo1210getAndMeasurehBUhpc(intValue, 0, spanOf, lazyGridMeasuredLineProvider.m1257childConstraintsJhjzzOo$foundation_release(0, spanOf));
                ArrayList arrayList2 = list5 == null ? new ArrayList() : list5;
                arrayList2.add(mo1210getAndMeasurehBUhpc);
                list5 = arrayList2;
            } else {
                i20 = i44;
                i21 = index2;
                i22 = index;
                arrayDeque = arrayDeque2;
                z11 = z12;
                f3 = f4;
                i23 = i38;
                i24 = i54;
                i25 = i57;
            }
            i56++;
            f4 = f3;
            z12 = z11;
            size = i25;
            i54 = i24;
            index2 = i21;
            index = i22;
            i38 = i23;
            i44 = i20;
            arrayDeque2 = arrayDeque;
        }
        int i58 = i44;
        int i59 = index2;
        int i60 = index;
        ArrayDeque arrayDeque4 = arrayDeque2;
        boolean z16 = z12;
        float f7 = f4;
        int i61 = i38;
        int i62 = i54;
        if (list5 == null) {
            list5 = CollectionsKt.emptyList();
        }
        List list6 = (List) arrayDeque4;
        List<LazyGridMeasuredLine> linesRetainedForLookahead = linesRetainedForLookahead(i59, i, lazyGridMeasuredLineProvider, z4, list6, lazyGridLayoutInfo);
        int size2 = list4.size();
        int i63 = 0;
        while (i63 < size2) {
            int intValue2 = list.get(i63).intValue();
            int i64 = i59;
            if (i64 + 1 <= intValue2 && intValue2 < i) {
                if (z16) {
                    int size3 = linesRetainedForLookahead.size();
                    i15 = i64;
                    int i65 = 0;
                    while (true) {
                        if (i65 >= size3) {
                            i16 = i63;
                            list2 = linesRetainedForLookahead;
                            z9 = false;
                            break;
                        }
                        int i66 = size3;
                        LazyGridMeasuredItem[] items2 = linesRetainedForLookahead.get(i65).getItems();
                        i16 = i63;
                        int length = items2.length;
                        list2 = linesRetainedForLookahead;
                        int i67 = 0;
                        while (true) {
                            if (i67 >= length) {
                                z10 = false;
                                break;
                            }
                            LazyGridMeasuredItem[] lazyGridMeasuredItemArr = items2;
                            if (items2[i67].getIndex() == intValue2) {
                                z10 = true;
                                break;
                            }
                            i67++;
                            items2 = lazyGridMeasuredItemArr;
                        }
                        if (z10) {
                            z9 = true;
                            break;
                        }
                        i65++;
                        size3 = i66;
                        linesRetainedForLookahead = list2;
                        i63 = i16;
                    }
                } else {
                    i15 = i64;
                    i16 = i63;
                    list2 = linesRetainedForLookahead;
                }
                z8 = true;
                if (z8) {
                    i17 = size2;
                    i18 = i16;
                    i19 = i15;
                    list3 = list2;
                } else {
                    int spanOf2 = lazyGridMeasuredLineProvider.spanOf(intValue2);
                    i19 = i15;
                    i18 = i16;
                    list3 = list2;
                    i17 = size2;
                    LazyGridMeasuredItem mo1210getAndMeasurehBUhpc2 = lazyGridMeasuredItemProvider.mo1210getAndMeasurehBUhpc(intValue2, 0, spanOf2, lazyGridMeasuredLineProvider.m1257childConstraintsJhjzzOo$foundation_release(0, spanOf2));
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    List list7 = arrayList;
                    list7.add(mo1210getAndMeasurehBUhpc2);
                    arrayList = list7;
                }
                i63 = i18 + 1;
                i59 = i19;
                linesRetainedForLookahead = list3;
                size2 = i17;
            } else {
                i15 = i64;
                i16 = i63;
                list2 = linesRetainedForLookahead;
            }
            z8 = false;
            if (z8) {
            }
            i63 = i18 + 1;
            i59 = i19;
            linesRetainedForLookahead = list3;
            size2 = i17;
        }
        List<LazyGridMeasuredLine> list8 = linesRetainedForLookahead;
        int i68 = i59;
        if (arrayList == null) {
            arrayList = CollectionsKt.emptyList();
        }
        if (i3 > 0 || i5 < 0) {
            int size4 = ((Collection) arrayDeque4).size();
            i12 = i55;
            int i69 = 0;
            while (i69 < size4) {
                int mainAxisSizeWithSpacings2 = ((LazyGridMeasuredLine) arrayDeque4.get(i69)).getMainAxisSizeWithSpacings();
                if (i12 == 0 || mainAxisSizeWithSpacings2 > i12 || i69 == CollectionsKt.getLastIndex(list6)) {
                    break;
                }
                i12 -= mainAxisSizeWithSpacings2;
                i69++;
                lazyGridMeasuredLine2 = (LazyGridMeasuredLine) arrayDeque4.get(i69);
            }
            lazyGridMeasuredLine = lazyGridMeasuredLine2;
        } else {
            lazyGridMeasuredLine = lazyGridMeasuredLine2;
            i12 = i55;
        }
        if (z) {
            i13 = Constraints.getMaxWidth-impl(j);
        } else {
            i13 = ConstraintsKt.constrainWidth-K40F9xA(j, i10);
        }
        if (z) {
            i14 = ConstraintsKt.constrainHeight-K40F9xA(j, i10);
        } else {
            i14 = Constraints.getMaxHeight-impl(j);
        }
        if (!list8.isEmpty()) {
            list6 = CollectionsKt.plus((Collection) arrayDeque4, list8);
        }
        final List<LazyGridMeasuredItem> calculateItemsOffsets = calculateItemsOffsets(list6, list5, arrayList, i13, i14, i10, i2, i62, z, vertical, horizontal, z2, density);
        lazyLayoutItemAnimator.onMeasured((int) f7, i13, i14, calculateItemsOffsets, lazyGridMeasuredItemProvider.getKeyIndexMap(), lazyGridMeasuredItemProvider, z, z4, i8, z3, i12, i10, coroutineScope, graphicsContext);
        if (z16) {
            f2 = f7;
        } else {
            long m1289getMinSizeToFitDisappearingItemsYbymL2g2 = lazyLayoutItemAnimator.m1289getMinSizeToFitDisappearingItemsYbymL2g();
            f2 = f7;
            if (!IntSize.equals-impl0(m1289getMinSizeToFitDisappearingItemsYbymL2g2, IntSize.Companion.getZero-YbymL2g())) {
                int i70 = z ? i14 : i13;
                i13 = ConstraintsKt.constrainWidth-K40F9xA(j, Math.max(i13, (int) (m1289getMinSizeToFitDisappearingItemsYbymL2g2 >> 32)));
                i14 = ConstraintsKt.constrainHeight-K40F9xA(j, Math.max(i14, (int) (m1289getMinSizeToFitDisappearingItemsYbymL2g2 & 4294967295L)));
                int i71 = z ? i14 : i13;
                if (i71 != i70) {
                    int size5 = calculateItemsOffsets.size();
                    for (int i72 = 0; i72 < size5; i72++) {
                        calculateItemsOffsets.get(i72).updateMainAxisLayoutSize(i71);
                    }
                }
            }
        }
        final List applyStickyItems = LazyLayoutStickyItemsKt.applyStickyItems(stickyItemsPlacement, i60, i68, calculateItemsOffsets, lazyGridMeasuredItemProvider.getHeaderIndices(), i3, i4, i13, i14, new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                LazyGridMeasuredItem measureLazyGrid_t1x4au0$lambda$9;
                measureLazyGrid_t1x4au0$lambda$9 = LazyGridMeasureKt.measureLazyGrid_t1x4au0$lambda$9(LazyGridMeasuredLineProvider.this, lazyGridMeasuredItemProvider, ((Integer) obj).intValue());
                return measureLazyGrid_t1x4au0$lambda$9;
            }
        });
        if (i68 == i - 1) {
            z6 = z4;
            if (i10 <= i2) {
                z7 = false;
                return new LazyGridMeasureResult(lazyGridMeasuredLine, i12, z7, f2, (MeasureResult) function3.invoke(Integer.valueOf(i13), Integer.valueOf(i14), new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj) {
                        Unit measureLazyGrid_t1x4au0$lambda$13;
                        measureLazyGrid_t1x4au0$lambda$13 = LazyGridMeasureKt.measureLazyGrid_t1x4au0$lambda$13(MutableState.this, calculateItemsOffsets, applyStickyItems, z6, (Placeable.PlacementScope) obj);
                        return measureLazyGrid_t1x4au0$lambda$13;
                    }
                }), f6, z5, coroutineScope, density, i8, function1, function12, LazyLayoutMeasuredItemKt.updatedVisibleItems(i60, i68, calculateItemsOffsets, applyStickyItems), i61, i58, i, z2, !z ? Orientation.Vertical : Orientation.Horizontal, i4, i5);
            }
        } else {
            z6 = z4;
        }
        z7 = true;
        return new LazyGridMeasureResult(lazyGridMeasuredLine, i12, z7, f2, (MeasureResult) function3.invoke(Integer.valueOf(i13), Integer.valueOf(i14), new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit measureLazyGrid_t1x4au0$lambda$13;
                measureLazyGrid_t1x4au0$lambda$13 = LazyGridMeasureKt.measureLazyGrid_t1x4au0$lambda$13(MutableState.this, calculateItemsOffsets, applyStickyItems, z6, (Placeable.PlacementScope) obj);
                return measureLazyGrid_t1x4au0$lambda$13;
            }
        }), f6, z5, coroutineScope, density, i8, function1, function12, LazyLayoutMeasuredItemKt.updatedVisibleItems(i60, i68, calculateItemsOffsets, applyStickyItems), i61, i58, i, z2, !z ? Orientation.Vertical : Orientation.Horizontal, i4, i5);
    }

    private static final List<LazyGridMeasuredItem> calculateExtraItems(List<Integer> list, LazyGridMeasuredItemProvider lazyGridMeasuredItemProvider, LazyGridMeasuredLineProvider lazyGridMeasuredLineProvider, Function1<? super Integer, Boolean> function1) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            int intValue = list.get(i).intValue();
            if (((Boolean) function1.invoke(Integer.valueOf(intValue))).booleanValue()) {
                int spanOf = lazyGridMeasuredLineProvider.spanOf(intValue);
                LazyGridMeasuredItem mo1210getAndMeasurehBUhpc = lazyGridMeasuredItemProvider.mo1210getAndMeasurehBUhpc(intValue, 0, spanOf, lazyGridMeasuredLineProvider.m1257childConstraintsJhjzzOo$foundation_release(0, spanOf));
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(mo1210getAndMeasurehBUhpc);
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measureLazyGrid_t1x4au0$lambda$13$lambda$12(List list, List list2, boolean z, Placeable.PlacementScope placementScope) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ((LazyGridMeasuredItem) list.get(i)).place(placementScope, z);
        }
        int size2 = list2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            ((LazyGridMeasuredItem) list2.get(i2)).place(placementScope, z);
        }
        return Unit.INSTANCE;
    }
}
