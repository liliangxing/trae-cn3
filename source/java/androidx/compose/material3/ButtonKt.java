package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.p002ui.Alignment;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.graphics.Shape;
import androidx.compose.p002ui.layout.LayoutKt;
import androidx.compose.p002ui.layout.MeasurePolicy;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Button.kt */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u008d\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u008d\u0001\u0010\u001a\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u008d\u0001\u0010\u001b\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u008d\u0001\u0010\u001c\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u008d\u0001\u0010\u001d\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019¨\u0006\u001e"}, d2 = {"Button", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/ButtonColors;", "elevation", "Landroidx/compose/material3/ButtonElevation;", "border", "Landroidx/compose/foundation/BorderStroke;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ButtonColors;Landroidx/compose/material3/ButtonElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ElevatedButton", "FilledTonalButton", "OutlinedButton", "TextButton", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class ButtonKt {
    /* JADX WARN: Removed duplicated region for block: B:100:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0196  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Button(final Function0<Unit> function0, Modifier modifier, boolean z, Shape shape, ButtonColors buttonColors, ButtonElevation buttonElevation, BorderStroke borderStroke, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        Shape shape2;
        ButtonColors buttonColors2;
        ButtonElevation buttonElevation2;
        int i5;
        int i6;
        int i7;
        int i8;
        MutableInteractionSource mutableInteractionSource2;
        Shape shape3;
        int i9;
        ButtonColors buttonColors3;
        BorderStroke borderStroke2;
        int i10;
        BorderStroke borderStroke3;
        MutableInteractionSource mutableInteractionSource3;
        final PaddingValues paddingValues2;
        int i11;
        Modifier modifier2;
        boolean z2;
        Composer composer2;
        PaddingValues paddingValues3;
        MutableInteractionSource mutableInteractionSource4;
        final Shape shape4;
        final ButtonElevation buttonElevation3;
        final boolean z3;
        BorderStroke borderStroke4;
        final Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        int i12;
        int i13;
        int i14;
        Composer startRestartGroup = composer.startRestartGroup(650121315);
        ComposerKt.sourceInformation(startRestartGroup, "C(Button)P(8,7,5,9,1,4!1,3,6)107@5444L5,108@5493L14,109@5558L17,112@5728L39,119@6094L977:Button.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i15 = i2 & 2;
        if (i15 != 0) {
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
                        shape2 = shape;
                        if (startRestartGroup.changed(shape2)) {
                            i14 = Fields.CameraDistance;
                            i3 |= i14;
                        }
                    } else {
                        shape2 = shape;
                    }
                    i14 = Fields.RotationZ;
                    i3 |= i14;
                } else {
                    shape2 = shape;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        buttonColors2 = buttonColors;
                        if (startRestartGroup.changed(buttonColors2)) {
                            i13 = Fields.Clip;
                            i3 |= i13;
                        }
                    } else {
                        buttonColors2 = buttonColors;
                    }
                    i13 = Fields.Shape;
                    i3 |= i13;
                } else {
                    buttonColors2 = buttonColors;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        buttonElevation2 = buttonElevation;
                        if (startRestartGroup.changed(buttonElevation2)) {
                            i12 = Fields.RenderEffect;
                            i3 |= i12;
                        }
                    } else {
                        buttonElevation2 = buttonElevation;
                    }
                    i12 = 65536;
                    i3 |= i12;
                } else {
                    buttonElevation2 = buttonElevation;
                }
                i5 = i2 & 64;
                if (i5 != 0) {
                    i3 |= 1572864;
                } else if ((1572864 & i) == 0) {
                    i3 |= startRestartGroup.changed(borderStroke) ? 1048576 : Fields.BlendMode;
                    i6 = i2 & Fields.SpotShadowColor;
                    if (i6 == 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        i3 |= startRestartGroup.changed(paddingValues) ? 8388608 : 4194304;
                    }
                    i7 = i2 & Fields.RotationX;
                    if (i7 == 0) {
                        i3 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        i8 = i7;
                        mutableInteractionSource2 = mutableInteractionSource;
                        i3 |= startRestartGroup.changed(mutableInteractionSource2) ? 67108864 : 33554432;
                        if ((i2 & Fields.RotationY) != 0) {
                            i3 |= 805306368;
                        } else if ((i & 805306368) == 0) {
                            i3 |= startRestartGroup.changedInstance(function3) ? 536870912 : 268435456;
                        }
                        if ((306783379 & i3) == 306783378 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                Modifier modifier4 = i15 != 0 ? Modifier.INSTANCE : modifier;
                                boolean z4 = i4 != 0 ? true : z;
                                if ((i2 & 8) != 0) {
                                    i3 &= -7169;
                                    shape3 = ButtonDefaults.INSTANCE.getShape(startRestartGroup, 6);
                                } else {
                                    shape3 = shape2;
                                }
                                if ((i2 & 16) != 0) {
                                    i9 = i3 & (-57345);
                                    buttonColors3 = ButtonDefaults.INSTANCE.buttonColors(startRestartGroup, 6);
                                } else {
                                    i9 = i3;
                                    buttonColors3 = buttonColors2;
                                }
                                if ((i2 & 32) != 0) {
                                    borderStroke2 = null;
                                    buttonElevation2 = ButtonDefaults.INSTANCE.m2251buttonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 196608, 31);
                                    i10 = i9 & (-458753);
                                } else {
                                    borderStroke2 = null;
                                    i10 = i9;
                                }
                                borderStroke3 = i5 != 0 ? borderStroke2 : borderStroke;
                                PaddingValues contentPadding = i6 != 0 ? ButtonDefaults.INSTANCE.getContentPadding() : paddingValues;
                                if (i8 != 0) {
                                    startRestartGroup.startReplaceableGroup(823568939);
                                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Button.kt#9igjgp");
                                    Object rememberedValue = startRestartGroup.rememberedValue();
                                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    i11 = i10;
                                    mutableInteractionSource3 = (MutableInteractionSource) rememberedValue;
                                    z2 = z4;
                                    shape2 = shape3;
                                    buttonColors2 = buttonColors3;
                                    paddingValues2 = contentPadding;
                                    modifier2 = modifier4;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    paddingValues2 = contentPadding;
                                    i11 = i10;
                                    modifier2 = modifier4;
                                    z2 = z4;
                                    shape2 = shape3;
                                    buttonColors2 = buttonColors3;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 8) != 0) {
                                    i3 &= -7169;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                }
                                modifier2 = modifier;
                                borderStroke3 = borderStroke;
                                paddingValues2 = paddingValues;
                                mutableInteractionSource3 = mutableInteractionSource;
                                i11 = i3;
                                z2 = z;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(650121315, i11, -1, "androidx.compose.material3.Button (Button.kt:114)");
                            }
                            long m2243containerColorvNxB06k$material3_release = buttonColors2.m2243containerColorvNxB06k$material3_release(z2);
                            final long m2244contentColorvNxB06k$material3_release = buttonColors2.m2244contentColorvNxB06k$material3_release(z2);
                            startRestartGroup.startReplaceableGroup(823569174);
                            ComposerKt.sourceInformation(startRestartGroup, "117@5963L43");
                            State<Dp> shadowElevation$material3_release = buttonElevation2 == null ? null : buttonElevation2.shadowElevation$material3_release(z2, mutableInteractionSource3, startRestartGroup, ((i11 >> 9) & 896) | ((i11 >> 6) & 14) | ((i11 >> 21) & 112));
                            startRestartGroup.endReplaceableGroup();
                            ButtonColors buttonColors4 = buttonColors2;
                            int i16 = (i11 & 14) | (i11 & 896) | (i11 & 7168) | ((i11 << 6) & 234881024) | ((i11 << 3) & 1879048192);
                            composer2 = startRestartGroup;
                            SurfaceKt.m3046Surfaceo_FOJdg(function0, SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$2
                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((SemanticsPropertyReceiver) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, Role.Companion.getButton-o7Vup1c());
                                }
                            }, 1, (Object) null), z2, shape2, m2243containerColorvNxB06k$material3_release, m2244contentColorvNxB06k$material3_release, buttonElevation2 != null ? buttonElevation2.m2262tonalElevationu2uoSUM$material3_release(z2) : Dp.constructor-impl(0), shadowElevation$material3_release != null ? shadowElevation$material3_release.getValue().unbox-impl() : Dp.constructor-impl(0), borderStroke3, mutableInteractionSource3, ComposableLambdaKt.composableLambda(startRestartGroup, 956488494, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$3
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

                                public final void invoke(Composer composer3, int i17) {
                                    ComposerKt.sourceInformation(composer3, "C133@6591L10,131@6482L583:Button.kt#uh7d8r");
                                    if ((i17 & 3) != 2 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(956488494, i17, -1, "androidx.compose.material3.Button.<anonymous> (Button.kt:131)");
                                        }
                                        long j = m2244contentColorvNxB06k$material3_release;
                                        TextStyle labelLarge = MaterialTheme.INSTANCE.getTypography(composer3, 6).getLabelLarge();
                                        final PaddingValues paddingValues4 = paddingValues2;
                                        final Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                                        ProvideContentColorTextStyleKt.m2813ProvideContentColorTextStyle3JVO9M(j, labelLarge, ComposableLambdaKt.composableLambda(composer3, 1327513942, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$3.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                invoke((Composer) obj, ((Number) obj2).intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer4, int i18) {
                                                ComposerKt.sourceInformation(composer4, "C134@6628L427:Button.kt#uh7d8r");
                                                if ((i18 & 3) != 2 || !composer4.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1327513942, i18, -1, "androidx.compose.material3.Button.<anonymous>.<anonymous> (Button.kt:134)");
                                                    }
                                                    Modifier padding = PaddingKt.padding(SizeKt.m1104defaultMinSizeVpY3zN4(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m2259getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m2258getMinHeightD9Ej5fM()), PaddingValues.this);
                                                    Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                    Function3<RowScope, Composer, Integer, Unit> function33 = function32;
                                                    composer4.startReplaceableGroup(693286680);
                                                    ComposerKt.sourceInformation(composer4, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer4, 54);
                                                    composer4.startReplaceableGroup(-1323940314);
                                                    ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                                    CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                                    Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(padding);
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
                                                    Updater.m4116setimpl(m4109constructorimpl, rowMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                                    Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                    Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                    if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                        m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                        m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                    }
                                                    modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer4)), composer4, 0);
                                                    composer4.startReplaceableGroup(2058660585);
                                                    ComposerKt.sourceInformationMarkerStart(composer4, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                                    function33.invoke(RowScopeInstance.INSTANCE, composer4, 6);
                                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                                    composer4.endReplaceableGroup();
                                                    composer4.endNode();
                                                    composer4.endReplaceableGroup();
                                                    composer4.endReplaceableGroup();
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer4.skipToGroupEnd();
                                            }
                                        }), composer3, 384);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }), composer2, i16, 6, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            buttonColors2 = buttonColors4;
                            paddingValues3 = paddingValues2;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            shape4 = shape2;
                            buttonElevation3 = buttonElevation2;
                            z3 = z2;
                            borderStroke4 = borderStroke3;
                            modifier3 = modifier2;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            modifier3 = modifier;
                            z3 = z;
                            shape4 = shape2;
                            buttonElevation3 = buttonElevation2;
                            mutableInteractionSource4 = mutableInteractionSource2;
                            composer2 = startRestartGroup;
                            borderStroke4 = borderStroke;
                            paddingValues3 = paddingValues;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            final ButtonColors buttonColors5 = buttonColors2;
                            final BorderStroke borderStroke5 = borderStroke4;
                            final PaddingValues paddingValues4 = paddingValues3;
                            final MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource4;
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$4
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

                                public final void invoke(Composer composer3, int i17) {
                                    ButtonKt.Button(function0, modifier3, z3, shape4, buttonColors5, buttonElevation3, borderStroke5, paddingValues4, mutableInteractionSource5, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i8 = i7;
                    mutableInteractionSource2 = mutableInteractionSource;
                    if ((i2 & Fields.RotationY) != 0) {
                    }
                    if ((306783379 & i3) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i15 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if ((i2 & 8) != 0) {
                    }
                    if ((i2 & 16) != 0) {
                    }
                    if ((i2 & 32) != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    long m2243containerColorvNxB06k$material3_release2 = buttonColors2.m2243containerColorvNxB06k$material3_release(z2);
                    final long m2244contentColorvNxB06k$material3_release2 = buttonColors2.m2244contentColorvNxB06k$material3_release(z2);
                    startRestartGroup.startReplaceableGroup(823569174);
                    ComposerKt.sourceInformation(startRestartGroup, "117@5963L43");
                    if (buttonElevation2 == null) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    ButtonColors buttonColors42 = buttonColors2;
                    int i162 = (i11 & 14) | (i11 & 896) | (i11 & 7168) | ((i11 << 6) & 234881024) | ((i11 << 3) & 1879048192);
                    composer2 = startRestartGroup;
                    SurfaceKt.m3046Surfaceo_FOJdg(function0, SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((SemanticsPropertyReceiver) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, Role.Companion.getButton-o7Vup1c());
                        }
                    }, 1, (Object) null), z2, shape2, m2243containerColorvNxB06k$material3_release2, m2244contentColorvNxB06k$material3_release2, buttonElevation2 != null ? buttonElevation2.m2262tonalElevationu2uoSUM$material3_release(z2) : Dp.constructor-impl(0), shadowElevation$material3_release != null ? shadowElevation$material3_release.getValue().unbox-impl() : Dp.constructor-impl(0), borderStroke3, mutableInteractionSource3, ComposableLambdaKt.composableLambda(startRestartGroup, 956488494, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$3
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

                        public final void invoke(Composer composer3, int i17) {
                            ComposerKt.sourceInformation(composer3, "C133@6591L10,131@6482L583:Button.kt#uh7d8r");
                            if ((i17 & 3) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(956488494, i17, -1, "androidx.compose.material3.Button.<anonymous> (Button.kt:131)");
                                }
                                long j = m2244contentColorvNxB06k$material3_release2;
                                TextStyle labelLarge = MaterialTheme.INSTANCE.getTypography(composer3, 6).getLabelLarge();
                                final PaddingValues paddingValues42 = paddingValues2;
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                                ProvideContentColorTextStyleKt.m2813ProvideContentColorTextStyle3JVO9M(j, labelLarge, ComposableLambdaKt.composableLambda(composer3, 1327513942, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$3.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                        invoke((Composer) obj, ((Number) obj2).intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer4, int i18) {
                                        ComposerKt.sourceInformation(composer4, "C134@6628L427:Button.kt#uh7d8r");
                                        if ((i18 & 3) != 2 || !composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1327513942, i18, -1, "androidx.compose.material3.Button.<anonymous>.<anonymous> (Button.kt:134)");
                                            }
                                            Modifier padding = PaddingKt.padding(SizeKt.m1104defaultMinSizeVpY3zN4(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m2259getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m2258getMinHeightD9Ej5fM()), PaddingValues.this);
                                            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                            Function3<RowScope, Composer, Integer, Unit> function33 = function32;
                                            composer4.startReplaceableGroup(693286680);
                                            ComposerKt.sourceInformation(composer4, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer4, 54);
                                            composer4.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                            CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                            Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(padding);
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
                                            Updater.m4116setimpl(m4109constructorimpl, rowMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                            Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                            if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                            }
                                            modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer4)), composer4, 0);
                                            composer4.startReplaceableGroup(2058660585);
                                            ComposerKt.sourceInformationMarkerStart(composer4, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                            function33.invoke(RowScopeInstance.INSTANCE, composer4, 6);
                                            ComposerKt.sourceInformationMarkerEnd(composer4);
                                            composer4.endReplaceableGroup();
                                            composer4.endNode();
                                            composer4.endReplaceableGroup();
                                            composer4.endReplaceableGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer4.skipToGroupEnd();
                                    }
                                }), composer3, 384);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), composer2, i162, 6, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    buttonColors2 = buttonColors42;
                    paddingValues3 = paddingValues2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    shape4 = shape2;
                    buttonElevation3 = buttonElevation2;
                    z3 = z2;
                    borderStroke4 = borderStroke3;
                    modifier3 = modifier2;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i6 = i2 & Fields.SpotShadowColor;
                if (i6 == 0) {
                }
                i7 = i2 & Fields.RotationX;
                if (i7 == 0) {
                }
                i8 = i7;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i2 & Fields.RotationY) != 0) {
                }
                if ((306783379 & i3) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i15 != 0) {
                }
                if (i4 != 0) {
                }
                if ((i2 & 8) != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                if ((i2 & 32) != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if (i8 != 0) {
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                long m2243containerColorvNxB06k$material3_release22 = buttonColors2.m2243containerColorvNxB06k$material3_release(z2);
                final long m2244contentColorvNxB06k$material3_release22 = buttonColors2.m2244contentColorvNxB06k$material3_release(z2);
                startRestartGroup.startReplaceableGroup(823569174);
                ComposerKt.sourceInformation(startRestartGroup, "117@5963L43");
                if (buttonElevation2 == null) {
                }
                startRestartGroup.endReplaceableGroup();
                ButtonColors buttonColors422 = buttonColors2;
                int i1622 = (i11 & 14) | (i11 & 896) | (i11 & 7168) | ((i11 << 6) & 234881024) | ((i11 << 3) & 1879048192);
                composer2 = startRestartGroup;
                SurfaceKt.m3046Surfaceo_FOJdg(function0, SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((SemanticsPropertyReceiver) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, Role.Companion.getButton-o7Vup1c());
                    }
                }, 1, (Object) null), z2, shape2, m2243containerColorvNxB06k$material3_release22, m2244contentColorvNxB06k$material3_release22, buttonElevation2 != null ? buttonElevation2.m2262tonalElevationu2uoSUM$material3_release(z2) : Dp.constructor-impl(0), shadowElevation$material3_release != null ? shadowElevation$material3_release.getValue().unbox-impl() : Dp.constructor-impl(0), borderStroke3, mutableInteractionSource3, ComposableLambdaKt.composableLambda(startRestartGroup, 956488494, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$3
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

                    public final void invoke(Composer composer3, int i17) {
                        ComposerKt.sourceInformation(composer3, "C133@6591L10,131@6482L583:Button.kt#uh7d8r");
                        if ((i17 & 3) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(956488494, i17, -1, "androidx.compose.material3.Button.<anonymous> (Button.kt:131)");
                            }
                            long j = m2244contentColorvNxB06k$material3_release22;
                            TextStyle labelLarge = MaterialTheme.INSTANCE.getTypography(composer3, 6).getLabelLarge();
                            final PaddingValues paddingValues42 = paddingValues2;
                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                            ProvideContentColorTextStyleKt.m2813ProvideContentColorTextStyle3JVO9M(j, labelLarge, ComposableLambdaKt.composableLambda(composer3, 1327513942, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$3.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer4, int i18) {
                                    ComposerKt.sourceInformation(composer4, "C134@6628L427:Button.kt#uh7d8r");
                                    if ((i18 & 3) != 2 || !composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1327513942, i18, -1, "androidx.compose.material3.Button.<anonymous>.<anonymous> (Button.kt:134)");
                                        }
                                        Modifier padding = PaddingKt.padding(SizeKt.m1104defaultMinSizeVpY3zN4(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m2259getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m2258getMinHeightD9Ej5fM()), PaddingValues.this);
                                        Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                        Function3<RowScope, Composer, Integer, Unit> function33 = function32;
                                        composer4.startReplaceableGroup(693286680);
                                        ComposerKt.sourceInformation(composer4, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer4, 54);
                                        composer4.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                        CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                        Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(padding);
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
                                        Updater.m4116setimpl(m4109constructorimpl, rowMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                        Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                        Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                        if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                            m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                            m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                        }
                                        modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer4)), composer4, 0);
                                        composer4.startReplaceableGroup(2058660585);
                                        ComposerKt.sourceInformationMarkerStart(composer4, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                        function33.invoke(RowScopeInstance.INSTANCE, composer4, 6);
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        composer4.endReplaceableGroup();
                                        composer4.endNode();
                                        composer4.endReplaceableGroup();
                                        composer4.endReplaceableGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer4.skipToGroupEnd();
                                }
                            }), composer3, 384);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }), composer2, i1622, 6, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                buttonColors2 = buttonColors422;
                paddingValues3 = paddingValues2;
                mutableInteractionSource4 = mutableInteractionSource3;
                shape4 = shape2;
                buttonElevation3 = buttonElevation2;
                z3 = z2;
                borderStroke4 = borderStroke3;
                modifier3 = modifier2;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            if ((196608 & i) == 0) {
            }
            i5 = i2 & 64;
            if (i5 != 0) {
            }
            i6 = i2 & Fields.SpotShadowColor;
            if (i6 == 0) {
            }
            i7 = i2 & Fields.RotationX;
            if (i7 == 0) {
            }
            i8 = i7;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & Fields.RotationY) != 0) {
            }
            if ((306783379 & i3) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i15 != 0) {
            }
            if (i4 != 0) {
            }
            if ((i2 & 8) != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if (i8 != 0) {
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            long m2243containerColorvNxB06k$material3_release222 = buttonColors2.m2243containerColorvNxB06k$material3_release(z2);
            final long m2244contentColorvNxB06k$material3_release222 = buttonColors2.m2244contentColorvNxB06k$material3_release(z2);
            startRestartGroup.startReplaceableGroup(823569174);
            ComposerKt.sourceInformation(startRestartGroup, "117@5963L43");
            if (buttonElevation2 == null) {
            }
            startRestartGroup.endReplaceableGroup();
            ButtonColors buttonColors4222 = buttonColors2;
            int i16222 = (i11 & 14) | (i11 & 896) | (i11 & 7168) | ((i11 << 6) & 234881024) | ((i11 << 3) & 1879048192);
            composer2 = startRestartGroup;
            SurfaceKt.m3046Surfaceo_FOJdg(function0, SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((SemanticsPropertyReceiver) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, Role.Companion.getButton-o7Vup1c());
                }
            }, 1, (Object) null), z2, shape2, m2243containerColorvNxB06k$material3_release222, m2244contentColorvNxB06k$material3_release222, buttonElevation2 != null ? buttonElevation2.m2262tonalElevationu2uoSUM$material3_release(z2) : Dp.constructor-impl(0), shadowElevation$material3_release != null ? shadowElevation$material3_release.getValue().unbox-impl() : Dp.constructor-impl(0), borderStroke3, mutableInteractionSource3, ComposableLambdaKt.composableLambda(startRestartGroup, 956488494, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$3
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

                public final void invoke(Composer composer3, int i17) {
                    ComposerKt.sourceInformation(composer3, "C133@6591L10,131@6482L583:Button.kt#uh7d8r");
                    if ((i17 & 3) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(956488494, i17, -1, "androidx.compose.material3.Button.<anonymous> (Button.kt:131)");
                        }
                        long j = m2244contentColorvNxB06k$material3_release222;
                        TextStyle labelLarge = MaterialTheme.INSTANCE.getTypography(composer3, 6).getLabelLarge();
                        final PaddingValues paddingValues42 = paddingValues2;
                        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                        ProvideContentColorTextStyleKt.m2813ProvideContentColorTextStyle3JVO9M(j, labelLarge, ComposableLambdaKt.composableLambda(composer3, 1327513942, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer4, int i18) {
                                ComposerKt.sourceInformation(composer4, "C134@6628L427:Button.kt#uh7d8r");
                                if ((i18 & 3) != 2 || !composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1327513942, i18, -1, "androidx.compose.material3.Button.<anonymous>.<anonymous> (Button.kt:134)");
                                    }
                                    Modifier padding = PaddingKt.padding(SizeKt.m1104defaultMinSizeVpY3zN4(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m2259getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m2258getMinHeightD9Ej5fM()), PaddingValues.this);
                                    Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                    Function3<RowScope, Composer, Integer, Unit> function33 = function32;
                                    composer4.startReplaceableGroup(693286680);
                                    ComposerKt.sourceInformation(composer4, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer4, 54);
                                    composer4.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                    Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(padding);
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
                                    Updater.m4116setimpl(m4109constructorimpl, rowMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                    Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                    Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                    if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer4)), composer4, 0);
                                    composer4.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer4, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                    function33.invoke(RowScopeInstance.INSTANCE, composer4, 6);
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    composer4.endReplaceableGroup();
                                    composer4.endNode();
                                    composer4.endReplaceableGroup();
                                    composer4.endReplaceableGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer4.skipToGroupEnd();
                            }
                        }), composer3, 384);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), composer2, i16222, 6, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            buttonColors2 = buttonColors4222;
            paddingValues3 = paddingValues2;
            mutableInteractionSource4 = mutableInteractionSource3;
            shape4 = shape2;
            buttonElevation3 = buttonElevation2;
            z3 = z2;
            borderStroke4 = borderStroke3;
            modifier3 = modifier2;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        if ((196608 & i) == 0) {
        }
        i5 = i2 & 64;
        if (i5 != 0) {
        }
        i6 = i2 & Fields.SpotShadowColor;
        if (i6 == 0) {
        }
        i7 = i2 & Fields.RotationX;
        if (i7 == 0) {
        }
        i8 = i7;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i2 & Fields.RotationY) != 0) {
        }
        if ((306783379 & i3) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i15 != 0) {
        }
        if (i4 != 0) {
        }
        if ((i2 & 8) != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if (i8 != 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        long m2243containerColorvNxB06k$material3_release2222 = buttonColors2.m2243containerColorvNxB06k$material3_release(z2);
        final long m2244contentColorvNxB06k$material3_release2222 = buttonColors2.m2244contentColorvNxB06k$material3_release(z2);
        startRestartGroup.startReplaceableGroup(823569174);
        ComposerKt.sourceInformation(startRestartGroup, "117@5963L43");
        if (buttonElevation2 == null) {
        }
        startRestartGroup.endReplaceableGroup();
        ButtonColors buttonColors42222 = buttonColors2;
        int i162222 = (i11 & 14) | (i11 & 896) | (i11 & 7168) | ((i11 << 6) & 234881024) | ((i11 << 3) & 1879048192);
        composer2 = startRestartGroup;
        SurfaceKt.m3046Surfaceo_FOJdg(function0, SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SemanticsPropertyReceiver) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, Role.Companion.getButton-o7Vup1c());
            }
        }, 1, (Object) null), z2, shape2, m2243containerColorvNxB06k$material3_release2222, m2244contentColorvNxB06k$material3_release2222, buttonElevation2 != null ? buttonElevation2.m2262tonalElevationu2uoSUM$material3_release(z2) : Dp.constructor-impl(0), shadowElevation$material3_release != null ? shadowElevation$material3_release.getValue().unbox-impl() : Dp.constructor-impl(0), borderStroke3, mutableInteractionSource3, ComposableLambdaKt.composableLambda(startRestartGroup, 956488494, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$3
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

            public final void invoke(Composer composer3, int i17) {
                ComposerKt.sourceInformation(composer3, "C133@6591L10,131@6482L583:Button.kt#uh7d8r");
                if ((i17 & 3) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(956488494, i17, -1, "androidx.compose.material3.Button.<anonymous> (Button.kt:131)");
                    }
                    long j = m2244contentColorvNxB06k$material3_release2222;
                    TextStyle labelLarge = MaterialTheme.INSTANCE.getTypography(composer3, 6).getLabelLarge();
                    final PaddingValues paddingValues42 = paddingValues2;
                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                    ProvideContentColorTextStyleKt.m2813ProvideContentColorTextStyle3JVO9M(j, labelLarge, ComposableLambdaKt.composableLambda(composer3, 1327513942, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$3.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer4, int i18) {
                            ComposerKt.sourceInformation(composer4, "C134@6628L427:Button.kt#uh7d8r");
                            if ((i18 & 3) != 2 || !composer4.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1327513942, i18, -1, "androidx.compose.material3.Button.<anonymous>.<anonymous> (Button.kt:134)");
                                }
                                Modifier padding = PaddingKt.padding(SizeKt.m1104defaultMinSizeVpY3zN4(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m2259getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m2258getMinHeightD9Ej5fM()), PaddingValues.this);
                                Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                Function3<RowScope, Composer, Integer, Unit> function33 = function32;
                                composer4.startReplaceableGroup(693286680);
                                ComposerKt.sourceInformation(composer4, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer4, 54);
                                composer4.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(padding);
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
                                Updater.m4116setimpl(m4109constructorimpl, rowMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer4)), composer4, 0);
                                composer4.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(composer4, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                function33.invoke(RowScopeInstance.INSTANCE, composer4, 6);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                composer4.endReplaceableGroup();
                                composer4.endNode();
                                composer4.endReplaceableGroup();
                                composer4.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer4.skipToGroupEnd();
                        }
                    }), composer3, 384);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer3.skipToGroupEnd();
            }
        }), composer2, i162222, 6, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        buttonColors2 = buttonColors42222;
        paddingValues3 = paddingValues2;
        mutableInteractionSource4 = mutableInteractionSource3;
        shape4 = shape2;
        buttonElevation3 = buttonElevation2;
        z3 = z2;
        borderStroke4 = borderStroke3;
        modifier3 = modifier2;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ElevatedButton(final Function0<Unit> function0, Modifier modifier, boolean z, Shape shape, ButtonColors buttonColors, ButtonElevation buttonElevation, BorderStroke borderStroke, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        boolean z2;
        Shape shape2;
        ButtonColors buttonColors2;
        ButtonElevation buttonElevation2;
        int i5;
        BorderStroke borderStroke2;
        int i6;
        int i7;
        int i8;
        final MutableInteractionSource mutableInteractionSource2;
        Modifier.Companion companion;
        Shape shape3;
        int i9;
        ButtonColors buttonColors3;
        PaddingValues contentPadding;
        int i10;
        BorderStroke borderStroke3;
        final boolean z3;
        final Shape shape4;
        final ButtonColors buttonColors4;
        final ButtonElevation buttonElevation3;
        final BorderStroke borderStroke4;
        final PaddingValues paddingValues2;
        final Modifier modifier2;
        int i11;
        int i12;
        int i13;
        Composer startRestartGroup = composer.startRestartGroup(1466887385);
        ComposerKt.sourceInformation(startRestartGroup, "C(ElevatedButton)P(8,7,5,9,1,4!1,3,6)198@9938L13,199@9995L22,200@10068L25,203@10246L39,206@10340L314:Button.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i14 = i2 & 2;
        if (i14 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? Fields.RotationX : Fields.SpotShadowColor;
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        shape2 = shape;
                        if (startRestartGroup.changed(shape2)) {
                            i13 = Fields.CameraDistance;
                            i3 |= i13;
                        }
                    } else {
                        shape2 = shape;
                    }
                    i13 = Fields.RotationZ;
                    i3 |= i13;
                } else {
                    shape2 = shape;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        buttonColors2 = buttonColors;
                        if (startRestartGroup.changed(buttonColors2)) {
                            i12 = Fields.Clip;
                            i3 |= i12;
                        }
                    } else {
                        buttonColors2 = buttonColors;
                    }
                    i12 = Fields.Shape;
                    i3 |= i12;
                } else {
                    buttonColors2 = buttonColors;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        buttonElevation2 = buttonElevation;
                        if (startRestartGroup.changed(buttonElevation2)) {
                            i11 = Fields.RenderEffect;
                            i3 |= i11;
                        }
                    } else {
                        buttonElevation2 = buttonElevation;
                    }
                    i11 = 65536;
                    i3 |= i11;
                } else {
                    buttonElevation2 = buttonElevation;
                }
                i5 = i2 & 64;
                if (i5 != 0) {
                    i3 |= 1572864;
                    borderStroke2 = borderStroke;
                } else {
                    borderStroke2 = borderStroke;
                    if ((1572864 & i) == 0) {
                        i3 |= startRestartGroup.changed(borderStroke2) ? 1048576 : Fields.BlendMode;
                    }
                }
                i6 = i2 & Fields.SpotShadowColor;
                if (i6 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    i3 |= startRestartGroup.changed(paddingValues) ? 8388608 : 4194304;
                }
                i7 = i2 & Fields.RotationX;
                if (i7 != 0) {
                    i3 |= 100663296;
                } else if ((i & 100663296) == 0) {
                    i8 = i7;
                    mutableInteractionSource2 = mutableInteractionSource;
                    i3 |= startRestartGroup.changed(mutableInteractionSource2) ? 67108864 : 33554432;
                    if ((i2 & Fields.RotationY) == 0) {
                        i3 |= 805306368;
                    } else if ((i & 805306368) == 0) {
                        i3 |= startRestartGroup.changedInstance(function3) ? 536870912 : 268435456;
                        if ((i3 & 306783379) == 306783378 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                companion = i14 != 0 ? Modifier.INSTANCE : modifier;
                                boolean z4 = i4 != 0 ? true : z2;
                                if ((i2 & 8) != 0) {
                                    i3 &= -7169;
                                    shape3 = ButtonDefaults.INSTANCE.getElevatedShape(startRestartGroup, 6);
                                } else {
                                    shape3 = shape2;
                                }
                                if ((i2 & 16) != 0) {
                                    i9 = i3 & (-57345);
                                    buttonColors3 = ButtonDefaults.INSTANCE.elevatedButtonColors(startRestartGroup, 6);
                                } else {
                                    i9 = i3;
                                    buttonColors3 = buttonColors2;
                                }
                                if ((i2 & 32) != 0) {
                                    buttonElevation2 = ButtonDefaults.INSTANCE.m2253elevatedButtonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 196608, 31);
                                    i3 = i9 & (-458753);
                                } else {
                                    i3 = i9;
                                }
                                if (i5 != 0) {
                                    borderStroke2 = null;
                                }
                                contentPadding = i6 != 0 ? ButtonDefaults.INSTANCE.getContentPadding() : paddingValues;
                                if (i8 != 0) {
                                    startRestartGroup.startReplaceableGroup(-446997561);
                                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Button.kt#9igjgp");
                                    Object rememberedValue = startRestartGroup.rememberedValue();
                                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                                    z2 = z4;
                                    shape2 = shape3;
                                    buttonColors2 = buttonColors3;
                                } else {
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    i10 = i3;
                                    borderStroke3 = borderStroke2;
                                    z2 = z4;
                                    shape2 = shape3;
                                    buttonColors2 = buttonColors3;
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1466887385, i10, -1, "androidx.compose.material3.ElevatedButton (Button.kt:206)");
                                    }
                                    Button(function0, companion, z2, shape2, buttonColors2, buttonElevation2, borderStroke3, contentPadding, mutableInteractionSource2, function3, startRestartGroup, (i10 & 14) | (i10 & 112) | (i10 & 896) | (i10 & 7168) | (57344 & i10) | (458752 & i10) | (3670016 & i10) | (29360128 & i10) | (234881024 & i10) | (i10 & 1879048192), 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    z3 = z2;
                                    shape4 = shape2;
                                    buttonColors4 = buttonColors2;
                                    buttonElevation3 = buttonElevation2;
                                    borderStroke4 = borderStroke3;
                                    paddingValues2 = contentPadding;
                                    modifier2 = companion;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 8) != 0) {
                                    i3 &= -7169;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                }
                                companion = modifier;
                                contentPadding = paddingValues;
                            }
                            i10 = i3;
                            borderStroke3 = borderStroke2;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            Button(function0, companion, z2, shape2, buttonColors2, buttonElevation2, borderStroke3, contentPadding, mutableInteractionSource2, function3, startRestartGroup, (i10 & 14) | (i10 & 112) | (i10 & 896) | (i10 & 7168) | (57344 & i10) | (458752 & i10) | (3670016 & i10) | (29360128 & i10) | (234881024 & i10) | (i10 & 1879048192), 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            z3 = z2;
                            shape4 = shape2;
                            buttonColors4 = buttonColors2;
                            buttonElevation3 = buttonElevation2;
                            borderStroke4 = borderStroke3;
                            paddingValues2 = contentPadding;
                            modifier2 = companion;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            modifier2 = modifier;
                            z3 = z2;
                            shape4 = shape2;
                            buttonColors4 = buttonColors2;
                            buttonElevation3 = buttonElevation2;
                            borderStroke4 = borderStroke2;
                            paddingValues2 = paddingValues;
                        }
                        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$ElevatedButton$2
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

                                public final void invoke(Composer composer2, int i15) {
                                    ButtonKt.ElevatedButton(function0, modifier2, z3, shape4, buttonColors4, buttonElevation3, borderStroke4, paddingValues2, mutableInteractionSource2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if ((i3 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i14 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if ((i2 & 8) != 0) {
                    }
                    if ((i2 & 16) != 0) {
                    }
                    if ((i2 & 32) != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i8 != 0) {
                    }
                }
                i8 = i7;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i2 & Fields.RotationY) == 0) {
                }
                if ((i3 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i14 != 0) {
                }
                if (i4 != 0) {
                }
                if ((i2 & 8) != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                if ((i2 & 32) != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if (i8 != 0) {
                }
            }
            z2 = z;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            if ((196608 & i) == 0) {
            }
            i5 = i2 & 64;
            if (i5 != 0) {
            }
            i6 = i2 & Fields.SpotShadowColor;
            if (i6 != 0) {
            }
            i7 = i2 & Fields.RotationX;
            if (i7 != 0) {
            }
            i8 = i7;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & Fields.RotationY) == 0) {
            }
            if ((i3 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i14 != 0) {
            }
            if (i4 != 0) {
            }
            if ((i2 & 8) != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if (i8 != 0) {
            }
        }
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        if ((196608 & i) == 0) {
        }
        i5 = i2 & 64;
        if (i5 != 0) {
        }
        i6 = i2 & Fields.SpotShadowColor;
        if (i6 != 0) {
        }
        i7 = i2 & Fields.RotationX;
        if (i7 != 0) {
        }
        i8 = i7;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i2 & Fields.RotationY) == 0) {
        }
        if ((i3 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i14 != 0) {
        }
        if (i4 != 0) {
        }
        if ((i2 & 8) != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if (i8 != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void FilledTonalButton(final Function0<Unit> function0, Modifier modifier, boolean z, Shape shape, ButtonColors buttonColors, ButtonElevation buttonElevation, BorderStroke borderStroke, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        boolean z2;
        Shape shape2;
        ButtonColors buttonColors2;
        ButtonElevation buttonElevation2;
        int i5;
        BorderStroke borderStroke2;
        int i6;
        int i7;
        int i8;
        final MutableInteractionSource mutableInteractionSource2;
        Modifier.Companion companion;
        Shape shape3;
        int i9;
        ButtonColors buttonColors3;
        PaddingValues contentPadding;
        int i10;
        BorderStroke borderStroke3;
        final boolean z3;
        final Shape shape4;
        final ButtonColors buttonColors4;
        final ButtonElevation buttonElevation3;
        final BorderStroke borderStroke4;
        final PaddingValues paddingValues2;
        final Modifier modifier2;
        int i11;
        int i12;
        int i13;
        Composer startRestartGroup = composer.startRestartGroup(-1717924381);
        ComposerKt.sourceInformation(startRestartGroup, "C(FilledTonalButton)P(8,7,5,9,1,4!1,3,6)268@13576L16,269@13636L25,270@13712L28,273@13893L39,276@13987L314:Button.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i14 = i2 & 2;
        if (i14 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? Fields.RotationX : Fields.SpotShadowColor;
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        shape2 = shape;
                        if (startRestartGroup.changed(shape2)) {
                            i13 = Fields.CameraDistance;
                            i3 |= i13;
                        }
                    } else {
                        shape2 = shape;
                    }
                    i13 = Fields.RotationZ;
                    i3 |= i13;
                } else {
                    shape2 = shape;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        buttonColors2 = buttonColors;
                        if (startRestartGroup.changed(buttonColors2)) {
                            i12 = Fields.Clip;
                            i3 |= i12;
                        }
                    } else {
                        buttonColors2 = buttonColors;
                    }
                    i12 = Fields.Shape;
                    i3 |= i12;
                } else {
                    buttonColors2 = buttonColors;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        buttonElevation2 = buttonElevation;
                        if (startRestartGroup.changed(buttonElevation2)) {
                            i11 = Fields.RenderEffect;
                            i3 |= i11;
                        }
                    } else {
                        buttonElevation2 = buttonElevation;
                    }
                    i11 = 65536;
                    i3 |= i11;
                } else {
                    buttonElevation2 = buttonElevation;
                }
                i5 = i2 & 64;
                if (i5 != 0) {
                    i3 |= 1572864;
                    borderStroke2 = borderStroke;
                } else {
                    borderStroke2 = borderStroke;
                    if ((1572864 & i) == 0) {
                        i3 |= startRestartGroup.changed(borderStroke2) ? 1048576 : Fields.BlendMode;
                    }
                }
                i6 = i2 & Fields.SpotShadowColor;
                if (i6 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    i3 |= startRestartGroup.changed(paddingValues) ? 8388608 : 4194304;
                }
                i7 = i2 & Fields.RotationX;
                if (i7 != 0) {
                    i3 |= 100663296;
                } else if ((i & 100663296) == 0) {
                    i8 = i7;
                    mutableInteractionSource2 = mutableInteractionSource;
                    i3 |= startRestartGroup.changed(mutableInteractionSource2) ? 67108864 : 33554432;
                    if ((i2 & Fields.RotationY) == 0) {
                        i3 |= 805306368;
                    } else if ((i & 805306368) == 0) {
                        i3 |= startRestartGroup.changedInstance(function3) ? 536870912 : 268435456;
                        if ((i3 & 306783379) == 306783378 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                companion = i14 != 0 ? Modifier.INSTANCE : modifier;
                                boolean z4 = i4 != 0 ? true : z2;
                                if ((i2 & 8) != 0) {
                                    i3 &= -7169;
                                    shape3 = ButtonDefaults.INSTANCE.getFilledTonalShape(startRestartGroup, 6);
                                } else {
                                    shape3 = shape2;
                                }
                                if ((i2 & 16) != 0) {
                                    i9 = i3 & (-57345);
                                    buttonColors3 = ButtonDefaults.INSTANCE.filledTonalButtonColors(startRestartGroup, 6);
                                } else {
                                    i9 = i3;
                                    buttonColors3 = buttonColors2;
                                }
                                if ((i2 & 32) != 0) {
                                    buttonElevation2 = ButtonDefaults.INSTANCE.m2255filledTonalButtonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, 196608, 31);
                                    i3 = i9 & (-458753);
                                } else {
                                    i3 = i9;
                                }
                                if (i5 != 0) {
                                    borderStroke2 = null;
                                }
                                contentPadding = i6 != 0 ? ButtonDefaults.INSTANCE.getContentPadding() : paddingValues;
                                if (i8 != 0) {
                                    startRestartGroup.startReplaceableGroup(1269258330);
                                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Button.kt#9igjgp");
                                    Object rememberedValue = startRestartGroup.rememberedValue();
                                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                                    z2 = z4;
                                    shape2 = shape3;
                                    buttonColors2 = buttonColors3;
                                } else {
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    i10 = i3;
                                    borderStroke3 = borderStroke2;
                                    z2 = z4;
                                    shape2 = shape3;
                                    buttonColors2 = buttonColors3;
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1717924381, i10, -1, "androidx.compose.material3.FilledTonalButton (Button.kt:276)");
                                    }
                                    Button(function0, companion, z2, shape2, buttonColors2, buttonElevation2, borderStroke3, contentPadding, mutableInteractionSource2, function3, startRestartGroup, (i10 & 14) | (i10 & 112) | (i10 & 896) | (i10 & 7168) | (57344 & i10) | (458752 & i10) | (3670016 & i10) | (29360128 & i10) | (234881024 & i10) | (i10 & 1879048192), 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    z3 = z2;
                                    shape4 = shape2;
                                    buttonColors4 = buttonColors2;
                                    buttonElevation3 = buttonElevation2;
                                    borderStroke4 = borderStroke3;
                                    paddingValues2 = contentPadding;
                                    modifier2 = companion;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 8) != 0) {
                                    i3 &= -7169;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                }
                                companion = modifier;
                                contentPadding = paddingValues;
                            }
                            i10 = i3;
                            borderStroke3 = borderStroke2;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            Button(function0, companion, z2, shape2, buttonColors2, buttonElevation2, borderStroke3, contentPadding, mutableInteractionSource2, function3, startRestartGroup, (i10 & 14) | (i10 & 112) | (i10 & 896) | (i10 & 7168) | (57344 & i10) | (458752 & i10) | (3670016 & i10) | (29360128 & i10) | (234881024 & i10) | (i10 & 1879048192), 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            z3 = z2;
                            shape4 = shape2;
                            buttonColors4 = buttonColors2;
                            buttonElevation3 = buttonElevation2;
                            borderStroke4 = borderStroke3;
                            paddingValues2 = contentPadding;
                            modifier2 = companion;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            modifier2 = modifier;
                            z3 = z2;
                            shape4 = shape2;
                            buttonColors4 = buttonColors2;
                            buttonElevation3 = buttonElevation2;
                            borderStroke4 = borderStroke2;
                            paddingValues2 = paddingValues;
                        }
                        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$FilledTonalButton$2
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

                                public final void invoke(Composer composer2, int i15) {
                                    ButtonKt.FilledTonalButton(function0, modifier2, z3, shape4, buttonColors4, buttonElevation3, borderStroke4, paddingValues2, mutableInteractionSource2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if ((i3 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i14 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if ((i2 & 8) != 0) {
                    }
                    if ((i2 & 16) != 0) {
                    }
                    if ((i2 & 32) != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i8 != 0) {
                    }
                }
                i8 = i7;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i2 & Fields.RotationY) == 0) {
                }
                if ((i3 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i14 != 0) {
                }
                if (i4 != 0) {
                }
                if ((i2 & 8) != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                if ((i2 & 32) != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if (i8 != 0) {
                }
            }
            z2 = z;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            if ((196608 & i) == 0) {
            }
            i5 = i2 & 64;
            if (i5 != 0) {
            }
            i6 = i2 & Fields.SpotShadowColor;
            if (i6 != 0) {
            }
            i7 = i2 & Fields.RotationX;
            if (i7 != 0) {
            }
            i8 = i7;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i2 & Fields.RotationY) == 0) {
            }
            if ((i3 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i14 != 0) {
            }
            if (i4 != 0) {
            }
            if ((i2 & 8) != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if (i8 != 0) {
            }
        }
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        if ((196608 & i) == 0) {
        }
        i5 = i2 & 64;
        if (i5 != 0) {
        }
        i6 = i2 & Fields.SpotShadowColor;
        if (i6 != 0) {
        }
        i7 = i2 & Fields.RotationX;
        if (i7 != 0) {
        }
        i8 = i7;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i2 & Fields.RotationY) == 0) {
        }
        if ((i3 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i14 != 0) {
        }
        if (i4 != 0) {
        }
        if ((i2 & 8) != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if (i8 != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void OutlinedButton(final Function0<Unit> function0, Modifier modifier, boolean z, Shape shape, ButtonColors buttonColors, ButtonElevation buttonElevation, BorderStroke borderStroke, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        boolean z2;
        Shape shape2;
        ButtonColors buttonColors2;
        int i5;
        ButtonElevation buttonElevation2;
        BorderStroke borderStroke2;
        int i6;
        int i7;
        final Modifier.Companion companion;
        boolean z3;
        Shape shape3;
        ButtonColors buttonColors3;
        ButtonElevation buttonElevation3;
        final BorderStroke borderStroke3;
        PaddingValues contentPadding;
        MutableInteractionSource mutableInteractionSource2;
        final boolean z4;
        final Shape shape4;
        final ButtonElevation buttonElevation4;
        final MutableInteractionSource mutableInteractionSource3;
        final PaddingValues paddingValues2;
        final ButtonColors buttonColors4;
        ScopeUpdateScope endRestartGroup;
        int i8;
        int i9;
        int i10;
        Composer startRestartGroup = composer.startRestartGroup(-1694808287);
        ComposerKt.sourceInformation(startRestartGroup, "C(OutlinedButton)P(8,7,5,9,1,4!1,3,6)337@17120L13,338@17177L22,340@17284L20,342@17423L39,345@17517L314:Button.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i11 = i2 & 2;
        if (i11 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? Fields.RotationX : Fields.SpotShadowColor;
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        shape2 = shape;
                        if (startRestartGroup.changed(shape2)) {
                            i10 = Fields.CameraDistance;
                            i3 |= i10;
                        }
                    } else {
                        shape2 = shape;
                    }
                    i10 = Fields.RotationZ;
                    i3 |= i10;
                } else {
                    shape2 = shape;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        buttonColors2 = buttonColors;
                        if (startRestartGroup.changed(buttonColors2)) {
                            i9 = Fields.Clip;
                            i3 |= i9;
                        }
                    } else {
                        buttonColors2 = buttonColors;
                    }
                    i9 = Fields.Shape;
                    i3 |= i9;
                } else {
                    buttonColors2 = buttonColors;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= 196608;
                } else if ((196608 & i) == 0) {
                    buttonElevation2 = buttonElevation;
                    i3 |= startRestartGroup.changed(buttonElevation2) ? Fields.RenderEffect : 65536;
                    if ((1572864 & i) != 0) {
                        if ((i2 & 64) == 0) {
                            borderStroke2 = borderStroke;
                            if (startRestartGroup.changed(borderStroke2)) {
                                i8 = 1048576;
                                i3 |= i8;
                            }
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        i8 = Fields.BlendMode;
                        i3 |= i8;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    i6 = i2 & Fields.SpotShadowColor;
                    if (i6 == 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        i3 |= startRestartGroup.changed(paddingValues) ? 8388608 : 4194304;
                    }
                    i7 = i2 & Fields.RotationX;
                    if (i7 == 0) {
                        i3 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        i3 |= startRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                    }
                    if ((i2 & Fields.RotationY) == 0) {
                        i3 |= 805306368;
                    } else if ((i & 805306368) == 0) {
                        i3 |= startRestartGroup.changedInstance(function3) ? 536870912 : 268435456;
                        if ((i3 & 306783379) == 306783378 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                companion = i11 != 0 ? Modifier.INSTANCE : modifier;
                                z3 = i4 != 0 ? true : z2;
                                if ((i2 & 8) != 0) {
                                    shape3 = ButtonDefaults.INSTANCE.getOutlinedShape(startRestartGroup, 6);
                                    i3 &= -7169;
                                } else {
                                    shape3 = shape2;
                                }
                                if ((i2 & 16) != 0) {
                                    buttonColors3 = ButtonDefaults.INSTANCE.outlinedButtonColors(startRestartGroup, 6);
                                    i3 &= -57345;
                                } else {
                                    buttonColors3 = buttonColors2;
                                }
                                buttonElevation3 = i5 != 0 ? null : buttonElevation2;
                                if ((i2 & 64) != 0) {
                                    borderStroke3 = ButtonDefaults.INSTANCE.getOutlinedButtonBorder(startRestartGroup, 6);
                                    i3 &= -3670017;
                                } else {
                                    borderStroke3 = borderStroke2;
                                }
                                contentPadding = i6 != 0 ? ButtonDefaults.INSTANCE.getContentPadding() : paddingValues;
                                if (i7 != 0) {
                                    startRestartGroup.startReplaceableGroup(-219967464);
                                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Button.kt#9igjgp");
                                    Object rememberedValue = startRestartGroup.rememberedValue();
                                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                    }
                                    mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                                    startRestartGroup.endReplaceableGroup();
                                } else {
                                    mutableInteractionSource2 = mutableInteractionSource;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 8) != 0) {
                                    i3 &= -7169;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                }
                                companion = modifier;
                                contentPadding = paddingValues;
                                mutableInteractionSource2 = mutableInteractionSource;
                                z3 = z2;
                                shape3 = shape2;
                                buttonColors3 = buttonColors2;
                                buttonElevation3 = buttonElevation2;
                                borderStroke3 = borderStroke2;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1694808287, i3, -1, "androidx.compose.material3.OutlinedButton (Button.kt:345)");
                            }
                            Button(function0, companion, z3, shape3, buttonColors3, buttonElevation3, borderStroke3, contentPadding, mutableInteractionSource2, function3, startRestartGroup, (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | (29360128 & i3) | (234881024 & i3) | (i3 & 1879048192), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z4 = z3;
                            shape4 = shape3;
                            buttonElevation4 = buttonElevation3;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            ButtonColors buttonColors5 = buttonColors3;
                            paddingValues2 = contentPadding;
                            buttonColors4 = buttonColors5;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            companion = modifier;
                            z4 = z2;
                            shape4 = shape2;
                            buttonColors4 = buttonColors2;
                            buttonElevation4 = buttonElevation2;
                            borderStroke3 = borderStroke2;
                            paddingValues2 = paddingValues;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$OutlinedButton$2
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
                                    ButtonKt.OutlinedButton(function0, companion, z4, shape4, buttonColors4, buttonElevation4, borderStroke3, paddingValues2, mutableInteractionSource3, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if ((i3 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if ((i2 & 8) != 0) {
                    }
                    if ((i2 & 16) != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if ((i2 & 64) != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i7 != 0) {
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    Button(function0, companion, z3, shape3, buttonColors3, buttonElevation3, borderStroke3, contentPadding, mutableInteractionSource2, function3, startRestartGroup, (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | (29360128 & i3) | (234881024 & i3) | (i3 & 1879048192), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    z4 = z3;
                    shape4 = shape3;
                    buttonElevation4 = buttonElevation3;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    ButtonColors buttonColors52 = buttonColors3;
                    paddingValues2 = contentPadding;
                    buttonColors4 = buttonColors52;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                buttonElevation2 = buttonElevation;
                if ((1572864 & i) != 0) {
                }
                i6 = i2 & Fields.SpotShadowColor;
                if (i6 == 0) {
                }
                i7 = i2 & Fields.RotationX;
                if (i7 == 0) {
                }
                if ((i2 & Fields.RotationY) == 0) {
                }
                if ((i3 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i11 != 0) {
                }
                if (i4 != 0) {
                }
                if ((i2 & 8) != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                if (i5 != 0) {
                }
                if ((i2 & 64) != 0) {
                }
                if (i6 != 0) {
                }
                if (i7 != 0) {
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                Button(function0, companion, z3, shape3, buttonColors3, buttonElevation3, borderStroke3, contentPadding, mutableInteractionSource2, function3, startRestartGroup, (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | (29360128 & i3) | (234881024 & i3) | (i3 & 1879048192), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                z4 = z3;
                shape4 = shape3;
                buttonElevation4 = buttonElevation3;
                mutableInteractionSource3 = mutableInteractionSource2;
                ButtonColors buttonColors522 = buttonColors3;
                paddingValues2 = contentPadding;
                buttonColors4 = buttonColors522;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            z2 = z;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            buttonElevation2 = buttonElevation;
            if ((1572864 & i) != 0) {
            }
            i6 = i2 & Fields.SpotShadowColor;
            if (i6 == 0) {
            }
            i7 = i2 & Fields.RotationX;
            if (i7 == 0) {
            }
            if ((i2 & Fields.RotationY) == 0) {
            }
            if ((i3 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i11 != 0) {
            }
            if (i4 != 0) {
            }
            if ((i2 & 8) != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            if (i5 != 0) {
            }
            if ((i2 & 64) != 0) {
            }
            if (i6 != 0) {
            }
            if (i7 != 0) {
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            Button(function0, companion, z3, shape3, buttonColors3, buttonElevation3, borderStroke3, contentPadding, mutableInteractionSource2, function3, startRestartGroup, (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | (29360128 & i3) | (234881024 & i3) | (i3 & 1879048192), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            z4 = z3;
            shape4 = shape3;
            buttonElevation4 = buttonElevation3;
            mutableInteractionSource3 = mutableInteractionSource2;
            ButtonColors buttonColors5222 = buttonColors3;
            paddingValues2 = contentPadding;
            buttonColors4 = buttonColors5222;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        buttonElevation2 = buttonElevation;
        if ((1572864 & i) != 0) {
        }
        i6 = i2 & Fields.SpotShadowColor;
        if (i6 == 0) {
        }
        i7 = i2 & Fields.RotationX;
        if (i7 == 0) {
        }
        if ((i2 & Fields.RotationY) == 0) {
        }
        if ((i3 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i11 != 0) {
        }
        if (i4 != 0) {
        }
        if ((i2 & 8) != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if (i5 != 0) {
        }
        if ((i2 & 64) != 0) {
        }
        if (i6 != 0) {
        }
        if (i7 != 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        Button(function0, companion, z3, shape3, buttonColors3, buttonElevation3, borderStroke3, contentPadding, mutableInteractionSource2, function3, startRestartGroup, (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (3670016 & i3) | (29360128 & i3) | (234881024 & i3) | (i3 & 1879048192), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        z4 = z3;
        shape4 = shape3;
        buttonElevation4 = buttonElevation3;
        mutableInteractionSource3 = mutableInteractionSource2;
        ButtonColors buttonColors52222 = buttonColors3;
        paddingValues2 = contentPadding;
        buttonColors4 = buttonColors52222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TextButton(final Function0<Unit> function0, Modifier modifier, boolean z, Shape shape, ButtonColors buttonColors, ButtonElevation buttonElevation, BorderStroke borderStroke, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        Shape shape2;
        ButtonColors buttonColors2;
        int i5;
        ButtonElevation buttonElevation2;
        int i6;
        BorderStroke borderStroke2;
        int i7;
        int i8;
        Modifier.Companion companion;
        boolean z2;
        Shape shape3;
        ButtonColors buttonColors3;
        BorderStroke borderStroke3;
        PaddingValues paddingValues2;
        int i9;
        ButtonElevation buttonElevation3;
        MutableInteractionSource mutableInteractionSource2;
        final MutableInteractionSource mutableInteractionSource3;
        final boolean z3;
        final ButtonColors buttonColors4;
        final BorderStroke borderStroke4;
        final PaddingValues paddingValues3;
        final Modifier modifier2;
        final Shape shape4;
        final ButtonElevation buttonElevation4;
        int i10;
        int i11;
        Composer startRestartGroup = composer.startRestartGroup(-2106428362);
        ComposerKt.sourceInformation(startRestartGroup, "C(TextButton)P(8,7,5,9,1,4!1,3,6)408@20786L9,409@20839L18,413@21060L39,416@21154L314:Button.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i;
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
                        shape2 = shape;
                        if (startRestartGroup.changed(shape2)) {
                            i11 = Fields.CameraDistance;
                            i3 |= i11;
                        }
                    } else {
                        shape2 = shape;
                    }
                    i11 = Fields.RotationZ;
                    i3 |= i11;
                } else {
                    shape2 = shape;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        buttonColors2 = buttonColors;
                        if (startRestartGroup.changed(buttonColors2)) {
                            i10 = Fields.Clip;
                            i3 |= i10;
                        }
                    } else {
                        buttonColors2 = buttonColors;
                    }
                    i10 = Fields.Shape;
                    i3 |= i10;
                } else {
                    buttonColors2 = buttonColors;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= 196608;
                } else if ((196608 & i) == 0) {
                    buttonElevation2 = buttonElevation;
                    i3 |= startRestartGroup.changed(buttonElevation2) ? Fields.RenderEffect : 65536;
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                    } else if ((1572864 & i) == 0) {
                        borderStroke2 = borderStroke;
                        i3 |= startRestartGroup.changed(borderStroke2) ? 1048576 : Fields.BlendMode;
                        i7 = i2 & Fields.SpotShadowColor;
                        if (i7 != 0) {
                            i3 |= 12582912;
                        } else if ((i & 12582912) == 0) {
                            i3 |= startRestartGroup.changed(paddingValues) ? 8388608 : 4194304;
                        }
                        i8 = i2 & Fields.RotationX;
                        if (i8 != 0) {
                            i3 |= 100663296;
                        } else if ((i & 100663296) == 0) {
                            i3 |= startRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                        }
                        if ((i2 & Fields.RotationY) != 0) {
                            i3 |= 805306368;
                        } else if ((i & 805306368) == 0) {
                            i3 |= startRestartGroup.changedInstance(function3) ? 536870912 : 268435456;
                            if ((i3 & 306783379) == 306783378 || !startRestartGroup.getSkipping()) {
                                startRestartGroup.startDefaults();
                                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    companion = i12 == 0 ? Modifier.INSTANCE : modifier;
                                    z2 = i4 == 0 ? true : z;
                                    if ((i2 & 8) == 0) {
                                        shape3 = ButtonDefaults.INSTANCE.getTextShape(startRestartGroup, 6);
                                        i3 &= -7169;
                                    } else {
                                        shape3 = shape2;
                                    }
                                    if ((i2 & 16) == 0) {
                                        buttonColors3 = ButtonDefaults.INSTANCE.textButtonColors(startRestartGroup, 6);
                                        i3 &= -57345;
                                    } else {
                                        buttonColors3 = buttonColors2;
                                    }
                                    if (i5 != 0) {
                                        buttonElevation2 = null;
                                    }
                                    borderStroke3 = i6 == 0 ? borderStroke2 : null;
                                    PaddingValues textButtonContentPadding = i7 == 0 ? ButtonDefaults.INSTANCE.getTextButtonContentPadding() : paddingValues;
                                    if (i8 == 0) {
                                        startRestartGroup.startReplaceableGroup(593745314);
                                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Button.kt#9igjgp");
                                        Object rememberedValue = startRestartGroup.rememberedValue();
                                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                            startRestartGroup.updateRememberedValue(rememberedValue);
                                        }
                                        startRestartGroup.endReplaceableGroup();
                                        i9 = i3;
                                        mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                                        paddingValues2 = textButtonContentPadding;
                                        buttonElevation3 = buttonElevation2;
                                        startRestartGroup.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-2106428362, i9, -1, "androidx.compose.material3.TextButton (Button.kt:416)");
                                        }
                                        Button(function0, companion, z2, shape3, buttonColors3, buttonElevation3, borderStroke3, paddingValues2, mutableInteractionSource2, function3, startRestartGroup, (i9 & 14) | (i9 & 112) | (i9 & 896) | (i9 & 7168) | (57344 & i9) | (458752 & i9) | (3670016 & i9) | (29360128 & i9) | (234881024 & i9) | (i9 & 1879048192), 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        mutableInteractionSource3 = mutableInteractionSource2;
                                        z3 = z2;
                                        buttonColors4 = buttonColors3;
                                        borderStroke4 = borderStroke3;
                                        paddingValues3 = paddingValues2;
                                        modifier2 = companion;
                                        shape4 = shape3;
                                        buttonElevation4 = buttonElevation3;
                                    } else {
                                        paddingValues2 = textButtonContentPadding;
                                        i9 = i3;
                                        buttonElevation3 = buttonElevation2;
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
                                    z2 = z;
                                    paddingValues2 = paddingValues;
                                    shape3 = shape2;
                                    buttonColors3 = buttonColors2;
                                    buttonElevation3 = buttonElevation2;
                                    borderStroke3 = borderStroke2;
                                    i9 = i3;
                                }
                                mutableInteractionSource2 = mutableInteractionSource;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                Button(function0, companion, z2, shape3, buttonColors3, buttonElevation3, borderStroke3, paddingValues2, mutableInteractionSource2, function3, startRestartGroup, (i9 & 14) | (i9 & 112) | (i9 & 896) | (i9 & 7168) | (57344 & i9) | (458752 & i9) | (3670016 & i9) | (29360128 & i9) | (234881024 & i9) | (i9 & 1879048192), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                mutableInteractionSource3 = mutableInteractionSource2;
                                z3 = z2;
                                buttonColors4 = buttonColors3;
                                borderStroke4 = borderStroke3;
                                paddingValues3 = paddingValues2;
                                modifier2 = companion;
                                shape4 = shape3;
                                buttonElevation4 = buttonElevation3;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                modifier2 = modifier;
                                z3 = z;
                                shape4 = shape2;
                                buttonColors4 = buttonColors2;
                                buttonElevation4 = buttonElevation2;
                                borderStroke4 = borderStroke2;
                                paddingValues3 = paddingValues;
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup != null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$TextButton$2
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
                                        ButtonKt.TextButton(function0, modifier2, z3, shape4, buttonColors4, buttonElevation4, borderStroke4, paddingValues3, mutableInteractionSource3, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        if ((i3 & 306783379) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                        }
                        if (i12 == 0) {
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 8) == 0) {
                        }
                        if ((i2 & 16) == 0) {
                        }
                        if (i5 != 0) {
                        }
                        if (i6 == 0) {
                        }
                        if (i7 == 0) {
                        }
                        if (i8 == 0) {
                        }
                    }
                    borderStroke2 = borderStroke;
                    i7 = i2 & Fields.SpotShadowColor;
                    if (i7 != 0) {
                    }
                    i8 = i2 & Fields.RotationX;
                    if (i8 != 0) {
                    }
                    if ((i2 & Fields.RotationY) != 0) {
                    }
                    if ((i3 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i12 == 0) {
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 8) == 0) {
                    }
                    if ((i2 & 16) == 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 == 0) {
                    }
                    if (i7 == 0) {
                    }
                    if (i8 == 0) {
                    }
                }
                buttonElevation2 = buttonElevation;
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                borderStroke2 = borderStroke;
                i7 = i2 & Fields.SpotShadowColor;
                if (i7 != 0) {
                }
                i8 = i2 & Fields.RotationX;
                if (i8 != 0) {
                }
                if ((i2 & Fields.RotationY) != 0) {
                }
                if ((i3 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i12 == 0) {
                }
                if (i4 == 0) {
                }
                if ((i2 & 8) == 0) {
                }
                if ((i2 & 16) == 0) {
                }
                if (i5 != 0) {
                }
                if (i6 == 0) {
                }
                if (i7 == 0) {
                }
                if (i8 == 0) {
                }
            }
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            buttonElevation2 = buttonElevation;
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            borderStroke2 = borderStroke;
            i7 = i2 & Fields.SpotShadowColor;
            if (i7 != 0) {
            }
            i8 = i2 & Fields.RotationX;
            if (i8 != 0) {
            }
            if ((i2 & Fields.RotationY) != 0) {
            }
            if ((i3 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i12 == 0) {
            }
            if (i4 == 0) {
            }
            if ((i2 & 8) == 0) {
            }
            if ((i2 & 16) == 0) {
            }
            if (i5 != 0) {
            }
            if (i6 == 0) {
            }
            if (i7 == 0) {
            }
            if (i8 == 0) {
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
        buttonElevation2 = buttonElevation;
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        borderStroke2 = borderStroke;
        i7 = i2 & Fields.SpotShadowColor;
        if (i7 != 0) {
        }
        i8 = i2 & Fields.RotationX;
        if (i8 != 0) {
        }
        if ((i2 & Fields.RotationY) != 0) {
        }
        if ((i3 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i12 == 0) {
        }
        if (i4 == 0) {
        }
        if ((i2 & 8) == 0) {
        }
        if ((i2 & 16) == 0) {
        }
        if (i5 != 0) {
        }
        if (i6 == 0) {
        }
        if (i7 == 0) {
        }
        if (i8 == 0) {
        }
    }
}
