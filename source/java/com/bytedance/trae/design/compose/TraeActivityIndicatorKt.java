package com.bytedance.trae.design.compose;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TraeActivityIndicator.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\u001a#\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000b\u0010\f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r²\u0006\n\u0010\u000e\u001a\u00020\u000fX\u008a\u0084\u0002"}, d2 = {"ActivityIndicatorSpokeCount", "", "ActivityIndicatorRotationDurationMillis", "ActivityIndicatorSpokeAlphas", "", "TraeActivityIndicator", "", "modifier", "Landroidx/compose/ui/Modifier;", "tintColor", "Landroidx/compose/ui/graphics/Color;", "TraeActivityIndicator-iJQMabo", "(Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "design-system-compose_mainlandRelease", "rotation", ""}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeActivityIndicatorKt {
    private static final int ActivityIndicatorRotationDurationMillis = 800;
    private static final float[] ActivityIndicatorSpokeAlphas = {1.0f, 0.8f, 0.7f, 0.6f, 0.5f, 0.4f, 0.3f, 0.2f};
    private static final int ActivityIndicatorSpokeCount = 8;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TraeActivityIndicator_iJQMabo$lambda$4(Modifier modifier, long j, int i, int i2, Composer composer, int i3) {
        m1580TraeActivityIndicatoriJQMabo(modifier, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* renamed from: TraeActivityIndicator-iJQMabo, reason: not valid java name */
    public static final void m1580TraeActivityIndicatoriJQMabo(Modifier modifier, long j, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        long j2;
        Modifier modifier3;
        final Modifier modifier4;
        final long j3;
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(-399389136);
        int i5 = i2 & 1;
        if (i5 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = i | (startRestartGroup.changed(modifier2) ? 4 : 2);
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                j2 = j;
                if (startRestartGroup.changed(j2)) {
                    i4 = 32;
                    i3 |= i4;
                }
            } else {
                j2 = j;
            }
            i4 = 16;
            i3 |= i4;
        } else {
            j2 = j;
        }
        if ((i3 & 19) != 18 || !startRestartGroup.getSkipping()) {
            startRestartGroup.startDefaults();
            if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                Modifier modifier5 = i5 != 0 ? (Modifier) Modifier.Companion : modifier2;
                if ((i2 & 2) != 0) {
                    j2 = TraeTheme.INSTANCE.getColors(startRestartGroup, 6).mo1751getIconIconDefault0d7_KjU();
                    i3 &= -113;
                }
                modifier3 = modifier5;
            } else {
                startRestartGroup.skipToGroupEnd();
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                }
                modifier3 = modifier2;
            }
            int i6 = i3;
            final long j4 = j2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-399389136, i6, -1, "com.bytedance.trae.design.compose.TraeActivityIndicator (TraeActivityIndicator.kt:28)");
            }
            Modifier rotate = RotateKt.rotate(modifier3, TraeActivityIndicator_iJQMabo$lambda$0(InfiniteTransitionKt.animateFloat(InfiniteTransitionKt.rememberInfiniteTransition((String) null, startRestartGroup, 0, 1), 0.0f, 360.0f, AnimationSpecKt.infiniteRepeatable-9IiC70o$default(AnimationSpecKt.tween$default(ActivityIndicatorRotationDurationMillis, 0, EasingKt.getLinearEasing(), 2, (Object) null), (RepeatMode) null, 0L, 6, (Object) null), (String) null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8)));
            startRestartGroup.startReplaceGroup(1056548667);
            boolean z = (((i6 & 112) ^ 48) > 32 && startRestartGroup.changed(j4)) || (i6 & 48) == 32;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function1() { // from class: com.bytedance.trae.design.compose.TraeActivityIndicatorKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        Unit TraeActivityIndicator_iJQMabo$lambda$3$lambda$2;
                        TraeActivityIndicator_iJQMabo$lambda$3$lambda$2 = TraeActivityIndicatorKt.TraeActivityIndicator_iJQMabo$lambda$3$lambda$2(j4, (DrawScope) obj);
                        return TraeActivityIndicator_iJQMabo$lambda$3$lambda$2;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            CanvasKt.Canvas(rotate, (Function1) rememberedValue, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
            j3 = j4;
        } else {
            startRestartGroup.skipToGroupEnd();
            modifier4 = modifier2;
            j3 = j2;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.bytedance.trae.design.compose.TraeActivityIndicatorKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit TraeActivityIndicator_iJQMabo$lambda$4;
                    TraeActivityIndicator_iJQMabo$lambda$4 = TraeActivityIndicatorKt.TraeActivityIndicator_iJQMabo$lambda$4(modifier4, j3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return TraeActivityIndicator_iJQMabo$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TraeActivityIndicator_iJQMabo$lambda$3$lambda$2(long j, DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "$this$Canvas");
        float f = Size.getMinDimension-impl(drawScope.getSize-NH-jbRc()) * 0.075f;
        float f2 = Size.getMinDimension-impl(drawScope.getSize-NH-jbRc()) * 0.25f;
        float f3 = Size.getMinDimension-impl(drawScope.getSize-NH-jbRc()) * 0.375f;
        int i = 0;
        while (i < 8) {
            double d = (-1.5707963267948966d) - (((i * 2.0d) * 3.141592653589793d) / 8);
            long j2 = Color.copy-wmQWz5c$default(j, Color.getAlpha-impl(j) * ActivityIndicatorSpokeAlphas[i], 0.0f, 0.0f, 0.0f, 14, (Object) null);
            long j3 = drawScope.getCenter-F1C5BW0();
            double d2 = f2;
            float cos = (float) (Math.cos(d) * d2);
            float sin = (float) (Math.sin(d) * d2);
            long j4 = Offset.plus-MK-Hz9U(j3, Offset.constructor-impl((Float.floatToRawIntBits(cos) << 32) | (Float.floatToRawIntBits(sin) & 4294967295L)));
            long j5 = drawScope.getCenter-F1C5BW0();
            double d3 = f3;
            float cos2 = (float) (Math.cos(d) * d3);
            float sin2 = (float) (Math.sin(d) * d3);
            DrawScope.drawLine-NGM6Ib0$default(drawScope, j2, j4, Offset.plus-MK-Hz9U(j5, Offset.constructor-impl((Float.floatToRawIntBits(sin2) & 4294967295L) | (Float.floatToRawIntBits(cos2) << 32))), f, StrokeCap.Companion.getRound-KaPHkGw(), (PathEffect) null, 0.0f, (ColorFilter) null, 0, 480, (Object) null);
            i++;
            f3 = f3;
            f2 = f2;
        }
        return Unit.INSTANCE;
    }

    private static final float TraeActivityIndicator_iJQMabo$lambda$0(State<Float> state) {
        return ((Number) state.getValue()).floatValue();
    }
}
