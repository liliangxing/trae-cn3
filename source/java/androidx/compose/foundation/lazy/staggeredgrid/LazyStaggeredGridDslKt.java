package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.OverscrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
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
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;

/* compiled from: LazyStaggeredGridDsl.kt */
@Metadata(d1 = {"\u0000 \u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\u001a\u008c\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0080\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0004\b\u001b\u0010\u001c\u001a%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010\u001f\u001a\u008c\u0001\u0010 \u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0004\b%\u0010&\u001a\u0080\u0001\u0010 \u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0004\b'\u0010(\u001a%\u0010)\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020#2\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010*\u001aÐ\u0001\u0010+\u001a\u00020\u0001\"\u0004\b\u0000\u0010,*\u00020\u00172\f\u0010+\u001a\b\u0012\u0004\u0012\u0002H,0-2%\b\n\u0010.\u001a\u001f\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u000202\u0018\u00010\u00162%\b\u0006\u00103\u001a\u001f\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0006\u0012\u0004\u0018\u0001020\u00162%\b\n\u00104\u001a\u001f\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u000205\u0018\u00010\u001623\b\u0004\u00106\u001a-\u0012\u0004\u0012\u000208\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020\u000107¢\u0006\u0002\b9¢\u0006\u0002\b\u0018H\u0086\b¢\u0006\u0002\u0010:\u001a¤\u0002\u0010;\u001a\u00020\u0001\"\u0004\b\u0000\u0010,*\u00020\u00172\f\u0010+\u001a\b\u0012\u0004\u0012\u0002H,0-2:\b\n\u0010.\u001a4\u0012\u0013\u0012\u00110<¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u000202\u0018\u0001072:\b\u0006\u00103\u001a4\u0012\u0013\u0012\u00110<¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0006\u0012\u0004\u0018\u000102072:\b\n\u00104\u001a4\u0012\u0013\u0012\u00110<¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u000205\u0018\u0001072H\b\u0004\u00106\u001aB\u0012\u0004\u0012\u000208\u0012\u0013\u0012\u00110<¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020\u00010>¢\u0006\u0002\b9¢\u0006\u0002\b\u0018H\u0086\b¢\u0006\u0002\u0010?\u001aÐ\u0001\u0010+\u001a\u00020\u0001\"\u0004\b\u0000\u0010,*\u00020\u00172\f\u0010+\u001a\b\u0012\u0004\u0012\u0002H,0@2%\b\n\u0010.\u001a\u001f\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u000202\u0018\u00010\u00162%\b\u0006\u00103\u001a\u001f\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0006\u0012\u0004\u0018\u0001020\u00162%\b\n\u00104\u001a\u001f\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u000205\u0018\u00010\u001623\b\u0004\u00106\u001a-\u0012\u0004\u0012\u000208\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020\u000107¢\u0006\u0002\b9¢\u0006\u0002\b\u0018H\u0086\b¢\u0006\u0002\u0010A\u001a¤\u0002\u0010;\u001a\u00020\u0001\"\u0004\b\u0000\u0010,*\u00020\u00172\f\u0010+\u001a\b\u0012\u0004\u0012\u0002H,0@2:\b\n\u0010.\u001a4\u0012\u0013\u0012\u00110<¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u000202\u0018\u0001072:\b\u0006\u00103\u001a4\u0012\u0013\u0012\u00110<¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0006\u0012\u0004\u0018\u000102072:\b\n\u00104\u001a4\u0012\u0013\u0012\u00110<¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u000205\u0018\u0001072H\b\u0004\u00106\u001aB\u0012\u0004\u0012\u000208\u0012\u0013\u0012\u00110<¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(=\u0012\u0013\u0012\u0011H,¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020\u00010>¢\u0006\u0002\b9¢\u0006\u0002\b\u0018H\u0086\b¢\u0006\u0002\u0010B¨\u0006C"}, d2 = {"LazyVerticalStaggeredGrid", "", "columns", "Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "verticalItemSpacing", "Landroidx/compose/ui/unit/Dp;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;", "Lkotlin/ExtensionFunctionType;", "LazyVerticalStaggeredGrid-6qCrX9Q", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/layout/PaddingValues;ZFLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/OverscrollEffect;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "LazyVerticalStaggeredGrid-zadm560", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/layout/PaddingValues;ZFLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "rememberColumnSlots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;", "LazyHorizontalStaggeredGrid", "rows", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalItemSpacing", "LazyHorizontalStaggeredGrid-121YqSk", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;FLandroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/OverscrollEffect;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "LazyHorizontalStaggeredGrid-cJHQLPU", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;FLandroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "rememberRowSlots", "(Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridCells;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;", "items", "T", "", "key", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "item", "", "contentType", "span", "Landroidx/compose/foundation/lazy/staggeredgrid/StaggeredGridItemSpan;", "itemContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemScope;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "itemsIndexed", "", "index", "Lkotlin/Function3;", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class LazyStaggeredGridDslKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LazyHorizontalStaggeredGrid_121YqSk$lambda$8(StaggeredGridCells staggeredGridCells, Modifier modifier, LazyStaggeredGridState lazyStaggeredGridState, PaddingValues paddingValues, boolean z, Arrangement.Vertical vertical, float f, FlingBehavior flingBehavior, boolean z2, OverscrollEffect overscrollEffect, Function1 function1, int i, int i2, int i3, Composer composer, int i4) {
        m1351LazyHorizontalStaggeredGrid121YqSk(staggeredGridCells, modifier, lazyStaggeredGridState, paddingValues, z, vertical, f, flingBehavior, z2, overscrollEffect, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LazyHorizontalStaggeredGrid_cJHQLPU$lambda$9(StaggeredGridCells staggeredGridCells, Modifier modifier, LazyStaggeredGridState lazyStaggeredGridState, PaddingValues paddingValues, boolean z, Arrangement.Vertical vertical, float f, FlingBehavior flingBehavior, boolean z2, Function1 function1, int i, int i2, Composer composer, int i3) {
        m1352LazyHorizontalStaggeredGridcJHQLPU(staggeredGridCells, modifier, lazyStaggeredGridState, paddingValues, z, vertical, f, flingBehavior, z2, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LazyVerticalStaggeredGrid_6qCrX9Q$lambda$0(StaggeredGridCells staggeredGridCells, Modifier modifier, LazyStaggeredGridState lazyStaggeredGridState, PaddingValues paddingValues, boolean z, float f, Arrangement.Horizontal horizontal, FlingBehavior flingBehavior, boolean z2, OverscrollEffect overscrollEffect, Function1 function1, int i, int i2, int i3, Composer composer, int i4) {
        m1353LazyVerticalStaggeredGrid6qCrX9Q(staggeredGridCells, modifier, lazyStaggeredGridState, paddingValues, z, f, horizontal, flingBehavior, z2, overscrollEffect, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LazyVerticalStaggeredGrid_zadm560$lambda$1(StaggeredGridCells staggeredGridCells, Modifier modifier, LazyStaggeredGridState lazyStaggeredGridState, PaddingValues paddingValues, boolean z, float f, Arrangement.Horizontal horizontal, FlingBehavior flingBehavior, boolean z2, Function1 function1, int i, int i2, Composer composer, int i3) {
        m1354LazyVerticalStaggeredGridzadm560(staggeredGridCells, modifier, lazyStaggeredGridState, paddingValues, z, f, horizontal, flingBehavior, z2, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:85:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [int] */
    /* renamed from: LazyVerticalStaggeredGrid-6qCrX9Q, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1353LazyVerticalStaggeredGrid6qCrX9Q(final StaggeredGridCells staggeredGridCells, Modifier modifier, LazyStaggeredGridState lazyStaggeredGridState, PaddingValues paddingValues, boolean z, float f, Arrangement.Horizontal horizontal, FlingBehavior flingBehavior, boolean z2, OverscrollEffect overscrollEffect, final Function1<? super LazyStaggeredGridScope, Unit> function1, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        int i5;
        PaddingValues paddingValues2;
        int i6;
        boolean z3;
        int i7;
        int i8;
        int i9;
        int i10;
        Modifier.Companion companion;
        final LazyStaggeredGridState lazyStaggeredGridState2;
        final float f2;
        final Arrangement.Horizontal horizontal2;
        final FlingBehavior flingBehavior2;
        final boolean z4;
        final PaddingValues paddingValues3;
        final OverscrollEffect overscrollEffect2;
        ScopeUpdateScope endRestartGroup;
        ?? r6;
        LazyStaggeredGridState lazyStaggeredGridState3;
        PaddingValues m1057PaddingValues0680j_4;
        float f3;
        Arrangement.HorizontalOrVertical m909spacedBy0680j_4;
        FlingBehavior flingBehavior3;
        OverscrollEffect overscrollEffect3;
        int i11;
        boolean z5;
        LazyStaggeredGridState lazyStaggeredGridState4;
        int i12;
        int i13;
        int i14;
        Composer startRestartGroup = composer.startRestartGroup(-578931208);
        ComposerKt.sourceInformation(startRestartGroup, "C(LazyVerticalStaggeredGrid)N(columns,modifier,state,contentPadding,reverseLayout,verticalItemSpacing:c#ui.unit.Dp,horizontalArrangement,flingBehavior,userScrollEnabled,overscrollEffect,content)93@4432L67,82@3985L548:LazyStaggeredGridDsl.kt#fzvcnm");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changed(staggeredGridCells) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i15 = i3 & 2;
        if (i15 != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= startRestartGroup.changed(modifier) ? 32 : 16;
            if ((i & 384) == 0) {
                if ((i3 & 4) == 0 && startRestartGroup.changed(lazyStaggeredGridState)) {
                    i14 = Fields.RotationX;
                    i4 |= i14;
                }
                i14 = Fields.SpotShadowColor;
                i4 |= i14;
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
                    i7 = i3 & 32;
                    if (i7 == 0) {
                        i4 |= 196608;
                    } else if ((i & 196608) == 0) {
                        i4 |= startRestartGroup.changed(f) ? Fields.RenderEffect : 65536;
                    }
                    i8 = i3 & 64;
                    if (i8 == 0) {
                        i4 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        i4 |= startRestartGroup.changed(horizontal) ? 1048576 : Fields.BlendMode;
                    }
                    if ((i & 12582912) == 0) {
                        if ((i3 & Fields.SpotShadowColor) == 0 && startRestartGroup.changed(flingBehavior)) {
                            i13 = 8388608;
                            i4 |= i13;
                        }
                        i13 = 4194304;
                        i4 |= i13;
                    }
                    i9 = i3 & Fields.RotationX;
                    if (i9 == 0) {
                        i4 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        i4 |= startRestartGroup.changed(z2) ? 67108864 : 33554432;
                    }
                    if ((i & 805306368) == 0) {
                        if ((i3 & Fields.RotationY) == 0 && startRestartGroup.changed(overscrollEffect)) {
                            i12 = 536870912;
                            i4 |= i12;
                        }
                        i12 = 268435456;
                        i4 |= i12;
                    }
                    if ((i3 & Fields.RotationZ) == 0) {
                        i10 = i2 | 6;
                    } else if ((i2 & 6) == 0) {
                        i10 = i2 | (startRestartGroup.changedInstance(function1) ? 4 : 2);
                    } else {
                        i10 = i2;
                    }
                    if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i10 & 3) != 2, i4 & 1)) {
                        startRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(startRestartGroup, "72@3506L32,77@3803L15,79@3901L26");
                        if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                            startRestartGroup.skipToGroupEnd();
                            if ((i3 & 4) != 0) {
                                i4 &= -897;
                            }
                            if ((i3 & Fields.SpotShadowColor) != 0) {
                                i4 &= -29360129;
                            }
                            if ((i3 & Fields.RotationY) != 0) {
                                i4 &= -1879048193;
                            }
                            companion = modifier;
                            lazyStaggeredGridState4 = lazyStaggeredGridState;
                            m909spacedBy0680j_4 = horizontal;
                            flingBehavior3 = flingBehavior;
                            overscrollEffect3 = overscrollEffect;
                            i11 = i4;
                            m1057PaddingValues0680j_4 = paddingValues2;
                            f3 = f;
                            z5 = z2;
                        } else {
                            companion = i15 != 0 ? Modifier.INSTANCE : modifier;
                            if ((i3 & 4) != 0) {
                                r6 = 0;
                                lazyStaggeredGridState3 = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, startRestartGroup, 0, 3);
                                i4 &= -897;
                            } else {
                                r6 = 0;
                                lazyStaggeredGridState3 = lazyStaggeredGridState;
                            }
                            m1057PaddingValues0680j_4 = i5 != 0 ? PaddingKt.m1057PaddingValues0680j_4(Dp.constructor-impl((float) r6)) : paddingValues2;
                            if (i6 != 0) {
                                z3 = r6;
                            }
                            f3 = i7 != 0 ? Dp.constructor-impl((float) r6) : f;
                            m909spacedBy0680j_4 = i8 != 0 ? Arrangement.INSTANCE.m909spacedBy0680j_4(Dp.constructor-impl((float) r6)) : horizontal;
                            if ((i3 & Fields.SpotShadowColor) != 0) {
                                flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(startRestartGroup, 6);
                                i4 &= -29360129;
                            } else {
                                flingBehavior3 = flingBehavior;
                            }
                            boolean z6 = i9 == 0 ? z2 : true;
                            if ((i3 & Fields.RotationY) != 0) {
                                i4 &= -1879048193;
                                overscrollEffect3 = OverscrollKt.rememberOverscrollEffect(startRestartGroup, 0);
                            } else {
                                overscrollEffect3 = overscrollEffect;
                            }
                            i11 = i4;
                            z5 = z6;
                            lazyStaggeredGridState4 = lazyStaggeredGridState3;
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-578931208, i11, i10, "androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid (LazyStaggeredGridDsl.kt:81)");
                        }
                        Orientation orientation = Orientation.Vertical;
                        float spacing = m909spacedBy0680j_4.getSpacing();
                        int i16 = i11 >> 3;
                        int i17 = i11 << 3;
                        LazyStaggeredGridKt.m1360LazyStaggeredGridw41Enmo(lazyStaggeredGridState4, orientation, rememberColumnSlots(staggeredGridCells, m909spacedBy0680j_4, m1057PaddingValues0680j_4, startRestartGroup, (i11 & 14) | ((i11 >> 15) & 112) | (i16 & 896)), companion, m1057PaddingValues0680j_4, z3, flingBehavior3, z5, overscrollEffect3, f3, spacing, function1, startRestartGroup, ((i11 >> 6) & 14) | 48 | ((i11 << 6) & 7168) | (i17 & 57344) | (i17 & 458752) | (3670016 & i16) | (29360128 & i16) | (i16 & 234881024) | ((i11 << 12) & 1879048192), (i10 << 3) & 112, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        paddingValues3 = m1057PaddingValues0680j_4;
                        flingBehavior2 = flingBehavior3;
                        z4 = z5;
                        lazyStaggeredGridState2 = lazyStaggeredGridState4;
                        OverscrollEffect overscrollEffect4 = overscrollEffect3;
                        horizontal2 = m909spacedBy0680j_4;
                        f2 = f3;
                        overscrollEffect2 = overscrollEffect4;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        companion = modifier;
                        lazyStaggeredGridState2 = lazyStaggeredGridState;
                        f2 = f;
                        horizontal2 = horizontal;
                        flingBehavior2 = flingBehavior;
                        z4 = z2;
                        paddingValues3 = paddingValues2;
                        overscrollEffect2 = overscrollEffect;
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        final Modifier modifier2 = companion;
                        final boolean z7 = z3;
                        endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$$ExternalSyntheticLambda4
                            public final Object invoke(Object obj, Object obj2) {
                                Unit LazyVerticalStaggeredGrid_6qCrX9Q$lambda$0;
                                LazyVerticalStaggeredGrid_6qCrX9Q$lambda$0 = LazyStaggeredGridDslKt.LazyVerticalStaggeredGrid_6qCrX9Q$lambda$0(StaggeredGridCells.this, modifier2, lazyStaggeredGridState2, paddingValues3, z7, f2, horizontal2, flingBehavior2, z4, overscrollEffect2, function1, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                return LazyVerticalStaggeredGrid_6qCrX9Q$lambda$0;
                            }
                        });
                        return;
                    }
                    return;
                }
                z3 = z;
                i7 = i3 & 32;
                if (i7 == 0) {
                }
                i8 = i3 & 64;
                if (i8 == 0) {
                }
                if ((i & 12582912) == 0) {
                }
                i9 = i3 & Fields.RotationX;
                if (i9 == 0) {
                }
                if ((i & 805306368) == 0) {
                }
                if ((i3 & Fields.RotationZ) == 0) {
                }
                if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i10 & 3) != 2, i4 & 1)) {
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
            i7 = i3 & 32;
            if (i7 == 0) {
            }
            i8 = i3 & 64;
            if (i8 == 0) {
            }
            if ((i & 12582912) == 0) {
            }
            i9 = i3 & Fields.RotationX;
            if (i9 == 0) {
            }
            if ((i & 805306368) == 0) {
            }
            if ((i3 & Fields.RotationZ) == 0) {
            }
            if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i10 & 3) != 2, i4 & 1)) {
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
        i7 = i3 & 32;
        if (i7 == 0) {
        }
        i8 = i3 & 64;
        if (i8 == 0) {
        }
        if ((i & 12582912) == 0) {
        }
        i9 = i3 & Fields.RotationX;
        if (i9 == 0) {
        }
        if ((i & 805306368) == 0) {
        }
        if ((i3 & Fields.RotationZ) == 0) {
        }
        if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i10 & 3) != 2, i4 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    /* renamed from: LazyVerticalStaggeredGrid-zadm560, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m1354LazyVerticalStaggeredGridzadm560(final StaggeredGridCells staggeredGridCells, Modifier modifier, LazyStaggeredGridState lazyStaggeredGridState, PaddingValues paddingValues, boolean z, float f, Arrangement.Horizontal horizontal, FlingBehavior flingBehavior, boolean z2, final Function1 function1, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        PaddingValues paddingValues2;
        int i5;
        boolean z3;
        int i6;
        float f2;
        int i7;
        int i8;
        final Modifier.Companion companion;
        final LazyStaggeredGridState lazyStaggeredGridState2;
        final Arrangement.Horizontal horizontal2;
        final boolean z4;
        final PaddingValues paddingValues3;
        final boolean z5;
        final float f3;
        final FlingBehavior flingBehavior2;
        ScopeUpdateScope endRestartGroup;
        LazyStaggeredGridState lazyStaggeredGridState3;
        PaddingValues m1057PaddingValues0680j_4;
        float f4;
        Arrangement.HorizontalOrVertical m909spacedBy0680j_4;
        FlingBehavior flingBehavior3;
        int i9;
        FlingBehavior flingBehavior4;
        boolean z6;
        int i10;
        int i11;
        Composer startRestartGroup = composer.startRestartGroup(1695323794);
        ComposerKt.sourceInformation(startRestartGroup, "C(LazyVerticalStaggeredGrid)N(columns,modifier,state,contentPadding,reverseLayout,verticalItemSpacing:c#ui.unit.Dp,horizontalArrangement,flingBehavior,userScrollEnabled,content)122@5578L26,112@5173L465:LazyStaggeredGridDsl.kt#fzvcnm");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(staggeredGridCells) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i12 = i2 & 2;
        if (i12 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? 32 : 16;
            if ((i & 384) == 0) {
                if ((i2 & 4) == 0 && startRestartGroup.changed(lazyStaggeredGridState)) {
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
                    i6 = i2 & 32;
                    if (i6 == 0) {
                        i3 |= 196608;
                    } else if ((196608 & i) == 0) {
                        f2 = f;
                        i3 |= startRestartGroup.changed(f2) ? Fields.RenderEffect : 65536;
                        i7 = i2 & 64;
                        if (i7 != 0) {
                            i3 |= 1572864;
                        } else if ((i & 1572864) == 0) {
                            i3 |= startRestartGroup.changed(horizontal) ? 1048576 : Fields.BlendMode;
                        }
                        if ((i & 12582912) == 0) {
                            if ((i2 & Fields.SpotShadowColor) == 0 && startRestartGroup.changed(flingBehavior)) {
                                i10 = 8388608;
                                i3 |= i10;
                            }
                            i10 = 4194304;
                            i3 |= i10;
                        }
                        i8 = i2 & Fields.RotationX;
                        if (i8 != 0) {
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
                                ComposerKt.sourceInformation(startRestartGroup, "103@4764L32,108@5061L15");
                                if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i2 & 4) != 0) {
                                        i3 &= -897;
                                    }
                                    if ((i2 & Fields.SpotShadowColor) != 0) {
                                        i3 &= -29360129;
                                    }
                                    companion = modifier;
                                    lazyStaggeredGridState3 = lazyStaggeredGridState;
                                    m909spacedBy0680j_4 = horizontal;
                                    flingBehavior4 = flingBehavior;
                                    i9 = i3;
                                    m1057PaddingValues0680j_4 = paddingValues2;
                                    f4 = f2;
                                } else {
                                    companion = i12 != 0 ? Modifier.INSTANCE : modifier;
                                    if ((i2 & 4) != 0) {
                                        lazyStaggeredGridState3 = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, startRestartGroup, 0, 3);
                                        i3 &= -897;
                                    } else {
                                        lazyStaggeredGridState3 = lazyStaggeredGridState;
                                    }
                                    m1057PaddingValues0680j_4 = i4 != 0 ? PaddingKt.m1057PaddingValues0680j_4(Dp.constructor-impl(0)) : paddingValues2;
                                    if (i5 != 0) {
                                        z3 = false;
                                    }
                                    f4 = i6 != 0 ? Dp.constructor-impl(0) : f2;
                                    m909spacedBy0680j_4 = i7 != 0 ? Arrangement.INSTANCE.m909spacedBy0680j_4(Dp.constructor-impl(0)) : horizontal;
                                    if ((i2 & Fields.SpotShadowColor) != 0) {
                                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(startRestartGroup, 6);
                                        i3 &= -29360129;
                                    } else {
                                        flingBehavior3 = flingBehavior;
                                    }
                                    i9 = i3;
                                    if (i8 != 0) {
                                        flingBehavior4 = flingBehavior3;
                                        z6 = true;
                                        startRestartGroup.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1695323794, i9, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid (LazyStaggeredGridDsl.kt:111)");
                                        }
                                        m1353LazyVerticalStaggeredGrid6qCrX9Q(staggeredGridCells, companion, lazyStaggeredGridState3, m1057PaddingValues0680j_4, z3, f4, m909spacedBy0680j_4, flingBehavior4, z6, OverscrollKt.rememberOverscrollEffect(startRestartGroup, 0), function1, startRestartGroup, (i9 & 14) | (i9 & 112) | (i9 & 896) | (i9 & 7168) | (57344 & i9) | (458752 & i9) | (3670016 & i9) | (29360128 & i9) | (234881024 & i9), (i9 >> 27) & 14, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        f3 = f4;
                                        z5 = z3;
                                        flingBehavior2 = flingBehavior4;
                                        Arrangement.Horizontal horizontal3 = m909spacedBy0680j_4;
                                        z4 = z6;
                                        lazyStaggeredGridState2 = lazyStaggeredGridState3;
                                        paddingValues3 = m1057PaddingValues0680j_4;
                                        horizontal2 = horizontal3;
                                    } else {
                                        flingBehavior4 = flingBehavior3;
                                    }
                                }
                                z6 = z2;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                m1353LazyVerticalStaggeredGrid6qCrX9Q(staggeredGridCells, companion, lazyStaggeredGridState3, m1057PaddingValues0680j_4, z3, f4, m909spacedBy0680j_4, flingBehavior4, z6, OverscrollKt.rememberOverscrollEffect(startRestartGroup, 0), function1, startRestartGroup, (i9 & 14) | (i9 & 112) | (i9 & 896) | (i9 & 7168) | (57344 & i9) | (458752 & i9) | (3670016 & i9) | (29360128 & i9) | (234881024 & i9), (i9 >> 27) & 14, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                f3 = f4;
                                z5 = z3;
                                flingBehavior2 = flingBehavior4;
                                Arrangement.Horizontal horizontal32 = m909spacedBy0680j_4;
                                z4 = z6;
                                lazyStaggeredGridState2 = lazyStaggeredGridState3;
                                paddingValues3 = m1057PaddingValues0680j_4;
                                horizontal2 = horizontal32;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                companion = modifier;
                                lazyStaggeredGridState2 = lazyStaggeredGridState;
                                horizontal2 = horizontal;
                                z4 = z2;
                                paddingValues3 = paddingValues2;
                                z5 = z3;
                                f3 = f2;
                                flingBehavior2 = flingBehavior;
                            }
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$$ExternalSyntheticLambda3
                                    public final Object invoke(Object obj, Object obj2) {
                                        Unit LazyVerticalStaggeredGrid_zadm560$lambda$1;
                                        LazyVerticalStaggeredGrid_zadm560$lambda$1 = LazyStaggeredGridDslKt.LazyVerticalStaggeredGrid_zadm560$lambda$1(StaggeredGridCells.this, companion, lazyStaggeredGridState2, paddingValues3, z5, f3, horizontal2, flingBehavior2, z4, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                        return LazyVerticalStaggeredGrid_zadm560$lambda$1;
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
                    f2 = f;
                    i7 = i2 & 64;
                    if (i7 != 0) {
                    }
                    if ((i & 12582912) == 0) {
                    }
                    i8 = i2 & Fields.RotationX;
                    if (i8 != 0) {
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
                i6 = i2 & 32;
                if (i6 == 0) {
                }
                f2 = f;
                i7 = i2 & 64;
                if (i7 != 0) {
                }
                if ((i & 12582912) == 0) {
                }
                i8 = i2 & Fields.RotationX;
                if (i8 != 0) {
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
            i6 = i2 & 32;
            if (i6 == 0) {
            }
            f2 = f;
            i7 = i2 & 64;
            if (i7 != 0) {
            }
            if ((i & 12582912) == 0) {
            }
            i8 = i2 & Fields.RotationX;
            if (i8 != 0) {
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
        i6 = i2 & 32;
        if (i6 == 0) {
        }
        f2 = f;
        i7 = i2 & 64;
        if (i7 != 0) {
        }
        if ((i & 12582912) == 0) {
        }
        i8 = i2 & Fields.RotationX;
        if (i8 != 0) {
        }
        if ((i2 & Fields.RotationY) != 0) {
        }
        if (!startRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    private static final LazyGridStaggeredGridSlotsProvider rememberColumnSlots(final StaggeredGridCells staggeredGridCells, final Arrangement.Horizontal horizontal, final PaddingValues paddingValues, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1267076841, "C(rememberColumnSlots)N(columns,horizontalArrangement,contentPadding)134@5881L1194:LazyStaggeredGridDsl.kt#fzvcnm");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1267076841, i, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberColumnSlots (LazyStaggeredGridDsl.kt:134)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2109874561, "CC(remember):LazyStaggeredGridDsl.kt#9igjgp");
        boolean z = ((((i & 14) ^ 6) > 4 && composer.changed(staggeredGridCells)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changed(horizontal)) || (i & 48) == 32) | ((((i & 896) ^ 384) > 256 && composer.changed(paddingValues)) || (i & 384) == 256);
        LazyStaggeredGridSlotCache rememberedValue = composer.rememberedValue();
        if (z || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new LazyStaggeredGridSlotCache(new Function2() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    LazyStaggeredGridSlots rememberColumnSlots$lambda$7$lambda$6;
                    rememberColumnSlots$lambda$7$lambda$6 = LazyStaggeredGridDslKt.rememberColumnSlots$lambda$7$lambda$6(PaddingValues.this, staggeredGridCells, horizontal, (Density) obj, (Constraints) obj2);
                    return rememberColumnSlots$lambda$7$lambda$6;
                }
            });
            composer.updateRememberedValue(rememberedValue);
        }
        LazyGridStaggeredGridSlotsProvider lazyGridStaggeredGridSlotsProvider = (LazyGridStaggeredGridSlotsProvider) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return lazyGridStaggeredGridSlotsProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LazyStaggeredGridSlots rememberColumnSlots$lambda$7$lambda$6(PaddingValues paddingValues, StaggeredGridCells staggeredGridCells, Arrangement.Horizontal horizontal, Density density, Constraints constraints) {
        if (!(Constraints.getMaxWidth-impl(constraints.unbox-impl()) != Integer.MAX_VALUE)) {
            InlineClassHelperKt.throwIllegalArgumentException("LazyVerticalStaggeredGrid's width should be bound by parent.");
        }
        int i = Constraints.getMaxWidth-impl(constraints.unbox-impl()) - density.roundToPx-0680j_4(Dp.constructor-impl(PaddingKt.calculateStartPadding(paddingValues, LayoutDirection.Ltr) + PaddingKt.calculateEndPadding(paddingValues, LayoutDirection.Ltr)));
        int[] calculateCrossAxisCellSizes = staggeredGridCells.calculateCrossAxisCellSizes(density, i, density.roundToPx-0680j_4(horizontal.getSpacing()));
        int[] iArr = new int[calculateCrossAxisCellSizes.length];
        horizontal.arrange(density, i, calculateCrossAxisCellSizes, LayoutDirection.Ltr, iArr);
        return new LazyStaggeredGridSlots(iArr, calculateCrossAxisCellSizes);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:85:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [int] */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* renamed from: LazyHorizontalStaggeredGrid-121YqSk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1351LazyHorizontalStaggeredGrid121YqSk(final StaggeredGridCells staggeredGridCells, Modifier modifier, LazyStaggeredGridState lazyStaggeredGridState, PaddingValues paddingValues, boolean z, Arrangement.Vertical vertical, float f, FlingBehavior flingBehavior, boolean z2, OverscrollEffect overscrollEffect, final Function1<? super LazyStaggeredGridScope, Unit> function1, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        int i5;
        PaddingValues paddingValues2;
        int i6;
        boolean z3;
        int i7;
        int i8;
        int i9;
        int i10;
        Modifier.Companion companion;
        final LazyStaggeredGridState lazyStaggeredGridState2;
        final Arrangement.Vertical vertical2;
        final float f2;
        final FlingBehavior flingBehavior2;
        final boolean z4;
        final PaddingValues paddingValues3;
        final OverscrollEffect overscrollEffect2;
        ScopeUpdateScope endRestartGroup;
        ?? r6;
        LazyStaggeredGridState lazyStaggeredGridState3;
        PaddingValues m1057PaddingValues0680j_4;
        Arrangement.HorizontalOrVertical m909spacedBy0680j_4;
        float f3;
        FlingBehavior flingBehavior3;
        OverscrollEffect overscrollEffect3;
        int i11;
        boolean z5;
        LazyStaggeredGridState lazyStaggeredGridState4;
        int i12;
        int i13;
        int i14;
        Composer startRestartGroup = composer.startRestartGroup(-670735644);
        ComposerKt.sourceInformation(startRestartGroup, "C(LazyHorizontalStaggeredGrid)N(rows,modifier,state,contentPadding,reverseLayout,verticalArrangement,horizontalItemSpacing:c#ui.unit.Dp,flingBehavior,userScrollEnabled,overscrollEffect,content)214@9926L59,203@9477L542:LazyStaggeredGridDsl.kt#fzvcnm");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changed(staggeredGridCells) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i15 = i3 & 2;
        if (i15 != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= startRestartGroup.changed(modifier) ? 32 : 16;
            if ((i & 384) == 0) {
                if ((i3 & 4) == 0 && startRestartGroup.changed(lazyStaggeredGridState)) {
                    i14 = Fields.RotationX;
                    i4 |= i14;
                }
                i14 = Fields.SpotShadowColor;
                i4 |= i14;
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
                    i7 = i3 & 32;
                    if (i7 == 0) {
                        i4 |= 196608;
                    } else if ((i & 196608) == 0) {
                        i4 |= startRestartGroup.changed(vertical) ? Fields.RenderEffect : 65536;
                    }
                    i8 = i3 & 64;
                    if (i8 == 0) {
                        i4 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        i4 |= startRestartGroup.changed(f) ? 1048576 : Fields.BlendMode;
                    }
                    if ((i & 12582912) == 0) {
                        if ((i3 & Fields.SpotShadowColor) == 0 && startRestartGroup.changed(flingBehavior)) {
                            i13 = 8388608;
                            i4 |= i13;
                        }
                        i13 = 4194304;
                        i4 |= i13;
                    }
                    i9 = i3 & Fields.RotationX;
                    if (i9 == 0) {
                        i4 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        i4 |= startRestartGroup.changed(z2) ? 67108864 : 33554432;
                    }
                    if ((i & 805306368) == 0) {
                        if ((i3 & Fields.RotationY) == 0 && startRestartGroup.changed(overscrollEffect)) {
                            i12 = 536870912;
                            i4 |= i12;
                        }
                        i12 = 268435456;
                        i4 |= i12;
                    }
                    if ((i3 & Fields.RotationZ) == 0) {
                        i10 = i2 | 6;
                    } else if ((i2 & 6) == 0) {
                        i10 = i2 | (startRestartGroup.changedInstance(function1) ? 4 : 2);
                    } else {
                        i10 = i2;
                    }
                    if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i10 & 3) != 2, i4 & 1)) {
                        startRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(startRestartGroup, "193@9000L32,198@9295L15,200@9393L26");
                        if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                            startRestartGroup.skipToGroupEnd();
                            if ((i3 & 4) != 0) {
                                i4 &= -897;
                            }
                            if ((i3 & Fields.SpotShadowColor) != 0) {
                                i4 &= -29360129;
                            }
                            if ((i3 & Fields.RotationY) != 0) {
                                i4 &= -1879048193;
                            }
                            companion = modifier;
                            lazyStaggeredGridState4 = lazyStaggeredGridState;
                            f3 = f;
                            flingBehavior3 = flingBehavior;
                            overscrollEffect3 = overscrollEffect;
                            i11 = i4;
                            m1057PaddingValues0680j_4 = paddingValues2;
                            m909spacedBy0680j_4 = vertical;
                            z5 = z2;
                        } else {
                            companion = i15 != 0 ? Modifier.INSTANCE : modifier;
                            if ((i3 & 4) != 0) {
                                r6 = 0;
                                lazyStaggeredGridState3 = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, startRestartGroup, 0, 3);
                                i4 &= -897;
                            } else {
                                r6 = 0;
                                lazyStaggeredGridState3 = lazyStaggeredGridState;
                            }
                            m1057PaddingValues0680j_4 = i5 != 0 ? PaddingKt.m1057PaddingValues0680j_4(Dp.constructor-impl((float) r6)) : paddingValues2;
                            if (i6 != 0) {
                                z3 = r6;
                            }
                            m909spacedBy0680j_4 = i7 != 0 ? Arrangement.INSTANCE.m909spacedBy0680j_4(Dp.constructor-impl((float) r6)) : vertical;
                            f3 = i8 != 0 ? Dp.constructor-impl((float) r6) : f;
                            if ((i3 & Fields.SpotShadowColor) != 0) {
                                flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(startRestartGroup, 6);
                                i4 &= -29360129;
                            } else {
                                flingBehavior3 = flingBehavior;
                            }
                            boolean z6 = i9 == 0 ? z2 : true;
                            if ((i3 & Fields.RotationY) != 0) {
                                i4 &= -1879048193;
                                overscrollEffect3 = OverscrollKt.rememberOverscrollEffect(startRestartGroup, 0);
                            } else {
                                overscrollEffect3 = overscrollEffect;
                            }
                            i11 = i4;
                            z5 = z6;
                            lazyStaggeredGridState4 = lazyStaggeredGridState3;
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-670735644, i11, i10, "androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid (LazyStaggeredGridDsl.kt:202)");
                        }
                        Orientation orientation = Orientation.Horizontal;
                        float spacing = m909spacedBy0680j_4.getSpacing();
                        int i16 = i11 >> 3;
                        int i17 = i11 << 3;
                        LazyStaggeredGridKt.m1360LazyStaggeredGridw41Enmo(lazyStaggeredGridState4, orientation, rememberRowSlots(staggeredGridCells, m909spacedBy0680j_4, m1057PaddingValues0680j_4, startRestartGroup, (i11 & 14) | ((i11 >> 12) & 112) | (i16 & 896)), companion, m1057PaddingValues0680j_4, z3, flingBehavior3, z5, overscrollEffect3, f3, spacing, function1, startRestartGroup, ((i11 >> 6) & 14) | 48 | ((i11 << 6) & 7168) | (i17 & 57344) | (i17 & 458752) | (3670016 & i16) | (29360128 & i16) | (i16 & 234881024) | ((i11 << 9) & 1879048192), (i10 << 3) & 112, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        paddingValues3 = m1057PaddingValues0680j_4;
                        flingBehavior2 = flingBehavior3;
                        z4 = z5;
                        lazyStaggeredGridState2 = lazyStaggeredGridState4;
                        OverscrollEffect overscrollEffect4 = overscrollEffect3;
                        f2 = f3;
                        vertical2 = m909spacedBy0680j_4;
                        overscrollEffect2 = overscrollEffect4;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        companion = modifier;
                        lazyStaggeredGridState2 = lazyStaggeredGridState;
                        vertical2 = vertical;
                        f2 = f;
                        flingBehavior2 = flingBehavior;
                        z4 = z2;
                        paddingValues3 = paddingValues2;
                        overscrollEffect2 = overscrollEffect;
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        final Modifier modifier2 = companion;
                        final boolean z7 = z3;
                        endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$$ExternalSyntheticLambda5
                            public final Object invoke(Object obj, Object obj2) {
                                Unit LazyHorizontalStaggeredGrid_121YqSk$lambda$8;
                                LazyHorizontalStaggeredGrid_121YqSk$lambda$8 = LazyStaggeredGridDslKt.LazyHorizontalStaggeredGrid_121YqSk$lambda$8(StaggeredGridCells.this, modifier2, lazyStaggeredGridState2, paddingValues3, z7, vertical2, f2, flingBehavior2, z4, overscrollEffect2, function1, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                return LazyHorizontalStaggeredGrid_121YqSk$lambda$8;
                            }
                        });
                        return;
                    }
                    return;
                }
                z3 = z;
                i7 = i3 & 32;
                if (i7 == 0) {
                }
                i8 = i3 & 64;
                if (i8 == 0) {
                }
                if ((i & 12582912) == 0) {
                }
                i9 = i3 & Fields.RotationX;
                if (i9 == 0) {
                }
                if ((i & 805306368) == 0) {
                }
                if ((i3 & Fields.RotationZ) == 0) {
                }
                if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i10 & 3) != 2, i4 & 1)) {
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
            i7 = i3 & 32;
            if (i7 == 0) {
            }
            i8 = i3 & 64;
            if (i8 == 0) {
            }
            if ((i & 12582912) == 0) {
            }
            i9 = i3 & Fields.RotationX;
            if (i9 == 0) {
            }
            if ((i & 805306368) == 0) {
            }
            if ((i3 & Fields.RotationZ) == 0) {
            }
            if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i10 & 3) != 2, i4 & 1)) {
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
        i7 = i3 & 32;
        if (i7 == 0) {
        }
        i8 = i3 & 64;
        if (i8 == 0) {
        }
        if ((i & 12582912) == 0) {
        }
        i9 = i3 & Fields.RotationX;
        if (i9 == 0) {
        }
        if ((i & 805306368) == 0) {
        }
        if ((i3 & Fields.RotationZ) == 0) {
        }
        if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i10 & 3) != 2, i4 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    /* renamed from: LazyHorizontalStaggeredGrid-cJHQLPU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m1352LazyHorizontalStaggeredGridcJHQLPU(final StaggeredGridCells staggeredGridCells, Modifier modifier, LazyStaggeredGridState lazyStaggeredGridState, PaddingValues paddingValues, boolean z, Arrangement.Vertical vertical, float f, FlingBehavior flingBehavior, boolean z2, final Function1 function1, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        PaddingValues paddingValues2;
        int i5;
        boolean z3;
        int i6;
        Arrangement.Vertical vertical2;
        int i7;
        int i8;
        final Modifier.Companion companion;
        final LazyStaggeredGridState lazyStaggeredGridState2;
        final float f2;
        final boolean z4;
        final PaddingValues paddingValues3;
        final boolean z5;
        final Arrangement.Vertical vertical3;
        final FlingBehavior flingBehavior2;
        ScopeUpdateScope endRestartGroup;
        LazyStaggeredGridState lazyStaggeredGridState3;
        PaddingValues m1057PaddingValues0680j_4;
        Arrangement.HorizontalOrVertical m909spacedBy0680j_4;
        float f3;
        FlingBehavior flingBehavior3;
        int i9;
        FlingBehavior flingBehavior4;
        boolean z6;
        int i10;
        int i11;
        Composer startRestartGroup = composer.startRestartGroup(-8666074);
        ComposerKt.sourceInformation(startRestartGroup, "C(LazyHorizontalStaggeredGrid)N(rows,modifier,state,contentPadding,reverseLayout,verticalArrangement,horizontalItemSpacing:c#ui.unit.Dp,flingBehavior,userScrollEnabled,content)243@11057L26,233@10656L461:LazyStaggeredGridDsl.kt#fzvcnm");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(staggeredGridCells) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i12 = i2 & 2;
        if (i12 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? 32 : 16;
            if ((i & 384) == 0) {
                if ((i2 & 4) == 0 && startRestartGroup.changed(lazyStaggeredGridState)) {
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
                    i6 = i2 & 32;
                    if (i6 == 0) {
                        i3 |= 196608;
                    } else if ((196608 & i) == 0) {
                        vertical2 = vertical;
                        i3 |= startRestartGroup.changed(vertical2) ? Fields.RenderEffect : 65536;
                        i7 = i2 & 64;
                        if (i7 != 0) {
                            i3 |= 1572864;
                        } else if ((i & 1572864) == 0) {
                            i3 |= startRestartGroup.changed(f) ? 1048576 : Fields.BlendMode;
                        }
                        if ((i & 12582912) == 0) {
                            if ((i2 & Fields.SpotShadowColor) == 0 && startRestartGroup.changed(flingBehavior)) {
                                i10 = 8388608;
                                i3 |= i10;
                            }
                            i10 = 4194304;
                            i3 |= i10;
                        }
                        i8 = i2 & Fields.RotationX;
                        if (i8 != 0) {
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
                                ComposerKt.sourceInformation(startRestartGroup, "224@10249L32,229@10544L15");
                                if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i2 & 4) != 0) {
                                        i3 &= -897;
                                    }
                                    if ((i2 & Fields.SpotShadowColor) != 0) {
                                        i3 &= -29360129;
                                    }
                                    companion = modifier;
                                    lazyStaggeredGridState3 = lazyStaggeredGridState;
                                    f3 = f;
                                    flingBehavior4 = flingBehavior;
                                    i9 = i3;
                                    m1057PaddingValues0680j_4 = paddingValues2;
                                    m909spacedBy0680j_4 = vertical2;
                                } else {
                                    companion = i12 != 0 ? Modifier.INSTANCE : modifier;
                                    if ((i2 & 4) != 0) {
                                        lazyStaggeredGridState3 = LazyStaggeredGridStateKt.rememberLazyStaggeredGridState(0, 0, startRestartGroup, 0, 3);
                                        i3 &= -897;
                                    } else {
                                        lazyStaggeredGridState3 = lazyStaggeredGridState;
                                    }
                                    m1057PaddingValues0680j_4 = i4 != 0 ? PaddingKt.m1057PaddingValues0680j_4(Dp.constructor-impl(0)) : paddingValues2;
                                    if (i5 != 0) {
                                        z3 = false;
                                    }
                                    m909spacedBy0680j_4 = i6 != 0 ? Arrangement.INSTANCE.m909spacedBy0680j_4(Dp.constructor-impl(0)) : vertical2;
                                    f3 = i7 != 0 ? Dp.constructor-impl(0) : f;
                                    if ((i2 & Fields.SpotShadowColor) != 0) {
                                        flingBehavior3 = ScrollableDefaults.INSTANCE.flingBehavior(startRestartGroup, 6);
                                        i3 &= -29360129;
                                    } else {
                                        flingBehavior3 = flingBehavior;
                                    }
                                    i9 = i3;
                                    if (i8 != 0) {
                                        flingBehavior4 = flingBehavior3;
                                        z6 = true;
                                        startRestartGroup.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-8666074, i9, -1, "androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid (LazyStaggeredGridDsl.kt:232)");
                                        }
                                        m1351LazyHorizontalStaggeredGrid121YqSk(staggeredGridCells, companion, lazyStaggeredGridState3, m1057PaddingValues0680j_4, z3, m909spacedBy0680j_4, f3, flingBehavior4, z6, OverscrollKt.rememberOverscrollEffect(startRestartGroup, 0), function1, startRestartGroup, (i9 & 14) | (i9 & 112) | (i9 & 896) | (i9 & 7168) | (57344 & i9) | (458752 & i9) | (3670016 & i9) | (29360128 & i9) | (234881024 & i9), (i9 >> 27) & 14, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        vertical3 = m909spacedBy0680j_4;
                                        z5 = z3;
                                        flingBehavior2 = flingBehavior4;
                                        float f4 = f3;
                                        z4 = z6;
                                        lazyStaggeredGridState2 = lazyStaggeredGridState3;
                                        paddingValues3 = m1057PaddingValues0680j_4;
                                        f2 = f4;
                                    } else {
                                        flingBehavior4 = flingBehavior3;
                                    }
                                }
                                z6 = z2;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                m1351LazyHorizontalStaggeredGrid121YqSk(staggeredGridCells, companion, lazyStaggeredGridState3, m1057PaddingValues0680j_4, z3, m909spacedBy0680j_4, f3, flingBehavior4, z6, OverscrollKt.rememberOverscrollEffect(startRestartGroup, 0), function1, startRestartGroup, (i9 & 14) | (i9 & 112) | (i9 & 896) | (i9 & 7168) | (57344 & i9) | (458752 & i9) | (3670016 & i9) | (29360128 & i9) | (234881024 & i9), (i9 >> 27) & 14, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                vertical3 = m909spacedBy0680j_4;
                                z5 = z3;
                                flingBehavior2 = flingBehavior4;
                                float f42 = f3;
                                z4 = z6;
                                lazyStaggeredGridState2 = lazyStaggeredGridState3;
                                paddingValues3 = m1057PaddingValues0680j_4;
                                f2 = f42;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                companion = modifier;
                                lazyStaggeredGridState2 = lazyStaggeredGridState;
                                f2 = f;
                                z4 = z2;
                                paddingValues3 = paddingValues2;
                                z5 = z3;
                                vertical3 = vertical2;
                                flingBehavior2 = flingBehavior;
                            }
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$$ExternalSyntheticLambda0
                                    public final Object invoke(Object obj, Object obj2) {
                                        Unit LazyHorizontalStaggeredGrid_cJHQLPU$lambda$9;
                                        LazyHorizontalStaggeredGrid_cJHQLPU$lambda$9 = LazyStaggeredGridDslKt.LazyHorizontalStaggeredGrid_cJHQLPU$lambda$9(StaggeredGridCells.this, companion, lazyStaggeredGridState2, paddingValues3, z5, vertical3, f2, flingBehavior2, z4, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                        return LazyHorizontalStaggeredGrid_cJHQLPU$lambda$9;
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
                    i7 = i2 & 64;
                    if (i7 != 0) {
                    }
                    if ((i & 12582912) == 0) {
                    }
                    i8 = i2 & Fields.RotationX;
                    if (i8 != 0) {
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
                i6 = i2 & 32;
                if (i6 == 0) {
                }
                vertical2 = vertical;
                i7 = i2 & 64;
                if (i7 != 0) {
                }
                if ((i & 12582912) == 0) {
                }
                i8 = i2 & Fields.RotationX;
                if (i8 != 0) {
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
            i6 = i2 & 32;
            if (i6 == 0) {
            }
            vertical2 = vertical;
            i7 = i2 & 64;
            if (i7 != 0) {
            }
            if ((i & 12582912) == 0) {
            }
            i8 = i2 & Fields.RotationX;
            if (i8 != 0) {
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
        i6 = i2 & 32;
        if (i6 == 0) {
        }
        vertical2 = vertical;
        i7 = i2 & 64;
        if (i7 != 0) {
        }
        if ((i & 12582912) == 0) {
        }
        i8 = i2 & Fields.RotationX;
        if (i8 != 0) {
        }
        if ((i2 & Fields.RotationY) != 0) {
        }
        if (!startRestartGroup.shouldExecute((i3 & 306783379) == 306783378, i3 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    private static final LazyGridStaggeredGridSlotsProvider rememberRowSlots(final StaggeredGridCells staggeredGridCells, final Arrangement.Vertical vertical, final PaddingValues paddingValues, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1532383053, "C(rememberRowSlots)N(rows,verticalArrangement,contentPadding)255@11347L956:LazyStaggeredGridDsl.kt#fzvcnm");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1532383053, i, -1, "androidx.compose.foundation.lazy.staggeredgrid.rememberRowSlots (LazyStaggeredGridDsl.kt:255)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 553674735, "CC(remember):LazyStaggeredGridDsl.kt#9igjgp");
        boolean z = ((((i & 14) ^ 6) > 4 && composer.changed(staggeredGridCells)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changed(vertical)) || (i & 48) == 32) | ((((i & 896) ^ 384) > 256 && composer.changed(paddingValues)) || (i & 384) == 256);
        LazyStaggeredGridSlotCache rememberedValue = composer.rememberedValue();
        if (z || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new LazyStaggeredGridSlotCache(new Function2() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    LazyStaggeredGridSlots rememberRowSlots$lambda$15$lambda$14;
                    rememberRowSlots$lambda$15$lambda$14 = LazyStaggeredGridDslKt.rememberRowSlots$lambda$15$lambda$14(PaddingValues.this, staggeredGridCells, vertical, (Density) obj, (Constraints) obj2);
                    return rememberRowSlots$lambda$15$lambda$14;
                }
            });
            composer.updateRememberedValue(rememberedValue);
        }
        LazyGridStaggeredGridSlotsProvider lazyGridStaggeredGridSlotsProvider = (LazyGridStaggeredGridSlotsProvider) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return lazyGridStaggeredGridSlotsProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LazyStaggeredGridSlots rememberRowSlots$lambda$15$lambda$14(PaddingValues paddingValues, StaggeredGridCells staggeredGridCells, Arrangement.Vertical vertical, Density density, Constraints constraints) {
        if (!(Constraints.getMaxHeight-impl(constraints.unbox-impl()) != Integer.MAX_VALUE)) {
            InlineClassHelperKt.throwIllegalArgumentException("LazyHorizontalStaggeredGrid's height should be bound by parent.");
        }
        int i = Constraints.getMaxHeight-impl(constraints.unbox-impl()) - density.roundToPx-0680j_4(Dp.constructor-impl(paddingValues.getTop() + paddingValues.getBottom()));
        int[] calculateCrossAxisCellSizes = staggeredGridCells.calculateCrossAxisCellSizes(density, i, density.roundToPx-0680j_4(vertical.getSpacing()));
        int[] iArr = new int[calculateCrossAxisCellSizes.length];
        vertical.arrange(density, i, calculateCrossAxisCellSizes, iArr);
        return new LazyStaggeredGridSlots(iArr, calculateCrossAxisCellSizes);
    }

    public static /* synthetic */ void items$default(LazyStaggeredGridScope lazyStaggeredGridScope, List list, Function1 function1, Function1 function12, Function1 function13, Function4 function4, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            function12 = new Function1() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$items$1
                /* renamed from: invoke, reason: collision with other method in class */
                public final Void m1355invoke(T t) {
                    return null;
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    return m1355invoke((LazyStaggeredGridDslKt$items$1) obj2);
                }
            };
        }
        if ((i & 8) != 0) {
            function13 = null;
        }
        lazyStaggeredGridScope.items(list.size(), function1 != null ? new LazyStaggeredGridDslKt$items$2$1(function1, list) : null, new LazyStaggeredGridDslKt$items$3(function12, list), function13 != null ? new LazyStaggeredGridDslKt$items$4$1(function13, list) : null, ComposableLambdaKt.composableLambdaInstance(-334987442, true, new LazyStaggeredGridDslKt$items$5(function4, list)));
    }

    public static final <T> void items(LazyStaggeredGridScope lazyStaggeredGridScope, List<? extends T> list, Function1<? super T, ? extends Object> function1, Function1<? super T, ? extends Object> function12, Function1<? super T, StaggeredGridItemSpan> function13, Function4<? super LazyStaggeredGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4) {
        lazyStaggeredGridScope.items(list.size(), function1 != null ? new LazyStaggeredGridDslKt$items$2$1(function1, list) : null, new LazyStaggeredGridDslKt$items$3(function12, list), function13 != null ? new LazyStaggeredGridDslKt$items$4$1(function13, list) : null, ComposableLambdaKt.composableLambdaInstance(-334987442, true, new LazyStaggeredGridDslKt$items$5(function4, list)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyStaggeredGridScope lazyStaggeredGridScope, List list, Function2 function2, Function2 function22, Function2 function23, Function5 function5, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            function22 = new Function2() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$itemsIndexed$1
                public final Void invoke(int i2, T t) {
                    return null;
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    return invoke(((Number) obj2).intValue(), (int) obj3);
                }
            };
        }
        if ((i & 8) != 0) {
            function23 = null;
        }
        lazyStaggeredGridScope.items(list.size(), function2 != null ? new LazyStaggeredGridDslKt$itemsIndexed$2$1(function2, list) : null, new LazyStaggeredGridDslKt$itemsIndexed$3(function22, list), function23 != null ? new LazyStaggeredGridDslKt$itemsIndexed$4$1(function23, list) : null, ComposableLambdaKt.composableLambdaInstance(-1466459515, true, new LazyStaggeredGridDslKt$itemsIndexed$5(function5, list)));
    }

    public static final <T> void itemsIndexed(LazyStaggeredGridScope lazyStaggeredGridScope, List<? extends T> list, Function2<? super Integer, ? super T, ? extends Object> function2, Function2<? super Integer, ? super T, ? extends Object> function22, Function2<? super Integer, ? super T, StaggeredGridItemSpan> function23, Function5<? super LazyStaggeredGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5) {
        lazyStaggeredGridScope.items(list.size(), function2 != null ? new LazyStaggeredGridDslKt$itemsIndexed$2$1(function2, list) : null, new LazyStaggeredGridDslKt$itemsIndexed$3(function22, list), function23 != null ? new LazyStaggeredGridDslKt$itemsIndexed$4$1(function23, list) : null, ComposableLambdaKt.composableLambdaInstance(-1466459515, true, new LazyStaggeredGridDslKt$itemsIndexed$5(function5, list)));
    }

    public static /* synthetic */ void items$default(LazyStaggeredGridScope lazyStaggeredGridScope, Object[] objArr, Function1 function1, Function1 function12, Function1 function13, Function4 function4, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            function12 = new Function1() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$items$6
                /* renamed from: invoke, reason: collision with other method in class */
                public final Void m1356invoke(T t) {
                    return null;
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    return m1356invoke((LazyStaggeredGridDslKt$items$6) obj2);
                }
            };
        }
        if ((i & 8) != 0) {
            function13 = null;
        }
        lazyStaggeredGridScope.items(objArr.length, function1 != null ? new LazyStaggeredGridDslKt$items$7$1(function1, objArr) : null, new LazyStaggeredGridDslKt$items$8(function12, objArr), function13 != null ? new LazyStaggeredGridDslKt$items$9$1(function13, objArr) : null, ComposableLambdaKt.composableLambdaInstance(-1775984467, true, new LazyStaggeredGridDslKt$items$10(function4, objArr)));
    }

    public static final <T> void items(LazyStaggeredGridScope lazyStaggeredGridScope, T[] tArr, Function1<? super T, ? extends Object> function1, Function1<? super T, ? extends Object> function12, Function1<? super T, StaggeredGridItemSpan> function13, Function4<? super LazyStaggeredGridItemScope, ? super T, ? super Composer, ? super Integer, Unit> function4) {
        lazyStaggeredGridScope.items(tArr.length, function1 != null ? new LazyStaggeredGridDslKt$items$7$1(function1, tArr) : null, new LazyStaggeredGridDslKt$items$8(function12, tArr), function13 != null ? new LazyStaggeredGridDslKt$items$9$1(function13, tArr) : null, ComposableLambdaKt.composableLambdaInstance(-1775984467, true, new LazyStaggeredGridDslKt$items$10(function4, tArr)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyStaggeredGridScope lazyStaggeredGridScope, Object[] objArr, Function2 function2, Function2 function22, Function2 function23, Function5 function5, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            function22 = new Function2() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridDslKt$itemsIndexed$6
                public final Void invoke(int i2, T t) {
                    return null;
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    return invoke(((Number) obj2).intValue(), (int) obj3);
                }
            };
        }
        if ((i & 8) != 0) {
            function23 = null;
        }
        lazyStaggeredGridScope.items(objArr.length, function2 != null ? new LazyStaggeredGridDslKt$itemsIndexed$7$1(function2, objArr) : null, new LazyStaggeredGridDslKt$itemsIndexed$8(function22, objArr), function23 != null ? new LazyStaggeredGridDslKt$itemsIndexed$9$1(function23, objArr) : null, ComposableLambdaKt.composableLambdaInstance(425846862, true, new LazyStaggeredGridDslKt$itemsIndexed$10(function5, objArr)));
    }

    public static final <T> void itemsIndexed(LazyStaggeredGridScope lazyStaggeredGridScope, T[] tArr, Function2<? super Integer, ? super T, ? extends Object> function2, Function2<? super Integer, ? super T, ? extends Object> function22, Function2<? super Integer, ? super T, StaggeredGridItemSpan> function23, Function5<? super LazyStaggeredGridItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> function5) {
        lazyStaggeredGridScope.items(tArr.length, function2 != null ? new LazyStaggeredGridDslKt$itemsIndexed$7$1(function2, tArr) : null, new LazyStaggeredGridDslKt$itemsIndexed$8(function22, tArr), function23 != null ? new LazyStaggeredGridDslKt$itemsIndexed$9$1(function23, tArr) : null, ComposableLambdaKt.composableLambdaInstance(425846862, true, new LazyStaggeredGridDslKt$itemsIndexed$10(function5, tArr)));
    }
}
