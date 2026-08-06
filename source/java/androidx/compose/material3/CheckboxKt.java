package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.material3.tokens.CheckboxTokens;
import androidx.compose.p002ui.Alignment;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.geometry.CornerRadiusKt;
import androidx.compose.p002ui.geometry.OffsetKt;
import androidx.compose.p002ui.geometry.Size;
import androidx.compose.p002ui.graphics.Color;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.graphics.StrokeCap;
import androidx.compose.p002ui.graphics.drawscope.DrawScope;
import androidx.compose.p002ui.graphics.drawscope.Fill;
import androidx.compose.p002ui.graphics.drawscope.Stroke;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.state.ToggleableStateKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;

/* compiled from: Checkbox.kt */
@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aS\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007¢\u0006\u0002\u0010\u0017\u001a-\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0003¢\u0006\u0002\u0010\u001b\u001aM\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001a2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007¢\u0006\u0002\u0010 \u001a6\u0010!\u001a\u00020\u000b*\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'H\u0002ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a>\u0010+\u001a\u00020\u000b*\u00020\"2\u0006\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020'2\u0006\u0010.\u001a\u00020'2\u0006\u0010/\u001a\u00020'2\u0006\u00100\u001a\u000201H\u0002ø\u0001\u0000¢\u0006\u0004\b2\u00103\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00064"}, d2 = {"BoxInDuration", "", "BoxOutDuration", "CheckAnimationDuration", "CheckboxDefaultPadding", "Landroidx/compose/ui/unit/Dp;", "F", "CheckboxSize", "RadiusSize", "StrokeWidth", "Checkbox", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "colors", "Landroidx/compose/material3/CheckboxColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/CheckboxColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "CheckboxImpl", "value", "Landroidx/compose/ui/state/ToggleableState;", "(ZLandroidx/compose/ui/state/ToggleableState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/CheckboxColors;Landroidx/compose/runtime/Composer;I)V", "TriStateCheckbox", "state", "onClick", "Lkotlin/Function0;", "(Landroidx/compose/ui/state/ToggleableState;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/CheckboxColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "drawBox", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "boxColor", "Landroidx/compose/ui/graphics/Color;", "borderColor", "radius", "", "strokeWidth", "drawBox-1wkBAMs", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJFF)V", "drawCheck", "checkColor", "checkFraction", "crossCenterGravitation", "strokeWidthPx", "drawingCache", "Landroidx/compose/material3/CheckDrawingCache;", "drawCheck-3IgeMak", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFFFLandroidx/compose/material3/CheckDrawingCache;)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class CheckboxKt {
    private static final int BoxInDuration = 50;
    private static final int BoxOutDuration = 100;
    private static final int CheckAnimationDuration = 100;
    private static final float CheckboxDefaultPadding;
    private static final float CheckboxSize = Dp.constructor-impl(20);
    private static final float RadiusSize;
    private static final float StrokeWidth;

    /* compiled from: Checkbox.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToggleableState.values().length];
            try {
                iArr[ToggleableState.On.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ToggleableState.Off.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ToggleableState.Indeterminate.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Checkbox(final boolean z, final Function1<? super Boolean, Unit> function1, Modifier modifier, boolean z2, CheckboxColors checkboxColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z3;
        CheckboxColors checkboxColors2;
        int i5;
        MutableInteractionSource mutableInteractionSource2;
        MutableInteractionSource mutableInteractionSource3;
        boolean z4;
        CheckboxColors checkboxColors3;
        Function0 function0;
        final boolean z5;
        final CheckboxColors checkboxColors4;
        final MutableInteractionSource mutableInteractionSource4;
        ScopeUpdateScope endRestartGroup;
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(-1406741137);
        ComposerKt.sourceInformation(startRestartGroup, "C(Checkbox)P(!1,5,4,2)92@4242L8,93@4302L39,95@4350L328:Checkbox.kt#uh7d8r");
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
        int i7 = i2 & 4;
        if (i7 != 0) {
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
                        checkboxColors2 = checkboxColors;
                        if (startRestartGroup.changed(checkboxColors2)) {
                            i6 = Fields.Clip;
                            i3 |= i6;
                        }
                    } else {
                        checkboxColors2 = checkboxColors;
                    }
                    i6 = Fields.Shape;
                    i3 |= i6;
                } else {
                    checkboxColors2 = checkboxColors;
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
                            if (i7 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                checkboxColors2 = CheckboxDefaults.INSTANCE.colors(startRestartGroup, 6);
                            }
                            if (i5 != 0) {
                                startRestartGroup.startReplaceableGroup(1557792488);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Checkbox.kt#9igjgp");
                                Object rememberedValue = startRestartGroup.rememberedValue();
                                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                startRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) rememberedValue;
                                z4 = z3;
                                checkboxColors3 = checkboxColors2;
                                Modifier modifier3 = modifier2;
                                int i8 = i3;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1406741137, i8, -1, "androidx.compose.material3.Checkbox (Checkbox.kt:94)");
                                }
                                ToggleableState ToggleableState = ToggleableStateKt.ToggleableState(z);
                                startRestartGroup.startReplaceableGroup(1557792614);
                                ComposerKt.sourceInformation(startRestartGroup, "98@4471L29");
                                if (function1 != null) {
                                    startRestartGroup.startReplaceableGroup(1557792657);
                                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Checkbox.kt#9igjgp");
                                    boolean z6 = ((i8 & 112) == 32) | ((i8 & 14) == 4);
                                    Object rememberedValue2 = startRestartGroup.rememberedValue();
                                    if (z6 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.CheckboxKt$Checkbox$2$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(0);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke() {
                                                m2303invoke();
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke, reason: collision with other method in class */
                                            public final void m2303invoke() {
                                                function1.invoke(Boolean.valueOf(!z));
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue2);
                                    }
                                    function0 = (Function0) rememberedValue2;
                                    startRestartGroup.endReplaceableGroup();
                                } else {
                                    function0 = null;
                                }
                                startRestartGroup.endReplaceableGroup();
                                TriStateCheckbox(ToggleableState, function0, modifier3, z4, checkboxColors3, mutableInteractionSource3, startRestartGroup, (i8 & 896) | (i8 & 7168) | (57344 & i8) | (i8 & 458752), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier2 = modifier3;
                                z5 = z4;
                                checkboxColors4 = checkboxColors3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                        }
                        z4 = z3;
                        checkboxColors3 = checkboxColors2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        Modifier modifier32 = modifier2;
                        int i82 = i3;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        ToggleableState ToggleableState2 = ToggleableStateKt.ToggleableState(z);
                        startRestartGroup.startReplaceableGroup(1557792614);
                        ComposerKt.sourceInformation(startRestartGroup, "98@4471L29");
                        if (function1 != null) {
                        }
                        startRestartGroup.endReplaceableGroup();
                        TriStateCheckbox(ToggleableState2, function0, modifier32, z4, checkboxColors3, mutableInteractionSource3, startRestartGroup, (i82 & 896) | (i82 & 7168) | (57344 & i82) | (i82 & 458752), 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier2 = modifier32;
                        z5 = z4;
                        checkboxColors4 = checkboxColors3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        z5 = z3;
                        checkboxColors4 = checkboxColors2;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        final Modifier modifier4 = modifier2;
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.CheckboxKt$Checkbox$3
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

                            public final void invoke(Composer composer2, int i9) {
                                CheckboxKt.Checkbox(z, function1, modifier4, z5, checkboxColors4, mutableInteractionSource4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
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
                if (i7 != 0) {
                }
                if (i4 != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                if (i5 != 0) {
                }
                z4 = z3;
                checkboxColors3 = checkboxColors2;
                mutableInteractionSource3 = mutableInteractionSource2;
                Modifier modifier322 = modifier2;
                int i822 = i3;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                ToggleableState ToggleableState22 = ToggleableStateKt.ToggleableState(z);
                startRestartGroup.startReplaceableGroup(1557792614);
                ComposerKt.sourceInformation(startRestartGroup, "98@4471L29");
                if (function1 != null) {
                }
                startRestartGroup.endReplaceableGroup();
                TriStateCheckbox(ToggleableState22, function0, modifier322, z4, checkboxColors3, mutableInteractionSource3, startRestartGroup, (i822 & 896) | (i822 & 7168) | (57344 & i822) | (i822 & 458752), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier2 = modifier322;
                z5 = z4;
                checkboxColors4 = checkboxColors3;
                mutableInteractionSource4 = mutableInteractionSource3;
                endRestartGroup = startRestartGroup.endRestartGroup();
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
            if (i7 != 0) {
            }
            if (i4 != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            if (i5 != 0) {
            }
            z4 = z3;
            checkboxColors3 = checkboxColors2;
            mutableInteractionSource3 = mutableInteractionSource2;
            Modifier modifier3222 = modifier2;
            int i8222 = i3;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            ToggleableState ToggleableState222 = ToggleableStateKt.ToggleableState(z);
            startRestartGroup.startReplaceableGroup(1557792614);
            ComposerKt.sourceInformation(startRestartGroup, "98@4471L29");
            if (function1 != null) {
            }
            startRestartGroup.endReplaceableGroup();
            TriStateCheckbox(ToggleableState222, function0, modifier3222, z4, checkboxColors3, mutableInteractionSource3, startRestartGroup, (i8222 & 896) | (i8222 & 7168) | (57344 & i8222) | (i8222 & 458752), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier2 = modifier3222;
            z5 = z4;
            checkboxColors4 = checkboxColors3;
            mutableInteractionSource4 = mutableInteractionSource3;
            endRestartGroup = startRestartGroup.endRestartGroup();
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
        if (i7 != 0) {
        }
        if (i4 != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if (i5 != 0) {
        }
        z4 = z3;
        checkboxColors3 = checkboxColors2;
        mutableInteractionSource3 = mutableInteractionSource2;
        Modifier modifier32222 = modifier2;
        int i82222 = i3;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        ToggleableState ToggleableState2222 = ToggleableStateKt.ToggleableState(z);
        startRestartGroup.startReplaceableGroup(1557792614);
        ComposerKt.sourceInformation(startRestartGroup, "98@4471L29");
        if (function1 != null) {
        }
        startRestartGroup.endReplaceableGroup();
        TriStateCheckbox(ToggleableState2222, function0, modifier32222, z4, checkboxColors3, mutableInteractionSource3, startRestartGroup, (i82222 & 896) | (i82222 & 7168) | (57344 & i82222) | (i82222 & 458752), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier2 = modifier32222;
        z5 = z4;
        checkboxColors4 = checkboxColors3;
        mutableInteractionSource4 = mutableInteractionSource3;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TriStateCheckbox(final ToggleableState toggleableState, final Function0<Unit> function0, Modifier modifier, boolean z, CheckboxColors checkboxColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        CheckboxColors checkboxColors2;
        int i5;
        MutableInteractionSource mutableInteractionSource2;
        boolean z3;
        CheckboxColors checkboxColors3;
        MutableInteractionSource mutableInteractionSource3;
        int i6;
        int i7;
        Modifier modifier3;
        Composer composer2;
        Modifier.Companion companion;
        final Modifier modifier4;
        final boolean z4;
        final CheckboxColors checkboxColors4;
        final MutableInteractionSource mutableInteractionSource4;
        ScopeUpdateScope endRestartGroup;
        int i8;
        Composer startRestartGroup = composer.startRestartGroup(-1608358065);
        ComposerKt.sourceInformation(startRestartGroup, "C(TriStateCheckbox)P(5,4,3,1)142@6635L8,143@6695L39,162@7339L412:Checkbox.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(toggleableState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        int i9 = i2 & 4;
        if (i9 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? Fields.RotationX : Fields.SpotShadowColor;
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? Fields.CameraDistance : Fields.RotationZ;
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        checkboxColors2 = checkboxColors;
                        if (startRestartGroup.changed(checkboxColors2)) {
                            i8 = Fields.Clip;
                            i3 |= i8;
                        }
                    } else {
                        checkboxColors2 = checkboxColors;
                    }
                    i8 = Fields.Shape;
                    i3 |= i8;
                } else {
                    checkboxColors2 = checkboxColors;
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
                            Modifier.Companion companion2 = i9 == 0 ? Modifier.INSTANCE : modifier2;
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                checkboxColors2 = CheckboxDefaults.INSTANCE.colors(startRestartGroup, 6);
                            }
                            if (i5 == 0) {
                                startRestartGroup.startReplaceableGroup(1797978171);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Checkbox.kt#9igjgp");
                                Object rememberedValue = startRestartGroup.rememberedValue();
                                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                startRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) rememberedValue;
                                z3 = z2;
                                checkboxColors3 = checkboxColors2;
                                modifier2 = companion2;
                            } else {
                                modifier2 = companion2;
                                z3 = z2;
                                checkboxColors3 = checkboxColors2;
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            i6 = i3;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            i6 = i3;
                            z3 = z2;
                            checkboxColors3 = checkboxColors2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1608358065, i6, -1, "androidx.compose.material3.TriStateCheckbox (Checkbox.kt:144)");
                        }
                        startRestartGroup.startReplaceableGroup(1797978252);
                        ComposerKt.sourceInformation(startRestartGroup, "154@7139L133");
                        if (function0 == null) {
                            i7 = i6;
                            modifier3 = modifier2;
                            composer2 = startRestartGroup;
                            companion = ToggleableKt.m1446triStateToggleableO2vRcR0(Modifier.INSTANCE, toggleableState, mutableInteractionSource3, RippleKt.m2177rememberRipple9IZ8Weo(false, Dp.constructor-impl(CheckboxTokens.INSTANCE.m3427getStateLayerSizeD9Ej5fM() / 2), 0L, startRestartGroup, 54, 4), z3, Role.box-impl(Role.Companion.getCheckbox-o7Vup1c()), function0);
                        } else {
                            i7 = i6;
                            modifier3 = modifier2;
                            composer2 = startRestartGroup;
                            companion = Modifier.INSTANCE;
                        }
                        composer2.endReplaceableGroup();
                        CheckboxImpl(z3, toggleableState, PaddingKt.m1064padding3ABfNKs(modifier3.then(function0 == null ? InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE) : Modifier.INSTANCE).then(companion), CheckboxDefaultPadding), checkboxColors3, composer2, ((i7 >> 9) & 14) | ((i7 << 3) & 112) | ((i7 >> 3) & 7168));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier4 = modifier3;
                        z4 = z3;
                        checkboxColors4 = checkboxColors3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        modifier4 = modifier2;
                        z4 = z2;
                        checkboxColors4 = checkboxColors2;
                        composer2 = startRestartGroup;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.CheckboxKt$TriStateCheckbox$2
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i10) {
                                CheckboxKt.TriStateCheckbox(toggleableState, function0, modifier4, z4, checkboxColors4, mutableInteractionSource4, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
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
                if (i9 == 0) {
                }
                if (i4 != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                if (i5 == 0) {
                }
                i6 = i3;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup.startReplaceableGroup(1797978252);
                ComposerKt.sourceInformation(startRestartGroup, "154@7139L133");
                if (function0 == null) {
                }
                composer2.endReplaceableGroup();
                CheckboxImpl(z3, toggleableState, PaddingKt.m1064padding3ABfNKs(modifier3.then(function0 == null ? InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE) : Modifier.INSTANCE).then(companion), CheckboxDefaultPadding), checkboxColors3, composer2, ((i7 >> 9) & 14) | ((i7 << 3) & 112) | ((i7 >> 3) & 7168));
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier4 = modifier3;
                z4 = z3;
                checkboxColors4 = checkboxColors3;
                mutableInteractionSource4 = mutableInteractionSource3;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z2 = z;
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
            if (i9 == 0) {
            }
            if (i4 != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            if (i5 == 0) {
            }
            i6 = i3;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceableGroup(1797978252);
            ComposerKt.sourceInformation(startRestartGroup, "154@7139L133");
            if (function0 == null) {
            }
            composer2.endReplaceableGroup();
            CheckboxImpl(z3, toggleableState, PaddingKt.m1064padding3ABfNKs(modifier3.then(function0 == null ? InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE) : Modifier.INSTANCE).then(companion), CheckboxDefaultPadding), checkboxColors3, composer2, ((i7 >> 9) & 14) | ((i7 << 3) & 112) | ((i7 >> 3) & 7168));
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier4 = modifier3;
            z4 = z3;
            checkboxColors4 = checkboxColors3;
            mutableInteractionSource4 = mutableInteractionSource3;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z2 = z;
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
        if (i9 == 0) {
        }
        if (i4 != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if (i5 == 0) {
        }
        i6 = i3;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceableGroup(1797978252);
        ComposerKt.sourceInformation(startRestartGroup, "154@7139L133");
        if (function0 == null) {
        }
        composer2.endReplaceableGroup();
        CheckboxImpl(z3, toggleableState, PaddingKt.m1064padding3ABfNKs(modifier3.then(function0 == null ? InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE) : Modifier.INSTANCE).then(companion), CheckboxDefaultPadding), checkboxColors3, composer2, ((i7 >> 9) & 14) | ((i7 << 3) & 112) | ((i7 >> 3) & 7168));
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier4 = modifier3;
        z4 = z3;
        checkboxColors4 = checkboxColors3;
        mutableInteractionSource4 = mutableInteractionSource3;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0207  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void CheckboxImpl(final boolean z, final ToggleableState toggleableState, final Modifier modifier, final CheckboxColors checkboxColors, Composer composer, final int i) {
        int i2;
        float f;
        int i3;
        float f2;
        int i4;
        float f3;
        int i5;
        Object rememberedValue;
        boolean changed;
        Object rememberedValue2;
        Composer startRestartGroup = composer.startRestartGroup(2007131616);
        ComposerKt.sourceInformation(startRestartGroup, "C(CheckboxImpl)P(1,3,2)264@12013L23,265@12076L443,281@12578L458,296@13058L32,297@13119L21,298@13167L24,299@13221L27,304@13371L538,300@13253L656:Checkbox.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(toggleableState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(modifier) ? Fields.RotationX : Fields.SpotShadowColor;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changed(checkboxColors) ? Fields.CameraDistance : Fields.RotationZ;
        }
        int i6 = i2;
        if ((i6 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2007131616, i6, -1, "androidx.compose.material3.CheckboxImpl (Checkbox.kt:263)");
            }
            int i7 = i6 >> 3;
            int i8 = i7 & 14;
            Transition updateTransition = TransitionKt.updateTransition(toggleableState, (String) null, startRestartGroup, i8, 2);
            CheckboxKt$CheckboxImpl$checkDrawFraction$1 checkboxKt$CheckboxImpl$checkDrawFraction$1 = new Function3<Transition.Segment<ToggleableState>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.CheckboxKt$CheckboxImpl$checkDrawFraction$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    return invoke((Transition.Segment<ToggleableState>) obj, (Composer) obj2, ((Number) obj3).intValue());
                }

                public final FiniteAnimationSpec<Float> invoke(Transition.Segment<ToggleableState> segment, Composer composer2, int i9) {
                    SpringSpec snap;
                    composer2.startReplaceableGroup(1373301606);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1373301606, i9, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:267)");
                    }
                    if (segment.getInitialState() == ToggleableState.Off) {
                        snap = AnimationSpecKt.tween$default(100, 0, null, 6, null);
                    } else {
                        snap = segment.getTargetState() == ToggleableState.Off ? AnimationSpecKt.snap(100) : AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2.endReplaceableGroup();
                    return snap;
                }
            };
            startRestartGroup.startReplaceableGroup(-1338768149);
            ComposerKt.sourceInformation(startRestartGroup, "CC(animateFloat)P(2)1165@46369L78:Transition.kt#pdpnli");
            TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            startRestartGroup.startReplaceableGroup(-142660079);
            ComposerKt.sourceInformation(startRestartGroup, "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli");
            ToggleableState toggleableState2 = (ToggleableState) updateTransition.getCurrentState();
            startRestartGroup.startReplaceableGroup(1800065638);
            ComposerKt.sourceInformation(startRestartGroup, "C:Checkbox.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1800065638, 0, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:274)");
            }
            int i9 = WhenMappings.$EnumSwitchMapping$0[toggleableState2.ordinal()];
            float f4 = 0.0f;
            if (i9 != 1) {
                if (i9 == 2) {
                    f = 0.0f;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    startRestartGroup.endReplaceableGroup();
                    Float valueOf = Float.valueOf(f);
                    ToggleableState toggleableState3 = (ToggleableState) updateTransition.getTargetState();
                    startRestartGroup.startReplaceableGroup(1800065638);
                    ComposerKt.sourceInformation(startRestartGroup, "C:Checkbox.kt#uh7d8r");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1800065638, 0, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:274)");
                    }
                    i3 = WhenMappings.$EnumSwitchMapping$0[toggleableState3.ordinal()];
                    if (i3 != 1) {
                        if (i3 == 2) {
                            f2 = 0.0f;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            startRestartGroup.endReplaceableGroup();
                            final State createTransitionAnimation = TransitionKt.createTransitionAnimation(updateTransition, valueOf, Float.valueOf(f2), (FiniteAnimationSpec) checkboxKt$CheckboxImpl$checkDrawFraction$1.invoke(updateTransition.getSegment(), startRestartGroup, 0), vectorConverter, "FloatAnimation", startRestartGroup, 0);
                            startRestartGroup.endReplaceableGroup();
                            startRestartGroup.endReplaceableGroup();
                            CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$1 checkboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$1 = new Function3<Transition.Segment<ToggleableState>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$1
                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                    return invoke((Transition.Segment<ToggleableState>) obj, (Composer) obj2, ((Number) obj3).intValue());
                                }

                                public final FiniteAnimationSpec<Float> invoke(Transition.Segment<ToggleableState> segment, Composer composer2, int i10) {
                                    TweenSpec snap;
                                    composer2.startReplaceableGroup(-1324481169);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1324481169, i10, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:283)");
                                    }
                                    if (segment.getInitialState() == ToggleableState.Off) {
                                        snap = AnimationSpecKt.snap$default(0, 1, null);
                                    } else {
                                        snap = segment.getTargetState() == ToggleableState.Off ? AnimationSpecKt.snap(100) : AnimationSpecKt.tween$default(100, 0, null, 6, null);
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    composer2.endReplaceableGroup();
                                    return snap;
                                }
                            };
                            startRestartGroup.startReplaceableGroup(-1338768149);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(animateFloat)P(2)1165@46369L78:Transition.kt#pdpnli");
                            TwoWayConverter<Float, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
                            startRestartGroup.startReplaceableGroup(-142660079);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli");
                            ToggleableState toggleableState4 = (ToggleableState) updateTransition.getCurrentState();
                            startRestartGroup.startReplaceableGroup(-1426969489);
                            ComposerKt.sourceInformation(startRestartGroup, "C:Checkbox.kt#uh7d8r");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1426969489, 0, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:290)");
                            }
                            i4 = WhenMappings.$EnumSwitchMapping$0[toggleableState4.ordinal()];
                            if (i4 != 1 || i4 == 2) {
                                f3 = 0.0f;
                            } else {
                                if (i4 != 3) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                f3 = 1.0f;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            startRestartGroup.endReplaceableGroup();
                            Float valueOf2 = Float.valueOf(f3);
                            ToggleableState toggleableState5 = (ToggleableState) updateTransition.getTargetState();
                            startRestartGroup.startReplaceableGroup(-1426969489);
                            ComposerKt.sourceInformation(startRestartGroup, "C:Checkbox.kt#uh7d8r");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1426969489, 0, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:290)");
                            }
                            i5 = WhenMappings.$EnumSwitchMapping$0[toggleableState5.ordinal()];
                            if (i5 != 1 && i5 != 2) {
                                if (i5 == 3) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                f4 = 1.0f;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            startRestartGroup.endReplaceableGroup();
                            final State createTransitionAnimation2 = TransitionKt.createTransitionAnimation(updateTransition, valueOf2, Float.valueOf(f4), (FiniteAnimationSpec) checkboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$1.invoke(updateTransition.getSegment(), startRestartGroup, 0), vectorConverter2, "FloatAnimation", startRestartGroup, 0);
                            startRestartGroup.endReplaceableGroup();
                            startRestartGroup.endReplaceableGroup();
                            startRestartGroup.startReplaceableGroup(-661291556);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Checkbox.kt#9igjgp");
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = new CheckDrawingCache(null, null, null, 7, null);
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            final CheckDrawingCache checkDrawingCache = (CheckDrawingCache) rememberedValue;
                            startRestartGroup.endReplaceableGroup();
                            final State<Color> checkmarkColor$material3_release = checkboxColors.checkmarkColor$material3_release(toggleableState, startRestartGroup, i8 | ((i6 >> 6) & 112));
                            int i10 = (i7 & 896) | (i6 & 14) | (i6 & 112);
                            final State<Color> boxColor$material3_release = checkboxColors.boxColor$material3_release(z, toggleableState, startRestartGroup, i10);
                            final State<Color> borderColor$material3_release = checkboxColors.borderColor$material3_release(z, toggleableState, startRestartGroup, i10);
                            Modifier m1112requiredSize3ABfNKs = SizeKt.m1112requiredSize3ABfNKs(SizeKt.wrapContentSize$default(modifier, Alignment.INSTANCE.getCenter(), false, 2, null), CheckboxSize);
                            startRestartGroup.startReplaceableGroup(-661291243);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Checkbox.kt#9igjgp");
                            changed = startRestartGroup.changed(boxColor$material3_release) | startRestartGroup.changed(borderColor$material3_release) | startRestartGroup.changed(checkmarkColor$material3_release) | startRestartGroup.changed(createTransitionAnimation) | startRestartGroup.changed(createTransitionAnimation2);
                            rememberedValue2 = startRestartGroup.rememberedValue();
                            if (!changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue2 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.CheckboxKt$CheckboxImpl$1$1
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
                                        float f5;
                                        float f6;
                                        f5 = CheckboxKt.StrokeWidth;
                                        float floor = (float) Math.floor(drawScope.toPx-0680j_4(f5));
                                        long m4849unboximpl = boxColor$material3_release.getValue().m4849unboximpl();
                                        long m4849unboximpl2 = borderColor$material3_release.getValue().m4849unboximpl();
                                        f6 = CheckboxKt.RadiusSize;
                                        CheckboxKt.m2301drawBox1wkBAMs(drawScope, m4849unboximpl, m4849unboximpl2, drawScope.toPx-0680j_4(f6), floor);
                                        CheckboxKt.m2302drawCheck3IgeMak(drawScope, checkmarkColor$material3_release.getValue().m4849unboximpl(), createTransitionAnimation.getValue().floatValue(), createTransitionAnimation2.getValue().floatValue(), floor, checkDrawingCache);
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue2);
                            }
                            startRestartGroup.endReplaceableGroup();
                            CanvasKt.Canvas(m1112requiredSize3ABfNKs, (Function1) rememberedValue2, startRestartGroup, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        } else if (i3 != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                    f2 = 1.0f;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    final State<Float> createTransitionAnimation3 = TransitionKt.createTransitionAnimation(updateTransition, valueOf, Float.valueOf(f2), (FiniteAnimationSpec) checkboxKt$CheckboxImpl$checkDrawFraction$1.invoke(updateTransition.getSegment(), startRestartGroup, 0), vectorConverter, "FloatAnimation", startRestartGroup, 0);
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$1 checkboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$12 = new Function3<Transition.Segment<ToggleableState>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                            return invoke((Transition.Segment<ToggleableState>) obj, (Composer) obj2, ((Number) obj3).intValue());
                        }

                        public final FiniteAnimationSpec<Float> invoke(Transition.Segment<ToggleableState> segment, Composer composer2, int i102) {
                            TweenSpec snap;
                            composer2.startReplaceableGroup(-1324481169);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1324481169, i102, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:283)");
                            }
                            if (segment.getInitialState() == ToggleableState.Off) {
                                snap = AnimationSpecKt.snap$default(0, 1, null);
                            } else {
                                snap = segment.getTargetState() == ToggleableState.Off ? AnimationSpecKt.snap(100) : AnimationSpecKt.tween$default(100, 0, null, 6, null);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer2.endReplaceableGroup();
                            return snap;
                        }
                    };
                    startRestartGroup.startReplaceableGroup(-1338768149);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(animateFloat)P(2)1165@46369L78:Transition.kt#pdpnli");
                    TwoWayConverter<Float, AnimationVector1D> vectorConverter22 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
                    startRestartGroup.startReplaceableGroup(-142660079);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli");
                    ToggleableState toggleableState42 = (ToggleableState) updateTransition.getCurrentState();
                    startRestartGroup.startReplaceableGroup(-1426969489);
                    ComposerKt.sourceInformation(startRestartGroup, "C:Checkbox.kt#uh7d8r");
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    i4 = WhenMappings.$EnumSwitchMapping$0[toggleableState42.ordinal()];
                    if (i4 != 1) {
                    }
                    f3 = 0.0f;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    Float valueOf22 = Float.valueOf(f3);
                    ToggleableState toggleableState52 = (ToggleableState) updateTransition.getTargetState();
                    startRestartGroup.startReplaceableGroup(-1426969489);
                    ComposerKt.sourceInformation(startRestartGroup, "C:Checkbox.kt#uh7d8r");
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    i5 = WhenMappings.$EnumSwitchMapping$0[toggleableState52.ordinal()];
                    if (i5 != 1) {
                        if (i5 == 3) {
                        }
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    final State<Float> createTransitionAnimation22 = TransitionKt.createTransitionAnimation(updateTransition, valueOf22, Float.valueOf(f4), (FiniteAnimationSpec) checkboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$12.invoke(updateTransition.getSegment(), startRestartGroup, 0), vectorConverter22, "FloatAnimation", startRestartGroup, 0);
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.startReplaceableGroup(-661291556);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Checkbox.kt#9igjgp");
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                    }
                    final CheckDrawingCache checkDrawingCache2 = (CheckDrawingCache) rememberedValue;
                    startRestartGroup.endReplaceableGroup();
                    final State<Color> checkmarkColor$material3_release2 = checkboxColors.checkmarkColor$material3_release(toggleableState, startRestartGroup, i8 | ((i6 >> 6) & 112));
                    int i102 = (i7 & 896) | (i6 & 14) | (i6 & 112);
                    final State<Color> boxColor$material3_release2 = checkboxColors.boxColor$material3_release(z, toggleableState, startRestartGroup, i102);
                    final State<Color> borderColor$material3_release2 = checkboxColors.borderColor$material3_release(z, toggleableState, startRestartGroup, i102);
                    Modifier m1112requiredSize3ABfNKs2 = SizeKt.m1112requiredSize3ABfNKs(SizeKt.wrapContentSize$default(modifier, Alignment.INSTANCE.getCenter(), false, 2, null), CheckboxSize);
                    startRestartGroup.startReplaceableGroup(-661291243);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Checkbox.kt#9igjgp");
                    changed = startRestartGroup.changed(boxColor$material3_release2) | startRestartGroup.changed(borderColor$material3_release2) | startRestartGroup.changed(checkmarkColor$material3_release2) | startRestartGroup.changed(createTransitionAnimation3) | startRestartGroup.changed(createTransitionAnimation22);
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (!changed) {
                    }
                    rememberedValue2 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.CheckboxKt$CheckboxImpl$1$1
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
                            float f5;
                            float f6;
                            f5 = CheckboxKt.StrokeWidth;
                            float floor = (float) Math.floor(drawScope.toPx-0680j_4(f5));
                            long m4849unboximpl = boxColor$material3_release2.getValue().m4849unboximpl();
                            long m4849unboximpl2 = borderColor$material3_release2.getValue().m4849unboximpl();
                            f6 = CheckboxKt.RadiusSize;
                            CheckboxKt.m2301drawBox1wkBAMs(drawScope, m4849unboximpl, m4849unboximpl2, drawScope.toPx-0680j_4(f6), floor);
                            CheckboxKt.m2302drawCheck3IgeMak(drawScope, checkmarkColor$material3_release2.getValue().m4849unboximpl(), createTransitionAnimation3.getValue().floatValue(), createTransitionAnimation22.getValue().floatValue(), floor, checkDrawingCache2);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                    startRestartGroup.endReplaceableGroup();
                    CanvasKt.Canvas(m1112requiredSize3ABfNKs2, (Function1) rememberedValue2, startRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                } else if (i9 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
            }
            f = 1.0f;
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.endReplaceableGroup();
            Float valueOf3 = Float.valueOf(f);
            ToggleableState toggleableState32 = (ToggleableState) updateTransition.getTargetState();
            startRestartGroup.startReplaceableGroup(1800065638);
            ComposerKt.sourceInformation(startRestartGroup, "C:Checkbox.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
            }
            i3 = WhenMappings.$EnumSwitchMapping$0[toggleableState32.ordinal()];
            if (i3 != 1) {
            }
            f2 = 1.0f;
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.endReplaceableGroup();
            final State<Float> createTransitionAnimation32 = TransitionKt.createTransitionAnimation(updateTransition, valueOf3, Float.valueOf(f2), (FiniteAnimationSpec) checkboxKt$CheckboxImpl$checkDrawFraction$1.invoke(updateTransition.getSegment(), startRestartGroup, 0), vectorConverter, "FloatAnimation", startRestartGroup, 0);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$1 checkboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$122 = new Function3<Transition.Segment<ToggleableState>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.CheckboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    return invoke((Transition.Segment<ToggleableState>) obj, (Composer) obj2, ((Number) obj3).intValue());
                }

                public final FiniteAnimationSpec<Float> invoke(Transition.Segment<ToggleableState> segment, Composer composer2, int i1022) {
                    TweenSpec snap;
                    composer2.startReplaceableGroup(-1324481169);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1324481169, i1022, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:283)");
                    }
                    if (segment.getInitialState() == ToggleableState.Off) {
                        snap = AnimationSpecKt.snap$default(0, 1, null);
                    } else {
                        snap = segment.getTargetState() == ToggleableState.Off ? AnimationSpecKt.snap(100) : AnimationSpecKt.tween$default(100, 0, null, 6, null);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2.endReplaceableGroup();
                    return snap;
                }
            };
            startRestartGroup.startReplaceableGroup(-1338768149);
            ComposerKt.sourceInformation(startRestartGroup, "CC(animateFloat)P(2)1165@46369L78:Transition.kt#pdpnli");
            TwoWayConverter<Float, AnimationVector1D> vectorConverter222 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            startRestartGroup.startReplaceableGroup(-142660079);
            ComposerKt.sourceInformation(startRestartGroup, "CC(animateValue)P(3,2)1082@42932L32,1083@42987L31,1084@43043L23,1086@43079L89:Transition.kt#pdpnli");
            ToggleableState toggleableState422 = (ToggleableState) updateTransition.getCurrentState();
            startRestartGroup.startReplaceableGroup(-1426969489);
            ComposerKt.sourceInformation(startRestartGroup, "C:Checkbox.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
            }
            i4 = WhenMappings.$EnumSwitchMapping$0[toggleableState422.ordinal()];
            if (i4 != 1) {
            }
            f3 = 0.0f;
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.endReplaceableGroup();
            Float valueOf222 = Float.valueOf(f3);
            ToggleableState toggleableState522 = (ToggleableState) updateTransition.getTargetState();
            startRestartGroup.startReplaceableGroup(-1426969489);
            ComposerKt.sourceInformation(startRestartGroup, "C:Checkbox.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
            }
            i5 = WhenMappings.$EnumSwitchMapping$0[toggleableState522.ordinal()];
            if (i5 != 1) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.endReplaceableGroup();
            final State<Float> createTransitionAnimation222 = TransitionKt.createTransitionAnimation(updateTransition, valueOf222, Float.valueOf(f4), (FiniteAnimationSpec) checkboxKt$CheckboxImpl$checkCenterGravitationShiftFraction$122.invoke(updateTransition.getSegment(), startRestartGroup, 0), vectorConverter222, "FloatAnimation", startRestartGroup, 0);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-661291556);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Checkbox.kt#9igjgp");
            rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            }
            final CheckDrawingCache checkDrawingCache22 = (CheckDrawingCache) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            final State<Color> checkmarkColor$material3_release22 = checkboxColors.checkmarkColor$material3_release(toggleableState, startRestartGroup, i8 | ((i6 >> 6) & 112));
            int i1022 = (i7 & 896) | (i6 & 14) | (i6 & 112);
            final State<Color> boxColor$material3_release22 = checkboxColors.boxColor$material3_release(z, toggleableState, startRestartGroup, i1022);
            final State<Color> borderColor$material3_release22 = checkboxColors.borderColor$material3_release(z, toggleableState, startRestartGroup, i1022);
            Modifier m1112requiredSize3ABfNKs22 = SizeKt.m1112requiredSize3ABfNKs(SizeKt.wrapContentSize$default(modifier, Alignment.INSTANCE.getCenter(), false, 2, null), CheckboxSize);
            startRestartGroup.startReplaceableGroup(-661291243);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Checkbox.kt#9igjgp");
            changed = startRestartGroup.changed(boxColor$material3_release22) | startRestartGroup.changed(borderColor$material3_release22) | startRestartGroup.changed(checkmarkColor$material3_release22) | startRestartGroup.changed(createTransitionAnimation32) | startRestartGroup.changed(createTransitionAnimation222);
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue2 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.CheckboxKt$CheckboxImpl$1$1
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
                    float f5;
                    float f6;
                    f5 = CheckboxKt.StrokeWidth;
                    float floor = (float) Math.floor(drawScope.toPx-0680j_4(f5));
                    long m4849unboximpl = boxColor$material3_release22.getValue().m4849unboximpl();
                    long m4849unboximpl2 = borderColor$material3_release22.getValue().m4849unboximpl();
                    f6 = CheckboxKt.RadiusSize;
                    CheckboxKt.m2301drawBox1wkBAMs(drawScope, m4849unboximpl, m4849unboximpl2, drawScope.toPx-0680j_4(f6), floor);
                    CheckboxKt.m2302drawCheck3IgeMak(drawScope, checkmarkColor$material3_release22.getValue().m4849unboximpl(), createTransitionAnimation32.getValue().floatValue(), createTransitionAnimation222.getValue().floatValue(), floor, checkDrawingCache22);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue2);
            startRestartGroup.endReplaceableGroup();
            CanvasKt.Canvas(m1112requiredSize3ABfNKs22, (Function1) rememberedValue2, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.CheckboxKt$CheckboxImpl$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i11) {
                    CheckboxKt.CheckboxImpl(z, toggleableState, modifier, checkboxColors, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawBox-1wkBAMs, reason: not valid java name */
    public static final void m2301drawBox1wkBAMs(DrawScope drawScope, long j, long j2, float f, float f2) {
        float f3 = f2 / 2.0f;
        Stroke stroke = new Stroke(f2, 0.0f, 0, 0, null, 30, null);
        float m4662getWidthimpl = Size.m4662getWidthimpl(drawScope.m5417getSizeNHjbRc());
        if (Color.m4840equalsimpl0(j, j2)) {
            DrawScope.m5413drawRoundRectuAw5IA$default(drawScope, j, 0L, androidx.compose.p002ui.geometry.SizeKt.Size(m4662getWidthimpl, m4662getWidthimpl), CornerRadiusKt.CornerRadius$default(f, 0.0f, 2, null), Fill.INSTANCE, 0.0f, null, 0, 226, null);
            return;
        }
        float f4 = m4662getWidthimpl - (2 * f2);
        DrawScope.m5413drawRoundRectuAw5IA$default(drawScope, j, OffsetKt.Offset(f2, f2), androidx.compose.p002ui.geometry.SizeKt.Size(f4, f4), CornerRadiusKt.CornerRadius$default(Math.max(0.0f, f - f2), 0.0f, 2, null), Fill.INSTANCE, 0.0f, null, 0, 224, null);
        float f5 = m4662getWidthimpl - f2;
        DrawScope.m5413drawRoundRectuAw5IA$default(drawScope, j2, OffsetKt.Offset(f3, f3), androidx.compose.p002ui.geometry.SizeKt.Size(f5, f5), CornerRadiusKt.CornerRadius$default(f - f3, 0.0f, 2, null), stroke, 0.0f, null, 0, 224, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawCheck-3IgeMak, reason: not valid java name */
    public static final void m2302drawCheck3IgeMak(DrawScope drawScope, long j, float f, float f2, float f3, CheckDrawingCache checkDrawingCache) {
        Stroke stroke = new Stroke(f3, 0.0f, StrokeCap.INSTANCE.m5213getSquareKaPHkGw(), 0, null, 26, null);
        float m4662getWidthimpl = Size.m4662getWidthimpl(drawScope.m5417getSizeNHjbRc());
        float lerp = MathHelpersKt.lerp(0.4f, 0.5f, f2);
        float lerp2 = MathHelpersKt.lerp(0.7f, 0.5f, f2);
        float lerp3 = MathHelpersKt.lerp(0.5f, 0.5f, f2);
        float lerp4 = MathHelpersKt.lerp(0.3f, 0.5f, f2);
        checkDrawingCache.getCheckPath().reset();
        checkDrawingCache.getCheckPath().moveTo(0.2f * m4662getWidthimpl, lerp3 * m4662getWidthimpl);
        checkDrawingCache.getCheckPath().lineTo(lerp * m4662getWidthimpl, lerp2 * m4662getWidthimpl);
        checkDrawingCache.getCheckPath().lineTo(0.8f * m4662getWidthimpl, m4662getWidthimpl * lerp4);
        checkDrawingCache.getPathMeasure().setPath(checkDrawingCache.getCheckPath(), false);
        checkDrawingCache.getPathToDraw().reset();
        checkDrawingCache.getPathMeasure().getSegment(0.0f, checkDrawingCache.getPathMeasure().getLength() * f, checkDrawingCache.getPathToDraw(), true);
        DrawScope.m5407drawPathLG529CI$default(drawScope, checkDrawingCache.getPathToDraw(), j, 0.0f, stroke, null, 0, 52, null);
    }

    static {
        float f = 2;
        CheckboxDefaultPadding = Dp.constructor-impl(f);
        StrokeWidth = Dp.constructor-impl(f);
        RadiusSize = Dp.constructor-impl(f);
    }
}
