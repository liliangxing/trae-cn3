package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteractionKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.material3.tokens.SwitchTokens;
import androidx.compose.p002ui.Alignment;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.graphics.Color;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.graphics.Shape;
import androidx.compose.p002ui.layout.LayoutKt;
import androidx.compose.p002ui.layout.MeasurePolicy;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: Switch.kt */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aj\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0007¢\u0006\u0002\u0010\u001e\u001ay\u0010\u001f\u001a\u00020\u000f*\u00020 2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\"2\u0013\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0006\u0010\u001c\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0004H\u0003ø\u0001\u0000¢\u0006\u0004\b)\u0010*\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0016\u0010\u0007\u001a\u00020\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\b\u0010\t\"\u0010\u0010\n\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u000b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0016\u0010\f\u001a\u00020\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\r\u0010\t\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006+²\u0006\n\u0010,\u001a\u00020\u0011X\u008a\u0084\u0002"}, d2 = {"AnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "SwitchHeight", "Landroidx/compose/ui/unit/Dp;", "F", "SwitchWidth", "ThumbDiameter", "getThumbDiameter", "()F", "ThumbPadding", "ThumbPathLength", "UncheckedThumbDiameter", "getUncheckedThumbDiameter", "Switch", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "thumbContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "enabled", "colors", "Landroidx/compose/material3/SwitchColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/SwitchColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "SwitchImpl", "Landroidx/compose/foundation/layout/BoxScope;", "thumbValue", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/interaction/InteractionSource;", "thumbShape", "Landroidx/compose/ui/graphics/Shape;", "uncheckedThumbDiameter", "minBound", "maxBound", "SwitchImpl-0DmnUew", "(Landroidx/compose/foundation/layout/BoxScope;ZZLandroidx/compose/material3/SwitchColors;Landroidx/compose/runtime/State;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/ui/graphics/Shape;FFFLandroidx/compose/runtime/Composer;II)V", "material3_release", "isPressed"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class SwitchKt {
    private static final TweenSpec<Float> AnimationSpec;
    private static final float SwitchHeight;
    private static final float SwitchWidth;
    private static final float ThumbDiameter;
    private static final float ThumbPadding;
    private static final float ThumbPathLength;
    private static final float UncheckedThumbDiameter;

    /* JADX WARN: Removed duplicated region for block: B:101:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0454  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x030e  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x036f  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x037b  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x03a4  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0445  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x037f  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0226  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Switch(final boolean z, final Function1<? super Boolean, Unit> function1, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, boolean z2, SwitchColors switchColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        final Modifier modifier2;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function22;
        int i5;
        boolean z3;
        SwitchColors switchColors2;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        Function2<? super Composer, ? super Integer, Unit> function23;
        boolean z4;
        SwitchColors switchColors3;
        MutableInteractionSource mutableInteractionSource3;
        Modifier modifier3;
        boolean changed;
        Object rememberedValue;
        final float floatValue;
        Object rememberedValue2;
        final Animatable animatable;
        Object rememberedValue3;
        boolean changedInstance;
        Object rememberedValue4;
        boolean changedInstance2;
        Object rememberedValue5;
        Animatable animatable2;
        float f;
        Object obj;
        Modifier.Companion companion;
        int currentCompositeKeyHash;
        Composer m4109constructorimpl;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        final boolean z5;
        final SwitchColors switchColors4;
        ScopeUpdateScope endRestartGroup;
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(1580463220);
        ComposerKt.sourceInformation(startRestartGroup, "C(Switch)P(!1,5,4,6,2)96@4481L8,97@4541L39,*106@4829L7,107@4904L7,108@4964L111,113@5139L36,114@5192L24,116@5233L145,116@5222L156,121@5410L190,121@5384L216,145@6060L844:Switch.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i8 = i2 & 4;
        if (i8 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? Fields.RotationX : Fields.SpotShadowColor;
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                function22 = function2;
                i3 |= startRestartGroup.changedInstance(function22) ? Fields.CameraDistance : Fields.RotationZ;
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    z3 = z2;
                    i3 |= startRestartGroup.changed(z3) ? Fields.Clip : Fields.Shape;
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            switchColors2 = switchColors;
                            if (startRestartGroup.changed(switchColors2)) {
                                i7 = Fields.RenderEffect;
                                i3 |= i7;
                            }
                        } else {
                            switchColors2 = switchColors;
                        }
                        i7 = 65536;
                        i3 |= i7;
                    } else {
                        switchColors2 = switchColors;
                    }
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                    } else if ((1572864 & i) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        i3 |= startRestartGroup.changed(mutableInteractionSource2) ? 1048576 : Fields.BlendMode;
                        if ((i3 & 599187) == 599186 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion2 = i8 != 0 ? Modifier.INSTANCE : modifier;
                                if (i4 != 0) {
                                    function22 = null;
                                }
                                if (i5 != 0) {
                                    z3 = true;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                    switchColors2 = SwitchDefaults.INSTANCE.colors(startRestartGroup, 6);
                                }
                                if (i6 != 0) {
                                    startRestartGroup.startReplaceableGroup(-1221651002);
                                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Switch.kt#9igjgp");
                                    Object rememberedValue6 = startRestartGroup.rememberedValue();
                                    if (rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue6 = InteractionSourceKt.MutableInteractionSource();
                                        startRestartGroup.updateRememberedValue(rememberedValue6);
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    modifier3 = companion2;
                                    mutableInteractionSource3 = (MutableInteractionSource) rememberedValue6;
                                    function23 = function22;
                                    z4 = z3;
                                    switchColors3 = switchColors2;
                                } else {
                                    function23 = function22;
                                    z4 = z3;
                                    switchColors3 = switchColors2;
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                    modifier3 = companion2;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                }
                                function23 = function22;
                                z4 = z3;
                                switchColors3 = switchColors2;
                                mutableInteractionSource3 = mutableInteractionSource2;
                                modifier3 = modifier;
                            }
                            int i9 = i3;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1580463220, i9, -1, "androidx.compose.material3.Switch (Switch.kt:98)");
                            }
                            float f2 = function23 == null ? UncheckedThumbDiameter : ThumbDiameter;
                            float f3 = SwitchHeight;
                            float f4 = Dp.constructor-impl(Dp.constructor-impl(f3 - f2) / 2);
                            ProvidableCompositionLocal localDensity = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume = startRestartGroup.consume(localDensity);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            final float f5 = ((Density) consume).toPx-0680j_4(f4);
                            ProvidableCompositionLocal localDensity2 = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume2 = startRestartGroup.consume(localDensity2);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            float f6 = ThumbPathLength;
                            final float f7 = ((Density) consume2).toPx-0680j_4(f6);
                            startRestartGroup.startReplaceableGroup(-1221650579);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Switch.kt#9igjgp");
                            changed = startRestartGroup.changed(f5) | startRestartGroup.changed(f7);
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = (Function1) new Function1<Boolean, Float>() { // from class: androidx.compose.material3.SwitchKt$Switch$valueToOffset$1$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    public final Float invoke(boolean z6) {
                                        return Float.valueOf(z6 ? f7 : f5);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                        return invoke(((Boolean) obj2).booleanValue());
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            startRestartGroup.endReplaceableGroup();
                            floatValue = ((Number) ((Function1) rememberedValue).invoke(Boolean.valueOf(z))).floatValue();
                            startRestartGroup.startReplaceableGroup(-1221650404);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Switch.kt#9igjgp");
                            rememberedValue2 = startRestartGroup.rememberedValue();
                            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue2 = AnimatableKt.Animatable$default(floatValue, 0.0f, 2, null);
                                startRestartGroup.updateRememberedValue(rememberedValue2);
                            }
                            animatable = (Animatable) rememberedValue2;
                            startRestartGroup.endReplaceableGroup();
                            startRestartGroup.startReplaceableGroup(773894976);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                            startRestartGroup.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                            rememberedValue3 = startRestartGroup.rememberedValue();
                            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                                startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                                rememberedValue3 = compositionScopedCoroutineScopeCanceller;
                            }
                            startRestartGroup.endReplaceableGroup();
                            final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue3).getCoroutineScope();
                            startRestartGroup.endReplaceableGroup();
                            startRestartGroup.startReplaceableGroup(-1221650310);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Switch.kt#9igjgp");
                            changedInstance = startRestartGroup.changedInstance(animatable) | startRestartGroup.changed(f5);
                            rememberedValue4 = startRestartGroup.rememberedValue();
                            if (!changedInstance || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue4 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.SwitchKt$Switch$2$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke() {
                                        m3082invoke();
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: collision with other method in class */
                                    public final void m3082invoke() {
                                        Animatable.updateBounds$default(animatable, Float.valueOf(f5), null, 2, null);
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue4);
                            }
                            startRestartGroup.endReplaceableGroup();
                            EffectsKt.SideEffect((Function0) rememberedValue4, startRestartGroup, 0);
                            Boolean valueOf = Boolean.valueOf(z);
                            startRestartGroup.startReplaceableGroup(-1221650133);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Switch.kt#9igjgp");
                            changedInstance2 = startRestartGroup.changedInstance(animatable) | startRestartGroup.changed(floatValue) | startRestartGroup.changedInstance(coroutineScope);
                            rememberedValue5 = startRestartGroup.rememberedValue();
                            if (!changedInstance2 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue5 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.material3.SwitchKt$Switch$3$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* compiled from: Switch.kt */
                                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                    @DebugMetadata(c = "androidx.compose.material3.SwitchKt$Switch$3$1$1", f = "Switch.kt", i = {}, l = {125}, m = "invokeSuspend", n = {}, s = {})
                                    /* renamed from: androidx.compose.material3.SwitchKt$Switch$3$1$1 */
                                    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
                                    public static final class C07071 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                        final /* synthetic */ Animatable<Float, AnimationVector1D> $offset;
                                        final /* synthetic */ float $targetValue;
                                        int label;

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        C07071(Animatable<Float, AnimationVector1D> animatable, float f, Continuation<? super C07071> continuation) {
                                            super(2, continuation);
                                            this.$offset = animatable;
                                            this.$targetValue = f;
                                        }

                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                            return new C07071(this.$offset, this.$targetValue, continuation);
                                        }

                                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                                        }

                                        public final Object invokeSuspend(Object obj) {
                                            TweenSpec tweenSpec;
                                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                            int i = this.label;
                                            if (i == 0) {
                                                ResultKt.throwOnFailure(obj);
                                                Animatable<Float, AnimationVector1D> animatable = this.$offset;
                                                Float boxFloat = Boxing.boxFloat(this.$targetValue);
                                                tweenSpec = SwitchKt.AnimationSpec;
                                                this.label = 1;
                                                if (Animatable.animateTo$default(animatable, boxFloat, tweenSpec, null, null, (Continuation) this, 12, null) == coroutine_suspended) {
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

                                    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                        if (!(animatable.getTargetValue().floatValue() == floatValue)) {
                                            BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new C07071(animatable, floatValue, null), 3, (Object) null);
                                        }
                                        return new DisposableEffectResult() { // from class: androidx.compose.material3.SwitchKt$Switch$3$1$invoke$$inlined$onDispose$1
                                            @Override // androidx.compose.runtime.DisposableEffectResult
                                            public void dispose() {
                                            }
                                        };
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue5);
                            }
                            startRestartGroup.endReplaceableGroup();
                            EffectsKt.DisposableEffect(valueOf, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue5, startRestartGroup, i9 & 14);
                            if (function1 != null) {
                                obj = null;
                                animatable2 = animatable;
                                f = f6;
                                companion = ToggleableKt.m1440toggleableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource3, null, z4, Role.box-impl(Role.Companion.getSwitch-o7Vup1c()), function1);
                            } else {
                                animatable2 = animatable;
                                f = f6;
                                obj = null;
                                companion = Modifier.INSTANCE;
                            }
                            Modifier m1114requiredSizeVpY3zN4 = SizeKt.m1114requiredSizeVpY3zN4(SizeKt.wrapContentSize$default(modifier3.then(function1 != null ? InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE) : Modifier.INSTANCE).then(companion), Alignment.INSTANCE.getCenter(), false, 2, obj), SwitchWidth, f3);
                            startRestartGroup.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                            startRestartGroup.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                            Function0 constructor = ComposeUiNode.Companion.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m1114requiredSizeVpY3zN4);
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
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1873061411, "C164@6698L5,158@6451L447:Switch.kt#uh7d8r");
                            int i10 = i9 >> 6;
                            int i11 = 6 | ((i9 << 3) & 112) | (i10 & 896) | (i10 & 7168) | ((i9 << 6) & 458752) | (3670016 & i9);
                            modifier2 = modifier3;
                            composer2 = startRestartGroup;
                            m3080SwitchImpl0DmnUew(boxScopeInstance, z, z4, switchColors3, animatable2.asState(), function23, mutableInteractionSource3, ShapesKt.getValue(SwitchTokens.INSTANCE.getHandleShape(), startRestartGroup, 6), f2, f4, f, composer2, i11, 6);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function24 = function23;
                            z5 = z4;
                            switchColors4 = switchColors3;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            function24 = function22;
                            z5 = z3;
                            switchColors4 = switchColors2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            composer2 = startRestartGroup;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            final MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource3;
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SwitchKt$Switch$5
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

                                public final void invoke(Composer composer3, int i12) {
                                    SwitchKt.Switch(z, function1, modifier2, function24, z5, switchColors4, mutableInteractionSource4, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    mutableInteractionSource2 = mutableInteractionSource;
                    if ((i3 & 599187) == 599186) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if ((i2 & 32) != 0) {
                    }
                    if (i6 != 0) {
                    }
                    int i92 = i3;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    float f22 = function23 == null ? UncheckedThumbDiameter : ThumbDiameter;
                    float f32 = SwitchHeight;
                    float f42 = Dp.constructor-impl(Dp.constructor-impl(f32 - f22) / 2);
                    ProvidableCompositionLocal localDensity3 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume3 = startRestartGroup.consume(localDensity3);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    final float f52 = ((Density) consume3).toPx-0680j_4(f42);
                    ProvidableCompositionLocal localDensity22 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume22 = startRestartGroup.consume(localDensity22);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    float f62 = ThumbPathLength;
                    final float f72 = ((Density) consume22).toPx-0680j_4(f62);
                    startRestartGroup.startReplaceableGroup(-1221650579);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Switch.kt#9igjgp");
                    changed = startRestartGroup.changed(f52) | startRestartGroup.changed(f72);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!changed) {
                    }
                    rememberedValue = (Function1) new Function1<Boolean, Float>() { // from class: androidx.compose.material3.SwitchKt$Switch$valueToOffset$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public final Float invoke(boolean z6) {
                            return Float.valueOf(z6 ? f72 : f52);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                            return invoke(((Boolean) obj2).booleanValue());
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                    startRestartGroup.endReplaceableGroup();
                    floatValue = ((Number) ((Function1) rememberedValue).invoke(Boolean.valueOf(z))).floatValue();
                    startRestartGroup.startReplaceableGroup(-1221650404);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Switch.kt#9igjgp");
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    }
                    animatable = (Animatable) rememberedValue2;
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.startReplaceableGroup(773894976);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                    startRestartGroup.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                    rememberedValue3 = startRestartGroup.rememberedValue();
                    if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    final CoroutineScope coroutineScope2 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue3).getCoroutineScope();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.startReplaceableGroup(-1221650310);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Switch.kt#9igjgp");
                    changedInstance = startRestartGroup.changedInstance(animatable) | startRestartGroup.changed(f52);
                    rememberedValue4 = startRestartGroup.rememberedValue();
                    if (!changedInstance) {
                    }
                    rememberedValue4 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.SwitchKt$Switch$2$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m3082invoke();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: collision with other method in class */
                        public final void m3082invoke() {
                            Animatable.updateBounds$default(animatable, Float.valueOf(f52), null, 2, null);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                    startRestartGroup.endReplaceableGroup();
                    EffectsKt.SideEffect((Function0) rememberedValue4, startRestartGroup, 0);
                    Boolean valueOf2 = Boolean.valueOf(z);
                    startRestartGroup.startReplaceableGroup(-1221650133);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Switch.kt#9igjgp");
                    changedInstance2 = startRestartGroup.changedInstance(animatable) | startRestartGroup.changed(floatValue) | startRestartGroup.changedInstance(coroutineScope2);
                    rememberedValue5 = startRestartGroup.rememberedValue();
                    if (!changedInstance2) {
                    }
                    rememberedValue5 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.material3.SwitchKt$Switch$3$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* compiled from: Switch.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                        @DebugMetadata(c = "androidx.compose.material3.SwitchKt$Switch$3$1$1", f = "Switch.kt", i = {}, l = {125}, m = "invokeSuspend", n = {}, s = {})
                        /* renamed from: androidx.compose.material3.SwitchKt$Switch$3$1$1 */
                        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
                        public static final class C07071 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ Animatable<Float, AnimationVector1D> $offset;
                            final /* synthetic */ float $targetValue;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            C07071(Animatable<Float, AnimationVector1D> animatable, float f, Continuation<? super C07071> continuation) {
                                super(2, continuation);
                                this.$offset = animatable;
                                this.$targetValue = f;
                            }

                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new C07071(this.$offset, this.$targetValue, continuation);
                            }

                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                            }

                            public final Object invokeSuspend(Object obj) {
                                TweenSpec tweenSpec;
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                int i = this.label;
                                if (i == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    Animatable<Float, AnimationVector1D> animatable = this.$offset;
                                    Float boxFloat = Boxing.boxFloat(this.$targetValue);
                                    tweenSpec = SwitchKt.AnimationSpec;
                                    this.label = 1;
                                    if (Animatable.animateTo$default(animatable, boxFloat, tweenSpec, null, null, (Continuation) this, 12, null) == coroutine_suspended) {
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

                        public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                            if (!(animatable.getTargetValue().floatValue() == floatValue)) {
                                BuildersKt.launch$default(coroutineScope2, (CoroutineContext) null, (CoroutineStart) null, new C07071(animatable, floatValue, null), 3, (Object) null);
                            }
                            return new DisposableEffectResult() { // from class: androidx.compose.material3.SwitchKt$Switch$3$1$invoke$$inlined$onDispose$1
                                @Override // androidx.compose.runtime.DisposableEffectResult
                                public void dispose() {
                                }
                            };
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                    startRestartGroup.endReplaceableGroup();
                    EffectsKt.DisposableEffect(valueOf2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue5, startRestartGroup, i92 & 14);
                    if (function1 != null) {
                    }
                    Modifier m1114requiredSizeVpY3zN42 = SizeKt.m1114requiredSizeVpY3zN4(SizeKt.wrapContentSize$default(modifier3.then(function1 != null ? InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE) : Modifier.INSTANCE).then(companion), Alignment.INSTANCE.getCenter(), false, 2, obj), SwitchWidth, f32);
                    startRestartGroup.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                    MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                    Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m1114requiredSizeVpY3zN42);
                    if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                    }
                    m4109constructorimpl = Updater.m4109constructorimpl(startRestartGroup);
                    Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy2, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap2, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (!m4109constructorimpl.getInserting()) {
                    }
                    m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
                    modifierMaterializerOf2.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1873061411, "C164@6698L5,158@6451L447:Switch.kt#uh7d8r");
                    int i102 = i92 >> 6;
                    int i112 = 6 | ((i92 << 3) & 112) | (i102 & 896) | (i102 & 7168) | ((i92 << 6) & 458752) | (3670016 & i92);
                    modifier2 = modifier3;
                    composer2 = startRestartGroup;
                    m3080SwitchImpl0DmnUew(boxScopeInstance2, z, z4, switchColors3, animatable2.asState(), function23, mutableInteractionSource3, ShapesKt.getValue(SwitchTokens.INSTANCE.getHandleShape(), startRestartGroup, 6), f22, f42, f, composer2, i112, 6);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    function24 = function23;
                    z5 = z4;
                    switchColors4 = switchColors3;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                z3 = z2;
                if ((196608 & i) != 0) {
                }
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i3 & 599187) == 599186) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i8 != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if ((i2 & 32) != 0) {
                }
                if (i6 != 0) {
                }
                int i922 = i3;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                float f222 = function23 == null ? UncheckedThumbDiameter : ThumbDiameter;
                float f322 = SwitchHeight;
                float f422 = Dp.constructor-impl(Dp.constructor-impl(f322 - f222) / 2);
                ProvidableCompositionLocal localDensity32 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume32 = startRestartGroup.consume(localDensity32);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                final float f522 = ((Density) consume32).toPx-0680j_4(f422);
                ProvidableCompositionLocal localDensity222 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume222 = startRestartGroup.consume(localDensity222);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                float f622 = ThumbPathLength;
                final float f722 = ((Density) consume222).toPx-0680j_4(f622);
                startRestartGroup.startReplaceableGroup(-1221650579);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Switch.kt#9igjgp");
                changed = startRestartGroup.changed(f522) | startRestartGroup.changed(f722);
                rememberedValue = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                rememberedValue = (Function1) new Function1<Boolean, Float>() { // from class: androidx.compose.material3.SwitchKt$Switch$valueToOffset$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final Float invoke(boolean z6) {
                        return Float.valueOf(z6 ? f722 : f522);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        return invoke(((Boolean) obj2).booleanValue());
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
                startRestartGroup.endReplaceableGroup();
                floatValue = ((Number) ((Function1) rememberedValue).invoke(Boolean.valueOf(z))).floatValue();
                startRestartGroup.startReplaceableGroup(-1221650404);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Switch.kt#9igjgp");
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                }
                animatable = (Animatable) rememberedValue2;
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(773894976);
                ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                startRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                }
                startRestartGroup.endReplaceableGroup();
                final CoroutineScope coroutineScope22 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue3).getCoroutineScope();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(-1221650310);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Switch.kt#9igjgp");
                changedInstance = startRestartGroup.changedInstance(animatable) | startRestartGroup.changed(f522);
                rememberedValue4 = startRestartGroup.rememberedValue();
                if (!changedInstance) {
                }
                rememberedValue4 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.SwitchKt$Switch$2$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m3082invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m3082invoke() {
                        Animatable.updateBounds$default(animatable, Float.valueOf(f522), null, 2, null);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
                startRestartGroup.endReplaceableGroup();
                EffectsKt.SideEffect((Function0) rememberedValue4, startRestartGroup, 0);
                Boolean valueOf22 = Boolean.valueOf(z);
                startRestartGroup.startReplaceableGroup(-1221650133);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Switch.kt#9igjgp");
                changedInstance2 = startRestartGroup.changedInstance(animatable) | startRestartGroup.changed(floatValue) | startRestartGroup.changedInstance(coroutineScope22);
                rememberedValue5 = startRestartGroup.rememberedValue();
                if (!changedInstance2) {
                }
                rememberedValue5 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.material3.SwitchKt$Switch$3$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* compiled from: Switch.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                    @DebugMetadata(c = "androidx.compose.material3.SwitchKt$Switch$3$1$1", f = "Switch.kt", i = {}, l = {125}, m = "invokeSuspend", n = {}, s = {})
                    /* renamed from: androidx.compose.material3.SwitchKt$Switch$3$1$1 */
                    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
                    public static final class C07071 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ Animatable<Float, AnimationVector1D> $offset;
                        final /* synthetic */ float $targetValue;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C07071(Animatable<Float, AnimationVector1D> animatable, float f, Continuation<? super C07071> continuation) {
                            super(2, continuation);
                            this.$offset = animatable;
                            this.$targetValue = f;
                        }

                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C07071(this.$offset, this.$targetValue, continuation);
                        }

                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                        }

                        public final Object invokeSuspend(Object obj) {
                            TweenSpec tweenSpec;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                Animatable<Float, AnimationVector1D> animatable = this.$offset;
                                Float boxFloat = Boxing.boxFloat(this.$targetValue);
                                tweenSpec = SwitchKt.AnimationSpec;
                                this.label = 1;
                                if (Animatable.animateTo$default(animatable, boxFloat, tweenSpec, null, null, (Continuation) this, 12, null) == coroutine_suspended) {
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

                    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                        if (!(animatable.getTargetValue().floatValue() == floatValue)) {
                            BuildersKt.launch$default(coroutineScope22, (CoroutineContext) null, (CoroutineStart) null, new C07071(animatable, floatValue, null), 3, (Object) null);
                        }
                        return new DisposableEffectResult() { // from class: androidx.compose.material3.SwitchKt$Switch$3$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                            }
                        };
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue5);
                startRestartGroup.endReplaceableGroup();
                EffectsKt.DisposableEffect(valueOf22, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue5, startRestartGroup, i922 & 14);
                if (function1 != null) {
                }
                Modifier m1114requiredSizeVpY3zN422 = SizeKt.m1114requiredSizeVpY3zN4(SizeKt.wrapContentSize$default(modifier3.then(function1 != null ? InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE) : Modifier.INSTANCE).then(companion), Alignment.INSTANCE.getCenter(), false, 2, obj), SwitchWidth, f322);
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy22 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0 constructor22 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf22 = LayoutKt.modifierMaterializerOf(m1114requiredSizeVpY3zN422);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                }
                m4109constructorimpl = Updater.m4109constructorimpl(startRestartGroup);
                Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy22, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap22, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash22 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!m4109constructorimpl.getInserting()) {
                }
                m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash22);
                modifierMaterializerOf22.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance22 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1873061411, "C164@6698L5,158@6451L447:Switch.kt#uh7d8r");
                int i1022 = i922 >> 6;
                int i1122 = 6 | ((i922 << 3) & 112) | (i1022 & 896) | (i1022 & 7168) | ((i922 << 6) & 458752) | (3670016 & i922);
                modifier2 = modifier3;
                composer2 = startRestartGroup;
                m3080SwitchImpl0DmnUew(boxScopeInstance22, z, z4, switchColors3, animatable2.asState(), function23, mutableInteractionSource3, ShapesKt.getValue(SwitchTokens.INSTANCE.getHandleShape(), startRestartGroup, 6), f222, f422, f, composer2, i1122, 6);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endReplaceableGroup();
                composer2.endNode();
                composer2.endReplaceableGroup();
                composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                }
                function24 = function23;
                z5 = z4;
                switchColors4 = switchColors3;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            function22 = function2;
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            z3 = z2;
            if ((196608 & i) != 0) {
            }
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i3 & 599187) == 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i8 != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if (i6 != 0) {
            }
            int i9222 = i3;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            float f2222 = function23 == null ? UncheckedThumbDiameter : ThumbDiameter;
            float f3222 = SwitchHeight;
            float f4222 = Dp.constructor-impl(Dp.constructor-impl(f3222 - f2222) / 2);
            ProvidableCompositionLocal localDensity322 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume322 = startRestartGroup.consume(localDensity322);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final float f5222 = ((Density) consume322).toPx-0680j_4(f4222);
            ProvidableCompositionLocal localDensity2222 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2222 = startRestartGroup.consume(localDensity2222);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            float f6222 = ThumbPathLength;
            final float f7222 = ((Density) consume2222).toPx-0680j_4(f6222);
            startRestartGroup.startReplaceableGroup(-1221650579);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Switch.kt#9igjgp");
            changed = startRestartGroup.changed(f5222) | startRestartGroup.changed(f7222);
            rememberedValue = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue = (Function1) new Function1<Boolean, Float>() { // from class: androidx.compose.material3.SwitchKt$Switch$valueToOffset$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final Float invoke(boolean z6) {
                    return Float.valueOf(z6 ? f7222 : f5222);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    return invoke(((Boolean) obj2).booleanValue());
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceableGroup();
            floatValue = ((Number) ((Function1) rememberedValue).invoke(Boolean.valueOf(z))).floatValue();
            startRestartGroup.startReplaceableGroup(-1221650404);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Switch.kt#9igjgp");
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            }
            animatable = (Animatable) rememberedValue2;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(773894976);
            ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            final CoroutineScope coroutineScope222 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue3).getCoroutineScope();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-1221650310);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Switch.kt#9igjgp");
            changedInstance = startRestartGroup.changedInstance(animatable) | startRestartGroup.changed(f5222);
            rememberedValue4 = startRestartGroup.rememberedValue();
            if (!changedInstance) {
            }
            rememberedValue4 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.SwitchKt$Switch$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m3082invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m3082invoke() {
                    Animatable.updateBounds$default(animatable, Float.valueOf(f5222), null, 2, null);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue4);
            startRestartGroup.endReplaceableGroup();
            EffectsKt.SideEffect((Function0) rememberedValue4, startRestartGroup, 0);
            Boolean valueOf222 = Boolean.valueOf(z);
            startRestartGroup.startReplaceableGroup(-1221650133);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Switch.kt#9igjgp");
            changedInstance2 = startRestartGroup.changedInstance(animatable) | startRestartGroup.changed(floatValue) | startRestartGroup.changedInstance(coroutineScope222);
            rememberedValue5 = startRestartGroup.rememberedValue();
            if (!changedInstance2) {
            }
            rememberedValue5 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.material3.SwitchKt$Switch$3$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: Switch.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "androidx.compose.material3.SwitchKt$Switch$3$1$1", f = "Switch.kt", i = {}, l = {125}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: androidx.compose.material3.SwitchKt$Switch$3$1$1 */
                /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
                public static final class C07071 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ Animatable<Float, AnimationVector1D> $offset;
                    final /* synthetic */ float $targetValue;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C07071(Animatable<Float, AnimationVector1D> animatable, float f, Continuation<? super C07071> continuation) {
                        super(2, continuation);
                        this.$offset = animatable;
                        this.$targetValue = f;
                    }

                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C07071(this.$offset, this.$targetValue, continuation);
                    }

                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                    }

                    public final Object invokeSuspend(Object obj) {
                        TweenSpec tweenSpec;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            Animatable<Float, AnimationVector1D> animatable = this.$offset;
                            Float boxFloat = Boxing.boxFloat(this.$targetValue);
                            tweenSpec = SwitchKt.AnimationSpec;
                            this.label = 1;
                            if (Animatable.animateTo$default(animatable, boxFloat, tweenSpec, null, null, (Continuation) this, 12, null) == coroutine_suspended) {
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

                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                    if (!(animatable.getTargetValue().floatValue() == floatValue)) {
                        BuildersKt.launch$default(coroutineScope222, (CoroutineContext) null, (CoroutineStart) null, new C07071(animatable, floatValue, null), 3, (Object) null);
                    }
                    return new DisposableEffectResult() { // from class: androidx.compose.material3.SwitchKt$Switch$3$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                        }
                    };
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue5);
            startRestartGroup.endReplaceableGroup();
            EffectsKt.DisposableEffect(valueOf222, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue5, startRestartGroup, i9222 & 14);
            if (function1 != null) {
            }
            Modifier m1114requiredSizeVpY3zN4222 = SizeKt.m1114requiredSizeVpY3zN4(SizeKt.wrapContentSize$default(modifier3.then(function1 != null ? InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE) : Modifier.INSTANCE).then(companion), Alignment.INSTANCE.getCenter(), false, 2, obj), SwitchWidth, f3222);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy222 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap222 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0 constructor222 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf222 = LayoutKt.modifierMaterializerOf(m1114requiredSizeVpY3zN4222);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m4109constructorimpl = Updater.m4109constructorimpl(startRestartGroup);
            Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy222, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap222, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash222 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (!m4109constructorimpl.getInserting()) {
            }
            m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash222);
            modifierMaterializerOf222.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance222 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1873061411, "C164@6698L5,158@6451L447:Switch.kt#uh7d8r");
            int i10222 = i9222 >> 6;
            int i11222 = 6 | ((i9222 << 3) & 112) | (i10222 & 896) | (i10222 & 7168) | ((i9222 << 6) & 458752) | (3670016 & i9222);
            modifier2 = modifier3;
            composer2 = startRestartGroup;
            m3080SwitchImpl0DmnUew(boxScopeInstance222, z, z4, switchColors3, animatable2.asState(), function23, mutableInteractionSource3, ShapesKt.getValue(SwitchTokens.INSTANCE.getHandleShape(), startRestartGroup, 6), f2222, f4222, f, composer2, i11222, 6);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
            }
            function24 = function23;
            z5 = z4;
            switchColors4 = switchColors3;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        function22 = function2;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        z3 = z2;
        if ((196608 & i) != 0) {
        }
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i3 & 599187) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i8 != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if (i6 != 0) {
        }
        int i92222 = i3;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        float f22222 = function23 == null ? UncheckedThumbDiameter : ThumbDiameter;
        float f32222 = SwitchHeight;
        float f42222 = Dp.constructor-impl(Dp.constructor-impl(f32222 - f22222) / 2);
        ProvidableCompositionLocal localDensity3222 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume3222 = startRestartGroup.consume(localDensity3222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        final float f52222 = ((Density) consume3222).toPx-0680j_4(f42222);
        ProvidableCompositionLocal localDensity22222 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume22222 = startRestartGroup.consume(localDensity22222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        float f62222 = ThumbPathLength;
        final float f72222 = ((Density) consume22222).toPx-0680j_4(f62222);
        startRestartGroup.startReplaceableGroup(-1221650579);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Switch.kt#9igjgp");
        changed = startRestartGroup.changed(f52222) | startRestartGroup.changed(f72222);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue = (Function1) new Function1<Boolean, Float>() { // from class: androidx.compose.material3.SwitchKt$Switch$valueToOffset$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final Float invoke(boolean z6) {
                return Float.valueOf(z6 ? f72222 : f52222);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                return invoke(((Boolean) obj2).booleanValue());
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceableGroup();
        floatValue = ((Number) ((Function1) rememberedValue).invoke(Boolean.valueOf(z))).floatValue();
        startRestartGroup.startReplaceableGroup(-1221650404);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Switch.kt#9igjgp");
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
        }
        animatable = (Animatable) rememberedValue2;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(773894976);
        ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
        startRestartGroup.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        final CoroutineScope coroutineScope2222 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue3).getCoroutineScope();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(-1221650310);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Switch.kt#9igjgp");
        changedInstance = startRestartGroup.changedInstance(animatable) | startRestartGroup.changed(f52222);
        rememberedValue4 = startRestartGroup.rememberedValue();
        if (!changedInstance) {
        }
        rememberedValue4 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.SwitchKt$Switch$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m3082invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m3082invoke() {
                Animatable.updateBounds$default(animatable, Float.valueOf(f52222), null, 2, null);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue4);
        startRestartGroup.endReplaceableGroup();
        EffectsKt.SideEffect((Function0) rememberedValue4, startRestartGroup, 0);
        Boolean valueOf2222 = Boolean.valueOf(z);
        startRestartGroup.startReplaceableGroup(-1221650133);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Switch.kt#9igjgp");
        changedInstance2 = startRestartGroup.changedInstance(animatable) | startRestartGroup.changed(floatValue) | startRestartGroup.changedInstance(coroutineScope2222);
        rememberedValue5 = startRestartGroup.rememberedValue();
        if (!changedInstance2) {
        }
        rememberedValue5 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.material3.SwitchKt$Switch$3$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: Switch.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.material3.SwitchKt$Switch$3$1$1", f = "Switch.kt", i = {}, l = {125}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: androidx.compose.material3.SwitchKt$Switch$3$1$1 */
            /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
            public static final class C07071 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Animatable<Float, AnimationVector1D> $offset;
                final /* synthetic */ float $targetValue;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C07071(Animatable<Float, AnimationVector1D> animatable, float f, Continuation<? super C07071> continuation) {
                    super(2, continuation);
                    this.$offset = animatable;
                    this.$targetValue = f;
                }

                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C07071(this.$offset, this.$targetValue, continuation);
                }

                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                }

                public final Object invokeSuspend(Object obj) {
                    TweenSpec tweenSpec;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        Animatable<Float, AnimationVector1D> animatable = this.$offset;
                        Float boxFloat = Boxing.boxFloat(this.$targetValue);
                        tweenSpec = SwitchKt.AnimationSpec;
                        this.label = 1;
                        if (Animatable.animateTo$default(animatable, boxFloat, tweenSpec, null, null, (Continuation) this, 12, null) == coroutine_suspended) {
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

            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                if (!(animatable.getTargetValue().floatValue() == floatValue)) {
                    BuildersKt.launch$default(coroutineScope2222, (CoroutineContext) null, (CoroutineStart) null, new C07071(animatable, floatValue, null), 3, (Object) null);
                }
                return new DisposableEffectResult() { // from class: androidx.compose.material3.SwitchKt$Switch$3$1$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                    }
                };
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue5);
        startRestartGroup.endReplaceableGroup();
        EffectsKt.DisposableEffect(valueOf2222, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue5, startRestartGroup, i92222 & 14);
        if (function1 != null) {
        }
        Modifier m1114requiredSizeVpY3zN42222 = SizeKt.m1114requiredSizeVpY3zN4(SizeKt.wrapContentSize$default(modifier3.then(function1 != null ? InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE) : Modifier.INSTANCE).then(companion), Alignment.INSTANCE.getCenter(), false, 2, obj), SwitchWidth, f32222);
        startRestartGroup.startReplaceableGroup(733328855);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
        MeasurePolicy rememberBoxMeasurePolicy2222 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap2222 = startRestartGroup.getCurrentCompositionLocalMap();
        Function0 constructor2222 = ComposeUiNode.Companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2222 = LayoutKt.modifierMaterializerOf(m1114requiredSizeVpY3zN42222);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m4109constructorimpl = Updater.m4109constructorimpl(startRestartGroup);
        Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy2222, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap2222, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2 setCompositeKeyHash2222 = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (!m4109constructorimpl.getInserting()) {
        }
        m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2222);
        modifierMaterializerOf2222.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
        BoxScopeInstance boxScopeInstance2222 = BoxScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1873061411, "C164@6698L5,158@6451L447:Switch.kt#uh7d8r");
        int i102222 = i92222 >> 6;
        int i112222 = 6 | ((i92222 << 3) & 112) | (i102222 & 896) | (i102222 & 7168) | ((i92222 << 6) & 458752) | (3670016 & i92222);
        modifier2 = modifier3;
        composer2 = startRestartGroup;
        m3080SwitchImpl0DmnUew(boxScopeInstance2222, z, z4, switchColors3, animatable2.asState(), function23, mutableInteractionSource3, ShapesKt.getValue(SwitchTokens.INSTANCE.getHandleShape(), startRestartGroup, 6), f22222, f42222, f, composer2, i112222, 6);
        ComposerKt.sourceInformationMarkerEnd(composer2);
        ComposerKt.sourceInformationMarkerEnd(composer2);
        composer2.endReplaceableGroup();
        composer2.endNode();
        composer2.endReplaceableGroup();
        composer2.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
        }
        function24 = function23;
        z5 = z4;
        switchColors4 = switchColors3;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: SwitchImpl-0DmnUew, reason: not valid java name */
    public static final void m3080SwitchImpl0DmnUew(final BoxScope boxScope, final boolean z, final boolean z2, final SwitchColors switchColors, final State<Float> state, final Function2<? super Composer, ? super Integer, Unit> function2, final InteractionSource interactionSource, final Shape shape, final float f, final float f2, final float f3, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        float f4;
        final float floatValue;
        float m3921getTrackOutlineWidthD9Ej5fM;
        Composer startRestartGroup = composer.startRestartGroup(-1968109941);
        ComposerKt.sourceInformation(startRestartGroup, "C(SwitchImpl)P(!1,2!1,8,6!1,7,9:c#ui.unit.Dp,5:c#ui.unit.Dp,4:c#ui.unit.Dp)188@7413L25,*190@7481L7,210@8114L5,222@8432L1050:Switch.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(boxScope) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= startRestartGroup.changed(z2) ? Fields.RotationX : Fields.SpotShadowColor;
        }
        if ((i & 3072) == 0) {
            i3 |= startRestartGroup.changed(switchColors) ? Fields.CameraDistance : Fields.RotationZ;
        }
        if ((i & 24576) == 0) {
            i3 |= startRestartGroup.changed(state) ? Fields.Clip : Fields.Shape;
        }
        if ((i & 196608) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? Fields.RenderEffect : 65536;
        }
        if ((i & 1572864) == 0) {
            i3 |= startRestartGroup.changed(interactionSource) ? 1048576 : Fields.BlendMode;
        }
        if ((i & 12582912) == 0) {
            i3 |= startRestartGroup.changed(shape) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i3 |= startRestartGroup.changed(f) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= startRestartGroup.changed(f2) ? 536870912 : 268435456;
        }
        if ((i2 & 6) == 0) {
            i4 = i2 | (startRestartGroup.changed(f3) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i3 & 306783379) != 306783378 || (i4 & 3) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1968109941, i3, i4, "androidx.compose.material3.SwitchImpl (Switch.kt:186)");
            }
            long m3077trackColorWaAFU9c$material3_release = switchColors.m3077trackColorWaAFU9c$material3_release(z2, z);
            State<Boolean> collectIsPressedAsState = PressInteractionKt.collectIsPressedAsState(interactionSource, startRestartGroup, (i3 >> 18) & 14);
            ProvidableCompositionLocal localDensity = CompositionLocalsKt.getLocalDensity();
            int i5 = i3;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            float f5 = ((Density) consume).toDp-u2uoSUM(state.getValue().floatValue());
            if (SwitchImpl_0DmnUew$lambda$8(collectIsPressedAsState)) {
                f4 = SwitchTokens.INSTANCE.m3915getPressedHandleWidthD9Ej5fM();
            } else {
                f4 = Dp.constructor-impl(Dp.constructor-impl(Dp.constructor-impl(ThumbDiameter - f) * (Dp.constructor-impl(f5 - f2) / Dp.constructor-impl(f3 - f2))) + f);
            }
            startRestartGroup.startReplaceableGroup(-993794132);
            ComposerKt.sourceInformation(startRestartGroup, "*199@7822L7");
            if (SwitchImpl_0DmnUew$lambda$8(collectIsPressedAsState)) {
                ProvidableCompositionLocal localDensity2 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume2 = startRestartGroup.consume(localDensity2);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Density density = (Density) consume2;
                if (!z) {
                    m3921getTrackOutlineWidthD9Ej5fM = SwitchTokens.INSTANCE.m3921getTrackOutlineWidthD9Ej5fM();
                } else {
                    m3921getTrackOutlineWidthD9Ej5fM = Dp.constructor-impl(ThumbPathLength - SwitchTokens.INSTANCE.m3921getTrackOutlineWidthD9Ej5fM());
                }
                floatValue = density.toPx-0680j_4(m3921getTrackOutlineWidthD9Ej5fM);
            } else {
                floatValue = state.getValue().floatValue();
            }
            startRestartGroup.endReplaceableGroup();
            Shape value = ShapesKt.getValue(SwitchTokens.INSTANCE.getTrackShape(), startRestartGroup, 6);
            Modifier m396backgroundbw27NRU = BackgroundKt.m396backgroundbw27NRU(BorderKt.m414borderxT4_qwU(SizeKt.m1106height3ABfNKs(SizeKt.m1125width3ABfNKs(boxScope.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenter()), SwitchWidth), SwitchHeight), SwitchTokens.INSTANCE.m3921getTrackOutlineWidthD9Ej5fM(), switchColors.m3057borderColorWaAFU9c$material3_release(z2, z), value), m3077trackColorWaAFU9c$material3_release, value);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m396backgroundbw27NRU);
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
            Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1420969714, "C228@8671L42,231@8868L134,225@8564L912:Switch.kt#uh7d8r");
            long m3076thumbColorWaAFU9c$material3_release = switchColors.m3076thumbColorWaAFU9c$material3_release(z2, z);
            Modifier align = boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterStart());
            startRestartGroup.startReplaceableGroup(1420969929);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Switch.kt#9igjgp");
            boolean changed = startRestartGroup.changed(floatValue);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.compose.material3.SwitchKt$SwitchImpl$1$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return IntOffset.box-impl(m3083invokeBjo55l4((Density) obj));
                    }

                    /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                    public final long m3083invokeBjo55l4(Density density2) {
                        return IntOffsetKt.IntOffset(MathKt.roundToInt(floatValue), 0);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            Modifier m396backgroundbw27NRU2 = BackgroundKt.m396backgroundbw27NRU(SizeKt.m1112requiredSize3ABfNKs(IndicationKt.indication(OffsetKt.offset(align, (Function1) rememberedValue), interactionSource, RippleKt.m2177rememberRipple9IZ8Weo(false, Dp.constructor-impl(SwitchTokens.INSTANCE.m3919getStateLayerSizeD9Ej5fM() / 2), 0L, startRestartGroup, 54, 4)), f4), m3076thumbColorWaAFU9c$material3_release, shape);
            Alignment center = Alignment.INSTANCE.getCenter();
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center, false, startRestartGroup, 6);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m396backgroundbw27NRU2);
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
            Updater.m4116setimpl(m4109constructorimpl2, rememberBoxMeasurePolicy2, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4116setimpl(m4109constructorimpl2, currentCompositionLocalMap2, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m4109constructorimpl2.getInserting() || !Intrinsics.areEqual(m4109constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m4109constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m4109constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            modifierMaterializerOf2.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2040677128, "C:Switch.kt#uh7d8r");
            startRestartGroup.startReplaceableGroup(1420970455);
            ComposerKt.sourceInformation(startRestartGroup, "242@9308L144");
            if (function2 != null) {
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4829boximpl(switchColors.m3075iconColorWaAFU9c$material3_release(z2, z))), function2, startRestartGroup, 0 | ProvidedValue.$stable | ((i5 >> 12) & 112));
            }
            startRestartGroup.endReplaceableGroup();
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
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SwitchKt$SwitchImpl$2
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
                    SwitchKt.m3080SwitchImpl0DmnUew(BoxScope.this, z, z2, switchColors, state, function2, interactionSource, shape, f, f2, f3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
                }
            });
        }
    }

    static {
        float m3917getSelectedHandleWidthD9Ej5fM = SwitchTokens.INSTANCE.m3917getSelectedHandleWidthD9Ej5fM();
        ThumbDiameter = m3917getSelectedHandleWidthD9Ej5fM;
        UncheckedThumbDiameter = SwitchTokens.INSTANCE.m3924getUnselectedHandleWidthD9Ej5fM();
        float m3922getTrackWidthD9Ej5fM = SwitchTokens.INSTANCE.m3922getTrackWidthD9Ej5fM();
        SwitchWidth = m3922getTrackWidthD9Ej5fM;
        float m3920getTrackHeightD9Ej5fM = SwitchTokens.INSTANCE.m3920getTrackHeightD9Ej5fM();
        SwitchHeight = m3920getTrackHeightD9Ej5fM;
        float f = Dp.constructor-impl(Dp.constructor-impl(m3920getTrackHeightD9Ej5fM - m3917getSelectedHandleWidthD9Ej5fM) / 2);
        ThumbPadding = f;
        ThumbPathLength = Dp.constructor-impl(Dp.constructor-impl(m3922getTrackWidthD9Ej5fM - m3917getSelectedHandleWidthD9Ej5fM) - f);
        AnimationSpec = new TweenSpec<>(100, 0, null, 6, null);
    }

    public static final float getThumbDiameter() {
        return ThumbDiameter;
    }

    public static final float getUncheckedThumbDiameter() {
        return UncheckedThumbDiameter;
    }

    private static final boolean SwitchImpl_0DmnUew$lambda$8(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
