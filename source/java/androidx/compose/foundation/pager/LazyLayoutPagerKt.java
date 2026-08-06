package androidx.compose.foundation.pager;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.ScrollingContainerKt;
import androidx.compose.foundation.gestures.BringIntoViewSpec;
import androidx.compose.foundation.gestures.BringIntoViewSpec_androidKt;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocalKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt;
import androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap;
import androidx.compose.p002ui.Alignment;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.geometry.Offset;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.p002ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.p002ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p002ui.input.pointer.PointerEvent;
import androidx.compose.p002ui.input.pointer.PointerEventKt;
import androidx.compose.p002ui.input.pointer.PointerEventPass;
import androidx.compose.p002ui.input.pointer.PointerInputChange;
import androidx.compose.p002ui.input.pointer.PointerInputEventHandler;
import androidx.compose.p002ui.input.pointer.PointerInputScope;
import androidx.compose.p002ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.reflect.KProperty0;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: LazyLayoutPager.kt */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aå\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182#\u0010\u0019\u001a\u001f\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001a2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$21\u0010%\u001a-\u0012\u0004\u0012\u00020'\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u00010&¢\u0006\u0002\b)¢\u0006\u0002\b*H\u0001¢\u0006\u0004\b+\u0010,\u001a\u0081\u0001\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.2\u0006\u0010\u0004\u001a\u00020\u000521\u0010%\u001a-\u0012\u0004\u0012\u00020'\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u00010&¢\u0006\u0002\b)¢\u0006\u0002\b*2#\u0010\u0019\u001a\u001f\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001a2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00120.H\u0003¢\u0006\u0002\u00101\u001a\u0014\u00102\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002¨\u00063"}, d2 = {"Pager", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/pager/PagerState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "flingBehavior", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "userScrollEnabled", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "beyondViewportPageCount", "", "pageSpacing", "Landroidx/compose/ui/unit/Dp;", "pageSize", "Landroidx/compose/foundation/pager/PageSize;", "pageNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "key", "Lkotlin/Function1;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "index", "", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "pageContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/pager/PagerScope;", "page", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "Pager-eLwUrMk", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/gestures/TargetedFlingBehavior;ZLandroidx/compose/foundation/OverscrollEffect;IFLandroidx/compose/foundation/pager/PageSize;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "rememberPagerItemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "pageCount", "(Landroidx/compose/foundation/pager/PagerState;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function0;", "dragDirectionDetector", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class LazyLayoutPagerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Pager_eLwUrMk$lambda$7(Modifier modifier, PagerState pagerState, PaddingValues paddingValues, boolean z, Orientation orientation, TargetedFlingBehavior targetedFlingBehavior, boolean z2, OverscrollEffect overscrollEffect, int i, float f, PageSize pageSize, NestedScrollConnection nestedScrollConnection, Function1 function1, Alignment.Horizontal horizontal, Alignment.Vertical vertical, SnapPosition snapPosition, Function4 function4, int i2, int i3, int i4, Composer composer, int i5) {
        m1396PagereLwUrMk(modifier, pagerState, paddingValues, z, orientation, targetedFlingBehavior, z2, overscrollEffect, i, f, pageSize, nestedScrollConnection, function1, horizontal, vertical, snapPosition, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x04f0  */
    /* JADX WARN: Removed duplicated region for block: B:128:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x04e0  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0229  */
    /* renamed from: Pager-eLwUrMk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1396PagereLwUrMk(final Modifier modifier, final PagerState pagerState, final PaddingValues paddingValues, final boolean z, final Orientation orientation, final TargetedFlingBehavior targetedFlingBehavior, final boolean z2, final OverscrollEffect overscrollEffect, int i, float f, final PageSize pageSize, final NestedScrollConnection nestedScrollConnection, final Function1<? super Integer, ? extends Object> function1, final Alignment.Horizontal horizontal, final Alignment.Vertical vertical, final SnapPosition snapPosition, final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        Composer composer2;
        final int i12;
        float f2;
        ScopeUpdateScope endRestartGroup;
        boolean z3;
        int i13;
        Modifier.Companion companion;
        Composer startRestartGroup = composer.startRestartGroup(-572816025);
        ComposerKt.sourceInformation(startRestartGroup, "C(Pager)N(modifier,state,contentPadding,reverseLayout,orientation,flingBehavior,userScrollEnabled,overscrollEffect,beyondViewportPageCount,pageSpacing:c#ui.unit.Dp,pageSize,pageNestedScrollConnection,key,horizontalAlignment,verticalAlignment,snapPosition,pageContent)109@5366L39,109@5281L124,113@5432L24,129@6075L19,116@5490L615,132@6131L70,135@6243L82,137@6385L7,139@6434L121,164@7272L301,159@7103L1509:LazyLayoutPager.kt#g6yjnt");
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
            i5 |= startRestartGroup.changed(pagerState) ? 32 : 16;
        }
        int i14 = i4 & 4;
        int i15 = Fields.RotationX;
        if (i14 != 0) {
            i5 |= 384;
        } else if ((i2 & 384) == 0) {
            i5 |= startRestartGroup.changed(paddingValues) ? 256 : 128;
            i6 = i4 & 8;
            int i16 = Fields.CameraDistance;
            if (i6 == 0) {
                i5 |= 3072;
            } else if ((i2 & 3072) == 0) {
                i5 |= startRestartGroup.changed(z) ? 2048 : 1024;
            }
            i7 = i4 & 16;
            int i17 = Fields.Clip;
            if (i7 == 0) {
                i5 |= 24576;
            } else if ((i2 & 24576) == 0) {
                i5 |= startRestartGroup.changed(orientation.ordinal()) ? 16384 : 8192;
            }
            if ((i4 & 32) == 0) {
                i5 |= 196608;
            } else if ((i2 & 196608) == 0) {
                i5 |= startRestartGroup.changed(targetedFlingBehavior) ? Fields.RenderEffect : 65536;
            }
            if ((i4 & 64) == 0) {
                i5 |= 1572864;
            } else if ((i2 & 1572864) == 0) {
                i5 |= startRestartGroup.changed(z2) ? 1048576 : Fields.BlendMode;
            }
            if ((i4 & Fields.SpotShadowColor) == 0) {
                i5 |= 12582912;
            } else if ((12582912 & i2) == 0) {
                i5 |= startRestartGroup.changed(overscrollEffect) ? 8388608 : 4194304;
                i8 = i4 & Fields.RotationX;
                if (i8 != 0) {
                    i5 |= 100663296;
                } else if ((i2 & 100663296) == 0) {
                    i5 |= startRestartGroup.changed(i) ? 67108864 : 33554432;
                }
                i9 = i4 & Fields.RotationY;
                if (i9 != 0) {
                    i5 |= 805306368;
                } else if ((i2 & 805306368) == 0) {
                    i5 |= startRestartGroup.changed(f) ? 536870912 : 268435456;
                }
                if ((i4 & Fields.RotationZ) != 0) {
                    i10 = i3 | 6;
                } else if ((i3 & 6) == 0) {
                    i10 = i3 | (startRestartGroup.changed(pageSize) ? 4 : 2);
                } else {
                    i10 = i3;
                }
                if ((i4 & Fields.CameraDistance) != 0) {
                    i10 |= 48;
                } else if ((i3 & 48) == 0) {
                    i10 |= startRestartGroup.changedInstance(nestedScrollConnection) ? 32 : 16;
                }
                i11 = i10;
                if ((i4 & Fields.TransformOrigin) != 0) {
                    i11 |= 384;
                } else if ((i3 & 384) == 0) {
                    if (!startRestartGroup.changedInstance(function1)) {
                        i15 = 128;
                    }
                    i11 |= i15;
                    if ((i4 & Fields.Shape) == 0) {
                        i11 |= 3072;
                    } else if ((i3 & 3072) == 0) {
                        if (!startRestartGroup.changed(horizontal)) {
                            i16 = 1024;
                        }
                        i11 |= i16;
                        if ((i4 & Fields.Clip) != 0) {
                            i11 |= 24576;
                        } else if ((i3 & 24576) == 0) {
                            if (!startRestartGroup.changed(vertical)) {
                                i17 = 8192;
                            }
                            i11 |= i17;
                            if ((i4 & Fields.CompositingStrategy) == 0) {
                                i11 |= 196608;
                            } else if ((i3 & 196608) == 0) {
                                i11 |= startRestartGroup.changed(snapPosition) ? Fields.RenderEffect : 65536;
                            }
                            if ((i4 & 65536) == 0) {
                                i11 |= 1572864;
                            } else if ((i3 & 1572864) == 0) {
                                i11 |= startRestartGroup.changedInstance(function4) ? 1048576 : Fields.BlendMode;
                            }
                            if (startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (599187 & i11) != 599186, i5 & 1)) {
                                composer2 = startRestartGroup;
                                composer2.skipToGroupEnd();
                                i12 = i;
                                f2 = f;
                            } else {
                                int i18 = i8 != 0 ? 0 : i;
                                float f3 = i9 != 0 ? Dp.constructor-impl(0) : f;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-572816025, i5, i11, "androidx.compose.foundation.pager.Pager (LazyLayoutPager.kt:102)");
                                }
                                if (!(i18 >= 0)) {
                                    InlineClassHelperKt.throwIllegalArgumentException("beyondViewportPageCount should be greater than or equal to 0, you selected " + i18);
                                }
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -720317842, "CC(remember):LazyLayoutPager.kt#9igjgp");
                                int i19 = i5 & 112;
                                boolean z4 = i19 == 32;
                                Object rememberedValue = startRestartGroup.rememberedValue();
                                if (z4 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = new Function0() { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$$ExternalSyntheticLambda0
                                        public final Object invoke() {
                                            int pageCount;
                                            pageCount = PagerState.this.getPageCount();
                                            return Integer.valueOf(pageCount);
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                Function0 function0 = (Function0) rememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                int i20 = i5 >> 3;
                                int i21 = i20 & 14;
                                int i22 = i11 >> 15;
                                int i23 = i5;
                                int i24 = i11;
                                int i25 = i18;
                                Function0<PagerLazyLayoutItemProvider> rememberPagerItemProviderLambda = rememberPagerItemProviderLambda(pagerState, function4, function1, function0, startRestartGroup, i21 | (i22 & 112) | (i11 & 896));
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                                Object rememberedValue2 = startRestartGroup.rememberedValue();
                                if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup);
                                    startRestartGroup.updateRememberedValue(rememberedValue2);
                                }
                                CoroutineScope coroutineScope = (CoroutineScope) rememberedValue2;
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -720295174, "CC(remember):LazyLayoutPager.kt#9igjgp");
                                boolean z5 = i19 == 32;
                                Object rememberedValue3 = startRestartGroup.rememberedValue();
                                if (z5 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue3 = new Function0() { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$$ExternalSyntheticLambda1
                                        public final Object invoke() {
                                            int pageCount;
                                            pageCount = PagerState.this.getPageCount();
                                            return Integer.valueOf(pageCount);
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue3);
                                }
                                Function0 function02 = (Function0) rememberedValue3;
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                int i26 = i23 >> 9;
                                int i27 = (i23 & 896) | i19 | (i23 & 7168) | (57344 & i23) | (458752 & i26) | (i26 & 3670016) | ((i24 << 21) & 29360128);
                                int i28 = i24 << 15;
                                f2 = f3;
                                LazyLayoutMeasurePolicy m1414rememberPagerMeasurePolicy8u0NR3k = PagerMeasurePolicyKt.m1414rememberPagerMeasurePolicy8u0NR3k(rememberPagerItemProviderLambda, pagerState, paddingValues, z, orientation, i25, f3, pageSize, horizontal, vertical, snapPosition, coroutineScope, function02, startRestartGroup, i27 | (234881024 & i28) | (i28 & 1879048192), i22 & 14);
                                if (orientation == Orientation.Vertical) {
                                    z3 = true;
                                    composer2 = startRestartGroup;
                                } else {
                                    composer2 = startRestartGroup;
                                    z3 = false;
                                }
                                LazyLayoutSemanticState rememberPagerSemanticState = PagerSemanticsKt.rememberPagerSemanticState(pagerState, z3, composer2, i21);
                                ComposerKt.sourceInformationMarkerStart(composer2, -720289735, "CC(remember):LazyLayoutPager.kt#9igjgp");
                                boolean z6 = ((i23 & 458752) == 131072) | (i19 == 32);
                                Object rememberedValue4 = composer2.rememberedValue();
                                if (z6 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue4 = new PagerWrapperFlingBehavior(targetedFlingBehavior, pagerState);
                                    composer2.updateRememberedValue(rememberedValue4);
                                }
                                PagerWrapperFlingBehavior pagerWrapperFlingBehavior = (PagerWrapperFlingBehavior) rememberedValue4;
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ProvidableCompositionLocal<BringIntoViewSpec> localBringIntoViewSpec = BringIntoViewSpec_androidKt.getLocalBringIntoViewSpec();
                                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object consume = composer2.consume(localBringIntoViewSpec);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                BringIntoViewSpec bringIntoViewSpec = (BringIntoViewSpec) consume;
                                ComposerKt.sourceInformationMarkerStart(composer2, -720283584, "CC(remember):LazyLayoutPager.kt#9igjgp");
                                boolean changed = composer2.changed(bringIntoViewSpec) | (i19 == 32);
                                Object rememberedValue5 = composer2.rememberedValue();
                                if (changed || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue5 = new PagerBringIntoViewSpec(pagerState, bringIntoViewSpec);
                                    composer2.updateRememberedValue(rememberedValue5);
                                }
                                PagerBringIntoViewSpec pagerBringIntoViewSpec = (PagerBringIntoViewSpec) rememberedValue5;
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                if (z2) {
                                    composer2.startReplaceGroup(-853761213);
                                    ComposerKt.sourceInformation(composer2, "147@6718L167");
                                    i13 = i25;
                                    companion = LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(Modifier.INSTANCE, PagerBeyondBoundsModifierKt.rememberPagerBeyondBoundsState(pagerState, i13, composer2, i21 | ((i23 >> 21) & 112)), pagerState.getBeyondBoundsInfo(), z, orientation);
                                    composer2.endReplaceGroup();
                                } else {
                                    i13 = i25;
                                    composer2.startReplaceGroup(-853331429);
                                    composer2.endReplaceGroup();
                                    companion = Modifier.INSTANCE;
                                }
                                int i29 = i13;
                                LazyLayoutKt.LazyLayout(rememberPagerItemProviderLambda, NestedScrollModifierKt.nestedScroll$default(dragDirectionDetector(ScrollingContainerKt.scrollingContainer(PagerKt.pagerSemantics(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier.then(pagerState.getRemeasurementModifier()).then(pagerState.getAwaitLayoutModifier()), rememberPagerItemProviderLambda, rememberPagerSemanticState, orientation, z2, z, composer2, (i20 & 7168) | ((i23 >> 6) & 57344) | ((i23 << 6) & 458752)), pagerState, orientation == Orientation.Vertical, coroutineScope, z2).then(companion), pagerState, orientation, z2, z, pagerWrapperFlingBehavior, pagerState.getInternalInteractionSource(), false, overscrollEffect, pagerBringIntoViewSpec), pagerState), nestedScrollConnection, null, 2, null), pagerState.getPrefetchState(), m1414rememberPagerMeasurePolicy8u0NR3k, composer2, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                i12 = i29;
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                final float f4 = f2;
                                endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$$ExternalSyntheticLambda2
                                    public final Object invoke(Object obj, Object obj2) {
                                        Unit Pager_eLwUrMk$lambda$7;
                                        Pager_eLwUrMk$lambda$7 = LazyLayoutPagerKt.Pager_eLwUrMk$lambda$7(Modifier.this, pagerState, paddingValues, z, orientation, targetedFlingBehavior, z2, overscrollEffect, i12, f4, pageSize, nestedScrollConnection, function1, horizontal, vertical, snapPosition, function4, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                        return Pager_eLwUrMk$lambda$7;
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        if ((i4 & Fields.CompositingStrategy) == 0) {
                        }
                        if ((i4 & 65536) == 0) {
                        }
                        if (startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (599187 & i11) != 599186, i5 & 1)) {
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    if ((i4 & Fields.Clip) != 0) {
                    }
                    if ((i4 & Fields.CompositingStrategy) == 0) {
                    }
                    if ((i4 & 65536) == 0) {
                    }
                    if (startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (599187 & i11) != 599186, i5 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                if ((i4 & Fields.Shape) == 0) {
                }
                if ((i4 & Fields.Clip) != 0) {
                }
                if ((i4 & Fields.CompositingStrategy) == 0) {
                }
                if ((i4 & 65536) == 0) {
                }
                if (startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (599187 & i11) != 599186, i5 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i8 = i4 & Fields.RotationX;
            if (i8 != 0) {
            }
            i9 = i4 & Fields.RotationY;
            if (i9 != 0) {
            }
            if ((i4 & Fields.RotationZ) != 0) {
            }
            if ((i4 & Fields.CameraDistance) != 0) {
            }
            i11 = i10;
            if ((i4 & Fields.TransformOrigin) != 0) {
            }
            if ((i4 & Fields.Shape) == 0) {
            }
            if ((i4 & Fields.Clip) != 0) {
            }
            if ((i4 & Fields.CompositingStrategy) == 0) {
            }
            if ((i4 & 65536) == 0) {
            }
            if (startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (599187 & i11) != 599186, i5 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i6 = i4 & 8;
        int i162 = Fields.CameraDistance;
        if (i6 == 0) {
        }
        i7 = i4 & 16;
        int i172 = Fields.Clip;
        if (i7 == 0) {
        }
        if ((i4 & 32) == 0) {
        }
        if ((i4 & 64) == 0) {
        }
        if ((i4 & Fields.SpotShadowColor) == 0) {
        }
        i8 = i4 & Fields.RotationX;
        if (i8 != 0) {
        }
        i9 = i4 & Fields.RotationY;
        if (i9 != 0) {
        }
        if ((i4 & Fields.RotationZ) != 0) {
        }
        if ((i4 & Fields.CameraDistance) != 0) {
        }
        i11 = i10;
        if ((i4 & Fields.TransformOrigin) != 0) {
        }
        if ((i4 & Fields.Shape) == 0) {
        }
        if ((i4 & Fields.Clip) != 0) {
        }
        if ((i4 & Fields.CompositingStrategy) == 0) {
        }
        if ((i4 & 65536) == 0) {
        }
        if (startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (599187 & i11) != 599186, i5 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    private static final Function0<PagerLazyLayoutItemProvider> rememberPagerItemProviderLambda(final PagerState pagerState, Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, Function1<? super Integer, ? extends Object> function1, final Function0<Integer> function0, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1052364153, "C(rememberPagerItemProviderLambda)N(state,pageContent,key,pageCount)259@10826L33,260@10880L25,261@10917L742:LazyLayoutPager.kt#g6yjnt");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1052364153, i, -1, "androidx.compose.foundation.pager.rememberPagerItemProviderLambda (LazyLayoutPager.kt:258)");
        }
        final State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function4, composer, (i >> 3) & 14);
        final State rememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(function1, composer, (i >> 6) & 14);
        ComposerKt.sourceInformationMarkerStart(composer, 2004648543, "CC(remember):LazyLayoutPager.kt#9igjgp");
        boolean changed = ((((i & 14) ^ 6) > 4 && composer.changed(pagerState)) || (i & 6) == 4) | composer.changed(rememberUpdatedState) | composer.changed(rememberUpdatedState2) | ((((i & 7168) ^ 3072) > 2048 && composer.changed(function0)) || (i & 3072) == 2048);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            final State derivedStateOf = SnapshotStateKt.derivedStateOf(SnapshotStateKt.referentialEqualityPolicy(), new Function0() { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$$ExternalSyntheticLambda3
                public final Object invoke() {
                    PagerLayoutIntervalContent rememberPagerItemProviderLambda$lambda$10$lambda$8;
                    rememberPagerItemProviderLambda$lambda$10$lambda$8 = LazyLayoutPagerKt.rememberPagerItemProviderLambda$lambda$10$lambda$8(State.this, rememberUpdatedState2, function0);
                    return rememberPagerItemProviderLambda$lambda$10$lambda$8;
                }
            });
            final State derivedStateOf2 = SnapshotStateKt.derivedStateOf(SnapshotStateKt.referentialEqualityPolicy(), new Function0() { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$$ExternalSyntheticLambda4
                public final Object invoke() {
                    PagerLazyLayoutItemProvider rememberPagerItemProviderLambda$lambda$10$lambda$9;
                    rememberPagerItemProviderLambda$lambda$10$lambda$9 = LazyLayoutPagerKt.rememberPagerItemProviderLambda$lambda$10$lambda$9(State.this, pagerState);
                    return rememberPagerItemProviderLambda$lambda$10$lambda$9;
                }
            });
            rememberedValue = (KProperty0) new PropertyReference0Impl(derivedStateOf2) { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$rememberPagerItemProviderLambda$1$1
                public Object get() {
                    return ((State) this.receiver).getValue();
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        Function0<PagerLazyLayoutItemProvider> function02 = (KProperty0) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return function02;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagerLayoutIntervalContent rememberPagerItemProviderLambda$lambda$10$lambda$8(State state, State state2, Function0 function0) {
        return new PagerLayoutIntervalContent((Function4) state.getValue(), (Function1) state2.getValue(), ((Number) function0.invoke()).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagerLazyLayoutItemProvider rememberPagerItemProviderLambda$lambda$10$lambda$9(State state, PagerState pagerState) {
        PagerLayoutIntervalContent pagerLayoutIntervalContent = (PagerLayoutIntervalContent) state.getValue();
        return new PagerLazyLayoutItemProvider(pagerState, pagerLayoutIntervalContent, new NearestRangeKeyIndexMap(pagerState.getNearestRange$foundation_release(), pagerLayoutIntervalContent));
    }

    private static final Modifier dragDirectionDetector(Modifier modifier, final PagerState pagerState) {
        return modifier.then(SuspendingPointerInputFilterKt.pointerInput(Modifier.INSTANCE, pagerState, new PointerInputEventHandler() { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1

            /* compiled from: LazyLayoutPager.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1$1", f = "LazyLayoutPager.kt", i = {}, l = {286}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1$1 */
            /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
            static final class C03621 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PagerState $state;
                final /* synthetic */ PointerInputScope $this_pointerInput;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C03621(PointerInputScope pointerInputScope, PagerState pagerState, Continuation<? super C03621> continuation) {
                    super(2, continuation);
                    this.$this_pointerInput = pointerInputScope;
                    this.$state = pagerState;
                }

                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C03621(this.$this_pointerInput, this.$state, continuation);
                }

                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: LazyLayoutPager.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                @DebugMetadata(c = "androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1$1$1", f = "LazyLayoutPager.kt", i = {0, 1, 1, 1}, l = {288, 292}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "downEvent", "upEventOrCancellation"}, s = {"L$0", "L$0", "L$1", "L$2"})
                /* renamed from: androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1$1$1, reason: invalid class name */
                /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
                public static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ PagerState $state;
                    private /* synthetic */ Object L$0;
                    Object L$1;
                    Object L$2;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(PagerState pagerState, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$state = pagerState;
                    }

                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$state, continuation);
                        anonymousClass1.L$0 = obj;
                        return anonymousClass1;
                    }

                    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                        return create(awaitPointerEventScope, continuation).invokeSuspend(Unit.INSTANCE);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:14:0x009f  */
                    /* JADX WARN: Removed duplicated region for block: B:16:0x0060  */
                    /* JADX WARN: Removed duplicated region for block: B:21:0x00b6  */
                    /* JADX WARN: Removed duplicated region for block: B:23:0x00b0  */
                    /* JADX WARN: Removed duplicated region for block: B:24:0x009c A[SYNTHETIC] */
                    /* JADX WARN: Removed duplicated region for block: B:8:0x008b  */
                    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0074 -> B:6:0x007b). Please report as a decompilation issue!!! */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object invokeSuspend(Object obj) {
                        AwaitPointerEventScope awaitPointerEventScope;
                        AwaitPointerEventScope awaitPointerEventScope2;
                        PointerInputChange pointerInputChange;
                        PointerInputChange pointerInputChange2;
                        AnonymousClass1 anonymousClass1;
                        boolean z;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                            this.L$0 = awaitPointerEventScope;
                            this.label = 1;
                            obj = TapGestureDetectorKt.awaitFirstDown(awaitPointerEventScope, false, PointerEventPass.Initial, (Continuation) this);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else if (i == 1) {
                            awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                            ResultKt.throwOnFailure(obj);
                        } else {
                            if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            PointerInputChange pointerInputChange3 = (PointerInputChange) this.L$2;
                            PointerInputChange pointerInputChange4 = (PointerInputChange) this.L$1;
                            AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            AwaitPointerEventScope awaitPointerEventScope4 = awaitPointerEventScope3;
                            PointerInputChange pointerInputChange5 = pointerInputChange4;
                            PointerInputChange pointerInputChange6 = pointerInputChange3;
                            Object obj2 = coroutine_suspended;
                            AnonymousClass1 anonymousClass12 = this;
                            PointerEvent pointerEvent = (PointerEvent) obj;
                            List<PointerInputChange> changes = pointerEvent.getChanges();
                            int size = changes.size();
                            int i2 = 0;
                            while (true) {
                                if (i2 >= size) {
                                    z = true;
                                    break;
                                }
                                if (!PointerEventKt.changedToUp(changes.get(i2))) {
                                    z = false;
                                    break;
                                }
                                i2++;
                            }
                            if (z) {
                                anonymousClass1 = anonymousClass12;
                                coroutine_suspended = obj2;
                                pointerInputChange = pointerInputChange6;
                                pointerInputChange2 = pointerInputChange5;
                                awaitPointerEventScope2 = awaitPointerEventScope4;
                            } else {
                                pointerInputChange2 = pointerInputChange5;
                                awaitPointerEventScope2 = awaitPointerEventScope4;
                                Object obj3 = obj2;
                                pointerInputChange = pointerEvent.getChanges().get(0);
                                anonymousClass1 = anonymousClass12;
                                coroutine_suspended = obj3;
                            }
                            if (pointerInputChange == null) {
                                anonymousClass1.L$0 = awaitPointerEventScope2;
                                anonymousClass1.L$1 = pointerInputChange2;
                                anonymousClass1.L$2 = pointerInputChange;
                                anonymousClass1.label = 2;
                                Object awaitPointerEvent = awaitPointerEventScope2.awaitPointerEvent(PointerEventPass.Initial, (Continuation) anonymousClass1);
                                if (awaitPointerEvent == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                Object obj4 = coroutine_suspended;
                                anonymousClass12 = anonymousClass1;
                                obj = awaitPointerEvent;
                                awaitPointerEventScope4 = awaitPointerEventScope2;
                                pointerInputChange5 = pointerInputChange2;
                                pointerInputChange6 = pointerInputChange;
                                obj2 = obj4;
                                PointerEvent pointerEvent2 = (PointerEvent) obj;
                                List<PointerInputChange> changes2 = pointerEvent2.getChanges();
                                int size2 = changes2.size();
                                int i22 = 0;
                                while (true) {
                                    if (i22 >= size2) {
                                    }
                                    i22++;
                                }
                                if (z) {
                                }
                                if (pointerInputChange == null) {
                                    anonymousClass1.$state.m1423setUpDownDifferencek4lQ0M$foundation_release(Offset.m4597minusMKHz9U(pointerInputChange.getPosition(), pointerInputChange2.getPosition()));
                                    return Unit.INSTANCE;
                                }
                            }
                        }
                        this.$state.m1423setUpDownDifferencek4lQ0M$foundation_release(Offset.INSTANCE.m4609getZeroF1C5BW0());
                        awaitPointerEventScope2 = awaitPointerEventScope;
                        pointerInputChange = null;
                        pointerInputChange2 = (PointerInputChange) obj;
                        anonymousClass1 = this;
                        if (pointerInputChange == null) {
                        }
                    }
                }

                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        if (ForEachGestureKt.awaitEachGesture(this.$this_pointerInput, new AnonymousClass1(this.$state, null), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // androidx.compose.p002ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                Object coroutineScope = CoroutineScopeKt.coroutineScope(new C03621(pointerInputScope, PagerState.this, null), continuation);
                return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
            }
        }));
    }
}
