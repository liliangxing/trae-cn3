package androidx.compose.foundation.lazy;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.CacheWindowLogic;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsStateKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.foundation.lazy.layout.StickyItemsPlacement;
import androidx.compose.p002ui.Alignment;
import androidx.compose.p002ui.graphics.GraphicsContext;
import androidx.compose.p002ui.layout.MeasureResult;
import androidx.compose.p002ui.layout.Placeable;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyList.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class LazyListKt$rememberLazyListMeasurePolicy$1$1 implements LazyLayoutMeasurePolicy {
    final /* synthetic */ int $beyondBoundsItemCount;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ GraphicsContext $graphicsContext;
    final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
    final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ Function0<LazyListItemProvider> $itemProviderLambda;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ LazyListState $state;
    final /* synthetic */ StickyItemsPlacement $stickyItemsPlacement;
    final /* synthetic */ Alignment.Vertical $verticalAlignment;
    final /* synthetic */ Arrangement.Vertical $verticalArrangement;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public LazyListKt$rememberLazyListMeasurePolicy$1$1(LazyListState lazyListState, boolean z, PaddingValues paddingValues, boolean z2, Function0<? extends LazyListItemProvider> function0, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, int i, CoroutineScope coroutineScope, GraphicsContext graphicsContext, StickyItemsPlacement stickyItemsPlacement, Alignment.Horizontal horizontal2, Alignment.Vertical vertical2) {
        this.$state = lazyListState;
        this.$isVertical = z;
        this.$contentPadding = paddingValues;
        this.$reverseLayout = z2;
        this.$itemProviderLambda = function0;
        this.$verticalArrangement = vertical;
        this.$horizontalArrangement = horizontal;
        this.$beyondBoundsItemCount = i;
        this.$coroutineScope = coroutineScope;
        this.$graphicsContext = graphicsContext;
        this.$stickyItemsPlacement = stickyItemsPlacement;
        this.$horizontalAlignment = horizontal2;
        this.$verticalAlignment = vertical2;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy
    /* renamed from: measure-0kLqBqw, reason: not valid java name */
    public final MeasureResult mo1198measure0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j) {
        int i;
        int i2;
        int i3;
        float spacing;
        int i4;
        long j2;
        float scrollToBeConsumed;
        ObservableScopeInvalidator.m1324attachToScopeimpl(this.$state.m1216getMeasurementScopeInvalidatorzYiylxw$foundation_release());
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
        int i5 = lazyLayoutMeasureScope.roundToPx-0680j_4(this.$contentPadding.getTop());
        int i6 = lazyLayoutMeasureScope.roundToPx-0680j_4(this.$contentPadding.getBottom());
        final int i7 = i5 + i6;
        final int i8 = i + i2;
        boolean z2 = this.$isVertical;
        int i9 = z2 ? i7 : i8;
        if (z2 && !this.$reverseLayout) {
            i3 = i5;
        } else if (z2 && this.$reverseLayout) {
            i3 = i6;
        } else {
            i3 = (z2 || this.$reverseLayout) ? i2 : i;
        }
        final int i10 = i9 - i3;
        final long j3 = ConstraintsKt.offset-NN6Ew-U(j, -i8, -i7);
        final LazyListItemProvider lazyListItemProvider = (LazyListItemProvider) this.$itemProviderLambda.invoke();
        lazyListItemProvider.getItemScope().setMaxSize(Constraints.getMaxWidth-impl(j3), Constraints.getMaxHeight-impl(j3));
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
                InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null horizontalAlignment when isVertical == false");
                throw new KotlinNothingValueException();
            }
        }
        final int i11 = lazyLayoutMeasureScope.roundToPx-0680j_4(spacing);
        final int itemCount = lazyListItemProvider.getItemCount();
        if (this.$isVertical) {
            i4 = Constraints.getMaxHeight-impl(j) - i7;
        } else {
            i4 = Constraints.getMaxWidth-impl(j) - i8;
        }
        int i12 = i4;
        if (this.$reverseLayout && i12 <= 0) {
            boolean z3 = this.$isVertical;
            if (!z3) {
                i += i12;
            }
            if (z3) {
                i5 += i12;
            }
            j2 = IntOffset.constructor-impl((i << 32) | (i5 & 4294967295L));
        } else {
            j2 = IntOffset.constructor-impl((i << 32) | (i5 & 4294967295L));
        }
        final long j4 = j2;
        final boolean z4 = this.$isVertical;
        final Alignment.Horizontal horizontal2 = this.$horizontalAlignment;
        final Alignment.Vertical vertical2 = this.$verticalAlignment;
        final boolean z5 = this.$reverseLayout;
        final LazyListState lazyListState = this.$state;
        final int i13 = i3;
        LazyListMeasuredItemProvider lazyListMeasuredItemProvider = new LazyListMeasuredItemProvider(j3, z4, lazyListItemProvider, lazyLayoutMeasureScope, itemCount, i11, horizontal2, vertical2, z5, i13, i10, j4, lazyListState) { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1
            final /* synthetic */ int $afterContentPadding;
            final /* synthetic */ int $beforeContentPadding;
            final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
            final /* synthetic */ boolean $isVertical;
            final /* synthetic */ int $itemsCount;
            final /* synthetic */ boolean $reverseLayout;
            final /* synthetic */ int $spaceBetweenItems;
            final /* synthetic */ LazyListState $state;
            final /* synthetic */ LazyLayoutMeasureScope $this_LazyLayoutMeasurePolicy;
            final /* synthetic */ Alignment.Vertical $verticalAlignment;
            final /* synthetic */ long $visualItemOffset;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.$isVertical = z4;
                this.$this_LazyLayoutMeasurePolicy = lazyLayoutMeasureScope;
                this.$itemsCount = itemCount;
                this.$spaceBetweenItems = i11;
                this.$horizontalAlignment = horizontal2;
                this.$verticalAlignment = vertical2;
                this.$reverseLayout = z5;
                this.$beforeContentPadding = i13;
                this.$afterContentPadding = i10;
                this.$visualItemOffset = j4;
                this.$state = lazyListState;
            }

            @Override // androidx.compose.foundation.lazy.LazyListMeasuredItemProvider
            /* renamed from: createItem-X9ElhV4, reason: not valid java name */
            public LazyListMeasuredItem mo1199createItemX9ElhV4(int index, Object key, Object contentType, List<? extends Placeable> placeables, long constraints) {
                return new LazyListMeasuredItem(index, placeables, this.$isVertical, this.$horizontalAlignment, this.$verticalAlignment, this.$this_LazyLayoutMeasurePolicy.getLayoutDirection(), this.$reverseLayout, this.$beforeContentPadding, this.$afterContentPadding, index == this.$itemsCount + (-1) ? 0 : this.$spaceBetweenItems, this.$visualItemOffset, key, contentType, this.$state.getItemAnimator$foundation_release(), constraints, null);
            }
        };
        Snapshot.Companion companion = Snapshot.INSTANCE;
        LazyListState lazyListState2 = this.$state;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            int updateScrollPositionIfTheFirstItemWasMoved$foundation_release = lazyListState2.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(lazyListItemProvider, lazyListState2.getFirstVisibleItemIndex());
            int firstVisibleItemScrollOffset = lazyListState2.getFirstVisibleItemScrollOffset();
            Unit unit = Unit.INSTANCE;
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            List<Integer> calculateLazyLayoutPinnedIndices = LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(lazyListItemProvider, this.$state.getPinnedItems(), this.$state.getBeyondBoundsInfo());
            if (lazyLayoutMeasureScope.isLookingAhead() || !z) {
                scrollToBeConsumed = this.$state.getScrollToBeConsumed();
            } else {
                scrollToBeConsumed = this.$state.getScrollDeltaBetweenPasses$foundation_release();
            }
            LazyListMeasuredItemProvider lazyListMeasuredItemProvider2 = lazyListMeasuredItemProvider;
            LazyListMeasureResult m1203measureLazyListLCrQqZ4 = LazyListMeasureKt.m1203measureLazyListLCrQqZ4(itemCount, lazyListMeasuredItemProvider2, i12, i3, i10, i11, updateScrollPositionIfTheFirstItemWasMoved$foundation_release, firstVisibleItemScrollOffset, scrollToBeConsumed, j3, this.$isVertical, this.$verticalArrangement, this.$horizontalArrangement, this.$reverseLayout, lazyLayoutMeasureScope, this.$state.getItemAnimator$foundation_release(), this.$beyondBoundsItemCount, calculateLazyLayoutPinnedIndices, z, lazyLayoutMeasureScope.isLookingAhead(), this.$state.getApproachLayoutInfo(), this.$coroutineScope, this.$state.m1217getPlacementScopeInvalidatorzYiylxw$foundation_release(), this.$graphicsContext, this.$stickyItemsPlacement, new Function3() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    MeasureResult measure_0kLqBqw$lambda$3;
                    measure_0kLqBqw$lambda$3 = LazyListKt$rememberLazyListMeasurePolicy$1$1.measure_0kLqBqw$lambda$3(LazyLayoutMeasureScope.this, j, i8, i7, ((Integer) obj).intValue(), ((Integer) obj2).intValue(), (Function1) obj3);
                    return measure_0kLqBqw$lambda$3;
                }
            });
            LazyListState.applyMeasureResult$foundation_release$default(this.$state, m1203measureLazyListLCrQqZ4, lazyLayoutMeasureScope.isLookingAhead(), false, 4, null);
            Object prefetchStrategy = this.$state.getPrefetchStrategy();
            CacheWindowLogic cacheWindowLogic = prefetchStrategy instanceof CacheWindowLogic ? (CacheWindowLogic) prefetchStrategy : null;
            if (cacheWindowLogic != null) {
                LazyListKt.keepAroundItems(cacheWindowLogic, m1203measureLazyListLCrQqZ4.getVisibleItemsInfo(), lazyListMeasuredItemProvider2);
            }
            return m1203measureLazyListLCrQqZ4;
        } catch (Throwable th) {
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult measure_0kLqBqw$lambda$3(LazyLayoutMeasureScope lazyLayoutMeasureScope, long j, int i, int i2, int i3, int i4, Function1 function1) {
        return lazyLayoutMeasureScope.layout(ConstraintsKt.constrainWidth-K40F9xA(j, i3 + i), ConstraintsKt.constrainHeight-K40F9xA(j, i4 + i2), MapsKt.emptyMap(), function1);
    }
}
