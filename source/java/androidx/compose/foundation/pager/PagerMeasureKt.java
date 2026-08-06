package androidx.compose.foundation.pager;

import androidx.collection.MutableIntObjectMap;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.gestures.snapping.SnapPositionKt;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.p002ui.Alignment;
import androidx.compose.p002ui.layout.Measurable;
import androidx.compose.p002ui.layout.MeasureResult;
import androidx.compose.p002ui.layout.Placeable;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: PagerMeasure.kt */
@Metadata(d1 = {"\u0000®\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u001a\u0082\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2/\u0010#\u001a+\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'0%¢\u0006\u0002\b(\u0012\u0004\u0012\u00020)0$2\u0012\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0\u001c0+H\u0000¢\u0006\u0004\b-\u0010.\u001aH\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u001c2\u0006\u00101\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002000%H\u0002\u001a@\u00104\u001a\b\u0012\u0004\u0012\u0002000\u001c2\u0006\u00105\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002000%H\u0002\u001aH\u00106\u001a\u0004\u0018\u0001002\u0006\u00107\u001a\u00020\u00042\f\u00108\u001a\b\u0012\u0004\u0012\u0002000\u001c2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u00109\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a{\u00103\u001a\u000200*\u00020\u00022\u0006\u0010:\u001a\u00020\u00042\u0006\u0010;\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010<\u001a\u00020=2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00042\u0012\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0\u001c0+H\u0002¢\u0006\u0004\b>\u0010?\u001a\u008c\u0001\u0010@\u001a\b\u0012\u0004\u0012\u0002000A*\u00020\u00022\f\u0010B\u001a\b\u0012\u0004\u0012\u0002000\u001c2\f\u0010C\u001a\b\u0012\u0004\u0012\u0002000\u001c2\f\u0010D\u001a\b\u0012\u0004\u0012\u0002000\u001c2\u0006\u0010E\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u00042\u0006\u0010G\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\u00042\u0006\u0010I\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010J\u001a\u00020K2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004H\u0002\u001a\u0017\u0010O\u001a\u00020'2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020R0QH\u0082\b\"\u000e\u0010L\u001a\u00020MX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010N\u001a\u00020MX\u0080T¢\u0006\u0002\n\u0000¨\u0006S"}, d2 = {"measurePager", "Landroidx/compose/foundation/pager/PagerMeasureResult;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "pageCount", "", "pagerItemProvider", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "mainAxisAvailableSize", "beforeContentPadding", "afterContentPadding", "spaceBetweenPages", "currentPage", "currentPageOffset", "constraints", "Landroidx/compose/ui/unit/Constraints;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "reverseLayout", "", "visualPageOffset", "Landroidx/compose/ui/unit/IntOffset;", "pageAvailableSize", "beyondViewportPageCount", "pinnedPages", "", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "placementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "layout", "Lkotlin/Function3;", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "placeablesCache", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/compose/ui/layout/Placeable;", "measurePager-BiYVr7A", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;ILandroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;IIIIIIJLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/Alignment$Horizontal;ZJIILjava/util/List;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Landroidx/compose/runtime/MutableState;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function3;Landroidx/collection/MutableIntObjectMap;)Landroidx/compose/foundation/pager/PagerMeasureResult;", "createPagesAfterList", "Landroidx/compose/foundation/pager/MeasuredPage;", "currentLastPage", "pagesCount", "getAndMeasure", "createPagesBeforeList", "currentFirstPage", "calculateNewCurrentPage", "viewportSize", "visiblePagesInfo", "itemSize", "index", "childConstraints", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getAndMeasure-G5IdpRk", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;IJLandroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;JLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/unit/LayoutDirection;ZILandroidx/collection/MutableIntObjectMap;)Landroidx/compose/foundation/pager/MeasuredPage;", "calculatePagesOffsets", "", "pages", "extraPagesBefore", "extraPagesAfter", "layoutWidth", "layoutHeight", "finalMainAxisOffset", "maxOffset", "pagesScrollOffset", "density", "Landroidx/compose/ui/unit/Density;", "MinPageOffset", "", "MaxPageOffset", "debugLog", "generateMsg", "Lkotlin/Function0;", "", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class PagerMeasureKt {
    public static final float MaxPageOffset = 0.5f;
    public static final float MinPageOffset = -0.5f;

    private static final int calculatePagesOffsets$reverseAware(int i, boolean z, int i2) {
        return !z ? i : (i2 - i) - 1;
    }

    private static final void debugLog(Function0<String> function0) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measurePager_BiYVr7A$lambda$3(Placeable.PlacementScope placementScope) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasuredPage measurePager_BiYVr7A$lambda$10(LazyLayoutMeasureScope lazyLayoutMeasureScope, long j, PagerLazyLayoutItemProvider pagerLazyLayoutItemProvider, long j2, Orientation orientation, Alignment.Horizontal horizontal, Alignment.Vertical vertical, boolean z, int i, MutableIntObjectMap mutableIntObjectMap, int i2) {
        return m1412getAndMeasureG5IdpRk(lazyLayoutMeasureScope, i2, j, pagerLazyLayoutItemProvider, j2, orientation, horizontal, vertical, lazyLayoutMeasureScope.getLayoutDirection(), z, i, mutableIntObjectMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasuredPage measurePager_BiYVr7A$lambda$12(LazyLayoutMeasureScope lazyLayoutMeasureScope, long j, PagerLazyLayoutItemProvider pagerLazyLayoutItemProvider, long j2, Orientation orientation, Alignment.Horizontal horizontal, Alignment.Vertical vertical, boolean z, int i, MutableIntObjectMap mutableIntObjectMap, int i2) {
        return m1412getAndMeasureG5IdpRk(lazyLayoutMeasureScope, i2, j, pagerLazyLayoutItemProvider, j2, orientation, horizontal, vertical, lazyLayoutMeasureScope.getLayoutDirection(), z, i, mutableIntObjectMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measurePager_BiYVr7A$lambda$20(MutableState mutableState, final List list, Placeable.PlacementScope placementScope) {
        placementScope.withMotionFrameOfReferencePlacement(new Function1() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit measurePager_BiYVr7A$lambda$20$lambda$19;
                measurePager_BiYVr7A$lambda$20$lambda$19 = PagerMeasureKt.measurePager_BiYVr7A$lambda$20$lambda$19(list, (Placeable.PlacementScope) obj);
                return measurePager_BiYVr7A$lambda$20$lambda$19;
            }
        });
        ObservableScopeInvalidator.m1324attachToScopeimpl(mutableState);
        return Unit.INSTANCE;
    }

    private static final List<MeasuredPage> createPagesAfterList(int i, int i2, int i3, List<Integer> list, Function1<? super Integer, MeasuredPage> function1) {
        int min = Math.min(i3, (i2 - i) - 1) + i;
        int i4 = i + 1;
        ArrayList arrayList = null;
        if (i4 <= min) {
            while (true) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(function1.invoke(Integer.valueOf(i4)));
                if (i4 == min) {
                    break;
                }
                i4++;
            }
        }
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            int intValue = list.get(i5).intValue();
            if (min + 1 <= intValue && intValue < i2) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(function1.invoke(Integer.valueOf(intValue)));
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    private static final List<MeasuredPage> createPagesBeforeList(int i, int i2, List<Integer> list, Function1<? super Integer, MeasuredPage> function1) {
        int max = Math.max(0, i - i2);
        int i3 = i - 1;
        ArrayList arrayList = null;
        if (max <= i3) {
            while (true) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(function1.invoke(Integer.valueOf(i3)));
                if (i3 == max) {
                    break;
                }
                i3--;
            }
        }
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            int intValue = list.get(i4).intValue();
            if (intValue < max) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(function1.invoke(Integer.valueOf(intValue)));
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    /* renamed from: getAndMeasure-G5IdpRk, reason: not valid java name */
    private static final MeasuredPage m1412getAndMeasureG5IdpRk(LazyLayoutMeasureScope lazyLayoutMeasureScope, int i, long j, PagerLazyLayoutItemProvider pagerLazyLayoutItemProvider, long j2, Orientation orientation, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection, boolean z, int i2, MutableIntObjectMap<List<Placeable>> mutableIntObjectMap) {
        List<Placeable> list;
        Object key = pagerLazyLayoutItemProvider.getKey(i);
        List<Placeable> list2 = mutableIntObjectMap.get(i);
        if (list2 != null) {
            list = list2;
        } else {
            List<Measurable> compose = lazyLayoutMeasureScope.compose(i);
            int size = compose.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i3 = 0; i3 < size; i3++) {
                arrayList.add(compose.get(i3).mo6318measureBRTryo0(j));
            }
            ArrayList arrayList2 = arrayList;
            mutableIntObjectMap.set(i, arrayList2);
            list = arrayList2;
        }
        return new MeasuredPage(i, i2, list, j2, key, orientation, horizontal, vertical, layoutDirection, z, null);
    }

    private static final List<MeasuredPage> calculatePagesOffsets(LazyLayoutMeasureScope lazyLayoutMeasureScope, List<MeasuredPage> list, List<MeasuredPage> list2, List<MeasuredPage> list3, int i, int i2, int i3, int i4, int i5, Orientation orientation, boolean z, Density density, int i6, int i7) {
        int i8;
        int i9;
        ArrayList arrayList;
        int i10;
        int i11 = i5;
        int i12 = i7 + i6;
        if (orientation == Orientation.Vertical) {
            i8 = i4;
            i9 = i2;
        } else {
            i8 = i4;
            i9 = i;
        }
        int i13 = 0;
        boolean z2 = i3 < Math.min(i9, i8);
        if (z2) {
            if (!(i11 == 0)) {
                InlineClassHelperKt.throwIllegalStateException("non-zero pagesScrollOffset=" + i11);
            }
        }
        ArrayList arrayList2 = new ArrayList(list.size() + list2.size() + list3.size());
        if (z2) {
            if (!(list2.isEmpty() && list3.isEmpty())) {
                InlineClassHelperKt.throwIllegalArgumentException("No extra pages");
            }
            int size = list.size();
            int[] iArr = new int[size];
            while (i13 < size) {
                iArr[i13] = i7;
                i13++;
            }
            int[] iArr2 = new int[size];
            Arrangement.HorizontalOrVertical m913spacedBy0680j_4 = Arrangement.Absolute.INSTANCE.m913spacedBy0680j_4(lazyLayoutMeasureScope.toDp-u2uoSUM(i6));
            if (orientation == Orientation.Vertical) {
                m913spacedBy0680j_4.arrange(density, i9, iArr, iArr2);
                arrayList = arrayList2;
                i10 = i9;
            } else {
                arrayList = arrayList2;
                i10 = i9;
                m913spacedBy0680j_4.arrange(density, i9, iArr, LayoutDirection.Ltr, iArr2);
            }
            IntProgression indices = ArraysKt.getIndices(iArr2);
            if (z) {
                indices = RangesKt.reversed(indices);
            }
            int first = indices.getFirst();
            int last = indices.getLast();
            int step = indices.getStep();
            if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                while (true) {
                    int i14 = iArr2[first];
                    MeasuredPage measuredPage = list.get(calculatePagesOffsets$reverseAware(first, z, size));
                    if (z) {
                        i14 = (i10 - i14) - measuredPage.getSize();
                    }
                    measuredPage.position(i14, i, i2);
                    arrayList.add(measuredPage);
                    if (first == last) {
                        break;
                    }
                    first += step;
                }
            }
        } else {
            arrayList = arrayList2;
            int size2 = list2.size();
            int i15 = i11;
            for (int i16 = 0; i16 < size2; i16++) {
                MeasuredPage measuredPage2 = list2.get(i16);
                i15 -= i12;
                measuredPage2.position(i15, i, i2);
                arrayList.add(measuredPage2);
            }
            int size3 = list.size();
            for (int i17 = 0; i17 < size3; i17++) {
                MeasuredPage measuredPage3 = list.get(i17);
                measuredPage3.position(i11, i, i2);
                arrayList.add(measuredPage3);
                i11 += i12;
            }
            int size4 = list3.size();
            while (i13 < size4) {
                MeasuredPage measuredPage4 = list3.get(i13);
                measuredPage4.position(i11, i, i2);
                arrayList.add(measuredPage4);
                i11 += i12;
                i13++;
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: measurePager-BiYVr7A, reason: not valid java name */
    public static final PagerMeasureResult m1413measurePagerBiYVr7A(final LazyLayoutMeasureScope lazyLayoutMeasureScope, int i, final PagerLazyLayoutItemProvider pagerLazyLayoutItemProvider, int i2, int i3, int i4, int i5, int i6, int i7, long j, final Orientation orientation, final Alignment.Vertical vertical, final Alignment.Horizontal horizontal, final boolean z, final long j2, final int i8, int i9, List<Integer> list, SnapPosition snapPosition, final MutableState<Unit> mutableState, CoroutineScope coroutineScope, Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> function3, final MutableIntObjectMap<List<Placeable>> mutableIntObjectMap) {
        int i10;
        int i11;
        int i12;
        int i13;
        MeasuredPage measuredPage;
        int i14;
        int i15;
        long j3;
        List<MeasuredPage> list2;
        ArrayList arrayList;
        ArrayList arrayList2;
        int i16;
        int i17;
        int i18 = 0;
        if (!(i3 >= 0)) {
            InlineClassHelperKt.throwIllegalArgumentException("negative beforeContentPadding");
        }
        if (!(i4 >= 0)) {
            InlineClassHelperKt.throwIllegalArgumentException("negative afterContentPadding");
        }
        int coerceAtLeast = RangesKt.coerceAtLeast(i8 + i5, 0);
        int coerceAtMost = RangesKt.coerceAtMost(i9, i);
        if (i <= 0) {
            return new PagerMeasureResult(CollectionsKt.emptyList(), i8, i5, i4, orientation, -i3, i2 + i4, false, coerceAtMost, null, null, 0.0f, 0, false, snapPosition, (MeasureResult) function3.invoke(Integer.valueOf(Constraints.getMinWidth-impl(j)), Integer.valueOf(Constraints.getMinHeight-impl(j)), new Function1() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit measurePager_BiYVr7A$lambda$3;
                    measurePager_BiYVr7A$lambda$3 = PagerMeasureKt.measurePager_BiYVr7A$lambda$3((Placeable.PlacementScope) obj);
                    return measurePager_BiYVr7A$lambda$3;
                }
            }), false, null, null, coroutineScope, 393216, null);
        }
        int i19 = coerceAtMost;
        final long Constraints$default = ConstraintsKt.Constraints$default(0, orientation == Orientation.Vertical ? Constraints.getMaxWidth-impl(j) : i8, 0, orientation != Orientation.Vertical ? Constraints.getMaxHeight-impl(j) : i8, 5, (Object) null);
        int i20 = i6;
        int i21 = i7;
        while (i20 > 0 && i21 > 0) {
            i20--;
            i21 -= coerceAtLeast;
        }
        int i22 = i21 * (-1);
        if (i20 >= i) {
            i20 = i - 1;
            i22 = 0;
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        int i23 = -i3;
        int i24 = (i5 < 0 ? i5 : 0) + i23;
        int i25 = i22 + i24;
        int i26 = 0;
        while (i25 < 0 && i20 > 0) {
            int i27 = i20 - 1;
            ArrayDeque arrayDeque2 = arrayDeque;
            int i28 = coerceAtLeast;
            int i29 = i18;
            MeasuredPage m1412getAndMeasureG5IdpRk = m1412getAndMeasureG5IdpRk(lazyLayoutMeasureScope, i27, Constraints$default, pagerLazyLayoutItemProvider, j2, orientation, horizontal, vertical, lazyLayoutMeasureScope.getLayoutDirection(), z, i8, mutableIntObjectMap);
            arrayDeque2.add(i29, m1412getAndMeasureG5IdpRk);
            i26 = Math.max(i26, m1412getAndMeasureG5IdpRk.getCrossAxisSize());
            i25 += i28;
            i24 = i24;
            coerceAtLeast = i28;
            arrayDeque = arrayDeque2;
            i18 = i29;
            i20 = i27;
            i23 = i23;
            i19 = i19;
        }
        int i30 = i25;
        int i31 = i23;
        int i32 = i24;
        ArrayDeque arrayDeque3 = arrayDeque;
        int i33 = coerceAtLeast;
        int i34 = i19;
        int i35 = i18;
        int i36 = (i30 < i32 ? i32 : i30) - i32;
        int i37 = i2 + i4;
        int coerceAtLeast2 = RangesKt.coerceAtLeast(i37, i35);
        int i38 = -i36;
        int i39 = i35;
        int i40 = i39;
        int i41 = i20;
        while (i39 < arrayDeque3.size()) {
            if (i38 >= coerceAtLeast2) {
                arrayDeque3.remove(i39);
                Unit unit = Unit.INSTANCE;
                i40 = 1;
            } else {
                i41++;
                i38 += i33;
                Integer.valueOf(i39);
                i39++;
            }
        }
        int i42 = i20;
        int i43 = i36;
        int i44 = i40;
        int i45 = i41;
        int i46 = i38;
        while (i45 < i && (i46 < coerceAtLeast2 || i46 <= 0 || arrayDeque3.isEmpty())) {
            int i47 = i37;
            int i48 = i46;
            int i49 = i45;
            int i50 = coerceAtLeast2;
            MeasuredPage m1412getAndMeasureG5IdpRk2 = m1412getAndMeasureG5IdpRk(lazyLayoutMeasureScope, i45, Constraints$default, pagerLazyLayoutItemProvider, j2, orientation, horizontal, vertical, lazyLayoutMeasureScope.getLayoutDirection(), z, i8, mutableIntObjectMap);
            int i51 = i - 1;
            i46 = (i49 == i51 ? i8 : i33) + i48;
            if (i46 <= i32 && i49 != i51) {
                i43 -= i33;
                Unit unit2 = Unit.INSTANCE;
                i42 = i49 + 1;
                i44 = 1;
            } else {
                i26 = Math.max(i26, m1412getAndMeasureG5IdpRk2.getCrossAxisSize());
                Boolean.valueOf(arrayDeque3.add(m1412getAndMeasureG5IdpRk2));
            }
            i45 = i49 + 1;
            i37 = i47;
            coerceAtLeast2 = i50;
        }
        int i52 = i37;
        int i53 = i46;
        int i54 = i45;
        if (i53 < i2) {
            int i55 = i2 - i53;
            int i56 = i43 - i55;
            int i57 = i55 + i53;
            int i58 = i3;
            int i59 = i56;
            int i60 = 0;
            while (i59 < i58 && i42 > 0) {
                i42--;
                int i61 = i54;
                int i62 = i60;
                MeasuredPage m1412getAndMeasureG5IdpRk3 = m1412getAndMeasureG5IdpRk(lazyLayoutMeasureScope, i42, Constraints$default, pagerLazyLayoutItemProvider, j2, orientation, horizontal, vertical, lazyLayoutMeasureScope.getLayoutDirection(), z, i8, mutableIntObjectMap);
                arrayDeque3.add(i62, m1412getAndMeasureG5IdpRk3);
                i26 = Math.max(i26, m1412getAndMeasureG5IdpRk3.getCrossAxisSize());
                i59 += i33;
                i58 = i3;
                i60 = i62;
                i54 = i61;
            }
            i10 = i54;
            i11 = i60;
            if (i59 < 0) {
                i13 = i11;
                i53 = i57 + i59;
            } else {
                i13 = i59;
                i53 = i57;
            }
            i12 = i42;
        } else {
            i10 = i54;
            i11 = 0;
            i12 = i42;
            i13 = i43;
        }
        if ((i13 >= 0 ? 1 : i11) == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("invalid currentFirstPageScrollOffset");
        }
        int i63 = -i13;
        MeasuredPage measuredPage2 = (MeasuredPage) arrayDeque3.first();
        if (i3 > 0 || i5 < 0) {
            int size = ((Collection) arrayDeque3).size();
            int i64 = i13;
            int i65 = i11;
            while (i65 < size && i64 != 0 && i33 <= i64 && i65 != CollectionsKt.getLastIndex((List) arrayDeque3)) {
                i64 -= i33;
                i65++;
                measuredPage2 = (MeasuredPage) arrayDeque3.get(i65);
            }
            measuredPage = measuredPage2;
            i14 = i64;
        } else {
            i14 = i13;
            measuredPage = measuredPage2;
        }
        int i66 = i26;
        MeasuredPage measuredPage3 = measuredPage;
        List<MeasuredPage> createPagesBeforeList = createPagesBeforeList(i12, i34, list, new Function1() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                MeasuredPage measurePager_BiYVr7A$lambda$10;
                measurePager_BiYVr7A$lambda$10 = PagerMeasureKt.measurePager_BiYVr7A$lambda$10(LazyLayoutMeasureScope.this, Constraints$default, pagerLazyLayoutItemProvider, j2, orientation, horizontal, vertical, z, i8, mutableIntObjectMap, ((Integer) obj).intValue());
                return measurePager_BiYVr7A$lambda$10;
            }
        });
        int size2 = createPagesBeforeList.size();
        int i67 = i66;
        for (int i68 = 0; i68 < size2; i68++) {
            i67 = Math.max(i67, createPagesBeforeList.get(i68).getCrossAxisSize());
        }
        int i69 = i53;
        List<MeasuredPage> createPagesAfterList = createPagesAfterList(((MeasuredPage) arrayDeque3.last()).getIndex(), i, i34, list, new Function1() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                MeasuredPage measurePager_BiYVr7A$lambda$12;
                measurePager_BiYVr7A$lambda$12 = PagerMeasureKt.measurePager_BiYVr7A$lambda$12(LazyLayoutMeasureScope.this, Constraints$default, pagerLazyLayoutItemProvider, j2, orientation, horizontal, vertical, z, i8, mutableIntObjectMap, ((Integer) obj).intValue());
                return measurePager_BiYVr7A$lambda$12;
            }
        });
        int size3 = createPagesAfterList.size();
        int i70 = i67;
        for (int i71 = 0; i71 < size3; i71++) {
            i70 = Math.max(i70, createPagesAfterList.get(i71).getCrossAxisSize());
        }
        boolean z2 = Intrinsics.areEqual(measuredPage3, arrayDeque3.first()) && createPagesBeforeList.isEmpty() && createPagesAfterList.isEmpty();
        if (orientation == Orientation.Vertical) {
            j3 = j;
            i15 = i70;
        } else {
            i15 = i69;
            j3 = j;
        }
        int i72 = ConstraintsKt.constrainWidth-K40F9xA(j3, i15);
        if (orientation == Orientation.Vertical) {
            i70 = i69;
        }
        int i73 = ConstraintsKt.constrainHeight-K40F9xA(j3, i70);
        final List<MeasuredPage> calculatePagesOffsets = calculatePagesOffsets(lazyLayoutMeasureScope, (List) arrayDeque3, createPagesBeforeList, createPagesAfterList, i72, i73, i69, i2, i63, orientation, z, lazyLayoutMeasureScope, i5, i8);
        if (z2) {
            list2 = calculatePagesOffsets;
        } else {
            ArrayList arrayList3 = new ArrayList(calculatePagesOffsets.size());
            int size4 = calculatePagesOffsets.size();
            for (int i74 = 0; i74 < size4; i74++) {
                MeasuredPage measuredPage4 = calculatePagesOffsets.get(i74);
                MeasuredPage measuredPage5 = measuredPage4;
                if (measuredPage5.getIndex() >= ((MeasuredPage) arrayDeque3.first()).getIndex() && measuredPage5.getIndex() <= ((MeasuredPage) arrayDeque3.last()).getIndex()) {
                    arrayList3.add(measuredPage4);
                }
            }
            list2 = arrayList3;
        }
        if (createPagesBeforeList.isEmpty()) {
            arrayList = CollectionsKt.emptyList();
        } else {
            ArrayList arrayList4 = new ArrayList(calculatePagesOffsets.size());
            int size5 = calculatePagesOffsets.size();
            for (int i75 = 0; i75 < size5; i75++) {
                MeasuredPage measuredPage6 = calculatePagesOffsets.get(i75);
                if (measuredPage6.getIndex() < ((MeasuredPage) arrayDeque3.first()).getIndex()) {
                    arrayList4.add(measuredPage6);
                }
            }
            arrayList = arrayList4;
        }
        List list3 = arrayList;
        if (createPagesAfterList.isEmpty()) {
            arrayList2 = CollectionsKt.emptyList();
        } else {
            ArrayList arrayList5 = new ArrayList(calculatePagesOffsets.size());
            int size6 = calculatePagesOffsets.size();
            for (int i76 = 0; i76 < size6; i76++) {
                MeasuredPage measuredPage7 = calculatePagesOffsets.get(i76);
                if (measuredPage7.getIndex() > ((MeasuredPage) arrayDeque3.last()).getIndex()) {
                    arrayList5.add(measuredPage7);
                }
            }
            arrayList2 = arrayList5;
        }
        List list4 = arrayList2;
        int i77 = i2 + i3 + i4;
        int i78 = i10;
        MeasuredPage calculateNewCurrentPage = calculateNewCurrentPage(i77, list2, i3, i4, i8, snapPosition, i);
        int position = snapPosition.position(i77, i8, i3, i4, calculateNewCurrentPage != null ? calculateNewCurrentPage.getIndex() : 0, i);
        if (calculateNewCurrentPage != null) {
            i17 = calculateNewCurrentPage.getOffset();
            i16 = i33;
        } else {
            i16 = i33;
            i17 = 0;
        }
        return new PagerMeasureResult(list2, i8, i5, i4, orientation, i31, i52, z, i34, measuredPage3, calculateNewCurrentPage, i16 == 0 ? 0.0f : RangesKt.coerceIn((position - i17) / i16, -0.5f, 0.5f), i14, i78 < i || i69 > i2, snapPosition, (MeasureResult) function3.invoke(Integer.valueOf(i72), Integer.valueOf(i73), new Function1() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit measurePager_BiYVr7A$lambda$20;
                measurePager_BiYVr7A$lambda$20 = PagerMeasureKt.measurePager_BiYVr7A$lambda$20(MutableState.this, calculatePagesOffsets, (Placeable.PlacementScope) obj);
                return measurePager_BiYVr7A$lambda$20;
            }
        }), i44, list3, list4, coroutineScope);
    }

    private static final MeasuredPage calculateNewCurrentPage(int i, List<MeasuredPage> list, int i2, int i3, int i4, SnapPosition snapPosition, int i5) {
        MeasuredPage measuredPage;
        if (list.isEmpty()) {
            measuredPage = null;
        } else {
            MeasuredPage measuredPage2 = list.get(0);
            MeasuredPage measuredPage3 = measuredPage2;
            float f = -Math.abs(SnapPositionKt.calculateDistanceToDesiredSnapPosition(i, i2, i3, i4, measuredPage3.getOffset(), measuredPage3.getIndex(), snapPosition, i5));
            int lastIndex = CollectionsKt.getLastIndex(list);
            int i6 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    MeasuredPage measuredPage4 = list.get(i6);
                    MeasuredPage measuredPage5 = measuredPage4;
                    float f2 = -Math.abs(SnapPositionKt.calculateDistanceToDesiredSnapPosition(i, i2, i3, i4, measuredPage5.getOffset(), measuredPage5.getIndex(), snapPosition, i5));
                    if (Float.compare(f, f2) < 0) {
                        measuredPage2 = measuredPage4;
                        f = f2;
                    }
                    if (i6 == lastIndex) {
                        break;
                    }
                    i6++;
                }
            }
            measuredPage = measuredPage2;
        }
        return measuredPage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measurePager_BiYVr7A$lambda$20$lambda$19(List list, Placeable.PlacementScope placementScope) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ((MeasuredPage) list.get(i)).place(placementScope);
        }
        return Unit.INSTANCE;
    }
}
