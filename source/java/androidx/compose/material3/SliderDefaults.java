package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.HoverableKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.material3.tokens.SliderTokens;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.draw.ShadowKt;
import androidx.compose.p002ui.geometry.Offset;
import androidx.compose.p002ui.geometry.OffsetKt;
import androidx.compose.p002ui.geometry.Size;
import androidx.compose.p002ui.graphics.Color;
import androidx.compose.p002ui.graphics.ColorKt;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.graphics.PointMode;
import androidx.compose.p002ui.graphics.Shape;
import androidx.compose.p002ui.graphics.StrokeCap;
import androidx.compose.p002ui.graphics.drawscope.DrawScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Slider.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JB\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J3\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007¢\u0006\u0002\u0010\u0018J3\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007¢\u0006\u0002\u0010\u001bJ3\u0010\u0015\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007¢\u0006\u0002\u0010\u001eJ\r\u0010\u000e\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u001fJv\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020!2\b\b\u0002\u0010#\u001a\u00020!2\b\b\u0002\u0010$\u001a\u00020!2\b\b\u0002\u0010%\u001a\u00020!2\b\b\u0002\u0010&\u001a\u00020!2\b\b\u0002\u0010'\u001a\u00020!2\b\b\u0002\u0010(\u001a\u00020!2\b\b\u0002\u0010)\u001a\u00020!2\b\b\u0002\u0010*\u001a\u00020!H\u0007ø\u0001\u0000¢\u0006\u0004\b+\u0010,JN\u0010-\u001a\u00020\t*\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002022\u0006\u0010$\u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010%\u001a\u00020!2\u0006\u0010#\u001a\u00020!H\u0002ø\u0001\u0000¢\u0006\u0004\b4\u00105R\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00066"}, d2 = {"Landroidx/compose/material3/SliderDefaults;", "", "()V", "defaultSliderColors", "Landroidx/compose/material3/SliderColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultSliderColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/SliderColors;", "Thumb", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "modifier", "Landroidx/compose/ui/Modifier;", "colors", "enabled", "", "thumbSize", "Landroidx/compose/ui/unit/DpSize;", "Thumb-9LiSoMs", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZJLandroidx/compose/runtime/Composer;II)V", "Track", "rangeSliderState", "Landroidx/compose/material3/RangeSliderState;", "(Landroidx/compose/material3/RangeSliderState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZLandroidx/compose/runtime/Composer;II)V", "sliderPositions", "Landroidx/compose/material3/SliderPositions;", "(Landroidx/compose/material3/SliderPositions;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZLandroidx/compose/runtime/Composer;II)V", "sliderState", "Landroidx/compose/material3/SliderState;", "(Landroidx/compose/material3/SliderState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZLandroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/SliderColors;", "thumbColor", "Landroidx/compose/ui/graphics/Color;", "activeTrackColor", "activeTickColor", "inactiveTrackColor", "inactiveTickColor", "disabledThumbColor", "disabledActiveTrackColor", "disabledActiveTickColor", "disabledInactiveTrackColor", "disabledInactiveTickColor", "colors-q0g_0yA", "(JJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/SliderColors;", "drawTrack", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "tickFractions", "", "activeRangeStart", "", "activeRangeEnd", "drawTrack-LUBghH0", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;[FFFJJJJ)V", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class SliderDefaults {
    public static final int $stable = 0;
    public static final SliderDefaults INSTANCE = new SliderDefaults();

    private SliderDefaults() {
    }

    public final SliderColors colors(Composer composer, int i) {
        composer.startReplaceableGroup(1376295968);
        ComposerKt.sourceInformation(composer, "C(colors)886@36284L11:Slider.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1376295968, i, -1, "androidx.compose.material3.SliderDefaults.colors (Slider.kt:886)");
        }
        SliderColors defaultSliderColors$material3_release = getDefaultSliderColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultSliderColors$material3_release;
    }

    /* renamed from: colors-q0g_0yA, reason: not valid java name */
    public final SliderColors m2927colorsq0g_0yA(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, Composer composer, int i, int i2, int i3) {
        composer.startReplaceableGroup(885588574);
        ComposerKt.sourceInformation(composer, "C(colors)P(9:c#ui.graphics.Color,1:c#ui.graphics.Color,0:c#ui.graphics.Color,8:c#ui.graphics.Color,7:c#ui.graphics.Color,6:c#ui.graphics.Color,3:c#ui.graphics.Color,2:c#ui.graphics.Color,5:c#ui.graphics.Color,4:c#ui.graphics.Color)927@38583L11:Slider.kt#uh7d8r");
        long m4875getUnspecified0d7_KjU = (i3 & 1) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j;
        long m4875getUnspecified0d7_KjU2 = (i3 & 2) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j2;
        long m4875getUnspecified0d7_KjU3 = (i3 & 4) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j3;
        long m4875getUnspecified0d7_KjU4 = (i3 & 8) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j4;
        long m4875getUnspecified0d7_KjU5 = (i3 & 16) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j5;
        long m4875getUnspecified0d7_KjU6 = (i3 & 32) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j6;
        long m4875getUnspecified0d7_KjU7 = (i3 & 64) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j7;
        long m4875getUnspecified0d7_KjU8 = (i3 & Fields.SpotShadowColor) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j8;
        long m4875getUnspecified0d7_KjU9 = (i3 & Fields.RotationX) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j9;
        long m4875getUnspecified0d7_KjU10 = (i3 & Fields.RotationY) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j10;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(885588574, i, i2, "androidx.compose.material3.SliderDefaults.colors (Slider.kt:927)");
        }
        SliderColors m2910copyK518z4 = getDefaultSliderColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m2910copyK518z4(m4875getUnspecified0d7_KjU, m4875getUnspecified0d7_KjU2, m4875getUnspecified0d7_KjU3, m4875getUnspecified0d7_KjU4, m4875getUnspecified0d7_KjU5, m4875getUnspecified0d7_KjU6, m4875getUnspecified0d7_KjU7, m4875getUnspecified0d7_KjU8, m4875getUnspecified0d7_KjU9, m4875getUnspecified0d7_KjU10);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return m2910copyK518z4;
    }

    public final SliderColors getDefaultSliderColors$material3_release(ColorScheme colorScheme) {
        SliderColors defaultSliderColorsCached = colorScheme.getDefaultSliderColorsCached();
        if (defaultSliderColorsCached != null) {
            return defaultSliderColorsCached;
        }
        SliderColors sliderColors = new SliderColors(ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getHandleColor()), ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getActiveTrackColor()), Color.m4838copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getTickMarksActiveContainerColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getInactiveTrackColor()), Color.m4838copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getTickMarksInactiveContainerColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorKt.m4884compositeOverOWjLjI(Color.m4838copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getDisabledHandleColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), colorScheme.getSurface()), Color.m4838copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getDisabledActiveTrackColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), Color.m4838copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getTickMarksDisabledContainerColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), Color.m4838copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getDisabledInactiveTrackColor()), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), Color.m4838copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, SliderTokens.INSTANCE.getTickMarksDisabledContainerColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.setDefaultSliderColorsCached$material3_release(sliderColors);
        return sliderColors;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0069  */
    /* renamed from: Thumb-9LiSoMs, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m2926Thumb9LiSoMs(final MutableInteractionSource mutableInteractionSource, Modifier modifier, SliderColors sliderColors, boolean z, long j, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        SliderColors sliderColors2;
        int i4;
        boolean z2;
        int i5;
        long j2;
        long j3;
        int i6;
        boolean z3;
        Object rememberedValue;
        SnapshotStateList snapshotStateList;
        boolean z4;
        SliderDefaults$Thumb$1$1 rememberedValue2;
        final boolean z5;
        final Modifier modifier3;
        final SliderColors sliderColors3;
        final long j4;
        ScopeUpdateScope endRestartGroup;
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(-290277409);
        ComposerKt.sourceInformation(startRestartGroup, "C(Thumb)P(2,3!,4:c#ui.unit.DpSize)983@41717L8,987@41833L46,988@41922L658,988@41888L692,1006@42779L5,1014@43049L143,1009@42833L595:Slider.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(mutableInteractionSource) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i8 = i2 & 2;
        if (i8 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i & 384) != 0) {
                if ((i2 & 4) == 0) {
                    sliderColors2 = sliderColors;
                    if (startRestartGroup.changed(sliderColors2)) {
                        i7 = Fields.RotationX;
                        i3 |= i7;
                    }
                } else {
                    sliderColors2 = sliderColors;
                }
                i7 = Fields.SpotShadowColor;
                i3 |= i7;
            } else {
                sliderColors2 = sliderColors;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? Fields.CameraDistance : Fields.RotationZ;
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    j2 = j;
                    i3 |= startRestartGroup.changed(j2) ? Fields.Clip : Fields.Shape;
                    if ((i2 & 32) == 0) {
                        i3 |= 196608;
                    } else if ((i & 196608) == 0) {
                        i3 |= startRestartGroup.changed(this) ? Fields.RenderEffect : 65536;
                    }
                    if ((i3 & 74899) == 74898 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            if (i8 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 4) != 0) {
                                SliderColors colors = colors(startRestartGroup, (i3 >> 15) & 14);
                                i3 &= -897;
                                sliderColors2 = colors;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if (i5 != 0) {
                                j3 = SliderKt.ThumbSize;
                                i6 = i3;
                                z3 = z2;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-290277409, i6, -1, "androidx.compose.material3.SliderDefaults.Thumb (Slider.kt:986)");
                                }
                                startRestartGroup.startReplaceableGroup(-1142853013);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                                rememberedValue = startRestartGroup.rememberedValue();
                                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = SnapshotStateKt.mutableStateListOf();
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                snapshotStateList = (SnapshotStateList) rememberedValue;
                                startRestartGroup.endReplaceableGroup();
                                startRestartGroup.startReplaceableGroup(-1142852924);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                                int i9 = i6 & 14;
                                z4 = i9 == 4;
                                rememberedValue2 = startRestartGroup.rememberedValue();
                                if (!z4 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue2 = new SliderDefaults$Thumb$1$1(mutableInteractionSource, snapshotStateList, null);
                                    startRestartGroup.updateRememberedValue(rememberedValue2);
                                }
                                startRestartGroup.endReplaceableGroup();
                                EffectsKt.LaunchedEffect(mutableInteractionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue2, startRestartGroup, i9);
                                float f = snapshotStateList.isEmpty() ^ true ? SliderKt.ThumbPressedElevation : SliderKt.ThumbDefaultElevation;
                                Shape value = ShapesKt.getValue(SliderTokens.INSTANCE.getHandleShape(), startRestartGroup, 6);
                                long j5 = j3;
                                Modifier hoverable$default = HoverableKt.hoverable$default(IndicationKt.indication(SizeKt.m1121size6HolHcs(modifier2, j3), mutableInteractionSource, RippleKt.m2177rememberRipple9IZ8Weo(false, Dp.constructor-impl(SliderTokens.INSTANCE.m3895getStateLayerSizeD9Ej5fM() / 2), 0L, startRestartGroup, 54, 4)), mutableInteractionSource, false, 2, null);
                                if (!z3) {
                                    f = Dp.constructor-impl(0);
                                }
                                SpacerKt.Spacer(BackgroundKt.m396backgroundbw27NRU(ShadowKt.m4425shadows4CzXII$default(hoverable$default, f, value, false, 0L, 0L, 24, null), sliderColors2.m2921thumbColorvNxB06k$material3_release(z3), value), startRestartGroup, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                z5 = z3;
                                modifier3 = modifier2;
                                sliderColors3 = sliderColors2;
                                j4 = j5;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                            }
                        }
                        i6 = i3;
                        z3 = z2;
                        j3 = j2;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        startRestartGroup.startReplaceableGroup(-1142853013);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                        }
                        snapshotStateList = (SnapshotStateList) rememberedValue;
                        startRestartGroup.endReplaceableGroup();
                        startRestartGroup.startReplaceableGroup(-1142852924);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                        int i92 = i6 & 14;
                        if (i92 == 4) {
                        }
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        if (!z4) {
                        }
                        rememberedValue2 = new SliderDefaults$Thumb$1$1(mutableInteractionSource, snapshotStateList, null);
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                        startRestartGroup.endReplaceableGroup();
                        EffectsKt.LaunchedEffect(mutableInteractionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue2, startRestartGroup, i92);
                        if (snapshotStateList.isEmpty() ^ true) {
                        }
                        Shape value2 = ShapesKt.getValue(SliderTokens.INSTANCE.getHandleShape(), startRestartGroup, 6);
                        long j52 = j3;
                        Modifier hoverable$default2 = HoverableKt.hoverable$default(IndicationKt.indication(SizeKt.m1121size6HolHcs(modifier2, j3), mutableInteractionSource, RippleKt.m2177rememberRipple9IZ8Weo(false, Dp.constructor-impl(SliderTokens.INSTANCE.m3895getStateLayerSizeD9Ej5fM() / 2), 0L, startRestartGroup, 54, 4)), mutableInteractionSource, false, 2, null);
                        if (!z3) {
                        }
                        SpacerKt.Spacer(BackgroundKt.m396backgroundbw27NRU(ShadowKt.m4425shadows4CzXII$default(hoverable$default2, f, value2, false, 0L, 0L, 24, null), sliderColors2.m2921thumbColorvNxB06k$material3_release(z3), value2), startRestartGroup, 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        z5 = z3;
                        modifier3 = modifier2;
                        sliderColors3 = sliderColors2;
                        j4 = j52;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        sliderColors3 = sliderColors2;
                        z5 = z2;
                        j4 = j2;
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Thumb$2
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i10) {
                                SliderDefaults.this.m2926Thumb9LiSoMs(mutableInteractionSource, modifier3, sliderColors3, z5, j4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                j2 = j;
                if ((i2 & 32) == 0) {
                }
                if ((i3 & 74899) == 74898) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i8 != 0) {
                }
                if ((i2 & 4) != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                i6 = i3;
                z3 = z2;
                j3 = j2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup.startReplaceableGroup(-1142853013);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                }
                snapshotStateList = (SnapshotStateList) rememberedValue;
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(-1142852924);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
                int i922 = i6 & 14;
                if (i922 == 4) {
                }
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (!z4) {
                }
                rememberedValue2 = new SliderDefaults$Thumb$1$1(mutableInteractionSource, snapshotStateList, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
                startRestartGroup.endReplaceableGroup();
                EffectsKt.LaunchedEffect(mutableInteractionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue2, startRestartGroup, i922);
                if (snapshotStateList.isEmpty() ^ true) {
                }
                Shape value22 = ShapesKt.getValue(SliderTokens.INSTANCE.getHandleShape(), startRestartGroup, 6);
                long j522 = j3;
                Modifier hoverable$default22 = HoverableKt.hoverable$default(IndicationKt.indication(SizeKt.m1121size6HolHcs(modifier2, j3), mutableInteractionSource, RippleKt.m2177rememberRipple9IZ8Weo(false, Dp.constructor-impl(SliderTokens.INSTANCE.m3895getStateLayerSizeD9Ej5fM() / 2), 0L, startRestartGroup, 54, 4)), mutableInteractionSource, false, 2, null);
                if (!z3) {
                }
                SpacerKt.Spacer(BackgroundKt.m396backgroundbw27NRU(ShadowKt.m4425shadows4CzXII$default(hoverable$default22, f, value22, false, 0L, 0L, 24, null), sliderColors2.m2921thumbColorvNxB06k$material3_release(z3), value22), startRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                z5 = z3;
                modifier3 = modifier2;
                sliderColors3 = sliderColors2;
                j4 = j522;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z2 = z;
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            j2 = j;
            if ((i2 & 32) == 0) {
            }
            if ((i3 & 74899) == 74898) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i8 != 0) {
            }
            if ((i2 & 4) != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            i6 = i3;
            z3 = z2;
            j3 = j2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceableGroup(-1142853013);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
            rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            }
            snapshotStateList = (SnapshotStateList) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-1142852924);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
            int i9222 = i6 & 14;
            if (i9222 == 4) {
            }
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (!z4) {
            }
            rememberedValue2 = new SliderDefaults$Thumb$1$1(mutableInteractionSource, snapshotStateList, null);
            startRestartGroup.updateRememberedValue(rememberedValue2);
            startRestartGroup.endReplaceableGroup();
            EffectsKt.LaunchedEffect(mutableInteractionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue2, startRestartGroup, i9222);
            if (snapshotStateList.isEmpty() ^ true) {
            }
            Shape value222 = ShapesKt.getValue(SliderTokens.INSTANCE.getHandleShape(), startRestartGroup, 6);
            long j5222 = j3;
            Modifier hoverable$default222 = HoverableKt.hoverable$default(IndicationKt.indication(SizeKt.m1121size6HolHcs(modifier2, j3), mutableInteractionSource, RippleKt.m2177rememberRipple9IZ8Weo(false, Dp.constructor-impl(SliderTokens.INSTANCE.m3895getStateLayerSizeD9Ej5fM() / 2), 0L, startRestartGroup, 54, 4)), mutableInteractionSource, false, 2, null);
            if (!z3) {
            }
            SpacerKt.Spacer(BackgroundKt.m396backgroundbw27NRU(ShadowKt.m4425shadows4CzXII$default(hoverable$default222, f, value222, false, 0L, 0L, 24, null), sliderColors2.m2921thumbColorvNxB06k$material3_release(z3), value222), startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            z5 = z3;
            modifier3 = modifier2;
            sliderColors3 = sliderColors2;
            j4 = j5222;
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
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        j2 = j;
        if ((i2 & 32) == 0) {
        }
        if ((i3 & 74899) == 74898) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i8 != 0) {
        }
        if ((i2 & 4) != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        i6 = i3;
        z3 = z2;
        j3 = j2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceableGroup(-1142853013);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
        }
        snapshotStateList = (SnapshotStateList) rememberedValue;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(-1142852924);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Slider.kt#9igjgp");
        int i92222 = i6 & 14;
        if (i92222 == 4) {
        }
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (!z4) {
        }
        rememberedValue2 = new SliderDefaults$Thumb$1$1(mutableInteractionSource, snapshotStateList, null);
        startRestartGroup.updateRememberedValue(rememberedValue2);
        startRestartGroup.endReplaceableGroup();
        EffectsKt.LaunchedEffect(mutableInteractionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue2, startRestartGroup, i92222);
        if (snapshotStateList.isEmpty() ^ true) {
        }
        Shape value2222 = ShapesKt.getValue(SliderTokens.INSTANCE.getHandleShape(), startRestartGroup, 6);
        long j52222 = j3;
        Modifier hoverable$default2222 = HoverableKt.hoverable$default(IndicationKt.indication(SizeKt.m1121size6HolHcs(modifier2, j3), mutableInteractionSource, RippleKt.m2177rememberRipple9IZ8Weo(false, Dp.constructor-impl(SliderTokens.INSTANCE.m3895getStateLayerSizeD9Ej5fM() / 2), 0L, startRestartGroup, 54, 4)), mutableInteractionSource, false, 2, null);
        if (!z3) {
        }
        SpacerKt.Spacer(BackgroundKt.m396backgroundbw27NRU(ShadowKt.m4425shadows4CzXII$default(hoverable$default2222, f, value2222, false, 0L, 0L, 24, null), sliderColors2.m2921thumbColorvNxB06k$material3_release(z3), value2222), startRestartGroup, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        z5 = z3;
        modifier3 = modifier2;
        sliderColors3 = sliderColors2;
        j4 = j52222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0065  */
    @Deprecated(message = "Use version that supports slider state")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Track(final SliderPositions sliderPositions, Modifier modifier, SliderColors sliderColors, boolean z, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        SliderColors sliderColors2;
        int i4;
        boolean z2;
        Modifier.Companion companion;
        boolean z3;
        Composer composer2;
        boolean changed;
        Object rememberedValue;
        final SliderColors sliderColors3;
        final Modifier modifier3;
        final boolean z4;
        ScopeUpdateScope endRestartGroup;
        int i5;
        Composer startRestartGroup = composer.startRestartGroup(-1546713545);
        ComposerKt.sourceInformation(startRestartGroup, "C(Track)P(3,2)1043@44335L8,1054@44796L1870,1050@44688L1978:Slider.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(sliderPositions) ? 4 : 2) | i;
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
                    sliderColors2 = sliderColors;
                    if (startRestartGroup.changed(sliderColors2)) {
                        i5 = Fields.RotationX;
                        i3 |= i5;
                    }
                } else {
                    sliderColors2 = sliderColors;
                }
                i5 = Fields.SpotShadowColor;
                i3 |= i5;
            } else {
                sliderColors2 = sliderColors;
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
                    i3 |= startRestartGroup.changed(this) ? Fields.Clip : Fields.Shape;
                }
                if ((i3 & 9363) == 9362 || !startRestartGroup.getSkipping()) {
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                        companion = i6 != 0 ? Modifier.INSTANCE : modifier2;
                        if ((i2 & 4) != 0) {
                            SliderColors colors = colors(startRestartGroup, (i3 >> 12) & 14);
                            i3 &= -897;
                            sliderColors2 = colors;
                        }
                        if (i4 != 0) {
                            z3 = true;
                            SliderColors sliderColors4 = sliderColors2;
                            int i7 = i3;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1546713545, i7, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1045)");
                            }
                            final long m2923trackColorWaAFU9c$material3_release = sliderColors4.m2923trackColorWaAFU9c$material3_release(z3, false);
                            final long m2923trackColorWaAFU9c$material3_release2 = sliderColors4.m2923trackColorWaAFU9c$material3_release(z3, true);
                            final long m2922tickColorWaAFU9c$material3_release = sliderColors4.m2922tickColorWaAFU9c$material3_release(z3, false);
                            final long m2922tickColorWaAFU9c$material3_release2 = sliderColors4.m2922tickColorWaAFU9c$material3_release(z3, true);
                            Modifier m1106height3ABfNKs = SizeKt.m1106height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), SliderKt.getTrackHeight());
                            composer2 = startRestartGroup;
                            composer2.startReplaceableGroup(-1134219991);
                            ComposerKt.sourceInformation(composer2, "CC(remember):Slider.kt#9igjgp");
                            changed = composer2.changed(m2923trackColorWaAFU9c$material3_release) | ((i7 & 14) != 4) | composer2.changed(m2923trackColorWaAFU9c$material3_release2) | composer2.changed(m2922tickColorWaAFU9c$material3_release) | composer2.changed(m2922tickColorWaAFU9c$material3_release2);
                            rememberedValue = composer2.rememberedValue();
                            if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$1$1
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
                                        boolean z5 = drawScope.getLayoutDirection() == LayoutDirection.Rtl;
                                        long Offset = OffsetKt.Offset(0.0f, Offset.m4594getYimpl(drawScope.m5416getCenterF1C5BW0()));
                                        long Offset2 = OffsetKt.Offset(Size.m4662getWidthimpl(drawScope.m5417getSizeNHjbRc()), Offset.m4594getYimpl(drawScope.m5416getCenterF1C5BW0()));
                                        long j = z5 ? Offset2 : Offset;
                                        long j2 = z5 ? Offset : Offset2;
                                        f = SliderKt.TickSize;
                                        float f2 = drawScope.toPx-0680j_4(f);
                                        float f3 = drawScope.toPx-0680j_4(SliderKt.getTrackHeight());
                                        long j3 = j2;
                                        long j4 = j;
                                        DrawScope.m5403drawLineNGM6Ib0$default(drawScope, m2923trackColorWaAFU9c$material3_release, j, j2, f3, StrokeCap.INSTANCE.m5212getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
                                        DrawScope.m5403drawLineNGM6Ib0$default(drawScope, m2923trackColorWaAFU9c$material3_release2, OffsetKt.Offset(Offset.m4593getXimpl(j4) + ((Offset.m4593getXimpl(j3) - Offset.m4593getXimpl(j4)) * ((Number) sliderPositions.getActiveRange().getStart()).floatValue()), Offset.m4594getYimpl(drawScope.m5416getCenterF1C5BW0())), OffsetKt.Offset(Offset.m4593getXimpl(j4) + ((Offset.m4593getXimpl(j3) - Offset.m4593getXimpl(j4)) * ((Number) sliderPositions.getActiveRange().getEndInclusive()).floatValue()), Offset.m4594getYimpl(drawScope.m5416getCenterF1C5BW0())), f3, StrokeCap.INSTANCE.m5212getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
                                        float[] tickFractions = sliderPositions.getTickFractions();
                                        SliderPositions sliderPositions2 = sliderPositions;
                                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                                        int length = tickFractions.length;
                                        for (int i8 = 0; i8 < length; i8++) {
                                            float f4 = tickFractions[i8];
                                            Boolean valueOf = Boolean.valueOf(f4 > ((Number) sliderPositions2.getActiveRange().getEndInclusive()).floatValue() || f4 < ((Number) sliderPositions2.getActiveRange().getStart()).floatValue());
                                            Object obj = linkedHashMap.get(valueOf);
                                            if (obj == null) {
                                                obj = (List) new ArrayList();
                                                linkedHashMap.put(valueOf, obj);
                                            }
                                            ((List) obj).add(Float.valueOf(f4));
                                        }
                                        long j5 = m2922tickColorWaAFU9c$material3_release;
                                        long j6 = m2922tickColorWaAFU9c$material3_release2;
                                        for (Map.Entry entry : linkedHashMap.entrySet()) {
                                            boolean booleanValue = ((Boolean) entry.getKey()).booleanValue();
                                            List list = (List) entry.getValue();
                                            ArrayList arrayList = new ArrayList(list.size());
                                            int size = list.size();
                                            int i9 = 0;
                                            while (i9 < size) {
                                                long j7 = j4;
                                                arrayList.add(Offset.m4582boximpl(OffsetKt.Offset(Offset.m4593getXimpl(OffsetKt.m4616lerpWko1d7g(j7, j3, ((Number) list.get(i9)).floatValue())), Offset.m4594getYimpl(drawScope.m5416getCenterF1C5BW0()))));
                                                i9++;
                                                j4 = j7;
                                            }
                                            long j8 = j4;
                                            j3 = j3;
                                            DrawScope.m5408drawPointsF8ZwMP8$default(drawScope, arrayList, PointMode.INSTANCE.m5158getPointsr_lszbg(), booleanValue ? j5 : j6, f2, StrokeCap.INSTANCE.m5212getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
                                            j6 = j6;
                                            j4 = j8;
                                        }
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue);
                            }
                            composer2.endReplaceableGroup();
                            CanvasKt.Canvas(m1106height3ABfNKs, (Function1) rememberedValue, composer2, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            sliderColors3 = sliderColors4;
                            modifier3 = companion;
                            z4 = z3;
                        }
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        companion = modifier2;
                    }
                    z3 = z2;
                    SliderColors sliderColors42 = sliderColors2;
                    int i72 = i3;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    final long m2923trackColorWaAFU9c$material3_release3 = sliderColors42.m2923trackColorWaAFU9c$material3_release(z3, false);
                    final long m2923trackColorWaAFU9c$material3_release22 = sliderColors42.m2923trackColorWaAFU9c$material3_release(z3, true);
                    final long m2922tickColorWaAFU9c$material3_release3 = sliderColors42.m2922tickColorWaAFU9c$material3_release(z3, false);
                    final long m2922tickColorWaAFU9c$material3_release22 = sliderColors42.m2922tickColorWaAFU9c$material3_release(z3, true);
                    Modifier m1106height3ABfNKs2 = SizeKt.m1106height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), SliderKt.getTrackHeight());
                    composer2 = startRestartGroup;
                    composer2.startReplaceableGroup(-1134219991);
                    ComposerKt.sourceInformation(composer2, "CC(remember):Slider.kt#9igjgp");
                    changed = composer2.changed(m2923trackColorWaAFU9c$material3_release3) | ((i72 & 14) != 4) | composer2.changed(m2923trackColorWaAFU9c$material3_release22) | composer2.changed(m2922tickColorWaAFU9c$material3_release3) | composer2.changed(m2922tickColorWaAFU9c$material3_release22);
                    rememberedValue = composer2.rememberedValue();
                    if (!changed) {
                    }
                    rememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$1$1
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
                            boolean z5 = drawScope.getLayoutDirection() == LayoutDirection.Rtl;
                            long Offset = OffsetKt.Offset(0.0f, Offset.m4594getYimpl(drawScope.m5416getCenterF1C5BW0()));
                            long Offset2 = OffsetKt.Offset(Size.m4662getWidthimpl(drawScope.m5417getSizeNHjbRc()), Offset.m4594getYimpl(drawScope.m5416getCenterF1C5BW0()));
                            long j = z5 ? Offset2 : Offset;
                            long j2 = z5 ? Offset : Offset2;
                            f = SliderKt.TickSize;
                            float f2 = drawScope.toPx-0680j_4(f);
                            float f3 = drawScope.toPx-0680j_4(SliderKt.getTrackHeight());
                            long j3 = j2;
                            long j4 = j;
                            DrawScope.m5403drawLineNGM6Ib0$default(drawScope, m2923trackColorWaAFU9c$material3_release3, j, j2, f3, StrokeCap.INSTANCE.m5212getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
                            DrawScope.m5403drawLineNGM6Ib0$default(drawScope, m2923trackColorWaAFU9c$material3_release22, OffsetKt.Offset(Offset.m4593getXimpl(j4) + ((Offset.m4593getXimpl(j3) - Offset.m4593getXimpl(j4)) * ((Number) sliderPositions.getActiveRange().getStart()).floatValue()), Offset.m4594getYimpl(drawScope.m5416getCenterF1C5BW0())), OffsetKt.Offset(Offset.m4593getXimpl(j4) + ((Offset.m4593getXimpl(j3) - Offset.m4593getXimpl(j4)) * ((Number) sliderPositions.getActiveRange().getEndInclusive()).floatValue()), Offset.m4594getYimpl(drawScope.m5416getCenterF1C5BW0())), f3, StrokeCap.INSTANCE.m5212getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
                            float[] tickFractions = sliderPositions.getTickFractions();
                            SliderPositions sliderPositions2 = sliderPositions;
                            LinkedHashMap linkedHashMap = new LinkedHashMap();
                            int length = tickFractions.length;
                            for (int i8 = 0; i8 < length; i8++) {
                                float f4 = tickFractions[i8];
                                Boolean valueOf = Boolean.valueOf(f4 > ((Number) sliderPositions2.getActiveRange().getEndInclusive()).floatValue() || f4 < ((Number) sliderPositions2.getActiveRange().getStart()).floatValue());
                                Object obj = linkedHashMap.get(valueOf);
                                if (obj == null) {
                                    obj = (List) new ArrayList();
                                    linkedHashMap.put(valueOf, obj);
                                }
                                ((List) obj).add(Float.valueOf(f4));
                            }
                            long j5 = m2922tickColorWaAFU9c$material3_release3;
                            long j6 = m2922tickColorWaAFU9c$material3_release22;
                            for (Map.Entry entry : linkedHashMap.entrySet()) {
                                boolean booleanValue = ((Boolean) entry.getKey()).booleanValue();
                                List list = (List) entry.getValue();
                                ArrayList arrayList = new ArrayList(list.size());
                                int size = list.size();
                                int i9 = 0;
                                while (i9 < size) {
                                    long j7 = j4;
                                    arrayList.add(Offset.m4582boximpl(OffsetKt.Offset(Offset.m4593getXimpl(OffsetKt.m4616lerpWko1d7g(j7, j3, ((Number) list.get(i9)).floatValue())), Offset.m4594getYimpl(drawScope.m5416getCenterF1C5BW0()))));
                                    i9++;
                                    j4 = j7;
                                }
                                long j8 = j4;
                                j3 = j3;
                                DrawScope.m5408drawPointsF8ZwMP8$default(drawScope, arrayList, PointMode.INSTANCE.m5158getPointsr_lszbg(), booleanValue ? j5 : j6, f2, StrokeCap.INSTANCE.m5212getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
                                j6 = j6;
                                j4 = j8;
                            }
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue);
                    composer2.endReplaceableGroup();
                    CanvasKt.Canvas(m1106height3ABfNKs2, (Function1) rememberedValue, composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    sliderColors3 = sliderColors42;
                    modifier3 = companion;
                    z4 = z3;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    composer2 = startRestartGroup;
                    modifier3 = modifier2;
                    sliderColors3 = sliderColors2;
                    z4 = z2;
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i8) {
                            SliderDefaults.this.Track(sliderPositions, modifier3, sliderColors3, z4, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
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
            z3 = z2;
            SliderColors sliderColors422 = sliderColors2;
            int i722 = i3;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            final long m2923trackColorWaAFU9c$material3_release32 = sliderColors422.m2923trackColorWaAFU9c$material3_release(z3, false);
            final long m2923trackColorWaAFU9c$material3_release222 = sliderColors422.m2923trackColorWaAFU9c$material3_release(z3, true);
            final long m2922tickColorWaAFU9c$material3_release32 = sliderColors422.m2922tickColorWaAFU9c$material3_release(z3, false);
            final long m2922tickColorWaAFU9c$material3_release222 = sliderColors422.m2922tickColorWaAFU9c$material3_release(z3, true);
            Modifier m1106height3ABfNKs22 = SizeKt.m1106height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), SliderKt.getTrackHeight());
            composer2 = startRestartGroup;
            composer2.startReplaceableGroup(-1134219991);
            ComposerKt.sourceInformation(composer2, "CC(remember):Slider.kt#9igjgp");
            changed = composer2.changed(m2923trackColorWaAFU9c$material3_release32) | ((i722 & 14) != 4) | composer2.changed(m2923trackColorWaAFU9c$material3_release222) | composer2.changed(m2922tickColorWaAFU9c$material3_release32) | composer2.changed(m2922tickColorWaAFU9c$material3_release222);
            rememberedValue = composer2.rememberedValue();
            if (!changed) {
            }
            rememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$1$1
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
                    boolean z5 = drawScope.getLayoutDirection() == LayoutDirection.Rtl;
                    long Offset = OffsetKt.Offset(0.0f, Offset.m4594getYimpl(drawScope.m5416getCenterF1C5BW0()));
                    long Offset2 = OffsetKt.Offset(Size.m4662getWidthimpl(drawScope.m5417getSizeNHjbRc()), Offset.m4594getYimpl(drawScope.m5416getCenterF1C5BW0()));
                    long j = z5 ? Offset2 : Offset;
                    long j2 = z5 ? Offset : Offset2;
                    f = SliderKt.TickSize;
                    float f2 = drawScope.toPx-0680j_4(f);
                    float f3 = drawScope.toPx-0680j_4(SliderKt.getTrackHeight());
                    long j3 = j2;
                    long j4 = j;
                    DrawScope.m5403drawLineNGM6Ib0$default(drawScope, m2923trackColorWaAFU9c$material3_release32, j, j2, f3, StrokeCap.INSTANCE.m5212getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
                    DrawScope.m5403drawLineNGM6Ib0$default(drawScope, m2923trackColorWaAFU9c$material3_release222, OffsetKt.Offset(Offset.m4593getXimpl(j4) + ((Offset.m4593getXimpl(j3) - Offset.m4593getXimpl(j4)) * ((Number) sliderPositions.getActiveRange().getStart()).floatValue()), Offset.m4594getYimpl(drawScope.m5416getCenterF1C5BW0())), OffsetKt.Offset(Offset.m4593getXimpl(j4) + ((Offset.m4593getXimpl(j3) - Offset.m4593getXimpl(j4)) * ((Number) sliderPositions.getActiveRange().getEndInclusive()).floatValue()), Offset.m4594getYimpl(drawScope.m5416getCenterF1C5BW0())), f3, StrokeCap.INSTANCE.m5212getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
                    float[] tickFractions = sliderPositions.getTickFractions();
                    SliderPositions sliderPositions2 = sliderPositions;
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    int length = tickFractions.length;
                    for (int i8 = 0; i8 < length; i8++) {
                        float f4 = tickFractions[i8];
                        Boolean valueOf = Boolean.valueOf(f4 > ((Number) sliderPositions2.getActiveRange().getEndInclusive()).floatValue() || f4 < ((Number) sliderPositions2.getActiveRange().getStart()).floatValue());
                        Object obj = linkedHashMap.get(valueOf);
                        if (obj == null) {
                            obj = (List) new ArrayList();
                            linkedHashMap.put(valueOf, obj);
                        }
                        ((List) obj).add(Float.valueOf(f4));
                    }
                    long j5 = m2922tickColorWaAFU9c$material3_release32;
                    long j6 = m2922tickColorWaAFU9c$material3_release222;
                    for (Map.Entry entry : linkedHashMap.entrySet()) {
                        boolean booleanValue = ((Boolean) entry.getKey()).booleanValue();
                        List list = (List) entry.getValue();
                        ArrayList arrayList = new ArrayList(list.size());
                        int size = list.size();
                        int i9 = 0;
                        while (i9 < size) {
                            long j7 = j4;
                            arrayList.add(Offset.m4582boximpl(OffsetKt.Offset(Offset.m4593getXimpl(OffsetKt.m4616lerpWko1d7g(j7, j3, ((Number) list.get(i9)).floatValue())), Offset.m4594getYimpl(drawScope.m5416getCenterF1C5BW0()))));
                            i9++;
                            j4 = j7;
                        }
                        long j8 = j4;
                        j3 = j3;
                        DrawScope.m5408drawPointsF8ZwMP8$default(drawScope, arrayList, PointMode.INSTANCE.m5158getPointsr_lszbg(), booleanValue ? j5 : j6, f2, StrokeCap.INSTANCE.m5212getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
                        j6 = j6;
                        j4 = j8;
                    }
                }
            };
            composer2.updateRememberedValue(rememberedValue);
            composer2.endReplaceableGroup();
            CanvasKt.Canvas(m1106height3ABfNKs22, (Function1) rememberedValue, composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            sliderColors3 = sliderColors422;
            modifier3 = companion;
            z4 = z3;
            endRestartGroup = composer2.endRestartGroup();
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
        z3 = z2;
        SliderColors sliderColors4222 = sliderColors2;
        int i7222 = i3;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        final long m2923trackColorWaAFU9c$material3_release322 = sliderColors4222.m2923trackColorWaAFU9c$material3_release(z3, false);
        final long m2923trackColorWaAFU9c$material3_release2222 = sliderColors4222.m2923trackColorWaAFU9c$material3_release(z3, true);
        final long m2922tickColorWaAFU9c$material3_release322 = sliderColors4222.m2922tickColorWaAFU9c$material3_release(z3, false);
        final long m2922tickColorWaAFU9c$material3_release2222 = sliderColors4222.m2922tickColorWaAFU9c$material3_release(z3, true);
        Modifier m1106height3ABfNKs222 = SizeKt.m1106height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), SliderKt.getTrackHeight());
        composer2 = startRestartGroup;
        composer2.startReplaceableGroup(-1134219991);
        ComposerKt.sourceInformation(composer2, "CC(remember):Slider.kt#9igjgp");
        changed = composer2.changed(m2923trackColorWaAFU9c$material3_release322) | ((i7222 & 14) != 4) | composer2.changed(m2923trackColorWaAFU9c$material3_release2222) | composer2.changed(m2922tickColorWaAFU9c$material3_release322) | composer2.changed(m2922tickColorWaAFU9c$material3_release2222);
        rememberedValue = composer2.rememberedValue();
        if (!changed) {
        }
        rememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$1$1
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
                boolean z5 = drawScope.getLayoutDirection() == LayoutDirection.Rtl;
                long Offset = OffsetKt.Offset(0.0f, Offset.m4594getYimpl(drawScope.m5416getCenterF1C5BW0()));
                long Offset2 = OffsetKt.Offset(Size.m4662getWidthimpl(drawScope.m5417getSizeNHjbRc()), Offset.m4594getYimpl(drawScope.m5416getCenterF1C5BW0()));
                long j = z5 ? Offset2 : Offset;
                long j2 = z5 ? Offset : Offset2;
                f = SliderKt.TickSize;
                float f2 = drawScope.toPx-0680j_4(f);
                float f3 = drawScope.toPx-0680j_4(SliderKt.getTrackHeight());
                long j3 = j2;
                long j4 = j;
                DrawScope.m5403drawLineNGM6Ib0$default(drawScope, m2923trackColorWaAFU9c$material3_release322, j, j2, f3, StrokeCap.INSTANCE.m5212getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
                DrawScope.m5403drawLineNGM6Ib0$default(drawScope, m2923trackColorWaAFU9c$material3_release2222, OffsetKt.Offset(Offset.m4593getXimpl(j4) + ((Offset.m4593getXimpl(j3) - Offset.m4593getXimpl(j4)) * ((Number) sliderPositions.getActiveRange().getStart()).floatValue()), Offset.m4594getYimpl(drawScope.m5416getCenterF1C5BW0())), OffsetKt.Offset(Offset.m4593getXimpl(j4) + ((Offset.m4593getXimpl(j3) - Offset.m4593getXimpl(j4)) * ((Number) sliderPositions.getActiveRange().getEndInclusive()).floatValue()), Offset.m4594getYimpl(drawScope.m5416getCenterF1C5BW0())), f3, StrokeCap.INSTANCE.m5212getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
                float[] tickFractions = sliderPositions.getTickFractions();
                SliderPositions sliderPositions2 = sliderPositions;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                int length = tickFractions.length;
                for (int i8 = 0; i8 < length; i8++) {
                    float f4 = tickFractions[i8];
                    Boolean valueOf = Boolean.valueOf(f4 > ((Number) sliderPositions2.getActiveRange().getEndInclusive()).floatValue() || f4 < ((Number) sliderPositions2.getActiveRange().getStart()).floatValue());
                    Object obj = linkedHashMap.get(valueOf);
                    if (obj == null) {
                        obj = (List) new ArrayList();
                        linkedHashMap.put(valueOf, obj);
                    }
                    ((List) obj).add(Float.valueOf(f4));
                }
                long j5 = m2922tickColorWaAFU9c$material3_release322;
                long j6 = m2922tickColorWaAFU9c$material3_release2222;
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    boolean booleanValue = ((Boolean) entry.getKey()).booleanValue();
                    List list = (List) entry.getValue();
                    ArrayList arrayList = new ArrayList(list.size());
                    int size = list.size();
                    int i9 = 0;
                    while (i9 < size) {
                        long j7 = j4;
                        arrayList.add(Offset.m4582boximpl(OffsetKt.Offset(Offset.m4593getXimpl(OffsetKt.m4616lerpWko1d7g(j7, j3, ((Number) list.get(i9)).floatValue())), Offset.m4594getYimpl(drawScope.m5416getCenterF1C5BW0()))));
                        i9++;
                        j4 = j7;
                    }
                    long j8 = j4;
                    j3 = j3;
                    DrawScope.m5408drawPointsF8ZwMP8$default(drawScope, arrayList, PointMode.INSTANCE.m5158getPointsr_lszbg(), booleanValue ? j5 : j6, f2, StrokeCap.INSTANCE.m5212getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
                    j6 = j6;
                    j4 = j8;
                }
            }
        };
        composer2.updateRememberedValue(rememberedValue);
        composer2.endReplaceableGroup();
        CanvasKt.Canvas(m1106height3ABfNKs222, (Function1) rememberedValue, composer2, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        sliderColors3 = sliderColors4222;
        modifier3 = companion;
        z4 = z3;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Track(final SliderState sliderState, Modifier modifier, SliderColors sliderColors, boolean z, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        SliderColors sliderColors2;
        int i4;
        boolean z2;
        Modifier.Companion companion;
        boolean z3;
        Composer composer2;
        boolean changed;
        Object rememberedValue;
        final Modifier modifier3;
        final boolean z4;
        final SliderColors sliderColors3;
        ScopeUpdateScope endRestartGroup;
        int i5;
        Composer startRestartGroup = composer.startRestartGroup(593554206);
        ComposerKt.sourceInformation(startRestartGroup, "C(Track)P(3,2)1121@47426L8,1132@47886L300,1128@47778L408:Slider.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(sliderState) ? 4 : 2) | i;
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
                    sliderColors2 = sliderColors;
                    if (startRestartGroup.changed(sliderColors2)) {
                        i5 = Fields.RotationX;
                        i3 |= i5;
                    }
                } else {
                    sliderColors2 = sliderColors;
                }
                i5 = Fields.SpotShadowColor;
                i3 |= i5;
            } else {
                sliderColors2 = sliderColors;
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
                    i3 |= startRestartGroup.changed(this) ? Fields.Clip : Fields.Shape;
                }
                if ((i3 & 9363) == 9362 || !startRestartGroup.getSkipping()) {
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                        companion = i6 != 0 ? Modifier.INSTANCE : modifier2;
                        if ((i2 & 4) != 0) {
                            SliderColors colors = colors(startRestartGroup, (i3 >> 12) & 14);
                            i3 &= -897;
                            sliderColors2 = colors;
                        }
                        if (i4 != 0) {
                            z3 = true;
                            SliderColors sliderColors4 = sliderColors2;
                            int i7 = i3;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(593554206, i7, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1123)");
                            }
                            final long m2923trackColorWaAFU9c$material3_release = sliderColors4.m2923trackColorWaAFU9c$material3_release(z3, false);
                            final long m2923trackColorWaAFU9c$material3_release2 = sliderColors4.m2923trackColorWaAFU9c$material3_release(z3, true);
                            final long m2922tickColorWaAFU9c$material3_release = sliderColors4.m2922tickColorWaAFU9c$material3_release(z3, false);
                            final long m2922tickColorWaAFU9c$material3_release2 = sliderColors4.m2922tickColorWaAFU9c$material3_release(z3, true);
                            Modifier m1106height3ABfNKs = SizeKt.m1106height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), SliderKt.getTrackHeight());
                            composer2 = startRestartGroup;
                            composer2.startReplaceableGroup(-1134216901);
                            ComposerKt.sourceInformation(composer2, "CC(remember):Slider.kt#9igjgp");
                            Modifier modifier4 = companion;
                            changed = composer2.changed(m2923trackColorWaAFU9c$material3_release) | ((i7 & 14) == 4) | composer2.changed(m2923trackColorWaAFU9c$material3_release2) | composer2.changed(m2922tickColorWaAFU9c$material3_release) | composer2.changed(m2922tickColorWaAFU9c$material3_release2);
                            rememberedValue = composer2.rememberedValue();
                            if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$3$1
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
                                        SliderDefaults.INSTANCE.m2925drawTrackLUBghH0(drawScope, SliderState.this.getTickFractions(), 0.0f, SliderState.this.getCoercedValueAsFraction$material3_release(), m2923trackColorWaAFU9c$material3_release, m2923trackColorWaAFU9c$material3_release2, m2922tickColorWaAFU9c$material3_release, m2922tickColorWaAFU9c$material3_release2);
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue);
                            }
                            composer2.endReplaceableGroup();
                            CanvasKt.Canvas(m1106height3ABfNKs, (Function1) rememberedValue, composer2, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            z4 = z3;
                            sliderColors3 = sliderColors4;
                        }
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        companion = modifier2;
                    }
                    z3 = z2;
                    SliderColors sliderColors42 = sliderColors2;
                    int i72 = i3;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    final long m2923trackColorWaAFU9c$material3_release3 = sliderColors42.m2923trackColorWaAFU9c$material3_release(z3, false);
                    final long m2923trackColorWaAFU9c$material3_release22 = sliderColors42.m2923trackColorWaAFU9c$material3_release(z3, true);
                    final long m2922tickColorWaAFU9c$material3_release3 = sliderColors42.m2922tickColorWaAFU9c$material3_release(z3, false);
                    final long m2922tickColorWaAFU9c$material3_release22 = sliderColors42.m2922tickColorWaAFU9c$material3_release(z3, true);
                    Modifier m1106height3ABfNKs2 = SizeKt.m1106height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), SliderKt.getTrackHeight());
                    composer2 = startRestartGroup;
                    composer2.startReplaceableGroup(-1134216901);
                    ComposerKt.sourceInformation(composer2, "CC(remember):Slider.kt#9igjgp");
                    Modifier modifier42 = companion;
                    changed = composer2.changed(m2923trackColorWaAFU9c$material3_release3) | ((i72 & 14) == 4) | composer2.changed(m2923trackColorWaAFU9c$material3_release22) | composer2.changed(m2922tickColorWaAFU9c$material3_release3) | composer2.changed(m2922tickColorWaAFU9c$material3_release22);
                    rememberedValue = composer2.rememberedValue();
                    if (!changed) {
                    }
                    rememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$3$1
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
                            SliderDefaults.INSTANCE.m2925drawTrackLUBghH0(drawScope, SliderState.this.getTickFractions(), 0.0f, SliderState.this.getCoercedValueAsFraction$material3_release(), m2923trackColorWaAFU9c$material3_release3, m2923trackColorWaAFU9c$material3_release22, m2922tickColorWaAFU9c$material3_release3, m2922tickColorWaAFU9c$material3_release22);
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue);
                    composer2.endReplaceableGroup();
                    CanvasKt.Canvas(m1106height3ABfNKs2, (Function1) rememberedValue, composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier3 = modifier42;
                    z4 = z3;
                    sliderColors3 = sliderColors42;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    composer2 = startRestartGroup;
                    modifier3 = modifier2;
                    sliderColors3 = sliderColors2;
                    z4 = z2;
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$4
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i8) {
                            SliderDefaults.this.Track(sliderState, modifier3, sliderColors3, z4, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
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
            z3 = z2;
            SliderColors sliderColors422 = sliderColors2;
            int i722 = i3;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            final long m2923trackColorWaAFU9c$material3_release32 = sliderColors422.m2923trackColorWaAFU9c$material3_release(z3, false);
            final long m2923trackColorWaAFU9c$material3_release222 = sliderColors422.m2923trackColorWaAFU9c$material3_release(z3, true);
            final long m2922tickColorWaAFU9c$material3_release32 = sliderColors422.m2922tickColorWaAFU9c$material3_release(z3, false);
            final long m2922tickColorWaAFU9c$material3_release222 = sliderColors422.m2922tickColorWaAFU9c$material3_release(z3, true);
            Modifier m1106height3ABfNKs22 = SizeKt.m1106height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), SliderKt.getTrackHeight());
            composer2 = startRestartGroup;
            composer2.startReplaceableGroup(-1134216901);
            ComposerKt.sourceInformation(composer2, "CC(remember):Slider.kt#9igjgp");
            Modifier modifier422 = companion;
            changed = composer2.changed(m2923trackColorWaAFU9c$material3_release32) | ((i722 & 14) == 4) | composer2.changed(m2923trackColorWaAFU9c$material3_release222) | composer2.changed(m2922tickColorWaAFU9c$material3_release32) | composer2.changed(m2922tickColorWaAFU9c$material3_release222);
            rememberedValue = composer2.rememberedValue();
            if (!changed) {
            }
            rememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$3$1
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
                    SliderDefaults.INSTANCE.m2925drawTrackLUBghH0(drawScope, SliderState.this.getTickFractions(), 0.0f, SliderState.this.getCoercedValueAsFraction$material3_release(), m2923trackColorWaAFU9c$material3_release32, m2923trackColorWaAFU9c$material3_release222, m2922tickColorWaAFU9c$material3_release32, m2922tickColorWaAFU9c$material3_release222);
                }
            };
            composer2.updateRememberedValue(rememberedValue);
            composer2.endReplaceableGroup();
            CanvasKt.Canvas(m1106height3ABfNKs22, (Function1) rememberedValue, composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier422;
            z4 = z3;
            sliderColors3 = sliderColors422;
            endRestartGroup = composer2.endRestartGroup();
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
        z3 = z2;
        SliderColors sliderColors4222 = sliderColors2;
        int i7222 = i3;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        final long m2923trackColorWaAFU9c$material3_release322 = sliderColors4222.m2923trackColorWaAFU9c$material3_release(z3, false);
        final long m2923trackColorWaAFU9c$material3_release2222 = sliderColors4222.m2923trackColorWaAFU9c$material3_release(z3, true);
        final long m2922tickColorWaAFU9c$material3_release322 = sliderColors4222.m2922tickColorWaAFU9c$material3_release(z3, false);
        final long m2922tickColorWaAFU9c$material3_release2222 = sliderColors4222.m2922tickColorWaAFU9c$material3_release(z3, true);
        Modifier m1106height3ABfNKs222 = SizeKt.m1106height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), SliderKt.getTrackHeight());
        composer2 = startRestartGroup;
        composer2.startReplaceableGroup(-1134216901);
        ComposerKt.sourceInformation(composer2, "CC(remember):Slider.kt#9igjgp");
        Modifier modifier4222 = companion;
        changed = composer2.changed(m2923trackColorWaAFU9c$material3_release322) | ((i7222 & 14) == 4) | composer2.changed(m2923trackColorWaAFU9c$material3_release2222) | composer2.changed(m2922tickColorWaAFU9c$material3_release322) | composer2.changed(m2922tickColorWaAFU9c$material3_release2222);
        rememberedValue = composer2.rememberedValue();
        if (!changed) {
        }
        rememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$3$1
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
                SliderDefaults.INSTANCE.m2925drawTrackLUBghH0(drawScope, SliderState.this.getTickFractions(), 0.0f, SliderState.this.getCoercedValueAsFraction$material3_release(), m2923trackColorWaAFU9c$material3_release322, m2923trackColorWaAFU9c$material3_release2222, m2922tickColorWaAFU9c$material3_release322, m2922tickColorWaAFU9c$material3_release2222);
            }
        };
        composer2.updateRememberedValue(rememberedValue);
        composer2.endReplaceableGroup();
        CanvasKt.Canvas(m1106height3ABfNKs222, (Function1) rememberedValue, composer2, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier4222;
        z4 = z3;
        sliderColors3 = sliderColors4222;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Track(final RangeSliderState rangeSliderState, Modifier modifier, SliderColors sliderColors, boolean z, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        SliderColors sliderColors2;
        int i4;
        boolean z2;
        Modifier.Companion companion;
        boolean z3;
        Composer composer2;
        boolean changed;
        Object rememberedValue;
        final Modifier modifier3;
        final boolean z4;
        final SliderColors sliderColors3;
        ScopeUpdateScope endRestartGroup;
        int i5;
        Composer startRestartGroup = composer.startRestartGroup(-1617869097);
        ComposerKt.sourceInformation(startRestartGroup, "C(Track)P(3,2)1161@48985L8,1172@49445L367,1168@49337L475:Slider.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(rangeSliderState) ? 4 : 2) | i;
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
                    sliderColors2 = sliderColors;
                    if (startRestartGroup.changed(sliderColors2)) {
                        i5 = Fields.RotationX;
                        i3 |= i5;
                    }
                } else {
                    sliderColors2 = sliderColors;
                }
                i5 = Fields.SpotShadowColor;
                i3 |= i5;
            } else {
                sliderColors2 = sliderColors;
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
                    i3 |= startRestartGroup.changed(this) ? Fields.Clip : Fields.Shape;
                }
                if ((i3 & 9363) == 9362 || !startRestartGroup.getSkipping()) {
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                        companion = i6 != 0 ? Modifier.INSTANCE : modifier2;
                        if ((i2 & 4) != 0) {
                            SliderColors colors = colors(startRestartGroup, (i3 >> 12) & 14);
                            i3 &= -897;
                            sliderColors2 = colors;
                        }
                        if (i4 != 0) {
                            z3 = true;
                            SliderColors sliderColors4 = sliderColors2;
                            int i7 = i3;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1617869097, i7, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1163)");
                            }
                            final long m2923trackColorWaAFU9c$material3_release = sliderColors4.m2923trackColorWaAFU9c$material3_release(z3, false);
                            final long m2923trackColorWaAFU9c$material3_release2 = sliderColors4.m2923trackColorWaAFU9c$material3_release(z3, true);
                            final long m2922tickColorWaAFU9c$material3_release = sliderColors4.m2922tickColorWaAFU9c$material3_release(z3, false);
                            final long m2922tickColorWaAFU9c$material3_release2 = sliderColors4.m2922tickColorWaAFU9c$material3_release(z3, true);
                            Modifier m1106height3ABfNKs = SizeKt.m1106height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), SliderKt.getTrackHeight());
                            composer2 = startRestartGroup;
                            composer2.startReplaceableGroup(-1134215342);
                            ComposerKt.sourceInformation(composer2, "CC(remember):Slider.kt#9igjgp");
                            Modifier modifier4 = companion;
                            changed = composer2.changed(m2923trackColorWaAFU9c$material3_release) | ((i7 & 14) == 4) | composer2.changed(m2923trackColorWaAFU9c$material3_release2) | composer2.changed(m2922tickColorWaAFU9c$material3_release) | composer2.changed(m2922tickColorWaAFU9c$material3_release2);
                            rememberedValue = composer2.rememberedValue();
                            if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$5$1
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
                                        SliderDefaults.INSTANCE.m2925drawTrackLUBghH0(drawScope, RangeSliderState.this.getTickFractions(), RangeSliderState.this.getCoercedActiveRangeStartAsFraction$material3_release(), RangeSliderState.this.getCoercedActiveRangeEndAsFraction$material3_release(), m2923trackColorWaAFU9c$material3_release, m2923trackColorWaAFU9c$material3_release2, m2922tickColorWaAFU9c$material3_release, m2922tickColorWaAFU9c$material3_release2);
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue);
                            }
                            composer2.endReplaceableGroup();
                            CanvasKt.Canvas(m1106height3ABfNKs, (Function1) rememberedValue, composer2, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            z4 = z3;
                            sliderColors3 = sliderColors4;
                        }
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        companion = modifier2;
                    }
                    z3 = z2;
                    SliderColors sliderColors42 = sliderColors2;
                    int i72 = i3;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    final long m2923trackColorWaAFU9c$material3_release3 = sliderColors42.m2923trackColorWaAFU9c$material3_release(z3, false);
                    final long m2923trackColorWaAFU9c$material3_release22 = sliderColors42.m2923trackColorWaAFU9c$material3_release(z3, true);
                    final long m2922tickColorWaAFU9c$material3_release3 = sliderColors42.m2922tickColorWaAFU9c$material3_release(z3, false);
                    final long m2922tickColorWaAFU9c$material3_release22 = sliderColors42.m2922tickColorWaAFU9c$material3_release(z3, true);
                    Modifier m1106height3ABfNKs2 = SizeKt.m1106height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), SliderKt.getTrackHeight());
                    composer2 = startRestartGroup;
                    composer2.startReplaceableGroup(-1134215342);
                    ComposerKt.sourceInformation(composer2, "CC(remember):Slider.kt#9igjgp");
                    Modifier modifier42 = companion;
                    changed = composer2.changed(m2923trackColorWaAFU9c$material3_release3) | ((i72 & 14) == 4) | composer2.changed(m2923trackColorWaAFU9c$material3_release22) | composer2.changed(m2922tickColorWaAFU9c$material3_release3) | composer2.changed(m2922tickColorWaAFU9c$material3_release22);
                    rememberedValue = composer2.rememberedValue();
                    if (!changed) {
                    }
                    rememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$5$1
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
                            SliderDefaults.INSTANCE.m2925drawTrackLUBghH0(drawScope, RangeSliderState.this.getTickFractions(), RangeSliderState.this.getCoercedActiveRangeStartAsFraction$material3_release(), RangeSliderState.this.getCoercedActiveRangeEndAsFraction$material3_release(), m2923trackColorWaAFU9c$material3_release3, m2923trackColorWaAFU9c$material3_release22, m2922tickColorWaAFU9c$material3_release3, m2922tickColorWaAFU9c$material3_release22);
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue);
                    composer2.endReplaceableGroup();
                    CanvasKt.Canvas(m1106height3ABfNKs2, (Function1) rememberedValue, composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier3 = modifier42;
                    z4 = z3;
                    sliderColors3 = sliderColors42;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    composer2 = startRestartGroup;
                    modifier3 = modifier2;
                    sliderColors3 = sliderColors2;
                    z4 = z2;
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$6
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i8) {
                            SliderDefaults.this.Track(rangeSliderState, modifier3, sliderColors3, z4, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
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
            z3 = z2;
            SliderColors sliderColors422 = sliderColors2;
            int i722 = i3;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            final long m2923trackColorWaAFU9c$material3_release32 = sliderColors422.m2923trackColorWaAFU9c$material3_release(z3, false);
            final long m2923trackColorWaAFU9c$material3_release222 = sliderColors422.m2923trackColorWaAFU9c$material3_release(z3, true);
            final long m2922tickColorWaAFU9c$material3_release32 = sliderColors422.m2922tickColorWaAFU9c$material3_release(z3, false);
            final long m2922tickColorWaAFU9c$material3_release222 = sliderColors422.m2922tickColorWaAFU9c$material3_release(z3, true);
            Modifier m1106height3ABfNKs22 = SizeKt.m1106height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), SliderKt.getTrackHeight());
            composer2 = startRestartGroup;
            composer2.startReplaceableGroup(-1134215342);
            ComposerKt.sourceInformation(composer2, "CC(remember):Slider.kt#9igjgp");
            Modifier modifier422 = companion;
            changed = composer2.changed(m2923trackColorWaAFU9c$material3_release32) | ((i722 & 14) == 4) | composer2.changed(m2923trackColorWaAFU9c$material3_release222) | composer2.changed(m2922tickColorWaAFU9c$material3_release32) | composer2.changed(m2922tickColorWaAFU9c$material3_release222);
            rememberedValue = composer2.rememberedValue();
            if (!changed) {
            }
            rememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$5$1
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
                    SliderDefaults.INSTANCE.m2925drawTrackLUBghH0(drawScope, RangeSliderState.this.getTickFractions(), RangeSliderState.this.getCoercedActiveRangeStartAsFraction$material3_release(), RangeSliderState.this.getCoercedActiveRangeEndAsFraction$material3_release(), m2923trackColorWaAFU9c$material3_release32, m2923trackColorWaAFU9c$material3_release222, m2922tickColorWaAFU9c$material3_release32, m2922tickColorWaAFU9c$material3_release222);
                }
            };
            composer2.updateRememberedValue(rememberedValue);
            composer2.endReplaceableGroup();
            CanvasKt.Canvas(m1106height3ABfNKs22, (Function1) rememberedValue, composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier422;
            z4 = z3;
            sliderColors3 = sliderColors422;
            endRestartGroup = composer2.endRestartGroup();
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
        z3 = z2;
        SliderColors sliderColors4222 = sliderColors2;
        int i7222 = i3;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        final long m2923trackColorWaAFU9c$material3_release322 = sliderColors4222.m2923trackColorWaAFU9c$material3_release(z3, false);
        final long m2923trackColorWaAFU9c$material3_release2222 = sliderColors4222.m2923trackColorWaAFU9c$material3_release(z3, true);
        final long m2922tickColorWaAFU9c$material3_release322 = sliderColors4222.m2922tickColorWaAFU9c$material3_release(z3, false);
        final long m2922tickColorWaAFU9c$material3_release2222 = sliderColors4222.m2922tickColorWaAFU9c$material3_release(z3, true);
        Modifier m1106height3ABfNKs222 = SizeKt.m1106height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), SliderKt.getTrackHeight());
        composer2 = startRestartGroup;
        composer2.startReplaceableGroup(-1134215342);
        ComposerKt.sourceInformation(composer2, "CC(remember):Slider.kt#9igjgp");
        Modifier modifier4222 = companion;
        changed = composer2.changed(m2923trackColorWaAFU9c$material3_release322) | ((i7222 & 14) == 4) | composer2.changed(m2923trackColorWaAFU9c$material3_release2222) | composer2.changed(m2922tickColorWaAFU9c$material3_release322) | composer2.changed(m2922tickColorWaAFU9c$material3_release2222);
        rememberedValue = composer2.rememberedValue();
        if (!changed) {
        }
        rememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.SliderDefaults$Track$5$1
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
                SliderDefaults.INSTANCE.m2925drawTrackLUBghH0(drawScope, RangeSliderState.this.getTickFractions(), RangeSliderState.this.getCoercedActiveRangeStartAsFraction$material3_release(), RangeSliderState.this.getCoercedActiveRangeEndAsFraction$material3_release(), m2923trackColorWaAFU9c$material3_release322, m2923trackColorWaAFU9c$material3_release2222, m2922tickColorWaAFU9c$material3_release322, m2922tickColorWaAFU9c$material3_release2222);
            }
        };
        composer2.updateRememberedValue(rememberedValue);
        composer2.endReplaceableGroup();
        CanvasKt.Canvas(m1106height3ABfNKs222, (Function1) rememberedValue, composer2, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier4222;
        z4 = z3;
        sliderColors3 = sliderColors4222;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawTrack-LUBghH0, reason: not valid java name */
    public final void m2925drawTrackLUBghH0(DrawScope drawScope, float[] fArr, float f, float f2, long j, long j2, long j3, long j4) {
        float f3;
        boolean z = drawScope.getLayoutDirection() == LayoutDirection.Rtl;
        long Offset = OffsetKt.Offset(0.0f, Offset.m4594getYimpl(drawScope.m5416getCenterF1C5BW0()));
        long Offset2 = OffsetKt.Offset(Size.m4662getWidthimpl(drawScope.m5417getSizeNHjbRc()), Offset.m4594getYimpl(drawScope.m5416getCenterF1C5BW0()));
        long j5 = z ? Offset2 : Offset;
        long j6 = z ? Offset : Offset2;
        f3 = SliderKt.TickSize;
        float f4 = drawScope.toPx-0680j_4(f3);
        float f5 = drawScope.toPx-0680j_4(SliderKt.getTrackHeight());
        long j7 = j6;
        long j8 = j5;
        DrawScope.m5403drawLineNGM6Ib0$default(drawScope, j, j5, j6, f5, StrokeCap.INSTANCE.m5212getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
        DrawScope.m5403drawLineNGM6Ib0$default(drawScope, j2, OffsetKt.Offset(Offset.m4593getXimpl(j8) + ((Offset.m4593getXimpl(j7) - Offset.m4593getXimpl(j8)) * f), Offset.m4594getYimpl(drawScope.m5416getCenterF1C5BW0())), OffsetKt.Offset(Offset.m4593getXimpl(j8) + ((Offset.m4593getXimpl(j7) - Offset.m4593getXimpl(j8)) * f2), Offset.m4594getYimpl(drawScope.m5416getCenterF1C5BW0())), f5, StrokeCap.INSTANCE.m5212getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
        int length = fArr.length;
        int i = 0;
        while (i < length) {
            float f6 = fArr[i];
            long j9 = j7;
            long j10 = j8;
            DrawScope.m5398drawCircleVaOC9Bg$default(drawScope, (f6 > f2 ? 1 : (f6 == f2 ? 0 : -1)) > 0 || (f6 > f ? 1 : (f6 == f ? 0 : -1)) < 0 ? j3 : j4, f4 / 2.0f, OffsetKt.Offset(Offset.m4593getXimpl(OffsetKt.m4616lerpWko1d7g(j10, j9, f6)), Offset.m4594getYimpl(drawScope.m5416getCenterF1C5BW0())), 0.0f, null, null, 0, 120, null);
            i++;
            j7 = j9;
            j8 = j10;
        }
    }
}
