package androidx.compose.foundation.lazy.grid;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.OverscrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;

/* compiled from: LazyGridDsl.kt */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\u001a\u008a\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a~\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u001a\u001a\u008a\u0001\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u001d\u001a~\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u001e\u001a\u001d\u0010\u001f\u001a\u00020 2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0003¢\u0006\u0002\u0010!\u001a\u001d\u0010\"\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0003¢\u0006\u0002\u0010#\u001a&\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020&H\u0002\u001aÛ\u0001\u0010*\u001a\u00020\u0001\"\u0004\b\u0000\u0010+*\u00020\u00172\f\u0010*\u001a\b\u0012\u0004\u0012\u0002H+0%2%\b\n\u0010,\u001a\u001f\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u000200\u0018\u00010\u001620\b\n\u00101\u001a*\u0012\u0004\u0012\u000203\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u000204\u0018\u000102¢\u0006\u0002\b\u00182%\b\n\u00105\u001a\u001f\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0006\u0012\u0004\u0018\u0001000\u001623\b\u0004\u00106\u001a-\u0012\u0004\u0012\u000207\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\u000102¢\u0006\u0002\b8¢\u0006\u0002\b\u0018H\u0086\b¢\u0006\u0002\u00109\u001a¯\u0002\u0010:\u001a\u00020\u0001\"\u0004\b\u0000\u0010+*\u00020\u00172\f\u0010*\u001a\b\u0012\u0004\u0012\u0002H+0%2:\b\n\u0010,\u001a4\u0012\u0013\u0012\u00110&¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u000200\u0018\u0001022E\b\n\u00101\u001a?\u0012\u0004\u0012\u000203\u0012\u0013\u0012\u00110&¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u000204\u0018\u00010<¢\u0006\u0002\b\u00182:\b\u0006\u00105\u001a4\u0012\u0013\u0012\u00110&¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0006\u0012\u0004\u0018\u000100022H\b\u0004\u00106\u001aB\u0012\u0004\u0012\u000207\u0012\u0013\u0012\u00110&¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\u00010<¢\u0006\u0002\b8¢\u0006\u0002\b\u0018H\u0086\b¢\u0006\u0002\u0010=\u001aÛ\u0001\u0010*\u001a\u00020\u0001\"\u0004\b\u0000\u0010+*\u00020\u00172\f\u0010*\u001a\b\u0012\u0004\u0012\u0002H+0>2%\b\n\u0010,\u001a\u001f\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u000200\u0018\u00010\u001620\b\n\u00101\u001a*\u0012\u0004\u0012\u000203\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u000204\u0018\u000102¢\u0006\u0002\b\u00182%\b\n\u00105\u001a\u001f\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0006\u0012\u0004\u0018\u0001000\u001623\b\u0004\u00106\u001a-\u0012\u0004\u0012\u000207\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\u000102¢\u0006\u0002\b8¢\u0006\u0002\b\u0018H\u0086\b¢\u0006\u0002\u0010?\u001a¯\u0002\u0010:\u001a\u00020\u0001\"\u0004\b\u0000\u0010+*\u00020\u00172\f\u0010*\u001a\b\u0012\u0004\u0012\u0002H+0>2:\b\n\u0010,\u001a4\u0012\u0013\u0012\u00110&¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u000200\u0018\u0001022E\b\n\u00101\u001a?\u0012\u0004\u0012\u000203\u0012\u0013\u0012\u00110&¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u000204\u0018\u00010<¢\u0006\u0002\b\u00182:\b\u0006\u00105\u001a4\u0012\u0013\u0012\u00110&¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0006\u0012\u0004\u0018\u000100022H\b\u0004\u00106\u001aB\u0012\u0004\u0012\u000207\u0012\u0013\u0012\u00110&¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(;\u0012\u0013\u0012\u0011H+¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\u00010<¢\u0006\u0002\b8¢\u0006\u0002\b\u0018H\u0086\b¢\u0006\u0002\u0010@¨\u0006A"}, d2 = {"LazyVerticalGrid", "", "columns", "Landroidx/compose/foundation/lazy/grid/GridCells;", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/grid/LazyGridScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/OverscrollEffect;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LazyHorizontalGrid", "rows", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/OverscrollEffect;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "rememberColumnWidthSums", "Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;", "rememberRowHeightSums", "(Landroidx/compose/foundation/lazy/grid/GridCells;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;", "calculateCellsCrossAxisSizeImpl", "", "", "gridSize", "slotCount", "spacing", "items", "T", "key", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "item", "", "span", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "contentType", "itemContent", "Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "itemsIndexed", "index", "Lkotlin/Function3;", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "(Landroidx/compose/foundation/lazy/grid/LazyGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class LazyGridDslKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LazyHorizontalGrid$lambda$2(GridCells gridCells, Modifier modifier, LazyGridState lazyGridState, PaddingValues paddingValues, boolean z, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, FlingBehavior flingBehavior, boolean z2, OverscrollEffect overscrollEffect, Function1 function1, int i, int i2, int i3, Composer composer, int i4) {
        LazyHorizontalGrid(gridCells, modifier, lazyGridState, paddingValues, z, horizontal, vertical, flingBehavior, z2, overscrollEffect, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LazyHorizontalGrid$lambda$3(GridCells gridCells, Modifier modifier, LazyGridState lazyGridState, PaddingValues paddingValues, boolean z, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, FlingBehavior flingBehavior, boolean z2, Function1 function1, int i, int i2, Composer composer, int i3) {
        LazyHorizontalGrid(gridCells, modifier, lazyGridState, paddingValues, z, horizontal, vertical, flingBehavior, z2, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LazyVerticalGrid$lambda$0(GridCells gridCells, Modifier modifier, LazyGridState lazyGridState, PaddingValues paddingValues, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, FlingBehavior flingBehavior, boolean z2, OverscrollEffect overscrollEffect, Function1 function1, int i, int i2, int i3, Composer composer, int i4) {
        LazyVerticalGrid(gridCells, modifier, lazyGridState, paddingValues, z, vertical, horizontal, flingBehavior, z2, overscrollEffect, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LazyVerticalGrid$lambda$1(GridCells gridCells, Modifier modifier, LazyGridState lazyGridState, PaddingValues paddingValues, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, FlingBehavior flingBehavior, boolean z2, Function1 function1, int i, int i2, Composer composer, int i3) {
        LazyVerticalGrid(gridCells, modifier, lazyGridState, paddingValues, z, vertical, horizontal, flingBehavior, z2, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:93:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LazyVerticalGrid(final GridCells gridCells, Modifier modifier, LazyGridState lazyGridState, PaddingValues paddingValues, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, FlingBehavior flingBehavior, boolean z2, OverscrollEffect overscrollEffect, final Function1<? super LazyGridScope, Unit> function1, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        int i5;
        PaddingValues paddingValues2;
        int i6;
        boolean z3;
        int i7;
        Arrangement.Horizontal horizontal2;
        int i8;
        int i9;
        Modifier.Companion companion;
        final LazyGridState lazyGridState2;
        final Arrangement.Vertical vertical2;
        final FlingBehavior flingBehavior2;
        final boolean z4;
        final PaddingValues paddingValues3;
        final Arrangement.Horizontal horizontal3;
        final OverscrollEffect overscrollEffect2;
        ScopeUpdateScope endRestartGroup;
        LazyGridState lazyGridState3;
        PaddingValues m1057PaddingValues0680j_4;
        Arrangement.Vertical vertical3;
        Arrangement.Horizontal start;
        FlingBehavior flingBehavior3;
        OverscrollEffect overscrollEffect3;
        int i10;
        boolean z5;
        int i11;
        int i12;
        int i13;
        Composer startRestartGroup = composer.startRestartGroup(-2072102870);
        ComposerKt.sourceInformation(startRestartGroup, "C(LazyVerticalGrid)N(columns,modifier,state,contentPadding,reverseLayout,verticalArrangement,horizontalArrangement,flingBehavior,userScrollEnabled,overscrollEffect,content)81@3849L55,80@3823L511:LazyGridDsl.kt#7791vq");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changed(gridCells) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i14 = i3 & 2;
        if (i14 != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= startRestartGroup.changed(modifier) ? 32 : 16;
            if ((i & 384) == 0) {
                if ((i3 & 4) == 0 && startRestartGroup.changed(lazyGridState)) {
                    i13 = Fields.RotationX;
                    i4 |= i13;
                }
                i13 = Fields.SpotShadowColor;
                i4 |= i13;
            }
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else if ((i & 3072) == 0) {
                paddingValues2 = paddingValues;
                i4 |= startRestartGroup.changed(paddingValues2) ? Fields.CameraDistance : Fields.RotationZ;
                i6 = i3 & 16;
                if (i6 != 0) {
                    i4 |= 24576;
                } else if ((i & 24576) == 0) {
                    z3 = z;
                    i4 |= startRestartGroup.changed(z3) ? Fields.Clip : Fields.Shape;
                    if ((i & 196608) == 0) {
                        i4 |= ((i3 & 32) == 0 && startRestartGroup.changed(vertical)) ? Fields.RenderEffect : 65536;
                    }
                    i7 = i3 & 64;
                    if (i7 == 0) {
                        i4 |= 1572864;
                        horizontal2 = horizontal;
                    } else {
                        horizontal2 = horizontal;
                        if ((i & 1572864) == 0) {
                            i4 |= startRestartGroup.changed(horizontal2) ? 1048576 : Fields.BlendMode;
                        }
                    }
                    if ((i & 12582912) == 0) {
                        if ((i3 & Fields.SpotShadowColor) == 0 && startRestartGroup.changed(flingBehavior)) {
                            i12 = 8388608;
                            i4 |= i12;
                        }
                        i12 = 4194304;
                        i4 |= i12;
                    }
                    i8 = i3 & Fields.RotationX;
                    if (i8 == 0) {
                        i4 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        i4 |= startRestartGroup.changed(z2) ? 67108864 : 33554432;
                    }
                    if ((i & 805306368) == 0) {
                        if ((i3 & Fields.RotationY) == 0 && startRestartGroup.changed(overscrollEffect)) {
                            i11 = 536870912;
                            i4 |= i11;
                        }
                        i11 = 268435456;
                        i4 |= i11;
                    }
                    if ((i3 & Fields.RotationZ) == 0) {
                        i9 = i2 | 6;
                    } else if ((i2 & 6) == 0) {
                        i9 = i2 | (startRestartGroup.changedInstance(function1) ? 4 : 2);
                    } else {
                        i9 = i2;
                    }
                    if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i9 & 3) != 2, i4 & 1)) {
                        startRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(startRestartGroup, "69@3290L23,75@3650L15,77@3748L26");
                        if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                            startRestartGroup.skipToGroupEnd();
                            if ((i3 & 4) != 0) {
                                i4 &= -897;
                            }
                            if ((i3 & 32) != 0) {
                                i4 &= -458753;
                            }
                            if ((i3 & Fields.SpotShadowColor) != 0) {
                                i4 &= -29360129;
                            }
                            if ((i3 & Fields.RotationY) != 0) {
                                i4 &= -1879048193;
                            }
                            companion = modifier;
                            lazyGridState3 = lazyGridState;
                            flingBehavior3 = flingBehavior;
                            overscrollEffect3 = overscrollEffect;
                            i10 = i4;
                            m1057PaddingValues0680j_4 = paddingValues2;
                            start = horizontal2;
                            vertical3 = vertical;
                            z5 = z2;
                        } else {
                            companion = i14 != 0 ? Modifier.INSTANCE : modifier;
                            if ((i3 & 4) != 0) {
                                lazyGridState3 = LazyGridStateKt.rememberLazyGridState(0, 0, startRestartGroup, 0, 3);
                                i4 &= -897;
                            } else {
                                lazyGridState3 = lazyGridState;
                            }
                            m1057PaddingValues0680j_4 = i5 != 0 ? PaddingKt.m1057PaddingValues0680j_4(Dp.constructor-impl(0)) : paddingValues2;
                            if (i6 != 0) {
                                z3 = false;
                            }
                            if ((i3 & 32) != 0) {
                                Arrangement arrangement = Arrangement.INSTANCE;
                                vertical3 = !z3 ? arrangement.getTop() : arrangement.getBottom();
                                i4 &= -458753;
                            } else {
                                vertical3 = vertical;
                            }
                            start = i7 != 0 ? Arrangement.INSTANCE.getStart() : horizontal2;
                            if ((i3 & Fields.SpotShadowColor) != 0) {
                                flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(startRestartGroup, 6);
                                i4 &= -29360129;
                            } else {
                                flingBehavior3 = flingBehavior;
                            }
                            boolean z6 = i8 == 0 ? z2 : true;
                            if ((i3 & Fields.RotationY) != 0) {
                                overscrollEffect3 = OverscrollKt.rememberOverscrollEffect(startRestartGroup, 0);
                                i4 &= -1879048193;
                            } else {
                                overscrollEffect3 = overscrollEffect;
                            }
                            i10 = i4;
                            z5 = z6;
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2072102870, i10, i9, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:79)");
                        }
                        int i15 = i10 >> 3;
                        LazyGridKt.LazyGrid(companion, lazyGridState3, rememberColumnWidthSums(gridCells, start, startRestartGroup, (i10 & 14) | ((i10 >> 15) & 112)), m1057PaddingValues0680j_4, z3, true, flingBehavior3, z5, overscrollEffect3, vertical3, start, function1, startRestartGroup, (i15 & 14) | 196608 | (i15 & 112) | (i10 & 7168) | (i10 & 57344) | (i15 & 3670016) | (i15 & 29360128) | (i15 & 234881024) | ((i10 << 12) & 1879048192), ((i10 >> 18) & 14) | ((i9 << 3) & 112), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        flingBehavior2 = flingBehavior3;
                        horizontal3 = start;
                        PaddingValues paddingValues4 = m1057PaddingValues0680j_4;
                        z4 = z5;
                        lazyGridState2 = lazyGridState3;
                        vertical2 = vertical3;
                        overscrollEffect2 = overscrollEffect3;
                        paddingValues3 = paddingValues4;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        companion = modifier;
                        lazyGridState2 = lazyGridState;
                        vertical2 = vertical;
                        flingBehavior2 = flingBehavior;
                        z4 = z2;
                        paddingValues3 = paddingValues2;
                        horizontal3 = horizontal2;
                        overscrollEffect2 = overscrollEffect;
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        final Modifier modifier2 = companion;
                        final boolean z7 = z3;
                        endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$$ExternalSyntheticLambda2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit LazyVerticalGrid$lambda$0;
                                LazyVerticalGrid$lambda$0 = LazyGridDslKt.LazyVerticalGrid$lambda$0(GridCells.this, modifier2, lazyGridState2, paddingValues3, z7, vertical2, horizontal3, flingBehavior2, z4, overscrollEffect2, function1, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                return LazyVerticalGrid$lambda$0;
                            }
                        });
                        return;
                    }
                    return;
                }
                z3 = z;
                if ((i & 196608) == 0) {
                }
                i7 = i3 & 64;
                if (i7 == 0) {
                }
                if ((i & 12582912) == 0) {
                }
                i8 = i3 & Fields.RotationX;
                if (i8 == 0) {
                }
                if ((i & 805306368) == 0) {
                }
                if ((i3 & Fields.RotationZ) == 0) {
                }
                if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i9 & 3) != 2, i4 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            paddingValues2 = paddingValues;
            i6 = i3 & 16;
            if (i6 != 0) {
            }
            z3 = z;
            if ((i & 196608) == 0) {
            }
            i7 = i3 & 64;
            if (i7 == 0) {
            }
            if ((i & 12582912) == 0) {
            }
            i8 = i3 & Fields.RotationX;
            if (i8 == 0) {
            }
            if ((i & 805306368) == 0) {
            }
            if ((i3 & Fields.RotationZ) == 0) {
            }
            if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i9 & 3) != 2, i4 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        if ((i & 384) == 0) {
        }
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        paddingValues2 = paddingValues;
        i6 = i3 & 16;
        if (i6 != 0) {
        }
        z3 = z;
        if ((i & 196608) == 0) {
        }
        i7 = i3 & 64;
        if (i7 == 0) {
        }
        if ((i & 12582912) == 0) {
        }
        i8 = i3 & Fields.RotationX;
        if (i8 == 0) {
        }
        if ((i & 805306368) == 0) {
        }
        if ((i3 & Fields.RotationZ) == 0) {
        }
        if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i9 & 3) != 2, i4 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void LazyVerticalGrid(final GridCells gridCells, Modifier modifier, LazyGridState lazyGridState, PaddingValues paddingValues, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, FlingBehavior flingBehavior, boolean z2, final Function1 function1, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        PaddingValues paddingValues2;
        int i5;
        boolean z3;
        Arrangement.Vertical vertical2;
        int i6;
        Arrangement.Horizontal horizontal2;
        int i7;
        final Modifier.Companion companion;
        final LazyGridState lazyGridState2;
        final boolean z4;
        final PaddingValues paddingValues3;
        final boolean z5;
        final Arrangement.Vertical vertical3;
        final Arrangement.Horizontal horizontal3;
        final FlingBehavior flingBehavior2;
        ScopeUpdateScope endRestartGroup;
        LazyGridState lazyGridState3;
        PaddingValues m1057PaddingValues0680j_4;
        Arrangement.Vertical vertical4;
        Arrangement.Horizontal start;
        FlingBehavior flingBehavior3;
        int i8;
        FlingBehavior flingBehavior4;
        boolean z6;
        int i9;
        int i10;
        int i11;
        Composer startRestartGroup = composer.startRestartGroup(1485410512);
        ComposerKt.sourceInformation(startRestartGroup, "C(LazyVerticalGrid)N(columns,modifier,state,contentPadding,reverseLayout,verticalArrangement,horizontalArrangement,flingBehavior,userScrollEnabled,content)121@5397L26,111@5001L456:LazyGridDsl.kt#7791vq");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(gridCells) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i12 = i2 & 2;
        if (i12 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? 32 : 16;
            if ((i & 384) == 0) {
                if ((i2 & 4) == 0 && startRestartGroup.changed(lazyGridState)) {
                    i11 = Fields.RotationX;
                    i3 |= i11;
                }
                i11 = Fields.SpotShadowColor;
                i3 |= i11;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                paddingValues2 = paddingValues;
                i3 |= startRestartGroup.changed(paddingValues2) ? Fields.CameraDistance : Fields.RotationZ;
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    z3 = z;
                    i3 |= startRestartGroup.changed(z3) ? Fields.Clip : Fields.Shape;
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            vertical2 = vertical;
                            if (startRestartGroup.changed(vertical2)) {
                                i10 = Fields.RenderEffect;
                                i3 |= i10;
                            }
                        } else {
                            vertical2 = vertical;
                        }
                        i10 = 65536;
                        i3 |= i10;
                    } else {
                        vertical2 = vertical;
                    }
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                    } else if ((1572864 & i) == 0) {
                        horizontal2 = horizontal;
                        i3 |= startRestartGroup.changed(horizontal2) ? 1048576 : Fields.BlendMode;
                        if ((i & 12582912) == 0) {
                            if ((i2 & Fields.SpotShadowColor) == 0 && startRestartGroup.changed(flingBehavior)) {
                                i9 = 8388608;
                                i3 |= i9;
                            }
                            i9 = 4194304;
                            i3 |= i9;
                        }
                        i7 = i2 & Fields.RotationX;
                        if (i7 != 0) {
                            i3 |= 100663296;
                        } else if ((i & 100663296) == 0) {
                            i3 |= startRestartGroup.changed(z2) ? 67108864 : 33554432;
                        }
                        if ((i2 & Fields.RotationY) != 0) {
                            i3 |= 805306368;
                        } else if ((i & 805306368) == 0) {
                            i3 |= startRestartGroup.changedInstance(function1) ? 536870912 : 268435456;
                            if (!startRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                                startRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(startRestartGroup, "101@4538L23,107@4898L15");
                                if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i2 & 4) != 0) {
                                        i3 &= -897;
                                    }
                                    if ((i2 & 32) != 0) {
                                        i3 &= -458753;
                                    }
                                    if ((i2 & Fields.SpotShadowColor) != 0) {
                                        i3 &= -29360129;
                                    }
                                    companion = modifier;
                                    lazyGridState3 = lazyGridState;
                                    flingBehavior4 = flingBehavior;
                                    i8 = i3;
                                    m1057PaddingValues0680j_4 = paddingValues2;
                                    vertical4 = vertical2;
                                    start = horizontal2;
                                } else {
                                    companion = i12 != 0 ? Modifier.INSTANCE : modifier;
                                    if ((i2 & 4) != 0) {
                                        lazyGridState3 = LazyGridStateKt.rememberLazyGridState(0, 0, startRestartGroup, 0, 3);
                                        i3 &= -897;
                                    } else {
                                        lazyGridState3 = lazyGridState;
                                    }
                                    m1057PaddingValues0680j_4 = i4 != 0 ? PaddingKt.m1057PaddingValues0680j_4(Dp.constructor-impl(0)) : paddingValues2;
                                    if (i5 != 0) {
                                        z3 = false;
                                    }
                                    if ((i2 & 32) != 0) {
                                        Arrangement arrangement = Arrangement.INSTANCE;
                                        vertical4 = !z3 ? arrangement.getTop() : arrangement.getBottom();
                                        i3 &= -458753;
                                    } else {
                                        vertical4 = vertical2;
                                    }
                                    start = i6 != 0 ? Arrangement.INSTANCE.getStart() : horizontal2;
                                    if ((i2 & Fields.SpotShadowColor) != 0) {
                                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(startRestartGroup, 6);
                                        i3 &= -29360129;
                                    } else {
                                        flingBehavior3 = flingBehavior;
                                    }
                                    i8 = i3;
                                    if (i7 != 0) {
                                        flingBehavior4 = flingBehavior3;
                                        z6 = true;
                                        startRestartGroup.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1485410512, i8, -1, "androidx.compose.foundation.lazy.grid.LazyVerticalGrid (LazyGridDsl.kt:110)");
                                        }
                                        LazyVerticalGrid(gridCells, companion, lazyGridState3, m1057PaddingValues0680j_4, z3, vertical4, start, flingBehavior4, z6, OverscrollKt.rememberOverscrollEffect(startRestartGroup, 0), function1, startRestartGroup, (i8 & 14) | (i8 & 112) | (i8 & 896) | (i8 & 7168) | (57344 & i8) | (458752 & i8) | (3670016 & i8) | (29360128 & i8) | (234881024 & i8), (i8 >> 27) & 14, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        vertical3 = vertical4;
                                        z5 = z3;
                                        flingBehavior2 = flingBehavior4;
                                        Arrangement.Horizontal horizontal4 = start;
                                        z4 = z6;
                                        lazyGridState2 = lazyGridState3;
                                        paddingValues3 = m1057PaddingValues0680j_4;
                                        horizontal3 = horizontal4;
                                    } else {
                                        flingBehavior4 = flingBehavior3;
                                    }
                                }
                                z6 = z2;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                LazyVerticalGrid(gridCells, companion, lazyGridState3, m1057PaddingValues0680j_4, z3, vertical4, start, flingBehavior4, z6, OverscrollKt.rememberOverscrollEffect(startRestartGroup, 0), function1, startRestartGroup, (i8 & 14) | (i8 & 112) | (i8 & 896) | (i8 & 7168) | (57344 & i8) | (458752 & i8) | (3670016 & i8) | (29360128 & i8) | (234881024 & i8), (i8 >> 27) & 14, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                vertical3 = vertical4;
                                z5 = z3;
                                flingBehavior2 = flingBehavior4;
                                Arrangement.Horizontal horizontal42 = start;
                                z4 = z6;
                                lazyGridState2 = lazyGridState3;
                                paddingValues3 = m1057PaddingValues0680j_4;
                                horizontal3 = horizontal42;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                companion = modifier;
                                lazyGridState2 = lazyGridState;
                                z4 = z2;
                                paddingValues3 = paddingValues2;
                                z5 = z3;
                                vertical3 = vertical2;
                                horizontal3 = horizontal2;
                                flingBehavior2 = flingBehavior;
                            }
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$$ExternalSyntheticLambda5
                                    public final Object invoke(Object obj, Object obj2) {
                                        Unit LazyVerticalGrid$lambda$1;
                                        LazyVerticalGrid$lambda$1 = LazyGridDslKt.LazyVerticalGrid$lambda$1(GridCells.this, companion, lazyGridState2, paddingValues3, z5, vertical3, horizontal3, flingBehavior2, z4, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                        return LazyVerticalGrid$lambda$1;
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        if (!startRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    horizontal2 = horizontal;
                    if ((i & 12582912) == 0) {
                    }
                    i7 = i2 & Fields.RotationX;
                    if (i7 != 0) {
                    }
                    if ((i2 & Fields.RotationY) != 0) {
                    }
                    if (!startRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                z3 = z;
                if ((196608 & i) != 0) {
                }
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                horizontal2 = horizontal;
                if ((i & 12582912) == 0) {
                }
                i7 = i2 & Fields.RotationX;
                if (i7 != 0) {
                }
                if ((i2 & Fields.RotationY) != 0) {
                }
                if (!startRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            paddingValues2 = paddingValues;
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            z3 = z;
            if ((196608 & i) != 0) {
            }
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            horizontal2 = horizontal;
            if ((i & 12582912) == 0) {
            }
            i7 = i2 & Fields.RotationX;
            if (i7 != 0) {
            }
            if ((i2 & Fields.RotationY) != 0) {
            }
            if (!startRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        if ((i & 384) == 0) {
        }
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        paddingValues2 = paddingValues;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        z3 = z;
        if ((196608 & i) != 0) {
        }
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        horizontal2 = horizontal;
        if ((i & 12582912) == 0) {
        }
        i7 = i2 & Fields.RotationX;
        if (i7 != 0) {
        }
        if ((i2 & Fields.RotationY) != 0) {
        }
        if (!startRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:93:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LazyHorizontalGrid(final GridCells gridCells, Modifier modifier, LazyGridState lazyGridState, PaddingValues paddingValues, boolean z, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, FlingBehavior flingBehavior, boolean z2, OverscrollEffect overscrollEffect, final Function1<? super LazyGridScope, Unit> function1, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        int i5;
        PaddingValues paddingValues2;
        int i6;
        boolean z3;
        int i7;
        Arrangement.Vertical vertical2;
        int i8;
        int i9;
        Modifier.Companion companion;
        final LazyGridState lazyGridState2;
        final Arrangement.Horizontal horizontal2;
        final FlingBehavior flingBehavior2;
        final boolean z4;
        final PaddingValues paddingValues3;
        final Arrangement.Vertical vertical3;
        final OverscrollEffect overscrollEffect2;
        ScopeUpdateScope endRestartGroup;
        LazyGridState lazyGridState3;
        PaddingValues m1057PaddingValues0680j_4;
        Arrangement.Horizontal horizontal3;
        Arrangement.Vertical top;
        FlingBehavior flingBehavior3;
        OverscrollEffect overscrollEffect3;
        int i10;
        boolean z5;
        int i11;
        int i12;
        int i13;
        Composer startRestartGroup = composer.startRestartGroup(635941664);
        ComposerKt.sourceInformation(startRestartGroup, "C(LazyHorizontalGrid)N(rows,modifier,state,contentPadding,reverseLayout,horizontalArrangement,verticalArrangement,flingBehavior,userScrollEnabled,overscrollEffect,content)170@7824L48,169@7798L505:LazyGridDsl.kt#7791vq");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changed(gridCells) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i14 = i3 & 2;
        if (i14 != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= startRestartGroup.changed(modifier) ? 32 : 16;
            if ((i & 384) == 0) {
                if ((i3 & 4) == 0 && startRestartGroup.changed(lazyGridState)) {
                    i13 = Fields.RotationX;
                    i4 |= i13;
                }
                i13 = Fields.SpotShadowColor;
                i4 |= i13;
            }
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else if ((i & 3072) == 0) {
                paddingValues2 = paddingValues;
                i4 |= startRestartGroup.changed(paddingValues2) ? Fields.CameraDistance : Fields.RotationZ;
                i6 = i3 & 16;
                if (i6 != 0) {
                    i4 |= 24576;
                } else if ((i & 24576) == 0) {
                    z3 = z;
                    i4 |= startRestartGroup.changed(z3) ? Fields.Clip : Fields.Shape;
                    if ((i & 196608) == 0) {
                        i4 |= ((i3 & 32) == 0 && startRestartGroup.changed(horizontal)) ? Fields.RenderEffect : 65536;
                    }
                    i7 = i3 & 64;
                    if (i7 == 0) {
                        i4 |= 1572864;
                        vertical2 = vertical;
                    } else {
                        vertical2 = vertical;
                        if ((i & 1572864) == 0) {
                            i4 |= startRestartGroup.changed(vertical2) ? 1048576 : Fields.BlendMode;
                        }
                    }
                    if ((i & 12582912) == 0) {
                        if ((i3 & Fields.SpotShadowColor) == 0 && startRestartGroup.changed(flingBehavior)) {
                            i12 = 8388608;
                            i4 |= i12;
                        }
                        i12 = 4194304;
                        i4 |= i12;
                    }
                    i8 = i3 & Fields.RotationX;
                    if (i8 == 0) {
                        i4 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        i4 |= startRestartGroup.changed(z2) ? 67108864 : 33554432;
                    }
                    if ((i & 805306368) == 0) {
                        if ((i3 & Fields.RotationY) == 0 && startRestartGroup.changed(overscrollEffect)) {
                            i11 = 536870912;
                            i4 |= i11;
                        }
                        i11 = 268435456;
                        i4 |= i11;
                    }
                    if ((i3 & Fields.RotationZ) == 0) {
                        i9 = i2 | 6;
                    } else if ((i2 & 6) == 0) {
                        i9 = i2 | (startRestartGroup.changedInstance(function1) ? 4 : 2);
                    } else {
                        i9 = i2;
                    }
                    if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i9 & 3) != 2, i4 & 1)) {
                        startRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(startRestartGroup, "158@7268L23,164@7625L15,166@7723L26");
                        if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                            startRestartGroup.skipToGroupEnd();
                            if ((i3 & 4) != 0) {
                                i4 &= -897;
                            }
                            if ((i3 & 32) != 0) {
                                i4 &= -458753;
                            }
                            if ((i3 & Fields.SpotShadowColor) != 0) {
                                i4 &= -29360129;
                            }
                            if ((i3 & Fields.RotationY) != 0) {
                                i4 &= -1879048193;
                            }
                            companion = modifier;
                            lazyGridState3 = lazyGridState;
                            flingBehavior3 = flingBehavior;
                            overscrollEffect3 = overscrollEffect;
                            i10 = i4;
                            m1057PaddingValues0680j_4 = paddingValues2;
                            top = vertical2;
                            horizontal3 = horizontal;
                            z5 = z2;
                        } else {
                            companion = i14 != 0 ? Modifier.INSTANCE : modifier;
                            if ((i3 & 4) != 0) {
                                lazyGridState3 = LazyGridStateKt.rememberLazyGridState(0, 0, startRestartGroup, 0, 3);
                                i4 &= -897;
                            } else {
                                lazyGridState3 = lazyGridState;
                            }
                            m1057PaddingValues0680j_4 = i5 != 0 ? PaddingKt.m1057PaddingValues0680j_4(Dp.constructor-impl(0)) : paddingValues2;
                            if (i6 != 0) {
                                z3 = false;
                            }
                            if ((i3 & 32) != 0) {
                                Arrangement arrangement = Arrangement.INSTANCE;
                                horizontal3 = !z3 ? arrangement.getStart() : arrangement.getEnd();
                                i4 &= -458753;
                            } else {
                                horizontal3 = horizontal;
                            }
                            top = i7 != 0 ? Arrangement.INSTANCE.getTop() : vertical2;
                            if ((i3 & Fields.SpotShadowColor) != 0) {
                                flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(startRestartGroup, 6);
                                i4 &= -29360129;
                            } else {
                                flingBehavior3 = flingBehavior;
                            }
                            boolean z6 = i8 == 0 ? z2 : true;
                            if ((i3 & Fields.RotationY) != 0) {
                                overscrollEffect3 = OverscrollKt.rememberOverscrollEffect(startRestartGroup, 0);
                                i4 &= -1879048193;
                            } else {
                                overscrollEffect3 = overscrollEffect;
                            }
                            i10 = i4;
                            z5 = z6;
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(635941664, i10, i9, "androidx.compose.foundation.lazy.grid.LazyHorizontalGrid (LazyGridDsl.kt:168)");
                        }
                        int i15 = i10 >> 15;
                        int i16 = i10 >> 3;
                        LazyGridKt.LazyGrid(companion, lazyGridState3, rememberRowHeightSums(gridCells, top, startRestartGroup, (i10 & 14) | (i15 & 112)), m1057PaddingValues0680j_4, z3, false, flingBehavior3, z5, overscrollEffect3, top, horizontal3, function1, startRestartGroup, (i16 & 14) | 196608 | (i16 & 112) | (i10 & 7168) | (i10 & 57344) | (i16 & 3670016) | (i16 & 29360128) | (i16 & 234881024) | ((i10 << 9) & 1879048192), (i15 & 14) | ((i9 << 3) & 112), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        flingBehavior2 = flingBehavior3;
                        vertical3 = top;
                        PaddingValues paddingValues4 = m1057PaddingValues0680j_4;
                        z4 = z5;
                        lazyGridState2 = lazyGridState3;
                        horizontal2 = horizontal3;
                        overscrollEffect2 = overscrollEffect3;
                        paddingValues3 = paddingValues4;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        companion = modifier;
                        lazyGridState2 = lazyGridState;
                        horizontal2 = horizontal;
                        flingBehavior2 = flingBehavior;
                        z4 = z2;
                        paddingValues3 = paddingValues2;
                        vertical3 = vertical2;
                        overscrollEffect2 = overscrollEffect;
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        final Modifier modifier2 = companion;
                        final boolean z7 = z3;
                        endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj, Object obj2) {
                                Unit LazyHorizontalGrid$lambda$2;
                                LazyHorizontalGrid$lambda$2 = LazyGridDslKt.LazyHorizontalGrid$lambda$2(GridCells.this, modifier2, lazyGridState2, paddingValues3, z7, horizontal2, vertical3, flingBehavior2, z4, overscrollEffect2, function1, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                return LazyHorizontalGrid$lambda$2;
                            }
                        });
                        return;
                    }
                    return;
                }
                z3 = z;
                if ((i & 196608) == 0) {
                }
                i7 = i3 & 64;
                if (i7 == 0) {
                }
                if ((i & 12582912) == 0) {
                }
                i8 = i3 & Fields.RotationX;
                if (i8 == 0) {
                }
                if ((i & 805306368) == 0) {
                }
                if ((i3 & Fields.RotationZ) == 0) {
                }
                if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i9 & 3) != 2, i4 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            paddingValues2 = paddingValues;
            i6 = i3 & 16;
            if (i6 != 0) {
            }
            z3 = z;
            if ((i & 196608) == 0) {
            }
            i7 = i3 & 64;
            if (i7 == 0) {
            }
            if ((i & 12582912) == 0) {
            }
            i8 = i3 & Fields.RotationX;
            if (i8 == 0) {
            }
            if ((i & 805306368) == 0) {
            }
            if ((i3 & Fields.RotationZ) == 0) {
            }
            if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i9 & 3) != 2, i4 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        if ((i & 384) == 0) {
        }
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        paddingValues2 = paddingValues;
        i6 = i3 & 16;
        if (i6 != 0) {
        }
        z3 = z;
        if ((i & 196608) == 0) {
        }
        i7 = i3 & 64;
        if (i7 == 0) {
        }
        if ((i & 12582912) == 0) {
        }
        i8 = i3 & Fields.RotationX;
        if (i8 == 0) {
        }
        if ((i & 805306368) == 0) {
        }
        if ((i3 & Fields.RotationZ) == 0) {
        }
        if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i9 & 3) != 2, i4 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void LazyHorizontalGrid(final GridCells gridCells, Modifier modifier, LazyGridState lazyGridState, PaddingValues paddingValues, boolean z, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, FlingBehavior flingBehavior, boolean z2, final Function1 function1, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        PaddingValues paddingValues2;
        int i5;
        boolean z3;
        Arrangement.Horizontal horizontal2;
        int i6;
        Arrangement.Vertical vertical2;
        int i7;
        final Modifier.Companion companion;
        final LazyGridState lazyGridState2;
        final boolean z4;
        final PaddingValues paddingValues3;
        final boolean z5;
        final Arrangement.Horizontal horizontal3;
        final Arrangement.Vertical vertical3;
        final FlingBehavior flingBehavior2;
        ScopeUpdateScope endRestartGroup;
        LazyGridState lazyGridState3;
        PaddingValues m1057PaddingValues0680j_4;
        Arrangement.Horizontal horizontal4;
        Arrangement.Vertical top;
        FlingBehavior flingBehavior3;
        int i8;
        FlingBehavior flingBehavior4;
        boolean z6;
        int i9;
        int i10;
        int i11;
        Composer startRestartGroup = composer.startRestartGroup(2123608858);
        ComposerKt.sourceInformation(startRestartGroup, "C(LazyHorizontalGrid)N(rows,modifier,state,contentPadding,reverseLayout,horizontalArrangement,verticalArrangement,flingBehavior,userScrollEnabled,content)210@9358L26,200@8966L452:LazyGridDsl.kt#7791vq");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(gridCells) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i12 = i2 & 2;
        if (i12 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? 32 : 16;
            if ((i & 384) == 0) {
                if ((i2 & 4) == 0 && startRestartGroup.changed(lazyGridState)) {
                    i11 = Fields.RotationX;
                    i3 |= i11;
                }
                i11 = Fields.SpotShadowColor;
                i3 |= i11;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                paddingValues2 = paddingValues;
                i3 |= startRestartGroup.changed(paddingValues2) ? Fields.CameraDistance : Fields.RotationZ;
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    z3 = z;
                    i3 |= startRestartGroup.changed(z3) ? Fields.Clip : Fields.Shape;
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            horizontal2 = horizontal;
                            if (startRestartGroup.changed(horizontal2)) {
                                i10 = Fields.RenderEffect;
                                i3 |= i10;
                            }
                        } else {
                            horizontal2 = horizontal;
                        }
                        i10 = 65536;
                        i3 |= i10;
                    } else {
                        horizontal2 = horizontal;
                    }
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                    } else if ((1572864 & i) == 0) {
                        vertical2 = vertical;
                        i3 |= startRestartGroup.changed(vertical2) ? 1048576 : Fields.BlendMode;
                        if ((i & 12582912) == 0) {
                            if ((i2 & Fields.SpotShadowColor) == 0 && startRestartGroup.changed(flingBehavior)) {
                                i9 = 8388608;
                                i3 |= i9;
                            }
                            i9 = 4194304;
                            i3 |= i9;
                        }
                        i7 = i2 & Fields.RotationX;
                        if (i7 != 0) {
                            i3 |= 100663296;
                        } else if ((i & 100663296) == 0) {
                            i3 |= startRestartGroup.changed(z2) ? 67108864 : 33554432;
                        }
                        if ((i2 & Fields.RotationY) != 0) {
                            i3 |= 805306368;
                        } else if ((i & 805306368) == 0) {
                            i3 |= startRestartGroup.changedInstance(function1) ? 536870912 : 268435456;
                            if (!startRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                                startRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(startRestartGroup, "190@8506L23,196@8863L15");
                                if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i2 & 4) != 0) {
                                        i3 &= -897;
                                    }
                                    if ((i2 & 32) != 0) {
                                        i3 &= -458753;
                                    }
                                    if ((i2 & Fields.SpotShadowColor) != 0) {
                                        i3 &= -29360129;
                                    }
                                    companion = modifier;
                                    lazyGridState3 = lazyGridState;
                                    flingBehavior4 = flingBehavior;
                                    i8 = i3;
                                    m1057PaddingValues0680j_4 = paddingValues2;
                                    horizontal4 = horizontal2;
                                    top = vertical2;
                                } else {
                                    companion = i12 != 0 ? Modifier.INSTANCE : modifier;
                                    if ((i2 & 4) != 0) {
                                        lazyGridState3 = LazyGridStateKt.rememberLazyGridState(0, 0, startRestartGroup, 0, 3);
                                        i3 &= -897;
                                    } else {
                                        lazyGridState3 = lazyGridState;
                                    }
                                    m1057PaddingValues0680j_4 = i4 != 0 ? PaddingKt.m1057PaddingValues0680j_4(Dp.constructor-impl(0)) : paddingValues2;
                                    if (i5 != 0) {
                                        z3 = false;
                                    }
                                    if ((i2 & 32) != 0) {
                                        Arrangement arrangement = Arrangement.INSTANCE;
                                        horizontal4 = !z3 ? arrangement.getStart() : arrangement.getEnd();
                                        i3 &= -458753;
                                    } else {
                                        horizontal4 = horizontal2;
                                    }
                                    top = i6 != 0 ? Arrangement.INSTANCE.getTop() : vertical2;
                                    if ((i2 & Fields.SpotShadowColor) != 0) {
                                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(startRestartGroup, 6);
                                        i3 &= -29360129;
                                    } else {
                                        flingBehavior3 = flingBehavior;
                                    }
                                    i8 = i3;
                                    if (i7 != 0) {
                                        flingBehavior4 = flingBehavior3;
                                        z6 = true;
                                        startRestartGroup.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(2123608858, i8, -1, "androidx.compose.foundation.lazy.grid.LazyHorizontalGrid (LazyGridDsl.kt:199)");
                                        }
                                        LazyHorizontalGrid(gridCells, companion, lazyGridState3, m1057PaddingValues0680j_4, z3, horizontal4, top, flingBehavior4, z6, OverscrollKt.rememberOverscrollEffect(startRestartGroup, 0), function1, startRestartGroup, (i8 & 14) | (i8 & 112) | (i8 & 896) | (i8 & 7168) | (57344 & i8) | (458752 & i8) | (3670016 & i8) | (29360128 & i8) | (234881024 & i8), (i8 >> 27) & 14, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        horizontal3 = horizontal4;
                                        z5 = z3;
                                        flingBehavior2 = flingBehavior4;
                                        Arrangement.Vertical vertical4 = top;
                                        z4 = z6;
                                        lazyGridState2 = lazyGridState3;
                                        paddingValues3 = m1057PaddingValues0680j_4;
                                        vertical3 = vertical4;
                                    } else {
                                        flingBehavior4 = flingBehavior3;
                                    }
                                }
                                z6 = z2;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                LazyHorizontalGrid(gridCells, companion, lazyGridState3, m1057PaddingValues0680j_4, z3, horizontal4, top, flingBehavior4, z6, OverscrollKt.rememberOverscrollEffect(startRestartGroup, 0), function1, startRestartGroup, (i8 & 14) | (i8 & 112) | (i8 & 896) | (i8 & 7168) | (57344 & i8) | (458752 & i8) | (3670016 & i8) | (29360128 & i8) | (234881024 & i8), (i8 >> 27) & 14, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                horizontal3 = horizontal4;
                                z5 = z3;
                                flingBehavior2 = flingBehavior4;
                                Arrangement.Vertical vertical42 = top;
                                z4 = z6;
                                lazyGridState2 = lazyGridState3;
                                paddingValues3 = m1057PaddingValues0680j_4;
                                vertical3 = vertical42;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                companion = modifier;
                                lazyGridState2 = lazyGridState;
                                z4 = z2;
                                paddingValues3 = paddingValues2;
                                z5 = z3;
                                horizontal3 = horizontal2;
                                vertical3 = vertical2;
                                flingBehavior2 = flingBehavior;
                            }
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$$ExternalSyntheticLambda0
                                    public final Object invoke(Object obj, Object obj2) {
                                        Unit LazyHorizontalGrid$lambda$3;
                                        LazyHorizontalGrid$lambda$3 = LazyGridDslKt.LazyHorizontalGrid$lambda$3(GridCells.this, companion, lazyGridState2, paddingValues3, z5, horizontal3, vertical3, flingBehavior2, z4, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                        return LazyHorizontalGrid$lambda$3;
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        if (!startRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    vertical2 = vertical;
                    if ((i & 12582912) == 0) {
                    }
                    i7 = i2 & Fields.RotationX;
                    if (i7 != 0) {
                    }
                    if ((i2 & Fields.RotationY) != 0) {
                    }
                    if (!startRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                z3 = z;
                if ((196608 & i) != 0) {
                }
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                vertical2 = vertical;
                if ((i & 12582912) == 0) {
                }
                i7 = i2 & Fields.RotationX;
                if (i7 != 0) {
                }
                if ((i2 & Fields.RotationY) != 0) {
                }
                if (!startRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            paddingValues2 = paddingValues;
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            z3 = z;
            if ((196608 & i) != 0) {
            }
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            vertical2 = vertical;
            if ((i & 12582912) == 0) {
            }
            i7 = i2 & Fields.RotationX;
            if (i7 != 0) {
            }
            if ((i2 & Fields.RotationY) != 0) {
            }
            if (!startRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        if ((i & 384) == 0) {
        }
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        paddingValues2 = paddingValues;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        z3 = z;
        if ((196608 & i) != 0) {
        }
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        vertical2 = vertical;
        if ((i & 12582912) == 0) {
        }
        i7 = i2 & Fields.RotationX;
        if (i7 != 0) {
        }
        if ((i2 & Fields.RotationY) != 0) {
        }
        if (!startRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    private static final LazyGridSlotsProvider rememberColumnWidthSums(final GridCells gridCells, final Arrangement.Horizontal horizontal, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -76500289, "C(rememberColumnWidthSums)N(columns,horizontalArrangement)221@9599L849:LazyGridDsl.kt#7791vq");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-76500289, i, -1, "androidx.compose.foundation.lazy.grid.rememberColumnWidthSums (LazyGridDsl.kt:221)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -502328624, "CC(remember):LazyGridDsl.kt#9igjgp");
        boolean z = ((((i & 14) ^ 6) > 4 && composer.changed(gridCells)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changed(horizontal)) || (i & 48) == 32);
        GridSlotCache rememberedValue = composer.rememberedValue();
        if (z || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new GridSlotCache(new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    LazyGridSlots rememberColumnWidthSums$lambda$9$lambda$8;
                    rememberColumnWidthSums$lambda$9$lambda$8 = LazyGridDslKt.rememberColumnWidthSums$lambda$9$lambda$8(GridCells.this, horizontal, (Density) obj, (Constraints) obj2);
                    return rememberColumnWidthSums$lambda$9$lambda$8;
                }
            });
            composer.updateRememberedValue(rememberedValue);
        }
        LazyGridSlotsProvider lazyGridSlotsProvider = (LazyGridSlotsProvider) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return lazyGridSlotsProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LazyGridSlots rememberColumnWidthSums$lambda$9$lambda$8(GridCells gridCells, Arrangement.Horizontal horizontal, Density density, Constraints constraints) {
        if (!(Constraints.getMaxWidth-impl(constraints.unbox-impl()) != Integer.MAX_VALUE)) {
            InlineClassHelperKt.throwIllegalArgumentException("LazyVerticalGrid's width should be bound by parent.");
        }
        int i = Constraints.getMaxWidth-impl(constraints.unbox-impl());
        int[] intArray = CollectionsKt.toIntArray(gridCells.calculateCrossAxisCellSizes(density, i, density.roundToPx-0680j_4(horizontal.getSpacing())));
        int[] iArr = new int[intArray.length];
        horizontal.arrange(density, i, intArray, LayoutDirection.Ltr, iArr);
        return new LazyGridSlots(intArray, iArr);
    }

    private static final LazyGridSlotsProvider rememberRowHeightSums(final GridCells gridCells, final Arrangement.Vertical vertical, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -150818144, "C(rememberRowHeightSums)N(rows,verticalArrangement)245@10605L772:LazyGridDsl.kt#7791vq");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-150818144, i, -1, "androidx.compose.foundation.lazy.grid.rememberRowHeightSums (LazyGridDsl.kt:245)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1092656036, "CC(remember):LazyGridDsl.kt#9igjgp");
        boolean z = ((((i & 14) ^ 6) > 4 && composer.changed(gridCells)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changed(vertical)) || (i & 48) == 32);
        GridSlotCache rememberedValue = composer.rememberedValue();
        if (z || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new GridSlotCache(new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    LazyGridSlots rememberRowHeightSums$lambda$15$lambda$14;
                    rememberRowHeightSums$lambda$15$lambda$14 = LazyGridDslKt.rememberRowHeightSums$lambda$15$lambda$14(GridCells.this, vertical, (Density) obj, (Constraints) obj2);
                    return rememberRowHeightSums$lambda$15$lambda$14;
                }
            });
            composer.updateRememberedValue(rememberedValue);
        }
        LazyGridSlotsProvider lazyGridSlotsProvider = (LazyGridSlotsProvider) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return lazyGridSlotsProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LazyGridSlots rememberRowHeightSums$lambda$15$lambda$14(GridCells gridCells, Arrangement.Vertical vertical, Density density, Constraints constraints) {
        if (!(Constraints.getMaxHeight-impl(constraints.unbox-impl()) != Integer.MAX_VALUE)) {
            InlineClassHelperKt.throwIllegalArgumentException("LazyHorizontalGrid's height should be bound by parent.");
        }
        int i = Constraints.getMaxHeight-impl(constraints.unbox-impl());
        int[] intArray = CollectionsKt.toIntArray(gridCells.calculateCrossAxisCellSizes(density, i, density.roundToPx-0680j_4(vertical.getSpacing())));
        int[] iArr = new int[intArray.length];
        vertical.arrange(density, i, intArray, iArr);
        return new LazyGridSlots(intArray, iArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Integer> calculateCellsCrossAxisSizeImpl(int i, int i2, int i3) {
        int i4 = i - (i3 * (i2 - 1));
        int i5 = i4 / i2;
        int i6 = i4 % i2;
        ArrayList arrayList = new ArrayList(i2);
        int i7 = 0;
        while (i7 < i2) {
            arrayList.add(Integer.valueOf((i7 < i6 ? 1 : 0) + i5));
            i7++;
        }
        return arrayList;
    }

    public static /* synthetic */ void items$default(LazyGridScope lazyGridScope, List list, Function1 function1, Function2 function2, Function1 function12, Function4 function4, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            function2 = null;
        }
        if ((i & 8) != 0) {
            function12 = new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$1
                /* renamed from: invoke, reason: collision with other method in class */
                public final Void m1237invoke(T t) {
                    return null;
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    return m1237invoke((LazyGridDslKt$items$1) obj2);
                }
            };
        }
        lazyGridScope.items(list.size(), function1 != null ? new LazyGridDslKt$items$2(function1, list) : null, function2 != null ? new LazyGridDslKt$items$3(function2, list) : null, new LazyGridDslKt$items$4(function12, list), ComposableLambdaKt.composableLambdaInstance(-1117249557, true, new LazyGridDslKt$items$5(function4, list)));
    }

    public static final <T> void items(LazyGridScope lazyGridScope, List<? extends T> list, Function1<? super T, ? extends Object> function1, Function2<? super LazyGridItemSpanScope, ? super T, GridItemSpan> function2, Function1<? super T, ? extends Object> function12, Function4<? super LazyGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4) {
        lazyGridScope.items(list.size(), function1 != null ? new LazyGridDslKt$items$2(function1, list) : null, function2 != null ? new LazyGridDslKt$items$3(function2, list) : null, new LazyGridDslKt$items$4(function12, list), ComposableLambdaKt.composableLambdaInstance(-1117249557, true, new LazyGridDslKt$items$5(function4, list)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyGridScope lazyGridScope, List list, Function2 function2, Function3 function3, Function2 function22, Function5 function5, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            function3 = null;
        }
        if ((i & 8) != 0) {
            function22 = new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$1
                public final Void invoke(int i2, T t) {
                    return null;
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    return invoke(((Number) obj2).intValue(), (int) obj3);
                }
            };
        }
        lazyGridScope.items(list.size(), function2 != null ? new LazyGridDslKt$itemsIndexed$2(function2, list) : null, function3 != null ? new LazyGridDslKt$itemsIndexed$3(function3, list) : null, new LazyGridDslKt$itemsIndexed$4(function22, list), ComposableLambdaKt.composableLambdaInstance(-1942245546, true, new LazyGridDslKt$itemsIndexed$5(function5, list)));
    }

    public static final <T> void itemsIndexed(LazyGridScope lazyGridScope, List<? extends T> list, Function2<? super Integer, ? super T, ? extends Object> function2, Function3<? super LazyGridItemSpanScope, ? super Integer, ? super T, GridItemSpan> function3, Function2<? super Integer, ? super T, ? extends Object> function22, Function5<? super LazyGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5) {
        lazyGridScope.items(list.size(), function2 != null ? new LazyGridDslKt$itemsIndexed$2(function2, list) : null, function3 != null ? new LazyGridDslKt$itemsIndexed$3(function3, list) : null, new LazyGridDslKt$itemsIndexed$4(function22, list), ComposableLambdaKt.composableLambdaInstance(-1942245546, true, new LazyGridDslKt$itemsIndexed$5(function5, list)));
    }

    public static /* synthetic */ void items$default(LazyGridScope lazyGridScope, Object[] objArr, Function1 function1, Function2 function2, Function1 function12, Function4 function4, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            function2 = null;
        }
        if ((i & 8) != 0) {
            function12 = new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$items$6
                /* renamed from: invoke, reason: collision with other method in class */
                public final Void m1239invoke(T t) {
                    return null;
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    return m1239invoke((LazyGridDslKt$items$6) obj2);
                }
            };
        }
        lazyGridScope.items(objArr.length, function1 != null ? new LazyGridDslKt$items$7(function1, objArr) : null, function2 != null ? new LazyGridDslKt$items$8(function2, objArr) : null, new LazyGridDslKt$items$9(function12, objArr), ComposableLambdaKt.composableLambdaInstance(1179065086, true, new LazyGridDslKt$items$10(function4, objArr)));
    }

    public static final <T> void items(LazyGridScope lazyGridScope, T[] tArr, Function1<? super T, ? extends Object> function1, Function2<? super LazyGridItemSpanScope, ? super T, GridItemSpan> function2, Function1<? super T, ? extends Object> function12, Function4<? super LazyGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4) {
        lazyGridScope.items(tArr.length, function1 != null ? new LazyGridDslKt$items$7(function1, tArr) : null, function2 != null ? new LazyGridDslKt$items$8(function2, tArr) : null, new LazyGridDslKt$items$9(function12, tArr), ComposableLambdaKt.composableLambdaInstance(1179065086, true, new LazyGridDslKt$items$10(function4, tArr)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyGridScope lazyGridScope, Object[] objArr, Function2 function2, Function3 function3, Function2 function22, Function5 function5, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            function3 = null;
        }
        if ((i & 8) != 0) {
            function22 = new Function2() { // from class: androidx.compose.foundation.lazy.grid.LazyGridDslKt$itemsIndexed$6
                public final Void invoke(int i2, T t) {
                    return null;
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    return invoke(((Number) obj2).intValue(), (int) obj3);
                }
            };
        }
        lazyGridScope.items(objArr.length, function2 != null ? new LazyGridDslKt$itemsIndexed$7(function2, objArr) : null, function3 != null ? new LazyGridDslKt$itemsIndexed$8(function3, objArr) : null, new LazyGridDslKt$itemsIndexed$9(function22, objArr), ComposableLambdaKt.composableLambdaInstance(49283819, true, new LazyGridDslKt$itemsIndexed$10(function5, objArr)));
    }

    public static final <T> void itemsIndexed(LazyGridScope lazyGridScope, T[] tArr, Function2<? super Integer, ? super T, ? extends Object> function2, Function3<? super LazyGridItemSpanScope, ? super Integer, ? super T, GridItemSpan> function3, Function2<? super Integer, ? super T, ? extends Object> function22, Function5<? super LazyGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5) {
        lazyGridScope.items(tArr.length, function2 != null ? new LazyGridDslKt$itemsIndexed$7(function2, tArr) : null, function3 != null ? new LazyGridDslKt$itemsIndexed$8(function3, tArr) : null, new LazyGridDslKt$itemsIndexed$9(function22, tArr), ComposableLambdaKt.composableLambdaInstance(49283819, true, new LazyGridDslKt$itemsIndexed$10(function5, tArr)));
    }
}
