package androidx.compose.foundation.lazy;

import android.os.Trace;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.ScrollingContainerKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.CacheWindowLogic;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocalKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt;
import androidx.compose.foundation.lazy.layout.StickyItemsPlacement;
import androidx.compose.p002ui.Alignment;
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
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: LazyList.kt */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a¢\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0017\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00010\u001b¢\u0006\u0002\b\u001dH\u0001¢\u0006\u0002\u0010\u001e\u001a\u0085\u0001\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0003¢\u0006\u0002\u0010*\u001a\"\u0010+\u001a\u00020\u0001*\u00020,2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.2\u0006\u00100\u001a\u000201H\u0002¨\u00062"}, d2 = {"LazyList", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "isVertical", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "beyondBoundsItemCount", "", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyListScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/OverscrollEffect;ILandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "rememberLazyListMeasurePolicy", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasurePolicy;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/LazyListItemProvider;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "stickyItemsPlacement", "Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZZILandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/graphics/GraphicsContext;Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasurePolicy;", "keepAroundItems", "Landroidx/compose/foundation/lazy/layout/CacheWindowLogic;", "visibleItemsList", "", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "measuredItemProvider", "Landroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class LazyListKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LazyList$lambda$0(Modifier modifier, LazyListState lazyListState, PaddingValues paddingValues, boolean z, boolean z2, FlingBehavior flingBehavior, boolean z3, OverscrollEffect overscrollEffect, int i, Alignment.Horizontal horizontal, Arrangement.Vertical vertical, Alignment.Vertical vertical2, Arrangement.Horizontal horizontal2, Function1 function1, int i2, int i3, int i4, Composer composer, int i5) {
        LazyList(modifier, lazyListState, paddingValues, z, z2, flingBehavior, z3, overscrollEffect, i, horizontal, vertical, vertical2, horizontal2, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x03cd  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x03e1  */
    /* JADX WARN: Removed duplicated region for block: B:91:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LazyList(final Modifier modifier, final LazyListState lazyListState, final PaddingValues paddingValues, final boolean z, final boolean z2, final FlingBehavior flingBehavior, final boolean z3, final OverscrollEffect overscrollEffect, int i, Alignment.Horizontal horizontal, Arrangement.Vertical vertical, Alignment.Vertical vertical2, Arrangement.Horizontal horizontal2, final Function1<? super LazyListScope, Unit> function1, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        Composer composer2;
        final int i13;
        final Alignment.Horizontal horizontal3;
        final Arrangement.Vertical vertical3;
        final Alignment.Vertical vertical4;
        final Arrangement.Horizontal horizontal4;
        ScopeUpdateScope endRestartGroup;
        int i14;
        Arrangement.Horizontal horizontal5;
        Alignment.Horizontal horizontal6;
        int i15;
        Arrangement.Vertical vertical5;
        Alignment.Vertical vertical6;
        Modifier.Companion companion;
        Modifier scrollingContainer;
        int i16;
        Composer startRestartGroup = composer.startRestartGroup(924924659);
        ComposerKt.sourceInformation(startRestartGroup, "C(LazyList)N(modifier,state,contentPadding,reverseLayout,isVertical,flingBehavior,userScrollEnabled,overscrollEffect,beyondBoundsItemCount,horizontalAlignment,verticalArrangement,verticalAlignment,horizontalArrangement,content)86@4193L50,88@4269L48,89@4343L24,90@4415L7,91@4484L7,94@4525L484,133@5813L302,128@5644L1176:LazyList.kt#428nma");
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i5 = (startRestartGroup.changed(modifier) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i2 & 48) == 0) {
            i5 |= startRestartGroup.changed(lazyListState) ? 32 : 16;
        }
        int i17 = i4 & 4;
        int i18 = Fields.SpotShadowColor;
        if (i17 != 0) {
            i5 |= 384;
        } else if ((i2 & 384) == 0) {
            i5 |= startRestartGroup.changed(paddingValues) ? 256 : 128;
            i6 = i4 & 8;
            int i19 = Fields.CameraDistance;
            if (i6 == 0) {
                i5 |= 3072;
            } else if ((i2 & 3072) == 0) {
                i5 |= startRestartGroup.changed(z) ? 2048 : 1024;
            }
            if ((i4 & 16) == 0) {
                i5 |= 24576;
            } else if ((i2 & 24576) == 0) {
                i5 |= startRestartGroup.changed(z2) ? Fields.Clip : Fields.Shape;
            }
            if ((i4 & 32) == 0) {
                i5 |= 196608;
            } else if ((i2 & 196608) == 0) {
                i5 |= startRestartGroup.changed(flingBehavior) ? Fields.RenderEffect : 65536;
                if ((i4 & 64) != 0) {
                    i5 |= 1572864;
                } else if ((i2 & 1572864) == 0) {
                    i5 |= startRestartGroup.changed(z3) ? 1048576 : Fields.BlendMode;
                }
                if ((i4 & Fields.SpotShadowColor) != 0) {
                    i5 |= 12582912;
                } else if ((i2 & 12582912) == 0) {
                    i5 |= startRestartGroup.changed(overscrollEffect) ? 8388608 : 4194304;
                    if ((i2 & 100663296) == 0) {
                        if ((i4 & Fields.RotationX) == 0 && startRestartGroup.changed(i)) {
                            i16 = 67108864;
                            i5 |= i16;
                        }
                        i16 = 33554432;
                        i5 |= i16;
                    }
                    i7 = i4 & Fields.RotationY;
                    if (i7 == 0) {
                        i5 |= 805306368;
                    } else if ((i2 & 805306368) == 0) {
                        i5 |= startRestartGroup.changed(horizontal) ? 536870912 : 268435456;
                    }
                    i8 = i4 & Fields.RotationZ;
                    if (i8 == 0) {
                        i9 = i3 | 6;
                    } else if ((i3 & 6) == 0) {
                        i9 = i3 | (startRestartGroup.changed(vertical) ? 4 : 2);
                    } else {
                        i9 = i3;
                    }
                    i10 = i4 & Fields.CameraDistance;
                    if (i10 == 0) {
                        i9 |= 48;
                    } else if ((i3 & 48) == 0) {
                        i9 |= startRestartGroup.changed(vertical2) ? 32 : 16;
                    }
                    i11 = i9;
                    i12 = i4 & Fields.TransformOrigin;
                    if (i12 == 0) {
                        i11 |= 384;
                    } else if ((i3 & 384) == 0) {
                        if (startRestartGroup.changed(horizontal2)) {
                            i18 = 256;
                        }
                        i11 |= i18;
                        if ((i4 & Fields.Shape) != 0) {
                            i11 |= 3072;
                        } else if ((i3 & 3072) == 0) {
                            if (!startRestartGroup.changedInstance(function1)) {
                                i19 = 1024;
                            }
                            i11 |= i19;
                        }
                        if (startRestartGroup.shouldExecute((306783379 & i5) == 306783378 || (i11 & 1171) != 1170, i5 & 1)) {
                            startRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(startRestartGroup, "74@3490L38");
                            if ((i2 & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                                if ((i4 & Fields.RotationX) != 0) {
                                    i14 = LazyList_androidKt.defaultLazyListBeyondBoundsItemCount(startRestartGroup, 0);
                                    i5 &= -234881025;
                                } else {
                                    i14 = i;
                                }
                                Alignment.Horizontal horizontal7 = i7 != 0 ? null : horizontal;
                                Arrangement.Vertical vertical7 = i8 != 0 ? null : vertical;
                                Alignment.Vertical vertical8 = i10 != 0 ? null : vertical2;
                                if (i12 != 0) {
                                    horizontal6 = horizontal7;
                                    i15 = i5;
                                    vertical5 = vertical7;
                                    vertical6 = vertical8;
                                    horizontal5 = null;
                                } else {
                                    horizontal5 = horizontal2;
                                    horizontal6 = horizontal7;
                                    i15 = i5;
                                    vertical5 = vertical7;
                                    vertical6 = vertical8;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i4 & Fields.RotationX) != 0) {
                                    i5 &= -234881025;
                                }
                                i14 = i;
                                horizontal6 = horizontal;
                                vertical5 = vertical;
                                vertical6 = vertical2;
                                horizontal5 = horizontal2;
                                i15 = i5;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(924924659, i15, i11, "androidx.compose.foundation.lazy.LazyList (LazyList.kt:85)");
                            }
                            int i20 = (i15 >> 3) & 14;
                            Function0<LazyListItemProvider> rememberLazyListItemProviderLambda = LazyListItemProviderKt.rememberLazyListItemProviderLambda(lazyListState, function1, startRestartGroup, i20 | ((i11 >> 6) & 112));
                            int i21 = i15 >> 9;
                            LazyLayoutSemanticState rememberLazyListSemanticState = LazyListSemanticsKt.rememberLazyListSemanticState(lazyListState, z2, startRestartGroup, i20 | (i21 & 112));
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
                            StickyItemsPlacement stickToTopPlacement = ((Boolean) consume2).booleanValue() ^ true ? StickyItemsPlacement.INSTANCE.getStickToTopPlacement() : null;
                            int i22 = i11 << 18;
                            int i23 = i15;
                            int i24 = i14;
                            LazyLayoutMeasurePolicy rememberLazyListMeasurePolicy = rememberLazyListMeasurePolicy(rememberLazyListItemProviderLambda, lazyListState, paddingValues, z, z2, i14, horizontal6, vertical6, horizontal5, vertical5, coroutineScope, graphicsContext, stickToTopPlacement, startRestartGroup, (i21 & 3670016) | (i15 & 112) | (i15 & 896) | (i15 & 7168) | (57344 & i15) | (458752 & i21) | (29360128 & i22) | (i22 & 234881024) | ((i11 << 27) & 1879048192), 0);
                            Orientation orientation = z2 ? Orientation.Vertical : Orientation.Horizontal;
                            if (z3) {
                                composer2 = startRestartGroup;
                                composer2.startReplaceGroup(-2077085864);
                                ComposerKt.sourceInformation(composer2, "116@5260L166");
                                companion = LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(Modifier.INSTANCE, LazyListBeyondBoundsModifierKt.rememberLazyListBeyondBoundsState(lazyListState, i24, composer2, i20 | ((i23 >> 21) & 112)), lazyListState.getBeyondBoundsInfo(), z, orientation);
                                composer2.endReplaceGroup();
                            } else {
                                composer2 = startRestartGroup;
                                composer2.startReplaceGroup(-2076657041);
                                composer2.endReplaceGroup();
                                companion = Modifier.INSTANCE;
                            }
                            scrollingContainer = ScrollingContainerKt.scrollingContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier.then(lazyListState.getRemeasurementModifier()).then(lazyListState.getAwaitLayoutModifier()), rememberLazyListItemProviderLambda, rememberLazyListSemanticState, orientation, z3, z, composer2, ((i23 >> 6) & 57344) | (458752 & (i23 << 6))).then(companion).then(lazyListState.getItemAnimator$foundation_release().getModifier()), lazyListState, orientation, z3, z, flingBehavior, lazyListState.getInternalInteractionSource(), false, overscrollEffect, (r21 & Fields.RotationX) != 0 ? null : null);
                            LazyLayoutKt.LazyLayout(rememberLazyListItemProviderLambda, scrollingContainer, lazyListState.getPrefetchState(), rememberLazyListMeasurePolicy, composer2, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            i13 = i24;
                            horizontal3 = horizontal6;
                            vertical3 = vertical5;
                            vertical4 = vertical6;
                            horizontal4 = horizontal5;
                        } else {
                            composer2 = startRestartGroup;
                            composer2.skipToGroupEnd();
                            i13 = i;
                            horizontal3 = horizontal;
                            vertical3 = vertical;
                            vertical4 = vertical2;
                            horizontal4 = horizontal2;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.LazyListKt$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj, Object obj2) {
                                    Unit LazyList$lambda$0;
                                    LazyList$lambda$0 = LazyListKt.LazyList$lambda$0(Modifier.this, lazyListState, paddingValues, z, z2, flingBehavior, z3, overscrollEffect, i13, horizontal3, vertical3, vertical4, horizontal4, function1, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                    return LazyList$lambda$0;
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if ((i4 & Fields.Shape) != 0) {
                    }
                    if (startRestartGroup.shouldExecute((306783379 & i5) == 306783378 || (i11 & 1171) != 1170, i5 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                if ((i2 & 100663296) == 0) {
                }
                i7 = i4 & Fields.RotationY;
                if (i7 == 0) {
                }
                i8 = i4 & Fields.RotationZ;
                if (i8 == 0) {
                }
                i10 = i4 & Fields.CameraDistance;
                if (i10 == 0) {
                }
                i11 = i9;
                i12 = i4 & Fields.TransformOrigin;
                if (i12 == 0) {
                }
                if ((i4 & Fields.Shape) != 0) {
                }
                if (startRestartGroup.shouldExecute((306783379 & i5) == 306783378 || (i11 & 1171) != 1170, i5 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            if ((i4 & 64) != 0) {
            }
            if ((i4 & Fields.SpotShadowColor) != 0) {
            }
            if ((i2 & 100663296) == 0) {
            }
            i7 = i4 & Fields.RotationY;
            if (i7 == 0) {
            }
            i8 = i4 & Fields.RotationZ;
            if (i8 == 0) {
            }
            i10 = i4 & Fields.CameraDistance;
            if (i10 == 0) {
            }
            i11 = i9;
            i12 = i4 & Fields.TransformOrigin;
            if (i12 == 0) {
            }
            if ((i4 & Fields.Shape) != 0) {
            }
            if (startRestartGroup.shouldExecute((306783379 & i5) == 306783378 || (i11 & 1171) != 1170, i5 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i6 = i4 & 8;
        int i192 = Fields.CameraDistance;
        if (i6 == 0) {
        }
        if ((i4 & 16) == 0) {
        }
        if ((i4 & 32) == 0) {
        }
        if ((i4 & 64) != 0) {
        }
        if ((i4 & Fields.SpotShadowColor) != 0) {
        }
        if ((i2 & 100663296) == 0) {
        }
        i7 = i4 & Fields.RotationY;
        if (i7 == 0) {
        }
        i8 = i4 & Fields.RotationZ;
        if (i8 == 0) {
        }
        i10 = i4 & Fields.CameraDistance;
        if (i10 == 0) {
        }
        i11 = i9;
        i12 = i4 & Fields.TransformOrigin;
        if (i12 == 0) {
        }
        if ((i4 & Fields.Shape) != 0) {
        }
        if (startRestartGroup.shouldExecute((306783379 & i5) == 306783378 || (i11 & 1171) != 1170, i5 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00c9, code lost:
    
        if (r34.changed(r28) == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00e5, code lost:
    
        if (r34.changed(r29) == false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0101, code lost:
    
        if (r34.changed(r30) == false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0120, code lost:
    
        if (r34.changed(r33) == false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x002f, code lost:
    
        if (r34.changed(r22) != false) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final LazyLayoutMeasurePolicy rememberLazyListMeasurePolicy(Function0<? extends LazyListItemProvider> function0, LazyListState lazyListState, PaddingValues paddingValues, boolean z, boolean z2, int i, Alignment.Horizontal horizontal, Alignment.Vertical vertical, Arrangement.Horizontal horizontal2, Arrangement.Vertical vertical2, CoroutineScope coroutineScope, GraphicsContext graphicsContext, StickyItemsPlacement stickyItemsPlacement, Composer composer, int i2, int i3) {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        LazyListKt$rememberLazyListMeasurePolicy$1$1 rememberedValue;
        ComposerKt.sourceInformationMarkerStart(composer, 406165748, "C(rememberLazyListMeasurePolicy)N(itemProviderLambda,state,contentPadding,reverseLayout,isVertical,beyondBoundsItemCount,horizontalAlignment,verticalAlignment,horizontalArrangement,verticalArrangement,coroutineScope,graphicsContext,stickyItemsPlacement)188@8087L9831:LazyList.kt#428nma");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(406165748, i2, i3, "androidx.compose.foundation.lazy.rememberLazyListMeasurePolicy (LazyList.kt:188)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -516689861, "CC(remember):LazyList.kt#9igjgp");
        if (((i2 & 112) ^ 48) <= 32) {
        }
        if ((i2 & 48) != 32) {
            z3 = false;
            boolean z9 = z3 | ((((i2 & 896) ^ 384) <= 256 && composer.changed(paddingValues)) || (i2 & 384) == 256) | ((((i2 & 7168) ^ 3072) <= 2048 && composer.changed(z)) || (i2 & 3072) == 2048) | ((((57344 & i2) ^ 24576) <= 16384 && composer.changed(z2)) || (i2 & 24576) == 16384) | ((((458752 & i2) ^ 196608) <= 131072 && composer.changed(i)) || (i2 & 196608) == 131072) | ((((3670016 & i2) ^ 1572864) <= 1048576 && composer.changed(horizontal)) || (i2 & 1572864) == 1048576);
            if (((29360128 & i2) ^ 12582912) <= 8388608) {
            }
            if ((12582912 & i2) != 8388608) {
                z4 = false;
                boolean z10 = z9 | z4;
                if (((234881024 & i2) ^ 100663296) <= 67108864) {
                }
                if ((100663296 & i2) != 67108864) {
                    z5 = false;
                    boolean z11 = z10 | z5;
                    if (((1879048192 & i2) ^ 805306368) <= 536870912) {
                    }
                    if ((i2 & 805306368) != 536870912) {
                        z6 = false;
                        boolean changed = z6 | z11 | composer.changed(graphicsContext);
                        if (((i3 & 896) ^ 384) <= 256) {
                        }
                        if ((i3 & 384) != 256) {
                            z7 = false;
                            z8 = changed | z7;
                            rememberedValue = composer.rememberedValue();
                            if (!z8 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = new LazyListKt$rememberLazyListMeasurePolicy$1$1(lazyListState, z2, paddingValues, z, function0, vertical2, horizontal2, i, coroutineScope, graphicsContext, stickyItemsPlacement, horizontal, vertical);
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
                        z7 = true;
                        z8 = changed | z7;
                        rememberedValue = composer.rememberedValue();
                        if (!z8) {
                        }
                        rememberedValue = new LazyListKt$rememberLazyListMeasurePolicy$1$1(lazyListState, z2, paddingValues, z, function0, vertical2, horizontal2, i, coroutineScope, graphicsContext, stickyItemsPlacement, horizontal, vertical);
                        composer.updateRememberedValue(rememberedValue);
                        LazyLayoutMeasurePolicy lazyLayoutMeasurePolicy2 = (LazyLayoutMeasurePolicy) rememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        return lazyLayoutMeasurePolicy2;
                    }
                    z6 = true;
                    boolean changed2 = z6 | z11 | composer.changed(graphicsContext);
                    if (((i3 & 896) ^ 384) <= 256) {
                    }
                    if ((i3 & 384) != 256) {
                    }
                    z7 = true;
                    z8 = changed2 | z7;
                    rememberedValue = composer.rememberedValue();
                    if (!z8) {
                    }
                    rememberedValue = new LazyListKt$rememberLazyListMeasurePolicy$1$1(lazyListState, z2, paddingValues, z, function0, vertical2, horizontal2, i, coroutineScope, graphicsContext, stickyItemsPlacement, horizontal, vertical);
                    composer.updateRememberedValue(rememberedValue);
                    LazyLayoutMeasurePolicy lazyLayoutMeasurePolicy22 = (LazyLayoutMeasurePolicy) rememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    return lazyLayoutMeasurePolicy22;
                }
                z5 = true;
                boolean z112 = z10 | z5;
                if (((1879048192 & i2) ^ 805306368) <= 536870912) {
                }
                if ((i2 & 805306368) != 536870912) {
                }
                z6 = true;
                boolean changed22 = z6 | z112 | composer.changed(graphicsContext);
                if (((i3 & 896) ^ 384) <= 256) {
                }
                if ((i3 & 384) != 256) {
                }
                z7 = true;
                z8 = changed22 | z7;
                rememberedValue = composer.rememberedValue();
                if (!z8) {
                }
                rememberedValue = new LazyListKt$rememberLazyListMeasurePolicy$1$1(lazyListState, z2, paddingValues, z, function0, vertical2, horizontal2, i, coroutineScope, graphicsContext, stickyItemsPlacement, horizontal, vertical);
                composer.updateRememberedValue(rememberedValue);
                LazyLayoutMeasurePolicy lazyLayoutMeasurePolicy222 = (LazyLayoutMeasurePolicy) rememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer);
                if (ComposerKt.isTraceInProgress()) {
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                return lazyLayoutMeasurePolicy222;
            }
            z4 = true;
            boolean z102 = z9 | z4;
            if (((234881024 & i2) ^ 100663296) <= 67108864) {
            }
            if ((100663296 & i2) != 67108864) {
            }
            z5 = true;
            boolean z1122 = z102 | z5;
            if (((1879048192 & i2) ^ 805306368) <= 536870912) {
            }
            if ((i2 & 805306368) != 536870912) {
            }
            z6 = true;
            boolean changed222 = z6 | z1122 | composer.changed(graphicsContext);
            if (((i3 & 896) ^ 384) <= 256) {
            }
            if ((i3 & 384) != 256) {
            }
            z7 = true;
            z8 = changed222 | z7;
            rememberedValue = composer.rememberedValue();
            if (!z8) {
            }
            rememberedValue = new LazyListKt$rememberLazyListMeasurePolicy$1$1(lazyListState, z2, paddingValues, z, function0, vertical2, horizontal2, i, coroutineScope, graphicsContext, stickyItemsPlacement, horizontal, vertical);
            composer.updateRememberedValue(rememberedValue);
            LazyLayoutMeasurePolicy lazyLayoutMeasurePolicy2222 = (LazyLayoutMeasurePolicy) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            return lazyLayoutMeasurePolicy2222;
        }
        z3 = true;
        boolean z92 = z3 | ((((i2 & 896) ^ 384) <= 256 && composer.changed(paddingValues)) || (i2 & 384) == 256) | ((((i2 & 7168) ^ 3072) <= 2048 && composer.changed(z)) || (i2 & 3072) == 2048) | ((((57344 & i2) ^ 24576) <= 16384 && composer.changed(z2)) || (i2 & 24576) == 16384) | ((((458752 & i2) ^ 196608) <= 131072 && composer.changed(i)) || (i2 & 196608) == 131072) | ((((3670016 & i2) ^ 1572864) <= 1048576 && composer.changed(horizontal)) || (i2 & 1572864) == 1048576);
        if (((29360128 & i2) ^ 12582912) <= 8388608) {
        }
        if ((12582912 & i2) != 8388608) {
        }
        z4 = true;
        boolean z1022 = z92 | z4;
        if (((234881024 & i2) ^ 100663296) <= 67108864) {
        }
        if ((100663296 & i2) != 67108864) {
        }
        z5 = true;
        boolean z11222 = z1022 | z5;
        if (((1879048192 & i2) ^ 805306368) <= 536870912) {
        }
        if ((i2 & 805306368) != 536870912) {
        }
        z6 = true;
        boolean changed2222 = z6 | z11222 | composer.changed(graphicsContext);
        if (((i3 & 896) ^ 384) <= 256) {
        }
        if ((i3 & 384) != 256) {
        }
        z7 = true;
        z8 = changed2222 | z7;
        rememberedValue = composer.rememberedValue();
        if (!z8) {
        }
        rememberedValue = new LazyListKt$rememberLazyListMeasurePolicy$1$1(lazyListState, z2, paddingValues, z, function0, vertical2, horizontal2, i, coroutineScope, graphicsContext, stickyItemsPlacement, horizontal, vertical);
        composer.updateRememberedValue(rememberedValue);
        LazyLayoutMeasurePolicy lazyLayoutMeasurePolicy22222 = (LazyLayoutMeasurePolicy) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return lazyLayoutMeasurePolicy22222;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void keepAroundItems(CacheWindowLogic cacheWindowLogic, List<LazyListMeasuredItem> list, LazyListMeasuredItemProvider lazyListMeasuredItemProvider) {
        Trace.beginSection("compose:lazy:cache_window:keepAroundItems");
        try {
            if (cacheWindowLogic.hasValidBounds() && (!list.isEmpty())) {
                int index = ((LazyListMeasuredItem) CollectionsKt.first(list)).getIndex();
                int index2 = ((LazyListMeasuredItem) CollectionsKt.last(list)).getIndex();
                for (int prefetchWindowStartLine = cacheWindowLogic.getPrefetchWindowStartLine(); prefetchWindowStartLine < index; prefetchWindowStartLine++) {
                    lazyListMeasuredItemProvider.keepAround(prefetchWindowStartLine);
                }
                int i = index2 + 1;
                int prefetchWindowEndLine = cacheWindowLogic.getPrefetchWindowEndLine();
                if (i <= prefetchWindowEndLine) {
                    while (true) {
                        lazyListMeasuredItemProvider.keepAround(i);
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
