package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.ScrollingContainerKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocalKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.graphics.GraphicsContext;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: LazyStaggeredGrid.kt */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0090\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00010\u0017¢\u0006\u0002\b\u0019H\u0001¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"LazyStaggeredGrid", "", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "slots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;", "modifier", "Landroidx/compose/ui/Modifier;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisSpacing", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;", "Lkotlin/ExtensionFunctionType;", "LazyStaggeredGrid-w41Enmo", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/OverscrollEffect;FFLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class LazyStaggeredGridKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LazyStaggeredGrid_w41Enmo$lambda$0(LazyStaggeredGridState lazyStaggeredGridState, Orientation orientation, LazyGridStaggeredGridSlotsProvider lazyGridStaggeredGridSlotsProvider, Modifier modifier, PaddingValues paddingValues, boolean z, FlingBehavior flingBehavior, boolean z2, OverscrollEffect overscrollEffect, float f, float f2, Function1 function1, int i, int i2, int i3, Composer composer, int i4) {
        m1360LazyStaggeredGridw41Enmo(lazyStaggeredGridState, orientation, lazyGridStaggeredGridSlotsProvider, modifier, paddingValues, z, flingBehavior, z2, overscrollEffect, f, f2, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x038b  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x03a4  */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    /* renamed from: LazyStaggeredGrid-w41Enmo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1360LazyStaggeredGridw41Enmo(final LazyStaggeredGridState lazyStaggeredGridState, final Orientation orientation, final LazyGridStaggeredGridSlotsProvider lazyGridStaggeredGridSlotsProvider, Modifier modifier, PaddingValues paddingValues, boolean z, FlingBehavior flingBehavior, boolean z2, final OverscrollEffect overscrollEffect, float f, float f2, final Function1<? super LazyStaggeredGridScope, Unit> function1, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        Composer composer2;
        final Modifier modifier2;
        final PaddingValues paddingValues2;
        final boolean z3;
        final FlingBehavior flingBehavior2;
        final boolean z4;
        final float f3;
        final float f4;
        ScopeUpdateScope endRestartGroup;
        boolean z5;
        Modifier modifier3;
        FlingBehavior flingBehavior3;
        int i12;
        float f5;
        Modifier modifier4;
        float f6;
        PaddingValues paddingValues3;
        float f7;
        boolean z6;
        int i13;
        FlingBehavior flingBehavior4;
        Modifier.Companion companion;
        Modifier scrollingContainer;
        Composer startRestartGroup = composer.startRestartGroup(-1904835166);
        ComposerKt.sourceInformation(startRestartGroup, "C(LazyStaggeredGrid)N(state,orientation,slots,modifier,contentPadding,reverseLayout,flingBehavior,userScrollEnabled,overscrollEffect,mainAxisSpacing:c#ui.unit.Dp,crossAxisSpacing:c#ui.unit.Dp,content)63@2872L55,64@2953L24,65@3025L7,67@3065L311,79@3401L60,98@4048L302,93@3879L1175:LazyStaggeredGrid.kt#fzvcnm");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changed(lazyStaggeredGridState) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= startRestartGroup.changed(orientation.ordinal()) ? 32 : 16;
        }
        if ((i3 & 4) != 0) {
            i4 |= 384;
        } else if ((i & 384) == 0) {
            i4 |= (i & Fields.RotationY) == 0 ? startRestartGroup.changed(lazyGridStaggeredGridSlotsProvider) : startRestartGroup.changedInstance(lazyGridStaggeredGridSlotsProvider) ? Fields.RotationX : Fields.SpotShadowColor;
        }
        int i14 = i3 & 8;
        if (i14 != 0) {
            i4 |= 3072;
        } else if ((i & 3072) == 0) {
            i4 |= startRestartGroup.changed(modifier) ? Fields.CameraDistance : Fields.RotationZ;
            i5 = i3 & 16;
            if (i5 == 0) {
                i4 |= 24576;
            } else if ((i & 24576) == 0) {
                i4 |= startRestartGroup.changed(paddingValues) ? Fields.Clip : Fields.Shape;
                i6 = i3 & 32;
                if (i6 != 0) {
                    i4 |= 196608;
                } else if ((i & 196608) == 0) {
                    i4 |= startRestartGroup.changed(z) ? Fields.RenderEffect : 65536;
                }
                if ((i & 1572864) == 0) {
                    i4 |= ((i3 & 64) == 0 && startRestartGroup.changed(flingBehavior)) ? 1048576 : Fields.BlendMode;
                }
                i7 = i3 & Fields.SpotShadowColor;
                if (i7 != 0) {
                    i4 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    i4 |= startRestartGroup.changed(z2) ? 8388608 : 4194304;
                }
                if ((i3 & Fields.RotationX) != 0) {
                    i4 |= 100663296;
                } else if ((i & 100663296) == 0) {
                    i4 |= startRestartGroup.changed(overscrollEffect) ? 67108864 : 33554432;
                    i8 = i3 & Fields.RotationY;
                    if (i8 == 0) {
                        i4 |= 805306368;
                    } else if ((i & 805306368) == 0) {
                        i4 |= startRestartGroup.changed(f) ? 536870912 : 268435456;
                    }
                    i9 = i3 & Fields.RotationZ;
                    if (i9 == 0) {
                        i10 = i2 | 6;
                    } else if ((i2 & 6) == 0) {
                        i10 = i2 | (startRestartGroup.changed(f2) ? 4 : 2);
                    } else {
                        i10 = i2;
                    }
                    if ((i3 & Fields.CameraDistance) == 0) {
                        i10 |= 48;
                    } else if ((i2 & 48) == 0) {
                        i10 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
                    }
                    i11 = i10;
                    if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i11 & 19) != 18, i4 & 1)) {
                        startRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(startRestartGroup, "51@2365L15");
                        if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                            startRestartGroup.skipToGroupEnd();
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                            }
                            modifier4 = modifier;
                            paddingValues3 = paddingValues;
                            z5 = z;
                            flingBehavior4 = flingBehavior;
                            z6 = z2;
                            f7 = f;
                            f6 = f2;
                            i13 = i4;
                        } else {
                            Modifier.Companion companion2 = i14 != 0 ? Modifier.INSTANCE : modifier;
                            PaddingValues m1057PaddingValues0680j_4 = i5 != 0 ? PaddingKt.m1057PaddingValues0680j_4(Dp.constructor-impl(0)) : paddingValues;
                            z5 = i6 != 0 ? false : z;
                            if ((i3 & 64) != 0) {
                                modifier3 = companion2;
                                flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(startRestartGroup, 6);
                                i4 &= -3670017;
                            } else {
                                modifier3 = companion2;
                                flingBehavior3 = flingBehavior;
                            }
                            boolean z7 = i7 == 0 ? z2 : true;
                            if (i8 != 0) {
                                i12 = 0;
                                f5 = Dp.constructor-impl(0);
                            } else {
                                i12 = 0;
                                f5 = f;
                            }
                            if (i9 != 0) {
                                modifier4 = modifier3;
                                f6 = Dp.constructor-impl(i12);
                            } else {
                                modifier4 = modifier3;
                                f6 = f2;
                            }
                            paddingValues3 = m1057PaddingValues0680j_4;
                            f7 = f5;
                            z6 = z7;
                            i13 = i4;
                            flingBehavior4 = flingBehavior3;
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1904835166, i13, i11, "androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGrid (LazyStaggeredGrid.kt:62)");
                        }
                        int i15 = i13 & 14;
                        Function0<LazyStaggeredGridItemProvider> rememberStaggeredGridItemProviderLambda = LazyStaggeredGridItemProviderKt.rememberStaggeredGridItemProviderLambda(lazyStaggeredGridState, function1, startRestartGroup, (i11 & 112) | i15);
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
                        int i16 = i13 >> 6;
                        int i17 = i13 >> 12;
                        int i18 = i13;
                        boolean z8 = z5;
                        Modifier modifier5 = modifier4;
                        LazyLayoutMeasurePolicy m1373rememberStaggeredGridMeasurePolicyqKj4JfE = LazyStaggeredGridMeasurePolicyKt.m1373rememberStaggeredGridMeasurePolicyqKj4JfE(lazyStaggeredGridState, rememberStaggeredGridItemProviderLambda, paddingValues3, z5, orientation, f7, f6, coroutineScope, lazyGridStaggeredGridSlotsProvider, graphicsContext, startRestartGroup, (i16 & 7168) | (i16 & 896) | i15 | ((i13 << 9) & 57344) | (i17 & 458752) | (3670016 & (i11 << 18)) | ((i13 << 18) & 234881024));
                        LazyLayoutSemanticState rememberLazyStaggeredGridSemanticState = LazyStaggeredGridSemanticsKt.rememberLazyStaggeredGridSemanticState(lazyStaggeredGridState, z8, startRestartGroup, (i17 & 112) | i15);
                        if (z6) {
                            startRestartGroup.startReplaceGroup(-1834534838);
                            ComposerKt.sourceInformation(startRestartGroup, "84@3604L57");
                            companion = LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(Modifier.INSTANCE, LazyStaggeredGridBeyondBoundsModifierKt.rememberLazyStaggeredGridBeyondBoundsState(lazyStaggeredGridState, startRestartGroup, i15), lazyStaggeredGridState.getBeyondBoundsInfo(), z8, orientation);
                            startRestartGroup.endReplaceGroup();
                        } else {
                            startRestartGroup.startReplaceGroup(-1834229984);
                            startRestartGroup.endReplaceGroup();
                            companion = Modifier.INSTANCE;
                        }
                        composer2 = startRestartGroup;
                        scrollingContainer = ScrollingContainerKt.scrollingContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier5.then(lazyStaggeredGridState.getRemeasurementModifier()).then(lazyStaggeredGridState.getAwaitLayoutModifier()), rememberStaggeredGridItemProviderLambda, rememberLazyStaggeredGridSemanticState, orientation, z6, z8, startRestartGroup, ((i18 << 6) & 7168) | ((i18 >> 9) & 57344) | (i18 & 458752)).then(companion).then(lazyStaggeredGridState.getItemAnimator$foundation_release().getModifier()), lazyStaggeredGridState, orientation, z6, z8, flingBehavior4, lazyStaggeredGridState.getMutableInteractionSource(), false, overscrollEffect, (r21 & Fields.RotationX) != 0 ? null : null);
                        LazyLayoutKt.LazyLayout(rememberStaggeredGridItemProviderLambda, scrollingContainer, lazyStaggeredGridState.getPrefetchState(), m1373rememberStaggeredGridMeasurePolicyqKj4JfE, composer2, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier5;
                        z3 = z8;
                        paddingValues2 = paddingValues3;
                        flingBehavior2 = flingBehavior4;
                        z4 = z6;
                        f3 = f7;
                        f4 = f6;
                    } else {
                        composer2 = startRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier2 = modifier;
                        paddingValues2 = paddingValues;
                        z3 = z;
                        flingBehavior2 = flingBehavior;
                        z4 = z2;
                        f3 = f;
                        f4 = f2;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridKt$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj, Object obj2) {
                                Unit LazyStaggeredGrid_w41Enmo$lambda$0;
                                LazyStaggeredGrid_w41Enmo$lambda$0 = LazyStaggeredGridKt.LazyStaggeredGrid_w41Enmo$lambda$0(LazyStaggeredGridState.this, orientation, lazyGridStaggeredGridSlotsProvider, modifier2, paddingValues2, z3, flingBehavior2, z4, overscrollEffect, f3, f4, function1, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                return LazyStaggeredGrid_w41Enmo$lambda$0;
                            }
                        });
                        return;
                    }
                    return;
                }
                i8 = i3 & Fields.RotationY;
                if (i8 == 0) {
                }
                i9 = i3 & Fields.RotationZ;
                if (i9 == 0) {
                }
                if ((i3 & Fields.CameraDistance) == 0) {
                }
                i11 = i10;
                if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i11 & 19) != 18, i4 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i6 = i3 & 32;
            if (i6 != 0) {
            }
            if ((i & 1572864) == 0) {
            }
            i7 = i3 & Fields.SpotShadowColor;
            if (i7 != 0) {
            }
            if ((i3 & Fields.RotationX) != 0) {
            }
            i8 = i3 & Fields.RotationY;
            if (i8 == 0) {
            }
            i9 = i3 & Fields.RotationZ;
            if (i9 == 0) {
            }
            if ((i3 & Fields.CameraDistance) == 0) {
            }
            i11 = i10;
            if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i11 & 19) != 18, i4 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i5 = i3 & 16;
        if (i5 == 0) {
        }
        i6 = i3 & 32;
        if (i6 != 0) {
        }
        if ((i & 1572864) == 0) {
        }
        i7 = i3 & Fields.SpotShadowColor;
        if (i7 != 0) {
        }
        if ((i3 & Fields.RotationX) != 0) {
        }
        i8 = i3 & Fields.RotationY;
        if (i8 == 0) {
        }
        i9 = i3 & Fields.RotationZ;
        if (i9 == 0) {
        }
        if ((i3 & Fields.CameraDistance) == 0) {
        }
        i11 = i10;
        if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i11 & 19) != 18, i4 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }
}
