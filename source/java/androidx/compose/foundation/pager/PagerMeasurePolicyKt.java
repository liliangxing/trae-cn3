package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy;
import androidx.compose.p002ui.Alignment;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: PagerMeasurePolicy.kt */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0087\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003H\u0001¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"rememberPagerMeasurePolicy", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasurePolicy;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "state", "Landroidx/compose/foundation/pager/PagerState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "beyondViewportPageCount", "", "pageSpacing", "Landroidx/compose/ui/unit/Dp;", "pageSize", "Landroidx/compose/foundation/pager/PageSize;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "pageCount", "rememberPagerMeasurePolicy-8u0NR3k", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/Orientation;IFLandroidx/compose/foundation/pager/PageSize;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasurePolicy;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class PagerMeasurePolicyKt {
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ea, code lost:
    
        if (r34.changed(r28) == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0103, code lost:
    
        if (r34.changed(r31) == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x011c, code lost:
    
        if (r34.changed(r33) == false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0139, code lost:
    
        if (r34.changed(r26) == false) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0030, code lost:
    
        if (r34.changed(r22) != false) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00ed  */
    /* renamed from: rememberPagerMeasurePolicy-8u0NR3k, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final LazyLayoutMeasurePolicy m1414rememberPagerMeasurePolicy8u0NR3k(Function0<PagerLazyLayoutItemProvider> function0, PagerState pagerState, PaddingValues paddingValues, boolean z, Orientation orientation, int i, float f, PageSize pageSize, Alignment.Horizontal horizontal, Alignment.Vertical vertical, SnapPosition snapPosition, CoroutineScope coroutineScope, Function0<Integer> function02, Composer composer, int i2, int i3) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean changed;
        PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1 rememberedValue;
        ComposerKt.sourceInformationMarkerStart(composer, -1294131537, "C(rememberPagerMeasurePolicy)N(itemProviderLambda,state,contentPadding,reverseLayout,orientation,beyondViewportPageCount,pageSpacing:c#ui.unit.Dp,pageSize,horizontalAlignment,verticalAlignment,snapPosition,coroutineScope,pageCount)58@2351L7519:PagerMeasurePolicy.kt#g6yjnt");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1294131537, i2, i3, "androidx.compose.foundation.pager.rememberPagerMeasurePolicy (PagerMeasurePolicy.kt:58)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1880133646, "CC(remember):PagerMeasurePolicy.kt#9igjgp");
        if (((i2 & 112) ^ 48) <= 32) {
        }
        if ((i2 & 48) != 32) {
            z2 = false;
            boolean z7 = z2 | ((((i2 & 896) ^ 384) <= 256 && composer.changed(paddingValues)) || (i2 & 384) == 256) | ((((i2 & 7168) ^ 3072) <= 2048 && composer.changed(z)) || (i2 & 3072) == 2048) | ((((57344 & i2) ^ 24576) <= 16384 && composer.changed(orientation.ordinal())) || (i2 & 24576) == 16384) | ((((234881024 & i2) ^ 100663296) <= 67108864 && composer.changed(horizontal)) || (i2 & 100663296) == 67108864) | ((((1879048192 & i2) ^ 805306368) <= 536870912 && composer.changed(vertical)) || (i2 & 805306368) == 536870912) | ((((3670016 & i2) ^ 1572864) <= 1048576 && composer.changed(f)) || (i2 & 1572864) == 1048576);
            if (((29360128 & i2) ^ 12582912) <= 8388608) {
            }
            if ((12582912 & i2) != 8388608) {
                z3 = false;
                boolean z8 = z7 | z3;
                if (((i3 & 14) ^ 6) <= 4) {
                }
                if ((i3 & 6) != 4) {
                    z4 = false;
                    boolean z9 = z8 | z4;
                    if (((i3 & 896) ^ 384) <= 256) {
                    }
                    if ((i3 & 384) != 256) {
                        z5 = false;
                        boolean z10 = z5 | z9;
                        if (((458752 & i2) ^ 196608) <= 131072) {
                        }
                        if ((i2 & 196608) != 131072) {
                            z6 = false;
                            changed = z10 | z6 | composer.changed(coroutineScope);
                            rememberedValue = composer.rememberedValue();
                            if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = new PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1(pagerState, orientation, paddingValues, z, f, pageSize, function0, function02, vertical, horizontal, i, snapPosition, coroutineScope);
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
                        z6 = true;
                        changed = z10 | z6 | composer.changed(coroutineScope);
                        rememberedValue = composer.rememberedValue();
                        if (!changed) {
                        }
                        rememberedValue = new PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1(pagerState, orientation, paddingValues, z, f, pageSize, function0, function02, vertical, horizontal, i, snapPosition, coroutineScope);
                        composer.updateRememberedValue(rememberedValue);
                        LazyLayoutMeasurePolicy lazyLayoutMeasurePolicy2 = (LazyLayoutMeasurePolicy) rememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        return lazyLayoutMeasurePolicy2;
                    }
                    z5 = true;
                    boolean z102 = z5 | z9;
                    if (((458752 & i2) ^ 196608) <= 131072) {
                    }
                    if ((i2 & 196608) != 131072) {
                    }
                    z6 = true;
                    changed = z102 | z6 | composer.changed(coroutineScope);
                    rememberedValue = composer.rememberedValue();
                    if (!changed) {
                    }
                    rememberedValue = new PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1(pagerState, orientation, paddingValues, z, f, pageSize, function0, function02, vertical, horizontal, i, snapPosition, coroutineScope);
                    composer.updateRememberedValue(rememberedValue);
                    LazyLayoutMeasurePolicy lazyLayoutMeasurePolicy22 = (LazyLayoutMeasurePolicy) rememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    return lazyLayoutMeasurePolicy22;
                }
                z4 = true;
                boolean z92 = z8 | z4;
                if (((i3 & 896) ^ 384) <= 256) {
                }
                if ((i3 & 384) != 256) {
                }
                z5 = true;
                boolean z1022 = z5 | z92;
                if (((458752 & i2) ^ 196608) <= 131072) {
                }
                if ((i2 & 196608) != 131072) {
                }
                z6 = true;
                changed = z1022 | z6 | composer.changed(coroutineScope);
                rememberedValue = composer.rememberedValue();
                if (!changed) {
                }
                rememberedValue = new PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1(pagerState, orientation, paddingValues, z, f, pageSize, function0, function02, vertical, horizontal, i, snapPosition, coroutineScope);
                composer.updateRememberedValue(rememberedValue);
                LazyLayoutMeasurePolicy lazyLayoutMeasurePolicy222 = (LazyLayoutMeasurePolicy) rememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer);
                if (ComposerKt.isTraceInProgress()) {
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                return lazyLayoutMeasurePolicy222;
            }
            z3 = true;
            boolean z82 = z7 | z3;
            if (((i3 & 14) ^ 6) <= 4) {
            }
            if ((i3 & 6) != 4) {
            }
            z4 = true;
            boolean z922 = z82 | z4;
            if (((i3 & 896) ^ 384) <= 256) {
            }
            if ((i3 & 384) != 256) {
            }
            z5 = true;
            boolean z10222 = z5 | z922;
            if (((458752 & i2) ^ 196608) <= 131072) {
            }
            if ((i2 & 196608) != 131072) {
            }
            z6 = true;
            changed = z10222 | z6 | composer.changed(coroutineScope);
            rememberedValue = composer.rememberedValue();
            if (!changed) {
            }
            rememberedValue = new PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1(pagerState, orientation, paddingValues, z, f, pageSize, function0, function02, vertical, horizontal, i, snapPosition, coroutineScope);
            composer.updateRememberedValue(rememberedValue);
            LazyLayoutMeasurePolicy lazyLayoutMeasurePolicy2222 = (LazyLayoutMeasurePolicy) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            return lazyLayoutMeasurePolicy2222;
        }
        z2 = true;
        boolean z72 = z2 | ((((i2 & 896) ^ 384) <= 256 && composer.changed(paddingValues)) || (i2 & 384) == 256) | ((((i2 & 7168) ^ 3072) <= 2048 && composer.changed(z)) || (i2 & 3072) == 2048) | ((((57344 & i2) ^ 24576) <= 16384 && composer.changed(orientation.ordinal())) || (i2 & 24576) == 16384) | ((((234881024 & i2) ^ 100663296) <= 67108864 && composer.changed(horizontal)) || (i2 & 100663296) == 67108864) | ((((1879048192 & i2) ^ 805306368) <= 536870912 && composer.changed(vertical)) || (i2 & 805306368) == 536870912) | ((((3670016 & i2) ^ 1572864) <= 1048576 && composer.changed(f)) || (i2 & 1572864) == 1048576);
        if (((29360128 & i2) ^ 12582912) <= 8388608) {
        }
        if ((12582912 & i2) != 8388608) {
        }
        z3 = true;
        boolean z822 = z72 | z3;
        if (((i3 & 14) ^ 6) <= 4) {
        }
        if ((i3 & 6) != 4) {
        }
        z4 = true;
        boolean z9222 = z822 | z4;
        if (((i3 & 896) ^ 384) <= 256) {
        }
        if ((i3 & 384) != 256) {
        }
        z5 = true;
        boolean z102222 = z5 | z9222;
        if (((458752 & i2) ^ 196608) <= 131072) {
        }
        if ((i2 & 196608) != 131072) {
        }
        z6 = true;
        changed = z102222 | z6 | composer.changed(coroutineScope);
        rememberedValue = composer.rememberedValue();
        if (!changed) {
        }
        rememberedValue = new PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1(pagerState, orientation, paddingValues, z, f, pageSize, function0, function02, vertical, horizontal, i, snapPosition, coroutineScope);
        composer.updateRememberedValue(rememberedValue);
        LazyLayoutMeasurePolicy lazyLayoutMeasurePolicy22222 = (LazyLayoutMeasurePolicy) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return lazyLayoutMeasurePolicy22222;
    }
}
