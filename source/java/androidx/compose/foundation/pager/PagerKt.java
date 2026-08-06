package androidx.compose.foundation.pager;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.OverscrollKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.pager.PageSize;
import androidx.compose.p002ui.Alignment;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: Pager.kt */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u001aÕ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132%\b\u0002\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u001c21\u0010\u001d\u001a-\u0012\u0004\u0012\u00020\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b!¢\u0006\u0002\b\"H\u0007¢\u0006\u0004\b#\u0010$\u001aë\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010%\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132%\b\u0002\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010&\u001a\u00020'2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)21\u0010\u001d\u001a-\u0012\u0004\u0012\u00020\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b!¢\u0006\u0002\b\"H\u0007¢\u0006\u0004\b*\u0010+\u001aß\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010%\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132%\b\u0002\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010&\u001a\u00020'21\u0010\u001d\u001a-\u0012\u0004\u0012\u00020\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b!¢\u0006\u0002\b\"H\u0007¢\u0006\u0004\b,\u0010-\u001aë\u0001\u0010.\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010%\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132%\b\u0002\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010&\u001a\u00020'2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)21\u0010\u001d\u001a-\u0012\u0004\u0012\u00020\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b!¢\u0006\u0002\b\"H\u0007¢\u0006\u0004\b1\u00102\u001aß\u0001\u0010.\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010%\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132%\b\u0002\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010&\u001a\u00020'21\u0010\u001d\u001a-\u0012\u0004\u0012\u00020\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b!¢\u0006\u0002\b\"H\u0007¢\u0006\u0004\b3\u00104\u001aL\u00105\u001a\u00020\u000b*\u00020'2\u0006\u00106\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u000b2\u0006\u00109\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u000bH\u0000\u001a,\u0010>\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\u00132\u0006\u0010@\u001a\u00020A2\u0006\u0010\u0012\u001a\u00020\u0013H\u0000\u001a\u0017\u0010B\u001a\u00020\u00012\f\u0010C\u001a\b\u0012\u0004\u0012\u00020E0DH\u0082\b¨\u0006F"}, d2 = {"HorizontalPager", "", "state", "Landroidx/compose/foundation/pager/PagerState;", "modifier", "Landroidx/compose/ui/Modifier;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "pageSize", "Landroidx/compose/foundation/pager/PageSize;", "beyondBoundsPageCount", "", "pageSpacing", "Landroidx/compose/ui/unit/Dp;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "flingBehavior", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "userScrollEnabled", "", "reverseLayout", "key", "Lkotlin/Function1;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "index", "", "pageNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "pageContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/pager/PagerScope;", "page", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "HorizontalPager-xYaah8o", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/pager/PageSize;IFLandroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/TargetedFlingBehavior;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "beyondViewportPageCount", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "HorizontalPager--8jOkeI", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/pager/PageSize;IFLandroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/TargetedFlingBehavior;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Landroidx/compose/foundation/OverscrollEffect;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "HorizontalPager-oI3XNZo", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/pager/PageSize;IFLandroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/TargetedFlingBehavior;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "VerticalPager", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "VerticalPager--8jOkeI", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/pager/PageSize;IFLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/TargetedFlingBehavior;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Landroidx/compose/foundation/OverscrollEffect;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "VerticalPager-oI3XNZo", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/pager/PageSize;IFLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/TargetedFlingBehavior;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "currentPageOffset", "layoutSize", "spaceBetweenPages", "beforeContentPadding", "afterContentPadding", "currentPage", "currentPageOffsetFraction", "", "pageCount", "pagerSemantics", "isVertical", "scope", "Lkotlinx/coroutines/CoroutineScope;", "debugLog", "generateMsg", "Lkotlin/Function0;", "", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class PagerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HorizontalPager__8jOkeI$lambda$1(PagerState pagerState, Modifier modifier, PaddingValues paddingValues, PageSize pageSize, int i, float f, Alignment.Vertical vertical, TargetedFlingBehavior targetedFlingBehavior, boolean z, boolean z2, Function1 function1, NestedScrollConnection nestedScrollConnection, SnapPosition snapPosition, OverscrollEffect overscrollEffect, Function4 function4, int i2, int i3, int i4, Composer composer, int i5) {
        m1403HorizontalPager8jOkeI(pagerState, modifier, paddingValues, pageSize, i, f, vertical, targetedFlingBehavior, z, z2, function1, nestedScrollConnection, snapPosition, overscrollEffect, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HorizontalPager_oI3XNZo$lambda$2(PagerState pagerState, Modifier modifier, PaddingValues paddingValues, PageSize pageSize, int i, float f, Alignment.Vertical vertical, TargetedFlingBehavior targetedFlingBehavior, boolean z, boolean z2, Function1 function1, NestedScrollConnection nestedScrollConnection, SnapPosition snapPosition, Function4 function4, int i2, int i3, int i4, Composer composer, int i5) {
        m1404HorizontalPageroI3XNZo(pagerState, modifier, paddingValues, pageSize, i, f, vertical, targetedFlingBehavior, z, z2, function1, nestedScrollConnection, snapPosition, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HorizontalPager_xYaah8o$lambda$0(PagerState pagerState, Modifier modifier, PaddingValues paddingValues, PageSize pageSize, int i, float f, Alignment.Vertical vertical, TargetedFlingBehavior targetedFlingBehavior, boolean z, boolean z2, Function1 function1, NestedScrollConnection nestedScrollConnection, Function4 function4, int i2, int i3, int i4, Composer composer, int i5) {
        m1405HorizontalPagerxYaah8o(pagerState, modifier, paddingValues, pageSize, i, f, vertical, targetedFlingBehavior, z, z2, function1, nestedScrollConnection, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VerticalPager__8jOkeI$lambda$3(PagerState pagerState, Modifier modifier, PaddingValues paddingValues, PageSize pageSize, int i, float f, Alignment.Horizontal horizontal, TargetedFlingBehavior targetedFlingBehavior, boolean z, boolean z2, Function1 function1, NestedScrollConnection nestedScrollConnection, SnapPosition snapPosition, OverscrollEffect overscrollEffect, Function4 function4, int i2, int i3, int i4, Composer composer, int i5) {
        m1406VerticalPager8jOkeI(pagerState, modifier, paddingValues, pageSize, i, f, horizontal, targetedFlingBehavior, z, z2, function1, nestedScrollConnection, snapPosition, overscrollEffect, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VerticalPager_oI3XNZo$lambda$4(PagerState pagerState, Modifier modifier, PaddingValues paddingValues, PageSize pageSize, int i, float f, Alignment.Horizontal horizontal, TargetedFlingBehavior targetedFlingBehavior, boolean z, boolean z2, Function1 function1, NestedScrollConnection nestedScrollConnection, SnapPosition snapPosition, Function4 function4, int i2, int i3, int i4, Composer composer, int i5) {
        m1407VerticalPageroI3XNZo(pagerState, modifier, paddingValues, pageSize, i, f, horizontal, targetedFlingBehavior, z, z2, function1, nestedScrollConnection, snapPosition, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    private static final void debugLog(Function0<String> function0) {
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0338  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:85:? A[RETURN, SYNTHETIC] */
    /* renamed from: HorizontalPager-xYaah8o, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1405HorizontalPagerxYaah8o(final PagerState pagerState, Modifier modifier, PaddingValues paddingValues, PageSize pageSize, int i, float f, Alignment.Vertical vertical, TargetedFlingBehavior targetedFlingBehavior, boolean z, boolean z2, Function1<? super Integer, ? extends Object> function1, NestedScrollConnection nestedScrollConnection, final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        Modifier modifier2;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        float f2;
        int i11;
        TargetedFlingBehavior targetedFlingBehavior2;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        Composer composer2;
        final PaddingValues paddingValues2;
        final Alignment.Vertical vertical2;
        final boolean z3;
        final boolean z4;
        final Function1<? super Integer, ? extends Object> function12;
        final Modifier modifier3;
        final TargetedFlingBehavior targetedFlingBehavior3;
        final NestedScrollConnection nestedScrollConnection2;
        final float f3;
        final int i20;
        final PageSize pageSize2;
        ScopeUpdateScope endRestartGroup;
        Modifier modifier4;
        PaddingValues m1057PaddingValues0680j_4;
        Alignment.Vertical centerVertically;
        int i21;
        int i22;
        boolean z5;
        TargetedFlingBehavior targetedFlingBehavior4;
        NestedScrollConnection nestedScrollConnection3;
        TargetedFlingBehavior targetedFlingBehavior5;
        PageSize pageSize3;
        boolean z6;
        float f4;
        int i23;
        Function1<? super Integer, ? extends Object> function13;
        int i24;
        int i25;
        int i26;
        Composer startRestartGroup = composer.startRestartGroup(-1054685464);
        ComposerKt.sourceInformation(startRestartGroup, "C(HorizontalPager)N(state,modifier,contentPadding,pageSize,beyondBoundsPageCount,pageSpacing:c#ui.unit.Dp,verticalAlignment,flingBehavior,userScrollEnabled,reverseLayout,key,pageNestedScrollConnection,pageContent)77@3516L527:Pager.kt#g6yjnt");
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i5 = (startRestartGroup.changed(pagerState) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        int i27 = i4 & 2;
        if (i27 != 0) {
            i5 |= 48;
        } else if ((i2 & 48) == 0) {
            modifier2 = modifier;
            i5 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i6 = i4 & 4;
            if (i6 == 0) {
                i5 |= 384;
            } else if ((i2 & 384) == 0) {
                i5 |= startRestartGroup.changed(paddingValues) ? Fields.RotationX : Fields.SpotShadowColor;
                i7 = i4 & 8;
                if (i7 != 0) {
                    i5 |= 3072;
                } else if ((i2 & 3072) == 0) {
                    i5 |= startRestartGroup.changed(pageSize) ? Fields.CameraDistance : Fields.RotationZ;
                    i8 = i4 & 16;
                    if (i8 == 0) {
                        i5 |= 24576;
                    } else if ((i2 & 24576) == 0) {
                        i9 = i;
                        i5 |= startRestartGroup.changed(i9) ? Fields.Clip : Fields.Shape;
                        i10 = i4 & 32;
                        if (i10 != 0) {
                            i5 |= 196608;
                            f2 = f;
                        } else {
                            f2 = f;
                            if ((i2 & 196608) == 0) {
                                i5 |= startRestartGroup.changed(f2) ? Fields.RenderEffect : 65536;
                            }
                        }
                        i11 = i4 & 64;
                        if (i11 != 0) {
                            i5 |= 1572864;
                        } else if ((i2 & 1572864) == 0) {
                            i5 |= startRestartGroup.changed(vertical) ? 1048576 : Fields.BlendMode;
                        }
                        if ((i2 & 12582912) == 0) {
                            if ((i4 & Fields.SpotShadowColor) == 0) {
                                targetedFlingBehavior2 = targetedFlingBehavior;
                                if (startRestartGroup.changed(targetedFlingBehavior2)) {
                                    i26 = 8388608;
                                    i5 |= i26;
                                }
                            } else {
                                targetedFlingBehavior2 = targetedFlingBehavior;
                            }
                            i26 = 4194304;
                            i5 |= i26;
                        } else {
                            targetedFlingBehavior2 = targetedFlingBehavior;
                        }
                        i12 = i4 & Fields.RotationX;
                        if (i12 != 0) {
                            i5 |= 100663296;
                        } else if ((i2 & 100663296) == 0) {
                            i5 |= startRestartGroup.changed(z) ? 67108864 : 33554432;
                        }
                        i13 = i4 & Fields.RotationY;
                        if (i13 != 0) {
                            i15 = i5 | 805306368;
                            i14 = i13;
                        } else {
                            if ((i2 & 805306368) == 0) {
                                i14 = i13;
                                i5 |= startRestartGroup.changed(z2) ? 536870912 : 268435456;
                            } else {
                                i14 = i13;
                            }
                            i15 = i5;
                        }
                        i16 = i4 & Fields.RotationZ;
                        if (i16 != 0) {
                            i17 = i3 | 6;
                        } else if ((i3 & 6) == 0) {
                            i17 = i3 | (startRestartGroup.changedInstance(function1) ? 4 : 2);
                        } else {
                            i17 = i3;
                        }
                        if ((i3 & 48) == 0) {
                            i18 = i16;
                            if ((i4 & Fields.CameraDistance) == 0 && startRestartGroup.changedInstance(nestedScrollConnection)) {
                                i25 = 32;
                                i17 |= i25;
                            }
                            i25 = 16;
                            i17 |= i25;
                        } else {
                            i18 = i16;
                        }
                        i19 = i17;
                        if ((i4 & Fields.TransformOrigin) != 0) {
                            i19 |= 384;
                        } else if ((i3 & 384) == 0) {
                            i19 |= startRestartGroup.changedInstance(function4) ? Fields.RotationX : Fields.SpotShadowColor;
                            if (!startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i19 & 147) != 146, i15 & 1)) {
                                startRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(startRestartGroup, "69@3164L28,74@3388L57");
                                if ((i2 & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i4 & Fields.SpotShadowColor) != 0) {
                                        i15 &= -29360129;
                                    }
                                    if ((i4 & Fields.CameraDistance) != 0) {
                                        i19 &= -113;
                                    }
                                    m1057PaddingValues0680j_4 = paddingValues;
                                    pageSize3 = pageSize;
                                    centerVertically = vertical;
                                    z6 = z;
                                    z5 = z2;
                                    nestedScrollConnection3 = nestedScrollConnection;
                                    i23 = i9;
                                    f4 = f2;
                                    modifier4 = modifier2;
                                    targetedFlingBehavior5 = targetedFlingBehavior2;
                                    i24 = i15;
                                    function13 = function1;
                                } else {
                                    modifier4 = i27 != 0 ? Modifier.INSTANCE : modifier2;
                                    m1057PaddingValues0680j_4 = i6 != 0 ? PaddingKt.m1057PaddingValues0680j_4(Dp.constructor-impl(0)) : paddingValues;
                                    PageSize pageSize4 = i7 != 0 ? PageSize.Fill.INSTANCE : pageSize;
                                    int i28 = i8 != 0 ? 0 : i9;
                                    float f5 = i10 != 0 ? Dp.constructor-impl(0) : f2;
                                    centerVertically = i11 != 0 ? Alignment.INSTANCE.getCenterVertically() : vertical;
                                    if ((i4 & Fields.SpotShadowColor) != 0) {
                                        i21 = i19;
                                        i22 = i18;
                                        z5 = false;
                                        targetedFlingBehavior4 = PagerDefaults.INSTANCE.flingBehavior(pagerState, null, null, null, 0.0f, startRestartGroup, (i15 & 14) | 196608, 30);
                                        i15 &= -29360129;
                                    } else {
                                        i21 = i19;
                                        i22 = i18;
                                        z5 = false;
                                        targetedFlingBehavior4 = targetedFlingBehavior2;
                                    }
                                    boolean z7 = i12 == 0 ? z : true;
                                    if (i14 == 0) {
                                        z5 = z2;
                                    }
                                    Function1<? super Integer, ? extends Object> function14 = i22 != 0 ? null : function1;
                                    if ((i4 & Fields.CameraDistance) != 0) {
                                        targetedFlingBehavior5 = targetedFlingBehavior4;
                                        nestedScrollConnection3 = PagerDefaults.INSTANCE.pageNestedScrollConnection(pagerState, Orientation.Horizontal, startRestartGroup, (i15 & 14) | 432);
                                        i19 = i21 & (-113);
                                        pageSize3 = pageSize4;
                                        z6 = z7;
                                    } else {
                                        nestedScrollConnection3 = nestedScrollConnection;
                                        targetedFlingBehavior5 = targetedFlingBehavior4;
                                        pageSize3 = pageSize4;
                                        z6 = z7;
                                        i19 = i21;
                                    }
                                    f4 = f5;
                                    i23 = i28;
                                    int i29 = i15;
                                    function13 = function14;
                                    i24 = i29;
                                }
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1054685464, i24, i19, "androidx.compose.foundation.pager.HorizontalPager (Pager.kt:76)");
                                }
                                composer2 = startRestartGroup;
                                m1403HorizontalPager8jOkeI(pagerState, modifier4, m1057PaddingValues0680j_4, pageSize3, i23, f4, centerVertically, targetedFlingBehavior5, z6, z5, function13, nestedScrollConnection3, null, null, function4, composer2, (i24 & 14) | (i24 & 112) | (i24 & 896) | (i24 & 7168) | (57344 & i24) | (458752 & i24) | (3670016 & i24) | (29360128 & i24) | (234881024 & i24) | (i24 & 1879048192), (i19 & 14) | (i19 & 112) | ((i19 << 6) & 57344), 12288);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                pageSize2 = pageSize3;
                                i20 = i23;
                                f3 = f4;
                                modifier3 = modifier4;
                                vertical2 = centerVertically;
                                paddingValues2 = m1057PaddingValues0680j_4;
                                targetedFlingBehavior3 = targetedFlingBehavior5;
                                z3 = z6;
                                function12 = function13;
                                z4 = z5;
                                nestedScrollConnection2 = nestedScrollConnection3;
                            } else {
                                composer2 = startRestartGroup;
                                composer2.skipToGroupEnd();
                                paddingValues2 = paddingValues;
                                vertical2 = vertical;
                                z3 = z;
                                z4 = z2;
                                function12 = function1;
                                modifier3 = modifier2;
                                targetedFlingBehavior3 = targetedFlingBehavior2;
                                nestedScrollConnection2 = nestedScrollConnection;
                                f3 = f2;
                                i20 = i9;
                                pageSize2 = pageSize;
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.pager.PagerKt$$ExternalSyntheticLambda2
                                    public final Object invoke(Object obj, Object obj2) {
                                        Unit HorizontalPager_xYaah8o$lambda$0;
                                        HorizontalPager_xYaah8o$lambda$0 = PagerKt.HorizontalPager_xYaah8o$lambda$0(PagerState.this, modifier3, paddingValues2, pageSize2, i20, f3, vertical2, targetedFlingBehavior3, z3, z4, function12, nestedScrollConnection2, function4, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                        return HorizontalPager_xYaah8o$lambda$0;
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        if (!startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i19 & 147) != 146, i15 & 1)) {
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i9 = i;
                    i10 = i4 & 32;
                    if (i10 != 0) {
                    }
                    i11 = i4 & 64;
                    if (i11 != 0) {
                    }
                    if ((i2 & 12582912) == 0) {
                    }
                    i12 = i4 & Fields.RotationX;
                    if (i12 != 0) {
                    }
                    i13 = i4 & Fields.RotationY;
                    if (i13 != 0) {
                    }
                    i16 = i4 & Fields.RotationZ;
                    if (i16 != 0) {
                    }
                    if ((i3 & 48) == 0) {
                    }
                    i19 = i17;
                    if ((i4 & Fields.TransformOrigin) != 0) {
                    }
                    if (!startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i19 & 147) != 146, i15 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                i8 = i4 & 16;
                if (i8 == 0) {
                }
                i9 = i;
                i10 = i4 & 32;
                if (i10 != 0) {
                }
                i11 = i4 & 64;
                if (i11 != 0) {
                }
                if ((i2 & 12582912) == 0) {
                }
                i12 = i4 & Fields.RotationX;
                if (i12 != 0) {
                }
                i13 = i4 & Fields.RotationY;
                if (i13 != 0) {
                }
                i16 = i4 & Fields.RotationZ;
                if (i16 != 0) {
                }
                if ((i3 & 48) == 0) {
                }
                i19 = i17;
                if ((i4 & Fields.TransformOrigin) != 0) {
                }
                if (!startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i19 & 147) != 146, i15 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i7 = i4 & 8;
            if (i7 != 0) {
            }
            i8 = i4 & 16;
            if (i8 == 0) {
            }
            i9 = i;
            i10 = i4 & 32;
            if (i10 != 0) {
            }
            i11 = i4 & 64;
            if (i11 != 0) {
            }
            if ((i2 & 12582912) == 0) {
            }
            i12 = i4 & Fields.RotationX;
            if (i12 != 0) {
            }
            i13 = i4 & Fields.RotationY;
            if (i13 != 0) {
            }
            i16 = i4 & Fields.RotationZ;
            if (i16 != 0) {
            }
            if ((i3 & 48) == 0) {
            }
            i19 = i17;
            if ((i4 & Fields.TransformOrigin) != 0) {
            }
            if (!startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i19 & 147) != 146, i15 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i6 = i4 & 4;
        if (i6 == 0) {
        }
        i7 = i4 & 8;
        if (i7 != 0) {
        }
        i8 = i4 & 16;
        if (i8 == 0) {
        }
        i9 = i;
        i10 = i4 & 32;
        if (i10 != 0) {
        }
        i11 = i4 & 64;
        if (i11 != 0) {
        }
        if ((i2 & 12582912) == 0) {
        }
        i12 = i4 & Fields.RotationX;
        if (i12 != 0) {
        }
        i13 = i4 & Fields.RotationY;
        if (i13 != 0) {
        }
        i16 = i4 & Fields.RotationZ;
        if (i16 != 0) {
        }
        if ((i3 & 48) == 0) {
        }
        i19 = i17;
        if ((i4 & Fields.TransformOrigin) != 0) {
        }
        if (!startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i19 & 147) != 146, i15 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x03d3  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x03f4  */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4, types: [int] */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* renamed from: HorizontalPager--8jOkeI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1403HorizontalPager8jOkeI(final PagerState pagerState, Modifier modifier, PaddingValues paddingValues, PageSize pageSize, int i, float f, Alignment.Vertical vertical, TargetedFlingBehavior targetedFlingBehavior, boolean z, boolean z2, Function1<? super Integer, ? extends Object> function1, NestedScrollConnection nestedScrollConnection, SnapPosition snapPosition, OverscrollEffect overscrollEffect, final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        Modifier modifier2;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        float f2;
        int i11;
        TargetedFlingBehavior targetedFlingBehavior2;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        Composer composer2;
        final PaddingValues paddingValues2;
        final Alignment.Vertical vertical2;
        final boolean z3;
        final boolean z4;
        final Function1<? super Integer, ? extends Object> function12;
        final NestedScrollConnection nestedScrollConnection2;
        final OverscrollEffect overscrollEffect2;
        final Modifier modifier3;
        final TargetedFlingBehavior targetedFlingBehavior3;
        final SnapPosition snapPosition2;
        final float f3;
        final int i21;
        final PageSize pageSize2;
        ScopeUpdateScope endRestartGroup;
        int i22;
        ?? r12;
        int i23;
        int i24;
        int i25;
        NestedScrollConnection nestedScrollConnection3;
        int i26;
        OverscrollEffect overscrollEffect3;
        boolean z5;
        Function1<? super Integer, ? extends Object> function13;
        SnapPosition snapPosition3;
        TargetedFlingBehavior targetedFlingBehavior4;
        boolean z6;
        int i27;
        float f4;
        Alignment.Vertical vertical3;
        int i28;
        NestedScrollConnection nestedScrollConnection4;
        PageSize pageSize3;
        PaddingValues paddingValues3;
        Modifier modifier4;
        int i29;
        int i30;
        Composer startRestartGroup = composer.startRestartGroup(1860873769);
        ComposerKt.sourceInformation(startRestartGroup, "C(HorizontalPager)N(state,modifier,contentPadding,pageSize,beyondViewportPageCount,pageSpacing:c#ui.unit.Dp,verticalAlignment,flingBehavior,userScrollEnabled,reverseLayout,key,pageNestedScrollConnection,snapPosition,overscrollEffect,pageContent)164@8809L707:Pager.kt#g6yjnt");
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i5 = (startRestartGroup.changed(pagerState) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        int i31 = i4 & 2;
        if (i31 != 0) {
            i5 |= 48;
        } else if ((i2 & 48) == 0) {
            modifier2 = modifier;
            i5 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i6 = i4 & 4;
            if (i6 == 0) {
                i5 |= 384;
            } else if ((i2 & 384) == 0) {
                i5 |= startRestartGroup.changed(paddingValues) ? Fields.RotationX : Fields.SpotShadowColor;
                i7 = i4 & 8;
                int i32 = Fields.RotationZ;
                if (i7 != 0) {
                    i5 |= 3072;
                } else if ((i2 & 3072) == 0) {
                    i5 |= startRestartGroup.changed(pageSize) ? 2048 : 1024;
                    i8 = i4 & 16;
                    int i33 = Fields.Clip;
                    if (i8 == 0) {
                        i5 |= 24576;
                    } else if ((i2 & 24576) == 0) {
                        i9 = i;
                        i5 |= startRestartGroup.changed(i9) ? 16384 : 8192;
                        i10 = i4 & 32;
                        if (i10 != 0) {
                            i5 |= 196608;
                            f2 = f;
                        } else {
                            f2 = f;
                            if ((i2 & 196608) == 0) {
                                i5 |= startRestartGroup.changed(f2) ? Fields.RenderEffect : 65536;
                            }
                        }
                        i11 = i4 & 64;
                        if (i11 != 0) {
                            i5 |= 1572864;
                        } else if ((i2 & 1572864) == 0) {
                            i5 |= startRestartGroup.changed(vertical) ? 1048576 : Fields.BlendMode;
                        }
                        if ((i2 & 12582912) == 0) {
                            if ((i4 & Fields.SpotShadowColor) == 0) {
                                targetedFlingBehavior2 = targetedFlingBehavior;
                                if (startRestartGroup.changed(targetedFlingBehavior2)) {
                                    i30 = 8388608;
                                    i5 |= i30;
                                }
                            } else {
                                targetedFlingBehavior2 = targetedFlingBehavior;
                            }
                            i30 = 4194304;
                            i5 |= i30;
                        } else {
                            targetedFlingBehavior2 = targetedFlingBehavior;
                        }
                        i12 = i4 & Fields.RotationX;
                        if (i12 != 0) {
                            i5 |= 100663296;
                        } else if ((i2 & 100663296) == 0) {
                            i5 |= startRestartGroup.changed(z) ? 67108864 : 33554432;
                        }
                        i13 = i4 & Fields.RotationY;
                        if (i13 != 0) {
                            i15 = i5 | 805306368;
                            i14 = i13;
                        } else {
                            if ((i2 & 805306368) == 0) {
                                i14 = i13;
                                i5 |= startRestartGroup.changed(z2) ? 536870912 : 268435456;
                            } else {
                                i14 = i13;
                            }
                            i15 = i5;
                        }
                        i16 = i4 & Fields.RotationZ;
                        if (i16 != 0) {
                            i17 = i3 | 6;
                        } else if ((i3 & 6) == 0) {
                            i17 = i3 | (startRestartGroup.changedInstance(function1) ? 4 : 2);
                        } else {
                            i17 = i3;
                        }
                        if ((i3 & 48) == 0) {
                            i18 = i16;
                            if ((i4 & Fields.CameraDistance) == 0 && startRestartGroup.changedInstance(nestedScrollConnection)) {
                                i29 = 32;
                                i17 |= i29;
                            }
                            i29 = 16;
                            i17 |= i29;
                        } else {
                            i18 = i16;
                        }
                        i19 = i17;
                        i20 = i4 & Fields.TransformOrigin;
                        if (i20 != 0) {
                            i19 |= 384;
                        } else if ((i3 & 384) == 0) {
                            i19 |= startRestartGroup.changed(snapPosition) ? Fields.RotationX : Fields.SpotShadowColor;
                            if ((i3 & 3072) == 0) {
                                if ((i4 & Fields.Shape) == 0 && startRestartGroup.changed(overscrollEffect)) {
                                    i32 = 2048;
                                }
                                i19 |= i32;
                            }
                            if ((i4 & Fields.Clip) == 0) {
                                i19 |= 24576;
                            } else if ((i3 & 24576) == 0) {
                                if (!startRestartGroup.changedInstance(function4)) {
                                    i33 = 8192;
                                }
                                i19 |= i33;
                                if (startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i19 & 9363) != 9362, i15 & 1)) {
                                    startRestartGroup.startDefaults();
                                    ComposerKt.sourceInformation(startRestartGroup, "154@8334L28,159@8558L57,161@8712L26");
                                    if ((i2 & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                        startRestartGroup.skipToGroupEnd();
                                        if ((i4 & Fields.SpotShadowColor) != 0) {
                                            i15 &= -29360129;
                                        }
                                        if ((i4 & Fields.CameraDistance) != 0) {
                                            i19 &= -113;
                                        }
                                        if ((i4 & Fields.Shape) != 0) {
                                            i19 &= -7169;
                                        }
                                        paddingValues3 = paddingValues;
                                        pageSize3 = pageSize;
                                        vertical3 = vertical;
                                        z6 = z;
                                        z5 = z2;
                                        function13 = function1;
                                        snapPosition3 = snapPosition;
                                        overscrollEffect3 = overscrollEffect;
                                        i27 = i9;
                                        f4 = f2;
                                        modifier4 = modifier2;
                                        targetedFlingBehavior4 = targetedFlingBehavior2;
                                        i28 = i15;
                                        nestedScrollConnection4 = nestedScrollConnection;
                                    } else {
                                        Modifier modifier5 = i31 != 0 ? Modifier.INSTANCE : modifier2;
                                        PaddingValues m1057PaddingValues0680j_4 = i6 != 0 ? PaddingKt.m1057PaddingValues0680j_4(Dp.constructor-impl(0)) : paddingValues;
                                        PageSize pageSize4 = i7 != 0 ? PageSize.Fill.INSTANCE : pageSize;
                                        int i34 = i8 != 0 ? 0 : i9;
                                        float f5 = i10 != 0 ? Dp.constructor-impl(0) : f2;
                                        Alignment.Vertical centerVertically = i11 != 0 ? Alignment.INSTANCE.getCenterVertically() : vertical;
                                        if ((i4 & Fields.SpotShadowColor) != 0) {
                                            i22 = i19;
                                            i25 = i18;
                                            r12 = 0;
                                            i23 = i20;
                                            i24 = i14;
                                            TargetedFlingBehavior flingBehavior = PagerDefaults.INSTANCE.flingBehavior(pagerState, null, null, null, 0.0f, startRestartGroup, (i15 & 14) | 196608, 30);
                                            i15 &= -29360129;
                                            targetedFlingBehavior2 = flingBehavior;
                                        } else {
                                            i22 = i19;
                                            r12 = 0;
                                            i23 = i20;
                                            i24 = i14;
                                            i25 = i18;
                                        }
                                        boolean z7 = i12 == 0 ? z : true;
                                        boolean z8 = i24 != 0 ? r12 : z2;
                                        Function1<? super Integer, ? extends Object> function14 = i25 != 0 ? null : function1;
                                        if ((i4 & Fields.CameraDistance) != 0) {
                                            nestedScrollConnection3 = PagerDefaults.INSTANCE.pageNestedScrollConnection(pagerState, Orientation.Horizontal, startRestartGroup, (i15 & 14) | 432);
                                            i26 = i22 & (-113);
                                        } else {
                                            nestedScrollConnection3 = nestedScrollConnection;
                                            i26 = i22;
                                        }
                                        SnapPosition.Start start = i23 != 0 ? SnapPosition.Start.INSTANCE : snapPosition;
                                        if ((i4 & Fields.Shape) != 0) {
                                            z5 = z8;
                                            function13 = function14;
                                            i19 = i26 & (-7169);
                                            snapPosition3 = start;
                                            overscrollEffect3 = OverscrollKt.rememberOverscrollEffect(startRestartGroup, r12);
                                        } else {
                                            overscrollEffect3 = overscrollEffect;
                                            z5 = z8;
                                            function13 = function14;
                                            i19 = i26;
                                            snapPosition3 = start;
                                        }
                                        targetedFlingBehavior4 = targetedFlingBehavior2;
                                        z6 = z7;
                                        i27 = i34;
                                        f4 = f5;
                                        vertical3 = centerVertically;
                                        i28 = i15;
                                        nestedScrollConnection4 = nestedScrollConnection3;
                                        pageSize3 = pageSize4;
                                        paddingValues3 = m1057PaddingValues0680j_4;
                                        modifier4 = modifier5;
                                    }
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1860873769, i28, i19, "androidx.compose.foundation.pager.HorizontalPager (Pager.kt:163)");
                                    }
                                    int i35 = i28 >> 6;
                                    int i36 = i28 << 12;
                                    int i37 = i19 << 6;
                                    composer2 = startRestartGroup;
                                    LazyLayoutPagerKt.m1396PagereLwUrMk(modifier4, pagerState, paddingValues3, z5, Orientation.Horizontal, targetedFlingBehavior4, z6, overscrollEffect3, i27, f4, pageSize3, nestedScrollConnection4, function13, Alignment.INSTANCE.getCenterHorizontally(), vertical3, snapPosition3, function4, composer2, ((i28 >> 3) & 14) | 24576 | ((i28 << 3) & 112) | (i28 & 896) | ((i28 >> 18) & 7168) | (458752 & i35) | (3670016 & i35) | ((i19 << 12) & 29360128) | (234881024 & i36) | (i36 & 1879048192), ((i19 << 9) & 458752) | ((i28 >> 9) & 14) | 3072 | (i19 & 112) | (i37 & 896) | (i35 & 57344) | (3670016 & i37), 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier3 = modifier4;
                                    paddingValues2 = paddingValues3;
                                    pageSize2 = pageSize3;
                                    i21 = i27;
                                    f3 = f4;
                                    vertical2 = vertical3;
                                    targetedFlingBehavior3 = targetedFlingBehavior4;
                                    z3 = z6;
                                    z4 = z5;
                                    function12 = function13;
                                    nestedScrollConnection2 = nestedScrollConnection4;
                                    snapPosition2 = snapPosition3;
                                    overscrollEffect2 = overscrollEffect3;
                                } else {
                                    composer2 = startRestartGroup;
                                    composer2.skipToGroupEnd();
                                    paddingValues2 = paddingValues;
                                    vertical2 = vertical;
                                    z3 = z;
                                    z4 = z2;
                                    function12 = function1;
                                    nestedScrollConnection2 = nestedScrollConnection;
                                    overscrollEffect2 = overscrollEffect;
                                    modifier3 = modifier2;
                                    targetedFlingBehavior3 = targetedFlingBehavior2;
                                    snapPosition2 = snapPosition;
                                    f3 = f2;
                                    i21 = i9;
                                    pageSize2 = pageSize;
                                }
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup != null) {
                                    endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.pager.PagerKt$$ExternalSyntheticLambda3
                                        public final Object invoke(Object obj, Object obj2) {
                                            Unit HorizontalPager__8jOkeI$lambda$1;
                                            HorizontalPager__8jOkeI$lambda$1 = PagerKt.HorizontalPager__8jOkeI$lambda$1(PagerState.this, modifier3, paddingValues2, pageSize2, i21, f3, vertical2, targetedFlingBehavior3, z3, z4, function12, nestedScrollConnection2, snapPosition2, overscrollEffect2, function4, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                            return HorizontalPager__8jOkeI$lambda$1;
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            if (startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i19 & 9363) != 9362, i15 & 1)) {
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                        if ((i3 & 3072) == 0) {
                        }
                        if ((i4 & Fields.Clip) == 0) {
                        }
                        if (startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i19 & 9363) != 9362, i15 & 1)) {
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    i9 = i;
                    i10 = i4 & 32;
                    if (i10 != 0) {
                    }
                    i11 = i4 & 64;
                    if (i11 != 0) {
                    }
                    if ((i2 & 12582912) == 0) {
                    }
                    i12 = i4 & Fields.RotationX;
                    if (i12 != 0) {
                    }
                    i13 = i4 & Fields.RotationY;
                    if (i13 != 0) {
                    }
                    i16 = i4 & Fields.RotationZ;
                    if (i16 != 0) {
                    }
                    if ((i3 & 48) == 0) {
                    }
                    i19 = i17;
                    i20 = i4 & Fields.TransformOrigin;
                    if (i20 != 0) {
                    }
                    if ((i3 & 3072) == 0) {
                    }
                    if ((i4 & Fields.Clip) == 0) {
                    }
                    if (startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i19 & 9363) != 9362, i15 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i8 = i4 & 16;
                int i332 = Fields.Clip;
                if (i8 == 0) {
                }
                i9 = i;
                i10 = i4 & 32;
                if (i10 != 0) {
                }
                i11 = i4 & 64;
                if (i11 != 0) {
                }
                if ((i2 & 12582912) == 0) {
                }
                i12 = i4 & Fields.RotationX;
                if (i12 != 0) {
                }
                i13 = i4 & Fields.RotationY;
                if (i13 != 0) {
                }
                i16 = i4 & Fields.RotationZ;
                if (i16 != 0) {
                }
                if ((i3 & 48) == 0) {
                }
                i19 = i17;
                i20 = i4 & Fields.TransformOrigin;
                if (i20 != 0) {
                }
                if ((i3 & 3072) == 0) {
                }
                if ((i4 & Fields.Clip) == 0) {
                }
                if (startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i19 & 9363) != 9362, i15 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i7 = i4 & 8;
            int i322 = Fields.RotationZ;
            if (i7 != 0) {
            }
            i8 = i4 & 16;
            int i3322 = Fields.Clip;
            if (i8 == 0) {
            }
            i9 = i;
            i10 = i4 & 32;
            if (i10 != 0) {
            }
            i11 = i4 & 64;
            if (i11 != 0) {
            }
            if ((i2 & 12582912) == 0) {
            }
            i12 = i4 & Fields.RotationX;
            if (i12 != 0) {
            }
            i13 = i4 & Fields.RotationY;
            if (i13 != 0) {
            }
            i16 = i4 & Fields.RotationZ;
            if (i16 != 0) {
            }
            if ((i3 & 48) == 0) {
            }
            i19 = i17;
            i20 = i4 & Fields.TransformOrigin;
            if (i20 != 0) {
            }
            if ((i3 & 3072) == 0) {
            }
            if ((i4 & Fields.Clip) == 0) {
            }
            if (startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i19 & 9363) != 9362, i15 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i6 = i4 & 4;
        if (i6 == 0) {
        }
        i7 = i4 & 8;
        int i3222 = Fields.RotationZ;
        if (i7 != 0) {
        }
        i8 = i4 & 16;
        int i33222 = Fields.Clip;
        if (i8 == 0) {
        }
        i9 = i;
        i10 = i4 & 32;
        if (i10 != 0) {
        }
        i11 = i4 & 64;
        if (i11 != 0) {
        }
        if ((i2 & 12582912) == 0) {
        }
        i12 = i4 & Fields.RotationX;
        if (i12 != 0) {
        }
        i13 = i4 & Fields.RotationY;
        if (i13 != 0) {
        }
        i16 = i4 & Fields.RotationZ;
        if (i16 != 0) {
        }
        if ((i3 & 48) == 0) {
        }
        i19 = i17;
        i20 = i4 & Fields.TransformOrigin;
        if (i20 != 0) {
        }
        if ((i3 & 3072) == 0) {
        }
        if ((i4 & Fields.Clip) == 0) {
        }
        if (startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i19 & 9363) != 9362, i15 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:89:? A[RETURN, SYNTHETIC] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    /* renamed from: HorizontalPager-oI3XNZo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m1404HorizontalPageroI3XNZo(final PagerState pagerState, Modifier modifier, PaddingValues paddingValues, PageSize pageSize, int i, float f, Alignment.Vertical vertical, TargetedFlingBehavior targetedFlingBehavior, boolean z, boolean z2, Function1 function1, NestedScrollConnection nestedScrollConnection, SnapPosition snapPosition, final Function4 function4, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        Modifier modifier2;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        float f2;
        int i11;
        TargetedFlingBehavior targetedFlingBehavior2;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        Composer composer2;
        final PaddingValues paddingValues2;
        final Alignment.Vertical vertical2;
        final boolean z3;
        final boolean z4;
        final Function1 function12;
        final NestedScrollConnection nestedScrollConnection2;
        final Modifier modifier3;
        final TargetedFlingBehavior targetedFlingBehavior3;
        final SnapPosition snapPosition2;
        final float f3;
        final int i21;
        final PageSize pageSize2;
        ScopeUpdateScope endRestartGroup;
        Modifier modifier4;
        PaddingValues m1057PaddingValues0680j_4;
        Alignment.Vertical centerVertically;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        TargetedFlingBehavior targetedFlingBehavior4;
        NestedScrollConnection nestedScrollConnection3;
        int i27;
        SnapPosition snapPosition3;
        TargetedFlingBehavior targetedFlingBehavior5;
        boolean z5;
        Function1 function13;
        boolean z6;
        float f4;
        int i28;
        NestedScrollConnection nestedScrollConnection4;
        int i29;
        PageSize pageSize3;
        int i30;
        int i31;
        Composer startRestartGroup = composer.startRestartGroup(1163833967);
        ComposerKt.sourceInformation(startRestartGroup, "C(HorizontalPager)N(state,modifier,contentPadding,pageSize,beyondViewportPageCount,pageSpacing:c#ui.unit.Dp,verticalAlignment,flingBehavior,userScrollEnabled,reverseLayout,key,pageNestedScrollConnection,snapPosition,pageContent)218@10977L26,204@10424L621:Pager.kt#g6yjnt");
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i5 = (startRestartGroup.changed(pagerState) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        int i32 = i4 & 2;
        if (i32 != 0) {
            i5 |= 48;
        } else if ((i2 & 48) == 0) {
            modifier2 = modifier;
            i5 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i6 = i4 & 4;
            if (i6 == 0) {
                i5 |= 384;
            } else if ((i2 & 384) == 0) {
                i5 |= startRestartGroup.changed(paddingValues) ? Fields.RotationX : Fields.SpotShadowColor;
                i7 = i4 & 8;
                int i33 = Fields.RotationZ;
                if (i7 != 0) {
                    i5 |= 3072;
                } else if ((i2 & 3072) == 0) {
                    i5 |= startRestartGroup.changed(pageSize) ? 2048 : 1024;
                    i8 = i4 & 16;
                    if (i8 == 0) {
                        i5 |= 24576;
                    } else if ((i2 & 24576) == 0) {
                        i9 = i;
                        i5 |= startRestartGroup.changed(i9) ? Fields.Clip : Fields.Shape;
                        i10 = i4 & 32;
                        if (i10 != 0) {
                            i5 |= 196608;
                            f2 = f;
                        } else {
                            f2 = f;
                            if ((i2 & 196608) == 0) {
                                i5 |= startRestartGroup.changed(f2) ? Fields.RenderEffect : 65536;
                            }
                        }
                        i11 = i4 & 64;
                        if (i11 != 0) {
                            i5 |= 1572864;
                        } else if ((i2 & 1572864) == 0) {
                            i5 |= startRestartGroup.changed(vertical) ? 1048576 : Fields.BlendMode;
                        }
                        if ((i2 & 12582912) == 0) {
                            if ((i4 & Fields.SpotShadowColor) == 0) {
                                targetedFlingBehavior2 = targetedFlingBehavior;
                                if (startRestartGroup.changed(targetedFlingBehavior2)) {
                                    i31 = 8388608;
                                    i5 |= i31;
                                }
                            } else {
                                targetedFlingBehavior2 = targetedFlingBehavior;
                            }
                            i31 = 4194304;
                            i5 |= i31;
                        } else {
                            targetedFlingBehavior2 = targetedFlingBehavior;
                        }
                        i12 = i4 & Fields.RotationX;
                        if (i12 != 0) {
                            i5 |= 100663296;
                        } else if ((i2 & 100663296) == 0) {
                            i5 |= startRestartGroup.changed(z) ? 67108864 : 33554432;
                        }
                        i13 = i4 & Fields.RotationY;
                        if (i13 != 0) {
                            i15 = i5 | 805306368;
                            i14 = i13;
                        } else {
                            if ((i2 & 805306368) == 0) {
                                i14 = i13;
                                i5 |= startRestartGroup.changed(z2) ? 536870912 : 268435456;
                            } else {
                                i14 = i13;
                            }
                            i15 = i5;
                        }
                        i16 = i4 & Fields.RotationZ;
                        if (i16 != 0) {
                            i17 = i3 | 6;
                        } else if ((i3 & 6) == 0) {
                            i17 = i3 | (startRestartGroup.changedInstance(function1) ? 4 : 2);
                        } else {
                            i17 = i3;
                        }
                        if ((i3 & 48) == 0) {
                            i18 = i16;
                            if ((i4 & Fields.CameraDistance) == 0 && startRestartGroup.changedInstance(nestedScrollConnection)) {
                                i30 = 32;
                                i17 |= i30;
                            }
                            i30 = 16;
                            i17 |= i30;
                        } else {
                            i18 = i16;
                        }
                        i19 = i17;
                        i20 = i4 & Fields.TransformOrigin;
                        if (i20 != 0) {
                            i19 |= 384;
                        } else if ((i3 & 384) == 0) {
                            i19 |= startRestartGroup.changed(snapPosition) ? Fields.RotationX : Fields.SpotShadowColor;
                            if ((i4 & Fields.Shape) == 0) {
                                i19 |= 3072;
                            } else if ((i3 & 3072) == 0) {
                                if (startRestartGroup.changedInstance(function4)) {
                                    i33 = 2048;
                                }
                                i19 |= i33;
                                if (startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i19 & 1171) != 1170, i15 & 1)) {
                                    startRestartGroup.startDefaults();
                                    ComposerKt.sourceInformation(startRestartGroup, "195@10019L28,200@10243L57");
                                    if ((i2 & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                        startRestartGroup.skipToGroupEnd();
                                        if ((i4 & Fields.SpotShadowColor) != 0) {
                                            i15 &= -29360129;
                                        }
                                        if ((i4 & Fields.CameraDistance) != 0) {
                                            i19 &= -113;
                                        }
                                        m1057PaddingValues0680j_4 = paddingValues;
                                        pageSize3 = pageSize;
                                        centerVertically = vertical;
                                        z6 = z;
                                        z5 = z2;
                                        function13 = function1;
                                        snapPosition3 = snapPosition;
                                        i29 = i9;
                                        f4 = f2;
                                        modifier4 = modifier2;
                                        i23 = 0;
                                        targetedFlingBehavior5 = targetedFlingBehavior2;
                                        i28 = i15;
                                        nestedScrollConnection4 = nestedScrollConnection;
                                    } else {
                                        modifier4 = i32 != 0 ? Modifier.INSTANCE : modifier2;
                                        m1057PaddingValues0680j_4 = i6 != 0 ? PaddingKt.m1057PaddingValues0680j_4(Dp.constructor-impl(0)) : paddingValues;
                                        PageSize pageSize4 = i7 != 0 ? PageSize.Fill.INSTANCE : pageSize;
                                        int i34 = i8 != 0 ? 0 : i9;
                                        float f5 = i10 != 0 ? Dp.constructor-impl(0) : f2;
                                        centerVertically = i11 != 0 ? Alignment.INSTANCE.getCenterVertically() : vertical;
                                        if ((i4 & Fields.SpotShadowColor) != 0) {
                                            i22 = i19;
                                            i26 = i18;
                                            i23 = 0;
                                            i24 = i20;
                                            i25 = i14;
                                            targetedFlingBehavior4 = PagerDefaults.INSTANCE.flingBehavior(pagerState, null, null, null, 0.0f, startRestartGroup, (i15 & 14) | 196608, 30);
                                            i15 &= -29360129;
                                        } else {
                                            i22 = i19;
                                            i23 = 0;
                                            i24 = i20;
                                            i25 = i14;
                                            i26 = i18;
                                            targetedFlingBehavior4 = targetedFlingBehavior2;
                                        }
                                        boolean z7 = i12 == 0 ? z : true;
                                        boolean z8 = i25 != 0 ? i23 == true ? 1 : 0 : z2;
                                        Function1 function14 = i26 != 0 ? null : function1;
                                        if ((i4 & Fields.CameraDistance) != 0) {
                                            nestedScrollConnection3 = PagerDefaults.INSTANCE.pageNestedScrollConnection(pagerState, Orientation.Horizontal, startRestartGroup, (i15 & 14) | 432);
                                            i27 = i22 & (-113);
                                        } else {
                                            nestedScrollConnection3 = nestedScrollConnection;
                                            i27 = i22;
                                        }
                                        if (i24 != 0) {
                                            targetedFlingBehavior5 = targetedFlingBehavior4;
                                            z5 = z8;
                                            function13 = function14;
                                            i19 = i27;
                                            snapPosition3 = SnapPosition.Start.INSTANCE;
                                        } else {
                                            snapPosition3 = snapPosition;
                                            targetedFlingBehavior5 = targetedFlingBehavior4;
                                            z5 = z8;
                                            function13 = function14;
                                            i19 = i27;
                                        }
                                        z6 = z7;
                                        f4 = f5;
                                        i28 = i15;
                                        nestedScrollConnection4 = nestedScrollConnection3;
                                        i29 = i34;
                                        pageSize3 = pageSize4;
                                    }
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1163833967, i28, i19, "androidx.compose.foundation.pager.HorizontalPager (Pager.kt:203)");
                                    }
                                    composer2 = startRestartGroup;
                                    m1403HorizontalPager8jOkeI(pagerState, modifier4, m1057PaddingValues0680j_4, pageSize3, i29, f4, centerVertically, targetedFlingBehavior5, z6, z5, function13, nestedScrollConnection4, snapPosition3, OverscrollKt.rememberOverscrollEffect(startRestartGroup, i23), function4, composer2, (i28 & 14) | (i28 & 112) | (i28 & 896) | (i28 & 7168) | (57344 & i28) | (458752 & i28) | (3670016 & i28) | (29360128 & i28) | (234881024 & i28) | (i28 & 1879048192), (i19 & 14) | (i19 & 112) | (i19 & 896) | ((i19 << 3) & 57344), 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier3 = modifier4;
                                    pageSize2 = pageSize3;
                                    paddingValues2 = m1057PaddingValues0680j_4;
                                    i21 = i29;
                                    f3 = f4;
                                    vertical2 = centerVertically;
                                    targetedFlingBehavior3 = targetedFlingBehavior5;
                                    z3 = z6;
                                    z4 = z5;
                                    function12 = function13;
                                    nestedScrollConnection2 = nestedScrollConnection4;
                                    snapPosition2 = snapPosition3;
                                } else {
                                    composer2 = startRestartGroup;
                                    composer2.skipToGroupEnd();
                                    paddingValues2 = paddingValues;
                                    vertical2 = vertical;
                                    z3 = z;
                                    z4 = z2;
                                    function12 = function1;
                                    nestedScrollConnection2 = nestedScrollConnection;
                                    modifier3 = modifier2;
                                    targetedFlingBehavior3 = targetedFlingBehavior2;
                                    snapPosition2 = snapPosition;
                                    f3 = f2;
                                    i21 = i9;
                                    pageSize2 = pageSize;
                                }
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup != null) {
                                    endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.pager.PagerKt$$ExternalSyntheticLambda1
                                        public final Object invoke(Object obj, Object obj2) {
                                            Unit HorizontalPager_oI3XNZo$lambda$2;
                                            HorizontalPager_oI3XNZo$lambda$2 = PagerKt.HorizontalPager_oI3XNZo$lambda$2(PagerState.this, modifier3, paddingValues2, pageSize2, i21, f3, vertical2, targetedFlingBehavior3, z3, z4, function12, nestedScrollConnection2, snapPosition2, function4, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                            return HorizontalPager_oI3XNZo$lambda$2;
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            if (startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i19 & 1171) != 1170, i15 & 1)) {
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                        if ((i4 & Fields.Shape) == 0) {
                        }
                        if (startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i19 & 1171) != 1170, i15 & 1)) {
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    i9 = i;
                    i10 = i4 & 32;
                    if (i10 != 0) {
                    }
                    i11 = i4 & 64;
                    if (i11 != 0) {
                    }
                    if ((i2 & 12582912) == 0) {
                    }
                    i12 = i4 & Fields.RotationX;
                    if (i12 != 0) {
                    }
                    i13 = i4 & Fields.RotationY;
                    if (i13 != 0) {
                    }
                    i16 = i4 & Fields.RotationZ;
                    if (i16 != 0) {
                    }
                    if ((i3 & 48) == 0) {
                    }
                    i19 = i17;
                    i20 = i4 & Fields.TransformOrigin;
                    if (i20 != 0) {
                    }
                    if ((i4 & Fields.Shape) == 0) {
                    }
                    if (startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i19 & 1171) != 1170, i15 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i8 = i4 & 16;
                if (i8 == 0) {
                }
                i9 = i;
                i10 = i4 & 32;
                if (i10 != 0) {
                }
                i11 = i4 & 64;
                if (i11 != 0) {
                }
                if ((i2 & 12582912) == 0) {
                }
                i12 = i4 & Fields.RotationX;
                if (i12 != 0) {
                }
                i13 = i4 & Fields.RotationY;
                if (i13 != 0) {
                }
                i16 = i4 & Fields.RotationZ;
                if (i16 != 0) {
                }
                if ((i3 & 48) == 0) {
                }
                i19 = i17;
                i20 = i4 & Fields.TransformOrigin;
                if (i20 != 0) {
                }
                if ((i4 & Fields.Shape) == 0) {
                }
                if (startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i19 & 1171) != 1170, i15 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i7 = i4 & 8;
            int i332 = Fields.RotationZ;
            if (i7 != 0) {
            }
            i8 = i4 & 16;
            if (i8 == 0) {
            }
            i9 = i;
            i10 = i4 & 32;
            if (i10 != 0) {
            }
            i11 = i4 & 64;
            if (i11 != 0) {
            }
            if ((i2 & 12582912) == 0) {
            }
            i12 = i4 & Fields.RotationX;
            if (i12 != 0) {
            }
            i13 = i4 & Fields.RotationY;
            if (i13 != 0) {
            }
            i16 = i4 & Fields.RotationZ;
            if (i16 != 0) {
            }
            if ((i3 & 48) == 0) {
            }
            i19 = i17;
            i20 = i4 & Fields.TransformOrigin;
            if (i20 != 0) {
            }
            if ((i4 & Fields.Shape) == 0) {
            }
            if (startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i19 & 1171) != 1170, i15 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i6 = i4 & 4;
        if (i6 == 0) {
        }
        i7 = i4 & 8;
        int i3322 = Fields.RotationZ;
        if (i7 != 0) {
        }
        i8 = i4 & 16;
        if (i8 == 0) {
        }
        i9 = i;
        i10 = i4 & 32;
        if (i10 != 0) {
        }
        i11 = i4 & 64;
        if (i11 != 0) {
        }
        if ((i2 & 12582912) == 0) {
        }
        i12 = i4 & Fields.RotationX;
        if (i12 != 0) {
        }
        i13 = i4 & Fields.RotationY;
        if (i13 != 0) {
        }
        i16 = i4 & Fields.RotationZ;
        if (i16 != 0) {
        }
        if ((i3 & 48) == 0) {
        }
        i19 = i17;
        i20 = i4 & Fields.TransformOrigin;
        if (i20 != 0) {
        }
        if ((i4 & Fields.Shape) == 0) {
        }
        if (startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i19 & 1171) != 1170, i15 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x03d1  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x03f2  */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4, types: [int] */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* renamed from: VerticalPager--8jOkeI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1406VerticalPager8jOkeI(final PagerState pagerState, Modifier modifier, PaddingValues paddingValues, PageSize pageSize, int i, float f, Alignment.Horizontal horizontal, TargetedFlingBehavior targetedFlingBehavior, boolean z, boolean z2, Function1<? super Integer, ? extends Object> function1, NestedScrollConnection nestedScrollConnection, SnapPosition snapPosition, OverscrollEffect overscrollEffect, final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        Modifier modifier2;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        float f2;
        int i11;
        TargetedFlingBehavior targetedFlingBehavior2;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        Composer composer2;
        final PaddingValues paddingValues2;
        final Alignment.Horizontal horizontal2;
        final boolean z3;
        final boolean z4;
        final Function1<? super Integer, ? extends Object> function12;
        final NestedScrollConnection nestedScrollConnection2;
        final SnapPosition snapPosition2;
        final Modifier modifier3;
        final TargetedFlingBehavior targetedFlingBehavior3;
        final OverscrollEffect overscrollEffect2;
        final float f3;
        final int i21;
        final PageSize pageSize2;
        ScopeUpdateScope endRestartGroup;
        int i22;
        ?? r12;
        int i23;
        int i24;
        int i25;
        NestedScrollConnection nestedScrollConnection3;
        int i26;
        OverscrollEffect overscrollEffect3;
        boolean z5;
        Function1<? super Integer, ? extends Object> function13;
        SnapPosition snapPosition3;
        TargetedFlingBehavior targetedFlingBehavior4;
        boolean z6;
        int i27;
        float f4;
        Alignment.Horizontal horizontal3;
        int i28;
        NestedScrollConnection nestedScrollConnection4;
        PageSize pageSize3;
        PaddingValues paddingValues3;
        Modifier modifier4;
        int i29;
        int i30;
        Composer startRestartGroup = composer.startRestartGroup(-1590376023);
        ComposerKt.sourceInformation(startRestartGroup, "C(VerticalPager)N(state,modifier,contentPadding,pageSize,beyondViewportPageCount,pageSpacing:c#ui.unit.Dp,horizontalAlignment,flingBehavior,userScrollEnabled,reverseLayout,key,pageNestedScrollConnection,snapPosition,overscrollEffect,pageContent)294@15738L705:Pager.kt#g6yjnt");
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i5 = (startRestartGroup.changed(pagerState) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        int i31 = i4 & 2;
        if (i31 != 0) {
            i5 |= 48;
        } else if ((i2 & 48) == 0) {
            modifier2 = modifier;
            i5 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i6 = i4 & 4;
            if (i6 == 0) {
                i5 |= 384;
            } else if ((i2 & 384) == 0) {
                i5 |= startRestartGroup.changed(paddingValues) ? Fields.RotationX : Fields.SpotShadowColor;
                i7 = i4 & 8;
                int i32 = Fields.RotationZ;
                if (i7 != 0) {
                    i5 |= 3072;
                } else if ((i2 & 3072) == 0) {
                    i5 |= startRestartGroup.changed(pageSize) ? 2048 : 1024;
                    i8 = i4 & 16;
                    int i33 = Fields.Clip;
                    if (i8 == 0) {
                        i5 |= 24576;
                    } else if ((i2 & 24576) == 0) {
                        i9 = i;
                        i5 |= startRestartGroup.changed(i9) ? 16384 : 8192;
                        i10 = i4 & 32;
                        if (i10 != 0) {
                            i5 |= 196608;
                            f2 = f;
                        } else {
                            f2 = f;
                            if ((i2 & 196608) == 0) {
                                i5 |= startRestartGroup.changed(f2) ? Fields.RenderEffect : 65536;
                            }
                        }
                        i11 = i4 & 64;
                        if (i11 != 0) {
                            i5 |= 1572864;
                        } else if ((i2 & 1572864) == 0) {
                            i5 |= startRestartGroup.changed(horizontal) ? 1048576 : Fields.BlendMode;
                        }
                        if ((i2 & 12582912) == 0) {
                            if ((i4 & Fields.SpotShadowColor) == 0) {
                                targetedFlingBehavior2 = targetedFlingBehavior;
                                if (startRestartGroup.changed(targetedFlingBehavior2)) {
                                    i30 = 8388608;
                                    i5 |= i30;
                                }
                            } else {
                                targetedFlingBehavior2 = targetedFlingBehavior;
                            }
                            i30 = 4194304;
                            i5 |= i30;
                        } else {
                            targetedFlingBehavior2 = targetedFlingBehavior;
                        }
                        i12 = i4 & Fields.RotationX;
                        if (i12 != 0) {
                            i5 |= 100663296;
                        } else if ((i2 & 100663296) == 0) {
                            i5 |= startRestartGroup.changed(z) ? 67108864 : 33554432;
                        }
                        i13 = i4 & Fields.RotationY;
                        if (i13 != 0) {
                            i15 = i5 | 805306368;
                            i14 = i13;
                        } else {
                            if ((i2 & 805306368) == 0) {
                                i14 = i13;
                                i5 |= startRestartGroup.changed(z2) ? 536870912 : 268435456;
                            } else {
                                i14 = i13;
                            }
                            i15 = i5;
                        }
                        i16 = i4 & Fields.RotationZ;
                        if (i16 != 0) {
                            i17 = i3 | 6;
                        } else if ((i3 & 6) == 0) {
                            i17 = i3 | (startRestartGroup.changedInstance(function1) ? 4 : 2);
                        } else {
                            i17 = i3;
                        }
                        if ((i3 & 48) == 0) {
                            i18 = i16;
                            if ((i4 & Fields.CameraDistance) == 0 && startRestartGroup.changedInstance(nestedScrollConnection)) {
                                i29 = 32;
                                i17 |= i29;
                            }
                            i29 = 16;
                            i17 |= i29;
                        } else {
                            i18 = i16;
                        }
                        i19 = i17;
                        i20 = i4 & Fields.TransformOrigin;
                        if (i20 != 0) {
                            i19 |= 384;
                        } else if ((i3 & 384) == 0) {
                            i19 |= startRestartGroup.changed(snapPosition) ? Fields.RotationX : Fields.SpotShadowColor;
                            if ((i3 & 3072) == 0) {
                                if ((i4 & Fields.Shape) == 0 && startRestartGroup.changed(overscrollEffect)) {
                                    i32 = 2048;
                                }
                                i19 |= i32;
                            }
                            if ((i4 & Fields.Clip) == 0) {
                                i19 |= 24576;
                            } else if ((i3 & 24576) == 0) {
                                if (!startRestartGroup.changedInstance(function4)) {
                                    i33 = 8192;
                                }
                                i19 |= i33;
                                if (startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i19 & 9363) != 9362, i15 & 1)) {
                                    startRestartGroup.startDefaults();
                                    ComposerKt.sourceInformation(startRestartGroup, "284@15265L28,289@15489L55,291@15641L26");
                                    if ((i2 & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                        startRestartGroup.skipToGroupEnd();
                                        if ((i4 & Fields.SpotShadowColor) != 0) {
                                            i15 &= -29360129;
                                        }
                                        if ((i4 & Fields.CameraDistance) != 0) {
                                            i19 &= -113;
                                        }
                                        if ((i4 & Fields.Shape) != 0) {
                                            i19 &= -7169;
                                        }
                                        paddingValues3 = paddingValues;
                                        pageSize3 = pageSize;
                                        horizontal3 = horizontal;
                                        z6 = z;
                                        z5 = z2;
                                        function13 = function1;
                                        snapPosition3 = snapPosition;
                                        overscrollEffect3 = overscrollEffect;
                                        i27 = i9;
                                        f4 = f2;
                                        modifier4 = modifier2;
                                        targetedFlingBehavior4 = targetedFlingBehavior2;
                                        i28 = i15;
                                        nestedScrollConnection4 = nestedScrollConnection;
                                    } else {
                                        Modifier modifier5 = i31 != 0 ? Modifier.INSTANCE : modifier2;
                                        PaddingValues m1057PaddingValues0680j_4 = i6 != 0 ? PaddingKt.m1057PaddingValues0680j_4(Dp.constructor-impl(0)) : paddingValues;
                                        PageSize pageSize4 = i7 != 0 ? PageSize.Fill.INSTANCE : pageSize;
                                        int i34 = i8 != 0 ? 0 : i9;
                                        float f5 = i10 != 0 ? Dp.constructor-impl(0) : f2;
                                        Alignment.Horizontal centerHorizontally = i11 != 0 ? Alignment.INSTANCE.getCenterHorizontally() : horizontal;
                                        if ((i4 & Fields.SpotShadowColor) != 0) {
                                            i22 = i19;
                                            i25 = i18;
                                            r12 = 0;
                                            i23 = i20;
                                            i24 = i14;
                                            TargetedFlingBehavior flingBehavior = PagerDefaults.INSTANCE.flingBehavior(pagerState, null, null, null, 0.0f, startRestartGroup, (i15 & 14) | 196608, 30);
                                            i15 &= -29360129;
                                            targetedFlingBehavior2 = flingBehavior;
                                        } else {
                                            i22 = i19;
                                            r12 = 0;
                                            i23 = i20;
                                            i24 = i14;
                                            i25 = i18;
                                        }
                                        boolean z7 = i12 == 0 ? z : true;
                                        boolean z8 = i24 != 0 ? r12 : z2;
                                        Function1<? super Integer, ? extends Object> function14 = i25 != 0 ? null : function1;
                                        if ((i4 & Fields.CameraDistance) != 0) {
                                            nestedScrollConnection3 = PagerDefaults.INSTANCE.pageNestedScrollConnection(pagerState, Orientation.Vertical, startRestartGroup, (i15 & 14) | 432);
                                            i26 = i22 & (-113);
                                        } else {
                                            nestedScrollConnection3 = nestedScrollConnection;
                                            i26 = i22;
                                        }
                                        SnapPosition.Start start = i23 != 0 ? SnapPosition.Start.INSTANCE : snapPosition;
                                        if ((i4 & Fields.Shape) != 0) {
                                            z5 = z8;
                                            function13 = function14;
                                            i19 = i26 & (-7169);
                                            snapPosition3 = start;
                                            overscrollEffect3 = OverscrollKt.rememberOverscrollEffect(startRestartGroup, r12);
                                        } else {
                                            overscrollEffect3 = overscrollEffect;
                                            z5 = z8;
                                            function13 = function14;
                                            i19 = i26;
                                            snapPosition3 = start;
                                        }
                                        targetedFlingBehavior4 = targetedFlingBehavior2;
                                        z6 = z7;
                                        i27 = i34;
                                        f4 = f5;
                                        horizontal3 = centerHorizontally;
                                        i28 = i15;
                                        nestedScrollConnection4 = nestedScrollConnection3;
                                        pageSize3 = pageSize4;
                                        paddingValues3 = m1057PaddingValues0680j_4;
                                        modifier4 = modifier5;
                                    }
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1590376023, i28, i19, "androidx.compose.foundation.pager.VerticalPager (Pager.kt:293)");
                                    }
                                    int i35 = i28 >> 6;
                                    int i36 = ((i28 >> 3) & 14) | 24576 | ((i28 << 3) & 112) | (i28 & 896) | ((i28 >> 18) & 7168) | (458752 & i35) | (i35 & 3670016) | ((i19 << 12) & 29360128);
                                    int i37 = i28 << 12;
                                    int i38 = i28 >> 9;
                                    int i39 = i19 << 6;
                                    composer2 = startRestartGroup;
                                    LazyLayoutPagerKt.m1396PagereLwUrMk(modifier4, pagerState, paddingValues3, z5, Orientation.Vertical, targetedFlingBehavior4, z6, overscrollEffect3, i27, f4, pageSize3, nestedScrollConnection4, function13, horizontal3, Alignment.INSTANCE.getCenterVertically(), snapPosition3, function4, composer2, i36 | (234881024 & i37) | (i37 & 1879048192), ((i19 << 9) & 458752) | (i38 & 7168) | (i38 & 14) | 24576 | (i19 & 112) | (i39 & 896) | (3670016 & i39), 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier3 = modifier4;
                                    paddingValues2 = paddingValues3;
                                    pageSize2 = pageSize3;
                                    i21 = i27;
                                    f3 = f4;
                                    horizontal2 = horizontal3;
                                    targetedFlingBehavior3 = targetedFlingBehavior4;
                                    z3 = z6;
                                    z4 = z5;
                                    function12 = function13;
                                    nestedScrollConnection2 = nestedScrollConnection4;
                                    snapPosition2 = snapPosition3;
                                    overscrollEffect2 = overscrollEffect3;
                                } else {
                                    composer2 = startRestartGroup;
                                    composer2.skipToGroupEnd();
                                    paddingValues2 = paddingValues;
                                    horizontal2 = horizontal;
                                    z3 = z;
                                    z4 = z2;
                                    function12 = function1;
                                    nestedScrollConnection2 = nestedScrollConnection;
                                    snapPosition2 = snapPosition;
                                    modifier3 = modifier2;
                                    targetedFlingBehavior3 = targetedFlingBehavior2;
                                    overscrollEffect2 = overscrollEffect;
                                    f3 = f2;
                                    i21 = i9;
                                    pageSize2 = pageSize;
                                }
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup != null) {
                                    endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.pager.PagerKt$$ExternalSyntheticLambda5
                                        public final Object invoke(Object obj, Object obj2) {
                                            Unit VerticalPager__8jOkeI$lambda$3;
                                            VerticalPager__8jOkeI$lambda$3 = PagerKt.VerticalPager__8jOkeI$lambda$3(PagerState.this, modifier3, paddingValues2, pageSize2, i21, f3, horizontal2, targetedFlingBehavior3, z3, z4, function12, nestedScrollConnection2, snapPosition2, overscrollEffect2, function4, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                            return VerticalPager__8jOkeI$lambda$3;
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            if (startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i19 & 9363) != 9362, i15 & 1)) {
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                        if ((i3 & 3072) == 0) {
                        }
                        if ((i4 & Fields.Clip) == 0) {
                        }
                        if (startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i19 & 9363) != 9362, i15 & 1)) {
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    i9 = i;
                    i10 = i4 & 32;
                    if (i10 != 0) {
                    }
                    i11 = i4 & 64;
                    if (i11 != 0) {
                    }
                    if ((i2 & 12582912) == 0) {
                    }
                    i12 = i4 & Fields.RotationX;
                    if (i12 != 0) {
                    }
                    i13 = i4 & Fields.RotationY;
                    if (i13 != 0) {
                    }
                    i16 = i4 & Fields.RotationZ;
                    if (i16 != 0) {
                    }
                    if ((i3 & 48) == 0) {
                    }
                    i19 = i17;
                    i20 = i4 & Fields.TransformOrigin;
                    if (i20 != 0) {
                    }
                    if ((i3 & 3072) == 0) {
                    }
                    if ((i4 & Fields.Clip) == 0) {
                    }
                    if (startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i19 & 9363) != 9362, i15 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i8 = i4 & 16;
                int i332 = Fields.Clip;
                if (i8 == 0) {
                }
                i9 = i;
                i10 = i4 & 32;
                if (i10 != 0) {
                }
                i11 = i4 & 64;
                if (i11 != 0) {
                }
                if ((i2 & 12582912) == 0) {
                }
                i12 = i4 & Fields.RotationX;
                if (i12 != 0) {
                }
                i13 = i4 & Fields.RotationY;
                if (i13 != 0) {
                }
                i16 = i4 & Fields.RotationZ;
                if (i16 != 0) {
                }
                if ((i3 & 48) == 0) {
                }
                i19 = i17;
                i20 = i4 & Fields.TransformOrigin;
                if (i20 != 0) {
                }
                if ((i3 & 3072) == 0) {
                }
                if ((i4 & Fields.Clip) == 0) {
                }
                if (startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i19 & 9363) != 9362, i15 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i7 = i4 & 8;
            int i322 = Fields.RotationZ;
            if (i7 != 0) {
            }
            i8 = i4 & 16;
            int i3322 = Fields.Clip;
            if (i8 == 0) {
            }
            i9 = i;
            i10 = i4 & 32;
            if (i10 != 0) {
            }
            i11 = i4 & 64;
            if (i11 != 0) {
            }
            if ((i2 & 12582912) == 0) {
            }
            i12 = i4 & Fields.RotationX;
            if (i12 != 0) {
            }
            i13 = i4 & Fields.RotationY;
            if (i13 != 0) {
            }
            i16 = i4 & Fields.RotationZ;
            if (i16 != 0) {
            }
            if ((i3 & 48) == 0) {
            }
            i19 = i17;
            i20 = i4 & Fields.TransformOrigin;
            if (i20 != 0) {
            }
            if ((i3 & 3072) == 0) {
            }
            if ((i4 & Fields.Clip) == 0) {
            }
            if (startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i19 & 9363) != 9362, i15 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i6 = i4 & 4;
        if (i6 == 0) {
        }
        i7 = i4 & 8;
        int i3222 = Fields.RotationZ;
        if (i7 != 0) {
        }
        i8 = i4 & 16;
        int i33222 = Fields.Clip;
        if (i8 == 0) {
        }
        i9 = i;
        i10 = i4 & 32;
        if (i10 != 0) {
        }
        i11 = i4 & 64;
        if (i11 != 0) {
        }
        if ((i2 & 12582912) == 0) {
        }
        i12 = i4 & Fields.RotationX;
        if (i12 != 0) {
        }
        i13 = i4 & Fields.RotationY;
        if (i13 != 0) {
        }
        i16 = i4 & Fields.RotationZ;
        if (i16 != 0) {
        }
        if ((i3 & 48) == 0) {
        }
        i19 = i17;
        i20 = i4 & Fields.TransformOrigin;
        if (i20 != 0) {
        }
        if ((i3 & 3072) == 0) {
        }
        if ((i4 & Fields.Clip) == 0) {
        }
        if (startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i19 & 9363) != 9362, i15 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:89:? A[RETURN, SYNTHETIC] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    /* renamed from: VerticalPager-oI3XNZo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m1407VerticalPageroI3XNZo(final PagerState pagerState, Modifier modifier, PaddingValues paddingValues, PageSize pageSize, int i, float f, Alignment.Horizontal horizontal, TargetedFlingBehavior targetedFlingBehavior, boolean z, boolean z2, Function1 function1, NestedScrollConnection nestedScrollConnection, SnapPosition snapPosition, final Function4 function4, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        Modifier modifier2;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        float f2;
        int i11;
        TargetedFlingBehavior targetedFlingBehavior2;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        Composer composer2;
        final PaddingValues paddingValues2;
        final Alignment.Horizontal horizontal2;
        final boolean z3;
        final boolean z4;
        final Function1 function12;
        final NestedScrollConnection nestedScrollConnection2;
        final Modifier modifier3;
        final TargetedFlingBehavior targetedFlingBehavior3;
        final SnapPosition snapPosition2;
        final float f3;
        final int i21;
        final PageSize pageSize2;
        ScopeUpdateScope endRestartGroup;
        Modifier modifier4;
        PaddingValues m1057PaddingValues0680j_4;
        Alignment.Horizontal centerHorizontally;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        TargetedFlingBehavior targetedFlingBehavior4;
        NestedScrollConnection nestedScrollConnection3;
        int i27;
        SnapPosition snapPosition3;
        TargetedFlingBehavior targetedFlingBehavior5;
        boolean z5;
        Function1 function13;
        boolean z6;
        float f4;
        int i28;
        NestedScrollConnection nestedScrollConnection4;
        int i29;
        PageSize pageSize3;
        int i30;
        int i31;
        Composer startRestartGroup = composer.startRestartGroup(-1474550033);
        ComposerKt.sourceInformation(startRestartGroup, "C(VerticalPager)N(state,modifier,contentPadding,pageSize,beyondViewportPageCount,pageSpacing:c#ui.unit.Dp,horizontalAlignment,flingBehavior,userScrollEnabled,reverseLayout,key,pageNestedScrollConnection,snapPosition,pageContent)348@17908L26,334@17353L623:Pager.kt#g6yjnt");
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i5 = (startRestartGroup.changed(pagerState) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        int i32 = i4 & 2;
        if (i32 != 0) {
            i5 |= 48;
        } else if ((i2 & 48) == 0) {
            modifier2 = modifier;
            i5 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i6 = i4 & 4;
            if (i6 == 0) {
                i5 |= 384;
            } else if ((i2 & 384) == 0) {
                i5 |= startRestartGroup.changed(paddingValues) ? Fields.RotationX : Fields.SpotShadowColor;
                i7 = i4 & 8;
                int i33 = Fields.RotationZ;
                if (i7 != 0) {
                    i5 |= 3072;
                } else if ((i2 & 3072) == 0) {
                    i5 |= startRestartGroup.changed(pageSize) ? 2048 : 1024;
                    i8 = i4 & 16;
                    if (i8 == 0) {
                        i5 |= 24576;
                    } else if ((i2 & 24576) == 0) {
                        i9 = i;
                        i5 |= startRestartGroup.changed(i9) ? Fields.Clip : Fields.Shape;
                        i10 = i4 & 32;
                        if (i10 != 0) {
                            i5 |= 196608;
                            f2 = f;
                        } else {
                            f2 = f;
                            if ((i2 & 196608) == 0) {
                                i5 |= startRestartGroup.changed(f2) ? Fields.RenderEffect : 65536;
                            }
                        }
                        i11 = i4 & 64;
                        if (i11 != 0) {
                            i5 |= 1572864;
                        } else if ((i2 & 1572864) == 0) {
                            i5 |= startRestartGroup.changed(horizontal) ? 1048576 : Fields.BlendMode;
                        }
                        if ((i2 & 12582912) == 0) {
                            if ((i4 & Fields.SpotShadowColor) == 0) {
                                targetedFlingBehavior2 = targetedFlingBehavior;
                                if (startRestartGroup.changed(targetedFlingBehavior2)) {
                                    i31 = 8388608;
                                    i5 |= i31;
                                }
                            } else {
                                targetedFlingBehavior2 = targetedFlingBehavior;
                            }
                            i31 = 4194304;
                            i5 |= i31;
                        } else {
                            targetedFlingBehavior2 = targetedFlingBehavior;
                        }
                        i12 = i4 & Fields.RotationX;
                        if (i12 != 0) {
                            i5 |= 100663296;
                        } else if ((i2 & 100663296) == 0) {
                            i5 |= startRestartGroup.changed(z) ? 67108864 : 33554432;
                        }
                        i13 = i4 & Fields.RotationY;
                        if (i13 != 0) {
                            i15 = i5 | 805306368;
                            i14 = i13;
                        } else {
                            if ((i2 & 805306368) == 0) {
                                i14 = i13;
                                i5 |= startRestartGroup.changed(z2) ? 536870912 : 268435456;
                            } else {
                                i14 = i13;
                            }
                            i15 = i5;
                        }
                        i16 = i4 & Fields.RotationZ;
                        if (i16 != 0) {
                            i17 = i3 | 6;
                        } else if ((i3 & 6) == 0) {
                            i17 = i3 | (startRestartGroup.changedInstance(function1) ? 4 : 2);
                        } else {
                            i17 = i3;
                        }
                        if ((i3 & 48) == 0) {
                            i18 = i16;
                            if ((i4 & Fields.CameraDistance) == 0 && startRestartGroup.changedInstance(nestedScrollConnection)) {
                                i30 = 32;
                                i17 |= i30;
                            }
                            i30 = 16;
                            i17 |= i30;
                        } else {
                            i18 = i16;
                        }
                        i19 = i17;
                        i20 = i4 & Fields.TransformOrigin;
                        if (i20 != 0) {
                            i19 |= 384;
                        } else if ((i3 & 384) == 0) {
                            i19 |= startRestartGroup.changed(snapPosition) ? Fields.RotationX : Fields.SpotShadowColor;
                            if ((i4 & Fields.Shape) == 0) {
                                i19 |= 3072;
                            } else if ((i3 & 3072) == 0) {
                                if (startRestartGroup.changedInstance(function4)) {
                                    i33 = 2048;
                                }
                                i19 |= i33;
                                if (startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i19 & 1171) != 1170, i15 & 1)) {
                                    startRestartGroup.startDefaults();
                                    ComposerKt.sourceInformation(startRestartGroup, "325@16950L28,330@17174L55");
                                    if ((i2 & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                        startRestartGroup.skipToGroupEnd();
                                        if ((i4 & Fields.SpotShadowColor) != 0) {
                                            i15 &= -29360129;
                                        }
                                        if ((i4 & Fields.CameraDistance) != 0) {
                                            i19 &= -113;
                                        }
                                        m1057PaddingValues0680j_4 = paddingValues;
                                        pageSize3 = pageSize;
                                        centerHorizontally = horizontal;
                                        z6 = z;
                                        z5 = z2;
                                        function13 = function1;
                                        snapPosition3 = snapPosition;
                                        i29 = i9;
                                        f4 = f2;
                                        modifier4 = modifier2;
                                        i23 = 0;
                                        targetedFlingBehavior5 = targetedFlingBehavior2;
                                        i28 = i15;
                                        nestedScrollConnection4 = nestedScrollConnection;
                                    } else {
                                        modifier4 = i32 != 0 ? Modifier.INSTANCE : modifier2;
                                        m1057PaddingValues0680j_4 = i6 != 0 ? PaddingKt.m1057PaddingValues0680j_4(Dp.constructor-impl(0)) : paddingValues;
                                        PageSize pageSize4 = i7 != 0 ? PageSize.Fill.INSTANCE : pageSize;
                                        int i34 = i8 != 0 ? 0 : i9;
                                        float f5 = i10 != 0 ? Dp.constructor-impl(0) : f2;
                                        centerHorizontally = i11 != 0 ? Alignment.INSTANCE.getCenterHorizontally() : horizontal;
                                        if ((i4 & Fields.SpotShadowColor) != 0) {
                                            i22 = i19;
                                            i26 = i18;
                                            i23 = 0;
                                            i24 = i20;
                                            i25 = i14;
                                            targetedFlingBehavior4 = PagerDefaults.INSTANCE.flingBehavior(pagerState, null, null, null, 0.0f, startRestartGroup, (i15 & 14) | 196608, 30);
                                            i15 &= -29360129;
                                        } else {
                                            i22 = i19;
                                            i23 = 0;
                                            i24 = i20;
                                            i25 = i14;
                                            i26 = i18;
                                            targetedFlingBehavior4 = targetedFlingBehavior2;
                                        }
                                        boolean z7 = i12 == 0 ? z : true;
                                        boolean z8 = i25 != 0 ? i23 == true ? 1 : 0 : z2;
                                        Function1 function14 = i26 != 0 ? null : function1;
                                        if ((i4 & Fields.CameraDistance) != 0) {
                                            nestedScrollConnection3 = PagerDefaults.INSTANCE.pageNestedScrollConnection(pagerState, Orientation.Vertical, startRestartGroup, (i15 & 14) | 432);
                                            i27 = i22 & (-113);
                                        } else {
                                            nestedScrollConnection3 = nestedScrollConnection;
                                            i27 = i22;
                                        }
                                        if (i24 != 0) {
                                            targetedFlingBehavior5 = targetedFlingBehavior4;
                                            z5 = z8;
                                            function13 = function14;
                                            i19 = i27;
                                            snapPosition3 = SnapPosition.Start.INSTANCE;
                                        } else {
                                            snapPosition3 = snapPosition;
                                            targetedFlingBehavior5 = targetedFlingBehavior4;
                                            z5 = z8;
                                            function13 = function14;
                                            i19 = i27;
                                        }
                                        z6 = z7;
                                        f4 = f5;
                                        i28 = i15;
                                        nestedScrollConnection4 = nestedScrollConnection3;
                                        i29 = i34;
                                        pageSize3 = pageSize4;
                                    }
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1474550033, i28, i19, "androidx.compose.foundation.pager.VerticalPager (Pager.kt:333)");
                                    }
                                    composer2 = startRestartGroup;
                                    m1406VerticalPager8jOkeI(pagerState, modifier4, m1057PaddingValues0680j_4, pageSize3, i29, f4, centerHorizontally, targetedFlingBehavior5, z6, z5, function13, nestedScrollConnection4, snapPosition3, OverscrollKt.rememberOverscrollEffect(startRestartGroup, i23), function4, composer2, (i28 & 14) | (i28 & 112) | (i28 & 896) | (i28 & 7168) | (57344 & i28) | (458752 & i28) | (3670016 & i28) | (29360128 & i28) | (234881024 & i28) | (i28 & 1879048192), (i19 & 14) | (i19 & 112) | (i19 & 896) | ((i19 << 3) & 57344), 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier3 = modifier4;
                                    pageSize2 = pageSize3;
                                    paddingValues2 = m1057PaddingValues0680j_4;
                                    i21 = i29;
                                    f3 = f4;
                                    horizontal2 = centerHorizontally;
                                    targetedFlingBehavior3 = targetedFlingBehavior5;
                                    z3 = z6;
                                    z4 = z5;
                                    function12 = function13;
                                    nestedScrollConnection2 = nestedScrollConnection4;
                                    snapPosition2 = snapPosition3;
                                } else {
                                    composer2 = startRestartGroup;
                                    composer2.skipToGroupEnd();
                                    paddingValues2 = paddingValues;
                                    horizontal2 = horizontal;
                                    z3 = z;
                                    z4 = z2;
                                    function12 = function1;
                                    nestedScrollConnection2 = nestedScrollConnection;
                                    modifier3 = modifier2;
                                    targetedFlingBehavior3 = targetedFlingBehavior2;
                                    snapPosition2 = snapPosition;
                                    f3 = f2;
                                    i21 = i9;
                                    pageSize2 = pageSize;
                                }
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup != null) {
                                    endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.pager.PagerKt$$ExternalSyntheticLambda4
                                        public final Object invoke(Object obj, Object obj2) {
                                            Unit VerticalPager_oI3XNZo$lambda$4;
                                            VerticalPager_oI3XNZo$lambda$4 = PagerKt.VerticalPager_oI3XNZo$lambda$4(PagerState.this, modifier3, paddingValues2, pageSize2, i21, f3, horizontal2, targetedFlingBehavior3, z3, z4, function12, nestedScrollConnection2, snapPosition2, function4, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                            return VerticalPager_oI3XNZo$lambda$4;
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            if (startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i19 & 1171) != 1170, i15 & 1)) {
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                        if ((i4 & Fields.Shape) == 0) {
                        }
                        if (startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i19 & 1171) != 1170, i15 & 1)) {
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    i9 = i;
                    i10 = i4 & 32;
                    if (i10 != 0) {
                    }
                    i11 = i4 & 64;
                    if (i11 != 0) {
                    }
                    if ((i2 & 12582912) == 0) {
                    }
                    i12 = i4 & Fields.RotationX;
                    if (i12 != 0) {
                    }
                    i13 = i4 & Fields.RotationY;
                    if (i13 != 0) {
                    }
                    i16 = i4 & Fields.RotationZ;
                    if (i16 != 0) {
                    }
                    if ((i3 & 48) == 0) {
                    }
                    i19 = i17;
                    i20 = i4 & Fields.TransformOrigin;
                    if (i20 != 0) {
                    }
                    if ((i4 & Fields.Shape) == 0) {
                    }
                    if (startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i19 & 1171) != 1170, i15 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i8 = i4 & 16;
                if (i8 == 0) {
                }
                i9 = i;
                i10 = i4 & 32;
                if (i10 != 0) {
                }
                i11 = i4 & 64;
                if (i11 != 0) {
                }
                if ((i2 & 12582912) == 0) {
                }
                i12 = i4 & Fields.RotationX;
                if (i12 != 0) {
                }
                i13 = i4 & Fields.RotationY;
                if (i13 != 0) {
                }
                i16 = i4 & Fields.RotationZ;
                if (i16 != 0) {
                }
                if ((i3 & 48) == 0) {
                }
                i19 = i17;
                i20 = i4 & Fields.TransformOrigin;
                if (i20 != 0) {
                }
                if ((i4 & Fields.Shape) == 0) {
                }
                if (startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i19 & 1171) != 1170, i15 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i7 = i4 & 8;
            int i332 = Fields.RotationZ;
            if (i7 != 0) {
            }
            i8 = i4 & 16;
            if (i8 == 0) {
            }
            i9 = i;
            i10 = i4 & 32;
            if (i10 != 0) {
            }
            i11 = i4 & 64;
            if (i11 != 0) {
            }
            if ((i2 & 12582912) == 0) {
            }
            i12 = i4 & Fields.RotationX;
            if (i12 != 0) {
            }
            i13 = i4 & Fields.RotationY;
            if (i13 != 0) {
            }
            i16 = i4 & Fields.RotationZ;
            if (i16 != 0) {
            }
            if ((i3 & 48) == 0) {
            }
            i19 = i17;
            i20 = i4 & Fields.TransformOrigin;
            if (i20 != 0) {
            }
            if ((i4 & Fields.Shape) == 0) {
            }
            if (startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i19 & 1171) != 1170, i15 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i6 = i4 & 4;
        if (i6 == 0) {
        }
        i7 = i4 & 8;
        int i3322 = Fields.RotationZ;
        if (i7 != 0) {
        }
        i8 = i4 & 16;
        if (i8 == 0) {
        }
        i9 = i;
        i10 = i4 & 32;
        if (i10 != 0) {
        }
        i11 = i4 & 64;
        if (i11 != 0) {
        }
        if ((i2 & 12582912) == 0) {
        }
        i12 = i4 & Fields.RotationX;
        if (i12 != 0) {
        }
        i13 = i4 & Fields.RotationY;
        if (i13 != 0) {
        }
        i16 = i4 & Fields.RotationZ;
        if (i16 != 0) {
        }
        if ((i3 & 48) == 0) {
        }
        i19 = i17;
        i20 = i4 & Fields.TransformOrigin;
        if (i20 != 0) {
        }
        if ((i4 & Fields.Shape) == 0) {
        }
        if (startRestartGroup.shouldExecute((i15 & 306783379) == 306783378 || (i19 & 1171) != 1170, i15 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    public static final int currentPageOffset(SnapPosition snapPosition, int i, int i2, int i3, int i4, int i5, int i6, float f, int i7) {
        return MathKt.roundToInt(snapPosition.position(i, i2, i4, i5, i6, i7) - (f * (i2 + i3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean pagerSemantics$performForwardPaging(PagerState pagerState, CoroutineScope coroutineScope) {
        if (!pagerState.getCanScrollForward()) {
            return false;
        }
        BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new PagerKt$pagerSemantics$performForwardPaging$1(pagerState, null), 3, (Object) null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean pagerSemantics$performBackwardPaging(PagerState pagerState, CoroutineScope coroutineScope) {
        if (!pagerState.getCanScrollBackward()) {
            return false;
        }
        BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new PagerKt$pagerSemantics$performBackwardPaging$1(pagerState, null), 3, (Object) null);
        return true;
    }

    public static final Modifier pagerSemantics(Modifier modifier, final PagerState pagerState, final boolean z, final CoroutineScope coroutineScope, boolean z2) {
        if (z2) {
            return modifier.then(SemanticsModifierKt.semantics$default(Modifier.INSTANCE, false, new Function1() { // from class: androidx.compose.foundation.pager.PagerKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit pagerSemantics$lambda$9;
                    pagerSemantics$lambda$9 = PagerKt.pagerSemantics$lambda$9(z, pagerState, coroutineScope, (SemanticsPropertyReceiver) obj);
                    return pagerSemantics$lambda$9;
                }
            }, 1, (Object) null));
        }
        return modifier.then(Modifier.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit pagerSemantics$lambda$9(boolean z, final PagerState pagerState, final CoroutineScope coroutineScope, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        if (z) {
            SemanticsPropertiesKt.pageUp$default(semanticsPropertyReceiver, (String) null, new Function0() { // from class: androidx.compose.foundation.pager.PagerKt$$ExternalSyntheticLambda6
                public final Object invoke() {
                    boolean pagerSemantics$performBackwardPaging;
                    pagerSemantics$performBackwardPaging = PagerKt.pagerSemantics$performBackwardPaging(PagerState.this, coroutineScope);
                    return Boolean.valueOf(pagerSemantics$performBackwardPaging);
                }
            }, 1, (Object) null);
            SemanticsPropertiesKt.pageDown$default(semanticsPropertyReceiver, (String) null, new Function0() { // from class: androidx.compose.foundation.pager.PagerKt$$ExternalSyntheticLambda7
                public final Object invoke() {
                    boolean pagerSemantics$performForwardPaging;
                    pagerSemantics$performForwardPaging = PagerKt.pagerSemantics$performForwardPaging(PagerState.this, coroutineScope);
                    return Boolean.valueOf(pagerSemantics$performForwardPaging);
                }
            }, 1, (Object) null);
        } else {
            SemanticsPropertiesKt.pageLeft$default(semanticsPropertyReceiver, (String) null, new Function0() { // from class: androidx.compose.foundation.pager.PagerKt$$ExternalSyntheticLambda8
                public final Object invoke() {
                    boolean pagerSemantics$performBackwardPaging;
                    pagerSemantics$performBackwardPaging = PagerKt.pagerSemantics$performBackwardPaging(PagerState.this, coroutineScope);
                    return Boolean.valueOf(pagerSemantics$performBackwardPaging);
                }
            }, 1, (Object) null);
            SemanticsPropertiesKt.pageRight$default(semanticsPropertyReceiver, (String) null, new Function0() { // from class: androidx.compose.foundation.pager.PagerKt$$ExternalSyntheticLambda9
                public final Object invoke() {
                    boolean pagerSemantics$performForwardPaging;
                    pagerSemantics$performForwardPaging = PagerKt.pagerSemantics$performForwardPaging(PagerState.this, coroutineScope);
                    return Boolean.valueOf(pagerSemantics$performForwardPaging);
                }
            }, 1, (Object) null);
        }
        return Unit.INSTANCE;
    }
}
