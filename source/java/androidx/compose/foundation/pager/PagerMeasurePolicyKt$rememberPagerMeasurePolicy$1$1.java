package androidx.compose.foundation.pager;

import androidx.collection.IntObjectMapKt;
import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsStateKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.p002ui.Alignment;
import androidx.compose.p002ui.layout.MeasureResult;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: PagerMeasurePolicy.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
final class PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1 implements LazyLayoutMeasurePolicy {
    final /* synthetic */ int $beyondViewportPageCount;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
    final /* synthetic */ Function0<PagerLazyLayoutItemProvider> $itemProviderLambda;
    final /* synthetic */ Orientation $orientation;
    final /* synthetic */ Function0<Integer> $pageCount;
    final /* synthetic */ PageSize $pageSize;
    final /* synthetic */ float $pageSpacing;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ SnapPosition $snapPosition;
    final /* synthetic */ PagerState $state;
    final /* synthetic */ Alignment.Vertical $verticalAlignment;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1(PagerState pagerState, Orientation orientation, PaddingValues paddingValues, boolean z, float f, PageSize pageSize, Function0<PagerLazyLayoutItemProvider> function0, Function0<Integer> function02, Alignment.Vertical vertical, Alignment.Horizontal horizontal, int i, SnapPosition snapPosition, CoroutineScope coroutineScope) {
        this.$state = pagerState;
        this.$orientation = orientation;
        this.$contentPadding = paddingValues;
        this.$reverseLayout = z;
        this.$pageSpacing = f;
        this.$pageSize = pageSize;
        this.$itemProviderLambda = function0;
        this.$pageCount = function02;
        this.$verticalAlignment = vertical;
        this.$horizontalAlignment = horizontal;
        this.$beyondViewportPageCount = i;
        this.$snapPosition = snapPosition;
        this.$coroutineScope = coroutineScope;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy
    /* renamed from: measure-0kLqBqw */
    public final MeasureResult mo1198measure0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        long j2;
        Snapshot snapshot;
        ObservableScopeInvalidator.m1324attachToScopeimpl(this.$state.m1418getMeasurementScopeInvalidatorzYiylxw$foundation_release());
        boolean z = this.$orientation == Orientation.Vertical;
        CheckScrollableContainerConstraintsKt.m433checkScrollableContainerConstraintsK40F9xA(j, z ? Orientation.Vertical : Orientation.Horizontal);
        if (z) {
            i = lazyLayoutMeasureScope.roundToPx-0680j_4(this.$contentPadding.mo998calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
        } else {
            i = lazyLayoutMeasureScope.roundToPx-0680j_4(PaddingKt.calculateStartPadding(this.$contentPadding, lazyLayoutMeasureScope.getLayoutDirection()));
        }
        if (z) {
            i2 = lazyLayoutMeasureScope.roundToPx-0680j_4(this.$contentPadding.mo999calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
        } else {
            i2 = lazyLayoutMeasureScope.roundToPx-0680j_4(PaddingKt.calculateEndPadding(this.$contentPadding, lazyLayoutMeasureScope.getLayoutDirection()));
        }
        int i6 = lazyLayoutMeasureScope.roundToPx-0680j_4(this.$contentPadding.getTop());
        int i7 = lazyLayoutMeasureScope.roundToPx-0680j_4(this.$contentPadding.getBottom());
        final int i8 = i6 + i7;
        final int i9 = i + i2;
        int i10 = z ? i8 : i9;
        if (z && !this.$reverseLayout) {
            i3 = i6;
        } else if (z && this.$reverseLayout) {
            i3 = i7;
        } else {
            i3 = (z || this.$reverseLayout) ? i2 : i;
        }
        int i11 = i10 - i3;
        long j3 = ConstraintsKt.offset-NN6Ew-U(j, -i9, -i8);
        LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
        this.$state.setDensity$foundation_release(lazyLayoutMeasureScope2);
        int i12 = lazyLayoutMeasureScope.roundToPx-0680j_4(this.$pageSpacing);
        if (z) {
            i4 = Constraints.getMaxHeight-impl(j) - i8;
        } else {
            i4 = Constraints.getMaxWidth-impl(j) - i9;
        }
        if (!this.$reverseLayout || i4 > 0) {
            i5 = i4;
            j2 = IntOffset.constructor-impl((i << 32) | (i6 & 4294967295L));
        } else {
            if (!z) {
                i += i4;
            }
            if (z) {
                i6 += i4;
            }
            i5 = i4;
            j2 = IntOffset.constructor-impl((i << 32) | (i6 & 4294967295L));
        }
        long j4 = j2;
        int i13 = i5;
        int coerceAtLeast = RangesKt.coerceAtLeast(this.$pageSize.calculateMainAxisPageSize(lazyLayoutMeasureScope2, i13, i12), 0);
        this.$state.m1422setPremeasureConstraintsBRTryo0$foundation_release(ConstraintsKt.Constraints$default(0, this.$orientation == Orientation.Vertical ? Constraints.getMaxWidth-impl(j3) : coerceAtLeast, 0, this.$orientation != Orientation.Vertical ? Constraints.getMaxHeight-impl(j3) : coerceAtLeast, 5, (Object) null));
        PagerLazyLayoutItemProvider pagerLazyLayoutItemProvider = (PagerLazyLayoutItemProvider) this.$itemProviderLambda.invoke();
        int i14 = i13 + i3 + i11;
        Snapshot.Companion companion = Snapshot.INSTANCE;
        PagerState pagerState = this.$state;
        SnapPosition snapPosition = this.$snapPosition;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            int matchScrollPositionWithKey$foundation_release = pagerState.matchScrollPositionWithKey$foundation_release(pagerLazyLayoutItemProvider, pagerState.getCurrentPage());
            int currentPage = pagerState.getCurrentPage();
            float currentPageOffsetFraction = pagerState.getCurrentPageOffsetFraction();
            int pageCount = pagerState.getPageCount();
            snapshot = makeCurrentNonObservable;
            try {
                int currentPageOffset = PagerKt.currentPageOffset(snapPosition, i14, coerceAtLeast, i12, i3, i11, currentPage, currentPageOffsetFraction, pageCount);
                Unit unit = Unit.INSTANCE;
                companion.restoreNonObservable(currentThreadSnapshot, snapshot, readObserver);
                PagerMeasureResult m1413measurePagerBiYVr7A = PagerMeasureKt.m1413measurePagerBiYVr7A(lazyLayoutMeasureScope, ((Number) this.$pageCount.invoke()).intValue(), pagerLazyLayoutItemProvider, i13, i3, i11, i12, matchScrollPositionWithKey$foundation_release, currentPageOffset, j3, this.$orientation, this.$verticalAlignment, this.$horizontalAlignment, this.$reverseLayout, j4, coerceAtLeast, this.$beyondViewportPageCount, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(pagerLazyLayoutItemProvider, this.$state.getPinnedPages(), this.$state.getBeyondBoundsInfo()), this.$snapPosition, this.$state.m1419getPlacementScopeInvalidatorzYiylxw$foundation_release(), this.$coroutineScope, new Function3() { // from class: androidx.compose.foundation.pager.PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        MeasureResult measure_0kLqBqw$lambda$2;
                        measure_0kLqBqw$lambda$2 = PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1.measure_0kLqBqw$lambda$2(LazyLayoutMeasureScope.this, j, i9, i8, ((Integer) obj).intValue(), ((Integer) obj2).intValue(), (Function1) obj3);
                        return measure_0kLqBqw$lambda$2;
                    }
                }, IntObjectMapKt.mutableIntObjectMapOf());
                PagerState.applyMeasureResult$foundation_release$default(this.$state, m1413measurePagerBiYVr7A, lazyLayoutMeasureScope.isLookingAhead(), false, 4, null);
                return m1413measurePagerBiYVr7A;
            } catch (Throwable th) {
                th = th;
                companion.restoreNonObservable(currentThreadSnapshot, snapshot, readObserver);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            snapshot = makeCurrentNonObservable;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult measure_0kLqBqw$lambda$2(LazyLayoutMeasureScope lazyLayoutMeasureScope, long j, int i, int i2, int i3, int i4, Function1 function1) {
        return lazyLayoutMeasureScope.layout(ConstraintsKt.constrainWidth-K40F9xA(j, i3 + i), ConstraintsKt.constrainHeight-K40F9xA(j, i4 + i2), MapsKt.emptyMap(), function1);
    }
}
