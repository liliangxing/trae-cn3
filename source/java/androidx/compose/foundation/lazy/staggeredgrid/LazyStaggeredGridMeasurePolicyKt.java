package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsStateKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.p002ui.graphics.GraphicsContext;
import androidx.compose.p002ui.layout.MeasureResult;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: LazyStaggeredGridMeasurePolicy.kt */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001ae\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0001¢\u0006\u0004\b\u0016\u0010\u0017\u001a!\u0010\u0018\u001a\u00020\u000e*\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002¢\u0006\u0002\u0010\u001b\u001a)\u0010\u001c\u001a\u00020\u000e*\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002¢\u0006\u0002\u0010\u001d\u001a)\u0010\u001e\u001a\u00020\u000e*\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002¢\u0006\u0002\u0010\u001d¨\u0006\u001f"}, d2 = {"rememberStaggeredGridMeasurePolicy", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasurePolicy;", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisSpacing", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "slots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "rememberStaggeredGridMeasurePolicy-qKj4JfE", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/Orientation;FFLkotlinx/coroutines/CoroutineScope;Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;Landroidx/compose/ui/graphics/GraphicsContext;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasurePolicy;", "startPadding", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/unit/LayoutDirection;)F", "beforePadding", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/ui/unit/LayoutDirection;)F", "afterPadding", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class LazyStaggeredGridMeasurePolicyKt {

    /* compiled from: LazyStaggeredGridMeasurePolicy.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Orientation.values().length];
            try {
                iArr[Orientation.Vertical.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Orientation.Horizontal.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x002f, code lost:
    
        if (r26.changed(r16) != false) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012d  */
    /* renamed from: rememberStaggeredGridMeasurePolicy-qKj4JfE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final LazyLayoutMeasurePolicy m1373rememberStaggeredGridMeasurePolicyqKj4JfE(final LazyStaggeredGridState lazyStaggeredGridState, final Function0<? extends LazyStaggeredGridItemProvider> function0, final PaddingValues paddingValues, final boolean z, final Orientation orientation, final float f, float f2, final CoroutineScope coroutineScope, final LazyGridStaggeredGridSlotsProvider lazyGridStaggeredGridSlotsProvider, final GraphicsContext graphicsContext, Composer composer, int i) {
        boolean z2;
        boolean changed;
        LazyLayoutMeasurePolicy rememberedValue;
        ComposerKt.sourceInformationMarkerStart(composer, 234882793, "C(rememberStaggeredGridMeasurePolicy)N(state,itemProviderLambda,contentPadding,reverseLayout,orientation,mainAxisSpacing:c#ui.unit.Dp,crossAxisSpacing:c#ui.unit.Dp,coroutineScope,slots,graphicsContext)50@2088L3728:LazyStaggeredGridMeasurePolicy.kt#fzvcnm");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(234882793, i, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberStaggeredGridMeasurePolicy (LazyStaggeredGridMeasurePolicy.kt:50)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1910883015, "CC(remember):LazyStaggeredGridMeasurePolicy.kt#9igjgp");
        if (((i & 14) ^ 6) <= 4) {
        }
        if ((i & 6) != 4) {
            z2 = false;
            changed = z2 | ((((i & 112) ^ 48) <= 32 && composer.changed(function0)) || (i & 48) == 32) | ((((i & 896) ^ 384) <= 256 && composer.changed(paddingValues)) || (i & 384) == 256) | ((((i & 7168) ^ 3072) <= 2048 && composer.changed(z)) || (i & 3072) == 2048) | ((((57344 & i) ^ 24576) <= 16384 && composer.changed(orientation.ordinal())) || (i & 24576) == 16384) | ((((458752 & i) ^ 196608) <= 131072 && composer.changed(f)) || (i & 196608) == 131072) | ((((3670016 & i) ^ 1572864) <= 1048576 && composer.changed(f2)) || (i & 1572864) == 1048576) | ((((234881024 & i) ^ 100663296) > 67108864 && composer.changed(lazyGridStaggeredGridSlotsProvider)) || (i & 100663296) == 67108864) | composer.changed(graphicsContext);
            rememberedValue = composer.rememberedValue();
            if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new LazyLayoutMeasurePolicy() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasurePolicyKt$rememberStaggeredGridMeasurePolicy$1$1
                    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy
                    /* renamed from: measure-0kLqBqw */
                    public final MeasureResult mo1198measure0kLqBqw(LazyLayoutMeasureScope lazyLayoutMeasureScope, long j) {
                        float beforePadding;
                        float afterPadding;
                        float startPadding;
                        long j2;
                        ObservableScopeInvalidator.m1324attachToScopeimpl(LazyStaggeredGridState.this.m1380getMeasurementScopeInvalidatorzYiylxw$foundation_release());
                        boolean z3 = LazyStaggeredGridState.this.getHasLookaheadOccurred() || lazyLayoutMeasureScope.isLookingAhead();
                        CheckScrollableContainerConstraintsKt.m433checkScrollableContainerConstraintsK40F9xA(j, orientation);
                        LazyStaggeredGridSlots mo1347invoke0kLqBqw = lazyGridStaggeredGridSlotsProvider.mo1347invoke0kLqBqw(lazyLayoutMeasureScope, j);
                        boolean z4 = orientation == Orientation.Vertical;
                        LazyStaggeredGridItemProvider lazyStaggeredGridItemProvider = (LazyStaggeredGridItemProvider) function0.invoke();
                        beforePadding = LazyStaggeredGridMeasurePolicyKt.beforePadding(paddingValues, orientation, z, lazyLayoutMeasureScope.getLayoutDirection());
                        int i2 = lazyLayoutMeasureScope.roundToPx-0680j_4(beforePadding);
                        afterPadding = LazyStaggeredGridMeasurePolicyKt.afterPadding(paddingValues, orientation, z, lazyLayoutMeasureScope.getLayoutDirection());
                        int i3 = lazyLayoutMeasureScope.roundToPx-0680j_4(afterPadding);
                        startPadding = LazyStaggeredGridMeasurePolicyKt.startPadding(paddingValues, orientation, lazyLayoutMeasureScope.getLayoutDirection());
                        int i4 = lazyLayoutMeasureScope.roundToPx-0680j_4(startPadding);
                        int i5 = ((z4 ? Constraints.getMaxHeight-impl(j) : Constraints.getMaxWidth-impl(j)) - i2) - i3;
                        if (z4) {
                            j2 = IntOffset.constructor-impl((i2 & 4294967295L) | (i4 << 32));
                        } else {
                            j2 = IntOffset.constructor-impl((i4 & 4294967295L) | (i2 << 32));
                        }
                        long j3 = j2;
                        PaddingValues paddingValues2 = paddingValues;
                        int i6 = lazyLayoutMeasureScope.roundToPx-0680j_4(Dp.constructor-impl(PaddingKt.calculateStartPadding(paddingValues2, lazyLayoutMeasureScope.getLayoutDirection()) + PaddingKt.calculateEndPadding(paddingValues2, lazyLayoutMeasureScope.getLayoutDirection())));
                        PaddingValues paddingValues3 = paddingValues;
                        LazyStaggeredGridMeasureResult m1372measureStaggeredGridC6celF4 = LazyStaggeredGridMeasureKt.m1372measureStaggeredGridC6celF4(lazyLayoutMeasureScope, LazyStaggeredGridState.this, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(lazyStaggeredGridItemProvider, LazyStaggeredGridState.this.getPinnedItems(), LazyStaggeredGridState.this.getBeyondBoundsInfo()), lazyStaggeredGridItemProvider, mo1347invoke0kLqBqw, Constraints.copy-Zbe2FdA$default(j, ConstraintsKt.constrainWidth-K40F9xA(j, i6), 0, ConstraintsKt.constrainHeight-K40F9xA(j, lazyLayoutMeasureScope.roundToPx-0680j_4(Dp.constructor-impl(paddingValues3.getTop() + paddingValues3.getBottom()))), 0, 10, (Object) null), z4, z, j3, i5, lazyLayoutMeasureScope.roundToPx-0680j_4(f), i2, i3, coroutineScope, z3, lazyLayoutMeasureScope.isLookingAhead(), LazyStaggeredGridState.this.getApproachLayoutInfo(), graphicsContext);
                        LazyStaggeredGridState.applyMeasureResult$foundation_release$default(LazyStaggeredGridState.this, m1372measureStaggeredGridC6celF4, lazyLayoutMeasureScope.isLookingAhead(), false, 4, null);
                        return m1372measureStaggeredGridC6celF4;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            LazyLayoutMeasurePolicy lazyLayoutMeasurePolicy = (LazyLayoutMeasurePolicy) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            return lazyLayoutMeasurePolicy;
        }
        z2 = true;
        if (((234881024 & i) ^ 100663296) > 67108864) {
            changed = z2 | ((((i & 112) ^ 48) <= 32 && composer.changed(function0)) || (i & 48) == 32) | ((((i & 896) ^ 384) <= 256 && composer.changed(paddingValues)) || (i & 384) == 256) | ((((i & 7168) ^ 3072) <= 2048 && composer.changed(z)) || (i & 3072) == 2048) | ((((57344 & i) ^ 24576) <= 16384 && composer.changed(orientation.ordinal())) || (i & 24576) == 16384) | ((((458752 & i) ^ 196608) <= 131072 && composer.changed(f)) || (i & 196608) == 131072) | ((((3670016 & i) ^ 1572864) <= 1048576 && composer.changed(f2)) || (i & 1572864) == 1048576) | ((((234881024 & i) ^ 100663296) > 67108864 && composer.changed(lazyGridStaggeredGridSlotsProvider)) || (i & 100663296) == 67108864) | composer.changed(graphicsContext);
            rememberedValue = composer.rememberedValue();
            if (!changed) {
            }
            rememberedValue = new LazyLayoutMeasurePolicy() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasurePolicyKt$rememberStaggeredGridMeasurePolicy$1$1
                @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy
                /* renamed from: measure-0kLqBqw */
                public final MeasureResult mo1198measure0kLqBqw(LazyLayoutMeasureScope lazyLayoutMeasureScope, long j) {
                    float beforePadding;
                    float afterPadding;
                    float startPadding;
                    long j2;
                    ObservableScopeInvalidator.m1324attachToScopeimpl(LazyStaggeredGridState.this.m1380getMeasurementScopeInvalidatorzYiylxw$foundation_release());
                    boolean z3 = LazyStaggeredGridState.this.getHasLookaheadOccurred() || lazyLayoutMeasureScope.isLookingAhead();
                    CheckScrollableContainerConstraintsKt.m433checkScrollableContainerConstraintsK40F9xA(j, orientation);
                    LazyStaggeredGridSlots mo1347invoke0kLqBqw = lazyGridStaggeredGridSlotsProvider.mo1347invoke0kLqBqw(lazyLayoutMeasureScope, j);
                    boolean z4 = orientation == Orientation.Vertical;
                    LazyStaggeredGridItemProvider lazyStaggeredGridItemProvider = (LazyStaggeredGridItemProvider) function0.invoke();
                    beforePadding = LazyStaggeredGridMeasurePolicyKt.beforePadding(paddingValues, orientation, z, lazyLayoutMeasureScope.getLayoutDirection());
                    int i2 = lazyLayoutMeasureScope.roundToPx-0680j_4(beforePadding);
                    afterPadding = LazyStaggeredGridMeasurePolicyKt.afterPadding(paddingValues, orientation, z, lazyLayoutMeasureScope.getLayoutDirection());
                    int i3 = lazyLayoutMeasureScope.roundToPx-0680j_4(afterPadding);
                    startPadding = LazyStaggeredGridMeasurePolicyKt.startPadding(paddingValues, orientation, lazyLayoutMeasureScope.getLayoutDirection());
                    int i4 = lazyLayoutMeasureScope.roundToPx-0680j_4(startPadding);
                    int i5 = ((z4 ? Constraints.getMaxHeight-impl(j) : Constraints.getMaxWidth-impl(j)) - i2) - i3;
                    if (z4) {
                        j2 = IntOffset.constructor-impl((i2 & 4294967295L) | (i4 << 32));
                    } else {
                        j2 = IntOffset.constructor-impl((i4 & 4294967295L) | (i2 << 32));
                    }
                    long j3 = j2;
                    PaddingValues paddingValues2 = paddingValues;
                    int i6 = lazyLayoutMeasureScope.roundToPx-0680j_4(Dp.constructor-impl(PaddingKt.calculateStartPadding(paddingValues2, lazyLayoutMeasureScope.getLayoutDirection()) + PaddingKt.calculateEndPadding(paddingValues2, lazyLayoutMeasureScope.getLayoutDirection())));
                    PaddingValues paddingValues3 = paddingValues;
                    LazyStaggeredGridMeasureResult m1372measureStaggeredGridC6celF4 = LazyStaggeredGridMeasureKt.m1372measureStaggeredGridC6celF4(lazyLayoutMeasureScope, LazyStaggeredGridState.this, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(lazyStaggeredGridItemProvider, LazyStaggeredGridState.this.getPinnedItems(), LazyStaggeredGridState.this.getBeyondBoundsInfo()), lazyStaggeredGridItemProvider, mo1347invoke0kLqBqw, Constraints.copy-Zbe2FdA$default(j, ConstraintsKt.constrainWidth-K40F9xA(j, i6), 0, ConstraintsKt.constrainHeight-K40F9xA(j, lazyLayoutMeasureScope.roundToPx-0680j_4(Dp.constructor-impl(paddingValues3.getTop() + paddingValues3.getBottom()))), 0, 10, (Object) null), z4, z, j3, i5, lazyLayoutMeasureScope.roundToPx-0680j_4(f), i2, i3, coroutineScope, z3, lazyLayoutMeasureScope.isLookingAhead(), LazyStaggeredGridState.this.getApproachLayoutInfo(), graphicsContext);
                    LazyStaggeredGridState.applyMeasureResult$foundation_release$default(LazyStaggeredGridState.this, m1372measureStaggeredGridC6celF4, lazyLayoutMeasureScope.isLookingAhead(), false, 4, null);
                    return m1372measureStaggeredGridC6celF4;
                }
            };
            composer.updateRememberedValue(rememberedValue);
            LazyLayoutMeasurePolicy lazyLayoutMeasurePolicy2 = (LazyLayoutMeasurePolicy) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            return lazyLayoutMeasurePolicy2;
        }
        changed = z2 | ((((i & 112) ^ 48) <= 32 && composer.changed(function0)) || (i & 48) == 32) | ((((i & 896) ^ 384) <= 256 && composer.changed(paddingValues)) || (i & 384) == 256) | ((((i & 7168) ^ 3072) <= 2048 && composer.changed(z)) || (i & 3072) == 2048) | ((((57344 & i) ^ 24576) <= 16384 && composer.changed(orientation.ordinal())) || (i & 24576) == 16384) | ((((458752 & i) ^ 196608) <= 131072 && composer.changed(f)) || (i & 196608) == 131072) | ((((3670016 & i) ^ 1572864) <= 1048576 && composer.changed(f2)) || (i & 1572864) == 1048576) | ((((234881024 & i) ^ 100663296) > 67108864 && composer.changed(lazyGridStaggeredGridSlotsProvider)) || (i & 100663296) == 67108864) | composer.changed(graphicsContext);
        rememberedValue = composer.rememberedValue();
        if (!changed) {
        }
        rememberedValue = new LazyLayoutMeasurePolicy() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasurePolicyKt$rememberStaggeredGridMeasurePolicy$1$1
            @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy
            /* renamed from: measure-0kLqBqw */
            public final MeasureResult mo1198measure0kLqBqw(LazyLayoutMeasureScope lazyLayoutMeasureScope, long j) {
                float beforePadding;
                float afterPadding;
                float startPadding;
                long j2;
                ObservableScopeInvalidator.m1324attachToScopeimpl(LazyStaggeredGridState.this.m1380getMeasurementScopeInvalidatorzYiylxw$foundation_release());
                boolean z3 = LazyStaggeredGridState.this.getHasLookaheadOccurred() || lazyLayoutMeasureScope.isLookingAhead();
                CheckScrollableContainerConstraintsKt.m433checkScrollableContainerConstraintsK40F9xA(j, orientation);
                LazyStaggeredGridSlots mo1347invoke0kLqBqw = lazyGridStaggeredGridSlotsProvider.mo1347invoke0kLqBqw(lazyLayoutMeasureScope, j);
                boolean z4 = orientation == Orientation.Vertical;
                LazyStaggeredGridItemProvider lazyStaggeredGridItemProvider = (LazyStaggeredGridItemProvider) function0.invoke();
                beforePadding = LazyStaggeredGridMeasurePolicyKt.beforePadding(paddingValues, orientation, z, lazyLayoutMeasureScope.getLayoutDirection());
                int i2 = lazyLayoutMeasureScope.roundToPx-0680j_4(beforePadding);
                afterPadding = LazyStaggeredGridMeasurePolicyKt.afterPadding(paddingValues, orientation, z, lazyLayoutMeasureScope.getLayoutDirection());
                int i3 = lazyLayoutMeasureScope.roundToPx-0680j_4(afterPadding);
                startPadding = LazyStaggeredGridMeasurePolicyKt.startPadding(paddingValues, orientation, lazyLayoutMeasureScope.getLayoutDirection());
                int i4 = lazyLayoutMeasureScope.roundToPx-0680j_4(startPadding);
                int i5 = ((z4 ? Constraints.getMaxHeight-impl(j) : Constraints.getMaxWidth-impl(j)) - i2) - i3;
                if (z4) {
                    j2 = IntOffset.constructor-impl((i2 & 4294967295L) | (i4 << 32));
                } else {
                    j2 = IntOffset.constructor-impl((i4 & 4294967295L) | (i2 << 32));
                }
                long j3 = j2;
                PaddingValues paddingValues2 = paddingValues;
                int i6 = lazyLayoutMeasureScope.roundToPx-0680j_4(Dp.constructor-impl(PaddingKt.calculateStartPadding(paddingValues2, lazyLayoutMeasureScope.getLayoutDirection()) + PaddingKt.calculateEndPadding(paddingValues2, lazyLayoutMeasureScope.getLayoutDirection())));
                PaddingValues paddingValues3 = paddingValues;
                LazyStaggeredGridMeasureResult m1372measureStaggeredGridC6celF4 = LazyStaggeredGridMeasureKt.m1372measureStaggeredGridC6celF4(lazyLayoutMeasureScope, LazyStaggeredGridState.this, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(lazyStaggeredGridItemProvider, LazyStaggeredGridState.this.getPinnedItems(), LazyStaggeredGridState.this.getBeyondBoundsInfo()), lazyStaggeredGridItemProvider, mo1347invoke0kLqBqw, Constraints.copy-Zbe2FdA$default(j, ConstraintsKt.constrainWidth-K40F9xA(j, i6), 0, ConstraintsKt.constrainHeight-K40F9xA(j, lazyLayoutMeasureScope.roundToPx-0680j_4(Dp.constructor-impl(paddingValues3.getTop() + paddingValues3.getBottom()))), 0, 10, (Object) null), z4, z, j3, i5, lazyLayoutMeasureScope.roundToPx-0680j_4(f), i2, i3, coroutineScope, z3, lazyLayoutMeasureScope.isLookingAhead(), LazyStaggeredGridState.this.getApproachLayoutInfo(), graphicsContext);
                LazyStaggeredGridState.applyMeasureResult$foundation_release$default(LazyStaggeredGridState.this, m1372measureStaggeredGridC6celF4, lazyLayoutMeasureScope.isLookingAhead(), false, 4, null);
                return m1372measureStaggeredGridC6celF4;
            }
        };
        composer.updateRememberedValue(rememberedValue);
        LazyLayoutMeasurePolicy lazyLayoutMeasurePolicy22 = (LazyLayoutMeasurePolicy) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return lazyLayoutMeasurePolicy22;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float startPadding(PaddingValues paddingValues, Orientation orientation, LayoutDirection layoutDirection) {
        int i = WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()];
        if (i == 1) {
            return PaddingKt.calculateStartPadding(paddingValues, layoutDirection);
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return paddingValues.getTop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float beforePadding(PaddingValues paddingValues, Orientation orientation, boolean z, LayoutDirection layoutDirection) {
        int i = WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()];
        if (i == 1) {
            return z ? paddingValues.getBottom() : paddingValues.getTop();
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        if (z) {
            return PaddingKt.calculateEndPadding(paddingValues, layoutDirection);
        }
        return PaddingKt.calculateStartPadding(paddingValues, layoutDirection);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float afterPadding(PaddingValues paddingValues, Orientation orientation, boolean z, LayoutDirection layoutDirection) {
        int i = WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()];
        if (i == 1) {
            return z ? paddingValues.getTop() : paddingValues.getBottom();
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        if (z) {
            return PaddingKt.calculateStartPadding(paddingValues, layoutDirection);
        }
        return PaddingKt.calculateEndPadding(paddingValues, layoutDirection);
    }
}
