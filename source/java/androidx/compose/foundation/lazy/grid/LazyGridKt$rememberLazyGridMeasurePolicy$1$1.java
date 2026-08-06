package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider;
import androidx.compose.foundation.lazy.layout.CacheWindowLogic;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsStateKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.foundation.lazy.layout.StickyItemsPlacement;
import androidx.compose.p002ui.graphics.GraphicsContext;
import androidx.compose.p002ui.layout.MeasureResult;
import androidx.compose.p002ui.layout.Placeable;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyGrid.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class LazyGridKt$rememberLazyGridMeasurePolicy$1$1 implements LazyLayoutMeasurePolicy {
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ GraphicsContext $graphicsContext;
    final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ Function0<LazyGridItemProvider> $itemProviderLambda;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ LazyGridSlotsProvider $slots;
    final /* synthetic */ LazyGridState $state;
    final /* synthetic */ StickyItemsPlacement $stickyItemsScrollBehavior;
    final /* synthetic */ Arrangement.Vertical $verticalArrangement;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public LazyGridKt$rememberLazyGridMeasurePolicy$1$1(LazyGridState lazyGridState, boolean z, PaddingValues paddingValues, boolean z2, Function0<? extends LazyGridItemProvider> function0, LazyGridSlotsProvider lazyGridSlotsProvider, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, CoroutineScope coroutineScope, GraphicsContext graphicsContext, StickyItemsPlacement stickyItemsPlacement) {
        this.$state = lazyGridState;
        this.$isVertical = z;
        this.$contentPadding = paddingValues;
        this.$reverseLayout = z2;
        this.$itemProviderLambda = function0;
        this.$slots = lazyGridSlotsProvider;
        this.$verticalArrangement = vertical;
        this.$horizontalArrangement = horizontal;
        this.$coroutineScope = coroutineScope;
        this.$graphicsContext = graphicsContext;
        this.$stickyItemsScrollBehavior = stickyItemsPlacement;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x027f  */
    /* JADX WARN: Type inference failed for: r29v0, types: [androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1] */
    /* JADX WARN: Type inference failed for: r2v19, types: [androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1] */
    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy
    /* renamed from: measure-0kLqBqw */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final MeasureResult mo1198measure0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j) {
        int i;
        int i2;
        int i3;
        float spacing;
        int i4;
        int i5;
        int i6;
        long j2;
        int lineIndexOfItem;
        int firstVisibleItemScrollOffset;
        float scrollToBeConsumed;
        CacheWindowLogic cacheWindowLogic;
        ObservableScopeInvalidator.m1324attachToScopeimpl(this.$state.m1259getMeasurementScopeInvalidatorzYiylxw$foundation_release());
        boolean z = this.$state.getHasLookaheadOccurred() || lazyLayoutMeasureScope.isLookingAhead();
        CheckScrollableContainerConstraintsKt.m433checkScrollableContainerConstraintsK40F9xA(j, this.$isVertical ? Orientation.Vertical : Orientation.Horizontal);
        if (this.$isVertical) {
            i = lazyLayoutMeasureScope.roundToPx-0680j_4(this.$contentPadding.mo998calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
        } else {
            i = lazyLayoutMeasureScope.roundToPx-0680j_4(PaddingKt.calculateStartPadding(this.$contentPadding, lazyLayoutMeasureScope.getLayoutDirection()));
        }
        if (this.$isVertical) {
            i2 = lazyLayoutMeasureScope.roundToPx-0680j_4(this.$contentPadding.mo999calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
        } else {
            i2 = lazyLayoutMeasureScope.roundToPx-0680j_4(PaddingKt.calculateEndPadding(this.$contentPadding, lazyLayoutMeasureScope.getLayoutDirection()));
        }
        int i7 = lazyLayoutMeasureScope.roundToPx-0680j_4(this.$contentPadding.getTop());
        int i8 = lazyLayoutMeasureScope.roundToPx-0680j_4(this.$contentPadding.getBottom());
        final int i9 = i7 + i8;
        final int i10 = i + i2;
        boolean z2 = this.$isVertical;
        int i11 = z2 ? i9 : i10;
        if (z2 && !this.$reverseLayout) {
            i3 = i7;
        } else if (z2 && this.$reverseLayout) {
            i3 = i8;
        } else {
            i3 = (z2 || this.$reverseLayout) ? i2 : i;
        }
        final int i12 = i11 - i3;
        long j3 = ConstraintsKt.offset-NN6Ew-U(j, -i10, -i9);
        final LazyGridItemProvider lazyGridItemProvider = (LazyGridItemProvider) this.$itemProviderLambda.invoke();
        final LazyGridSpanLayoutProvider spanLayoutProvider = lazyGridItemProvider.getSpanLayoutProvider();
        LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
        final LazyGridSlots mo1232invoke0kLqBqw = this.$slots.mo1232invoke0kLqBqw(lazyLayoutMeasureScope2, j3);
        int length = mo1232invoke0kLqBqw.getSizes().length;
        spanLayoutProvider.setSlotsPerLine(length);
        if (this.$isVertical) {
            Arrangement.Vertical vertical = this.$verticalArrangement;
            if (vertical != null) {
                spacing = vertical.getSpacing();
            } else {
                InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null verticalArrangement when isVertical == true");
                throw new KotlinNothingValueException();
            }
        } else {
            Arrangement.Horizontal horizontal = this.$horizontalArrangement;
            if (horizontal != null) {
                spacing = horizontal.getSpacing();
            } else {
                InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null horizontalArrangement when isVertical == false");
                throw new KotlinNothingValueException();
            }
        }
        final int i13 = lazyLayoutMeasureScope.roundToPx-0680j_4(spacing);
        int itemCount = lazyGridItemProvider.getItemCount();
        if (this.$isVertical) {
            i4 = Constraints.getMaxHeight-impl(j) - i9;
        } else {
            i4 = Constraints.getMaxWidth-impl(j) - i10;
        }
        int i14 = i4;
        if (this.$reverseLayout && i14 <= 0) {
            boolean z3 = this.$isVertical;
            if (!z3) {
                i += i14;
            }
            if (z3) {
                i7 += i14;
            }
            i5 = itemCount;
            i6 = length;
            j2 = IntOffset.constructor-impl((i << 32) | (i7 & 4294967295L));
        } else {
            i5 = itemCount;
            i6 = length;
            j2 = IntOffset.constructor-impl((i << 32) | (i7 & 4294967295L));
        }
        final long j4 = j2;
        final LazyGridState lazyGridState = this.$state;
        final boolean z4 = this.$isVertical;
        final boolean z5 = this.$reverseLayout;
        int i15 = i6;
        final int i16 = i3;
        final ?? r29 = new LazyGridMeasuredItemProvider(lazyGridItemProvider, lazyLayoutMeasureScope, i13, lazyGridState, z4, z5, i16, i12, j4) { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1
            final /* synthetic */ int $afterContentPadding;
            final /* synthetic */ int $beforeContentPadding;
            final /* synthetic */ boolean $isVertical;
            final /* synthetic */ boolean $reverseLayout;
            final /* synthetic */ LazyGridState $state;
            final /* synthetic */ LazyLayoutMeasureScope $this_LazyLayoutMeasurePolicy;
            final /* synthetic */ long $visualItemOffset;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.$this_LazyLayoutMeasurePolicy = lazyLayoutMeasureScope;
                this.$state = lazyGridState;
                this.$isVertical = z4;
                this.$reverseLayout = z5;
                this.$beforeContentPadding = i16;
                this.$afterContentPadding = i12;
                this.$visualItemOffset = j4;
            }

            @Override // androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider
            /* renamed from: createItem-O3s9Psw, reason: not valid java name */
            public LazyGridMeasuredItem mo1250createItemO3s9Psw(int index, Object key, Object contentType, int crossAxisSize, int mainAxisSpacing, List<? extends Placeable> placeables, long constraints, int lane, int span) {
                return new LazyGridMeasuredItem(index, key, this.$isVertical, crossAxisSize, mainAxisSpacing, this.$reverseLayout, this.$this_LazyLayoutMeasurePolicy.getLayoutDirection(), this.$beforeContentPadding, this.$afterContentPadding, placeables, this.$visualItemOffset, contentType, this.$state.getItemAnimator$foundation_release(), constraints, lane, span, null);
            }
        };
        final boolean z6 = this.$isVertical;
        final int i17 = i5;
        final ?? r2 = new LazyGridMeasuredLineProvider(z6, mo1232invoke0kLqBqw, i17, i13, r29, spanLayoutProvider) { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1
            final /* synthetic */ boolean $isVertical;
            final /* synthetic */ LazyGridSlots $resolvedSlots;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(z6, mo1232invoke0kLqBqw, i17, i13, r29, spanLayoutProvider);
                this.$isVertical = z6;
                this.$resolvedSlots = mo1232invoke0kLqBqw;
            }

            @Override // androidx.compose.foundation.lazy.grid.LazyGridMeasuredLineProvider
            public LazyGridMeasuredLine createLine(int index, LazyGridMeasuredItem[] items, List<GridItemSpan> spans, int mainAxisSpacing) {
                return new LazyGridMeasuredLine(index, items, this.$resolvedSlots, spans, this.$isVertical, mainAxisSpacing);
            }
        };
        Function1 function1 = new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                ArrayList measure_0kLqBqw$lambda$3;
                measure_0kLqBqw$lambda$3 = LazyGridKt$rememberLazyGridMeasurePolicy$1$1.measure_0kLqBqw$lambda$3(LazyGridSpanLayoutProvider.this, r2, ((Integer) obj).intValue());
                return measure_0kLqBqw$lambda$3;
            }
        };
        Function1 function12 = new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                int lineIndexOfItem2;
                lineIndexOfItem2 = LazyGridSpanLayoutProvider.this.getLineIndexOfItem(((Integer) obj).intValue());
                return Integer.valueOf(lineIndexOfItem2);
            }
        };
        Snapshot.Companion companion = Snapshot.INSTANCE;
        LazyGridState lazyGridState2 = this.$state;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            int updateScrollPositionIfTheFirstItemWasMoved$foundation_release = lazyGridState2.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(lazyGridItemProvider, lazyGridState2.getFirstVisibleItemIndex());
            if (updateScrollPositionIfTheFirstItemWasMoved$foundation_release >= i5 && i5 > 0) {
                lineIndexOfItem = spanLayoutProvider.getLineIndexOfItem(i5 - 1);
                firstVisibleItemScrollOffset = 0;
                Unit unit = Unit.INSTANCE;
                companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                List<Integer> calculateLazyLayoutPinnedIndices = LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(lazyGridItemProvider, this.$state.getPinnedItems(), this.$state.getBeyondBoundsInfo());
                if (!lazyLayoutMeasureScope.isLookingAhead() || !z) {
                    scrollToBeConsumed = this.$state.getScrollToBeConsumed();
                } else {
                    scrollToBeConsumed = this.$state.getScrollDeltaBetweenPasses$foundation_release();
                }
                LazyGridMeasuredLineProvider lazyGridMeasuredLineProvider = (LazyGridMeasuredLineProvider) r2;
                LazyGridMeasureResult m1253measureLazyGridt1x4au0 = LazyGridMeasureKt.m1253measureLazyGridt1x4au0(i5, lazyGridMeasuredLineProvider, (LazyGridMeasuredItemProvider) r29, i14, i3, i12, i13, lineIndexOfItem, firstVisibleItemScrollOffset, scrollToBeConsumed, j3, this.$isVertical, this.$verticalArrangement, this.$horizontalArrangement, this.$reverseLayout, lazyLayoutMeasureScope2, this.$state.getItemAnimator$foundation_release(), i15, calculateLazyLayoutPinnedIndices, z, lazyLayoutMeasureScope.isLookingAhead(), this.$state.getApproachLayoutInfo(), this.$coroutineScope, this.$state.m1260getPlacementScopeInvalidatorzYiylxw$foundation_release(), this.$graphicsContext, function1, function12, this.$stickyItemsScrollBehavior, new Function3() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        MeasureResult measure_0kLqBqw$lambda$6;
                        measure_0kLqBqw$lambda$6 = LazyGridKt$rememberLazyGridMeasurePolicy$1$1.measure_0kLqBqw$lambda$6(LazyLayoutMeasureScope.this, j, i10, i9, ((Integer) obj).intValue(), ((Integer) obj2).intValue(), (Function1) obj3);
                        return measure_0kLqBqw$lambda$6;
                    }
                });
                LazyGridState.applyMeasureResult$foundation_release$default(this.$state, m1253measureLazyGridt1x4au0, lazyLayoutMeasureScope.isLookingAhead(), false, 4, null);
                Object prefetchStrategy = this.$state.getPrefetchStrategy();
                cacheWindowLogic = prefetchStrategy instanceof CacheWindowLogic ? (CacheWindowLogic) prefetchStrategy : null;
                if (cacheWindowLogic != null) {
                    LazyGridKt.keepAroundItems(cacheWindowLogic, m1253measureLazyGridt1x4au0.getOrientation(), m1253measureLazyGridt1x4au0.getVisibleItemsInfo(), lazyGridMeasuredLineProvider);
                }
                return m1253measureLazyGridt1x4au0;
            }
            lineIndexOfItem = spanLayoutProvider.getLineIndexOfItem(updateScrollPositionIfTheFirstItemWasMoved$foundation_release);
            firstVisibleItemScrollOffset = lazyGridState2.getFirstVisibleItemScrollOffset();
            Unit unit2 = Unit.INSTANCE;
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            List<Integer> calculateLazyLayoutPinnedIndices2 = LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(lazyGridItemProvider, this.$state.getPinnedItems(), this.$state.getBeyondBoundsInfo());
            if (!lazyLayoutMeasureScope.isLookingAhead()) {
            }
            scrollToBeConsumed = this.$state.getScrollToBeConsumed();
            LazyGridMeasuredLineProvider lazyGridMeasuredLineProvider2 = (LazyGridMeasuredLineProvider) r2;
            LazyGridMeasureResult m1253measureLazyGridt1x4au02 = LazyGridMeasureKt.m1253measureLazyGridt1x4au0(i5, lazyGridMeasuredLineProvider2, (LazyGridMeasuredItemProvider) r29, i14, i3, i12, i13, lineIndexOfItem, firstVisibleItemScrollOffset, scrollToBeConsumed, j3, this.$isVertical, this.$verticalArrangement, this.$horizontalArrangement, this.$reverseLayout, lazyLayoutMeasureScope2, this.$state.getItemAnimator$foundation_release(), i15, calculateLazyLayoutPinnedIndices2, z, lazyLayoutMeasureScope.isLookingAhead(), this.$state.getApproachLayoutInfo(), this.$coroutineScope, this.$state.m1260getPlacementScopeInvalidatorzYiylxw$foundation_release(), this.$graphicsContext, function1, function12, this.$stickyItemsScrollBehavior, new Function3() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    MeasureResult measure_0kLqBqw$lambda$6;
                    measure_0kLqBqw$lambda$6 = LazyGridKt$rememberLazyGridMeasurePolicy$1$1.measure_0kLqBqw$lambda$6(LazyLayoutMeasureScope.this, j, i10, i9, ((Integer) obj).intValue(), ((Integer) obj2).intValue(), (Function1) obj3);
                    return measure_0kLqBqw$lambda$6;
                }
            });
            LazyGridState.applyMeasureResult$foundation_release$default(this.$state, m1253measureLazyGridt1x4au02, lazyLayoutMeasureScope.isLookingAhead(), false, 4, null);
            Object prefetchStrategy2 = this.$state.getPrefetchStrategy();
            if (prefetchStrategy2 instanceof CacheWindowLogic) {
            }
            if (cacheWindowLogic != null) {
            }
            return m1253measureLazyGridt1x4au02;
        } catch (Throwable th) {
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArrayList measure_0kLqBqw$lambda$3(LazyGridSpanLayoutProvider lazyGridSpanLayoutProvider, C0340xaa796ba c0340xaa796ba, int i) {
        LazyGridSpanLayoutProvider.LineConfiguration lineConfiguration = lazyGridSpanLayoutProvider.getLineConfiguration(i);
        int firstItemIndex = lineConfiguration.getFirstItemIndex();
        ArrayList arrayList = new ArrayList(lineConfiguration.getSpans().size());
        List<GridItemSpan> spans = lineConfiguration.getSpans();
        int size = spans.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            int m1228getCurrentLineSpanimpl = GridItemSpan.m1228getCurrentLineSpanimpl(spans.get(i3).getPackedValue());
            arrayList.add(TuplesKt.to(Integer.valueOf(firstItemIndex), Constraints.box-impl(c0340xaa796ba.m1257childConstraintsJhjzzOo$foundation_release(i2, m1228getCurrentLineSpanimpl))));
            firstItemIndex++;
            i2 += m1228getCurrentLineSpanimpl;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult measure_0kLqBqw$lambda$6(LazyLayoutMeasureScope lazyLayoutMeasureScope, long j, int i, int i2, int i3, int i4, Function1 function1) {
        return lazyLayoutMeasureScope.layout(ConstraintsKt.constrainWidth-K40F9xA(j, i3 + i), ConstraintsKt.constrainHeight-K40F9xA(j, i4 + i2), MapsKt.emptyMap(), function1);
    }
}
