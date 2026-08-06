package androidx.compose.foundation.lazy.grid;

import android.os.Trace;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.ScrollingContainerKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.CacheWindowLogic;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocalKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt;
import androidx.compose.foundation.lazy.layout.StickyItemsPlacement;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.graphics.GraphicsContext;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: LazyGrid.kt */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0088\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00010\u0017¢\u0006\u0002\b\u0019H\u0001¢\u0006\u0002\u0010\u001a\u001aq\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0003¢\u0006\u0002\u0010&\u001a*\u0010'\u001a\u00020\u0001*\u00020(2\u0006\u0010)\u001a\u00020*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,2\u0006\u0010.\u001a\u00020/H\u0002¨\u00060"}, d2 = {"LazyGrid", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "slots", "Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "isVertical", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/grid/LazyGridScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/OverscrollEffect;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "rememberLazyGridMeasurePolicy", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasurePolicy;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "stickyItemsScrollBehavior", "Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/graphics/GraphicsContext;Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasurePolicy;", "keepAroundItems", "Landroidx/compose/foundation/lazy/layout/CacheWindowLogic;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "visibleItemsList", "", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "measuredLineProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLineProvider;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class LazyGridKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LazyGrid$lambda$0(Modifier modifier, LazyGridState lazyGridState, LazyGridSlotsProvider lazyGridSlotsProvider, PaddingValues paddingValues, boolean z, boolean z2, FlingBehavior flingBehavior, boolean z3, OverscrollEffect overscrollEffect, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, Function1 function1, int i, int i2, int i3, Composer composer, int i4) {
        LazyGrid(modifier, lazyGridState, lazyGridSlotsProvider, paddingValues, z, z2, flingBehavior, z3, overscrollEffect, vertical, horizontal, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:85:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LazyGrid(Modifier modifier, final LazyGridState lazyGridState, final LazyGridSlotsProvider lazyGridSlotsProvider, PaddingValues paddingValues, boolean z, final boolean z2, FlingBehavior flingBehavior, final boolean z3, final OverscrollEffect overscrollEffect, final Arrangement.Vertical vertical, final Arrangement.Horizontal horizontal, final Function1<? super LazyGridScope, Unit> function1, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        int i5;
        final FlingBehavior flingBehavior2;
        int i6;
        int i7;
        Composer composer2;
        final Modifier modifier2;
        final PaddingValues paddingValues2;
        final boolean z4;
        ScopeUpdateScope endRestartGroup;
        PaddingValues paddingValues3;
        boolean z5;
        FlingBehavior flingBehavior3;
        Modifier modifier3;
        boolean z6;
        Modifier.Companion companion;
        Modifier scrollingContainer;
        Composer startRestartGroup = composer.startRestartGroup(708740370);
        ComposerKt.sourceInformation(startRestartGroup, "C(LazyGrid)N(modifier,state,slots,contentPadding,reverseLayout,isVertical,flingBehavior,userScrollEnabled,overscrollEffect,verticalArrangement,horizontalArrangement,content)84@4019L50,86@4095L51,88@4173L24,89@4245L7,90@4314L7,93@4355L404,126@5425L302,121@5256L1176:LazyGrid.kt#7791vq");
        int i8 = i3 & 1;
        if (i8 != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= startRestartGroup.changed(lazyGridState) ? 32 : 16;
        }
        if ((i3 & 4) != 0) {
            i4 |= 384;
        } else if ((i & 384) == 0) {
            i4 |= (i & Fields.RotationY) == 0 ? startRestartGroup.changed(lazyGridSlotsProvider) : startRestartGroup.changedInstance(lazyGridSlotsProvider) ? Fields.RotationX : Fields.SpotShadowColor;
        }
        int i9 = i3 & 8;
        if (i9 != 0) {
            i4 |= 3072;
        } else if ((i & 3072) == 0) {
            i4 |= startRestartGroup.changed(paddingValues) ? Fields.CameraDistance : Fields.RotationZ;
            i5 = i3 & 16;
            if (i5 == 0) {
                i4 |= 24576;
            } else if ((i & 24576) == 0) {
                i4 |= startRestartGroup.changed(z) ? Fields.Clip : Fields.Shape;
                if ((i3 & 32) != 0) {
                    i4 |= 196608;
                } else if ((i & 196608) == 0) {
                    i4 |= startRestartGroup.changed(z2) ? Fields.RenderEffect : 65536;
                }
                if ((i & 1572864) == 0) {
                    flingBehavior2 = flingBehavior;
                    i4 |= ((i3 & 64) == 0 && startRestartGroup.changed(flingBehavior2)) ? 1048576 : Fields.BlendMode;
                } else {
                    flingBehavior2 = flingBehavior;
                }
                if ((i3 & Fields.SpotShadowColor) != 0) {
                    i4 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    i4 |= startRestartGroup.changed(z3) ? 8388608 : 4194304;
                }
                if ((i3 & Fields.RotationX) != 0) {
                    i4 |= 100663296;
                } else if ((i & 100663296) == 0) {
                    i4 |= startRestartGroup.changed(overscrollEffect) ? 67108864 : 33554432;
                    if ((i3 & Fields.RotationY) == 0) {
                        i4 |= 805306368;
                    } else if ((805306368 & i) == 0) {
                        i4 |= startRestartGroup.changed(vertical) ? 536870912 : 268435456;
                        if ((i3 & Fields.RotationZ) != 0) {
                            i6 = i2 | 6;
                        } else if ((i2 & 6) == 0) {
                            i6 = i2 | (startRestartGroup.changed(horizontal) ? 4 : 2);
                        } else {
                            i6 = i2;
                        }
                        if ((i3 & Fields.CameraDistance) != 0) {
                            i6 |= 48;
                        } else if ((i2 & 48) == 0) {
                            i6 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
                        }
                        i7 = i6;
                        if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i7 & 19) != 18, i4 & 1)) {
                            startRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(startRestartGroup, "72@3487L15");
                            if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                startRestartGroup.skipToGroupEnd();
                                if ((i3 & 64) != 0) {
                                    i4 &= -3670017;
                                }
                                paddingValues3 = paddingValues;
                                z5 = z;
                                flingBehavior3 = flingBehavior2;
                                modifier3 = modifier;
                            } else {
                                Modifier.Companion companion2 = i8 != 0 ? Modifier.INSTANCE : modifier;
                                PaddingValues m1057PaddingValues0680j_4 = i9 != 0 ? PaddingKt.m1057PaddingValues0680j_4(Dp.constructor-impl(0)) : paddingValues;
                                boolean z7 = i5 == 0 ? z : false;
                                if ((i3 & 64) != 0) {
                                    i4 &= -3670017;
                                    modifier3 = companion2;
                                    paddingValues3 = m1057PaddingValues0680j_4;
                                    flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(startRestartGroup, 6);
                                    z5 = z7;
                                } else {
                                    paddingValues3 = m1057PaddingValues0680j_4;
                                    z5 = z7;
                                    flingBehavior3 = flingBehavior2;
                                    modifier3 = companion2;
                                }
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(708740370, i4, i7, "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:83)");
                            }
                            int i10 = (i4 >> 3) & 14;
                            Function0<LazyGridItemProvider> rememberLazyGridItemProviderLambda = LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(lazyGridState, function1, startRestartGroup, (i7 & 112) | i10);
                            int i11 = i4 >> 9;
                            LazyLayoutSemanticState rememberLazyGridSemanticState = LazySemanticsKt.rememberLazyGridSemanticState(lazyGridState, z5, startRestartGroup, (i11 & 112) | i10);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                            Object rememberedValue = startRestartGroup.rememberedValue();
                            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup);
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            CoroutineScope coroutineScope = (CoroutineScope) rememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ProvidableCompositionLocal localGraphicsContext = CompositionLocalsKt.getLocalGraphicsContext();
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object consume = startRestartGroup.consume(localGraphicsContext);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            GraphicsContext graphicsContext = (GraphicsContext) consume;
                            CompositionLocal localScrollCaptureInProgress = CompositionLocalsKt.getLocalScrollCaptureInProgress();
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object consume2 = startRestartGroup.consume(localScrollCaptureInProgress);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            int i12 = i4;
                            boolean z8 = z5;
                            Modifier modifier4 = modifier3;
                            LazyLayoutMeasurePolicy rememberLazyGridMeasurePolicy = rememberLazyGridMeasurePolicy(rememberLazyGridItemProviderLambda, lazyGridState, lazyGridSlotsProvider, paddingValues3, z5, z2, horizontal, vertical, coroutineScope, graphicsContext, ((Boolean) consume2).booleanValue() ^ true ? StickyItemsPlacement.INSTANCE.getStickToTopPlacement() : null, startRestartGroup, ((i7 << 18) & 3670016) | (i4 & 112) | (i4 & 896) | (i4 & 7168) | (57344 & i4) | (458752 & i4) | ((i4 >> 6) & 29360128), 0);
                            Orientation orientation = z2 ? Orientation.Vertical : Orientation.Horizontal;
                            if (z3) {
                                composer2 = startRestartGroup;
                                composer2.startReplaceGroup(27343139);
                                ComposerKt.sourceInformation(composer2, "112@4990L48");
                                z6 = z8;
                                companion = LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(Modifier.INSTANCE, LazyGridBeyondBoundsModifierKt.rememberLazyGridBeyondBoundsState(lazyGridState, composer2, i10), lazyGridState.getBeyondBoundsInfo(), z6, orientation);
                                composer2.endReplaceGroup();
                            } else {
                                composer2 = startRestartGroup;
                                z6 = z8;
                                composer2.startReplaceGroup(27639344);
                                composer2.endReplaceGroup();
                                companion = Modifier.INSTANCE;
                            }
                            boolean z9 = z6;
                            scrollingContainer = ScrollingContainerKt.scrollingContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier4.then(lazyGridState.getRemeasurementModifier()).then(lazyGridState.getAwaitLayoutModifier()), rememberLazyGridItemProviderLambda, rememberLazyGridSemanticState, orientation, z3, z6, composer2, (i11 & 57344) | ((i12 << 3) & 458752)).then(companion).then(lazyGridState.getItemAnimator$foundation_release().getModifier()), lazyGridState, orientation, z3, z6, flingBehavior3, lazyGridState.getInternalInteractionSource(), false, overscrollEffect, (r21 & Fields.RotationX) != 0 ? null : null);
                            LazyLayoutKt.LazyLayout(rememberLazyGridItemProviderLambda, scrollingContainer, lazyGridState.getPrefetchState(), rememberLazyGridMeasurePolicy, composer2, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z4 = z9;
                            paddingValues2 = paddingValues3;
                            flingBehavior2 = flingBehavior3;
                            modifier2 = modifier4;
                        } else {
                            composer2 = startRestartGroup;
                            composer2.skipToGroupEnd();
                            modifier2 = modifier;
                            paddingValues2 = paddingValues;
                            z4 = z;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj, Object obj2) {
                                    Unit LazyGrid$lambda$0;
                                    LazyGrid$lambda$0 = LazyGridKt.LazyGrid$lambda$0(Modifier.this, lazyGridState, lazyGridSlotsProvider, paddingValues2, z4, z2, flingBehavior2, z3, overscrollEffect, vertical, horizontal, function1, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                    return LazyGrid$lambda$0;
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if ((i3 & Fields.RotationZ) != 0) {
                    }
                    if ((i3 & Fields.CameraDistance) != 0) {
                    }
                    i7 = i6;
                    if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i7 & 19) != 18, i4 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                if ((i3 & Fields.RotationY) == 0) {
                }
                if ((i3 & Fields.RotationZ) != 0) {
                }
                if ((i3 & Fields.CameraDistance) != 0) {
                }
                i7 = i6;
                if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i7 & 19) != 18, i4 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            if ((i3 & 32) != 0) {
            }
            if ((i & 1572864) == 0) {
            }
            if ((i3 & Fields.SpotShadowColor) != 0) {
            }
            if ((i3 & Fields.RotationX) != 0) {
            }
            if ((i3 & Fields.RotationY) == 0) {
            }
            if ((i3 & Fields.RotationZ) != 0) {
            }
            if ((i3 & Fields.CameraDistance) != 0) {
            }
            i7 = i6;
            if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i7 & 19) != 18, i4 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i5 = i3 & 16;
        if (i5 == 0) {
        }
        if ((i3 & 32) != 0) {
        }
        if ((i & 1572864) == 0) {
        }
        if ((i3 & Fields.SpotShadowColor) != 0) {
        }
        if ((i3 & Fields.RotationX) != 0) {
        }
        if ((i3 & Fields.RotationY) == 0) {
        }
        if ((i3 & Fields.RotationZ) != 0) {
        }
        if ((i3 & Fields.CameraDistance) != 0) {
        }
        i7 = i6;
        if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i7 & 19) != 18, i4 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0031, code lost:
    
        if (r29.changed(r19) != false) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0115  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final LazyLayoutMeasurePolicy rememberLazyGridMeasurePolicy(Function0<? extends LazyGridItemProvider> function0, LazyGridState lazyGridState, LazyGridSlotsProvider lazyGridSlotsProvider, PaddingValues paddingValues, boolean z, boolean z2, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, CoroutineScope coroutineScope, GraphicsContext graphicsContext, StickyItemsPlacement stickyItemsPlacement, Composer composer, int i, int i2) {
        boolean z3;
        boolean changed;
        LazyGridKt$rememberLazyGridMeasurePolicy$1$1 rememberedValue;
        ComposerKt.sourceInformationMarkerStart(composer, -1030995717, "C(rememberLazyGridMeasurePolicy)N(itemProviderLambda,state,slots,contentPadding,reverseLayout,isVertical,horizontalArrangement,verticalArrangement,coroutineScope,graphicsContext,stickyItemsScrollBehavior)180@7653L12074:LazyGrid.kt#7791vq");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1030995717, i, i2, "androidx.compose.foundation.lazy.grid.rememberLazyGridMeasurePolicy (LazyGrid.kt:180)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1350608741, "CC(remember):LazyGrid.kt#9igjgp");
        if (((i & 112) ^ 48) <= 32) {
        }
        if ((i & 48) != 32) {
            z3 = false;
            changed = z3 | ((((i & 896) ^ 384) <= 256 && composer.changed(lazyGridSlotsProvider)) || (i & 384) == 256) | ((((i & 7168) ^ 3072) <= 2048 && composer.changed(paddingValues)) || (i & 3072) == 2048) | ((((57344 & i) ^ 24576) <= 16384 && composer.changed(z)) || (i & 24576) == 16384) | ((((458752 & i) ^ 196608) <= 131072 && composer.changed(z2)) || (i & 196608) == 131072) | ((((3670016 & i) ^ 1572864) <= 1048576 && composer.changed(horizontal)) || (i & 1572864) == 1048576) | ((((29360128 & i) ^ 12582912) > 8388608 && composer.changed(vertical)) || (i & 12582912) == 8388608) | composer.changed(graphicsContext);
            rememberedValue = composer.rememberedValue();
            if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new LazyGridKt$rememberLazyGridMeasurePolicy$1$1(lazyGridState, z2, paddingValues, z, function0, lazyGridSlotsProvider, vertical, horizontal, coroutineScope, graphicsContext, stickyItemsPlacement);
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
        z3 = true;
        if (((29360128 & i) ^ 12582912) > 8388608) {
            changed = z3 | ((((i & 896) ^ 384) <= 256 && composer.changed(lazyGridSlotsProvider)) || (i & 384) == 256) | ((((i & 7168) ^ 3072) <= 2048 && composer.changed(paddingValues)) || (i & 3072) == 2048) | ((((57344 & i) ^ 24576) <= 16384 && composer.changed(z)) || (i & 24576) == 16384) | ((((458752 & i) ^ 196608) <= 131072 && composer.changed(z2)) || (i & 196608) == 131072) | ((((3670016 & i) ^ 1572864) <= 1048576 && composer.changed(horizontal)) || (i & 1572864) == 1048576) | ((((29360128 & i) ^ 12582912) > 8388608 && composer.changed(vertical)) || (i & 12582912) == 8388608) | composer.changed(graphicsContext);
            rememberedValue = composer.rememberedValue();
            if (!changed) {
            }
            rememberedValue = new LazyGridKt$rememberLazyGridMeasurePolicy$1$1(lazyGridState, z2, paddingValues, z, function0, lazyGridSlotsProvider, vertical, horizontal, coroutineScope, graphicsContext, stickyItemsPlacement);
            composer.updateRememberedValue(rememberedValue);
            LazyLayoutMeasurePolicy lazyLayoutMeasurePolicy2 = (LazyLayoutMeasurePolicy) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            return lazyLayoutMeasurePolicy2;
        }
        changed = z3 | ((((i & 896) ^ 384) <= 256 && composer.changed(lazyGridSlotsProvider)) || (i & 384) == 256) | ((((i & 7168) ^ 3072) <= 2048 && composer.changed(paddingValues)) || (i & 3072) == 2048) | ((((57344 & i) ^ 24576) <= 16384 && composer.changed(z)) || (i & 24576) == 16384) | ((((458752 & i) ^ 196608) <= 131072 && composer.changed(z2)) || (i & 196608) == 131072) | ((((3670016 & i) ^ 1572864) <= 1048576 && composer.changed(horizontal)) || (i & 1572864) == 1048576) | ((((29360128 & i) ^ 12582912) > 8388608 && composer.changed(vertical)) || (i & 12582912) == 8388608) | composer.changed(graphicsContext);
        rememberedValue = composer.rememberedValue();
        if (!changed) {
        }
        rememberedValue = new LazyGridKt$rememberLazyGridMeasurePolicy$1$1(lazyGridState, z2, paddingValues, z, function0, lazyGridSlotsProvider, vertical, horizontal, coroutineScope, graphicsContext, stickyItemsPlacement);
        composer.updateRememberedValue(rememberedValue);
        LazyLayoutMeasurePolicy lazyLayoutMeasurePolicy22 = (LazyLayoutMeasurePolicy) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return lazyLayoutMeasurePolicy22;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void keepAroundItems(CacheWindowLogic cacheWindowLogic, Orientation orientation, List<LazyGridMeasuredItem> list, LazyGridMeasuredLineProvider lazyGridMeasuredLineProvider) {
        Trace.beginSection("compose:lazy:cache_window:keepAroundItems");
        try {
            if (cacheWindowLogic.hasValidBounds() && (!list.isEmpty())) {
                int lineIndex = LazyGridItemInfoKt.lineIndex((LazyGridItemInfo) CollectionsKt.first(list), orientation);
                int lineIndex2 = LazyGridItemInfoKt.lineIndex((LazyGridItemInfo) CollectionsKt.last(list), orientation);
                for (int prefetchWindowStartLine = cacheWindowLogic.getPrefetchWindowStartLine(); prefetchWindowStartLine < lineIndex; prefetchWindowStartLine++) {
                    lazyGridMeasuredLineProvider.keepAround(prefetchWindowStartLine);
                }
                int i = lineIndex2 + 1;
                int prefetchWindowEndLine = cacheWindowLogic.getPrefetchWindowEndLine();
                if (i <= prefetchWindowEndLine) {
                    while (true) {
                        lazyGridMeasuredLineProvider.keepAround(i);
                        if (i == prefetchWindowEndLine) {
                            break;
                        } else {
                            i++;
                        }
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }
}
