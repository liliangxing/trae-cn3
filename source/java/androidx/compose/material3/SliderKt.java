package androidx.compose.material3;

import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.Strings;
import androidx.compose.material3.tokens.SliderTokens;
import androidx.compose.p002ui.Alignment;
import androidx.compose.p002ui.C0754R;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p002ui.input.pointer.C0769xe3d9cdbd;
import androidx.compose.p002ui.input.pointer.PointerInputChange;
import androidx.compose.p002ui.input.pointer.SuspendPointerInputElement;
import androidx.compose.p002ui.layout.LayoutIdKt;
import androidx.compose.p002ui.layout.LayoutKt;
import androidx.compose.p002ui.layout.Measurable;
import androidx.compose.p002ui.layout.MeasurePolicy;
import androidx.compose.p002ui.layout.MeasureResult;
import androidx.compose.p002ui.layout.MeasureScope;
import androidx.compose.p002ui.layout.Placeable;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.IntIterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* compiled from: Slider.kt */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0098\u0001\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u001f2\u0019\b\u0002\u0010!\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00160\"¢\u0006\u0002\b#2\u0019\b\u0002\u0010$\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00160\"¢\u0006\u0002\b#2\u0019\b\u0002\u0010%\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00160\"¢\u0006\u0002\b#H\u0007¢\u0006\u0002\u0010&\u001aä\u0001\u0010\u0015\u001a\u00020\u00162\f\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(2\u0018\u0010*\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0(\u0012\u0004\u0012\u00020\u00160\"2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\u000e\b\u0002\u0010+\u001a\b\u0012\u0004\u0012\u00020)0(2\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010-2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u001f2\u0019\b\u0002\u0010!\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00160\"¢\u0006\u0002\b#2\u0019\b\u0002\u0010$\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00160\"¢\u0006\u0002\b#2\u0019\b\u0002\u0010%\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00160\"¢\u0006\u0002\b#2\b\b\u0003\u0010.\u001a\u00020/H\u0007¢\u0006\u0002\u00100\u001a\u007f\u0010\u0015\u001a\u00020\u00162\f\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(2\u0018\u0010*\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0(\u0012\u0004\u0012\u00020\u00160\"2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\u000e\b\u0002\u0010+\u001a\b\u0012\u0004\u0012\u00020)0(2\b\b\u0003\u0010.\u001a\u00020/2\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010-2\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0007¢\u0006\u0002\u00101\u001a\u0080\u0001\u00102\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0017\u0010!\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00160\"¢\u0006\u0002\b#2\u0017\u0010$\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00160\"¢\u0006\u0002\b#2\u0017\u0010%\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00160\"¢\u0006\u0002\b#H\u0003¢\u0006\u0002\u00103\u001as\u00104\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u0002052\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u00106\u001a\u00020\u001f2\u0019\b\u0002\u00107\u001a\u0013\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020\u00160\"¢\u0006\u0002\b#2\u0019\b\u0002\u0010%\u001a\u0013\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020\u00160\"¢\u0006\u0002\b#H\u0007¢\u0006\u0002\u00108\u001a³\u0001\u00104\u001a\u00020\u00162\u0006\u0010'\u001a\u00020)2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00160\"2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010-2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u00106\u001a\u00020\u001f2\b\b\u0003\u0010.\u001a\u00020/2\u0019\b\u0002\u00107\u001a\u0013\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020\u00160\"¢\u0006\u0002\b#2\u0019\b\u0002\u0010%\u001a\u0013\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020\u00160\"¢\u0006\u0002\b#2\u000e\b\u0002\u0010+\u001a\b\u0012\u0004\u0012\u00020)0(H\u0007¢\u0006\u0002\u00109\u001a}\u00104\u001a\u00020\u00162\u0006\u0010'\u001a\u00020)2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00160\"2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u000f2\u000e\b\u0002\u0010+\u001a\b\u0012\u0004\u0012\u00020)0(2\b\b\u0003\u0010.\u001a\u00020/2\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010-2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u00106\u001a\u00020\u001fH\u0007¢\u0006\u0002\u0010:\u001a_\u0010;\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u0002052\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u00106\u001a\u00020\u001f2\u0017\u00107\u001a\u0013\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020\u00160\"¢\u0006\u0002\b#2\u0017\u0010%\u001a\u0013\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020\u00160\"¢\u0006\u0002\b#H\u0003¢\u0006\u0002\u0010<\u001a\u001d\u0010=\u001a\u00020\u00102\u0006\u0010>\u001a\u00020)2\u0006\u0010?\u001a\u00020)H\u0001¢\u0006\u0002\u0010@\u001a\u001b\u0010=\u001a\u00020\u00102\f\u0010A\u001a\b\u0012\u0004\u0012\u00020)0(H\u0001¢\u0006\u0002\u0010B\u001a \u0010C\u001a\u00020)2\u0006\u0010D\u001a\u00020)2\u0006\u0010E\u001a\u00020)2\u0006\u0010F\u001a\u00020)H\u0002\u001a:\u0010G\u001a\u00020\u00102\u0006\u0010H\u001a\u00020)2\u0006\u0010I\u001a\u00020)2\u0006\u0010J\u001a\u00020\u00102\u0006\u0010K\u001a\u00020)2\u0006\u0010L\u001a\u00020)H\u0002ø\u0001\u0000¢\u0006\u0004\bM\u0010N\u001a0\u0010G\u001a\u00020)2\u0006\u0010H\u001a\u00020)2\u0006\u0010I\u001a\u00020)2\u0006\u0010O\u001a\u00020)2\u0006\u0010K\u001a\u00020)2\u0006\u0010L\u001a\u00020)H\u0002\u001a(\u0010P\u001a\u00020)2\u0006\u0010Q\u001a\u00020)2\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020)2\u0006\u0010U\u001a\u00020)H\u0002\u001a\u0010\u0010V\u001a\u00020S2\u0006\u0010.\u001a\u00020/H\u0002\u001a5\u0010W\u001a\u0010\u0012\u0004\u0012\u00020Y\u0012\u0004\u0012\u00020)\u0018\u00010X*\u00020Z2\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020^H\u0082@ø\u0001\u0000¢\u0006\u0004\b_\u0010`\u001a\u001c\u0010a\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u000fH\u0002\u001a,\u0010b\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0003\u001a\u001c\u0010c\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u000fH\u0002\u001a\u001c\u0010d\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010\u0017\u001a\u0002052\u0006\u0010\u001b\u001a\u00020\u000fH\u0002\u001a$\u0010e\u001a\u00020\u001a*\u00020\u001a2\u0006\u0010\u0017\u001a\u0002052\u0006\u00106\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0003\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007\"\u0016\u0010\b\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\t\u0010\n\"\u0010\u0010\u000b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0016\u0010\f\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\r\u0010\n\"\u001e\u0010\u000e\u001a\u00020\u000f*\u00020\u00108@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006f"}, d2 = {"ThumbDefaultElevation", "Landroidx/compose/ui/unit/Dp;", "F", "ThumbHeight", "ThumbPressedElevation", "ThumbSize", "Landroidx/compose/ui/unit/DpSize;", "J", "ThumbWidth", "getThumbWidth", "()F", "TickSize", "TrackHeight", "getTrackHeight", "isSpecified", "", "Landroidx/compose/material3/SliderRange;", "isSpecified-If1S1O4$annotations", "(J)V", "isSpecified-If1S1O4", "(J)Z", "RangeSlider", "", "state", "Landroidx/compose/material3/RangeSliderState;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "colors", "Landroidx/compose/material3/SliderColors;", "startInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "endInteractionSource", "startThumb", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "endThumb", "track", "(Landroidx/compose/material3/RangeSliderState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "value", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "onValueChange", "valueRange", "onValueChangeFinished", "Lkotlin/Function0;", "steps", "", "(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;ILandroidx/compose/runtime/Composer;III)V", "(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/runtime/Composer;II)V", "RangeSliderImpl", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/RangeSliderState;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "Slider", "Landroidx/compose/material3/SliderState;", "interactionSource", "thumb", "(Landroidx/compose/material3/SliderState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(FLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;ILkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/ranges/ClosedFloatingPointRange;Landroidx/compose/runtime/Composer;III)V", "(FLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "SliderImpl", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderState;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "SliderRange", "start", "endInclusive", "(FF)J", "range", "(Lkotlin/ranges/ClosedFloatingPointRange;)J", "calcFraction", "a", "b", "pos", "scale", "a1", "b1", "x", "a2", "b2", "scale-ziovWd0", "(FFJFF)J", "x1", "snapValueToTick", "current", "tickFractions", "", "minPx", "maxPx", "stepsToTickFractions", "awaitSlop", "Lkotlin/Pair;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "id", "Landroidx/compose/ui/input/pointer/PointerId;", "type", "Landroidx/compose/ui/input/pointer/PointerType;", "awaitSlop-8vUncbI", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rangeSliderEndThumbSemantics", "rangeSliderPressDragModifier", "rangeSliderStartThumbSemantics", "sliderSemantics", "sliderTapModifier", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class SliderKt {
    private static final float ThumbDefaultElevation;
    private static final float ThumbHeight;
    private static final float ThumbPressedElevation;
    private static final long ThumbSize;
    private static final float ThumbWidth;
    private static final float TickSize;
    private static final float TrackHeight;

    public static final /* synthetic */ float access$calcFraction(float f, float f2, float f3) {
        return calcFraction(f, f2, f3);
    }

    public static final /* synthetic */ float access$scale(float f, float f2, float f3, float f4, float f5) {
        return scale(f, f2, f3, f4, f5);
    }

    /* renamed from: access$scale-ziovWd0 */
    public static final /* synthetic */ long m2929access$scaleziovWd0(float f, float f2, long j, float f3, float f4) {
        return m2933scaleziovWd0(f, f2, j, f3, f4);
    }

    public static final /* synthetic */ float access$snapValueToTick(float f, float[] fArr, float f2, float f3) {
        return snapValueToTick(f, fArr, f2, f3);
    }

    public static final /* synthetic */ float[] access$stepsToTickFractions(int i) {
        return stepsToTickFractions(i);
    }

    /* renamed from: isSpecified-If1S1O4$annotations */
    public static /* synthetic */ void m2932isSpecifiedIf1S1O4$annotations(long j) {
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0101  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Slider(final float f, final Function1<? super Float, Unit> function1, Modifier modifier, boolean z, ClosedFloatingPointRange<Float> closedFloatingPointRange, int i, Function0<Unit> function0, SliderColors sliderColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i2, final int i3) {
        int i4;
        int i5;
        Modifier modifier2;
        int i6;
        final boolean z2;
        ClosedFloatingPointRange<Float> closedFloatingPointRange2;
        int i7;
        int i8;
        int i9;
        Function0<Unit> function02;
        int i10;
        SliderColors sliderColors2;
        final MutableInteractionSource mutableInteractionSource2;
        int i11;
        int i12;
        final SliderColors sliderColors3;
        Function0<Unit> function03;
        final Function0<Unit> function04;
        final boolean z3;
        final SliderColors sliderColors4;
        final Modifier modifier3;
        final int i13;
        final MutableInteractionSource mutableInteractionSource3;
        final ClosedFloatingPointRange<Float> closedFloatingPointRange3;
        ScopeUpdateScope endRestartGroup;
        int i14;
        int i15;
        Composer startRestartGroup = composer.startRestartGroup(-202044027);
        ComposerKt.sourceInformation(startRestartGroup, "C(Slider)P(7,4,3,1,8,6,5)155@7378L8,156@7438L39,158@7486L714:Slider.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (startRestartGroup.changed(f) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            i4 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
            i5 = i3 & 4;
            if (i5 == 0) {
                i4 |= 384;
            } else if ((i2 & 384) == 0) {
                modifier2 = modifier;
                i4 |= startRestartGroup.changed(modifier2) ? Fields.RotationX : Fields.SpotShadowColor;
                i6 = i3 & 8;
                if (i6 != 0) {
                    i4 |= 3072;
                } else if ((i2 & 3072) == 0) {
                    z2 = z;
                    i4 |= startRestartGroup.changed(z2) ? Fields.CameraDistance : Fields.RotationZ;
                    if ((i2 & 24576) != 0) {
                        if ((i3 & 16) == 0) {
                            closedFloatingPointRange2 = closedFloatingPointRange;
                            if (startRestartGroup.changed(closedFloatingPointRange2)) {
                                i15 = Fields.Clip;
                                i4 |= i15;
                            }
                        } else {
                            closedFloatingPointRange2 = closedFloatingPointRange;
                        }
                        i15 = Fields.Shape;
                        i4 |= i15;
                    } else {
                        closedFloatingPointRange2 = closedFloatingPointRange;
                    }
                    i7 = i3 & 32;
                    if (i7 == 0) {
                        i4 |= 196608;
                    } else if ((196608 & i2) == 0) {
                        i8 = i;
                        i4 |= startRestartGroup.changed(i8) ? Fields.RenderEffect : 65536;
                        i9 = i3 & 64;
                        if (i9 != 0) {
                            i4 |= 1572864;
                        } else if ((1572864 & i2) == 0) {
                            function02 = function0;
                            i4 |= startRestartGroup.changedInstance(function02) ? 1048576 : Fields.BlendMode;
                            if ((i2 & 12582912) == 0) {
                                if ((i3 & Fields.SpotShadowColor) == 0 && startRestartGroup.changed(sliderColors)) {
                                    i14 = 8388608;
                                    i4 |= i14;
                                }
                                i14 = 4194304;
                                i4 |= i14;
                            }
                            i10 = i3 & Fields.RotationX;
                            if (i10 == 0) {
                                i4 |= 100663296;
                            } else if ((i2 & 100663296) == 0) {
                                i4 |= startRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                            }
                            if ((i4 & 38347923) == 38347922 || !startRestartGroup.getSkipping()) {
                                startRestartGroup.startDefaults();
                                if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    if (i5 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i6 != 0) {
                                        z2 = true;
                                    }
                                    if ((i3 & 16) != 0) {
                                        i4 &= -57345;
                                        closedFloatingPointRange2 = RangesKt.rangeTo(0.0f, 1.0f);
                                    }
                                    if (i7 != 0) {
                                        i8 = 0;
                                    }
                                    if (i9 != 0) {
                                        function02 = null;
                                    }
                                    if ((i3 & Fields.SpotShadowColor) == 0) {
                                        sliderColors2 = SliderDefaults.INSTANCE.colors(startRestartGroup, 6);
                                        i4 &= -29360129;
                                    } else {
                                        sliderColors2 = sliderColors;
                                    }
                                    if (i10 == 0) {
                                        startRestartGroup.startReplaceableGroup(-1537043190);
                                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                                        Object rememberedValue = startRestartGroup.rememberedValue();
                                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                            startRestartGroup.updateRememberedValue(rememberedValue);
                                        }
                                        startRestartGroup.endReplaceableGroup();
                                        mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                                    } else {
                                        mutableInteractionSource2 = mutableInteractionSource;
                                    }
                                    i11 = i4;
                                    i12 = i8;
                                    sliderColors3 = sliderColors2;
                                    function03 = function02;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i3 & 16) != 0) {
                                        i4 &= -57345;
                                    }
                                    if ((i3 & Fields.SpotShadowColor) != 0) {
                                        i4 &= -29360129;
                                    }
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    i11 = i4;
                                    i12 = i8;
                                    function03 = function02;
                                    sliderColors3 = sliderColors;
                                }
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-202044027, i11, -1, "androidx.compose.material3.Slider (Slider.kt:157)");
                                }
                                int i16 = i11 >> 6;
                                Slider(f, function1, modifier2, z2, function03, sliderColors3, mutableInteractionSource2, i12, ComposableLambdaKt.composableLambda(startRestartGroup, 308249025, true, new Function3<SliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$2
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                        invoke((SliderState) obj, (Composer) obj2, ((Number) obj3).intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(SliderState sliderState, Composer composer2, int i17) {
                                        ComposerKt.sourceInformation(composer2, "C168@7807L142:Slider.kt#uh7d8r");
                                        if ((i17 & 17) != 16 || !composer2.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(308249025, i17, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:168)");
                                            }
                                            SliderDefaults.INSTANCE.m2926Thumb9LiSoMs(MutableInteractionSource.this, null, sliderColors3, z2, 0L, composer2, 196608, 18);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer2.skipToGroupEnd();
                                    }
                                }), ComposableLambdaKt.composableLambda(startRestartGroup, -1843234110, true, new Function3<SliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$3
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                        invoke((SliderState) obj, (Composer) obj2, ((Number) obj3).intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(SliderState sliderState, Composer composer2, int i17) {
                                        ComposerKt.sourceInformation(composer2, "C175@8021L130:Slider.kt#uh7d8r");
                                        if ((i17 & 6) == 0) {
                                            i17 |= composer2.changed(sliderState) ? 4 : 2;
                                        }
                                        if ((i17 & 19) != 18 || !composer2.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1843234110, i17, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:175)");
                                            }
                                            SliderDefaults.INSTANCE.Track(sliderState, (Modifier) null, SliderColors.this, z2, composer2, (i17 & 14) | 24576, 2);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer2.skipToGroupEnd();
                                    }
                                }), closedFloatingPointRange2, startRestartGroup, (i11 & 14) | 905969664 | (i11 & 112) | (i11 & 896) | (i11 & 7168) | (57344 & i16) | (458752 & i16) | (i16 & 3670016) | ((i11 << 6) & 29360128), (i11 >> 12) & 14, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                function04 = function03;
                                z3 = z2;
                                sliderColors4 = sliderColors3;
                                modifier3 = modifier2;
                                i13 = i12;
                                ClosedFloatingPointRange<Float> closedFloatingPointRange4 = closedFloatingPointRange2;
                                mutableInteractionSource3 = mutableInteractionSource2;
                                closedFloatingPointRange3 = closedFloatingPointRange4;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                modifier3 = modifier2;
                                z3 = z2;
                                closedFloatingPointRange3 = closedFloatingPointRange2;
                                i13 = i8;
                                function04 = function02;
                                sliderColors4 = sliderColors;
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$4
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                        invoke((Composer) obj, ((Number) obj2).intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer2, int i17) {
                                        SliderKt.Slider(f, function1, modifier3, z3, closedFloatingPointRange3, i13, function04, sliderColors4, mutableInteractionSource3, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        function02 = function0;
                        if ((i2 & 12582912) == 0) {
                        }
                        i10 = i3 & Fields.RotationX;
                        if (i10 == 0) {
                        }
                        if ((i4 & 38347923) == 38347922) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                        }
                        if (i5 != 0) {
                        }
                        if (i6 != 0) {
                        }
                        if ((i3 & 16) != 0) {
                        }
                        if (i7 != 0) {
                        }
                        if (i9 != 0) {
                        }
                        if ((i3 & Fields.SpotShadowColor) == 0) {
                        }
                        if (i10 == 0) {
                        }
                        i11 = i4;
                        i12 = i8;
                        sliderColors3 = sliderColors2;
                        function03 = function02;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i162 = i11 >> 6;
                        Slider(f, function1, modifier2, z2, function03, sliderColors3, mutableInteractionSource2, i12, ComposableLambdaKt.composableLambda(startRestartGroup, 308249025, true, new Function3<SliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$2
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                invoke((SliderState) obj, (Composer) obj2, ((Number) obj3).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(SliderState sliderState, Composer composer2, int i17) {
                                ComposerKt.sourceInformation(composer2, "C168@7807L142:Slider.kt#uh7d8r");
                                if ((i17 & 17) != 16 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(308249025, i17, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:168)");
                                    }
                                    SliderDefaults.INSTANCE.m2926Thumb9LiSoMs(MutableInteractionSource.this, null, sliderColors3, z2, 0L, composer2, 196608, 18);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }), ComposableLambdaKt.composableLambda(startRestartGroup, -1843234110, true, new Function3<SliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$3
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                invoke((SliderState) obj, (Composer) obj2, ((Number) obj3).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(SliderState sliderState, Composer composer2, int i17) {
                                ComposerKt.sourceInformation(composer2, "C175@8021L130:Slider.kt#uh7d8r");
                                if ((i17 & 6) == 0) {
                                    i17 |= composer2.changed(sliderState) ? 4 : 2;
                                }
                                if ((i17 & 19) != 18 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1843234110, i17, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:175)");
                                    }
                                    SliderDefaults.INSTANCE.Track(sliderState, (Modifier) null, SliderColors.this, z2, composer2, (i17 & 14) | 24576, 2);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }), closedFloatingPointRange2, startRestartGroup, (i11 & 14) | 905969664 | (i11 & 112) | (i11 & 896) | (i11 & 7168) | (57344 & i162) | (458752 & i162) | (i162 & 3670016) | ((i11 << 6) & 29360128), (i11 >> 12) & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        function04 = function03;
                        z3 = z2;
                        sliderColors4 = sliderColors3;
                        modifier3 = modifier2;
                        i13 = i12;
                        ClosedFloatingPointRange<Float> closedFloatingPointRange42 = closedFloatingPointRange2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        closedFloatingPointRange3 = closedFloatingPointRange42;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i8 = i;
                    i9 = i3 & 64;
                    if (i9 != 0) {
                    }
                    function02 = function0;
                    if ((i2 & 12582912) == 0) {
                    }
                    i10 = i3 & Fields.RotationX;
                    if (i10 == 0) {
                    }
                    if ((i4 & 38347923) == 38347922) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if ((i3 & 16) != 0) {
                    }
                    if (i7 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if ((i3 & Fields.SpotShadowColor) == 0) {
                    }
                    if (i10 == 0) {
                    }
                    i11 = i4;
                    i12 = i8;
                    sliderColors3 = sliderColors2;
                    function03 = function02;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i1622 = i11 >> 6;
                    Slider(f, function1, modifier2, z2, function03, sliderColors3, mutableInteractionSource2, i12, ComposableLambdaKt.composableLambda(startRestartGroup, 308249025, true, new Function3<SliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                            invoke((SliderState) obj, (Composer) obj2, ((Number) obj3).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(SliderState sliderState, Composer composer2, int i17) {
                            ComposerKt.sourceInformation(composer2, "C168@7807L142:Slider.kt#uh7d8r");
                            if ((i17 & 17) != 16 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(308249025, i17, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:168)");
                                }
                                SliderDefaults.INSTANCE.m2926Thumb9LiSoMs(MutableInteractionSource.this, null, sliderColors3, z2, 0L, composer2, 196608, 18);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), ComposableLambdaKt.composableLambda(startRestartGroup, -1843234110, true, new Function3<SliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$3
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                            invoke((SliderState) obj, (Composer) obj2, ((Number) obj3).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(SliderState sliderState, Composer composer2, int i17) {
                            ComposerKt.sourceInformation(composer2, "C175@8021L130:Slider.kt#uh7d8r");
                            if ((i17 & 6) == 0) {
                                i17 |= composer2.changed(sliderState) ? 4 : 2;
                            }
                            if ((i17 & 19) != 18 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1843234110, i17, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:175)");
                                }
                                SliderDefaults.INSTANCE.Track(sliderState, (Modifier) null, SliderColors.this, z2, composer2, (i17 & 14) | 24576, 2);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), closedFloatingPointRange2, startRestartGroup, (i11 & 14) | 905969664 | (i11 & 112) | (i11 & 896) | (i11 & 7168) | (57344 & i1622) | (458752 & i1622) | (i1622 & 3670016) | ((i11 << 6) & 29360128), (i11 >> 12) & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    function04 = function03;
                    z3 = z2;
                    sliderColors4 = sliderColors3;
                    modifier3 = modifier2;
                    i13 = i12;
                    ClosedFloatingPointRange<Float> closedFloatingPointRange422 = closedFloatingPointRange2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    closedFloatingPointRange3 = closedFloatingPointRange422;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                z2 = z;
                if ((i2 & 24576) != 0) {
                }
                i7 = i3 & 32;
                if (i7 == 0) {
                }
                i8 = i;
                i9 = i3 & 64;
                if (i9 != 0) {
                }
                function02 = function0;
                if ((i2 & 12582912) == 0) {
                }
                i10 = i3 & Fields.RotationX;
                if (i10 == 0) {
                }
                if ((i4 & 38347923) == 38347922) {
                }
                startRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if ((i3 & 16) != 0) {
                }
                if (i7 != 0) {
                }
                if (i9 != 0) {
                }
                if ((i3 & Fields.SpotShadowColor) == 0) {
                }
                if (i10 == 0) {
                }
                i11 = i4;
                i12 = i8;
                sliderColors3 = sliderColors2;
                function03 = function02;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i16222 = i11 >> 6;
                Slider(f, function1, modifier2, z2, function03, sliderColors3, mutableInteractionSource2, i12, ComposableLambdaKt.composableLambda(startRestartGroup, 308249025, true, new Function3<SliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        invoke((SliderState) obj, (Composer) obj2, ((Number) obj3).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(SliderState sliderState, Composer composer2, int i17) {
                        ComposerKt.sourceInformation(composer2, "C168@7807L142:Slider.kt#uh7d8r");
                        if ((i17 & 17) != 16 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(308249025, i17, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:168)");
                            }
                            SliderDefaults.INSTANCE.m2926Thumb9LiSoMs(MutableInteractionSource.this, null, sliderColors3, z2, 0L, composer2, 196608, 18);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), ComposableLambdaKt.composableLambda(startRestartGroup, -1843234110, true, new Function3<SliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$3
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        invoke((SliderState) obj, (Composer) obj2, ((Number) obj3).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(SliderState sliderState, Composer composer2, int i17) {
                        ComposerKt.sourceInformation(composer2, "C175@8021L130:Slider.kt#uh7d8r");
                        if ((i17 & 6) == 0) {
                            i17 |= composer2.changed(sliderState) ? 4 : 2;
                        }
                        if ((i17 & 19) != 18 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1843234110, i17, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:175)");
                            }
                            SliderDefaults.INSTANCE.Track(sliderState, (Modifier) null, SliderColors.this, z2, composer2, (i17 & 14) | 24576, 2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), closedFloatingPointRange2, startRestartGroup, (i11 & 14) | 905969664 | (i11 & 112) | (i11 & 896) | (i11 & 7168) | (57344 & i16222) | (458752 & i16222) | (i16222 & 3670016) | ((i11 << 6) & 29360128), (i11 >> 12) & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                function04 = function03;
                z3 = z2;
                sliderColors4 = sliderColors3;
                modifier3 = modifier2;
                i13 = i12;
                ClosedFloatingPointRange<Float> closedFloatingPointRange4222 = closedFloatingPointRange2;
                mutableInteractionSource3 = mutableInteractionSource2;
                closedFloatingPointRange3 = closedFloatingPointRange4222;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            modifier2 = modifier;
            i6 = i3 & 8;
            if (i6 != 0) {
            }
            z2 = z;
            if ((i2 & 24576) != 0) {
            }
            i7 = i3 & 32;
            if (i7 == 0) {
            }
            i8 = i;
            i9 = i3 & 64;
            if (i9 != 0) {
            }
            function02 = function0;
            if ((i2 & 12582912) == 0) {
            }
            i10 = i3 & Fields.RotationX;
            if (i10 == 0) {
            }
            if ((i4 & 38347923) == 38347922) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if ((i3 & 16) != 0) {
            }
            if (i7 != 0) {
            }
            if (i9 != 0) {
            }
            if ((i3 & Fields.SpotShadowColor) == 0) {
            }
            if (i10 == 0) {
            }
            i11 = i4;
            i12 = i8;
            sliderColors3 = sliderColors2;
            function03 = function02;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i162222 = i11 >> 6;
            Slider(f, function1, modifier2, z2, function03, sliderColors3, mutableInteractionSource2, i12, ComposableLambdaKt.composableLambda(startRestartGroup, 308249025, true, new Function3<SliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((SliderState) obj, (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(SliderState sliderState, Composer composer2, int i17) {
                    ComposerKt.sourceInformation(composer2, "C168@7807L142:Slider.kt#uh7d8r");
                    if ((i17 & 17) != 16 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(308249025, i17, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:168)");
                        }
                        SliderDefaults.INSTANCE.m2926Thumb9LiSoMs(MutableInteractionSource.this, null, sliderColors3, z2, 0L, composer2, 196608, 18);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), ComposableLambdaKt.composableLambda(startRestartGroup, -1843234110, true, new Function3<SliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((SliderState) obj, (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(SliderState sliderState, Composer composer2, int i17) {
                    ComposerKt.sourceInformation(composer2, "C175@8021L130:Slider.kt#uh7d8r");
                    if ((i17 & 6) == 0) {
                        i17 |= composer2.changed(sliderState) ? 4 : 2;
                    }
                    if ((i17 & 19) != 18 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1843234110, i17, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:175)");
                        }
                        SliderDefaults.INSTANCE.Track(sliderState, (Modifier) null, SliderColors.this, z2, composer2, (i17 & 14) | 24576, 2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), closedFloatingPointRange2, startRestartGroup, (i11 & 14) | 905969664 | (i11 & 112) | (i11 & 896) | (i11 & 7168) | (57344 & i162222) | (458752 & i162222) | (i162222 & 3670016) | ((i11 << 6) & 29360128), (i11 >> 12) & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            function04 = function03;
            z3 = z2;
            sliderColors4 = sliderColors3;
            modifier3 = modifier2;
            i13 = i12;
            ClosedFloatingPointRange<Float> closedFloatingPointRange42222 = closedFloatingPointRange2;
            mutableInteractionSource3 = mutableInteractionSource2;
            closedFloatingPointRange3 = closedFloatingPointRange42222;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i5 = i3 & 4;
        if (i5 == 0) {
        }
        modifier2 = modifier;
        i6 = i3 & 8;
        if (i6 != 0) {
        }
        z2 = z;
        if ((i2 & 24576) != 0) {
        }
        i7 = i3 & 32;
        if (i7 == 0) {
        }
        i8 = i;
        i9 = i3 & 64;
        if (i9 != 0) {
        }
        function02 = function0;
        if ((i2 & 12582912) == 0) {
        }
        i10 = i3 & Fields.RotationX;
        if (i10 == 0) {
        }
        if ((i4 & 38347923) == 38347922) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if ((i3 & 16) != 0) {
        }
        if (i7 != 0) {
        }
        if (i9 != 0) {
        }
        if ((i3 & Fields.SpotShadowColor) == 0) {
        }
        if (i10 == 0) {
        }
        i11 = i4;
        i12 = i8;
        sliderColors3 = sliderColors2;
        function03 = function02;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i1622222 = i11 >> 6;
        Slider(f, function1, modifier2, z2, function03, sliderColors3, mutableInteractionSource2, i12, ComposableLambdaKt.composableLambda(startRestartGroup, 308249025, true, new Function3<SliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((SliderState) obj, (Composer) obj2, ((Number) obj3).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(SliderState sliderState, Composer composer2, int i17) {
                ComposerKt.sourceInformation(composer2, "C168@7807L142:Slider.kt#uh7d8r");
                if ((i17 & 17) != 16 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(308249025, i17, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:168)");
                    }
                    SliderDefaults.INSTANCE.m2926Thumb9LiSoMs(MutableInteractionSource.this, null, sliderColors3, z2, 0L, composer2, 196608, 18);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }), ComposableLambdaKt.composableLambda(startRestartGroup, -1843234110, true, new Function3<SliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((SliderState) obj, (Composer) obj2, ((Number) obj3).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(SliderState sliderState, Composer composer2, int i17) {
                ComposerKt.sourceInformation(composer2, "C175@8021L130:Slider.kt#uh7d8r");
                if ((i17 & 6) == 0) {
                    i17 |= composer2.changed(sliderState) ? 4 : 2;
                }
                if ((i17 & 19) != 18 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1843234110, i17, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:175)");
                    }
                    SliderDefaults.INSTANCE.Track(sliderState, (Modifier) null, SliderColors.this, z2, composer2, (i17 & 14) | 24576, 2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }), closedFloatingPointRange2, startRestartGroup, (i11 & 14) | 905969664 | (i11 & 112) | (i11 & 896) | (i11 & 7168) | (57344 & i1622222) | (458752 & i1622222) | (i1622222 & 3670016) | ((i11 << 6) & 29360128), (i11 >> 12) & 14, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        function04 = function03;
        z3 = z2;
        sliderColors4 = sliderColors3;
        modifier3 = modifier2;
        i13 = i12;
        ClosedFloatingPointRange<Float> closedFloatingPointRange422222 = closedFloatingPointRange2;
        mutableInteractionSource3 = mutableInteractionSource2;
        closedFloatingPointRange3 = closedFloatingPointRange422222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Slider(final float f, final Function1<? super Float, Unit> function1, Modifier modifier, boolean z, Function0<Unit> function0, SliderColors sliderColors, MutableInteractionSource mutableInteractionSource, int i, Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function3, Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function32, ClosedFloatingPointRange<Float> closedFloatingPointRange, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        int i6;
        int i7;
        Function0<Unit> function02;
        SliderColors sliderColors2;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        Modifier.Companion companion;
        final boolean z2;
        Function0<Unit> function03;
        final SliderColors sliderColors3;
        final MutableInteractionSource mutableInteractionSource2;
        int i13;
        ComposableLambda composableLambda;
        ComposableLambda composableLambda2;
        ClosedFloatingPointRange<Float> closedFloatingPointRange2;
        int i14;
        SliderColors sliderColors4;
        boolean z3;
        Object rememberedValue;
        final Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function33;
        final boolean z4;
        final ClosedFloatingPointRange<Float> closedFloatingPointRange3;
        final Function0<Unit> function04;
        final int i15;
        final Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function34;
        final SliderColors sliderColors5;
        ScopeUpdateScope endRestartGroup;
        int i16;
        int i17;
        Composer startRestartGroup = composer.startRestartGroup(1191170377);
        ComposerKt.sourceInformation(startRestartGroup, "C(Slider)P(9,4,3,1,5)246@11459L8,247@11519L39,266@12117L43,267@12177L210,283@12458L184:Slider.kt#uh7d8r");
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i5 = (startRestartGroup.changed(f) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i2 & 48) == 0) {
            i5 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i18 = i4 & 4;
        if (i18 != 0) {
            i5 |= 384;
        } else if ((i2 & 384) == 0) {
            i5 |= startRestartGroup.changed(modifier) ? Fields.RotationX : Fields.SpotShadowColor;
            i6 = i4 & 8;
            if (i6 == 0) {
                i5 |= 3072;
            } else if ((i2 & 3072) == 0) {
                i5 |= startRestartGroup.changed(z) ? Fields.CameraDistance : Fields.RotationZ;
                i7 = i4 & 16;
                if (i7 != 0) {
                    i5 |= 24576;
                } else if ((i2 & 24576) == 0) {
                    function02 = function0;
                    i5 |= startRestartGroup.changedInstance(function02) ? Fields.Clip : Fields.Shape;
                    if ((196608 & i2) != 0) {
                        if ((i4 & 32) == 0) {
                            sliderColors2 = sliderColors;
                            if (startRestartGroup.changed(sliderColors2)) {
                                i17 = Fields.RenderEffect;
                                i5 |= i17;
                            }
                        } else {
                            sliderColors2 = sliderColors;
                        }
                        i17 = 65536;
                        i5 |= i17;
                    } else {
                        sliderColors2 = sliderColors;
                    }
                    i8 = i4 & 64;
                    if (i8 == 0) {
                        i5 |= 1572864;
                    } else if ((i2 & 1572864) == 0) {
                        i5 |= startRestartGroup.changed(mutableInteractionSource) ? 1048576 : Fields.BlendMode;
                    }
                    i9 = i4 & Fields.SpotShadowColor;
                    if (i9 == 0) {
                        i5 |= 12582912;
                    } else if ((i2 & 12582912) == 0) {
                        i5 |= startRestartGroup.changed(i) ? 8388608 : 4194304;
                    }
                    i10 = i4 & Fields.RotationX;
                    if (i10 == 0) {
                        i5 |= 100663296;
                    } else if ((i2 & 100663296) == 0) {
                        i5 |= startRestartGroup.changedInstance(function3) ? 67108864 : 33554432;
                    }
                    i11 = i4 & Fields.RotationY;
                    if (i11 == 0) {
                        i5 |= 805306368;
                    } else if ((i2 & 805306368) == 0) {
                        i5 |= startRestartGroup.changedInstance(function32) ? 536870912 : 268435456;
                    }
                    if ((i3 & 6) != 0) {
                        if ((i4 & Fields.RotationZ) == 0 && startRestartGroup.changed(closedFloatingPointRange)) {
                            i16 = 4;
                            i12 = i3 | i16;
                        }
                        i16 = 2;
                        i12 = i3 | i16;
                    } else {
                        i12 = i3;
                    }
                    if ((i5 & 306783379) == 306783378 || (i12 & 3) != 2 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            companion = i18 == 0 ? Modifier.INSTANCE : modifier;
                            z2 = i6 == 0 ? true : z;
                            function03 = i7 == 0 ? null : function02;
                            if ((i4 & 32) == 0) {
                                sliderColors3 = SliderDefaults.INSTANCE.colors(startRestartGroup, 6);
                                i5 &= -458753;
                            } else {
                                sliderColors3 = sliderColors2;
                            }
                            if (i8 == 0) {
                                startRestartGroup.startReplaceableGroup(-1537039109);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                                Object rememberedValue2 = startRestartGroup.rememberedValue();
                                if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                                    startRestartGroup.updateRememberedValue(rememberedValue2);
                                }
                                mutableInteractionSource2 = (MutableInteractionSource) rememberedValue2;
                                startRestartGroup.endReplaceableGroup();
                            } else {
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                            i13 = i9 == 0 ? 0 : i;
                            composableLambda = i10 == 0 ? ComposableLambdaKt.composableLambda(startRestartGroup, -1756326375, true, new Function3<SliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$6
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                    invoke((SliderState) obj, (Composer) obj2, ((Number) obj3).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(SliderState sliderState, Composer composer2, int i19) {
                                    ComposerKt.sourceInformation(composer2, "C251@11676L126:Slider.kt#uh7d8r");
                                    if ((i19 & 17) != 16 || !composer2.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1756326375, i19, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:251)");
                                        }
                                        SliderDefaults.INSTANCE.m2926Thumb9LiSoMs(MutableInteractionSource.this, null, sliderColors3, z2, 0L, composer2, 196608, 18);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer2.skipToGroupEnd();
                                }
                            }) : function3;
                            composableLambda2 = i11 == 0 ? ComposableLambdaKt.composableLambda(startRestartGroup, 2083675534, true, new Function3<SliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$7
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                    invoke((SliderState) obj, (Composer) obj2, ((Number) obj3).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(SliderState sliderState, Composer composer2, int i19) {
                                    ComposerKt.sourceInformation(composer2, "C258@11897L114:Slider.kt#uh7d8r");
                                    if ((i19 & 6) == 0) {
                                        i19 |= composer2.changed(sliderState) ? 4 : 2;
                                    }
                                    if ((i19 & 19) != 18 || !composer2.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(2083675534, i19, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:258)");
                                        }
                                        SliderDefaults.INSTANCE.Track(sliderState, (Modifier) null, SliderColors.this, z2, composer2, (i19 & 14) | 24576, 2);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer2.skipToGroupEnd();
                                }
                            }) : function32;
                            if ((i4 & Fields.RotationZ) == 0) {
                                closedFloatingPointRange2 = RangesKt.rangeTo(0.0f, 1.0f);
                                i12 &= -15;
                            } else {
                                closedFloatingPointRange2 = closedFloatingPointRange;
                            }
                            i14 = i12;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i4 & 32) != 0) {
                                i5 &= -458753;
                            }
                            if ((i4 & Fields.RotationZ) != 0) {
                                i12 &= -15;
                            }
                            companion = modifier;
                            z2 = z;
                            i13 = i;
                            composableLambda = function3;
                            composableLambda2 = function32;
                            closedFloatingPointRange2 = closedFloatingPointRange;
                            function03 = function02;
                            sliderColors3 = sliderColors2;
                            i14 = i12;
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            sliderColors4 = sliderColors3;
                        } else {
                            sliderColors4 = sliderColors3;
                            ComposerKt.traceEventStart(1191170377, i5, i14, "androidx.compose.material3.Slider (Slider.kt:265)");
                        }
                        final State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function03, startRestartGroup, (i5 >> 12) & 14);
                        startRestartGroup.startReplaceableGroup(-1537038451);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                        Function0<Unit> function05 = function03;
                        z3 = ((29360128 & i5) != 8388608) | ((((i14 & 14) ^ 6) > 4 && startRestartGroup.changed(closedFloatingPointRange2)) || (i14 & 6) == 4);
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (!z3 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = new SliderState(f, i13, new Function0<Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$state$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                public /* bridge */ /* synthetic */ Object invoke() {
                                    m2936invoke();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: collision with other method in class */
                                public final void m2936invoke() {
                                    Function0<Unit> value = rememberUpdatedState.getValue();
                                    if (value != null) {
                                        value.invoke();
                                    }
                                }
                            }, closedFloatingPointRange2);
                            startRestartGroup.updateRememberedValue(rememberedValue);
                        }
                        SliderState sliderState = (SliderState) rememberedValue;
                        startRestartGroup.endReplaceableGroup();
                        sliderState.setOnValueChange$material3_release(function1);
                        sliderState.setValue(f);
                        int i19 = i5 >> 3;
                        int i20 = (i19 & 896) | (i19 & 112) | ((i5 >> 6) & 57344);
                        int i21 = i5 >> 9;
                        Slider(sliderState, companion, z2, null, mutableInteractionSource2, composableLambda, composableLambda2, startRestartGroup, (i21 & 3670016) | i20 | (458752 & i21), 8);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function33 = composableLambda;
                        z4 = z2;
                        closedFloatingPointRange3 = closedFloatingPointRange2;
                        function04 = function05;
                        i15 = i13;
                        function34 = composableLambda2;
                        sliderColors5 = sliderColors4;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        companion = modifier;
                        z4 = z;
                        i15 = i;
                        function33 = function3;
                        function34 = function32;
                        closedFloatingPointRange3 = closedFloatingPointRange;
                        function04 = function02;
                        sliderColors5 = sliderColors2;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                        final Modifier modifier2 = companion;
                        final MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource2;
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$8
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i22) {
                                SliderKt.Slider(f, function1, modifier2, z4, function04, sliderColors5, mutableInteractionSource3, i15, function33, function34, closedFloatingPointRange3, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
                            }
                        });
                        return;
                    }
                    return;
                }
                function02 = function0;
                if ((196608 & i2) != 0) {
                }
                i8 = i4 & 64;
                if (i8 == 0) {
                }
                i9 = i4 & Fields.SpotShadowColor;
                if (i9 == 0) {
                }
                i10 = i4 & Fields.RotationX;
                if (i10 == 0) {
                }
                i11 = i4 & Fields.RotationY;
                if (i11 == 0) {
                }
                if ((i3 & 6) != 0) {
                }
                if ((i5 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                }
                if (i18 == 0) {
                }
                if (i6 == 0) {
                }
                if (i7 == 0) {
                }
                if ((i4 & 32) == 0) {
                }
                if (i8 == 0) {
                }
                if (i9 == 0) {
                }
                if (i10 == 0) {
                }
                if (i11 == 0) {
                }
                if ((i4 & Fields.RotationZ) == 0) {
                }
                i14 = i12;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                final State<? extends Function0<Unit>> rememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(function03, startRestartGroup, (i5 >> 12) & 14);
                startRestartGroup.startReplaceableGroup(-1537038451);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                Function0<Unit> function052 = function03;
                if (((i14 & 14) ^ 6) > 4) {
                    z3 = ((29360128 & i5) != 8388608) | ((((i14 & 14) ^ 6) > 4 && startRestartGroup.changed(closedFloatingPointRange2)) || (i14 & 6) == 4);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!z3) {
                    }
                    rememberedValue = new SliderState(f, i13, new Function0<Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$state$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m2936invoke();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: collision with other method in class */
                        public final void m2936invoke() {
                            Function0<Unit> value = rememberUpdatedState2.getValue();
                            if (value != null) {
                                value.invoke();
                            }
                        }
                    }, closedFloatingPointRange2);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                    SliderState sliderState2 = (SliderState) rememberedValue;
                    startRestartGroup.endReplaceableGroup();
                    sliderState2.setOnValueChange$material3_release(function1);
                    sliderState2.setValue(f);
                    int i192 = i5 >> 3;
                    int i202 = (i192 & 896) | (i192 & 112) | ((i5 >> 6) & 57344);
                    int i212 = i5 >> 9;
                    Slider(sliderState2, companion, z2, null, mutableInteractionSource2, composableLambda, composableLambda2, startRestartGroup, (i212 & 3670016) | i202 | (458752 & i212), 8);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    function33 = composableLambda;
                    z4 = z2;
                    closedFloatingPointRange3 = closedFloatingPointRange2;
                    function04 = function052;
                    i15 = i13;
                    function34 = composableLambda2;
                    sliderColors5 = sliderColors4;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                z3 = ((29360128 & i5) != 8388608) | ((((i14 & 14) ^ 6) > 4 && startRestartGroup.changed(closedFloatingPointRange2)) || (i14 & 6) == 4);
                rememberedValue = startRestartGroup.rememberedValue();
                if (!z3) {
                }
                rememberedValue = new SliderState(f, i13, new Function0<Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$state$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m2936invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m2936invoke() {
                        Function0<Unit> value = rememberUpdatedState2.getValue();
                        if (value != null) {
                            value.invoke();
                        }
                    }
                }, closedFloatingPointRange2);
                startRestartGroup.updateRememberedValue(rememberedValue);
                SliderState sliderState22 = (SliderState) rememberedValue;
                startRestartGroup.endReplaceableGroup();
                sliderState22.setOnValueChange$material3_release(function1);
                sliderState22.setValue(f);
                int i1922 = i5 >> 3;
                int i2022 = (i1922 & 896) | (i1922 & 112) | ((i5 >> 6) & 57344);
                int i2122 = i5 >> 9;
                Slider(sliderState22, companion, z2, null, mutableInteractionSource2, composableLambda, composableLambda2, startRestartGroup, (i2122 & 3670016) | i2022 | (458752 & i2122), 8);
                if (ComposerKt.isTraceInProgress()) {
                }
                function33 = composableLambda;
                z4 = z2;
                closedFloatingPointRange3 = closedFloatingPointRange2;
                function04 = function052;
                i15 = i13;
                function34 = composableLambda2;
                sliderColors5 = sliderColors4;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i7 = i4 & 16;
            if (i7 != 0) {
            }
            function02 = function0;
            if ((196608 & i2) != 0) {
            }
            i8 = i4 & 64;
            if (i8 == 0) {
            }
            i9 = i4 & Fields.SpotShadowColor;
            if (i9 == 0) {
            }
            i10 = i4 & Fields.RotationX;
            if (i10 == 0) {
            }
            i11 = i4 & Fields.RotationY;
            if (i11 == 0) {
            }
            if ((i3 & 6) != 0) {
            }
            if ((i5 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
            }
            if (i18 == 0) {
            }
            if (i6 == 0) {
            }
            if (i7 == 0) {
            }
            if ((i4 & 32) == 0) {
            }
            if (i8 == 0) {
            }
            if (i9 == 0) {
            }
            if (i10 == 0) {
            }
            if (i11 == 0) {
            }
            if ((i4 & Fields.RotationZ) == 0) {
            }
            i14 = i12;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            final State<? extends Function0<Unit>> rememberUpdatedState22 = SnapshotStateKt.rememberUpdatedState(function03, startRestartGroup, (i5 >> 12) & 14);
            startRestartGroup.startReplaceableGroup(-1537038451);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
            Function0<Unit> function0522 = function03;
            z3 = ((29360128 & i5) != 8388608) | ((((i14 & 14) ^ 6) > 4 && startRestartGroup.changed(closedFloatingPointRange2)) || (i14 & 6) == 4);
            rememberedValue = startRestartGroup.rememberedValue();
            if (!z3) {
            }
            rememberedValue = new SliderState(f, i13, new Function0<Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$state$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m2936invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2936invoke() {
                    Function0<Unit> value = rememberUpdatedState22.getValue();
                    if (value != null) {
                        value.invoke();
                    }
                }
            }, closedFloatingPointRange2);
            startRestartGroup.updateRememberedValue(rememberedValue);
            SliderState sliderState222 = (SliderState) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            sliderState222.setOnValueChange$material3_release(function1);
            sliderState222.setValue(f);
            int i19222 = i5 >> 3;
            int i20222 = (i19222 & 896) | (i19222 & 112) | ((i5 >> 6) & 57344);
            int i21222 = i5 >> 9;
            Slider(sliderState222, companion, z2, null, mutableInteractionSource2, composableLambda, composableLambda2, startRestartGroup, (i21222 & 3670016) | i20222 | (458752 & i21222), 8);
            if (ComposerKt.isTraceInProgress()) {
            }
            function33 = composableLambda;
            z4 = z2;
            closedFloatingPointRange3 = closedFloatingPointRange2;
            function04 = function0522;
            i15 = i13;
            function34 = composableLambda2;
            sliderColors5 = sliderColors4;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i6 = i4 & 8;
        if (i6 == 0) {
        }
        i7 = i4 & 16;
        if (i7 != 0) {
        }
        function02 = function0;
        if ((196608 & i2) != 0) {
        }
        i8 = i4 & 64;
        if (i8 == 0) {
        }
        i9 = i4 & Fields.SpotShadowColor;
        if (i9 == 0) {
        }
        i10 = i4 & Fields.RotationX;
        if (i10 == 0) {
        }
        i11 = i4 & Fields.RotationY;
        if (i11 == 0) {
        }
        if ((i3 & 6) != 0) {
        }
        if ((i5 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i18 == 0) {
        }
        if (i6 == 0) {
        }
        if (i7 == 0) {
        }
        if ((i4 & 32) == 0) {
        }
        if (i8 == 0) {
        }
        if (i9 == 0) {
        }
        if (i10 == 0) {
        }
        if (i11 == 0) {
        }
        if ((i4 & Fields.RotationZ) == 0) {
        }
        i14 = i12;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        final State<? extends Function0<Unit>> rememberUpdatedState222 = SnapshotStateKt.rememberUpdatedState(function03, startRestartGroup, (i5 >> 12) & 14);
        startRestartGroup.startReplaceableGroup(-1537038451);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
        Function0<Unit> function05222 = function03;
        z3 = ((29360128 & i5) != 8388608) | ((((i14 & 14) ^ 6) > 4 && startRestartGroup.changed(closedFloatingPointRange2)) || (i14 & 6) == 4);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!z3) {
        }
        rememberedValue = new SliderState(f, i13, new Function0<Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$state$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m2936invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2936invoke() {
                Function0<Unit> value = rememberUpdatedState222.getValue();
                if (value != null) {
                    value.invoke();
                }
            }
        }, closedFloatingPointRange2);
        startRestartGroup.updateRememberedValue(rememberedValue);
        SliderState sliderState2222 = (SliderState) rememberedValue;
        startRestartGroup.endReplaceableGroup();
        sliderState2222.setOnValueChange$material3_release(function1);
        sliderState2222.setValue(f);
        int i192222 = i5 >> 3;
        int i202222 = (i192222 & 896) | (i192222 & 112) | ((i5 >> 6) & 57344);
        int i212222 = i5 >> 9;
        Slider(sliderState2222, companion, z2, null, mutableInteractionSource2, composableLambda, composableLambda2, startRestartGroup, (i212222 & 3670016) | i202222 | (458752 & i212222), 8);
        if (ComposerKt.isTraceInProgress()) {
        }
        function33 = composableLambda;
        z4 = z2;
        closedFloatingPointRange3 = closedFloatingPointRange2;
        function04 = function05222;
        i15 = i13;
        function34 = composableLambda2;
        sliderColors5 = sliderColors4;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Slider(final SliderState sliderState, Modifier modifier, boolean z, SliderColors sliderColors, MutableInteractionSource mutableInteractionSource, Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function3, Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function32, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        final boolean z2;
        final SliderColors sliderColors2;
        int i5;
        final MutableInteractionSource mutableInteractionSource2;
        int i6;
        Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function33;
        int i7;
        Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function34;
        Modifier.Companion companion;
        Function3<? super SliderState, ? super Composer, ? super Integer, Unit> composableLambda;
        MutableInteractionSource mutableInteractionSource3;
        Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function35;
        final Modifier modifier3;
        final SliderColors sliderColors3;
        final boolean z3;
        final Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function36;
        final Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function37;
        final MutableInteractionSource mutableInteractionSource4;
        int i8;
        Composer startRestartGroup = composer.startRestartGroup(-1303883986);
        ComposerKt.sourceInformation(startRestartGroup, "C(Slider)P(4,3,1)342@15085L8,343@15145L39,361@15666L188:Slider.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(sliderState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i9 = i2 & 2;
        if (i9 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? Fields.RotationX : Fields.SpotShadowColor;
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        sliderColors2 = sliderColors;
                        if (startRestartGroup.changed(sliderColors2)) {
                            i8 = Fields.CameraDistance;
                            i3 |= i8;
                        }
                    } else {
                        sliderColors2 = sliderColors;
                    }
                    i8 = Fields.RotationZ;
                    i3 |= i8;
                } else {
                    sliderColors2 = sliderColors;
                }
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    i3 |= startRestartGroup.changed(mutableInteractionSource2) ? Fields.Clip : Fields.Shape;
                    i6 = i2 & 32;
                    if (i6 == 0) {
                        i3 |= 196608;
                    } else if ((196608 & i) == 0) {
                        function33 = function3;
                        i3 |= startRestartGroup.changedInstance(function33) ? Fields.RenderEffect : 65536;
                        i7 = i2 & 64;
                        if (i7 != 0) {
                            i3 |= 1572864;
                        } else if ((1572864 & i) == 0) {
                            function34 = function32;
                            i3 |= startRestartGroup.changedInstance(function34) ? 1048576 : Fields.BlendMode;
                            if ((i3 & 599187) == 599186 || !startRestartGroup.getSkipping()) {
                                startRestartGroup.startDefaults();
                                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    companion = i9 == 0 ? Modifier.INSTANCE : modifier2;
                                    if (i4 != 0) {
                                        z2 = true;
                                    }
                                    if ((i2 & 8) != 0) {
                                        i3 &= -7169;
                                        sliderColors2 = SliderDefaults.INSTANCE.colors(startRestartGroup, 6);
                                    }
                                    if (i5 != 0) {
                                        startRestartGroup.startReplaceableGroup(-1537035483);
                                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                                        Object rememberedValue = startRestartGroup.rememberedValue();
                                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                            startRestartGroup.updateRememberedValue(rememberedValue);
                                        }
                                        startRestartGroup.endReplaceableGroup();
                                        mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                                    }
                                    if (i6 != 0) {
                                        function33 = ComposableLambdaKt.composableLambda(startRestartGroup, 1426271326, true, new Function3<SliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$10
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(3);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                                invoke((SliderState) obj, (Composer) obj2, ((Number) obj3).intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(SliderState sliderState2, Composer composer2, int i10) {
                                                ComposerKt.sourceInformation(composer2, "C345@15258L126:Slider.kt#uh7d8r");
                                                if ((i10 & 17) != 16 || !composer2.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1426271326, i10, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:345)");
                                                    }
                                                    SliderDefaults.INSTANCE.m2926Thumb9LiSoMs(MutableInteractionSource.this, null, sliderColors2, z2, 0L, composer2, 196608, 18);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer2.skipToGroupEnd();
                                            }
                                        });
                                    }
                                    if (i7 != 0) {
                                        composableLambda = ComposableLambdaKt.composableLambda(startRestartGroup, 577038345, true, new Function3<SliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$11
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(3);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                                invoke((SliderState) obj, (Composer) obj2, ((Number) obj3).intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(SliderState sliderState2, Composer composer2, int i10) {
                                                ComposerKt.sourceInformation(composer2, "C352@15479L114:Slider.kt#uh7d8r");
                                                if ((i10 & 6) == 0) {
                                                    i10 |= composer2.changed(sliderState2) ? 4 : 2;
                                                }
                                                if ((i10 & 19) != 18 || !composer2.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(577038345, i10, -1, "androidx.compose.material3.Slider.<anonymous> (Slider.kt:352)");
                                                    }
                                                    SliderDefaults.INSTANCE.Track(sliderState2, (Modifier) null, SliderColors.this, z2, composer2, (i10 & 14) | 24576, 2);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer2.skipToGroupEnd();
                                            }
                                        });
                                        mutableInteractionSource3 = mutableInteractionSource2;
                                        function35 = function33;
                                        SliderColors sliderColors4 = sliderColors2;
                                        int i10 = i3;
                                        startRestartGroup.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1303883986, i10, -1, "androidx.compose.material3.Slider (Slider.kt:358)");
                                        }
                                        if (!(sliderState.getSteps() >= 0)) {
                                            throw new IllegalArgumentException("steps should be >= 0".toString());
                                        }
                                        int i11 = i10 >> 3;
                                        SliderImpl(companion, sliderState, z2, mutableInteractionSource3, function35, composableLambda, startRestartGroup, (i10 & 896) | (i11 & 14) | ((i10 << 3) & 112) | (i11 & 7168) | (57344 & i11) | (i11 & 458752));
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        modifier3 = companion;
                                        MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource3;
                                        sliderColors3 = sliderColors4;
                                        z3 = z2;
                                        function36 = composableLambda;
                                        function37 = function35;
                                        mutableInteractionSource4 = mutableInteractionSource5;
                                    }
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i2 & 8) != 0) {
                                        i3 &= -7169;
                                    }
                                    companion = modifier2;
                                }
                                mutableInteractionSource3 = mutableInteractionSource2;
                                function35 = function33;
                                composableLambda = function34;
                                SliderColors sliderColors42 = sliderColors2;
                                int i102 = i3;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                if (!(sliderState.getSteps() >= 0)) {
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                modifier3 = modifier2;
                                z3 = z2;
                                sliderColors3 = sliderColors2;
                                mutableInteractionSource4 = mutableInteractionSource2;
                                function37 = function33;
                                function36 = function34;
                            }
                            ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup != null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$Slider$13
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                        invoke((Composer) obj, ((Number) obj2).intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer2, int i12) {
                                        SliderKt.Slider(SliderState.this, modifier3, z3, sliderColors3, mutableInteractionSource4, function37, function36, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        function34 = function32;
                        if ((i3 & 599187) == 599186) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                        }
                        if (i9 == 0) {
                        }
                        if (i4 != 0) {
                        }
                        if ((i2 & 8) != 0) {
                        }
                        if (i5 != 0) {
                        }
                        if (i6 != 0) {
                        }
                        if (i7 != 0) {
                        }
                        mutableInteractionSource3 = mutableInteractionSource2;
                        function35 = function33;
                        composableLambda = function34;
                        SliderColors sliderColors422 = sliderColors2;
                        int i1022 = i3;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        if (!(sliderState.getSteps() >= 0)) {
                        }
                    }
                    function33 = function3;
                    i7 = i2 & 64;
                    if (i7 != 0) {
                    }
                    function34 = function32;
                    if ((i3 & 599187) == 599186) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i9 == 0) {
                    }
                    if (i4 != 0) {
                    }
                    if ((i2 & 8) != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i7 != 0) {
                    }
                    mutableInteractionSource3 = mutableInteractionSource2;
                    function35 = function33;
                    composableLambda = function34;
                    SliderColors sliderColors4222 = sliderColors2;
                    int i10222 = i3;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    if (!(sliderState.getSteps() >= 0)) {
                    }
                }
                mutableInteractionSource2 = mutableInteractionSource;
                i6 = i2 & 32;
                if (i6 == 0) {
                }
                function33 = function3;
                i7 = i2 & 64;
                if (i7 != 0) {
                }
                function34 = function32;
                if ((i3 & 599187) == 599186) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i9 == 0) {
                }
                if (i4 != 0) {
                }
                if ((i2 & 8) != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if (i7 != 0) {
                }
                mutableInteractionSource3 = mutableInteractionSource2;
                function35 = function33;
                composableLambda = function34;
                SliderColors sliderColors42222 = sliderColors2;
                int i102222 = i3;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                if (!(sliderState.getSteps() >= 0)) {
                }
            }
            z2 = z;
            if ((i & 3072) == 0) {
            }
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            i6 = i2 & 32;
            if (i6 == 0) {
            }
            function33 = function3;
            i7 = i2 & 64;
            if (i7 != 0) {
            }
            function34 = function32;
            if ((i3 & 599187) == 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i9 == 0) {
            }
            if (i4 != 0) {
            }
            if ((i2 & 8) != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if (i7 != 0) {
            }
            mutableInteractionSource3 = mutableInteractionSource2;
            function35 = function33;
            composableLambda = function34;
            SliderColors sliderColors422222 = sliderColors2;
            int i1022222 = i3;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            if (!(sliderState.getSteps() >= 0)) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i & 3072) == 0) {
        }
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        i6 = i2 & 32;
        if (i6 == 0) {
        }
        function33 = function3;
        i7 = i2 & 64;
        if (i7 != 0) {
        }
        function34 = function32;
        if ((i3 & 599187) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i9 == 0) {
        }
        if (i4 != 0) {
        }
        if ((i2 & 8) != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if (i7 != 0) {
        }
        mutableInteractionSource3 = mutableInteractionSource2;
        function35 = function33;
        composableLambda = function34;
        SliderColors sliderColors4222222 = sliderColors2;
        int i10222222 = i3;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        if (!(sliderState.getSteps() >= 0)) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void RangeSlider(final ClosedFloatingPointRange<Float> closedFloatingPointRange, final Function1<? super ClosedFloatingPointRange<Float>, Unit> function1, Modifier modifier, boolean z, ClosedFloatingPointRange<Float> closedFloatingPointRange2, int i, Function0<Unit> function0, SliderColors sliderColors, Composer composer, final int i2, final int i3) {
        int i4;
        int i5;
        Modifier modifier2;
        int i6;
        final boolean z2;
        ClosedFloatingPointRange<Float> closedFloatingPointRange3;
        int i7;
        int i8;
        int i9;
        Function0<Unit> function02;
        final SliderColors colors;
        Object rememberedValue;
        Object rememberedValue2;
        SliderColors sliderColors2;
        final Function0<Unit> function03;
        final ClosedFloatingPointRange<Float> closedFloatingPointRange4;
        final int i10;
        final Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        int i11;
        int i12;
        Composer startRestartGroup = composer.startRestartGroup(-743091416);
        ComposerKt.sourceInformation(startRestartGroup, "C(RangeSlider)P(6,3,2,1,7,5,4)415@18225L8,417@18297L39,418@18394L39,420@18439L987:Slider.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (startRestartGroup.changed(closedFloatingPointRange) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            i4 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
            i5 = i3 & 4;
            if (i5 == 0) {
                i4 |= 384;
            } else if ((i2 & 384) == 0) {
                modifier2 = modifier;
                i4 |= startRestartGroup.changed(modifier2) ? Fields.RotationX : Fields.SpotShadowColor;
                i6 = i3 & 8;
                if (i6 != 0) {
                    i4 |= 3072;
                } else if ((i2 & 3072) == 0) {
                    z2 = z;
                    i4 |= startRestartGroup.changed(z2) ? Fields.CameraDistance : Fields.RotationZ;
                    if ((i2 & 24576) != 0) {
                        if ((i3 & 16) == 0) {
                            closedFloatingPointRange3 = closedFloatingPointRange2;
                            if (startRestartGroup.changed(closedFloatingPointRange3)) {
                                i12 = Fields.Clip;
                                i4 |= i12;
                            }
                        } else {
                            closedFloatingPointRange3 = closedFloatingPointRange2;
                        }
                        i12 = Fields.Shape;
                        i4 |= i12;
                    } else {
                        closedFloatingPointRange3 = closedFloatingPointRange2;
                    }
                    i7 = i3 & 32;
                    if (i7 == 0) {
                        i4 |= 196608;
                    } else if ((196608 & i2) == 0) {
                        i8 = i;
                        i4 |= startRestartGroup.changed(i8) ? Fields.RenderEffect : 65536;
                        i9 = i3 & 64;
                        if (i9 != 0) {
                            i4 |= 1572864;
                        } else if ((1572864 & i2) == 0) {
                            function02 = function0;
                            i4 |= startRestartGroup.changedInstance(function02) ? 1048576 : Fields.BlendMode;
                            if ((i2 & 12582912) == 0) {
                                if ((i3 & Fields.SpotShadowColor) == 0 && startRestartGroup.changed(sliderColors)) {
                                    i11 = 8388608;
                                    i4 |= i11;
                                }
                                i11 = 4194304;
                                i4 |= i11;
                            }
                            if ((i4 & 4793491) == 4793490 || !startRestartGroup.getSkipping()) {
                                startRestartGroup.startDefaults();
                                if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    if (i5 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i6 != 0) {
                                        z2 = true;
                                    }
                                    if ((i3 & 16) != 0) {
                                        i4 &= -57345;
                                        closedFloatingPointRange3 = RangesKt.rangeTo(0.0f, 1.0f);
                                    }
                                    if (i7 != 0) {
                                        i8 = 0;
                                    }
                                    if (i9 != 0) {
                                        function02 = null;
                                    }
                                    if ((i3 & Fields.SpotShadowColor) != 0) {
                                        i4 &= -29360129;
                                        colors = SliderDefaults.INSTANCE.colors(startRestartGroup, 6);
                                        ClosedFloatingPointRange<Float> closedFloatingPointRange5 = closedFloatingPointRange3;
                                        Function0<Unit> function04 = function02;
                                        int i13 = i4;
                                        int i14 = i8;
                                        startRestartGroup.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-743091416, i13, -1, "androidx.compose.material3.RangeSlider (Slider.kt:416)");
                                        }
                                        startRestartGroup.startReplaceableGroup(-223513570);
                                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                                        rememberedValue = startRestartGroup.rememberedValue();
                                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                            startRestartGroup.updateRememberedValue(rememberedValue);
                                        }
                                        final MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) rememberedValue;
                                        startRestartGroup.endReplaceableGroup();
                                        startRestartGroup.startReplaceableGroup(-223513473);
                                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                                        rememberedValue2 = startRestartGroup.rememberedValue();
                                        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                                            startRestartGroup.updateRememberedValue(rememberedValue2);
                                        }
                                        final MutableInteractionSource mutableInteractionSource2 = (MutableInteractionSource) rememberedValue2;
                                        startRestartGroup.endReplaceableGroup();
                                        RangeSlider(closedFloatingPointRange, function1, modifier2, z2, closedFloatingPointRange5, function04, null, mutableInteractionSource, mutableInteractionSource2, ComposableLambdaKt.composableLambda(startRestartGroup, -811582901, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(3);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                                invoke((RangeSliderState) obj, (Composer) obj2, ((Number) obj3).intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(RangeSliderState rangeSliderState, Composer composer2, int i15) {
                                                ComposerKt.sourceInformation(composer2, "C431@18841L147:Slider.kt#uh7d8r");
                                                if ((i15 & 17) != 16 || !composer2.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-811582901, i15, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:431)");
                                                    }
                                                    SliderDefaults.INSTANCE.m2926Thumb9LiSoMs(MutableInteractionSource.this, null, colors, z2, 0L, composer2, 196614, 18);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer2.skipToGroupEnd();
                                            }
                                        }), ComposableLambdaKt.composableLambda(startRestartGroup, -1832060001, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$2
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(3);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                                invoke((RangeSliderState) obj, (Composer) obj2, ((Number) obj3).intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(RangeSliderState rangeSliderState, Composer composer2, int i15) {
                                                ComposerKt.sourceInformation(composer2, "C438@19048L145:Slider.kt#uh7d8r");
                                                if ((i15 & 17) != 16 || !composer2.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1832060001, i15, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:438)");
                                                    }
                                                    SliderDefaults.INSTANCE.m2926Thumb9LiSoMs(MutableInteractionSource.this, null, colors, z2, 0L, composer2, 196614, 18);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer2.skipToGroupEnd();
                                            }
                                        }), ComposableLambdaKt.composableLambda(startRestartGroup, 377064480, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$3
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(3);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                                invoke((RangeSliderState) obj, (Composer) obj2, ((Number) obj3).intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(RangeSliderState rangeSliderState, Composer composer2, int i15) {
                                                ComposerKt.sourceInformation(composer2, "C445@19270L140:Slider.kt#uh7d8r");
                                                if ((i15 & 6) == 0) {
                                                    i15 |= composer2.changed(rangeSliderState) ? 4 : 2;
                                                }
                                                if ((i15 & 19) != 18 || !composer2.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(377064480, i15, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:445)");
                                                    }
                                                    SliderDefaults.INSTANCE.Track(rangeSliderState, (Modifier) null, SliderColors.this, z2, composer2, (i15 & 14) | 24576, 2);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer2.skipToGroupEnd();
                                            }
                                        }), i14, startRestartGroup, (i13 & 14) | 918552576 | (i13 & 112) | (i13 & 896) | (i13 & 7168) | (57344 & i13) | ((i13 >> 3) & 458752), ((i13 >> 9) & 896) | 54, 64);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        sliderColors2 = colors;
                                        function03 = function04;
                                        closedFloatingPointRange4 = closedFloatingPointRange5;
                                        Modifier modifier4 = modifier2;
                                        i10 = i14;
                                        modifier3 = modifier4;
                                    }
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i3 & 16) != 0) {
                                        i4 &= -57345;
                                    }
                                    if ((i3 & Fields.SpotShadowColor) != 0) {
                                        i4 &= -29360129;
                                    }
                                }
                                colors = sliderColors;
                                ClosedFloatingPointRange<Float> closedFloatingPointRange52 = closedFloatingPointRange3;
                                Function0<Unit> function042 = function02;
                                int i132 = i4;
                                int i142 = i8;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                startRestartGroup.startReplaceableGroup(-223513570);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                                rememberedValue = startRestartGroup.rememberedValue();
                                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                }
                                final MutableInteractionSource mutableInteractionSource3 = (MutableInteractionSource) rememberedValue;
                                startRestartGroup.endReplaceableGroup();
                                startRestartGroup.startReplaceableGroup(-223513473);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                                rememberedValue2 = startRestartGroup.rememberedValue();
                                if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                }
                                final MutableInteractionSource mutableInteractionSource22 = (MutableInteractionSource) rememberedValue2;
                                startRestartGroup.endReplaceableGroup();
                                RangeSlider(closedFloatingPointRange, function1, modifier2, z2, closedFloatingPointRange52, function042, null, mutableInteractionSource3, mutableInteractionSource22, ComposableLambdaKt.composableLambda(startRestartGroup, -811582901, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                        invoke((RangeSliderState) obj, (Composer) obj2, ((Number) obj3).intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(RangeSliderState rangeSliderState, Composer composer2, int i15) {
                                        ComposerKt.sourceInformation(composer2, "C431@18841L147:Slider.kt#uh7d8r");
                                        if ((i15 & 17) != 16 || !composer2.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-811582901, i15, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:431)");
                                            }
                                            SliderDefaults.INSTANCE.m2926Thumb9LiSoMs(MutableInteractionSource.this, null, colors, z2, 0L, composer2, 196614, 18);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer2.skipToGroupEnd();
                                    }
                                }), ComposableLambdaKt.composableLambda(startRestartGroup, -1832060001, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$2
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                        invoke((RangeSliderState) obj, (Composer) obj2, ((Number) obj3).intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(RangeSliderState rangeSliderState, Composer composer2, int i15) {
                                        ComposerKt.sourceInformation(composer2, "C438@19048L145:Slider.kt#uh7d8r");
                                        if ((i15 & 17) != 16 || !composer2.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1832060001, i15, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:438)");
                                            }
                                            SliderDefaults.INSTANCE.m2926Thumb9LiSoMs(MutableInteractionSource.this, null, colors, z2, 0L, composer2, 196614, 18);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer2.skipToGroupEnd();
                                    }
                                }), ComposableLambdaKt.composableLambda(startRestartGroup, 377064480, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$3
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                        invoke((RangeSliderState) obj, (Composer) obj2, ((Number) obj3).intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(RangeSliderState rangeSliderState, Composer composer2, int i15) {
                                        ComposerKt.sourceInformation(composer2, "C445@19270L140:Slider.kt#uh7d8r");
                                        if ((i15 & 6) == 0) {
                                            i15 |= composer2.changed(rangeSliderState) ? 4 : 2;
                                        }
                                        if ((i15 & 19) != 18 || !composer2.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(377064480, i15, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:445)");
                                            }
                                            SliderDefaults.INSTANCE.Track(rangeSliderState, (Modifier) null, SliderColors.this, z2, composer2, (i15 & 14) | 24576, 2);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer2.skipToGroupEnd();
                                    }
                                }), i142, startRestartGroup, (i132 & 14) | 918552576 | (i132 & 112) | (i132 & 896) | (i132 & 7168) | (57344 & i132) | ((i132 >> 3) & 458752), ((i132 >> 9) & 896) | 54, 64);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                sliderColors2 = colors;
                                function03 = function042;
                                closedFloatingPointRange4 = closedFloatingPointRange52;
                                Modifier modifier42 = modifier2;
                                i10 = i142;
                                modifier3 = modifier42;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                modifier3 = modifier2;
                                closedFloatingPointRange4 = closedFloatingPointRange3;
                                i10 = i8;
                                function03 = function02;
                                sliderColors2 = sliderColors;
                            }
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup == null) {
                                final boolean z3 = z2;
                                final SliderColors sliderColors3 = sliderColors2;
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$4
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                        invoke((Composer) obj, ((Number) obj2).intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer2, int i15) {
                                        SliderKt.RangeSlider(closedFloatingPointRange, function1, modifier3, z3, closedFloatingPointRange4, i10, function03, sliderColors3, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        function02 = function0;
                        if ((i2 & 12582912) == 0) {
                        }
                        if ((i4 & 4793491) == 4793490) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                        }
                        if (i5 != 0) {
                        }
                        if (i6 != 0) {
                        }
                        if ((i3 & 16) != 0) {
                        }
                        if (i7 != 0) {
                        }
                        if (i9 != 0) {
                        }
                        if ((i3 & Fields.SpotShadowColor) != 0) {
                        }
                        colors = sliderColors;
                        ClosedFloatingPointRange<Float> closedFloatingPointRange522 = closedFloatingPointRange3;
                        Function0<Unit> function0422 = function02;
                        int i1322 = i4;
                        int i1422 = i8;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        startRestartGroup.startReplaceableGroup(-223513570);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                        }
                        final MutableInteractionSource mutableInteractionSource32 = (MutableInteractionSource) rememberedValue;
                        startRestartGroup.endReplaceableGroup();
                        startRestartGroup.startReplaceableGroup(-223513473);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        }
                        final MutableInteractionSource mutableInteractionSource222 = (MutableInteractionSource) rememberedValue2;
                        startRestartGroup.endReplaceableGroup();
                        RangeSlider(closedFloatingPointRange, function1, modifier2, z2, closedFloatingPointRange522, function0422, null, mutableInteractionSource32, mutableInteractionSource222, ComposableLambdaKt.composableLambda(startRestartGroup, -811582901, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                invoke((RangeSliderState) obj, (Composer) obj2, ((Number) obj3).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(RangeSliderState rangeSliderState, Composer composer2, int i15) {
                                ComposerKt.sourceInformation(composer2, "C431@18841L147:Slider.kt#uh7d8r");
                                if ((i15 & 17) != 16 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-811582901, i15, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:431)");
                                    }
                                    SliderDefaults.INSTANCE.m2926Thumb9LiSoMs(MutableInteractionSource.this, null, colors, z2, 0L, composer2, 196614, 18);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }), ComposableLambdaKt.composableLambda(startRestartGroup, -1832060001, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$2
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                invoke((RangeSliderState) obj, (Composer) obj2, ((Number) obj3).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(RangeSliderState rangeSliderState, Composer composer2, int i15) {
                                ComposerKt.sourceInformation(composer2, "C438@19048L145:Slider.kt#uh7d8r");
                                if ((i15 & 17) != 16 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1832060001, i15, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:438)");
                                    }
                                    SliderDefaults.INSTANCE.m2926Thumb9LiSoMs(MutableInteractionSource.this, null, colors, z2, 0L, composer2, 196614, 18);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }), ComposableLambdaKt.composableLambda(startRestartGroup, 377064480, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$3
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                invoke((RangeSliderState) obj, (Composer) obj2, ((Number) obj3).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(RangeSliderState rangeSliderState, Composer composer2, int i15) {
                                ComposerKt.sourceInformation(composer2, "C445@19270L140:Slider.kt#uh7d8r");
                                if ((i15 & 6) == 0) {
                                    i15 |= composer2.changed(rangeSliderState) ? 4 : 2;
                                }
                                if ((i15 & 19) != 18 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(377064480, i15, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:445)");
                                    }
                                    SliderDefaults.INSTANCE.Track(rangeSliderState, (Modifier) null, SliderColors.this, z2, composer2, (i15 & 14) | 24576, 2);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }), i1422, startRestartGroup, (i1322 & 14) | 918552576 | (i1322 & 112) | (i1322 & 896) | (i1322 & 7168) | (57344 & i1322) | ((i1322 >> 3) & 458752), ((i1322 >> 9) & 896) | 54, 64);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        sliderColors2 = colors;
                        function03 = function0422;
                        closedFloatingPointRange4 = closedFloatingPointRange522;
                        Modifier modifier422 = modifier2;
                        i10 = i1422;
                        modifier3 = modifier422;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i8 = i;
                    i9 = i3 & 64;
                    if (i9 != 0) {
                    }
                    function02 = function0;
                    if ((i2 & 12582912) == 0) {
                    }
                    if ((i4 & 4793491) == 4793490) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if ((i3 & 16) != 0) {
                    }
                    if (i7 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if ((i3 & Fields.SpotShadowColor) != 0) {
                    }
                    colors = sliderColors;
                    ClosedFloatingPointRange<Float> closedFloatingPointRange5222 = closedFloatingPointRange3;
                    Function0<Unit> function04222 = function02;
                    int i13222 = i4;
                    int i14222 = i8;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.startReplaceableGroup(-223513570);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                    }
                    final MutableInteractionSource mutableInteractionSource322 = (MutableInteractionSource) rememberedValue;
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.startReplaceableGroup(-223513473);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    }
                    final MutableInteractionSource mutableInteractionSource2222 = (MutableInteractionSource) rememberedValue2;
                    startRestartGroup.endReplaceableGroup();
                    RangeSlider(closedFloatingPointRange, function1, modifier2, z2, closedFloatingPointRange5222, function04222, null, mutableInteractionSource322, mutableInteractionSource2222, ComposableLambdaKt.composableLambda(startRestartGroup, -811582901, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                            invoke((RangeSliderState) obj, (Composer) obj2, ((Number) obj3).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(RangeSliderState rangeSliderState, Composer composer2, int i15) {
                            ComposerKt.sourceInformation(composer2, "C431@18841L147:Slider.kt#uh7d8r");
                            if ((i15 & 17) != 16 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-811582901, i15, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:431)");
                                }
                                SliderDefaults.INSTANCE.m2926Thumb9LiSoMs(MutableInteractionSource.this, null, colors, z2, 0L, composer2, 196614, 18);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), ComposableLambdaKt.composableLambda(startRestartGroup, -1832060001, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                            invoke((RangeSliderState) obj, (Composer) obj2, ((Number) obj3).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(RangeSliderState rangeSliderState, Composer composer2, int i15) {
                            ComposerKt.sourceInformation(composer2, "C438@19048L145:Slider.kt#uh7d8r");
                            if ((i15 & 17) != 16 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1832060001, i15, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:438)");
                                }
                                SliderDefaults.INSTANCE.m2926Thumb9LiSoMs(MutableInteractionSource.this, null, colors, z2, 0L, composer2, 196614, 18);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), ComposableLambdaKt.composableLambda(startRestartGroup, 377064480, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$3
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                            invoke((RangeSliderState) obj, (Composer) obj2, ((Number) obj3).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(RangeSliderState rangeSliderState, Composer composer2, int i15) {
                            ComposerKt.sourceInformation(composer2, "C445@19270L140:Slider.kt#uh7d8r");
                            if ((i15 & 6) == 0) {
                                i15 |= composer2.changed(rangeSliderState) ? 4 : 2;
                            }
                            if ((i15 & 19) != 18 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(377064480, i15, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:445)");
                                }
                                SliderDefaults.INSTANCE.Track(rangeSliderState, (Modifier) null, SliderColors.this, z2, composer2, (i15 & 14) | 24576, 2);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), i14222, startRestartGroup, (i13222 & 14) | 918552576 | (i13222 & 112) | (i13222 & 896) | (i13222 & 7168) | (57344 & i13222) | ((i13222 >> 3) & 458752), ((i13222 >> 9) & 896) | 54, 64);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    sliderColors2 = colors;
                    function03 = function04222;
                    closedFloatingPointRange4 = closedFloatingPointRange5222;
                    Modifier modifier4222 = modifier2;
                    i10 = i14222;
                    modifier3 = modifier4222;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                z2 = z;
                if ((i2 & 24576) != 0) {
                }
                i7 = i3 & 32;
                if (i7 == 0) {
                }
                i8 = i;
                i9 = i3 & 64;
                if (i9 != 0) {
                }
                function02 = function0;
                if ((i2 & 12582912) == 0) {
                }
                if ((i4 & 4793491) == 4793490) {
                }
                startRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if ((i3 & 16) != 0) {
                }
                if (i7 != 0) {
                }
                if (i9 != 0) {
                }
                if ((i3 & Fields.SpotShadowColor) != 0) {
                }
                colors = sliderColors;
                ClosedFloatingPointRange<Float> closedFloatingPointRange52222 = closedFloatingPointRange3;
                Function0<Unit> function042222 = function02;
                int i132222 = i4;
                int i142222 = i8;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup.startReplaceableGroup(-223513570);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                }
                final MutableInteractionSource mutableInteractionSource3222 = (MutableInteractionSource) rememberedValue;
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(-223513473);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                }
                final MutableInteractionSource mutableInteractionSource22222 = (MutableInteractionSource) rememberedValue2;
                startRestartGroup.endReplaceableGroup();
                RangeSlider(closedFloatingPointRange, function1, modifier2, z2, closedFloatingPointRange52222, function042222, null, mutableInteractionSource3222, mutableInteractionSource22222, ComposableLambdaKt.composableLambda(startRestartGroup, -811582901, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        invoke((RangeSliderState) obj, (Composer) obj2, ((Number) obj3).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(RangeSliderState rangeSliderState, Composer composer2, int i15) {
                        ComposerKt.sourceInformation(composer2, "C431@18841L147:Slider.kt#uh7d8r");
                        if ((i15 & 17) != 16 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-811582901, i15, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:431)");
                            }
                            SliderDefaults.INSTANCE.m2926Thumb9LiSoMs(MutableInteractionSource.this, null, colors, z2, 0L, composer2, 196614, 18);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), ComposableLambdaKt.composableLambda(startRestartGroup, -1832060001, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        invoke((RangeSliderState) obj, (Composer) obj2, ((Number) obj3).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(RangeSliderState rangeSliderState, Composer composer2, int i15) {
                        ComposerKt.sourceInformation(composer2, "C438@19048L145:Slider.kt#uh7d8r");
                        if ((i15 & 17) != 16 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1832060001, i15, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:438)");
                            }
                            SliderDefaults.INSTANCE.m2926Thumb9LiSoMs(MutableInteractionSource.this, null, colors, z2, 0L, composer2, 196614, 18);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), ComposableLambdaKt.composableLambda(startRestartGroup, 377064480, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$3
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        invoke((RangeSliderState) obj, (Composer) obj2, ((Number) obj3).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(RangeSliderState rangeSliderState, Composer composer2, int i15) {
                        ComposerKt.sourceInformation(composer2, "C445@19270L140:Slider.kt#uh7d8r");
                        if ((i15 & 6) == 0) {
                            i15 |= composer2.changed(rangeSliderState) ? 4 : 2;
                        }
                        if ((i15 & 19) != 18 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(377064480, i15, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:445)");
                            }
                            SliderDefaults.INSTANCE.Track(rangeSliderState, (Modifier) null, SliderColors.this, z2, composer2, (i15 & 14) | 24576, 2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), i142222, startRestartGroup, (i132222 & 14) | 918552576 | (i132222 & 112) | (i132222 & 896) | (i132222 & 7168) | (57344 & i132222) | ((i132222 >> 3) & 458752), ((i132222 >> 9) & 896) | 54, 64);
                if (ComposerKt.isTraceInProgress()) {
                }
                sliderColors2 = colors;
                function03 = function042222;
                closedFloatingPointRange4 = closedFloatingPointRange52222;
                Modifier modifier42222 = modifier2;
                i10 = i142222;
                modifier3 = modifier42222;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            modifier2 = modifier;
            i6 = i3 & 8;
            if (i6 != 0) {
            }
            z2 = z;
            if ((i2 & 24576) != 0) {
            }
            i7 = i3 & 32;
            if (i7 == 0) {
            }
            i8 = i;
            i9 = i3 & 64;
            if (i9 != 0) {
            }
            function02 = function0;
            if ((i2 & 12582912) == 0) {
            }
            if ((i4 & 4793491) == 4793490) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if ((i3 & 16) != 0) {
            }
            if (i7 != 0) {
            }
            if (i9 != 0) {
            }
            if ((i3 & Fields.SpotShadowColor) != 0) {
            }
            colors = sliderColors;
            ClosedFloatingPointRange<Float> closedFloatingPointRange522222 = closedFloatingPointRange3;
            Function0<Unit> function0422222 = function02;
            int i1322222 = i4;
            int i1422222 = i8;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceableGroup(-223513570);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
            rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            }
            final MutableInteractionSource mutableInteractionSource32222 = (MutableInteractionSource) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-223513473);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            }
            final MutableInteractionSource mutableInteractionSource222222 = (MutableInteractionSource) rememberedValue2;
            startRestartGroup.endReplaceableGroup();
            RangeSlider(closedFloatingPointRange, function1, modifier2, z2, closedFloatingPointRange522222, function0422222, null, mutableInteractionSource32222, mutableInteractionSource222222, ComposableLambdaKt.composableLambda(startRestartGroup, -811582901, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((RangeSliderState) obj, (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RangeSliderState rangeSliderState, Composer composer2, int i15) {
                    ComposerKt.sourceInformation(composer2, "C431@18841L147:Slider.kt#uh7d8r");
                    if ((i15 & 17) != 16 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-811582901, i15, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:431)");
                        }
                        SliderDefaults.INSTANCE.m2926Thumb9LiSoMs(MutableInteractionSource.this, null, colors, z2, 0L, composer2, 196614, 18);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), ComposableLambdaKt.composableLambda(startRestartGroup, -1832060001, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((RangeSliderState) obj, (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RangeSliderState rangeSliderState, Composer composer2, int i15) {
                    ComposerKt.sourceInformation(composer2, "C438@19048L145:Slider.kt#uh7d8r");
                    if ((i15 & 17) != 16 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1832060001, i15, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:438)");
                        }
                        SliderDefaults.INSTANCE.m2926Thumb9LiSoMs(MutableInteractionSource.this, null, colors, z2, 0L, composer2, 196614, 18);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), ComposableLambdaKt.composableLambda(startRestartGroup, 377064480, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((RangeSliderState) obj, (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RangeSliderState rangeSliderState, Composer composer2, int i15) {
                    ComposerKt.sourceInformation(composer2, "C445@19270L140:Slider.kt#uh7d8r");
                    if ((i15 & 6) == 0) {
                        i15 |= composer2.changed(rangeSliderState) ? 4 : 2;
                    }
                    if ((i15 & 19) != 18 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(377064480, i15, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:445)");
                        }
                        SliderDefaults.INSTANCE.Track(rangeSliderState, (Modifier) null, SliderColors.this, z2, composer2, (i15 & 14) | 24576, 2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), i1422222, startRestartGroup, (i1322222 & 14) | 918552576 | (i1322222 & 112) | (i1322222 & 896) | (i1322222 & 7168) | (57344 & i1322222) | ((i1322222 >> 3) & 458752), ((i1322222 >> 9) & 896) | 54, 64);
            if (ComposerKt.isTraceInProgress()) {
            }
            sliderColors2 = colors;
            function03 = function0422222;
            closedFloatingPointRange4 = closedFloatingPointRange522222;
            Modifier modifier422222 = modifier2;
            i10 = i1422222;
            modifier3 = modifier422222;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i5 = i3 & 4;
        if (i5 == 0) {
        }
        modifier2 = modifier;
        i6 = i3 & 8;
        if (i6 != 0) {
        }
        z2 = z;
        if ((i2 & 24576) != 0) {
        }
        i7 = i3 & 32;
        if (i7 == 0) {
        }
        i8 = i;
        i9 = i3 & 64;
        if (i9 != 0) {
        }
        function02 = function0;
        if ((i2 & 12582912) == 0) {
        }
        if ((i4 & 4793491) == 4793490) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if ((i3 & 16) != 0) {
        }
        if (i7 != 0) {
        }
        if (i9 != 0) {
        }
        if ((i3 & Fields.SpotShadowColor) != 0) {
        }
        colors = sliderColors;
        ClosedFloatingPointRange<Float> closedFloatingPointRange5222222 = closedFloatingPointRange3;
        Function0<Unit> function04222222 = function02;
        int i13222222 = i4;
        int i14222222 = i8;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceableGroup(-223513570);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
        }
        final MutableInteractionSource mutableInteractionSource322222 = (MutableInteractionSource) rememberedValue;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(-223513473);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
        }
        final MutableInteractionSource mutableInteractionSource2222222 = (MutableInteractionSource) rememberedValue2;
        startRestartGroup.endReplaceableGroup();
        RangeSlider(closedFloatingPointRange, function1, modifier2, z2, closedFloatingPointRange5222222, function04222222, null, mutableInteractionSource322222, mutableInteractionSource2222222, ComposableLambdaKt.composableLambda(startRestartGroup, -811582901, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((RangeSliderState) obj, (Composer) obj2, ((Number) obj3).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(RangeSliderState rangeSliderState, Composer composer2, int i15) {
                ComposerKt.sourceInformation(composer2, "C431@18841L147:Slider.kt#uh7d8r");
                if ((i15 & 17) != 16 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-811582901, i15, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:431)");
                    }
                    SliderDefaults.INSTANCE.m2926Thumb9LiSoMs(MutableInteractionSource.this, null, colors, z2, 0L, composer2, 196614, 18);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }), ComposableLambdaKt.composableLambda(startRestartGroup, -1832060001, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((RangeSliderState) obj, (Composer) obj2, ((Number) obj3).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(RangeSliderState rangeSliderState, Composer composer2, int i15) {
                ComposerKt.sourceInformation(composer2, "C438@19048L145:Slider.kt#uh7d8r");
                if ((i15 & 17) != 16 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1832060001, i15, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:438)");
                    }
                    SliderDefaults.INSTANCE.m2926Thumb9LiSoMs(MutableInteractionSource.this, null, colors, z2, 0L, composer2, 196614, 18);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }), ComposableLambdaKt.composableLambda(startRestartGroup, 377064480, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((RangeSliderState) obj, (Composer) obj2, ((Number) obj3).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(RangeSliderState rangeSliderState, Composer composer2, int i15) {
                ComposerKt.sourceInformation(composer2, "C445@19270L140:Slider.kt#uh7d8r");
                if ((i15 & 6) == 0) {
                    i15 |= composer2.changed(rangeSliderState) ? 4 : 2;
                }
                if ((i15 & 19) != 18 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(377064480, i15, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:445)");
                    }
                    SliderDefaults.INSTANCE.Track(rangeSliderState, (Modifier) null, SliderColors.this, z2, composer2, (i15 & 14) | 24576, 2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }), i14222222, startRestartGroup, (i13222222 & 14) | 918552576 | (i13222222 & 112) | (i13222222 & 896) | (i13222222 & 7168) | (57344 & i13222222) | ((i13222222 >> 3) & 458752), ((i13222222 >> 9) & 896) | 54, 64);
        if (ComposerKt.isTraceInProgress()) {
        }
        sliderColors2 = colors;
        function03 = function04222222;
        closedFloatingPointRange4 = closedFloatingPointRange5222222;
        Modifier modifier4222222 = modifier2;
        i10 = i14222222;
        modifier3 = modifier4222222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x03fd  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0416  */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02e0  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0385  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void RangeSlider(final ClosedFloatingPointRange<Float> closedFloatingPointRange, final Function1<? super ClosedFloatingPointRange<Float>, Unit> function1, Modifier modifier, boolean z, ClosedFloatingPointRange<Float> closedFloatingPointRange2, Function0<Unit> function0, SliderColors sliderColors, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function3, Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function32, Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function33, int i, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        final boolean z2;
        Modifier modifier2;
        ClosedFloatingPointRange<Float> closedFloatingPointRange3;
        Function0<Unit> function02;
        final SliderColors sliderColors2;
        final MutableInteractionSource mutableInteractionSource3;
        final MutableInteractionSource mutableInteractionSource4;
        int i15;
        boolean z3;
        ComposableLambda composableLambda;
        int i16;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function34;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function35;
        MutableInteractionSource mutableInteractionSource5;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function36;
        Modifier modifier3;
        ClosedFloatingPointRange<Float> closedFloatingPointRange4;
        SliderColors sliderColors3;
        boolean z4;
        Object rememberedValue;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function37;
        boolean z5;
        Object rememberedValue2;
        final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function38;
        final MutableInteractionSource mutableInteractionSource6;
        final int i17;
        final SliderColors sliderColors4;
        final Function0<Unit> function03;
        final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function39;
        final ClosedFloatingPointRange<Float> closedFloatingPointRange5;
        final MutableInteractionSource mutableInteractionSource7;
        final boolean z6;
        final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function310;
        final Modifier modifier4;
        ScopeUpdateScope endRestartGroup;
        int i18;
        Composer startRestartGroup = composer.startRestartGroup(-1048796133);
        ComposerKt.sourceInformation(startRestartGroup, "C(RangeSlider)P(11,5,4,1,12,6!1,7!1,8!1,10)517@23109L8,518@23174L39,519@23268L39,544@24060L43,545@24120L252,558@24400L44,562@24537L291:Slider.kt#uh7d8r");
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i5 = (startRestartGroup.changed(closedFloatingPointRange) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i2 & 48) == 0) {
            i5 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i19 = i4 & 4;
        if (i19 != 0) {
            i5 |= 384;
        } else if ((i2 & 384) == 0) {
            i5 |= startRestartGroup.changed(modifier) ? Fields.RotationX : Fields.SpotShadowColor;
            i6 = i4 & 8;
            if (i6 == 0) {
                i5 |= 3072;
            } else if ((i2 & 3072) == 0) {
                i5 |= startRestartGroup.changed(z) ? Fields.CameraDistance : Fields.RotationZ;
                if ((i2 & 24576) == 0) {
                    if ((i4 & 16) == 0 && startRestartGroup.changed(closedFloatingPointRange2)) {
                        i18 = Fields.Clip;
                        i5 |= i18;
                    }
                    i18 = Fields.Shape;
                    i5 |= i18;
                }
                i7 = i4 & 32;
                if (i7 != 0) {
                    i5 |= 196608;
                } else if ((i2 & 196608) == 0) {
                    i5 |= startRestartGroup.changedInstance(function0) ? Fields.RenderEffect : 65536;
                }
                if ((i2 & 1572864) == 0) {
                    i5 |= ((i4 & 64) == 0 && startRestartGroup.changed(sliderColors)) ? 1048576 : Fields.BlendMode;
                }
                i8 = i4 & Fields.SpotShadowColor;
                if (i8 != 0) {
                    i5 |= 12582912;
                } else if ((i2 & 12582912) == 0) {
                    i5 |= startRestartGroup.changed(mutableInteractionSource) ? 8388608 : 4194304;
                }
                i9 = i4 & Fields.RotationX;
                if (i9 != 0) {
                    i5 |= 100663296;
                } else if ((i2 & 100663296) == 0) {
                    i5 |= startRestartGroup.changed(mutableInteractionSource2) ? 67108864 : 33554432;
                }
                i10 = i4 & Fields.RotationY;
                if (i10 != 0) {
                    i5 |= 805306368;
                } else if ((i2 & 805306368) == 0) {
                    i5 |= startRestartGroup.changedInstance(function3) ? 536870912 : 268435456;
                }
                i11 = i4 & Fields.RotationZ;
                if (i11 != 0) {
                    i12 = i3 | 6;
                } else if ((i3 & 6) == 0) {
                    i12 = i3 | (startRestartGroup.changedInstance(function32) ? 4 : 2);
                } else {
                    i12 = i3;
                }
                i13 = i4 & Fields.CameraDistance;
                if (i13 != 0) {
                    i12 |= 48;
                } else if ((i3 & 48) == 0) {
                    i12 |= startRestartGroup.changedInstance(function33) ? 32 : 16;
                }
                int i20 = i12;
                i14 = i4 & Fields.TransformOrigin;
                if (i14 != 0) {
                    i20 |= 384;
                } else if ((i3 & 384) == 0) {
                    i20 |= startRestartGroup.changed(i) ? Fields.RotationX : Fields.SpotShadowColor;
                    if ((i5 & 306783379) == 306783378 || (i20 & 147) != 146 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            Modifier.Companion companion = i19 == 0 ? Modifier.INSTANCE : modifier;
                            z2 = i6 == 0 ? true : z;
                            if ((i4 & 16) == 0) {
                                modifier2 = companion;
                                closedFloatingPointRange3 = RangesKt.rangeTo(0.0f, 1.0f);
                                i5 &= -57345;
                            } else {
                                modifier2 = companion;
                                closedFloatingPointRange3 = closedFloatingPointRange2;
                            }
                            function02 = i7 == 0 ? null : function0;
                            ClosedFloatingPointRange<Float> closedFloatingPointRange6 = closedFloatingPointRange3;
                            if ((i4 & 64) == 0) {
                                sliderColors2 = SliderDefaults.INSTANCE.colors(startRestartGroup, 6);
                                i5 &= -3670017;
                            } else {
                                sliderColors2 = sliderColors;
                            }
                            if (i8 == 0) {
                                startRestartGroup.startReplaceableGroup(-223508693);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                                Object rememberedValue3 = startRestartGroup.rememberedValue();
                                if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue3 = InteractionSourceKt.MutableInteractionSource();
                                    startRestartGroup.updateRememberedValue(rememberedValue3);
                                }
                                mutableInteractionSource3 = (MutableInteractionSource) rememberedValue3;
                                startRestartGroup.endReplaceableGroup();
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if (i9 == 0) {
                                startRestartGroup.startReplaceableGroup(-223508599);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                                Object rememberedValue4 = startRestartGroup.rememberedValue();
                                if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue4 = InteractionSourceKt.MutableInteractionSource();
                                    startRestartGroup.updateRememberedValue(rememberedValue4);
                                }
                                mutableInteractionSource4 = (MutableInteractionSource) rememberedValue4;
                                startRestartGroup.endReplaceableGroup();
                            } else {
                                mutableInteractionSource4 = mutableInteractionSource2;
                            }
                            if (i10 == 0) {
                                i15 = i5;
                                z3 = true;
                                composableLambda = ComposableLambdaKt.composableLambda(startRestartGroup, -1963073082, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$7
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                        invoke((RangeSliderState) obj, (Composer) obj2, ((Number) obj3).intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(RangeSliderState rangeSliderState, Composer composer2, int i21) {
                                        ComposerKt.sourceInformation(composer2, "C521@23391L131:Slider.kt#uh7d8r");
                                        if ((i21 & 17) != 16 || !composer2.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1963073082, i21, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:521)");
                                            }
                                            SliderDefaults.INSTANCE.m2926Thumb9LiSoMs(MutableInteractionSource.this, null, sliderColors2, z2, 0L, composer2, 196608, 18);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer2.skipToGroupEnd();
                                    }
                                });
                            } else {
                                i15 = i5;
                                z3 = true;
                                composableLambda = function3;
                            }
                            ComposableLambda composableLambda2 = i11 == 0 ? ComposableLambdaKt.composableLambda(startRestartGroup, 1908709951, z3, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$8
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                    invoke((RangeSliderState) obj, (Composer) obj2, ((Number) obj3).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(RangeSliderState rangeSliderState, Composer composer2, int i21) {
                                    ComposerKt.sourceInformation(composer2, "C528@23610L129:Slider.kt#uh7d8r");
                                    if ((i21 & 17) != 16 || !composer2.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1908709951, i21, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:528)");
                                        }
                                        SliderDefaults.INSTANCE.m2926Thumb9LiSoMs(MutableInteractionSource.this, null, sliderColors2, z2, 0L, composer2, 196608, 18);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer2.skipToGroupEnd();
                                }
                            }) : function32;
                            ComposableLambda composableLambda3 = i13 == 0 ? ComposableLambdaKt.composableLambda(startRestartGroup, -429193201, z3, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$9
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                    invoke((RangeSliderState) obj, (Composer) obj2, ((Number) obj3).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(RangeSliderState rangeSliderState, Composer composer2, int i21) {
                                    ComposerKt.sourceInformation(composer2, "C535@23844L124:Slider.kt#uh7d8r");
                                    if ((i21 & 6) == 0) {
                                        i21 |= composer2.changed(rangeSliderState) ? 4 : 2;
                                    }
                                    if ((i21 & 19) != 18 || !composer2.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-429193201, i21, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:535)");
                                        }
                                        SliderDefaults.INSTANCE.Track(rangeSliderState, (Modifier) null, SliderColors.this, z2, composer2, (i21 & 14) | 24576, 2);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer2.skipToGroupEnd();
                                }
                            }) : function33;
                            i5 = i15;
                            if (i14 == 0) {
                                function34 = composableLambda2;
                                function35 = composableLambda3;
                                i16 = 0;
                            } else {
                                i16 = i;
                                function34 = composableLambda2;
                                function35 = composableLambda3;
                            }
                            mutableInteractionSource5 = mutableInteractionSource4;
                            function36 = composableLambda;
                            modifier3 = modifier2;
                            closedFloatingPointRange4 = closedFloatingPointRange6;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i4 & 16) != 0) {
                                i5 &= -57345;
                            }
                            if ((i4 & 64) != 0) {
                                i5 &= -3670017;
                            }
                            modifier3 = modifier;
                            z2 = z;
                            closedFloatingPointRange4 = closedFloatingPointRange2;
                            function02 = function0;
                            sliderColors2 = sliderColors;
                            mutableInteractionSource3 = mutableInteractionSource;
                            mutableInteractionSource5 = mutableInteractionSource2;
                            function36 = function3;
                            function34 = function32;
                            function35 = function33;
                            i16 = i;
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            sliderColors3 = sliderColors2;
                        } else {
                            sliderColors3 = sliderColors2;
                            ComposerKt.traceEventStart(-1048796133, i5, i20, "androidx.compose.material3.RangeSlider (Slider.kt:543)");
                        }
                        final State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function02, startRestartGroup, (i5 >> 15) & 14);
                        startRestartGroup.startReplaceableGroup(-223507747);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                        Function0<Unit> function04 = function02;
                        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function311 = function35;
                        z4 = ((((57344 & i5) ^ 24576) <= 16384 && startRestartGroup.changed(closedFloatingPointRange4)) || (i5 & 24576) == 16384) | ((i20 & 896) != 256);
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (!z4 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                            function37 = function34;
                            rememberedValue = new RangeSliderState(((Number) closedFloatingPointRange.getStart()).floatValue(), ((Number) closedFloatingPointRange.getEndInclusive()).floatValue(), i16, new Function0<Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$state$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                public /* bridge */ /* synthetic */ Object invoke() {
                                    m2935invoke();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: collision with other method in class */
                                public final void m2935invoke() {
                                    Function0<Unit> value = rememberUpdatedState.getValue();
                                    if (value != null) {
                                        value.invoke();
                                    }
                                }
                            }, closedFloatingPointRange4);
                            startRestartGroup.updateRememberedValue(rememberedValue);
                        } else {
                            function37 = function34;
                        }
                        RangeSliderState rangeSliderState = (RangeSliderState) rememberedValue;
                        startRestartGroup.endReplaceableGroup();
                        startRestartGroup.startReplaceableGroup(-223507467);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                        z5 = (i5 & 112) != 32;
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        if (!z5 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = (Function1) new Function1<SliderRange, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$10$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    m2934invokeIf1S1O4(((SliderRange) obj).m2947unboximpl());
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke-If1S1O4, reason: not valid java name */
                                public final void m2934invokeIf1S1O4(long j) {
                                    function1.invoke(RangesKt.rangeTo(SliderRange.m2944getStartimpl(j), SliderRange.m2943getEndInclusiveimpl(j)));
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue2);
                        }
                        startRestartGroup.endReplaceableGroup();
                        rangeSliderState.setOnValueChange$material3_release((Function1) rememberedValue2);
                        rangeSliderState.setActiveRangeStart(((Number) closedFloatingPointRange.getStart()).floatValue());
                        rangeSliderState.setActiveRangeEnd(((Number) closedFloatingPointRange.getEndInclusive()).floatValue());
                        int i21 = i5 >> 3;
                        int i22 = i5 >> 9;
                        int i23 = i20 << 21;
                        RangeSlider(rangeSliderState, modifier3, z2, null, mutableInteractionSource3, mutableInteractionSource5, function36, function37, function311, startRestartGroup, (i22 & 3670016) | (i21 & 896) | (i21 & 112) | (57344 & i22) | (458752 & i22) | (29360128 & i23) | (i23 & 234881024), 8);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function38 = function36;
                        mutableInteractionSource6 = mutableInteractionSource3;
                        i17 = i16;
                        sliderColors4 = sliderColors3;
                        function03 = function04;
                        function39 = function311;
                        closedFloatingPointRange5 = closedFloatingPointRange4;
                        mutableInteractionSource7 = mutableInteractionSource5;
                        z6 = z2;
                        function310 = function37;
                        modifier4 = modifier3;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        modifier4 = modifier;
                        z6 = z;
                        closedFloatingPointRange5 = closedFloatingPointRange2;
                        function03 = function0;
                        sliderColors4 = sliderColors;
                        mutableInteractionSource6 = mutableInteractionSource;
                        mutableInteractionSource7 = mutableInteractionSource2;
                        function38 = function3;
                        function310 = function32;
                        function39 = function33;
                        i17 = i;
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$11
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i24) {
                                SliderKt.RangeSlider(closedFloatingPointRange, function1, modifier4, z6, closedFloatingPointRange5, function03, sliderColors4, mutableInteractionSource6, mutableInteractionSource7, function38, function310, function39, i17, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
                            }
                        });
                        return;
                    }
                    return;
                }
                if ((i5 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                }
                if (i19 == 0) {
                }
                if (i6 == 0) {
                }
                if ((i4 & 16) == 0) {
                }
                if (i7 == 0) {
                }
                ClosedFloatingPointRange<Float> closedFloatingPointRange62 = closedFloatingPointRange3;
                if ((i4 & 64) == 0) {
                }
                if (i8 == 0) {
                }
                if (i9 == 0) {
                }
                if (i10 == 0) {
                }
                if (i11 == 0) {
                }
                if (i13 == 0) {
                }
                i5 = i15;
                if (i14 == 0) {
                }
                mutableInteractionSource5 = mutableInteractionSource4;
                function36 = composableLambda;
                modifier3 = modifier2;
                closedFloatingPointRange4 = closedFloatingPointRange62;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                final State<? extends Function0<Unit>> rememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(function02, startRestartGroup, (i5 >> 15) & 14);
                startRestartGroup.startReplaceableGroup(-223507747);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                Function0<Unit> function042 = function02;
                if ((i20 & 896) != 256) {
                }
                Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function3112 = function35;
                z4 = ((((57344 & i5) ^ 24576) <= 16384 && startRestartGroup.changed(closedFloatingPointRange4)) || (i5 & 24576) == 16384) | ((i20 & 896) != 256);
                rememberedValue = startRestartGroup.rememberedValue();
                if (z4) {
                }
                function37 = function34;
                rememberedValue = new RangeSliderState(((Number) closedFloatingPointRange.getStart()).floatValue(), ((Number) closedFloatingPointRange.getEndInclusive()).floatValue(), i16, new Function0<Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$state$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m2935invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m2935invoke() {
                        Function0<Unit> value = rememberUpdatedState2.getValue();
                        if (value != null) {
                            value.invoke();
                        }
                    }
                }, closedFloatingPointRange4);
                startRestartGroup.updateRememberedValue(rememberedValue);
                RangeSliderState rangeSliderState2 = (RangeSliderState) rememberedValue;
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(-223507467);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                if ((i5 & 112) != 32) {
                }
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (!z5) {
                }
                rememberedValue2 = (Function1) new Function1<SliderRange, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$10$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        m2934invokeIf1S1O4(((SliderRange) obj).m2947unboximpl());
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke-If1S1O4, reason: not valid java name */
                    public final void m2934invokeIf1S1O4(long j) {
                        function1.invoke(RangesKt.rangeTo(SliderRange.m2944getStartimpl(j), SliderRange.m2943getEndInclusiveimpl(j)));
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
                startRestartGroup.endReplaceableGroup();
                rangeSliderState2.setOnValueChange$material3_release((Function1) rememberedValue2);
                rangeSliderState2.setActiveRangeStart(((Number) closedFloatingPointRange.getStart()).floatValue());
                rangeSliderState2.setActiveRangeEnd(((Number) closedFloatingPointRange.getEndInclusive()).floatValue());
                int i212 = i5 >> 3;
                int i222 = i5 >> 9;
                int i232 = i20 << 21;
                RangeSlider(rangeSliderState2, modifier3, z2, null, mutableInteractionSource3, mutableInteractionSource5, function36, function37, function3112, startRestartGroup, (i222 & 3670016) | (i212 & 896) | (i212 & 112) | (57344 & i222) | (458752 & i222) | (29360128 & i232) | (i232 & 234881024), 8);
                if (ComposerKt.isTraceInProgress()) {
                }
                function38 = function36;
                mutableInteractionSource6 = mutableInteractionSource3;
                i17 = i16;
                sliderColors4 = sliderColors3;
                function03 = function042;
                function39 = function3112;
                closedFloatingPointRange5 = closedFloatingPointRange4;
                mutableInteractionSource7 = mutableInteractionSource5;
                z6 = z2;
                function310 = function37;
                modifier4 = modifier3;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            if ((i2 & 24576) == 0) {
            }
            i7 = i4 & 32;
            if (i7 != 0) {
            }
            if ((i2 & 1572864) == 0) {
            }
            i8 = i4 & Fields.SpotShadowColor;
            if (i8 != 0) {
            }
            i9 = i4 & Fields.RotationX;
            if (i9 != 0) {
            }
            i10 = i4 & Fields.RotationY;
            if (i10 != 0) {
            }
            i11 = i4 & Fields.RotationZ;
            if (i11 != 0) {
            }
            i13 = i4 & Fields.CameraDistance;
            if (i13 != 0) {
            }
            int i202 = i12;
            i14 = i4 & Fields.TransformOrigin;
            if (i14 != 0) {
            }
            if ((i5 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
            }
            if (i19 == 0) {
            }
            if (i6 == 0) {
            }
            if ((i4 & 16) == 0) {
            }
            if (i7 == 0) {
            }
            ClosedFloatingPointRange<Float> closedFloatingPointRange622 = closedFloatingPointRange3;
            if ((i4 & 64) == 0) {
            }
            if (i8 == 0) {
            }
            if (i9 == 0) {
            }
            if (i10 == 0) {
            }
            if (i11 == 0) {
            }
            if (i13 == 0) {
            }
            i5 = i15;
            if (i14 == 0) {
            }
            mutableInteractionSource5 = mutableInteractionSource4;
            function36 = composableLambda;
            modifier3 = modifier2;
            closedFloatingPointRange4 = closedFloatingPointRange622;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            final State<? extends Function0<Unit>> rememberUpdatedState22 = SnapshotStateKt.rememberUpdatedState(function02, startRestartGroup, (i5 >> 15) & 14);
            startRestartGroup.startReplaceableGroup(-223507747);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
            Function0<Unit> function0422 = function02;
            if ((i202 & 896) != 256) {
            }
            Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function31122 = function35;
            z4 = ((((57344 & i5) ^ 24576) <= 16384 && startRestartGroup.changed(closedFloatingPointRange4)) || (i5 & 24576) == 16384) | ((i202 & 896) != 256);
            rememberedValue = startRestartGroup.rememberedValue();
            if (z4) {
            }
            function37 = function34;
            rememberedValue = new RangeSliderState(((Number) closedFloatingPointRange.getStart()).floatValue(), ((Number) closedFloatingPointRange.getEndInclusive()).floatValue(), i16, new Function0<Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$state$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m2935invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2935invoke() {
                    Function0<Unit> value = rememberUpdatedState22.getValue();
                    if (value != null) {
                        value.invoke();
                    }
                }
            }, closedFloatingPointRange4);
            startRestartGroup.updateRememberedValue(rememberedValue);
            RangeSliderState rangeSliderState22 = (RangeSliderState) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-223507467);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
            if ((i5 & 112) != 32) {
            }
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (!z5) {
            }
            rememberedValue2 = (Function1) new Function1<SliderRange, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$10$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    m2934invokeIf1S1O4(((SliderRange) obj).m2947unboximpl());
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke-If1S1O4, reason: not valid java name */
                public final void m2934invokeIf1S1O4(long j) {
                    function1.invoke(RangesKt.rangeTo(SliderRange.m2944getStartimpl(j), SliderRange.m2943getEndInclusiveimpl(j)));
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue2);
            startRestartGroup.endReplaceableGroup();
            rangeSliderState22.setOnValueChange$material3_release((Function1) rememberedValue2);
            rangeSliderState22.setActiveRangeStart(((Number) closedFloatingPointRange.getStart()).floatValue());
            rangeSliderState22.setActiveRangeEnd(((Number) closedFloatingPointRange.getEndInclusive()).floatValue());
            int i2122 = i5 >> 3;
            int i2222 = i5 >> 9;
            int i2322 = i202 << 21;
            RangeSlider(rangeSliderState22, modifier3, z2, null, mutableInteractionSource3, mutableInteractionSource5, function36, function37, function31122, startRestartGroup, (i2222 & 3670016) | (i2122 & 896) | (i2122 & 112) | (57344 & i2222) | (458752 & i2222) | (29360128 & i2322) | (i2322 & 234881024), 8);
            if (ComposerKt.isTraceInProgress()) {
            }
            function38 = function36;
            mutableInteractionSource6 = mutableInteractionSource3;
            i17 = i16;
            sliderColors4 = sliderColors3;
            function03 = function0422;
            function39 = function31122;
            closedFloatingPointRange5 = closedFloatingPointRange4;
            mutableInteractionSource7 = mutableInteractionSource5;
            z6 = z2;
            function310 = function37;
            modifier4 = modifier3;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i6 = i4 & 8;
        if (i6 == 0) {
        }
        if ((i2 & 24576) == 0) {
        }
        i7 = i4 & 32;
        if (i7 != 0) {
        }
        if ((i2 & 1572864) == 0) {
        }
        i8 = i4 & Fields.SpotShadowColor;
        if (i8 != 0) {
        }
        i9 = i4 & Fields.RotationX;
        if (i9 != 0) {
        }
        i10 = i4 & Fields.RotationY;
        if (i10 != 0) {
        }
        i11 = i4 & Fields.RotationZ;
        if (i11 != 0) {
        }
        i13 = i4 & Fields.CameraDistance;
        if (i13 != 0) {
        }
        int i2022 = i12;
        i14 = i4 & Fields.TransformOrigin;
        if (i14 != 0) {
        }
        if ((i5 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i19 == 0) {
        }
        if (i6 == 0) {
        }
        if ((i4 & 16) == 0) {
        }
        if (i7 == 0) {
        }
        ClosedFloatingPointRange<Float> closedFloatingPointRange6222 = closedFloatingPointRange3;
        if ((i4 & 64) == 0) {
        }
        if (i8 == 0) {
        }
        if (i9 == 0) {
        }
        if (i10 == 0) {
        }
        if (i11 == 0) {
        }
        if (i13 == 0) {
        }
        i5 = i15;
        if (i14 == 0) {
        }
        mutableInteractionSource5 = mutableInteractionSource4;
        function36 = composableLambda;
        modifier3 = modifier2;
        closedFloatingPointRange4 = closedFloatingPointRange6222;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        final State<? extends Function0<Unit>> rememberUpdatedState222 = SnapshotStateKt.rememberUpdatedState(function02, startRestartGroup, (i5 >> 15) & 14);
        startRestartGroup.startReplaceableGroup(-223507747);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
        Function0<Unit> function04222 = function02;
        if ((i2022 & 896) != 256) {
        }
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function311222 = function35;
        z4 = ((((57344 & i5) ^ 24576) <= 16384 && startRestartGroup.changed(closedFloatingPointRange4)) || (i5 & 24576) == 16384) | ((i2022 & 896) != 256);
        rememberedValue = startRestartGroup.rememberedValue();
        if (z4) {
        }
        function37 = function34;
        rememberedValue = new RangeSliderState(((Number) closedFloatingPointRange.getStart()).floatValue(), ((Number) closedFloatingPointRange.getEndInclusive()).floatValue(), i16, new Function0<Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$state$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m2935invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2935invoke() {
                Function0<Unit> value = rememberUpdatedState222.getValue();
                if (value != null) {
                    value.invoke();
                }
            }
        }, closedFloatingPointRange4);
        startRestartGroup.updateRememberedValue(rememberedValue);
        RangeSliderState rangeSliderState222 = (RangeSliderState) rememberedValue;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(-223507467);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
        if ((i5 & 112) != 32) {
        }
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (!z5) {
        }
        rememberedValue2 = (Function1) new Function1<SliderRange, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$10$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m2934invokeIf1S1O4(((SliderRange) obj).m2947unboximpl());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-If1S1O4, reason: not valid java name */
            public final void m2934invokeIf1S1O4(long j) {
                function1.invoke(RangesKt.rangeTo(SliderRange.m2944getStartimpl(j), SliderRange.m2943getEndInclusiveimpl(j)));
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue2);
        startRestartGroup.endReplaceableGroup();
        rangeSliderState222.setOnValueChange$material3_release((Function1) rememberedValue2);
        rangeSliderState222.setActiveRangeStart(((Number) closedFloatingPointRange.getStart()).floatValue());
        rangeSliderState222.setActiveRangeEnd(((Number) closedFloatingPointRange.getEndInclusive()).floatValue());
        int i21222 = i5 >> 3;
        int i22222 = i5 >> 9;
        int i23222 = i2022 << 21;
        RangeSlider(rangeSliderState222, modifier3, z2, null, mutableInteractionSource3, mutableInteractionSource5, function36, function37, function311222, startRestartGroup, (i22222 & 3670016) | (i21222 & 896) | (i21222 & 112) | (57344 & i22222) | (458752 & i22222) | (29360128 & i23222) | (i23222 & 234881024), 8);
        if (ComposerKt.isTraceInProgress()) {
        }
        function38 = function36;
        mutableInteractionSource6 = mutableInteractionSource3;
        i17 = i16;
        sliderColors4 = sliderColors3;
        function03 = function04222;
        function39 = function311222;
        closedFloatingPointRange5 = closedFloatingPointRange4;
        mutableInteractionSource7 = mutableInteractionSource5;
        z6 = z2;
        function310 = function37;
        modifier4 = modifier3;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x017d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void RangeSlider(final RangeSliderState rangeSliderState, Modifier modifier, boolean z, SliderColors sliderColors, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function3, Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function32, Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function33, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        SliderColors sliderColors2;
        int i5;
        MutableInteractionSource mutableInteractionSource3;
        int i6;
        MutableInteractionSource mutableInteractionSource4;
        int i7;
        int i8;
        int i9;
        Modifier.Companion companion;
        final boolean z2;
        final SliderColors sliderColors3;
        final MutableInteractionSource mutableInteractionSource5;
        final MutableInteractionSource mutableInteractionSource6;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function34;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function35;
        int i10;
        Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> composableLambda;
        final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function36;
        final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function37;
        final Modifier modifier2;
        final SliderColors sliderColors4;
        final MutableInteractionSource mutableInteractionSource7;
        final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function38;
        final boolean z3;
        final MutableInteractionSource mutableInteractionSource8;
        int i11;
        Composer startRestartGroup = composer.startRestartGroup(511405654);
        ComposerKt.sourceInformation(startRestartGroup, "C(RangeSlider)P(7,4,1!1,5!1,6)624@27533L8,625@27598L39,626@27692L39,651@28465L295:Slider.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(rangeSliderState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i12 = i2 & 2;
        if (i12 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                i3 |= startRestartGroup.changed(z) ? Fields.RotationX : Fields.SpotShadowColor;
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        sliderColors2 = sliderColors;
                        if (startRestartGroup.changed(sliderColors2)) {
                            i11 = Fields.CameraDistance;
                            i3 |= i11;
                        }
                    } else {
                        sliderColors2 = sliderColors;
                    }
                    i11 = Fields.RotationZ;
                    i3 |= i11;
                } else {
                    sliderColors2 = sliderColors;
                }
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    mutableInteractionSource3 = mutableInteractionSource;
                    i3 |= startRestartGroup.changed(mutableInteractionSource3) ? Fields.Clip : Fields.Shape;
                    i6 = i2 & 32;
                    if (i6 == 0) {
                        i3 |= 196608;
                    } else if ((196608 & i) == 0) {
                        mutableInteractionSource4 = mutableInteractionSource2;
                        i3 |= startRestartGroup.changed(mutableInteractionSource4) ? Fields.RenderEffect : 65536;
                        i7 = i2 & 64;
                        if (i7 != 0) {
                            i3 |= 1572864;
                        } else if ((i & 1572864) == 0) {
                            i3 |= startRestartGroup.changedInstance(function3) ? 1048576 : Fields.BlendMode;
                        }
                        i8 = i2 & Fields.SpotShadowColor;
                        if (i8 != 0) {
                            i3 |= 12582912;
                        } else if ((i & 12582912) == 0) {
                            i3 |= startRestartGroup.changedInstance(function32) ? 8388608 : 4194304;
                        }
                        i9 = i2 & Fields.RotationX;
                        if (i9 != 0) {
                            i3 |= 100663296;
                        } else if ((i & 100663296) == 0) {
                            i3 |= startRestartGroup.changedInstance(function33) ? 67108864 : 33554432;
                        }
                        if ((i3 & 38347923) == 38347922 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                companion = i12 != 0 ? Modifier.INSTANCE : modifier;
                                z2 = i4 != 0 ? true : z;
                                if ((i2 & 8) != 0) {
                                    sliderColors3 = SliderDefaults.INSTANCE.colors(startRestartGroup, 6);
                                    i3 &= -7169;
                                } else {
                                    sliderColors3 = sliderColors2;
                                }
                                if (i5 != 0) {
                                    startRestartGroup.startReplaceableGroup(-223504269);
                                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                                    Object rememberedValue = startRestartGroup.rememberedValue();
                                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                    }
                                    mutableInteractionSource5 = (MutableInteractionSource) rememberedValue;
                                    startRestartGroup.endReplaceableGroup();
                                } else {
                                    mutableInteractionSource5 = mutableInteractionSource3;
                                }
                                if (i6 != 0) {
                                    startRestartGroup.startReplaceableGroup(-223504175);
                                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                                    Object rememberedValue2 = startRestartGroup.rememberedValue();
                                    if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                                        startRestartGroup.updateRememberedValue(rememberedValue2);
                                    }
                                    mutableInteractionSource6 = (MutableInteractionSource) rememberedValue2;
                                    startRestartGroup.endReplaceableGroup();
                                } else {
                                    mutableInteractionSource6 = mutableInteractionSource4;
                                }
                                ComposableLambda composableLambda2 = i7 != 0 ? ComposableLambdaKt.composableLambda(startRestartGroup, 1884205643, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$14
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                        invoke((RangeSliderState) obj, (Composer) obj2, ((Number) obj3).intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(RangeSliderState rangeSliderState2, Composer composer2, int i13) {
                                        ComposerKt.sourceInformation(composer2, "C628@27815L131:Slider.kt#uh7d8r");
                                        if ((i13 & 17) != 16 || !composer2.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1884205643, i13, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:628)");
                                            }
                                            SliderDefaults.INSTANCE.m2926Thumb9LiSoMs(MutableInteractionSource.this, null, sliderColors3, z2, 0L, composer2, 196608, 18);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer2.skipToGroupEnd();
                                    }
                                }) : function3;
                                ComposableLambda composableLambda3 = i8 != 0 ? ComposableLambdaKt.composableLambda(startRestartGroup, 1016457138, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$15
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                        invoke((RangeSliderState) obj, (Composer) obj2, ((Number) obj3).intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(RangeSliderState rangeSliderState2, Composer composer2, int i13) {
                                        ComposerKt.sourceInformation(composer2, "C635@28034L129:Slider.kt#uh7d8r");
                                        if ((i13 & 17) != 16 || !composer2.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1016457138, i13, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:635)");
                                            }
                                            SliderDefaults.INSTANCE.m2926Thumb9LiSoMs(MutableInteractionSource.this, null, sliderColors3, z2, 0L, composer2, 196608, 18);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer2.skipToGroupEnd();
                                    }
                                }) : function32;
                                if (i9 != 0) {
                                    function34 = composableLambda3;
                                    function35 = composableLambda2;
                                    i10 = i3;
                                    composableLambda = ComposableLambdaKt.composableLambda(startRestartGroup, -1617375262, true, new Function3<RangeSliderState, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$16
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                            invoke((RangeSliderState) obj, (Composer) obj2, ((Number) obj3).intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(RangeSliderState rangeSliderState2, Composer composer2, int i13) {
                                            ComposerKt.sourceInformation(composer2, "C642@28268L124:Slider.kt#uh7d8r");
                                            if ((i13 & 6) == 0) {
                                                i13 |= composer2.changed(rangeSliderState2) ? 4 : 2;
                                            }
                                            if ((i13 & 19) != 18 || !composer2.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1617375262, i13, -1, "androidx.compose.material3.RangeSlider.<anonymous> (Slider.kt:642)");
                                                }
                                                SliderDefaults.INSTANCE.Track(rangeSliderState2, (Modifier) null, SliderColors.this, z2, composer2, (i13 & 14) | 24576, 2);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer2.skipToGroupEnd();
                                        }
                                    });
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(511405654, i10, -1, "androidx.compose.material3.RangeSlider (Slider.kt:648)");
                                    }
                                    if (rangeSliderState.getSteps() >= 0) {
                                        throw new IllegalArgumentException("steps should be >= 0".toString());
                                    }
                                    int i13 = i10 >> 3;
                                    RangeSliderImpl(companion, rangeSliderState, z2, mutableInteractionSource5, mutableInteractionSource6, function35, function34, composableLambda, startRestartGroup, (i10 & 896) | (i13 & 14) | ((i10 << 3) & 112) | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (3670016 & i13) | (i13 & 29360128));
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    function36 = function35;
                                    MutableInteractionSource mutableInteractionSource9 = mutableInteractionSource6;
                                    function37 = function34;
                                    modifier2 = companion;
                                    sliderColors4 = sliderColors3;
                                    mutableInteractionSource7 = mutableInteractionSource9;
                                    MutableInteractionSource mutableInteractionSource10 = mutableInteractionSource5;
                                    function38 = composableLambda;
                                    z3 = z2;
                                    mutableInteractionSource8 = mutableInteractionSource10;
                                } else {
                                    function34 = composableLambda3;
                                    function35 = composableLambda2;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 8) != 0) {
                                    i3 &= -7169;
                                }
                                companion = modifier;
                                z2 = z;
                                function35 = function3;
                                function34 = function32;
                                sliderColors3 = sliderColors2;
                                mutableInteractionSource5 = mutableInteractionSource3;
                                mutableInteractionSource6 = mutableInteractionSource4;
                            }
                            i10 = i3;
                            composableLambda = function33;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            if (rangeSliderState.getSteps() >= 0) {
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            modifier2 = modifier;
                            z3 = z;
                            function36 = function3;
                            function38 = function33;
                            sliderColors4 = sliderColors2;
                            mutableInteractionSource8 = mutableInteractionSource3;
                            mutableInteractionSource7 = mutableInteractionSource4;
                            function37 = function32;
                        }
                        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSlider$18
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i14) {
                                    SliderKt.RangeSlider(RangeSliderState.this, modifier2, z3, sliderColors4, mutableInteractionSource8, mutableInteractionSource7, function36, function37, function38, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    mutableInteractionSource4 = mutableInteractionSource2;
                    i7 = i2 & 64;
                    if (i7 != 0) {
                    }
                    i8 = i2 & Fields.SpotShadowColor;
                    if (i8 != 0) {
                    }
                    i9 = i2 & Fields.RotationX;
                    if (i9 != 0) {
                    }
                    if ((i3 & 38347923) == 38347922) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i12 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if ((i2 & 8) != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i7 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i9 != 0) {
                    }
                }
                mutableInteractionSource3 = mutableInteractionSource;
                i6 = i2 & 32;
                if (i6 == 0) {
                }
                mutableInteractionSource4 = mutableInteractionSource2;
                i7 = i2 & 64;
                if (i7 != 0) {
                }
                i8 = i2 & Fields.SpotShadowColor;
                if (i8 != 0) {
                }
                i9 = i2 & Fields.RotationX;
                if (i9 != 0) {
                }
                if ((i3 & 38347923) == 38347922) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i12 != 0) {
                }
                if (i4 != 0) {
                }
                if ((i2 & 8) != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if (i7 != 0) {
                }
                if (i8 != 0) {
                }
                if (i9 != 0) {
                }
            }
            if ((i & 3072) == 0) {
            }
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            mutableInteractionSource3 = mutableInteractionSource;
            i6 = i2 & 32;
            if (i6 == 0) {
            }
            mutableInteractionSource4 = mutableInteractionSource2;
            i7 = i2 & 64;
            if (i7 != 0) {
            }
            i8 = i2 & Fields.SpotShadowColor;
            if (i8 != 0) {
            }
            i9 = i2 & Fields.RotationX;
            if (i9 != 0) {
            }
            if ((i3 & 38347923) == 38347922) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i12 != 0) {
            }
            if (i4 != 0) {
            }
            if ((i2 & 8) != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if (i7 != 0) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
        }
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        if ((i & 3072) == 0) {
        }
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        mutableInteractionSource3 = mutableInteractionSource;
        i6 = i2 & 32;
        if (i6 == 0) {
        }
        mutableInteractionSource4 = mutableInteractionSource2;
        i7 = i2 & 64;
        if (i7 != 0) {
        }
        i8 = i2 & Fields.SpotShadowColor;
        if (i8 != 0) {
        }
        i9 = i2 & Fields.RotationX;
        if (i9 != 0) {
        }
        if ((i3 & 38347923) == 38347922) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i12 != 0) {
        }
        if (i4 != 0) {
        }
        if ((i2 & 8) != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if (i7 != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
    }

    public static final void SliderImpl(final Modifier modifier, final SliderState sliderState, final boolean z, final MutableInteractionSource mutableInteractionSource, final Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function3, final Function3<? super SliderState, ? super Composer, ? super Integer, Unit> function32, Composer composer, final int i) {
        int i2;
        Modifier draggable;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(1390990089);
        ComposerKt.sourceInformation(startRestartGroup, "C(SliderImpl)P(2,3)673@29093L7,684@29451L28,711@30244L1254,689@29563L1935:Slider.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(sliderState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(z) ? Fields.RotationX : Fields.SpotShadowColor;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changed(mutableInteractionSource) ? Fields.CameraDistance : Fields.RotationZ;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(function3) ? Fields.Clip : Fields.Shape;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function32) ? Fields.RenderEffect : 65536;
        }
        int i3 = i2;
        if ((74899 & i3) == 74898 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1390990089, i3, -1, "androidx.compose.material3.SliderImpl (Slider.kt:672)");
            }
            ProvidableCompositionLocal localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            sliderState.setRtl$material3_release(consume == LayoutDirection.Rtl);
            Modifier sliderTapModifier = sliderTapModifier(Modifier.INSTANCE, sliderState, mutableInteractionSource, z);
            Modifier.Companion companion = Modifier.INSTANCE;
            Orientation orientation = Orientation.Horizontal;
            boolean isRtl = sliderState.getIsRtl();
            boolean isDragging$material3_release = sliderState.isDragging$material3_release();
            Modifier.Companion companion2 = companion;
            SliderState sliderState2 = sliderState;
            startRestartGroup.startReplaceableGroup(1114013383);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
            int i4 = i3 & 112;
            boolean z2 = i4 == 32;
            SliderKt$SliderImpl$drag$1$1 rememberedValue = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new SliderKt$SliderImpl$drag$1$1(sliderState, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            draggable = DraggableKt.draggable(companion2, sliderState2, orientation, (r20 & 4) != 0 ? true : z, (r20 & 8) != 0 ? null : mutableInteractionSource, (r20 & 16) != 0 ? false : isDragging$material3_release, (r20 & 32) != 0 ? DraggableKt.NoOpOnDragStarted : null, (r20 & 64) != 0 ? DraggableKt.NoOpOnDragStopped : (Function3) rememberedValue, (r20 & Fields.SpotShadowColor) != 0 ? false : isRtl);
            Modifier then = FocusableKt.focusable(sliderSemantics(SizeKt.m1116requiredSizeInqDBjuR0$default(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier), SliderTokens.INSTANCE.m3890getHandleWidthD9Ej5fM(), SliderTokens.INSTANCE.m3889getHandleHeightD9Ej5fM(), 0.0f, 0.0f, 12, null), sliderState, z), z, mutableInteractionSource).then(sliderTapModifier).then(draggable);
            composer2 = startRestartGroup;
            composer2.startReplaceableGroup(1114014176);
            ComposerKt.sourceInformation(composer2, "CC(remember):Slider.kt#9igjgp");
            boolean z3 = i4 == 32;
            MeasurePolicy rememberedValue2 = composer2.rememberedValue();
            if (z3 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new MeasurePolicy() { // from class: androidx.compose.material3.SliderKt$SliderImpl$2$1
                    @Override // androidx.compose.p002ui.layout.MeasurePolicy
                    /* renamed from: measure-3p2s80s */
                    public final MeasureResult mo147measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                        int size = list.size();
                        for (int i5 = 0; i5 < size; i5++) {
                            Measurable measurable = list.get(i5);
                            if (LayoutIdKt.getLayoutId(measurable) == SliderComponents.THUMB) {
                                final Placeable mo6318measureBRTryo0 = measurable.mo6318measureBRTryo0(j);
                                int size2 = list.size();
                                for (int i6 = 0; i6 < size2; i6++) {
                                    Measurable measurable2 = list.get(i6);
                                    if (LayoutIdKt.getLayoutId(measurable2) == SliderComponents.TRACK) {
                                        final Placeable mo6318measureBRTryo02 = measurable2.mo6318measureBRTryo0(Constraints.copy-Zbe2FdA$default(ConstraintsKt.offset-NN6Ew-U$default(j, -mo6318measureBRTryo0.getWidth(), 0, 2, (Object) null), 0, 0, 0, 0, 11, (Object) null));
                                        int width = mo6318measureBRTryo0.getWidth() + mo6318measureBRTryo02.getWidth();
                                        int max = Math.max(mo6318measureBRTryo02.getHeight(), mo6318measureBRTryo0.getHeight());
                                        SliderState.this.updateDimensions$material3_release(mo6318measureBRTryo0.getWidth(), width);
                                        final int width2 = mo6318measureBRTryo0.getWidth() / 2;
                                        final int roundToInt = MathKt.roundToInt(mo6318measureBRTryo02.getWidth() * SliderState.this.getCoercedValueAsFraction$material3_release());
                                        final int height = (max - mo6318measureBRTryo02.getHeight()) / 2;
                                        final int height2 = (max - mo6318measureBRTryo0.getHeight()) / 2;
                                        return MeasureScope.layout$default(measureScope, width, max, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.SliderKt$SliderImpl$2$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                invoke((Placeable.PlacementScope) obj);
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Placeable.PlacementScope placementScope) {
                                                Placeable.PlacementScope.placeRelative$default(placementScope, Placeable.this, width2, height, 0.0f, 4, null);
                                                Placeable.PlacementScope.placeRelative$default(placementScope, mo6318measureBRTryo0, roundToInt, height2, 0.0f, 4, null);
                                            }
                                        }, 4, null);
                                    }
                                }
                                throw new NoSuchElementException("Collection contains no element matching the predicate.");
                            }
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                };
                composer2.updateRememberedValue(rememberedValue2);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue2;
            composer2.endReplaceableGroup();
            composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(then);
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            Composer m4109constructorimpl = Updater.m4109constructorimpl(composer2);
            Updater.m4116setimpl(m4109constructorimpl, measurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer2)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(composer2, 1541261174, "C691@29593L102,694@29708L102:Slider.kt#uh7d8r");
            Modifier layoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, SliderComponents.THUMB);
            composer2.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
            composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(layoutId);
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor2);
            } else {
                composer2.useNode();
            }
            Composer m4109constructorimpl2 = Updater.m4109constructorimpl(composer2);
            Updater.m4116setimpl(m4109constructorimpl2, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4116setimpl(m4109constructorimpl2, currentCompositionLocalMap2, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m4109constructorimpl2.getInserting() || !Intrinsics.areEqual(m4109constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m4109constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m4109constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            modifierMaterializerOf2.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer2)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, -1819482525, "C692@29669L12:Slider.kt#uh7d8r");
            int i5 = (i3 >> 3) & 14;
            function3.invoke(sliderState, composer2, Integer.valueOf(((i3 >> 9) & 112) | i5));
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            Modifier layoutId2 = LayoutIdKt.layoutId(Modifier.INSTANCE, SliderComponents.TRACK);
            composer2.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
            composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
            Function0 constructor3 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(layoutId2);
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor3);
            } else {
                composer2.useNode();
            }
            Composer m4109constructorimpl3 = Updater.m4109constructorimpl(composer2);
            Updater.m4116setimpl(m4109constructorimpl3, rememberBoxMeasurePolicy2, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4116setimpl(m4109constructorimpl3, currentCompositionLocalMap3, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m4109constructorimpl3.getInserting() || !Intrinsics.areEqual(m4109constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m4109constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m4109constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            modifierMaterializerOf3.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer2)), composer2, 0);
            composer2.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, -1819482410, "C695@29784L12:Slider.kt#uh7d8r");
            function32.invoke(sliderState, composer2, Integer.valueOf(((i3 >> 12) & 112) | i5));
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$SliderImpl$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i6) {
                    SliderKt.SliderImpl(Modifier.this, sliderState, z, mutableInteractionSource, function3, function32, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final void RangeSliderImpl(final Modifier modifier, final RangeSliderState rangeSliderState, final boolean z, final MutableInteractionSource mutableInteractionSource, final MutableInteractionSource mutableInteractionSource2, final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function3, final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function32, final Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function33, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-1411725677);
        ComposerKt.sourceInformation(startRestartGroup, "C(RangeSliderImpl)P(3,6!1,4!1,5)763@31973L7,775@32367L35,776@32435L33,807@33617L2386,778@32474L3529:Slider.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(rangeSliderState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(z) ? Fields.RotationX : Fields.SpotShadowColor;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changed(mutableInteractionSource) ? Fields.CameraDistance : Fields.RotationZ;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changed(mutableInteractionSource2) ? Fields.Clip : Fields.Shape;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function3) ? Fields.RenderEffect : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function32) ? 1048576 : Fields.BlendMode;
        }
        if ((12582912 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function33) ? 8388608 : 4194304;
        }
        if ((4793491 & i2) != 4793490 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1411725677, i2, -1, "androidx.compose.material3.RangeSliderImpl (Slider.kt:762)");
            }
            ProvidableCompositionLocal localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            rangeSliderState.setRtl$material3_release(consume == LayoutDirection.Rtl);
            Modifier rangeSliderPressDragModifier = rangeSliderPressDragModifier(Modifier.INSTANCE, rangeSliderState, mutableInteractionSource, mutableInteractionSource2, z);
            Modifier rangeSliderStartThumbSemantics = rangeSliderStartThumbSemantics(Modifier.INSTANCE, rangeSliderState, z);
            Modifier rangeSliderEndThumbSemantics = rangeSliderEndThumbSemantics(Modifier.INSTANCE, rangeSliderState, z);
            Strings.Companion companion = Strings.INSTANCE;
            final String m3033getStringNWtq28 = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0754R.string.range_start), startRestartGroup, 0);
            Strings.Companion companion2 = Strings.INSTANCE;
            final String m3033getStringNWtq282 = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0754R.string.range_end), startRestartGroup, 0);
            Modifier then = SizeKt.m1116requiredSizeInqDBjuR0$default(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier), SliderTokens.INSTANCE.m3890getHandleWidthD9Ej5fM(), SliderTokens.INSTANCE.m3889getHandleHeightD9Ej5fM(), 0.0f, 0.0f, 12, null).then(rangeSliderPressDragModifier);
            startRestartGroup.startReplaceableGroup(1300547382);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
            boolean z2 = (i2 & 112) == 32;
            MeasurePolicy rememberedValue = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new MeasurePolicy() { // from class: androidx.compose.material3.SliderKt$RangeSliderImpl$2$1
                    @Override // androidx.compose.p002ui.layout.MeasurePolicy
                    /* renamed from: measure-3p2s80s */
                    public final MeasureResult mo147measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                        int size = list.size();
                        for (int i3 = 0; i3 < size; i3++) {
                            Measurable measurable = list.get(i3);
                            if (LayoutIdKt.getLayoutId(measurable) == RangeSliderComponents.STARTTHUMB) {
                                final Placeable mo6318measureBRTryo0 = measurable.mo6318measureBRTryo0(j);
                                int size2 = list.size();
                                for (int i4 = 0; i4 < size2; i4++) {
                                    Measurable measurable2 = list.get(i4);
                                    if (LayoutIdKt.getLayoutId(measurable2) == RangeSliderComponents.ENDTHUMB) {
                                        final Placeable mo6318measureBRTryo02 = measurable2.mo6318measureBRTryo0(j);
                                        int size3 = list.size();
                                        for (int i5 = 0; i5 < size3; i5++) {
                                            Measurable measurable3 = list.get(i5);
                                            if (LayoutIdKt.getLayoutId(measurable3) == RangeSliderComponents.TRACK) {
                                                final Placeable mo6318measureBRTryo03 = measurable3.mo6318measureBRTryo0(Constraints.copy-Zbe2FdA$default(ConstraintsKt.offset-NN6Ew-U$default(j, (-(mo6318measureBRTryo0.getWidth() + mo6318measureBRTryo02.getWidth())) / 2, 0, 2, (Object) null), 0, 0, 0, 0, 11, (Object) null));
                                                int width = mo6318measureBRTryo03.getWidth() + ((mo6318measureBRTryo0.getWidth() + mo6318measureBRTryo02.getWidth()) / 2);
                                                int max = Math.max(mo6318measureBRTryo03.getHeight(), Math.max(mo6318measureBRTryo0.getHeight(), mo6318measureBRTryo02.getHeight()));
                                                RangeSliderState.this.setStartThumbWidth$material3_release(mo6318measureBRTryo0.getWidth());
                                                RangeSliderState.this.setEndThumbWidth$material3_release(mo6318measureBRTryo02.getWidth());
                                                RangeSliderState.this.setTotalWidth$material3_release(width);
                                                RangeSliderState.this.updateMinMaxPx$material3_release();
                                                final int width2 = mo6318measureBRTryo0.getWidth() / 2;
                                                final int roundToInt = MathKt.roundToInt(mo6318measureBRTryo03.getWidth() * RangeSliderState.this.getCoercedActiveRangeStartAsFraction$material3_release());
                                                final int roundToInt2 = MathKt.roundToInt((mo6318measureBRTryo03.getWidth() * RangeSliderState.this.getCoercedActiveRangeEndAsFraction$material3_release()) + ((mo6318measureBRTryo0.getWidth() - mo6318measureBRTryo02.getWidth()) / 2));
                                                final int height = (max - mo6318measureBRTryo03.getHeight()) / 2;
                                                final int height2 = (max - mo6318measureBRTryo0.getHeight()) / 2;
                                                final int height3 = (max - mo6318measureBRTryo02.getHeight()) / 2;
                                                return MeasureScope.layout$default(measureScope, width, max, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSliderImpl$2$1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                        invoke((Placeable.PlacementScope) obj);
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Placeable.PlacementScope placementScope) {
                                                        Placeable.PlacementScope.placeRelative$default(placementScope, Placeable.this, width2, height, 0.0f, 4, null);
                                                        Placeable.PlacementScope.placeRelative$default(placementScope, mo6318measureBRTryo0, roundToInt, height2, 0.0f, 4, null);
                                                        Placeable.PlacementScope.placeRelative$default(placementScope, mo6318measureBRTryo02, roundToInt2, height3, 0.0f, 4, null);
                                                    }
                                                }, 4, null);
                                            }
                                        }
                                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                                    }
                                }
                                throw new NoSuchElementException("Collection contains no element matching the predicate.");
                            }
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(then);
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
            if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2040261250, "C782@32640L84,780@32504L359,790@33010L82,788@32876L349,796@33238L107:Slider.kt#uh7d8r");
            Modifier layoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, RangeSliderComponents.STARTTHUMB);
            startRestartGroup.startReplaceableGroup(-2040261114);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
            boolean changed = startRestartGroup.changed(m3033getStringNWtq28);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSliderImpl$1$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((SemanticsPropertyReceiver) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, m3033getStringNWtq28);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            Modifier then2 = FocusableKt.focusable(SemanticsModifierKt.semantics(layoutId, true, (Function1) rememberedValue2), z, mutableInteractionSource).then(rangeSliderStartThumbSemantics);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(then2);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            Composer m4109constructorimpl2 = Updater.m4109constructorimpl(startRestartGroup);
            Updater.m4116setimpl(m4109constructorimpl2, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4116setimpl(m4109constructorimpl2, currentCompositionLocalMap2, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m4109constructorimpl2.getInserting() || !Intrinsics.areEqual(m4109constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m4109constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m4109constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            modifierMaterializerOf2.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1631551475, "C787@32844L17:Slider.kt#uh7d8r");
            int i3 = (i2 >> 3) & 14;
            function3.invoke(rangeSliderState, startRestartGroup, Integer.valueOf(((i2 >> 12) & 112) | i3));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            Modifier layoutId2 = LayoutIdKt.layoutId(Modifier.INSTANCE, RangeSliderComponents.ENDTHUMB);
            startRestartGroup.startReplaceableGroup(-2040260744);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
            boolean changed2 = startRestartGroup.changed(m3033getStringNWtq282);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSliderImpl$1$3$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((SemanticsPropertyReceiver) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, m3033getStringNWtq282);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceableGroup();
            Modifier then3 = FocusableKt.focusable(SemanticsModifierKt.semantics(layoutId2, true, (Function1) rememberedValue3), z, mutableInteractionSource2).then(rangeSliderEndThumbSemantics);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0 constructor3 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(then3);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor3);
            } else {
                startRestartGroup.useNode();
            }
            Composer m4109constructorimpl3 = Updater.m4109constructorimpl(startRestartGroup);
            Updater.m4116setimpl(m4109constructorimpl3, rememberBoxMeasurePolicy2, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4116setimpl(m4109constructorimpl3, currentCompositionLocalMap3, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m4109constructorimpl3.getInserting() || !Intrinsics.areEqual(m4109constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m4109constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m4109constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            modifierMaterializerOf3.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1631551839, "C795@33208L15:Slider.kt#uh7d8r");
            function32.invoke(rangeSliderState, startRestartGroup, Integer.valueOf(((i2 >> 15) & 112) | i3));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            Modifier layoutId3 = LayoutIdKt.layoutId(Modifier.INSTANCE, RangeSliderComponents.TRACK);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0 constructor4 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(layoutId3);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor4);
            } else {
                startRestartGroup.useNode();
            }
            Composer m4109constructorimpl4 = Updater.m4109constructorimpl(startRestartGroup);
            Updater.m4116setimpl(m4109constructorimpl4, rememberBoxMeasurePolicy3, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4116setimpl(m4109constructorimpl4, currentCompositionLocalMap4, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m4109constructorimpl4.getInserting() || !Intrinsics.areEqual(m4109constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                m4109constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                m4109constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            modifierMaterializerOf4.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1631551950, "C797@33319L12:Slider.kt#uh7d8r");
            function33.invoke(rangeSliderState, startRestartGroup, Integer.valueOf(((i2 >> 18) & 112) | i3));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderKt$RangeSliderImpl$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i4) {
                    SliderKt.RangeSliderImpl(Modifier.this, rangeSliderState, z, mutableInteractionSource, mutableInteractionSource2, function3, function32, function33, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0067 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* renamed from: awaitSlop-8vUncbI */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m2930awaitSlop8vUncbI(AwaitPointerEventScope awaitPointerEventScope, long j, int i, Continuation<? super Pair<PointerInputChange, Float>> continuation) {
        SliderKt$awaitSlop$1 sliderKt$awaitSlop$1;
        int i2;
        Ref.FloatRef floatRef;
        PointerInputChange pointerInputChange;
        if (continuation instanceof SliderKt$awaitSlop$1) {
            sliderKt$awaitSlop$1 = (SliderKt$awaitSlop$1) continuation;
            if ((sliderKt$awaitSlop$1.label & Integer.MIN_VALUE) != 0) {
                sliderKt$awaitSlop$1.label -= Integer.MIN_VALUE;
                SliderKt$awaitSlop$1 sliderKt$awaitSlop$12 = sliderKt$awaitSlop$1;
                Object obj = sliderKt$awaitSlop$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = sliderKt$awaitSlop$12.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    final Ref.FloatRef floatRef2 = new Ref.FloatRef();
                    Function2<PointerInputChange, Float, Unit> function2 = new Function2<PointerInputChange, Float, Unit>() { // from class: androidx.compose.material3.SliderKt$awaitSlop$postPointerSlop$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                            invoke((PointerInputChange) obj2, ((Number) obj3).floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(PointerInputChange pointerInputChange2, float f) {
                            pointerInputChange2.consume();
                            floatRef2.element = f;
                        }
                    };
                    sliderKt$awaitSlop$12.L$0 = floatRef2;
                    sliderKt$awaitSlop$12.label = 1;
                    Object m2542awaitHorizontalPointerSlopOrCancellationgDDlDlE = DragGestureDetectorCopyKt.m2542awaitHorizontalPointerSlopOrCancellationgDDlDlE(awaitPointerEventScope, j, i, function2, sliderKt$awaitSlop$12);
                    if (m2542awaitHorizontalPointerSlopOrCancellationgDDlDlE == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = m2542awaitHorizontalPointerSlopOrCancellationgDDlDlE;
                    floatRef = floatRef2;
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    floatRef = (Ref.FloatRef) sliderKt$awaitSlop$12.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                pointerInputChange = (PointerInputChange) obj;
                if (pointerInputChange == null) {
                    return TuplesKt.to(pointerInputChange, Boxing.boxFloat(floatRef.element));
                }
                return null;
            }
        }
        sliderKt$awaitSlop$1 = new SliderKt$awaitSlop$1(continuation);
        SliderKt$awaitSlop$1 sliderKt$awaitSlop$122 = sliderKt$awaitSlop$1;
        Object obj2 = sliderKt$awaitSlop$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = sliderKt$awaitSlop$122.label;
        if (i2 != 0) {
        }
        pointerInputChange = (PointerInputChange) obj2;
        if (pointerInputChange == null) {
        }
    }

    public static final float[] stepsToTickFractions(int i) {
        if (i == 0) {
            return new float[0];
        }
        int i2 = i + 2;
        float[] fArr = new float[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            fArr[i3] = i3 / (i + 1);
        }
        return fArr;
    }

    public static final float scale(float f, float f2, float f3, float f4, float f5) {
        return MathHelpersKt.lerp(f4, f5, calcFraction(f, f2, f3));
    }

    /* renamed from: scale-ziovWd0 */
    public static final long m2933scaleziovWd0(float f, float f2, long j, float f3, float f4) {
        return SliderRange(scale(f, f2, SliderRange.m2944getStartimpl(j), f3, f4), scale(f, f2, SliderRange.m2943getEndInclusiveimpl(j), f3, f4));
    }

    public static final float calcFraction(float f, float f2, float f3) {
        float f4 = f2 - f;
        return RangesKt.coerceIn((f4 > 0.0f ? 1 : (f4 == 0.0f ? 0 : -1)) == 0 ? 0.0f : (f3 - f) / f4, 0.0f, 1.0f);
    }

    private static final Modifier sliderSemantics(Modifier modifier, final SliderState sliderState, final boolean z) {
        return ProgressSemanticsKt.progressSemantics(SemanticsModifierKt.semantics$default(modifier, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.SliderKt$sliderSemantics$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SemanticsPropertyReceiver) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                if (!z) {
                    SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
                }
                final SliderState sliderState2 = sliderState;
                SemanticsPropertiesKt.setProgress$default(semanticsPropertyReceiver, (String) null, new Function1<Float, Boolean>() { // from class: androidx.compose.material3.SliderKt$sliderSemantics$1.1
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return invoke(((Number) obj).floatValue());
                    }

                    public final Boolean invoke(float f) {
                        int steps;
                        float coerceIn = RangesKt.coerceIn(f, ((Number) SliderState.this.getValueRange().getStart()).floatValue(), ((Number) SliderState.this.getValueRange().getEndInclusive()).floatValue());
                        if (SliderState.this.getSteps() > 0 && (steps = SliderState.this.getSteps() + 1) >= 0) {
                            float f2 = coerceIn;
                            float f3 = f2;
                            int i = 0;
                            while (true) {
                                float lerp = MathHelpersKt.lerp(((Number) SliderState.this.getValueRange().getStart()).floatValue(), ((Number) SliderState.this.getValueRange().getEndInclusive()).floatValue(), i / (SliderState.this.getSteps() + 1));
                                float f4 = lerp - coerceIn;
                                if (Math.abs(f4) <= f2) {
                                    f2 = Math.abs(f4);
                                    f3 = lerp;
                                }
                                if (i == steps) {
                                    break;
                                }
                                i++;
                            }
                            coerceIn = f3;
                        }
                        if (!(coerceIn == SliderState.this.getValue())) {
                            if (!(coerceIn == SliderState.this.getValue())) {
                                if (SliderState.this.getOnValueChange$material3_release() != null) {
                                    Function1<Float, Unit> onValueChange$material3_release = SliderState.this.getOnValueChange$material3_release();
                                    if (onValueChange$material3_release != null) {
                                        onValueChange$material3_release.invoke(Float.valueOf(coerceIn));
                                    }
                                } else {
                                    SliderState.this.setValue(coerceIn);
                                }
                            }
                            Function0<Unit> onValueChangeFinished = SliderState.this.getOnValueChangeFinished();
                            if (onValueChangeFinished != null) {
                                onValueChangeFinished.invoke();
                            }
                            r1 = true;
                        }
                        return Boolean.valueOf(r1);
                    }
                }, 1, (Object) null);
            }
        }, 1, (Object) null), sliderState.getValue(), RangesKt.rangeTo(((Number) sliderState.getValueRange().getStart()).floatValue(), ((Number) sliderState.getValueRange().getEndInclusive()).floatValue()), sliderState.getSteps());
    }

    private static final Modifier rangeSliderStartThumbSemantics(Modifier modifier, final RangeSliderState rangeSliderState, final boolean z) {
        final ClosedFloatingPointRange rangeTo = RangesKt.rangeTo(((Number) rangeSliderState.getValueRange().getStart()).floatValue(), rangeSliderState.getActiveRangeEnd());
        return ProgressSemanticsKt.progressSemantics(SemanticsModifierKt.semantics$default(modifier, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.SliderKt$rangeSliderStartThumbSemantics$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SemanticsPropertyReceiver) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                if (!z) {
                    SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
                }
                final ClosedFloatingPointRange<Float> closedFloatingPointRange = rangeTo;
                final RangeSliderState rangeSliderState2 = rangeSliderState;
                SemanticsPropertiesKt.setProgress$default(semanticsPropertyReceiver, (String) null, new Function1<Float, Boolean>() { // from class: androidx.compose.material3.SliderKt$rangeSliderStartThumbSemantics$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return invoke(((Number) obj).floatValue());
                    }

                    public final Boolean invoke(float f) {
                        int startSteps$material3_release;
                        float coerceIn = RangesKt.coerceIn(f, ((Number) closedFloatingPointRange.getStart()).floatValue(), ((Number) closedFloatingPointRange.getEndInclusive()).floatValue());
                        boolean z2 = false;
                        if (rangeSliderState2.getStartSteps$material3_release() > 0 && (startSteps$material3_release = rangeSliderState2.getStartSteps$material3_release() + 1) >= 0) {
                            float f2 = coerceIn;
                            float f3 = f2;
                            int i = 0;
                            while (true) {
                                float lerp = MathHelpersKt.lerp(((Number) closedFloatingPointRange.getStart()).floatValue(), ((Number) closedFloatingPointRange.getEndInclusive()).floatValue(), i / (rangeSliderState2.getStartSteps$material3_release() + 1));
                                float f4 = lerp - coerceIn;
                                if (Math.abs(f4) <= f2) {
                                    f2 = Math.abs(f4);
                                    f3 = lerp;
                                }
                                if (i == startSteps$material3_release) {
                                    break;
                                }
                                i++;
                            }
                            coerceIn = f3;
                        }
                        if (!(coerceIn == rangeSliderState2.getActiveRangeStart())) {
                            long SliderRange = SliderKt.SliderRange(coerceIn, rangeSliderState2.getActiveRangeEnd());
                            if (!SliderRange.m2942equalsimpl0(SliderRange, SliderKt.SliderRange(rangeSliderState2.getActiveRangeStart(), rangeSliderState2.getActiveRangeEnd()))) {
                                if (rangeSliderState2.getOnValueChange$material3_release() != null) {
                                    Function1<SliderRange, Unit> onValueChange$material3_release = rangeSliderState2.getOnValueChange$material3_release();
                                    if (onValueChange$material3_release != null) {
                                        onValueChange$material3_release.invoke(SliderRange.m2939boximpl(SliderRange));
                                    }
                                } else {
                                    rangeSliderState2.setActiveRangeStart(SliderRange.m2944getStartimpl(SliderRange));
                                    rangeSliderState2.setActiveRangeEnd(SliderRange.m2943getEndInclusiveimpl(SliderRange));
                                }
                            }
                            Function0<Unit> onValueChangeFinished = rangeSliderState2.getOnValueChangeFinished();
                            if (onValueChangeFinished != null) {
                                onValueChangeFinished.invoke();
                            }
                            z2 = true;
                        }
                        return Boolean.valueOf(z2);
                    }
                }, 1, (Object) null);
            }
        }, 1, (Object) null), rangeSliderState.getActiveRangeStart(), rangeTo, rangeSliderState.getStartSteps$material3_release());
    }

    private static final Modifier rangeSliderEndThumbSemantics(Modifier modifier, final RangeSliderState rangeSliderState, final boolean z) {
        final ClosedFloatingPointRange rangeTo = RangesKt.rangeTo(rangeSliderState.getActiveRangeStart(), ((Number) rangeSliderState.getValueRange().getEndInclusive()).floatValue());
        return ProgressSemanticsKt.progressSemantics(SemanticsModifierKt.semantics$default(modifier, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.SliderKt$rangeSliderEndThumbSemantics$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SemanticsPropertyReceiver) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                if (!z) {
                    SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
                }
                final ClosedFloatingPointRange<Float> closedFloatingPointRange = rangeTo;
                final RangeSliderState rangeSliderState2 = rangeSliderState;
                SemanticsPropertiesKt.setProgress$default(semanticsPropertyReceiver, (String) null, new Function1<Float, Boolean>() { // from class: androidx.compose.material3.SliderKt$rangeSliderEndThumbSemantics$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return invoke(((Number) obj).floatValue());
                    }

                    public final Boolean invoke(float f) {
                        int endSteps$material3_release;
                        float coerceIn = RangesKt.coerceIn(f, ((Number) closedFloatingPointRange.getStart()).floatValue(), ((Number) closedFloatingPointRange.getEndInclusive()).floatValue());
                        boolean z2 = false;
                        if (rangeSliderState2.getEndSteps$material3_release() > 0 && (endSteps$material3_release = rangeSliderState2.getEndSteps$material3_release() + 1) >= 0) {
                            float f2 = coerceIn;
                            float f3 = f2;
                            int i = 0;
                            while (true) {
                                float lerp = MathHelpersKt.lerp(((Number) closedFloatingPointRange.getStart()).floatValue(), ((Number) closedFloatingPointRange.getEndInclusive()).floatValue(), i / (rangeSliderState2.getEndSteps$material3_release() + 1));
                                float f4 = lerp - coerceIn;
                                if (Math.abs(f4) <= f2) {
                                    f2 = Math.abs(f4);
                                    f3 = lerp;
                                }
                                if (i == endSteps$material3_release) {
                                    break;
                                }
                                i++;
                            }
                            coerceIn = f3;
                        }
                        if (!(coerceIn == rangeSliderState2.getActiveRangeEnd())) {
                            long SliderRange = SliderKt.SliderRange(rangeSliderState2.getActiveRangeStart(), coerceIn);
                            if (!SliderRange.m2942equalsimpl0(SliderRange, SliderKt.SliderRange(rangeSliderState2.getActiveRangeStart(), rangeSliderState2.getActiveRangeEnd()))) {
                                if (rangeSliderState2.getOnValueChange$material3_release() != null) {
                                    Function1<SliderRange, Unit> onValueChange$material3_release = rangeSliderState2.getOnValueChange$material3_release();
                                    if (onValueChange$material3_release != null) {
                                        onValueChange$material3_release.invoke(SliderRange.m2939boximpl(SliderRange));
                                    }
                                } else {
                                    rangeSliderState2.setActiveRangeStart(SliderRange.m2944getStartimpl(SliderRange));
                                    rangeSliderState2.setActiveRangeEnd(SliderRange.m2943getEndInclusiveimpl(SliderRange));
                                }
                            }
                            Function0<Unit> onValueChangeFinished = rangeSliderState2.getOnValueChangeFinished();
                            if (onValueChangeFinished != null) {
                                onValueChangeFinished.invoke();
                            }
                            z2 = true;
                        }
                        return Boolean.valueOf(z2);
                    }
                }, 1, (Object) null);
            }
        }, 1, (Object) null), rangeSliderState.getActiveRangeEnd(), rangeTo, rangeSliderState.getEndSteps$material3_release());
    }

    private static final Modifier sliderTapModifier(Modifier modifier, SliderState sliderState, MutableInteractionSource mutableInteractionSource, boolean z) {
        Modifier then;
        if (!z) {
            return modifier;
        }
        then = modifier.then((Modifier) new SuspendPointerInputElement(sliderState, mutableInteractionSource, null, new C0769xe3d9cdbd(new SliderKt$sliderTapModifier$1(sliderState, null)), 4, null));
        return then;
    }

    private static final Modifier rangeSliderPressDragModifier(Modifier modifier, RangeSliderState rangeSliderState, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, boolean z) {
        Modifier then;
        if (!z) {
            return modifier;
        }
        then = modifier.then((Modifier) new SuspendPointerInputElement(null, null, new Object[]{mutableInteractionSource, mutableInteractionSource2, rangeSliderState}, new C0769xe3d9cdbd(new SliderKt$rangeSliderPressDragModifier$1(rangeSliderState, mutableInteractionSource, mutableInteractionSource2, null)), 3, null));
        return then;
    }

    static {
        float m3890getHandleWidthD9Ej5fM = SliderTokens.INSTANCE.m3890getHandleWidthD9Ej5fM();
        ThumbWidth = m3890getHandleWidthD9Ej5fM;
        float m3889getHandleHeightD9Ej5fM = SliderTokens.INSTANCE.m3889getHandleHeightD9Ej5fM();
        ThumbHeight = m3889getHandleHeightD9Ej5fM;
        ThumbSize = DpKt.DpSize-YgX7TsA(m3890getHandleWidthD9Ej5fM, m3889getHandleHeightD9Ej5fM);
        ThumbDefaultElevation = Dp.constructor-impl(1);
        ThumbPressedElevation = Dp.constructor-impl(6);
        TickSize = SliderTokens.INSTANCE.m3896getTickMarksContainerSizeD9Ej5fM();
        TrackHeight = SliderTokens.INSTANCE.m3891getInactiveTrackHeightD9Ej5fM();
    }

    public static final float getThumbWidth() {
        return ThumbWidth;
    }

    public static final float getTrackHeight() {
        return TrackHeight;
    }

    public static final long SliderRange(float f, float f2) {
        boolean z = true;
        if (!(Float.isNaN(f) && Float.isNaN(f2)) && f > f2) {
            z = false;
        }
        if (!z) {
            throw new IllegalArgumentException(("start(" + f + ") must be <= endInclusive(" + f2 + ')').toString());
        }
        return SliderRange.m2940constructorimpl((Float.floatToRawIntBits(f2) & 4294967295L) | (Float.floatToRawIntBits(f) << 32));
    }

    public static final long SliderRange(ClosedFloatingPointRange<Float> closedFloatingPointRange) {
        float floatValue = ((Number) closedFloatingPointRange.getStart()).floatValue();
        float floatValue2 = ((Number) closedFloatingPointRange.getEndInclusive()).floatValue();
        boolean z = true;
        if (!(Float.isNaN(floatValue) && Float.isNaN(floatValue2)) && floatValue > floatValue2) {
            z = false;
        }
        if (!z) {
            throw new IllegalArgumentException(("ClosedFloatingPointRange<Float>.start(" + floatValue + ") must be <= ClosedFloatingPoint.endInclusive(" + floatValue2 + ')').toString());
        }
        return SliderRange.m2940constructorimpl((Float.floatToRawIntBits(floatValue) << 32) | (Float.floatToRawIntBits(floatValue2) & 4294967295L));
    }

    /* renamed from: isSpecified-If1S1O4 */
    public static final boolean m2931isSpecifiedIf1S1O4(long j) {
        return j != SliderRange.INSTANCE.m2949getUnspecifiedFYbKRX4();
    }

    public static final float snapValueToTick(float f, float[] fArr, float f2, float f3) {
        Float valueOf;
        if (fArr.length == 0) {
            valueOf = null;
        } else {
            float f4 = fArr[0];
            int lastIndex = ArraysKt.getLastIndex(fArr);
            if (lastIndex != 0) {
                float abs = Math.abs(MathHelpersKt.lerp(f2, f3, f4) - f);
                IntIterator it = new IntRange(1, lastIndex).iterator();
                while (it.hasNext()) {
                    float f5 = fArr[it.nextInt()];
                    float abs2 = Math.abs(MathHelpersKt.lerp(f2, f3, f5) - f);
                    if (Float.compare(abs, abs2) > 0) {
                        f4 = f5;
                        abs = abs2;
                    }
                }
                valueOf = Float.valueOf(f4);
            } else {
                valueOf = Float.valueOf(f4);
            }
        }
        return valueOf != null ? MathHelpersKt.lerp(f2, f3, valueOf.floatValue()) : f;
    }
}
