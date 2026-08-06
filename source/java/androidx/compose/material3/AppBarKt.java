package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.material3.tokens.BottomAppBarTokens;
import androidx.compose.material3.tokens.TopAppBarLargeTokens;
import androidx.compose.material3.tokens.TopAppBarMediumTokens;
import androidx.compose.material3.tokens.TopAppBarSmallTokens;
import androidx.compose.p002ui.Alignment;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.draw.ClipKt;
import androidx.compose.p002ui.graphics.Color;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.p002ui.graphics.Shape;
import androidx.compose.p002ui.layout.AlignmentLineKt;
import androidx.compose.p002ui.layout.LayoutIdKt;
import androidx.compose.p002ui.layout.LayoutKt;
import androidx.compose.p002ui.layout.LayoutModifierKt;
import androidx.compose.p002ui.layout.Measurable;
import androidx.compose.p002ui.layout.MeasurePolicy;
import androidx.compose.p002ui.layout.MeasureResult;
import androidx.compose.p002ui.layout.MeasureScope;
import androidx.compose.p002ui.layout.Placeable;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
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
import kotlin.ranges.RangesKt;

/* compiled from: AppBar.kt */
@Metadata(d1 = {"\u0000®\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0083\u0001\u0010\u0010\u001a\u00020\u00112\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"H\u0007ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\u008f\u0001\u0010\u0010\u001a\u00020\u00112\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&H\u0007ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001al\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\u001c\u0010)\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b*\u0010+\u001ax\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\u001c\u0010)\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b,\u0010-\u001a \u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u000201H\u0007\u001a\u007f\u00104\u001a\u00020\u00112\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u00107\u001a\u0002082\n\b\u0002\u0010%\u001a\u0004\u0018\u000109H\u0007¢\u0006\u0002\u0010:\u001a\u007f\u0010;\u001a\u00020\u00112\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u00107\u001a\u0002082\n\b\u0002\u0010%\u001a\u0004\u0018\u000109H\u0007¢\u0006\u0002\u0010:\u001a\u007f\u0010<\u001a\u00020\u00112\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u00107\u001a\u0002082\n\b\u0002\u0010%\u001a\u0004\u0018\u000109H\u0007¢\u0006\u0002\u0010:\u001a\u0085\u0001\u0010=\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\u0011\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\u0006\u0010!\u001a\u00020\"2\u0006\u00107\u001a\u0002082\b\u0010%\u001a\u0004\u0018\u000109H\u0003¢\u0006\u0002\u0010B\u001a\u007f\u0010C\u001a\u00020\u00112\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u00107\u001a\u0002082\n\b\u0002\u0010%\u001a\u0004\u0018\u000109H\u0007¢\u0006\u0002\u0010:\u001a\u007f\u0010D\u001a\u00020\u00112\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0013\b\u0002\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u00107\u001a\u0002082\n\b\u0002\u0010%\u001a\u0004\u0018\u000109H\u0007¢\u0006\u0002\u0010:\u001a£\u0001\u0010E\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010F\u001a\u0002012\u0006\u0010G\u001a\u00020\u001c2\u0006\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u001c2\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u0006\u0010>\u001a\u00020?2\u0006\u0010J\u001a\u0002012\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020A2\u0011\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u0015H\u0003ø\u0001\u0000¢\u0006\u0004\bR\u0010S\u001aµ\u0001\u0010T\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u0006\u0010>\u001a\u00020?2\u0006\u0010O\u001a\u00020\u00012\u0011\u0010U\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u0006\u0010V\u001a\u00020?2\u0011\u00106\u001a\r\u0012\u0004\u0012\u00020\u00110\u001a¢\u0006\u0002\b\u00152\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\b\u0015¢\u0006\u0002\b\u00162\u0006\u0010!\u001a\u00020\"2\u0006\u00107\u001a\u0002082\u0006\u0010W\u001a\u00020\u00012\u0006\u0010X\u001a\u00020\u00012\b\u0010%\u001a\u0004\u0018\u000109H\u0003ø\u0001\u0000¢\u0006\u0004\bY\u0010Z\u001a+\u0010[\u001a\u00020/2\b\b\u0002\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u0002012\b\b\u0002\u00103\u001a\u000201H\u0007¢\u0006\u0002\u0010\\\u001a+\u0010]\u001a\u00020^2\b\b\u0002\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u0002012\b\b\u0002\u00103\u001a\u000201H\u0007¢\u0006\u0002\u0010_\u001a>\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020^2\u0006\u0010c\u001a\u0002012\u000e\u0010d\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010e2\u000e\u0010f\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010gH\u0082@¢\u0006\u0002\u0010h\u001a>\u0010i\u001a\u00020a2\u0006\u0010b\u001a\u00020/2\u0006\u0010c\u001a\u0002012\u000e\u0010d\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010e2\u000e\u0010f\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010gH\u0083@¢\u0006\u0002\u0010j\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0016\u0010\u0003\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u0004\u0010\u0005\"\u0010\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0007\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u000b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\f\u001a\u00020\rX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006k²\u0006\n\u0010l\u001a\u00020\u001cX\u008a\u0084\u0002"}, d2 = {"BottomAppBarHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "BottomAppBarVerticalPadding", "getBottomAppBarVerticalPadding", "()F", "FABHorizontalPadding", "FABVerticalPadding", "LargeTitleBottomPadding", "MediumTitleBottomPadding", "TopAppBarHorizontalPadding", "TopAppBarTitleInset", "TopTitleAlphaEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "getTopTitleAlphaEasing", "()Landroidx/compose/animation/core/CubicBezierEasing;", "BottomAppBar", "", "actions", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "floatingActionButton", "Lkotlin/Function0;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "BottomAppBar-Snr_uVM", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/runtime/Composer;II)V", "scrollBehavior", "Landroidx/compose/material3/BottomAppBarScrollBehavior;", "BottomAppBar-qhFBPw4", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/BottomAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "content", "BottomAppBar-1oL4kX8", "(Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomAppBar-e-3WI5M", "(Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/BottomAppBarScrollBehavior;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomAppBarState", "Landroidx/compose/material3/BottomAppBarState;", "initialHeightOffsetLimit", "", "initialHeightOffset", "initialContentOffset", "CenterAlignedTopAppBar", "title", "navigationIcon", "colors", "Landroidx/compose/material3/TopAppBarColors;", "Landroidx/compose/material3/TopAppBarScrollBehavior;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "LargeTopAppBar", "MediumTopAppBar", "SingleRowTopAppBar", "titleTextStyle", "Landroidx/compose/ui/text/TextStyle;", "centeredTitle", "", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;II)V", "SmallTopAppBar", "TopAppBar", "TopAppBarLayout", "heightPx", "navigationIconContentColor", "titleContentColor", "actionIconContentColor", "titleAlpha", "titleVerticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "titleHorizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "titleBottomPadding", "", "hideTitleSemantics", "TopAppBarLayout-kXwM9vE", "(Landroidx/compose/ui/Modifier;FJJJLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;FLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;IZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "TwoRowsTopAppBar", "smallTitle", "smallTitleTextStyle", "maxHeight", "pinnedHeight", "TwoRowsTopAppBar-tjU4iQQ", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;FLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/material3/TopAppBarColors;FFLandroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;III)V", "rememberBottomAppBarState", "(FFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/BottomAppBarState;", "rememberTopAppBarState", "Landroidx/compose/material3/TopAppBarState;", "(FFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarState;", "settleAppBar", "Landroidx/compose/ui/unit/Velocity;", "state", "velocity", "flingAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/material3/TopAppBarState;FLandroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "settleAppBarBottom", "(Landroidx/compose/material3/BottomAppBarState;FLandroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "material3_release", "appBarContainerColor"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class AppBarKt {
    private static final float BottomAppBarHorizontalPadding;
    private static final float BottomAppBarVerticalPadding;
    private static final float FABHorizontalPadding;
    private static final float FABVerticalPadding;
    private static final float LargeTitleBottomPadding;
    private static final float MediumTitleBottomPadding;
    private static final float TopAppBarHorizontalPadding;
    private static final float TopAppBarTitleInset;
    private static final CubicBezierEasing TopTitleAlphaEasing;

    /* JADX WARN: Removed duplicated region for block: B:102:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TopAppBar(final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function23;
        int i5;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32;
        WindowInsets windowInsets2;
        TopAppBarColors topAppBarColors2;
        int i6;
        TopAppBarScrollBehavior topAppBarScrollBehavior2;
        Modifier.Companion companion;
        int i7;
        TopAppBarScrollBehavior topAppBarScrollBehavior3;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33;
        WindowInsets windowInsets3;
        TopAppBarColors topAppBarColors3;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function34;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        final TopAppBarScrollBehavior topAppBarScrollBehavior4;
        final TopAppBarColors topAppBarColors4;
        int i8;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(1906353009);
        ComposerKt.sourceInformation(startRestartGroup, "C(TopAppBar)P(5,2,3!1,6)126@6292L12,127@6354L17,133@6544L10,130@6433L374:AppBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i10 = i2 & 2;
        if (i10 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                function23 = function22;
                i3 |= startRestartGroup.changedInstance(function23) ? Fields.RotationX : Fields.SpotShadowColor;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    function32 = function3;
                    i3 |= startRestartGroup.changedInstance(function32) ? Fields.CameraDistance : Fields.RotationZ;
                    if ((i & 24576) != 0) {
                        if ((i2 & 16) == 0) {
                            windowInsets2 = windowInsets;
                            if (startRestartGroup.changed(windowInsets2)) {
                                i9 = Fields.Clip;
                                i3 |= i9;
                            }
                        } else {
                            windowInsets2 = windowInsets;
                        }
                        i9 = Fields.Shape;
                        i3 |= i9;
                    } else {
                        windowInsets2 = windowInsets;
                    }
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            topAppBarColors2 = topAppBarColors;
                            if (startRestartGroup.changed(topAppBarColors2)) {
                                i8 = Fields.RenderEffect;
                                i3 |= i8;
                            }
                        } else {
                            topAppBarColors2 = topAppBarColors;
                        }
                        i8 = 65536;
                        i3 |= i8;
                    } else {
                        topAppBarColors2 = topAppBarColors;
                    }
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                    } else if ((1572864 & i) == 0) {
                        topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                        i3 |= startRestartGroup.changed(topAppBarScrollBehavior2) ? 1048576 : Fields.BlendMode;
                        if ((599187 & i3) == 599186 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                companion = i10 != 0 ? Modifier.INSTANCE : modifier2;
                                if (i4 != 0) {
                                    function23 = ComposableSingletons$AppBarKt.INSTANCE.m2393getLambda1$material3_release();
                                }
                                if (i5 != 0) {
                                    function32 = ComposableSingletons$AppBarKt.INSTANCE.m2397getLambda2$material3_release();
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                    windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets(startRestartGroup, 6);
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                    topAppBarColors2 = TopAppBarDefaults.INSTANCE.topAppBarColors(startRestartGroup, 6);
                                }
                                if (i6 != 0) {
                                    i7 = i3;
                                    topAppBarScrollBehavior3 = null;
                                    function33 = function32;
                                    windowInsets3 = windowInsets2;
                                    topAppBarColors3 = topAppBarColors2;
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1906353009, i7, -1, "androidx.compose.material3.TopAppBar (AppBar.kt:129)");
                                    }
                                    int i11 = ((i7 >> 3) & 14) | 3072 | ((i7 << 3) & 112);
                                    int i12 = i7 << 6;
                                    SingleRowTopAppBar(companion, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), TopAppBarSmallTokens.INSTANCE.getHeadlineFont()), false, function23, function33, windowInsets3, topAppBarColors3, topAppBarScrollBehavior3, startRestartGroup, i11 | (57344 & i12) | (458752 & i12) | (3670016 & i12) | (29360128 & i12) | (i12 & 234881024), 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    windowInsets2 = windowInsets3;
                                    function34 = function33;
                                    function24 = function23;
                                    topAppBarScrollBehavior4 = topAppBarScrollBehavior3;
                                    topAppBarColors4 = topAppBarColors3;
                                    modifier2 = companion;
                                } else {
                                    i7 = i3;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                }
                                i7 = i3;
                                companion = modifier2;
                            }
                            function33 = function32;
                            windowInsets3 = windowInsets2;
                            topAppBarColors3 = topAppBarColors2;
                            topAppBarScrollBehavior3 = topAppBarScrollBehavior2;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            int i112 = ((i7 >> 3) & 14) | 3072 | ((i7 << 3) & 112);
                            int i122 = i7 << 6;
                            SingleRowTopAppBar(companion, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), TopAppBarSmallTokens.INSTANCE.getHeadlineFont()), false, function23, function33, windowInsets3, topAppBarColors3, topAppBarScrollBehavior3, startRestartGroup, i112 | (57344 & i122) | (458752 & i122) | (3670016 & i122) | (29360128 & i122) | (i122 & 234881024), 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            windowInsets2 = windowInsets3;
                            function34 = function33;
                            function24 = function23;
                            topAppBarScrollBehavior4 = topAppBarScrollBehavior3;
                            topAppBarColors4 = topAppBarColors3;
                            modifier2 = companion;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            function24 = function23;
                            function34 = function32;
                            topAppBarColors4 = topAppBarColors2;
                            topAppBarScrollBehavior4 = topAppBarScrollBehavior2;
                        }
                        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            final Modifier modifier3 = modifier2;
                            final WindowInsets windowInsets4 = windowInsets2;
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$TopAppBar$1
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

                                public final void invoke(Composer composer2, int i13) {
                                    AppBarKt.TopAppBar(function2, modifier3, function24, function34, windowInsets4, topAppBarColors4, topAppBarScrollBehavior4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                    if ((599187 & i3) == 599186) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if ((i2 & 16) != 0) {
                    }
                    if ((i2 & 32) != 0) {
                    }
                    if (i6 != 0) {
                    }
                }
                function32 = function3;
                if ((i & 24576) != 0) {
                }
                if ((196608 & i) != 0) {
                }
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                if ((599187 & i3) == 599186) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i10 != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                if ((i2 & 32) != 0) {
                }
                if (i6 != 0) {
                }
            }
            function23 = function22;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            function32 = function3;
            if ((i & 24576) != 0) {
            }
            if ((196608 & i) != 0) {
            }
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            topAppBarScrollBehavior2 = topAppBarScrollBehavior;
            if ((599187 & i3) == 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i10 != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if (i6 != 0) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        function23 = function22;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        function32 = function3;
        if ((i & 24576) != 0) {
        }
        if ((196608 & i) != 0) {
        }
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        topAppBarScrollBehavior2 = topAppBarScrollBehavior;
        if ((599187 & i3) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i10 != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if (i6 != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x006d  */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Use TopAppBar instead.", replaceWith = @ReplaceWith(expression = "TopAppBar(title, modifier, navigationIcon, actions, windowInsets, colors, scrollBehavior)", imports = {}))
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SmallTopAppBar(final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function23;
        int i5;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32;
        WindowInsets windowInsets2;
        TopAppBarColors topAppBarColors2;
        int i6;
        TopAppBarScrollBehavior topAppBarScrollBehavior2;
        Modifier.Companion companion;
        int i7;
        TopAppBarScrollBehavior topAppBarScrollBehavior3;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33;
        WindowInsets windowInsets3;
        TopAppBarColors topAppBarColors3;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function34;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        final TopAppBarScrollBehavior topAppBarScrollBehavior4;
        final TopAppBarColors topAppBarColors4;
        int i8;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(-1967617284);
        ComposerKt.sourceInformation(startRestartGroup, "C(SmallTopAppBar)P(5,2,3!1,6)189@9271L12,190@9333L17,192@9408L89:AppBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i10 = i2 & 2;
        if (i10 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                function23 = function22;
                i3 |= startRestartGroup.changedInstance(function23) ? Fields.RotationX : Fields.SpotShadowColor;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    function32 = function3;
                    i3 |= startRestartGroup.changedInstance(function32) ? Fields.CameraDistance : Fields.RotationZ;
                    if ((i & 24576) != 0) {
                        if ((i2 & 16) == 0) {
                            windowInsets2 = windowInsets;
                            if (startRestartGroup.changed(windowInsets2)) {
                                i9 = Fields.Clip;
                                i3 |= i9;
                            }
                        } else {
                            windowInsets2 = windowInsets;
                        }
                        i9 = Fields.Shape;
                        i3 |= i9;
                    } else {
                        windowInsets2 = windowInsets;
                    }
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            topAppBarColors2 = topAppBarColors;
                            if (startRestartGroup.changed(topAppBarColors2)) {
                                i8 = Fields.RenderEffect;
                                i3 |= i8;
                            }
                        } else {
                            topAppBarColors2 = topAppBarColors;
                        }
                        i8 = 65536;
                        i3 |= i8;
                    } else {
                        topAppBarColors2 = topAppBarColors;
                    }
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                    } else if ((1572864 & i) == 0) {
                        topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                        i3 |= startRestartGroup.changed(topAppBarScrollBehavior2) ? 1048576 : Fields.BlendMode;
                        if ((599187 & i3) == 599186 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                companion = i10 != 0 ? Modifier.INSTANCE : modifier2;
                                if (i4 != 0) {
                                    function23 = ComposableSingletons$AppBarKt.INSTANCE.m2398getLambda3$material3_release();
                                }
                                if (i5 != 0) {
                                    function32 = ComposableSingletons$AppBarKt.INSTANCE.m2399getLambda4$material3_release();
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                    windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets(startRestartGroup, 6);
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                    topAppBarColors2 = TopAppBarDefaults.INSTANCE.topAppBarColors(startRestartGroup, 6);
                                }
                                if (i6 != 0) {
                                    i7 = i3;
                                    topAppBarScrollBehavior3 = null;
                                    function33 = function32;
                                    windowInsets3 = windowInsets2;
                                    topAppBarColors3 = topAppBarColors2;
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1967617284, i7, -1, "androidx.compose.material3.SmallTopAppBar (AppBar.kt:192)");
                                    }
                                    TopAppBar(function2, companion, function23, function33, windowInsets3, topAppBarColors3, topAppBarScrollBehavior3, startRestartGroup, (i7 & 14) | (i7 & 112) | (i7 & 896) | (i7 & 7168) | (57344 & i7) | (458752 & i7) | (i7 & 3670016), 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    windowInsets2 = windowInsets3;
                                    function34 = function33;
                                    function24 = function23;
                                    topAppBarScrollBehavior4 = topAppBarScrollBehavior3;
                                    topAppBarColors4 = topAppBarColors3;
                                    modifier2 = companion;
                                } else {
                                    i7 = i3;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                }
                                i7 = i3;
                                companion = modifier2;
                            }
                            function33 = function32;
                            windowInsets3 = windowInsets2;
                            topAppBarColors3 = topAppBarColors2;
                            topAppBarScrollBehavior3 = topAppBarScrollBehavior2;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            TopAppBar(function2, companion, function23, function33, windowInsets3, topAppBarColors3, topAppBarScrollBehavior3, startRestartGroup, (i7 & 14) | (i7 & 112) | (i7 & 896) | (i7 & 7168) | (57344 & i7) | (458752 & i7) | (i7 & 3670016), 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            windowInsets2 = windowInsets3;
                            function34 = function33;
                            function24 = function23;
                            topAppBarScrollBehavior4 = topAppBarScrollBehavior3;
                            topAppBarColors4 = topAppBarColors3;
                            modifier2 = companion;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            function24 = function23;
                            function34 = function32;
                            topAppBarColors4 = topAppBarColors2;
                            topAppBarScrollBehavior4 = topAppBarScrollBehavior2;
                        }
                        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            final Modifier modifier3 = modifier2;
                            final WindowInsets windowInsets4 = windowInsets2;
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$SmallTopAppBar$1
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

                                public final void invoke(Composer composer2, int i11) {
                                    AppBarKt.SmallTopAppBar(function2, modifier3, function24, function34, windowInsets4, topAppBarColors4, topAppBarScrollBehavior4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                    if ((599187 & i3) == 599186) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if ((i2 & 16) != 0) {
                    }
                    if ((i2 & 32) != 0) {
                    }
                    if (i6 != 0) {
                    }
                }
                function32 = function3;
                if ((i & 24576) != 0) {
                }
                if ((196608 & i) != 0) {
                }
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                if ((599187 & i3) == 599186) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i10 != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                if ((i2 & 32) != 0) {
                }
                if (i6 != 0) {
                }
            }
            function23 = function22;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            function32 = function3;
            if ((i & 24576) != 0) {
            }
            if ((196608 & i) != 0) {
            }
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            topAppBarScrollBehavior2 = topAppBarScrollBehavior;
            if ((599187 & i3) == 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i10 != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if (i6 != 0) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        function23 = function22;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        function32 = function3;
        if ((i & 24576) != 0) {
        }
        if ((196608 & i) != 0) {
        }
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        topAppBarScrollBehavior2 = topAppBarScrollBehavior;
        if ((599187 & i3) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i10 != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if (i6 != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void CenterAlignedTopAppBar(final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function23;
        int i5;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32;
        WindowInsets windowInsets2;
        TopAppBarColors topAppBarColors2;
        int i6;
        TopAppBarScrollBehavior topAppBarScrollBehavior2;
        Modifier.Companion companion;
        int i7;
        TopAppBarScrollBehavior topAppBarScrollBehavior3;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33;
        WindowInsets windowInsets3;
        TopAppBarColors topAppBarColors3;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function34;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        final TopAppBarScrollBehavior topAppBarScrollBehavior4;
        final TopAppBarColors topAppBarColors4;
        int i8;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(-2139286460);
        ComposerKt.sourceInformation(startRestartGroup, "C(CenterAlignedTopAppBar)P(5,2,3!1,6)230@11690L12,231@11752L30,238@11963L10,234@11844L381:AppBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i10 = i2 & 2;
        if (i10 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                function23 = function22;
                i3 |= startRestartGroup.changedInstance(function23) ? Fields.RotationX : Fields.SpotShadowColor;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    function32 = function3;
                    i3 |= startRestartGroup.changedInstance(function32) ? Fields.CameraDistance : Fields.RotationZ;
                    if ((i & 24576) != 0) {
                        if ((i2 & 16) == 0) {
                            windowInsets2 = windowInsets;
                            if (startRestartGroup.changed(windowInsets2)) {
                                i9 = Fields.Clip;
                                i3 |= i9;
                            }
                        } else {
                            windowInsets2 = windowInsets;
                        }
                        i9 = Fields.Shape;
                        i3 |= i9;
                    } else {
                        windowInsets2 = windowInsets;
                    }
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            topAppBarColors2 = topAppBarColors;
                            if (startRestartGroup.changed(topAppBarColors2)) {
                                i8 = Fields.RenderEffect;
                                i3 |= i8;
                            }
                        } else {
                            topAppBarColors2 = topAppBarColors;
                        }
                        i8 = 65536;
                        i3 |= i8;
                    } else {
                        topAppBarColors2 = topAppBarColors;
                    }
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                    } else if ((1572864 & i) == 0) {
                        topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                        i3 |= startRestartGroup.changed(topAppBarScrollBehavior2) ? 1048576 : Fields.BlendMode;
                        if ((599187 & i3) == 599186 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                companion = i10 != 0 ? Modifier.INSTANCE : modifier2;
                                if (i4 != 0) {
                                    function23 = ComposableSingletons$AppBarKt.INSTANCE.m2400getLambda5$material3_release();
                                }
                                if (i5 != 0) {
                                    function32 = ComposableSingletons$AppBarKt.INSTANCE.m2401getLambda6$material3_release();
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                    windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets(startRestartGroup, 6);
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                    topAppBarColors2 = TopAppBarDefaults.INSTANCE.centerAlignedTopAppBarColors(startRestartGroup, 6);
                                }
                                if (i6 != 0) {
                                    i7 = i3;
                                    topAppBarScrollBehavior3 = null;
                                    function33 = function32;
                                    windowInsets3 = windowInsets2;
                                    topAppBarColors3 = topAppBarColors2;
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-2139286460, i7, -1, "androidx.compose.material3.CenterAlignedTopAppBar (AppBar.kt:233)");
                                    }
                                    int i11 = ((i7 >> 3) & 14) | 3072 | ((i7 << 3) & 112);
                                    int i12 = i7 << 6;
                                    SingleRowTopAppBar(companion, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), TopAppBarSmallTokens.INSTANCE.getHeadlineFont()), true, function23, function33, windowInsets3, topAppBarColors3, topAppBarScrollBehavior3, startRestartGroup, i11 | (57344 & i12) | (458752 & i12) | (3670016 & i12) | (29360128 & i12) | (i12 & 234881024), 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    windowInsets2 = windowInsets3;
                                    function34 = function33;
                                    function24 = function23;
                                    topAppBarScrollBehavior4 = topAppBarScrollBehavior3;
                                    topAppBarColors4 = topAppBarColors3;
                                    modifier2 = companion;
                                } else {
                                    i7 = i3;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                }
                                i7 = i3;
                                companion = modifier2;
                            }
                            function33 = function32;
                            windowInsets3 = windowInsets2;
                            topAppBarColors3 = topAppBarColors2;
                            topAppBarScrollBehavior3 = topAppBarScrollBehavior2;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            int i112 = ((i7 >> 3) & 14) | 3072 | ((i7 << 3) & 112);
                            int i122 = i7 << 6;
                            SingleRowTopAppBar(companion, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), TopAppBarSmallTokens.INSTANCE.getHeadlineFont()), true, function23, function33, windowInsets3, topAppBarColors3, topAppBarScrollBehavior3, startRestartGroup, i112 | (57344 & i122) | (458752 & i122) | (3670016 & i122) | (29360128 & i122) | (i122 & 234881024), 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            windowInsets2 = windowInsets3;
                            function34 = function33;
                            function24 = function23;
                            topAppBarScrollBehavior4 = topAppBarScrollBehavior3;
                            topAppBarColors4 = topAppBarColors3;
                            modifier2 = companion;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            function24 = function23;
                            function34 = function32;
                            topAppBarColors4 = topAppBarColors2;
                            topAppBarScrollBehavior4 = topAppBarScrollBehavior2;
                        }
                        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            final Modifier modifier3 = modifier2;
                            final WindowInsets windowInsets4 = windowInsets2;
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$CenterAlignedTopAppBar$1
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

                                public final void invoke(Composer composer2, int i13) {
                                    AppBarKt.CenterAlignedTopAppBar(function2, modifier3, function24, function34, windowInsets4, topAppBarColors4, topAppBarScrollBehavior4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                    if ((599187 & i3) == 599186) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if ((i2 & 16) != 0) {
                    }
                    if ((i2 & 32) != 0) {
                    }
                    if (i6 != 0) {
                    }
                }
                function32 = function3;
                if ((i & 24576) != 0) {
                }
                if ((196608 & i) != 0) {
                }
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                if ((599187 & i3) == 599186) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i10 != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                if ((i2 & 32) != 0) {
                }
                if (i6 != 0) {
                }
            }
            function23 = function22;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            function32 = function3;
            if ((i & 24576) != 0) {
            }
            if ((196608 & i) != 0) {
            }
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            topAppBarScrollBehavior2 = topAppBarScrollBehavior;
            if ((599187 & i3) == 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i10 != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if (i6 != 0) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        function23 = function22;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        function32 = function3;
        if ((i & 24576) != 0) {
        }
        if ((196608 & i) != 0) {
        }
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        topAppBarScrollBehavior2 = topAppBarScrollBehavior;
        if ((599187 & i3) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i10 != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if (i6 != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void MediumTopAppBar(final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function23;
        int i5;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32;
        WindowInsets windowInsets2;
        TopAppBarColors topAppBarColors2;
        int i6;
        TopAppBarScrollBehavior topAppBarScrollBehavior2;
        Modifier.Companion companion;
        int i7;
        TopAppBarScrollBehavior topAppBarScrollBehavior3;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33;
        WindowInsets windowInsets3;
        TopAppBarColors topAppBarColors3;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function34;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        final TopAppBarScrollBehavior topAppBarScrollBehavior4;
        final TopAppBarColors topAppBarColors4;
        int i8;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(1805417862);
        ComposerKt.sourceInformation(startRestartGroup, "C(MediumTopAppBar)P(5,2,3!1,6)285@14543L12,286@14605L23,292@14799L10,293@14901L10,289@14690L646:AppBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i10 = i2 & 2;
        if (i10 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                function23 = function22;
                i3 |= startRestartGroup.changedInstance(function23) ? Fields.RotationX : Fields.SpotShadowColor;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    function32 = function3;
                    i3 |= startRestartGroup.changedInstance(function32) ? Fields.CameraDistance : Fields.RotationZ;
                    if ((i & 24576) != 0) {
                        if ((i2 & 16) == 0) {
                            windowInsets2 = windowInsets;
                            if (startRestartGroup.changed(windowInsets2)) {
                                i9 = Fields.Clip;
                                i3 |= i9;
                            }
                        } else {
                            windowInsets2 = windowInsets;
                        }
                        i9 = Fields.Shape;
                        i3 |= i9;
                    } else {
                        windowInsets2 = windowInsets;
                    }
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            topAppBarColors2 = topAppBarColors;
                            if (startRestartGroup.changed(topAppBarColors2)) {
                                i8 = Fields.RenderEffect;
                                i3 |= i8;
                            }
                        } else {
                            topAppBarColors2 = topAppBarColors;
                        }
                        i8 = 65536;
                        i3 |= i8;
                    } else {
                        topAppBarColors2 = topAppBarColors;
                    }
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                    } else if ((1572864 & i) == 0) {
                        topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                        i3 |= startRestartGroup.changed(topAppBarScrollBehavior2) ? 1048576 : Fields.BlendMode;
                        if ((599187 & i3) == 599186 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                companion = i10 != 0 ? Modifier.INSTANCE : modifier2;
                                if (i4 != 0) {
                                    function23 = ComposableSingletons$AppBarKt.INSTANCE.m2402getLambda7$material3_release();
                                }
                                if (i5 != 0) {
                                    function32 = ComposableSingletons$AppBarKt.INSTANCE.m2403getLambda8$material3_release();
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                    windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets(startRestartGroup, 6);
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                    topAppBarColors2 = TopAppBarDefaults.INSTANCE.mediumTopAppBarColors(startRestartGroup, 6);
                                }
                                if (i6 != 0) {
                                    i7 = i3;
                                    topAppBarScrollBehavior3 = null;
                                    function33 = function32;
                                    windowInsets3 = windowInsets2;
                                    topAppBarColors3 = topAppBarColors2;
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1805417862, i7, -1, "androidx.compose.material3.MediumTopAppBar (AppBar.kt:288)");
                                    }
                                    int i11 = i7 << 12;
                                    m2204TwoRowsTopAppBartjU4iQQ(companion, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), TopAppBarMediumTokens.INSTANCE.getHeadlineFont()), MediumTitleBottomPadding, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), TopAppBarSmallTokens.INSTANCE.getHeadlineFont()), function23, function33, windowInsets3, topAppBarColors3, TopAppBarMediumTokens.INSTANCE.m3953getContainerHeightD9Ej5fM(), TopAppBarSmallTokens.INSTANCE.m3963getContainerHeightD9Ej5fM(), topAppBarScrollBehavior3, startRestartGroup, ((i7 >> 3) & 14) | 3072 | ((i7 << 3) & 112) | (57344 & i11) | (3670016 & i11) | (29360128 & i11) | (234881024 & i11) | (i11 & 1879048192), ((i7 >> 12) & 896) | 54, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    windowInsets2 = windowInsets3;
                                    function34 = function33;
                                    function24 = function23;
                                    topAppBarScrollBehavior4 = topAppBarScrollBehavior3;
                                    topAppBarColors4 = topAppBarColors3;
                                    modifier2 = companion;
                                } else {
                                    i7 = i3;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                }
                                i7 = i3;
                                companion = modifier2;
                            }
                            function33 = function32;
                            windowInsets3 = windowInsets2;
                            topAppBarColors3 = topAppBarColors2;
                            topAppBarScrollBehavior3 = topAppBarScrollBehavior2;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            int i112 = i7 << 12;
                            m2204TwoRowsTopAppBartjU4iQQ(companion, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), TopAppBarMediumTokens.INSTANCE.getHeadlineFont()), MediumTitleBottomPadding, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), TopAppBarSmallTokens.INSTANCE.getHeadlineFont()), function23, function33, windowInsets3, topAppBarColors3, TopAppBarMediumTokens.INSTANCE.m3953getContainerHeightD9Ej5fM(), TopAppBarSmallTokens.INSTANCE.m3963getContainerHeightD9Ej5fM(), topAppBarScrollBehavior3, startRestartGroup, ((i7 >> 3) & 14) | 3072 | ((i7 << 3) & 112) | (57344 & i112) | (3670016 & i112) | (29360128 & i112) | (234881024 & i112) | (i112 & 1879048192), ((i7 >> 12) & 896) | 54, 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            windowInsets2 = windowInsets3;
                            function34 = function33;
                            function24 = function23;
                            topAppBarScrollBehavior4 = topAppBarScrollBehavior3;
                            topAppBarColors4 = topAppBarColors3;
                            modifier2 = companion;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            function24 = function23;
                            function34 = function32;
                            topAppBarColors4 = topAppBarColors2;
                            topAppBarScrollBehavior4 = topAppBarScrollBehavior2;
                        }
                        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            final Modifier modifier3 = modifier2;
                            final WindowInsets windowInsets4 = windowInsets2;
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$MediumTopAppBar$1
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
                                    AppBarKt.MediumTopAppBar(function2, modifier3, function24, function34, windowInsets4, topAppBarColors4, topAppBarScrollBehavior4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                    if ((599187 & i3) == 599186) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if ((i2 & 16) != 0) {
                    }
                    if ((i2 & 32) != 0) {
                    }
                    if (i6 != 0) {
                    }
                }
                function32 = function3;
                if ((i & 24576) != 0) {
                }
                if ((196608 & i) != 0) {
                }
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                if ((599187 & i3) == 599186) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i10 != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                if ((i2 & 32) != 0) {
                }
                if (i6 != 0) {
                }
            }
            function23 = function22;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            function32 = function3;
            if ((i & 24576) != 0) {
            }
            if ((196608 & i) != 0) {
            }
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            topAppBarScrollBehavior2 = topAppBarScrollBehavior;
            if ((599187 & i3) == 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i10 != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if (i6 != 0) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        function23 = function22;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        function32 = function3;
        if ((i & 24576) != 0) {
        }
        if ((196608 & i) != 0) {
        }
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        topAppBarScrollBehavior2 = topAppBarScrollBehavior;
        if ((599187 & i3) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i10 != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if (i6 != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LargeTopAppBar(final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, WindowInsets windowInsets, TopAppBarColors topAppBarColors, TopAppBarScrollBehavior topAppBarScrollBehavior, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function23;
        int i5;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32;
        WindowInsets windowInsets2;
        TopAppBarColors topAppBarColors2;
        int i6;
        TopAppBarScrollBehavior topAppBarScrollBehavior2;
        Modifier.Companion companion;
        int i7;
        TopAppBarScrollBehavior topAppBarScrollBehavior3;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33;
        WindowInsets windowInsets3;
        TopAppBarColors topAppBarColors3;
        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function34;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        final TopAppBarScrollBehavior topAppBarScrollBehavior4;
        final TopAppBarColors topAppBarColors4;
        int i8;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(-474540752);
        ComposerKt.sourceInformation(startRestartGroup, "C(LargeTopAppBar)P(5,2,3!1,6)343@17646L12,344@17708L22,349@17872L10,350@17973L10,347@17792L643:AppBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i10 = i2 & 2;
        if (i10 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                function23 = function22;
                i3 |= startRestartGroup.changedInstance(function23) ? Fields.RotationX : Fields.SpotShadowColor;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    function32 = function3;
                    i3 |= startRestartGroup.changedInstance(function32) ? Fields.CameraDistance : Fields.RotationZ;
                    if ((i & 24576) != 0) {
                        if ((i2 & 16) == 0) {
                            windowInsets2 = windowInsets;
                            if (startRestartGroup.changed(windowInsets2)) {
                                i9 = Fields.Clip;
                                i3 |= i9;
                            }
                        } else {
                            windowInsets2 = windowInsets;
                        }
                        i9 = Fields.Shape;
                        i3 |= i9;
                    } else {
                        windowInsets2 = windowInsets;
                    }
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            topAppBarColors2 = topAppBarColors;
                            if (startRestartGroup.changed(topAppBarColors2)) {
                                i8 = Fields.RenderEffect;
                                i3 |= i8;
                            }
                        } else {
                            topAppBarColors2 = topAppBarColors;
                        }
                        i8 = 65536;
                        i3 |= i8;
                    } else {
                        topAppBarColors2 = topAppBarColors;
                    }
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                    } else if ((1572864 & i) == 0) {
                        topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                        i3 |= startRestartGroup.changed(topAppBarScrollBehavior2) ? 1048576 : Fields.BlendMode;
                        if ((599187 & i3) == 599186 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                companion = i10 != 0 ? Modifier.INSTANCE : modifier2;
                                if (i4 != 0) {
                                    function23 = ComposableSingletons$AppBarKt.INSTANCE.m2404getLambda9$material3_release();
                                }
                                if (i5 != 0) {
                                    function32 = ComposableSingletons$AppBarKt.INSTANCE.m2394getLambda10$material3_release();
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                    windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets(startRestartGroup, 6);
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                    topAppBarColors2 = TopAppBarDefaults.INSTANCE.largeTopAppBarColors(startRestartGroup, 6);
                                }
                                if (i6 != 0) {
                                    i7 = i3;
                                    topAppBarScrollBehavior3 = null;
                                    function33 = function32;
                                    windowInsets3 = windowInsets2;
                                    topAppBarColors3 = topAppBarColors2;
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-474540752, i7, -1, "androidx.compose.material3.LargeTopAppBar (AppBar.kt:346)");
                                    }
                                    int i11 = i7 << 12;
                                    m2204TwoRowsTopAppBartjU4iQQ(companion, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), TopAppBarLargeTokens.INSTANCE.getHeadlineFont()), LargeTitleBottomPadding, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), TopAppBarSmallTokens.INSTANCE.getHeadlineFont()), function23, function33, windowInsets3, topAppBarColors3, TopAppBarLargeTokens.INSTANCE.m3949getContainerHeightD9Ej5fM(), TopAppBarSmallTokens.INSTANCE.m3963getContainerHeightD9Ej5fM(), topAppBarScrollBehavior3, startRestartGroup, ((i7 >> 3) & 14) | 3072 | ((i7 << 3) & 112) | (57344 & i11) | (3670016 & i11) | (29360128 & i11) | (234881024 & i11) | (i11 & 1879048192), ((i7 >> 12) & 896) | 54, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    windowInsets2 = windowInsets3;
                                    function34 = function33;
                                    function24 = function23;
                                    topAppBarScrollBehavior4 = topAppBarScrollBehavior3;
                                    topAppBarColors4 = topAppBarColors3;
                                    modifier2 = companion;
                                } else {
                                    i7 = i3;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                }
                                i7 = i3;
                                companion = modifier2;
                            }
                            function33 = function32;
                            windowInsets3 = windowInsets2;
                            topAppBarColors3 = topAppBarColors2;
                            topAppBarScrollBehavior3 = topAppBarScrollBehavior2;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            int i112 = i7 << 12;
                            m2204TwoRowsTopAppBartjU4iQQ(companion, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), TopAppBarLargeTokens.INSTANCE.getHeadlineFont()), LargeTitleBottomPadding, function2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), TopAppBarSmallTokens.INSTANCE.getHeadlineFont()), function23, function33, windowInsets3, topAppBarColors3, TopAppBarLargeTokens.INSTANCE.m3949getContainerHeightD9Ej5fM(), TopAppBarSmallTokens.INSTANCE.m3963getContainerHeightD9Ej5fM(), topAppBarScrollBehavior3, startRestartGroup, ((i7 >> 3) & 14) | 3072 | ((i7 << 3) & 112) | (57344 & i112) | (3670016 & i112) | (29360128 & i112) | (234881024 & i112) | (i112 & 1879048192), ((i7 >> 12) & 896) | 54, 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            windowInsets2 = windowInsets3;
                            function34 = function33;
                            function24 = function23;
                            topAppBarScrollBehavior4 = topAppBarScrollBehavior3;
                            topAppBarColors4 = topAppBarColors3;
                            modifier2 = companion;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            function24 = function23;
                            function34 = function32;
                            topAppBarColors4 = topAppBarColors2;
                            topAppBarScrollBehavior4 = topAppBarScrollBehavior2;
                        }
                        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            final Modifier modifier3 = modifier2;
                            final WindowInsets windowInsets4 = windowInsets2;
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$LargeTopAppBar$1
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
                                    AppBarKt.LargeTopAppBar(function2, modifier3, function24, function34, windowInsets4, topAppBarColors4, topAppBarScrollBehavior4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                    if ((599187 & i3) == 599186) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if ((i2 & 16) != 0) {
                    }
                    if ((i2 & 32) != 0) {
                    }
                    if (i6 != 0) {
                    }
                }
                function32 = function3;
                if ((i & 24576) != 0) {
                }
                if ((196608 & i) != 0) {
                }
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                if ((599187 & i3) == 599186) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i10 != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                if ((i2 & 32) != 0) {
                }
                if (i6 != 0) {
                }
            }
            function23 = function22;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            function32 = function3;
            if ((i & 24576) != 0) {
            }
            if ((196608 & i) != 0) {
            }
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            topAppBarScrollBehavior2 = topAppBarScrollBehavior;
            if ((599187 & i3) == 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i10 != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if (i6 != 0) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        function23 = function22;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        function32 = function3;
        if ((i & 24576) != 0) {
        }
        if ((196608 & i) != 0) {
        }
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        topAppBarScrollBehavior2 = topAppBarScrollBehavior;
        if ((599187 & i3) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i10 != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if (i6 != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00c4  */
    /* renamed from: BottomAppBar-Snr_uVM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2200BottomAppBarSnr_uVM(final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, long j, long j2, float f, PaddingValues paddingValues, WindowInsets windowInsets, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function22;
        long j3;
        long j4;
        int i5;
        float f2;
        int i6;
        WindowInsets windowInsets2;
        PaddingValues paddingValues2;
        int i7;
        long j5;
        final WindowInsets windowInsets3;
        final float f3;
        final PaddingValues paddingValues3;
        final Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        final long j6;
        final long j7;
        int i8;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(2141738945);
        ComposerKt.sourceInformation(startRestartGroup, "C(BottomAppBar)P(!1,5,4,1:c#ui.graphics.Color,2:c#ui.graphics.Color,6:c#ui.unit.Dp)400@20438L14,401@20480L31,404@20706L12,405@20724L315:AppBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(function3) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i10 = i2 & 2;
        if (i10 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                function22 = function2;
                i3 |= startRestartGroup.changedInstance(function22) ? Fields.RotationX : Fields.SpotShadowColor;
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        j3 = j;
                        if (startRestartGroup.changed(j3)) {
                            i9 = Fields.CameraDistance;
                            i3 |= i9;
                        }
                    } else {
                        j3 = j;
                    }
                    i9 = Fields.RotationZ;
                    i3 |= i9;
                } else {
                    j3 = j;
                }
                if ((i & 24576) == 0) {
                    j4 = j2;
                    i3 |= ((i2 & 16) == 0 && startRestartGroup.changed(j4)) ? Fields.Clip : Fields.Shape;
                } else {
                    j4 = j2;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= 196608;
                } else if ((196608 & i) == 0) {
                    f2 = f;
                    i3 |= startRestartGroup.changed(f2) ? Fields.RenderEffect : 65536;
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        i3 |= startRestartGroup.changed(paddingValues) ? 1048576 : Fields.BlendMode;
                    }
                    if ((i & 12582912) == 0) {
                        if ((i2 & Fields.SpotShadowColor) == 0 && startRestartGroup.changed(windowInsets)) {
                            i8 = 8388608;
                            i3 |= i8;
                        }
                        i8 = 4194304;
                        i3 |= i8;
                    }
                    if ((i3 & 4793491) == 4793490 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            if (i10 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function22 = null;
                            }
                            if ((i2 & 8) != 0) {
                                j3 = BottomAppBarDefaults.INSTANCE.getContainerColor(startRestartGroup, 6);
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                j4 = ColorSchemeKt.m2381contentColorForek8zF_U(j3, startRestartGroup, (i3 >> 9) & 14);
                                i3 &= -57345;
                            }
                            if (i5 != 0) {
                                f2 = BottomAppBarDefaults.INSTANCE.m2223getContainerElevationD9Ej5fM();
                            }
                            PaddingValues contentPadding = i6 == 0 ? BottomAppBarDefaults.INSTANCE.getContentPadding() : paddingValues;
                            if ((i2 & Fields.SpotShadowColor) == 0) {
                                i7 = i3 & (-29360129);
                                windowInsets2 = BottomAppBarDefaults.INSTANCE.getWindowInsets(startRestartGroup, 6);
                                j5 = j4;
                                paddingValues2 = contentPadding;
                                float f4 = f2;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2141738945, i7, -1, "androidx.compose.material3.BottomAppBar (AppBar.kt:405)");
                                }
                                m2202BottomAppBarqhFBPw4(function3, modifier2, function22, j3, j5, f4, paddingValues2, windowInsets2, null, startRestartGroup, (i7 & 14) | 100663296 | (i7 & 112) | (i7 & 896) | (i7 & 7168) | (57344 & i7) | (458752 & i7) | (3670016 & i7) | (i7 & 29360128), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                windowInsets3 = windowInsets2;
                                long j8 = j3;
                                f3 = f4;
                                paddingValues3 = paddingValues2;
                                long j9 = j5;
                                modifier3 = modifier2;
                                function23 = function22;
                                j6 = j8;
                                j7 = j9;
                            } else {
                                windowInsets2 = windowInsets;
                                paddingValues2 = contentPadding;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            if ((i2 & Fields.SpotShadowColor) != 0) {
                                i3 &= -29360129;
                            }
                            paddingValues2 = paddingValues;
                            windowInsets2 = windowInsets;
                        }
                        i7 = i3;
                        j5 = j4;
                        float f42 = f2;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        m2202BottomAppBarqhFBPw4(function3, modifier2, function22, j3, j5, f42, paddingValues2, windowInsets2, null, startRestartGroup, (i7 & 14) | 100663296 | (i7 & 112) | (i7 & 896) | (i7 & 7168) | (57344 & i7) | (458752 & i7) | (3670016 & i7) | (i7 & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        windowInsets3 = windowInsets2;
                        long j82 = j3;
                        f3 = f42;
                        paddingValues3 = paddingValues2;
                        long j92 = j5;
                        modifier3 = modifier2;
                        function23 = function22;
                        j6 = j82;
                        j7 = j92;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        windowInsets3 = windowInsets;
                        modifier3 = modifier2;
                        function23 = function22;
                        j6 = j3;
                        j7 = j4;
                        f3 = f2;
                        paddingValues3 = paddingValues;
                    }
                    ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$1
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

                            public final void invoke(Composer composer2, int i11) {
                                AppBarKt.m2200BottomAppBarSnr_uVM(function3, modifier3, function23, j6, j7, f3, paddingValues3, windowInsets3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                f2 = f;
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                if ((i & 12582912) == 0) {
                }
                if ((i3 & 4793491) == 4793490) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i10 != 0) {
                }
                if (i4 != 0) {
                }
                if ((i2 & 8) != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 == 0) {
                }
                if ((i2 & Fields.SpotShadowColor) == 0) {
                }
            }
            function22 = function2;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            f2 = f;
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            if ((i & 12582912) == 0) {
            }
            if ((i3 & 4793491) == 4793490) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i10 != 0) {
            }
            if (i4 != 0) {
            }
            if ((i2 & 8) != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 == 0) {
            }
            if ((i2 & Fields.SpotShadowColor) == 0) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        function22 = function2;
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        f2 = f;
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        if ((i & 12582912) == 0) {
        }
        if ((i3 & 4793491) == 4793490) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i10 != 0) {
        }
        if (i4 != 0) {
        }
        if ((i2 & 8) != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 == 0) {
        }
        if ((i2 & Fields.SpotShadowColor) == 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01b6  */
    /* renamed from: BottomAppBar-qhFBPw4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2202BottomAppBarqhFBPw4(final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, long j, long j2, float f, PaddingValues paddingValues, WindowInsets windowInsets, BottomAppBarScrollBehavior bottomAppBarScrollBehavior, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        long j3;
        long j4;
        int i5;
        float f2;
        int i6;
        int i7;
        Modifier.Companion companion;
        final Function2<? super Composer, ? super Integer, Unit> function22;
        WindowInsets windowInsets2;
        BottomAppBarScrollBehavior bottomAppBarScrollBehavior2;
        float f3;
        int i8;
        PaddingValues paddingValues2;
        PaddingValues paddingValues3;
        WindowInsets windowInsets3;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        final long j5;
        ScopeUpdateScope endRestartGroup;
        int i9;
        int i10;
        int i11;
        Composer startRestartGroup = composer.startRestartGroup(-1044837119);
        ComposerKt.sourceInformation(startRestartGroup, "C(BottomAppBar)P(!1,5,4,1:c#ui.graphics.Color,2:c#ui.graphics.Color,7:c#ui.unit.Dp!1,8)462@23624L14,463@23666L31,466@23892L12,468@23966L804:AppBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(function3) ? 4 : 2) | i;
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
                i3 |= startRestartGroup.changedInstance(function2) ? Fields.RotationX : Fields.SpotShadowColor;
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        j3 = j;
                        if (startRestartGroup.changed(j3)) {
                            i11 = Fields.CameraDistance;
                            i3 |= i11;
                        }
                    } else {
                        j3 = j;
                    }
                    i11 = Fields.RotationZ;
                    i3 |= i11;
                } else {
                    j3 = j;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        j4 = j2;
                        if (startRestartGroup.changed(j4)) {
                            i10 = Fields.Clip;
                            i3 |= i10;
                        }
                    } else {
                        j4 = j2;
                    }
                    i10 = Fields.Shape;
                    i3 |= i10;
                } else {
                    j4 = j2;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= 196608;
                } else if ((196608 & i) == 0) {
                    f2 = f;
                    i3 |= startRestartGroup.changed(f2) ? Fields.RenderEffect : 65536;
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        i3 |= startRestartGroup.changed(paddingValues) ? 1048576 : Fields.BlendMode;
                    }
                    if ((i & 12582912) == 0) {
                        if ((i2 & Fields.SpotShadowColor) == 0 && startRestartGroup.changed(windowInsets)) {
                            i9 = 8388608;
                            i3 |= i9;
                        }
                        i9 = 4194304;
                        i3 |= i9;
                    }
                    i7 = i2 & Fields.RotationX;
                    if (i7 == 0) {
                        i3 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        i3 |= startRestartGroup.changed(bottomAppBarScrollBehavior) ? 67108864 : 33554432;
                    }
                    if ((i3 & 38347923) == 38347922 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            companion = i12 == 0 ? Modifier.INSTANCE : modifier;
                            function22 = i4 == 0 ? null : function2;
                            if ((i2 & 8) != 0) {
                                j3 = BottomAppBarDefaults.INSTANCE.getContainerColor(startRestartGroup, 6);
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                j4 = ColorSchemeKt.m2381contentColorForek8zF_U(j3, startRestartGroup, (i3 >> 9) & 14);
                                i3 &= -57345;
                            }
                            float m2223getContainerElevationD9Ej5fM = i5 == 0 ? BottomAppBarDefaults.INSTANCE.m2223getContainerElevationD9Ej5fM() : f2;
                            PaddingValues contentPadding = i6 == 0 ? BottomAppBarDefaults.INSTANCE.getContentPadding() : paddingValues;
                            if ((i2 & Fields.SpotShadowColor) == 0) {
                                windowInsets2 = BottomAppBarDefaults.INSTANCE.getWindowInsets(startRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                windowInsets2 = windowInsets;
                            }
                            if (i7 == 0) {
                                f3 = m2223getContainerElevationD9Ej5fM;
                                bottomAppBarScrollBehavior2 = null;
                            } else {
                                bottomAppBarScrollBehavior2 = bottomAppBarScrollBehavior;
                                f3 = m2223getContainerElevationD9Ej5fM;
                            }
                            i8 = i3;
                            paddingValues2 = contentPadding;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            if ((i2 & Fields.SpotShadowColor) != 0) {
                                i3 &= -29360129;
                            }
                            companion = modifier;
                            function22 = function2;
                            windowInsets2 = windowInsets;
                            bottomAppBarScrollBehavior2 = bottomAppBarScrollBehavior;
                            i8 = i3;
                            f3 = f2;
                            paddingValues2 = paddingValues;
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1044837119, i8, -1, "androidx.compose.material3.BottomAppBar (AppBar.kt:468)");
                        }
                        int i13 = i8 >> 6;
                        m2201BottomAppBare3WI5M(companion, j3, j4, f3, paddingValues2, windowInsets2, bottomAppBarScrollBehavior2, ComposableLambdaKt.composableLambda(startRestartGroup, 1566394874, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$2
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                invoke((RowScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(RowScope rowScope, Composer composer2, int i14) {
                                int i15;
                                float f4;
                                float f5;
                                ComposerKt.sourceInformation(composer2, "C477@24226L184,484@24459L303:AppBar.kt#uh7d8r");
                                if ((i14 & 6) == 0) {
                                    i15 = i14 | (composer2.changed(rowScope) ? 4 : 2);
                                } else {
                                    i15 = i14;
                                }
                                if ((i15 & 19) != 18 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1566394874, i15, -1, "androidx.compose.material3.BottomAppBar.<anonymous> (AppBar.kt:477)");
                                    }
                                    Modifier weight$default = RowScope.weight$default(rowScope, Modifier.INSTANCE, 1.0f, false, 2, null);
                                    Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                    Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                                    composer2.startReplaceableGroup(693286680);
                                    ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer2, 54);
                                    composer2.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                    Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(weight$default);
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
                                    Updater.m4116setimpl(m4109constructorimpl, rowMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                    Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                    Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                    if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer2)), composer2, 0);
                                    composer2.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer2, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                    function32.invoke(RowScopeInstance.INSTANCE, composer2, 6);
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    composer2.endReplaceableGroup();
                                    composer2.endNode();
                                    composer2.endReplaceableGroup();
                                    composer2.endReplaceableGroup();
                                    if (function22 != null) {
                                        Modifier fillMaxHeight$default = SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null);
                                        f4 = AppBarKt.FABVerticalPadding;
                                        f5 = AppBarKt.FABHorizontalPadding;
                                        Modifier m1068paddingqDBjuR0$default = PaddingKt.m1068paddingqDBjuR0$default(fillMaxHeight$default, 0.0f, f4, f5, 0.0f, 9, null);
                                        Alignment topStart = Alignment.INSTANCE.getTopStart();
                                        Function2<Composer, Integer, Unit> function24 = function22;
                                        composer2.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(topStart, false, composer2, 6);
                                        composer2.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                        CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                                        Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m1068paddingqDBjuR0$default);
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
                                        ComposerKt.sourceInformationMarkerStart(composer2, 1859776956, "C493@24730L22:AppBar.kt#uh7d8r");
                                        function24.invoke(composer2, 0);
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        composer2.endReplaceableGroup();
                                        composer2.endNode();
                                        composer2.endReplaceableGroup();
                                        composer2.endReplaceableGroup();
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }), startRestartGroup, ((i8 >> 3) & 14) | 12582912 | (i13 & 112) | (i13 & 896) | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (i13 & 3670016), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        f2 = f3;
                        long j6 = j4;
                        paddingValues3 = paddingValues2;
                        windowInsets3 = windowInsets2;
                        function23 = function22;
                        j5 = j6;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        companion = modifier;
                        function23 = function2;
                        bottomAppBarScrollBehavior2 = bottomAppBarScrollBehavior;
                        j5 = j4;
                        paddingValues3 = paddingValues;
                        windowInsets3 = windowInsets;
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        final Modifier modifier2 = companion;
                        final long j7 = j3;
                        final float f4 = f2;
                        final PaddingValues paddingValues4 = paddingValues3;
                        final WindowInsets windowInsets4 = windowInsets3;
                        final BottomAppBarScrollBehavior bottomAppBarScrollBehavior3 = bottomAppBarScrollBehavior2;
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$3
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
                                AppBarKt.m2202BottomAppBarqhFBPw4(function3, modifier2, function23, j7, j5, f4, paddingValues4, windowInsets4, bottomAppBarScrollBehavior3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                f2 = f;
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                if ((i & 12582912) == 0) {
                }
                i7 = i2 & Fields.RotationX;
                if (i7 == 0) {
                }
                if ((i3 & 38347923) == 38347922) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i12 == 0) {
                }
                if (i4 == 0) {
                }
                if ((i2 & 8) != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                if (i5 == 0) {
                }
                if (i6 == 0) {
                }
                if ((i2 & Fields.SpotShadowColor) == 0) {
                }
                if (i7 == 0) {
                }
                i8 = i3;
                paddingValues2 = contentPadding;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i132 = i8 >> 6;
                m2201BottomAppBare3WI5M(companion, j3, j4, f3, paddingValues2, windowInsets2, bottomAppBarScrollBehavior2, ComposableLambdaKt.composableLambda(startRestartGroup, 1566394874, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        invoke((RowScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(RowScope rowScope, Composer composer2, int i14) {
                        int i15;
                        float f42;
                        float f5;
                        ComposerKt.sourceInformation(composer2, "C477@24226L184,484@24459L303:AppBar.kt#uh7d8r");
                        if ((i14 & 6) == 0) {
                            i15 = i14 | (composer2.changed(rowScope) ? 4 : 2);
                        } else {
                            i15 = i14;
                        }
                        if ((i15 & 19) != 18 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1566394874, i15, -1, "androidx.compose.material3.BottomAppBar.<anonymous> (AppBar.kt:477)");
                            }
                            Modifier weight$default = RowScope.weight$default(rowScope, Modifier.INSTANCE, 1.0f, false, 2, null);
                            Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                            Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                            composer2.startReplaceableGroup(693286680);
                            ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer2, 54);
                            composer2.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                            Function0 constructor = ComposeUiNode.Companion.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(weight$default);
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
                            Updater.m4116setimpl(m4109constructorimpl, rowMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer2)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer2, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                            function32.invoke(RowScopeInstance.INSTANCE, composer2, 6);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            if (function22 != null) {
                                Modifier fillMaxHeight$default = SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null);
                                f42 = AppBarKt.FABVerticalPadding;
                                f5 = AppBarKt.FABHorizontalPadding;
                                Modifier m1068paddingqDBjuR0$default = PaddingKt.m1068paddingqDBjuR0$default(fillMaxHeight$default, 0.0f, f42, f5, 0.0f, 9, null);
                                Alignment topStart = Alignment.INSTANCE.getTopStart();
                                Function2<Composer, Integer, Unit> function24 = function22;
                                composer2.startReplaceableGroup(733328855);
                                ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(topStart, false, composer2, 6);
                                composer2.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                                Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m1068paddingqDBjuR0$default);
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
                                ComposerKt.sourceInformationMarkerStart(composer2, 1859776956, "C493@24730L22:AppBar.kt#uh7d8r");
                                function24.invoke(composer2, 0);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                composer2.endReplaceableGroup();
                                composer2.endNode();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), startRestartGroup, ((i8 >> 3) & 14) | 12582912 | (i132 & 112) | (i132 & 896) | (i132 & 7168) | (57344 & i132) | (458752 & i132) | (i132 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                f2 = f3;
                long j62 = j4;
                paddingValues3 = paddingValues2;
                windowInsets3 = windowInsets2;
                function23 = function22;
                j5 = j62;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            f2 = f;
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            if ((i & 12582912) == 0) {
            }
            i7 = i2 & Fields.RotationX;
            if (i7 == 0) {
            }
            if ((i3 & 38347923) == 38347922) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i12 == 0) {
            }
            if (i4 == 0) {
            }
            if ((i2 & 8) != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            if (i5 == 0) {
            }
            if (i6 == 0) {
            }
            if ((i2 & Fields.SpotShadowColor) == 0) {
            }
            if (i7 == 0) {
            }
            i8 = i3;
            paddingValues2 = contentPadding;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i1322 = i8 >> 6;
            m2201BottomAppBare3WI5M(companion, j3, j4, f3, paddingValues2, windowInsets2, bottomAppBarScrollBehavior2, ComposableLambdaKt.composableLambda(startRestartGroup, 1566394874, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((RowScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RowScope rowScope, Composer composer2, int i14) {
                    int i15;
                    float f42;
                    float f5;
                    ComposerKt.sourceInformation(composer2, "C477@24226L184,484@24459L303:AppBar.kt#uh7d8r");
                    if ((i14 & 6) == 0) {
                        i15 = i14 | (composer2.changed(rowScope) ? 4 : 2);
                    } else {
                        i15 = i14;
                    }
                    if ((i15 & 19) != 18 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1566394874, i15, -1, "androidx.compose.material3.BottomAppBar.<anonymous> (AppBar.kt:477)");
                        }
                        Modifier weight$default = RowScope.weight$default(rowScope, Modifier.INSTANCE, 1.0f, false, 2, null);
                        Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                        Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                        composer2.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer2, 54);
                        composer2.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Function0 constructor = ComposeUiNode.Companion.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(weight$default);
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
                        Updater.m4116setimpl(m4109constructorimpl, rowMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer2, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                        function32.invoke(RowScopeInstance.INSTANCE, composer2, 6);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        if (function22 != null) {
                            Modifier fillMaxHeight$default = SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null);
                            f42 = AppBarKt.FABVerticalPadding;
                            f5 = AppBarKt.FABHorizontalPadding;
                            Modifier m1068paddingqDBjuR0$default = PaddingKt.m1068paddingqDBjuR0$default(fillMaxHeight$default, 0.0f, f42, f5, 0.0f, 9, null);
                            Alignment topStart = Alignment.INSTANCE.getTopStart();
                            Function2<Composer, Integer, Unit> function24 = function22;
                            composer2.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(topStart, false, composer2, 6);
                            composer2.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                            CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m1068paddingqDBjuR0$default);
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
                            ComposerKt.sourceInformationMarkerStart(composer2, 1859776956, "C493@24730L22:AppBar.kt#uh7d8r");
                            function24.invoke(composer2, 0);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), startRestartGroup, ((i8 >> 3) & 14) | 12582912 | (i1322 & 112) | (i1322 & 896) | (i1322 & 7168) | (57344 & i1322) | (458752 & i1322) | (i1322 & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            f2 = f3;
            long j622 = j4;
            paddingValues3 = paddingValues2;
            windowInsets3 = windowInsets2;
            function23 = function22;
            j5 = j622;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        f2 = f;
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        if ((i & 12582912) == 0) {
        }
        i7 = i2 & Fields.RotationX;
        if (i7 == 0) {
        }
        if ((i3 & 38347923) == 38347922) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i12 == 0) {
        }
        if (i4 == 0) {
        }
        if ((i2 & 8) != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if (i5 == 0) {
        }
        if (i6 == 0) {
        }
        if ((i2 & Fields.SpotShadowColor) == 0) {
        }
        if (i7 == 0) {
        }
        i8 = i3;
        paddingValues2 = contentPadding;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i13222 = i8 >> 6;
        m2201BottomAppBare3WI5M(companion, j3, j4, f3, paddingValues2, windowInsets2, bottomAppBarScrollBehavior2, ComposableLambdaKt.composableLambda(startRestartGroup, 1566394874, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((RowScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(RowScope rowScope, Composer composer2, int i14) {
                int i15;
                float f42;
                float f5;
                ComposerKt.sourceInformation(composer2, "C477@24226L184,484@24459L303:AppBar.kt#uh7d8r");
                if ((i14 & 6) == 0) {
                    i15 = i14 | (composer2.changed(rowScope) ? 4 : 2);
                } else {
                    i15 = i14;
                }
                if ((i15 & 19) != 18 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1566394874, i15, -1, "androidx.compose.material3.BottomAppBar.<anonymous> (AppBar.kt:477)");
                    }
                    Modifier weight$default = RowScope.weight$default(rowScope, Modifier.INSTANCE, 1.0f, false, 2, null);
                    Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                    Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                    composer2.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer2, 54);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Function0 constructor = ComposeUiNode.Companion.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(weight$default);
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
                    Updater.m4116setimpl(m4109constructorimpl, rowMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer2, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                    function32.invoke(RowScopeInstance.INSTANCE, composer2, 6);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (function22 != null) {
                        Modifier fillMaxHeight$default = SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null);
                        f42 = AppBarKt.FABVerticalPadding;
                        f5 = AppBarKt.FABHorizontalPadding;
                        Modifier m1068paddingqDBjuR0$default = PaddingKt.m1068paddingqDBjuR0$default(fillMaxHeight$default, 0.0f, f42, f5, 0.0f, 9, null);
                        Alignment topStart = Alignment.INSTANCE.getTopStart();
                        Function2<Composer, Integer, Unit> function24 = function22;
                        composer2.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(topStart, false, composer2, 6);
                        composer2.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                        Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m1068paddingqDBjuR0$default);
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
                        ComposerKt.sourceInformationMarkerStart(composer2, 1859776956, "C493@24730L22:AppBar.kt#uh7d8r");
                        function24.invoke(composer2, 0);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }), startRestartGroup, ((i8 >> 3) & 14) | 12582912 | (i13222 & 112) | (i13222 & 896) | (i13222 & 7168) | (57344 & i13222) | (458752 & i13222) | (i13222 & 3670016), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        f2 = f3;
        long j6222 = j4;
        paddingValues3 = paddingValues2;
        windowInsets3 = windowInsets2;
        function23 = function22;
        j5 = j6222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0087  */
    /* renamed from: BottomAppBar-1oL4kX8, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2199BottomAppBar1oL4kX8(Modifier modifier, long j, long j2, float f, PaddingValues paddingValues, WindowInsets windowInsets, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        long j3;
        long j4;
        float f2;
        int i4;
        PaddingValues paddingValues2;
        WindowInsets windowInsets2;
        Modifier.Companion companion;
        int i5;
        PaddingValues paddingValues3;
        WindowInsets windowInsets3;
        float f3;
        Modifier modifier2;
        ScopeUpdateScope endRestartGroup;
        int i6;
        int i7;
        int i8;
        Composer startRestartGroup = composer.startRestartGroup(-1391700845);
        ComposerKt.sourceInformation(startRestartGroup, "C(BottomAppBar)P(4,0:c#ui.graphics.Color,2:c#ui.graphics.Color,5:c#ui.unit.Dp,3,6)527@26431L14,528@26473L31,531@26699L12,533@26762L266:AppBar.kt#uh7d8r");
        int i9 = i2 & 1;
        if (i9 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                j3 = j;
                if (startRestartGroup.changed(j3)) {
                    i8 = 32;
                    i3 |= i8;
                }
            } else {
                j3 = j;
            }
            i8 = 16;
            i3 |= i8;
        } else {
            j3 = j;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                j4 = j2;
                if (startRestartGroup.changed(j4)) {
                    i7 = Fields.RotationX;
                    i3 |= i7;
                }
            } else {
                j4 = j2;
            }
            i7 = Fields.SpotShadowColor;
            i3 |= i7;
        } else {
            j4 = j2;
        }
        int i10 = i2 & 8;
        if (i10 != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            f2 = f;
            i3 |= startRestartGroup.changed(f2) ? Fields.CameraDistance : Fields.RotationZ;
            i4 = i2 & 16;
            if (i4 == 0) {
                i3 |= 24576;
            } else if ((i & 24576) == 0) {
                paddingValues2 = paddingValues;
                i3 |= startRestartGroup.changed(paddingValues2) ? Fields.Clip : Fields.Shape;
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        windowInsets2 = windowInsets;
                        if (startRestartGroup.changed(windowInsets2)) {
                            i6 = Fields.RenderEffect;
                            i3 |= i6;
                        }
                    } else {
                        windowInsets2 = windowInsets;
                    }
                    i6 = 65536;
                    i3 |= i6;
                } else {
                    windowInsets2 = windowInsets;
                }
                if ((i2 & 64) != 0) {
                    i3 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    i3 |= startRestartGroup.changedInstance(function3) ? 1048576 : Fields.BlendMode;
                    if ((i3 & 599187) == 599186 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            companion = i9 == 0 ? Modifier.INSTANCE : modifier;
                            if ((i2 & 2) != 0) {
                                j3 = BottomAppBarDefaults.INSTANCE.getContainerColor(startRestartGroup, 6);
                                i3 &= -113;
                            }
                            if ((i2 & 4) != 0) {
                                j4 = ColorSchemeKt.m2381contentColorForek8zF_U(j3, startRestartGroup, (i3 >> 3) & 14);
                                i3 &= -897;
                            }
                            if (i10 != 0) {
                                f2 = BottomAppBarDefaults.INSTANCE.m2223getContainerElevationD9Ej5fM();
                            }
                            if (i4 != 0) {
                                paddingValues2 = BottomAppBarDefaults.INSTANCE.getContentPadding();
                            }
                            if ((i2 & 32) != 0) {
                                i5 = i3 & (-458753);
                                paddingValues3 = paddingValues2;
                                windowInsets3 = BottomAppBarDefaults.INSTANCE.getWindowInsets(startRestartGroup, 6);
                                f3 = f2;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1391700845, i5, -1, "androidx.compose.material3.BottomAppBar (AppBar.kt:533)");
                                }
                                m2201BottomAppBare3WI5M(companion, j3, j4, f3, paddingValues3, windowInsets3, null, function3, startRestartGroup, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                f2 = f3;
                                paddingValues2 = paddingValues3;
                                windowInsets2 = windowInsets3;
                                modifier2 = companion;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 2) != 0) {
                                i3 &= -113;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            companion = modifier;
                        }
                        i5 = i3;
                        f3 = f2;
                        paddingValues3 = paddingValues2;
                        windowInsets3 = windowInsets2;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        m2201BottomAppBare3WI5M(companion, j3, j4, f3, paddingValues3, windowInsets3, null, function3, startRestartGroup, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        f2 = f3;
                        paddingValues2 = paddingValues3;
                        windowInsets2 = windowInsets3;
                        modifier2 = companion;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        modifier2 = modifier;
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        final Modifier modifier3 = modifier2;
                        final long j5 = j3;
                        final long j6 = j4;
                        final float f4 = f2;
                        final PaddingValues paddingValues4 = paddingValues2;
                        final WindowInsets windowInsets4 = windowInsets2;
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$4
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

                            public final void invoke(Composer composer2, int i11) {
                                AppBarKt.m2199BottomAppBar1oL4kX8(Modifier.this, j5, j6, f4, paddingValues4, windowInsets4, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                if ((i3 & 599187) == 599186) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i9 == 0) {
                }
                if ((i2 & 2) != 0) {
                }
                if ((i2 & 4) != 0) {
                }
                if (i10 != 0) {
                }
                if (i4 != 0) {
                }
                if ((i2 & 32) != 0) {
                }
                i5 = i3;
                f3 = f2;
                paddingValues3 = paddingValues2;
                windowInsets3 = windowInsets2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                m2201BottomAppBare3WI5M(companion, j3, j4, f3, paddingValues3, windowInsets3, null, function3, startRestartGroup, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                f2 = f3;
                paddingValues2 = paddingValues3;
                windowInsets2 = windowInsets3;
                modifier2 = companion;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            paddingValues2 = paddingValues;
            if ((196608 & i) == 0) {
            }
            if ((i2 & 64) != 0) {
            }
            if ((i3 & 599187) == 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i9 == 0) {
            }
            if ((i2 & 2) != 0) {
            }
            if ((i2 & 4) != 0) {
            }
            if (i10 != 0) {
            }
            if (i4 != 0) {
            }
            if ((i2 & 32) != 0) {
            }
            i5 = i3;
            f3 = f2;
            paddingValues3 = paddingValues2;
            windowInsets3 = windowInsets2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            m2201BottomAppBare3WI5M(companion, j3, j4, f3, paddingValues3, windowInsets3, null, function3, startRestartGroup, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            f2 = f3;
            paddingValues2 = paddingValues3;
            windowInsets2 = windowInsets3;
            modifier2 = companion;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        f2 = f;
        i4 = i2 & 16;
        if (i4 == 0) {
        }
        paddingValues2 = paddingValues;
        if ((196608 & i) == 0) {
        }
        if ((i2 & 64) != 0) {
        }
        if ((i3 & 599187) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i9 == 0) {
        }
        if ((i2 & 2) != 0) {
        }
        if ((i2 & 4) != 0) {
        }
        if (i10 != 0) {
        }
        if (i4 != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        i5 = i3;
        f3 = f2;
        paddingValues3 = paddingValues2;
        windowInsets3 = windowInsets2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        m2201BottomAppBare3WI5M(companion, j3, j4, f3, paddingValues3, windowInsets3, null, function3, startRestartGroup, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | ((i5 << 3) & 29360128), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        f2 = f3;
        paddingValues2 = paddingValues3;
        windowInsets2 = windowInsets3;
        modifier2 = companion;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02bf  */
    /* renamed from: BottomAppBar-e-3WI5M, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2201BottomAppBare3WI5M(Modifier modifier, long j, long j2, float f, PaddingValues paddingValues, WindowInsets windowInsets, BottomAppBarScrollBehavior bottomAppBarScrollBehavior, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        long j3;
        long j4;
        float f2;
        int i4;
        PaddingValues paddingValues2;
        int i5;
        Modifier.Companion companion;
        WindowInsets windowInsets2;
        final WindowInsets windowInsets3;
        float f3;
        int i6;
        final PaddingValues paddingValues3;
        final BottomAppBarScrollBehavior bottomAppBarScrollBehavior2;
        Modifier.Companion companion2;
        boolean z;
        Object rememberedValue;
        Modifier modifier2;
        final BottomAppBarScrollBehavior bottomAppBarScrollBehavior3;
        final float f4;
        final long j5;
        final PaddingValues paddingValues4;
        final long j6;
        final WindowInsets windowInsets4;
        ScopeUpdateScope endRestartGroup;
        int i7;
        int i8;
        Composer startRestartGroup = composer.startRestartGroup(422438773);
        ComposerKt.sourceInformation(startRestartGroup, "C(BottomAppBar)P(4,0:c#ui.graphics.Color,2:c#ui.graphics.Color,6:c#ui.unit.Dp,3,7,5)577@29038L14,578@29080L31,581@29306L12,613@30640L5,615@30695L577,608@30373L1325:AppBar.kt#uh7d8r");
        int i9 = i2 & 1;
        if (i9 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                j3 = j;
                if (startRestartGroup.changed(j3)) {
                    i8 = 32;
                    i3 |= i8;
                }
            } else {
                j3 = j;
            }
            i8 = 16;
            i3 |= i8;
        } else {
            j3 = j;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                j4 = j2;
                if (startRestartGroup.changed(j4)) {
                    i7 = Fields.RotationX;
                    i3 |= i7;
                }
            } else {
                j4 = j2;
            }
            i7 = Fields.SpotShadowColor;
            i3 |= i7;
        } else {
            j4 = j2;
        }
        int i10 = i2 & 8;
        if (i10 != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            f2 = f;
            i3 |= startRestartGroup.changed(f2) ? Fields.CameraDistance : Fields.RotationZ;
            i4 = i2 & 16;
            if (i4 == 0) {
                i3 |= 24576;
            } else if ((i & 24576) == 0) {
                paddingValues2 = paddingValues;
                i3 |= startRestartGroup.changed(paddingValues2) ? Fields.Clip : Fields.Shape;
                if ((i & 196608) == 0) {
                    i3 |= ((i2 & 32) == 0 && startRestartGroup.changed(windowInsets)) ? Fields.RenderEffect : 65536;
                }
                i5 = i2 & 64;
                if (i5 != 0) {
                    i3 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    i3 |= startRestartGroup.changed(bottomAppBarScrollBehavior) ? 1048576 : Fields.BlendMode;
                }
                if ((i2 & Fields.SpotShadowColor) != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    i3 |= startRestartGroup.changedInstance(function3) ? 8388608 : 4194304;
                }
                if ((4793491 & i3) == 4793490 || !startRestartGroup.getSkipping()) {
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                        companion = i9 != 0 ? Modifier.INSTANCE : modifier;
                        if ((i2 & 2) != 0) {
                            j3 = BottomAppBarDefaults.INSTANCE.getContainerColor(startRestartGroup, 6);
                            i3 &= -113;
                        }
                        if ((i2 & 4) != 0) {
                            j4 = ColorSchemeKt.m2381contentColorForek8zF_U(j3, startRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                        }
                        if (i10 != 0) {
                            f2 = BottomAppBarDefaults.INSTANCE.m2223getContainerElevationD9Ej5fM();
                        }
                        if (i4 != 0) {
                            paddingValues2 = BottomAppBarDefaults.INSTANCE.getContentPadding();
                        }
                        if ((i2 & 32) != 0) {
                            windowInsets2 = BottomAppBarDefaults.INSTANCE.getWindowInsets(startRestartGroup, 6);
                            i3 &= -458753;
                        } else {
                            windowInsets2 = windowInsets;
                        }
                        windowInsets3 = windowInsets2;
                        f3 = f2;
                        i6 = i3;
                        paddingValues3 = paddingValues2;
                        if (i5 != 0) {
                            bottomAppBarScrollBehavior2 = null;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(422438773, i6, -1, "androidx.compose.material3.BottomAppBar (AppBar.kt:584)");
                            }
                            startRestartGroup.startReplaceableGroup(1291864525);
                            ComposerKt.sourceInformation(startRestartGroup, "589@29726L83,589@29703L106,592@29839L261");
                            if (bottomAppBarScrollBehavior2 == null && !bottomAppBarScrollBehavior2.getIsPinned()) {
                                Modifier.Companion companion3 = Modifier.INSTANCE;
                                Orientation orientation = Orientation.Vertical;
                                startRestartGroup.startReplaceableGroup(1291864702);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AppBar.kt#9igjgp");
                                int i11 = i6 & 3670016;
                                boolean z2 = i11 == 1048576;
                                Object rememberedValue2 = startRestartGroup.rememberedValue();
                                if (z2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue2 = (Function1) new Function1<Float, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$appBarDragModifier$1$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        {
                                            super(1);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                            invoke(((Number) obj).floatValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(float f5) {
                                            BottomAppBarState state = BottomAppBarScrollBehavior.this.getState();
                                            state.setHeightOffset(state.getHeightOffset() - f5);
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue2);
                                }
                                startRestartGroup.endReplaceableGroup();
                                DraggableState rememberDraggableState = DraggableKt.rememberDraggableState((Function1) rememberedValue2, startRestartGroup, 0);
                                Modifier.Companion companion4 = companion3;
                                startRestartGroup.startReplaceableGroup(1291864815);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AppBar.kt#9igjgp");
                                boolean z3 = i11 == 1048576;
                                AppBarKt$BottomAppBar$appBarDragModifier$2$1 rememberedValue3 = startRestartGroup.rememberedValue();
                                if (z3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue3 = new AppBarKt$BottomAppBar$appBarDragModifier$2$1(bottomAppBarScrollBehavior2, null);
                                    startRestartGroup.updateRememberedValue(rememberedValue3);
                                }
                                startRestartGroup.endReplaceableGroup();
                                companion2 = DraggableKt.draggable$default(companion4, rememberDraggableState, orientation, false, null, false, null, (Function3) rememberedValue3, false, 188, null);
                            } else {
                                companion2 = Modifier.INSTANCE;
                            }
                            startRestartGroup.endReplaceableGroup();
                            Shape value = ShapesKt.getValue(BottomAppBarTokens.INSTANCE.getContainerShape(), startRestartGroup, 6);
                            startRestartGroup.startReplaceableGroup(1291865671);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AppBar.kt#9igjgp");
                            z = (3670016 & i6) != 1048576;
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (!z || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = (Function3) new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$5$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    {
                                        super(3);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                        return m2207invoke3p2s80s((MeasureScope) obj, (Measurable) obj2, ((Constraints) obj3).unbox-impl());
                                    }

                                    /* renamed from: invoke-3p2s80s, reason: not valid java name */
                                    public final MeasureResult m2207invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j7) {
                                        BottomAppBarState state;
                                        BottomAppBarScrollBehavior bottomAppBarScrollBehavior4 = BottomAppBarScrollBehavior.this;
                                        BottomAppBarState state2 = bottomAppBarScrollBehavior4 != null ? bottomAppBarScrollBehavior4.getState() : null;
                                        if (state2 != null) {
                                            state2.setHeightOffsetLimit(-measureScope.toPx-0680j_4(BottomAppBarTokens.INSTANCE.m3415getContainerHeightD9Ej5fM()));
                                        }
                                        final Placeable mo6318measureBRTryo0 = measurable.mo6318measureBRTryo0(j7);
                                        float height = mo6318measureBRTryo0.getHeight();
                                        BottomAppBarScrollBehavior bottomAppBarScrollBehavior5 = BottomAppBarScrollBehavior.this;
                                        return MeasureScope.layout$default(measureScope, mo6318measureBRTryo0.getWidth(), MathKt.roundToInt(height + ((bottomAppBarScrollBehavior5 == null || (state = bottomAppBarScrollBehavior5.getState()) == null) ? 0.0f : state.getHeightOffset())), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$5$1.1
                                            {
                                                super(1);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                invoke((Placeable.PlacementScope) obj);
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Placeable.PlacementScope placementScope) {
                                                Placeable.PlacementScope.place$default(placementScope, Placeable.this, 0, 0, 0.0f, 4, null);
                                            }
                                        }, 4, null);
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            startRestartGroup.endReplaceableGroup();
                            modifier2 = companion;
                            int i12 = i6 << 3;
                            int i13 = (i12 & 896) | 12582912 | (i12 & 7168) | (i12 & 57344);
                            BottomAppBarScrollBehavior bottomAppBarScrollBehavior4 = bottomAppBarScrollBehavior2;
                            SurfaceKt.m3043SurfaceT9BRK9s(LayoutModifierKt.layout(companion, (Function3) rememberedValue).then(companion2), value, j3, j4, f3, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1243053520, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$6
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
                                    ComposerKt.sourceInformation(composer2, "C629@31327L365:AppBar.kt#uh7d8r");
                                    if ((i14 & 3) != 2 || !composer2.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1243053520, i14, -1, "androidx.compose.material3.BottomAppBar.<anonymous> (AppBar.kt:629)");
                                        }
                                        Modifier padding = PaddingKt.padding(SizeKt.m1106height3ABfNKs(WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), WindowInsets.this), BottomAppBarTokens.INSTANCE.m3415getContainerHeightD9Ej5fM()), paddingValues3);
                                        Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                        Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                                        composer2.startReplaceableGroup(693286680);
                                        ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer2, 54);
                                        composer2.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                        Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(padding);
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
                                        Updater.m4116setimpl(m4109constructorimpl, rowMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                        Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                        Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                        if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                            m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                            m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                        }
                                        modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer2)), composer2, 0);
                                        composer2.startReplaceableGroup(2058660585);
                                        ComposerKt.sourceInformationMarkerStart(composer2, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                        function32.invoke(RowScopeInstance.INSTANCE, composer2, 6);
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        composer2.endReplaceableGroup();
                                        composer2.endNode();
                                        composer2.endReplaceableGroup();
                                        composer2.endReplaceableGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer2.skipToGroupEnd();
                                }
                            }), startRestartGroup, i13, 96);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            WindowInsets windowInsets5 = windowInsets3;
                            bottomAppBarScrollBehavior3 = bottomAppBarScrollBehavior4;
                            f4 = f3;
                            j5 = j3;
                            long j7 = j4;
                            paddingValues4 = paddingValues3;
                            j6 = j7;
                            windowInsets4 = windowInsets5;
                        }
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                        }
                        companion = modifier;
                        windowInsets3 = windowInsets;
                        f3 = f2;
                        i6 = i3;
                        paddingValues3 = paddingValues2;
                    }
                    bottomAppBarScrollBehavior2 = bottomAppBarScrollBehavior;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.startReplaceableGroup(1291864525);
                    ComposerKt.sourceInformation(startRestartGroup, "589@29726L83,589@29703L106,592@29839L261");
                    if (bottomAppBarScrollBehavior2 == null) {
                    }
                    companion2 = Modifier.INSTANCE;
                    startRestartGroup.endReplaceableGroup();
                    Shape value2 = ShapesKt.getValue(BottomAppBarTokens.INSTANCE.getContainerShape(), startRestartGroup, 6);
                    startRestartGroup.startReplaceableGroup(1291865671);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AppBar.kt#9igjgp");
                    if ((3670016 & i6) != 1048576) {
                    }
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!z) {
                    }
                    rememberedValue = (Function3) new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$5$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(3);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                            return m2207invoke3p2s80s((MeasureScope) obj, (Measurable) obj2, ((Constraints) obj3).unbox-impl());
                        }

                        /* renamed from: invoke-3p2s80s, reason: not valid java name */
                        public final MeasureResult m2207invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j72) {
                            BottomAppBarState state;
                            BottomAppBarScrollBehavior bottomAppBarScrollBehavior42 = BottomAppBarScrollBehavior.this;
                            BottomAppBarState state2 = bottomAppBarScrollBehavior42 != null ? bottomAppBarScrollBehavior42.getState() : null;
                            if (state2 != null) {
                                state2.setHeightOffsetLimit(-measureScope.toPx-0680j_4(BottomAppBarTokens.INSTANCE.m3415getContainerHeightD9Ej5fM()));
                            }
                            final Placeable mo6318measureBRTryo0 = measurable.mo6318measureBRTryo0(j72);
                            float height = mo6318measureBRTryo0.getHeight();
                            BottomAppBarScrollBehavior bottomAppBarScrollBehavior5 = BottomAppBarScrollBehavior.this;
                            return MeasureScope.layout$default(measureScope, mo6318measureBRTryo0.getWidth(), MathKt.roundToInt(height + ((bottomAppBarScrollBehavior5 == null || (state = bottomAppBarScrollBehavior5.getState()) == null) ? 0.0f : state.getHeightOffset())), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$5$1.1
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((Placeable.PlacementScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Placeable.PlacementScope placementScope) {
                                    Placeable.PlacementScope.place$default(placementScope, Placeable.this, 0, 0, 0.0f, 4, null);
                                }
                            }, 4, null);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                    startRestartGroup.endReplaceableGroup();
                    modifier2 = companion;
                    int i122 = i6 << 3;
                    int i132 = (i122 & 896) | 12582912 | (i122 & 7168) | (i122 & 57344);
                    BottomAppBarScrollBehavior bottomAppBarScrollBehavior42 = bottomAppBarScrollBehavior2;
                    SurfaceKt.m3043SurfaceT9BRK9s(LayoutModifierKt.layout(companion, (Function3) rememberedValue).then(companion2), value2, j3, j4, f3, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1243053520, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$6
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
                            ComposerKt.sourceInformation(composer2, "C629@31327L365:AppBar.kt#uh7d8r");
                            if ((i14 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1243053520, i14, -1, "androidx.compose.material3.BottomAppBar.<anonymous> (AppBar.kt:629)");
                                }
                                Modifier padding = PaddingKt.padding(SizeKt.m1106height3ABfNKs(WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), WindowInsets.this), BottomAppBarTokens.INSTANCE.m3415getContainerHeightD9Ej5fM()), paddingValues3);
                                Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                                composer2.startReplaceableGroup(693286680);
                                ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer2, 54);
                                composer2.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(padding);
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
                                Updater.m4116setimpl(m4109constructorimpl, rowMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer2)), composer2, 0);
                                composer2.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(composer2, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                function32.invoke(RowScopeInstance.INSTANCE, composer2, 6);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                composer2.endReplaceableGroup();
                                composer2.endNode();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), startRestartGroup, i132, 96);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    WindowInsets windowInsets52 = windowInsets3;
                    bottomAppBarScrollBehavior3 = bottomAppBarScrollBehavior42;
                    f4 = f3;
                    j5 = j3;
                    long j72 = j4;
                    paddingValues4 = paddingValues3;
                    j6 = j72;
                    windowInsets4 = windowInsets52;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    modifier2 = modifier;
                    bottomAppBarScrollBehavior3 = bottomAppBarScrollBehavior;
                    j5 = j3;
                    j6 = j4;
                    f4 = f2;
                    paddingValues4 = paddingValues2;
                    windowInsets4 = windowInsets;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier3 = modifier2;
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$7
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
                            AppBarKt.m2201BottomAppBare3WI5M(Modifier.this, j5, j6, f4, paddingValues4, windowInsets4, bottomAppBarScrollBehavior3, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                    return;
                }
                return;
            }
            paddingValues2 = paddingValues;
            if ((i & 196608) == 0) {
            }
            i5 = i2 & 64;
            if (i5 != 0) {
            }
            if ((i2 & Fields.SpotShadowColor) != 0) {
            }
            if ((4793491 & i3) == 4793490) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i9 != 0) {
            }
            if ((i2 & 2) != 0) {
            }
            if ((i2 & 4) != 0) {
            }
            if (i10 != 0) {
            }
            if (i4 != 0) {
            }
            if ((i2 & 32) != 0) {
            }
            windowInsets3 = windowInsets2;
            f3 = f2;
            i6 = i3;
            paddingValues3 = paddingValues2;
            if (i5 != 0) {
            }
            bottomAppBarScrollBehavior2 = bottomAppBarScrollBehavior;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceableGroup(1291864525);
            ComposerKt.sourceInformation(startRestartGroup, "589@29726L83,589@29703L106,592@29839L261");
            if (bottomAppBarScrollBehavior2 == null) {
            }
            companion2 = Modifier.INSTANCE;
            startRestartGroup.endReplaceableGroup();
            Shape value22 = ShapesKt.getValue(BottomAppBarTokens.INSTANCE.getContainerShape(), startRestartGroup, 6);
            startRestartGroup.startReplaceableGroup(1291865671);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AppBar.kt#9igjgp");
            if ((3670016 & i6) != 1048576) {
            }
            rememberedValue = startRestartGroup.rememberedValue();
            if (!z) {
            }
            rememberedValue = (Function3) new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$5$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(3);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    return m2207invoke3p2s80s((MeasureScope) obj, (Measurable) obj2, ((Constraints) obj3).unbox-impl());
                }

                /* renamed from: invoke-3p2s80s, reason: not valid java name */
                public final MeasureResult m2207invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j722) {
                    BottomAppBarState state;
                    BottomAppBarScrollBehavior bottomAppBarScrollBehavior422 = BottomAppBarScrollBehavior.this;
                    BottomAppBarState state2 = bottomAppBarScrollBehavior422 != null ? bottomAppBarScrollBehavior422.getState() : null;
                    if (state2 != null) {
                        state2.setHeightOffsetLimit(-measureScope.toPx-0680j_4(BottomAppBarTokens.INSTANCE.m3415getContainerHeightD9Ej5fM()));
                    }
                    final Placeable mo6318measureBRTryo0 = measurable.mo6318measureBRTryo0(j722);
                    float height = mo6318measureBRTryo0.getHeight();
                    BottomAppBarScrollBehavior bottomAppBarScrollBehavior5 = BottomAppBarScrollBehavior.this;
                    return MeasureScope.layout$default(measureScope, mo6318measureBRTryo0.getWidth(), MathKt.roundToInt(height + ((bottomAppBarScrollBehavior5 == null || (state = bottomAppBarScrollBehavior5.getState()) == null) ? 0.0f : state.getHeightOffset())), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$5$1.1
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((Placeable.PlacementScope) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Placeable.PlacementScope placementScope) {
                            Placeable.PlacementScope.place$default(placementScope, Placeable.this, 0, 0, 0.0f, 4, null);
                        }
                    }, 4, null);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceableGroup();
            modifier2 = companion;
            int i1222 = i6 << 3;
            int i1322 = (i1222 & 896) | 12582912 | (i1222 & 7168) | (i1222 & 57344);
            BottomAppBarScrollBehavior bottomAppBarScrollBehavior422 = bottomAppBarScrollBehavior2;
            SurfaceKt.m3043SurfaceT9BRK9s(LayoutModifierKt.layout(companion, (Function3) rememberedValue).then(companion2), value22, j3, j4, f3, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1243053520, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$6
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
                    ComposerKt.sourceInformation(composer2, "C629@31327L365:AppBar.kt#uh7d8r");
                    if ((i14 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1243053520, i14, -1, "androidx.compose.material3.BottomAppBar.<anonymous> (AppBar.kt:629)");
                        }
                        Modifier padding = PaddingKt.padding(SizeKt.m1106height3ABfNKs(WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), WindowInsets.this), BottomAppBarTokens.INSTANCE.m3415getContainerHeightD9Ej5fM()), paddingValues3);
                        Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                        Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                        composer2.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer2, 54);
                        composer2.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Function0 constructor = ComposeUiNode.Companion.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(padding);
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
                        Updater.m4116setimpl(m4109constructorimpl, rowMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer2, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                        function32.invoke(RowScopeInstance.INSTANCE, composer2, 6);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), startRestartGroup, i1322, 96);
            if (ComposerKt.isTraceInProgress()) {
            }
            WindowInsets windowInsets522 = windowInsets3;
            bottomAppBarScrollBehavior3 = bottomAppBarScrollBehavior422;
            f4 = f3;
            j5 = j3;
            long j722 = j4;
            paddingValues4 = paddingValues3;
            j6 = j722;
            windowInsets4 = windowInsets522;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        f2 = f;
        i4 = i2 & 16;
        if (i4 == 0) {
        }
        paddingValues2 = paddingValues;
        if ((i & 196608) == 0) {
        }
        i5 = i2 & 64;
        if (i5 != 0) {
        }
        if ((i2 & Fields.SpotShadowColor) != 0) {
        }
        if ((4793491 & i3) == 4793490) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i9 != 0) {
        }
        if ((i2 & 2) != 0) {
        }
        if ((i2 & 4) != 0) {
        }
        if (i10 != 0) {
        }
        if (i4 != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        windowInsets3 = windowInsets2;
        f3 = f2;
        i6 = i3;
        paddingValues3 = paddingValues2;
        if (i5 != 0) {
        }
        bottomAppBarScrollBehavior2 = bottomAppBarScrollBehavior;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceableGroup(1291864525);
        ComposerKt.sourceInformation(startRestartGroup, "589@29726L83,589@29703L106,592@29839L261");
        if (bottomAppBarScrollBehavior2 == null) {
        }
        companion2 = Modifier.INSTANCE;
        startRestartGroup.endReplaceableGroup();
        Shape value222 = ShapesKt.getValue(BottomAppBarTokens.INSTANCE.getContainerShape(), startRestartGroup, 6);
        startRestartGroup.startReplaceableGroup(1291865671);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AppBar.kt#9igjgp");
        if ((3670016 & i6) != 1048576) {
        }
        rememberedValue = startRestartGroup.rememberedValue();
        if (!z) {
        }
        rememberedValue = (Function3) new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$5$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return m2207invoke3p2s80s((MeasureScope) obj, (Measurable) obj2, ((Constraints) obj3).unbox-impl());
            }

            /* renamed from: invoke-3p2s80s, reason: not valid java name */
            public final MeasureResult m2207invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j7222) {
                BottomAppBarState state;
                BottomAppBarScrollBehavior bottomAppBarScrollBehavior4222 = BottomAppBarScrollBehavior.this;
                BottomAppBarState state2 = bottomAppBarScrollBehavior4222 != null ? bottomAppBarScrollBehavior4222.getState() : null;
                if (state2 != null) {
                    state2.setHeightOffsetLimit(-measureScope.toPx-0680j_4(BottomAppBarTokens.INSTANCE.m3415getContainerHeightD9Ej5fM()));
                }
                final Placeable mo6318measureBRTryo0 = measurable.mo6318measureBRTryo0(j7222);
                float height = mo6318measureBRTryo0.getHeight();
                BottomAppBarScrollBehavior bottomAppBarScrollBehavior5 = BottomAppBarScrollBehavior.this;
                return MeasureScope.layout$default(measureScope, mo6318measureBRTryo0.getWidth(), MathKt.roundToInt(height + ((bottomAppBarScrollBehavior5 == null || (state = bottomAppBarScrollBehavior5.getState()) == null) ? 0.0f : state.getHeightOffset())), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$5$1.1
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Placeable.PlacementScope) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Placeable.PlacementScope placementScope) {
                        Placeable.PlacementScope.place$default(placementScope, Placeable.this, 0, 0, 0.0f, 4, null);
                    }
                }, 4, null);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceableGroup();
        modifier2 = companion;
        int i12222 = i6 << 3;
        int i13222 = (i12222 & 896) | 12582912 | (i12222 & 7168) | (i12222 & 57344);
        BottomAppBarScrollBehavior bottomAppBarScrollBehavior4222 = bottomAppBarScrollBehavior2;
        SurfaceKt.m3043SurfaceT9BRK9s(LayoutModifierKt.layout(companion, (Function3) rememberedValue).then(companion2), value222, j3, j4, f3, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1243053520, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$BottomAppBar$6
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
                ComposerKt.sourceInformation(composer2, "C629@31327L365:AppBar.kt#uh7d8r");
                if ((i14 & 3) != 2 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1243053520, i14, -1, "androidx.compose.material3.BottomAppBar.<anonymous> (AppBar.kt:629)");
                    }
                    Modifier padding = PaddingKt.padding(SizeKt.m1106height3ABfNKs(WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), WindowInsets.this), BottomAppBarTokens.INSTANCE.m3415getContainerHeightD9Ej5fM()), paddingValues3);
                    Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                    Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                    composer2.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer2, 54);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Function0 constructor = ComposeUiNode.Companion.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(padding);
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
                    Updater.m4116setimpl(m4109constructorimpl, rowMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer2, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                    function32.invoke(RowScopeInstance.INSTANCE, composer2, 6);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }), startRestartGroup, i13222, 96);
        if (ComposerKt.isTraceInProgress()) {
        }
        WindowInsets windowInsets5222 = windowInsets3;
        bottomAppBarScrollBehavior3 = bottomAppBarScrollBehavior4222;
        f4 = f3;
        j5 = j3;
        long j7222 = j4;
        paddingValues4 = paddingValues3;
        j6 = j7222;
        windowInsets4 = windowInsets5222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    public static final TopAppBarState rememberTopAppBarState(final float f, final float f2, final float f3, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1801969826);
        ComposerKt.sourceInformation(composer, "C(rememberTopAppBarState)P(2,1)1052@50642L145,1052@50595L192:AppBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            f = -3.4028235E38f;
        }
        if ((i2 & 2) != 0) {
            f2 = 0.0f;
        }
        if ((i2 & 4) != 0) {
            f3 = 0.0f;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1801969826, i, -1, "androidx.compose.material3.rememberTopAppBarState (AppBar.kt:1051)");
        }
        Object[] objArr = new Object[0];
        Saver<TopAppBarState, ?> saver = TopAppBarState.INSTANCE.getSaver();
        composer.startReplaceableGroup(1171243704);
        ComposerKt.sourceInformation(composer, "CC(remember):AppBar.kt#9igjgp");
        boolean z = ((((i & 14) ^ 6) > 4 && composer.changed(f)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changed(f2)) || (i & 48) == 32) | ((((i & 896) ^ 384) > 256 && composer.changed(f3)) || (i & 384) == 256);
        Object rememberedValue = composer.rememberedValue();
        if (z || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = (Function0) new Function0<TopAppBarState>() { // from class: androidx.compose.material3.AppBarKt$rememberTopAppBarState$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final TopAppBarState m2211invoke() {
                    return new TopAppBarState(f, f2, f3);
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        TopAppBarState topAppBarState = (TopAppBarState) RememberSaveableKt.m4241rememberSaveable(objArr, (Saver) saver, (String) null, (Function0) rememberedValue, composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return topAppBarState;
    }

    public static final BottomAppBarState rememberBottomAppBarState(final float f, final float f2, final float f3, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1420874240);
        ComposerKt.sourceInformation(composer, "C(rememberBottomAppBarState)P(2,1)1373@63308L148,1373@63258L198:AppBar.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            f = -3.4028235E38f;
        }
        if ((i2 & 2) != 0) {
            f2 = 0.0f;
        }
        if ((i2 & 4) != 0) {
            f3 = 0.0f;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1420874240, i, -1, "androidx.compose.material3.rememberBottomAppBarState (AppBar.kt:1372)");
        }
        Object[] objArr = new Object[0];
        Saver<BottomAppBarState, ?> saver = BottomAppBarState.INSTANCE.getSaver();
        composer.startReplaceableGroup(647586024);
        ComposerKt.sourceInformation(composer, "CC(remember):AppBar.kt#9igjgp");
        boolean z = ((((i & 14) ^ 6) > 4 && composer.changed(f)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changed(f2)) || (i & 48) == 32) | ((((i & 896) ^ 384) > 256 && composer.changed(f3)) || (i & 384) == 256);
        Object rememberedValue = composer.rememberedValue();
        if (z || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = (Function0) new Function0<BottomAppBarState>() { // from class: androidx.compose.material3.AppBarKt$rememberBottomAppBarState$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final BottomAppBarState m2210invoke() {
                    return AppBarKt.BottomAppBarState(f, f2, f3);
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        BottomAppBarState bottomAppBarState = (BottomAppBarState) RememberSaveableKt.m4241rememberSaveable(objArr, (Saver) saver, (String) null, (Function0) rememberedValue, composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return bottomAppBarState;
    }

    public static final BottomAppBarState BottomAppBarState(float f, float f2, float f3) {
        return new BottomAppBarStateImpl(f, f2, f3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0119 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object settleAppBarBottom(BottomAppBarState bottomAppBarState, float f, DecayAnimationSpec<Float> decayAnimationSpec, AnimationSpec<Float> animationSpec, Continuation<? super Velocity> continuation) {
        AppBarKt$settleAppBarBottom$1 appBarKt$settleAppBarBottom$1;
        Object coroutine_suspended;
        int i;
        final Ref.FloatRef floatRef;
        AnimationSpec<Float> animationSpec2;
        AnimationSpec<Float> animationSpec3;
        AnimationState AnimationState$default;
        Float boxFloat;
        Function1<AnimationScope<Float, AnimationVector1D>, Unit> function1;
        Ref.FloatRef floatRef2;
        final BottomAppBarState bottomAppBarState2 = bottomAppBarState;
        if (continuation instanceof AppBarKt$settleAppBarBottom$1) {
            appBarKt$settleAppBarBottom$1 = (AppBarKt$settleAppBarBottom$1) continuation;
            if ((appBarKt$settleAppBarBottom$1.label & Integer.MIN_VALUE) != 0) {
                appBarKt$settleAppBarBottom$1.label -= Integer.MIN_VALUE;
                Object obj = appBarKt$settleAppBarBottom$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = appBarKt$settleAppBarBottom$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (bottomAppBarState.getCollapsedFraction() >= 0.01f) {
                        if (!(bottomAppBarState.getCollapsedFraction() == 1.0f)) {
                            floatRef = new Ref.FloatRef();
                            floatRef.element = f;
                            if (decayAnimationSpec == null || Math.abs(f) <= 1.0f) {
                                animationSpec2 = animationSpec;
                            } else {
                                final Ref.FloatRef floatRef3 = new Ref.FloatRef();
                                AnimationState AnimationState$default2 = AnimationStateKt.AnimationState$default(0.0f, f, 0L, 0L, false, 28, null);
                                Function1<AnimationScope<Float, AnimationVector1D>, Unit> function12 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.material3.AppBarKt$settleAppBarBottom$2
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                        invoke((AnimationScope<Float, AnimationVector1D>) obj2);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                                        float floatValue = animationScope.getValue().floatValue() - floatRef3.element;
                                        float heightOffset = bottomAppBarState2.getHeightOffset();
                                        bottomAppBarState2.setHeightOffset(heightOffset + floatValue);
                                        float abs = Math.abs(heightOffset - bottomAppBarState2.getHeightOffset());
                                        floatRef3.element = animationScope.getValue().floatValue();
                                        floatRef.element = animationScope.getVelocity().floatValue();
                                        if (Math.abs(floatValue - abs) > 0.5f) {
                                            animationScope.cancelAnimation();
                                        }
                                    }
                                };
                                appBarKt$settleAppBarBottom$1.L$0 = bottomAppBarState2;
                                animationSpec2 = animationSpec;
                                appBarKt$settleAppBarBottom$1.L$1 = animationSpec2;
                                appBarKt$settleAppBarBottom$1.L$2 = floatRef;
                                appBarKt$settleAppBarBottom$1.label = 1;
                                if (SuspendAnimationKt.animateDecay$default(AnimationState$default2, decayAnimationSpec, false, function12, appBarKt$settleAppBarBottom$1, 2, null) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                        }
                    }
                    return Velocity.box-impl(Velocity.Companion.getZero-9UxMQ8M());
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    floatRef2 = (Ref.FloatRef) appBarKt$settleAppBarBottom$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    floatRef = floatRef2;
                    return Velocity.box-impl(VelocityKt.Velocity(0.0f, floatRef.element));
                }
                Ref.FloatRef floatRef4 = (Ref.FloatRef) appBarKt$settleAppBarBottom$1.L$2;
                AnimationSpec<Float> animationSpec4 = (AnimationSpec) appBarKt$settleAppBarBottom$1.L$1;
                BottomAppBarState bottomAppBarState3 = (BottomAppBarState) appBarKt$settleAppBarBottom$1.L$0;
                ResultKt.throwOnFailure(obj);
                floatRef = floatRef4;
                animationSpec2 = animationSpec4;
                bottomAppBarState2 = bottomAppBarState3;
                animationSpec3 = animationSpec2;
                if (animationSpec3 != null && bottomAppBarState2.getHeightOffset() < 0.0f && bottomAppBarState2.getHeightOffset() > bottomAppBarState2.getHeightOffsetLimit()) {
                    AnimationState$default = AnimationStateKt.AnimationState$default(bottomAppBarState2.getHeightOffset(), 0.0f, 0L, 0L, false, 30, null);
                    boxFloat = Boxing.boxFloat(bottomAppBarState2.getCollapsedFraction() >= 0.5f ? 0.0f : bottomAppBarState2.getHeightOffsetLimit());
                    function1 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.material3.AppBarKt$settleAppBarBottom$3
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                            invoke((AnimationScope<Float, AnimationVector1D>) obj2);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                            BottomAppBarState.this.setHeightOffset(animationScope.getValue().floatValue());
                        }
                    };
                    appBarKt$settleAppBarBottom$1.L$0 = floatRef;
                    appBarKt$settleAppBarBottom$1.L$1 = null;
                    appBarKt$settleAppBarBottom$1.L$2 = null;
                    appBarKt$settleAppBarBottom$1.label = 2;
                    if (SuspendAnimationKt.animateTo$default(AnimationState$default, boxFloat, animationSpec3, false, function1, appBarKt$settleAppBarBottom$1, 4, null) != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    floatRef2 = floatRef;
                    floatRef = floatRef2;
                }
                return Velocity.box-impl(VelocityKt.Velocity(0.0f, floatRef.element));
            }
        }
        appBarKt$settleAppBarBottom$1 = new AppBarKt$settleAppBarBottom$1(continuation);
        Object obj2 = appBarKt$settleAppBarBottom$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = appBarKt$settleAppBarBottom$1.label;
        if (i != 0) {
        }
        animationSpec3 = animationSpec2;
        if (animationSpec3 != null) {
            AnimationState$default = AnimationStateKt.AnimationState$default(bottomAppBarState2.getHeightOffset(), 0.0f, 0L, 0L, false, 30, null);
            boxFloat = Boxing.boxFloat(bottomAppBarState2.getCollapsedFraction() >= 0.5f ? 0.0f : bottomAppBarState2.getHeightOffsetLimit());
            function1 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.material3.AppBarKt$settleAppBarBottom$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj22) {
                    invoke((AnimationScope<Float, AnimationVector1D>) obj22);
                    return Unit.INSTANCE;
                }

                public final void invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                    BottomAppBarState.this.setHeightOffset(animationScope.getValue().floatValue());
                }
            };
            appBarKt$settleAppBarBottom$1.L$0 = floatRef;
            appBarKt$settleAppBarBottom$1.L$1 = null;
            appBarKt$settleAppBarBottom$1.L$2 = null;
            appBarKt$settleAppBarBottom$1.label = 2;
            if (SuspendAnimationKt.animateTo$default(AnimationState$default, boxFloat, animationSpec3, false, function1, appBarKt$settleAppBarBottom$1, 4, null) != coroutine_suspended) {
            }
        }
        return Velocity.box-impl(VelocityKt.Velocity(0.0f, floatRef.element));
    }

    public static final float getBottomAppBarVerticalPadding() {
        return BottomAppBarVerticalPadding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SingleRowTopAppBar(Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, final TextStyle textStyle, final boolean z, final Function2<? super Composer, ? super Integer, Unit> function22, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, final WindowInsets windowInsets, final TopAppBarColors topAppBarColors, final TopAppBarScrollBehavior topAppBarScrollBehavior, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Modifier.Companion companion;
        TopAppBarState state;
        Composer startRestartGroup = composer.startRestartGroup(1841601619);
        ComposerKt.sourceInformation(startRestartGroup, "C(SingleRowTopAppBar)P(3,6,7,1,4!1,8)*1639@73368L7,1640@73441L167,1640@73430L178,1652@74154L151,1690@75611L1166:AppBar.kt#uh7d8r");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changed(textStyle) ? Fields.RotationX : Fields.SpotShadowColor;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            i3 |= startRestartGroup.changed(z) ? Fields.CameraDistance : Fields.RotationZ;
        }
        if ((i2 & 16) != 0) {
            i3 |= 24576;
        } else if ((i & 24576) == 0) {
            i3 |= startRestartGroup.changedInstance(function22) ? Fields.Clip : Fields.Shape;
        }
        if ((i2 & 32) != 0) {
            i3 |= 196608;
        } else if ((i & 196608) == 0) {
            i3 |= startRestartGroup.changedInstance(function3) ? Fields.RenderEffect : 65536;
        }
        if ((i2 & 64) != 0) {
            i3 |= 1572864;
        } else if ((i & 1572864) == 0) {
            i3 |= startRestartGroup.changed(windowInsets) ? 1048576 : Fields.BlendMode;
        }
        if ((i2 & Fields.SpotShadowColor) != 0) {
            i3 |= 12582912;
        } else if ((i & 12582912) == 0) {
            i3 |= startRestartGroup.changed(topAppBarColors) ? 8388608 : 4194304;
        }
        if ((i2 & Fields.RotationX) != 0) {
            i3 |= 100663296;
        } else if ((i & 100663296) == 0) {
            i3 |= startRestartGroup.changed(topAppBarScrollBehavior) ? 67108864 : 33554432;
        }
        if ((38347923 & i3) != 38347922 || !startRestartGroup.getSkipping()) {
            Modifier modifier3 = i4 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1841601619, i3, -1, "androidx.compose.material3.SingleRowTopAppBar (AppBar.kt:1635)");
            }
            ProvidableCompositionLocal localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final float f = -((Density) consume).toPx-0680j_4(TopAppBarSmallTokens.INSTANCE.m3963getContainerHeightD9Ej5fM());
            startRestartGroup.startReplaceableGroup(-1008351447);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AppBar.kt#9igjgp");
            int i5 = i3 & 234881024;
            boolean changed = (i5 == 67108864) | startRestartGroup.changed(f);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.AppBarKt$SingleRowTopAppBar$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m2208invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m2208invoke() {
                        TopAppBarState state2;
                        TopAppBarScrollBehavior topAppBarScrollBehavior2 = TopAppBarScrollBehavior.this;
                        if (Intrinsics.areEqual((topAppBarScrollBehavior2 == null || (state2 = topAppBarScrollBehavior2.getState()) == null) ? null : Float.valueOf(state2.getHeightOffsetLimit()), f)) {
                            return;
                        }
                        TopAppBarScrollBehavior topAppBarScrollBehavior3 = TopAppBarScrollBehavior.this;
                        TopAppBarState state3 = topAppBarScrollBehavior3 != null ? topAppBarScrollBehavior3.getState() : null;
                        if (state3 == null) {
                            return;
                        }
                        state3.setHeightOffsetLimit(f);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            EffectsKt.SideEffect((Function0) rememberedValue, startRestartGroup, 0);
            Modifier modifier4 = modifier3;
            State<Color> m244animateColorAsStateeuL9pac = SingleValueAnimationKt.m244animateColorAsStateeuL9pac(topAppBarColors.m3358containerColorvNxB06k$material3_release(((topAppBarScrollBehavior == null || (state = topAppBarScrollBehavior.getState()) == null) ? 0.0f : state.getOverlappedFraction()) > 0.01f ? 1.0f : 0.0f), AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null), null, null, startRestartGroup, 48, 12);
            final ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(startRestartGroup, 1520880938, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$SingleRowTopAppBar$actionsRow$1
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

                public final void invoke(Composer composer2, int i6) {
                    ComposerKt.sourceInformation(composer2, "C1659@74390L157:AppBar.kt#uh7d8r");
                    if ((i6 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1520880938, i6, -1, "androidx.compose.material3.SingleRowTopAppBar.<anonymous> (AppBar.kt:1659)");
                        }
                        Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                        Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                        composer2.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                        Modifier.Companion companion2 = Modifier.INSTANCE;
                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(end, centerVertically, composer2, 54);
                        composer2.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Function0 constructor = ComposeUiNode.Companion.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion2);
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
                        Updater.m4116setimpl(m4109constructorimpl, rowMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer2, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                        function32.invoke(RowScopeInstance.INSTANCE, composer2, 6);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            });
            startRestartGroup.startReplaceableGroup(-1008350212);
            ComposerKt.sourceInformation(startRestartGroup, "1670@74853L118,1670@74830L141,1673@75001L255");
            if (topAppBarScrollBehavior != null && !topAppBarScrollBehavior.getIsPinned()) {
                Modifier.Companion companion2 = Modifier.INSTANCE;
                Orientation orientation = Orientation.Vertical;
                startRestartGroup.startReplaceableGroup(-1008350035);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AppBar.kt#9igjgp");
                boolean z2 = i5 == 67108864;
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (z2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = (Function1) new Function1<Float, Unit>() { // from class: androidx.compose.material3.AppBarKt$SingleRowTopAppBar$appBarDragModifier$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke(((Number) obj).floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float f2) {
                            TopAppBarScrollBehavior.this.getState().setHeightOffset(TopAppBarScrollBehavior.this.getState().getHeightOffset() + f2);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceableGroup();
                DraggableState rememberDraggableState = DraggableKt.rememberDraggableState((Function1) rememberedValue2, startRestartGroup, 0);
                Modifier.Companion companion3 = companion2;
                startRestartGroup.startReplaceableGroup(-1008349887);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AppBar.kt#9igjgp");
                boolean z3 = i5 == 67108864;
                AppBarKt$SingleRowTopAppBar$appBarDragModifier$2$1 rememberedValue3 = startRestartGroup.rememberedValue();
                if (z3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue3 = new AppBarKt$SingleRowTopAppBar$appBarDragModifier$2$1(topAppBarScrollBehavior, null);
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceableGroup();
                companion = DraggableKt.draggable$default(companion3, rememberDraggableState, orientation, false, null, false, null, (Function3) rememberedValue3, false, 188, null);
            } else {
                companion = Modifier.INSTANCE;
            }
            startRestartGroup.endReplaceableGroup();
            SurfaceKt.m3043SurfaceT9BRK9s(modifier4.then(companion), null, SingleRowTopAppBar$lambda$7(m244animateColorAsStateeuL9pac), 0L, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, 376925230, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$SingleRowTopAppBar$2
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

                public final void invoke(Composer composer2, int i6) {
                    TopAppBarState state2;
                    ComposerKt.sourceInformation(composer2, "C*1691@75731L7,1695@75881L890:AppBar.kt#uh7d8r");
                    if ((i6 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(376925230, i6, -1, "androidx.compose.material3.SingleRowTopAppBar.<anonymous> (AppBar.kt:1691)");
                        }
                        ProvidableCompositionLocal localDensity2 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume2 = composer2.consume(localDensity2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        TopAppBarScrollBehavior topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                        AppBarKt.m2203TopAppBarLayoutkXwM9vE(ClipKt.clipToBounds(WindowInsetsPaddingKt.windowInsetsPadding(Modifier.INSTANCE, WindowInsets.this)), ((topAppBarScrollBehavior2 == null || (state2 = topAppBarScrollBehavior2.getState()) == null) ? 0.0f : state2.getHeightOffset()) + ((Density) consume2).toPx-0680j_4(TopAppBarSmallTokens.INSTANCE.m3963getContainerHeightD9Ej5fM()), topAppBarColors.getNavigationIconContentColor(), topAppBarColors.getTitleContentColor(), topAppBarColors.getActionIconContentColor(), function2, textStyle, 1.0f, Arrangement.INSTANCE.getCenter(), z ? Arrangement.INSTANCE.getCenter() : Arrangement.INSTANCE.getStart(), 0, false, function22, composableLambda, composer2, 113246208, 3126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), startRestartGroup, 12582912, 122);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier2;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$SingleRowTopAppBar$3
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

                public final void invoke(Composer composer2, int i6) {
                    AppBarKt.SingleRowTopAppBar(Modifier.this, function2, textStyle, z, function22, function3, windowInsets, topAppBarColors, topAppBarScrollBehavior, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:110:0x039d  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01be  */
    /* renamed from: TwoRowsTopAppBar-tjU4iQQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2204TwoRowsTopAppBartjU4iQQ(Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, final TextStyle textStyle, final float f, final Function2<? super Composer, ? super Integer, Unit> function22, final TextStyle textStyle2, final Function2<? super Composer, ? super Integer, Unit> function23, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, final WindowInsets windowInsets, final TopAppBarColors topAppBarColors, final float f2, final float f3, final TopAppBarScrollBehavior topAppBarScrollBehavior, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        int i5;
        Modifier.Companion companion;
        Composer composer2;
        final Modifier modifier2;
        TopAppBarState state;
        Composer startRestartGroup = composer.startRestartGroup(210227552);
        ComposerKt.sourceInformation(startRestartGroup, "C(TwoRowsTopAppBar)P(3,9,11,10:c#ui.unit.Dp,7,8,4!1,12!1,2:c#ui.unit.Dp,5:c#ui.unit.Dp)*1750@77824L7,1758@78137L189,1758@78126L200,1807@80298L2301:AppBar.kt#uh7d8r");
        int i6 = i3 & 1;
        if (i6 != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        int i7 = i3 & 4;
        int i8 = Fields.SpotShadowColor;
        if (i7 != 0) {
            i4 |= 384;
        } else if ((i & 384) == 0) {
            i4 |= startRestartGroup.changed(textStyle) ? Fields.RotationX : 128;
            if ((i3 & 8) == 0) {
                i4 |= 3072;
            } else if ((i & 3072) == 0) {
                i4 |= startRestartGroup.changed(f) ? Fields.CameraDistance : Fields.RotationZ;
            }
            if ((i3 & 16) == 0) {
                i4 |= 24576;
            } else if ((i & 24576) == 0) {
                i4 |= startRestartGroup.changedInstance(function22) ? Fields.Clip : Fields.Shape;
                if ((i3 & 32) != 0) {
                    i4 |= 196608;
                } else if ((i & 196608) == 0) {
                    i4 |= startRestartGroup.changed(textStyle2) ? Fields.RenderEffect : 65536;
                }
                if ((i3 & 64) != 0) {
                    i4 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    i4 |= startRestartGroup.changedInstance(function23) ? 1048576 : Fields.BlendMode;
                }
                if ((i3 & Fields.SpotShadowColor) != 0) {
                    i4 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    i4 |= startRestartGroup.changedInstance(function3) ? 8388608 : 4194304;
                }
                if ((i3 & Fields.RotationX) != 0) {
                    i4 |= 100663296;
                } else if ((i & 100663296) == 0) {
                    i4 |= startRestartGroup.changed(windowInsets) ? 67108864 : 33554432;
                    if ((i3 & Fields.RotationY) == 0) {
                        i4 |= 805306368;
                    } else if ((i & 805306368) == 0) {
                        i4 |= startRestartGroup.changed(topAppBarColors) ? 536870912 : 268435456;
                    }
                    if ((i3 & Fields.RotationZ) == 0) {
                        i5 = i2 | 6;
                    } else if ((i2 & 6) == 0) {
                        i5 = i2 | (startRestartGroup.changed(f2) ? 4 : 2);
                    } else {
                        i5 = i2;
                    }
                    if ((i3 & Fields.CameraDistance) == 0) {
                        i5 |= 48;
                    } else if ((i2 & 48) == 0) {
                        i5 |= startRestartGroup.changed(f3) ? 32 : 16;
                    }
                    if ((i3 & Fields.TransformOrigin) == 0) {
                        i5 |= 384;
                    } else if ((i2 & 384) == 0) {
                        if (startRestartGroup.changed(topAppBarScrollBehavior)) {
                            i8 = Fields.RotationX;
                        }
                        i5 |= i8;
                    }
                    if ((306783379 & i4) == 306783378 || (i5 & 147) != 146 || !startRestartGroup.getSkipping()) {
                        Modifier.Companion companion2 = i6 == 0 ? Modifier.INSTANCE : modifier;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(210227552, i4, i5, "androidx.compose.material3.TwoRowsTopAppBar (AppBar.kt:1741)");
                        }
                        if (Dp.compareTo-0680j_4(f2, f3) > 0) {
                            throw new IllegalArgumentException("A TwoRowsTopAppBar max height should be greater than its pinned height");
                        }
                        final Ref.FloatRef floatRef = new Ref.FloatRef();
                        final Ref.FloatRef floatRef2 = new Ref.FloatRef();
                        final Ref.IntRef intRef = new Ref.IntRef();
                        ProvidableCompositionLocal localDensity = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume = startRestartGroup.consume(localDensity);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        Density density = (Density) consume;
                        floatRef.element = density.toPx-0680j_4(f3);
                        floatRef2.element = density.toPx-0680j_4(f2);
                        intRef.element = density.roundToPx-0680j_4(f);
                        startRestartGroup.startReplaceableGroup(-1609641260);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AppBar.kt#9igjgp");
                        int i9 = i5 & 896;
                        boolean changed = startRestartGroup.changed(floatRef.element) | (i9 == 256) | startRestartGroup.changed(floatRef2.element);
                        Object rememberedValue = startRestartGroup.rememberedValue();
                        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$2$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                public /* bridge */ /* synthetic */ Object invoke() {
                                    m2209invoke();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: collision with other method in class */
                                public final void m2209invoke() {
                                    TopAppBarState state2;
                                    TopAppBarScrollBehavior topAppBarScrollBehavior2 = TopAppBarScrollBehavior.this;
                                    if (Intrinsics.areEqual((topAppBarScrollBehavior2 == null || (state2 = topAppBarScrollBehavior2.getState()) == null) ? null : Float.valueOf(state2.getHeightOffsetLimit()), floatRef.element - floatRef2.element)) {
                                        return;
                                    }
                                    TopAppBarScrollBehavior topAppBarScrollBehavior3 = TopAppBarScrollBehavior.this;
                                    TopAppBarState state3 = topAppBarScrollBehavior3 != null ? topAppBarScrollBehavior3.getState() : null;
                                    if (state3 == null) {
                                        return;
                                    }
                                    state3.setHeightOffsetLimit(floatRef.element - floatRef2.element);
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue);
                        }
                        startRestartGroup.endReplaceableGroup();
                        EffectsKt.SideEffect((Function0) rememberedValue, startRestartGroup, 0);
                        float collapsedFraction = (topAppBarScrollBehavior == null || (state = topAppBarScrollBehavior.getState()) == null) ? 0.0f : state.getCollapsedFraction();
                        long m3358containerColorvNxB06k$material3_release = topAppBarColors.m3358containerColorvNxB06k$material3_release(collapsedFraction);
                        final ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(startRestartGroup, -1048401111, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$actionsRow$1
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

                            public final void invoke(Composer composer3, int i10) {
                                ComposerKt.sourceInformation(composer3, "C1774@78959L157:AppBar.kt#uh7d8r");
                                if ((i10 & 3) != 2 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1048401111, i10, -1, "androidx.compose.material3.TwoRowsTopAppBar.<anonymous> (AppBar.kt:1774)");
                                    }
                                    Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                    Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                                    composer3.startReplaceableGroup(693286680);
                                    ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                    Modifier.Companion companion3 = Modifier.INSTANCE;
                                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(end, centerVertically, composer3, 54);
                                    composer3.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                    Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion3);
                                    if (!(composer3.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer3.startReusableNode();
                                    if (composer3.getInserting()) {
                                        composer3.createNode(constructor);
                                    } else {
                                        composer3.useNode();
                                    }
                                    Composer m4109constructorimpl = Updater.m4109constructorimpl(composer3);
                                    Updater.m4116setimpl(m4109constructorimpl, rowMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                    Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                    Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                    if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer3)), composer3, 0);
                                    composer3.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer3, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                    function32.invoke(RowScopeInstance.INSTANCE, composer3, 6);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    composer3.endReplaceableGroup();
                                    composer3.endNode();
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        });
                        final float transform = TopTitleAlphaEasing.transform(collapsedFraction);
                        final float f4 = 1.0f - collapsedFraction;
                        final boolean z = collapsedFraction < 0.5f;
                        final boolean z2 = !z;
                        startRestartGroup.startReplaceableGroup(-1609639731);
                        ComposerKt.sourceInformation(startRestartGroup, "1791@79843L118,1791@79820L141,1794@79991L255");
                        if (topAppBarScrollBehavior != null && !topAppBarScrollBehavior.getIsPinned()) {
                            Modifier.Companion companion3 = Modifier.INSTANCE;
                            Orientation orientation = Orientation.Vertical;
                            startRestartGroup.startReplaceableGroup(-1609639554);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AppBar.kt#9igjgp");
                            boolean z3 = i9 == 256;
                            Object rememberedValue2 = startRestartGroup.rememberedValue();
                            if (z3 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue2 = (Function1) new Function1<Float, Unit>() { // from class: androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$appBarDragModifier$1$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke(((Number) obj).floatValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(float f5) {
                                        TopAppBarScrollBehavior.this.getState().setHeightOffset(TopAppBarScrollBehavior.this.getState().getHeightOffset() + f5);
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue2);
                            }
                            startRestartGroup.endReplaceableGroup();
                            DraggableState rememberDraggableState = DraggableKt.rememberDraggableState((Function1) rememberedValue2, startRestartGroup, 0);
                            Modifier.Companion companion4 = companion3;
                            startRestartGroup.startReplaceableGroup(-1609639406);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AppBar.kt#9igjgp");
                            boolean z4 = i9 == 256;
                            AppBarKt$TwoRowsTopAppBar$appBarDragModifier$2$1 rememberedValue3 = startRestartGroup.rememberedValue();
                            if (z4 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue3 = new AppBarKt$TwoRowsTopAppBar$appBarDragModifier$2$1(topAppBarScrollBehavior, null);
                                startRestartGroup.updateRememberedValue(rememberedValue3);
                            }
                            startRestartGroup.endReplaceableGroup();
                            companion = DraggableKt.draggable$default(companion4, rememberDraggableState, orientation, false, null, false, null, (Function3) rememberedValue3, false, 188, null);
                        } else {
                            companion = Modifier.INSTANCE;
                        }
                        startRestartGroup.endReplaceableGroup();
                        Modifier then = companion2.then(companion);
                        Modifier modifier3 = companion2;
                        composer2 = startRestartGroup;
                        SurfaceKt.m3043SurfaceT9BRK9s(then, null, m3358containerColorvNxB06k$material3_release, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, 1985938853, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$3
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

                            public final void invoke(Composer composer3, int i10) {
                                TopAppBarState state2;
                                ComposerKt.sourceInformation(composer3, "C1808@80392L2201:AppBar.kt#uh7d8r");
                                if ((i10 & 3) != 2 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1985938853, i10, -1, "androidx.compose.material3.TwoRowsTopAppBar.<anonymous> (AppBar.kt:1808)");
                                    }
                                    WindowInsets windowInsets2 = WindowInsets.this;
                                    Ref.FloatRef floatRef3 = floatRef;
                                    TopAppBarColors topAppBarColors2 = topAppBarColors;
                                    Function2<Composer, Integer, Unit> function24 = function22;
                                    TextStyle textStyle3 = textStyle2;
                                    float f5 = transform;
                                    boolean z5 = z;
                                    Function2<Composer, Integer, Unit> function25 = function23;
                                    Function2<Composer, Integer, Unit> function26 = composableLambda;
                                    Ref.FloatRef floatRef4 = floatRef2;
                                    TopAppBarScrollBehavior topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                                    Function2<Composer, Integer, Unit> function27 = function2;
                                    TextStyle textStyle4 = textStyle;
                                    float f6 = f4;
                                    Ref.IntRef intRef2 = intRef;
                                    boolean z6 = z2;
                                    composer3.startReplaceableGroup(-483455358);
                                    ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                    Modifier.Companion companion5 = Modifier.INSTANCE;
                                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                                    composer3.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                    Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion5);
                                    if (!(composer3.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer3.startReusableNode();
                                    if (composer3.getInserting()) {
                                        composer3.createNode(constructor);
                                    } else {
                                        composer3.useNode();
                                    }
                                    Composer m4109constructorimpl = Updater.m4109constructorimpl(composer3);
                                    Updater.m4116setimpl(m4109constructorimpl, columnMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                    Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                    Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                    if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer3)), composer3, 0);
                                    composer3.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer3, 1863931258, "C1809@80413L982,1830@81408L1175:AppBar.kt#uh7d8r");
                                    AppBarKt.m2203TopAppBarLayoutkXwM9vE(ClipKt.clipToBounds(WindowInsetsPaddingKt.windowInsetsPadding(Modifier.INSTANCE, windowInsets2)), floatRef3.element, topAppBarColors2.getNavigationIconContentColor(), topAppBarColors2.getTitleContentColor(), topAppBarColors2.getActionIconContentColor(), function24, textStyle3, f5, Arrangement.INSTANCE.getCenter(), Arrangement.INSTANCE.getStart(), 0, z5, function25, function26, composer3, 905969664, 3078);
                                    AppBarKt.m2203TopAppBarLayoutkXwM9vE(ClipKt.clipToBounds(WindowInsetsPaddingKt.windowInsetsPadding(Modifier.INSTANCE, WindowInsetsKt.m1152onlybOOhFvg(windowInsets2, WindowInsetsSides.INSTANCE.m1176getHorizontalJoeWqyM()))), (floatRef4.element - floatRef3.element) + ((topAppBarScrollBehavior2 == null || (state2 = topAppBarScrollBehavior2.getState()) == null) ? 0.0f : state2.getHeightOffset()), topAppBarColors2.getNavigationIconContentColor(), topAppBarColors2.getTitleContentColor(), topAppBarColors2.getActionIconContentColor(), function27, textStyle4, f6, Arrangement.INSTANCE.getBottom(), Arrangement.INSTANCE.getStart(), intRef2.element, z6, ComposableSingletons$AppBarKt.INSTANCE.m2395getLambda11$material3_release(), ComposableSingletons$AppBarKt.INSTANCE.m2396getLambda12$material3_release(), composer3, 905969664, 3456);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    composer3.endReplaceableGroup();
                                    composer3.endNode();
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }), composer2, 12582912, 122);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier3;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        modifier2 = modifier;
                        composer2 = startRestartGroup;
                    }
                    ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$TwoRowsTopAppBar$4
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

                            public final void invoke(Composer composer3, int i10) {
                                AppBarKt.m2204TwoRowsTopAppBartjU4iQQ(Modifier.this, function2, textStyle, f, function22, textStyle2, function23, function3, windowInsets, topAppBarColors, f2, f3, topAppBarScrollBehavior, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                            }
                        });
                        return;
                    }
                    return;
                }
                if ((i3 & Fields.RotationY) == 0) {
                }
                if ((i3 & Fields.RotationZ) == 0) {
                }
                if ((i3 & Fields.CameraDistance) == 0) {
                }
                if ((i3 & Fields.TransformOrigin) == 0) {
                }
                if ((306783379 & i4) == 306783378) {
                }
                if (i6 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                if (Dp.compareTo-0680j_4(f2, f3) > 0) {
                }
            }
            if ((i3 & 32) != 0) {
            }
            if ((i3 & 64) != 0) {
            }
            if ((i3 & Fields.SpotShadowColor) != 0) {
            }
            if ((i3 & Fields.RotationX) != 0) {
            }
            if ((i3 & Fields.RotationY) == 0) {
            }
            if ((i3 & Fields.RotationZ) == 0) {
            }
            if ((i3 & Fields.CameraDistance) == 0) {
            }
            if ((i3 & Fields.TransformOrigin) == 0) {
            }
            if ((306783379 & i4) == 306783378) {
            }
            if (i6 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            if (Dp.compareTo-0680j_4(f2, f3) > 0) {
            }
        }
        if ((i3 & 8) == 0) {
        }
        if ((i3 & 16) == 0) {
        }
        if ((i3 & 32) != 0) {
        }
        if ((i3 & 64) != 0) {
        }
        if ((i3 & Fields.SpotShadowColor) != 0) {
        }
        if ((i3 & Fields.RotationX) != 0) {
        }
        if ((i3 & Fields.RotationY) == 0) {
        }
        if ((i3 & Fields.RotationZ) == 0) {
        }
        if ((i3 & Fields.CameraDistance) == 0) {
        }
        if ((i3 & Fields.TransformOrigin) == 0) {
        }
        if ((306783379 & i4) == 306783378) {
        }
        if (i6 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        if (Dp.compareTo-0680j_4(f2, f3) > 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: TopAppBarLayout-kXwM9vE, reason: not valid java name */
    public static final void m2203TopAppBarLayoutkXwM9vE(final Modifier modifier, final float f, final long j, final long j2, final long j3, final Function2<? super Composer, ? super Integer, Unit> function2, final TextStyle textStyle, final float f2, final Arrangement.Vertical vertical, final Arrangement.Horizontal horizontal, final int i, final boolean z, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, Composer composer, final int i2, final int i3) {
        int i4;
        int i5;
        Composer startRestartGroup = composer.startRestartGroup(-6794037);
        ComposerKt.sourceInformation(startRestartGroup, "C(TopAppBarLayout)P(4,2,6:c#ui.graphics.Color,10:c#ui.graphics.Color,0:c#ui.graphics.Color,7,12,8,13,11,9,3,5)1936@85940L4001,1900@84643L5298:AppBar.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i4 = (startRestartGroup.changed(modifier) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= startRestartGroup.changed(f) ? 32 : 16;
        }
        int i6 = i2 & 384;
        int i7 = Fields.RotationX;
        if (i6 == 0) {
            i4 |= startRestartGroup.changed(j) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= startRestartGroup.changed(j2) ? Fields.CameraDistance : Fields.RotationZ;
        }
        if ((i2 & 24576) == 0) {
            i4 |= startRestartGroup.changed(j3) ? Fields.Clip : Fields.Shape;
        }
        if ((196608 & i2) == 0) {
            i4 |= startRestartGroup.changedInstance(function2) ? Fields.RenderEffect : 65536;
        }
        if ((1572864 & i2) == 0) {
            i4 |= startRestartGroup.changed(textStyle) ? 1048576 : Fields.BlendMode;
        }
        if ((i2 & 12582912) == 0) {
            i4 |= startRestartGroup.changed(f2) ? 8388608 : 4194304;
        }
        if ((i2 & 100663296) == 0) {
            i4 |= startRestartGroup.changed(vertical) ? 67108864 : 33554432;
        }
        if ((i2 & 805306368) == 0) {
            i4 |= startRestartGroup.changed(horizontal) ? 536870912 : 268435456;
        }
        if ((i3 & 6) == 0) {
            i5 = i3 | (startRestartGroup.changed(i) ? 4 : 2);
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            if (!startRestartGroup.changedInstance(function22)) {
                i7 = 128;
            }
            i5 |= i7;
        }
        if ((i3 & 3072) == 0) {
            i5 |= startRestartGroup.changedInstance(function23) ? Fields.CameraDistance : Fields.RotationZ;
        }
        int i8 = i5;
        if ((i4 & 306783379) != 306783378 || (i8 & 1171) != 1170 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-6794037, i4, i8, "androidx.compose.material3.TopAppBarLayout (AppBar.kt:1899)");
            }
            startRestartGroup.startReplaceableGroup(1019460550);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):AppBar.kt#9igjgp");
            boolean z2 = ((i4 & 112) == 32) | ((1879048192 & i4) == 536870912) | ((234881024 & i4) == 67108864) | ((i8 & 14) == 4);
            MeasurePolicy rememberedValue = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new MeasurePolicy() { // from class: androidx.compose.material3.AppBarKt$TopAppBarLayout$2$1
                    @Override // androidx.compose.p002ui.layout.MeasurePolicy
                    /* renamed from: measure-3p2s80s */
                    public final MeasureResult mo147measure3p2s80s(final MeasureScope measureScope, List<? extends Measurable> list, final long j4) {
                        int coerceAtLeast;
                        int size = list.size();
                        for (int i9 = 0; i9 < size; i9++) {
                            Measurable measurable = list.get(i9);
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "navigationIcon")) {
                                final Placeable mo6318measureBRTryo0 = measurable.mo6318measureBRTryo0(Constraints.copy-Zbe2FdA$default(j4, 0, 0, 0, 0, 14, (Object) null));
                                int size2 = list.size();
                                for (int i10 = 0; i10 < size2; i10++) {
                                    Measurable measurable2 = list.get(i10);
                                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "actionIcons")) {
                                        final Placeable mo6318measureBRTryo02 = measurable2.mo6318measureBRTryo0(Constraints.copy-Zbe2FdA$default(j4, 0, 0, 0, 0, 14, (Object) null));
                                        if (Constraints.getMaxWidth-impl(j4) == Integer.MAX_VALUE) {
                                            coerceAtLeast = Constraints.getMaxWidth-impl(j4);
                                        } else {
                                            coerceAtLeast = RangesKt.coerceAtLeast((Constraints.getMaxWidth-impl(j4) - mo6318measureBRTryo0.getWidth()) - mo6318measureBRTryo02.getWidth(), 0);
                                        }
                                        int i11 = coerceAtLeast;
                                        int size3 = list.size();
                                        for (int i12 = 0; i12 < size3; i12++) {
                                            Measurable measurable3 = list.get(i12);
                                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable3), "title")) {
                                                final Placeable mo6318measureBRTryo03 = measurable3.mo6318measureBRTryo0(Constraints.copy-Zbe2FdA$default(j4, 0, i11, 0, 0, 12, (Object) null));
                                                final int i13 = mo6318measureBRTryo03.get(AlignmentLineKt.getLastBaseline()) != Integer.MIN_VALUE ? mo6318measureBRTryo03.get(AlignmentLineKt.getLastBaseline()) : 0;
                                                final int roundToInt = Float.isNaN(f) ? 0 : MathKt.roundToInt(f);
                                                int i14 = Constraints.getMaxWidth-impl(j4);
                                                final Arrangement.Horizontal horizontal2 = horizontal;
                                                final Arrangement.Vertical vertical2 = vertical;
                                                final int i15 = i;
                                                return MeasureScope.layout$default(measureScope, i14, roundToInt, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.AppBarKt$TopAppBarLayout$2$1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                        invoke((Placeable.PlacementScope) obj);
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Placeable.PlacementScope placementScope) {
                                                        float f3;
                                                        int max;
                                                        int i16;
                                                        int height;
                                                        int max2;
                                                        int i17;
                                                        int i18;
                                                        Placeable placeable = Placeable.this;
                                                        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, (roundToInt - placeable.getHeight()) / 2, 0.0f, 4, null);
                                                        Placeable placeable2 = mo6318measureBRTryo03;
                                                        Arrangement.Horizontal horizontal3 = horizontal2;
                                                        if (Intrinsics.areEqual(horizontal3, Arrangement.INSTANCE.getCenter())) {
                                                            max = (Constraints.getMaxWidth-impl(j4) - mo6318measureBRTryo03.getWidth()) / 2;
                                                            if (max < Placeable.this.getWidth()) {
                                                                i18 = Placeable.this.getWidth() - max;
                                                            } else if (mo6318measureBRTryo03.getWidth() + max > Constraints.getMaxWidth-impl(j4) - mo6318measureBRTryo02.getWidth()) {
                                                                i18 = (Constraints.getMaxWidth-impl(j4) - mo6318measureBRTryo02.getWidth()) - (mo6318measureBRTryo03.getWidth() + max);
                                                            }
                                                            max += i18;
                                                        } else if (Intrinsics.areEqual(horizontal3, Arrangement.INSTANCE.getEnd())) {
                                                            max = (Constraints.getMaxWidth-impl(j4) - mo6318measureBRTryo03.getWidth()) - mo6318measureBRTryo02.getWidth();
                                                        } else {
                                                            MeasureScope measureScope2 = measureScope;
                                                            f3 = AppBarKt.TopAppBarTitleInset;
                                                            max = Math.max(measureScope2.roundToPx-0680j_4(f3), Placeable.this.getWidth());
                                                        }
                                                        int i19 = max;
                                                        Arrangement.Vertical vertical3 = vertical2;
                                                        if (Intrinsics.areEqual(vertical3, Arrangement.INSTANCE.getCenter())) {
                                                            i17 = (roundToInt - mo6318measureBRTryo03.getHeight()) / 2;
                                                        } else if (!Intrinsics.areEqual(vertical3, Arrangement.INSTANCE.getBottom())) {
                                                            i16 = 0;
                                                            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i19, i16, 0.0f, 4, null);
                                                            Placeable.PlacementScope.placeRelative$default(placementScope, mo6318measureBRTryo02, Constraints.getMaxWidth-impl(j4) - mo6318measureBRTryo02.getWidth(), (roundToInt - mo6318measureBRTryo02.getHeight()) / 2, 0.0f, 4, null);
                                                        } else {
                                                            if (i15 == 0) {
                                                                height = roundToInt;
                                                                max2 = mo6318measureBRTryo03.getHeight();
                                                            } else {
                                                                height = roundToInt - mo6318measureBRTryo03.getHeight();
                                                                max2 = Math.max(0, (i15 - mo6318measureBRTryo03.getHeight()) + i13);
                                                            }
                                                            i17 = height - max2;
                                                        }
                                                        i16 = i17;
                                                        Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i19, i16, 0.0f, 4, null);
                                                        Placeable.PlacementScope.placeRelative$default(placementScope, mo6318measureBRTryo02, Constraints.getMaxWidth-impl(j4) - mo6318measureBRTryo02.getWidth(), (roundToInt - mo6318measureBRTryo02.getHeight()) / 2, 0.0f, 4, null);
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
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier);
            int i9 = ((((i4 << 3) & 112) << 9) & 7168) | 6;
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
            modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, Integer.valueOf((i9 >> 3) & 112));
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -290509324, "C1902@84673L352,1912@85038L507,1924@85558L336:AppBar.kt#uh7d8r");
            Modifier layoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, "navigationIcon");
            float f3 = TopAppBarHorizontalPadding;
            Modifier m1068paddingqDBjuR0$default = PaddingKt.m1068paddingqDBjuR0$default(layoutId, f3, 0.0f, 0.0f, 0.0f, 14, null);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m1068paddingqDBjuR0$default);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1090257852, "C1907@84848L163:AppBar.kt#uh7d8r");
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4829boximpl(j)), function22, startRestartGroup, ProvidedValue.$stable | 0 | ((i8 >> 3) & 112));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            Modifier m1066paddingVpY3zN4$default = PaddingKt.m1066paddingVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, "title"), f3, 0.0f, 2, null);
            Modifier.Companion companion = Modifier.INSTANCE;
            if (z) {
                companion = SemanticsModifierKt.clearAndSetSemantics(companion, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.AppBarKt$TopAppBarLayout$1$2
                    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((SemanticsPropertyReceiver) obj);
                        return Unit.INSTANCE;
                    }
                });
            }
            Modifier m5004graphicsLayerAp8cVGQ$default = GraphicsLayerModifierKt.m5004graphicsLayerAp8cVGQ$default(m1066paddingVpY3zN4$default.then(companion), 0.0f, 0.0f, f2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131067, null);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0 constructor3 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(m5004graphicsLayerAp8cVGQ$default);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1090257337, "C1919@85363L168:AppBar.kt#uh7d8r");
            int i10 = i4 >> 9;
            ProvideContentColorTextStyleKt.m2813ProvideContentColorTextStyle3JVO9M(j2, textStyle, function2, startRestartGroup, ((i4 >> 15) & 112) | (i10 & 14) | (i10 & 896));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            Modifier m1068paddingqDBjuR0$default2 = PaddingKt.m1068paddingqDBjuR0$default(LayoutIdKt.layoutId(Modifier.INSTANCE, "actionIcons"), 0.0f, 0.0f, f3, 0.0f, 11, null);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0 constructor4 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(m1068paddingqDBjuR0$default2);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1090256972, "C1929@85728L152:AppBar.kt#uh7d8r");
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4829boximpl(j3)), function23, startRestartGroup, ((i8 >> 6) & 112) | ProvidedValue.$stable | 0);
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
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AppBarKt$TopAppBarLayout$3
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

                public final void invoke(Composer composer2, int i11) {
                    AppBarKt.m2203TopAppBarLayoutkXwM9vE(Modifier.this, f, j, j2, j3, function2, textStyle, f2, vertical, horizontal, i, z, function22, function23, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0119 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object settleAppBar(TopAppBarState topAppBarState, float f, DecayAnimationSpec<Float> decayAnimationSpec, AnimationSpec<Float> animationSpec, Continuation<? super Velocity> continuation) {
        AppBarKt$settleAppBar$1 appBarKt$settleAppBar$1;
        Object coroutine_suspended;
        int i;
        final Ref.FloatRef floatRef;
        AnimationSpec<Float> animationSpec2;
        AnimationSpec<Float> animationSpec3;
        AnimationState AnimationState$default;
        Float boxFloat;
        Function1<AnimationScope<Float, AnimationVector1D>, Unit> function1;
        Ref.FloatRef floatRef2;
        final TopAppBarState topAppBarState2 = topAppBarState;
        if (continuation instanceof AppBarKt$settleAppBar$1) {
            appBarKt$settleAppBar$1 = (AppBarKt$settleAppBar$1) continuation;
            if ((appBarKt$settleAppBar$1.label & Integer.MIN_VALUE) != 0) {
                appBarKt$settleAppBar$1.label -= Integer.MIN_VALUE;
                Object obj = appBarKt$settleAppBar$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = appBarKt$settleAppBar$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (topAppBarState.getCollapsedFraction() >= 0.01f) {
                        if (!(topAppBarState.getCollapsedFraction() == 1.0f)) {
                            floatRef = new Ref.FloatRef();
                            floatRef.element = f;
                            if (decayAnimationSpec == null || Math.abs(f) <= 1.0f) {
                                animationSpec2 = animationSpec;
                            } else {
                                final Ref.FloatRef floatRef3 = new Ref.FloatRef();
                                AnimationState AnimationState$default2 = AnimationStateKt.AnimationState$default(0.0f, f, 0L, 0L, false, 28, null);
                                Function1<AnimationScope<Float, AnimationVector1D>, Unit> function12 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.material3.AppBarKt$settleAppBar$2
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                        invoke((AnimationScope<Float, AnimationVector1D>) obj2);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                                        float floatValue = animationScope.getValue().floatValue() - floatRef3.element;
                                        float heightOffset = topAppBarState2.getHeightOffset();
                                        topAppBarState2.setHeightOffset(heightOffset + floatValue);
                                        float abs = Math.abs(heightOffset - topAppBarState2.getHeightOffset());
                                        floatRef3.element = animationScope.getValue().floatValue();
                                        floatRef.element = animationScope.getVelocity().floatValue();
                                        if (Math.abs(floatValue - abs) > 0.5f) {
                                            animationScope.cancelAnimation();
                                        }
                                    }
                                };
                                appBarKt$settleAppBar$1.L$0 = topAppBarState2;
                                animationSpec2 = animationSpec;
                                appBarKt$settleAppBar$1.L$1 = animationSpec2;
                                appBarKt$settleAppBar$1.L$2 = floatRef;
                                appBarKt$settleAppBar$1.label = 1;
                                if (SuspendAnimationKt.animateDecay$default(AnimationState$default2, decayAnimationSpec, false, function12, appBarKt$settleAppBar$1, 2, null) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                        }
                    }
                    return Velocity.box-impl(Velocity.Companion.getZero-9UxMQ8M());
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    floatRef2 = (Ref.FloatRef) appBarKt$settleAppBar$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    floatRef = floatRef2;
                    return Velocity.box-impl(VelocityKt.Velocity(0.0f, floatRef.element));
                }
                Ref.FloatRef floatRef4 = (Ref.FloatRef) appBarKt$settleAppBar$1.L$2;
                AnimationSpec<Float> animationSpec4 = (AnimationSpec) appBarKt$settleAppBar$1.L$1;
                TopAppBarState topAppBarState3 = (TopAppBarState) appBarKt$settleAppBar$1.L$0;
                ResultKt.throwOnFailure(obj);
                floatRef = floatRef4;
                animationSpec2 = animationSpec4;
                topAppBarState2 = topAppBarState3;
                animationSpec3 = animationSpec2;
                if (animationSpec3 != null && topAppBarState2.getHeightOffset() < 0.0f && topAppBarState2.getHeightOffset() > topAppBarState2.getHeightOffsetLimit()) {
                    AnimationState$default = AnimationStateKt.AnimationState$default(topAppBarState2.getHeightOffset(), 0.0f, 0L, 0L, false, 30, null);
                    boxFloat = Boxing.boxFloat(topAppBarState2.getCollapsedFraction() >= 0.5f ? 0.0f : topAppBarState2.getHeightOffsetLimit());
                    function1 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.material3.AppBarKt$settleAppBar$3
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                            invoke((AnimationScope<Float, AnimationVector1D>) obj2);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                            TopAppBarState.this.setHeightOffset(animationScope.getValue().floatValue());
                        }
                    };
                    appBarKt$settleAppBar$1.L$0 = floatRef;
                    appBarKt$settleAppBar$1.L$1 = null;
                    appBarKt$settleAppBar$1.L$2 = null;
                    appBarKt$settleAppBar$1.label = 2;
                    if (SuspendAnimationKt.animateTo$default(AnimationState$default, boxFloat, animationSpec3, false, function1, appBarKt$settleAppBar$1, 4, null) != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    floatRef2 = floatRef;
                    floatRef = floatRef2;
                }
                return Velocity.box-impl(VelocityKt.Velocity(0.0f, floatRef.element));
            }
        }
        appBarKt$settleAppBar$1 = new AppBarKt$settleAppBar$1(continuation);
        Object obj2 = appBarKt$settleAppBar$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = appBarKt$settleAppBar$1.label;
        if (i != 0) {
        }
        animationSpec3 = animationSpec2;
        if (animationSpec3 != null) {
            AnimationState$default = AnimationStateKt.AnimationState$default(topAppBarState2.getHeightOffset(), 0.0f, 0L, 0L, false, 30, null);
            boxFloat = Boxing.boxFloat(topAppBarState2.getCollapsedFraction() >= 0.5f ? 0.0f : topAppBarState2.getHeightOffsetLimit());
            function1 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.material3.AppBarKt$settleAppBar$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj22) {
                    invoke((AnimationScope<Float, AnimationVector1D>) obj22);
                    return Unit.INSTANCE;
                }

                public final void invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                    TopAppBarState.this.setHeightOffset(animationScope.getValue().floatValue());
                }
            };
            appBarKt$settleAppBar$1.L$0 = floatRef;
            appBarKt$settleAppBar$1.L$1 = null;
            appBarKt$settleAppBar$1.L$2 = null;
            appBarKt$settleAppBar$1.label = 2;
            if (SuspendAnimationKt.animateTo$default(AnimationState$default, boxFloat, animationSpec3, false, function1, appBarKt$settleAppBar$1, 4, null) != coroutine_suspended) {
            }
        }
        return Velocity.box-impl(VelocityKt.Velocity(0.0f, floatRef.element));
    }

    public static final CubicBezierEasing getTopTitleAlphaEasing() {
        return TopTitleAlphaEasing;
    }

    private static final long SingleRowTopAppBar$lambda$7(State<Color> state) {
        return state.getValue().m4849unboximpl();
    }

    static {
        float f = 16;
        float f2 = 12;
        float f3 = Dp.constructor-impl(Dp.constructor-impl(f) - Dp.constructor-impl(f2));
        BottomAppBarHorizontalPadding = f3;
        float f4 = Dp.constructor-impl(Dp.constructor-impl(f) - Dp.constructor-impl(f2));
        BottomAppBarVerticalPadding = f4;
        FABHorizontalPadding = Dp.constructor-impl(Dp.constructor-impl(f) - f3);
        FABVerticalPadding = Dp.constructor-impl(Dp.constructor-impl(f2) - f4);
        TopTitleAlphaEasing = new CubicBezierEasing(0.8f, 0.0f, 0.8f, 0.15f);
        MediumTitleBottomPadding = Dp.constructor-impl(24);
        LargeTitleBottomPadding = Dp.constructor-impl(28);
        float f5 = Dp.constructor-impl(4);
        TopAppBarHorizontalPadding = f5;
        TopAppBarTitleInset = Dp.constructor-impl(Dp.constructor-impl(f) - f5);
    }
}
