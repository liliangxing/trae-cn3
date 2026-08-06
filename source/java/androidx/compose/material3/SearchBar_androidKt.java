package androidx.compose.material3;

import android.content.res.Configuration;
import androidx.activity.compose.BackHandlerKt;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.shape.GenericShape;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.Strings;
import androidx.compose.material3.tokens.MotionTokens;
import androidx.compose.p002ui.Alignment;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.ZIndexModifierKt;
import androidx.compose.p002ui.focus.FocusChangedModifierKt;
import androidx.compose.p002ui.focus.FocusManager;
import androidx.compose.p002ui.focus.FocusRequester;
import androidx.compose.p002ui.focus.FocusRequesterModifierKt;
import androidx.compose.p002ui.focus.FocusState;
import androidx.compose.p002ui.geometry.CornerRadiusKt;
import androidx.compose.p002ui.geometry.RoundRectKt;
import androidx.compose.p002ui.geometry.Size;
import androidx.compose.p002ui.geometry.SizeKt;
import androidx.compose.p002ui.graphics.Brush;
import androidx.compose.p002ui.graphics.Color;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.p002ui.graphics.GraphicsLayerScope;
import androidx.compose.p002ui.graphics.Path;
import androidx.compose.p002ui.graphics.Shadow;
import androidx.compose.p002ui.graphics.Shape;
import androidx.compose.p002ui.graphics.SolidColor;
import androidx.compose.p002ui.graphics.drawscope.DrawStyle;
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
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
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
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: SearchBar.android.kt */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0087\u0002\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\"0&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\"0&2\u0006\u0010(\u001a\u00020)2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\"0&2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020)2\u0015\b\u0002\u0010.\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u00107\u001a\u00020\u00102\b\b\u0002\u00108\u001a\u00020\u00102\b\b\u0002\u00109\u001a\u00020:2\u001c\u0010;\u001a\u0018\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\"0&¢\u0006\u0002\b0¢\u0006\u0002\b=H\u0007ø\u0001\u0000¢\u0006\u0004\b>\u0010?\u001a\u0091\u0002\u0010@\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\"0&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\"0&2\u0006\u0010(\u001a\u00020)2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\"0&2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020)2\u0015\b\u0002\u0010.\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u00107\u001a\u00020\u00102\b\b\u0002\u00108\u001a\u00020\u00102\b\b\u0002\u0010A\u001a\u00020B2\b\b\u0002\u00109\u001a\u00020:2\u001c\u0010;\u001a\u0018\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\"0&¢\u0006\u0002\b0¢\u0006\u0002\b=H\u0007ø\u0001\u0000¢\u0006\u0004\bC\u0010D\u001aÆ\u0001\u0010E\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\"0&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\"0&2\u0006\u0010(\u001a\u00020)2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\"0&2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020)2\u0015\b\u0002\u0010.\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\b\b\u0002\u00105\u001a\u00020F2\b\b\u0002\u00109\u001a\u00020:H\u0003¢\u0006\u0002\u0010G\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u000f\u001a\u00020\u0010X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012\"\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0018\u001a\u00020\u0010X\u0082\u0004¢\u0006\n\n\u0002\u0010\u0013\u0012\u0004\b\u0019\u0010\u001a\"\u0010\u0010\u001b\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013\"\u0010\u0010\u001c\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013\"\u0016\u0010\u001d\u001a\u00020\u0010X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001e\u0010\u0012\"\u0016\u0010\u001f\u001a\u00020\u0010X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b \u0010\u0012\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006H²\u0006\n\u0010I\u001a\u00020)X\u008a\u0084\u0002²\u0006\n\u0010J\u001a\u00020)X\u008a\u0084\u0002"}, d2 = {"AnimationDelayMillis", "", "AnimationEnterDurationMillis", "AnimationEnterEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "AnimationEnterFloatSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "AnimationEnterSizeSpec", "Landroidx/compose/ui/unit/IntSize;", "AnimationExitDurationMillis", "AnimationExitEasing", "AnimationExitFloatSpec", "AnimationExitSizeSpec", "DockedActiveTableMaxHeightScreenRatio", "DockedActiveTableMinHeight", "Landroidx/compose/ui/unit/Dp;", "getDockedActiveTableMinHeight", "()F", "F", "DockedEnterTransition", "Landroidx/compose/animation/EnterTransition;", "DockedExitTransition", "Landroidx/compose/animation/ExitTransition;", "SearchBarCornerRadius", "getSearchBarCornerRadius$annotations", "()V", "SearchBarIconOffsetX", "SearchBarMaxWidth", "SearchBarMinWidth", "getSearchBarMinWidth", "SearchBarVerticalPadding", "getSearchBarVerticalPadding", "DockedSearchBar", "", "query", "", "onQueryChange", "Lkotlin/Function1;", "onSearch", "active", "", "onActiveChange", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "placeholder", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "leadingIcon", "trailingIcon", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/SearchBarColors;", "tonalElevation", "shadowElevation", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "DockedSearchBar-eWTbjVg", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "SearchBar", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "SearchBar-WuY5d9Q", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "SearchBarInputField", "Landroidx/compose/material3/TextFieldColors;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "material3_release", "useFullScreenShape", "showResults"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class SearchBar_androidKt {
    private static final int AnimationDelayMillis = 100;
    private static final int AnimationEnterDurationMillis = 600;
    private static final CubicBezierEasing AnimationEnterEasing;
    private static final FiniteAnimationSpec<Float> AnimationEnterFloatSpec;
    private static final FiniteAnimationSpec<IntSize> AnimationEnterSizeSpec;
    private static final int AnimationExitDurationMillis = 350;
    private static final CubicBezierEasing AnimationExitEasing;
    private static final FiniteAnimationSpec<Float> AnimationExitFloatSpec;
    private static final FiniteAnimationSpec<IntSize> AnimationExitSizeSpec;
    private static final float DockedActiveTableMaxHeightScreenRatio = 0.6666667f;
    private static final EnterTransition DockedEnterTransition;
    private static final ExitTransition DockedExitTransition;
    private static final float SearchBarCornerRadius = Dp.constructor-impl(SearchBarDefaults.INSTANCE.m2843getInputFieldHeightD9Ej5fM() / 2);
    private static final float DockedActiveTableMinHeight = Dp.constructor-impl(240);
    private static final float SearchBarMinWidth = Dp.constructor-impl(360);
    private static final float SearchBarMaxWidth = Dp.constructor-impl(720);
    private static final float SearchBarVerticalPadding = Dp.constructor-impl(8);
    private static final float SearchBarIconOffsetX = Dp.constructor-impl(4);

    private static /* synthetic */ void getSearchBarCornerRadius$annotations() {
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0376  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x038b  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0407  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0438  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x044c  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0493  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x04b8  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x04f9  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x050c  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0545  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x05ea A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x060f  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0642  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0649  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x066f  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x049e  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x045a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x046a  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0381  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x035a  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x068c  */
    /* JADX WARN: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x024f  */
    /* renamed from: SearchBar-WuY5d9Q, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2849SearchBarWuY5d9Q(final String str, final Function1<? super String, Unit> function1, final Function1<? super String, Unit> function12, final boolean z, final Function1<? super Boolean, Unit> function13, Modifier modifier, boolean z2, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, SearchBarColors searchBarColors, float f, float f2, WindowInsets windowInsets, MutableInteractionSource mutableInteractionSource, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z3;
        int i9;
        Function2<? super Composer, ? super Integer, Unit> function24;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        boolean z4;
        Function2<? super Composer, ? super Integer, Unit> function25;
        Function2<? super Composer, ? super Integer, Unit> function26;
        Shape shape2;
        int i17;
        Function2<? super Composer, ? super Integer, Unit> function27;
        String str2;
        int i18;
        int i19;
        SearchBarColors searchBarColors2;
        WindowInsets windowInsets2;
        String str3;
        Function2<? super Composer, ? super Integer, Unit> function28;
        MutableInteractionSource mutableInteractionSource2;
        SearchBarColors searchBarColors3;
        float f3;
        float f4;
        final WindowInsets windowInsets3;
        Modifier modifier2;
        Shape shape3;
        int i20;
        int i21;
        final State<Float> animateFloatAsState;
        final Density density;
        Shape inputFieldShape;
        Shape fullScreenShape;
        Object rememberedValue;
        State state;
        boolean changed;
        Object rememberedValue2;
        Object rememberedValue3;
        boolean changed2;
        Object rememberedValue4;
        boolean z5;
        Object rememberedValue5;
        boolean changed3;
        Object rememberedValue6;
        Composer composer2;
        boolean z6;
        boolean changed4;
        SearchBar_androidKt$SearchBar$5$1 rememberedValue7;
        boolean z7;
        Object rememberedValue8;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        final SearchBarColors searchBarColors4;
        final float f5;
        final MutableInteractionSource mutableInteractionSource3;
        final boolean z8;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        final WindowInsets windowInsets4;
        final Shape shape4;
        final Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        int i22;
        int i23;
        Composer startRestartGroup = composer.startRestartGroup(1001512593);
        ComposerKt.sourceInformation(startRestartGroup, "C(SearchBar)P(11,8,9!1,7,6,3,10,5,15,13!1,14:c#ui.unit.Dp,12:c#ui.unit.Dp,16,4)170@8780L15,171@8845L8,174@9026L12,175@9090L39,178@9226L160,183@9429L7,184@9468L7,186@9528L15,187@9595L15,188@9641L101,191@9767L578,211@10793L34,212@10849L179,222@11136L38,227@11355L112,231@11539L1082,219@11034L2762,284@13836L25,286@13943L292,286@13920L315,295@14271L37,295@14241L67:SearchBar.android.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i3 & 4) != 0) {
            i4 |= 384;
        } else if ((i & 384) == 0) {
            i4 |= startRestartGroup.changedInstance(function12) ? Fields.RotationX : Fields.SpotShadowColor;
            i5 = i3 & 8;
            int i24 = Fields.CameraDistance;
            if (i5 == 0) {
                i4 |= 3072;
            } else if ((i & 3072) == 0) {
                i4 |= startRestartGroup.changed(z) ? 2048 : 1024;
            }
            i6 = i3 & 16;
            int i25 = Fields.Shape;
            if (i6 == 0) {
                i4 |= 24576;
            } else if ((i & 24576) == 0) {
                i4 |= startRestartGroup.changedInstance(function13) ? Fields.Clip : 8192;
            }
            i7 = i3 & 32;
            if (i7 == 0) {
                i4 |= 196608;
            } else if ((i & 196608) == 0) {
                i4 |= startRestartGroup.changed(modifier) ? Fields.RenderEffect : 65536;
            }
            i8 = i3 & 64;
            if (i8 == 0) {
                i4 |= 1572864;
                z3 = z2;
            } else {
                z3 = z2;
                if ((i & 1572864) == 0) {
                    i4 |= startRestartGroup.changed(z3) ? 1048576 : Fields.BlendMode;
                }
            }
            i9 = i3 & Fields.SpotShadowColor;
            if (i9 == 0) {
                i4 |= 12582912;
                function24 = function2;
            } else {
                function24 = function2;
                if ((i & 12582912) == 0) {
                    i4 |= startRestartGroup.changedInstance(function24) ? 8388608 : 4194304;
                }
            }
            i10 = i3 & Fields.RotationX;
            if (i10 == 0) {
                i4 |= 100663296;
            } else if ((i & 100663296) == 0) {
                i4 |= startRestartGroup.changedInstance(function22) ? 67108864 : 33554432;
            }
            i11 = i3 & Fields.RotationY;
            if (i11 == 0) {
                i4 |= 805306368;
            } else if ((i & 805306368) == 0) {
                i4 |= startRestartGroup.changedInstance(function23) ? 536870912 : 268435456;
            }
            if ((i2 & 6) != 0) {
                if ((i3 & Fields.RotationZ) == 0 && startRestartGroup.changed(shape)) {
                    i23 = 4;
                    i12 = i2 | i23;
                }
                i23 = 2;
                i12 = i2 | i23;
            } else {
                i12 = i2;
            }
            if ((i2 & 48) == 0) {
                if ((i3 & Fields.CameraDistance) == 0 && startRestartGroup.changed(searchBarColors)) {
                    i22 = 32;
                    i12 |= i22;
                }
                i22 = 16;
                i12 |= i22;
            }
            int i26 = i12;
            i13 = i3 & Fields.TransformOrigin;
            if (i13 == 0) {
                i26 |= 384;
            } else if ((i2 & 384) == 0) {
                i26 |= startRestartGroup.changed(f) ? Fields.RotationX : Fields.SpotShadowColor;
                i14 = i3 & Fields.Shape;
                if (i14 != 0) {
                    i26 |= 3072;
                } else if ((i2 & 3072) == 0) {
                    if (!startRestartGroup.changed(f2)) {
                        i24 = 1024;
                    }
                    i26 |= i24;
                    if ((i2 & 24576) == 0) {
                        if ((i3 & Fields.Clip) == 0 && startRestartGroup.changed(windowInsets)) {
                            i25 = Fields.Clip;
                        }
                        i26 |= i25;
                    }
                    i15 = i3 & Fields.CompositingStrategy;
                    if (i15 == 0) {
                        i26 |= 196608;
                    } else if ((i2 & 196608) == 0) {
                        i16 = i14;
                        i26 |= startRestartGroup.changed(mutableInteractionSource) ? Fields.RenderEffect : 65536;
                        if ((i3 & 65536) != 0) {
                            i26 |= 1572864;
                        } else if ((i2 & 1572864) == 0) {
                            i26 |= startRestartGroup.changedInstance(function3) ? 1048576 : Fields.BlendMode;
                        }
                        int i27 = i4;
                        if ((i4 & 306783379) != 306783378 && (599187 & i26) == 599186 && startRestartGroup.getSkipping()) {
                            startRestartGroup.skipToGroupEnd();
                            modifier3 = modifier;
                            function211 = function22;
                            shape4 = shape;
                            searchBarColors4 = searchBarColors;
                            f5 = f;
                            f4 = f2;
                            mutableInteractionSource3 = mutableInteractionSource;
                            function210 = function24;
                            windowInsets4 = windowInsets;
                            z8 = z3;
                            composer2 = startRestartGroup;
                            function29 = function23;
                        } else {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                Modifier modifier4 = i7 != 0 ? Modifier.INSTANCE : modifier;
                                z4 = i8 != 0 ? true : z3;
                                function25 = i9 != 0 ? null : function24;
                                function26 = i10 != 0 ? null : function22;
                                Function2<? super Composer, ? super Integer, Unit> function212 = i11 != 0 ? null : function23;
                                if ((i3 & Fields.RotationZ) != 0) {
                                    i26 &= -15;
                                    shape2 = SearchBarDefaults.INSTANCE.getInputFieldShape(startRestartGroup, 6);
                                } else {
                                    shape2 = shape;
                                }
                                int i28 = i26;
                                if ((i3 & Fields.CameraDistance) != 0) {
                                    i17 = i27;
                                    str2 = "CC(remember):SearchBar.android.kt#9igjgp";
                                    i18 = i16;
                                    i19 = i13;
                                    function27 = function212;
                                    searchBarColors2 = SearchBarDefaults.INSTANCE.m2841colorsKlgxPg(0L, 0L, null, startRestartGroup, 3072, 7);
                                    i28 &= -113;
                                } else {
                                    i17 = i27;
                                    function27 = function212;
                                    str2 = "CC(remember):SearchBar.android.kt#9igjgp";
                                    i18 = i16;
                                    i19 = i13;
                                    searchBarColors2 = searchBarColors;
                                }
                                float m2845getTonalElevationD9Ej5fM = i19 != 0 ? SearchBarDefaults.INSTANCE.m2845getTonalElevationD9Ej5fM() : f;
                                float m2844getShadowElevationD9Ej5fM = i18 != 0 ? SearchBarDefaults.INSTANCE.m2844getShadowElevationD9Ej5fM() : f2;
                                if ((i3 & Fields.Clip) != 0) {
                                    windowInsets2 = SearchBarDefaults.INSTANCE.getWindowInsets(startRestartGroup, 6);
                                    i28 &= -57345;
                                } else {
                                    windowInsets2 = windowInsets;
                                }
                                if (i15 != 0) {
                                    startRestartGroup.startReplaceableGroup(851477946);
                                    str3 = str2;
                                    ComposerKt.sourceInformation(startRestartGroup, str3);
                                    Object rememberedValue9 = startRestartGroup.rememberedValue();
                                    if (rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue9 = InteractionSourceKt.MutableInteractionSource();
                                        startRestartGroup.updateRememberedValue(rememberedValue9);
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    function28 = function27;
                                    searchBarColors3 = searchBarColors2;
                                    f3 = m2845getTonalElevationD9Ej5fM;
                                    f4 = m2844getShadowElevationD9Ej5fM;
                                    mutableInteractionSource2 = (MutableInteractionSource) rememberedValue9;
                                    modifier2 = modifier4;
                                    shape3 = shape2;
                                    windowInsets3 = windowInsets2;
                                } else {
                                    str3 = str2;
                                    function28 = function27;
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    searchBarColors3 = searchBarColors2;
                                    f3 = m2845getTonalElevationD9Ej5fM;
                                    f4 = m2844getShadowElevationD9Ej5fM;
                                    windowInsets3 = windowInsets2;
                                    modifier2 = modifier4;
                                    shape3 = shape2;
                                }
                                i20 = i28;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i3 & Fields.RotationZ) != 0) {
                                    i26 &= -15;
                                }
                                if ((i3 & Fields.CameraDistance) != 0) {
                                    i26 &= -113;
                                }
                                if ((i3 & Fields.Clip) != 0) {
                                    i26 &= -57345;
                                }
                                function26 = function22;
                                function28 = function23;
                                searchBarColors3 = searchBarColors;
                                f4 = f2;
                                windowInsets3 = windowInsets;
                                mutableInteractionSource2 = mutableInteractionSource;
                                i17 = i27;
                                i20 = i26;
                                z4 = z3;
                                function25 = function24;
                                str3 = "CC(remember):SearchBar.android.kt#9igjgp";
                                modifier2 = modifier;
                                shape3 = shape;
                                f3 = f;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                i21 = i17;
                                ComposerKt.traceEventStart(1001512593, i21, i20, "androidx.compose.material3.SearchBar (SearchBar.android.kt:177)");
                            } else {
                                i21 = i17;
                            }
                            animateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, z ? AnimationEnterFloatSpec : AnimationExitFloatSpec, 0.0f, null, null, startRestartGroup, 0, 28);
                            ProvidableCompositionLocal localFocusManager = CompositionLocalsKt.getLocalFocusManager();
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume = startRestartGroup.consume(localFocusManager);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            FocusManager focusManager = (FocusManager) consume;
                            ProvidableCompositionLocal localDensity = CompositionLocalsKt.getLocalDensity();
                            int i29 = i21;
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume2 = startRestartGroup.consume(localDensity);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            density = (Density) consume2;
                            inputFieldShape = SearchBarDefaults.INSTANCE.getInputFieldShape(startRestartGroup, 6);
                            fullScreenShape = SearchBarDefaults.INSTANCE.getFullScreenShape(startRestartGroup, 6);
                            startRestartGroup.startReplaceableGroup(851478497);
                            ComposerKt.sourceInformation(startRestartGroup, str3);
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0<Boolean>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$useFullScreenShape$2$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                    public final Boolean m2856invoke() {
                                        return Boolean.valueOf(animateFloatAsState.getValue().floatValue() == 1.0f);
                                    }
                                });
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            state = (State) rememberedValue;
                            startRestartGroup.endReplaceableGroup();
                            boolean SearchBar_WuY5d9Q$lambda$2 = SearchBar_WuY5d9Q$lambda$2(state);
                            startRestartGroup.startReplaceableGroup(851478623);
                            ComposerKt.sourceInformation(startRestartGroup, str3);
                            changed = startRestartGroup.changed(SearchBar_WuY5d9Q$lambda$2) | ((((i20 & 14) ^ 6) <= 4 && startRestartGroup.changed(shape3)) || (i20 & 6) == 4);
                            rememberedValue2 = startRestartGroup.rememberedValue();
                            if (!changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                GenericShape genericShape = Intrinsics.areEqual(shape3, inputFieldShape) ? new GenericShape(new Function3<Path, Size, LayoutDirection, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$animatedShape$1$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                        m2854invoke12SF9DM((Path) obj, ((Size) obj2).m4667unboximpl(), (LayoutDirection) obj3);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke-12SF9DM, reason: not valid java name */
                                    public final void m2854invoke12SF9DM(Path path, long j, LayoutDirection layoutDirection) {
                                        float f6;
                                        Density density2 = density;
                                        State<Float> state2 = animateFloatAsState;
                                        f6 = SearchBar_androidKt.SearchBarCornerRadius;
                                        path.addRoundRect(RoundRectKt.m4648RoundRectsniSvfs(SizeKt.m4683toRectuvyYCjk(j), CornerRadiusKt.CornerRadius$default(density2.toPx-0680j_4(Dp.constructor-impl(f6 * (1 - state2.getValue().floatValue()))), 0.0f, 2, null)));
                                    }
                                }) : SearchBar_WuY5d9Q$lambda$2(state) ? fullScreenShape : shape3;
                                startRestartGroup.updateRememberedValue(genericShape);
                                rememberedValue2 = genericShape;
                            }
                            Shape shape5 = (Shape) rememberedValue2;
                            startRestartGroup.endReplaceableGroup();
                            startRestartGroup.startReplaceableGroup(851479649);
                            ComposerKt.sourceInformation(startRestartGroup, str3);
                            rememberedValue3 = startRestartGroup.rememberedValue();
                            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue3 = new MutableWindowInsets(null, 1, null);
                                startRestartGroup.updateRememberedValue(rememberedValue3);
                            }
                            final MutableWindowInsets mutableWindowInsets = (MutableWindowInsets) rememberedValue3;
                            startRestartGroup.endReplaceableGroup();
                            startRestartGroup.startReplaceableGroup(851479705);
                            ComposerKt.sourceInformation(startRestartGroup, str3);
                            changed2 = startRestartGroup.changed(density);
                            rememberedValue4 = startRestartGroup.rememberedValue();
                            if (!changed2 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue4 = SnapshotStateKt.derivedStateOf(new Function0<Dp>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$topPadding$1$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke() {
                                        return Dp.box-impl(m2855invokeD9Ej5fM());
                                    }

                                    /* renamed from: invoke-D9Ej5fM, reason: not valid java name */
                                    public final float m2855invokeD9Ej5fM() {
                                        return Dp.constructor-impl(SearchBar_androidKt.getSearchBarVerticalPadding() + WindowInsetsKt.asPaddingValues(MutableWindowInsets.this, density).getTop());
                                    }
                                });
                                startRestartGroup.updateRememberedValue(rememberedValue4);
                            }
                            final State state2 = (State) rememberedValue4;
                            startRestartGroup.endReplaceableGroup();
                            long containerColor = searchBarColors3.getContainerColor();
                            long m2381contentColorForek8zF_U = ColorSchemeKt.m2381contentColorForek8zF_U(searchBarColors3.getContainerColor(), startRestartGroup, 0);
                            Modifier zIndex = ZIndexModifierKt.zIndex(modifier2, 1.0f);
                            startRestartGroup.startReplaceableGroup(851480211);
                            ComposerKt.sourceInformation(startRestartGroup, str3);
                            z5 = (((57344 & i20) ^ 24576) <= 16384 && startRestartGroup.changed(windowInsets3)) || (i20 & 24576) == 16384;
                            rememberedValue5 = startRestartGroup.rememberedValue();
                            if (!z5 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue5 = (Function1) new Function1<WindowInsets, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$2$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((WindowInsets) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(WindowInsets windowInsets5) {
                                        MutableWindowInsets.this.setInsets(WindowInsetsKt.exclude(windowInsets3, windowInsets5));
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue5);
                            }
                            startRestartGroup.endReplaceableGroup();
                            Modifier consumeWindowInsets = WindowInsetsPaddingKt.consumeWindowInsets(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(zIndex, (Function1) rememberedValue5), mutableWindowInsets);
                            startRestartGroup.startReplaceableGroup(851480395);
                            ComposerKt.sourceInformation(startRestartGroup, str3);
                            changed3 = startRestartGroup.changed(state2) | startRestartGroup.changed(animateFloatAsState);
                            rememberedValue6 = startRestartGroup.rememberedValue();
                            if (!changed3 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue6 = (Function3) new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$3$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                        return m2851invoke3p2s80s((MeasureScope) obj, (Measurable) obj2, ((Constraints) obj3).unbox-impl());
                                    }

                                    /* renamed from: invoke-3p2s80s, reason: not valid java name */
                                    public final MeasureResult m2851invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
                                        float f6;
                                        final int i30 = measureScope.roundToPx-0680j_4(DpKt.lerp-Md-fbLM(state2.getValue().unbox-impl(), Dp.constructor-impl(0), animateFloatAsState.getValue().floatValue()));
                                        int max = Math.max(Constraints.getMinWidth-impl(j), measureScope.roundToPx-0680j_4(SearchBar_androidKt.getSearchBarMinWidth()));
                                        int i31 = Constraints.getMaxWidth-impl(j);
                                        f6 = SearchBar_androidKt.SearchBarMaxWidth;
                                        int coerceAtMost = RangesKt.coerceAtMost(max, Math.min(i31, measureScope.roundToPx-0680j_4(f6)));
                                        int coerceAtMost2 = RangesKt.coerceAtMost(Math.max(Constraints.getMinHeight-impl(j), measureScope.roundToPx-0680j_4(SearchBarDefaults.INSTANCE.m2843getInputFieldHeightD9Ej5fM())), Constraints.getMaxHeight-impl(j));
                                        int i32 = Constraints.getMaxWidth-impl(j);
                                        int i33 = Constraints.getMaxHeight-impl(j);
                                        int lerp = MathHelpersKt.lerp(coerceAtMost, i32, animateFloatAsState.getValue().floatValue());
                                        int lerp2 = MathHelpersKt.lerp(coerceAtMost2, i33, animateFloatAsState.getValue().floatValue()) + i30;
                                        final Placeable mo6318measureBRTryo0 = measurable.mo6318measureBRTryo0(ConstraintsKt.offset-NN6Ew-U$default(Constraints.Companion.fixed-JhjzzOo(lerp, lerp2), 0, -i30, 1, (Object) null));
                                        return MeasureScope.layout$default(measureScope, lerp, lerp2, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$3$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                invoke((Placeable.PlacementScope) obj);
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Placeable.PlacementScope placementScope) {
                                                Placeable.PlacementScope.placeRelative$default(placementScope, Placeable.this, 0, i30, 0.0f, 4, null);
                                            }
                                        }, 4, null);
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue6);
                            }
                            startRestartGroup.endReplaceableGroup();
                            int i30 = i20;
                            WindowInsets windowInsets5 = windowInsets3;
                            final boolean z9 = z4;
                            Shape shape6 = shape3;
                            final Function2<? super Composer, ? super Integer, Unit> function213 = function25;
                            Modifier modifier5 = modifier2;
                            final Function2<? super Composer, ? super Integer, Unit> function214 = function26;
                            String str4 = str3;
                            final Function2<? super Composer, ? super Integer, Unit> function215 = function28;
                            final SearchBarColors searchBarColors5 = searchBarColors3;
                            final MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                            composer2 = startRestartGroup;
                            int i31 = i30 << 6;
                            SurfaceKt.m3043SurfaceT9BRK9s(LayoutModifierKt.layout(consumeWindowInsets, (Function3) rememberedValue6), shape5, containerColor, m2381contentColorForek8zF_U, f3, f4, null, ComposableLambdaKt.composableLambda(composer2, 483163116, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$4
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

                                public final void invoke(Composer composer3, int i32) {
                                    final State<Float> state3;
                                    ComposerKt.sourceInformation(composer3, "C253@12638L1152:SearchBar.android.kt#uh7d8r");
                                    if ((i32 & 3) != 2 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(483163116, i32, -1, "androidx.compose.material3.SearchBar.<anonymous> (SearchBar.android.kt:253)");
                                        }
                                        String str5 = str;
                                        Function1<String, Unit> function14 = function1;
                                        Function1<String, Unit> function15 = function12;
                                        boolean z10 = z;
                                        Function1<Boolean, Unit> function16 = function13;
                                        boolean z11 = z9;
                                        Function2<Composer, Integer, Unit> function216 = function213;
                                        Function2<Composer, Integer, Unit> function217 = function214;
                                        Function2<Composer, Integer, Unit> function218 = function215;
                                        SearchBarColors searchBarColors6 = searchBarColors5;
                                        MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource4;
                                        State<Float> state4 = animateFloatAsState;
                                        State<Dp> state5 = state2;
                                        Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                                        composer3.startReplaceableGroup(-483455358);
                                        ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                        Modifier.Companion companion = Modifier.INSTANCE;
                                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                                        composer3.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                        Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
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
                                        ComposerKt.sourceInformationMarkerStart(composer3, -685095315, "C254@12691L93,257@12797L590,272@13420L115:SearchBar.android.kt#uh7d8r");
                                        composer3.startReplaceableGroup(-685095283);
                                        ComposerKt.sourceInformation(composer3, "CC(remember):SearchBar.android.kt#9igjgp");
                                        Object rememberedValue10 = composer3.rememberedValue();
                                        if (rememberedValue10 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue10 = new AnimatedPaddingValues(state4, state5);
                                            composer3.updateRememberedValue(rememberedValue10);
                                        }
                                        composer3.endReplaceableGroup();
                                        SearchBar_androidKt.SearchBarInputField(str5, function14, function15, z10, function16, PaddingKt.padding(Modifier.INSTANCE, (AnimatedPaddingValues) rememberedValue10), z11, function216, function217, function218, searchBarColors6.getInputFieldColors(), mutableInteractionSource5, composer3, 196608, 0, 0);
                                        composer3.startReplaceableGroup(-685094554);
                                        ComposerKt.sourceInformation(composer3, "CC(remember):SearchBar.android.kt#9igjgp");
                                        Object rememberedValue11 = composer3.rememberedValue();
                                        if (rememberedValue11 == Composer.INSTANCE.getEmpty()) {
                                            state3 = state4;
                                            rememberedValue11 = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0<Boolean>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$4$1$showResults$2$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                                public final Boolean m2852invoke() {
                                                    return Boolean.valueOf(state3.getValue().floatValue() > 0.0f);
                                                }
                                            });
                                            composer3.updateRememberedValue(rememberedValue11);
                                        } else {
                                            state3 = state4;
                                        }
                                        composer3.endReplaceableGroup();
                                        composer3.startReplaceableGroup(551421253);
                                        ComposerKt.sourceInformation(composer3, "276@13613L35,276@13583L183");
                                        if (invoke$lambda$5$lambda$2((State) rememberedValue11)) {
                                            Modifier.Companion companion2 = Modifier.INSTANCE;
                                            composer3.startReplaceableGroup(-685094361);
                                            ComposerKt.sourceInformation(composer3, "CC(remember):SearchBar.android.kt#9igjgp");
                                            boolean changed5 = composer3.changed(state3);
                                            Object rememberedValue12 = composer3.rememberedValue();
                                            if (changed5 || rememberedValue12 == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue12 = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$4$1$1$1
                                                    /* JADX INFO: Access modifiers changed from: package-private */
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                        invoke((GraphicsLayerScope) obj);
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                                                        graphicsLayerScope.setAlpha(state3.getValue().floatValue());
                                                    }
                                                };
                                                composer3.updateRememberedValue(rememberedValue12);
                                            }
                                            composer3.endReplaceableGroup();
                                            Modifier graphicsLayer = GraphicsLayerModifierKt.graphicsLayer(companion2, (Function1) rememberedValue12);
                                            composer3.startReplaceableGroup(-483455358);
                                            ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                                            composer3.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                            CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(graphicsLayer);
                                            if (!(composer3.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer3.startReusableNode();
                                            if (composer3.getInserting()) {
                                                composer3.createNode(constructor2);
                                            } else {
                                                composer3.useNode();
                                            }
                                            Composer m4109constructorimpl2 = Updater.m4109constructorimpl(composer3);
                                            Updater.m4116setimpl(m4109constructorimpl2, columnMeasurePolicy2, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                            Updater.m4116setimpl(m4109constructorimpl2, currentCompositionLocalMap2, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                            Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                            if (m4109constructorimpl2.getInserting() || !Intrinsics.areEqual(m4109constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                                m4109constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                                m4109constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                            }
                                            modifierMaterializerOf2.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer3)), composer3, 0);
                                            composer3.startReplaceableGroup(2058660585);
                                            ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(composer3, 1234675075, "C277@13672L46,278@13739L9:SearchBar.android.kt#uh7d8r");
                                            DividerKt.m2540HorizontalDivider9IZ8Weo(null, 0.0f, searchBarColors6.getDividerColor(), composer3, 0, 3);
                                            function32.invoke(columnScopeInstance2, composer3, 6);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            composer3.endReplaceableGroup();
                                            composer3.endNode();
                                            composer3.endReplaceableGroup();
                                            composer3.endReplaceableGroup();
                                        }
                                        composer3.endReplaceableGroup();
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

                                private static final boolean invoke$lambda$5$lambda$2(State<Boolean> state3) {
                                    return state3.getValue().booleanValue();
                                }
                            }), composer2, (57344 & i31) | 12582912 | (i31 & 458752), 64);
                            z6 = z && FocusInteractionKt.collectIsFocusedAsState(mutableInteractionSource2, composer2, (i30 >> 15) & 14).getValue().booleanValue();
                            Boolean valueOf = Boolean.valueOf(z);
                            composer2.startReplaceableGroup(851482799);
                            ComposerKt.sourceInformation(composer2, str4);
                            changed4 = composer2.changed(z6) | composer2.changedInstance(focusManager);
                            rememberedValue7 = composer2.rememberedValue();
                            if (!changed4 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue7 = new SearchBar_androidKt$SearchBar$5$1(z6, focusManager, null);
                                composer2.updateRememberedValue(rememberedValue7);
                            }
                            composer2.endReplaceableGroup();
                            int i32 = (i29 >> 9) & 14;
                            EffectsKt.LaunchedEffect(valueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue7, composer2, i32);
                            composer2.startReplaceableGroup(851483127);
                            ComposerKt.sourceInformation(composer2, str4);
                            z7 = (i29 & 57344) == 16384;
                            rememberedValue8 = composer2.rememberedValue();
                            if (!z7 || rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue8 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$6$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(0);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke() {
                                        m2853invoke();
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: collision with other method in class */
                                    public final void m2853invoke() {
                                        function13.invoke(false);
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue8);
                            }
                            composer2.endReplaceableGroup();
                            BackHandlerKt.BackHandler(z, (Function0) rememberedValue8, composer2, i32, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function29 = function28;
                            searchBarColors4 = searchBarColors3;
                            f5 = f3;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            z8 = z4;
                            function210 = function25;
                            function211 = function26;
                            windowInsets4 = windowInsets5;
                            shape4 = shape6;
                            modifier3 = modifier5;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            final float f6 = f4;
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$7
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

                                public final void invoke(Composer composer3, int i33) {
                                    SearchBar_androidKt.m2849SearchBarWuY5d9Q(str, function1, function12, z, function13, modifier3, z8, function210, function211, function29, shape4, searchBarColors4, f5, f6, windowInsets4, mutableInteractionSource3, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i16 = i14;
                    if ((i3 & 65536) != 0) {
                    }
                    int i272 = i4;
                    if ((i4 & 306783379) != 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i7 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if ((i3 & Fields.RotationZ) != 0) {
                    }
                    int i282 = i26;
                    if ((i3 & Fields.CameraDistance) != 0) {
                    }
                    if (i19 != 0) {
                    }
                    if (i18 != 0) {
                    }
                    if ((i3 & Fields.Clip) != 0) {
                    }
                    if (i15 != 0) {
                    }
                    i20 = i282;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    animateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, z ? AnimationEnterFloatSpec : AnimationExitFloatSpec, 0.0f, null, null, startRestartGroup, 0, 28);
                    ProvidableCompositionLocal localFocusManager2 = CompositionLocalsKt.getLocalFocusManager();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume3 = startRestartGroup.consume(localFocusManager2);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    FocusManager focusManager2 = (FocusManager) consume3;
                    ProvidableCompositionLocal localDensity2 = CompositionLocalsKt.getLocalDensity();
                    int i292 = i21;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume22 = startRestartGroup.consume(localDensity2);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    density = (Density) consume22;
                    inputFieldShape = SearchBarDefaults.INSTANCE.getInputFieldShape(startRestartGroup, 6);
                    fullScreenShape = SearchBarDefaults.INSTANCE.getFullScreenShape(startRestartGroup, 6);
                    startRestartGroup.startReplaceableGroup(851478497);
                    ComposerKt.sourceInformation(startRestartGroup, str3);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                    }
                    state = (State) rememberedValue;
                    startRestartGroup.endReplaceableGroup();
                    boolean SearchBar_WuY5d9Q$lambda$22 = SearchBar_WuY5d9Q$lambda$2(state);
                    startRestartGroup.startReplaceableGroup(851478623);
                    ComposerKt.sourceInformation(startRestartGroup, str3);
                    changed = startRestartGroup.changed(SearchBar_WuY5d9Q$lambda$22) | ((((i20 & 14) ^ 6) <= 4 && startRestartGroup.changed(shape3)) || (i20 & 6) == 4);
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (!changed) {
                    }
                    if (Intrinsics.areEqual(shape3, inputFieldShape)) {
                    }
                    startRestartGroup.updateRememberedValue(genericShape);
                    rememberedValue2 = genericShape;
                    Shape shape52 = (Shape) rememberedValue2;
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.startReplaceableGroup(851479649);
                    ComposerKt.sourceInformation(startRestartGroup, str3);
                    rememberedValue3 = startRestartGroup.rememberedValue();
                    if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    }
                    final MutableWindowInsets mutableWindowInsets2 = (MutableWindowInsets) rememberedValue3;
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.startReplaceableGroup(851479705);
                    ComposerKt.sourceInformation(startRestartGroup, str3);
                    changed2 = startRestartGroup.changed(density);
                    rememberedValue4 = startRestartGroup.rememberedValue();
                    if (!changed2) {
                    }
                    rememberedValue4 = SnapshotStateKt.derivedStateOf(new Function0<Dp>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$topPadding$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            return Dp.box-impl(m2855invokeD9Ej5fM());
                        }

                        /* renamed from: invoke-D9Ej5fM, reason: not valid java name */
                        public final float m2855invokeD9Ej5fM() {
                            return Dp.constructor-impl(SearchBar_androidKt.getSearchBarVerticalPadding() + WindowInsetsKt.asPaddingValues(MutableWindowInsets.this, density).getTop());
                        }
                    });
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                    final State<Dp> state22 = (State) rememberedValue4;
                    startRestartGroup.endReplaceableGroup();
                    long containerColor2 = searchBarColors3.getContainerColor();
                    long m2381contentColorForek8zF_U2 = ColorSchemeKt.m2381contentColorForek8zF_U(searchBarColors3.getContainerColor(), startRestartGroup, 0);
                    Modifier zIndex2 = ZIndexModifierKt.zIndex(modifier2, 1.0f);
                    startRestartGroup.startReplaceableGroup(851480211);
                    ComposerKt.sourceInformation(startRestartGroup, str3);
                    if (((57344 & i20) ^ 24576) <= 16384) {
                    }
                    rememberedValue5 = startRestartGroup.rememberedValue();
                    if (!z5) {
                    }
                    rememberedValue5 = (Function1) new Function1<WindowInsets, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$2$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((WindowInsets) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(WindowInsets windowInsets52) {
                            MutableWindowInsets.this.setInsets(WindowInsetsKt.exclude(windowInsets3, windowInsets52));
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                    startRestartGroup.endReplaceableGroup();
                    Modifier consumeWindowInsets2 = WindowInsetsPaddingKt.consumeWindowInsets(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(zIndex2, (Function1) rememberedValue5), mutableWindowInsets2);
                    startRestartGroup.startReplaceableGroup(851480395);
                    ComposerKt.sourceInformation(startRestartGroup, str3);
                    changed3 = startRestartGroup.changed(state22) | startRestartGroup.changed(animateFloatAsState);
                    rememberedValue6 = startRestartGroup.rememberedValue();
                    if (!changed3) {
                    }
                    rememberedValue6 = (Function3) new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$3$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                            return m2851invoke3p2s80s((MeasureScope) obj, (Measurable) obj2, ((Constraints) obj3).unbox-impl());
                        }

                        /* renamed from: invoke-3p2s80s, reason: not valid java name */
                        public final MeasureResult m2851invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
                            float f62;
                            final int i302 = measureScope.roundToPx-0680j_4(DpKt.lerp-Md-fbLM(state22.getValue().unbox-impl(), Dp.constructor-impl(0), animateFloatAsState.getValue().floatValue()));
                            int max = Math.max(Constraints.getMinWidth-impl(j), measureScope.roundToPx-0680j_4(SearchBar_androidKt.getSearchBarMinWidth()));
                            int i312 = Constraints.getMaxWidth-impl(j);
                            f62 = SearchBar_androidKt.SearchBarMaxWidth;
                            int coerceAtMost = RangesKt.coerceAtMost(max, Math.min(i312, measureScope.roundToPx-0680j_4(f62)));
                            int coerceAtMost2 = RangesKt.coerceAtMost(Math.max(Constraints.getMinHeight-impl(j), measureScope.roundToPx-0680j_4(SearchBarDefaults.INSTANCE.m2843getInputFieldHeightD9Ej5fM())), Constraints.getMaxHeight-impl(j));
                            int i322 = Constraints.getMaxWidth-impl(j);
                            int i33 = Constraints.getMaxHeight-impl(j);
                            int lerp = MathHelpersKt.lerp(coerceAtMost, i322, animateFloatAsState.getValue().floatValue());
                            int lerp2 = MathHelpersKt.lerp(coerceAtMost2, i33, animateFloatAsState.getValue().floatValue()) + i302;
                            final Placeable mo6318measureBRTryo0 = measurable.mo6318measureBRTryo0(ConstraintsKt.offset-NN6Ew-U$default(Constraints.Companion.fixed-JhjzzOo(lerp, lerp2), 0, -i302, 1, (Object) null));
                            return MeasureScope.layout$default(measureScope, lerp, lerp2, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$3$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((Placeable.PlacementScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Placeable.PlacementScope placementScope) {
                                    Placeable.PlacementScope.placeRelative$default(placementScope, Placeable.this, 0, i302, 0.0f, 4, null);
                                }
                            }, 4, null);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue6);
                    startRestartGroup.endReplaceableGroup();
                    int i302 = i20;
                    WindowInsets windowInsets52 = windowInsets3;
                    final boolean z92 = z4;
                    Shape shape62 = shape3;
                    final Function2<? super Composer, ? super Integer, Unit> function2132 = function25;
                    Modifier modifier52 = modifier2;
                    final Function2<? super Composer, ? super Integer, Unit> function2142 = function26;
                    String str42 = str3;
                    final Function2<? super Composer, ? super Integer, Unit> function2152 = function28;
                    final SearchBarColors searchBarColors52 = searchBarColors3;
                    final MutableInteractionSource mutableInteractionSource42 = mutableInteractionSource2;
                    composer2 = startRestartGroup;
                    int i312 = i302 << 6;
                    SurfaceKt.m3043SurfaceT9BRK9s(LayoutModifierKt.layout(consumeWindowInsets2, (Function3) rememberedValue6), shape52, containerColor2, m2381contentColorForek8zF_U2, f3, f4, null, ComposableLambdaKt.composableLambda(composer2, 483163116, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$4
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

                        public final void invoke(Composer composer3, int i322) {
                            final State<Float> state3;
                            ComposerKt.sourceInformation(composer3, "C253@12638L1152:SearchBar.android.kt#uh7d8r");
                            if ((i322 & 3) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(483163116, i322, -1, "androidx.compose.material3.SearchBar.<anonymous> (SearchBar.android.kt:253)");
                                }
                                String str5 = str;
                                Function1<String, Unit> function14 = function1;
                                Function1<String, Unit> function15 = function12;
                                boolean z10 = z;
                                Function1<Boolean, Unit> function16 = function13;
                                boolean z11 = z92;
                                Function2<Composer, Integer, Unit> function216 = function2132;
                                Function2<Composer, Integer, Unit> function217 = function2142;
                                Function2<Composer, Integer, Unit> function218 = function2152;
                                SearchBarColors searchBarColors6 = searchBarColors52;
                                MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource42;
                                State<Float> state4 = animateFloatAsState;
                                State<Dp> state5 = state22;
                                Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                                composer3.startReplaceableGroup(-483455358);
                                ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                Modifier.Companion companion = Modifier.INSTANCE;
                                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                                composer3.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
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
                                ComposerKt.sourceInformationMarkerStart(composer3, -685095315, "C254@12691L93,257@12797L590,272@13420L115:SearchBar.android.kt#uh7d8r");
                                composer3.startReplaceableGroup(-685095283);
                                ComposerKt.sourceInformation(composer3, "CC(remember):SearchBar.android.kt#9igjgp");
                                Object rememberedValue10 = composer3.rememberedValue();
                                if (rememberedValue10 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue10 = new AnimatedPaddingValues(state4, state5);
                                    composer3.updateRememberedValue(rememberedValue10);
                                }
                                composer3.endReplaceableGroup();
                                SearchBar_androidKt.SearchBarInputField(str5, function14, function15, z10, function16, PaddingKt.padding(Modifier.INSTANCE, (AnimatedPaddingValues) rememberedValue10), z11, function216, function217, function218, searchBarColors6.getInputFieldColors(), mutableInteractionSource5, composer3, 196608, 0, 0);
                                composer3.startReplaceableGroup(-685094554);
                                ComposerKt.sourceInformation(composer3, "CC(remember):SearchBar.android.kt#9igjgp");
                                Object rememberedValue11 = composer3.rememberedValue();
                                if (rememberedValue11 == Composer.INSTANCE.getEmpty()) {
                                    state3 = state4;
                                    rememberedValue11 = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0<Boolean>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$4$1$showResults$2$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                        public final Boolean m2852invoke() {
                                            return Boolean.valueOf(state3.getValue().floatValue() > 0.0f);
                                        }
                                    });
                                    composer3.updateRememberedValue(rememberedValue11);
                                } else {
                                    state3 = state4;
                                }
                                composer3.endReplaceableGroup();
                                composer3.startReplaceableGroup(551421253);
                                ComposerKt.sourceInformation(composer3, "276@13613L35,276@13583L183");
                                if (invoke$lambda$5$lambda$2((State) rememberedValue11)) {
                                    Modifier.Companion companion2 = Modifier.INSTANCE;
                                    composer3.startReplaceableGroup(-685094361);
                                    ComposerKt.sourceInformation(composer3, "CC(remember):SearchBar.android.kt#9igjgp");
                                    boolean changed5 = composer3.changed(state3);
                                    Object rememberedValue12 = composer3.rememberedValue();
                                    if (changed5 || rememberedValue12 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue12 = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$4$1$1$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                invoke((GraphicsLayerScope) obj);
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                                                graphicsLayerScope.setAlpha(state3.getValue().floatValue());
                                            }
                                        };
                                        composer3.updateRememberedValue(rememberedValue12);
                                    }
                                    composer3.endReplaceableGroup();
                                    Modifier graphicsLayer = GraphicsLayerModifierKt.graphicsLayer(companion2, (Function1) rememberedValue12);
                                    composer3.startReplaceableGroup(-483455358);
                                    ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                    MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                                    composer3.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                    CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                    Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(graphicsLayer);
                                    if (!(composer3.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer3.startReusableNode();
                                    if (composer3.getInserting()) {
                                        composer3.createNode(constructor2);
                                    } else {
                                        composer3.useNode();
                                    }
                                    Composer m4109constructorimpl2 = Updater.m4109constructorimpl(composer3);
                                    Updater.m4116setimpl(m4109constructorimpl2, columnMeasurePolicy2, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                    Updater.m4116setimpl(m4109constructorimpl2, currentCompositionLocalMap2, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                    Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                    if (m4109constructorimpl2.getInserting() || !Intrinsics.areEqual(m4109constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                        m4109constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                        m4109constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                    }
                                    modifierMaterializerOf2.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer3)), composer3, 0);
                                    composer3.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                    ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer3, 1234675075, "C277@13672L46,278@13739L9:SearchBar.android.kt#uh7d8r");
                                    DividerKt.m2540HorizontalDivider9IZ8Weo(null, 0.0f, searchBarColors6.getDividerColor(), composer3, 0, 3);
                                    function32.invoke(columnScopeInstance2, composer3, 6);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    composer3.endReplaceableGroup();
                                    composer3.endNode();
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                }
                                composer3.endReplaceableGroup();
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

                        private static final boolean invoke$lambda$5$lambda$2(State<Boolean> state3) {
                            return state3.getValue().booleanValue();
                        }
                    }), composer2, (57344 & i312) | 12582912 | (i312 & 458752), 64);
                    if (z) {
                    }
                    Boolean valueOf2 = Boolean.valueOf(z);
                    composer2.startReplaceableGroup(851482799);
                    ComposerKt.sourceInformation(composer2, str42);
                    changed4 = composer2.changed(z6) | composer2.changedInstance(focusManager2);
                    rememberedValue7 = composer2.rememberedValue();
                    if (!changed4) {
                    }
                    rememberedValue7 = new SearchBar_androidKt$SearchBar$5$1(z6, focusManager2, null);
                    composer2.updateRememberedValue(rememberedValue7);
                    composer2.endReplaceableGroup();
                    int i322 = (i292 >> 9) & 14;
                    EffectsKt.LaunchedEffect(valueOf2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue7, composer2, i322);
                    composer2.startReplaceableGroup(851483127);
                    ComposerKt.sourceInformation(composer2, str42);
                    if ((i292 & 57344) == 16384) {
                    }
                    rememberedValue8 = composer2.rememberedValue();
                    if (!z7) {
                    }
                    rememberedValue8 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$6$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m2853invoke();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: collision with other method in class */
                        public final void m2853invoke() {
                            function13.invoke(false);
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue8);
                    composer2.endReplaceableGroup();
                    BackHandlerKt.BackHandler(z, (Function0) rememberedValue8, composer2, i322, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    function29 = function28;
                    searchBarColors4 = searchBarColors3;
                    f5 = f3;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    z8 = z4;
                    function210 = function25;
                    function211 = function26;
                    windowInsets4 = windowInsets52;
                    shape4 = shape62;
                    modifier3 = modifier52;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                if ((i2 & 24576) == 0) {
                }
                i15 = i3 & Fields.CompositingStrategy;
                if (i15 == 0) {
                }
                i16 = i14;
                if ((i3 & 65536) != 0) {
                }
                int i2722 = i4;
                if ((i4 & 306783379) != 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i7 != 0) {
                }
                if (i8 != 0) {
                }
                if (i9 != 0) {
                }
                if (i10 != 0) {
                }
                if (i11 != 0) {
                }
                if ((i3 & Fields.RotationZ) != 0) {
                }
                int i2822 = i26;
                if ((i3 & Fields.CameraDistance) != 0) {
                }
                if (i19 != 0) {
                }
                if (i18 != 0) {
                }
                if ((i3 & Fields.Clip) != 0) {
                }
                if (i15 != 0) {
                }
                i20 = i2822;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                animateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, z ? AnimationEnterFloatSpec : AnimationExitFloatSpec, 0.0f, null, null, startRestartGroup, 0, 28);
                ProvidableCompositionLocal localFocusManager22 = CompositionLocalsKt.getLocalFocusManager();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume32 = startRestartGroup.consume(localFocusManager22);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                FocusManager focusManager22 = (FocusManager) consume32;
                ProvidableCompositionLocal localDensity22 = CompositionLocalsKt.getLocalDensity();
                int i2922 = i21;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume222 = startRestartGroup.consume(localDensity22);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                density = (Density) consume222;
                inputFieldShape = SearchBarDefaults.INSTANCE.getInputFieldShape(startRestartGroup, 6);
                fullScreenShape = SearchBarDefaults.INSTANCE.getFullScreenShape(startRestartGroup, 6);
                startRestartGroup.startReplaceableGroup(851478497);
                ComposerKt.sourceInformation(startRestartGroup, str3);
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                }
                state = (State) rememberedValue;
                startRestartGroup.endReplaceableGroup();
                boolean SearchBar_WuY5d9Q$lambda$222 = SearchBar_WuY5d9Q$lambda$2(state);
                startRestartGroup.startReplaceableGroup(851478623);
                ComposerKt.sourceInformation(startRestartGroup, str3);
                changed = startRestartGroup.changed(SearchBar_WuY5d9Q$lambda$222) | ((((i20 & 14) ^ 6) <= 4 && startRestartGroup.changed(shape3)) || (i20 & 6) == 4);
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                if (Intrinsics.areEqual(shape3, inputFieldShape)) {
                }
                startRestartGroup.updateRememberedValue(genericShape);
                rememberedValue2 = genericShape;
                Shape shape522 = (Shape) rememberedValue2;
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(851479649);
                ComposerKt.sourceInformation(startRestartGroup, str3);
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                }
                final MutableWindowInsets mutableWindowInsets22 = (MutableWindowInsets) rememberedValue3;
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(851479705);
                ComposerKt.sourceInformation(startRestartGroup, str3);
                changed2 = startRestartGroup.changed(density);
                rememberedValue4 = startRestartGroup.rememberedValue();
                if (!changed2) {
                }
                rememberedValue4 = SnapshotStateKt.derivedStateOf(new Function0<Dp>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$topPadding$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        return Dp.box-impl(m2855invokeD9Ej5fM());
                    }

                    /* renamed from: invoke-D9Ej5fM, reason: not valid java name */
                    public final float m2855invokeD9Ej5fM() {
                        return Dp.constructor-impl(SearchBar_androidKt.getSearchBarVerticalPadding() + WindowInsetsKt.asPaddingValues(MutableWindowInsets.this, density).getTop());
                    }
                });
                startRestartGroup.updateRememberedValue(rememberedValue4);
                final State<Dp> state222 = (State) rememberedValue4;
                startRestartGroup.endReplaceableGroup();
                long containerColor22 = searchBarColors3.getContainerColor();
                long m2381contentColorForek8zF_U22 = ColorSchemeKt.m2381contentColorForek8zF_U(searchBarColors3.getContainerColor(), startRestartGroup, 0);
                Modifier zIndex22 = ZIndexModifierKt.zIndex(modifier2, 1.0f);
                startRestartGroup.startReplaceableGroup(851480211);
                ComposerKt.sourceInformation(startRestartGroup, str3);
                if (((57344 & i20) ^ 24576) <= 16384) {
                }
                rememberedValue5 = startRestartGroup.rememberedValue();
                if (!z5) {
                }
                rememberedValue5 = (Function1) new Function1<WindowInsets, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$2$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((WindowInsets) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(WindowInsets windowInsets522) {
                        MutableWindowInsets.this.setInsets(WindowInsetsKt.exclude(windowInsets3, windowInsets522));
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue5);
                startRestartGroup.endReplaceableGroup();
                Modifier consumeWindowInsets22 = WindowInsetsPaddingKt.consumeWindowInsets(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(zIndex22, (Function1) rememberedValue5), mutableWindowInsets22);
                startRestartGroup.startReplaceableGroup(851480395);
                ComposerKt.sourceInformation(startRestartGroup, str3);
                changed3 = startRestartGroup.changed(state222) | startRestartGroup.changed(animateFloatAsState);
                rememberedValue6 = startRestartGroup.rememberedValue();
                if (!changed3) {
                }
                rememberedValue6 = (Function3) new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$3$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        return m2851invoke3p2s80s((MeasureScope) obj, (Measurable) obj2, ((Constraints) obj3).unbox-impl());
                    }

                    /* renamed from: invoke-3p2s80s, reason: not valid java name */
                    public final MeasureResult m2851invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
                        float f62;
                        final int i3022 = measureScope.roundToPx-0680j_4(DpKt.lerp-Md-fbLM(state222.getValue().unbox-impl(), Dp.constructor-impl(0), animateFloatAsState.getValue().floatValue()));
                        int max = Math.max(Constraints.getMinWidth-impl(j), measureScope.roundToPx-0680j_4(SearchBar_androidKt.getSearchBarMinWidth()));
                        int i3122 = Constraints.getMaxWidth-impl(j);
                        f62 = SearchBar_androidKt.SearchBarMaxWidth;
                        int coerceAtMost = RangesKt.coerceAtMost(max, Math.min(i3122, measureScope.roundToPx-0680j_4(f62)));
                        int coerceAtMost2 = RangesKt.coerceAtMost(Math.max(Constraints.getMinHeight-impl(j), measureScope.roundToPx-0680j_4(SearchBarDefaults.INSTANCE.m2843getInputFieldHeightD9Ej5fM())), Constraints.getMaxHeight-impl(j));
                        int i3222 = Constraints.getMaxWidth-impl(j);
                        int i33 = Constraints.getMaxHeight-impl(j);
                        int lerp = MathHelpersKt.lerp(coerceAtMost, i3222, animateFloatAsState.getValue().floatValue());
                        int lerp2 = MathHelpersKt.lerp(coerceAtMost2, i33, animateFloatAsState.getValue().floatValue()) + i3022;
                        final Placeable mo6318measureBRTryo0 = measurable.mo6318measureBRTryo0(ConstraintsKt.offset-NN6Ew-U$default(Constraints.Companion.fixed-JhjzzOo(lerp, lerp2), 0, -i3022, 1, (Object) null));
                        return MeasureScope.layout$default(measureScope, lerp, lerp2, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$3$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((Placeable.PlacementScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Placeable.PlacementScope placementScope) {
                                Placeable.PlacementScope.placeRelative$default(placementScope, Placeable.this, 0, i3022, 0.0f, 4, null);
                            }
                        }, 4, null);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue6);
                startRestartGroup.endReplaceableGroup();
                int i3022 = i20;
                WindowInsets windowInsets522 = windowInsets3;
                final boolean z922 = z4;
                Shape shape622 = shape3;
                final Function2<? super Composer, ? super Integer, Unit> function21322 = function25;
                Modifier modifier522 = modifier2;
                final Function2<? super Composer, ? super Integer, Unit> function21422 = function26;
                String str422 = str3;
                final Function2<? super Composer, ? super Integer, Unit> function21522 = function28;
                final SearchBarColors searchBarColors522 = searchBarColors3;
                final MutableInteractionSource mutableInteractionSource422 = mutableInteractionSource2;
                composer2 = startRestartGroup;
                int i3122 = i3022 << 6;
                SurfaceKt.m3043SurfaceT9BRK9s(LayoutModifierKt.layout(consumeWindowInsets22, (Function3) rememberedValue6), shape522, containerColor22, m2381contentColorForek8zF_U22, f3, f4, null, ComposableLambdaKt.composableLambda(composer2, 483163116, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$4
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

                    public final void invoke(Composer composer3, int i3222) {
                        final State<Float> state3;
                        ComposerKt.sourceInformation(composer3, "C253@12638L1152:SearchBar.android.kt#uh7d8r");
                        if ((i3222 & 3) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(483163116, i3222, -1, "androidx.compose.material3.SearchBar.<anonymous> (SearchBar.android.kt:253)");
                            }
                            String str5 = str;
                            Function1<String, Unit> function14 = function1;
                            Function1<String, Unit> function15 = function12;
                            boolean z10 = z;
                            Function1<Boolean, Unit> function16 = function13;
                            boolean z11 = z922;
                            Function2<Composer, Integer, Unit> function216 = function21322;
                            Function2<Composer, Integer, Unit> function217 = function21422;
                            Function2<Composer, Integer, Unit> function218 = function21522;
                            SearchBarColors searchBarColors6 = searchBarColors522;
                            MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource422;
                            State<Float> state4 = animateFloatAsState;
                            State<Dp> state5 = state222;
                            Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                            composer3.startReplaceableGroup(-483455358);
                            ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                            Modifier.Companion companion = Modifier.INSTANCE;
                            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                            composer3.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                            Function0 constructor = ComposeUiNode.Companion.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
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
                            ComposerKt.sourceInformationMarkerStart(composer3, -685095315, "C254@12691L93,257@12797L590,272@13420L115:SearchBar.android.kt#uh7d8r");
                            composer3.startReplaceableGroup(-685095283);
                            ComposerKt.sourceInformation(composer3, "CC(remember):SearchBar.android.kt#9igjgp");
                            Object rememberedValue10 = composer3.rememberedValue();
                            if (rememberedValue10 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue10 = new AnimatedPaddingValues(state4, state5);
                                composer3.updateRememberedValue(rememberedValue10);
                            }
                            composer3.endReplaceableGroup();
                            SearchBar_androidKt.SearchBarInputField(str5, function14, function15, z10, function16, PaddingKt.padding(Modifier.INSTANCE, (AnimatedPaddingValues) rememberedValue10), z11, function216, function217, function218, searchBarColors6.getInputFieldColors(), mutableInteractionSource5, composer3, 196608, 0, 0);
                            composer3.startReplaceableGroup(-685094554);
                            ComposerKt.sourceInformation(composer3, "CC(remember):SearchBar.android.kt#9igjgp");
                            Object rememberedValue11 = composer3.rememberedValue();
                            if (rememberedValue11 == Composer.INSTANCE.getEmpty()) {
                                state3 = state4;
                                rememberedValue11 = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0<Boolean>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$4$1$showResults$2$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                    public final Boolean m2852invoke() {
                                        return Boolean.valueOf(state3.getValue().floatValue() > 0.0f);
                                    }
                                });
                                composer3.updateRememberedValue(rememberedValue11);
                            } else {
                                state3 = state4;
                            }
                            composer3.endReplaceableGroup();
                            composer3.startReplaceableGroup(551421253);
                            ComposerKt.sourceInformation(composer3, "276@13613L35,276@13583L183");
                            if (invoke$lambda$5$lambda$2((State) rememberedValue11)) {
                                Modifier.Companion companion2 = Modifier.INSTANCE;
                                composer3.startReplaceableGroup(-685094361);
                                ComposerKt.sourceInformation(composer3, "CC(remember):SearchBar.android.kt#9igjgp");
                                boolean changed5 = composer3.changed(state3);
                                Object rememberedValue12 = composer3.rememberedValue();
                                if (changed5 || rememberedValue12 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue12 = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$4$1$1$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                            invoke((GraphicsLayerScope) obj);
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                                            graphicsLayerScope.setAlpha(state3.getValue().floatValue());
                                        }
                                    };
                                    composer3.updateRememberedValue(rememberedValue12);
                                }
                                composer3.endReplaceableGroup();
                                Modifier graphicsLayer = GraphicsLayerModifierKt.graphicsLayer(companion2, (Function1) rememberedValue12);
                                composer3.startReplaceableGroup(-483455358);
                                ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                                composer3.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(graphicsLayer);
                                if (!(composer3.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer3.startReusableNode();
                                if (composer3.getInserting()) {
                                    composer3.createNode(constructor2);
                                } else {
                                    composer3.useNode();
                                }
                                Composer m4109constructorimpl2 = Updater.m4109constructorimpl(composer3);
                                Updater.m4116setimpl(m4109constructorimpl2, columnMeasurePolicy2, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.m4116setimpl(m4109constructorimpl2, currentCompositionLocalMap2, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                if (m4109constructorimpl2.getInserting() || !Intrinsics.areEqual(m4109constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                    m4109constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                    m4109constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                }
                                modifierMaterializerOf2.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer3)), composer3, 0);
                                composer3.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer3, 1234675075, "C277@13672L46,278@13739L9:SearchBar.android.kt#uh7d8r");
                                DividerKt.m2540HorizontalDivider9IZ8Weo(null, 0.0f, searchBarColors6.getDividerColor(), composer3, 0, 3);
                                function32.invoke(columnScopeInstance2, composer3, 6);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                composer3.endReplaceableGroup();
                                composer3.endNode();
                                composer3.endReplaceableGroup();
                                composer3.endReplaceableGroup();
                            }
                            composer3.endReplaceableGroup();
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

                    private static final boolean invoke$lambda$5$lambda$2(State<Boolean> state3) {
                        return state3.getValue().booleanValue();
                    }
                }), composer2, (57344 & i3122) | 12582912 | (i3122 & 458752), 64);
                if (z) {
                }
                Boolean valueOf22 = Boolean.valueOf(z);
                composer2.startReplaceableGroup(851482799);
                ComposerKt.sourceInformation(composer2, str422);
                changed4 = composer2.changed(z6) | composer2.changedInstance(focusManager22);
                rememberedValue7 = composer2.rememberedValue();
                if (!changed4) {
                }
                rememberedValue7 = new SearchBar_androidKt$SearchBar$5$1(z6, focusManager22, null);
                composer2.updateRememberedValue(rememberedValue7);
                composer2.endReplaceableGroup();
                int i3222 = (i2922 >> 9) & 14;
                EffectsKt.LaunchedEffect(valueOf22, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue7, composer2, i3222);
                composer2.startReplaceableGroup(851483127);
                ComposerKt.sourceInformation(composer2, str422);
                if ((i2922 & 57344) == 16384) {
                }
                rememberedValue8 = composer2.rememberedValue();
                if (!z7) {
                }
                rememberedValue8 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$6$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m2853invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m2853invoke() {
                        function13.invoke(false);
                    }
                };
                composer2.updateRememberedValue(rememberedValue8);
                composer2.endReplaceableGroup();
                BackHandlerKt.BackHandler(z, (Function0) rememberedValue8, composer2, i3222, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                function29 = function28;
                searchBarColors4 = searchBarColors3;
                f5 = f3;
                mutableInteractionSource3 = mutableInteractionSource2;
                z8 = z4;
                function210 = function25;
                function211 = function26;
                windowInsets4 = windowInsets522;
                shape4 = shape622;
                modifier3 = modifier522;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i14 = i3 & Fields.Shape;
            if (i14 != 0) {
            }
            if ((i2 & 24576) == 0) {
            }
            i15 = i3 & Fields.CompositingStrategy;
            if (i15 == 0) {
            }
            i16 = i14;
            if ((i3 & 65536) != 0) {
            }
            int i27222 = i4;
            if ((i4 & 306783379) != 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i7 != 0) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
            if (i10 != 0) {
            }
            if (i11 != 0) {
            }
            if ((i3 & Fields.RotationZ) != 0) {
            }
            int i28222 = i26;
            if ((i3 & Fields.CameraDistance) != 0) {
            }
            if (i19 != 0) {
            }
            if (i18 != 0) {
            }
            if ((i3 & Fields.Clip) != 0) {
            }
            if (i15 != 0) {
            }
            i20 = i28222;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            animateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, z ? AnimationEnterFloatSpec : AnimationExitFloatSpec, 0.0f, null, null, startRestartGroup, 0, 28);
            ProvidableCompositionLocal localFocusManager222 = CompositionLocalsKt.getLocalFocusManager();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume322 = startRestartGroup.consume(localFocusManager222);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            FocusManager focusManager222 = (FocusManager) consume322;
            ProvidableCompositionLocal localDensity222 = CompositionLocalsKt.getLocalDensity();
            int i29222 = i21;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2222 = startRestartGroup.consume(localDensity222);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            density = (Density) consume2222;
            inputFieldShape = SearchBarDefaults.INSTANCE.getInputFieldShape(startRestartGroup, 6);
            fullScreenShape = SearchBarDefaults.INSTANCE.getFullScreenShape(startRestartGroup, 6);
            startRestartGroup.startReplaceableGroup(851478497);
            ComposerKt.sourceInformation(startRestartGroup, str3);
            rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            }
            state = (State) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            boolean SearchBar_WuY5d9Q$lambda$2222 = SearchBar_WuY5d9Q$lambda$2(state);
            startRestartGroup.startReplaceableGroup(851478623);
            ComposerKt.sourceInformation(startRestartGroup, str3);
            changed = startRestartGroup.changed(SearchBar_WuY5d9Q$lambda$2222) | ((((i20 & 14) ^ 6) <= 4 && startRestartGroup.changed(shape3)) || (i20 & 6) == 4);
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            if (Intrinsics.areEqual(shape3, inputFieldShape)) {
            }
            startRestartGroup.updateRememberedValue(genericShape);
            rememberedValue2 = genericShape;
            Shape shape5222 = (Shape) rememberedValue2;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(851479649);
            ComposerKt.sourceInformation(startRestartGroup, str3);
            rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
            }
            final MutableWindowInsets mutableWindowInsets222 = (MutableWindowInsets) rememberedValue3;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(851479705);
            ComposerKt.sourceInformation(startRestartGroup, str3);
            changed2 = startRestartGroup.changed(density);
            rememberedValue4 = startRestartGroup.rememberedValue();
            if (!changed2) {
            }
            rememberedValue4 = SnapshotStateKt.derivedStateOf(new Function0<Dp>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$topPadding$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    return Dp.box-impl(m2855invokeD9Ej5fM());
                }

                /* renamed from: invoke-D9Ej5fM, reason: not valid java name */
                public final float m2855invokeD9Ej5fM() {
                    return Dp.constructor-impl(SearchBar_androidKt.getSearchBarVerticalPadding() + WindowInsetsKt.asPaddingValues(MutableWindowInsets.this, density).getTop());
                }
            });
            startRestartGroup.updateRememberedValue(rememberedValue4);
            final State<Dp> state2222 = (State) rememberedValue4;
            startRestartGroup.endReplaceableGroup();
            long containerColor222 = searchBarColors3.getContainerColor();
            long m2381contentColorForek8zF_U222 = ColorSchemeKt.m2381contentColorForek8zF_U(searchBarColors3.getContainerColor(), startRestartGroup, 0);
            Modifier zIndex222 = ZIndexModifierKt.zIndex(modifier2, 1.0f);
            startRestartGroup.startReplaceableGroup(851480211);
            ComposerKt.sourceInformation(startRestartGroup, str3);
            if (((57344 & i20) ^ 24576) <= 16384) {
            }
            rememberedValue5 = startRestartGroup.rememberedValue();
            if (!z5) {
            }
            rememberedValue5 = (Function1) new Function1<WindowInsets, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((WindowInsets) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(WindowInsets windowInsets5222) {
                    MutableWindowInsets.this.setInsets(WindowInsetsKt.exclude(windowInsets3, windowInsets5222));
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue5);
            startRestartGroup.endReplaceableGroup();
            Modifier consumeWindowInsets222 = WindowInsetsPaddingKt.consumeWindowInsets(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(zIndex222, (Function1) rememberedValue5), mutableWindowInsets222);
            startRestartGroup.startReplaceableGroup(851480395);
            ComposerKt.sourceInformation(startRestartGroup, str3);
            changed3 = startRestartGroup.changed(state2222) | startRestartGroup.changed(animateFloatAsState);
            rememberedValue6 = startRestartGroup.rememberedValue();
            if (!changed3) {
            }
            rememberedValue6 = (Function3) new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$3$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    return m2851invoke3p2s80s((MeasureScope) obj, (Measurable) obj2, ((Constraints) obj3).unbox-impl());
                }

                /* renamed from: invoke-3p2s80s, reason: not valid java name */
                public final MeasureResult m2851invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
                    float f62;
                    final int i30222 = measureScope.roundToPx-0680j_4(DpKt.lerp-Md-fbLM(state2222.getValue().unbox-impl(), Dp.constructor-impl(0), animateFloatAsState.getValue().floatValue()));
                    int max = Math.max(Constraints.getMinWidth-impl(j), measureScope.roundToPx-0680j_4(SearchBar_androidKt.getSearchBarMinWidth()));
                    int i31222 = Constraints.getMaxWidth-impl(j);
                    f62 = SearchBar_androidKt.SearchBarMaxWidth;
                    int coerceAtMost = RangesKt.coerceAtMost(max, Math.min(i31222, measureScope.roundToPx-0680j_4(f62)));
                    int coerceAtMost2 = RangesKt.coerceAtMost(Math.max(Constraints.getMinHeight-impl(j), measureScope.roundToPx-0680j_4(SearchBarDefaults.INSTANCE.m2843getInputFieldHeightD9Ej5fM())), Constraints.getMaxHeight-impl(j));
                    int i32222 = Constraints.getMaxWidth-impl(j);
                    int i33 = Constraints.getMaxHeight-impl(j);
                    int lerp = MathHelpersKt.lerp(coerceAtMost, i32222, animateFloatAsState.getValue().floatValue());
                    int lerp2 = MathHelpersKt.lerp(coerceAtMost2, i33, animateFloatAsState.getValue().floatValue()) + i30222;
                    final Placeable mo6318measureBRTryo0 = measurable.mo6318measureBRTryo0(ConstraintsKt.offset-NN6Ew-U$default(Constraints.Companion.fixed-JhjzzOo(lerp, lerp2), 0, -i30222, 1, (Object) null));
                    return MeasureScope.layout$default(measureScope, lerp, lerp2, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$3$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((Placeable.PlacementScope) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Placeable.PlacementScope placementScope) {
                            Placeable.PlacementScope.placeRelative$default(placementScope, Placeable.this, 0, i30222, 0.0f, 4, null);
                        }
                    }, 4, null);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue6);
            startRestartGroup.endReplaceableGroup();
            int i30222 = i20;
            WindowInsets windowInsets5222 = windowInsets3;
            final boolean z9222 = z4;
            Shape shape6222 = shape3;
            final Function2<? super Composer, ? super Integer, Unit> function213222 = function25;
            Modifier modifier5222 = modifier2;
            final Function2<? super Composer, ? super Integer, Unit> function214222 = function26;
            String str4222 = str3;
            final Function2<? super Composer, ? super Integer, Unit> function215222 = function28;
            final SearchBarColors searchBarColors5222 = searchBarColors3;
            final MutableInteractionSource mutableInteractionSource4222 = mutableInteractionSource2;
            composer2 = startRestartGroup;
            int i31222 = i30222 << 6;
            SurfaceKt.m3043SurfaceT9BRK9s(LayoutModifierKt.layout(consumeWindowInsets222, (Function3) rememberedValue6), shape5222, containerColor222, m2381contentColorForek8zF_U222, f3, f4, null, ComposableLambdaKt.composableLambda(composer2, 483163116, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$4
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

                public final void invoke(Composer composer3, int i32222) {
                    final State<Float> state3;
                    ComposerKt.sourceInformation(composer3, "C253@12638L1152:SearchBar.android.kt#uh7d8r");
                    if ((i32222 & 3) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(483163116, i32222, -1, "androidx.compose.material3.SearchBar.<anonymous> (SearchBar.android.kt:253)");
                        }
                        String str5 = str;
                        Function1<String, Unit> function14 = function1;
                        Function1<String, Unit> function15 = function12;
                        boolean z10 = z;
                        Function1<Boolean, Unit> function16 = function13;
                        boolean z11 = z9222;
                        Function2<Composer, Integer, Unit> function216 = function213222;
                        Function2<Composer, Integer, Unit> function217 = function214222;
                        Function2<Composer, Integer, Unit> function218 = function215222;
                        SearchBarColors searchBarColors6 = searchBarColors5222;
                        MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource4222;
                        State<Float> state4 = animateFloatAsState;
                        State<Dp> state5 = state2222;
                        Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                        composer3.startReplaceableGroup(-483455358);
                        ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                        Modifier.Companion companion = Modifier.INSTANCE;
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                        Function0 constructor = ComposeUiNode.Companion.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
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
                        ComposerKt.sourceInformationMarkerStart(composer3, -685095315, "C254@12691L93,257@12797L590,272@13420L115:SearchBar.android.kt#uh7d8r");
                        composer3.startReplaceableGroup(-685095283);
                        ComposerKt.sourceInformation(composer3, "CC(remember):SearchBar.android.kt#9igjgp");
                        Object rememberedValue10 = composer3.rememberedValue();
                        if (rememberedValue10 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue10 = new AnimatedPaddingValues(state4, state5);
                            composer3.updateRememberedValue(rememberedValue10);
                        }
                        composer3.endReplaceableGroup();
                        SearchBar_androidKt.SearchBarInputField(str5, function14, function15, z10, function16, PaddingKt.padding(Modifier.INSTANCE, (AnimatedPaddingValues) rememberedValue10), z11, function216, function217, function218, searchBarColors6.getInputFieldColors(), mutableInteractionSource5, composer3, 196608, 0, 0);
                        composer3.startReplaceableGroup(-685094554);
                        ComposerKt.sourceInformation(composer3, "CC(remember):SearchBar.android.kt#9igjgp");
                        Object rememberedValue11 = composer3.rememberedValue();
                        if (rememberedValue11 == Composer.INSTANCE.getEmpty()) {
                            state3 = state4;
                            rememberedValue11 = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0<Boolean>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$4$1$showResults$2$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                public final Boolean m2852invoke() {
                                    return Boolean.valueOf(state3.getValue().floatValue() > 0.0f);
                                }
                            });
                            composer3.updateRememberedValue(rememberedValue11);
                        } else {
                            state3 = state4;
                        }
                        composer3.endReplaceableGroup();
                        composer3.startReplaceableGroup(551421253);
                        ComposerKt.sourceInformation(composer3, "276@13613L35,276@13583L183");
                        if (invoke$lambda$5$lambda$2((State) rememberedValue11)) {
                            Modifier.Companion companion2 = Modifier.INSTANCE;
                            composer3.startReplaceableGroup(-685094361);
                            ComposerKt.sourceInformation(composer3, "CC(remember):SearchBar.android.kt#9igjgp");
                            boolean changed5 = composer3.changed(state3);
                            Object rememberedValue12 = composer3.rememberedValue();
                            if (changed5 || rememberedValue12 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue12 = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$4$1$1$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((GraphicsLayerScope) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                                        graphicsLayerScope.setAlpha(state3.getValue().floatValue());
                                    }
                                };
                                composer3.updateRememberedValue(rememberedValue12);
                            }
                            composer3.endReplaceableGroup();
                            Modifier graphicsLayer = GraphicsLayerModifierKt.graphicsLayer(companion2, (Function1) rememberedValue12);
                            composer3.startReplaceableGroup(-483455358);
                            ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                            composer3.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                            CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(graphicsLayer);
                            if (!(composer3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer3.startReusableNode();
                            if (composer3.getInserting()) {
                                composer3.createNode(constructor2);
                            } else {
                                composer3.useNode();
                            }
                            Composer m4109constructorimpl2 = Updater.m4109constructorimpl(composer3);
                            Updater.m4116setimpl(m4109constructorimpl2, columnMeasurePolicy2, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.m4116setimpl(m4109constructorimpl2, currentCompositionLocalMap2, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (m4109constructorimpl2.getInserting() || !Intrinsics.areEqual(m4109constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                m4109constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                m4109constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                            }
                            modifierMaterializerOf2.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer3)), composer3, 0);
                            composer3.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer3, 1234675075, "C277@13672L46,278@13739L9:SearchBar.android.kt#uh7d8r");
                            DividerKt.m2540HorizontalDivider9IZ8Weo(null, 0.0f, searchBarColors6.getDividerColor(), composer3, 0, 3);
                            function32.invoke(columnScopeInstance2, composer3, 6);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endReplaceableGroup();
                            composer3.endNode();
                            composer3.endReplaceableGroup();
                            composer3.endReplaceableGroup();
                        }
                        composer3.endReplaceableGroup();
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

                private static final boolean invoke$lambda$5$lambda$2(State<Boolean> state3) {
                    return state3.getValue().booleanValue();
                }
            }), composer2, (57344 & i31222) | 12582912 | (i31222 & 458752), 64);
            if (z) {
            }
            Boolean valueOf222 = Boolean.valueOf(z);
            composer2.startReplaceableGroup(851482799);
            ComposerKt.sourceInformation(composer2, str4222);
            changed4 = composer2.changed(z6) | composer2.changedInstance(focusManager222);
            rememberedValue7 = composer2.rememberedValue();
            if (!changed4) {
            }
            rememberedValue7 = new SearchBar_androidKt$SearchBar$5$1(z6, focusManager222, null);
            composer2.updateRememberedValue(rememberedValue7);
            composer2.endReplaceableGroup();
            int i32222 = (i29222 >> 9) & 14;
            EffectsKt.LaunchedEffect(valueOf222, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue7, composer2, i32222);
            composer2.startReplaceableGroup(851483127);
            ComposerKt.sourceInformation(composer2, str4222);
            if ((i29222 & 57344) == 16384) {
            }
            rememberedValue8 = composer2.rememberedValue();
            if (!z7) {
            }
            rememberedValue8 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$6$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m2853invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2853invoke() {
                    function13.invoke(false);
                }
            };
            composer2.updateRememberedValue(rememberedValue8);
            composer2.endReplaceableGroup();
            BackHandlerKt.BackHandler(z, (Function0) rememberedValue8, composer2, i32222, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            function29 = function28;
            searchBarColors4 = searchBarColors3;
            f5 = f3;
            mutableInteractionSource3 = mutableInteractionSource2;
            z8 = z4;
            function210 = function25;
            function211 = function26;
            windowInsets4 = windowInsets5222;
            shape4 = shape6222;
            modifier3 = modifier5222;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i5 = i3 & 8;
        int i242 = Fields.CameraDistance;
        if (i5 == 0) {
        }
        i6 = i3 & 16;
        int i252 = Fields.Shape;
        if (i6 == 0) {
        }
        i7 = i3 & 32;
        if (i7 == 0) {
        }
        i8 = i3 & 64;
        if (i8 == 0) {
        }
        i9 = i3 & Fields.SpotShadowColor;
        if (i9 == 0) {
        }
        i10 = i3 & Fields.RotationX;
        if (i10 == 0) {
        }
        i11 = i3 & Fields.RotationY;
        if (i11 == 0) {
        }
        if ((i2 & 6) != 0) {
        }
        if ((i2 & 48) == 0) {
        }
        int i262 = i12;
        i13 = i3 & Fields.TransformOrigin;
        if (i13 == 0) {
        }
        i14 = i3 & Fields.Shape;
        if (i14 != 0) {
        }
        if ((i2 & 24576) == 0) {
        }
        i15 = i3 & Fields.CompositingStrategy;
        if (i15 == 0) {
        }
        i16 = i14;
        if ((i3 & 65536) != 0) {
        }
        int i272222 = i4;
        if ((i4 & 306783379) != 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i7 != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        if (i10 != 0) {
        }
        if (i11 != 0) {
        }
        if ((i3 & Fields.RotationZ) != 0) {
        }
        int i282222 = i262;
        if ((i3 & Fields.CameraDistance) != 0) {
        }
        if (i19 != 0) {
        }
        if (i18 != 0) {
        }
        if ((i3 & Fields.Clip) != 0) {
        }
        if (i15 != 0) {
        }
        i20 = i282222;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        animateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, z ? AnimationEnterFloatSpec : AnimationExitFloatSpec, 0.0f, null, null, startRestartGroup, 0, 28);
        ProvidableCompositionLocal localFocusManager2222 = CompositionLocalsKt.getLocalFocusManager();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume3222 = startRestartGroup.consume(localFocusManager2222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        FocusManager focusManager2222 = (FocusManager) consume3222;
        ProvidableCompositionLocal localDensity2222 = CompositionLocalsKt.getLocalDensity();
        int i292222 = i21;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume22222 = startRestartGroup.consume(localDensity2222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        density = (Density) consume22222;
        inputFieldShape = SearchBarDefaults.INSTANCE.getInputFieldShape(startRestartGroup, 6);
        fullScreenShape = SearchBarDefaults.INSTANCE.getFullScreenShape(startRestartGroup, 6);
        startRestartGroup.startReplaceableGroup(851478497);
        ComposerKt.sourceInformation(startRestartGroup, str3);
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
        }
        state = (State) rememberedValue;
        startRestartGroup.endReplaceableGroup();
        boolean SearchBar_WuY5d9Q$lambda$22222 = SearchBar_WuY5d9Q$lambda$2(state);
        startRestartGroup.startReplaceableGroup(851478623);
        ComposerKt.sourceInformation(startRestartGroup, str3);
        changed = startRestartGroup.changed(SearchBar_WuY5d9Q$lambda$22222) | ((((i20 & 14) ^ 6) <= 4 && startRestartGroup.changed(shape3)) || (i20 & 6) == 4);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        if (Intrinsics.areEqual(shape3, inputFieldShape)) {
        }
        startRestartGroup.updateRememberedValue(genericShape);
        rememberedValue2 = genericShape;
        Shape shape52222 = (Shape) rememberedValue2;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(851479649);
        ComposerKt.sourceInformation(startRestartGroup, str3);
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
        }
        final MutableWindowInsets mutableWindowInsets2222 = (MutableWindowInsets) rememberedValue3;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(851479705);
        ComposerKt.sourceInformation(startRestartGroup, str3);
        changed2 = startRestartGroup.changed(density);
        rememberedValue4 = startRestartGroup.rememberedValue();
        if (!changed2) {
        }
        rememberedValue4 = SnapshotStateKt.derivedStateOf(new Function0<Dp>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$topPadding$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                return Dp.box-impl(m2855invokeD9Ej5fM());
            }

            /* renamed from: invoke-D9Ej5fM, reason: not valid java name */
            public final float m2855invokeD9Ej5fM() {
                return Dp.constructor-impl(SearchBar_androidKt.getSearchBarVerticalPadding() + WindowInsetsKt.asPaddingValues(MutableWindowInsets.this, density).getTop());
            }
        });
        startRestartGroup.updateRememberedValue(rememberedValue4);
        final State<Dp> state22222 = (State) rememberedValue4;
        startRestartGroup.endReplaceableGroup();
        long containerColor2222 = searchBarColors3.getContainerColor();
        long m2381contentColorForek8zF_U2222 = ColorSchemeKt.m2381contentColorForek8zF_U(searchBarColors3.getContainerColor(), startRestartGroup, 0);
        Modifier zIndex2222 = ZIndexModifierKt.zIndex(modifier2, 1.0f);
        startRestartGroup.startReplaceableGroup(851480211);
        ComposerKt.sourceInformation(startRestartGroup, str3);
        if (((57344 & i20) ^ 24576) <= 16384) {
        }
        rememberedValue5 = startRestartGroup.rememberedValue();
        if (!z5) {
        }
        rememberedValue5 = (Function1) new Function1<WindowInsets, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((WindowInsets) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(WindowInsets windowInsets52222) {
                MutableWindowInsets.this.setInsets(WindowInsetsKt.exclude(windowInsets3, windowInsets52222));
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue5);
        startRestartGroup.endReplaceableGroup();
        Modifier consumeWindowInsets2222 = WindowInsetsPaddingKt.consumeWindowInsets(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(zIndex2222, (Function1) rememberedValue5), mutableWindowInsets2222);
        startRestartGroup.startReplaceableGroup(851480395);
        ComposerKt.sourceInformation(startRestartGroup, str3);
        changed3 = startRestartGroup.changed(state22222) | startRestartGroup.changed(animateFloatAsState);
        rememberedValue6 = startRestartGroup.rememberedValue();
        if (!changed3) {
        }
        rememberedValue6 = (Function3) new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$3$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return m2851invoke3p2s80s((MeasureScope) obj, (Measurable) obj2, ((Constraints) obj3).unbox-impl());
            }

            /* renamed from: invoke-3p2s80s, reason: not valid java name */
            public final MeasureResult m2851invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
                float f62;
                final int i302222 = measureScope.roundToPx-0680j_4(DpKt.lerp-Md-fbLM(state22222.getValue().unbox-impl(), Dp.constructor-impl(0), animateFloatAsState.getValue().floatValue()));
                int max = Math.max(Constraints.getMinWidth-impl(j), measureScope.roundToPx-0680j_4(SearchBar_androidKt.getSearchBarMinWidth()));
                int i312222 = Constraints.getMaxWidth-impl(j);
                f62 = SearchBar_androidKt.SearchBarMaxWidth;
                int coerceAtMost = RangesKt.coerceAtMost(max, Math.min(i312222, measureScope.roundToPx-0680j_4(f62)));
                int coerceAtMost2 = RangesKt.coerceAtMost(Math.max(Constraints.getMinHeight-impl(j), measureScope.roundToPx-0680j_4(SearchBarDefaults.INSTANCE.m2843getInputFieldHeightD9Ej5fM())), Constraints.getMaxHeight-impl(j));
                int i322222 = Constraints.getMaxWidth-impl(j);
                int i33 = Constraints.getMaxHeight-impl(j);
                int lerp = MathHelpersKt.lerp(coerceAtMost, i322222, animateFloatAsState.getValue().floatValue());
                int lerp2 = MathHelpersKt.lerp(coerceAtMost2, i33, animateFloatAsState.getValue().floatValue()) + i302222;
                final Placeable mo6318measureBRTryo0 = measurable.mo6318measureBRTryo0(ConstraintsKt.offset-NN6Ew-U$default(Constraints.Companion.fixed-JhjzzOo(lerp, lerp2), 0, -i302222, 1, (Object) null));
                return MeasureScope.layout$default(measureScope, lerp, lerp2, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$3$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Placeable.PlacementScope) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Placeable.PlacementScope placementScope) {
                        Placeable.PlacementScope.placeRelative$default(placementScope, Placeable.this, 0, i302222, 0.0f, 4, null);
                    }
                }, 4, null);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue6);
        startRestartGroup.endReplaceableGroup();
        int i302222 = i20;
        WindowInsets windowInsets52222 = windowInsets3;
        final boolean z92222 = z4;
        Shape shape62222 = shape3;
        final Function2<? super Composer, ? super Integer, Unit> function2132222 = function25;
        Modifier modifier52222 = modifier2;
        final Function2<? super Composer, ? super Integer, Unit> function2142222 = function26;
        String str42222 = str3;
        final Function2<? super Composer, ? super Integer, Unit> function2152222 = function28;
        final SearchBarColors searchBarColors52222 = searchBarColors3;
        final MutableInteractionSource mutableInteractionSource42222 = mutableInteractionSource2;
        composer2 = startRestartGroup;
        int i312222 = i302222 << 6;
        SurfaceKt.m3043SurfaceT9BRK9s(LayoutModifierKt.layout(consumeWindowInsets2222, (Function3) rememberedValue6), shape52222, containerColor2222, m2381contentColorForek8zF_U2222, f3, f4, null, ComposableLambdaKt.composableLambda(composer2, 483163116, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$4
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

            public final void invoke(Composer composer3, int i322222) {
                final State<Float> state3;
                ComposerKt.sourceInformation(composer3, "C253@12638L1152:SearchBar.android.kt#uh7d8r");
                if ((i322222 & 3) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(483163116, i322222, -1, "androidx.compose.material3.SearchBar.<anonymous> (SearchBar.android.kt:253)");
                    }
                    String str5 = str;
                    Function1<String, Unit> function14 = function1;
                    Function1<String, Unit> function15 = function12;
                    boolean z10 = z;
                    Function1<Boolean, Unit> function16 = function13;
                    boolean z11 = z92222;
                    Function2<Composer, Integer, Unit> function216 = function2132222;
                    Function2<Composer, Integer, Unit> function217 = function2142222;
                    Function2<Composer, Integer, Unit> function218 = function2152222;
                    SearchBarColors searchBarColors6 = searchBarColors52222;
                    MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource42222;
                    State<Float> state4 = animateFloatAsState;
                    State<Dp> state5 = state22222;
                    Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                    composer3.startReplaceableGroup(-483455358);
                    ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                    Modifier.Companion companion = Modifier.INSTANCE;
                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                    Function0 constructor = ComposeUiNode.Companion.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
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
                    ComposerKt.sourceInformationMarkerStart(composer3, -685095315, "C254@12691L93,257@12797L590,272@13420L115:SearchBar.android.kt#uh7d8r");
                    composer3.startReplaceableGroup(-685095283);
                    ComposerKt.sourceInformation(composer3, "CC(remember):SearchBar.android.kt#9igjgp");
                    Object rememberedValue10 = composer3.rememberedValue();
                    if (rememberedValue10 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue10 = new AnimatedPaddingValues(state4, state5);
                        composer3.updateRememberedValue(rememberedValue10);
                    }
                    composer3.endReplaceableGroup();
                    SearchBar_androidKt.SearchBarInputField(str5, function14, function15, z10, function16, PaddingKt.padding(Modifier.INSTANCE, (AnimatedPaddingValues) rememberedValue10), z11, function216, function217, function218, searchBarColors6.getInputFieldColors(), mutableInteractionSource5, composer3, 196608, 0, 0);
                    composer3.startReplaceableGroup(-685094554);
                    ComposerKt.sourceInformation(composer3, "CC(remember):SearchBar.android.kt#9igjgp");
                    Object rememberedValue11 = composer3.rememberedValue();
                    if (rememberedValue11 == Composer.INSTANCE.getEmpty()) {
                        state3 = state4;
                        rememberedValue11 = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0<Boolean>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$4$1$showResults$2$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                            public final Boolean m2852invoke() {
                                return Boolean.valueOf(state3.getValue().floatValue() > 0.0f);
                            }
                        });
                        composer3.updateRememberedValue(rememberedValue11);
                    } else {
                        state3 = state4;
                    }
                    composer3.endReplaceableGroup();
                    composer3.startReplaceableGroup(551421253);
                    ComposerKt.sourceInformation(composer3, "276@13613L35,276@13583L183");
                    if (invoke$lambda$5$lambda$2((State) rememberedValue11)) {
                        Modifier.Companion companion2 = Modifier.INSTANCE;
                        composer3.startReplaceableGroup(-685094361);
                        ComposerKt.sourceInformation(composer3, "CC(remember):SearchBar.android.kt#9igjgp");
                        boolean changed5 = composer3.changed(state3);
                        Object rememberedValue12 = composer3.rememberedValue();
                        if (changed5 || rememberedValue12 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue12 = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$4$1$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((GraphicsLayerScope) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                                    graphicsLayerScope.setAlpha(state3.getValue().floatValue());
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue12);
                        }
                        composer3.endReplaceableGroup();
                        Modifier graphicsLayer = GraphicsLayerModifierKt.graphicsLayer(companion2, (Function1) rememberedValue12);
                        composer3.startReplaceableGroup(-483455358);
                        ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                        MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                        Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(graphicsLayer);
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor2);
                        } else {
                            composer3.useNode();
                        }
                        Composer m4109constructorimpl2 = Updater.m4109constructorimpl(composer3);
                        Updater.m4116setimpl(m4109constructorimpl2, columnMeasurePolicy2, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m4116setimpl(m4109constructorimpl2, currentCompositionLocalMap2, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (m4109constructorimpl2.getInserting() || !Intrinsics.areEqual(m4109constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            m4109constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            m4109constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                        }
                        modifierMaterializerOf2.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer3)), composer3, 0);
                        composer3.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer3, 1234675075, "C277@13672L46,278@13739L9:SearchBar.android.kt#uh7d8r");
                        DividerKt.m2540HorizontalDivider9IZ8Weo(null, 0.0f, searchBarColors6.getDividerColor(), composer3, 0, 3);
                        function32.invoke(columnScopeInstance2, composer3, 6);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceableGroup();
                        composer3.endNode();
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                    }
                    composer3.endReplaceableGroup();
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

            private static final boolean invoke$lambda$5$lambda$2(State<Boolean> state3) {
                return state3.getValue().booleanValue();
            }
        }), composer2, (57344 & i312222) | 12582912 | (i312222 & 458752), 64);
        if (z) {
        }
        Boolean valueOf2222 = Boolean.valueOf(z);
        composer2.startReplaceableGroup(851482799);
        ComposerKt.sourceInformation(composer2, str42222);
        changed4 = composer2.changed(z6) | composer2.changedInstance(focusManager2222);
        rememberedValue7 = composer2.rememberedValue();
        if (!changed4) {
        }
        rememberedValue7 = new SearchBar_androidKt$SearchBar$5$1(z6, focusManager2222, null);
        composer2.updateRememberedValue(rememberedValue7);
        composer2.endReplaceableGroup();
        int i322222 = (i292222 >> 9) & 14;
        EffectsKt.LaunchedEffect(valueOf2222, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue7, composer2, i322222);
        composer2.startReplaceableGroup(851483127);
        ComposerKt.sourceInformation(composer2, str42222);
        if ((i292222 & 57344) == 16384) {
        }
        rememberedValue8 = composer2.rememberedValue();
        if (!z7) {
        }
        rememberedValue8 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$6$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m2853invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2853invoke() {
                function13.invoke(false);
            }
        };
        composer2.updateRememberedValue(rememberedValue8);
        composer2.endReplaceableGroup();
        BackHandlerKt.BackHandler(z, (Function0) rememberedValue8, composer2, i322222, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        function29 = function28;
        searchBarColors4 = searchBarColors3;
        f5 = f3;
        mutableInteractionSource3 = mutableInteractionSource2;
        z8 = z4;
        function210 = function25;
        function211 = function26;
        windowInsets4 = windowInsets52222;
        shape4 = shape62222;
        modifier3 = modifier52222;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x043e  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0447  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x046e  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0440  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x048b  */
    /* JADX WARN: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0338  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x03e7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x040c  */
    /* renamed from: DockedSearchBar-eWTbjVg, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2848DockedSearchBareWTbjVg(final String str, final Function1<? super String, Unit> function1, final Function1<? super String, Unit> function12, final boolean z, final Function1<? super Boolean, Unit> function13, Modifier modifier, boolean z2, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, SearchBarColors searchBarColors, float f, float f2, MutableInteractionSource mutableInteractionSource, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        Function2<? super Composer, ? super Integer, Unit> function24;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        Shape shape2;
        int i17;
        String str2;
        boolean z3;
        int i18;
        int i19;
        SearchBarColors searchBarColors2;
        int i20;
        String str3;
        MutableInteractionSource mutableInteractionSource2;
        Function2<? super Composer, ? super Integer, Unit> function25;
        SearchBarColors searchBarColors3;
        float f3;
        int i21;
        float f4;
        Modifier modifier2;
        boolean z4;
        Function2<? super Composer, ? super Integer, Unit> function26;
        Function2<? super Composer, ? super Integer, Unit> function27;
        Shape shape3;
        int i22;
        Composer composer2;
        boolean z5;
        boolean changed;
        SearchBar_androidKt$DockedSearchBar$3$1 rememberedValue;
        boolean z6;
        Object rememberedValue2;
        final boolean z7;
        final Function2<? super Composer, ? super Integer, Unit> function28;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        final Shape shape4;
        final SearchBarColors searchBarColors4;
        final float f5;
        final float f6;
        final MutableInteractionSource mutableInteractionSource3;
        final Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        int i23;
        int i24;
        Composer startRestartGroup = composer.startRestartGroup(1299054533);
        ComposerKt.sourceInformation(startRestartGroup, "C(DockedSearchBar)P(11,8,9!1,7,6,3,10,5,15,13!1,14:c#ui.unit.Dp,12:c#ui.unit.Dp,4)358@17745L11,359@17806L8,362@17986L39,365@18121L7,370@18228L38,367@18134L1617,413@19791L25,415@19898L292,415@19875L315,424@20226L37,424@20196L67:SearchBar.android.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i3 & 4) != 0) {
            i4 |= 384;
        } else if ((i & 384) == 0) {
            i4 |= startRestartGroup.changedInstance(function12) ? Fields.RotationX : 128;
            i5 = i3 & 8;
            int i25 = Fields.CameraDistance;
            if (i5 == 0) {
                i4 |= 3072;
            } else if ((i & 3072) == 0) {
                i4 |= startRestartGroup.changed(z) ? 2048 : 1024;
            }
            i6 = i3 & 16;
            int i26 = Fields.Shape;
            if (i6 == 0) {
                i4 |= 24576;
            } else if ((i & 24576) == 0) {
                i4 |= startRestartGroup.changedInstance(function13) ? Fields.Clip : 8192;
            }
            i7 = i3 & 32;
            if (i7 == 0) {
                i4 |= 196608;
            } else if ((i & 196608) == 0) {
                i4 |= startRestartGroup.changed(modifier) ? Fields.RenderEffect : 65536;
            }
            i8 = i3 & 64;
            if (i8 == 0) {
                i4 |= 1572864;
            } else if ((i & 1572864) == 0) {
                i4 |= startRestartGroup.changed(z2) ? 1048576 : Fields.BlendMode;
            }
            i9 = i3 & Fields.SpotShadowColor;
            if (i9 == 0) {
                i4 |= 12582912;
                function24 = function2;
            } else {
                function24 = function2;
                if ((i & 12582912) == 0) {
                    i4 |= startRestartGroup.changedInstance(function24) ? 8388608 : 4194304;
                }
            }
            i10 = i3 & Fields.RotationX;
            if (i10 == 0) {
                i4 |= 100663296;
            } else if ((i & 100663296) == 0) {
                i4 |= startRestartGroup.changedInstance(function22) ? 67108864 : 33554432;
            }
            i11 = i3 & Fields.RotationY;
            if (i11 == 0) {
                i4 |= 805306368;
            } else if ((i & 805306368) == 0) {
                i4 |= startRestartGroup.changedInstance(function23) ? 536870912 : 268435456;
            }
            if ((i2 & 6) != 0) {
                if ((i3 & Fields.RotationZ) == 0 && startRestartGroup.changed(shape)) {
                    i24 = 4;
                    i12 = i2 | i24;
                }
                i24 = 2;
                i12 = i2 | i24;
            } else {
                i12 = i2;
            }
            if ((i2 & 48) == 0) {
                if ((i3 & Fields.CameraDistance) == 0 && startRestartGroup.changed(searchBarColors)) {
                    i23 = 32;
                    i12 |= i23;
                }
                i23 = 16;
                i12 |= i23;
            }
            int i27 = i12;
            i13 = i3 & Fields.TransformOrigin;
            if (i13 == 0) {
                i27 |= 384;
            } else if ((i2 & 384) == 0) {
                i27 |= startRestartGroup.changed(f) ? Fields.RotationX : 128;
                i14 = i3 & Fields.Shape;
                if (i14 != 0) {
                    i27 |= 3072;
                } else if ((i2 & 3072) == 0) {
                    if (!startRestartGroup.changed(f2)) {
                        i25 = 1024;
                    }
                    i27 |= i25;
                    i15 = i3 & Fields.Clip;
                    if (i15 == 0) {
                        i27 |= 24576;
                    } else if ((i2 & 24576) == 0) {
                        if (startRestartGroup.changed(mutableInteractionSource)) {
                            i26 = Fields.Clip;
                        }
                        i27 |= i26;
                        if ((i3 & Fields.CompositingStrategy) != 0) {
                            i27 |= 196608;
                        } else if ((i2 & 196608) == 0) {
                            i16 = i15;
                            i27 |= startRestartGroup.changedInstance(function3) ? Fields.RenderEffect : 65536;
                            int i28 = i4;
                            if ((i4 & 306783379) != 306783378 && (74899 & i27) == 74898 && startRestartGroup.getSkipping()) {
                                startRestartGroup.skipToGroupEnd();
                                z7 = z2;
                                function29 = function22;
                                shape4 = shape;
                                searchBarColors4 = searchBarColors;
                                mutableInteractionSource3 = mutableInteractionSource;
                                function28 = function24;
                                composer2 = startRestartGroup;
                                modifier3 = modifier;
                                function210 = function23;
                                f5 = f;
                                f6 = f2;
                            } else {
                                startRestartGroup.startDefaults();
                                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    Modifier modifier4 = i7 == 0 ? Modifier.INSTANCE : modifier;
                                    boolean z8 = i8 == 0 ? true : z2;
                                    Function2<? super Composer, ? super Integer, Unit> function211 = i9 == 0 ? null : function24;
                                    Function2<? super Composer, ? super Integer, Unit> function212 = i10 == 0 ? null : function22;
                                    Function2<? super Composer, ? super Integer, Unit> function213 = i11 == 0 ? null : function23;
                                    if ((i3 & Fields.RotationZ) == 0) {
                                        i27 &= -15;
                                        shape2 = SearchBarDefaults.INSTANCE.getDockedShape(startRestartGroup, 6);
                                    } else {
                                        shape2 = shape;
                                    }
                                    int i29 = i27;
                                    if ((i3 & Fields.CameraDistance) == 0) {
                                        i17 = i28;
                                        str2 = "CC(remember):SearchBar.android.kt#9igjgp";
                                        z3 = true;
                                        i18 = i16;
                                        i19 = i14;
                                        searchBarColors2 = SearchBarDefaults.INSTANCE.m2841colorsKlgxPg(0L, 0L, null, startRestartGroup, 3072, 7);
                                        i20 = i29 & (-113);
                                    } else {
                                        i17 = i28;
                                        str2 = "CC(remember):SearchBar.android.kt#9igjgp";
                                        z3 = true;
                                        i18 = i16;
                                        i19 = i14;
                                        searchBarColors2 = searchBarColors;
                                        i20 = i29;
                                    }
                                    float m2845getTonalElevationD9Ej5fM = i13 == 0 ? SearchBarDefaults.INSTANCE.m2845getTonalElevationD9Ej5fM() : f;
                                    float m2844getShadowElevationD9Ej5fM = i19 == 0 ? SearchBarDefaults.INSTANCE.m2844getShadowElevationD9Ej5fM() : f2;
                                    if (i18 == 0) {
                                        startRestartGroup.startReplaceableGroup(-32072212);
                                        str3 = str2;
                                        ComposerKt.sourceInformation(startRestartGroup, str3);
                                        Object rememberedValue3 = startRestartGroup.rememberedValue();
                                        if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue3 = InteractionSourceKt.MutableInteractionSource();
                                            startRestartGroup.updateRememberedValue(rememberedValue3);
                                        }
                                        startRestartGroup.endReplaceableGroup();
                                        function25 = function213;
                                        searchBarColors3 = searchBarColors2;
                                        f3 = m2845getTonalElevationD9Ej5fM;
                                        i21 = i20;
                                        f4 = m2844getShadowElevationD9Ej5fM;
                                        mutableInteractionSource2 = (MutableInteractionSource) rememberedValue3;
                                    } else {
                                        str3 = str2;
                                        mutableInteractionSource2 = mutableInteractionSource;
                                        function25 = function213;
                                        searchBarColors3 = searchBarColors2;
                                        f3 = m2845getTonalElevationD9Ej5fM;
                                        i21 = i20;
                                        f4 = m2844getShadowElevationD9Ej5fM;
                                    }
                                    modifier2 = modifier4;
                                    z4 = z8;
                                    function26 = function211;
                                    function27 = function212;
                                    shape3 = shape2;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i3 & Fields.RotationZ) != 0) {
                                        i27 &= -15;
                                    }
                                    if ((i3 & Fields.CameraDistance) != 0) {
                                        i27 &= -113;
                                    }
                                    modifier2 = modifier;
                                    z4 = z2;
                                    function27 = function22;
                                    function25 = function23;
                                    shape3 = shape;
                                    searchBarColors3 = searchBarColors;
                                    f3 = f;
                                    f4 = f2;
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    i17 = i28;
                                    i21 = i27;
                                    function26 = function24;
                                    z3 = true;
                                    str3 = "CC(remember):SearchBar.android.kt#9igjgp";
                                }
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    i22 = i17;
                                } else {
                                    i22 = i17;
                                    ComposerKt.traceEventStart(1299054533, i22, i21, "androidx.compose.material3.DockedSearchBar (SearchBar.android.kt:364)");
                                }
                                ProvidableCompositionLocal localFocusManager = CompositionLocalsKt.getLocalFocusManager();
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object consume = startRestartGroup.consume(localFocusManager);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                FocusManager focusManager = (FocusManager) consume;
                                long containerColor = searchBarColors3.getContainerColor();
                                long m2381contentColorForek8zF_U = ColorSchemeKt.m2381contentColorForek8zF_U(searchBarColors3.getContainerColor(), startRestartGroup, 0);
                                Modifier m1125width3ABfNKs = androidx.compose.foundation.layout.SizeKt.m1125width3ABfNKs(ZIndexModifierKt.zIndex(modifier2, 1.0f), SearchBarMinWidth);
                                int i30 = i22;
                                final boolean z9 = z4;
                                int i31 = i21;
                                final Function2<? super Composer, ? super Integer, Unit> function214 = function26;
                                Modifier modifier5 = modifier2;
                                final Function2<? super Composer, ? super Integer, Unit> function215 = function27;
                                String str4 = str3;
                                final Function2<? super Composer, ? super Integer, Unit> function216 = function25;
                                final SearchBarColors searchBarColors5 = searchBarColors3;
                                final MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                                int i32 = i31 << 6;
                                SurfaceKt.m3043SurfaceT9BRK9s(m1125width3ABfNKs, shape3, containerColor, m2381contentColorForek8zF_U, f3, f4, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1088676554, z3, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$2
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

                                    public final void invoke(Composer composer3, int i33) {
                                        EnterTransition enterTransition;
                                        ExitTransition exitTransition;
                                        ComposerKt.sourceInformation(composer3, "C377@18458L1287:SearchBar.android.kt#uh7d8r");
                                        if ((i33 & 3) != 2 || !composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1088676554, i33, -1, "androidx.compose.material3.DockedSearchBar.<anonymous> (SearchBar.android.kt:377)");
                                            }
                                            String str5 = str;
                                            Function1<String, Unit> function14 = function1;
                                            Function1<String, Unit> function15 = function12;
                                            boolean z10 = z;
                                            Function1<Boolean, Unit> function16 = function13;
                                            boolean z11 = z9;
                                            Function2<Composer, Integer, Unit> function217 = function214;
                                            Function2<Composer, Integer, Unit> function218 = function215;
                                            Function2<Composer, Integer, Unit> function219 = function216;
                                            final SearchBarColors searchBarColors6 = searchBarColors5;
                                            MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource4;
                                            final Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                                            composer3.startReplaceableGroup(-483455358);
                                            ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                            Modifier.Companion companion = Modifier.INSTANCE;
                                            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                                            composer3.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                            CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                            Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
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
                                            ComposerKt.sourceInformationMarkerStart(composer3, 1253285019, "C378@18479L502,392@18995L740:SearchBar.android.kt#uh7d8r");
                                            SearchBar_androidKt.SearchBarInputField(str5, function14, function15, z10, function16, null, z11, function217, function218, function219, searchBarColors6.getInputFieldColors(), mutableInteractionSource5, composer3, 0, 0, 32);
                                            enterTransition = SearchBar_androidKt.DockedEnterTransition;
                                            exitTransition = SearchBar_androidKt.DockedExitTransition;
                                            AnimatedVisibilityKt.AnimatedVisibility(columnScopeInstance, z10, (Modifier) null, enterTransition, exitTransition, (String) null, ComposableLambdaKt.composableLambda(composer3, 1804538904, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$2$1$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(3);
                                                }

                                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                                    invoke((AnimatedVisibilityScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer4, int i34) {
                                                    ComposerKt.sourceInformation(composer4, "C*397@19211L7,398@19269L115,401@19417L110,405@19545L176:SearchBar.android.kt#uh7d8r");
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1804538904, i34, -1, "androidx.compose.material3.DockedSearchBar.<anonymous>.<anonymous>.<anonymous> (SearchBar.android.kt:397)");
                                                    }
                                                    ProvidableCompositionLocal localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
                                                    ComposerKt.sourceInformationMarkerStart(composer4, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                    Object consume2 = composer4.consume(localConfiguration);
                                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                                    float f7 = Dp.constructor-impl(((Configuration) consume2).screenHeightDp);
                                                    composer4.startReplaceableGroup(747855826);
                                                    ComposerKt.sourceInformation(composer4, "CC(remember):SearchBar.android.kt#9igjgp");
                                                    boolean changed2 = composer4.changed(f7);
                                                    Object rememberedValue4 = composer4.rememberedValue();
                                                    if (changed2 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                                        rememberedValue4 = Dp.box-impl(Dp.constructor-impl(f7 * 0.6666667f));
                                                        composer4.updateRememberedValue(rememberedValue4);
                                                    }
                                                    float f8 = ((Dp) rememberedValue4).unbox-impl();
                                                    composer4.endReplaceableGroup();
                                                    composer4.startReplaceableGroup(747855974);
                                                    ComposerKt.sourceInformation(composer4, "CC(remember):SearchBar.android.kt#9igjgp");
                                                    boolean changed3 = composer4.changed(f8);
                                                    Object rememberedValue5 = composer4.rememberedValue();
                                                    if (changed3 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                                        rememberedValue5 = Dp.box-impl(RangesKt.coerceAtMost(Dp.box-impl(SearchBar_androidKt.getDockedActiveTableMinHeight()), Dp.box-impl(f8)).unbox-impl());
                                                        composer4.updateRememberedValue(rememberedValue5);
                                                    }
                                                    float f9 = ((Dp) rememberedValue5).unbox-impl();
                                                    composer4.endReplaceableGroup();
                                                    Modifier m1107heightInVpY3zN4 = androidx.compose.foundation.layout.SizeKt.m1107heightInVpY3zN4(Modifier.INSTANCE, f9, f8);
                                                    SearchBarColors searchBarColors7 = SearchBarColors.this;
                                                    Function3<ColumnScope, Composer, Integer, Unit> function33 = function32;
                                                    composer4.startReplaceableGroup(-483455358);
                                                    ComposerKt.sourceInformation(composer4, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                                    MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer4, 0);
                                                    composer4.startReplaceableGroup(-1323940314);
                                                    ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                                    CompositionLocalMap currentCompositionLocalMap2 = composer4.getCurrentCompositionLocalMap();
                                                    Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m1107heightInVpY3zN4);
                                                    if (!(composer4.getApplier() instanceof Applier)) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    composer4.startReusableNode();
                                                    if (composer4.getInserting()) {
                                                        composer4.createNode(constructor2);
                                                    } else {
                                                        composer4.useNode();
                                                    }
                                                    Composer m4109constructorimpl2 = Updater.m4109constructorimpl(composer4);
                                                    Updater.m4116setimpl(m4109constructorimpl2, columnMeasurePolicy2, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                                    Updater.m4116setimpl(m4109constructorimpl2, currentCompositionLocalMap2, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                    Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                    if (m4109constructorimpl2.getInserting() || !Intrinsics.areEqual(m4109constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                                        m4109constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                                        m4109constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                                    }
                                                    modifierMaterializerOf2.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer4)), composer4, 0);
                                                    composer4.startReplaceableGroup(2058660585);
                                                    ComposerKt.sourceInformationMarkerStart(composer4, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                                    ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                                                    ComposerKt.sourceInformationMarkerStart(composer4, 1001846745, "C406@19627L46,407@19694L9:SearchBar.android.kt#uh7d8r");
                                                    DividerKt.m2540HorizontalDivider9IZ8Weo(null, 0.0f, searchBarColors7.getDividerColor(), composer4, 0, 3);
                                                    function33.invoke(columnScopeInstance2, composer4, 6);
                                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                                    composer4.endReplaceableGroup();
                                                    composer4.endNode();
                                                    composer4.endReplaceableGroup();
                                                    composer4.endReplaceableGroup();
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }), composer3, 1600518, 18);
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
                                }), startRestartGroup, ((i31 << 3) & 112) | 12582912 | (57344 & i32) | (i32 & 458752), 64);
                                composer2 = startRestartGroup;
                                z5 = (z && FocusInteractionKt.collectIsFocusedAsState(mutableInteractionSource2, startRestartGroup, (i31 >> 12) & 14).getValue().booleanValue()) ? z3 : false;
                                Boolean valueOf = Boolean.valueOf(z);
                                composer2.startReplaceableGroup(-32070300);
                                ComposerKt.sourceInformation(composer2, str4);
                                changed = composer2.changed(z5) | composer2.changedInstance(focusManager);
                                rememberedValue = composer2.rememberedValue();
                                if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = new SearchBar_androidKt$DockedSearchBar$3$1(z5, focusManager, null);
                                    composer2.updateRememberedValue(rememberedValue);
                                }
                                composer2.endReplaceableGroup();
                                int i33 = (i30 >> 9) & 14;
                                EffectsKt.LaunchedEffect(valueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue, composer2, i33);
                                composer2.startReplaceableGroup(-32069972);
                                ComposerKt.sourceInformation(composer2, str4);
                                z6 = (i30 & 57344) != 16384 ? z3 : false;
                                rememberedValue2 = composer2.rememberedValue();
                                if (!z6 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$4$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(0);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke() {
                                            m2850invoke();
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: collision with other method in class */
                                        public final void m2850invoke() {
                                            function13.invoke(false);
                                        }
                                    };
                                    composer2.updateRememberedValue(rememberedValue2);
                                }
                                composer2.endReplaceableGroup();
                                BackHandlerKt.BackHandler(z, (Function0) rememberedValue2, composer2, i33, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                z7 = z4;
                                function28 = function26;
                                function29 = function27;
                                function210 = function25;
                                shape4 = shape3;
                                searchBarColors4 = searchBarColors3;
                                f5 = f3;
                                f6 = f4;
                                mutableInteractionSource3 = mutableInteractionSource2;
                                modifier3 = modifier5;
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$5
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

                                    public final void invoke(Composer composer3, int i34) {
                                        SearchBar_androidKt.m2848DockedSearchBareWTbjVg(str, function1, function12, z, function13, modifier3, z7, function28, function29, function210, shape4, searchBarColors4, f5, f6, mutableInteractionSource3, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i16 = i15;
                        int i282 = i4;
                        if ((i4 & 306783379) != 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                        }
                        if (i7 == 0) {
                        }
                        if (i8 == 0) {
                        }
                        if (i9 == 0) {
                        }
                        if (i10 == 0) {
                        }
                        if (i11 == 0) {
                        }
                        if ((i3 & Fields.RotationZ) == 0) {
                        }
                        int i292 = i27;
                        if ((i3 & Fields.CameraDistance) == 0) {
                        }
                        if (i13 == 0) {
                        }
                        if (i19 == 0) {
                        }
                        if (i18 == 0) {
                        }
                        modifier2 = modifier4;
                        z4 = z8;
                        function26 = function211;
                        function27 = function212;
                        shape3 = shape2;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        ProvidableCompositionLocal localFocusManager2 = CompositionLocalsKt.getLocalFocusManager();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume2 = startRestartGroup.consume(localFocusManager2);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        FocusManager focusManager2 = (FocusManager) consume2;
                        long containerColor2 = searchBarColors3.getContainerColor();
                        long m2381contentColorForek8zF_U2 = ColorSchemeKt.m2381contentColorForek8zF_U(searchBarColors3.getContainerColor(), startRestartGroup, 0);
                        Modifier m1125width3ABfNKs2 = androidx.compose.foundation.layout.SizeKt.m1125width3ABfNKs(ZIndexModifierKt.zIndex(modifier2, 1.0f), SearchBarMinWidth);
                        int i302 = i22;
                        final boolean z92 = z4;
                        int i312 = i21;
                        final Function2<? super Composer, ? super Integer, Unit> function2142 = function26;
                        Modifier modifier52 = modifier2;
                        final Function2<? super Composer, ? super Integer, Unit> function2152 = function27;
                        String str42 = str3;
                        final Function2<? super Composer, ? super Integer, Unit> function2162 = function25;
                        final SearchBarColors searchBarColors52 = searchBarColors3;
                        final MutableInteractionSource mutableInteractionSource42 = mutableInteractionSource2;
                        int i322 = i312 << 6;
                        SurfaceKt.m3043SurfaceT9BRK9s(m1125width3ABfNKs2, shape3, containerColor2, m2381contentColorForek8zF_U2, f3, f4, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1088676554, z3, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$2
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

                            public final void invoke(Composer composer3, int i332) {
                                EnterTransition enterTransition;
                                ExitTransition exitTransition;
                                ComposerKt.sourceInformation(composer3, "C377@18458L1287:SearchBar.android.kt#uh7d8r");
                                if ((i332 & 3) != 2 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1088676554, i332, -1, "androidx.compose.material3.DockedSearchBar.<anonymous> (SearchBar.android.kt:377)");
                                    }
                                    String str5 = str;
                                    Function1<String, Unit> function14 = function1;
                                    Function1<String, Unit> function15 = function12;
                                    boolean z10 = z;
                                    Function1<Boolean, Unit> function16 = function13;
                                    boolean z11 = z92;
                                    Function2<Composer, Integer, Unit> function217 = function2142;
                                    Function2<Composer, Integer, Unit> function218 = function2152;
                                    Function2<Composer, Integer, Unit> function219 = function2162;
                                    final SearchBarColors searchBarColors6 = searchBarColors52;
                                    MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource42;
                                    final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                                    composer3.startReplaceableGroup(-483455358);
                                    ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                    Modifier.Companion companion = Modifier.INSTANCE;
                                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                                    composer3.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                    Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
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
                                    ComposerKt.sourceInformationMarkerStart(composer3, 1253285019, "C378@18479L502,392@18995L740:SearchBar.android.kt#uh7d8r");
                                    SearchBar_androidKt.SearchBarInputField(str5, function14, function15, z10, function16, null, z11, function217, function218, function219, searchBarColors6.getInputFieldColors(), mutableInteractionSource5, composer3, 0, 0, 32);
                                    enterTransition = SearchBar_androidKt.DockedEnterTransition;
                                    exitTransition = SearchBar_androidKt.DockedExitTransition;
                                    AnimatedVisibilityKt.AnimatedVisibility(columnScopeInstance, z10, (Modifier) null, enterTransition, exitTransition, (String) null, ComposableLambdaKt.composableLambda(composer3, 1804538904, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$2$1$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(3);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                            invoke((AnimatedVisibilityScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer4, int i34) {
                                            ComposerKt.sourceInformation(composer4, "C*397@19211L7,398@19269L115,401@19417L110,405@19545L176:SearchBar.android.kt#uh7d8r");
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1804538904, i34, -1, "androidx.compose.material3.DockedSearchBar.<anonymous>.<anonymous>.<anonymous> (SearchBar.android.kt:397)");
                                            }
                                            ProvidableCompositionLocal localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
                                            ComposerKt.sourceInformationMarkerStart(composer4, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                            Object consume22 = composer4.consume(localConfiguration);
                                            ComposerKt.sourceInformationMarkerEnd(composer4);
                                            float f7 = Dp.constructor-impl(((Configuration) consume22).screenHeightDp);
                                            composer4.startReplaceableGroup(747855826);
                                            ComposerKt.sourceInformation(composer4, "CC(remember):SearchBar.android.kt#9igjgp");
                                            boolean changed2 = composer4.changed(f7);
                                            Object rememberedValue4 = composer4.rememberedValue();
                                            if (changed2 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue4 = Dp.box-impl(Dp.constructor-impl(f7 * 0.6666667f));
                                                composer4.updateRememberedValue(rememberedValue4);
                                            }
                                            float f8 = ((Dp) rememberedValue4).unbox-impl();
                                            composer4.endReplaceableGroup();
                                            composer4.startReplaceableGroup(747855974);
                                            ComposerKt.sourceInformation(composer4, "CC(remember):SearchBar.android.kt#9igjgp");
                                            boolean changed3 = composer4.changed(f8);
                                            Object rememberedValue5 = composer4.rememberedValue();
                                            if (changed3 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue5 = Dp.box-impl(RangesKt.coerceAtMost(Dp.box-impl(SearchBar_androidKt.getDockedActiveTableMinHeight()), Dp.box-impl(f8)).unbox-impl());
                                                composer4.updateRememberedValue(rememberedValue5);
                                            }
                                            float f9 = ((Dp) rememberedValue5).unbox-impl();
                                            composer4.endReplaceableGroup();
                                            Modifier m1107heightInVpY3zN4 = androidx.compose.foundation.layout.SizeKt.m1107heightInVpY3zN4(Modifier.INSTANCE, f9, f8);
                                            SearchBarColors searchBarColors7 = SearchBarColors.this;
                                            Function3<ColumnScope, Composer, Integer, Unit> function33 = function32;
                                            composer4.startReplaceableGroup(-483455358);
                                            ComposerKt.sourceInformation(composer4, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer4, 0);
                                            composer4.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                            CompositionLocalMap currentCompositionLocalMap2 = composer4.getCurrentCompositionLocalMap();
                                            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m1107heightInVpY3zN4);
                                            if (!(composer4.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer4.startReusableNode();
                                            if (composer4.getInserting()) {
                                                composer4.createNode(constructor2);
                                            } else {
                                                composer4.useNode();
                                            }
                                            Composer m4109constructorimpl2 = Updater.m4109constructorimpl(composer4);
                                            Updater.m4116setimpl(m4109constructorimpl2, columnMeasurePolicy2, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                            Updater.m4116setimpl(m4109constructorimpl2, currentCompositionLocalMap2, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                            Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                            if (m4109constructorimpl2.getInserting() || !Intrinsics.areEqual(m4109constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                                m4109constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                                m4109constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                            }
                                            modifierMaterializerOf2.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer4)), composer4, 0);
                                            composer4.startReplaceableGroup(2058660585);
                                            ComposerKt.sourceInformationMarkerStart(composer4, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(composer4, 1001846745, "C406@19627L46,407@19694L9:SearchBar.android.kt#uh7d8r");
                                            DividerKt.m2540HorizontalDivider9IZ8Weo(null, 0.0f, searchBarColors7.getDividerColor(), composer4, 0, 3);
                                            function33.invoke(columnScopeInstance2, composer4, 6);
                                            ComposerKt.sourceInformationMarkerEnd(composer4);
                                            ComposerKt.sourceInformationMarkerEnd(composer4);
                                            composer4.endReplaceableGroup();
                                            composer4.endNode();
                                            composer4.endReplaceableGroup();
                                            composer4.endReplaceableGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composer3, 1600518, 18);
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
                        }), startRestartGroup, ((i312 << 3) & 112) | 12582912 | (57344 & i322) | (i322 & 458752), 64);
                        composer2 = startRestartGroup;
                        if (z) {
                        }
                        Boolean valueOf2 = Boolean.valueOf(z);
                        composer2.startReplaceableGroup(-32070300);
                        ComposerKt.sourceInformation(composer2, str42);
                        changed = composer2.changed(z5) | composer2.changedInstance(focusManager2);
                        rememberedValue = composer2.rememberedValue();
                        if (!changed) {
                        }
                        rememberedValue = new SearchBar_androidKt$DockedSearchBar$3$1(z5, focusManager2, null);
                        composer2.updateRememberedValue(rememberedValue);
                        composer2.endReplaceableGroup();
                        int i332 = (i302 >> 9) & 14;
                        EffectsKt.LaunchedEffect(valueOf2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue, composer2, i332);
                        composer2.startReplaceableGroup(-32069972);
                        ComposerKt.sourceInformation(composer2, str42);
                        if ((i302 & 57344) != 16384) {
                        }
                        rememberedValue2 = composer2.rememberedValue();
                        if (!z6) {
                        }
                        rememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$4$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(0);
                            }

                            public /* bridge */ /* synthetic */ Object invoke() {
                                m2850invoke();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: collision with other method in class */
                            public final void m2850invoke() {
                                function13.invoke(false);
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue2);
                        composer2.endReplaceableGroup();
                        BackHandlerKt.BackHandler(z, (Function0) rememberedValue2, composer2, i332, 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        z7 = z4;
                        function28 = function26;
                        function29 = function27;
                        function210 = function25;
                        shape4 = shape3;
                        searchBarColors4 = searchBarColors3;
                        f5 = f3;
                        f6 = f4;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        modifier3 = modifier52;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    if ((i3 & Fields.CompositingStrategy) != 0) {
                    }
                    i16 = i15;
                    int i2822 = i4;
                    if ((i4 & 306783379) != 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i7 == 0) {
                    }
                    if (i8 == 0) {
                    }
                    if (i9 == 0) {
                    }
                    if (i10 == 0) {
                    }
                    if (i11 == 0) {
                    }
                    if ((i3 & Fields.RotationZ) == 0) {
                    }
                    int i2922 = i27;
                    if ((i3 & Fields.CameraDistance) == 0) {
                    }
                    if (i13 == 0) {
                    }
                    if (i19 == 0) {
                    }
                    if (i18 == 0) {
                    }
                    modifier2 = modifier4;
                    z4 = z8;
                    function26 = function211;
                    function27 = function212;
                    shape3 = shape2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ProvidableCompositionLocal localFocusManager22 = CompositionLocalsKt.getLocalFocusManager();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume22 = startRestartGroup.consume(localFocusManager22);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    FocusManager focusManager22 = (FocusManager) consume22;
                    long containerColor22 = searchBarColors3.getContainerColor();
                    long m2381contentColorForek8zF_U22 = ColorSchemeKt.m2381contentColorForek8zF_U(searchBarColors3.getContainerColor(), startRestartGroup, 0);
                    Modifier m1125width3ABfNKs22 = androidx.compose.foundation.layout.SizeKt.m1125width3ABfNKs(ZIndexModifierKt.zIndex(modifier2, 1.0f), SearchBarMinWidth);
                    int i3022 = i22;
                    final boolean z922 = z4;
                    int i3122 = i21;
                    final Function2<? super Composer, ? super Integer, Unit> function21422 = function26;
                    Modifier modifier522 = modifier2;
                    final Function2<? super Composer, ? super Integer, Unit> function21522 = function27;
                    String str422 = str3;
                    final Function2<? super Composer, ? super Integer, Unit> function21622 = function25;
                    final SearchBarColors searchBarColors522 = searchBarColors3;
                    final MutableInteractionSource mutableInteractionSource422 = mutableInteractionSource2;
                    int i3222 = i3122 << 6;
                    SurfaceKt.m3043SurfaceT9BRK9s(m1125width3ABfNKs22, shape3, containerColor22, m2381contentColorForek8zF_U22, f3, f4, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1088676554, z3, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$2
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

                        public final void invoke(Composer composer3, int i3322) {
                            EnterTransition enterTransition;
                            ExitTransition exitTransition;
                            ComposerKt.sourceInformation(composer3, "C377@18458L1287:SearchBar.android.kt#uh7d8r");
                            if ((i3322 & 3) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1088676554, i3322, -1, "androidx.compose.material3.DockedSearchBar.<anonymous> (SearchBar.android.kt:377)");
                                }
                                String str5 = str;
                                Function1<String, Unit> function14 = function1;
                                Function1<String, Unit> function15 = function12;
                                boolean z10 = z;
                                Function1<Boolean, Unit> function16 = function13;
                                boolean z11 = z922;
                                Function2<Composer, Integer, Unit> function217 = function21422;
                                Function2<Composer, Integer, Unit> function218 = function21522;
                                Function2<Composer, Integer, Unit> function219 = function21622;
                                final SearchBarColors searchBarColors6 = searchBarColors522;
                                MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource422;
                                final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                                composer3.startReplaceableGroup(-483455358);
                                ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                Modifier.Companion companion = Modifier.INSTANCE;
                                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                                composer3.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
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
                                ComposerKt.sourceInformationMarkerStart(composer3, 1253285019, "C378@18479L502,392@18995L740:SearchBar.android.kt#uh7d8r");
                                SearchBar_androidKt.SearchBarInputField(str5, function14, function15, z10, function16, null, z11, function217, function218, function219, searchBarColors6.getInputFieldColors(), mutableInteractionSource5, composer3, 0, 0, 32);
                                enterTransition = SearchBar_androidKt.DockedEnterTransition;
                                exitTransition = SearchBar_androidKt.DockedExitTransition;
                                AnimatedVisibilityKt.AnimatedVisibility(columnScopeInstance, z10, (Modifier) null, enterTransition, exitTransition, (String) null, ComposableLambdaKt.composableLambda(composer3, 1804538904, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$2$1$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(3);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                        invoke((AnimatedVisibilityScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer4, int i34) {
                                        ComposerKt.sourceInformation(composer4, "C*397@19211L7,398@19269L115,401@19417L110,405@19545L176:SearchBar.android.kt#uh7d8r");
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1804538904, i34, -1, "androidx.compose.material3.DockedSearchBar.<anonymous>.<anonymous>.<anonymous> (SearchBar.android.kt:397)");
                                        }
                                        ProvidableCompositionLocal localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
                                        ComposerKt.sourceInformationMarkerStart(composer4, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                        Object consume222 = composer4.consume(localConfiguration);
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        float f7 = Dp.constructor-impl(((Configuration) consume222).screenHeightDp);
                                        composer4.startReplaceableGroup(747855826);
                                        ComposerKt.sourceInformation(composer4, "CC(remember):SearchBar.android.kt#9igjgp");
                                        boolean changed2 = composer4.changed(f7);
                                        Object rememberedValue4 = composer4.rememberedValue();
                                        if (changed2 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue4 = Dp.box-impl(Dp.constructor-impl(f7 * 0.6666667f));
                                            composer4.updateRememberedValue(rememberedValue4);
                                        }
                                        float f8 = ((Dp) rememberedValue4).unbox-impl();
                                        composer4.endReplaceableGroup();
                                        composer4.startReplaceableGroup(747855974);
                                        ComposerKt.sourceInformation(composer4, "CC(remember):SearchBar.android.kt#9igjgp");
                                        boolean changed3 = composer4.changed(f8);
                                        Object rememberedValue5 = composer4.rememberedValue();
                                        if (changed3 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue5 = Dp.box-impl(RangesKt.coerceAtMost(Dp.box-impl(SearchBar_androidKt.getDockedActiveTableMinHeight()), Dp.box-impl(f8)).unbox-impl());
                                            composer4.updateRememberedValue(rememberedValue5);
                                        }
                                        float f9 = ((Dp) rememberedValue5).unbox-impl();
                                        composer4.endReplaceableGroup();
                                        Modifier m1107heightInVpY3zN4 = androidx.compose.foundation.layout.SizeKt.m1107heightInVpY3zN4(Modifier.INSTANCE, f9, f8);
                                        SearchBarColors searchBarColors7 = SearchBarColors.this;
                                        Function3<ColumnScope, Composer, Integer, Unit> function33 = function32;
                                        composer4.startReplaceableGroup(-483455358);
                                        ComposerKt.sourceInformation(composer4, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                        MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer4, 0);
                                        composer4.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                        CompositionLocalMap currentCompositionLocalMap2 = composer4.getCurrentCompositionLocalMap();
                                        Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m1107heightInVpY3zN4);
                                        if (!(composer4.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer4.startReusableNode();
                                        if (composer4.getInserting()) {
                                            composer4.createNode(constructor2);
                                        } else {
                                            composer4.useNode();
                                        }
                                        Composer m4109constructorimpl2 = Updater.m4109constructorimpl(composer4);
                                        Updater.m4116setimpl(m4109constructorimpl2, columnMeasurePolicy2, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                        Updater.m4116setimpl(m4109constructorimpl2, currentCompositionLocalMap2, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                        Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                        if (m4109constructorimpl2.getInserting() || !Intrinsics.areEqual(m4109constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                            m4109constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                            m4109constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                        }
                                        modifierMaterializerOf2.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer4)), composer4, 0);
                                        composer4.startReplaceableGroup(2058660585);
                                        ComposerKt.sourceInformationMarkerStart(composer4, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                        ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composer4, 1001846745, "C406@19627L46,407@19694L9:SearchBar.android.kt#uh7d8r");
                                        DividerKt.m2540HorizontalDivider9IZ8Weo(null, 0.0f, searchBarColors7.getDividerColor(), composer4, 0, 3);
                                        function33.invoke(columnScopeInstance2, composer4, 6);
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        composer4.endReplaceableGroup();
                                        composer4.endNode();
                                        composer4.endReplaceableGroup();
                                        composer4.endReplaceableGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), composer3, 1600518, 18);
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
                    }), startRestartGroup, ((i3122 << 3) & 112) | 12582912 | (57344 & i3222) | (i3222 & 458752), 64);
                    composer2 = startRestartGroup;
                    if (z) {
                    }
                    Boolean valueOf22 = Boolean.valueOf(z);
                    composer2.startReplaceableGroup(-32070300);
                    ComposerKt.sourceInformation(composer2, str422);
                    changed = composer2.changed(z5) | composer2.changedInstance(focusManager22);
                    rememberedValue = composer2.rememberedValue();
                    if (!changed) {
                    }
                    rememberedValue = new SearchBar_androidKt$DockedSearchBar$3$1(z5, focusManager22, null);
                    composer2.updateRememberedValue(rememberedValue);
                    composer2.endReplaceableGroup();
                    int i3322 = (i3022 >> 9) & 14;
                    EffectsKt.LaunchedEffect(valueOf22, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue, composer2, i3322);
                    composer2.startReplaceableGroup(-32069972);
                    ComposerKt.sourceInformation(composer2, str422);
                    if ((i3022 & 57344) != 16384) {
                    }
                    rememberedValue2 = composer2.rememberedValue();
                    if (!z6) {
                    }
                    rememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$4$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m2850invoke();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: collision with other method in class */
                        public final void m2850invoke() {
                            function13.invoke(false);
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue2);
                    composer2.endReplaceableGroup();
                    BackHandlerKt.BackHandler(z, (Function0) rememberedValue2, composer2, i3322, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    z7 = z4;
                    function28 = function26;
                    function29 = function27;
                    function210 = function25;
                    shape4 = shape3;
                    searchBarColors4 = searchBarColors3;
                    f5 = f3;
                    f6 = f4;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    modifier3 = modifier522;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                i15 = i3 & Fields.Clip;
                if (i15 == 0) {
                }
                if ((i3 & Fields.CompositingStrategy) != 0) {
                }
                i16 = i15;
                int i28222 = i4;
                if ((i4 & 306783379) != 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i7 == 0) {
                }
                if (i8 == 0) {
                }
                if (i9 == 0) {
                }
                if (i10 == 0) {
                }
                if (i11 == 0) {
                }
                if ((i3 & Fields.RotationZ) == 0) {
                }
                int i29222 = i27;
                if ((i3 & Fields.CameraDistance) == 0) {
                }
                if (i13 == 0) {
                }
                if (i19 == 0) {
                }
                if (i18 == 0) {
                }
                modifier2 = modifier4;
                z4 = z8;
                function26 = function211;
                function27 = function212;
                shape3 = shape2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                ProvidableCompositionLocal localFocusManager222 = CompositionLocalsKt.getLocalFocusManager();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume222 = startRestartGroup.consume(localFocusManager222);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                FocusManager focusManager222 = (FocusManager) consume222;
                long containerColor222 = searchBarColors3.getContainerColor();
                long m2381contentColorForek8zF_U222 = ColorSchemeKt.m2381contentColorForek8zF_U(searchBarColors3.getContainerColor(), startRestartGroup, 0);
                Modifier m1125width3ABfNKs222 = androidx.compose.foundation.layout.SizeKt.m1125width3ABfNKs(ZIndexModifierKt.zIndex(modifier2, 1.0f), SearchBarMinWidth);
                int i30222 = i22;
                final boolean z9222 = z4;
                int i31222 = i21;
                final Function2<? super Composer, ? super Integer, Unit> function214222 = function26;
                Modifier modifier5222 = modifier2;
                final Function2<? super Composer, ? super Integer, Unit> function215222 = function27;
                String str4222 = str3;
                final Function2<? super Composer, ? super Integer, Unit> function216222 = function25;
                final SearchBarColors searchBarColors5222 = searchBarColors3;
                final MutableInteractionSource mutableInteractionSource4222 = mutableInteractionSource2;
                int i32222 = i31222 << 6;
                SurfaceKt.m3043SurfaceT9BRK9s(m1125width3ABfNKs222, shape3, containerColor222, m2381contentColorForek8zF_U222, f3, f4, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1088676554, z3, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$2
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

                    public final void invoke(Composer composer3, int i33222) {
                        EnterTransition enterTransition;
                        ExitTransition exitTransition;
                        ComposerKt.sourceInformation(composer3, "C377@18458L1287:SearchBar.android.kt#uh7d8r");
                        if ((i33222 & 3) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1088676554, i33222, -1, "androidx.compose.material3.DockedSearchBar.<anonymous> (SearchBar.android.kt:377)");
                            }
                            String str5 = str;
                            Function1<String, Unit> function14 = function1;
                            Function1<String, Unit> function15 = function12;
                            boolean z10 = z;
                            Function1<Boolean, Unit> function16 = function13;
                            boolean z11 = z9222;
                            Function2<Composer, Integer, Unit> function217 = function214222;
                            Function2<Composer, Integer, Unit> function218 = function215222;
                            Function2<Composer, Integer, Unit> function219 = function216222;
                            final SearchBarColors searchBarColors6 = searchBarColors5222;
                            MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource4222;
                            final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                            composer3.startReplaceableGroup(-483455358);
                            ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                            Modifier.Companion companion = Modifier.INSTANCE;
                            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                            composer3.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                            Function0 constructor = ComposeUiNode.Companion.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
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
                            ComposerKt.sourceInformationMarkerStart(composer3, 1253285019, "C378@18479L502,392@18995L740:SearchBar.android.kt#uh7d8r");
                            SearchBar_androidKt.SearchBarInputField(str5, function14, function15, z10, function16, null, z11, function217, function218, function219, searchBarColors6.getInputFieldColors(), mutableInteractionSource5, composer3, 0, 0, 32);
                            enterTransition = SearchBar_androidKt.DockedEnterTransition;
                            exitTransition = SearchBar_androidKt.DockedExitTransition;
                            AnimatedVisibilityKt.AnimatedVisibility(columnScopeInstance, z10, (Modifier) null, enterTransition, exitTransition, (String) null, ComposableLambdaKt.composableLambda(composer3, 1804538904, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$2$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                    invoke((AnimatedVisibilityScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer4, int i34) {
                                    ComposerKt.sourceInformation(composer4, "C*397@19211L7,398@19269L115,401@19417L110,405@19545L176:SearchBar.android.kt#uh7d8r");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1804538904, i34, -1, "androidx.compose.material3.DockedSearchBar.<anonymous>.<anonymous>.<anonymous> (SearchBar.android.kt:397)");
                                    }
                                    ProvidableCompositionLocal localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
                                    ComposerKt.sourceInformationMarkerStart(composer4, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                    Object consume2222 = composer4.consume(localConfiguration);
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    float f7 = Dp.constructor-impl(((Configuration) consume2222).screenHeightDp);
                                    composer4.startReplaceableGroup(747855826);
                                    ComposerKt.sourceInformation(composer4, "CC(remember):SearchBar.android.kt#9igjgp");
                                    boolean changed2 = composer4.changed(f7);
                                    Object rememberedValue4 = composer4.rememberedValue();
                                    if (changed2 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue4 = Dp.box-impl(Dp.constructor-impl(f7 * 0.6666667f));
                                        composer4.updateRememberedValue(rememberedValue4);
                                    }
                                    float f8 = ((Dp) rememberedValue4).unbox-impl();
                                    composer4.endReplaceableGroup();
                                    composer4.startReplaceableGroup(747855974);
                                    ComposerKt.sourceInformation(composer4, "CC(remember):SearchBar.android.kt#9igjgp");
                                    boolean changed3 = composer4.changed(f8);
                                    Object rememberedValue5 = composer4.rememberedValue();
                                    if (changed3 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue5 = Dp.box-impl(RangesKt.coerceAtMost(Dp.box-impl(SearchBar_androidKt.getDockedActiveTableMinHeight()), Dp.box-impl(f8)).unbox-impl());
                                        composer4.updateRememberedValue(rememberedValue5);
                                    }
                                    float f9 = ((Dp) rememberedValue5).unbox-impl();
                                    composer4.endReplaceableGroup();
                                    Modifier m1107heightInVpY3zN4 = androidx.compose.foundation.layout.SizeKt.m1107heightInVpY3zN4(Modifier.INSTANCE, f9, f8);
                                    SearchBarColors searchBarColors7 = SearchBarColors.this;
                                    Function3<ColumnScope, Composer, Integer, Unit> function33 = function32;
                                    composer4.startReplaceableGroup(-483455358);
                                    ComposerKt.sourceInformation(composer4, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                    MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer4, 0);
                                    composer4.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                    CompositionLocalMap currentCompositionLocalMap2 = composer4.getCurrentCompositionLocalMap();
                                    Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m1107heightInVpY3zN4);
                                    if (!(composer4.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer4.startReusableNode();
                                    if (composer4.getInserting()) {
                                        composer4.createNode(constructor2);
                                    } else {
                                        composer4.useNode();
                                    }
                                    Composer m4109constructorimpl2 = Updater.m4109constructorimpl(composer4);
                                    Updater.m4116setimpl(m4109constructorimpl2, columnMeasurePolicy2, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                    Updater.m4116setimpl(m4109constructorimpl2, currentCompositionLocalMap2, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                    Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                    if (m4109constructorimpl2.getInserting() || !Intrinsics.areEqual(m4109constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                        m4109constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                        m4109constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                    }
                                    modifierMaterializerOf2.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer4)), composer4, 0);
                                    composer4.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer4, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                    ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer4, 1001846745, "C406@19627L46,407@19694L9:SearchBar.android.kt#uh7d8r");
                                    DividerKt.m2540HorizontalDivider9IZ8Weo(null, 0.0f, searchBarColors7.getDividerColor(), composer4, 0, 3);
                                    function33.invoke(columnScopeInstance2, composer4, 6);
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    composer4.endReplaceableGroup();
                                    composer4.endNode();
                                    composer4.endReplaceableGroup();
                                    composer4.endReplaceableGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composer3, 1600518, 18);
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
                }), startRestartGroup, ((i31222 << 3) & 112) | 12582912 | (57344 & i32222) | (i32222 & 458752), 64);
                composer2 = startRestartGroup;
                if (z) {
                }
                Boolean valueOf222 = Boolean.valueOf(z);
                composer2.startReplaceableGroup(-32070300);
                ComposerKt.sourceInformation(composer2, str4222);
                changed = composer2.changed(z5) | composer2.changedInstance(focusManager222);
                rememberedValue = composer2.rememberedValue();
                if (!changed) {
                }
                rememberedValue = new SearchBar_androidKt$DockedSearchBar$3$1(z5, focusManager222, null);
                composer2.updateRememberedValue(rememberedValue);
                composer2.endReplaceableGroup();
                int i33222 = (i30222 >> 9) & 14;
                EffectsKt.LaunchedEffect(valueOf222, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue, composer2, i33222);
                composer2.startReplaceableGroup(-32069972);
                ComposerKt.sourceInformation(composer2, str4222);
                if ((i30222 & 57344) != 16384) {
                }
                rememberedValue2 = composer2.rememberedValue();
                if (!z6) {
                }
                rememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$4$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m2850invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m2850invoke() {
                        function13.invoke(false);
                    }
                };
                composer2.updateRememberedValue(rememberedValue2);
                composer2.endReplaceableGroup();
                BackHandlerKt.BackHandler(z, (Function0) rememberedValue2, composer2, i33222, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                z7 = z4;
                function28 = function26;
                function29 = function27;
                function210 = function25;
                shape4 = shape3;
                searchBarColors4 = searchBarColors3;
                f5 = f3;
                f6 = f4;
                mutableInteractionSource3 = mutableInteractionSource2;
                modifier3 = modifier5222;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i14 = i3 & Fields.Shape;
            if (i14 != 0) {
            }
            i15 = i3 & Fields.Clip;
            if (i15 == 0) {
            }
            if ((i3 & Fields.CompositingStrategy) != 0) {
            }
            i16 = i15;
            int i282222 = i4;
            if ((i4 & 306783379) != 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i7 == 0) {
            }
            if (i8 == 0) {
            }
            if (i9 == 0) {
            }
            if (i10 == 0) {
            }
            if (i11 == 0) {
            }
            if ((i3 & Fields.RotationZ) == 0) {
            }
            int i292222 = i27;
            if ((i3 & Fields.CameraDistance) == 0) {
            }
            if (i13 == 0) {
            }
            if (i19 == 0) {
            }
            if (i18 == 0) {
            }
            modifier2 = modifier4;
            z4 = z8;
            function26 = function211;
            function27 = function212;
            shape3 = shape2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            ProvidableCompositionLocal localFocusManager2222 = CompositionLocalsKt.getLocalFocusManager();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2222 = startRestartGroup.consume(localFocusManager2222);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            FocusManager focusManager2222 = (FocusManager) consume2222;
            long containerColor2222 = searchBarColors3.getContainerColor();
            long m2381contentColorForek8zF_U2222 = ColorSchemeKt.m2381contentColorForek8zF_U(searchBarColors3.getContainerColor(), startRestartGroup, 0);
            Modifier m1125width3ABfNKs2222 = androidx.compose.foundation.layout.SizeKt.m1125width3ABfNKs(ZIndexModifierKt.zIndex(modifier2, 1.0f), SearchBarMinWidth);
            int i302222 = i22;
            final boolean z92222 = z4;
            int i312222 = i21;
            final Function2<? super Composer, ? super Integer, Unit> function2142222 = function26;
            Modifier modifier52222 = modifier2;
            final Function2<? super Composer, ? super Integer, Unit> function2152222 = function27;
            String str42222 = str3;
            final Function2<? super Composer, ? super Integer, Unit> function2162222 = function25;
            final SearchBarColors searchBarColors52222 = searchBarColors3;
            final MutableInteractionSource mutableInteractionSource42222 = mutableInteractionSource2;
            int i322222 = i312222 << 6;
            SurfaceKt.m3043SurfaceT9BRK9s(m1125width3ABfNKs2222, shape3, containerColor2222, m2381contentColorForek8zF_U2222, f3, f4, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1088676554, z3, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$2
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

                public final void invoke(Composer composer3, int i332222) {
                    EnterTransition enterTransition;
                    ExitTransition exitTransition;
                    ComposerKt.sourceInformation(composer3, "C377@18458L1287:SearchBar.android.kt#uh7d8r");
                    if ((i332222 & 3) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1088676554, i332222, -1, "androidx.compose.material3.DockedSearchBar.<anonymous> (SearchBar.android.kt:377)");
                        }
                        String str5 = str;
                        Function1<String, Unit> function14 = function1;
                        Function1<String, Unit> function15 = function12;
                        boolean z10 = z;
                        Function1<Boolean, Unit> function16 = function13;
                        boolean z11 = z92222;
                        Function2<Composer, Integer, Unit> function217 = function2142222;
                        Function2<Composer, Integer, Unit> function218 = function2152222;
                        Function2<Composer, Integer, Unit> function219 = function2162222;
                        final SearchBarColors searchBarColors6 = searchBarColors52222;
                        MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource42222;
                        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                        composer3.startReplaceableGroup(-483455358);
                        ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                        Modifier.Companion companion = Modifier.INSTANCE;
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                        Function0 constructor = ComposeUiNode.Companion.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
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
                        ComposerKt.sourceInformationMarkerStart(composer3, 1253285019, "C378@18479L502,392@18995L740:SearchBar.android.kt#uh7d8r");
                        SearchBar_androidKt.SearchBarInputField(str5, function14, function15, z10, function16, null, z11, function217, function218, function219, searchBarColors6.getInputFieldColors(), mutableInteractionSource5, composer3, 0, 0, 32);
                        enterTransition = SearchBar_androidKt.DockedEnterTransition;
                        exitTransition = SearchBar_androidKt.DockedExitTransition;
                        AnimatedVisibilityKt.AnimatedVisibility(columnScopeInstance, z10, (Modifier) null, enterTransition, exitTransition, (String) null, ComposableLambdaKt.composableLambda(composer3, 1804538904, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$2$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                invoke((AnimatedVisibilityScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer4, int i34) {
                                ComposerKt.sourceInformation(composer4, "C*397@19211L7,398@19269L115,401@19417L110,405@19545L176:SearchBar.android.kt#uh7d8r");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1804538904, i34, -1, "androidx.compose.material3.DockedSearchBar.<anonymous>.<anonymous>.<anonymous> (SearchBar.android.kt:397)");
                                }
                                ProvidableCompositionLocal localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
                                ComposerKt.sourceInformationMarkerStart(composer4, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object consume22222 = composer4.consume(localConfiguration);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                float f7 = Dp.constructor-impl(((Configuration) consume22222).screenHeightDp);
                                composer4.startReplaceableGroup(747855826);
                                ComposerKt.sourceInformation(composer4, "CC(remember):SearchBar.android.kt#9igjgp");
                                boolean changed2 = composer4.changed(f7);
                                Object rememberedValue4 = composer4.rememberedValue();
                                if (changed2 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue4 = Dp.box-impl(Dp.constructor-impl(f7 * 0.6666667f));
                                    composer4.updateRememberedValue(rememberedValue4);
                                }
                                float f8 = ((Dp) rememberedValue4).unbox-impl();
                                composer4.endReplaceableGroup();
                                composer4.startReplaceableGroup(747855974);
                                ComposerKt.sourceInformation(composer4, "CC(remember):SearchBar.android.kt#9igjgp");
                                boolean changed3 = composer4.changed(f8);
                                Object rememberedValue5 = composer4.rememberedValue();
                                if (changed3 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue5 = Dp.box-impl(RangesKt.coerceAtMost(Dp.box-impl(SearchBar_androidKt.getDockedActiveTableMinHeight()), Dp.box-impl(f8)).unbox-impl());
                                    composer4.updateRememberedValue(rememberedValue5);
                                }
                                float f9 = ((Dp) rememberedValue5).unbox-impl();
                                composer4.endReplaceableGroup();
                                Modifier m1107heightInVpY3zN4 = androidx.compose.foundation.layout.SizeKt.m1107heightInVpY3zN4(Modifier.INSTANCE, f9, f8);
                                SearchBarColors searchBarColors7 = SearchBarColors.this;
                                Function3<ColumnScope, Composer, Integer, Unit> function33 = function32;
                                composer4.startReplaceableGroup(-483455358);
                                ComposerKt.sourceInformation(composer4, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer4, 0);
                                composer4.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                CompositionLocalMap currentCompositionLocalMap2 = composer4.getCurrentCompositionLocalMap();
                                Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m1107heightInVpY3zN4);
                                if (!(composer4.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer4.startReusableNode();
                                if (composer4.getInserting()) {
                                    composer4.createNode(constructor2);
                                } else {
                                    composer4.useNode();
                                }
                                Composer m4109constructorimpl2 = Updater.m4109constructorimpl(composer4);
                                Updater.m4116setimpl(m4109constructorimpl2, columnMeasurePolicy2, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.m4116setimpl(m4109constructorimpl2, currentCompositionLocalMap2, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                if (m4109constructorimpl2.getInserting() || !Intrinsics.areEqual(m4109constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                    m4109constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                    m4109constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                }
                                modifierMaterializerOf2.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer4)), composer4, 0);
                                composer4.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(composer4, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer4, 1001846745, "C406@19627L46,407@19694L9:SearchBar.android.kt#uh7d8r");
                                DividerKt.m2540HorizontalDivider9IZ8Weo(null, 0.0f, searchBarColors7.getDividerColor(), composer4, 0, 3);
                                function33.invoke(columnScopeInstance2, composer4, 6);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                composer4.endReplaceableGroup();
                                composer4.endNode();
                                composer4.endReplaceableGroup();
                                composer4.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer3, 1600518, 18);
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
            }), startRestartGroup, ((i312222 << 3) & 112) | 12582912 | (57344 & i322222) | (i322222 & 458752), 64);
            composer2 = startRestartGroup;
            if (z) {
            }
            Boolean valueOf2222 = Boolean.valueOf(z);
            composer2.startReplaceableGroup(-32070300);
            ComposerKt.sourceInformation(composer2, str42222);
            changed = composer2.changed(z5) | composer2.changedInstance(focusManager2222);
            rememberedValue = composer2.rememberedValue();
            if (!changed) {
            }
            rememberedValue = new SearchBar_androidKt$DockedSearchBar$3$1(z5, focusManager2222, null);
            composer2.updateRememberedValue(rememberedValue);
            composer2.endReplaceableGroup();
            int i332222 = (i302222 >> 9) & 14;
            EffectsKt.LaunchedEffect(valueOf2222, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue, composer2, i332222);
            composer2.startReplaceableGroup(-32069972);
            ComposerKt.sourceInformation(composer2, str42222);
            if ((i302222 & 57344) != 16384) {
            }
            rememberedValue2 = composer2.rememberedValue();
            if (!z6) {
            }
            rememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$4$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m2850invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2850invoke() {
                    function13.invoke(false);
                }
            };
            composer2.updateRememberedValue(rememberedValue2);
            composer2.endReplaceableGroup();
            BackHandlerKt.BackHandler(z, (Function0) rememberedValue2, composer2, i332222, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            z7 = z4;
            function28 = function26;
            function29 = function27;
            function210 = function25;
            shape4 = shape3;
            searchBarColors4 = searchBarColors3;
            f5 = f3;
            f6 = f4;
            mutableInteractionSource3 = mutableInteractionSource2;
            modifier3 = modifier52222;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i5 = i3 & 8;
        int i252 = Fields.CameraDistance;
        if (i5 == 0) {
        }
        i6 = i3 & 16;
        int i262 = Fields.Shape;
        if (i6 == 0) {
        }
        i7 = i3 & 32;
        if (i7 == 0) {
        }
        i8 = i3 & 64;
        if (i8 == 0) {
        }
        i9 = i3 & Fields.SpotShadowColor;
        if (i9 == 0) {
        }
        i10 = i3 & Fields.RotationX;
        if (i10 == 0) {
        }
        i11 = i3 & Fields.RotationY;
        if (i11 == 0) {
        }
        if ((i2 & 6) != 0) {
        }
        if ((i2 & 48) == 0) {
        }
        int i272 = i12;
        i13 = i3 & Fields.TransformOrigin;
        if (i13 == 0) {
        }
        i14 = i3 & Fields.Shape;
        if (i14 != 0) {
        }
        i15 = i3 & Fields.Clip;
        if (i15 == 0) {
        }
        if ((i3 & Fields.CompositingStrategy) != 0) {
        }
        i16 = i15;
        int i2822222 = i4;
        if ((i4 & 306783379) != 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i7 == 0) {
        }
        if (i8 == 0) {
        }
        if (i9 == 0) {
        }
        if (i10 == 0) {
        }
        if (i11 == 0) {
        }
        if ((i3 & Fields.RotationZ) == 0) {
        }
        int i2922222 = i272;
        if ((i3 & Fields.CameraDistance) == 0) {
        }
        if (i13 == 0) {
        }
        if (i19 == 0) {
        }
        if (i18 == 0) {
        }
        modifier2 = modifier4;
        z4 = z8;
        function26 = function211;
        function27 = function212;
        shape3 = shape2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        ProvidableCompositionLocal localFocusManager22222 = CompositionLocalsKt.getLocalFocusManager();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume22222 = startRestartGroup.consume(localFocusManager22222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        FocusManager focusManager22222 = (FocusManager) consume22222;
        long containerColor22222 = searchBarColors3.getContainerColor();
        long m2381contentColorForek8zF_U22222 = ColorSchemeKt.m2381contentColorForek8zF_U(searchBarColors3.getContainerColor(), startRestartGroup, 0);
        Modifier m1125width3ABfNKs22222 = androidx.compose.foundation.layout.SizeKt.m1125width3ABfNKs(ZIndexModifierKt.zIndex(modifier2, 1.0f), SearchBarMinWidth);
        int i3022222 = i22;
        final boolean z922222 = z4;
        int i3122222 = i21;
        final Function2<? super Composer, ? super Integer, Unit> function21422222 = function26;
        Modifier modifier522222 = modifier2;
        final Function2<? super Composer, ? super Integer, Unit> function21522222 = function27;
        String str422222 = str3;
        final Function2<? super Composer, ? super Integer, Unit> function21622222 = function25;
        final SearchBarColors searchBarColors522222 = searchBarColors3;
        final MutableInteractionSource mutableInteractionSource422222 = mutableInteractionSource2;
        int i3222222 = i3122222 << 6;
        SurfaceKt.m3043SurfaceT9BRK9s(m1125width3ABfNKs22222, shape3, containerColor22222, m2381contentColorForek8zF_U22222, f3, f4, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1088676554, z3, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$2
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

            public final void invoke(Composer composer3, int i3322222) {
                EnterTransition enterTransition;
                ExitTransition exitTransition;
                ComposerKt.sourceInformation(composer3, "C377@18458L1287:SearchBar.android.kt#uh7d8r");
                if ((i3322222 & 3) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1088676554, i3322222, -1, "androidx.compose.material3.DockedSearchBar.<anonymous> (SearchBar.android.kt:377)");
                    }
                    String str5 = str;
                    Function1<String, Unit> function14 = function1;
                    Function1<String, Unit> function15 = function12;
                    boolean z10 = z;
                    Function1<Boolean, Unit> function16 = function13;
                    boolean z11 = z922222;
                    Function2<Composer, Integer, Unit> function217 = function21422222;
                    Function2<Composer, Integer, Unit> function218 = function21522222;
                    Function2<Composer, Integer, Unit> function219 = function21622222;
                    final SearchBarColors searchBarColors6 = searchBarColors522222;
                    MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource422222;
                    final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                    composer3.startReplaceableGroup(-483455358);
                    ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                    Modifier.Companion companion = Modifier.INSTANCE;
                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                    Function0 constructor = ComposeUiNode.Companion.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
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
                    ComposerKt.sourceInformationMarkerStart(composer3, 1253285019, "C378@18479L502,392@18995L740:SearchBar.android.kt#uh7d8r");
                    SearchBar_androidKt.SearchBarInputField(str5, function14, function15, z10, function16, null, z11, function217, function218, function219, searchBarColors6.getInputFieldColors(), mutableInteractionSource5, composer3, 0, 0, 32);
                    enterTransition = SearchBar_androidKt.DockedEnterTransition;
                    exitTransition = SearchBar_androidKt.DockedExitTransition;
                    AnimatedVisibilityKt.AnimatedVisibility(columnScopeInstance, z10, (Modifier) null, enterTransition, exitTransition, (String) null, ComposableLambdaKt.composableLambda(composer3, 1804538904, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$2$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                            invoke((AnimatedVisibilityScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer4, int i34) {
                            ComposerKt.sourceInformation(composer4, "C*397@19211L7,398@19269L115,401@19417L110,405@19545L176:SearchBar.android.kt#uh7d8r");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1804538904, i34, -1, "androidx.compose.material3.DockedSearchBar.<anonymous>.<anonymous>.<anonymous> (SearchBar.android.kt:397)");
                            }
                            ProvidableCompositionLocal localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
                            ComposerKt.sourceInformationMarkerStart(composer4, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume222222 = composer4.consume(localConfiguration);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            float f7 = Dp.constructor-impl(((Configuration) consume222222).screenHeightDp);
                            composer4.startReplaceableGroup(747855826);
                            ComposerKt.sourceInformation(composer4, "CC(remember):SearchBar.android.kt#9igjgp");
                            boolean changed2 = composer4.changed(f7);
                            Object rememberedValue4 = composer4.rememberedValue();
                            if (changed2 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue4 = Dp.box-impl(Dp.constructor-impl(f7 * 0.6666667f));
                                composer4.updateRememberedValue(rememberedValue4);
                            }
                            float f8 = ((Dp) rememberedValue4).unbox-impl();
                            composer4.endReplaceableGroup();
                            composer4.startReplaceableGroup(747855974);
                            ComposerKt.sourceInformation(composer4, "CC(remember):SearchBar.android.kt#9igjgp");
                            boolean changed3 = composer4.changed(f8);
                            Object rememberedValue5 = composer4.rememberedValue();
                            if (changed3 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue5 = Dp.box-impl(RangesKt.coerceAtMost(Dp.box-impl(SearchBar_androidKt.getDockedActiveTableMinHeight()), Dp.box-impl(f8)).unbox-impl());
                                composer4.updateRememberedValue(rememberedValue5);
                            }
                            float f9 = ((Dp) rememberedValue5).unbox-impl();
                            composer4.endReplaceableGroup();
                            Modifier m1107heightInVpY3zN4 = androidx.compose.foundation.layout.SizeKt.m1107heightInVpY3zN4(Modifier.INSTANCE, f9, f8);
                            SearchBarColors searchBarColors7 = SearchBarColors.this;
                            Function3<ColumnScope, Composer, Integer, Unit> function33 = function32;
                            composer4.startReplaceableGroup(-483455358);
                            ComposerKt.sourceInformation(composer4, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer4, 0);
                            composer4.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                            CompositionLocalMap currentCompositionLocalMap2 = composer4.getCurrentCompositionLocalMap();
                            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m1107heightInVpY3zN4);
                            if (!(composer4.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer4.startReusableNode();
                            if (composer4.getInserting()) {
                                composer4.createNode(constructor2);
                            } else {
                                composer4.useNode();
                            }
                            Composer m4109constructorimpl2 = Updater.m4109constructorimpl(composer4);
                            Updater.m4116setimpl(m4109constructorimpl2, columnMeasurePolicy2, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.m4116setimpl(m4109constructorimpl2, currentCompositionLocalMap2, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (m4109constructorimpl2.getInserting() || !Intrinsics.areEqual(m4109constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                m4109constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                m4109constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                            }
                            modifierMaterializerOf2.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer4)), composer4, 0);
                            composer4.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer4, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer4, 1001846745, "C406@19627L46,407@19694L9:SearchBar.android.kt#uh7d8r");
                            DividerKt.m2540HorizontalDivider9IZ8Weo(null, 0.0f, searchBarColors7.getDividerColor(), composer4, 0, 3);
                            function33.invoke(columnScopeInstance2, composer4, 6);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            composer4.endReplaceableGroup();
                            composer4.endNode();
                            composer4.endReplaceableGroup();
                            composer4.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer3, 1600518, 18);
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
        }), startRestartGroup, ((i3122222 << 3) & 112) | 12582912 | (57344 & i3222222) | (i3222222 & 458752), 64);
        composer2 = startRestartGroup;
        if (z) {
        }
        Boolean valueOf22222 = Boolean.valueOf(z);
        composer2.startReplaceableGroup(-32070300);
        ComposerKt.sourceInformation(composer2, str422222);
        changed = composer2.changed(z5) | composer2.changedInstance(focusManager22222);
        rememberedValue = composer2.rememberedValue();
        if (!changed) {
        }
        rememberedValue = new SearchBar_androidKt$DockedSearchBar$3$1(z5, focusManager22222, null);
        composer2.updateRememberedValue(rememberedValue);
        composer2.endReplaceableGroup();
        int i3322222 = (i3022222 >> 9) & 14;
        EffectsKt.LaunchedEffect(valueOf22222, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue, composer2, i3322222);
        composer2.startReplaceableGroup(-32069972);
        ComposerKt.sourceInformation(composer2, str422222);
        if ((i3022222 & 57344) != 16384) {
        }
        rememberedValue2 = composer2.rememberedValue();
        if (!z6) {
        }
        rememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$4$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m2850invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2850invoke() {
                function13.invoke(false);
            }
        };
        composer2.updateRememberedValue(rememberedValue2);
        composer2.endReplaceableGroup();
        BackHandlerKt.BackHandler(z, (Function0) rememberedValue2, composer2, i3322222, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        z7 = z4;
        function28 = function26;
        function29 = function27;
        function210 = function25;
        shape4 = shape3;
        searchBarColors4 = searchBarColors3;
        f5 = f3;
        f6 = f4;
        mutableInteractionSource3 = mutableInteractionSource2;
        modifier3 = modifier522222;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0462, code lost:
    
        if (r8 == androidx.compose.runtime.Composer.INSTANCE.getEmpty()) goto L214;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x04eb  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0454  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x044c  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0502  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0371  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x044a  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0452  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x045c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SearchBarInputField(final String str, final Function1<? super String, Unit> function1, final Function1<? super String, Unit> function12, final boolean z, final Function1<? super Boolean, Unit> function13, Modifier modifier, boolean z2, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, TextFieldColors textFieldColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        int i5;
        Modifier modifier2;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        MutableInteractionSource mutableInteractionSource2;
        int i13;
        boolean z3;
        Function2<? super Composer, ? super Integer, Unit> function24;
        int i14;
        TextFieldColors textFieldColors2;
        Function2<? super Composer, ? super Integer, Unit> function25;
        MutableInteractionSource mutableInteractionSource3;
        Modifier modifier3;
        Function2<? super Composer, ? super Integer, Unit> function26;
        Function2<? super Composer, ? super Integer, Unit> function27;
        TextFieldColors textFieldColors3;
        Object rememberedValue;
        long j;
        boolean z4;
        Object rememberedValue2;
        boolean changed;
        Object rememberedValue3;
        boolean z5;
        Object obj;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function28;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        final MutableInteractionSource mutableInteractionSource4;
        final TextFieldColors textFieldColors4;
        final Modifier modifier4;
        final boolean z6;
        ScopeUpdateScope endRestartGroup;
        int i15;
        Composer startRestartGroup = composer.startRestartGroup(496394889);
        ComposerKt.sourceInformation(startRestartGroup, "C(SearchBarInputField)P(10,7,8!1,6,5,2,9,4,11)442@20766L18,443@20836L39,445@20906L29,446@20962L34,447@21037L39,459@21490L42,460@21556L304,472@21951L7,473@22036L28,475@22199L19,452@21246L2004:SearchBar.android.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
            if ((i3 & 4) == 0) {
                i4 |= 384;
            } else if ((i & 384) == 0) {
                i4 |= startRestartGroup.changedInstance(function12) ? Fields.RotationX : Fields.SpotShadowColor;
            }
            if ((i3 & 8) == 0) {
                i4 |= 3072;
            } else if ((i & 3072) == 0) {
                i4 |= startRestartGroup.changed(z) ? Fields.CameraDistance : Fields.RotationZ;
            }
            if ((i3 & 16) == 0) {
                i4 |= 24576;
            } else if ((i & 24576) == 0) {
                i4 |= startRestartGroup.changedInstance(function13) ? Fields.Clip : Fields.Shape;
            }
            i5 = i3 & 32;
            if (i5 == 0) {
                i4 |= 196608;
                modifier2 = modifier;
            } else {
                modifier2 = modifier;
                if ((i & 196608) == 0) {
                    i4 |= startRestartGroup.changed(modifier2) ? Fields.RenderEffect : 65536;
                }
            }
            i6 = i3 & 64;
            if (i6 == 0) {
                i4 |= 1572864;
            } else if ((i & 1572864) == 0) {
                i4 |= startRestartGroup.changed(z2) ? 1048576 : Fields.BlendMode;
            }
            i7 = i3 & Fields.SpotShadowColor;
            if (i7 == 0) {
                i4 |= 12582912;
            } else if ((i & 12582912) == 0) {
                i4 |= startRestartGroup.changedInstance(function2) ? 8388608 : 4194304;
            }
            i8 = i3 & Fields.RotationX;
            if (i8 == 0) {
                i4 |= 100663296;
            } else if ((i & 100663296) == 0) {
                i4 |= startRestartGroup.changedInstance(function22) ? 67108864 : 33554432;
            }
            i9 = i3 & Fields.RotationY;
            if (i9 == 0) {
                i4 |= 805306368;
            } else if ((i & 805306368) == 0) {
                i4 |= startRestartGroup.changedInstance(function23) ? 536870912 : 268435456;
            }
            if ((i2 & 6) != 0) {
                if ((i3 & Fields.RotationZ) == 0 && startRestartGroup.changed(textFieldColors)) {
                    i15 = 4;
                    i10 = i2 | i15;
                }
                i15 = 2;
                i10 = i2 | i15;
            } else {
                i10 = i2;
            }
            i11 = i3 & Fields.CameraDistance;
            if (i11 == 0) {
                i12 = i11;
                i13 = i10 | 48;
                mutableInteractionSource2 = mutableInteractionSource;
            } else {
                if ((i2 & 48) == 0) {
                    i12 = i11;
                    mutableInteractionSource2 = mutableInteractionSource;
                    i10 |= startRestartGroup.changed(mutableInteractionSource2) ? 32 : 16;
                } else {
                    i12 = i11;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                i13 = i10;
            }
            if ((i4 & 306783379) != 306783378 && (i13 & 19) == 18 && startRestartGroup.getSkipping()) {
                startRestartGroup.skipToGroupEnd();
                z6 = z2;
                function28 = function2;
                function29 = function22;
                function210 = function23;
                modifier4 = modifier2;
                composer2 = startRestartGroup;
                mutableInteractionSource4 = mutableInteractionSource2;
                textFieldColors4 = textFieldColors;
            } else {
                startRestartGroup.startDefaults();
                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                    Modifier.Companion companion = i5 == 0 ? Modifier.INSTANCE : modifier;
                    z3 = i6 == 0 ? true : z2;
                    Function2<? super Composer, ? super Integer, Unit> function211 = i7 == 0 ? null : function2;
                    Function2<? super Composer, ? super Integer, Unit> function212 = i8 == 0 ? null : function22;
                    Function2<? super Composer, ? super Integer, Unit> function213 = i9 == 0 ? null : function23;
                    if ((i3 & Fields.RotationZ) == 0) {
                        function24 = function213;
                        i14 = i12;
                        textFieldColors2 = SearchBarDefaults.INSTANCE.m2847inputFieldColorsITpI4ow(0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, startRestartGroup, 0, 24576, 16383);
                        i13 &= -15;
                    } else {
                        function24 = function213;
                        i14 = i12;
                        textFieldColors2 = textFieldColors;
                    }
                    if (i14 == 0) {
                        startRestartGroup.startReplaceableGroup(462567468);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SearchBar.android.kt#9igjgp");
                        Object rememberedValue4 = startRestartGroup.rememberedValue();
                        if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue4 = InteractionSourceKt.MutableInteractionSource();
                            startRestartGroup.updateRememberedValue(rememberedValue4);
                        }
                        startRestartGroup.endReplaceableGroup();
                        function25 = function24;
                        mutableInteractionSource3 = (MutableInteractionSource) rememberedValue4;
                    } else {
                        function25 = function24;
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    modifier3 = companion;
                    function26 = function211;
                    function27 = function212;
                    textFieldColors3 = textFieldColors2;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    if ((i3 & Fields.RotationZ) != 0) {
                        i13 &= -15;
                    }
                    modifier3 = modifier;
                    z3 = z2;
                    function26 = function2;
                    function27 = function22;
                    function25 = function23;
                    textFieldColors3 = textFieldColors;
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                int i16 = i13;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(496394889, i4, i16, "androidx.compose.material3.SearchBarInputField (SearchBar.android.kt:444)");
                }
                startRestartGroup.startReplaceableGroup(462567538);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SearchBar.android.kt#9igjgp");
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new FocusRequester();
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                final FocusRequester focusRequester = (FocusRequester) rememberedValue;
                startRestartGroup.endReplaceableGroup();
                Strings.Companion companion2 = Strings.INSTANCE;
                final String m3033getStringNWtq28 = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0675R.string.m3c_search_bar_search), startRestartGroup, 0);
                Strings.Companion companion3 = Strings.INSTANCE;
                final String m3033getStringNWtq282 = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0675R.string.m3c_suggestions_available), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(462567758);
                ComposerKt.sourceInformation(startRestartGroup, "*448@21112L7,449@21154L74");
                ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume = startRestartGroup.consume(localTextStyle);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                j = ((TextStyle) consume).getColor-0d7_KjU();
                if (!(j == Color.INSTANCE.m4875getUnspecified0d7_KjU())) {
                    j = textFieldColors3.textColor$material3_release(z3, false, mutableInteractionSource3, startRestartGroup, ((i16 << 3) & 896) | ((i4 >> 18) & 14) | 48 | ((i16 << 9) & 7168)).getValue().m4849unboximpl();
                }
                long j2 = j;
                startRestartGroup.endReplaceableGroup();
                Modifier modifier5 = modifier3;
                Modifier focusRequester2 = FocusRequesterModifierKt.focusRequester(androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(androidx.compose.foundation.layout.SizeKt.m1106height3ABfNKs(modifier3, SearchBarDefaults.INSTANCE.m2843getInputFieldHeightD9Ej5fM()), 0.0f, 1, null), focusRequester);
                startRestartGroup.startReplaceableGroup(462568122);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SearchBar.android.kt#9igjgp");
                z4 = (57344 & i4) != 16384;
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (!z4 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = (Function1) new Function1<FocusState, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarInputField$2$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                            invoke((FocusState) obj2);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(FocusState focusState) {
                            if (focusState.isFocused()) {
                                function13.invoke(true);
                            }
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceableGroup();
                Modifier onFocusChanged = FocusChangedModifierKt.onFocusChanged(focusRequester2, (Function1) rememberedValue2);
                startRestartGroup.startReplaceableGroup(462568188);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SearchBar.android.kt#9igjgp");
                changed = startRestartGroup.changed(m3033getStringNWtq28) | ((i4 & 7168) != 2048) | startRestartGroup.changed(m3033getStringNWtq282);
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (!changed || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue3 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarInputField$3$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                            invoke((SemanticsPropertyReceiver) obj2);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, m3033getStringNWtq28);
                            if (z) {
                                SemanticsPropertiesKt.setStateDescription(semanticsPropertyReceiver, m3033getStringNWtq282);
                            }
                            final FocusRequester focusRequester3 = focusRequester;
                            SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, (String) null, new Function0<Boolean>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarInputField$3$1.1
                                {
                                    super(0);
                                }

                                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                public final Boolean m2857invoke() {
                                    FocusRequester.this.requestFocus();
                                    return true;
                                }
                            }, 1, (Object) null);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceableGroup();
                Modifier semantics$default = SemanticsModifierKt.semantics$default(onFocusChanged, false, (Function1) rememberedValue3, 1, (Object) null);
                ProvidableCompositionLocal<TextStyle> localTextStyle2 = TextKt.getLocalTextStyle();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume2 = startRestartGroup.consume(localTextStyle2);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                TextStyle merge = ((TextStyle) consume2).merge(new TextStyle(j2, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
                SolidColor solidColor = new SolidColor(textFieldColors3.cursorColor$material3_release(false, startRestartGroup, ((i16 << 3) & 112) | 6).getValue().m4849unboximpl(), null);
                KeyboardOptions keyboardOptions = new KeyboardOptions(0, false, 0, ImeAction.Companion.getSearch-eUduSuo(), (PlatformImeOptions) null, 23, (DefaultConstructorMarker) null);
                startRestartGroup.startReplaceableGroup(462568831);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SearchBar.android.kt#9igjgp");
                int i17 = i4 & 14;
                z5 = ((i4 & 896) != 256) | (i17 != 4);
                Object rememberedValue5 = startRestartGroup.rememberedValue();
                if (!z5) {
                    obj = rememberedValue5;
                }
                Function1<KeyboardActionScope, Unit> function14 = new Function1<KeyboardActionScope, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarInputField$4$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        invoke((KeyboardActionScope) obj2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(KeyboardActionScope keyboardActionScope) {
                        function12.invoke(str);
                    }
                };
                startRestartGroup.updateRememberedValue(function14);
                obj = function14;
                startRestartGroup.endReplaceableGroup();
                int i18 = i4;
                final boolean z7 = z3;
                final MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource3;
                final Function2<? super Composer, ? super Integer, Unit> function214 = function26;
                final Function2<? super Composer, ? super Integer, Unit> function215 = function27;
                final Function2<? super Composer, ? super Integer, Unit> function216 = function25;
                final TextFieldColors textFieldColors5 = textFieldColors3;
                TextFieldColors textFieldColors6 = textFieldColors3;
                composer2 = startRestartGroup;
                BasicTextFieldKt.BasicTextField(str, function1, semantics$default, z3, false, merge, keyboardOptions, new KeyboardActions(null, null, null, null, (Function1) obj, null, 47, null), true, 0, 0, (VisualTransformation) null, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource3, (Brush) solidColor, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(startRestartGroup, -951844929, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarInputField$5
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4) {
                        invoke((Function2<? super Composer, ? super Integer, Unit>) obj2, (Composer) obj3, ((Number) obj4).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Function2<? super Composer, ? super Integer, Unit> function217, Composer composer3, int i19) {
                        int i20;
                        ComposerKt.sourceInformation(composer3, "C492@23058L15,478@22354L880:SearchBar.android.kt#uh7d8r");
                        if ((i19 & 6) == 0) {
                            i20 = i19 | (composer3.changedInstance(function217) ? 4 : 2);
                        } else {
                            i20 = i19;
                        }
                        if ((i20 & 19) != 18 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-951844929, i20, -1, "androidx.compose.material3.SearchBarInputField.<anonymous> (SearchBar.android.kt:478)");
                            }
                            TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                            String str2 = str;
                            boolean z8 = z7;
                            VisualTransformation none = VisualTransformation.Companion.getNone();
                            MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource5;
                            Function2<Composer, Integer, Unit> function218 = function214;
                            final Function2<Composer, Integer, Unit> function219 = function215;
                            ComposableLambda composableLambda = function219 != null ? ComposableLambdaKt.composableLambda(composer3, -1030845367, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarInputField$5$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                    invoke((Composer) obj2, ((Number) obj3).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer4, int i21) {
                                    float f;
                                    ComposerKt.sourceInformation(composer4, "C487@22765L60:SearchBar.android.kt#uh7d8r");
                                    if ((i21 & 3) == 2 && composer4.getSkipping()) {
                                        composer4.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1030845367, i21, -1, "androidx.compose.material3.SearchBarInputField.<anonymous>.<anonymous>.<anonymous> (SearchBar.android.kt:487)");
                                    }
                                    Modifier.Companion companion4 = Modifier.INSTANCE;
                                    f = SearchBar_androidKt.SearchBarIconOffsetX;
                                    Modifier m1017offsetVpY3zN4$default = OffsetKt.m1017offsetVpY3zN4$default(companion4, f, 0.0f, 2, null);
                                    Function2<Composer, Integer, Unit> function220 = function219;
                                    composer4.startReplaceableGroup(733328855);
                                    ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer4, 0);
                                    composer4.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                    Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m1017offsetVpY3zN4$default);
                                    if (!(composer4.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer4.startReusableNode();
                                    if (composer4.getInserting()) {
                                        composer4.createNode(constructor);
                                    } else {
                                        composer4.useNode();
                                    }
                                    Composer m4109constructorimpl = Updater.m4109constructorimpl(composer4);
                                    Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                    Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                    Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                    if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer4)), composer4, 0);
                                    composer4.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer4, 643342186, "C487@22814L9:SearchBar.android.kt#uh7d8r");
                                    function220.invoke(composer4, 0);
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    composer4.endReplaceableGroup();
                                    composer4.endNode();
                                    composer4.endReplaceableGroup();
                                    composer4.endReplaceableGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }) : null;
                            final Function2<Composer, Integer, Unit> function220 = function216;
                            textFieldDefaults.DecorationBox(str2, function217, z8, true, none, mutableInteractionSource6, false, null, function218, composableLambda, function220 != null ? ComposableLambdaKt.composableLambda(composer3, -1558904811, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarInputField$5$2$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                    invoke((Composer) obj2, ((Number) obj3).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer4, int i21) {
                                    float f;
                                    ComposerKt.sourceInformation(composer4, "C490@22932L62:SearchBar.android.kt#uh7d8r");
                                    if ((i21 & 3) == 2 && composer4.getSkipping()) {
                                        composer4.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1558904811, i21, -1, "androidx.compose.material3.SearchBarInputField.<anonymous>.<anonymous>.<anonymous> (SearchBar.android.kt:490)");
                                    }
                                    Modifier.Companion companion4 = Modifier.INSTANCE;
                                    f = SearchBar_androidKt.SearchBarIconOffsetX;
                                    Modifier m1017offsetVpY3zN4$default = OffsetKt.m1017offsetVpY3zN4$default(companion4, Dp.constructor-impl(-f), 0.0f, 2, null);
                                    Function2<Composer, Integer, Unit> function221 = function220;
                                    composer4.startReplaceableGroup(733328855);
                                    ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer4, 0);
                                    composer4.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                    Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m1017offsetVpY3zN4$default);
                                    if (!(composer4.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer4.startReusableNode();
                                    if (composer4.getInserting()) {
                                        composer4.createNode(constructor);
                                    } else {
                                        composer4.useNode();
                                    }
                                    Composer m4109constructorimpl = Updater.m4109constructorimpl(composer4);
                                    Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                    Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                    Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                    if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer4)), composer4, 0);
                                    composer4.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer4, 643342354, "C490@22982L10:SearchBar.android.kt#uh7d8r");
                                    function221.invoke(composer4, 0);
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    composer4.endReplaceableGroup();
                                    composer4.endNode();
                                    composer4.endReplaceableGroup();
                                    composer4.endReplaceableGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }) : null, null, null, null, SearchBarDefaults.INSTANCE.getInputFieldShape(composer3, 6), textFieldColors5, TextFieldDefaults.m3160contentPaddingWithoutLabela9UjIt4$default(TextFieldDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 15, null), ComposableSingletons$SearchBar_androidKt.INSTANCE.m2422getLambda1$material3_release(), composer3, ((i20 << 3) & 112) | 27648, 113246208, 14528);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }), startRestartGroup, 102236160 | i17 | (i18 & 112) | ((i18 >> 9) & 7168), ((i16 << 6) & 7168) | 196608, 7696);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function28 = function26;
                function29 = function27;
                function210 = function25;
                mutableInteractionSource4 = mutableInteractionSource3;
                textFieldColors4 = textFieldColors6;
                modifier4 = modifier5;
                z6 = z3;
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarInputField$6
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                        invoke((Composer) obj2, ((Number) obj3).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i19) {
                        SearchBar_androidKt.SearchBarInputField(str, function1, function12, z, function13, modifier4, z6, function28, function29, function210, textFieldColors4, mutableInteractionSource4, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                    }
                });
                return;
            }
            return;
        }
        if ((i3 & 4) == 0) {
        }
        if ((i3 & 8) == 0) {
        }
        if ((i3 & 16) == 0) {
        }
        i5 = i3 & 32;
        if (i5 == 0) {
        }
        i6 = i3 & 64;
        if (i6 == 0) {
        }
        i7 = i3 & Fields.SpotShadowColor;
        if (i7 == 0) {
        }
        i8 = i3 & Fields.RotationX;
        if (i8 == 0) {
        }
        i9 = i3 & Fields.RotationY;
        if (i9 == 0) {
        }
        if ((i2 & 6) != 0) {
        }
        i11 = i3 & Fields.CameraDistance;
        if (i11 == 0) {
        }
        if ((i4 & 306783379) != 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i5 == 0) {
        }
        if (i6 == 0) {
        }
        if (i7 == 0) {
        }
        if (i8 == 0) {
        }
        if (i9 == 0) {
        }
        if ((i3 & Fields.RotationZ) == 0) {
        }
        if (i14 == 0) {
        }
        modifier3 = companion;
        function26 = function211;
        function27 = function212;
        textFieldColors3 = textFieldColors2;
        int i162 = i13;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceableGroup(462567538);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SearchBar.android.kt#9igjgp");
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
        }
        final FocusRequester focusRequester3 = (FocusRequester) rememberedValue;
        startRestartGroup.endReplaceableGroup();
        Strings.Companion companion22 = Strings.INSTANCE;
        final String m3033getStringNWtq283 = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0675R.string.m3c_search_bar_search), startRestartGroup, 0);
        Strings.Companion companion32 = Strings.INSTANCE;
        final String m3033getStringNWtq2822 = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0675R.string.m3c_suggestions_available), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(462567758);
        ComposerKt.sourceInformation(startRestartGroup, "*448@21112L7,449@21154L74");
        ProvidableCompositionLocal<TextStyle> localTextStyle3 = TextKt.getLocalTextStyle();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume3 = startRestartGroup.consume(localTextStyle3);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        j = ((TextStyle) consume3).getColor-0d7_KjU();
        if (!(j == Color.INSTANCE.m4875getUnspecified0d7_KjU())) {
        }
        long j22 = j;
        startRestartGroup.endReplaceableGroup();
        Modifier modifier52 = modifier3;
        Modifier focusRequester22 = FocusRequesterModifierKt.focusRequester(androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(androidx.compose.foundation.layout.SizeKt.m1106height3ABfNKs(modifier3, SearchBarDefaults.INSTANCE.m2843getInputFieldHeightD9Ej5fM()), 0.0f, 1, null), focusRequester3);
        startRestartGroup.startReplaceableGroup(462568122);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SearchBar.android.kt#9igjgp");
        if ((57344 & i4) != 16384) {
        }
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (!z4) {
        }
        rememberedValue2 = (Function1) new Function1<FocusState, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarInputField$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                invoke((FocusState) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(FocusState focusState) {
                if (focusState.isFocused()) {
                    function13.invoke(true);
                }
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue2);
        startRestartGroup.endReplaceableGroup();
        Modifier onFocusChanged2 = FocusChangedModifierKt.onFocusChanged(focusRequester22, (Function1) rememberedValue2);
        startRestartGroup.startReplaceableGroup(462568188);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SearchBar.android.kt#9igjgp");
        changed = startRestartGroup.changed(m3033getStringNWtq283) | ((i4 & 7168) != 2048) | startRestartGroup.changed(m3033getStringNWtq2822);
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue3 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarInputField$3$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                invoke((SemanticsPropertyReceiver) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, m3033getStringNWtq283);
                if (z) {
                    SemanticsPropertiesKt.setStateDescription(semanticsPropertyReceiver, m3033getStringNWtq2822);
                }
                final FocusRequester focusRequester32 = focusRequester3;
                SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, (String) null, new Function0<Boolean>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarInputField$3$1.1
                    {
                        super(0);
                    }

                    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                    public final Boolean m2857invoke() {
                        FocusRequester.this.requestFocus();
                        return true;
                    }
                }, 1, (Object) null);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue3);
        startRestartGroup.endReplaceableGroup();
        Modifier semantics$default2 = SemanticsModifierKt.semantics$default(onFocusChanged2, false, (Function1) rememberedValue3, 1, (Object) null);
        ProvidableCompositionLocal<TextStyle> localTextStyle22 = TextKt.getLocalTextStyle();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume22 = startRestartGroup.consume(localTextStyle22);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        TextStyle merge2 = ((TextStyle) consume22).merge(new TextStyle(j22, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
        SolidColor solidColor2 = new SolidColor(textFieldColors3.cursorColor$material3_release(false, startRestartGroup, ((i162 << 3) & 112) | 6).getValue().m4849unboximpl(), null);
        KeyboardOptions keyboardOptions2 = new KeyboardOptions(0, false, 0, ImeAction.Companion.getSearch-eUduSuo(), (PlatformImeOptions) null, 23, (DefaultConstructorMarker) null);
        startRestartGroup.startReplaceableGroup(462568831);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SearchBar.android.kt#9igjgp");
        int i172 = i4 & 14;
        z5 = ((i4 & 896) != 256) | (i172 != 4);
        Object rememberedValue52 = startRestartGroup.rememberedValue();
        if (!z5) {
        }
        Function1<KeyboardActionScope, Unit> function142 = new Function1<KeyboardActionScope, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarInputField$4$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                invoke((KeyboardActionScope) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(KeyboardActionScope keyboardActionScope) {
                function12.invoke(str);
            }
        };
        startRestartGroup.updateRememberedValue(function142);
        obj = function142;
        startRestartGroup.endReplaceableGroup();
        int i182 = i4;
        final boolean z72 = z3;
        final MutableInteractionSource mutableInteractionSource52 = mutableInteractionSource3;
        final Function2<? super Composer, ? super Integer, Unit> function2142 = function26;
        final Function2<? super Composer, ? super Integer, Unit> function2152 = function27;
        final Function2<? super Composer, ? super Integer, Unit> function2162 = function25;
        final TextFieldColors textFieldColors52 = textFieldColors3;
        TextFieldColors textFieldColors62 = textFieldColors3;
        composer2 = startRestartGroup;
        BasicTextFieldKt.BasicTextField(str, function1, semantics$default2, z3, false, merge2, keyboardOptions2, new KeyboardActions(null, null, null, null, (Function1) obj, null, 47, null), true, 0, 0, (VisualTransformation) null, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource3, (Brush) solidColor2, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(startRestartGroup, -951844929, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarInputField$5
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4) {
                invoke((Function2<? super Composer, ? super Integer, Unit>) obj2, (Composer) obj3, ((Number) obj4).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Function2<? super Composer, ? super Integer, Unit> function217, Composer composer3, int i19) {
                int i20;
                ComposerKt.sourceInformation(composer3, "C492@23058L15,478@22354L880:SearchBar.android.kt#uh7d8r");
                if ((i19 & 6) == 0) {
                    i20 = i19 | (composer3.changedInstance(function217) ? 4 : 2);
                } else {
                    i20 = i19;
                }
                if ((i20 & 19) != 18 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-951844929, i20, -1, "androidx.compose.material3.SearchBarInputField.<anonymous> (SearchBar.android.kt:478)");
                    }
                    TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                    String str2 = str;
                    boolean z8 = z72;
                    VisualTransformation none = VisualTransformation.Companion.getNone();
                    MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource52;
                    Function2<Composer, Integer, Unit> function218 = function2142;
                    final Function2<? super Composer, ? super Integer, Unit> function219 = function2152;
                    ComposableLambda composableLambda = function219 != null ? ComposableLambdaKt.composableLambda(composer3, -1030845367, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarInputField$5$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                            invoke((Composer) obj2, ((Number) obj3).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer4, int i21) {
                            float f;
                            ComposerKt.sourceInformation(composer4, "C487@22765L60:SearchBar.android.kt#uh7d8r");
                            if ((i21 & 3) == 2 && composer4.getSkipping()) {
                                composer4.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1030845367, i21, -1, "androidx.compose.material3.SearchBarInputField.<anonymous>.<anonymous>.<anonymous> (SearchBar.android.kt:487)");
                            }
                            Modifier.Companion companion4 = Modifier.INSTANCE;
                            f = SearchBar_androidKt.SearchBarIconOffsetX;
                            Modifier m1017offsetVpY3zN4$default = OffsetKt.m1017offsetVpY3zN4$default(companion4, f, 0.0f, 2, null);
                            Function2<Composer, Integer, Unit> function220 = function219;
                            composer4.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer4, 0);
                            composer4.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                            Function0 constructor = ComposeUiNode.Companion.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m1017offsetVpY3zN4$default);
                            if (!(composer4.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer4.startReusableNode();
                            if (composer4.getInserting()) {
                                composer4.createNode(constructor);
                            } else {
                                composer4.useNode();
                            }
                            Composer m4109constructorimpl = Updater.m4109constructorimpl(composer4);
                            Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer4)), composer4, 0);
                            composer4.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer4, 643342186, "C487@22814L9:SearchBar.android.kt#uh7d8r");
                            function220.invoke(composer4, 0);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            composer4.endReplaceableGroup();
                            composer4.endNode();
                            composer4.endReplaceableGroup();
                            composer4.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }) : null;
                    final Function2<? super Composer, ? super Integer, Unit> function220 = function2162;
                    textFieldDefaults.DecorationBox(str2, function217, z8, true, none, mutableInteractionSource6, false, null, function218, composableLambda, function220 != null ? ComposableLambdaKt.composableLambda(composer3, -1558904811, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarInputField$5$2$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                            invoke((Composer) obj2, ((Number) obj3).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer4, int i21) {
                            float f;
                            ComposerKt.sourceInformation(composer4, "C490@22932L62:SearchBar.android.kt#uh7d8r");
                            if ((i21 & 3) == 2 && composer4.getSkipping()) {
                                composer4.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1558904811, i21, -1, "androidx.compose.material3.SearchBarInputField.<anonymous>.<anonymous>.<anonymous> (SearchBar.android.kt:490)");
                            }
                            Modifier.Companion companion4 = Modifier.INSTANCE;
                            f = SearchBar_androidKt.SearchBarIconOffsetX;
                            Modifier m1017offsetVpY3zN4$default = OffsetKt.m1017offsetVpY3zN4$default(companion4, Dp.constructor-impl(-f), 0.0f, 2, null);
                            Function2<Composer, Integer, Unit> function221 = function220;
                            composer4.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composer4, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer4, 0);
                            composer4.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                            Function0 constructor = ComposeUiNode.Companion.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m1017offsetVpY3zN4$default);
                            if (!(composer4.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer4.startReusableNode();
                            if (composer4.getInserting()) {
                                composer4.createNode(constructor);
                            } else {
                                composer4.useNode();
                            }
                            Composer m4109constructorimpl = Updater.m4109constructorimpl(composer4);
                            Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer4)), composer4, 0);
                            composer4.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer4, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer4, 643342354, "C490@22982L10:SearchBar.android.kt#uh7d8r");
                            function221.invoke(composer4, 0);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            ComposerKt.sourceInformationMarkerEnd(composer4);
                            composer4.endReplaceableGroup();
                            composer4.endNode();
                            composer4.endReplaceableGroup();
                            composer4.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }) : null, null, null, null, SearchBarDefaults.INSTANCE.getInputFieldShape(composer3, 6), textFieldColors52, TextFieldDefaults.m3160contentPaddingWithoutLabela9UjIt4$default(TextFieldDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 15, null), ComposableSingletons$SearchBar_androidKt.INSTANCE.m2422getLambda1$material3_release(), composer3, ((i20 << 3) & 112) | 27648, 113246208, 14528);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer3.skipToGroupEnd();
            }
        }), startRestartGroup, 102236160 | i172 | (i182 & 112) | ((i182 >> 9) & 7168), ((i162 << 6) & 7168) | 196608, 7696);
        if (ComposerKt.isTraceInProgress()) {
        }
        function28 = function26;
        function29 = function27;
        function210 = function25;
        mutableInteractionSource4 = mutableInteractionSource3;
        textFieldColors4 = textFieldColors62;
        modifier4 = modifier52;
        z6 = z3;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    static {
        CubicBezierEasing easingEmphasizedDecelerateCubicBezier = MotionTokens.INSTANCE.getEasingEmphasizedDecelerateCubicBezier();
        AnimationEnterEasing = easingEmphasizedDecelerateCubicBezier;
        CubicBezierEasing cubicBezierEasing = new CubicBezierEasing(0.0f, 1.0f, 0.0f, 1.0f);
        AnimationExitEasing = cubicBezierEasing;
        TweenSpec tween = AnimationSpecKt.tween(AnimationEnterDurationMillis, 100, easingEmphasizedDecelerateCubicBezier);
        AnimationEnterFloatSpec = tween;
        TweenSpec tween2 = AnimationSpecKt.tween(AnimationExitDurationMillis, 100, cubicBezierEasing);
        AnimationExitFloatSpec = tween2;
        TweenSpec tween3 = AnimationSpecKt.tween(AnimationEnterDurationMillis, 100, easingEmphasizedDecelerateCubicBezier);
        AnimationEnterSizeSpec = tween3;
        TweenSpec tween4 = AnimationSpecKt.tween(AnimationExitDurationMillis, 100, cubicBezierEasing);
        AnimationExitSizeSpec = tween4;
        DockedEnterTransition = EnterExitTransitionKt.fadeIn$default(tween, 0.0f, 2, null).plus(EnterExitTransitionKt.expandVertically$default(tween3, null, false, null, 14, null));
        DockedExitTransition = EnterExitTransitionKt.fadeOut$default(tween2, 0.0f, 2, null).plus(EnterExitTransitionKt.shrinkVertically$default(tween4, null, false, null, 14, null));
    }

    public static final float getDockedActiveTableMinHeight() {
        return DockedActiveTableMinHeight;
    }

    public static final float getSearchBarMinWidth() {
        return SearchBarMinWidth;
    }

    public static final float getSearchBarVerticalPadding() {
        return SearchBarVerticalPadding;
    }

    private static final boolean SearchBar_WuY5d9Q$lambda$2(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
