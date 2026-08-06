package androidx.compose.material3;

import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.Orientation;
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
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.text.input.internal.PartialGapBuffer;
import androidx.compose.material3.Strings;
import androidx.compose.material3.tokens.NavigationDrawerTokens;
import androidx.compose.p002ui.Alignment;
import androidx.compose.p002ui.C0754R;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.graphics.Color;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.graphics.RectangleShapeKt;
import androidx.compose.p002ui.graphics.Shape;
import androidx.compose.p002ui.graphics.drawscope.DrawScope;
import androidx.compose.p002ui.input.pointer.C0769xe3d9cdbd;
import androidx.compose.p002ui.input.pointer.SuspendPointerInputElement;
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
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: NavigationDrawer.kt */
@Metadata(d1 = {"\u0000t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\u001al\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\t0\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001aQ\u0010\u001b\u001a\u00020\t2\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\t0\u001d¢\u0006\u0002\b\u00172\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\t0\u001d¢\u0006\u0002\b\u0017H\u0007¢\u0006\u0002\u0010\"\u001aj\u0010#\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00052\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\t0\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0003ø\u0001\u0000¢\u0006\u0004\b$\u0010%\u001al\u0010&\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\t0\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007ø\u0001\u0000¢\u0006\u0004\b'\u0010\u001a\u001a`\u0010(\u001a\u00020\t2\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\t0\u001d¢\u0006\u0002\b\u00172\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010)\u001a\u00020\u000f2\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\t0\u001d¢\u0006\u0002\b\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b*\u0010+\u001a\u008c\u0001\u0010,\u001a\u00020\t2\u0011\u0010-\u001a\r\u0012\u0004\u0012\u00020\t0\u001d¢\u0006\u0002\b\u00172\u0006\u0010.\u001a\u00020!2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\t0\u001d2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0015\b\u0002\u00100\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u001d¢\u0006\u0002\b\u00172\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u001d¢\u0006\u0002\b\u00172\b\b\u0002\u00102\u001a\u00020\r2\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u000206H\u0007¢\u0006\u0002\u00107\u001al\u00108\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\t0\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007ø\u0001\u0000¢\u0006\u0004\b9\u0010\u001a\u001a=\u0010:\u001a\u00020\t2\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\t0\u001d¢\u0006\u0002\b\u00172\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\t0\u001d¢\u0006\u0002\b\u0017H\u0007¢\u0006\u0002\u0010;\u001a>\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020!2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\t0\u001d2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00020\u001d2\u0006\u0010@\u001a\u00020\u000fH\u0003ø\u0001\u0000¢\u0006\u0004\bA\u0010B\u001a \u0010C\u001a\u00020\u00022\u0006\u0010D\u001a\u00020\u00022\u0006\u0010E\u001a\u00020\u00022\u0006\u0010F\u001a\u00020\u0002H\u0002\u001a+\u0010G\u001a\u00020\u001f2\u0006\u0010H\u001a\u00020I2\u0014\b\u0002\u0010J\u001a\u000e\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020!0\u0015H\u0007¢\u0006\u0002\u0010K\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0002X\u0082D¢\u0006\u0002\n\u0000\"\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006L"}, d2 = {"AnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "DrawerPositionalThreshold", "DrawerVelocityThreshold", "Landroidx/compose/ui/unit/Dp;", "F", "MinimumDrawerWidth", "DismissibleDrawerSheet", "", "modifier", "Landroidx/compose/ui/Modifier;", "drawerShape", "Landroidx/compose/ui/graphics/Shape;", "drawerContainerColor", "Landroidx/compose/ui/graphics/Color;", "drawerContentColor", "drawerTonalElevation", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "DismissibleDrawerSheet-afqeVBk", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DismissibleNavigationDrawer", "drawerContent", "Lkotlin/Function0;", "drawerState", "Landroidx/compose/material3/DrawerState;", "gesturesEnabled", "", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DrawerState;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "DrawerSheet", "DrawerSheet-vywBR7E", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ModalDrawerSheet", "ModalDrawerSheet-afqeVBk", "ModalNavigationDrawer", "scrimColor", "ModalNavigationDrawer-FHprtrg", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DrawerState;ZJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "NavigationDrawerItem", "label", "selected", "onClick", "icon", "badge", "shape", "colors", "Landroidx/compose/material3/NavigationDrawerItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/NavigationDrawerItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "PermanentDrawerSheet", "PermanentDrawerSheet-afqeVBk", "PermanentNavigationDrawer", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Scrim", "open", "onClose", "fraction", "color", "Scrim-Bx497Mc", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;JLandroidx/compose/runtime/Composer;I)V", "calculateFraction", "a", "b", "pos", "rememberDrawerState", "initialValue", "Landroidx/compose/material3/DrawerValue;", "confirmStateChange", "(Landroidx/compose/material3/DrawerValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/DrawerState;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class NavigationDrawerKt {
    private static final float DrawerPositionalThreshold = 0.5f;
    private static final float DrawerVelocityThreshold = Dp.constructor-impl(400);
    private static final float MinimumDrawerWidth = Dp.constructor-impl(240);
    private static final TweenSpec<Float> AnimationSpec = new TweenSpec<>(Fields.RotationX, 0, null, 6, null);

    public static final DrawerState rememberDrawerState(final DrawerValue drawerValue, final Function1<? super DrawerValue, Boolean> function1, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(2098699222);
        ComposerKt.sourceInformation(composer, "C(rememberDrawerState)P(1)280@10617L61,280@10553L125:NavigationDrawer.kt#uh7d8r");
        if ((i2 & 2) != 0) {
            function1 = new Function1<DrawerValue, Boolean>() { // from class: androidx.compose.material3.NavigationDrawerKt$rememberDrawerState$1
                public final Boolean invoke(DrawerValue drawerValue2) {
                    return true;
                }
            };
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2098699222, i, -1, "androidx.compose.material3.rememberDrawerState (NavigationDrawer.kt:279)");
        }
        Object[] objArr = new Object[0];
        Saver<DrawerState, DrawerValue> Saver = DrawerState.INSTANCE.Saver(function1);
        composer.startReplaceableGroup(-21510967);
        ComposerKt.sourceInformation(composer, "CC(remember):NavigationDrawer.kt#9igjgp");
        boolean z = ((((i & 14) ^ 6) > 4 && composer.changed(drawerValue)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changed(function1)) || (i & 48) == 32);
        Object rememberedValue = composer.rememberedValue();
        if (z || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = (Function0) new Function0<DrawerState>() { // from class: androidx.compose.material3.NavigationDrawerKt$rememberDrawerState$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final DrawerState m2750invoke() {
                    return new DrawerState(DrawerValue.this, function1);
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        DrawerState drawerState = (DrawerState) RememberSaveableKt.m4241rememberSaveable(objArr, (Saver) Saver, (String) null, (Function0) rememberedValue, composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return drawerState;
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x03ec, code lost:
    
        if (r12 == androidx.compose.runtime.Composer.INSTANCE.getEmpty()) goto L158;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x042a, code lost:
    
        if (r12 == androidx.compose.runtime.Composer.INSTANCE.getEmpty()) goto L171;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x03e6  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0410  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0424  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x046e  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0481  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x04ab  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x04c5  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x051c  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0528  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0551  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x05cc  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x052c  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x05d9  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0352  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x03c6  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x03cd  */
    /* renamed from: ModalNavigationDrawer-FHprtrg, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2736ModalNavigationDrawerFHprtrg(final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, DrawerState drawerState, boolean z, long j, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        DrawerState drawerState2;
        int i4;
        boolean z2;
        long j2;
        long scrimColor;
        final boolean z3;
        int i5;
        final DrawerState drawerState3;
        Object rememberedValue;
        boolean changed;
        Object rememberedValue2;
        int currentCompositeKeyHash;
        Composer m4109constructorimpl;
        int currentCompositeKeyHash2;
        Composer m4109constructorimpl2;
        boolean changedInstance;
        Object obj;
        boolean changed2;
        Object obj2;
        boolean z4;
        Object rememberedValue3;
        boolean changed3;
        Object rememberedValue4;
        int currentCompositeKeyHash3;
        Composer m4109constructorimpl3;
        final boolean z5;
        ScopeUpdateScope endRestartGroup;
        int i6;
        int i7;
        int i8;
        Composer startRestartGroup = composer.startRestartGroup(-1169303680);
        ComposerKt.sourceInformation(startRestartGroup, "C(ModalNavigationDrawer)P(1,4,2,3,5:c#ui.graphics.Color)309@11871L39,311@11988L10,314@12056L24,315@12106L33,316@12171L7,320@12300L250,320@12289L261,330@12589L7,331@12624L1701:NavigationDrawer.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i9 = i2 & 2;
        if (i9 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i & 384) != 0) {
                if ((i2 & 4) == 0) {
                    drawerState2 = drawerState;
                    if (startRestartGroup.changed(drawerState2)) {
                        i8 = Fields.RotationX;
                        i3 |= i8;
                    }
                } else {
                    drawerState2 = drawerState;
                }
                i8 = Fields.SpotShadowColor;
                i3 |= i8;
            } else {
                drawerState2 = drawerState;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? Fields.CameraDistance : Fields.RotationZ;
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        j2 = j;
                        if (startRestartGroup.changed(j2)) {
                            i7 = Fields.Clip;
                            i3 |= i7;
                        }
                    } else {
                        j2 = j;
                    }
                    i7 = Fields.Shape;
                    i3 |= i7;
                } else {
                    j2 = j;
                }
                if ((i2 & 32) == 0) {
                    i6 = (i & 196608) == 0 ? startRestartGroup.changedInstance(function22) ? Fields.RenderEffect : 65536 : 196608;
                    if ((i3 & 74899) == 74898 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            if (i9 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                                drawerState2 = rememberDrawerState(DrawerValue.Closed, null, startRestartGroup, 6, 2);
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 16) != 0) {
                                scrimColor = DrawerDefaults.INSTANCE.getScrimColor(startRestartGroup, 6);
                                z3 = z2;
                                i5 = i3 & (-57345);
                                drawerState3 = drawerState2;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1169303680, i5, -1, "androidx.compose.material3.ModalNavigationDrawer (NavigationDrawer.kt:313)");
                                }
                                startRestartGroup.startReplaceableGroup(773894976);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                                startRestartGroup.startReplaceableGroup(-492369756);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                                rememberedValue = startRestartGroup.rememberedValue();
                                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                                    startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                                    rememberedValue = compositionScopedCoroutineScopeCanceller;
                                }
                                startRestartGroup.endReplaceableGroup();
                                final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
                                startRestartGroup.endReplaceableGroup();
                                Strings.Companion companion = Strings.INSTANCE;
                                final String m3033getStringNWtq28 = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0754R.string.navigation_menu), startRestartGroup, 0);
                                ProvidableCompositionLocal localDensity = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object consume = startRestartGroup.consume(localDensity);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                final Density density = (Density) consume;
                                final float f = -density.toPx-0680j_4(NavigationDrawerTokens.INSTANCE.m3728getContainerWidthD9Ej5fM());
                                startRestartGroup.startReplaceableGroup(-1870335235);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
                                int i10 = (i5 & 896) ^ 384;
                                changed = ((i10 <= 256 && startRestartGroup.changed(drawerState3)) || (i5 & 384) == 256) | startRestartGroup.changed(density) | startRestartGroup.changed(f);
                                rememberedValue2 = startRestartGroup.rememberedValue();
                                final float f2 = 0.0f;
                                if (!changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$1$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke() {
                                            m2743invoke();
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: collision with other method in class */
                                        public final void m2743invoke() {
                                            DrawerState.this.setDensity$material3_release(density);
                                            AnchoredDraggableState<DrawerValue> anchoredDraggableState$material3_release = DrawerState.this.getAnchoredDraggableState$material3_release();
                                            final float f3 = f;
                                            final float f4 = f2;
                                            AnchoredDraggableState.updateAnchors$default(anchoredDraggableState$material3_release, AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<DrawerValue>, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$1$1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                                                    invoke((DraggableAnchorsConfig<DrawerValue>) obj3);
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(DraggableAnchorsConfig<DrawerValue> draggableAnchorsConfig) {
                                                    draggableAnchorsConfig.m48at(DrawerValue.Closed, f3);
                                                    draggableAnchorsConfig.m48at(DrawerValue.Open, f4);
                                                }
                                            }), null, 2, null);
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue2);
                                }
                                startRestartGroup.endReplaceableGroup();
                                EffectsKt.SideEffect((Function0) rememberedValue2, startRestartGroup, 0);
                                ProvidableCompositionLocal localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object consume2 = startRestartGroup.consume(localLayoutDirection);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                Modifier anchoredDraggable$default = AnchoredDraggableKt.anchoredDraggable$default(SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, null), drawerState3.getAnchoredDraggableState$material3_release(), Orientation.Horizontal, z3, consume2 == LayoutDirection.Rtl, null, 16, null);
                                startRestartGroup.startReplaceableGroup(733328855);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                                startRestartGroup.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                Modifier modifier3 = modifier2;
                                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                                Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(anchoredDraggable$default);
                                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                startRestartGroup.startReusableNode();
                                if (startRestartGroup.getInserting()) {
                                    startRestartGroup.createNode(constructor);
                                } else {
                                    startRestartGroup.useNode();
                                }
                                m4109constructorimpl = Updater.m4109constructorimpl(startRestartGroup);
                                Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                if (!m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
                                startRestartGroup.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2009208343, "C341@12933L37,346@13047L264,354@13336L98,344@12979L497,361@13535L198,368@13761L507,359@13485L834:NavigationDrawer.kt#uh7d8r");
                                startRestartGroup.startReplaceableGroup(733328855);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                Modifier.Companion companion2 = Modifier.INSTANCE;
                                MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                                startRestartGroup.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                                Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(companion2);
                                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                startRestartGroup.startReusableNode();
                                if (startRestartGroup.getInserting()) {
                                    startRestartGroup.createNode(constructor2);
                                } else {
                                    startRestartGroup.useNode();
                                }
                                m4109constructorimpl2 = Updater.m4109constructorimpl(startRestartGroup);
                                Updater.m4116setimpl(m4109constructorimpl2, rememberBoxMeasurePolicy2, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.m4116setimpl(m4109constructorimpl2, currentCompositionLocalMap2, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                if (!m4109constructorimpl2.getInserting() || !Intrinsics.areEqual(m4109constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                    m4109constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                    m4109constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                }
                                modifierMaterializerOf2.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
                                startRestartGroup.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -860467894, "C342@12951L9:NavigationDrawer.kt#uh7d8r");
                                function22.invoke(startRestartGroup, Integer.valueOf((i5 >> 15) & 14));
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                startRestartGroup.endReplaceableGroup();
                                startRestartGroup.endNode();
                                startRestartGroup.endReplaceableGroup();
                                startRestartGroup.endReplaceableGroup();
                                boolean isOpen = drawerState3.isOpen();
                                startRestartGroup.startReplaceableGroup(2009208457);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
                                changedInstance = ((i5 & 7168) == 2048) | ((i10 <= 256 && startRestartGroup.changed(drawerState3)) || (i5 & 384) == 256) | startRestartGroup.changedInstance(coroutineScope);
                                Object rememberedValue5 = startRestartGroup.rememberedValue();
                                if (!changedInstance) {
                                    obj = rememberedValue5;
                                }
                                Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$2$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke() {
                                        m2744invoke();
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: collision with other method in class */
                                    public final void m2744invoke() {
                                        if (z3 && ((Boolean) drawerState3.getAnchoredDraggableState$material3_release().getConfirmValueChange$material3_release().invoke(DrawerValue.Closed)).booleanValue()) {
                                            BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new C06631(drawerState3, null), 3, (Object) null);
                                        }
                                    }

                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* compiled from: NavigationDrawer.kt */
                                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                    @DebugMetadata(c = "androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$2$1$1", f = "NavigationDrawer.kt", i = {}, l = {352}, m = "invokeSuspend", n = {}, s = {})
                                    /* renamed from: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$2$1$1 */
                                    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
                                    public static final class C06631 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                        final /* synthetic */ DrawerState $drawerState;
                                        int label;

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        C06631(DrawerState drawerState, Continuation<? super C06631> continuation) {
                                            super(2, continuation);
                                            this.$drawerState = drawerState;
                                        }

                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                            return new C06631(this.$drawerState, continuation);
                                        }

                                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                                        }

                                        public final Object invokeSuspend(Object obj) {
                                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                            int i = this.label;
                                            if (i == 0) {
                                                ResultKt.throwOnFailure(obj);
                                                this.label = 1;
                                                if (this.$drawerState.close((Continuation) this) == coroutine_suspended) {
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
                                };
                                startRestartGroup.updateRememberedValue(function0);
                                obj = function0;
                                Function0 function02 = (Function0) obj;
                                startRestartGroup.endReplaceableGroup();
                                startRestartGroup.startReplaceableGroup(2009208746);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
                                changed2 = ((i10 <= 256 && startRestartGroup.changed(drawerState3)) || (i5 & 384) == 256) | startRestartGroup.changed(f);
                                Object rememberedValue6 = startRestartGroup.rememberedValue();
                                if (!changed2) {
                                    obj2 = rememberedValue6;
                                }
                                final float f3 = 0.0f;
                                Function0<Float> function03 = new Function0<Float>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$3$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                    public final Float m2745invoke() {
                                        float calculateFraction;
                                        calculateFraction = NavigationDrawerKt.calculateFraction(f, f3, drawerState3.requireOffset$material3_release());
                                        return Float.valueOf(calculateFraction);
                                    }
                                };
                                startRestartGroup.updateRememberedValue(function03);
                                obj2 = function03;
                                startRestartGroup.endReplaceableGroup();
                                boolean z6 = z3;
                                m2738ScrimBx497Mc(isOpen, function02, (Function0) obj2, scrimColor, startRestartGroup, (i5 >> 3) & 7168);
                                Modifier.Companion companion3 = Modifier.INSTANCE;
                                startRestartGroup.startReplaceableGroup(2009208945);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
                                z4 = (i10 <= 256 && startRestartGroup.changed(drawerState3)) || (i5 & 384) == 256;
                                rememberedValue3 = startRestartGroup.rememberedValue();
                                if (!z4 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue3 = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$4$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        {
                                            super(1);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                                            return IntOffset.box-impl(m2746invokeBjo55l4((Density) obj3));
                                        }

                                        /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                                        public final long m2746invokeBjo55l4(Density density2) {
                                            return IntOffsetKt.IntOffset(MathKt.roundToInt(DrawerState.this.requireOffset$material3_release()), 0);
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue3);
                                }
                                startRestartGroup.endReplaceableGroup();
                                Modifier offset = OffsetKt.offset(companion3, (Function1) rememberedValue3);
                                startRestartGroup.startReplaceableGroup(2009209171);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
                                changed3 = startRestartGroup.changed(m3033getStringNWtq28) | ((i10 <= 256 && startRestartGroup.changed(drawerState3)) || (i5 & 384) == 256) | startRestartGroup.changedInstance(coroutineScope);
                                rememberedValue4 = startRestartGroup.rememberedValue();
                                if (!changed3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue4 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$5$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                                            invoke((SemanticsPropertyReceiver) obj3);
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                            SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, m3033getStringNWtq28);
                                            if (drawerState3.isOpen()) {
                                                final DrawerState drawerState4 = drawerState3;
                                                final CoroutineScope coroutineScope2 = coroutineScope;
                                                SemanticsPropertiesKt.dismiss$default(semanticsPropertyReceiver, (String) null, new Function0<Boolean>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$5$1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(0);
                                                    }

                                                    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                                    public final Boolean m2747invoke() {
                                                        if (((Boolean) DrawerState.this.getAnchoredDraggableState$material3_release().getConfirmValueChange$material3_release().invoke(DrawerValue.Closed)).booleanValue()) {
                                                            BuildersKt.launch$default(coroutineScope2, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(DrawerState.this, null), 3, (Object) null);
                                                        }
                                                        return true;
                                                    }

                                                    /* JADX INFO: Access modifiers changed from: package-private */
                                                    /* compiled from: NavigationDrawer.kt */
                                                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                                    @DebugMetadata(c = "androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$5$1$1$1", f = "NavigationDrawer.kt", i = {}, l = {377}, m = "invokeSuspend", n = {}, s = {})
                                                    /* renamed from: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$5$1$1$1, reason: invalid class name */
                                                    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
                                                    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                        final /* synthetic */ DrawerState $drawerState;
                                                        int label;

                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        AnonymousClass1(DrawerState drawerState, Continuation<? super AnonymousClass1> continuation) {
                                                            super(2, continuation);
                                                            this.$drawerState = drawerState;
                                                        }

                                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                            return new AnonymousClass1(this.$drawerState, continuation);
                                                        }

                                                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                                                        }

                                                        public final Object invokeSuspend(Object obj) {
                                                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                            int i = this.label;
                                                            if (i == 0) {
                                                                ResultKt.throwOnFailure(obj);
                                                                this.label = 1;
                                                                if (this.$drawerState.close((Continuation) this) == coroutine_suspended) {
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
                                                }, 1, (Object) null);
                                            }
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue4);
                                }
                                startRestartGroup.endReplaceableGroup();
                                Modifier semantics$default = SemanticsModifierKt.semantics$default(offset, false, (Function1) rememberedValue4, 1, (Object) null);
                                startRestartGroup.startReplaceableGroup(733328855);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                MeasurePolicy rememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                                startRestartGroup.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                                CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                                Function0 constructor3 = ComposeUiNode.Companion.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(semantics$default);
                                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                startRestartGroup.startReusableNode();
                                if (startRestartGroup.getInserting()) {
                                    startRestartGroup.createNode(constructor3);
                                } else {
                                    startRestartGroup.useNode();
                                }
                                m4109constructorimpl3 = Updater.m4109constructorimpl(startRestartGroup);
                                Updater.m4116setimpl(m4109constructorimpl3, rememberBoxMeasurePolicy3, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.m4116setimpl(m4109constructorimpl3, currentCompositionLocalMap3, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Function2 setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                if (!m4109constructorimpl3.getInserting() || !Intrinsics.areEqual(m4109constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                    m4109constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                    m4109constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                }
                                modifierMaterializerOf3.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
                                startRestartGroup.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -860466551, "C382@14294L15:NavigationDrawer.kt#uh7d8r");
                                function2.invoke(startRestartGroup, Integer.valueOf(i5 & 14));
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                startRestartGroup.endReplaceableGroup();
                                startRestartGroup.endNode();
                                startRestartGroup.endReplaceableGroup();
                                startRestartGroup.endReplaceableGroup();
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                startRestartGroup.endReplaceableGroup();
                                startRestartGroup.endNode();
                                startRestartGroup.endReplaceableGroup();
                                startRestartGroup.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                z5 = z6;
                                modifier2 = modifier3;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                        }
                        i5 = i3;
                        drawerState3 = drawerState2;
                        z3 = z2;
                        scrimColor = j2;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        startRestartGroup.startReplaceableGroup(773894976);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                        startRestartGroup.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                        }
                        startRestartGroup.endReplaceableGroup();
                        final CoroutineScope coroutineScope2 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
                        startRestartGroup.endReplaceableGroup();
                        Strings.Companion companion4 = Strings.INSTANCE;
                        final String m3033getStringNWtq282 = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0754R.string.navigation_menu), startRestartGroup, 0);
                        ProvidableCompositionLocal localDensity2 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume3 = startRestartGroup.consume(localDensity2);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        final Density density2 = (Density) consume3;
                        final float f4 = -density2.toPx-0680j_4(NavigationDrawerTokens.INSTANCE.m3728getContainerWidthD9Ej5fM());
                        startRestartGroup.startReplaceableGroup(-1870335235);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
                        int i102 = (i5 & 896) ^ 384;
                        changed = ((i102 <= 256 && startRestartGroup.changed(drawerState3)) || (i5 & 384) == 256) | startRestartGroup.changed(density2) | startRestartGroup.changed(f4);
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        final float f22 = 0.0f;
                        if (!changed) {
                        }
                        rememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            public /* bridge */ /* synthetic */ Object invoke() {
                                m2743invoke();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: collision with other method in class */
                            public final void m2743invoke() {
                                DrawerState.this.setDensity$material3_release(density2);
                                AnchoredDraggableState<DrawerValue> anchoredDraggableState$material3_release = DrawerState.this.getAnchoredDraggableState$material3_release();
                                final float f32 = f4;
                                final float f42 = f22;
                                AnchoredDraggableState.updateAnchors$default(anchoredDraggableState$material3_release, AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<DrawerValue>, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$1$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                                        invoke((DraggableAnchorsConfig<DrawerValue>) obj3);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(DraggableAnchorsConfig<DrawerValue> draggableAnchorsConfig) {
                                        draggableAnchorsConfig.m48at(DrawerValue.Closed, f32);
                                        draggableAnchorsConfig.m48at(DrawerValue.Open, f42);
                                    }
                                }), null, 2, null);
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                        startRestartGroup.endReplaceableGroup();
                        EffectsKt.SideEffect((Function0) rememberedValue2, startRestartGroup, 0);
                        ProvidableCompositionLocal localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume22 = startRestartGroup.consume(localLayoutDirection2);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        Modifier anchoredDraggable$default2 = AnchoredDraggableKt.anchoredDraggable$default(SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, null), drawerState3.getAnchoredDraggableState$material3_release(), Orientation.Horizontal, z3, consume22 == LayoutDirection.Rtl, null, 16, null);
                        startRestartGroup.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy4 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                        startRestartGroup.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        Modifier modifier32 = modifier2;
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
                        Function0 constructor4 = ComposeUiNode.Companion.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(anchoredDraggable$default2);
                        if (!(startRestartGroup.getApplier() instanceof Applier)) {
                        }
                        startRestartGroup.startReusableNode();
                        if (startRestartGroup.getInserting()) {
                        }
                        m4109constructorimpl = Updater.m4109constructorimpl(startRestartGroup);
                        Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy4, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap4, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2 setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (!m4109constructorimpl.getInserting()) {
                        }
                        m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash4);
                        modifierMaterializerOf4.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
                        startRestartGroup.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2009208343, "C341@12933L37,346@13047L264,354@13336L98,344@12979L497,361@13535L198,368@13761L507,359@13485L834:NavigationDrawer.kt#uh7d8r");
                        startRestartGroup.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        Modifier.Companion companion22 = Modifier.INSTANCE;
                        MeasurePolicy rememberBoxMeasurePolicy22 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                        startRestartGroup.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
                        Function0 constructor22 = ComposeUiNode.Companion.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf22 = LayoutKt.modifierMaterializerOf(companion22);
                        if (!(startRestartGroup.getApplier() instanceof Applier)) {
                        }
                        startRestartGroup.startReusableNode();
                        if (startRestartGroup.getInserting()) {
                        }
                        m4109constructorimpl2 = Updater.m4109constructorimpl(startRestartGroup);
                        Updater.m4116setimpl(m4109constructorimpl2, rememberBoxMeasurePolicy22, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m4116setimpl(m4109constructorimpl2, currentCompositionLocalMap22, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2 setCompositeKeyHash22 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (!m4109constructorimpl2.getInserting()) {
                        }
                        m4109constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        m4109constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash22);
                        modifierMaterializerOf22.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
                        startRestartGroup.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance22 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -860467894, "C342@12951L9:NavigationDrawer.kt#uh7d8r");
                        function22.invoke(startRestartGroup, Integer.valueOf((i5 >> 15) & 14));
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        startRestartGroup.endReplaceableGroup();
                        startRestartGroup.endNode();
                        startRestartGroup.endReplaceableGroup();
                        startRestartGroup.endReplaceableGroup();
                        boolean isOpen2 = drawerState3.isOpen();
                        startRestartGroup.startReplaceableGroup(2009208457);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
                        changedInstance = ((i5 & 7168) == 2048) | ((i102 <= 256 && startRestartGroup.changed(drawerState3)) || (i5 & 384) == 256) | startRestartGroup.changedInstance(coroutineScope2);
                        Object rememberedValue52 = startRestartGroup.rememberedValue();
                        if (!changedInstance) {
                        }
                        Function0<Unit> function04 = new Function0<Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$2$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            public /* bridge */ /* synthetic */ Object invoke() {
                                m2744invoke();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: collision with other method in class */
                            public final void m2744invoke() {
                                if (z3 && ((Boolean) drawerState3.getAnchoredDraggableState$material3_release().getConfirmValueChange$material3_release().invoke(DrawerValue.Closed)).booleanValue()) {
                                    BuildersKt.launch$default(coroutineScope2, (CoroutineContext) null, (CoroutineStart) null, new C06631(drawerState3, null), 3, (Object) null);
                                }
                            }

                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* compiled from: NavigationDrawer.kt */
                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                            @DebugMetadata(c = "androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$2$1$1", f = "NavigationDrawer.kt", i = {}, l = {352}, m = "invokeSuspend", n = {}, s = {})
                            /* renamed from: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$2$1$1 */
                            /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
                            public static final class C06631 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                final /* synthetic */ DrawerState $drawerState;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                C06631(DrawerState drawerState, Continuation<? super C06631> continuation) {
                                    super(2, continuation);
                                    this.$drawerState = drawerState;
                                }

                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    return new C06631(this.$drawerState, continuation);
                                }

                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                    return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                                }

                                public final Object invokeSuspend(Object obj) {
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    int i = this.label;
                                    if (i == 0) {
                                        ResultKt.throwOnFailure(obj);
                                        this.label = 1;
                                        if (this.$drawerState.close((Continuation) this) == coroutine_suspended) {
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
                        };
                        startRestartGroup.updateRememberedValue(function04);
                        obj = function04;
                        Function0 function022 = (Function0) obj;
                        startRestartGroup.endReplaceableGroup();
                        startRestartGroup.startReplaceableGroup(2009208746);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
                        changed2 = ((i102 <= 256 && startRestartGroup.changed(drawerState3)) || (i5 & 384) == 256) | startRestartGroup.changed(f4);
                        Object rememberedValue62 = startRestartGroup.rememberedValue();
                        if (!changed2) {
                        }
                        final float f32 = 0.0f;
                        Function0<Float> function032 = new Function0<Float>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$3$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                            public final Float m2745invoke() {
                                float calculateFraction;
                                calculateFraction = NavigationDrawerKt.calculateFraction(f4, f32, drawerState3.requireOffset$material3_release());
                                return Float.valueOf(calculateFraction);
                            }
                        };
                        startRestartGroup.updateRememberedValue(function032);
                        obj2 = function032;
                        startRestartGroup.endReplaceableGroup();
                        boolean z62 = z3;
                        m2738ScrimBx497Mc(isOpen2, function022, (Function0) obj2, scrimColor, startRestartGroup, (i5 >> 3) & 7168);
                        Modifier.Companion companion32 = Modifier.INSTANCE;
                        startRestartGroup.startReplaceableGroup(2009208945);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
                        if (i102 <= 256) {
                        }
                        rememberedValue3 = startRestartGroup.rememberedValue();
                        if (!z4) {
                        }
                        rememberedValue3 = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$4$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                                return IntOffset.box-impl(m2746invokeBjo55l4((Density) obj3));
                            }

                            /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                            public final long m2746invokeBjo55l4(Density density22) {
                                return IntOffsetKt.IntOffset(MathKt.roundToInt(DrawerState.this.requireOffset$material3_release()), 0);
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue3);
                        startRestartGroup.endReplaceableGroup();
                        Modifier offset2 = OffsetKt.offset(companion32, (Function1) rememberedValue3);
                        startRestartGroup.startReplaceableGroup(2009209171);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
                        changed3 = startRestartGroup.changed(m3033getStringNWtq282) | ((i102 <= 256 && startRestartGroup.changed(drawerState3)) || (i5 & 384) == 256) | startRestartGroup.changedInstance(coroutineScope2);
                        rememberedValue4 = startRestartGroup.rememberedValue();
                        if (!changed3) {
                        }
                        rememberedValue4 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$5$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                                invoke((SemanticsPropertyReceiver) obj3);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, m3033getStringNWtq282);
                                if (drawerState3.isOpen()) {
                                    final DrawerState drawerState4 = drawerState3;
                                    final CoroutineScope coroutineScope22 = coroutineScope2;
                                    SemanticsPropertiesKt.dismiss$default(semanticsPropertyReceiver, (String) null, new Function0<Boolean>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$5$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                        public final Boolean m2747invoke() {
                                            if (((Boolean) DrawerState.this.getAnchoredDraggableState$material3_release().getConfirmValueChange$material3_release().invoke(DrawerValue.Closed)).booleanValue()) {
                                                BuildersKt.launch$default(coroutineScope22, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(DrawerState.this, null), 3, (Object) null);
                                            }
                                            return true;
                                        }

                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* compiled from: NavigationDrawer.kt */
                                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                        @DebugMetadata(c = "androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$5$1$1$1", f = "NavigationDrawer.kt", i = {}, l = {377}, m = "invokeSuspend", n = {}, s = {})
                                        /* renamed from: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$5$1$1$1, reason: invalid class name */
                                        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
                                        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                            final /* synthetic */ DrawerState $drawerState;
                                            int label;

                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            AnonymousClass1(DrawerState drawerState, Continuation<? super AnonymousClass1> continuation) {
                                                super(2, continuation);
                                                this.$drawerState = drawerState;
                                            }

                                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                return new AnonymousClass1(this.$drawerState, continuation);
                                            }

                                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                                            }

                                            public final Object invokeSuspend(Object obj) {
                                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                int i = this.label;
                                                if (i == 0) {
                                                    ResultKt.throwOnFailure(obj);
                                                    this.label = 1;
                                                    if (this.$drawerState.close((Continuation) this) == coroutine_suspended) {
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
                                    }, 1, (Object) null);
                                }
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue4);
                        startRestartGroup.endReplaceableGroup();
                        Modifier semantics$default2 = SemanticsModifierKt.semantics$default(offset2, false, (Function1) rememberedValue4, 1, (Object) null);
                        startRestartGroup.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy32 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                        startRestartGroup.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap32 = startRestartGroup.getCurrentCompositionLocalMap();
                        Function0 constructor32 = ComposeUiNode.Companion.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf32 = LayoutKt.modifierMaterializerOf(semantics$default2);
                        if (!(startRestartGroup.getApplier() instanceof Applier)) {
                        }
                        startRestartGroup.startReusableNode();
                        if (startRestartGroup.getInserting()) {
                        }
                        m4109constructorimpl3 = Updater.m4109constructorimpl(startRestartGroup);
                        Updater.m4116setimpl(m4109constructorimpl3, rememberBoxMeasurePolicy32, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m4116setimpl(m4109constructorimpl3, currentCompositionLocalMap32, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2 setCompositeKeyHash32 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (!m4109constructorimpl3.getInserting()) {
                        }
                        m4109constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        m4109constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash32);
                        modifierMaterializerOf32.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
                        startRestartGroup.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance32 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -860466551, "C382@14294L15:NavigationDrawer.kt#uh7d8r");
                        function2.invoke(startRestartGroup, Integer.valueOf(i5 & 14));
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        startRestartGroup.endReplaceableGroup();
                        startRestartGroup.endNode();
                        startRestartGroup.endReplaceableGroup();
                        startRestartGroup.endReplaceableGroup();
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        startRestartGroup.endReplaceableGroup();
                        startRestartGroup.endNode();
                        startRestartGroup.endReplaceableGroup();
                        startRestartGroup.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        z5 = z62;
                        modifier2 = modifier32;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        drawerState3 = drawerState2;
                        z5 = z2;
                        scrimColor = j2;
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        final Modifier modifier4 = modifier2;
                        final long j3 = scrimColor;
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj3, Object obj4) {
                                invoke((Composer) obj3, ((Number) obj4).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i11) {
                                NavigationDrawerKt.m2736ModalNavigationDrawerFHprtrg(function2, modifier4, drawerState3, z5, j3, function22, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= i6;
                if ((i3 & 74899) == 74898) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i9 != 0) {
                }
                if ((i2 & 4) != 0) {
                }
                if (i4 != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                i5 = i3;
                drawerState3 = drawerState2;
                z3 = z2;
                scrimColor = j2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup.startReplaceableGroup(773894976);
                ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                startRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                }
                startRestartGroup.endReplaceableGroup();
                final CoroutineScope coroutineScope22 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
                startRestartGroup.endReplaceableGroup();
                Strings.Companion companion42 = Strings.INSTANCE;
                final String m3033getStringNWtq2822 = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0754R.string.navigation_menu), startRestartGroup, 0);
                ProvidableCompositionLocal localDensity22 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume32 = startRestartGroup.consume(localDensity22);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                final Density density22 = (Density) consume32;
                final float f42 = -density22.toPx-0680j_4(NavigationDrawerTokens.INSTANCE.m3728getContainerWidthD9Ej5fM());
                startRestartGroup.startReplaceableGroup(-1870335235);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
                int i1022 = (i5 & 896) ^ 384;
                changed = ((i1022 <= 256 && startRestartGroup.changed(drawerState3)) || (i5 & 384) == 256) | startRestartGroup.changed(density22) | startRestartGroup.changed(f42);
                rememberedValue2 = startRestartGroup.rememberedValue();
                final float f222 = 0.0f;
                if (!changed) {
                }
                rememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m2743invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m2743invoke() {
                        DrawerState.this.setDensity$material3_release(density22);
                        AnchoredDraggableState<DrawerValue> anchoredDraggableState$material3_release = DrawerState.this.getAnchoredDraggableState$material3_release();
                        final float f322 = f42;
                        final float f422 = f222;
                        AnchoredDraggableState.updateAnchors$default(anchoredDraggableState$material3_release, AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<DrawerValue>, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                                invoke((DraggableAnchorsConfig<DrawerValue>) obj3);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(DraggableAnchorsConfig<DrawerValue> draggableAnchorsConfig) {
                                draggableAnchorsConfig.m48at(DrawerValue.Closed, f322);
                                draggableAnchorsConfig.m48at(DrawerValue.Open, f422);
                            }
                        }), null, 2, null);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
                startRestartGroup.endReplaceableGroup();
                EffectsKt.SideEffect((Function0) rememberedValue2, startRestartGroup, 0);
                ProvidableCompositionLocal localLayoutDirection22 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume222 = startRestartGroup.consume(localLayoutDirection22);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Modifier anchoredDraggable$default22 = AnchoredDraggableKt.anchoredDraggable$default(SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, null), drawerState3.getAnchoredDraggableState$material3_release(), Orientation.Horizontal, z3, consume222 == LayoutDirection.Rtl, null, 16, null);
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy42 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                Modifier modifier322 = modifier2;
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap42 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0 constructor42 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf42 = LayoutKt.modifierMaterializerOf(anchoredDraggable$default22);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                }
                m4109constructorimpl = Updater.m4109constructorimpl(startRestartGroup);
                Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy42, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap42, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash42 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!m4109constructorimpl.getInserting()) {
                }
                m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash42);
                modifierMaterializerOf42.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance42 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2009208343, "C341@12933L37,346@13047L264,354@13336L98,344@12979L497,361@13535L198,368@13761L507,359@13485L834:NavigationDrawer.kt#uh7d8r");
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                Modifier.Companion companion222 = Modifier.INSTANCE;
                MeasurePolicy rememberBoxMeasurePolicy222 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap222 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0 constructor222 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf222 = LayoutKt.modifierMaterializerOf(companion222);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                }
                m4109constructorimpl2 = Updater.m4109constructorimpl(startRestartGroup);
                Updater.m4116setimpl(m4109constructorimpl2, rememberBoxMeasurePolicy222, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m4116setimpl(m4109constructorimpl2, currentCompositionLocalMap222, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash222 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!m4109constructorimpl2.getInserting()) {
                }
                m4109constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m4109constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash222);
                modifierMaterializerOf222.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance222 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -860467894, "C342@12951L9:NavigationDrawer.kt#uh7d8r");
                function22.invoke(startRestartGroup, Integer.valueOf((i5 >> 15) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                boolean isOpen22 = drawerState3.isOpen();
                startRestartGroup.startReplaceableGroup(2009208457);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
                changedInstance = ((i5 & 7168) == 2048) | ((i1022 <= 256 && startRestartGroup.changed(drawerState3)) || (i5 & 384) == 256) | startRestartGroup.changedInstance(coroutineScope22);
                Object rememberedValue522 = startRestartGroup.rememberedValue();
                if (!changedInstance) {
                }
                Function0<Unit> function042 = new Function0<Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$2$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m2744invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m2744invoke() {
                        if (z3 && ((Boolean) drawerState3.getAnchoredDraggableState$material3_release().getConfirmValueChange$material3_release().invoke(DrawerValue.Closed)).booleanValue()) {
                            BuildersKt.launch$default(coroutineScope22, (CoroutineContext) null, (CoroutineStart) null, new C06631(drawerState3, null), 3, (Object) null);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* compiled from: NavigationDrawer.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                    @DebugMetadata(c = "androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$2$1$1", f = "NavigationDrawer.kt", i = {}, l = {352}, m = "invokeSuspend", n = {}, s = {})
                    /* renamed from: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$2$1$1 */
                    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
                    public static final class C06631 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ DrawerState $drawerState;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C06631(DrawerState drawerState, Continuation<? super C06631> continuation) {
                            super(2, continuation);
                            this.$drawerState = drawerState;
                        }

                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C06631(this.$drawerState, continuation);
                        }

                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                        }

                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                this.label = 1;
                                if (this.$drawerState.close((Continuation) this) == coroutine_suspended) {
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
                };
                startRestartGroup.updateRememberedValue(function042);
                obj = function042;
                Function0 function0222 = (Function0) obj;
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(2009208746);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
                changed2 = ((i1022 <= 256 && startRestartGroup.changed(drawerState3)) || (i5 & 384) == 256) | startRestartGroup.changed(f42);
                Object rememberedValue622 = startRestartGroup.rememberedValue();
                if (!changed2) {
                }
                final float f322 = 0.0f;
                Function0<Float> function0322 = new Function0<Float>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$3$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                    public final Float m2745invoke() {
                        float calculateFraction;
                        calculateFraction = NavigationDrawerKt.calculateFraction(f42, f322, drawerState3.requireOffset$material3_release());
                        return Float.valueOf(calculateFraction);
                    }
                };
                startRestartGroup.updateRememberedValue(function0322);
                obj2 = function0322;
                startRestartGroup.endReplaceableGroup();
                boolean z622 = z3;
                m2738ScrimBx497Mc(isOpen22, function0222, (Function0) obj2, scrimColor, startRestartGroup, (i5 >> 3) & 7168);
                Modifier.Companion companion322 = Modifier.INSTANCE;
                startRestartGroup.startReplaceableGroup(2009208945);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
                if (i1022 <= 256) {
                }
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (!z4) {
                }
                rememberedValue3 = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$4$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                        return IntOffset.box-impl(m2746invokeBjo55l4((Density) obj3));
                    }

                    /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                    public final long m2746invokeBjo55l4(Density density222) {
                        return IntOffsetKt.IntOffset(MathKt.roundToInt(DrawerState.this.requireOffset$material3_release()), 0);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
                startRestartGroup.endReplaceableGroup();
                Modifier offset22 = OffsetKt.offset(companion322, (Function1) rememberedValue3);
                startRestartGroup.startReplaceableGroup(2009209171);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
                changed3 = startRestartGroup.changed(m3033getStringNWtq2822) | ((i1022 <= 256 && startRestartGroup.changed(drawerState3)) || (i5 & 384) == 256) | startRestartGroup.changedInstance(coroutineScope22);
                rememberedValue4 = startRestartGroup.rememberedValue();
                if (!changed3) {
                }
                rememberedValue4 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$5$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                        invoke((SemanticsPropertyReceiver) obj3);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, m3033getStringNWtq2822);
                        if (drawerState3.isOpen()) {
                            final DrawerState drawerState4 = drawerState3;
                            final CoroutineScope coroutineScope222 = coroutineScope22;
                            SemanticsPropertiesKt.dismiss$default(semanticsPropertyReceiver, (String) null, new Function0<Boolean>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$5$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                public final Boolean m2747invoke() {
                                    if (((Boolean) DrawerState.this.getAnchoredDraggableState$material3_release().getConfirmValueChange$material3_release().invoke(DrawerValue.Closed)).booleanValue()) {
                                        BuildersKt.launch$default(coroutineScope222, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(DrawerState.this, null), 3, (Object) null);
                                    }
                                    return true;
                                }

                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* compiled from: NavigationDrawer.kt */
                                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                @DebugMetadata(c = "androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$5$1$1$1", f = "NavigationDrawer.kt", i = {}, l = {377}, m = "invokeSuspend", n = {}, s = {})
                                /* renamed from: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$5$1$1$1, reason: invalid class name */
                                /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
                                public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                    final /* synthetic */ DrawerState $drawerState;
                                    int label;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    AnonymousClass1(DrawerState drawerState, Continuation<? super AnonymousClass1> continuation) {
                                        super(2, continuation);
                                        this.$drawerState = drawerState;
                                    }

                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                        return new AnonymousClass1(this.$drawerState, continuation);
                                    }

                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                                    }

                                    public final Object invokeSuspend(Object obj) {
                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        int i = this.label;
                                        if (i == 0) {
                                            ResultKt.throwOnFailure(obj);
                                            this.label = 1;
                                            if (this.$drawerState.close((Continuation) this) == coroutine_suspended) {
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
                            }, 1, (Object) null);
                        }
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
                startRestartGroup.endReplaceableGroup();
                Modifier semantics$default22 = SemanticsModifierKt.semantics$default(offset22, false, (Function1) rememberedValue4, 1, (Object) null);
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy322 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap322 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0 constructor322 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf322 = LayoutKt.modifierMaterializerOf(semantics$default22);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                }
                m4109constructorimpl3 = Updater.m4109constructorimpl(startRestartGroup);
                Updater.m4116setimpl(m4109constructorimpl3, rememberBoxMeasurePolicy322, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m4116setimpl(m4109constructorimpl3, currentCompositionLocalMap322, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash322 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!m4109constructorimpl3.getInserting()) {
                }
                m4109constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m4109constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash322);
                modifierMaterializerOf322.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance322 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -860466551, "C382@14294L15:NavigationDrawer.kt#uh7d8r");
                function2.invoke(startRestartGroup, Integer.valueOf(i5 & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                }
                z5 = z622;
                modifier2 = modifier322;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z2 = z;
            if ((i & 24576) == 0) {
            }
            if ((i2 & 32) == 0) {
            }
            i3 |= i6;
            if ((i3 & 74899) == 74898) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i9 != 0) {
            }
            if ((i2 & 4) != 0) {
            }
            if (i4 != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            i5 = i3;
            drawerState3 = drawerState2;
            z3 = z2;
            scrimColor = j2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceableGroup(773894976);
            ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            final CoroutineScope coroutineScope222 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
            startRestartGroup.endReplaceableGroup();
            Strings.Companion companion422 = Strings.INSTANCE;
            final String m3033getStringNWtq28222 = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0754R.string.navigation_menu), startRestartGroup, 0);
            ProvidableCompositionLocal localDensity222 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume322 = startRestartGroup.consume(localDensity222);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final Density density222 = (Density) consume322;
            final float f422 = -density222.toPx-0680j_4(NavigationDrawerTokens.INSTANCE.m3728getContainerWidthD9Ej5fM());
            startRestartGroup.startReplaceableGroup(-1870335235);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
            int i10222 = (i5 & 896) ^ 384;
            changed = ((i10222 <= 256 && startRestartGroup.changed(drawerState3)) || (i5 & 384) == 256) | startRestartGroup.changed(density222) | startRestartGroup.changed(f422);
            rememberedValue2 = startRestartGroup.rememberedValue();
            final float f2222 = 0.0f;
            if (!changed) {
            }
            rememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m2743invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2743invoke() {
                    DrawerState.this.setDensity$material3_release(density222);
                    AnchoredDraggableState<DrawerValue> anchoredDraggableState$material3_release = DrawerState.this.getAnchoredDraggableState$material3_release();
                    final float f3222 = f422;
                    final float f4222 = f2222;
                    AnchoredDraggableState.updateAnchors$default(anchoredDraggableState$material3_release, AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<DrawerValue>, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$1$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                            invoke((DraggableAnchorsConfig<DrawerValue>) obj3);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(DraggableAnchorsConfig<DrawerValue> draggableAnchorsConfig) {
                            draggableAnchorsConfig.m48at(DrawerValue.Closed, f3222);
                            draggableAnchorsConfig.m48at(DrawerValue.Open, f4222);
                        }
                    }), null, 2, null);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue2);
            startRestartGroup.endReplaceableGroup();
            EffectsKt.SideEffect((Function0) rememberedValue2, startRestartGroup, 0);
            ProvidableCompositionLocal localLayoutDirection222 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2222 = startRestartGroup.consume(localLayoutDirection222);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier anchoredDraggable$default222 = AnchoredDraggableKt.anchoredDraggable$default(SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, null), drawerState3.getAnchoredDraggableState$material3_release(), Orientation.Horizontal, z3, consume2222 == LayoutDirection.Rtl, null, 16, null);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy422 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            Modifier modifier3222 = modifier2;
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap422 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0 constructor422 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf422 = LayoutKt.modifierMaterializerOf(anchoredDraggable$default222);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m4109constructorimpl = Updater.m4109constructorimpl(startRestartGroup);
            Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy422, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap422, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash422 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (!m4109constructorimpl.getInserting()) {
            }
            m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash422);
            modifierMaterializerOf422.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance422 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2009208343, "C341@12933L37,346@13047L264,354@13336L98,344@12979L497,361@13535L198,368@13761L507,359@13485L834:NavigationDrawer.kt#uh7d8r");
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            Modifier.Companion companion2222 = Modifier.INSTANCE;
            MeasurePolicy rememberBoxMeasurePolicy2222 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2222 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0 constructor2222 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2222 = LayoutKt.modifierMaterializerOf(companion2222);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m4109constructorimpl2 = Updater.m4109constructorimpl(startRestartGroup);
            Updater.m4116setimpl(m4109constructorimpl2, rememberBoxMeasurePolicy2222, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4116setimpl(m4109constructorimpl2, currentCompositionLocalMap2222, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash2222 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (!m4109constructorimpl2.getInserting()) {
            }
            m4109constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
            m4109constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2222);
            modifierMaterializerOf2222.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2222 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -860467894, "C342@12951L9:NavigationDrawer.kt#uh7d8r");
            function22.invoke(startRestartGroup, Integer.valueOf((i5 >> 15) & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            boolean isOpen222 = drawerState3.isOpen();
            startRestartGroup.startReplaceableGroup(2009208457);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
            changedInstance = ((i5 & 7168) == 2048) | ((i10222 <= 256 && startRestartGroup.changed(drawerState3)) || (i5 & 384) == 256) | startRestartGroup.changedInstance(coroutineScope222);
            Object rememberedValue5222 = startRestartGroup.rememberedValue();
            if (!changedInstance) {
            }
            Function0<Unit> function0422 = new Function0<Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m2744invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2744invoke() {
                    if (z3 && ((Boolean) drawerState3.getAnchoredDraggableState$material3_release().getConfirmValueChange$material3_release().invoke(DrawerValue.Closed)).booleanValue()) {
                        BuildersKt.launch$default(coroutineScope222, (CoroutineContext) null, (CoroutineStart) null, new C06631(drawerState3, null), 3, (Object) null);
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: NavigationDrawer.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$2$1$1", f = "NavigationDrawer.kt", i = {}, l = {352}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$2$1$1 */
                /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
                public static final class C06631 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ DrawerState $drawerState;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C06631(DrawerState drawerState, Continuation<? super C06631> continuation) {
                        super(2, continuation);
                        this.$drawerState = drawerState;
                    }

                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C06631(this.$drawerState, continuation);
                    }

                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                    }

                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            this.label = 1;
                            if (this.$drawerState.close((Continuation) this) == coroutine_suspended) {
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
            };
            startRestartGroup.updateRememberedValue(function0422);
            obj = function0422;
            Function0 function02222 = (Function0) obj;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(2009208746);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
            changed2 = ((i10222 <= 256 && startRestartGroup.changed(drawerState3)) || (i5 & 384) == 256) | startRestartGroup.changed(f422);
            Object rememberedValue6222 = startRestartGroup.rememberedValue();
            if (!changed2) {
            }
            final float f3222 = 0.0f;
            Function0<Float> function03222 = new Function0<Float>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$3$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final Float m2745invoke() {
                    float calculateFraction;
                    calculateFraction = NavigationDrawerKt.calculateFraction(f422, f3222, drawerState3.requireOffset$material3_release());
                    return Float.valueOf(calculateFraction);
                }
            };
            startRestartGroup.updateRememberedValue(function03222);
            obj2 = function03222;
            startRestartGroup.endReplaceableGroup();
            boolean z6222 = z3;
            m2738ScrimBx497Mc(isOpen222, function02222, (Function0) obj2, scrimColor, startRestartGroup, (i5 >> 3) & 7168);
            Modifier.Companion companion3222 = Modifier.INSTANCE;
            startRestartGroup.startReplaceableGroup(2009208945);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
            if (i10222 <= 256) {
            }
            rememberedValue3 = startRestartGroup.rememberedValue();
            if (!z4) {
            }
            rememberedValue3 = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$4$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                    return IntOffset.box-impl(m2746invokeBjo55l4((Density) obj3));
                }

                /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                public final long m2746invokeBjo55l4(Density density2222) {
                    return IntOffsetKt.IntOffset(MathKt.roundToInt(DrawerState.this.requireOffset$material3_release()), 0);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue3);
            startRestartGroup.endReplaceableGroup();
            Modifier offset222 = OffsetKt.offset(companion3222, (Function1) rememberedValue3);
            startRestartGroup.startReplaceableGroup(2009209171);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
            changed3 = startRestartGroup.changed(m3033getStringNWtq28222) | ((i10222 <= 256 && startRestartGroup.changed(drawerState3)) || (i5 & 384) == 256) | startRestartGroup.changedInstance(coroutineScope222);
            rememberedValue4 = startRestartGroup.rememberedValue();
            if (!changed3) {
            }
            rememberedValue4 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$5$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                    invoke((SemanticsPropertyReceiver) obj3);
                    return Unit.INSTANCE;
                }

                public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, m3033getStringNWtq28222);
                    if (drawerState3.isOpen()) {
                        final DrawerState drawerState4 = drawerState3;
                        final CoroutineScope coroutineScope2222 = coroutineScope222;
                        SemanticsPropertiesKt.dismiss$default(semanticsPropertyReceiver, (String) null, new Function0<Boolean>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$5$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                            public final Boolean m2747invoke() {
                                if (((Boolean) DrawerState.this.getAnchoredDraggableState$material3_release().getConfirmValueChange$material3_release().invoke(DrawerValue.Closed)).booleanValue()) {
                                    BuildersKt.launch$default(coroutineScope2222, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(DrawerState.this, null), 3, (Object) null);
                                }
                                return true;
                            }

                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* compiled from: NavigationDrawer.kt */
                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                            @DebugMetadata(c = "androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$5$1$1$1", f = "NavigationDrawer.kt", i = {}, l = {377}, m = "invokeSuspend", n = {}, s = {})
                            /* renamed from: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$5$1$1$1, reason: invalid class name */
                            /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
                            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                final /* synthetic */ DrawerState $drawerState;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                AnonymousClass1(DrawerState drawerState, Continuation<? super AnonymousClass1> continuation) {
                                    super(2, continuation);
                                    this.$drawerState = drawerState;
                                }

                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    return new AnonymousClass1(this.$drawerState, continuation);
                                }

                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                    return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                                }

                                public final Object invokeSuspend(Object obj) {
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    int i = this.label;
                                    if (i == 0) {
                                        ResultKt.throwOnFailure(obj);
                                        this.label = 1;
                                        if (this.$drawerState.close((Continuation) this) == coroutine_suspended) {
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
                        }, 1, (Object) null);
                    }
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue4);
            startRestartGroup.endReplaceableGroup();
            Modifier semantics$default222 = SemanticsModifierKt.semantics$default(offset222, false, (Function1) rememberedValue4, 1, (Object) null);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy3222 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3222 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0 constructor3222 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3222 = LayoutKt.modifierMaterializerOf(semantics$default222);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m4109constructorimpl3 = Updater.m4109constructorimpl(startRestartGroup);
            Updater.m4116setimpl(m4109constructorimpl3, rememberBoxMeasurePolicy3222, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4116setimpl(m4109constructorimpl3, currentCompositionLocalMap3222, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash3222 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (!m4109constructorimpl3.getInserting()) {
            }
            m4109constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
            m4109constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3222);
            modifierMaterializerOf3222.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance3222 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -860466551, "C382@14294L15:NavigationDrawer.kt#uh7d8r");
            function2.invoke(startRestartGroup, Integer.valueOf(i5 & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
            }
            z5 = z6222;
            modifier2 = modifier3222;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        if ((i & 384) != 0) {
        }
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i & 24576) == 0) {
        }
        if ((i2 & 32) == 0) {
        }
        i3 |= i6;
        if ((i3 & 74899) == 74898) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i9 != 0) {
        }
        if ((i2 & 4) != 0) {
        }
        if (i4 != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        i5 = i3;
        drawerState3 = drawerState2;
        z3 = z2;
        scrimColor = j2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceableGroup(773894976);
        ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
        startRestartGroup.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        final CoroutineScope coroutineScope2222 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
        startRestartGroup.endReplaceableGroup();
        Strings.Companion companion4222 = Strings.INSTANCE;
        final String m3033getStringNWtq282222 = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0754R.string.navigation_menu), startRestartGroup, 0);
        ProvidableCompositionLocal localDensity2222 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume3222 = startRestartGroup.consume(localDensity2222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        final Density density2222 = (Density) consume3222;
        final float f4222 = -density2222.toPx-0680j_4(NavigationDrawerTokens.INSTANCE.m3728getContainerWidthD9Ej5fM());
        startRestartGroup.startReplaceableGroup(-1870335235);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
        int i102222 = (i5 & 896) ^ 384;
        changed = ((i102222 <= 256 && startRestartGroup.changed(drawerState3)) || (i5 & 384) == 256) | startRestartGroup.changed(density2222) | startRestartGroup.changed(f4222);
        rememberedValue2 = startRestartGroup.rememberedValue();
        final float f22222 = 0.0f;
        if (!changed) {
        }
        rememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m2743invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2743invoke() {
                DrawerState.this.setDensity$material3_release(density2222);
                AnchoredDraggableState<DrawerValue> anchoredDraggableState$material3_release = DrawerState.this.getAnchoredDraggableState$material3_release();
                final float f32222 = f4222;
                final float f42222 = f22222;
                AnchoredDraggableState.updateAnchors$default(anchoredDraggableState$material3_release, AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<DrawerValue>, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$1$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                        invoke((DraggableAnchorsConfig<DrawerValue>) obj3);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(DraggableAnchorsConfig<DrawerValue> draggableAnchorsConfig) {
                        draggableAnchorsConfig.m48at(DrawerValue.Closed, f32222);
                        draggableAnchorsConfig.m48at(DrawerValue.Open, f42222);
                    }
                }), null, 2, null);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue2);
        startRestartGroup.endReplaceableGroup();
        EffectsKt.SideEffect((Function0) rememberedValue2, startRestartGroup, 0);
        ProvidableCompositionLocal localLayoutDirection2222 = CompositionLocalsKt.getLocalLayoutDirection();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume22222 = startRestartGroup.consume(localLayoutDirection2222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        Modifier anchoredDraggable$default2222 = AnchoredDraggableKt.anchoredDraggable$default(SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, null), drawerState3.getAnchoredDraggableState$material3_release(), Orientation.Horizontal, z3, consume22222 == LayoutDirection.Rtl, null, 16, null);
        startRestartGroup.startReplaceableGroup(733328855);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
        MeasurePolicy rememberBoxMeasurePolicy4222 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
        Modifier modifier32222 = modifier2;
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap4222 = startRestartGroup.getCurrentCompositionLocalMap();
        Function0 constructor4222 = ComposeUiNode.Companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4222 = LayoutKt.modifierMaterializerOf(anchoredDraggable$default2222);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m4109constructorimpl = Updater.m4109constructorimpl(startRestartGroup);
        Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy4222, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap4222, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2 setCompositeKeyHash4222 = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (!m4109constructorimpl.getInserting()) {
        }
        m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash4222);
        modifierMaterializerOf4222.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
        BoxScopeInstance boxScopeInstance4222 = BoxScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2009208343, "C341@12933L37,346@13047L264,354@13336L98,344@12979L497,361@13535L198,368@13761L507,359@13485L834:NavigationDrawer.kt#uh7d8r");
        startRestartGroup.startReplaceableGroup(733328855);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
        Modifier.Companion companion22222 = Modifier.INSTANCE;
        MeasurePolicy rememberBoxMeasurePolicy22222 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
        currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap22222 = startRestartGroup.getCurrentCompositionLocalMap();
        Function0 constructor22222 = ComposeUiNode.Companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf22222 = LayoutKt.modifierMaterializerOf(companion22222);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m4109constructorimpl2 = Updater.m4109constructorimpl(startRestartGroup);
        Updater.m4116setimpl(m4109constructorimpl2, rememberBoxMeasurePolicy22222, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m4116setimpl(m4109constructorimpl2, currentCompositionLocalMap22222, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2 setCompositeKeyHash22222 = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (!m4109constructorimpl2.getInserting()) {
        }
        m4109constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
        m4109constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash22222);
        modifierMaterializerOf22222.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
        BoxScopeInstance boxScopeInstance22222 = BoxScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -860467894, "C342@12951L9:NavigationDrawer.kt#uh7d8r");
        function22.invoke(startRestartGroup, Integer.valueOf((i5 >> 15) & 14));
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        boolean isOpen2222 = drawerState3.isOpen();
        startRestartGroup.startReplaceableGroup(2009208457);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
        changedInstance = ((i5 & 7168) == 2048) | ((i102222 <= 256 && startRestartGroup.changed(drawerState3)) || (i5 & 384) == 256) | startRestartGroup.changedInstance(coroutineScope2222);
        Object rememberedValue52222 = startRestartGroup.rememberedValue();
        if (!changedInstance) {
        }
        Function0<Unit> function04222 = new Function0<Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m2744invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2744invoke() {
                if (z3 && ((Boolean) drawerState3.getAnchoredDraggableState$material3_release().getConfirmValueChange$material3_release().invoke(DrawerValue.Closed)).booleanValue()) {
                    BuildersKt.launch$default(coroutineScope2222, (CoroutineContext) null, (CoroutineStart) null, new C06631(drawerState3, null), 3, (Object) null);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: NavigationDrawer.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$2$1$1", f = "NavigationDrawer.kt", i = {}, l = {352}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$2$1$1 */
            /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
            public static final class C06631 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ DrawerState $drawerState;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C06631(DrawerState drawerState, Continuation<? super C06631> continuation) {
                    super(2, continuation);
                    this.$drawerState = drawerState;
                }

                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C06631(this.$drawerState, continuation);
                }

                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                }

                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        if (this.$drawerState.close((Continuation) this) == coroutine_suspended) {
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
        };
        startRestartGroup.updateRememberedValue(function04222);
        obj = function04222;
        Function0 function022222 = (Function0) obj;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(2009208746);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
        changed2 = ((i102222 <= 256 && startRestartGroup.changed(drawerState3)) || (i5 & 384) == 256) | startRestartGroup.changed(f4222);
        Object rememberedValue62222 = startRestartGroup.rememberedValue();
        if (!changed2) {
        }
        final float f32222 = 0.0f;
        Function0<Float> function032222 = new Function0<Float>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$3$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Float m2745invoke() {
                float calculateFraction;
                calculateFraction = NavigationDrawerKt.calculateFraction(f4222, f32222, drawerState3.requireOffset$material3_release());
                return Float.valueOf(calculateFraction);
            }
        };
        startRestartGroup.updateRememberedValue(function032222);
        obj2 = function032222;
        startRestartGroup.endReplaceableGroup();
        boolean z62222 = z3;
        m2738ScrimBx497Mc(isOpen2222, function022222, (Function0) obj2, scrimColor, startRestartGroup, (i5 >> 3) & 7168);
        Modifier.Companion companion32222 = Modifier.INSTANCE;
        startRestartGroup.startReplaceableGroup(2009208945);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
        if (i102222 <= 256) {
        }
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (!z4) {
        }
        rememberedValue3 = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$4$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                return IntOffset.box-impl(m2746invokeBjo55l4((Density) obj3));
            }

            /* renamed from: invoke-Bjo55l4, reason: not valid java name */
            public final long m2746invokeBjo55l4(Density density22222) {
                return IntOffsetKt.IntOffset(MathKt.roundToInt(DrawerState.this.requireOffset$material3_release()), 0);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue3);
        startRestartGroup.endReplaceableGroup();
        Modifier offset2222 = OffsetKt.offset(companion32222, (Function1) rememberedValue3);
        startRestartGroup.startReplaceableGroup(2009209171);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
        changed3 = startRestartGroup.changed(m3033getStringNWtq282222) | ((i102222 <= 256 && startRestartGroup.changed(drawerState3)) || (i5 & 384) == 256) | startRestartGroup.changedInstance(coroutineScope2222);
        rememberedValue4 = startRestartGroup.rememberedValue();
        if (!changed3) {
        }
        rememberedValue4 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$5$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                invoke((SemanticsPropertyReceiver) obj3);
                return Unit.INSTANCE;
            }

            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, m3033getStringNWtq282222);
                if (drawerState3.isOpen()) {
                    final DrawerState drawerState4 = drawerState3;
                    final CoroutineScope coroutineScope22222 = coroutineScope2222;
                    SemanticsPropertiesKt.dismiss$default(semanticsPropertyReceiver, (String) null, new Function0<Boolean>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$5$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final Boolean m2747invoke() {
                            if (((Boolean) DrawerState.this.getAnchoredDraggableState$material3_release().getConfirmValueChange$material3_release().invoke(DrawerValue.Closed)).booleanValue()) {
                                BuildersKt.launch$default(coroutineScope22222, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(DrawerState.this, null), 3, (Object) null);
                            }
                            return true;
                        }

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* compiled from: NavigationDrawer.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                        @DebugMetadata(c = "androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$5$1$1$1", f = "NavigationDrawer.kt", i = {}, l = {377}, m = "invokeSuspend", n = {}, s = {})
                        /* renamed from: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$2$5$1$1$1, reason: invalid class name */
                        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
                        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ DrawerState $drawerState;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass1(DrawerState drawerState, Continuation<? super AnonymousClass1> continuation) {
                                super(2, continuation);
                                this.$drawerState = drawerState;
                            }

                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new AnonymousClass1(this.$drawerState, continuation);
                            }

                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                            }

                            public final Object invokeSuspend(Object obj) {
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                int i = this.label;
                                if (i == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    this.label = 1;
                                    if (this.$drawerState.close((Continuation) this) == coroutine_suspended) {
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
                    }, 1, (Object) null);
                }
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue4);
        startRestartGroup.endReplaceableGroup();
        Modifier semantics$default2222 = SemanticsModifierKt.semantics$default(offset2222, false, (Function1) rememberedValue4, 1, (Object) null);
        startRestartGroup.startReplaceableGroup(733328855);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
        MeasurePolicy rememberBoxMeasurePolicy32222 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
        currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap32222 = startRestartGroup.getCurrentCompositionLocalMap();
        Function0 constructor32222 = ComposeUiNode.Companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf32222 = LayoutKt.modifierMaterializerOf(semantics$default2222);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m4109constructorimpl3 = Updater.m4109constructorimpl(startRestartGroup);
        Updater.m4116setimpl(m4109constructorimpl3, rememberBoxMeasurePolicy32222, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m4116setimpl(m4109constructorimpl3, currentCompositionLocalMap32222, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2 setCompositeKeyHash32222 = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (!m4109constructorimpl3.getInserting()) {
        }
        m4109constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
        m4109constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash32222);
        modifierMaterializerOf32222.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
        BoxScopeInstance boxScopeInstance32222 = BoxScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -860466551, "C382@14294L15:NavigationDrawer.kt#uh7d8r");
        function2.invoke(startRestartGroup, Integer.valueOf(i5 & 14));
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
        }
        z5 = z62222;
        modifier2 = modifier32222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x03ef  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0418  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x04b2  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x04be  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x04e7  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x056e  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x04c2  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x03f3  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x057c  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0375  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x03e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void DismissibleNavigationDrawer(final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, DrawerState drawerState, boolean z, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        final DrawerState drawerState2;
        int i4;
        boolean z2;
        boolean changed;
        Object rememberedValue;
        Object rememberedValue2;
        int currentCompositeKeyHash;
        Composer m4109constructorimpl;
        boolean z3;
        MeasurePolicy rememberedValue3;
        int currentCompositeKeyHash2;
        Composer m4109constructorimpl2;
        boolean changed2;
        Object rememberedValue4;
        int currentCompositeKeyHash3;
        Composer m4109constructorimpl3;
        int currentCompositeKeyHash4;
        Composer m4109constructorimpl4;
        final DrawerState drawerState3;
        final boolean z4;
        ScopeUpdateScope endRestartGroup;
        int i5;
        Composer startRestartGroup = composer.startRestartGroup(398812198);
        ComposerKt.sourceInformation(startRestartGroup, "C(DismissibleNavigationDrawer)P(1,4,2,3)412@15589L39,416@15738L7,422@15939L250,422@15928L261,432@16207L24,433@16257L33,435@16329L7,436@16364L1446:NavigationDrawer.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i6 = i2 & 2;
        if (i6 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i & 384) != 0) {
                if ((i2 & 4) == 0) {
                    drawerState2 = drawerState;
                    if (startRestartGroup.changed(drawerState2)) {
                        i5 = 256;
                        i3 |= i5;
                    }
                } else {
                    drawerState2 = drawerState;
                }
                i5 = Fields.SpotShadowColor;
                i3 |= i5;
            } else {
                drawerState2 = drawerState;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? Fields.CameraDistance : Fields.RotationZ;
                if ((i2 & 16) != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    i3 |= startRestartGroup.changedInstance(function22) ? Fields.Clip : Fields.Shape;
                }
                if ((i3 & 9363) == 9362 || !startRestartGroup.getSkipping()) {
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                        if (i6 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            drawerState2 = rememberDrawerState(DrawerValue.Closed, null, startRestartGroup, 6, 2);
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(398812198, i3, -1, "androidx.compose.material3.DismissibleNavigationDrawer (NavigationDrawer.kt:415)");
                    }
                    ProvidableCompositionLocal localDensity = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume = startRestartGroup.consume(localDensity);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    final Density density = (Density) consume;
                    final float f = -density.toPx-0680j_4(NavigationDrawerTokens.INSTANCE.m3728getContainerWidthD9Ej5fM());
                    startRestartGroup.startReplaceableGroup(171918245);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
                    int i7 = (i3 & 896) ^ 384;
                    changed = ((i7 <= 256 && startRestartGroup.changed(drawerState2)) || (i3 & 384) == 256) | startRestartGroup.changed(density) | startRestartGroup.changed(f);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        final float f2 = 0.0f;
                        rememberedValue = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            public /* bridge */ /* synthetic */ Object invoke() {
                                m2741invoke();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: collision with other method in class */
                            public final void m2741invoke() {
                                DrawerState.this.setDensity$material3_release(density);
                                AnchoredDraggableState<DrawerValue> anchoredDraggableState$material3_release = DrawerState.this.getAnchoredDraggableState$material3_release();
                                final float f3 = f;
                                final float f4 = f2;
                                AnchoredDraggableState.updateAnchors$default(anchoredDraggableState$material3_release, AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<DrawerValue>, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$1$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((DraggableAnchorsConfig<DrawerValue>) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(DraggableAnchorsConfig<DrawerValue> draggableAnchorsConfig) {
                                        draggableAnchorsConfig.m48at(DrawerValue.Closed, f3);
                                        draggableAnchorsConfig.m48at(DrawerValue.Open, f4);
                                    }
                                }), null, 2, null);
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    startRestartGroup.endReplaceableGroup();
                    EffectsKt.SideEffect((Function0) rememberedValue, startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(773894976);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                    startRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                        startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                        rememberedValue2 = compositionScopedCoroutineScopeCanceller;
                    }
                    startRestartGroup.endReplaceableGroup();
                    final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue2).getCoroutineScope();
                    startRestartGroup.endReplaceableGroup();
                    Strings.Companion companion = Strings.INSTANCE;
                    final String m3033getStringNWtq28 = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0754R.string.navigation_menu), startRestartGroup, 0);
                    ProvidableCompositionLocal localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume2 = startRestartGroup.consume(localLayoutDirection);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    Modifier anchoredDraggable$default = AnchoredDraggableKt.anchoredDraggable$default(modifier2, drawerState2.getAnchoredDraggableState$material3_release(), Orientation.Horizontal, z2, consume2 == LayoutDirection.Rtl, null, 16, null);
                    startRestartGroup.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifier3 = modifier2;
                    Function0 constructor = ComposeUiNode.Companion.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(anchoredDraggable$default);
                    boolean z5 = z2;
                    if (!(startRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                        startRestartGroup.createNode(constructor);
                    } else {
                        startRestartGroup.useNode();
                    }
                    m4109constructorimpl = Updater.m4109constructorimpl(startRestartGroup);
                    Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (!m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 973030793, "C464@17278L526,445@16646L1158:NavigationDrawer.kt#uh7d8r");
                    startRestartGroup.startReplaceableGroup(973031425);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
                    z3 = (i7 <= 256 && startRestartGroup.changed(drawerState2)) || (i3 & 384) == 256;
                    rememberedValue3 = startRestartGroup.rememberedValue();
                    if (!z3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue3 = new MeasurePolicy() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$2$1
                            @Override // androidx.compose.p002ui.layout.MeasurePolicy
                            /* renamed from: measure-3p2s80s */
                            public final MeasureResult mo147measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                                final Placeable mo6318measureBRTryo0 = list.get(0).mo6318measureBRTryo0(j);
                                final Placeable mo6318measureBRTryo02 = list.get(1).mo6318measureBRTryo0(j);
                                int width = mo6318measureBRTryo02.getWidth();
                                int height = mo6318measureBRTryo02.getHeight();
                                final DrawerState drawerState4 = DrawerState.this;
                                return MeasureScope.layout$default(measureScope, width, height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$2$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((Placeable.PlacementScope) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Placeable.PlacementScope placementScope) {
                                        Placeable.PlacementScope.placeRelative$default(placementScope, Placeable.this, MathKt.roundToInt(drawerState4.requireOffset$material3_release()) + mo6318measureBRTryo0.getWidth(), 0, 0.0f, 4, null);
                                        Placeable.PlacementScope.placeRelative$default(placementScope, mo6318measureBRTryo0, MathKt.roundToInt(drawerState4.requireOffset$material3_release()), 0, 0.0f, 4, null);
                                    }
                                }, 4, null);
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue3);
                    }
                    MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue3;
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                    Modifier.Companion companion2 = Modifier.INSTANCE;
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                    Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(companion2);
                    if (!(startRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                        startRestartGroup.createNode(constructor2);
                    } else {
                        startRestartGroup.useNode();
                    }
                    m4109constructorimpl2 = Updater.m4109constructorimpl(startRestartGroup);
                    Updater.m4116setimpl(m4109constructorimpl2, measurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m4116setimpl(m4109constructorimpl2, currentCompositionLocalMap2, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (!m4109constructorimpl2.getInserting() || !Intrinsics.areEqual(m4109constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        m4109constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        m4109constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    modifierMaterializerOf2.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 94149449, "C446@16700L459,446@16677L531,461@17221L45:NavigationDrawer.kt#uh7d8r");
                    Modifier.Companion companion3 = Modifier.INSTANCE;
                    startRestartGroup.startReplaceableGroup(94149472);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
                    changed2 = startRestartGroup.changed(m3033getStringNWtq28) | ((i7 <= 256 && startRestartGroup.changed(drawerState2)) || (i3 & 384) == 256) | startRestartGroup.changedInstance(coroutineScope);
                    rememberedValue4 = startRestartGroup.rememberedValue();
                    if (!changed2 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue4 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1$1
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
                                SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, m3033getStringNWtq28);
                                if (drawerState2.isOpen()) {
                                    final DrawerState drawerState4 = drawerState2;
                                    final CoroutineScope coroutineScope2 = coroutineScope;
                                    SemanticsPropertiesKt.dismiss$default(semanticsPropertyReceiver, (String) null, new Function0<Boolean>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                        public final Boolean m2742invoke() {
                                            if (((Boolean) DrawerState.this.getAnchoredDraggableState$material3_release().getConfirmValueChange$material3_release().invoke(DrawerValue.Closed)).booleanValue()) {
                                                BuildersKt.launch$default(coroutineScope2, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(DrawerState.this, null), 3, (Object) null);
                                            }
                                            return true;
                                        }

                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* compiled from: NavigationDrawer.kt */
                                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                        @DebugMetadata(c = "androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1$1$1$1", f = "NavigationDrawer.kt", i = {}, l = {455}, m = "invokeSuspend", n = {}, s = {})
                                        /* renamed from: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1$1$1$1, reason: invalid class name */
                                        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
                                        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                            final /* synthetic */ DrawerState $drawerState;
                                            int label;

                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            AnonymousClass1(DrawerState drawerState, Continuation<? super AnonymousClass1> continuation) {
                                                super(2, continuation);
                                                this.$drawerState = drawerState;
                                            }

                                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                return new AnonymousClass1(this.$drawerState, continuation);
                                            }

                                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                                            }

                                            public final Object invokeSuspend(Object obj) {
                                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                int i = this.label;
                                                if (i == 0) {
                                                    ResultKt.throwOnFailure(obj);
                                                    this.label = 1;
                                                    if (this.$drawerState.close((Continuation) this) == coroutine_suspended) {
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
                                    }, 1, (Object) null);
                                }
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue4);
                    }
                    startRestartGroup.endReplaceableGroup();
                    Modifier semantics$default = SemanticsModifierKt.semantics$default(companion3, false, (Function1) rememberedValue4, 1, (Object) null);
                    startRestartGroup.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                    MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                    currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                    Function0 constructor3 = ComposeUiNode.Companion.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(semantics$default);
                    if (!(startRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                        startRestartGroup.createNode(constructor3);
                    } else {
                        startRestartGroup.useNode();
                    }
                    m4109constructorimpl3 = Updater.m4109constructorimpl(startRestartGroup);
                    Updater.m4116setimpl(m4109constructorimpl3, rememberBoxMeasurePolicy2, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m4116setimpl(m4109constructorimpl3, currentCompositionLocalMap3, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2 setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (!m4109constructorimpl3.getInserting() || !Intrinsics.areEqual(m4109constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        m4109constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        m4109constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    }
                    modifierMaterializerOf3.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -817264288, "C459@17179L15:NavigationDrawer.kt#uh7d8r");
                    function2.invoke(startRestartGroup, Integer.valueOf(i3 & 14));
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endNode();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                    Modifier.Companion companion4 = Modifier.INSTANCE;
                    MeasurePolicy rememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                    currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
                    Function0 constructor4 = ComposeUiNode.Companion.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(companion4);
                    if (!(startRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                        startRestartGroup.createNode(constructor4);
                    } else {
                        startRestartGroup.useNode();
                    }
                    m4109constructorimpl4 = Updater.m4109constructorimpl(startRestartGroup);
                    Updater.m4116setimpl(m4109constructorimpl4, rememberBoxMeasurePolicy3, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m4116setimpl(m4109constructorimpl4, currentCompositionLocalMap4, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2 setCompositeKeyHash4 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (!m4109constructorimpl4.getInserting() || !Intrinsics.areEqual(m4109constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                        m4109constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                        m4109constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                    }
                    modifierMaterializerOf4.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -817264224, "C462@17243L9:NavigationDrawer.kt#uh7d8r");
                    function22.invoke(startRestartGroup, Integer.valueOf((i3 >> 12) & 14));
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
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endNode();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    drawerState3 = drawerState2;
                    z4 = z5;
                    modifier2 = modifier3;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    drawerState3 = drawerState2;
                    z4 = z2;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier4 = modifier2;
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$3
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

                        public final void invoke(Composer composer2, int i8) {
                            NavigationDrawerKt.DismissibleNavigationDrawer(function2, modifier4, drawerState3, z4, function22, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                    return;
                }
                return;
            }
            z2 = z;
            if ((i2 & 16) != 0) {
            }
            if ((i3 & 9363) == 9362) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i6 != 0) {
            }
            if ((i2 & 4) != 0) {
            }
            if (i4 != 0) {
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            ProvidableCompositionLocal localDensity2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume3 = startRestartGroup.consume(localDensity2);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final Density density2 = (Density) consume3;
            final float f3 = -density2.toPx-0680j_4(NavigationDrawerTokens.INSTANCE.m3728getContainerWidthD9Ej5fM());
            startRestartGroup.startReplaceableGroup(171918245);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
            int i72 = (i3 & 896) ^ 384;
            changed = ((i72 <= 256 && startRestartGroup.changed(drawerState2)) || (i3 & 384) == 256) | startRestartGroup.changed(density2) | startRestartGroup.changed(f3);
            rememberedValue = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            final float f22 = 0.0f;
            rememberedValue = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m2741invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2741invoke() {
                    DrawerState.this.setDensity$material3_release(density2);
                    AnchoredDraggableState<DrawerValue> anchoredDraggableState$material3_release = DrawerState.this.getAnchoredDraggableState$material3_release();
                    final float f32 = f3;
                    final float f4 = f22;
                    AnchoredDraggableState.updateAnchors$default(anchoredDraggableState$material3_release, AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<DrawerValue>, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$1$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((DraggableAnchorsConfig<DrawerValue>) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(DraggableAnchorsConfig<DrawerValue> draggableAnchorsConfig) {
                            draggableAnchorsConfig.m48at(DrawerValue.Closed, f32);
                            draggableAnchorsConfig.m48at(DrawerValue.Open, f4);
                        }
                    }), null, 2, null);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceableGroup();
            EffectsKt.SideEffect((Function0) rememberedValue, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(773894976);
            ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            final CoroutineScope coroutineScope2 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue2).getCoroutineScope();
            startRestartGroup.endReplaceableGroup();
            Strings.Companion companion5 = Strings.INSTANCE;
            final String m3033getStringNWtq282 = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0754R.string.navigation_menu), startRestartGroup, 0);
            ProvidableCompositionLocal localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume22 = startRestartGroup.consume(localLayoutDirection2);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Modifier anchoredDraggable$default2 = AnchoredDraggableKt.anchoredDraggable$default(modifier2, drawerState2.getAnchoredDraggableState$material3_release(), Orientation.Horizontal, z2, consume22 == LayoutDirection.Rtl, null, 16, null);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy4 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap5 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifier32 = modifier2;
            Function0 constructor5 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf5 = LayoutKt.modifierMaterializerOf(anchoredDraggable$default2);
            boolean z52 = z2;
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m4109constructorimpl = Updater.m4109constructorimpl(startRestartGroup);
            Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy4, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap5, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash5 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (!m4109constructorimpl.getInserting()) {
            }
            m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash5);
            modifierMaterializerOf5.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 973030793, "C464@17278L526,445@16646L1158:NavigationDrawer.kt#uh7d8r");
            startRestartGroup.startReplaceableGroup(973031425);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
            if (i72 <= 256) {
            }
            rememberedValue3 = startRestartGroup.rememberedValue();
            if (!z3) {
            }
            rememberedValue3 = new MeasurePolicy() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$2$1
                @Override // androidx.compose.p002ui.layout.MeasurePolicy
                /* renamed from: measure-3p2s80s */
                public final MeasureResult mo147measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                    final Placeable mo6318measureBRTryo0 = list.get(0).mo6318measureBRTryo0(j);
                    final Placeable mo6318measureBRTryo02 = list.get(1).mo6318measureBRTryo0(j);
                    int width = mo6318measureBRTryo02.getWidth();
                    int height = mo6318measureBRTryo02.getHeight();
                    final DrawerState drawerState4 = DrawerState.this;
                    return MeasureScope.layout$default(measureScope, width, height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$2$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((Placeable.PlacementScope) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Placeable.PlacementScope placementScope) {
                            Placeable.PlacementScope.placeRelative$default(placementScope, Placeable.this, MathKt.roundToInt(drawerState4.requireOffset$material3_release()) + mo6318measureBRTryo0.getWidth(), 0, 0.0f, 4, null);
                            Placeable.PlacementScope.placeRelative$default(placementScope, mo6318measureBRTryo0, MathKt.roundToInt(drawerState4.requireOffset$material3_release()), 0, 0.0f, 4, null);
                        }
                    }, 4, null);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue3);
            MeasurePolicy measurePolicy2 = (MeasurePolicy) rememberedValue3;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            Modifier.Companion companion22 = Modifier.INSTANCE;
            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0 constructor22 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf22 = LayoutKt.modifierMaterializerOf(companion22);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m4109constructorimpl2 = Updater.m4109constructorimpl(startRestartGroup);
            Updater.m4116setimpl(m4109constructorimpl2, measurePolicy2, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4116setimpl(m4109constructorimpl2, currentCompositionLocalMap22, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash22 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (!m4109constructorimpl2.getInserting()) {
            }
            m4109constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
            m4109constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash22);
            modifierMaterializerOf22.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 94149449, "C446@16700L459,446@16677L531,461@17221L45:NavigationDrawer.kt#uh7d8r");
            Modifier.Companion companion32 = Modifier.INSTANCE;
            startRestartGroup.startReplaceableGroup(94149472);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
            changed2 = startRestartGroup.changed(m3033getStringNWtq282) | ((i72 <= 256 && startRestartGroup.changed(drawerState2)) || (i3 & 384) == 256) | startRestartGroup.changedInstance(coroutineScope2);
            rememberedValue4 = startRestartGroup.rememberedValue();
            if (!changed2) {
            }
            rememberedValue4 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1$1
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
                    SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, m3033getStringNWtq282);
                    if (drawerState2.isOpen()) {
                        final DrawerState drawerState4 = drawerState2;
                        final CoroutineScope coroutineScope22 = coroutineScope2;
                        SemanticsPropertiesKt.dismiss$default(semanticsPropertyReceiver, (String) null, new Function0<Boolean>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                            public final Boolean m2742invoke() {
                                if (((Boolean) DrawerState.this.getAnchoredDraggableState$material3_release().getConfirmValueChange$material3_release().invoke(DrawerValue.Closed)).booleanValue()) {
                                    BuildersKt.launch$default(coroutineScope22, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(DrawerState.this, null), 3, (Object) null);
                                }
                                return true;
                            }

                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* compiled from: NavigationDrawer.kt */
                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                            @DebugMetadata(c = "androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1$1$1$1", f = "NavigationDrawer.kt", i = {}, l = {455}, m = "invokeSuspend", n = {}, s = {})
                            /* renamed from: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1$1$1$1, reason: invalid class name */
                            /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
                            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                final /* synthetic */ DrawerState $drawerState;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                AnonymousClass1(DrawerState drawerState, Continuation<? super AnonymousClass1> continuation) {
                                    super(2, continuation);
                                    this.$drawerState = drawerState;
                                }

                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    return new AnonymousClass1(this.$drawerState, continuation);
                                }

                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                    return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                                }

                                public final Object invokeSuspend(Object obj) {
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    int i = this.label;
                                    if (i == 0) {
                                        ResultKt.throwOnFailure(obj);
                                        this.label = 1;
                                        if (this.$drawerState.close((Continuation) this) == coroutine_suspended) {
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
                        }, 1, (Object) null);
                    }
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue4);
            startRestartGroup.endReplaceableGroup();
            Modifier semantics$default2 = SemanticsModifierKt.semantics$default(companion32, false, (Function1) rememberedValue4, 1, (Object) null);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy22 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap32 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0 constructor32 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf32 = LayoutKt.modifierMaterializerOf(semantics$default2);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m4109constructorimpl3 = Updater.m4109constructorimpl(startRestartGroup);
            Updater.m4116setimpl(m4109constructorimpl3, rememberBoxMeasurePolicy22, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4116setimpl(m4109constructorimpl3, currentCompositionLocalMap32, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash32 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (!m4109constructorimpl3.getInserting()) {
            }
            m4109constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
            m4109constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash32);
            modifierMaterializerOf32.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance22 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -817264288, "C459@17179L15:NavigationDrawer.kt#uh7d8r");
            function2.invoke(startRestartGroup, Integer.valueOf(i3 & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            Modifier.Companion companion42 = Modifier.INSTANCE;
            MeasurePolicy rememberBoxMeasurePolicy32 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap42 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0 constructor42 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf42 = LayoutKt.modifierMaterializerOf(companion42);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m4109constructorimpl4 = Updater.m4109constructorimpl(startRestartGroup);
            Updater.m4116setimpl(m4109constructorimpl4, rememberBoxMeasurePolicy32, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4116setimpl(m4109constructorimpl4, currentCompositionLocalMap42, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash42 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (!m4109constructorimpl4.getInserting()) {
            }
            m4109constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
            m4109constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash42);
            modifierMaterializerOf42.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance32 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -817264224, "C462@17243L9:NavigationDrawer.kt#uh7d8r");
            function22.invoke(startRestartGroup, Integer.valueOf((i3 >> 12) & 14));
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
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
            }
            drawerState3 = drawerState2;
            z4 = z52;
            modifier2 = modifier32;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i & 384) != 0) {
        }
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i2 & 16) != 0) {
        }
        if ((i3 & 9363) == 9362) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i6 != 0) {
        }
        if ((i2 & 4) != 0) {
        }
        if (i4 != 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        ProvidableCompositionLocal localDensity22 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume32 = startRestartGroup.consume(localDensity22);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        final Density density22 = (Density) consume32;
        final float f32 = -density22.toPx-0680j_4(NavigationDrawerTokens.INSTANCE.m3728getContainerWidthD9Ej5fM());
        startRestartGroup.startReplaceableGroup(171918245);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
        int i722 = (i3 & 896) ^ 384;
        changed = ((i722 <= 256 && startRestartGroup.changed(drawerState2)) || (i3 & 384) == 256) | startRestartGroup.changed(density22) | startRestartGroup.changed(f32);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        final float f222 = 0.0f;
        rememberedValue = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m2741invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2741invoke() {
                DrawerState.this.setDensity$material3_release(density22);
                AnchoredDraggableState<DrawerValue> anchoredDraggableState$material3_release = DrawerState.this.getAnchoredDraggableState$material3_release();
                final float f322 = f32;
                final float f4 = f222;
                AnchoredDraggableState.updateAnchors$default(anchoredDraggableState$material3_release, AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<DrawerValue>, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$1$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((DraggableAnchorsConfig<DrawerValue>) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(DraggableAnchorsConfig<DrawerValue> draggableAnchorsConfig) {
                        draggableAnchorsConfig.m48at(DrawerValue.Closed, f322);
                        draggableAnchorsConfig.m48at(DrawerValue.Open, f4);
                    }
                }), null, 2, null);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceableGroup();
        EffectsKt.SideEffect((Function0) rememberedValue, startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(773894976);
        ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
        startRestartGroup.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        final CoroutineScope coroutineScope22 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue2).getCoroutineScope();
        startRestartGroup.endReplaceableGroup();
        Strings.Companion companion52 = Strings.INSTANCE;
        final String m3033getStringNWtq2822 = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0754R.string.navigation_menu), startRestartGroup, 0);
        ProvidableCompositionLocal localLayoutDirection22 = CompositionLocalsKt.getLocalLayoutDirection();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume222 = startRestartGroup.consume(localLayoutDirection22);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        Modifier anchoredDraggable$default22 = AnchoredDraggableKt.anchoredDraggable$default(modifier2, drawerState2.getAnchoredDraggableState$material3_release(), Orientation.Horizontal, z2, consume222 == LayoutDirection.Rtl, null, 16, null);
        startRestartGroup.startReplaceableGroup(733328855);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
        MeasurePolicy rememberBoxMeasurePolicy42 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap52 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier modifier322 = modifier2;
        Function0 constructor52 = ComposeUiNode.Companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf52 = LayoutKt.modifierMaterializerOf(anchoredDraggable$default22);
        boolean z522 = z2;
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m4109constructorimpl = Updater.m4109constructorimpl(startRestartGroup);
        Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy42, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap52, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2 setCompositeKeyHash52 = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (!m4109constructorimpl.getInserting()) {
        }
        m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash52);
        modifierMaterializerOf52.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
        BoxScopeInstance boxScopeInstance42 = BoxScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 973030793, "C464@17278L526,445@16646L1158:NavigationDrawer.kt#uh7d8r");
        startRestartGroup.startReplaceableGroup(973031425);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
        if (i722 <= 256) {
        }
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (!z3) {
        }
        rememberedValue3 = new MeasurePolicy() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$2$1
            @Override // androidx.compose.p002ui.layout.MeasurePolicy
            /* renamed from: measure-3p2s80s */
            public final MeasureResult mo147measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                final Placeable mo6318measureBRTryo0 = list.get(0).mo6318measureBRTryo0(j);
                final Placeable mo6318measureBRTryo02 = list.get(1).mo6318measureBRTryo0(j);
                int width = mo6318measureBRTryo02.getWidth();
                int height = mo6318measureBRTryo02.getHeight();
                final DrawerState drawerState4 = DrawerState.this;
                return MeasureScope.layout$default(measureScope, width, height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$2$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Placeable.PlacementScope) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Placeable.PlacementScope placementScope) {
                        Placeable.PlacementScope.placeRelative$default(placementScope, Placeable.this, MathKt.roundToInt(drawerState4.requireOffset$material3_release()) + mo6318measureBRTryo0.getWidth(), 0, 0.0f, 4, null);
                        Placeable.PlacementScope.placeRelative$default(placementScope, mo6318measureBRTryo0, MathKt.roundToInt(drawerState4.requireOffset$material3_release()), 0, 0.0f, 4, null);
                    }
                }, 4, null);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue3);
        MeasurePolicy measurePolicy22 = (MeasurePolicy) rememberedValue3;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
        Modifier.Companion companion222 = Modifier.INSTANCE;
        currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap222 = startRestartGroup.getCurrentCompositionLocalMap();
        Function0 constructor222 = ComposeUiNode.Companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf222 = LayoutKt.modifierMaterializerOf(companion222);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m4109constructorimpl2 = Updater.m4109constructorimpl(startRestartGroup);
        Updater.m4116setimpl(m4109constructorimpl2, measurePolicy22, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m4116setimpl(m4109constructorimpl2, currentCompositionLocalMap222, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2 setCompositeKeyHash222 = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (!m4109constructorimpl2.getInserting()) {
        }
        m4109constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
        m4109constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash222);
        modifierMaterializerOf222.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 94149449, "C446@16700L459,446@16677L531,461@17221L45:NavigationDrawer.kt#uh7d8r");
        Modifier.Companion companion322 = Modifier.INSTANCE;
        startRestartGroup.startReplaceableGroup(94149472);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
        changed2 = startRestartGroup.changed(m3033getStringNWtq2822) | ((i722 <= 256 && startRestartGroup.changed(drawerState2)) || (i3 & 384) == 256) | startRestartGroup.changedInstance(coroutineScope22);
        rememberedValue4 = startRestartGroup.rememberedValue();
        if (!changed2) {
        }
        rememberedValue4 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1$1
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
                SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, m3033getStringNWtq2822);
                if (drawerState2.isOpen()) {
                    final DrawerState drawerState4 = drawerState2;
                    final CoroutineScope coroutineScope222 = coroutineScope22;
                    SemanticsPropertiesKt.dismiss$default(semanticsPropertyReceiver, (String) null, new Function0<Boolean>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final Boolean m2742invoke() {
                            if (((Boolean) DrawerState.this.getAnchoredDraggableState$material3_release().getConfirmValueChange$material3_release().invoke(DrawerValue.Closed)).booleanValue()) {
                                BuildersKt.launch$default(coroutineScope222, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(DrawerState.this, null), 3, (Object) null);
                            }
                            return true;
                        }

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* compiled from: NavigationDrawer.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                        @DebugMetadata(c = "androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1$1$1$1", f = "NavigationDrawer.kt", i = {}, l = {455}, m = "invokeSuspend", n = {}, s = {})
                        /* renamed from: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$2$1$1$1$1$1, reason: invalid class name */
                        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
                        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ DrawerState $drawerState;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass1(DrawerState drawerState, Continuation<? super AnonymousClass1> continuation) {
                                super(2, continuation);
                                this.$drawerState = drawerState;
                            }

                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new AnonymousClass1(this.$drawerState, continuation);
                            }

                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                            }

                            public final Object invokeSuspend(Object obj) {
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                int i = this.label;
                                if (i == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    this.label = 1;
                                    if (this.$drawerState.close((Continuation) this) == coroutine_suspended) {
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
                    }, 1, (Object) null);
                }
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue4);
        startRestartGroup.endReplaceableGroup();
        Modifier semantics$default22 = SemanticsModifierKt.semantics$default(companion322, false, (Function1) rememberedValue4, 1, (Object) null);
        startRestartGroup.startReplaceableGroup(733328855);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
        MeasurePolicy rememberBoxMeasurePolicy222 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
        currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap322 = startRestartGroup.getCurrentCompositionLocalMap();
        Function0 constructor322 = ComposeUiNode.Companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf322 = LayoutKt.modifierMaterializerOf(semantics$default22);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m4109constructorimpl3 = Updater.m4109constructorimpl(startRestartGroup);
        Updater.m4116setimpl(m4109constructorimpl3, rememberBoxMeasurePolicy222, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m4116setimpl(m4109constructorimpl3, currentCompositionLocalMap322, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2 setCompositeKeyHash322 = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (!m4109constructorimpl3.getInserting()) {
        }
        m4109constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
        m4109constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash322);
        modifierMaterializerOf322.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
        BoxScopeInstance boxScopeInstance222 = BoxScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -817264288, "C459@17179L15:NavigationDrawer.kt#uh7d8r");
        function2.invoke(startRestartGroup, Integer.valueOf(i3 & 14));
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(733328855);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
        Modifier.Companion companion422 = Modifier.INSTANCE;
        MeasurePolicy rememberBoxMeasurePolicy322 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
        currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap422 = startRestartGroup.getCurrentCompositionLocalMap();
        Function0 constructor422 = ComposeUiNode.Companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf422 = LayoutKt.modifierMaterializerOf(companion422);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m4109constructorimpl4 = Updater.m4109constructorimpl(startRestartGroup);
        Updater.m4116setimpl(m4109constructorimpl4, rememberBoxMeasurePolicy322, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m4116setimpl(m4109constructorimpl4, currentCompositionLocalMap422, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2 setCompositeKeyHash422 = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (!m4109constructorimpl4.getInserting()) {
        }
        m4109constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
        m4109constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash422);
        modifierMaterializerOf422.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
        BoxScopeInstance boxScopeInstance322 = BoxScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -817264224, "C462@17243L9:NavigationDrawer.kt#uh7d8r");
        function22.invoke(startRestartGroup, Integer.valueOf((i3 >> 12) & 14));
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
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
        }
        drawerState3 = drawerState2;
        z4 = z522;
        modifier2 = modifier322;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    public static final void PermanentNavigationDrawer(final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i, final int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-276843608);
        ComposerKt.sourceInformation(startRestartGroup, "C(PermanentNavigationDrawer)P(1,2)501@18841L105:NavigationDrawer.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changedInstance(function22) ? Fields.RotationX : Fields.SpotShadowColor;
        }
        if ((i3 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-276843608, i3, -1, "androidx.compose.material3.PermanentNavigationDrawer (NavigationDrawer.kt:500)");
            }
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(modifier, 0.0f, 1, null);
            startRestartGroup.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillMaxSize$default);
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
            Updater.m4116setimpl(m4109constructorimpl, rowMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -326681643, "C92@4661L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1153993360, "C502@18879L15,503@18903L37:NavigationDrawer.kt#uh7d8r");
            function2.invoke(startRestartGroup, Integer.valueOf(i3 & 14));
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(companion);
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1146975803, "C504@18921L9:NavigationDrawer.kt#uh7d8r");
            function22.invoke(startRestartGroup, Integer.valueOf((i3 >> 6) & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        final Modifier modifier2 = modifier;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$PermanentNavigationDrawer$2
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

                public final void invoke(Composer composer2, int i5) {
                    NavigationDrawerKt.PermanentNavigationDrawer(function2, modifier2, function22, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00bf  */
    /* renamed from: ModalDrawerSheet-afqeVBk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2735ModalDrawerSheetafqeVBk(Modifier modifier, Shape shape, long j, long j2, float f, WindowInsets windowInsets, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Shape shape2;
        long j3;
        long j4;
        float f2;
        WindowInsets windowInsets2;
        Modifier.Companion companion;
        WindowInsets windowInsets3;
        float f3;
        final Shape shape3;
        ScopeUpdateScope endRestartGroup;
        int i4;
        int i5;
        int i6;
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(1001163336);
        ComposerKt.sourceInformation(startRestartGroup, "C(ModalDrawerSheet)P(5,3,1:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,6)528@20049L5,529@20105L14,530@20153L37,532@20308L12,535@20378L183:NavigationDrawer.kt#uh7d8r");
        int i8 = i2 & 1;
        if (i8 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                shape2 = shape;
                if (startRestartGroup.changed(shape2)) {
                    i7 = 32;
                    i3 |= i7;
                }
            } else {
                shape2 = shape;
            }
            i7 = 16;
            i3 |= i7;
        } else {
            shape2 = shape;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                j3 = j;
                if (startRestartGroup.changed(j3)) {
                    i6 = Fields.RotationX;
                    i3 |= i6;
                }
            } else {
                j3 = j;
            }
            i6 = Fields.SpotShadowColor;
            i3 |= i6;
        } else {
            j3 = j;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                j4 = j2;
                if (startRestartGroup.changed(j4)) {
                    i5 = Fields.CameraDistance;
                    i3 |= i5;
                }
            } else {
                j4 = j2;
            }
            i5 = Fields.RotationZ;
            i3 |= i5;
        } else {
            j4 = j2;
        }
        int i9 = i2 & 16;
        if (i9 != 0) {
            i3 |= 24576;
        } else if ((i & 24576) == 0) {
            f2 = f;
            i3 |= startRestartGroup.changed(f2) ? Fields.Clip : Fields.Shape;
            if ((196608 & i) != 0) {
                if ((i2 & 32) == 0) {
                    windowInsets2 = windowInsets;
                    if (startRestartGroup.changed(windowInsets2)) {
                        i4 = Fields.RenderEffect;
                        i3 |= i4;
                    }
                } else {
                    windowInsets2 = windowInsets;
                }
                i4 = 65536;
                i3 |= i4;
            } else {
                windowInsets2 = windowInsets;
            }
            if ((i2 & 64) == 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                i3 |= startRestartGroup.changedInstance(function3) ? 1048576 : Fields.BlendMode;
                if ((599187 & i3) == 599186 || !startRestartGroup.getSkipping()) {
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                        companion = i8 != 0 ? Modifier.INSTANCE : modifier2;
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                            shape2 = DrawerDefaults.INSTANCE.getShape(startRestartGroup, 6);
                        }
                        if ((i2 & 4) != 0) {
                            j3 = DrawerDefaults.INSTANCE.getContainerColor(startRestartGroup, 6);
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            j4 = ColorSchemeKt.m2381contentColorForek8zF_U(j3, startRestartGroup, (i3 >> 6) & 14);
                            i3 &= -7169;
                        }
                        if (i9 != 0) {
                            f2 = DrawerDefaults.INSTANCE.m2548getModalDrawerElevationD9Ej5fM();
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(startRestartGroup, 6);
                            f3 = f2;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1001163336, i3, -1, "androidx.compose.material3.ModalDrawerSheet (NavigationDrawer.kt:534)");
                            }
                            int i10 = i3 << 3;
                            m2734DrawerSheetvywBR7E(windowInsets3, companion, shape2, j3, j4, f3, function3, startRestartGroup, ((i3 >> 15) & 14) | (i10 & 112) | (i10 & 896) | (i10 & 7168) | (57344 & i10) | (i10 & 458752) | (i3 & 3670016), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            f2 = f3;
                            windowInsets2 = windowInsets3;
                            shape3 = shape2;
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
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                        }
                        companion = modifier2;
                    }
                    f3 = f2;
                    windowInsets3 = windowInsets2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i102 = i3 << 3;
                    m2734DrawerSheetvywBR7E(windowInsets3, companion, shape2, j3, j4, f3, function3, startRestartGroup, ((i3 >> 15) & 14) | (i102 & 112) | (i102 & 896) | (i102 & 7168) | (57344 & i102) | (i102 & 458752) | (i3 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    f2 = f3;
                    windowInsets2 = windowInsets3;
                    shape3 = shape2;
                    modifier2 = companion;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    shape3 = shape2;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier3 = modifier2;
                    final long j5 = j3;
                    final long j6 = j4;
                    final float f4 = f2;
                    final WindowInsets windowInsets4 = windowInsets2;
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalDrawerSheet$1
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
                            NavigationDrawerKt.m2735ModalDrawerSheetafqeVBk(Modifier.this, shape3, j5, j6, f4, windowInsets4, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                    return;
                }
                return;
            }
            if ((599187 & i3) == 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i8 != 0) {
            }
            if ((i2 & 2) != 0) {
            }
            if ((i2 & 4) != 0) {
            }
            if ((i2 & 8) != 0) {
            }
            if (i9 != 0) {
            }
            if ((i2 & 32) != 0) {
            }
            f3 = f2;
            windowInsets3 = windowInsets2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i1022 = i3 << 3;
            m2734DrawerSheetvywBR7E(windowInsets3, companion, shape2, j3, j4, f3, function3, startRestartGroup, ((i3 >> 15) & 14) | (i1022 & 112) | (i1022 & 896) | (i1022 & 7168) | (57344 & i1022) | (i1022 & 458752) | (i3 & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            f2 = f3;
            windowInsets2 = windowInsets3;
            shape3 = shape2;
            modifier2 = companion;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        f2 = f;
        if ((196608 & i) != 0) {
        }
        if ((i2 & 64) == 0) {
        }
        if ((599187 & i3) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i8 != 0) {
        }
        if ((i2 & 2) != 0) {
        }
        if ((i2 & 4) != 0) {
        }
        if ((i2 & 8) != 0) {
        }
        if (i9 != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        f3 = f2;
        windowInsets3 = windowInsets2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i10222 = i3 << 3;
        m2734DrawerSheetvywBR7E(windowInsets3, companion, shape2, j3, j4, f3, function3, startRestartGroup, ((i3 >> 15) & 14) | (i10222 & 112) | (i10222 & 896) | (i10222 & 7168) | (57344 & i10222) | (i10222 & 458752) | (i3 & 3670016), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        f2 = f3;
        windowInsets2 = windowInsets3;
        shape3 = shape2;
        modifier2 = companion;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0085  */
    /* renamed from: DismissibleDrawerSheet-afqeVBk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2733DismissibleDrawerSheetafqeVBk(Modifier modifier, Shape shape, long j, long j2, float f, WindowInsets windowInsets, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Shape shape2;
        long j3;
        long j4;
        int i4;
        float f2;
        WindowInsets windowInsets2;
        Modifier.Companion companion;
        WindowInsets windowInsets3;
        int i5;
        long j5;
        float f3;
        Modifier modifier2;
        final float f4;
        final WindowInsets windowInsets4;
        final long j6;
        ScopeUpdateScope endRestartGroup;
        int i6;
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(-588600583);
        ComposerKt.sourceInformation(startRestartGroup, "C(DismissibleDrawerSheet)P(5,3,1:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,6)566@21732L14,567@21780L37,569@21941L12,572@22011L183:NavigationDrawer.kt#uh7d8r");
        int i8 = i2 & 1;
        if (i8 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i9 = i2 & 2;
        if (i9 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            shape2 = shape;
            i3 |= startRestartGroup.changed(shape2) ? 32 : 16;
            if ((i & 384) != 0) {
                if ((i2 & 4) == 0) {
                    j3 = j;
                    if (startRestartGroup.changed(j3)) {
                        i7 = Fields.RotationX;
                        i3 |= i7;
                    }
                } else {
                    j3 = j;
                }
                i7 = Fields.SpotShadowColor;
                i3 |= i7;
            } else {
                j3 = j;
            }
            if ((i & 3072) != 0) {
                j4 = j2;
                i3 |= ((i2 & 8) == 0 && startRestartGroup.changed(j4)) ? Fields.CameraDistance : Fields.RotationZ;
            } else {
                j4 = j2;
            }
            i4 = i2 & 16;
            if (i4 == 0) {
                i3 |= 24576;
            } else if ((i & 24576) == 0) {
                f2 = f;
                i3 |= startRestartGroup.changed(f2) ? Fields.Clip : Fields.Shape;
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
                            companion = i8 == 0 ? Modifier.INSTANCE : modifier;
                            if (i9 != 0) {
                                shape2 = RectangleShapeKt.getRectangleShape();
                            }
                            if ((i2 & 4) != 0) {
                                j3 = DrawerDefaults.INSTANCE.getContainerColor(startRestartGroup, 6);
                                i3 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                j4 = ColorSchemeKt.m2381contentColorForek8zF_U(j3, startRestartGroup, (i3 >> 6) & 14);
                                i3 &= -7169;
                            }
                            if (i4 != 0) {
                                f2 = DrawerDefaults.INSTANCE.m2546getDismissibleDrawerElevationD9Ej5fM();
                            }
                            if ((i2 & 32) != 0) {
                                windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(startRestartGroup, 6);
                                i5 = i3 & (-458753);
                                j5 = j4;
                                f3 = f2;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-588600583, i5, -1, "androidx.compose.material3.DismissibleDrawerSheet (NavigationDrawer.kt:571)");
                                }
                                int i10 = i5 << 3;
                                m2734DrawerSheetvywBR7E(windowInsets3, companion, shape2, j3, j5, f3, function3, startRestartGroup, ((i5 >> 15) & 14) | (i10 & 112) | (i10 & 896) | (i10 & 7168) | (57344 & i10) | (i10 & 458752) | (i5 & 3670016), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                j4 = j5;
                                modifier2 = companion;
                                long j7 = j3;
                                f4 = f3;
                                windowInsets4 = windowInsets3;
                                j6 = j7;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            companion = modifier;
                        }
                        i5 = i3;
                        j5 = j4;
                        f3 = f2;
                        windowInsets3 = windowInsets2;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i102 = i5 << 3;
                        m2734DrawerSheetvywBR7E(windowInsets3, companion, shape2, j3, j5, f3, function3, startRestartGroup, ((i5 >> 15) & 14) | (i102 & 112) | (i102 & 896) | (i102 & 7168) | (57344 & i102) | (i102 & 458752) | (i5 & 3670016), 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        j4 = j5;
                        modifier2 = companion;
                        long j72 = j3;
                        f4 = f3;
                        windowInsets4 = windowInsets3;
                        j6 = j72;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        modifier2 = modifier;
                        j6 = j3;
                        f4 = f2;
                        windowInsets4 = windowInsets2;
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        final Modifier modifier3 = modifier2;
                        final Shape shape3 = shape2;
                        final long j8 = j4;
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleDrawerSheet$1
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
                                NavigationDrawerKt.m2733DismissibleDrawerSheetafqeVBk(Modifier.this, shape3, j6, j8, f4, windowInsets4, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
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
                if (i8 == 0) {
                }
                if (i9 != 0) {
                }
                if ((i2 & 4) != 0) {
                }
                if ((i2 & 8) != 0) {
                }
                if (i4 != 0) {
                }
                if ((i2 & 32) != 0) {
                }
                i5 = i3;
                j5 = j4;
                f3 = f2;
                windowInsets3 = windowInsets2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i1022 = i5 << 3;
                m2734DrawerSheetvywBR7E(windowInsets3, companion, shape2, j3, j5, f3, function3, startRestartGroup, ((i5 >> 15) & 14) | (i1022 & 112) | (i1022 & 896) | (i1022 & 7168) | (57344 & i1022) | (i1022 & 458752) | (i5 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                j4 = j5;
                modifier2 = companion;
                long j722 = j3;
                f4 = f3;
                windowInsets4 = windowInsets3;
                j6 = j722;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            f2 = f;
            if ((196608 & i) == 0) {
            }
            if ((i2 & 64) != 0) {
            }
            if ((i3 & 599187) == 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i8 == 0) {
            }
            if (i9 != 0) {
            }
            if ((i2 & 4) != 0) {
            }
            if ((i2 & 8) != 0) {
            }
            if (i4 != 0) {
            }
            if ((i2 & 32) != 0) {
            }
            i5 = i3;
            j5 = j4;
            f3 = f2;
            windowInsets3 = windowInsets2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i10222 = i5 << 3;
            m2734DrawerSheetvywBR7E(windowInsets3, companion, shape2, j3, j5, f3, function3, startRestartGroup, ((i5 >> 15) & 14) | (i10222 & 112) | (i10222 & 896) | (i10222 & 7168) | (57344 & i10222) | (i10222 & 458752) | (i5 & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            j4 = j5;
            modifier2 = companion;
            long j7222 = j3;
            f4 = f3;
            windowInsets4 = windowInsets3;
            j6 = j7222;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        shape2 = shape;
        if ((i & 384) != 0) {
        }
        if ((i & 3072) != 0) {
        }
        i4 = i2 & 16;
        if (i4 == 0) {
        }
        f2 = f;
        if ((196608 & i) == 0) {
        }
        if ((i2 & 64) != 0) {
        }
        if ((i3 & 599187) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i8 == 0) {
        }
        if (i9 != 0) {
        }
        if ((i2 & 4) != 0) {
        }
        if ((i2 & 8) != 0) {
        }
        if (i4 != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        i5 = i3;
        j5 = j4;
        f3 = f2;
        windowInsets3 = windowInsets2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i102222 = i5 << 3;
        m2734DrawerSheetvywBR7E(windowInsets3, companion, shape2, j3, j5, f3, function3, startRestartGroup, ((i5 >> 15) & 14) | (i102222 & 112) | (i102222 & 896) | (i102222 & 7168) | (57344 & i102222) | (i102222 & 458752) | (i5 & 3670016), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        j4 = j5;
        modifier2 = companion;
        long j72222 = j3;
        f4 = f3;
        windowInsets4 = windowInsets3;
        j6 = j72222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00bf  */
    /* renamed from: PermanentDrawerSheet-afqeVBk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2737PermanentDrawerSheetafqeVBk(Modifier modifier, Shape shape, long j, long j2, float f, WindowInsets windowInsets, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Shape shape2;
        long j3;
        long j4;
        int i4;
        float f2;
        WindowInsets windowInsets2;
        Modifier.Companion companion;
        WindowInsets windowInsets3;
        int i5;
        long j5;
        float f3;
        boolean changed;
        Object rememberedValue;
        Modifier modifier2;
        final float f4;
        final WindowInsets windowInsets4;
        final long j6;
        ScopeUpdateScope endRestartGroup;
        int i6;
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(-1733353241);
        ComposerKt.sourceInformation(startRestartGroup, "C(PermanentDrawerSheet)P(5,3,1:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,6)603@23356L14,604@23404L37,606@23563L12,609@23654L33,612@23754L50,610@23692L244:NavigationDrawer.kt#uh7d8r");
        int i8 = i2 & 1;
        if (i8 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i9 = i2 & 2;
        if (i9 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            shape2 = shape;
            i3 |= startRestartGroup.changed(shape2) ? 32 : 16;
            if ((i & 384) != 0) {
                if ((i2 & 4) == 0) {
                    j3 = j;
                    if (startRestartGroup.changed(j3)) {
                        i7 = Fields.RotationX;
                        i3 |= i7;
                    }
                } else {
                    j3 = j;
                }
                i7 = Fields.SpotShadowColor;
                i3 |= i7;
            } else {
                j3 = j;
            }
            if ((i & 3072) != 0) {
                j4 = j2;
                i3 |= ((i2 & 8) == 0 && startRestartGroup.changed(j4)) ? Fields.CameraDistance : Fields.RotationZ;
            } else {
                j4 = j2;
            }
            i4 = i2 & 16;
            if (i4 == 0) {
                i3 |= 24576;
            } else if ((i & 24576) == 0) {
                f2 = f;
                i3 |= startRestartGroup.changed(f2) ? Fields.Clip : Fields.Shape;
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
                            companion = i8 == 0 ? Modifier.INSTANCE : modifier;
                            if (i9 != 0) {
                                shape2 = RectangleShapeKt.getRectangleShape();
                            }
                            if ((i2 & 4) != 0) {
                                j3 = DrawerDefaults.INSTANCE.getContainerColor(startRestartGroup, 6);
                                i3 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                j4 = ColorSchemeKt.m2381contentColorForek8zF_U(j3, startRestartGroup, (i3 >> 6) & 14);
                                i3 &= -7169;
                            }
                            if (i4 != 0) {
                                f2 = DrawerDefaults.INSTANCE.m2549getPermanentDrawerElevationD9Ej5fM();
                            }
                            if ((i2 & 32) != 0) {
                                windowInsets3 = DrawerDefaults.INSTANCE.getWindowInsets(startRestartGroup, 6);
                                i5 = i3 & (-458753);
                                j5 = j4;
                                f3 = f2;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1733353241, i5, -1, "androidx.compose.material3.PermanentDrawerSheet (NavigationDrawer.kt:608)");
                                }
                                Strings.Companion companion2 = Strings.INSTANCE;
                                final String m3033getStringNWtq28 = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0754R.string.navigation_menu), startRestartGroup, 0);
                                startRestartGroup.startReplaceableGroup(705343847);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
                                changed = startRestartGroup.changed(m3033getStringNWtq28);
                                rememberedValue = startRestartGroup.rememberedValue();
                                if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$PermanentDrawerSheet$1$1
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
                                            SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, m3033getStringNWtq28);
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                startRestartGroup.endReplaceableGroup();
                                int i10 = i5 << 3;
                                m2734DrawerSheetvywBR7E(windowInsets3, SemanticsModifierKt.semantics$default(companion, false, (Function1) rememberedValue, 1, (Object) null), shape2, j3, j5, f3, function3, startRestartGroup, ((i5 >> 15) & 14) | (i10 & 896) | (i10 & 7168) | (57344 & i10) | (i10 & 458752) | (i5 & 3670016), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                j4 = j5;
                                modifier2 = companion;
                                long j7 = j3;
                                f4 = f3;
                                windowInsets4 = windowInsets3;
                                j6 = j7;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            companion = modifier;
                        }
                        i5 = i3;
                        j5 = j4;
                        f3 = f2;
                        windowInsets3 = windowInsets2;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        Strings.Companion companion22 = Strings.INSTANCE;
                        final String m3033getStringNWtq282 = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0754R.string.navigation_menu), startRestartGroup, 0);
                        startRestartGroup.startReplaceableGroup(705343847);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
                        changed = startRestartGroup.changed(m3033getStringNWtq282);
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (!changed) {
                        }
                        rememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$PermanentDrawerSheet$1$1
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
                                SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, m3033getStringNWtq282);
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue);
                        startRestartGroup.endReplaceableGroup();
                        int i102 = i5 << 3;
                        m2734DrawerSheetvywBR7E(windowInsets3, SemanticsModifierKt.semantics$default(companion, false, (Function1) rememberedValue, 1, (Object) null), shape2, j3, j5, f3, function3, startRestartGroup, ((i5 >> 15) & 14) | (i102 & 896) | (i102 & 7168) | (57344 & i102) | (i102 & 458752) | (i5 & 3670016), 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        j4 = j5;
                        modifier2 = companion;
                        long j72 = j3;
                        f4 = f3;
                        windowInsets4 = windowInsets3;
                        j6 = j72;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        modifier2 = modifier;
                        j6 = j3;
                        f4 = f2;
                        windowInsets4 = windowInsets2;
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        final Modifier modifier3 = modifier2;
                        final Shape shape3 = shape2;
                        final long j8 = j4;
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$PermanentDrawerSheet$2
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
                                NavigationDrawerKt.m2737PermanentDrawerSheetafqeVBk(Modifier.this, shape3, j6, j8, f4, windowInsets4, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
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
                if (i8 == 0) {
                }
                if (i9 != 0) {
                }
                if ((i2 & 4) != 0) {
                }
                if ((i2 & 8) != 0) {
                }
                if (i4 != 0) {
                }
                if ((i2 & 32) != 0) {
                }
                i5 = i3;
                j5 = j4;
                f3 = f2;
                windowInsets3 = windowInsets2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                Strings.Companion companion222 = Strings.INSTANCE;
                final String m3033getStringNWtq2822 = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0754R.string.navigation_menu), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(705343847);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
                changed = startRestartGroup.changed(m3033getStringNWtq2822);
                rememberedValue = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                rememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$PermanentDrawerSheet$1$1
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
                        SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, m3033getStringNWtq2822);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
                startRestartGroup.endReplaceableGroup();
                int i1022 = i5 << 3;
                m2734DrawerSheetvywBR7E(windowInsets3, SemanticsModifierKt.semantics$default(companion, false, (Function1) rememberedValue, 1, (Object) null), shape2, j3, j5, f3, function3, startRestartGroup, ((i5 >> 15) & 14) | (i1022 & 896) | (i1022 & 7168) | (57344 & i1022) | (i1022 & 458752) | (i5 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                j4 = j5;
                modifier2 = companion;
                long j722 = j3;
                f4 = f3;
                windowInsets4 = windowInsets3;
                j6 = j722;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            f2 = f;
            if ((196608 & i) == 0) {
            }
            if ((i2 & 64) != 0) {
            }
            if ((i3 & 599187) == 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i8 == 0) {
            }
            if (i9 != 0) {
            }
            if ((i2 & 4) != 0) {
            }
            if ((i2 & 8) != 0) {
            }
            if (i4 != 0) {
            }
            if ((i2 & 32) != 0) {
            }
            i5 = i3;
            j5 = j4;
            f3 = f2;
            windowInsets3 = windowInsets2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            Strings.Companion companion2222 = Strings.INSTANCE;
            final String m3033getStringNWtq28222 = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0754R.string.navigation_menu), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(705343847);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
            changed = startRestartGroup.changed(m3033getStringNWtq28222);
            rememberedValue = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$PermanentDrawerSheet$1$1
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
                    SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, m3033getStringNWtq28222);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceableGroup();
            int i10222 = i5 << 3;
            m2734DrawerSheetvywBR7E(windowInsets3, SemanticsModifierKt.semantics$default(companion, false, (Function1) rememberedValue, 1, (Object) null), shape2, j3, j5, f3, function3, startRestartGroup, ((i5 >> 15) & 14) | (i10222 & 896) | (i10222 & 7168) | (57344 & i10222) | (i10222 & 458752) | (i5 & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            j4 = j5;
            modifier2 = companion;
            long j7222 = j3;
            f4 = f3;
            windowInsets4 = windowInsets3;
            j6 = j7222;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        shape2 = shape;
        if ((i & 384) != 0) {
        }
        if ((i & 3072) != 0) {
        }
        i4 = i2 & 16;
        if (i4 == 0) {
        }
        f2 = f;
        if ((196608 & i) == 0) {
        }
        if ((i2 & 64) != 0) {
        }
        if ((i3 & 599187) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i8 == 0) {
        }
        if (i9 != 0) {
        }
        if ((i2 & 4) != 0) {
        }
        if ((i2 & 8) != 0) {
        }
        if (i4 != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        i5 = i3;
        j5 = j4;
        f3 = f2;
        windowInsets3 = windowInsets2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        Strings.Companion companion22222 = Strings.INSTANCE;
        final String m3033getStringNWtq282222 = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0754R.string.navigation_menu), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(705343847);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
        changed = startRestartGroup.changed(m3033getStringNWtq282222);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$PermanentDrawerSheet$1$1
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
                SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, m3033getStringNWtq282222);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceableGroup();
        int i102222 = i5 << 3;
        m2734DrawerSheetvywBR7E(windowInsets3, SemanticsModifierKt.semantics$default(companion, false, (Function1) rememberedValue, 1, (Object) null), shape2, j3, j5, f3, function3, startRestartGroup, ((i5 >> 15) & 14) | (i102222 & 896) | (i102222 & 7168) | (57344 & i102222) | (i102222 & 458752) | (i5 & 3670016), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        j4 = j5;
        modifier2 = companion;
        long j72222 = j3;
        f4 = f3;
        windowInsets4 = windowInsets3;
        j6 = j72222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:100:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x007a  */
    /* renamed from: DrawerSheet-vywBR7E, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2734DrawerSheetvywBR7E(final WindowInsets windowInsets, Modifier modifier, Shape shape, long j, long j2, float f, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        Shape shape2;
        long j3;
        long j4;
        int i5;
        float f2;
        Modifier.Companion companion;
        Shape rectangleShape;
        long j5;
        long j6;
        long j7;
        float m2549getPermanentDrawerElevationD9Ej5fM;
        Modifier modifier2;
        final float f3;
        Composer startRestartGroup = composer.startRestartGroup(175072821);
        ComposerKt.sourceInformation(startRestartGroup, "C(DrawerSheet)P(6,5,3,1:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp)628@24134L14,629@24182L37,633@24349L667:NavigationDrawer.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(windowInsets) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i6 = i2 & 2;
        if (i6 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                shape2 = shape;
                i3 |= startRestartGroup.changed(shape2) ? Fields.RotationX : Fields.SpotShadowColor;
                if ((i & 3072) == 0) {
                    j3 = j;
                    i3 |= ((i2 & 8) == 0 && startRestartGroup.changed(j3)) ? Fields.CameraDistance : Fields.RotationZ;
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
                    if ((i2 & 64) == 0) {
                        i3 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        i3 |= startRestartGroup.changedInstance(function3) ? 1048576 : Fields.BlendMode;
                    }
                    if ((i3 & 599187) == 599186 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            companion = i6 == 0 ? Modifier.INSTANCE : modifier;
                            rectangleShape = i4 == 0 ? RectangleShapeKt.getRectangleShape() : shape2;
                            if ((i2 & 8) == 0) {
                                j5 = DrawerDefaults.INSTANCE.getContainerColor(startRestartGroup, 6);
                                i3 &= -7169;
                            } else {
                                j5 = j3;
                            }
                            if ((i2 & 16) == 0) {
                                j6 = ColorSchemeKt.m2381contentColorForek8zF_U(j5, startRestartGroup, (i3 >> 9) & 14);
                                i3 &= -57345;
                            } else {
                                j6 = j4;
                            }
                            if (i5 == 0) {
                                m2549getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m2549getPermanentDrawerElevationD9Ej5fM();
                                j7 = j6;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(175072821, i3, -1, "androidx.compose.material3.DrawerSheet (NavigationDrawer.kt:632)");
                                }
                                int i7 = i3 >> 3;
                                SurfaceKt.m3043SurfaceT9BRK9s(SizeKt.fillMaxHeight$default(SizeKt.m1124sizeInqDBjuR0$default(companion, MinimumDrawerWidth, 0.0f, DrawerDefaults.INSTANCE.m2547getMaximumDrawerWidthD9Ej5fM(), 0.0f, 10, null), 0.0f, 1, null), rectangleShape, j5, j7, m2549getPermanentDrawerElevationD9Ej5fM, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, 959363152, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DrawerSheet$1
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

                                    public final void invoke(Composer composer2, int i8) {
                                        float f4;
                                        ComposerKt.sourceInformation(composer2, "C645@24731L279:NavigationDrawer.kt#uh7d8r");
                                        if ((i8 & 3) != 2 || !composer2.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(959363152, i8, -1, "androidx.compose.material3.DrawerSheet.<anonymous> (NavigationDrawer.kt:645)");
                                            }
                                            Modifier.Companion companion2 = Modifier.INSTANCE;
                                            f4 = NavigationDrawerKt.MinimumDrawerWidth;
                                            Modifier windowInsetsPadding = WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.m1124sizeInqDBjuR0$default(companion2, f4, 0.0f, DrawerDefaults.INSTANCE.m2547getMaximumDrawerWidthD9Ej5fM(), 0.0f, 10, null), WindowInsets.this);
                                            Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                                            composer2.startReplaceableGroup(-483455358);
                                            ComposerKt.sourceInformation(composer2, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
                                            composer2.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                            Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(windowInsetsPadding);
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
                                            Updater.m4116setimpl(m4109constructorimpl, columnMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                            Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                            if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                            }
                                            modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer2)), composer2, 0);
                                            composer2.startReplaceableGroup(2058660585);
                                            ComposerKt.sourceInformationMarkerStart(composer2, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                            function32.invoke(ColumnScopeInstance.INSTANCE, composer2, 6);
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
                                }), startRestartGroup, (i7 & 112) | 12582912 | (i7 & 896) | (i7 & 7168) | (i7 & 57344), 96);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier2 = companion;
                                f3 = m2549getPermanentDrawerElevationD9Ej5fM;
                            } else {
                                j7 = j6;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            companion = modifier;
                            rectangleShape = shape2;
                            j5 = j3;
                            j7 = j4;
                        }
                        m2549getPermanentDrawerElevationD9Ej5fM = f2;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i72 = i3 >> 3;
                        SurfaceKt.m3043SurfaceT9BRK9s(SizeKt.fillMaxHeight$default(SizeKt.m1124sizeInqDBjuR0$default(companion, MinimumDrawerWidth, 0.0f, DrawerDefaults.INSTANCE.m2547getMaximumDrawerWidthD9Ej5fM(), 0.0f, 10, null), 0.0f, 1, null), rectangleShape, j5, j7, m2549getPermanentDrawerElevationD9Ej5fM, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, 959363152, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DrawerSheet$1
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

                            public final void invoke(Composer composer2, int i8) {
                                float f4;
                                ComposerKt.sourceInformation(composer2, "C645@24731L279:NavigationDrawer.kt#uh7d8r");
                                if ((i8 & 3) != 2 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(959363152, i8, -1, "androidx.compose.material3.DrawerSheet.<anonymous> (NavigationDrawer.kt:645)");
                                    }
                                    Modifier.Companion companion2 = Modifier.INSTANCE;
                                    f4 = NavigationDrawerKt.MinimumDrawerWidth;
                                    Modifier windowInsetsPadding = WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.m1124sizeInqDBjuR0$default(companion2, f4, 0.0f, DrawerDefaults.INSTANCE.m2547getMaximumDrawerWidthD9Ej5fM(), 0.0f, 10, null), WindowInsets.this);
                                    Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                                    composer2.startReplaceableGroup(-483455358);
                                    ComposerKt.sourceInformation(composer2, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
                                    composer2.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                    Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(windowInsetsPadding);
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
                                    Updater.m4116setimpl(m4109constructorimpl, columnMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                    Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                    Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                    if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer2)), composer2, 0);
                                    composer2.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer2, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                    function32.invoke(ColumnScopeInstance.INSTANCE, composer2, 6);
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
                        }), startRestartGroup, (i72 & 112) | 12582912 | (i72 & 896) | (i72 & 7168) | (i72 & 57344), 96);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier2 = companion;
                        f3 = m2549getPermanentDrawerElevationD9Ej5fM;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        modifier2 = modifier;
                        rectangleShape = shape2;
                        j5 = j3;
                        j7 = j4;
                        f3 = f2;
                    }
                    ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                        final Modifier modifier3 = modifier2;
                        final Shape shape3 = rectangleShape;
                        final long j8 = j5;
                        final long j9 = j7;
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$DrawerSheet$2
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

                            public final void invoke(Composer composer2, int i8) {
                                NavigationDrawerKt.m2734DrawerSheetvywBR7E(WindowInsets.this, modifier3, shape3, j8, j9, f3, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                f2 = f;
                if ((i2 & 64) == 0) {
                }
                if ((i3 & 599187) == 599186) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i6 == 0) {
                }
                if (i4 == 0) {
                }
                if ((i2 & 8) == 0) {
                }
                if ((i2 & 16) == 0) {
                }
                if (i5 == 0) {
                }
            }
            shape2 = shape;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            f2 = f;
            if ((i2 & 64) == 0) {
            }
            if ((i3 & 599187) == 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i6 == 0) {
            }
            if (i4 == 0) {
            }
            if ((i2 & 8) == 0) {
            }
            if ((i2 & 16) == 0) {
            }
            if (i5 == 0) {
            }
        }
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        shape2 = shape;
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        f2 = f;
        if ((i2 & 64) == 0) {
        }
        if ((i3 & 599187) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i6 == 0) {
        }
        if (i4 == 0) {
        }
        if ((i2 & 8) == 0) {
        }
        if ((i2 & 16) == 0) {
        }
        if (i5 == 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00f9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void NavigationDrawerItem(final Function2<? super Composer, ? super Integer, Unit> function2, final boolean z, final Function0<Unit> function0, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, NavigationDrawerItemColors navigationDrawerItemColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        int i5;
        Function2<? super Composer, ? super Integer, Unit> function24;
        Shape shape2;
        NavigationDrawerItemColors navigationDrawerItemColors2;
        int i6;
        Shape shape3;
        NavigationDrawerItemColors navigationDrawerItemColors3;
        MutableInteractionSource mutableInteractionSource2;
        int i7;
        Modifier modifier2;
        Function2<? super Composer, ? super Integer, Unit> function25;
        Shape shape4;
        Function2<? super Composer, ? super Integer, Unit> function26;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        final Function2<? super Composer, ? super Integer, Unit> function28;
        final Shape shape5;
        final MutableInteractionSource mutableInteractionSource3;
        final NavigationDrawerItemColors navigationDrawerItemColors4;
        final Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        int i8;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(-1304626543);
        ComposerKt.sourceInformation(startRestartGroup, "C(NavigationDrawerItem)P(4,7,6,5,2!1,8)729@28081L5,730@28158L8,731@28218L39,741@28543L24,733@28266L1246:NavigationDrawer.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changedInstance(function0) ? Fields.RotationX : Fields.SpotShadowColor;
        }
        int i10 = i2 & 8;
        if (i10 != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? Fields.CameraDistance : Fields.RotationZ;
            i4 = i2 & 16;
            if (i4 == 0) {
                i3 |= 24576;
            } else if ((i & 24576) == 0) {
                i3 |= startRestartGroup.changedInstance(function22) ? Fields.Clip : Fields.Shape;
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= 196608;
                } else if ((196608 & i) == 0) {
                    function24 = function23;
                    i3 |= startRestartGroup.changedInstance(function24) ? Fields.RenderEffect : 65536;
                    if ((1572864 & i) != 0) {
                        if ((i2 & 64) == 0) {
                            shape2 = shape;
                            if (startRestartGroup.changed(shape2)) {
                                i9 = 1048576;
                                i3 |= i9;
                            }
                        } else {
                            shape2 = shape;
                        }
                        i9 = Fields.BlendMode;
                        i3 |= i9;
                    } else {
                        shape2 = shape;
                    }
                    if ((12582912 & i) != 0) {
                        if ((i2 & Fields.SpotShadowColor) == 0) {
                            navigationDrawerItemColors2 = navigationDrawerItemColors;
                            if (startRestartGroup.changed(navigationDrawerItemColors2)) {
                                i8 = 8388608;
                                i3 |= i8;
                            }
                        } else {
                            navigationDrawerItemColors2 = navigationDrawerItemColors;
                        }
                        i8 = 4194304;
                        i3 |= i8;
                    } else {
                        navigationDrawerItemColors2 = navigationDrawerItemColors;
                    }
                    i6 = i2 & Fields.RotationX;
                    if (i6 == 0) {
                        i3 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        i3 |= startRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                    }
                    if ((i3 & 38347923) == 38347922 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            Modifier.Companion companion = i10 == 0 ? Modifier.INSTANCE : modifier;
                            Function2<? super Composer, ? super Integer, Unit> function29 = i4 == 0 ? null : function22;
                            if (i5 != 0) {
                                function24 = null;
                            }
                            if ((i2 & 64) == 0) {
                                shape3 = ShapesKt.getValue(NavigationDrawerTokens.INSTANCE.getActiveIndicatorShape(), startRestartGroup, 6);
                                i3 &= -3670017;
                            } else {
                                shape3 = shape2;
                            }
                            if ((i2 & Fields.SpotShadowColor) == 0) {
                                navigationDrawerItemColors3 = NavigationDrawerItemDefaults.INSTANCE.m2732colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, startRestartGroup, 100663296, PartialGapBuffer.BUF_SIZE);
                                i3 &= -29360129;
                            } else {
                                navigationDrawerItemColors3 = navigationDrawerItemColors2;
                            }
                            if (i6 == 0) {
                                startRestartGroup.startReplaceableGroup(111536735);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
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
                            i7 = i3;
                            modifier2 = companion;
                            function25 = function29;
                            shape4 = shape3;
                            navigationDrawerItemColors2 = navigationDrawerItemColors3;
                            function26 = function24;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                            }
                            if ((i2 & Fields.SpotShadowColor) != 0) {
                                i3 &= -29360129;
                            }
                            modifier2 = modifier;
                            function25 = function22;
                            mutableInteractionSource2 = mutableInteractionSource;
                            function26 = function24;
                            shape4 = shape2;
                            i7 = i3;
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1304626543, i7, -1, "androidx.compose.material3.NavigationDrawerItem (NavigationDrawer.kt:732)");
                        }
                        int i11 = i7 >> 3;
                        int i12 = i11 & 14;
                        int i13 = i7;
                        final Function2<? super Composer, ? super Integer, Unit> function210 = function25;
                        final NavigationDrawerItemColors navigationDrawerItemColors5 = navigationDrawerItemColors2;
                        final Function2<? super Composer, ? super Integer, Unit> function211 = function26;
                        int i14 = i12 | (i11 & 112) | ((i13 >> 6) & 57344);
                        NavigationDrawerItemColors navigationDrawerItemColors6 = navigationDrawerItemColors2;
                        int i15 = ((i13 >> 24) & 14) | 48;
                        Modifier modifier4 = modifier2;
                        composer2 = startRestartGroup;
                        SurfaceKt.m3044Surfaced85dljk(z, function0, SizeKt.fillMaxWidth$default(SizeKt.m1106height3ABfNKs(SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$NavigationDrawerItem$2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((SemanticsPropertyReceiver) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, Role.Companion.getTab-o7Vup1c());
                            }
                        }, 1, (Object) null), NavigationDrawerTokens.INSTANCE.m3726getActiveIndicatorHeightD9Ej5fM()), 0.0f, 1, null), false, shape4, navigationDrawerItemColors2.containerColor(z, startRestartGroup, i12 | ((i7 >> 18) & 112)).getValue().m4849unboximpl(), 0L, 0.0f, 0.0f, (BorderStroke) null, mutableInteractionSource2, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(startRestartGroup, 191488423, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$NavigationDrawerItem$3
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

                            public final void invoke(Composer composer3, int i16) {
                                ComposerKt.sourceInformation(composer3, "C744@28638L868:NavigationDrawer.kt#uh7d8r");
                                if ((i16 & 3) != 2 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(191488423, i16, -1, "androidx.compose.material3.NavigationDrawerItem.<anonymous> (NavigationDrawer.kt:744)");
                                    }
                                    Modifier m1068paddingqDBjuR0$default = PaddingKt.m1068paddingqDBjuR0$default(Modifier.INSTANCE, Dp.constructor-impl(16), 0.0f, Dp.constructor-impl(24), 0.0f, 10, null);
                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                    Function2<Composer, Integer, Unit> function212 = function210;
                                    NavigationDrawerItemColors navigationDrawerItemColors7 = navigationDrawerItemColors5;
                                    boolean z2 = z;
                                    Function2<Composer, Integer, Unit> function213 = function211;
                                    Function2<Composer, Integer, Unit> function214 = function2;
                                    composer3.startReplaceableGroup(693286680);
                                    ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer3, 48);
                                    composer3.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                    Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m1068paddingqDBjuR0$default);
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
                                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer3, -1538529193, "C753@29036L203:NavigationDrawer.kt#uh7d8r");
                                    composer3.startReplaceableGroup(-1538529193);
                                    ComposerKt.sourceInformation(composer3, "749@28843L19,750@28885L78,751@28980L29");
                                    if (function212 != null) {
                                        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4829boximpl(navigationDrawerItemColors7.iconColor(z2, composer3, 0).getValue().m4849unboximpl())), function212, composer3, ProvidedValue.$stable | 0);
                                        SpacerKt.Spacer(SizeKt.m1125width3ABfNKs(Modifier.INSTANCE, Dp.constructor-impl(12)), composer3, 6);
                                    }
                                    composer3.endReplaceableGroup();
                                    Modifier weight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                                    composer3.startReplaceableGroup(733328855);
                                    ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                                    composer3.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                    CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                    Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(weight$default);
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
                                    Updater.m4116setimpl(m4109constructorimpl2, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                    Updater.m4116setimpl(m4109constructorimpl2, currentCompositionLocalMap2, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                    Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                    if (m4109constructorimpl2.getInserting() || !Intrinsics.areEqual(m4109constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                        m4109constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                        m4109constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                    }
                                    modifierMaterializerOf2.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer3)), composer3, 0);
                                    composer3.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer3, 1694714143, "C754@29103L19,755@29145L80:NavigationDrawer.kt#uh7d8r");
                                    CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4829boximpl(navigationDrawerItemColors7.textColor(z2, composer3, 0).getValue().m4849unboximpl())), function214, composer3, ProvidedValue.$stable | 0);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    composer3.endReplaceableGroup();
                                    composer3.endNode();
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                    composer3.startReplaceableGroup(-533536502);
                                    ComposerKt.sourceInformation(composer3, "758@29289L29,759@29359L20,760@29402L80");
                                    if (function213 != null) {
                                        SpacerKt.Spacer(SizeKt.m1125width3ABfNKs(Modifier.INSTANCE, Dp.constructor-impl(12)), composer3, 6);
                                        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4829boximpl(navigationDrawerItemColors7.badgeColor(z2, composer3, 0).getValue().m4849unboximpl())), function213, composer3, ProvidedValue.$stable | 0);
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
                        }), composer2, i14, i15, 968);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function27 = function25;
                        function28 = function26;
                        shape5 = shape4;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        navigationDrawerItemColors4 = navigationDrawerItemColors6;
                        modifier3 = modifier4;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        modifier3 = modifier;
                        function27 = function22;
                        composer2 = startRestartGroup;
                        function28 = function24;
                        shape5 = shape2;
                        navigationDrawerItemColors4 = navigationDrawerItemColors2;
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$NavigationDrawerItem$4
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

                            public final void invoke(Composer composer3, int i16) {
                                NavigationDrawerKt.NavigationDrawerItem(function2, z, function0, modifier3, function27, function28, shape5, navigationDrawerItemColors4, mutableInteractionSource3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                function24 = function23;
                if ((1572864 & i) != 0) {
                }
                if ((12582912 & i) != 0) {
                }
                i6 = i2 & Fields.RotationX;
                if (i6 == 0) {
                }
                if ((i3 & 38347923) == 38347922) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i10 == 0) {
                }
                if (i4 == 0) {
                }
                if (i5 != 0) {
                }
                if ((i2 & 64) == 0) {
                }
                if ((i2 & Fields.SpotShadowColor) == 0) {
                }
                if (i6 == 0) {
                }
                i7 = i3;
                modifier2 = companion;
                function25 = function29;
                shape4 = shape3;
                navigationDrawerItemColors2 = navigationDrawerItemColors3;
                function26 = function24;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i112 = i7 >> 3;
                int i122 = i112 & 14;
                int i132 = i7;
                final Function2<? super Composer, ? super Integer, Unit> function2102 = function25;
                final NavigationDrawerItemColors navigationDrawerItemColors52 = navigationDrawerItemColors2;
                final Function2<? super Composer, ? super Integer, Unit> function2112 = function26;
                int i142 = i122 | (i112 & 112) | ((i132 >> 6) & 57344);
                NavigationDrawerItemColors navigationDrawerItemColors62 = navigationDrawerItemColors2;
                int i152 = ((i132 >> 24) & 14) | 48;
                Modifier modifier42 = modifier2;
                composer2 = startRestartGroup;
                SurfaceKt.m3044Surfaced85dljk(z, function0, SizeKt.fillMaxWidth$default(SizeKt.m1106height3ABfNKs(SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$NavigationDrawerItem$2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((SemanticsPropertyReceiver) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, Role.Companion.getTab-o7Vup1c());
                    }
                }, 1, (Object) null), NavigationDrawerTokens.INSTANCE.m3726getActiveIndicatorHeightD9Ej5fM()), 0.0f, 1, null), false, shape4, navigationDrawerItemColors2.containerColor(z, startRestartGroup, i122 | ((i7 >> 18) & 112)).getValue().m4849unboximpl(), 0L, 0.0f, 0.0f, (BorderStroke) null, mutableInteractionSource2, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(startRestartGroup, 191488423, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$NavigationDrawerItem$3
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

                    public final void invoke(Composer composer3, int i16) {
                        ComposerKt.sourceInformation(composer3, "C744@28638L868:NavigationDrawer.kt#uh7d8r");
                        if ((i16 & 3) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(191488423, i16, -1, "androidx.compose.material3.NavigationDrawerItem.<anonymous> (NavigationDrawer.kt:744)");
                            }
                            Modifier m1068paddingqDBjuR0$default = PaddingKt.m1068paddingqDBjuR0$default(Modifier.INSTANCE, Dp.constructor-impl(16), 0.0f, Dp.constructor-impl(24), 0.0f, 10, null);
                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                            Function2<Composer, Integer, Unit> function212 = function2102;
                            NavigationDrawerItemColors navigationDrawerItemColors7 = navigationDrawerItemColors52;
                            boolean z2 = z;
                            Function2<Composer, Integer, Unit> function213 = function2112;
                            Function2<Composer, Integer, Unit> function214 = function2;
                            composer3.startReplaceableGroup(693286680);
                            ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer3, 48);
                            composer3.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                            Function0 constructor = ComposeUiNode.Companion.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m1068paddingqDBjuR0$default);
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
                            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer3, -1538529193, "C753@29036L203:NavigationDrawer.kt#uh7d8r");
                            composer3.startReplaceableGroup(-1538529193);
                            ComposerKt.sourceInformation(composer3, "749@28843L19,750@28885L78,751@28980L29");
                            if (function212 != null) {
                                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4829boximpl(navigationDrawerItemColors7.iconColor(z2, composer3, 0).getValue().m4849unboximpl())), function212, composer3, ProvidedValue.$stable | 0);
                                SpacerKt.Spacer(SizeKt.m1125width3ABfNKs(Modifier.INSTANCE, Dp.constructor-impl(12)), composer3, 6);
                            }
                            composer3.endReplaceableGroup();
                            Modifier weight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                            composer3.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                            composer3.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                            CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(weight$default);
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
                            Updater.m4116setimpl(m4109constructorimpl2, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.m4116setimpl(m4109constructorimpl2, currentCompositionLocalMap2, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (m4109constructorimpl2.getInserting() || !Intrinsics.areEqual(m4109constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                m4109constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                m4109constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                            }
                            modifierMaterializerOf2.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer3)), composer3, 0);
                            composer3.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer3, 1694714143, "C754@29103L19,755@29145L80:NavigationDrawer.kt#uh7d8r");
                            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4829boximpl(navigationDrawerItemColors7.textColor(z2, composer3, 0).getValue().m4849unboximpl())), function214, composer3, ProvidedValue.$stable | 0);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endReplaceableGroup();
                            composer3.endNode();
                            composer3.endReplaceableGroup();
                            composer3.endReplaceableGroup();
                            composer3.startReplaceableGroup(-533536502);
                            ComposerKt.sourceInformation(composer3, "758@29289L29,759@29359L20,760@29402L80");
                            if (function213 != null) {
                                SpacerKt.Spacer(SizeKt.m1125width3ABfNKs(Modifier.INSTANCE, Dp.constructor-impl(12)), composer3, 6);
                                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4829boximpl(navigationDrawerItemColors7.badgeColor(z2, composer3, 0).getValue().m4849unboximpl())), function213, composer3, ProvidedValue.$stable | 0);
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
                }), composer2, i142, i152, 968);
                if (ComposerKt.isTraceInProgress()) {
                }
                function27 = function25;
                function28 = function26;
                shape5 = shape4;
                mutableInteractionSource3 = mutableInteractionSource2;
                navigationDrawerItemColors4 = navigationDrawerItemColors62;
                modifier3 = modifier42;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            function24 = function23;
            if ((1572864 & i) != 0) {
            }
            if ((12582912 & i) != 0) {
            }
            i6 = i2 & Fields.RotationX;
            if (i6 == 0) {
            }
            if ((i3 & 38347923) == 38347922) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i10 == 0) {
            }
            if (i4 == 0) {
            }
            if (i5 != 0) {
            }
            if ((i2 & 64) == 0) {
            }
            if ((i2 & Fields.SpotShadowColor) == 0) {
            }
            if (i6 == 0) {
            }
            i7 = i3;
            modifier2 = companion;
            function25 = function29;
            shape4 = shape3;
            navigationDrawerItemColors2 = navigationDrawerItemColors3;
            function26 = function24;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i1122 = i7 >> 3;
            int i1222 = i1122 & 14;
            int i1322 = i7;
            final Function2<? super Composer, ? super Integer, Unit> function21022 = function25;
            final NavigationDrawerItemColors navigationDrawerItemColors522 = navigationDrawerItemColors2;
            final Function2<? super Composer, ? super Integer, Unit> function21122 = function26;
            int i1422 = i1222 | (i1122 & 112) | ((i1322 >> 6) & 57344);
            NavigationDrawerItemColors navigationDrawerItemColors622 = navigationDrawerItemColors2;
            int i1522 = ((i1322 >> 24) & 14) | 48;
            Modifier modifier422 = modifier2;
            composer2 = startRestartGroup;
            SurfaceKt.m3044Surfaced85dljk(z, function0, SizeKt.fillMaxWidth$default(SizeKt.m1106height3ABfNKs(SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$NavigationDrawerItem$2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((SemanticsPropertyReceiver) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, Role.Companion.getTab-o7Vup1c());
                }
            }, 1, (Object) null), NavigationDrawerTokens.INSTANCE.m3726getActiveIndicatorHeightD9Ej5fM()), 0.0f, 1, null), false, shape4, navigationDrawerItemColors2.containerColor(z, startRestartGroup, i1222 | ((i7 >> 18) & 112)).getValue().m4849unboximpl(), 0L, 0.0f, 0.0f, (BorderStroke) null, mutableInteractionSource2, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(startRestartGroup, 191488423, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$NavigationDrawerItem$3
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

                public final void invoke(Composer composer3, int i16) {
                    ComposerKt.sourceInformation(composer3, "C744@28638L868:NavigationDrawer.kt#uh7d8r");
                    if ((i16 & 3) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(191488423, i16, -1, "androidx.compose.material3.NavigationDrawerItem.<anonymous> (NavigationDrawer.kt:744)");
                        }
                        Modifier m1068paddingqDBjuR0$default = PaddingKt.m1068paddingqDBjuR0$default(Modifier.INSTANCE, Dp.constructor-impl(16), 0.0f, Dp.constructor-impl(24), 0.0f, 10, null);
                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                        Function2<Composer, Integer, Unit> function212 = function21022;
                        NavigationDrawerItemColors navigationDrawerItemColors7 = navigationDrawerItemColors522;
                        boolean z2 = z;
                        Function2<Composer, Integer, Unit> function213 = function21122;
                        Function2<Composer, Integer, Unit> function214 = function2;
                        composer3.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer3, 48);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                        Function0 constructor = ComposeUiNode.Companion.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m1068paddingqDBjuR0$default);
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
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer3, -1538529193, "C753@29036L203:NavigationDrawer.kt#uh7d8r");
                        composer3.startReplaceableGroup(-1538529193);
                        ComposerKt.sourceInformation(composer3, "749@28843L19,750@28885L78,751@28980L29");
                        if (function212 != null) {
                            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4829boximpl(navigationDrawerItemColors7.iconColor(z2, composer3, 0).getValue().m4849unboximpl())), function212, composer3, ProvidedValue.$stable | 0);
                            SpacerKt.Spacer(SizeKt.m1125width3ABfNKs(Modifier.INSTANCE, Dp.constructor-impl(12)), composer3, 6);
                        }
                        composer3.endReplaceableGroup();
                        Modifier weight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                        composer3.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                        Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(weight$default);
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
                        Updater.m4116setimpl(m4109constructorimpl2, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m4116setimpl(m4109constructorimpl2, currentCompositionLocalMap2, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (m4109constructorimpl2.getInserting() || !Intrinsics.areEqual(m4109constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            m4109constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            m4109constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                        }
                        modifierMaterializerOf2.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer3)), composer3, 0);
                        composer3.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer3, 1694714143, "C754@29103L19,755@29145L80:NavigationDrawer.kt#uh7d8r");
                        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4829boximpl(navigationDrawerItemColors7.textColor(z2, composer3, 0).getValue().m4849unboximpl())), function214, composer3, ProvidedValue.$stable | 0);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceableGroup();
                        composer3.endNode();
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        composer3.startReplaceableGroup(-533536502);
                        ComposerKt.sourceInformation(composer3, "758@29289L29,759@29359L20,760@29402L80");
                        if (function213 != null) {
                            SpacerKt.Spacer(SizeKt.m1125width3ABfNKs(Modifier.INSTANCE, Dp.constructor-impl(12)), composer3, 6);
                            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4829boximpl(navigationDrawerItemColors7.badgeColor(z2, composer3, 0).getValue().m4849unboximpl())), function213, composer3, ProvidedValue.$stable | 0);
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
            }), composer2, i1422, i1522, 968);
            if (ComposerKt.isTraceInProgress()) {
            }
            function27 = function25;
            function28 = function26;
            shape5 = shape4;
            mutableInteractionSource3 = mutableInteractionSource2;
            navigationDrawerItemColors4 = navigationDrawerItemColors622;
            modifier3 = modifier422;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i4 = i2 & 16;
        if (i4 == 0) {
        }
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        function24 = function23;
        if ((1572864 & i) != 0) {
        }
        if ((12582912 & i) != 0) {
        }
        i6 = i2 & Fields.RotationX;
        if (i6 == 0) {
        }
        if ((i3 & 38347923) == 38347922) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i10 == 0) {
        }
        if (i4 == 0) {
        }
        if (i5 != 0) {
        }
        if ((i2 & 64) == 0) {
        }
        if ((i2 & Fields.SpotShadowColor) == 0) {
        }
        if (i6 == 0) {
        }
        i7 = i3;
        modifier2 = companion;
        function25 = function29;
        shape4 = shape3;
        navigationDrawerItemColors2 = navigationDrawerItemColors3;
        function26 = function24;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i11222 = i7 >> 3;
        int i12222 = i11222 & 14;
        int i13222 = i7;
        final Function2<? super Composer, ? super Integer, Unit> function210222 = function25;
        final NavigationDrawerItemColors navigationDrawerItemColors5222 = navigationDrawerItemColors2;
        final Function2<? super Composer, ? super Integer, Unit> function211222 = function26;
        int i14222 = i12222 | (i11222 & 112) | ((i13222 >> 6) & 57344);
        NavigationDrawerItemColors navigationDrawerItemColors6222 = navigationDrawerItemColors2;
        int i15222 = ((i13222 >> 24) & 14) | 48;
        Modifier modifier4222 = modifier2;
        composer2 = startRestartGroup;
        SurfaceKt.m3044Surfaced85dljk(z, function0, SizeKt.fillMaxWidth$default(SizeKt.m1106height3ABfNKs(SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$NavigationDrawerItem$2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SemanticsPropertyReceiver) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, Role.Companion.getTab-o7Vup1c());
            }
        }, 1, (Object) null), NavigationDrawerTokens.INSTANCE.m3726getActiveIndicatorHeightD9Ej5fM()), 0.0f, 1, null), false, shape4, navigationDrawerItemColors2.containerColor(z, startRestartGroup, i12222 | ((i7 >> 18) & 112)).getValue().m4849unboximpl(), 0L, 0.0f, 0.0f, (BorderStroke) null, mutableInteractionSource2, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(startRestartGroup, 191488423, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$NavigationDrawerItem$3
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

            public final void invoke(Composer composer3, int i16) {
                ComposerKt.sourceInformation(composer3, "C744@28638L868:NavigationDrawer.kt#uh7d8r");
                if ((i16 & 3) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(191488423, i16, -1, "androidx.compose.material3.NavigationDrawerItem.<anonymous> (NavigationDrawer.kt:744)");
                    }
                    Modifier m1068paddingqDBjuR0$default = PaddingKt.m1068paddingqDBjuR0$default(Modifier.INSTANCE, Dp.constructor-impl(16), 0.0f, Dp.constructor-impl(24), 0.0f, 10, null);
                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                    Function2<Composer, Integer, Unit> function212 = function210222;
                    NavigationDrawerItemColors navigationDrawerItemColors7 = navigationDrawerItemColors5222;
                    boolean z2 = z;
                    Function2<Composer, Integer, Unit> function213 = function211222;
                    Function2<Composer, Integer, Unit> function214 = function2;
                    composer3.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composer3, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer3, 48);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                    Function0 constructor = ComposeUiNode.Companion.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m1068paddingqDBjuR0$default);
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
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer3, -1538529193, "C753@29036L203:NavigationDrawer.kt#uh7d8r");
                    composer3.startReplaceableGroup(-1538529193);
                    ComposerKt.sourceInformation(composer3, "749@28843L19,750@28885L78,751@28980L29");
                    if (function212 != null) {
                        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4829boximpl(navigationDrawerItemColors7.iconColor(z2, composer3, 0).getValue().m4849unboximpl())), function212, composer3, ProvidedValue.$stable | 0);
                        SpacerKt.Spacer(SizeKt.m1125width3ABfNKs(Modifier.INSTANCE, Dp.constructor-impl(12)), composer3, 6);
                    }
                    composer3.endReplaceableGroup();
                    Modifier weight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                    composer3.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer3, 0);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                    Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(weight$default);
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
                    Updater.m4116setimpl(m4109constructorimpl2, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m4116setimpl(m4109constructorimpl2, currentCompositionLocalMap2, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (m4109constructorimpl2.getInserting() || !Intrinsics.areEqual(m4109constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        m4109constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        m4109constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    modifierMaterializerOf2.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer3)), composer3, 0);
                    composer3.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer3, 1694714143, "C754@29103L19,755@29145L80:NavigationDrawer.kt#uh7d8r");
                    CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4829boximpl(navigationDrawerItemColors7.textColor(z2, composer3, 0).getValue().m4849unboximpl())), function214, composer3, ProvidedValue.$stable | 0);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceableGroup();
                    composer3.endNode();
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    composer3.startReplaceableGroup(-533536502);
                    ComposerKt.sourceInformation(composer3, "758@29289L29,759@29359L20,760@29402L80");
                    if (function213 != null) {
                        SpacerKt.Spacer(SizeKt.m1125width3ABfNKs(Modifier.INSTANCE, Dp.constructor-impl(12)), composer3, 6);
                        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4829boximpl(navigationDrawerItemColors7.badgeColor(z2, composer3, 0).getValue().m4849unboximpl())), function213, composer3, ProvidedValue.$stable | 0);
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
        }), composer2, i14222, i15222, 968);
        if (ComposerKt.isTraceInProgress()) {
        }
        function27 = function25;
        function28 = function26;
        shape5 = shape4;
        mutableInteractionSource3 = mutableInteractionSource2;
        navigationDrawerItemColors4 = navigationDrawerItemColors6222;
        modifier3 = modifier4222;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float calculateFraction(float f, float f2, float f3) {
        return RangesKt.coerceIn((f3 - f) / (f2 - f), 0.0f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Scrim-Bx497Mc, reason: not valid java name */
    public static final void m2738ScrimBx497Mc(final boolean z, final Function0<Unit> function0, final Function0<Float> function02, final long j, Composer composer, final int i) {
        int i2;
        int i3;
        Modifier.Companion companion;
        Modifier then;
        Composer startRestartGroup = composer.startRestartGroup(2106487387);
        ComposerKt.sourceInformation(startRestartGroup, "C(Scrim)P(3,2,1,0:c#ui.graphics.Color)919@35520L30,935@35964L51,931@35873L142:NavigationDrawer.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function02) ? Fields.RotationX : Fields.SpotShadowColor;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changed(j) ? Fields.CameraDistance : Fields.RotationZ;
        }
        if ((i2 & 1171) != 1170 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2106487387, i2, -1, "androidx.compose.material3.Scrim (NavigationDrawer.kt:918)");
            }
            Strings.Companion companion2 = Strings.INSTANCE;
            final String m3033getStringNWtq28 = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0754R.string.close_drawer), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1858700652);
            ComposerKt.sourceInformation(startRestartGroup, "922@35639L35,923@35723L108");
            if (z) {
                Modifier.Companion companion3 = Modifier.INSTANCE;
                startRestartGroup.startReplaceableGroup(-1858700588);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
                int i4 = i2 & 112;
                boolean z2 = i4 == 32;
                NavigationDrawerKt$Scrim$dismissDrawer$1$1 rememberedValue = startRestartGroup.rememberedValue();
                if (z2 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new NavigationDrawerKt$Scrim$dismissDrawer$1$1(function0, null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceableGroup();
                then = companion3.then((Modifier) new SuspendPointerInputElement(function0, null, null, new C0769xe3d9cdbd((Function2) rememberedValue), 6, null));
                startRestartGroup.startReplaceableGroup(-1858700504);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
                boolean changed = (i4 == 32) | startRestartGroup.changed(m3033getStringNWtq28);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$Scrim$dismissDrawer$2$1
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
                            final Function0<Unit> function03 = function0;
                            SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, (String) null, new Function0<Boolean>() { // from class: androidx.compose.material3.NavigationDrawerKt$Scrim$dismissDrawer$2$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                public final Boolean m2749invoke() {
                                    function03.invoke();
                                    return true;
                                }
                            }, 1, (Object) null);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceableGroup();
                i3 = 1;
                companion = SemanticsModifierKt.semantics(then, true, (Function1) rememberedValue2);
            } else {
                i3 = 1;
                companion = Modifier.INSTANCE;
            }
            startRestartGroup.endReplaceableGroup();
            Modifier then2 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, i3, null).then(companion);
            startRestartGroup.startReplaceableGroup(-1858700263);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationDrawer.kt#9igjgp");
            int i5 = ((i2 & 7168) == 2048 ? i3 : 0) | ((i2 & 896) == 256 ? i3 : 0);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (i5 != 0 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$Scrim$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((DrawScope) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(DrawScope drawScope) {
                        DrawScope.m5411drawRectnJ9OG0$default(drawScope, j, 0L, 0L, ((Number) function02.invoke()).floatValue(), null, null, 0, 118, null);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceableGroup();
            CanvasKt.Canvas(then2, (Function1) rememberedValue3, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationDrawerKt$Scrim$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i6) {
                    NavigationDrawerKt.m2738ScrimBx497Mc(z, function0, function02, j, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
