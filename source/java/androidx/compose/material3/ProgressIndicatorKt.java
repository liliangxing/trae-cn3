package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.KeyframeBaseEntity;
import androidx.compose.animation.core.KeyframesSpec;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.CircularProgressIndicatorTokens;
import androidx.compose.material3.tokens.LinearProgressIndicatorTokens;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.geometry.OffsetKt;
import androidx.compose.p002ui.geometry.Size;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.graphics.StrokeCap;
import androidx.compose.p002ui.graphics.drawscope.DrawScope;
import androidx.compose.p002ui.graphics.drawscope.Stroke;
import androidx.compose.p002ui.layout.LayoutModifierKt;
import androidx.compose.p002ui.layout.Measurable;
import androidx.compose.p002ui.layout.MeasureResult;
import androidx.compose.p002ui.layout.MeasureScope;
import androidx.compose.p002ui.layout.Placeable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.ProgressBarRangeInfo;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

/* compiled from: ProgressIndicator.kt */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\u001aR\u0010%\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00010(2\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020\u00052\b\b\u0002\u0010-\u001a\u00020+2\b\b\u0002\u0010.\u001a\u00020/H\u0007ø\u0001\u0000¢\u0006\u0004\b0\u00101\u001a0\u0010%\u001a\u00020&2\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b2\u00103\u001aD\u0010%\u001a\u00020&2\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020\u00052\b\b\u0002\u0010-\u001a\u00020+2\b\b\u0002\u0010.\u001a\u00020/H\u0007ø\u0001\u0000¢\u0006\u0004\b4\u00105\u001a8\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00012\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b6\u00107\u001aL\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00012\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020\u00052\b\b\u0002\u0010-\u001a\u00020+2\b\b\u0002\u0010.\u001a\u00020/H\u0007ø\u0001\u0000¢\u0006\u0004\b0\u00108\u001aH\u00109\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00010(2\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020+2\b\b\u0002\u0010.\u001a\u00020/H\u0007ø\u0001\u0000¢\u0006\u0004\b:\u0010;\u001a0\u00109\u001a\u00020&2\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020+H\u0007ø\u0001\u0000¢\u0006\u0004\b<\u0010=\u001a:\u00109\u001a\u00020&2\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020+2\b\b\u0002\u0010.\u001a\u00020/H\u0007ø\u0001\u0000¢\u0006\u0004\b>\u0010?\u001a8\u00109\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00012\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020+H\u0007ø\u0001\u0000¢\u0006\u0004\b@\u0010A\u001aB\u00109\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00012\b\b\u0002\u0010)\u001a\u00020\u00132\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020+2\b\b\u0002\u0010.\u001a\u00020/H\u0007ø\u0001\u0000¢\u0006\u0004\b:\u0010B\u001a6\u0010C\u001a\u00020&*\u00020D2\u0006\u0010E\u001a\u00020\u00012\u0006\u0010F\u001a\u00020\u00012\u0006\u0010*\u001a\u00020+2\u0006\u0010G\u001a\u00020HH\u0002ø\u0001\u0000¢\u0006\u0004\bI\u0010J\u001a&\u0010K\u001a\u00020&*\u00020D2\u0006\u0010*\u001a\u00020+2\u0006\u0010G\u001a\u00020HH\u0002ø\u0001\u0000¢\u0006\u0004\bL\u0010M\u001a6\u0010N\u001a\u00020&*\u00020D2\u0006\u0010E\u001a\u00020\u00012\u0006\u0010F\u001a\u00020\u00012\u0006\u0010*\u001a\u00020+2\u0006\u0010G\u001a\u00020HH\u0002ø\u0001\u0000¢\u0006\u0004\bO\u0010J\u001a>\u0010P\u001a\u00020&*\u00020D2\u0006\u0010E\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u00052\u0006\u0010F\u001a\u00020\u00012\u0006\u0010*\u001a\u00020+2\u0006\u0010G\u001a\u00020HH\u0002ø\u0001\u0000¢\u0006\u0004\bQ\u0010R\u001a>\u0010S\u001a\u00020&*\u00020D2\u0006\u0010T\u001a\u00020\u00012\u0006\u0010U\u001a\u00020\u00012\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00012\u0006\u0010.\u001a\u00020/H\u0002ø\u0001\u0000¢\u0006\u0004\bV\u0010W\u001a.\u0010X\u001a\u00020&*\u00020D2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00012\u0006\u0010.\u001a\u00020/H\u0002ø\u0001\u0000¢\u0006\u0004\bY\u0010Z\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007\"\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0016\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0017\u0010\u0007\"\u0016\u0010\u0018\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0019\u0010\u0007\"\u000e\u0010\u001a\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\"\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010#\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b\"\u000e\u0010$\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006["}, d2 = {"BaseRotationAngle", "", "CircularEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "CircularIndicatorDiameter", "Landroidx/compose/ui/unit/Dp;", "getCircularIndicatorDiameter", "()F", "F", "FirstLineHeadDelay", "", "FirstLineHeadDuration", "FirstLineHeadEasing", "FirstLineTailDelay", "FirstLineTailDuration", "FirstLineTailEasing", "HeadAndTailAnimationDuration", "HeadAndTailDelayDuration", "IncreaseSemanticsBounds", "Landroidx/compose/ui/Modifier;", "JumpRotationAngle", "LinearAnimationDuration", "LinearIndicatorHeight", "getLinearIndicatorHeight", "LinearIndicatorWidth", "getLinearIndicatorWidth", "RotationAngleOffset", "RotationDuration", "RotationsPerCycle", "SecondLineHeadDelay", "SecondLineHeadDuration", "SecondLineHeadEasing", "SecondLineTailDelay", "SecondLineTailDuration", "SecondLineTailEasing", "SemanticsBoundsPadding", "StartAngleOffset", "CircularProgressIndicator", "", "progress", "Lkotlin/Function0;", "modifier", "color", "Landroidx/compose/ui/graphics/Color;", "strokeWidth", "trackColor", "strokeCap", "Landroidx/compose/ui/graphics/StrokeCap;", "CircularProgressIndicator-DUhRLBM", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JFJILandroidx/compose/runtime/Composer;II)V", "CircularProgressIndicator-aM-cp0Q", "(Landroidx/compose/ui/Modifier;JFLandroidx/compose/runtime/Composer;II)V", "CircularProgressIndicator-LxG7B9w", "(Landroidx/compose/ui/Modifier;JFJILandroidx/compose/runtime/Composer;II)V", "CircularProgressIndicator-MBs18nI", "(FLandroidx/compose/ui/Modifier;JFLandroidx/compose/runtime/Composer;II)V", "(FLandroidx/compose/ui/Modifier;JFJILandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator", "LinearProgressIndicator-_5eSR-E", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JJILandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-RIQooxk", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-2cYBFYY", "(Landroidx/compose/ui/Modifier;JJILandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-eaDK9VM", "(FLandroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "(FLandroidx/compose/ui/Modifier;JJILandroidx/compose/runtime/Composer;II)V", "drawCircularIndicator", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "startAngle", "sweep", "stroke", "Landroidx/compose/ui/graphics/drawscope/Stroke;", "drawCircularIndicator-42QJj7c", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawCircularIndicatorTrack", "drawCircularIndicatorTrack-bw27NRU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawDeterminateCircularIndicator", "drawDeterminateCircularIndicator-42QJj7c", "drawIndeterminateCircularIndicator", "drawIndeterminateCircularIndicator-hrjfTZI", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFFJLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawLinearIndicator", "startFraction", "endFraction", "drawLinearIndicator-qYKTg0g", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJFI)V", "drawLinearIndicatorTrack", "drawLinearIndicatorTrack-AZGd3zU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFI)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class ProgressIndicatorKt {
    private static final float BaseRotationAngle = 286.0f;
    private static final CubicBezierEasing CircularEasing;
    private static final float CircularIndicatorDiameter;
    private static final int FirstLineHeadDelay = 0;
    private static final int FirstLineHeadDuration = 750;
    private static final CubicBezierEasing FirstLineHeadEasing;
    private static final int FirstLineTailDelay = 333;
    private static final int FirstLineTailDuration = 850;
    private static final CubicBezierEasing FirstLineTailEasing;
    private static final int HeadAndTailAnimationDuration = 666;
    private static final int HeadAndTailDelayDuration = 666;
    private static final Modifier IncreaseSemanticsBounds;
    private static final float JumpRotationAngle = 290.0f;
    private static final int LinearAnimationDuration = 1800;
    private static final float LinearIndicatorHeight;
    private static final float LinearIndicatorWidth;
    private static final float RotationAngleOffset = 216.0f;
    private static final int RotationDuration = 1332;
    private static final int RotationsPerCycle = 5;
    private static final int SecondLineHeadDelay = 1000;
    private static final int SecondLineHeadDuration = 567;
    private static final CubicBezierEasing SecondLineHeadEasing;
    private static final int SecondLineTailDelay = 1267;
    private static final int SecondLineTailDuration = 533;
    private static final CubicBezierEasing SecondLineTailEasing;
    private static final float SemanticsBoundsPadding;
    private static final float StartAngleOffset = -90.0f;

    /* JADX WARN: Code restructure failed: missing block: B:60:0x0125, code lost:
    
        if (r7 == androidx.compose.runtime.Composer.INSTANCE.getEmpty()) goto L97;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00cc  */
    /* renamed from: LinearProgressIndicator-_5eSR-E, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2795LinearProgressIndicator_5eSRE(final Function0<Float> function0, Modifier modifier, long j, long j2, int i, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        long j3;
        long j4;
        int i5;
        int i6;
        long j5;
        int m2786getLinearStrokeCapKaPHkGw;
        final long j6;
        boolean z;
        Object obj;
        boolean changed;
        Object rememberedValue;
        boolean z2;
        int i7;
        long j7;
        long j8;
        Object obj2;
        final int i8;
        final long j9;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-1796992155);
        ComposerKt.sourceInformation(startRestartGroup, "C(LinearProgressIndicator)P(2,1,0:c#ui.graphics.Color,4:c#ui.graphics.Color,3:c#ui.graphics.StrokeCap)81@3829L11,82@3892L16,85@4010L31,89@4162L102,93@4334L196,86@4046L484:ProgressIndicator.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i9 = i3 & 2;
        if (i9 != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            modifier2 = modifier;
            i4 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i2 & 384) != 0) {
                j3 = j;
                i4 |= ((i3 & 4) == 0 && startRestartGroup.changed(j3)) ? Fields.RotationX : Fields.SpotShadowColor;
            } else {
                j3 = j;
            }
            if ((i2 & 3072) != 0) {
                j4 = j2;
                i4 |= ((i3 & 8) == 0 && startRestartGroup.changed(j4)) ? Fields.CameraDistance : Fields.RotationZ;
            } else {
                j4 = j2;
            }
            i5 = i3 & 16;
            if (i5 == 0) {
                i4 |= 24576;
            } else if ((i2 & 24576) == 0) {
                i6 = i;
                i4 |= startRestartGroup.changed(i6) ? Fields.Clip : Fields.Shape;
                if ((i4 & 9363) == 9362 || !startRestartGroup.getSkipping()) {
                    startRestartGroup.startDefaults();
                    if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                        if (i9 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i3 & 4) != 0) {
                            j3 = ProgressIndicatorDefaults.INSTANCE.getLinearColor(startRestartGroup, 6);
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            j5 = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor(startRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            j5 = j4;
                        }
                        m2786getLinearStrokeCapKaPHkGw = i5 != 0 ? ProgressIndicatorDefaults.INSTANCE.m2786getLinearStrokeCapKaPHkGw() : i6;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        if ((i3 & 4) != 0) {
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            i4 &= -7169;
                        }
                        m2786getLinearStrokeCapKaPHkGw = i6;
                        j5 = j4;
                    }
                    j6 = j3;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1796992155, i4, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:84)");
                    }
                    startRestartGroup.startReplaceableGroup(-1348540816);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
                    boolean z3 = true;
                    z = (i4 & 14) == 4;
                    Object rememberedValue2 = startRestartGroup.rememberedValue();
                    if (!z) {
                        obj = rememberedValue2;
                    }
                    Function0<Float> function02 = new Function0<Float>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$coercedProgress$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final Float m2812invoke() {
                            return Float.valueOf(RangesKt.coerceIn(((Number) function0.invoke()).floatValue(), 0.0f, 1.0f));
                        }
                    };
                    startRestartGroup.updateRememberedValue(function02);
                    obj = function02;
                    final Function0 function03 = (Function0) obj;
                    startRestartGroup.endReplaceableGroup();
                    Modifier then = modifier2.then(IncreaseSemanticsBounds);
                    startRestartGroup.startReplaceableGroup(-1348540664);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
                    changed = startRestartGroup.changed(function03);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$1$1
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
                                SemanticsPropertiesKt.setProgressBarRangeInfo(semanticsPropertyReceiver, new ProgressBarRangeInfo(((Number) function03.invoke()).floatValue(), RangesKt.rangeTo(0.0f, 1.0f), 0, 4, (DefaultConstructorMarker) null));
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    startRestartGroup.endReplaceableGroup();
                    Modifier m1122sizeVpY3zN4 = SizeKt.m1122sizeVpY3zN4(SemanticsModifierKt.semantics(then, true, (Function1) rememberedValue), LinearIndicatorWidth, LinearIndicatorHeight);
                    startRestartGroup.startReplaceableGroup(-1348540492);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
                    boolean changed2 = ((((i4 & 7168) ^ 3072) <= 2048 && startRestartGroup.changed(j5)) || (i4 & 3072) == 2048) | ((57344 & i4) == 16384) | startRestartGroup.changed(function03);
                    if ((((i4 & 896) ^ 384) > 256 || !startRestartGroup.changed(j6)) && (i4 & 384) != 256) {
                        z3 = false;
                    }
                    z2 = changed2 | z3;
                    Object rememberedValue3 = startRestartGroup.rememberedValue();
                    if (!z2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        i7 = 0;
                        final long j10 = j5;
                        j7 = j5;
                        final int i10 = m2786getLinearStrokeCapKaPHkGw;
                        j8 = j6;
                        obj2 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$2$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                                invoke((DrawScope) obj3);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(DrawScope drawScope) {
                                float m4659getHeightimpl = Size.m4659getHeightimpl(drawScope.m5417getSizeNHjbRc());
                                ProgressIndicatorKt.m2807drawLinearIndicatorTrackAZGd3zU(drawScope, j10, m4659getHeightimpl, i10);
                                ProgressIndicatorKt.m2806drawLinearIndicatorqYKTg0g(drawScope, 0.0f, ((Number) function03.invoke()).floatValue(), j6, m4659getHeightimpl, i10);
                            }
                        };
                        startRestartGroup.updateRememberedValue(obj2);
                    } else {
                        obj2 = rememberedValue3;
                        j7 = j5;
                        j8 = j6;
                        i7 = 0;
                    }
                    startRestartGroup.endReplaceableGroup();
                    CanvasKt.Canvas(m1122sizeVpY3zN4, (Function1) obj2, startRestartGroup, i7);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i8 = m2786getLinearStrokeCapKaPHkGw;
                    j4 = j7;
                    j9 = j8;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    i8 = i6;
                    j9 = j3;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier3 = modifier2;
                    final long j11 = j4;
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$3
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj3, Object obj4) {
                            invoke((Composer) obj3, ((Number) obj4).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i11) {
                            ProgressIndicatorKt.m2795LinearProgressIndicator_5eSRE(function0, modifier3, j9, j11, i8, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                        }
                    });
                    return;
                }
                return;
            }
            i6 = i;
            if ((i4 & 9363) == 9362) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
            }
            if (i9 != 0) {
            }
            if ((i3 & 4) != 0) {
            }
            if ((i3 & 8) != 0) {
            }
            if (i5 != 0) {
            }
            j6 = j3;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceableGroup(-1348540816);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
            boolean z32 = true;
            if ((i4 & 14) == 4) {
            }
            Object rememberedValue22 = startRestartGroup.rememberedValue();
            if (!z) {
            }
            Function0<Float> function022 = new Function0<Float>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$coercedProgress$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final Float m2812invoke() {
                    return Float.valueOf(RangesKt.coerceIn(((Number) function0.invoke()).floatValue(), 0.0f, 1.0f));
                }
            };
            startRestartGroup.updateRememberedValue(function022);
            obj = function022;
            final Function0<Float> function032 = (Function0) obj;
            startRestartGroup.endReplaceableGroup();
            Modifier then2 = modifier2.then(IncreaseSemanticsBounds);
            startRestartGroup.startReplaceableGroup(-1348540664);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
            changed = startRestartGroup.changed(function032);
            rememberedValue = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$1$1
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
                    SemanticsPropertiesKt.setProgressBarRangeInfo(semanticsPropertyReceiver, new ProgressBarRangeInfo(((Number) function032.invoke()).floatValue(), RangesKt.rangeTo(0.0f, 1.0f), 0, 4, (DefaultConstructorMarker) null));
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceableGroup();
            Modifier m1122sizeVpY3zN42 = SizeKt.m1122sizeVpY3zN4(SemanticsModifierKt.semantics(then2, true, (Function1) rememberedValue), LinearIndicatorWidth, LinearIndicatorHeight);
            startRestartGroup.startReplaceableGroup(-1348540492);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
            boolean changed22 = ((((i4 & 7168) ^ 3072) <= 2048 && startRestartGroup.changed(j5)) || (i4 & 3072) == 2048) | ((57344 & i4) == 16384) | startRestartGroup.changed(function032);
            if (((i4 & 896) ^ 384) > 256) {
            }
            z32 = false;
            z2 = changed22 | z32;
            Object rememberedValue32 = startRestartGroup.rememberedValue();
            if (z2) {
            }
            i7 = 0;
            final long j102 = j5;
            j7 = j5;
            final int i102 = m2786getLinearStrokeCapKaPHkGw;
            j8 = j6;
            obj2 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                    invoke((DrawScope) obj3);
                    return Unit.INSTANCE;
                }

                public final void invoke(DrawScope drawScope) {
                    float m4659getHeightimpl = Size.m4659getHeightimpl(drawScope.m5417getSizeNHjbRc());
                    ProgressIndicatorKt.m2807drawLinearIndicatorTrackAZGd3zU(drawScope, j102, m4659getHeightimpl, i102);
                    ProgressIndicatorKt.m2806drawLinearIndicatorqYKTg0g(drawScope, 0.0f, ((Number) function032.invoke()).floatValue(), j6, m4659getHeightimpl, i102);
                }
            };
            startRestartGroup.updateRememberedValue(obj2);
            startRestartGroup.endReplaceableGroup();
            CanvasKt.Canvas(m1122sizeVpY3zN42, (Function1) obj2, startRestartGroup, i7);
            if (ComposerKt.isTraceInProgress()) {
            }
            i8 = m2786getLinearStrokeCapKaPHkGw;
            j4 = j7;
            j9 = j8;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i2 & 384) != 0) {
        }
        if ((i2 & 3072) != 0) {
        }
        i5 = i3 & 16;
        if (i5 == 0) {
        }
        i6 = i;
        if ((i4 & 9363) == 9362) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i9 != 0) {
        }
        if ((i3 & 4) != 0) {
        }
        if ((i3 & 8) != 0) {
        }
        if (i5 != 0) {
        }
        j6 = j3;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceableGroup(-1348540816);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
        boolean z322 = true;
        if ((i4 & 14) == 4) {
        }
        Object rememberedValue222 = startRestartGroup.rememberedValue();
        if (!z) {
        }
        Function0<Float> function0222 = new Function0<Float>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$coercedProgress$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Float m2812invoke() {
                return Float.valueOf(RangesKt.coerceIn(((Number) function0.invoke()).floatValue(), 0.0f, 1.0f));
            }
        };
        startRestartGroup.updateRememberedValue(function0222);
        obj = function0222;
        final Function0<Float> function0322 = (Function0) obj;
        startRestartGroup.endReplaceableGroup();
        Modifier then22 = modifier2.then(IncreaseSemanticsBounds);
        startRestartGroup.startReplaceableGroup(-1348540664);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
        changed = startRestartGroup.changed(function0322);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$1$1
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
                SemanticsPropertiesKt.setProgressBarRangeInfo(semanticsPropertyReceiver, new ProgressBarRangeInfo(((Number) function0322.invoke()).floatValue(), RangesKt.rangeTo(0.0f, 1.0f), 0, 4, (DefaultConstructorMarker) null));
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceableGroup();
        Modifier m1122sizeVpY3zN422 = SizeKt.m1122sizeVpY3zN4(SemanticsModifierKt.semantics(then22, true, (Function1) rememberedValue), LinearIndicatorWidth, LinearIndicatorHeight);
        startRestartGroup.startReplaceableGroup(-1348540492);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
        boolean changed222 = ((((i4 & 7168) ^ 3072) <= 2048 && startRestartGroup.changed(j5)) || (i4 & 3072) == 2048) | ((57344 & i4) == 16384) | startRestartGroup.changed(function0322);
        if (((i4 & 896) ^ 384) > 256) {
        }
        z322 = false;
        z2 = changed222 | z322;
        Object rememberedValue322 = startRestartGroup.rememberedValue();
        if (z2) {
        }
        i7 = 0;
        final long j1022 = j5;
        j7 = j5;
        final int i1022 = m2786getLinearStrokeCapKaPHkGw;
        j8 = j6;
        obj2 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                invoke((DrawScope) obj3);
                return Unit.INSTANCE;
            }

            public final void invoke(DrawScope drawScope) {
                float m4659getHeightimpl = Size.m4659getHeightimpl(drawScope.m5417getSizeNHjbRc());
                ProgressIndicatorKt.m2807drawLinearIndicatorTrackAZGd3zU(drawScope, j1022, m4659getHeightimpl, i1022);
                ProgressIndicatorKt.m2806drawLinearIndicatorqYKTg0g(drawScope, 0.0f, ((Number) function0322.invoke()).floatValue(), j6, m4659getHeightimpl, i1022);
            }
        };
        startRestartGroup.updateRememberedValue(obj2);
        startRestartGroup.endReplaceableGroup();
        CanvasKt.Canvas(m1122sizeVpY3zN422, (Function1) obj2, startRestartGroup, i7);
        if (ComposerKt.isTraceInProgress()) {
        }
        i8 = m2786getLinearStrokeCapKaPHkGw;
        j4 = j7;
        j9 = j8;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x0209, code lost:
    
        if (r1.changed(r10) == false) goto L83;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00bc  */
    /* renamed from: LinearProgressIndicator-2cYBFYY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2792LinearProgressIndicator2cYBFYY(Modifier modifier, long j, long j2, int i, Composer composer, final int i2, final int i3) {
        Modifier modifier2;
        int i4;
        long j3;
        long j4;
        int i5;
        Modifier.Companion companion;
        int m2786getLinearStrokeCapKaPHkGw;
        int i6;
        long j5;
        long j6;
        int i7;
        long j7;
        boolean z;
        boolean changed;
        Object rememberedValue;
        final int i8;
        final long j8;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-476865359);
        ComposerKt.sourceInformation(startRestartGroup, "C(LinearProgressIndicator)P(1,0:c#ui.graphics.Color,3:c#ui.graphics.Color,2:c#ui.graphics.StrokeCap)118@5518L11,119@5581L16,122@5702L28,126@5984L320,137@6348L320,148@6713L324,159@7082L324,175@7581L660,170@7411L830:ProgressIndicator.kt#uh7d8r");
        int i9 = i3 & 1;
        if (i9 != 0) {
            i4 = i2 | 6;
            modifier2 = modifier;
        } else if ((i2 & 6) == 0) {
            modifier2 = modifier;
            i4 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i2;
        } else {
            modifier2 = modifier;
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            j3 = j;
            i4 |= ((i3 & 2) == 0 && startRestartGroup.changed(j3)) ? 32 : 16;
        } else {
            j3 = j;
        }
        if ((i2 & 384) == 0) {
            j4 = j2;
            i4 |= ((i3 & 4) == 0 && startRestartGroup.changed(j4)) ? 256 : Fields.SpotShadowColor;
        } else {
            j4 = j2;
        }
        int i10 = i3 & 8;
        if (i10 != 0) {
            i4 |= 3072;
        } else if ((i2 & 3072) == 0) {
            i5 = i;
            i4 |= startRestartGroup.changed(i5) ? Fields.CameraDistance : Fields.RotationZ;
            if ((i4 & 1171) == 1170 || !startRestartGroup.getSkipping()) {
                startRestartGroup.startDefaults();
                if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                    companion = i9 == 0 ? Modifier.INSTANCE : modifier2;
                    if ((i3 & 2) != 0) {
                        j3 = ProgressIndicatorDefaults.INSTANCE.getLinearColor(startRestartGroup, 6);
                        i4 &= -113;
                    }
                    if ((i3 & 4) != 0) {
                        j4 = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor(startRestartGroup, 6);
                        i4 &= -897;
                    }
                    if (i10 != 0) {
                        m2786getLinearStrokeCapKaPHkGw = ProgressIndicatorDefaults.INSTANCE.m2786getLinearStrokeCapKaPHkGw();
                        i6 = i4;
                        j5 = j3;
                        j6 = j4;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-476865359, i6, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:121)");
                        }
                        InfiniteTransition rememberInfiniteTransition = InfiniteTransitionKt.rememberInfiniteTransition(null, startRestartGroup, 0, 1);
                        boolean z2 = true;
                        i7 = i6;
                        long j9 = j6;
                        final State<Float> animateFloat = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m282infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$firstLineHead$1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((KeyframesSpec.KeyframesSpecConfig<Float>) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                                CubicBezierEasing cubicBezierEasing;
                                keyframesSpecConfig.setDurationMillis(1800);
                                KeyframeBaseEntity mo12at = keyframesSpecConfig.mo12at((Object) Float.valueOf(0.0f), 0);
                                cubicBezierEasing = ProgressIndicatorKt.FirstLineHeadEasing;
                                keyframesSpecConfig.using(mo12at, cubicBezierEasing);
                                keyframesSpecConfig.mo12at((Object) Float.valueOf(1.0f), 750);
                            }
                        }), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                        final State<Float> animateFloat2 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m282infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$firstLineTail$1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((KeyframesSpec.KeyframesSpecConfig<Float>) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                                CubicBezierEasing cubicBezierEasing;
                                keyframesSpecConfig.setDurationMillis(1800);
                                KeyframeBaseEntity mo12at = keyframesSpecConfig.mo12at((Object) Float.valueOf(0.0f), 333);
                                cubicBezierEasing = ProgressIndicatorKt.FirstLineTailEasing;
                                keyframesSpecConfig.using(mo12at, cubicBezierEasing);
                                keyframesSpecConfig.mo12at((Object) Float.valueOf(1.0f), 1183);
                            }
                        }), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                        final State<Float> animateFloat3 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m282infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$secondLineHead$1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((KeyframesSpec.KeyframesSpecConfig<Float>) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                                CubicBezierEasing cubicBezierEasing;
                                keyframesSpecConfig.setDurationMillis(1800);
                                KeyframeBaseEntity mo12at = keyframesSpecConfig.mo12at((Object) Float.valueOf(0.0f), 1000);
                                cubicBezierEasing = ProgressIndicatorKt.SecondLineHeadEasing;
                                keyframesSpecConfig.using(mo12at, cubicBezierEasing);
                                keyframesSpecConfig.mo12at((Object) Float.valueOf(1.0f), 1567);
                            }
                        }), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                        final State<Float> animateFloat4 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition, 0.0f, 1.0f, AnimationSpecKt.m282infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$secondLineTail$1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((KeyframesSpec.KeyframesSpecConfig<Float>) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                                CubicBezierEasing cubicBezierEasing;
                                keyframesSpecConfig.setDurationMillis(1800);
                                KeyframeBaseEntity mo12at = keyframesSpecConfig.mo12at((Object) Float.valueOf(0.0f), 1267);
                                cubicBezierEasing = ProgressIndicatorKt.SecondLineTailEasing;
                                keyframesSpecConfig.using(mo12at, cubicBezierEasing);
                                keyframesSpecConfig.mo12at((Object) Float.valueOf(1.0f), 1800);
                            }
                        }), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                        Modifier m1122sizeVpY3zN4 = SizeKt.m1122sizeVpY3zN4(ProgressSemanticsKt.progressSemantics(companion.then(IncreaseSemanticsBounds)), LinearIndicatorWidth, LinearIndicatorHeight);
                        startRestartGroup.startReplaceableGroup(-1348537245);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
                        if (((i7 & 896) ^ 384) > 256) {
                            j7 = j9;
                        } else {
                            j7 = j9;
                        }
                        if ((i7 & 384) != 256) {
                            z = false;
                            boolean changed2 = z | ((i7 & 7168) != 2048) | startRestartGroup.changed(animateFloat) | startRestartGroup.changed(animateFloat2);
                            if ((((i7 & 112) ^ 48) > 32 || !startRestartGroup.changed(j5)) && (i7 & 48) != 32) {
                                z2 = false;
                            }
                            changed = changed2 | z2 | startRestartGroup.changed(animateFloat3) | startRestartGroup.changed(animateFloat4);
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                final long j10 = j7;
                                final int i11 = m2786getLinearStrokeCapKaPHkGw;
                                final long j11 = j5;
                                rememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$4$1
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
                                        float m4659getHeightimpl = Size.m4659getHeightimpl(drawScope.m5417getSizeNHjbRc());
                                        ProgressIndicatorKt.m2807drawLinearIndicatorTrackAZGd3zU(drawScope, j10, m4659getHeightimpl, i11);
                                        if (animateFloat.getValue().floatValue() - animateFloat2.getValue().floatValue() > 0.0f) {
                                            ProgressIndicatorKt.m2806drawLinearIndicatorqYKTg0g(drawScope, animateFloat.getValue().floatValue(), animateFloat2.getValue().floatValue(), j11, m4659getHeightimpl, i11);
                                        }
                                        if (animateFloat3.getValue().floatValue() - animateFloat4.getValue().floatValue() > 0.0f) {
                                            ProgressIndicatorKt.m2806drawLinearIndicatorqYKTg0g(drawScope, animateFloat3.getValue().floatValue(), animateFloat4.getValue().floatValue(), j11, m4659getHeightimpl, i11);
                                        }
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            startRestartGroup.endReplaceableGroup();
                            CanvasKt.Canvas(m1122sizeVpY3zN4, (Function1) rememberedValue, startRestartGroup, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            j3 = j5;
                            i8 = m2786getLinearStrokeCapKaPHkGw;
                            j8 = j7;
                        }
                        z = true;
                        boolean changed22 = z | ((i7 & 7168) != 2048) | startRestartGroup.changed(animateFloat) | startRestartGroup.changed(animateFloat2);
                        if (((i7 & 112) ^ 48) > 32) {
                        }
                        z2 = false;
                        changed = changed22 | z2 | startRestartGroup.changed(animateFloat3) | startRestartGroup.changed(animateFloat4);
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (!changed) {
                        }
                        final long j102 = j7;
                        final int i112 = m2786getLinearStrokeCapKaPHkGw;
                        final long j112 = j5;
                        rememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$4$1
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
                                float m4659getHeightimpl = Size.m4659getHeightimpl(drawScope.m5417getSizeNHjbRc());
                                ProgressIndicatorKt.m2807drawLinearIndicatorTrackAZGd3zU(drawScope, j102, m4659getHeightimpl, i112);
                                if (animateFloat.getValue().floatValue() - animateFloat2.getValue().floatValue() > 0.0f) {
                                    ProgressIndicatorKt.m2806drawLinearIndicatorqYKTg0g(drawScope, animateFloat.getValue().floatValue(), animateFloat2.getValue().floatValue(), j112, m4659getHeightimpl, i112);
                                }
                                if (animateFloat3.getValue().floatValue() - animateFloat4.getValue().floatValue() > 0.0f) {
                                    ProgressIndicatorKt.m2806drawLinearIndicatorqYKTg0g(drawScope, animateFloat3.getValue().floatValue(), animateFloat4.getValue().floatValue(), j112, m4659getHeightimpl, i112);
                                }
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue);
                        startRestartGroup.endReplaceableGroup();
                        CanvasKt.Canvas(m1122sizeVpY3zN4, (Function1) rememberedValue, startRestartGroup, 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        j3 = j5;
                        i8 = m2786getLinearStrokeCapKaPHkGw;
                        j8 = j7;
                    }
                } else {
                    startRestartGroup.skipToGroupEnd();
                    if ((i3 & 2) != 0) {
                        i4 &= -113;
                    }
                    if ((i3 & 4) != 0) {
                        i4 &= -897;
                    }
                    companion = modifier2;
                }
                j6 = j4;
                m2786getLinearStrokeCapKaPHkGw = i5;
                i6 = i4;
                j5 = j3;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                InfiniteTransition rememberInfiniteTransition2 = InfiniteTransitionKt.rememberInfiniteTransition(null, startRestartGroup, 0, 1);
                boolean z22 = true;
                i7 = i6;
                long j92 = j6;
                final State<Float> animateFloat5 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition2, 0.0f, 1.0f, AnimationSpecKt.m282infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$firstLineHead$1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((KeyframesSpec.KeyframesSpecConfig<Float>) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                        CubicBezierEasing cubicBezierEasing;
                        keyframesSpecConfig.setDurationMillis(1800);
                        KeyframeBaseEntity mo12at = keyframesSpecConfig.mo12at((Object) Float.valueOf(0.0f), 0);
                        cubicBezierEasing = ProgressIndicatorKt.FirstLineHeadEasing;
                        keyframesSpecConfig.using(mo12at, cubicBezierEasing);
                        keyframesSpecConfig.mo12at((Object) Float.valueOf(1.0f), 750);
                    }
                }), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                final State<Float> animateFloat22 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition2, 0.0f, 1.0f, AnimationSpecKt.m282infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$firstLineTail$1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((KeyframesSpec.KeyframesSpecConfig<Float>) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                        CubicBezierEasing cubicBezierEasing;
                        keyframesSpecConfig.setDurationMillis(1800);
                        KeyframeBaseEntity mo12at = keyframesSpecConfig.mo12at((Object) Float.valueOf(0.0f), 333);
                        cubicBezierEasing = ProgressIndicatorKt.FirstLineTailEasing;
                        keyframesSpecConfig.using(mo12at, cubicBezierEasing);
                        keyframesSpecConfig.mo12at((Object) Float.valueOf(1.0f), 1183);
                    }
                }), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                final State<Float> animateFloat32 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition2, 0.0f, 1.0f, AnimationSpecKt.m282infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$secondLineHead$1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((KeyframesSpec.KeyframesSpecConfig<Float>) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                        CubicBezierEasing cubicBezierEasing;
                        keyframesSpecConfig.setDurationMillis(1800);
                        KeyframeBaseEntity mo12at = keyframesSpecConfig.mo12at((Object) Float.valueOf(0.0f), 1000);
                        cubicBezierEasing = ProgressIndicatorKt.SecondLineHeadEasing;
                        keyframesSpecConfig.using(mo12at, cubicBezierEasing);
                        keyframesSpecConfig.mo12at((Object) Float.valueOf(1.0f), 1567);
                    }
                }), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                final State<Float> animateFloat42 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition2, 0.0f, 1.0f, AnimationSpecKt.m282infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$secondLineTail$1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((KeyframesSpec.KeyframesSpecConfig<Float>) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                        CubicBezierEasing cubicBezierEasing;
                        keyframesSpecConfig.setDurationMillis(1800);
                        KeyframeBaseEntity mo12at = keyframesSpecConfig.mo12at((Object) Float.valueOf(0.0f), 1267);
                        cubicBezierEasing = ProgressIndicatorKt.SecondLineTailEasing;
                        keyframesSpecConfig.using(mo12at, cubicBezierEasing);
                        keyframesSpecConfig.mo12at((Object) Float.valueOf(1.0f), 1800);
                    }
                }), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                Modifier m1122sizeVpY3zN42 = SizeKt.m1122sizeVpY3zN4(ProgressSemanticsKt.progressSemantics(companion.then(IncreaseSemanticsBounds)), LinearIndicatorWidth, LinearIndicatorHeight);
                startRestartGroup.startReplaceableGroup(-1348537245);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
                if (((i7 & 896) ^ 384) > 256) {
                }
                if ((i7 & 384) != 256) {
                }
                z = true;
                boolean changed222 = z | ((i7 & 7168) != 2048) | startRestartGroup.changed(animateFloat5) | startRestartGroup.changed(animateFloat22);
                if (((i7 & 112) ^ 48) > 32) {
                }
                z22 = false;
                changed = changed222 | z22 | startRestartGroup.changed(animateFloat32) | startRestartGroup.changed(animateFloat42);
                rememberedValue = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                final long j1022 = j7;
                final int i1122 = m2786getLinearStrokeCapKaPHkGw;
                final long j1122 = j5;
                rememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$4$1
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
                        float m4659getHeightimpl = Size.m4659getHeightimpl(drawScope.m5417getSizeNHjbRc());
                        ProgressIndicatorKt.m2807drawLinearIndicatorTrackAZGd3zU(drawScope, j1022, m4659getHeightimpl, i1122);
                        if (animateFloat5.getValue().floatValue() - animateFloat22.getValue().floatValue() > 0.0f) {
                            ProgressIndicatorKt.m2806drawLinearIndicatorqYKTg0g(drawScope, animateFloat5.getValue().floatValue(), animateFloat22.getValue().floatValue(), j1122, m4659getHeightimpl, i1122);
                        }
                        if (animateFloat32.getValue().floatValue() - animateFloat42.getValue().floatValue() > 0.0f) {
                            ProgressIndicatorKt.m2806drawLinearIndicatorqYKTg0g(drawScope, animateFloat32.getValue().floatValue(), animateFloat42.getValue().floatValue(), j1122, m4659getHeightimpl, i1122);
                        }
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
                startRestartGroup.endReplaceableGroup();
                CanvasKt.Canvas(m1122sizeVpY3zN42, (Function1) rememberedValue, startRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                j3 = j5;
                i8 = m2786getLinearStrokeCapKaPHkGw;
                j8 = j7;
            } else {
                startRestartGroup.skipToGroupEnd();
                companion = modifier2;
                j8 = j4;
                i8 = i5;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                final Modifier modifier3 = companion;
                final long j12 = j3;
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$5
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i12) {
                        ProgressIndicatorKt.m2792LinearProgressIndicator2cYBFYY(Modifier.this, j12, j8, i8, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                    }
                });
                return;
            }
            return;
        }
        i5 = i;
        if ((i4 & 1171) == 1170) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i9 == 0) {
        }
        if ((i3 & 2) != 0) {
        }
        if ((i3 & 4) != 0) {
        }
        if (i10 != 0) {
        }
        j6 = j4;
        m2786getLinearStrokeCapKaPHkGw = i5;
        i6 = i4;
        j5 = j3;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        InfiniteTransition rememberInfiniteTransition22 = InfiniteTransitionKt.rememberInfiniteTransition(null, startRestartGroup, 0, 1);
        boolean z222 = true;
        i7 = i6;
        long j922 = j6;
        final State<Float> animateFloat52 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition22, 0.0f, 1.0f, AnimationSpecKt.m282infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$firstLineHead$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((KeyframesSpec.KeyframesSpecConfig<Float>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                CubicBezierEasing cubicBezierEasing;
                keyframesSpecConfig.setDurationMillis(1800);
                KeyframeBaseEntity mo12at = keyframesSpecConfig.mo12at((Object) Float.valueOf(0.0f), 0);
                cubicBezierEasing = ProgressIndicatorKt.FirstLineHeadEasing;
                keyframesSpecConfig.using(mo12at, cubicBezierEasing);
                keyframesSpecConfig.mo12at((Object) Float.valueOf(1.0f), 750);
            }
        }), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
        final State<Float> animateFloat222 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition22, 0.0f, 1.0f, AnimationSpecKt.m282infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$firstLineTail$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((KeyframesSpec.KeyframesSpecConfig<Float>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                CubicBezierEasing cubicBezierEasing;
                keyframesSpecConfig.setDurationMillis(1800);
                KeyframeBaseEntity mo12at = keyframesSpecConfig.mo12at((Object) Float.valueOf(0.0f), 333);
                cubicBezierEasing = ProgressIndicatorKt.FirstLineTailEasing;
                keyframesSpecConfig.using(mo12at, cubicBezierEasing);
                keyframesSpecConfig.mo12at((Object) Float.valueOf(1.0f), 1183);
            }
        }), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
        final State<Float> animateFloat322 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition22, 0.0f, 1.0f, AnimationSpecKt.m282infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$secondLineHead$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((KeyframesSpec.KeyframesSpecConfig<Float>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                CubicBezierEasing cubicBezierEasing;
                keyframesSpecConfig.setDurationMillis(1800);
                KeyframeBaseEntity mo12at = keyframesSpecConfig.mo12at((Object) Float.valueOf(0.0f), 1000);
                cubicBezierEasing = ProgressIndicatorKt.SecondLineHeadEasing;
                keyframesSpecConfig.using(mo12at, cubicBezierEasing);
                keyframesSpecConfig.mo12at((Object) Float.valueOf(1.0f), 1567);
            }
        }), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
        final State<Float> animateFloat422 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition22, 0.0f, 1.0f, AnimationSpecKt.m282infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$secondLineTail$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((KeyframesSpec.KeyframesSpecConfig<Float>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                CubicBezierEasing cubicBezierEasing;
                keyframesSpecConfig.setDurationMillis(1800);
                KeyframeBaseEntity mo12at = keyframesSpecConfig.mo12at((Object) Float.valueOf(0.0f), 1267);
                cubicBezierEasing = ProgressIndicatorKt.SecondLineTailEasing;
                keyframesSpecConfig.using(mo12at, cubicBezierEasing);
                keyframesSpecConfig.mo12at((Object) Float.valueOf(1.0f), 1800);
            }
        }), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
        Modifier m1122sizeVpY3zN422 = SizeKt.m1122sizeVpY3zN4(ProgressSemanticsKt.progressSemantics(companion.then(IncreaseSemanticsBounds)), LinearIndicatorWidth, LinearIndicatorHeight);
        startRestartGroup.startReplaceableGroup(-1348537245);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
        if (((i7 & 896) ^ 384) > 256) {
        }
        if ((i7 & 384) != 256) {
        }
        z = true;
        boolean changed2222 = z | ((i7 & 7168) != 2048) | startRestartGroup.changed(animateFloat52) | startRestartGroup.changed(animateFloat222);
        if (((i7 & 112) ^ 48) > 32) {
        }
        z222 = false;
        changed = changed2222 | z222 | startRestartGroup.changed(animateFloat322) | startRestartGroup.changed(animateFloat422);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        final long j10222 = j7;
        final int i11222 = m2786getLinearStrokeCapKaPHkGw;
        final long j11222 = j5;
        rememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$4$1
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
                float m4659getHeightimpl = Size.m4659getHeightimpl(drawScope.m5417getSizeNHjbRc());
                ProgressIndicatorKt.m2807drawLinearIndicatorTrackAZGd3zU(drawScope, j10222, m4659getHeightimpl, i11222);
                if (animateFloat52.getValue().floatValue() - animateFloat222.getValue().floatValue() > 0.0f) {
                    ProgressIndicatorKt.m2806drawLinearIndicatorqYKTg0g(drawScope, animateFloat52.getValue().floatValue(), animateFloat222.getValue().floatValue(), j11222, m4659getHeightimpl, i11222);
                }
                if (animateFloat322.getValue().floatValue() - animateFloat422.getValue().floatValue() > 0.0f) {
                    ProgressIndicatorKt.m2806drawLinearIndicatorqYKTg0g(drawScope, animateFloat322.getValue().floatValue(), animateFloat422.getValue().floatValue(), j11222, m4659getHeightimpl, i11222);
                }
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceableGroup();
        CanvasKt.Canvas(m1122sizeVpY3zN422, (Function1) rememberedValue, startRestartGroup, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        j3 = j5;
        i8 = m2786getLinearStrokeCapKaPHkGw;
        j8 = j7;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x005d  */
    @Deprecated(message = "Use the overload that takes `progress` as a lambda", replaceWith = @ReplaceWith(expression = "LinearProgressIndicator(\nprogress = { progress },\nmodifier = modifier,\ncolor = color,\ntrackColor = trackColor,\nstrokeCap = strokeCap,\n)", imports = {}))
    /* renamed from: LinearProgressIndicator-_5eSR-E, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2794LinearProgressIndicator_5eSRE(final float f, Modifier modifier, long j, long j2, int i, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        long j3;
        long j4;
        int i5;
        int i6;
        int m2786getLinearStrokeCapKaPHkGw;
        long j5;
        long j6;
        boolean z;
        Object rememberedValue;
        final int i7;
        final long j7;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(905419617);
        ComposerKt.sourceInformation(startRestartGroup, "C(LinearProgressIndicator)P(2,1,0:c#ui.graphics.Color,4:c#ui.graphics.Color,3:c#ui.graphics.StrokeCap)213@8723L11,214@8786L16,217@8918L12,216@8878L155:ProgressIndicator.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (startRestartGroup.changed(f) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i8 = i3 & 2;
        if (i8 != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            modifier2 = modifier;
            i4 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i2 & 384) != 0) {
                j3 = j;
                i4 |= ((i3 & 4) == 0 && startRestartGroup.changed(j3)) ? Fields.RotationX : Fields.SpotShadowColor;
            } else {
                j3 = j;
            }
            if ((i2 & 3072) != 0) {
                j4 = j2;
                i4 |= ((i3 & 8) == 0 && startRestartGroup.changed(j4)) ? Fields.CameraDistance : Fields.RotationZ;
            } else {
                j4 = j2;
            }
            i5 = i3 & 16;
            if (i5 == 0) {
                i4 |= 24576;
            } else if ((i2 & 24576) == 0) {
                i6 = i;
                i4 |= startRestartGroup.changed(i6) ? Fields.Clip : Fields.Shape;
                if ((i4 & 9363) == 9362 || !startRestartGroup.getSkipping()) {
                    startRestartGroup.startDefaults();
                    if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                        if (i8 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i3 & 4) != 0) {
                            j3 = ProgressIndicatorDefaults.INSTANCE.getLinearColor(startRestartGroup, 6);
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            j4 = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor(startRestartGroup, 6);
                            i4 &= -7169;
                        }
                        if (i5 != 0) {
                            m2786getLinearStrokeCapKaPHkGw = ProgressIndicatorDefaults.INSTANCE.m2786getLinearStrokeCapKaPHkGw();
                            j5 = j3;
                            j6 = j4;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(905419617, i4, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:216)");
                            }
                            startRestartGroup.startReplaceableGroup(-1348535908);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
                            z = (i4 & 14) != 4;
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (!z || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$6$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                    public final Float m2811invoke() {
                                        return Float.valueOf(f);
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            startRestartGroup.endReplaceableGroup();
                            m2795LinearProgressIndicator_5eSRE((Function0<Float>) rememberedValue, modifier2, j5, j6, m2786getLinearStrokeCapKaPHkGw, startRestartGroup, (i4 & 112) | (i4 & 896) | (i4 & 7168) | (i4 & 57344), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            i7 = m2786getLinearStrokeCapKaPHkGw;
                            j7 = j5;
                            j4 = j6;
                        }
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        if ((i3 & 4) != 0) {
                            i4 &= -897;
                        }
                        if ((i3 & 8) != 0) {
                            i4 &= -7169;
                        }
                    }
                    j5 = j3;
                    j6 = j4;
                    m2786getLinearStrokeCapKaPHkGw = i6;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.startReplaceableGroup(-1348535908);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
                    if ((i4 & 14) != 4) {
                    }
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!z) {
                    }
                    rememberedValue = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$6$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final Float m2811invoke() {
                            return Float.valueOf(f);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                    startRestartGroup.endReplaceableGroup();
                    m2795LinearProgressIndicator_5eSRE((Function0<Float>) rememberedValue, modifier2, j5, j6, m2786getLinearStrokeCapKaPHkGw, startRestartGroup, (i4 & 112) | (i4 & 896) | (i4 & 7168) | (i4 & 57344), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    i7 = m2786getLinearStrokeCapKaPHkGw;
                    j7 = j5;
                    j4 = j6;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    j7 = j3;
                    i7 = i6;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier3 = modifier2;
                    final long j8 = j4;
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$7
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i9) {
                            ProgressIndicatorKt.m2794LinearProgressIndicator_5eSRE(f, modifier3, j7, j8, i7, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                        }
                    });
                    return;
                }
                return;
            }
            i6 = i;
            if ((i4 & 9363) == 9362) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
            }
            if (i8 != 0) {
            }
            if ((i3 & 4) != 0) {
            }
            if ((i3 & 8) != 0) {
            }
            if (i5 != 0) {
            }
            j5 = j3;
            j6 = j4;
            m2786getLinearStrokeCapKaPHkGw = i6;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceableGroup(-1348535908);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
            if ((i4 & 14) != 4) {
            }
            rememberedValue = startRestartGroup.rememberedValue();
            if (!z) {
            }
            rememberedValue = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$6$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final Float m2811invoke() {
                    return Float.valueOf(f);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceableGroup();
            m2795LinearProgressIndicator_5eSRE((Function0<Float>) rememberedValue, modifier2, j5, j6, m2786getLinearStrokeCapKaPHkGw, startRestartGroup, (i4 & 112) | (i4 & 896) | (i4 & 7168) | (i4 & 57344), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            i7 = m2786getLinearStrokeCapKaPHkGw;
            j7 = j5;
            j4 = j6;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i2 & 384) != 0) {
        }
        if ((i2 & 3072) != 0) {
        }
        i5 = i3 & 16;
        if (i5 == 0) {
        }
        i6 = i;
        if ((i4 & 9363) == 9362) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i8 != 0) {
        }
        if ((i3 & 4) != 0) {
        }
        if ((i3 & 8) != 0) {
        }
        if (i5 != 0) {
        }
        j5 = j3;
        j6 = j4;
        m2786getLinearStrokeCapKaPHkGw = i6;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceableGroup(-1348535908);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
        if ((i4 & 14) != 4) {
        }
        rememberedValue = startRestartGroup.rememberedValue();
        if (!z) {
        }
        rememberedValue = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$6$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Float m2811invoke() {
                return Float.valueOf(f);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceableGroup();
        m2795LinearProgressIndicator_5eSRE((Function0<Float>) rememberedValue, modifier2, j5, j6, m2786getLinearStrokeCapKaPHkGw, startRestartGroup, (i4 & 112) | (i4 & 896) | (i4 & 7168) | (i4 & 57344), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        i7 = m2786getLinearStrokeCapKaPHkGw;
        j7 = j5;
        j4 = j6;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0061  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: LinearProgressIndicator-eaDK9VM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m2796LinearProgressIndicatoreaDK9VM(final float f, Modifier modifier, long j, long j2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        long j3;
        long j4;
        Modifier.Companion companion;
        long linearTrackColor;
        long j5;
        final long j6;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-372717133);
        ComposerKt.sourceInformation(startRestartGroup, "C(LinearProgressIndicator)P(2,1,0:c#ui.graphics.Color,3:c#ui.graphics.Color)230@9286L11,231@9349L16,232@9371L140:ProgressIndicator.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(f) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i & 384) != 0) {
                j3 = j;
                i3 |= ((i2 & 4) == 0 && startRestartGroup.changed(j3)) ? Fields.RotationX : Fields.SpotShadowColor;
            } else {
                j3 = j;
            }
            if ((i & 3072) != 0) {
                j4 = j2;
                i3 |= ((i2 & 8) == 0 && startRestartGroup.changed(j4)) ? Fields.CameraDistance : Fields.RotationZ;
            } else {
                j4 = j2;
            }
            if ((i3 & 1171) == 1170 || !startRestartGroup.getSkipping()) {
                startRestartGroup.startDefaults();
                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                    companion = i4 == 0 ? Modifier.INSTANCE : modifier2;
                    if ((i2 & 4) != 0) {
                        j3 = ProgressIndicatorDefaults.INSTANCE.getLinearColor(startRestartGroup, 6);
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        linearTrackColor = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor(startRestartGroup, 6);
                        j5 = j3;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-372717133, i3, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:232)");
                        }
                        m2794LinearProgressIndicator_5eSRE(f, companion, j5, linearTrackColor, ProgressIndicatorDefaults.INSTANCE.m2786getLinearStrokeCapKaPHkGw(), startRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j3 = j5;
                        j6 = linearTrackColor;
                    }
                } else {
                    startRestartGroup.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                    companion = modifier2;
                }
                j5 = j3;
                linearTrackColor = j4;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                m2794LinearProgressIndicator_5eSRE(f, companion, j5, linearTrackColor, ProgressIndicatorDefaults.INSTANCE.m2786getLinearStrokeCapKaPHkGw(), startRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                j3 = j5;
                j6 = linearTrackColor;
            } else {
                startRestartGroup.skipToGroupEnd();
                companion = modifier2;
                j6 = j4;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                final Modifier modifier3 = companion;
                final long j7 = j3;
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$8
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i5) {
                        ProgressIndicatorKt.m2796LinearProgressIndicatoreaDK9VM(f, modifier3, j7, j6, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        modifier2 = modifier;
        if ((i & 384) != 0) {
        }
        if ((i & 3072) != 0) {
        }
        if ((i3 & 1171) == 1170) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i4 == 0) {
        }
        if ((i2 & 4) != 0) {
        }
        if ((i2 & 8) != 0) {
        }
        j5 = j3;
        linearTrackColor = j4;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        m2794LinearProgressIndicator_5eSRE(f, companion, j5, linearTrackColor, ProgressIndicatorDefaults.INSTANCE.m2786getLinearStrokeCapKaPHkGw(), startRestartGroup, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        j3 = j5;
        j6 = linearTrackColor;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: LinearProgressIndicator-RIQooxk, reason: not valid java name */
    public static final /* synthetic */ void m2793LinearProgressIndicatorRIQooxk(Modifier modifier, long j, long j2, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        long j3;
        long j4;
        Modifier.Companion companion;
        long j5;
        Composer startRestartGroup = composer.startRestartGroup(585576195);
        ComposerKt.sourceInformation(startRestartGroup, "C(LinearProgressIndicator)P(1,0:c#ui.graphics.Color,2:c#ui.graphics.Color)244@9718L11,245@9781L16,246@9803L126:ProgressIndicator.kt#uh7d8r");
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
        if ((i & 48) == 0) {
            j3 = j;
            i3 |= ((i2 & 2) == 0 && startRestartGroup.changed(j3)) ? 32 : 16;
        } else {
            j3 = j;
        }
        if ((i & 384) == 0) {
            j4 = j2;
            i3 |= ((i2 & 4) == 0 && startRestartGroup.changed(j4)) ? Fields.RotationX : Fields.SpotShadowColor;
        } else {
            j4 = j2;
        }
        if ((i3 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            companion = modifier2;
            j5 = j3;
        } else {
            startRestartGroup.startDefaults();
            if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i2 & 2) != 0) {
                    j3 = ProgressIndicatorDefaults.INSTANCE.getLinearColor(startRestartGroup, 6);
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    j4 = ProgressIndicatorDefaults.INSTANCE.getLinearTrackColor(startRestartGroup, 6);
                    i3 &= -897;
                }
            } else {
                startRestartGroup.skipToGroupEnd();
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                }
                companion = modifier2;
            }
            int i5 = i3;
            j5 = j3;
            long j6 = j4;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(585576195, i5, -1, "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:246)");
            }
            m2792LinearProgressIndicator2cYBFYY(companion, j5, j6, ProgressIndicatorDefaults.INSTANCE.m2786getLinearStrokeCapKaPHkGw(), startRestartGroup, (i5 & 14) | 3072 | (i5 & 112) | (i5 & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            j4 = j6;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier3 = companion;
            final long j7 = j5;
            final long j8 = j4;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$9
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
                    ProgressIndicatorKt.m2793LinearProgressIndicatorRIQooxk(Modifier.this, j7, j8, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawLinearIndicator-qYKTg0g, reason: not valid java name */
    public static final void m2806drawLinearIndicatorqYKTg0g(DrawScope drawScope, float f, float f2, long j, float f3, int i) {
        float m4662getWidthimpl = Size.m4662getWidthimpl(drawScope.m5417getSizeNHjbRc());
        float m4659getHeightimpl = Size.m4659getHeightimpl(drawScope.m5417getSizeNHjbRc());
        float f4 = 2;
        float f5 = m4659getHeightimpl / f4;
        boolean z = drawScope.getLayoutDirection() == LayoutDirection.Ltr;
        float f6 = (z ? f : 1.0f - f2) * m4662getWidthimpl;
        float f7 = (z ? f2 : 1.0f - f) * m4662getWidthimpl;
        if (StrokeCap.m5207equalsimpl0(i, StrokeCap.INSTANCE.m5211getButtKaPHkGw()) || m4659getHeightimpl > m4662getWidthimpl) {
            DrawScope.m5403drawLineNGM6Ib0$default(drawScope, j, OffsetKt.Offset(f6, f5), OffsetKt.Offset(f7, f5), f3, 0, null, 0.0f, null, 0, 496, null);
            return;
        }
        float f8 = f3 / f4;
        ClosedFloatingPointRange rangeTo = RangesKt.rangeTo(f8, m4662getWidthimpl - f8);
        float floatValue = ((Number) RangesKt.coerceIn(Float.valueOf(f6), rangeTo)).floatValue();
        float floatValue2 = ((Number) RangesKt.coerceIn(Float.valueOf(f7), rangeTo)).floatValue();
        if (Math.abs(f2 - f) > 0.0f) {
            DrawScope.m5403drawLineNGM6Ib0$default(drawScope, j, OffsetKt.Offset(floatValue, f5), OffsetKt.Offset(floatValue2, f5), f3, i, null, 0.0f, null, 0, 480, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawLinearIndicatorTrack-AZGd3zU, reason: not valid java name */
    public static final void m2807drawLinearIndicatorTrackAZGd3zU(DrawScope drawScope, long j, float f, int i) {
        m2806drawLinearIndicatorqYKTg0g(drawScope, 0.0f, 1.0f, j, f, i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x014d, code lost:
    
        if (r13 == androidx.compose.runtime.Composer.INSTANCE.getEmpty()) goto L106;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00f5  */
    /* renamed from: CircularProgressIndicator-DUhRLBM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2788CircularProgressIndicatorDUhRLBM(final Function0<Float> function0, Modifier modifier, long j, float f, long j2, int i, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        long j3;
        int i5;
        float f2;
        long j4;
        int i6;
        final int i7;
        boolean z;
        Object obj;
        boolean changed;
        Object rememberedValue;
        boolean changed2;
        Object rememberedValue2;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-761680467);
        ComposerKt.sourceInformation(startRestartGroup, "C(CircularProgressIndicator)P(2,1,0:c#ui.graphics.Color,4:c#ui.unit.Dp,5:c#ui.graphics.Color,3:c#ui.graphics.StrokeCap)348@14143L13,350@14277L18,353@14410L31,*354@14477L7,359@14631L102,363@14785L243,357@14558L470:ProgressIndicator.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i8 = i3 & 2;
        if (i8 != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            modifier2 = modifier;
            i4 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i2 & 384) != 0) {
                j3 = j;
                i4 |= ((i3 & 4) == 0 && startRestartGroup.changed(j3)) ? Fields.RotationX : Fields.SpotShadowColor;
            } else {
                j3 = j;
            }
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else if ((i2 & 3072) == 0) {
                f2 = f;
                i4 |= startRestartGroup.changed(f2) ? Fields.CameraDistance : Fields.RotationZ;
                if ((i2 & 24576) == 0) {
                    j4 = j2;
                    i4 |= ((i3 & 16) == 0 && startRestartGroup.changed(j4)) ? Fields.Clip : Fields.Shape;
                } else {
                    j4 = j2;
                }
                i6 = i3 & 32;
                if (i6 != 0) {
                    i4 |= 196608;
                    i7 = i;
                } else {
                    i7 = i;
                    if ((i2 & 196608) == 0) {
                        i4 |= startRestartGroup.changed(i7) ? Fields.RenderEffect : 65536;
                    }
                }
                if ((i4 & 74899) == 74898 || !startRestartGroup.getSkipping()) {
                    startRestartGroup.startDefaults();
                    if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                        if (i8 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i3 & 4) != 0) {
                            j3 = ProgressIndicatorDefaults.INSTANCE.getCircularColor(startRestartGroup, 6);
                            i4 &= -897;
                        }
                        if (i5 != 0) {
                            f2 = ProgressIndicatorDefaults.INSTANCE.m2785getCircularStrokeWidthD9Ej5fM();
                        }
                        if ((i3 & 16) != 0) {
                            j4 = ProgressIndicatorDefaults.INSTANCE.getCircularTrackColor(startRestartGroup, 6);
                            i4 &= -57345;
                        }
                        if (i6 != 0) {
                            i7 = ProgressIndicatorDefaults.INSTANCE.m2783getCircularDeterminateStrokeCapKaPHkGw();
                        }
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        if ((i3 & 4) != 0) {
                            i4 &= -897;
                        }
                        if ((i3 & 16) != 0) {
                            i4 &= -57345;
                        }
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-761680467, i4, -1, "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:352)");
                    }
                    startRestartGroup.startReplaceableGroup(821866314);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
                    z = (i4 & 14) == 4;
                    Object rememberedValue3 = startRestartGroup.rememberedValue();
                    if (!z) {
                        obj = rememberedValue3;
                    }
                    Function0<Float> function02 = new Function0<Float>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$coercedProgress$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final Float m2809invoke() {
                            return Float.valueOf(RangesKt.coerceIn(((Number) function0.invoke()).floatValue(), 0.0f, 1.0f));
                        }
                    };
                    startRestartGroup.updateRememberedValue(function02);
                    obj = function02;
                    final Function0 function03 = (Function0) obj;
                    startRestartGroup.endReplaceableGroup();
                    ProvidableCompositionLocal localDensity = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume = startRestartGroup.consume(localDensity);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    final Stroke stroke = new Stroke(((Density) consume).toPx-0680j_4(f2), 0.0f, i7, 0, null, 26, null);
                    startRestartGroup.startReplaceableGroup(821866535);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
                    changed = startRestartGroup.changed(function03);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$1$1
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
                                SemanticsPropertiesKt.setProgressBarRangeInfo(semanticsPropertyReceiver, new ProgressBarRangeInfo(((Number) function03.invoke()).floatValue(), RangesKt.rangeTo(0.0f, 1.0f), 0, 4, (DefaultConstructorMarker) null));
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    startRestartGroup.endReplaceableGroup();
                    Modifier m1120size3ABfNKs = SizeKt.m1120size3ABfNKs(SemanticsModifierKt.semantics(modifier2, true, (Function1) rememberedValue), CircularIndicatorDiameter);
                    startRestartGroup.startReplaceableGroup(821866689);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
                    changed2 = startRestartGroup.changed(function03) | ((((57344 & i4) ^ 24576) <= 16384 && startRestartGroup.changed(j4)) || (i4 & 24576) == 16384) | startRestartGroup.changedInstance(stroke) | ((((i4 & 896) ^ 384) <= 256 && startRestartGroup.changed(j3)) || (i4 & 384) == 256);
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (!changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        final long j5 = j4;
                        final long j6 = j3;
                        rememberedValue2 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$2$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                invoke((DrawScope) obj2);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(DrawScope drawScope) {
                                float floatValue = 360.0f * ((Number) function03.invoke()).floatValue();
                                ProgressIndicatorKt.m2803drawCircularIndicatorTrackbw27NRU(drawScope, j5, stroke);
                                ProgressIndicatorKt.m2804drawDeterminateCircularIndicator42QJj7c(drawScope, 270.0f, floatValue, j6, stroke);
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                    }
                    startRestartGroup.endReplaceableGroup();
                    CanvasKt.Canvas(m1120size3ABfNKs, (Function1) rememberedValue2, startRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    startRestartGroup.skipToGroupEnd();
                }
                final long j7 = j3;
                final float f3 = f2;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier3 = modifier2;
                    final long j8 = j4;
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$3
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                            invoke((Composer) obj2, ((Number) obj3).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i9) {
                            ProgressIndicatorKt.m2788CircularProgressIndicatorDUhRLBM(function0, modifier3, j7, f3, j8, i7, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                        }
                    });
                    return;
                }
                return;
            }
            f2 = f;
            if ((i2 & 24576) == 0) {
            }
            i6 = i3 & 32;
            if (i6 != 0) {
            }
            if ((i4 & 74899) == 74898) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
            }
            if (i8 != 0) {
            }
            if ((i3 & 4) != 0) {
            }
            if (i5 != 0) {
            }
            if ((i3 & 16) != 0) {
            }
            if (i6 != 0) {
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceableGroup(821866314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
            if ((i4 & 14) == 4) {
            }
            Object rememberedValue32 = startRestartGroup.rememberedValue();
            if (!z) {
            }
            Function0<Float> function022 = new Function0<Float>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$coercedProgress$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final Float m2809invoke() {
                    return Float.valueOf(RangesKt.coerceIn(((Number) function0.invoke()).floatValue(), 0.0f, 1.0f));
                }
            };
            startRestartGroup.updateRememberedValue(function022);
            obj = function022;
            final Function0<Float> function032 = (Function0) obj;
            startRestartGroup.endReplaceableGroup();
            ProvidableCompositionLocal localDensity2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = startRestartGroup.consume(localDensity2);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final Stroke stroke2 = new Stroke(((Density) consume2).toPx-0680j_4(f2), 0.0f, i7, 0, null, 26, null);
            startRestartGroup.startReplaceableGroup(821866535);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
            changed = startRestartGroup.changed(function032);
            rememberedValue = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$1$1
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
                    SemanticsPropertiesKt.setProgressBarRangeInfo(semanticsPropertyReceiver, new ProgressBarRangeInfo(((Number) function032.invoke()).floatValue(), RangesKt.rangeTo(0.0f, 1.0f), 0, 4, (DefaultConstructorMarker) null));
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceableGroup();
            Modifier m1120size3ABfNKs2 = SizeKt.m1120size3ABfNKs(SemanticsModifierKt.semantics(modifier2, true, (Function1) rememberedValue), CircularIndicatorDiameter);
            startRestartGroup.startReplaceableGroup(821866689);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
            changed2 = startRestartGroup.changed(function032) | ((((57344 & i4) ^ 24576) <= 16384 && startRestartGroup.changed(j4)) || (i4 & 24576) == 16384) | startRestartGroup.changedInstance(stroke2) | ((((i4 & 896) ^ 384) <= 256 && startRestartGroup.changed(j3)) || (i4 & 384) == 256);
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (!changed2) {
            }
            final long j52 = j4;
            final long j62 = j3;
            rememberedValue2 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((DrawScope) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(DrawScope drawScope) {
                    float floatValue = 360.0f * ((Number) function032.invoke()).floatValue();
                    ProgressIndicatorKt.m2803drawCircularIndicatorTrackbw27NRU(drawScope, j52, stroke2);
                    ProgressIndicatorKt.m2804drawDeterminateCircularIndicator42QJj7c(drawScope, 270.0f, floatValue, j62, stroke2);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue2);
            startRestartGroup.endReplaceableGroup();
            CanvasKt.Canvas(m1120size3ABfNKs2, (Function1) rememberedValue2, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            final long j72 = j3;
            final float f32 = f2;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i2 & 384) != 0) {
        }
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        f2 = f;
        if ((i2 & 24576) == 0) {
        }
        i6 = i3 & 32;
        if (i6 != 0) {
        }
        if ((i4 & 74899) == 74898) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i8 != 0) {
        }
        if ((i3 & 4) != 0) {
        }
        if (i5 != 0) {
        }
        if ((i3 & 16) != 0) {
        }
        if (i6 != 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceableGroup(821866314);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
        if ((i4 & 14) == 4) {
        }
        Object rememberedValue322 = startRestartGroup.rememberedValue();
        if (!z) {
        }
        Function0<Float> function0222 = new Function0<Float>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$coercedProgress$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Float m2809invoke() {
                return Float.valueOf(RangesKt.coerceIn(((Number) function0.invoke()).floatValue(), 0.0f, 1.0f));
            }
        };
        startRestartGroup.updateRememberedValue(function0222);
        obj = function0222;
        final Function0<Float> function0322 = (Function0) obj;
        startRestartGroup.endReplaceableGroup();
        ProvidableCompositionLocal localDensity22 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume22 = startRestartGroup.consume(localDensity22);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        final Stroke stroke22 = new Stroke(((Density) consume22).toPx-0680j_4(f2), 0.0f, i7, 0, null, 26, null);
        startRestartGroup.startReplaceableGroup(821866535);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
        changed = startRestartGroup.changed(function0322);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$1$1
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
                SemanticsPropertiesKt.setProgressBarRangeInfo(semanticsPropertyReceiver, new ProgressBarRangeInfo(((Number) function0322.invoke()).floatValue(), RangesKt.rangeTo(0.0f, 1.0f), 0, 4, (DefaultConstructorMarker) null));
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceableGroup();
        Modifier m1120size3ABfNKs22 = SizeKt.m1120size3ABfNKs(SemanticsModifierKt.semantics(modifier2, true, (Function1) rememberedValue), CircularIndicatorDiameter);
        startRestartGroup.startReplaceableGroup(821866689);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
        changed2 = startRestartGroup.changed(function0322) | ((((57344 & i4) ^ 24576) <= 16384 && startRestartGroup.changed(j4)) || (i4 & 24576) == 16384) | startRestartGroup.changedInstance(stroke22) | ((((i4 & 896) ^ 384) <= 256 && startRestartGroup.changed(j3)) || (i4 & 384) == 256);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (!changed2) {
        }
        final long j522 = j4;
        final long j622 = j3;
        rememberedValue2 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                invoke((DrawScope) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(DrawScope drawScope) {
                float floatValue = 360.0f * ((Number) function0322.invoke()).floatValue();
                ProgressIndicatorKt.m2803drawCircularIndicatorTrackbw27NRU(drawScope, j522, stroke22);
                ProgressIndicatorKt.m2804drawDeterminateCircularIndicator42QJj7c(drawScope, 270.0f, floatValue, j622, stroke22);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue2);
        startRestartGroup.endReplaceableGroup();
        CanvasKt.Canvas(m1120size3ABfNKs22, (Function1) rememberedValue2, startRestartGroup, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        final long j722 = j3;
        final float f322 = f2;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0087  */
    /* renamed from: CircularProgressIndicator-LxG7B9w, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2789CircularProgressIndicatorLxG7B9w(Modifier modifier, long j, float f, long j2, int i, Composer composer, final int i2, final int i3) {
        Modifier modifier2;
        int i4;
        long j3;
        float f2;
        long j4;
        int i5;
        int i6;
        Modifier.Companion companion;
        long j5;
        int i7;
        long j6;
        float f3;
        int i8;
        long j7;
        int i9;
        long j8;
        Modifier modifier3;
        Stroke stroke;
        boolean z;
        boolean z2;
        Object rememberedValue;
        final int i10;
        final long j9;
        int i11;
        Composer startRestartGroup = composer.startRestartGroup(-115871647);
        ComposerKt.sourceInformation(startRestartGroup, "C(CircularProgressIndicator)P(1,0:c#ui.graphics.Color,3:c#ui.unit.Dp,4:c#ui.graphics.Color,2:c#ui.graphics.StrokeCap)391@16088L13,393@16222L18,*396@16366L7,400@16465L28,402@16622L278,414@17014L230,425@17361L346,436@17740L355,451@18209L628,447@18100L737:ProgressIndicator.kt#uh7d8r");
        int i12 = i3 & 1;
        if (i12 != 0) {
            i4 = i2 | 6;
            modifier2 = modifier;
        } else if ((i2 & 6) == 0) {
            modifier2 = modifier;
            i4 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i2;
        } else {
            modifier2 = modifier;
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            j3 = j;
            i4 |= ((i3 & 2) == 0 && startRestartGroup.changed(j3)) ? 32 : 16;
        } else {
            j3 = j;
        }
        int i13 = i3 & 4;
        if (i13 != 0) {
            i4 |= 384;
        } else if ((i2 & 384) == 0) {
            f2 = f;
            i4 |= startRestartGroup.changed(f2) ? Fields.RotationX : Fields.SpotShadowColor;
            if ((i2 & 3072) != 0) {
                if ((i3 & 8) == 0) {
                    j4 = j2;
                    if (startRestartGroup.changed(j4)) {
                        i11 = Fields.CameraDistance;
                        i4 |= i11;
                    }
                } else {
                    j4 = j2;
                }
                i11 = Fields.RotationZ;
                i4 |= i11;
            } else {
                j4 = j2;
            }
            i5 = i3 & 16;
            if (i5 == 0) {
                i4 |= 24576;
            } else if ((i2 & 24576) == 0) {
                i6 = i;
                i4 |= startRestartGroup.changed(i6) ? Fields.Clip : Fields.Shape;
                if ((i4 & 9363) == 9362 || !startRestartGroup.getSkipping()) {
                    startRestartGroup.startDefaults();
                    if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                        companion = i12 != 0 ? Modifier.INSTANCE : modifier2;
                        if ((i3 & 2) != 0) {
                            j3 = ProgressIndicatorDefaults.INSTANCE.getCircularColor(startRestartGroup, 6);
                            i4 &= -113;
                        }
                        if (i13 != 0) {
                            f2 = ProgressIndicatorDefaults.INSTANCE.m2785getCircularStrokeWidthD9Ej5fM();
                        }
                        if ((i3 & 8) != 0) {
                            j5 = ProgressIndicatorDefaults.INSTANCE.getCircularTrackColor(startRestartGroup, 6);
                            i4 &= -7169;
                        } else {
                            j5 = j4;
                        }
                        if (i5 != 0) {
                            i7 = i4;
                            j7 = j5;
                            f3 = f2;
                            i8 = ProgressIndicatorDefaults.INSTANCE.m2784getCircularIndeterminateStrokeCapKaPHkGw();
                        } else {
                            i7 = i4;
                            j6 = j3;
                            long j10 = j5;
                            f3 = f2;
                            i8 = i6;
                            j7 = j10;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-115871647, i7, -1, "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:395)");
                            }
                            ProvidableCompositionLocal localDensity = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume = startRestartGroup.consume(localDensity);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            Stroke stroke2 = new Stroke(((Density) consume).toPx-0680j_4(f3), 0.0f, i8, 0, null, 26, null);
                            InfiniteTransition rememberInfiniteTransition = InfiniteTransitionKt.rememberInfiniteTransition(null, startRestartGroup, 0, 1);
                            boolean z3 = true;
                            i9 = i7;
                            long j11 = j7;
                            final State animateValue = InfiniteTransitionKt.animateValue(rememberInfiniteTransition, 0, 5, VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE), AnimationSpecKt.m282infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(6660, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 12), 16);
                            final State<Float> animateFloat = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition, 0.0f, BaseRotationAngle, AnimationSpecKt.m282infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(RotationDuration, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                            final State<Float> animateFloat2 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition, 0.0f, JumpRotationAngle, AnimationSpecKt.m282infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$endAngle$1
                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((KeyframesSpec.KeyframesSpecConfig<Float>) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                                    CubicBezierEasing cubicBezierEasing;
                                    keyframesSpecConfig.setDurationMillis(1332);
                                    KeyframeBaseEntity mo12at = keyframesSpecConfig.mo12at((Object) Float.valueOf(0.0f), 0);
                                    cubicBezierEasing = ProgressIndicatorKt.CircularEasing;
                                    keyframesSpecConfig.using(mo12at, cubicBezierEasing);
                                    keyframesSpecConfig.mo12at((Object) Float.valueOf(290.0f), 666);
                                }
                            }), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                            final State<Float> animateFloat3 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition, 0.0f, JumpRotationAngle, AnimationSpecKt.m282infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$startAngle$1
                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((KeyframesSpec.KeyframesSpecConfig<Float>) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                                    CubicBezierEasing cubicBezierEasing;
                                    keyframesSpecConfig.setDurationMillis(1332);
                                    KeyframeBaseEntity mo12at = keyframesSpecConfig.mo12at((Object) Float.valueOf(0.0f), 666);
                                    cubicBezierEasing = ProgressIndicatorKt.CircularEasing;
                                    keyframesSpecConfig.using(mo12at, cubicBezierEasing);
                                    keyframesSpecConfig.mo12at((Object) Float.valueOf(290.0f), keyframesSpecConfig.getDurationMillis());
                                }
                            }), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                            Modifier m1120size3ABfNKs = SizeKt.m1120size3ABfNKs(ProgressSemanticsKt.progressSemantics(companion), CircularIndicatorDiameter);
                            startRestartGroup.startReplaceableGroup(821870113);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
                            if (((i9 & 7168) ^ 3072) <= 2048) {
                                j8 = j11;
                                if (startRestartGroup.changed(j8)) {
                                    modifier3 = companion;
                                    z = true;
                                    stroke = stroke2;
                                    int i14 = i8;
                                    boolean changedInstance = z | startRestartGroup.changedInstance(stroke) | startRestartGroup.changed(animateValue) | startRestartGroup.changed(animateFloat2) | startRestartGroup.changed(animateFloat3) | startRestartGroup.changed(animateFloat) | ((i9 & 896) != 256);
                                    if ((((i9 & 112) ^ 48) > 32 || !startRestartGroup.changed(j6)) && (i9 & 48) != 32) {
                                        z3 = false;
                                    }
                                    z2 = changedInstance | z3;
                                    rememberedValue = startRestartGroup.rememberedValue();
                                    if (!z2 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                        final long j12 = j8;
                                        final Stroke stroke3 = stroke;
                                        final float f4 = f3;
                                        final long j13 = j6;
                                        rememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$4$1
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
                                                ProgressIndicatorKt.m2803drawCircularIndicatorTrackbw27NRU(drawScope, j12, stroke3);
                                                ProgressIndicatorKt.m2805drawIndeterminateCircularIndicatorhrjfTZI(drawScope, animateFloat3.getValue().floatValue() + (((animateValue.getValue().floatValue() * 216.0f) % 360.0f) - 90.0f) + animateFloat.getValue().floatValue(), f4, Math.abs(animateFloat2.getValue().floatValue() - animateFloat3.getValue().floatValue()), j13, stroke3);
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    CanvasKt.Canvas(m1120size3ABfNKs, (Function1) rememberedValue, startRestartGroup, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    i10 = i14;
                                    j9 = j6;
                                    j4 = j8;
                                    modifier2 = modifier3;
                                }
                            } else {
                                j8 = j11;
                            }
                            modifier3 = companion;
                            if ((i9 & 3072) != 2048) {
                                stroke = stroke2;
                                z = false;
                                int i142 = i8;
                                boolean changedInstance2 = z | startRestartGroup.changedInstance(stroke) | startRestartGroup.changed(animateValue) | startRestartGroup.changed(animateFloat2) | startRestartGroup.changed(animateFloat3) | startRestartGroup.changed(animateFloat) | ((i9 & 896) != 256);
                                if (((i9 & 112) ^ 48) > 32) {
                                }
                                z3 = false;
                                z2 = changedInstance2 | z3;
                                rememberedValue = startRestartGroup.rememberedValue();
                                if (!z2) {
                                }
                                final long j122 = j8;
                                final Stroke stroke32 = stroke;
                                final float f42 = f3;
                                final long j132 = j6;
                                rememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$4$1
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
                                        ProgressIndicatorKt.m2803drawCircularIndicatorTrackbw27NRU(drawScope, j122, stroke32);
                                        ProgressIndicatorKt.m2805drawIndeterminateCircularIndicatorhrjfTZI(drawScope, animateFloat3.getValue().floatValue() + (((animateValue.getValue().floatValue() * 216.0f) % 360.0f) - 90.0f) + animateFloat.getValue().floatValue(), f42, Math.abs(animateFloat2.getValue().floatValue() - animateFloat3.getValue().floatValue()), j132, stroke32);
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue);
                                startRestartGroup.endReplaceableGroup();
                                CanvasKt.Canvas(m1120size3ABfNKs, (Function1) rememberedValue, startRestartGroup, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                i10 = i142;
                                j9 = j6;
                                j4 = j8;
                                modifier2 = modifier3;
                            }
                            z = true;
                            stroke = stroke2;
                            int i1422 = i8;
                            boolean changedInstance22 = z | startRestartGroup.changedInstance(stroke) | startRestartGroup.changed(animateValue) | startRestartGroup.changed(animateFloat2) | startRestartGroup.changed(animateFloat3) | startRestartGroup.changed(animateFloat) | ((i9 & 896) != 256);
                            if (((i9 & 112) ^ 48) > 32) {
                            }
                            z3 = false;
                            z2 = changedInstance22 | z3;
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (!z2) {
                            }
                            final long j1222 = j8;
                            final Stroke stroke322 = stroke;
                            final float f422 = f3;
                            final long j1322 = j6;
                            rememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$4$1
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
                                    ProgressIndicatorKt.m2803drawCircularIndicatorTrackbw27NRU(drawScope, j1222, stroke322);
                                    ProgressIndicatorKt.m2805drawIndeterminateCircularIndicatorhrjfTZI(drawScope, animateFloat3.getValue().floatValue() + (((animateValue.getValue().floatValue() * 216.0f) % 360.0f) - 90.0f) + animateFloat.getValue().floatValue(), f422, Math.abs(animateFloat2.getValue().floatValue() - animateFloat3.getValue().floatValue()), j1322, stroke322);
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue);
                            startRestartGroup.endReplaceableGroup();
                            CanvasKt.Canvas(m1120size3ABfNKs, (Function1) rememberedValue, startRestartGroup, 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            i10 = i1422;
                            j9 = j6;
                            j4 = j8;
                            modifier2 = modifier3;
                        }
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        if ((i3 & 2) != 0) {
                            i4 &= -113;
                        }
                        if ((i3 & 8) != 0) {
                            i4 &= -7169;
                        }
                        companion = modifier2;
                        f3 = f2;
                        i8 = i6;
                        j7 = j4;
                        i7 = i4;
                    }
                    j6 = j3;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ProvidableCompositionLocal localDensity2 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume2 = startRestartGroup.consume(localDensity2);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    Stroke stroke22 = new Stroke(((Density) consume2).toPx-0680j_4(f3), 0.0f, i8, 0, null, 26, null);
                    InfiniteTransition rememberInfiniteTransition2 = InfiniteTransitionKt.rememberInfiniteTransition(null, startRestartGroup, 0, 1);
                    boolean z32 = true;
                    i9 = i7;
                    long j112 = j7;
                    final State<Integer> animateValue2 = InfiniteTransitionKt.animateValue(rememberInfiniteTransition2, 0, 5, VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE), AnimationSpecKt.m282infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(6660, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 12), 16);
                    final State<Float> animateFloat4 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition2, 0.0f, BaseRotationAngle, AnimationSpecKt.m282infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(RotationDuration, 0, EasingKt.getLinearEasing(), 2, null), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                    final State<Float> animateFloat22 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition2, 0.0f, JumpRotationAngle, AnimationSpecKt.m282infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$endAngle$1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((KeyframesSpec.KeyframesSpecConfig<Float>) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                            CubicBezierEasing cubicBezierEasing;
                            keyframesSpecConfig.setDurationMillis(1332);
                            KeyframeBaseEntity mo12at = keyframesSpecConfig.mo12at((Object) Float.valueOf(0.0f), 0);
                            cubicBezierEasing = ProgressIndicatorKt.CircularEasing;
                            keyframesSpecConfig.using(mo12at, cubicBezierEasing);
                            keyframesSpecConfig.mo12at((Object) Float.valueOf(290.0f), 666);
                        }
                    }), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                    final State<Float> animateFloat32 = InfiniteTransitionKt.animateFloat(rememberInfiniteTransition2, 0.0f, JumpRotationAngle, AnimationSpecKt.m282infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$startAngle$1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((KeyframesSpec.KeyframesSpecConfig<Float>) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
                            CubicBezierEasing cubicBezierEasing;
                            keyframesSpecConfig.setDurationMillis(1332);
                            KeyframeBaseEntity mo12at = keyframesSpecConfig.mo12at((Object) Float.valueOf(0.0f), 666);
                            cubicBezierEasing = ProgressIndicatorKt.CircularEasing;
                            keyframesSpecConfig.using(mo12at, cubicBezierEasing);
                            keyframesSpecConfig.mo12at((Object) Float.valueOf(290.0f), keyframesSpecConfig.getDurationMillis());
                        }
                    }), null, 0L, 6, null), null, startRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
                    Modifier m1120size3ABfNKs2 = SizeKt.m1120size3ABfNKs(ProgressSemanticsKt.progressSemantics(companion), CircularIndicatorDiameter);
                    startRestartGroup.startReplaceableGroup(821870113);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
                    if (((i9 & 7168) ^ 3072) <= 2048) {
                    }
                    modifier3 = companion;
                    if ((i9 & 3072) != 2048) {
                    }
                    z = true;
                    stroke = stroke22;
                    int i14222 = i8;
                    boolean changedInstance222 = z | startRestartGroup.changedInstance(stroke) | startRestartGroup.changed(animateValue2) | startRestartGroup.changed(animateFloat22) | startRestartGroup.changed(animateFloat32) | startRestartGroup.changed(animateFloat4) | ((i9 & 896) != 256);
                    if (((i9 & 112) ^ 48) > 32) {
                    }
                    z32 = false;
                    z2 = changedInstance222 | z32;
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!z2) {
                    }
                    final long j12222 = j8;
                    final Stroke stroke3222 = stroke;
                    final float f4222 = f3;
                    final long j13222 = j6;
                    rememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$4$1
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
                            ProgressIndicatorKt.m2803drawCircularIndicatorTrackbw27NRU(drawScope, j12222, stroke3222);
                            ProgressIndicatorKt.m2805drawIndeterminateCircularIndicatorhrjfTZI(drawScope, animateFloat32.getValue().floatValue() + (((animateValue2.getValue().floatValue() * 216.0f) % 360.0f) - 90.0f) + animateFloat4.getValue().floatValue(), f4222, Math.abs(animateFloat22.getValue().floatValue() - animateFloat32.getValue().floatValue()), j13222, stroke3222);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                    startRestartGroup.endReplaceableGroup();
                    CanvasKt.Canvas(m1120size3ABfNKs2, (Function1) rememberedValue, startRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    i10 = i14222;
                    j9 = j6;
                    j4 = j8;
                    modifier2 = modifier3;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    j9 = j3;
                    f3 = f2;
                    i10 = i6;
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier4 = modifier2;
                    final float f5 = f3;
                    final long j14 = j4;
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$5
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
                            ProgressIndicatorKt.m2789CircularProgressIndicatorLxG7B9w(Modifier.this, j9, f5, j14, i10, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                        }
                    });
                    return;
                }
                return;
            }
            i6 = i;
            if ((i4 & 9363) == 9362) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
            }
            if (i12 != 0) {
            }
            if ((i3 & 2) != 0) {
            }
            if (i13 != 0) {
            }
            if ((i3 & 8) != 0) {
            }
            if (i5 != 0) {
            }
        }
        f2 = f;
        if ((i2 & 3072) != 0) {
        }
        i5 = i3 & 16;
        if (i5 == 0) {
        }
        i6 = i;
        if ((i4 & 9363) == 9362) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i12 != 0) {
        }
        if ((i3 & 2) != 0) {
        }
        if (i13 != 0) {
        }
        if ((i3 & 8) != 0) {
        }
        if (i5 != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0067  */
    @Deprecated(message = "Use the overload that takes `progress` as a lambda", replaceWith = @ReplaceWith(expression = "CircularProgressIndicator(\nprogress = { progress },\nmodifier = modifier,\ncolor = color,\nstrokeWidth = strokeWidth,\ntrackColor = trackColor,\nstrokeCap = strokeCap,\n)", imports = {}))
    /* renamed from: CircularProgressIndicator-DUhRLBM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2787CircularProgressIndicatorDUhRLBM(final float f, Modifier modifier, long j, float f2, long j2, int i, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        long j3;
        int i5;
        float f3;
        long j4;
        int i6;
        int i7;
        int m2783getCircularDeterminateStrokeCapKaPHkGw;
        int i8;
        float f4;
        long j5;
        boolean z;
        Object rememberedValue;
        final long j6;
        final int i9;
        final float f5;
        ScopeUpdateScope endRestartGroup;
        int i10;
        int i11;
        Composer startRestartGroup = composer.startRestartGroup(-1472321743);
        ComposerKt.sourceInformation(startRestartGroup, "C(CircularProgressIndicator)P(2,1,0:c#ui.graphics.Color,4:c#ui.unit.Dp,5:c#ui.graphics.Color,3:c#ui.graphics.StrokeCap)487@19401L13,489@19535L18,492@19684L12,491@19642L188:ProgressIndicator.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (startRestartGroup.changed(f) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i12 = i3 & 2;
        if (i12 != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            modifier2 = modifier;
            i4 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i2 & 384) != 0) {
                if ((i3 & 4) == 0) {
                    j3 = j;
                    if (startRestartGroup.changed(j3)) {
                        i11 = Fields.RotationX;
                        i4 |= i11;
                    }
                } else {
                    j3 = j;
                }
                i11 = Fields.SpotShadowColor;
                i4 |= i11;
            } else {
                j3 = j;
            }
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else if ((i2 & 3072) == 0) {
                f3 = f2;
                i4 |= startRestartGroup.changed(f3) ? Fields.CameraDistance : Fields.RotationZ;
                if ((i2 & 24576) == 0) {
                    if ((i3 & 16) == 0) {
                        j4 = j2;
                        if (startRestartGroup.changed(j4)) {
                            i10 = Fields.Clip;
                            i4 |= i10;
                        }
                    } else {
                        j4 = j2;
                    }
                    i10 = Fields.Shape;
                    i4 |= i10;
                } else {
                    j4 = j2;
                }
                i6 = i3 & 32;
                if (i6 != 0) {
                    i4 |= 196608;
                } else if ((196608 & i2) == 0) {
                    i7 = i;
                    i4 |= startRestartGroup.changed(i7) ? Fields.RenderEffect : 65536;
                    if ((i4 & 74899) == 74898 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            if (i12 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i3 & 4) != 0) {
                                j3 = ProgressIndicatorDefaults.INSTANCE.getCircularColor(startRestartGroup, 6);
                                i4 &= -897;
                            }
                            if (i5 != 0) {
                                f3 = ProgressIndicatorDefaults.INSTANCE.m2785getCircularStrokeWidthD9Ej5fM();
                            }
                            if ((i3 & 16) != 0) {
                                j4 = ProgressIndicatorDefaults.INSTANCE.getCircularTrackColor(startRestartGroup, 6);
                                i4 &= -57345;
                            }
                            if (i6 != 0) {
                                m2783getCircularDeterminateStrokeCapKaPHkGw = ProgressIndicatorDefaults.INSTANCE.m2783getCircularDeterminateStrokeCapKaPHkGw();
                                i8 = i4;
                                f4 = f3;
                                j5 = j4;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1472321743, i8, -1, "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:491)");
                                }
                                startRestartGroup.startReplaceableGroup(821871588);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
                                z = (i8 & 14) == 4;
                                rememberedValue = startRestartGroup.rememberedValue();
                                if (!z || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$6$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                        public final Float m2808invoke() {
                                            return Float.valueOf(f);
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                startRestartGroup.endReplaceableGroup();
                                m2788CircularProgressIndicatorDUhRLBM((Function0<Float>) rememberedValue, modifier2, j3, f4, j5, m2783getCircularDeterminateStrokeCapKaPHkGw, startRestartGroup, (i8 & 112) | (i8 & 896) | (i8 & 7168) | (57344 & i8) | (i8 & 458752), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                j4 = j5;
                                j6 = j3;
                                i9 = m2783getCircularDeterminateStrokeCapKaPHkGw;
                                f5 = f4;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i3 & 4) != 0) {
                                i4 &= -897;
                            }
                            if ((i3 & 16) != 0) {
                                i4 &= -57345;
                            }
                        }
                        i8 = i4;
                        f4 = f3;
                        j5 = j4;
                        m2783getCircularDeterminateStrokeCapKaPHkGw = i7;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        startRestartGroup.startReplaceableGroup(821871588);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
                        if ((i8 & 14) == 4) {
                        }
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (!z) {
                        }
                        rememberedValue = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$6$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                            public final Float m2808invoke() {
                                return Float.valueOf(f);
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue);
                        startRestartGroup.endReplaceableGroup();
                        m2788CircularProgressIndicatorDUhRLBM((Function0<Float>) rememberedValue, modifier2, j3, f4, j5, m2783getCircularDeterminateStrokeCapKaPHkGw, startRestartGroup, (i8 & 112) | (i8 & 896) | (i8 & 7168) | (57344 & i8) | (i8 & 458752), 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        j4 = j5;
                        j6 = j3;
                        i9 = m2783getCircularDeterminateStrokeCapKaPHkGw;
                        f5 = f4;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        j6 = j3;
                        f5 = f3;
                        i9 = i7;
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        final Modifier modifier3 = modifier2;
                        final long j7 = j4;
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$7
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i13) {
                                ProgressIndicatorKt.m2787CircularProgressIndicatorDUhRLBM(f, modifier3, j6, f5, j7, i9, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                            }
                        });
                        return;
                    }
                    return;
                }
                i7 = i;
                if ((i4 & 74899) == 74898) {
                }
                startRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                }
                if (i12 != 0) {
                }
                if ((i3 & 4) != 0) {
                }
                if (i5 != 0) {
                }
                if ((i3 & 16) != 0) {
                }
                if (i6 != 0) {
                }
                i8 = i4;
                f4 = f3;
                j5 = j4;
                m2783getCircularDeterminateStrokeCapKaPHkGw = i7;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup.startReplaceableGroup(821871588);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
                if ((i8 & 14) == 4) {
                }
                rememberedValue = startRestartGroup.rememberedValue();
                if (!z) {
                }
                rememberedValue = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$6$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                    public final Float m2808invoke() {
                        return Float.valueOf(f);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
                startRestartGroup.endReplaceableGroup();
                m2788CircularProgressIndicatorDUhRLBM((Function0<Float>) rememberedValue, modifier2, j3, f4, j5, m2783getCircularDeterminateStrokeCapKaPHkGw, startRestartGroup, (i8 & 112) | (i8 & 896) | (i8 & 7168) | (57344 & i8) | (i8 & 458752), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                j4 = j5;
                j6 = j3;
                i9 = m2783getCircularDeterminateStrokeCapKaPHkGw;
                f5 = f4;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            f3 = f2;
            if ((i2 & 24576) == 0) {
            }
            i6 = i3 & 32;
            if (i6 != 0) {
            }
            i7 = i;
            if ((i4 & 74899) == 74898) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
            }
            if (i12 != 0) {
            }
            if ((i3 & 4) != 0) {
            }
            if (i5 != 0) {
            }
            if ((i3 & 16) != 0) {
            }
            if (i6 != 0) {
            }
            i8 = i4;
            f4 = f3;
            j5 = j4;
            m2783getCircularDeterminateStrokeCapKaPHkGw = i7;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceableGroup(821871588);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
            if ((i8 & 14) == 4) {
            }
            rememberedValue = startRestartGroup.rememberedValue();
            if (!z) {
            }
            rememberedValue = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$6$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final Float m2808invoke() {
                    return Float.valueOf(f);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceableGroup();
            m2788CircularProgressIndicatorDUhRLBM((Function0<Float>) rememberedValue, modifier2, j3, f4, j5, m2783getCircularDeterminateStrokeCapKaPHkGw, startRestartGroup, (i8 & 112) | (i8 & 896) | (i8 & 7168) | (57344 & i8) | (i8 & 458752), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            j4 = j5;
            j6 = j3;
            i9 = m2783getCircularDeterminateStrokeCapKaPHkGw;
            f5 = f4;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        if ((i2 & 384) != 0) {
        }
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        f3 = f2;
        if ((i2 & 24576) == 0) {
        }
        i6 = i3 & 32;
        if (i6 != 0) {
        }
        i7 = i;
        if ((i4 & 74899) == 74898) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i12 != 0) {
        }
        if ((i3 & 4) != 0) {
        }
        if (i5 != 0) {
        }
        if ((i3 & 16) != 0) {
        }
        if (i6 != 0) {
        }
        i8 = i4;
        f4 = f3;
        j5 = j4;
        m2783getCircularDeterminateStrokeCapKaPHkGw = i7;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceableGroup(821871588);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ProgressIndicator.kt#9igjgp");
        if ((i8 & 14) == 4) {
        }
        rememberedValue = startRestartGroup.rememberedValue();
        if (!z) {
        }
        rememberedValue = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$6$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Float m2808invoke() {
                return Float.valueOf(f);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceableGroup();
        m2788CircularProgressIndicatorDUhRLBM((Function0<Float>) rememberedValue, modifier2, j3, f4, j5, m2783getCircularDeterminateStrokeCapKaPHkGw, startRestartGroup, (i8 & 112) | (i8 & 896) | (i8 & 7168) | (57344 & i8) | (i8 & 458752), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        j4 = j5;
        j6 = j3;
        i9 = m2783getCircularDeterminateStrokeCapKaPHkGw;
        f5 = f4;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0063  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: CircularProgressIndicator-MBs18nI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m2790CircularProgressIndicatorMBs18nI(final float f, Modifier modifier, long j, float f2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        long j2;
        int i4;
        float f3;
        Modifier.Companion companion;
        final float m2785getCircularStrokeWidthD9Ej5fM;
        long j3;
        ScopeUpdateScope endRestartGroup;
        int i5;
        Composer startRestartGroup = composer.startRestartGroup(402841196);
        ComposerKt.sourceInformation(startRestartGroup, "C(CircularProgressIndicator)P(2,1,0:c#ui.graphics.Color,3:c#ui.unit.Dp)506@20085L13,513@20298L18,508@20172L219:ProgressIndicator.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(f) ? 4 : 2) | i;
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
                    j2 = j;
                    if (startRestartGroup.changed(j2)) {
                        i5 = Fields.RotationX;
                        i3 |= i5;
                    }
                } else {
                    j2 = j;
                }
                i5 = Fields.SpotShadowColor;
                i3 |= i5;
            } else {
                j2 = j;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                f3 = f2;
                i3 |= startRestartGroup.changed(f3) ? Fields.CameraDistance : Fields.RotationZ;
                if ((i3 & 1171) == 1170 || !startRestartGroup.getSkipping()) {
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                        companion = i6 != 0 ? Modifier.INSTANCE : modifier2;
                        if ((i2 & 4) != 0) {
                            j2 = ProgressIndicatorDefaults.INSTANCE.getCircularColor(startRestartGroup, 6);
                            i3 &= -897;
                        }
                        if (i4 != 0) {
                            m2785getCircularStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m2785getCircularStrokeWidthD9Ej5fM();
                            j3 = j2;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(402841196, i3, -1, "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:508)");
                            }
                            m2787CircularProgressIndicatorDUhRLBM(f, companion, j3, m2785getCircularStrokeWidthD9Ej5fM, ProgressIndicatorDefaults.INSTANCE.getCircularTrackColor(startRestartGroup, 6), ProgressIndicatorDefaults.INSTANCE.m2783getCircularDeterminateStrokeCapKaPHkGw(), startRestartGroup, (i3 & 14) | 196608 | (i3 & 112) | (i3 & 896) | (i3 & 7168), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        companion = modifier2;
                    }
                    j3 = j2;
                    m2785getCircularStrokeWidthD9Ej5fM = f3;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    m2787CircularProgressIndicatorDUhRLBM(f, companion, j3, m2785getCircularStrokeWidthD9Ej5fM, ProgressIndicatorDefaults.INSTANCE.getCircularTrackColor(startRestartGroup, 6), ProgressIndicatorDefaults.INSTANCE.m2783getCircularDeterminateStrokeCapKaPHkGw(), startRestartGroup, (i3 & 14) | 196608 | (i3 & 112) | (i3 & 896) | (i3 & 7168), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                } else {
                    startRestartGroup.skipToGroupEnd();
                    companion = modifier2;
                    j3 = j2;
                    m2785getCircularStrokeWidthD9Ej5fM = f3;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier3 = companion;
                    final long j4 = j3;
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$8
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i7) {
                            ProgressIndicatorKt.m2790CircularProgressIndicatorMBs18nI(f, modifier3, j4, m2785getCircularStrokeWidthD9Ej5fM, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                    return;
                }
                return;
            }
            f3 = f2;
            if ((i3 & 1171) == 1170) {
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
            j3 = j2;
            m2785getCircularStrokeWidthD9Ej5fM = f3;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            m2787CircularProgressIndicatorDUhRLBM(f, companion, j3, m2785getCircularStrokeWidthD9Ej5fM, ProgressIndicatorDefaults.INSTANCE.getCircularTrackColor(startRestartGroup, 6), ProgressIndicatorDefaults.INSTANCE.m2783getCircularDeterminateStrokeCapKaPHkGw(), startRestartGroup, (i3 & 14) | 196608 | (i3 & 112) | (i3 & 896) | (i3 & 7168), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
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
        f3 = f2;
        if ((i3 & 1171) == 1170) {
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
        j3 = j2;
        m2785getCircularStrokeWidthD9Ej5fM = f3;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        m2787CircularProgressIndicatorDUhRLBM(f, companion, j3, m2785getCircularStrokeWidthD9Ej5fM, ProgressIndicatorDefaults.INSTANCE.getCircularTrackColor(startRestartGroup, 6), ProgressIndicatorDefaults.INSTANCE.m2783getCircularDeterminateStrokeCapKaPHkGw(), startRestartGroup, (i3 & 14) | 196608 | (i3 & 112) | (i3 & 896) | (i3 & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00a1  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* renamed from: CircularProgressIndicator-aM-cp0Q, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m2791CircularProgressIndicatoraMcp0Q(Modifier modifier, long j, float f, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        long j2;
        float f2;
        Modifier.Companion companion;
        float m2785getCircularStrokeWidthD9Ej5fM;
        long j3;
        ScopeUpdateScope endRestartGroup;
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(947193756);
        ComposerKt.sourceInformation(startRestartGroup, "C(CircularProgressIndicator)P(1,0:c#ui.graphics.Color,2:c#ui.unit.Dp)521@20600L13,527@20799L18,523@20687L207:ProgressIndicator.kt#uh7d8r");
        int i5 = i2 & 1;
        if (i5 != 0) {
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
        int i6 = i2 & 4;
        if (i6 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            f2 = f;
            i3 |= startRestartGroup.changed(f2) ? Fields.RotationX : Fields.SpotShadowColor;
            if ((i3 & 147) == 146 || !startRestartGroup.getSkipping()) {
                startRestartGroup.startDefaults();
                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                    companion = i5 == 0 ? Modifier.INSTANCE : modifier2;
                    if ((i2 & 2) != 0) {
                        j2 = ProgressIndicatorDefaults.INSTANCE.getCircularColor(startRestartGroup, 6);
                        i3 &= -113;
                    }
                    if (i6 != 0) {
                        m2785getCircularStrokeWidthD9Ej5fM = ProgressIndicatorDefaults.INSTANCE.m2785getCircularStrokeWidthD9Ej5fM();
                        long j4 = j2;
                        int i7 = i3;
                        j3 = j4;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(947193756, i7, -1, "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:523)");
                        }
                        m2789CircularProgressIndicatorLxG7B9w(companion, j3, m2785getCircularStrokeWidthD9Ej5fM, ProgressIndicatorDefaults.INSTANCE.getCircularTrackColor(startRestartGroup, 6), ProgressIndicatorDefaults.INSTANCE.m2784getCircularIndeterminateStrokeCapKaPHkGw(), startRestartGroup, (i7 & 14) | 24576 | (i7 & 112) | (i7 & 896), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        f2 = m2785getCircularStrokeWidthD9Ej5fM;
                    }
                } else {
                    startRestartGroup.skipToGroupEnd();
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                    }
                    companion = modifier2;
                }
                m2785getCircularStrokeWidthD9Ej5fM = f2;
                long j42 = j2;
                int i72 = i3;
                j3 = j42;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                m2789CircularProgressIndicatorLxG7B9w(companion, j3, m2785getCircularStrokeWidthD9Ej5fM, ProgressIndicatorDefaults.INSTANCE.getCircularTrackColor(startRestartGroup, 6), ProgressIndicatorDefaults.INSTANCE.m2784getCircularIndeterminateStrokeCapKaPHkGw(), startRestartGroup, (i72 & 14) | 24576 | (i72 & 112) | (i72 & 896), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                f2 = m2785getCircularStrokeWidthD9Ej5fM;
            } else {
                startRestartGroup.skipToGroupEnd();
                companion = modifier2;
                j3 = j2;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                final Modifier modifier3 = companion;
                final long j5 = j3;
                final float f3 = f2;
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$9
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i8) {
                        ProgressIndicatorKt.m2791CircularProgressIndicatoraMcp0Q(Modifier.this, j5, f3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        f2 = f;
        if ((i3 & 147) == 146) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i5 == 0) {
        }
        if ((i2 & 2) != 0) {
        }
        if (i6 != 0) {
        }
        m2785getCircularStrokeWidthD9Ej5fM = f2;
        long j422 = j2;
        int i722 = i3;
        j3 = j422;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        m2789CircularProgressIndicatorLxG7B9w(companion, j3, m2785getCircularStrokeWidthD9Ej5fM, ProgressIndicatorDefaults.INSTANCE.getCircularTrackColor(startRestartGroup, 6), ProgressIndicatorDefaults.INSTANCE.m2784getCircularIndeterminateStrokeCapKaPHkGw(), startRestartGroup, (i722 & 14) | 24576 | (i722 & 112) | (i722 & 896), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        f2 = m2785getCircularStrokeWidthD9Ej5fM;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* renamed from: drawCircularIndicator-42QJj7c, reason: not valid java name */
    private static final void m2802drawCircularIndicator42QJj7c(DrawScope drawScope, float f, float f2, long j, Stroke stroke) {
        float f3 = 2;
        float width = stroke.getWidth() / f3;
        float m4662getWidthimpl = Size.m4662getWidthimpl(drawScope.m5417getSizeNHjbRc()) - (f3 * width);
        DrawScope.m5396drawArcyD3GUKo$default(drawScope, j, f, f2, false, OffsetKt.Offset(width, width), androidx.compose.p002ui.geometry.SizeKt.Size(m4662getWidthimpl, m4662getWidthimpl), 0.0f, stroke, null, 0, 832, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawCircularIndicatorTrack-bw27NRU, reason: not valid java name */
    public static final void m2803drawCircularIndicatorTrackbw27NRU(DrawScope drawScope, long j, Stroke stroke) {
        m2802drawCircularIndicator42QJj7c(drawScope, 0.0f, 360.0f, j, stroke);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawDeterminateCircularIndicator-42QJj7c, reason: not valid java name */
    public static final void m2804drawDeterminateCircularIndicator42QJj7c(DrawScope drawScope, float f, float f2, long j, Stroke stroke) {
        m2802drawCircularIndicator42QJj7c(drawScope, f, f2, j, stroke);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawIndeterminateCircularIndicator-hrjfTZI, reason: not valid java name */
    public static final void m2805drawIndeterminateCircularIndicatorhrjfTZI(DrawScope drawScope, float f, float f2, float f3, long j, Stroke stroke) {
        m2802drawCircularIndicator42QJj7c(drawScope, f + (StrokeCap.m5207equalsimpl0(stroke.getCap(), StrokeCap.INSTANCE.m5211getButtKaPHkGw()) ? 0.0f : ((f2 / Dp.constructor-impl(CircularIndicatorDiameter / 2)) * 57.29578f) / 2.0f), Math.max(f3, 0.1f), j, stroke);
    }

    public static final float getLinearIndicatorWidth() {
        return LinearIndicatorWidth;
    }

    public static final float getLinearIndicatorHeight() {
        return LinearIndicatorHeight;
    }

    public static final float getCircularIndicatorDiameter() {
        return CircularIndicatorDiameter;
    }

    static {
        float f = Dp.constructor-impl(10);
        SemanticsBoundsPadding = f;
        IncreaseSemanticsBounds = PaddingKt.m1066paddingVpY3zN4$default(SemanticsModifierKt.semantics(LayoutModifierKt.layout(Modifier.INSTANCE, new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.material3.ProgressIndicatorKt$IncreaseSemanticsBounds$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return m2810invoke3p2s80s((MeasureScope) obj, (Measurable) obj2, ((Constraints) obj3).unbox-impl());
            }

            /* renamed from: invoke-3p2s80s, reason: not valid java name */
            public final MeasureResult m2810invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
                float f2;
                f2 = ProgressIndicatorKt.SemanticsBoundsPadding;
                final int i = measureScope.roundToPx-0680j_4(f2);
                int i2 = i * 2;
                final Placeable mo6318measureBRTryo0 = measurable.mo6318measureBRTryo0(ConstraintsKt.offset-NN6Ew-U(j, 0, i2));
                return MeasureScope.layout$default(measureScope, mo6318measureBRTryo0.getWidth(), mo6318measureBRTryo0.getHeight() - i2, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$IncreaseSemanticsBounds$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Placeable.PlacementScope) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Placeable.PlacementScope placementScope) {
                        Placeable.PlacementScope.place$default(placementScope, Placeable.this, 0, -i, 0.0f, 4, null);
                    }
                }, 4, null);
            }
        }), true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ProgressIndicatorKt$IncreaseSemanticsBounds$2
            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SemanticsPropertyReceiver) obj);
                return Unit.INSTANCE;
            }
        }), 0.0f, f, 1, null);
        LinearIndicatorWidth = Dp.constructor-impl(240);
        LinearIndicatorHeight = LinearProgressIndicatorTokens.INSTANCE.m3703getTrackHeightD9Ej5fM();
        CircularIndicatorDiameter = Dp.constructor-impl(CircularProgressIndicatorTokens.INSTANCE.m3437getSizeD9Ej5fM() - Dp.constructor-impl(CircularProgressIndicatorTokens.INSTANCE.m3436getActiveIndicatorWidthD9Ej5fM() * 2));
        FirstLineHeadEasing = new CubicBezierEasing(0.2f, 0.0f, 0.8f, 1.0f);
        FirstLineTailEasing = new CubicBezierEasing(0.4f, 0.0f, 1.0f, 1.0f);
        SecondLineHeadEasing = new CubicBezierEasing(0.0f, 0.0f, 0.65f, 1.0f);
        SecondLineTailEasing = new CubicBezierEasing(0.1f, 0.0f, 0.45f, 1.0f);
        CircularEasing = new CubicBezierEasing(0.4f, 0.0f, 0.2f, 1.0f);
    }
}
