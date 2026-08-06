package androidx.compose.foundation.lazy;

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
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: LazyListMeasure.kt */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u000e\u001a\u009c\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u001c\u001a\u00020\u00032\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001e2\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00112\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2/\u0010+\u001a+\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/0-¢\u0006\u0002\b0\u0012\u0004\u0012\u0002010,H\u0000¢\u0006\u0004\b2\u00103\u001a\\\u00104\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001e2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u001b062\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00032\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001e2\u0006\u00107\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u00112\b\u00108\u001a\u0004\u0018\u00010\"H\u0002\u001a4\u00109\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001e2\u0006\u0010:\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00032\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001eH\u0002\u001a\u008c\u0001\u0010;\u001a\b\u0012\u0004\u0012\u00020\u001b062\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001e2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001e2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001e2\u0006\u0010?\u001a\u00020\u00032\u0006\u0010@\u001a\u00020\u00032\u0006\u0010A\u001a\u00020\u00032\u0006\u0010B\u001a\u00020\u00032\u0006\u0010C\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0002¨\u0006D"}, d2 = {"measureLazyList", "Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "itemsCount", "", "measuredItemProvider", "Landroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;", "mainAxisAvailableSize", "beforeContentPadding", "afterContentPadding", "spaceBetweenItems", "firstVisibleItemIndex", "firstVisibleItemScrollOffset", "scrollToBeConsumed", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "isVertical", "", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "reverseLayout", "density", "Landroidx/compose/ui/unit/Density;", "itemAnimator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "beyondBoundsItemCount", "pinnedItems", "", "hasLookaheadOccurred", "isLookingAhead", "approachLayoutInfo", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "placementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "stickyItemsPlacement", "Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;", "layout", "Lkotlin/Function3;", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measureLazyList-LCrQqZ4", "(ILandroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;IIIIIIFJZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ZLandroidx/compose/ui/unit/Density;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;ILjava/util/List;ZZLandroidx/compose/foundation/lazy/LazyListLayoutInfo;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/graphics/GraphicsContext;Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "createItemsAfterList", "visibleItems", "", "consumedScroll", "lastApproachLayoutInfo", "createItemsBeforeList", "currentFirstItemIndex", "calculateItemsOffsets", "items", "extraItemsBefore", "extraItemsAfter", "layoutWidth", "layoutHeight", "finalMainAxisOffset", "maxOffset", "itemsScrollOffset", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class LazyListMeasureKt {
    private static final int calculateItemsOffsets$reverseAware(int i, boolean z, int i2) {
        return !z ? i : (i2 - i) - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measureLazyList_LCrQqZ4$lambda$2(Placeable.PlacementScope placementScope) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measureLazyList_LCrQqZ4$lambda$11(MutableState mutableState, final List list, final List list2, final boolean z, Placeable.PlacementScope placementScope) {
        placementScope.withMotionFrameOfReferencePlacement(new Function1() { // from class: androidx.compose.foundation.lazy.LazyListMeasureKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit measureLazyList_LCrQqZ4$lambda$11$lambda$10;
                measureLazyList_LCrQqZ4$lambda$11$lambda$10 = LazyListMeasureKt.measureLazyList_LCrQqZ4$lambda$11$lambda$10(list, list2, z, (Placeable.PlacementScope) obj);
                return measureLazyList_LCrQqZ4$lambda$11$lambda$10;
            }
        });
        ObservableScopeInvalidator.m1324attachToScopeimpl(mutableState);
        return Unit.INSTANCE;
    }

    private static final List<LazyListMeasuredItem> createItemsAfterList(List<LazyListMeasuredItem> list, LazyListMeasuredItemProvider lazyListMeasuredItemProvider, int i, int i2, List<Integer> list2, float f, boolean z, LazyListLayoutInfo lazyListLayoutInfo) {
        ArrayList arrayList;
        LazyListItemInfo lazyListItemInfo;
        LazyListMeasuredItem lazyListMeasuredItem;
        LazyListMeasuredItem lazyListMeasuredItem2;
        int mainAxisSizeWithSpacings;
        LazyListMeasuredItem lazyListMeasuredItem3;
        int index;
        int min;
        LazyListMeasuredItem lazyListMeasuredItem4;
        LazyListMeasuredItem lazyListMeasuredItem5;
        int i3 = i - 1;
        int min2 = Math.min(((LazyListMeasuredItem) CollectionsKt.last(list)).getIndex() + i2, i3);
        int index2 = ((LazyListMeasuredItem) CollectionsKt.last(list)).getIndex() + 1;
        if (index2 <= min2) {
            ArrayList arrayList2 = null;
            while (true) {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                arrayList = arrayList2;
                arrayList.add(LazyListMeasuredItemProvider.m1209getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider, index2, 0L, 2, null));
                if (index2 == min2) {
                    break;
                }
                index2++;
                arrayList2 = arrayList;
            }
        } else {
            arrayList = null;
        }
        if (z && lazyListLayoutInfo != null && (!lazyListLayoutInfo.getVisibleItemsInfo().isEmpty())) {
            List<LazyListItemInfo> visibleItemsInfo = lazyListLayoutInfo.getVisibleItemsInfo();
            for (int size = visibleItemsInfo.size() - 1; -1 < size; size--) {
                if (visibleItemsInfo.get(size).getIndex() > min2 && (size == 0 || visibleItemsInfo.get(size - 1).getIndex() <= min2)) {
                    lazyListItemInfo = visibleItemsInfo.get(size);
                    break;
                }
            }
            lazyListItemInfo = null;
            LazyListItemInfo lazyListItemInfo2 = (LazyListItemInfo) CollectionsKt.last(lazyListLayoutInfo.getVisibleItemsInfo());
            if (lazyListItemInfo != null && (index = lazyListItemInfo.getIndex()) <= (min = Math.min(lazyListItemInfo2.getIndex(), i3))) {
                while (true) {
                    if (arrayList != null) {
                        int size2 = arrayList.size();
                        int i4 = 0;
                        while (true) {
                            if (i4 >= size2) {
                                lazyListMeasuredItem5 = null;
                                break;
                            }
                            lazyListMeasuredItem5 = arrayList.get(i4);
                            if (lazyListMeasuredItem5.getIndex() == index) {
                                break;
                            }
                            i4++;
                        }
                        lazyListMeasuredItem4 = lazyListMeasuredItem5;
                    } else {
                        lazyListMeasuredItem4 = null;
                    }
                    if (lazyListMeasuredItem4 == null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(LazyListMeasuredItemProvider.m1209getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider, index, 0L, 2, null));
                    }
                    if (index == min) {
                        break;
                    }
                    index++;
                }
            }
            float viewportEndOffset = ((lazyListLayoutInfo.getViewportEndOffset() - lazyListItemInfo2.getOffset()) - lazyListItemInfo2.getSize()) - f;
            if (viewportEndOffset > 0.0f) {
                int index3 = lazyListItemInfo2.getIndex() + 1;
                int i5 = 0;
                while (index3 < i && i5 < viewportEndOffset) {
                    if (index3 <= min2) {
                        int size3 = list.size();
                        int i6 = 0;
                        while (true) {
                            if (i6 >= size3) {
                                lazyListMeasuredItem3 = null;
                                break;
                            }
                            lazyListMeasuredItem3 = list.get(i6);
                            if (lazyListMeasuredItem3.getIndex() == index3) {
                                break;
                            }
                            i6++;
                        }
                        lazyListMeasuredItem = lazyListMeasuredItem3;
                    } else if (arrayList != null) {
                        int size4 = arrayList.size();
                        int i7 = 0;
                        while (true) {
                            if (i7 >= size4) {
                                lazyListMeasuredItem2 = null;
                                break;
                            }
                            lazyListMeasuredItem2 = arrayList.get(i7);
                            if (lazyListMeasuredItem2.getIndex() == index3) {
                                break;
                            }
                            i7++;
                        }
                        lazyListMeasuredItem = lazyListMeasuredItem2;
                    } else {
                        lazyListMeasuredItem = null;
                    }
                    if (lazyListMeasuredItem != null) {
                        index3++;
                        mainAxisSizeWithSpacings = lazyListMeasuredItem.getMainAxisSizeWithSpacings();
                    } else {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(LazyListMeasuredItemProvider.m1209getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider, index3, 0L, 2, null));
                        index3++;
                        mainAxisSizeWithSpacings = ((LazyListMeasuredItem) CollectionsKt.last(arrayList)).getMainAxisSizeWithSpacings();
                    }
                    i5 += mainAxisSizeWithSpacings;
                }
            }
        }
        if (arrayList != null && ((LazyListMeasuredItem) CollectionsKt.last(arrayList)).getIndex() > min2) {
            min2 = ((LazyListMeasuredItem) CollectionsKt.last(arrayList)).getIndex();
        }
        int size5 = list2.size();
        for (int i8 = 0; i8 < size5; i8++) {
            int intValue = list2.get(i8).intValue();
            if (intValue > min2) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(LazyListMeasuredItemProvider.m1209getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider, intValue, 0L, 2, null));
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    private static final List<LazyListMeasuredItem> createItemsBeforeList(int i, LazyListMeasuredItemProvider lazyListMeasuredItemProvider, int i2, List<Integer> list) {
        int max = Math.max(0, i - i2);
        int i3 = i - 1;
        ArrayList arrayList = null;
        if (max <= i3) {
            while (true) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(LazyListMeasuredItemProvider.m1209getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider, i3, 0L, 2, null));
                if (i3 == max) {
                    break;
                }
                i3--;
            }
        }
        int size = list.size() - 1;
        if (size >= 0) {
            while (true) {
                int i4 = size - 1;
                int intValue = list.get(size).intValue();
                if (intValue < max) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(LazyListMeasuredItemProvider.m1209getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider, intValue, 0L, 2, null));
                }
                if (i4 < 0) {
                    break;
                }
                size = i4;
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    private static final List<LazyListMeasuredItem> calculateItemsOffsets(List<LazyListMeasuredItem> list, List<LazyListMeasuredItem> list2, List<LazyListMeasuredItem> list3, int i, int i2, int i3, int i4, int i5, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z2, Density density) {
        int i6 = z ? i2 : i;
        int i7 = 0;
        boolean z3 = i3 < Math.min(i6, i4);
        if (z3) {
            if (!(i5 == 0)) {
                InlineClassHelperKt.throwIllegalStateException("non-zero itemsScrollOffset");
            }
        }
        ArrayList arrayList = new ArrayList(list.size() + list2.size() + list3.size());
        if (z3) {
            if (!(list2.isEmpty() && list3.isEmpty())) {
                InlineClassHelperKt.throwIllegalArgumentException("no extra items");
            }
            int size = list.size();
            int[] iArr = new int[size];
            while (i7 < size) {
                iArr[i7] = list.get(calculateItemsOffsets$reverseAware(i7, z2, size)).getSize();
                i7++;
            }
            int[] iArr2 = new int[size];
            if (z) {
                if (vertical != null) {
                    vertical.arrange(density, i6, iArr, iArr2);
                } else {
                    InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null verticalArrangement when isVertical == true");
                    throw new KotlinNothingValueException();
                }
            } else if (horizontal != null) {
                horizontal.arrange(density, i6, iArr, LayoutDirection.Ltr, iArr2);
            } else {
                InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null horizontalArrangement when isVertical == false");
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
                    int i8 = iArr2[first];
                    LazyListMeasuredItem lazyListMeasuredItem = list.get(calculateItemsOffsets$reverseAware(first, z2, size));
                    if (z2) {
                        i8 = (i6 - i8) - lazyListMeasuredItem.getSize();
                    }
                    lazyListMeasuredItem.position(i8, i, i2);
                    arrayList.add(lazyListMeasuredItem);
                    if (first == last) {
                        break;
                    }
                    first += step;
                }
            }
        } else {
            int size2 = list2.size();
            int i9 = i5;
            for (int i10 = 0; i10 < size2; i10++) {
                LazyListMeasuredItem lazyListMeasuredItem2 = list2.get(i10);
                i9 -= lazyListMeasuredItem2.getMainAxisSizeWithSpacings();
                lazyListMeasuredItem2.position(i9, i, i2);
                arrayList.add(lazyListMeasuredItem2);
            }
            int size3 = list.size();
            int i11 = i5;
            for (int i12 = 0; i12 < size3; i12++) {
                LazyListMeasuredItem lazyListMeasuredItem3 = list.get(i12);
                lazyListMeasuredItem3.position(i11, i, i2);
                arrayList.add(lazyListMeasuredItem3);
                i11 += lazyListMeasuredItem3.getMainAxisSizeWithSpacings();
            }
            int size4 = list3.size();
            while (i7 < size4) {
                LazyListMeasuredItem lazyListMeasuredItem4 = list3.get(i7);
                lazyListMeasuredItem4.position(i11, i, i2);
                arrayList.add(lazyListMeasuredItem4);
                i11 += lazyListMeasuredItem4.getMainAxisSizeWithSpacings();
                i7++;
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:127:0x03f3  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0404  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x042b  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0450  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x049b  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x04a4  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x04b1  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x04b4  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x04a9  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x04a0  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0461  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x043c  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x040b  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x03fa  */
    /* renamed from: measureLazyList-LCrQqZ4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final LazyListMeasureResult m1203measureLazyListLCrQqZ4(int i, final LazyListMeasuredItemProvider lazyListMeasuredItemProvider, int i2, int i3, int i4, int i5, int i6, int i7, float f, long j, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z2, Density density, LazyLayoutItemAnimator<LazyListMeasuredItem> lazyLayoutItemAnimator, int i8, List<Integer> list, boolean z3, final boolean z4, LazyListLayoutInfo lazyListLayoutInfo, CoroutineScope coroutineScope, final MutableState<Unit> mutableState, GraphicsContext graphicsContext, StickyItemsPlacement stickyItemsPlacement, Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> function3) {
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        LazyListMeasuredItem lazyListMeasuredItem;
        LazyListMeasuredItem lazyListMeasuredItem2;
        int i15;
        List<Integer> list2;
        int i16;
        ArrayDeque arrayDeque;
        int i17;
        float f2;
        int i18;
        Integer valueOf;
        int i19;
        int i20 = 0;
        if (!(i3 >= 0)) {
            InlineClassHelperKt.throwIllegalArgumentException("invalid beforeContentPadding");
        }
        if (!(i4 >= 0)) {
            InlineClassHelperKt.throwIllegalArgumentException("invalid afterContentPadding");
        }
        if (i <= 0) {
            int i21 = Constraints.getMinWidth-impl(j);
            int i22 = Constraints.getMinHeight-impl(j);
            lazyLayoutItemAnimator.onMeasured(0, i21, i22, new ArrayList(), lazyListMeasuredItemProvider.getKeyIndexMap(), lazyListMeasuredItemProvider, z, z4, 1, z3, 0, 0, coroutineScope, graphicsContext);
            if (!z4) {
                long m1289getMinSizeToFitDisappearingItemsYbymL2g = lazyLayoutItemAnimator.m1289getMinSizeToFitDisappearingItemsYbymL2g();
                if (!IntSize.equals-impl0(m1289getMinSizeToFitDisappearingItemsYbymL2g, IntSize.Companion.getZero-YbymL2g())) {
                    i21 = ConstraintsKt.constrainWidth-K40F9xA(j, (int) (m1289getMinSizeToFitDisappearingItemsYbymL2g >> 32));
                    i22 = ConstraintsKt.constrainHeight-K40F9xA(j, (int) (m1289getMinSizeToFitDisappearingItemsYbymL2g & 4294967295L));
                }
            }
            return new LazyListMeasureResult(null, 0, false, 0.0f, (MeasureResult) function3.invoke(Integer.valueOf(i21), Integer.valueOf(i22), new Function1() { // from class: androidx.compose.foundation.lazy.LazyListMeasureKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    Unit measureLazyList_LCrQqZ4$lambda$2;
                    measureLazyList_LCrQqZ4$lambda$2 = LazyListMeasureKt.measureLazyList_LCrQqZ4$lambda$2((Placeable.PlacementScope) obj);
                    return measureLazyList_LCrQqZ4$lambda$2;
                }
            }), 0.0f, false, coroutineScope, density, lazyListMeasuredItemProvider.getChildConstraints(), CollectionsKt.emptyList(), -i3, i2 + i4, 0, z2, z ? Orientation.Vertical : Orientation.Horizontal, i4, i5, null);
        }
        int i23 = i6;
        if (i23 >= i) {
            i23 = i - 1;
            i9 = 0;
        } else {
            i9 = i7;
        }
        int round = Math.round(f);
        int i24 = i9 - round;
        if (i23 != 0 || i24 >= 0) {
            i10 = round;
        } else {
            i10 = round + i24;
            i24 = 0;
        }
        ArrayDeque arrayDeque2 = new ArrayDeque();
        int i25 = -i3;
        int i26 = (i5 < 0 ? i5 : 0) + i25;
        int i27 = i24 + i26;
        int i28 = 0;
        while (i27 < 0 && i23 > 0) {
            int i29 = i23 - 1;
            ArrayDeque arrayDeque3 = arrayDeque2;
            LazyListMeasuredItem m1209getAndMeasure0kLqBqw$default = LazyListMeasuredItemProvider.m1209getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider, i29, 0L, 2, null);
            arrayDeque3.add(0, m1209getAndMeasure0kLqBqw$default);
            i28 = Math.max(i28, m1209getAndMeasure0kLqBqw$default.getCrossAxisSize());
            i27 += m1209getAndMeasure0kLqBqw$default.getMainAxisSizeWithSpacings();
            arrayDeque2 = arrayDeque3;
            i23 = i29;
            i26 = i26;
            i25 = i25;
        }
        int i30 = i28;
        int i31 = i26;
        int i32 = i27;
        int i33 = i25;
        ArrayDeque arrayDeque4 = arrayDeque2;
        if (i32 < i31) {
            i10 -= i31 - i32;
            i32 = i31;
        }
        int i34 = i10;
        int i35 = i32 - i31;
        int i36 = i2 + i4;
        int coerceAtLeast = RangesKt.coerceAtLeast(i36, 0);
        int i37 = -i35;
        int i38 = i23;
        int i39 = i38;
        boolean z5 = false;
        while (i20 < arrayDeque4.size()) {
            if (i37 >= coerceAtLeast) {
                arrayDeque4.remove(i20);
                Unit unit = Unit.INSTANCE;
                z5 = true;
            } else {
                i39++;
                i37 += ((LazyListMeasuredItem) arrayDeque4.get(i20)).getMainAxisSizeWithSpacings();
                Integer.valueOf(i20);
                i20++;
            }
        }
        int i40 = i37;
        int i41 = i39;
        boolean z6 = z5;
        int i42 = i35;
        int i43 = i30;
        int i44 = i38;
        while (i41 < i && (i40 < coerceAtLeast || i40 <= 0 || arrayDeque4.isEmpty())) {
            int i45 = i41;
            int i46 = i43;
            int i47 = coerceAtLeast;
            int i48 = i36;
            int i49 = i34;
            LazyListMeasuredItem m1209getAndMeasure0kLqBqw$default2 = LazyListMeasuredItemProvider.m1209getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider, i41, 0L, 2, null);
            i40 += m1209getAndMeasure0kLqBqw$default2.getMainAxisSizeWithSpacings();
            if (i40 <= i31) {
                i19 = i45;
                if (i19 != i - 1) {
                    i42 -= m1209getAndMeasure0kLqBqw$default2.getMainAxisSizeWithSpacings();
                    Unit unit2 = Unit.INSTANCE;
                    i44 = i19 + 1;
                    i43 = i46;
                    z6 = true;
                    i41 = i19 + 1;
                    i34 = i49;
                    coerceAtLeast = i47;
                    i36 = i48;
                }
            } else {
                i19 = i45;
            }
            int max = Math.max(i46, m1209getAndMeasure0kLqBqw$default2.getCrossAxisSize());
            Boolean.valueOf(arrayDeque4.add(m1209getAndMeasure0kLqBqw$default2));
            i43 = max;
            i41 = i19 + 1;
            i34 = i49;
            coerceAtLeast = i47;
            i36 = i48;
        }
        int i50 = i36;
        int i51 = i34;
        int i52 = i41;
        if (i40 < i2) {
            int i53 = i2 - i40;
            i40 += i53;
            int i54 = i44;
            int i55 = i42 - i53;
            int i56 = i43;
            while (i55 < i3 && i54 > 0) {
                int i57 = i54 - 1;
                LazyListMeasuredItem m1209getAndMeasure0kLqBqw$default3 = LazyListMeasuredItemProvider.m1209getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider, i57, 0L, 2, null);
                arrayDeque4.add(0, m1209getAndMeasure0kLqBqw$default3);
                i56 = Math.max(i56, m1209getAndMeasure0kLqBqw$default3.getCrossAxisSize());
                i55 += m1209getAndMeasure0kLqBqw$default3.getMainAxisSizeWithSpacings();
                i52 = i52;
                i54 = i57;
            }
            int i58 = i55;
            i11 = i52;
            i12 = 0;
            i13 = i51 + i53;
            if (i58 < 0) {
                i13 += i58;
                i40 += i58;
                i43 = i56;
                i44 = i54;
                i14 = 0;
            } else {
                i43 = i56;
                i44 = i54;
                i14 = i58;
            }
        } else {
            i11 = i52;
            i12 = 0;
            i13 = i51;
            i14 = i42;
        }
        float f3 = (MathKt.getSign(Math.round(f)) != MathKt.getSign(i13) || Math.abs(Math.round(f)) < Math.abs(i13)) ? f : i13;
        float f4 = f - f3;
        float f5 = (!z4 || i13 <= i51 || f4 > 0.0f) ? 0.0f : (i13 - i51) + f4;
        if ((i14 >= 0 ? 1 : i12) == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("negative currentFirstItemScrollOffset");
        }
        int i59 = -i14;
        LazyListMeasuredItem lazyListMeasuredItem3 = (LazyListMeasuredItem) arrayDeque4.first();
        if (i3 > 0 || i5 < 0) {
            int size = ((Collection) arrayDeque4).size();
            int i60 = i12;
            while (i60 < size) {
                int mainAxisSizeWithSpacings = ((LazyListMeasuredItem) arrayDeque4.get(i60)).getMainAxisSizeWithSpacings();
                if (i14 == 0 || mainAxisSizeWithSpacings > i14) {
                    break;
                }
                lazyListMeasuredItem = lazyListMeasuredItem3;
                if (i60 == CollectionsKt.getLastIndex((List) arrayDeque4)) {
                    break;
                }
                i14 -= mainAxisSizeWithSpacings;
                i60++;
                lazyListMeasuredItem3 = (LazyListMeasuredItem) arrayDeque4.get(i60);
            }
            lazyListMeasuredItem = lazyListMeasuredItem3;
            lazyListMeasuredItem2 = lazyListMeasuredItem;
            i15 = i8;
            list2 = list;
            i16 = i14;
        } else {
            i15 = i8;
            list2 = list;
            i16 = i14;
            lazyListMeasuredItem2 = lazyListMeasuredItem3;
        }
        List<LazyListMeasuredItem> createItemsBeforeList = createItemsBeforeList(i44, lazyListMeasuredItemProvider, i15, list2);
        int i61 = 0;
        for (int size2 = createItemsBeforeList.size(); i61 < size2; size2 = size2) {
            i43 = Math.max(i43, createItemsBeforeList.get(i61).getCrossAxisSize());
            i61++;
        }
        List list3 = (List) arrayDeque4;
        LazyListMeasuredItem lazyListMeasuredItem4 = lazyListMeasuredItem2;
        int i62 = i11;
        List<LazyListMeasuredItem> createItemsAfterList = createItemsAfterList(list3, lazyListMeasuredItemProvider, i, i8, list, f3, z4, lazyListLayoutInfo);
        int size3 = createItemsAfterList.size();
        int i63 = i43;
        for (int i64 = 0; i64 < size3; i64++) {
            i63 = Math.max(i63, createItemsAfterList.get(i64).getCrossAxisSize());
        }
        boolean z7 = Intrinsics.areEqual(lazyListMeasuredItem4, arrayDeque4.first()) && createItemsBeforeList.isEmpty() && createItemsAfterList.isEmpty();
        if (z) {
            i17 = i63;
            arrayDeque = arrayDeque4;
        } else {
            arrayDeque = arrayDeque4;
            i17 = i40;
        }
        int i65 = ConstraintsKt.constrainWidth-K40F9xA(j, i17);
        if (z) {
            i63 = i40;
        }
        int i66 = ConstraintsKt.constrainHeight-K40F9xA(j, i63);
        final List<LazyListMeasuredItem> calculateItemsOffsets = calculateItemsOffsets(list3, createItemsBeforeList, createItemsAfterList, i65, i66, i40, i2, i59, z, vertical, horizontal, z2, density);
        lazyLayoutItemAnimator.onMeasured((int) f3, i65, i66, calculateItemsOffsets, lazyListMeasuredItemProvider.getKeyIndexMap(), lazyListMeasuredItemProvider, z, z4, 1, z3, i16, i40, coroutineScope, graphicsContext);
        if (z4) {
            f2 = f3;
        } else {
            long m1289getMinSizeToFitDisappearingItemsYbymL2g2 = lazyLayoutItemAnimator.m1289getMinSizeToFitDisappearingItemsYbymL2g();
            f2 = f3;
            if (!IntSize.equals-impl0(m1289getMinSizeToFitDisappearingItemsYbymL2g2, IntSize.Companion.getZero-YbymL2g())) {
                int i67 = z ? i66 : i65;
                i18 = i40;
                i65 = ConstraintsKt.constrainWidth-K40F9xA(j, Math.max(i65, (int) (m1289getMinSizeToFitDisappearingItemsYbymL2g2 >> 32)));
                i66 = ConstraintsKt.constrainHeight-K40F9xA(j, Math.max(i66, (int) (m1289getMinSizeToFitDisappearingItemsYbymL2g2 & 4294967295L)));
                int i68 = z ? i66 : i65;
                if (i68 != i67) {
                    int size4 = calculateItemsOffsets.size();
                    for (int i69 = 0; i69 < size4; i69++) {
                        calculateItemsOffsets.get(i69).updateMainAxisLayoutSize(i68);
                    }
                }
                LazyListMeasuredItem lazyListMeasuredItem5 = (LazyListMeasuredItem) arrayDeque.firstOrNull();
                int index = lazyListMeasuredItem5 == null ? lazyListMeasuredItem5.getIndex() : 0;
                LazyListMeasuredItem lazyListMeasuredItem6 = (LazyListMeasuredItem) arrayDeque.lastOrNull();
                final List applyStickyItems = LazyLayoutStickyItemsKt.applyStickyItems(stickyItemsPlacement, index, lazyListMeasuredItem6 == null ? lazyListMeasuredItem6.getIndex() : 0, calculateItemsOffsets, lazyListMeasuredItemProvider.getHeaderIndexes(), i3, i4, i65, i66, new Function1() { // from class: androidx.compose.foundation.lazy.LazyListMeasureKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        LazyListMeasuredItem m1209getAndMeasure0kLqBqw$default4;
                        m1209getAndMeasure0kLqBqw$default4 = LazyListMeasuredItemProvider.m1209getAndMeasure0kLqBqw$default(LazyListMeasuredItemProvider.this, ((Integer) obj).intValue(), 0L, 2, null);
                        return m1209getAndMeasure0kLqBqw$default4;
                    }
                });
                Integer num = null;
                if (!z7) {
                    LazyListMeasuredItem lazyListMeasuredItem7 = (LazyListMeasuredItem) CollectionsKt.firstOrNull(calculateItemsOffsets);
                    if (lazyListMeasuredItem7 != null) {
                        valueOf = Integer.valueOf(lazyListMeasuredItem7.getIndex());
                    }
                    valueOf = null;
                } else {
                    LazyListMeasuredItem lazyListMeasuredItem8 = (LazyListMeasuredItem) arrayDeque.firstOrNull();
                    if (lazyListMeasuredItem8 != null) {
                        valueOf = Integer.valueOf(lazyListMeasuredItem8.getIndex());
                    }
                    valueOf = null;
                }
                if (!z7) {
                    LazyListMeasuredItem lazyListMeasuredItem9 = (LazyListMeasuredItem) CollectionsKt.lastOrNull(calculateItemsOffsets);
                    if (lazyListMeasuredItem9 != null) {
                        num = Integer.valueOf(lazyListMeasuredItem9.getIndex());
                    }
                } else {
                    LazyListMeasuredItem lazyListMeasuredItem10 = (LazyListMeasuredItem) arrayDeque.lastOrNull();
                    if (lazyListMeasuredItem10 != null) {
                        num = Integer.valueOf(lazyListMeasuredItem10.getIndex());
                    }
                }
                return new LazyListMeasureResult(lazyListMeasuredItem4, i16, i62 >= i || i18 > i2, f2, (MeasureResult) function3.invoke(Integer.valueOf(i65), Integer.valueOf(i66), new Function1() { // from class: androidx.compose.foundation.lazy.LazyListMeasureKt$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj) {
                        Unit measureLazyList_LCrQqZ4$lambda$11;
                        measureLazyList_LCrQqZ4$lambda$11 = LazyListMeasureKt.measureLazyList_LCrQqZ4$lambda$11(MutableState.this, calculateItemsOffsets, applyStickyItems, z4, (Placeable.PlacementScope) obj);
                        return measureLazyList_LCrQqZ4$lambda$11;
                    }
                }), f5, z6, coroutineScope, density, lazyListMeasuredItemProvider.getChildConstraints(), LazyLayoutMeasuredItemKt.updatedVisibleItems(valueOf == null ? valueOf.intValue() : 0, num == null ? num.intValue() : 0, calculateItemsOffsets, applyStickyItems), i33, i50, i, z2, !z ? Orientation.Vertical : Orientation.Horizontal, i4, i5, null);
            }
        }
        i18 = i40;
        LazyListMeasuredItem lazyListMeasuredItem52 = (LazyListMeasuredItem) arrayDeque.firstOrNull();
        if (lazyListMeasuredItem52 == null) {
        }
        LazyListMeasuredItem lazyListMeasuredItem62 = (LazyListMeasuredItem) arrayDeque.lastOrNull();
        final List applyStickyItems2 = LazyLayoutStickyItemsKt.applyStickyItems(stickyItemsPlacement, index, lazyListMeasuredItem62 == null ? lazyListMeasuredItem62.getIndex() : 0, calculateItemsOffsets, lazyListMeasuredItemProvider.getHeaderIndexes(), i3, i4, i65, i66, new Function1() { // from class: androidx.compose.foundation.lazy.LazyListMeasureKt$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                LazyListMeasuredItem m1209getAndMeasure0kLqBqw$default4;
                m1209getAndMeasure0kLqBqw$default4 = LazyListMeasuredItemProvider.m1209getAndMeasure0kLqBqw$default(LazyListMeasuredItemProvider.this, ((Integer) obj).intValue(), 0L, 2, null);
                return m1209getAndMeasure0kLqBqw$default4;
            }
        });
        Integer num2 = null;
        if (!z7) {
        }
        if (!z7) {
        }
        if (i62 >= i) {
        }
        if (!z) {
        }
        return new LazyListMeasureResult(lazyListMeasuredItem4, i16, i62 >= i || i18 > i2, f2, (MeasureResult) function3.invoke(Integer.valueOf(i65), Integer.valueOf(i66), new Function1() { // from class: androidx.compose.foundation.lazy.LazyListMeasureKt$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit measureLazyList_LCrQqZ4$lambda$11;
                measureLazyList_LCrQqZ4$lambda$11 = LazyListMeasureKt.measureLazyList_LCrQqZ4$lambda$11(MutableState.this, calculateItemsOffsets, applyStickyItems2, z4, (Placeable.PlacementScope) obj);
                return measureLazyList_LCrQqZ4$lambda$11;
            }
        }), f5, z6, coroutineScope, density, lazyListMeasuredItemProvider.getChildConstraints(), LazyLayoutMeasuredItemKt.updatedVisibleItems(valueOf == null ? valueOf.intValue() : 0, num2 == null ? num2.intValue() : 0, calculateItemsOffsets, applyStickyItems2), i33, i50, i, z2, !z ? Orientation.Vertical : Orientation.Horizontal, i4, i5, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measureLazyList_LCrQqZ4$lambda$11$lambda$10(List list, List list2, boolean z, Placeable.PlacementScope placementScope) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ((LazyListMeasuredItem) list.get(i)).place(placementScope, z);
        }
        int size2 = list2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            ((LazyListMeasuredItem) list2.get(i2)).place(placementScope, z);
        }
        return Unit.INSTANCE;
    }
}
