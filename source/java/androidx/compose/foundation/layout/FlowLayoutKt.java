package androidx.compose.foundation.layout;

import androidx.collection.IntIntPair;
import androidx.collection.IntObjectMapKt;
import androidx.collection.IntSetKt;
import androidx.collection.MutableIntList;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.FlowLayoutBuildingBlocks;
import androidx.compose.foundation.layout.FlowLayoutOverflow;
import androidx.compose.p002ui.Alignment;
import androidx.compose.p002ui.ComposedModifierKt;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.layout.IntrinsicMeasurable;
import androidx.compose.p002ui.layout.LayoutKt;
import androidx.compose.p002ui.layout.Measurable;
import androidx.compose.p002ui.layout.MeasurePolicy;
import androidx.compose.p002ui.layout.MeasureResult;
import androidx.compose.p002ui.layout.MeasureScope;
import androidx.compose.p002ui.layout.MultiContentMeasurePolicy;
import androidx.compose.p002ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.p002ui.layout.Placeable;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: FlowLayout.kt */
@Metadata(d1 = {"\u0000â\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aq\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u001c\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u0014\u001ag\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\u001c\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u0015\u001aq\u0010\u0016\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u001a2\u001c\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u001c\u001ag\u0010\u0016\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\u001c\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0012¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0002\u0010\u001d\u001a%\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u000bH\u0001¢\u0006\u0002\u0010!\u001a=\u0010\"\u001a\u00020#2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\u0010&\u001a%\u0010'\u001a\u00020\u001f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u000bH\u0001¢\u0006\u0002\u0010(\u001a=\u0010)\u001a\u00020#2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\u0010*\u001aT\u0010+\u001a\u00020\u000b2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-2#\u0010/\u001a\u001f\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b00¢\u0006\u0002\b\u00132\u0006\u00101\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000bH\u0082\b\u001a\u0091\u0001\u00103\u001a\u00020\u000b2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-2#\u0010/\u001a\u001f\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b00¢\u0006\u0002\b\u00132#\u00104\u001a\u001f\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b00¢\u0006\u0002\b\u00132\u0006\u00101\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020%H\u0082\b\u001a[\u00106\u001a\u0002072\f\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u0002092\u0006\u0010;\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020%H\u0002¢\u0006\u0002\u0010<\u001a\u0096\u0001\u00106\u001a\u0002072\f\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-2#\u0010/\u001a\u001f\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b00¢\u0006\u0002\b\u00132#\u00104\u001a\u001f\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b00¢\u0006\u0002\b\u00132\u0006\u0010;\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020%H\u0082\b¢\u0006\u0002\u0010=\u001aY\u0010>\u001a\u00020?*\u00020@2\u0006\u0010A\u001a\u00020B2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020E0D2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020G2\u0006\u0010I\u001a\u00020J2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020%H\u0000¢\u0006\u0004\bK\u0010L\u001a\u001e\u0010M\u001a\u0004\u0018\u00010E*\b\u0012\u0004\u0012\u00020E0D2\b\u0010N\u001a\u0004\u0018\u00010OH\u0002\u001a\u001c\u0010P\u001a\u00020\u000b*\u00020.2\u0006\u0010Q\u001a\u00020R2\u0006\u00104\u001a\u00020\u000bH\u0000\u001a\u001c\u0010S\u001a\u00020\u000b*\u00020.2\u0006\u0010Q\u001a\u00020R2\u0006\u0010/\u001a\u00020\u000bH\u0000\u001a9\u0010Z\u001a\u000207*\u00020E2\u0006\u0010A\u001a\u00020B2\u0006\u0010I\u001a\u00020[2\u0014\u0010\\\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010]\u0012\u0004\u0012\u00020\u00010\u0010H\u0000¢\u0006\u0004\b^\u0010_\u001aQ\u0010`\u001a\u00020?*\u00020@2\u0006\u0010I\u001a\u00020J2\u0006\u0010a\u001a\u00020\u000b2\u0006\u0010b\u001a\u00020\u000b2\u0006\u0010:\u001a\u0002092\f\u0010c\u001a\b\u0012\u0004\u0012\u00020?0d2\u0006\u0010e\u001a\u00020B2\u0006\u0010f\u001a\u000209H\u0000¢\u0006\u0004\bg\u0010h\"\u0014\u0010T\u001a\u00020UX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u0010W\"\u0014\u0010X\u001a\u00020UX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bY\u0010W¨\u0006i"}, d2 = {"FlowRow", "", "modifier", "Landroidx/compose/ui/Modifier;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "itemVerticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "maxItemsInEachRow", "", "maxLines", "overflow", "Landroidx/compose/foundation/layout/FlowRowOverflow;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/FlowRowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;IILandroidx/compose/foundation/layout/FlowRowOverflow;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;IILkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "FlowColumn", "itemHorizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "maxItemsInEachColumn", "Landroidx/compose/foundation/layout/FlowColumnOverflow;", "Landroidx/compose/foundation/layout/FlowColumnScope;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Horizontal;IILandroidx/compose/foundation/layout/FlowColumnOverflow;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Horizontal;IILkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "rowMeasurementHelper", "Landroidx/compose/ui/layout/MeasurePolicy;", "maxItemsInMainAxis", "(Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;ILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MeasurePolicy;", "rowMeasurementMultiContentHelper", "Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "overflowState", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "(Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;IILandroidx/compose/foundation/layout/FlowLayoutOverflowState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "columnMeasurementHelper", "(Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MeasurePolicy;", "columnMeasurementMultiContentHelper", "(Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Horizontal;IILandroidx/compose/foundation/layout/FlowLayoutOverflowState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "maxIntrinsicMainAxisSize", "children", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "mainAxisSize", "Lkotlin/Function3;", "crossAxisAvailable", "mainAxisSpacing", "minIntrinsicMainAxisSize", "crossAxisSize", "crossAxisSpacing", "intrinsicCrossAxisSize", "Landroidx/collection/IntIntPair;", "mainAxisSizes", "", "crossAxisSizes", "mainAxisAvailable", "(Ljava/util/List;[I[IIIIIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;)J", "(Ljava/util/List;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;IIIIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;)J", "breakDownItems", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurePolicy", "Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;", "measurablesIterator", "", "Landroidx/compose/ui/layout/Measurable;", "mainAxisSpacingDp", "Landroidx/compose/ui/unit/Dp;", "crossAxisSpacingDp", "constraints", "Landroidx/compose/foundation/layout/OrientationIndependentConstraints;", "breakDownItems-di9J0FM", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;Ljava/util/Iterator;FFJIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;)Landroidx/compose/ui/layout/MeasureResult;", "safeNext", "info", "Landroidx/compose/foundation/layout/FlowLineInfo;", "mainAxisMin", "isHorizontal", "", "crossAxisMin", "CROSS_AXIS_ALIGNMENT_TOP", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "getCROSS_AXIS_ALIGNMENT_TOP", "()Landroidx/compose/foundation/layout/CrossAxisAlignment;", "CROSS_AXIS_ALIGNMENT_START", "getCROSS_AXIS_ALIGNMENT_START", "measureAndCache", "Landroidx/compose/ui/unit/Constraints;", "storePlaceable", "Landroidx/compose/ui/layout/Placeable;", "measureAndCache-rqJ1uqs", "(Landroidx/compose/ui/layout/Measurable;Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;JLkotlin/jvm/functions/Function1;)J", "placeHelper", "mainAxisTotalSize", "crossAxisTotalSize", "items", "Landroidx/compose/runtime/collection/MutableVector;", "measureHelper", "outPosition", "placeHelper-BmaY500", "(Landroidx/compose/ui/layout/MeasureScope;JII[ILandroidx/compose/runtime/collection/MutableVector;Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;[I)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class FlowLayoutKt {
    private static final CrossAxisAlignment CROSS_AXIS_ALIGNMENT_TOP = CrossAxisAlignment.INSTANCE.vertical$foundation_layout(Alignment.INSTANCE.getTop());
    private static final CrossAxisAlignment CROSS_AXIS_ALIGNMENT_START = CrossAxisAlignment.INSTANCE.horizontal$foundation_layout(Alignment.INSTANCE.getStart());

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FlowColumn$lambda$6(Modifier modifier, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, Alignment.Horizontal horizontal2, int i, int i2, FlowColumnOverflow flowColumnOverflow, Function3 function3, int i3, int i4, Composer composer, int i5) {
        FlowColumn(modifier, vertical, horizontal, horizontal2, i, i2, flowColumnOverflow, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FlowColumn$lambda$7(Modifier modifier, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, Alignment.Horizontal horizontal2, int i, int i2, Function3 function3, int i3, int i4, Composer composer, int i5) {
        FlowColumn(modifier, vertical, horizontal, horizontal2, i, i2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FlowRow$lambda$2(Modifier modifier, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, Alignment.Vertical vertical2, int i, int i2, FlowRowOverflow flowRowOverflow, Function3 function3, int i3, int i4, Composer composer, int i5) {
        FlowRow(modifier, horizontal, vertical, vertical2, i, i2, flowRowOverflow, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FlowRow$lambda$3(Modifier modifier, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, Alignment.Vertical vertical2, int i, int i2, Function3 function3, int i3, int i4, Composer composer, int i5) {
        FlowRow(modifier, horizontal, vertical, vertical2, i, i2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0327  */
    @Deprecated(message = "The overflow parameter has been deprecated")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void FlowRow(Modifier modifier, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, Alignment.Vertical vertical2, int i, int i2, FlowRowOverflow flowRowOverflow, final Function3<? super FlowRowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i3, final int i4) {
        int i5;
        int i6;
        Arrangement.Vertical vertical3;
        int i7;
        Alignment.Vertical vertical4;
        int i8;
        int i9;
        int i10;
        int i11;
        Modifier modifier2;
        Arrangement.Horizontal horizontal2;
        final int i12;
        final FlowRowOverflow flowRowOverflow2;
        final Alignment.Vertical vertical5;
        final int i13;
        ScopeUpdateScope endRestartGroup;
        boolean z;
        Object obj;
        Composer startRestartGroup = composer.startRestartGroup(-1956591841);
        ComposerKt.sourceInformation(startRestartGroup, "C(FlowRow)N(modifier,horizontalArrangement,verticalArrangement,itemVerticalAlignment,maxItemsInEachRow,maxLines,overflow,content)100@4511L53,102@4597L226,111@4877L291,118@5174L75:FlowLayout.kt#2w3rfo");
        int i14 = i4 & 1;
        if (i14 != 0) {
            i5 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i5 = (startRestartGroup.changed(modifier) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        int i15 = i4 & 2;
        if (i15 != 0) {
            i5 |= 48;
        } else if ((i3 & 48) == 0) {
            i5 |= startRestartGroup.changed(horizontal) ? 32 : 16;
            i6 = i4 & 4;
            if (i6 == 0) {
                i5 |= 384;
            } else if ((i3 & 384) == 0) {
                vertical3 = vertical;
                i5 |= startRestartGroup.changed(vertical3) ? Fields.RotationX : Fields.SpotShadowColor;
                i7 = i4 & 8;
                if (i7 != 0) {
                    i5 |= 3072;
                } else if ((i3 & 3072) == 0) {
                    vertical4 = vertical2;
                    i5 |= startRestartGroup.changed(vertical4) ? Fields.CameraDistance : Fields.RotationZ;
                    i8 = i4 & 16;
                    if (i8 == 0) {
                        i5 |= 24576;
                    } else if ((i3 & 24576) == 0) {
                        i9 = i;
                        i5 |= startRestartGroup.changed(i9) ? Fields.Clip : Fields.Shape;
                        i10 = i4 & 32;
                        if (i10 != 0) {
                            i5 |= 196608;
                        } else if ((i3 & 196608) == 0) {
                            i5 |= startRestartGroup.changed(i2) ? Fields.RenderEffect : 65536;
                        }
                        i11 = i4 & 64;
                        if (i11 != 0) {
                            i5 |= 1572864;
                        } else if ((i3 & 1572864) == 0) {
                            i5 |= startRestartGroup.changed(flowRowOverflow) ? 1048576 : Fields.BlendMode;
                        }
                        if ((i4 & Fields.SpotShadowColor) != 0) {
                            i5 |= 12582912;
                        } else if ((i3 & 12582912) == 0) {
                            i5 |= startRestartGroup.changedInstance(function3) ? 8388608 : 4194304;
                        }
                        if (!startRestartGroup.shouldExecute((4793491 & i5) != 4793490, i5 & 1)) {
                            startRestartGroup.skipToGroupEnd();
                            modifier2 = modifier;
                            horizontal2 = horizontal;
                            i12 = i2;
                            flowRowOverflow2 = flowRowOverflow;
                            vertical5 = vertical4;
                            i13 = i9;
                        } else {
                            Modifier.Companion companion = i14 != 0 ? Modifier.INSTANCE : modifier;
                            Arrangement.Horizontal start = i15 != 0 ? Arrangement.INSTANCE.getStart() : horizontal;
                            Arrangement.Vertical top = i6 != 0 ? Arrangement.INSTANCE.getTop() : vertical3;
                            Alignment.Vertical top2 = i7 != 0 ? Alignment.INSTANCE.getTop() : vertical4;
                            int i16 = i8 != 0 ? Integer.MAX_VALUE : i9;
                            int i17 = i10 != 0 ? Integer.MAX_VALUE : i2;
                            FlowRowOverflow clip = i11 != 0 ? FlowRowOverflow.INSTANCE.getClip() : flowRowOverflow;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1956591841, i5, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:99)");
                            }
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 910934132, "CC(remember):FlowLayout.kt#9igjgp");
                            int i18 = i5 & 3670016;
                            boolean z2 = i18 == 1048576;
                            Object rememberedValue = startRestartGroup.rememberedValue();
                            if (z2 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = clip.createOverflowState$foundation_layout();
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            FlowLayoutOverflowState flowLayoutOverflowState = (FlowLayoutOverflowState) rememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            int i19 = i5 >> 3;
                            Arrangement.Horizontal horizontal3 = start;
                            Arrangement.Vertical vertical6 = top;
                            Alignment.Vertical vertical7 = top2;
                            FlowRowOverflow flowRowOverflow3 = clip;
                            MultiContentMeasurePolicy rowMeasurementMultiContentHelper = rowMeasurementMultiContentHelper(start, top, top2, i16, i17, flowLayoutOverflowState, startRestartGroup, (i19 & 896) | (i19 & 14) | (i19 & 112) | (i19 & 7168) | (i19 & 57344));
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 910946082, "CC(remember):FlowLayout.kt#9igjgp");
                            boolean z3 = (i18 == 1048576) | ((29360128 & i5) == 8388608) | ((458752 & i5) == 131072);
                            Object rememberedValue2 = startRestartGroup.rememberedValue();
                            if (z3 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                ArrayList arrayList = new ArrayList();
                                z = true;
                                arrayList.add(ComposableLambdaKt.composableLambdaInstance(-1192950673, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$FlowRow$list$1$1
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                        invoke((Composer) obj2, ((Number) obj3).intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer2, int i20) {
                                        ComposerKt.sourceInformation(composer2, "C113@5051L9:FlowLayout.kt#2w3rfo");
                                        if (!composer2.shouldExecute((i20 & 3) != 2, i20 & 1)) {
                                            composer2.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1192950673, i20, -1, "androidx.compose.foundation.layout.FlowRow.<anonymous>.<anonymous> (FlowLayout.kt:113)");
                                        }
                                        function3.invoke(FlowRowScopeInstance.INSTANCE, composer2, 6);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }));
                                flowRowOverflow3.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList);
                                startRestartGroup.updateRememberedValue(arrayList);
                                obj = arrayList;
                            } else {
                                z = true;
                                obj = rememberedValue2;
                            }
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            int i20 = (i5 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1399185516, "CC(Layout)P(!1,2)169@6976L62,166@6862L183:Layout.kt#80mrfh");
                            Function2<Composer, Integer, Unit> combineAsVirtualLayouts = LayoutKt.combineAsVirtualLayouts((List) obj);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 292529258, "CC(remember):Layout.kt#9igjgp");
                            boolean z4 = ((((i20 & 896) ^ 384) <= 256 || !startRestartGroup.changed(rowMeasurementMultiContentHelper)) && (i20 & 384) != 256) ? false : z;
                            Object rememberedValue3 = startRestartGroup.rememberedValue();
                            if (z4 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(rowMeasurementMultiContentHelper);
                                startRestartGroup.updateRememberedValue(rememberedValue3);
                            }
                            MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
                            Function0 constructor = ComposeUiNode.Companion.getConstructor();
                            int i21 = ((i20 & 112) << 6) & 896;
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            startRestartGroup.startReusableNode();
                            if (startRestartGroup.getInserting()) {
                                startRestartGroup.createNode(constructor);
                            } else {
                                startRestartGroup.useNode();
                            }
                            Composer m4109constructorimpl = Updater.m4109constructorimpl(startRestartGroup);
                            Updater.m4116setimpl(m4109constructorimpl, measurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(hashCode))) {
                                m4109constructorimpl.updateRememberedValue(Integer.valueOf(hashCode));
                                m4109constructorimpl.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
                            }
                            Updater.m4116setimpl(m4109constructorimpl, materializeModifier, (Function2<? super T, ? super Modifier, Unit>) ComposeUiNode.Companion.getSetModifier());
                            combineAsVirtualLayouts.invoke(startRestartGroup, Integer.valueOf((i21 >> 6) & 14));
                            startRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            vertical3 = vertical6;
                            vertical5 = vertical7;
                            modifier2 = companion;
                            i13 = i16;
                            i12 = i17;
                            flowRowOverflow2 = flowRowOverflow3;
                            horizontal2 = horizontal3;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            final Modifier modifier3 = modifier2;
                            final Arrangement.Horizontal horizontal4 = horizontal2;
                            final Arrangement.Vertical vertical8 = vertical3;
                            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda1
                                public final Object invoke(Object obj2, Object obj3) {
                                    Unit FlowRow$lambda$2;
                                    FlowRow$lambda$2 = FlowLayoutKt.FlowRow$lambda$2(Modifier.this, horizontal4, vertical8, vertical5, i13, i12, flowRowOverflow2, function3, i3, i4, (Composer) obj2, ((Integer) obj3).intValue());
                                    return FlowRow$lambda$2;
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i9 = i;
                    i10 = i4 & 32;
                    if (i10 != 0) {
                    }
                    i11 = i4 & 64;
                    if (i11 != 0) {
                    }
                    if ((i4 & Fields.SpotShadowColor) != 0) {
                    }
                    if (!startRestartGroup.shouldExecute((4793491 & i5) != 4793490, i5 & 1)) {
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                vertical4 = vertical2;
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
                if ((i4 & Fields.SpotShadowColor) != 0) {
                }
                if (!startRestartGroup.shouldExecute((4793491 & i5) != 4793490, i5 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            vertical3 = vertical;
            i7 = i4 & 8;
            if (i7 != 0) {
            }
            vertical4 = vertical2;
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
            if ((i4 & Fields.SpotShadowColor) != 0) {
            }
            if (!startRestartGroup.shouldExecute((4793491 & i5) != 4793490, i5 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i6 = i4 & 4;
        if (i6 == 0) {
        }
        vertical3 = vertical;
        i7 = i4 & 8;
        if (i7 != 0) {
        }
        vertical4 = vertical2;
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
        if ((i4 & Fields.SpotShadowColor) != 0) {
        }
        if (!startRestartGroup.shouldExecute((4793491 & i5) != 4793490, i5 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void FlowRow(Modifier modifier, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, Alignment.Vertical vertical2, int i, int i2, final Function3<? super FlowRowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i3, final int i4) {
        int i5;
        Arrangement.Horizontal horizontal2;
        int i6;
        Arrangement.Vertical vertical3;
        int i7;
        Alignment.Vertical vertical4;
        int i8;
        int i9;
        int i10;
        int i11;
        Modifier modifier2;
        final Arrangement.Vertical vertical5;
        final Alignment.Vertical vertical6;
        final int i12;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-1303174015);
        ComposerKt.sourceInformation(startRestartGroup, "C(FlowRow)N(modifier,horizontalArrangement,verticalArrangement,itemVerticalAlignment,maxItemsInEachRow,maxLines,content)162@7315L215:FlowLayout.kt#2w3rfo");
        int i13 = i4 & 1;
        if (i13 != 0) {
            i5 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i5 = (startRestartGroup.changed(modifier) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        int i14 = i4 & 2;
        if (i14 != 0) {
            i5 |= 48;
        } else if ((i3 & 48) == 0) {
            horizontal2 = horizontal;
            i5 |= startRestartGroup.changed(horizontal2) ? 32 : 16;
            i6 = i4 & 4;
            if (i6 == 0) {
                i5 |= 384;
            } else if ((i3 & 384) == 0) {
                vertical3 = vertical;
                i5 |= startRestartGroup.changed(vertical3) ? Fields.RotationX : Fields.SpotShadowColor;
                i7 = i4 & 8;
                if (i7 != 0) {
                    i5 |= 3072;
                } else if ((i3 & 3072) == 0) {
                    vertical4 = vertical2;
                    i5 |= startRestartGroup.changed(vertical4) ? Fields.CameraDistance : Fields.RotationZ;
                    i8 = i4 & 16;
                    if (i8 == 0) {
                        i5 |= 24576;
                    } else if ((i3 & 24576) == 0) {
                        i9 = i;
                        i5 |= startRestartGroup.changed(i9) ? Fields.Clip : Fields.Shape;
                        i10 = i4 & 32;
                        if (i10 != 0) {
                            i5 |= 196608;
                        } else if ((196608 & i3) == 0) {
                            i11 = i2;
                            i5 |= startRestartGroup.changed(i11) ? Fields.RenderEffect : 65536;
                            if ((i4 & 64) == 0) {
                                i5 |= 1572864;
                            } else if ((i3 & 1572864) == 0) {
                                i5 |= startRestartGroup.changedInstance(function3) ? 1048576 : Fields.BlendMode;
                            }
                            if (startRestartGroup.shouldExecute((i5 & 599187) == 599186, i5 & 1)) {
                                startRestartGroup.skipToGroupEnd();
                                modifier2 = modifier;
                                vertical5 = vertical3;
                                vertical6 = vertical4;
                                i12 = i9;
                            } else {
                                Modifier.Companion companion = i13 != 0 ? Modifier.INSTANCE : modifier;
                                if (i14 != 0) {
                                    horizontal2 = Arrangement.INSTANCE.getStart();
                                }
                                Arrangement.Vertical top = i6 != 0 ? Arrangement.INSTANCE.getTop() : vertical3;
                                Alignment.Vertical top2 = i7 != 0 ? Alignment.INSTANCE.getTop() : vertical4;
                                int i15 = i8 != 0 ? Integer.MAX_VALUE : i9;
                                int i16 = i10 == 0 ? i11 : Integer.MAX_VALUE;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1303174015, i5, -1, "androidx.compose.foundation.layout.FlowRow (FlowLayout.kt:162)");
                                }
                                FlowRow(companion, horizontal2, top, top2, i15, i16, FlowRowOverflow.INSTANCE.getClip(), function3, startRestartGroup, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                vertical6 = top2;
                                i11 = i16;
                                i12 = i15;
                                vertical5 = top;
                                modifier2 = companion;
                            }
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup == null) {
                                final Modifier modifier3 = modifier2;
                                final Arrangement.Horizontal horizontal3 = horizontal2;
                                final int i17 = i11;
                                endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda4
                                    public final Object invoke(Object obj, Object obj2) {
                                        Unit FlowRow$lambda$3;
                                        FlowRow$lambda$3 = FlowLayoutKt.FlowRow$lambda$3(Modifier.this, horizontal3, vertical5, vertical6, i12, i17, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                        return FlowRow$lambda$3;
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i11 = i2;
                        if ((i4 & 64) == 0) {
                        }
                        if (startRestartGroup.shouldExecute((i5 & 599187) == 599186, i5 & 1)) {
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i9 = i;
                    i10 = i4 & 32;
                    if (i10 != 0) {
                    }
                    i11 = i2;
                    if ((i4 & 64) == 0) {
                    }
                    if (startRestartGroup.shouldExecute((i5 & 599187) == 599186, i5 & 1)) {
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                vertical4 = vertical2;
                i8 = i4 & 16;
                if (i8 == 0) {
                }
                i9 = i;
                i10 = i4 & 32;
                if (i10 != 0) {
                }
                i11 = i2;
                if ((i4 & 64) == 0) {
                }
                if (startRestartGroup.shouldExecute((i5 & 599187) == 599186, i5 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            vertical3 = vertical;
            i7 = i4 & 8;
            if (i7 != 0) {
            }
            vertical4 = vertical2;
            i8 = i4 & 16;
            if (i8 == 0) {
            }
            i9 = i;
            i10 = i4 & 32;
            if (i10 != 0) {
            }
            i11 = i2;
            if ((i4 & 64) == 0) {
            }
            if (startRestartGroup.shouldExecute((i5 & 599187) == 599186, i5 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        horizontal2 = horizontal;
        i6 = i4 & 4;
        if (i6 == 0) {
        }
        vertical3 = vertical;
        i7 = i4 & 8;
        if (i7 != 0) {
        }
        vertical4 = vertical2;
        i8 = i4 & 16;
        if (i8 == 0) {
        }
        i9 = i;
        i10 = i4 & 32;
        if (i10 != 0) {
        }
        i11 = i2;
        if ((i4 & 64) == 0) {
        }
        if (startRestartGroup.shouldExecute((i5 & 599187) == 599186, i5 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0327  */
    @Deprecated(message = "The overflow parameter has been deprecated")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void FlowColumn(Modifier modifier, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, Alignment.Horizontal horizontal2, int i, int i2, FlowColumnOverflow flowColumnOverflow, final Function3<? super FlowColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i3, final int i4) {
        int i5;
        int i6;
        Arrangement.Horizontal horizontal3;
        int i7;
        Alignment.Horizontal horizontal4;
        int i8;
        int i9;
        int i10;
        int i11;
        Modifier modifier2;
        Arrangement.Vertical vertical2;
        final int i12;
        final FlowColumnOverflow flowColumnOverflow2;
        final Alignment.Horizontal horizontal5;
        final int i13;
        ScopeUpdateScope endRestartGroup;
        boolean z;
        Object obj;
        Composer startRestartGroup = composer.startRestartGroup(-1944405121);
        ComposerKt.sourceInformation(startRestartGroup, "C(FlowColumn)N(modifier,verticalArrangement,horizontalArrangement,itemHorizontalAlignment,maxItemsInEachColumn,maxLines,overflow,content)214@9466L53,216@9552L234,225@9840L294,231@10139L75:FlowLayout.kt#2w3rfo");
        int i14 = i4 & 1;
        if (i14 != 0) {
            i5 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i5 = (startRestartGroup.changed(modifier) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        int i15 = i4 & 2;
        if (i15 != 0) {
            i5 |= 48;
        } else if ((i3 & 48) == 0) {
            i5 |= startRestartGroup.changed(vertical) ? 32 : 16;
            i6 = i4 & 4;
            if (i6 == 0) {
                i5 |= 384;
            } else if ((i3 & 384) == 0) {
                horizontal3 = horizontal;
                i5 |= startRestartGroup.changed(horizontal3) ? Fields.RotationX : Fields.SpotShadowColor;
                i7 = i4 & 8;
                if (i7 != 0) {
                    i5 |= 3072;
                } else if ((i3 & 3072) == 0) {
                    horizontal4 = horizontal2;
                    i5 |= startRestartGroup.changed(horizontal4) ? Fields.CameraDistance : Fields.RotationZ;
                    i8 = i4 & 16;
                    if (i8 == 0) {
                        i5 |= 24576;
                    } else if ((i3 & 24576) == 0) {
                        i9 = i;
                        i5 |= startRestartGroup.changed(i9) ? Fields.Clip : Fields.Shape;
                        i10 = i4 & 32;
                        if (i10 != 0) {
                            i5 |= 196608;
                        } else if ((i3 & 196608) == 0) {
                            i5 |= startRestartGroup.changed(i2) ? Fields.RenderEffect : 65536;
                        }
                        i11 = i4 & 64;
                        if (i11 != 0) {
                            i5 |= 1572864;
                        } else if ((i3 & 1572864) == 0) {
                            i5 |= startRestartGroup.changed(flowColumnOverflow) ? 1048576 : Fields.BlendMode;
                        }
                        if ((i4 & Fields.SpotShadowColor) != 0) {
                            i5 |= 12582912;
                        } else if ((i3 & 12582912) == 0) {
                            i5 |= startRestartGroup.changedInstance(function3) ? 8388608 : 4194304;
                        }
                        if (!startRestartGroup.shouldExecute((4793491 & i5) != 4793490, i5 & 1)) {
                            startRestartGroup.skipToGroupEnd();
                            modifier2 = modifier;
                            vertical2 = vertical;
                            i12 = i2;
                            flowColumnOverflow2 = flowColumnOverflow;
                            horizontal5 = horizontal4;
                            i13 = i9;
                        } else {
                            Modifier.Companion companion = i14 != 0 ? Modifier.INSTANCE : modifier;
                            Arrangement.Vertical top = i15 != 0 ? Arrangement.INSTANCE.getTop() : vertical;
                            Arrangement.Horizontal start = i6 != 0 ? Arrangement.INSTANCE.getStart() : horizontal3;
                            Alignment.Horizontal start2 = i7 != 0 ? Alignment.INSTANCE.getStart() : horizontal4;
                            int i16 = i8 != 0 ? Integer.MAX_VALUE : i9;
                            int i17 = i10 != 0 ? Integer.MAX_VALUE : i2;
                            FlowColumnOverflow clip = i11 != 0 ? FlowColumnOverflow.INSTANCE.getClip() : flowColumnOverflow;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1944405121, i5, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:213)");
                            }
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -262529164, "CC(remember):FlowLayout.kt#9igjgp");
                            int i18 = i5 & 3670016;
                            boolean z2 = i18 == 1048576;
                            Object rememberedValue = startRestartGroup.rememberedValue();
                            if (z2 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = clip.createOverflowState$foundation_layout();
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            FlowLayoutOverflowState flowLayoutOverflowState = (FlowLayoutOverflowState) rememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            int i19 = i5 >> 3;
                            Arrangement.Vertical vertical3 = top;
                            Arrangement.Horizontal horizontal6 = start;
                            Alignment.Horizontal horizontal7 = start2;
                            FlowColumnOverflow flowColumnOverflow3 = clip;
                            MultiContentMeasurePolicy columnMeasurementMultiContentHelper = columnMeasurementMultiContentHelper(top, start, start2, i16, i17, flowLayoutOverflowState, startRestartGroup, (i19 & 896) | (i19 & 14) | (i19 & 112) | (i19 & 7168) | (i19 & 57344));
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -262516955, "CC(remember):FlowLayout.kt#9igjgp");
                            boolean z3 = (i18 == 1048576) | ((29360128 & i5) == 8388608) | ((458752 & i5) == 131072);
                            Object rememberedValue2 = startRestartGroup.rememberedValue();
                            if (z3 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                ArrayList arrayList = new ArrayList();
                                z = true;
                                arrayList.add(ComposableLambdaKt.composableLambdaInstance(-1720407857, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$FlowColumn$list$1$1
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                        invoke((Composer) obj2, ((Number) obj3).intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer2, int i20) {
                                        ComposerKt.sourceInformation(composer2, "C227@10017L9:FlowLayout.kt#2w3rfo");
                                        if (!composer2.shouldExecute((i20 & 3) != 2, i20 & 1)) {
                                            composer2.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1720407857, i20, -1, "androidx.compose.foundation.layout.FlowColumn.<anonymous>.<anonymous> (FlowLayout.kt:227)");
                                        }
                                        function3.invoke(FlowColumnScopeInstance.INSTANCE, composer2, 6);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }));
                                flowColumnOverflow3.addOverflowComposables$foundation_layout(flowLayoutOverflowState, arrayList);
                                startRestartGroup.updateRememberedValue(arrayList);
                                obj = arrayList;
                            } else {
                                z = true;
                                obj = rememberedValue2;
                            }
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            int i20 = (i5 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1399185516, "CC(Layout)P(!1,2)169@6976L62,166@6862L183:Layout.kt#80mrfh");
                            Function2<Composer, Integer, Unit> combineAsVirtualLayouts = LayoutKt.combineAsVirtualLayouts((List) obj);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 292529258, "CC(remember):Layout.kt#9igjgp");
                            boolean z4 = ((((i20 & 896) ^ 384) <= 256 || !startRestartGroup.changed(columnMeasurementMultiContentHelper)) && (i20 & 384) != 256) ? false : z;
                            Object rememberedValue3 = startRestartGroup.rememberedValue();
                            if (z4 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(columnMeasurementMultiContentHelper);
                                startRestartGroup.updateRememberedValue(rememberedValue3);
                            }
                            MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                            int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
                            Function0 constructor = ComposeUiNode.Companion.getConstructor();
                            int i21 = ((i20 & 112) << 6) & 896;
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            startRestartGroup.startReusableNode();
                            if (startRestartGroup.getInserting()) {
                                startRestartGroup.createNode(constructor);
                            } else {
                                startRestartGroup.useNode();
                            }
                            Composer m4109constructorimpl = Updater.m4109constructorimpl(startRestartGroup);
                            Updater.m4116setimpl(m4109constructorimpl, measurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(hashCode))) {
                                m4109constructorimpl.updateRememberedValue(Integer.valueOf(hashCode));
                                m4109constructorimpl.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
                            }
                            Updater.m4116setimpl(m4109constructorimpl, materializeModifier, (Function2<? super T, ? super Modifier, Unit>) ComposeUiNode.Companion.getSetModifier());
                            combineAsVirtualLayouts.invoke(startRestartGroup, Integer.valueOf((i21 >> 6) & 14));
                            startRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            horizontal3 = horizontal6;
                            horizontal5 = horizontal7;
                            modifier2 = companion;
                            i13 = i16;
                            i12 = i17;
                            flowColumnOverflow2 = flowColumnOverflow3;
                            vertical2 = vertical3;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            final Modifier modifier3 = modifier2;
                            final Arrangement.Vertical vertical4 = vertical2;
                            final Arrangement.Horizontal horizontal8 = horizontal3;
                            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda6
                                public final Object invoke(Object obj2, Object obj3) {
                                    Unit FlowColumn$lambda$6;
                                    FlowColumn$lambda$6 = FlowLayoutKt.FlowColumn$lambda$6(Modifier.this, vertical4, horizontal8, horizontal5, i13, i12, flowColumnOverflow2, function3, i3, i4, (Composer) obj2, ((Integer) obj3).intValue());
                                    return FlowColumn$lambda$6;
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i9 = i;
                    i10 = i4 & 32;
                    if (i10 != 0) {
                    }
                    i11 = i4 & 64;
                    if (i11 != 0) {
                    }
                    if ((i4 & Fields.SpotShadowColor) != 0) {
                    }
                    if (!startRestartGroup.shouldExecute((4793491 & i5) != 4793490, i5 & 1)) {
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                horizontal4 = horizontal2;
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
                if ((i4 & Fields.SpotShadowColor) != 0) {
                }
                if (!startRestartGroup.shouldExecute((4793491 & i5) != 4793490, i5 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            horizontal3 = horizontal;
            i7 = i4 & 8;
            if (i7 != 0) {
            }
            horizontal4 = horizontal2;
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
            if ((i4 & Fields.SpotShadowColor) != 0) {
            }
            if (!startRestartGroup.shouldExecute((4793491 & i5) != 4793490, i5 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i6 = i4 & 4;
        if (i6 == 0) {
        }
        horizontal3 = horizontal;
        i7 = i4 & 8;
        if (i7 != 0) {
        }
        horizontal4 = horizontal2;
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
        if ((i4 & Fields.SpotShadowColor) != 0) {
        }
        if (!startRestartGroup.shouldExecute((4793491 & i5) != 4793490, i5 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void FlowColumn(Modifier modifier, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, Alignment.Horizontal horizontal2, int i, int i2, final Function3<? super FlowColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i3, final int i4) {
        int i5;
        Arrangement.Vertical vertical2;
        int i6;
        Arrangement.Horizontal horizontal3;
        int i7;
        Alignment.Horizontal horizontal4;
        int i8;
        int i9;
        int i10;
        int i11;
        Modifier modifier2;
        final Arrangement.Horizontal horizontal5;
        final Alignment.Horizontal horizontal6;
        final int i12;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(1371845627);
        ComposerKt.sourceInformation(startRestartGroup, "C(FlowColumn)N(modifier,verticalArrangement,horizontalArrangement,itemHorizontalAlignment,maxItemsInEachColumn,maxLines,content)271@11939L226:FlowLayout.kt#2w3rfo");
        int i13 = i4 & 1;
        if (i13 != 0) {
            i5 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i5 = (startRestartGroup.changed(modifier) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        int i14 = i4 & 2;
        if (i14 != 0) {
            i5 |= 48;
        } else if ((i3 & 48) == 0) {
            vertical2 = vertical;
            i5 |= startRestartGroup.changed(vertical2) ? 32 : 16;
            i6 = i4 & 4;
            if (i6 == 0) {
                i5 |= 384;
            } else if ((i3 & 384) == 0) {
                horizontal3 = horizontal;
                i5 |= startRestartGroup.changed(horizontal3) ? Fields.RotationX : Fields.SpotShadowColor;
                i7 = i4 & 8;
                if (i7 != 0) {
                    i5 |= 3072;
                } else if ((i3 & 3072) == 0) {
                    horizontal4 = horizontal2;
                    i5 |= startRestartGroup.changed(horizontal4) ? Fields.CameraDistance : Fields.RotationZ;
                    i8 = i4 & 16;
                    if (i8 == 0) {
                        i5 |= 24576;
                    } else if ((i3 & 24576) == 0) {
                        i9 = i;
                        i5 |= startRestartGroup.changed(i9) ? Fields.Clip : Fields.Shape;
                        i10 = i4 & 32;
                        if (i10 != 0) {
                            i5 |= 196608;
                        } else if ((196608 & i3) == 0) {
                            i11 = i2;
                            i5 |= startRestartGroup.changed(i11) ? Fields.RenderEffect : 65536;
                            if ((i4 & 64) == 0) {
                                i5 |= 1572864;
                            } else if ((i3 & 1572864) == 0) {
                                i5 |= startRestartGroup.changedInstance(function3) ? 1048576 : Fields.BlendMode;
                            }
                            if (startRestartGroup.shouldExecute((i5 & 599187) == 599186, i5 & 1)) {
                                startRestartGroup.skipToGroupEnd();
                                modifier2 = modifier;
                                horizontal5 = horizontal3;
                                horizontal6 = horizontal4;
                                i12 = i9;
                            } else {
                                Modifier.Companion companion = i13 != 0 ? Modifier.INSTANCE : modifier;
                                if (i14 != 0) {
                                    vertical2 = Arrangement.INSTANCE.getTop();
                                }
                                Arrangement.Horizontal start = i6 != 0 ? Arrangement.INSTANCE.getStart() : horizontal3;
                                Alignment.Horizontal start2 = i7 != 0 ? Alignment.INSTANCE.getStart() : horizontal4;
                                int i15 = i8 != 0 ? Integer.MAX_VALUE : i9;
                                int i16 = i10 == 0 ? i11 : Integer.MAX_VALUE;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1371845627, i5, -1, "androidx.compose.foundation.layout.FlowColumn (FlowLayout.kt:271)");
                                }
                                FlowColumn(companion, vertical2, start, start2, i15, i16, FlowColumnOverflow.INSTANCE.getClip(), function3, startRestartGroup, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                horizontal6 = start2;
                                i11 = i16;
                                i12 = i15;
                                horizontal5 = start;
                                modifier2 = companion;
                            }
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup == null) {
                                final Modifier modifier3 = modifier2;
                                final Arrangement.Vertical vertical3 = vertical2;
                                final int i17 = i11;
                                endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda0
                                    public final Object invoke(Object obj, Object obj2) {
                                        Unit FlowColumn$lambda$7;
                                        FlowColumn$lambda$7 = FlowLayoutKt.FlowColumn$lambda$7(Modifier.this, vertical3, horizontal5, horizontal6, i12, i17, function3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                        return FlowColumn$lambda$7;
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i11 = i2;
                        if ((i4 & 64) == 0) {
                        }
                        if (startRestartGroup.shouldExecute((i5 & 599187) == 599186, i5 & 1)) {
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i9 = i;
                    i10 = i4 & 32;
                    if (i10 != 0) {
                    }
                    i11 = i2;
                    if ((i4 & 64) == 0) {
                    }
                    if (startRestartGroup.shouldExecute((i5 & 599187) == 599186, i5 & 1)) {
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                horizontal4 = horizontal2;
                i8 = i4 & 16;
                if (i8 == 0) {
                }
                i9 = i;
                i10 = i4 & 32;
                if (i10 != 0) {
                }
                i11 = i2;
                if ((i4 & 64) == 0) {
                }
                if (startRestartGroup.shouldExecute((i5 & 599187) == 599186, i5 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            horizontal3 = horizontal;
            i7 = i4 & 8;
            if (i7 != 0) {
            }
            horizontal4 = horizontal2;
            i8 = i4 & 16;
            if (i8 == 0) {
            }
            i9 = i;
            i10 = i4 & 32;
            if (i10 != 0) {
            }
            i11 = i2;
            if ((i4 & 64) == 0) {
            }
            if (startRestartGroup.shouldExecute((i5 & 599187) == 599186, i5 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        vertical2 = vertical;
        i6 = i4 & 4;
        if (i6 == 0) {
        }
        horizontal3 = horizontal;
        i7 = i4 & 8;
        if (i7 != 0) {
        }
        horizontal4 = horizontal2;
        i8 = i4 & 16;
        if (i8 == 0) {
        }
        i9 = i;
        i10 = i4 & 32;
        if (i10 != 0) {
        }
        i11 = i2;
        if ((i4 & 64) == 0) {
        }
        if (startRestartGroup.shouldExecute((i5 & 599187) == 599186, i5 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x002f, code lost:
    
        if (r20.changed(r17) != false) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final MeasurePolicy rowMeasurementHelper(Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, int i, Composer composer, int i2) {
        boolean z;
        boolean z2;
        MeasurePolicy rememberedValue;
        ComposerKt.sourceInformationMarkerStart(composer, 1479255111, "C(rowMeasurementHelper)N(horizontalArrangement,verticalArrangement,maxItemsInMainAxis)440@17697L893:FlowLayout.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1479255111, i2, -1, "androidx.compose.foundation.layout.rowMeasurementHelper (FlowLayout.kt:439)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -70004252, "CC(remember):FlowLayout.kt#9igjgp");
        if (((i2 & 14) ^ 6) <= 4) {
        }
        if ((i2 & 6) != 4) {
            z = false;
            z2 = z | ((((i2 & 112) ^ 48) <= 32 && composer.changed(vertical)) || (i2 & 48) == 32) | ((((i2 & 896) ^ 384) > 256 && composer.changed(i)) || (i2 & 384) == 256);
            rememberedValue = composer.rememberedValue();
            if (!z2 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                final FlowMeasurePolicy flowMeasurePolicy = new FlowMeasurePolicy(true, horizontal, vertical, horizontal.getSpacing(), CROSS_AXIS_ALIGNMENT_TOP, vertical.getSpacing(), i, Integer.MAX_VALUE, FlowRowOverflow.INSTANCE.getVisible().createOverflowState$foundation_layout(), null);
                rememberedValue = new MeasurePolicy() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$rowMeasurementHelper$1$1
                    @Override // androidx.compose.p002ui.layout.MeasurePolicy
                    /* renamed from: measure-3p2s80s */
                    public final MeasureResult mo147measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                        return MultiContentMeasurePolicy.this.mo992measure3p2s80s(measureScope, CollectionsKt.listOf(list), j);
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            return measurePolicy;
        }
        z = true;
        if (((i2 & 896) ^ 384) > 256) {
            z2 = z | ((((i2 & 112) ^ 48) <= 32 && composer.changed(vertical)) || (i2 & 48) == 32) | ((((i2 & 896) ^ 384) > 256 && composer.changed(i)) || (i2 & 384) == 256);
            rememberedValue = composer.rememberedValue();
            if (!z2) {
            }
            final MultiContentMeasurePolicy flowMeasurePolicy2 = new FlowMeasurePolicy(true, horizontal, vertical, horizontal.getSpacing(), CROSS_AXIS_ALIGNMENT_TOP, vertical.getSpacing(), i, Integer.MAX_VALUE, FlowRowOverflow.INSTANCE.getVisible().createOverflowState$foundation_layout(), null);
            rememberedValue = new MeasurePolicy() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$rowMeasurementHelper$1$1
                @Override // androidx.compose.p002ui.layout.MeasurePolicy
                /* renamed from: measure-3p2s80s */
                public final MeasureResult mo147measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                    return MultiContentMeasurePolicy.this.mo992measure3p2s80s(measureScope, CollectionsKt.listOf(list), j);
                }
            };
            composer.updateRememberedValue(rememberedValue);
            MeasurePolicy measurePolicy2 = (MeasurePolicy) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            return measurePolicy2;
        }
        z2 = z | ((((i2 & 112) ^ 48) <= 32 && composer.changed(vertical)) || (i2 & 48) == 32) | ((((i2 & 896) ^ 384) > 256 && composer.changed(i)) || (i2 & 384) == 256);
        rememberedValue = composer.rememberedValue();
        if (!z2) {
        }
        final MultiContentMeasurePolicy flowMeasurePolicy22 = new FlowMeasurePolicy(true, horizontal, vertical, horizontal.getSpacing(), CROSS_AXIS_ALIGNMENT_TOP, vertical.getSpacing(), i, Integer.MAX_VALUE, FlowRowOverflow.INSTANCE.getVisible().createOverflowState$foundation_layout(), null);
        rememberedValue = new MeasurePolicy() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$rowMeasurementHelper$1$1
            @Override // androidx.compose.p002ui.layout.MeasurePolicy
            /* renamed from: measure-3p2s80s */
            public final MeasureResult mo147measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                return MultiContentMeasurePolicy.this.mo992measure3p2s80s(measureScope, CollectionsKt.listOf(list), j);
            }
        };
        composer.updateRememberedValue(rememberedValue);
        MeasurePolicy measurePolicy22 = (MeasurePolicy) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return measurePolicy22;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0031, code lost:
    
        if (r24.changed(r18) != false) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final MultiContentMeasurePolicy rowMeasurementMultiContentHelper(Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, Alignment.Vertical vertical2, int i, int i2, FlowLayoutOverflowState flowLayoutOverflowState, Composer composer, int i3) {
        boolean z;
        boolean changed;
        Object rememberedValue;
        ComposerKt.sourceInformationMarkerStart(composer, -2010142641, "C(rowMeasurementMultiContentHelper)N(horizontalArrangement,verticalArrangement,itemVerticalAlignment,maxItemsInMainAxis,maxLines,overflowState)471@18969L708:FlowLayout.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2010142641, i3, -1, "androidx.compose.foundation.layout.rowMeasurementMultiContentHelper (FlowLayout.kt:470)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 988217907, "CC(remember):FlowLayout.kt#9igjgp");
        if (((i3 & 14) ^ 6) <= 4) {
        }
        if ((i3 & 6) != 4) {
            z = false;
            changed = z | ((((i3 & 112) ^ 48) <= 32 && composer.changed(vertical)) || (i3 & 48) == 32) | ((((i3 & 896) ^ 384) <= 256 && composer.changed(vertical2)) || (i3 & 384) == 256) | ((((i3 & 7168) ^ 3072) <= 2048 && composer.changed(i)) || (i3 & 3072) == 2048) | ((((57344 & i3) ^ 24576) > 16384 && composer.changed(i2)) || (i3 & 24576) == 16384) | composer.changed(flowLayoutOverflowState);
            rememberedValue = composer.rememberedValue();
            if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new FlowMeasurePolicy(true, horizontal, vertical, horizontal.getSpacing(), CrossAxisAlignment.INSTANCE.vertical$foundation_layout(vertical2), vertical.getSpacing(), i, i2, flowLayoutOverflowState, null);
                composer.updateRememberedValue(rememberedValue);
            }
            FlowMeasurePolicy flowMeasurePolicy = (FlowMeasurePolicy) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            return flowMeasurePolicy;
        }
        z = true;
        if (((57344 & i3) ^ 24576) > 16384) {
            changed = z | ((((i3 & 112) ^ 48) <= 32 && composer.changed(vertical)) || (i3 & 48) == 32) | ((((i3 & 896) ^ 384) <= 256 && composer.changed(vertical2)) || (i3 & 384) == 256) | ((((i3 & 7168) ^ 3072) <= 2048 && composer.changed(i)) || (i3 & 3072) == 2048) | ((((57344 & i3) ^ 24576) > 16384 && composer.changed(i2)) || (i3 & 24576) == 16384) | composer.changed(flowLayoutOverflowState);
            rememberedValue = composer.rememberedValue();
            if (!changed) {
            }
            rememberedValue = new FlowMeasurePolicy(true, horizontal, vertical, horizontal.getSpacing(), CrossAxisAlignment.INSTANCE.vertical$foundation_layout(vertical2), vertical.getSpacing(), i, i2, flowLayoutOverflowState, null);
            composer.updateRememberedValue(rememberedValue);
            FlowMeasurePolicy flowMeasurePolicy2 = (FlowMeasurePolicy) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            return flowMeasurePolicy2;
        }
        changed = z | ((((i3 & 112) ^ 48) <= 32 && composer.changed(vertical)) || (i3 & 48) == 32) | ((((i3 & 896) ^ 384) <= 256 && composer.changed(vertical2)) || (i3 & 384) == 256) | ((((i3 & 7168) ^ 3072) <= 2048 && composer.changed(i)) || (i3 & 3072) == 2048) | ((((57344 & i3) ^ 24576) > 16384 && composer.changed(i2)) || (i3 & 24576) == 16384) | composer.changed(flowLayoutOverflowState);
        rememberedValue = composer.rememberedValue();
        if (!changed) {
        }
        rememberedValue = new FlowMeasurePolicy(true, horizontal, vertical, horizontal.getSpacing(), CrossAxisAlignment.INSTANCE.vertical$foundation_layout(vertical2), vertical.getSpacing(), i, i2, flowLayoutOverflowState, null);
        composer.updateRememberedValue(rememberedValue);
        FlowMeasurePolicy flowMeasurePolicy22 = (FlowMeasurePolicy) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return flowMeasurePolicy22;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x002f, code lost:
    
        if (r20.changed(r17) != false) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final MeasurePolicy columnMeasurementHelper(Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, int i, Composer composer, int i2) {
        boolean z;
        boolean z2;
        MeasurePolicy rememberedValue;
        ComposerKt.sourceInformationMarkerStart(composer, -2013098357, "C(columnMeasurementHelper)N(verticalArrangement,horizontalArrangement,maxItemsInMainAxis)501@19939L850:FlowLayout.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2013098357, i2, -1, "androidx.compose.foundation.layout.columnMeasurementHelper (FlowLayout.kt:500)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1852228771, "CC(remember):FlowLayout.kt#9igjgp");
        if (((i2 & 14) ^ 6) <= 4) {
        }
        if ((i2 & 6) != 4) {
            z = false;
            z2 = z | ((((i2 & 112) ^ 48) <= 32 && composer.changed(horizontal)) || (i2 & 48) == 32) | ((((i2 & 896) ^ 384) > 256 && composer.changed(i)) || (i2 & 384) == 256);
            rememberedValue = composer.rememberedValue();
            if (!z2 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                final FlowMeasurePolicy flowMeasurePolicy = new FlowMeasurePolicy(false, horizontal, vertical, vertical.getSpacing(), CROSS_AXIS_ALIGNMENT_START, horizontal.getSpacing(), i, Integer.MAX_VALUE, FlowRowOverflow.INSTANCE.getVisible().createOverflowState$foundation_layout(), null);
                rememberedValue = new MeasurePolicy() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$columnMeasurementHelper$1$1
                    @Override // androidx.compose.p002ui.layout.MeasurePolicy
                    /* renamed from: measure-3p2s80s */
                    public final MeasureResult mo147measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                        return FlowMeasurePolicy.this.mo992measure3p2s80s(measureScope, CollectionsKt.listOf(list), j);
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            return measurePolicy;
        }
        z = true;
        if (((i2 & 896) ^ 384) > 256) {
            z2 = z | ((((i2 & 112) ^ 48) <= 32 && composer.changed(horizontal)) || (i2 & 48) == 32) | ((((i2 & 896) ^ 384) > 256 && composer.changed(i)) || (i2 & 384) == 256);
            rememberedValue = composer.rememberedValue();
            if (!z2) {
            }
            final FlowMeasurePolicy flowMeasurePolicy2 = new FlowMeasurePolicy(false, horizontal, vertical, vertical.getSpacing(), CROSS_AXIS_ALIGNMENT_START, horizontal.getSpacing(), i, Integer.MAX_VALUE, FlowRowOverflow.INSTANCE.getVisible().createOverflowState$foundation_layout(), null);
            rememberedValue = new MeasurePolicy() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$columnMeasurementHelper$1$1
                @Override // androidx.compose.p002ui.layout.MeasurePolicy
                /* renamed from: measure-3p2s80s */
                public final MeasureResult mo147measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                    return FlowMeasurePolicy.this.mo992measure3p2s80s(measureScope, CollectionsKt.listOf(list), j);
                }
            };
            composer.updateRememberedValue(rememberedValue);
            MeasurePolicy measurePolicy2 = (MeasurePolicy) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            return measurePolicy2;
        }
        z2 = z | ((((i2 & 112) ^ 48) <= 32 && composer.changed(horizontal)) || (i2 & 48) == 32) | ((((i2 & 896) ^ 384) > 256 && composer.changed(i)) || (i2 & 384) == 256);
        rememberedValue = composer.rememberedValue();
        if (!z2) {
        }
        final FlowMeasurePolicy flowMeasurePolicy22 = new FlowMeasurePolicy(false, horizontal, vertical, vertical.getSpacing(), CROSS_AXIS_ALIGNMENT_START, horizontal.getSpacing(), i, Integer.MAX_VALUE, FlowRowOverflow.INSTANCE.getVisible().createOverflowState$foundation_layout(), null);
        rememberedValue = new MeasurePolicy() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$columnMeasurementHelper$1$1
            @Override // androidx.compose.p002ui.layout.MeasurePolicy
            /* renamed from: measure-3p2s80s */
            public final MeasureResult mo147measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                return FlowMeasurePolicy.this.mo992measure3p2s80s(measureScope, CollectionsKt.listOf(list), j);
            }
        };
        composer.updateRememberedValue(rememberedValue);
        MeasurePolicy measurePolicy22 = (MeasurePolicy) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return measurePolicy22;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0031, code lost:
    
        if (r24.changed(r18) != false) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final MultiContentMeasurePolicy columnMeasurementMultiContentHelper(Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, Alignment.Horizontal horizontal2, int i, int i2, FlowLayoutOverflowState flowLayoutOverflowState, Composer composer, int i3) {
        boolean z;
        boolean changed;
        Object rememberedValue;
        ComposerKt.sourceInformationMarkerStart(composer, -308635847, "C(columnMeasurementMultiContentHelper)N(verticalArrangement,horizontalArrangement,itemHorizontalAlignment,maxItemsInMainAxis,maxLines,overflowState)529@21138L715:FlowLayout.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-308635847, i3, -1, "androidx.compose.foundation.layout.columnMeasurementMultiContentHelper (FlowLayout.kt:528)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -246293788, "CC(remember):FlowLayout.kt#9igjgp");
        if (((i3 & 14) ^ 6) <= 4) {
        }
        if ((i3 & 6) != 4) {
            z = false;
            changed = z | ((((i3 & 112) ^ 48) <= 32 && composer.changed(horizontal)) || (i3 & 48) == 32) | ((((i3 & 896) ^ 384) <= 256 && composer.changed(horizontal2)) || (i3 & 384) == 256) | ((((i3 & 7168) ^ 3072) <= 2048 && composer.changed(i)) || (i3 & 3072) == 2048) | ((((57344 & i3) ^ 24576) > 16384 && composer.changed(i2)) || (i3 & 24576) == 16384) | composer.changed(flowLayoutOverflowState);
            rememberedValue = composer.rememberedValue();
            if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new FlowMeasurePolicy(false, horizontal, vertical, vertical.getSpacing(), CrossAxisAlignment.INSTANCE.horizontal$foundation_layout(horizontal2), horizontal.getSpacing(), i, i2, flowLayoutOverflowState, null);
                composer.updateRememberedValue(rememberedValue);
            }
            FlowMeasurePolicy flowMeasurePolicy = (FlowMeasurePolicy) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            return flowMeasurePolicy;
        }
        z = true;
        if (((57344 & i3) ^ 24576) > 16384) {
            changed = z | ((((i3 & 112) ^ 48) <= 32 && composer.changed(horizontal)) || (i3 & 48) == 32) | ((((i3 & 896) ^ 384) <= 256 && composer.changed(horizontal2)) || (i3 & 384) == 256) | ((((i3 & 7168) ^ 3072) <= 2048 && composer.changed(i)) || (i3 & 3072) == 2048) | ((((57344 & i3) ^ 24576) > 16384 && composer.changed(i2)) || (i3 & 24576) == 16384) | composer.changed(flowLayoutOverflowState);
            rememberedValue = composer.rememberedValue();
            if (!changed) {
            }
            rememberedValue = new FlowMeasurePolicy(false, horizontal, vertical, vertical.getSpacing(), CrossAxisAlignment.INSTANCE.horizontal$foundation_layout(horizontal2), horizontal.getSpacing(), i, i2, flowLayoutOverflowState, null);
            composer.updateRememberedValue(rememberedValue);
            FlowMeasurePolicy flowMeasurePolicy2 = (FlowMeasurePolicy) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            return flowMeasurePolicy2;
        }
        changed = z | ((((i3 & 112) ^ 48) <= 32 && composer.changed(horizontal)) || (i3 & 48) == 32) | ((((i3 & 896) ^ 384) <= 256 && composer.changed(horizontal2)) || (i3 & 384) == 256) | ((((i3 & 7168) ^ 3072) <= 2048 && composer.changed(i)) || (i3 & 3072) == 2048) | ((((57344 & i3) ^ 24576) > 16384 && composer.changed(i2)) || (i3 & 24576) == 16384) | composer.changed(flowLayoutOverflowState);
        rememberedValue = composer.rememberedValue();
        if (!changed) {
        }
        rememberedValue = new FlowMeasurePolicy(false, horizontal, vertical, vertical.getSpacing(), CrossAxisAlignment.INSTANCE.horizontal$foundation_layout(horizontal2), horizontal.getSpacing(), i, i2, flowLayoutOverflowState, null);
        composer.updateRememberedValue(rememberedValue);
        FlowMeasurePolicy flowMeasurePolicy22 = (FlowMeasurePolicy) rememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return flowMeasurePolicy22;
    }

    private static final int minIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> list, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function3, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function32, int i, int i2, int i3, int i4, int i5, FlowLayoutOverflowState flowLayoutOverflowState) {
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        int[] iArr = new int[size];
        int size2 = list.size();
        int[] iArr2 = new int[size2];
        int size3 = list.size();
        for (int i6 = 0; i6 < size3; i6++) {
            IntrinsicMeasurable intrinsicMeasurable = list.get(i6);
            int intValue = ((Number) function3.invoke(intrinsicMeasurable, Integer.valueOf(i6), Integer.valueOf(i))).intValue();
            iArr[i6] = intValue;
            iArr2[i6] = ((Number) function32.invoke(intrinsicMeasurable, Integer.valueOf(i6), Integer.valueOf(intValue))).intValue();
        }
        int i7 = Integer.MAX_VALUE;
        if (i5 != Integer.MAX_VALUE && i4 != Integer.MAX_VALUE) {
            i7 = i4 * i5;
        }
        int i8 = 1;
        int min = Math.min(i7 - (((i7 >= list.size() || !(flowLayoutOverflowState.getType$foundation_layout() == FlowLayoutOverflow.OverflowType.ExpandIndicator || flowLayoutOverflowState.getType$foundation_layout() == FlowLayoutOverflow.OverflowType.ExpandOrCollapseIndicator)) && (i7 < list.size() || i5 < flowLayoutOverflowState.getMinLinesToShowCollapse$foundation_layout() || flowLayoutOverflowState.getType$foundation_layout() != FlowLayoutOverflow.OverflowType.ExpandOrCollapseIndicator)) ? 0 : 1), list.size());
        int sum = ArraysKt.sum(iArr) + ((list.size() - 1) * i2);
        if (!(size2 == 0)) {
            int i9 = iArr2[0];
            int lastIndex = ArraysKt.getLastIndex(iArr2);
            if (1 <= lastIndex) {
                int i10 = 1;
                while (true) {
                    int i11 = iArr2[i10];
                    if (i9 < i11) {
                        i9 = i11;
                    }
                    if (i10 == lastIndex) {
                        break;
                    }
                    i10++;
                }
            }
            if (!(size == 0)) {
                int i12 = iArr[0];
                int lastIndex2 = ArraysKt.getLastIndex(iArr);
                if (1 <= lastIndex2) {
                    while (true) {
                        int i13 = iArr[i8];
                        if (i12 < i13) {
                            i12 = i13;
                        }
                        if (i8 == lastIndex2) {
                            break;
                        }
                        i8++;
                    }
                }
                int i14 = i12;
                int i15 = sum;
                while (i14 <= i15 && i9 != i) {
                    int i16 = (i14 + i15) / 2;
                    int i17 = i15;
                    int i18 = i14;
                    long intrinsicCrossAxisSize = intrinsicCrossAxisSize(list, iArr, iArr2, i16, i2, i3, i4, i5, flowLayoutOverflowState);
                    i9 = IntIntPair.m127getFirstimpl(intrinsicCrossAxisSize);
                    int m128getSecondimpl = IntIntPair.m128getSecondimpl(intrinsicCrossAxisSize);
                    if (i9 > i || m128getSecondimpl < min) {
                        i14 = i16 + 1;
                        if (i14 > i17) {
                            return i14;
                        }
                        i15 = i17;
                        sum = i16;
                    } else {
                        if (i9 >= i) {
                            return i16;
                        }
                        i15 = i16 - 1;
                        sum = i16;
                        i14 = i18;
                    }
                }
                return sum;
            }
            throw new NoSuchElementException();
        }
        throw new NoSuchElementException();
    }

    private static final long intrinsicCrossAxisSize(List<? extends IntrinsicMeasurable> list, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function3, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function32, int i, int i2, int i3, int i4, int i5, FlowLayoutOverflowState flowLayoutOverflowState) {
        int i6;
        int i7;
        int i8 = 0;
        if (list.isEmpty()) {
            return IntIntPair.m123constructorimpl(0, 0);
        }
        FlowLayoutBuildingBlocks flowLayoutBuildingBlocks = new FlowLayoutBuildingBlocks(i4, flowLayoutOverflowState, OrientationIndependentConstraints.m1029constructorimpl(0, i, 0, Integer.MAX_VALUE), i5, i2, i3, null);
        IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) CollectionsKt.getOrNull(list, 0);
        int intValue = intrinsicMeasurable != null ? ((Number) function32.invoke(intrinsicMeasurable, 0, Integer.valueOf(i))).intValue() : 0;
        int intValue2 = intrinsicMeasurable != null ? ((Number) function3.invoke(intrinsicMeasurable, 0, Integer.valueOf(intValue))).intValue() : 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        if (flowLayoutBuildingBlocks.m964getWrapInfoOpUlnko(list.size() > 1, 0, IntIntPair.m123constructorimpl(i, Integer.MAX_VALUE), intrinsicMeasurable == null ? null : IntIntPair.m120boximpl(IntIntPair.m123constructorimpl(intValue2, intValue)), 0, 0, 0, false, false).getIsLastItemInContainer()) {
            IntIntPair m973ellipsisSizeF35zmw$foundation_layout = flowLayoutOverflowState.m973ellipsisSizeF35zmw$foundation_layout(intrinsicMeasurable != null, 0, 0);
            return IntIntPair.m123constructorimpl(m973ellipsisSizeF35zmw$foundation_layout != null ? IntIntPair.m128getSecondimpl(m973ellipsisSizeF35zmw$foundation_layout.getPackedValue()) : 0, 0);
        }
        int size = list.size();
        int i12 = i;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (true) {
            if (i13 >= size) {
                i6 = i14;
                break;
            }
            int i16 = i12 - intValue2;
            i6 = i13 + 1;
            int max = Math.max(i9, intValue);
            IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) CollectionsKt.getOrNull(list, i6);
            int intValue3 = intrinsicMeasurable2 != null ? ((Number) function32.invoke(intrinsicMeasurable2, Integer.valueOf(i6), Integer.valueOf(i))).intValue() : i8;
            int intValue4 = intrinsicMeasurable2 != null ? ((Number) function3.invoke(intrinsicMeasurable2, Integer.valueOf(i6), Integer.valueOf(intValue3))).intValue() + i2 : 0;
            boolean z = i13 + 2 < list.size();
            int i17 = i6 - i15;
            FlowLayoutBuildingBlocks.WrapInfo m964getWrapInfoOpUlnko = flowLayoutBuildingBlocks.m964getWrapInfoOpUlnko(z, i17, IntIntPair.m123constructorimpl(i16, Integer.MAX_VALUE), intrinsicMeasurable2 == null ? null : IntIntPair.m120boximpl(IntIntPair.m123constructorimpl(intValue4, intValue3)), i11, i10, max, false, false);
            if (m964getWrapInfoOpUlnko.getIsLastItemInLine()) {
                i10 += max + i3;
                FlowLayoutBuildingBlocks.WrapEllipsisInfo wrapEllipsisInfo = flowLayoutBuildingBlocks.getWrapEllipsisInfo(m964getWrapInfoOpUlnko, intrinsicMeasurable2 != null, i11, i10, i16, i17);
                int i18 = intValue4 - i2;
                i11++;
                if (!m964getWrapInfoOpUlnko.getIsLastItemInContainer()) {
                    i7 = i;
                    intValue2 = i18;
                    i15 = i6;
                    i9 = 0;
                } else if (wrapEllipsisInfo != null) {
                    long ellipsisSize = wrapEllipsisInfo.getEllipsisSize();
                    if (!wrapEllipsisInfo.getPlaceEllipsisOnLastContentLine()) {
                        i10 += IntIntPair.m128getSecondimpl(ellipsisSize) + i3;
                    }
                }
            } else {
                i9 = max;
                i7 = i16;
                intValue2 = intValue4;
            }
            i13 = i6;
            i14 = i13;
            i8 = 0;
            i12 = i7;
            intValue = intValue3;
        }
        return IntIntPair.m123constructorimpl(i10 - i3, i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit breakDownItems_di9J0FM$lambda$20$lambda$19(Ref.ObjectRef objectRef, Placeable placeable) {
        objectRef.element = placeable;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit breakDownItems_di9J0FM$lambda$23$lambda$22(Ref.ObjectRef objectRef, Placeable placeable) {
        objectRef.element = placeable;
        return Unit.INSTANCE;
    }

    private static final Measurable safeNext(Iterator<? extends Measurable> it, FlowLineInfo flowLineInfo) {
        Measurable next;
        try {
            if (it instanceof ContextualFlowItemIterator) {
                Intrinsics.checkNotNull(flowLineInfo);
                next = ((ContextualFlowItemIterator) it).getNext$foundation_layout(flowLineInfo);
            } else {
                next = it.next();
            }
            return next;
        } catch (IndexOutOfBoundsException unused) {
            return null;
        }
    }

    public static final int mainAxisMin(IntrinsicMeasurable intrinsicMeasurable, boolean z, int i) {
        if (z) {
            return intrinsicMeasurable.minIntrinsicWidth(i);
        }
        return intrinsicMeasurable.minIntrinsicHeight(i);
    }

    public static final int crossAxisMin(IntrinsicMeasurable intrinsicMeasurable, boolean z, int i) {
        if (z) {
            return intrinsicMeasurable.minIntrinsicHeight(i);
        }
        return intrinsicMeasurable.minIntrinsicWidth(i);
    }

    public static final CrossAxisAlignment getCROSS_AXIS_ALIGNMENT_TOP() {
        return CROSS_AXIS_ALIGNMENT_TOP;
    }

    public static final CrossAxisAlignment getCROSS_AXIS_ALIGNMENT_START() {
        return CROSS_AXIS_ALIGNMENT_START;
    }

    /* renamed from: measureAndCache-rqJ1uqs, reason: not valid java name */
    public static final long m971measureAndCacherqJ1uqs(Measurable measurable, FlowLineMeasurePolicy flowLineMeasurePolicy, long j, Function1<? super Placeable, Unit> function1) {
        FlowLayoutData flowLayoutData;
        Measurable measurable2 = measurable;
        if (RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(measurable2)) == 0.0f) {
            RowColumnParentData rowColumnParentData = RowColumnImplKt.getRowColumnParentData(measurable2);
            if (((rowColumnParentData == null || (flowLayoutData = rowColumnParentData.getFlowLayoutData()) == null) ? null : Float.valueOf(flowLayoutData.getFillCrossAxisFraction())) == null) {
                Placeable mo6318measureBRTryo0 = measurable.mo6318measureBRTryo0(j);
                function1.invoke(mo6318measureBRTryo0);
                return IntIntPair.m123constructorimpl(flowLineMeasurePolicy.mainAxisSize(mo6318measureBRTryo0), flowLineMeasurePolicy.crossAxisSize(mo6318measureBRTryo0));
            }
        }
        int mainAxisMin = mainAxisMin(measurable2, flowLineMeasurePolicy.isHorizontal(), Integer.MAX_VALUE);
        return IntIntPair.m123constructorimpl(mainAxisMin, crossAxisMin(measurable2, flowLineMeasurePolicy.isHorizontal(), mainAxisMin));
    }

    /* renamed from: placeHelper-BmaY500, reason: not valid java name */
    public static final MeasureResult m972placeHelperBmaY500(MeasureScope measureScope, long j, int i, int i2, int[] iArr, final MutableVector<MeasureResult> mutableVector, FlowLineMeasurePolicy flowLineMeasurePolicy, int[] iArr2) {
        int i3;
        boolean isHorizontal = flowLineMeasurePolicy.isHorizontal();
        Arrangement.Vertical verticalArrangement = flowLineMeasurePolicy.getVerticalArrangement();
        Arrangement.Horizontal horizontalArrangement = flowLineMeasurePolicy.getHorizontalArrangement();
        if (isHorizontal) {
            int i4 = (measureScope.roundToPx-0680j_4(verticalArrangement.getSpacing()) * (mutableVector.getSize() - 1)) + i2;
            int i5 = Constraints.getMinHeight-impl(j);
            i3 = Constraints.getMaxHeight-impl(j);
            if (i4 < i5) {
                i4 = i5;
            }
            if (i4 <= i3) {
                i3 = i4;
            }
            verticalArrangement.arrange(measureScope, i3, iArr, iArr2);
        } else {
            int i6 = (measureScope.roundToPx-0680j_4(horizontalArrangement.getSpacing()) * (mutableVector.getSize() - 1)) + i2;
            int i7 = Constraints.getMinHeight-impl(j);
            int i8 = Constraints.getMaxHeight-impl(j);
            if (i6 < i7) {
                i6 = i7;
            }
            if (i6 > i8) {
                i6 = i8;
            }
            i3 = i6;
            horizontalArrangement.arrange(measureScope, i3, iArr, measureScope.getLayoutDirection(), iArr2);
        }
        int i9 = Constraints.getMinWidth-impl(j);
        int i10 = Constraints.getMaxWidth-impl(j);
        if (i >= i9) {
            i9 = i;
        }
        if (i9 <= i10) {
            i10 = i9;
        }
        if (!isHorizontal) {
            int i11 = i3;
            i3 = i10;
            i10 = i11;
        }
        return MeasureScope.layout$default(measureScope, i10, i3, null, new Function1() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit placeHelper_BmaY500$lambda$30;
                placeHelper_BmaY500$lambda$30 = FlowLayoutKt.placeHelper_BmaY500$lambda$30(MutableVector.this, (Placeable.PlacementScope) obj);
                return placeHelper_BmaY500$lambda$30;
            }
        }, 4, null);
    }

    private static final int maxIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> list, Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer> function3, int i, int i2, int i3) {
        int size = list.size();
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i4 < size) {
            int intValue = ((Number) function3.invoke(list.get(i4), Integer.valueOf(i4), Integer.valueOf(i))).intValue() + i2;
            int i8 = i4 + 1;
            if (i8 - i6 == i3 || i8 == list.size()) {
                i5 = Math.max(i5, (i7 + intValue) - i2);
                i7 = 0;
                i6 = i4;
            } else {
                i7 += intValue;
            }
            i4 = i8;
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long intrinsicCrossAxisSize(List<? extends IntrinsicMeasurable> list, int[] iArr, int[] iArr2, int i, int i2, int i3, int i4, int i5, FlowLayoutOverflowState flowLayoutOverflowState) {
        if (list.isEmpty()) {
            return IntIntPair.m123constructorimpl(0, 0);
        }
        FlowLayoutBuildingBlocks flowLayoutBuildingBlocks = new FlowLayoutBuildingBlocks(i4, flowLayoutOverflowState, OrientationIndependentConstraints.m1029constructorimpl(0, i, 0, Integer.MAX_VALUE), i5, i2, i3, null);
        IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) CollectionsKt.getOrNull(list, 0);
        int i6 = intrinsicMeasurable != null ? iArr2[0] : 0;
        int i7 = intrinsicMeasurable != null ? iArr[0] : 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        if (flowLayoutBuildingBlocks.m964getWrapInfoOpUlnko(list.size() > 1, 0, IntIntPair.m123constructorimpl(i, Integer.MAX_VALUE), intrinsicMeasurable == null ? null : IntIntPair.m120boximpl(IntIntPair.m123constructorimpl(i7, i6)), 0, 0, 0, false, false).getIsLastItemInContainer()) {
            IntIntPair m973ellipsisSizeF35zmw$foundation_layout = flowLayoutOverflowState.m973ellipsisSizeF35zmw$foundation_layout(intrinsicMeasurable != null, 0, 0);
            return IntIntPair.m123constructorimpl(m973ellipsisSizeF35zmw$foundation_layout != null ? IntIntPair.m128getSecondimpl(m973ellipsisSizeF35zmw$foundation_layout.getPackedValue()) : 0, 0);
        }
        int size = list.size();
        int i11 = i;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (true) {
            if (i12 >= size) {
                break;
            }
            int i15 = i11 - i7;
            int i16 = i12 + 1;
            int max = Math.max(i8, i6);
            IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) CollectionsKt.getOrNull(list, i16);
            int i17 = intrinsicMeasurable2 != null ? iArr2[i16] : 0;
            int i18 = intrinsicMeasurable2 != null ? iArr[i16] + i2 : 0;
            boolean z = i12 + 2 < list.size();
            int i19 = i16 - i14;
            int i20 = i18;
            int i21 = i17;
            FlowLayoutBuildingBlocks.WrapInfo m964getWrapInfoOpUlnko = flowLayoutBuildingBlocks.m964getWrapInfoOpUlnko(z, i19, IntIntPair.m123constructorimpl(i15, Integer.MAX_VALUE), intrinsicMeasurable2 == null ? null : IntIntPair.m120boximpl(IntIntPair.m123constructorimpl(i18, i17)), i10, i9, max, false, false);
            if (m964getWrapInfoOpUlnko.getIsLastItemInLine()) {
                i9 += max + i3;
                FlowLayoutBuildingBlocks.WrapEllipsisInfo wrapEllipsisInfo = flowLayoutBuildingBlocks.getWrapEllipsisInfo(m964getWrapInfoOpUlnko, intrinsicMeasurable2 != null, i10, i9, i15, i19);
                int i22 = i20 - i2;
                i10++;
                if (m964getWrapInfoOpUlnko.getIsLastItemInContainer()) {
                    if (wrapEllipsisInfo != null) {
                        long ellipsisSize = wrapEllipsisInfo.getEllipsisSize();
                        if (!wrapEllipsisInfo.getPlaceEllipsisOnLastContentLine()) {
                            i9 += IntIntPair.m128getSecondimpl(ellipsisSize) + i3;
                        }
                    }
                    i13 = i16;
                } else {
                    i14 = i16;
                    i8 = 0;
                    i7 = i22;
                    i11 = i;
                }
            } else {
                i8 = max;
                i11 = i15;
                i7 = i20;
            }
            i12 = i16;
            i13 = i12;
            i6 = i21;
        }
        return IntIntPair.m123constructorimpl(i9 - i3, i13);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0455  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x045e  */
    /* renamed from: breakDownItems-di9J0FM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final MeasureResult m970breakDownItemsdi9J0FM(MeasureScope measureScope, FlowLineMeasurePolicy flowLineMeasurePolicy, Iterator<? extends Measurable> it, float f, float f2, long j, int i, int i2, FlowLayoutOverflowState flowLayoutOverflowState) {
        Measurable measurable;
        Integer num;
        MutableIntList mutableIntList;
        Measurable measurable2;
        FlowLineInfo flowLineInfo;
        Ref.ObjectRef objectRef;
        boolean z;
        int i3;
        int i4;
        int i5;
        ArrayList arrayList;
        long j2;
        int i6;
        MutableIntList mutableIntList2;
        FlowLayoutBuildingBlocks.WrapEllipsisInfo wrapEllipsisInfo;
        ArrayList arrayList2;
        MutableIntObjectMap mutableIntObjectMap;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        FlowLineInfo flowLineInfo2;
        boolean z2;
        boolean z3;
        int i12;
        MutableIntObjectMap mutableIntObjectMap2;
        int i13;
        Ref.ObjectRef objectRef2;
        long j3;
        IntIntPair intIntPair;
        long j4;
        IntIntPair m120boximpl;
        int i14;
        MutableIntSet mutableIntSet;
        MutableIntList mutableIntList3;
        int i15;
        MutableIntList mutableIntList4;
        int i16;
        int i17;
        int i18;
        int i19;
        FlowLayoutBuildingBlocks.WrapEllipsisInfo wrapEllipsisInfo2;
        int i20;
        int i21;
        int i22;
        FlowLayoutData flowLayoutData;
        Iterator<? extends Measurable> it2 = it;
        MutableVector mutableVector = new MutableVector(new MeasureResult[16], 0);
        int i23 = Constraints.getMaxWidth-impl(j);
        int i24 = Constraints.getMinWidth-impl(j);
        int i25 = Constraints.getMaxHeight-impl(j);
        MutableIntObjectMap mutableIntObjectMapOf = IntObjectMapKt.mutableIntObjectMapOf();
        ArrayList arrayList3 = new ArrayList();
        int ceil = (int) Math.ceil(measureScope.toPx-0680j_4(f));
        int ceil2 = (int) Math.ceil(measureScope.toPx-0680j_4(f2));
        long m1029constructorimpl = OrientationIndependentConstraints.m1029constructorimpl(0, i23, 0, i25);
        long m1044toBoxConstraintsOenEA2s = OrientationIndependentConstraints.m1044toBoxConstraintsOenEA2s(OrientationIndependentConstraints.m1033copyyUG9Ft0$default(m1029constructorimpl, 0, 0, 0, 0, 14, null), flowLineMeasurePolicy.isHorizontal() ? LayoutOrientation.Horizontal : LayoutOrientation.Vertical);
        final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        FlowLineInfo flowLineInfo3 = it2 instanceof ContextualFlowItemIterator ? new FlowLineInfo(0, 0, measureScope.toDp-u2uoSUM(i23), measureScope.toDp-u2uoSUM(i25), null) : null;
        Measurable safeNext = !it.hasNext() ? null : safeNext(it2, flowLineInfo3);
        IntIntPair m120boximpl2 = safeNext != null ? IntIntPair.m120boximpl(m971measureAndCacherqJ1uqs(safeNext, flowLineMeasurePolicy, m1044toBoxConstraintsOenEA2s, new Function1() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit breakDownItems_di9J0FM$lambda$20$lambda$19;
                breakDownItems_di9J0FM$lambda$20$lambda$19 = FlowLayoutKt.breakDownItems_di9J0FM$lambda$20$lambda$19(objectRef3, (Placeable) obj);
                return breakDownItems_di9J0FM$lambda$20$lambda$19;
            }
        })) : null;
        Integer valueOf = m120boximpl2 != null ? Integer.valueOf(IntIntPair.m127getFirstimpl(m120boximpl2.getPackedValue())) : null;
        if (m120boximpl2 != null) {
            measurable = safeNext;
            num = Integer.valueOf(IntIntPair.m128getSecondimpl(m120boximpl2.getPackedValue()));
        } else {
            measurable = safeNext;
            num = null;
        }
        MutableIntList mutableIntList5 = new MutableIntList(0, 1, null);
        MutableIntList mutableIntList6 = new MutableIntList(0, 1, null);
        MutableIntSet mutableIntSetOf = IntSetKt.mutableIntSetOf();
        FlowLayoutBuildingBlocks flowLayoutBuildingBlocks = new FlowLayoutBuildingBlocks(i, flowLayoutOverflowState, j, i2, ceil, ceil2, null);
        FlowLayoutBuildingBlocks.WrapInfo m964getWrapInfoOpUlnko = flowLayoutBuildingBlocks.m964getWrapInfoOpUlnko(it.hasNext(), 0, IntIntPair.m123constructorimpl(i23, i25), m120boximpl2, 0, 0, 0, false, false);
        if (m964getWrapInfoOpUlnko.getIsLastItemInContainer()) {
            flowLineInfo = flowLineInfo3;
            objectRef = objectRef3;
            j2 = m1044toBoxConstraintsOenEA2s;
            boolean z4 = m120boximpl2 != null;
            z = true;
            i3 = ceil2;
            i4 = ceil;
            mutableIntList = mutableIntList5;
            measurable2 = measurable;
            i5 = i24;
            arrayList = arrayList3;
            i6 = i25;
            mutableIntList2 = mutableIntList6;
            wrapEllipsisInfo = flowLayoutBuildingBlocks.getWrapEllipsisInfo(m964getWrapInfoOpUlnko, z4, -1, 0, i23, 0);
        } else {
            mutableIntList = mutableIntList5;
            measurable2 = measurable;
            flowLineInfo = flowLineInfo3;
            objectRef = objectRef3;
            z = true;
            i3 = ceil2;
            i4 = ceil;
            i5 = i24;
            arrayList = arrayList3;
            j2 = m1044toBoxConstraintsOenEA2s;
            i6 = i25;
            mutableIntList2 = mutableIntList6;
            wrapEllipsisInfo = null;
        }
        FlowLayoutBuildingBlocks.WrapEllipsisInfo wrapEllipsisInfo3 = wrapEllipsisInfo;
        Measurable measurable3 = measurable2;
        int i26 = i5;
        int i27 = 0;
        int i28 = i6;
        boolean z5 = false;
        int i29 = 0;
        int i30 = 0;
        int i31 = 0;
        int i32 = 0;
        int i33 = 0;
        int i34 = i23;
        while (!m964getWrapInfoOpUlnko.getIsLastItemInContainer() && measurable3 != null) {
            Intrinsics.checkNotNull(valueOf);
            int intValue = valueOf.intValue();
            Intrinsics.checkNotNull(num);
            MutableIntSet mutableIntSet2 = mutableIntSetOf;
            int i35 = i30 + intValue;
            int max = Math.max(i31, num.intValue());
            int i36 = i34 - intValue;
            MutableIntList mutableIntList7 = mutableIntList2;
            int i37 = i29 + 1;
            int i38 = i23;
            flowLayoutOverflowState.setItemShown$foundation_layout(i37);
            arrayList.add(measurable3);
            ArrayList arrayList4 = arrayList;
            final Ref.ObjectRef objectRef4 = objectRef;
            mutableIntObjectMapOf.set(i29, objectRef4.element);
            Object parentData = measurable3.getParentData();
            RowColumnParentData rowColumnParentData = parentData instanceof RowColumnParentData ? (RowColumnParentData) parentData : null;
            boolean z6 = ((rowColumnParentData == null || (flowLayoutData = rowColumnParentData.getFlowLayoutData()) == null) ? null : Float.valueOf(flowLayoutData.getFillCrossAxisFraction())) != null ? z : z5;
            int i39 = i37 - i32;
            if (i39 < i) {
                z2 = z;
                flowLineInfo2 = flowLineInfo;
            } else {
                flowLineInfo2 = flowLineInfo;
                z2 = false;
            }
            if (flowLineInfo2 != null) {
                if (z2) {
                    mutableIntObjectMap2 = mutableIntObjectMapOf;
                    i20 = i27;
                } else {
                    mutableIntObjectMap2 = mutableIntObjectMapOf;
                    i20 = i27 + 1;
                }
                i12 = i37;
                int i40 = z2 ? i39 : 0;
                if (z2) {
                    int i41 = i36 - i4;
                    z3 = z6;
                    i21 = i41 < 0 ? 0 : i41;
                } else {
                    z3 = z6;
                    i21 = i38;
                }
                float f3 = measureScope.toDp-u2uoSUM(i21);
                if (z2) {
                    i13 = i3;
                    i22 = i28;
                } else {
                    int i42 = (i28 - max) - i3;
                    i13 = i3;
                    i22 = i42 < 0 ? 0 : i42;
                }
                flowLineInfo2.m981update4j6BHR0$foundation_layout(i20, i40, f3, measureScope.toDp-u2uoSUM(i22));
                Unit unit = Unit.INSTANCE;
            } else {
                z3 = z6;
                i12 = i37;
                mutableIntObjectMap2 = mutableIntObjectMapOf;
                i13 = i3;
            }
            Measurable safeNext2 = !it.hasNext() ? null : safeNext(it2, flowLineInfo2);
            objectRef4.element = null;
            if (safeNext2 != null) {
                objectRef2 = objectRef4;
                j3 = j2;
                intIntPair = IntIntPair.m120boximpl(m971measureAndCacherqJ1uqs(safeNext2, flowLineMeasurePolicy, j3, new Function1() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj) {
                        Unit breakDownItems_di9J0FM$lambda$23$lambda$22;
                        breakDownItems_di9J0FM$lambda$23$lambda$22 = FlowLayoutKt.breakDownItems_di9J0FM$lambda$23$lambda$22(objectRef4, (Placeable) obj);
                        return breakDownItems_di9J0FM$lambda$23$lambda$22;
                    }
                }));
            } else {
                objectRef2 = objectRef4;
                j3 = j2;
                intIntPair = null;
            }
            Integer valueOf2 = intIntPair != null ? Integer.valueOf(IntIntPair.m127getFirstimpl(intIntPair.getPackedValue()) + i4) : null;
            Integer valueOf3 = intIntPair != null ? Integer.valueOf(IntIntPair.m128getSecondimpl(intIntPair.getPackedValue())) : null;
            boolean hasNext = it.hasNext();
            long m123constructorimpl = IntIntPair.m123constructorimpl(i36, i28);
            if (intIntPair == null) {
                j4 = j3;
                m120boximpl = null;
            } else {
                Intrinsics.checkNotNull(valueOf2);
                int intValue2 = valueOf2.intValue();
                Intrinsics.checkNotNull(valueOf3);
                j4 = j3;
                m120boximpl = IntIntPair.m120boximpl(IntIntPair.m123constructorimpl(intValue2, valueOf3.intValue()));
            }
            FlowLayoutBuildingBlocks.WrapInfo m964getWrapInfoOpUlnko2 = flowLayoutBuildingBlocks.m964getWrapInfoOpUlnko(hasNext, i39, m123constructorimpl, m120boximpl, i27, i33, max, false, false);
            if (m964getWrapInfoOpUlnko2.getIsLastItemInLine()) {
                i15 = i38;
                int min = Math.min(Math.max(i26, i35), i15);
                int i43 = i33 + max;
                wrapEllipsisInfo2 = flowLayoutBuildingBlocks.getWrapEllipsisInfo(m964getWrapInfoOpUlnko2, intIntPair != null ? z : false, i27, i43, i36, i39);
                mutableIntList3 = mutableIntList7;
                mutableIntList3.add(max);
                mutableIntSet = mutableIntSet2;
                if (z3) {
                    mutableIntSet.plusAssign(i27);
                }
                int i44 = (i6 - i43) - i13;
                int i45 = i12;
                MutableIntList mutableIntList8 = mutableIntList;
                mutableIntList8.add(i45);
                i33 = i43 + i13;
                i28 = i44;
                i34 = i15;
                i32 = i45;
                valueOf = valueOf2 != null ? Integer.valueOf(valueOf2.intValue() - i4) : null;
                z3 = false;
                i18 = i27 + 1;
                i14 = i32;
                i16 = 0;
                i19 = min;
                mutableIntList4 = mutableIntList8;
                i17 = 0;
            } else {
                i14 = i12;
                mutableIntSet = mutableIntSet2;
                mutableIntList3 = mutableIntList7;
                i15 = i38;
                mutableIntList4 = mutableIntList;
                i34 = i36;
                valueOf = valueOf2;
                i16 = max;
                i17 = i35;
                i18 = i27;
                i19 = i26;
                wrapEllipsisInfo2 = wrapEllipsisInfo3;
            }
            mutableIntList = mutableIntList4;
            wrapEllipsisInfo3 = wrapEllipsisInfo2;
            i26 = i19;
            i27 = i18;
            i30 = i17;
            i23 = i15;
            mutableIntList2 = mutableIntList3;
            i31 = i16;
            mutableIntObjectMapOf = mutableIntObjectMap2;
            z5 = z3;
            num = valueOf3;
            j2 = j4;
            mutableIntSetOf = mutableIntSet;
            flowLineInfo = flowLineInfo2;
            arrayList = arrayList4;
            measurable3 = safeNext2;
            i29 = i14;
            m964getWrapInfoOpUlnko = m964getWrapInfoOpUlnko2;
            it2 = it;
            int i46 = i13;
            objectRef = objectRef2;
            i3 = i46;
        }
        ArrayList arrayList5 = arrayList;
        MutableIntObjectMap mutableIntObjectMap3 = mutableIntObjectMapOf;
        MutableIntSet mutableIntSet3 = mutableIntSetOf;
        MutableIntList mutableIntList9 = mutableIntList;
        MutableIntList mutableIntList10 = mutableIntList2;
        if (wrapEllipsisInfo3 != null) {
            arrayList2 = arrayList5;
            arrayList2.add(wrapEllipsisInfo3.getEllipsis());
            mutableIntObjectMap = mutableIntObjectMap3;
            mutableIntObjectMap.set(arrayList2.size() - 1, wrapEllipsisInfo3.getPlaceable());
            MutableIntList mutableIntList11 = mutableIntList9;
            int i47 = mutableIntList11._size - 1;
            if (wrapEllipsisInfo3.getPlaceEllipsisOnLastContentLine()) {
                int i48 = mutableIntList11._size - 1;
                mutableIntList10.set(i47, Math.max(mutableIntList10.get(i47), IntIntPair.m128getSecondimpl(wrapEllipsisInfo3.getEllipsisSize())));
                mutableIntList9.set(i48, mutableIntList9.last() + 1);
                Unit unit2 = Unit.INSTANCE;
            } else {
                mutableIntList10.add(IntIntPair.m128getSecondimpl(wrapEllipsisInfo3.getEllipsisSize()));
                Boolean.valueOf(mutableIntList9.add(mutableIntList9.last() + 1));
            }
        } else {
            arrayList2 = arrayList5;
            mutableIntObjectMap = mutableIntObjectMap3;
        }
        int size = arrayList2.size();
        Placeable[] placeableArr = new Placeable[size];
        for (int i49 = 0; i49 < size; i49++) {
            placeableArr[i49] = mutableIntObjectMap.get(i49);
        }
        MutableIntList mutableIntList12 = mutableIntList9;
        int[] iArr = new int[mutableIntList12._size];
        int[] iArr2 = new int[mutableIntList12._size];
        int[] iArr3 = mutableIntList12.content;
        int i50 = mutableIntList12._size;
        int i51 = i26;
        int i52 = 0;
        int i53 = 0;
        int i54 = 0;
        while (i52 < i50) {
            int i55 = iArr3[i52];
            int i56 = mutableIntList10.get(i52);
            if (!mutableIntSet3.contains(i52)) {
                if (Constraints.getMaxHeight-impl(m1029constructorimpl) == Integer.MAX_VALUE) {
                    i9 = Integer.MAX_VALUE;
                    int i57 = i52;
                    int i58 = i51;
                    int i59 = i50;
                    int[] iArr4 = iArr3;
                    ArrayList arrayList6 = arrayList2;
                    MutableIntSet mutableIntSet4 = mutableIntSet3;
                    ArrayList arrayList7 = arrayList2;
                    int i60 = i53;
                    int[] iArr5 = iArr2;
                    MutableIntList mutableIntList13 = mutableIntList10;
                    int[] iArr6 = iArr;
                    MeasureResult measure = RowColumnMeasurePolicyKt.measure(flowLineMeasurePolicy, i51, Constraints.getMinHeight-impl(m1029constructorimpl), Constraints.getMaxWidth-impl(m1029constructorimpl), i9, i4, measureScope, arrayList6, placeableArr, i60, i55, iArr, i57);
                    if (!flowLineMeasurePolicy.isHorizontal()) {
                        i10 = measure.get$width();
                        i11 = measure.get$height();
                    } else {
                        i10 = measure.get$height();
                        i11 = measure.get$width();
                    }
                    iArr5[i57] = i11;
                    i54 += i11;
                    i51 = Math.max(i58, i10);
                    mutableVector.add(measure);
                    i52 = i57 + 1;
                    mutableIntList10 = mutableIntList13;
                    i53 = i55;
                    i50 = i59;
                    iArr3 = iArr4;
                    mutableIntSet3 = mutableIntSet4;
                    arrayList2 = arrayList7;
                    iArr2 = iArr5;
                    iArr = iArr6;
                } else {
                    i56 = Constraints.getMaxHeight-impl(m1029constructorimpl) - i54;
                }
            }
            i9 = i56;
            int i572 = i52;
            int i582 = i51;
            int i592 = i50;
            int[] iArr42 = iArr3;
            ArrayList arrayList62 = arrayList2;
            MutableIntSet mutableIntSet42 = mutableIntSet3;
            ArrayList arrayList72 = arrayList2;
            int i602 = i53;
            int[] iArr52 = iArr2;
            MutableIntList mutableIntList132 = mutableIntList10;
            int[] iArr62 = iArr;
            MeasureResult measure2 = RowColumnMeasurePolicyKt.measure(flowLineMeasurePolicy, i51, Constraints.getMinHeight-impl(m1029constructorimpl), Constraints.getMaxWidth-impl(m1029constructorimpl), i9, i4, measureScope, arrayList62, placeableArr, i602, i55, iArr, i572);
            if (!flowLineMeasurePolicy.isHorizontal()) {
            }
            iArr52[i572] = i11;
            i54 += i11;
            i51 = Math.max(i582, i10);
            mutableVector.add(measure2);
            i52 = i572 + 1;
            mutableIntList10 = mutableIntList132;
            i53 = i55;
            i50 = i592;
            iArr3 = iArr42;
            mutableIntSet3 = mutableIntSet42;
            arrayList2 = arrayList72;
            iArr2 = iArr52;
            iArr = iArr62;
        }
        int i61 = i51;
        int[] iArr7 = iArr2;
        int[] iArr8 = iArr;
        if (mutableVector.getSize() == 0 ? z : false) {
            i7 = 0;
            i8 = 0;
        } else {
            i7 = i61;
            i8 = i54;
        }
        return m972placeHelperBmaY500(measureScope, j, i7, i8, iArr7, mutableVector, flowLineMeasurePolicy, iArr8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit placeHelper_BmaY500$lambda$30(MutableVector mutableVector, Placeable.PlacementScope placementScope) {
        Object[] objArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            ((MeasureResult) objArr[i]).placeChildren();
        }
        return Unit.INSTANCE;
    }
}
