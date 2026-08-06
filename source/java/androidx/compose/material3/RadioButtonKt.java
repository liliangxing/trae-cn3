package androidx.compose.material3;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.material3.tokens.RadioButtonTokens;
import androidx.compose.p002ui.Alignment;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.graphics.Color;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.graphics.drawscope.DrawScope;
import androidx.compose.p002ui.graphics.drawscope.Fill;
import androidx.compose.p002ui.graphics.drawscope.Stroke;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: RadioButton.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aM\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007¢\u0006\u0002\u0010\u0014\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0010\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0010\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004¨\u0006\u0015"}, d2 = {"RadioAnimationDuration", "", "RadioButtonDotSize", "Landroidx/compose/ui/unit/Dp;", "F", "RadioButtonPadding", "RadioStrokeWidth", "RadioButton", "", "selected", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "colors", "Landroidx/compose/material3/RadioButtonColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/RadioButtonColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class RadioButtonKt {
    private static final int RadioAnimationDuration = 100;
    private static final float RadioButtonDotSize = Dp.constructor-impl(12);
    private static final float RadioButtonPadding;
    private static final float RadioStrokeWidth;

    /* JADX WARN: Removed duplicated region for block: B:13:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0066  */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r13v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void RadioButton(final boolean z, final Function0<Unit> function0, Modifier modifier, boolean z2, RadioButtonColors radioButtonColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        final Modifier modifier2;
        int i4;
        boolean z3;
        RadioButtonColors radioButtonColors2;
        int i5;
        MutableInteractionSource mutableInteractionSource2;
        MutableInteractionSource mutableInteractionSource3;
        Modifier modifier3;
        ?? r13;
        final State<Color> state;
        RadioButtonColors radioButtonColors3;
        Modifier modifier4;
        int i6;
        Composer composer2;
        State<Dp> state2;
        boolean z4;
        Modifier.Companion companion;
        boolean changed;
        Object rememberedValue;
        final RadioButtonColors radioButtonColors4;
        final boolean z5;
        final MutableInteractionSource mutableInteractionSource4;
        ScopeUpdateScope endRestartGroup;
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(408580840);
        ComposerKt.sourceInformation(startRestartGroup, "C(RadioButton)P(5,4,3,1)77@3753L8,78@3813L39,80@3877L164,84@4070L29,115@5122L415,102@4704L833:RadioButton.kt#uh7d8r");
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
            i3 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
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
                z3 = z2;
                i3 |= startRestartGroup.changed(z3) ? Fields.CameraDistance : Fields.RotationZ;
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        radioButtonColors2 = radioButtonColors;
                        if (startRestartGroup.changed(radioButtonColors2)) {
                            i7 = Fields.Clip;
                            i3 |= i7;
                        }
                    } else {
                        radioButtonColors2 = radioButtonColors;
                    }
                    i7 = Fields.Shape;
                    i3 |= i7;
                } else {
                    radioButtonColors2 = radioButtonColors;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= 196608;
                } else if ((196608 & i) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    i3 |= startRestartGroup.changed(mutableInteractionSource2) ? Fields.RenderEffect : 65536;
                    if ((74899 & i3) == 74898 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            Modifier.Companion companion2 = i8 == 0 ? Modifier.INSTANCE : modifier2;
                            if (i4 != 0) {
                                z3 = true;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                radioButtonColors2 = RadioButtonDefaults.INSTANCE.colors(startRestartGroup, 6);
                            }
                            if (i5 == 0) {
                                startRestartGroup.startReplaceableGroup(735546075);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):RadioButton.kt#9igjgp");
                                Object rememberedValue2 = startRestartGroup.rememberedValue();
                                if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                                    startRestartGroup.updateRememberedValue(rememberedValue2);
                                }
                                startRestartGroup.endReplaceableGroup();
                                modifier3 = companion2;
                                mutableInteractionSource3 = (MutableInteractionSource) rememberedValue2;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                                modifier3 = companion2;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            mutableInteractionSource3 = mutableInteractionSource;
                            modifier3 = modifier2;
                        }
                        boolean z6 = z3;
                        RadioButtonColors radioButtonColors5 = radioButtonColors2;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(408580840, i3, -1, "androidx.compose.material3.RadioButton (RadioButton.kt:79)");
                        }
                        State<Dp> m271animateDpAsStateAjpBEmI = AnimateAsStateKt.m271animateDpAsStateAjpBEmI(!z ? Dp.constructor-impl(RadioButtonDotSize / 2) : Dp.constructor-impl(0), AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, startRestartGroup, 48, 12);
                        State<Color> radioColor$material3_release = radioButtonColors5.radioColor$material3_release(z6, z, startRestartGroup, ((i3 >> 6) & 896) | ((i3 >> 9) & 14) | ((i3 << 3) & 112));
                        startRestartGroup.startReplaceableGroup(735546399);
                        ComposerKt.sourceInformation(startRestartGroup, "94@4501L136");
                        if (function0 == null) {
                            state2 = m271animateDpAsStateAjpBEmI;
                            r13 = 0;
                            state = radioColor$material3_release;
                            radioButtonColors3 = radioButtonColors5;
                            z4 = z6;
                            modifier4 = modifier3;
                            i6 = 2;
                            composer2 = startRestartGroup;
                            companion = SelectableKt.m1432selectableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource3, RippleKt.m2177rememberRipple9IZ8Weo(false, Dp.constructor-impl(RadioButtonTokens.INSTANCE.m3870getStateLayerSizeD9Ej5fM() / 2), 0L, startRestartGroup, 54, 4), z4, Role.box-impl(Role.Companion.getRadioButton-o7Vup1c()), function0);
                        } else {
                            r13 = 0;
                            state = radioColor$material3_release;
                            radioButtonColors3 = radioButtonColors5;
                            modifier4 = modifier3;
                            i6 = 2;
                            composer2 = startRestartGroup;
                            state2 = m271animateDpAsStateAjpBEmI;
                            z4 = z6;
                            companion = Modifier.INSTANCE;
                        }
                        composer2.endReplaceableGroup();
                        Modifier m1112requiredSize3ABfNKs = SizeKt.m1112requiredSize3ABfNKs(PaddingKt.m1064padding3ABfNKs(SizeKt.wrapContentSize$default(modifier4.then(function0 == null ? InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE) : Modifier.INSTANCE).then(companion), Alignment.INSTANCE.getCenter(), r13, i6, null), RadioButtonPadding), RadioButtonTokens.INSTANCE.m3869getIconSizeD9Ej5fM());
                        composer2.startReplaceableGroup(735547384);
                        ComposerKt.sourceInformation(composer2, "CC(remember):RadioButton.kt#9igjgp");
                        final State<Dp> state3 = state2;
                        changed = composer2.changed(state) | composer2.changed(state3);
                        rememberedValue = composer2.rememberedValue();
                        if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.RadioButtonKt$RadioButton$2$1
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
                                    float f;
                                    f = RadioButtonKt.RadioStrokeWidth;
                                    float f2 = drawScope.toPx-0680j_4(f);
                                    float f3 = 2;
                                    float f4 = f2 / f3;
                                    DrawScope.m5398drawCircleVaOC9Bg$default(drawScope, state.getValue().m4849unboximpl(), drawScope.toPx-0680j_4(Dp.constructor-impl(RadioButtonTokens.INSTANCE.m3869getIconSizeD9Ej5fM() / f3)) - f4, 0L, 0.0f, new Stroke(f2, 0.0f, 0, 0, null, 30, null), null, 0, 108, null);
                                    if (Dp.compareTo-0680j_4(state3.getValue().unbox-impl(), Dp.constructor-impl(0)) > 0) {
                                        DrawScope.m5398drawCircleVaOC9Bg$default(drawScope, state.getValue().m4849unboximpl(), drawScope.toPx-0680j_4(state3.getValue().unbox-impl()) - f4, 0L, 0.0f, Fill.INSTANCE, null, 0, 108, null);
                                    }
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue);
                        }
                        composer2.endReplaceableGroup();
                        CanvasKt.Canvas(m1112requiredSize3ABfNKs, (Function1) rememberedValue, composer2, r13);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier4;
                        radioButtonColors4 = radioButtonColors3;
                        z5 = z4;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        composer2 = startRestartGroup;
                        z5 = z3;
                        radioButtonColors4 = radioButtonColors2;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.RadioButtonKt$RadioButton$3
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i9) {
                                RadioButtonKt.RadioButton(z, function0, modifier2, z5, radioButtonColors4, mutableInteractionSource4, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                mutableInteractionSource2 = mutableInteractionSource;
                if ((74899 & i3) == 74898) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i8 == 0) {
                }
                if (i4 != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                if (i5 == 0) {
                }
                boolean z62 = z3;
                RadioButtonColors radioButtonColors52 = radioButtonColors2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                State<Dp> m271animateDpAsStateAjpBEmI2 = AnimateAsStateKt.m271animateDpAsStateAjpBEmI(!z ? Dp.constructor-impl(RadioButtonDotSize / 2) : Dp.constructor-impl(0), AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, startRestartGroup, 48, 12);
                State<Color> radioColor$material3_release2 = radioButtonColors52.radioColor$material3_release(z62, z, startRestartGroup, ((i3 >> 6) & 896) | ((i3 >> 9) & 14) | ((i3 << 3) & 112));
                startRestartGroup.startReplaceableGroup(735546399);
                ComposerKt.sourceInformation(startRestartGroup, "94@4501L136");
                if (function0 == null) {
                }
                composer2.endReplaceableGroup();
                Modifier m1112requiredSize3ABfNKs2 = SizeKt.m1112requiredSize3ABfNKs(PaddingKt.m1064padding3ABfNKs(SizeKt.wrapContentSize$default(modifier4.then(function0 == null ? InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE) : Modifier.INSTANCE).then(companion), Alignment.INSTANCE.getCenter(), r13, i6, null), RadioButtonPadding), RadioButtonTokens.INSTANCE.m3869getIconSizeD9Ej5fM());
                composer2.startReplaceableGroup(735547384);
                ComposerKt.sourceInformation(composer2, "CC(remember):RadioButton.kt#9igjgp");
                final State<Dp> state32 = state2;
                changed = composer2.changed(state) | composer2.changed(state32);
                rememberedValue = composer2.rememberedValue();
                if (!changed) {
                }
                rememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.RadioButtonKt$RadioButton$2$1
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
                        float f;
                        f = RadioButtonKt.RadioStrokeWidth;
                        float f2 = drawScope.toPx-0680j_4(f);
                        float f3 = 2;
                        float f4 = f2 / f3;
                        DrawScope.m5398drawCircleVaOC9Bg$default(drawScope, state.getValue().m4849unboximpl(), drawScope.toPx-0680j_4(Dp.constructor-impl(RadioButtonTokens.INSTANCE.m3869getIconSizeD9Ej5fM() / f3)) - f4, 0L, 0.0f, new Stroke(f2, 0.0f, 0, 0, null, 30, null), null, 0, 108, null);
                        if (Dp.compareTo-0680j_4(state32.getValue().unbox-impl(), Dp.constructor-impl(0)) > 0) {
                            DrawScope.m5398drawCircleVaOC9Bg$default(drawScope, state.getValue().m4849unboximpl(), drawScope.toPx-0680j_4(state32.getValue().unbox-impl()) - f4, 0L, 0.0f, Fill.INSTANCE, null, 0, 108, null);
                        }
                    }
                };
                composer2.updateRememberedValue(rememberedValue);
                composer2.endReplaceableGroup();
                CanvasKt.Canvas(m1112requiredSize3ABfNKs2, (Function1) rememberedValue, composer2, r13);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier2 = modifier4;
                radioButtonColors4 = radioButtonColors3;
                z5 = z4;
                mutableInteractionSource4 = mutableInteractionSource3;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z3 = z2;
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((74899 & i3) == 74898) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i8 == 0) {
            }
            if (i4 != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            if (i5 == 0) {
            }
            boolean z622 = z3;
            RadioButtonColors radioButtonColors522 = radioButtonColors2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            State<Dp> m271animateDpAsStateAjpBEmI22 = AnimateAsStateKt.m271animateDpAsStateAjpBEmI(!z ? Dp.constructor-impl(RadioButtonDotSize / 2) : Dp.constructor-impl(0), AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, startRestartGroup, 48, 12);
            State<Color> radioColor$material3_release22 = radioButtonColors522.radioColor$material3_release(z622, z, startRestartGroup, ((i3 >> 6) & 896) | ((i3 >> 9) & 14) | ((i3 << 3) & 112));
            startRestartGroup.startReplaceableGroup(735546399);
            ComposerKt.sourceInformation(startRestartGroup, "94@4501L136");
            if (function0 == null) {
            }
            composer2.endReplaceableGroup();
            Modifier m1112requiredSize3ABfNKs22 = SizeKt.m1112requiredSize3ABfNKs(PaddingKt.m1064padding3ABfNKs(SizeKt.wrapContentSize$default(modifier4.then(function0 == null ? InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE) : Modifier.INSTANCE).then(companion), Alignment.INSTANCE.getCenter(), r13, i6, null), RadioButtonPadding), RadioButtonTokens.INSTANCE.m3869getIconSizeD9Ej5fM());
            composer2.startReplaceableGroup(735547384);
            ComposerKt.sourceInformation(composer2, "CC(remember):RadioButton.kt#9igjgp");
            final State<Dp> state322 = state2;
            changed = composer2.changed(state) | composer2.changed(state322);
            rememberedValue = composer2.rememberedValue();
            if (!changed) {
            }
            rememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.RadioButtonKt$RadioButton$2$1
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
                    float f;
                    f = RadioButtonKt.RadioStrokeWidth;
                    float f2 = drawScope.toPx-0680j_4(f);
                    float f3 = 2;
                    float f4 = f2 / f3;
                    DrawScope.m5398drawCircleVaOC9Bg$default(drawScope, state.getValue().m4849unboximpl(), drawScope.toPx-0680j_4(Dp.constructor-impl(RadioButtonTokens.INSTANCE.m3869getIconSizeD9Ej5fM() / f3)) - f4, 0L, 0.0f, new Stroke(f2, 0.0f, 0, 0, null, 30, null), null, 0, 108, null);
                    if (Dp.compareTo-0680j_4(state322.getValue().unbox-impl(), Dp.constructor-impl(0)) > 0) {
                        DrawScope.m5398drawCircleVaOC9Bg$default(drawScope, state.getValue().m4849unboximpl(), drawScope.toPx-0680j_4(state322.getValue().unbox-impl()) - f4, 0L, 0.0f, Fill.INSTANCE, null, 0, 108, null);
                    }
                }
            };
            composer2.updateRememberedValue(rememberedValue);
            composer2.endReplaceableGroup();
            CanvasKt.Canvas(m1112requiredSize3ABfNKs22, (Function1) rememberedValue, composer2, r13);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier2 = modifier4;
            radioButtonColors4 = radioButtonColors3;
            z5 = z4;
            mutableInteractionSource4 = mutableInteractionSource3;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z3 = z2;
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((74899 & i3) == 74898) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i8 == 0) {
        }
        if (i4 != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if (i5 == 0) {
        }
        boolean z6222 = z3;
        RadioButtonColors radioButtonColors5222 = radioButtonColors2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        State<Dp> m271animateDpAsStateAjpBEmI222 = AnimateAsStateKt.m271animateDpAsStateAjpBEmI(!z ? Dp.constructor-impl(RadioButtonDotSize / 2) : Dp.constructor-impl(0), AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, startRestartGroup, 48, 12);
        State<Color> radioColor$material3_release222 = radioButtonColors5222.radioColor$material3_release(z6222, z, startRestartGroup, ((i3 >> 6) & 896) | ((i3 >> 9) & 14) | ((i3 << 3) & 112));
        startRestartGroup.startReplaceableGroup(735546399);
        ComposerKt.sourceInformation(startRestartGroup, "94@4501L136");
        if (function0 == null) {
        }
        composer2.endReplaceableGroup();
        Modifier m1112requiredSize3ABfNKs222 = SizeKt.m1112requiredSize3ABfNKs(PaddingKt.m1064padding3ABfNKs(SizeKt.wrapContentSize$default(modifier4.then(function0 == null ? InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE) : Modifier.INSTANCE).then(companion), Alignment.INSTANCE.getCenter(), r13, i6, null), RadioButtonPadding), RadioButtonTokens.INSTANCE.m3869getIconSizeD9Ej5fM());
        composer2.startReplaceableGroup(735547384);
        ComposerKt.sourceInformation(composer2, "CC(remember):RadioButton.kt#9igjgp");
        final State<Dp> state3222 = state2;
        changed = composer2.changed(state) | composer2.changed(state3222);
        rememberedValue = composer2.rememberedValue();
        if (!changed) {
        }
        rememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.RadioButtonKt$RadioButton$2$1
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
                float f;
                f = RadioButtonKt.RadioStrokeWidth;
                float f2 = drawScope.toPx-0680j_4(f);
                float f3 = 2;
                float f4 = f2 / f3;
                DrawScope.m5398drawCircleVaOC9Bg$default(drawScope, state.getValue().m4849unboximpl(), drawScope.toPx-0680j_4(Dp.constructor-impl(RadioButtonTokens.INSTANCE.m3869getIconSizeD9Ej5fM() / f3)) - f4, 0L, 0.0f, new Stroke(f2, 0.0f, 0, 0, null, 30, null), null, 0, 108, null);
                if (Dp.compareTo-0680j_4(state3222.getValue().unbox-impl(), Dp.constructor-impl(0)) > 0) {
                    DrawScope.m5398drawCircleVaOC9Bg$default(drawScope, state.getValue().m4849unboximpl(), drawScope.toPx-0680j_4(state3222.getValue().unbox-impl()) - f4, 0L, 0.0f, Fill.INSTANCE, null, 0, 108, null);
                }
            }
        };
        composer2.updateRememberedValue(rememberedValue);
        composer2.endReplaceableGroup();
        CanvasKt.Canvas(m1112requiredSize3ABfNKs222, (Function1) rememberedValue, composer2, r13);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier2 = modifier4;
        radioButtonColors4 = radioButtonColors3;
        z5 = z4;
        mutableInteractionSource4 = mutableInteractionSource3;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    static {
        float f = 2;
        RadioButtonPadding = Dp.constructor-impl(f);
        RadioStrokeWidth = Dp.constructor-impl(f);
    }
}
